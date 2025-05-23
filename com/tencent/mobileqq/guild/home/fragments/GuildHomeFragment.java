package com.tencent.mobileqq.guild.home.fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.core.os.BundleKt;
import androidx.core.view.KeyEventDispatcher;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import bp1.s;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheLunarData;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.part.Part;
import com.tencent.guild.api.ILocalFocusService;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.guild.api.IGuildTempApi;
import com.tencent.mobileqq.guild.base.extension.m;
import com.tencent.mobileqq.guild.base.repository.h;
import com.tencent.mobileqq.guild.constant.GuildFacadeType;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedLauncherApi;
import com.tencent.mobileqq.guild.heartbeatreport.impl.FacadeFragmentOnlineReportHelper;
import com.tencent.mobileqq.guild.home.fragments.GuildHomeFragment;
import com.tencent.mobileqq.guild.home.fragments.eventbus.GuildHomeDialogEvent;
import com.tencent.mobileqq.guild.home.fragments.eventbus.GuildHomeSwitchTabEvent;
import com.tencent.mobileqq.guild.home.helper.GuildHomeTipHelper;
import com.tencent.mobileqq.guild.home.parts.GuildFrameDragCompatibilityPart;
import com.tencent.mobileqq.guild.home.parts.GuildHomeBackgroundPart;
import com.tencent.mobileqq.guild.home.parts.GuildHomeBanPart;
import com.tencent.mobileqq.guild.home.parts.GuildHomeFloatTitlePart;
import com.tencent.mobileqq.guild.home.parts.GuildHomeHeaderPart;
import com.tencent.mobileqq.guild.home.parts.GuildHomeInvisibleForVisitorPart;
import com.tencent.mobileqq.guild.home.parts.GuildHomeLoadingPart;
import com.tencent.mobileqq.guild.home.parts.GuildHomeRefreshLoadingPart;
import com.tencent.mobileqq.guild.home.parts.GuildHomeSubFragmentPart;
import com.tencent.mobileqq.guild.home.parts.GuildHomeVisitorJoinPart;
import com.tencent.mobileqq.guild.home.parts.GuildOnIdlePreloadPart;
import com.tencent.mobileqq.guild.home.subhome.GuildHomeSubFragmentBehavior;
import com.tencent.mobileqq.guild.home.subhome.f;
import com.tencent.mobileqq.guild.home.utils.GuildFeedsHomeSubChannelPollingManager;
import com.tencent.mobileqq.guild.home.viewmodels.GuildHomeHeaderRepository;
import com.tencent.mobileqq.guild.home.viewmodels.GuildHomeViewModel;
import com.tencent.mobileqq.guild.home.viewmodels.header.GuildHomeCoverColors;
import com.tencent.mobileqq.guild.home.views.BetterCoordinatorLayout;
import com.tencent.mobileqq.guild.home.views.header.handler.GuildHomeHeaderTitleJumpHandler;
import com.tencent.mobileqq.guild.jump.GuildJumpUtil;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.jump.model.extras.JumpGuildNoticeMsg;
import com.tencent.mobileqq.guild.mainframe.manager.GuildOpenRecordManager;
import com.tencent.mobileqq.guild.mainframe.startpanel.rightpart.facade.FacadeArgsData;
import com.tencent.mobileqq.guild.mainframe.util.GuildMainFrameUtils;
import com.tencent.mobileqq.guild.media.core.viewpool.ViewPoolEngine;
import com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi;
import com.tencent.mobileqq.guild.report.DummyPerformanceReportTask;
import com.tencent.mobileqq.guild.report.IPerformanceReportTask;
import com.tencent.mobileqq.guild.rolegroup.model.data.RoleGroupListModel;
import com.tencent.mobileqq.guild.rolegroup.model.repositories.FetchRoleGroupParam;
import com.tencent.mobileqq.guild.rolegroup.model.repositories.r;
import com.tencent.mobileqq.guild.util.GuildNoticeKtKt;
import com.tencent.mobileqq.guild.util.GuildSplitViewUtils;
import com.tencent.mobileqq.guild.util.GuildSubscribePollingManager;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.TraceUtils;
import com.tencent.mobileqq.guild.util.at;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.cy;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pad.g;
import com.tencent.mobileqq.pad.l;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.u;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.richframework.argus.node.ArgusTag;
import cr0.GuildActiveInfo;
import ef1.c;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SpreadBuilder;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.time.Duration;
import kotlin.time.TimeSource;
import kotlin.time.TimedValue;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.IAccountCallback;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vh1.k;
import wo1.ImageColorInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00d8\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b*\u0002\u0019\u001c\b\u0007\u0018\u0000 \u00cb\u00012\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u00042\u00020\u00052\u00020\u0006:\u0002\u00cc\u0001B\t\u00a2\u0006\u0006\b\u00c9\u0001\u0010\u00ca\u0001J\u0015\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\b\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u0010\u001a\u00020\u000bH\u0002J\b\u0010\u0011\u001a\u00020\u000bH\u0002J\u0010\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\b\u0010\u0015\u001a\u00020\u000bH\u0002J\b\u0010\u0016\u001a\u00020\u000bH\u0002J\b\u0010\u0018\u001a\u00020\u0017H\u0002J\u000f\u0010\u001a\u001a\u00020\u0019H\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001d\u001a\u00020\u001cH\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010 \u001a\u00020\u001fH\u0002J\u0010\u0010#\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020!H\u0002J\u0010\u0010%\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020$H\u0002J\u000e\u0010'\u001a\b\u0012\u0004\u0012\u00020\b0&H\u0016J\b\u0010)\u001a\u00020(H\u0014J\b\u0010*\u001a\u00020\u0017H\u0016J\b\u0010+\u001a\u00020\u0017H\u0016J\b\u0010,\u001a\u00020\u0017H\u0016J\u0012\u0010/\u001a\u00020\u000b2\b\u0010.\u001a\u0004\u0018\u00010-H\u0016J\u0012\u00102\u001a\u00020\u000b2\b\u00101\u001a\u0004\u0018\u000100H\u0016J$\u00107\u001a\u00020\r2\u0006\u00104\u001a\u0002032\b\u00106\u001a\u0004\u0018\u0001052\b\u00101\u001a\u0004\u0018\u000100H\u0016J\u001a\u00108\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\b\u00101\u001a\u0004\u0018\u000100H\u0016J\b\u00109\u001a\u00020\u000bH\u0016J\u001a\u0010;\u001a\u00020\u000b2\u0006\u0010:\u001a\u00020\r2\b\u00101\u001a\u0004\u0018\u000100H\u0014J\u001a\u0010<\u001a\u00020\u000b2\u0006\u0010:\u001a\u00020\r2\b\u00101\u001a\u0004\u0018\u000100H\u0014J\b\u0010=\u001a\u00020\u000bH\u0016J\b\u0010>\u001a\u00020\u000bH\u0016J\b\u0010?\u001a\u00020\u000bH\u0016J\b\u0010@\u001a\u00020\u000bH\u0016J\b\u0010A\u001a\u00020\u0017H\u0016J\u0012\u0010B\u001a\u00020\u000b2\b\u0010\"\u001a\u0004\u0018\u00010\u0003H\u0016J$\u0010F\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030D0Cj\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030D`EH\u0016J\b\u0010G\u001a\u00020\u0017H\u0016J\b\u0010H\u001a\u00020\u000bH\u0016J\u0010\u0010J\u001a\u00020\u000b2\u0006\u0010I\u001a\u00020(H\u0016J\u0012\u0010M\u001a\u00020\u000b2\b\u0010L\u001a\u0004\u0018\u00010KH\u0016J\u0012\u0010N\u001a\u00020\u000b2\b\u0010L\u001a\u0004\u0018\u00010KH\u0016J\u0012\u0010Q\u001a\u00020\u000b2\b\u0010P\u001a\u0004\u0018\u00010OH\u0016J\n\u0010S\u001a\u0004\u0018\u00010RH\u0016J\u0010\u0010U\u001a\u00020\u00172\u0006\u0010T\u001a\u00020\u0017H\u0016R\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bV\u0010WR\u001b\u0010]\u001a\u00020X8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bY\u0010Z\u001a\u0004\b[\u0010\\R\u0018\u0010`\u001a\u0004\u0018\u00010X8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b^\u0010_R\u0018\u0010b\u001a\u0004\u0018\u00010X8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\ba\u0010_R\u001b\u0010g\u001a\u00020c8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bd\u0010Z\u001a\u0004\be\u0010fR\u001b\u0010l\u001a\u00020h8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bi\u0010Z\u001a\u0004\bj\u0010kR\u001b\u0010q\u001a\u00020m8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bn\u0010Z\u001a\u0004\bo\u0010pR\u001b\u0010v\u001a\u00020r8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bs\u0010Z\u001a\u0004\bt\u0010uR\u001b\u0010{\u001a\u00020w8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bx\u0010Z\u001a\u0004\by\u0010zR\u001c\u0010\u0080\u0001\u001a\u00020|8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b}\u0010Z\u001a\u0004\b~\u0010\u007fR \u0010\u0085\u0001\u001a\u00030\u0081\u00018BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u0082\u0001\u0010Z\u001a\u0006\b\u0083\u0001\u0010\u0084\u0001R \u0010\u008a\u0001\u001a\u00030\u0086\u00018BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u0087\u0001\u0010Z\u001a\u0006\b\u0088\u0001\u0010\u0089\u0001R \u0010\u008f\u0001\u001a\u00030\u008b\u00018BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u008c\u0001\u0010Z\u001a\u0006\b\u008d\u0001\u0010\u008e\u0001R \u0010\u0094\u0001\u001a\u00030\u0090\u00018BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u0091\u0001\u0010Z\u001a\u0006\b\u0092\u0001\u0010\u0093\u0001R \u0010\u0099\u0001\u001a\u00030\u0095\u00018BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u0096\u0001\u0010Z\u001a\u0006\b\u0097\u0001\u0010\u0098\u0001R \u0010\u009e\u0001\u001a\u00030\u009a\u00018BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u009b\u0001\u0010Z\u001a\u0006\b\u009c\u0001\u0010\u009d\u0001R \u0010\u00a3\u0001\u001a\u00030\u009f\u00018BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u00a0\u0001\u0010Z\u001a\u0006\b\u00a1\u0001\u0010\u00a2\u0001R\u001a\u0010\u00a7\u0001\u001a\u00030\u00a4\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u00a5\u0001\u0010\u00a6\u0001R\u001a\u0010\u00ab\u0001\u001a\u00030\u00a8\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u00a9\u0001\u0010\u00aa\u0001R\u001c\u0010\u00af\u0001\u001a\u0005\u0018\u00010\u00ac\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00ad\u0001\u0010\u00ae\u0001R\u0018\u0010\u00b3\u0001\u001a\u00030\u00b0\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00b1\u0001\u0010\u00b2\u0001R\u0019\u0010\u00b6\u0001\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00b4\u0001\u0010\u00b5\u0001R\u0019\u0010\u00b8\u0001\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00b7\u0001\u0010\u00b7\u0001R\u001c\u0010\u00bc\u0001\u001a\u0005\u0018\u00010\u00b9\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00ba\u0001\u0010\u00bb\u0001R\u0018\u0010\u00be\u0001\u001a\u00020(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00bd\u0001\u0010nR\u0017\u0010\u00c1\u0001\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00bf\u0001\u0010\u00c0\u0001R\u0018\u0010\u00c5\u0001\u001a\u00030\u00c2\u00018BX\u0082\u0004\u00a2\u0006\b\u001a\u0006\b\u00c3\u0001\u0010\u00c4\u0001R\u0015\u0010\u00c8\u0001\u001a\u00030\u00b0\u00018F\u00a2\u0006\b\u001a\u0006\b\u00c6\u0001\u0010\u00c7\u0001\u00a8\u0006\u00cd\u0001"}, d2 = {"Lcom/tencent/mobileqq/guild/home/fragments/GuildHomeFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Lcom/tencent/mobileqq/pad/g;", "Lmqq/app/IAccountCallback;", "Lcom/tencent/mobileqq/webview/swift/u;", "", "Lcom/tencent/biz/richframework/part/Part;", "ii", "()[Lcom/tencent/biz/richframework/part/Part;", "", "initViewModel", "Landroid/view/View;", "view", "ki", "bi", "ai", "Lcom/tencent/mobileqq/guild/mainframe/startpanel/rightpart/facade/FacadeArgsData;", "facadeArgsData", "li", "hi", "Hh", "", "Ih", "com/tencent/mobileqq/guild/home/fragments/GuildHomeFragment$b", "Jh", "()Lcom/tencent/mobileqq/guild/home/fragments/GuildHomeFragment$b;", "com/tencent/mobileqq/guild/home/fragments/GuildHomeFragment$f", WidgetCacheLunarData.JI, "()Lcom/tencent/mobileqq/guild/home/fragments/GuildHomeFragment$f;", "Lcom/tencent/mobileqq/guild/home/subhome/f;", "gi", "Lcom/tencent/mobileqq/guild/home/fragments/eventbus/GuildHomeSwitchTabEvent;", "event", "ci", "Lcom/tencent/mobileqq/guild/home/fragments/eventbus/GuildHomeDialogEvent;", "Zh", "", "assembleParts", "", "getContentLayoutId", "needStatusTrans", "needImmersive", "isWrapContent", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "initWindowStyleAndAnimation", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "onCreateView", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onDestroyView", "contentView", "onViewCreatedBeforePartInit", "onViewCreatedAfterPartInit", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "onFinish", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "onBackEvent", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "qOnBackPressed", "qOnNewIntent", "from", "d5", "Lmqq/app/AppRuntime;", "newRuntime", "onAccountChanged", "onAccountChangeFailed", "Lmqq/app/Constants$LogoutReason;", "reason", "onLogout", "Lcom/tencent/mobileqq/webview/swift/WebViewFragment;", "getCurrentWebViewFragment", NodeProps.VISIBLE, "setBottomBarVisibility", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/mainframe/startpanel/rightpart/facade/FacadeArgsData;", "Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", "D", "Lkotlin/Lazy;", "Yh", "()Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", "reportTask", "E", "Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", "reportMainTask", UserInfo.SEX_FEMALE, "reportPauseTask", "Lcom/tencent/mobileqq/guild/home/parts/GuildHomeBackgroundPart;", "G", "Oh", "()Lcom/tencent/mobileqq/guild/home/parts/GuildHomeBackgroundPart;", "homeBackgroundPart", "Lcom/tencent/mobileqq/guild/home/parts/GuildHomeRefreshLoadingPart;", "H", "Uh", "()Lcom/tencent/mobileqq/guild/home/parts/GuildHomeRefreshLoadingPart;", "homeRefreshLoadingPart", "Lcom/tencent/mobileqq/guild/home/parts/GuildHomeVisitorJoinPart;", "I", "Nh", "()Lcom/tencent/mobileqq/guild/home/parts/GuildHomeVisitorJoinPart;", "guildHomeVisitorJoinPart", "Lcom/tencent/mobileqq/guild/home/parts/GuildHomeFloatTitlePart;", "J", "Qh", "()Lcom/tencent/mobileqq/guild/home/parts/GuildHomeFloatTitlePart;", "homeFloatTitlePart", "Lcom/tencent/mobileqq/guild/home/parts/GuildHomeHeaderPart;", "K", "Rh", "()Lcom/tencent/mobileqq/guild/home/parts/GuildHomeHeaderPart;", "homeHeaderPart", "Lcom/tencent/mobileqq/guild/home/parts/GuildHomeBanPart;", "L", "Ph", "()Lcom/tencent/mobileqq/guild/home/parts/GuildHomeBanPart;", "homeBanPart", "Lcom/tencent/mobileqq/guild/home/parts/GuildHomeLoadingPart;", "M", "Th", "()Lcom/tencent/mobileqq/guild/home/parts/GuildHomeLoadingPart;", "homeLoadingPart", "Lcom/tencent/mobileqq/guild/home/parts/GuildHomeInvisibleForVisitorPart;", "N", "Sh", "()Lcom/tencent/mobileqq/guild/home/parts/GuildHomeInvisibleForVisitorPart;", "homeInvisibleForVisitorPart", "Lcom/tencent/mobileqq/guild/home/parts/GuildHomeSubFragmentPart;", "P", "Vh", "()Lcom/tencent/mobileqq/guild/home/parts/GuildHomeSubFragmentPart;", "homeSubFragmentsPart", "Lcom/tencent/mobileqq/guild/home/parts/GuildOnIdlePreloadPart;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Wh", "()Lcom/tencent/mobileqq/guild/home/parts/GuildOnIdlePreloadPart;", "preloadGuidePart", "Lcom/tencent/mobileqq/guild/home/subhome/GuildHomeSubFragmentBehavior;", BdhLogUtil.LogTag.Tag_Req, "Kh", "()Lcom/tencent/mobileqq/guild/home/subhome/GuildHomeSubFragmentBehavior;", "fragmentBehavior", "Lcom/tencent/mobileqq/guild/home/parts/GuildFrameDragCompatibilityPart;", ExifInterface.LATITUDE_SOUTH, "Lh", "()Lcom/tencent/mobileqq/guild/home/parts/GuildFrameDragCompatibilityPart;", "frameDragCompatibilityPart", "Lwo1/b;", "T", "Xh", "()Lwo1/b;", "preparedIoc", "Lcom/tencent/mobileqq/guild/home/viewmodels/GuildHomeViewModel;", "U", "Lcom/tencent/mobileqq/guild/home/viewmodels/GuildHomeViewModel;", "guildHomeViewModel", "Lcom/tencent/mobileqq/guild/home/views/header/handler/GuildHomeHeaderTitleJumpHandler;", "V", "Lcom/tencent/mobileqq/guild/home/views/header/handler/GuildHomeHeaderTitleJumpHandler;", "guildTitleJumpHandler", "Lcom/tencent/mobileqq/guild/home/helper/GuildHomeTipHelper;", "W", "Lcom/tencent/mobileqq/guild/home/helper/GuildHomeTipHelper;", "guildHomeTipHelper", "", "X", "Ljava/lang/String;", "curInstanceId", "Y", "Lcom/tencent/mobileqq/guild/home/subhome/f;", "onSlideRightListener", "Z", "hasConsumedJumpParam", "Lwo1/a;", "a0", "Lwo1/a;", "coverInfoListener", "b0", "activityCode", "c0", "Lcom/tencent/mobileqq/guild/home/fragments/GuildHomeFragment$b;", "saveStateCallback", "Lcom/tencent/mobileqq/guild/constant/GuildFacadeType;", "Mh", "()Lcom/tencent/mobileqq/guild/constant/GuildFacadeType;", "guildFacadeType", "getGuildId", "()Ljava/lang/String;", "guildId", "<init>", "()V", "d0", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
@Deprecated(message = "\u65b0\u7248\u672c\u7684\u9891\u9053\u9996\u9875, \u6b63\u5728\u5f00\u53d1\u4e2d, \u65e7\u9875\u9762\u672a\u6765\u4f1a\u5e9f\u5f03", replaceWith = @ReplaceWith(expression = "GuildHomeV2Fragment", imports = {}))
@ArgusTag(testConfigKey = "Argus_Guild_Home_Main", testTags = {"AUTO_PRELOAD"})
/* loaded from: classes13.dex */
public final class GuildHomeFragment extends QPublicBaseFragment implements SimpleEventReceiver<SimpleBaseEvent>, g, IAccountCallback, u {

