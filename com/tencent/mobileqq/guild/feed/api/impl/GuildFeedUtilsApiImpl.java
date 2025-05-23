package com.tencent.mobileqq.guild.feed.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import cm1.a;
import com.airbnb.lottie.LottieAnimationView;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.guild.data.GuildSharePageSource;
import com.tencent.mobileqq.guild.data.profilecard.GuildBaseProfileData;
import com.tencent.mobileqq.guild.data.profilecard.GuildProfileData;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.RecommendExtData;
import com.tencent.mobileqq.guild.feed.adapter.GuildFeedCacheRecycleViewPool;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedUtilsApi;
import com.tencent.mobileqq.guild.feed.channeltop.GuildFeedChannelTopOperator;
import com.tencent.mobileqq.guild.feed.feedsquare.part.GuildFeedSquareV2PublishPart;
import com.tencent.mobileqq.guild.feed.feedsquare.utils.AbsGuildFeedMediaSizeUtils;
import com.tencent.mobileqq.guild.feed.feedsquare.utils.GuildFeedMediaSizeForRecommendUtils;
import com.tencent.mobileqq.guild.feed.feedsquare.utils.GuildFeedMediaSizeForSearchUtils;
import com.tencent.mobileqq.guild.feed.fragment.GuildAtTransFragment;
import com.tencent.mobileqq.guild.feed.fragment.GuildHashtagTransFragment;
import com.tencent.mobileqq.guild.feed.fragment.GuildPartTransFragment;
import com.tencent.mobileqq.guild.feed.gallery.GuildFeedGalleryFragment;
import com.tencent.mobileqq.guild.feed.gallery.widget.item.GuildBannerImageItemViewV2;
import com.tencent.mobileqq.guild.feed.manager.GuildInfoManager;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.layout.main.logic.ShareManageKt;
import com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.data.GProStFeedDetailRspWrapper;
import com.tencent.mobileqq.guild.feed.nativedetail.fragment.FeedNativeDetailFragment;
import com.tencent.mobileqq.guild.feed.publish.GuildTaskQueueManager;
import com.tencent.mobileqq.guild.feed.publish.event.GuildTriggerPublishOperationEvent;
import com.tencent.mobileqq.guild.feed.util.GuildFeedHtmlOfflineUtil;
import com.tencent.mobileqq.guild.feed.util.ax;
import com.tencent.mobileqq.guild.feed.util.bc;
import com.tencent.mobileqq.guild.feed.util.bl;
import com.tencent.mobileqq.guild.feed.video.GuildFeedVideoPlayParamManager;
import com.tencent.mobileqq.guild.feed.webbundle.GuildFeedDetailIdleTaskHelper;
import com.tencent.mobileqq.guild.feed.webbundle.GuildWebBundleManager;
import com.tencent.mobileqq.guild.mainframe.GuildFeedReportSourceInfo;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendFeed;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendGuild;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.ac;
import com.tencent.qqnt.kernel.nativeinterface.GProGuildRobotInfoReq;
import com.tencent.qqnt.kernel.nativeinterface.GProGuildRobotInfoRsp;
import com.tencent.qqnt.kernel.nativeinterface.IGProFetchGuildRobotInfoCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import com.tencent.richframework.preload.activity.BaseActivityResPreloadTask;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.io.FilesKt__UtilsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
import vh2.bq;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00ea\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u008c\u00012\u00020\u0001:\u0002\u008d\u0001B\t\u00a2\u0006\u0006\b\u008a\u0001\u0010\u008b\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J,\u0010\u0010\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000bH\u0016J\"\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0013\u001a\u00020\u000bH\u0016J4\u0010\u0017\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J*\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\u0018\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u000bH\u0016J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u001c\u001a\u00020\u0015H\u0016J\u0010\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u000bH\u0016J\u0018\u0010\"\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u000bH\u0016J\b\u0010#\u001a\u00020\u0004H\u0016J\b\u0010%\u001a\u00020$H\u0016JE\u0010.\u001a\u00020(2\u0006\u0010&\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020\u00152\u0006\u0010\r\u001a\u00020\u00152\u0006\u0010)\u001a\u00020(2\b\u0010+\u001a\u0004\u0018\u00010*2\u0006\u0010-\u001a\u00020,H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b.\u0010/J=\u00108\u001a\u00020\u00042\u0006\u00101\u001a\u0002002\b\u00103\u001a\u0004\u0018\u0001022\b\u00105\u001a\u0004\u0018\u0001042\u0006\u00106\u001a\u00020,2\b\u00107\u001a\u0004\u0018\u00010\u0015H\u0016\u00a2\u0006\u0004\b8\u00109J*\u0010.\u001a\u00020(2\u0006\u0010;\u001a\u00020:2\u0006\u0010)\u001a\u00020(2\b\u0010+\u001a\u0004\u0018\u00010*2\u0006\u0010-\u001a\u00020,H\u0016J\u0018\u0010>\u001a\u00020\u00042\u0006\u0010=\u001a\u00020<2\u0006\u0010&\u001a\u00020\u000bH\u0016J\b\u0010?\u001a\u00020\u0004H\u0016J\b\u0010A\u001a\u00020@H\u0016J\b\u0010B\u001a\u00020@H\u0016J\b\u0010C\u001a\u00020@H\u0016J=\u0010M\u001a\u00020\u00042\u0006\u0010E\u001a\u00020D2\u0006\u0010G\u001a\u00020F2#\u0010L\u001a\u001f\u0012\u0013\u0012\u00110,\u00a2\u0006\f\bI\u0012\b\bJ\u0012\u0004\b\b(K\u0012\u0004\u0012\u00020\u0004\u0018\u00010HH\u0016J\u0012\u0010Q\u001a\u00020P2\b\u0010O\u001a\u0004\u0018\u00010NH\u0016J\b\u0010R\u001a\u00020,H\u0016JS\u0010W\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010S\u001a\u00020\u000b2\u0006\u0010T\u001a\u00020,2!\u0010V\u001a\u001d\u0012\u0013\u0012\u00110,\u00a2\u0006\f\bI\u0012\b\bJ\u0012\u0004\b\b(U\u0012\u0004\u0012\u00020\u00040HH\u0016J\b\u0010X\u001a\u00020\u0004H\u0016J \u0010]\u001a\u00020\u000b2\u0006\u0010Y\u001a\u00020(2\u0006\u0010Z\u001a\u00020\u000b2\u0006\u0010\\\u001a\u00020[H\u0016J\u0010\u0010`\u001a\u00020\u00042\u0006\u0010_\u001a\u00020^H\u0016J\u0010\u0010b\u001a\u00020\u000b2\u0006\u0010a\u001a\u00020\u0015H\u0016J\u0010\u0010e\u001a\n\u0012\u0006\b\u0001\u0012\u00020d0cH\u0016J\u0010\u0010f\u001a\n\u0012\u0006\b\u0001\u0012\u00020d0cH\u0016J\b\u0010g\u001a\u00020\u000bH\u0016J\u000e\u0010j\u001a\u00020\u000b2\u0006\u0010i\u001a\u00020hJ\u0010\u0010m\u001a\u00020l2\u0006\u0010k\u001a\u00020PH\u0016J\u0010\u0010o\u001a\u00020$2\u0006\u0010n\u001a\u00020(H\u0016J \u0010s\u001a\u00020l2\u0006\u0010p\u001a\u00020l2\u0006\u0010q\u001a\u00020l2\u0006\u0010\f\u001a\u00020rH\u0016J\u0014\u0010v\u001a\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020u0tH\u0016J\u0014\u0010w\u001a\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020u0tH\u0016J\u0018\u0010z\u001a\u00020\u00042\u0006\u0010x\u001a\u00020\u000b2\u0006\u0010y\u001a\u00020\u000bH\u0002J\b\u0010{\u001a\u00020\u000bH\u0002J \u0010~\u001a\u00020}2\u0006\u0010|\u001a\u00020\u000b2\u0006\u0010y\u001a\u00020\u000b2\u0006\u0010_\u001a\u00020^H\u0002J(\u0010\u0081\u0001\u001a\t\u0012\u0005\u0012\u00030\u0080\u00010\u007f2\u0006\u0010y\u001a\u00020\u000b2\u0006\u0010_\u001a\u00020^2\u0006\u0010|\u001a\u00020\u000bH\u0002J!\u0010\u0083\u0001\u001a\u00020\u000b2\u000e\u0010\u0082\u0001\u001a\t\u0012\u0005\u0012\u00030\u0080\u00010\u007f2\u0006\u0010_\u001a\u00020^H\u0002J\u001a\u0010\u0085\u0001\u001a\u00030\u0084\u00012\u000e\u0010\u0082\u0001\u001a\t\u0012\u0005\u0012\u00030\u0080\u00010\u007fH\u0002JG\u0010\u0087\u0001\u001a\u00020\u00042\u0006\u0010E\u001a\u00020D2\u0006\u0010K\u001a\u00020,2\u0007\u0010\u0086\u0001\u001a\u00020F2#\u0010L\u001a\u001f\u0012\u0013\u0012\u00110,\u00a2\u0006\f\bI\u0012\b\bJ\u0012\u0004\b\b(K\u0012\u0004\u0012\u00020\u0004\u0018\u00010HH\u0002J\u001a\u0010\u0088\u0001\u001a\u00020\u00042\u0006\u0010E\u001a\u00020D2\u0007\u0010\u0086\u0001\u001a\u00020FH\u0002J>\u0010\u0089\u0001\u001a\u00020\u00042\u0006\u0010E\u001a\u00020D2\u0006\u0010G\u001a\u00020F2#\u0010L\u001a\u001f\u0012\u0013\u0012\u00110,\u00a2\u0006\f\bI\u0012\b\bJ\u0012\u0004\b\b(K\u0012\u0004\u0012\u00020\u0004\u0018\u00010HH\u0002\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u008e\u0001"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/api/impl/GuildFeedUtilsApiImpl;", "Lcom/tencent/mobileqq/guild/feed/api/IGuildFeedUtilsApi;", "Landroid/os/Bundle;", "params", "", "showGuildEmojiInFeed", "bundle", "showGuildAt", "showGuildHashtag", "showPartSelection", "registerMuteObserver", "", "guild", "channelId", "prePageId", "preType", "reportPageInAttaData", "pageId", "pageType", "refPageId", "reportMyPageInAttaData", "", "time", "reportPageOutAttaData", "reportMyPageOutAttaData", "troopId", "uin", "showTroopUserCard", "id", "getFeedImageServerPath", "videoId", "getFeedVideoPlayParam", "feedInfos", "stage", "exposeRecommend", "clearFeedListViewCache", "Lcom/tencent/biz/richframework/part/Part;", "getFeedPublishPart", "feedId", "guildId", "", "preferStatus", "Lcom/tencent/mobileqq/guild/mainframe/GuildFeedReportSourceInfo;", "reportMap", "", "enableFake", "doVoteUpFeed", "(Ljava/lang/String;JJILcom/tencent/mobileqq/guild/mainframe/GuildFeedReportSourceInfo;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroid/widget/ImageView;", "iv", "Lcom/airbnb/lottie/LottieAnimationView;", "likeAnimView", "Landroid/widget/TextView;", "tv", "like", "currentCount", "updateVoteUpUI", "(Landroid/widget/ImageView;Lcom/airbnb/lottie/LottieAnimationView;Landroid/widget/TextView;ZLjava/lang/Long;)V", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProContentRecommendFeed;", "feed", "Landroidx/fragment/app/FragmentActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "shareContent", "preloadToolProcess", "Lcom/tencent/richframework/preload/activity/BaseActivityResPreloadTask;", "getFeedSquarePreloadTask", "getFeedDetailPreloadTask", "getFeedGalleryPreloadTask", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/guild/data/profilecard/GuildProfileData;", "guildProfileData", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "isRobot", "onOpenCB", "openProfileOnClick", "", "byteArray", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", "convertToStFeedByNT", "isSelectHotPageByAB", "sectionName", "isSetTop", "isSuccess", "cb", "doChannelTop", "loadFeedHtmlOffline", "count", "zeroHint", "Lcom/tencent/mobileqq/guild/data/y;", "exceedConfig", "getShowCountString", "Lcom/tencent/mobileqq/guild/data/z;", "feedData", "publishAtOnce", "timestamp", "getFeedTimeFormat", "Ljava/lang/Class;", "Landroidx/fragment/app/Fragment;", "getFeedNativeDetailFragment", "getGuildFeedGalleryFragment", "getBizSrcJcFeed", "Ljava/io/File;", "file", "getMimeType", "stFeed", "", "parseStFeedToIFeedMainDisplayable", "businessType", "newGuildFeedFloatCommentContainerPart", "data", "ext", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProContentRecommendGuild;", "newRecommendFeedData", "Lkotlin/Pair;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/utils/AbsGuildFeedMediaSizeUtils;", "getRecommendFeedMediaUtils", "getSearchFeedMediaUtils", "publishJsonFeed", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "sendTriggerPublishEvent", "generateMainTaskId", "mainTaskId", "Lcom/tencent/mvi/base/route/k;", "handleGetPublishJson", "", "Lfm1/i;", "prepareMediaList", "mediaResult", "getPublishJson", "Lorg/json/JSONArray;", "getMediaTasksJson", "profileData", "openProfile", "realOpenProfile", "fetchRobotInfo", "<init>", "()V", "Companion", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedUtilsApiImpl implements IGuildFeedUtilsApi {

    @NotNull
    private static final String TAG = "GuildFeedUtilsApiImpl";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/feed/api/impl/GuildFeedUtilsApiImpl$b", "Lcom/tencent/mobileqq/guild/feed/channeltop/GuildFeedChannelTopOperator$a;", "", "result", "", "errMsg", "", "onResult", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements GuildFeedChannelTopOperator.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<Boolean, Unit> f218060a;

        /* JADX WARN: Multi-variable type inference failed */
        b(Function1<? super Boolean, Unit> function1) {
            this.f218060a = function1;
        }

        @Override // com.tencent.mobileqq.guild.feed.channeltop.GuildFeedChannelTopOperator.a
        public void onResult(int result, @NotNull String errMsg) {
            boolean z16;
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            Function1<Boolean, Unit> function1 = this.f218060a;
            if (result == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            function1.invoke(Boolean.valueOf(z16));
        }
    }

    private final void fetchRobotInfo(final Context context, final GuildProfileData guildProfileData, final Function1<? super Boolean, Unit> onOpenCB) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        try {
            String e16 = guildProfileData.getGuildBaseProfileData().e();
            Intrinsics.checkNotNullExpressionValue(e16, "guildProfileData.guildBaseProfileData.guildId");
            long parseLong = Long.parseLong(e16);
            String b16 = guildProfileData.getGuildBaseProfileData().b();
            Intrinsics.checkNotNullExpressionValue(b16, "guildProfileData.guildBaseProfileData.dstTinyId");
            long parseLong2 = Long.parseLong(b16);
            String a16 = guildProfileData.getGuildBaseProfileData().a();
            Intrinsics.checkNotNullExpressionValue(a16, "guildProfileData.guildBaseProfileData.channelId");
            GProGuildRobotInfoReq gProGuildRobotInfoReq = new GProGuildRobotInfoReq(parseLong, 0L, parseLong2, Long.parseLong(a16), sx1.f.d(), 0, 1L, 0L);
            ac robotService = ((IKernelService) peekAppRuntime.getRuntimeService(IKernelService.class, "")).getRobotService();
            if (robotService != null) {
                try {
                    robotService.fetchGuildRobotInfo(gProGuildRobotInfoReq, new IGProFetchGuildRobotInfoCallback() { // from class: com.tencent.mobileqq.guild.feed.api.impl.y
                        @Override // com.tencent.qqnt.kernel.nativeinterface.IGProFetchGuildRobotInfoCallback
                        public final void onFetchGuildRobotInfo(int i3, String str, GProGuildRobotInfoRsp gProGuildRobotInfoRsp) {
                            GuildFeedUtilsApiImpl.fetchRobotInfo$lambda$10(GuildFeedUtilsApiImpl.this, context, guildProfileData, onOpenCB, i3, str, gProGuildRobotInfoRsp);
                        }
                    });
                } catch (Exception e17) {
                    e = e17;
                    QLog.e(TAG, 1, "fetchRobotInfo exception: " + e.getMessage());
                }
            }
        } catch (Exception e18) {
            e = e18;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void fetchRobotInfo$lambda$10(GuildFeedUtilsApiImpl this$0, Context context, GuildProfileData guildProfileData, Function1 function1, int i3, String errMsg, GProGuildRobotInfoRsp gProGuildRobotInfoRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(guildProfileData, "$guildProfileData");
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        boolean z16 = true;
        if (i3 != 0 || gProGuildRobotInfoRsp == null) {
            QLog.e(TAG, 1, "fetchRobotInfo|result = " + i3 + " errMsg = " + errMsg);
            z16 = false;
        }
        this$0.openProfile(context, z16, guildProfileData, function1);
    }

    private final String generateMainTaskId() {
        return "GuildNativeMain" + System.nanoTime();
    }

    private final JSONArray getMediaTasksJson(List<? extends fm1.i> mediaResult) {
        JSONArray jSONArray = new JSONArray();
        Iterator<? extends fm1.i> it = mediaResult.iterator();
        while (it.hasNext()) {
            jSONArray.mo162put(it.next().getCom.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet.KEY_TASKID java.lang.String());
        }
        return jSONArray;
    }

    private final String getPublishJson(List<? extends fm1.i> mediaResult, com.tencent.mobileqq.guild.data.z feedData) {
        throw null;
    }

    private final com.tencent.mvi.base.route.k handleGetPublishJson(String mainTaskId, String taskId, com.tencent.mobileqq.guild.data.z feedData) {
        List<fm1.i> prepareMediaList = prepareMediaList(taskId, feedData, mainTaskId);
        String publishJson = getPublishJson(prepareMediaList, feedData);
        JSONArray mediaTasksJson = getMediaTasksJson(prepareMediaList);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("taskIds", mediaTasksJson);
        jSONObject.put("jsonFeed", publishJson);
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "it.toString()");
        return new a.MakeJsonMsgResult(jSONObject2, jSONObject);
    }

    private final void openProfile(final Context context, boolean isRobot, final GuildProfileData profileData, Function1<? super Boolean, Unit> onOpenCB) {
        QLog.i(TAG, 1, "[openProfile] isRobot: " + isRobot + ", profileData: " + profileData);
        if (isRobot) {
            profileData.getGuildBaseProfileData().y(true);
        }
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            realOpenProfile(context, profileData);
        } else {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.api.impl.x
                @Override // java.lang.Runnable
                public final void run() {
                    GuildFeedUtilsApiImpl.openProfile$lambda$9(GuildFeedUtilsApiImpl.this, context, profileData);
                }
            });
        }
        if (onOpenCB != null) {
            onOpenCB.invoke(Boolean.valueOf(isRobot));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void openProfile$lambda$9(GuildFeedUtilsApiImpl this$0, Context context, GuildProfileData profileData) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(profileData, "$profileData");
        this$0.realOpenProfile(context, profileData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void openProfileOnClick$lambda$2(GuildFeedUtilsApiImpl this$0, Context context, GuildProfileData guildProfileData, Function1 function1, GuildBaseProfileData guildBaseProfileData, int i3, String str, List list, List list2) {
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(guildProfileData, "$guildProfileData");
        boolean z17 = true;
        if (i3 == 0) {
            List list3 = list;
            if (list3 != null && !list3.isEmpty()) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                if (((IGProUserInfo) list.get(0)).getRobotType() != 1) {
                    z17 = false;
                }
                this$0.openProfile(context, z17, guildProfileData, function1);
                return;
            }
        }
        QLog.i(TAG, 1, "[openProfileOnClickAt] fail to get userInfo: " + guildBaseProfileData.b() + ", " + str);
        this$0.fetchRobotInfo(context, guildProfileData, function1);
    }

    private final List<fm1.i> prepareMediaList(String taskId, com.tencent.mobileqq.guild.data.z feedData, String mainTaskId) {
        throw null;
    }

    private static final void publishAtOnce$lambda$3(GuildFeedUtilsApiImpl this$0, String mainTaskId, String taskId, com.tencent.mobileqq.guild.data.z feedData) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(mainTaskId, "$mainTaskId");
        Intrinsics.checkNotNullParameter(taskId, "$taskId");
        Intrinsics.checkNotNullParameter(feedData, "$feedData");
        com.tencent.mvi.base.route.k handleGetPublishJson = this$0.handleGetPublishJson(mainTaskId, taskId, feedData);
        Intrinsics.checkNotNull(handleGetPublishJson, "null cannot be cast to non-null type com.tencent.mobileqq.guild.feed.nativepublish.content.FeedEditorContentMsgResult.MakeJsonMsgResult");
        this$0.sendTriggerPublishEvent(((a.MakeJsonMsgResult) handleGetPublishJson).getFeedJson(), mainTaskId);
    }

    private final void realOpenProfile(Context context, GuildProfileData profileData) {
        if (context instanceof Activity) {
            ((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).openGuildProfileDialog((Activity) context, profileData);
            return;
        }
        if (context instanceof ContextWrapper) {
            ContextWrapper contextWrapper = (ContextWrapper) context;
            if (contextWrapper.getBaseContext() instanceof Activity) {
                IQQGuildRouterApi iQQGuildRouterApi = (IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class);
                Context baseContext = contextWrapper.getBaseContext();
                Intrinsics.checkNotNull(baseContext, "null cannot be cast to non-null type android.app.Activity");
                iQQGuildRouterApi.openGuildProfileDialog((Activity) baseContext, profileData);
                return;
            }
        }
        QLog.i(TAG, 1, "[realOpenProfile] robot. context is not activity!");
    }

    private final void sendTriggerPublishEvent(String publishJsonFeed, String taskId) {
        bl c16 = bl.c();
        GuildTriggerPublishOperationEvent guildTriggerPublishOperationEvent = new GuildTriggerPublishOperationEvent();
        guildTriggerPublishOperationEvent.setMainTaskId(taskId);
        guildTriggerPublishOperationEvent.setJson(publishJsonFeed);
        guildTriggerPublishOperationEvent.setBusinessType(0);
        guildTriggerPublishOperationEvent.setPersonalGuildToBeCreated(false);
        guildTriggerPublishOperationEvent.setIsEdit(false);
        guildTriggerPublishOperationEvent.setMileStoneFeed(true);
        c16.a(guildTriggerPublishOperationEvent);
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedUtilsApi
    public void clearFeedListViewCache() {
        gn1.a.b();
        GuildFeedCacheRecycleViewPool.INSTANCE.a().e();
        jj1.b.a();
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedUtilsApi
    @NotNull
    public GProStFeed convertToStFeedByNT(@Nullable byte[] byteArray) {
        return com.tencent.mobileqq.guild.feed.util.m.a(byteArray);
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedUtilsApi
    public void doChannelTop(@NotNull String feedId, @NotNull String guildId, @NotNull String channelId, @NotNull String sectionName, boolean isSetTop, @NotNull Function1<? super Boolean, Unit> cb5) {
        Long longOrNull;
        long j3;
        Long longOrNull2;
        long j16;
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(sectionName, "sectionName");
        Intrinsics.checkNotNullParameter(cb5, "cb");
        Context context = QBaseActivity.sTopActivity;
        if (context == null) {
            context = BaseApplication.getContext();
        }
        GuildFeedChannelTopOperator guildFeedChannelTopOperator = GuildFeedChannelTopOperator.f218329a;
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(guildId);
        if (longOrNull != null) {
            j3 = longOrNull.longValue();
        } else {
            j3 = 0;
        }
        longOrNull2 = StringsKt__StringNumberConversionsKt.toLongOrNull(channelId);
        if (longOrNull2 != null) {
            j16 = longOrNull2.longValue();
        } else {
            j16 = 0;
        }
        GuildFeedChannelTopOperator.FeedChannelTopParam feedChannelTopParam = new GuildFeedChannelTopOperator.FeedChannelTopParam(feedId, j16, j3, sectionName, isSetTop, GuildSharePageSource.FEED_DETAIL.ordinal());
        Intrinsics.checkNotNullExpressionValue(context, "context");
        guildFeedChannelTopOperator.c(feedChannelTopParam, context, new b(cb5));
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedUtilsApi
    @Nullable
    public Object doVoteUpFeed(@NotNull String str, long j3, long j16, int i3, @Nullable GuildFeedReportSourceInfo guildFeedReportSourceInfo, boolean z16, @NotNull Continuation<? super Integer> continuation) {
        bc.a aVar = new bc.a();
        aVar.curPreferStatus = i3;
        aVar.operate = 2000;
        aVar.feedId = str;
        aVar.guildId = j3;
        aVar.channelId = j16;
        aVar.enableFake = z16;
        aVar.reportMap = guildFeedReportSourceInfo;
        return bc.e(aVar, continuation);
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedUtilsApi
    public void exposeRecommend(@NotNull String feedInfos, @NotNull String stage) {
        Intrinsics.checkNotNullParameter(feedInfos, "feedInfos");
        Intrinsics.checkNotNullParameter(stage, "stage");
        mk1.f.f416899a.a(feedInfos, stage);
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedUtilsApi
    @NotNull
    public String getBizSrcJcFeed() {
        return "biz_src_jc_feed";
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedUtilsApi
    @NotNull
    public BaseActivityResPreloadTask getFeedDetailPreloadTask() {
        return new sl1.a();
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedUtilsApi
    @NotNull
    public BaseActivityResPreloadTask getFeedGalleryPreloadTask() {
        return new dk1.a();
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedUtilsApi
    @Nullable
    public String getFeedImageServerPath(long id5) {
        return GuildBannerImageItemViewV2.INSTANCE.a().get(Long.valueOf(id5));
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedUtilsApi
    @NotNull
    public Class<? extends Fragment> getFeedNativeDetailFragment() {
        return FeedNativeDetailFragment.class;
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedUtilsApi
    @NotNull
    public Part getFeedPublishPart() {
        return new GuildFeedSquareV2PublishPart(0, 0, 2, null);
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedUtilsApi
    @NotNull
    public BaseActivityResPreloadTask getFeedSquarePreloadTask() {
        return new dk1.b();
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedUtilsApi
    @NotNull
    public String getFeedTimeFormat(long timestamp) {
        String w3 = ax.w(timestamp);
        Intrinsics.checkNotNullExpressionValue(w3, "getFeedTimeFormat(timestamp)");
        return w3;
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedUtilsApi
    @NotNull
    public Bundle getFeedVideoPlayParam(@NotNull String videoId) {
        Intrinsics.checkNotNullParameter(videoId, "videoId");
        Bundle bundle = new Bundle();
        GuildFeedVideoPlayParamManager guildFeedVideoPlayParamManager = GuildFeedVideoPlayParamManager.f223979d;
        bundle.putInt(InnerAudioPlugin.AUDIO_PROPERTY_CURRENTTIME, guildFeedVideoPlayParamManager.d(videoId));
        bundle.putBoolean("muteStatus", guildFeedVideoPlayParamManager.c());
        bundle.putBoolean("autoPlay", guildFeedVideoPlayParamManager.f());
        return bundle;
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedUtilsApi
    @NotNull
    public Class<? extends Fragment> getGuildFeedGalleryFragment() {
        return GuildFeedGalleryFragment.class;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0055 A[ORIG_RETURN, RETURN] */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String getMimeType(@NotNull File file) {
        String extension;
        Intrinsics.checkNotNullParameter(file, "file");
        extension = FilesKt__UtilsKt.getExtension(file);
        Locale ROOT = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
        String lowerCase = extension.toLowerCase(ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        int hashCode = lowerCase.hashCode();
        if (hashCode != 105441) {
            if (hashCode != 111145) {
                if (hashCode == 3268712 && lowerCase.equals(MimeHelper.IMAGE_SUBTYPE_JPEG)) {
                    return "image/jpeg";
                }
            } else if (lowerCase.equals("png")) {
                return "image/png";
            }
            return "application/octet-stream";
        }
        if (!lowerCase.equals("jpg")) {
            return "application/octet-stream";
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedUtilsApi
    @NotNull
    public Pair<Integer, AbsGuildFeedMediaSizeUtils> getRecommendFeedMediaUtils() {
        return TuplesKt.to(Integer.valueOf(com.tencent.mobileqq.guild.feed.feedsquare.utils.g.a()), GuildFeedMediaSizeForRecommendUtils.f219289d);
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedUtilsApi
    @NotNull
    public Pair<Integer, AbsGuildFeedMediaSizeUtils> getSearchFeedMediaUtils() {
        return TuplesKt.to(Integer.valueOf(com.tencent.mobileqq.guild.feed.feedsquare.utils.g.a()), GuildFeedMediaSizeForSearchUtils.f219293d);
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedUtilsApi
    @NotNull
    public String getShowCountString(int count, @NotNull String zeroHint, @NotNull com.tencent.mobileqq.guild.data.y exceedConfig) {
        Intrinsics.checkNotNullParameter(zeroHint, "zeroHint");
        Intrinsics.checkNotNullParameter(exceedConfig, "exceedConfig");
        return bl1.b.f28597a.g(count, zeroHint, exceedConfig);
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedUtilsApi
    public boolean isSelectHotPageByAB() {
        return tl1.d.f436521a.a();
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedUtilsApi
    public void loadFeedHtmlOffline() {
        GuildFeedHtmlOfflineUtil.f();
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedUtilsApi
    @NotNull
    public Part newGuildFeedFloatCommentContainerPart(int businessType) {
        return new com.tencent.mobileqq.guild.feed.gallery.part.a(businessType);
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedUtilsApi
    @NotNull
    public Object newRecommendFeedData(@NotNull Object data, @NotNull Object ext, @NotNull IGProContentRecommendGuild guild2) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(ext, "ext");
        Intrinsics.checkNotNullParameter(guild2, "guild");
        return new rj1.c((qj1.h) data, new rj1.d((RecommendExtData) ext, guild2));
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedUtilsApi
    public void openProfileOnClick(@NotNull final Context context, @NotNull final GuildProfileData guildProfileData, @Nullable final Function1<? super Boolean, Unit> onOpenCB) {
        boolean z16;
        boolean z17;
        ArrayList arrayListOf;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(guildProfileData, "guildProfileData");
        final GuildBaseProfileData guildBaseProfileData = guildProfileData.getGuildBaseProfileData();
        if (guildBaseProfileData.b() != null) {
            String b16 = guildBaseProfileData.b();
            Intrinsics.checkNotNullExpressionValue(b16, "profileData.dstTinyId");
            if (b16.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                String e16 = guildBaseProfileData.e();
                if (e16 != null && e16.length() != 0) {
                    z17 = false;
                } else {
                    z17 = true;
                }
                if (z17) {
                    QLog.i(TAG, 1, "[openProfileOnClickAt] guildId is null!");
                    openProfile(context, false, guildProfileData, onOpenCB);
                    return;
                } else {
                    IGPSService iGPSService = (IGPSService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IGPSService.class, "");
                    String e17 = guildBaseProfileData.e();
                    arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(guildBaseProfileData.b());
                    iGPSService.fetchUserInfo(e17, arrayListOf, false, new bq() { // from class: com.tencent.mobileqq.guild.feed.api.impl.z
                        @Override // vh2.bq
                        public final void a(int i3, String str, List list, List list2) {
                            GuildFeedUtilsApiImpl.openProfileOnClick$lambda$2(GuildFeedUtilsApiImpl.this, context, guildProfileData, onOpenCB, guildBaseProfileData, i3, str, list, list2);
                        }
                    });
                    return;
                }
            }
        }
        QLog.e(TAG, 1, "[openProfileOnClickAt] dstTinyId is null!");
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedUtilsApi
    @NotNull
    public Object parseStFeedToIFeedMainDisplayable(@NotNull GProStFeed stFeed) {
        Intrinsics.checkNotNullParameter(stFeed, "stFeed");
        return new GProStFeedDetailRspWrapper(stFeed, null, 2, null);
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedUtilsApi
    public void preloadToolProcess() {
        GuildFeedDetailIdleTaskHelper.INSTANCE.a().f(new GuildWebBundleManager.c());
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedUtilsApi
    public void publishAtOnce(@NotNull com.tencent.mobileqq.guild.data.z feedData) {
        Intrinsics.checkNotNullParameter(feedData, "feedData");
        GuildTaskQueueManager.m().C();
        com.tencent.mobileqq.guild.feed.nativepublish.publish.a.f222223a.b();
        generateMainTaskId();
        bl.c();
        throw null;
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedUtilsApi
    public void registerMuteObserver(@NotNull Bundle params) {
        Intrinsics.checkNotNullParameter(params, "params");
        String string = params.getString("key_guild_id");
        String string2 = params.getString("key_channel_id");
        if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
            GuildInfoManager.q().H(string, string2);
        } else {
            QLog.e(TAG, 1, "actionRegisterMuteObserver: channelId or guildId is null.");
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedUtilsApi
    public void reportMyPageInAttaData(@NotNull String pageId, @Nullable String pageType, @NotNull String refPageId) {
        Intrinsics.checkNotNullParameter(pageId, "pageId");
        Intrinsics.checkNotNullParameter(refPageId, "refPageId");
        com.tencent.mobileqq.guild.feed.report.e.d("pgin", pageId, pageType, refPageId, 0L);
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedUtilsApi
    public void reportMyPageOutAttaData(@NotNull String pageId, @Nullable String pageType, @NotNull String refPageId, long time) {
        Intrinsics.checkNotNullParameter(pageId, "pageId");
        Intrinsics.checkNotNullParameter(refPageId, "refPageId");
        com.tencent.mobileqq.guild.feed.report.e.d("pgout", pageId, "3", refPageId, time);
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedUtilsApi
    public void reportPageInAttaData(@NotNull String guild2, @NotNull String channelId, @Nullable String prePageId, @Nullable String preType) {
        Intrinsics.checkNotNullParameter(guild2, "guild");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        com.tencent.mobileqq.guild.feed.report.e.e(guild2, channelId, "pgin", "pg_channel_forum_page", "1", prePageId, preType, 0L);
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedUtilsApi
    public void reportPageOutAttaData(@NotNull String guild2, @NotNull String channelId, @Nullable String prePageId, @Nullable String preType, long time) {
        Intrinsics.checkNotNullParameter(guild2, "guild");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        com.tencent.mobileqq.guild.feed.report.e.e(guild2, channelId, "pgout", "pg_channel_forum_page", "1", prePageId, preType, time);
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedUtilsApi
    public void shareContent(@NotNull FragmentActivity activity, @NotNull String feedId) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        ShareManageKt.h(activity, feedId);
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedUtilsApi
    public void showGuildAt(@Nullable Bundle bundle) {
        if (yl1.n.d(false, 0, 3, null)) {
            return;
        }
        Intent intent = new Intent();
        if (bundle != null) {
            intent.putExtra("guild_key_at", bundle);
        }
        intent.putExtra("public_fragment_window_feature", 1);
        intent.addFlags(268435456);
        QPublicTransFragmentActivity.start(BaseApplication.getContext(), intent, GuildAtTransFragment.class);
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedUtilsApi
    public void showGuildEmojiInFeed(@NotNull Bundle params) {
        Intrinsics.checkNotNullParameter(params, "params");
        ax.L(params);
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedUtilsApi
    public void showGuildHashtag(@Nullable Bundle bundle) {
        Intent intent = new Intent();
        if (bundle != null) {
            intent.putExtra("guild_key_hashtag", bundle);
        }
        intent.addFlags(268435456);
        QPublicTransFragmentActivity.start(BaseApplication.getContext(), intent, GuildHashtagTransFragment.class);
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedUtilsApi
    public void showPartSelection(@Nullable Bundle bundle) {
        Intent intent = new Intent();
        if (bundle != null) {
            intent.putExtra("guild_key_part_selection", bundle);
        }
        intent.putExtra("public_fragment_window_feature", 1);
        intent.addFlags(268435456);
        QPublicTransFragmentActivity.start(BaseApplication.getContext(), intent, GuildPartTransFragment.class);
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedUtilsApi
    public void showTroopUserCard(@NotNull String troopId, @NotNull String uin) {
        Intrinsics.checkNotNullParameter(troopId, "troopId");
        Intrinsics.checkNotNullParameter(uin, "uin");
        if (TextUtils.isEmpty(troopId) || TextUtils.isEmpty(uin)) {
            QLog.e(TAG, 1, "showTroopUserCard param error !!! troopId = " + troopId + ", uin = " + uin + " ");
        }
        ax.M(troopId, uin);
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedUtilsApi
    public void updateVoteUpUI(@NotNull ImageView iv5, @Nullable LottieAnimationView likeAnimView, @Nullable TextView tv5, boolean like, @Nullable Long currentCount) {
        Intrinsics.checkNotNullParameter(iv5, "iv");
        com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.layout.main.logic.f.INSTANCE.a(iv5, likeAnimView, tv5, like, currentCount);
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedUtilsApi
    public int doVoteUpFeed(@NotNull IGProContentRecommendFeed feed, int preferStatus, @Nullable GuildFeedReportSourceInfo reportMap, boolean enableFake) {
        Intrinsics.checkNotNullParameter(feed, "feed");
        bc.a aVar = new bc.a();
        aVar.curPreferStatus = preferStatus;
        aVar.operate = 2000;
        aVar.feedId = feed.getIdd();
        aVar.guildId = feed.getGuildInfo().getGuildId();
        aVar.channelId = feed.getGuildInfo().getChannelId();
        aVar.enableFake = enableFake;
        aVar.reportMap = reportMap;
        return bc.d(aVar);
    }
}
