package com.tencent.apkupdate.obfuscated;

import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Iterator;
import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes3.dex */
public class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f72512a;

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f72512a = new byte[4096];
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x01f9, code lost:
    
        if (r5 == null) goto L123;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01f1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01e7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int a(String str, String str2, String str3) {
        DataOutputStream dataOutputStream;
        DataInputStream dataInputStream;
        f fVar;
        RandomAccessFile randomAccessFile;
        LinkedList linkedList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, this, str, str2, str3)).intValue();
        }
        Log.i("GenNewApkV2", "start parser old apk file.");
        RandomAccessFile randomAccessFile2 = null;
        int i3 = 0;
        try {
            fVar = new f();
        } catch (Throwable unused) {
        }
        try {
            fVar.a(str);
            Log.i("GenNewApkV2", "parse old apk file finished.");
            try {
                dataInputStream = new DataInputStream(new BufferedInputStream(new FileInputStream(str2)));
                try {
                    try {
                        dataOutputStream = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(str3)));
                    } catch (FileNotFoundException e16) {
                        e16.printStackTrace();
                        try {
                            throw new Throwable();
                        } catch (Throwable unused2) {
                            i3 = -3;
                            dataOutputStream = null;
                            try {
                                Log.i("GenNewApkV2", "err code = " + i3);
                                if (randomAccessFile2 != null) {
                                }
                                if (dataOutputStream != null) {
                                }
                            } finally {
                            }
                        }
                    }
                } catch (Throwable unused3) {
                    dataOutputStream = null;
                    Log.i("GenNewApkV2", "err code = " + i3);
                    if (randomAccessFile2 != null) {
                    }
                    if (dataOutputStream != null) {
                    }
                }
                try {
                    try {
                        randomAccessFile = new RandomAccessFile(str, "r");
                        try {
                            linkedList = new LinkedList();
                        } catch (Throwable unused4) {
                        }
                    } catch (Throwable unused5) {
                    }
                    try {
                        int readInt = dataInputStream.readInt();
                        for (int i16 = 0; i16 < readInt; i16++) {
                            try {
                                b bVar = new b();
                                bVar.a(dataInputStream);
                                linkedList.add(bVar);
                            } catch (IOException e17) {
                                e17.printStackTrace();
                                try {
                                    throw new Throwable();
                                } catch (Throwable unused6) {
                                    i3 = -5;
                                    randomAccessFile2 = randomAccessFile;
                                    Log.i("GenNewApkV2", "err code = " + i3);
                                    if (randomAccessFile2 != null) {
                                    }
                                    if (dataOutputStream != null) {
                                    }
                                }
                            } catch (ClassNotFoundException e18) {
                                e18.printStackTrace();
                                try {
                                    throw new Throwable();
                                } catch (Throwable unused7) {
                                    i3 = -6;
                                    randomAccessFile2 = randomAccessFile;
                                    Log.i("GenNewApkV2", "err code = " + i3);
                                    if (randomAccessFile2 != null) {
                                    }
                                    if (dataOutputStream != null) {
                                    }
                                }
                            }
                        }
                        Log.i("GenNewApkV2", "read patch file headed finished.");
                        try {
                            Iterator it = linkedList.iterator();
                            while (it.hasNext()) {
                                b bVar2 = (b) it.next();
                                bVar2.f72484c = (short) 0;
                                if (bVar2.f72499r) {
                                    b(bVar2, dataInputStream, dataOutputStream);
                                } else {
                                    c(bVar2, randomAccessFile, fVar, dataOutputStream);
                                }
                            }
                            Log.i("GenNewApkV2", "writeLocalFileHeaderAndData finished.");
                            int size = dataOutputStream.size();
                            try {
                                Iterator it5 = linkedList.iterator();
                                while (it5.hasNext()) {
                                    ((b) it5.next()).b(dataOutputStream);
                                }
                                try {
                                    int readInt2 = dataInputStream.readInt();
                                    int size2 = dataOutputStream.size() - size;
                                    if (readInt2 == 1347093766) {
                                        short d16 = a.d(dataInputStream.readShort());
                                        short d17 = a.d(dataInputStream.readShort());
                                        short d18 = a.d(dataInputStream.readShort());
                                        short d19 = a.d(dataInputStream.readShort());
                                        dataInputStream.readInt();
                                        dataInputStream.readInt();
                                        int d26 = a.d(dataInputStream.readShort());
                                        byte[] bArr = new byte[d26];
                                        dataInputStream.read(bArr, 0, d26);
                                        dataOutputStream.writeInt(1347093766);
                                        dataOutputStream.writeShort(a.d(d16));
                                        dataOutputStream.writeShort(a.d(d17));
                                        dataOutputStream.writeShort(a.d(d18));
                                        dataOutputStream.writeShort(a.d(d19));
                                        dataOutputStream.writeInt(a.a(size2));
                                        dataOutputStream.writeInt(a.a(size));
                                        dataOutputStream.writeShort(a.d(d26));
                                        if (d26 > 0) {
                                            dataOutputStream.write(bArr);
                                        }
                                        Log.i("GenNewApkV2", "write EndOfCentralDirRecord finished.");
                                        try {
                                            randomAccessFile.close();
                                        } catch (IOException e19) {
                                            e19.printStackTrace();
                                        }
                                        try {
                                            dataOutputStream.close();
                                        } catch (IOException e26) {
                                            e26.printStackTrace();
                                        }
                                        try {
                                            dataInputStream.close();
                                        } catch (IOException e27) {
                                            e27.printStackTrace();
                                        }
                                        return i3;
                                    }
                                    throw new Throwable();
                                } catch (Exception e28) {
                                    e28.printStackTrace();
                                    try {
                                        throw new Throwable();
                                    } catch (Throwable unused8) {
                                        i3 = -9;
                                        randomAccessFile2 = randomAccessFile;
                                        Log.i("GenNewApkV2", "err code = " + i3);
                                        if (randomAccessFile2 != null) {
                                        }
                                        if (dataOutputStream != null) {
                                        }
                                    }
                                }
                            } catch (IOException e29) {
                                e29.printStackTrace();
                                try {
                                    throw new Throwable();
                                } catch (Throwable unused9) {
                                    i3 = -7;
                                    randomAccessFile2 = randomAccessFile;
                                    Log.i("GenNewApkV2", "err code = " + i3);
                                    if (randomAccessFile2 != null) {
                                    }
                                    if (dataOutputStream != null) {
                                    }
                                }
                            }
                        } catch (Exception e36) {
                            e36.printStackTrace();
                            try {
                                throw new Throwable();
                            } catch (Throwable unused10) {
                                i3 = -10;
                                randomAccessFile2 = randomAccessFile;
                                Log.i("GenNewApkV2", "err code = " + i3);
                                if (randomAccessFile2 != null) {
                                }
                                if (dataOutputStream != null) {
                                }
                            }
                        }
                    } catch (IOException e37) {
                        e37.printStackTrace();
                        try {
                            throw new Throwable();
                        } catch (Throwable unused11) {
                            i3 = -4;
                            randomAccessFile2 = randomAccessFile;
                            Log.i("GenNewApkV2", "err code = " + i3);
                            if (randomAccessFile2 != null) {
                            }
                            if (dataOutputStream != null) {
                            }
                        }
                    }
                } catch (FileNotFoundException e38) {
                    e38.printStackTrace();
                    try {
                        throw new Throwable();
                    } catch (Throwable unused12) {
                        i3 = -1;
                        Log.i("GenNewApkV2", "err code = " + i3);
                        if (randomAccessFile2 != null) {
                            try {
                                randomAccessFile2.close();
                            } catch (IOException e39) {
                                e39.printStackTrace();
                            }
                        }
                        if (dataOutputStream != null) {
                            try {
                                dataOutputStream.close();
                            } catch (IOException e46) {
                                e46.printStackTrace();
                            }
                        }
                    }
                }
            } catch (FileNotFoundException e47) {
                e47.printStackTrace();
                try {
                    throw new Throwable();
                } catch (Throwable unused13) {
                    i3 = -2;
                    dataOutputStream = null;
                    dataInputStream = null;
                    Log.i("GenNewApkV2", "err code = " + i3);
                    if (randomAccessFile2 != null) {
                    }
                    if (dataOutputStream != null) {
                    }
                }
            }
        } catch (IOException e48) {
            e48.printStackTrace();
            try {
                throw new Throwable();
            } catch (Throwable unused14) {
                i3 = -1;
                dataOutputStream = null;
                dataInputStream = null;
                Log.i("GenNewApkV2", "err code = " + i3);
                if (randomAccessFile2 != null) {
                }
                if (dataOutputStream != null) {
                }
            }
        }
    }

    public final void b(b bVar, DataInputStream dataInputStream, DataOutputStream dataOutputStream) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, bVar, dataInputStream, dataOutputStream);
            return;
        }
        e.a(bVar, dataOutputStream);
        int i3 = bVar.f72489h;
        while (true) {
            z16 = false;
            if (i3 <= 0) {
                break;
            }
            int i16 = 4096;
            if (i3 <= 4096) {
                i16 = i3;
            }
            int read = dataInputStream.read(this.f72512a, 0, i16);
            if (read > 0) {
                dataOutputStream.write(this.f72512a, 0, read);
                i3 -= read;
            }
        }
        if ((bVar.f72484c & 8) != 0) {
            z16 = true;
        }
        if (z16) {
            a.e(bVar, dataOutputStream);
        }
    }

    public final void c(b bVar, RandomAccessFile randomAccessFile, f fVar, DataOutputStream dataOutputStream) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, bVar, randomAccessFile, fVar, dataOutputStream);
            return;
        }
        String str = new String(bVar.f72500s, "utf-8");
        b bVar2 = fVar.f72519b.get(str);
        if (bVar2 != null) {
            bVar.f72485d = bVar2.f72485d;
            bVar.f72489h = bVar2.f72489h;
            bVar.f72488g = bVar2.f72488g;
            bVar.f72492k = bVar2.f72492k;
            bVar.f72501t = bVar2.f72501t;
            bVar.f72493l = bVar2.f72493l;
            bVar.f72502u = bVar2.f72502u;
            e.a(bVar, dataOutputStream);
            int i3 = bVar.f72489h;
            if (i3 > 0) {
                if (fVar.f72519b.get(str) != null) {
                    if (fVar.f72518a.get(str) != null) {
                        randomAccessFile.seek(r9.f72514b + 30 + r9.f72515c + r4.f72498q);
                        while (i3 > 0) {
                            int i16 = 4096;
                            if (i3 <= 4096) {
                                i16 = i3;
                            }
                            int read = randomAccessFile.read(this.f72512a, 0, i16);
                            if (read > 0) {
                                dataOutputStream.write(this.f72512a, 0, read);
                                i3 -= read;
                            }
                        }
                    } else {
                        throw new FileNotFoundException();
                    }
                } else {
                    throw new FileNotFoundException();
                }
            }
            if ((bVar.f72484c & 8) == 0) {
                z16 = false;
            }
            if (z16) {
                a.e(bVar, dataOutputStream);
                return;
            }
            return;
        }
        throw new Exception();
    }
}
