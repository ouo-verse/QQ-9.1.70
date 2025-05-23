package com.tencent.open.agent.util;

import android.text.TextUtils;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qconn.protofile.appType$LoginSig;
import com.tencent.qphone.base.BaseConstants;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.TicketManagerImpl;
import mqq.manager.MainTicketCallback;
import mqq.manager.MainTicketInfo;
import mqq.manager.Manager;
import mqq.manager.TicketManager;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0012B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J6\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\t0\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0007J0\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0007J \u0010\u000f\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0002\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/open/agent/util/k;", "", "Lmqq/app/AppRuntime;", "app", "", "openSdkUin", "cmd", "cmdEmp", "Lkotlin/Pair;", "Lcom/tencent/qconn/protofile/appType$LoginSig;", "b", "Lcom/tencent/open/agent/util/k$a;", "callback", "", "c", "d", "<init>", "()V", "a", "opensdk-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final k f340608a = new k();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u00e6\u0080\u0001\u0018\u00002\u00020\u0001J\u001e\u0010\u0007\u001a\u00020\u00062\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/open/agent/util/k$a;", "", "Lkotlin/Pair;", "", "Lcom/tencent/qconn/protofile/appType$LoginSig;", BaseConstants.CMD_MSFCOMMAND, "", "a", "opensdk-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public interface a {
        void a(@NotNull Pair<String, appType$LoginSig> msfCommand);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/open/agent/util/k$b", "Lmqq/manager/MainTicketCallback;", "Lmqq/manager/MainTicketInfo;", "info", "", "onSuccess", "", "errorCode", "", "errorMsg", "onFail", "opensdk-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class b implements MainTicketCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AppRuntime f340609a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f340610b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ a f340611c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f340612d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f340613e;

        b(AppRuntime appRuntime, String str, a aVar, String str2, String str3) {
            this.f340609a = appRuntime;
            this.f340610b = str;
            this.f340611c = aVar;
            this.f340612d = str2;
            this.f340613e = str3;
        }

        @Override // mqq.manager.MainTicketCallback
        public void onFail(int errorCode, @NotNull String errorMsg) {
            Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
            t.b("MsfCommandUtils", "getMainTicket main account onFail ");
            k.f340608a.d(this.f340610b, this.f340613e, this.f340611c);
        }

        @Override // mqq.manager.MainTicketCallback
        public void onSuccess(@NotNull MainTicketInfo info) {
            Intrinsics.checkNotNullParameter(info, "info");
            t.b("MsfCommandUtils", "getMsfCommandAsync onSuccess");
            if (TextUtils.equals(this.f340609a.getAccount(), this.f340610b)) {
                t.b("MsfCommandUtils", "getMsfCommandAsync callback by login account");
                this.f340611c.a(new Pair<>(this.f340612d, null));
                return;
            }
            t.b("MsfCommandUtils", "getMsfCommandAsync use qq cache");
            appType$LoginSig apptype_loginsig = new appType$LoginSig();
            apptype_loginsig.type.set(8);
            apptype_loginsig.appid.set(16);
            apptype_loginsig.sig.set(ByteStringMicro.copyFrom(HexUtil.hexStr2Bytes(info.getA2())));
            this.f340611c.a(new Pair<>(this.f340612d, apptype_loginsig));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/open/agent/util/k$c", "Lmqq/manager/MainTicketCallback;", "Lmqq/manager/MainTicketInfo;", "info", "", "onSuccess", "", "errorCode", "", "errorMsg", "onFail", "opensdk-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class c implements MainTicketCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f340614a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f340615b;

        c(a aVar, String str) {
            this.f340614a = aVar;
            this.f340615b = str;
        }

        @Override // mqq.manager.MainTicketCallback
        public void onFail(int errorCode, @NotNull String errorMsg) {
            Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
            t.e("MsfCommandUtils", "get main ticket failed errorCode: " + errorCode);
            this.f340614a.a(new Pair<>(this.f340615b, null));
        }

        @Override // mqq.manager.MainTicketCallback
        public void onSuccess(@NotNull MainTicketInfo info) {
            Intrinsics.checkNotNullParameter(info, "info");
            appType$LoginSig apptype_loginsig = new appType$LoginSig();
            apptype_loginsig.appid.set(TicketManagerImpl.BUFLAG_OPEN_CONNECT);
            apptype_loginsig.sig.set(ByteStringMicro.copyFrom(HexUtil.hexStr2Bytes(info.getA2())));
            this.f340614a.a(new Pair<>(this.f340615b, apptype_loginsig));
        }
    }

    k() {
    }

    @JvmStatic
    @NotNull
    public static final Pair<String, appType$LoginSig> b(@NotNull AppRuntime app, @NotNull String openSdkUin, @NotNull String cmd, @NotNull String cmdEmp) {
        boolean z16;
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(openSdkUin, "openSdkUin");
        Intrinsics.checkNotNullParameter(cmd, "cmd");
        Intrinsics.checkNotNullParameter(cmdEmp, "cmdEmp");
        boolean k3 = hp3.b.e().k(openSdkUin);
        String account = app.getAccount();
        t.f("MsfCommandUtils", "checkIsSameAccount: " + MsfSdkUtils.getShortUin(account) + "/" + MsfSdkUtils.getShortUin(openSdkUin));
        if (!k3 && TextUtils.equals(account, openSdkUin)) {
            if (g.l(openSdkUin, app, true) != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            boolean E = g.E(openSdkUin, app);
            t.b("MsfCommandUtils", "getMsfCommand qq current account hasA2=" + z16 + ", hasD2=" + E);
            if (z16 && E) {
                return new Pair<>(cmd, null);
            }
        }
        appType$LoginSig apptype_loginsig = new appType$LoginSig();
        apptype_loginsig.type.set(8);
        byte[] l3 = g.l(openSdkUin, app, true);
        if (!k3 && l3 != null && g.E(openSdkUin, app)) {
            t.b("MsfCommandUtils", "getMsfCommand use qq cache");
            apptype_loginsig.appid.set(16);
            apptype_loginsig.sig.set(ByteStringMicro.copyFrom(l3));
            return new Pair<>(cmd, apptype_loginsig);
        }
        byte[] l16 = g.l(openSdkUin, app, false);
        if (l16 != null) {
            t.b("MsfCommandUtils", "getMsfCommand use opensdk cache");
            apptype_loginsig.appid.set(TicketManagerImpl.BUFLAG_OPEN_CONNECT);
            apptype_loginsig.sig.set(ByteStringMicro.copyFrom(l16));
            return new Pair<>(cmdEmp, apptype_loginsig);
        }
        return new Pair<>(cmd, null);
    }

    @JvmStatic
    public static final void c(@NotNull AppRuntime app, @NotNull String openSdkUin, @NotNull String cmd, @NotNull String cmdEmp, @NotNull a callback) {
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(openSdkUin, "openSdkUin");
        Intrinsics.checkNotNullParameter(cmd, "cmd");
        Intrinsics.checkNotNullParameter(cmdEmp, "cmdEmp");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (MobileQQ.sMobileQQ.isLoginByNT()) {
            t.b("MsfCommandUtils", "getMsfCommandAsync by nt ticket!");
            if (hp3.b.e().k(openSdkUin)) {
                f340608a.d(openSdkUin, cmdEmp, callback);
                return;
            }
            Manager manager = app.getManager(2);
            Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type mqq.manager.TicketManager");
            ((TicketManager) manager).getMainTicket(Long.parseLong(openSdkUin), 16, new b(app, openSdkUin, callback, cmd, cmdEmp));
            return;
        }
        t.b("MsfCommandUtils", "getMsfCommandAsync use old road");
        callback.a(b(app, openSdkUin, cmd, cmdEmp));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d(String openSdkUin, String cmdEmp, a callback) {
        Manager manager = MobileQQ.sMobileQQ.peekAppRuntime().getManager(2);
        Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type mqq.manager.TicketManager");
        ((TicketManager) manager).getMainTicket(Long.parseLong(openSdkUin), TicketManagerImpl.BUFLAG_OPEN_CONNECT, new c(callback, cmdEmp));
    }
}
