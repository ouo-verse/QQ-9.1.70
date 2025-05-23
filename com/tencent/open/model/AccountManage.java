package com.tencent.open.model;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.loginregister.servlet.ILoginServletService;
import com.tencent.mobileqq.loginregister.servlet.f;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.thirdsig.api.IThirdSigService;
import com.tencent.open.agent.util.i;
import com.tencent.open.agent.util.t;
import com.tencent.open.agent.util.u;
import com.tencent.open.virtual.OpenSdkVirtualUtil;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.TicketManagerImpl;
import mqq.manager.Manager;
import mqq.manager.TicketManager;
import mqq.manager.WtloginManager;
import mqq.observer.SSOAccountObserver;
import mqq.os.MqqHandler;

/* compiled from: P */
/* loaded from: classes22.dex */
public class AccountManage {

    /* renamed from: a, reason: collision with root package name */
    private static AccountManage f341600a;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class a extends com.tencent.mobileqq.loginregister.servlet.f {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ h f341635d;

        a(h hVar) {
            this.f341635d = hVar;
        }

        @Override // com.tencent.mobileqq.loginregister.servlet.f
        public void a(String str, int i3, int i16, Bundle bundle) {
            Object valueOf;
            Object[] objArr = new Object[5];
            objArr[0] = "-->getTicketNoPasswd onFailed";
            objArr[1] = ", action";
            objArr[2] = Integer.valueOf(i3);
            objArr[3] = ", code=";
            if (bundle == null) {
                valueOf = "null";
            } else {
                valueOf = Integer.valueOf(bundle.getInt("code"));
            }
            objArr[4] = valueOf;
            t.b(SSOAccountObserver.TAG, objArr);
            this.f341635d.a(str, bundle);
        }

        @Override // com.tencent.mobileqq.loginregister.servlet.f
        public void c(String str, byte[] bArr, int i3, Bundle bundle) {
            t.b("BaseAccountManage", "getTicketNoPasswd onGetTicketNoPasswd");
            if (!bundle.getBoolean("fake_callback") && i3 == 64) {
                up3.b.o(str, System.currentTimeMillis());
            }
            com.tencent.open.model.a aVar = new com.tencent.open.model.a();
            aVar.f341678a = OpenSdkVirtualUtil.b(str);
            aVar.f341679b = bundle.getByteArray("st_temp");
            aVar.f341680c = bundle.getByteArray("st_temp_key");
            this.f341635d.b(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class b implements u {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f341637a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.loginregister.servlet.f f341638b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f341639c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Bundle f341640d;

        b(String str, com.tencent.mobileqq.loginregister.servlet.f fVar, int i3, Bundle bundle) {
            this.f341637a = str;
            this.f341638b = fVar;
            this.f341639c = i3;
            this.f341640d = bundle;
        }

        @Override // com.tencent.open.agent.util.u
        public void onResult(boolean z16, String str) {
            AccountManage.this.f(this.f341637a, this.f341638b, this.f341639c, this.f341640d, z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class c implements i {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Bundle f341642a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f341643b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f341644c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.loginregister.servlet.f f341645d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f341646e;

        /* compiled from: P */
        /* loaded from: classes22.dex */
        class a implements i {
            a() {
            }

            @Override // com.tencent.open.agent.util.i
            public void a(final byte[] bArr) {
                final Bundle bundle;
                t.b("BaseAccountManage", "update get open sdk A2 onSuccess");
                if (c.this.f341642a != null) {
                    bundle = new Bundle(c.this.f341642a);
                } else {
                    bundle = new Bundle();
                }
                c cVar = c.this;
                if (3 == cVar.f341643b && cVar.f341644c) {
                    t.b("BaseAccountManage", "delegateGetTicketNoPasswd 110509 and use540Ticket");
                    bundle.putLong("dwSrcAppid", BaseConstants.OPEN_SDK_BUFLAG_B1);
                    bundle.putLong("dwDstAppid", BaseConstants.OPEN_SDK_BUFLAG_B1);
                }
                ((WtloginManager) MobileQQ.sMobileQQ.peekAppRuntime().getManager(1)).refreshMemorySig();
                MqqHandler uIHandler = ThreadManager.getUIHandler();
                c cVar2 = c.this;
                final com.tencent.mobileqq.loginregister.servlet.f fVar = cVar2.f341645d;
                final String str = cVar2.f341646e;
                uIHandler.post(new Runnable() { // from class: com.tencent.open.model.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        f.this.c(str, bArr, 64, bundle);
                    }
                });
                c cVar3 = c.this;
                AccountManage.this.l(cVar3.f341646e, false);
            }

            @Override // com.tencent.open.agent.util.i
            public void onFail(int i3, String str) {
                t.b("BaseAccountManage", "update get open sdk A2 onFail");
                c cVar = c.this;
                cVar.f341645d.a(cVar.f341646e, 64, i3, cVar.f341642a);
            }
        }

        c(Bundle bundle, int i3, boolean z16, com.tencent.mobileqq.loginregister.servlet.f fVar, String str) {
            this.f341642a = bundle;
            this.f341643b = i3;
            this.f341644c = z16;
            this.f341645d = fVar;
            this.f341646e = str;
        }

        @Override // com.tencent.open.agent.util.i
        public void a(final byte[] bArr) {
            final Bundle bundle;
            t.b("BaseAccountManage", "update get main A2 onSuccess");
            if (this.f341642a != null) {
                bundle = new Bundle(this.f341642a);
            } else {
                bundle = new Bundle();
            }
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            bundle.putLong("dwSrcAppid", BaseConstants.OPEN_SDK_BUFLAG_B1);
            bundle.putLong("dwDstAppid", BaseConstants.OPEN_SDK_BUFLAG_B1);
            if (3 == this.f341643b && this.f341644c) {
                t.b("BaseAccountManage", "delegateGetTicketNoPasswd 110509 and use540Ticket");
                bundle.putLong("dwSrcAppid", BaseConstants.OPEN_SDK_BUFLAG_B1);
                bundle.putLong("dwDstAppid", BaseConstants.OPEN_SDK_BUFLAG_B1);
            }
            ((WtloginManager) peekAppRuntime.getManager(1)).refreshMemorySig();
            MqqHandler uIHandler = ThreadManager.getUIHandler();
            final com.tencent.mobileqq.loginregister.servlet.f fVar = this.f341645d;
            final String str = this.f341646e;
            uIHandler.post(new Runnable() { // from class: com.tencent.open.model.b
                @Override // java.lang.Runnable
                public final void run() {
                    f.this.c(str, bArr, 64, bundle);
                }
            });
            AccountManage.this.l(this.f341646e, true);
        }

        @Override // com.tencent.open.agent.util.i
        public void onFail(int i3, String str) {
            t.b("BaseAccountManage", "update get main A2 onFailed");
            com.tencent.open.agent.util.g.m(this.f341646e, false, new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class d implements i {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Bundle f341649a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f341650b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f341651c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.loginregister.servlet.f f341652d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f341653e;

        d(Bundle bundle, int i3, boolean z16, com.tencent.mobileqq.loginregister.servlet.f fVar, String str) {
            this.f341649a = bundle;
            this.f341650b = i3;
            this.f341651c = z16;
            this.f341652d = fVar;
            this.f341653e = str;
        }

        @Override // com.tencent.open.agent.util.i
        public void a(final byte[] bArr) {
            final Bundle bundle;
            t.b("BaseAccountManage", "delegateGetTicketNoPasswdFromNT get main A2 onSuccess ");
            t.b("BaseAccountManage", "update get main A2 onSuccess");
            if (this.f341649a != null) {
                bundle = new Bundle(this.f341649a);
            } else {
                bundle = new Bundle();
            }
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            bundle.putLong("dwSrcAppid", BaseConstants.OPEN_SDK_BUFLAG_B1);
            bundle.putLong("dwDstAppid", BaseConstants.OPEN_SDK_BUFLAG_B1);
            if (3 == this.f341650b && this.f341651c) {
                t.b("BaseAccountManage", "delegateGetTicketNoPasswd 110509 and use540Ticket");
                bundle.putLong("dwSrcAppid", BaseConstants.OPEN_SDK_BUFLAG_B1);
                bundle.putLong("dwDstAppid", BaseConstants.OPEN_SDK_BUFLAG_B1);
            }
            ((WtloginManager) peekAppRuntime.getManager(1)).refreshMemorySig();
            MqqHandler uIHandler = ThreadManager.getUIHandler();
            final com.tencent.mobileqq.loginregister.servlet.f fVar = this.f341652d;
            final String str = this.f341653e;
            uIHandler.post(new Runnable() { // from class: com.tencent.open.model.d
                @Override // java.lang.Runnable
                public final void run() {
                    f.this.c(str, bArr, 64, bundle);
                }
            });
            AccountManage.this.l(this.f341653e, true);
        }

        @Override // com.tencent.open.agent.util.i
        public void onFail(int i3, String str) {
            t.b("BaseAccountManage", "delegateGetTicketNoPasswdFrom main ticket is invalid!!!");
            AccountManage.this.i(this.f341653e, this.f341652d, this.f341650b, this.f341649a, this.f341651c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class e implements i {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.loginregister.servlet.f f341655a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f341656b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f341657c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Bundle f341658d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f341659e;

        e(com.tencent.mobileqq.loginregister.servlet.f fVar, String str, int i3, Bundle bundle, boolean z16) {
            this.f341655a = fVar;
            this.f341656b = str;
            this.f341657c = i3;
            this.f341658d = bundle;
            this.f341659e = z16;
        }

        @Override // com.tencent.open.agent.util.i
        public void a(byte[] bArr) {
            t.b("BaseAccountManage", "delegateGetTicketNoPasswdFromNT get open A2 onSuccess!");
            if (MobileQQ.sMobileQQ.isLoginByNT()) {
                Bundle bundle = new Bundle();
                bundle.putBoolean("fake_callback", true);
                this.f341655a.c(this.f341656b, bArr, 64, bundle);
                AccountManage.this.l(this.f341656b, false);
                return;
            }
            AccountManage.this.h(this.f341656b, bArr, false, this.f341657c, this.f341658d, this.f341659e, this.f341655a);
        }

        @Override // com.tencent.open.agent.util.i
        public void onFail(int i3, String str) {
            t.e("BaseAccountManage", "main Account A2 and openSDKA2 is all invalid!!!");
            AccountManage.this.m(this.f341656b, this.f341655a, this.f341657c, this.f341658d, this.f341659e, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class f implements com.tencent.mobileqq.thirdsig.api.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f341661a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ byte[] f341662b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.loginregister.servlet.f f341663c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f341664d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Bundle f341665e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f341666f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ boolean f341667g;

        f(String str, byte[] bArr, com.tencent.mobileqq.loginregister.servlet.f fVar, int i3, Bundle bundle, boolean z16, boolean z17) {
            this.f341661a = str;
            this.f341662b = bArr;
            this.f341663c = fVar;
            this.f341664d = i3;
            this.f341665e = bundle;
            this.f341666f = z16;
            this.f341667g = z17;
        }

        @Override // com.tencent.mobileqq.thirdsig.api.d
        public void a(@NonNull com.tencent.mobileqq.thirdsig.api.g gVar) {
            t.b("BaseAccountManage", "get st sig onSuccess");
            if (gVar.a().length != 0 && gVar.b() != null && gVar.b().length != 0) {
                AccountManage.this.k(this.f341661a, this.f341662b, gVar.a(), gVar.b(), this.f341663c);
            } else {
                t.e("BaseAccountManage", "get St from NT sig is null");
            }
        }

        @Override // com.tencent.mobileqq.thirdsig.api.d
        public void onFail(int i3, @NonNull String str) {
            t.e("BaseAccountManage", "get St Sig onFail: " + i3 + "errMsg: " + str);
            AccountManage.this.m(this.f341661a, this.f341663c, this.f341664d, this.f341665e, this.f341666f, this.f341667g);
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public interface g {
        void onFail(int i3, String str);

        void onSuccess(String str);
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public interface h {
        void a(String str, Bundle bundle);

        void b(com.tencent.open.model.a aVar);
    }

    AccountManage() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0115  */
    /* JADX WARN: Type inference failed for: r1v4, types: [com.tencent.open.model.AccountManage$9, android.os.Bundle, com.tencent.mobileqq.loginregister.servlet.f] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void d(final String str, final com.tencent.mobileqq.loginregister.servlet.f fVar, int i3, Bundle bundle, boolean z16) {
        boolean z17;
        byte[] bArr;
        byte[] bArr2;
        t.b("BaseAccountManage", "-->delegateGetTicketNoPasswd--refresh=" + i3);
        if (bundle != null) {
            new Bundle(bundle);
        } else {
            new Bundle();
        }
        final AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (!up3.b.p(str) && i3 == 1) {
            byte[] l3 = com.tencent.open.agent.util.g.l(str, peekAppRuntime, true);
            TicketManager ticketManager = (TicketManager) peekAppRuntime.getManager(2);
            if (l3 != null) {
                t.b("BaseAccountManage", "ticketqq valid");
                bArr = ticketManager.getSt(str, 16);
                bArr2 = ticketManager.getStkey(str, 16);
            } else {
                bArr = null;
                bArr2 = null;
            }
            if (bArr == null || bArr2 == null) {
                t.b("BaseAccountManage", "st == null || stKey == null appid = 16");
                l3 = com.tencent.open.agent.util.g.l(str, peekAppRuntime, false);
                if (l3 != null) {
                    t.b("BaseAccountManage", "ticket opensdk valid");
                    bArr = ticketManager.getSt(str, TicketManagerImpl.BUFLAG_OPEN_CONNECT);
                    bArr2 = ticketManager.getStkey(str, TicketManagerImpl.BUFLAG_OPEN_CONNECT);
                }
            }
            final byte[] bArr3 = l3;
            if (bArr != null && bArr2 != null) {
                t.b("BaseAccountManage", "delegateGetTicketNoPasswd fake SSOAccountObserver success.");
                final Bundle bundle2 = new Bundle();
                bundle2.putBoolean("fake_callback", true);
                bundle2.putByteArray("st_temp", bArr);
                bundle2.putByteArray("st_temp_key", bArr2);
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.open.model.AccountManage.8
                    @Override // java.lang.Runnable
                    public void run() {
                        fVar.c(str, bArr3, 64, bundle2);
                    }
                });
                z17 = false;
                if (!z17) {
                    if (com.tencent.open.agent.util.g.l(str, peekAppRuntime, true) == null) {
                        t.b("BaseAccountManage", "delegateGetTicketNoPasswd appid=16 sKey empty");
                        "dwDstAppid".putLong("dwSrcAppid", BaseConstants.OPEN_SDK_BUFLAG_B1);
                        "dwDstAppid".putLong("dwDstAppid", BaseConstants.OPEN_SDK_BUFLAG_B1);
                    }
                    if (3 == i3 && z16) {
                        t.b("BaseAccountManage", "delegateGetTicketNoPasswd 110509 and use540Ticket");
                        "dwDstAppid".putLong("dwSrcAppid", BaseConstants.OPEN_SDK_BUFLAG_B1);
                        "dwDstAppid".putLong("dwDstAppid", BaseConstants.OPEN_SDK_BUFLAG_B1);
                    }
                    ILoginServletService iLoginServletService = (ILoginServletService) peekAppRuntime.getRuntimeService(ILoginServletService.class, "all");
                    ?? r16 = new com.tencent.mobileqq.loginregister.servlet.f() { // from class: com.tencent.open.model.AccountManage.9
                        /* JADX INFO: Access modifiers changed from: private */
                        public void f(final String str2, final byte[] bArr4, final int i16, final Bundle bundle3) {
                            Manager manager = peekAppRuntime.getManager(1);
                            if (manager != null) {
                                long currentTimeMillis = System.currentTimeMillis();
                                ((WtloginManager) manager).refreshMemorySig();
                                t.b("BaseAccountManage", "refreshMemorySig cost : ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                            }
                            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.open.model.AccountManage.9.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    fVar.c(str2, bArr4, i16, bundle3);
                                }
                            });
                        }

                        @Override // com.tencent.mobileqq.loginregister.servlet.f
                        public void a(String str2, int i16, int i17, Bundle bundle3) {
                            fVar.a(str2, i16, i17, bundle3);
                        }

                        @Override // com.tencent.mobileqq.loginregister.servlet.f
                        public void b(String str2, int i16, byte[] bArr4, int i17, Bundle bundle3) {
                            fVar.b(str2, i16, bArr4, i17, bundle3);
                        }

                        @Override // com.tencent.mobileqq.loginregister.servlet.f
                        public void c(final String str2, final byte[] bArr4, final int i16, final Bundle bundle3) {
                            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.open.model.AccountManage.9.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    f(str2, bArr4, i16, bundle3);
                                }
                            }, 128, null, true);
                        }

                        @Override // com.tencent.mobileqq.loginregister.servlet.f
                        public void d(String str2, int i16, Bundle bundle3) {
                            fVar.d(str2, i16, bundle3);
                        }
                    };
                    iLoginServletService.ssoGetTicketNoPasswd(str, 64, r16, r16);
                    return;
                }
                return;
            }
        }
        z17 = true;
        if (!z17) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(String str, com.tencent.mobileqq.loginregister.servlet.f fVar, int i3, Bundle bundle, boolean z16) {
        t.b("BaseAccountManage", "-->delegateGetTicketNoPasswd--refresh=" + i3);
        if (!up3.b.p(str) && i3 == 1) {
            com.tencent.open.agent.util.g.m(str, true, new d(bundle, i3, z16, fVar, str));
        } else {
            t.e("BaseAccountManage", "delegateGetTicketNoPasswdFromNT ticket need refresh");
            com.tencent.open.agent.util.g.m(str, true, new c(bundle, i3, z16, fVar, str));
        }
    }

    public static synchronized AccountManage g() {
        AccountManage accountManage;
        synchronized (AccountManage.class) {
            if (f341600a == null) {
                f341600a = new AccountManage();
            }
            accountManage = f341600a;
        }
        return accountManage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(String str, boolean z16) {
        QLog.d("BaseAccountManage", 1, "refreshLoginAccountTicket uin" + str + " isHost: " + z16);
        Bundle bundle = new Bundle();
        bundle.putString("user_uin", str);
        bundle.putBoolean("is_host_uin", z16);
        QIPCClientHelper.getInstance().callServer("LoginIPCModule", "RefreshNTTicket", bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(String str, final com.tencent.mobileqq.loginregister.servlet.f fVar, int i3, Bundle bundle, boolean z16, boolean z17) {
        Bundle bundle2;
        t.b("BaseAccountManage", "updateTicket ");
        if (bundle != null) {
            bundle2 = new Bundle(bundle);
        } else {
            bundle2 = new Bundle();
        }
        final AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (z17) {
            t.b("BaseAccountManage", "delegateGetTicketNoPasswd appid=16 sKey empty");
            bundle2.putLong("dwSrcAppid", BaseConstants.OPEN_SDK_BUFLAG_B1);
            bundle2.putLong("dwDstAppid", BaseConstants.OPEN_SDK_BUFLAG_B1);
        }
        if (3 == i3 && z16) {
            t.b("BaseAccountManage", "delegateGetTicketNoPasswd 110509 and use540Ticket");
            bundle2.putLong("dwSrcAppid", BaseConstants.OPEN_SDK_BUFLAG_B1);
            bundle2.putLong("dwDstAppid", BaseConstants.OPEN_SDK_BUFLAG_B1);
        }
        ((ILoginServletService) peekAppRuntime.getRuntimeService(ILoginServletService.class, "all")).ssoGetTicketNoPasswd(str, 64, new com.tencent.mobileqq.loginregister.servlet.f() { // from class: com.tencent.open.model.AccountManage.10
            /* JADX INFO: Access modifiers changed from: private */
            public void f(final String str2, final byte[] bArr, final int i16, final Bundle bundle3) {
                Manager manager = peekAppRuntime.getManager(1);
                if (manager != null) {
                    long currentTimeMillis = System.currentTimeMillis();
                    ((WtloginManager) manager).refreshMemorySig();
                    t.b("BaseAccountManage", "refreshMemorySig cost : ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                }
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.open.model.AccountManage.10.2
                    @Override // java.lang.Runnable
                    public void run() {
                        fVar.c(str2, bArr, i16, bundle3);
                    }
                });
            }

            @Override // com.tencent.mobileqq.loginregister.servlet.f
            public void a(String str2, int i16, int i17, Bundle bundle3) {
                fVar.a(str2, i16, i17, bundle3);
            }

            @Override // com.tencent.mobileqq.loginregister.servlet.f
            public void b(String str2, int i16, byte[] bArr, int i17, Bundle bundle3) {
                fVar.b(str2, i16, bArr, i17, bundle3);
            }

            @Override // com.tencent.mobileqq.loginregister.servlet.f
            public void c(final String str2, final byte[] bArr, final int i16, final Bundle bundle3) {
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.open.model.AccountManage.10.1
                    @Override // java.lang.Runnable
                    public void run() {
                        f(str2, bArr, i16, bundle3);
                    }
                }, 128, null, true);
            }

            @Override // com.tencent.mobileqq.loginregister.servlet.f
            public void d(String str2, int i16, Bundle bundle3) {
                fVar.d(str2, i16, bundle3);
            }
        }, bundle2);
    }

    public void e(String str, com.tencent.mobileqq.loginregister.servlet.f fVar, String str2, int i3) {
        Bundle bundle = new Bundle();
        bundle.putByteArray(AppConstants.Key.KEY_CONNECT_DATA, com.tencent.open.agent.util.g.u(str2));
        boolean k3 = hp3.b.e().k(str);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (MobileQQ.sMobileQQ.isLoginByNT()) {
            t.b("BaseAccountManage", "delegateGetTicketNoPasswd use new nt login");
            com.tencent.open.agent.util.g.D(peekAppRuntime, str, k3, new b(str, fVar, i3, bundle));
        } else {
            t.b("BaseAccountManage", "delegateGetTicketNoPasswd use old login");
            d(str, fVar, i3, bundle, com.tencent.open.agent.util.g.H(peekAppRuntime, str, k3));
        }
    }

    void h(String str, byte[] bArr, boolean z16, int i3, Bundle bundle, boolean z17, com.tencent.mobileqq.loginregister.servlet.f fVar) {
        int i16;
        int i17;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (z16) {
            i16 = 16;
        } else {
            i16 = TicketManagerImpl.BUFLAG_OPEN_CONNECT;
        }
        int i18 = i16;
        if (z16) {
            i17 = 0;
        } else {
            i17 = 6;
        }
        ((IThirdSigService) peekAppRuntime.getRuntimeService(IThirdSigService.class, "all")).getSt(Long.parseLong(str), i17, i18, new f(str, bArr, fVar, i3, bundle, z17, z16));
    }

    void i(String str, com.tencent.mobileqq.loginregister.servlet.f fVar, int i3, Bundle bundle, boolean z16) {
        t.b("BaseAccountManage", "getTicketByOpenSDK ");
        MobileQQ.sMobileQQ.peekAppRuntime();
        com.tencent.open.agent.util.g.m(str, false, new e(fVar, str, i3, bundle, z16));
    }

    public void j(String str, String str2, int i3, h hVar) {
        t.b("BaseAccountManage", "getTicketNoPasswd uin=" + com.tencent.open.agent.util.g.C(str));
        e(str, new a(hVar), str2, i3);
    }

    void k(final String str, final byte[] bArr, byte[] bArr2, byte[] bArr3, final com.tencent.mobileqq.loginregister.servlet.f fVar) {
        if (bArr2 != null && bArr3 != null) {
            t.b("BaseAccountManage", "delegateGetTicketNoPasswdNT fake SSOAccountObserver success.");
            final Bundle bundle = new Bundle();
            bundle.putBoolean("fake_callback", true);
            bundle.putByteArray("st_temp", bArr2);
            bundle.putByteArray("st_temp_key", bArr3);
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.open.model.AccountManage.7
                @Override // java.lang.Runnable
                public void run() {
                    fVar.c(str, bArr, 64, bundle);
                }
            });
        }
    }
}
