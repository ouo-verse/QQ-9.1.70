package bm4;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.newnearby.INearbyAddFriendHelper;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import java.util.List;
import kotlin.Metadata;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import trpc.yes.common.CommonOuterClass$QQUserId;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0010\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J \u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH&J\u001e\u0010\u0012\u001a\u00020\f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u000b\u001a\u00020\u0011H&J0\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0017H&J0\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0017H&J8\u0010\u001c\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0017H&J@\u0010\u001f\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u0017H&J(\u0010\"\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u00172\u0006\u0010!\u001a\u00020\bH&J(\u0010&\u001a\u00020\f2\u0006\u0010#\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0017H&\u00a8\u0006'"}, d2 = {"Lbm4/a;", "Lmm4/a;", "", "uin", "Lmqq/app/AppRuntime;", "app", "", "H3", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "qqUserId", "Lcom/tencent/mobileqq/newnearby/INearbyAddFriendHelper$c;", "listener", "", "Q0", "", "", "tinyIdList", "Lcom/tencent/mobileqq/newnearby/INearbyAddFriendHelper$b;", "h3", "Lcom/tencent/mobileqq/app/QBaseActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "showName", "friendUserId", "", VirtualAppProxy.KEY_GAME_ID, "B3", "z2", "initiatorId", "k0", "subId", WadlProxyConsts.SCENE_ID, "w3", "matchRelationSource", "qqId", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "fromTinyId", "toTinyId", "nick", "B0", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public interface a extends mm4.a {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: bm4.a$a, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public static final class C0137a {
        public static int a(@NotNull a aVar) {
            return 1088;
        }
    }

    void B0(long fromTinyId, long toTinyId, @NotNull String nick, int gameId);

    void B3(@NotNull QBaseActivity activity, @NotNull String uin, @NotNull String showName, @NotNull CommonOuterClass$QQUserId friendUserId, int gameId);

    boolean H3(@NotNull String uin, @NotNull AppRuntime app);

    void Q(@NotNull QBaseActivity activity, @NotNull String uin, int matchRelationSource, @NotNull CommonOuterClass$QQUserId qqId);

    void Q0(@NotNull CommonOuterClass$QQUserId qqUserId, @NotNull AppRuntime app, @NotNull INearbyAddFriendHelper.c listener);

    void h3(@NotNull List<Long> tinyIdList, @NotNull INearbyAddFriendHelper.b listener);

    void k0(@NotNull QBaseActivity activity, @NotNull CommonOuterClass$QQUserId initiatorId, @NotNull String uin, @NotNull String showName, @NotNull CommonOuterClass$QQUserId friendUserId, int gameId);

    void w3(@NotNull QBaseActivity activity, @NotNull String uin, @NotNull String showName, @NotNull CommonOuterClass$QQUserId friendUserId, int gameId, int subId, int sceneId);

    void z2(@NotNull QBaseActivity activity, @NotNull String uin, @NotNull String showName, @NotNull CommonOuterClass$QQUserId friendUserId, int gameId);
}
