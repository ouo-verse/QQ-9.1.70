package com.tencent.now.linkpkanchorplay.mainpage.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwner;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.now.linkpkanchorplay.event.UIEvent;
import com.tencent.now.linkpkanchorplay.event.b;
import com.tencent.now.linkpkanchorplay.invite.model.AnchorTabPageContext;
import com.tencent.now.linkpkanchorplay.mainpage.model.a;
import com.tencent.now.linkpkanchorplay.mainpage.view.LinkAndPkInviteHeadView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import fn3.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 22\u00020\u0001:\u00013B/\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u00a2\u0006\u0004\b0\u00101J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010%\u001a\u00020\u001c8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010\u001eR\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010/\u001a\u00020\u001c8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b.\u0010\u001e\u00a8\u00064"}, d2 = {"Lcom/tencent/now/linkpkanchorplay/mainpage/view/LinkAndPkInviteHeadView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", "context", "", "G0", "C0", "E0", "", "type", "I0", "setInviteBizType", "Lcom/tencent/now/linkpkanchorplay/event/b;", "d", "Lcom/tencent/now/linkpkanchorplay/event/b;", "eventTrigger", "Landroidx/lifecycle/LifecycleOwner;", "e", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Lcom/tencent/now/linkpkanchorplay/invite/model/a;", "f", "Lcom/tencent/now/linkpkanchorplay/invite/model/a;", "pageContext", "Lcom/tencent/now/linkpkanchorplay/mainpage/model/a;", h.F, "Lcom/tencent/now/linkpkanchorplay/mainpage/model/a;", "anchorSelectInviteInfoModel", "Landroid/widget/TextView;", "i", "Landroid/widget/TextView;", "searchBtn", "Landroid/view/ViewGroup;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/view/ViewGroup;", "randomMatchClickableLayout", BdhLogUtil.LogTag.Tag_Conn, "randomMatchBtn", "Landroid/widget/LinearLayout;", "D", "Landroid/widget/LinearLayout;", "randomMatchWholeLayout", "Landroid/widget/ImageView;", "E", "Landroid/widget/ImageView;", "pkHistoryBtn", UserInfo.SEX_FEMALE, "recommendTipsView", "<init>", "(Lcom/tencent/now/linkpkanchorplay/event/b;Landroid/content/Context;Landroidx/lifecycle/LifecycleOwner;Lcom/tencent/now/linkpkanchorplay/invite/model/a;Lcom/tencent/now/linkpkanchorplay/mainpage/model/a;)V", "G", "a", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class LinkAndPkInviteHeadView extends ConstraintLayout {

    /* renamed from: C, reason: from kotlin metadata */
    private TextView randomMatchBtn;

    /* renamed from: D, reason: from kotlin metadata */
    private LinearLayout randomMatchWholeLayout;

    /* renamed from: E, reason: from kotlin metadata */
    private ImageView pkHistoryBtn;

    /* renamed from: F, reason: from kotlin metadata */
    private TextView recommendTipsView;

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
    private TextView searchBtn;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private ViewGroup randomMatchClickableLayout;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LinkAndPkInviteHeadView(@NotNull b eventTrigger, @NotNull Context context, @NotNull LifecycleOwner lifecycleOwner, @NotNull AnchorTabPageContext pageContext, @NotNull a anchorSelectInviteInfoModel) {
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
        G0(context);
    }

    private final void C0() {
        View findViewById = findViewById(R.id.f25420as);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById<TextView>(R.id.pk_random_match_btn)");
        this.randomMatchBtn = (TextView) findViewById;
        View findViewById2 = findViewById(R.id.f70103kj);
        ((LinearLayout) findViewById2).setOnClickListener(new View.OnClickListener() { // from class: qm3.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LinkAndPkInviteHeadView.D0(LinkAndPkInviteHeadView.this, view);
            }
        });
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById<LinearLayou\u2026          }\n            }");
        ViewGroup viewGroup = (ViewGroup) findViewById2;
        this.randomMatchClickableLayout = viewGroup;
        com.tencent.report.a aVar = com.tencent.report.a.f364907a;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("randomMatchClickableLayout");
            viewGroup = null;
        }
        com.tencent.report.a.e(aVar, viewGroup, true, null, "em_qqlive_lppk_start_pk", null, 16, null);
        View findViewById3 = findViewById(R.id.f70113kk);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById<LinearLayou\u2026R.id.random_match_layout)");
        this.randomMatchWholeLayout = (LinearLayout) findViewById3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D0(LinkAndPkInviteHeadView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.eventTrigger.t1(new UIEvent.ShowPKRandomMatchPanel(UIEvent.PKType.LinkPK));
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void E0() {
        View findViewById = findViewById(R.id.f80664c3);
        TextView textView = (TextView) findViewById;
        textView.setOnClickListener(new View.OnClickListener() { // from class: qm3.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LinkAndPkInviteHeadView.F0(LinkAndPkInviteHeadView.this, view);
            }
        });
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById<TextView>(R\u2026)\n            }\n        }");
        this.searchBtn = textView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F0(LinkAndPkInviteHeadView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.I0(1);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void G0(Context context) {
        ImageView imageView;
        View.inflate(context, R.layout.feb, this);
        C0();
        E0();
        View findViewById = findViewById(R.id.f25400aq);
        ImageView imageView2 = (ImageView) findViewById;
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: qm3.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LinkAndPkInviteHeadView.H0(LinkAndPkInviteHeadView.this, view);
            }
        });
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById<ImageView>(\u2026\n\n            }\n        }");
        this.pkHistoryBtn = imageView2;
        View findViewById2 = findViewById(R.id.f71313nt);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById<TextView>(R\u2026d.recommend_introduction)");
        this.recommendTipsView = (TextView) findViewById2;
        com.tencent.report.a aVar = com.tencent.report.a.f364907a;
        ImageView imageView3 = this.pkHistoryBtn;
        TextView textView = null;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pkHistoryBtn");
            imageView = null;
        } else {
            imageView = imageView3;
        }
        com.tencent.report.a.e(aVar, imageView, true, null, "em_qqlive_lppk_history", null, 16, null);
        TextView textView2 = this.randomMatchBtn;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("randomMatchBtn");
        } else {
            textView = textView2;
        }
        com.tencent.misc.utils.b.b(textView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H0(LinkAndPkInviteHeadView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.I0(2);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void I0(int type) {
        this.eventTrigger.t1(new UIEvent.ShowSecondaryPageEvent(type, new AnchorTabPageContext(this.anchorSelectInviteInfoModel.getSelectInviteBizType(), this.pageContext.getRoomInfo())));
    }

    public final void setInviteBizType(int type) {
        String str;
        TextView textView;
        if (type != 1) {
            if (type == 3) {
                LinearLayout linearLayout = this.randomMatchWholeLayout;
                if (linearLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("randomMatchWholeLayout");
                    linearLayout = null;
                }
                linearLayout.setVisibility(0);
                TextView textView2 = this.recommendTipsView;
                if (textView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recommendTipsView");
                    textView2 = null;
                }
                textView2.setVisibility(0);
            }
        } else {
            LinearLayout linearLayout2 = this.randomMatchWholeLayout;
            if (linearLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("randomMatchWholeLayout");
                linearLayout2 = null;
            }
            linearLayout2.setVisibility(8);
            TextView textView3 = this.recommendTipsView;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recommendTipsView");
                textView3 = null;
            }
            textView3.setVisibility(8);
        }
        this.anchorSelectInviteInfoModel.b(type);
        TextView textView4 = this.searchBtn;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchBtn");
            textView4 = null;
        }
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        textView4.setText(c.h(context, type));
        LinearLayout linearLayout3 = this.randomMatchWholeLayout;
        if (linearLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("randomMatchWholeLayout");
            linearLayout3 = null;
        }
        if (linearLayout3.getVisibility() == 8) {
            str = "em_qqlive_lp_search";
        } else {
            str = "em_qqlive_lppk_search";
        }
        String str2 = str;
        com.tencent.report.a aVar = com.tencent.report.a.f364907a;
        TextView textView5 = this.searchBtn;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchBtn");
            textView = null;
        } else {
            textView = textView5;
        }
        com.tencent.report.a.e(aVar, textView, true, null, str2, null, 16, null);
    }
}
