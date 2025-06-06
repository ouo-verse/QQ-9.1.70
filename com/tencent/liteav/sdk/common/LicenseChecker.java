package com.tencent.liteav.sdk.common;

import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.util.SoLoader;

/* compiled from: P */
@JNINamespace("liteav::license")
/* loaded from: classes7.dex */
public class LicenseChecker {
    private b mLicenceCheckListener;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public enum a {
        PUSHER(1),
        UGC_SIMPLE(2),
        UGC_STANDARD(4),
        PITU_SIMPLE(8),
        PITU(16),
        PLAYER_STANDARD(32),
        PLAYER_MONET(64),
        PLAYER_PREMIUM(128),
        PLAYER_ENTERPRISE(256),
        PLAYER_PROJECTION(512);

        int value;

        a(int i3) {
            this.value = i3;
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface b {
        void a(int i3, String str);
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public enum c {
        LIVE,
        UGC
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public enum d {
        OK(0),
        ERROR_JSON_FORMAT(-1),
        ERROR_SIGNATURE(-2),
        ERROR_DECODE(-3),
        ERROR_PACKAGE(-4),
        ERROR_FEATURE(-5),
        ERROR_INNER_NOT_EXIST(-6),
        ERROR_LOCAL_NOT_EXIST(-7),
        ERROR_CONTENT_EMPTY(-8),
        ERROR_WRITE_LICENSE(-9),
        ERROR_WRITE_PITU_LICENSE(-10),
        ERROR_EXPIRED(-11),
        ERROR_DOWNLOAD(-12),
        ERROR_NO_AUTHORIZATION(-13),
        ERROR_UNKNOWN(-14);

        int value;

        d(int i3) {
            this.value = i3;
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    static class e {

        /* renamed from: a, reason: collision with root package name */
        public static LicenseChecker f119103a = new LicenseChecker();
    }

    static {
        SoLoader.loadAllLibraries();
    }

    public static LicenseChecker getInstance() {
        return e.f119103a;
    }

    private static native String nativeGetAppId();

    private static native String nativeGetKey(int i3);

    private static native String nativeGetLicense(int i3);

    private static native void nativeSetClient(LicenseChecker licenseChecker);

    private static native boolean nativeSetLicense(int i3, String str, String str2);

    private static native int nativeValid(int i3);

    public void OnResult(int i3, String str) {
        b bVar = this.mLicenceCheckListener;
        if (bVar != null) {
            bVar.a(i3, str);
        }
    }

    public String getAppId() {
        return nativeGetAppId();
    }

    public String getKey(c cVar) {
        return nativeGetKey(cVar.ordinal());
    }

    public String getLicense(c cVar) {
        return nativeGetLicense(cVar.ordinal());
    }

    public boolean setLicense(c cVar, String str, String str2) {
        return nativeSetLicense(cVar.ordinal(), str, str2);
    }

    public void setListener(b bVar) {
        this.mLicenceCheckListener = bVar;
        if (bVar != null) {
            nativeSetClient(this);
        }
    }

    public d valid(a aVar) {
        int nativeValid = nativeValid(aVar.value);
        for (d dVar : d.values()) {
            if (dVar.value == nativeValid) {
                return dVar;
            }
        }
        return d.ERROR_UNKNOWN;
    }
}
