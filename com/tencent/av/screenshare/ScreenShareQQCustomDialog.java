package com.tencent.av.screenshare;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.av.business.handler.SafetyHandler;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ScreenShareQQCustomDialog extends QQCustomDialog {
    private Handler C;
    private int D;
    private int E;
    private boolean F;
    private String G;
    private String H;
    private Boolean I;
    private long J;
    private String K;
    private int L;
    lu.b M;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class a extends lu.b {
        a() {
        }

        @Override // lu.b
        public void b(boolean z16, SafetyHandler.a aVar) {
            ScreenShareQQCustomDialog.this.m0();
            if (z16 && aVar != null && !TextUtils.isEmpty(aVar.f73275a)) {
                QLog.d("SafetyObserver", 1, "onUpdateGetSafetyRejectionInfo: mContent: " + aVar.f73275a);
                ScreenShareQQCustomDialog.this.setMessage(aVar.f73275a);
                ((QQCustomDialog) ScreenShareQQCustomDialog.this).rBtn.setEnabled(false);
                ScreenShareQQCustomDialog.this.L = 1;
            } else {
                QLog.d("SafetyObserver", 1, "onUpdateGetSafetyRejectionInfo: isSuccess\uff1a" + z16);
                ((QQCustomDialog) ScreenShareQQCustomDialog.this).rBtn.setEnabled(true);
                ScreenShareQQCustomDialog.this.L = 3;
            }
            ScreenShareQQCustomDialog.this.I = Boolean.TRUE;
            ScreenShareQQCustomDialog.this.p0("ev_bas_sharing_safety_tips");
        }

        @Override // lu.b
        public void c(boolean z16, SafetyHandler.b bVar) {
            ScreenShareQQCustomDialog.this.m0();
            if (ScreenShareQQCustomDialog.this.I.booleanValue()) {
                QLog.d("SafetyObserver", 1, "onUpdateGetSafetyWarningInfo: timeoutUpdate");
                return;
            }
            if (z16 && bVar != null && bVar.f73284g > 0) {
                QLog.d("SafetyObserver", 1, "onUpdateGetSafetyWarningInfo: mStayTimeInterval\uff1a" + bVar.f73284g);
                ScreenShareQQCustomDialog.this.D = bVar.f73284g;
                ScreenShareQQCustomDialog screenShareQQCustomDialog = ScreenShareQQCustomDialog.this;
                screenShareQQCustomDialog.E = screenShareQQCustomDialog.D;
                ScreenShareQQCustomDialog.this.F = true;
                ((QQCustomDialog) ScreenShareQQCustomDialog.this).rBtn.setText(String.format("%s(%d)", ScreenShareQQCustomDialog.this.H, Integer.valueOf(ScreenShareQQCustomDialog.this.D)));
                ((QQCustomDialog) ScreenShareQQCustomDialog.this).rBtn.setEnabled(false);
                ScreenShareQQCustomDialog.this.C.postDelayed(ScreenShareQQCustomDialog.this.k0(), 1000L);
                ScreenShareQQCustomDialog.this.L = 2;
            } else {
                QLog.d("SafetyObserver", 1, "onUpdateGetSafetyWarningInfo: isSuccess\uff1a" + z16);
                ((QQCustomDialog) ScreenShareQQCustomDialog.this).rBtn.setEnabled(true);
                ScreenShareQQCustomDialog.this.L = 3;
            }
            ScreenShareQQCustomDialog.this.I = Boolean.TRUE;
            ScreenShareQQCustomDialog.this.p0("ev_bas_sharing_safety_tips");
        }

        @Override // lu.b
        public void d(boolean z16, Object obj) {
            ScreenShareQQCustomDialog.this.m0();
            if (ScreenShareQQCustomDialog.this.I.booleanValue()) {
                QLog.d("SafetyObserver", 1, "onUpdateSafetyStatusAllowed: timeoutUpdate");
                return;
            }
            QLog.d("SafetyObserver", 1, "onUpdateSafetyStatusAllowed: isSuccess\uff1a" + z16);
            ((QQCustomDialog) ScreenShareQQCustomDialog.this).rBtn.setEnabled(true);
            ScreenShareQQCustomDialog.this.I = Boolean.TRUE;
            ScreenShareQQCustomDialog.this.L = 3;
            ScreenShareQQCustomDialog.this.p0("ev_bas_sharing_safety_tips");
        }
    }

    public ScreenShareQQCustomDialog(Context context, int i3, String str, String str2, boolean z16, int i16) {
        super(context, i3);
        this.C = new Handler(Looper.getMainLooper());
        this.I = Boolean.FALSE;
        this.J = -1L;
        this.L = 0;
        this.M = new a();
        this.D = i16;
        this.E = i16;
        this.F = z16;
        this.G = str;
        this.H = str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Runnable k0() {
        return new Runnable() { // from class: com.tencent.av.screenshare.ScreenShareQQCustomDialog.1
            @Override // java.lang.Runnable
            public void run() {
                ScreenShareQQCustomDialog screenShareQQCustomDialog = ScreenShareQQCustomDialog.this;
                screenShareQQCustomDialog.D--;
                ScreenShareQQCustomDialog.this.n0(this);
            }
        };
    }

    private Runnable l0() {
        return new Runnable() { // from class: com.tencent.av.screenshare.ScreenShareQQCustomDialog.2
            @Override // java.lang.Runnable
            public void run() {
                if (!ScreenShareQQCustomDialog.this.I.booleanValue()) {
                    ((QQCustomDialog) ScreenShareQQCustomDialog.this).rBtn.setEnabled(true);
                    ScreenShareQQCustomDialog.this.I = Boolean.TRUE;
                    QLog.d("ScreenShareQQCustomDialog", 1, "SafetyTimeout Run");
                    ScreenShareQQCustomDialog.this.p0("ev_bas_sharing_safety_tips");
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m0() {
        if (this.J > 0) {
            QLog.i("ScreenShareQQCustomDialog", 2, "ScreenShareSafeCheckTimeCost: " + (System.currentTimeMillis() - this.J) + " ms");
            this.J = -1L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n0(Runnable runnable) {
        if (this.D > 0) {
            this.lBtn.setText(this.G);
            this.rBtn.setText(String.format("%s(%d)", this.H, Integer.valueOf(this.D)));
            this.C.postDelayed(runnable, 1000L);
        } else {
            this.lBtn.setText(this.G);
            this.rBtn.setText(this.H);
            this.D = this.E;
            this.rBtn.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p0(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("user_security_type", Integer.valueOf(this.L));
        if (!TextUtils.isEmpty(this.K)) {
            hashMap.put("to_uin", Long.valueOf(this.K));
        }
        VideoReport.reportEvent(str, hashMap);
    }

    @Override // com.tencent.mobileqq.utils.QQCustomDialog, com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        this.C.removeCallbacksAndMessages(null);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            ((AppInterface) peekAppRuntime).removeObserver(this.M);
        }
    }

    public void o0() {
        p0("ev_bas_continue_share");
    }

    public void q0(Typeface typeface, ColorStateList colorStateList) {
        this.title.setTypeface(typeface);
        this.text.setHighlightColor(getContext().getResources().getColor(17170445));
        this.lBtn.setTextColor(colorStateList);
        this.rBtn.setTextColor(colorStateList);
    }

    public void r0(String str, int i3, String str2, boolean z16) {
        QLog.d("ScreenShareQQCustomDialog", 1, "showWithSafetyCheckrelationType:" + i3 + "relationId:" + str2 + "isFirstShow:" + z16);
        this.K = str2;
        if (yt.b.e("exp_secure_screen_sharing_3m_time_limit")) {
            QLog.d("ScreenShareQQCustomDialog", 1, "showWithSafetyCheck experiment: hasExperiment");
            super.show();
            this.lBtn.setText(this.G);
            this.lBtn.setEnabled(true);
            this.rBtn.setText(this.H);
            this.rBtn.setEnabled(false);
            this.J = System.currentTimeMillis();
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null && AppInterface.class.isInstance(peekAppRuntime)) {
                AppInterface appInterface = (AppInterface) peekAppRuntime;
                ((SafetyHandler) appInterface.getBusinessHandler(SafetyHandler.class.getName())).G2(str, i3, str2, z16);
                appInterface.addObserver(this.M);
                this.I = Boolean.FALSE;
                this.C.postDelayed(l0(), 2000L);
                yt.b.g("exp_secure_screen_sharing_3m_time_limit");
                return;
            }
            QLog.w("ScreenShareQQCustomDialog", 1, "showWithSafetyCheck: get appInterface fail!");
            this.rBtn.setEnabled(true);
            return;
        }
        if (yt.b.d("exp_secure_screen_sharing_3m_time_limit")) {
            QLog.d("ScreenShareQQCustomDialog", 1, "showWithSafetyCheck experiment: hasContrast");
            show();
            yt.b.g("exp_secure_screen_sharing_3m_time_limit");
            p0("ev_bas_sharing_safety_tips");
            return;
        }
        QLog.d("ScreenShareQQCustomDialog", 1, "showWithSafetyCheck experiment: else");
        show();
        p0("ev_bas_sharing_safety_tips");
    }

    @Override // com.tencent.mobileqq.utils.QQCustomDialog, com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog
    public void show() {
        QLog.d("ScreenShareQQCustomDialog", 1, "show");
        super.show();
        if (this.F && this.D > 0) {
            this.lBtn.setText(this.G);
            this.lBtn.setEnabled(true);
            this.rBtn.setText(String.format("%s(%d)", this.H, Integer.valueOf(this.D)));
            this.rBtn.setEnabled(false);
            this.C.postDelayed(k0(), 1000L);
        }
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
    }
}
