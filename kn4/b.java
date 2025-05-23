package kn4;

import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.timi.game.tim.api.message.c;
import com.tencent.timi.game.tim.api.message.d;
import com.tencent.timi.game.utils.IResultListener;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.MessageOuterClass$TimMsgBody;
import trpc.yes.common.TcloudServerOuterClass$GetUserTCloudSignRsp;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J\b\u0010\b\u001a\u00020\u0006H&J\u0018\u0010\u000b\u001a\u00020\u00062\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tH&J\b\u0010\r\u001a\u00020\fH&J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH&J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u000eH&J\u0010\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0014H&J\u0010\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0014H&J\u0018\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0019H&\u00a8\u0006\u001c"}, d2 = {"Lkn4/b;", "Lmm4/a;", "", "isLoaded", "Lkn4/a;", "callback", "", "T1", "logout", "Lcom/tencent/timi/game/utils/IResultListener;", "Ltrpc/yes/common/TcloudServerOuterClass$GetUserTCloudSignRsp;", "O", "Lln4/b;", "V1", "", "uid", "Lcom/tencent/timi/game/tim/api/message/c;", BdhLogUtil.LogTag.Tag_Conn, "groupId", "M", "Lcom/tencent/timi/game/tim/api/message/d;", "listener", "r0", "q2", "", "Ltrpc/yes/common/MessageOuterClass$TimMsgBody;", "timMsgBody", "q3", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public interface b extends mm4.a {
    @NotNull
    c C(long uid);

    @NotNull
    c M(long groupId);

    void O(@Nullable IResultListener<TcloudServerOuterClass$GetUserTCloudSignRsp> callback);

    void T1(@Nullable a callback);

    @NotNull
    ln4.b V1();

    boolean isLoaded();

    void logout();

    void q2(@NotNull d listener);

    void q3(@NotNull String groupId, @NotNull MessageOuterClass$TimMsgBody timMsgBody);

    void r0(@NotNull d listener);
}
