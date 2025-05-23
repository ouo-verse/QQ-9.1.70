package com.tencent.mobileqq.activity.photo.aiocomment;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.aiocomment.a;
import com.tencent.mobileqq.data.BaseEmotionPanelBusinessParam;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResMgr;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.PhotoCommentEmotionPanelBusinessParam;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonInfo;
import com.tencent.mobileqq.emoticonview.SystemEmoticonInfo;
import com.tencent.mobileqq.emoticonview.api.IEmoticonMainPanelService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.LargeAreaPatchedButton;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XPanelContainer;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes10.dex */
public class b implements View.OnClickListener, EmoticonCallback, XPanelContainer.g, TextWatcher, a.InterfaceC7188a {
    static IPatchRedirector $redirector_;
    protected RelativeLayout C;
    protected XEditTextEx D;
    protected ImageButton E;
    protected LargeAreaPatchedButton F;
    protected XPanelContainer G;
    protected IEmoticonMainPanel H;
    private long I;
    private String J;
    private int K;
    private boolean L;

    /* renamed from: d, reason: collision with root package name */
    protected Context f184156d;

    /* renamed from: e, reason: collision with root package name */
    protected AppRuntime f184157e;

    /* renamed from: f, reason: collision with root package name */
    protected c f184158f;

    /* renamed from: h, reason: collision with root package name */
    protected com.tencent.mobileqq.activity.photo.aiocomment.a f184159h;

    /* renamed from: i, reason: collision with root package name */
    protected Dialog f184160i;

