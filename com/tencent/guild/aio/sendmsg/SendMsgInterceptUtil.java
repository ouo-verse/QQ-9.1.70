package com.tencent.guild.aio.sendmsg;

import android.os.Bundle;
import com.tencent.aio.msgservice.k;
import com.tencent.mobileqq.guild.util.IQQGuildSPUtilsApi;
import com.tencent.mobileqq.qroute.QRoute;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import st1.n;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\nB\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ(\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u00a8\u0006\r"}, d2 = {"Lcom/tencent/guild/aio/sendmsg/SendMsgInterceptUtil;", "", "Lcom/tencent/aio/msgservice/k;", "req", "Lcom/tencent/aio/api/runtime/a;", "context", "Landroid/os/Bundle;", "extData", "Lkotlinx/coroutines/flow/Flow;", "Lcom/tencent/guild/aio/sendmsg/SendMsgInterceptUtil$a;", "a", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class SendMsgInterceptUtil {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final SendMsgInterceptUtil f112285a = new SendMsgInterceptUtil();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u000f\u001a\u00020\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0010\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0015\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000f\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0017\u0010\u0014\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013R$\u0010\u001a\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0016\u001a\u0004\b\t\u0010\u0017\"\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/guild/aio/sendmsg/SendMsgInterceptUtil$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "c", "()Z", "setIntercept", "(Z)V", "isIntercept", "Lst1/n;", "b", "Lst1/n;", "()Lst1/n;", "sendMsgsReq", "Landroid/os/Bundle;", "Landroid/os/Bundle;", "()Landroid/os/Bundle;", "setExtData", "(Landroid/os/Bundle;)V", "extData", "<init>", "(ZLst1/n;Landroid/os/Bundle;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.guild.aio.sendmsg.SendMsgInterceptUtil$a, reason: from toString */
    /* loaded from: classes6.dex */
    public static final /* data */ class SendMsgsRsp {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private boolean isIntercept;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final n sendMsgsReq;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private Bundle extData;

        public SendMsgsRsp(boolean z16, @NotNull n sendMsgsReq, @Nullable Bundle bundle) {
            Intrinsics.checkNotNullParameter(sendMsgsReq, "sendMsgsReq");
            this.isIntercept = z16;
            this.sendMsgsReq = sendMsgsReq;
            this.extData = bundle;
        }

        @Nullable
        /* renamed from: a, reason: from getter */
        public final Bundle getExtData() {
            return this.extData;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final n getSendMsgsReq() {
            return this.sendMsgsReq;
        }

        /* renamed from: c, reason: from getter */
        public final boolean getIsIntercept() {
            return this.isIntercept;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SendMsgsRsp)) {
                return false;
            }
            SendMsgsRsp sendMsgsRsp = (SendMsgsRsp) other;
            if (this.isIntercept == sendMsgsRsp.isIntercept && Intrinsics.areEqual(this.sendMsgsReq, sendMsgsRsp.sendMsgsReq) && Intrinsics.areEqual(this.extData, sendMsgsRsp.extData)) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v6 */
        /* JADX WARN: Type inference failed for: r0v7 */
        public int hashCode() {
            int hashCode;
            boolean z16 = this.isIntercept;
            ?? r06 = z16;
            if (z16) {
                r06 = 1;
            }
            int hashCode2 = ((r06 * 31) + this.sendMsgsReq.hashCode()) * 31;
            Bundle bundle = this.extData;
            if (bundle == null) {
                hashCode = 0;
            } else {
                hashCode = bundle.hashCode();
            }
            return hashCode2 + hashCode;
        }

        @NotNull
        public String toString() {
            return "SendMsgsRsp(isIntercept=" + this.isIntercept + ", sendMsgsReq=" + this.sendMsgsReq + ", extData=" + this.extData + ")";
        }
    }

    SendMsgInterceptUtil() {
    }

    public static /* synthetic */ Flow b(SendMsgInterceptUtil sendMsgInterceptUtil, k kVar, com.tencent.aio.api.runtime.a aVar, Bundle bundle, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            bundle = null;
        }
        return sendMsgInterceptUtil.a(kVar, aVar, bundle);
    }

    @NotNull
    public final Flow<SendMsgsRsp> a(@NotNull k req, @NotNull com.tencent.aio.api.runtime.a context, @Nullable Bundle extData) {
        Intrinsics.checkNotNullParameter(req, "req");
        Intrinsics.checkNotNullParameter(context, "context");
        ((IQQGuildSPUtilsApi) QRoute.api(IQQGuildSPUtilsApi.class)).addOneRecentTalkedChannel(com.tencent.guild.aio.util.ex.a.h(context), req.a().c().j());
        return FlowKt.callbackFlow(new SendMsgInterceptUtil$sendMsgs$1(req, context, extData, null));
    }
}
