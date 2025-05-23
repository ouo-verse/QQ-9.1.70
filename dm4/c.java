package dm4;

import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.l;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.CommonOuterClass$QQUserId;
import trpc.yes.common.UserProxyCmdOuterClass$GetSessionInfoRsp;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ6\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\b\u00a8\u0006\u000f"}, d2 = {"Ldm4/c;", "", "", "fromUin", "toUin", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "fromQQId", "toQQId", "Lcom/tencent/timi/game/utils/IResultListener;", "", "callback", "", "a", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f394282a = new c();

    /* compiled from: P */
    @Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016JP\u0010\u0011\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\u0012"}, d2 = {"dm4/c$a", "Lpl4/d;", "Ltrpc/yes/common/UserProxyCmdOuterClass$GetSessionInfoRsp;", "response", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "originalMsfRsp", "", "d", "", "isMsfSuccess", "", "msfResultCode", "timiErrCode", "timiSubErrCode", "", "timiErrMsg", "timiDisplayErrMsg", "c", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class a implements pl4.d<UserProxyCmdOuterClass$GetSessionInfoRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IResultListener<byte[]> f394283a;

        a(IResultListener<byte[]> iResultListener) {
            this.f394283a = iResultListener;
        }

        @Override // pl4.d
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(boolean isMsfSuccess, int msfResultCode, int timiErrCode, int timiSubErrCode, @Nullable String timiErrMsg, @Nullable String timiDisplayErrMsg, @Nullable UserProxyCmdOuterClass$GetSessionInfoRsp response, @Nullable FromServiceMsg originalMsfRsp) {
            l.e("GetSessionInfoRequest", "getSessionInfo - onError " + isMsfSuccess + "-" + msfResultCode + " -- " + timiErrCode + "-" + timiErrMsg + "-" + timiDisplayErrMsg);
            this.f394283a.onError(timiErrCode, timiErrMsg);
        }

        @Override // pl4.d
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(@Nullable UserProxyCmdOuterClass$GetSessionInfoRsp response, @Nullable FromServiceMsg originalMsfRsp) {
            l.i("GetSessionInfoRequest", "getSessionInfo - success ");
            if (response != null) {
                this.f394283a.onSuccess(response.bytes_sig.get().toByteArray());
            } else {
                this.f394283a.onError(0, "data error");
            }
        }
    }

    c() {
    }

    public final void a(long fromUin, long toUin, @NotNull CommonOuterClass$QQUserId fromQQId, @NotNull CommonOuterClass$QQUserId toQQId, @NotNull IResultListener<byte[]> callback) {
        Intrinsics.checkNotNullParameter(fromQQId, "fromQQId");
        Intrinsics.checkNotNullParameter(toQQId, "toQQId");
        Intrinsics.checkNotNullParameter(callback, "callback");
        l.i("GetSessionInfoRequest", "getSessionInfo - " + l.j(toUin));
        ((pl4.c) mm4.b.b(pl4.c.class)).F1(d.INSTANCE.a(fromUin, toUin, fromQQId, toQQId), UserProxyCmdOuterClass$GetSessionInfoRsp.class, new a(callback));
    }
}