    /* renamed from: m, reason: collision with root package name */
    protected View f184161m;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a implements DialogInterface.OnDismissListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            }
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface);
                return;
            }
            com.tencent.mobileqq.activity.photo.aiocomment.a aVar = b.this.f184159h;
            if (aVar != null) {
                aVar.a();
            }
            b bVar = b.this;
            c cVar = bVar.f184158f;
            if (cVar != null) {
                cVar.a(bVar.J);
            }
            XEditTextEx xEditTextEx = b.this.D;
            if (xEditTextEx != null) {
                xEditTextEx.setText("");
            }
            XPanelContainer xPanelContainer = b.this.G;
            if (xPanelContainer != null) {
                xPanelContainer.removeAllViews();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.activity.photo.aiocomment.b$b, reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public class ViewOnTouchListenerC7189b implements View.OnTouchListener {
        static IPatchRedirector $redirector_;

        ViewOnTouchListenerC7189b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
            }
            b.this.c();
            b.this.G.setOnTouchListener(null);
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public interface c {
        void a(String str);
    }

    public b(Context context, AppRuntime appRuntime, c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, appRuntime, cVar);
            return;
        }
        this.L = false;
        this.f184156d = context;
        this.f184157e = appRuntime;
        this.f184158f = cVar;
        IEmoticonMainPanel create = ((IEmoticonMainPanelService) appRuntime.getRuntimeService(IEmoticonMainPanelService.class, "all")).newBuilder(this.f184156d, 10017).setPanelBusinessParam(f()).setCallBack(this).setOnlySysAndEmoji(true).create();
        this.H = create;
        create.hideAllTabs();
    }

    private Map<Integer, BaseEmotionPanelBusinessParam> f() {
        HashMap hashMap = new HashMap();
        PhotoCommentEmotionPanelBusinessParam photoCommentEmotionPanelBusinessParam = new PhotoCommentEmotionPanelBusinessParam();
        photoCommentEmotionPanelBusinessParam.showTitleLightColor = true;
        hashMap.put(21, photoCommentEmotionPanelBusinessParam);
        return hashMap;
    }

    private void g(Context context, AppRuntime appRuntime) {
        this.f184161m = View.inflate(context, R.layout.fcj, null);
        ReportDialog reportDialog = new ReportDialog(context, R.style.DialogNoBackground);
        this.f184160i = reportDialog;
        reportDialog.setContentView(this.f184161m);
        this.f184160i.getWindow().setLayout(-1, -1);
        this.f184160i.getWindow().setSoftInputMode(4);
        this.f184160i.getWindow().setWindowAnimations(R.style.f174160rf);
        XPanelContainer xPanelContainer = (XPanelContainer) this.f184161m.findViewById(R.id.root);
        this.G = xPanelContainer;
        xPanelContainer.setOnPanelChangeListener(this);
        ImageButton imageButton = (ImageButton) this.f184161m.findViewById(R.id.a75);
        this.E = imageButton;
        imageButton.setOnClickListener(this);
        LargeAreaPatchedButton largeAreaPatchedButton = (LargeAreaPatchedButton) this.f184161m.findViewById(R.id.u2u);
        this.F = largeAreaPatchedButton;
        largeAreaPatchedButton.setOnClickListener(this);
        this.C = (RelativeLayout) this.f184161m.findViewById(R.id.inputBar);
        XEditTextEx xEditTextEx = (XEditTextEx) this.f184161m.findViewById(R.id.input);
        this.D = xEditTextEx;
        xEditTextEx.setOnClickListener(this);
        this.D.addTextChangedListener(this);
        try {
            this.D.setEditableFactory(QQTextBuilder.EMOTION_INPUT_FACTORY);
        } catch (Exception e16) {
            QLog.e("ImageCommentPopupWindow", 1, "input set error", e16);
        }
        this.G.c(this.D);
    }

    @Override // com.tencent.widget.XPanelContainer.g
    public void E() {
        XPanelContainer xPanelContainer;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
        } else if (this.f184160i != null && (xPanelContainer = this.G) != null && xPanelContainer.m() == 2) {
            this.f184160i.dismiss();
        }
    }

    @Override // com.tencent.widget.XPanelContainer.g
    public View E2(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (View) iPatchRedirector.redirect((short) 18, (Object) this, i3);
        }
        if (QLog.isColorLevel()) {
            QLog.i("ImageCommentPopupWindow", 1, "onCreatePanel panelId is " + i3);
        }
        IEmoticonMainPanel iEmoticonMainPanel = this.H;
        if (iEmoticonMainPanel != null && i3 == 2) {
            return iEmoticonMainPanel.getView();
        }
        return null;
    }

    @Override // com.tencent.widget.XPanelContainer.g
    public boolean T(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Boolean) iPatchRedirector.redirect((short) 20, (Object) this, i3)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.activity.photo.aiocomment.a.InterfaceC7188a
    public void a(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, z16);
            return;
        }
        if (z16) {
            if (!this.L) {
                k(this.J);
                this.L = true;
                return;
            }
            return;
        }
        d();
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) editable);
            return;
        }
        this.J = editable.toString();
        if (this.F == null) {
            QLog.d("ImageCommentPopupWindow", 1, "afterTextChanged err: mCompleteBtn == null");
        } else if (editable.length() == 0) {
            this.F.setVisibility(8);
        } else {
            this.F.setVisibility(0);
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
        }
    }

    protected void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        XPanelContainer xPanelContainer = this.G;
        if (xPanelContainer == null) {
            QLog.d("ImageCommentPopupWindow", 1, "completeInput err");
            return;
        }
        boolean t16 = xPanelContainer.t(false);
        if (QLog.isColorLevel()) {
            QLog.d("ImageCommentPopupWindow", 2, "completeInput result is " + t16 + " currentPannel is " + this.G.m());
        }
        if (!t16 && this.G.m() != 2) {
            this.G.v();
        }
        if (this.f184160i != null) {
            if (QLog.isColorLevel()) {
                QLog.d("ImageCommentPopupWindow", 2, "close comment dialog");
            }
            this.f184160i.dismiss();
        }
    }

    protected void d() {
        XPanelContainer xPanelContainer;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else if (this.f184160i != null && (xPanelContainer = this.G) != null && xPanelContainer.m() == 0) {
            this.f184160i.dismiss();
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
    public void delete() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        }
    }

    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this);
            return;
        }
        XPanelContainer xPanelContainer = this.G;
        if (xPanelContainer != null) {
            xPanelContainer.s();
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
    public void emoticonMall() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
        }
    }

    protected boolean h(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, i3)).booleanValue();
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (i3 == this.K && currentTimeMillis - this.I < 500) {
            return true;
        }
        this.K = i3;
        this.I = currentTimeMillis;
        return false;
    }

    public boolean i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        Dialog dialog = this.f184160i;
        if (dialog != null) {
            return dialog.isShowing();
        }
        return false;
    }

    public void j(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            return;
        }
        g(this.f184156d, this.f184157e);
        RelativeLayout relativeLayout = this.C;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
            this.L = false;
        }
        this.J = str;
        this.f184159h = new com.tencent.mobileqq.activity.photo.aiocomment.a(this.f184161m, this);
        this.f184160i.setOnDismissListener(new a());
        this.f184160i.show();
        this.D.requestFocus();
    }

    protected void k(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
            return;
        }
        RelativeLayout relativeLayout = this.C;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(0);
        }
        XEditTextEx xEditTextEx = this.D;
        if (xEditTextEx != null) {
            xEditTextEx.requestFocus();
            if (str != null) {
                this.D.setText(str);
                this.D.setSelection(str.length());
            }
        }
        ImageButton imageButton = this.E;
        if (imageButton != null) {
            imageButton.setSelected(false);
        }
        XPanelContainer xPanelContainer = this.G;
        if (xPanelContainer != null) {
            xPanelContainer.setOnTouchListener(new ViewOnTouchListenerC7189b());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) view);
        } else {
            int id5 = view.getId();
            if (!h(id5)) {
                this.K = id5;
                if (id5 == R.id.a75) {
                    if (this.E.isSelected()) {
                        this.E.setSelected(false);
                        this.G.N(1);
                    } else {
                        this.E.setSelected(true);
                        this.G.O(2, false);
                    }
                } else if (id5 == R.id.input) {
                    this.E.setSelected(false);
                    this.G.N(1);
                } else if (id5 == R.id.u2u) {
                    c();
                } else if (id5 == R.id.root) {
                    c();
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
    public void onHidePopup(EmoticonInfo emoticonInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) emoticonInfo);
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
    public boolean onLongClick(EmoticonInfo emoticonInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, (Object) emoticonInfo)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.widget.XPanelContainer.g
    public void onPanelChanged(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, Integer.valueOf(i3), Integer.valueOf(i16));
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
    public void onShowPopup(EmoticonInfo emoticonInfo, EmoticonInfo emoticonInfo2, Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, emoticonInfo, emoticonInfo2, drawable);
        }
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
    public void send() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 11)) {
            return;
        }
        iPatchRedirector.redirect((short) 11, (Object) this);
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
    public void setting() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
    public void send(EmoticonInfo emoticonInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) emoticonInfo);
            return;
        }
        XEditTextEx xEditTextEx = this.D;
        if (xEditTextEx != null && emoticonInfo != null) {
            if (emoticonInfo instanceof SystemEmoticonInfo) {
                int selectionStart = xEditTextEx.getSelectionStart();
                int selectionEnd = this.D.getSelectionEnd();
                if (selectionStart < 0 || selectionEnd < 0 || selectionEnd < selectionStart) {
                    return;
                }
                this.D.getEditableText().replace(selectionStart, selectionEnd, TextUtils.getSysEmotcationString(((SystemEmoticonInfo) emoticonInfo).code));
                return;
            }
            if (emoticonInfo instanceof SystemAndEmojiEmoticonInfo) {
                SystemAndEmojiEmoticonInfo systemAndEmojiEmoticonInfo = (SystemAndEmojiEmoticonInfo) emoticonInfo;
                int selectionStart2 = xEditTextEx.getSelectionStart();
                int selectionEnd2 = this.D.getSelectionEnd();
                int i3 = systemAndEmojiEmoticonInfo.emotionType;
                int i16 = systemAndEmojiEmoticonInfo.code;
                if (selectionStart2 >= 0 && selectionEnd2 >= 0 && selectionEnd2 >= selectionStart2) {
                    if (i3 == 2 && i16 == -1) {
                        return;
                    }
                    this.D.getEditableText().replace(selectionStart2, selectionEnd2, i3 == 1 ? TextUtils.getSysEmotcationString(i16) : TextUtils.getEmojiString(i16));
                    this.D.requestFocus();
                }
                systemAndEmojiEmoticonInfo.addToCommonUsed(this.f184157e, (Parcelable) null);
                QQSysAndEmojiResMgr.getInstance().getResImpl(i3).reportEmoClick(i16, 2);
                return;
            }
            return;
        }
        QLog.d("ImageCommentPopupWindow", 1, "send err: mInput == null || info == null");
    }
}
