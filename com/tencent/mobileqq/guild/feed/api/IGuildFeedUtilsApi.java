package com.tencent.mobileqq.guild.feed.api;

import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.airbnb.lottie.LottieAnimationView;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.guild.data.profilecard.GuildProfileData;
import com.tencent.mobileqq.guild.data.y;
import com.tencent.mobileqq.guild.data.z;
import com.tencent.mobileqq.guild.mainframe.GuildFeedReportSourceInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendFeed;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendGuild;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import com.tencent.richframework.preload.activity.BaseActivityResPreloadTask;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00c2\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H&J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H&J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H&J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J,\u0010\u0010\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000bH&J\"\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0013\u001a\u00020\u000bH&J6\u0010\u0017\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u0016\u001a\u00020\u0015H&J,\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0013\u001a\u00020\u000b2\b\b\u0002\u0010\u0016\u001a\u00020\u0015H&J\u0018\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u000bH&J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u001c\u001a\u00020\u0015H&J\u0010\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u000bH&J\u0018\u0010\"\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u000bH&J\b\u0010#\u001a\u00020\u0004H&J\b\u0010%\u001a\u00020$H&J\b\u0010&\u001a\u00020$H&J\b\u0010'\u001a\u00020$H&J\b\u0010)\u001a\u00020(H&J*\u00102\u001a\u00020,2\u0006\u0010+\u001a\u00020*2\u0006\u0010-\u001a\u00020,2\b\u0010/\u001a\u0004\u0018\u00010.2\u0006\u00101\u001a\u000200H&JE\u00102\u001a\u00020,2\u0006\u00103\u001a\u00020\u000b2\u0006\u00104\u001a\u00020\u00152\u0006\u0010\r\u001a\u00020\u00152\u0006\u0010-\u001a\u00020,2\b\u0010/\u001a\u0004\u0018\u00010.2\u0006\u00101\u001a\u000200H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b2\u00105J?\u0010>\u001a\u00020\u00042\u0006\u00107\u001a\u0002062\n\b\u0002\u00109\u001a\u0004\u0018\u0001082\b\u0010;\u001a\u0004\u0018\u00010:2\u0006\u0010<\u001a\u0002002\b\u0010=\u001a\u0004\u0018\u00010\u0015H&\u00a2\u0006\u0004\b>\u0010?J\u0018\u0010B\u001a\u00020\u00042\u0006\u0010A\u001a\u00020@2\u0006\u00103\u001a\u00020\u000bH&J\b\u0010C\u001a\u00020\u0004H&J=\u0010M\u001a\u00020\u00042\u0006\u0010E\u001a\u00020D2\u0006\u0010G\u001a\u00020F2#\u0010L\u001a\u001f\u0012\u0013\u0012\u001100\u00a2\u0006\f\bI\u0012\b\bJ\u0012\u0004\b\b(K\u0012\u0004\u0012\u00020\u0004\u0018\u00010HH&J\u0012\u0010Q\u001a\u00020P2\b\u0010O\u001a\u0004\u0018\u00010NH&J\b\u0010R\u001a\u000200H&JS\u0010W\u001a\u00020\u00042\u0006\u00103\u001a\u00020\u000b2\u0006\u00104\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010S\u001a\u00020\u000b2\u0006\u0010T\u001a\u0002002!\u0010V\u001a\u001d\u0012\u0013\u0012\u001100\u00a2\u0006\f\bI\u0012\b\bJ\u0012\u0004\b\b(U\u0012\u0004\u0012\u00020\u00040HH&J\b\u0010X\u001a\u00020\u0004H&J$\u0010]\u001a\u00020\u000b2\u0006\u0010Y\u001a\u00020,2\b\b\u0002\u0010Z\u001a\u00020\u000b2\b\b\u0002\u0010\\\u001a\u00020[H&J\u0010\u0010`\u001a\u00020\u00042\u0006\u0010_\u001a\u00020^H&J\u0010\u0010b\u001a\u00020\u000b2\u0006\u0010a\u001a\u00020\u0015H&J\u0010\u0010e\u001a\n\u0012\u0006\b\u0001\u0012\u00020d0cH&J\u0010\u0010f\u001a\n\u0012\u0006\b\u0001\u0012\u00020d0cH&J\b\u0010g\u001a\u00020\u000bH&J\u0010\u0010j\u001a\u00020i2\u0006\u0010h\u001a\u00020PH&J \u0010n\u001a\u00020i2\u0006\u0010k\u001a\u00020i2\u0006\u0010l\u001a\u00020i2\u0006\u0010\f\u001a\u00020mH&J\u0014\u0010p\u001a\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020i0oH&J\u0014\u0010q\u001a\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020i0oH&J\u0010\u0010s\u001a\u00020(2\u0006\u0010r\u001a\u00020,H&\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006t"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/api/IGuildFeedUtilsApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Landroid/os/Bundle;", "params", "", "showGuildEmojiInFeed", "bundle", "showGuildAt", "showGuildHashtag", "showPartSelection", "registerMuteObserver", "", "guild", "channelId", "prePageId", "preType", "reportPageInAttaData", "pageId", "pageType", "refPageId", "reportMyPageInAttaData", "", "time", "reportPageOutAttaData", "reportMyPageOutAttaData", "troopId", "uin", "showTroopUserCard", "id", "getFeedImageServerPath", "videoId", "getFeedVideoPlayParam", "feedInfos", "stage", "exposeRecommend", "clearFeedListViewCache", "Lcom/tencent/richframework/preload/activity/BaseActivityResPreloadTask;", "getFeedSquarePreloadTask", "getFeedDetailPreloadTask", "getFeedGalleryPreloadTask", "Lcom/tencent/biz/richframework/part/Part;", "getFeedPublishPart", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProContentRecommendFeed;", "feed", "", "preferStatus", "Lcom/tencent/mobileqq/guild/mainframe/GuildFeedReportSourceInfo;", "reportMap", "", "enableFake", "doVoteUpFeed", "feedId", "guildId", "(Ljava/lang/String;JJILcom/tencent/mobileqq/guild/mainframe/GuildFeedReportSourceInfo;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroid/widget/ImageView;", "iv", "Lcom/airbnb/lottie/LottieAnimationView;", "likeAnimView", "Landroid/widget/TextView;", "tv", "like", "currentCount", "updateVoteUpUI", "(Landroid/widget/ImageView;Lcom/airbnb/lottie/LottieAnimationView;Landroid/widget/TextView;ZLjava/lang/Long;)V", "Landroidx/fragment/app/FragmentActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "shareContent", "preloadToolProcess", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/guild/data/profilecard/GuildProfileData;", "guildProfileData", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "isRobot", "onOpenCB", "openProfileOnClick", "", "byteArray", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", "convertToStFeedByNT", "isSelectHotPageByAB", "sectionName", "isSetTop", "isSuccess", "cb", "doChannelTop", "loadFeedHtmlOffline", "count", "zeroHint", "Lcom/tencent/mobileqq/guild/data/y;", "exceedConfig", "getShowCountString", "Lcom/tencent/mobileqq/guild/data/z;", "feedData", "publishAtOnce", "timestamp", "getFeedTimeFormat", "Ljava/lang/Class;", "Landroidx/fragment/app/Fragment;", "getFeedNativeDetailFragment", "getGuildFeedGalleryFragment", "getBizSrcJcFeed", "stFeed", "", "parseStFeedToIFeedMainDisplayable", "data", "ext", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProContentRecommendGuild;", "newRecommendFeedData", "Lkotlin/Pair;", "getRecommendFeedMediaUtils", "getSearchFeedMediaUtils", "businessType", "newGuildFeedFloatCommentContainerPart", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes13.dex */
public interface IGuildFeedUtilsApi extends QRouteApi {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public static final class a {
        public static /* synthetic */ String a(IGuildFeedUtilsApi iGuildFeedUtilsApi, int i3, String str, y yVar, int i16, Object obj) {
            if (obj == null) {
                if ((i16 & 2) != 0) {
                    str = "";
                }
                if ((i16 & 4) != 0) {
                    yVar = y.b.f216487d;
                }
                return iGuildFeedUtilsApi.getShowCountString(i3, str, yVar);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getShowCountString");
        }
    }

