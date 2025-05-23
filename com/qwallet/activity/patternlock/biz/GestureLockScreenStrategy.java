package com.qwallet.activity.patternlock.biz;

import Wallet.GetSignV2Rsp;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.qwallet.activity.patternlock.PatternLockActivity;
import com.qwallet.activity.patternlock.PatternLockHelper;
import com.qwallet.activity.patternlock.PatternLockSetFragment;
import com.qwallet.protocol.Wallet.PatternLock.SetPasswordRsp;
import com.qwallet.utils.QWalletUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.ipc.IPCConst;
import com.tenpay.api.TenpayInterface;
import cooperation.qwallet.plugin.IActivity;
import cooperation.qwallet.plugin.PatternLockUtils;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes3.dex */
public class GestureLockScreenStrategy implements a, com.qwallet.activity.patternlock.a {

    /* renamed from: a, reason: collision with root package name */
    private QvipPayWalletPatternLockBizManager f41364a;

    /* renamed from: b, reason: collision with root package name */
    private Activity f41365b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f41366c;

    /* renamed from: d, reason: collision with root package name */
    private b f41367d;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    static class CloseGestureReceiver extends ResultReceiver {

        /* renamed from: d, reason: collision with root package name */
        private final WeakReference<QvipPayWalletPatternLockBizManager> f41368d;

        public CloseGestureReceiver(Handler handler, QvipPayWalletPatternLockBizManager qvipPayWalletPatternLockBizManager) {
            super(handler);
            this.f41368d = new WeakReference<>(qvipPayWalletPatternLockBizManager);
        }

        @Override // android.os.ResultReceiver
        protected void onReceiveResult(int i3, Bundle bundle) {
            String str;
            QvipPayWalletPatternLockBizManager qvipPayWalletPatternLockBizManager = this.f41368d.get();
            if (qvipPayWalletPatternLockBizManager == null) {
                return;
            }
            QLog.i("GestureLockScreenStrategy", 2, "resultCode: " + i3);
            if (i3 == 0) {
                if (bundle != null) {
                    str = bundle.getString("qpwd_token");
                } else {
                    str = "";
                }
                qvipPayWalletPatternLockBizManager.i(str);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    static class CreateGestureReceiver extends ResultReceiver {

        /* renamed from: d, reason: collision with root package name */
        private final WeakReference<Activity> f41369d;

        public CreateGestureReceiver(Handler handler, Activity activity) {
            super(handler);
            this.f41369d = new WeakReference<>(activity);
        }

        @Override // android.os.ResultReceiver
        protected void onReceiveResult(int i3, Bundle bundle) {
            Activity activity = this.f41369d.get();
            if (activity != null && !activity.isFinishing()) {
                QLog.i("GestureLockScreenStrategy", 2, "resultCode: " + i3);
                if (i3 == 0) {
                    Intent intent = new Intent();
                    intent.putExtra("action_mode", 2);
                    intent.putExtra("enable_act_anim", true);
                    intent.putExtra("is_first_create_patternlock", true);
                    intent.putExtra("is_from_create_patternlock", true);
                    intent.putExtra(IPCConst.KEY_TITLE_TEXT, activity.getString(R.string.g_6));
                    com.tencent.mobileqq.base.c.g(activity, intent, PatternLockActivity.class, 313);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    static class ForgetGestureReceiver extends ResultReceiver {

        /* renamed from: d, reason: collision with root package name */
        private final WeakReference<Activity> f41370d;

        public ForgetGestureReceiver(Handler handler, Activity activity) {
            super(handler);
            this.f41370d = new WeakReference<>(activity);
        }

        @Override // android.os.ResultReceiver
        protected void onReceiveResult(int i3, Bundle bundle) {
            Activity activity = this.f41370d.get();
            if (activity != null && !activity.isFinishing()) {
                QLog.i("GestureLockScreenStrategy", 2, "resultCode: " + i3);
                if (i3 == 0) {
                    Intent intent = new Intent();
                    intent.putExtra("action_mode", 2);
                    intent.putExtra("enable_act_anim", true);
                    intent.putExtra("is_from_create_patternlock", true);
                    intent.putExtra(IPCConst.KEY_TITLE_TEXT, activity.getString(R.string.f2179762g));
                    com.tencent.mobileqq.base.c.g(activity, intent, PatternLockActivity.class, 302);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    static class PayPswUnlockReceiver extends ResultReceiver {

        /* renamed from: d, reason: collision with root package name */
        private final WeakReference<Activity> f41371d;

        public PayPswUnlockReceiver(Handler handler, Activity activity) {
            super(handler);
            this.f41371d = new WeakReference<>(activity);
        }

        @Override // android.os.ResultReceiver
        protected void onReceiveResult(int i3, Bundle bundle) {
            Activity activity = this.f41371d.get();
            if (activity != null && !activity.isFinishing()) {
                QLog.i("GestureLockScreenStrategy", 2, "resultCode: " + i3);
                if (i3 != 0) {
                    Intent intent = new Intent();
                    intent.setAction(IActivity.ACTION_QWALLET_PATTERN_LOCK_COLSEALL);
                    activity.sendBroadcast(intent);
                }
                activity.finish();
            }
        }
    }

    @Override // com.qwallet.activity.patternlock.biz.a
    public void a() {
        QvipPayWalletPatternLockBizManager qvipPayWalletPatternLockBizManager = this.f41364a;
        if (qvipPayWalletPatternLockBizManager != null) {
            qvipPayWalletPatternLockBizManager.a();
        } else {
            QLog.i("GestureLockScreenStrategy", 2, "\u3010unAttachActivity\u3011bizManager is null");
        }
        b bVar = this.f41367d;
        if (bVar != null) {
            bVar.a();
        } else {
            QLog.i("GestureLockScreenStrategy", 2, "\u3010unAttachActivity\u3011mVerifyStrategy is null");
        }
    }

    @Override // com.qwallet.activity.patternlock.a
    public void b(int i3) {
        if (i3 == 1) {
            QLog.e("GestureLockScreenStrategy", 1, "request error \u7f51\u7edc\u8bf7\u6c42\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5\u4e00\u8bd5");
            QQToast.makeText(MobileQQ.sMobileQQ, 1, "\u7f51\u7edc\u8bf7\u6c42\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5\u4e00\u8bd5", 0).show();
        }
    }

    @Override // com.qwallet.activity.patternlock.a
    public void c(SetPasswordRsp setPasswordRsp) {
        if (setPasswordRsp.ret == 0) {
            PatternLockUtils.setPWD(this.f41365b, QWalletUtils.h(), "");
            PatternLockUtils.setPWDType(this.f41365b, QWalletUtils.h(), 3);
            PatternLockUtils.setUnlockFailedTimes(this.f41365b, QWalletUtils.h(), 0);
        } else {
            Activity activity = this.f41365b;
            PatternLockHelper.a(activity, activity.getString(R.string.f179693_2));
        }
        Activity activity2 = this.f41365b;
        if (activity2 instanceof QPublicFragmentActivity) {
            QPublicBaseFragment fragment = ((QPublicFragmentActivity) activity2).getFragment();
            if (fragment instanceof PatternLockSetFragment) {
                ((PatternLockSetFragment) fragment).Jh();
            }
        }
    }

    @Override // com.qwallet.activity.patternlock.biz.a
    public void d() {
        QvipPayWalletPatternLockBizManager qvipPayWalletPatternLockBizManager = this.f41364a;
        if (qvipPayWalletPatternLockBizManager != null) {
            qvipPayWalletPatternLockBizManager.m();
            QvipPayWalletPatternLockBizManager qvipPayWalletPatternLockBizManager2 = this.f41364a;
            this.f41366c = qvipPayWalletPatternLockBizManager2.f41379i;
            qvipPayWalletPatternLockBizManager2.h();
            return;
        }
        QLog.i("GestureLockScreenStrategy", 2, "\u3010showLockScreen\u3011bizManager is null");
    }

    @Override // com.qwallet.activity.patternlock.biz.a
    public a e(WeakReference<Activity> weakReference) {
        if (weakReference != null) {
            this.f41365b = weakReference.get();
        }
        if (this.f41364a == null) {
            this.f41364a = new QvipPayWalletPatternLockBizManager(this);
        }
        if (this.f41367d == null) {
            PayPasswordVerifyImpl payPasswordVerifyImpl = new PayPasswordVerifyImpl(this.f41364a);
            this.f41367d = payPasswordVerifyImpl;
            payPasswordVerifyImpl.c(this.f41365b);
        }
        return this;
    }

    @Override // com.qwallet.activity.patternlock.biz.a
    public void f() {
        QvipPayWalletPatternLockBizManager qvipPayWalletPatternLockBizManager = this.f41364a;
        if (qvipPayWalletPatternLockBizManager != null) {
            qvipPayWalletPatternLockBizManager.q();
        } else {
            QLog.i("GestureLockScreenStrategy", 2, "\u3010sendSetBaseActivityUnlockSuceess\u3011bizManager is null");
        }
    }

    @Override // com.qwallet.activity.patternlock.biz.a
    public void g(int i3, int i16) {
        QvipPayWalletPatternLockBizManager qvipPayWalletPatternLockBizManager = this.f41364a;
        if (qvipPayWalletPatternLockBizManager != null) {
            qvipPayWalletPatternLockBizManager.k(this.f41366c, i3, i16);
            this.f41366c = this.f41364a.f41379i;
        } else {
            QLog.i("GestureLockScreenStrategy", 2, "\u3010doOnActivityResult\u3011bizManager is null");
        }
    }

    @Override // y3.a
    public java.lang.ref.WeakReference<Activity> getBaseActivity() {
        return new WeakReference(this.f41365b);
    }

    @Override // com.qwallet.activity.patternlock.biz.a
    public void h() {
        QvipPayWalletPatternLockBizManager qvipPayWalletPatternLockBizManager = this.f41364a;
        if (qvipPayWalletPatternLockBizManager != null) {
            qvipPayWalletPatternLockBizManager.p();
        } else {
            QLog.i("GestureLockScreenStrategy", 2, "\u3010processTwinceShowFromOtherApp\u3011bizManager is null");
        }
    }

    @Override // com.qwallet.activity.patternlock.biz.a
    public void i(int i3) {
        b bVar = this.f41367d;
        if (bVar != null) {
            bVar.b(i3);
        } else {
            QLog.i("GestureLockScreenStrategy", 2, "\u3010createPatternLock\u3011mVerifyStrategy is null");
        }
    }

    @Override // com.qwallet.activity.patternlock.a
    public void j(GetSignV2Rsp getSignV2Rsp, int i3) {
        String currentAccountUin = MobileQQ.sMobileQQ.waitAppRuntime(null).getCurrentAccountUin();
        Bundle c16 = PatternLockHelper.c(getSignV2Rsp);
        int i16 = getSignV2Rsp.ret;
        if (i16 == 0 && c16 != null) {
            QLog.i("GestureLockScreenStrategy", 2, "[onPwdVerifyCallback] type: " + i3);
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 == 4) {
                            TenpayInterface.gotoView(this.f41365b, "checkPsw", currentAccountUin, com.tencent.mobileqq.base.a.b(), c16, new PayPswUnlockReceiver(null, this.f41365b));
                            return;
                        }
                        return;
                    }
                    TenpayInterface.gotoView(this.f41365b, "checkPsw", currentAccountUin, com.tencent.mobileqq.base.a.b(), c16, new ForgetGestureReceiver(null, this.f41365b));
                    return;
                }
                TenpayInterface.gotoView(this.f41365b, "checkPsw", currentAccountUin, com.tencent.mobileqq.base.a.b(), c16, new CloseGestureReceiver(null, this.f41364a));
                return;
            }
            TenpayInterface.gotoView(this.f41365b, "checkPsw", currentAccountUin, com.tencent.mobileqq.base.a.b(), c16, new CreateGestureReceiver(null, this.f41365b));
            return;
        }
        QLog.i("GestureLockScreenStrategy", 2, String.format("data = %1$s, ret=%2$s", c16, Integer.valueOf(i16)));
        Activity activity = this.f41365b;
        PatternLockHelper.a(activity, activity.getString(R.string.f179783_a));
    }
}
