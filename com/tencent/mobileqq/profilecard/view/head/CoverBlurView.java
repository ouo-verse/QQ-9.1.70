package com.tencent.mobileqq.profilecard.view.head;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.profilecard.constant.QCircleProfileConstant;
import com.tencent.mobileqq.profilecard.utils.CoverBlurUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 12\u00020\u0001:\u000212B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J\u0018\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0013H\u0002J\u0010\u0010$\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0002J\u0010\u0010%\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0002J\b\u0010&\u001a\u00020\u0017H\u0002J.\u0010'\u001a\u00020 2\u0006\u0010#\u001a\u00020\u00132\u0006\u0010(\u001a\u00020\u00112\u0006\u0010)\u001a\u00020\u00112\u0006\u0010*\u001a\u00020\u00112\u0006\u0010+\u001a\u00020\u0015J\u0010\u0010,\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0014J\u0016\u0010-\u001a\u00020 2\u0006\u0010(\u001a\u00020\u00112\u0006\u0010)\u001a\u00020\u0011J\u0006\u0010.\u001a\u00020 J\u000e\u0010/\u001a\u00020 2\u0006\u00100\u001a\u00020\nR\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00063"}, d2 = {"Lcom/tencent/mobileqq/profilecard/view/head/CoverBlurView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "blurBitmapRectF", "Landroid/graphics/RectF;", "blurLoadListener", "Lcom/tencent/mobileqq/profilecard/view/head/CoverBlurView$IBlurLoadListener;", "blurRectBottom", "", "blurRectLeft", "blurRectRight", "blurRectTop", "clipHeight", "", "coverBitmap", "Landroid/graphics/Bitmap;", "isFailed", "", NodeProps.LINEAR_GRADIENT, "Landroid/graphics/LinearGradient;", "paint", "Landroid/graphics/Paint;", "regionRectF", "videoBottom", "videoTop", "xfermode", "Landroid/graphics/PorterDuffXfermode;", "drawBitmap", "", PM.CANVAS, "Landroid/graphics/Canvas;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "drawBlur", "drawGradient", "getLinearGradient", "loadCover", "top", "bottom", "clipH", "isFromCache", "onDraw", "onVideoPosChange", "setFailed", "setLoadBlurListener", "listener", "Companion", "IBlurLoadListener", "profilecard_feature_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public final class CoverBlurView extends View {
    private static final String TAG = "CoverBlurView";
    private final RectF blurBitmapRectF;
    private IBlurLoadListener blurLoadListener;
    private float blurRectBottom;
    private float blurRectLeft;
    private float blurRectRight;
    private float blurRectTop;
    private int clipHeight;
    private volatile Bitmap coverBitmap;
    private boolean isFailed;
    private LinearGradient linearGradient;
    private final Paint paint;
    private final RectF regionRectF;
    private int videoBottom;
    private int videoTop;
    private final PorterDuffXfermode xfermode;
    private static final int ALPHA_0 = Color.parseColor("#00FFFFFF");
    private static final int ALPHA_1 = Color.parseColor("#FFFFFFFF");
    private static final int blurOffset = ViewUtils.dip2px(40.0f);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/profilecard/view/head/CoverBlurView$IBlurLoadListener;", "", "onLoadBlurFinish", "", MimeHelper.IMAGE_SUBTYPE_BITMAP, "Landroid/graphics/Bitmap;", "isFromCache", "", "profilecard_feature_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes35.dex */
    public interface IBlurLoadListener {
        void onLoadBlurFinish(Bitmap bitmap, boolean isFromCache);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoverBlurView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.regionRectF = new RectF();
        this.blurBitmapRectF = new RectF();
        this.xfermode = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
        this.paint = new Paint(1);
    }

    private final void drawBitmap(Canvas canvas, Bitmap bitmap) {
        RectF rectF = this.blurBitmapRectF;
        rectF.left = this.blurRectLeft;
        rectF.top = this.blurRectTop;
        rectF.right = this.blurRectRight;
        rectF.bottom = this.blurRectBottom;
        Unit unit = Unit.INSTANCE;
        canvas.drawBitmap(bitmap, (Rect) null, rectF, this.paint);
    }

    private final void drawBlur(Canvas canvas) {
        Bitmap bitmap = this.coverBitmap;
        if (bitmap != null) {
            int saveLayer = canvas.saveLayer(this.regionRectF, null);
            drawBitmap(canvas, bitmap);
            drawGradient(canvas);
            canvas.restoreToCount(saveLayer);
        }
    }

    private final void drawGradient(Canvas canvas) {
        this.paint.setXfermode(this.xfermode);
        this.paint.setShader(getLinearGradient());
        canvas.drawRect(this.regionRectF, this.paint);
        this.paint.setXfermode(null);
        this.paint.setShader(null);
    }

    private final LinearGradient getLinearGradient() {
        LinearGradient linearGradient = this.linearGradient;
        if (linearGradient != null) {
            return linearGradient;
        }
        float centerX = this.regionRectF.centerX();
        RectF rectF = this.regionRectF;
        float f16 = rectF.top;
        float centerX2 = rectF.centerX();
        RectF rectF2 = this.regionRectF;
        float f17 = rectF2.bottom;
        int i3 = ALPHA_1;
        int i16 = ALPHA_0;
        int i17 = this.videoTop + this.clipHeight;
        int i18 = blurOffset;
        RectF rectF3 = this.regionRectF;
        float f18 = (this.videoBottom + this.clipHeight) - i18;
        RectF rectF4 = this.regionRectF;
        float f19 = this.videoBottom + this.clipHeight;
        RectF rectF5 = this.regionRectF;
        LinearGradient linearGradient2 = new LinearGradient(centerX, f16, centerX2, f17, new int[]{i3, i3, i16, i16, i3, i3}, new float[]{0.0f, ((this.videoTop + this.clipHeight) - rectF2.top) / rectF2.height(), ((i17 + i18) - rectF3.top) / rectF3.height(), (f18 - rectF4.top) / rectF4.height(), (f19 - rectF5.top) / rectF5.height(), 1.0f}, Shader.TileMode.CLAMP);
        this.linearGradient = linearGradient2;
        return linearGradient2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void loadCover$lambda$1(CoverBlurView this$0, Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(bitmap, "$bitmap");
        CoverBlurUtil coverBlurUtil = CoverBlurUtil.INSTANCE;
        Context context = this$0.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        this$0.coverBitmap = CoverBlurUtil.blur$default(coverBlurUtil, context, bitmap, 0.0f, 6, 0, 20, null);
        this$0.postInvalidate();
        IBlurLoadListener iBlurLoadListener = this$0.blurLoadListener;
        if (iBlurLoadListener != null) {
            iBlurLoadListener.onLoadBlurFinish(this$0.coverBitmap, false);
        }
    }

    public final void loadCover(final Bitmap bitmap, int top, int bottom, int clipH, boolean isFromCache) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        this.clipHeight = clipH;
        this.videoTop = top;
        this.videoBottom = bottom;
        this.blurRectTop = -clipH;
        this.blurRectLeft = 0.0f;
        float screenWidth = ViewUtils.getScreenWidth();
        this.blurRectRight = screenWidth;
        float f16 = QCircleProfileConstant.FULL_SCREEN_HEIGHT + this.clipHeight;
        this.blurRectBottom = f16;
        RectF rectF = this.regionRectF;
        rectF.left = this.blurRectLeft;
        rectF.top = this.blurRectTop;
        rectF.right = screenWidth;
        rectF.bottom = f16;
        if (isFromCache) {
            this.coverBitmap = bitmap;
            invalidate();
            IBlurLoadListener iBlurLoadListener = this.blurLoadListener;
            if (iBlurLoadListener != null) {
                iBlurLoadListener.onLoadBlurFinish(this.coverBitmap, true);
                return;
            }
            return;
        }
        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.profilecard.view.head.ab
            @Override // java.lang.Runnable
            public final void run() {
                CoverBlurView.loadCover$lambda$1(CoverBlurView.this, bitmap);
            }
        });
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        if (this.isFailed) {
            return;
        }
        try {
            drawBlur(canvas);
        } catch (Exception e16) {
            QLog.w(TAG, 1, "drawBlur, error", e16);
        }
    }

    public final void onVideoPosChange(int top, int bottom) {
        this.videoTop = top;
        this.videoBottom = bottom;
    }

    public final void setLoadBlurListener(IBlurLoadListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.blurLoadListener = listener;
    }

    public final void setFailed() {
        this.isFailed = true;
    }
}
