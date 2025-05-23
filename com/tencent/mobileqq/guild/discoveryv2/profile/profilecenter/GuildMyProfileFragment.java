package com.tencent.mobileqq.guild.discoveryv2.profile.profilecenter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.core.os.BundleKt;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheLunarData;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.api.ILaunchGuildChatPieApi;
import com.tencent.mobileqq.guild.api.LaunchGuildChatPieParam;
import com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment;
import com.tencent.mobileqq.guild.data.w;
import com.tencent.mobileqq.guild.discoveryv2.profile.profilecenter.event.CloseMyProfilePageEvent;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedLauncherApi;
import com.tencent.mobileqq.guild.inbox.GuildInboxUnreadCntRepository;
import com.tencent.mobileqq.guild.inbox.centerpanel.assistant.GuildAssistantFragment;
import com.tencent.mobileqq.guild.inbox.centerpanel.income.GuildNoticeIncomeFragment;
import com.tencent.mobileqq.guild.inbox.centerpanel.notice.GuildNoticeFragment;
import com.tencent.mobileqq.guild.inbox.startpanel.GuildInboxC2CViewModel;
import com.tencent.mobileqq.guild.inbox.startpanel.d;
import com.tencent.mobileqq.guild.inbox.startpanel.dialog.GuildInboxSettingDialog;
import com.tencent.mobileqq.guild.inbox.startpanel.dialog.InboxNodeSettingBaseDialog;
import com.tencent.mobileqq.guild.inbox.startpanel.dialog.k;
import com.tencent.mobileqq.guild.inbox.startpanel.p;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.jump.model.extras.AbsJumpExtra;
import com.tencent.mobileqq.guild.mainframe.GuildAppReportSourceInfo;
import com.tencent.mobileqq.guild.mainframe.util.j;
import com.tencent.mobileqq.guild.mainframe.view.GuildDragFrameLayout;
import com.tencent.mobileqq.guild.message.directmessage.model.repositories.DirectMessageNodeRepository;
import com.tencent.mobileqq.guild.util.GuildSplitViewUtils;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.az;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.o;
import com.tencent.mobileqq.guild.util.v;
import com.tencent.mobileqq.guild.widget.GuildDefaultThemeNavBarCommon;
import com.tencent.mobileqq.guild.widget.OverScrollRecyclerViewWithHeaderFooter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.quibadge.QUIBadgeDragLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000\u00fc\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u008b\u00012\u00020\u00012\u00020\u00022\u00020\u00032\b\u0012\u0004\u0012\u00020\u00050\u0004:\u0006\u008c\u0001\u008d\u0001\u008e\u0001B\t\u00a2\u0006\u0006\b\u0089\u0001\u0010\u008a\u0001J\b\u0010\u0007\u001a\u00020\u0006H\u0014J\b\u0010\b\u001a\u00020\u0006H\u0014J\b\u0010\t\u001a\u00020\u0006H\u0014J&\u0010\u0011\u001a\u00020\u00102\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0014J\b\u0010\u0012\u001a\u00020\u0010H\u0016J\u001a\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u0016\u001a\u00020\u0010H\u0016J\b\u0010\u0017\u001a\u00020\u0010H\u0016J\b\u0010\u0018\u001a\u00020\u0010H\u0016J \u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J\u000e\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00130\u001fH\u0016J\u0012\u0010#\u001a\u00020\u00102\b\u0010\"\u001a\u0004\u0018\u00010!H\u0016J\u0014\u0010&\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050%0$H\u0016J\b\u0010'\u001a\u00020\u0019H\u0016J\b\u0010(\u001a\u00020\u0010H\u0002J\b\u0010)\u001a\u00020\u0010H\u0002J\b\u0010*\u001a\u00020\u0010H\u0002J\b\u0010+\u001a\u00020\u0010H\u0002J\b\u0010-\u001a\u00020,H\u0002J\b\u0010/\u001a\u00020.H\u0002J\b\u00101\u001a\u000200H\u0002J\u0010\u00104\u001a\u00020\u00102\u0006\u00103\u001a\u000202H\u0002J\u001a\u00107\u001a\u00020\u00102\u0006\u00103\u001a\u0002022\b\u00106\u001a\u0004\u0018\u000105H\u0002J\b\u00108\u001a\u00020\u0010H\u0002J.\u0010>\u001a\u00020\u00102\u0006\u00109\u001a\u00020\u00062\u0006\u0010;\u001a\u00020:2\u0014\u0010=\u001a\u0010\u0012\u0004\u0012\u00020:\u0012\u0004\u0012\u00020:\u0018\u00010<H\u0002J$\u0010A\u001a\u00020\u00102\u0006\u00103\u001a\u0002022\b\u0010@\u001a\u0004\u0018\u00010?2\b\u00106\u001a\u0004\u0018\u00010\u000eH\u0002J\b\u0010B\u001a\u00020\u0010H\u0002J\u0010\u0010D\u001a\u00020\u00062\u0006\u0010C\u001a\u00020\u0019H\u0002J\u0010\u0010F\u001a\u00020\u00102\u0006\u0010E\u001a\u00020\u0019H\u0002J\u0010\u0010G\u001a\u00020\u00192\u0006\u0010;\u001a\u00020:H\u0002J\u0018\u0010J\u001a\u00020\u00192\u0006\u0010H\u001a\u00020:2\u0006\u0010I\u001a\u00020:H\u0002J\u0010\u0010L\u001a\u00020\u00102\u0006\u00106\u001a\u00020KH\u0002J\b\u0010M\u001a\u00020\u0010H\u0002J\u0010\u0010N\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020:H\u0002J\b\u0010O\u001a\u00020\u0010H\u0002J\b\u0010P\u001a\u00020\u0010H\u0002R\u0016\u0010T\u001a\u00020Q8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bR\u0010SR\u001b\u0010Z\u001a\u00020U8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bV\u0010W\u001a\u0004\bX\u0010YR\u001b\u0010_\u001a\u00020[8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\\\u0010W\u001a\u0004\b]\u0010^R\u0016\u0010c\u001a\u00020`8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\ba\u0010bR\u0016\u0010g\u001a\u00020d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\be\u0010fR\u0016\u0010j\u001a\u00020\u00138\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bh\u0010iR\u0016\u0010n\u001a\u00020k8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bl\u0010mR\u0016\u0010r\u001a\u00020o8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bp\u0010qR\u0016\u0010u\u001a\u00020.8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bs\u0010tR\u0016\u0010w\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bv\u0010lR\u0016\u0010z\u001a\u00020:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bx\u0010yR\u0016\u0010~\u001a\u00020{8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b|\u0010}R\u001d\u0010\u0082\u0001\u001a\u00060\u007fR\u00020\u00008\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u0080\u0001\u0010\u0081\u0001R\u0018\u0010\u0084\u0001\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0083\u0001\u0010lR\u0018\u0010\u0088\u0001\u001a\u00030\u0085\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0086\u0001\u0010\u0087\u0001\u00a8\u0006\u008f\u0001"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/profile/profilecenter/GuildMyProfileFragment;", "Lcom/tencent/mobileqq/guild/base/QQGuildTitleBarFragment;", "Lcom/tencent/mobileqq/activity/recent/cur/DragFrameLayout$b;", "", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/mobileqq/guild/discoveryv2/profile/profilecenter/event/CloseMyProfilePageEvent;", "", "getContentLayoutId", "qh", "ph", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "doOnCreateView", "onResume", "Landroid/view/View;", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, MiniSDKConst.NOTIFY_EVENT_ONPAUSE, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "onPostThemeChanged", "", "isDone", "dragType", "Lcom/tencent/mobileqq/quibadge/QUIBadgeDragLayout;", "from", "onChange", "", "onGetVisibleDragView", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "onBackEvent", "initUI", "initData", "ki", "oi", "Lcom/tencent/mobileqq/guild/widget/GuildDefaultThemeNavBarCommon$a;", "Yh", "Lli1/b;", "Wh", "Lcom/tencent/mobileqq/guild/inbox/startpanel/d$b;", "Xh", "Lcom/tencent/mobileqq/guild/inbox/startpanel/p;", "uiData", "fi", "Landroid/content/Intent;", "data", "gi", "ni", "inboxType", "", "inboxKey", "", "ext", "ei", "Lcom/tencent/mobileqq/guild/mainframe/GuildAppReportSourceInfo;", "reportSourceInfo", "di", WidgetCacheLunarData.JI, "isTop", "ci", "afterSubmit", "Uh", "li", "selectId", "source", "Zh", "Lcom/tencent/mobileqq/guild/inbox/startpanel/GuildInboxC2CViewModel$c;", "ri", "qi", "pi", "Vh", "mi", "Lcom/tencent/mobileqq/guild/widget/OverScrollRecyclerViewWithHeaderFooter;", "T", "Lcom/tencent/mobileqq/guild/widget/OverScrollRecyclerViewWithHeaderFooter;", "mNoticeListView", "Lcom/tencent/mobileqq/guild/inbox/startpanel/GuildInboxC2CViewModel;", "U", "Lkotlin/Lazy;", "bi", "()Lcom/tencent/mobileqq/guild/inbox/startpanel/GuildInboxC2CViewModel;", "mInboxViewModel", "Lcom/tencent/mobileqq/guild/inbox/startpanel/dialog/k;", "V", "ai", "()Lcom/tencent/mobileqq/guild/inbox/startpanel/dialog/k;", "mDialogFactory", "Lki1/a;", "W", "Lki1/a;", "mInboxSelectHelper", "Lcom/tencent/mobileqq/guild/mainframe/view/GuildDragFrameLayout;", "X", "Lcom/tencent/mobileqq/guild/mainframe/view/GuildDragFrameLayout;", "mDragHost", "Y", "Landroid/view/View;", "mEmptyViewLayout", "Landroid/widget/ImageView;", "Z", "Landroid/widget/ImageView;", "mEmptyImageView", "Lcom/tencent/mobileqq/guild/widget/GuildDefaultThemeNavBarCommon;", "a0", "Lcom/tencent/mobileqq/guild/widget/GuildDefaultThemeNavBarCommon;", "titleBar", "b0", "Lli1/b;", "mInboxAdapter", "c0", "mRightPanelOpen", "d0", "Ljava/lang/String;", "mLastElementReportEvent", "Landroidx/recyclerview/widget/LinearLayoutManager;", "e0", "Landroidx/recyclerview/widget/LinearLayoutManager;", "mLinearLayoutManager", "Lcom/tencent/mobileqq/guild/discoveryv2/profile/profilecenter/GuildMyProfileFragment$AfterSubmitRunnable;", "f0", "Lcom/tencent/mobileqq/guild/discoveryv2/profile/profilecenter/GuildMyProfileFragment$AfterSubmitRunnable;", "mAfterSubmitRunnable", "g0", "hasConsumedJumpParam", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "h0", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onListViewScrollListener", "<init>", "()V", "i0", "AfterSubmitRunnable", "a", "OpenParam", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildMyProfileFragment extends QQGuildTitleBarFragment implements DragFrameLayout.b, QUIBadgeDragLayout.IDragViewProvider, SimpleEventReceiver<CloseMyProfilePageEvent> {

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: T, reason: from kotlin metadata */
    private OverScrollRecyclerViewWithHeaderFooter mNoticeListView;

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    private final Lazy mInboxViewModel;

    /* renamed from: V, reason: from kotlin metadata */
    @NotNull
    private final Lazy mDialogFactory;

    /* renamed from: W, reason: from kotlin metadata */
    private ki1.a mInboxSelectHelper;

    /* renamed from: X, reason: from kotlin metadata */
    private GuildDragFrameLayout mDragHost;

    /* renamed from: Y, reason: from kotlin metadata */
    private View mEmptyViewLayout;

    /* renamed from: Z, reason: from kotlin metadata */
    private ImageView mEmptyImageView;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private GuildDefaultThemeNavBarCommon titleBar;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private li1.b mInboxAdapter;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private boolean mRightPanelOpen;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String mLastElementReportEvent;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    private LinearLayoutManager mLinearLayoutManager;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    private AfterSubmitRunnable mAfterSubmitRunnable;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    private boolean hasConsumedJumpParam;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RecyclerView.OnScrollListener onListViewScrollListener;

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0006\u0010\u0006\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0004R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\f\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\nR\u0016\u0010\u000e\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/profile/profilecenter/GuildMyProfileFragment$AfterSubmitRunnable;", "Ljava/lang/Runnable;", "", "g", "", TencentLocation.RUN_MODE, "f", "e", "", "d", "I", "previousItemSize", "beforeSubmitOffset", "Z", "selectedFlag", "", h.F, "J", "selectLaterTimestamp", "<init>", "(Lcom/tencent/mobileqq/guild/discoveryv2/profile/profilecenter/GuildMyProfileFragment;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public final class AfterSubmitRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private int previousItemSize;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private int beforeSubmitOffset;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private boolean selectedFlag;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        private long selectLaterTimestamp;

        public AfterSubmitRunnable() {
        }

        private final boolean g() {
            if (this.selectLaterTimestamp > 0 && SystemClock.uptimeMillis() - this.selectLaterTimestamp < 1000) {
                return true;
            }
            return false;
        }

        public final void e() {
            this.selectedFlag = true;
            li1.b bVar = GuildMyProfileFragment.this.mInboxAdapter;
            if (bVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mInboxAdapter");
                bVar = null;
            }
            QLog.d("GuildMyProfileFragment", 2, "AfterSubmitRunnable::markSelected() adapterSize=" + bVar.getNUM_BACKGOURND_ICON());
        }

        public final void f() {
            int i3;
            OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter = GuildMyProfileFragment.this.mNoticeListView;
            OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter2 = null;
            if (overScrollRecyclerViewWithHeaderFooter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mNoticeListView");
                overScrollRecyclerViewWithHeaderFooter = null;
            }
            this.beforeSubmitOffset = overScrollRecyclerViewWithHeaderFooter.computeVerticalScrollOffset();
            OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter3 = GuildMyProfileFragment.this.mNoticeListView;
            if (overScrollRecyclerViewWithHeaderFooter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mNoticeListView");
                overScrollRecyclerViewWithHeaderFooter3 = null;
            }
            if (overScrollRecyclerViewWithHeaderFooter3.getChildCount() > 0) {
                OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter4 = GuildMyProfileFragment.this.mNoticeListView;
                if (overScrollRecyclerViewWithHeaderFooter4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mNoticeListView");
                    overScrollRecyclerViewWithHeaderFooter4 = null;
                }
                View childAt = overScrollRecyclerViewWithHeaderFooter4.getChildAt(0);
                Intrinsics.checkNotNullExpressionValue(childAt, "mNoticeListView.getChildAt(0)");
                OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter5 = GuildMyProfileFragment.this.mNoticeListView;
                if (overScrollRecyclerViewWithHeaderFooter5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mNoticeListView");
                } else {
                    overScrollRecyclerViewWithHeaderFooter2 = overScrollRecyclerViewWithHeaderFooter5;
                }
                i3 = overScrollRecyclerViewWithHeaderFooter2.getChildAdapterPosition(childAt);
            } else {
                i3 = -1;
            }
            QLog.d("GuildMyProfileFragment", 2, "AfterSubmitRunnable::markBeforeSubmit(), beforeOffset=" + this.beforeSubmitOffset + " child(0) pos: " + i3);
        }

        @Override // java.lang.Runnable
        public void run() {
            QLog.d("GuildMyProfileFragment", 2, "AfterSubmitRunnable::run() selectedLater: " + this.selectLaterTimestamp + " selectedFlag: " + this.selectedFlag);
            li1.b bVar = GuildMyProfileFragment.this.mInboxAdapter;
            LinearLayoutManager linearLayoutManager = null;
            li1.b bVar2 = null;
            if (bVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mInboxAdapter");
                bVar = null;
            }
            int num_backgournd_icon = bVar.getNUM_BACKGOURND_ICON();
            if (g()) {
                li1.b bVar3 = GuildMyProfileFragment.this.mInboxAdapter;
                if (bVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mInboxAdapter");
                } else {
                    bVar2 = bVar3;
                }
                List<p> currentList = bVar2.getCurrentList();
                Intrinsics.checkNotNullExpressionValue(currentList, "mInboxAdapter.getCurrentList()");
                Iterator<p> it = currentList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    p next = it.next();
                    if (next.E) {
                        GuildMyProfileFragment guildMyProfileFragment = GuildMyProfileFragment.this;
                        String str = next.f226296e;
                        Intrinsics.checkNotNullExpressionValue(str, "item.inboxKey");
                        guildMyProfileFragment.Zh(str, "AfterSubmitRunnable");
                        break;
                    }
                }
            } else {
                int i3 = this.beforeSubmitOffset;
                if (i3 == 0 && !this.selectedFlag) {
                    QLog.d("GuildMyProfileFragment", 2, "AfterSubmitRunnable::run() scrollToPositionWithOffset(0)" + this.previousItemSize + " -> " + num_backgournd_icon);
                    LinearLayoutManager linearLayoutManager2 = GuildMyProfileFragment.this.mLinearLayoutManager;
                    if (linearLayoutManager2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mLinearLayoutManager");
                    } else {
                        linearLayoutManager = linearLayoutManager2;
                    }
                    linearLayoutManager.scrollToPositionWithOffset(0, 0);
                } else {
                    QLog.d("GuildMyProfileFragment", 2, "AfterSubmitRunnable::run() scroll nothing, beforeSubmitOffset: " + i3);
                }
            }
            this.previousItemSize = num_backgournd_icon;
            this.selectedFlag = false;
            this.selectLaterTimestamp = 0L;
            GuildMyProfileFragment.this.Uh(true);
        }
    }

    @Parcelize
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B#\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0004H\u00c6\u0003J\t\u0010\u000f\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0006H\u00c6\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u00c6\u0001J\t\u0010\u0012\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u00d6\u0003J\t\u0010\u0017\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u0018\u001a\u00020\u0006H\u00d6\u0001J\u0019\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0004H\u00d6\u0001R\u0011\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/profile/profilecenter/GuildMyProfileFragment$OpenParam;", "Lcom/tencent/mobileqq/guild/jump/model/extras/AbsJumpExtra;", "Landroid/os/Parcelable;", "inboxType", "", "inboxKey", "", "channelId", "(ILjava/lang/String;Ljava/lang/String;)V", "getChannelId", "()Ljava/lang/String;", "getInboxKey", "getInboxType", "()I", "component1", "component2", "component3", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", WadlProxyConsts.FLAGS, "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public static final /* data */ class OpenParam extends AbsJumpExtra implements Parcelable {

        @NotNull
        public static final Parcelable.Creator<OpenParam> CREATOR = new a();

        @NotNull
        private final String channelId;

        @NotNull
        private final String inboxKey;
        private final int inboxType;

        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes13.dex */
        public static final class a implements Parcelable.Creator<OpenParam> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final OpenParam createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new OpenParam(parcel.readInt(), parcel.readString(), parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final OpenParam[] newArray(int i3) {
                return new OpenParam[i3];
            }
        }

        public OpenParam() {
            this(0, null, null, 7, null);
        }

        public static /* synthetic */ OpenParam copy$default(OpenParam openParam, int i3, String str, String str2, int i16, Object obj) {
            if ((i16 & 1) != 0) {
                i3 = openParam.inboxType;
            }
            if ((i16 & 2) != 0) {
                str = openParam.inboxKey;
            }
            if ((i16 & 4) != 0) {
                str2 = openParam.channelId;
            }
            return openParam.copy(i3, str, str2);
        }

        /* renamed from: component1, reason: from getter */
        public final int getInboxType() {
            return this.inboxType;
        }

        @NotNull
        /* renamed from: component2, reason: from getter */
        public final String getInboxKey() {
            return this.inboxKey;
        }

        @NotNull
        /* renamed from: component3, reason: from getter */
        public final String getChannelId() {
            return this.channelId;
        }

        @NotNull
        public final OpenParam copy(int inboxType, @NotNull String inboxKey, @NotNull String channelId) {
            Intrinsics.checkNotNullParameter(inboxKey, "inboxKey");
            Intrinsics.checkNotNullParameter(channelId, "channelId");
            return new OpenParam(inboxType, inboxKey, channelId);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OpenParam)) {
                return false;
            }
            OpenParam openParam = (OpenParam) other;
            if (this.inboxType == openParam.inboxType && Intrinsics.areEqual(this.inboxKey, openParam.inboxKey) && Intrinsics.areEqual(this.channelId, openParam.channelId)) {
                return true;
            }
            return false;
        }

        @NotNull
        public final String getChannelId() {
            return this.channelId;
        }

        @NotNull
        public final String getInboxKey() {
            return this.inboxKey;
        }

        public final int getInboxType() {
            return this.inboxType;
        }

        public int hashCode() {
            return (((this.inboxType * 31) + this.inboxKey.hashCode()) * 31) + this.channelId.hashCode();
        }

        @NotNull
        public String toString() {
            return "OpenParam(inboxType=" + this.inboxType + ", inboxKey=" + this.inboxKey + ", channelId=" + this.channelId + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeInt(this.inboxType);
            parcel.writeString(this.inboxKey);
            parcel.writeString(this.channelId);
        }

        public /* synthetic */ OpenParam(int i3, String str, String str2, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this((i16 & 1) != 0 ? 1 : i3, (i16 & 2) != 0 ? "" : str, (i16 & 4) != 0 ? "" : str2);
        }

        public OpenParam(int i3, @NotNull String inboxKey, @NotNull String channelId) {
            Intrinsics.checkNotNullParameter(inboxKey, "inboxKey");
            Intrinsics.checkNotNullParameter(channelId, "channelId");
            this.inboxType = i3;
            this.inboxKey = inboxKey;
            this.channelId = channelId;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\r\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/profile/profilecenter/GuildMyProfileFragment$a;", "", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/guild/discoveryv2/profile/profilecenter/GuildMyProfileFragment$OpenParam;", "openParam", "", "a", "", "ENSURE_SELECT_THRESHOLD", "J", "", "INBOX_EMPTY_VIEW_IMAGE_URL", "Ljava/lang/String;", "KEY_OPEN_PARAM", "TAG", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.discoveryv2.profile.profilecenter.GuildMyProfileFragment$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void a(@Nullable Context context, @NotNull OpenParam openParam) {
            Intrinsics.checkNotNullParameter(openParam, "openParam");
            Logger.f235387a.d().d("GuildMyProfileFragment", 1, "openAsPage openParam:" + openParam);
            Intent intent = new Intent();
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            intent.putExtras(BundleKt.bundleOf(TuplesKt.to("KEY_OPEN_PARAM", openParam)));
            GuildSplitViewUtils.p(GuildSplitViewUtils.f235370a, context, intent, GuildMyProfileFragment.class, null, 8, null);
        }

        Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/discoveryv2/profile/profilecenter/GuildMyProfileFragment$b", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "", "fromPosition", "toPosition", "itemCount", "", "onItemRangeMoved", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b extends RecyclerView.AdapterDataObserver {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeMoved(int fromPosition, int toPosition, int itemCount) {
            super.onItemRangeMoved(fromPosition, toPosition, itemCount);
            li1.b bVar = GuildMyProfileFragment.this.mInboxAdapter;
            li1.b bVar2 = null;
            if (bVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mInboxAdapter");
                bVar = null;
            }
            if (toPosition >= bVar.getCurrentList().size()) {
                li1.b bVar3 = GuildMyProfileFragment.this.mInboxAdapter;
                if (bVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mInboxAdapter");
                } else {
                    bVar2 = bVar3;
                }
                QLog.w("GuildMyProfileFragment", 1, "onItemRangeMoved to=" + toPosition + " list size=" + bVar2.getCurrentList().size());
                return;
            }
            li1.b bVar4 = GuildMyProfileFragment.this.mInboxAdapter;
            if (bVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mInboxAdapter");
            } else {
                bVar2 = bVar4;
            }
            p pVar = bVar2.getCurrentList().get(toPosition);
            if (!pVar.E) {
                return;
            }
            if (GuildMyProfileFragment.this.mRightPanelOpen) {
                GuildMyProfileFragment guildMyProfileFragment = GuildMyProfileFragment.this;
                String str = pVar.f226296e;
                Intrinsics.checkNotNullExpressionValue(str, "targetNode.inboxKey");
                guildMyProfileFragment.Zh(str, "onItemRangeMoved");
                return;
            }
            QLog.d("GuildMyProfileFragment", 2, "EnsureVisibleAdapterDataChangeObserver::onItemRangeMoved() won't ensureVisible mRightPanelOpen = false");
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/guild/discoveryv2/profile/profilecenter/GuildMyProfileFragment$c", "Lcom/tencent/mobileqq/guild/inbox/startpanel/d$b;", "Landroid/view/View;", "itemView", "Lcom/tencent/mobileqq/guild/inbox/startpanel/p;", "uiData", "", "b", "a", "c", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class c implements d.b {
        c() {
        }

        @Override // com.tencent.mobileqq.guild.inbox.startpanel.d.b
        public void a(@NotNull View itemView, @NotNull p uiData) {
            InboxNodeSettingBaseDialog a16;
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            Intrinsics.checkNotNullParameter(uiData, "uiData");
            if (uiData.f226295d == 0) {
                a16 = GuildMyProfileFragment.this.ai().a(1);
            } else {
                GuildMyProfileFragment guildMyProfileFragment = GuildMyProfileFragment.this;
                String str = uiData.f226296e;
                Intrinsics.checkNotNullExpressionValue(str, "uiData.inboxKey");
                if (guildMyProfileFragment.li(str)) {
                    a16 = GuildMyProfileFragment.this.ai().a(2);
                } else {
                    a16 = GuildMyProfileFragment.this.ai().a(3);
                }
            }
            a16.Ph(uiData);
            FragmentManager parentFragmentManager = GuildMyProfileFragment.this.getParentFragmentManager();
            Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            com.tencent.mobileqq.guild.base.extension.d.a(a16, parentFragmentManager, "GuildMyProfileFragment");
        }

        @Override // com.tencent.mobileqq.guild.inbox.startpanel.d.b
        public void b(@NotNull View itemView, @NotNull p uiData) {
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            Intrinsics.checkNotNullParameter(uiData, "uiData");
            GuildMyProfileFragment.this.bi().v2(uiData.f226296e);
            int i3 = uiData.f226295d;
            if (i3 == 0) {
                GuildMyProfileFragment.this.di(uiData, null, null);
            } else if (i3 == 1) {
                GuildMyProfileFragment.this.gi(uiData, null);
            }
        }

        @Override // com.tencent.mobileqq.guild.inbox.startpanel.d.b
        public void c(@NotNull View itemView, @NotNull p uiData) {
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            Intrinsics.checkNotNullParameter(uiData, "uiData");
            GuildMyProfileFragment.this.fi(uiData);
        }
    }

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/guild/discoveryv2/profile/profilecenter/GuildMyProfileFragment$d", "Lcom/tencent/mobileqq/guild/widget/GuildDefaultThemeNavBarCommon$a;", "Landroid/view/View;", "view", "", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "onItemSelect", "v", "", "onItemLongClick", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class d implements GuildDefaultThemeNavBarCommon.a {
        d() {
        }

        @Override // com.tencent.mobileqq.guild.widget.GuildDefaultThemeNavBarCommon.a
        public boolean onItemLongClick(@Nullable View v3, int item) {
            return false;
        }

        @Override // com.tencent.mobileqq.guild.widget.GuildDefaultThemeNavBarCommon.a
        public void onItemSelect(@NotNull View view, int item) {
            FragmentActivity activity;
            Intrinsics.checkNotNullParameter(view, "view");
            if (item != 1) {
                if (item == 4) {
                    GuildMyProfileFragment guildMyProfileFragment = GuildMyProfileFragment.this;
                    if (!o.c("fastClickGuard") && (activity = guildMyProfileFragment.getActivity()) != null) {
                        new GuildInboxSettingDialog(true).show(activity.getSupportFragmentManager(), "GuildInboxTitleHeaderView");
                        return;
                    }
                    return;
                }
                return;
            }
            GuildMyProfileFragment guildMyProfileFragment2 = GuildMyProfileFragment.this;
            if (!o.c("fastClickGuard")) {
                guildMyProfileFragment2.requireActivity().onBackPressed();
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/guild/discoveryv2/profile/profilecenter/GuildMyProfileFragment$e", "Lkv1/a;", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class e implements kv1.a {
        e() {
        }

        @Override // kv1.a
        public void a() {
            if (com.tencent.mobileqq.guild.performance.report.f.c()) {
                com.tencent.mobileqq.guild.performance.report.f.b(GuildMyProfileFragment.this.bi().h2());
                OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter = GuildMyProfileFragment.this.mNoticeListView;
                if (overScrollRecyclerViewWithHeaderFooter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mNoticeListView");
                    overScrollRecyclerViewWithHeaderFooter = null;
                }
                overScrollRecyclerViewWithHeaderFooter.O();
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J \u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0016R\u0016\u0010\r\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/guild/discoveryv2/profile/profilecenter/GuildMyProfileFragment$f", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "dx", "dy", "onScrolled", "d", "I", "lastOffsetY", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class f extends RecyclerView.OnScrollListener {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private int lastOffsetY;

        f() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int newState) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            if (newState == 0) {
                OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter = GuildMyProfileFragment.this.mNoticeListView;
                if (overScrollRecyclerViewWithHeaderFooter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mNoticeListView");
                    overScrollRecyclerViewWithHeaderFooter = null;
                }
                VideoReport.traversePage(overScrollRecyclerViewWithHeaderFooter);
                int ci5 = GuildMyProfileFragment.this.ci(false);
                if (ci5 == -1) {
                    return;
                }
                GuildMyProfileFragment.this.bi().t2(ci5);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NotNull RecyclerView recyclerView, int dx5, int dy5) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, dx5, dy5);
            int computeVerticalScrollOffset = recyclerView.computeVerticalScrollOffset();
            int i3 = this.lastOffsetY;
            if (computeVerticalScrollOffset > i3) {
                if (computeVerticalScrollOffset - i3 >= recyclerView.getMeasuredHeight()) {
                    this.lastOffsetY = computeVerticalScrollOffset;
                    GuildMyProfileFragment.this.Uh(false);
                    return;
                }
                return;
            }
            this.lastOffsetY = computeVerticalScrollOffset;
        }
    }

    public GuildMyProfileFragment() {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<GuildInboxC2CViewModel>() { // from class: com.tencent.mobileqq.guild.discoveryv2.profile.profilecenter.GuildMyProfileFragment$mInboxViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GuildInboxC2CViewModel invoke() {
                return (GuildInboxC2CViewModel) new ViewModelProvider(GuildMyProfileFragment.this, GuildInboxC2CViewModel.S).get(GuildInboxC2CViewModel.class);
            }
        });
        this.mInboxViewModel = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<k>() { // from class: com.tencent.mobileqq.guild.discoveryv2.profile.profilecenter.GuildMyProfileFragment$mDialogFactory$2

            @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/discoveryv2/profile/profilecenter/GuildMyProfileFragment$mDialogFactory$2$a", "Lcom/tencent/mobileqq/guild/inbox/startpanel/dialog/d;", "Lcom/tencent/mobileqq/guild/inbox/startpanel/p;", "uiData", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes13.dex */
            public static final class a implements com.tencent.mobileqq.guild.inbox.startpanel.dialog.d {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ GuildMyProfileFragment f217743a;

                a(GuildMyProfileFragment guildMyProfileFragment) {
                    this.f217743a = guildMyProfileFragment;
                }

                @Override // com.tencent.mobileqq.guild.inbox.startpanel.dialog.d
                public void a(@NotNull p uiData) {
                    Intrinsics.checkNotNullParameter(uiData, "uiData");
                    this.f217743a.fi(uiData);
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final k invoke() {
                return new k(new a(GuildMyProfileFragment.this));
            }
        });
        this.mDialogFactory = lazy2;
        this.mLastElementReportEvent = "";
        this.onListViewScrollListener = new f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Uh(boolean afterSubmit) {
        int ci5 = ci(true);
        int ci6 = ci(false);
        if (ci5 >= 0 && ci6 >= 0) {
            bi().X1(ci5, ci6, afterSubmit);
        }
    }

    private final void Vh() {
        if (this.mDragHost == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDragHost");
        }
        GuildDragFrameLayout guildDragFrameLayout = this.mDragHost;
        GuildDragFrameLayout guildDragFrameLayout2 = null;
        if (guildDragFrameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDragHost");
            guildDragFrameLayout = null;
        }
        guildDragFrameLayout.removeOnDragModeChangeListener(this);
        String x16 = fs1.b.x(4, "");
        GuildDragFrameLayout guildDragFrameLayout3 = this.mDragHost;
        if (guildDragFrameLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDragHost");
        } else {
            guildDragFrameLayout2 = guildDragFrameLayout3;
        }
        guildDragFrameLayout2.removeDragViewProviderByGroup(x16, this);
    }

    private final li1.b Wh() {
        ki1.a aVar = this.mInboxSelectHelper;
        OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInboxSelectHelper");
            aVar = null;
        }
        d.b Xh = Xh();
        GuildDragFrameLayout guildDragFrameLayout = this.mDragHost;
        if (guildDragFrameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDragHost");
            guildDragFrameLayout = null;
        }
        li1.b bVar = new li1.b(aVar, Xh, guildDragFrameLayout);
        OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter2 = this.mNoticeListView;
        if (overScrollRecyclerViewWithHeaderFooter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNoticeListView");
        } else {
            overScrollRecyclerViewWithHeaderFooter = overScrollRecyclerViewWithHeaderFooter2;
        }
        bVar.o0(overScrollRecyclerViewWithHeaderFooter);
        bVar.registerAdapterDataObserver(new b());
        return bVar;
    }

    private final d.b Xh() {
        return new c();
    }

    private final GuildDefaultThemeNavBarCommon.a Yh() {
        return new d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean Zh(String selectId, String source) {
        li1.b bVar = this.mInboxAdapter;
        AfterSubmitRunnable afterSubmitRunnable = null;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInboxAdapter");
            bVar = null;
        }
        List<p> currentList = bVar.getCurrentList();
        Intrinsics.checkNotNullExpressionValue(currentList, "mInboxAdapter.currentList");
        int size = currentList.size();
        int i3 = 0;
        while (true) {
            if (i3 < size) {
                if (TextUtils.equals(currentList.get(i3).f226296e, selectId)) {
                    break;
                }
                i3++;
            } else {
                i3 = -1;
                break;
            }
        }
        if (i3 < 0) {
            QLog.d("GuildMyProfileFragment", 2, "ensureSelectedNodeVisible() not find select item! won't scroll, source: " + source);
            return false;
        }
        int ci5 = ci(true);
        int ci6 = ci(false);
        if (i3 >= ci5 && i3 <= ci6) {
            QLog.d("GuildMyProfileFragment", 2, "ensureSelectedNodeVisible() need not scroll, source: " + source);
            return false;
        }
        OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter = this.mNoticeListView;
        if (overScrollRecyclerViewWithHeaderFooter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNoticeListView");
            overScrollRecyclerViewWithHeaderFooter = null;
        }
        RecyclerView.ViewHolder findViewHolderForAdapterPosition = overScrollRecyclerViewWithHeaderFooter.findViewHolderForAdapterPosition(i3);
        if (findViewHolderForAdapterPosition != null && findViewHolderForAdapterPosition.itemView.getTop() >= 0 && findViewHolderForAdapterPosition.getLayoutPosition() == i3) {
            QLog.d("GuildMyProfileFragment", 2, "ensureSelectedNodeVisible(" + selectId + ") viewHolder top = " + findViewHolderForAdapterPosition.itemView.getTop() + " won't scroll viewHolder height = " + findViewHolderForAdapterPosition.itemView.getHeight() + " viewHolder isRecyclable = " + findViewHolderForAdapterPosition.isRecyclable() + " viewHolder layoutPosition = " + findViewHolderForAdapterPosition.getLayoutPosition() + " pos = " + i3 + " source: " + source);
            return false;
        }
        if (findViewHolderForAdapterPosition == null && i3 == 0) {
            OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter2 = this.mNoticeListView;
            if (overScrollRecyclerViewWithHeaderFooter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mNoticeListView");
                overScrollRecyclerViewWithHeaderFooter2 = null;
            }
            if (overScrollRecyclerViewWithHeaderFooter2.computeVerticalScrollOffset() == 0) {
                QLog.d("GuildMyProfileFragment", 2, "ensureSelectedNodeVisible(" + selectId + ") scroll to " + i3 + "computeVerticalScrollOffset=0 ignore!(viewHolder=null) source: " + source);
                return false;
            }
        }
        QLog.d("GuildMyProfileFragment", 2, "ensureSelectedNodeVisible(" + selectId + ") scroll to " + i3 + " source: " + source);
        LinearLayoutManager linearLayoutManager = this.mLinearLayoutManager;
        if (linearLayoutManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLinearLayoutManager");
            linearLayoutManager = null;
        }
        linearLayoutManager.scrollToPositionWithOffset(i3, 0);
        AfterSubmitRunnable afterSubmitRunnable2 = this.mAfterSubmitRunnable;
        if (afterSubmitRunnable2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAfterSubmitRunnable");
        } else {
            afterSubmitRunnable = afterSubmitRunnable2;
        }
        afterSubmitRunnable.e();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final k ai() {
        return (k) this.mDialogFactory.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final GuildInboxC2CViewModel bi() {
        return (GuildInboxC2CViewModel) this.mInboxViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int ci(boolean isTop) {
        OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter = this.mNoticeListView;
        LinearLayoutManager linearLayoutManager = null;
        if (overScrollRecyclerViewWithHeaderFooter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNoticeListView");
            overScrollRecyclerViewWithHeaderFooter = null;
        }
        RecyclerView.LayoutManager layoutManager = overScrollRecyclerViewWithHeaderFooter.getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            linearLayoutManager = (LinearLayoutManager) layoutManager;
        }
        if (linearLayoutManager == null) {
            return -1;
        }
        if (isTop) {
            return linearLayoutManager.findFirstVisibleItemPosition();
        }
        return linearLayoutManager.findLastVisibleItemPosition();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void di(p uiData, GuildAppReportSourceInfo reportSourceInfo, Bundle data) {
        if (QLog.isColorLevel()) {
            QLog.d("GuildMyProfileFragment", 1, "handleC2CNodeClick, uiData:", uiData, " reportSourceInfo:", reportSourceInfo);
        }
        ki1.a aVar = this.mInboxSelectHelper;
        ki1.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInboxSelectHelper");
            aVar = null;
        }
        aVar.h(uiData.f226295d, uiData.f226296e);
        GuildInboxC2CViewModel bi5 = bi();
        ki1.a aVar3 = this.mInboxSelectHelper;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInboxSelectHelper");
        } else {
            aVar2 = aVar3;
        }
        bi5.v2(aVar2.getMSelItem().getSelKey());
        Bundle bundle = new Bundle();
        bundle.putByte(AppConstants.Key.GUILD_DIRECT_MESSAGE_FLAG, (byte) 1);
        if (reportSourceInfo != null) {
            bundle.putParcelable("GuildAppReportSourceInfo", reportSourceInfo);
        }
        if (uiData.G == 1) {
            bundle.putInt(AppConstants.Key.GUILD_DIRECT_MESSAGE_TYPE, 2);
        }
        if (data != null) {
            bundle.putAll(data);
        }
        bundle.putInt(JumpGuildParam.EXTRA_KEY_CHANNEL_OPEN_SOURCE, 1);
        ((ILaunchGuildChatPieApi) QRoute.api(ILaunchGuildChatPieApi.class)).launchGuildDirectMessageAio(requireContext(), new LaunchGuildChatPieParam().l(uiData.f226296e).b(uiData.f226297f).r(false).o(1).g(3).k(bundle).q("").a());
    }

    private final void ei(int inboxType, String inboxKey, Map<String, String> ext) {
        bi().b2(inboxType, inboxKey);
        if (inboxType == 0) {
            DirectMessageNodeRepository.a0(getActivity(), inboxKey, ext);
        } else {
            bi().u2(inboxKey);
        }
        if (QLog.isColorLevel()) {
            QLog.d("GuildMyProfileFragment", 2, "onInboxNodeRemove inboxType:", Integer.valueOf(inboxType), " inboxKey:", inboxKey);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void fi(p uiData) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String str = uiData.f226297f;
        Intrinsics.checkNotNullExpressionValue(str, "uiData.channelId");
        linkedHashMap.put("extra_channel_id", str);
        String str2 = uiData.f226298h;
        Intrinsics.checkNotNullExpressionValue(str2, "uiData.tinyId");
        linkedHashMap.put("extra_target_tiny_id", str2);
        int i3 = uiData.f226295d;
        String str3 = uiData.f226296e;
        Intrinsics.checkNotNullExpressionValue(str3, "uiData.inboxKey");
        ei(i3, str3, linkedHashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void gi(p uiData, Intent data) {
        if (QLog.isColorLevel()) {
            QLog.d("GuildMyProfileFragment", 2, "handleGuildNoticeClick, uiData:", uiData);
        }
        ki1.a aVar = this.mInboxSelectHelper;
        ki1.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInboxSelectHelper");
            aVar = null;
        }
        aVar.h(uiData.f226295d, uiData.f226296e);
        GuildInboxC2CViewModel bi5 = bi();
        ki1.a aVar3 = this.mInboxSelectHelper;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInboxSelectHelper");
        } else {
            aVar2 = aVar3;
        }
        bi5.v2(aVar2.getMSelItem().getSelKey());
        if (TextUtils.equals(uiData.f226296e, "6")) {
            GuildNoticeFragment.Mh(requireContext(), uiData.F);
        } else if (TextUtils.equals(uiData.f226296e, "7")) {
            GuildAssistantFragment.Companion companion = GuildAssistantFragment.INSTANCE;
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
            companion.b(requireContext);
        } else if (TextUtils.equals(uiData.f226296e, "5")) {
            GuildNoticeIncomeFragment.Companion companion2 = GuildNoticeIncomeFragment.INSTANCE;
            Context requireContext2 = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext2, "requireContext()");
            companion2.b(requireContext2);
        } else if (TextUtils.equals(uiData.f226296e, "8")) {
            ni();
        } else {
            QLog.e("GuildMyProfileFragment", 1, "handleOfficialNodeClick, the uiData is error, uiData:", uiData);
        }
        bi().b2(uiData.f226295d, uiData.f226296e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void hi(GuildMyProfileFragment this$0, GuildInboxC2CViewModel.c data) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(data, "data");
        this$0.ri(data);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ii(GuildMyProfileFragment this$0, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (z16) {
            li1.b bVar = this$0.mInboxAdapter;
            if (bVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mInboxAdapter");
                bVar = null;
            }
            bVar.j0();
        }
    }

    private final void initData() {
        this.mLinearLayoutManager = new LinearLayoutManager(requireContext(), 1, false);
        OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter = this.mNoticeListView;
        ki1.a aVar = null;
        if (overScrollRecyclerViewWithHeaderFooter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNoticeListView");
            overScrollRecyclerViewWithHeaderFooter = null;
        }
        LinearLayoutManager linearLayoutManager = this.mLinearLayoutManager;
        if (linearLayoutManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLinearLayoutManager");
            linearLayoutManager = null;
        }
        overScrollRecyclerViewWithHeaderFooter.setLayoutManager(linearLayoutManager);
        this.mInboxAdapter = Wh();
        OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter2 = this.mNoticeListView;
        if (overScrollRecyclerViewWithHeaderFooter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNoticeListView");
            overScrollRecyclerViewWithHeaderFooter2 = null;
        }
        li1.b bVar = this.mInboxAdapter;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInboxAdapter");
            bVar = null;
        }
        overScrollRecyclerViewWithHeaderFooter2.setAdapter(bVar);
        OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter3 = this.mNoticeListView;
        if (overScrollRecyclerViewWithHeaderFooter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNoticeListView");
            overScrollRecyclerViewWithHeaderFooter3 = null;
        }
        overScrollRecyclerViewWithHeaderFooter3.setDrawListener(new e());
        bi().init();
        GuildInboxC2CViewModel bi5 = bi();
        ki1.a aVar2 = this.mInboxSelectHelper;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInboxSelectHelper");
        } else {
            aVar = aVar2;
        }
        bi5.v2(aVar.getMSelItem().getSelKey());
        bi().g2().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.guild.discoveryv2.profile.profilecenter.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildMyProfileFragment.hi(GuildMyProfileFragment.this, (GuildInboxC2CViewModel.c) obj);
            }
        });
        bi().i2().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.guild.discoveryv2.profile.profilecenter.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildMyProfileFragment.ii(GuildMyProfileFragment.this, ((Boolean) obj).booleanValue());
            }
        });
    }

    private final void initUI() {
        View findViewById = this.P.findViewById(R.id.xlt);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mContentView.findViewById(R.id.inbox_list)");
        this.mNoticeListView = (OverScrollRecyclerViewWithHeaderFooter) findViewById;
        View findViewById2 = this.P.findViewById(R.id.root_layout);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mContentView.findViewById(R.id.root_layout)");
        this.mDragHost = (GuildDragFrameLayout) findViewById2;
        this.mRightPanelOpen = false;
        this.mLastElementReportEvent = "";
        this.mAfterSubmitRunnable = new AfterSubmitRunnable();
        this.hasConsumedJumpParam = false;
        OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter = null;
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.eup, (ViewGroup) null);
        inflate.setVisibility(8);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(activity).inflate(R\u2026 visibility = View.GONE }");
        this.mEmptyViewLayout = inflate;
        View findViewById3 = inflate.findViewById(R.id.xls);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "mEmptyViewLayout.findVie\u2026id.inbox_empty_imageview)");
        this.mEmptyImageView = (ImageView) findViewById3;
        ji();
        GuildDragFrameLayout guildDragFrameLayout = this.mDragHost;
        if (guildDragFrameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDragHost");
            guildDragFrameLayout = null;
        }
        guildDragFrameLayout.setIsNeedDrawClip(false);
        View titleBarView = getTitleBarView();
        Intrinsics.checkNotNull(titleBarView, "null cannot be cast to non-null type com.tencent.mobileqq.guild.widget.GuildDefaultThemeNavBarCommon");
        GuildDefaultThemeNavBarCommon guildDefaultThemeNavBarCommon = (GuildDefaultThemeNavBarCommon) titleBarView;
        this.titleBar = guildDefaultThemeNavBarCommon;
        if (guildDefaultThemeNavBarCommon == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleBar");
            guildDefaultThemeNavBarCommon = null;
        }
        guildDefaultThemeNavBarCommon.setTitle("\u9891\u9053\u79c1\u4fe1");
        GuildDefaultThemeNavBarCommon guildDefaultThemeNavBarCommon2 = this.titleBar;
        if (guildDefaultThemeNavBarCommon2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleBar");
            guildDefaultThemeNavBarCommon2 = null;
        }
        guildDefaultThemeNavBarCommon2.setLeftBackVisible(0);
        GuildDefaultThemeNavBarCommon guildDefaultThemeNavBarCommon3 = this.titleBar;
        if (guildDefaultThemeNavBarCommon3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleBar");
            guildDefaultThemeNavBarCommon3 = null;
        }
        guildDefaultThemeNavBarCommon3.setRightDrawable(R.drawable.qui_more);
        GuildDefaultThemeNavBarCommon guildDefaultThemeNavBarCommon4 = this.titleBar;
        if (guildDefaultThemeNavBarCommon4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleBar");
            guildDefaultThemeNavBarCommon4 = null;
        }
        guildDefaultThemeNavBarCommon4.setOnItemSelectListener(Yh());
        OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter2 = this.mNoticeListView;
        if (overScrollRecyclerViewWithHeaderFooter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNoticeListView");
            overScrollRecyclerViewWithHeaderFooter2 = null;
        }
        overScrollRecyclerViewWithHeaderFooter2.addOnScrollListener(this.onListViewScrollListener);
        OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter3 = this.mNoticeListView;
        if (overScrollRecyclerViewWithHeaderFooter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNoticeListView");
            overScrollRecyclerViewWithHeaderFooter3 = null;
        }
        overScrollRecyclerViewWithHeaderFooter3.H();
        OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter4 = this.mNoticeListView;
        if (overScrollRecyclerViewWithHeaderFooter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNoticeListView");
            overScrollRecyclerViewWithHeaderFooter4 = null;
        }
        overScrollRecyclerViewWithHeaderFooter4.setHasFixedSize(true);
        OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter5 = this.mNoticeListView;
        if (overScrollRecyclerViewWithHeaderFooter5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNoticeListView");
            overScrollRecyclerViewWithHeaderFooter5 = null;
        }
        View view = this.mEmptyViewLayout;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEmptyViewLayout");
            view = null;
        }
        overScrollRecyclerViewWithHeaderFooter5.C(view);
        OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter6 = this.mNoticeListView;
        if (overScrollRecyclerViewWithHeaderFooter6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNoticeListView");
        } else {
            overScrollRecyclerViewWithHeaderFooter = overScrollRecyclerViewWithHeaderFooter6;
        }
        VideoReport.enableAndroidXRVExposure(overScrollRecyclerViewWithHeaderFooter);
        ki1.a aVar = new ki1.a();
        this.mInboxSelectHelper = aVar;
        aVar.g(requireContext());
    }

    private final void ji() {
        GuildDragFrameLayout guildDragFrameLayout = this.mDragHost;
        GuildDragFrameLayout guildDragFrameLayout2 = null;
        if (guildDragFrameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDragHost");
            guildDragFrameLayout = null;
        }
        guildDragFrameLayout.addOnDragModeChangeListener(this, true);
        String x16 = fs1.b.x(4, "");
        GuildDragFrameLayout guildDragFrameLayout3 = this.mDragHost;
        if (guildDragFrameLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDragHost");
        } else {
            guildDragFrameLayout2 = guildDragFrameLayout3;
        }
        guildDragFrameLayout2.addDragViewProviderByGroup(x16, this, false);
    }

    private final void ki() {
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean li(String inboxKey) {
        int c16 = az.c(inboxKey, 0);
        if (c16 != 6 && c16 != 7 && c16 != 5 && c16 != 8) {
            return false;
        }
        return true;
    }

    private final void mi() {
        Object obj;
        if (this.hasConsumedJumpParam) {
            return;
        }
        this.hasConsumedJumpParam = true;
        Bundle arguments = getArguments();
        OpenParam openParam = null;
        if (arguments != null) {
            obj = arguments.get("KEY_OPEN_PARAM");
        } else {
            obj = null;
        }
        if (obj instanceof OpenParam) {
            openParam = (OpenParam) obj;
        }
        Logger logger = Logger.f235387a;
        logger.d().d("GuildMyProfileFragment", 1, "jumpNextPageIfNeed openParam:" + openParam);
        if (openParam == null) {
            return;
        }
        int inboxType = openParam.getInboxType();
        if (inboxType != 0) {
            if (inboxType == 1) {
                String inboxKey = openParam.getInboxKey();
                int hashCode = inboxKey.hashCode();
                if (hashCode != 53) {
                    if (hashCode != 55) {
                        if (hashCode == 56 && inboxKey.equals("8")) {
                            ni();
                            return;
                        }
                    } else if (inboxKey.equals("7")) {
                        GuildAssistantFragment.Companion companion = GuildAssistantFragment.INSTANCE;
                        Context requireContext = requireContext();
                        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
                        companion.b(requireContext);
                        return;
                    }
                } else if (inboxKey.equals("5")) {
                    GuildNoticeIncomeFragment.Companion companion2 = GuildNoticeIncomeFragment.INSTANCE;
                    Context requireContext2 = requireContext();
                    Intrinsics.checkNotNullExpressionValue(requireContext2, "requireContext()");
                    companion2.b(requireContext2);
                    return;
                }
                logger.d().w("GuildMyProfileFragment", 1, "jumpNextPageIfNeed INBOX_TYPE_OFFICIAL unexpectedNode");
                return;
            }
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putByte(AppConstants.Key.GUILD_DIRECT_MESSAGE_FLAG, (byte) 1);
        ((ILaunchGuildChatPieApi) QRoute.api(ILaunchGuildChatPieApi.class)).launchGuildDirectMessageAio(requireContext(), new LaunchGuildChatPieParam().l(openParam.getInboxKey()).b(openParam.getChannelId()).r(false).o(1).g(3).k(bundle).q("").a());
    }

    private final void ni() {
        ((IGuildFeedLauncherApi) QRoute.api(IGuildFeedLauncherApi.class)).launchGuildVisitorFeedNoticeFragment();
    }

    private final void oi() {
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    private final void pi(String event) {
        if (TextUtils.equals(this.mLastElementReportEvent, event)) {
            return;
        }
        this.mLastElementReportEvent = event;
        HashMap hashMap = new HashMap();
        OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter = this.mNoticeListView;
        if (overScrollRecyclerViewWithHeaderFooter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNoticeListView");
            overScrollRecyclerViewWithHeaderFooter = null;
        }
        VideoReport.reportEvent(event, overScrollRecyclerViewWithHeaderFooter, hashMap);
    }

    private final void qi() {
        VideoReport.addToDetectionWhitelist(getQBaseActivity());
        VideoReport.setPageId(this.P, "pg_sgrp_mvp_private_list");
        HashMap hashMap = new HashMap();
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, "0S200MNJT807V3GE");
        w.b(hashMap);
        hashMap.putAll(com.tencent.mobileqq.guild.report.b.d());
        VideoReport.setPageParams(this.P, new PageParams(hashMap));
        OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter = this.mNoticeListView;
        if (overScrollRecyclerViewWithHeaderFooter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNoticeListView");
            overScrollRecyclerViewWithHeaderFooter = null;
        }
        ch.Y0(overScrollRecyclerViewWithHeaderFooter, "em_sgrp_private_letters", ClickPolicy.REPORT_NONE, ExposurePolicy.REPORT_NONE);
    }

    private final void ri(final GuildInboxC2CViewModel.c data) {
        AfterSubmitRunnable afterSubmitRunnable = null;
        if (data.f226223a.isEmpty()) {
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.discoveryv2.profile.profilecenter.c
                @Override // java.lang.Runnable
                public final void run() {
                    GuildMyProfileFragment.si(GuildMyProfileFragment.this, data);
                }
            }, 500L);
        } else {
            View view = this.mEmptyViewLayout;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mEmptyViewLayout");
                view = null;
            }
            view.setVisibility(8);
            ImageView imageView = this.mEmptyImageView;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mEmptyImageView");
                imageView = null;
            }
            imageView.setVisibility(8);
        }
        if (data.f226224b) {
            com.tencent.mobileqq.guild.performance.report.f.d(true);
        }
        AfterSubmitRunnable afterSubmitRunnable2 = this.mAfterSubmitRunnable;
        if (afterSubmitRunnable2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAfterSubmitRunnable");
            afterSubmitRunnable2 = null;
        }
        afterSubmitRunnable2.f();
        li1.b bVar = this.mInboxAdapter;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInboxAdapter");
            bVar = null;
        }
        List<p> list = data.f226223a;
        Intrinsics.checkNotNullExpressionValue(list, "data.dataList");
        AfterSubmitRunnable afterSubmitRunnable3 = this.mAfterSubmitRunnable;
        if (afterSubmitRunnable3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAfterSubmitRunnable");
        } else {
            afterSubmitRunnable = afterSubmitRunnable3;
        }
        bVar.p0(list, afterSubmitRunnable);
        j.d("inbox load finish", "KEY_RIGHT_PART_LOAD");
        j.d("inbox load finish after guild init. data size=" + data.f226223a.size(), "KEY_MAIN_FRAGMENT_CREATE");
        if (data.f226224b) {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.guild.discoveryv2.profile.profilecenter.d
                @Override // java.lang.Runnable
                public final void run() {
                    GuildMyProfileFragment.ti(GuildInboxC2CViewModel.c.this, this);
                }
            });
            QLog.i("GuildMyProfileFragment", 2, "open center panel mInit=" + data.f226224b + " delayed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void si(GuildMyProfileFragment this$0, GuildInboxC2CViewModel.c data) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(data, "$data");
        GuildInboxC2CViewModel.c value = this$0.bi().g2().getValue();
        Intrinsics.checkNotNull(value);
        if (value.f226223a.isEmpty()) {
            ImageView imageView = this$0.mEmptyImageView;
            ImageView imageView2 = null;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mEmptyImageView");
                imageView = null;
            }
            v.k("https://downv6.qq.com/innovate/guild/empty_view/guild_inbox_empty_view_new.png", imageView, new ColorDrawable(0));
            View view = this$0.mEmptyViewLayout;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mEmptyViewLayout");
                view = null;
            }
            view.setVisibility(0);
            ImageView imageView3 = this$0.mEmptyImageView;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mEmptyImageView");
            } else {
                imageView2 = imageView3;
            }
            imageView2.setVisibility(0);
            QLog.e("GuildMyProfileFragment", 1, "getC2CMassageNodeLiveData onChanged, noticeNodeUIData isEmpty:", Boolean.valueOf(data.f226223a.isEmpty()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ti(GuildInboxC2CViewModel.c data, GuildMyProfileFragment this$0) {
        Intrinsics.checkNotNullParameter(data, "$data");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("GuildMyProfileFragment", 2, "open center panel " + data.f226224b);
        ki1.a aVar = this$0.mInboxSelectHelper;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInboxSelectHelper");
            aVar = null;
        }
        List<p> list = data.f226223a;
        Intrinsics.checkNotNullExpressionValue(list, "data.dataList");
        aVar.e(list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment, com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment
    public void doOnCreateView(@Nullable LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.doOnCreateView(inflater, container, savedInstanceState);
        rh();
        initUI();
        initData();
        ki();
        qi();
        GuildSplitViewUtils guildSplitViewUtils = GuildSplitViewUtils.f235370a;
        guildSplitViewUtils.B(this.N);
        guildSplitViewUtils.A(getActivity(), this.N, R.drawable.qui_common_bg_bottom_light_bg);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f0s;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<CloseMyProfilePageEvent>> getEventClass() {
        ArrayList<Class<CloseMyProfilePageEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(CloseMyProfilePageEvent.class);
        return arrayListOf;
    }

    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        return GuildSplitViewUtils.u(GuildSplitViewUtils.f235370a, getActivity(), false, 2, null);
    }

    @Override // com.tencent.mobileqq.quibadge.QUIBadgeDragLayout.OnDragModeChangedListener
    public void onChange(boolean isDone, int dragType, @NotNull QUIBadgeDragLayout from) {
        boolean z16;
        boolean z17;
        Intrinsics.checkNotNullParameter(from, "from");
        if (from.getDragView() == null) {
            return;
        }
        GuildDragFrameLayout guildDragFrameLayout = this.mDragHost;
        if (guildDragFrameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDragHost");
            guildDragFrameLayout = null;
        }
        boolean z18 = false;
        if (guildDragFrameLayout.getMode() == -1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (from.getDragView() != null) {
            z17 = true;
        } else {
            z17 = false;
        }
        boolean z19 = z16 & z17;
        if (from.getDragView().getId() == R.id.xm8 || from.getDragView().getId() == R.id.xm7) {
            z18 = true;
        }
        if (z19 & z18) {
            QLog.i("GuildMyProfileFragment", 4, "drag onchange tag " + from.getDragView().getTag());
            if (from.getDragView().getTag() instanceof p) {
                Object tag = from.getDragView().getTag();
                Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type com.tencent.mobileqq.guild.inbox.startpanel.InboxNodeUIData");
                p pVar = (p) tag;
                if (TextUtils.isEmpty(pVar.f226296e)) {
                    QLog.e("GuildMyProfileFragment", 1, "clearUnreadMsg error, the data is null");
                    return;
                } else {
                    bi().b2(pVar.f226295d, pVar.f226296e);
                    return;
                }
            }
            if (from.getDragView().getTag() instanceof String) {
                Object tag2 = from.getDragView().getTag();
                Intrinsics.checkNotNull(tag2, "null cannot be cast to non-null type kotlin.String");
                if (TextUtils.equals((String) tag2, "GuildInboxTitleHeaderView")) {
                    GuildInboxUnreadCntRepository.f226100d.i();
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        if (QLog.isColorLevel()) {
            QLog.d("GuildMyProfileFragment", 2, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        }
        Vh();
        if (bi() != null) {
            bi().removeListener();
        }
        oi();
        super.onDestroy();
    }

    @Override // com.tencent.mobileqq.quibadge.QUIBadgeDragLayout.IDragViewProvider
    @NotNull
    public List<View> onGetVisibleDragView() {
        List emptyList;
        List<View> mutableList;
        if (!isVisible()) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) emptyList);
            return mutableList;
        }
        ArrayList arrayList = new ArrayList();
        li1.b bVar = this.mInboxAdapter;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInboxAdapter");
            bVar = null;
        }
        int num_backgournd_icon = bVar.getNUM_BACKGOURND_ICON();
        for (int i3 = 0; i3 < num_backgournd_icon; i3++) {
            OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter = this.mNoticeListView;
            if (overScrollRecyclerViewWithHeaderFooter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mNoticeListView");
                overScrollRecyclerViewWithHeaderFooter = null;
            }
            View childAt = overScrollRecyclerViewWithHeaderFooter.getChildAt(i3);
            if (childAt != null) {
                View findViewById = childAt.findViewById(R.id.xm8);
                if (findViewById instanceof DragTextView) {
                    DragTextView dragTextView = (DragTextView) findViewById;
                    if (dragTextView.isShown() && dragTextView.c() != -1) {
                        arrayList.add(findViewById);
                    }
                }
            }
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        if (isVisible()) {
            pi("imp_end");
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public void onPostThemeChanged() {
        super.onPostThemeChanged();
        rh();
        yh(ph());
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        FragmentActivity activity;
        if ((event instanceof CloseMyProfilePageEvent) && (activity = getActivity()) != null) {
            activity.finish();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (isVisible()) {
            pi("imp");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        mi();
    }

    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment
    protected int ph() {
        return GuildSplitViewUtils.f235370a.m(getActivity(), R.color.qui_common_bg_bottom_light);
    }

    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment
    protected int qh() {
        return R.drawable.qui_common_bg_bottom_light_bg;
    }
}
