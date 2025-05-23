package com.tencent.open.agent.auth.presenter;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.gamecenter.api.IGameCenterAuthApi;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.login.QAdLoginDefine$LoginStatus;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.open.agent.CreateVirtualAccountFragment;
import com.tencent.open.agent.OpenSelectPermissionFragment;
import com.tencent.open.agent.PublicFragmentActivityForOpenSDK;
import com.tencent.open.agent.auth.model.NewAuthDataSourceImpl;
import com.tencent.open.agent.auth.presenter.NewAuthorityPresenter;
import com.tencent.open.agent.auth.presenter.j;
import com.tencent.open.agent.auth.util.AppAuthLimitHelper;
import com.tencent.open.agent.util.o;
import com.tencent.open.agent.util.p;
import com.tencent.open.agent.util.t;
import com.tencent.open.api.IOpenSdkApi;
import com.tencent.open.base.http.AvatarUpdateService;
import com.tencent.open.base.http.d;
import com.tencent.open.model.AccountManage;
import com.tencent.open.model.VirtualInfo;
import com.tencent.open.ticket.NtTicketInvalidFixUtils;
import com.tencent.open.ticket.OpenTicketHelper;
import com.tencent.open.virtual.OpenSdkVirtualUtil;
import com.tencent.qconn.protofile.preAuth$PreAuthResponse;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONObject;

@RequiresApi(api = 3)
/* loaded from: classes22.dex */
public class NewAuthorityPresenter extends BaseAuthorityPresenter implements ep3.d {
    private int F;
    private long G;
    private long H;
    private boolean I;
    private boolean J;
    private long K;
    private final ep3.e L;
    private Handler M;
    private fp3.a N;

    /* loaded from: classes22.dex */
    class a implements Handler.Callback {
        a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    NewAuthorityPresenter.this.h1();
                    return true;
                case 2:
                    NewAuthorityPresenter.this.L.T7(NewAuthorityPresenter.this.f340190y.f341678a);
                    return true;
                case 3:
                    NewAuthorityPresenter.this.W0((com.tencent.open.model.e) message.obj);
                    return true;
                case 4:
                    NewAuthorityPresenter.this.b1((preAuth$PreAuthResponse) message.obj);
                    return true;
                case 5:
                    NewAuthorityPresenter.this.X0((hp3.a) message.obj);
                    return true;
                case 6:
                    NewAuthorityPresenter.this.S((fp3.b) message.obj);
                    return true;
                default:
                    return true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes22.dex */
    public class b implements j.b {
        b() {
        }

        @Override // com.tencent.open.agent.auth.presenter.j.b
        public void onFail(int i3, String str) {
            if (NewAuthorityPresenter.this.f340190y != null) {
                t.b("NewAuthorityPresenter", "updatePreAuthFromServer | onFail: | uin : *" + com.tencent.open.agent.util.g.C(NewAuthorityPresenter.this.f340190y.f341678a), ", errorCode=", Integer.valueOf(i3), ", errorMsg=", str);
            } else {
                t.b("NewAuthorityPresenter", "updatePreAuthFromServer | onFail: | uin : *", ", errorCode=", Integer.valueOf(i3), ", errorMsg=", str);
            }
            if (!NewAuthorityPresenter.this.N0()) {
                t.e("NewAuthorityPresenter", "updatePreAuthFromServer onFail for activity is finished");
                return;
            }
            if (i3 == 110537) {
                NewAuthorityPresenter newAuthorityPresenter = NewAuthorityPresenter.this;
                if (newAuthorityPresenter.f340190y != null) {
                    newAuthorityPresenter.L0(i3, false);
                    t.e("NewAuthorityPresenter", "updatePreAuthFromServer handle110537");
                    return;
                }
            }
            if (NewAuthorityPresenter.this.K0(i3, 3, str)) {
                t.e("NewAuthorityPresenter", "updatePreAuthFromServer handle110509");
            } else {
                if (NewAuthorityPresenter.this.M0(i3)) {
                    return;
                }
                Message.obtain(NewAuthorityPresenter.this.M, 3, null).sendToTarget();
                NewAuthorityPresenter.this.B(3001, R.string.cov);
            }
        }

