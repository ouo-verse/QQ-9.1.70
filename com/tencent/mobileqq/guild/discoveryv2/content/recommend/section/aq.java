package com.tencent.mobileqq.guild.discoveryv2.content.recommend.section;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.guild.aio.util.ex.ViewExtKt;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.RecommendSchemeData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001b2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u001cB\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0005\u001a\u00020\u0004H\u0014J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0014J(\u0010\u0010\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rH\u0014J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0006H\u0016J\u0010\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0006H\u0016R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/section/aq;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/section/ar;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/RecommendSchemeData;", "Lcom/tencent/guild/aio/util/ex/c;", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "", "onInitView", "data", "", "position", "", "", "payload", ReportConstant.COSTREPORT_PREFIX, "v", "", NodeProps.ON_LONG_CLICK, NodeProps.ON_CLICK, "Landroid/widget/ImageView;", "e", "Landroid/widget/ImageView;", "mPic", "<init>", "()V", "f", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class aq extends ar<RecommendSchemeData> implements com.tencent.guild.aio.util.ex.c {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ImageView mPic;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        return new int[]{R.id.w5x};
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(v3, "v");
        com.tencent.mobileqq.guild.discoveryv2.content.recommend.d p16 = p();
        T mData = this.mData;
        Intrinsics.checkNotNullExpressionValue(mData, "mData");
        p16.l((RecommendSchemeData) mData, v3);
        EventCollector.getInstance().onViewClicked(v3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@NotNull View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        View findViewById = containerView.findViewById(R.id.w5l);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewBy\u2026_discovery_v2_feed_image)");
        this.mPic = (ImageView) findViewById;
        View rootView = getRootView();
        Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
        ViewExtKt.b(rootView, this);
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(@NotNull View v3) {
        EventCollector.getInstance().onViewLongClickedBefore(v3);
        Intrinsics.checkNotNullParameter(v3, "v");
        com.tencent.mobileqq.guild.discoveryv2.content.recommend.d p16 = p();
        T mData = this.mData;
        Intrinsics.checkNotNullExpressionValue(mData, "mData");
        boolean i3 = p16.i((com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.l) mData, v3, this.mPosition);
        EventCollector.getInstance().onViewLongClicked(v3);
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public void onBindData(@NotNull RecommendSchemeData data, int position, @Nullable List<Object> payload) {
        ImageView imageView;
        Intrinsics.checkNotNullParameter(data, "data");
        ImageView imageView2 = this.mPic;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPic");
            imageView2 = null;
        }
        imageView2.setVisibility(0);
        int b16 = (int) (q().b() / 1.2484472049689441d);
        ImageView imageView3 = this.mPic;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPic");
            imageView3 = null;
        }
        ViewGroup.LayoutParams layoutParams = imageView3.getLayoutParams();
        layoutParams.height = b16;
        layoutParams.width = q().b();
        ImageView imageView4 = this.mPic;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPic");
            imageView4 = null;
        }
        imageView4.setLayoutParams(layoutParams);
        com.tencent.mobileqq.guild.discoveryv2.util.d dVar = com.tencent.mobileqq.guild.discoveryv2.util.d.f217794a;
        ImageView imageView5 = this.mPic;
        if (imageView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPic");
            imageView = null;
        } else {
            imageView = imageView5;
        }
        com.tencent.mobileqq.guild.discoveryv2.util.d.c(dVar, imageView, data.getCover(), q().b(), b16, false, 16, null);
    }
}
