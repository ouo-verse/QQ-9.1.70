package gx3;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.style.ReplacementSpan;
import android.util.TypedValue;
import androidx.core.graphics.drawable.DrawableKt;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b,\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010L\u001a\u00020\u0018\u0012\u0006\u0010M\u001a\u00020\u0004\u0012\u0006\u0010N\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010O\u001a\u00020\u0004\u0012\u0006\u0010P\u001a\u00020\u0004\u0012\u0006\u0010Q\u001a\u00020\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\bR\u0010SJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J4\u0010\u000f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016JR\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0003\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0016R\"\u0010\u001f\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010&\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010-\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\"\u00104\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\"\u00108\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b5\u0010/\u001a\u0004\b6\u00101\"\u0004\b7\u00103R\"\u0010<\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b9\u0010/\u001a\u0004\b:\u00101\"\u0004\b;\u00103R\"\u0010@\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b=\u0010/\u001a\u0004\b>\u00101\"\u0004\b?\u00103R\"\u0010D\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bA\u0010!\u001a\u0004\bB\u0010#\"\u0004\bC\u0010%R\u0018\u0010H\u001a\u0004\u0018\u00010E8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010I\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u0010/R\u0016\u0010K\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010/\u00a8\u0006T"}, d2 = {"Lgx3/b;", "Landroid/text/style/ReplacementSpan;", "", "text", "", "bgWidthPadding", "", "a", "Landroid/graphics/Paint;", "paint", "", "start", "end", "Landroid/graphics/Paint$FontMetricsInt;", "fm", "getSize", "Landroid/graphics/Canvas;", PM.CANVAS, HippyTKDListViewAdapter.X, "top", "y", "bottom", "", "draw", "Landroid/content/Context;", "d", "Landroid/content/Context;", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "mContext", "e", "I", "getMBgColor", "()I", "setMBgColor", "(I)V", "mBgColor", "f", "Ljava/lang/String;", "getMText", "()Ljava/lang/String;", "setMText", "(Ljava/lang/String;)V", "mText", h.F, UserInfo.SEX_FEMALE, "getMBgHeight", "()F", "setMBgHeight", "(F)V", "mBgHeight", "i", "getMBgWidth", "setMBgWidth", "mBgWidth", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "getMRightMargin", "setMRightMargin", "mRightMargin", BdhLogUtil.LogTag.Tag_Conn, "getMTextSize", "setMTextSize", "mTextSize", "D", "getMTextColor", "setMTextColor", "mTextColor", "Landroid/graphics/drawable/Drawable;", "E", "Landroid/graphics/drawable/Drawable;", "mDrawableIcon", "mIconSize", "G", "mBgRadius", "context", "bgColor", "bgHeight", "rightMargin", "textSize", "textColor", "<init>", "(Landroid/content/Context;IIIIIILjava/lang/String;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class b extends ReplacementSpan {

    /* renamed from: C, reason: from kotlin metadata */
    private float mTextSize;

    /* renamed from: D, reason: from kotlin metadata */
    private int mTextColor;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private Drawable mDrawableIcon;

    /* renamed from: F, reason: from kotlin metadata */
    private float mIconSize;

    /* renamed from: G, reason: from kotlin metadata */
    private float mBgRadius;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Context mContext;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int mBgColor;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String mText;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private float mBgHeight;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private float mBgWidth;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private float mRightMargin;

    public b(@NotNull Context context, int i3, int i16, int i17, int i18, int i19, int i26, @NotNull String text) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(text, "text");
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
        this.mContext = applicationContext;
        this.mBgColor = i3;
        this.mText = text;
        this.mTextColor = i26;
        this.mBgRadius = 10.0f;
        this.mBgHeight = TypedValue.applyDimension(1, i16, applicationContext.getResources().getDisplayMetrics());
        this.mRightMargin = TypedValue.applyDimension(1, i18, this.mContext.getResources().getDisplayMetrics());
        this.mTextSize = TypedValue.applyDimension(1, i19, this.mContext.getResources().getDisplayMetrics());
        this.mBgWidth = a(text, i17);
    }

    public final float a(@NotNull String text, int bgWidthPadding) {
        Intrinsics.checkNotNullParameter(text, "text");
        if (text.length() > 1) {
            Rect rect = new Rect();
            Paint paint = new Paint();
            paint.setTextSize(this.mTextSize);
            paint.getTextBounds(text, 0, text.length(), rect);
            return rect.width() + (TypedValue.applyDimension(1, bgWidthPadding, this.mContext.getResources().getDisplayMetrics()) * 2);
        }
        return this.mBgHeight;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(@NotNull Canvas canvas, @Nullable CharSequence text, int start, int end, float x16, int top, int y16, int bottom, @NotNull Paint paint) {
        float f16;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(paint, "paint");
        Paint paint2 = new Paint();
        paint2.setColor(this.mBgColor);
        paint2.setStyle(Paint.Style.FILL);
        paint2.setAntiAlias(true);
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        float f17 = fontMetrics.descent;
        float f18 = fontMetrics.ascent;
        float f19 = 2;
        float f26 = y16 + (((f17 - f18) - this.mBgHeight) / f19) + f18;
        RectF rectF = new RectF(x16, f26, this.mBgWidth + x16, this.mBgHeight + f26);
        float f27 = this.mBgRadius;
        canvas.drawRoundRect(rectF, f27, f27, paint2);
        TextPaint textPaint = new TextPaint();
        textPaint.setColor(this.mTextColor);
        textPaint.setTextSize(this.mTextSize);
        textPaint.setAntiAlias(true);
        textPaint.setTextAlign(Paint.Align.CENTER);
        Paint.FontMetrics fontMetrics2 = textPaint.getFontMetrics();
        float f28 = fontMetrics2.bottom;
        float f29 = fontMetrics2.top;
        float f36 = f28 - f29;
        String str = this.mText;
        if (this.mDrawableIcon == null) {
            f16 = (this.mBgWidth / f19) + x16;
        } else {
            f16 = ((this.mBgWidth / f19) + x16) - (this.mIconSize / f19);
        }
        canvas.drawText(str, f16, (f26 + ((this.mBgHeight - f36) / f19)) - f29, textPaint);
        Drawable drawable = this.mDrawableIcon;
        if (drawable != null) {
            float f37 = this.mIconSize;
            Bitmap bitmap$default = DrawableKt.toBitmap$default(drawable, (int) f37, (int) f37, null, 4, null);
            if (bitmap$default != null) {
                Paint paint3 = new Paint(6);
                paint3.setAntiAlias(true);
                paint3.setTextAlign(Paint.Align.CENTER);
                canvas.drawBitmap(bitmap$default, x16 + ((this.mBgWidth * 3) / 4), (this.mBgHeight - f36) / f19, paint3);
            }
        }
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(@NotNull Paint paint, @Nullable CharSequence text, int start, int end, @Nullable Paint.FontMetricsInt fm5) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        return (int) (this.mBgWidth + this.mRightMargin);
    }
}
