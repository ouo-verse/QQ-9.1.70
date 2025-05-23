package bf4;

import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.timi.game.utils.l;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pl4.d;
import trpc.yes.common.LiveActivityServerOuterClass$GetRoomPendantRsp;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lbf4/c;", "", "", "viewType", "", "roomId", "Lbf4/b;", "listener", "", "a", "Lbf4/a;", "b", "Lbf4/a;", "servlet", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f28360a = new c();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final bf4.a servlet = new bf4.a();

    /* compiled from: P */
    @Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016JP\u0010\u0011\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\u0012"}, d2 = {"bf4/c$a", "Lpl4/d;", "Ltrpc/yes/common/LiveActivityServerOuterClass$GetRoomPendantRsp;", "response", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "originalMsfRsp", "", "d", "", "isMsfSuccess", "", "msfResultCode", "timiErrCode", "timiSubErrCode", "", "timiErrMsg", "timiDisplayErrMsg", "c", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class a implements d<LiveActivityServerOuterClass$GetRoomPendantRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f28362a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f28363b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ b f28364c;

        a(int i3, long j3, b bVar) {
            this.f28362a = i3;
            this.f28363b = j3;
            this.f28364c = bVar;
        }

        @Override // pl4.d
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(boolean isMsfSuccess, int msfResultCode, int timiErrCode, int timiSubErrCode, @Nullable String timiErrMsg, @Nullable String timiDisplayErrMsg, @Nullable LiveActivityServerOuterClass$GetRoomPendantRsp response, @Nullable FromServiceMsg originalMsfRsp) {
            l.e("TimiOperationFetcher", "viewType:" + this.f28362a + ", roomId:" + this.f28363b + ", msfResultCode:" + msfResultCode + ", timiErrCode:" + timiErrCode + ", timiSubErrCode:" + timiSubErrCode + ", timiErrMsg:" + timiErrMsg + ", timiDisplayErrMsg:" + timiDisplayErrMsg);
            this.f28364c.b(timiErrCode, timiDisplayErrMsg);
        }

        @Override // pl4.d
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(@Nullable LiveActivityServerOuterClass$GetRoomPendantRsp response, @Nullable FromServiceMsg originalMsfRsp) {
            if (response == null) {
                l.e("TimiOperationFetcher", "viewType:" + this.f28362a + ", roomId:" + this.f28363b + ", req succeed bug rsp is null!");
                this.f28364c.b(-1, "req succeed bug rsp is null!");
                return;
            }
            l.h("TimiOperationFetcher", 2, "viewType:" + this.f28362a + ", roomId:" + this.f28363b + ",  req succeed");
            this.f28364c.a(response);
        }
    }

    c() {
    }

    public final void a(int viewType, long roomId, @NotNull b listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        servlet.e(viewType, roomId, new a(viewType, roomId, listener));
    }
}
