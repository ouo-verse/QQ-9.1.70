package com.tencent.tbs.one.impl.common.a;

import com.tencent.tbs.one.impl.a.g;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class a extends com.tencent.tbs.one.impl.a.b<byte[]> {

    /* renamed from: p, reason: collision with root package name */
    private String f374792p;

    /* renamed from: q, reason: collision with root package name */
    private File f374793q;

    /* renamed from: r, reason: collision with root package name */
    private ZipEntry f374794r;

    /* renamed from: s, reason: collision with root package name */
    private ZipOutputStream f374795s;

    /* renamed from: t, reason: collision with root package name */
    private int f374796t = 0;

    /* compiled from: P */
    /* renamed from: com.tencent.tbs.one.impl.common.a.a$a, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    final class C9891a implements Comparator<File> {
        C9891a() {
        }

        @Override // java.util.Comparator
        public final /* synthetic */ int compare(File file, File file2) {
            File file3 = file;
            File file4 = file2;
            if (file3.lastModified() > file4.lastModified()) {
                return 1;
            }
            if (file3.lastModified() < file4.lastModified()) {
                return -1;
            }
            return 0;
        }
    }

    public a(String str) {
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            this.f374792p = str;
            this.f374794r = new ZipEntry("onelog");
            File c16 = c("log_", ".zip.tmp", file);
            this.f374793q = c16;
            c16.getAbsolutePath();
            try {
                ZipOutputStream zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(this.f374793q)));
                this.f374795s = zipOutputStream;
                zipOutputStream.putNextEntry(this.f374794r);
                return;
            } catch (FileNotFoundException e16) {
                e16.printStackTrace();
                return;
            } catch (IOException e17) {
                e17.printStackTrace();
                return;
            }
        }
        a(1001, "Log path not exist or not directory!", new Throwable());
    }

    private static File c(String str, String str2, File file) {
        File[] listFiles = file.listFiles();
        for (int i3 = 0; i3 < listFiles.length; i3++) {
            String name = listFiles[i3].getName();
            if (name.startsWith(str) && name.endsWith(str2)) {
                listFiles[i3].delete();
            }
        }
        return new File(file, str + System.currentTimeMillis() + str2);
    }

    private void d(File file) {
        if (file.getAbsolutePath().endsWith(".zip.tmp")) {
            file.getAbsolutePath();
            return;
        }
        int i3 = this.f374796t;
        this.f374796t = i3 + 1;
        a(i3);
        file.getAbsolutePath();
        byte[] bArr = new byte[4096];
        BufferedInputStream bufferedInputStream = null;
        try {
            try {
                BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file), 4096);
                while (true) {
                    try {
                        int read = bufferedInputStream2.read(bArr, 0, 4096);
                        if (read != -1) {
                            this.f374795s.write(bArr, 0, read);
                        } else {
                            this.f374795s.flush();
                            try {
                                bufferedInputStream2.close();
                                return;
                            } catch (IOException e16) {
                                e16.printStackTrace();
                                return;
                            }
                        }
                    } catch (IOException e17) {
                        e = e17;
                        bufferedInputStream = bufferedInputStream2;
                        e.printStackTrace();
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                                return;
                            } catch (IOException e18) {
                                e18.printStackTrace();
                                return;
                            }
                        }
                        return;
                    } catch (Throwable th5) {
                        th = th5;
                        bufferedInputStream = bufferedInputStream2;
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (IOException e19) {
                                e19.printStackTrace();
                            }
                        }
                        throw th;
                    }
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (IOException e26) {
            e = e26;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't wrap try/catch for region: R(17:6|(4:9|(2:11|12)(2:14|15)|13|7)|16|(4:19|(4:22|(2:24|25)(2:27|28)|26|20)|29|17)|30|31|(2:34|32)|35|36|(3:125|126|127)|38|39|40|(4:41|42|(1:44)|(2:46|47))|48|49|(12:50|51|52|53|54|(2:55|(1:57)(1:58))|59|61|62|63|64|65)) */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0144, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0145, code lost:
    
        r0.printStackTrace();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0181 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x012d A[Catch: IOException -> 0x0149, all -> 0x0169, LOOP:4: B:55:0x0126->B:57:0x012d, LOOP_END, TryCatch #3 {all -> 0x0169, blocks: (B:54:0x0124, B:55:0x0126, B:57:0x012d, B:59:0x0131, B:71:0x0152), top: B:50:0x011b }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0131 A[EDGE_INSN: B:58:0x0131->B:59:0x0131 BREAK  A[LOOP:4: B:55:0x0126->B:57:0x012d], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x016c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v17, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r1v38 */
    /* JADX WARN: Type inference failed for: r1v39 */
    /* JADX WARN: Type inference failed for: r1v40 */
    /* JADX WARN: Type inference failed for: r1v41 */
    /* JADX WARN: Type inference failed for: r1v42 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.util.zip.ZipOutputStream] */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.io.RandomAccessFile] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:89:0x0145 -> B:55:0x0162). Please report as a decompilation issue!!! */
    @Override // com.tencent.tbs.one.impl.a.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a() {
        RandomAccessFile randomAccessFile;
        ?? r16;
        ByteArrayOutputStream byteArrayOutputStream;
        Throwable th5;
        FileInputStream fileInputStream;
        byte[] bArr;
        int read;
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        File file = new File(this.f374792p);
        if (!file.isDirectory()) {
            String str = "\"" + this.f374792p + "\" input path is not a Directory , please input the right path of the directory";
            a(1001, str, new Throwable(str));
            c();
            return;
        }
        File[] listFiles = file.listFiles();
        for (int i3 = 0; i3 < listFiles.length; i3++) {
            if (listFiles[i3].isDirectory()) {
                linkedList.add(listFiles[i3]);
            } else {
                linkedList2.add(listFiles[i3]);
            }
        }
        while (!linkedList.isEmpty()) {
            File[] listFiles2 = ((File) linkedList.removeFirst()).listFiles();
            for (int i16 = 0; i16 < listFiles2.length; i16++) {
                if (listFiles2[i16].isDirectory()) {
                    linkedList.add(listFiles2[i16]);
                } else {
                    linkedList2.add(listFiles2[i16]);
                }
            }
        }
        Collections.sort(linkedList2, new C9891a());
        Iterator it = linkedList2.iterator();
        while (it.hasNext()) {
            d((File) it.next());
        }
        ZipOutputStream zipOutputStream = this.f374795s;
        ?? r26 = 0;
        r2 = null;
        byte[] bArr2 = null;
        if (zipOutputStream != null) {
            try {
                try {
                    zipOutputStream.closeEntry();
                    this.f374795s.close();
                } finally {
                    this.f374795s = null;
                }
            } catch (IOException e16) {
                e16.printStackTrace();
            }
        }
        try {
            randomAccessFile = new RandomAccessFile(this.f374793q, "rw");
        } catch (Exception e17) {
            e = e17;
            randomAccessFile = null;
        } catch (Throwable th6) {
            th = th6;
            if (r26 != 0) {
            }
            throw th;
        }
        try {
            try {
                int parseInt = Integer.parseInt("00001000", 2);
                randomAccessFile.seek(7L);
                int read2 = randomAccessFile.read();
                int i17 = read2 & parseInt;
                int i18 = parseInt;
                if (i17 > 0) {
                    randomAccessFile.seek(7L);
                    int i19 = (~parseInt) & 255 & read2;
                    randomAccessFile.write(i19);
                    i18 = i19;
                }
                try {
                    randomAccessFile.close();
                    r16 = i18;
                } catch (IOException e18) {
                    g.c("Exception replace wrong zip byte! ", e18);
                    r16 = e18;
                }
            } catch (Throwable th7) {
                th = th7;
                r26 = randomAccessFile;
                if (r26 != 0) {
                    try {
                        r26.close();
                    } catch (IOException e19) {
                        g.c("Exception replace wrong zip byte! ", e19);
                    }
                }
                throw th;
            }
        } catch (Exception e26) {
            e = e26;
            g.c("Exception replace wrong zip byte! ", e);
            r16 = e;
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                    r16 = e;
                } catch (IOException e27) {
                    g.c("Exception replace wrong zip byte! ", e27);
                    r16 = e27;
                }
            }
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                fileInputStream = new FileInputStream(this.f374793q);
            } catch (IOException e28) {
                e = e28;
                fileInputStream = null;
            } catch (Throwable th8) {
                th5 = th8;
                r16 = 0;
                if (r16 != 0) {
                }
                try {
                    byteArrayOutputStream.close();
                    throw th5;
                } catch (IOException e29) {
                    e29.printStackTrace();
                    throw th5;
                }
            }
            try {
                bArr = new byte[8192];
                while (true) {
                    read = fileInputStream.read(bArr);
                    if (read != -1) {
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                byteArrayOutputStream.flush();
                bArr2 = byteArrayOutputStream.toByteArray();
                try {
                    fileInputStream.close();
                } catch (IOException e36) {
                    e36.printStackTrace();
                }
                byteArrayOutputStream.close();
            } catch (IOException e37) {
                e = e37;
                e.printStackTrace();
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e38) {
                        e38.printStackTrace();
                    }
                }
                byteArrayOutputStream.close();
                c();
                a((a) bArr2);
            }
            c();
            a((a) bArr2);
        }
        byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            fileInputStream = new FileInputStream(this.f374793q);
            bArr = new byte[8192];
            while (true) {
                read = fileInputStream.read(bArr);
                if (read != -1) {
                    break;
                } else {
                    byteArrayOutputStream.write(bArr, 0, read);
                }
            }
            byteArrayOutputStream.flush();
            bArr2 = byteArrayOutputStream.toByteArray();
            fileInputStream.close();
            byteArrayOutputStream.close();
            c();
            a((a) bArr2);
        } catch (Throwable th9) {
            th5 = th9;
            if (r16 != 0) {
                try {
                    r16.close();
                } catch (IOException e39) {
                    e39.printStackTrace();
                }
            }
            byteArrayOutputStream.close();
            throw th5;
        }
    }

    private void c() {
        File file = this.f374793q;
        if (file != null) {
            file.delete();
            this.f374793q = null;
        }
    }
}
