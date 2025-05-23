package com.tencent.state.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.appcompat.widget.AppCompatImageView;
import com.tencent.image.URLDrawable;
import com.tencent.state.SquareDebug;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.utils.DrawableUtil;
import com.tencent.state.utils.ViewUtils;

/* compiled from: P */
/* loaded from: classes38.dex */
public class SquareImageView extends AppCompatImageView {
    private static final String TAG = "SquareDrawable_SquareImageView";
    private boolean ignoreTransparentTouchEvent;
    private boolean needCheckSizeOnLayout;

    public SquareImageView(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.ignoreTransparentTouchEvent && motionEvent.getAction() == 0) {
            int x16 = (int) motionEvent.getX();
            int y16 = (int) motionEvent.getY();
            Drawable drawable = getDrawable();
            if (drawable != null) {
                try {
                    Bitmap bitmap = drawable instanceof BitmapDrawable ? ((BitmapDrawable) drawable).getBitmap() : null;
                    if (bitmap != null) {
                        if (bitmap.getPixel((bitmap.getWidth() * x16) / getWidth(), (bitmap.getHeight() * y16) / getHeight()) == 0) {
                            return false;
                        }
                    }
                } catch (Exception e16) {
                    Square.INSTANCE.getConfig().getLogger().e(TAG, "dispatchTouchEvent, e:" + e16.getMessage(), e16);
                }
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        Drawable drawable;
        super.onDetachedFromWindow();
        if (Square.INSTANCE.getConfig().getCommonUtils().getPerformanceConfig().getAutoUnbindURLDrawable() && (drawable = getDrawable()) != null && (drawable instanceof URLDrawable)) {
            setImageDrawable(null);
        }
    }

    @Override // android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        if (this.needCheckSizeOnLayout) {
            int width = getWidth();
            int height = getHeight();
            if (width == 0 || height == 0) {
                return;
            }
            this.needCheckSizeOnLayout = false;
            checkDrawableSize(getDrawable(), width, height);
        }
    }

    public void setIgnoreTransparentTouchEvent(boolean z16) {
        this.ignoreTransparentTouchEvent = z16;
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        if (Square.INSTANCE.getConfig().getCommonUtils().isDebugVersion() && drawable != null && drawable != getDrawable() && SquareDebug.INSTANCE.getDrawableMonitor()) {
            int width = getWidth();
            int height = getHeight();
            if (width != 0 && height != 0) {
                this.needCheckSizeOnLayout = false;
                checkDrawableSize(drawable, width, height);
            } else {
                this.needCheckSizeOnLayout = true;
            }
        } else {
            this.needCheckSizeOnLayout = false;
        }
        super.setImageDrawable(drawable);
        if (drawable == null || !(drawable instanceof URLDrawable)) {
            return;
        }
        DrawableUtil.INSTANCE.markURLDrawable(getContext(), (URLDrawable) drawable);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int i3) {
        super.setImageResource(i3);
        setImageDrawable(DrawableUtil.INSTANCE.getDrawable(i3));
    }

    public SquareImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SquareImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.needCheckSizeOnLayout = false;
        this.ignoreTransparentTouchEvent = false;
    }

    private void checkDrawableSize(Drawable drawable, int i3, int i16) {
        if (drawable == null) {
            return;
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicWidth > i3 || intrinsicHeight > i16) {
            SquareLogger logger = Square.INSTANCE.getConfig().getLogger();
            StringBuilder sb5 = new StringBuilder();
            sb5.append("largeDrawableSize, viewName:");
            sb5.append(ViewUtils.INSTANCE.getViewName(this));
            sb5.append(", visible:");
            sb5.append(getVisibility() == 0);
            sb5.append(", vw:");
            sb5.append(i3);
            sb5.append(", vh:");
            sb5.append(i16);
            sb5.append(", dw:");
            sb5.append(intrinsicWidth);
            sb5.append(", dh:");
            sb5.append(intrinsicHeight);
            sb5.append(", url:");
            sb5.append(DrawableUtil.INSTANCE.getDrawableUrl(drawable));
            logger.e(TAG, sb5.toString(), null);
        }
    }
}
