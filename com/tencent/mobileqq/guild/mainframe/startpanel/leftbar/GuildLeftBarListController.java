package com.tencent.mobileqq.guild.mainframe.startpanel.leftbar;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import androidx.annotation.RequiresApi;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.api.LaunchGuildChatPieParam;
import com.tencent.mobileqq.guild.data.w;
import com.tencent.mobileqq.guild.mainframe.GuildAppReportSourceInfo;
import com.tencent.mobileqq.guild.mainframe.centerpanel.GuildCenterPanelController;
import com.tencent.mobileqq.guild.mainframe.helper.d;
import com.tencent.mobileqq.guild.mainframe.helper.jump.GuildMainFrameJumpParam;
import com.tencent.mobileqq.guild.mainframe.startpanel.leftbar.GuildLeftBarListAdapter;
import com.tencent.mobileqq.guild.mainframe.startpanel.leftbar.GuildLeftBarPersonalView;
import com.tencent.mobileqq.guild.mainframe.startpanel.leftbar.GuildLeftBarViewModel;
import com.tencent.mobileqq.guild.mainframe.startpanel.leftbar.animation.GuildLeftBarAnimator;
import com.tencent.mobileqq.guild.mainframe.view.GuildDragTextView;
import com.tencent.mobileqq.guild.nt.perf.api.IPerfApi;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.TraceUtils;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.widget.OverScrollRecyclerViewWithHeaderFooter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.tianjige.IQQOpenTelemetryReportApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00e3\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0003[x|\u0018\u0000 \u001e2\u00020\u0001:\u0002\u0010\u0014B\u0013\u0012\b\u0010\u0086\u0001\u001a\u00030\u0085\u0001\u00a2\u0006\u0006\b\u0087\u0001\u0010\u0088\u0001J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\fH\u0016J\u0006\u0010\u0011\u001a\u00020\u0004J\b\u0010\u0012\u001a\u00020\u0004H\u0016J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\fH\u0016J\b\u0010\u0015\u001a\u00020\u0004H\u0016J\u0006\u0010\u0017\u001a\u00020\u0016J \u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cJ\u000e\u0010!\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u001fJ\u0006\u0010\"\u001a\u00020\u0004J\u000e\u0010$\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u001fJ\u000e\u0010&\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020%J\b\u0010'\u001a\u00020\u0004H\u0002J\b\u0010(\u001a\u00020\u0004H\u0003J\u0010\u0010*\u001a\u00020\f2\u0006\u0010)\u001a\u00020\u0018H\u0002J\u0010\u0010,\u001a\u00020\f2\u0006\u0010+\u001a\u00020\u0018H\u0002J\u0018\u0010/\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u00182\u0006\u0010.\u001a\u00020-H\u0002J \u00102\u001a\u00020\u00042\u0006\u00100\u001a\u00020\u001a2\u0006\u00101\u001a\u00020\f2\u0006\u0010.\u001a\u00020-H\u0002J,\u00105\u001a\u001e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001a03j\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001a`42\u0006\u00101\u001a\u00020\fH\u0002J\u0010\u00107\u001a\u00020\u00042\u0006\u00106\u001a\u00020\u001aH\u0002J\u0010\u00108\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u001fH\u0002J\u0010\u0010;\u001a\u00020\u00042\u0006\u0010:\u001a\u000209H\u0002J\u0010\u0010<\u001a\u00020\f2\u0006\u0010 \u001a\u00020\u001fH\u0002J\u0012\u0010=\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0010\u0010@\u001a\u00020\u00042\u0006\u0010?\u001a\u00020>H\u0002J\b\u0010A\u001a\u00020\u0004H\u0002J\u0018\u0010C\u001a\u00020\u00042\u0006\u0010B\u001a\u00020\u001a2\u0006\u00106\u001a\u00020\u001aH\u0002J\b\u0010E\u001a\u00020DH\u0002R\u0016\u0010H\u001a\u00020\u00068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010K\u001a\u00020\u00168\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bI\u0010JR(\u0010P\u001a\u0004\u0018\u00010\u001f2\b\u0010L\u001a\u0004\u0018\u00010\u001f8\u0002@BX\u0082\u000e\u00a2\u0006\f\n\u0004\b\b\u0010M\"\u0004\bN\u0010OR\u0016\u0010S\u001a\u00020Q8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u0010ER\u0018\u0010W\u001a\u0004\u0018\u00010T8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bU\u0010VR\u0016\u0010Z\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bX\u0010YR\u0016\u0010^\u001a\u00020[8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\\\u0010]R\u0016\u0010b\u001a\u00020_8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b`\u0010aR\u0016\u0010e\u001a\u00020c8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b(\u0010dR\u0016\u0010h\u001a\u00020f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b,\u0010gR\u0016\u0010k\u001a\u00020i8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b7\u0010jR\u0018\u0010m\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010lR\u0016\u0010n\u001a\u00020Q8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010ER\u001c\u0010r\u001a\b\u0012\u0004\u0012\u00020D0o8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bp\u0010qR\u0014\u0010t\u001a\u00020D8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010sR\u0016\u0010w\u001a\u00020u8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u0010vR\u0016\u0010{\u001a\u00020x8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\by\u0010zR\u0016\u0010~\u001a\u00020|8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010}R\u0018\u0010\u0081\u0001\u001a\u00020\u007f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b!\u0010\u0080\u0001R\u0017\u0010\u0084\u0001\u001a\u00030\u0082\u00018\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b8\u0010\u0083\u0001\u00a8\u0006\u0089\u0001"}, d2 = {"Lcom/tencent/mobileqq/guild/mainframe/startpanel/leftbar/GuildLeftBarListController;", "Lcom/tencent/mobileqq/guild/mainframe/k;", "Lcs1/b;", "uIData", "", "W", "Landroid/view/View;", "view", tl.h.F, "onStart", DKHippyEvent.EVENT_STOP, "onCreate", "", "tabChange", "onResume", "tabChanged", "a", "X", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "isSwitchAccount", "b", "onBeforeAccountChanged", "Lcom/tencent/mobileqq/guild/widget/OverScrollRecyclerViewWithHeaderFooter;", "L", "", "type", "", "key", "Lcom/tencent/mobileqq/guild/mainframe/GuildAppReportSourceInfo;", "sourceInfo", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/mobileqq/guild/mainframe/helper/jump/GuildMainFrameJumpParam;", "param", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "T", "jumpParam", "P", "Lcom/tencent/mobileqq/guild/api/LaunchGuildChatPieParam;", "I", "k0", UserInfo.SEX_FEMALE, "position", "Y", "adapterPosition", "G", "Lfs1/b;", "viewHolder", "j0", "guildId", "isSetTop", "g0", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "M", "source", "H", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/mobileqq/guild/mainframe/helper/d$a;", "newSelItem", "d0", "V", "b0", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "a0", "e0", "eventKey", "c0", "Ljava/lang/Runnable;", "J", "e", "Landroid/view/View;", "mLeftBarRootView", "f", "Lcom/tencent/mobileqq/guild/widget/OverScrollRecyclerViewWithHeaderFooter;", "mLeftBarListView", "value", "Lcom/tencent/mobileqq/guild/mainframe/helper/jump/GuildMainFrameJumpParam;", "f0", "(Lcom/tencent/mobileqq/guild/mainframe/helper/jump/GuildMainFrameJumpParam;)V", "mWaitJumpParam", "", "i", "mWaitJumpStartTime", "Les1/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Les1/a;", "mSetTopPopWindow", BdhLogUtil.LogTag.Tag_Conn, "Z", "mHasStopped", "com/tencent/mobileqq/guild/mainframe/startpanel/leftbar/GuildLeftBarListController$i", "D", "Lcom/tencent/mobileqq/guild/mainframe/startpanel/leftbar/GuildLeftBarListController$i;", "differCallback", "Lcom/tencent/mobileqq/guild/mainframe/startpanel/leftbar/GuildLeftBarListAdapter;", "E", "Lcom/tencent/mobileqq/guild/mainframe/startpanel/leftbar/GuildLeftBarListAdapter;", "mLeftBarListAdapter", "Lcom/tencent/mobileqq/guild/mainframe/startpanel/leftbar/GuildLeftBarViewModel;", "Lcom/tencent/mobileqq/guild/mainframe/startpanel/leftbar/GuildLeftBarViewModel;", "mLeftBarViewModel", "Lcom/tencent/mobileqq/guild/mainframe/startpanel/leftbar/GuildLeftBarPersonalView;", "Lcom/tencent/mobileqq/guild/mainframe/startpanel/leftbar/GuildLeftBarPersonalView;", "mLeftBarPersonalView", "Landroid/widget/FrameLayout;", "Landroid/widget/FrameLayout;", "mPersonalViewContainer", "Ljava/lang/String;", "mLastPageReportEvent", "mPageInTime", "", "K", "Ljava/util/List;", "mPendingRunnables", "Ljava/lang/Runnable;", "mAfterSubmitCallback", "Landroidx/recyclerview/widget/RecyclerView$RecyclerListener;", "Landroidx/recyclerview/widget/RecyclerView$RecyclerListener;", "mRecyclerListener", "com/tencent/mobileqq/guild/mainframe/startpanel/leftbar/GuildLeftBarListController$o", "N", "Lcom/tencent/mobileqq/guild/mainframe/startpanel/leftbar/GuildLeftBarListController$o;", "mListDrawListener", "com/tencent/mobileqq/guild/mainframe/startpanel/leftbar/GuildLeftBarListController$p", "Lcom/tencent/mobileqq/guild/mainframe/startpanel/leftbar/GuildLeftBarListController$p;", "mScrollListener", "Lcom/tencent/mobileqq/guild/mainframe/startpanel/leftbar/GuildLeftBarListController$b;", "Lcom/tencent/mobileqq/guild/mainframe/startpanel/leftbar/GuildLeftBarListController$b;", "mDataUpdateListener", "Lrr1/a;", "Lrr1/a;", "mGestureListener", "Lcom/tencent/mobileqq/guild/mainframe/i;", "mainViewContext", "<init>", "(Lcom/tencent/mobileqq/guild/mainframe/i;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildLeftBarListController extends com.tencent.mobileqq.guild.mainframe.k {

    /* renamed from: C, reason: from kotlin metadata */
    private boolean mHasStopped;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private i differCallback;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private GuildLeftBarListAdapter mLeftBarListAdapter;

    /* renamed from: F, reason: from kotlin metadata */
    private GuildLeftBarViewModel mLeftBarViewModel;

    /* renamed from: G, reason: from kotlin metadata */
    private GuildLeftBarPersonalView mLeftBarPersonalView;

    /* renamed from: H, reason: from kotlin metadata */
    private FrameLayout mPersonalViewContainer;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private String mLastPageReportEvent;

    /* renamed from: J, reason: from kotlin metadata */
    private long mPageInTime;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private List<Runnable> mPendingRunnables;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final Runnable mAfterSubmitCallback;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private RecyclerView.RecyclerListener mRecyclerListener;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private o mListDrawListener;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private p mScrollListener;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private b mDataUpdateListener;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private final rr1.a mGestureListener;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private View mLeftBarRootView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private OverScrollRecyclerViewWithHeaderFooter mLeftBarListView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GuildMainFrameJumpParam mWaitJumpParam;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private long mWaitJumpStartTime;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private es1.a mSetTopPopWindow;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\f\u00a2\u0006\u0004\b\u0011\u0010\u0012J(\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016R$\u0010\u000f\u001a\u0010\u0012\f\u0012\n \r*\u0004\u0018\u00010\f0\f0\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000e\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/guild/mainframe/startpanel/leftbar/GuildLeftBarListController$b;", "Lcom/tencent/mobileqq/guild/mainframe/startpanel/leftbar/GuildLeftBarViewModel$i;", "", "from", "", "Lcs1/b;", "dataList", "Ljava/lang/Runnable;", "afterSubmitBlock", "", "a", "Lmqq/util/WeakReference;", "Lcom/tencent/mobileqq/guild/mainframe/startpanel/leftbar/GuildLeftBarListController;", "kotlin.jvm.PlatformType", "Lmqq/util/WeakReference;", "parentRef", HippyNestedScrollComponent.PRIORITY_PARENT, "<init>", "(Lcom/tencent/mobileqq/guild/mainframe/startpanel/leftbar/GuildLeftBarListController;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements GuildLeftBarViewModel.i {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private WeakReference<GuildLeftBarListController> parentRef;

        public b(@NotNull GuildLeftBarListController parent) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            this.parentRef = new WeakReference<>(parent);
        }

        @Override // com.tencent.mobileqq.guild.mainframe.startpanel.leftbar.GuildLeftBarViewModel.i
        public void a(int from, @NotNull List<cs1.b> dataList, @Nullable Runnable afterSubmitBlock) {
            Intrinsics.checkNotNullParameter(dataList, "dataList");
            GuildLeftBarListController guildLeftBarListController = this.parentRef.get();
            if (guildLeftBarListController != null) {
                ArrayList<cs1.b> arrayList = new ArrayList<>(dataList);
                TraceUtils.h("Guild.MainUi.LeftBarDataSubmit.s=" + arrayList.size());
                if (afterSubmitBlock != null) {
                    int hashCode = afterSubmitBlock.hashCode();
                    Logger.f235387a.d().d("Guild.MF.Lt.GuildLeftBarListController", 1, "setData from:" + from + " data size:" + arrayList.size() + " list:" + arrayList.hashCode() + " block:" + hashCode);
                    guildLeftBarListController.mPendingRunnables.add(afterSubmitBlock);
                }
                guildLeftBarListController.mLeftBarListAdapter.M0(arrayList, guildLeftBarListController.mAfterSubmitCallback);
                TraceUtils.k();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0006\b\u0000\u0010\u0000\u0018\u00012\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "kotlin.jvm.PlatformType", "it", "", "onChanged", "(Ljava/lang/Object;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c<T> implements Observer {
        public c() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.Observer
        public final void onChanged(T t16) {
            d.a aVar = (d.a) t16;
            QLog.i("Guild.MF.Lt.GuildLeftBarListController", 1, "jump2SelectItem type:" + aVar);
            GuildLeftBarPersonalView guildLeftBarPersonalView = null;
            if (aVar.f227428a == 4) {
                GuildLeftBarPersonalView guildLeftBarPersonalView2 = GuildLeftBarListController.this.mLeftBarPersonalView;
                if (guildLeftBarPersonalView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mLeftBarPersonalView");
                } else {
                    guildLeftBarPersonalView = guildLeftBarPersonalView2;
                }
                guildLeftBarPersonalView.m(false);
                return;
            }
            GuildLeftBarListAdapter guildLeftBarListAdapter = GuildLeftBarListController.this.mLeftBarListAdapter;
            int i3 = aVar.f227428a;
            String str = aVar.f227429b;
            Intrinsics.checkNotNullExpressionValue(str, "it.selKey");
            guildLeftBarListAdapter.F0(i3, str, null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0006\b\u0000\u0010\u0000\u0018\u00012\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "kotlin.jvm.PlatformType", "it", "", "onChanged", "(Ljava/lang/Object;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class d<T> implements Observer {
        public d() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.Observer
        public final void onChanged(T t16) {
            d.a it = (d.a) t16;
            QLog.i("Guild.MF.Lt.GuildLeftBarListController", 1, "clearSelectItem type:" + it);
            GuildLeftBarListAdapter guildLeftBarListAdapter = GuildLeftBarListController.this.mLeftBarListAdapter;
            Intrinsics.checkNotNullExpressionValue(it, "it");
            guildLeftBarListAdapter.q0(it);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0006\b\u0000\u0010\u0000\u0018\u00012\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "kotlin.jvm.PlatformType", "it", "", "onChanged", "(Ljava/lang/Object;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class e<T> implements Observer {
        public e() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.Observer
        public final void onChanged(T t16) {
            QLog.i("Guild.MF.Lt.GuildLeftBarListController", 2, "theme changed night[" + ((Boolean) t16) + "]");
            OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter = GuildLeftBarListController.this.mLeftBarListView;
            OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter2 = null;
            if (overScrollRecyclerViewWithHeaderFooter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLeftBarListView");
                overScrollRecyclerViewWithHeaderFooter = null;
            }
            overScrollRecyclerViewWithHeaderFooter.setItemViewCacheSize(0);
            OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter3 = GuildLeftBarListController.this.mLeftBarListView;
            if (overScrollRecyclerViewWithHeaderFooter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLeftBarListView");
            } else {
                overScrollRecyclerViewWithHeaderFooter2 = overScrollRecyclerViewWithHeaderFooter3;
            }
            overScrollRecyclerViewWithHeaderFooter2.setItemViewCacheSize(2);
            GuildLeftBarListController.this.mLeftBarListAdapter.notifyDataSetChanged();
            GuildLeftBarListController.this.k0();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0006\b\u0000\u0010\u0000\u0018\u00012\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "kotlin.jvm.PlatformType", "it", "", "onChanged", "(Ljava/lang/Object;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class f<T> implements Observer {
        public f() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.Observer
        public final void onChanged(T t16) {
            Boolean it = (Boolean) t16;
            Intrinsics.checkNotNullExpressionValue(it, "it");
            if (it.booleanValue()) {
                GuildCenterPanelController.b x16 = ((com.tencent.mobileqq.guild.mainframe.k) GuildLeftBarListController.this).f227466d.Z0().x();
                Intrinsics.checkNotNullExpressionValue(x16, "mainViewContext.guildCen\u2026elController.guildSelInfo");
                if (x16.f227299a != 0) {
                    d.a b16 = com.tencent.mobileqq.guild.mainframe.helper.d.f().b();
                    Intrinsics.checkNotNullExpressionValue(b16, "getInstance().curSelItem");
                    GuildLeftBarViewModel guildLeftBarViewModel = GuildLeftBarListController.this.mLeftBarViewModel;
                    GuildLeftBarViewModel guildLeftBarViewModel2 = null;
                    if (guildLeftBarViewModel == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mLeftBarViewModel");
                        guildLeftBarViewModel = null;
                    }
                    d.a y26 = guildLeftBarViewModel.y2(x16);
                    Intrinsics.checkNotNullExpressionValue(y26, "mLeftBarViewModel.getSelItem(centerPanelSelInfo)");
                    if (!Intrinsics.areEqual(b16, y26)) {
                        QLog.w("Guild.MF.Lt.GuildLeftBarListController", 2, "need adjust item to " + y26);
                        GuildLeftBarViewModel guildLeftBarViewModel3 = GuildLeftBarListController.this.mLeftBarViewModel;
                        if (guildLeftBarViewModel3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mLeftBarViewModel");
                        } else {
                            guildLeftBarViewModel2 = guildLeftBarViewModel3;
                        }
                        guildLeftBarViewModel2.k2(y26, GuildLeftBarListController.this.mLeftBarListAdapter.getItems());
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("Guild.MF.Lt.GuildLeftBarListController", 2, "jump2TargetItem " + y26);
                    }
                    ((com.tencent.mobileqq.guild.mainframe.k) GuildLeftBarListController.this).f227466d.e1().m(x16);
                }
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0006\b\u0000\u0010\u0000\u0018\u00012\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "kotlin.jvm.PlatformType", "it", "", "onChanged", "(Ljava/lang/Object;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class g<T> implements Observer {
        public g() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.Observer
        public final void onChanged(T t16) {
            GuildLeftBarPersonalView guildLeftBarPersonalView = GuildLeftBarListController.this.mLeftBarPersonalView;
            if (guildLeftBarPersonalView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLeftBarPersonalView");
                guildLeftBarPersonalView = null;
            }
            guildLeftBarPersonalView.n();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0006\b\u0000\u0010\u0000\u0018\u00012\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "kotlin.jvm.PlatformType", "it", "", "onChanged", "(Ljava/lang/Object;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class h<T> implements Observer {
        public h() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.Observer
        public final void onChanged(T t16) {
            GuildLeftBarPersonalView guildLeftBarPersonalView = GuildLeftBarListController.this.mLeftBarPersonalView;
            if (guildLeftBarPersonalView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLeftBarPersonalView");
                guildLeftBarPersonalView = null;
            }
            guildLeftBarPersonalView.t();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u001a\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/guild/mainframe/startpanel/leftbar/GuildLeftBarListController$i", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcs1/b;", "oldItem", "newItem", "", "b", "a", "", "c", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class i extends DiffUtil.ItemCallback<cs1.b> {
        i() {
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean areContentsTheSame(@NotNull cs1.b oldItem, @NotNull cs1.b newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem, newItem);
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean areItemsTheSame(@NotNull cs1.b oldItem, @NotNull cs1.b newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            if (oldItem.h() == newItem.h() && TextUtils.equals(oldItem.f391796e, newItem.f391796e)) {
                return true;
            }
            return false;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        @Nullable
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Object getChangePayload(@NotNull cs1.b oldItem, @NotNull cs1.b newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return oldItem.e(newItem);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/guild/mainframe/startpanel/leftbar/GuildLeftBarListController$j", "Landroidx/recyclerview/widget/LinearLayoutManager;", "", "canScrollVertically", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class j extends LinearLayoutManager {
        j(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean canScrollVertically() {
            if (GuildLeftBarListController.this.mSetTopPopWindow != null) {
                es1.a aVar = GuildLeftBarListController.this.mSetTopPopWindow;
                Intrinsics.checkNotNull(aVar);
                if (aVar.isShowing()) {
                    Logger logger = Logger.f235387a;
                    if (QLog.isDebugVersion()) {
                        logger.d().d("Guild.MF.Lt.GuildLeftBarListController", 1, "canScrollVertically false");
                        return false;
                    }
                    return false;
                }
            }
            return super.canScrollVertically();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/guild/mainframe/startpanel/leftbar/GuildLeftBarListController$k", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class k extends RecyclerView.ItemDecoration {
        k() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NotNull Rect outRect, @NotNull View view, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            if (parent.getChildLayoutPosition(view) == 0) {
                outRect.top = QQGuildUIUtil.l(R.dimen.cgz);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/guild/mainframe/startpanel/leftbar/GuildLeftBarListController$l", "Lcom/tencent/mobileqq/guild/mainframe/startpanel/leftbar/GuildLeftBarPersonalView$b;", "Lcom/tencent/mobileqq/guild/mainframe/helper/d$a;", "selItem", "", "b", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class l implements GuildLeftBarPersonalView.b {
        l() {
        }

        @Override // com.tencent.mobileqq.guild.mainframe.startpanel.leftbar.GuildLeftBarPersonalView.b
        public void a() {
            GuildLeftBarViewModel guildLeftBarViewModel = GuildLeftBarListController.this.mLeftBarViewModel;
            GuildLeftBarAnimator guildLeftBarAnimator = null;
            if (guildLeftBarViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLeftBarViewModel");
                guildLeftBarViewModel = null;
            }
            if (guildLeftBarViewModel.z2()) {
                OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter = GuildLeftBarListController.this.mLeftBarListView;
                if (overScrollRecyclerViewWithHeaderFooter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mLeftBarListView");
                    overScrollRecyclerViewWithHeaderFooter = null;
                }
                RecyclerView.ItemAnimator itemAnimator = overScrollRecyclerViewWithHeaderFooter.getItemAnimator();
                if (itemAnimator instanceof GuildLeftBarAnimator) {
                    guildLeftBarAnimator = (GuildLeftBarAnimator) itemAnimator;
                }
                if (guildLeftBarAnimator != null) {
                    guildLeftBarAnimator.endAnimations();
                }
            }
        }

        @Override // com.tencent.mobileqq.guild.mainframe.startpanel.leftbar.GuildLeftBarPersonalView.b
        public void b(@NotNull d.a selItem) {
            Intrinsics.checkNotNullParameter(selItem, "selItem");
            GuildLeftBarListController.this.mLeftBarListAdapter.q0(selItem);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/guild/mainframe/startpanel/leftbar/GuildLeftBarListController$m", "Lcom/tencent/mobileqq/guild/mainframe/startpanel/leftbar/GuildLeftBarListAdapter$b;", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class m implements GuildLeftBarListAdapter.b {
        m() {
        }

        @Override // com.tencent.mobileqq.guild.mainframe.startpanel.leftbar.GuildLeftBarListAdapter.b
        public void a() {
            GuildLeftBarPersonalView guildLeftBarPersonalView = GuildLeftBarListController.this.mLeftBarPersonalView;
            if (guildLeftBarPersonalView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLeftBarPersonalView");
                guildLeftBarPersonalView = null;
            }
            guildLeftBarPersonalView.e();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/mainframe/startpanel/leftbar/GuildLeftBarListController$n", "Lrr1/a;", "Lrr1/i;", "notifyData", "", "c", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class n extends rr1.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.guild.mainframe.i f227526a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ GuildLeftBarListController f227527b;

        n(com.tencent.mobileqq.guild.mainframe.i iVar, GuildLeftBarListController guildLeftBarListController) {
            this.f227526a = iVar;
            this.f227527b = guildLeftBarListController;
        }

        @Override // rr1.a
        public void c(@NotNull rr1.i notifyData) {
            Intrinsics.checkNotNullParameter(notifyData, "notifyData");
            GuildCenterPanelController.b x16 = this.f227526a.Z0().x();
            GuildLeftBarViewModel guildLeftBarViewModel = this.f227527b.mLeftBarViewModel;
            if (guildLeftBarViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLeftBarViewModel");
                guildLeftBarViewModel = null;
            }
            if (guildLeftBarViewModel.B2(notifyData, x16)) {
                this.f227526a.e1().m(x16);
            }
            if (notifyData.f() == 2) {
                this.f227527b.H("aio show");
            }
            if (notifyData.f() == 3) {
                if (notifyData.g() == 1 || notifyData.g() == 3) {
                    if (notifyData.c() == 3) {
                        Logger logger = Logger.f235387a;
                        if (QLog.isColorLevel()) {
                            logger.d().d("AbsGestureListener", 2, "back from AIO");
                        }
                        this.f227527b.c0("pgin", "back from AIO");
                        return;
                    }
                    if (notifyData.c() == 1 && notifyData.d() == 2) {
                        Logger logger2 = Logger.f235387a;
                        if (QLog.isColorLevel()) {
                            logger2.d().d("AbsGestureListener", 2, "go to AIO");
                        }
                        this.f227527b.c0("pgout", "go to AIO");
                    }
                }
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/guild/mainframe/startpanel/leftbar/GuildLeftBarListController$o", "Lkv1/a;", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class o implements kv1.a {
        o() {
        }

        @Override // kv1.a
        public void a() {
            Intrinsics.checkNotNullExpressionValue(GuildLeftBarListController.this.mLeftBarListAdapter.getItems(), "mLeftBarListAdapter.items");
            if (!r0.isEmpty()) {
                com.tencent.mobileqq.guild.performance.report.i.a();
                OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter = GuildLeftBarListController.this.mLeftBarListView;
                if (overScrollRecyclerViewWithHeaderFooter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mLeftBarListView");
                    overScrollRecyclerViewWithHeaderFooter = null;
                }
                overScrollRecyclerViewWithHeaderFooter.O();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J \u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/guild/mainframe/startpanel/leftbar/GuildLeftBarListController$p", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "dx", "dy", "onScrolled", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class p extends RecyclerView.OnScrollListener {
        p() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int newState) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            if (newState == 0) {
                ((IPerfApi) QRoute.api(IPerfApi.class)).stopMonitorDropFrame("qqguild_leftbar_list");
                GuildLeftBarListController.this.a0(recyclerView);
            } else {
                ((IPerfApi) QRoute.api(IPerfApi.class)).startMonitorDropFrame("qqguild_leftbar_list");
            }
            f12.d.f397604d.i("guild_list", newState);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NotNull RecyclerView recyclerView, int dx5, int dy5) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            if (Math.abs(dy5) > 0 && GuildLeftBarListController.this.mSetTopPopWindow != null) {
                es1.a aVar = GuildLeftBarListController.this.mSetTopPopWindow;
                Intrinsics.checkNotNull(aVar);
                if (aVar.isShowing()) {
                    Logger.f235387a.d().i("Guild.MF.Lt.GuildLeftBarListController", 1, "onScrollStateChanged dismiss top window");
                    es1.a aVar2 = GuildLeftBarListController.this.mSetTopPopWindow;
                    Intrinsics.checkNotNull(aVar2);
                    aVar2.dismiss();
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildLeftBarListController(@NotNull com.tencent.mobileqq.guild.mainframe.i mainViewContext) {
        super(mainViewContext);
        Intrinsics.checkNotNullParameter(mainViewContext, "mainViewContext");
        this.differCallback = new i();
        this.mLeftBarListAdapter = new GuildLeftBarListAdapter(this, new GuildLeftBarListController$mLeftBarListAdapter$1(this), this.differCallback);
        this.mPendingRunnables = new ArrayList();
        this.mAfterSubmitCallback = J();
        this.mRecyclerListener = new RecyclerView.RecyclerListener() { // from class: com.tencent.mobileqq.guild.mainframe.startpanel.leftbar.g
            @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
            public final void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                GuildLeftBarListController.U(GuildLeftBarListController.this, viewHolder);
            }
        };
        this.mListDrawListener = new o();
        this.mScrollListener = new p();
        this.mDataUpdateListener = new b(this);
        this.mGestureListener = new n(mainViewContext, this);
        com.tencent.mobileqq.guild.performance.report.i.c();
    }

    @RequiresApi(16)
    @SuppressLint({"NotifyDataSetChanged"})
    private final void F() {
        GuildLeftBarViewModel guildLeftBarViewModel = this.mLeftBarViewModel;
        GuildLeftBarPersonalView guildLeftBarPersonalView = null;
        if (guildLeftBarViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLeftBarViewModel");
            guildLeftBarViewModel = null;
        }
        guildLeftBarViewModel.T2(this.mDataUpdateListener);
        GuildLeftBarViewModel guildLeftBarViewModel2 = this.mLeftBarViewModel;
        if (guildLeftBarViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLeftBarViewModel");
            guildLeftBarViewModel2 = null;
        }
        LiveData<d.a> v26 = guildLeftBarViewModel2.v2();
        Intrinsics.checkNotNullExpressionValue(v26, "mLeftBarViewModel.jump2SelectItemLiveData");
        LifecycleOwner lifecycleOwner = this.f227466d.getLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(lifecycleOwner, "mainViewContext.lifecycleOwner");
        v26.observe(lifecycleOwner, new c());
        GuildLeftBarViewModel guildLeftBarViewModel3 = this.mLeftBarViewModel;
        if (guildLeftBarViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLeftBarViewModel");
            guildLeftBarViewModel3 = null;
        }
        MutableLiveData<d.a> u26 = guildLeftBarViewModel3.u2();
        Intrinsics.checkNotNullExpressionValue(u26, "mLeftBarViewModel.clearSelectItem");
        LifecycleOwner lifecycleOwner2 = this.f227466d.getLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(lifecycleOwner2, "mainViewContext.lifecycleOwner");
        u26.observe(lifecycleOwner2, new d());
        GuildLeftBarViewModel guildLeftBarViewModel4 = this.mLeftBarViewModel;
        if (guildLeftBarViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLeftBarViewModel");
            guildLeftBarViewModel4 = null;
        }
        LiveData<Boolean> w26 = guildLeftBarViewModel4.w2();
        Intrinsics.checkNotNullExpressionValue(w26, "mLeftBarViewModel.nightThemeChangedLiveData");
        LifecycleOwner lifecycleOwner3 = this.f227466d.getLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(lifecycleOwner3, "mainViewContext.lifecycleOwner");
        w26.observe(lifecycleOwner3, new e());
        GuildLeftBarViewModel guildLeftBarViewModel5 = this.mLeftBarViewModel;
        if (guildLeftBarViewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLeftBarViewModel");
            guildLeftBarViewModel5 = null;
        }
        LiveData<Boolean> t26 = guildLeftBarViewModel5.t2();
        Intrinsics.checkNotNullExpressionValue(t26, "mLeftBarViewModel.centerPanelClosedLiveData");
        LifecycleOwner lifecycleOwner4 = this.f227466d.getLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(lifecycleOwner4, "mainViewContext.lifecycleOwner");
        t26.observe(lifecycleOwner4, new f());
        GuildLeftBarViewModel guildLeftBarViewModel6 = this.mLeftBarViewModel;
        if (guildLeftBarViewModel6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLeftBarViewModel");
            guildLeftBarViewModel6 = null;
        }
        MutableLiveData<Boolean> x26 = guildLeftBarViewModel6.x2();
        Intrinsics.checkNotNullExpressionValue(x26, "mLeftBarViewModel.personalViewUpdateLiveData");
        LifecycleOwner lifecycleOwner5 = this.f227466d.getLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(lifecycleOwner5, "mainViewContext.lifecycleOwner");
        x26.observe(lifecycleOwner5, new g());
        GuildLeftBarViewModel guildLeftBarViewModel7 = this.mLeftBarViewModel;
        if (guildLeftBarViewModel7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLeftBarViewModel");
            guildLeftBarViewModel7 = null;
        }
        MutableLiveData<Boolean> selfInfoUpdateLiveData = guildLeftBarViewModel7.getSelfInfoUpdateLiveData();
        Intrinsics.checkNotNullExpressionValue(selfInfoUpdateLiveData, "mLeftBarViewModel.selfInfoUpdateLiveData");
        LifecycleOwner lifecycleOwner6 = this.f227466d.getLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(lifecycleOwner6, "mainViewContext.lifecycleOwner");
        selfInfoUpdateLiveData.observe(lifecycleOwner6, new h());
        GuildLeftBarViewModel guildLeftBarViewModel8 = this.mLeftBarViewModel;
        if (guildLeftBarViewModel8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLeftBarViewModel");
            guildLeftBarViewModel8 = null;
        }
        GuildLeftBarPersonalView guildLeftBarPersonalView2 = this.mLeftBarPersonalView;
        if (guildLeftBarPersonalView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLeftBarPersonalView");
        } else {
            guildLeftBarPersonalView = guildLeftBarPersonalView2;
        }
        guildLeftBarViewModel8.U2(guildLeftBarPersonalView.g());
    }

    private final boolean G(int adapterPosition) {
        if (!this.mLeftBarListAdapter.B0(adapterPosition)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H(String source) {
        es1.a aVar = this.mSetTopPopWindow;
        if (aVar != null) {
            Intrinsics.checkNotNull(aVar);
            if (aVar.isShowing()) {
                es1.a aVar2 = this.mSetTopPopWindow;
                Intrinsics.checkNotNull(aVar2);
                aVar2.dismiss();
                Logger.f235387a.d().i("Guild.MF.Lt.GuildLeftBarListController", 1, "closeTopWin " + source);
            }
        }
    }

    private final Runnable J() {
        return new Runnable() { // from class: com.tencent.mobileqq.guild.mainframe.startpanel.leftbar.i
            @Override // java.lang.Runnable
            public final void run() {
                GuildLeftBarListController.K(GuildLeftBarListController.this);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(GuildLeftBarListController this$0) {
        Object m476constructorimpl;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ViewModelStoreOwner y16 = this$0.f227466d.y();
        if (y16 instanceof Fragment) {
            Fragment fragment = (Fragment) y16;
            if (fragment.isDetached() || fragment.getFragmentManager() == null) {
                Logger logger = Logger.f235387a;
                Logger.b bVar = new Logger.b();
                bVar.a().add("fragment isDetached");
                Iterator<T> it = bVar.a().iterator();
                while (it.hasNext()) {
                    Logger.f235387a.d().e("Guild.MF.Lt.GuildLeftBarListController", 1, (String) it.next(), null);
                }
                return;
            }
        }
        TraceUtils.h("Guild.MainUi.LeftBarDataSubmitted,s=" + this$0.mLeftBarListAdapter.getNUM_BACKGOURND_ICON());
        if (this$0.mPendingRunnables.size() > 0 || this$0.mWaitJumpParam != null) {
            Logger.f235387a.d().i("Guild.MF.Lt.GuildLeftBarListController", 1, " afterSubmit block list:" + this$0.mLeftBarListAdapter.getItems().hashCode() + " mPendingRunnables:" + this$0.mPendingRunnables.size() + " mWaitJumpParam:" + this$0.mWaitJumpParam);
        }
        if (this$0.mWaitJumpParam != null) {
            if (System.currentTimeMillis() - this$0.mWaitJumpStartTime < 3500) {
                GuildLeftBarListAdapter guildLeftBarListAdapter = this$0.mLeftBarListAdapter;
                GuildMainFrameJumpParam guildMainFrameJumpParam = this$0.mWaitJumpParam;
                Intrinsics.checkNotNull(guildMainFrameJumpParam);
                guildLeftBarListAdapter.E0(guildMainFrameJumpParam);
            } else {
                Logger.f235387a.d().w("Guild.MF.Lt.GuildLeftBarListController", 1, "mWaitJumpParam time out " + (System.currentTimeMillis() - this$0.mWaitJumpStartTime) + " mWaitJumpParam=" + this$0.mWaitJumpParam);
            }
            this$0.f0(null);
        } else {
            int i3 = 0;
            for (Object obj : this$0.mPendingRunnables) {
                int i16 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                Runnable runnable = (Runnable) obj;
                try {
                    Result.Companion companion = Result.INSTANCE;
                    runnable.run();
                    m476constructorimpl = Result.m476constructorimpl(Unit.INSTANCE);
                } catch (Throwable th5) {
                    Result.Companion companion2 = Result.INSTANCE;
                    m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
                }
                Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
                if (m479exceptionOrNullimpl != null) {
                    Logger logger2 = Logger.f235387a;
                    Logger.b bVar2 = new Logger.b();
                    String str = "createAfterSubmitCallback error while run " + i3;
                    if (str instanceof String) {
                        bVar2.a().add(str);
                    }
                    Iterator<T> it5 = bVar2.a().iterator();
                    while (it5.hasNext()) {
                        Logger.f235387a.d().e("Guild.MF.Lt.GuildLeftBarListController", 1, (String) it5.next(), m479exceptionOrNullimpl);
                    }
                }
                i3 = i16;
            }
        }
        this$0.mPendingRunnables.clear();
        TraceUtils.k();
    }

    private final HashMap<String, String> M(boolean isSetTop) {
        HashMap<String, String> hashMap = new HashMap<>(1);
        if (isSetTop) {
            hashMap.put("sgrp_set_operation_top", "1");
        } else {
            hashMap.put("sgrp_set_operation_top", "2");
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N(Rect leftBarClipBounds, GuildLeftBarListController this$0, View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
        Intrinsics.checkNotNullParameter(leftBarClipBounds, "$leftBarClipBounds");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        leftBarClipBounds.set(0, 0, view.getWidth() + ViewUtils.dpToPx(10.0f), view.getHeight() + ViewUtils.dpToPx(10.0f));
        OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter = this$0.mLeftBarListView;
        if (overScrollRecyclerViewWithHeaderFooter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLeftBarListView");
            overScrollRecyclerViewWithHeaderFooter = null;
        }
        overScrollRecyclerViewWithHeaderFooter.setClipBounds(leftBarClipBounds);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O(Rect leftBarClipBounds, GuildLeftBarListController this$0, RecyclerView recyclerView, int i3, int i16) {
        Intrinsics.checkNotNullParameter(leftBarClipBounds, "$leftBarClipBounds");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        leftBarClipBounds.top = -i16;
        OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter = this$0.mLeftBarListView;
        if (overScrollRecyclerViewWithHeaderFooter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLeftBarListView");
            overScrollRecyclerViewWithHeaderFooter = null;
        }
        overScrollRecyclerViewWithHeaderFooter.setClipBounds(leftBarClipBounds);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void R(GuildMainFrameJumpParam param) {
        if (!V(param)) {
            Logger.f235387a.d().i("Guild.MF.Lt.GuildLeftBarListController", 1, "openChatCenterPanel no need just guild. param:" + param);
            if (!this.f227466d.e1().r(param)) {
                this.f227466d.e1().q(param);
                return;
            }
            return;
        }
        Logger.f235387a.d().i("Guild.MF.Lt.GuildLeftBarListController", 1, "openChatCenterPanel param:" + param);
        if (param.f227437a == 4) {
            GuildLeftBarPersonalView guildLeftBarPersonalView = this.mLeftBarPersonalView;
            if (guildLeftBarPersonalView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLeftBarPersonalView");
                guildLeftBarPersonalView = null;
            }
            guildLeftBarPersonalView.m(false);
            this.f227466d.e1().q(param);
            return;
        }
        if (!this.mLeftBarListAdapter.E0(param)) {
            QLog.w("Guild.MF.Lt.GuildLeftBarListController", 1, "openChatCenterPanel can't find target item!! type=" + param.f227437a + " key=" + param.f227438b);
            d.a aVar = new d.a(param.f227437a, param.f227438b);
            d.a b16 = com.tencent.mobileqq.guild.mainframe.helper.d.f().b();
            Intrinsics.checkNotNullExpressionValue(b16, "getInstance().curSelItem");
            QLog.w("Guild.MF.Lt.GuildLeftBarListController", 1, "openChatCenterPanel can't find target item tmpSelItem: " + aVar);
            d0(aVar);
            if (!this.f227466d.e1().q(param)) {
                d0(b16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U(GuildLeftBarListController this$0, RecyclerView.ViewHolder holder) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(holder, "holder");
        this$0.b0(holder.itemView);
    }

    private final boolean V(GuildMainFrameJumpParam param) {
        LaunchGuildChatPieParam launchGuildChatPieParam;
        d.a b16 = com.tencent.mobileqq.guild.mainframe.helper.d.f().b();
        Intrinsics.checkNotNullExpressionValue(b16, "getInstance().curSelItem");
        GuildMainFrameJumpParam.GuildCenterPanelJumpExtra guildCenterPanelJumpExtra = param.f227440d;
        if (guildCenterPanelJumpExtra != null && (launchGuildChatPieParam = guildCenterPanelJumpExtra.f227444e) != null && launchGuildChatPieParam.m() && b16.f227428a == 4) {
            return false;
        }
        if (b16.a() && TextUtils.equals(b16.f227429b, param.f227438b)) {
            return false;
        }
        if (b16.f227428a != param.f227437a || !TextUtils.equals(b16.f227429b, param.f227438b)) {
            return true;
        }
        QLog.i("Guild.MF.Lt.GuildLeftBarListController", 1, "jump2TargetItem no need adjust left item. cur:" + b16);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean Y(final int position) {
        OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter = this.mLeftBarListView;
        if (overScrollRecyclerViewWithHeaderFooter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLeftBarListView");
            overScrollRecyclerViewWithHeaderFooter = null;
        }
        final RecyclerView.ViewHolder findViewHolderForAdapterPosition = overScrollRecyclerViewWithHeaderFooter.findViewHolderForAdapterPosition(position);
        if (findViewHolderForAdapterPosition == null || !G(findViewHolderForAdapterPosition.getAdapterPosition())) {
            return false;
        }
        Logger.f235387a.d().d("Guild.MF.Lt.GuildLeftBarListController", 1, "onLongClick guild " + position + " pos = " + findViewHolderForAdapterPosition.getAdapterPosition());
        QQGuildUIUtil.T(80L);
        findViewHolderForAdapterPosition.itemView.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.mainframe.startpanel.leftbar.h
            @Override // java.lang.Runnable
            public final void run() {
                GuildLeftBarListController.Z(GuildLeftBarListController.this, position, findViewHolderForAdapterPosition);
            }
        }, 200L);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z(GuildLeftBarListController this$0, int i3, RecyclerView.ViewHolder viewHolder) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(viewHolder, "$viewHolder");
        this$0.j0(i3, (fs1.b) viewHolder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a0(RecyclerView recyclerView) {
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (!(layoutManager instanceof LinearLayoutManager)) {
            return;
        }
        int findLastVisibleItemPosition = ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition();
        GuildLeftBarViewModel guildLeftBarViewModel = this.mLeftBarViewModel;
        if (guildLeftBarViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLeftBarViewModel");
            guildLeftBarViewModel = null;
        }
        guildLeftBarViewModel.L2(findLastVisibleItemPosition);
    }

    private final void b0(View view) {
        GuildDragTextView guildDragTextView;
        if (view == null || (guildDragTextView = (GuildDragTextView) view.findViewById(R.id.kio)) == null) {
            return;
        }
        g().N().removeGestureListener(guildDragTextView.g());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c0(String eventKey, String source) {
        if (Intrinsics.areEqual(eventKey, this.mLastPageReportEvent)) {
            return;
        }
        if (this.mLeftBarListView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLeftBarListView");
        }
        HashMap hashMap = new HashMap();
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, "0S200MNJT807V3GE");
        hashMap.put("pgid", "pg_sgrp_head_list");
        w.c(hashMap);
        if (Intrinsics.areEqual("pgin", eventKey)) {
            this.mPageInTime = System.currentTimeMillis();
        } else {
            hashMap.put(DTParamKey.REPORT_KEY_LVTM, Long.valueOf(System.currentTimeMillis() - this.mPageInTime));
        }
        Intrinsics.checkNotNullExpressionValue(this.f227466d.f0().getReportInfoMap(), "mainViewContext.reportSourceInfo.reportInfoMap");
        if (!r2.isEmpty()) {
            for (Map.Entry<String, String> entry : this.f227466d.f0().getReportInfoMap().entrySet()) {
                String key = entry.getKey();
                Intrinsics.checkNotNullExpressionValue(key, "entry.key");
                hashMap.put(key, entry.getValue());
            }
        }
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.MF.Lt.GuildLeftBarListController", 2, "reportPageExpose\uff1aeventKey=" + eventKey + ", source=" + source + " pageParams=" + hashMap);
        }
        OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter = this.mLeftBarListView;
        if (overScrollRecyclerViewWithHeaderFooter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLeftBarListView");
            overScrollRecyclerViewWithHeaderFooter = null;
        }
        VideoReport.reportEvent(eventKey, overScrollRecyclerViewWithHeaderFooter, hashMap);
        this.mLastPageReportEvent = eventKey;
    }

    private final void d0(d.a newSelItem) {
        com.tencent.mobileqq.guild.mainframe.helper.d f16 = com.tencent.mobileqq.guild.mainframe.helper.d.f();
        d.a b16 = f16.b();
        Intrinsics.checkNotNullExpressionValue(b16, "leftBarSelHelper.curSelItem");
        f16.j(newSelItem);
        this.mLeftBarListAdapter.q0(b16);
    }

    private final void e0() {
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.MF.Lt.GuildLeftBarListController", 2, "setDtPage");
        }
        VideoReport.addToDetectionWhitelist(this.f227466d.getActivity());
        View view = this.mLeftBarRootView;
        OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLeftBarRootView");
            view = null;
        }
        VideoReport.setPageId(view, "pg_sgrp_head_list");
        HashMap hashMap = new HashMap();
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, "0S200MNJT807V3GE");
        w.c(hashMap);
        OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter2 = this.mLeftBarListView;
        if (overScrollRecyclerViewWithHeaderFooter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLeftBarListView");
            overScrollRecyclerViewWithHeaderFooter2 = null;
        }
        VideoReport.setPageParams(overScrollRecyclerViewWithHeaderFooter2, new PageParams(hashMap));
        OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter3 = this.mLeftBarListView;
        if (overScrollRecyclerViewWithHeaderFooter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLeftBarListView");
        } else {
            overScrollRecyclerViewWithHeaderFooter = overScrollRecyclerViewWithHeaderFooter3;
        }
        VideoReport.ignorePageInOutEvent(overScrollRecyclerViewWithHeaderFooter, true);
    }

    private final void f0(GuildMainFrameJumpParam guildMainFrameJumpParam) {
        this.mWaitJumpStartTime = System.currentTimeMillis();
        this.mWaitJumpParam = guildMainFrameJumpParam;
    }

    private final void g0(final String guildId, final boolean isSetTop, fs1.b viewHolder) {
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.MF.Lt.GuildLeftBarListController", 2, "showSetTopPopWin isSetTop=" + isSetTop);
        }
        if (this.mSetTopPopWindow == null) {
            es1.a aVar = new es1.a(this.f227466d.getActivity());
            this.mSetTopPopWindow = aVar;
            Intrinsics.checkNotNull(aVar);
            aVar.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.tencent.mobileqq.guild.mainframe.startpanel.leftbar.j
                @Override // android.widget.PopupWindow.OnDismissListener
                public final void onDismiss() {
                    GuildLeftBarListController.h0(GuildLeftBarListController.this);
                }
            });
        }
        es1.a aVar2 = this.mSetTopPopWindow;
        Intrinsics.checkNotNull(aVar2);
        if (aVar2.isShowing()) {
            es1.a aVar3 = this.mSetTopPopWindow;
            Intrinsics.checkNotNull(aVar3);
            aVar3.dismiss();
        }
        es1.a aVar4 = this.mSetTopPopWindow;
        Intrinsics.checkNotNull(aVar4);
        aVar4.c(isSetTop, viewHolder.itemView, new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.mainframe.startpanel.leftbar.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildLeftBarListController.i0(GuildLeftBarListController.this, isSetTop, guildId, view);
            }
        });
        es1.a aVar5 = this.mSetTopPopWindow;
        Intrinsics.checkNotNull(aVar5);
        VideoReport.setPageId(aVar5.getContentView(), "pg_sgrp_head_list");
        HashMap hashMap = new HashMap();
        hashMap.put("sgrp_channel_id", guildId);
        w.b(hashMap);
        es1.a aVar6 = this.mSetTopPopWindow;
        Intrinsics.checkNotNull(aVar6);
        VideoReport.setPageParams(aVar6.getContentView(), new PageParams(hashMap));
        es1.a aVar7 = this.mSetTopPopWindow;
        Intrinsics.checkNotNull(aVar7);
        VideoReport.setElementId(aVar7.a(), "em_sgrp_set_top");
        es1.a aVar8 = this.mSetTopPopWindow;
        Intrinsics.checkNotNull(aVar8);
        VideoReport.reportEvent("imp", aVar8.a(), M(isSetTop));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h0(GuildLeftBarListController this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter = this$0.mLeftBarListView;
        if (overScrollRecyclerViewWithHeaderFooter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLeftBarListView");
            overScrollRecyclerViewWithHeaderFooter = null;
        }
        overScrollRecyclerViewWithHeaderFooter.P();
        es1.a aVar = this$0.mSetTopPopWindow;
        Intrinsics.checkNotNull(aVar);
        VideoReport.reportEvent("imp_end", aVar.getContentView(), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i0(GuildLeftBarListController this$0, boolean z16, String guildId, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(guildId, "$guildId");
        GuildLeftBarViewModel guildLeftBarViewModel = this$0.mLeftBarViewModel;
        if (guildLeftBarViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLeftBarViewModel");
            guildLeftBarViewModel = null;
        }
        guildLeftBarViewModel.S2(z16, guildId);
        HashMap<String, String> M = this$0.M(z16);
        es1.a aVar = this$0.mSetTopPopWindow;
        Intrinsics.checkNotNull(aVar);
        VideoReport.reportEvent("clck", aVar.a(), M);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void j0(int position, fs1.b viewHolder) {
        if (this.mLeftBarListAdapter.D0(position)) {
            g0(this.mLeftBarListAdapter.t0(position), false, viewHolder);
        } else {
            g0(this.mLeftBarListAdapter.t0(position), true, viewHolder);
        }
        OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter = this.mLeftBarListView;
        if (overScrollRecyclerViewWithHeaderFooter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLeftBarListView");
            overScrollRecyclerViewWithHeaderFooter = null;
        }
        overScrollRecyclerViewWithHeaderFooter.M();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k0() {
        View view = this.mLeftBarRootView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLeftBarRootView");
            view = null;
        }
        View findViewById = view.findViewById(R.id.xdd);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mLeftBarRootView.findVie\u2026mageView>(R.id.icon_beta)");
        GuildUIUtils.d((ImageView) findViewById, R.drawable.guild_icon_beta, Integer.valueOf(R.color.qui_common_text_tertiary));
    }

    @NotNull
    public final GuildMainFrameJumpParam I(@NotNull LaunchGuildChatPieParam param) {
        GuildAppReportSourceInfo guildAppReportSourceInfo;
        Intrinsics.checkNotNullParameter(param, "param");
        GuildMainFrameJumpParam guildMainFrameJumpParam = new GuildMainFrameJumpParam();
        Bundle bundle = param.G;
        if (bundle != null) {
            guildAppReportSourceInfo = (GuildAppReportSourceInfo) bundle.getParcelable("GuildAppReportSourceInfo");
        } else {
            guildAppReportSourceInfo = null;
        }
        guildMainFrameJumpParam.f227441e = guildAppReportSourceInfo;
        GuildMainFrameJumpParam.GuildCenterPanelJumpExtra guildCenterPanelJumpExtra = new GuildMainFrameJumpParam.GuildCenterPanelJumpExtra();
        guildMainFrameJumpParam.f227440d = guildCenterPanelJumpExtra;
        guildCenterPanelJumpExtra.f227444e = param;
        if (param.m()) {
            guildMainFrameJumpParam.f227437a = 4;
            guildMainFrameJumpParam.f227440d.f227443d = new GuildMainFrameJumpParam.GuildInboxJumpExtra();
            GuildMainFrameJumpParam.GuildInboxJumpExtra guildInboxJumpExtra = guildMainFrameJumpParam.f227440d.f227443d;
            guildInboxJumpExtra.f227446d = 0;
            guildInboxJumpExtra.f227447e = param.f214354d;
        } else if (!TextUtils.isEmpty(param.j())) {
            guildMainFrameJumpParam.f227437a = 4;
            guildMainFrameJumpParam.f227440d.f227443d = new GuildMainFrameJumpParam.GuildInboxJumpExtra();
            GuildMainFrameJumpParam.GuildInboxJumpExtra guildInboxJumpExtra2 = guildMainFrameJumpParam.f227440d.f227443d;
            guildInboxJumpExtra2.f227446d = 1;
            guildInboxJumpExtra2.f227447e = "6";
        } else {
            guildMainFrameJumpParam.f227437a = 1;
            guildMainFrameJumpParam.f227438b = param.f214354d;
        }
        Bundle bundle2 = param.G;
        if (bundle2 != null) {
            guildMainFrameJumpParam.f227442f.putAll(bundle2);
        }
        return guildMainFrameJumpParam;
    }

    @NotNull
    public final OverScrollRecyclerViewWithHeaderFooter L() {
        OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter = this.mLeftBarListView;
        if (overScrollRecyclerViewWithHeaderFooter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLeftBarListView");
            return null;
        }
        return overScrollRecyclerViewWithHeaderFooter;
    }

    public final void P(@NotNull final GuildMainFrameJumpParam jumpParam) {
        Intrinsics.checkNotNullParameter(jumpParam, "jumpParam");
        final LaunchGuildChatPieParam launchGuildChatPieParam = jumpParam.f227440d.f227444e;
        if (jumpParam.f227437a == 1 && launchGuildChatPieParam != null) {
            String str = launchGuildChatPieParam.f214354d;
            Intrinsics.checkNotNullExpressionValue(str, "aioParam.guildId");
            com.tencent.mobileqq.guild.channel.joinchannel.a.m(new com.tencent.mobileqq.guild.channel.joinchannel.a(str, launchGuildChatPieParam.f214355e, new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.mainframe.startpanel.leftbar.GuildLeftBarListController$jump2CenterPanel$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public final void invoke(boolean z16) {
                    IGProChannelInfo B = ch.B(LaunchGuildChatPieParam.this.f214355e);
                    if (z16 && B != null) {
                        this.R(jumpParam);
                        return;
                    }
                    Logger logger = Logger.f235387a;
                    GuildMainFrameJumpParam guildMainFrameJumpParam = jumpParam;
                    Logger.b bVar = new Logger.b();
                    String str2 = "jump2CenterPanel failed channelInfo is null. jumpParam=" + guildMainFrameJumpParam;
                    if (str2 instanceof String) {
                        bVar.a().add(str2);
                    }
                    Iterator<T> it = bVar.a().iterator();
                    while (it.hasNext()) {
                        Logger.f235387a.d().e("Guild.MF.Lt.GuildLeftBarListController", 1, (String) it.next(), null);
                    }
                    GuildMainFrameJumpParam guildMainFrameJumpParam2 = jumpParam;
                    guildMainFrameJumpParam2.f227440d.f227444e = null;
                    this.Q(guildMainFrameJumpParam2);
                    QQToast.makeText(((com.tencent.mobileqq.guild.mainframe.k) this).f227466d.getActivity(), "\u8be5\u5b50\u9891\u9053\u5df2\u88ab\u5220\u9664", 0).show();
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }
            }), false, 1, null);
            return;
        }
        R(jumpParam);
    }

    public final void Q(@NotNull GuildMainFrameJumpParam param) {
        Intrinsics.checkNotNullParameter(param, "param");
        boolean E0 = this.mLeftBarListAdapter.E0(param);
        if (!E0) {
            f0(param);
        }
        Logger.f235387a.d().d("Guild.MF.Lt.GuildLeftBarListController", 1, "jump2Guild result=" + E0 + " jumpParam=" + param);
    }

    public final void S(int type, @NotNull String key, @Nullable GuildAppReportSourceInfo sourceInfo) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (type == 4) {
            GuildLeftBarPersonalView guildLeftBarPersonalView = this.mLeftBarPersonalView;
            if (guildLeftBarPersonalView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLeftBarPersonalView");
                guildLeftBarPersonalView = null;
            }
            guildLeftBarPersonalView.m(false);
            return;
        }
        boolean F0 = this.mLeftBarListAdapter.F0(type, key, sourceInfo);
        if (!F0) {
            GuildMainFrameJumpParam guildMainFrameJumpParam = new GuildMainFrameJumpParam();
            guildMainFrameJumpParam.f227437a = type;
            guildMainFrameJumpParam.f227438b = key;
            guildMainFrameJumpParam.f227441e = sourceInfo;
            f0(guildMainFrameJumpParam);
        }
        Logger.f235387a.d().d("Guild.MF.Lt.GuildLeftBarListController", 1, "jumpItemView result=" + F0 + " jumpParam=" + this.mWaitJumpParam);
    }

    public final void T() {
        GuildLeftBarViewModel guildLeftBarViewModel = this.mLeftBarViewModel;
        if (guildLeftBarViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLeftBarViewModel");
            guildLeftBarViewModel = null;
        }
        guildLeftBarViewModel.D2();
    }

    public final void W(@NotNull cs1.b uIData) {
        Intrinsics.checkNotNullParameter(uIData, "uIData");
        if (this.mWaitJumpParam != null) {
            Logger.f235387a.d().i("Guild.MF.Lt.GuildLeftBarListController", 1, "onClickGuildItem " + uIData.f391795d + "_" + uIData.f391796e + " . clear mWaitJumpParam=" + this.mWaitJumpParam);
            f0(null);
            this.mWaitJumpStartTime = 0L;
        }
    }

    public final void X() {
        OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter = this.mLeftBarListView;
        if (overScrollRecyclerViewWithHeaderFooter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLeftBarListView");
            overScrollRecyclerViewWithHeaderFooter = null;
        }
        overScrollRecyclerViewWithHeaderFooter.setAdapter(null);
    }

    @Override // com.tencent.mobileqq.guild.mainframe.k, com.tencent.mobileqq.guild.mainframe.t
    public void a(boolean tabChanged) {
        super.a(tabChanged);
        c0("pgout", MiniSDKConst.NOTIFY_EVENT_ONPAUSE);
        H(MiniSDKConst.NOTIFY_EVENT_ONPAUSE);
    }

    @Override // com.tencent.mobileqq.guild.mainframe.k, com.tencent.mobileqq.guild.mainframe.t
    public void b(boolean isSwitchAccount) {
        GuildLeftBarPersonalView guildLeftBarPersonalView = null;
        if (isSwitchAccount) {
            this.f227466d.e1().n(4, null, null);
        }
        GuildLeftBarViewModel guildLeftBarViewModel = this.mLeftBarViewModel;
        if (guildLeftBarViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLeftBarViewModel");
            guildLeftBarViewModel = null;
        }
        guildLeftBarViewModel.onAfterAccountChanged(isSwitchAccount);
        GuildLeftBarPersonalView guildLeftBarPersonalView2 = this.mLeftBarPersonalView;
        if (guildLeftBarPersonalView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLeftBarPersonalView");
        } else {
            guildLeftBarPersonalView = guildLeftBarPersonalView2;
        }
        guildLeftBarPersonalView.t();
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.MF.Lt.GuildLeftBarListController", 2, "onAfterAccountChanged");
        }
    }

    @Override // com.tencent.mobileqq.guild.mainframe.k
    public void h(@NotNull View view) {
        Map<String, String> mapOf;
        Intrinsics.checkNotNullParameter(view, "view");
        if (view instanceof ViewGroup) {
            try {
                View inflate = LayoutInflater.from(((ViewGroup) view).getContext()).inflate(R.layout.exm, (ViewGroup) view, false);
                Intrinsics.checkNotNullExpressionValue(inflate, "from(view.context).infla\u2026ame_leftbar, view, false)");
                this.mLeftBarRootView = inflate;
                ViewGroup viewGroup = (ViewGroup) view;
                GuildLeftBarPersonalView guildLeftBarPersonalView = null;
                if (inflate == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mLeftBarRootView");
                    inflate = null;
                }
                viewGroup.addView(inflate);
                View view2 = this.mLeftBarRootView;
                if (view2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mLeftBarRootView");
                    view2 = null;
                }
                View findViewById = view2.findViewById(R.id.wto);
                Intrinsics.checkNotNullExpressionValue(findViewById, "mLeftBarRootView.findVie\u2026_personal_view_container)");
                FrameLayout frameLayout = (FrameLayout) findViewById;
                this.mPersonalViewContainer = frameLayout;
                if (frameLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPersonalViewContainer");
                    frameLayout = null;
                }
                frameLayout.setElevation(1.0f);
                View view3 = this.mLeftBarRootView;
                if (view3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mLeftBarRootView");
                    view3 = null;
                }
                View findViewById2 = view3.findViewById(R.id.x5a);
                Intrinsics.checkNotNullExpressionValue(findViewById2, "mLeftBarRootView.findViewById(R.id.guildlist)");
                OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter = (OverScrollRecyclerViewWithHeaderFooter) findViewById2;
                this.mLeftBarListView = overScrollRecyclerViewWithHeaderFooter;
                if (overScrollRecyclerViewWithHeaderFooter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mLeftBarListView");
                    overScrollRecyclerViewWithHeaderFooter = null;
                }
                overScrollRecyclerViewWithHeaderFooter.setAdapter(this.mLeftBarListAdapter);
                OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter2 = this.mLeftBarListView;
                if (overScrollRecyclerViewWithHeaderFooter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mLeftBarListView");
                    overScrollRecyclerViewWithHeaderFooter2 = null;
                }
                View view4 = this.mLeftBarRootView;
                if (view4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mLeftBarRootView");
                    view4 = null;
                }
                overScrollRecyclerViewWithHeaderFooter2.setLayoutManager(new j(view4.getContext()));
                GuildLeftBarViewModel A2 = GuildLeftBarViewModel.A2(this.f227466d.y(), this.f227466d);
                Intrinsics.checkNotNullExpressionValue(A2, "getViewModel(mainViewCon\u2026reOwner, mainViewContext)");
                this.mLeftBarViewModel = A2;
                if (A2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mLeftBarViewModel");
                    A2 = null;
                }
                if (A2.z2()) {
                    OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter3 = this.mLeftBarListView;
                    if (overScrollRecyclerViewWithHeaderFooter3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mLeftBarListView");
                        overScrollRecyclerViewWithHeaderFooter3 = null;
                    }
                    GuildLeftBarAnimator guildLeftBarAnimator = new GuildLeftBarAnimator();
                    guildLeftBarAnimator.setMoveDuration(200L);
                    guildLeftBarAnimator.setChangeDuration(com.tencent.mobileqq.guild.mainframe.startpanel.leftbar.animation.c.f227609a.h());
                    guildLeftBarAnimator.setAddDuration(100L);
                    guildLeftBarAnimator.setRemoveDuration(100L);
                    overScrollRecyclerViewWithHeaderFooter3.setItemAnimator(guildLeftBarAnimator);
                }
                OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter4 = this.mLeftBarListView;
                if (overScrollRecyclerViewWithHeaderFooter4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mLeftBarListView");
                    overScrollRecyclerViewWithHeaderFooter4 = null;
                }
                overScrollRecyclerViewWithHeaderFooter4.addItemDecoration(new k());
                final Rect rect = new Rect();
                OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter5 = this.mLeftBarListView;
                if (overScrollRecyclerViewWithHeaderFooter5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mLeftBarListView");
                    overScrollRecyclerViewWithHeaderFooter5 = null;
                }
                overScrollRecyclerViewWithHeaderFooter5.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.tencent.mobileqq.guild.mainframe.startpanel.leftbar.e
                    @Override // android.view.View.OnLayoutChangeListener
                    public final void onLayoutChange(View view5, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
                        GuildLeftBarListController.N(rect, this, view5, i3, i16, i17, i18, i19, i26, i27, i28);
                    }
                });
                OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter6 = this.mLeftBarListView;
                if (overScrollRecyclerViewWithHeaderFooter6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mLeftBarListView");
                    overScrollRecyclerViewWithHeaderFooter6 = null;
                }
                overScrollRecyclerViewWithHeaderFooter6.G(new OverScrollRecyclerViewWithHeaderFooter.i() { // from class: com.tencent.mobileqq.guild.mainframe.startpanel.leftbar.f
                    @Override // com.tencent.mobileqq.guild.widget.OverScrollRecyclerViewWithHeaderFooter.i
                    public final void a(RecyclerView recyclerView, int i3, int i16) {
                        GuildLeftBarListController.O(rect, this, recyclerView, i3, i16);
                    }
                });
                OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter7 = this.mLeftBarListView;
                if (overScrollRecyclerViewWithHeaderFooter7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mLeftBarListView");
                    overScrollRecyclerViewWithHeaderFooter7 = null;
                }
                overScrollRecyclerViewWithHeaderFooter7.setClipToPadding(false);
                OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter8 = this.mLeftBarListView;
                if (overScrollRecyclerViewWithHeaderFooter8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mLeftBarListView");
                    overScrollRecyclerViewWithHeaderFooter8 = null;
                }
                overScrollRecyclerViewWithHeaderFooter8.setRecyclerListener(this.mRecyclerListener);
                OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter9 = this.mLeftBarListView;
                if (overScrollRecyclerViewWithHeaderFooter9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mLeftBarListView");
                    overScrollRecyclerViewWithHeaderFooter9 = null;
                }
                overScrollRecyclerViewWithHeaderFooter9.setOnScrollListener(this.mScrollListener);
                OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter10 = this.mLeftBarListView;
                if (overScrollRecyclerViewWithHeaderFooter10 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mLeftBarListView");
                    overScrollRecyclerViewWithHeaderFooter10 = null;
                }
                overScrollRecyclerViewWithHeaderFooter10.setHasFixedSize(true);
                OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter11 = this.mLeftBarListView;
                if (overScrollRecyclerViewWithHeaderFooter11 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mLeftBarListView");
                    overScrollRecyclerViewWithHeaderFooter11 = null;
                }
                overScrollRecyclerViewWithHeaderFooter11.setDrawListener(this.mListDrawListener);
                this.mLeftBarListAdapter.z0();
                e0();
                GuildLeftBarListAdapter guildLeftBarListAdapter = this.mLeftBarListAdapter;
                GuildLeftBarViewModel guildLeftBarViewModel = this.mLeftBarViewModel;
                if (guildLeftBarViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mLeftBarViewModel");
                    guildLeftBarViewModel = null;
                }
                guildLeftBarListAdapter.O0(guildLeftBarViewModel);
                View view5 = this.mLeftBarRootView;
                if (view5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mLeftBarRootView");
                    view5 = null;
                }
                View findViewById3 = view5.findViewById(R.id.wtn);
                Intrinsics.checkNotNullExpressionValue(findViewById3, "mLeftBarRootView.findVie\u2026R.id.guild_personal_view)");
                GuildLeftBarPersonalView guildLeftBarPersonalView2 = (GuildLeftBarPersonalView) findViewById3;
                this.mLeftBarPersonalView = guildLeftBarPersonalView2;
                if (guildLeftBarPersonalView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mLeftBarPersonalView");
                    guildLeftBarPersonalView2 = null;
                }
                guildLeftBarPersonalView2.h(this.f227466d);
                GuildLeftBarPersonalView guildLeftBarPersonalView3 = this.mLeftBarPersonalView;
                if (guildLeftBarPersonalView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mLeftBarPersonalView");
                } else {
                    guildLeftBarPersonalView = guildLeftBarPersonalView3;
                }
                guildLeftBarPersonalView.setDelegateCallback(new l());
                this.mLeftBarListAdapter.N0(new m());
                g().N().addGestureListener(this.mGestureListener);
                k0();
                Logger logger = Logger.f235387a;
                if (QLog.isColorLevel()) {
                    logger.d().d("Guild.MF.Lt.GuildLeftBarListController", 2, "initView");
                    return;
                }
                return;
            } catch (Exception e16) {
                Logger logger2 = Logger.f235387a;
                Logger.b bVar = new Logger.b();
                bVar.a().add("onCreate error");
                Iterator<T> it = bVar.a().iterator();
                while (it.hasNext()) {
                    Logger.f235387a.d().e("Guild.MF.Lt.GuildLeftBarListController", 1, (String) it.next(), e16);
                }
                mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("left_bar_inflate_exception", e16.toString()));
                ((IQQOpenTelemetryReportApi) QRoute.api(IQQOpenTelemetryReportApi.class)).reportEvent("gpro_quality#event#left_bar_inflate_exception", mapOf);
                throw e16;
            }
        }
        throw new IllegalArgumentException("Guild.MF.Lt.GuildLeftBarListController initView, the view is error");
    }

    @Override // com.tencent.mobileqq.guild.mainframe.k, com.tencent.mobileqq.guild.mainframe.t
    public void onBeforeAccountChanged() {
        GuildLeftBarViewModel guildLeftBarViewModel = this.mLeftBarViewModel;
        if (guildLeftBarViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLeftBarViewModel");
            guildLeftBarViewModel = null;
        }
        guildLeftBarViewModel.onBeforeAccountChanged();
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.MF.Lt.GuildLeftBarListController", 2, "onBeforeAccountChanged");
        }
    }

    @Override // com.tencent.mobileqq.guild.mainframe.k, com.tencent.mobileqq.guild.mainframe.t
    public void onCreate() {
        GuildLeftBarViewModel guildLeftBarViewModel = this.mLeftBarViewModel;
        GuildLeftBarViewModel guildLeftBarViewModel2 = null;
        if (guildLeftBarViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLeftBarViewModel");
            guildLeftBarViewModel = null;
        }
        guildLeftBarViewModel.T2(this.mDataUpdateListener);
        GuildLeftBarViewModel guildLeftBarViewModel3 = this.mLeftBarViewModel;
        if (guildLeftBarViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLeftBarViewModel");
        } else {
            guildLeftBarViewModel2 = guildLeftBarViewModel3;
        }
        guildLeftBarViewModel2.onCreate();
        F();
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.MF.Lt.GuildLeftBarListController", 2, "onCreate");
        }
    }

    @Override // com.tencent.mobileqq.guild.mainframe.k, com.tencent.mobileqq.guild.mainframe.t
    public void onDestroy() {
        GuildLeftBarViewModel guildLeftBarViewModel = this.mLeftBarViewModel;
        if (guildLeftBarViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLeftBarViewModel");
            guildLeftBarViewModel = null;
        }
        guildLeftBarViewModel.onDestroy();
        GuildLeftBarViewModel guildLeftBarViewModel2 = this.mLeftBarViewModel;
        if (guildLeftBarViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLeftBarViewModel");
            guildLeftBarViewModel2 = null;
        }
        guildLeftBarViewModel2.T2(null);
        g().N().removeGestureListener(this.mGestureListener);
        this.mLeftBarListAdapter.J0();
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.MF.Lt.GuildLeftBarListController", 2, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        }
    }

    @Override // com.tencent.mobileqq.guild.mainframe.k, com.tencent.mobileqq.guild.mainframe.t
    public void onResume(boolean tabChange) {
        super.onResume(tabChange);
        c0("pgin", "onResume");
    }

    @Override // com.tencent.mobileqq.guild.mainframe.k, com.tencent.mobileqq.guild.mainframe.t
    public void onStart() {
        super.onStart();
        if (this.mHasStopped) {
            GuildLeftBarViewModel guildLeftBarViewModel = this.mLeftBarViewModel;
            if (guildLeftBarViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLeftBarViewModel");
                guildLeftBarViewModel = null;
            }
            guildLeftBarViewModel.N2(3, "onStart");
            this.mHasStopped = false;
        }
    }

    @Override // com.tencent.mobileqq.guild.mainframe.k, com.tencent.mobileqq.guild.mainframe.t
    public void onStop() {
        super.onStop();
        this.mHasStopped = true;
    }
}