    void clearFeedListViewCache();

    @NotNull
    GProStFeed convertToStFeedByNT(@Nullable byte[] byteArray);

    void doChannelTop(@NotNull String feedId, @NotNull String guildId, @NotNull String channelId, @NotNull String sectionName, boolean isSetTop, @NotNull Function1<? super Boolean, Unit> cb5);

    int doVoteUpFeed(@NotNull IGProContentRecommendFeed feed, int preferStatus, @Nullable GuildFeedReportSourceInfo reportMap, boolean enableFake);

    @Nullable
    Object doVoteUpFeed(@NotNull String str, long j3, long j16, int i3, @Nullable GuildFeedReportSourceInfo guildFeedReportSourceInfo, boolean z16, @NotNull Continuation<? super Integer> continuation);

    void exposeRecommend(@NotNull String feedInfos, @NotNull String stage);

    @NotNull
    String getBizSrcJcFeed();

    @NotNull
    BaseActivityResPreloadTask getFeedDetailPreloadTask();

    @NotNull
    BaseActivityResPreloadTask getFeedGalleryPreloadTask();

    @Nullable
    String getFeedImageServerPath(long id5);

    @NotNull
    Class<? extends Fragment> getFeedNativeDetailFragment();

    @NotNull
    Part getFeedPublishPart();

