package com.tencent.mobileqq.forward;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
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
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.utils.SimpleModeHelper;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.cw;
import com.tencent.mobileqq.utils.eg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.InputMethodUtil;
import com.tencent.util.TokenResUtils;
import com.tencent.widget.MaxHeightRelativelayout;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.ref.WeakReference;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes12.dex */
public class ForwardNewVersionDialog extends cw implements View.OnClickListener, DialogInterface.OnDismissListener {
    static IPatchRedirector $redirector_;
    private MaxHeightRelativelayout K;
    private TextView L;
    private WeakReference<Context> M;
    private View N;
    private EditText P;
    private int Q;
    private ImageView R;
    private LinearLayout S;
    private IEmoticonMainPanel T;
    private Handler U;
    private Resources V;
    private WindowManager W;
    private WindowManager.LayoutParams X;
    private boolean Y;
    protected ScrollView Z;

    /* renamed from: a0, reason: collision with root package name */
    private int f210698a0;

    /* renamed from: b0, reason: collision with root package name */
    private eg f210699b0;

    /* renamed from: c0, reason: collision with root package name */
    eg.b f210700c0;

    /* renamed from: d0, reason: collision with root package name */
    private j f210701d0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ DialogInterface.OnClickListener f210703d;

        a(DialogInterface.OnClickListener onClickListener) {
            this.f210703d = onClickListener;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardNewVersionDialog.this, (Object) onClickListener);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                ForwardNewVersionDialog.this.hideSoftInputFromWindow();
                DialogInterface.OnClickListener onClickListener = this.f210703d;
                if (onClickListener != null) {
                    onClickListener.onClick(ForwardNewVersionDialog.this, 0);
                }
                if (ForwardNewVersionDialog.this.Y) {
                    ForwardNewVersionDialog.this.W.removeView(ForwardNewVersionDialog.this.T.getView());
                    ForwardNewVersionDialog.this.Y = false;
                }
                try {
                    if (ForwardNewVersionDialog.this.isShowing()) {
                        ForwardNewVersionDialog.this.dismiss();
                    }
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d("Forward.NewVersion.Dialog", 2, Log.getStackTraceString(e16));
                    }
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class b implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ DialogInterface.OnClickListener f210705d;

