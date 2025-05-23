package com.tencent.mobileqq.forward.dialog;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResMgr;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonInfo;
import com.tencent.mobileqq.emoticonview.SystemEmoticonInfo;
import com.tencent.mobileqq.emoticonview.api.ICommonPanelInteractionView;
import com.tencent.mobileqq.emoticonview.api.IEmoticonMainPanelService;
import com.tencent.mobileqq.emoticonview.api.impl.CommonPanelInteractionListener;
import com.tencent.mobileqq.forward.preview.ForwardPreViewForShareDialog;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.SimpleModeHelper;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.cw;
import com.tencent.mobileqq.utils.eg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.InputMethodUtil;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.ref.WeakReference;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes12.dex */
public class ForwardDialog extends cw implements View.OnClickListener, DialogInterface.OnDismissListener {
    static IPatchRedirector $redirector_;
    private RelativeLayout K;
    private ForwardPreViewForShareDialog L;
    private TextView M;
    private WeakReference<Context> N;
    private View P;
    private EditText Q;
    private int R;
    private ImageView S;
    private LinearLayout T;
    private IEmoticonMainPanel U;
    private Handler V;
    private Resources W;
    private WindowManager X;
    private WindowManager.LayoutParams Y;
    private boolean Z;

    /* renamed from: a0, reason: collision with root package name */
    protected ScrollView f210999a0;

    /* renamed from: b0, reason: collision with root package name */
    private int f211000b0;

    /* renamed from: c0, reason: collision with root package name */
    private eg f211001c0;

    /* renamed from: d0, reason: collision with root package name */
    eg.b f211002d0;

    /* renamed from: e0, reason: collision with root package name */
    private i f211003e0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ DialogInterface.OnClickListener f211005d;