    /* renamed from: C, reason: from kotlin metadata */
    private FacadeArgsData facadeArgsData;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Lazy reportTask;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private IPerformanceReportTask reportMainTask;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private IPerformanceReportTask reportPauseTask;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final Lazy homeBackgroundPart;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final Lazy homeRefreshLoadingPart;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final Lazy guildHomeVisitorJoinPart;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final Lazy homeFloatTitlePart;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final Lazy homeHeaderPart;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final Lazy homeBanPart;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final Lazy homeLoadingPart;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final Lazy homeInvisibleForVisitorPart;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private final Lazy homeSubFragmentsPart;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final Lazy preloadGuidePart;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private final Lazy fragmentBehavior;

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    private final Lazy frameDragCompatibilityPart;

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private final Lazy preparedIoc;

    /* renamed from: U, reason: from kotlin metadata */
    private GuildHomeViewModel guildHomeViewModel;

    /* renamed from: V, reason: from kotlin metadata */
    private GuildHomeHeaderTitleJumpHandler guildTitleJumpHandler;

    /* renamed from: W, reason: from kotlin metadata */
    @Nullable
    private GuildHomeTipHelper guildHomeTipHelper;

    /* renamed from: X, reason: from kotlin metadata */
    @NotNull
    private final String curInstanceId;