        b(DialogInterface.OnClickListener onClickListener) {
            this.f210705d = onClickListener;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardNewVersionDialog.this, (Object) onClickListener);
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
                if (ForwardNewVersionDialog.this.f210701d0 != null) {
                    z16 = ForwardNewVersionDialog.this.f210701d0.a(view);
                } else {
                    z16 = false;
                }
                ForwardNewVersionDialog.this.hideSoftInputFromWindow();
                DialogInterface.OnClickListener onClickListener = this.f210705d;
                if (onClickListener != null) {
                    onClickListener.onClick(ForwardNewVersionDialog.this, 1);
                }
                if (ForwardNewVersionDialog.this.Y) {
                    ForwardNewVersionDialog.this.W.removeView(ForwardNewVersionDialog.this.T.getView());
                    ForwardNewVersionDialog.this.Y = false;
                }
                try {
                    if (ForwardNewVersionDialog.this.isShowing() && !z16) {
                        ForwardNewVersionDialog.this.dismiss();
                    }
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d("Forward.NewVersion.Dialog", 2, Log.getStackTraceString(e16));
                    }
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class c implements eg.b {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardNewVersionDialog.this);
            }
        }

        @Override // com.tencent.mobileqq.utils.eg.b
        public void a(int i3, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                ForwardNewVersionDialog.this.f210698a0 = eg.i(i3);
                ForwardNewVersionDialog.this.X.height = ForwardNewVersionDialog.this.f210698a0;
            } else {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class d implements View.OnTouchListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardNewVersionDialog.this);
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
            }
            ForwardNewVersionDialog.this.R.setImageResource(TokenResUtils.getTokenRes2(R.drawable.forward_dialog_new_edit_emoji, R.drawable.qui_emoticon));
            ForwardNewVersionDialog.this.R.setTag(Integer.valueOf(R.drawable.forward_dialog_new_edit_emoji));
            if (ForwardNewVersionDialog.this.Y) {
                ForwardNewVersionDialog.this.B0();
                ForwardNewVersionDialog.this.W.removeView(ForwardNewVersionDialog.this.T.getView());
                ForwardNewVersionDialog.this.Y = false;
                WindowManager.LayoutParams attributes = ForwardNewVersionDialog.this.getWindow().getAttributes();
                attributes.y = 0;
                ForwardNewVersionDialog.this.getWindow().setAttributes(attributes);
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class e implements IEmoticonMainPanel.DispatchKeyEventListener {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardNewVersionDialog.this);
            }
        }

        @Override // com.tencent.mobileqq.emoticonview.IEmoticonMainPanel.DispatchKeyEventListener
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) keyEvent)).booleanValue();
            }
            if (keyEvent.getKeyCode() != 4 || keyEvent.getAction() != 1 || !ForwardNewVersionDialog.this.Y) {
                return false;
            }
            ForwardNewVersionDialog.this.W.removeView(ForwardNewVersionDialog.this.T.getView());
            ForwardNewVersionDialog.this.Y = false;
            WindowManager.LayoutParams attributes = ForwardNewVersionDialog.this.getWindow().getAttributes();
            attributes.y = 0;
            ForwardNewVersionDialog.this.getWindow().setAttributes(attributes);
            ForwardNewVersionDialog.this.B0();
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class f implements ViewTreeObserver.OnGlobalLayoutListener {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardNewVersionDialog.this);
            }
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            ScrollView scrollView = ForwardNewVersionDialog.this.Z;
            if (scrollView != null) {
                scrollView.fullScroll(130);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class g implements TextWatcher {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f210711d;

        g(int i3) {
            this.f210711d = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardNewVersionDialog.this, i3);
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) editable);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
                return;
            }
            int length = ForwardNewVersionDialog.this.P.getText().length();
            int i18 = this.f210711d;
            if (length == i18 && charSequence.charAt(i18 - 1) == 20) {
                ForwardNewVersionDialog.this.P.setText(charSequence.subSequence(0, this.f210711d - 1));
                ForwardNewVersionDialog.this.P.setSelection(this.f210711d - 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class h implements EmoticonCallback {
        static IPatchRedirector $redirector_;

        h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardNewVersionDialog.this);
            }
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void delete() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this);
                return;
            }
            if (ForwardNewVersionDialog.this.P.getSelectionStart() == 0) {
                return;
            }
            try {
                Editable text = ForwardNewVersionDialog.this.P.getText();
                int selectionStart = ForwardNewVersionDialog.this.P.getSelectionStart();
                int offsetBefore = TextUtils.getOffsetBefore(ForwardNewVersionDialog.this.P.getText(), selectionStart);
                if (selectionStart != offsetBefore) {
                    text.delete(Math.min(selectionStart, offsetBefore), Math.max(selectionStart, offsetBefore));
                }
            } catch (Exception e16) {
                e16.printStackTrace();
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

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v0 */
        /* JADX WARN: Type inference failed for: r4v1, types: [int] */
        /* JADX WARN: Type inference failed for: r4v2, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r4v3, types: [java.lang.CharSequence] */
        /* JADX WARN: Type inference failed for: r4v5 */
        /* JADX WARN: Type inference failed for: r4v7 */
        /* JADX WARN: Type inference failed for: r4v8 */
        /* JADX WARN: Type inference failed for: r5v5, types: [android.text.Editable] */
        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void send(EmoticonInfo emoticonInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) emoticonInfo);
                return;
            }
            if (emoticonInfo instanceof SystemEmoticonInfo) {
                int selectionStart = ForwardNewVersionDialog.this.P.getSelectionStart();
                int selectionEnd = ForwardNewVersionDialog.this.P.getSelectionEnd();
                if (selectionStart < 0 || selectionEnd < 0 || selectionEnd < selectionStart) {
                    return;
                }
                ForwardNewVersionDialog.this.P.getEditableText().replace(selectionStart, selectionEnd, com.tencent.mobileqq.text.TextUtils.getSysEmotcationString(((SystemEmoticonInfo) emoticonInfo).code));
                return;
            }
            if (emoticonInfo instanceof SystemAndEmojiEmoticonInfo) {
                SystemAndEmojiEmoticonInfo systemAndEmojiEmoticonInfo = (SystemAndEmojiEmoticonInfo) emoticonInfo;
                int selectionStart2 = ForwardNewVersionDialog.this.P.getSelectionStart();
                int selectionEnd2 = ForwardNewVersionDialog.this.P.getSelectionEnd();
                int i3 = systemAndEmojiEmoticonInfo.emotionType;
                int i16 = systemAndEmojiEmoticonInfo.code;
                if (selectionStart2 >= 0 && selectionEnd2 >= 0 && selectionEnd2 >= selectionStart2) {
                    ?? r46 = 2;
                    if (i3 == 2 && i16 == -1) {
                        return;
                    }
                    try {
                        r46 = i3 == 1 ? com.tencent.mobileqq.text.TextUtils.getSysEmotcationString(i16) : com.tencent.mobileqq.text.TextUtils.getEmojiString(i16);
                    } catch (Exception e16) {
                        if (QLog.isColorLevel()) {
                            QLog.d("Forward.NewVersion.Dialog", (int) r46, QLog.getStackTraceString(e16));
                        }
                        r46 = "";
                    }
                    ForwardNewVersionDialog.this.P.getEditableText().replace(selectionStart2, selectionEnd2, r46);
                    ForwardNewVersionDialog.this.P.requestFocus();
                }
                systemAndEmojiEmoticonInfo.addToCommonUsed((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime(), (Parcelable) null);
                QQSysAndEmojiResMgr.getInstance().getResImpl(i3).reportEmoClick(i16, 4);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class i implements ICommonPanelInteractionView {
        static IPatchRedirector $redirector_;

        i() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardNewVersionDialog.this);
            }
        }

        @Override // com.tencent.mobileqq.emoticonview.api.ICommonPanelInteractionView
        public EditText getAIOInput() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return ForwardNewVersionDialog.this.P;
            }
            return (EditText) iPatchRedirector.redirect((short) 2, (Object) this);
        }

        @Override // com.tencent.mobileqq.emoticonview.api.ICommonPanelInteractionView
        public IEmoticonMainPanel getIEmoticonMainPanel() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return ForwardNewVersionDialog.this.T;
            }
            return (IEmoticonMainPanel) iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface j {
        boolean a(View view);
    }

    public ForwardNewVersionDialog(@NonNull Context context) {
        super(context, R.style.qZoneInputDialog);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.Q = 7;
        this.R = null;
        this.T = null;
        this.U = new Handler();
        this.V = null;
        this.f210700c0 = new c();
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        if (attributes != null) {
            attributes.gravity = 17;
        }
        this.M = new WeakReference<>(context);
        this.V = context.getResources();
        getWindow().setSoftInputMode(19);
        this.W = (WindowManager) context.getSystemService("window");
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-1, eg.i(0), 2, 32, -1);
        this.X = layoutParams;
        layoutParams.gravity = 81;
        layoutParams.windowAnimations = R.style.f173457dx;
        setContentView(R.layout.f167849ji);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean A0() {
        Context context = this.M.get();
        boolean z16 = context instanceof Activity;
        if (!z16) {
            QLog.e("Forward.NewVersion.Dialog", 1, "isActivityFinishing is true! context not instanceof activity!");
            return true;
        }
        if (z16 && ((Activity) context).isFinishing()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B0() {
        ViewGroup.LayoutParams layoutParams = this.N.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = -2;
            this.N.requestLayout();
        }
    }

    private void u0(Context context) {
        boolean z16;
        h hVar = new h();
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime instanceof QQAppInterface) {
            int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.title_bar_height);
            IEmoticonMainPanelService.PanelBuilder callBack = ((IEmoticonMainPanelService) ((QQAppInterface) runtime).getRuntimeService(IEmoticonMainPanelService.class)).newBuilder(getContext(), 100003).setCallBack(hVar);
            if (this.Q == 7) {
                z16 = true;
            } else {
                z16 = false;
            }
            IEmoticonMainPanel create = callBack.setOnlySysAndEmoji(z16).setPanelInteractionListener(new CommonPanelInteractionListener(new i())).setShowEmotionPanelDeleteButton(true).setToastOffset(dimensionPixelSize).create();
            this.T = create;
            create.hideAllTabs();
            this.X.height = this.f210698a0;
            return;
        }
        QLog.e("Forward.NewVersion.Dialog", 1, "get QQAppInterface fail");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int x0(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return iArr[1];
    }

    public void C0(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, i3);
        } else {
            this.K.setMaxHeight(BaseAIOUtils.f(i3, getContext().getResources()));
        }
    }

    public void D0(j jVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) jVar);
        } else {
            this.f210701d0 = jVar;
        }
    }

    public void E0(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, i3);
            return;
        }
        EditText editText = this.P;
        if (editText != null) {
            editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(i3)});
            this.P.addTextChangedListener(new g(i3));
        }
    }

    @Override // com.tencent.mobileqq.utils.QQCustomDialog
    /* renamed from: F0, reason: merged with bridge method [inline-methods] */
    public ForwardNewVersionDialog setNegativeButton(String str, DialogInterface.OnClickListener onClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (ForwardNewVersionDialog) iPatchRedirector.redirect((short) 19, (Object) this, (Object) str, (Object) onClickListener);
        }
        if (onClickListener == null) {
            this.lBtn.setVisibility(8);
            return this;
        }
        this.lBtn.setText(str);
        this.lBtn.setVisibility(0);
        this.lBtn.setContentDescription(str + getContext().getString(R.string.a_n));
        this.lBtn.setOnClickListener(new a(onClickListener));
        return this;
    }

    @Override // com.tencent.mobileqq.utils.QQCustomDialog
    /* renamed from: H0, reason: merged with bridge method [inline-methods] */
    public ForwardNewVersionDialog setPositiveButton(String str, DialogInterface.OnClickListener onClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (ForwardNewVersionDialog) iPatchRedirector.redirect((short) 20, (Object) this, (Object) str, (Object) onClickListener);
        }
        if (onClickListener == null) {
            this.rBtn.setVisibility(8);
            return this;
        }
        this.rBtn.setText(str);
        this.rBtn.setContentDescription(str + getContext().getString(R.string.a_n));
        this.rBtn.setVisibility(0);
        this.rBtn.setOnClickListener(new b(onClickListener));
        return this;
    }

    public void I0(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        } else if (str != null) {
            this.L.setText(str);
        }
    }

    @Override // com.tencent.mobileqq.utils.QQCustomDialog
    public EditText getEditText() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (EditText) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.P;
    }

    @Override // com.tencent.mobileqq.utils.QQCustomDialog
    public String getInputValue() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.P.getText().toString();
    }

    @Override // com.tencent.mobileqq.utils.QQCustomDialog
    public void hideSoftInputFromWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
        } else if (this.P != null) {
            ((InputMethodManager) getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).hideSoftInputFromWindow(this.P.getWindowToken(), 0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) view);
        } else if (view.getId() == R.id.emo_btn) {
            if (this.T != null) {
                if (this.Y) {
                    B0();
                    this.W.removeView(this.T.getView());
                    this.Y = false;
                    this.R.setImageResource(TokenResUtils.getTokenRes2(R.drawable.forward_dialog_new_edit_emoji, R.drawable.qui_emoticon));
                    this.R.setTag(Integer.valueOf(R.drawable.forward_dialog_new_edit_emoji));
                    this.U.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.forward.ForwardNewVersionDialog.8
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ForwardNewVersionDialog.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                            } else {
                                InputMethodUtil.show(ForwardNewVersionDialog.this.P);
                            }
                        }
                    }, 200L);
                    WindowManager.LayoutParams attributes = getWindow().getAttributes();
                    attributes.y = 0;
                    getWindow().setAttributes(attributes);
                } else {
                    Object tag = this.R.getTag();
                    if (tag != null && (tag instanceof Integer) && ((Integer) tag).intValue() == R.drawable.forward_dialog_new_edit_keyboard) {
                        InputMethodUtil.show(this.P);
                        this.R.setImageResource(TokenResUtils.getTokenRes2(R.drawable.forward_dialog_new_edit_emoji, R.drawable.qui_emoticon));
                        this.R.setTag(Integer.valueOf(R.drawable.forward_dialog_new_edit_emoji));
                        this.Y = false;
                    } else {
                        InputMethodUtil.hide(this.P);
                        this.R.setImageResource(TokenResUtils.getTokenRes2(R.drawable.forward_dialog_new_edit_keyboard, R.drawable.qui_keyboard_circle));
                        this.R.setTag(Integer.valueOf(R.drawable.forward_dialog_new_edit_keyboard));
                        this.T.getView().setMinimumHeight(eg.i(0));
                        this.U.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.forward.ForwardNewVersionDialog.9
                            static IPatchRedirector $redirector_;

                            {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ForwardNewVersionDialog.this);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                    iPatchRedirector2.redirect((short) 2, (Object) this);
                                } else {
                                    if (ForwardNewVersionDialog.this.A0()) {
                                        return;
                                    }
                                    ForwardNewVersionDialog.this.W.addView(ForwardNewVersionDialog.this.T.getView(), ForwardNewVersionDialog.this.X);
                                    ForwardNewVersionDialog.this.Y = true;
                                    ForwardNewVersionDialog.this.T.getView().post(new Runnable() { // from class: com.tencent.mobileqq.forward.ForwardNewVersionDialog.9.1
                                        static IPatchRedirector $redirector_;

                                        {
                                            IPatchRedirector iPatchRedirector3 = $redirector_;
                                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass9.this);
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
                                            ForwardNewVersionDialog forwardNewVersionDialog = ForwardNewVersionDialog.this;
                                            int x06 = forwardNewVersionDialog.x0(forwardNewVersionDialog.T.getView());
                                            ForwardNewVersionDialog forwardNewVersionDialog2 = ForwardNewVersionDialog.this;
                                            int x07 = forwardNewVersionDialog2.x0(forwardNewVersionDialog2.N);
                                            int height = ForwardNewVersionDialog.this.N.getHeight();
                                            int i16 = x07 + height;
                                            int i17 = x06 - i16;
                                            int statusBarHeight = ImmersiveUtils.getStatusBarHeight(ForwardNewVersionDialog.this.getContext());
                                            if (i17 > 0) {
                                                dip2px = ForwardNewVersionDialog.this.T.getView().getHeight() / 2;
                                            } else {
                                                int i18 = (((x06 - height) - statusBarHeight) / 2) + statusBarHeight;
                                                if (i18 < x07) {
                                                    dip2px = x07 - i18;
                                                } else {
                                                    dip2px = (i16 - x06) + ViewUtils.dip2px(10.0f);
                                                }
                                            }
                                            WindowManager.LayoutParams attributes2 = ForwardNewVersionDialog.this.getWindow().getAttributes();
                                            attributes2.y = -dip2px;
                                            ForwardNewVersionDialog.this.getWindow().setAttributes(attributes2);
                                            if (dip2px > x07 - statusBarHeight && (layoutParams = ForwardNewVersionDialog.this.N.getLayoutParams()) != null) {
                                                layoutParams.height = (x06 - ImmersiveUtils.getStatusBarHeight(ForwardNewVersionDialog.this.getContext())) - ViewUtils.dip2px(10.0f);
                                                ForwardNewVersionDialog.this.N.requestLayout();
                                            }
                                            if (QLog.isColorLevel()) {
                                                Context context = (Context) ForwardNewVersionDialog.this.M.get();
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
            if (this.Y) {
                B0();
                this.W.removeView(this.T.getView());
                this.Y = false;
                WindowManager.LayoutParams attributes2 = getWindow().getAttributes();
                attributes2.y = 0;
                getWindow().setAttributes(attributes2);
            }
            InputMethodUtil.hide(this.P);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) dialogInterface);
            return;
        }
        IEmoticonMainPanel iEmoticonMainPanel = this.T;
        if (iEmoticonMainPanel != null) {
            iEmoticonMainPanel.onDestory();
        }
        eg egVar = this.f210699b0;
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
        if (this.Y) {
            this.W.removeView(this.T.getView());
            this.Y = false;
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.y = 0;
            getWindow().setAttributes(attributes);
            B0();
        }
        InputMethodUtil.hide(this.P);
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void s0(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) view);
        } else {
            if (view == null) {
                return;
            }
            this.K.addView(view);
        }
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
        this.K = (MaxHeightRelativelayout) findViewById(R.id.f166799ic3);
        this.L = (TextView) findViewById(R.id.kfr);
        this.P = (EditText) findViewById(R.id.input);
        this.R = (ImageView) findViewById(R.id.emo_btn);
        this.S = (LinearLayout) findViewById(R.id.dmo);
        this.N = findViewById(R.id.bja);
        this.R.setOnClickListener(this);
        this.P.setEditableFactory(QQTextBuilder.getCustomSizeEditableFactory(16));
        this.P.setSingleLine(false);
        this.P.setMaxLines(2);
        if (Build.VERSION.SDK_INT >= 29 && TokenResUtils.useTokenRes2()) {
            this.P.setTextCursorDrawable(R.drawable.qui_input_cursor);
        }
        this.R.setImageResource(TokenResUtils.getTokenRes2(R.drawable.forward_dialog_new_edit_emoji, R.drawable.qui_emoticon));
        E0(this.V.getInteger(R.integer.f167158k));
        this.P.setOnTouchListener(new d());
        Context context = this.M.get();
        if (context == null) {
            return;
        }
        com.tencent.devicelib.a.a(context, this.P);
        eg egVar = new eg(((ViewGroup) getWindow().getDecorView().findViewById(android.R.id.content)).getChildAt(0), this.W.getDefaultDisplay().getHeight(), this.f210700c0);
        this.f210699b0 = egVar;
        int k3 = egVar.k();
        this.f210698a0 = k3;
        this.f210698a0 = eg.i(k3);
        setOnDismissListener(this);
        u0(context);
        this.T.setDispatchKeyEventListener(new e());
        View findViewById = this.N.findViewById(R.id.ii8);
        if (findViewById instanceof ScrollView) {
            this.Z = (ScrollView) findViewById;
        }
        this.N.getViewTreeObserver().addOnGlobalLayoutListener(new f());
        SimpleModeHelper.y(this);
    }

    public void w0(String str, String str2, String str3, String str4, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, str, str2, str3, str4, onClickListener, onClickListener2);
            return;
        }
        this.title.setText(str);
        this.P.setHint(str2);
        setNegativeButton(str3, onClickListener2);
        setPositiveButton(str4, onClickListener);
    }

    public void y0(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, z16);
        } else if (z16) {
            this.S.setVisibility(8);
        } else {
            this.S.setVisibility(0);
        }
    }

    public void z0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        Object tag = this.R.getTag();
        if (tag != null && (tag instanceof Integer) && ((Integer) tag).intValue() == R.drawable.forward_dialog_new_edit_keyboard) {
            this.R.setImageResource(TokenResUtils.getTokenRes2(R.drawable.forward_dialog_new_edit_emoji, R.drawable.qui_emoticon));
            this.R.setTag(Integer.valueOf(R.drawable.forward_dialog_new_edit_emoji));
            B0();
            if (this.Y) {
                this.Y = false;
                this.W.removeView(this.T.getView());
            }
        }
    }
}
