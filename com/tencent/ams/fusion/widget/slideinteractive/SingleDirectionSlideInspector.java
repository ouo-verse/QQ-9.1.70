package com.tencent.ams.fusion.widget.slideinteractive;

import android.graphics.PointF;
import com.tencent.ams.fusion.widget.base.SlideInspector;
import com.tencent.ams.fusion.widget.slideinteractive.SlideGestureViewHelper;
import com.tencent.ams.fusion.widget.utils.Logger;
import com.tencent.ams.fusion.widget.utils.Utils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class SingleDirectionSlideInspector implements SlideInspector {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "SingleDirectionSlideInspector";

    @SlideGestureViewHelper.SlideDirection
    private int mGestureSlideDirection;
    private float mGestureSlideValidAngle;
    private int mGestureSlideValidHeightDp;
    private float mInspectAngle;
    private float mInspectOffsetX;
    private float mInspectOffsetY;

    public SingleDirectionSlideInspector() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mGestureSlideDirection = 2;
        this.mGestureSlideValidAngle = 90.0f;
        this.mGestureSlideValidHeightDp = 100;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0035, code lost:
    
        if (r11 < 0.0f) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0062, code lost:
    
        r2 = r2 + 180.0d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0045, code lost:
    
        if (r10 < 0.0f) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0053, code lost:
    
        if (r11 > 0.0f) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0060, code lost:
    
        if (r10 > 0.0f) goto L27;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private double calculateSlideAngle(float f16, float f17) {
        double d16 = 0.0d;
        if (f17 == 0.0f || f16 == 0.0f) {
            return 0.0d;
        }
        int i3 = this.mGestureSlideDirection;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        Logger.w(TAG, "unsupported slide direction.");
                    } else {
                        d16 = Math.toDegrees(Math.atan(f16 / f17));
                    }
                } else {
                    d16 = Math.toDegrees(-Math.atan(f17 / f16));
                }
            } else {
                d16 = Math.toDegrees(Math.atan(f16 / (-f17)));
            }
        } else {
            d16 = Math.toDegrees(Math.atan(f17 / f16));
        }
        if (d16 > 180.0d) {
            return d16 - 360.0d;
        }
        return d16;
    }

    private float calculateSlideDistance(float f16, float f17) {
        int i3 = this.mGestureSlideDirection;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        Logger.w(TAG, "unsupported slide direction.");
                        return 0.0f;
                    }
                    return f17;
                }
                return f16;
            }
            return -f17;
        }
        return -f16;
    }

    public float getInspectAngle() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Float) iPatchRedirector.redirect((short) 7, (Object) this)).floatValue();
        }
        return this.mInspectAngle;
    }

    public float getInspectOffsetX() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Float) iPatchRedirector.redirect((short) 5, (Object) this)).floatValue();
        }
        return this.mInspectOffsetX;
    }

    public float getInspectOffsetY() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Float) iPatchRedirector.redirect((short) 6, (Object) this)).floatValue();
        }
        return this.mInspectOffsetY;
    }

    @Override // com.tencent.ams.fusion.widget.base.SlideInspector
    public boolean inspect(PointF pointF, PointF pointF2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) pointF, (Object) pointF2)).booleanValue();
        }
        if (pointF == null || pointF2 == null) {
            return false;
        }
        return inspect(pointF2.x - pointF.x, pointF2.y - pointF.y);
    }

    public void setGestureSlideDirection(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3);
        } else {
            this.mGestureSlideDirection = i3;
        }
    }

    public void setGestureSlideValidAngle(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Float.valueOf(f16));
        } else {
            this.mGestureSlideValidAngle = f16;
        }
    }

    public void setGestureSlideValidHeightDp(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
        } else {
            this.mGestureSlideValidHeightDp = i3;
        }
    }

    private boolean inspect(float f16, float f17) {
        this.mInspectOffsetX = f16;
        this.mInspectOffsetY = f17;
        boolean z16 = false;
        if (f17 == 0.0f) {
            return false;
        }
        float calculateSlideAngle = (float) calculateSlideAngle(f16, f17);
        if (Utils.px2dp(calculateSlideDistance(f16, f17)) >= this.mGestureSlideValidHeightDp && Math.abs(calculateSlideAngle) <= this.mGestureSlideValidAngle) {
            z16 = true;
        }
        this.mInspectAngle = calculateSlideAngle;
        return z16;
    }
}
