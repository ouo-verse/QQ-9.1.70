package com.tencent.mobileqq.guild.discoveryv2.content.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/content/view/FullSpanGradientImageView;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/view/GradientImageView;", "Landroid/graphics/Paint;", "paint", "", "height", "", "t", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class FullSpanGradientImageView extends GradientImageView {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FullSpanGradientImageView(@NotNull Context context, @NotNull AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.view.GradientImageView
    public void t(@NotNull Paint paint, int height) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        paint.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, height, new int[]{Color.parseColor("#26FFFFFF"), Color.parseColor("#00FFFFFF"), Color.parseColor("#00FFFFFF")}, new float[]{0.0f, 0.7f, 1.0f}, Shader.TileMode.CLAMP));
    }
}
