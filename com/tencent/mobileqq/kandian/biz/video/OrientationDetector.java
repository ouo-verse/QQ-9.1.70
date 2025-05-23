package com.tencent.mobileqq.kandian.biz.video;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.view.OrientationEventListener;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes15.dex */
public class OrientationDetector {

    /* renamed from: h, reason: collision with root package name */
    public static final String f239513h = "Q.readinjoy.video." + OrientationDetector.class.getSimpleName();

    /* renamed from: a, reason: collision with root package name */
    private volatile OrientationEventListener f239514a;

    /* renamed from: c, reason: collision with root package name */
    private volatile c f239516c;

    /* renamed from: d, reason: collision with root package name */
    private WeakReference<Context> f239517d;

    /* renamed from: b, reason: collision with root package name */
    private int f239515b = 1;

    /* renamed from: e, reason: collision with root package name */
    private boolean f239518e = false;

    /* renamed from: g, reason: collision with root package name */
    private Object f239520g = new Object();

    /* renamed from: f, reason: collision with root package name */
    private HashMap<Integer, Long> f239519f = new HashMap<>();

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a extends OrientationEventListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ WeakReference f239524a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Context context, WeakReference weakReference) {
            super(context);
            this.f239524a = weakReference;
        }

        @Override // android.view.OrientationEventListener
        public void onOrientationChanged(int i3) {
            if (OrientationDetector.this.m(i3)) {
                int i16 = OrientationDetector.this.f239515b;
                if ((i3 >= 0 && i3 <= 30) || i3 > 330) {
                    i16 = 1;
                } else if (i3 > 70 && i3 <= 110) {
                    i16 = 8;
                } else if (i3 > 150 && i3 <= 210) {
                    i16 = 9;
                } else if (i3 > 250 && i3 <= 290) {
                    i16 = 0;
                }
                if (i16 != OrientationDetector.this.f239515b) {
                    OrientationDetector.this.f239515b = i16;
                    if (this.f239524a.get() != null) {
                        ((b) this.f239524a.get()).onOrientationChanged(i16);
                    }
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public interface b {
        void onOrientationChanged(int i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class c extends ContentObserver {
        public c(Handler handler) {
            super(handler);
        }

        public ContentResolver a() {
            if (OrientationDetector.this.l() != null) {
                return OrientationDetector.this.l().getContentResolver();
            }
            return null;
        }

        public void b() {
            if (a() != null) {
                a().registerContentObserver(Settings.System.getUriFor("accelerometer_rotation"), false, this);
            }
        }

        public void c() {
            if (a() != null) {
                a().unregisterContentObserver(this);
            }
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z16) {
            super.onChange(z16);
            if (OrientationDetector.this.l() == null) {
                return;
            }
            int i3 = Settings.System.getInt(OrientationDetector.this.l().getContentResolver(), "accelerometer_rotation", -1);
            if (i3 == 1) {
                OrientationDetector.this.f239518e = true;
                OrientationDetector.this.k(true);
            } else {
                OrientationDetector.this.f239518e = false;
                OrientationDetector.this.k(false);
            }
            if (QLog.isColorLevel()) {
                QLog.d(OrientationDetector.f239513h, 2, "RotationObserver.onChange() : rotateState=" + i3);
            }
        }
    }

    public OrientationDetector(final Activity activity, b bVar) {
        this.f239517d = new WeakReference<>(activity);
        synchronized (this.f239520g) {
            this.f239514a = new a(activity, new WeakReference(bVar));
        }
        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.kandian.biz.video.OrientationDetector.2
            @Override // java.lang.Runnable
            public void run() {
                OrientationDetector.this.f239515b = activity.getRequestedOrientation();
                OrientationDetector.this.f239516c = new c(new Handler(Looper.getMainLooper()));
                OrientationDetector.this.f239516c.b();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean m(int i3) {
        int i16;
        if (i3 >= 70 && i3 <= 110) {
            i16 = 1;
        } else if (i3 >= 250 && i3 <= 290) {
            i16 = 2;
        } else {
            i16 = 0;
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.f239519f.put(Integer.valueOf(i16), Long.valueOf(currentTimeMillis));
        for (Map.Entry<Integer, Long> entry : this.f239519f.entrySet()) {
            if (entry.getKey().intValue() != i16 && currentTimeMillis - entry.getValue().longValue() < 200) {
                return false;
            }
        }
        return true;
    }

    private void n(final boolean z16, final boolean z17) {
        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.kandian.biz.video.OrientationDetector.3
            @Override // java.lang.Runnable
            public void run() {
                synchronized (OrientationDetector.this.f239520g) {
                    if (QLog.isColorLevel()) {
                        QLog.d(OrientationDetector.f239513h, 2, "run: innerEnable: enable=" + z16 + ", mEventListener=" + OrientationDetector.this.f239514a);
                    }
                    if (OrientationDetector.this.f239514a == null) {
                        return;
                    }
                    try {
                        if (z16) {
                            if (OrientationDetector.this.f239514a.canDetectOrientation()) {
                                OrientationDetector.this.f239514a.enable();
                            }
                        } else {
                            OrientationDetector.this.f239514a.disable();
                        }
                    } catch (Throwable unused) {
                    }
                    if (z17) {
                        synchronized (OrientationDetector.this.f239520g) {
                            OrientationDetector.this.f239514a = null;
                        }
                    }
                }
            }
        });
    }

    public void j() {
        if (QLog.isColorLevel()) {
            QLog.d(f239513h, 2, "destory: ");
        }
        n(false, true);
        if (this.f239516c != null) {
            this.f239516c.c();
            this.f239516c = null;
        }
    }

    public boolean k(boolean z16) {
        if (this.f239514a == null) {
            return false;
        }
        if (z16) {
            if (this.f239518e) {
                n(true, false);
                return true;
            }
            if (QLog.isColorLevel()) {
                QLog.w(f239513h, 2, "mRotateSettingSwitch is false : enable failure");
            }
            return false;
        }
        n(false, false);
        return true;
    }

    public Context l() {
        WeakReference<Context> weakReference = this.f239517d;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }
}
