package com.tencent.mobileqq.guild.feed.api;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.core.util.Consumer;
import androidx.core.util.Supplier;
import androidx.fragment.app.Fragment;
import com.qzone.module.covercomponent.model.CoverDBCacheData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.guild.data.s;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.jump.model.extras.JumpGuildNoticeMsg;
import com.tencent.mobileqq.guild.mainframe.GuildFeedReportSourceInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendFeed;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import cooperation.qzone.report.datong.QZoneDTLoginReporter;
import defpackage.FeedSectionTabLaunchParam;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u00012\u00020\u0002JD\u0010\f\u001a\u00020\u000b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052&\u0010\n\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b\u0018\u0001`\tH&J\u0012\u0010\u000e\u001a\u00020\r2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u000f\u001a\u00020\u000b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H&J\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002H&J$\u0010\u0015\u001a\u00020\u000b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0014\u001a\u00020\rH&J\b\u0010\u0016\u001a\u00020\u000bH&J\u001a\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u00172\b\b\u0002\u0010\u001a\u001a\u00020\u0019H&J\"\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u0019H&J\b\u0010\u001f\u001a\u00020\u000bH&J\b\u0010 \u001a\u00020\u000bH&J\u0018\u0010\"\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u0012H&J\u0012\u0010%\u001a\u00020$2\b\u0010#\u001a\u0004\u0018\u00010\u0012H&J-\u0010(\u001a\u0004\u0018\u00010$2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u0012H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b(\u0010)J#\u0010,\u001a\u00020$2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010+\u001a\u00020*H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b,\u0010-J\u0018\u0010.\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u0012H&J0\u0010.\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\u00052\u0006\u0010/\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u0012H&J0\u00102\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\u00052\u0006\u00100\u001a\u00020\u00052\u0006\u00101\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0019H&J(\u00103\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\u00052\u0006\u00100\u001a\u00020\u00052\u0006\u00101\u001a\u00020\u0005H&J:\u00103\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\u00052\u0006\u00100\u001a\u00020\u00052\u0006\u00104\u001a\u00020\u00192\u0006\u00105\u001a\u00020\u00192\b\b\u0002\u00107\u001a\u000206H&J^\u0010;\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010&\u001a\u0004\u0018\u00010\u00052\b\u00100\u001a\u0004\u0018\u00010\u00052\b\u00108\u001a\u0004\u0018\u00010\u00052\u0006\u00104\u001a\u00020\u00192\u0006\u00105\u001a\u00020\u00192\b\u00109\u001a\u0004\u0018\u00010\u00052\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b\u0018\u00010:H&J\u0018\u0010<\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0005H&J=\u0010<\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00050=2\u0006\u0010?\u001a\u00020\u00192\u0006\u0010@\u001a\u00020\u00192\u0006\u0010A\u001a\u00020\u0019H&\u00a2\u0006\u0004\b<\u0010BJn\u0010<\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010D\u001a\u00020C2\u0006\u0010E\u001a\u00020\u00052\u0006\u00104\u001a\u00020\u00192\u0006\u0010F\u001a\u00020\u00192\u0006\u0010H\u001a\u00020G2\u0006\u0010I\u001a\u00020G2\b\u0010J\u001a\u0004\u0018\u00010\u00052\u0006\u0010K\u001a\u00020\u00052\u0006\u0010L\u001a\u00020\u00052\u0006\u0010M\u001a\u00020\u00192\n\b\u0002\u0010O\u001a\u0004\u0018\u00010NH&J:\u0010\u0015\u001a\u00020\u000b2\u0006\u0010P\u001a\u00020N2\u0006\u0010D\u001a\u00020C2\b\u0010J\u001a\u0004\u0018\u00010\u00052\u0006\u0010K\u001a\u00020\u00052\u0006\u0010L\u001a\u00020\u00052\u0006\u0010Q\u001a\u00020\u0019H&J\u0010\u0010S\u001a\u00020\u000b2\u0006\u0010R\u001a\u00020\u0005H&J*\u0010V\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010T\u001a\u00020G2\b\u0010U\u001a\u0004\u0018\u00010\u00052\u0006\u0010J\u001a\u00020\u0005H&J\u0018\u0010X\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010+\u001a\u00020WH&\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006Y"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/api/IGuildFeedLauncherApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "Landroid/content/Context;", "context", "", "action", "Ljava/util/HashMap;", "Ljava/io/Serializable;", "Lkotlin/collections/HashMap;", Node.ATTRS_ATTR, "", "launchGuildFeedByScheme", "", "isGuildFeedSchemeAction", "launchGuildDebugPage", "mainViewContext", "getFeedNoticeCenterPanelController", "Landroid/os/Bundle;", "bundle", "needOpenNative", "launchGuildFeedDetailActivity", "launchGuildEmojiTransFragment", "Lcom/tencent/mobileqq/guild/jump/model/extras/JumpGuildNoticeMsg;", "params", "", "from", "launchGuildFeedNoticeFragment", "jumpId", "type", "launchGuildFeedNoticeFragmentInPersonalDimension", "launchGuildVisitorFeedNoticeFragment", "launchGuildFeedPreloadWebView", "extra", "launchGuildFeedSquareFragment", "arguments", "Landroidx/fragment/app/Fragment;", "createFeedTopFragment", "guildId", "extraParam", "createNewSquareFragment", "(Landroid/content/Context;Ljava/lang/String;Landroid/os/Bundle;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lb;", "param", "createFeedSectionFragment", "(Landroid/content/Context;Lb;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "launchGuildFeedPostsLoadFragment", "userId", "channelId", "troopUin", "launchTroopFeedNoticeActivity", "launchGuildFeedPublish", "businessType", "redirectAction", "Lcom/tencent/mobileqq/guild/mainframe/GuildFeedReportSourceInfo;", "reportMap", "channelName", "jsonFeedContent", "", "launchGuildFeedH5Publish", "launchGuildFeedGalleryActivity", "", CoverDBCacheData.URLS, "position", HippyTKDListViewAdapter.X, "y", "(Landroid/content/Context;[Ljava/lang/String;III)V", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProContentRecommendFeed;", "feed", "pageId", "preferStatus", "", "preferCount", "commentCount", "traceId", "sourceId", "subSourceId", "immersiveSource", "Landroid/view/View;", "sourceView", "v", "source", QZoneDTLoginReporter.SCHEMA, "launchByScheme", "topicId", "topicName", "launchTopicFeeds", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;", "launchGuildHomeFragment", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes13.dex */
public interface IGuildFeedLauncherApi extends QRouteApi {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public static final class a {
        public static /* synthetic */ void a(IGuildFeedLauncherApi iGuildFeedLauncherApi, Context context, Bundle bundle, boolean z16, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    z16 = false;
                }
                iGuildFeedLauncherApi.launchGuildFeedDetailActivity(context, bundle, z16);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: launchGuildFeedDetailActivity");
        }

        public static /* synthetic */ void b(IGuildFeedLauncherApi iGuildFeedLauncherApi, JumpGuildNoticeMsg jumpGuildNoticeMsg, int i3, int i16, Object obj) {
            if (obj == null) {
                if ((i16 & 2) != 0) {
                    i3 = 0;
                }
                iGuildFeedLauncherApi.launchGuildFeedNoticeFragment(jumpGuildNoticeMsg, i3);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: launchGuildFeedNoticeFragment");
        }
    }

    @Nullable
    Object createFeedSectionFragment(@NotNull Context context, @NotNull FeedSectionTabLaunchParam feedSectionTabLaunchParam, @NotNull Continuation<? super Fragment> continuation);

    @NotNull
    Fragment createFeedTopFragment(@Nullable Bundle arguments);

    @Nullable
    Object createNewSquareFragment(@NotNull Context context, @NotNull String str, @NotNull Bundle bundle, @NotNull Continuation<? super Fragment> continuation);

    @Nullable
    Object getFeedNoticeCenterPanelController(@Nullable Object mainViewContext);

    boolean isGuildFeedSchemeAction(@Nullable String action);

    void launchByScheme(@NotNull String r16);

    void launchGuildDebugPage(@Nullable Context context);

    void launchGuildEmojiTransFragment();

    void launchGuildFeedByScheme(@Nullable Context context, @Nullable String action, @Nullable HashMap<String, Serializable> r36);

    void launchGuildFeedDetailActivity(@Nullable Context context, @NotNull Bundle bundle, boolean needOpenNative);

    void launchGuildFeedDetailActivity(@NotNull View v3, @NotNull IGProContentRecommendFeed feed, @Nullable String traceId, @NotNull String sourceId, @NotNull String subSourceId, int source);

    void launchGuildFeedGalleryActivity(@NotNull Context context, @NotNull IGProContentRecommendFeed feed, @NotNull String pageId, int businessType, int preferStatus, long preferCount, long commentCount, @Nullable String traceId, @NotNull String sourceId, @NotNull String subSourceId, int immersiveSource, @Nullable View sourceView);

    void launchGuildFeedGalleryActivity(@NotNull Context context, @NotNull String params);

    void launchGuildFeedGalleryActivity(@NotNull Context context, @NotNull String[] r26, int position, int r46, int y16);

    void launchGuildFeedH5Publish(@NotNull Context context, @Nullable String guildId, @Nullable String channelId, @Nullable String channelName, int businessType, int redirectAction, @Nullable String jsonFeedContent, @Nullable Map<String, ? extends Serializable> r85);

    void launchGuildFeedNoticeFragment(@NotNull JumpGuildNoticeMsg params, int from);

    void launchGuildFeedNoticeFragmentInPersonalDimension(@NotNull String jumpId, int type, int from);

    void launchGuildFeedPostsLoadFragment(@NotNull Context context, @NotNull Bundle extra);

    void launchGuildFeedPostsLoadFragment(@NotNull Context context, @NotNull String guildId, @NotNull String userId, @NotNull String from, @NotNull Bundle extra);

    void launchGuildFeedPreloadWebView();

    void launchGuildFeedPublish(@NotNull Context context, @NotNull String guildId, @NotNull String channelId, int businessType, int redirectAction, @NotNull GuildFeedReportSourceInfo reportMap);

    void launchGuildFeedPublish(@NotNull Context context, @NotNull String guildId, @NotNull String channelId, @NotNull String troopUin);

    void launchGuildFeedSquareFragment(@NotNull Context context, @NotNull Bundle extra);

    void launchGuildHomeFragment(@NotNull Context context, @NotNull JumpGuildParam param);

    void launchGuildVisitorFeedNoticeFragment();

    void launchTopicFeeds(@NotNull Context context, long topicId, @Nullable String topicName, @NotNull String traceId);

    void launchTroopFeedNoticeActivity(@NotNull Context context, @NotNull String guildId, @NotNull String channelId, @NotNull String troopUin, int from);

    @NotNull
    /* synthetic */ Consumer<FeedEditorCheckItemResult> makeFallbackCheckItemResultConsumer(@NotNull String str, @NotNull Supplier<Activity> supplier);

    @NotNull
    /* synthetic */ Job performCheckItemOfFeedEditorStartup(int i3, @NotNull CoroutineScope coroutineScope, @Nullable s sVar, @NotNull FeedEditorLaunchOptionModel feedEditorLaunchOptionModel, @Nullable JSONObject jSONObject, @NotNull c cVar);

    @NotNull
    /* synthetic */ Job performCheckItemsToStartFeedEditorToPostNewOne(@NotNull Context context, @Nullable s sVar, @NotNull FeedEditorLaunchOptionModel feedEditorLaunchOptionModel, @NotNull FeedEditorLaunchSourceModel feedEditorLaunchSourceModel, @Nullable JSONObject jSONObject, @NotNull c cVar, @Nullable d dVar);
}
