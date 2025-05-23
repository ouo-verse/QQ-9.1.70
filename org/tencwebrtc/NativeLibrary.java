package org.tencwebrtc;

/* compiled from: P */
/* loaded from: classes29.dex */
public class NativeLibrary {
    private static String TAG = "NativeLibrary";
    private static boolean libraryLoaded;
    private static Object lock = new Object();

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class DefaultLoader implements NativeLibraryLoader {
        @Override // org.tencwebrtc.NativeLibraryLoader
        public boolean load(String str) {
            Logging.d(NativeLibrary.TAG, "Loading library: " + str);
            try {
                System.loadLibrary(str);
                return true;
            } catch (UnsatisfiedLinkError e16) {
                Logging.e(NativeLibrary.TAG, "Failed to load native library: " + str, e16);
                return false;
            }
        }
    }

    public static void initialize(NativeLibraryLoader nativeLibraryLoader, String str) {
        synchronized (lock) {
            if (libraryLoaded) {
                Logging.d(TAG, "Native library has already been loaded.");
                return;
            }
            Logging.d(TAG, "Loading native library: " + str);
            libraryLoaded = nativeLibraryLoader.load(str);
        }
    }

    public static boolean isLoaded() {
        boolean z16;
        synchronized (lock) {
            z16 = libraryLoaded;
        }
        return z16;
    }
}
