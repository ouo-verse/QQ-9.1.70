package com.qwallet.pay;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.qwallet.data.PayPucAccManager;
import com.qwallet.pay.b;
import com.qwallet.utils.QWalletUtils;
import com.tencent.mobileqq.qwallet.ToggleConfig;
import com.tencent.mobileqq.qwallet.e;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy;
import com.tenpay.sdk.Cgi;
import cooperation.qwallet.plugin.IPayLogic;
import cooperation.qwallet.plugin.IQWalletHelper;
import cooperation.qwallet.plugin.QWalletPayBridge;
import cooperation.qwallet.plugin.impl.QWalletHelperDelegate;

/* compiled from: P */
/* loaded from: classes3.dex */
public abstract class a implements b {

    /* renamed from: j, reason: collision with root package name */
    private static int f41628j;

    /* renamed from: a, reason: collision with root package name */
    protected Context f41629a;

    /* renamed from: b, reason: collision with root package name */
    protected Intent f41630b;

    /* renamed from: c, reason: collision with root package name */
    protected Service f41631c;

    /* renamed from: d, reason: collision with root package name */
    protected Bundle f41632d;

    /* renamed from: e, reason: collision with root package name */
    public int f41633e = -1;

    /* renamed from: f, reason: collision with root package name */
    public boolean f41634f;

    /* renamed from: g, reason: collision with root package name */
    protected int f41635g;

    /* renamed from: h, reason: collision with root package name */
    protected ResultReceiver f41636h;

    /* renamed from: i, reason: collision with root package name */
    b.a f41637i;

