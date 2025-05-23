package dm4;

import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.l;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.UserProxyCmdOuterClass$GetNearbyChatSigRsp;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ&\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005\u00a8\u0006\f"}, d2 = {"Ldm4/a;", "", "", "fromTinyId", "toTinyId", "Lcom/tencent/timi/game/utils/IResultListener;", "", "callback", "", "a", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f394279a = new a();

    /* compiled from: P */
    @Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016JP\u0010\u0011\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\u0012"}, d2 = {"dm4/a$a", "Lpl4/d;", "Ltrpc/yes/common/UserProxyCmdOuterClass$GetNearbyChatSigRsp;", "response", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "originalMsfRsp", "", "d", "", "isMsfSuccess", "", "msfResultCode", "timiErrCode", "timiSubErrCode", "", "timiErrMsg", "timiDisplayErrMsg", "c", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: dm4.a$a, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public static final class C10193a implements pl4.d<UserProxyCmdOuterClass$GetNearbyChatSigRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IResultListener<byte[]> f394280a;

        C10193a(IResultListener<byte[]> iResultListener) {
            this.f394280a = iResultListener;
        }

        @Override // pl4.d
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(boolean isMsfSuccess, int msfResultCode, int timiErrCode, int timiSubErrCode, @Nullable String timiErrMsg, @Nullable String timiDisplayErrMsg, @Nullable UserProxyCmdOuterClass$GetNearbyChatSigRsp response, @Nullable FromServiceMsg originalMsfRsp) {
            l.e("GetNearbyChatSigRequest", "getSessionInfo - onError " + isMsfSuccess + "-" + msfResultCode + " -- " + timiErrCode + "-" + timiErrMsg + "-" + timiDisplayErrMsg);
            this.f394280a.onError(timiErrCode, timiErrMsg);
        }

        @Override // pl4.d
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(@Nullable UserProxyCmdOuterClass$GetNearbyChatSigRsp response, @Nullable FromServiceMsg originalMsfRsp) {
            l.i("GetNearbyChatSigRequest", "getSessionInfo - success ");
            if (response != null) {
                this.f394280a.onSuccess(response.sig.get().toByteArray());
            } else {
                this.f394280a.onError(0, "data error");
            }
        }
    }

    a() {
    }

    public final void a(long fromTinyId, long toTinyId, @NotNull IResultListener<byte[]> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        l.i("GetNearbyChatSigRequest", "getSessionInfo ");
        ((pl4.c) mm4.b.b(pl4.c.class)).F1(b.INSTANCE.a(fromTinyId, toTinyId), UserProxyCmdOuterClass$GetNearbyChatSigRsp.class, new C10193a(callback));
    }
}
