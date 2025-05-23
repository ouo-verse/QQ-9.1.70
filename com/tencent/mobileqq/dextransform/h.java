package com.tencent.mobileqq.dextransform;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.app.face.util.FaceUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.jf.dexlib2.DexFileFactory;
import org.jf.dexlib2.Opcodes;
import org.jf.dexlib2.iface.ClassDef;
import org.jf.dexlib2.iface.DexFile;

/* compiled from: P */
/* loaded from: classes10.dex */
public class h {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static c f203557a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class a implements DexFile {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Set f203558a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ DexFile f203559b;

        a(Set set, DexFile dexFile) {
            this.f203558a = set;
            this.f203559b = dexFile;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) set, (Object) dexFile);
            }
        }

        @Override // org.jf.dexlib2.iface.DexFile
        @NonNull
        public Set<? extends ClassDef> getClasses() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Set) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.f203558a;
        }

        @Override // org.jf.dexlib2.iface.DexFile
        @NonNull
        public Opcodes getOpcodes() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Opcodes) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.f203559b.getOpcodes();
        }
    }

    @NonNull
    private static File a(File file) throws IOException {
        File file2 = new File(file.getParent(), FaceUtil.IMG_TEMP);
        if (!file2.exists() && !file2.mkdir()) {
            throw new IOException("can not create temp dir: " + file2.getAbsolutePath());
        }
        FileUtils.cleanDirectory(file2);
        return file2;
    }

    public static c b() {
        return f203557a;
    }

    public static void c(c cVar) {
        f203557a = cVar;
    }

    public static boolean d(File file, b bVar, File file2) throws IOException {
        if (!bVar.b()) {
            com.tencent.mobileqq.nlog.c.a("Transform", "configs is invalidate");
            return false;
        }
        if (j.j(file)) {
            return e(file, bVar, file2);
        }
        return f(file, bVar, file2);
    }

    private static boolean e(File file, b bVar, File file2) throws IOException {
        File a16 = a(file2);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        boolean z16 = true;
        int i3 = 1;
        int i16 = 0;
        while (true) {
            int i17 = i3 + 1;
            String a17 = j.a(i3);
            arrayList2.add(a17);
            try {
                if (g(DexFileFactory.loadDexEntry(file, a17, true, null).getDexFile(), bVar, new File(a16, a17))) {
                    i16++;
                } else {
                    arrayList.add(a17);
                }
                i3 = i17;
            } catch (DexFileFactory.DexFileNotFoundException unused) {
                if (i16 > 0) {
                    h(file, a16, arrayList, arrayList2);
                }
                if (i16 == 0 || !j.m(a16.getAbsolutePath(), file2.getAbsolutePath())) {
                    z16 = false;
                }
                FileUtils.deleteDirectory(a16);
                return z16;
            }
        }
    }

    private static boolean f(File file, b bVar, File file2) throws IOException {
        return g(DexFileFactory.loadDexFile(file, (Opcodes) null), bVar, file2);
    }

    private static boolean g(DexFile dexFile, b bVar, File file) throws IOException {
        HashSet hashSet = new HashSet();
        i iVar = new i();
        Iterator<? extends ClassDef> it = dexFile.getClasses().iterator();
        while (it.hasNext()) {
            com.tencent.mobileqq.dexasm.d dVar = new com.tencent.mobileqq.dexasm.d(it.next());
            com.tencent.mobileqq.dexasm.f fVar = new com.tencent.mobileqq.dexasm.f(dexFile.getOpcodes());
            dVar.a(new f(dexFile.getOpcodes(), fVar, bVar, iVar));
            hashSet.add(fVar.g());
        }
        if (!iVar.a()) {
            com.tencent.mobileqq.nlog.c.c("Transform", "dex is not transformed");
            return false;
        }
        com.tencent.mobileqq.nlog.c.c("Transform", "write new dex: " + file.getAbsolutePath());
        DexFileFactory.writeDexFile(file.getAbsolutePath(), new a(hashSet, dexFile));
        return true;
    }

    private static void h(File file, File file2, List<String> list, List<String> list2) throws IOException {
        ZipFile zipFile;
        FileOutputStream fileOutputStream;
        ZipFile zipFile2 = null;
        FileOutputStream fileOutputStream2 = null;
        try {
            zipFile = new ZipFile(file);
        } catch (Throwable th5) {
            th = th5;
        }
        try {
            Enumeration<? extends ZipEntry> entries = zipFile.entries();
            while (entries.hasMoreElements()) {
                ZipEntry nextElement = entries.nextElement();
                if (!list2.contains(nextElement.getName())) {
                    list.add(nextElement.getName());
                }
            }
            for (String str : list) {
                int lastIndexOf = str.lastIndexOf("/");
                if (lastIndexOf != -1) {
                    File file3 = new File(file2, str.substring(0, lastIndexOf));
                    if (!file3.exists()) {
                        file3.mkdirs();
                    }
                }
                if (lastIndexOf != str.length() - 1) {
                    InputStream inputStream = zipFile.getInputStream(zipFile.getEntry(str));
                    try {
                        fileOutputStream = new FileOutputStream(new File(file2, str));
                    } catch (Throwable th6) {
                        th = th6;
                    }
                    try {
                        IOUtils.copy(inputStream, fileOutputStream);
                        IOUtils.closeQuietly((OutputStream) fileOutputStream);
                    } catch (Throwable th7) {
                        th = th7;
                        fileOutputStream2 = fileOutputStream;
                        IOUtils.closeQuietly((OutputStream) fileOutputStream2);
                        throw th;
                    }
                }
            }
            try {
                zipFile.close();
            } catch (IOException unused) {
            }
        } catch (Throwable th8) {
            th = th8;
            zipFile2 = zipFile;
            if (zipFile2 != null) {
                try {
                    zipFile2.close();
                } catch (IOException unused2) {
                }
            }
            throw th;
        }
    }
}
