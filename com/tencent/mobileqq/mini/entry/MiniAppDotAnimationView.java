package com.tencent.mobileqq.mini.entry;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqmini.sdk.launcher.utils.ColorUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniAppDotAnimationView extends View {
    private static String TAG = "MiniAppDotAnimationView";
    private boolean hasReset;
    private List<Dot> mDots;
    private Paint mPaint;
    private static final int SCROLL_ANIMATION_OPEN_START = ViewUtils.dpToPx(-20.0f);
    private static final int SCROLL_ANIMATION_OPEN_END = ViewUtils.dpToPx(-50.0f);
    private static final int SCROLL_ANIMATION_CLOSE_START = ViewUtils.dpToPx(-70.0f);
    private static final int SCROLL_ANIMATION_CLOSE_END = ViewUtils.dpToPx(-95.0f);
    private static final int MIN_DOT_SIZE = ViewUtils.dpToPx(3.0f);
    private static final int MAX_DOT_SIZE = ViewUtils.dpToPx(6.0f);
    private static final int MARGIN_LEFT_RIGHT = ViewUtils.dpToPx(30.0f);
    private static final int DEFAULT_OFFSET = ViewUtils.dpToPx(-20.0f);

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class Dot {
        float finalOffset;
        float offset;
        float radius;

        Dot() {
        }
    }

    public MiniAppDotAnimationView(Context context) {
        super(context);
        this.mDots = new ArrayList(3);
        this.hasReset = false;
        init();
    }

    private void drawDots(Canvas canvas) {
        for (Dot dot : this.mDots) {
            canvas.drawCircle((getWidth() / 2) + dot.offset, getHeight() / 2, dot.radius, this.mPaint);
        }
    }

    private void init() {
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setColor(ColorUtils.parseColor("#DDDEE2"));
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setStrokeWidth(0.1f);
        this.mPaint.setAntiAlias(true);
        for (int i3 = 0; i3 < 3; i3++) {
            this.mDots.add(new Dot());
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        drawDots(canvas);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        super.onSizeChanged(i3, i16, i17, i18);
        for (Dot dot : this.mDots) {
            dot.radius = 0.0f;
            dot.offset = 0.0f;
            dot.finalOffset = 0.0f;
        }
        this.mDots.get(0).finalOffset = DEFAULT_OFFSET;
        this.mDots.get(1).finalOffset = 0.0f;
        this.mDots.get(2).finalOffset = -this.mDots.get(0).finalOffset;
        this.hasReset = false;
    }

    public void resetDots() {
        if (this.hasReset) {
            return;
        }
        this.hasReset = true;
        boolean z16 = false;
        for (Dot dot : this.mDots) {
            if (dot.radius != 0.0f || dot.offset != 0.0f) {
                z16 = true;
            }
            dot.radius = 0.0f;
            dot.offset = 0.0f;
        }
        if (z16) {
            setTranslationY(0.0f);
            invalidate();
        }
    }

    public MiniAppDotAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mDots = new ArrayList(3);
        this.hasReset = false;
        init();
    }

    public void doOnScroll(float f16) {
        if (f16 > 0.0f) {
            return;
        }
        this.hasReset = false;
        int i3 = SCROLL_ANIMATION_OPEN_START;
        if (f16 > i3) {
            for (Dot dot : this.mDots) {
                dot.radius = 0.0f;
                dot.offset = 0.0f;
            }
            this.mDots.get(1).radius = MAX_DOT_SIZE * (Math.abs(f16) / Math.abs(SCROLL_ANIMATION_OPEN_START));
        } else {
            if (f16 > SCROLL_ANIMATION_OPEN_END) {
                float f17 = (i3 - f16) / (i3 - r3);
                for (int i16 = 0; i16 < this.mDots.size(); i16++) {
                    this.mDots.get(i16).offset = this.mDots.get(i16).finalOffset * f17;
                    if (i16 == 1) {
                        this.mDots.get(i16).radius = MAX_DOT_SIZE - ((r2 - MIN_DOT_SIZE) * f17);
                    } else {
                        this.mDots.get(i16).radius = MIN_DOT_SIZE;
                    }
                }
            } else if (f16 > SCROLL_ANIMATION_CLOSE_START) {
                for (Dot dot2 : this.mDots) {
                    dot2.radius = MIN_DOT_SIZE;
                    dot2.offset = dot2.finalOffset;
                }
            } else {
                for (Dot dot3 : this.mDots) {
                    dot3.offset = dot3.finalOffset;
                }
                int i17 = SCROLL_ANIMATION_CLOSE_START;
                int i18 = SCROLL_ANIMATION_CLOSE_END;
                float f18 = ((i18 - i17) / 2) + i17;
                float f19 = i18;
                if (f16 > f18) {
                    float f26 = (i17 - f16) / (i17 - f18);
                    Dot dot4 = this.mDots.get(0);
                    Dot dot5 = this.mDots.get(2);
                    int i19 = MIN_DOT_SIZE;
                    float f27 = i19 - (i19 * f26);
                    dot5.radius = f27;
                    dot4.radius = f27;
                    this.mDots.get(1).radius = i19;
                } else if (f16 > f19) {
                    Dot dot6 = this.mDots.get(0);
                    this.mDots.get(2).radius = 0.0f;
                    dot6.radius = 0.0f;
                    Dot dot7 = this.mDots.get(1);
                    int i26 = MIN_DOT_SIZE;
                    dot7.radius = i26 - (i26 * ((f18 - f16) / (f18 - f19)));
                } else {
                    Iterator<Dot> it = this.mDots.iterator();
                    while (it.hasNext()) {
                        it.next().radius = 0.0f;
                    }
                }
            }
        }
        invalidate();
    }

    public MiniAppDotAnimationView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.mDots = new ArrayList(3);
        this.hasReset = false;
        init();
    }
}
