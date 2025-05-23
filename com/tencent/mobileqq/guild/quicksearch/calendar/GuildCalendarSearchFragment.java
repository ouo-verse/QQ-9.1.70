package com.tencent.mobileqq.guild.quicksearch.calendar;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.guild.base.extension.CalendarEx;
import com.tencent.mobileqq.guild.base.extension.m;
import com.tencent.mobileqq.guild.component.GuildQUIEmptyState;
import com.tencent.mobileqq.guild.component.animator.ScanningLightView;
import com.tencent.mobileqq.guild.home.schedule.models.a;
import com.tencent.mobileqq.guild.home.views.dialog.ScheduleDateLocatorDialog;
import com.tencent.mobileqq.guild.quicksearch.GuildQuickSearchFragment;
import com.tencent.mobileqq.guild.quicksearch.calendar.CalendarSearchViewModel;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.bi;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.cw;
import com.tencent.mobileqq.guild.util.o;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.mobileqq.widget.selectorview.QActionSheet;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.PageReportPolicy;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import cooperation.qzone.QzoneIPCModule;
import ef1.c;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Function0;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import kotlin.ranges.IntRange;
import kotlin.time.Duration;
import kotlin.time.TimeSource;
import kotlin.time.TimedValue;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.flow.StateFlow;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 U2\u00020\u0001:\u0001VB\u0007\u00a2\u0006\u0004\bS\u0010TJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0014J$\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\"\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0017\u001a\u00020\u0002H\u0016J\b\u0010\u0018\u001a\u00020\u0010H\u0002J\b\u0010\u0019\u001a\u00020\u0010H\u0002J\b\u0010\u001a\u001a\u00020\u0010H\u0002J\b\u0010\u001b\u001a\u00020\u0010H\u0002J\b\u0010\u001c\u001a\u00020\u0010H\u0002J\u0010\u0010\u001f\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u001dH\u0002J\b\u0010 \u001a\u00020\u0010H\u0002J\b\u0010!\u001a\u00020\u0010H\u0002R\u0016\u0010$\u001a\u00020\n8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00107\u001a\u00020\u000e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0018\u00109\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00106R\u0016\u0010=\u001a\u00020:8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010A\u001a\u00020>8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010E\u001a\u00020B8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0014\u0010I\u001a\u00020F8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010M\u001a\u00020J8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bK\u0010LR\u0016\u0010P\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010OR\u0016\u0010R\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bQ\u0010O\u00a8\u0006W"}, d2 = {"Lcom/tencent/mobileqq/guild/quicksearch/calendar/GuildCalendarSearchFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "", "needStatusTrans", "needImmersive", "isWrapContent", "", "getContentLayoutId", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "", "onResume", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "onBackEvent", "initView", "Uh", "initData", "Qh", "Sh", "Lcom/tencent/mobileqq/guild/home/schedule/models/a$a;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Ph", "closePage", "initDtReport", BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/ViewGroup;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Lcom/tencent/mobileqq/widget/navbar/NavBarCommon;", "D", "Lcom/tencent/mobileqq/widget/navbar/NavBarCommon;", "navigator", "Landroid/widget/TextView;", "E", "Landroid/widget/TextView;", "monthHeader", "Landroid/widget/LinearLayout;", UserInfo.SEX_FEMALE, "Landroid/widget/LinearLayout;", "weekdaysIndicator", "Landroidx/recyclerview/widget/RecyclerView;", "G", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "H", "Landroid/view/View;", "contentView", "I", "emptyView", "Lcom/tencent/mobileqq/guild/component/animator/ScanningLightView;", "J", "Lcom/tencent/mobileqq/guild/component/animator/ScanningLightView;", "loadingView", "", "K", "Ljava/lang/String;", "guildId", "Landroidx/recyclerview/widget/GridLayoutManager;", "L", "Landroidx/recyclerview/widget/GridLayoutManager;", "layoutManager", "Lcom/tencent/mobileqq/guild/quicksearch/calendar/c;", "M", "Lcom/tencent/mobileqq/guild/quicksearch/calendar/c;", "adapter", "Lcom/tencent/mobileqq/guild/quicksearch/calendar/CalendarSearchViewModel;", "N", "Lcom/tencent/mobileqq/guild/quicksearch/calendar/CalendarSearchViewModel;", "viewModel", "P", "Z", "needScrollToEnd", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "needScrollToTop", "<init>", "()V", BdhLogUtil.LogTag.Tag_Req, "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildCalendarSearchFragment extends QPublicBaseFragment {

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    private ViewGroup rootView;

    /* renamed from: D, reason: from kotlin metadata */
    private NavBarCommon navigator;

    /* renamed from: E, reason: from kotlin metadata */
    private TextView monthHeader;

    /* renamed from: F, reason: from kotlin metadata */
    private LinearLayout weekdaysIndicator;

    /* renamed from: G, reason: from kotlin metadata */
    private RecyclerView recyclerView;

    /* renamed from: H, reason: from kotlin metadata */
    private View contentView;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private View emptyView;

    /* renamed from: J, reason: from kotlin metadata */
    private ScanningLightView loadingView;

    /* renamed from: L, reason: from kotlin metadata */
    private GridLayoutManager layoutManager;

    /* renamed from: N, reason: from kotlin metadata */
    private CalendarSearchViewModel viewModel;

    /* renamed from: Q, reason: from kotlin metadata */
    private boolean needScrollToTop;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private String guildId = "";

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.quicksearch.calendar.c adapter = new com.tencent.mobileqq.guild.quicksearch.calendar.c(new GuildCalendarSearchFragment$adapter$1(this));

    /* renamed from: P, reason: from kotlin metadata */
    private boolean needScrollToEnd = true;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007R\u0014\u0010\n\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0014\u0010\r\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/guild/quicksearch/calendar/GuildCalendarSearchFragment$a;", "", "Landroid/content/Context;", "context", "", "guildId", "", "requestCode", "", "a", "REQUEST_CODE_FOR_CALENDAR_SEARCH", "I", "SCROLL_REQUEST_THRESHOLD", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.quicksearch.calendar.GuildCalendarSearchFragment$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void a(@NotNull Context context, @NotNull String guildId, int requestCode) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            Intent intent = new Intent();
            intent.putExtra("guildId", guildId);
            QPublicFragmentActivity.b.f(context, intent, QPublicFragmentActivity.class, GuildCalendarSearchFragment.class, requestCode);
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f231582a;

        static {
            int[] iArr = new int[CalendarSearchViewModel.PageState.values().length];
            try {
                iArr[CalendarSearchViewModel.PageState.LOADING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CalendarSearchViewModel.PageState.FAILED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CalendarSearchViewModel.PageState.FINISH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f231582a = iArr;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/base/mvvm/SingleViewModelProvider$Companion$factory$1", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "p0", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c implements ViewModelProvider.Factory {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewModelStoreOwner f231583a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ GuildCalendarSearchFragment f231584b;

        public c(ViewModelStoreOwner viewModelStoreOwner, GuildCalendarSearchFragment guildCalendarSearchFragment) {
            this.f231583a = viewModelStoreOwner;
            this.f231584b = guildCalendarSearchFragment;
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        @NotNull
        public <T extends ViewModel> T create(@NotNull Class<T> p06) {
            Intrinsics.checkNotNullParameter(p06, "p0");
            TimedValue timedValue = new TimedValue(new CalendarSearchViewModel(this.f231584b.guildId), TimeSource.Monotonic.ValueTimeMark.m1966elapsedNowUwyO8pc(TimeSource.Monotonic.INSTANCE.m1963markNowz9LOYto()), null);
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("GuildViewModelProvider", 2, "create " + m.a(timedValue.getValue()) + " cost " + Duration.m1875toStringimpl(timedValue.m1981getDurationUwyO8pc()));
            }
            return (T) timedValue.getValue();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/guild/quicksearch/calendar/GuildCalendarSearchFragment$d", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "", "position", "getSpanSize", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class d extends GridLayoutManager.SpanSizeLookup {
        d() {
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanSize(int position) {
            com.tencent.mobileqq.guild.home.schedule.models.a aVar = GuildCalendarSearchFragment.this.adapter.getItems().get(position);
            if (aVar instanceof a.CalendarDay) {
                return 1;
            }
            if (aVar instanceof a.CalendarMonth) {
                return 7;
            }
            if (aVar instanceof a.PlaceHolder) {
                return ((a.PlaceHolder) aVar).getSpanSize();
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016R\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/guild/quicksearch/calendar/GuildCalendarSearchFragment$e", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "dx", "dy", "", "onScrolled", "", "d", "Z", "isScrollingUp", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class e extends RecyclerView.OnScrollListener {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private boolean isScrollingUp;

        e() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NotNull RecyclerView recyclerView, int dx5, int dy5) {
            boolean z16;
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, dx5, dy5);
            GuildCalendarSearchFragment.this.Uh();
            if (dy5 > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.isScrollingUp = z16;
            GridLayoutManager gridLayoutManager = GuildCalendarSearchFragment.this.layoutManager;
            CalendarSearchViewModel calendarSearchViewModel = null;
            if (gridLayoutManager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("layoutManager");
                gridLayoutManager = null;
            }
            int findFirstVisibleItemPosition = gridLayoutManager.findFirstVisibleItemPosition();
            GridLayoutManager gridLayoutManager2 = GuildCalendarSearchFragment.this.layoutManager;
            if (gridLayoutManager2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("layoutManager");
                gridLayoutManager2 = null;
            }
            int findLastVisibleItemPosition = gridLayoutManager2.findLastVisibleItemPosition();
            int num_backgournd_icon = GuildCalendarSearchFragment.this.adapter.getNUM_BACKGOURND_ICON();
            boolean z17 = this.isScrollingUp;
            if (z17 && findLastVisibleItemPosition >= num_backgournd_icon - 100) {
                CalendarSearchViewModel calendarSearchViewModel2 = GuildCalendarSearchFragment.this.viewModel;
                if (calendarSearchViewModel2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                } else {
                    calendarSearchViewModel = calendarSearchViewModel2;
                }
                calendarSearchViewModel.o2(true);
                return;
            }
            if (!z17 && findFirstVisibleItemPosition <= 100) {
                CalendarSearchViewModel calendarSearchViewModel3 = GuildCalendarSearchFragment.this.viewModel;
                if (calendarSearchViewModel3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                } else {
                    calendarSearchViewModel = calendarSearchViewModel3;
                }
                calendarSearchViewModel.o2(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Lh(final GuildCalendarSearchFragment this$0, View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RecyclerView recyclerView = this$0.recyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        recyclerView.post(new Runnable() { // from class: com.tencent.mobileqq.guild.quicksearch.calendar.g
            @Override // java.lang.Runnable
            public final void run() {
                GuildCalendarSearchFragment.Mh(GuildCalendarSearchFragment.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Mh(GuildCalendarSearchFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RecyclerView recyclerView = this$0.recyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        recyclerView.invalidateItemDecorations();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Nh(GuildCalendarSearchFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Oh(GuildCalendarSearchFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Sh();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ph(a.CalendarDay item) {
        CalendarSearchViewModel calendarSearchViewModel = this.viewModel;
        if (calendarSearchViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            calendarSearchViewModel = null;
        }
        calendarSearchViewModel.s2(item.a());
        GuildQuickSearchFragment.Companion companion = GuildQuickSearchFragment.INSTANCE;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        companion.b(requireContext, this.guildId, item.getTimeMs(), 1002);
        Logger.f235387a.d().d("QQGuildInSearchTag.GuildCalendarSearchFragment", 1, "onPickDate " + this.guildId + " " + item.getTimeMs());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Qh() {
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.quicksearch.calendar.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildCalendarSearchFragment.Rh(GuildCalendarSearchFragment.this, view);
            }
        };
        GuildQUIEmptyState.a q16 = new GuildQUIEmptyState.a(getContext()).s(3).o(2).r(false).u("\u7f51\u7edc\u5f02\u5e38").q("\u8bf7\u68c0\u67e5\u7f51\u7edc\u8bbe\u7f6e\u540e\u91cd\u8bd5");
        String string = getResources().getString(R.string.f152871ak);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.guild_reload)");
        this.emptyView = q16.p(string, onClickListener).a();
        ViewGroup viewGroup = this.rootView;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            viewGroup = null;
        }
        viewGroup.addView(this.emptyView, -1, -1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Rh(GuildCalendarSearchFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        CalendarSearchViewModel calendarSearchViewModel = this$0.viewModel;
        if (calendarSearchViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            calendarSearchViewModel = null;
        }
        calendarSearchViewModel.p2(CalendarEx.f214714a.e(), new IntRange(-3, -1));
        this$0.needScrollToEnd = true;
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void Sh() {
        Calendar calendar;
        if (!o.c("fastClickGuard")) {
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
            final com.tencent.mobileqq.guild.quicksearch.calendar.b bVar = new com.tencent.mobileqq.guild.quicksearch.calendar.b(requireContext);
            TextView textView = this.monthHeader;
            CalendarSearchViewModel calendarSearchViewModel = null;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("monthHeader");
                textView = null;
            }
            Object tag = textView.getTag();
            if (tag instanceof Calendar) {
                calendar = (Calendar) tag;
            } else {
                calendar = null;
            }
            if (calendar == null) {
                calendar = CalendarEx.f214714a.e();
            }
            CalendarSearchViewModel calendarSearchViewModel2 = this.viewModel;
            if (calendarSearchViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                calendarSearchViewModel2 = null;
            }
            Calendar calendar2 = calendarSearchViewModel2.get_minStartData();
            CalendarSearchViewModel calendarSearchViewModel3 = this.viewModel;
            if (calendarSearchViewModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            } else {
                calendarSearchViewModel = calendarSearchViewModel3;
            }
            bVar.x(calendar, calendar2, calendarSearchViewModel.get_maxEndData());
            final View s16 = bVar.s();
            bVar.i(new QActionSheet.f() { // from class: com.tencent.mobileqq.guild.quicksearch.calendar.GuildCalendarSearchFragment$showMonthSelector$1$1
                @Override // com.tencent.mobileqq.widget.selectorview.QActionSheet.f
                public void onConfirm() {
                    BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new GuildCalendarSearchFragment$showMonthSelector$1$1$onConfirm$1(bVar, this, s16, null), 3, null);
                }

                @Override // com.tencent.mobileqq.widget.selectorview.QActionSheet.f
                public void onDismiss() {
                    Map mapOf;
                    View view = s16;
                    mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("sgrp_btn_type", "2"));
                    VideoReport.reportEvent("dt_clck", view, mapOf);
                }

                @Override // com.tencent.mobileqq.widget.selectorview.QActionSheet.f
                public void t() {
                }
            });
            bVar.m();
            Function0.b(200, new Runnable() { // from class: com.tencent.mobileqq.guild.quicksearch.calendar.h
                @Override // java.lang.Runnable
                public final void run() {
                    GuildCalendarSearchFragment.Th(s16, this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Th(View contentView, GuildCalendarSearchFragment this$0) {
        Intrinsics.checkNotNullParameter(contentView, "$contentView");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ViewGroup viewGroup = this$0.rootView;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            viewGroup = null;
        }
        VideoReport.setLogicParent(contentView, viewGroup);
        VideoReport.setElementId(contentView, "em_sgrp_search_date_pop");
        VideoReport.reportEvent("dt_imp", contentView, new HashMap());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Uh() {
        GridLayoutManager gridLayoutManager = this.layoutManager;
        TextView textView = null;
        if (gridLayoutManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutManager");
            gridLayoutManager = null;
        }
        int findFirstCompletelyVisibleItemPosition = gridLayoutManager.findFirstCompletelyVisibleItemPosition();
        boolean z16 = false;
        if (findFirstCompletelyVisibleItemPosition >= 0 && findFirstCompletelyVisibleItemPosition < this.adapter.getNUM_BACKGOURND_ICON()) {
            z16 = true;
        }
        if (z16) {
            com.tencent.mobileqq.guild.home.schedule.models.a aVar = this.adapter.getItems().get(findFirstCompletelyVisibleItemPosition);
            TextView textView2 = this.monthHeader;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("monthHeader");
                textView2 = null;
            }
            textView2.setText(aVar.a().get(1) + "\u5e74" + (aVar.a().get(2) + 1) + "\u6708");
            TextView textView3 = this.monthHeader;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("monthHeader");
            } else {
                textView = textView3;
            }
            textView.setTag(aVar.a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void closePage() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setResult(10213);
        }
        FragmentActivity activity2 = getActivity();
        if (activity2 != null) {
            activity2.finish();
        }
    }

    private final void initData() {
        String str;
        boolean z16;
        int roundToInt;
        Intent intent;
        FragmentActivity activity = getActivity();
        CalendarSearchViewModel calendarSearchViewModel = null;
        if (activity != null && (intent = activity.getIntent()) != null) {
            str = intent.getStringExtra("guildId");
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        this.guildId = str;
        if (str.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            Logger.f235387a.d().d("QQGuildInSearchTag.GuildCalendarSearchFragment", 1, "params error, guildId is 0, finish self");
            FragmentActivity activity2 = getActivity();
            if (activity2 != null) {
                activity2.finish();
                return;
            }
            return;
        }
        c.Companion companion = ef1.c.INSTANCE;
        ViewModel viewModel = new ViewModelProvider(this, new c(this, this)).get(CalendarSearchViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, \u2026k(this) })[T::class.java]");
        this.viewModel = (CalendarSearchViewModel) viewModel;
        this.layoutManager = new GridLayoutManager(getContext(), 7);
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        recyclerView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.tencent.mobileqq.guild.quicksearch.calendar.d
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
                GuildCalendarSearchFragment.Lh(GuildCalendarSearchFragment.this, view, i3, i16, i17, i18, i19, i26, i27, i28);
            }
        });
        GridLayoutManager gridLayoutManager = this.layoutManager;
        if (gridLayoutManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutManager");
            gridLayoutManager = null;
        }
        gridLayoutManager.setSpanSizeLookup(new d());
        RecyclerView recyclerView2 = this.recyclerView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView2 = null;
        }
        GridLayoutManager gridLayoutManager2 = this.layoutManager;
        if (gridLayoutManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutManager");
            gridLayoutManager2 = null;
        }
        recyclerView2.setLayoutManager(gridLayoutManager2);
        RecyclerView recyclerView3 = this.recyclerView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView3 = null;
        }
        recyclerView3.setAdapter(this.adapter);
        RecyclerView recyclerView4 = this.recyclerView;
        if (recyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView4 = null;
        }
        recyclerView4.setItemAnimator(null);
        RecyclerView recyclerView5 = this.recyclerView;
        if (recyclerView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView5 = null;
        }
        roundToInt = MathKt__MathJVMKt.roundToInt(cw.b(40));
        recyclerView5.addItemDecoration(new ScheduleDateLocatorDialog.b(roundToInt));
        CalendarSearchViewModel calendarSearchViewModel2 = this.viewModel;
        if (calendarSearchViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            calendarSearchViewModel2 = null;
        }
        StateFlow<List<com.tencent.mobileqq.guild.home.schedule.models.a>> i26 = calendarSearchViewModel2.i2();
        LifecycleOwner hostLifecycleOwner = getLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(hostLifecycleOwner, "hostLifecycleOwner");
        Lifecycle.State state = Lifecycle.State.STARTED;
        Lifecycle lifecycle = hostLifecycleOwner.getLifecycle();
        Intrinsics.checkNotNullExpressionValue(lifecycle, "owner.lifecycle");
        LifecycleKt.getCoroutineScope(lifecycle).launchWhenCreated(new GuildCalendarSearchFragment$initData$$inlined$collectIn$default$1(lifecycle, state, i26, null, this));
        CalendarSearchViewModel calendarSearchViewModel3 = this.viewModel;
        if (calendarSearchViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            calendarSearchViewModel = calendarSearchViewModel3;
        }
        StateFlow<CalendarSearchViewModel.PageState> l26 = calendarSearchViewModel.l2();
        LifecycleOwner hostLifecycleOwner2 = getLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(hostLifecycleOwner2, "hostLifecycleOwner");
        Lifecycle lifecycle2 = hostLifecycleOwner2.getLifecycle();
        Intrinsics.checkNotNullExpressionValue(lifecycle2, "owner.lifecycle");
        LifecycleKt.getCoroutineScope(lifecycle2).launchWhenCreated(new GuildCalendarSearchFragment$initData$$inlined$collectIn$default$2(lifecycle2, state, l26, null, this));
    }

    private final void initDtReport() {
        Integer num;
        HashMap hashMapOf;
        VideoReport.addToDetectionWhitelist(getActivity());
        ViewGroup viewGroup = this.rootView;
        ViewGroup viewGroup2 = null;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            viewGroup = null;
        }
        VideoReport.setPageId(viewGroup, "pg_sgrp_search_date_sencod");
        ViewGroup viewGroup3 = this.rootView;
        if (viewGroup3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            viewGroup3 = null;
        }
        VideoReport.setPageReportPolicy(viewGroup3, PageReportPolicy.REPORT_ALL);
        Pair[] pairArr = new Pair[2];
        pairArr[0] = TuplesKt.to("sgrp_channel_id", this.guildId);
        IGProGuildInfo L = ch.L(this.guildId);
        if (L != null) {
            num = Integer.valueOf(rp1.a.a(L));
        } else {
            num = null;
        }
        pairArr[1] = TuplesKt.to("sgrp_user_type", num);
        hashMapOf = MapsKt__MapsKt.hashMapOf(pairArr);
        ViewGroup viewGroup4 = this.rootView;
        if (viewGroup4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            viewGroup4 = null;
        }
        VideoReport.setPageParams(viewGroup4, new PageParams(hashMapOf));
        NavBarCommon navBarCommon = this.navigator;
        if (navBarCommon == null) {
            Intrinsics.throwUninitializedPropertyAccessException("navigator");
            navBarCommon = null;
        }
        VideoReport.setElementId(navBarCommon.getLeftBackIcon(), "em_sgrp_back_btn");
        ViewGroup viewGroup5 = this.rootView;
        if (viewGroup5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
        } else {
            viewGroup2 = viewGroup5;
        }
        VideoReport.setPageLinkEnable(viewGroup2, true);
    }

    private final void initView() {
        ViewGroup viewGroup = this.rootView;
        RecyclerView recyclerView = null;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            viewGroup = null;
        }
        View findViewById = viewGroup.findViewById(R.id.zm9);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.nav_bar)");
        NavBarCommon navBarCommon = (NavBarCommon) findViewById;
        this.navigator = navBarCommon;
        if (navBarCommon == null) {
            Intrinsics.throwUninitializedPropertyAccessException("navigator");
            navBarCommon = null;
        }
        navBarCommon.setTitle("\u6309\u65e5\u671f\u67e5\u627e");
        NavBarCommon navBarCommon2 = this.navigator;
        if (navBarCommon2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("navigator");
            navBarCommon2 = null;
        }
        navBarCommon2.getLeftBackIcon().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.quicksearch.calendar.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildCalendarSearchFragment.Nh(GuildCalendarSearchFragment.this, view);
            }
        });
        ViewGroup viewGroup2 = this.rootView;
        if (viewGroup2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            viewGroup2 = null;
        }
        View findViewById2 = viewGroup2.findViewById(R.id.b_7);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.content_view)");
        this.contentView = findViewById2;
        ViewGroup viewGroup3 = this.rootView;
        if (viewGroup3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            viewGroup3 = null;
        }
        View findViewById3 = viewGroup3.findViewById(R.id.efs);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.loading_view)");
        this.loadingView = (ScanningLightView) findViewById3;
        ViewGroup viewGroup4 = this.rootView;
        if (viewGroup4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            viewGroup4 = null;
        }
        View findViewById4 = viewGroup4.findViewById(R.id.zdk);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.id.month_header)");
        this.monthHeader = (TextView) findViewById4;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        Drawable w3 = GuildUIUtils.w(requireContext, R.drawable.guild_arrow_down, Integer.valueOf(R.color.qui_common_icon_secondary));
        if (w3 != null) {
            w3.setBounds(0, 0, bi.b(16), bi.b(16));
        }
        TextView textView = this.monthHeader;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("monthHeader");
            textView = null;
        }
        textView.setCompoundDrawables(null, null, w3, null);
        TextView textView2 = this.monthHeader;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("monthHeader");
            textView2 = null;
        }
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.quicksearch.calendar.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildCalendarSearchFragment.Oh(GuildCalendarSearchFragment.this, view);
            }
        });
        ViewGroup viewGroup5 = this.rootView;
        if (viewGroup5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            viewGroup5 = null;
        }
        View findViewById5 = viewGroup5.findViewById(R.id.f122177d9);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "rootView.findViewById(R.id.weekdays_indicator)");
        LinearLayout linearLayout = (LinearLayout) findViewById5;
        this.weekdaysIndicator = linearLayout;
        hw1.a aVar = hw1.a.f406504a;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("weekdaysIndicator");
            linearLayout = null;
        }
        aVar.a(linearLayout);
        ViewGroup viewGroup6 = this.rootView;
        if (viewGroup6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            viewGroup6 = null;
        }
        View findViewById6 = viewGroup6.findViewById(R.id.i4m);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "rootView.findViewById(R.id.recycler_view)");
        RecyclerView recyclerView2 = (RecyclerView) findViewById6;
        this.recyclerView = recyclerView2;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        } else {
            recyclerView = recyclerView2;
        }
        recyclerView.addOnScrollListener(new e());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.ehb;
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

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1002 && resultCode == 10213) {
            closePage();
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        Map emptyMap;
        NavBarCommon navBarCommon = this.navigator;
        if (navBarCommon == null) {
            Intrinsics.throwUninitializedPropertyAccessException("navigator");
            navBarCommon = null;
        }
        TextView leftBackIcon = navBarCommon.getLeftBackIcon();
        emptyMap = MapsKt__MapsKt.emptyMap();
        VideoReport.reportEvent("dt_clck", leftBackIcon, emptyMap);
        return super.onBackEvent();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View onCreateView = super.onCreateView(inflater, container, savedInstanceState);
        Intrinsics.checkNotNull(onCreateView, "null cannot be cast to non-null type android.view.ViewGroup");
        this.rootView = (ViewGroup) onCreateView;
        initView();
        initData();
        ViewGroup viewGroup = this.rootView;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            viewGroup = null;
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, viewGroup);
        return viewGroup;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        initDtReport();
    }
}
