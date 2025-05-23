package com.tencent.mobileqq.guild.discoveryv2.content.recommend.section;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.discoveryv2.content.view.DiscoveryV2RootView;
import com.tencent.mobileqq.guild.widget.RadiusFrameLayout;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b$\u0010%J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\n\u001a\u00020\tH\u0014J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0014J(\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010H\u0014R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\"\u0010#\u001a\u00020\u001c8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/section/o;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/section/ar;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/j;", "data", "", HippyTKDListViewAdapter.X, "v", "params", "w", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "onInitView", "", "position", "", "", "payload", "t", "Lcom/tencent/mobileqq/guild/widget/RadiusFrameLayout;", "e", "Lcom/tencent/mobileqq/guild/widget/RadiusFrameLayout;", "mediaLayout", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "feedText", "Lcom/tencent/mobileqq/guild/discoveryv2/content/view/DiscoveryV2RootView;", tl.h.F, "Lcom/tencent/mobileqq/guild/discoveryv2/content/view/DiscoveryV2RootView;", ReportConstant.COSTREPORT_PREFIX, "()Lcom/tencent/mobileqq/guild/discoveryv2/content/view/DiscoveryV2RootView;", "u", "(Lcom/tencent/mobileqq/guild/discoveryv2/content/view/DiscoveryV2RootView;)V", "itemView", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class o extends ar<com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.j> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RadiusFrameLayout mediaLayout;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView feedText;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public DiscoveryV2RootView itemView;

    private final void v(com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.j data) {
        RadiusFrameLayout radiusFrameLayout = this.mediaLayout;
        if (radiusFrameLayout == null) {
            return;
        }
        radiusFrameLayout.setCornerRadius(data.getMediaLayoutRoundCorner());
        ViewGroup.LayoutParams layoutParams = radiusFrameLayout.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = q().b();
            layoutParams.height = (int) (q().b() * data.getMediaRatio());
            radiusFrameLayout.setLayoutParams(layoutParams);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    private final void w(com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.j params) {
        if (!params.getRootBg()) {
            s().setBackground(null);
            s().setRadius(0.0f);
        }
    }

    private final void x(com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.j data) {
        int coerceIn;
        TextView textView = this.feedText;
        if (textView == null) {
            return;
        }
        boolean z16 = false;
        if (data.getMediaLayoutRoundCorner().length >= 4) {
            textView.setPadding(data.getTextPadding()[0], data.getTextPadding()[1], data.getTextPadding()[2], data.getTextPadding()[3]);
        }
        ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = q().b();
            textView.setLayoutParams(layoutParams);
            if (this.mPosition == 0) {
                coerceIn = RangesKt___RangesKt.coerceIn(ci1.a.a(textView, q().b()), 1, 2);
                data.setMaxLines(coerceIn);
            }
            if (data.getMaxLines() == 1) {
                z16 = true;
            }
            textView.setSingleLine(z16);
            textView.setMaxLines(data.getMaxLines());
            textView.setEllipsize(TextUtils.TruncateAt.END);
            textView.setTypeface(data.getTypeface());
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

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
        u((DiscoveryV2RootView) containerView);
        this.mediaLayout = (RadiusFrameLayout) containerView.findViewById(R.id.w5o);
        this.feedText = (TextView) containerView.findViewById(R.id.w5s);
    }

    @NotNull
    public final DiscoveryV2RootView s() {
        DiscoveryV2RootView discoveryV2RootView = this.itemView;
        if (discoveryV2RootView != null) {
            return discoveryV2RootView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("itemView");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public void onBindData(@NotNull com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.j data, int position, @Nullable List<Object> payload) {
        Intrinsics.checkNotNullParameter(data, "data");
        v(data);
        x(data);
        w(data);
    }

    public final void u(@NotNull DiscoveryV2RootView discoveryV2RootView) {
        Intrinsics.checkNotNullParameter(discoveryV2RootView, "<set-?>");
        this.itemView = discoveryV2RootView;
    }
}
