package com.tencent.tav.coremedia;

import android.support.annotation.NonNull;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes26.dex */
public class CMTime implements Cloneable {
    public static final int DEFAULT_TIME_SCALE = 600;
    private static final long SECONDS_MS = 1000;
    private static final long SECONDS_US = 1000000;
    private int flag;
    private final float time;
    public final int timeScale;
    private final long timeUs;
    public final long value;
    public static final CMTime CMTimeZero = new CMTime(0, 600);
    public static final CMTime CMTimeOne = new CMTime(600, 600);
    public static final CMTime CMTimeInvalid = new CMTime(Long.MIN_VALUE, 600, -1.0f, -1);

    public CMTime() {
        this(0L, 600);
    }

    public static int GCD(int i3, int i16) {
        if (i3 == 0) {
            return i16;
        }
        return GCD(i16 % i3, i3);
    }

    public static int LCM(int i3, int i16) {
        return (i3 / GCD(i3, i16)) * i16;
    }

    public static CMTime add(CMTime cMTime, CMTime cMTime2) {
        CMTime cMTime3;
        if (cMTime == null || cMTime == (cMTime3 = CMTimeInvalid)) {
            return cMTime2.m259clone();
        }
        if (cMTime2 != null && cMTime2 != cMTime3) {
            int LCM = LCM(cMTime.timeScale, cMTime2.timeScale);
            CMTime convertTimeScale = convertTimeScale(cMTime, LCM);
            return new CMTime(convertTimeScale.getValue() + convertTimeScale(cMTime2, LCM).getValue(), convertTimeScale.timeScale);
        }
        return cMTime.m259clone();
    }

    public static CMTime convertTimeScale(@NonNull CMTime cMTime, int i3) {
        Utils.checkNotNull(cMTime);
        CMTime cMTime2 = CMTimeInvalid;
        if (cMTime == cMTime2) {
            return cMTime2;
        }
        if (cMTime == CMTimeZero) {
            return new CMTime(0L, i3);
        }
        return new CMTime((cMTime.getValue() * i3) / cMTime.getTimeScale(), i3);
    }

    public static CMTime fromMs(long j3) {
        return new CMTime((((float) j3) * 1.0f) / 1000.0f);
    }

    public static CMTime fromSeconds(float f16) {
        return new CMTime(f16);
    }

    public static CMTime fromUs(long j3) {
        return new CMTime((((float) j3) * 1.0f) / 1000000.0f);
    }

    public static CMTime max(CMTime cMTime, CMTime cMTime2) {
        if (cMTime.bigThan(cMTime2)) {
            return cMTime;
        }
        return cMTime2;
    }

    public static CMTime min(CMTime cMTime, CMTime cMTime2) {
        if (cMTime.smallThan(cMTime2)) {
            return cMTime;
        }
        return cMTime2;
    }

    public static CMTime sub(CMTime cMTime, CMTime cMTime2) {
        CMTime cMTime3;
        if (cMTime == null || cMTime == (cMTime3 = CMTimeInvalid)) {
            return new CMTime(-cMTime2.getValue());
        }
        if (cMTime2 != null && cMTime2 != cMTime3) {
            int LCM = LCM(cMTime.timeScale, cMTime2.timeScale);
            CMTime convertTimeScale = convertTimeScale(cMTime, LCM);
            return new CMTime(convertTimeScale.getValue() - convertTimeScale(cMTime2, LCM).getValue(), convertTimeScale.timeScale);
        }
        return cMTime.m259clone();
    }

    public boolean bigThan(CMTime cMTime) {
        if (cMTime == null || getTimeUs() > cMTime.getTimeUs()) {
            return true;
        }
        return false;
    }

    public int compare(CMTime cMTime) {
        if (cMTime == null) {
            return 1;
        }
        long timeUs = getTimeUs() - cMTime.getTimeUs();
        if (timeUs > 0) {
            return 1;
        }
        if (timeUs == 0) {
            return 0;
        }
        return -1;
    }

    public CMTime divide(float f16) {
        CMTime cMTime = CMTimeInvalid;
        return this == cMTime ? cMTime : new CMTime(((float) getValue()) / f16, this.timeScale);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof CMTime)) {
            return false;
        }
        CMTime cMTime = (CMTime) obj;
        if (this.value != cMTime.value || this.timeScale != cMTime.timeScale) {
            return false;
        }
        return true;
    }

    public boolean equalsTo(CMTime cMTime) {
        if (cMTime == null || getTimeUs() != cMTime.getTimeUs()) {
            return false;
        }
        return true;
    }

    public int getFlag() {
        return this.flag;
    }

    public int getTimeScale() {
        return this.timeScale;
    }

    public float getTimeSeconds() {
        return this.time;
    }

    public long getTimeUs() {
        return this.timeUs;
    }

    public long getValue() {
        return this.value;
    }

    public CMTime limitMax(@NonNull CMTime cMTime) {
        Utils.checkNotNull(cMTime);
        if (bigThan(cMTime)) {
            return cMTime;
        }
        return this;
    }

    public CMTime limitMin(@NonNull CMTime cMTime) {
        Utils.checkNotNull(cMTime);
        if (smallThan(cMTime)) {
            return cMTime;
        }
        return this;
    }

    public CMTime multi(float f16) {
        CMTime cMTime = CMTimeInvalid;
        return this == cMTime ? cMTime : new CMTime(((float) getValue()) * f16, this.timeScale);
    }

    public void setFlag(int i3) {
        this.flag = i3;
    }

    public boolean smallThan(CMTime cMTime) {
        if (cMTime == null || getTimeUs() >= cMTime.getTimeUs()) {
            return false;
        }
        return true;
    }

    public String toString() {
        return "[value = " + this.value + " timeScale = " + this.timeScale + " timeUs = " + this.timeUs + " flag = " + this.flag + "]";
    }

    public CMTime(long j3) {
        this(j3, 600);
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public CMTime m259clone() {
        return new CMTime(this.value, this.timeScale, this.time, this.timeUs);
    }

    public CMTime(float f16) {
        this(f16 * 600.0f, 600);
    }

    public CMTime divide(CMTime cMTime) {
        int LCM = LCM(this.timeScale, cMTime.timeScale);
        return new CMTime(convertTimeScale(this, LCM).value / convertTimeScale(cMTime, LCM).value, LCM);
    }

    public CMTime multi(CMTime cMTime) {
        CMTime cMTime2 = CMTimeInvalid;
        if (this != cMTime2 && cMTime != null && cMTime != cMTime2) {
            int LCM = LCM(this.timeScale, cMTime.timeScale);
            return new CMTime(convertTimeScale(this, LCM).value * convertTimeScale(cMTime, LCM).value, LCM);
        }
        return CMTimeZero;
    }

    public CMTime(long j3, int i3) {
        this.flag = 0;
        this.value = j3;
        this.timeScale = i3;
        this.time = (((float) j3) * 1.0f) / i3;
        this.timeUs = (j3 * 1000000) / i3;
    }

    public CMTime add(long j3) {
        if (this == CMTimeInvalid) {
            return m259clone();
        }
        return new CMTime(getValue() + ((j3 * this.timeScale) / TimeUnit.SECONDS.toMicros(1L)), this.timeScale);
    }

    public CMTime sub(CMTime cMTime) {
        return sub(this, cMTime);
    }

    CMTime(long j3, int i3, float f16, long j16) {
        this.flag = 0;
        this.value = j3;
        this.timeUs = j16;
        this.time = f16;
        this.timeScale = i3;
    }

    public CMTime add(CMTime cMTime) {
        return add(this, cMTime);
    }
}