    @NotNull
    BaseActivityResPreloadTask getFeedSquarePreloadTask();

    @NotNull
    String getFeedTimeFormat(long timestamp);

    @NotNull
    Bundle getFeedVideoPlayParam(@NotNull String videoId);

    @NotNull
    Class<? extends Fragment> getGuildFeedGalleryFragment();

    @NotNull
    Pair<Integer, Object> getRecommendFeedMediaUtils();

    @NotNull
    Pair<Integer, Object> getSearchFeedMediaUtils();

    @NotNull
    String getShowCountString(int count, @NotNull String zeroHint, @NotNull y exceedConfig);

    boolean isSelectHotPageByAB();

    void loadFeedHtmlOffline();

    @NotNull
    Part newGuildFeedFloatCommentContainerPart(int businessType);

    @NotNull
    Object newRecommendFeedData(@NotNull Object data, @NotNull Object ext, @NotNull IGProContentRecommendGuild guild2);

    void openProfileOnClick(@NotNull Context context, @NotNull GuildProfileData guildProfileData, @Nullable Function1<? super Boolean, Unit> onOpenCB);

    @NotNull
    Object parseStFeedToIFeedMainDisplayable(@NotNull GProStFeed stFeed);

    void preloadToolProcess();

    void publishAtOnce(@NotNull z feedData);

    void registerMuteObserver(@NotNull Bundle params);

    void reportMyPageInAttaData(@NotNull String pageId, @Nullable String pageType, @NotNull String refPageId);

    void reportMyPageOutAttaData(@NotNull String pageId, @Nullable String pageType, @NotNull String refPageId, long time);

    void reportPageInAttaData(@NotNull String guild2, @NotNull String channelId, @Nullable String prePageId, @Nullable String preType);

    void reportPageOutAttaData(@NotNull String guild2, @NotNull String channelId, @Nullable String prePageId, @Nullable String preType, long time);

    void shareContent(@NotNull FragmentActivity activity, @NotNull String feedId);

    void showGuildAt(@Nullable Bundle bundle);

    void showGuildEmojiInFeed(@NotNull Bundle params);

    void showGuildHashtag(@Nullable Bundle bundle);

    void showPartSelection(@Nullable Bundle bundle);

    void showTroopUserCard(@NotNull String troopId, @NotNull String uin);

    void updateVoteUpUI(@NotNull ImageView iv5, @Nullable LottieAnimationView likeAnimView, @Nullable TextView tv5, boolean like, @Nullable Long currentCount);
}