    /* renamed from: Y, reason: from kotlin metadata */
    @NotNull
    private com.tencent.mobileqq.guild.home.subhome.f onSlideRightListener;

    /* renamed from: Z, reason: from kotlin metadata */
    private boolean hasConsumedJumpParam;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private wo1.a coverInfoListener;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private int activityCode;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b saveStateCallback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/home/fragments/GuildHomeFragment$b", "Ldf1/c;", "Landroid/app/Activity;", "saveActivity", "Landroid/os/Bundle;", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements df1.c {
        b() {
        }

        @Override // df1.c
        @Nullable
        public Bundle a(@NotNull Activity saveActivity) {
            Intrinsics.checkNotNullParameter(saveActivity, "saveActivity");
            if (!Intrinsics.areEqual(GuildHomeFragment.this.getActivity(), saveActivity)) {
                return null;
            }
            Bundle bundleOf = BundleKt.bundleOf(TuplesKt.to("sgrp_stream_pgin_source_name", com.tencent.mobileqq.guild.report.b.c()));
            Logger.f235387a.d().d("Guild.NewHome.GuildHomeFragment", 1, "onSaveInstanceState " + bundleOf);
            return bundleOf;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/base/mvvm/SingleViewModelProvider$Companion$factory$1", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "p0", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class c implements ViewModelProvider.Factory {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewModelStoreOwner f224811a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ GuildHomeFragment f224812b;

        public c(ViewModelStoreOwner viewModelStoreOwner, GuildHomeFragment guildHomeFragment) {
            this.f224811a = viewModelStoreOwner;
            this.f224812b = guildHomeFragment;
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        @NotNull
        public <T extends ViewModel> T create(@NotNull Class<T> p06) {
            Intrinsics.checkNotNullParameter(p06, "p0");
            long m1963markNowz9LOYto = TimeSource.Monotonic.INSTANCE.m1963markNowz9LOYto();
            FacadeArgsData facadeArgsData = this.f224812b.facadeArgsData;
            if (facadeArgsData == null) {
                Intrinsics.throwUninitializedPropertyAccessException("facadeArgsData");
                facadeArgsData = null;
            }
            TimedValue timedValue = new TimedValue(new GuildHomeViewModel(facadeArgsData), TimeSource.Monotonic.ValueTimeMark.m1966elapsedNowUwyO8pc(m1963markNowz9LOYto), null);
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("GuildViewModelProvider", 2, "create " + m.a(timedValue.getValue()) + " cost " + Duration.m1875toStringimpl(timedValue.m1981getDurationUwyO8pc()));
            }
            return (T) timedValue.getValue();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/guild/home/fragments/GuildHomeFragment$d", "Lcom/tencent/mobileqq/guild/home/subhome/f;", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class d implements com.tencent.mobileqq.guild.home.subhome.f {
        public d() {
        }

        @Override // com.tencent.mobileqq.guild.home.subhome.f
        public void a() {
            GuildHomeFragment.this.onBackEvent();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lri1/a;", "<anonymous parameter 0>", "Lcom/tencent/mobileqq/guild/rolegroup/model/data/g;", "<anonymous parameter 1>", "", "b", "(Lri1/a;Lcom/tencent/mobileqq/guild/rolegroup/model/data/g;)V"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    static final class e<T> implements h {

        /* renamed from: a, reason: collision with root package name */
        public static final e<T> f224814a = new e<>();

        e() {
        }

        @Override // com.tencent.mobileqq.guild.base.repository.h
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final void a(@NotNull ri1.a aVar, @Nullable RoleGroupListModel roleGroupListModel) {
            Intrinsics.checkNotNullParameter(aVar, "<anonymous parameter 0>");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000A\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001R\"\u0010\t\u001a\u00020\u00028\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0010\u001a\n \u000b*\u0004\u0018\u00010\n0\n8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0015\u001a\u00020\u00118\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u001a\u001a\u00020\u00168\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0017\u0010\u0019R\u0014\u0010\u001d\u001a\u00020\u001b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u001cR\u0014\u0010!\u001a\u00020\u001e8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0014\u0010$\u001a\u00020\"8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010#\u00a8\u0006%"}, d2 = {"com/tencent/mobileqq/guild/home/fragments/GuildHomeFragment$f", "Lwo1/b;", "Lcom/tencent/mobileqq/guild/mainframe/startpanel/rightpart/facade/FacadeArgsData;", "a", "Lcom/tencent/mobileqq/guild/mainframe/startpanel/rightpart/facade/FacadeArgsData;", "c", "()Lcom/tencent/mobileqq/guild/mainframe/startpanel/rightpart/facade/FacadeArgsData;", "g", "(Lcom/tencent/mobileqq/guild/mainframe/startpanel/rightpart/facade/FacadeArgsData;)V", "facadeArgsData", "Lcom/tencent/mobileqq/app/QBaseActivity;", "kotlin.jvm.PlatformType", "b", "Lcom/tencent/mobileqq/app/QBaseActivity;", "getActivity", "()Lcom/tencent/mobileqq/app/QBaseActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/guild/home/subhome/GuildHomeSubFragmentBehavior;", "Lcom/tencent/mobileqq/guild/home/subhome/GuildHomeSubFragmentBehavior;", "e", "()Lcom/tencent/mobileqq/guild/home/subhome/GuildHomeSubFragmentBehavior;", "fragmentBehavior", "Lmp1/b;", "d", "Lmp1/b;", "()Lmp1/b;", "homeViewModel", "Lcom/tencent/mobileqq/guild/constant/GuildFacadeType;", "()Lcom/tencent/mobileqq/guild/constant/GuildFacadeType;", "guildFacadeType", "Lcom/tencent/mobileqq/guild/home/views/header/handler/GuildHomeHeaderTitleJumpHandler;", "f", "()Lcom/tencent/mobileqq/guild/home/views/header/handler/GuildHomeHeaderTitleJumpHandler;", "guildTitleJumpHandler", "Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", "()Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", "reportTask", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class f implements wo1.b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private FacadeArgsData facadeArgsData;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final QBaseActivity activity;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final GuildHomeSubFragmentBehavior fragmentBehavior;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final mp1.b homeViewModel;

        f() {
            FacadeArgsData facadeArgsData = GuildHomeFragment.this.facadeArgsData;
            GuildHomeViewModel guildHomeViewModel = null;
            if (facadeArgsData == null) {
                Intrinsics.throwUninitializedPropertyAccessException("facadeArgsData");
                facadeArgsData = null;
            }
            this.facadeArgsData = facadeArgsData;
            this.activity = GuildHomeFragment.this.getQBaseActivity();
            this.fragmentBehavior = GuildHomeFragment.this.Kh();
            GuildHomeViewModel guildHomeViewModel2 = GuildHomeFragment.this.guildHomeViewModel;
            if (guildHomeViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("guildHomeViewModel");
            } else {
                guildHomeViewModel = guildHomeViewModel2;
            }
            this.homeViewModel = guildHomeViewModel;
        }

        @Override // wo1.b
        @NotNull
        public GuildFacadeType a() {
            Serializable serializable;
            Bundle bundle = getFacadeArgsData().C;
            GuildFacadeType guildFacadeType = null;
            if (bundle != null) {
                serializable = bundle.getSerializable("guild_facade_type");
            } else {
                serializable = null;
            }
            if (serializable instanceof GuildFacadeType) {
                guildFacadeType = (GuildFacadeType) serializable;
            }
            if (guildFacadeType == null) {
                return GuildFacadeType.FeedsGuildHome9015;
            }
            return guildFacadeType;
        }

        @Override // wo1.b
        @NotNull
        public IPerformanceReportTask b() {
            return GuildHomeFragment.this.Yh();
        }

        @Override // wo1.b
        @NotNull
        /* renamed from: c, reason: from getter */
        public FacadeArgsData getFacadeArgsData() {
            return this.facadeArgsData;
        }

        @Override // wo1.b
        @NotNull
        /* renamed from: d, reason: from getter */
        public mp1.b getHomeViewModel() {
            return this.homeViewModel;
        }

        @Override // wo1.b
        @NotNull
        /* renamed from: e, reason: from getter */
        public GuildHomeSubFragmentBehavior getFragmentBehavior() {
            return this.fragmentBehavior;
        }

        @Override // wo1.b
        @NotNull
        public GuildHomeHeaderTitleJumpHandler f() {
            GuildHomeHeaderTitleJumpHandler guildHomeHeaderTitleJumpHandler = GuildHomeFragment.this.guildTitleJumpHandler;
            if (guildHomeHeaderTitleJumpHandler == null) {
                Intrinsics.throwUninitializedPropertyAccessException("guildTitleJumpHandler");
                return null;
            }
            return guildHomeHeaderTitleJumpHandler;
        }

        @Override // wo1.b
        public void g(@NotNull FacadeArgsData facadeArgsData) {
            Intrinsics.checkNotNullParameter(facadeArgsData, "<set-?>");
            this.facadeArgsData = facadeArgsData;
        }

        @Override // wo1.b
        public QBaseActivity getActivity() {
            return this.activity;
        }
    }

    public GuildHomeFragment() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        Lazy lazy6;
        Lazy lazy7;
        Lazy lazy8;
        Lazy lazy9;
        Lazy lazy10;
        Lazy lazy11;
        Lazy lazy12;
        Lazy lazy13;
        Lazy lazy14;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<IPerformanceReportTask>() { // from class: com.tencent.mobileqq.guild.home.fragments.GuildHomeFragment$reportTask$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final IPerformanceReportTask invoke() {
                return qw1.b.d(GuildHomeFragment.this.getArguments(), null, 1, null);
            }
        });
        this.reportTask = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<GuildHomeBackgroundPart>() { // from class: com.tencent.mobileqq.guild.home.fragments.GuildHomeFragment$homeBackgroundPart$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GuildHomeBackgroundPart invoke() {
                return new GuildHomeBackgroundPart();
            }
        });
        this.homeBackgroundPart = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<GuildHomeRefreshLoadingPart>() { // from class: com.tencent.mobileqq.guild.home.fragments.GuildHomeFragment$homeRefreshLoadingPart$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GuildHomeRefreshLoadingPart invoke() {
                return new GuildHomeRefreshLoadingPart();
            }
        });
        this.homeRefreshLoadingPart = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<GuildHomeVisitorJoinPart>() { // from class: com.tencent.mobileqq.guild.home.fragments.GuildHomeFragment$guildHomeVisitorJoinPart$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GuildHomeVisitorJoinPart invoke() {
                return new GuildHomeVisitorJoinPart();
            }
        });
        this.guildHomeVisitorJoinPart = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(new Function0<GuildHomeFloatTitlePart>() { // from class: com.tencent.mobileqq.guild.home.fragments.GuildHomeFragment$homeFloatTitlePart$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GuildHomeFloatTitlePart invoke() {
                return new GuildHomeFloatTitlePart();
            }
        });
        this.homeFloatTitlePart = lazy5;
        lazy6 = LazyKt__LazyJVMKt.lazy(new Function0<GuildHomeHeaderPart>() { // from class: com.tencent.mobileqq.guild.home.fragments.GuildHomeFragment$homeHeaderPart$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GuildHomeHeaderPart invoke() {
                return new GuildHomeHeaderPart();
            }
        });
        this.homeHeaderPart = lazy6;
        lazy7 = LazyKt__LazyJVMKt.lazy(new Function0<GuildHomeBanPart>() { // from class: com.tencent.mobileqq.guild.home.fragments.GuildHomeFragment$homeBanPart$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GuildHomeBanPart invoke() {
                return new GuildHomeBanPart();
            }
        });
        this.homeBanPart = lazy7;
        lazy8 = LazyKt__LazyJVMKt.lazy(new Function0<GuildHomeLoadingPart>() { // from class: com.tencent.mobileqq.guild.home.fragments.GuildHomeFragment$homeLoadingPart$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GuildHomeLoadingPart invoke() {
                return new GuildHomeLoadingPart();
            }
        });
        this.homeLoadingPart = lazy8;
        lazy9 = LazyKt__LazyJVMKt.lazy(new Function0<GuildHomeInvisibleForVisitorPart>() { // from class: com.tencent.mobileqq.guild.home.fragments.GuildHomeFragment$homeInvisibleForVisitorPart$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GuildHomeInvisibleForVisitorPart invoke() {
                return new GuildHomeInvisibleForVisitorPart();
            }
        });
        this.homeInvisibleForVisitorPart = lazy9;
        lazy10 = LazyKt__LazyJVMKt.lazy(new Function0<GuildHomeSubFragmentPart>() { // from class: com.tencent.mobileqq.guild.home.fragments.GuildHomeFragment$homeSubFragmentsPart$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GuildHomeSubFragmentPart invoke() {
                return new GuildHomeSubFragmentPart();
            }
        });
        this.homeSubFragmentsPart = lazy10;
        lazy11 = LazyKt__LazyJVMKt.lazy(new Function0<GuildOnIdlePreloadPart>() { // from class: com.tencent.mobileqq.guild.home.fragments.GuildHomeFragment$preloadGuidePart$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GuildOnIdlePreloadPart invoke() {
                return new GuildOnIdlePreloadPart();
            }
        });
        this.preloadGuidePart = lazy11;
        lazy12 = LazyKt__LazyJVMKt.lazy(new Function0<GuildHomeSubFragmentBehavior>() { // from class: com.tencent.mobileqq.guild.home.fragments.GuildHomeFragment$fragmentBehavior$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GuildHomeSubFragmentBehavior invoke() {
                Context requireContext = GuildHomeFragment.this.requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
                GuildHomeSubFragmentBehavior guildHomeSubFragmentBehavior = new GuildHomeSubFragmentBehavior(requireContext, null);
                if (GuildHomeFragment.this.Mh() == GuildFacadeType.GameCenter) {
                    guildHomeSubFragmentBehavior.k(false);
                }
                return guildHomeSubFragmentBehavior;
            }
        });
        this.fragmentBehavior = lazy12;
        lazy13 = LazyKt__LazyJVMKt.lazy(new Function0<GuildFrameDragCompatibilityPart>() { // from class: com.tencent.mobileqq.guild.home.fragments.GuildHomeFragment$frameDragCompatibilityPart$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GuildFrameDragCompatibilityPart invoke() {
                return new GuildFrameDragCompatibilityPart();
            }
        });
        this.frameDragCompatibilityPart = lazy13;
        lazy14 = LazyKt__LazyJVMKt.lazy(new Function0<f>() { // from class: com.tencent.mobileqq.guild.home.fragments.GuildHomeFragment$preparedIoc$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GuildHomeFragment.f invoke() {
                GuildHomeFragment.f ji5;
                ji5 = GuildHomeFragment.this.ji();
                return ji5;
            }
        });
        this.preparedIoc = lazy14;
        this.curInstanceId = System.identityHashCode(this) + "_" + System.currentTimeMillis();
        this.onSlideRightListener = gi();
        this.saveStateCallback = Jh();
    }

    private final void Hh() {
        GuildSubscribePollingManager guildSubscribePollingManager = GuildSubscribePollingManager.f235373a;
        FacadeArgsData facadeArgsData = this.facadeArgsData;
        if (facadeArgsData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("facadeArgsData");
            facadeArgsData = null;
        }
        String str = facadeArgsData.f227656e;
        Intrinsics.checkNotNullExpressionValue(str, "facadeArgsData.guildId");
        guildSubscribePollingManager.d(str, this.curInstanceId);
        FacadeFragmentOnlineReportHelper.h();
        GuildHomeTipHelper guildHomeTipHelper = this.guildHomeTipHelper;
        if (guildHomeTipHelper != null) {
            guildHomeTipHelper.p();
        }
    }

    private final boolean Ih() {
        if (!GuildSplitViewUtils.f235370a.n(getActivity()) && !((IGuildTempApi) QRoute.api(IGuildTempApi.class)).isSplashActivity(getActivity())) {
            return false;
        }
        KeyEventDispatcher.Component activity = getActivity();
        if (activity instanceof l) {
            ((l) activity).getqFragmentStackManager().q(GuildHomeFragment.class.getName());
            return true;
        }
        return true;
    }

    private final b Jh() {
        return new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final GuildHomeSubFragmentBehavior Kh() {
        return (GuildHomeSubFragmentBehavior) this.fragmentBehavior.getValue();
    }

    private final GuildFrameDragCompatibilityPart Lh() {
        return (GuildFrameDragCompatibilityPart) this.frameDragCompatibilityPart.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final GuildFacadeType Mh() {
        FacadeArgsData facadeArgsData = this.facadeArgsData;
        GuildFacadeType guildFacadeType = null;
        if (facadeArgsData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("facadeArgsData");
            facadeArgsData = null;
        }
        Serializable serializable = facadeArgsData.C.getSerializable("guild_facade_type");
        if (serializable instanceof GuildFacadeType) {
            guildFacadeType = (GuildFacadeType) serializable;
        }
        if (guildFacadeType == null) {
            return GuildFacadeType.UnknownType;
        }
        return guildFacadeType;
    }

    private final GuildHomeVisitorJoinPart Nh() {
        return (GuildHomeVisitorJoinPart) this.guildHomeVisitorJoinPart.getValue();
    }

    private final GuildHomeBackgroundPart Oh() {
        return (GuildHomeBackgroundPart) this.homeBackgroundPart.getValue();
    }

    private final GuildHomeBanPart Ph() {
        return (GuildHomeBanPart) this.homeBanPart.getValue();
    }

    private final GuildHomeFloatTitlePart Qh() {
        return (GuildHomeFloatTitlePart) this.homeFloatTitlePart.getValue();
    }

    private final GuildHomeHeaderPart Rh() {
        return (GuildHomeHeaderPart) this.homeHeaderPart.getValue();
    }

    private final GuildHomeInvisibleForVisitorPart Sh() {
        return (GuildHomeInvisibleForVisitorPart) this.homeInvisibleForVisitorPart.getValue();
    }

    private final GuildHomeLoadingPart Th() {
        return (GuildHomeLoadingPart) this.homeLoadingPart.getValue();
    }

    private final GuildHomeRefreshLoadingPart Uh() {
        return (GuildHomeRefreshLoadingPart) this.homeRefreshLoadingPart.getValue();
    }

    private final GuildHomeSubFragmentPart Vh() {
        return (GuildHomeSubFragmentPart) this.homeSubFragmentsPart.getValue();
    }

    private final GuildOnIdlePreloadPart Wh() {
        return (GuildOnIdlePreloadPart) this.preloadGuidePart.getValue();
    }

    private final wo1.b Xh() {
        return (wo1.b) this.preparedIoc.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IPerformanceReportTask Yh() {
        return (IPerformanceReportTask) this.reportTask.getValue();
    }

    private final void Zh(GuildHomeDialogEvent event) {
        View requireView = requireView();
        Intrinsics.checkNotNullExpressionValue(requireView, "requireView()");
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        GuildHomeTipHelper guildHomeTipHelper = new GuildHomeTipHelper(requireView, requireActivity, getGuildId(), event.getDialogTips());
        this.guildHomeTipHelper = guildHomeTipHelper;
        guildHomeTipHelper.g();
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0031, code lost:
    
        r1 = kotlin.text.StringsKt__StringsKt.split$default((java.lang.CharSequence) r6, new java.lang.String[]{","}, false, 0, 6, (java.lang.Object) null);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void ai() {
        JumpGuildNoticeMsg jumpGuildNoticeMsg;
        boolean z16;
        String str;
        List split$default;
        Object orNull;
        if (this.hasConsumedJumpParam) {
            return;
        }
        this.hasConsumedJumpParam = true;
        FacadeArgsData facadeArgsData = this.facadeArgsData;
        FacadeArgsData facadeArgsData2 = null;
        if (facadeArgsData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("facadeArgsData");
            facadeArgsData = null;
        }
        String string = facadeArgsData.C.getString("detailId");
        if (string != null) {
            if (string.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                str = string;
            } else {
                str = null;
            }
            if (str != null && split$default != null) {
                orNull = CollectionsKt___CollectionsKt.getOrNull(split$default, 3);
                String str2 = (String) orNull;
                if (str2 != null) {
                    ((IGuildFeedLauncherApi) QRoute.api(IGuildFeedLauncherApi.class)).launchByScheme(str2);
                    return;
                }
            }
        }
        FacadeArgsData facadeArgsData3 = this.facadeArgsData;
        if (facadeArgsData3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("facadeArgsData");
            facadeArgsData3 = null;
        }
        Parcelable parcelable = facadeArgsData3.C.getParcelable(JumpGuildParam.EXTRA_JUMP_NOTICE_MSG);
        if (parcelable instanceof JumpGuildNoticeMsg) {
            jumpGuildNoticeMsg = (JumpGuildNoticeMsg) parcelable;
        } else {
            jumpGuildNoticeMsg = null;
        }
        if (jumpGuildNoticeMsg != null) {
            ((IGuildFeedLauncherApi) QRoute.api(IGuildFeedLauncherApi.class)).launchGuildFeedNoticeFragment(jumpGuildNoticeMsg, 1);
            return;
        }
        FacadeArgsData facadeArgsData4 = this.facadeArgsData;
        if (facadeArgsData4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("facadeArgsData");
            facadeArgsData4 = null;
        }
        if (facadeArgsData4.C.getInt(IGuildMessageUtilsApi.MSG_FROM_PUSH_CHANNEL) == 2) {
            FacadeArgsData facadeArgsData5 = this.facadeArgsData;
            if (facadeArgsData5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("facadeArgsData");
                facadeArgsData5 = null;
            }
            facadeArgsData5.C.remove(IGuildMessageUtilsApi.MSG_FROM_PUSH_CHANNEL);
            Context context = getContext();
            if (context != null) {
                FacadeArgsData facadeArgsData6 = this.facadeArgsData;
                if (facadeArgsData6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("facadeArgsData");
                } else {
                    facadeArgsData2 = facadeArgsData6;
                }
                JumpGuildParam a16 = facadeArgsData2.a();
                Intrinsics.checkNotNullExpressionValue(a16, "facadeArgsData.covert2JumpGuildParam()");
                GuildJumpUtil.n(context, a16);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x005b, code lost:
    
        if ((!r2) == true) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void bi() {
        String str;
        boolean isBlank;
        boolean isBlank2;
        int identityHashCode = System.identityHashCode(requireActivity());
        this.activityCode = identityHashCode;
        df1.b bVar = df1.b.f393668a;
        bVar.b(identityHashCode, this.saveStateCallback);
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        Bundle d16 = bVar.d(requireActivity);
        if (d16 != null) {
            str = d16.getString("sgrp_stream_pgin_source_name");
        } else {
            str = null;
        }
        boolean z16 = true;
        Logger.f235387a.d().i("Guild.NewHome.GuildHomeFragment", 1, "savedInstanceState " + d16);
        isBlank = StringsKt__StringsJVMKt.isBlank(com.tencent.mobileqq.guild.report.b.c());
        if (isBlank) {
            if (str != null) {
                isBlank2 = StringsKt__StringsJVMKt.isBlank(str);
            }
            z16 = false;
            if (z16) {
                com.tencent.mobileqq.guild.report.b.g(str, "Guild.NewHome.GuildHomeFragment");
            }
        }
    }

    private final void ci(GuildHomeSwitchTabEvent event) {
        if (event.getSwitchMainTab()) {
            Vh().La();
            GuildHomeViewModel guildHomeViewModel = null;
            if (!GuildMainFrameUtils.q(event.getChannelId())) {
                GuildHomeViewModel guildHomeViewModel2 = this.guildHomeViewModel;
                if (guildHomeViewModel2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("guildHomeViewModel");
                    guildHomeViewModel2 = null;
                }
                guildHomeViewModel2.getGuildSubTabPageViewModel().S1(getGuildId(), event.getChannelId());
            }
            if (event.getCategoryId() == 0) {
                GuildHomeViewModel guildHomeViewModel3 = this.guildHomeViewModel;
                if (guildHomeViewModel3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("guildHomeViewModel");
                    guildHomeViewModel3 = null;
                }
                Integer value = guildHomeViewModel3.getGuildSubTabPageViewModel().O1().getValue();
                if (value == null || value.intValue() != 2) {
                    GuildHomeViewModel guildHomeViewModel4 = this.guildHomeViewModel;
                    if (guildHomeViewModel4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("guildHomeViewModel");
                    } else {
                        guildHomeViewModel = guildHomeViewModel4;
                    }
                    guildHomeViewModel.getGuildSubTabPageViewModel().N1(2);
                    return;
                }
                return;
            }
            return;
        }
        Vh().Ja(event.getCategoryId(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void di(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ei(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void fi(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final com.tencent.mobileqq.guild.home.subhome.f gi() {
        f.Companion companion = com.tencent.mobileqq.guild.home.subhome.f.INSTANCE;
        return new d();
    }

    private final void hi() {
        FacadeArgsData facadeArgsData = this.facadeArgsData;
        GuildHomeViewModel guildHomeViewModel = null;
        if (facadeArgsData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("facadeArgsData");
            facadeArgsData = null;
        }
        String str = facadeArgsData.f227656e;
        Intrinsics.checkNotNullExpressionValue(str, "facadeArgsData.guildId");
        GuildHomeHeaderRepository.H(str, this.curInstanceId);
        GuildSubscribePollingManager guildSubscribePollingManager = GuildSubscribePollingManager.f235373a;
        FacadeArgsData facadeArgsData2 = this.facadeArgsData;
        if (facadeArgsData2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("facadeArgsData");
            facadeArgsData2 = null;
        }
        String str2 = facadeArgsData2.f227656e;
        Intrinsics.checkNotNullExpressionValue(str2, "facadeArgsData.guildId");
        guildSubscribePollingManager.c(str2, this.curInstanceId);
        GuildFeedsHomeSubChannelPollingManager guildFeedsHomeSubChannelPollingManager = GuildFeedsHomeSubChannelPollingManager.f225330a;
        FacadeArgsData facadeArgsData3 = this.facadeArgsData;
        if (facadeArgsData3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("facadeArgsData");
            facadeArgsData3 = null;
        }
        String str3 = facadeArgsData3.f227656e;
        Intrinsics.checkNotNullExpressionValue(str3, "facadeArgsData.guildId");
        guildFeedsHomeSubChannelPollingManager.i(str3, this.curInstanceId);
        FacadeArgsData facadeArgsData4 = this.facadeArgsData;
        if (facadeArgsData4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("facadeArgsData");
            facadeArgsData4 = null;
        }
        if (ch.j0(facadeArgsData4.f227656e)) {
            FacadeArgsData facadeArgsData5 = this.facadeArgsData;
            if (facadeArgsData5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("facadeArgsData");
                facadeArgsData5 = null;
            }
            FacadeFragmentOnlineReportHelper.d(facadeArgsData5.f227656e);
        } else {
            FacadeArgsData facadeArgsData6 = this.facadeArgsData;
            if (facadeArgsData6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("facadeArgsData");
                facadeArgsData6 = null;
            }
            FacadeFragmentOnlineReportHelper.j(facadeArgsData6.f227656e);
        }
        GuildHomeViewModel guildHomeViewModel2 = this.guildHomeViewModel;
        if (guildHomeViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildHomeViewModel");
        } else {
            guildHomeViewModel = guildHomeViewModel2;
        }
        guildHomeViewModel.onResume();
    }

    private final Part[] ii() {
        if (Mh() == GuildFacadeType.GameCenter) {
            return new Part[0];
        }
        return new Part[]{Qh()};
    }

    private final void initViewModel() {
        c.Companion companion = ef1.c.INSTANCE;
        ViewModel viewModel = new ViewModelProvider(this, new c(this, this)).get(GuildHomeViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, \u2026k(this) })[T::class.java]");
        this.guildHomeViewModel = (GuildHomeViewModel) viewModel;
        Logger logger = Logger.f235387a;
        GuildHomeViewModel guildHomeViewModel = null;
        if (QLog.isColorLevel()) {
            Logger.a d16 = logger.d();
            GuildHomeViewModel guildHomeViewModel2 = this.guildHomeViewModel;
            if (guildHomeViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("guildHomeViewModel");
                guildHomeViewModel2 = null;
            }
            int identityHashCode = System.identityHashCode(guildHomeViewModel2);
            GuildHomeViewModel guildHomeViewModel3 = this.guildHomeViewModel;
            if (guildHomeViewModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("guildHomeViewModel");
                guildHomeViewModel3 = null;
            }
            d16.d("Guild.NewHome.GuildHomeFragment", 1, "initViewModel id:" + identityHashCode + " " + guildHomeViewModel3);
        }
        GuildHomeViewModel guildHomeViewModel4 = this.guildHomeViewModel;
        if (guildHomeViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildHomeViewModel");
            guildHomeViewModel4 = null;
        }
        LiveData<IGProGuildInfo> X1 = guildHomeViewModel4.getCoverViewModel().X1();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<IGProGuildInfo, Unit> function1 = new Function1<IGProGuildInfo, Unit>() { // from class: com.tencent.mobileqq.guild.home.fragments.GuildHomeFragment$initViewModel$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(IGProGuildInfo iGProGuildInfo) {
                invoke2(iGProGuildInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable IGProGuildInfo iGProGuildInfo) {
                if (iGProGuildInfo == null) {
                    Logger logger2 = Logger.f235387a;
                    GuildHomeFragment guildHomeFragment = GuildHomeFragment.this;
                    Logger.b bVar = new Logger.b();
                    String str = guildHomeFragment.getGuildId() + " guildInfo is null, finish";
                    if (str instanceof String) {
                        bVar.a().add(str);
                    }
                    Iterator<T> it = bVar.a().iterator();
                    while (it.hasNext()) {
                        Logger.f235387a.d().e("Guild.NewHome.GuildHomeFragment", 1, (String) it.next(), null);
                    }
                    GuildHomeFragment.this.onBackEvent();
                    return;
                }
                if (iGProGuildInfo.isMember()) {
                    return;
                }
                FacadeArgsData facadeArgsData = GuildHomeFragment.this.facadeArgsData;
                if (facadeArgsData == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("facadeArgsData");
                    facadeArgsData = null;
                }
                if (facadeArgsData.f227659i.a().isValid()) {
                    return;
                }
                Logger logger3 = Logger.f235387a;
                GuildHomeFragment guildHomeFragment2 = GuildHomeFragment.this;
                Logger.b bVar2 = new Logger.b();
                String str2 = guildHomeFragment2.getGuildId() + " notGuildMember and withoutValidJoinInfoParam, finish";
                if (str2 instanceof String) {
                    bVar2.a().add(str2);
                }
                Iterator<T> it5 = bVar2.a().iterator();
                while (it5.hasNext()) {
                    Logger.f235387a.d().e("Guild.NewHome.GuildHomeFragment", 1, (String) it5.next(), null);
                }
                GuildHomeFragment.this.onBackEvent();
            }
        };
        X1.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.guild.home.fragments.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildHomeFragment.di(Function1.this, obj);
            }
        });
        GuildHomeViewModel guildHomeViewModel5 = this.guildHomeViewModel;
        if (guildHomeViewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildHomeViewModel");
            guildHomeViewModel5 = null;
        }
        LiveData<GuildHomeCoverColors> T1 = guildHomeViewModel5.getHeaderColorsViewModel().T1();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        final Function1<GuildHomeCoverColors, Unit> function12 = new Function1<GuildHomeCoverColors, Unit>() { // from class: com.tencent.mobileqq.guild.home.fragments.GuildHomeFragment$initViewModel$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(GuildHomeCoverColors guildHomeCoverColors) {
                invoke2(guildHomeCoverColors);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(GuildHomeCoverColors guildHomeCoverColors) {
                wo1.a aVar;
                if (guildHomeCoverColors.getType() == 0) {
                    return;
                }
                GuildHomeViewModel guildHomeViewModel6 = GuildHomeFragment.this.guildHomeViewModel;
                if (guildHomeViewModel6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("guildHomeViewModel");
                    guildHomeViewModel6 = null;
                }
                IGProGuildInfo d26 = guildHomeViewModel6.d2();
                if (d26 == null) {
                    return;
                }
                aVar = GuildHomeFragment.this.coverInfoListener;
                if (aVar != null) {
                    String guildId = GuildHomeFragment.this.getGuildId();
                    String coverUrl = d26.getCoverUrl(0, 0);
                    Intrinsics.checkNotNullExpressionValue(coverUrl, "guildInfo.getCoverUrl(0, 0)");
                    aVar.a(guildId, new ImageColorInfo(coverUrl, guildHomeCoverColors.getMainColor(), guildHomeCoverColors.getType() == 2));
                }
                if (GuildFacadeType.GameCenter != GuildHomeFragment.this.Mh()) {
                    FragmentActivity requireActivity = GuildHomeFragment.this.requireActivity();
                    Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
                    s.b(requireActivity, guildHomeCoverColors.getType() == 2);
                }
            }
        };
        T1.observe(viewLifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.guild.home.fragments.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildHomeFragment.ei(Function1.this, obj);
            }
        });
        GuildHomeViewModel guildHomeViewModel6 = this.guildHomeViewModel;
        if (guildHomeViewModel6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildHomeViewModel");
            guildHomeViewModel6 = null;
        }
        MutableLiveData<Boolean> S1 = guildHomeViewModel6.getGuildNetViewModel().S1();
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        final Function1<Boolean, Unit> function13 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.home.fragments.GuildHomeFragment$initViewModel$5
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool) {
                Logger.f235387a.d().i("Guild.NewHome.GuildHomeFragment", 1, "network------onReconnect");
                GuildHomeFragment guildHomeFragment = GuildHomeFragment.this;
                FacadeArgsData facadeArgsData = guildHomeFragment.facadeArgsData;
                if (facadeArgsData == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("facadeArgsData");
                    facadeArgsData = null;
                }
                guildHomeFragment.li(facadeArgsData);
            }
        };
        S1.observe(viewLifecycleOwner3, new Observer() { // from class: com.tencent.mobileqq.guild.home.fragments.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildHomeFragment.fi(Function1.this, obj);
            }
        });
        GuildHomeViewModel guildHomeViewModel7 = this.guildHomeViewModel;
        if (guildHomeViewModel7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildHomeViewModel");
        } else {
            guildHomeViewModel = guildHomeViewModel7;
        }
        LifecycleOwner viewLifecycleOwner4 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner4, "viewLifecycleOwner");
        guildHomeViewModel.R1(viewLifecycleOwner4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final f ji() {
        return new f();
    }

    private final void ki(View view) {
        String str;
        String str2;
        String string;
        bi();
        com.tencent.mobileqq.guild.report.b.i("pg_sgrp_channel_feed", "Guild.NewHome.GuildHomeFragment");
        HashMap hashMap = new HashMap(com.tencent.mobileqq.guild.report.b.d());
        if (Mh() == GuildFacadeType.GameCenter) {
            str = "1";
        } else {
            str = "0";
        }
        hashMap.put("sgrp_distribute_scene", str);
        FacadeArgsData facadeArgsData = this.facadeArgsData;
        FacadeArgsData facadeArgsData2 = null;
        if (facadeArgsData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("facadeArgsData");
            facadeArgsData = null;
        }
        Bundle bundle = facadeArgsData.C;
        String str3 = "";
        if (bundle == null || (str2 = bundle.getString(JumpGuildParam.EXTRA_KEY_TRACE_ID)) == null) {
            str2 = "";
        }
        hashMap.put(JumpGuildParam.EXTRA_KEY_TRACE_ID, str2);
        FacadeArgsData facadeArgsData3 = this.facadeArgsData;
        if (facadeArgsData3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("facadeArgsData");
        } else {
            facadeArgsData2 = facadeArgsData3;
        }
        Bundle bundle2 = facadeArgsData2.C;
        if (bundle2 != null && (string = bundle2.getString("sgrp_channel_extension_info")) != null) {
            str3 = string;
        }
        hashMap.put("sgrp_channel_extension_info", str3);
        VideoReport.addToDetectionWhitelist(getActivity());
        VideoReport.setPageId(view, "pg_sgrp_channel_feed");
        com.tencent.mobileqq.guild.util.report.a.a(view, getGuildId(), hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void li(FacadeArgsData facadeArgsData) {
        this.facadeArgsData = facadeArgsData;
        Bundle arguments = getArguments();
        if (arguments != null) {
            arguments.putParcelable("param_facade_args_data", facadeArgsData);
        }
        Xh().g(facadeArgsData);
        Vh().ja();
        Rh().V9();
        GuildHomeHeaderTitleJumpHandler guildHomeHeaderTitleJumpHandler = this.guildTitleJumpHandler;
        GuildHomeViewModel guildHomeViewModel = null;
        if (guildHomeHeaderTitleJumpHandler == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildTitleJumpHandler");
            guildHomeHeaderTitleJumpHandler = null;
        }
        guildHomeHeaderTitleJumpHandler.g(facadeArgsData);
        GuildHomeViewModel guildHomeViewModel2 = this.guildHomeViewModel;
        if (guildHomeViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildHomeViewModel");
        } else {
            guildHomeViewModel = guildHomeViewModel2;
        }
        guildHomeViewModel.k2(facadeArgsData);
        GuildOpenRecordManager guildOpenRecordManager = GuildOpenRecordManager.f227480a;
        guildOpenRecordManager.i(this.curInstanceId);
        String str = facadeArgsData.f227656e;
        Intrinsics.checkNotNullExpressionValue(str, "facadeArgsData.guildId");
        guildOpenRecordManager.b(new GuildOpenRecordManager.ActivityRecord(str, this.curInstanceId));
        hi();
        Kh().D();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<Part> assembleParts() {
        List<Part> mutableListOf;
        SpreadBuilder spreadBuilder = new SpreadBuilder(12);
        spreadBuilder.add(Rh());
        spreadBuilder.add(Vh());
        spreadBuilder.add(Oh());
        spreadBuilder.add(Uh());
        spreadBuilder.add(Nh());
        spreadBuilder.add(Ph());
        spreadBuilder.add(Th());
        spreadBuilder.add(Sh());
        spreadBuilder.add(new com.tencent.mobileqq.guild.home.parts.ch());
        spreadBuilder.add(Lh());
        spreadBuilder.add(Wh());
        spreadBuilder.addSpread(ii());
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(spreadBuilder.toArray(new Part[spreadBuilder.size()]));
        return mutableListOf;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.etm;
    }

    @Override // com.tencent.mobileqq.webview.swift.u
    @Nullable
    public WebViewFragment getCurrentWebViewFragment() {
        return Vh().ma();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(GuildHomeSwitchTabEvent.class, GuildHomeDialogEvent.class);
        return arrayListOf;
    }

    @NotNull
    public final String getGuildId() {
        FacadeArgsData facadeArgsData = this.facadeArgsData;
        FacadeArgsData facadeArgsData2 = null;
        if (facadeArgsData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("facadeArgsData");
            facadeArgsData = null;
        }
        String str = facadeArgsData.f227656e;
        if (str == null) {
            FacadeArgsData facadeArgsData3 = this.facadeArgsData;
            if (facadeArgsData3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("facadeArgsData");
            } else {
                facadeArgsData2 = facadeArgsData3;
            }
            com.tencent.mobileqq.guild.util.s.f("Guild.NewHome.GuildHomeFragment", "facadeArgsData(" + facadeArgsData2 + ") is invalid!", new NullPointerException());
            return "";
        }
        return str;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public void initWindowStyleAndAnimation(@Nullable Activity activity) {
        Logger logger = Logger.f235387a;
        logger.d().i("Guild.NewHome.GuildHomeFragment", 1, "initWindowStyleAndAnimation " + this.curInstanceId);
        super.initWindowStyleAndAnimation(activity);
        FacadeArgsData b16 = com.tencent.mobileqq.guild.base.extension.c.b(getArguments());
        this.facadeArgsData = b16;
        Boolean bool = null;
        if (b16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("facadeArgsData");
            b16 = null;
        }
        Bundle bundle = b16.C;
        if (bundle != null) {
            bool = Boolean.valueOf(bundle.getBoolean("jumpGuildFromLoadingPage"));
        }
        if (QLog.isDebugVersion()) {
            logger.d().d("Guild.NewHome.GuildHomeFragment", 1, "initWindowStyleAndAnimation activity:" + activity + " JUMP_GUILD_FROM_LOADING_PAGE:" + bool);
        }
        if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
            if (activity != null) {
                activity.overridePendingTransition(R.anim.l_, R.anim.l_);
            }
        } else if (activity != null) {
            activity.overridePendingTransition(R.anim.f154619or, R.anim.f154425m);
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean isWrapContent() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needStatusTrans() {
        return true;
    }

    @Override // mqq.app.IAccountCallback
    public void onAccountChanged(@Nullable AppRuntime newRuntime) {
        Ih();
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        FragmentActivity activity;
        QLog.i("Guild.NewHome.GuildHomeFragment", 1, "tagckb onBackEvent-> 01 GuildHomeFragment");
        if (!super.onBackEvent() && !com.tencent.mobileqq.guild.base.extension.h.b(this) && !Ih() && (activity = getActivity()) != null) {
            activity.finish();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Window window;
        Logger.f235387a.d().i("Guild.NewHome.GuildHomeFragment", 1, "onCreate " + this.curInstanceId);
        FacadeArgsData b16 = com.tencent.mobileqq.guild.base.extension.c.b(getArguments());
        this.facadeArgsData = b16;
        dp1.a aVar = dp1.a.f394517a;
        FacadeArgsData facadeArgsData = null;
        if (b16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("facadeArgsData");
            b16 = null;
        }
        String str = b16.f227656e;
        Intrinsics.checkNotNullExpressionValue(str, "facadeArgsData.guildId");
        aVar.f(str, System.currentTimeMillis());
        super.onCreate(savedInstanceState);
        FragmentActivity activity = getActivity();
        if (activity != null && (window = activity.getWindow()) != null) {
            window.setSoftInputMode(48);
        }
        if (GuildSplitViewUtils.f235370a.n(getActivity())) {
            MobileQQ.sMobileQQ.registerAccountCallback(this);
        }
        k.Companion companion = k.INSTANCE;
        FacadeArgsData facadeArgsData2 = this.facadeArgsData;
        if (facadeArgsData2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("facadeArgsData");
        } else {
            facadeArgsData = facadeArgsData2;
        }
        String str2 = facadeArgsData.f227656e;
        Intrinsics.checkNotNullExpressionValue(str2, "facadeArgsData.guildId");
        companion.b(str2, "GuildHomeFragment");
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FacadeArgsData facadeArgsData;
        BetterCoordinatorLayout betterCoordinatorLayout;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        IPerformanceReportTask iPerformanceReportTask = this.reportMainTask;
        if (iPerformanceReportTask == null) {
            iPerformanceReportTask = Yh().duplicate("guild_id").setStageCode("stage_main");
        }
        this.reportMainTask = iPerformanceReportTask;
        IPerformanceReportTask iPerformanceReportTask2 = this.reportPauseTask;
        if (iPerformanceReportTask2 == null) {
            iPerformanceReportTask2 = Yh().duplicate("guild_id").setStageCode("stage_fragment_onpause");
        }
        this.reportPauseTask = iPerformanceReportTask2;
        dp1.a aVar = dp1.a.f394517a;
        FacadeArgsData facadeArgsData2 = this.facadeArgsData;
        if (facadeArgsData2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("facadeArgsData");
            facadeArgsData2 = null;
        }
        String str = facadeArgsData2.f227656e;
        Intrinsics.checkNotNullExpressionValue(str, "facadeArgsData.guildId");
        aVar.e(str, System.currentTimeMillis());
        TraceUtils traceUtils = TraceUtils.f235403a;
        if (!TraceUtils.m()) {
            traceUtils.l();
            Logger.f235387a.d().i("Guild.NewHome.GuildHomeFragment", 1, "onCreateView guildId=" + getGuildId() + " " + getArguments());
            if (at.c()) {
                r.p().h(new FetchRoleGroupParam(getGuildId(), null, false, 100, 6, null), e.f224814a);
            }
            View onCreateView = super.onCreateView(inflater, container, savedInstanceState);
            Intrinsics.checkNotNull(onCreateView);
            GuildFacadeType Mh = Mh();
            GuildFacadeType guildFacadeType = GuildFacadeType.GameCenter;
            if (Mh == guildFacadeType) {
                onCreateView.setFitsSystemWindows(false);
                com.tencent.mobileqq.guild.report.b.g("new_qq_games_embed_channels", "Guild.NewHome.GuildHomeFragment");
            }
            if (onCreateView instanceof BetterCoordinatorLayout) {
                String guildId = getGuildId();
                betterCoordinatorLayout = (BetterCoordinatorLayout) onCreateView;
                betterCoordinatorLayout.setTouchEventAware(Kh());
                FragmentActivity requireActivity = requireActivity();
                Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
                s.e(requireActivity);
                if (guildFacadeType != Mh()) {
                    FragmentActivity requireActivity2 = requireActivity();
                    Intrinsics.checkNotNullExpressionValue(requireActivity2, "requireActivity()");
                    s.b(requireActivity2, false);
                }
                QBaseActivity qBaseActivity = getQBaseActivity();
                Intrinsics.checkNotNullExpressionValue(qBaseActivity, "qBaseActivity");
                this.guildTitleJumpHandler = new GuildHomeHeaderTitleJumpHandler(qBaseActivity, Mh());
                GuildHomeHeaderTitleJumpHandler guildHomeHeaderTitleJumpHandler = this.guildTitleJumpHandler;
                if (guildHomeHeaderTitleJumpHandler == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("guildTitleJumpHandler");
                    guildHomeHeaderTitleJumpHandler = null;
                }
                FacadeArgsData facadeArgsData3 = this.facadeArgsData;
                if (facadeArgsData3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("facadeArgsData");
                    facadeArgsData3 = null;
                }
                guildHomeHeaderTitleJumpHandler.g(facadeArgsData3);
                traceUtils.e(onCreateView, "Guild.HomePage.Fragment.RootViewPreDraw", new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.home.fragments.GuildHomeFragment$onCreateView$1$3
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        dp1.a aVar2 = dp1.a.f394517a;
                        FacadeArgsData facadeArgsData4 = GuildHomeFragment.this.facadeArgsData;
                        if (facadeArgsData4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("facadeArgsData");
                            facadeArgsData4 = null;
                        }
                        String str2 = facadeArgsData4.f227656e;
                        Intrinsics.checkNotNullExpressionValue(str2, "facadeArgsData.guildId");
                        aVar2.d(str2, System.currentTimeMillis(), "Guild.HomePage.Fragment.RootViewPreDraw");
                    }
                });
                Kh().g(this.onSlideRightListener);
                GuildOpenRecordManager.f227480a.b(new GuildOpenRecordManager.ActivityRecord(guildId, this.curInstanceId));
                qw1.b.k(this.reportMainTask, onCreateView, null, 2, null);
                this.reportMainTask = DummyPerformanceReportTask.INSTANCE;
                FacadeArgsData facadeArgsData4 = this.facadeArgsData;
                if (facadeArgsData4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("facadeArgsData");
                    facadeArgsData4 = null;
                }
                qw1.b.c(facadeArgsData4.C, JumpGuildParam.EXTRA_JUMP_REPORT_TASK).duplicate("guild_id").setStageCode("stage_jump_home_show").report();
            } else {
                throw new IllegalStateException("Check failed.".toString());
            }
        } else {
            try {
                cy.c("Guild.HomePage.Fragment.onCreate");
                Logger.f235387a.d().i("Guild.NewHome.GuildHomeFragment", 1, "onCreateView guildId=" + getGuildId() + " " + getArguments());
                if (at.c()) {
                    r.p().h(new FetchRoleGroupParam(getGuildId(), null, false, 100, 6, null), e.f224814a);
                }
                View onCreateView2 = super.onCreateView(inflater, container, savedInstanceState);
                Intrinsics.checkNotNull(onCreateView2);
                GuildFacadeType Mh2 = Mh();
                GuildFacadeType guildFacadeType2 = GuildFacadeType.GameCenter;
                if (Mh2 == guildFacadeType2) {
                    onCreateView2.setFitsSystemWindows(false);
                    com.tencent.mobileqq.guild.report.b.g("new_qq_games_embed_channels", "Guild.NewHome.GuildHomeFragment");
                }
                if (onCreateView2 instanceof BetterCoordinatorLayout) {
                    String guildId2 = getGuildId();
                    ((BetterCoordinatorLayout) onCreateView2).setTouchEventAware(Kh());
                    FragmentActivity requireActivity3 = requireActivity();
                    Intrinsics.checkNotNullExpressionValue(requireActivity3, "requireActivity()");
                    s.e(requireActivity3);
                    if (guildFacadeType2 != Mh()) {
                        FragmentActivity requireActivity4 = requireActivity();
                        Intrinsics.checkNotNullExpressionValue(requireActivity4, "requireActivity()");
                        s.b(requireActivity4, false);
                    }
                    QBaseActivity qBaseActivity2 = getQBaseActivity();
                    Intrinsics.checkNotNullExpressionValue(qBaseActivity2, "qBaseActivity");
                    this.guildTitleJumpHandler = new GuildHomeHeaderTitleJumpHandler(qBaseActivity2, Mh());
                    GuildHomeHeaderTitleJumpHandler guildHomeHeaderTitleJumpHandler2 = this.guildTitleJumpHandler;
                    if (guildHomeHeaderTitleJumpHandler2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("guildTitleJumpHandler");
                        guildHomeHeaderTitleJumpHandler2 = null;
                    }
                    FacadeArgsData facadeArgsData5 = this.facadeArgsData;
                    if (facadeArgsData5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("facadeArgsData");
                        facadeArgsData5 = null;
                    }
                    guildHomeHeaderTitleJumpHandler2.g(facadeArgsData5);
                    traceUtils.e(onCreateView2, "Guild.HomePage.Fragment.RootViewPreDraw", new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.home.fragments.GuildHomeFragment$onCreateView$1$3
                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            dp1.a aVar2 = dp1.a.f394517a;
                            FacadeArgsData facadeArgsData42 = GuildHomeFragment.this.facadeArgsData;
                            if (facadeArgsData42 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("facadeArgsData");
                                facadeArgsData42 = null;
                            }
                            String str2 = facadeArgsData42.f227656e;
                            Intrinsics.checkNotNullExpressionValue(str2, "facadeArgsData.guildId");
                            aVar2.d(str2, System.currentTimeMillis(), "Guild.HomePage.Fragment.RootViewPreDraw");
                        }
                    });
                    Kh().g(this.onSlideRightListener);
                    GuildOpenRecordManager.f227480a.b(new GuildOpenRecordManager.ActivityRecord(guildId2, this.curInstanceId));
                    qw1.b.k(this.reportMainTask, onCreateView2, null, 2, null);
                    this.reportMainTask = DummyPerformanceReportTask.INSTANCE;
                    FacadeArgsData facadeArgsData6 = this.facadeArgsData;
                    if (facadeArgsData6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("facadeArgsData");
                        facadeArgsData = null;
                    } else {
                        facadeArgsData = facadeArgsData6;
                    }
                    qw1.b.c(facadeArgsData.C, JumpGuildParam.EXTRA_JUMP_REPORT_TASK).duplicate("guild_id").setStageCode("stage_jump_home_show").report();
                    betterCoordinatorLayout = (BetterCoordinatorLayout) onCreateView2;
                } else {
                    throw new IllegalStateException("Check failed.".toString());
                }
            } finally {
                cy.d();
            }
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, betterCoordinatorLayout);
        return betterCoordinatorLayout;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        boolean z16;
        super.onDestroy();
        FacadeArgsData facadeArgsData = this.facadeArgsData;
        FacadeArgsData facadeArgsData2 = null;
        if (facadeArgsData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("facadeArgsData");
            facadeArgsData = null;
        }
        String str = facadeArgsData.f227656e;
        Intrinsics.checkNotNullExpressionValue(str, "facadeArgsData.guildId");
        GuildHomeHeaderRepository.G(str, this.curInstanceId);
        GuildFeedsHomeSubChannelPollingManager guildFeedsHomeSubChannelPollingManager = GuildFeedsHomeSubChannelPollingManager.f225330a;
        FacadeArgsData facadeArgsData3 = this.facadeArgsData;
        if (facadeArgsData3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("facadeArgsData");
            facadeArgsData3 = null;
        }
        String str2 = facadeArgsData3.f227656e;
        Intrinsics.checkNotNullExpressionValue(str2, "facadeArgsData.guildId");
        guildFeedsHomeSubChannelPollingManager.h(str2, this.curInstanceId);
        RFWIocAbilityProvider.g().unregisterSingleIoc(getView(), wo1.b.class);
        GuildOpenRecordManager.f227480a.i(this.curInstanceId);
        Kh().B(this.onSlideRightListener);
        ViewPoolEngine.f228744a.j();
        ILocalFocusService iLocalFocusService = (ILocalFocusService) ch.R0(ILocalFocusService.class);
        FacadeArgsData facadeArgsData4 = this.facadeArgsData;
        if (facadeArgsData4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("facadeArgsData");
        } else {
            facadeArgsData2 = facadeArgsData4;
        }
        String str3 = facadeArgsData2.f227656e;
        if (str3.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            str3 = "0";
        }
        Intrinsics.checkNotNullExpressionValue(str3, "facadeArgsData.guildId.i\u2026FocusService.INVALID_ID }");
        iLocalFocusService.setActiveGuild(new GuildActiveInfo(new GuildActiveInfo.UniqueKey(str3, this.curInstanceId), 2, false));
        if (GuildSplitViewUtils.f235370a.n(getActivity())) {
            MobileQQ.sMobileQQ.unregisterAccountCallback(this);
        }
        df1.b.f393668a.e(this.activityCode);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        GuildNoticeKtKt.c(getGuildId(), 5, null, 4, null);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onFinish() {
        super.onFinish();
        QBaseActivity qBaseActivity = getQBaseActivity();
        if (qBaseActivity != null) {
            qBaseActivity.overridePendingTransition(R.anim.f154422j, R.anim.f154480ae);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        Hh();
        qw1.b.m(this.reportPauseTask);
        GuildHomeViewModel guildHomeViewModel = this.guildHomeViewModel;
        if (guildHomeViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildHomeViewModel");
            guildHomeViewModel = null;
        }
        guildHomeViewModel.f2();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        if (event instanceof GuildHomeSwitchTabEvent) {
            ci((GuildHomeSwitchTabEvent) event);
        } else if (event instanceof GuildHomeDialogEvent) {
            Zh((GuildHomeDialogEvent) event);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        String str;
        boolean z16;
        super.onResume();
        View requireView = requireView();
        Intrinsics.checkNotNullExpressionValue(requireView, "requireView()");
        ki(requireView);
        IGProGuildInfo L = ch.L(getGuildId());
        GuildHomeViewModel guildHomeViewModel = null;
        if (L != null) {
            str = L.getGuildName();
        } else {
            str = null;
        }
        if (str == null) {
            str = "Unknown";
        }
        boolean z17 = true;
        Logger.f235387a.d().i("Guild.NewHome.GuildHomeFragment", 1, "onResume: " + Mh() + ", " + this.curInstanceId + ", " + getGuildId() + ", " + str);
        hi();
        SimpleEventBus.getInstance().registerReceiver(this);
        ILocalFocusService iLocalFocusService = (ILocalFocusService) ch.R0(ILocalFocusService.class);
        FacadeArgsData facadeArgsData = this.facadeArgsData;
        if (facadeArgsData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("facadeArgsData");
            facadeArgsData = null;
        }
        String str2 = facadeArgsData.f227656e;
        if (str2.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            str2 = "0";
        }
        Intrinsics.checkNotNullExpressionValue(str2, "facadeArgsData.guildId.i\u2026FocusService.INVALID_ID }");
        GuildActiveInfo.UniqueKey uniqueKey = new GuildActiveInfo.UniqueKey(str2, this.curInstanceId);
        FacadeArgsData facadeArgsData2 = this.facadeArgsData;
        if (facadeArgsData2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("facadeArgsData");
            facadeArgsData2 = null;
        }
        String str3 = facadeArgsData2.f227656e;
        Intrinsics.checkNotNullExpressionValue(str3, "facadeArgsData.guildId");
        if (str3.length() <= 0) {
            z17 = false;
        }
        iLocalFocusService.setActiveGuild(new GuildActiveInfo(uniqueKey, 2, z17));
        GuildHomeViewModel guildHomeViewModel2 = this.guildHomeViewModel;
        if (guildHomeViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildHomeViewModel");
        } else {
            guildHomeViewModel = guildHomeViewModel2;
        }
        guildHomeViewModel.g2();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        Logger.f235387a.d().i("Guild.NewHome.GuildHomeFragment", 1, "onViewCreated " + this.curInstanceId);
        FacadeArgsData facadeArgsData = this.facadeArgsData;
        if (facadeArgsData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("facadeArgsData");
            facadeArgsData = null;
        }
        String string = facadeArgsData.C.getString("param_first_show_text");
        if (string != null) {
            FragmentActivity requireActivity = requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            GuildHomeTipHelper guildHomeTipHelper = new GuildHomeTipHelper(view, requireActivity, getGuildId(), string);
            this.guildHomeTipHelper = guildHomeTipHelper;
            guildHomeTipHelper.g();
        }
        initViewModel();
        super.onViewCreated(view, savedInstanceState);
        GuildNoticeKtKt.c(getGuildId(), 5, null, 4, null);
        ai();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedAfterPartInit(@NotNull View contentView, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(contentView, "contentView");
        Logger.f235387a.d().i("Guild.NewHome.GuildHomeFragment", 1, "onViewCreatedAfterPartInit");
        super.onViewCreatedAfterPartInit(contentView, savedInstanceState);
        Vh().Ba();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedBeforePartInit(@NotNull View contentView, @Nullable Bundle savedInstanceState) {
        boolean z16;
        Intrinsics.checkNotNullParameter(contentView, "contentView");
        super.onViewCreatedBeforePartInit(contentView, savedInstanceState);
        if (contentView == getView()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            RFWIocAbilityProvider.g().registerIoc(getView(), Xh(), wo1.b.class);
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    @Override // com.tencent.mobileqq.pad.f
    public boolean qOnBackPressed() {
        return false;
    }

    @Override // com.tencent.mobileqq.webview.swift.u
    public boolean setBottomBarVisibility(boolean visible) {
        return false;
    }

    @Override // com.tencent.mobileqq.pad.f
    public void qOnNewIntent() {
    }

    @Override // com.tencent.mobileqq.pad.g
    public void d5(int from) {
    }

    @Override // mqq.app.IAccountCallback
    public void onAccountChangeFailed(@Nullable AppRuntime newRuntime) {
    }

    @Override // mqq.app.IAccountCallback
    public void onLogout(@Nullable Constants.LogoutReason reason) {
    }
}
