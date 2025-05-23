package com.tencent.mobileqq.ocr;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.Editable;
import android.text.Layout;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ClickableSpan;
import android.util.Pair;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.ocr.api.impl.PicOcrHandler;
import com.tencent.mobileqq.ocr.d;
import com.tencent.mobileqq.ocr.ui.OCRTextSearchActivity;
import com.tencent.mobileqq.ocr.view.gesture.GestureFrameLayout;
import com.tencent.mobileqq.participle.api.IParticipleApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqfavor.api.IFavoriteOCR;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.o;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.DocsVipInfoManager;
import com.tencent.mobileqq.teamwork.TenDocOCRExportHandler;
import com.tencent.mobileqq.teamwork.api.ITeamWorkDocEditBrowserProxy;
import com.tencent.mobileqq.teamwork.api.ITeamWorkDocsListFragment;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtils;
import com.tencent.mobileqq.teamwork.bn;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.textpreview.BaseMenuUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.OCRBottomTabView;
import com.tencent.mobileqq.widget.ProgressView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.participle.ParticipleBottomMenuView;
import com.tencent.mobileqq.widget.participle.ParticipleView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ScrollView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

/* compiled from: P */
/* loaded from: classes16.dex */
public class OCRResultFragmentNew extends QPublicBaseFragment implements View.OnClickListener, Handler.Callback {
    static IPatchRedirector $redirector_;
    private int C;
    private boolean D;
    ParticipleBottomMenuView E;
    OCRBottomTabView F;
    OCRBottomTabView G;
    private com.tencent.mobileqq.ocr.view.e H;
    private Dialog I;
    private ProgressView J;
    ParticipleView K;
    ViewGroup L;
    View M;
    View N;
    View P;
    EditText Q;
    ViewGroup R;
    ViewGroup S;
    ActionSheet T;
    URLImageView U;
    GestureFrameLayout V;
    FrameLayout W;
    ImageView X;
    TextView Y;
    Runnable Z;

    /* renamed from: a0, reason: collision with root package name */
    private boolean f254511a0;

    /* renamed from: b0, reason: collision with root package name */
    private MqqHandler f254512b0;

    /* renamed from: c0, reason: collision with root package name */
    private String f254513c0;

    /* renamed from: d0, reason: collision with root package name */
    private QBaseActivity f254514d0;

    /* renamed from: e0, reason: collision with root package name */
    private int f254515e0;

    /* renamed from: f0, reason: collision with root package name */
    private int f254516f0;

    /* renamed from: g0, reason: collision with root package name */
    private ScrollView f254517g0;

    /* renamed from: h0, reason: collision with root package name */
    private com.tencent.mobileqq.participle.d f254518h0;

    /* renamed from: i0, reason: collision with root package name */
    private bn f254519i0;

    /* renamed from: j0, reason: collision with root package name */
    private com.tencent.mobileqq.gallery.picocr.a f254520j0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class a implements ActionSheet.OnButtonClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ List f254533d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ d.a f254534e;

