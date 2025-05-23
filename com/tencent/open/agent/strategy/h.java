package com.tencent.open.agent.strategy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.login.aa;
import com.tencent.mobileqq.login.aj;
import com.tencent.open.OpenProxy;
import com.tencent.open.agent.util.t;
import com.tencent.qqconnect.wtlogin.AbstractOpenSdkAppInterface;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes22.dex */
public class h extends c {

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class a implements aa {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f340579a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f340580b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ AbstractOpenSdkAppInterface f340581c;

        a(String str, boolean z16, AbstractOpenSdkAppInterface abstractOpenSdkAppInterface) {
            this.f340579a = str;
            this.f340580b = z16;
            this.f340581c = abstractOpenSdkAppInterface;
        }

        private void d(String str, int i3) {
            Bundle bundle = new Bundle();
            bundle.putInt("key_sso_ret", i3);
            bundle.putString("uin", str);
            bundle.putBoolean("is_from_login", this.f340580b);
            com.tencent.open.b.f(bundle);
            this.f340581c.h(2, null);
        }

        @Override // com.tencent.mobileqq.login.aa
        public void a() {
            t.b("IMBlockLoginAction", "-->onUserCancel--", com.tencent.open.agent.util.g.C(this.f340579a));
            d(this.f340579a, 2006);
        }

        @Override // com.tencent.mobileqq.login.aa
        public void b(aj ajVar) {
            t.b("IMBlockLoginAction", "-->onFailed--", com.tencent.open.agent.util.g.C(this.f340579a));
            d(this.f340579a, ajVar.f241864a);
        }

        @Override // com.tencent.mobileqq.login.aa
        public void c(String str, Bundle bundle) {
            t.b("IMBlockLoginAction", "-->onLoginSuccess--", com.tencent.open.agent.util.g.C(str));
            OpenProxy.c().a(str);
            com.tencent.open.b.c(str);
            d(str, 0);
        }
    }

    public h(String str) {
        super(str);
    }

    @Override // com.tencent.open.agent.strategy.c, com.tencent.open.agent.strategy.g
    public /* bridge */ /* synthetic */ void a(Activity activity) {
        super.a(activity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.open.agent.strategy.c
    public boolean b(Activity activity, Bundle bundle) {
        return true;
    }

    @Override // com.tencent.open.agent.strategy.c
    public void d(Activity activity, Bundle bundle) {
        Intent intent = activity.getIntent();
        String stringExtra = intent.getStringExtra("appid");
        String stringExtra2 = intent.getStringExtra("uin");
        String stringExtra3 = intent.getStringExtra("passwd");
        boolean booleanExtra = intent.getBooleanExtra("is_from_login", false);
        AbstractOpenSdkAppInterface abstractOpenSdkAppInterface = (AbstractOpenSdkAppInterface) MobileQQ.sMobileQQ.waitAppRuntime(null);
        abstractOpenSdkAppInterface.h(1, null);
        com.tencent.open.agent.util.b.e(stringExtra, stringExtra2, stringExtra3, new a(stringExtra2, booleanExtra, abstractOpenSdkAppInterface));
    }
}
