package com.tencent.now.linkpkanchorplay.mainpage.view.anchortab;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.ilive.widget.circleimageview.CircleImageView;
import com.tencent.misc.utils.b;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.now.linkpkanchorplay.mainpage.view.anchortab.AnchorInfoTabView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.report.a;
import g55.f;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u00100\u001a\u00020/\u00a2\u0006\u0004\b1\u00102B\u001b\b\u0016\u0012\u0006\u00100\u001a\u00020/\u0012\b\u00104\u001a\u0004\u0018\u000103\u00a2\u0006\u0004\b1\u00105B#\b\u0016\u0012\u0006\u00100\u001a\u00020/\u0012\b\u00104\u001a\u0004\u0018\u000103\u0012\u0006\u00107\u001a\u000206\u00a2\u0006\u0004\b1\u00108J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0016\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0013R\u0016\u0010\u001a\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0013R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010$\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010!R\u0016\u0010&\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010!R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-\u00a8\u00069"}, d2 = {"Lcom/tencent/now/linkpkanchorplay/mainpage/view/anchortab/AnchorInfoTabView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lg55/f;", "anchorPKTab", "", "D0", "F0", "E0", "G0", "Lcom/tencent/ilive/widget/circleimageview/CircleImageView;", "d", "Lcom/tencent/ilive/widget/circleimageview/CircleImageView;", "anchorAvatar", "Lcom/tencent/now/linkpkanchorplay/mainpage/view/anchortab/ColorTextView;", "e", "Lcom/tencent/now/linkpkanchorplay/mainpage/view/anchortab/ColorTextView;", "anchorRankGradeLevel", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "anchorNick", h.F, "upgradeValue", "i", "upgradeLabelPrefix", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "upgradeLabelSuffix", "Lcom/tencent/now/linkpkanchorplay/mainpage/view/anchortab/AnchorRankGameProgressView;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/now/linkpkanchorplay/mainpage/view/anchortab/AnchorRankGameProgressView;", "rankGameProgressView", "Lcom/tencent/now/linkpkanchorplay/mainpage/view/anchortab/LabelTextView;", "D", "Lcom/tencent/now/linkpkanchorplay/mainpage/view/anchortab/LabelTextView;", "rankLabelTextView", "E", "winNumLabelTextView", UserInfo.SEX_FEMALE, "winRateLabelTextView", "Lcom/tencent/now/linkpkanchorplay/mainpage/view/anchortab/AnchorTabContributeView;", "G", "Lcom/tencent/now/linkpkanchorplay/mainpage/view/anchortab/AnchorTabContributeView;", "anchorTabContributeView", "Landroid/view/View;", "H", "Landroid/view/View;", "anchorTabContributeClickView", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class AnchorInfoTabView extends ConstraintLayout {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private AnchorRankGameProgressView rankGameProgressView;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private LabelTextView rankLabelTextView;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private LabelTextView winNumLabelTextView;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private LabelTextView winRateLabelTextView;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private AnchorTabContributeView anchorTabContributeView;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private View anchorTabContributeClickView;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private CircleImageView anchorAvatar;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ColorTextView anchorRankGradeLevel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private TextView anchorNick;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private TextView upgradeValue;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private TextView upgradeLabelPrefix;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private TextView upgradeLabelSuffix;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnchorInfoTabView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        View.inflate(getContext(), R.layout.f167645dx4, this);
        View findViewById = findViewById(R.id.snp);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById<CircleImageView>(R.id.anchor_avatar)");
        this.anchorAvatar = (CircleImageView) findViewById;
        View findViewById2 = findViewById(R.id.f70213ku);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById<ColorTextView>(R.id.rank_grade_level)");
        this.anchorRankGradeLevel = (ColorTextView) findViewById2;
        View findViewById3 = findViewById(R.id.sor);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById<TextView>(R.id.anchor_nick)");
        this.anchorNick = (TextView) findViewById3;
        View findViewById4 = findViewById(R.id.f114626tu);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById<TextView>(R.id.upgrade_value)");
        this.upgradeValue = (TextView) findViewById4;
        View findViewById5 = findViewById(R.id.f114596tr);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.upgrade_label_1)");
        this.upgradeLabelPrefix = (TextView) findViewById5;
        View findViewById6 = findViewById(R.id.f114606ts);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.upgrade_label_2)");
        this.upgradeLabelSuffix = (TextView) findViewById6;
        View findViewById7 = findViewById(R.id.f70233kw);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById<AnchorRankG\u2026ew>(R.id.rank_grade_view)");
        this.rankGameProgressView = (AnchorRankGameProgressView) findViewById7;
        View findViewById8 = findViewById(R.id.f70123kl);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById<LabelTextView>(R.id.rank)");
        this.rankLabelTextView = (LabelTextView) findViewById8;
        View findViewById9 = findViewById(R.id.f122367dr);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "findViewById<LabelTextView>(R.id.win_num)");
        this.winNumLabelTextView = (LabelTextView) findViewById9;
        View findViewById10 = findViewById(R.id.f122377ds);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "findViewById<LabelTextView>(R.id.win_rate)");
        this.winRateLabelTextView = (LabelTextView) findViewById10;
        View findViewById11 = findViewById(R.id.u8u);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "findViewById<AnchorTabCo\u2026ew>(R.id.contribute_view)");
        this.anchorTabContributeView = (AnchorTabContributeView) findViewById11;
        View findViewById12 = findViewById(R.id.u8s);
        Intrinsics.checkNotNullExpressionValue(findViewById12, "findViewById(R.id.contribute_click_view)");
        this.anchorTabContributeClickView = findViewById12;
        b.b(this.upgradeValue);
        this.rankLabelTextView.setOnClickListener(new View.OnClickListener() { // from class: rm3.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AnchorInfoTabView.B0(AnchorInfoTabView.this, view);
            }
        });
        this.anchorTabContributeClickView.setOnClickListener(new View.OnClickListener() { // from class: rm3.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AnchorInfoTabView.C0(AnchorInfoTabView.this, view);
            }
        });
        a aVar = a.f364907a;
        a.e(aVar, this.rankLabelTextView, true, null, "em_qqlive_pwpk_rank", null, 16, null);
        a.e(aVar, this.anchorTabContributeClickView, true, null, "em_qqlive_pwpk_contribution_list", null, 16, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B0(AnchorInfoTabView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getClass();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C0(AnchorInfoTabView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getClass();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void D0(f anchorPKTab) {
        throw null;
    }

    private final void E0(f anchorPKTab) {
        this.anchorTabContributeView.setData(anchorPKTab);
    }

    private final void F0(f anchorPKTab) {
        throw null;
    }

    public final void G0(@NotNull f anchorPKTab) {
        Intrinsics.checkNotNullParameter(anchorPKTab, "anchorPKTab");
        D0(anchorPKTab);
        F0(anchorPKTab);
        E0(anchorPKTab);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnchorInfoTabView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        View.inflate(getContext(), R.layout.f167645dx4, this);
        View findViewById = findViewById(R.id.snp);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById<CircleImageView>(R.id.anchor_avatar)");
        this.anchorAvatar = (CircleImageView) findViewById;
        View findViewById2 = findViewById(R.id.f70213ku);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById<ColorTextView>(R.id.rank_grade_level)");
        this.anchorRankGradeLevel = (ColorTextView) findViewById2;
        View findViewById3 = findViewById(R.id.sor);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById<TextView>(R.id.anchor_nick)");
        this.anchorNick = (TextView) findViewById3;
        View findViewById4 = findViewById(R.id.f114626tu);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById<TextView>(R.id.upgrade_value)");
        this.upgradeValue = (TextView) findViewById4;
        View findViewById5 = findViewById(R.id.f114596tr);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.upgrade_label_1)");
        this.upgradeLabelPrefix = (TextView) findViewById5;
        View findViewById6 = findViewById(R.id.f114606ts);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.upgrade_label_2)");
        this.upgradeLabelSuffix = (TextView) findViewById6;
        View findViewById7 = findViewById(R.id.f70233kw);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById<AnchorRankG\u2026ew>(R.id.rank_grade_view)");
        this.rankGameProgressView = (AnchorRankGameProgressView) findViewById7;
        View findViewById8 = findViewById(R.id.f70123kl);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById<LabelTextView>(R.id.rank)");
        this.rankLabelTextView = (LabelTextView) findViewById8;
        View findViewById9 = findViewById(R.id.f122367dr);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "findViewById<LabelTextView>(R.id.win_num)");
        this.winNumLabelTextView = (LabelTextView) findViewById9;
        View findViewById10 = findViewById(R.id.f122377ds);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "findViewById<LabelTextView>(R.id.win_rate)");
        this.winRateLabelTextView = (LabelTextView) findViewById10;
        View findViewById11 = findViewById(R.id.u8u);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "findViewById<AnchorTabCo\u2026ew>(R.id.contribute_view)");
        this.anchorTabContributeView = (AnchorTabContributeView) findViewById11;
        View findViewById12 = findViewById(R.id.u8s);
        Intrinsics.checkNotNullExpressionValue(findViewById12, "findViewById(R.id.contribute_click_view)");
        this.anchorTabContributeClickView = findViewById12;
        b.b(this.upgradeValue);
        this.rankLabelTextView.setOnClickListener(new View.OnClickListener() { // from class: rm3.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AnchorInfoTabView.B0(AnchorInfoTabView.this, view);
            }
        });
        this.anchorTabContributeClickView.setOnClickListener(new View.OnClickListener() { // from class: rm3.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AnchorInfoTabView.C0(AnchorInfoTabView.this, view);
            }
        });
        a aVar = a.f364907a;
        a.e(aVar, this.rankLabelTextView, true, null, "em_qqlive_pwpk_rank", null, 16, null);
        a.e(aVar, this.anchorTabContributeClickView, true, null, "em_qqlive_pwpk_contribution_list", null, 16, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnchorInfoTabView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        View.inflate(getContext(), R.layout.f167645dx4, this);
        View findViewById = findViewById(R.id.snp);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById<CircleImageView>(R.id.anchor_avatar)");
        this.anchorAvatar = (CircleImageView) findViewById;
        View findViewById2 = findViewById(R.id.f70213ku);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById<ColorTextView>(R.id.rank_grade_level)");
        this.anchorRankGradeLevel = (ColorTextView) findViewById2;
        View findViewById3 = findViewById(R.id.sor);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById<TextView>(R.id.anchor_nick)");
        this.anchorNick = (TextView) findViewById3;
        View findViewById4 = findViewById(R.id.f114626tu);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById<TextView>(R.id.upgrade_value)");
        this.upgradeValue = (TextView) findViewById4;
        View findViewById5 = findViewById(R.id.f114596tr);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.upgrade_label_1)");
        this.upgradeLabelPrefix = (TextView) findViewById5;
        View findViewById6 = findViewById(R.id.f114606ts);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.upgrade_label_2)");
        this.upgradeLabelSuffix = (TextView) findViewById6;
        View findViewById7 = findViewById(R.id.f70233kw);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById<AnchorRankG\u2026ew>(R.id.rank_grade_view)");
        this.rankGameProgressView = (AnchorRankGameProgressView) findViewById7;
        View findViewById8 = findViewById(R.id.f70123kl);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById<LabelTextView>(R.id.rank)");
        this.rankLabelTextView = (LabelTextView) findViewById8;
        View findViewById9 = findViewById(R.id.f122367dr);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "findViewById<LabelTextView>(R.id.win_num)");
        this.winNumLabelTextView = (LabelTextView) findViewById9;
        View findViewById10 = findViewById(R.id.f122377ds);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "findViewById<LabelTextView>(R.id.win_rate)");
        this.winRateLabelTextView = (LabelTextView) findViewById10;
        View findViewById11 = findViewById(R.id.u8u);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "findViewById<AnchorTabCo\u2026ew>(R.id.contribute_view)");
        this.anchorTabContributeView = (AnchorTabContributeView) findViewById11;
        View findViewById12 = findViewById(R.id.u8s);
        Intrinsics.checkNotNullExpressionValue(findViewById12, "findViewById(R.id.contribute_click_view)");
        this.anchorTabContributeClickView = findViewById12;
        b.b(this.upgradeValue);
        this.rankLabelTextView.setOnClickListener(new View.OnClickListener() { // from class: rm3.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AnchorInfoTabView.B0(AnchorInfoTabView.this, view);
            }
        });
        this.anchorTabContributeClickView.setOnClickListener(new View.OnClickListener() { // from class: rm3.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AnchorInfoTabView.C0(AnchorInfoTabView.this, view);
            }
        });
        a aVar = a.f364907a;
        a.e(aVar, this.rankLabelTextView, true, null, "em_qqlive_pwpk_rank", null, 16, null);
        a.e(aVar, this.anchorTabContributeClickView, true, null, "em_qqlive_pwpk_contribution_list", null, 16, null);
    }
}
