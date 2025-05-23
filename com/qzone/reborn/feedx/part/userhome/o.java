package com.qzone.reborn.feedx.part.userhome;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellFeedCommInfo;
import com.qzone.reborn.feedx.itemview.QZoneBaseFeedItemView;
import com.qzone.reborn.feedx.itemview.memoryseal.QZoneMemorySealFeedItemView;
import com.qzone.reborn.feedx.util.QZoneFeedxViewUtils;
import com.qzone.reborn.feedx.util.ah;
import com.qzone.reborn.feedx.widget.QZoneLoadMoreUpView;
import com.qzone.reborn.feedx.widget.homepage.QZoneCalendarIconView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b-\u0010.J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\u0012\u0010\b\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0019\u0010\u000b\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\r\u001a\u00020\u0002H\u0002J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0006H\u0016J\u001a\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010$\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010(\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+\u00a8\u0006/"}, d2 = {"Lcom/qzone/reborn/feedx/part/userhome/o;", "Lcom/qzone/reborn/feedx/part/g;", "", "L9", "K9", "N9", "Landroid/view/View;", "firstView", "J9", "", "timeMillis", "O9", "(Ljava/lang/Long;)V", "I9", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "", "action", "", "args", "handleBroadcastMessage", "Landroid/widget/TextView;", "d", "Landroid/widget/TextView;", "mDateText", "Landroid/view/ViewGroup;", "e", "Landroid/view/ViewGroup;", "mDateLayout", "Lcom/qzone/reborn/feedx/widget/homepage/QZoneCalendarIconView;", "f", "Lcom/qzone/reborn/feedx/widget/homepage/QZoneCalendarIconView;", "mCalendarIcon", "Lcom/qzone/reborn/feedx/viewmodel/w;", tl.h.F, "Lcom/qzone/reborn/feedx/viewmodel/w;", "mUserHomeViewModel", "Lcom/qzone/reborn/feedx/viewmodel/r;", "i", "Lcom/qzone/reborn/feedx/viewmodel/r;", "mScrollViewModel", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "I", "mFirstVisiblePosition", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class o extends com.qzone.reborn.feedx.part.g {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private TextView mDateText;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ViewGroup mDateLayout;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private QZoneCalendarIconView mCalendarIcon;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private com.qzone.reborn.feedx.viewmodel.w mUserHomeViewModel;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private com.qzone.reborn.feedx.viewmodel.r mScrollViewModel;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int mFirstVisiblePosition;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/qzone/reborn/feedx/part/userhome/o$a", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "dx", "dy", "", "onScrolled", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class a extends RecyclerView.OnScrollListener {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int dx5, int dy5) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            int a16 = ah.a(recyclerView);
            if (o.this.mFirstVisiblePosition != a16) {
                o.this.mFirstVisiblePosition = a16;
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                o.this.J9(layoutManager != null ? layoutManager.findViewByPosition(a16) : null);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/qzone/reborn/feedx/part/userhome/o$b", "Lcom/qzone/reborn/feedx/viewmodel/s;", "", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "feedsData", "", "b", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b extends com.qzone.reborn.feedx.viewmodel.s {
        b() {
        }

        @Override // com.qzone.reborn.feedx.viewmodel.s
        public void b(List<? extends BusinessFeedData> feedsData) {
            Intrinsics.checkNotNullParameter(feedsData, "feedsData");
            o.this.N9();
        }
    }

    private final void I9() {
        com.qzone.reborn.feedx.viewmodel.r rVar = this.mScrollViewModel;
        if (rVar != null) {
            rVar.N1(new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J9(View firstView) {
        CellFeedCommInfo feedCommInfo;
        if ((firstView instanceof QZoneMemorySealFeedItemView) || (firstView instanceof QZoneLoadMoreUpView)) {
            return;
        }
        if (firstView instanceof QZoneBaseFeedItemView) {
            BusinessFeedData businessFeedData = ((QZoneBaseFeedItemView) firstView).C;
            Long valueOf = (businessFeedData == null || (feedCommInfo = businessFeedData.getFeedCommInfo()) == null) ? null : Long.valueOf(feedCommInfo.time);
            if (valueOf != null) {
                O9(Long.valueOf(valueOf.longValue()));
                N9();
                return;
            }
            return;
        }
        K9();
    }

    private final void K9() {
        ViewGroup viewGroup = this.mDateLayout;
        if (viewGroup == null) {
            return;
        }
        viewGroup.setVisibility(8);
    }

    private final void L9() {
        QZoneCalendarIconView qZoneCalendarIconView = this.mCalendarIcon;
        if (qZoneCalendarIconView != null) {
            qZoneCalendarIconView.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.feedx.part.userhome.n
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    o.M9(o.this, view);
                }
            });
        }
        AccessibilityUtil.p(this.mCalendarIcon, com.qzone.util.l.a(R.string.f2201768e));
        QZoneCalendarIconView qZoneCalendarIconView2 = this.mCalendarIcon;
        if (qZoneCalendarIconView2 != null) {
            qZoneCalendarIconView2.a(getActivity().getColor(R.color.qui_common_icon_nav_secondary));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M9(o this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.broadcastMessage("SHOW_TIME_LINE", null);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void N9() {
        ViewGroup viewGroup = this.mDateLayout;
        if (viewGroup == null || viewGroup.getVisibility() == 0) {
            return;
        }
        viewGroup.setVisibility(0);
        viewGroup.setTranslationY(-viewGroup.getHeight());
        viewGroup.animate().translationY(0.0f).setDuration(300L).start();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(String action, Object args) {
        Intrinsics.checkNotNullParameter(action, "action");
        if (Intrinsics.areEqual("on_time_line_click", action) && (args instanceof Long)) {
            O9((Long) args);
        }
    }

    @Override // com.qzone.reborn.feedx.part.g, com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        this.mUserHomeViewModel = (com.qzone.reborn.feedx.viewmodel.w) getViewModel(com.qzone.reborn.feedx.viewmodel.w.class);
        this.mScrollViewModel = (com.qzone.reborn.feedx.viewmodel.r) getViewModel(com.qzone.reborn.feedx.viewmodel.r.class);
        this.mDateLayout = (ViewGroup) rootView.findViewById(R.id.mjr);
        this.mDateText = (TextView) rootView.findViewById(R.id.mjs);
        this.mCalendarIcon = (QZoneCalendarIconView) rootView.findViewById(R.id.mjq);
        ViewGroup viewGroup = this.mDateLayout;
        ViewGroup.LayoutParams layoutParams = viewGroup != null ? viewGroup.getLayoutParams() : null;
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = QZoneFeedxViewUtils.e(getActivity());
        }
        L9();
        I9();
        com.qzone.reborn.feedx.viewmodel.w wVar = this.mUserHomeViewModel;
        if (wVar != null) {
            wVar.f3(new b());
        }
    }

    private final void O9(Long timeMillis) {
        if (timeMillis == null || timeMillis.longValue() <= 0) {
            return;
        }
        String format = new SimpleDateFormat("yyyy\u5e74MM\u6708", Locale.CHINESE).format(timeMillis);
        TextView textView = this.mDateText;
        if (textView != null) {
            textView.setText(format);
        }
        QZoneCalendarIconView qZoneCalendarIconView = this.mCalendarIcon;
        if (qZoneCalendarIconView != null) {
            qZoneCalendarIconView.m(timeMillis.longValue());
        }
        broadcastMessage("UPDATE_TIME_LINE_SELECTION", timeMillis);
    }
}
