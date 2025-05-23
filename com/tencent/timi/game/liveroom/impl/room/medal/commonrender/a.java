package com.tencent.timi.game.liveroom.impl.room.medal.commonrender;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.style.ReplacementSpan;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sr4.g;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0016\u0018\u0000 ,2\u00020\u0001:\u0001\tB!\b\u0016\u0012\u0006\u0010)\u001a\u00020\"\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u0012\u0006\u0010!\u001a\u00020\u001e\u00a2\u0006\u0004\b*\u0010+J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J4\u0010\u0011\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016JR\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\bH\u0016R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010!\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010%\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010(\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'\u00a8\u0006-"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/medal/commonrender/a;", "Landroid/text/style/ReplacementSpan;", "", "fontSize", "", "isFontBold", "", "textColor", "Landroid/graphics/Paint;", "a", "paint", "", "text", "start", "end", "Landroid/graphics/Paint$FontMetricsInt;", "fm", "getSize", "Landroid/graphics/Canvas;", PM.CANVAS, HippyTKDListViewAdapter.X, "top", "y", "bottom", "", "draw", "Lsr4/g;", "d", "Lsr4/g;", "medalInfo", "Lcom/tencent/timi/game/liveroom/impl/room/medal/commonrender/b;", "e", "Lcom/tencent/timi/game/liveroom/impl/room/medal/commonrender/b;", "drawConfig", "Landroid/graphics/Bitmap;", "f", "Landroid/graphics/Bitmap;", "bgImage", h.F, "Landroid/graphics/Paint;", "bgPaint", MimeHelper.IMAGE_SUBTYPE_BITMAP, "<init>", "(Landroid/graphics/Bitmap;Lsr4/g;Lcom/tencent/timi/game/liveroom/impl/room/medal/commonrender/b;)V", "i", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public class a extends ReplacementSpan {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private g medalInfo;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private MedalLayoutStyleConfig drawConfig;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Bitmap bgImage;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Paint bgPaint;

    public a(@NotNull Bitmap bitmap, @NotNull g medalInfo, @NotNull MedalLayoutStyleConfig drawConfig) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Intrinsics.checkNotNullParameter(medalInfo, "medalInfo");
        Intrinsics.checkNotNullParameter(drawConfig, "drawConfig");
        this.bgPaint = new Paint(7);
        this.bgImage = bitmap;
        this.drawConfig = drawConfig;
        this.medalInfo = medalInfo;
    }

    private final Paint a(float fontSize, boolean isFontBold, int textColor) {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setTextSize(fontSize);
        paint.setColor(textColor);
        if (isFontBold) {
            paint.setTypeface(Typeface.DEFAULT_BOLD);
        }
        return paint;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0076  */
    @Override // android.text.style.ReplacementSpan
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void draw(@NotNull Canvas canvas, @Nullable CharSequence text, int start, int end, float x16, int top, int y16, int bottom, @NotNull Paint paint) {
        MedalLayoutStyleConfig medalLayoutStyleConfig;
        boolean z16;
        boolean z17;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(paint, "paint");
        if (this.medalInfo != null && (medalLayoutStyleConfig = this.drawConfig) != null && this.bgImage != null) {
            Intrinsics.checkNotNull(medalLayoutStyleConfig);
            g gVar = this.medalInfo;
            Intrinsics.checkNotNull(gVar);
            Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
            float f16 = 2;
            float height = ((((fontMetricsInt.descent + y16) + y16) + fontMetricsInt.ascent) / 2) - (medalLayoutStyleConfig.getHeight() / f16);
            canvas.save();
            canvas.translate(x16, height);
            MedalLayoutStyleConfig medalLayoutStyleConfig2 = this.drawConfig;
            Intrinsics.checkNotNull(medalLayoutStyleConfig2);
            float width = medalLayoutStyleConfig2.getWidth();
            MedalLayoutStyleConfig medalLayoutStyleConfig3 = this.drawConfig;
            Intrinsics.checkNotNull(medalLayoutStyleConfig3);
            RectF rectF = new RectF(0.0f, 0.0f, width, medalLayoutStyleConfig3.getHeight());
            Bitmap bitmap = this.bgImage;
            Intrinsics.checkNotNull(bitmap);
            canvas.drawBitmap(bitmap, (Rect) null, rectF, this.bgPaint);
            String[] strArr = gVar.B.f434411c;
            if (strArr != null) {
                if (strArr.length == 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (!z17) {
                    z16 = false;
                    if (!z16) {
                        canvas.drawText(gVar.B.f434411c[0], (((medalLayoutStyleConfig.getWidth() / f16) - (((int) r7.measureText(gVar.B.f434411c[0])) / 2)) + medalLayoutStyleConfig.getFirTextCenterXOffset()) - medalLayoutStyleConfig.getTextFontOffsetX(), ((medalLayoutStyleConfig.getHeight() / f16) + (medalLayoutStyleConfig.getFirTextFontSize() / f16)) - medalLayoutStyleConfig.getTextFontOffsetY(), a(medalLayoutStyleConfig.getFirTextFontSize(), medalLayoutStyleConfig.getFirTextFontBold(), medalLayoutStyleConfig.getFirTextColor()));
                        if (gVar.B.f434411c.length > 1) {
                            canvas.drawText(gVar.B.f434411c[1], (((medalLayoutStyleConfig.getWidth() / f16) - (((int) r7.measureText(gVar.B.f434411c[1])) / 2)) + medalLayoutStyleConfig.getSecTextCenterXOffset()) - medalLayoutStyleConfig.getTextFontOffsetX(), ((medalLayoutStyleConfig.getHeight() / f16) + (medalLayoutStyleConfig.getSecTextFontSize() / f16)) - medalLayoutStyleConfig.getTextFontOffsetY(), a(medalLayoutStyleConfig.getSecTextFontSize(), medalLayoutStyleConfig.getSecTextFontBold(), medalLayoutStyleConfig.getSecTextColor()));
                        }
                    }
                    canvas.restore();
                }
            }
            z16 = true;
            if (!z16) {
            }
            canvas.restore();
        }
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(@NotNull Paint paint, @Nullable CharSequence text, int start, int end, @Nullable Paint.FontMetricsInt fm5) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        MedalLayoutStyleConfig medalLayoutStyleConfig = this.drawConfig;
        if (medalLayoutStyleConfig == null) {
            return 0;
        }
        Intrinsics.checkNotNull(medalLayoutStyleConfig);
        return (int) medalLayoutStyleConfig.getWidth();
    }
}
