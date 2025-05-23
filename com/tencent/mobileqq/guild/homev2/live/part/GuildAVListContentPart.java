package com.tencent.mobileqq.guild.homev2.live.part;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.guild.base.extension.MiscKt;
import com.tencent.mobileqq.guild.channel.create.CreateSubChannelInfo;
import com.tencent.mobileqq.guild.channel.create.dialog.QQGuildSubChannelCreateDialogFragment;
import com.tencent.mobileqq.guild.component.GuildQUIEmptyState;
import com.tencent.mobileqq.guild.homev2.live.adapter.GuildAVBaseAdapterDelegate;
import com.tencent.mobileqq.guild.homev2.live.viewmodel.GuildAVListContentViewModel;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.report.IPerformanceReportTask;
import com.tencent.mobileqq.guild.util.GuildSplitViewUtils;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.bi;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import com.tencent.util.QQToastUtil;
import ef1.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.time.Duration;
import kotlin.time.TimeSource;
import kotlin.time.TimedValue;
import np1.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pp1.GuildLiveAudioSpaceUIData;

@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 T2\u00020\u0001:\u0001UB1\u0012\u0006\u0010&\u001a\u00020#\u0012\u0006\u0010)\u001a\u00020\u000e\u0012\u0006\u0010-\u001a\u00020*\u0012\u0006\u0010/\u001a\u00020\u000e\u0012\b\u00103\u001a\u0004\u0018\u000100\u00a2\u0006\u0004\bR\u0010SJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0016\u0010\b\u001a\u00020\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\u0002H\u0002J\b\u0010\r\u001a\u00020\u0002H\u0002J\u0010\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0011\u001a\u00020\u0002H\u0002J+\u0010\u0018\u001a\u00020\u00022!\u0010\u0017\u001a\u001d\u0012\u0013\u0012\u00110\u0013\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00020\u0012H\u0002J\u0010\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0006H\u0002J\b\u0010\u001b\u001a\u00020\u0002H\u0002J\u0010\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J\u0012\u0010!\u001a\u00020\u00022\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0016J\u0012\u0010\"\u001a\u00020\u00022\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0016R\u0014\u0010&\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010)\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010-\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0014\u0010/\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010(R\u0016\u00103\u001a\u0004\u0018\u0001008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010;\u001a\u0002088\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010?\u001a\u00020<8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010C\u001a\u00020@8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010G\u001a\u00020D8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010K\u001a\u00020H8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u001c\u0010O\u001a\b\u0012\u0004\u0012\u00020\t0L8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bM\u0010NR\u001c\u0010Q\u001a\n P*\u0004\u0018\u00010*0*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010,\u00a8\u0006V"}, d2 = {"Lcom/tencent/mobileqq/guild/homev2/live/part/GuildAVListContentPart;", "Lcom/tencent/biz/richframework/part/Part;", "", "initView", "initData", "", "Lpp1/g;", "list", "ha", "Lpp1/j;", "emptyData", "ea", "ca", "Q9", "", "width", "V9", "da", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/guild/homev2/live/adapter/GuildAVBaseAdapterDelegate$a;", "Lkotlin/ParameterName;", "name", "viewHolder", "callback", "U9", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "W9", "T9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartResume", "onPartPause", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;", "d", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;", "mJumpGuildParam", "e", "I", "mCategoryType", "", "f", "Ljava/lang/String;", "mCategoryId", tl.h.F, "mSceneType", "Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", "i", "Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", "mReportTask", "Landroidx/recyclerview/widget/RecyclerView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/recyclerview/widget/RecyclerView;", "mListView", "Landroidx/recyclerview/widget/GridLayoutManager;", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/recyclerview/widget/GridLayoutManager;", "mLayoutManager", "Landroid/view/ViewGroup;", "D", "Landroid/view/ViewGroup;", "mEmptyTipContainer", "Lnp1/a;", "E", "Lnp1/a;", "mAdapter", "Lcom/tencent/mobileqq/guild/homev2/live/viewmodel/GuildAVListContentViewModel;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/guild/homev2/live/viewmodel/GuildAVListContentViewModel;", "mViewModel", "Lcom/tencent/mobileqq/guild/homev2/live/viewmodel/d;", "G", "Lcom/tencent/mobileqq/guild/homev2/live/viewmodel/d;", "avLivePermissionViewModel", "Landroidx/lifecycle/MediatorLiveData;", "H", "Landroidx/lifecycle/MediatorLiveData;", "isShowEmptyTipsLiveData", "kotlin.jvm.PlatformType", "mGuildId", "<init>", "(Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;ILjava/lang/String;ILcom/tencent/mobileqq/guild/report/IPerformanceReportTask;)V", "J", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildAVListContentPart extends Part {

    /* renamed from: C, reason: from kotlin metadata */
    private GridLayoutManager mLayoutManager;

    /* renamed from: D, reason: from kotlin metadata */
    private ViewGroup mEmptyTipContainer;

    /* renamed from: E, reason: from kotlin metadata */
    private np1.a mAdapter;

    /* renamed from: F, reason: from kotlin metadata */
    private GuildAVListContentViewModel mViewModel;

    /* renamed from: G, reason: from kotlin metadata */
    private com.tencent.mobileqq.guild.homev2.live.viewmodel.d avLivePermissionViewModel;

    /* renamed from: H, reason: from kotlin metadata */
    private MediatorLiveData<pp1.j> isShowEmptyTipsLiveData;

    /* renamed from: I, reason: from kotlin metadata */
    private final String mGuildId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final JumpGuildParam mJumpGuildParam;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int mCategoryType;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String mCategoryId;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final int mSceneType;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final IPerformanceReportTask mReportTask;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private RecyclerView mListView;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/base/mvvm/SingleViewModelProvider$Companion$factory$1", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "p0", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements ViewModelProvider.Factory {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewModelStoreOwner f225814a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ GuildAVListContentPart f225815b;

        public b(ViewModelStoreOwner viewModelStoreOwner, GuildAVListContentPart guildAVListContentPart) {
            this.f225814a = viewModelStoreOwner;
            this.f225815b = guildAVListContentPart;
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        @NotNull
        public <T extends ViewModel> T create(@NotNull Class<T> p06) {
            Intrinsics.checkNotNullParameter(p06, "p0");
            long m1963markNowz9LOYto = TimeSource.Monotonic.INSTANCE.m1963markNowz9LOYto();
            String str = this.f225815b.mJumpGuildParam.guildId;
            Intrinsics.checkNotNullExpressionValue(str, "mJumpGuildParam.guildId");
            TimedValue timedValue = new TimedValue(new GuildAVListContentViewModel(str, this.f225815b.mCategoryType, this.f225815b.mSceneType), TimeSource.Monotonic.ValueTimeMark.m1966elapsedNowUwyO8pc(m1963markNowz9LOYto), null);
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("GuildViewModelProvider", 2, "create " + com.tencent.mobileqq.guild.base.extension.m.a(timedValue.getValue()) + " cost " + Duration.m1875toStringimpl(timedValue.m1981getDurationUwyO8pc()));
            }
            return (T) timedValue.getValue();
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/base/mvvm/SingleViewModelProvider$Companion$factory$1", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "p0", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class c implements ViewModelProvider.Factory {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewModelStoreOwner f225816a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ GuildAVListContentPart f225817b;

        public c(ViewModelStoreOwner viewModelStoreOwner, GuildAVListContentPart guildAVListContentPart) {
            this.f225816a = viewModelStoreOwner;
            this.f225817b = guildAVListContentPart;
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        @NotNull
        public <T extends ViewModel> T create(@NotNull Class<T> p06) {
            Intrinsics.checkNotNullParameter(p06, "p0");
            long m1963markNowz9LOYto = TimeSource.Monotonic.INSTANCE.m1963markNowz9LOYto();
            String mGuildId = this.f225817b.mGuildId;
            Intrinsics.checkNotNullExpressionValue(mGuildId, "mGuildId");
            TimedValue timedValue = new TimedValue(new com.tencent.mobileqq.guild.homev2.live.viewmodel.d(mGuildId, this.f225817b.mCategoryId, this.f225817b.mSceneType), TimeSource.Monotonic.ValueTimeMark.m1966elapsedNowUwyO8pc(m1963markNowz9LOYto), null);
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("GuildViewModelProvider", 2, "create " + com.tencent.mobileqq.guild.base.extension.m.a(timedValue.getValue()) + " cost " + Duration.m1875toStringimpl(timedValue.m1981getDurationUwyO8pc()));
            }
            return (T) timedValue.getValue();
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/guild/homev2/live/part/GuildAVListContentPart$d", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "", "p0", "getSpanSize", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class d extends GridLayoutManager.SpanSizeLookup {
        d() {
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanSize(int p06) {
            Object orNull;
            np1.a aVar = GuildAVListContentPart.this.mAdapter;
            GridLayoutManager gridLayoutManager = null;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
                aVar = null;
            }
            List<pp1.g> items = aVar.getItems();
            Intrinsics.checkNotNullExpressionValue(items, "mAdapter.items");
            orNull = CollectionsKt___CollectionsKt.getOrNull(items, p06);
            if (((pp1.g) orNull) instanceof GuildLiveAudioSpaceUIData) {
                GridLayoutManager gridLayoutManager2 = GuildAVListContentPart.this.mLayoutManager;
                if (gridLayoutManager2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mLayoutManager");
                } else {
                    gridLayoutManager = gridLayoutManager2;
                }
                return gridLayoutManager.getSpanCount();
            }
            return 1;
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/homev2/live/part/GuildAVListContentPart$e", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class e extends RecyclerView.OnScrollListener {
        e() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int newState) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, newState);
            if (newState == 0) {
                VideoReport.traversePage(recyclerView);
            }
        }
    }

    public GuildAVListContentPart(@NotNull JumpGuildParam mJumpGuildParam, int i3, @NotNull String mCategoryId, int i16, @Nullable IPerformanceReportTask iPerformanceReportTask) {
        Intrinsics.checkNotNullParameter(mJumpGuildParam, "mJumpGuildParam");
        Intrinsics.checkNotNullParameter(mCategoryId, "mCategoryId");
        this.mJumpGuildParam = mJumpGuildParam;
        this.mCategoryType = i3;
        this.mCategoryId = mCategoryId;
        this.mSceneType = i16;
        this.mReportTask = iPerformanceReportTask;
        this.mGuildId = mJumpGuildParam.guildId;
    }

    private final void Q9() {
        RecyclerView recyclerView = this.mListView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mListView");
            recyclerView = null;
        }
        recyclerView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.tencent.mobileqq.guild.homev2.live.part.g
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
                GuildAVListContentPart.R9(GuildAVListContentPart.this, view, i3, i16, i17, i18, i19, i26, i27, i28);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R9(final GuildAVListContentPart this$0, View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i29 = i17 - i3;
        GuildSplitViewUtils guildSplitViewUtils = GuildSplitViewUtils.f235370a;
        RecyclerView recyclerView = null;
        if (guildSplitViewUtils.n(this$0.getContext())) {
            i29 = RangesKt___RangesKt.coerceAtMost(i29, GuildSplitViewUtils.j(guildSplitViewUtils, false, null, 3, null));
        }
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("GuildLiveListPart", 1, "adjustListColumnSize newWidth:" + i29);
        }
        if (i29 == i27 - i19) {
            return;
        }
        int V9 = this$0.V9(i29);
        GridLayoutManager gridLayoutManager = this$0.mLayoutManager;
        if (gridLayoutManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLayoutManager");
            gridLayoutManager = null;
        }
        if (V9 == gridLayoutManager.getSpanCount()) {
            return;
        }
        GridLayoutManager gridLayoutManager2 = this$0.mLayoutManager;
        if (gridLayoutManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLayoutManager");
            gridLayoutManager2 = null;
        }
        gridLayoutManager2.setSpanCount(V9);
        RecyclerView recyclerView2 = this$0.mListView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mListView");
        } else {
            recyclerView = recyclerView2;
        }
        recyclerView.post(new Runnable() { // from class: com.tencent.mobileqq.guild.homev2.live.part.i
            @Override // java.lang.Runnable
            public final void run() {
                GuildAVListContentPart.S9(GuildAVListContentPart.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S9(GuildAVListContentPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        np1.a aVar = this$0.mAdapter;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
            aVar = null;
        }
        aVar.notifyDataSetChanged();
    }

    private final void T9() {
        ViewGroup viewGroup = this.mEmptyTipContainer;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEmptyTipContainer");
            viewGroup = null;
        }
        VideoReport.setElementId(viewGroup, "em_sgrp_empty");
    }

    private final void U9(Function1<? super GuildAVBaseAdapterDelegate.a, Unit> callback) {
        GridLayoutManager gridLayoutManager = this.mLayoutManager;
        if (gridLayoutManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLayoutManager");
            gridLayoutManager = null;
        }
        int childCount = gridLayoutManager.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            GridLayoutManager gridLayoutManager2 = this.mLayoutManager;
            if (gridLayoutManager2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLayoutManager");
                gridLayoutManager2 = null;
            }
            View childAt = gridLayoutManager2.getChildAt(i3);
            if (childAt != null) {
                RecyclerView recyclerView = this.mListView;
                if (recyclerView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mListView");
                    recyclerView = null;
                }
                RecyclerView.ViewHolder childViewHolder = recyclerView.getChildViewHolder(childAt);
                if (childViewHolder instanceof GuildAVBaseAdapterDelegate.a) {
                    callback.invoke(childViewHolder);
                }
            }
        }
    }

    private final int V9(int width) {
        if (width < bi.b(549)) {
            return 2;
        }
        if (width < bi.b(768)) {
            return 3;
        }
        return 4;
    }

    private final void W9(pp1.g item) {
        IGProChannelInfo B = ch.B(item.getChannelId());
        GuildAVListContentViewModel guildAVListContentViewModel = null;
        if (B == null) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str = "handleClickItem channelInfoIsNull " + item;
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("GuildLiveListPart", 1, (String) it.next(), null);
            }
            GuildAVListContentViewModel guildAVListContentViewModel2 = this.mViewModel;
            if (guildAVListContentViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            } else {
                guildAVListContentViewModel = guildAVListContentViewModel2;
            }
            guildAVListContentViewModel.S1("clickInvalidChanel");
            QQToastUtil.showQQToast(1, "\u5b50\u9891\u9053\u4e0d\u5b58\u5728\u4e86");
            return;
        }
        ap1.a aVar = new ap1.a();
        aVar.a(zr1.e.INSTANCE.a(this.mJumpGuildParam, null));
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        aVar.b(B, true, context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void aa(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ba(GuildAVListContentPart this$0, pp1.g it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.W9(it);
    }

    private final void ca() {
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("GuildLiveListPart", 1, "openCreateChannelPage, " + this.mGuildId);
        }
        Activity hostActivity = getPartHost().getHostActivity();
        if (!(hostActivity instanceof FragmentActivity)) {
            return;
        }
        CreateSubChannelInfo createSubChannelInfo = new CreateSubChannelInfo(this.mGuildId, MiscKt.l(this.mCategoryId), "list_setting");
        int i3 = this.mCategoryType;
        int i16 = 5;
        if (i3 != 3 && i3 == 9) {
            i16 = 2;
        }
        createSubChannelInfo.f214824h = i16;
        createSubChannelInfo.f214826m = "\u53d6\u6d88";
        QQGuildSubChannelCreateDialogFragment.Eh(createSubChannelInfo).show(((FragmentActivity) hostActivity).getSupportFragmentManager(), "GuildLiveListPart");
    }

    private final void da() {
        IPerformanceReportTask iPerformanceReportTask = this.mReportTask;
        RecyclerView recyclerView = null;
        if (iPerformanceReportTask != null) {
            RecyclerView recyclerView2 = this.mListView;
            if (recyclerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mListView");
                recyclerView2 = null;
            }
            qw1.b.q(iPerformanceReportTask, recyclerView2, null, 2, null);
        }
        RecyclerView recyclerView3 = this.mListView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mListView");
        } else {
            recyclerView = recyclerView3;
        }
        recyclerView.addOnScrollListener(new e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ea(pp1.j emptyData) {
        int i3;
        String qqStr;
        String qqStr2;
        ViewGroup viewGroup = this.mEmptyTipContainer;
        ViewGroup viewGroup2 = null;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEmptyTipContainer");
            viewGroup = null;
        }
        if (emptyData.getIsEmptyList()) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        viewGroup.setVisibility(i3);
        GuildQUIEmptyState.a s16 = new GuildQUIEmptyState.a(getContext()).s(3);
        int i16 = this.mCategoryType;
        if (i16 != 3) {
            if (i16 != 9) {
                qqStr = "";
            } else {
                qqStr = HardCodeUtil.qqStr(R.string.f1511716z);
            }
        } else {
            qqStr = HardCodeUtil.qqStr(R.string.f1511616y);
        }
        Intrinsics.checkNotNullExpressionValue(qqStr, "when (mCategoryType) {\n \u2026e -> \"\"\n                }");
        GuildQUIEmptyState.a o16 = s16.u(qqStr).o(0);
        if (emptyData.getIsCanCreate()) {
            int i17 = this.mCategoryType;
            if (i17 != 3) {
                if (i17 != 9) {
                    qqStr2 = "\u521b\u5efa";
                } else {
                    qqStr2 = HardCodeUtil.qqStr(R.string.f141350gf);
                }
            } else {
                qqStr2 = HardCodeUtil.qqStr(R.string.f141310gb);
            }
            Intrinsics.checkNotNullExpressionValue(qqStr2, "when (mCategoryType) {\n \u2026-> \"\u521b\u5efa\"\n                }");
            o16.p(qqStr2, new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.homev2.live.part.h
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GuildAVListContentPart.ga(GuildAVListContentPart.this, view);
                }
            });
        }
        ViewGroup viewGroup3 = this.mEmptyTipContainer;
        if (viewGroup3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEmptyTipContainer");
            viewGroup3 = null;
        }
        if (viewGroup3.getChildCount() > 0) {
            ViewGroup viewGroup4 = this.mEmptyTipContainer;
            if (viewGroup4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mEmptyTipContainer");
                viewGroup4 = null;
            }
            viewGroup4.removeAllViews();
        }
        ViewGroup viewGroup5 = this.mEmptyTipContainer;
        if (viewGroup5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEmptyTipContainer");
        } else {
            viewGroup2 = viewGroup5;
        }
        viewGroup2.addView(o16.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ga(GuildAVListContentPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.ca();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ha(List<? extends pp1.g> list) {
        int i3;
        int collectionSizeOrDefault;
        Logger logger = Logger.f235387a;
        if (QLog.isDebugVersion()) {
            Logger.a d16 = logger.d();
            List<? extends pp1.g> list2 = list;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            Iterator<T> it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(((pp1.g) it.next()).b());
            }
            d16.d("GuildLiveListPart", 1, "updateListContent list:" + arrayList);
        }
        RecyclerView recyclerView = this.mListView;
        np1.a aVar = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mListView");
            recyclerView = null;
        }
        if (true ^ list.isEmpty()) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        recyclerView.setVisibility(i3);
        np1.a aVar2 = this.mAdapter;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
        } else {
            aVar = aVar2;
        }
        aVar.setItems(list);
    }

    private final void initData() {
        c.Companion companion = ef1.c.INSTANCE;
        IPartHost partHost = getPartHost();
        Intrinsics.checkNotNullExpressionValue(partHost, "partHost");
        ViewModel viewModel = new ViewModelProvider(partHost, new b(partHost, this)).get(GuildAVListContentViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, \u2026k(this) })[T::class.java]");
        this.mViewModel = (GuildAVListContentViewModel) viewModel;
        IPartHost partHost2 = getPartHost();
        Intrinsics.checkNotNullExpressionValue(partHost2, "partHost");
        ViewModel viewModel2 = new ViewModelProvider(partHost2, new c(partHost2, this)).get(com.tencent.mobileqq.guild.homev2.live.viewmodel.d.class);
        Intrinsics.checkNotNullExpressionValue(viewModel2, "ViewModelProvider(this, \u2026k(this) })[T::class.java]");
        this.avLivePermissionViewModel = (com.tencent.mobileqq.guild.homev2.live.viewmodel.d) viewModel2;
        MediatorLiveData<pp1.j> mediatorLiveData = new MediatorLiveData<>();
        GuildAVListContentViewModel guildAVListContentViewModel = this.mViewModel;
        GuildAVListContentViewModel guildAVListContentViewModel2 = null;
        if (guildAVListContentViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            guildAVListContentViewModel = null;
        }
        LiveData Q1 = guildAVListContentViewModel.Q1();
        final Function1<List<? extends pp1.g>, Unit> function1 = new Function1<List<? extends pp1.g>, Unit>() { // from class: com.tencent.mobileqq.guild.homev2.live.part.GuildAVListContentPart$initData$3$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends pp1.g> list) {
                invoke2(list);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<? extends pp1.g> list) {
                MediatorLiveData mediatorLiveData2;
                MediatorLiveData mediatorLiveData3;
                mediatorLiveData2 = GuildAVListContentPart.this.isShowEmptyTipsLiveData;
                MediatorLiveData mediatorLiveData4 = null;
                if (mediatorLiveData2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("isShowEmptyTipsLiveData");
                    mediatorLiveData2 = null;
                }
                pp1.j jVar = (pp1.j) mediatorLiveData2.getValue();
                mediatorLiveData3 = GuildAVListContentPart.this.isShowEmptyTipsLiveData;
                if (mediatorLiveData3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("isShowEmptyTipsLiveData");
                } else {
                    mediatorLiveData4 = mediatorLiveData3;
                }
                boolean isEmpty = list.isEmpty();
                boolean z16 = false;
                if (jVar != null && !jVar.getIsCanCreate()) {
                    z16 = true;
                }
                mediatorLiveData4.setValue(new pp1.j(isEmpty, !z16));
            }
        };
        mediatorLiveData.addSource(Q1, new Observer() { // from class: com.tencent.mobileqq.guild.homev2.live.part.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildAVListContentPart.X9(Function1.this, obj);
            }
        });
        com.tencent.mobileqq.guild.homev2.live.viewmodel.d dVar = this.avLivePermissionViewModel;
        if (dVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avLivePermissionViewModel");
            dVar = null;
        }
        LiveData Q12 = dVar.Q1();
        final Function1<Boolean, Unit> function12 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.homev2.live.part.GuildAVListContentPart$initData$3$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean canCreate) {
                MediatorLiveData mediatorLiveData2;
                MediatorLiveData mediatorLiveData3;
                mediatorLiveData2 = GuildAVListContentPart.this.isShowEmptyTipsLiveData;
                MediatorLiveData mediatorLiveData4 = null;
                if (mediatorLiveData2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("isShowEmptyTipsLiveData");
                    mediatorLiveData2 = null;
                }
                pp1.j jVar = (pp1.j) mediatorLiveData2.getValue();
                mediatorLiveData3 = GuildAVListContentPart.this.isShowEmptyTipsLiveData;
                if (mediatorLiveData3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("isShowEmptyTipsLiveData");
                } else {
                    mediatorLiveData4 = mediatorLiveData3;
                }
                boolean z16 = false;
                if (jVar != null && !jVar.getIsEmptyList()) {
                    z16 = true;
                }
                Intrinsics.checkNotNullExpressionValue(canCreate, "canCreate");
                mediatorLiveData4.setValue(new pp1.j(!z16, canCreate.booleanValue()));
            }
        };
        mediatorLiveData.addSource(Q12, new Observer() { // from class: com.tencent.mobileqq.guild.homev2.live.part.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildAVListContentPart.Y9(Function1.this, obj);
            }
        });
        this.isShowEmptyTipsLiveData = mediatorLiveData;
        GuildAVListContentViewModel guildAVListContentViewModel3 = this.mViewModel;
        if (guildAVListContentViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            guildAVListContentViewModel3 = null;
        }
        LiveData<List<pp1.g>> Q13 = guildAVListContentViewModel3.Q1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<List<? extends pp1.g>, Unit> function13 = new Function1<List<? extends pp1.g>, Unit>() { // from class: com.tencent.mobileqq.guild.homev2.live.part.GuildAVListContentPart$initData$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends pp1.g> list) {
                invoke2(list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<? extends pp1.g> it) {
                GuildAVListContentPart guildAVListContentPart = GuildAVListContentPart.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                guildAVListContentPart.ha(it);
            }
        };
        Q13.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.guild.homev2.live.part.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildAVListContentPart.Z9(Function1.this, obj);
            }
        });
        MediatorLiveData<pp1.j> mediatorLiveData2 = this.isShowEmptyTipsLiveData;
        if (mediatorLiveData2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("isShowEmptyTipsLiveData");
            mediatorLiveData2 = null;
        }
        LifecycleOwner lifecycleOwner2 = getPartHost().getLifecycleOwner();
        final Function1<pp1.j, Unit> function14 = new Function1<pp1.j, Unit>() { // from class: com.tencent.mobileqq.guild.homev2.live.part.GuildAVListContentPart$initData$5
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(pp1.j jVar) {
                invoke2(jVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(pp1.j it) {
                GuildAVListContentPart guildAVListContentPart = GuildAVListContentPart.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                guildAVListContentPart.ea(it);
            }
        };
        mediatorLiveData2.observe(lifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.guild.homev2.live.part.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildAVListContentPart.aa(Function1.this, obj);
            }
        });
        GuildAVListContentViewModel guildAVListContentViewModel4 = this.mViewModel;
        if (guildAVListContentViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
        } else {
            guildAVListContentViewModel2 = guildAVListContentViewModel4;
        }
        guildAVListContentViewModel2.S1("initData");
    }

    private final void initView() {
        View findViewById = getPartRootView().findViewById(R.id.uur);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.empty_tip_container)");
        this.mEmptyTipContainer = (ViewGroup) findViewById;
        View findViewById2 = getPartRootView().findViewById(R.id.eap);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.list)");
        this.mListView = (RecyclerView) findViewById2;
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(lifecycleOwner, "partHost.hostLifecycleOwner");
        this.mAdapter = new np1.a(lifecycleOwner, new a.b() { // from class: com.tencent.mobileqq.guild.homev2.live.part.f
            @Override // np1.a.b
            public final void a(pp1.g gVar) {
                GuildAVListContentPart.ba(GuildAVListContentPart.this, gVar);
            }
        });
        RecyclerView recyclerView = this.mListView;
        GridLayoutManager gridLayoutManager = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mListView");
            recyclerView = null;
        }
        np1.a aVar = this.mAdapter;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
            aVar = null;
        }
        recyclerView.setAdapter(aVar);
        RecyclerView recyclerView2 = this.mListView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mListView");
            recyclerView2 = null;
        }
        recyclerView2.setHasFixedSize(true);
        RecyclerView recyclerView3 = this.mListView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mListView");
            recyclerView3 = null;
        }
        recyclerView3.setItemAnimator(null);
        GridLayoutManager gridLayoutManager2 = new GridLayoutManager(getContext(), 2);
        this.mLayoutManager = gridLayoutManager2;
        gridLayoutManager2.setSpanSizeLookup(new d());
        RecyclerView recyclerView4 = this.mListView;
        if (recyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mListView");
            recyclerView4 = null;
        }
        GridLayoutManager gridLayoutManager3 = this.mLayoutManager;
        if (gridLayoutManager3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLayoutManager");
        } else {
            gridLayoutManager = gridLayoutManager3;
        }
        recyclerView4.setLayoutManager(gridLayoutManager);
        Q9();
        da();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        initView();
        initData();
        T9();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartPause(@Nullable Activity activity) {
        super.onPartPause(activity);
        U9(new Function1<GuildAVBaseAdapterDelegate.a, Unit>() { // from class: com.tencent.mobileqq.guild.homev2.live.part.GuildAVListContentPart$onPartPause$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(GuildAVBaseAdapterDelegate.a aVar) {
                invoke2(aVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull GuildAVBaseAdapterDelegate.a it) {
                Intrinsics.checkNotNullParameter(it, "it");
                it.o(false);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(@Nullable Activity activity) {
        super.onPartResume(activity);
        U9(new Function1<GuildAVBaseAdapterDelegate.a, Unit>() { // from class: com.tencent.mobileqq.guild.homev2.live.part.GuildAVListContentPart$onPartResume$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(GuildAVBaseAdapterDelegate.a aVar) {
                invoke2(aVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull GuildAVBaseAdapterDelegate.a it) {
                Intrinsics.checkNotNullParameter(it, "it");
                it.o(true);
            }
        });
    }
}