        @Override // com.tencent.open.agent.auth.presenter.j.b
        public void onSuccess() {
            if (!NewAuthorityPresenter.this.N0()) {
                t.e("NewAuthorityPresenter", "updatePreAuthFromServer onSuccess for activity is finished");
                return;
            }
            hp3.a c16 = hp3.b.e().c(NewAuthorityPresenter.this.z());
            t.b("NewAuthorityPresenter", "updatePreAuthFromServer use cached realAppId=", NewAuthorityPresenter.this.z(), ", appInfo=", c16);
            Message.obtain(NewAuthorityPresenter.this.M, 5, c16);
            com.tencent.open.model.e j3 = hp3.b.e().j(NewAuthorityPresenter.this.z());
            t.b("NewAuthorityPresenter", "updatePreAuthFromServer back, virtualResult=", j3);
            Message.obtain(NewAuthorityPresenter.this.M, 3, j3).sendToTarget();
            NewAuthorityPresenter newAuthorityPresenter = NewAuthorityPresenter.this;
            if (!newAuthorityPresenter.f340180o) {
                newAuthorityPresenter.L.H7(true);
            }
            Message.obtain(NewAuthorityPresenter.this.M, 4, hp3.b.e().i(NewAuthorityPresenter.this.z())).sendToTarget();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes22.dex */
    public class c implements j.b {
        c() {
        }

        @Override // com.tencent.open.agent.auth.presenter.j.b
        public void onFail(int i3, String str) {
            t.b("NewAuthorityPresenter", "getVirtualList onFail errorCode=", Integer.valueOf(i3), ", msg=", str);
            if (i3 == 110537) {
                NewAuthorityPresenter newAuthorityPresenter = NewAuthorityPresenter.this;
                if (newAuthorityPresenter.f340190y != null) {
                    newAuthorityPresenter.L0(i3, true);
                    t.e("NewAuthorityPresenter", "getVirtualList handle110537");
                    return;
                }
            }
            if (NewAuthorityPresenter.this.K0(i3, 2, str)) {
                t.e("NewAuthorityPresenter", "getVirtualList handle110509");
            } else {
                if (NewAuthorityPresenter.this.M0(i3)) {
                    return;
                }
                Message.obtain(NewAuthorityPresenter.this.M, 3, null).sendToTarget();
            }
        }

        @Override // com.tencent.open.agent.auth.presenter.j.b
        public void onSuccess() {
            Message.obtain(NewAuthorityPresenter.this.M, 3, hp3.b.e().j(NewAuthorityPresenter.this.z())).sendToTarget();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes22.dex */
    public class d implements d.a {
        d() {
        }

        @Override // com.tencent.open.base.http.d.a
        public void r1(String str, Bitmap bitmap) {
            t.b("NewAuthorityPresenter", "onTaskCompleted uin=", com.tencent.open.agent.util.g.C(str), ", bitmap=", bitmap);
            if (bitmap != null && str.equals(NewAuthorityPresenter.this.f340190y.f341678a)) {
                NewAuthorityPresenter.this.M.sendEmptyMessage(2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes22.dex */
    public class e implements AccountManage.h {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f340219a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f340220b;

        e(int i3, String str) {
            this.f340219a = i3;
            this.f340220b = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d(String str, DialogInterface dialogInterface, int i3) {
            NewAuthorityPresenter.this.c0(str);
        }

        @Override // com.tencent.open.model.AccountManage.h
        public void a(final String str, Bundle bundle) {
            String str2;
            if (!NewAuthorityPresenter.this.N0()) {
                t.b("NewAuthorityPresenter", "refreshTicket onFail Activity Finishing");
                return;
            }
            if (this.f340219a == 1) {
                com.tencent.open.agent.util.d.s(NewAuthorityPresenter.this.f340189x, "0X800B65F");
            }
            boolean b16 = com.tencent.open.agent.util.b.b(bundle);
            t.e("NewAuthorityPresenter", "refreshTicketBySSOFailed triggerReason=", Integer.valueOf(this.f340219a), ", isIMBlock=", Boolean.valueOf(b16), ", uin=", com.tencent.open.agent.util.g.C(str));
            if (b16) {
                com.tencent.open.b.c(str);
            }
            NewAuthorityPresenter.this.L.dismissProgressDialog();
            if (TextUtils.isEmpty(this.f340220b)) {
                str2 = HardCodeUtil.qqStr(R.string.f213565qj);
            } else {
                str2 = this.f340220b;
            }
            NewAuthorityPresenter.this.L.w2(str2, new DialogInterface.OnClickListener() { // from class: com.tencent.open.agent.auth.presenter.f
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    NewAuthorityPresenter.e.this.d(str, dialogInterface, i3);
                }
            });
        }

        @Override // com.tencent.open.model.AccountManage.h
        public void b(com.tencent.open.model.a aVar) {
            t.b("NewAuthorityPresenter", "refreshTicketBySSOFailed success info.uin=" + com.tencent.open.agent.util.g.C(aVar.f341678a), ", triggerReason=", Integer.valueOf(this.f340219a));
            if (!NewAuthorityPresenter.this.N0()) {
                t.b("NewAuthorityPresenter", "refreshTicketBySSOFailed success Activity Finishing");
                return;
            }
            NewAuthorityPresenter.this.L.dismissProgressDialog();
            hp3.b.e().q(NewAuthorityPresenter.this.z(), aVar);
            int i3 = this.f340219a;
            if (i3 == 1) {
                long ia5 = NewAuthorityPresenter.this.L.ia();
                List<hp3.e> D0 = NewAuthorityPresenter.this.D0();
                k kVar = new k();
                NewAuthorityPresenter newAuthorityPresenter = NewAuthorityPresenter.this;
                boolean z16 = newAuthorityPresenter.f340181p;
                String G0 = newAuthorityPresenter.G0();
                String H0 = NewAuthorityPresenter.this.H0();
                NewAuthorityPresenter newAuthorityPresenter2 = NewAuthorityPresenter.this;
                kVar.f(z16, G0, H0, newAuthorityPresenter2.f340188w, D0, ia5, newAuthorityPresenter2.N, com.tencent.open.agent.util.c.g(NewAuthorityPresenter.this.C));
                return;
            }
            if (i3 == 2) {
                NewAuthorityPresenter.this.J0();
            } else if (i3 == 3) {
                NewAuthorityPresenter.this.i1();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes22.dex */
    public class f implements fp3.a {
        f() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c(com.tencent.open.model.a aVar, DialogInterface dialogInterface, int i3) {
            String str;
            NewAuthorityPresenter newAuthorityPresenter = NewAuthorityPresenter.this;
            if (aVar == null) {
                str = null;
            } else {
                str = aVar.f341678a;
            }
            newAuthorityPresenter.c0(str);
        }

        @Override // fp3.a
        public void a(boolean z16, int i3, fp3.b bVar) {
            com.tencent.open.agent.util.d.h("KEY_AUTHORIZE_REQUEST", NewAuthorityPresenter.this.f340190y, z16);
            NewAuthorityPresenter.this.L.dismissLoading();
            if (z16 && bVar != null) {
                Message.obtain(NewAuthorityPresenter.this.M, 6, bVar).sendToTarget();
                return;
            }
            if (i3 == 110509) {
                String qqStr = HardCodeUtil.qqStr(R.string.f213565qj);
                if (bVar != null && !TextUtils.isEmpty(bVar.f400228b.get())) {
                    qqStr = bVar.f400228b.get();
                }
                if (NewAuthorityPresenter.this.F >= 2) {
                    com.tencent.open.agent.util.d.s(NewAuthorityPresenter.this.f340189x, "0X800B65F");
                    final com.tencent.open.model.a b16 = hp3.b.e().b(NewAuthorityPresenter.this.z());
                    NewAuthorityPresenter.this.L.w2(qqStr, new DialogInterface.OnClickListener() { // from class: com.tencent.open.agent.auth.presenter.g
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i16) {
                            NewAuthorityPresenter.f.this.c(b16, dialogInterface, i16);
                        }
                    });
                    return;
                } else {
                    NewAuthorityPresenter.this.F++;
                    NewAuthorityPresenter.this.e1(1, qqStr);
                    return;
                }
            }
            if (i3 == 110537) {
                t.b("NewAuthorityPresenter", "onDoAuthorize 110537");
                NewAuthorityPresenter.this.L.M1(HardCodeUtil.qqStr(R.string.f213575qk), false);
                NewAuthorityPresenter newAuthorityPresenter = NewAuthorityPresenter.this;
                newAuthorityPresenter.a0(newAuthorityPresenter.f340189x);
                return;
            }
            AppAuthLimitHelper.b(i3, NewAuthorityPresenter.this.G0(), bVar);
            com.tencent.open.agent.util.d.s(NewAuthorityPresenter.this.f340189x, "0X800B65F");
            NewAuthorityPresenter.this.L.M1(com.tencent.open.agent.util.g.p(bVar, NewAuthorityPresenter.this.C.getResources(), i3), false);
        }
    }

    /* loaded from: classes22.dex */
    class g implements fp3.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.open.model.a f340223a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f340224b;

        g(com.tencent.open.model.a aVar, long j3) {
            this.f340223a = aVar;
            this.f340224b = j3;
        }

        @Override // fp3.d
        public boolean a(boolean z16, String str, int i3, String str2) {
            t.b("NewAuthorityPresenter", "deleteVirtual result=", str, ", success=", Boolean.valueOf(z16), ", errCode=", Integer.valueOf(i3), ", errMsg=", str2);
            com.tencent.open.agent.util.d.h("KEY_DELETE_VIRTUAL_D18", this.f340223a, z16);
            if (z16) {
                NewAuthorityPresenter.this.a1(this.f340224b, str, i3);
            } else {
                NewAuthorityPresenter.this.V0(i3);
            }
            return false;
        }
    }

    public NewAuthorityPresenter(ep3.e eVar, com.tencent.open.agent.auth.model.c cVar) {
        super(eVar, cVar);
        this.M = new Handler(new a());
        this.N = new f();
        this.L = eVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<hp3.e> D0() {
        List<hp3.e> g16 = hp3.b.e().g(z());
        ArrayList arrayList = new ArrayList();
        if (g16 != null && !g16.isEmpty()) {
            for (hp3.e eVar : g16) {
                hp3.e eVar2 = new hp3.e();
                eVar2.f405823e = eVar.f405823e;
                eVar2.f405819a = eVar.f405819a;
                eVar2.f405824f = eVar.f405824f;
                eVar2.f405822d = eVar.f405822d;
                eVar2.f405820b = eVar.f405820b;
                eVar2.f405825g = true;
                arrayList.add(eVar2);
            }
        }
        return arrayList;
    }

    private void E0(final List<hp3.e> list) {
        t.b("NewAuthorityPresenter", "onClick doAuthorize");
        if (AppAuthLimitHelper.d()) {
            this.L.showLoading();
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.open.agent.auth.presenter.e
                @Override // java.lang.Runnable
                public final void run() {
                    NewAuthorityPresenter.this.T0(list);
                }
            }, 128, null, false);
        } else {
            T0(list);
        }
    }

    private void F0() {
        if (!N0()) {
            t.e("NewAuthorityPresenter", "getAppInfo return for activity is finished");
            return;
        }
        this.f340185t = 2;
        hp3.a c16 = hp3.b.e().c(z());
        t.b("NewAuthorityPresenter", "getAppInfo use cached appid=", z(), ", appInfo=", c16);
        Message.obtain(this.M, 5, c16).sendToTarget();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String G0() {
        return this.f340186u;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String H0() {
        return this.f340187v;
    }

    private void I0() {
        t.b("NewAuthorityPresenter", "getVirtualList");
        this.I = false;
        this.J = false;
        J0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J0() {
        t.b("NewAuthorityPresenter", "getVirtualListFromServer");
        if (!NetworkUtil.isNetworkAvailable(this.C)) {
            t.b("NewAuthorityPresenter", "getVirtualListFromServer no network");
            return;
        }
        j jVar = new j();
        String G0 = G0();
        String z16 = z();
        Activity activity = this.C;
        jVar.j(G0, z16, activity, com.tencent.open.agent.util.c.g(activity), this.A, new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean K0(int i3, int i16, String str) {
        com.tencent.open.model.a aVar;
        t.b("NewAuthorityPresenter", "handle110509 mIn110509Retry=", Boolean.valueOf(this.J), ", errorCode=", Integer.valueOf(i3), ", triggerReason=", Integer.valueOf(i16), "mAccount=", this.f340190y, "msg=", str);
        if (i3 != 110509 || (aVar = this.f340190y) == null) {
            return false;
        }
        if (this.J) {
            this.J = false;
            c0(aVar.f341678a);
        } else {
            this.J = true;
            this.L.showProgressDialog(R.string.cow);
            e1(i16, str);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L0(int i3, final boolean z16) {
        t.b("NewAuthorityPresenter", "handle110537 mIn110537Retry=", Boolean.valueOf(this.I), ", errorCode=", Integer.valueOf(i3), ", isGetVirtualList=", Boolean.valueOf(z16), "mAccount=", this.f340190y);
        com.tencent.open.b.c(this.f340190y.f341678a);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (!MobileQQ.sMobileQQ.isLoginByNT()) {
            if (!this.I && com.tencent.open.agent.util.g.l(this.f340190y.f341678a, peekAppRuntime, false) != null) {
                if (z16) {
                    this.I = true;
                    J0();
                    return;
                } else {
                    this.I = true;
                    i1();
                    return;
                }
            }
            this.I = false;
            c0(this.f340190y.f341678a);
            return;
        }
        OpenTicketHelper.f(this.f340190y.f341678a, false, new com.tencent.open.agent.util.i() { // from class: com.tencent.open.agent.auth.presenter.NewAuthorityPresenter.3
            @Override // com.tencent.open.agent.util.i
            public void a(byte[] bArr) {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.open.agent.auth.presenter.NewAuthorityPresenter.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (NewAuthorityPresenter.this.I) {
                            NewAuthorityPresenter.this.I = false;
                            NewAuthorityPresenter newAuthorityPresenter = NewAuthorityPresenter.this;
                            newAuthorityPresenter.c0(newAuthorityPresenter.f340190y.f341678a);
                            return;
                        }
                        AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                        if (z16) {
                            NewAuthorityPresenter.this.I = true;
                            NewAuthorityPresenter.this.J0();
                        } else {
                            NewAuthorityPresenter.this.I = true;
                            NewAuthorityPresenter.this.i1();
                        }
                    }
                });
            }

            @Override // com.tencent.open.agent.util.i
            public void onFail(int i16, String str) {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.open.agent.auth.presenter.NewAuthorityPresenter.3.2
                    @Override // java.lang.Runnable
                    public void run() {
                        NewAuthorityPresenter.this.I = false;
                        NewAuthorityPresenter newAuthorityPresenter = NewAuthorityPresenter.this;
                        newAuthorityPresenter.c0(newAuthorityPresenter.f340190y.f341678a);
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean M0(int i3) {
        if (NtTicketInvalidFixUtils.a() && i3 == 2001) {
            com.tencent.open.model.a aVar = this.f340190y;
            if (aVar != null) {
                c0(aVar.f341678a);
                String account = MobileQQ.sMobileQQ.peekAppRuntime().getAccount();
                if (account != null && account.equals(this.f340190y.f341678a)) {
                    d(account, true);
                }
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean N0() {
        Activity activity = this.C;
        if (activity != null && !activity.isFinishing()) {
            return true;
        }
        return false;
    }

    private boolean O0() {
        List<hp3.e> g16 = hp3.b.e().g(z());
        if (g16 != null && !g16.isEmpty()) {
            Iterator<hp3.e> it = g16.iterator();
            while (it.hasNext()) {
                int i3 = it.next().f405819a;
                if (i3 == 2 || i3 == 3) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean P0(String str) {
        preAuth$PreAuthResponse i3 = hp3.b.e().i(str);
        if (i3 != null && i3.is_high_quality_game.has()) {
            return i3.is_high_quality_game.get();
        }
        return false;
    }

    private boolean Q0() {
        if (TextUtils.isEmpty(this.f340187v) && P0(this.f340186u)) {
            return true;
        }
        return false;
    }

    private void R0() {
        String str;
        t.b("NewAuthorityPresenter", "onClick to gameCenterAuthFragment");
        Intent intent = new Intent();
        intent.putExtra("appId", o.c(this.f340186u));
        intent.putExtra("key_proxy_appid", o.c(this.f340187v));
        intent.putExtra("vid", this.L.ia());
        preAuth$PreAuthResponse i3 = hp3.b.e().i(z());
        if (i3 == null) {
            str = "";
        } else {
            str = i3.app_name.get();
        }
        intent.putExtra("appName", str);
        intent.putExtra("hasIcon", this.f340178m);
        intent.putExtra("login_cost", this.f340169d - this.f340168c);
        long j3 = this.H;
        if (j3 == 0) {
            j3 = SystemClock.elapsedRealtime();
        }
        intent.putExtra("authStartTime", j3);
        intent.putExtra("authListCostTime", this.f340170e);
        intent.putExtra("is_from_qr_login", this.f340181p);
        intent.putExtra("public_fragment_window_feature", 1);
        intent.putExtra("packagename", this.A.getString("packagename"));
        intent.putExtra("packagesign", this.A.getString("packagesign"));
        intent.putExtra("pkg_name", com.tencent.open.agent.util.c.g(this.C));
        intent.putExtra("sdkv", this.f340175j);
        ((IGameCenterAuthApi) QRoute.api(IGameCenterAuthApi.class)).jump2AuthFragmentWhenLogin(this.C, intent, PublicFragmentActivityForOpenSDK.class, 103);
    }

    private void S0() {
        String str;
        t.b("NewAuthorityPresenter", "onClick to OpenSelectPermissionFragment");
        preAuth$PreAuthResponse i3 = hp3.b.e().i(z());
        Intent intent = new Intent();
        intent.putExtra("appId", this.f340186u);
        intent.putExtra("key_proxy_appid", this.f340187v);
        intent.putExtra("key_proxy_token", this.A.getString("key_proxy_token"));
        intent.putExtra("vid", this.L.ia());
        if (i3 == null) {
            str = "";
        } else {
            str = i3.app_name.get();
        }
        intent.putExtra("appName", str);
        intent.putExtra("hasIcon", this.f340178m);
        intent.putExtra("login_cost", this.f340169d - this.f340168c);
        long j3 = this.H;
        if (j3 == 0) {
            j3 = SystemClock.elapsedRealtime();
        }
        intent.putExtra("authStartTime", j3);
        intent.putExtra("authListCostTime", this.f340170e);
        intent.putExtra("is_from_qr_login", this.f340181p);
        intent.putExtra("public_fragment_window_feature", 1);
        intent.putExtra("packagename", this.A.getString("packagename"));
        intent.putExtra("packagesign", this.A.getString("packagesign"));
        intent.putExtra("pkg_name", com.tencent.open.agent.util.c.g(this.C));
        intent.putExtra("sdkv", this.f340175j);
        com.tencent.open.agent.util.d.B("KEY_LOGIN_STAGE_2_2_NEW_TOTAL");
        QPublicFragmentActivity.b.e(this.C, intent, PublicFragmentActivityForOpenSDK.class, OpenSelectPermissionFragment.class, 102);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U0() {
        this.L.gf(null, this.f340190y.f341678a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W0(com.tencent.open.model.e eVar) {
        boolean z16;
        boolean z17;
        if (eVar != null && eVar.f341693a == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        t.b("NewAuthorityPresenter", "-->onGetVirtualList isSuccess=", Boolean.valueOf(z16));
        com.tencent.open.agent.util.d.h("KEY_GET_VIRTUAL_LIST_D24", this.f340190y, z16);
        if (!N0()) {
            t.e("NewAuthorityPresenter", " activity is isInvalid");
            return;
        }
        if (eVar == null) {
            this.L.ud(0, null, this.G);
            return;
        }
        int i3 = eVar.f341693a;
        if (i3 != 0) {
            t.b("NewAuthorityPresenter", "getVirtualList errorCode ===", Integer.valueOf(i3));
            this.L.ud(eVar.f341693a, null, this.G);
            return;
        }
        if (this.L.ia() == 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        List<hp3.h> h16 = com.tencent.open.agent.util.b.h(eVar, z17);
        t.b("NewAuthorityPresenter", "onGetVirtualList setData accountInfoList.size=", Integer.valueOf(h16.size()));
        this.L.ud(0, h16, this.G);
        this.G = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X0(hp3.a aVar) {
        t.b("NewAuthorityPresenter", "parseAppInfoResponse hasAppIcon=", Boolean.valueOf(this.f340178m), ", response=", aVar);
        if (aVar == null) {
            return;
        }
        String c16 = aVar.c();
        if (!TextUtils.isEmpty(c16)) {
            this.L.p0(c16, null);
            t.b("NewAuthorityPresenter", "parseGetAppInfoResponse appName=", c16);
        }
        if (this.f340178m) {
            return;
        }
        List<hp3.d> d16 = aVar.d();
        if (d16.isEmpty()) {
            t.b("NewAuthorityPresenter", "parseGetAppInfoResponse iconsURL none");
        } else {
            v(d16.get(y(d16)));
        }
    }

    private void Y0(preAuth$PreAuthResponse preauth_preauthresponse) {
        this.H = SystemClock.elapsedRealtime();
        this.f340179n = false;
        hp3.b.e().r(z(), this.H);
        J(this.L.A9(hp3.b.e().g(z()), preauth_preauthresponse.authorized_union_text.get()));
        this.L.H7(true);
        this.L.dismissProgressDialog();
        F0();
    }

    private void Z0(Bundle bundle) {
        if (this.f340183r) {
            com.tencent.open.agent.util.b.d(bundle);
            s();
            this.L.Me();
        } else if (!"action_login".equals(com.tencent.open.agent.util.c.l(this.D, "key_action"))) {
            this.L.Me();
        } else if (E()) {
            this.f340180o = false;
        } else {
            s();
            this.L.Me();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a1(long j3, String str, int i3) {
        try {
            i3 = new JSONObject(str).optInt("ErrorCode");
            if (i3 == 0) {
                Iterator<VirtualInfo> it = hp3.b.e().j(z()).f341695c.iterator();
                while (it.hasNext()) {
                    if (it.next().f341675d == j3) {
                        it.remove();
                        return;
                    }
                }
                return;
            }
        } catch (Exception e16) {
            t.d("NewAuthorityPresenter", "Exception", e16);
        }
        V0(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b1(preAuth$PreAuthResponse preauth_preauthresponse) {
        if (preauth_preauthresponse == null) {
            this.L.dismissProgressDialog();
            t.b("NewAuthorityPresenter", "GET_API_LIST_DONE  response = null");
            return;
        }
        int i3 = preauth_preauthresponse.ret.get();
        t.b("NewAuthorityPresenter", "parseGetAuthListResult ret=", Integer.valueOf(i3));
        if (i3 == 0) {
            Y0(preauth_preauthresponse);
        } else {
            R(preauth_preauthresponse.f342476msg.get(), i3);
        }
    }

    private void c1() {
        if (this.f340190y == null) {
            t.b("NewAuthorityPresenter", "queryAuthList mAccount == null");
            this.L.ld(30000L);
            return;
        }
        preAuth$PreAuthResponse i3 = hp3.b.e().i(z());
        t.b("NewAuthorityPresenter", "queryAuthorityUseCache response=", i3);
        if (i3 == null) {
            this.I = false;
            this.J = false;
            i1();
            return;
        }
        Message.obtain(this.M, 4, i3).sendToTarget();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d1, reason: merged with bridge method [inline-methods] */
    public void T0(List<hp3.e> list) {
        int i3;
        String str;
        if (this.f340181p) {
            i3 = 2;
        } else {
            i3 = 1;
        }
        long ia5 = this.L.ia();
        if (ia5 == 0) {
            str = "0X800A117";
        } else {
            str = "0X800A116";
        }
        String str2 = str;
        ReportController.o(null, "dc00898", "", "", str2, str2, i3, 0, "", "", "", "");
        com.tencent.open.agent.util.d.B("KEY_AUTHORIZE_REQUEST");
        com.tencent.open.agent.util.d.g("KEY_LOGIN_STAGE_2_NEW_TOTAL", this.f340190y, com.tencent.open.agent.util.d.a(this.f340186u), true);
        com.tencent.open.agent.util.d.B("KEY_LOGIN_STAGE_3_TOTAL");
        this.F = 0;
        new k().f(this.f340181p, G0(), H0(), this.f340188w, list, ia5, this.N, com.tencent.open.agent.util.c.g(this.C));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e1(int i3, String str) {
        t.e("NewAuthorityPresenter", "refreshTicketBySSOFailed triggerReason=", Integer.valueOf(i3));
        AccountManage.g().j(hp3.b.e().b(z()).f341678a, z(), 3, new e(i3, str));
    }

    private void f1() {
        Message.obtain(this.M, 3, hp3.b.e().j(z())).sendToTarget();
    }

    private void g1() {
        int i3;
        int i16;
        com.tencent.open.agent.util.d.B("KEY_LOGIN_STAGE_2_NEW_TOTAL");
        com.tencent.open.agent.util.d.B("KEY_LOGIN_STAGE_2_1_NEW_TOTAL");
        if (this.f340181p) {
            i3 = 2;
        } else {
            i3 = 1;
        }
        com.tencent.open.agent.util.d.p("0X800A115", i3);
        com.tencent.open.agent.util.d.s(this.f340189x, "0X800B65C");
        com.tencent.open.agent.util.d.z(this.f340189x, z(), "1", "0", false);
        List<String> list = this.f340191z;
        if (list != null) {
            i16 = list.size();
        } else {
            i16 = -1;
        }
        com.tencent.open.agent.util.g.R(null, "0X800B934", new String[]{this.f340186u, String.valueOf(i16), this.A.getString("oauth_app_name"), this.f340175j});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h1() {
        t.b("NewAuthorityPresenter", "showUserInfo uin=" + com.tencent.open.agent.util.g.C(this.f340190y.f341678a));
        this.L.T7(this.f340190y.f341678a);
        AvatarUpdateService.a().c(this.C, this.f340190y.f341678a, z(), new d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i1() {
        byte[] bArr;
        t.b("NewAuthorityPresenter", "-->updatePreAuthFromServer--");
        if (!N0()) {
            t.e("NewAuthorityPresenter", "updatePreAuthFromServer for activity is finished");
            return;
        }
        if (!NetworkUtil.isNetworkAvailable(this.C)) {
            t.b("NewAuthorityPresenter", "-->updatePreAuthFromServer isNetworkAvailable false--");
            this.L.ld(0L);
            return;
        }
        if (this.f340190y == null) {
            t.b("NewAuthorityPresenter", "-->updatePreAuthFromServer mAccount == null");
            this.L.ld(30000L);
            return;
        }
        if (!MobileQQ.sMobileQQ.isLoginByNT() && ((bArr = this.f340190y.f341679b) == null || bArr.length == 0)) {
            t.b("NewAuthorityPresenter", "-->updatePreAuthFromServer mAccount.st == null || mAccount.st.length == 0");
            B(3000, R.string.cov);
            return;
        }
        this.f340185t = 2;
        j jVar = new j();
        String G0 = G0();
        String z16 = z();
        Activity activity = this.C;
        jVar.j(G0, z16, activity, com.tencent.open.agent.util.c.g(activity), this.A, new b());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.open.agent.auth.presenter.BaseAuthorityPresenter
    public void I(fp3.b bVar) {
        com.tencent.open.agent.util.g.S(this.L.ia(), z(), this.f340175j);
        super.I(bVar);
    }

    @Override // com.tencent.open.agent.auth.presenter.BaseAuthorityPresenter
    protected void M(String str, int i3, Bundle bundle) {
        String C;
        if (!bundle.getBoolean("fake_callback") && i3 == 64) {
            up3.b.o(str, System.currentTimeMillis());
        }
        this.f340174i = 0;
        this.f340182q = false;
        this.f340169d = SystemClock.elapsedRealtime();
        this.L.H7(true);
        if (!this.f340183r) {
            this.M.sendEmptyMessage(1);
        }
        com.tencent.open.model.a b16 = hp3.b.e().b(z());
        if (b16 == null || !b16.f341678a.equals(this.f340190y.f341678a)) {
            if (b16 == null) {
                C = "null";
            } else {
                C = com.tencent.open.agent.util.g.C(b16.f341678a);
            }
            t.b("NewAuthorityPresenter", "loginSuccess, changeAccount old uin=", C, ", new uin=", com.tencent.open.agent.util.g.C(this.f340190y.f341678a));
            hp3.b.e().q(z(), this.f340190y);
            if (NtTicketInvalidFixUtils.a()) {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.open.agent.auth.presenter.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        NewAuthorityPresenter.this.U0();
                    }
                });
            }
            I0();
        }
        if (this.f340184s == 1) {
            new k().f(this.f340181p, this.f340186u, this.f340187v, this.f340188w, new ArrayList(), this.L.ia(), this.N, com.tencent.open.agent.util.c.g(this.C));
        } else {
            c1();
        }
    }

    public void V0(int i3) {
        t.e("NewAuthorityPresenter", "onDeleteVirtualFailed errCode=", Integer.valueOf(i3));
        f1();
        I0();
        if (i3 == 151) {
            this.L.M1(HardCodeUtil.qqStr(R.string.f213555qi), false);
            a0(this.f340189x);
        } else {
            if (i3 < 0) {
                this.L.M1(HardCodeUtil.qqStr(R.string.f172922rr), false);
                return;
            }
            this.L.M1(HardCodeUtil.qqStr(R.string.oyp) + i3, false);
        }
    }

    @Override // com.tencent.open.agent.auth.presenter.BaseAuthorityPresenter
    protected void Z(String str) {
        t.e("NewAuthorityPresenter", "showLocalInfo uin=", com.tencent.open.agent.util.g.C(str));
        if (!this.f340183r && !TextUtils.isEmpty(str)) {
            String b16 = OpenSdkVirtualUtil.b(str);
            if (!TextUtils.isEmpty(b16) && !b16.equals("0")) {
                e0(b16);
                this.L.T7(this.f340189x);
            } else {
                t.e("NewAuthorityPresenter", "showLocalInfo uin=", b16);
            }
        }
    }

    @Override // ep3.b
    public void a(int i3, Intent intent) {
        com.tencent.open.model.a aVar;
        com.tencent.open.model.a aVar2;
        this.f340169d = SystemClock.elapsedRealtime();
        if (i3 == 0) {
            if (TextUtils.isEmpty(this.f340189x)) {
                k();
                return;
            }
            return;
        }
        if (-1 == i3) {
            if (intent == null) {
                t.e("NewAuthorityPresenter", "onActivityResult, but data is null.");
                return;
            }
            d0(intent);
            this.f340173h = false;
            if (0 != o.c(this.f340186u)) {
                F0();
            }
            String stringExtra = intent.getStringExtra("last_account");
            String b16 = OpenSdkVirtualUtil.b(stringExtra);
            t.f("NewAuthorityPresenter", "onActivityResult: account: " + stringExtra + ", uin: " + MsfSdkUtils.getShortUin(b16));
            e0(b16);
            this.L.Me();
            this.L.gf(null, this.f340189x);
            Z(this.f340189x);
            this.M.sendEmptyMessage(1);
            if (intent.getBooleanExtra(QAdLoginDefine$LoginStatus.IS_LOGIN, false)) {
                this.E.b(this.f340189x);
                com.tencent.open.agent.util.g.V(this.f340189x);
            }
            Bundle d16 = com.tencent.open.agent.util.c.d(intent, "ssobundle");
            if (d16 != null) {
                byte[] byteArray = d16.getByteArray("st_temp");
                byte[] byteArray2 = d16.getByteArray("st_temp_key");
                if (byteArray != null && byteArray2 != null && (aVar2 = this.f340190y) != null) {
                    aVar2.f341679b = byteArray;
                    aVar2.f341680c = byteArray2;
                }
            }
            this.f340180o = true;
            this.L.H7(false);
            if (intent.getBooleanExtra("fromLoginPhoneNum", false) && (aVar = this.f340190y) != null && aVar.f341680c == null) {
                F(this.f340189x);
                return;
            }
            hp3.b.e().q(z(), this.f340190y);
            this.I = false;
            this.J = false;
            if (intent.getBooleanExtra(QAdLoginDefine$LoginStatus.IS_LOGIN, false) || this.f340182q) {
                this.f340182q = false;
                hp3.b.e().a(this.f340189x);
            }
            i1();
        }
    }

    @Override // ep3.d
    public void c() {
        com.tencent.open.model.a aVar;
        t.b("NewAuthorityPresenter", "onLoginBtnClick mGetTicketFailed=", Boolean.valueOf(this.f340182q));
        if (!NetworkUtil.isNetworkAvailable(this.C)) {
            t.b("NewAuthorityPresenter", "onClick isNetworkAvailable false");
            this.L.ld(0L);
            return;
        }
        if (!this.f340179n && !this.f340182q && (aVar = this.f340190y) != null) {
            if (this.f340185t == 0) {
                this.L.showProgressDialog(R.string.cow);
                c1();
                return;
            }
            com.tencent.open.agent.util.d.f("KEY_LOGIN_STAGE_2_1_NEW_TOTAL", aVar);
            List<hp3.e> D0 = D0();
            hp3.b.e().q(z(), this.f340190y);
            hp3.b.e().t(z(), this.A);
            if (O0()) {
                S0();
            } else if (Q0()) {
                R0();
            } else if (dq3.f.f394643a.t() && this.C != null) {
                ((IOpenSdkApi) QRoute.api(IOpenSdkApi.class)).openRecommendFragment(this.C);
            } else {
                E0(D0);
            }
            com.tencent.open.agent.util.d.z(this.f340189x, z(), "2", "0", false);
            com.tencent.open.agent.util.g.R(null, "0X800BA77", new String[]{this.f340186u, String.valueOf(this.L.fe(5)), com.tencent.open.agent.util.c.j(this.A, "oauth_app_name", ""), this.f340175j});
            return;
        }
        F(this.f340189x);
    }

    @Override // ep3.b
    public void d(String str, boolean z16) {
        com.tencent.open.agent.util.g.O("0X800BA7C");
        u(str, z16);
    }

    @Override // ep3.d
    public boolean e(long j3, boolean z16) {
        com.tencent.open.agent.util.g.O("0X800C347");
        if (!NetworkUtil.isNetworkAvailable(this.C)) {
            t.b("NewAuthorityPresenter", "deleteVirtual fail network unavailable");
            this.L.M1(HardCodeUtil.qqStr(R.string.f172922rr), false);
            return true;
        }
        com.tencent.open.model.a b16 = hp3.b.e().b(z());
        if (b16 == null) {
            t.b("NewAuthorityPresenter", "deleteVirtual fail for account is null");
            V0(-1);
            return true;
        }
        t.b("NewAuthorityPresenter", "deleteVirtual start uin=", com.tencent.open.agent.util.g.C(b16.f341678a));
        com.tencent.open.agent.util.d.B("KEY_DELETE_VIRTUAL_D18");
        new NewAuthDataSourceImpl().b(j3, z(), b16, z16, new g(b16, j3));
        return false;
    }

    @Override // ep3.d
    public void g(Intent intent) {
        int intExtra = intent.getIntExtra("createVirtualAccount", 0);
        if (intExtra == 1) {
            this.G = intent.getLongExtra("createVirtualVid", 0L);
            I0();
        } else if (intExtra == 2) {
            c0(this.f340189x);
        }
        t.b("NewAuthorityPresenter", "onActivityResult, CreateVirtualAccount code = " + this.f340189x);
    }

    @Override // ep3.d
    public String getCurrentAccount() {
        return this.f340189x;
    }

    @Override // ep3.d
    public void h(Intent intent) {
        int intExtra = intent.getIntExtra("key_cancel_auth", 0);
        int intExtra2 = intent.getIntExtra("key_error_code", 0);
        int intExtra3 = intent.getIntExtra("key_need_login", 0);
        boolean booleanExtra = intent.getBooleanExtra("key_need_show_uin", false);
        if (intExtra3 == 1) {
            t.b("NewAuthorityPresenter", "OpenVirtual.onActivityResult  REQUEST_CODE_SELECT_PERMISSION needLogin ");
            if (booleanExtra) {
                c0(this.f340189x);
                return;
            } else {
                a0(this.f340189x);
                return;
            }
        }
        if (intExtra == 1) {
            this.C.setResult(0);
        } else if (intExtra2 == 0 && this.f340181p) {
            p.d(this.A);
        } else {
            String stringExtra = intent.getStringExtra("key_error_msg");
            String stringExtra2 = intent.getStringExtra("key_error_detail");
            String stringExtra3 = intent.getStringExtra("key_response");
            t.b("NewAuthorityPresenter", "OpenVirtual.onActivityResult, error: ", Integer.valueOf(intExtra2), ", msg:", stringExtra, ", detail:", stringExtra2);
            Intent intent2 = new Intent();
            intent2.putExtra("key_error_code", intExtra2);
            intent2.putExtra("key_error_msg", stringExtra);
            intent2.putExtra("key_error_detail", stringExtra2);
            intent2.putExtra("key_response", stringExtra3);
            this.C.setResult(-1, intent2);
        }
        this.C.finish();
    }

    @Override // ep3.d
    public void i() {
        t.b("NewAuthorityPresenter", "onClick to CreateVirtualAccountFragment");
        com.tencent.open.agent.util.g.O("0X800BA7A");
        if (System.currentTimeMillis() - this.K <= 1000) {
            return;
        }
        this.K = System.currentTimeMillis();
        Intent intent = new Intent();
        intent.putExtra("appid", z());
        intent.putExtra("key_proxy_appid", this.f340187v);
        intent.putExtra("public_fragment_window_feature", 1);
        QPublicFragmentActivity.b.e(this.C, intent, PublicFragmentActivityForOpenSDK.class, CreateVirtualAccountFragment.class, 101);
    }

    @Override // com.tencent.open.agent.auth.presenter.BaseAuthorityPresenter, ep3.b
    public void k() {
        super.k();
        com.tencent.open.agent.util.g.O("0X800BA79");
    }

    @Override // com.tencent.open.agent.auth.presenter.BaseAuthorityPresenter, ep3.b
    public void l() {
        super.l();
        com.tencent.open.agent.util.g.O("0X800BA7D");
    }

    @Override // ep3.d
    public void onCreate(Bundle bundle) {
        t.b("NewAuthorityPresenter", "onCreate44");
        if (bundle == null) {
            t.b("NewAuthorityPresenter", "param is null, finish activity");
            X(-5, "params is null", "params is null", "params is null");
        } else {
            D(bundle);
            g1();
            Z0(bundle);
        }
    }
}
