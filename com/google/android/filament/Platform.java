package com.google.android.filament;

import androidx.annotation.NonNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public abstract class Platform {
    private static Platform mCurrentPlatform;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class UnknownPlatform extends Platform {
        UnknownPlatform() {
        }

        @Override // com.google.android.filament.Platform
        long getSharedContextNativeHandle(Object obj) {
            return 0L;
        }

        @Override // com.google.android.filament.Platform
        void log(String str) {
            System.out.println(str);
        }

        @Override // com.google.android.filament.Platform
        boolean validateSharedContext(Object obj) {
            return false;
        }

        @Override // com.google.android.filament.Platform
        boolean validateStreamSource(Object obj) {
            return false;
        }

        @Override // com.google.android.filament.Platform
        boolean validateSurface(Object obj) {
            return false;
        }

        @Override // com.google.android.filament.Platform
        void warn(String str) {
            System.out.println(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public static Platform get() {
        if (mCurrentPlatform == null) {
            try {
                if (isAndroid()) {
                    int i3 = AndroidPlatform.f32954a;
                    mCurrentPlatform = (Platform) AndroidPlatform.class.newInstance();
                } else {
                    mCurrentPlatform = (Platform) Class.forName("com.google.android.filament.DesktopPlatform").newInstance();
                }
            } catch (Exception unused) {
            }
            if (mCurrentPlatform == null) {
                mCurrentPlatform = new UnknownPlatform();
            }
        }
        return mCurrentPlatform;
    }

    static boolean isAndroid() {
        return "The Android Project".equalsIgnoreCase(System.getProperty("java.vendor"));
    }

    static boolean isLinux() {
        if (System.getProperty("os.name").contains("Linux") && !isAndroid()) {
            return true;
        }
        return false;
    }

    static boolean isMacOS() {
        return System.getProperty("os.name").contains("Mac OS X");
    }

    static boolean isWindows() {
        return System.getProperty("os.name").contains("Windows");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract long getSharedContextNativeHandle(Object obj);

    abstract void log(String str);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean validateSharedContext(Object obj);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean validateStreamSource(Object obj);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean validateSurface(Object obj);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void warn(String str);
}
