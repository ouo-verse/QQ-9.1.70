package com.tencent.open.agent.auth.presenter;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.gamecenter.api.IGameCenterAuthApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.open.agent.PublicFragmentActivityForOpenSDK;
import com.tencent.open.agent.auth.util.AppAuthLimitHelper;
import com.tencent.open.agent.util.AuthUIUtil;
import com.tencent.open.agent.util.o;
import com.tencent.open.agent.util.t;
import com.tencent.open.api.IOpenSdkApi;
import com.tencent.open.model.AccountManage;
import com.tencent.open.virtual.OpenSdkVirtualUtil;
import com.tencent.qconn.protofile.preAuth$PreAuthResponse;
import com.tencent.util.UiThreadUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;
import org.json.JSONException;

/* loaded from: classes22.dex */
public class SelectPermissionPresenter implements ep3.j {

    /* renamed from: a, reason: collision with root package name */
    private com.tencent.open.agent.auth.model.c f340245a;

    /* renamed from: b, reason: collision with root package name */
    private ep3.k f340246b;

    /* renamed from: c, reason: collision with root package name */
    private int f340247c;

    /* renamed from: e, reason: collision with root package name */
    private long f340249e;

    /* renamed from: f, reason: collision with root package name */
    private long f340250f;

    /* renamed from: g, reason: collision with root package name */
    private String f340251g;

    /* renamed from: h, reason: collision with root package name */
    private long f340252h;

    /* renamed from: i, reason: collision with root package name */
    private long f340253i;

    /* renamed from: j, reason: collision with root package name */
    private long f340254j;

    /* renamed from: k, reason: collision with root package name */
    private long f340255k;

    /* renamed from: l, reason: collision with root package name */
    private String f340256l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f340257m;

    /* renamed from: n, reason: collision with root package name */
    private String f340258n;

    /* renamed from: o, reason: collision with root package name */
    private Activity f340259o;

    /* renamed from: p, reason: collision with root package name */
    private Intent f340260p;

    /* renamed from: d, reason: collision with root package name */
    private List<hp3.e> f340248d = new ArrayList();

