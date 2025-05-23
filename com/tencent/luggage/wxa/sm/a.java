package com.tencent.luggage.wxa.sm;

import android.text.TextUtils;
import com.tencent.luggage.wxa.aa.h;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.qqmusic.mediaplayer.AudioPlayerConfigure;
import com.tencent.qqmusic.mediaplayer.ILog;
import com.tencent.qqmusic.mediaplayer.ISoLibraryLoader;
import com.tencent.qqmusic.mediaplayer.NativeLibs;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static final String f140392a = "MicroMsg.Audio.AudioPlayerUtils";

    /* renamed from: b, reason: collision with root package name */
    private static com.tencent.luggage.wxa.sm.c f140393b = new d(null);

    /* renamed from: c, reason: collision with root package name */
    private static boolean f140394c = false;

    /* renamed from: d, reason: collision with root package name */
    private static boolean f140395d = false;

    /* renamed from: e, reason: collision with root package name */
    public static final Set<String> f140396e = new HashSet(Arrays.asList(NativeLibs.nlog.getName(), NativeLibs.audioCommon.getName()));

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.sm.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C6723a implements ILog {
        @Override // com.tencent.qqmusic.mediaplayer.ILog
        public void d(String str, String str2) {
            w.a(str, str2);
        }

        @Override // com.tencent.qqmusic.mediaplayer.ILog
        public void e(String str, String str2) {
            w.b(str, str2);
        }

        @Override // com.tencent.qqmusic.mediaplayer.ILog
        public void i(String str, String str2) {
            w.d(str, str2);
        }

        @Override // com.tencent.qqmusic.mediaplayer.ILog
        public void w(String str, String str2) {
            w.f(str, str2);
        }

        @Override // com.tencent.qqmusic.mediaplayer.ILog
        public void e(String str, Throwable th5) {
            w.a(str, th5, " throwable", new Object[0]);
        }

        @Override // com.tencent.qqmusic.mediaplayer.ILog
        public void i(String str, String str2, Throwable th5) {
            w.a(str, th5, str2, new Object[0]);
        }

        @Override // com.tencent.qqmusic.mediaplayer.ILog
        public void e(String str, String str2, Throwable th5) {
            w.a(str, th5, str2, new Object[0]);
        }

        @Override // com.tencent.qqmusic.mediaplayer.ILog
        public void e(String str, String str2, Object... objArr) {
            w.b(str, String.format(str2, objArr));
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements ISoLibraryLoader {
        @Override // com.tencent.qqmusic.mediaplayer.ISoLibraryLoader
        public String findLibPath(String str) {
            if (a.f140393b != null) {
                return a.f140393b.findLibPath(str);
            }
            return null;
        }

        @Override // com.tencent.qqmusic.mediaplayer.ISoLibraryLoader
        public boolean load(String str) {
            if (a.f140393b != null) {
                return a.f140393b.load(str);
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            a.b();
            boolean unused = a.f140395d = false;
        }
    }

    public static synchronized boolean b() {
        synchronized (a.class) {
            if (f140394c) {
                return true;
            }
            com.tencent.luggage.wxa.sm.c cVar = f140393b;
            if (cVar == null) {
                return false;
            }
            NativeLibs nativeLibs = NativeLibs.nlog;
            cVar.load(nativeLibs.getName());
            f140393b.load(NativeLibs.audioCommon.getName());
            if (f140393b.a(nativeLibs.getName())) {
                try {
                    f140394c = AudioPlayerConfigure.enableNativeLog(null);
                } catch (Throwable th5) {
                    w.a(f140392a, th5, "checkNLogLoad", new Object[0]);
                    if (com.tencent.luggage.wxa.aa.a.a(20)) {
                        f140394c = AudioPlayerConfigure.enableNativeLog(null);
                    } else {
                        throw th5;
                    }
                }
                if (f140394c) {
                    w.d(f140392a, "enableNativeLog success");
                }
                return f140394c;
            }
            w.d(f140392a, "enableNativeLog fail");
            return false;
        }
    }

    public static void c() {
        w.d(f140392a, "configQQMusicSdkConfig");
        AudioPlayerConfigure.setLog(new C6723a());
        AudioPlayerConfigure.setSoLibraryLoader(new b());
        d();
    }

    private static void d() {
        if (f140394c || f140395d) {
            return;
        }
        f140395d = true;
        com.tencent.luggage.wxa.co.a.a(new c(), "audio load NLog");
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class d implements com.tencent.luggage.wxa.sm.c {

        /* renamed from: a, reason: collision with root package name */
        private final HashMap<String, Boolean> f140397a;

        d() {
            this.f140397a = new HashMap<>();
        }

        @Override // com.tencent.luggage.wxa.sm.c
        public boolean a(String str) {
            if (this.f140397a.containsKey(str)) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.luggage.wxa.sm.c
        public String findLibPath(String str) {
            w.d(a.f140392a, "findLibPath %s", str);
            if (a.f140396e.contains(str)) {
                return h.d(str);
            }
            return h.c(str);
        }

        @Override // com.tencent.luggage.wxa.sm.c
        public boolean load(String str) {
            if (TextUtils.isEmpty(str)) {
                w.b(a.f140392a, "LoadLibrary lib_name is null");
                return false;
            }
            if (this.f140397a.containsKey(str) && this.f140397a.get(str).booleanValue()) {
                w.b(a.f140392a, "LoadLibrary lib_name %s is loaded", str);
                return true;
            }
            if (a.f140396e.contains(str)) {
                h.h(str);
            } else {
                h.g(str);
            }
            this.f140397a.put(str, Boolean.TRUE);
            return true;
        }

        public /* synthetic */ d(C6723a c6723a) {
            this();
        }
    }

    public static void a(com.tencent.luggage.wxa.sm.c cVar) {
        f140393b = cVar;
    }
}
