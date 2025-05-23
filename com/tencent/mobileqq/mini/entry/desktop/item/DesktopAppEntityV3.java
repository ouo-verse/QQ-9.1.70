package com.tencent.mobileqq.mini.entry.desktop.item;

import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.utils.FastClickUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/* compiled from: P */
/* loaded from: classes33.dex */
public class DesktopAppEntityV3 extends Entity {
    public static final String TAG = "DesktopAppInfoEntityV2";
    public String appId;
    public byte[] appInfo;
    public String name;

    @unique
    public String uniqueId;
    public int verType;

    public DesktopAppEntityV3() {
    }

    private byte[] packAppInfo(MiniAppInfo miniAppInfo) {
        ObjectOutputStream objectOutputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            try {
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                } catch (NotSerializableException e16) {
                    e = e16;
                    objectOutputStream = null;
                } catch (IOException e17) {
                    e = e17;
                    objectOutputStream = null;
                } catch (Throwable th5) {
                    th = th5;
                    objectOutputStream = null;
                }
                try {
                    objectOutputStream.writeObject(miniAppInfo);
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    try {
                        objectOutputStream.close();
                    } catch (IOException e18) {
                        QLog.e(TAG, 1, "packAppInfo close e:", e18);
                    }
                    return byteArray;
                } catch (NotSerializableException e19) {
                    e = e19;
                    QLog.e(TAG, 1, "packAppInfo failed!", e);
                    if (objectOutputStream != null) {
                        objectOutputStream.close();
                    }
                    return null;
                } catch (IOException e26) {
                    e = e26;
                    QLog.e(TAG, 1, "packAppInfo failed!", e);
                    if (objectOutputStream != null) {
                        objectOutputStream.close();
                    }
                    return null;
                } catch (Throwable th6) {
                    th = th6;
                    QLog.e(TAG, 1, "packAppInfo fatal!", th);
                    if (objectOutputStream != null) {
                        objectOutputStream.close();
                    }
                    return null;
                }
            } catch (IOException e27) {
                QLog.e(TAG, 1, "packAppInfo close e:", e27);
                return null;
            }
        } catch (Throwable th7) {
            if (objectOutputStream != null) {
                try {
                    objectOutputStream.close();
                } catch (IOException e28) {
                    QLog.e(TAG, 1, "packAppInfo close e:", e28);
                }
            }
            throw th7;
        }
    }

    /* JADX WARN: Not initialized variable reg: 4, insn: 0x0055: IF  (r4 I:??[int, boolean, OBJECT, ARRAY, byte, short, char]) == (0 ??[int, boolean, OBJECT, ARRAY, byte, short, char])  -> B:34:0x005f, block:B:33:0x0055 */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0043 A[Catch: all -> 0x0054, TRY_LEAVE, TryCatch #4 {all -> 0x0054, blocks: (B:28:0x002b, B:19:0x003d, B:21:0x0043), top: B:5:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x004b A[Catch: IOException -> 0x004f, TRY_ENTER, TRY_LEAVE, TryCatch #7 {IOException -> 0x004f, blocks: (B:30:0x0033, B:23:0x004b), top: B:4:0x000a }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public MiniAppInfo createAppInfoFromBuffer(byte[] bArr) {
        ObjectInputStream objectInputStream;
        ObjectInputStream objectInputStream2;
        if (bArr != null) {
            try {
                try {
                    try {
                        objectInputStream = new ObjectInputStream(new ByteArrayInputStream(bArr));
                    } catch (IOException e16) {
                        e = e16;
                        objectInputStream = null;
                        if (!FastClickUtils.isFastDoubleClick(TAG, 200L)) {
                        }
                        if (objectInputStream != null) {
                        }
                        return null;
                    } catch (ClassNotFoundException e17) {
                        e = e17;
                        objectInputStream = null;
                        if (!FastClickUtils.isFastDoubleClick(TAG, 200L)) {
                        }
                        if (objectInputStream != null) {
                        }
                        return null;
                    } catch (Throwable th5) {
                        th = th5;
                        objectInputStream = null;
                    }
                    try {
                        MiniAppInfo miniAppInfo = (MiniAppInfo) objectInputStream.readObject();
                        try {
                            objectInputStream.close();
                        } catch (IOException e18) {
                            QLog.e(TAG, 1, "createAppInfoFromBuffer close e:", e18);
                        }
                        return miniAppInfo;
                    } catch (IOException e19) {
                        e = e19;
                        if (!FastClickUtils.isFastDoubleClick(TAG, 200L)) {
                            QLog.e(TAG, 1, "createAppInfoFromBuffer failed!", e);
                        }
                        if (objectInputStream != null) {
                            objectInputStream.close();
                        }
                        return null;
                    } catch (ClassNotFoundException e26) {
                        e = e26;
                        if (!FastClickUtils.isFastDoubleClick(TAG, 200L)) {
                        }
                        if (objectInputStream != null) {
                        }
                        return null;
                    } catch (Throwable th6) {
                        th = th6;
                        QLog.e(TAG, 1, "createAppInfoFromBuffer fatal!", th);
                        if (objectInputStream != null) {
                            objectInputStream.close();
                        }
                        return null;
                    }
                } catch (Throwable th7) {
                    if (objectInputStream2 != null) {
                        try {
                            objectInputStream2.close();
                        } catch (IOException e27) {
                            QLog.e(TAG, 1, "createAppInfoFromBuffer close e:", e27);
                        }
                    }
                    throw th7;
                }
            } catch (IOException e28) {
                QLog.e(TAG, 1, "createAppInfoFromBuffer close e:", e28);
            }
        }
        return null;
    }

    public DesktopAppEntityV3(MiniAppInfo miniAppInfo) {
        this.uniqueId = miniAppInfo.appId + "_" + this.verType;
        this.appId = miniAppInfo.appId;
        this.name = miniAppInfo.name;
        this.verType = miniAppInfo.verType;
        this.appInfo = packAppInfo(miniAppInfo);
    }
}
