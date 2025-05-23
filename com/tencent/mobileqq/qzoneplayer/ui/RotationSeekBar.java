package com.tencent.mobileqq.qzoneplayer.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.SeekBar;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.oskplayer.util.PlayerUtils;

/* compiled from: P */
/* loaded from: classes16.dex */
public class RotationSeekBar extends SeekBar {
    static IPatchRedirector $redirector_;
    private static boolean isRubbishPhoneModel;
    private static float sDensity;
    private int mCurRotate;
    private Paint mDebugPainter;
    private Paint mMarkPainter;
    private float[] mMarkPercent;
    private OnRotationChangeListener mOnRotationChangeListener;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public interface OnRotationChangeListener {
        int getCurRotate();
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12005);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            isRubbishPhoneModel = PlayerUtils.isRubbishPhoneMobile();
            sDensity = -1.0f;
        }
    }

    public RotationSeekBar(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.mMarkPercent = null;
        this.mMarkPainter = null;
        this.mDebugPainter = null;
        initUI();
    }

    private int dpToPx(float f16) {
        getDensity();
        return Math.round(f16 * sDensity);
    }

    private MotionEvent fixTouchMoveEvent(MotionEvent motionEvent) {
        int i3;
        int i16;
        if (motionEvent != null && motionEvent.getAction() == 2) {
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            int i17 = iArr[0];
            int i18 = iArr[1];
            int rawX = (int) motionEvent.getRawX();
            int rawY = (int) motionEvent.getRawY();
            int i19 = this.mCurRotate;
            if (i19 != 90) {
                if (i19 != 180) {
                    if (i19 != 270) {
                        i3 = (int) motionEvent.getX();
                        i16 = (int) motionEvent.getY();
                    } else {
                        i3 = i18 - rawY;
                        i16 = rawX - i17;
                    }
                } else {
                    int i26 = i17 - rawX;
                    i16 = i18 - rawY;
                    i3 = i26;
                }
            } else {
                i3 = rawY - i18;
                i16 = i17 - rawX;
            }
            motionEvent.setLocation(i3, i16);
        }
        return motionEvent;
    }

    private float getDensity() {
        if (sDensity == -1.0f) {
            sDensity = getContext().getResources().getDisplayMetrics().density;
        }
        return sDensity;
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        OnRotationChangeListener onRotationChangeListener;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) motionEvent)).booleanValue();
        }
        if (motionEvent != null && motionEvent.getAction() == 0 && (onRotationChangeListener = this.mOnRotationChangeListener) != null) {
            this.mCurRotate = onRotationChangeListener.getCurRotate();
        }
        int i3 = this.mCurRotate;
        if (i3 != 0 || i3 != 360) {
            motionEvent = fixTouchMoveEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    protected void onDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) canvas);
            return;
        }
        super.onDraw(canvas);
        if (this.mMarkPercent != null) {
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            if (this.mMarkPainter == null) {
                Paint paint = new Paint();
                this.mMarkPainter = paint;
                paint.setStyle(Paint.Style.FILL);
                this.mMarkPainter.setColor(-3355444);
            }
            int dpToPx = dpToPx(2.0f);
            int i3 = measuredHeight / 2;
            for (float f16 : this.mMarkPercent) {
                if (f16 > 0.0f && f16 < 1.0f) {
                    canvas.save();
                    canvas.translate(f16 * measuredWidth, i3);
                    canvas.drawCircle(0.0f, 0.0f, dpToPx, this.mMarkPainter);
                    canvas.restore();
                }
            }
        }
    }

    @Override // android.widget.AbsSeekBar, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) motionEvent)).booleanValue();
        }
        return super.onTouchEvent(motionEvent);
    }

    public void placeMarkerAtPositions(float[] fArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) fArr);
        } else {
            this.mMarkPercent = fArr;
        }
    }

    public void setOnRotationChangeListener(OnRotationChangeListener onRotationChangeListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) onRotationChangeListener);
        } else {
            this.mOnRotationChangeListener = onRotationChangeListener;
        }
    }

    public RotationSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.mMarkPercent = null;
        this.mMarkPainter = null;
        this.mDebugPainter = null;
        initUI();
    }

    public RotationSeekBar(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.mMarkPercent = null;
        this.mMarkPainter = null;
        this.mDebugPainter = null;
        initUI();
    }

    void initUI() {
    }
}
