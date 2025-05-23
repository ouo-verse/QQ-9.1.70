package com.tencent.mobileqq.mini.entry.desktop.item;

import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/* compiled from: P */
/* loaded from: classes33.dex */
public class DeskTopAppEntity extends Entity {
    public static final String TAG = "DeskTopAppInfoEntity";
    public String appId;
    public byte[] appInfo;
    public String name;

    @unique
    public String uniqueId;
    public int verType;

    public DeskTopAppEntity() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0040, code lost:
    
        if (r5 == null) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x002b, code lost:
    
        if (r5 == null) goto L31;
     */
    /* JADX WARN: Not initialized variable reg: 5, insn: 0x0044: IF  (r5 I:??[int, boolean, OBJECT, ARRAY, byte, short, char]) == (0 ??[int, boolean, OBJECT, ARRAY, byte, short, char])  -> B:31:0x0049, block:B:30:0x0044 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private byte[] packAppInfo(MiniAppInfo miniAppInfo) {
        ObjectOutputStream objectOutputStream;
        ObjectOutputStream objectOutputStream2;
        try {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                try {
                    objectOutputStream.writeObject(miniAppInfo);
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    try {
                        objectOutputStream.close();
                    } catch (IOException unused) {
                    }
                    return byteArray;
                } catch (NotSerializableException e16) {
                    e = e16;
                    QLog.e(TAG, 1, "packAppInfo failed!", e);
                } catch (IOException e17) {
                    e = e17;
                    QLog.e(TAG, 1, "packAppInfo failed!", e);
                    if (objectOutputStream != null) {
                        try {
                            objectOutputStream.close();
                        } catch (IOException unused2) {
                            return null;
                        }
                    }
                    return null;
                } catch (Throwable th5) {
                    th = th5;
                    QLog.e(TAG, 1, "packAppInfo fatal!", th);
                }
            } catch (NotSerializableException e18) {
                e = e18;
                objectOutputStream = null;
            } catch (IOException e19) {
                e = e19;
                objectOutputStream = null;
            } catch (Throwable th6) {
                th = th6;
                objectOutputStream = null;
            }
        } catch (Throwable th7) {
            if (objectOutputStream2 != null) {
                try {
                    objectOutputStream2.close();
                } catch (IOException unused3) {
                }
            }
            throw th7;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0041, code lost:
    
        if (r4 == null) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x002c, code lost:
    
        if (r4 == null) goto L36;
     */
    /* JADX WARN: Not initialized variable reg: 4, insn: 0x0044: IF  (r4 I:??[int, boolean, OBJECT, ARRAY, byte, short, char]) == (0 ??[int, boolean, OBJECT, ARRAY, byte, short, char])  -> B:32:0x0049, block:B:31:0x0044 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public MiniAppInfo createAppInfoFromBuffer(byte[] bArr) {
        ObjectInputStream objectInputStream;
        ObjectInputStream objectInputStream2;
        if (bArr != null) {
            try {
                try {
                    objectInputStream = new ObjectInputStream(new ByteArrayInputStream(bArr));
                } catch (IOException e16) {
                    e = e16;
                    objectInputStream = null;
                } catch (ClassNotFoundException e17) {
                    e = e17;
                    objectInputStream = null;
                } catch (Throwable th5) {
                    th = th5;
                    objectInputStream = null;
                }
                try {
                    MiniAppInfo miniAppInfo = (MiniAppInfo) objectInputStream.readObject();
                    try {
                        objectInputStream.close();
                    } catch (IOException unused) {
                    }
                    return miniAppInfo;
                } catch (IOException e18) {
                    e = e18;
                    QLog.e(TAG, 1, "createAppInfoFromBuffer failed!", e);
                } catch (ClassNotFoundException e19) {
                    e = e19;
                    QLog.e(TAG, 1, "createAppInfoFromBuffer failed!", e);
                    if (objectInputStream != null) {
                        try {
                            objectInputStream.close();
                        } catch (IOException unused2) {
                        }
                    }
                    return null;
                } catch (Throwable th6) {
                    th = th6;
                    QLog.e(TAG, 1, "createAppInfoFromBuffer fatal!", th);
                }
            } catch (Throwable th7) {
                if (objectInputStream2 != null) {
                    try {
                        objectInputStream2.close();
                    } catch (IOException unused3) {
                    }
                }
                throw th7;
            }
        }
        return null;
    }

    public DeskTopAppEntity(MiniAppInfo miniAppInfo) {
        this.uniqueId = miniAppInfo.appId + "_" + this.verType;
        this.appId = miniAppInfo.appId;
        this.name = miniAppInfo.name;
        this.verType = miniAppInfo.verType;
        this.appInfo = packAppInfo(miniAppInfo);
    }
}
