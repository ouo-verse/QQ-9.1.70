package com.tencent.mobileqq.qqecommerce.biz.kuikly.utils;

import android.graphics.Canvas;
import android.graphics.RecordingCanvas;
import android.graphics.RenderEffect;
import android.graphics.RenderNode;
import android.graphics.Shader;
import android.view.View;
import com.qq.e.comm.managers.plugin.PM;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J&\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bR\u0017\u0010\u0012\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/utils/n;", "", "Landroid/view/View;", "srcView", "", "dstWidth", "dstHeight", "", "radius", "", "b", "Landroid/graphics/Canvas;", PM.CANVAS, "a", "Landroid/graphics/RenderNode;", "Landroid/graphics/RenderNode;", "getRenderNode", "()Landroid/graphics/RenderNode;", "renderNode", "<init>", "()V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final RenderNode renderNode = new RenderNode("QQKuiklyVideoBlur-RenderNode");

    public final void a(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (canvas.isHardwareAccelerated()) {
            canvas.drawRenderNode(this.renderNode);
        }
    }

    public final void b(View srcView, int dstWidth, int dstHeight, float radius) {
        RenderEffect createBlurEffect;
        RecordingCanvas beginRecording;
        Intrinsics.checkNotNullParameter(srcView, "srcView");
        if (dstWidth == 0 || dstHeight == 0) {
            return;
        }
        RenderNode renderNode = this.renderNode;
        createBlurEffect = RenderEffect.createBlurEffect(radius, radius, Shader.TileMode.CLAMP);
        renderNode.setRenderEffect(createBlurEffect);
        this.renderNode.setPosition(0, 0, dstWidth, dstHeight);
        beginRecording = this.renderNode.beginRecording();
        Intrinsics.checkNotNullExpressionValue(beginRecording, "renderNode.beginRecording()");
        float f16 = dstWidth;
        float f17 = dstHeight;
        float min = Math.min(srcView.getWidth() / f16, srcView.getHeight() / f17);
        beginRecording.save();
        beginRecording.scale(min, min);
        float f18 = 2;
        beginRecording.translate(((f16 * min) - srcView.getWidth()) / f18, ((f17 * min) - srcView.getHeight()) / f18);
        srcView.draw(beginRecording);
        beginRecording.restore();
        this.renderNode.endRecording();
    }
}