    /* compiled from: P */
    /* renamed from: com.qwallet.pay.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    class C0307a implements e.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f41638a;

        C0307a(Context context) {
            this.f41638a = context;
        }

        @Override // com.tencent.mobileqq.qwallet.e.a
        public void onFinish(int i3, @Nullable String str, @Nullable String str2) {
            if (i3 == 0 && !TextUtils.isEmpty(str2)) {
                a aVar = a.this;
                aVar.m(str2, aVar.f41632d);
                a.this.g(this.f41638a);
                return;
            }
            a.this.f(-97);
        }
    }

    public a(Context context, Intent intent) {
        this.f41629a = context;
        this.f41630b = intent;
        if (context instanceof Service) {
            this.f41631c = (Service) context;
        }
        QLog.i("Q.qwallet.BasePayPluginLogic", 1, "current class=" + getClass().getSimpleName());
    }

    private void k() {
        QWalletHelperDelegate.mIsEnterPayBridge = false;
        QWalletHelperDelegate.sEnterQWalletPluginCount--;
        QWalletHelperDelegate.sReporteSeq = 0L;
        int i3 = f41628j - 1;
        f41628j = i3;
        if (i3 == 0) {
            PayPucAccManager.n();
            t.a().b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(String str, Bundle bundle) {
        if (bundle != null && !TextUtils.isEmpty(str)) {
            bundle.putString(ShortVideoConstants.PARAM_KEY_SESSION_TYPE, "pskey_120");
            bundle.putString("userKey", str);
        }
    }

    @Override // com.qwallet.pay.b
    public final void a(Context context) {
        this.f41629a = context;
        int i3 = i(context);
        if (i3 != 0) {
            f(i3);
        } else if (j()) {
            com.tencent.mobileqq.qwallet.e.b(false, Cgi.TENPAY_DOMAIN, new C0307a(context));
        } else {
            g(context);
        }
    }

    @Override // com.qwallet.pay.b
    public boolean b() {
        return false;
    }

    @Override // com.qwallet.pay.b
    public void c(b.a aVar) {
        this.f41637i = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(Bundle bundle) {
        ResultReceiver resultReceiver = this.f41636h;
        if (resultReceiver != null) {
            resultReceiver.send(this.f41635g, bundle);
        }
        this.f41637i.x2(this.f41629a);
    }

    public void f(int i3) {
        if (QLog.isColorLevel()) {
            QLog.i("Q.qwallet.BasePayPluginLogic", 2, "doParamsError errCode:" + i3);
        }
        Intent intent = new Intent();
        intent.putExtra(QWalletPayBridge.Key.PAY_INVOKER_ID, this.f41635g);
        intent.putExtra(QWalletPayBridge.PayResult.PAY_RESULT_EXTRA_KEY, 2);
        intent.putExtra("result", "");
        intent.putExtra("payRetCode", i3);
        e(intent.getExtras());
    }

    @Nullable
    public Lifecycle h() {
        Object obj = this.f41629a;
        if (obj instanceof LifecycleOwner) {
            return ((LifecycleOwner) obj).getLifecycle();
        }
        return null;
    }

    protected int i(Context context) {
        f41628j++;
        QWalletHelperDelegate.sEnterQWalletPluginCount++;
        QWalletUtils.b(context);
        QWalletHelperDelegate.mIsEnterPayBridge = true;
        QLog.i("Q.qwallet.BasePayPluginLogic", 2, "parseParams");
        Intent intent = this.f41630b;
        if (intent == null) {
            return -96;
        }
        this.f41632d = intent.getBundleExtra(IQWalletHelper.QWALLET_EXTRA_KEY_PAY_BUNDLE);
        long longExtra = this.f41630b.getLongExtra(IQWalletHelper.QWALLET_EXTRA_KEY_PAY_TIME_START, 0L);
        Bundle bundle = this.f41632d;
        if (bundle == null) {
            return -95;
        }
        int i3 = bundle.getInt(PayProxy.Source.PAY_TYPE_EXTRA_KEY, -1);
        this.f41633e = i3;
        PayPucAccManager.f41509e = i3;
        QWalletUtils.r(this.f41630b.getExtras());
        long currentTimeMillis = System.currentTimeMillis();
        if (longExtra != 0) {
            QLog.i("Q.qwallet.BasePayPluginLogic", 2, "StartReceiverTime:" + (currentTimeMillis - longExtra));
        }
        this.f41636h = (ResultReceiver) this.f41632d.getParcelable(IPayLogic.RECEIVER_COM_KEY);
        int i16 = this.f41632d.getInt(QWalletPayBridge.Key.PAY_INVOKER_ID, -1);
        PayPucAccManager.f41510f = i16;
        this.f41635g = i16;
        QLog.i("Q.qwallet.BasePayPluginLogic", 2, "parseParams mInvokeId = " + this.f41635g);
        return 0;
    }

    protected boolean j() {
        if (this.f41632d.getBoolean(PayProxy.Source.PAY_IS_LOCK_WITHDRAW, false) || !QWalletPayBridge.isMidasInvokerId(this.f41635g)) {
            return false;
        }
        String string = this.f41632d.getString(ShortVideoConstants.PARAM_KEY_SESSION_TYPE);
        if (!TextUtils.isEmpty(this.f41632d.getString("userKey")) && !TextUtils.isEmpty(string)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void l(int i3, String str, int i16, String str2) {
        if (QLog.isColorLevel()) {
            QLog.d("Q.qwallet.BasePayPluginLogic", 2, "onOpenTenpayViewResult nInvokerId=" + i3 + ",callbackSn=" + str + ",viewRetCode=" + i16 + ",result=" + str2);
        }
        Intent intent = new Intent();
        intent.putExtra(QWalletPayBridge.Key.PAY_INVOKER_ID, i3);
        intent.putExtra(QWalletPayBridge.PayResult.PAY_RESULT_EXTRA_KEY, 1);
        intent.putExtra("callbackSn", str);
        intent.putExtra("result", str2);
        intent.putExtra("viewRetCode", i16);
        e(intent.getExtras());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void n() {
        if (ToggleConfig.b()) {
            this.f41629a = null;
        }
    }

    @Override // com.qwallet.pay.b
    public void onDestroy() {
        k();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(Context context) {
    }

    @Override // com.qwallet.pay.b
    public void onActivityResult(int i3, int i16, Intent intent) {
    }
}
