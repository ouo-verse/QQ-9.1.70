package com.tencent.mobileqq.nearbypro.api.router;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.fragment.app.Fragment;
import com.qzone.album.data.model.PhotoCategorySummaryInfo;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqmini.sdk.plugins.QQFriendJsPlugin;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import op4.i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u001a\u0010\r\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u000bH&J\u001a\u0010\r\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\f\u001a\u00020\u000bH&J:\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u0013H&J \u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000bH&J=\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000b2#\u0010\u001d\u001a\u001f\u0012\u0013\u0012\u00110\u0019\u00a2\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0018H&J\u0018\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J,\u0010$\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010!\u001a\u00020 2\b\b\u0002\u0010\"\u001a\u00020\u00192\b\b\u0002\u0010#\u001a\u00020\u0013H&J\u0018\u0010%\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010!\u001a\u00020 H&J \u0010(\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010&\u001a\u00020\u00132\u0006\u0010'\u001a\u00020\u000bH&J]\u0010.\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010)\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010 2\b\u0010\u001b\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u000b2\b\u0010*\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010+2\u0006\u0010-\u001a\u00020\u0013H&\u00a2\u0006\u0004\b.\u0010/J \u0010$\u001a\u00020\u00062\u0006\u00100\u001a\u00020\u00022\u0006\u0010!\u001a\u00020 2\u0006\u00101\u001a\u00020\u0013H&J \u00105\u001a\u00020\u00062\u0006\u00100\u001a\u00020\u00022\u0006\u0010&\u001a\u0002022\u0006\u00104\u001a\u000203H&J,\u0010:\u001a\u00020\u00062\u0006\u00100\u001a\u00020\u00022\n\u00107\u001a\u00060\u0013j\u0002`62\u0006\u0010&\u001a\u00020\u00132\u0006\u00109\u001a\u000208H&\u00a8\u0006;"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/api/router/INearbyProPageRouter;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Landroid/content/Context;", "ctx", "Landroid/content/Intent;", "intent", "", "launchProfileEditPage", "launchNearbyMainFragment", "Landroidx/fragment/app/Fragment;", "fragment", "", "poiId", "routeToLocationPage", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "tinyID", "nickname", PhotoCategorySummaryInfo.AVATAR_URL, "", "sourceType", "tacitInvite", "launchNearbyAIOFragment", QQFriendJsPlugin.API_ADD_FRIEND, "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", GuildMsgItem.NICK_FRIEND, "callback", IProfileProtocolConst.PARAM_IS_FRIEND, "launchNearbyChatsListFragment", "", "tinyId", "isMode", "sourceId", "launchNearbyPersonalFragment", "launchNearbyPersonalFragmentFromAIO", "source", "topicIds", "launchNearbyFeedPublishFragment", "feedID", "avatarDressBorderUrl", "Lop4/i;", "feed", "from", "launchNearbyFeedDetailFragment", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lop4/i;I)V", "context", AdMetricTag.Report.TYPE, "Lcom/tencent/mobileqq/nearbypro/api/router/NBPArticleFeedDetailPageSource;", "Lcom/tencent/mobileqq/nearbypro/api/router/a;", "launchData", "launchArticleFeedDetailPage", "Lcom/tencent/mobileqq/nearbypro/api/data/AppID;", "appId", "Lcom/tencent/mobileqq/nearbypro/api/router/b;", "data", "launchFeedSharePage", "qq_nearby_pro_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface INearbyProPageRouter extends QRouteApi {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes15.dex */
    public static final class a {
        public static /* synthetic */ void a(INearbyProPageRouter iNearbyProPageRouter, Context context, String str, String str2, String str3, int i3, int i16, int i17, Object obj) {
            if (obj == null) {
                if ((i17 & 32) != 0) {
                    i16 = 0;
                }
                iNearbyProPageRouter.launchNearbyAIOFragment(context, str, str2, str3, i3, i16);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: launchNearbyAIOFragment");
        }

        public static /* synthetic */ void b(INearbyProPageRouter iNearbyProPageRouter, Context context, long j3, boolean z16, int i3, int i16, Object obj) {
            if (obj == null) {
                if ((i16 & 4) != 0) {
                    z16 = true;
                }
                boolean z17 = z16;
                if ((i16 & 8) != 0) {
                    i3 = 0;
                }
                iNearbyProPageRouter.launchNearbyPersonalFragment(context, j3, z17, i3);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: launchNearbyPersonalFragment");
        }
    }

    void addFriend(@NotNull Context context, @NotNull String str, @NotNull String str2);

    void isFriend(@NotNull Context context, @NotNull String str, @Nullable Function1<? super Boolean, Unit> function1);

    void launchArticleFeedDetailPage(@NotNull Context context, @NotNull NBPArticleFeedDetailPageSource source, @NotNull com.tencent.mobileqq.nearbypro.api.router.a launchData);

    void launchFeedSharePage(@NotNull Context context, int appId, int source, @NotNull NearbyFeedPosterData data);

    void launchNearbyAIOFragment(@NotNull Context ctx, @NotNull String tinyID, @NotNull String nickname, @NotNull String r46, int sourceType, int tacitInvite);

    void launchNearbyChatsListFragment(@NotNull Context ctx, @NotNull Intent intent);

    void launchNearbyFeedDetailFragment(@NotNull Context ctx, @Nullable String feedID, @Nullable Long tinyID, @Nullable String name, @Nullable String r56, @Nullable String avatarDressBorderUrl, @Nullable i feed, int from);

    void launchNearbyFeedPublishFragment(@NotNull Context ctx, int source, @NotNull String topicIds);

    void launchNearbyMainFragment(@NotNull Context ctx, @NotNull Intent intent);

    void launchNearbyPersonalFragment(@NotNull Context context, long tinyId, int r46);

    void launchNearbyPersonalFragment(@NotNull Context ctx, long tinyId, boolean isMode, int sourceId);

    void launchNearbyPersonalFragmentFromAIO(@NotNull Context ctx, long tinyId);

    void launchProfileEditPage(@NotNull Context ctx, @NotNull Intent intent);

    void routeToLocationPage(@Nullable Activity r16, @NotNull String poiId);

    void routeToLocationPage(@Nullable Fragment fragment, @NotNull String poiId);
}
