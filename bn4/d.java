package bn4;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.l;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.UserProxyCmdOuterClass$ArkMsgRecvInfo;
import trpc.yes.common.UserProxyCmdOuterClass$SendArkMsgRsp;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013JL\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00022\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r\u00a8\u0006\u0014"}, d2 = {"Lbn4/d;", "", "", "textMessage", "", "Ltrpc/yes/common/UserProxyCmdOuterClass$ArkMsgRecvInfo;", "recList", "", "type", "", AppConstants.Key.COLUMN_MSG_SENDER_UIN, VirtualAppProxy.KEY_GAME_ID, "metaJson", "Lcom/tencent/timi/game/utils/IResultListener;", "Ltrpc/yes/common/UserProxyCmdOuterClass$SendArkMsgRsp;", "callback", "", "a", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f28702a = new d();

    /* compiled from: P */
    @Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016JP\u0010\u0011\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\u0012"}, d2 = {"bn4/d$a", "Lpl4/d;", "Ltrpc/yes/common/UserProxyCmdOuterClass$SendArkMsgRsp;", "response", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "originalMsfRsp", "", "d", "", "isMsfSuccess", "", "msfResultCode", "timiErrCode", "timiSubErrCode", "", "timiErrMsg", "timiDisplayErrMsg", "c", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class a implements pl4.d<UserProxyCmdOuterClass$SendArkMsgRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IResultListener<UserProxyCmdOuterClass$SendArkMsgRsp> f28703a;

        a(IResultListener<UserProxyCmdOuterClass$SendArkMsgRsp> iResultListener) {
            this.f28703a = iResultListener;
        }

        @Override // pl4.d
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(boolean isMsfSuccess, int msfResultCode, int timiErrCode, int timiSubErrCode, @Nullable String timiErrMsg, @Nullable String timiDisplayErrMsg, @Nullable UserProxyCmdOuterClass$SendArkMsgRsp response, @Nullable FromServiceMsg originalMsfRsp) {
            IResultListener<UserProxyCmdOuterClass$SendArkMsgRsp> iResultListener = this.f28703a;
            if (iResultListener != null) {
                iResultListener.onError(timiErrCode, timiErrMsg);
            }
            l.e("SendArkMsgRequest_", "requestUserInfo - onError -" + timiErrMsg + "-" + timiDisplayErrMsg);
        }

        @Override // pl4.d
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(@Nullable UserProxyCmdOuterClass$SendArkMsgRsp response, @Nullable FromServiceMsg originalMsfRsp) {
            l.i("SendArkMsgRequest_", "sendArkMsgRequest - success ");
            IResultListener<UserProxyCmdOuterClass$SendArkMsgRsp> iResultListener = this.f28703a;
            if (iResultListener != null) {
                iResultListener.onSuccess(response);
            }
        }
    }

    d() {
    }

    public final void a(@NotNull String textMessage, @NotNull List<UserProxyCmdOuterClass$ArkMsgRecvInfo> recList, int type, long senderUin, int gameId, @NotNull String metaJson, @Nullable IResultListener<UserProxyCmdOuterClass$SendArkMsgRsp> callback) {
        Intrinsics.checkNotNullParameter(textMessage, "textMessage");
        Intrinsics.checkNotNullParameter(recList, "recList");
        Intrinsics.checkNotNullParameter(metaJson, "metaJson");
        ((pl4.c) mm4.b.b(pl4.c.class)).F1(c.INSTANCE.a(textMessage, recList, type, senderUin, gameId, metaJson), UserProxyCmdOuterClass$SendArkMsgRsp.class, new a(callback));
    }
}
