package androidx.swiperefreshlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.view.animation.Animation;
import android.widget.ImageView;
import androidx.core.view.ViewCompat;
import androidx.swiperefreshlayout.R;

/* compiled from: P */
/* loaded from: classes.dex */
class CircleImageView extends ImageView {
    private static final int DEFAULT_BACKGROUND_COLOR = -328966;
    private static final int FILL_SHADOW_COLOR = 1023410176;
    private static final int KEY_SHADOW_COLOR = 503316480;
    private static final int SHADOW_ELEVATION = 4;
    private static final float SHADOW_RADIUS = 3.5f;
    private static final float X_OFFSET = 0.0f;
    private static final float Y_OFFSET = 1.75f;
    private int mBackgroundColor;
    private Animation.AnimationListener mListener;
    private int mShadowRadius;

    /* compiled from: P */
    /* loaded from: classes.dex */
    private static class OvalShadow extends OvalShape {
        private CircleImageView mCircleImageView;
        private Paint mShadowPaint = new Paint();
        private int mShadowRadius;

        OvalShadow(CircleImageView circleImageView, int i3) {
            this.mCircleImageView = circleImageView;
            this.mShadowRadius = i3;
            updateRadialGradient((int) rect().width());
        }

        private void updateRadialGradient(int i3) {
            float f16 = i3 / 2;
            this.mShadowPaint.setShader(new RadialGradient(f16, f16, this.mShadowRadius, new int[]{CircleImageView.FILL_SHADOW_COLOR, 0}, (float[]) null, Shader.TileMode.CLAMP));
        }

        @Override // android.graphics.drawable.shapes.OvalShape, android.graphics.drawable.shapes.RectShape, android.graphics.drawable.shapes.Shape
        public void draw(Canvas canvas, Paint paint) {
            float width = this.mCircleImageView.getWidth() / 2;
            float height = this.mCircleImageView.getHeight() / 2;
            canvas.drawCircle(width, height, width, this.mShadowPaint);
            canvas.drawCircle(width, height, r0 - this.mShadowRadius, paint);
        }

        @Override // android.graphics.drawable.shapes.RectShape, android.graphics.drawable.shapes.Shape
        protected void onResize(float f16, float f17) {
            super.onResize(f16, f17);
            updateRadialGradient((int) f16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CircleImageView(Context context) {
        super(context);
        ShapeDrawable shapeDrawable;
        float f16 = getContext().getResources().getDisplayMetrics().density;
        int i3 = (int) (Y_OFFSET * f16);
        int i16 = (int) (0.0f * f16);
        this.mShadowRadius = (int) (SHADOW_RADIUS * f16);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(R.styleable.SwipeRefreshLayout);
        this.mBackgroundColor = obtainStyledAttributes.getColor(R.styleable.SwipeRefreshLayout_swipeRefreshLayoutProgressSpinnerBackgroundColor, DEFAULT_BACKGROUND_COLOR);
        obtainStyledAttributes.recycle();
        if (elevationSupported()) {
            shapeDrawable = new ShapeDrawable(new OvalShape());
            ViewCompat.setElevation(this, f16 * 4.0f);
        } else {
            ShapeDrawable shapeDrawable2 = new ShapeDrawable(new OvalShadow(this, this.mShadowRadius));
            setLayerType(1, shapeDrawable2.getPaint());
            shapeDrawable2.getPaint().setShadowLayer(this.mShadowRadius, i16, i3, KEY_SHADOW_COLOR);
            int i17 = this.mShadowRadius;
            setPadding(i17, i17, i17, i17);
            shapeDrawable = shapeDrawable2;
        }
        shapeDrawable.getPaint().setColor(this.mBackgroundColor);
        ViewCompat.setBackground(this, shapeDrawable);
    }

    private boolean elevationSupported() {
        return true;
    }

    public int getBackgroundColor() {
        return this.mBackgroundColor;
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
            this.mBackgroundColor = i3;
        }
    }
}