        a(DialogInterface.OnClickListener onClickListener) {
            this.f211005d = onClickListener;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardDialog.this, (Object) onClickListener);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean z16;
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                if (ForwardDialog.this.f211003e0 != null) {
                    z16 = ForwardDialog.this.f211003e0.a(view);
                } else {
                    z16 = false;
                }
                ForwardDialog.this.hideSoftInputFromWindow();
                DialogInterface.OnClickListener onClickListener = this.f211005d;
                if (onClickListener != null) {
                    onClickListener.onClick(ForwardDialog.this, 1);
                }
                if (ForwardDialog.this.Z) {
                    ForwardDialog.this.X.removeView(ForwardDialog.this.U.getView());
                    ForwardDialog.this.Z = false;
                }
                try {
                    if (ForwardDialog.this.isShowing() && !z16) {
                        ForwardDialog.this.dismiss();
                    }
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d("Forward.NewVersion.ForwardDialogForPreView", 2, Log.getStackTraceString(e16));
                    }
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class b implements eg.b {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardDialog.this);
            }
        }

        @Override // com.tencent.mobileqq.utils.eg.b
        public void a(int i3, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                ForwardDialog.this.f211000b0 = eg.i(i3);
                ForwardDialog.this.Y.height = ForwardDialog.this.f211000b0;
            } else {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class c implements IEmoticonMainPanel.DispatchKeyEventListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardDialog.this);
            }
        }

        @Override // com.tencent.mobileqq.emoticonview.IEmoticonMainPanel.DispatchKeyEventListener
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) keyEvent)).booleanValue();
            }
            if (keyEvent.getKeyCode() != 4 || keyEvent.getAction() != 1 || !ForwardDialog.this.Z) {
                return false;
            }
            ForwardDialog.this.X.removeView(ForwardDialog.this.U.getView());
            ForwardDialog.this.Z = false;
            WindowManager.LayoutParams attributes = ForwardDialog.this.getWindow().getAttributes();
            attributes.y = 0;
            ForwardDialog.this.getWindow().setAttributes(attributes);
            ForwardDialog.this.A0();
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class d implements ViewTreeObserver.OnGlobalLayoutListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardDialog.this);
            }
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            ScrollView scrollView = ForwardDialog.this.f210999a0;
            if (scrollView != null) {
                scrollView.fullScroll(130);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class e implements EmoticonCallback {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardDialog.this);
            }
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void delete() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this);
                return;
            }
            if (ForwardDialog.this.Q != null && ForwardDialog.this.Q.getSelectionStart() != 0) {
                try {
                    Editable text = ForwardDialog.this.Q.getText();
                    int selectionStart = ForwardDialog.this.Q.getSelectionStart();
                    int offsetBefore = TextUtils.getOffsetBefore(ForwardDialog.this.Q.getText(), selectionStart);
                    if (selectionStart != offsetBefore) {
                        text.delete(Math.min(selectionStart, offsetBefore), Math.max(selectionStart, offsetBefore));
                    }
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            }
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void emoticonMall() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void onHidePopup(EmoticonInfo emoticonInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, (Object) emoticonInfo);
            }
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public boolean onLongClick(EmoticonInfo emoticonInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) emoticonInfo)).booleanValue();
            }
            return true;
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void onShowPopup(EmoticonInfo emoticonInfo, EmoticonInfo emoticonInfo2, Drawable drawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, this, emoticonInfo, emoticonInfo2, drawable);
            }
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void send() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this);
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void setting() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void send(EmoticonInfo emoticonInfo) {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) emoticonInfo);
                return;
            }
            if (ForwardDialog.this.Q == null) {
                QLog.i("Forward.NewVersion.ForwardDialogForPreView", 1, "send(EmoticonInfo info) faild, because mInputView == null");
                return;
            }
            if (emoticonInfo instanceof SystemEmoticonInfo) {
                int selectionStart = ForwardDialog.this.Q.getSelectionStart();
                int selectionEnd = ForwardDialog.this.Q.getSelectionEnd();
                if (selectionStart < 0 || selectionEnd < 0 || selectionEnd < selectionStart) {
                    return;
                }
                ForwardDialog.this.Q.getEditableText().replace(selectionStart, selectionEnd, com.tencent.mobileqq.text.TextUtils.getSysEmotcationString(((SystemEmoticonInfo) emoticonInfo).code));
                return;
            }
            if (emoticonInfo instanceof SystemAndEmojiEmoticonInfo) {
                SystemAndEmojiEmoticonInfo systemAndEmojiEmoticonInfo = (SystemAndEmojiEmoticonInfo) emoticonInfo;
                int selectionStart2 = ForwardDialog.this.Q.getSelectionStart();
                int selectionEnd2 = ForwardDialog.this.Q.getSelectionEnd();
                int i3 = systemAndEmojiEmoticonInfo.emotionType;
                int i16 = systemAndEmojiEmoticonInfo.code;
                if (selectionStart2 >= 0 && selectionEnd2 >= 0 && selectionEnd2 >= selectionStart2) {
                    if (i3 == 2 && i16 == -1) {
                        return;
                    }
                    try {
                        str = i3 == 1 ? com.tencent.mobileqq.text.TextUtils.getSysEmotcationString(i16) : com.tencent.mobileqq.text.TextUtils.getEmojiString(i16);
                    } catch (Exception e16) {
                        if (QLog.isColorLevel()) {
                            QLog.d("Forward.NewVersion.ForwardDialogForPreView", 2, QLog.getStackTraceString(e16));
                        }
                        str = "";
                    }
                    ForwardDialog.this.Q.getEditableText().replace(selectionStart2, selectionEnd2, str);
                    ForwardDialog.this.Q.requestFocus();
                }
                systemAndEmojiEmoticonInfo.addToCommonUsed((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime(), (Parcelable) null);
                QQSysAndEmojiResMgr.getInstance().getResImpl(i3).reportEmoClick(i16, 4);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class f implements ICommonPanelInteractionView {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardDialog.this);
            }
        }

        @Override // com.tencent.mobileqq.emoticonview.api.ICommonPanelInteractionView
        public EditText getAIOInput() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return ForwardDialog.this.Q;
            }
            return (EditText) iPatchRedirector.redirect((short) 2, (Object) this);
        }

        @Override // com.tencent.mobileqq.emoticonview.api.ICommonPanelInteractionView
        public IEmoticonMainPanel getIEmoticonMainPanel() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return ForwardDialog.this.U;
            }
            return (IEmoticonMainPanel) iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class g implements View.OnTouchListener {
        static IPatchRedirector $redirector_;

        g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardDialog.this);
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
            }
            ForwardDialog.this.L.setEmoButtonImageResourceATag(R.drawable.qui_emoticon, R.drawable.forward_dialog_new_edit_emoji);
            if (ForwardDialog.this.Z) {
                ForwardDialog.this.A0();
                ForwardDialog.this.X.removeView(ForwardDialog.this.U.getView());
                ForwardDialog.this.Z = false;
                WindowManager.LayoutParams attributes = ForwardDialog.this.getWindow().getAttributes();
                attributes.y = 0;
                ForwardDialog.this.getWindow().setAttributes(attributes);
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class h implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ DialogInterface.OnClickListener f211013d;

        h(DialogInterface.OnClickListener onClickListener) {
            this.f211013d = onClickListener;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardDialog.this, (Object) onClickListener);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                ForwardDialog.this.hideSoftInputFromWindow();
                DialogInterface.OnClickListener onClickListener = this.f211013d;
                if (onClickListener != null) {
                    onClickListener.onClick(ForwardDialog.this, 0);
                }
                if (ForwardDialog.this.Z) {
                    ForwardDialog.this.X.removeView(ForwardDialog.this.U.getView());
                    ForwardDialog.this.Z = false;
                }
                try {
                    if (ForwardDialog.this.isShowing()) {
                        ForwardDialog.this.dismiss();
                    }
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d("Forward.NewVersion.ForwardDialogForPreView", 2, Log.getStackTraceString(e16));
                    }
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface i {
        boolean a(View view);
    }

    public ForwardDialog(Context context) {
        super(context, R.style.qZoneInputDialog);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.R = 7;
        this.S = null;
        this.U = null;
        this.V = new Handler();
        this.W = null;
        this.f211002d0 = new b();
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        if (attributes != null) {
            attributes.gravity = 17;
        }
        this.N = new WeakReference<>(context);
        this.W = context.getResources();
        getWindow().setSoftInputMode(19);
        this.X = (WindowManager) context.getSystemService("window");
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-1, eg.i(0), 2, 32, -1);
        this.Y = layoutParams;
        layoutParams.gravity = 81;
        layoutParams.windowAnimations = R.style.f173457dx;
        setContentView(R.layout.e57);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0() {
        ViewGroup.LayoutParams layoutParams = this.P.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = -2;
            this.P.requestLayout();
        }
    }

    private void s0(Context context) {
        boolean z16;
        e eVar = new e();
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime instanceof QQAppInterface) {
            int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.title_bar_height);
            IEmoticonMainPanelService.PanelBuilder callBack = ((IEmoticonMainPanelService) ((QQAppInterface) runtime).getRuntimeService(IEmoticonMainPanelService.class)).newBuilder(getContext(), 100003).setCallBack(eVar);
            if (this.R == 7) {
                z16 = true;
            } else {
                z16 = false;
            }
            IEmoticonMainPanel create = callBack.setOnlySysAndEmoji(z16).setPanelInteractionListener(new CommonPanelInteractionListener(new f())).setShowEmotionPanelDeleteButton(true).setToastOffset(dimensionPixelSize).create();
            this.U = create;
            create.hideAllTabs();
            this.Y.height = this.f211000b0;
            return;
        }
        QLog.e("Forward.NewVersion.ForwardDialogForPreView", 1, "get QQAppInterface fail");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int x0(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return iArr[1];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean z0() {
        Context context = this.N.get();
        boolean z16 = context instanceof Activity;
        if (!z16) {
            QLog.e("Forward.NewVersion.ForwardDialogForPreView", 1, "isActivityFinishing is true! context not instanceof activity!");
            return true;
        }
        if (z16 && ((Activity) context).isFinishing()) {
            return true;
        }
        return false;
    }

    public void B0(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, i3);
            return;
        }
        ForwardPreViewForShareDialog forwardPreViewForShareDialog = this.L;
        if (forwardPreViewForShareDialog != null) {
            forwardPreViewForShareDialog.setContentViewHeight(i3);
        }
    }

    public void C0(i iVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) iVar);
        } else {
            this.f211003e0 = iVar;
        }
    }

    @Override // com.tencent.mobileqq.utils.QQCustomDialog
    /* renamed from: D0, reason: merged with bridge method [inline-methods] */
    public ForwardDialog setNegativeButton(String str, DialogInterface.OnClickListener onClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (ForwardDialog) iPatchRedirector.redirect((short) 20, (Object) this, (Object) str, (Object) onClickListener);
        }
        if (onClickListener == null) {
            this.lBtn.setVisibility(8);
            return this;
        }
        this.lBtn.setText(str);
        this.lBtn.setVisibility(0);
        AccessibilityUtil.c(this.lBtn, str, Button.class.getName());
        this.lBtn.setOnClickListener(new h(onClickListener));
        return this;
    }

    @Override // com.tencent.mobileqq.utils.QQCustomDialog
    /* renamed from: E0, reason: merged with bridge method [inline-methods] */
    public ForwardDialog setPositiveButton(String str, DialogInterface.OnClickListener onClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (ForwardDialog) iPatchRedirector.redirect((short) 21, (Object) this, (Object) str, (Object) onClickListener);
        }
        if (onClickListener == null) {
            this.rBtn.setVisibility(8);
            return this;
        }
        this.rBtn.setText(str);
        AccessibilityUtil.c(this.rBtn, str, Button.class.getName());
        this.rBtn.setVisibility(0);
        this.rBtn.setOnClickListener(new a(onClickListener));
        return this;
    }

    public void F0(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        } else if (str != null) {
            this.M.setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.utils.cw
    public void S() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
            return;
        }
        super.S();
        this.L.setEmoButtonImageResourceATag(R.drawable.qui_emoticon, R.drawable.forward_dialog_new_edit_emoji);
        if (this.Z) {
            A0();
            this.X.removeView(this.U.getView());
            this.Z = false;
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.y = 0;
            getWindow().setAttributes(attributes);
        }
    }

    @Override // com.tencent.mobileqq.utils.cw, com.tencent.mobileqq.utils.QQCustomDialog, com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
            return;
        }
        super.dismiss();
        IEmoticonMainPanel iEmoticonMainPanel = this.U;
        if (iEmoticonMainPanel != null) {
            iEmoticonMainPanel.onDestory();
        }
    }

    @Override // com.tencent.mobileqq.utils.QQCustomDialog
    public EditText getEditText() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (EditText) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.Q;
    }

    @Override // com.tencent.mobileqq.utils.QQCustomDialog
    public String getInputValue() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        ForwardPreViewForShareDialog forwardPreViewForShareDialog = this.L;
        if (forwardPreViewForShareDialog != null) {
            return forwardPreViewForShareDialog.j();
        }
        return "";
    }

    @Override // com.tencent.mobileqq.utils.QQCustomDialog
    public void hideSoftInputFromWindow() {
        InputMethodManager inputMethodManager;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
        } else {
            if (this.Q == null || (inputMethodManager = (InputMethodManager) getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)) == null) {
                return;
            }
            inputMethodManager.hideSoftInputFromWindow(this.Q.getWindowToken(), 0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) view);
        } else if (view.getId() == R.id.emo_btn) {
            if (this.U != null) {
                if (this.Z) {
                    A0();
                    this.X.removeView(this.U.getView());
                    this.Z = false;
                    ForwardPreViewForShareDialog forwardPreViewForShareDialog = this.L;
                    if (forwardPreViewForShareDialog != null) {
                        forwardPreViewForShareDialog.setEmoButtonImageResourceATag(R.drawable.qui_emoticon, R.drawable.forward_dialog_new_edit_emoji);
                    }
                    this.V.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.forward.dialog.ForwardDialog.6
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ForwardDialog.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                            } else {
                                InputMethodUtil.show(ForwardDialog.this.Q);
                            }
                        }
                    }, 200L);
                    WindowManager.LayoutParams attributes = getWindow().getAttributes();
                    attributes.y = 0;
                    getWindow().setAttributes(attributes);
                } else {
                    Object tag = this.S.getTag();
                    if (tag != null && (tag instanceof Integer) && ((Integer) tag).intValue() == R.drawable.forward_dialog_new_edit_keyboard) {
                        InputMethodUtil.show(this.Q);
                        ForwardPreViewForShareDialog forwardPreViewForShareDialog2 = this.L;
                        if (forwardPreViewForShareDialog2 != null) {
                            forwardPreViewForShareDialog2.setEmoButtonImageResourceATag(R.drawable.qui_emoticon, R.drawable.forward_dialog_new_edit_emoji);
                        }
                        this.Z = false;
                    } else {
                        InputMethodUtil.hide(this.Q);
                        ForwardPreViewForShareDialog forwardPreViewForShareDialog3 = this.L;
                        if (forwardPreViewForShareDialog3 != null) {
                            forwardPreViewForShareDialog3.setEmoButtonImageResourceATag(R.drawable.qui_keyboard_circle, R.drawable.forward_dialog_new_edit_keyboard);
                        }
                        this.U.getView().setMinimumHeight(eg.i(0));
                        this.V.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.forward.dialog.ForwardDialog.7
                            static IPatchRedirector $redirector_;

                            {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ForwardDialog.this);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                    iPatchRedirector2.redirect((short) 2, (Object) this);
                                } else {
                                    if (ForwardDialog.this.z0()) {
                                        return;
                                    }
                                    ForwardDialog.this.X.addView(ForwardDialog.this.U.getView(), ForwardDialog.this.Y);
                                    ForwardDialog.this.Z = true;
                                    ForwardDialog.this.U.getView().post(new Runnable() { // from class: com.tencent.mobileqq.forward.dialog.ForwardDialog.7.1
                                        static IPatchRedirector $redirector_;

                                        {
                                            IPatchRedirector iPatchRedirector3 = $redirector_;
                                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass7.this);
                                            }
                                        }

                                        @Override // java.lang.Runnable
                                        public void run() {
                                            int dip2px;
                                            int i3;
                                            ViewGroup.LayoutParams layoutParams;
                                            IPatchRedirector iPatchRedirector3 = $redirector_;
                                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                                iPatchRedirector3.redirect((short) 2, (Object) this);
                                                return;
                                            }
                                            ForwardDialog forwardDialog = ForwardDialog.this;
                                            int x06 = forwardDialog.x0(forwardDialog.U.getView());
                                            ForwardDialog forwardDialog2 = ForwardDialog.this;
                                            int x07 = forwardDialog2.x0(forwardDialog2.P);
                                            int height = ForwardDialog.this.P.getHeight();
                                            int i16 = x07 + height;
                                            int i17 = x06 - i16;
                                            int statusBarHeight = ImmersiveUtils.getStatusBarHeight(ForwardDialog.this.getContext());
                                            if (i17 > 0) {
                                                dip2px = ForwardDialog.this.U.getView().getHeight() / 2;
                                            } else {
                                                int i18 = (((x06 - height) - statusBarHeight) / 2) + statusBarHeight;
                                                if (i18 < x07) {
                                                    dip2px = x07 - i18;
                                                } else {
                                                    dip2px = (i16 - x06) + ViewUtils.dip2px(10.0f);
                                                }
                                            }
                                            WindowManager.LayoutParams attributes2 = ForwardDialog.this.getWindow().getAttributes();
                                            attributes2.y = -dip2px;
                                            ForwardDialog.this.getWindow().setAttributes(attributes2);
                                            if (dip2px > x07 - statusBarHeight && (layoutParams = ForwardDialog.this.P.getLayoutParams()) != null) {
                                                layoutParams.height = (x06 - ImmersiveUtils.getStatusBarHeight(ForwardDialog.this.getContext())) - ViewUtils.dip2px(10.0f);
                                                ForwardDialog.this.P.requestLayout();
                                            }
                                            if (QLog.isColorLevel()) {
                                                Context context = (Context) ForwardDialog.this.N.get();
                                                if (context != null) {
                                                    i3 = context.getResources().getDisplayMetrics().heightPixels;
                                                } else {
                                                    i3 = 0;
                                                }
                                                StringBuilder sb5 = new StringBuilder(128);
                                                if (context == null) {
                                                    sb5.append("|context is null");
                                                } else {
                                                    sb5.append("|context is not null");
                                                }
                                                sb5.append("|screenHeight=");
                                                sb5.append(i3);
                                                sb5.append("|statusBarHeight=");
                                                sb5.append(statusBarHeight);
                                                sb5.append("|emoSpaceY=");
                                                sb5.append(x06);
                                                sb5.append("|dialogY=");
                                                sb5.append(x07);
                                                sb5.append("|dialogHeight=");
                                                sb5.append(height);
                                                sb5.append("|moveY=");
                                                sb5.append(dip2px);
                                                QLog.d("QQCustomDialogWtihEmoticonInput.meassure", 2, sb5.toString());
                                            }
                                        }
                                    });
                                }
                            }
                        }, 200L);
                    }
                }
            }
        } else {
            if (this.Z) {
                A0();
                this.X.removeView(this.U.getView());
                this.Z = false;
                WindowManager.LayoutParams attributes2 = getWindow().getAttributes();
                attributes2.y = 0;
                getWindow().setAttributes(attributes2);
            }
            InputMethodUtil.hide(this.Q);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) dialogInterface);
            return;
        }
        eg egVar = this.f211001c0;
        if (egVar != null) {
            egVar.h();
        }
    }

    @Override // android.app.Dialog
    public boolean onTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this, (Object) motionEvent)).booleanValue();
        }
        if (motionEvent.getAction() != 1) {
            return super.onTouchEvent(motionEvent);
        }
        if (this.Z) {
            this.X.removeView(this.U.getView());
            this.Z = false;
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.y = 0;
            getWindow().setAttributes(attributes);
            A0();
        }
        InputMethodUtil.hide(this.Q);
        super.onTouchEvent(motionEvent);
        return true;
    }

    @Override // com.tencent.mobileqq.utils.cw, com.tencent.mobileqq.utils.QQCustomDialog, android.app.Dialog
    @SuppressLint({"ClickableViewAccessibility"})
    public void setContentView(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3);
            return;
        }
        super.setContentView(i3);
        this.K = (RelativeLayout) findViewById(R.id.b9w);
        this.M = (TextView) findViewById(R.id.kfr);
        this.P = findViewById(R.id.bja);
        Context context = this.N.get();
        if (context == null) {
            return;
        }
        eg egVar = new eg(((ViewGroup) getWindow().getDecorView().findViewById(android.R.id.content)).getChildAt(0), this.X.getDefaultDisplay().getHeight(), this.f211002d0);
        this.f211001c0 = egVar;
        int k3 = egVar.k();
        this.f211000b0 = k3;
        this.f211000b0 = eg.i(k3);
        setOnDismissListener(this);
        s0(context);
        this.U.setDispatchKeyEventListener(new c());
        View findViewById = this.P.findViewById(R.id.ii8);
        if (findViewById instanceof ScrollView) {
            this.f210999a0 = (ScrollView) findViewById;
        }
        this.P.getViewTreeObserver().addOnGlobalLayoutListener(new d());
        SimpleModeHelper.y(this);
    }

    @Override // com.tencent.mobileqq.utils.cw, com.tencent.mobileqq.utils.QQCustomDialog, com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog
    public void show() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this);
        } else {
            com.tencent.mobileqq.simpleui.c.b(this);
            super.show();
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void u0(ForwardPreViewForShareDialog forwardPreViewForShareDialog) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) forwardPreViewForShareDialog);
            return;
        }
        if (forwardPreViewForShareDialog == null) {
            return;
        }
        this.L = forwardPreViewForShareDialog;
        this.K.addView(forwardPreViewForShareDialog);
        this.Q = this.L.i();
        this.S = this.L.g();
        this.T = this.L.h();
        this.S.setOnClickListener(this);
        this.Q.setOnTouchListener(new g());
    }

    public void w0(String str, String str2, String str3, String str4, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, str, str2, str3, str4, onClickListener, onClickListener2);
            return;
        }
        this.title.setText(str);
        EditText editText = this.Q;
        if (editText != null) {
            editText.setHint(str2);
        }
        setNegativeButton(str3, onClickListener2);
        setPositiveButton(str4, onClickListener);
    }

    public void y0(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, z16);
            return;
        }
        ForwardPreViewForShareDialog forwardPreViewForShareDialog = this.L;
        if (forwardPreViewForShareDialog != null) {
            forwardPreViewForShareDialog.k(z16);
        }
    }
}
