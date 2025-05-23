package com.tencent.open.ticket;

import android.text.TextUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.open.agent.util.g;
import com.tencent.open.agent.util.i;
import com.tencent.open.agent.util.t;
import com.tencent.open.agent.util.u;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import mqq.app.MobileQQ;
import mqq.app.TicketManagerImpl;
import mqq.manager.MainTicketCallback;
import mqq.manager.MainTicketInfo;
import mqq.manager.Manager;
import mqq.manager.TicketManager;
import mqq.manager.WtloginManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0001\u0013B\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u001c\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u0018\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\rH\u0016J\u0018\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\rH\u0016J \u0010\u0012\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\rH\u0016J \u0010\u0013\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0018\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0016R\u0014\u0010\u0018\u001a\u00020\u00048\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/open/ticket/d;", "Lcom/tencent/open/ticket/a;", "", "uin", "", h.F, "isHost", "Lcom/tencent/open/agent/util/i;", "callback", "", "f", "", "g", "Lcom/tencent/open/agent/util/u;", "e", "d", "", "appIdArr", "c", "a", "", "appId", "b", "Z", "useAsyncApi", "<init>", "()V", "opensdk-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class d implements a {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final boolean useAsyncApi;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0000\u00a2\u0006\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/open/ticket/d$a;", "", "Lmqq/manager/WtloginManager;", "a", "()Lmqq/manager/WtloginManager;", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "opensdk-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.open.ticket.d$a, reason: from kotlin metadata */
    /* loaded from: classes22.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final WtloginManager a() {
            Manager manager = MobileQQ.sMobileQQ.peekAppRuntime().getManager(1);
            Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type mqq.manager.WtloginManager");
            return (WtloginManager) manager;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/open/ticket/d$b", "Lmqq/manager/MainTicketCallback;", "Lmqq/manager/MainTicketInfo;", "info", "", "onSuccess", "", "errorCode", "", "errorMsg", "onFail", "opensdk-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class b implements MainTicketCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ i f341747a;

        b(i iVar) {
            this.f341747a = iVar;
        }

        @Override // mqq.manager.MainTicketCallback
        public void onFail(int errorCode, @Nullable String errorMsg) {
            t.e("WtLoginOpenTicketApiImpl", "getA2 fail code: " + errorCode + ", msg: " + errorMsg);
            this.f341747a.onFail(errorCode, errorMsg);
        }

        @Override // mqq.manager.MainTicketCallback
        public void onSuccess(@Nullable MainTicketInfo info) {
            String str;
            boolean z16;
            if (info != null) {
                str = info.getA2();
            } else {
                str = null;
            }
            if (str != null && str.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                this.f341747a.a(HexUtil.hexStr2Bytes(str));
            } else {
                this.f341747a.onFail(-1, "onSuccess but a2 is null or empty");
            }
        }
    }

    private final void f(String uin, boolean isHost, i callback) {
        Long longOrNull;
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(uin);
        if (longOrNull != null) {
            long longValue = longOrNull.longValue();
            Manager manager = MobileQQ.sMobileQQ.peekAppRuntime().getManager(2);
            Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type mqq.manager.TicketManager");
            ((TicketManager) manager).getA2(longValue, a.INSTANCE.b(isHost), new b(callback));
        }
    }

    private final byte[] g(String uin, boolean isHost) {
        String openA2;
        String str;
        if (TextUtils.isEmpty(uin)) {
            t.e("WtLoginOpenTicketApiImpl", "getA2 false, currentAccount empty");
            return null;
        }
        TicketManager c16 = a.INSTANCE.c();
        if (isHost) {
            openA2 = c16.getA2(uin);
        } else {
            openA2 = c16.getOpenA2(uin);
        }
        Object[] objArr = new Object[1];
        if (isHost) {
            str = "host";
        } else {
            str = "opensdk";
        }
        objArr[0] = str + " getA2 uin= " + g.C(uin) + " " + g.C(openA2);
        t.b("WtLoginOpenTicketApiImpl", objArr);
        if (TextUtils.isEmpty(openA2)) {
            return null;
        }
        return HexUtil.hexStr2Bytes(openA2);
    }

    private final boolean h(String uin) {
        WtloginManager a16 = INSTANCE.a();
        if (a16.isUserHaveA1(uin, 16L)) {
            t.b("WtLoginOpenTicketApiImpl", "isUserHaveA1 appid=16, uin=" + g.C(uin));
            return true;
        }
        if (a16.isUserHaveA1(uin, BaseConstants.OPEN_SDK_BUFLAG_B1)) {
            t.b("WtLoginOpenTicketApiImpl", "isUserHaveA1 appid=*540, uin=" + g.C(uin));
            return true;
        }
        t.b("WtLoginOpenTicketApiImpl", "isUserHaveA1 false uin=" + g.C(uin));
        return false;
    }

    @Override // com.tencent.open.ticket.a
    public void a(@NotNull String uin, boolean isHost, @NotNull i callback) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(callback, "callback");
        QLog.d("WtLoginOpenTicketApiImpl", 2, "getA2Async by old road");
        if (this.useAsyncApi) {
            f(uin, isHost, callback);
            return;
        }
        byte[] g16 = g(uin, isHost);
        if (g16 != null) {
            callback.a(g16);
        } else {
            callback.onFail(-1, "ticket is null");
        }
    }

    @Override // com.tencent.open.ticket.a
    public void b(long uin, long appId) {
        WtloginManager a16 = INSTANCE.a();
        a16.clearUserFastLoginData(String.valueOf(uin), 16L);
        a16.refreshMemorySig();
    }

    @Override // com.tencent.open.ticket.a
    public void c(@NotNull String uin, @NotNull int[] appIdArr, @NotNull u callback) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(appIdArr, "appIdArr");
        Intrinsics.checkNotNullParameter(callback, "callback");
        callback.onResult(h(uin), "checkMainTicketReady old road");
    }

    @Override // com.tencent.open.ticket.a
    public void d(@NotNull String uin, @NotNull u callback) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(callback, "callback");
        callback.onResult(h(uin), "checkQuickLoginTicketReady old road");
    }

    @Override // com.tencent.open.ticket.a
    public void e(@NotNull String uin, @NotNull u callback) {
        boolean z16;
        String str;
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(callback, "callback");
        WtloginManager a16 = INSTANCE.a();
        if (a16.isNeedLoginWithPasswd(uin, 16) && a16.isNeedLoginWithPasswd(uin, TicketManagerImpl.BUFLAG_OPEN_CONNECT)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            str = "isNeedLoginWithPasswd old road";
        } else {
            str = "";
        }
        callback.onResult(z16, str);
    }
}
