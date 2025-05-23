package com.getkeepsafe.relinker;

import android.content.Context;
import java.io.File;

/* compiled from: P */
/* loaded from: classes2.dex */
public class b {

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface a {
        void a(Context context, String[] strArr, String str, File file, ReLinkerInstance reLinkerInstance);
    }

    /* compiled from: P */
    /* renamed from: com.getkeepsafe.relinker.b$b, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0224b {
        void loadLibrary(String str);

        void loadPath(String str);

        String mapLibraryName(String str);

        String[] supportedAbis();

        String unmapLibraryName(String str);
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface c {
    }

    public static void a(Context context, String str) {
        b(context, str, null, null);
    }

    public static void b(Context context, String str, String str2, c cVar) {
        new ReLinkerInstance().f(context, str, str2, cVar);
    }
}
