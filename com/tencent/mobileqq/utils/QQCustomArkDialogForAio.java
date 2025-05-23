package com.tencent.mobileqq.utils;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.ark.ArkViewImplement;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.ArkAppContainer;
import com.tencent.mobileqq.activity.aio.item.ArkAppLoadLayout;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQCustomArkDialogUtil;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes20.dex */
public class QQCustomArkDialogForAio extends QQCustomDialog {
    ArkAppView C;
    ArkAppContainer D;
    ArkAppLoadLayout E;
    int F;
    int G;
    int H;
    int I;
    int J;
    int K;
    int L;
    private ArkAppContainer.b M;
    private ArkViewImplement.LoadCallback N;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a implements ArkAppContainer.b {
        a() {
        }

        @Override // com.tencent.mobileqq.activity.aio.item.ArkAppContainer.b
        public boolean Fb(ArkAppContainer arkAppContainer) {
            if (QQCustomArkDialogForAio.this.isShowing()) {
                QQCustomArkDialogForAio.this.dismiss();
                return true;
            }
            return false;
        }

        @Override // com.tencent.mobileqq.activity.aio.item.ArkAppContainer.b
        public boolean U1(ArkAppContainer arkAppContainer, String str, String str2) {
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public String f307124a;

        /* renamed from: b, reason: collision with root package name */
        public String f307125b;

        /* renamed from: c, reason: collision with root package name */
        public String f307126c;

        /* renamed from: d, reason: collision with root package name */
        public String f307127d;

        /* renamed from: e, reason: collision with root package name */
        public String f307128e;

        /* renamed from: f, reason: collision with root package name */
        public float f307129f;

        /* renamed from: h, reason: collision with root package name */
        public ArkAppContainer f307131h = null;

        /* renamed from: i, reason: collision with root package name */
        public String f307132i = "";

        /* renamed from: j, reason: collision with root package name */
        public boolean f307133j = false;

        /* renamed from: g, reason: collision with root package name */
        public SessionInfo f307130g = new SessionInfo();

        public b(Bundle bundle) {
            this.f307124a = bundle.getString("appName");
            this.f307125b = bundle.getString(QQCustomArkDialogUtil.APP_VIEW);
            this.f307126c = bundle.getString(QQCustomArkDialogUtil.BIZ_SRC);
            this.f307127d = bundle.getString(QQCustomArkDialogUtil.APP_MIN_VERSION);
            this.f307128e = bundle.getString(QQCustomArkDialogUtil.META_DATA);
            this.f307129f = bundle.getFloat("scale", 1.0f);
            String string = bundle.getString("troopUin");
            if (string != null) {
                SessionInfo sessionInfo = this.f307130g;
                sessionInfo.f179555d = 1;
                sessionInfo.f179557e = string;
            }
        }
    }

    public QQCustomArkDialogForAio(Context context, int i3) {
        super(context, i3);
        this.F = 0;
        this.G = 0;
        this.H = 0;
        this.I = 0;
        this.J = 0;
        this.K = 0;
        this.L = -1;
        this.M = new a();
        this.N = new ArkViewImplement.LoadCallback() { // from class: com.tencent.mobileqq.utils.QQCustomArkDialogForAio.2
            @Override // com.tencent.ark.ArkViewImplement.LoadCallback
            public void onLoadFailed(int i16, int i17, String str, boolean z16) {
                onLoadState(i16);
            }

            @Override // com.tencent.ark.ArkViewImplement.LoadCallback
            public void onLoadState(final int i16) {
                final WeakReference weakReference = new WeakReference(QQCustomArkDialogForAio.this);
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.utils.QQCustomArkDialogForAio.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        QQCustomArkDialogForAio qQCustomArkDialogForAio = (QQCustomArkDialogForAio) weakReference.get();
                        if (qQCustomArkDialogForAio != null) {
                            qQCustomArkDialogForAio.S(i16);
                        }
                    }
                });
            }
        };
    }

    private ArkAppContainer P(b bVar) {
        int i3;
        this.D = new com.tencent.mobileqq.activity.aio.item.b();
        int width = this.C.getWidth();
        int height = this.C.getHeight();
        if (QLog.isDebugVersion()) {
            QLog.d("QQCustomArkDialog", 4, "w=" + width + ",h=" + height + ", appName:" + bVar.f307124a);
        }
        this.D.h(bVar.f307124a, bVar.f307125b, bVar.f307126c, bVar.f307127d, bVar.f307128e, bVar.f307129f, bVar.f307130g);
        int i16 = this.J;
        if (i16 != 0 && (i3 = this.K) != 0) {
            this.D.setFixSize(i16, i3);
        } else {
            this.D.setFixSize(this.I, this.L);
            this.D.setMaxSize(this.I, this.F);
            this.D.setMinSize(this.G, this.H);
        }
        com.tencent.mobileqq.ark.module.b.f199564k = false;
        return this.D;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q(Bundle bundle) {
        ArkAppContainer P = P(new b(bundle));
        P.a(this.M);
        if (QLog.isColorLevel()) {
            QLog.w("QQCustomArkDialog", 2, "init");
        }
        this.C.a(P, this.E);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S(int i3) {
        if (i3 != 1) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.E.getLayoutParams();
            layoutParams.addRule(14);
            int i16 = this.I;
            layoutParams.width = i16;
            layoutParams.height = i16;
            layoutParams.setMargins(0, 0, 0, 0);
            this.rBtn.setEnabled(false);
            this.rBtn.setTextColor(Color.parseColor("#656565"));
            return;
        }
        this.rBtn.setEnabled(true);
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x023c  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:59:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0240  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void R(Context context, final Bundle bundle) {
        RelativeLayout.LayoutParams layoutParams;
        int i3;
        LinearLayout linearLayout;
        Activity activity;
        MessageForArkApp.Size limitToSizeRange;
        try {
            getWindow().setFlags(16777216, 16777216);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.w("QQCustomArkDialog", 2, e16.getMessage());
            }
        }
        if (QLog.isColorLevel()) {
            QLog.i("QQCustomArkDialog", 2, "initArkView:" + bundle);
        }
        setContentView(R.layout.f167856jn);
        View inflate = LayoutInflater.from(context).inflate(R.layout.f167726f7, (ViewGroup) null);
        inflate.setPadding(0, 0, 0, 0);
        this.C = (ArkAppView) inflate.findViewById(R.id.y_);
        this.E = (ArkAppLoadLayout) inflate.findViewById(R.id.eet);
        inflate.findViewById(R.id.f164471yu).setPadding(0, 0, 0, 0);
        ((LinearLayout) inflate.findViewById(R.id.f164456yf)).setVisibility(8);
        this.C.setBorderType(0);
        this.C.setLoadCallback(this.N);
        boolean z16 = bundle.getBoolean("is_ark_display_share", false);
        if (QLog.isColorLevel()) {
            QLog.d("QQCustomArkDialog", 2, "from Forward:" + z16);
        }
        ArkAppMessage.Config config = new ArkAppMessage.Config();
        String string = bundle.getString(AppConstants.Key.FORWARD_ARK_APP_CONFIG);
        if (!TextUtils.isEmpty(string)) {
            config.fromString(string);
        }
        if (IndividuationUrlHelper.UrlId.CARD_HOME.equals(config.type)) {
            this.L = BaseChatItemLayout.M;
        }
        boolean isSetSizeByConfig = MessageForArkApp.isSetSizeByConfig(config);
        if (isSetSizeByConfig && (limitToSizeRange = MessageForArkApp.limitToSizeRange(com.tencent.mobileqq.ark.f.c(), config.width.intValue(), config.height.intValue())) != null) {
            this.J = limitToSizeRange.width;
            Integer num = config.autoSize;
            if (num != null && num.intValue() == 1) {
                this.J = BaseChatItemLayout.M;
            }
            this.K = limitToSizeRange.height;
            if (QLog.isColorLevel()) {
                float c16 = com.tencent.mobileqq.ark.f.c();
                QLog.d("QQCustomArkDialog", 2, "width_from_sdk:" + config.width + ", height_from_sdk:" + config.height + ", scale:" + c16 + ", realwidth:" + ((int) (limitToSizeRange.width / c16)) + ", realheight:" + ((int) (limitToSizeRange.height / c16)));
            }
        }
        LinearLayout linearLayout2 = this.bodyLayout;
        if (linearLayout2 != null) {
            layoutParams = (RelativeLayout.LayoutParams) linearLayout2.getLayoutParams();
        } else {
            layoutParams = null;
        }
        this.rootView.setPadding(0, 0, 0, 0);
        if (!z16) {
            View findViewById = findViewById(R.id.aew);
            if (findViewById != null) {
                findViewById.setVisibility(8);
            }
            ArkAppView arkAppView = this.C;
            arkAppView.setOnTouchListener(arkAppView);
            View findViewById2 = findViewById(R.id.bif);
            if (findViewById2 != null) {
                findViewById2.setVisibility(8);
            }
            View findViewById3 = findViewById(R.id.biw);
            if (findViewById3 != null) {
                findViewById3.setVisibility(8);
            }
            if (layoutParams != null && this.bodyLayout != null) {
                layoutParams.setMargins(0, 0, 0, 0);
                this.bodyLayout.setLayoutParams(layoutParams);
            }
        } else if (layoutParams != null) {
            i3 = layoutParams.leftMargin + layoutParams.rightMargin;
            if (QLog.isColorLevel()) {
                QLog.d("QQCustomArkDialog", 2, "margin=" + i3);
            }
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
            int dp2px = MessageForArkApp.dp2px(1.0f);
            layoutParams2.setMargins(dp2px, dp2px, dp2px, dp2px);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setStroke(dp2px, 436207616);
            linearLayout = this.bodyLayout;
            if (linearLayout != null) {
                if (!isSetSizeByConfig) {
                    linearLayout.setBackgroundDrawable(gradientDrawable);
                }
                addCenterView(inflate, layoutParams2);
            }
            this.F = MessageForArkApp.dp2px(390.0f);
            this.G = MessageForArkApp.dp2px(30.0f);
            this.H = MessageForArkApp.dp2px(30.0f);
            this.I = (MessageForArkApp.dp2px(296.0f) - i3) - (dp2px * 2);
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.E.getLayoutParams();
            layoutParams3.addRule(14);
            int i16 = this.I;
            layoutParams3.width = i16;
            layoutParams3.height = i16;
            layoutParams3.setMargins(0, 0, 0, 0);
            this.C.post(new Runnable() { // from class: com.tencent.mobileqq.utils.QQCustomArkDialogForAio.3
                @Override // java.lang.Runnable
                public void run() {
                    QQCustomArkDialogForAio.this.Q(bundle);
                }
            });
            ArkAppView arkAppView2 = this.C;
            arkAppView2.setInputHolderAnchor((ViewGroup) arkAppView2.getRootView());
            if (!(context instanceof Activity)) {
                activity = (Activity) context;
            } else {
                activity = null;
            }
            if (activity == null) {
                com.tencent.mobileqq.ark.o.b(activity, this.C);
                return;
            }
            return;
        }
        i3 = 0;
        LinearLayout.LayoutParams layoutParams22 = new LinearLayout.LayoutParams(-1, -2);
        int dp2px2 = MessageForArkApp.dp2px(1.0f);
        layoutParams22.setMargins(dp2px2, dp2px2, dp2px2, dp2px2);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setStroke(dp2px2, 436207616);
        linearLayout = this.bodyLayout;
        if (linearLayout != null) {
        }
        this.F = MessageForArkApp.dp2px(390.0f);
        this.G = MessageForArkApp.dp2px(30.0f);
        this.H = MessageForArkApp.dp2px(30.0f);
        this.I = (MessageForArkApp.dp2px(296.0f) - i3) - (dp2px2 * 2);
        RelativeLayout.LayoutParams layoutParams32 = (RelativeLayout.LayoutParams) this.E.getLayoutParams();
        layoutParams32.addRule(14);
        int i162 = this.I;
        layoutParams32.width = i162;
        layoutParams32.height = i162;
        layoutParams32.setMargins(0, 0, 0, 0);
        this.C.post(new Runnable() { // from class: com.tencent.mobileqq.utils.QQCustomArkDialogForAio.3
            @Override // java.lang.Runnable
            public void run() {
                QQCustomArkDialogForAio.this.Q(bundle);
            }
        });
        ArkAppView arkAppView22 = this.C;
        arkAppView22.setInputHolderAnchor((ViewGroup) arkAppView22.getRootView());
        if (!(context instanceof Activity)) {
        }
        if (activity == null) {
        }
    }

    @Override // com.tencent.mobileqq.utils.QQCustomDialog, com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        ArkAppContainer arkAppContainer = this.D;
        if (arkAppContainer != null) {
            arkAppContainer.doOnEvent(2);
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQCustomArkDialog", 2, "dismiss");
        }
        com.tencent.mobileqq.ark.module.b.f199564k = true;
        super.dismiss();
    }

    @Override // android.app.Dialog
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.C != null && motionEvent.getAction() == 0 && (motionEvent.getX() < this.C.getX() - 10.0f || motionEvent.getX() > this.C.getX() + this.C.getWidth() + 10.0f || motionEvent.getY() < this.C.getY() - 10.0f || motionEvent.getY() > this.C.getY() + this.C.getHeight() + 10.0f)) {
            this.C.mViewImpl.resetInputState();
            InputMethodManager inputMethodManager = (InputMethodManager) this.C.getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
            if (inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(this.C.getWindowToken(), 0);
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.app.Dialog
    public void setOnDismissListener(@Nullable DialogInterface.OnDismissListener onDismissListener) {
        super.setOnDismissListener(onDismissListener);
    }
}
