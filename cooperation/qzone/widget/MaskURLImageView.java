package cooperation.qzone.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes28.dex */
public class MaskURLImageView extends URLImageView {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private float moreIconSize;
    private boolean needSowPlayIcon;
    private int num;
    private float paddingSize;
    Paint paint;
    private float playIconSize;
    private float textSize;

    public MaskURLImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.needSowPlayIcon = false;
        init();
    }

    private void drawMask(Canvas canvas) {
        if (this.needSowPlayIcon) {
            drawPlayIcon(canvas);
            return;
        }
        if (this.num <= 0) {
            return;
        }
        canvas.drawColor(1711276032);
        int width = (getWidth() - ((int) ((this.paint.measureText(String.valueOf(this.num)) + this.paddingSize) + this.moreIconSize))) / 2;
        float height = getHeight();
        float f16 = this.moreIconSize;
        int i3 = (int) ((height - f16) / 2.0f);
        Paint.FontMetrics fontMetrics = this.paint.getFontMetrics();
        float height2 = ((getHeight() - (fontMetrics.bottom - fontMetrics.top)) / 2.0f) - fontMetrics.top;
        Drawable drawable = getResources().getDrawable(R.drawable.fxe);
        drawable.setBounds(width, i3, (int) (width + f16), (int) (i3 + f16));
        drawable.draw(canvas);
        canvas.drawText(String.valueOf(this.num), r0 + width, height2, this.paint);
    }

    private void drawPlayIcon(Canvas canvas) {
        int width = (int) ((getWidth() - this.playIconSize) / 2.0f);
        int height = (int) ((getHeight() - this.playIconSize) / 2.0f);
        Drawable drawable = getResources().getDrawable(R.drawable.bvo);
        if (drawable != null) {
            float f16 = this.playIconSize;
            drawable.setBounds(width, height, (int) (width + f16), (int) (height + f16));
            drawable.draw(canvas);
        }
    }

    private void init() {
        Paint paint = new Paint();
        this.paint = paint;
        paint.setColor(-1);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.textSize = TypedValue.applyDimension(2, 18.0f, displayMetrics);
        this.paddingSize = TypedValue.applyDimension(1, 4.0f, displayMetrics);
        this.moreIconSize = TypedValue.applyDimension(1, 12.0f, displayMetrics);
        this.playIconSize = TypedValue.applyDimension(1, 28.0f, displayMetrics);
        this.paint.setTextSize(this.textSize);
        this.paint.setAntiAlias(true);
        this.paint.setTextAlign(Paint.Align.RIGHT);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawMask(canvas);
    }

    @Override // com.tencent.image.URLImageView, com.tencent.image.URLDrawable.URLDrawableListener
    public void onLoadCanceled(URLDrawable uRLDrawable) {
        super.onLoadCanceled(uRLDrawable);
    }

    @Override // com.tencent.image.URLImageView, com.tencent.image.URLDrawable.URLDrawableListener
    public void onLoadFialed(URLDrawable uRLDrawable, Throwable th5) {
        super.onLoadFialed(uRLDrawable, th5);
    }

    @Override // com.tencent.image.URLImageView, com.tencent.image.URLDrawable.URLDrawableListener
    public void onLoadSuccessed(URLDrawable uRLDrawable) {
        super.onLoadSuccessed(uRLDrawable);
    }

    public void setHasMore(int i3) {
        this.num = i3;
        invalidate();
    }

    public void setNeedSowPlayIcon(boolean z16) {
        this.needSowPlayIcon = z16;
        invalidate();
    }

    public MaskURLImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.needSowPlayIcon = false;
        init();
    }

    public MaskURLImageView(Context context) {
        super(context);
        this.needSowPlayIcon = false;
        init();
    }
}
