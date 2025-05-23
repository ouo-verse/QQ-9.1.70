package com.tencent.mobileqq.guild.quicksearch.resultview.feed;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.view.ViewGroupKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import androidx.vectordrawable.graphics.drawable.GuildVectorDrawableCompat;
import androidx.viewpager2.widget.ViewPager2;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.guild.component.calendar.CalendarEx;
import com.tencent.mobileqq.guild.component.calendar.CalendarExKt;
import com.tencent.mobileqq.guild.quicksearch.viewmodel.QuickSearchFilterViewModel;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.guild.util.bt;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qcircle.weseevideo.model.utils.LocaleUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vp1.cw;
import vp1.cx;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001c\u001a\u00020\u0017\u00a2\u0006\u0004\bK\u0010LJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\u0012\u0010\n\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u001c\u0010\r\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\b2\b\u0010\f\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010\u000e\u001a\u00020\u0004H\u0002J\u001c\u0010\u000f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\b2\b\u0010\f\u001a\u0004\u0018\u00010\bH\u0002J\u001c\u0010\u0010\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\b2\b\u0010\f\u001a\u0004\u0018\u00010\bH\u0002J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u0014\u001a\u00020\u0004H\u0002J\b\u0010\u0015\u001a\u00020\u0004H\u0002J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\u001c\u001a\u00020\u00178\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\"\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\"\u0012\u0006\b\u0001\u0012\u00020#0!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0018\u0010:\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u001d\u0010@\u001a\u0004\u0018\u00010;8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?R\u001d\u0010C\u001a\u0004\u0018\u00010;8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bA\u0010=\u001a\u0004\bB\u0010?R\u0018\u0010F\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0018\u0010H\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010ER\u0016\u0010J\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010I\u00a8\u0006M"}, d2 = {"Lcom/tencent/mobileqq/guild/quicksearch/resultview/feed/QuickSearchFeedDateFilterPart;", "Lcom/tencent/biz/richframework/part/Part;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "ba", "ia", "R9", "Ljava/util/Calendar;", "date", "ga", "start", "end", "ha", "V9", LocaleUtils.L_JAPANESE, "la", "", "enable", "S9", "initViewModel", "aa", "onInitView", "Lcom/tencent/mobileqq/guild/quicksearch/viewmodel/QuickSearchFilterViewModel;", "d", "Lcom/tencent/mobileqq/guild/quicksearch/viewmodel/QuickSearchFilterViewModel;", "getViewModel", "()Lcom/tencent/mobileqq/guild/quicksearch/viewmodel/QuickSearchFilterViewModel;", "viewModel", "", "e", "I", "filterBoxReportType", "Ljava/util/HashMap;", "", "", "f", "Ljava/util/HashMap;", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_PARAMS, "Lvp1/cx;", tl.h.F, "Lvp1/cx;", "titleBinding", "Lvp1/cw;", "i", "Lvp1/cw;", "filterPanelBinding", "Lcom/tencent/mobileqq/guild/quicksearch/resultview/feed/FeedSearchCalendarAdapter;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/guild/quicksearch/resultview/feed/FeedSearchCalendarAdapter;", "calendarAdapter", "Landroid/view/ViewGroup;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/ViewGroup;", "calendarPanel", "Lcom/tencent/mobileqq/activity/fling/TopGestureLayout;", "D", "Lcom/tencent/mobileqq/activity/fling/TopGestureLayout;", "gestureLayout", "Landroidx/vectordrawable/graphics/drawable/GuildVectorDrawableCompat;", "E", "Lkotlin/Lazy;", "U9", "()Landroidx/vectordrawable/graphics/drawable/GuildVectorDrawableCompat;", "previousDrawable", UserInfo.SEX_FEMALE, "T9", "nextDrawable", "G", "Ljava/util/Calendar;", "selectionStartDate", "H", "selectionEndDate", "Z", "isFilterPanelOpen", "<init>", "(Lcom/tencent/mobileqq/guild/quicksearch/viewmodel/QuickSearchFilterViewModel;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class QuickSearchFeedDateFilterPart extends Part {

    /* renamed from: C, reason: from kotlin metadata */
    private ViewGroup calendarPanel;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private TopGestureLayout gestureLayout;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy previousDrawable;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Lazy nextDrawable;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private Calendar selectionStartDate;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private Calendar selectionEndDate;

    /* renamed from: I, reason: from kotlin metadata */
    private boolean isFilterPanelOpen;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final QuickSearchFilterViewModel viewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int filterBoxReportType;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<String, ? extends Object> reportParams;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private cx titleBinding;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private cw filterPanelBinding;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private FeedSearchCalendarAdapter calendarAdapter;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/quicksearch/resultview/feed/QuickSearchFeedDateFilterPart$a", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "", "position", "", "onPageSelected", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class a extends ViewPager2.OnPageChangeCallback {

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Resources f231738c;

        a(Resources resources) {
            this.f231738c = resources;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int position) {
            boolean z16;
            int i3;
            FeedSearchCalendarAdapter feedSearchCalendarAdapter = QuickSearchFeedDateFilterPart.this.calendarAdapter;
            FeedSearchCalendarAdapter feedSearchCalendarAdapter2 = null;
            if (feedSearchCalendarAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("calendarAdapter");
                feedSearchCalendarAdapter = null;
            }
            Calendar j06 = feedSearchCalendarAdapter.j0(position);
            cw cwVar = QuickSearchFeedDateFilterPart.this.filterPanelBinding;
            if (cwVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("filterPanelBinding");
                cwVar = null;
            }
            boolean z17 = true;
            cwVar.f442819b.setText(j06.get(1) + "\u5e74" + (j06.get(2) + 1) + "\u6708");
            cw cwVar2 = QuickSearchFeedDateFilterPart.this.filterPanelBinding;
            if (cwVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("filterPanelBinding");
                cwVar2 = null;
            }
            ImageView imageView = cwVar2.f442824g;
            Resources resources = this.f231738c;
            if (position > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            imageView.setEnabled(z16);
            boolean isEnabled = imageView.isEnabled();
            int i16 = R.color.qui_common_icon_primary;
            if (isEnabled) {
                i3 = R.color.qui_common_icon_primary;
            } else {
                i3 = R.color.qui_common_icon_tertiary;
            }
            imageView.setImageTintList(resources.getColorStateList(i3));
            cw cwVar3 = QuickSearchFeedDateFilterPart.this.filterPanelBinding;
            if (cwVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("filterPanelBinding");
                cwVar3 = null;
            }
            ImageView imageView2 = cwVar3.f442823f;
            QuickSearchFeedDateFilterPart quickSearchFeedDateFilterPart = QuickSearchFeedDateFilterPart.this;
            Resources resources2 = this.f231738c;
            FeedSearchCalendarAdapter feedSearchCalendarAdapter3 = quickSearchFeedDateFilterPart.calendarAdapter;
            if (feedSearchCalendarAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("calendarAdapter");
            } else {
                feedSearchCalendarAdapter2 = feedSearchCalendarAdapter3;
            }
            if (position >= feedSearchCalendarAdapter2.getItemCount() - 1) {
                z17 = false;
            }
            imageView2.setEnabled(z17);
            if (!imageView2.isEnabled()) {
                i16 = R.color.qui_common_icon_tertiary;
            }
            imageView2.setImageTintList(resources2.getColorStateList(i16));
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", NodeProps.ON_CLICK, "(Landroid/view/View;)V", "com/tencent/mobileqq/guild/base/extension/l", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f231739d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ QuickSearchFeedDateFilterPart f231740e;

        public b(View view, QuickSearchFeedDateFilterPart quickSearchFeedDateFilterPart) {
            this.f231739d = view;
            this.f231740e = quickSearchFeedDateFilterPart;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (!com.tencent.mobileqq.guild.util.o.c("fastClickGuard")) {
                this.f231740e.R9();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", NodeProps.ON_CLICK, "(Landroid/view/View;)V", "com/tencent/mobileqq/guild/base/extension/l", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f231741d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ QuickSearchFeedDateFilterPart f231742e;

        public c(View view, QuickSearchFeedDateFilterPart quickSearchFeedDateFilterPart) {
            this.f231741d = view;
            this.f231742e = quickSearchFeedDateFilterPart;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (!com.tencent.mobileqq.guild.util.o.c("fastClickGuard")) {
                if (this.f231742e.isFilterPanelOpen) {
                    this.f231742e.R9();
                } else {
                    this.f231742e.ia();
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", NodeProps.ON_CLICK, "(Landroid/view/View;)V", "com/tencent/mobileqq/guild/base/extension/l", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class d implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f231743d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ QuickSearchFeedDateFilterPart f231744e;

        public d(View view, QuickSearchFeedDateFilterPart quickSearchFeedDateFilterPart) {
            this.f231743d = view;
            this.f231744e = quickSearchFeedDateFilterPart;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (!com.tencent.mobileqq.guild.util.o.c("fastClickGuard")) {
                if (this.f231744e.isFilterPanelOpen) {
                    this.f231744e.R9();
                }
                if (this.f231744e.selectionStartDate != null) {
                    this.f231744e.ha(null, null);
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public QuickSearchFeedDateFilterPart(@NotNull QuickSearchFilterViewModel viewModel) {
        HashMap<String, ? extends Object> hashMapOf;
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        this.viewModel = viewModel;
        this.filterBoxReportType = 3;
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("search_trace_id", kw1.a.f413327a.b()), TuplesKt.to("sgrp_filter_box_type", 3));
        this.reportParams = hashMapOf;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<GuildVectorDrawableCompat>() { // from class: com.tencent.mobileqq.guild.quicksearch.resultview.feed.QuickSearchFeedDateFilterPart$previousDrawable$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final GuildVectorDrawableCompat invoke() {
                GuildVectorDrawableCompat create = GuildVectorDrawableCompat.create(QuickSearchFeedDateFilterPart.this.getPartRootView().getResources(), R.drawable.guild_vector_icon_back, null);
                if (create == null) {
                    return null;
                }
                create.setOverrideStrokeWidth(1.7f);
                return create;
            }
        });
        this.previousDrawable = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<GuildVectorDrawableCompat>() { // from class: com.tencent.mobileqq.guild.quicksearch.resultview.feed.QuickSearchFeedDateFilterPart$nextDrawable$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final GuildVectorDrawableCompat invoke() {
                GuildVectorDrawableCompat create = GuildVectorDrawableCompat.create(QuickSearchFeedDateFilterPart.this.getPartRootView().getResources(), R.drawable.guild_vector_icon_back, null);
                if (create == null) {
                    return null;
                }
                create.setOverrideStrokeWidth(1.7f);
                return create;
            }
        });
        this.nextDrawable = lazy2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void R9() {
        this.isFilterPanelOpen = false;
        this.viewModel.d2();
        ViewGroup viewGroup = this.calendarPanel;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("calendarPanel");
            viewGroup = null;
        }
        viewGroup.setVisibility(8);
        S9(true);
        ja(this.selectionStartDate, this.selectionEndDate);
    }

    private final void S9(boolean enable) {
        View view;
        if (this.gestureLayout == null) {
            View partRootView = getPartRootView();
            ViewGroup viewGroup = null;
            if (partRootView != null) {
                view = partRootView.getRootView();
            } else {
                view = null;
            }
            if (view instanceof ViewGroup) {
                viewGroup = (ViewGroup) view;
            }
            if (viewGroup == null) {
                return;
            }
            int childCount = viewGroup.getChildCount();
            int i3 = 0;
            while (true) {
                if (i3 >= childCount) {
                    break;
                }
                View childAt = viewGroup.getChildAt(i3);
                if (childAt instanceof TopGestureLayout) {
                    this.gestureLayout = (TopGestureLayout) childAt;
                    break;
                }
                i3++;
            }
        }
        TopGestureLayout topGestureLayout = this.gestureLayout;
        if (topGestureLayout != null) {
            topGestureLayout.setInterceptTouchFlag(enable);
        }
    }

    private final GuildVectorDrawableCompat T9() {
        return (GuildVectorDrawableCompat) this.nextDrawable.getValue();
    }

    private final GuildVectorDrawableCompat U9() {
        return (GuildVectorDrawableCompat) this.previousDrawable.getValue();
    }

    private final void V9() {
        View view;
        Calendar calendar;
        cw e16 = cw.e(getPartRootView().findViewById(R.id.f164711tl0));
        Intrinsics.checkNotNullExpressionValue(e16, "bind(rootView.findViewById<View>(R.id.calendar))");
        this.filterPanelBinding = e16;
        cw cwVar = null;
        if (e16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filterPanelBinding");
            e16 = null;
        }
        ViewPager2 viewPager2 = e16.f442820c;
        Intrinsics.checkNotNullExpressionValue(viewPager2, "filterPanelBinding.calendarViewpager");
        Iterator<View> it = ViewGroupKt.getChildren(viewPager2).iterator();
        while (true) {
            if (it.hasNext()) {
                view = it.next();
                if (view instanceof RecyclerView) {
                    break;
                }
            } else {
                view = null;
                break;
            }
        }
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        final RecyclerView recyclerView = (RecyclerView) view;
        cw cwVar2 = this.filterPanelBinding;
        if (cwVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filterPanelBinding");
            cwVar2 = null;
        }
        ViewPager2 viewPager22 = cwVar2.f442820c;
        final FeedSearchCalendarAdapter feedSearchCalendarAdapter = new FeedSearchCalendarAdapter();
        IGProGuildInfo L = ch.L(this.viewModel.getPageViewModel().getGuildId());
        if (L != null) {
            Intrinsics.checkNotNullExpressionValue(L, "getGuildInfo(viewModel.pageViewModel.guildId)");
            calendar = CalendarEx.f215865a.a(L.getCreateTime() * 1000);
        } else {
            calendar = null;
        }
        feedSearchCalendarAdapter.m0(calendar, Calendar.getInstance());
        feedSearchCalendarAdapter.y0(true);
        this.calendarAdapter = feedSearchCalendarAdapter;
        feedSearchCalendarAdapter.w0(new Function2<Calendar, Calendar, Unit>() { // from class: com.tencent.mobileqq.guild.quicksearch.resultview.feed.QuickSearchFeedDateFilterPart$initFilterPanel$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Calendar calendar2, Calendar calendar3) {
                invoke2(calendar2, calendar3);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Calendar calendar2, @Nullable Calendar calendar3) {
                cw cwVar3 = QuickSearchFeedDateFilterPart.this.filterPanelBinding;
                cw cwVar4 = null;
                if (cwVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("filterPanelBinding");
                    cwVar3 = null;
                }
                cwVar3.f442822e.setEnabled((QuickSearchFeedDateFilterPart.this.selectionStartDate != null && calendar2 == null) || calendar2 != null);
                cw cwVar5 = QuickSearchFeedDateFilterPart.this.filterPanelBinding;
                if (cwVar5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("filterPanelBinding");
                } else {
                    cwVar4 = cwVar5;
                }
                cwVar4.f442821d.setEnabled(calendar2 != null);
                Sequence<View> children = ViewGroupKt.getChildren(recyclerView);
                RecyclerView recyclerView2 = recyclerView;
                for (View view2 : children) {
                    if (recyclerView2.getChildAdapterPosition(view2) != -1) {
                        view2.invalidate();
                    }
                }
                QuickSearchFeedDateFilterPart.this.ja(calendar2, calendar3);
            }
        });
        cw cwVar3 = this.filterPanelBinding;
        if (cwVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filterPanelBinding");
            cwVar3 = null;
        }
        cwVar3.f442821d.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.quicksearch.resultview.feed.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                QuickSearchFeedDateFilterPart.X9(FeedSearchCalendarAdapter.this, view2);
            }
        });
        cw cwVar4 = this.filterPanelBinding;
        if (cwVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filterPanelBinding");
            cwVar4 = null;
        }
        cwVar4.f442822e.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.quicksearch.resultview.feed.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                QuickSearchFeedDateFilterPart.Y9(QuickSearchFeedDateFilterPart.this, feedSearchCalendarAdapter, view2);
            }
        });
        viewPager22.setAdapter(feedSearchCalendarAdapter);
        Resources resources = getPartRootView().getResources();
        cw cwVar5 = this.filterPanelBinding;
        if (cwVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filterPanelBinding");
            cwVar5 = null;
        }
        cwVar5.f442824g.setImageDrawable(U9());
        cw cwVar6 = this.filterPanelBinding;
        if (cwVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filterPanelBinding");
            cwVar6 = null;
        }
        cwVar6.f442823f.setImageDrawable(T9());
        cw cwVar7 = this.filterPanelBinding;
        if (cwVar7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filterPanelBinding");
            cwVar7 = null;
        }
        cwVar7.f442820c.registerOnPageChangeCallback(new a(resources));
        cw cwVar8 = this.filterPanelBinding;
        if (cwVar8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filterPanelBinding");
            cwVar8 = null;
        }
        cwVar8.f442824g.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.quicksearch.resultview.feed.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                QuickSearchFeedDateFilterPart.Z9(QuickSearchFeedDateFilterPart.this, view2);
            }
        });
        cw cwVar9 = this.filterPanelBinding;
        if (cwVar9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filterPanelBinding");
        } else {
            cwVar = cwVar9;
        }
        cwVar.f442823f.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.quicksearch.resultview.feed.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                QuickSearchFeedDateFilterPart.W9(QuickSearchFeedDateFilterPart.this, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W9(QuickSearchFeedDateFilterPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        cw cwVar = this$0.filterPanelBinding;
        if (cwVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filterPanelBinding");
            cwVar = null;
        }
        ViewPager2 viewPager2 = cwVar.f442820c;
        viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X9(FeedSearchCalendarAdapter this_apply, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        bt btVar = bt.f235484a;
        Intrinsics.checkNotNullExpressionValue(it, "it");
        bt.h(btVar, it, "em_sgrp_search_date_clear_button", "clck", null, 8, null);
        this_apply.p0();
        EventCollector.getInstance().onViewClicked(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y9(QuickSearchFeedDateFilterPart this$0, FeedSearchCalendarAdapter this_apply, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        bt btVar = bt.f235484a;
        Intrinsics.checkNotNullExpressionValue(it, "it");
        bt.h(btVar, it, "em_sgrp_search_date_button", "clck", null, 8, null);
        this$0.R9();
        this$0.ha(this_apply.getStartDate(), this_apply.getEndDate());
        EventCollector.getInstance().onViewClicked(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z9(QuickSearchFeedDateFilterPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        cw cwVar = this$0.filterPanelBinding;
        if (cwVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filterPanelBinding");
            cwVar = null;
        }
        cwVar.f442820c.setCurrentItem(r1.getCurrentItem() - 1);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void aa() {
        cx cxVar = this.titleBinding;
        if (cxVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleBinding");
            cxVar = null;
        }
        LinearLayout root = cxVar.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "titleBinding.root");
        bt.c(root, "em_sgrp_filter_box", this.reportParams, ClickPolicy.REPORT_ALL, ExposurePolicy.REPORT_ALL, EndExposurePolicy.REPORT_NONE);
    }

    private final void ba(View rootView) {
        cx e16 = cx.e(rootView.findViewById(R.id.tj9));
        Intrinsics.checkNotNullExpressionValue(e16, "bind(rootView.findViewBy\u2026d.button_container_date))");
        e16.f442829d.setText("\u9009\u62e9\u65e5\u671f");
        LinearLayout root = e16.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "this.root");
        root.setOnClickListener(new c(root, this));
        ImageView ivClear = e16.f442828c;
        Intrinsics.checkNotNullExpressionValue(ivClear, "ivClear");
        ivClear.setOnClickListener(new d(ivClear, this));
        this.titleBinding = e16;
        View findViewById = rootView.findViewById(R.id.f164714tl3);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.calendar_panel)");
        ViewGroup viewGroup = (ViewGroup) findViewById;
        this.calendarPanel = viewGroup;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("calendarPanel");
            viewGroup = null;
        }
        viewGroup.setOnClickListener(new b(viewGroup, this));
        V9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ca(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void da(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ea(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void ga(Calendar date) {
        if (date == null) {
            date = Calendar.getInstance();
        }
        cw cwVar = this.filterPanelBinding;
        FeedSearchCalendarAdapter feedSearchCalendarAdapter = null;
        if (cwVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filterPanelBinding");
            cwVar = null;
        }
        ViewPager2 viewPager2 = cwVar.f442820c;
        FeedSearchCalendarAdapter feedSearchCalendarAdapter2 = this.calendarAdapter;
        if (feedSearchCalendarAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("calendarAdapter");
        } else {
            feedSearchCalendarAdapter = feedSearchCalendarAdapter2;
        }
        Intrinsics.checkNotNullExpressionValue(date, "target");
        viewPager2.setCurrentItem(feedSearchCalendarAdapter.i0(date), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ha(Calendar start, Calendar end) {
        Calendar calendar;
        this.selectionStartDate = start;
        if (end == null) {
            calendar = start;
        } else {
            calendar = end;
        }
        this.selectionEndDate = calendar;
        ja(start, end);
        if (start == null) {
            this.viewModel.t2(null);
            return;
        }
        if (end == null) {
            end = start;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(TuxDateStringUtils.TUX_COMMON_DATE_FORMAT);
        this.viewModel.t2(TuplesKt.to(simpleDateFormat.format(start.getTime()), simpleDateFormat.format(end.getTime())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ia() {
        this.isFilterPanelOpen = true;
        this.viewModel.u2();
        ViewGroup viewGroup = this.calendarPanel;
        FeedSearchCalendarAdapter feedSearchCalendarAdapter = null;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("calendarPanel");
            viewGroup = null;
        }
        viewGroup.setVisibility(0);
        S9(false);
        ja(this.selectionStartDate, this.selectionEndDate);
        ga(this.selectionStartDate);
        FeedSearchCalendarAdapter feedSearchCalendarAdapter2 = this.calendarAdapter;
        if (feedSearchCalendarAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("calendarAdapter");
        } else {
            feedSearchCalendarAdapter = feedSearchCalendarAdapter2;
        }
        feedSearchCalendarAdapter.x0(this.selectionStartDate, this.selectionEndDate);
    }

    private final void initViewModel() {
        LiveData<Boolean> h26 = this.viewModel.h2();
        LifecycleOwner a16 = com.tencent.mobileqq.guild.discoveryv2.content.part.d.a(this);
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.quicksearch.resultview.feed.QuickSearchFeedDateFilterPart$initViewModel$1
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
                Calendar calendar;
                if (QuickSearchFeedDateFilterPart.this.isFilterPanelOpen) {
                    QuickSearchFeedDateFilterPart.this.R9();
                }
                QuickSearchFeedDateFilterPart.this.selectionStartDate = null;
                QuickSearchFeedDateFilterPart.this.selectionEndDate = null;
                QuickSearchFeedDateFilterPart quickSearchFeedDateFilterPart = QuickSearchFeedDateFilterPart.this;
                Calendar calendar2 = quickSearchFeedDateFilterPart.selectionStartDate;
                calendar = QuickSearchFeedDateFilterPart.this.selectionEndDate;
                quickSearchFeedDateFilterPart.ja(calendar2, calendar);
            }
        };
        h26.observe(a16, new Observer() { // from class: com.tencent.mobileqq.guild.quicksearch.resultview.feed.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QuickSearchFeedDateFilterPart.ca(Function1.this, obj);
            }
        });
        LiveData<Boolean> g26 = this.viewModel.g2();
        LifecycleOwner a17 = com.tencent.mobileqq.guild.discoveryv2.content.part.d.a(this);
        final Function1<Boolean, Unit> function12 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.quicksearch.resultview.feed.QuickSearchFeedDateFilterPart$initViewModel$2
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
                if (QuickSearchFeedDateFilterPart.this.isFilterPanelOpen) {
                    QuickSearchFeedDateFilterPart.this.R9();
                }
            }
        };
        g26.observe(a17, new Observer() { // from class: com.tencent.mobileqq.guild.quicksearch.resultview.feed.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QuickSearchFeedDateFilterPart.da(Function1.this, obj);
            }
        });
        MutableLiveData<Boolean> k26 = this.viewModel.getPageViewModel().k2();
        LifecycleOwner a18 = com.tencent.mobileqq.guild.discoveryv2.content.part.d.a(this);
        final Function1<Boolean, Unit> function13 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.quicksearch.resultview.feed.QuickSearchFeedDateFilterPart$initViewModel$3
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
                cx cxVar;
                cxVar = QuickSearchFeedDateFilterPart.this.titleBinding;
                if (cxVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("titleBinding");
                    cxVar = null;
                }
                LinearLayout root = cxVar.getRoot();
                Intrinsics.checkNotNullExpressionValue(root, "titleBinding.root");
                root.setVisibility(bool.booleanValue() ^ true ? 0 : 8);
            }
        };
        k26.observe(a18, new Observer() { // from class: com.tencent.mobileqq.guild.quicksearch.resultview.feed.i
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QuickSearchFeedDateFilterPart.ea(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ja(Calendar start, Calendar end) {
        boolean z16;
        int i3;
        boolean z17;
        cx cxVar = this.titleBinding;
        cx cxVar2 = null;
        if (cxVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleBinding");
            cxVar = null;
        }
        cxVar.f442827b.setSelected(this.isFilterPanelOpen);
        cx cxVar3 = this.titleBinding;
        if (cxVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleBinding");
            cxVar3 = null;
        }
        ImageView imageView = cxVar3.f442827b;
        Intrinsics.checkNotNullExpressionValue(imageView, "titleBinding.ivArrow");
        int i16 = 0;
        if (start == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        imageView.setVisibility(i3);
        cx cxVar4 = this.titleBinding;
        if (cxVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleBinding");
            cxVar4 = null;
        }
        ImageView imageView2 = cxVar4.f442828c;
        Intrinsics.checkNotNullExpressionValue(imageView2, "titleBinding.ivClear");
        cx cxVar5 = this.titleBinding;
        if (cxVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleBinding");
            cxVar5 = null;
        }
        ImageView imageView3 = cxVar5.f442827b;
        Intrinsics.checkNotNullExpressionValue(imageView3, "titleBinding.ivArrow");
        if (imageView3.getVisibility() == 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (!(true ^ z17)) {
            i16 = 8;
        }
        imageView2.setVisibility(i16);
        cx cxVar6 = this.titleBinding;
        if (cxVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleBinding");
            cxVar6 = null;
        }
        Resources resources = cxVar6.getRoot().getResources();
        if (!this.isFilterPanelOpen && start == null) {
            GuildUIUtils guildUIUtils = GuildUIUtils.f235378a;
            cx cxVar7 = this.titleBinding;
            if (cxVar7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("titleBinding");
                cxVar7 = null;
            }
            ImageView imageView4 = cxVar7.f442827b;
            Intrinsics.checkNotNullExpressionValue(imageView4, "titleBinding.ivArrow");
            guildUIUtils.G(imageView4, resources.getColor(R.color.qui_common_text_primary));
            cx cxVar8 = this.titleBinding;
            if (cxVar8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("titleBinding");
                cxVar8 = null;
            }
            ImageView imageView5 = cxVar8.f442828c;
            Intrinsics.checkNotNullExpressionValue(imageView5, "titleBinding.ivClear");
            guildUIUtils.G(imageView5, resources.getColor(R.color.qui_common_text_primary));
            cx cxVar9 = this.titleBinding;
            if (cxVar9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("titleBinding");
                cxVar9 = null;
            }
            cxVar9.getRoot().setBackgroundResource(R.drawable.guild_quick_filter_bg);
            cx cxVar10 = this.titleBinding;
            if (cxVar10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("titleBinding");
            } else {
                cxVar2 = cxVar10;
            }
            cxVar2.f442829d.setTextColor(resources.getColorStateList(R.color.f157160bt1));
        } else {
            GuildUIUtils guildUIUtils2 = GuildUIUtils.f235378a;
            cx cxVar11 = this.titleBinding;
            if (cxVar11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("titleBinding");
                cxVar11 = null;
            }
            ImageView imageView6 = cxVar11.f442827b;
            Intrinsics.checkNotNullExpressionValue(imageView6, "titleBinding.ivArrow");
            guildUIUtils2.G(imageView6, resources.getColor(R.color.qui_common_brand_standard));
            cx cxVar12 = this.titleBinding;
            if (cxVar12 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("titleBinding");
                cxVar12 = null;
            }
            ImageView imageView7 = cxVar12.f442828c;
            Intrinsics.checkNotNullExpressionValue(imageView7, "titleBinding.ivClear");
            guildUIUtils2.G(imageView7, resources.getColor(R.color.qui_common_brand_standard));
            cx cxVar13 = this.titleBinding;
            if (cxVar13 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("titleBinding");
                cxVar13 = null;
            }
            cxVar13.getRoot().setBackgroundResource(R.drawable.guild_quick_filter_qui_brand_standard_bg);
            cx cxVar14 = this.titleBinding;
            if (cxVar14 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("titleBinding");
            } else {
                cxVar2 = cxVar14;
            }
            cxVar2.f442829d.setTextColor(resources.getColorStateList(R.color.qui_common_brand_standard));
        }
        la(start, end);
    }

    private final void la(Calendar start, Calendar end) {
        cx cxVar = null;
        if (start != null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd");
            if (end != null && !CalendarExKt.c(start, end)) {
                cx cxVar2 = this.titleBinding;
                if (cxVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("titleBinding");
                } else {
                    cxVar = cxVar2;
                }
                cxVar.f442829d.setText(simpleDateFormat.format(start.getTime()) + " \u81f3 " + simpleDateFormat.format(end.getTime()));
                return;
            }
            cx cxVar3 = this.titleBinding;
            if (cxVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("titleBinding");
            } else {
                cxVar = cxVar3;
            }
            cxVar.f442829d.setText(simpleDateFormat.format(start.getTime()));
            return;
        }
        cx cxVar4 = this.titleBinding;
        if (cxVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleBinding");
        } else {
            cxVar = cxVar4;
        }
        cxVar.f442829d.setText("\u9009\u62e9\u65e5\u671f");
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        ba(rootView);
        initViewModel();
        aa();
    }
}
