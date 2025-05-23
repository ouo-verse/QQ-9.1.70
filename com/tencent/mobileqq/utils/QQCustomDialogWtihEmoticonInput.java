package com.tencent.mobileqq.utils;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Parcelable;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
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
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.image.RegionDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResMgr;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonInfo;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonPanel;
import com.tencent.mobileqq.emoticonview.SystemEmoticonInfo;
import com.tencent.mobileqq.emoticonview.SystemEmoticonPanel;
import com.tencent.mobileqq.emoticonview.api.IEmoticonMainPanelService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.eg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.InputMethodUtil;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.ref.SoftReference;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes20.dex */
public class QQCustomDialogWtihEmoticonInput extends cw implements View.OnClickListener, DialogInterface.OnDismissListener {
    SoftReference<Context> K;
    EditText L;
    boolean M;
    boolean N;
    int P;
    ImageView Q;
    SystemEmoticonPanel R;
    IEmoticonMainPanel S;
    Handler T;
    Resources U;
    WindowManager V;
    WindowManager.LayoutParams W;
    boolean X;
    RelativeLayout Y;
    protected ScrollView Z;

    /* renamed from: a0, reason: collision with root package name */
    private int f307183a0;

    /* renamed from: b0, reason: collision with root package name */
    private eg f307184b0;

    /* renamed from: c0, reason: collision with root package name */
    eg.b f307185c0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ DialogInterface.OnClickListener f307188d;

