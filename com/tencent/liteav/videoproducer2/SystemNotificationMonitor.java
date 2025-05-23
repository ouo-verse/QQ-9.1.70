package com.tencent.liteav.videoproducer2;

import android.os.Looper;
import android.view.OrientationEventListener;
import com.tencent.liteav.base.ContextUtils;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.util.k;
import com.tencent.liteav.base.util.r;
import com.tencent.liteav.videobase.videobase.SystemDisplayInfo;

/* compiled from: P */
@JNINamespace("liteav::video")
/* loaded from: classes7.dex */
public class SystemNotificationMonitor extends OrientationEventListener implements r.a {
    private static final int SENSOR_ROTATION_DETECTION_THRESHOLD = 30;
    private k mDisplayRotation;
    private int mLastOrientation;
    private volatile long mListenerPtr;
    private k mSensorRotation;
    private volatile r mTimer;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.liteav.videoproducer2.SystemNotificationMonitor$1, reason: invalid class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f119728a;

        static {
            int[] iArr = new int[k.values().length];
            f119728a = iArr;
            try {
                iArr[k.ROTATION_90.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f119728a[k.ROTATION_180.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f119728a[k.ROTATION_270.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f119728a[k.NORMAL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public SystemNotificationMonitor() {
        super(ContextUtils.getApplicationContext());
        this.mLastOrientation = -1;
        this.mTimer = null;
        this.mListenerPtr = 0L;
        this.mSensorRotation = null;
        this.mDisplayRotation = null;
    }

    private k getSensorRotationByDisplayRotation(k kVar) {
        if (kVar == null) {
            return k.NORMAL;
        }
        int i3 = AnonymousClass1.f119728a[kVar.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    return k.NORMAL;
                }
                return k.ROTATION_90;
            }
            return k.ROTATION_180;
        }
        return k.ROTATION_270;
    }

    private k getSensorRotationCorrection() {
        if (this.mListenerPtr == 0) {
            return null;
        }
        int nativeGetGravitySensorRotationCorrection = nativeGetGravitySensorRotationCorrection(this.mListenerPtr);
        if (!k.b(nativeGetGravitySensorRotationCorrection)) {
            return null;
        }
        return k.a(nativeGetGravitySensorRotationCorrection);
    }

    private static native synchronized int nativeGetGravitySensorRotationCorrection(long j3);

    private static native void nativeSensorChanged(long j3, int i3, int i16);

    private synchronized void notifyOrientationChanged() {
        int i3;
        if (this.mListenerPtr == 0) {
            return;
        }
        int i16 = 0;
        if (getSensorRotationCorrection() != null) {
            i3 = getSensorRotationCorrection().mValue;
        } else {
            k kVar = this.mSensorRotation;
            if (kVar != null) {
                i3 = kVar.mValue;
            } else {
                i3 = 0;
            }
        }
        k kVar2 = this.mDisplayRotation;
        if (kVar2 != null) {
            i16 = kVar2.mValue;
        }
        nativeSensorChanged(this.mListenerPtr, i3, i16);
    }

    public synchronized void initialize(long j3) {
        this.mListenerPtr = j3;
        if (this.mTimer != null) {
            return;
        }
        super.enable();
        this.mTimer = new r(Looper.getMainLooper(), this);
        this.mTimer.a(200);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    @Override // android.view.OrientationEventListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onOrientationChanged(int i3) {
        k kVar;
        if (i3 == -1) {
            return;
        }
        int i16 = this.mLastOrientation;
        if (i16 != -1 && Math.abs(i3 - i16) <= 30) {
            return;
        }
        this.mLastOrientation = i3;
        if (i3 > 45) {
            if (i3 <= 135) {
                kVar = k.ROTATION_90;
            } else if (i3 <= 225) {
                kVar = k.ROTATION_180;
            } else if (i3 <= 315) {
                kVar = k.ROTATION_270;
            }
            if (this.mSensorRotation == kVar) {
                this.mSensorRotation = kVar;
                this.mDisplayRotation = k.a(SystemDisplayInfo.getDisplayRotationDegree());
                notifyOrientationChanged();
                return;
            }
            return;
        }
        kVar = k.NORMAL;
        if (this.mSensorRotation == kVar) {
        }
    }

    @Override // com.tencent.liteav.base.util.r.a
    public void onTimeout() {
        k a16 = k.a(SystemDisplayInfo.getDisplayRotationDegree());
        if (this.mDisplayRotation == a16) {
            return;
        }
        this.mDisplayRotation = a16;
        if (this.mSensorRotation == null) {
            this.mSensorRotation = getSensorRotationByDisplayRotation(a16);
        }
        notifyOrientationChanged();
    }

    public synchronized void uninitialize() {
        super.disable();
        this.mListenerPtr = 0L;
        if (this.mTimer != null) {
            this.mTimer.a();
            this.mTimer = null;
        }
    }
}
