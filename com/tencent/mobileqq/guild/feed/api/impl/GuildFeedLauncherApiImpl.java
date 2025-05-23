package com.tencent.mobileqq.guild.feed.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.core.os.BundleKt;
import androidx.core.util.Consumer;
import androidx.core.util.Supplier;
import androidx.fragment.app.Fragment;
import com.qzone.module.covercomponent.model.CoverDBCacheData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.pubaccount.weishi.WSAutoShowCommentParams;
import com.tencent.biz.richframework.animation.transition.TransitionBean;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.feed.GuildFeedMyFeedsFragmentV2;
import com.tencent.mobileqq.guild.feed.api.AnimationParams;
import com.tencent.mobileqq.guild.feed.api.FeedEditorCheckItemResult;
import com.tencent.mobileqq.guild.feed.api.FeedEditorLaunchOptionModel;
import com.tencent.mobileqq.guild.feed.api.FeedEditorLaunchSourceModel;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedLauncherApi;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedMiscApi;
import com.tencent.mobileqq.guild.feed.bean.GuildFeedRichMediaData;
import com.tencent.mobileqq.guild.feed.feedsection.fragment.FeedSectionSecondaryListFragment;
import com.tencent.mobileqq.guild.feed.feedsquare.fragment.GuildFeedSquareHomeFragment;
import com.tencent.mobileqq.guild.feed.fragment.GuildEmojiTransFragment;
import com.tencent.mobileqq.guild.feed.fragment.GuildFeedNoticeFragment;
import com.tencent.mobileqq.guild.feed.fragment.GuildVisitorFeedNoticeFragment;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedBaseInitBean;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedDetailInitBean;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedGalleryInitBean;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedLauncher;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedPublishThirdContentInitBean;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedSchemeBean;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedTroopInitBean;
import com.tencent.mobileqq.guild.feed.manager.GuildFeedDetailDataCacheManager;
import com.tencent.mobileqq.guild.feed.nativepublish.launcher.compat.FeedPublishEditorLaunchCompat;
import com.tencent.mobileqq.guild.feed.preload.detail.data.GuildFeedDetailPreloadParams;
import com.tencent.mobileqq.guild.feed.squarehead.GuildFeedSquareHeaderFragment;
import com.tencent.mobileqq.guild.feed.util.am;
import com.tencent.mobileqq.guild.feed.util.ax;
import com.tencent.mobileqq.guild.feed.util.bm;
import com.tencent.mobileqq.guild.feed.webbundle.GuildWebBundleManager;
import com.tencent.mobileqq.guild.homev2.fragments.GuildHomeV2Fragment;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.jump.model.extras.JumpGuildNoticeMsg;
import com.tencent.mobileqq.guild.mainframe.GuildAppReportSourceInfo;
import com.tencent.mobileqq.guild.mainframe.GuildFeedReportSourceInfo;
import com.tencent.mobileqq.guild.util.IQQGuildUtilApi;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendFeed;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProFeedGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProImage;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProPoster;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProVideo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStImage;
import com.tencent.troopguild.api.ITroopGuildApi;
import cooperation.qzone.report.datong.QZoneDTLoginReporter;
import defpackage.FeedSectionTabLaunchParam;
import dj1.b;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00fc\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u0084\u00012\u00020\u00012\u00020\u0002:\u0002\u0085\u0001B\t\u00a2\u0006\u0006\b\u0082\u0001\u0010\u0083\u0001J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J%\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J \u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0007H\u0002J \u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0007H\u0002J \u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\u0010\u0010\u001f\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u001dH\u0002J'\u0010%\u001a\b\u0012\u0004\u0012\u00020$0#2\u0006\u0010\u0013\u001a\u00020\u00122\u000e\u0010\"\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010!0 H\u0096\u0001J=\u00102\u001a\u0002012\u0006\u0010&\u001a\u00020\t2\u0006\u0010(\u001a\u00020'2\b\u0010*\u001a\u0004\u0018\u00010)2\u0006\u0010,\u001a\u00020+2\b\u0010.\u001a\u0004\u0018\u00010-2\u0006\u00100\u001a\u00020/H\u0096\u0001JM\u00107\u001a\u0002012\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010*\u001a\u0004\u0018\u00010)2\b\b\u0002\u0010,\u001a\u00020+2\b\b\u0002\u00104\u001a\u0002032\n\b\u0002\u0010.\u001a\u0004\u0018\u00010-2\u0006\u00100\u001a\u00020/2\b\u00106\u001a\u0004\u0018\u000105H\u0096\u0001JD\u0010=\u001a\u00020\u00172\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u00108\u001a\u0004\u0018\u00010\u00122&\u0010<\u001a\"\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020:\u0018\u000109j\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020:\u0018\u0001`;H\u0016J\u0012\u0010?\u001a\u00020>2\b\u00108\u001a\u0004\u0018\u00010\u0012H\u0016J\u0012\u0010@\u001a\u00020\u00172\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\u0012\u0010B\u001a\u00020\u00022\b\u0010A\u001a\u0004\u0018\u00010\u0002H\u0016J\"\u0010D\u001a\u00020\u00172\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010C\u001a\u00020>H\u0016J:\u0010D\u001a\u00020\u00172\u0006\u0010E\u001a\u00020\u00032\u0006\u0010G\u001a\u00020F2\b\u0010&\u001a\u0004\u0018\u00010\u00122\u0006\u0010H\u001a\u00020\u00122\u0006\u0010I\u001a\u00020\u00122\u0006\u00104\u001a\u00020\tH\u0016J\b\u0010J\u001a\u00020\u0017H\u0016J \u0010M\u001a\u00020\u00172\u0006\u0010K\u001a\u00020\u00122\u0006\u0010\n\u001a\u00020\t2\u0006\u0010L\u001a\u00020\tH\u0016J\u0018\u0010P\u001a\u00020\u00172\u0006\u0010O\u001a\u00020N2\u0006\u0010L\u001a\u00020\tH\u0016J\b\u0010Q\u001a\u00020\u0017H\u0016J\b\u0010R\u001a\u00020\u0017H\u0016J\u0018\u0010S\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0007H\u0016J\u0012\u0010U\u001a\u00020\u000b2\b\u0010T\u001a\u0004\u0018\u00010\u0007H\u0016J-\u0010W\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010V\u001a\u00020\u0007H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\bW\u0010XJ\u0018\u0010Y\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0007H\u0016J0\u0010Y\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010Z\u001a\u00020\u00122\u0006\u0010L\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0007H\u0016J0\u0010]\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010[\u001a\u00020\u00122\u0006\u0010\\\u001a\u00020\u00122\u0006\u0010L\u001a\u00020\tH\u0016J(\u0010^\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010[\u001a\u00020\u00122\u0006\u0010\\\u001a\u00020\u0012H\u0016J8\u0010^\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010[\u001a\u00020\u00122\u0006\u0010_\u001a\u00020\t2\u0006\u0010`\u001a\u00020\t2\u0006\u0010b\u001a\u00020aH\u0016J^\u0010f\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010[\u001a\u0004\u0018\u00010\u00122\b\u0010c\u001a\u0004\u0018\u00010\u00122\u0006\u0010_\u001a\u00020\t2\u0006\u0010`\u001a\u00020\t2\b\u0010d\u001a\u0004\u0018\u00010\u00122\u0014\u0010<\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020:\u0018\u00010eH\u0016J\u0018\u0010g\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010O\u001a\u00020\u0012H\u0016J=\u0010g\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u00142\f\u0010i\u001a\b\u0012\u0004\u0012\u00020\u00120h2\u0006\u0010j\u001a\u00020\t2\u0006\u0010k\u001a\u00020\t2\u0006\u0010l\u001a\u00020\tH\u0016\u00a2\u0006\u0004\bg\u0010mJl\u0010g\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010G\u001a\u00020F2\u0006\u0010n\u001a\u00020\u00122\u0006\u0010_\u001a\u00020\t2\u0006\u0010o\u001a\u00020\t2\u0006\u0010q\u001a\u00020p2\u0006\u0010r\u001a\u00020p2\b\u0010&\u001a\u0004\u0018\u00010\u00122\u0006\u0010s\u001a\u00020\u00122\u0006\u0010t\u001a\u00020\u00122\u0006\u0010u\u001a\u00020\t2\b\u0010v\u001a\u0004\u0018\u00010\u0003H\u0016J\u0010\u0010x\u001a\u00020\u00172\u0006\u0010w\u001a\u00020\u0012H\u0016J*\u0010{\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010y\u001a\u00020p2\b\u0010z\u001a\u0004\u0018\u00010\u00122\u0006\u0010&\u001a\u00020\u0012H\u0016J#\u0010~\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010}\u001a\u00020|H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b~\u0010\u007fJ\u001a\u0010\u0081\u0001\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u00142\u0007\u0010}\u001a\u00030\u0080\u0001H\u0016\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0086\u0001"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/api/impl/GuildFeedLauncherApiImpl;", "Lcom/tencent/mobileqq/guild/feed/api/IGuildFeedLauncherApi;", "", "Landroid/view/View;", "cardView", "Lcom/tencent/mobileqq/guild/feed/api/AnimationParams;", "getAnimationParams", "Landroid/os/Bundle;", "bundle", "", "type", "Landroidx/fragment/app/Fragment;", "createSquareFragmentAsync", "(Landroid/os/Bundle;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Ljn1/d;", "bean", "Lcom/tencent/biz/richframework/animation/transition/TransitionBean;", "initTransition", "", "guildId", "Landroid/content/Context;", "context", "extra", "", "openGuildFeedSquareAsync", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "guildInfo", "doOpenGuildFeedSquare", "doOpenGuildFeedsHome", "Lcom/tencent/mobileqq/guild/feed/preload/detail/data/GuildFeedDetailPreloadParams;", "preloadParams", "tryPreloadFeedDetail", "Landroidx/core/util/Supplier;", "Landroid/app/Activity;", "activitySupplier", "Landroidx/core/util/Consumer;", "Lcom/tencent/mobileqq/guild/feed/api/a;", "makeFallbackCheckItemResultConsumer", "traceId", "Lkotlinx/coroutines/CoroutineScope;", "scope", "Lcom/tencent/mobileqq/guild/data/s;", "contact", "Lcom/tencent/mobileqq/guild/feed/api/FeedEditorLaunchOptionModel;", "option", "Lorg/json/JSONObject;", "richContentJson", "Lcom/tencent/mobileqq/guild/feed/api/c;", "checkItemListener", "Lkotlinx/coroutines/Job;", "performCheckItemOfFeedEditorStartup", "Lcom/tencent/mobileqq/guild/feed/api/b;", "source", "Lcom/tencent/mobileqq/guild/feed/api/d;", "startProcedureAware", "performCheckItemsToStartFeedEditorToPostNewOne", "action", "Ljava/util/HashMap;", "Ljava/io/Serializable;", "Lkotlin/collections/HashMap;", Node.ATTRS_ATTR, "launchGuildFeedByScheme", "", "isGuildFeedSchemeAction", "launchGuildDebugPage", "mainViewContext", "getFeedNoticeCenterPanelController", "needOpenNative", "launchGuildFeedDetailActivity", "v", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProContentRecommendFeed;", "feed", "sourceId", "subSourceId", "launchGuildEmojiTransFragment", "jumpId", "from", "launchGuildFeedNoticeFragmentInPersonalDimension", "Lcom/tencent/mobileqq/guild/jump/model/extras/JumpGuildNoticeMsg;", "params", "launchGuildFeedNoticeFragment", "launchGuildVisitorFeedNoticeFragment", "launchGuildFeedPreloadWebView", "launchGuildFeedSquareFragment", "arguments", "createFeedTopFragment", "extraParam", "createNewSquareFragment", "(Landroid/content/Context;Ljava/lang/String;Landroid/os/Bundle;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "launchGuildFeedPostsLoadFragment", "userId", "channelId", "troopUin", "launchTroopFeedNoticeActivity", "launchGuildFeedPublish", "businessType", "redirectAction", "Lcom/tencent/mobileqq/guild/mainframe/GuildFeedReportSourceInfo;", "reportMap", "channelName", "jsonFeedContent", "", "launchGuildFeedH5Publish", "launchGuildFeedGalleryActivity", "", CoverDBCacheData.URLS, "position", HippyTKDListViewAdapter.X, "y", "(Landroid/content/Context;[Ljava/lang/String;III)V", "pageId", "preferStatus", "", "preferCount", "commentCount", "sourceid", "subSourceid", "immersiveSource", "sourceView", QZoneDTLoginReporter.SCHEMA, "launchByScheme", "topicId", "topicName", "launchTopicFeeds", "Lb;", "param", "createFeedSectionFragment", "(Landroid/content/Context;Lb;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;", "launchGuildHomeFragment", "<init>", "()V", "Companion", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedLauncherApiImpl implements IGuildFeedLauncherApi {

    @NotNull
    private static final String TAG = "GuildFeedLauncherApiImpl";
    private final /* synthetic */ FeedEditorLaunchApiImpl $$delegate_0 = new FeedEditorLaunchApiImpl();

    @NotNull
    private static final AtomicBoolean preloadFlag = new AtomicBoolean(false);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroidx/fragment/app/Fragment;", "kotlin.jvm.PlatformType", "fragment", "", "a", "(Landroidx/fragment/app/Fragment;)V"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements b.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Continuation<Fragment> f218008a;

        /* JADX WARN: Multi-variable type inference failed */
        b(Continuation<? super Fragment> continuation) {
            this.f218008a = continuation;
        }

        @Override // dj1.b.a
        public final void a(Fragment fragment) {
            this.f218008a.resumeWith(Result.m476constructorimpl(fragment));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object createSquareFragmentAsync(Bundle bundle, int i3, Continuation<? super Fragment> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        dj1.b.f(bundle, i3, new b(safeContinuation));
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    private final void doOpenGuildFeedSquare(IGProGuildInfo guildInfo, Context context, Bundle extra) {
        int i3;
        if (d12.a.c()) {
            doOpenGuildFeedsHome(guildInfo, extra, context);
            return;
        }
        if (!guildInfo.isMovePostSection()) {
            i3 = 2;
        } else {
            i3 = 3;
        }
        extra.putInt("guild_posts_type", i3);
        GuildFeedSquareHomeFragment.INSTANCE.a(context, extra);
    }

    private final void doOpenGuildFeedsHome(IGProGuildInfo guildInfo, Bundle extra, Context context) {
        JumpGuildParam.JoinInfoParam joinInfoParam;
        JumpGuildParam jumpGuildParam = new JumpGuildParam(guildInfo.getGuildID(), extra.getString("channelId", ""));
        jumpGuildParam.extras.putAll(extra);
        JumpGuildParam.JoinInfoParam loadFrom = JumpGuildParam.JoinInfoParam.loadFrom(extra);
        if (loadFrom != null) {
            jumpGuildParam.setJoinInfoParam(loadFrom);
        }
        GuildAppReportSourceInfo guildAppReportSourceInfo = null;
        if (!jumpGuildParam.getJoinInfoParam().isValid()) {
            Parcelable parcelable = extra.getParcelable(JumpGuildParam.KEY_JOIN_INFO_PARAM);
            if (parcelable instanceof JumpGuildParam.JoinInfoParam) {
                joinInfoParam = (JumpGuildParam.JoinInfoParam) parcelable;
            } else {
                joinInfoParam = null;
            }
            if (joinInfoParam != null) {
                jumpGuildParam.setJoinInfoParam(joinInfoParam);
            }
        }
        Parcelable parcelable2 = extra.getParcelable("GuildAppReportSourceInfo");
        if (parcelable2 instanceof GuildAppReportSourceInfo) {
            guildAppReportSourceInfo = (GuildAppReportSourceInfo) parcelable2;
        }
        if (guildAppReportSourceInfo == null) {
            guildAppReportSourceInfo = new GuildAppReportSourceInfo();
        }
        jumpGuildParam.setReportSourceInfo(guildAppReportSourceInfo);
        d12.a.d(context, jumpGuildParam);
    }

    private final AnimationParams getAnimationParams(View cardView) {
        cardView.getLocationOnScreen(new int[2]);
        return new AnimationParams(r0[0], r0[1], cardView.getWidth(), cardView.getHeight(), cardView.getHeight());
    }

    private final TransitionBean initTransition(jn1.d bean) {
        bean.f410652x = ViewUtils.dip2px((float) bean.f410652x);
        bean.f410653y = ViewUtils.dip2px((float) bean.f410653y);
        bean.showWidth = ViewUtils.dip2px(bean.showWidth);
        bean.showHeight = ViewUtils.dip2px(bean.showHeight);
        TransitionBean enterViewRect = new TransitionBean().setEnterViewRect((int) bean.f410652x, (int) bean.f410653y, bean.showWidth, bean.showHeight);
        int i3 = bean.type;
        if (i3 == 1) {
            enterViewRect.setStImage(bean.coverUrl, bean.width, bean.height);
        } else if (i3 == 0) {
            enterViewRect.setStImage(bean.imageUrl, bean.width, bean.height);
        }
        enterViewRect.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return enterViewRect;
    }

    private final void openGuildFeedSquareAsync(final String guildId, final Context context, final Bundle extra) {
        ((IGPSService) ch.R0(IGPSService.class)).fetchGuildInfoWithSource(guildId, 104, new vh2.v() { // from class: com.tencent.mobileqq.guild.feed.api.impl.k
            @Override // vh2.v
            public final void a(int i3, String str, IGProGuildInfo iGProGuildInfo) {
                GuildFeedLauncherApiImpl.openGuildFeedSquareAsync$lambda$13(GuildFeedLauncherApiImpl.this, context, extra, guildId, i3, str, iGProGuildInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void openGuildFeedSquareAsync$lambda$13(GuildFeedLauncherApiImpl this$0, Context context, Bundle extra, String guildId, int i3, String str, IGProGuildInfo iGProGuildInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(extra, "$extra");
        Intrinsics.checkNotNullParameter(guildId, "$guildId");
        if (i3 == 0 && iGProGuildInfo != null) {
            this$0.doOpenGuildFeedSquare(iGProGuildInfo, context, extra);
            return;
        }
        Logger logger = Logger.f235387a;
        Logger.b bVar = new Logger.b();
        String str2 = guildId + " fetchGuildInfoWithSource error result:" + i3 + " errMsg:" + str;
        if (str2 instanceof String) {
            bVar.a().add(str2);
        }
        Iterator<T> it = bVar.a().iterator();
        while (it.hasNext()) {
            Logger.f235387a.d().e(TAG, 1, (String) it.next(), null);
        }
    }

    private final void tryPreloadFeedDetail(final GuildFeedDetailPreloadParams preloadParams) {
        if (!preloadParams.isValid()) {
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.api.impl.l
            @Override // java.lang.Runnable
            public final void run() {
                GuildFeedLauncherApiImpl.tryPreloadFeedDetail$lambda$16(GuildFeedDetailPreloadParams.this);
            }
        }, 128, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void tryPreloadFeedDetail$lambda$16(GuildFeedDetailPreloadParams preloadParams) {
        ArrayList arrayListOf;
        Intrinsics.checkNotNullParameter(preloadParams, "$preloadParams");
        GuildFeedDetailDataCacheManager y16 = GuildFeedDetailDataCacheManager.y();
        if (y16.x(preloadParams.getFeedId()) <= 0 && !y16.E(preloadParams.getFeedId(), preloadParams.getCreateTime())) {
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(preloadParams);
            y16.t(arrayListOf, null);
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedLauncherApi
    @Nullable
    public Object createFeedSectionFragment(@NotNull Context context, @NotNull FeedSectionTabLaunchParam feedSectionTabLaunchParam, @NotNull Continuation<? super Fragment> continuation) {
        com.tencent.mobileqq.guild.feed.feedsquare.part.remake.e eVar = com.tencent.mobileqq.guild.feed.feedsquare.part.remake.e.f218972a;
        Bundle a16 = eVar.a(feedSectionTabLaunchParam.getGuildId(), feedSectionTabLaunchParam.getChannelId(), 1);
        eVar.b(a16, feedSectionTabLaunchParam.getSectionName(), null);
        eVar.c(a16, 0, feedSectionTabLaunchParam.getJoinInfoParam());
        FeedSectionSecondaryListFragment feedSectionSecondaryListFragment = new FeedSectionSecondaryListFragment();
        feedSectionSecondaryListFragment.setArguments(a16);
        return feedSectionSecondaryListFragment;
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedLauncherApi
    @NotNull
    public Fragment createFeedTopFragment(@Nullable Bundle arguments) {
        return GuildFeedSquareHeaderFragment.INSTANCE.a(arguments);
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedLauncherApi
    @Nullable
    public Object createNewSquareFragment(@NotNull Context context, @NotNull String str, @NotNull Bundle bundle, @NotNull Continuation<? super Fragment> continuation) {
        Bundle bundle2 = new Bundle();
        bundle2.putString("guild_id", str);
        bundle2.putAll(bundle);
        return createSquareFragmentAsync(bundle2, 4, continuation);
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedLauncherApi
    @NotNull
    public Object getFeedNoticeCenterPanelController(@Nullable Object mainViewContext) {
        Intrinsics.checkNotNull(mainViewContext, "null cannot be cast to non-null type com.tencent.mobileqq.guild.mainframe.GuildMainViewContext");
        return new uk1.a((com.tencent.mobileqq.guild.mainframe.i) mainViewContext);
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedLauncherApi
    public boolean isGuildFeedSchemeAction(@Nullable String action) {
        return com.tencent.mobileqq.guild.feed.launcher.f.b(action);
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedLauncherApi
    public void launchByScheme(@NotNull String schema) {
        Intrinsics.checkNotNullParameter(schema, "schema");
        GuildFeedLauncher.t(schema);
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedLauncherApi
    public void launchGuildDebugPage(@Nullable Context context) {
        GuildFeedLauncher.u(context);
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedLauncherApi
    public void launchGuildEmojiTransFragment() {
        Intent intent = new Intent();
        intent.addFlags(268435456);
        QPublicTransFragmentActivity.start(BaseApplication.getContext(), intent, GuildEmojiTransFragment.class);
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedLauncherApi
    public void launchGuildFeedByScheme(@Nullable Context context, @Nullable String action, @Nullable HashMap<String, Serializable> attrs) {
        GuildFeedSchemeBean guildFeedSchemeBean = new GuildFeedSchemeBean();
        guildFeedSchemeBean.mAction = action;
        guildFeedSchemeBean.setAttrs(attrs);
        com.tencent.mobileqq.guild.feed.launcher.f.a(context, guildFeedSchemeBean);
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedLauncherApi
    public void launchGuildFeedDetailActivity(@Nullable Context context, @NotNull Bundle bundle, boolean needOpenNative) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        com.tencent.mobileqq.guild.util.ab.b("GuildFeedLauncherApiImpl#launchGuildFeedDetailActivity");
        com.tencent.mobileqq.guild.performance.report.w wVar = com.tencent.mobileqq.guild.performance.report.w.f231064i;
        wVar.l("event_launch_detail_page", "GuildFeedLauncherApiImpl#launchGuildFeedDetailActivity", System.currentTimeMillis());
        wVar.n(QIPCServerHelper.getInstance().isProcessRunning("com.tencent.mobileqq:tool"));
        HashMap<String, Serializable> hashMap = new HashMap<>();
        String string = bundle.getString(AppConstants.Key.GUILD_EXTAR_DETAIL_CONTENT_JUMP_URL, "");
        Intrinsics.checkNotNullExpressionValue(string, "bundle.getString(GUILD_E\u2026AIL_CONTENT_JUMP_URL, \"\")");
        hashMap.put(AppConstants.Key.GUILD_EXTAR_DETAIL_CONTENT_JUMP_URL, string);
        hashMap.put(JumpGuildParam.EXTRA_KEY_IS_FROM_STANDALONE_PAGE, Boolean.valueOf(bundle.getBoolean(JumpGuildParam.EXTRA_KEY_IS_FROM_STANDALONE_PAGE, false)));
        hashMap.put("jumpGuildFromLoadingPage", Boolean.valueOf(bundle.getBoolean("jumpGuildFromLoadingPage", false)));
        GuildFeedDetailInitBean guildFeedDetailInitBean = new GuildFeedDetailInitBean();
        guildFeedDetailInitBean.setGuildId(bundle.getString("guildId", ""));
        guildFeedDetailInitBean.setChannelId(bundle.getString("channelId", ""));
        guildFeedDetailInitBean.setPosterTinyId(bundle.getString("posterTinyId", ""));
        guildFeedDetailInitBean.setFeedId(bundle.getString("feedId", ""));
        guildFeedDetailInitBean.setShareSource(bundle.getInt("shareSource", 0));
        guildFeedDetailInitBean.setCreateTime(bundle.getLong(WadlProxyConsts.CREATE_TIME, 0L));
        guildFeedDetailInitBean.setIsMember(!ch.j0(guildFeedDetailInitBean.getGuildId()));
        guildFeedDetailInitBean.setUserType(((IGuildFeedMiscApi) QRoute.api(IGuildFeedMiscApi.class)).getCurrentUserType(guildFeedDetailInitBean.getGuildId()));
        guildFeedDetailInitBean.setVisitorTinyId(bundle.getString("visitorTinyId", ""));
        guildFeedDetailInitBean.setInviteCode(bundle.getString("inviteCode", ""));
        guildFeedDetailInitBean.setJoinInfoParam((JumpGuildParam.JoinInfoParam) bundle.getParcelable("joinInfoParam"));
        guildFeedDetailInitBean.setBusinessType(bundle.getInt("businessType", 6));
        guildFeedDetailInitBean.setTroopUin(bundle.getString("troopUin", ""));
        guildFeedDetailInitBean.setTroopRole(bundle.getInt("troopRole", 0));
        if (guildFeedDetailInitBean.getBusinessType() == 7) {
            guildFeedDetailInitBean.setCommentId(bundle.getString(WSAutoShowCommentParams.KEY_COMMENT_ID, ""));
            guildFeedDetailInitBean.setReplyId(bundle.getString(WSAutoShowCommentParams.KEY_REPLY_ID, ""));
            guildFeedDetailInitBean.setPosition(bundle.getInt("position", 0));
        }
        Serializable serializable = bundle.getSerializable("discoverSearchDtParams");
        if (serializable != null ? serializable instanceof HashMap : true) {
            guildFeedDetailInitBean.setDiscoverSearchDtParams((HashMap) serializable);
        } else {
            guildFeedDetailInitBean.setDiscoverSearchDtParams(null);
        }
        guildFeedDetailInitBean.setBannerId(bundle.getString("bannerId", "0"));
        guildFeedDetailInitBean.setJumpExtraInfo((GuildAppReportSourceInfo) bundle.getParcelable("jumpExtraInfo"));
        guildFeedDetailInitBean.setFeedReportSourceInfo((GuildFeedReportSourceInfo) bundle.getParcelable("feedReportInfo"));
        guildFeedDetailInitBean.setAttrs(hashMap);
        guildFeedDetailInitBean.setImmersiveSource(bundle.getInt("immersive_source", 6));
        GuildFeedLauncher.x(context, guildFeedDetailInitBean, Boolean.valueOf(needOpenNative));
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedLauncherApi
    public void launchGuildFeedGalleryActivity(@NotNull Context context, @NotNull String params) {
        String optString;
        List<jn1.d> p16;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(params, "params");
        try {
            JSONObject jSONObject = new JSONObject(params);
            String optString2 = jSONObject.optString("feedId");
            if (optString2 == null || (optString = jSONObject.optString("posterId")) == null) {
                return;
            }
            String optString3 = jSONObject.optString("guildId", "");
            String optString4 = jSONObject.optString("channelId", "");
            int optInt = jSONObject.optInt("mediaIndex");
            JSONArray optJSONArray = jSONObject.optJSONArray("mediaList");
            if (optJSONArray == null || (p16 = qk1.d.p(optJSONArray.toString())) == null) {
                return;
            }
            if (optInt >= 0 && optInt < p16.size()) {
                GuildFeedGalleryInitBean guildFeedGalleryInitBean = new GuildFeedGalleryInitBean();
                guildFeedGalleryInitBean.setRichMediaDataList(am.c(p16));
                guildFeedGalleryInitBean.setFeedId(optString2);
                guildFeedGalleryInitBean.setPosterId(optString);
                guildFeedGalleryInitBean.setGuildId(optString3);
                guildFeedGalleryInitBean.setChannelId(optString4);
                guildFeedGalleryInitBean.setEnterPos(optInt);
                GuildFeedLauncher.y(context, guildFeedGalleryInitBean);
                return;
            }
            QLog.e(TAG, 1, "launchGuildFeedGalleryActivity invalid mediaIndex");
        } catch (JSONException e16) {
            QLog.e(TAG, 1, "launchGuildFeedGalleryActivity parse json e:", e16);
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedLauncherApi
    public void launchGuildFeedH5Publish(@NotNull Context context, @Nullable String guildId, @Nullable String channelId, @Nullable String channelName, int businessType, int redirectAction, @Nullable String jsonFeedContent, @Nullable Map<String, ? extends Serializable> attrs) {
        Object obj;
        Intrinsics.checkNotNullParameter(context, "context");
        GuildFeedPublishThirdContentInitBean guildFeedPublishThirdContentInitBean = new GuildFeedPublishThirdContentInitBean(jsonFeedContent);
        List list = null;
        if (attrs != null) {
            obj = (Serializable) attrs.get("local_media_info_list");
        } else {
            obj = null;
        }
        if (obj instanceof List) {
            list = (List) obj;
        }
        if (list != null) {
            guildFeedPublishThirdContentInitBean.getMediaInfo().addAll(list);
        }
        guildFeedPublishThirdContentInitBean.setGuildId(guildId);
        guildFeedPublishThirdContentInitBean.setChannelId(channelId);
        guildFeedPublishThirdContentInitBean.setChannelName(channelName);
        guildFeedPublishThirdContentInitBean.setBusinessType(businessType);
        if (attrs != null) {
            guildFeedPublishThirdContentInitBean.getAttrs().putAll(attrs);
        }
        guildFeedPublishThirdContentInitBean.setTinyId(ax.u());
        guildFeedPublishThirdContentInitBean.setNickName(((IGPSService) ((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).runtimeService(IGPSService.class)).getGuildUserDisplayName(guildId, guildFeedPublishThirdContentInitBean.getTinyId()));
        HashMap<String, Serializable> attrs2 = guildFeedPublishThirdContentInitBean.getAttrs();
        Intrinsics.checkNotNullExpressionValue(attrs2, "this.attrs");
        attrs2.put("is_part_not_selected", Integer.valueOf(TextUtils.isEmpty(channelName) ? 1 : 0));
        HashMap<String, Serializable> attrs3 = guildFeedPublishThirdContentInitBean.getAttrs();
        Intrinsics.checkNotNullExpressionValue(attrs3, "this.attrs");
        attrs3.put("launch_redirect_action", Integer.valueOf(redirectAction));
        GuildFeedLauncher.D(context, guildFeedPublishThirdContentInitBean);
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedLauncherApi
    public void launchGuildFeedNoticeFragment(@NotNull JumpGuildNoticeMsg params, int from) {
        Intrinsics.checkNotNullParameter(params, "params");
        QLog.i(TAG, 1, "launchGuildFeedNoticeFragment params:" + params);
        GuildFeedNoticeFragment.Gh(params.getGuildId(), params.getChannelId(), params.getFeedId(), params.getJumpType(), from);
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedLauncherApi
    public void launchGuildFeedNoticeFragmentInPersonalDimension(@NotNull String jumpId, int type, int from) {
        Intrinsics.checkNotNullParameter(jumpId, "jumpId");
        GuildFeedNoticeFragment.Hh(jumpId, type, from);
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedLauncherApi
    public void launchGuildFeedPostsLoadFragment(@NotNull Context context, @NotNull Bundle extra) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(extra, "extra");
        GuildFeedMyFeedsFragmentV2.INSTANCE.a(context, extra);
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedLauncherApi
    public void launchGuildFeedPreloadWebView() {
        long j3;
        if (preloadFlag.compareAndSet(false, true)) {
            j3 = 1000;
        } else {
            j3 = 0;
        }
        QLog.i(TAG, 1, "launchGuildFeedPreloadWebView preloadWebBundleWhileOnIdle== delay=" + j3);
        GuildWebBundleManager.Companion companion = GuildWebBundleManager.INSTANCE;
        companion.a().w();
        companion.a().D(j3, "");
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedLauncherApi
    public void launchGuildFeedPublish(@NotNull Context context, @NotNull String guildId, @NotNull String channelId, @NotNull String troopUin) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        GuildFeedTroopInitBean guildFeedTroopInitBean = new GuildFeedTroopInitBean();
        guildFeedTroopInitBean.setGuildId(guildId);
        guildFeedTroopInitBean.setChannelId(channelId);
        guildFeedTroopInitBean.setTroopUin(troopUin);
        guildFeedTroopInitBean.setBusinessType(7);
        guildFeedTroopInitBean.setTroopRole(((ITroopGuildApi) QRoute.api(ITroopGuildApi.class)).getTroopGuildRole(troopUin));
        em1.a.c(context, guildFeedTroopInitBean);
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedLauncherApi
    public void launchGuildFeedSquareFragment(@NotNull Context context, @NotNull Bundle extra) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(extra, "extra");
        String guildId = extra.getString("guild_id", "");
        IGProGuildInfo L = ch.L(guildId);
        if (L != null) {
            doOpenGuildFeedSquare(L, context, extra);
        } else {
            Intrinsics.checkNotNullExpressionValue(guildId, "guildId");
            openGuildFeedSquareAsync(guildId, context, extra);
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedLauncherApi
    public void launchGuildHomeFragment(@NotNull Context context, @NotNull JumpGuildParam param) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(param, "param");
        GuildHomeV2Fragment.INSTANCE.c(context, param);
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedLauncherApi
    public void launchGuildVisitorFeedNoticeFragment() {
        GuildVisitorFeedNoticeFragment.INSTANCE.a();
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedLauncherApi
    public void launchTopicFeeds(@NotNull Context context, long topicId, @Nullable String topicName, @NotNull String traceId) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(traceId, "traceId");
        com.tencent.mobileqq.guild.feed.launcher.parser.f.R(com.tencent.mobileqq.guild.feed.launcher.parser.f.f220101a, context, topicId, topicName, null, null, 24, null);
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedLauncherApi
    public void launchTroopFeedNoticeActivity(@NotNull Context context, @NotNull String guildId, @NotNull String channelId, @NotNull String troopUin, int from) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        GuildFeedLauncher.J(context, guildId, channelId, troopUin, from);
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedLauncherApi
    @NotNull
    public Consumer<FeedEditorCheckItemResult> makeFallbackCheckItemResultConsumer(@NotNull String guildId, @NotNull Supplier<Activity> activitySupplier) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(activitySupplier, "activitySupplier");
        return this.$$delegate_0.s(guildId, activitySupplier);
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedLauncherApi
    @NotNull
    public Job performCheckItemOfFeedEditorStartup(int traceId, @NotNull CoroutineScope scope, @Nullable com.tencent.mobileqq.guild.data.s contact, @NotNull FeedEditorLaunchOptionModel option, @Nullable JSONObject richContentJson, @NotNull com.tencent.mobileqq.guild.feed.api.c checkItemListener) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(option, "option");
        Intrinsics.checkNotNullParameter(checkItemListener, "checkItemListener");
        return this.$$delegate_0.y(traceId, scope, contact, option, richContentJson, checkItemListener);
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedLauncherApi
    @NotNull
    public Job performCheckItemsToStartFeedEditorToPostNewOne(@NotNull Context context, @Nullable com.tencent.mobileqq.guild.data.s contact, @NotNull FeedEditorLaunchOptionModel option, @NotNull FeedEditorLaunchSourceModel source, @Nullable JSONObject richContentJson, @NotNull com.tencent.mobileqq.guild.feed.api.c checkItemListener, @Nullable com.tencent.mobileqq.guild.feed.api.d startProcedureAware) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(option, "option");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(checkItemListener, "checkItemListener");
        return this.$$delegate_0.z(context, contact, option, source, richContentJson, checkItemListener, startProcedureAware);
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedLauncherApi
    public void launchGuildFeedPostsLoadFragment(@NotNull Context context, @NotNull String guildId, @NotNull String userId, @NotNull String from, @NotNull Bundle extra) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(extra, "extra");
        GuildFeedMyFeedsFragmentV2.INSTANCE.b(context, guildId, userId, from, extra);
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedLauncherApi
    public void launchGuildFeedPublish(@NotNull Context context, @NotNull String guildId, @NotNull String channelId, int businessType, int redirectAction, @NotNull GuildFeedReportSourceInfo reportMap) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(reportMap, "reportMap");
        em1.a aVar = em1.a.f396585a;
        String str = com.tencent.mobileqq.guild.feed.b.f218115a;
        GuildFeedBaseInitBean guildFeedBaseInitBean = new GuildFeedBaseInitBean();
        guildFeedBaseInitBean.setGuildId(guildId);
        guildFeedBaseInitBean.setChannelId(channelId);
        guildFeedBaseInitBean.setBusinessType(businessType);
        guildFeedBaseInitBean.setFeedReportSourceInfo(reportMap);
        Unit unit = Unit.INSTANCE;
        Bundle bundleOf = BundleKt.bundleOf(TuplesKt.to(str, guildFeedBaseInitBean), TuplesKt.to("launch_redirect_action", Integer.valueOf(redirectAction)));
        FeedPublishEditorLaunchCompat feedPublishEditorLaunchCompat = FeedPublishEditorLaunchCompat.f222113a;
        aVar.h(context, 1, bundleOf, feedPublishEditorLaunchCompat.e(feedPublishEditorLaunchCompat.f("publish new feed"), feedPublishEditorLaunchCompat.c()));
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedLauncherApi
    public void launchGuildFeedGalleryActivity(@NotNull Context context, @NotNull String[] urls, int position, int x16, int y16) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(urls, "urls");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (String str : urls) {
            GuildFeedRichMediaData guildFeedRichMediaData = new GuildFeedRichMediaData();
            jn1.d dVar = new jn1.d();
            dVar.coverUrl = str;
            dVar.imageUrl = str;
            dVar.type = 0;
            dVar.showHeight = 0;
            dVar.showWidth = 0;
            dVar.fileId = str;
            dVar.f410652x = x16;
            dVar.f410653y = y16;
            arrayList2.add(dVar);
            guildFeedRichMediaData.setType(0);
            GProStImage gProStImage = new GProStImage();
            gProStImage.picId = dVar.fileId;
            String str2 = dVar.imageUrl;
            gProStImage.picUrl = str2;
            gProStImage.width = dVar.width;
            gProStImage.height = dVar.height;
            gProStImage.isOrig = true;
            gProStImage.isGif = false;
            gProStImage.origSize = 0;
            Intrinsics.checkNotNullExpressionValue(str2, "bean.imageUrl");
            gProStImage.vecImageUrlList = bm.p(str2);
            guildFeedRichMediaData.setImage(gProStImage);
            arrayList.add(guildFeedRichMediaData);
        }
        GuildFeedGalleryInitBean guildFeedGalleryInitBean = new GuildFeedGalleryInitBean();
        guildFeedGalleryInitBean.setRichMediaDataList(arrayList);
        guildFeedGalleryInitBean.setEnterPos(position);
        guildFeedGalleryInitBean.setFromPage(3);
        if (position >= 0 && position < arrayList2.size()) {
            guildFeedGalleryInitBean.setTransitionBean(initTransition((jn1.d) arrayList2.get(position)));
        }
        if (guildFeedGalleryInitBean.getTransitionBean() != null) {
            guildFeedGalleryInitBean.getTransitionBean().setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
        GuildFeedLauncher.y(context, guildFeedGalleryInitBean);
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedLauncherApi
    public void launchGuildFeedDetailActivity(@NotNull View v3, @NotNull IGProContentRecommendFeed feed, @Nullable String traceId, @NotNull String sourceId, @NotNull String subSourceId, int source) {
        String str;
        Map mutableMapOf;
        Intrinsics.checkNotNullParameter(v3, "v");
        Intrinsics.checkNotNullParameter(feed, "feed");
        Intrinsics.checkNotNullParameter(sourceId, "sourceId");
        Intrinsics.checkNotNullParameter(subSourceId, "subSourceId");
        IGProFeedGuildInfo guildInfo = feed.getGuildInfo();
        if (guildInfo == null) {
            return;
        }
        IGProPoster poster = feed.getPoster();
        if (poster == null || (str = Long.valueOf(poster.getTinyId()).toString()) == null) {
            str = "";
        }
        long guildId = guildInfo.getGuildId();
        long channelId = guildInfo.getChannelId();
        String idd = feed.getIdd();
        Intrinsics.checkNotNullExpressionValue(idd, "feed.idd");
        tryPreloadFeedDetail(new GuildFeedDetailPreloadParams(guildId, channelId, idd, str, feed.getCreateTime(), 0L));
        Context context = v3.getContext();
        GuildFeedDetailInitBean guildFeedDetailInitBean = new GuildFeedDetailInitBean();
        guildFeedDetailInitBean.setGuildId(String.valueOf(guildInfo.getGuildId()));
        guildFeedDetailInitBean.setChannelId(String.valueOf(guildInfo.getChannelId()));
        guildFeedDetailInitBean.setPosterTinyId(str);
        guildFeedDetailInitBean.setFeedId(feed.getIdd());
        guildFeedDetailInitBean.setCreateTime(feed.getCreateTime());
        guildFeedDetailInitBean.setIsMember(!ch.j0(guildFeedDetailInitBean.getGuildId()));
        guildFeedDetailInitBean.setUserType(((IGuildFeedMiscApi) QRoute.api(IGuildFeedMiscApi.class)).getCurrentUserType(guildFeedDetailInitBean.getGuildId()));
        guildFeedDetailInitBean.setVisitorTinyId(ch.g());
        guildFeedDetailInitBean.setJoinInfoParam(new JumpGuildParam.JoinInfoParam(String.valueOf(guildInfo.getChannelId()), guildInfo.getJoinGuildSig(), sourceId, subSourceId));
        guildFeedDetailInitBean.setImmersiveSource(ci1.a.e(source, sourceId));
        guildFeedDetailInitBean.setShareSource(ci1.a.f(source));
        guildFeedDetailInitBean.setBusinessType(ci1.a.b(source));
        if (traceId != null) {
            HashMap<String, Serializable> attrs = guildFeedDetailInitBean.getAttrs();
            Intrinsics.checkNotNullExpressionValue(attrs, "attrs");
            attrs.put(JumpGuildParam.EXTRA_KEY_TRACE_ID, traceId);
            mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("sp_trace_id", traceId));
            Intrinsics.checkNotNull(mutableMapOf, "null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.String>");
            guildFeedDetailInitBean.setDiscoverSearchDtParams((HashMap) mutableMapOf);
        }
        guildFeedDetailInitBean.setAnimationParams(getAnimationParams(v3));
        GuildFeedLauncher.w(context, guildFeedDetailInitBean);
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedLauncherApi
    public void launchGuildFeedGalleryActivity(@NotNull Context context, @NotNull IGProContentRecommendFeed feed, @NotNull String pageId, int businessType, int preferStatus, long preferCount, long commentCount, @Nullable String traceId, @NotNull String sourceid, @NotNull String subSourceid, int immersiveSource, @Nullable View sourceView) {
        Object first;
        GuildFeedRichMediaData i3;
        IGProImage cover;
        String url;
        ArrayList arrayListOf;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(feed, "feed");
        Intrinsics.checkNotNullParameter(pageId, "pageId");
        Intrinsics.checkNotNullParameter(sourceid, "sourceid");
        Intrinsics.checkNotNullParameter(subSourceid, "subSourceid");
        ArrayList<IGProVideo> videos = feed.getVideos();
        if ((videos == null || videos.isEmpty()) && feed.getImage() == null) {
            return;
        }
        ArrayList<IGProVideo> videos2 = feed.getVideos();
        if (videos2 == null || videos2.isEmpty()) {
            String url2 = feed.getImage().getUrl();
            if (url2 != null) {
                com.tencent.mobileqq.guild.discoveryv2.util.d.g(com.tencent.mobileqq.guild.discoveryv2.util.d.f217794a, url2, 0, 0, 6, null);
            }
            i3 = com.tencent.mobileqq.guild.feed.util.h.d(feed);
        } else {
            ArrayList<IGProVideo> videos3 = feed.getVideos();
            Intrinsics.checkNotNullExpressionValue(videos3, "feed.videos");
            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) videos3);
            IGProVideo iGProVideo = (IGProVideo) first;
            if (iGProVideo != null && (cover = iGProVideo.getCover()) != null && (url = cover.getUrl()) != null) {
                com.tencent.mobileqq.guild.discoveryv2.util.d.g(com.tencent.mobileqq.guild.discoveryv2.util.d.f217794a, url, 0, 0, 6, null);
            }
            i3 = com.tencent.mobileqq.guild.feed.util.h.i(feed);
        }
        i3.setPageId(pageId);
        GuildFeedGalleryInitBean guildFeedGalleryInitBean = new GuildFeedGalleryInitBean();
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(i3);
        guildFeedGalleryInitBean.setRichMediaDataList(arrayListOf);
        guildFeedGalleryInitBean.setEnterPos(0);
        IGProFeedGuildInfo guildInfo = feed.getGuildInfo();
        guildFeedGalleryInitBean.setGuildId(guildInfo != null ? Long.valueOf(guildInfo.getGuildId()).toString() : null);
        IGProFeedGuildInfo guildInfo2 = feed.getGuildInfo();
        guildFeedGalleryInitBean.setChannelId(guildInfo2 != null ? Long.valueOf(guildInfo2.getChannelId()).toString() : null);
        guildFeedGalleryInitBean.setPosterAvatar(feed.getPoster().getAvatar());
        guildFeedGalleryInitBean.setPosterNick(feed.getPoster().getNick());
        guildFeedGalleryInitBean.setPosterId(String.valueOf(feed.getPoster().getTinyId()));
        guildFeedGalleryInitBean.setFeedId(feed.getIdd());
        guildFeedGalleryInitBean.setBusinessType(businessType);
        guildFeedGalleryInitBean.setFeed(com.tencent.mobileqq.guild.feed.util.h.g(feed, preferStatus, preferCount));
        guildFeedGalleryInitBean.setFromPage(2);
        guildFeedGalleryInitBean.setImmersiveSource(immersiveSource);
        guildFeedGalleryInitBean.setTraceId(traceId);
        HashMap hashMap = new HashMap();
        hashMap.put("sgrp_stream_pgin_source_name", pageId);
        guildFeedGalleryInitBean.getJumpExtraInfo().addReportItems(hashMap);
        String guildId = guildFeedGalleryInitBean.getGuildId();
        IGProFeedGuildInfo guildInfo3 = feed.getGuildInfo();
        guildFeedGalleryInitBean.setJoinInfoParam(new JumpGuildParam.JoinInfoParam(guildId, guildInfo3 != null ? guildInfo3.getJoinGuildSig() : null, sourceid, subSourceid));
        if (guildFeedGalleryInitBean.getJoinInfoParam().isValid() && guildFeedGalleryInitBean.getJoinInfoParam().getMainSource().equals("discover")) {
            guildFeedGalleryInitBean.getJoinInfoParam().setSubSource("discover_immersive_feed");
        }
        GuildFeedLauncher.z(context, guildFeedGalleryInitBean, sourceView);
    }
}
