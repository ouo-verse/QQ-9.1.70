package com.tencent.mobileqq.guild.mainframe;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentContainer;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.common.config.AppSetting;
import com.tencent.guild.api.util.IGuildUtilApi;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.utils.GlobalDisplayMetricsManager;
import com.tencent.mobileqq.guild.api.IGuildStandalonePageOpenApi;
import com.tencent.mobileqq.guild.api.IGuildTempApi;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.guild.base.preload.LayoutLoaders;
import com.tencent.mobileqq.guild.main.alert.GuildMainAlertEvent;
import com.tencent.mobileqq.guild.mainframe.GuildSecondaryFragment;
import com.tencent.mobileqq.guild.mainframe.centerpanel.GuildCenterPanelController;
import com.tencent.mobileqq.guild.mainframe.centerpanel.GuildMainFrameLayout;
import com.tencent.mobileqq.guild.mainframe.helper.GuildGuideAnimHelper;
import com.tencent.mobileqq.guild.mainframe.l;
import com.tencent.mobileqq.guild.mainframe.manager.GuildMainFrameManager;
import com.tencent.mobileqq.guild.mainframe.startpanel.leftbar.GuildLeftBarListController;
import com.tencent.mobileqq.guild.mainframe.startpanel.rightpart.GuildStartPanelRightController;
import com.tencent.mobileqq.guild.mainframe.view.GuildDragFrameLayout;
import com.tencent.mobileqq.guild.message.unread.api.IGuildUnreadCntService;
import com.tencent.mobileqq.guild.openentrance.eventbus.GuildJumpLeftNodeEvent;
import com.tencent.mobileqq.guild.openentrance.eventbus.GuildJumpNextUnreadNodeEvent;
import com.tencent.mobileqq.guild.theme.GuildThemeManager;
import com.tencent.mobileqq.guild.util.FragmentUtils;
import com.tencent.mobileqq.guild.util.GuildDebugUtils;
import com.tencent.mobileqq.guild.util.IQQGuildUtilApi;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.TraceUtils;
import com.tencent.mobileqq.guild.util.bc;
import com.tencent.mobileqq.guild.util.bh;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.cy;
import com.tencent.mobileqq.guild.util.debug.GuildJumpDebugUtils;
import com.tencent.mobileqq.guild.widget.GuildBottomSheetDialogDismissEvent;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qqguildsdk.tianjige.IQQOpenTelemetryReportApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.richframework.argus.node.ArgusTag;
import com.tencent.util.Pair;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vp1.ax;

