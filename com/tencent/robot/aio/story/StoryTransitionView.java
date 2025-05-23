package com.tencent.robot.aio.story;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.FloatRange;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.hippy.qq.view.pag.HippyQQPagView;
import com.tencent.mapsdk.internal.by;
import com.tencent.qqnt.aio.utils.ViewUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001fB\u0011\b\u0016\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u00a2\u0006\u0004\b\u0019\u0010\u001aB\u001b\b\u0016\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u00a2\u0006\u0004\b\u0019\u0010\u001dJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014R*\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00068\u0006@FX\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006 "}, d2 = {"Lcom/tencent/robot/aio/story/StoryTransitionView;", "Landroid/view/View;", "Landroid/graphics/Canvas;", PM.CANVAS, "", "onDraw", "", "value", "d", UserInfo.SEX_FEMALE, HippyQQPagView.FunctionName.GET_PROGRESS, "()F", HippyQQPagView.FunctionName.SET_PROGRESS, "(F)V", "progress", "Landroid/graphics/Paint;", "e", "Landroid/graphics/Paint;", "mPaint", "Landroid/graphics/PorterDuffXfermode;", "f", "Landroid/graphics/PorterDuffXfermode;", "clearMode", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", tl.h.F, "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class StoryTransitionView extends View {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @FloatRange(from = 0.0d, to = by.f147964a)
    private float progress;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Paint mPaint;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final PorterDuffXfermode clearMode;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoryTransitionView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mPaint = new Paint(1);
        this.clearMode = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
    }

    @Override // android.view.View
    protected void onDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        int saveLayer = canvas.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null);
        canvas.drawColor(-14605786);
        canvas.rotate(this.progress * 45.0f, getWidth() / 2.0f, getHeight() / 2.0f);
        float width = getWidth() / 2.0f;
        float height = getHeight() / 2.0f;
        float width2 = (this.progress * (getWidth() + getHeight())) / ((float) Math.sqrt(2.0f));
        float f16 = width2 * 0.128f;
        this.mPaint.setXfermode(this.clearMode);
        this.mPaint.setStyle(Paint.Style.FILL);
        float f17 = 2;
        float f18 = width2 / f17;
        float f19 = width - f18;
        float f26 = (1.424f * width2) / f17;
        float f27 = height - f26;
        float f28 = width + f18;
        float f29 = height + f26;
        canvas.drawRoundRect(f19, f27, f28, f29, f16, f16, this.mPaint);
        this.mPaint.setXfermode(null);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeWidth(ViewUtils.f352270a.a(0.004f * width2));
        this.mPaint.setColor(-3227226);
        canvas.drawRoundRect(f19, f27, f28, f29, f16, f16, this.mPaint);
        float f36 = width2 * 1.08f;
        float f37 = 1.4f * f36;
        float f38 = f36 * 0.14814815f;
        this.mPaint.setColor(1724826022);
        float f39 = f36 / f17;
        float f46 = f37 / f17;
        canvas.drawRoundRect(width - f39, height - f46, width + f39, height + f46, f38, f38, this.mPaint);
        canvas.restoreToCount(saveLayer);
    }

    public final void setProgress(float f16) {
        this.progress = f16;
        invalidate();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoryTransitionView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mPaint = new Paint(1);
        this.clearMode = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
    }
}
