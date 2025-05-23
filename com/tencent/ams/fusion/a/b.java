package com.tencent.ams.fusion.a;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.qq.e.tg.splash.image.TGSplashFileUtil;
import com.tencent.hippy.qq.api.MMKVCommonFileKeys;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes3.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final Map<String, AtomicInteger> f70231a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class a implements Comparator<File> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(File file, File file2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) file, (Object) file2)).intValue();
            }
            if (file == null && file2 == null) {
                return 0;
            }
            if (file != null && file2 != null) {
                return Long.valueOf(file.lastModified()).compareTo(Long.valueOf(file2.lastModified()));
            }
            if (file == null) {
                return 1;
            }
            return -1;
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.ams.fusion.a.b$b, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    static class C0672b implements d {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ File f70232a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Object f70233b;

        C0672b(File file, Object obj) {
            this.f70232a = file;
            this.f70233b = obj;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) file, obj);
            }
        }

        @Override // com.tencent.ams.fusion.a.b.d
        public boolean a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            return b.k(this.f70232a, this.f70233b);
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    static class c implements d {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ File f70234a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Parcelable f70235b;

        c(File file, Parcelable parcelable) {
            this.f70234a = file;
            this.f70235b = parcelable;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) file, (Object) parcelable);
            }
        }

        @Override // com.tencent.ams.fusion.a.b.d
        public boolean a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            return b.i(this.f70234a, this.f70235b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface d {
        boolean a();
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(55763);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
        } else {
            f70231a = new HashMap(1);
        }
    }

    public static File a() {
        Context f16 = com.tencent.ams.fusion.service.b.b().f();
        if (f16 == null) {
            return null;
        }
        return f16.getDir(TGSplashFileUtil.ADNET, 0);
    }

    public static File b(int i3) {
        String str;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    str = null;
                } else {
                    str = "zip";
                }
            } else {
                str = "video";
            }
        } else {
            str = "image";
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(a().getAbsolutePath());
        String str2 = File.separator;
        sb5.append(str2);
        sb5.append("resource");
        sb5.append(str2);
        sb5.append(str);
        File file = new File(sb5.toString());
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File c(int i3, String str) {
        File b16 = b(i3);
        if (b16 == null) {
            return null;
        }
        String d16 = d(str);
        if (TextUtils.isEmpty(d16)) {
            return null;
        }
        File file = new File(b16.getAbsolutePath() + File.separator + d16);
        f(file);
        return file;
    }

    public static String d(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return g.b(str);
    }

    public static <T> List<String> e(List<T> list) {
        String d16;
        if (j.b(list)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (T t16 : list) {
            if (t16 instanceof com.tencent.ams.fusion.service.splash.b.a.a) {
                com.tencent.ams.fusion.service.splash.b.a.a aVar = (com.tencent.ams.fusion.service.splash.b.a.a) t16;
                String a16 = aVar.a();
                if (!TextUtils.isEmpty(a16)) {
                    String b16 = aVar.b();
                    if (TextUtils.isEmpty(b16)) {
                        d16 = d(a16);
                    } else {
                        d16 = d(b16);
                    }
                    arrayList.add(d16);
                }
            }
        }
        return arrayList;
    }

    public static void f(File file) {
        if (file != null && file.exists()) {
            try {
                file.setLastModified(System.currentTimeMillis());
            } catch (Throwable th5) {
                f.d("setLastModified failed :", th5);
            }
        }
    }

    private static void g(File file, List<File> list) {
        File[] listFiles;
        if (file != null && file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                if (file2 != null && !TextUtils.isEmpty(file2.getName())) {
                    if (file2.isDirectory()) {
                        if (file2.getName().contains(MMKVCommonFileKeys.WEB_PREFIX)) {
                            list.add(file2);
                        } else {
                            g(file2, list);
                        }
                    } else {
                        list.add(file2);
                    }
                }
            }
        }
    }

    public static void h(File[] fileArr) {
        if (fileArr != null && fileArr.length >= 2) {
            Arrays.sort(fileArr, new a());
        }
    }

    public static boolean i(File file, Parcelable parcelable) {
        byte[] l3;
        boolean z16 = false;
        if (file == null || parcelable == null || (l3 = l(parcelable)) == null) {
            return false;
        }
        FileOutputStream fileOutputStream = null;
        try {
        } catch (Throwable th5) {
            th = th5;
        }
        if (u(file)) {
            return false;
        }
        File file2 = new File(file.getAbsolutePath() + ".tmp");
        FileOutputStream fileOutputStream2 = new FileOutputStream(file2);
        try {
            fileOutputStream2.write(l3);
            fileOutputStream2.flush();
            z16 = file2.renameTo(file);
            com.tencent.ams.fusion.a.d.a(fileOutputStream2);
        } catch (Throwable th6) {
            th = th6;
            fileOutputStream = fileOutputStream2;
            try {
                f.d("writeParcelable2File Throwable", th);
                return z16;
            } finally {
                com.tencent.ams.fusion.a.d.a(fileOutputStream);
            }
        }
        return z16;
    }

    public static boolean j(File file, d dVar) {
        AtomicInteger atomicInteger;
        boolean a16;
        if (file == null || dVar == null) {
            return false;
        }
        String absolutePath = file.getAbsolutePath();
        Map<String, AtomicInteger> map = f70231a;
        synchronized (map) {
            atomicInteger = map.get(absolutePath);
            if (atomicInteger == null) {
                atomicInteger = new AtomicInteger(0);
                map.put(absolutePath, atomicInteger);
            }
            atomicInteger.incrementAndGet();
        }
        synchronized (atomicInteger) {
            a16 = dVar.a();
        }
        synchronized (map) {
            if (atomicInteger.decrementAndGet() == 0) {
                map.remove(absolutePath);
            }
        }
        return a16;
    }

    public static boolean k(File file, Object obj) {
        ObjectOutputStream objectOutputStream;
        boolean z16 = false;
        if (file == null || obj == null) {
            return false;
        }
        FileOutputStream fileOutputStream = null;
        try {
            f.i("writeObj2File:" + obj);
        } catch (Throwable th5) {
            th = th5;
            objectOutputStream = null;
        }
        if (u(file)) {
            com.tencent.ams.fusion.a.d.a(null);
            com.tencent.ams.fusion.a.d.a(null);
            return false;
        }
        File file2 = new File(file.getAbsolutePath() + ".tmp");
        FileOutputStream fileOutputStream2 = new FileOutputStream(file2);
        try {
            objectOutputStream = new ObjectOutputStream(fileOutputStream2);
        } catch (Throwable th6) {
            th = th6;
            objectOutputStream = null;
        }
        try {
            objectOutputStream.writeObject(obj);
            objectOutputStream.flush();
            z16 = file2.renameTo(file);
            com.tencent.ams.fusion.a.d.a(objectOutputStream);
            com.tencent.ams.fusion.a.d.a(fileOutputStream2);
        } catch (Throwable th7) {
            th = th7;
            fileOutputStream = fileOutputStream2;
            try {
                f.d("writeObj2File Throwable", th);
                return z16;
            } finally {
                com.tencent.ams.fusion.a.d.a(objectOutputStream);
                com.tencent.ams.fusion.a.d.a(fileOutputStream);
            }
        }
        return z16;
    }

    private static byte[] l(Parcelable parcelable) {
        Parcel obtain;
        if (parcelable == null || (obtain = Parcel.obtain()) == null) {
            return null;
        }
        obtain.setDataPosition(0);
        parcelable.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        OaidMonitor.parcelRecycle(obtain);
        return marshall;
    }

    public static long m(File file) {
        File[] listFiles;
        long length;
        long j3 = -1;
        if (file != null) {
            try {
                if (file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
                    for (File file2 : listFiles) {
                        if (file2 != null) {
                            if (file2.isDirectory()) {
                                length = m(file2);
                            } else {
                                length = file2.length();
                            }
                            j3 += length;
                        }
                    }
                }
            } catch (Throwable th5) {
                f.d("getDirSize error:", th5);
            }
        }
        return j3;
    }

    public static File n() {
        File file = new File(a().getAbsolutePath() + File.separator + "resource");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File o(int i3, String str) {
        File r16 = r(i3, str);
        if (r16 != null) {
            return new File(r16.getAbsolutePath() + File.separator + "index.html");
        }
        return null;
    }

    public static boolean p(File file, Parcelable parcelable) {
        return j(file, new c(file, parcelable));
    }

    public static boolean q(File file, Object obj) {
        return j(file, new C0672b(file, obj));
    }

    public static File r(int i3, String str) {
        File b16 = b(i3);
        File file = null;
        if (b16 != null && !TextUtils.isEmpty(str)) {
            String str2 = MMKVCommonFileKeys.WEB_PREFIX + d(str);
            if (TextUtils.isEmpty(str2)) {
                return null;
            }
            file = new File(b16.getAbsolutePath() + File.separator + str2);
            if (!file.exists()) {
                file.mkdirs();
            }
            if (!j.d(file.listFiles())) {
                for (File file2 : file.listFiles()) {
                    f(file2);
                }
            }
        }
        return file;
    }

    public static File[] s(File file) {
        if (file != null && file.exists() && file.isDirectory()) {
            ArrayList arrayList = new ArrayList();
            try {
                g(file, arrayList);
                if (arrayList.isEmpty()) {
                    return null;
                }
                File[] fileArr = (File[]) arrayList.toArray(new File[arrayList.size()]);
                h(fileArr);
                return fileArr;
            } catch (Throwable th5) {
                f.d("getCacheFiles error :", th5);
            }
        }
        return null;
    }

    public static boolean t(File file) {
        if (file == null || !file.exists()) {
            return false;
        }
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (!j.d(listFiles)) {
                for (File file2 : listFiles) {
                    t(file2);
                }
            }
        }
        f.g("delete file :" + file.getAbsolutePath());
        return file.delete();
    }

    private static boolean u(File file) {
        File parentFile;
        if (file == null || (parentFile = file.getParentFile()) == null) {
            return true;
        }
        if (!parentFile.exists() && !parentFile.mkdirs()) {
            return true;
        }
        return false;
    }
}
