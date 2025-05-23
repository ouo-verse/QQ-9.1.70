package lh4;

import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.l;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pl4.c;
import pl4.d;
import trpc.yes.common.RecommendProxyOuterClass$GetTopKuolieRoomListRsp;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u0006\u001a\u00020\u00052\u0010\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0002R\u0014\u0010\t\u001a\u00020\u00078\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\b\u00a8\u0006\f"}, d2 = {"Llh4/a;", "", "Lcom/tencent/timi/game/utils/IResultListener;", "Ltrpc/yes/common/RecommendProxyOuterClass$GetTopKuolieRoomListRsp;", "callback", "", "b", "", "Ljava/lang/String;", "TAG", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f414596a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String TAG = "GetTopKuolieRoomListRequest";

    /* compiled from: P */
    @Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016JP\u0010\u0011\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\u0012"}, d2 = {"lh4/a$a", "Lpl4/d;", "Ltrpc/yes/common/RecommendProxyOuterClass$GetTopKuolieRoomListRsp;", "response", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "originalMsfRsp", "", "d", "", "isMsfSuccess", "", "msfResultCode", "timiErrCode", "timiSubErrCode", "", "timiErrMsg", "timiDisplayErrMsg", "c", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: lh4.a$a, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public static final class C10724a implements d<RecommendProxyOuterClass$GetTopKuolieRoomListRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IResultListener<RecommendProxyOuterClass$GetTopKuolieRoomListRsp> f414598a;

        C10724a(IResultListener<RecommendProxyOuterClass$GetTopKuolieRoomListRsp> iResultListener) {
            this.f414598a = iResultListener;
        }

        @Override // pl4.d
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(boolean isMsfSuccess, int msfResultCode, int timiErrCode, int timiSubErrCode, @Nullable String timiErrMsg, @Nullable String timiDisplayErrMsg, @Nullable RecommendProxyOuterClass$GetTopKuolieRoomListRsp response, @Nullable FromServiceMsg originalMsfRsp) {
            l.e(a.TAG, "requestRoomList - onError " + isMsfSuccess + "-" + msfResultCode + " -- " + timiErrCode + "-" + timiErrMsg + "-" + timiDisplayErrMsg);
            IResultListener<RecommendProxyOuterClass$GetTopKuolieRoomListRsp> iResultListener = this.f414598a;
            if (iResultListener != null) {
                iResultListener.onError(timiErrCode, timiErrMsg);
            }
        }

        @Override // pl4.d
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(@Nullable RecommendProxyOuterClass$GetTopKuolieRoomListRsp response, @Nullable FromServiceMsg originalMsfRsp) {
            l.i(a.TAG, "requestRoomList - success ");
            IResultListener<RecommendProxyOuterClass$GetTopKuolieRoomListRsp> iResultListener = this.f414598a;
            if (iResultListener != null) {
                iResultListener.onSuccess(response);
            }
        }
    }

    a() {
    }

    public final void b(@Nullable IResultListener<RecommendProxyOuterClass$GetTopKuolieRoomListRsp> callback) {
        l.i(TAG, "requestAnchorGameRoleList ");
        ((c) mm4.b.b(c.class)).F1(b.INSTANCE.a(), RecommendProxyOuterClass$GetTopKuolieRoomListRsp.class, new C10724a(callback));
    }
}
