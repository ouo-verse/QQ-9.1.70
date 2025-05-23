package com.tencent.state.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.process.BitmapProcessor;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.state.service.ImageService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\tJR\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J4\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/state/view/EnhancedImageSpan;", "Landroid/text/style/ImageSpan;", "context", "Landroid/content/Context;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "Landroid/graphics/Bitmap;", NodeProps.MARGIN_LEFT, "", NodeProps.MARGIN_RIGHT, "(Landroid/content/Context;Landroid/graphics/Bitmap;II)V", "draw", "", PM.CANVAS, "Landroid/graphics/Canvas;", "text", "", "start", "end", HippyTKDListViewAdapter.X, "", "top", "y", "bottom", "paint", "Landroid/graphics/Paint;", "getSize", "fontMetricsInt", "Landroid/graphics/Paint$FontMetricsInt;", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class EnhancedImageSpan extends ImageSpan {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int marginLeft;
    private final int marginRight;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002JT\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\r2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0012J@\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\bH\u0002\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/state/view/EnhancedImageSpan$Companion;", "", "()V", "loadAndSetToSpan", "", "context", "Landroid/content/Context;", "ssb", "Landroid/text/SpannableStringBuilder;", "imgHolder", "", "imgUrl", "imgW", "", "imgH", NodeProps.MARGIN_LEFT, NodeProps.MARGIN_RIGHT, "onFinish", "Lkotlin/Function0;", "setImageSpan", "loadedImage", "Landroid/graphics/Bitmap;", "startIdx", "endIdx", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public static final class Companion {
        Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void setImageSpan(Context context, Bitmap loadedImage, int marginLeft, int marginRight, int startIdx, int endIdx, SpannableStringBuilder ssb) {
            ssb.setSpan(new EnhancedImageSpan(context, loadedImage, marginLeft, marginRight), startIdx, endIdx, 33);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void loadAndSetToSpan(final Context context, final SpannableStringBuilder ssb, final String imgHolder, final String imgUrl, final int imgW, final int imgH, final int marginLeft, final int marginRight, final Function0<Unit> onFinish) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(ssb, "ssb");
            Intrinsics.checkNotNullParameter(imgHolder, "imgHolder");
            Intrinsics.checkNotNullParameter(imgUrl, "imgUrl");
            Intrinsics.checkNotNullParameter(onFinish, "onFinish");
            synchronized (ssb) {
                ssb.append((CharSequence) imgHolder);
                int length = ssb.length() - imgHolder.length();
                int length2 = ssb.length();
                DisplayImageOptions build = new DisplayImageOptions.Builder().cacheInMemory(true).cacheOnDisk(true).postProcessor(new BitmapProcessor() { // from class: com.tencent.state.view.EnhancedImageSpan$Companion$loadAndSetToSpan$$inlined$synchronized$lambda$1
                    @Override // com.nostra13.universalimageloader.core.process.BitmapProcessor
                    public final Bitmap process(Bitmap bitmap) {
                        Intrinsics.checkNotNullExpressionValue(bitmap, "bitmap");
                        return EnhancedImageSpanKt.imageScale(bitmap, imgW, imgH);
                    }
                }).build();
                ImageLoader loader = ImageService.INSTANCE.getLoader();
                if (loader != null) {
                    loader.loadImage(imgUrl, build, new EnhancedImageSpan$Companion$loadAndSetToSpan$$inlined$synchronized$lambda$2(length, length2, ssb, imgHolder, imgW, imgH, imgUrl, context, marginLeft, marginRight, onFinish));
                    Unit unit = Unit.INSTANCE;
                }
            }
        }
    }

    public /* synthetic */ EnhancedImageSpan(Context context, Bitmap bitmap, int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, bitmap, (i17 & 4) != 0 ? 0 : i3, (i17 & 8) != 0 ? 0 : i16);
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence text, int start, int end, float x16, int top, int y16, int bottom, Paint paint) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(paint, "paint");
        Drawable b16 = getDrawable();
        canvas.save();
        Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
        float f16 = this.marginLeft + x16;
        int i3 = fontMetricsInt.descent + y16 + y16 + fontMetricsInt.ascent;
        Intrinsics.checkNotNullExpressionValue(b16, "b");
        canvas.translate(f16, (i3 - b16.getBounds().bottom) / 2);
        b16.draw(canvas);
        canvas.restore();
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence text, int start, int end, Paint.FontMetricsInt fontMetricsInt) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        Drawable drawable = getDrawable();
        Intrinsics.checkNotNullExpressionValue(drawable, "drawable");
        Rect bounds = drawable.getBounds();
        Intrinsics.checkNotNullExpressionValue(bounds, "drawable.bounds");
        if (fontMetricsInt != null) {
            Paint.FontMetricsInt fontMetricsInt2 = paint.getFontMetricsInt();
            Intrinsics.checkNotNullExpressionValue(fontMetricsInt2, "paint.fontMetricsInt");
            int i3 = fontMetricsInt2.descent;
            int i16 = fontMetricsInt2.ascent;
            int i17 = i16 + ((i3 - i16) / 2);
            int i18 = (bounds.bottom - bounds.top) / 2;
            int i19 = i17 - i18;
            fontMetricsInt.ascent = i19;
            fontMetricsInt.top = i19;
            int i26 = i17 + i18;
            fontMetricsInt.bottom = i26;
            fontMetricsInt.descent = i26;
        }
        return this.marginLeft + bounds.right + this.marginRight;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EnhancedImageSpan(Context context, Bitmap bitmap, int i3, int i16) {
        super(context, bitmap);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        this.marginLeft = i3;
        this.marginRight = i16;
    }
}
