package com.tencent.open.ticket;

import android.text.TextUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.open.agent.util.i;
import com.tencent.open.agent.util.t;
import com.tencent.open.agent.util.u;
import com.tencent.open.ticket.a;
import com.tencent.qqnt.kernel.api.ILoginService;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.manager.MainTicketCallback;
import mqq.manager.MainTicketInfo;
import mqq.manager.TicketManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u0000 \u00142\u00020\u0001:\u0001\u0012B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J \u0010\u000e\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J \u0010\u0012\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u0011H\u0016J\u0018\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u0013H\u0016\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/open/ticket/c;", "Lcom/tencent/open/ticket/a;", "", "uin", "", "appId", "Lcom/tencent/open/agent/util/u;", "callback", "", "i", "e", "d", "", "appIdArr", "c", "", "isHost", "Lcom/tencent/open/agent/util/i;", "a", "", "b", "<init>", "()V", "opensdk-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class c implements a {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\f"}, d2 = {"com/tencent/open/ticket/c$b", "Lcom/tencent/open/agent/util/u;", "", "isSuccess", "", "errMsg", "", "onResult", "", "a", "I", "curIndex", "opensdk-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class b implements u {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private int curIndex;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ u f341738b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int[] f341739c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ c f341740d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f341741e;

        b(u uVar, int[] iArr, c cVar, String str) {
            this.f341738b = uVar;
            this.f341739c = iArr;
            this.f341740d = cVar;
            this.f341741e = str;
        }

        @Override // com.tencent.open.agent.util.u
        public void onResult(boolean isSuccess, @Nullable String errMsg) {
            int lastIndex;
            if (isSuccess) {
                this.f341738b.onResult(true, "main account ticket is valid!");
                return;
            }
            t.b("NtOpenTicketApiImpl", "main account ticket is invalid! msg: " + errMsg);
            int i3 = this.curIndex + 1;
            this.curIndex = i3;
            lastIndex = ArraysKt___ArraysKt.getLastIndex(this.f341739c);
            if (i3 <= lastIndex) {
                this.f341740d.i(this.f341741e, this.f341739c[this.curIndex], this);
                return;
            }
            u uVar = this.f341738b;
            if (errMsg == null) {
                errMsg = "unknown error";
            }
            uVar.onResult(false, errMsg);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/open/ticket/c$c", "Lmqq/manager/MainTicketCallback;", "Lmqq/manager/MainTicketInfo;", "info", "", "onSuccess", "", "errorCode", "", "errorMsg", "onFail", "opensdk-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.open.ticket.c$c, reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public static final class C9284c implements MainTicketCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f341742a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ u f341743b;

        C9284c(String str, u uVar) {
            this.f341742a = str;
            this.f341743b = uVar;
        }

        @Override // mqq.manager.MainTicketCallback
        public void onFail(int errorCode, @NotNull String errorMsg) {
            Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
            t.b("NtOpenTicketApiImpl", this.f341742a + " errorCode: errorCode: " + errorCode + ", errMsg: " + errorMsg);
            this.f341743b.onResult(false, errorMsg);
        }

        @Override // mqq.manager.MainTicketCallback
        public void onSuccess(@NotNull MainTicketInfo info) {
            Intrinsics.checkNotNullParameter(info, "info");
            if (!TextUtils.isEmpty(info.getA2()) && info.getD2() != null) {
                t.b("NtOpenTicketApiImpl", this.f341742a + " onSuccess ");
                this.f341743b.onResult(true, "success");
                return;
            }
            t.b("NtOpenTicketApiImpl", this.f341742a + " onSuccess but A2 or D2 is null!");
            this.f341743b.onResult(false, "A2 or D2 is null");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/open/ticket/c$d", "Lmqq/manager/MainTicketCallback;", "Lmqq/manager/MainTicketInfo;", "info", "", "onSuccess", "", "errorCode", "", "errorMsg", "onFail", "opensdk-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class d implements MainTicketCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ i f341744a;

        d(i iVar) {
            this.f341744a = iVar;
        }

        @Override // mqq.manager.MainTicketCallback
        public void onFail(int errorCode, @NotNull String errorMsg) {
            Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
            t.e("NtOpenTicketApiImpl", "getA2Async failed errorCode: " + errorCode + " errMsg: " + errorMsg);
            this.f341744a.onFail(errorCode, errorMsg);
        }

        @Override // mqq.manager.MainTicketCallback
        public void onSuccess(@NotNull MainTicketInfo info) {
            Intrinsics.checkNotNullParameter(info, "info");
            t.b("NtOpenTicketApiImpl", "getA2Async success!!");
            this.f341744a.a(HexUtil.hexStr2Bytes(info.getA2()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(u callback, boolean z16, String str) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        if (z16) {
            callback.onResult(false, "main account ticket is valid!");
        } else {
            t.b("NtOpenTicketApiImpl", "main account ticket is invalid! ");
            callback.onResult(true, "all ticket is invalid!");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i(String uin, int appId, u callback) {
        boolean contains;
        a.Companion companion = a.INSTANCE;
        TicketManager c16 = companion.c();
        String str = "doCheckUserMainTicketReady [uin:" + StringUtil.getSimpleUinForPrint(uin) + ", appId:" + appId + "][cb: " + callback.hashCode() + "]";
        contains = ArraysKt___ArraysKt.contains(companion.a(), appId);
        if (!contains) {
            callback.onResult(false, str + " fail. appId is invalid");
            return;
        }
        c16.getMainTicket(Long.parseLong(uin), appId, new C9284c(str, callback));
    }

    @Override // com.tencent.open.ticket.a
    public void a(@NotNull String uin, boolean isHost, @NotNull i callback) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(callback, "callback");
        t.b("NtOpenTicketApiImpl", "getA2Async by nt new road isHost is " + isHost);
        a.Companion companion = a.INSTANCE;
        companion.c().getA2(Long.parseLong(uin), companion.b(isHost), new d(callback));
    }

    @Override // com.tencent.open.ticket.a
    public void b(long uin, long appId) {
        ((ILoginService) QRoute.api(ILoginService.class)).deleteLoginTicket(uin, appId);
    }

    @Override // com.tencent.open.ticket.a
    public void c(@NotNull String uin, @NotNull int[] appIdArr, @NotNull u callback) {
        Integer firstOrNull;
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(appIdArr, "appIdArr");
        Intrinsics.checkNotNullParameter(callback, "callback");
        t.b("NtOpenTicketApiImpl", "checkMainTicketReady on new road!");
        firstOrNull = ArraysKt___ArraysKt.firstOrNull(appIdArr);
        if (firstOrNull != null) {
            i(uin, firstOrNull.intValue(), new b(callback, appIdArr, this, uin));
        } else {
            t.e("NtOpenTicketApiImpl", "appId is empty!");
            callback.onResult(false, "appIdArr is empty!");
        }
    }

    @Override // com.tencent.open.ticket.a
    public void d(@NotNull String uin, @NotNull u callback) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(callback, "callback");
        c(uin, a.INSTANCE.a(), callback);
    }

    @Override // com.tencent.open.ticket.a
    public void e(@NotNull String uin, @NotNull final u callback) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(callback, "callback");
        t.b("NtOpenTicketApiImpl", "checkIfNeedLoginWithPasswd on new road!");
        c(uin, a.INSTANCE.a(), new u() { // from class: com.tencent.open.ticket.b
            @Override // com.tencent.open.agent.util.u
            public final void onResult(boolean z16, String str) {
                c.h(u.this, z16, str);
            }
        });
    }
}
