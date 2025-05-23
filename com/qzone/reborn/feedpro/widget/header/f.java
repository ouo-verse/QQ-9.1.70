package com.qzone.reborn.feedpro.widget.header;

import android.animation.ValueAnimator;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.reborn.feedx.util.QZoneFeedxViewUtils;
import com.qzone.reborn.feedx.widget.QZoneLinearGradientView;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010+\u001a\u00020\u0004\u00a2\u0006\u0004\b,\u0010-J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\u0002H\u0016J\u0012\u0010\u0010\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010\u0011\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u0018\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012H\u0016J\b\u0010\u0017\u001a\u00020\u0002H\u0016J\b\u0010\u0018\u001a\u00020\u0002H\u0016R\u0017\u0010\u001e\u001a\u00020\u00198\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010#\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0016\u0010&\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010(\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010%R\u0016\u0010*\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010%\u00a8\u0006."}, d2 = {"Lcom/qzone/reborn/feedpro/widget/header/f;", "Lcom/qzone/reborn/feedpro/widget/header/d;", "", "p", "Landroid/view/View;", "view", "", "height", DomainData.DOMAIN_NAME, ReportConstant.COSTREPORT_PREFIX, "Lcom/qzone/reborn/feedx/widget/QZoneLinearGradientView;", "gradientView", "r", "onInit", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "holder", "N", "g0", "", "offSet", "sumOffSet", "", "c", "M", "onPostThemeChanged", "Landroid/view/ViewGroup;", "f", "Landroid/view/ViewGroup;", "o", "()Landroid/view/ViewGroup;", "mCoverLayout", tl.h.F, "Landroid/view/View;", "getTitleGuideLine", "()Landroid/view/View;", "titleGuideLine", "i", "I", "mCoverMinHeight", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mCoverMaxHeight", BdhLogUtil.LogTag.Tag_Conn, "titleHeight", "containerView", "<init>", "(Landroid/view/View;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public class f extends d {

    /* renamed from: C, reason: from kotlin metadata */
    private int titleHeight;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final ViewGroup mCoverLayout;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final View titleGuideLine;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int mCoverMinHeight;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int mCoverMaxHeight;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(View containerView) {
        super(containerView);
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        View findViewById = containerView.findViewById(R.id.mzu);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewBy\u2026_feedx_header_cover_view)");
        this.mCoverLayout = (ViewGroup) findViewById;
        View findViewById2 = containerView.findViewById(R.id.mwh);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "containerView.findViewBy\u2026o_header_title_guideline)");
        this.titleGuideLine = findViewById2;
    }

    private final void n(View view, int height) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = height;
            view.setLayoutParams(layoutParams);
        }
    }

    private final void p() {
        com.qzone.reborn.feedpro.utils.l lVar = com.qzone.reborn.feedpro.utils.l.f54345a;
        int b16 = lVar.b();
        this.mCoverMaxHeight = lVar.c() + b16;
        this.mCoverMinHeight = b16;
        n(this.mCoverLayout, b16);
        int e16 = QZoneFeedxViewUtils.e(i());
        this.titleHeight = e16;
        if (b16 <= e16) {
            return;
        }
        View view = this.titleGuideLine;
        int i3 = b16 - e16;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams == null) {
            ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
            int i16 = layoutParams2 != null ? layoutParams2.width : -2;
            ViewGroup.LayoutParams layoutParams3 = view.getLayoutParams();
            marginLayoutParams = new ViewGroup.MarginLayoutParams(i16, layoutParams3 != null ? layoutParams3.height : -2);
        }
        if (i3 != marginLayoutParams.bottomMargin) {
            marginLayoutParams.bottomMargin = i3;
            view.setLayoutParams(marginLayoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(f this$0, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ViewGroup viewGroup = this$0.mCoverLayout;
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        this$0.n(viewGroup, ((Integer) animatedValue).intValue());
    }

    private final void r(QZoneLinearGradientView gradientView) {
        int color = ResourcesCompat.getColor(gradientView.getResources(), R.color.qui_common_bg_bottom_light, null);
        GuildUIUtils guildUIUtils = GuildUIUtils.f235378a;
        gradientView.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, this.mCoverMinHeight - this.titleHeight, new int[]{guildUIUtils.E(color, 0.0f), guildUIUtils.E(color, 0.01f), guildUIUtils.E(color, 0.03f), guildUIUtils.E(color, 0.07f), guildUIUtils.E(color, 0.12f), guildUIUtils.E(color, 0.18f), guildUIUtils.E(color, 0.25f), guildUIUtils.E(color, 0.33f), guildUIUtils.E(color, 0.41f), guildUIUtils.E(color, 0.5f), guildUIUtils.E(color, 0.59f), guildUIUtils.E(color, 0.67f), guildUIUtils.E(color, 0.76f), guildUIUtils.E(color, 0.85f), guildUIUtils.E(color, 0.93f), guildUIUtils.E(color, 1.0f)}, (float[]) null, Shader.TileMode.CLAMP));
    }

    private final void s() {
        QZoneLinearGradientView qZoneLinearGradientView = (QZoneLinearGradientView) h().findViewById(R.id.myz);
        if (qZoneLinearGradientView != null) {
            r(qZoneLinearGradientView);
        }
    }

    @Override // com.qzone.reborn.feedpro.widget.header.d, com.qzone.reborn.feedpro.widget.header.c
    public void N(RecyclerView.ViewHolder holder) {
        RFWLog.d(k(), RFWLog.USR, "onAttachToWindow");
    }

    @Override // com.qzone.reborn.feedpro.widget.header.d, com.qzone.reborn.feedpro.widget.header.c
    public void g0(RecyclerView.ViewHolder holder) {
        RFWLog.d(k(), RFWLog.USR, "onDetachToWindow");
    }

    /* renamed from: o, reason: from getter */
    public final ViewGroup getMCoverLayout() {
        return this.mCoverLayout;
    }

    @Override // com.qzone.reborn.feedpro.widget.header.c
    public void onInit() {
        p();
        s();
    }

    @Override // com.qzone.reborn.feedpro.widget.header.d, com.qzone.reborn.feedpro.widget.header.c
    public void onPostThemeChanged() {
        s();
    }

    @Override // com.qzone.reborn.feedpro.widget.header.d, com.qzone.reborn.feedpro.widget.header.c
    public void M() {
        ValueAnimator ofInt = ValueAnimator.ofInt(this.mCoverLayout.getLayoutParams().height, this.mCoverMinHeight);
        ofInt.setDuration(200L).start();
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.qzone.reborn.feedpro.widget.header.e
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                f.q(f.this, valueAnimator);
            }
        });
        ofInt.start();
    }

    @Override // com.qzone.reborn.feedpro.widget.header.d, com.qzone.reborn.feedpro.widget.header.c
    public boolean c(float offSet, float sumOffSet) {
        if (offSet > 0.0f && this.mCoverLayout.getLayoutParams().height < this.mCoverMaxHeight) {
            n(this.mCoverLayout, (int) (r4.getLayoutParams().height + offSet));
            return false;
        }
        if (offSet >= 0.0f || this.mCoverLayout.getBottom() <= this.mCoverMinHeight) {
            return false;
        }
        n(this.mCoverLayout, (int) (r4.getLayoutParams().height + offSet));
        return false;
    }
}
