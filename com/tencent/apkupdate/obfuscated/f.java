package com.tencent.apkupdate.obfuscated;

import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes3.dex */
public class f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public LinkedHashMap<String, e> f72518a;

    /* renamed from: b, reason: collision with root package name */
    public LinkedHashMap<String, b> f72519b;

    /* renamed from: c, reason: collision with root package name */
    public ArrayList<String> f72520c;

    /* renamed from: d, reason: collision with root package name */
    public c f72521d;

    /* renamed from: e, reason: collision with root package name */
    public long f72522e;

    /* renamed from: f, reason: collision with root package name */
    public String f72523f;

    public f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f72518a = new LinkedHashMap<>();
        this.f72519b = new LinkedHashMap<>();
        this.f72520c = new ArrayList<>();
        this.f72521d = new c();
        this.f72522e = 0L;
        this.f72523f = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            return;
        }
        this.f72523f = str;
        RandomAccessFile randomAccessFile = new RandomAccessFile(str, "r");
        long length = randomAccessFile.length();
        this.f72522e = length;
        long j3 = 1024;
        if (1024 > length) {
            j3 = length;
        }
        byte[] bArr = new byte[1024];
        randomAccessFile.skipBytes((int) (length - j3));
        randomAccessFile.read(bArr, 0, (int) j3);
        int i3 = 0;
        while (i3 < j3 - 4) {
            int i16 = i3 + 1;
            if ((bArr[i3] << 24) + (bArr[i16] << RegisterType.UNINIT_REF) + (bArr[i3 + 2] << 8) + bArr[i3 + 3] == 1347093766) {
                try {
                    int i17 = i3 + 4;
                    DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr, i17, (int) (j3 - i17)));
                    this.f72521d.a(dataInputStream);
                    dataInputStream.close();
                } catch (IOException e16) {
                    e16.printStackTrace();
                }
            }
            i3 = i16;
        }
        randomAccessFile.close();
        Log.i("ZipFileParser", "readEndOfCentralDirRecord finished.");
        DataInputStream dataInputStream2 = new DataInputStream(new BufferedInputStream(new FileInputStream(this.f72523f)));
        dataInputStream2.skip(this.f72521d.f72509f);
        boolean z16 = false;
        while (dataInputStream2.available() >= 4 && !z16) {
            int readInt = dataInputStream2.readInt();
            if (readInt != 1347092738) {
                if (readInt == 1347093766) {
                    z16 = true;
                }
            } else {
                b bVar = new b();
                bVar.f72482a = a.d(dataInputStream2.readShort());
                bVar.f72483b = a.d(dataInputStream2.readShort());
                bVar.f72484c = a.d(dataInputStream2.readShort());
                bVar.f72485d = a.d(dataInputStream2.readShort());
                bVar.f72486e = a.d(dataInputStream2.readShort());
                bVar.f72487f = a.d(dataInputStream2.readShort());
                bVar.f72488g = a.a(dataInputStream2.readInt());
                bVar.f72489h = a.a(dataInputStream2.readInt());
                bVar.f72490i = a.a(dataInputStream2.readInt());
                bVar.f72491j = a.d(dataInputStream2.readShort());
                bVar.f72493l = a.d(dataInputStream2.readShort());
                bVar.f72494m = a.d(dataInputStream2.readShort());
                bVar.f72495n = a.d(dataInputStream2.readShort());
                bVar.f72496o = a.d(dataInputStream2.readShort());
                bVar.f72497p = a.a(dataInputStream2.readInt());
                bVar.f72498q = a.a(dataInputStream2.readInt());
                bVar.f72499r = false;
                int i18 = bVar.f72491j;
                byte[] bArr2 = new byte[i18];
                bVar.f72500s = bArr2;
                bVar.f72502u = new byte[bVar.f72493l];
                bVar.f72503v = new byte[bVar.f72494m];
                dataInputStream2.read(bArr2, 0, i18);
                dataInputStream2.read(bVar.f72502u, 0, bVar.f72493l);
                dataInputStream2.read(bVar.f72503v, 0, bVar.f72494m);
                String str2 = new String(bVar.f72500s, Charset.defaultCharset().name());
                if (str2.startsWith("META-INF/")) {
                    this.f72520c.add(str2);
                }
                this.f72519b.put(str2, bVar);
            }
        }
        dataInputStream2.close();
        Log.i("ZipFileParser", "readCentralDirFileHeaderList finished.");
        DataInputStream dataInputStream3 = new DataInputStream(new BufferedInputStream(new FileInputStream(this.f72523f)));
        boolean z17 = false;
        while (dataInputStream3.available() >= 4 && !z17) {
            int readInt2 = dataInputStream3.readInt();
            if (readInt2 != 1347092738) {
                if (readInt2 != 1347093252) {
                    if (readInt2 != 1347093766) {
                        if (readInt2 == 1347094280) {
                            dataInputStream3.skipBytes(12);
                        }
                    }
                } else {
                    e eVar = new e();
                    dataInputStream3.readShort();
                    dataInputStream3.readShort();
                    dataInputStream3.readShort();
                    dataInputStream3.readShort();
                    dataInputStream3.readShort();
                    dataInputStream3.readInt();
                    eVar.f72513a = a.a(dataInputStream3.readInt());
                    dataInputStream3.readInt();
                    eVar.f72514b = a.d(dataInputStream3.readShort());
                    int d16 = a.d(dataInputStream3.readShort());
                    eVar.f72515c = d16;
                    int i19 = eVar.f72514b;
                    byte[] bArr3 = new byte[i19];
                    eVar.f72516d = bArr3;
                    eVar.f72517e = new byte[d16];
                    dataInputStream3.read(bArr3, 0, i19);
                    dataInputStream3.read(eVar.f72517e, 0, eVar.f72515c);
                    String str3 = new String(eVar.f72516d, Charset.defaultCharset().name());
                    b bVar2 = this.f72519b.get(str3);
                    short s16 = eVar.f72515c;
                    bVar2.f72492k = s16;
                    if (s16 > 0) {
                        bVar2.f72501t = (byte[]) eVar.f72517e.clone();
                    }
                    int i26 = bVar2.f72489h;
                    eVar.f72513a = i26;
                    dataInputStream3.skipBytes(i26);
                    this.f72518a.put(str3, eVar);
                }
            }
            z17 = true;
        }
        dataInputStream3.close();
        Log.i("ZipFileParser", "readLocalFileHeader finished.");
    }
}
