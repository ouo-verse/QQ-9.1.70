package com.tencent.timi.game.live.impl.danmuku;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.BoringLayout;
import android.text.Layout;
import android.text.TextPaint;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.BaseApplication;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\b*\u0001#\u0018\u0000 )2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b'\u0010(J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u001a\u0010\f\u001a\u00020\u000b2\u0010\u0010\n\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\tH\u0016J\u0012\u0010\u000e\u001a\u00020\r2\b\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0016J6\u0010\u0017\u001a\u00020\u00162\b\u0010\n\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0013H\u0016R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001c\u0010\"\u001a\n \u001f*\u0004\u0018\u00010\u001e0\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010&\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%\u00a8\u0006*"}, d2 = {"Lcom/tencent/timi/game/live/impl/danmuku/DanmakuRender;", "Lcom/tencent/common/danmaku/render/a;", "Lki4/d;", "", "text", "Landroid/text/TextPaint;", "textPaint", "Landroid/text/Layout;", h.F, "Lcom/tencent/common/danmaku/data/a;", "p0", "", "a", "Lcom/tencent/common/danmaku/util/a;", "i", "Landroid/graphics/Canvas;", "p1", "Lcom/tencent/common/danmaku/inject/b;", "p2", "", "p3", "p4", "", "j", "b", "Landroid/text/TextPaint;", "Landroid/text/BoringLayout$Metrics;", "c", "Landroid/text/BoringLayout$Metrics;", "boringMetrics", "Landroid/graphics/drawable/Drawable;", "kotlin.jvm.PlatformType", "d", "Landroid/graphics/drawable/Drawable;", "selfDanmakuBgDrawable", "com/tencent/timi/game/live/impl/danmuku/DanmakuRender$cache$1", "e", "Lcom/tencent/timi/game/live/impl/danmuku/DanmakuRender$cache$1;", "cache", "<init>", "()V", "f", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class DanmakuRender extends com.tencent.common.danmaku.render.a<ki4.d> {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextPaint textPaint;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final BoringLayout.Metrics boringMetrics;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Drawable selfDanmakuBgDrawable;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final DanmakuRender$cache$1 cache;

    public DanmakuRender() {
        TextPaint textPaint = new TextPaint();
        textPaint.setAntiAlias(true);
        textPaint.setDither(true);
        this.textPaint = textPaint;
        this.boringMetrics = new BoringLayout.Metrics();
        this.selfDanmakuBgDrawable = yn4.c.b(R.drawable.f162569lt2);
        this.cache = new DanmakuRender$cache$1();
    }

    private final Layout h(String text, TextPaint textPaint) {
        int roundToInt;
        Layout layout = (Layout) this.cache.get((Object) text);
        if (layout != null) {
            return layout;
        }
        QQText qQText = new QQText(com.tencent.mobileqq.qqlive.widget.util.c.a(text), 3, 20);
        float desiredWidth = Layout.getDesiredWidth(qQText, textPaint);
        BoringLayout.Metrics metrics = this.boringMetrics;
        roundToInt = MathKt__MathJVMKt.roundToInt(desiredWidth);
        metrics.width = roundToInt;
        this.boringMetrics.leading = textPaint.getFontMetricsInt().leading;
        this.boringMetrics.top = textPaint.getFontMetricsInt().top;
        this.boringMetrics.ascent = textPaint.getFontMetricsInt().ascent;
        this.boringMetrics.descent = textPaint.getFontMetricsInt().descent;
        this.boringMetrics.bottom = textPaint.getFontMetricsInt().bottom;
        BoringLayout boringLayout = BoringLayout.make(qQText, textPaint, ((int) desiredWidth) + 1, Layout.Alignment.ALIGN_NORMAL, 0.0f, 0.0f, this.boringMetrics, false);
        DanmakuRender$cache$1 danmakuRender$cache$1 = this.cache;
        Intrinsics.checkNotNullExpressionValue(boringLayout, "boringLayout");
        danmakuRender$cache$1.put(text, boringLayout);
        return boringLayout;
    }

    @Override // com.tencent.common.danmaku.render.a
    public boolean a(@Nullable com.tencent.common.danmaku.data.a<?, ?> p06) {
        return p06 instanceof ki4.d;
    }

    @Override // com.tencent.common.danmaku.render.a
    @NotNull
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public com.tencent.common.danmaku.util.a e(@Nullable ki4.d p06) {
        float f16;
        if (p06 == null) {
            return new com.tencent.common.danmaku.util.a(0.0f, 0.0f);
        }
        TextPaint textPaint = this.textPaint;
        if (p06.getType() != 1 && p06.getType() != 2) {
            f16 = 56.0f;
        } else {
            f16 = 12.0f;
        }
        textPaint.setTextSize(Utils.o(f16, BaseApplication.getContext().getResources()));
        Layout h16 = h(p06.l().getContent(), this.textPaint);
        float width = h16.getWidth();
        if (p06.getType() == 2) {
            width += fh4.b.d(16);
        }
        float height = h16.getHeight();
        if (p06.getType() == 2) {
            height += fh4.b.d(4);
        }
        float ceil = (float) Math.ceil(width);
        float ceil2 = (float) Math.ceil(height);
        p06.h0(ceil);
        p06.g0(ceil2);
        return new com.tencent.common.danmaku.util.a(ceil, ceil2);
    }

    @Override // com.tencent.common.danmaku.render.a
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public void f(@Nullable Canvas p06, @Nullable ki4.d p16, @Nullable com.tencent.common.danmaku.inject.b p26, float p36, float p46) {
        float f16;
        if (p06 != null && p16 != null) {
            TextPaint textPaint = this.textPaint;
            if (p16.getType() != 1 && p16.getType() != 2) {
                f16 = 56.0f;
            } else {
                f16 = 12.0f;
            }
            textPaint.setTextSize(Utils.o(f16, BaseApplication.getContext().getResources()));
            int type = p16.getType();
            if (type != 1) {
                if (type != 2) {
                    p06.drawColor(-16711936);
                    this.textPaint.setStrokeWidth(5.0f);
                    this.textPaint.setStyle(Paint.Style.STROKE);
                    this.textPaint.setColor(-16777216);
                    p06.drawText(p16.l().getContent(), p36, p46 - this.textPaint.ascent(), this.textPaint);
                    this.textPaint.setStrokeWidth(3.0f);
                    this.textPaint.setStyle(Paint.Style.FILL_AND_STROKE);
                    this.textPaint.setColor(-1);
                    p06.drawText(p16.l().getContent(), p36, p46 - this.textPaint.ascent(), this.textPaint);
                    return;
                }
                this.selfDanmakuBgDrawable.setBounds(fh4.b.b(3), fh4.b.b(3), (int) (p16.y() - fh4.b.d(3)), (int) (p16.x() - fh4.b.d(3)));
                this.selfDanmakuBgDrawable.draw(p06);
                this.textPaint.setStyle(Paint.Style.FILL);
                this.textPaint.setColor(-1);
                p06.save();
                p06.translate(p36 + fh4.b.d(8), p46 + fh4.b.d(2));
                h(p16.l().getContent(), this.textPaint).draw(p06);
                p06.restore();
                return;
            }
            this.textPaint.setStyle(Paint.Style.FILL);
            this.textPaint.setColor(-1);
            p06.save();
            p06.translate(p36, p46);
            h(p16.l().getContent(), this.textPaint).draw(p06);
            p06.restore();
        }
    }
}
