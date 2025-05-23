package com.qwallet.activity.patternlock.biz;

import Wallet.GetPasswordRsp;
import Wallet.GetSignV2Rsp;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager;
import com.qwallet.activity.QvipPayFullScreenRealAuthActivity;
import com.qwallet.activity.patternlock.PatternLockActivity;
import com.qwallet.protocol.Wallet.PatternLock.SetPasswordRsp;
import com.qwallet.utils.QWalletUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.GesturePWDUnlockActivity;
import com.tencent.mobileqq.msf.core.c0.j;
import com.tencent.mobileqq.qwallet.utils.g;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.ipc.IPCConst;
import com.tenpay.api.TenpayInterface;
import cooperation.qwallet.plugin.IActivity;
import cooperation.qwallet.plugin.IQWalletHelper;
import cooperation.qwallet.plugin.PatternLockUtils;
import cooperation.qwallet.plugin.impl.QWalletHelperDelegate;
import cooperation.qwallet.plugin.ipc.TickReq;
import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class QvipPayWalletPatternLockBizManager extends y3.b {
    public boolean C;
    public boolean D;
    private int E;
    private com.qwallet.activity.patternlock.a F;

    /* renamed from: h, reason: collision with root package name */
    private BroadcastReceiver f41378h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f41379i;

    /* renamed from: m, reason: collision with root package name */
    public int f41380m;

    /* loaded from: classes3.dex */
    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action;
            if (intent != null && (action = intent.getAction()) != null && action.equals(IActivity.ACTION_QWALLET_PATTERN_LOCK_COLSEALL)) {
                ((y3.b) QvipPayWalletPatternLockBizManager.this).f449299e.finish();
            }
        }
    }

    public QvipPayWalletPatternLockBizManager(com.qwallet.activity.patternlock.a aVar) {
        super(aVar);
        this.F = aVar;
    }

    private void j() {
        try {
            Intent intent = new Intent();
            intent.setAction(GesturePWDUnlockActivity.GESTURE_ACTION);
            intent.putExtra("timeid", System.currentTimeMillis());
            this.f449299e.sendBroadcast(intent);
        } catch (Exception e16) {
            QLog.e("Q.qwallet.pattern.helper", 1, "error msg in qqpay-impl module: ", e16);
        }
    }

    private void n(int i3, String str) {
        QLog.i("Q.qwallet.pattern.manager", 1, "onPatternLockUpdated: type" + i3 + ", password");
        if (i3 != 0) {
            if (i3 != 3) {
                r(i3);
            }
        } else if (!TextUtils.isEmpty(str)) {
            o();
        }
    }

    private void r(final int i3) {
        HashMap hashMap = new HashMap();
        hashMap.put(j.T0, "appid#0|bargainor_id#0|channel#wallet");
        TenpayInterface.requestData(this.f449299e, "qwallet", com.tencent.mobileqq.base.a.c(), hashMap, new ResultReceiver(null) { // from class: com.qwallet.activity.patternlock.biz.QvipPayWalletPatternLockBizManager.1
            @Override // android.os.ResultReceiver
            protected void onReceiveResult(int i16, Bundle bundle) {
                boolean z16;
                super.onReceiveResult(i16, bundle);
                QLog.i("Q.qwallet.pattern.manager", 1, "resultCode: " + i16);
                if (i16 == 0) {
                    String string = bundle.getString("retmsg");
                    try {
                        if (!StringUtil.isEmpty(string)) {
                            JSONObject jSONObject = new JSONObject(string);
                            String optString = jSONObject.optString("user_attr");
                            boolean z17 = false;
                            if (!TextUtils.isEmpty(optString) && !optString.equals("0") && !optString.equals("3")) {
                                z16 = true;
                            } else {
                                z16 = false;
                            }
                            g.l("qwallet_is_pws_enter_" + com.tencent.mobileqq.base.a.c(), z16);
                            String optString2 = jSONObject.optString("realauth_url");
                            if (!StringUtil.isEmpty(optString2)) {
                                QWalletUtils.i(((y3.b) QvipPayWalletPatternLockBizManager.this).f449299e).edit().putString("real_auth_" + com.tencent.mobileqq.base.a.c(), optString2).apply();
                            }
                            Intent intent = new Intent();
                            if (!z16) {
                                z17 = true;
                            }
                            intent.putExtra("is_real_auth", z17);
                            intent.putExtra("pwd_type", i3);
                            com.tencent.mobileqq.base.c.d(((y3.b) QvipPayWalletPatternLockBizManager.this).f449299e, intent, QvipPayFullScreenRealAuthActivity.class);
                            return;
                        }
                        return;
                    } catch (Throwable th5) {
                        QLog.e("Q.qwallet.pattern.manager", 1, QLog.getStackTraceString(th5));
                        return;
                    }
                }
                QLog.i("Q.qwallet.pattern.manager", 1, "get user password type info fail!!!");
            }
        });
    }

    @Override // com.qwallet.activity.sso.f
    public int H9() {
        return 2;
    }

    @Override // y3.b
    public void a() {
        super.a();
        if (b() && this.f41378h != null) {
            try {
                this.f449299e.getApplicationContext().unregisterReceiver(this.f41378h);
            } catch (IllegalArgumentException e16) {
                QLog.e("Q.qwallet.pattern.manager", 1, "clean: ", e16);
            }
        }
    }

    @Override // y3.b
    protected void c(int i3, boolean z16, Object obj) {
        com.qwallet.activity.patternlock.a aVar;
        super.c(i3, z16, obj);
        if (i3 == 5 && (aVar = this.F) != null) {
            aVar.b(this.E);
        }
    }

    @Override // y3.b
    public void d(int i3, boolean z16, Object obj) {
        String str;
        if (!b()) {
            return;
        }
        QLog.i("Q.qwallet.pattern.manager", 1, "[onUpdateSelf] type: " + i3 + " data: " + obj + "mCallBackType: " + this.E);
        if (i3 == 3 && (obj instanceof GetPasswordRsp)) {
            GetPasswordRsp getPasswordRsp = (GetPasswordRsp) obj;
            if (getPasswordRsp.ret == 0) {
                if (!TextUtils.isEmpty(getPasswordRsp.password)) {
                    str = MD5.toMD5(QWalletHelperDelegate.getQWDevId() + getPasswordRsp.password);
                } else {
                    str = "";
                }
                PatternLockUtils.setSyncPatternLockState(this.f449299e, QWalletUtils.h(), false);
                PatternLockUtils.setPWD(this.f449299e, QWalletUtils.h(), str);
                PatternLockUtils.setPWDType(this.f449299e, QWalletUtils.h(), getPasswordRsp.passwordType);
                PatternLockUtils.setCheckIntervalTime(this.f449299e, QWalletUtils.h(), getPasswordRsp.checkInterval);
                PatternLockUtils.setForgroundIntervalTime(this.f449299e, QWalletUtils.h(), getPasswordRsp.passInterval);
                n(getPasswordRsp.passwordType, getPasswordRsp.password);
            }
        }
        if (i3 == 5 && (obj instanceof GetSignV2Rsp)) {
            GetSignV2Rsp getSignV2Rsp = (GetSignV2Rsp) obj;
            com.qwallet.activity.patternlock.a aVar = this.F;
            if (aVar != null) {
                aVar.j(getSignV2Rsp, this.E);
            }
        }
        if (i3 == 2 && (obj instanceof SetPasswordRsp)) {
            SetPasswordRsp setPasswordRsp = (SetPasswordRsp) obj;
            com.qwallet.activity.patternlock.a aVar2 = this.F;
            if (aVar2 != null) {
                aVar2.c(setPasswordRsp);
            }
        }
    }

    public void h() {
        if (b() && this.f449298d != null) {
            boolean syncPatternLockState = PatternLockUtils.getSyncPatternLockState(this.f449299e, QWalletUtils.h());
            QLog.i("Q.qwallet.pattern.manager", 1, "isNeedSync: " + syncPatternLockState);
            if (syncPatternLockState) {
                this.f449298d.b(this.f449299e);
            } else {
                n(PatternLockUtils.getPWDType(this.f449299e, QWalletUtils.h()), PatternLockUtils.getPWD(this.f449299e, QWalletUtils.h()));
            }
        }
    }

    public void i(String str) {
        this.f449298d.a("", str);
    }

    public void k(boolean z16, int i3, int i16) {
        if (!b()) {
            return;
        }
        if (i3 == 102) {
            if (i16 == 0) {
                this.f449299e.finish();
                this.f41380m = 3;
                return;
            }
            WindowManager.LayoutParams attributes = this.f449299e.getWindow().getAttributes();
            attributes.alpha = 1.0f;
            this.f449299e.getWindow().setAttributes(attributes);
            this.f41380m = 2;
            PatternLockUtils.setNewCreatePatternLock(this.f449299e, QWalletUtils.h(), false);
            return;
        }
        if (i3 == 103) {
            boolean isPatternLockOpened = PatternLockUtils.isPatternLockOpened(this.f449299e, QWalletUtils.h());
            if (z16 && !isPatternLockOpened) {
                this.f41379i = false;
                this.f449299e.getIntent().putExtra(IActivity.PARAM_IS_USE_QWALLET_PATTERN_LOCK, false);
            } else if (!z16 && isPatternLockOpened) {
                this.f41379i = true;
                this.f449299e.getIntent().putExtra(IActivity.PARAM_IS_USE_QWALLET_PATTERN_LOCK, true);
                try {
                    this.f41378h = new a();
                    this.f449299e.getApplicationContext().registerReceiver(this.f41378h, new IntentFilter(IActivity.ACTION_QWALLET_PATTERN_LOCK_COLSEALL));
                } catch (Exception e16) {
                    QLog.e("Q.qwallet.pattern.manager", 1, "", e16);
                }
            }
        }
    }

    public void l(int i3, int i16) {
        QLog.i("Q.qwallet.pattern.manager", 1, "[getSignV2ForVerifyPayPwd] callbackType: " + i3 + " identify: " + i16);
        this.E = i3;
        this.f449298d.c(i16);
    }

    public void m() {
        if (!b()) {
            return;
        }
        this.f41379i = PatternLockUtils.isPatternLockOpened(this.f449299e, QWalletUtils.h());
        this.C = this.f449299e.getIntent().getBooleanExtra(IQWalletHelper.QWALLET_HOMEPAGE_IS_NEED_OPEN_PATTERN_LOCK, false);
        QLog.i("Q.qwallet.pattern.manager", 1, "[initPatternLockState] hasPatternLock: " + this.f41379i + " isNeedOpenPatternLock: " + this.C);
        if (this.C) {
            this.f449299e.getIntent().putExtra(IActivity.PARAM_DISABLE_PATTERN_LOCK, true);
            this.D = true;
        }
    }

    public boolean o() {
        boolean isNeedOpenPatternLock = PatternLockUtils.isNeedOpenPatternLock(this.f449299e, QWalletUtils.h());
        QLog.d("Q.qwallet.pattern.manager", 1, "\u3010Open PatternLock\u3011 isPageNeedLock=" + this.C + ", isUserNeedLock=" + isNeedOpenPatternLock);
        if (!this.C || !isNeedOpenPatternLock) {
            return false;
        }
        j();
        this.f41380m = 1;
        Window window = this.f449299e.getWindow();
        window.setWindowAnimations(0);
        Intent intent = new Intent();
        intent.putExtra("action_mode", 1);
        intent.putExtra("is_for_entrance", true);
        intent.putExtra("is_from_background", false);
        intent.putExtra(IActivity.PARAM_DISABLE_PATTERN_LOCK, true);
        intent.putExtra(IPCConst.KEY_TITLE_TEXT, this.f449299e.getString(R.string.f179793_b));
        com.tencent.mobileqq.base.c.g(this.f449299e, intent, PatternLockActivity.class, 102);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.alpha = 0.0f;
        window.setAttributes(attributes);
        return true;
    }

    public void p() {
        if (this.D) {
            this.D = false;
            Activity activity = this.f449299e;
            if (activity != null && activity.getIntent() != null) {
                this.f449299e.getIntent().putExtra(IActivity.PARAM_DISABLE_PATTERN_LOCK, false);
            }
        }
    }

    public void q() {
        TickReq tickReq = new TickReq();
        tickReq.tickType = 3;
        QWalletUtils.u(tickReq);
    }
}
