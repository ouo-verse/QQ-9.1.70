package com.tencent.xweb;

import android.content.Context;
import com.tencent.luggage.wxa.ar.x0;
import com.tencent.rfix.loader.utils.RFixConstants;
import java.io.File;

/* compiled from: P */
/* loaded from: classes27.dex */
public class LibraryLoader {

    /* renamed from: a, reason: collision with root package name */
    public static ILibraryLoader f384958a;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface ILibraryLoader {
        String findLibrary(Context context, String str);

        void loadLibrary(String str);
    }

    public static String findLibrary(Context context, String str) {
        String findLibrary;
        ILibraryLoader iLibraryLoader = f384958a;
        if (iLibraryLoader != null && (findLibrary = iLibraryLoader.findLibrary(context, str)) != null) {
            x0.d("LibraryLoader", "findLibrary, use custom library loader, path:" + findLibrary);
            return findLibrary;
        }
        if (context != null) {
            String str2 = context.getApplicationInfo().nativeLibraryDir;
            File file = new File(str2, RFixConstants.SO_PATH + str + ".so");
            if (!file.isDirectory() && file.canRead()) {
                String absolutePath = file.getAbsolutePath();
                x0.d("LibraryLoader", "findLibrary, use system library loader, path:" + absolutePath);
                return absolutePath;
            }
            x0.f("LibraryLoader", "findLibrary, nativeLibraryDir:" + str2);
        } else {
            x0.f("LibraryLoader", "findLibrary, invalid context");
        }
        x0.d("LibraryLoader", "findLibrary, can not find library:" + str);
        return null;
    }

    public static void loadLibrary(String str) {
        ILibraryLoader iLibraryLoader = f384958a;
        if (iLibraryLoader != null) {
            iLibraryLoader.loadLibrary(str);
            x0.d("LibraryLoader", "loadLibrary, use custom library loader, lib:" + str);
            return;
        }
        System.loadLibrary(str);
        x0.d("LibraryLoader", "loadLibrary, use system library loader, lib:" + str);
    }

    @DeprecatedOutsideXWebSdk
    @Deprecated
    public static void setLibraryLoader(ILibraryLoader iLibraryLoader) {
        f384958a = iLibraryLoader;
    }
}
