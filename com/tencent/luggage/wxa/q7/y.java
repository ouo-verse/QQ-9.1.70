package com.tencent.luggage.wxa.q7;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.FileObserver;
import android.util.Log;
import com.eclipsesource.mmv8.V8;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.ilinkservice.IlinkServiceInterface;
import com.tencent.luggage.wxa.aa.h;
import com.tencent.luggage.wxa.b.c;
import com.tencent.luggage.wxa.gp.a;
import com.tencent.luggage.wxa.qi.g;
import com.tencent.luggage.wxa.standalone_open_runtime.OpenRuntimeJNI;
import com.tencent.luggage.wxaapi.InitDynamicPkgResult;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.rfix.loader.utils.RFixConstants;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.apache.commons.io.FileUtils;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class y {

    /* renamed from: a, reason: collision with root package name */
    public static final y f138216a = new y();

    /* renamed from: b, reason: collision with root package name */
    public static final String f138217b = "WxaDynamicPkgMgr";

    /* renamed from: c, reason: collision with root package name */
    public static final Lazy f138218c;

    /* renamed from: d, reason: collision with root package name */
    public static final Lazy f138219d;

    /* renamed from: e, reason: collision with root package name */
    public static final Lazy f138220e;

    /* renamed from: f, reason: collision with root package name */
    public static int f138221f;

    /* renamed from: g, reason: collision with root package name */
    public static String f138222g;

    /* renamed from: h, reason: collision with root package name */
    public static FileObserver f138223h;

    /* renamed from: i, reason: collision with root package name */
    public static LinkedHashSet f138224i;

    /* renamed from: j, reason: collision with root package name */
    public static com.tencent.luggage.wxa.tn.f0 f138225j;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements OpenRuntimeJNI.b {

        /* renamed from: a, reason: collision with root package name */
        public static final a f138226a = new a();

        @Override // com.tencent.luggage.wxa.standalone_open_runtime.OpenRuntimeJNI.b
        public final void loadLibrary(String str) {
            com.tencent.luggage.wxa.aa.h.g(str);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b extends FileObserver {
        public b(String str, int i3) {
            super(str, i3);
        }

        @Override // android.os.FileObserver
        public void onEvent(int i3, String str) {
            SharedPreferences.Editor remove;
            y yVar = y.f138216a;
            yVar.h("FileObserver event:" + i3 + " path:" + str);
            if ((i3 == 2 || i3 == 512) && str != null) {
                String c16 = yVar.c(str);
                com.tencent.luggage.wxa.tn.f0 g16 = yVar.g();
                if (g16 != null && (remove = g16.remove(c16)) != null) {
                    remove.commit();
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c extends h.c {
        @Override // com.tencent.luggage.wxa.aa.h.c
        public void a(String libName) {
            Intrinsics.checkNotNullParameter(libName, "libName");
            if (Intrinsics.areEqual(libName, "mmv8") || Intrinsics.areEqual(libName, "mmj2v8")) {
                y.f138216a.k();
            }
            y.f138216a.g(libName);
        }

        @Override // com.tencent.luggage.wxa.aa.h.c
        public String b(String path) {
            Intrinsics.checkNotNullParameter(path, "path");
            y yVar = y.f138216a;
            String a16 = yVar.a(new File(path));
            if (a16 != null) {
                yVar.i(a16);
            }
            String b16 = h.c.f121021a.b(path);
            Intrinsics.checkNotNullExpressionValue(b16, "SYSTEM.loadByPath(path)");
            return b16;
        }

        @Override // com.tencent.luggage.wxa.aa.h.c
        public String c(String path) {
            Intrinsics.checkNotNullParameter(path, "path");
            String c16 = h.c.f121021a.c(path);
            Intrinsics.checkNotNullExpressionValue(c16, "SYSTEM.resolve(path)");
            return c16;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class d implements IlinkServiceInterface.IIlinkLoadDelegate {

        /* renamed from: a, reason: collision with root package name */
        public static final d f138227a = new d();

        @Override // com.tencent.ilinkservice.IlinkServiceInterface.IIlinkLoadDelegate
        public final void loadLibrary(String str) {
            com.tencent.luggage.wxa.aa.h.b(str, y.f138216a.getClass().getClassLoader());
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class e implements a.b {

        /* renamed from: a, reason: collision with root package name */
        public static final e f138228a = new e();

        @Override // com.tencent.luggage.wxa.gp.a.b
        public final void loadLibrary(String str) {
            com.tencent.luggage.wxa.aa.h.b(str, y.f138216a.getClass().getClassLoader());
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class f implements com.tencent.luggage.wxa.sm.c {
        @Override // com.tencent.luggage.wxa.sm.c
        public boolean a(String str) {
            boolean z16;
            if (str != null && str.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                return false;
            }
            return com.tencent.luggage.wxa.aa.h.b(str);
        }

        @Override // com.tencent.luggage.wxa.sm.c
        public String findLibPath(String lib_name) {
            boolean startsWith$default;
            boolean endsWith$default;
            Intrinsics.checkNotNullParameter(lib_name, "lib_name");
            com.tencent.luggage.wxa.tn.w.d(y.f138217b, "findLibPath %s", lib_name);
            int hashCode = lib_name.hashCode();
            if (hashCode != -1539357211) {
                if (hashCode != -221789578) {
                    if (hashCode != -221778096) {
                        if (hashCode == 1714602760 && lib_name.equals("qm_native_decoder_flac")) {
                            y.f138216a.g("qm_native_decoder_flac");
                        }
                    } else if (lib_name.equals("qm_native_decoder_mp3")) {
                        y.f138216a.g("qm_native_decoder_mp3");
                    }
                } else if (lib_name.equals("qm_native_decoder_ape")) {
                    y.f138216a.g("qm_native_decoder_ape");
                }
            } else if (lib_name.equals("qm_native_decoder_ffmpeg")) {
                y.f138216a.g("qm_native_decoder_ffmpeg");
            }
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(lib_name, RFixConstants.SO_PATH, false, 2, null);
            if (!startsWith$default) {
                lib_name = RFixConstants.SO_PATH + lib_name;
            }
            endsWith$default = StringsKt__StringsJVMKt.endsWith$default(lib_name, ".so", false, 2, null);
            if (!endsWith$default) {
                return lib_name + ".so";
            }
            return lib_name;
        }

        @Override // com.tencent.luggage.wxa.sm.c
        public boolean load(String str) {
            boolean z16;
            if (str != null && str.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                return false;
            }
            com.tencent.luggage.wxa.aa.h.b(str, y.f138216a.getClass().getClassLoader());
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class g implements g.b {

        /* renamed from: a, reason: collision with root package name */
        public static final g f138229a = new g();

        @Override // com.tencent.luggage.wxa.qi.g.b
        public final void loadLibrary(String str, ClassLoader classLoader) {
            com.tencent.luggage.wxa.aa.h.b(str, y.f138216a.getClass().getClassLoader());
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class h implements MMBitmapFactory.a {

        /* renamed from: a, reason: collision with root package name */
        public static final h f138230a = new h();

        @Override // com.tencent.mm.graphics.MMBitmapFactory.a
        public final void loadLibrary(String str) {
            com.tencent.luggage.wxa.aa.h.b(str, y.f138216a.getClass().getClassLoader());
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class i extends Lambda implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public static final i f138231a = new i();

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a implements c.d {

            /* renamed from: a, reason: collision with root package name */
            public static final a f138232a = new a();

            @Override // com.tencent.luggage.wxa.b.c.d
            public final void a(String str) {
                com.tencent.luggage.wxa.tn.w.d(y.f138217b, "[reLinker::log] " + str);
            }
        }

        public i() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final com.tencent.luggage.wxa.b.d invoke() {
            return com.tencent.luggage.wxa.b.c.a(a.f138232a);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class j extends Lambda implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public static final j f138233a = new j();

        public j() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String[] invoke() {
            return y.f138216a.d();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class k extends Lambda implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public static final k f138234a = new k();

        public k() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String[] invoke() {
            return y.f138216a.e();
        }
    }

    static {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        lazy = LazyKt__LazyJVMKt.lazy(j.f138233a);
        f138218c = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(k.f138234a);
        f138219d = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(i.f138231a);
        f138220e = lazy3;
        f138221f = 2;
        f138222g = "";
        f138224i = new LinkedHashSet();
    }

    public final String[] e() {
        return new String[0];
    }

    public final com.tencent.luggage.wxa.b.d f() {
        return (com.tencent.luggage.wxa.b.d) f138220e.getValue();
    }

    public final void g(String str) {
        boolean contains;
        boolean contains2;
        boolean contains$default;
        String str2 = f138217b;
        com.tencent.luggage.wxa.tn.w.d(str2, "load library " + str + TokenParser.SP + y.class.getClassLoader());
        if (Intrinsics.areEqual("mmv8", str)) {
            k();
        }
        String i3 = i(str);
        if (i3.length() == 0) {
            return;
        }
        contains = ArraysKt___ArraysKt.contains(h(), i3);
        if (!contains) {
            contains2 = ArraysKt___ArraysKt.contains(i(), i3);
            if (contains2) {
                return;
            }
            f().a(com.tencent.luggage.wxa.tn.z.c(), i3);
            return;
        }
        if (f(i3)) {
            com.tencent.luggage.wxa.tn.w.f(str2, "load library success: " + str);
            try {
                System.load(d(i3));
                return;
            } catch (Exception e16) {
                com.tencent.luggage.wxa.tn.w.b(f138217b, "load library fail: " + str + " e:" + e16);
                return;
            } catch (Throwable th5) {
                com.tencent.luggage.wxa.tn.w.b(f138217b, "load library fail: " + str + " e:" + th5);
                return;
            }
        }
        com.tencent.luggage.wxa.tn.w.b(str2, "load library fail: " + str);
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) i3, (CharSequence) "mmimgcodec", false, 2, (Object) null);
        if (contains$default && com.tencent.luggage.wxa.tn.z.m()) {
            throw new UnsatisfiedLinkError();
        }
    }

    public final String[] h() {
        return (String[]) f138218c.getValue();
    }

    public final String[] i() {
        return (String[]) f138219d.getValue();
    }

    public final boolean j() {
        long currentTimeMillis = System.currentTimeMillis();
        for (String str : h()) {
            if (!f(str)) {
                return false;
            }
        }
        com.tencent.luggage.wxa.tn.w.d(f138217b, "isLoaded: " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
        FileObserver fileObserver = f138223h;
        if (fileObserver != null) {
            fileObserver.startWatching();
            return true;
        }
        return true;
    }

    public final void k() {
        boolean equals;
        boolean equals2;
        String str = Build.MANUFACTURER;
        equals = StringsKt__StringsJVMKt.equals(str, CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_XIAOMI, true);
        if (!equals) {
            equals2 = StringsKt__StringsJVMKt.equals(str, "Vivo", true);
            if (!equals2) {
                return;
            }
        }
        int i3 = Build.VERSION.SDK_INT;
        if (i3 == 27 || i3 == 28) {
            V8.setFlags("--single-threaded-gc");
        }
    }

    public final InitDynamicPkgResult e(String dynamicPkgPath) {
        com.tencent.luggage.wxa.tn.f0 g16;
        Intrinsics.checkNotNullParameter(dynamicPkgPath, "dynamicPkgPath");
        String str = f138217b;
        com.tencent.luggage.wxa.tn.w.d(str, "initDynamicPkg dirPath:" + dynamicPkgPath + ", sLibDirPath:" + f138222g + ", abiType:" + f138221f);
        File file = new File(dynamicPkgPath);
        if (!file.exists()) {
            com.tencent.luggage.wxa.tn.w.b(str, "dirPath isn't exist, return");
            return InitDynamicPkgResult.FailDynamicPkgPathNotExist;
        }
        boolean isDirectory = file.isDirectory();
        if (isDirectory) {
            com.tencent.luggage.wxa.tn.w.d(str, "init dynamic package with a directory");
        } else if (!OpenRuntimeJNI.a(dynamicPkgPath, f138221f)) {
            com.tencent.luggage.wxa.tn.w.b(str, "checkMd5 fail");
            return InitDynamicPkgResult.FailCheckInvalid;
        }
        if (com.tencent.luggage.wxa.tn.z.m() && (g16 = g()) != null) {
            g16.b();
        }
        if (j()) {
            return InitDynamicPkgResult.OK;
        }
        FileObserver fileObserver = f138223h;
        if (fileObserver != null) {
            fileObserver.stopWatching();
        }
        b();
        if (isDirectory) {
            FileUtils.copyDirectory(file, new File(f138222g), true);
        } else {
            b(f138222g, dynamicPkgPath);
        }
        for (String str2 : h()) {
            if (!f(str2)) {
                com.tencent.luggage.wxa.tn.w.b(f138217b, "initDynamicPkg fail: " + str2);
                return InitDynamicPkgResult.FailCheckInvalid;
            }
        }
        b();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        synchronized (this) {
            linkedHashSet.addAll(f138224i);
            f138224i.clear();
            Unit unit = Unit.INSTANCE;
        }
        Iterator it = linkedHashSet.iterator();
        while (it.hasNext()) {
            ((Function0) it.next()).invoke();
        }
        FileObserver fileObserver2 = f138223h;
        if (fileObserver2 != null) {
            fileObserver2.startWatching();
        }
        return InitDynamicPkgResult.OK;
    }

    public final boolean f(String str) {
        SharedPreferences.Editor putInt;
        if (a(str)) {
            h(str + " isPrivateLibValid true");
            return true;
        }
        boolean a16 = OpenRuntimeJNI.a(d(str), str, f138221f);
        if (a16) {
            y yVar = f138216a;
            yVar.h(str + " sCacheLibInfoMMKV save");
            com.tencent.luggage.wxa.tn.f0 g16 = yVar.g();
            if (g16 != null && (putInt = g16.putInt(str, 0)) != null) {
                putInt.commit();
            }
        }
        return a16;
    }

    public final void h(String str) {
        if (r.f138048a.b()) {
            com.tencent.luggage.wxa.tn.w.d(f138217b, str);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0069, code lost:
    
        if (r6.equals("mmphysx") == false) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x008b, code lost:
    
        g("mmv8");
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0074, code lost:
    
        if (r6.equals("mmmedia") == false) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0087, code lost:
    
        if (r6.equals("mmbox2d") == false) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0019, code lost:
    
        if (r6.equals("xffmpeg") == false) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0078, code lost:
    
        g("wxVcodec1");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String i(String str) {
        boolean contains;
        switch (str.hashCode()) {
            case -1861790728:
                if (str.equals("wechatsight_v7a")) {
                    g("wechatpack");
                    g("xffmpeg");
                    g("voipVideoCodec");
                    break;
                }
                break;
            case -1539357211:
                if (str.equals("qm_native_decoder_ffmpeg")) {
                    g("xffmpeg");
                    break;
                }
                break;
            case -764095497:
                if (str.equals("liteavsdk")) {
                    contains = ArraysKt___ArraysKt.contains(h(), "soundtouch");
                    if (contains) {
                        g("soundtouch");
                        break;
                    }
                }
                break;
            case -738708122:
                if (str.equals("cronet.119.0.6045.214")) {
                    g("mmv8");
                    g("mmnode");
                    break;
                }
                break;
            case -80394285:
                if (str.equals("mmimgcodec")) {
                    g("commonimgdec");
                    break;
                }
                break;
            case -56060061:
                if (str.equals("wxa-runtime-binding")) {
                    g("mmv8");
                    g("mmnode");
                    break;
                }
                break;
            case 104025665:
                if (str.equals("mmtcp")) {
                    g("mmudp");
                    break;
                }
                break;
            case 1168159709:
                break;
            case 1178003012:
                break;
            case 1180883462:
                break;
            case 1187197227:
                if (str.equals("mmwcwss")) {
                    g("wcwss");
                    break;
                }
                break;
            case 1573188013:
                if (str.equals("magicbrush")) {
                    g("mmskia");
                    g("commonimgdec");
                    g("native-iv");
                    g("mmnode");
                    break;
                }
                break;
            case 1767420309:
                if (str.equals("wxaudio")) {
                    g("XNet");
                    break;
                }
                break;
            case 2143989949:
                break;
        }
        return str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00e8 A[Catch: IOException -> 0x00e4, TRY_LEAVE, TryCatch #6 {IOException -> 0x00e4, blocks: (B:49:0x00dd, B:39:0x00e8), top: B:48:0x00dd }] */
    /* JADX WARN: Removed duplicated region for block: B:47:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00dd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00ff A[Catch: IOException -> 0x00fb, TRY_LEAVE, TryCatch #11 {IOException -> 0x00fb, blocks: (B:62:0x00f4, B:55:0x00ff), top: B:61:0x00f4 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00f4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v12, types: [java.io.OutputStream, java.io.BufferedOutputStream] */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean b(String str, String str2) {
        boolean endsWith$default;
        ?? r56;
        ZipInputStream zipInputStream;
        boolean contains$default;
        boolean contains$default2;
        String str3 = f138222g;
        Intrinsics.checkNotNull(str3);
        String separator = File.separator;
        Intrinsics.checkNotNullExpressionValue(separator, "separator");
        ZipInputStream zipInputStream2 = null;
        endsWith$default = StringsKt__StringsJVMKt.endsWith$default(str3, separator, false, 2, null);
        if (!endsWith$default) {
            f138222g += separator;
        }
        try {
            zipInputStream = new ZipInputStream(new BufferedInputStream(new FileInputStream(str2)));
            try {
                byte[] bArr = new byte[2048];
                ?? r16 = 0;
                while (true) {
                    try {
                        ZipEntry nextEntry = zipInputStream.getNextEntry();
                        if (nextEntry != null) {
                            Intrinsics.checkNotNull(nextEntry);
                            String name = nextEntry.getName();
                            Intrinsics.checkNotNullExpressionValue(name, "ze!!.name");
                            contains$default = StringsKt__StringsKt.contains$default((CharSequence) name, (CharSequence) "../", false, 2, (Object) null);
                            if (!contains$default) {
                                contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) name, (CharSequence) "..\\", false, 2, (Object) null);
                                if (!contains$default2) {
                                    a(name, str);
                                    if (nextEntry.isDirectory()) {
                                        new File(str + name).mkdirs();
                                    } else {
                                        r56 = new BufferedOutputStream(new FileOutputStream(str + name));
                                        while (true) {
                                            try {
                                                int read = zipInputStream.read(bArr);
                                                if (read == -1) {
                                                    break;
                                                }
                                                r56.write(bArr, 0, read);
                                            } catch (IOException e16) {
                                                e = e16;
                                                zipInputStream2 = zipInputStream;
                                                r56 = r56;
                                                try {
                                                    e.printStackTrace();
                                                    if (zipInputStream2 != null) {
                                                        try {
                                                            zipInputStream2.closeEntry();
                                                            zipInputStream2.close();
                                                        } catch (IOException e17) {
                                                            e17.printStackTrace();
                                                            return false;
                                                        }
                                                    }
                                                    if (r56 != 0) {
                                                        return false;
                                                    }
                                                    r56.close();
                                                    return false;
                                                } catch (Throwable th5) {
                                                    th = th5;
                                                    zipInputStream = zipInputStream2;
                                                    if (zipInputStream != null) {
                                                        try {
                                                            zipInputStream.closeEntry();
                                                            zipInputStream.close();
                                                        } catch (IOException e18) {
                                                            e18.printStackTrace();
                                                            throw th;
                                                        }
                                                    }
                                                    if (r56 != 0) {
                                                        r56.close();
                                                    }
                                                    throw th;
                                                }
                                            } catch (Throwable th6) {
                                                th = th6;
                                                if (zipInputStream != null) {
                                                }
                                                if (r56 != 0) {
                                                }
                                                throw th;
                                            }
                                        }
                                        r56.flush();
                                        r56.close();
                                        r16 = r56;
                                    }
                                }
                            }
                        } else {
                            try {
                                break;
                            } catch (IOException e19) {
                                e19.printStackTrace();
                            }
                        }
                    } catch (IOException e26) {
                        e = e26;
                        zipInputStream2 = r16;
                        r56 = zipInputStream2;
                        zipInputStream2 = zipInputStream;
                        r56 = r56;
                        e.printStackTrace();
                        if (zipInputStream2 != null) {
                        }
                        if (r56 != 0) {
                        }
                    } catch (Throwable th7) {
                        th = th7;
                        zipInputStream2 = r16;
                        r56 = zipInputStream2;
                        if (zipInputStream != null) {
                        }
                        if (r56 != 0) {
                        }
                        throw th;
                    }
                }
                zipInputStream.closeEntry();
                zipInputStream.close();
                if (r16 != 0) {
                    r16.close();
                }
                return true;
            } catch (IOException e27) {
                e = e27;
            } catch (Throwable th8) {
                th = th8;
            }
        } catch (IOException e28) {
            e = e28;
            r56 = 0;
        } catch (Throwable th9) {
            th = th9;
            r56 = 0;
            zipInputStream = zipInputStream2;
            if (zipInputStream != null) {
            }
            if (r56 != 0) {
            }
            throw th;
        }
    }

    public final void c() {
        File file = new File(f138222g);
        if (!file.exists()) {
            com.tencent.luggage.wxa.tn.w.b(f138217b, f138222g + " is empty");
            return;
        }
        String[] names = file.list();
        Intrinsics.checkNotNullExpressionValue(names, "names");
        if (names.length == 0) {
            com.tencent.luggage.wxa.tn.w.b(f138217b, f138222g + " is empty, names is null");
            return;
        }
        File file2 = new File(f138222g + names[0]);
        if (!file2.exists()) {
            com.tencent.luggage.wxa.tn.w.b(f138217b, names[0] + " not exist");
            return;
        }
        file2.delete();
    }

    public final String d(String str) {
        boolean contains$default;
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) "wxa_library", false, 2, (Object) null);
        if (contains$default) {
            return f138222g + str + ".zip";
        }
        return f138222g + b(str);
    }

    public final void a(int i3) {
        f138221f = i3;
    }

    public final void a(Function0 block) {
        Intrinsics.checkNotNullParameter(block, "block");
        if (j()) {
            block.invoke();
        } else {
            synchronized (this) {
                f138224i.add(block);
            }
        }
    }

    public final String[] d() {
        List split$default;
        boolean contains$default;
        boolean contains$default2;
        String replace$default;
        String str = f138221f == 1 ? "armeabi-v7a" : "arm64-v8a";
        ArrayList arrayList = new ArrayList();
        String a16 = OpenRuntimeJNI.a();
        if (a16 != null) {
            if (!(a16.length() == 0)) {
                split$default = StringsKt__StringsKt.split$default((CharSequence) a16, new String[]{"|"}, false, 0, 6, (Object) null);
                int i3 = 0;
                for (Object obj : split$default) {
                    int i16 = i3 + 1;
                    if (i3 < 0) {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                    }
                    String str2 = (String) obj;
                    if (i3 % 3 == 0) {
                        contains$default = StringsKt__StringsKt.contains$default((CharSequence) str2, (CharSequence) str, false, 2, (Object) null);
                        if (contains$default) {
                            contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) str2, (CharSequence) ("DynamicPkg-" + str), false, 2, (Object) null);
                            if (!contains$default2) {
                                replace$default = StringsKt__StringsJVMKt.replace$default(str2, '-' + str, "", false, 4, (Object) null);
                                arrayList.add(replace$default);
                            }
                        }
                    }
                    i3 = i16;
                }
                Object[] array = arrayList.toArray(new String[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                return (String[]) array;
            }
        }
        com.tencent.luggage.wxa.tn.w.b(f138217b, "getDynamicLibList fail");
        return new String[0];
    }

    public final String a(File file) {
        boolean startsWith$default;
        boolean endsWith$default;
        String removeSurrounding;
        Intrinsics.checkNotNullParameter(file, "<this>");
        String name = file.getName();
        Intrinsics.checkNotNullExpressionValue(name, "name");
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(name, RFixConstants.SO_PATH, false, 2, null);
        if (startsWith$default) {
            String name2 = file.getName();
            Intrinsics.checkNotNullExpressionValue(name2, "name");
            endsWith$default = StringsKt__StringsJVMKt.endsWith$default(name2, ".so", false, 2, null);
            if (endsWith$default) {
                String name3 = file.getName();
                Intrinsics.checkNotNullExpressionValue(name3, "name");
                removeSurrounding = StringsKt__StringsKt.removeSurrounding(name3, (CharSequence) RFixConstants.SO_PATH, (CharSequence) ".so");
                return removeSurrounding;
            }
        }
        return null;
    }

    public final void a(Context context) {
        boolean endsWith$default;
        com.tencent.luggage.wxa.tn.f0 g16;
        Intrinsics.checkNotNullParameter(context, "context");
        if (com.tencent.luggage.wxa.tn.z.m() && (g16 = g()) != null) {
            g16.b();
        }
        OpenRuntimeJNI.a(a.f138226a);
        OpenRuntimeJNI.a(context);
        String absolutePath = context.getDir("libs", 0).getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "context.getDir(\"libs\", C\u2026ODE_PRIVATE).absolutePath");
        f138222g = absolutePath;
        Intrinsics.checkNotNull(absolutePath);
        String separator = File.separator;
        Intrinsics.checkNotNullExpressionValue(separator, "separator");
        endsWith$default = StringsKt__StringsJVMKt.endsWith$default(absolutePath, separator, false, 2, null);
        if (!endsWith$default) {
            f138222g += separator;
        }
        File file = new File(f138222g);
        if (!file.exists()) {
            file.mkdir();
        }
        com.tencent.luggage.wxa.aa.h.a(f138222g);
        f138223h = new b(f138222g, 514);
        String str = f138217b;
        Log.i(str, "initLoadLibrary abiType:" + f138221f);
        com.tencent.luggage.wxa.tn.w.d(str, "initLoadLibrary abiType:" + f138221f);
        m.f138016a.a(context, f138222g);
        Log.i(str, "path list init succ");
        com.tencent.luggage.wxa.tn.w.d(str, "path list init succ");
        h.c.a(new c());
        IlinkServiceInterface.setIlinkLoadDelegate(d.f138227a);
        com.tencent.luggage.wxa.gp.a.a(e.f138228a);
        com.tencent.luggage.wxa.sm.a.a(new f());
        com.tencent.luggage.wxa.qi.g.a(g.f138229a);
        MMBitmapFactory.a(h.f138230a);
    }

    public final String c(String str) {
        String substring = str.substring(3, str.length() - 3);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
        return substring;
    }

    public final com.tencent.luggage.wxa.tn.f0 g() {
        if (f138225j == null) {
            String str = f138217b;
            synchronized (str) {
                if (f138225j == null) {
                    f138225j = com.tencent.luggage.wxa.tn.f0.c(str, 2);
                }
                Unit unit = Unit.INSTANCE;
            }
        }
        return f138225j;
    }

    public final String b(String str) {
        return RFixConstants.SO_PATH + str + ".so";
    }

    public final void b() {
        File file = new File(f138222g);
        if (!file.exists()) {
            com.tencent.luggage.wxa.tn.w.b(f138217b, "sLibDir:" + f138222g + " is null, err return");
            return;
        }
        File[] listFiles = file.listFiles();
        StringBuffer stringBuffer = new StringBuffer();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2 != null) {
                    stringBuffer.append(" [" + file2.getName() + TokenParser.SP + file2.length() + "] ");
                }
            }
        }
        com.tencent.luggage.wxa.tn.w.d(f138217b, "libs: " + ((Object) stringBuffer));
    }

    public final void a(String str, String str2) {
        List split$default;
        split$default = StringsKt__StringsKt.split$default((CharSequence) str, new String[]{"/"}, false, 0, 6, (Object) null);
        Object[] array = split$default.toArray(new String[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        String[] strArr = (String[]) array;
        if (strArr.length <= 1) {
            return;
        }
        int length = strArr.length - 1;
        for (int i3 = 0; i3 < length; i3++) {
            str2 = str2 + strArr[i3] + '/';
            File file = new File(str2);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
    }

    public final boolean a(String str) {
        com.tencent.luggage.wxa.tn.f0 g16 = g();
        if (g16 != null && g16.a(str)) {
            h(str + " checkLibCacheValid true");
            return true;
        }
        h(str + " checkLibCacheValid false");
        return false;
    }
}
