package bn4;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.NewIntent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pl4.a;
import trpc.yes.common.UserProxyCmdOuterClass$ArkMsgInfo;
import trpc.yes.common.UserProxyCmdOuterClass$ArkMsgRecvInfo;
import trpc.yes.common.UserProxyCmdOuterClass$SendArkMsgReq;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \u00062\u00020\u0001:\u0001\u0007B\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u00020\u0002H\u0014\u00a8\u0006\b"}, d2 = {"Lbn4/c;", "Lpl4/a;", "", "b", "<init>", "()V", "d", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class c extends pl4.a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J>\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0002\u00a8\u0006\u0011"}, d2 = {"Lbn4/c$a;", "", "", "textMessage", "", "Ltrpc/yes/common/UserProxyCmdOuterClass$ArkMsgRecvInfo;", "recList", "", "type", "", AppConstants.Key.COLUMN_MSG_SENDER_UIN, VirtualAppProxy.KEY_GAME_ID, "metaJson", "Lmqq/app/NewIntent;", "a", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: bn4.c$a, reason: from kotlin metadata */
    /* loaded from: classes26.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final NewIntent a(@NotNull String textMessage, @NotNull List<UserProxyCmdOuterClass$ArkMsgRecvInfo> recList, int type, long senderUin, int gameId, @NotNull String metaJson) {
            Intrinsics.checkNotNullParameter(textMessage, "textMessage");
            Intrinsics.checkNotNullParameter(recList, "recList");
            Intrinsics.checkNotNullParameter(metaJson, "metaJson");
            UserProxyCmdOuterClass$ArkMsgInfo userProxyCmdOuterClass$ArkMsgInfo = new UserProxyCmdOuterClass$ArkMsgInfo();
            userProxyCmdOuterClass$ArkMsgInfo.text_msg.set(textMessage);
            userProxyCmdOuterClass$ArkMsgInfo.recv_info_list.set(recList);
            userProxyCmdOuterClass$ArkMsgInfo.send_uin.set(senderUin);
            userProxyCmdOuterClass$ArkMsgInfo.meta_json.set(metaJson);
            UserProxyCmdOuterClass$SendArkMsgReq userProxyCmdOuterClass$SendArkMsgReq = new UserProxyCmdOuterClass$SendArkMsgReq();
            userProxyCmdOuterClass$SendArkMsgReq.type.set(type);
            userProxyCmdOuterClass$SendArkMsgReq.game_id.set(gameId);
            userProxyCmdOuterClass$SendArkMsgReq.info.set(userProxyCmdOuterClass$ArkMsgInfo);
            return a.C11028a.a(userProxyCmdOuterClass$SendArkMsgReq, c.class);
        }

        Companion() {
        }
    }

    @Override // pl4.a
    protected int b() {
        return 1202;
    }
}
