package com.tencent.mm.plugin.appbrand.widget.base;

import android.annotation.TargetApi;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Keep;
import com.tencent.luggage.wxa.ll.c;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class AppBrandViewMotionCompat {

    /* renamed from: a, reason: collision with root package name */
    public static MotionEvent.PointerCoords[] f152367a;

    /* renamed from: b, reason: collision with root package name */
    public static MotionEvent.PointerProperties[] f152368b;

    /* renamed from: c, reason: collision with root package name */
    public static int[] f152369c;

    public static boolean a(View view) {
        return view.getVisibility() == 0 || view.getAnimation() != null;
    }

    public static Matrix b(View view) {
        if (view == null) {
            return null;
        }
        Matrix matrix = (Matrix) view.getTag(R.id.suo);
        if (matrix == null) {
            matrix = new Matrix();
            view.setTag(R.id.suo, matrix);
        }
        view.getMatrix().invert(matrix);
        return matrix;
    }

    public static boolean c(View view) {
        return view.getMatrix().isIdentity();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean d(View view) {
        if (view != 0 && (view instanceof c) && ((c) view).c()) {
            return true;
        }
        return false;
    }

    @Keep
    @TargetApi(11)
    public static boolean dispatchTransformedTouchEvent(ViewGroup viewGroup, MotionEvent motionEvent, boolean z16, View view, int i3) {
        MotionEvent a16;
        if (viewGroup == null || motionEvent == null) {
            return false;
        }
        int action = motionEvent.getAction();
        if (!z16 && action != 3) {
            int a17 = a(motionEvent);
            int i16 = i3 & a17;
            if (i16 == 0) {
                return false;
            }
            if (i16 == a17) {
                if (view != null && !c(view)) {
                    a16 = MotionEvent.obtain(motionEvent);
                } else {
                    if (view == null) {
                        return false;
                    }
                    float scrollX = viewGroup.getScrollX() - view.getLeft();
                    float scrollY = viewGroup.getScrollY() - view.getTop();
                    motionEvent.offsetLocation(scrollX, scrollY);
                    boolean dispatchTouchEvent = view.dispatchTouchEvent(motionEvent);
                    motionEvent.offsetLocation(-scrollX, -scrollY);
                    return dispatchTouchEvent;
                }
            } else {
                try {
                    a16 = a(motionEvent, i16);
                } catch (IllegalArgumentException e16) {
                    w.h("MicroMsg.AppBrandViewMotionCompat", "dispatchTransformedTouchEvent e=%s", e16.getMessage());
                    return false;
                }
            }
            if (view == null) {
                return false;
            }
            a16.offsetLocation(viewGroup.getScrollX() - view.getLeft(), viewGroup.getScrollY() - view.getTop());
            if (!c(view)) {
                Matrix matrix = view.getMatrix();
                matrix.invert(matrix);
                a16.transform(matrix);
            }
            boolean dispatchTouchEvent2 = view.dispatchTouchEvent(a16);
            a16.recycle();
            return dispatchTouchEvent2;
        }
        motionEvent.setAction(3);
        if (view == null) {
            return false;
        }
        boolean dispatchTouchEvent3 = view.dispatchTouchEvent(motionEvent);
        motionEvent.setAction(action);
        return dispatchTouchEvent3;
    }

    public static boolean a(ViewGroup viewGroup, float f16, float f17, View view, PointF pointF) {
        float[] fArr = {0.0f, 0.0f};
        fArr[0] = f16 + (viewGroup.getScrollX() - view.getLeft());
        fArr[1] = f17 + (viewGroup.getScrollY() - view.getTop());
        Matrix matrix = view.getMatrix();
        if (!matrix.isIdentity()) {
            matrix.invert(matrix);
            matrix.mapPoints(fArr);
        }
        float f18 = fArr[0];
        boolean z16 = f18 >= 0.0f && fArr[1] >= 0.0f && f18 < ((float) (view.getRight() - view.getLeft())) && fArr[1] < ((float) (view.getBottom() - view.getTop()));
        if (z16 && pointF != null) {
            pointF.set(fArr[0], fArr[1]);
        }
        return z16;
    }

    public static void c(int i3) {
        MotionEvent.PointerCoords[] pointerCoordsArr = f152367a;
        if (pointerCoordsArr == null || pointerCoordsArr.length < i3) {
            int length = pointerCoordsArr != null ? pointerCoordsArr.length : 8;
            while (length < i3) {
                length *= 2;
            }
            f152367a = a(length);
            f152368b = b(length);
            f152369c = new int[length];
        }
    }

    public static MotionEvent.PointerProperties[] b(int i3) {
        MotionEvent.PointerProperties[] pointerPropertiesArr = new MotionEvent.PointerProperties[i3];
        for (int i16 = 0; i16 < i3; i16++) {
            pointerPropertiesArr[i16] = new MotionEvent.PointerProperties();
        }
        return pointerPropertiesArr;
    }

    public static int a(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        int i3 = 0;
        for (int i16 = 0; i16 < pointerCount; i16++) {
            i3 |= 1 << motionEvent.getPointerId(i16);
        }
        return i3;
    }

    public static MotionEvent.PointerCoords[] a(int i3) {
        MotionEvent.PointerCoords[] pointerCoordsArr = new MotionEvent.PointerCoords[i3];
        for (int i16 = 0; i16 < i3; i16++) {
            pointerCoordsArr[i16] = new MotionEvent.PointerCoords();
        }
        return pointerCoordsArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0068  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static MotionEvent a(MotionEvent motionEvent, int i3) {
        int i16;
        int historySize;
        int i17;
        int i18;
        int i19;
        int i26;
        int i27;
        int i28;
        MotionEvent.PointerCoords[] pointerCoordsArr;
        MotionEvent motionEvent2 = motionEvent;
        if (Looper.getMainLooper() == Looper.myLooper()) {
            int pointerCount = motionEvent.getPointerCount();
            c(pointerCount);
            MotionEvent.PointerProperties[] pointerPropertiesArr = f152368b;
            MotionEvent.PointerCoords[] pointerCoordsArr2 = f152367a;
            int[] iArr = f152369c;
            int action = motionEvent.getAction();
            int i29 = action & 255;
            int i36 = (65280 & action) >> 8;
            int i37 = 0;
            int i38 = -1;
            int i39 = 0;
            for (int i46 = 0; i46 < pointerCount; i46++) {
                motionEvent2.getPointerProperties(i46, pointerPropertiesArr[i39]);
                if (((1 << pointerPropertiesArr[i39].id) & i3) != 0) {
                    if (i46 == i36) {
                        i38 = i39;
                    }
                    iArr[i39] = i46;
                    i39++;
                }
            }
            if (i39 != 0) {
                if (i29 == 5 || i29 == 6) {
                    if (i38 < 0) {
                        action = 2;
                    } else {
                        if (i39 == 1) {
                            i16 = i29 == 5 ? 0 : 1;
                            historySize = motionEvent.getHistorySize();
                            MotionEvent motionEvent3 = null;
                            i17 = 0;
                            while (i17 <= historySize) {
                                int i47 = i17 == historySize ? Integer.MIN_VALUE : i17;
                                for (int i48 = i37; i48 < i39; i48++) {
                                    motionEvent2.getHistoricalPointerCoords(iArr[i48], i47, pointerCoordsArr2[i48]);
                                }
                                long historicalEventTime = motionEvent2.getHistoricalEventTime(i47);
                                if (i17 == 0) {
                                    i19 = i17;
                                    i26 = historySize;
                                    i27 = i39;
                                    i28 = i37;
                                    i18 = i16;
                                    pointerCoordsArr = pointerCoordsArr2;
                                    motionEvent3 = MotionEvent.obtain(motionEvent.getDownTime(), motionEvent.getEventTime(), i16, i39, pointerPropertiesArr, pointerCoordsArr2, motionEvent.getMetaState(), motionEvent.getButtonState(), motionEvent.getXPrecision(), motionEvent.getYPrecision(), motionEvent.getDeviceId(), motionEvent.getEdgeFlags(), motionEvent.getSource(), motionEvent.getFlags());
                                    motionEvent3.offsetLocation(motionEvent3.getX() - motionEvent3.getRawX(), motionEvent3.getY() - motionEvent3.getRawY());
                                } else {
                                    i18 = i16;
                                    i19 = i17;
                                    i26 = historySize;
                                    i27 = i39;
                                    i28 = i37;
                                    pointerCoordsArr = pointerCoordsArr2;
                                    motionEvent3.addBatch(historicalEventTime, pointerCoordsArr, i28);
                                }
                                i17 = i19 + 1;
                                i37 = i28;
                                pointerCoordsArr2 = pointerCoordsArr;
                                historySize = i26;
                                i39 = i27;
                                motionEvent2 = motionEvent;
                                i16 = i18;
                            }
                            return motionEvent3;
                        }
                        action = i29 | (i38 << 8);
                    }
                }
                i16 = action;
                historySize = motionEvent.getHistorySize();
                MotionEvent motionEvent32 = null;
                i17 = 0;
                while (i17 <= historySize) {
                }
                return motionEvent32;
            }
            throw new IllegalArgumentException("idBits did not match any ids in the event");
        }
        throw new RuntimeException("Should be called on main-thread");
    }
}
