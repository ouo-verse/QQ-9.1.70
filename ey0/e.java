package ey0;

import com.tencent.icgame.game.userinfo.api.IUserInfo;
import com.tencent.icgame.trpc.yes.common.CommonOuterClass$OnlineRouteInfoList;
import com.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\b\u0016\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0004\b\u0018\u0010\u0019R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\u0011\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0017\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0003\u0010\u0015\"\u0004\b\u000b\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Ley0/e;", "", "Lcom/tencent/icgame/game/userinfo/api/IUserInfo;", "a", "Lcom/tencent/icgame/game/userinfo/api/IUserInfo;", "getUserInfo", "()Lcom/tencent/icgame/game/userinfo/api/IUserInfo;", "setUserInfo", "(Lcom/tencent/icgame/game/userinfo/api/IUserInfo;)V", ITVKPlayerEventListener.KEY_USER_INFO, "Lcom/tencent/icgame/trpc/yes/common/CommonOuterClass$OnlineRouteInfoList;", "b", "Lcom/tencent/icgame/trpc/yes/common/CommonOuterClass$OnlineRouteInfoList;", "getOnlineRouteInfoList", "()Lcom/tencent/icgame/trpc/yes/common/CommonOuterClass$OnlineRouteInfoList;", "setOnlineRouteInfoList", "(Lcom/tencent/icgame/trpc/yes/common/CommonOuterClass$OnlineRouteInfoList;)V", "onlineRouteInfoList", "", "c", "Z", "()Z", "(Z)V", "canAddQQFriendOpen", "<init>", "(Lcom/tencent/icgame/game/userinfo/api/IUserInfo;Lcom/tencent/icgame/trpc/yes/common/CommonOuterClass$OnlineRouteInfoList;)V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private IUserInfo userInfo;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private CommonOuterClass$OnlineRouteInfoList onlineRouteInfoList;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean canAddQQFriendOpen;

    public e(@Nullable IUserInfo iUserInfo, @Nullable CommonOuterClass$OnlineRouteInfoList commonOuterClass$OnlineRouteInfoList) {
        this.userInfo = iUserInfo;
        this.onlineRouteInfoList = commonOuterClass$OnlineRouteInfoList;
    }

    /* renamed from: a, reason: from getter */
    public final boolean getCanAddQQFriendOpen() {
        return this.canAddQQFriendOpen;
    }

    public final void b(boolean z16) {
        this.canAddQQFriendOpen = z16;
    }
}
