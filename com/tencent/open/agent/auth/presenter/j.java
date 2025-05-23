package com.tencent.open.agent.auth.presenter;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.open.agent.auth.model.NewAuthDataSourceImpl;
import com.tencent.open.agent.util.k;
import com.tencent.open.agent.util.t;
import com.tencent.open.model.VirtualInfo;
import com.tencent.qconn.protofile.appType$AuthItem;
import com.tencent.qconn.protofile.preAuth$PreAuthResponse;
import com.tencent.qconn.protofile.preAuth$VirtualProfile;
import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import mqq.app.MainService;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes22.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    private int f340314a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class a implements com.tencent.open.appcommon.d {
        final /* synthetic */ String C;
        final /* synthetic */ Bundle D;
        final /* synthetic */ b E;
        final /* synthetic */ int F;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f340315d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.tencent.open.model.a f340316e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f340317f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f340318h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ String f340319i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ String f340320m;

        a(String str, com.tencent.open.model.a aVar, boolean z16, String str2, String str3, String str4, String str5, Bundle bundle, b bVar, int i3) {
            this.f340315d = str;
            this.f340316e = aVar;
            this.f340317f = z16;
            this.f340318h = str2;
            this.f340319i = str3;
            this.f340320m = str4;
            this.C = str5;
            this.D = bundle;
            this.E = bVar;
            this.F = i3;
        }

        private void a(int i3, String str) {
            t.b("SSOPreAuthPresenter", "preAuth onFail mPreAuthRetryCount=", Integer.valueOf(j.this.f340314a), ", errorCode=", Integer.valueOf(i3));
            if (j.this.f340314a >= this.F || i3 == 110537 || i3 == 110509 || i3 == 2001) {
                j.this.f340314a = 0;
                this.E.onFail(i3, str);
            } else {
                j.this.f340314a++;
                j.this.i(this.f340318h, this.f340319i, this.f340320m, this.C, this.D, this.f340316e, this.E, this.F);
            }
        }

        private void b(Bundle bundle, byte[] bArr) {
            try {
                preAuth$PreAuthResponse mergeFrom = new preAuth$PreAuthResponse().mergeFrom(bArr);
                if (mergeFrom.ret.has() && mergeFrom.ret.get() == 0) {
                    t.b("SSOPreAuthPresenter", "preAuth mergeFrom success");
                    if (mergeFrom.guide.has() && mergeFrom.guide.allow_promote_page.get()) {
                        dq3.f.k(this.f340318h, this.f340319i, this.f340320m, this.C, this.D, this.f340316e);
                    } else {
                        t.b("SSOPreAuthPresenter", "preAuth allow_promote_page false");
                    }
                    com.tencent.open.agent.util.d.h("KEY_PRE_AUTH", this.f340316e, true);
                    j.this.h(mergeFrom);
                    j.this.f340314a = 0;
                    this.E.onSuccess();
                    return;
                }
                t.b("SSOPreAuthPresenter", "preAuth mergeFrom fail ret=", Integer.valueOf(mergeFrom.ret.get()), ", msg=", mergeFrom.f342476msg.get());
                com.tencent.open.agent.util.d.h("KEY_PRE_AUTH", this.f340316e, false);
                a(mergeFrom.ret.get(), mergeFrom.f342476msg.get());
            } catch (Exception e16) {
                t.d("SSOPreAuthPresenter", "Exception", e16);
                com.tencent.open.agent.util.d.h("KEY_PRE_AUTH", this.f340316e, false);
                a(bundle.getInt("code", -1), "");
            }
        }

        @Override // mqq.observer.BusinessObserver
        public void onReceive(int i3, boolean z16, Bundle bundle) {
            t.b("SSOPreAuthPresenter", "preAuthWithRetry isSuccess=", Boolean.valueOf(z16), ", type=", Integer.valueOf(i3), ", mPreAuthRetryCount=", Integer.valueOf(j.this.f340314a), ", cmd=", this.f340315d);
            if (!z16) {
                com.tencent.open.agent.util.d.h("KEY_PRE_AUTH", this.f340316e, false);
                a(bundle.getInt("code", -1), "");
                return;
            }
            byte[] x16 = com.tencent.open.agent.util.g.x(bundle, this.f340317f, this.f340316e);
            if (x16 == null) {
                com.tencent.open.agent.util.d.h("KEY_PRE_AUTH", this.f340316e, false);
                a(bundle.getInt("code", -1), "");
            } else {
                b(bundle, x16);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public interface b {
        void onFail(int i3, String str);

        void onSuccess();
    }

    private com.tencent.open.model.e e(preAuth$PreAuthResponse preauth_preauthresponse) {
        com.tencent.open.model.e eVar = new com.tencent.open.model.e();
        t.b("SSOPreAuthPresenter", "onPreAuthResponse response.profiles.has()=", Boolean.valueOf(preauth_preauthresponse.profiles.has()));
        if (!preauth_preauthresponse.profiles.has()) {
            return eVar;
        }
        ArrayList<VirtualInfo> arrayList = new ArrayList<>();
        for (preAuth$VirtualProfile preauth_virtualprofile : preauth_preauthresponse.profiles.get()) {
            VirtualInfo virtualInfo = new VirtualInfo();
            virtualInfo.f341675d = preauth_virtualprofile.vid.get();
            virtualInfo.f341676e = preauth_virtualprofile.nick_name.get();
            virtualInfo.f341677f = preauth_virtualprofile.avatar_url.get();
            t.b("SSOPreAuthPresenter", "onPreAuthResponse nickName=", virtualInfo.f341676e + ", avatarUrl=", virtualInfo.f341677f);
            arrayList.add(virtualInfo);
        }
        eVar.f341694b = preauth_preauthresponse.vid.get();
        eVar.f341693a = preauth_preauthresponse.ret.get();
        eVar.f341695c = arrayList;
        return eVar;
    }

    private List<hp3.e> f(preAuth$PreAuthResponse preauth_preauthresponse) {
        boolean z16;
        ArrayList arrayList = new ArrayList();
        if (!preauth_preauthresponse.auth_items.has()) {
            return arrayList;
        }
        for (appType$AuthItem apptype_authitem : preauth_preauthresponse.auth_items.get()) {
            hp3.e eVar = new hp3.e();
            eVar.f405823e = apptype_authitem.api_list.get();
            eVar.f405819a = apptype_authitem.default_flag.get();
            eVar.f405824f = apptype_authitem.f342466id.get();
            if (apptype_authitem.is_new.get() != 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            eVar.f405822d = z16;
            eVar.f405820b = apptype_authitem.title.get();
            eVar.f405821c = apptype_authitem.desc.get();
            t.b("SSOPreAuthPresenter", "onPreAuthResponse Permission=", eVar.toString());
            arrayList.add(eVar);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(String str, String str2, String str3, String str4, Bundle bundle, com.tencent.open.model.a aVar, b bVar, int i3, Pair pair) {
        String str5 = (String) pair.getFirst();
        boolean equals = "QQConnectLogin.pre_auth_emp".equals(str5);
        t.b("SSOPreAuthPresenter", "preAuthWithRetry cmd=", str5, ",proxyAppId=", str, ",proxyToken=", str2);
        new NewAuthDataSourceImpl().c(str3, str4, str, str2, bundle, aVar, new Object[]{pair.getFirst(), pair.getSecond()}, new a(str5, aVar, equals, str3, str4, str, str2, bundle, bVar, i3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(preAuth$PreAuthResponse preauth_preauthresponse) {
        t.b("SSOPreAuthPresenter", "onPreAuthResponse");
        if (!preauth_preauthresponse.appid.has()) {
            return;
        }
        String l3 = Long.toString(preauth_preauthresponse.appid.get());
        hp3.b.e().n(l3, preauth_preauthresponse);
        hp3.b.e().m(l3, f(preauth_preauthresponse));
        if (preauth_preauthresponse.android_info.has()) {
            hp3.b.e().l(l3, hp3.a.b(preauth_preauthresponse, preauth_preauthresponse.android_info));
        }
        hp3.b.e().p(l3, e(preauth_preauthresponse));
    }

    public void i(final String str, final String str2, final String str3, final String str4, final Bundle bundle, final com.tencent.open.model.a aVar, final b bVar, final int i3) {
        com.tencent.open.agent.util.d.B("KEY_PRE_AUTH");
        com.tencent.open.agent.util.g.z(MobileQQ.sMobileQQ.waitAppRuntime(null), aVar.f341678a, MainService.CMD_PRE_AUTH, "QQConnectLogin.pre_auth_emp", new k.a() { // from class: com.tencent.open.agent.auth.presenter.i
            @Override // com.tencent.open.agent.util.k.a
            public final void a(Pair pair) {
                j.this.g(str3, str4, str, str2, bundle, aVar, bVar, i3, pair);
            }
        });
    }

    public void j(String str, String str2, Activity activity, String str3, Bundle bundle, b bVar) {
        com.tencent.open.model.a b16 = hp3.b.e().b(str2);
        if (b16 != null && activity != null) {
            String i3 = com.tencent.open.agent.util.c.i(bundle, "key_proxy_appid");
            String o16 = com.tencent.open.agent.util.c.o(com.tencent.open.agent.util.c.i(bundle, "key_proxy_token"));
            t.b("SSOPreAuthPresenter", "updatePreAuthFromServer proxyAppId=", i3, ", proxyToken=", o16);
            i(str3, str, i3, o16, bundle, b16, bVar, 2);
            return;
        }
        t.b("SSOPreAuthPresenter", "updatePreAuthFromServer account=", b16, ", context=", activity);
        bVar.onFail(-1, "");
    }
}
