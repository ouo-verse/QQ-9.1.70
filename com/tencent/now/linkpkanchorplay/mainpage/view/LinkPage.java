package com.tencent.now.linkpkanchorplay.mainpage.view;

import android.content.Context;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.now.linkpkanchorplay.event.b;
import com.tencent.now.linkpkanchorplay.invite.model.AnchorTabPageContext;
import com.tencent.now.linkpkanchorplay.mainpage.model.a;
import com.tencent.now.linkpkanchorplay.recommendlist.widget.RecommendAnchorListView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000  2\u00020\u0001:\u0001!B/\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006\""}, d2 = {"Lcom/tencent/now/linkpkanchorplay/mainpage/view/LinkPage;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", "context", "", "z0", "Lcom/tencent/now/linkpkanchorplay/event/b;", "d", "Lcom/tencent/now/linkpkanchorplay/event/b;", "eventTrigger", "Landroidx/lifecycle/LifecycleOwner;", "e", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Lcom/tencent/now/linkpkanchorplay/invite/model/a;", "f", "Lcom/tencent/now/linkpkanchorplay/invite/model/a;", "pageContext", "Lcom/tencent/now/linkpkanchorplay/mainpage/model/a;", h.F, "Lcom/tencent/now/linkpkanchorplay/mainpage/model/a;", "anchorSelectInviteInfoModel", "Lcom/tencent/now/linkpkanchorplay/mainpage/view/LinkAndPkInviteHeadView;", "i", "Lcom/tencent/now/linkpkanchorplay/mainpage/view/LinkAndPkInviteHeadView;", "linkAndPkInviteHeadView", "Lcom/tencent/now/linkpkanchorplay/recommendlist/widget/RecommendAnchorListView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/now/linkpkanchorplay/recommendlist/widget/RecommendAnchorListView;", "recommendAnchorListView", "<init>", "(Lcom/tencent/now/linkpkanchorplay/event/b;Landroid/content/Context;Landroidx/lifecycle/LifecycleOwner;Lcom/tencent/now/linkpkanchorplay/invite/model/a;Lcom/tencent/now/linkpkanchorplay/mainpage/model/a;)V", BdhLogUtil.LogTag.Tag_Conn, "a", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class LinkPage extends ConstraintLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b eventTrigger;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LifecycleOwner lifecycleOwner;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AnchorTabPageContext pageContext;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a anchorSelectInviteInfoModel;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private LinkAndPkInviteHeadView linkAndPkInviteHeadView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private RecommendAnchorListView recommendAnchorListView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LinkPage(@NotNull b eventTrigger, @NotNull Context context, @NotNull LifecycleOwner lifecycleOwner, @NotNull AnchorTabPageContext pageContext, @NotNull a anchorSelectInviteInfoModel) {
        super(context);
        Intrinsics.checkNotNullParameter(eventTrigger, "eventTrigger");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(pageContext, "pageContext");
        Intrinsics.checkNotNullParameter(anchorSelectInviteInfoModel, "anchorSelectInviteInfoModel");
        this.eventTrigger = eventTrigger;
        this.lifecycleOwner = lifecycleOwner;
        this.pageContext = pageContext;
        this.anchorSelectInviteInfoModel = anchorSelectInviteInfoModel;
        z0(context);
    }

    private final void z0(Context context) {
        View.inflate(context, R.layout.fec, this);
        LinkAndPkInviteHeadView linkAndPkInviteHeadView = new LinkAndPkInviteHeadView(this.eventTrigger, context, this.lifecycleOwner, this.pageContext, this.anchorSelectInviteInfoModel);
        linkAndPkInviteHeadView.setInviteBizType(1);
        this.linkAndPkInviteHeadView = linkAndPkInviteHeadView;
        View findViewById = findViewById(R.id.f71173nf);
        RecommendAnchorListView recommendAnchorListView = (RecommendAnchorListView) findViewById;
        LinkAndPkInviteHeadView linkAndPkInviteHeadView2 = this.linkAndPkInviteHeadView;
        if (linkAndPkInviteHeadView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("linkAndPkInviteHeadView");
            linkAndPkInviteHeadView2 = null;
        }
        recommendAnchorListView.d(linkAndPkInviteHeadView2);
        recommendAnchorListView.f();
        recommendAnchorListView.setEmptyView(R.layout.few);
        recommendAnchorListView.setRecommendInviteType(1);
        recommendAnchorListView.setSource(0);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById<RecommendAn\u2026MMEND_LIST)\n            }");
        this.recommendAnchorListView = recommendAnchorListView;
        com.tencent.report.a.b(com.tencent.report.a.f364907a, this, true, "qqlive_lppk_anchor", "em_qqlive_lppk_anchor", null, 16, null);
    }
}
