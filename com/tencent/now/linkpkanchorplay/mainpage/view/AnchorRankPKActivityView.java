package com.tencent.now.linkpkanchorplay.mainpage.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.heytap.databaseengine.apiv3.data.Element;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.now.linkpkanchorplay.event.b;
import com.tencent.now.linkpkanchorplay.invite.model.AnchorTabPageContext;
import com.tencent.now.linkpkanchorplay.recommendlist.widget.RecommendAnchorListView;
import g55.f;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u00a2\u0006\u0004\b\u001d\u0010\u001eB\u001b\b\u0016\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\b\u0010 \u001a\u0004\u0018\u00010\u001f\u00a2\u0006\u0004\b\u001d\u0010!B#\b\u0016\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\b\u0010 \u001a\u0004\u0018\u00010\u001f\u0012\u0006\u0010\"\u001a\u00020\f\u00a2\u0006\u0004\b\u001d\u0010#J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006$"}, d2 = {"Lcom/tencent/now/linkpkanchorplay/mainpage/view/AnchorRankPKActivityView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/tencent/now/linkpkanchorplay/invite/model/a;", "pageContext", "", "setPageContext", "Lcom/tencent/now/linkpkanchorplay/event/b;", "eventTrigger", "setEventTrigger", "Lg55/f;", "anchorPKTab", "setAnchorPKTabInfo", "", Element.ELEMENT_NAME_TIMES, "setRemainInviteTimes", "Lcom/tencent/now/linkpkanchorplay/recommendlist/widget/RecommendAnchorListView;", "d", "Lcom/tencent/now/linkpkanchorplay/recommendlist/widget/RecommendAnchorListView;", "recommendAnchorListView", "Lcom/tencent/now/linkpkanchorplay/mainpage/view/AnchorRankPKActivityHeadView;", "e", "Lcom/tencent/now/linkpkanchorplay/mainpage/view/AnchorRankPKActivityHeadView;", "rankHeadView", "f", "Lcom/tencent/now/linkpkanchorplay/event/b;", h.F, "Lcom/tencent/now/linkpkanchorplay/invite/model/a;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class AnchorRankPKActivityView extends ConstraintLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private RecommendAnchorListView recommendAnchorListView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private AnchorRankPKActivityHeadView rankHeadView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private b eventTrigger;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private AnchorTabPageContext pageContext;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnchorRankPKActivityView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        View.inflate(getContext(), R.layout.ff8, this);
        View findViewById = findViewById(R.id.f71173nf);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(com.tencent\u2026id.recommend_anchor_View)");
        this.recommendAnchorListView = (RecommendAnchorListView) findViewById;
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        AnchorRankPKActivityHeadView anchorRankPKActivityHeadView = new AnchorRankPKActivityHeadView(context2);
        this.rankHeadView = anchorRankPKActivityHeadView;
        this.recommendAnchorListView.d(anchorRankPKActivityHeadView);
        this.recommendAnchorListView.f();
        this.recommendAnchorListView.setRecommendInviteType(5);
        this.recommendAnchorListView.setSource(4);
        this.recommendAnchorListView.setEmptyView(R.layout.fev);
    }

    public final void setAnchorPKTabInfo(@NotNull f anchorPKTab) {
        Intrinsics.checkNotNullParameter(anchorPKTab, "anchorPKTab");
        this.rankHeadView.setAnchorPKTabInfo(anchorPKTab);
    }

    public final void setEventTrigger(@NotNull b eventTrigger) {
        Intrinsics.checkNotNullParameter(eventTrigger, "eventTrigger");
        this.eventTrigger = eventTrigger;
        this.rankHeadView.setEventTrigger(eventTrigger);
    }

    public final void setPageContext(@NotNull AnchorTabPageContext pageContext) {
        Intrinsics.checkNotNullParameter(pageContext, "pageContext");
        this.pageContext = pageContext;
        this.rankHeadView.setPageContext(pageContext);
    }

    public final void setRemainInviteTimes(int times) {
        this.rankHeadView.setRemainInviteTimes(times);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnchorRankPKActivityView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        View.inflate(getContext(), R.layout.ff8, this);
        View findViewById = findViewById(R.id.f71173nf);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(com.tencent\u2026id.recommend_anchor_View)");
        this.recommendAnchorListView = (RecommendAnchorListView) findViewById;
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        AnchorRankPKActivityHeadView anchorRankPKActivityHeadView = new AnchorRankPKActivityHeadView(context2);
        this.rankHeadView = anchorRankPKActivityHeadView;
        this.recommendAnchorListView.d(anchorRankPKActivityHeadView);
        this.recommendAnchorListView.f();
        this.recommendAnchorListView.setRecommendInviteType(5);
        this.recommendAnchorListView.setSource(4);
        this.recommendAnchorListView.setEmptyView(R.layout.fev);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnchorRankPKActivityView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        View.inflate(getContext(), R.layout.ff8, this);
        View findViewById = findViewById(R.id.f71173nf);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(com.tencent\u2026id.recommend_anchor_View)");
        this.recommendAnchorListView = (RecommendAnchorListView) findViewById;
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        AnchorRankPKActivityHeadView anchorRankPKActivityHeadView = new AnchorRankPKActivityHeadView(context2);
        this.rankHeadView = anchorRankPKActivityHeadView;
        this.recommendAnchorListView.d(anchorRankPKActivityHeadView);
        this.recommendAnchorListView.f();
        this.recommendAnchorListView.setRecommendInviteType(5);
        this.recommendAnchorListView.setSource(4);
        this.recommendAnchorListView.setEmptyView(R.layout.fev);
    }
}
