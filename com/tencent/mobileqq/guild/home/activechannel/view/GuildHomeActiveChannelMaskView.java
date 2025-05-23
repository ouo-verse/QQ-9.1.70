package com.tencent.mobileqq.guild.home.activechannel.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.guild.home.viewmodels.header.GuildHomeCoverColors;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\nB\u001b\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u00a2\u0006\u0004\b\u001d\u0010\u001eJ(\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0014J\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0002J\u0012\u0010\r\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0014R\u0016\u0010\u0010\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/guild/home/activechannel/view/GuildHomeActiveChannelMaskView;", "Landroid/view/View;", "", "w", h.F, "oldw", "oldh", "", MosaicConstants$JsFunction.FUNC_ON_SIZE_CHANGED, "color", "a", "Landroid/graphics/Canvas;", PM.CANVAS, "onDraw", "d", "I", "mainColor", "Landroid/graphics/Paint;", "e", "Landroid/graphics/Paint;", "paint", "Landroid/graphics/Matrix;", "f", "Landroid/graphics/Matrix;", "scaleMatrix", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildHomeActiveChannelMaskView extends View {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int mainColor;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Paint paint;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Matrix scaleMatrix;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildHomeActiveChannelMaskView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        this.paint = paint;
        Matrix matrix = new Matrix();
        matrix.setScale(1.0f, 1.0f);
        this.scaleMatrix = matrix;
    }

    public final void a(int color) {
        this.mainColor = color;
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(@Nullable Canvas canvas) {
        List listOf;
        int[] intArray;
        List listOf2;
        float[] floatArray;
        super.onDraw(canvas);
        float width = getWidth();
        float height = getHeight();
        GuildHomeCoverColors.Companion companion = GuildHomeCoverColors.INSTANCE;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(companion.a(0.95f, this.mainColor)), Integer.valueOf(companion.a(0.95f, this.mainColor)), Integer.valueOf(companion.a(0.0f, this.mainColor))});
        intArray = CollectionsKt___CollectionsKt.toIntArray(listOf);
        listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) new Float[]{Float.valueOf(0.0f), Float.valueOf(0.5f), Float.valueOf(1.0f)});
        floatArray = CollectionsKt___CollectionsKt.toFloatArray(listOf2);
        LinearGradient linearGradient = new LinearGradient(0.0f, width, height, 0.0f, intArray, floatArray, Shader.TileMode.CLAMP);
        linearGradient.setLocalMatrix(this.scaleMatrix);
        this.paint.setShader(linearGradient);
        if (canvas != null) {
            canvas.drawRect(0.0f, 0.0f, getWidth(), getHeight(), this.paint);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int w3, int h16, int oldw, int oldh) {
        super.onSizeChanged(w3, h16, oldw, oldh);
        if (w3 != 0 && h16 != 0) {
            Matrix matrix = new Matrix();
            matrix.setScale(w3 / h16, 1.0f);
            this.scaleMatrix = matrix;
        }
    }
}