/* compiled from: P */
@ArgusTag(testConfigKey = "Argus_Guild", testTags = {"AUTO_PRELOAD"})
@Metadata(d1 = {"\u0000\u00ac\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\t*\u0002\u00b5\u0001\b\u0007\u0018\u0000 \u009c\u00012\u00020\u00012\u00020\u00022\u00020\u00032\b\u0012\u0004\u0012\u00020\u00050\u0004:\u0004\u00bb\u0001\u00bc\u0001B\t\u00a2\u0006\u0006\b\u00b9\u0001\u0010\u00ba\u0001J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J$\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u000f\u001a\u00020\bH\u0016J\b\u0010\u0010\u001a\u00020\bH\u0016J\b\u0010\u0011\u001a\u00020\bH\u0016J\u0012\u0010\u0013\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005H\u0016J$\u0010\u0017\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00150\u0014j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0015`\u0016H\u0016J\b\u0010\u0018\u001a\u00020\bH\u0016J\b\u0010\u0019\u001a\u00020\bH\u0016J\b\u0010\u001a\u001a\u00020\bH\u0016J\u0010\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\b\u0010\u001f\u001a\u00020\u001eH\u0016J\b\u0010!\u001a\u00020 H\u0016J\b\u0010#\u001a\u00020\"H\u0016J\b\u0010%\u001a\u00020$H\u0016J\b\u0010'\u001a\u00020&H\u0016J\b\u0010)\u001a\u00020(H\u0016J\u0012\u0010-\u001a\u0004\u0018\u00010,2\u0006\u0010+\u001a\u00020*H\u0016J\b\u0010/\u001a\u00020.H\u0016J\b\u00100\u001a\u00020\fH\u0016J\b\u00102\u001a\u000201H\u0016J\b\u00104\u001a\u000203H\u0016J\b\u00106\u001a\u000205H\u0016J\u0010\u00108\u001a\u00020\b2\u0006\u00107\u001a\u000205H\u0016J\b\u0010:\u001a\u000209H\u0016J\b\u0010<\u001a\u00020;H\u0016J\u0012\u0010>\u001a\u00020\b2\b\u0010=\u001a\u0004\u0018\u00010\u0006H\u0016J\u0018\u0010A\u001a\u00020\b2\u0006\u0010?\u001a\u00020*2\u0006\u0010@\u001a\u000203H\u0016J\u0010\u0010C\u001a\u00020\b2\u0006\u0010B\u001a\u00020*H\u0016J\u0010\u0010D\u001a\u00020\b2\u0006\u0010B\u001a\u00020*H\u0016J\u001a\u0010H\u001a\u00020\b2\u0006\u0010E\u001a\u0002032\b\u0010G\u001a\u0004\u0018\u00010FH\u0016J\u0012\u0010K\u001a\u00020\b2\b\u0010J\u001a\u0004\u0018\u00010IH\u0016J\u0018\u0010O\u001a\u00020\b2\u0006\u0010M\u001a\u00020L2\u0006\u0010N\u001a\u000203H\u0016J\u0006\u0010Q\u001a\u00020PJ\"\u0010V\u001a\u00020\b2\u0006\u0010R\u001a\u00020*2\u0006\u0010S\u001a\u00020*2\b\u0010U\u001a\u0004\u0018\u00010TH\u0016J\b\u0010W\u001a\u00020\bH\u0016J\b\u0010X\u001a\u00020\bH\u0016J\u0010\u0010Z\u001a\u00020\b2\u0006\u0010Y\u001a\u000203H\u0016J\u0010\u0010[\u001a\u00020\b2\u0006\u0010Y\u001a\u000203H\u0016J\b\u0010\\\u001a\u00020\bH\u0016J\b\u0010]\u001a\u00020\bH\u0016J\b\u0010^\u001a\u00020\bH\u0016J\u0010\u0010`\u001a\u00020\b2\u0006\u0010_\u001a\u000203H\u0016J\b\u0010a\u001a\u000203H\u0016J\u0010\u0010c\u001a\u00020\b2\u0006\u0010b\u001a\u000203H\u0016J\b\u0010d\u001a\u000203H\u0016J\u0010\u0010g\u001a\u00020\b2\u0006\u0010f\u001a\u00020eH\u0016J\b\u0010h\u001a\u00020\bH\u0002J\b\u0010i\u001a\u00020\bH\u0002J\b\u0010k\u001a\u00020jH\u0002J\b\u0010l\u001a\u00020\bH\u0002J\u0016\u0010o\u001a\b\u0012\u0004\u0012\u00020L0n2\u0006\u0010m\u001a\u00020LH\u0002J\b\u0010p\u001a\u00020\bH\u0002R\u0016\u0010s\u001a\u00020P8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bq\u0010rR\u0016\u0010w\u001a\u00020t8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bu\u0010vR\u0016\u0010z\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bx\u0010yR\u0016\u0010}\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b{\u0010|R\u0017\u0010\u0080\u0001\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b~\u0010\u007fR\u0019\u0010\u0083\u0001\u001a\u00020&8\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u0081\u0001\u0010\u0082\u0001R\u0019\u0010\u0086\u0001\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u0084\u0001\u0010\u0085\u0001R\u001a\u0010\u008a\u0001\u001a\u00030\u0087\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u0088\u0001\u0010\u0089\u0001R\u0019\u0010\u008d\u0001\u001a\u00020.8\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u008b\u0001\u0010\u008c\u0001R\u0019\u0010\u0090\u0001\u001a\u00020\f8\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u008e\u0001\u0010\u008f\u0001RI\u0010\u0096\u0001\u001a4\u0012\r\u0012\u000b\u0012\u0007\b\u0001\u0012\u00030\u0092\u00010\u0015\u0012\u0005\u0012\u00030\u0092\u00010\u0091\u0001j\u0019\u0012\r\u0012\u000b\u0012\u0007\b\u0001\u0012\u00030\u0092\u00010\u0015\u0012\u0005\u0012\u00030\u0092\u0001`\u0093\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0094\u0001\u0010\u0095\u0001R\u0017\u0010\u0099\u0001\u001a\u00030\u0097\u00018\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b)\u0010\u0098\u0001R\u0018\u0010\u009a\u0001\u001a\u00020*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b4\u0010\u0084\u0001R\u0019\u0010\u009d\u0001\u001a\u0002038\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u009b\u0001\u0010\u009c\u0001R\u0018\u0010\u009f\u0001\u001a\u0002058\u0002@\u0002X\u0082.\u00a2\u0006\u0007\n\u0005\b8\u0010\u009e\u0001R!\u0010\u00a5\u0001\u001a\u00030\u00a0\u00018BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u00a1\u0001\u0010\u00a2\u0001\u001a\u0006\b\u00a3\u0001\u0010\u00a4\u0001R\u0019\u0010\u00a7\u0001\u001a\u0002038\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00a6\u0001\u0010\u009c\u0001R\u001a\u0010\u00ab\u0001\u001a\u00030\u00a8\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00a9\u0001\u0010\u00aa\u0001R\u0019\u0010\u00ae\u0001\u001a\u00020j8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00ac\u0001\u0010\u00ad\u0001R\u001c\u0010\u00b2\u0001\u001a\u0005\u0018\u00010\u00af\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00b0\u0001\u0010\u00b1\u0001R\u0019\u0010\u00b4\u0001\u001a\u0002038\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00b3\u0001\u0010\u009c\u0001R\u0018\u0010\u00b8\u0001\u001a\u00030\u00b5\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00b6\u0001\u0010\u00b7\u0001\u00a8\u0006\u00bd\u0001"}, d2 = {"Lcom/tencent/mobileqq/guild/mainframe/GuildMainFragment;", "Lcom/tencent/mobileqq/guild/mainframe/AbsGuildMainFragment;", "Lcom/tencent/mobileqq/guild/mainframe/c;", "Lcom/tencent/mobileqq/guild/mainframe/s;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onCreate", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Kh", "onStart", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, DKHippyEvent.EVENT_STOP, "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "onResume", "onDestroyView", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "Lmqq/app/AppRuntime;", "getApp", "Lcom/tencent/mobileqq/guild/mainframe/startpanel/leftbar/GuildLeftBarListController;", "C1", "Lcom/tencent/mobileqq/guild/mainframe/startpanel/rightpart/GuildStartPanelRightController;", "e1", "Lcom/tencent/mobileqq/guild/mainframe/centerpanel/GuildCenterPanelController;", "Z0", "Lvr1/a;", "d1", "Lsr1/d;", "N", "", "type", "", "getHelper", "Lcom/tencent/mobileqq/activity/recent/cur/DragFrameLayout;", "jh", "getRootView", "Landroidx/fragment/app/FragmentManager;", "Rc", "", "P", "Lcom/tencent/mobileqq/guild/mainframe/GuildAppReportSourceInfo;", "f0", "sourceInfo", BdhLogUtil.LogTag.Tag_Req, "Landroidx/lifecycle/LifecycleOwner;", "getLifecycleOwner", "Landroidx/lifecycle/ViewModelStoreOwner;", "y", "extra", "handleJumpAction", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_SHOW_TYPE, "isPlayAnim", "guildCenterPanelInOrOut", "height", "onPostThemeChanged", "setTabHeight", "guildTab", "Lcom/tencent/mobileqq/guild/message/unread/api/IGuildUnreadCntService$b;", "tabUnreadCntInfo", "onTabChanged", "Landroid/view/View;", "view", "onGuildTabClick", "", "source", NodeProps.VISIBLE, "changeGuildFacadeVisible", "Lcom/tencent/mobileqq/guild/mainframe/i;", "Hh", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "th", "qh", "xh", "tabChanged", "wh", "vh", "yh", "rh", "gg", "isSwitchAccount", "md", "uh", "isInMultiWindowMode", "onMultiWindowModeChanged", "ph", "Landroid/content/Context;", "context", "onAttach", "onThemeChanged", "Oh", "Landroid/os/MessageQueue$IdleHandler;", "Fh", "Mh", "method", "Lkotlin/Lazy;", "Jh", "Nh", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/mainframe/i;", "mainViewContext", "Lcom/tencent/mobileqq/guild/mainframe/helper/j;", "D", "Lcom/tencent/mobileqq/guild/mainframe/helper/j;", "helperProvider", "E", "Lcom/tencent/mobileqq/guild/mainframe/startpanel/leftbar/GuildLeftBarListController;", "leftBarController", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/guild/mainframe/startpanel/rightpart/GuildStartPanelRightController;", "startPanelRightController", "G", "Lcom/tencent/mobileqq/guild/mainframe/centerpanel/GuildCenterPanelController;", "centerPanelController", "H", "Lvr1/a;", "endContainerController", "I", "Lsr1/d;", "guildChatFrameGestureManager", "Lcom/tencent/mobileqq/guild/mainframe/helper/GuildGuideAnimHelper;", "J", "Lcom/tencent/mobileqq/guild/mainframe/helper/GuildGuideAnimHelper;", "guildGuideAnimHelper", "K", "Lcom/tencent/mobileqq/activity/recent/cur/DragFrameLayout;", "dragFrame", "L", "Landroid/view/ViewGroup;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Ljava/util/LinkedHashMap;", "Lcom/tencent/mobileqq/guild/mainframe/t;", "Lkotlin/collections/LinkedHashMap;", "M", "Ljava/util/LinkedHashMap;", "controllers", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "hasDestroyed", "tabHeight", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Z", "firstWebPreloadingDone", "Lcom/tencent/mobileqq/guild/mainframe/GuildAppReportSourceInfo;", "reportSourceInfo", "Lcom/tencent/mobileqq/guild/mainframe/l;", ExifInterface.LATITUDE_SOUTH, "Lkotlin/Lazy;", "getGuildMainViewModel", "()Lcom/tencent/mobileqq/guild/mainframe/l;", "guildMainViewModel", "T", "inGuildTab", "Lcom/tencent/mobileqq/guild/mainframe/GuildMainFragment$PreloadWebRunnable;", "U", "Lcom/tencent/mobileqq/guild/mainframe/GuildMainFragment$PreloadWebRunnable;", "preloadWebRunnable", "V", "Landroid/os/MessageQueue$IdleHandler;", "preloadIdleHandler", "Lvp1/ax;", "W", "Lvp1/ax;", "secondaryFragmentBinding", "X", "isInited", "com/tencent/mobileqq/guild/mainframe/GuildMainFragment$b", "Y", "Lcom/tencent/mobileqq/guild/mainframe/GuildMainFragment$b;", "absGestureListener", "<init>", "()V", "a", "PreloadWebRunnable", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildMainFragment extends AbsGuildMainFragment implements com.tencent.mobileqq.guild.mainframe.c, SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: Z, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    private i mainViewContext;

    /* renamed from: D, reason: from kotlin metadata */
    private com.tencent.mobileqq.guild.mainframe.helper.j helperProvider;

    /* renamed from: E, reason: from kotlin metadata */
    private GuildLeftBarListController leftBarController;

    /* renamed from: F, reason: from kotlin metadata */
    private GuildStartPanelRightController startPanelRightController;

    /* renamed from: G, reason: from kotlin metadata */
    private GuildCenterPanelController centerPanelController;

    /* renamed from: H, reason: from kotlin metadata */
    private vr1.a endContainerController;

    /* renamed from: I, reason: from kotlin metadata */
    private sr1.d guildChatFrameGestureManager;

    /* renamed from: J, reason: from kotlin metadata */
    private GuildGuideAnimHelper guildGuideAnimHelper;

    /* renamed from: K, reason: from kotlin metadata */
    private DragFrameLayout dragFrame;

    /* renamed from: L, reason: from kotlin metadata */
    private ViewGroup rootView;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final LinkedHashMap<Class<? extends t>, t> controllers = new LinkedHashMap<>();

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final AtomicBoolean hasDestroyed = new AtomicBoolean(false);

    /* renamed from: P, reason: from kotlin metadata */
    private int tabHeight;

    /* renamed from: Q, reason: from kotlin metadata */
    private boolean firstWebPreloadingDone;

    /* renamed from: R, reason: from kotlin metadata */
    private GuildAppReportSourceInfo reportSourceInfo;

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    private final Lazy guildMainViewModel;

    /* renamed from: T, reason: from kotlin metadata */
    private boolean inGuildTab;

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    private PreloadWebRunnable preloadWebRunnable;

    /* renamed from: V, reason: from kotlin metadata */
    @NotNull
    private MessageQueue.IdleHandler preloadIdleHandler;

    /* renamed from: W, reason: from kotlin metadata */
    @Nullable
    private ax secondaryFragmentBinding;

    /* renamed from: X, reason: from kotlin metadata */
    private boolean isInited;

    /* renamed from: Y, reason: from kotlin metadata */
    @NotNull
    private final b absGestureListener;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\u0005\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R%\u0010\u000b\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/guild/mainframe/GuildMainFragment$PreloadWebRunnable;", "Ljava/lang/Runnable;", "", TencentLocation.RUN_MODE, "Lmqq/util/WeakReference;", "Lcom/tencent/mobileqq/guild/mainframe/GuildMainFragment;", "kotlin.jvm.PlatformType", "d", "Lmqq/util/WeakReference;", "getWeakRef", "()Lmqq/util/WeakReference;", "weakRef", "mainFragment", "<init>", "(Lcom/tencent/mobileqq/guild/mainframe/GuildMainFragment;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class PreloadWebRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final WeakReference<GuildMainFragment> weakRef;

        public PreloadWebRunnable(@NotNull GuildMainFragment mainFragment) {
            Intrinsics.checkNotNullParameter(mainFragment, "mainFragment");
            this.weakRef = new WeakReference<>(mainFragment);
        }

        @Override // java.lang.Runnable
        public void run() {
            GuildMainFragment guildMainFragment = this.weakRef.get();
            if (guildMainFragment != null) {
                Looper.myQueue().addIdleHandler(guildMainFragment.preloadIdleHandler);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\u0003\u001a\u00020\u0002H\u0007R\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/mainframe/GuildMainFragment$a;", "", "Lcom/tencent/mobileqq/guild/mainframe/GuildAppReportSourceInfo;", "a", "", "EXTRA_SHOW_GUIDE_ANIM", "Ljava/lang/String;", "TAG", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.mainframe.GuildMainFragment$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final GuildAppReportSourceInfo a() {
            GuildAppReportSourceInfo guildAppReportSourceInfo = new GuildAppReportSourceInfo();
            guildAppReportSourceInfo.addReportItem("sgrp_stream_pgin_source_name", "initiative");
            guildAppReportSourceInfo.addReportItem("sgrp_stream_pgin_into_source", "pg_sgrp_channel");
            guildAppReportSourceInfo.addReportItem("sgrp_channel_changetab_state", com.tencent.mobileqq.guild.report.e.a());
            guildAppReportSourceInfo.addReportItem("sgrp_channel_tab_state_number", com.tencent.mobileqq.guild.report.e.f232013a.b());
            return guildAppReportSourceInfo;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/mainframe/GuildMainFragment$b", "Lrr1/a;", "Lrr1/i;", "notifyData", "", "c", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b extends rr1.a {
        b() {
        }

        @Override // rr1.a
        public void c(@NotNull rr1.i notifyData) {
            Object obj;
            DialogFragment dialogFragment;
            Intrinsics.checkNotNullParameter(notifyData, "notifyData");
            if (GuildMainFragment.this.getActivity() != null) {
                FragmentActivity activity = GuildMainFragment.this.getActivity();
                boolean z16 = false;
                if (activity != null && activity.isFinishing()) {
                    z16 = true;
                }
                if (!z16) {
                    i iVar = null;
                    if (notifyData.f() == 3 && notifyData.a() == 3 && notifyData.c() != 3) {
                        FragmentActivity activity2 = GuildMainFragment.this.getActivity();
                        Intrinsics.checkNotNull(activity2);
                        List<Fragment> fragments = activity2.getSupportFragmentManager().getFragments();
                        Intrinsics.checkNotNullExpressionValue(fragments, "activity!!.supportFragmentManager.fragments");
                        Iterator<T> it = fragments.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                obj = it.next();
                                if (((Fragment) obj) instanceof DialogFragment) {
                                    break;
                                }
                            } else {
                                obj = null;
                                break;
                            }
                        }
                        if (obj instanceof DialogFragment) {
                            dialogFragment = (DialogFragment) obj;
                        } else {
                            dialogFragment = null;
                        }
                        if (dialogFragment != null) {
                            Logger.f235387a.d().d("AbsGestureListener", 1, "dismiss dialog: " + dialogFragment.getClass().getCanonicalName());
                            dialogFragment.dismissAllowingStateLoss();
                        }
                    }
                    if (AppSetting.t(GuildMainFragment.this.requireContext()) && notifyData.f() == 3) {
                        if ((notifyData.c() == 1 || notifyData.c() == 2) && !GuildMainFragment.this.P()) {
                            Logger.f235387a.d().d("AbsGestureListener", 1, "onNotify, GuildSecondaryFragment is null, launch it");
                            GuildSecondaryFragment.Companion companion = GuildSecondaryFragment.INSTANCE;
                            i iVar2 = GuildMainFragment.this.mainViewContext;
                            if (iVar2 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("mainViewContext");
                            } else {
                                iVar = iVar2;
                            }
                            companion.e(iVar);
                        }
                    }
                }
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"com/tencent/mobileqq/guild/mainframe/GuildMainFragment$c", "Landroidx/fragment/app/FragmentManager;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c extends FragmentManager {
        c() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"com/tencent/mobileqq/guild/mainframe/GuildMainFragment$d", "Landroidx/fragment/app/FragmentManager;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class d extends FragmentManager {
        d() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/mainframe/GuildMainFragment$e", "Landroidx/fragment/app/FragmentContainer;", "", "id", "Landroid/view/View;", "onFindViewById", "", "onHasView", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class e extends FragmentContainer {
        e() {
        }

        @Override // androidx.fragment.app.FragmentContainer
        @NotNull
        public View onFindViewById(int id5) {
            View view = GuildMainFragment.this.getView();
            if (view != null) {
                View view2 = null;
                if (id5 == R.id.tub) {
                    ax c16 = GuildSecondaryFragment.INSTANCE.c();
                    if (c16 != null) {
                        view2 = c16.f442332b;
                    }
                    if (view2 == null) {
                        View findViewById = view.findViewById(id5);
                        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(id)");
                        return findViewById;
                    }
                    return view2;
                }
                if (id5 == R.id.uvi) {
                    ax c17 = GuildSecondaryFragment.INSTANCE.c();
                    if (c17 != null) {
                        view2 = c17.f442333c;
                    }
                    if (view2 == null) {
                        View findViewById2 = view.findViewById(id5);
                        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(id)");
                        return findViewById2;
                    }
                    return view2;
                }
                View findViewById3 = view.findViewById(id5);
                Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(id)");
                return findViewById3;
            }
            throw new IllegalStateException(("Fragment " + this + " does not have a view").toString());
        }

        @Override // androidx.fragment.app.FragmentContainer
        public boolean onHasView() {
            if (GuildMainFragment.this.getView() != null) {
                return true;
            }
            return false;
        }
    }

    public GuildMainFragment() {
        l.Companion companion = l.INSTANCE;
        final Function0<ViewModelStoreOwner> function0 = new Function0<ViewModelStoreOwner>() { // from class: com.tencent.mobileqq.guild.mainframe.GuildMainViewModel$Store$shared$1

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n\u00a2\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelStore;", "T", "Landroidx/lifecycle/ViewModel;", "getViewModelStore"}, k = 3, mv = {1, 7, 1}, xi = 176)
            /* loaded from: classes14.dex */
            public static final class a implements ViewModelStoreOwner {

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ Fragment f227283d;

                public a(Fragment fragment) {
                    this.f227283d = fragment;
                }

                @Override // androidx.lifecycle.ViewModelStoreOwner
                @NotNull
                /* renamed from: getViewModelStore */
                public final ViewModelStore get_viewModelStore() {
                    ViewModelStore putIfAbsent;
                    int hashCode = this.f227283d.requireActivity().hashCode();
                    Logger logger = Logger.f235387a;
                    Fragment fragment = this.f227283d;
                    logger.d().i("Guild.comm.GuildMainViewModel", 1, "retrieveStore, key=" + hashCode + ", fragment=" + fragment.hashCode() + " " + fragment.getClass().getCanonicalName());
                    ConcurrentHashMap<Integer, ViewModelStore> b16 = l.INSTANCE.b();
                    Integer valueOf = Integer.valueOf(hashCode);
                    ViewModelStore viewModelStore = b16.get(valueOf);
                    if (viewModelStore == null && (putIfAbsent = b16.putIfAbsent(valueOf, (viewModelStore = new ViewModelStore()))) != null) {
                        viewModelStore = putIfAbsent;
                    }
                    return viewModelStore;
                }
            }

            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ViewModelStoreOwner invoke() {
                return new a(Fragment.this);
            }
        };
        this.guildMainViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(l.class), new Function0<ViewModelStore>() { // from class: com.tencent.mobileqq.guild.mainframe.GuildMainViewModel$Store$shared$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = ((ViewModelStoreOwner) Function0.this.invoke()).get_viewModelStore();
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "ownerProducer().viewModelStore");
                return viewModelStore;
            }
        }, null);
        this.preloadWebRunnable = new PreloadWebRunnable(this);
        this.preloadIdleHandler = Fh();
        this.absGestureListener = new b();
    }

    private final MessageQueue.IdleHandler Fh() {
        return new MessageQueue.IdleHandler() { // from class: com.tencent.mobileqq.guild.mainframe.g
            @Override // android.os.MessageQueue.IdleHandler
            public final boolean queueIdle() {
                boolean Gh;
                Gh = GuildMainFragment.Gh(GuildMainFragment.this);
                return Gh;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Gh(GuildMainFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.firstWebPreloadingDone = true;
        ((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).preloadWebProcess();
        return false;
    }

    @JvmStatic
    @NotNull
    public static final GuildAppReportSourceInfo Ih() {
        return INSTANCE.a();
    }

    private final Lazy<String> Jh(String method) {
        return GuildDebugUtils.f235333a.c(this, "Guild.MF.GuildMainFragment", method);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Lh(DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
    }

    private final void Mh() {
        Object m476constructorimpl;
        Object m476constructorimpl2;
        GuildDebugUtils guildDebugUtils = GuildDebugUtils.f235333a;
        Lazy<String> Jh = Jh("realDestroy");
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("GUILD_DEBUG", 2, ((Object) Jh.getValue()) + " begin...");
        }
        TraceUtils.h(Jh.getValue());
        ViewGroup viewGroup = null;
        if (!this.isInited) {
            Logger.b bVar = new Logger.b();
            bVar.a().add("realDestroy isInited is false");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.MF.GuildMainFragment", 1, (String) it.next(), null);
            }
        } else {
            for (Map.Entry<Class<? extends t>, t> entry : this.controllers.entrySet()) {
                Class<? extends t> key = entry.getKey();
                t value = entry.getValue();
                try {
                    Result.Companion companion = Result.INSTANCE;
                    value.onDestroy();
                    m476constructorimpl2 = Result.m476constructorimpl(Unit.INSTANCE);
                } catch (Throwable th5) {
                    Result.Companion companion2 = Result.INSTANCE;
                    m476constructorimpl2 = Result.m476constructorimpl(ResultKt.createFailure(th5));
                }
                Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl2);
                if (m479exceptionOrNullimpl != null) {
                    Logger logger2 = Logger.f235387a;
                    Logger.b bVar2 = new Logger.b();
                    String str = "realDestroy error controller[" + key + "] " + m479exceptionOrNullimpl.getMessage();
                    if (str instanceof String) {
                        bVar2.a().add(str);
                    }
                    Iterator<T> it5 = bVar2.a().iterator();
                    while (it5.hasNext()) {
                        Logger.f235387a.d().e("Guild.MF.GuildMainFragment", 1, (String) it5.next(), m479exceptionOrNullimpl);
                    }
                }
            }
            try {
                Result.Companion companion3 = Result.INSTANCE;
                sr1.d dVar = this.guildChatFrameGestureManager;
                if (dVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("guildChatFrameGestureManager");
                    dVar = null;
                }
                dVar.onDestroy();
                f12.o.f397685a.c();
                GuildSecondaryFragment.Companion companion4 = GuildSecondaryFragment.INSTANCE;
                i b16 = companion4.b();
                i iVar = this.mainViewContext;
                if (iVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mainViewContext");
                    iVar = null;
                }
                if (b16 == iVar) {
                    companion4.g(null);
                }
                l.Companion companion5 = l.INSTANCE;
                FragmentActivity requireActivity = requireActivity();
                Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
                companion5.a(requireActivity);
                ViewGroup viewGroup2 = this.rootView;
                if (viewGroup2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
                } else {
                    viewGroup = viewGroup2;
                }
                viewGroup.removeCallbacks(this.preloadWebRunnable);
                Looper.myQueue().removeIdleHandler(this.preloadIdleHandler);
                Logger.f235387a.d().i("Guild.MF.GuildMainFragment", 1, "realDestroy finish removeRunnable / removeHandle");
                m476constructorimpl = Result.m476constructorimpl(Unit.INSTANCE);
            } catch (Throwable th6) {
                Result.Companion companion6 = Result.INSTANCE;
                m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th6));
            }
            Throwable m479exceptionOrNullimpl2 = Result.m479exceptionOrNullimpl(m476constructorimpl);
            if (m479exceptionOrNullimpl2 != null) {
                Logger logger3 = Logger.f235387a;
                Logger.b bVar3 = new Logger.b();
                bVar3.a().add("realDestroy error");
                Iterator<T> it6 = bVar3.a().iterator();
                while (it6.hasNext()) {
                    Logger.f235387a.d().e("Guild.MF.GuildMainFragment", 1, (String) it6.next(), m479exceptionOrNullimpl2);
                }
            }
        }
        Unit unit = Unit.INSTANCE;
        Logger logger4 = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger4.d().d("GUILD_DEBUG", 2, ((Object) Jh.getValue()) + " end...");
        }
        TraceUtils.k();
    }

    private final void Nh() {
        e eVar = new e();
        FragmentUtils fragmentUtils = FragmentUtils.f235325a;
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        fragmentUtils.b(childFragmentManager, eVar);
    }

    private final void Oh() {
        SimpleUIUtil.adjustSimpleStatusBar((ImmersiveTitleBar2) null, requireActivity().getWindow());
        boolean z16 = !GuildThemeManager.f235286a.b();
        Window window = requireActivity().getWindow();
        Intrinsics.checkNotNullExpressionValue(window, "requireActivity().window");
        GuildThemeManager.i(z16, window);
    }

    private final void onThemeChanged() {
        Oh();
        ViewGroup viewGroup = this.rootView;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            viewGroup = null;
        }
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        viewGroup.setBackground(bc.b(requireContext, R.drawable.qui_common_bg_bottom_standard_bg));
    }

    @Override // com.tencent.mobileqq.guild.mainframe.c
    @NotNull
    public GuildLeftBarListController C1() {
        GuildLeftBarListController guildLeftBarListController = this.leftBarController;
        if (guildLeftBarListController == null) {
            Intrinsics.throwUninitializedPropertyAccessException("leftBarController");
            return null;
        }
        return guildLeftBarListController;
    }

    @NotNull
    public final i Hh() {
        i iVar = this.mainViewContext;
        if (iVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainViewContext");
            return null;
        }
        return iVar;
    }

    @Override // androidx.fragment.app.Fragment
    @NotNull
    /* renamed from: Kh, reason: merged with bridge method [inline-methods] */
    public ViewGroup onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        ViewGroup viewGroup3;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        GuildDebugUtils guildDebugUtils = GuildDebugUtils.f235333a;
        Lazy<String> Jh = Jh("onCreateView");
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("GUILD_DEBUG", 2, ((Object) Jh.getValue()) + " begin...");
        }
        TraceUtils.h(Jh.getValue());
        logger.d().i("Guild.MF.GuildMainFragment", 1, "onCreateView " + hashCode());
        com.tencent.mobileqq.guild.mainframe.util.j.c("KEY_MAIN_FRAGMENT_CREATE");
        View inflate = inflater.inflate(R.layout.esc, container, false);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup4 = (ViewGroup) inflate;
        this.rootView = viewGroup4;
        ViewGroup viewGroup5 = null;
        if (viewGroup4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            viewGroup4 = null;
        }
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        viewGroup4.setBackground(bc.b(requireContext, R.drawable.qui_common_bg_bottom_standard_bg));
        ViewGroup viewGroup6 = this.rootView;
        if (viewGroup6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            viewGroup6 = null;
        }
        View findViewById = viewGroup6.findViewById(R.id.ulm);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.dragframe)");
        this.dragFrame = (DragFrameLayout) findViewById;
        if (!this.isInited) {
            Logger.b bVar = new Logger.b();
            bVar.a().add("onCreateView isInited is false");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.MF.GuildMainFragment", 1, (String) it.next(), null);
            }
            viewGroup3 = this.rootView;
            if (viewGroup3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            }
            viewGroup5 = viewGroup3;
        } else {
            if (AppSetting.t(getContext())) {
                logger.d().i("Guild.MF.GuildMainFragment", 1, "create secondaryBinding");
                ax g16 = ax.g(inflater, container, false);
                Intrinsics.checkNotNullExpressionValue(g16, "inflate(inflater, container, false)");
                GuildSecondaryFragment.INSTANCE.h(g16);
                this.secondaryFragmentBinding = g16;
                View findViewById2 = g16.getRoot().findViewById(R.id.tub);
                Intrinsics.checkNotNullExpressionValue(findViewById2, "secondaryBinding.root.findViewById(R.id.chatframe)");
                viewGroup = (ViewGroup) findViewById2;
                View findViewById3 = g16.getRoot().findViewById(R.id.uvi);
                Intrinsics.checkNotNullExpressionValue(findViewById3, "secondaryBinding.root.findViewById(R.id.end_page)");
                viewGroup2 = (ViewGroup) findViewById3;
                ViewGroup viewGroup7 = this.rootView;
                if (viewGroup7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
                    viewGroup7 = null;
                }
                viewGroup7.addView(g16.getRoot());
                ViewGroup viewGroup8 = this.rootView;
                if (viewGroup8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
                    viewGroup8 = null;
                }
                GuildMainFrameLayout guildMainFrameLayout = viewGroup8 instanceof GuildMainFrameLayout ? (GuildMainFrameLayout) viewGroup8 : null;
                if (guildMainFrameLayout != null) {
                    guildMainFrameLayout.setInterceptTouchDisabled(true);
                }
                sr1.d dVar = this.guildChatFrameGestureManager;
                if (dVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("guildChatFrameGestureManager");
                    dVar = null;
                }
                GuildMainFrameLayout root = g16.getRoot();
                DragFrameLayout dragFrameLayout = this.dragFrame;
                if (dragFrameLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("dragFrame");
                    dragFrameLayout = null;
                }
                dVar.k(root, dragFrameLayout, viewGroup, viewGroup2);
            } else {
                logger.d().i("Guild.MF.GuildMainFragment", 1, "didn't create secondaryBinding");
                ViewGroup viewGroup9 = this.rootView;
                if (viewGroup9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
                    viewGroup9 = null;
                }
                View findViewById4 = viewGroup9.findViewById(R.id.tub);
                Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.id.chatframe)");
                viewGroup = (ViewGroup) findViewById4;
                ViewGroup viewGroup10 = this.rootView;
                if (viewGroup10 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
                    viewGroup10 = null;
                }
                View findViewById5 = viewGroup10.findViewById(R.id.uvi);
                Intrinsics.checkNotNullExpressionValue(findViewById5, "rootView.findViewById(R.id.end_page)");
                viewGroup2 = (ViewGroup) findViewById5;
                sr1.d dVar2 = this.guildChatFrameGestureManager;
                if (dVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("guildChatFrameGestureManager");
                    dVar2 = null;
                }
                ViewGroup viewGroup11 = this.rootView;
                if (viewGroup11 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
                    viewGroup11 = null;
                }
                DragFrameLayout dragFrameLayout2 = this.dragFrame;
                if (dragFrameLayout2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("dragFrame");
                    dragFrameLayout2 = null;
                }
                dVar2.k(viewGroup11, dragFrameLayout2, viewGroup, viewGroup2);
            }
            GuildStartPanelRightController guildStartPanelRightController = this.startPanelRightController;
            if (guildStartPanelRightController == null) {
                Intrinsics.throwUninitializedPropertyAccessException("startPanelRightController");
                guildStartPanelRightController = null;
            }
            ViewGroup viewGroup12 = this.rootView;
            if (viewGroup12 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
                viewGroup12 = null;
            }
            guildStartPanelRightController.h(viewGroup12.findViewById(R.id.wp8));
            GuildLeftBarListController guildLeftBarListController = this.leftBarController;
            if (guildLeftBarListController == null) {
                Intrinsics.throwUninitializedPropertyAccessException("leftBarController");
                guildLeftBarListController = null;
            }
            ViewGroup viewGroup13 = this.rootView;
            if (viewGroup13 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
                viewGroup13 = null;
            }
            View findViewById6 = viewGroup13.findViewById(R.id.yhp);
            Intrinsics.checkNotNullExpressionValue(findViewById6, "rootView.findViewById(R.id.leftbar)");
            guildLeftBarListController.h(findViewById6);
            GuildCenterPanelController guildCenterPanelController = this.centerPanelController;
            if (guildCenterPanelController == null) {
                Intrinsics.throwUninitializedPropertyAccessException("centerPanelController");
                guildCenterPanelController = null;
            }
            guildCenterPanelController.h(viewGroup);
            vr1.a aVar = this.endContainerController;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("endContainerController");
                aVar = null;
            }
            aVar.h(viewGroup2);
            GuildGuideAnimHelper guildGuideAnimHelper = this.guildGuideAnimHelper;
            if (guildGuideAnimHelper == null) {
                Intrinsics.throwUninitializedPropertyAccessException("guildGuideAnimHelper");
                guildGuideAnimHelper = null;
            }
            ViewGroup viewGroup14 = this.rootView;
            if (viewGroup14 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
                viewGroup14 = null;
            }
            View findViewById7 = viewGroup14.findViewById(R.id.wsc);
            Intrinsics.checkNotNullExpressionValue(findViewById7, "rootView.findViewById(R.\u2026new_video_anim_container)");
            guildGuideAnimHelper.h(findViewById7);
            ViewGroup viewGroup15 = this.rootView;
            if (viewGroup15 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
                viewGroup15 = null;
            }
            viewGroup15.postDelayed(this.preloadWebRunnable, 30000L);
            SimpleEventBus.getInstance().registerReceiver(this);
            sr1.d dVar3 = this.guildChatFrameGestureManager;
            if (dVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("guildChatFrameGestureManager");
                dVar3 = null;
            }
            dVar3.addGestureListener(this.absGestureListener);
            viewGroup3 = this.rootView;
            if (viewGroup3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            }
            viewGroup5 = viewGroup3;
        }
        Logger logger2 = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger2.d().d("GUILD_DEBUG", 2, ((Object) Jh.getValue()) + " end...");
        }
        TraceUtils.k();
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, viewGroup5);
        return viewGroup5;
    }

    @Override // com.tencent.mobileqq.guild.mainframe.c
    @NotNull
    public sr1.d N() {
        sr1.d dVar = this.guildChatFrameGestureManager;
        if (dVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildChatFrameGestureManager");
            return null;
        }
        return dVar;
    }

    @Override // com.tencent.mobileqq.guild.mainframe.c
    public boolean P() {
        return GuildSecondaryFragment.INSTANCE.a();
    }

    @Override // com.tencent.mobileqq.guild.mainframe.c
    public void R(@NotNull GuildAppReportSourceInfo sourceInfo) {
        Intrinsics.checkNotNullParameter(sourceInfo, "sourceInfo");
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.MF.GuildMainFragment", 2, "setReportSourceInfo to " + sourceInfo + "}");
        }
        this.reportSourceInfo = sourceInfo;
    }

    @Override // com.tencent.mobileqq.guild.mainframe.c
    @NotNull
    public FragmentManager Rc() {
        if (isDetached()) {
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("Guild.MF.GuildMainFragment", 2, "getGuildFragmentManager, return NullObject FragmentManager");
            }
            return new c();
        }
        if (!isAdded()) {
            com.tencent.mobileqq.guild.util.s.f("Guild.MF.GuildMainFragment", "getGuildFragmentManager, fail", new IllegalStateException("GuildMainFragment isAdded = false, return NullObject FragmentManager!"));
            return new d();
        }
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        return childFragmentManager;
    }

    @Override // com.tencent.mobileqq.guild.mainframe.c
    @NotNull
    public GuildCenterPanelController Z0() {
        GuildCenterPanelController guildCenterPanelController = this.centerPanelController;
        if (guildCenterPanelController == null) {
            Intrinsics.throwUninitializedPropertyAccessException("centerPanelController");
            return null;
        }
        return guildCenterPanelController;
    }

    @Override // com.tencent.mobileqq.guild.mainframe.s
    public void changeGuildFacadeVisible(@NotNull String source, boolean visible) {
        boolean z16;
        Intrinsics.checkNotNullParameter(source, "source");
        if (AppSetting.t(getContext())) {
            return;
        }
        if (isDetached()) {
            Logger.f235387a.d().w("Guild.MF.GuildMainFragment", 1, "notifyGuildFrameVisibleChanged[" + source + "]: " + visible + " fragment is detached");
            return;
        }
        Logger.a d16 = Logger.f235387a.d();
        int i3 = 0;
        if (this.rootView != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        d16.i("Guild.MF.GuildMainFragment", 1, "notifyGuildFrameVisibleChanged[" + source + "]: " + visible + " " + z16);
        ViewGroup viewGroup = this.rootView;
        if (viewGroup != null) {
            if (viewGroup == null) {
                Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
                viewGroup = null;
            }
            View findViewById = viewGroup.findViewById(R.id.f165215v73);
            Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type android.view.View");
            if (!visible) {
                i3 = 8;
            }
            findViewById.setVisibility(i3);
        }
    }

    @Override // com.tencent.mobileqq.guild.mainframe.c
    @NotNull
    public vr1.a d1() {
        vr1.a aVar = this.endContainerController;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("endContainerController");
            return null;
        }
        return aVar;
    }

    @Override // com.tencent.mobileqq.guild.mainframe.c
    @NotNull
    public GuildStartPanelRightController e1() {
        GuildStartPanelRightController guildStartPanelRightController = this.startPanelRightController;
        if (guildStartPanelRightController == null) {
            Intrinsics.throwUninitializedPropertyAccessException("startPanelRightController");
            return null;
        }
        return guildStartPanelRightController;
    }

    @Override // com.tencent.mobileqq.guild.mainframe.c
    @NotNull
    public GuildAppReportSourceInfo f0() {
        GuildAppReportSourceInfo guildAppReportSourceInfo = this.reportSourceInfo;
        if (guildAppReportSourceInfo == null) {
            Intrinsics.throwUninitializedPropertyAccessException("reportSourceInfo");
            return null;
        }
        return guildAppReportSourceInfo;
    }

    @Override // com.tencent.mobileqq.guild.mainframe.c
    public /* bridge */ /* synthetic */ Activity getActivity() {
        return getActivity();
    }

    @Override // com.tencent.mobileqq.guild.mainframe.c
    @NotNull
    public AppRuntime getApp() {
        AppRuntime m3 = ch.m();
        Intrinsics.checkNotNullExpressionValue(m3, "appRuntime()");
        return m3;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(GuildMainAlertEvent.class, GuildJumpLeftNodeEvent.class, GuildJumpNextUnreadNodeEvent.class);
        return arrayListOf;
    }

    @Override // com.tencent.mobileqq.guild.mainframe.c
    @Nullable
    public Object getHelper(int type) {
        com.tencent.mobileqq.guild.mainframe.helper.j jVar = this.helperProvider;
        if (jVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("helperProvider");
            jVar = null;
        }
        return jVar.i(type);
    }

    @Override // com.tencent.mobileqq.guild.mainframe.c
    @NotNull
    public LifecycleOwner getLifecycleOwner() {
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
        return viewLifecycleOwner;
    }

    @Override // com.tencent.mobileqq.guild.mainframe.c
    @NotNull
    public ViewGroup getRootView() {
        ViewGroup viewGroup = this.rootView;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            return null;
        }
        return viewGroup;
    }

    @Override // com.tencent.mobileqq.guild.mainframe.AbsGuildMainFragment
    public void gg() {
        GuildDebugUtils guildDebugUtils = GuildDebugUtils.f235333a;
        Lazy<String> Jh = Jh("notifyBeforeAccountChanged()");
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("GUILD_DEBUG", 2, ((Object) Jh.getValue()) + " begin...");
        }
        TraceUtils.h(Jh.getValue());
        Iterator<Map.Entry<Class<? extends t>, t>> it = this.controllers.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().onBeforeAccountChanged();
        }
        Unit unit = Unit.INSTANCE;
        Logger logger2 = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger2.d().d("GUILD_DEBUG", 2, ((Object) Jh.getValue()) + " end...");
        }
        TraceUtils.k();
    }

    @Override // com.tencent.mobileqq.guild.mainframe.s
    public void guildCenterPanelInOrOut(int showType, boolean isPlayAnim) {
        GuildCenterPanelController guildCenterPanelController = null;
        if (isPlayAnim) {
            GuildCenterPanelController guildCenterPanelController2 = this.centerPanelController;
            if (guildCenterPanelController2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("centerPanelController");
            } else {
                guildCenterPanelController = guildCenterPanelController2;
            }
            guildCenterPanelController.z(showType);
            return;
        }
        GuildCenterPanelController guildCenterPanelController3 = this.centerPanelController;
        if (guildCenterPanelController3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("centerPanelController");
        } else {
            guildCenterPanelController = guildCenterPanelController3;
        }
        guildCenterPanelController.y(showType);
    }

    @Override // com.tencent.mobileqq.guild.mainframe.s
    public void handleJumpAction(@Nullable Bundle extra) {
        com.tencent.mobileqq.guild.mainframe.helper.j jVar = null;
        if (!this.isInited) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            bVar.a().add("handleJumpAction isInited is false");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.MF.GuildMainFragment", 1, (String) it.next(), null);
            }
            return;
        }
        if (!isAdded()) {
            Logger logger2 = Logger.f235387a;
            Logger.b bVar2 = new Logger.b();
            bVar2.a().add("handleJumpAction isAdded is false");
            Iterator<T> it5 = bVar2.a().iterator();
            while (it5.hasNext()) {
                Logger.f235387a.d().e("Guild.MF.GuildMainFragment", 1, (String) it5.next(), null);
            }
            return;
        }
        SimpleEventBus.getInstance().dispatchEvent(new GuildBottomSheetDialogDismissEvent());
        com.tencent.mobileqq.guild.mainframe.helper.j jVar2 = this.helperProvider;
        if (jVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("helperProvider");
        } else {
            jVar = jVar2;
        }
        Object i3 = jVar.i(GuildMainFrameConstants.f227258b);
        Intrinsics.checkNotNull(i3, "null cannot be cast to non-null type com.tencent.mobileqq.guild.mainframe.helper.GuildMFJumpHelper");
        ((com.tencent.mobileqq.guild.mainframe.helper.e) i3).i(extra);
    }

    @Override // com.tencent.mobileqq.guild.mainframe.c
    @NotNull
    public DragFrameLayout jh() {
        DragFrameLayout dragFrameLayout = this.dragFrame;
        if (dragFrameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dragFrame");
            return null;
        }
        return dragFrameLayout;
    }

    @Override // com.tencent.mobileqq.guild.mainframe.AbsGuildMainFragment
    public void md(boolean isSwitchAccount) {
        GuildDebugUtils guildDebugUtils = GuildDebugUtils.f235333a;
        Lazy<String> Jh = Jh("notifyAfterAccountChanged(" + isSwitchAccount + ")");
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("GUILD_DEBUG", 2, ((Object) Jh.getValue()) + " begin...");
        }
        TraceUtils.h(Jh.getValue());
        Iterator<Map.Entry<Class<? extends t>, t>> it = this.controllers.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().b(isSwitchAccount);
        }
        Unit unit = Unit.INSTANCE;
        Logger logger2 = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger2.d().d("GUILD_DEBUG", 2, ((Object) Jh.getValue()) + " end...");
        }
        TraceUtils.k();
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (!AppSetting.t(context)) {
            super.onAttach(context);
        } else {
            Nh();
            super.onAttach(context);
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        GuildDragFrameLayout guildDragFrameLayout;
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        i iVar = null;
        if (!this.isInited) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            bVar.a().add("onConfigurationChanged isInited is false");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.MF.GuildMainFragment", 1, (String) it.next(), null);
            }
            return;
        }
        super.onConfigurationChanged(newConfig);
        Logger logger2 = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger2.d().d("Guild.MF.GuildMainFragment", 2, "onConfigurationChanged,  newConfig:" + newConfig);
        }
        GlobalDisplayMetricsManager.adjustDisplayMetrics(getActivity());
        FontSettingManager.resetFontIfNeeded(getActivity(), true, false);
        DragFrameLayout dragFrameLayout = this.dragFrame;
        if (dragFrameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dragFrame");
            dragFrameLayout = null;
        }
        if (dragFrameLayout instanceof GuildDragFrameLayout) {
            guildDragFrameLayout = (GuildDragFrameLayout) dragFrameLayout;
        } else {
            guildDragFrameLayout = null;
        }
        if (guildDragFrameLayout != null) {
            guildDragFrameLayout.l();
        }
        sr1.d dVar = this.guildChatFrameGestureManager;
        if (dVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildChatFrameGestureManager");
            dVar = null;
        }
        dVar.onConfigurationChanged(newConfig);
        ((IGuildUtilApi) QRoute.api(IGuildUtilApi.class)).onConfigurationChanged(newConfig);
        IGuildTempApi iGuildTempApi = (IGuildTempApi) QRoute.api(IGuildTempApi.class);
        i iVar2 = this.mainViewContext;
        if (iVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainViewContext");
        } else {
            iVar = iVar2;
        }
        iGuildTempApi.adjustTab(iVar.getActivity());
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Map<String, String> mapOf;
        GuildDebugUtils guildDebugUtils = GuildDebugUtils.f235333a;
        Lazy<String> Jh = Jh("onCreate");
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("GUILD_DEBUG", 2, ((Object) Jh.getValue()) + " begin...");
        }
        TraceUtils.h(Jh.getValue());
        try {
            TraceUtils.h("Guild.MainUi.OnCreate.");
            super.onCreate(com.tencent.mobileqq.guild.base.extension.c.a(savedInstanceState));
            logger.d().i("Guild.MF.GuildMainFragment", 1, "Guild cost, GuildMainFragment start create!");
            j jVar = new j(this);
            this.mainViewContext = jVar;
            GuildSecondaryFragment.INSTANCE.g(jVar);
            TraceUtils traceUtils = TraceUtils.f235403a;
            GuildAppReportSourceInfo guildAppReportSourceInfo = null;
            if (!TraceUtils.m()) {
                traceUtils.l();
                LayoutLoaders layoutLoaders = LayoutLoaders.f214751a;
                i iVar = this.mainViewContext;
                if (iVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mainViewContext");
                    iVar = null;
                }
                QBaseActivity activity = iVar.getActivity();
                Intrinsics.checkNotNullExpressionValue(activity, "mainViewContext.activity");
                layoutLoaders.j(activity);
                i iVar2 = this.mainViewContext;
                if (iVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mainViewContext");
                    iVar2 = null;
                }
                QBaseActivity activity2 = iVar2.getActivity();
                Intrinsics.checkNotNullExpressionValue(activity2, "mainViewContext.activity");
                layoutLoaders.i(activity2);
            } else {
                try {
                    cy.c("Guild.MainUi.OnCreate.preloadViewItems");
                    LayoutLoaders layoutLoaders2 = LayoutLoaders.f214751a;
                    i iVar3 = this.mainViewContext;
                    if (iVar3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mainViewContext");
                        iVar3 = null;
                    }
                    QBaseActivity activity3 = iVar3.getActivity();
                    Intrinsics.checkNotNullExpressionValue(activity3, "mainViewContext.activity");
                    layoutLoaders2.j(activity3);
                    i iVar4 = this.mainViewContext;
                    if (iVar4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mainViewContext");
                        iVar4 = null;
                    }
                    QBaseActivity activity4 = iVar4.getActivity();
                    Intrinsics.checkNotNullExpressionValue(activity4, "mainViewContext.activity");
                    layoutLoaders2.i(activity4);
                    Unit unit = Unit.INSTANCE;
                } finally {
                    cy.d();
                }
            }
            i iVar5 = this.mainViewContext;
            if (iVar5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mainViewContext");
                iVar5 = null;
            }
            this.helperProvider = new com.tencent.mobileqq.guild.mainframe.helper.j(iVar5);
            i iVar6 = this.mainViewContext;
            if (iVar6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mainViewContext");
                iVar6 = null;
            }
            this.leftBarController = new GuildLeftBarListController(iVar6);
            i iVar7 = this.mainViewContext;
            if (iVar7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mainViewContext");
                iVar7 = null;
            }
            this.startPanelRightController = new GuildStartPanelRightController(iVar7);
            i iVar8 = this.mainViewContext;
            if (iVar8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mainViewContext");
                iVar8 = null;
            }
            this.centerPanelController = new GuildCenterPanelController(iVar8);
            i iVar9 = this.mainViewContext;
            if (iVar9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mainViewContext");
                iVar9 = null;
            }
            this.endContainerController = new vr1.a(iVar9);
            i iVar10 = this.mainViewContext;
            if (iVar10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mainViewContext");
                iVar10 = null;
            }
            this.guildChatFrameGestureManager = new sr1.g(iVar10);
            i iVar11 = this.mainViewContext;
            if (iVar11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mainViewContext");
                iVar11 = null;
            }
            Object helper = iVar11.getHelper(GuildMainFrameConstants.f227266j);
            Intrinsics.checkNotNullExpressionValue(helper, "mainViewContext.getHelpe\u2026.GUILD_GUIDE_ANIM_HELPER)");
            this.guildGuideAnimHelper = (GuildGuideAnimHelper) helper;
            if (o02.c.a() != null) {
                GuildAppReportSourceInfo a16 = o02.c.a();
                Intrinsics.checkNotNull(a16);
                this.reportSourceInfo = a16;
            } else if (SystemClock.uptimeMillis() - GuildAppReportSourceInfo.getAppStartTime() < 10000) {
                GuildAppReportSourceInfo guildAppReportSourceInfo2 = new GuildAppReportSourceInfo("restart", "pg_sgrp_channel");
                this.reportSourceInfo = guildAppReportSourceInfo2;
                guildAppReportSourceInfo2.addReportItem("sgrp_channel_changetab_state", com.tencent.mobileqq.guild.report.e.a());
                GuildAppReportSourceInfo guildAppReportSourceInfo3 = this.reportSourceInfo;
                if (guildAppReportSourceInfo3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("reportSourceInfo");
                    guildAppReportSourceInfo3 = null;
                }
                guildAppReportSourceInfo3.addReportItem("sgrp_channel_tab_state_number", com.tencent.mobileqq.guild.report.e.f232013a.b());
            } else {
                this.reportSourceInfo = new GuildAppReportSourceInfo();
            }
            ch.i0();
            LinkedHashMap<Class<? extends t>, t> linkedHashMap = this.controllers;
            com.tencent.mobileqq.guild.mainframe.helper.j jVar2 = this.helperProvider;
            if (jVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("helperProvider");
                jVar2 = null;
            }
            linkedHashMap.put(com.tencent.mobileqq.guild.mainframe.helper.j.class, jVar2);
            LinkedHashMap<Class<? extends t>, t> linkedHashMap2 = this.controllers;
            GuildLeftBarListController guildLeftBarListController = this.leftBarController;
            if (guildLeftBarListController == null) {
                Intrinsics.throwUninitializedPropertyAccessException("leftBarController");
                guildLeftBarListController = null;
            }
            linkedHashMap2.put(GuildLeftBarListController.class, guildLeftBarListController);
            LinkedHashMap<Class<? extends t>, t> linkedHashMap3 = this.controllers;
            GuildStartPanelRightController guildStartPanelRightController = this.startPanelRightController;
            if (guildStartPanelRightController == null) {
                Intrinsics.throwUninitializedPropertyAccessException("startPanelRightController");
                guildStartPanelRightController = null;
            }
            linkedHashMap3.put(GuildStartPanelRightController.class, guildStartPanelRightController);
            LinkedHashMap<Class<? extends t>, t> linkedHashMap4 = this.controllers;
            GuildCenterPanelController guildCenterPanelController = this.centerPanelController;
            if (guildCenterPanelController == null) {
                Intrinsics.throwUninitializedPropertyAccessException("centerPanelController");
                guildCenterPanelController = null;
            }
            linkedHashMap4.put(GuildCenterPanelController.class, guildCenterPanelController);
            LinkedHashMap<Class<? extends t>, t> linkedHashMap5 = this.controllers;
            vr1.a aVar = this.endContainerController;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("endContainerController");
                aVar = null;
            }
            linkedHashMap5.put(vr1.a.class, aVar);
            TraceUtils.k();
            bh.f235466a.a(false);
            GuildMainFrameManager.f227469a.n(this);
            Logger.a d16 = logger.d();
            boolean b16 = GuildThemeManager.f235286a.b();
            GuildAppReportSourceInfo guildAppReportSourceInfo4 = this.reportSourceInfo;
            if (guildAppReportSourceInfo4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("reportSourceInfo");
            } else {
                guildAppReportSourceInfo = guildAppReportSourceInfo4;
            }
            d16.i("Guild.MF.GuildMainFragment", 1, "currentNightTheme: " + b16 + " reportSourceInfo=" + guildAppReportSourceInfo);
            this.isInited = true;
        } catch (Exception e16) {
            Logger logger2 = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            bVar.a().add("onCreate error");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.MF.GuildMainFragment", 1, (String) it.next(), e16);
            }
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("err_main_frame_init", e16.toString()));
            ((IQQOpenTelemetryReportApi) QRoute.api(IQQOpenTelemetryReportApi.class)).reportEvent("gpro_quality#event#main_frame_init_error", mapOf);
        }
        Unit unit2 = Unit.INSTANCE;
        Logger logger3 = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger3.d().d("GUILD_DEBUG", 2, ((Object) Jh.getValue()) + " end...");
        }
        TraceUtils.k();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        GuildDebugUtils guildDebugUtils = GuildDebugUtils.f235333a;
        Lazy<String> Jh = Jh("onDestroy()");
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("GUILD_DEBUG", 2, ((Object) Jh.getValue()) + " begin...");
        }
        TraceUtils.h(Jh.getValue());
        super.onDestroy();
        Unit unit = Unit.INSTANCE;
        if (QLog.isColorLevel()) {
            logger.d().d("GUILD_DEBUG", 2, ((Object) Jh.getValue()) + " end...");
        }
        TraceUtils.k();
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        GuildDebugUtils guildDebugUtils = GuildDebugUtils.f235333a;
        Lazy<String> Jh = Jh("onDestroyView()");
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("GUILD_DEBUG", 2, ((Object) Jh.getValue()) + " begin...");
        }
        TraceUtils.h(Jh.getValue());
        super.onDestroyView();
        GuildLeftBarListController guildLeftBarListController = null;
        if (!this.isInited) {
            Logger.b bVar = new Logger.b();
            bVar.a().add("onDestroyView isInited is false");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.MF.GuildMainFragment", 1, (String) it.next(), null);
            }
        } else {
            logger.d().i("Guild.MF.GuildMainFragment", 1, "onDestroyView " + hashCode());
            sr1.d dVar = this.guildChatFrameGestureManager;
            if (dVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("guildChatFrameGestureManager");
                dVar = null;
            }
            dVar.removeGestureListener(this.absGestureListener);
            ax axVar = this.secondaryFragmentBinding;
            GuildSecondaryFragment.Companion companion = GuildSecondaryFragment.INSTANCE;
            if (axVar == companion.c()) {
                companion.h(null);
            }
            SimpleEventBus.getInstance().unRegisterReceiver(this);
            if (this.hasDestroyed.compareAndSet(false, true)) {
                Mh();
            }
            bh.f235466a.a(true);
            GuildLeftBarListController guildLeftBarListController2 = this.leftBarController;
            if (guildLeftBarListController2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("leftBarController");
            } else {
                guildLeftBarListController = guildLeftBarListController2;
            }
            guildLeftBarListController.X();
        }
        Unit unit = Unit.INSTANCE;
        Logger logger2 = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger2.d().d("GUILD_DEBUG", 2, ((Object) Jh.getValue()) + " end...");
        }
        TraceUtils.k();
    }

    @Override // com.tencent.mobileqq.guild.mainframe.s
    public void onGuildTabClick(@Nullable View view) {
        R(INSTANCE.a());
        Logger.a d16 = Logger.f235387a.d();
        GuildAppReportSourceInfo guildAppReportSourceInfo = this.reportSourceInfo;
        if (guildAppReportSourceInfo == null) {
            Intrinsics.throwUninitializedPropertyAccessException("reportSourceInfo");
            guildAppReportSourceInfo = null;
        }
        d16.i("Guild.MF.GuildMainFragment", 1, "onGuildTabClick reportSourceInfo=" + guildAppReportSourceInfo);
    }

    @Override // androidx.fragment.app.Fragment
    public void onMultiWindowModeChanged(boolean isInMultiWindowMode) {
        Logger.f235387a.d().i("Guild.MF.GuildMainFragment", 1, "onMultiWindowModeChanged " + isInMultiWindowMode);
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXFragment, androidx.fragment.app.Fragment
    public void onPause() {
        GuildDebugUtils guildDebugUtils = GuildDebugUtils.f235333a;
        Lazy<String> Jh = Jh("onPause()");
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("GUILD_DEBUG", 2, ((Object) Jh.getValue()) + " begin...");
        }
        TraceUtils.h(Jh.getValue());
        super.onPause();
        logger.d().i("Guild.MF.GuildMainFragment", 1, "onPause " + hashCode());
        Unit unit = Unit.INSTANCE;
        if (QLog.isColorLevel()) {
            logger.d().d("GUILD_DEBUG", 2, ((Object) Jh.getValue()) + " end...");
        }
        TraceUtils.k();
    }

    @Override // com.tencent.mobileqq.guild.mainframe.s
    public void onPostThemeChanged(int height) {
        GuildDebugUtils guildDebugUtils = GuildDebugUtils.f235333a;
        Lazy<String> Jh = Jh("onPostThemeChanged()");
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("GUILD_DEBUG", 2, ((Object) Jh.getValue()) + " begin...");
        }
        TraceUtils.h(Jh.getValue());
        if (height != -1) {
            setTabHeight(height);
        }
        SimpleUIUtil.adjustSimpleStatusBar((ImmersiveTitleBar2) null, requireActivity().getWindow());
        onThemeChanged();
        Unit unit = Unit.INSTANCE;
        if (QLog.isColorLevel()) {
            logger.d().d("GUILD_DEBUG", 2, ((Object) Jh.getValue()) + " end...");
        }
        TraceUtils.k();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        QLog.i("Guild.MF.GuildMainFragment", 1, "[onReceiveEvent] event: " + event + " isAdded:" + isAdded());
        if (event instanceof GuildMainAlertEvent) {
            GuildMainAlertEvent guildMainAlertEvent = (GuildMainAlertEvent) event;
            DialogUtil.createCustomDialog(getContext(), 230).setMessage(guildMainAlertEvent.getMsgContent()).setPositiveButton(guildMainAlertEvent.getButtonContent(), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.mainframe.f
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    GuildMainFragment.Lh(dialogInterface, i3);
                }
            }).show();
            return;
        }
        GuildLeftBarListController guildLeftBarListController = null;
        if (event instanceof GuildJumpLeftNodeEvent) {
            if (isAdded()) {
                i iVar = this.mainViewContext;
                if (iVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mainViewContext");
                    iVar = null;
                }
                GuildJumpLeftNodeEvent guildJumpLeftNodeEvent = (GuildJumpLeftNodeEvent) event;
                iVar.h(guildJumpLeftNodeEvent.getType(), guildJumpLeftNodeEvent.getGuildId(), null);
                return;
            }
            return;
        }
        if (event instanceof GuildJumpNextUnreadNodeEvent) {
            GuildLeftBarListController guildLeftBarListController2 = this.leftBarController;
            if (guildLeftBarListController2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("leftBarController");
            } else {
                guildLeftBarListController = guildLeftBarListController2;
            }
            guildLeftBarListController.T();
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXFragment, androidx.fragment.app.Fragment
    public void onResume() {
        GuildDebugUtils guildDebugUtils = GuildDebugUtils.f235333a;
        Lazy<String> Jh = Jh("onResume()");
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("GUILD_DEBUG", 2, ((Object) Jh.getValue()) + " begin...");
        }
        TraceUtils.h(Jh.getValue());
        super.onResume();
        i iVar = null;
        if (!this.isInited) {
            Logger.b bVar = new Logger.b();
            bVar.a().add("onResume isInited is false");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.MF.GuildMainFragment", 1, (String) it.next(), null);
            }
        } else {
            logger.d().i("Guild.MF.GuildMainFragment", 1, "onResume " + hashCode());
            changeGuildFacadeVisible("guild fragment, onResume", true);
            Pair<String, Integer> takePendingJumpChannel = ((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).takePendingJumpChannel();
            if (takePendingJumpChannel != null) {
                i iVar2 = this.mainViewContext;
                if (iVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mainViewContext");
                    iVar2 = null;
                }
                iVar2.g(takePendingJumpChannel.first);
            }
            if (this.firstWebPreloadingDone) {
                ((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).preloadWebProcess();
            }
            Oh();
            com.tencent.mobileqq.guild.mainframe.d dVar = com.tencent.mobileqq.guild.mainframe.d.f227410a;
            if (dVar.a() != null) {
                i iVar3 = this.mainViewContext;
                if (iVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mainViewContext");
                    iVar3 = null;
                }
                iVar3.R(dVar.a());
                Logger.a d16 = logger.d();
                i iVar4 = this.mainViewContext;
                if (iVar4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mainViewContext");
                    iVar4 = null;
                }
                d16.i("Guild.MF.GuildMainFragment", 1, "onResume reportSourceInfo=" + iVar4.f0());
                dVar.b(null);
            }
            GuildSecondaryFragment.Companion companion = GuildSecondaryFragment.INSTANCE;
            if (companion.c() == null) {
                logger.d().i("Guild.MF.GuildMainFragment", 1, "secondaryBinding is null");
                companion.h(this.secondaryFragmentBinding);
            }
            if (companion.b() == null) {
                logger.d().i("Guild.MF.GuildMainFragment", 1, "secondary mainViewContext is null");
                i iVar5 = this.mainViewContext;
                if (iVar5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mainViewContext");
                } else {
                    iVar = iVar5;
                }
                companion.g(iVar);
            }
        }
        Unit unit = Unit.INSTANCE;
        Logger logger2 = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger2.d().d("GUILD_DEBUG", 2, ((Object) Jh.getValue()) + " end...");
        }
        TraceUtils.k();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        GuildDebugUtils guildDebugUtils = GuildDebugUtils.f235333a;
        Lazy<String> Jh = Jh("onStart()");
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("GUILD_DEBUG", 2, ((Object) Jh.getValue()) + " begin...");
        }
        TraceUtils.h(Jh.getValue());
        super.onStart();
        logger.d().i("Guild.MF.GuildMainFragment", 1, "onStart " + hashCode());
        f12.o.f397685a.q();
        f12.f.f397616a.e("guild_main_frame", true);
        com.tencent.mobileqq.guild.performance.report.m.INSTANCE.a().c();
        Unit unit = Unit.INSTANCE;
        if (QLog.isColorLevel()) {
            logger.d().d("GUILD_DEBUG", 2, ((Object) Jh.getValue()) + " end...");
        }
        TraceUtils.k();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        GuildDebugUtils guildDebugUtils = GuildDebugUtils.f235333a;
        Lazy<String> Jh = Jh("onStop()");
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("GUILD_DEBUG", 2, ((Object) Jh.getValue()) + " begin...");
        }
        TraceUtils.h(Jh.getValue());
        super.onStop();
        logger.d().i("Guild.MF.GuildMainFragment", 1, "onStop " + hashCode());
        f12.o.f397685a.s();
        com.tencent.mobileqq.guild.performance.report.m.INSTANCE.a().endTask();
        Unit unit = Unit.INSTANCE;
        if (QLog.isColorLevel()) {
            logger.d().d("GUILD_DEBUG", 2, ((Object) Jh.getValue()) + " end...");
        }
        TraceUtils.k();
    }

    @Override // com.tencent.mobileqq.guild.mainframe.s
    public void onTabChanged(boolean guildTab, @Nullable IGuildUnreadCntService.b tabUnreadCntInfo) {
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.MF.GuildMainFragment", 2, "onTabChanged " + guildTab);
        }
        this.inGuildTab = guildTab;
        if (guildTab) {
            if (AppSetting.t(getContext()) && getActivity() != null) {
                com.tencent.mobileqq.pad.m.a(requireActivity());
            }
            Oh();
            ((IGuildStandalonePageOpenApi) QRoute.api(IGuildStandalonePageOpenApi.class)).setChannelPageSourceType(IGuildStandalonePageOpenApi.SOURCE_KEY_GUILDTAB, 1);
        } else {
            ((IGuildStandalonePageOpenApi) QRoute.api(IGuildStandalonePageOpenApi.class)).unSetChannelPageSourceType(IGuildStandalonePageOpenApi.SOURCE_KEY_GUILDTAB);
        }
        f12.f.f397616a.h(guildTab);
        Iterator<Map.Entry<Class<? extends t>, t>> it = this.controllers.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().onTabChanged(guildTab);
        }
    }

    @Override // com.tencent.mobileqq.guild.mainframe.AbsGuildMainFragment
    public boolean ph() {
        Object m476constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(getParentFragmentManager());
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        if (Result.m482isFailureimpl(m476constructorimpl)) {
            m476constructorimpl = null;
        }
        if (m476constructorimpl != null) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.guild.mainframe.AbsGuildMainFragment
    public void qh() {
        GuildDebugUtils guildDebugUtils = GuildDebugUtils.f235333a;
        Lazy<String> Jh = Jh("notifyCreate");
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("GUILD_DEBUG", 2, ((Object) Jh.getValue()) + " begin...");
        }
        TraceUtils.h(Jh.getValue());
        Iterator<Map.Entry<Class<? extends t>, t>> it = this.controllers.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().onCreate();
        }
        Unit unit = Unit.INSTANCE;
        Logger logger2 = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger2.d().d("GUILD_DEBUG", 2, ((Object) Jh.getValue()) + " end...");
        }
        TraceUtils.k();
    }

    @Override // com.tencent.mobileqq.guild.mainframe.AbsGuildMainFragment
    public void rh() {
        GuildDebugUtils guildDebugUtils = GuildDebugUtils.f235333a;
        Lazy<String> Jh = Jh("notifyDestroy");
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("GUILD_DEBUG", 2, ((Object) Jh.getValue()) + " begin...");
        }
        TraceUtils.h(Jh.getValue());
        if (this.hasDestroyed.compareAndSet(false, true)) {
            Mh();
        }
        Unit unit = Unit.INSTANCE;
        if (QLog.isColorLevel()) {
            logger.d().d("GUILD_DEBUG", 2, ((Object) Jh.getValue()) + " end...");
        }
        TraceUtils.k();
    }

    @Override // com.tencent.mobileqq.guild.mainframe.s
    public void setTabHeight(int height) {
        if (height == this.tabHeight) {
            return;
        }
        this.tabHeight = height;
        ViewGroup viewGroup = this.rootView;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            viewGroup = null;
        }
        viewGroup.setPadding(0, 0, 0, 0);
    }

    @Override // com.tencent.mobileqq.guild.mainframe.AbsGuildMainFragment
    public void th(int requestCode, int resultCode, @Nullable Intent data) {
        GuildDebugUtils guildDebugUtils = GuildDebugUtils.f235333a;
        Lazy<String> Jh = Jh(requestCode + ", " + resultCode + ", " + data);
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("GUILD_DEBUG", 2, ((Object) Jh.getValue()) + " begin...");
        }
        TraceUtils.h(Jh.getValue());
        Iterator<Map.Entry<Class<? extends t>, t>> it = this.controllers.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().onActivityResult(requestCode, resultCode, data);
        }
        Unit unit = Unit.INSTANCE;
        Logger logger2 = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger2.d().d("GUILD_DEBUG", 2, ((Object) Jh.getValue()) + " end...");
        }
        TraceUtils.k();
    }

    @Override // com.tencent.mobileqq.guild.mainframe.AbsGuildMainFragment
    public boolean uh() {
        GuildDebugUtils guildDebugUtils = GuildDebugUtils.f235333a;
        Lazy<String> Jh = Jh("notifyOnBackPressed");
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("GUILD_DEBUG", 2, ((Object) Jh.getValue()) + " begin...");
        }
        TraceUtils.h(Jh.getValue());
        Iterator<Map.Entry<Class<? extends t>, t>> it = this.controllers.entrySet().iterator();
        boolean z16 = false;
        while (it.hasNext()) {
            t value = it.next().getValue();
            if (value.onBackPressed()) {
                QLog.d("Guild.MF.GuildMainFragment", 1, "notifyOnBackPressed item class = " + value.getClass());
                z16 = true;
            }
        }
        Logger logger2 = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger2.d().d("GUILD_DEBUG", 2, ((Object) Jh.getValue()) + " end...");
        }
        TraceUtils.k();
        return z16;
    }

    @Override // com.tencent.mobileqq.guild.mainframe.AbsGuildMainFragment
    public void vh(boolean tabChanged) {
        GuildDebugUtils guildDebugUtils = GuildDebugUtils.f235333a;
        Lazy<String> Jh = Jh("notifyPause");
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("GUILD_DEBUG", 2, ((Object) Jh.getValue()) + " begin...");
        }
        TraceUtils.h(Jh.getValue());
        GuildCenterPanelController guildCenterPanelController = null;
        if (!this.isInited) {
            Logger.b bVar = new Logger.b();
            bVar.a().add("notifyPause isInited is false");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.MF.GuildMainFragment", 1, (String) it.next(), null);
            }
        } else {
            if (tabChanged) {
                GuildCenterPanelController guildCenterPanelController2 = this.centerPanelController;
                if (guildCenterPanelController2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("centerPanelController");
                } else {
                    guildCenterPanelController = guildCenterPanelController2;
                }
                guildCenterPanelController.y(2);
            }
            Iterator<Map.Entry<Class<? extends t>, t>> it5 = this.controllers.entrySet().iterator();
            while (it5.hasNext()) {
                it5.next().getValue().a(tabChanged);
            }
            GuildJumpDebugUtils.a("Guild.MF.GuildMainFragment", "notifyPause(), fragment = ", this);
        }
        Unit unit = Unit.INSTANCE;
        Logger logger2 = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger2.d().d("GUILD_DEBUG", 2, ((Object) Jh.getValue()) + " end...");
        }
        TraceUtils.k();
    }

    @Override // com.tencent.mobileqq.guild.mainframe.AbsGuildMainFragment
    public void wh(boolean tabChanged) {
        boolean z16;
        GuildDebugUtils guildDebugUtils = GuildDebugUtils.f235333a;
        Lazy<String> Jh = Jh("notifyResume");
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("GUILD_DEBUG", 2, ((Object) Jh.getValue()) + " begin...");
        }
        TraceUtils.h(Jh.getValue());
        GuildGuideAnimHelper guildGuideAnimHelper = null;
        if (!this.isInited) {
            Logger.b bVar = new Logger.b();
            bVar.a().add("notifyResume isInited is false");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.MF.GuildMainFragment", 1, (String) it.next(), null);
            }
        } else {
            if (tabChanged) {
                logger.d().i("Guild.MF.GuildMainFragment", 1, "tabChanged center panel show on right");
                GuildCenterPanelController guildCenterPanelController = this.centerPanelController;
                if (guildCenterPanelController == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("centerPanelController");
                    guildCenterPanelController = null;
                }
                guildCenterPanelController.y(2);
            }
            Iterator<Map.Entry<Class<? extends t>, t>> it5 = this.controllers.entrySet().iterator();
            while (it5.hasNext()) {
                it5.next().getValue().onResume(tabChanged);
            }
            IGuildTempApi iGuildTempApi = (IGuildTempApi) QRoute.api(IGuildTempApi.class);
            i iVar = this.mainViewContext;
            if (iVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mainViewContext");
                iVar = null;
            }
            iGuildTempApi.adjustTab(iVar.getActivity());
            Bundle arguments = getArguments();
            if (arguments != null) {
                z16 = arguments.getBoolean("extra_show_guide_anim");
            } else {
                z16 = false;
            }
            Bundle arguments2 = getArguments();
            if (arguments2 != null) {
                arguments2.putBoolean("extra_show_guide_anim", false);
            }
            GuildGuideAnimHelper guildGuideAnimHelper2 = this.guildGuideAnimHelper;
            if (guildGuideAnimHelper2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("guildGuideAnimHelper");
            } else {
                guildGuideAnimHelper = guildGuideAnimHelper2;
            }
            guildGuideAnimHelper.i(z16);
        }
        Unit unit = Unit.INSTANCE;
        Logger logger2 = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger2.d().d("GUILD_DEBUG", 2, ((Object) Jh.getValue()) + " end...");
        }
        TraceUtils.k();
    }

    @Override // com.tencent.mobileqq.guild.mainframe.AbsGuildMainFragment
    public void xh() {
        GuildDebugUtils guildDebugUtils = GuildDebugUtils.f235333a;
        Lazy<String> Jh = Jh("notifyStart");
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("GUILD_DEBUG", 2, ((Object) Jh.getValue()) + " begin...");
        }
        TraceUtils.h(Jh.getValue());
        Iterator<Map.Entry<Class<? extends t>, t>> it = this.controllers.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().onStart();
        }
        Unit unit = Unit.INSTANCE;
        Logger logger2 = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger2.d().d("GUILD_DEBUG", 2, ((Object) Jh.getValue()) + " end...");
        }
        TraceUtils.k();
    }

    @Override // com.tencent.mobileqq.guild.mainframe.AbsGuildMainFragment
    public void yh() {
        GuildDebugUtils guildDebugUtils = GuildDebugUtils.f235333a;
        Lazy<String> Jh = Jh("notifyStop");
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("GUILD_DEBUG", 2, ((Object) Jh.getValue()) + " begin...");
        }
        TraceUtils.h(Jh.getValue());
        Iterator<Map.Entry<Class<? extends t>, t>> it = this.controllers.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().onStop();
        }
        Unit unit = Unit.INSTANCE;
        Logger logger2 = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger2.d().d("GUILD_DEBUG", 2, ((Object) Jh.getValue()) + " end...");
        }
        TraceUtils.k();
    }

    @Override // com.tencent.mobileqq.guild.mainframe.c
    @NotNull
    public ViewModelStoreOwner y() {
        return this;
    }
}