    /* renamed from: q, reason: collision with root package name */
    private fp3.a f340261q = new fp3.a() { // from class: com.tencent.open.agent.auth.presenter.SelectPermissionPresenter.3
        @Override // fp3.a
        public void a(final boolean z16, final int i3, final fp3.b bVar) {
            t.b("SelectPermissionPresenter", "-->onDoAuthorize isSuccess=", Boolean.valueOf(z16), ", code=", Integer.valueOf(i3));
            if (SelectPermissionPresenter.this.f340259o == null) {
                t.e("SelectPermissionPresenter", "onDoAuthorize activity is null");
            } else {
                SelectPermissionPresenter.this.f340259o.runOnUiThread(new Runnable() { // from class: com.tencent.open.agent.auth.presenter.SelectPermissionPresenter.3.1

                    /* renamed from: com.tencent.open.agent.auth.presenter.SelectPermissionPresenter$3$1$a */
                    /* loaded from: classes22.dex */
                    class a implements DialogInterface.OnClickListener {
                        a() {
                        }

                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i3) {
                            dialogInterface.dismiss();
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        String str;
                        boolean z17;
                        if (z16 && bVar != null) {
                            SelectPermissionPresenter.this.P(true);
                            SelectPermissionPresenter.this.U(bVar.f400231e.get(), SelectPermissionPresenter.this.J());
                            SelectPermissionPresenter.this.T(bVar.f400231e.get(), bVar.f400233g.get());
                            try {
                                long elapsedRealtime = SystemClock.elapsedRealtime() - SelectPermissionPresenter.this.f340252h;
                                fp3.b bVar2 = bVar;
                                long j3 = SelectPermissionPresenter.this.f340254j;
                                long j16 = SelectPermissionPresenter.this.f340253i;
                                if (SelectPermissionPresenter.this.f340250f != 0) {
                                    z17 = true;
                                } else {
                                    z17 = false;
                                }
                                SelectPermissionPresenter.this.Q(bVar.f400227a.get(), com.tencent.open.agent.util.g.L(bVar2, j3, j16, elapsedRealtime, z17).toString(), null, null);
                            } catch (JSONException e16) {
                                t.d("SelectPermissionPresenter", "catch JSONException", e16);
                            }
                        } else {
                            int i16 = i3;
                            if (i16 == 110509) {
                                t.b("SelectPermissionPresenter", "onDoAuthorize mAuthRetryCountBy110509=" + SelectPermissionPresenter.this.f340247c);
                                fp3.b bVar3 = bVar;
                                if (bVar3 == null) {
                                    str = "";
                                } else {
                                    str = bVar3.f400228b.get();
                                }
                                if (SelectPermissionPresenter.this.f340247c >= 2) {
                                    SelectPermissionPresenter.this.H(str);
                                } else {
                                    SelectPermissionPresenter.this.f340247c++;
                                    SelectPermissionPresenter.this.O(3, str);
                                }
                                SelectPermissionPresenter.this.P(false);
                            } else if (i16 == 110537) {
                                t.b("SelectPermissionPresenter", "onDoAuthorize 110537");
                                AuthUIUtil.l(SelectPermissionPresenter.this.f340259o, HardCodeUtil.qqStr(R.string.f213575qk), false);
                                SelectPermissionPresenter.this.G();
                            } else if (i16 == 100044) {
                                com.tencent.open.agent.util.d.w(hp3.b.e().b(SelectPermissionPresenter.this.J()).f341678a, SelectPermissionPresenter.this.J(), SelectPermissionPresenter.this.f340259o.getIntent().getStringExtra("packagename"), SelectPermissionPresenter.this.f340259o.getIntent().getStringExtra("packagesign"));
                                AuthUIUtil.f(SelectPermissionPresenter.this.f340259o, com.tencent.open.agent.util.g.p(bVar, SelectPermissionPresenter.this.f340259o.getResources(), i3), new a());
                            } else {
                                AppAuthLimitHelper.b(i16, SelectPermissionPresenter.this.I(), bVar);
                                AuthUIUtil.l(SelectPermissionPresenter.this.f340259o, com.tencent.open.agent.util.g.p(bVar, SelectPermissionPresenter.this.f340259o.getResources(), i3), false);
                                SelectPermissionPresenter.this.P(false);
                            }
                        }
                        SelectPermissionPresenter.this.f340246b.L();
                    }
                });
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes22.dex */
    public class a implements AccountManage.h {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f340270a;

        a(String str) {
            this.f340270a = str;
        }

        @Override // com.tencent.open.model.AccountManage.h
        public void a(String str, Bundle bundle) {
            t.e("SelectPermissionPresenter", "refreshTicket onFail");
            if (!SelectPermissionPresenter.this.K()) {
                SelectPermissionPresenter.this.H(this.f340270a);
            } else {
                t.b("SelectPermissionPresenter", "refreshTicket onFail Activity Finishing");
            }
        }

        @Override // com.tencent.open.model.AccountManage.h
        public void b(com.tencent.open.model.a aVar) {
            t.b("SelectPermissionPresenter", "refreshTicket success info.uin=" + com.tencent.open.agent.util.g.C(aVar.f341678a));
            if (SelectPermissionPresenter.this.K()) {
                t.b("SelectPermissionPresenter", "refreshTicket success Activity Finishing");
            } else {
                hp3.b.e().q(SelectPermissionPresenter.this.J(), aVar);
                SelectPermissionPresenter.this.F();
            }
        }
    }

    public SelectPermissionPresenter(ep3.k kVar, com.tencent.open.agent.auth.model.c cVar) {
        this.f340246b = kVar;
        this.f340259o = kVar.getActivity();
        this.f340245a = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F() {
        com.tencent.open.model.a b16 = hp3.b.e().b(J());
        com.tencent.open.agent.util.d.f("KEY_LOGIN_STAGE_2_NEW_TOTAL", b16);
        com.tencent.open.agent.util.d.f("KEY_LOGIN_STAGE_2_2_NEW_TOTAL", b16);
        com.tencent.open.agent.util.d.B("KEY_LOGIN_STAGE_3_TOTAL");
        this.f340246b.showLoading();
        ThreadManagerV2.executeOnNetWorkThread(new Runnable() { // from class: com.tencent.open.agent.auth.presenter.SelectPermissionPresenter.2
            @Override // java.lang.Runnable
            public void run() {
                String valueOf;
                String str;
                List<hp3.e> g16 = hp3.b.e().g(SelectPermissionPresenter.this.J());
                int i3 = 1;
                if (g16 == null) {
                    t.b("SelectPermissionPresenter", "getAuthApiListResponse == null");
                    return;
                }
                ArrayList<hp3.e> arrayList = new ArrayList();
                for (hp3.e eVar : g16) {
                    hp3.e eVar2 = new hp3.e();
                    eVar2.f405819a = eVar.f405819a;
                    eVar2.f405823e = eVar.f405823e;
                    eVar2.f405824f = eVar.f405824f;
                    eVar2.f405822d = eVar.f405822d;
                    eVar2.f405820b = eVar.f405820b;
                    eVar2.f405821c = eVar.f405821c;
                    eVar2.f405825g = true;
                    arrayList.add(eVar2);
                }
                if (!SelectPermissionPresenter.this.f340248d.isEmpty()) {
                    for (hp3.e eVar3 : SelectPermissionPresenter.this.f340248d) {
                        for (hp3.e eVar4 : arrayList) {
                            if (eVar3.f405824f == eVar4.f405824f) {
                                eVar4.f405825g = eVar3.f405825g;
                            }
                        }
                    }
                }
                if (SelectPermissionPresenter.this.f340257m) {
                    i3 = 2;
                }
                int i16 = i3;
                com.tencent.open.agent.util.d.B("KEY_AUTHORIZE_REQUEST");
                if (0 == SelectPermissionPresenter.this.f340250f) {
                    valueOf = "";
                } else {
                    valueOf = String.valueOf(SelectPermissionPresenter.this.f340250f);
                }
                new k().f(SelectPermissionPresenter.this.f340257m, SelectPermissionPresenter.this.I(), valueOf, SelectPermissionPresenter.this.f340251g, arrayList, SelectPermissionPresenter.this.f340255k, SelectPermissionPresenter.this.f340261q, SelectPermissionPresenter.this.f340256l);
                if (SelectPermissionPresenter.this.f340255k == 0) {
                    str = "0X800A117";
                } else {
                    str = "0X800A116";
                }
                com.tencent.open.agent.util.g.P(null, str, 0, i16, null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G() {
        AuthUIUtil.l(this.f340259o, HardCodeUtil.qqStr(R.string.f213565qj), false);
        if (K()) {
            t.b("SelectPermissionPresenter", "finishAndToLogin but Activity isFinishing");
            return;
        }
        t.b("SelectPermissionPresenter", "finishAndToLogin");
        Intent intent = new Intent();
        intent.putExtra("key_need_login", 1);
        this.f340259o.setResult(102, intent);
        this.f340259o.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(String str) {
        if (K()) {
            t.b("SelectPermissionPresenter", "finishAndToLogin but Activity isFinishing");
            return;
        }
        t.b("SelectPermissionPresenter", "finishAndToLogin from 110509");
        if (TextUtils.isEmpty(str)) {
            str = HardCodeUtil.qqStr(R.string.f213565qj);
        }
        AuthUIUtil.g(this.f340259o, HardCodeUtil.qqStr(R.string.f197714kr), str, new DialogInterface.OnClickListener() { // from class: com.tencent.open.agent.auth.presenter.l
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                SelectPermissionPresenter.this.N(dialogInterface, i3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String I() {
        return String.valueOf(this.f340249e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String J() {
        long j3 = this.f340250f;
        if (j3 == 0) {
            j3 = this.f340249e;
        }
        return String.valueOf(j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean K() {
        Activity activity = this.f340259o;
        if (activity != null && !activity.isFinishing()) {
            return false;
        }
        return true;
    }

    private void M() {
        t.b("SelectPermissionPresenter", "onClick to NextFragment");
        Intent intent = this.f340260p;
        if (intent == null) {
            intent = new Intent();
            intent.putExtra("pkg_name", com.tencent.open.agent.util.c.g(this.f340259o));
            intent.putExtra("appName", this.f340258n);
        }
        intent.putExtra("appId", this.f340249e);
        intent.putExtra("key_proxy_appid", this.f340250f);
        intent.putExtra("key_proxy_token", this.f340259o.getIntent().getStringExtra("key_proxy_token"));
        ((IGameCenterAuthApi) QRoute.api(IGameCenterAuthApi.class)).jump2AuthFragmentWhenLogin(this.f340259o, intent, PublicFragmentActivityForOpenSDK.class, 103);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void N(DialogInterface dialogInterface, int i3) {
        Intent intent = new Intent();
        intent.putExtra("key_need_login", 1);
        intent.putExtra("key_need_show_uin", true);
        this.f340259o.setResult(102, intent);
        this.f340259o.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O(int i3, String str) {
        AccountManage.g().j(hp3.b.e().b(J()).f341678a, J(), i3, new a(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P(boolean z16) {
        String str;
        String str2;
        com.tencent.open.model.a b16 = hp3.b.e().b(J());
        com.tencent.open.agent.util.d.h("KEY_AUTHORIZE_REQUEST", b16, z16);
        if (b16 != null && (str = b16.f341678a) != null) {
            if (z16) {
                str2 = "0X800B65E";
            } else {
                str2 = "0X800B65F";
            }
            com.tencent.open.agent.util.d.s(str, str2);
        }
        if (z16) {
            com.tencent.open.agent.util.g.S(this.f340255k, J(), com.tencent.open.agent.util.c.k(this.f340259o, "sdkv"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q(int i3, String str, String str2, String str3) {
        String str4;
        com.tencent.open.model.a b16 = hp3.b.e().b(J());
        com.tencent.open.agent.util.d.n(i3, b16, String.valueOf(this.f340249e));
        String J = J();
        if (b16 == null) {
            str4 = "";
        } else {
            str4 = b16.f341678a;
        }
        com.tencent.open.agent.util.d.t(i3, J, str4);
        Intent intent = new Intent();
        intent.putExtra("key_cancel_auth", 0);
        intent.putExtra("key_error_code", i3);
        intent.putExtra("key_error_msg", str2);
        intent.putExtra("key_error_detail", str3);
        intent.putExtra("key_response", str);
        t.b("SelectPermissionPresenter", "OpenVirtual.setSdkResult, error: ", Integer.valueOf(i3), ", msg:", str2, ", detail:", str3);
        this.f340259o.setResult(102, intent);
        this.f340259o.finish();
        this.f340246b.L();
    }

    private void R() {
        List<hp3.e> g16 = hp3.b.e().g(J());
        if (g16 == null) {
            t.b("SelectPermissionPresenter", "updateMemoryPermissionList == null");
            return;
        }
        ArrayList<hp3.e> arrayList = new ArrayList();
        for (hp3.e eVar : g16) {
            hp3.e eVar2 = new hp3.e();
            eVar2.f405819a = eVar.f405819a;
            eVar2.f405823e = eVar.f405823e;
            eVar2.f405824f = eVar.f405824f;
            eVar2.f405822d = eVar.f405822d;
            eVar2.f405820b = eVar.f405820b;
            eVar2.f405821c = eVar.f405821c;
            eVar2.f405825g = true;
            arrayList.add(eVar2);
        }
        if (!this.f340248d.isEmpty()) {
            for (hp3.e eVar3 : this.f340248d) {
                for (hp3.e eVar4 : arrayList) {
                    if (eVar3.f405824f == eVar4.f405824f) {
                        eVar4.f405825g = eVar3.f405825g;
                    }
                }
            }
        }
        hp3.b.e().m(J(), arrayList);
    }

    private void S() {
        List<hp3.e> g16 = hp3.b.e().g(J());
        if (g16 == null) {
            t.b("SelectPermissionPresenter", "updateMemoryPermissionList == null");
            return;
        }
        ArrayList<hp3.e> arrayList = new ArrayList();
        for (hp3.e eVar : g16) {
            hp3.e eVar2 = new hp3.e();
            eVar2.f405819a = eVar.f405819a;
            eVar2.f405823e = eVar.f405823e;
            eVar2.f405824f = eVar.f405824f;
            eVar2.f405822d = eVar.f405822d;
            eVar2.f405820b = eVar.f405820b;
            eVar2.f405821c = eVar.f405821c;
            eVar2.f405825g = eVar.f405825g;
            arrayList.add(eVar2);
        }
        if (!this.f340248d.isEmpty()) {
            for (hp3.e eVar3 : this.f340248d) {
                for (hp3.e eVar4 : arrayList) {
                    if (eVar3.f405824f == eVar4.f405824f) {
                        eVar4.f405825g = eVar3.f405825g;
                    }
                }
            }
        }
        hp3.b.e().o(J(), arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T(String str, String str2) {
        this.f340245a.c(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U(String str, String str2) {
        com.tencent.open.model.a b16 = hp3.b.e().b(str2);
        if (b16 != null) {
            this.f340245a.a(str, str2, b16.f341678a);
        }
    }

    public boolean L() {
        preAuth$PreAuthResponse i3;
        if (this.f340250f != 0 || (i3 = hp3.b.e().i(String.valueOf(this.f340249e))) == null || !i3.is_high_quality_game.has()) {
            return false;
        }
        return i3.is_high_quality_game.get();
    }

    @Override // ep3.j
    public String a() {
        StringBuilder sb5 = new StringBuilder();
        Iterator<hp3.e> it = this.f340248d.iterator();
        while (it.hasNext()) {
            sb5.append(it.next().f405820b);
            sb5.append(" ");
        }
        return sb5.toString();
    }

    @Override // ep3.j
    public void b(Intent intent) {
        this.f340256l = intent.getStringExtra("pkg_name");
        this.f340257m = intent.getBooleanExtra("is_from_qr_login", false);
        this.f340255k = intent.getLongExtra("vid", 0L);
        this.f340249e = o.c(intent.getStringExtra("appId"));
        this.f340250f = o.c(intent.getStringExtra("key_proxy_appid"));
        this.f340251g = com.tencent.open.agent.util.c.o(intent.getStringExtra("key_proxy_token"));
        this.f340254j = intent.getLongExtra("login_cost", 0L);
        this.f340253i = intent.getLongExtra("authListCostTime", 0L);
        this.f340252h = intent.getLongExtra("authStartTime", SystemClock.elapsedRealtime());
        this.f340258n = intent.getStringExtra("appName");
        if (L()) {
            this.f340260p = new Intent(intent);
        }
        t.b("SelectPermissionPresenter", "onCreateView3 mCurrentAppId=", Long.valueOf(this.f340249e), ", mProxyCurrentAppId=", Long.valueOf(this.f340250f), ", proxyToken=", this.f340251g, ", mIsFromQrLogin=", Boolean.valueOf(this.f340257m));
    }

    @Override // ep3.j
    public void c(boolean z16) {
        t.b("SelectPermissionPresenter", "doAuth");
        if (z16) {
            boolean L = L();
            t.f("SelectPermissionPresenter", "doAuth isCompetitiveGame= " + L);
            if (L) {
                R();
                M();
                return;
            }
        }
        if (dq3.f.f394643a.t() && this.f340259o != null) {
            ((IOpenSdkApi) QRoute.api(IOpenSdkApi.class)).openRecommendFragment(this.f340259o);
            return;
        }
        S();
        this.f340247c = 0;
        F();
    }

    @Override // ep3.j
    public void d(boolean z16) {
        if (!z16) {
            return;
        }
        ThreadManagerV2.executeOnFileThread(new Runnable() { // from class: com.tencent.open.agent.auth.presenter.SelectPermissionPresenter.1
            @Override // java.lang.Runnable
            public void run() {
                final Bitmap j3 = OpenSdkVirtualUtil.j(MobileQQ.sMobileQQ, SelectPermissionPresenter.this.J());
                if (j3 == null) {
                    return;
                }
                UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.open.agent.auth.presenter.SelectPermissionPresenter.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SelectPermissionPresenter.this.f340246b.setImageBitmap(j3);
                    }
                });
            }
        });
    }

    @Override // ep3.j
    public List<hp3.e> e() {
        boolean z16;
        List<hp3.e> g16 = hp3.b.e().g(J());
        if (g16 == null) {
            return null;
        }
        for (hp3.e eVar : g16) {
            hp3.e eVar2 = new hp3.e();
            int i3 = eVar.f405819a;
            eVar2.f405819a = i3;
            if (i3 == 2 || i3 == 3) {
                eVar2.f405823e = eVar.f405823e;
                eVar2.f405824f = eVar.f405824f;
                eVar2.f405822d = eVar.f405822d;
                eVar2.f405820b = eVar.f405820b;
                eVar2.f405821c = eVar.f405821c;
                if (i3 == 2) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                eVar2.f405825g = z16;
                this.f340248d.add(eVar2);
            }
        }
        return this.f340248d;
    }
}
