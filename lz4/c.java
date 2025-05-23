package lz4;

import android.content.Context;
import android.text.TextUtils;
import android.text.format.Formatter;
import android.util.Base64;
import com.xiaomi.push.ag;
import com.xiaomi.push.an;
import com.xiaomi.push.fu;
import com.xiaomi.push.in;
import com.xiaomi.push.ip;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* compiled from: P */
/* loaded from: classes22.dex */
public class c implements a {

    /* renamed from: a, reason: collision with root package name */
    protected Context f415861a;

    /* renamed from: b, reason: collision with root package name */
    private HashMap<String, ArrayList<kz4.d>> f415862b;

    public c(Context context) {
        f(context);
    }

    public static String d(kz4.d dVar) {
        return String.valueOf(dVar.f413529a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x006c, code lost:
    
        jz4.c.B("eventData read from cache file failed cause lengthBuffer < 1 || lengthBuffer > 4K");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private List<String> e(String str) {
        ArrayList arrayList = new ArrayList();
        byte[] bArr = new byte[4];
        byte[] bArr2 = new byte[4];
        FileInputStream fileInputStream = null;
        try {
            try {
                FileInputStream fileInputStream2 = new FileInputStream(new File(str));
                while (true) {
                    try {
                        int read = fileInputStream2.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        if (read != 4) {
                            jz4.c.B("eventData read from cache file failed because magicNumber error");
                            break;
                        }
                        if (ip.a(bArr) != -573785174) {
                            jz4.c.B("eventData read from cache file failed because magicNumber error");
                            break;
                        }
                        int read2 = fileInputStream2.read(bArr2);
                        if (read2 == -1) {
                            break;
                        }
                        if (read2 != 4) {
                            jz4.c.B("eventData read from cache file failed cause lengthBuffer error");
                            break;
                        }
                        int a16 = ip.a(bArr2);
                        if (a16 < 1 || a16 > 4096) {
                            break;
                        }
                        byte[] bArr3 = new byte[a16];
                        if (fileInputStream2.read(bArr3) != a16) {
                            jz4.c.B("eventData read from cache file failed cause buffer size not equal length");
                            break;
                        }
                        String m3 = m(bArr3);
                        if (!TextUtils.isEmpty(m3)) {
                            arrayList.add(m3);
                        }
                    } catch (Exception e16) {
                        e = e16;
                        fileInputStream = fileInputStream2;
                        jz4.c.q(e);
                        in.b(fileInputStream);
                        return arrayList;
                    } catch (Throwable th5) {
                        th = th5;
                        fileInputStream = fileInputStream2;
                        in.b(fileInputStream);
                        throw th;
                    }
                }
                in.b(fileInputStream2);
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (Exception e17) {
            e = e17;
        }
        return arrayList;
    }

    private void g(RandomAccessFile randomAccessFile, FileLock fileLock) {
        if (fileLock != null && fileLock.isValid()) {
            try {
                fileLock.release();
            } catch (IOException e16) {
                jz4.c.q(e16);
            }
        }
        in.b(randomAccessFile);
    }

    private void h(String str, String str2) {
        kz4.b f16 = com.xiaomi.clientreport.manager.a.c(this.f415861a).f(5001, "24:" + str + "," + str2);
        ArrayList arrayList = new ArrayList();
        arrayList.add(f16.d());
        i(arrayList);
    }

    private kz4.d[] k(kz4.d[] dVarArr) {
        FileLock fileLock;
        RandomAccessFile randomAccessFile;
        BufferedOutputStream bufferedOutputStream;
        String l3 = l(dVarArr[0]);
        BufferedOutputStream bufferedOutputStream2 = null;
        if (TextUtils.isEmpty(l3)) {
            return null;
        }
        try {
            File file = new File(l3 + ".lock");
            in.f(file);
            randomAccessFile = new RandomAccessFile(file, "rw");
            try {
                fileLock = randomAccessFile.getChannel().lock();
            } catch (Exception e16) {
                e = e16;
                fileLock = null;
                bufferedOutputStream = null;
            } catch (Throwable th5) {
                th = th5;
                fileLock = null;
            }
        } catch (Exception e17) {
            e = e17;
            fileLock = null;
            randomAccessFile = null;
            bufferedOutputStream = null;
        } catch (Throwable th6) {
            th = th6;
            fileLock = null;
            randomAccessFile = null;
        }
        try {
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File(l3), true));
        } catch (Exception e18) {
            e = e18;
            bufferedOutputStream = null;
        } catch (Throwable th7) {
            th = th7;
            in.b(bufferedOutputStream2);
            g(randomAccessFile, fileLock);
            throw th;
        }
        try {
            try {
                int i3 = 0;
                for (kz4.d dVar : dVarArr) {
                    if (dVar != null) {
                        byte[] n3 = n(dVar.d());
                        if (n3 != null && n3.length >= 1 && n3.length <= 4096) {
                            if (!an.d(this.f415861a, l3)) {
                                int length = dVarArr.length - i3;
                                kz4.d[] dVarArr2 = new kz4.d[length];
                                System.arraycopy(dVarArr, i3, dVarArr2, 0, length);
                                in.b(bufferedOutputStream);
                                g(randomAccessFile, fileLock);
                                return dVarArr2;
                            }
                            bufferedOutputStream.write(ip.b(-573785174));
                            bufferedOutputStream.write(ip.b(n3.length));
                            bufferedOutputStream.write(n3);
                            bufferedOutputStream.flush();
                            i3++;
                        }
                        jz4.c.B("event data throw a invalid item ");
                    }
                }
            } catch (Throwable th8) {
                th = th8;
                bufferedOutputStream2 = bufferedOutputStream;
                in.b(bufferedOutputStream2);
                g(randomAccessFile, fileLock);
                throw th;
            }
        } catch (Exception e19) {
            e = e19;
            jz4.c.o("event data write to cache file failed cause exception", e);
            in.b(bufferedOutputStream);
            g(randomAccessFile, fileLock);
            return null;
        }
        in.b(bufferedOutputStream);
        g(randomAccessFile, fileLock);
        return null;
    }

    private String l(kz4.d dVar) {
        File file = new File(this.f415861a.getFilesDir(), "event");
        String str = file.getAbsolutePath() + File.separator + d(dVar);
        for (int i3 = 0; i3 < 100; i3++) {
            String str2 = str + i3;
            if (an.d(this.f415861a, str2)) {
                return str2;
            }
        }
        return null;
    }

    @Override // lz4.e
    public void a() {
        int i3;
        an.c(this.f415861a, "event", "eventUploading");
        File[] f16 = an.f(this.f415861a, "eventUploading");
        if (f16 == null || f16.length <= 0) {
            return;
        }
        FileLock fileLock = null;
        File file = null;
        RandomAccessFile randomAccessFile = null;
        for (File file2 : f16) {
            if (file2 == null) {
                if (fileLock != null && fileLock.isValid()) {
                    try {
                        fileLock.release();
                    } catch (IOException e16) {
                        jz4.c.q(e16);
                    }
                }
                in.b(randomAccessFile);
                i3 = file == null ? i3 + 1 : 0;
                file.delete();
            } else {
                try {
                    try {
                    } catch (Exception e17) {
                        e = e17;
                    }
                    if (file2.length() > 5242880) {
                        jz4.c.B("eventData read from cache file failed because " + file2.getName() + " is too big, length " + file2.length());
                        h(file2.getName(), Formatter.formatFileSize(this.f415861a, file2.length()));
                        file2.delete();
                        if (fileLock != null && fileLock.isValid()) {
                            try {
                                fileLock.release();
                            } catch (IOException e18) {
                                jz4.c.q(e18);
                            }
                        }
                        in.b(randomAccessFile);
                        if (file == null) {
                        }
                        file.delete();
                    } else {
                        String absolutePath = file2.getAbsolutePath();
                        File file3 = new File(absolutePath + ".lock");
                        try {
                            in.f(file3);
                            RandomAccessFile randomAccessFile2 = new RandomAccessFile(file3, "rw");
                            try {
                                fileLock = randomAccessFile2.getChannel().lock();
                                i(e(absolutePath));
                                file2.delete();
                                if (fileLock != null && fileLock.isValid()) {
                                    try {
                                        fileLock.release();
                                    } catch (IOException e19) {
                                        jz4.c.q(e19);
                                    }
                                }
                                in.b(randomAccessFile2);
                                file3.delete();
                                randomAccessFile = randomAccessFile2;
                                file = file3;
                            } catch (Exception e26) {
                                e = e26;
                                randomAccessFile = randomAccessFile2;
                                file = file3;
                                jz4.c.q(e);
                                if (fileLock != null && fileLock.isValid()) {
                                    try {
                                        fileLock.release();
                                    } catch (IOException e27) {
                                        jz4.c.q(e27);
                                    }
                                }
                                in.b(randomAccessFile);
                                if (file == null) {
                                }
                                file.delete();
                            } catch (Throwable th5) {
                                th = th5;
                                randomAccessFile = randomAccessFile2;
                                file = file3;
                                if (fileLock != null && fileLock.isValid()) {
                                    try {
                                        fileLock.release();
                                    } catch (IOException e28) {
                                        jz4.c.q(e28);
                                    }
                                }
                                in.b(randomAccessFile);
                                if (file != null) {
                                    file.delete();
                                    throw th;
                                }
                                throw th;
                            }
                        } catch (Exception e29) {
                            e = e29;
                        } catch (Throwable th6) {
                            th = th6;
                        }
                    }
                } catch (Throwable th7) {
                    th = th7;
                }
            }
        }
    }

    @Override // lz4.f
    public void b() {
        HashMap<String, ArrayList<kz4.d>> hashMap = this.f415862b;
        if (hashMap == null) {
            return;
        }
        if (hashMap.size() > 0) {
            Iterator<String> it = this.f415862b.keySet().iterator();
            while (it.hasNext()) {
                ArrayList<kz4.d> arrayList = this.f415862b.get(it.next());
                if (arrayList != null && arrayList.size() > 0) {
                    kz4.d[] dVarArr = new kz4.d[arrayList.size()];
                    arrayList.toArray(dVarArr);
                    j(dVarArr);
                }
            }
        }
        this.f415862b.clear();
    }

    public void f(Context context) {
        this.f415861a = context;
    }

    public void i(List<String> list) {
        throw null;
    }

    public void j(kz4.d[] dVarArr) {
        if (dVarArr == null || dVarArr.length == 0 || dVarArr[0] == null) {
            jz4.c.m("event data write to cache file failed because data null");
            return;
        }
        do {
            dVarArr = k(dVarArr);
            if (dVarArr == null || dVarArr.length <= 0) {
                return;
            }
        } while (dVarArr[0] != null);
    }

    public String m(byte[] bArr) {
        byte[] e16;
        if (bArr != null && bArr.length >= 1) {
            if (!com.xiaomi.clientreport.manager.a.c(this.f415861a).e().f()) {
                return ag.l(bArr);
            }
            String b16 = an.b(this.f415861a);
            if (!TextUtils.isEmpty(b16) && (e16 = an.e(b16)) != null && e16.length > 0) {
                try {
                    return ag.l(Base64.decode(fu.b(e16, bArr), 2));
                } catch (InvalidAlgorithmParameterException e17) {
                    jz4.c.q(e17);
                } catch (InvalidKeyException e18) {
                    jz4.c.q(e18);
                } catch (NoSuchAlgorithmException e19) {
                    jz4.c.q(e19);
                } catch (BadPaddingException e26) {
                    jz4.c.q(e26);
                } catch (IllegalBlockSizeException e27) {
                    jz4.c.q(e27);
                } catch (NoSuchPaddingException e28) {
                    jz4.c.q(e28);
                }
            }
        }
        return null;
    }

    public byte[] n(String str) {
        byte[] e16;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!com.xiaomi.clientreport.manager.a.c(this.f415861a).e().f()) {
            return ag.j(str);
        }
        String b16 = an.b(this.f415861a);
        byte[] j3 = ag.j(str);
        if (!TextUtils.isEmpty(b16) && j3 != null && j3.length > 1 && (e16 = an.e(b16)) != null) {
            try {
                if (e16.length > 1) {
                    return fu.c(e16, Base64.encode(j3, 2));
                }
            } catch (Exception e17) {
                jz4.c.q(e17);
            }
        }
        return null;
    }

    @Override // lz4.f
    public void b(kz4.d dVar) {
        if ((dVar instanceof kz4.b) && this.f415862b != null) {
            kz4.b bVar = (kz4.b) dVar;
            String d16 = d(bVar);
            ArrayList<kz4.d> arrayList = this.f415862b.get(d16);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
            }
            arrayList.add(bVar);
            this.f415862b.put(d16, arrayList);
        }
    }

    @Override // lz4.a
    public void a(HashMap<String, ArrayList<kz4.d>> hashMap) {
        this.f415862b = hashMap;
    }
}
