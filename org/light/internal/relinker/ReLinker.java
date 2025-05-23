package org.light.internal.relinker;

import android.content.Context;
import java.io.File;

/* compiled from: P */
/* loaded from: classes29.dex */
public class ReLinker {

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public interface LibraryInstaller {
        void installLibrary(Context context, String[] strArr, String str, File file, ReLinkerInstance reLinkerInstance);
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public interface LibraryLoader {
        void loadLibrary(String str);

        void loadPath(String str);

        String mapLibraryName(String str);

        String[] supportedAbis();

        String unmapLibraryName(String str);
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public interface LoadListener {
        void failure(Throwable th5);

        void success();
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public interface Logger {
        void log(String str);
    }

    ReLinker() {
    }

    public static ReLinkerInstance force() {
        return new ReLinkerInstance().force();
    }

    public static void loadLibrary(Context context, String str) {
        loadLibrary(context, str, null, null);
    }

    public static ReLinkerInstance log(Logger logger) {
        return new ReLinkerInstance().log(logger);
    }

    public static ReLinkerInstance recursively() {
        return new ReLinkerInstance().recursively();
    }

    public static void loadLibrary(Context context, String str, String str2) {
        loadLibrary(context, str, str2, null);
    }

    public static void loadLibrary(Context context, String str, LoadListener loadListener) {
        loadLibrary(context, str, null, loadListener);
    }

    public static void loadLibrary(Context context, String str, String str2, LoadListener loadListener) {
        new ReLinkerInstance().loadLibrary(context, str, str2, loadListener);
    }
}
