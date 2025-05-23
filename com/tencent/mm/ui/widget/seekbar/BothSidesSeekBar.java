package com.tencent.mm.ui.widget.seekbar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatSeekBar;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.luggage.wxa.lo.o;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0014J\f\u0010\n\u001a\u00020\u0004*\u00020\tH\u0002R\u0016\u0010\f\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\"\u0010\u0013\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mm/ui/widget/seekbar/BothSidesSeekBar;", "Landroidx/appcompat/widget/AppCompatSeekBar;", "", "dp", "", "changeBarHeight", "Landroid/graphics/Canvas;", PM.CANVAS, "onDraw", "Landroid/graphics/Paint;", "a", "I", "seekbarHeight", "b", "Landroid/graphics/Paint;", "paint", "", "c", "Z", "isBothSidesMode", "()Z", "setBothSidesMode", "(Z)V", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "weui-native-android-lib_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes9.dex */
public final class BothSidesSeekBar extends AppCompatSeekBar {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public int seekbarHeight;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public Paint paint;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public boolean isBothSidesMode;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public BothSidesSeekBar(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void a(Paint paint) {
        paint.reset();
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeWidth(this.seekbarHeight);
    }

    public final void changeBarHeight(int dp5) {
        this.seekbarHeight = dp5;
        this.paint.setStrokeWidth(dp5);
    }

    /* renamed from: isBothSidesMode, reason: from getter */
    public final boolean getIsBothSidesMode() {
        return this.isBothSidesMode;
    }

    @Override // androidx.appcompat.widget.AppCompatSeekBar, android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public synchronized void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        this.paint.setColor(1308622847);
        this.paint.setShader(null);
        canvas.drawLine(getThumbOffset() + 0.0f, getHeight() / 2.0f, getWidth() - getThumbOffset(), getHeight() / 2.0f, this.paint);
        if (this.isBothSidesMode) {
            int max = getMax() / 2;
            if (getProgress() > max) {
                float thumbOffset = getThumbOffset() + (getWidth() / 2.0f);
                float height = getHeight() / 2.0f;
                float thumbOffset2 = getThumbOffset() + (getWidth() / 2.0f) + (((getWidth() - (getThumbOffset() * 2)) / getMax()) * (getProgress() - max));
                float height2 = getHeight() / 2.0f;
                a(this.paint);
                this.paint.setShader(new LinearGradient(thumbOffset, height, thumbOffset2, height2, new int[]{Color.parseColor("#63E7A0"), Color.parseColor("#2AAE67")}, (float[]) null, Shader.TileMode.CLAMP));
                canvas.drawLine(thumbOffset, height, thumbOffset2, height2, this.paint);
            }
            if (getProgress() < max) {
                float width = ((getWidth() / 2.0f) - (((getWidth() - (getThumbOffset() * 2)) / getMax()) * (max - getProgress()))) - getThumbOffset();
                float height3 = getHeight() / 2.0f;
                float width2 = getWidth() / 2.0f;
                float height4 = getHeight() / 2.0f;
                a(this.paint);
                this.paint.setShader(new LinearGradient(width, height3, width2, height4, new int[]{Color.parseColor("#63E7A0"), Color.parseColor("#2AAE67")}, (float[]) null, Shader.TileMode.CLAMP));
                canvas.drawLine(width, height3, width2, height4, this.paint);
            }
        } else {
            float thumbOffset3 = getThumbOffset() + 0.0f;
            float height5 = getHeight() / 2.0f;
            float thumbOffset4 = getThumbOffset() + ((getWidth() - (getThumbOffset() * 2)) * (getProgress() / getMax()));
            float height6 = getHeight() / 2.0f;
            a(this.paint);
            this.paint.setShader(new LinearGradient(thumbOffset3, height5, thumbOffset4, height6, new int[]{Color.parseColor("#63E7A0"), Color.parseColor("#2AAE67")}, (float[]) null, Shader.TileMode.CLAMP));
            canvas.drawLine(thumbOffset3, height5, thumbOffset4, height6, this.paint);
        }
        super.onDraw(canvas);
    }

    public final void setBothSidesMode(boolean z16) {
        this.isBothSidesMode = z16;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public BothSidesSeekBar(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ BothSidesSeekBar(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public BothSidesSeekBar(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.seekbarHeight = o.a(getContext(), 4);
        Paint paint = new Paint();
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeWidth(this.seekbarHeight);
        this.paint = paint;
    }
}
