package com.tencent.mobileqq.guild.home.schedule.list;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentResultListener;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.guild.aio.util.ex.ViewExtKt;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.base.QQGuildTokenTitleBarFragment;
import com.tencent.mobileqq.guild.base.extension.CalendarEx;
import com.tencent.mobileqq.guild.base.extension.CalendarExKt;
import com.tencent.mobileqq.guild.base.extension.q;
import com.tencent.mobileqq.guild.home.schedule.ScheduleEntryListAdapter;
import com.tencent.mobileqq.guild.home.schedule.create.GuildNewScheduleCreateFragment;
import com.tencent.mobileqq.guild.home.schedule.delegates.DayGroupDelegate;
import com.tencent.mobileqq.guild.home.schedule.delegates.ScheduleEmptyEntryDelegate;
import com.tencent.mobileqq.guild.home.schedule.delegates.ScheduleEntryDelegate;
import com.tencent.mobileqq.guild.home.schedule.list.GuildHomeScheduleListFragment;
import com.tencent.mobileqq.guild.home.schedule.models.DayGroupItem;
import com.tencent.mobileqq.guild.home.schedule.models.ScheduleEmptyPlaceholderItem;
import com.tencent.mobileqq.guild.home.schedule.models.ScheduleInfoItem;
import com.tencent.mobileqq.guild.home.schedule.models.ScheduleLoadingItem;
import com.tencent.mobileqq.guild.home.schedule.models.d;
import com.tencent.mobileqq.guild.home.schedule.viewmodels.GuildHomeScheduleViewModel;
import com.tencent.mobileqq.guild.home.views.dialog.ScheduleDateLocatorDialog;
import com.tencent.mobileqq.guild.home.views.sticky.StickyHeadContainer;
import com.tencent.mobileqq.guild.home.views.widget.ScheduleRecyclerView;
import com.tencent.mobileqq.guild.homev2.views.widget.GuildHomeVisitorJoinView;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.report.IPerformanceReportTask;
import com.tencent.mobileqq.guild.schedule.detail.GuildScheduleDetailFragment;
import com.tencent.mobileqq.guild.util.GuildSplitViewUtils;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.bt;
import com.tencent.mobileqq.guild.util.cw;
import com.tencent.mobileqq.guild.util.o;
import com.tencent.mobileqq.guild.util.s;
import com.tencent.mobileqq.guild.widget.ShadowFrameLayout;
import com.tencent.mobileqq.qqguildsdk.data.GuildScheduleInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import cooperation.qzone.QzoneIPCModule;
import ef1.c;
import java.io.Serializable;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.LightConstants;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00cc\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u000e\n\u0002\b\n*\u0002\u0082\u0001\u0018\u0000 \u0088\u00012\u00020\u0001:\u0004\u0089\u0001\u008a\u0001B\t\u00a2\u0006\u0006\b\u0086\u0001\u0010\u0087\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0014J\u001a\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\n\u001a\u00020\u0002H\u0014J\b\u0010\u000b\u001a\u00020\u0002H\u0014J\"\u0010\u0010\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\u0010\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J$\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0016\u001a\u00020\u00112\b\b\u0002\u0010\u0017\u001a\u00020\u0011H\u0002J\u0010\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u0014H\u0002J\b\u0010\u001b\u001a\u00020\bH\u0002J\b\u0010\u001d\u001a\u00020\u001cH\u0002J\b\u0010\u001e\u001a\u00020\bH\u0002J\u0010\u0010\u001f\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\u001a\u0010\"\u001a\u00020\u00022\u0006\u0010!\u001a\u00020 2\b\b\u0002\u0010\u0015\u001a\u00020\u0014H\u0002J%\u0010&\u001a\u00020\b2\b\u0010$\u001a\u0004\u0018\u00010#2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010#H\u0002\u00a2\u0006\u0004\b&\u0010'J\u0012\u0010*\u001a\u00020\u00112\b\u0010)\u001a\u0004\u0018\u00010(H\u0002J \u0010.\u001a\u00020\u00112\u0006\u0010+\u001a\u00020\u00022\u0006\u0010,\u001a\u00020\u00022\u0006\u0010-\u001a\u00020\u0002H\u0002J\b\u0010/\u001a\u00020\bH\u0002J\b\u00101\u001a\u000200H\u0002J\u0010\u00104\u001a\u00020\b2\u0006\u00103\u001a\u000202H\u0002J\u0010\u00105\u001a\u00020\b2\u0006\u00103\u001a\u000202H\u0002J\b\u00106\u001a\u00020\bH\u0002J\u0012\u00107\u001a\u00020\b2\b\u00103\u001a\u0004\u0018\u000102H\u0002J\u0010\u00109\u001a\u00020\b2\u0006\u00103\u001a\u000208H\u0002J\b\u0010;\u001a\u00020:H\u0002R\u0016\u0010?\u001a\u00020<8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010C\u001a\u00020@8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010G\u001a\u00020D8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010K\u001a\u00020H8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010N\u001a\u00020\u00048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bL\u0010MR\u0016\u0010P\u001a\u00020\u00048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bO\u0010MR\u0016\u0010R\u001a\u00020\u00048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bQ\u0010MR\u0016\u0010V\u001a\u00020S8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bT\u0010UR\u0016\u0010Z\u001a\u00020W8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bX\u0010YR\u0016\u0010^\u001a\u00020[8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\\\u0010]R\u0016\u0010`\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b_\u0010QR\u0018\u0010c\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\ba\u0010bR\u0014\u0010f\u001a\u0002008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bd\u0010eR\u0014\u0010j\u001a\u00020g8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bh\u0010iR\u0014\u0010l\u001a\u00020g8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bk\u0010iR\u0016\u0010n\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bm\u0010QR\u0018\u0010r\u001a\u0004\u0018\u00010o8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bp\u0010qR\u001c\u0010v\u001a\b\u0012\u0004\u0012\u0002020s8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bt\u0010uR\u0016\u0010y\u001a\u00020:8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bw\u0010xR\u0016\u0010|\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bz\u0010{R\u0016\u0010~\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b}\u0010{R\u0016\u0010\u0081\u0001\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b\u007f\u0010\u0080\u0001R\u0018\u0010\u0085\u0001\u001a\u00030\u0082\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0083\u0001\u0010\u0084\u0001\u00a8\u0006\u008b\u0001"}, d2 = {"Lcom/tencent/mobileqq/guild/home/schedule/list/GuildHomeScheduleListFragment;", "Lcom/tencent/mobileqq/guild/base/QQGuildTokenTitleBarFragment;", "", "getContentLayoutId", "Landroid/view/View;", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "qh", "ph", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "", "onBackEvent", "initViews", "", "from", LightConstants.DowngradeStrategyKey.SMOOTH, "tryAgain", "Ai", "source", "Ri", "initData", "Landroidx/fragment/app/FragmentResultListener;", "si", "initDtReport", "Qi", "Lcom/tencent/mobileqq/guild/home/schedule/viewmodels/GuildHomeScheduleViewModel$DateLocator;", "target", "qi", "", "time", "locateScheduleId", "Ni", "(Ljava/lang/Long;Ljava/lang/Long;)V", "Lcom/tencent/mobileqq/qqguildsdk/data/GuildScheduleInfo;", "deletedInfo", "Pi", "firstIndex", "lastIndex", "lastCompletedIndex", "Mi", "Ei", "Lcom/tencent/mobileqq/guild/home/schedule/ScheduleEntryListAdapter;", "Fi", "Lcom/tencent/mobileqq/guild/home/schedule/models/d;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Ji", "Ii", "Ki", "Hi", "Lcom/tencent/mobileqq/guild/home/schedule/models/ScheduleInfoItem;", "Gi", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;", "Li", "Lcom/tencent/mobileqq/guild/home/schedule/viewmodels/GuildHomeScheduleViewModel;", "T", "Lcom/tencent/mobileqq/guild/home/schedule/viewmodels/GuildHomeScheduleViewModel;", "viewModel", "Lcom/tencent/mobileqq/guild/home/views/widget/ScheduleRecyclerView;", "U", "Lcom/tencent/mobileqq/guild/home/views/widget/ScheduleRecyclerView;", "recyclerView", "Lcom/tencent/mobileqq/guild/home/views/sticky/StickyHeadContainer;", "V", "Lcom/tencent/mobileqq/guild/home/views/sticky/StickyHeadContainer;", "headContainer", "Landroid/widget/TextView;", "W", "Landroid/widget/TextView;", "headItemTitle", "X", "Landroid/view/View;", "btnGotoToday", "Y", "btnPickDate", "Z", "rightActionLayout", "Landroidx/recyclerview/widget/LinearLayoutManager;", "a0", "Landroidx/recyclerview/widget/LinearLayoutManager;", "linearLayoutManager", "Lcom/tencent/mobileqq/guild/widget/ShadowFrameLayout;", "b0", "Lcom/tencent/mobileqq/guild/widget/ShadowFrameLayout;", "createScheduleLayout", "Lcom/tencent/mobileqq/guild/homev2/views/widget/GuildHomeVisitorJoinView;", "c0", "Lcom/tencent/mobileqq/guild/homev2/views/widget/GuildHomeVisitorJoinView;", "visitorJoinLayout", "d0", "relocateAfterDataInsert", "e0", "Lcom/tencent/mobileqq/guild/home/schedule/viewmodels/GuildHomeScheduleViewModel$DateLocator;", "locateTarget", "f0", "Lcom/tencent/mobileqq/guild/home/schedule/ScheduleEntryListAdapter;", "adapter", "Lcom/tencent/mobileqq/guild/home/schedule/models/e;", "g0", "Lcom/tencent/mobileqq/guild/home/schedule/models/e;", "loadNext", "h0", "loadPrevious", "i0", "firstPageTargetScrolled", "Ljava/lang/Runnable;", "j0", "Ljava/lang/Runnable;", "updateTodayRunnable", "", "k0", "Ljava/util/List;", "adapterPendingItems", "l0", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;", "jumpGuildParam", "m0", "Ljava/lang/String;", "guildId", "n0", "scheduleChannelId", "o0", "I", "space", "com/tencent/mobileqq/guild/home/schedule/list/GuildHomeScheduleListFragment$i", "p0", "Lcom/tencent/mobileqq/guild/home/schedule/list/GuildHomeScheduleListFragment$i;", "pickDateListener", "<init>", "()V", "q0", "a", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildHomeScheduleListFragment extends QQGuildTokenTitleBarFragment {

    /* renamed from: q0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: T, reason: from kotlin metadata */
    private GuildHomeScheduleViewModel viewModel;

    /* renamed from: U, reason: from kotlin metadata */
    private ScheduleRecyclerView recyclerView;

    /* renamed from: V, reason: from kotlin metadata */
    private StickyHeadContainer headContainer;

    /* renamed from: W, reason: from kotlin metadata */
    private TextView headItemTitle;

    /* renamed from: X, reason: from kotlin metadata */
    private View btnGotoToday;

    /* renamed from: Y, reason: from kotlin metadata */
    private View btnPickDate;

    /* renamed from: Z, reason: from kotlin metadata */
    private View rightActionLayout;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private LinearLayoutManager linearLayoutManager;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private ShadowFrameLayout createScheduleLayout;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private GuildHomeVisitorJoinView visitorJoinLayout;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private boolean relocateAfterDataInsert;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GuildHomeScheduleViewModel.DateLocator locateTarget;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ScheduleEntryListAdapter adapter = Fi();

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ScheduleLoadingItem loadNext = new ScheduleLoadingItem(2, "LoadNext");

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ScheduleLoadingItem loadPrevious = new ScheduleLoadingItem(3, "LoadPrevious");

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    private boolean firstPageTargetScrolled = true;

    /* renamed from: j0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Runnable updateTodayRunnable;

    /* renamed from: k0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<? extends com.tencent.mobileqq.guild.home.schedule.models.d> adapterPendingItems;

    /* renamed from: l0, reason: collision with root package name and from kotlin metadata */
    private JumpGuildParam jumpGuildParam;

    /* renamed from: m0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String guildId;

    /* renamed from: n0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String scheduleChannelId;

    /* renamed from: o0, reason: collision with root package name and from kotlin metadata */
    private final int space;

    /* renamed from: p0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final i pickDateListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007R\u0014\u0010\n\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\r8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000b\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/guild/home/schedule/list/GuildHomeScheduleListFragment$a;", "", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;", "jump", "", "scheduleChannelId", "", "a", "PARAM_JUMP_GUILD_PARAM", "Ljava/lang/String;", "PARAM_SCHEDULE_CHANNEL_ID", "", "REQUEST_CODE", "I", "TAG", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.home.schedule.list.GuildHomeScheduleListFragment$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void a(@NotNull Context context, @NotNull JumpGuildParam jump, @NotNull String scheduleChannelId) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(jump, "jump");
            Intrinsics.checkNotNullParameter(scheduleChannelId, "scheduleChannelId");
            Bundle bundle = new Bundle();
            bundle.putParcelable("param_jump_guild_param", jump);
            bundle.putString("param_schedule_channel_id", scheduleChannelId);
            Intent intent = new Intent();
            intent.putExtras(bundle);
            GuildSplitViewUtils.p(GuildSplitViewUtils.f235370a, context, intent, GuildHomeScheduleListFragment.class, null, 8, null);
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u0002H\u0016R\"\u0010\u0012\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/guild/home/schedule/list/GuildHomeScheduleListFragment$b;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "", "findLastVisibleItemPosition", "findLastCompletelyVisibleItemPosition", "getPaddingBottom", "position", "offset", "", "scrollToPositionWithOffset", "scrollToPosition", "", "d", "Z", "getNoPaddingFlag", "()Z", "setNoPaddingFlag", "(Z)V", "noPaddingFlag", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b extends LinearLayoutManager {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private boolean noPaddingFlag;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull Context context) {
            super(context, 1, false);
            Intrinsics.checkNotNullParameter(context, "context");
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager
        public int findLastCompletelyVisibleItemPosition() {
            this.noPaddingFlag = true;
            int findLastCompletelyVisibleItemPosition = super.findLastCompletelyVisibleItemPosition();
            this.noPaddingFlag = false;
            return findLastCompletelyVisibleItemPosition;
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager
        public int findLastVisibleItemPosition() {
            this.noPaddingFlag = true;
            int findLastVisibleItemPosition = super.findLastVisibleItemPosition();
            this.noPaddingFlag = false;
            return findLastVisibleItemPosition;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
        public int getPaddingBottom() {
            if (this.noPaddingFlag) {
                return 0;
            }
            return super.getPaddingBottom();
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public void scrollToPosition(int position) {
            Logger logger = Logger.f235387a;
            if (QLog.isDevelopLevel()) {
                Log.d("Guild.NewHome.subFrag.GuildHomeScheduleListFragment", "scrollToPosition(" + position + ")");
            }
            super.scrollToPosition(position);
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager
        public void scrollToPositionWithOffset(int position, int offset) {
            Logger logger = Logger.f235387a;
            if (QLog.isDevelopLevel()) {
                Log.d("Guild.NewHome.subFrag.GuildHomeScheduleListFragment", "scrollToPositionWithOffset(" + position + ", " + offset + ")");
            }
            super.scrollToPositionWithOffset(position, offset);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/home/schedule/list/GuildHomeScheduleListFragment$c", "Landroidx/fragment/app/FragmentResultListener;", "", "requestKey", "Landroid/os/Bundle;", "result", "", "onFragmentResult", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class c implements FragmentResultListener {
        c() {
        }

        @Override // androidx.fragment.app.FragmentResultListener
        public void onFragmentResult(@NotNull String requestKey, @NotNull Bundle result) {
            GuildScheduleInfo guildScheduleInfo;
            Long l3;
            Intrinsics.checkNotNullParameter(requestKey, "requestKey");
            Intrinsics.checkNotNullParameter(result, "result");
            Serializable serializable = result.getSerializable("success_schedule_info");
            if (serializable instanceof GuildScheduleInfo) {
                guildScheduleInfo = (GuildScheduleInfo) serializable;
            } else {
                guildScheduleInfo = null;
            }
            if (GuildHomeScheduleListFragment.this.Pi(guildScheduleInfo)) {
                return;
            }
            Serializable serializable2 = result.getSerializable("success_schedule_info_start_time");
            if (serializable2 instanceof Long) {
                l3 = (Long) serializable2;
            } else {
                l3 = null;
            }
            GuildHomeScheduleListFragment.Oi(GuildHomeScheduleListFragment.this, l3, null, 2, null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004\"\u0006\b\u0000\u0010\u0000\u0018\u00012\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00028\u0000 \u0002*\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00010\u0001H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"T", "Lef1/a;", "kotlin.jvm.PlatformType", "it", "", "a", "(Lef1/a;)V"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class d<T> implements Observer {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Object f225169d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Observer f225170e;

        public d(Object obj, Observer observer) {
            this.f225169d = obj;
            this.f225170e = observer;
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(ef1.a<T> aVar) {
            T b16;
            if (aVar != null && (b16 = aVar.b(this.f225169d)) != null) {
                this.f225170e.onChanged(b16);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/guild/home/schedule/list/GuildHomeScheduleListFragment$e", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "dx", "dy", "", "onScrolled", "newState", "onScrollStateChanged", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class e extends RecyclerView.OnScrollListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ View f225172e;

        e(View view) {
            this.f225172e = view;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void e(GuildHomeScheduleListFragment this$0, int i3) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            LinearLayoutManager linearLayoutManager = this$0.linearLayoutManager;
            if (linearLayoutManager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("linearLayoutManager");
                linearLayoutManager = null;
            }
            this$0.Ri("onScrolled " + i3 + " " + linearLayoutManager.findLastVisibleItemPosition());
            this$0.updateTodayRunnable = null;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int newState) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, newState);
            Logger logger = Logger.f235387a;
            GuildHomeScheduleListFragment guildHomeScheduleListFragment = GuildHomeScheduleListFragment.this;
            if (QLog.isDevelopLevel()) {
                Log.d("Guild.NewHome.subFrag.GuildHomeScheduleListFragment", "onScrollStateChanged() " + guildHomeScheduleListFragment.locateTarget);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NotNull RecyclerView recyclerView, int dx5, final int dy5) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            GuildHomeScheduleListFragment.Bi(GuildHomeScheduleListFragment.this, "onScrolled " + dy5, false, false, 6, null);
            if (GuildHomeScheduleListFragment.this.updateTodayRunnable != null) {
                this.f225172e.removeCallbacks(GuildHomeScheduleListFragment.this.updateTodayRunnable);
                this.f225172e.post(GuildHomeScheduleListFragment.this.updateTodayRunnable);
            } else {
                final GuildHomeScheduleListFragment guildHomeScheduleListFragment = GuildHomeScheduleListFragment.this;
                guildHomeScheduleListFragment.updateTodayRunnable = new Runnable() { // from class: com.tencent.mobileqq.guild.home.schedule.list.m
                    @Override // java.lang.Runnable
                    public final void run() {
                        GuildHomeScheduleListFragment.e.e(GuildHomeScheduleListFragment.this, dy5);
                    }
                };
                this.f225172e.post(GuildHomeScheduleListFragment.this.updateTodayRunnable);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/guild/home/schedule/list/GuildHomeScheduleListFragment$f", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "", "positionStart", "itemCount", "", "onItemRangeInserted", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class f extends RecyclerView.AdapterDataObserver {
        f() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeInserted(int positionStart, int itemCount) {
            super.onItemRangeInserted(positionStart, itemCount);
            if (GuildHomeScheduleListFragment.this.relocateAfterDataInsert) {
                GuildHomeScheduleListFragment.this.relocateAfterDataInsert = false;
                GuildHomeScheduleListFragment.this.Qi("[onItemRangeInserted]");
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/guild/home/schedule/list/GuildHomeScheduleListFragment$g", "Lip1/a;", "", "offset", "", "a", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class g implements ip1.a {
        g() {
        }

        @Override // ip1.a
        public void a(int offset) {
            StickyHeadContainer stickyHeadContainer = GuildHomeScheduleListFragment.this.headContainer;
            StickyHeadContainer stickyHeadContainer2 = null;
            if (stickyHeadContainer == null) {
                Intrinsics.throwUninitializedPropertyAccessException("headContainer");
                stickyHeadContainer = null;
            }
            stickyHeadContainer.setTranslationY(offset);
            StickyHeadContainer stickyHeadContainer3 = GuildHomeScheduleListFragment.this.headContainer;
            if (stickyHeadContainer3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("headContainer");
            } else {
                stickyHeadContainer2 = stickyHeadContainer3;
            }
            stickyHeadContainer2.setVisibility(0);
        }

        @Override // ip1.a
        public void b() {
            StickyHeadContainer stickyHeadContainer = GuildHomeScheduleListFragment.this.headContainer;
            if (stickyHeadContainer == null) {
                Intrinsics.throwUninitializedPropertyAccessException("headContainer");
                stickyHeadContainer = null;
            }
            stickyHeadContainer.setVisibility(8);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JR\u0010\u000e\u001a\u00020\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0016\u00a8\u0006\u000f"}, d2 = {"com/tencent/mobileqq/guild/home/schedule/list/GuildHomeScheduleListFragment$h", "Landroid/view/View$OnLayoutChangeListener;", "Landroid/view/View;", "v", "", "left", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "", "onLayoutChange", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class h implements View.OnLayoutChangeListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f225175d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ GuildHomeScheduleListFragment f225176e;

        h(View view, GuildHomeScheduleListFragment guildHomeScheduleListFragment) {
            this.f225175d = view;
            this.f225176e = guildHomeScheduleListFragment;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(GuildHomeScheduleListFragment this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.adapter.notifyDataSetChanged();
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(@Nullable View v3, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
            if (right - left != oldRight - oldLeft) {
                View view = this.f225175d;
                final GuildHomeScheduleListFragment guildHomeScheduleListFragment = this.f225176e;
                view.post(new Runnable() { // from class: com.tencent.mobileqq.guild.home.schedule.list.n
                    @Override // java.lang.Runnable
                    public final void run() {
                        GuildHomeScheduleListFragment.h.b(GuildHomeScheduleListFragment.this);
                    }
                });
            }
            GuildHomeScheduleListFragment.Bi(this.f225176e, "onLayoutChange", false, false, 6, null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/home/schedule/list/GuildHomeScheduleListFragment$i", "Lcom/tencent/mobileqq/guild/home/views/dialog/ScheduleDateLocatorDialog$c;", "", "dateInMillis", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class i implements ScheduleDateLocatorDialog.c {
        i() {
        }

        @Override // com.tencent.mobileqq.guild.home.views.dialog.ScheduleDateLocatorDialog.c
        public void a(long dateInMillis) {
            GuildHomeScheduleViewModel guildHomeScheduleViewModel = GuildHomeScheduleListFragment.this.viewModel;
            if (guildHomeScheduleViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                guildHomeScheduleViewModel = null;
            }
            GuildHomeScheduleViewModel.y2(guildHomeScheduleViewModel, true, dateInMillis, 0, null, null, 28, null);
        }
    }

    public GuildHomeScheduleListFragment() {
        List<? extends com.tencent.mobileqq.guild.home.schedule.models.d> emptyList;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.adapterPendingItems = emptyList;
        this.guildId = "";
        this.scheduleChannelId = "";
        this.space = ViewUtils.dpToPx(150.0f);
        this.pickDateListener = new i();
    }

    /* JADX WARN: Removed duplicated region for block: B:87:0x03df A[LOOP:2: B:84:0x0394->B:87:0x03df, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x03e8 A[EDGE_INSN: B:88:0x03e8->B:89:0x03e8 BREAK  A[LOOP:2: B:84:0x0394->B:87:0x03df], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void Ai(String from, boolean smooth, boolean tryAgain) {
        Object firstOrNull;
        Object firstOrNull2;
        String str;
        String str2;
        String str3;
        String str4;
        Logger logger;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        int i3;
        int i16;
        GuildHomeScheduleViewModel.DateLocator dateLocator = this.locateTarget;
        Logger logger2 = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger2.d().d("Guild.NewHome.subFrag.GuildHomeScheduleListFragment", 1, "locateTargetByScroll[" + from + ", " + smooth + "] onLayoutChange locate flag? " + dateLocator);
        }
        if (this.adapterPendingItems.size() == this.adapter.getItems().size()) {
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) this.adapterPendingItems);
            com.tencent.mobileqq.guild.home.schedule.models.d dVar = (com.tencent.mobileqq.guild.home.schedule.models.d) firstOrNull;
            Integer valueOf = dVar != null ? Integer.valueOf(dVar.getType()) : null;
            List<com.tencent.mobileqq.guild.home.schedule.models.d> items = this.adapter.getItems();
            Intrinsics.checkNotNullExpressionValue(items, "adapter.items");
            firstOrNull2 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) items);
            com.tencent.mobileqq.guild.home.schedule.models.d dVar2 = (com.tencent.mobileqq.guild.home.schedule.models.d) firstOrNull2;
            if (Intrinsics.areEqual(valueOf, dVar2 != null ? Integer.valueOf(dVar2.getType()) : null)) {
                if (dateLocator != null) {
                    final int ri5 = ri(this, dateLocator, null, 2, null);
                    if (ri5 < 0) {
                        Logger.b bVar = new Logger.b();
                        String str11 = "locateTargetByScroll locate flag? " + ri5 + ", not find the index";
                        if (str11 instanceof String) {
                            bVar.a().add(str11);
                        }
                        Iterator<T> it = bVar.a().iterator();
                        while (it.hasNext()) {
                            Logger.f235387a.d().e("Guild.NewHome.subFrag.GuildHomeScheduleListFragment", 1, (String) it.next(), null);
                        }
                        try {
                            s.e("Guild.NewHome.subFrag.GuildHomeScheduleListFragment", "locateTargetByScroll locate flag? " + ri5 + ", not find the index", new IllegalStateException());
                        } catch (Exception unused) {
                        }
                        this.locateTarget = null;
                        return;
                    }
                    ScheduleRecyclerView scheduleRecyclerView = this.recyclerView;
                    if (scheduleRecyclerView == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                        scheduleRecyclerView = null;
                    }
                    RecyclerView.ViewHolder findViewHolderForAdapterPosition = scheduleRecyclerView.findViewHolderForAdapterPosition(ri5);
                    if (findViewHolderForAdapterPosition != null) {
                        if (QLog.isColorLevel()) {
                            Logger.a d16 = logger2.d();
                            int adapterPosition = findViewHolderForAdapterPosition.getAdapterPosition();
                            str3 = ")";
                            int top = findViewHolderForAdapterPosition.itemView.getTop();
                            ScheduleRecyclerView scheduleRecyclerView2 = this.recyclerView;
                            if (scheduleRecyclerView2 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                                str4 = "linearLayoutManager";
                                scheduleRecyclerView2 = null;
                            } else {
                                str4 = "linearLayoutManager";
                            }
                            int top2 = scheduleRecyclerView2.getTop();
                            str2 = " ";
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append("locateTargetByScroll locate flag? ");
                            sb5.append(ri5);
                            str = "locateTargetByScroll locate flag? ";
                            sb5.append(" adapterPosition->");
                            sb5.append(adapterPosition);
                            sb5.append(", top: ");
                            sb5.append(top);
                            sb5.append(" -- ");
                            sb5.append(top2);
                            d16.d("Guild.NewHome.subFrag.GuildHomeScheduleListFragment", 1, sb5.toString());
                        } else {
                            str = "locateTargetByScroll locate flag? ";
                            str2 = " ";
                            str3 = ")";
                            str4 = "linearLayoutManager";
                        }
                        Rect rect = new Rect();
                        Rect rect2 = new Rect();
                        findViewHolderForAdapterPosition.itemView.getGlobalVisibleRect(rect);
                        ScheduleRecyclerView scheduleRecyclerView3 = this.recyclerView;
                        if (scheduleRecyclerView3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                            scheduleRecyclerView3 = null;
                        }
                        scheduleRecyclerView3.getGlobalVisibleRect(rect2);
                        if (findViewHolderForAdapterPosition instanceof DayGroupDelegate.b) {
                            if (QLog.isColorLevel()) {
                                logger2.d().d("Guild.NewHome.subFrag.GuildHomeScheduleListFragment", 1, "locateTargetByScroll[" + from + "] DayGroupDelegate -> " + ((Object) ((DayGroupDelegate.b) findViewHolderForAdapterPosition).getItemTitle().getText()));
                            }
                        } else if (findViewHolderForAdapterPosition instanceof ScheduleEntryDelegate.b) {
                            if (QLog.isColorLevel()) {
                                Logger.a d17 = logger2.d();
                                ScheduleInfoItem item = ((ScheduleEntryDelegate.b) findViewHolderForAdapterPosition).getItem();
                                d17.d("Guild.NewHome.subFrag.GuildHomeScheduleListFragment", 1, "locateTargetByScroll[" + from + "] ScheduleEntryDelegate -> " + (item != null ? item.getText() : null));
                            }
                        } else if ((findViewHolderForAdapterPosition instanceof ScheduleEmptyEntryDelegate.a) && QLog.isColorLevel()) {
                            Logger.a d18 = logger2.d();
                            ScheduleEmptyEntryDelegate.a aVar = (ScheduleEmptyEntryDelegate.a) findViewHolderForAdapterPosition;
                            ScheduleEmptyPlaceholderItem item2 = aVar.getItem();
                            Boolean valueOf2 = item2 != null ? Boolean.valueOf(item2.getIsToday()) : null;
                            ScheduleEmptyPlaceholderItem item3 = aVar.getItem();
                            d18.d("Guild.NewHome.subFrag.GuildHomeScheduleListFragment", 1, "locateTargetByScroll[" + from + "] ScheduleEmptyEntryDelegate -> today=" + valueOf2 + "/" + (item3 != null ? item3.getDate() : null));
                        }
                        final Ref.IntRef intRef = new Ref.IntRef();
                        if (this.adapter.getItems().size() > ri5 && !(this.adapter.getItems().get(ri5) instanceof DayGroupItem)) {
                            intRef.element = (int) cw.b(48);
                        }
                        int height = (rect2.bottom - findViewHolderForAdapterPosition.itemView.getHeight()) - rect2.top;
                        if (QLog.isColorLevel()) {
                            Logger.a d19 = logger2.d();
                            int i17 = rect.bottom;
                            int i18 = rect2.bottom;
                            int i19 = rect.top;
                            logger = logger2;
                            int i26 = rect2.top;
                            str5 = "locateTargetByScroll[";
                            int i27 = intRef.element;
                            str6 = "recyclerView";
                            StringBuilder sb6 = new StringBuilder();
                            str8 = str;
                            sb6.append(str8);
                            sb6.append(i17);
                            sb6.append(",");
                            sb6.append(i18);
                            str7 = str2;
                            sb6.append(str7);
                            sb6.append(ri5);
                            sb6.append(", top: ");
                            sb6.append(i19);
                            sb6.append(" -- ");
                            sb6.append(i26);
                            sb6.append(" offset=");
                            sb6.append(i27);
                            sb6.append(" maxPadding= ");
                            sb6.append(height);
                            d19.d("Guild.NewHome.subFrag.GuildHomeScheduleListFragment", 1, sb6.toString());
                        } else {
                            logger = logger2;
                            str5 = "locateTargetByScroll[";
                            str6 = "recyclerView";
                            str7 = str2;
                            str8 = str;
                        }
                        if (rect.top > rect2.top + intRef.element) {
                            String str12 = str8;
                            LinearLayoutManager linearLayoutManager = this.linearLayoutManager;
                            if (linearLayoutManager == null) {
                                Intrinsics.throwUninitializedPropertyAccessException(str4);
                                linearLayoutManager = null;
                            }
                            int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
                            LinearLayoutManager linearLayoutManager2 = this.linearLayoutManager;
                            if (linearLayoutManager2 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException(str4);
                                linearLayoutManager2 = null;
                            }
                            int findLastVisibleItemPosition = linearLayoutManager2.findLastVisibleItemPosition();
                            ScheduleRecyclerView scheduleRecyclerView4 = this.recyclerView;
                            if (scheduleRecyclerView4 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException(str6);
                                scheduleRecyclerView4 = null;
                            }
                            RecyclerView.ViewHolder findViewHolderForAdapterPosition2 = scheduleRecyclerView4.findViewHolderForAdapterPosition(findLastVisibleItemPosition);
                            if (findViewHolderForAdapterPosition2 == null) {
                                Logger.b bVar2 = new Logger.b();
                                String str13 = str5 + from + "] " + findLastVisibleItemPosition + " not find the viewHolder! ";
                                if (str13 instanceof String) {
                                    bVar2.a().add(str13);
                                }
                                Iterator<T> it5 = bVar2.a().iterator();
                                while (it5.hasNext()) {
                                    Logger.f235387a.d().e("Guild.NewHome.subFrag.GuildHomeScheduleListFragment", 1, (String) it5.next(), null);
                                }
                                return;
                            }
                            Rect rect3 = new Rect();
                            findViewHolderForAdapterPosition2.itemView.getGlobalVisibleRect(rect3);
                            if (!QLog.isDebugVersion() || findFirstVisibleItemPosition > findLastVisibleItemPosition) {
                                i3 = ri5;
                            } else {
                                int i28 = findFirstVisibleItemPosition;
                                while (true) {
                                    if (findFirstVisibleItemPosition >= 0) {
                                        ScheduleRecyclerView scheduleRecyclerView5 = this.recyclerView;
                                        if (scheduleRecyclerView5 == null) {
                                            Intrinsics.throwUninitializedPropertyAccessException(str6);
                                            scheduleRecyclerView5 = null;
                                        }
                                        RecyclerView.ViewHolder findViewHolderForAdapterPosition3 = scheduleRecyclerView5.findViewHolderForAdapterPosition(i28);
                                        com.tencent.mobileqq.guild.home.schedule.models.d dVar3 = this.adapter.getItems().get(i28);
                                        Logger logger3 = Logger.f235387a;
                                        if (QLog.isDevelopLevel()) {
                                            i16 = findFirstVisibleItemPosition;
                                            StringBuilder sb7 = new StringBuilder();
                                            sb7.append(i28);
                                            i3 = ri5;
                                            sb7.append(MsgSummary.STR_COLON);
                                            sb7.append(dVar3);
                                            sb7.append(str7);
                                            sb7.append(findViewHolderForAdapterPosition3);
                                            Log.d("Guild.NewHome.subFrag.GuildHomeScheduleListFragment", sb7.toString());
                                            if (i28 != findLastVisibleItemPosition) {
                                                break;
                                            }
                                            i28++;
                                            findFirstVisibleItemPosition = i16;
                                            ri5 = i3;
                                        }
                                    }
                                    i3 = ri5;
                                    i16 = findFirstVisibleItemPosition;
                                    if (i28 != findLastVisibleItemPosition) {
                                    }
                                }
                            }
                            int i29 = (rect2.bottom - rect3.bottom) + (rect.top - (rect2.top + intRef.element)) + 1;
                            ScheduleRecyclerView scheduleRecyclerView6 = this.recyclerView;
                            if (scheduleRecyclerView6 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException(str6);
                                scheduleRecyclerView6 = null;
                            }
                            if (scheduleRecyclerView6.getPaddingBottom() < i29 && i29 <= height) {
                                ScheduleRecyclerView scheduleRecyclerView7 = this.recyclerView;
                                if (scheduleRecyclerView7 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException(str6);
                                    scheduleRecyclerView7 = null;
                                }
                                ViewExtKt.c(scheduleRecyclerView7, Math.max(i29, this.space));
                                Logger logger4 = Logger.f235387a;
                                if (QLog.isColorLevel()) {
                                    logger4.d().d("Guild.NewHome.subFrag.GuildHomeScheduleListFragment", 1, str12 + rect3.bottom + " / " + rect2.top + " - " + rect2.bottom + " setPaddingBottom(" + i29 + str3);
                                }
                            } else {
                                Logger logger5 = Logger.f235387a;
                                if (QLog.isColorLevel()) {
                                    Logger.a d26 = logger5.d();
                                    int i36 = rect3.bottom;
                                    int i37 = rect2.top;
                                    int i38 = rect2.bottom;
                                    ScheduleRecyclerView scheduleRecyclerView8 = this.recyclerView;
                                    if (scheduleRecyclerView8 == null) {
                                        Intrinsics.throwUninitializedPropertyAccessException(str6);
                                        scheduleRecyclerView8 = null;
                                    }
                                    d26.d("Guild.NewHome.subFrag.GuildHomeScheduleListFragment", 1, str12 + i36 + " / " + i37 + " - " + i38 + " setPaddingBottom(" + i29 + ") ignore: paddingBottom = " + scheduleRecyclerView8.getPaddingBottom());
                                }
                            }
                            if (smooth) {
                                ScheduleRecyclerView scheduleRecyclerView9 = this.recyclerView;
                                if (scheduleRecyclerView9 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException(str6);
                                    scheduleRecyclerView9 = null;
                                }
                                q.d(scheduleRecyclerView9, i3, intRef.element);
                            } else {
                                final int i39 = i3;
                                ScheduleRecyclerView scheduleRecyclerView10 = this.recyclerView;
                                if (scheduleRecyclerView10 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException(str6);
                                    scheduleRecyclerView10 = null;
                                }
                                scheduleRecyclerView10.postOnAnimation(new Runnable() { // from class: com.tencent.mobileqq.guild.home.schedule.list.h
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        GuildHomeScheduleListFragment.Ci(GuildHomeScheduleListFragment.this, i39, intRef);
                                    }
                                });
                            }
                            if (tryAgain) {
                                return;
                            }
                            this.locateTarget = null;
                            return;
                        }
                        String str14 = str8;
                        String str15 = str3;
                        LinearLayoutManager linearLayoutManager3 = this.linearLayoutManager;
                        if (linearLayoutManager3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException(str4);
                            linearLayoutManager3 = null;
                        }
                        int findLastVisibleItemPosition2 = linearLayoutManager3.findLastVisibleItemPosition();
                        ScheduleRecyclerView scheduleRecyclerView11 = this.recyclerView;
                        if (scheduleRecyclerView11 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException(str6);
                            scheduleRecyclerView11 = null;
                        }
                        RecyclerView.ViewHolder findViewHolderForAdapterPosition4 = scheduleRecyclerView11.findViewHolderForAdapterPosition(findLastVisibleItemPosition2);
                        if (findViewHolderForAdapterPosition4 != null) {
                            Rect rect4 = new Rect();
                            findViewHolderForAdapterPosition4.itemView.getGlobalVisibleRect(rect4);
                            int i46 = (rect2.bottom - rect4.bottom) + (rect.top - (rect2.top + intRef.element)) + 1;
                            if (QLog.isColorLevel()) {
                                str9 = str15;
                                logger.d().d("Guild.NewHome.subFrag.GuildHomeScheduleListFragment", 1, str14 + ri5 + ", bottom: " + rect4.bottom + " -- " + rect2.bottom);
                            } else {
                                str9 = str15;
                            }
                            int i47 = rect4.bottom;
                            if (i47 >= rect2.bottom) {
                                ScheduleRecyclerView scheduleRecyclerView12 = this.recyclerView;
                                if (scheduleRecyclerView12 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException(str6);
                                    scheduleRecyclerView12 = null;
                                }
                                if (scheduleRecyclerView12.getPaddingBottom() != 0) {
                                    if (QLog.isColorLevel()) {
                                        logger.d().d("Guild.NewHome.subFrag.GuildHomeScheduleListFragment", 1, "locateTargetByScroll locate flag? setPaddingBottom(0)");
                                    }
                                    ScheduleRecyclerView scheduleRecyclerView13 = this.recyclerView;
                                    if (scheduleRecyclerView13 == null) {
                                        Intrinsics.throwUninitializedPropertyAccessException(str6);
                                        scheduleRecyclerView13 = null;
                                    }
                                    ViewExtKt.c(scheduleRecyclerView13, 0);
                                } else {
                                    ScheduleRecyclerView scheduleRecyclerView14 = this.recyclerView;
                                    if (scheduleRecyclerView14 == null) {
                                        Intrinsics.throwUninitializedPropertyAccessException(str6);
                                        scheduleRecyclerView14 = null;
                                    }
                                    ViewExtKt.c(scheduleRecyclerView14, this.space);
                                    if (QLog.isColorLevel()) {
                                        Logger.a d27 = logger.d();
                                        ScheduleRecyclerView scheduleRecyclerView15 = this.recyclerView;
                                        if (scheduleRecyclerView15 == null) {
                                            Intrinsics.throwUninitializedPropertyAccessException(str6);
                                            scheduleRecyclerView15 = null;
                                        }
                                        d27.d("Guild.NewHome.subFrag.GuildHomeScheduleListFragment", 1, "locateTargetByScroll locate flag? ignore setPaddingBottom(already 0), recyclerView.paddingBottom=" + scheduleRecyclerView15.getPaddingBottom());
                                    }
                                }
                            } else {
                                ScheduleRecyclerView scheduleRecyclerView16 = this.recyclerView;
                                if (scheduleRecyclerView16 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException(str6);
                                    scheduleRecyclerView16 = null;
                                }
                                if (i47 + scheduleRecyclerView16.getPaddingBottom() < rect2.bottom && i46 <= height) {
                                    if (QLog.isColorLevel()) {
                                        Logger.a d28 = logger.d();
                                        int i48 = rect2.bottom;
                                        int i49 = rect4.bottom;
                                        int i56 = rect.top;
                                        int i57 = rect2.top;
                                        int i58 = intRef.element;
                                        StringBuilder sb8 = new StringBuilder();
                                        sb8.append("locateTargetByScroll locate flag? (");
                                        sb8.append(i48);
                                        sb8.append(" - ");
                                        sb8.append(i49);
                                        sb8.append(" + (");
                                        sb8.append(i56);
                                        sb8.append(" - ");
                                        sb8.append(i57);
                                        sb8.append(" - ");
                                        sb8.append(i58);
                                        sb8.append(") + 1) setPaddingBottom(");
                                        sb8.append(i46);
                                        str10 = str9;
                                        sb8.append(str10);
                                        d28.d("Guild.NewHome.subFrag.GuildHomeScheduleListFragment", 1, sb8.toString());
                                    } else {
                                        str10 = str9;
                                    }
                                    if (QLog.isColorLevel()) {
                                        Logger.a d29 = logger.d();
                                        ScheduleRecyclerView scheduleRecyclerView17 = this.recyclerView;
                                        if (scheduleRecyclerView17 == null) {
                                            Intrinsics.throwUninitializedPropertyAccessException(str6);
                                            scheduleRecyclerView17 = null;
                                        }
                                        d29.d("Guild.NewHome.subFrag.GuildHomeScheduleListFragment", 1, "locateTargetByScroll locate flag? setPaddingBottom(" + scheduleRecyclerView17.getPaddingBottom() + " -> " + i46 + str10);
                                    }
                                    ScheduleRecyclerView scheduleRecyclerView18 = this.recyclerView;
                                    if (scheduleRecyclerView18 == null) {
                                        Intrinsics.throwUninitializedPropertyAccessException(str6);
                                        scheduleRecyclerView18 = null;
                                    }
                                    ViewExtKt.c(scheduleRecyclerView18, Math.max(i46, this.space));
                                } else if (QLog.isColorLevel()) {
                                    Logger.a d36 = logger.d();
                                    ScheduleRecyclerView scheduleRecyclerView19 = this.recyclerView;
                                    if (scheduleRecyclerView19 == null) {
                                        Intrinsics.throwUninitializedPropertyAccessException(str6);
                                        scheduleRecyclerView19 = null;
                                    }
                                    d36.d("Guild.NewHome.subFrag.GuildHomeScheduleListFragment", 1, "locateTargetByScroll locate flag? ignore setPaddingBottom, recyclerView.paddingBottom=" + scheduleRecyclerView19.getPaddingBottom() + ", newPadding=" + i46);
                                }
                            }
                            if (smooth) {
                                ScheduleRecyclerView scheduleRecyclerView20 = this.recyclerView;
                                if (scheduleRecyclerView20 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException(str6);
                                    scheduleRecyclerView20 = null;
                                }
                                q.d(scheduleRecyclerView20, ri5, intRef.element);
                            } else {
                                ScheduleRecyclerView scheduleRecyclerView21 = this.recyclerView;
                                if (scheduleRecyclerView21 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException(str6);
                                    scheduleRecyclerView21 = null;
                                }
                                scheduleRecyclerView21.postOnAnimation(new Runnable() { // from class: com.tencent.mobileqq.guild.home.schedule.list.i
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        GuildHomeScheduleListFragment.Di(GuildHomeScheduleListFragment.this, ri5, intRef);
                                    }
                                });
                            }
                        }
                        if (tryAgain) {
                            return;
                        }
                        this.locateTarget = null;
                        return;
                    }
                    if (QLog.isDebugVersion()) {
                        LinearLayoutManager linearLayoutManager4 = this.linearLayoutManager;
                        if (linearLayoutManager4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("linearLayoutManager");
                            linearLayoutManager4 = null;
                        }
                        int findFirstVisibleItemPosition2 = linearLayoutManager4.findFirstVisibleItemPosition();
                        LinearLayoutManager linearLayoutManager5 = this.linearLayoutManager;
                        if (linearLayoutManager5 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("linearLayoutManager");
                            linearLayoutManager5 = null;
                        }
                        int findLastVisibleItemPosition3 = linearLayoutManager5.findLastVisibleItemPosition();
                        Logger.b bVar3 = new Logger.b();
                        String str16 = "onLayoutChange, not find viewHolder for " + dateLocator + ", (" + findFirstVisibleItemPosition2 + " .. " + findLastVisibleItemPosition3 + ")";
                        if (str16 instanceof String) {
                            bVar3.a().add(str16);
                        }
                        Iterator<T> it6 = bVar3.a().iterator();
                        while (it6.hasNext()) {
                            Logger.f235387a.d().e("Guild.NewHome.subFrag.GuildHomeScheduleListFragment", 1, (String) it6.next(), null);
                        }
                        if (findFirstVisibleItemPosition2 <= findLastVisibleItemPosition3) {
                            int i59 = findFirstVisibleItemPosition2;
                            while (true) {
                                Logger logger6 = Logger.f235387a;
                                Logger.b bVar4 = new Logger.b();
                                ScheduleRecyclerView scheduleRecyclerView22 = this.recyclerView;
                                if (scheduleRecyclerView22 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                                    scheduleRecyclerView22 = null;
                                }
                                String str17 = "onLayoutChange, " + i59 + "  " + scheduleRecyclerView22.findViewHolderForLayoutPosition(i59);
                                if (str17 instanceof String) {
                                    bVar4.a().add(str17);
                                }
                                Iterator<T> it7 = bVar4.a().iterator();
                                while (it7.hasNext()) {
                                    Logger.f235387a.d().e("Guild.NewHome.subFrag.GuildHomeScheduleListFragment", 1, (String) it7.next(), null);
                                }
                                if (i59 == findLastVisibleItemPosition3) {
                                    break;
                                } else {
                                    i59++;
                                }
                            }
                        }
                        if (findFirstVisibleItemPosition2 < 0) {
                            return;
                        }
                        ListIterator<com.tencent.mobileqq.guild.home.schedule.models.d> listIterator = this.adapter.getItems().listIterator(findFirstVisibleItemPosition2);
                        while (listIterator.hasNext()) {
                            int nextIndex = listIterator.nextIndex();
                            com.tencent.mobileqq.guild.home.schedule.models.d next = listIterator.next();
                            Logger logger7 = Logger.f235387a;
                            if (QLog.isColorLevel()) {
                                logger7.d().d("Guild.NewHome.subFrag.GuildHomeScheduleListFragment", 1, "onLayoutChange, items:, " + nextIndex + " " + next);
                            }
                        }
                        return;
                    }
                    return;
                }
                return;
            }
        }
        if (QLog.isColorLevel()) {
            logger2.d().d("Guild.NewHome.subFrag.GuildHomeScheduleListFragment", 1, "locateTargetByScroll[" + from + "], ignore items mismatch");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void Bi(GuildHomeScheduleListFragment guildHomeScheduleListFragment, String str, boolean z16, boolean z17, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        if ((i3 & 4) != 0) {
            z17 = false;
        }
        guildHomeScheduleListFragment.Ai(str, z16, z17);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ci(GuildHomeScheduleListFragment this$0, int i3, Ref.IntRef offset) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(offset, "$offset");
        LinearLayoutManager linearLayoutManager = this$0.linearLayoutManager;
        if (linearLayoutManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("linearLayoutManager");
            linearLayoutManager = null;
        }
        linearLayoutManager.scrollToPositionWithOffset(i3, offset.element);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Di(GuildHomeScheduleListFragment this$0, int i3, Ref.IntRef offset) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(offset, "$offset");
        LinearLayoutManager linearLayoutManager = this$0.linearLayoutManager;
        if (linearLayoutManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("linearLayoutManager");
            linearLayoutManager = null;
        }
        linearLayoutManager.scrollToPositionWithOffset(i3, offset.element);
    }

    private final void Ei() {
        com.tencent.mobileqq.guild.home.schedule.models.d dVar;
        LinearLayoutManager linearLayoutManager = this.linearLayoutManager;
        GuildHomeScheduleViewModel guildHomeScheduleViewModel = null;
        if (linearLayoutManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("linearLayoutManager");
            linearLayoutManager = null;
        }
        int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
        if (findFirstVisibleItemPosition < 0) {
            return;
        }
        List<com.tencent.mobileqq.guild.home.schedule.models.d> items = this.adapter.getItems();
        while (-1 < findFirstVisibleItemPosition) {
            if (items.size() > findFirstVisibleItemPosition && ((items.get(findFirstVisibleItemPosition) instanceof DayGroupItem) || (items.get(findFirstVisibleItemPosition) instanceof ScheduleInfoItem))) {
                dVar = items.get(findFirstVisibleItemPosition);
                break;
            }
            findFirstVisibleItemPosition--;
        }
        dVar = null;
        if (dVar != null) {
            Calendar a16 = com.tencent.mobileqq.guild.home.schedule.models.d.INSTANCE.a(dVar);
            if (!o.c("fastClickGuard")) {
                ScheduleDateLocatorDialog.Companion companion = ScheduleDateLocatorDialog.INSTANCE;
                FragmentManager parentFragmentManager = getParentFragmentManager();
                Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                JumpGuildParam jumpGuildParam = this.jumpGuildParam;
                if (jumpGuildParam == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("jumpGuildParam");
                    jumpGuildParam = null;
                }
                String str = jumpGuildParam.guildId;
                Intrinsics.checkNotNullExpressionValue(str, "jumpGuildParam.guildId");
                GuildHomeScheduleViewModel guildHomeScheduleViewModel2 = this.viewModel;
                if (guildHomeScheduleViewModel2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                } else {
                    guildHomeScheduleViewModel = guildHomeScheduleViewModel2;
                }
                companion.a(parentFragmentManager, str, guildHomeScheduleViewModel.getChannelId(), a16.get(1), a16.get(2) + 1, a16.get(5), this.pickDateListener);
            }
        }
    }

    private final ScheduleEntryListAdapter Fi() {
        return new ScheduleEntryListAdapter(new GuildHomeScheduleListFragment$newAdapter$1(this), new GuildHomeScheduleListFragment$newAdapter$2(this), new GuildHomeScheduleListFragment$newAdapter$3(this), new GuildHomeScheduleListFragment$newAdapter$4(this), new GuildHomeScheduleListFragment$newAdapter$5(this), new GuildHomeScheduleListFragment$newAdapter$6(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Gi(ScheduleInfoItem item) {
        GuildScheduleDetailFragment.ii(this, requireContext(), String.valueOf(item.getInfo().getScheduleId()), Li(), 100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Hi(com.tencent.mobileqq.guild.home.schedule.models.d item) {
        ScheduleEmptyPlaceholderItem scheduleEmptyPlaceholderItem;
        GuildHomeScheduleViewModel guildHomeScheduleViewModel = null;
        if (item instanceof ScheduleEmptyPlaceholderItem) {
            scheduleEmptyPlaceholderItem = (ScheduleEmptyPlaceholderItem) item;
        } else {
            scheduleEmptyPlaceholderItem = null;
        }
        if (scheduleEmptyPlaceholderItem != null && !scheduleEmptyPlaceholderItem.getIsToday()) {
            GuildNewScheduleCreateFragment.Companion companion = GuildNewScheduleCreateFragment.INSTANCE;
            JumpGuildParam jumpGuildParam = this.jumpGuildParam;
            if (jumpGuildParam == null) {
                Intrinsics.throwUninitializedPropertyAccessException("jumpGuildParam");
                jumpGuildParam = null;
            }
            String str = jumpGuildParam.guildId;
            Intrinsics.checkNotNullExpressionValue(str, "jumpGuildParam.guildId");
            GuildHomeScheduleViewModel guildHomeScheduleViewModel2 = this.viewModel;
            if (guildHomeScheduleViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            } else {
                guildHomeScheduleViewModel = guildHomeScheduleViewModel2;
            }
            companion.a(this, str, guildHomeScheduleViewModel.getChannelId(), 100, ((ScheduleEmptyPlaceholderItem) item).getDate().c());
            return;
        }
        GuildNewScheduleCreateFragment.Companion companion2 = GuildNewScheduleCreateFragment.INSTANCE;
        JumpGuildParam jumpGuildParam2 = this.jumpGuildParam;
        if (jumpGuildParam2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("jumpGuildParam");
            jumpGuildParam2 = null;
        }
        String str2 = jumpGuildParam2.guildId;
        Intrinsics.checkNotNullExpressionValue(str2, "jumpGuildParam.guildId");
        GuildHomeScheduleViewModel guildHomeScheduleViewModel3 = this.viewModel;
        if (guildHomeScheduleViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            guildHomeScheduleViewModel = guildHomeScheduleViewModel3;
        }
        GuildNewScheduleCreateFragment.Companion.b(companion2, this, str2, guildHomeScheduleViewModel.getChannelId(), 100, 0L, 16, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ii(com.tencent.mobileqq.guild.home.schedule.models.d item) {
        GuildHomeScheduleViewModel guildHomeScheduleViewModel = this.viewModel;
        if (guildHomeScheduleViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            guildHomeScheduleViewModel = null;
        }
        GuildHomeScheduleViewModel.y2(guildHomeScheduleViewModel, false, 0L, 0, null, null, 31, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ji(com.tencent.mobileqq.guild.home.schedule.models.d item) {
        GuildHomeScheduleViewModel guildHomeScheduleViewModel = this.viewModel;
        if (guildHomeScheduleViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            guildHomeScheduleViewModel = null;
        }
        guildHomeScheduleViewModel.B2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ki() {
        GuildHomeScheduleViewModel guildHomeScheduleViewModel = this.viewModel;
        if (guildHomeScheduleViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            guildHomeScheduleViewModel = null;
        }
        GuildHomeScheduleViewModel.y2(guildHomeScheduleViewModel, true, 0L, 0, null, getContext(), 14, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final JumpGuildParam Li() {
        JumpGuildParam jumpGuildParam = this.jumpGuildParam;
        GuildHomeScheduleViewModel guildHomeScheduleViewModel = null;
        if (jumpGuildParam == null) {
            Intrinsics.throwUninitializedPropertyAccessException("jumpGuildParam");
            jumpGuildParam = null;
        }
        GuildHomeScheduleViewModel guildHomeScheduleViewModel2 = this.viewModel;
        if (guildHomeScheduleViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            guildHomeScheduleViewModel = guildHomeScheduleViewModel2;
        }
        jumpGuildParam.setChannelId(guildHomeScheduleViewModel.getChannelId());
        return jumpGuildParam;
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x012e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean Mi(int firstIndex, int lastIndex, int lastCompletedIndex) {
        Object m476constructorimpl;
        Throwable m479exceptionOrNullimpl;
        boolean z16;
        View view;
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("Guild.NewHome.subFrag.GuildHomeScheduleListFragment", "shouldDisplayGotoTodayButton " + firstIndex + " .. " + lastIndex + ", adapter.items.size=" + this.adapter.getItems().size());
        }
        View view2 = null;
        boolean z17 = false;
        try {
            Result.Companion companion = Result.INSTANCE;
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        if (firstIndex >= 0 && lastIndex >= 0) {
            ListIterator<com.tencent.mobileqq.guild.home.schedule.models.d> listIterator = this.adapter.getItems().listIterator(firstIndex);
            HashSet hashSet = new HashSet();
            while (listIterator.hasNext() && listIterator.nextIndex() <= lastIndex) {
                com.tencent.mobileqq.guild.home.schedule.models.d next = listIterator.next();
                ScheduleRecyclerView scheduleRecyclerView = this.recyclerView;
                if (scheduleRecyclerView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                    scheduleRecyclerView = null;
                }
                RecyclerView.ViewHolder findViewHolderForLayoutPosition = scheduleRecyclerView.findViewHolderForLayoutPosition(listIterator.previousIndex());
                Rect rect = new Rect(0, 0, 0, 0);
                int screenHeight = ViewUtils.getScreenHeight();
                if (findViewHolderForLayoutPosition != null && (view = findViewHolderForLayoutPosition.itemView) != null) {
                    view.getGlobalVisibleRect(rect);
                }
                Logger logger2 = Logger.f235387a;
                if (QLog.isDevelopLevel()) {
                    Log.d("Guild.NewHome.subFrag.GuildHomeScheduleListFragment", listIterator.previousIndex() + " - " + rect + " " + screenHeight + " today=" + next.getIsToday() + " " + next);
                }
                if (rect.bottom < screenHeight && listIterator.previousIndex() <= lastCompletedIndex && next.getIsToday()) {
                    break;
                }
                next.getType();
                hashSet.add(Integer.valueOf(next.getType()));
            }
            if (hashSet.contains(0) || hashSet.contains(1) || hashSet.contains(5)) {
                z16 = true;
                m476constructorimpl = Result.m476constructorimpl(Boolean.valueOf(z16));
                m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
                if (m479exceptionOrNullimpl != null) {
                    View view3 = this.btnGotoToday;
                    if (view3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("btnGotoToday");
                    } else {
                        view2 = view3;
                    }
                    if (view2.getVisibility() == 0) {
                        z17 = true;
                    }
                    Logger logger3 = Logger.f235387a;
                    Logger.b bVar = new Logger.b();
                    String str = "shouldDisplayGotoTodayButton failed, origin btnGotoToday visible = " + z17;
                    if (str instanceof String) {
                        bVar.a().add(str);
                    }
                    Iterator<T> it = bVar.a().iterator();
                    while (it.hasNext()) {
                        Logger.f235387a.d().e("Guild.NewHome.subFrag.GuildHomeScheduleListFragment", 1, (String) it.next(), m479exceptionOrNullimpl);
                    }
                    m476constructorimpl = Boolean.valueOf(z17);
                }
                return ((Boolean) m476constructorimpl).booleanValue();
            }
        }
        z16 = false;
        m476constructorimpl = Result.m476constructorimpl(Boolean.valueOf(z16));
        m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
        if (m479exceptionOrNullimpl != null) {
        }
        return ((Boolean) m476constructorimpl).booleanValue();
    }

    private final void Ni(Long time, Long locateScheduleId) {
        if (time != null) {
            GuildHomeScheduleViewModel guildHomeScheduleViewModel = this.viewModel;
            if (guildHomeScheduleViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                guildHomeScheduleViewModel = null;
            }
            GuildHomeScheduleViewModel.y2(guildHomeScheduleViewModel, true, time.longValue(), 1, locateScheduleId, null, 16, null);
        }
    }

    static /* synthetic */ void Oi(GuildHomeScheduleListFragment guildHomeScheduleListFragment, Long l3, Long l16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            l16 = null;
        }
        guildHomeScheduleListFragment.Ni(l3, l16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0052 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:? A[LOOP:0: B:4:0x001d->B:48:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean Pi(GuildScheduleInfo deletedInfo) {
        int i3;
        int i16;
        GuildHomeScheduleViewModel guildHomeScheduleViewModel;
        GuildHomeScheduleViewModel guildHomeScheduleViewModel2;
        GuildHomeScheduleViewModel guildHomeScheduleViewModel3;
        boolean z16;
        int i17 = 0;
        if (deletedInfo == null) {
            return false;
        }
        long startTimeMs = deletedInfo.getStartTimeMs();
        List<com.tencent.mobileqq.guild.home.schedule.models.d> items = this.adapter.getItems();
        Intrinsics.checkNotNullExpressionValue(items, "adapter.items");
        ListIterator<com.tencent.mobileqq.guild.home.schedule.models.d> listIterator = items.listIterator(items.size());
        while (true) {
            i3 = -1;
            if (listIterator.hasPrevious()) {
                com.tencent.mobileqq.guild.home.schedule.models.d previous = listIterator.previous();
                if (previous instanceof ScheduleInfoItem) {
                    ScheduleInfoItem scheduleInfoItem = (ScheduleInfoItem) previous;
                    if (scheduleInfoItem.getInfo().getStartTimeMs() <= startTimeMs && scheduleInfoItem.getInfo().getScheduleId() != deletedInfo.getScheduleId()) {
                        z16 = true;
                        if (!z16) {
                            i16 = listIterator.nextIndex();
                            break;
                        }
                    }
                }
                z16 = false;
                if (!z16) {
                }
            } else {
                i16 = -1;
                break;
            }
        }
        if (i16 >= 0) {
            com.tencent.mobileqq.guild.home.schedule.models.d item = this.adapter.getItems().get(i16);
            GuildHomeScheduleViewModel guildHomeScheduleViewModel4 = this.viewModel;
            if (guildHomeScheduleViewModel4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                guildHomeScheduleViewModel3 = null;
            } else {
                guildHomeScheduleViewModel3 = guildHomeScheduleViewModel4;
            }
            d.Companion companion = com.tencent.mobileqq.guild.home.schedule.models.d.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(item, "item");
            GuildHomeScheduleViewModel.y2(guildHomeScheduleViewModel3, true, companion.a(item).getTimeInMillis(), 1, null, null, 24, null);
            return true;
        }
        List<com.tencent.mobileqq.guild.home.schedule.models.d> items2 = this.adapter.getItems();
        Intrinsics.checkNotNullExpressionValue(items2, "adapter.items");
        Iterator<com.tencent.mobileqq.guild.home.schedule.models.d> it = items2.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            if (it.next() instanceof ScheduleInfoItem) {
                i3 = i17;
                break;
            }
            i17++;
        }
        if (i3 >= 0) {
            com.tencent.mobileqq.guild.home.schedule.models.d item2 = this.adapter.getItems().get(i3);
            GuildHomeScheduleViewModel guildHomeScheduleViewModel5 = this.viewModel;
            if (guildHomeScheduleViewModel5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                guildHomeScheduleViewModel2 = null;
            } else {
                guildHomeScheduleViewModel2 = guildHomeScheduleViewModel5;
            }
            d.Companion companion2 = com.tencent.mobileqq.guild.home.schedule.models.d.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(item2, "item");
            GuildHomeScheduleViewModel.y2(guildHomeScheduleViewModel2, true, companion2.a(item2).getTimeInMillis(), 1, null, null, 24, null);
            return true;
        }
        GuildHomeScheduleViewModel guildHomeScheduleViewModel6 = this.viewModel;
        if (guildHomeScheduleViewModel6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            guildHomeScheduleViewModel = null;
        } else {
            guildHomeScheduleViewModel = guildHomeScheduleViewModel6;
        }
        GuildHomeScheduleViewModel.y2(guildHomeScheduleViewModel, true, 0L, 0, null, null, 30, null);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Qi(String from) {
        int i3;
        GuildHomeScheduleViewModel guildHomeScheduleViewModel = this.viewModel;
        LinearLayoutManager linearLayoutManager = null;
        if (guildHomeScheduleViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            guildHomeScheduleViewModel = null;
        }
        int qi5 = qi(guildHomeScheduleViewModel.getBaseDate(), from);
        if (qi5 >= 0) {
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("Guild.NewHome.subFrag.GuildHomeScheduleListFragment", 1, "tryLocateToBaseLocator(" + from + ") scrollToPositionWithOffset, index = " + qi5 + "  " + this.adapter.getItems().get(qi5) + " ");
            }
            GuildHomeScheduleViewModel guildHomeScheduleViewModel2 = this.viewModel;
            if (guildHomeScheduleViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                guildHomeScheduleViewModel2 = null;
            }
            this.locateTarget = guildHomeScheduleViewModel2.getBaseDate();
            if (this.adapter.getItems().size() > qi5 && !(this.adapter.getItems().get(qi5) instanceof DayGroupItem)) {
                i3 = (int) cw.b(48);
            } else {
                i3 = 0;
            }
            LinearLayoutManager linearLayoutManager2 = this.linearLayoutManager;
            if (linearLayoutManager2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("linearLayoutManager");
            } else {
                linearLayoutManager = linearLayoutManager2;
            }
            linearLayoutManager.scrollToPositionWithOffset(qi5, i3);
            return;
        }
        this.relocateAfterDataInsert = true;
        Logger logger2 = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger2.d().d("Guild.NewHome.subFrag.GuildHomeScheduleListFragment", 1, "liveEventFinishLoadFirstPage, scrollToPositionWithOffset, index = " + qi5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ri(String source) {
        int i3;
        boolean z16;
        Boolean bool;
        LinearLayoutManager linearLayoutManager = this.linearLayoutManager;
        ScheduleRecyclerView scheduleRecyclerView = null;
        if (linearLayoutManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("linearLayoutManager");
            linearLayoutManager = null;
        }
        int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
        LinearLayoutManager linearLayoutManager2 = this.linearLayoutManager;
        if (linearLayoutManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("linearLayoutManager");
            linearLayoutManager2 = null;
        }
        int findLastVisibleItemPosition = linearLayoutManager2.findLastVisibleItemPosition();
        LinearLayoutManager linearLayoutManager3 = this.linearLayoutManager;
        if (linearLayoutManager3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("linearLayoutManager");
            linearLayoutManager3 = null;
        }
        boolean Mi = Mi(findFirstVisibleItemPosition, findLastVisibleItemPosition, linearLayoutManager3.findLastCompletelyVisibleItemPosition());
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("Guild.NewHome.subFrag.GuildHomeScheduleListFragment", "updateViewsVisibility: showToday=" + Mi + ", " + source);
        }
        View view = this.btnGotoToday;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnGotoToday");
            view = null;
        }
        boolean z17 = false;
        if (Mi) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        view.setVisibility(i3);
        View view2 = this.rightActionLayout;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rightActionLayout");
            view2 = null;
        }
        view2.requestLayout();
        ScheduleRecyclerView scheduleRecyclerView2 = this.recyclerView;
        if (scheduleRecyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            scheduleRecyclerView2 = null;
        }
        if (scheduleRecyclerView2.getVisibility() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16 && this.locateTarget == null) {
            GuildHomeScheduleViewModel guildHomeScheduleViewModel = this.viewModel;
            if (guildHomeScheduleViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                guildHomeScheduleViewModel = null;
            }
            ef1.a<Boolean> value = guildHomeScheduleViewModel.n2().getValue();
            if (value != null) {
                bool = value.a();
            } else {
                bool = null;
            }
            if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
                ScheduleRecyclerView scheduleRecyclerView3 = this.recyclerView;
                if (scheduleRecyclerView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                    scheduleRecyclerView3 = null;
                }
                scheduleRecyclerView3.setVisibility(0);
                Logger logger2 = Logger.f235387a;
                if (QLog.isColorLevel()) {
                    logger2.d().d("Guild.NewHome.subFrag.GuildHomeScheduleListFragment", 1, "update Visibility -> change recyclerview visible=visible");
                }
            }
        }
        if (QLog.isDevelopLevel()) {
            ScheduleRecyclerView scheduleRecyclerView4 = this.recyclerView;
            if (scheduleRecyclerView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            } else {
                scheduleRecyclerView = scheduleRecyclerView4;
            }
            if (scheduleRecyclerView.getVisibility() == 0) {
                z17 = true;
            }
            Log.d("Guild.NewHome.subFrag.GuildHomeScheduleListFragment", "updateViewsVisibility: recyclerView.isVisible=" + z17 + ", " + source);
        }
    }

    private final void initData() {
        GuildHomeScheduleViewModel guildHomeScheduleViewModel;
        FragmentActivity activity;
        FragmentManager supportFragmentManager;
        GuildSplitViewUtils guildSplitViewUtils = GuildSplitViewUtils.f235370a;
        JumpGuildParam jumpGuildParam = (JumpGuildParam) guildSplitViewUtils.g(this).getParcelable("param_jump_guild_param");
        if (jumpGuildParam == null) {
            return;
        }
        this.jumpGuildParam = jumpGuildParam;
        String str = jumpGuildParam.guildId;
        Intrinsics.checkNotNullExpressionValue(str, "jumpGuildParam.guildId");
        this.guildId = str;
        String string = guildSplitViewUtils.g(this).getString("param_schedule_channel_id");
        if (string == null) {
            string = "";
        }
        this.scheduleChannelId = string;
        if (guildSplitViewUtils.n(getActivity())) {
            guildHomeScheduleViewModel = (GuildHomeScheduleViewModel) ef1.c.INSTANCE.b(this, GuildHomeScheduleViewModel.class, this.guildId, this.scheduleChannelId);
        } else {
            c.Companion companion = ef1.c.INSTANCE;
            FragmentActivity requireActivity = requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            guildHomeScheduleViewModel = (GuildHomeScheduleViewModel) companion.b(requireActivity, GuildHomeScheduleViewModel.class, this.guildId, this.scheduleChannelId);
        }
        this.viewModel = guildHomeScheduleViewModel;
        GuildHomeScheduleViewModel guildHomeScheduleViewModel2 = null;
        if (guildHomeScheduleViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            guildHomeScheduleViewModel = null;
        }
        guildHomeScheduleViewModel.J2(this.guildId, this.scheduleChannelId);
        if (!Intrinsics.areEqual(this.scheduleChannelId, "0")) {
            Logger.f235387a.d().i("Guild.NewHome.subFrag.GuildHomeScheduleListFragment", 1, "update channelId " + this.scheduleChannelId);
            GuildHomeScheduleViewModel guildHomeScheduleViewModel3 = this.viewModel;
            if (guildHomeScheduleViewModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                guildHomeScheduleViewModel3 = null;
            }
            guildHomeScheduleViewModel3.G2(this.scheduleChannelId);
            this.adapter.o0(this.scheduleChannelId);
        }
        GuildHomeScheduleViewModel guildHomeScheduleViewModel4 = this.viewModel;
        if (guildHomeScheduleViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            guildHomeScheduleViewModel4 = null;
        }
        LiveData<Boolean> m26 = guildHomeScheduleViewModel4.m2();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.home.schedule.list.GuildHomeScheduleListFragment$initData$2
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
            public final void invoke2(Boolean it) {
                ShadowFrameLayout shadowFrameLayout;
                ShadowFrameLayout shadowFrameLayout2;
                ShadowFrameLayout shadowFrameLayout3;
                Logger.f235387a.d().i("Guild.NewHome.subFrag.GuildHomeScheduleListFragment", 1, "liveCreatePermission: " + it);
                shadowFrameLayout = GuildHomeScheduleListFragment.this.createScheduleLayout;
                if (shadowFrameLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("createScheduleLayout");
                    shadowFrameLayout = null;
                }
                shadowFrameLayout.setVisibility(Intrinsics.areEqual(it, Boolean.TRUE) ? 0 : 8);
                Intrinsics.checkNotNullExpressionValue(it, "it");
                if (it.booleanValue()) {
                    shadowFrameLayout2 = GuildHomeScheduleListFragment.this.createScheduleLayout;
                    if (shadowFrameLayout2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("createScheduleLayout");
                        shadowFrameLayout3 = null;
                    } else {
                        shadowFrameLayout3 = shadowFrameLayout2;
                    }
                    bt.d(shadowFrameLayout3, "em_sgrp_create_event", null, null, null, EndExposurePolicy.REPORT_NONE, 28, null);
                }
            }
        };
        m26.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.guild.home.schedule.list.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildHomeScheduleListFragment.ti(Function1.this, obj);
            }
        });
        GuildHomeScheduleViewModel guildHomeScheduleViewModel5 = this.viewModel;
        if (guildHomeScheduleViewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            guildHomeScheduleViewModel5 = null;
        }
        LiveData<ef1.a<Boolean>> n26 = guildHomeScheduleViewModel5.n2();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "viewLifecycleOwner");
        final Function1<Boolean, Unit> function12 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.home.schedule.list.GuildHomeScheduleListFragment$initData$3
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
                GuildHomeScheduleListFragment.this.Qi("[liveEventFinishLoadFirstPage event]");
                GuildHomeScheduleListFragment.Bi(GuildHomeScheduleListFragment.this, "liveEventFinishLoadFirstPage", false, false, 6, null);
                GuildHomeScheduleListFragment.this.firstPageTargetScrolled = false;
            }
        };
        n26.observe(viewLifecycleOwner2, new d(this, new Observer() { // from class: com.tencent.mobileqq.guild.home.schedule.list.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildHomeScheduleListFragment.ui(Function1.this, obj);
            }
        }));
        GuildHomeScheduleViewModel guildHomeScheduleViewModel6 = this.viewModel;
        if (guildHomeScheduleViewModel6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            guildHomeScheduleViewModel6 = null;
        }
        Flow onEach = FlowKt.onEach(guildHomeScheduleViewModel6.j2(), new GuildHomeScheduleListFragment$initData$4(this, null));
        Lifecycle lifecycle = getLifecycle();
        Intrinsics.checkNotNullExpressionValue(lifecycle, "lifecycle");
        FlowKt.launchIn(onEach, LifecycleKt.getCoroutineScope(lifecycle));
        if (guildSplitViewUtils.n(getActivity()) && getActivity() != null && (activity = getActivity()) != null && (supportFragmentManager = activity.getSupportFragmentManager()) != null) {
            supportFragmentManager.setFragmentResultListener("100", this, si());
        }
        ShadowFrameLayout shadowFrameLayout = this.createScheduleLayout;
        if (shadowFrameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("createScheduleLayout");
            shadowFrameLayout = null;
        }
        shadowFrameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.home.schedule.list.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildHomeScheduleListFragment.vi(GuildHomeScheduleListFragment.this, view);
            }
        });
        GuildHomeVisitorJoinView guildHomeVisitorJoinView = this.visitorJoinLayout;
        if (guildHomeVisitorJoinView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("visitorJoinLayout");
            guildHomeVisitorJoinView = null;
        }
        JumpGuildParam jumpGuildParam2 = this.jumpGuildParam;
        if (jumpGuildParam2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("jumpGuildParam");
            jumpGuildParam2 = null;
        }
        guildHomeVisitorJoinView.c(jumpGuildParam2);
        GuildHomeScheduleViewModel guildHomeScheduleViewModel7 = this.viewModel;
        if (guildHomeScheduleViewModel7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            guildHomeScheduleViewModel2 = guildHomeScheduleViewModel7;
        }
        LiveData<IGProGuildInfo> k26 = guildHomeScheduleViewModel2.k2();
        LifecycleOwner lifecycleOwner = getLifecycleOwner();
        final Function1<IGProGuildInfo, Unit> function13 = new Function1<IGProGuildInfo, Unit>() { // from class: com.tencent.mobileqq.guild.home.schedule.list.GuildHomeScheduleListFragment$initData$6
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
                GuildHomeVisitorJoinView guildHomeVisitorJoinView2;
                GuildHomeVisitorJoinView guildHomeVisitorJoinView3;
                GuildHomeVisitorJoinView guildHomeVisitorJoinView4 = null;
                if (iGProGuildInfo == null || !iGProGuildInfo.isMember()) {
                    guildHomeVisitorJoinView2 = GuildHomeScheduleListFragment.this.visitorJoinLayout;
                    if (guildHomeVisitorJoinView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("visitorJoinLayout");
                    } else {
                        guildHomeVisitorJoinView4 = guildHomeVisitorJoinView2;
                    }
                    guildHomeVisitorJoinView4.setVisibility(0);
                    return;
                }
                guildHomeVisitorJoinView3 = GuildHomeScheduleListFragment.this.visitorJoinLayout;
                if (guildHomeVisitorJoinView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("visitorJoinLayout");
                } else {
                    guildHomeVisitorJoinView4 = guildHomeVisitorJoinView3;
                }
                guildHomeVisitorJoinView4.setVisibility(8);
            }
        };
        k26.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.guild.home.schedule.list.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildHomeScheduleListFragment.wi(Function1.this, obj);
            }
        });
    }

    private final void initDtReport() {
        View view;
        View view2 = this.btnPickDate;
        JumpGuildParam jumpGuildParam = null;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnPickDate");
            view = null;
        } else {
            view = view2;
        }
        com.tencent.mobileqq.guild.base.extension.g.b(view, "em_sgrp_filter_date", false, false, null, 14, null);
        VideoReport.addToDetectionWhitelist(getActivity());
        VideoReport.setPageId(getView(), "pg_sgrp_event_second");
        HashMap hashMap = new HashMap(com.tencent.mobileqq.guild.report.b.d());
        hashMap.put("sgrp_stream_pgin_source_name", com.tencent.mobileqq.guild.report.b.c());
        hashMap.put("sgrp_sub_channel_id", this.scheduleChannelId);
        IGuildDTReportApi iGuildDTReportApi = (IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class);
        View view3 = getView();
        JumpGuildParam jumpGuildParam2 = this.jumpGuildParam;
        if (jumpGuildParam2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("jumpGuildParam");
        } else {
            jumpGuildParam = jumpGuildParam2;
        }
        iGuildDTReportApi.setGuildPageParams(view3, jumpGuildParam.guildId, hashMap);
    }

    private final void initViews(View view) {
        rh();
        setTitle("\u65e5\u7a0b");
        ScheduleRecyclerView scheduleRecyclerView = null;
        final IPerformanceReportTask d16 = qw1.b.d(getArguments(), null, 1, null);
        View findViewById = view.findViewById(R.id.f165618wz3);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.guild_schedule_list)");
        ScheduleRecyclerView scheduleRecyclerView2 = (ScheduleRecyclerView) findViewById;
        this.recyclerView = scheduleRecyclerView2;
        if (scheduleRecyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            scheduleRecyclerView2 = null;
        }
        qw1.b.j(d16, scheduleRecyclerView2, new Function1<IPerformanceReportTask, Unit>() { // from class: com.tencent.mobileqq.guild.home.schedule.list.GuildHomeScheduleListFragment$initViews$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(IPerformanceReportTask iPerformanceReportTask) {
                invoke2(iPerformanceReportTask);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull IPerformanceReportTask reportOnFirstFrame) {
                Intrinsics.checkNotNullParameter(reportOnFirstFrame, "$this$reportOnFirstFrame");
                cp1.d.f391542a.b(IPerformanceReportTask.this);
            }
        });
        View findViewById2 = view.findViewById(R.id.f164929ub2);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.create_schedule_layout)");
        this.createScheduleLayout = (ShadowFrameLayout) findViewById2;
        View findViewById3 = view.findViewById(R.id.x4w);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.guild_visitor_join_layout)");
        this.visitorJoinLayout = (GuildHomeVisitorJoinView) findViewById3;
        View findViewById4 = view.findViewById(R.id.f165675d35);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.head_container)");
        StickyHeadContainer stickyHeadContainer = (StickyHeadContainer) findViewById4;
        this.headContainer = stickyHeadContainer;
        if (stickyHeadContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("headContainer");
            stickyHeadContainer = null;
        }
        View findViewById5 = stickyHeadContainer.findViewById(R.id.f165615wz0);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "headContainer.findViewBy\u2026uild_schedule_item_title)");
        this.headItemTitle = (TextView) findViewById5;
        View findViewById6 = view.findViewById(R.id.f74443w_);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "view.findViewById(R.id.right_action_layout)");
        this.rightActionLayout = findViewById6;
        View findViewById7 = view.findViewById(R.id.f165619wz4);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "view.findViewById(R.id.guild_schedule_pick_date)");
        this.btnPickDate = findViewById7;
        View findViewById8 = view.findViewById(R.id.wym);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "view.findViewById(R.id.guild_schedule_goto_today)");
        this.btnGotoToday = findViewById8;
        if (findViewById8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnGotoToday");
            findViewById8 = null;
        }
        GuildUIUtils guildUIUtils = GuildUIUtils.f235378a;
        View view2 = this.btnGotoToday;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnGotoToday");
            view2 = null;
        }
        Context context = view2.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "btnGotoToday.context");
        findViewById8.setBackground(guildUIUtils.p(context, R.color.qui_common_text_tertiary, 0, 12.0f, 1.0f));
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        this.linearLayoutManager = new b(requireContext);
        ScheduleRecyclerView scheduleRecyclerView3 = this.recyclerView;
        if (scheduleRecyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            scheduleRecyclerView3 = null;
        }
        scheduleRecyclerView3.addOnScrollListener(new e(view));
        View view3 = this.btnGotoToday;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnGotoToday");
            view3 = null;
        }
        view3.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.home.schedule.list.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view4) {
                GuildHomeScheduleListFragment.xi(GuildHomeScheduleListFragment.this, view4);
            }
        });
        View view4 = this.btnPickDate;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnPickDate");
            view4 = null;
        }
        view4.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.home.schedule.list.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view5) {
                GuildHomeScheduleListFragment.yi(GuildHomeScheduleListFragment.this, view5);
            }
        });
        StickyHeadContainer stickyHeadContainer2 = this.headContainer;
        if (stickyHeadContainer2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("headContainer");
            stickyHeadContainer2 = null;
        }
        stickyHeadContainer2.setDataCallback(new StickyHeadContainer.b() { // from class: com.tencent.mobileqq.guild.home.schedule.list.c
            @Override // com.tencent.mobileqq.guild.home.views.sticky.StickyHeadContainer.b
            public final void a(int i3) {
                GuildHomeScheduleListFragment.zi(GuildHomeScheduleListFragment.this, i3);
            }
        });
        ScheduleRecyclerView scheduleRecyclerView4 = this.recyclerView;
        if (scheduleRecyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            scheduleRecyclerView4 = null;
        }
        LinearLayoutManager linearLayoutManager = this.linearLayoutManager;
        if (linearLayoutManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("linearLayoutManager");
            linearLayoutManager = null;
        }
        scheduleRecyclerView4.setLayoutManager(linearLayoutManager);
        ScheduleRecyclerView scheduleRecyclerView5 = this.recyclerView;
        if (scheduleRecyclerView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            scheduleRecyclerView5 = null;
        }
        scheduleRecyclerView5.setItemAnimator(null);
        ScheduleRecyclerView scheduleRecyclerView6 = this.recyclerView;
        if (scheduleRecyclerView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            scheduleRecyclerView6 = null;
        }
        scheduleRecyclerView6.setAdapter(this.adapter);
        ScheduleRecyclerView scheduleRecyclerView7 = this.recyclerView;
        if (scheduleRecyclerView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            scheduleRecyclerView7 = null;
        }
        scheduleRecyclerView7.setVisibility(4);
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.NewHome.subFrag.GuildHomeScheduleListFragment", 1, "init -> change recyclerview visible=invisible");
        }
        this.adapter.registerAdapterDataObserver(new f());
        StickyHeadContainer stickyHeadContainer3 = this.headContainer;
        if (stickyHeadContainer3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("headContainer");
            stickyHeadContainer3 = null;
        }
        com.tencent.mobileqq.guild.home.views.sticky.a aVar = new com.tencent.mobileqq.guild.home.views.sticky.a(stickyHeadContainer3, new GuildHomeScheduleListFragment$initViews$stickyItemDecoration$1(this.adapter));
        aVar.h(new g());
        ScheduleRecyclerView scheduleRecyclerView8 = this.recyclerView;
        if (scheduleRecyclerView8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            scheduleRecyclerView8 = null;
        }
        scheduleRecyclerView8.addItemDecoration(aVar);
        ScheduleRecyclerView scheduleRecyclerView9 = this.recyclerView;
        if (scheduleRecyclerView9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        } else {
            scheduleRecyclerView = scheduleRecyclerView9;
        }
        scheduleRecyclerView.addOnLayoutChangeListener(new h(view, this));
    }

    private final int qi(GuildHomeScheduleViewModel.DateLocator target, String from) {
        Object firstOrNull;
        Integer num;
        Object firstOrNull2;
        Integer num2;
        boolean z16;
        int i3 = -1;
        if (this.adapterPendingItems.size() == this.adapter.getItems().size()) {
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) this.adapterPendingItems);
            com.tencent.mobileqq.guild.home.schedule.models.d dVar = (com.tencent.mobileqq.guild.home.schedule.models.d) firstOrNull;
            GuildHomeScheduleViewModel guildHomeScheduleViewModel = null;
            if (dVar != null) {
                num = Integer.valueOf(dVar.getType());
            } else {
                num = null;
            }
            List<com.tencent.mobileqq.guild.home.schedule.models.d> items = this.adapter.getItems();
            Intrinsics.checkNotNullExpressionValue(items, "adapter.items");
            firstOrNull2 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) items);
            com.tencent.mobileqq.guild.home.schedule.models.d dVar2 = (com.tencent.mobileqq.guild.home.schedule.models.d) firstOrNull2;
            if (dVar2 != null) {
                num2 = Integer.valueOf(dVar2.getType());
            } else {
                num2 = null;
            }
            if (Intrinsics.areEqual(num, num2)) {
                List<com.tencent.mobileqq.guild.home.schedule.models.d> items2 = this.adapter.getItems();
                Intrinsics.checkNotNullExpressionValue(items2, "adapter.items");
                Iterator<com.tencent.mobileqq.guild.home.schedule.models.d> it = items2.iterator();
                boolean z17 = false;
                int i16 = 0;
                while (true) {
                    if (it.hasNext()) {
                        com.tencent.mobileqq.guild.home.schedule.models.d next = it.next();
                        if ((next instanceof DayGroupItem) && CalendarExKt.e(CalendarEx.f214714a.d(((DayGroupItem) next).getItem().a()), target.getDate())) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        if (z16) {
                            break;
                        }
                        i16++;
                    } else {
                        i16 = -1;
                        break;
                    }
                }
                if (i16 < 0) {
                    Logger logger = Logger.f235387a;
                    if (QLog.isColorLevel()) {
                        logger.d().d("Guild.NewHome.subFrag.GuildHomeScheduleListFragment", 1, "calculateLocateTargetIndex[" + from + "], not find index, " + target + " -> " + i16);
                    }
                    return i16;
                }
                if (target.getType() == 0) {
                    Logger logger2 = Logger.f235387a;
                    if (QLog.isColorLevel()) {
                        logger2.d().d("Guild.NewHome.subFrag.GuildHomeScheduleListFragment", 1, "calculateLocateTargetIndex[" + from + "], " + target + " -> " + i16);
                    }
                    return i16;
                }
                GuildHomeScheduleViewModel guildHomeScheduleViewModel2 = this.viewModel;
                if (guildHomeScheduleViewModel2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                } else {
                    guildHomeScheduleViewModel = guildHomeScheduleViewModel2;
                }
                long timeInMillis = guildHomeScheduleViewModel.getBaseDate().getDate().getTimeInMillis();
                ListIterator<com.tencent.mobileqq.guild.home.schedule.models.d> listIterator = this.adapter.getItems().listIterator(i16);
                int i17 = i16;
                while (true) {
                    if (!listIterator.hasNext()) {
                        break;
                    }
                    com.tencent.mobileqq.guild.home.schedule.models.d next2 = listIterator.next();
                    if (next2 instanceof ScheduleInfoItem) {
                        ScheduleInfoItem scheduleInfoItem = (ScheduleInfoItem) next2;
                        if (scheduleInfoItem.getInfo().getStartTimeMs() < timeInMillis) {
                            i17 = listIterator.previousIndex();
                        } else if (scheduleInfoItem.getInfo().getStartTimeMs() == timeInMillis) {
                            if (!z17) {
                                i17 = listIterator.previousIndex();
                                z17 = true;
                            }
                            long scheduleId = scheduleInfoItem.getInfo().getScheduleId();
                            Long scheduleId2 = target.getScheduleId();
                            if (scheduleId2 != null && scheduleId == scheduleId2.longValue()) {
                                i3 = listIterator.previousIndex();
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
                Logger logger3 = Logger.f235387a;
                if (QLog.isColorLevel()) {
                    logger3.d().d("Guild.NewHome.subFrag.GuildHomeScheduleListFragment", 1, "calculateLocateTargetIndex, " + target + " -> " + i16 + "/" + i17 + " (specifyIndex=" + i3 + ")");
                }
                if (i3 < 0) {
                    return i17;
                }
                return i3;
            }
        }
        Logger logger4 = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger4.d().d("Guild.NewHome.subFrag.GuildHomeScheduleListFragment", 1, "calculateLocateTargetIndex[" + from + "], ignore items mismatch");
        }
        return -1;
    }

    static /* synthetic */ int ri(GuildHomeScheduleListFragment guildHomeScheduleListFragment, GuildHomeScheduleViewModel.DateLocator dateLocator, String str, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str = "NoWhere";
        }
        return guildHomeScheduleListFragment.qi(dateLocator, str);
    }

    private final FragmentResultListener si() {
        return new c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ti(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ui(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void vi(GuildHomeScheduleListFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Hi(null);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void wi(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void xi(GuildHomeScheduleListFragment this$0, View view) {
        GuildHomeScheduleViewModel guildHomeScheduleViewModel;
        boolean z16;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        List<com.tencent.mobileqq.guild.home.schedule.models.d> items = this$0.adapter.getItems();
        Intrinsics.checkNotNullExpressionValue(items, "adapter.items");
        Iterator<com.tencent.mobileqq.guild.home.schedule.models.d> it = items.iterator();
        int i3 = 0;
        while (true) {
            if (it.hasNext()) {
                com.tencent.mobileqq.guild.home.schedule.models.d next = it.next();
                if ((next instanceof DayGroupItem) && next.getIsToday()) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    break;
                } else {
                    i3++;
                }
            } else {
                i3 = -1;
                break;
            }
        }
        LinearLayoutManager linearLayoutManager = null;
        if (i3 >= 0) {
            Calendar calendar = Calendar.getInstance();
            Intrinsics.checkNotNullExpressionValue(calendar, "getInstance()");
            this$0.locateTarget = new GuildHomeScheduleViewModel.DateLocator(0, calendar, null, 4, null);
            LinearLayoutManager linearLayoutManager2 = this$0.linearLayoutManager;
            if (linearLayoutManager2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("linearLayoutManager");
            } else {
                linearLayoutManager = linearLayoutManager2;
            }
            linearLayoutManager.scrollToPositionWithOffset(i3, 0);
        } else {
            GuildHomeScheduleViewModel guildHomeScheduleViewModel2 = this$0.viewModel;
            if (guildHomeScheduleViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                guildHomeScheduleViewModel = null;
            } else {
                guildHomeScheduleViewModel = guildHomeScheduleViewModel2;
            }
            GuildHomeScheduleViewModel.y2(guildHomeScheduleViewModel, true, CalendarEx.f214714a.e().getTimeInMillis(), 0, null, null, 28, null);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void yi(GuildHomeScheduleListFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Ei();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void zi(GuildHomeScheduleListFragment this$0, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.guild.home.schedule.models.d dVar = this$0.adapter.getItems().get(i3);
        Logger.f235387a.d().i("Guild.NewHome.subFrag.GuildHomeScheduleListFragment", 1, "update header pos[" + i3 + "]: " + dVar);
        if (dVar instanceof DayGroupItem) {
            TextView textView = this$0.headItemTitle;
            TextView textView2 = null;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("headItemTitle");
                textView = null;
            }
            textView.setText(dVar.getText());
            if (dVar.getIsToday()) {
                TextView textView3 = this$0.headItemTitle;
                if (textView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("headItemTitle");
                } else {
                    textView2 = textView3;
                }
                com.tencent.mobileqq.guild.base.extension.s.a(textView2, 600, 1);
                return;
            }
            TextView textView4 = this$0.headItemTitle;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("headItemTitle");
            } else {
                textView2 = textView4;
            }
            com.tencent.mobileqq.guild.base.extension.s.a(textView2, 400, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.eu6;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        GuildScheduleInfo guildScheduleInfo;
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode != 100) {
            return;
        }
        Logger logger = Logger.f235387a;
        boolean z16 = true;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.NewHome.subFrag.GuildHomeScheduleListFragment", 1, "onActivityResult(): " + requestCode + " " + resultCode + " " + data);
        }
        if (data != null && resultCode == -1) {
            Serializable serializableExtra = data.getSerializableExtra("success_schedule_info");
            Long l3 = null;
            if (serializableExtra instanceof GuildScheduleInfo) {
                guildScheduleInfo = (GuildScheduleInfo) serializableExtra;
            } else {
                guildScheduleInfo = null;
            }
            if (Pi(guildScheduleInfo)) {
                return;
            }
            long longExtra = data.getLongExtra("success_schedule_info_start_time", -1L);
            Long valueOf = Long.valueOf(data.getLongExtra("success_schedule_info_schedule_id", -1L));
            if (valueOf.longValue() <= 0) {
                z16 = false;
            }
            if (z16) {
                l3 = valueOf;
            }
            Ni(Long.valueOf(longExtra), l3);
        }
    }

    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        return GuildSplitViewUtils.u(GuildSplitViewUtils.f235370a, getActivity(), false, 2, null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
        initData();
        initDtReport();
        GuildHomeScheduleViewModel guildHomeScheduleViewModel = this.viewModel;
        if (guildHomeScheduleViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            guildHomeScheduleViewModel = null;
        }
        GuildHomeScheduleViewModel.y2(guildHomeScheduleViewModel, true, 0L, 0, null, getContext(), 14, null);
        GuildSplitViewUtils.f235370a.B(this.N);
    }

    @Override // com.tencent.mobileqq.guild.base.QQGuildTokenTitleBarFragment, com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment
    protected int ph() {
        return GuildSplitViewUtils.f235370a.m(getActivity(), R.color.qui_common_bg_bottom_light);
    }

    @Override // com.tencent.mobileqq.guild.base.QQGuildTokenTitleBarFragment, com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment
    protected int qh() {
        return R.drawable.qui_common_bg_bottom_light_bg;
    }
}
