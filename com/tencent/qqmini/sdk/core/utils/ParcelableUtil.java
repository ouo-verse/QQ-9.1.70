package com.tencent.qqmini.sdk.core.utils;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/* loaded from: classes23.dex */
public class ParcelableUtil {
    private static final String TAG = "ParcelableUtil";

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:60:0x0066 -> B:31:0x0069). Please report as a decompilation issue!!! */
    public static <T extends Parcelable> T readParcelableFromFile(Class cls, String str) {
        FileInputStream fileInputStream;
        Parcel parcel;
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                File file = new File(str);
                if (!file.exists()) {
                    return null;
                }
                fileInputStream = new FileInputStream(file);
                try {
                    int available = fileInputStream.available();
                    byte[] bArr = new byte[available];
                    fileInputStream.read(bArr, 0, available);
                    try {
                        parcel = unmarshall(bArr);
                    } catch (Throwable th5) {
                        th = th5;
                        parcel = null;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    try {
                        QMLog.e(TAG, "readParcelableFromFile exception!", th);
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        return null;
                    } catch (Throwable th7) {
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Throwable th8) {
                                QMLog.e(TAG, "readParcelableFromFile exception!", th8);
                            }
                        }
                        throw th7;
                    }
                }
                try {
                    T t16 = (T) parcel.readParcelable(cls.getClassLoader());
                    OaidMonitor.parcelRecycle(parcel);
                    try {
                        fileInputStream.close();
                    } catch (Throwable th9) {
                        QMLog.e(TAG, "readParcelableFromFile exception!", th9);
                    }
                    return t16;
                } catch (Throwable th10) {
                    th = th10;
                    try {
                        QMLog.e(TAG, "readParcelableFromFile exception!", th);
                        fileInputStream.close();
                        return null;
                    } finally {
                        if (parcel != null) {
                            OaidMonitor.parcelRecycle(parcel);
                        }
                    }
                }
            } catch (Throwable th11) {
                th = th11;
                fileInputStream = null;
            }
        } catch (Throwable th12) {
            QMLog.e(TAG, "readParcelableFromFile exception!", th12);
        }
    }

    public static Parcel unmarshall(byte[] bArr) {
        Parcel obtain = Parcel.obtain();
        if (bArr == null) {
            return obtain;
        }
        try {
            obtain.unmarshall(bArr, 0, bArr.length);
            obtain.setDataPosition(0);
        } catch (Exception unused) {
        }
        return obtain;
    }

    public static boolean writeParcelableToFile(Parcelable parcelable, String str) {
        byte[] marshall;
        FileOutputStream fileOutputStream;
        if (parcelable == null || TextUtils.isEmpty(str)) {
            return false;
        }
        Parcel parcel = null;
        FileOutputStream fileOutputStream2 = null;
        try {
            Parcel obtain = Parcel.obtain();
            try {
                obtain.writeParcelable(parcelable, 0);
                marshall = obtain.marshall();
                try {
                    File file = new File(str);
                    File parentFile = file.getParentFile();
                    if (!parentFile.exists() || !parentFile.isDirectory()) {
                        parentFile.mkdirs();
                    }
                    if (!file.exists() || !file.isFile()) {
                        file.createNewFile();
                    }
                    fileOutputStream = new FileOutputStream(file, false);
                } catch (Throwable th5) {
                    th = th5;
                }
            } catch (Throwable th6) {
                th = th6;
                parcel = obtain;
                try {
                    QMLog.e(TAG, "writeParcelableToFile exception!", th);
                    return false;
                } finally {
                    if (parcel != null) {
                        OaidMonitor.parcelRecycle(parcel);
                    }
                }
            }
            try {
                fileOutputStream.write(marshall);
                fileOutputStream.flush();
                try {
                    fileOutputStream.close();
                } catch (Throwable th7) {
                    QMLog.e(TAG, "writeParcelableToFile exception!", th7);
                }
                OaidMonitor.parcelRecycle(obtain);
                return true;
            } catch (Throwable th8) {
                th = th8;
                fileOutputStream2 = fileOutputStream;
                try {
                    QMLog.e(TAG, "writeParcelableToFile exception!", th);
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (Throwable th9) {
                            QMLog.e(TAG, "writeParcelableToFile exception!", th9);
                        }
                    }
                    OaidMonitor.parcelRecycle(obtain);
                    return false;
                } finally {
                }
            }
        } catch (Throwable th10) {
            th = th10;
        }
    }
}
