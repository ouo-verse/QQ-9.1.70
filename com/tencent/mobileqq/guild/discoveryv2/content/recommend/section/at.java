package com.tencent.mobileqq.guild.discoveryv2.content.recommend.section;

import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.discoveryv2.content.view.DiscoveryV2RootView;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b(\u0010)J\b\u0010\u0004\u001a\u00020\u0003H\u0014J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0014J*\u0010\u000f\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0010\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\fH\u0014R\"\u0010\u0017\u001a\u00020\u00108\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u001f\u001a\u00020\u00188\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010'\u001a\u00020 8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/section/at;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/section/ar;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/j;", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "", "onInitView", "data", "", "position", "", "", "payload", "v", "Lcom/tencent/mobileqq/guild/discoveryv2/content/view/DiscoveryV2RootView;", "e", "Lcom/tencent/mobileqq/guild/discoveryv2/content/view/DiscoveryV2RootView;", "t", "()Lcom/tencent/mobileqq/guild/discoveryv2/content/view/DiscoveryV2RootView;", HippyTKDListViewAdapter.X, "(Lcom/tencent/mobileqq/guild/discoveryv2/content/view/DiscoveryV2RootView;)V", "itemView", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", ReportConstant.COSTREPORT_PREFIX, "()Landroid/widget/TextView;", "w", "(Landroid/widget/TextView;)V", "feedText", "Landroid/widget/LinearLayout;", tl.h.F, "Landroid/widget/LinearLayout;", "u", "()Landroid/widget/LinearLayout;", "y", "(Landroid/widget/LinearLayout;)V", "textContainer", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class at extends ar<com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.j> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public DiscoveryV2RootView itemView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public TextView feedText;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public LinearLayout textContainer;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        return new int[0];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@NotNull View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        x((DiscoveryV2RootView) containerView);
        DiscoveryV2RootView t16 = t();
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(t().getResources().getDimension(R.dimen.f158966ce1));
        gradientDrawable.setColor(t().getResources().getColorStateList(R.color.qui_common_fill_light_secondary));
        gradientDrawable.setStroke(com.tencent.guild.aio.util.c.b(1), t().getResources().getColorStateList(R.color.qui_common_border_light));
        t16.setBackground(gradientDrawable);
        View findViewById = containerView.findViewById(R.id.w7a);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewBy\u2026ry_v2_textfeed_container)");
        y((LinearLayout) findViewById);
        View findViewById2 = containerView.findViewById(R.id.w5s);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "containerView.findViewBy\u2026d_discovery_v2_feed_text)");
        w((TextView) findViewById2);
        containerView.findViewById(R.id.w5t).setVisibility(8);
    }

    @NotNull
    public final TextView s() {
        TextView textView = this.feedText;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("feedText");
        return null;
    }

    @NotNull
    public final DiscoveryV2RootView t() {
        DiscoveryV2RootView discoveryV2RootView = this.itemView;
        if (discoveryV2RootView != null) {
            return discoveryV2RootView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("itemView");
        return null;
    }

    @NotNull
    public final LinearLayout u() {
        LinearLayout linearLayout = this.textContainer;
        if (linearLayout != null) {
            return linearLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("textContainer");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:15:0x009f  */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onBindData(@NotNull com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.j data, int position, @Nullable List<? extends Object> payload) {
        int coerceIn;
        Object m476constructorimpl;
        float f16;
        Intrinsics.checkNotNullParameter(data, "data");
        LinearLayout u16 = u();
        ViewGroup.LayoutParams layoutParams = u16.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = q().b();
            u16.setLayoutParams(layoutParams);
            if (this.mPosition == 0) {
                u().measure(View.MeasureSpec.makeMeasureSpec(q().b(), 1073741824), View.MeasureSpec.makeMeasureSpec(q().h(), Integer.MIN_VALUE));
                coerceIn = RangesKt___RangesKt.coerceIn(u().getMeasuredHeight(), Math.min(data.getMinH(), q().a()), q().h());
                int measuredWidth = u().getMeasuredWidth();
                try {
                    Result.Companion companion = Result.INSTANCE;
                } catch (Throwable th5) {
                    Result.Companion companion2 = Result.INSTANCE;
                    m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
                }
                if (measuredWidth != 0 && coerceIn != 0) {
                    f16 = coerceIn / measuredWidth;
                    m476constructorimpl = Result.m476constructorimpl(Float.valueOf(f16));
                    Float valueOf = Float.valueOf(1.0f);
                    if (Result.m482isFailureimpl(m476constructorimpl)) {
                        m476constructorimpl = valueOf;
                    }
                    data.setMediaRatio(((Number) m476constructorimpl).floatValue());
                }
                f16 = 1.0f;
                m476constructorimpl = Result.m476constructorimpl(Float.valueOf(f16));
                Float valueOf2 = Float.valueOf(1.0f);
                if (Result.m482isFailureimpl(m476constructorimpl)) {
                }
                data.setMediaRatio(((Number) m476constructorimpl).floatValue());
            }
            LinearLayout u17 = u();
            ViewGroup.LayoutParams layoutParams2 = u17.getLayoutParams();
            if (layoutParams2 != null) {
                int b16 = q().b();
                layoutParams2.width = b16;
                layoutParams2.height = (int) (b16 * data.getMediaRatio());
                u17.setLayoutParams(layoutParams2);
                t().setRadius(0.0f);
                s().setGravity(16);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    public final void w(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.feedText = textView;
    }

    public final void x(@NotNull DiscoveryV2RootView discoveryV2RootView) {
        Intrinsics.checkNotNullParameter(discoveryV2RootView, "<set-?>");
        this.itemView = discoveryV2RootView;
    }

    public final void y(@NotNull LinearLayout linearLayout) {
        Intrinsics.checkNotNullParameter(linearLayout, "<set-?>");
        this.textContainer = linearLayout;
    }
}
