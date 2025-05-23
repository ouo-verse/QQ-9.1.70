package com.tencent.biz.qqcircle.widgets;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QCircleRoundCorneredRelativeLayout extends RelativeLayout {

    /* renamed from: d, reason: collision with root package name */
    private boolean f93135d;

    /* renamed from: e, reason: collision with root package name */
    private final Paint f93136e;

    /* renamed from: f, reason: collision with root package name */
    private float[] f93137f;

    @TargetApi(11)
    public QCircleRoundCorneredRelativeLayout(Context context) {
        super(context);
        this.f93135d = false;
        this.f93136e = new Paint();
        this.f93137f = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        a(context);
    }

    private void a(Context context) {
        this.f93136e.setAntiAlias(true);
        this.f93136e.setStyle(Paint.Style.FILL);
        this.f93136e.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        Path path = new Path();
        path.addRoundRect(new RectF(getPaddingLeft(), getPaddingTop(), width - getPaddingRight(), height - getPaddingBottom()), this.f93137f, Path.Direction.CW);
        float f16 = width;
        float f17 = height;
        canvas.saveLayer(new RectF(0.0f, 0.0f, f16, f17), null, 31);
        super.dispatchDraw(canvas);
        if (Build.VERSION.SDK_INT <= 27) {
            this.f93136e.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
            canvas.drawPath(path, this.f93136e);
        } else {
            this.f93136e.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
            Path path2 = new Path();
            path2.addRect(0.0f, 0.0f, f16, f17, Path.Direction.CW);
            path2.op(path, Path.Op.DIFFERENCE);
            canvas.drawPath(path2, this.f93136e);
        }
        canvas.restore();
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x001e, code lost:
    
        if (r0 != 3) goto L20;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f93135d && isClickable() && isEnabled()) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action != 2) {
                    }
                }
                setAlpha(1.0f);
                return super.onTouchEvent(motionEvent);
            }
            setAlpha(0.5f);
            return super.onTouchEvent(motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setRadius(float f16, float f17, float f18, float f19) {
        this.f93137f = new float[]{f16, f16, f17, f17, f18, f18, f19, f19};
    }

    @TargetApi(11)
    public QCircleRoundCorneredRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f93135d = false;
        this.f93136e = new Paint();
        this.f93137f = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        a(context);
    }
}
