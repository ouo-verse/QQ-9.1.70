package com.tencent.mobileqq.now.netchannel.websso;

import android.util.Log;
import com.tencent.mobileqq.now.loginmerge.LoginMergedProto$LoginReq;
import com.tencent.mobileqq.now.loginmerge.LoginMergedProto$LoginRsp;
import com.tencent.mobileqq.now.loginmerge.LoginMergedProto$LoginTicketInfo;
import com.tencent.mobileqq.now.loginmerge.LoginMergedProto$LogoutReq;
import com.tencent.mobileqq.now.loginmerge.LoginMergedProto$TicketInfo;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.utils.bv;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.MainTicketCallback;
import mqq.manager.MainTicketInfo;
import mqq.manager.TicketManager;

/* compiled from: P */
/* loaded from: classes9.dex */
public class c {

    /* renamed from: c, reason: collision with root package name */
    private static c f254380c;

    /* renamed from: a, reason: collision with root package name */
    private boolean f254381a = false;

    /* renamed from: b, reason: collision with root package name */
    private boolean f254382b = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements MainTicketCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f254383a;

        a(d dVar) {
            this.f254383a = dVar;
        }

        @Override // mqq.manager.MainTicketCallback
        public void onFail(int i3, String str) {
            QLog.i("now_live_login_mgr", 1, "login async get login ticket fail");
        }

        @Override // mqq.manager.MainTicketCallback
        public void onSuccess(MainTicketInfo mainTicketInfo) {
            QLog.i("now_live_login_mgr", 1, "login async get login ticket success");
            c.this.g(this.f254383a, mainTicketInfo.getA2());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class b implements com.tencent.mobileqq.now.netchannel.websso.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f254385a;

        b(d dVar) {
            this.f254385a = dVar;
        }

        @Override // com.tencent.mobileqq.now.netchannel.websso.b
        public void onError(int i3, String str) {
            Log.d("now_live_login_mgr", "login faile, errCode=" + i3 + ", errMsg=" + str);
            d dVar = this.f254385a;
            if (dVar != null) {
                dVar.c3(i3, str);
            }
        }

        @Override // com.tencent.mobileqq.now.netchannel.websso.b
        public void onRecv(byte[] bArr) {
            boolean z16;
            if (c.this.f254381a) {
                return;
            }
            try {
                Log.d("now_live_login_mgr", "login success");
                LoginMergedProto$LoginRsp loginMergedProto$LoginRsp = new LoginMergedProto$LoginRsp();
                loginMergedProto$LoginRsp.mergeFrom(bArr);
                e.c().k(loginMergedProto$LoginRsp.account_base_info.uid.get());
                e.c().j(loginMergedProto$LoginRsp.account_base_info.tinyid.get());
                e.c().i(loginMergedProto$LoginRsp.tickets.auth_key.get());
                c cVar = c.this;
                if (loginMergedProto$LoginRsp.result.get() == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                cVar.f254382b = z16;
                d dVar = this.f254385a;
                if (dVar != null) {
                    dVar.c3(loginMergedProto$LoginRsp.result.get(), loginMergedProto$LoginRsp.errMsg.get());
                }
            } catch (Exception e16) {
                Log.d("now_live_login_mgr", "login parse exception, errMsg=" + e16.getMessage());
                d dVar2 = this.f254385a;
                if (dVar2 != null) {
                    dVar2.c3(1000001, "login parse exception");
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface d {
        void c3(int i3, String str);
    }

    public static c d() {
        if (f254380c == null) {
            f254380c = new c();
            ChannelCenter.e().i(qb2.b.d());
        }
        return f254380c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(d dVar, String str) {
        LoginMergedProto$LoginReq loginMergedProto$LoginReq = new LoginMergedProto$LoginReq();
        LoginMergedProto$LoginTicketInfo loginMergedProto$LoginTicketInfo = new LoginMergedProto$LoginTicketInfo();
        loginMergedProto$LoginTicketInfo.client_version.set(0);
        loginMergedProto$LoginTicketInfo.login_type.set(0);
        loginMergedProto$LoginTicketInfo.client_type.set(16130);
        LoginMergedProto$TicketInfo loginMergedProto$TicketInfo = new LoginMergedProto$TicketInfo();
        loginMergedProto$LoginTicketInfo.account_id.set(e.g());
        loginMergedProto$LoginTicketInfo.auth_appid.set("16");
        loginMergedProto$TicketInfo.auth_key.set(str);
        loginMergedProto$LoginTicketInfo.ticket_info.set(loginMergedProto$TicketInfo);
        loginMergedProto$LoginReq.login_ticket_info.set(loginMergedProto$LoginTicketInfo);
        ChannelCenter.e().h(30840, 1, loginMergedProto$LoginReq.toByteArray(), new b(dVar));
    }

    public static void i() {
        f254380c = null;
    }

    public boolean e() {
        return this.f254382b;
    }

    public void f(d dVar) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        TicketManager ticketManager = (TicketManager) peekAppRuntime.getManager(2);
        if (ticketManager.useAsyncTicketInterface()) {
            ticketManager.getA2(bv.b(peekAppRuntime.getCurrentUin(), 0L), 16, new a(dVar));
            return;
        }
        String a26 = ticketManager.getA2(peekAppRuntime.getCurrentUin());
        QLog.i("now_live_login_mgr", 1, "login sync get login ticket");
        g(dVar, a26);
    }

    public void h() {
        this.f254381a = true;
        ChannelCenter.e().h(30840, 2, new MessageMicro<LoginMergedProto$LogoutReq>() { // from class: com.tencent.mobileqq.now.loginmerge.LoginMergedProto$LogoutReq
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], LoginMergedProto$LogoutReq.class);
        }.toByteArray(), new C8165c());
        ChannelCenter.g();
        e.h();
        i();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.now.netchannel.websso.c$c, reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C8165c implements com.tencent.mobileqq.now.netchannel.websso.b {
        C8165c() {
        }

        @Override // com.tencent.mobileqq.now.netchannel.websso.b
        public void onRecv(byte[] bArr) {
        }

        @Override // com.tencent.mobileqq.now.netchannel.websso.b
        public void onError(int i3, String str) {
        }
    }
}
