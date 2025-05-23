package bo4;

import com.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener;
import com.tencent.timi.game.userinfo.api.IUserInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.CommonOuterClass$OnlineRouteInfoList;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\b\u0016\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0004\b\u0017\u0010\u0018R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\u0010\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0016\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0003\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lbo4/f;", "", "Lcom/tencent/timi/game/userinfo/api/IUserInfo;", "a", "Lcom/tencent/timi/game/userinfo/api/IUserInfo;", "c", "()Lcom/tencent/timi/game/userinfo/api/IUserInfo;", "setUserInfo", "(Lcom/tencent/timi/game/userinfo/api/IUserInfo;)V", ITVKPlayerEventListener.KEY_USER_INFO, "Ltrpc/yes/common/CommonOuterClass$OnlineRouteInfoList;", "b", "Ltrpc/yes/common/CommonOuterClass$OnlineRouteInfoList;", "()Ltrpc/yes/common/CommonOuterClass$OnlineRouteInfoList;", "setOnlineRouteInfoList", "(Ltrpc/yes/common/CommonOuterClass$OnlineRouteInfoList;)V", "onlineRouteInfoList", "", "Z", "()Z", "d", "(Z)V", "canAddQQFriendOpen", "<init>", "(Lcom/tencent/timi/game/userinfo/api/IUserInfo;Ltrpc/yes/common/CommonOuterClass$OnlineRouteInfoList;)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private IUserInfo userInfo;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private CommonOuterClass$OnlineRouteInfoList onlineRouteInfoList;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean canAddQQFriendOpen;

    public f(@Nullable IUserInfo iUserInfo, @Nullable CommonOuterClass$OnlineRouteInfoList commonOuterClass$OnlineRouteInfoList) {
        this.userInfo = iUserInfo;
        this.onlineRouteInfoList = commonOuterClass$OnlineRouteInfoList;
    }

    /* renamed from: a, reason: from getter */
    public final boolean getCanAddQQFriendOpen() {
        return this.canAddQQFriendOpen;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final CommonOuterClass$OnlineRouteInfoList getOnlineRouteInfoList() {
        return this.onlineRouteInfoList;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final IUserInfo getUserInfo() {
        return this.userInfo;
    }

    public final void d(boolean z16) {
        this.canAddQQFriendOpen = z16;
    }
}
