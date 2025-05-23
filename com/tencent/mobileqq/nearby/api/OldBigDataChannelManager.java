package com.tencent.mobileqq.nearby.api;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import mqq.manager.Manager;
import mqq.observer.AccountObserver;

/* compiled from: P */
/* loaded from: classes33.dex */
public class OldBigDataChannelManager implements Manager {

    /* renamed from: d, reason: collision with root package name */
    private AppInterface f252530d;

    /* renamed from: e, reason: collision with root package name */
    private byte[] f252531e = null;

    /* renamed from: f, reason: collision with root package name */
    private byte[] f252532f = null;

    /* renamed from: h, reason: collision with root package name */
    private String[] f252533h = null;

    /* renamed from: i, reason: collision with root package name */
    private int f252534i = 0;

    /* renamed from: m, reason: collision with root package name */
    private AccountObserver f252535m;

    public OldBigDataChannelManager(AppInterface appInterface) {
        AccountObserver accountObserver = new AccountObserver() { // from class: com.tencent.mobileqq.nearby.api.OldBigDataChannelManager.1
            @Override // mqq.observer.AccountObserver
            public void onExchangeUin(String str, String str2, String str3) {
                ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.nearby.api.OldBigDataChannelManager.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        OldBigDataChannelManager.this.c();
                        OldBigDataChannelManager.this.h();
                    }
                });
            }
        };
        this.f252535m = accountObserver;
        this.f252530d = appInterface;
        appInterface.registObserver(accountObserver);
        h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x00ad, code lost:
    
        if (r4 == null) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x00d3, code lost:
    
        if (com.tencent.qphone.base.util.QLog.isColorLevel() != false) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00d5, code lost:
    
        com.tencent.qphone.base.util.QLog.d("OldBigDataChannelManager", 2, "readSrvConfigFile | lastIpIndex = " + r9.f252534i);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00ec, code lost:
    
        r9.f252534i = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00ef, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00af, code lost:
    
        r4.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00cc, code lost:
    
        if (r4 == null) goto L43;
     */
    /* JADX WARN: Not initialized variable reg: 5, insn: 0x00f1: MOVE (r2 I:??[OBJECT, ARRAY]) = (r5 I:??[OBJECT, ARRAY]), block:B:68:0x00f1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void h() {
        ByteArrayInputStream byteArrayInputStream;
        ObjectInputStream objectInputStream;
        ObjectInputStream objectInputStream2;
        ObjectInputStream objectInputStream3 = null;
        try {
            try {
                File file = new File(this.f252530d.getApp().getFilesDir(), this.f252530d.getCurrentAccountUin() + IOldBigDataChannelManager.FILE_SUFFIX);
                if (file.exists()) {
                    byte[] fileToBytes = FileUtils.fileToBytes(file);
                    byteArrayInputStream = new ByteArrayInputStream(fileToBytes);
                    try {
                        objectInputStream = new ObjectInputStream(byteArrayInputStream);
                    } catch (Exception e16) {
                        e = e16;
                        objectInputStream = null;
                    } catch (Throwable th5) {
                        th = th5;
                        if (objectInputStream3 != null) {
                            try {
                                objectInputStream3.close();
                            } catch (IOException unused) {
                            }
                        }
                        if (byteArrayInputStream != null) {
                            try {
                                byteArrayInputStream.close();
                                throw th;
                            } catch (IOException unused2) {
                                throw th;
                            }
                        }
                        throw th;
                    }
                    try {
                        int readInt = objectInputStream.readInt();
                        if (readInt <= fileToBytes.length) {
                            if (readInt > 0) {
                                byte[] bArr = new byte[readInt];
                                this.f252531e = bArr;
                                objectInputStream.read(bArr);
                            }
                            int readInt2 = objectInputStream.readInt();
                            if (readInt2 <= fileToBytes.length) {
                                if (readInt2 > 0) {
                                    byte[] bArr2 = new byte[readInt2];
                                    this.f252532f = bArr2;
                                    objectInputStream.read(bArr2);
                                }
                                this.f252534i = objectInputStream.readInt();
                                this.f252533h = (String[]) objectInputStream.readObject();
                                objectInputStream3 = objectInputStream;
                            } else {
                                throw new RuntimeException("invalid sig size " + readInt2);
                            }
                        } else {
                            throw new RuntimeException("invalid key size " + readInt);
                        }
                    } catch (Exception e17) {
                        e = e17;
                        this.f252531e = null;
                        if (QLog.isColorLevel()) {
                            QLog.d("OldBigDataChannelManager", 2, "$readSrvConfigFile ", e);
                        }
                        if (objectInputStream != null) {
                            try {
                                objectInputStream.close();
                            } catch (IOException unused3) {
                            }
                        }
                    }
                } else {
                    byteArrayInputStream = null;
                }
                if (objectInputStream3 != null) {
                    try {
                        objectInputStream3.close();
                    } catch (IOException unused4) {
                    }
                }
            } catch (Exception e18) {
                e = e18;
                byteArrayInputStream = null;
                objectInputStream = null;
            } catch (Throwable th6) {
                th = th6;
                byteArrayInputStream = null;
            }
        } catch (Throwable th7) {
            th = th7;
            objectInputStream3 = objectInputStream2;
        }
    }

    public String d() {
        String[] strArr = this.f252533h;
        if (strArr == null || strArr.length == 0) {
            return null;
        }
        this.f252534i %= strArr.length;
        if (QLog.isColorLevel()) {
            QLog.d("OldBigDataChannelManager", 2, "getCircleSrvUrl | usingIndex = " + this.f252534i + " | count = " + strArr.length + " | result = " + strArr[this.f252534i]);
        }
        return strArr[this.f252534i];
    }

    public byte[] e() {
        return this.f252531e;
    }

    public byte[] f() {
        return this.f252532f;
    }

    public void g() {
        if (QLog.isColorLevel()) {
            QLog.d("OldBigDataChannelManager", 2, "onResponseException | current index = " + this.f252534i);
        }
        this.f252534i++;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0024 A[Catch: all -> 0x000c, TryCatch #0 {all -> 0x000c, blocks: (B:27:0x0005, B:29:0x0008, B:6:0x0011, B:8:0x0014, B:10:0x0019, B:12:0x001c, B:14:0x0024, B:15:0x0027, B:17:0x002d), top: B:26:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x002d A[Catch: all -> 0x000c, TRY_LEAVE, TryCatch #0 {all -> 0x000c, blocks: (B:27:0x0005, B:29:0x0008, B:6:0x0011, B:8:0x0014, B:10:0x0019, B:12:0x001c, B:14:0x0024, B:15:0x0027, B:17:0x002d), top: B:26:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void i(byte[] bArr, byte[] bArr2, String[] strArr) {
        boolean z16;
        boolean z17 = true;
        if (bArr != null) {
            try {
                if (bArr.length > 0) {
                    this.f252531e = bArr;
                    z16 = true;
                    if (bArr2 != null && bArr2.length > 0) {
                        this.f252532f = bArr2;
                        z16 = true;
                    }
                    if (strArr != null || strArr.length <= 0) {
                        z17 = z16;
                    } else {
                        this.f252534i = 0;
                        this.f252533h = strArr;
                    }
                    if (z17) {
                        j();
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("OldBigDataChannelManager", 2, "saveSrvParam | changed = " + z17 + " | usingIndex = " + this.f252534i);
                    }
                }
            } catch (Throwable th5) {
                throw th5;
            }
        }
        z16 = false;
        if (bArr2 != null) {
            this.f252532f = bArr2;
            z16 = true;
        }
        if (strArr != null) {
        }
        z17 = z16;
        if (z17) {
        }
        if (QLog.isColorLevel()) {
        }
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        this.f252530d.unRegistObserver(this.f252535m);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        this.f252531e = null;
        this.f252532f = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00ac A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void j() {
        ObjectOutputStream objectOutputStream;
        Throwable th5;
        Exception e16;
        ByteArrayOutputStream byteArrayOutputStream;
        byte[] bArr;
        byte[] bArr2;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        } catch (Exception e17) {
            objectOutputStream = null;
            e16 = e17;
        } catch (Throwable th6) {
            objectOutputStream = null;
            th5 = th6;
            if (objectOutputStream != null) {
            }
            throw th5;
        }
        try {
            try {
                try {
                    bArr = this.f252531e;
                } catch (Throwable th7) {
                    th5 = th7;
                    if (objectOutputStream != null) {
                        try {
                            objectOutputStream.close();
                        } catch (Exception unused) {
                        }
                    }
                    throw th5;
                }
            } catch (Exception e18) {
                e16 = e18;
                if (QLog.isColorLevel()) {
                    QLog.d("OldBigDataChannelManager", 2, "$writeSrvConfigFile | Exception:" + e16.getMessage());
                }
                if (objectOutputStream == null) {
                    return;
                }
                objectOutputStream.close();
            }
            if (bArr != null && bArr.length != 0) {
                objectOutputStream.writeInt(bArr.length);
                objectOutputStream.write(this.f252531e);
                bArr2 = this.f252532f;
                if (bArr2 != null && bArr2.length != 0) {
                    objectOutputStream.writeInt(bArr2.length);
                    objectOutputStream.write(this.f252532f);
                    objectOutputStream.writeInt(this.f252534i);
                    objectOutputStream.writeObject(this.f252533h);
                    objectOutputStream.flush();
                    FileUtils.pushData2File(new File(this.f252530d.getApp().getFilesDir(), this.f252530d.getCurrentAccountUin() + IOldBigDataChannelManager.FILE_SUFFIX).getAbsolutePath(), byteArrayOutputStream.toByteArray(), false);
                    objectOutputStream.close();
                }
                objectOutputStream.writeInt(0);
                objectOutputStream.writeInt(this.f252534i);
                objectOutputStream.writeObject(this.f252533h);
                objectOutputStream.flush();
                FileUtils.pushData2File(new File(this.f252530d.getApp().getFilesDir(), this.f252530d.getCurrentAccountUin() + IOldBigDataChannelManager.FILE_SUFFIX).getAbsolutePath(), byteArrayOutputStream.toByteArray(), false);
                objectOutputStream.close();
            }
            if (bArr2 != null) {
                objectOutputStream.writeInt(bArr2.length);
                objectOutputStream.write(this.f252532f);
                objectOutputStream.writeInt(this.f252534i);
                objectOutputStream.writeObject(this.f252533h);
                objectOutputStream.flush();
                FileUtils.pushData2File(new File(this.f252530d.getApp().getFilesDir(), this.f252530d.getCurrentAccountUin() + IOldBigDataChannelManager.FILE_SUFFIX).getAbsolutePath(), byteArrayOutputStream.toByteArray(), false);
                objectOutputStream.close();
            }
            objectOutputStream.close();
        } catch (Exception unused2) {
            return;
        }
        objectOutputStream.writeInt(0);
        bArr2 = this.f252532f;
        objectOutputStream.writeInt(0);
        objectOutputStream.writeInt(this.f252534i);
        objectOutputStream.writeObject(this.f252533h);
        objectOutputStream.flush();
        FileUtils.pushData2File(new File(this.f252530d.getApp().getFilesDir(), this.f252530d.getCurrentAccountUin() + IOldBigDataChannelManager.FILE_SUFFIX).getAbsolutePath(), byteArrayOutputStream.toByteArray(), false);
    }
}
