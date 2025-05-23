package com.tencent.now.linkpkanchorplay.rankpkhistory.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.component.appx.utils.AppUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.now.app.common.widget.NewPagerSlidingTabStrip;
import com.tencent.now.linkpkanchorplay.base.WrapContentHeightViewPager;
import com.tencent.now.linkpkanchorplay.invite.model.AnchorTabPageContext;
import com.tencent.now.linkpkanchorplay.rankpkhistory.view.RankPKHistoryTitleTabData;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u00012B-\b\u0007\u0012\u0006\u0010-\u001a\u00020,\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\u0006\u0010\u0019\u001a\u00020\u0014\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010.\u00a2\u0006\u0004\b0\u00101J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0016\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bR\u0017\u0010\u0013\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0019\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+\u00a8\u00063"}, d2 = {"Lcom/tencent/now/linkpkanchorplay/rankpkhistory/view/RankPKHistoryTabView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "Lcom/tencent/now/linkpkanchorplay/rankpkhistory/view/RankPKHistoryTitleTabData;", "B0", "Lcom/tencent/now/linkpkanchorplay/event/b;", "eventTrigger", "Lcom/tencent/now/linkpkanchorplay/invite/model/a;", "pageContext", "", "C0", "Lcom/tencent/now/linkpkanchorplay/rankpkhistory/view/RankPKHistoryTabView$a;", "backCallback", "setBackCallback", "Landroidx/lifecycle/ViewModelStoreOwner;", "d", "Landroidx/lifecycle/ViewModelStoreOwner;", "getViewModelStoreOwner", "()Landroidx/lifecycle/ViewModelStoreOwner;", "viewModelStoreOwner", "Landroidx/lifecycle/LifecycleOwner;", "e", "Landroidx/lifecycle/LifecycleOwner;", "getLifeCycleOwner", "()Landroidx/lifecycle/LifecycleOwner;", "lifeCycleOwner", "Landroid/view/View;", "f", "Landroid/view/View;", "backViewArea", "Lcom/tencent/now/app/common/widget/NewPagerSlidingTabStrip;", h.F, "Lcom/tencent/now/app/common/widget/NewPagerSlidingTabStrip;", "titleTabStrip", "Lcom/tencent/now/linkpkanchorplay/base/WrapContentHeightViewPager;", "i", "Lcom/tencent/now/linkpkanchorplay/base/WrapContentHeightViewPager;", "viewPager", "Lcom/tencent/now/linkpkanchorplay/rankpkhistory/view/c;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/now/linkpkanchorplay/rankpkhistory/view/c;", "rankPKHistoryTabViewAdapter", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/now/linkpkanchorplay/rankpkhistory/view/RankPKHistoryTabView$a;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroidx/lifecycle/ViewModelStoreOwner;Landroidx/lifecycle/LifecycleOwner;Landroid/util/AttributeSet;)V", "a", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class RankPKHistoryTabView extends ConstraintLayout {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private a backCallback;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ViewModelStoreOwner viewModelStoreOwner;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LifecycleOwner lifeCycleOwner;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private View backViewArea;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private NewPagerSlidingTabStrip titleTabStrip;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private WrapContentHeightViewPager viewPager;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private c rankPKHistoryTabViewAdapter;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/now/linkpkanchorplay/rankpkhistory/view/RankPKHistoryTabView$a;", "", "", "onBack", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public interface a {
        void onBack();
    }

    public /* synthetic */ RankPKHistoryTabView(Context context, ViewModelStoreOwner viewModelStoreOwner, LifecycleOwner lifecycleOwner, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, viewModelStoreOwner, lifecycleOwner, (i3 & 8) != 0 ? null : attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A0(RankPKHistoryTabView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        a aVar = this$0.backCallback;
        if (aVar != null) {
            aVar.onBack();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final List<RankPKHistoryTitleTabData> B0() {
        RankPKHistoryTitleTabData.TabId tabId = RankPKHistoryTitleTabData.TabId.LINK_SCREEN_MATCH;
        String string = getContext().getString(R.string.f16236208);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.string.link_screen_qualifying)");
        RankPKHistoryTitleTabData rankPKHistoryTitleTabData = new RankPKHistoryTitleTabData(tabId, string, true, 2);
        RankPKHistoryTitleTabData.TabId tabId2 = RankPKHistoryTitleTabData.TabId.COMMON_MATCH;
        String string2 = getContext().getString(R.string.f171052mp);
        Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.string.normal_qualifying)");
        RankPKHistoryTitleTabData rankPKHistoryTitleTabData2 = new RankPKHistoryTitleTabData(tabId2, string2, false, 1);
        ArrayList arrayList = new ArrayList();
        arrayList.add(rankPKHistoryTitleTabData);
        arrayList.add(rankPKHistoryTitleTabData2);
        return arrayList;
    }

    public final void C0(@NotNull com.tencent.now.linkpkanchorplay.event.b eventTrigger, @NotNull AnchorTabPageContext pageContext) {
        Intrinsics.checkNotNullParameter(eventTrigger, "eventTrigger");
        Intrinsics.checkNotNullParameter(pageContext, "pageContext");
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        c cVar = new c(context, eventTrigger, pageContext, this.viewModelStoreOwner, this.lifeCycleOwner, new ArrayList());
        this.rankPKHistoryTabViewAdapter = cVar;
        this.viewPager.setAdapter(cVar);
        this.titleTabStrip.setViewPager(this.viewPager);
        c cVar2 = this.rankPKHistoryTabViewAdapter;
        if (cVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rankPKHistoryTabViewAdapter");
            cVar2 = null;
        }
        cVar2.e(this.viewPager, B0());
        this.titleTabStrip.l();
    }

    public final void setBackCallback(@NotNull a backCallback) {
        Intrinsics.checkNotNullParameter(backCallback, "backCallback");
        this.backCallback = backCallback;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RankPKHistoryTabView(@NotNull Context context, @NotNull ViewModelStoreOwner viewModelStoreOwner, @NotNull LifecycleOwner lifeCycleOwner, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(viewModelStoreOwner, "viewModelStoreOwner");
        Intrinsics.checkNotNullParameter(lifeCycleOwner, "lifeCycleOwner");
        this.viewModelStoreOwner = viewModelStoreOwner;
        this.lifeCycleOwner = lifeCycleOwner;
        View.inflate(context, R.layout.hmk, this);
        View findViewById = findViewById(R.id.f70403lc);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.rank_pk_history_back_area)");
        this.backViewArea = findViewById;
        View findViewById2 = findViewById(R.id.f70423le);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById<NewPagerSli\u2026_history_title_tab_strip)");
        this.titleTabStrip = (NewPagerSlidingTabStrip) findViewById2;
        View findViewById3 = findViewById(R.id.f70433lf);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.rank_pk_history_view_pager)");
        this.viewPager = (WrapContentHeightViewPager) findViewById3;
        NewPagerSlidingTabStrip newPagerSlidingTabStrip = this.titleTabStrip;
        newPagerSlidingTabStrip.setTextColor(-1);
        newPagerSlidingTabStrip.setTextSize(AppUtils.UI.dip2px(14.0f));
        newPagerSlidingTabStrip.setIndictorBottomMargin(0);
        newPagerSlidingTabStrip.setUnSelectedTextColor(2063597567);
        this.backViewArea.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.now.linkpkanchorplay.rankpkhistory.view.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RankPKHistoryTabView.A0(RankPKHistoryTabView.this, view);
            }
        });
    }
}
