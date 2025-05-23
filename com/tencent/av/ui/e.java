package com.tencent.av.ui;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.view.OrientationEventListener;
import com.tencent.av.mcqq.api.IAVPadOrientationSwitchApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public abstract class e extends OrientationEventListener {

    /* renamed from: h, reason: collision with root package name */
    private static List<String> f75524h = Arrays.asList("GOT-W09");

    /* renamed from: a, reason: collision with root package name */
    private boolean f75525a;

    /* renamed from: b, reason: collision with root package name */
    protected Context f75526b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f75527c;

    /* renamed from: d, reason: collision with root package name */
    private int f75528d;

    /* renamed from: e, reason: collision with root package name */
    private p f75529e;

    /* renamed from: f, reason: collision with root package name */
    private a f75530f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f75531g;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class a extends ContentObserver {

        /* renamed from: a, reason: collision with root package name */
        private ContentResolver f75532a;

        public a(Handler handler) {
            super(handler);
            BaseApplication context = BaseApplication.getContext();
            if (context == null) {
                QLog.e("RotationObserver", 2, "RotationObserver construct context as null, the auto-rotation listener when flat placed wont work!!");
            } else {
                this.f75532a = context.getContentResolver();
            }
        }

        public void a() {
            ContentResolver contentResolver = this.f75532a;
            if (contentResolver != null) {
                contentResolver.registerContentObserver(Settings.System.getUriFor("accelerometer_rotation"), false, this);
            }
        }

        public void b() {
            ContentResolver contentResolver = this.f75532a;
            if (contentResolver != null) {
                contentResolver.unregisterContentObserver(this);
            }
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z16) {
            super.onChange(z16);
            e.this.f75531g = com.tencent.av.utils.ad.g();
            if (e.this.f75531g) {
                QLog.d("RotationObserver", 2, "onChange onOrientationChanged when detect auto-rotation locked.");
                e.this.onOrientationChanged(-2);
            }
        }
    }

    public e(Context context, int i3) {
        super(context, i3);
        this.f75527c = false;
        this.f75528d = -25;
        this.f75526b = context;
        boolean p16 = com.tencent.av.utils.ad.p(context);
        this.f75525a = p16;
        if (p16) {
            this.f75529e = new p();
        }
        a aVar = new a(new Handler(Looper.getMainLooper()));
        this.f75530f = aVar;
        aVar.a();
        this.f75531g = com.tencent.av.utils.ad.g();
    }

    private boolean c(int i3, int i16) {
        int i17 = i3 - i16;
        if (i17 < 45 && i17 > -45) {
            return true;
        }
        int i18 = ((360 - (i3 % 360)) % 360) - ((360 - (i16 % 360)) % 360);
        if (i18 < 45 && i18 > -45) {
            return true;
        }
        return false;
    }

    public abstract void d(int i3, boolean z16);

    public void e() {
        a aVar = this.f75530f;
        if (aVar != null) {
            aVar.b();
        }
    }

    @Override // android.view.OrientationEventListener
    public void onOrientationChanged(int i3) {
        boolean z16;
        int i16;
        int b16;
        boolean z17;
        if (i3 == -1) {
            this.f75528d = i3;
            if (QLog.isDevelopLevel()) {
                QLog.d("AbstractOrientationEventListener", 2, "onOrientationChanged ORIENTATION_UNKNOWN. orientation: " + i3 + ", mLastOrientation: " + this.f75528d);
                return;
            }
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("AbstractOrientationEventListener", 2, "onOrientationChanged. orientation: " + i3 + ", mLastOrientation: " + this.f75528d);
        }
        if (i3 == -2) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (this.f75531g) {
            i3 = 0;
        }
        if (this.f75528d < 0) {
            this.f75528d = 0;
        }
        if (c(i3, this.f75528d) && !this.f75527c && z16) {
            return;
        }
        if (this.f75525a) {
            if (this.f75529e != null) {
                Boolean isNeedRotate90 = ((IAVPadOrientationSwitchApi) QRoute.api(IAVPadOrientationSwitchApi.class)).isNeedRotate90();
                if (isNeedRotate90 == null) {
                    isNeedRotate90 = Boolean.valueOf(this.f75529e.a());
                    QLog.d("AVPadOrientationSwitch", 1, "use old dcp config. needRotation90ByMC=" + isNeedRotate90);
                }
                z17 = isNeedRotate90.booleanValue();
            } else {
                z17 = true;
            }
            if (z17) {
                i3 -= 90;
            }
            if (i3 < 0) {
                i3 += 360;
            }
        }
        if (!f75524h.contains(DeviceInfoMonitor.getModel())) {
            if (this.f75527c) {
                b16 = pu.c.i(this.f75526b.getApplicationContext(), false, false, (byte) 0, true);
            } else {
                b16 = pu.c.b(this.f75526b.getApplicationContext(), false, false, (byte) 0, true);
            }
            i16 = b16 * 90;
        } else {
            i16 = 0;
        }
        if (i16 > 360) {
            i16 %= 360;
        }
        int i17 = i3 - i16;
        if (i17 < 0) {
            i17 += 360;
        }
        this.f75528d = i17;
        if (i17 <= 314 && i17 >= 45) {
            if (i17 > 44 && i17 < 135) {
                d(90, this.f75527c);
                return;
            } else if (i17 > 134 && i17 < 225) {
                d(180, this.f75527c);
                return;
            } else {
                d(270, this.f75527c);
                return;
            }
        }
        d(0, this.f75527c);
    }
}
