package bn4;

import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.l;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.CommonOuterClass$QQUserId;
import trpc.yes.common.UserProxyCmdOuterClass$GetArkMsgBodyRsp;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ6\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u00a8\u0006\u0010"}, d2 = {"Lbn4/b;", "", "", "type", VirtualAppProxy.KEY_GAME_ID, "", "userId", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "qqUid", "Lcom/tencent/timi/game/utils/IResultListener;", "Ltrpc/yes/common/UserProxyCmdOuterClass$GetArkMsgBodyRsp;", "callback", "", "a", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f28699a = new b();

    /* compiled from: P */
    @Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016JP\u0010\u0011\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\u0012"}, d2 = {"bn4/b$a", "Lpl4/d;", "Ltrpc/yes/common/UserProxyCmdOuterClass$GetArkMsgBodyRsp;", "response", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "originalMsfRsp", "", "d", "", "isMsfSuccess", "", "msfResultCode", "timiErrCode", "timiSubErrCode", "", "timiErrMsg", "timiDisplayErrMsg", "c", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class a implements pl4.d<UserProxyCmdOuterClass$GetArkMsgBodyRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IResultListener<UserProxyCmdOuterClass$GetArkMsgBodyRsp> f28700a;

        a(IResultListener<UserProxyCmdOuterClass$GetArkMsgBodyRsp> iResultListener) {
            this.f28700a = iResultListener;
        }

        @Override // pl4.d
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(boolean isMsfSuccess, int msfResultCode, int timiErrCode, int timiSubErrCode, @Nullable String timiErrMsg, @Nullable String timiDisplayErrMsg, @Nullable UserProxyCmdOuterClass$GetArkMsgBodyRsp response, @Nullable FromServiceMsg originalMsfRsp) {
            IResultListener<UserProxyCmdOuterClass$GetArkMsgBodyRsp> iResultListener = this.f28700a;
            if (iResultListener != null) {
                iResultListener.onError(timiErrCode, timiErrMsg);
            }
            l.e("GetArkMsgBodyRequest_", "requestUserInfo - onError -" + timiErrMsg + "-" + timiDisplayErrMsg);
        }

        @Override // pl4.d
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(@Nullable UserProxyCmdOuterClass$GetArkMsgBodyRsp response, @Nullable FromServiceMsg originalMsfRsp) {
            String str;
            PBStringField pBStringField;
            if (response != null && (pBStringField = response.body_json) != null) {
                str = pBStringField.get();
            } else {
                str = null;
            }
            l.i("GetArkMsgBodyRequest_", "sendArkMsgRequest - success " + str);
            IResultListener<UserProxyCmdOuterClass$GetArkMsgBodyRsp> iResultListener = this.f28700a;
            if (iResultListener != null) {
                iResultListener.onSuccess(response);
            }
        }
    }

    b() {
    }

    public final void a(int type, int gameId, long userId, @NotNull CommonOuterClass$QQUserId qqUid, @Nullable IResultListener<UserProxyCmdOuterClass$GetArkMsgBodyRsp> callback) {
        Intrinsics.checkNotNullParameter(qqUid, "qqUid");
        ((pl4.c) mm4.b.b(pl4.c.class)).F1(bn4.a.INSTANCE.a(type, gameId, userId, qqUid), UserProxyCmdOuterClass$GetArkMsgBodyRsp.class, new a(callback));
    }
}
