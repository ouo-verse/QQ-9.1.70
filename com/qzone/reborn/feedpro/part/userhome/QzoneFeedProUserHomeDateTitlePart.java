package com.qzone.reborn.feedpro.part.userhome;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.feedpro.itemview.QzoneBaseFeedProItemView;
import com.qzone.reborn.feedpro.itemview.QzoneMemorySealFeedProItemView;
import com.qzone.reborn.feedpro.utils.aa;
import com.qzone.reborn.feedpro.widget.userhome.QzoneProCalendarIconView;
import com.qzone.reborn.feedx.util.QZoneFeedxViewUtils;
import com.qzone.reborn.feedx.util.ah;
import com.qzone.reborn.feedx.widget.QZoneLoadMoreUpView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellCommon;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeed;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.data.base.UIStateData;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 H2\u00020\u0001:\u0001IB\u0007\u00a2\u0006\u0004\bF\u0010GJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\u001a\u0010\f\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0012\u0010\u000f\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002J\u0019\u0010\u0012\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\u0015\u001a\u00020\u0002H\u0002J\u0010\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\bH\u0016J\u001a\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016R\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010\"\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\u001fR\u001b\u0010'\u001a\u00020\u001d8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u0018\u0010+\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010/\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0018\u00103\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0018\u00107\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0018\u0010;\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010=\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010\u001fR\u0018\u0010A\u001a\u0004\u0018\u00010>8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010E\u001a\u00020B8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010D\u00a8\u0006J"}, d2 = {"Lcom/qzone/reborn/feedpro/part/userhome/QzoneFeedProUserHomeDateTitlePart;", "Lcom/qzone/reborn/feedx/part/g;", "", "ba", "initViewModel", "Z9", "Y9", "ea", "Landroid/view/View;", "firstView", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "V9", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "feedData", "ga", "", "timeMillis", "ha", "(Ljava/lang/Long;)V", "W9", "U9", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "", "action", "", "args", "handleBroadcastMessage", "", "d", "I", "mDateLayoutHeight", "e", "mDateLayoutPaddingVertical", "f", "Lkotlin/Lazy;", "X9", "()I", "mTitleHeight", "Landroid/widget/TextView;", tl.h.F, "Landroid/widget/TextView;", "mDateText", "Landroid/view/ViewGroup;", "i", "Landroid/view/ViewGroup;", "mDateLayout", "Lcom/qzone/reborn/feedpro/widget/userhome/QzoneProCalendarIconView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/qzone/reborn/feedpro/widget/userhome/QzoneProCalendarIconView;", "mCalendarIcon", "Lcom/qzone/reborn/feedpro/viewmodel/m;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/qzone/reborn/feedpro/viewmodel/m;", "mUserHomeViewModel", "Lcom/qzone/reborn/feedpro/viewmodel/n;", "D", "Lcom/qzone/reborn/feedpro/viewmodel/n;", "mScrollViewModel", "E", "mFirstVisiblePosition", "Lcom/qzone/reborn/feedpro/itemview/QzoneBaseFeedProItemView;", UserInfo.SEX_FEMALE, "Lcom/qzone/reborn/feedpro/itemview/QzoneBaseFeedProItemView;", "mFirstFeedProItemView", "", "G", "Z", "mNeedRefreshFirstView", "<init>", "()V", "H", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QzoneFeedProUserHomeDateTitlePart extends com.qzone.reborn.feedx.part.g {

    /* renamed from: C, reason: from kotlin metadata */
    private com.qzone.reborn.feedpro.viewmodel.m mUserHomeViewModel;

    /* renamed from: D, reason: from kotlin metadata */
    private com.qzone.reborn.feedpro.viewmodel.n mScrollViewModel;

    /* renamed from: E, reason: from kotlin metadata */
    private int mFirstVisiblePosition;

    /* renamed from: F, reason: from kotlin metadata */
    private QzoneBaseFeedProItemView mFirstFeedProItemView;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean mNeedRefreshFirstView;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int mDateLayoutHeight = ef.d.b(48);

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int mDateLayoutPaddingVertical = ef.d.b(12);

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Lazy mTitleHeight;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private TextView mDateText;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private ViewGroup mDateLayout;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private QzoneProCalendarIconView mCalendarIcon;

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/qzone/reborn/feedpro/part/userhome/QzoneFeedProUserHomeDateTitlePart$b", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "dx", "dy", "", "onScrolled", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b extends RecyclerView.OnScrollListener {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int dx5, int dy5) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            int a16 = ah.a(recyclerView);
            if (QzoneFeedProUserHomeDateTitlePart.this.mNeedRefreshFirstView || QzoneFeedProUserHomeDateTitlePart.this.mFirstVisiblePosition != a16) {
                QzoneFeedProUserHomeDateTitlePart.this.mFirstVisiblePosition = a16;
                QzoneFeedProUserHomeDateTitlePart.this.mFirstFeedProItemView = null;
                QzoneFeedProUserHomeDateTitlePart.this.mNeedRefreshFirstView = false;
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                QzoneFeedProUserHomeDateTitlePart.this.V9(layoutManager != null ? layoutManager.findViewByPosition(a16) : null, recyclerView);
            }
            QzoneBaseFeedProItemView qzoneBaseFeedProItemView = QzoneFeedProUserHomeDateTitlePart.this.mFirstFeedProItemView;
            if (qzoneBaseFeedProItemView != null) {
                QzoneFeedProUserHomeDateTitlePart qzoneFeedProUserHomeDateTitlePart = QzoneFeedProUserHomeDateTitlePart.this;
                if (qzoneBaseFeedProItemView.getTop() >= ((qzoneFeedProUserHomeDateTitlePart.X9() + qzoneFeedProUserHomeDateTitlePart.mDateLayoutHeight) - ef.d.b(20)) + qzoneFeedProUserHomeDateTitlePart.mDateLayoutPaddingVertical) {
                    qzoneFeedProUserHomeDateTitlePart.Y9();
                } else {
                    qzoneFeedProUserHomeDateTitlePart.ga(qzoneBaseFeedProItemView.C);
                }
            }
        }
    }

    public QzoneFeedProUserHomeDateTitlePart() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.qzone.reborn.feedpro.part.userhome.QzoneFeedProUserHomeDateTitlePart$mTitleHeight$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Integer invoke() {
                return Integer.valueOf(QZoneFeedxViewUtils.e(QzoneFeedProUserHomeDateTitlePart.this.getActivity()));
            }
        });
        this.mTitleHeight = lazy;
    }

    private final void U9() {
        com.qzone.reborn.feedpro.viewmodel.n nVar = this.mScrollViewModel;
        if (nVar != null) {
            nVar.N1(new b());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void V9(View firstView, RecyclerView recyclerView) {
        if ((firstView instanceof QzoneMemorySealFeedProItemView) || (firstView instanceof QZoneLoadMoreUpView)) {
            return;
        }
        if (firstView instanceof QzoneBaseFeedProItemView) {
            ga(((QzoneBaseFeedProItemView) firstView).C);
        } else {
            W9(recyclerView);
        }
    }

    private final void W9(final RecyclerView recyclerView) {
        IntRange until;
        Sequence asSequence;
        Sequence map;
        Sequence filter;
        Sequence filterNot;
        Object firstOrNull;
        until = RangesKt___RangesKt.until(0, recyclerView.getChildCount());
        asSequence = CollectionsKt___CollectionsKt.asSequence(until);
        map = SequencesKt___SequencesKt.map(asSequence, new Function1<Integer, View>() { // from class: com.qzone.reborn.feedpro.part.userhome.QzoneFeedProUserHomeDateTitlePart$findFirstFeedItemView$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final View invoke(int i3) {
                return RecyclerView.this.getChildAt(i3);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ View invoke(Integer num) {
                return invoke(num.intValue());
            }
        });
        filter = SequencesKt___SequencesKt.filter(map, new Function1<Object, Boolean>() { // from class: com.qzone.reborn.feedpro.part.userhome.QzoneFeedProUserHomeDateTitlePart$findFirstFeedItemView$$inlined$filterIsInstance$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(Object obj) {
                return Boolean.valueOf(obj instanceof QzoneBaseFeedProItemView);
            }
        });
        Intrinsics.checkNotNull(filter, "null cannot be cast to non-null type kotlin.sequences.Sequence<R of kotlin.sequences.SequencesKt___SequencesKt.filterIsInstance>");
        filterNot = SequencesKt___SequencesKt.filterNot(filter, new Function1<QzoneBaseFeedProItemView, Boolean>() { // from class: com.qzone.reborn.feedpro.part.userhome.QzoneFeedProUserHomeDateTitlePart$findFirstFeedItemView$2
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(QzoneBaseFeedProItemView it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(it instanceof QzoneMemorySealFeedProItemView);
            }
        });
        firstOrNull = SequencesKt___SequencesKt.firstOrNull(filterNot);
        QzoneBaseFeedProItemView qzoneBaseFeedProItemView = (QzoneBaseFeedProItemView) firstOrNull;
        this.mFirstFeedProItemView = qzoneBaseFeedProItemView;
        int i3 = RFWLog.DEV;
        Object[] objArr = new Object[1];
        Class<?> cls = qzoneBaseFeedProItemView != null ? qzoneBaseFeedProItemView.getClass() : null;
        QzoneBaseFeedProItemView qzoneBaseFeedProItemView2 = this.mFirstFeedProItemView;
        objArr[0] = "[findFirstFeedItemView] firstFeedItemView is " + cls + ", cur top: " + (qzoneBaseFeedProItemView2 != null ? Integer.valueOf(qzoneBaseFeedProItemView2.getTop()) : null);
        RFWLog.d("QzoneFeedProUserHomeDateTitlePart", i3, objArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int X9() {
        return ((Number) this.mTitleHeight.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Y9() {
        ViewGroup viewGroup = this.mDateLayout;
        if (viewGroup == null) {
            return;
        }
        viewGroup.setVisibility(8);
    }

    private final void Z9() {
        QzoneProCalendarIconView qzoneProCalendarIconView = this.mCalendarIcon;
        if (qzoneProCalendarIconView != null) {
            qzoneProCalendarIconView.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.feedpro.part.userhome.m
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QzoneFeedProUserHomeDateTitlePart.aa(QzoneFeedProUserHomeDateTitlePart.this, view);
                }
            });
        }
        QzoneProCalendarIconView qzoneProCalendarIconView2 = this.mCalendarIcon;
        if (qzoneProCalendarIconView2 != null) {
            aa.m(aa.f54263a, qzoneProCalendarIconView2, 0.0f, 1, null);
        }
        AccessibilityUtil.p(this.mCalendarIcon, com.qzone.util.l.a(R.string.f2201768e));
        QzoneProCalendarIconView qzoneProCalendarIconView3 = this.mCalendarIcon;
        if (qzoneProCalendarIconView3 != null) {
            qzoneProCalendarIconView3.a(getActivity().getColor(R.color.qui_common_text_secondary));
        }
        QzoneProCalendarIconView qzoneProCalendarIconView4 = this.mCalendarIcon;
        if (qzoneProCalendarIconView4 != null) {
            fo.c.q(qzoneProCalendarIconView4, "em_qz_time_shaft", null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void aa(QzoneFeedProUserHomeDateTitlePart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.broadcastMessage("SHOW_TIME_LINE", null);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void ba() {
        ViewGroup.LayoutParams layoutParams;
        ViewGroup.LayoutParams layoutParams2;
        ViewGroup viewGroup = this.mDateLayout;
        if (viewGroup != null && (layoutParams2 = viewGroup.getLayoutParams()) != null) {
            Integer valueOf = Integer.valueOf(layoutParams2.height);
            if (!(valueOf.intValue() > 0)) {
                valueOf = null;
            }
            if (valueOf != null) {
                this.mDateLayoutHeight = valueOf.intValue();
            }
        }
        QzoneProCalendarIconView qzoneProCalendarIconView = this.mCalendarIcon;
        if (qzoneProCalendarIconView == null || (layoutParams = qzoneProCalendarIconView.getLayoutParams()) == null) {
            return;
        }
        Integer valueOf2 = Integer.valueOf(layoutParams.height);
        Integer num = valueOf2.intValue() > 0 ? valueOf2 : null;
        if (num != null) {
            this.mDateLayoutPaddingVertical = (this.mDateLayoutHeight - num.intValue()) / 2;
        }
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
    public final void ea() {
        ViewGroup viewGroup = this.mDateLayout;
        if (viewGroup == null || viewGroup.getVisibility() == 0) {
            return;
        }
        viewGroup.setVisibility(0);
        viewGroup.setTranslationY(-viewGroup.getHeight());
        viewGroup.animate().translationY(0.0f).setDuration(300L).start();
    }

    private final void initViewModel() {
        MutableLiveData<UIStateData<List<CommonFeed>>> N1;
        MutableLiveData<com.qzone.reborn.feedpro.viewmodel.b> O1;
        com.qzone.reborn.feedpro.viewmodel.m mVar = this.mUserHomeViewModel;
        if (mVar != null && (O1 = mVar.O1()) != null) {
            LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
            final Function1<com.qzone.reborn.feedpro.viewmodel.b, Unit> function1 = new Function1<com.qzone.reborn.feedpro.viewmodel.b, Unit>() { // from class: com.qzone.reborn.feedpro.part.userhome.QzoneFeedProUserHomeDateTitlePart$initViewModel$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(com.qzone.reborn.feedpro.viewmodel.b bVar) {
                    invoke2(bVar);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(com.qzone.reborn.feedpro.viewmodel.b bVar) {
                    ViewGroup viewGroup;
                    if (Intrinsics.areEqual(bVar, com.qzone.reborn.feedpro.viewmodel.b.INSTANCE.f())) {
                        viewGroup = QzoneFeedProUserHomeDateTitlePart.this.mDateLayout;
                        boolean z16 = false;
                        if (viewGroup != null && viewGroup.getVisibility() == 0) {
                            z16 = true;
                        }
                        if (z16) {
                            return;
                        }
                        QzoneFeedProUserHomeDateTitlePart.this.ea();
                    }
                }
            };
            O1.observe(lifecycleOwner, new Observer() { // from class: com.qzone.reborn.feedpro.part.userhome.n
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    QzoneFeedProUserHomeDateTitlePart.ca(Function1.this, obj);
                }
            });
        }
        com.qzone.reborn.feedpro.viewmodel.m mVar2 = this.mUserHomeViewModel;
        if (mVar2 == null || (N1 = mVar2.N1()) == null) {
            return;
        }
        LifecycleOwner lifecycleOwner2 = getPartHost().getLifecycleOwner();
        final Function1<UIStateData<List<? extends CommonFeed>>, Unit> function12 = new Function1<UIStateData<List<? extends CommonFeed>>, Unit>() { // from class: com.qzone.reborn.feedpro.part.userhome.QzoneFeedProUserHomeDateTitlePart$initViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(UIStateData<List<? extends CommonFeed>> uIStateData) {
                invoke2((UIStateData<List<CommonFeed>>) uIStateData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(UIStateData<List<CommonFeed>> uIStateData) {
                if (uIStateData != null) {
                    int state = uIStateData.getState();
                    if (state == 2 || state == 3) {
                        QzoneFeedProUserHomeDateTitlePart.this.mNeedRefreshFirstView = true;
                    }
                }
            }
        };
        N1.observe(lifecycleOwner2, new Observer() { // from class: com.qzone.reborn.feedpro.part.userhome.o
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QzoneFeedProUserHomeDateTitlePart.da(Function1.this, obj);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(String action, Object args) {
        Intrinsics.checkNotNullParameter(action, "action");
        if (Intrinsics.areEqual("on_time_line_click", action) && (args instanceof Long)) {
            ha((Long) args);
        }
    }

    @Override // com.qzone.reborn.feedx.part.g, com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        this.mUserHomeViewModel = (com.qzone.reborn.feedpro.viewmodel.m) getViewModel(com.qzone.reborn.feedpro.viewmodel.m.class);
        this.mScrollViewModel = (com.qzone.reborn.feedpro.viewmodel.n) getViewModel(com.qzone.reborn.feedpro.viewmodel.n.class);
        this.mDateLayout = (ViewGroup) rootView.findViewById(R.id.mjr);
        this.mDateText = (TextView) rootView.findViewById(R.id.mjs);
        this.mCalendarIcon = (QzoneProCalendarIconView) rootView.findViewById(R.id.mjq);
        ViewGroup viewGroup = this.mDateLayout;
        ViewGroup.LayoutParams layoutParams = viewGroup != null ? viewGroup.getLayoutParams() : null;
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = QZoneFeedxViewUtils.e(getActivity());
        }
        Z9();
        ba();
        U9();
        initViewModel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ga(CommonFeed feedData) {
        CommonCellCommon cellCommon;
        if (feedData == null || (cellCommon = feedData.getCellCommon()) == null) {
            return;
        }
        ha(Long.valueOf(cellCommon.getTime() * 1000));
        ea();
    }

    private final void ha(Long timeMillis) {
        if (timeMillis == null || timeMillis.longValue() <= 0) {
            return;
        }
        String format = new SimpleDateFormat("yyyy\u5e74MM\u6708", Locale.CHINESE).format(timeMillis);
        TextView textView = this.mDateText;
        if (textView != null) {
            textView.setText(format);
        }
        QzoneProCalendarIconView qzoneProCalendarIconView = this.mCalendarIcon;
        if (qzoneProCalendarIconView != null) {
            qzoneProCalendarIconView.m(timeMillis.longValue());
        }
        broadcastMessage("UPDATE_TIME_LINE_SELECTION", timeMillis);
    }
}
