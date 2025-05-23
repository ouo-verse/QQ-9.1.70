package com.tencent.now.linkpkanchorplay.mainpage.view;

import an3.a;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.heytap.databaseengine.apiv3.data.Element;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqlive.utils.c;
import com.tencent.now.linkpkanchorplay.event.UIEvent;
import com.tencent.now.linkpkanchorplay.event.b;
import com.tencent.now.linkpkanchorplay.invite.model.AnchorTabPageContext;
import com.tencent.now.linkpkanchorplay.mainpage.view.AnchorRankPKActivityHeadView;
import com.tencent.now.linkpkanchorplay.mainpage.view.anchortab.AnchorInfoTabView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import g55.f;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010*\u001a\u00020)\u00a2\u0006\u0004\b+\u0010,B\u001b\b\u0016\u0012\u0006\u0010*\u001a\u00020)\u0012\b\u0010.\u001a\u0004\u0018\u00010-\u00a2\u0006\u0004\b+\u0010/B#\b\u0016\u0012\u0006\u0010*\u001a\u00020)\u0012\b\u0010.\u001a\u0004\u0018\u00010-\u0012\u0006\u00100\u001a\u00020\u0010\u00a2\u0006\u0004\b+\u00101J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010 \u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\u001dR\u0016\u0010$\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010\u001dR\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'\u00a8\u00062"}, d2 = {"Lcom/tencent/now/linkpkanchorplay/mainpage/view/AnchorRankPKActivityHeadView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/tencent/now/linkpkanchorplay/event/UIEvent$PKType;", "pkType", "", "F0", "Lg55/f;", "anchorPKTab", "G0", "Lcom/tencent/now/linkpkanchorplay/invite/model/a;", "pageContext", "setPageContext", "Lcom/tencent/now/linkpkanchorplay/event/b;", "eventTrigger", "setEventTrigger", "setAnchorPKTabInfo", "", Element.ELEMENT_NAME_TIMES, "setRemainInviteTimes", "Lcom/tencent/now/linkpkanchorplay/mainpage/view/anchortab/AnchorInfoTabView;", "d", "Lcom/tencent/now/linkpkanchorplay/mainpage/view/anchortab/AnchorInfoTabView;", "anchorInfoTabView", "e", "Lcom/tencent/now/linkpkanchorplay/event/b;", "f", "Lcom/tencent/now/linkpkanchorplay/invite/model/a;", "Landroid/widget/TextView;", h.F, "Landroid/widget/TextView;", "linkScreenMatchBtn", "i", "matchTag", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "linkNormalMatchBtn", BdhLogUtil.LogTag.Tag_Conn, "remainInviteTimesView", "Landroid/widget/ImageView;", "D", "Landroid/widget/ImageView;", "rankPKHistoryBtn", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class AnchorRankPKActivityHeadView extends ConstraintLayout {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private TextView remainInviteTimesView;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private ImageView rankPKHistoryBtn;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private AnchorInfoTabView anchorInfoTabView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private b eventTrigger;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private AnchorTabPageContext pageContext;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private TextView linkScreenMatchBtn;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private TextView matchTag;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private TextView linkNormalMatchBtn;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnchorRankPKActivityHeadView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        View.inflate(getContext(), R.layout.ff7, this);
        View findViewById = findViewById(R.id.snx);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.anchor_detail_rank_info)");
        AnchorInfoTabView anchorInfoTabView = (AnchorInfoTabView) findViewById;
        this.anchorInfoTabView = anchorInfoTabView;
        a.Companion companion = a.INSTANCE;
        c.b(anchorInfoTabView, companion.a());
        View findViewById2 = findViewById(R.id.yj6);
        TextView textView = (TextView) findViewById2;
        textView.setOnClickListener(new View.OnClickListener() { // from class: qm3.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AnchorRankPKActivityHeadView.D0(AnchorRankPKActivityHeadView.this, view);
            }
        });
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById<TextView>(R\u2026)\n            }\n        }");
        this.linkScreenMatchBtn = textView;
        View findViewById3 = findViewById(R.id.zsa);
        TextView textView2 = (TextView) findViewById3;
        textView2.setOnClickListener(new View.OnClickListener() { // from class: qm3.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AnchorRankPKActivityHeadView.E0(AnchorRankPKActivityHeadView.this, view);
            }
        });
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById<TextView>(R\u2026)\n            }\n        }");
        this.linkNormalMatchBtn = textView2;
        View findViewById4 = findViewById(R.id.f72713rl);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById<TextView>(R.id.remain_invite_times)");
        this.remainInviteTimesView = (TextView) findViewById4;
        View findViewById5 = findViewById(R.id.yy6);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.match_tag)");
        TextView textView3 = (TextView) findViewById5;
        this.matchTag = textView3;
        c.b(textView3, companion.i());
        View findViewById6 = findViewById(R.id.f25400aq);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById<ImageView>(R.id.pk_history_btn)");
        ImageView imageView = (ImageView) findViewById6;
        this.rankPKHistoryBtn = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: qm3.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AnchorRankPKActivityHeadView.C0(AnchorRankPKActivityHeadView.this, view);
            }
        });
        com.tencent.report.a aVar = com.tencent.report.a.f364907a;
        com.tencent.report.a.e(aVar, this.rankPKHistoryBtn, true, null, "em_qqlive_pwpk_history", null, 16, null);
        com.tencent.report.a.e(aVar, this.linkNormalMatchBtn, true, null, "em_qqlive_pwpk_start_pk", null, 16, null);
        com.tencent.report.a.e(aVar, this.linkScreenMatchBtn, true, null, "em_qqlive_pwpk_start_lppk", null, 16, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C0(AnchorRankPKActivityHeadView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        b bVar = this$0.eventTrigger;
        AnchorTabPageContext anchorTabPageContext = null;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("eventTrigger");
            bVar = null;
        }
        AnchorTabPageContext anchorTabPageContext2 = this$0.pageContext;
        if (anchorTabPageContext2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageContext");
        } else {
            anchorTabPageContext = anchorTabPageContext2;
        }
        bVar.t1(new UIEvent.ShowSecondaryPageEvent(4, new AnchorTabPageContext(0, anchorTabPageContext.getRoomInfo())));
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D0(AnchorRankPKActivityHeadView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.F0(UIEvent.PKType.Rank_Link_PK);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E0(AnchorRankPKActivityHeadView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.F0(UIEvent.PKType.Rank_Normal_PK);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void F0(UIEvent.PKType pkType) {
        b bVar = this.eventTrigger;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("eventTrigger");
            bVar = null;
        }
        bVar.t1(new UIEvent.ShowPKRandomMatchPanel(pkType));
    }

    private final void G0(f anchorPKTab) {
        throw null;
    }

    public final void setAnchorPKTabInfo(@NotNull f anchorPKTab) {
        Intrinsics.checkNotNullParameter(anchorPKTab, "anchorPKTab");
        this.anchorInfoTabView.G0(anchorPKTab);
        G0(anchorPKTab);
    }

    public final void setEventTrigger(@NotNull b eventTrigger) {
        Intrinsics.checkNotNullParameter(eventTrigger, "eventTrigger");
        this.eventTrigger = eventTrigger;
    }

    public final void setPageContext(@NotNull AnchorTabPageContext pageContext) {
        Intrinsics.checkNotNullParameter(pageContext, "pageContext");
        this.pageContext = pageContext;
    }

    public final void setRemainInviteTimes(int times) {
        this.remainInviteTimesView.setText(getContext().getString(R.string.f23223740, String.valueOf(times)));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnchorRankPKActivityHeadView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        View.inflate(getContext(), R.layout.ff7, this);
        View findViewById = findViewById(R.id.snx);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.anchor_detail_rank_info)");
        AnchorInfoTabView anchorInfoTabView = (AnchorInfoTabView) findViewById;
        this.anchorInfoTabView = anchorInfoTabView;
        a.Companion companion = a.INSTANCE;
        c.b(anchorInfoTabView, companion.a());
        View findViewById2 = findViewById(R.id.yj6);
        TextView textView = (TextView) findViewById2;
        textView.setOnClickListener(new View.OnClickListener() { // from class: qm3.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AnchorRankPKActivityHeadView.D0(AnchorRankPKActivityHeadView.this, view);
            }
        });
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById<TextView>(R\u2026)\n            }\n        }");
        this.linkScreenMatchBtn = textView;
        View findViewById3 = findViewById(R.id.zsa);
        TextView textView2 = (TextView) findViewById3;
        textView2.setOnClickListener(new View.OnClickListener() { // from class: qm3.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AnchorRankPKActivityHeadView.E0(AnchorRankPKActivityHeadView.this, view);
            }
        });
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById<TextView>(R\u2026)\n            }\n        }");
        this.linkNormalMatchBtn = textView2;
        View findViewById4 = findViewById(R.id.f72713rl);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById<TextView>(R.id.remain_invite_times)");
        this.remainInviteTimesView = (TextView) findViewById4;
        View findViewById5 = findViewById(R.id.yy6);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.match_tag)");
        TextView textView3 = (TextView) findViewById5;
        this.matchTag = textView3;
        c.b(textView3, companion.i());
        View findViewById6 = findViewById(R.id.f25400aq);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById<ImageView>(R.id.pk_history_btn)");
        ImageView imageView = (ImageView) findViewById6;
        this.rankPKHistoryBtn = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: qm3.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AnchorRankPKActivityHeadView.C0(AnchorRankPKActivityHeadView.this, view);
            }
        });
        com.tencent.report.a aVar = com.tencent.report.a.f364907a;
        com.tencent.report.a.e(aVar, this.rankPKHistoryBtn, true, null, "em_qqlive_pwpk_history", null, 16, null);
        com.tencent.report.a.e(aVar, this.linkNormalMatchBtn, true, null, "em_qqlive_pwpk_start_pk", null, 16, null);
        com.tencent.report.a.e(aVar, this.linkScreenMatchBtn, true, null, "em_qqlive_pwpk_start_lppk", null, 16, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnchorRankPKActivityHeadView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        View.inflate(getContext(), R.layout.ff7, this);
        View findViewById = findViewById(R.id.snx);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.anchor_detail_rank_info)");
        AnchorInfoTabView anchorInfoTabView = (AnchorInfoTabView) findViewById;
        this.anchorInfoTabView = anchorInfoTabView;
        a.Companion companion = a.INSTANCE;
        c.b(anchorInfoTabView, companion.a());
        View findViewById2 = findViewById(R.id.yj6);
        TextView textView = (TextView) findViewById2;
        textView.setOnClickListener(new View.OnClickListener() { // from class: qm3.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AnchorRankPKActivityHeadView.D0(AnchorRankPKActivityHeadView.this, view);
            }
        });
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById<TextView>(R\u2026)\n            }\n        }");
        this.linkScreenMatchBtn = textView;
        View findViewById3 = findViewById(R.id.zsa);
        TextView textView2 = (TextView) findViewById3;
        textView2.setOnClickListener(new View.OnClickListener() { // from class: qm3.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AnchorRankPKActivityHeadView.E0(AnchorRankPKActivityHeadView.this, view);
            }
        });
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById<TextView>(R\u2026)\n            }\n        }");
        this.linkNormalMatchBtn = textView2;
        View findViewById4 = findViewById(R.id.f72713rl);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById<TextView>(R.id.remain_invite_times)");
        this.remainInviteTimesView = (TextView) findViewById4;
        View findViewById5 = findViewById(R.id.yy6);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.match_tag)");
        TextView textView3 = (TextView) findViewById5;
        this.matchTag = textView3;
        c.b(textView3, companion.i());
        View findViewById6 = findViewById(R.id.f25400aq);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById<ImageView>(R.id.pk_history_btn)");
        ImageView imageView = (ImageView) findViewById6;
        this.rankPKHistoryBtn = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: qm3.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AnchorRankPKActivityHeadView.C0(AnchorRankPKActivityHeadView.this, view);
            }
        });
        com.tencent.report.a aVar = com.tencent.report.a.f364907a;
        com.tencent.report.a.e(aVar, this.rankPKHistoryBtn, true, null, "em_qqlive_pwpk_history", null, 16, null);
        com.tencent.report.a.e(aVar, this.linkNormalMatchBtn, true, null, "em_qqlive_pwpk_start_pk", null, 16, null);
        com.tencent.report.a.e(aVar, this.linkScreenMatchBtn, true, null, "em_qqlive_pwpk_start_lppk", null, 16, null);
    }
}