        a(DialogInterface.OnClickListener onClickListener) {
            this.f307188d = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QQCustomDialogWtihEmoticonInput.this.hideSoftInputFromWindow();
            DialogInterface.OnClickListener onClickListener = this.f307188d;
            if (onClickListener != null) {
                onClickListener.onClick(QQCustomDialogWtihEmoticonInput.this, 0);
                QQCustomDialogWtihEmoticonInput qQCustomDialogWtihEmoticonInput = QQCustomDialogWtihEmoticonInput.this;
                if (qQCustomDialogWtihEmoticonInput.X) {
                    if (qQCustomDialogWtihEmoticonInput.M) {
                        qQCustomDialogWtihEmoticonInput.V.removeView(qQCustomDialogWtihEmoticonInput.S.getView());
                    } else {
                        qQCustomDialogWtihEmoticonInput.V.removeView(qQCustomDialogWtihEmoticonInput.R);
                    }
                    QQCustomDialogWtihEmoticonInput.this.X = false;
                }
            }
            try {
                if (QQCustomDialogWtihEmoticonInput.this.isShowing()) {
                    QQCustomDialogWtihEmoticonInput.this.dismiss();
                }
            } catch (Exception unused) {
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class b implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ DialogInterface.OnClickListener f307190d;

        b(DialogInterface.OnClickListener onClickListener) {
            this.f307190d = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QQCustomDialogWtihEmoticonInput.this.hideSoftInputFromWindow();
            DialogInterface.OnClickListener onClickListener = this.f307190d;
            if (onClickListener != null) {
                onClickListener.onClick(QQCustomDialogWtihEmoticonInput.this, 1);
                QQCustomDialogWtihEmoticonInput qQCustomDialogWtihEmoticonInput = QQCustomDialogWtihEmoticonInput.this;
                if (qQCustomDialogWtihEmoticonInput.X) {
                    if (qQCustomDialogWtihEmoticonInput.M) {
                        qQCustomDialogWtihEmoticonInput.V.removeView(qQCustomDialogWtihEmoticonInput.S.getView());
                    } else {
                        qQCustomDialogWtihEmoticonInput.V.removeView(qQCustomDialogWtihEmoticonInput.R);
                    }
                    QQCustomDialogWtihEmoticonInput.this.X = false;
                }
            }
            try {
                if (QQCustomDialogWtihEmoticonInput.this.isShowing()) {
                    QQCustomDialogWtihEmoticonInput.this.dismiss();
                }
            } catch (Exception unused) {
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class c implements eg.b {
        c() {
        }

        @Override // com.tencent.mobileqq.utils.eg.b
        public void a(int i3, boolean z16) {
            QQCustomDialogWtihEmoticonInput.this.f307183a0 = eg.i(i3);
            QQCustomDialogWtihEmoticonInput qQCustomDialogWtihEmoticonInput = QQCustomDialogWtihEmoticonInput.this;
            qQCustomDialogWtihEmoticonInput.W.height = qQCustomDialogWtihEmoticonInput.f307183a0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class d implements View.OnTouchListener {
        d() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            QQCustomDialogWtihEmoticonInput.this.o0(true);
            QQCustomDialogWtihEmoticonInput qQCustomDialogWtihEmoticonInput = QQCustomDialogWtihEmoticonInput.this;
            if (qQCustomDialogWtihEmoticonInput.X) {
                qQCustomDialogWtihEmoticonInput.n0();
                QQCustomDialogWtihEmoticonInput qQCustomDialogWtihEmoticonInput2 = QQCustomDialogWtihEmoticonInput.this;
                if (qQCustomDialogWtihEmoticonInput2.M) {
                    qQCustomDialogWtihEmoticonInput2.V.removeView(qQCustomDialogWtihEmoticonInput2.S.getView());
                } else {
                    qQCustomDialogWtihEmoticonInput2.V.removeView(qQCustomDialogWtihEmoticonInput2.R);
                }
                QQCustomDialogWtihEmoticonInput qQCustomDialogWtihEmoticonInput3 = QQCustomDialogWtihEmoticonInput.this;
                qQCustomDialogWtihEmoticonInput3.X = false;
                WindowManager.LayoutParams attributes = qQCustomDialogWtihEmoticonInput3.getWindow().getAttributes();
                attributes.y = 0;
                QQCustomDialogWtihEmoticonInput.this.getWindow().setAttributes(attributes);
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class e implements IEmoticonMainPanel.DispatchKeyEventListener {
        e() {
        }

        @Override // com.tencent.mobileqq.emoticonview.IEmoticonMainPanel.DispatchKeyEventListener
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 1) {
                QQCustomDialogWtihEmoticonInput qQCustomDialogWtihEmoticonInput = QQCustomDialogWtihEmoticonInput.this;
                if (qQCustomDialogWtihEmoticonInput.X) {
                    qQCustomDialogWtihEmoticonInput.V.removeView(qQCustomDialogWtihEmoticonInput.S.getView());
                    QQCustomDialogWtihEmoticonInput qQCustomDialogWtihEmoticonInput2 = QQCustomDialogWtihEmoticonInput.this;
                    qQCustomDialogWtihEmoticonInput2.X = false;
                    WindowManager.LayoutParams attributes = qQCustomDialogWtihEmoticonInput2.getWindow().getAttributes();
                    attributes.y = 0;
                    QQCustomDialogWtihEmoticonInput.this.getWindow().setAttributes(attributes);
                    QQCustomDialogWtihEmoticonInput.this.n0();
                    return true;
                }
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class f implements SystemEmoticonPanel.DispatchKeyEventListener {
        f() {
        }

        @Override // com.tencent.mobileqq.emoticonview.SystemEmoticonPanel.DispatchKeyEventListener
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 1) {
                QQCustomDialogWtihEmoticonInput qQCustomDialogWtihEmoticonInput = QQCustomDialogWtihEmoticonInput.this;
                if (qQCustomDialogWtihEmoticonInput.X) {
                    qQCustomDialogWtihEmoticonInput.V.removeView(qQCustomDialogWtihEmoticonInput.R);
                    QQCustomDialogWtihEmoticonInput qQCustomDialogWtihEmoticonInput2 = QQCustomDialogWtihEmoticonInput.this;
                    qQCustomDialogWtihEmoticonInput2.X = false;
                    WindowManager.LayoutParams attributes = qQCustomDialogWtihEmoticonInput2.getWindow().getAttributes();
                    attributes.y = 0;
                    QQCustomDialogWtihEmoticonInput.this.getWindow().setAttributes(attributes);
                    QQCustomDialogWtihEmoticonInput.this.n0();
                    return true;
                }
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class g implements ViewTreeObserver.OnGlobalLayoutListener {
        g() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            ScrollView scrollView = QQCustomDialogWtihEmoticonInput.this.Z;
            if (scrollView != null) {
                scrollView.fullScroll(130);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class i implements EmoticonCallback {
        i() {
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void delete() {
            if (QQCustomDialogWtihEmoticonInput.this.L.getSelectionStart() == 0) {
                return;
            }
            try {
                Editable text = QQCustomDialogWtihEmoticonInput.this.L.getText();
                int selectionStart = QQCustomDialogWtihEmoticonInput.this.L.getSelectionStart();
                int offsetBefore = TextUtils.getOffsetBefore(QQCustomDialogWtihEmoticonInput.this.L.getText(), selectionStart);
                if (selectionStart != offsetBefore) {
                    text.delete(Math.min(selectionStart, offsetBefore), Math.max(selectionStart, offsetBefore));
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public boolean onLongClick(EmoticonInfo emoticonInfo) {
            return true;
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void send() {
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void send(EmoticonInfo emoticonInfo) {
            if (emoticonInfo instanceof SystemEmoticonInfo) {
                int selectionStart = QQCustomDialogWtihEmoticonInput.this.L.getSelectionStart();
                int selectionEnd = QQCustomDialogWtihEmoticonInput.this.L.getSelectionEnd();
                if (selectionStart < 0 || selectionEnd < 0 || selectionEnd < selectionStart) {
                    return;
                }
                QQCustomDialogWtihEmoticonInput.this.L.getEditableText().replace(selectionStart, selectionEnd, com.tencent.mobileqq.text.TextUtils.getSysEmotcationString(((SystemEmoticonInfo) emoticonInfo).code));
                return;
            }
            if (emoticonInfo instanceof SystemAndEmojiEmoticonInfo) {
                SystemAndEmojiEmoticonInfo systemAndEmojiEmoticonInfo = (SystemAndEmojiEmoticonInfo) emoticonInfo;
                int selectionStart2 = QQCustomDialogWtihEmoticonInput.this.L.getSelectionStart();
                int selectionEnd2 = QQCustomDialogWtihEmoticonInput.this.L.getSelectionEnd();
                int i3 = systemAndEmojiEmoticonInfo.emotionType;
                int i16 = systemAndEmojiEmoticonInfo.code;
                if (selectionStart2 >= 0 && selectionEnd2 >= 0 && selectionEnd2 >= selectionStart2) {
                    if (i3 == 2 && i16 == -1) {
                        return;
                    }
                    QQCustomDialogWtihEmoticonInput.this.L.getEditableText().replace(selectionStart2, selectionEnd2, i3 == 1 ? com.tencent.mobileqq.text.TextUtils.getSysEmotcationString(i16) : com.tencent.mobileqq.text.TextUtils.getEmojiString(i16));
                    QQCustomDialogWtihEmoticonInput.this.L.requestFocus();
                }
                if (QQCustomDialogWtihEmoticonInput.this.M) {
                    systemAndEmojiEmoticonInfo.addToCommonUsed((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime(), (Parcelable) null);
                }
                QQSysAndEmojiResMgr.getInstance().getResImpl(i3).reportEmoClick(i16, 5);
            }
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void emoticonMall() {
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void setting() {
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void onHidePopup(EmoticonInfo emoticonInfo) {
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void onShowPopup(EmoticonInfo emoticonInfo, EmoticonInfo emoticonInfo2, Drawable drawable) {
        }
    }

    public QQCustomDialogWtihEmoticonInput(Context context, int i3) {
        super(context, i3);
        int i16;
        this.M = true;
        this.N = false;
        this.P = 1;
        this.Q = null;
        this.R = null;
        this.S = null;
        this.T = new Handler();
        this.U = null;
        this.f307185c0 = new c();
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        if (attributes != null) {
            attributes.gravity = 17;
        }
        this.K = new SoftReference<>(context);
        this.U = context.getResources();
        getWindow().setSoftInputMode(19);
        this.V = (WindowManager) context.getSystemService("window");
        boolean z16 = MobileQQ.sProcessId == 1;
        this.M = z16;
        if (z16) {
            i16 = eg.i(0);
        } else {
            i16 = (int) (this.U.getDisplayMetrics().density * 150.0f);
        }
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-1, i16, 2, 32, -1);
        this.W = layoutParams;
        layoutParams.gravity = 81;
        layoutParams.windowAnimations = R.style.f173457dx;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean m0() {
        Context context = this.K.get();
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n0() {
        ViewGroup.LayoutParams layoutParams = this.Y.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = -2;
            this.Y.requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o0(boolean z16) {
        int i3;
        String str;
        if (z16) {
            i3 = R.drawable.forward_dialog_new_edit_emoji;
            str = "\u6253\u5f00\u8868\u60c5\u9762\u677f";
        } else {
            i3 = R.drawable.forward_dialog_new_edit_keyboard;
            str = "\u6253\u5f00\u952e\u76d8";
        }
        this.Q.setImageResource(i3);
        this.Q.setTag(Integer.valueOf(i3));
        this.Q.setContentDescription(str);
    }

    @Override // com.tencent.mobileqq.utils.cw, com.tencent.mobileqq.utils.QQCustomDialog, com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        IEmoticonMainPanel iEmoticonMainPanel = this.S;
        if (iEmoticonMainPanel != null) {
            iEmoticonMainPanel.onDestory();
        }
    }

    @Override // com.tencent.mobileqq.utils.QQCustomDialog
    public String getEditString() {
        EditText editText = this.L;
        if (editText == null) {
            return null;
        }
        String obj = editText.getText().toString();
        if (TextUtils.isEmpty(obj)) {
            return this.L.getHint().toString();
        }
        return obj;
    }

    @Override // com.tencent.mobileqq.utils.QQCustomDialog
    public EditText getEditText() {
        return this.L;
    }

    @Override // com.tencent.mobileqq.utils.QQCustomDialog
    public String getInputValue() {
        return this.L.getText().toString();
    }

    @Override // com.tencent.mobileqq.utils.QQCustomDialog
    public void hideSoftInputFromWindow() {
        if (this.L != null) {
            ((InputMethodManager) getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).hideSoftInputFromWindow(this.L.getWindowToken(), 0);
        }
    }

    void i0(Context context) {
        i iVar = new i();
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        boolean z16 = true;
        if (runtime instanceof QQAppInterface) {
            int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.title_bar_height);
            IEmoticonMainPanelService.PanelBuilder callBack = ((IEmoticonMainPanelService) ((QQAppInterface) runtime).getRuntimeService(IEmoticonMainPanelService.class)).newBuilder(getContext(), 100003).setCallBack(iVar);
            if (this.P != 7) {
                z16 = false;
            }
            IEmoticonMainPanel create = callBack.setOnlySysAndEmoji(z16).setToastOffset(dimensionPixelSize).create();
            this.S = create;
            create.hideAllTabs();
            this.W.height = this.f307183a0;
            return;
        }
        QLog.e("QQCustomDialogWtihEmoticonInput", 1, "get QQAppInterface fail");
        if (this.P == 7) {
            this.R = new SystemAndEmojiEmoticonPanel(context, iVar);
        } else {
            this.R = new SystemEmoticonPanel(context, iVar);
        }
    }

    public String j0() {
        QQTextBuilder qQTextBuilder;
        EditText editText = this.L;
        if (editText == null) {
            return "";
        }
        if (editText.getText() instanceof com.tencent.mobileqq.text.o) {
            com.tencent.mobileqq.text.o oVar = (com.tencent.mobileqq.text.o) this.L.getText();
            if (oVar != null) {
                return oVar.toPlainText();
            }
        } else if ((this.L.getText() instanceof QQTextBuilder) && (qQTextBuilder = (QQTextBuilder) this.L.getText()) != null) {
            return qQTextBuilder.toPlainText();
        }
        return this.L.getEditableText().toString();
    }

    int k0(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return iArr[1];
    }

    public void l0() {
        RelativeLayout relativeLayout;
        if (this.M) {
            relativeLayout = this.S.getView();
        } else {
            relativeLayout = this.R;
        }
        if (this.X && relativeLayout != null) {
            this.V.removeView(relativeLayout);
            this.X = false;
            n0();
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.y = 0;
        getWindow().setAttributes(attributes);
        InputMethodUtil.hide(this.L);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        final RelativeLayout relativeLayout;
        EventCollector.getInstance().onViewClickedBefore(view);
        if (this.M) {
            relativeLayout = this.S.getView();
        } else {
            relativeLayout = this.R;
        }
        if (view.getId() == R.id.emo_btn) {
            if (relativeLayout != null) {
                if (this.X) {
                    n0();
                    this.V.removeView(relativeLayout);
                    this.X = false;
                    o0(true);
                    this.T.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.utils.QQCustomDialogWtihEmoticonInput.8
                        @Override // java.lang.Runnable
                        public void run() {
                            InputMethodUtil.show(QQCustomDialogWtihEmoticonInput.this.L);
                        }
                    }, 200L);
                    WindowManager.LayoutParams attributes = getWindow().getAttributes();
                    attributes.y = 0;
                    getWindow().setAttributes(attributes);
                } else {
                    Object tag = this.Q.getTag();
                    if (tag != null && (tag instanceof Integer) && ((Integer) tag).intValue() == R.drawable.forward_dialog_new_edit_keyboard) {
                        InputMethodUtil.show(this.L);
                        o0(true);
                        this.X = false;
                    } else {
                        InputMethodUtil.hide(this.L);
                        o0(false);
                        if (this.M) {
                            relativeLayout.setMinimumHeight(eg.i(0));
                        }
                        this.T.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.utils.QQCustomDialogWtihEmoticonInput.9
                            @Override // java.lang.Runnable
                            public void run() {
                                if (QQCustomDialogWtihEmoticonInput.this.m0()) {
                                    return;
                                }
                                QQCustomDialogWtihEmoticonInput qQCustomDialogWtihEmoticonInput = QQCustomDialogWtihEmoticonInput.this;
                                if (qQCustomDialogWtihEmoticonInput.X) {
                                    return;
                                }
                                qQCustomDialogWtihEmoticonInput.V.addView(relativeLayout, qQCustomDialogWtihEmoticonInput.W);
                                QQCustomDialogWtihEmoticonInput.this.X = true;
                                relativeLayout.post(new Runnable() { // from class: com.tencent.mobileqq.utils.QQCustomDialogWtihEmoticonInput.9.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        int i3;
                                        int dip2px;
                                        int i16;
                                        int i17;
                                        ViewGroup.LayoutParams layoutParams;
                                        AnonymousClass9 anonymousClass9 = AnonymousClass9.this;
                                        int k06 = QQCustomDialogWtihEmoticonInput.this.k0(relativeLayout);
                                        QQCustomDialogWtihEmoticonInput qQCustomDialogWtihEmoticonInput2 = QQCustomDialogWtihEmoticonInput.this;
                                        int k07 = qQCustomDialogWtihEmoticonInput2.k0(qQCustomDialogWtihEmoticonInput2.Y);
                                        int height = QQCustomDialogWtihEmoticonInput.this.Y.getHeight();
                                        int i18 = k07 + height;
                                        if (k06 - i18 > 0) {
                                            i16 = relativeLayout.getHeight() / 2;
                                        } else {
                                            QQCustomDialogWtihEmoticonInput qQCustomDialogWtihEmoticonInput3 = QQCustomDialogWtihEmoticonInput.this;
                                            if (qQCustomDialogWtihEmoticonInput3.M) {
                                                int statusBarHeight = ImmersiveUtils.getStatusBarHeight(qQCustomDialogWtihEmoticonInput3.getContext());
                                                int i19 = (((k06 - height) - statusBarHeight) / 2) + statusBarHeight;
                                                if (i19 < k07) {
                                                    i16 = k07 - i19;
                                                } else {
                                                    i3 = i18 - k06;
                                                    dip2px = ViewUtils.dip2px(10.0f);
                                                }
                                            } else {
                                                i3 = i18 - k06;
                                                dip2px = ViewUtils.dip2px(10.0f);
                                            }
                                            i16 = i3 + dip2px;
                                        }
                                        WindowManager.LayoutParams attributes2 = QQCustomDialogWtihEmoticonInput.this.getWindow().getAttributes();
                                        attributes2.y = -i16;
                                        QQCustomDialogWtihEmoticonInput.this.getWindow().setAttributes(attributes2);
                                        if (i16 > k07 && (layoutParams = QQCustomDialogWtihEmoticonInput.this.Y.getLayoutParams()) != null) {
                                            layoutParams.height = (k06 - ImmersiveUtils.getStatusBarHeight(QQCustomDialogWtihEmoticonInput.this.getContext())) - ViewUtils.dip2px(10.0f);
                                            QQCustomDialogWtihEmoticonInput.this.Y.requestLayout();
                                        }
                                        if (QLog.isColorLevel()) {
                                            Context context = QQCustomDialogWtihEmoticonInput.this.K.get();
                                            if (context != null) {
                                                i17 = context.getResources().getDisplayMetrics().heightPixels;
                                            } else {
                                                i17 = 0;
                                            }
                                            StringBuilder sb5 = new StringBuilder(128);
                                            if (context == null) {
                                                sb5.append("|context is null");
                                            } else {
                                                sb5.append("|context is not null");
                                            }
                                            sb5.append("|screenHeight=");
                                            sb5.append(i17);
                                            sb5.append("|emoSpaceY=");
                                            sb5.append(k06);
                                            sb5.append("|dialogY=");
                                            sb5.append(k07);
                                            sb5.append("|dialogHeight=");
                                            sb5.append(height);
                                            sb5.append("|moveY=");
                                            sb5.append(i16);
                                            QLog.d("QQCustomDialogWtihEmoticonInput.meassure", 2, sb5.toString());
                                        }
                                    }
                                });
                            }
                        }, 200L);
                    }
                }
            }
        } else {
            if (this.X) {
                this.V.removeView(relativeLayout);
                this.X = false;
                n0();
            }
            WindowManager.LayoutParams attributes2 = getWindow().getAttributes();
            attributes2.y = 0;
            getWindow().setAttributes(attributes2);
            InputMethodUtil.hide(this.L);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void onDismiss(DialogInterface dialogInterface) {
        eg egVar = this.f307184b0;
        if (egVar != null) {
            egVar.h();
        }
    }

    @Override // android.app.Dialog
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() != 1) {
            return super.onTouchEvent(motionEvent);
        }
        if (this.X) {
            if (this.M) {
                this.V.removeView(this.S.getView());
            } else {
                this.V.removeView(this.R);
            }
            this.X = false;
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.y = 0;
            getWindow().setAttributes(attributes);
            n0();
        }
        InputMethodUtil.hide(this.L);
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void p0(int i3) {
        this.P = i3;
    }

    public void q0(String str) {
        if (str != null) {
            this.L.setText(str);
        }
    }

    public void r0(int i3) {
        EditText editText = this.L;
        if (editText != null) {
            editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(i3)});
            this.L.addTextChangedListener(new h(i3));
        }
    }

    public void s0() {
        EditText editText = this.L;
        if (editText != null) {
            editText.setEditableFactory(com.tencent.mobileqq.text.o.f292704d);
        }
    }

    @Override // com.tencent.mobileqq.utils.cw, com.tencent.mobileqq.utils.QQCustomDialog, android.app.Dialog
    @TargetApi(11)
    public void setContentView(int i3) {
        super.setContentView(i3);
        this.Y = (RelativeLayout) findViewById(R.id.bja);
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("100234", false)) {
            ak.f(this.Y, ViewUtils.dpToPx(6.0f));
        }
        this.L = (EditText) findViewById(R.id.input);
        ImageView imageView = (ImageView) findViewById(R.id.emo_btn);
        this.Q = imageView;
        imageView.setOnClickListener(this);
        o0(true);
        findViewById(R.id.iie).setOnClickListener(this);
        this.L.setEditableFactory(QQTextBuilder.EMOTION_INPUT_FACTORY);
        this.L.setSingleLine(this.N);
        this.L.setOnTouchListener(new d());
        Context context = this.K.get();
        if (context == null) {
            return;
        }
        com.tencent.devicelib.a.a(context, this.L);
        if (this.M) {
            eg egVar = new eg(((ViewGroup) getWindow().getDecorView().findViewById(android.R.id.content)).getChildAt(0), this.V.getDefaultDisplay().getHeight(), this.f307185c0);
            this.f307184b0 = egVar;
            int k3 = egVar.k();
            this.f307183a0 = k3;
            this.f307183a0 = eg.i(k3);
            setOnDismissListener(this);
            i0(context);
            this.S.setDispatchKeyEventListener(new e());
        } else {
            i0(context);
            this.R.setBackgroundResource(R.drawable.aio_face_bg);
            this.R.setMinimumHeight(BaseAIOUtils.f(150.0f, this.U));
            this.R.setDispatchKeyEventListener(new f());
        }
        View findViewById = this.Y.findViewById(R.id.ii8);
        if (findViewById instanceof ScrollView) {
            this.Z = (ScrollView) findViewById;
        }
        this.Y.getViewTreeObserver().addOnGlobalLayoutListener(new g());
        try {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.Y.getLayoutParams();
            marginLayoutParams.setMargins(0, ViewUtils.dpToPx(5.0f), 0, ViewUtils.dpToPx(5.0f));
            this.Y.setLayoutParams(marginLayoutParams);
        } catch (Exception e16) {
            QLog.e("QQCustomDialogWtihEmoticonInput", 1, "setContentView error" + e16);
        }
    }

    @Override // com.tencent.mobileqq.utils.QQCustomDialog
    public void setEditLint(String str) {
        this.L.setHint(str);
    }

    @Override // com.tencent.mobileqq.utils.QQCustomDialog
    public QQCustomDialog setNegativeButton(int i3, DialogInterface.OnClickListener onClickListener) {
        if (onClickListener == null) {
            this.lBtn.setVisibility(8);
            return this;
        }
        hideSoftInputFromWindow();
        this.lBtn.setText(i3);
        this.lBtn.setContentDescription(getContext().getString(i3) + getContext().getString(R.string.a_n));
        this.lBtn.setVisibility(0);
        this.lBtn.setOnClickListener(new a(onClickListener));
        setSeperatorState();
        return this;
    }

    @Override // com.tencent.mobileqq.utils.QQCustomDialog
    public QQCustomDialog setPositiveButton(int i3, DialogInterface.OnClickListener onClickListener) {
        if (onClickListener == null) {
            this.rBtn.setVisibility(8);
            return this;
        }
        this.rBtn.setText(i3);
        AccessibilityUtil.c(this.rBtn, getContext().getString(i3), Button.class.getName());
        this.rBtn.setVisibility(0);
        this.rBtn.setOnClickListener(new b(onClickListener));
        setSeperatorState();
        return this;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0054  */
    @Override // com.tencent.mobileqq.utils.QQCustomDialog
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public QQCustomDialog setPreviewImage(Drawable drawable, boolean z16, int i3, boolean z17) {
        BitmapDrawable bitmapDrawable;
        Bitmap bitmap;
        if (drawable.getIntrinsicHeight() > drawable.getIntrinsicWidth()) {
            Drawable currDrawable = ((URLDrawable) drawable).getCurrDrawable();
            if ((currDrawable instanceof RegionDrawable) && (bitmap = ((RegionDrawable) currDrawable).getBitmap()) != null) {
                Matrix matrix = new Matrix();
                matrix.postScale(0.5f, 0.5f);
                Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
                if (createBitmap != null) {
                    bitmapDrawable = new BitmapDrawable(this.U, createBitmap);
                    bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
                    if (bitmapDrawable != null) {
                        return super.setPreviewImage(drawable, z16, i3, z17);
                    }
                    return super.setPreviewImage(bitmapDrawable, z16, i3, z17);
                }
            }
        }
        bitmapDrawable = null;
        if (bitmapDrawable != null) {
        }
    }

    public void u0(boolean z16) {
        this.N = z16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class h implements TextWatcher {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f307197d;

        h(int i3) {
            this.f307197d = i3;
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            int length = QQCustomDialogWtihEmoticonInput.this.L.getText().length();
            int i18 = this.f307197d;
            if (length == i18 && charSequence.charAt(i18 - 1) == 20) {
                QQCustomDialogWtihEmoticonInput.this.L.setText(charSequence.subSequence(0, this.f307197d - 1));
                QQCustomDialogWtihEmoticonInput.this.L.setSelection(this.f307197d - 1);
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }
    }
}
