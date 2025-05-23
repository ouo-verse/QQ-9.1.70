package android.support.v4.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.support.v4.view.ViewCompat;
import android.view.animation.Animation;
import android.widget.ImageView;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes.dex */
public class CircleImageView extends ImageView {
    private static final int FILL_SHADOW_COLOR = 1023410176;
    private static final int KEY_SHADOW_COLOR = 503316480;
    private static final int SHADOW_ELEVATION = 4;
    private static final float SHADOW_RADIUS = 3.5f;
    private static final float X_OFFSET = 0.0f;
    private static final float Y_OFFSET = 1.75f;
    private Animation.AnimationListener mListener;
    private int mShadowRadius;

    /* compiled from: P */
    /* loaded from: classes.dex */
    private class OvalShadow extends OvalShape {
        private int mCircleDiameter;
        private RadialGradient mRadialGradient;
        private Paint mShadowPaint = new Paint();

        public OvalShadow(int i3, int i16) {
            CircleImageView.this.mShadowRadius = i3;
            this.mCircleDiameter = i16;
            int i17 = this.mCircleDiameter;
            RadialGradient radialGradient = new RadialGradient(i17 / 2, i17 / 2, CircleImageView.this.mShadowRadius, new int[]{CircleImageView.FILL_SHADOW_COLOR, 0}, (float[]) null, Shader.TileMode.CLAMP);
            this.mRadialGradient = radialGradient;
            this.mShadowPaint.setShader(radialGradient);
        }

        @Override // android.graphics.drawable.shapes.OvalShape, android.graphics.drawable.shapes.RectShape, android.graphics.drawable.shapes.Shape
        public void draw(Canvas canvas, Paint paint) {
            float width = CircleImageView.this.getWidth() / 2;
            float height = CircleImageView.this.getHeight() / 2;
            canvas.drawCircle(width, height, (this.mCircleDiameter / 2) + CircleImageView.this.mShadowRadius, this.mShadowPaint);
            canvas.drawCircle(width, height, this.mCircleDiameter / 2, paint);
        }
    }

    public CircleImageView(Context context, int i3, float f16) {
        super(context);
        ShapeDrawable shapeDrawable;
        float f17 = getContext().getResources().getDisplayMetrics().density;
        int i16 = (int) (f16 * f17 * 2.0f);
        int i17 = (int) (Y_OFFSET * f17);
        int i18 = (int) (0.0f * f17);
        this.mShadowRadius = (int) (SHADOW_RADIUS * f17);
        if (elevationSupported()) {
            shapeDrawable = new ShapeDrawable(new OvalShape());
            ViewCompat.setElevation(this, f17 * 4.0f);
        } else {
            shapeDrawable = new ShapeDrawable(new OvalShadow(this.mShadowRadius, i16));
            ViewCompat.setLayerType(this, 1, shapeDrawable.getPaint());
            shapeDrawable.getPaint().setShadowLayer(this.mShadowRadius, i18, i17, KEY_SHADOW_COLOR);
            int i19 = this.mShadowRadius;
            setPadding(i19, i19, i19, i19);
        }
        shapeDrawable.getPaint().setColor(i3);
        setBackgroundDrawable(shapeDrawable);
    }

    private boolean elevationSupported() {
        return true;
    }

    @Override // android.view.View
    public void onAnimationEnd() {
        super.onAnimationEnd();
        Animation.AnimationListener animationListener = this.mListener;
        if (animationListener != null) {
            animationListener.onAnimationEnd(getAnimation());
        }
    }

    @Override // android.view.View
    public void onAnimationStart() {
        super.onAnimationStart();
        Animation.AnimationListener animationListener = this.mListener;
        if (animationListener != null) {
            animationListener.onAnimationStart(getAnimation());
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
        if (!elevationSupported()) {
            setMeasuredDimension(getMeasuredWidth() + (this.mShadowRadius * 2), getMeasuredHeight() + (this.mShadowRadius * 2));
        }
    }

    public void setAnimationListener(Animation.AnimationListener animationListener) {
        this.mListener = animationListener;
    }

    @Override // android.view.View
    public void setBackgroundColor(int i3) {
        if (getBackground() instanceof ShapeDrawable) {
            ((ShapeDrawable) getBackground()).getPaint().setColor(i3);
        }
    }

    public void setBackgroundColorRes(int i3) {
        setBackgroundColor(getContext().getResources().getColor(i3));
    }
}
