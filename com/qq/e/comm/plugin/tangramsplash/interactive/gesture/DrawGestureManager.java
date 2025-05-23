package com.qq.e.comm.plugin.tangramsplash.interactive.gesture;

import android.annotation.SuppressLint;
import android.gesture.Gesture;
import android.gesture.GestureOverlayView;
import android.gesture.GestureStroke;
import android.os.Vibrator;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.qq.e.comm.plugin.base.ad.model.InteractiveInfo;
import com.qq.e.comm.plugin.k.ba;
import com.qq.e.comm.plugin.tangramsplash.interactive.e;
import com.qq.e.comm.util.GDTLogger;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes3.dex */
public class DrawGestureManager implements GestureOverlayView.OnGestureListener, GestureOverlayView.OnGesturePerformedListener {

    /* renamed from: f, reason: collision with root package name */
    private static volatile DrawGestureManager f40296f;

    /* renamed from: a, reason: collision with root package name */
    private List<a> f40297a = new CopyOnWriteArrayList();

    /* renamed from: b, reason: collision with root package name */
    private WeakReference<GestureOverlayView> f40298b;

    /* renamed from: c, reason: collision with root package name */
    private InteractiveInfo f40299c;

    /* renamed from: d, reason: collision with root package name */
    private Vibrator f40300d;

    /* renamed from: e, reason: collision with root package name */
    private ViewConfiguration f40301e;

    /* renamed from: g, reason: collision with root package name */
    private float f40302g;

    /* renamed from: h, reason: collision with root package name */
    private float f40303h;

    /* renamed from: i, reason: collision with root package name */
    private float f40304i;

    /* renamed from: j, reason: collision with root package name */
    private float f40305j;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface ClickInfo {
        public static final String DOWN_X = "DOWN_X";
        public static final String DOWN_Y = "DOWN_Y";
        public static final String UP_X = "UP_X";
        public static final String UP_Y = "UP_Y";
    }

    DrawGestureManager() {
    }

    private Map<String, String> b(Gesture gesture) {
        float[] fArr;
        if (gesture == null) {
            return null;
        }
        ArrayList<GestureStroke> strokes = gesture.getStrokes();
        if (strokes != null && strokes.size() != 0) {
            GestureStroke gestureStroke = strokes.get(0);
            if (gestureStroke == null || (fArr = gestureStroke.points) == null || fArr.length < 2) {
                return null;
            }
            float f16 = fArr[0];
            float f17 = fArr[1];
            float f18 = fArr[fArr.length - 2];
            float f19 = fArr[fArr.length - 1];
            HashMap hashMap = new HashMap();
            hashMap.put(ClickInfo.DOWN_X, String.valueOf(f16));
            hashMap.put(ClickInfo.DOWN_Y, String.valueOf(f17));
            hashMap.put(ClickInfo.UP_X, String.valueOf(f18));
            hashMap.put(ClickInfo.UP_Y, String.valueOf(f19));
            return hashMap;
        }
        GDTLogger.i("onGesturePerformed: empty strokes");
        return null;
    }

    private void c() {
        List<a> list = this.f40297a;
        if (list != null) {
            for (a aVar : list) {
                if (aVar != null) {
                    aVar.a();
                }
            }
        }
    }

    @Override // android.gesture.GestureOverlayView.OnGestureListener
    public void onGestureCancelled(GestureOverlayView gestureOverlayView, MotionEvent motionEvent) {
        GDTLogger.d("onGestureCancelled");
    }

    @Override // android.gesture.GestureOverlayView.OnGestureListener
    public void onGestureEnded(GestureOverlayView gestureOverlayView, MotionEvent motionEvent) {
        GDTLogger.d("onGestureEnded");
        this.f40304i += Math.abs(motionEvent.getX() - this.f40302g);
        this.f40305j += Math.abs(motionEvent.getY() - this.f40303h);
        this.f40302g = motionEvent.getX();
        this.f40303h = motionEvent.getY();
        float f16 = this.f40304i;
        float f17 = this.f40305j;
        if ((f16 * f16) + (f17 * f17) <= this.f40301e.getScaledTouchSlop() * this.f40301e.getScaledTouchSlop()) {
            GDTLogger.d("interactive ad, action is click");
            a(false, (Map<String, String>) null);
        } else if (gestureOverlayView != null) {
            a(gestureOverlayView.getGesture());
        }
    }

    @Override // android.gesture.GestureOverlayView.OnGestureListener
    public void onGestureStarted(GestureOverlayView gestureOverlayView, MotionEvent motionEvent) {
        this.f40302g = motionEvent.getX();
        this.f40303h = motionEvent.getY();
        this.f40304i = 0.0f;
        this.f40305j = 0.0f;
        GDTLogger.d("onGestureStarted");
        c();
    }

    public static DrawGestureManager a() {
        if (f40296f == null) {
            synchronized (DrawGestureManager.class) {
                if (f40296f == null) {
                    f40296f = new DrawGestureManager();
                }
            }
        }
        return f40296f;
    }

    @SuppressLint({"MissingPermission"})
    private void a(Gesture gesture) {
        Vibrator vibrator;
        boolean a16 = e.a(gesture, this.f40299c);
        if (a16 && (vibrator = this.f40300d) != null) {
            vibrator.vibrate(200L);
        }
        a(a16, b(gesture));
        GDTLogger.d("interactive ad, checkGestureResult: " + a16);
    }

    private void a(boolean z16, Map<String, String> map) {
        List<a> list = this.f40297a;
        if (list != null) {
            for (a aVar : list) {
                if (aVar != null) {
                    aVar.a(z16, map);
                }
            }
        }
    }

    public void b() {
        List<a> list = this.f40297a;
        if (list != null) {
            list.clear();
        }
        WeakReference<GestureOverlayView> weakReference = this.f40298b;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.f40298b.get().removeOnGestureListener(this);
        this.f40298b.get().removeOnGesturePerformedListener(this);
        this.f40298b.get().post(new Runnable() { // from class: com.qq.e.comm.plugin.tangramsplash.interactive.gesture.DrawGestureManager.1
            @Override // java.lang.Runnable
            public void run() {
                if (DrawGestureManager.this.f40298b != null && DrawGestureManager.this.f40298b.get() != null) {
                    ba.a((View) DrawGestureManager.this.f40298b.get());
                    DrawGestureManager.this.f40298b = null;
                }
            }
        });
    }

    @Override // android.gesture.GestureOverlayView.OnGestureListener
    public void onGesture(GestureOverlayView gestureOverlayView, MotionEvent motionEvent) {
    }

    @Override // android.gesture.GestureOverlayView.OnGesturePerformedListener
    public void onGesturePerformed(GestureOverlayView gestureOverlayView, Gesture gesture) {
    }
}