        a(List list, d.a aVar) {
            this.f254533d = list;
            this.f254534e = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, OCRResultFragmentNew.this, list, aVar);
            }
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, i3);
                return;
            }
            if (i3 < this.f254533d.size()) {
                String str = (String) this.f254533d.get(i3);
                if (str.equalsIgnoreCase(this.f254534e.f254713a)) {
                    QLog.i("OCRResultFragmentNew", 2, "lanCode equals, return, selectedLan:" + str);
                } else {
                    QQToast.makeText(OCRResultFragmentNew.this.f254514d0, 0, R.string.fob, 0).show();
                    com.tencent.mobileqq.ocr.d.f254705b.d(str);
                    try {
                        if (QLog.isColorLevel()) {
                            QLog.i("OCRResultFragmentNew", 2, "requestOcr lan:" + str + ", ctx:" + com.tencent.mobileqq.ocr.d.f254705b.f());
                        }
                        OCRResultFragmentNew.this.Oh(com.tencent.mobileqq.ocr.d.f254705b);
                    } catch (Exception e16) {
                        e16.printStackTrace();
                    }
                }
            }
            ActionSheet actionSheet = OCRResultFragmentNew.this.T;
            if (actionSheet != null && actionSheet.isShowing()) {
                OCRResultFragmentNew.this.T.dismiss();
            }
            OCRResultFragmentNew.this.T = null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class b extends com.tencent.mobileqq.ocr.view.gesture.control.c {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private boolean f254536d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f254537e;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) OCRResultFragmentNew.this);
            }
        }

        @Override // com.tencent.mobileqq.ocr.view.gesture.control.c, com.tencent.mobileqq.ocr.view.gesture.control.b
        public void b(MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) motionEvent);
                return;
            }
            super.b(motionEvent);
            if (this.f254536d || this.f254537e) {
                com.tencent.mobileqq.ocr.d.n("0X800AC97", 0);
            }
        }

        @Override // com.tencent.mobileqq.ocr.view.gesture.control.b
        public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) scaleGestureDetector);
            } else {
                this.f254536d = true;
            }
        }

        @Override // com.tencent.mobileqq.ocr.view.gesture.control.c, com.tencent.mobileqq.ocr.view.gesture.control.b
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, this, motionEvent, motionEvent2, Float.valueOf(f16), Float.valueOf(f17))).booleanValue();
            }
            this.f254537e = true;
            return super.onScroll(motionEvent, motionEvent2, f16, f17);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class c implements TextWatcher {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) OCRResultFragmentNew.this);
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) editable);
            } else if (editable.toString().trim().length() == 0) {
                OCRResultFragmentNew.this.G.setEnabled(false);
                OCRResultFragmentNew.this.F.setEnabled(false);
            } else {
                OCRResultFragmentNew.this.G.setEnabled(true);
                OCRResultFragmentNew.this.F.setEnabled(true);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class d implements ActionMode.Callback {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ EditText f254540a;

        d(EditText editText) {
            this.f254540a = editText;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) OCRResultFragmentNew.this, (Object) editText);
            }
        }

        @Override // android.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) actionMode, (Object) menuItem)).booleanValue();
            }
            if (menuItem.getItemId() != R.id.fcl) {
                return false;
            }
            String b16 = com.tencent.mobileqq.ocr.d.b(this.f254540a);
            if (TextUtils.isEmpty(b16)) {
                QQToast.makeText(OCRResultFragmentNew.this.f254514d0, 1, HardCodeUtil.qqStr(R.string.oxt), 0).show();
                return false;
            }
            OCRTextSearchActivity.Q2(OCRResultFragmentNew.this.f254514d0, b16);
            OCRResultFragmentNew.this.f254514d0.overridePendingTransition(R.anim.activity_new, 0);
            return true;
        }

        @Override // android.view.ActionMode.Callback
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) actionMode, (Object) menu)).booleanValue();
            }
            MenuInflater menuInflater = actionMode.getMenuInflater();
            if (menuInflater != null) {
                menuInflater.inflate(R.menu.f169217g, menu);
                return true;
            }
            return true;
        }

        @Override // android.view.ActionMode.Callback
        public void onDestroyActionMode(ActionMode actionMode) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) actionMode);
            }
        }

        @Override // android.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) actionMode, (Object) menu)).booleanValue();
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class e implements ViewTreeObserver.OnGlobalLayoutListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ EditText f254542d;

        e(EditText editText) {
            this.f254542d = editText;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) OCRResultFragmentNew.this, (Object) editText);
            }
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            OCRResultFragmentNew.this.f254514d0.findViewById(R.id.ckj).setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            Rect rect = new Rect();
            OCRResultFragmentNew.this.M.getWindowVisibleDisplayFrame(rect);
            int height = OCRResultFragmentNew.this.M.getRootView().getHeight();
            int i3 = height - rect.bottom;
            if (i3 != OCRResultFragmentNew.this.f254515e0) {
                OCRResultFragmentNew.this.f254515e0 = i3;
                OCRResultFragmentNew.this.Mh();
                double d16 = i3;
                double d17 = height * 0.15d;
                boolean z16 = true;
                if (d16 > d17) {
                    OCRResultFragmentNew.this.S.setVisibility(8);
                    try {
                        Editable text = this.f254542d.getText();
                        ClickableSpan[] clickableSpanArr = (ClickableSpan[]) text.getSpans(0, text.length(), ClickableSpan.class);
                        if (clickableSpanArr != null && clickableSpanArr.length > 0) {
                            for (ClickableSpan clickableSpan : clickableSpanArr) {
                                text.removeSpan(clickableSpan);
                            }
                        }
                        QLog.i("OCRResultFragmentNew", 1, "mTouchActionDownY=" + OCRResultFragmentNew.this.f254516f0 + "r.bottom=" + rect.bottom);
                        if (OCRResultFragmentNew.this.f254516f0 > rect.bottom) {
                            OCRResultFragmentNew.this.f254517g0.scrollBy(0, OCRResultFragmentNew.this.f254516f0 - rect.bottom);
                        }
                    } catch (Exception e16) {
                        EditText editText = this.f254542d;
                        editText.setText(OCRResultFragmentNew.this.Gh(editText.getText(), true));
                        e16.printStackTrace();
                    }
                } else {
                    OCRResultFragmentNew.this.getMainHandler().postDelayed(OCRResultFragmentNew.this.Z, 100L);
                    z81.e.c(OCRResultFragmentNew.this.f254514d0, OCRResultFragmentNew.this.S, false, 0);
                    if (this.f254542d.hasSelection()) {
                        this.f254542d.clearFocus();
                    }
                    EditText editText2 = this.f254542d;
                    editText2.setText(OCRResultFragmentNew.this.Gh(editText2.getText(), true));
                }
                if (QLog.isColorLevel()) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("OnGlobalLayoutListener showKeyboard:");
                    if (d16 <= d17) {
                        z16 = false;
                    }
                    sb5.append(z16);
                    QLog.d("OCRResultFragmentNew", 2, sb5.toString());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class f implements View.OnTouchListener {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) OCRResultFragmentNew.this);
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
            }
            EditText editText = (EditText) view;
            int action = motionEvent.getAction();
            boolean z16 = false;
            if (action == 0) {
                OCRResultFragmentNew.this.f254516f0 = (int) motionEvent.getRawY();
            } else if (action == 1) {
                Editable text = editText.getText();
                int x16 = (int) motionEvent.getX();
                int y16 = (int) motionEvent.getY();
                int totalPaddingLeft = x16 - editText.getTotalPaddingLeft();
                int totalPaddingTop = y16 - editText.getTotalPaddingTop();
                int scrollX = totalPaddingLeft + editText.getScrollX();
                int scrollY = totalPaddingTop + editText.getScrollY();
                Layout layout = editText.getLayout();
                int lineForVertical = layout.getLineForVertical(scrollY);
                float f16 = scrollX;
                if (f16 <= layout.getLineWidth(lineForVertical)) {
                    int offsetForHorizontal = layout.getOffsetForHorizontal(lineForVertical, f16);
                    ClickableSpan[] clickableSpanArr = (ClickableSpan[]) text.getSpans(offsetForHorizontal, offsetForHorizontal, ClickableSpan.class);
                    if (clickableSpanArr.length != 0) {
                        clickableSpanArr[0].onClick(editText);
                        ReportController.o(null, "dc00898", "", "", "0X80082E3", "0X80082E3", 0, 0, "", "", "", "");
                        z16 = true;
                    }
                }
            }
            if (z16) {
                return true;
            }
            if (action == 1 && !editText.isFocused()) {
                ReportController.o(null, "dc00898", "", "", "0X80082E2", "0X80082E2", 0, 0, "", "", "", "");
            }
            return editText.onTouchEvent(motionEvent);
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class g extends com.tencent.mobileqq.participle.d {
        static IPatchRedirector $redirector_;

        g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) OCRResultFragmentNew.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.participle.d
        public void a(boolean z16, List<String> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), list);
                return;
            }
            super.a(z16, list);
            if (OCRResultFragmentNew.this.I != null) {
                OCRResultFragmentNew.this.I.setOnCancelListener(null);
                OCRResultFragmentNew.this.I.dismiss();
            }
            if (z16 && list != null && list.size() > 0) {
                OCRResultFragmentNew.this.K.setParticipleItems(list);
                OCRResultFragmentNew.this.K.R();
                OCRResultFragmentNew.this.Th(2);
                return;
            }
            QQToast.makeText(OCRResultFragmentNew.this.f254514d0, 1, HardCodeUtil.qqStr(R.string.oxz), 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class h implements ParticipleBottomMenuView.c {
        static IPatchRedirector $redirector_;

        h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) OCRResultFragmentNew.this);
            }
        }

        @Override // com.tencent.mobileqq.widget.participle.ParticipleBottomMenuView.c
        public void a(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            } else {
                BaseMenuUtil.copy(str, "OCR_Participle_copy");
            }
        }

        @Override // com.tencent.mobileqq.widget.participle.ParticipleBottomMenuView.c
        public void b(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            } else {
                com.tencent.mobileqq.ocr.d.i(OCRResultFragmentNew.this.f254514d0, str);
            }
        }

        @Override // com.tencent.mobileqq.widget.participle.ParticipleBottomMenuView.c
        public void c(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
            } else {
                TranslateFragment.Gh(OCRResultFragmentNew.this.f254514d0, str);
            }
        }

        @Override // com.tencent.mobileqq.widget.participle.ParticipleBottomMenuView.c
        public void d(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            } else {
                ((IFavoriteOCR) QRoute.api(IFavoriteOCR.class)).favorite(OCRResultFragmentNew.this.f254514d0, str);
            }
        }

        @Override // com.tencent.mobileqq.widget.participle.ParticipleBottomMenuView.c
        public void onCancelClick() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
                OCRResultFragmentNew.this.Th(0);
            } else {
                iPatchRedirector.redirect((short) 6, (Object) this);
            }
        }
    }

    public OCRResultFragmentNew() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.C = -1;
        this.D = false;
        this.Z = new Runnable() { // from class: com.tencent.mobileqq.ocr.OCRResultFragmentNew.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) OCRResultFragmentNew.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                ViewGroup viewGroup = OCRResultFragmentNew.this.S;
                if (viewGroup != null) {
                    viewGroup.setVisibility(0);
                }
            }
        };
        this.f254515e0 = -1;
        this.f254516f0 = 0;
        this.f254518h0 = new g();
        this.f254519i0 = new bn(this.f254514d0) { // from class: com.tencent.mobileqq.ocr.OCRResultFragmentNew.8
            static IPatchRedirector $redirector_;

            {
                super(r5);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) OCRResultFragmentNew.this, (Object) r5);
                }
            }

            @Override // com.tencent.mobileqq.teamwork.bn
            public void a(boolean z16, String str) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    iPatchRedirector2.redirect((short) 3, this, Boolean.valueOf(z16), str);
                } else {
                    OCRResultFragmentNew.this.f254512b0.post(new Runnable(str) { // from class: com.tencent.mobileqq.ocr.OCRResultFragmentNew.8.2
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ String f254527d;

                        {
                            this.f254527d = str;
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass8.this, (Object) str);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                                return;
                            }
                            try {
                                OCRResultFragmentNew.this.H.dismiss();
                                OCRResultFragmentNew.this.H.setProgress(0);
                                OCRResultFragmentNew.this.f254511a0 = false;
                                QQToast.makeText(OCRResultFragmentNew.this.f254514d0, 2, HardCodeUtil.qqStr(R.string.oxx), 1).show();
                                String str2 = this.f254527d;
                                if (str2 != null && str2.length() > 0) {
                                    OCRResultFragmentNew.this.Hh(this.f254527d);
                                } else {
                                    QQToast.makeText(OCRResultFragmentNew.this.f254514d0, 1, HardCodeUtil.qqStr(R.string.oxr), 0).show();
                                }
                            } catch (Exception e16) {
                                e16.printStackTrace();
                            }
                        }
                    });
                }
            }

            @Override // com.tencent.mobileqq.teamwork.bn
            public void b(String str, String str2, int i3) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                    iPatchRedirector2.redirect((short) 4, this, str, str2, Integer.valueOf(i3));
                } else {
                    OCRResultFragmentNew.this.f254512b0.post(new Runnable(i3) { // from class: com.tencent.mobileqq.ocr.OCRResultFragmentNew.8.3
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ int f254529d;

                        {
                            this.f254529d = i3;
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass8.this, i3);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 == null || !iPatchRedirector3.hasPatch((short) 2)) {
                                OCRResultFragmentNew.this.f254511a0 = false;
                                OCRResultFragmentNew.this.H.dismiss();
                                OCRResultFragmentNew.this.H.setProgress(0);
                                QQToast.makeText(OCRResultFragmentNew.this.f254514d0, 1, HardCodeUtil.qqStr(R.string.oxu), 0).show();
                                if (this.f254529d == 20010) {
                                    DocsVipInfoManager.c().h(OCRResultFragmentNew.this.f254514d0, "qqscan");
                                    return;
                                }
                                return;
                            }
                            iPatchRedirector3.redirect((short) 2, (Object) this);
                        }
                    });
                }
            }

            @Override // com.tencent.mobileqq.teamwork.bn
            public void c(int i3) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 5)) {
                    iPatchRedirector2.redirect((short) 5, (Object) this, i3);
                } else {
                    OCRResultFragmentNew.this.f254512b0.post(new Runnable(i3) { // from class: com.tencent.mobileqq.ocr.OCRResultFragmentNew.8.4
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ int f254531d;

                        {
                            this.f254531d = i3;
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass8.this, i3);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 == null || !iPatchRedirector3.hasPatch((short) 2)) {
                                OCRResultFragmentNew.this.f254511a0 = true;
                                OCRResultFragmentNew.this.H.setProgress(this.f254531d);
                            } else {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                            }
                        }
                    });
                }
            }

            @Override // com.tencent.mobileqq.teamwork.bn
            public void d() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    OCRResultFragmentNew.this.f254512b0.post(new Runnable() { // from class: com.tencent.mobileqq.ocr.OCRResultFragmentNew.8.1
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass8.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                                return;
                            }
                            OCRResultFragmentNew.this.H.show();
                            OCRResultFragmentNew.this.H.setProgress(0);
                            OCRResultFragmentNew.this.f254511a0 = true;
                        }
                    });
                }
            }
        };
        this.f254520j0 = new com.tencent.mobileqq.gallery.picocr.a() { // from class: com.tencent.mobileqq.ocr.OCRResultFragmentNew.11
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) OCRResultFragmentNew.this);
                }
            }

            @Override // com.tencent.mobileqq.gallery.picocr.a
            protected void a(boolean z16, com.tencent.mobileqq.gallery.picocr.c cVar) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, Boolean.valueOf(z16), cVar);
                } else if (OCRResultFragmentNew.this.D) {
                    OCRResultFragmentNew.this.D = false;
                    OCRResultFragmentNew.this.f254514d0.runOnUiThread(new Runnable(z16, cVar) { // from class: com.tencent.mobileqq.ocr.OCRResultFragmentNew.11.1
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ boolean f254522d;

                        /* renamed from: e, reason: collision with root package name */
                        final /* synthetic */ com.tencent.mobileqq.gallery.picocr.c f254523e;

                        {
                            this.f254522d = z16;
                            this.f254523e = cVar;
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, this, AnonymousClass11.this, Boolean.valueOf(z16), cVar);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            ArrayList<com.tencent.mobileqq.gallery.picocr.b> arrayList;
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                                return;
                            }
                            if (this.f254522d && (arrayList = this.f254523e.f211819f) != null && !arrayList.isEmpty()) {
                                com.tencent.mobileqq.ocr.d.f254709f = com.tencent.mobileqq.ocr.d.r(this.f254523e.f211819f);
                                d.a aVar = com.tencent.mobileqq.ocr.d.f254707d;
                                String str = com.tencent.mobileqq.ocr.d.f254705b.f254765a;
                                com.tencent.mobileqq.gallery.picocr.c cVar2 = this.f254523e;
                                com.tencent.mobileqq.ocr.d.f254707d = com.tencent.mobileqq.ocr.d.l(aVar, str, cVar2.f211820g, cVar2.f211821h);
                                OCRResultFragmentNew.this.Th(0);
                                return;
                            }
                            QQToast.makeText(OCRResultFragmentNew.this.f254514d0, 1, R.string.fo_, 0).show();
                            com.tencent.mobileqq.ocr.d.n("0X800AD1B", 0);
                        }
                    });
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CharSequence Gh(CharSequence charSequence, boolean z16) {
        if (z16) {
            return new QQText(charSequence, 8, 16);
        }
        return String.valueOf(charSequence);
    }

    private void Ih(QBaseActivity qBaseActivity) {
        if (qBaseActivity != null) {
            ((InputMethodManager) qBaseActivity.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).hideSoftInputFromWindow(this.Q.getWindowToken(), 0);
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void Jh(EditText editText) {
        editText.setLinkTextColor(Color.parseColor("#12B7F5"));
        if (AppSetting.f99565y) {
            editText.setAutoLinkMask(7);
        } else {
            editText.setAutoLinkMask(0);
        }
        editText.addTextChangedListener(new c());
        if (com.tencent.mobileqq.ocr.b.a()) {
            editText.setCustomSelectionActionModeCallback(new d(editText));
        }
        this.M.getViewTreeObserver().addOnGlobalLayoutListener(new e(editText));
        editText.setOnTouchListener(new f());
    }

    private void Kh() {
        this.E.setOnMenuClickListener(new h());
        this.E.b(this.K);
    }

    private void Lh(String str) {
        if (!NetworkUtil.isNetSupport(this.f254514d0)) {
            QQToast.makeText(this.f254514d0, HardCodeUtil.qqStr(R.string.oxw), 0).show(getResources().getDimensionPixelSize(R.dimen.title_bar_height));
            return;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Ph();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            ((IParticipleApi) QRoute.api(IParticipleApi.class)).participleTheContent((AppInterface) peekAppRuntime, str);
        }
        if (peekAppRuntime != null) {
            ReportController.o(peekAppRuntime, "dc00898", "", "", "0X800A357", "0X800A357", 2, 0, "", "", "", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Mh() {
        getMainHandler().removeCallbacks(this.Z);
    }

    private void Nh(String str) {
        if (!NetworkUtil.isNetworkAvailable(this.f254514d0)) {
            QLog.d("OCRResultFragmentNew", 1, "requestExport2Doc, network error");
            QQToast.makeText(this.f254514d0, 1, R.string.b3j, 0).show();
            return;
        }
        if (!FileUtils.fileExists(str)) {
            QLog.d("OCRResultFragmentNew", 1, "requestExport2Doc, file not exist, picPath:" + str);
            QQToast.makeText(this.f254514d0, 1, R.string.fo9, 0).show();
            return;
        }
        if (this.f254511a0) {
            QLog.d("OCRResultFragmentNew", 1, "requestExport2Doc, in export request, " + str);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("OCRResultFragmentNew", 2, String.format("requestExport2Doc: %s", this.f254513c0));
        }
        this.f254511a0 = true;
        this.f254513c0 = str;
        ((TenDocOCRExportHandler) ((AppInterface) MobileQQ.sMobileQQ.waitAppRuntime(null)).getBusinessHandler(TenDocOCRExportHandler.f291571e)).E2(this.f254513c0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Oh(com.tencent.mobileqq.ocr.req.a aVar) {
        if (!FileUtils.fileExists(aVar.f254767c)) {
            QLog.d("OCRResultFragmentNew", 1, "requestOcr, file not exist, picPath:" + aVar.f254767c);
            QQToast.makeText(this.f254514d0, 1, R.string.fo9, 0).show();
            return;
        }
        if (this.D) {
            QQToast.makeText(this.f254514d0, 0, R.string.fob, 0).show();
            QLog.d("OCRResultFragmentNew", 1, "requestOcr, in ocr request, " + aVar.f254767c);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("OCRResultFragmentNew", 2, "requestOcr:" + aVar.f254767c);
        }
        this.D = true;
        PicOcrHandler picOcrHandler = (PicOcrHandler) ((AppInterface) MobileQQ.sMobileQQ.waitAppRuntime(null)).getBusinessHandler(PicOcrHandler.f254691d);
        if (picOcrHandler != null) {
            picOcrHandler.E2(com.tencent.mobileqq.ocr.d.f254705b);
        }
    }

    private void Ph() {
        Dialog dialog = this.I;
        if (dialog == null) {
            this.J = new ProgressView(this.f254514d0);
            ReportDialog reportDialog = new ReportDialog(this.f254514d0);
            this.I = reportDialog;
            if (reportDialog.getWindow() != null) {
                this.I.getWindow().setBackgroundDrawable(new ColorDrawable(0));
            }
            this.I.setCanceledOnTouchOutside(false);
            this.I.requestWindowFeature(1);
            this.I.setContentView(this.J);
            this.I.setOnCancelListener(new com.tencent.mobileqq.f(this.f254514d0));
        } else {
            dialog.dismiss();
        }
        this.J.setProgressText(HardCodeUtil.qqStr(R.string.oxy));
        this.I.show();
    }

    private void Qh(d.a aVar) {
        if (aVar != null && !aVar.f254714b.isEmpty()) {
            ActionSheet create = ActionSheet.create(this.f254514d0);
            this.T = create;
            create.setMainTitle(R.string.foe);
            ArrayList arrayList = new ArrayList(aVar.f254714b.size());
            Iterator<String> it = aVar.f254714b.iterator();
            while (it.hasNext()) {
                Pair<String, String> a16 = aVar.a(it.next());
                if (a16 != null) {
                    this.T.addRadioButton((CharSequence) a16.second, ((String) a16.first).equalsIgnoreCase(aVar.f254713a));
                    arrayList.add((String) a16.first);
                }
            }
            this.T.addCancelButton(R.string.cancel);
            this.T.setOnButtonClickListener(new a(arrayList, aVar));
            try {
                this.T.show();
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Th(int i3) {
        this.C = i3;
        if (i3 == 0) {
            this.N.setVisibility(0);
            this.M.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.f157825a21)));
            this.L.setVisibility(0);
            this.Q.setVisibility(0);
            this.R.setVisibility(0);
            this.Q.setText(Gh(com.tencent.mobileqq.ocr.d.f254709f, true));
            this.E.setVisibility(8);
            this.K.setVisibility(8);
            this.G.setTabImage(getResources().getDrawable(R.drawable.qui_translate_icon_allwhite_primary));
            this.G.setTabText(getResources().getString(R.string.qyf));
            Ih(this.f254514d0);
            z81.e.c(this.f254514d0, this.S, false, 0);
        }
        if (i3 == 2) {
            Ih(this.f254514d0);
            Fh();
            this.L.setVisibility(8);
            this.Q.setVisibility(8);
            this.R.setVisibility(8);
            this.N.setVisibility(8);
            this.K.setVisibility(0);
            this.E.a();
            this.M.setBackgroundDrawable(getResources().getDrawable(R.drawable.f160251e7));
            z81.e.c(this.f254514d0, this.S, false, 0);
        }
    }

    protected void Hh(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) str);
            return;
        }
        try {
            ActivityURIRequest activityURIRequest = new ActivityURIRequest(this.f254514d0, RouterConstants.UI_ROUTE_BROWSER);
            if (TextUtils.isEmpty(str)) {
                str = "https://docs.qq.com/desktop/m/index.html?_from=1";
            }
            String tencentDocSourceAdtagStrUrl = ((ITeamWorkUtils) QRoute.api(ITeamWorkUtils.class)).getTencentDocSourceAdtagStrUrl(str, ITeamWorkUtils.TD_SOURCE_QQ_OCR_SAVE);
            activityURIRequest.extra().putString(ITeamWorkUtils.TD_SOURCE_QQ_ADTAG, ITeamWorkUtils.TD_SOURCE_QQ_OCR_SAVE);
            activityURIRequest.extra().putString("big_brother_source_key", "biz_src_jc_file");
            activityURIRequest.extra().putString("fragment_class", ((ITeamWorkDocsListFragment) QRoute.api(ITeamWorkDocsListFragment.class)).getCanonicalName());
            if (!((ITeamWorkDocEditBrowserProxy) QRoute.api(ITeamWorkDocEditBrowserProxy.class)).openDocsMiniApp(this.f254514d0, tencentDocSourceAdtagStrUrl, activityURIRequest.extra().getString(ITeamWorkUtils.TD_SOURCE_QQ_ADTAG))) {
                activityURIRequest.extra().putString("url", tencentDocSourceAdtagStrUrl);
                QRoute.startUri(activityURIRequest, (o) null);
            }
        } catch (Exception e16) {
            QLog.i("OCRResultFragmentNew", 1, e16.toString());
        }
    }

    public CharSequence Rh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (CharSequence) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        if (this.C == 0) {
            return com.tencent.mobileqq.ocr.d.b(this.Q);
        }
        return "";
    }

    public CharSequence Sh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (CharSequence) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        if (this.C == 0) {
            EditText editText = this.Q;
            if (editText == null) {
                return com.tencent.mobileqq.ocr.d.f254708e;
            }
            return editText.getText();
        }
        return "";
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this, (Object) message)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public void initWindowStyleAndAnimation(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) activity);
            return;
        }
        activity.overridePendingTransition(R.anim.f154424l, R.anim.f154422j);
        activity.getWindow().getDecorView().setSystemUiVisibility(1);
        activity.getWindow().setSoftInputMode(16);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needStatusTrans() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        super.onActivityResult(i3, i16, intent);
        if (QLog.isColorLevel()) {
            QLog.d("OCRResultFragmentNew", 2, "doOnActivityResult:OCRResultFragmentNew");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity);
        } else {
            super.onAttach(activity);
            this.f254514d0 = (QBaseActivity) activity;
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        Ih(this.f254514d0);
        if (this.C == 2) {
            Th(0);
            return true;
        }
        this.f254514d0.finish();
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) view);
        } else {
            int id5 = view.getId();
            if (id5 == R.id.cju) {
                CharSequence Rh = Rh();
                if (TextUtils.isEmpty(Rh)) {
                    com.tencent.mobileqq.ocr.d.i(this.f254514d0, Sh().toString());
                } else {
                    com.tencent.mobileqq.ocr.d.i(this.f254514d0, Rh.toString());
                }
                com.tencent.mobileqq.ocr.d.n("0X8009C84", 0);
            } else if (id5 == R.id.jvi) {
                CharSequence Rh2 = Rh();
                if (TextUtils.isEmpty(Rh2)) {
                    TranslateFragment.Gh(this.f254514d0, String.valueOf(Sh()));
                } else {
                    TranslateFragment.Gh(this.f254514d0, String.valueOf(Rh2));
                }
                com.tencent.mobileqq.ocr.d.n("0X800AAF2", 0);
            } else if (id5 == R.id.f164918dv4) {
                CharSequence Rh3 = Rh();
                if (TextUtils.isEmpty(Rh3)) {
                    BaseMenuUtil.copy(Sh().toString(), "OCRResultFragmentNew");
                } else {
                    BaseMenuUtil.copy(Rh3.toString(), "OCRResultFragmentNew");
                }
                com.tencent.mobileqq.ocr.d.n("0X800AAF1", 0);
            } else if (id5 == R.id.lyu) {
                CharSequence Rh4 = Rh();
                if (TextUtils.isEmpty(Rh4)) {
                    Lh(String.valueOf(Sh()));
                } else {
                    Lh(String.valueOf(Rh4));
                }
                com.tencent.mobileqq.ocr.d.n("0X800A357", 2);
            } else if (id5 == R.id.lgl) {
                com.tencent.mobileqq.ocr.d.n("0X800A161", 0);
                Nh(this.f254513c0);
            } else if (id5 == R.id.fck) {
                Qh(com.tencent.mobileqq.ocr.d.f254707d);
            } else if (id5 == R.id.a47) {
                onBackEvent();
            } else if (id5 == R.id.fch) {
                FrameLayout frameLayout = this.W;
                if (frameLayout != null && frameLayout.getVisibility() == 0) {
                    this.W.setVisibility(8);
                    com.tencent.mobileqq.ocr.d.n("0X800AC96", 0);
                }
            } else if (id5 == R.id.zw4) {
                if (this.f254513c0 != null && this.W != null) {
                    Ih(this.f254514d0);
                    this.W.setVisibility(0);
                }
                com.tencent.mobileqq.ocr.d.n("0X800AC95", 0);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) bundle);
            return;
        }
        super.onCreate(bundle);
        this.f254513c0 = getActivity().getIntent().getStringExtra("param_ocr_path");
        this.f254512b0 = new MqqHandler(Looper.getMainLooper(), this);
        this.H = new com.tencent.mobileqq.ocr.view.e(this.f254514d0);
        this.f254514d0.addObserver(this.f254518h0);
        this.f254514d0.addObserver(this.f254519i0);
        this.f254514d0.addObserver(this.f254520j0);
        com.tencent.mobileqq.ocr.d.n("0X800AD1A", 0);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            inflate = (View) iPatchRedirector.redirect((short) 4, this, layoutInflater, viewGroup, bundle);
        } else {
            int i16 = 0;
            inflate = layoutInflater.inflate(R.layout.b2c, viewGroup, false);
            this.M = inflate.findViewById(R.id.root);
            this.N = inflate.findViewById(R.id.jqb);
            this.L = (ViewGroup) inflate.findViewById(R.id.fcp);
            this.Q = (EditText) inflate.findViewById(R.id.fcm);
            this.R = (ViewGroup) inflate.findViewById(R.id.adk);
            this.S = (ViewGroup) inflate.findViewById(R.id.lag);
            this.K = (ParticipleView) inflate.findViewById(R.id.m0t);
            this.E = (ParticipleBottomMenuView) inflate.findViewById(R.id.lyt);
            this.G = (OCRBottomTabView) inflate.findViewById(R.id.jvi);
            this.F = (OCRBottomTabView) inflate.findViewById(R.id.lgl);
            this.P = inflate.findViewById(R.id.fck);
            this.f254517g0 = (ScrollView) inflate.findViewById(R.id.b_7);
            OCRBottomTabView oCRBottomTabView = (OCRBottomTabView) inflate.findViewById(R.id.lyu);
            ie0.a f16 = ie0.a.f();
            this.F.setTabImage(f16.o(this.f254514d0, R.drawable.qui_qqdocs, R.color.qui_common_icon_allwhite_primary, 1002));
            oCRBottomTabView.setTabImage(f16.o(this.f254514d0, R.drawable.qui_edit_plus, R.color.qui_common_icon_allwhite_primary, 1002));
            oCRBottomTabView.setOnClickListener(this);
            inflate.findViewById(R.id.cju).setOnClickListener(this);
            inflate.findViewById(R.id.f164918dv4).setOnClickListener(this);
            inflate.findViewById(R.id.a47).setOnClickListener(this);
            Jh(this.Q);
            Kh();
            View view = this.P;
            if (com.tencent.mobileqq.ocr.d.f254704a) {
                i3 = 8;
            } else {
                i3 = 0;
            }
            view.setVisibility(i3);
            this.P.setOnClickListener(this);
            this.G.setOnClickListener(this);
            this.F.setOnClickListener(this);
            GestureFrameLayout gestureFrameLayout = (GestureFrameLayout) inflate.findViewById(R.id.vgz);
            this.V = gestureFrameLayout;
            gestureFrameLayout.e().R(new b());
            this.U = (URLImageView) inflate.findViewById(R.id.u8f);
            this.W = (FrameLayout) inflate.findViewById(R.id.vgy);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.fch);
            this.X = imageView;
            imageView.setOnClickListener(this);
            if (this.f254513c0 != null) {
                this.U.setImageDrawable(URLDrawable.getFileDrawable(this.f254513c0, com.tencent.mobileqq.ocr.d.k(this.U, getResources().getDrawable(R.drawable.trans))));
            }
            TextView textView = (TextView) inflate.findViewById(R.id.zw4);
            this.Y = textView;
            textView.setOnClickListener(this);
            Th(0);
            Ih(this.f254514d0);
            boolean equals = "1103".equals(ThemeUtil.getCurrentThemeInfo().getString("themeId"));
            View findViewById = inflate.findViewById(R.id.f166448zw1);
            if (!equals) {
                i16 = 8;
            }
            findViewById.setVisibility(i16);
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        super.onDestroy();
        this.f254514d0.removeObserver(this.f254518h0);
        this.f254514d0.removeObserver(this.f254519i0);
        this.f254514d0.removeObserver(this.f254520j0);
        Dialog dialog = this.I;
        if (dialog != null) {
            dialog.setOnCancelListener(null);
            this.I.dismiss();
        }
    }

    private void Fh() {
    }
}
