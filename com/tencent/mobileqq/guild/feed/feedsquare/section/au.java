package com.tencent.mobileqq.guild.feed.feedsquare.section;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Build;
import android.text.style.ReplacementSpan;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.guild.util.cw;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\r\u0018\u0000 %2\u00020\u0001:\u0001\u0004B-\u0012\u0006\u0010\"\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0018\u001a\u00020\b\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0019\u0012\b\b\u0002\u0010\u001e\u001a\u00020\b\u00a2\u0006\u0004\b#\u0010$J\f\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0002J2\u0010\r\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016JP\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0002H\u0016R\u0014\u0010\u0018\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001e\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u0017R\u0014\u0010!\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 \u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/section/au;", "Landroid/text/style/ReplacementSpan;", "Landroid/graphics/Paint;", "", "a", "paint", "", "text", "", "start", "end", "Landroid/graphics/Paint$FontMetricsInt;", "fm", "getSize", "Landroid/graphics/Canvas;", PM.CANVAS, "", HippyTKDListViewAdapter.X, "top", "y", "bottom", "draw", "d", "I", "maxWidthPx", "", "e", "Ljava/lang/String;", "ellipsis", "f", "fontWeight", tl.h.F, "Landroid/graphics/Paint;", "workPaint", "tvPaint", "<init>", "(Landroid/graphics/Paint;ILjava/lang/String;I)V", "i", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class au extends ReplacementSpan {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int maxWidthPx;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String ellipsis;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int fontWeight;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Paint workPaint;

    public /* synthetic */ au(Paint paint, int i3, String str, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(paint, (i17 & 2) != 0 ? (int) cw.c(100.0f) : i3, (i17 & 4) != 0 ? MiniBoxNoticeInfo.APPNAME_SUFFIX : str, (i17 & 8) != 0 ? 500 : i16);
    }

    private final void a(Paint paint) {
        Typeface create;
        if (Build.VERSION.SDK_INT >= 28) {
            create = Typeface.create(null, this.fontWeight, false);
            paint.setTypeface(create);
        } else {
            paint.setFakeBoldText(true);
        }
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(@NotNull Canvas canvas, @NotNull CharSequence text, int start, int end, float x16, int top, int y16, int bottom, @NotNull Paint paint) {
        String str;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(paint, "paint");
        CharSequence subSequence = text.subSequence(start, end);
        if (this.workPaint.measureText(subSequence.toString()) <= this.maxWidthPx) {
            canvas.drawText(subSequence, 0, subSequence.length(), x16, y16, this.workPaint);
            return;
        }
        float measureText = this.maxWidthPx - this.workPaint.measureText(this.ellipsis);
        if (measureText <= 0.0f) {
            canvas.drawText(this.ellipsis, x16, y16, this.workPaint);
            return;
        }
        int breakText = this.workPaint.breakText(subSequence, 0, subSequence.length(), true, measureText, null);
        if (breakText > 0) {
            CharSequence subSequence2 = subSequence.subSequence(0, breakText);
            str = ((Object) subSequence2) + this.ellipsis;
        } else {
            str = this.ellipsis;
        }
        canvas.drawText(str, x16, y16, this.workPaint);
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(@NotNull Paint paint, @NotNull CharSequence text, int start, int end, @Nullable Paint.FontMetricsInt fm5) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        Intrinsics.checkNotNullParameter(text, "text");
        return Math.min((int) this.workPaint.measureText(text.subSequence(start, end).toString()), this.maxWidthPx);
    }

    public au(@NotNull Paint tvPaint, int i3, @NotNull String ellipsis, int i16) {
        Intrinsics.checkNotNullParameter(tvPaint, "tvPaint");
        Intrinsics.checkNotNullParameter(ellipsis, "ellipsis");
        this.maxWidthPx = i3;
        this.ellipsis = ellipsis;
        this.fontWeight = i16;
        Paint paint = new Paint(tvPaint);
        a(paint);
        this.workPaint = paint;
    }
}
