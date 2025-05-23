package com.tencent.mobileqq.config;

import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService$Config;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService$ReqGetConfig;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Locale;
import java.util.zip.InflaterInputStream;

/* compiled from: P */
/* loaded from: classes10.dex */
public class aj {
    static void b(byte[] bArr, int i3, long j3) {
        bArr[i3] = (byte) (j3 >> 24);
        bArr[i3 + 1] = (byte) (j3 >> 16);
        bArr[i3 + 2] = (byte) (j3 >> 8);
        bArr[i3 + 3] = (byte) j3;
    }

    private static byte[] c(byte[] bArr) {
        InflaterInputStream inflaterInputStream;
        if (bArr == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            inflaterInputStream = new InflaterInputStream(new ByteArrayInputStream(bArr));
        } catch (Throwable th5) {
            th = th5;
            inflaterInputStream = null;
        }
        try {
            byte[] bArr2 = new byte[256];
            while (true) {
                int read = inflaterInputStream.read(bArr2);
                if (-1 == read) {
                    break;
                }
                byteArrayOutputStream.write(bArr2, 0, read);
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                inflaterInputStream.close();
            } catch (IOException e16) {
                QLog.e("QConfigManager", 1, "decompressArConfig, close stream fail, ", e16);
            }
            return byteArray;
        } catch (Throwable th6) {
            th = th6;
            try {
                th.printStackTrace();
                return null;
            } finally {
                if (inflaterInputStream != null) {
                    try {
                        inflaterInputStream.close();
                    } catch (IOException e17) {
                        QLog.e("QConfigManager", 1, "decompressArConfig, close stream fail, ", e17);
                    }
                }
            }
        }
    }

    public static String d(ConfigurationService$Config configurationService$Config, int i3, int i16) {
        int i17;
        String str;
        if (configurationService$Config.version.get() == i3) {
            if (QLog.isColorLevel()) {
                QLog.d("QConfigManager", 2, "handleCompressConfig| version is update, return null");
            }
            return null;
        }
        if (configurationService$Config.msg_content_list.size() == 0) {
            QLog.d("QConfigManager", 1, "handleCompressConfig| content is null. newVersion=", Integer.valueOf(configurationService$Config.version.get()), ", oldVersion=", Integer.valueOf(i3), ", type=", Integer.valueOf(i16));
            return "";
        }
        if (configurationService$Config.msg_content_list.size() >= 2) {
            QLog.d("QConfigManager", 1, "handleCompressConfig, multiple config, type=", Integer.valueOf(i16), ", size=" + configurationService$Config.msg_content_list.size());
            i17 = 1;
        } else {
            i17 = 0;
        }
        byte[] byteArray = configurationService$Config.msg_content_list.get(i17).content.get().toByteArray();
        if (configurationService$Config.msg_content_list.get(0).compress.get() == 1 && (byteArray = c(byteArray)) == null) {
            QLog.e("QConfigManager", 1, "handleCompressConfig| decompress is failed. type=", Integer.valueOf(i16), ", data=null");
            return null;
        }
        try {
            str = new String(byteArray, "utf-8");
        } catch (UnsupportedEncodingException e16) {
            QLog.d("QConfigManager", 1, "handleCompressConfig| parse content, ", e16);
            str = null;
        }
        if (str == null) {
            QLog.e("QConfigManager", 1, "handleCompressConfig| switch data[] to String failed. type=", Integer.valueOf(i16), ", data=", new String(byteArray));
            return null;
        }
        String format = String.format(Locale.CHINA, "handleCompressConfig| config is update. version=%d, type=%d", Integer.valueOf(configurationService$Config.version.get()), Integer.valueOf(i16));
        if (QLog.isColorLevel()) {
            if (configurationService$Config.version.get() != 397 && configurationService$Config.version.get() != 394) {
                QLog.d("QConfigManager", 2, format, "content=", str);
            }
        } else {
            QLog.d("QConfigManager", 1, format);
        }
        return str;
    }

    public static byte[] e(byte[] bArr) {
        InflaterInputStream inflaterInputStream;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            inflaterInputStream = new InflaterInputStream(new ByteArrayInputStream(bArr));
        } catch (Throwable th5) {
            th = th5;
            inflaterInputStream = null;
        }
        try {
            byte[] bArr2 = new byte[256];
            while (true) {
                int read = inflaterInputStream.read(bArr2);
                if (-1 == read) {
                    break;
                }
                byteArrayOutputStream.write(bArr2, 0, read);
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                inflaterInputStream.close();
            } catch (IOException e16) {
                QLog.d("OlympicUtil", 2, "inflateConfigString, close stream, ", e16);
            }
            return byteArray;
        } catch (Throwable th6) {
            th = th6;
            try {
                if (QLog.isColorLevel()) {
                    QLog.d("OlympicUtil", 2, "inflateConfigString, ", th);
                }
                return null;
            } finally {
                if (inflaterInputStream != null) {
                    try {
                        inflaterInputStream.close();
                    } catch (IOException e17) {
                        QLog.d("OlympicUtil", 2, "inflateConfigString, close stream, ", e17);
                    }
                }
            }
        }
    }

    public static <T> T f(Class<T> cls) {
        try {
            Constructor<T> declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
            declaredConstructor.setAccessible(true);
            T newInstance = declaredConstructor.newInstance(new Object[0]);
            a(cls, newInstance);
            return newInstance;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("QConfigManager", 2, "newInstance failed, class=" + cls.getSimpleName(), e16);
                return null;
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] g(ConfigurationService$ReqGetConfig configurationService$ReqGetConfig) {
        byte[] byteArray = configurationService$ReqGetConfig.toByteArray();
        long length = byteArray.length;
        int i3 = (int) length;
        byte[] bArr = new byte[i3 + 4];
        b(bArr, 0, length + 4);
        System.arraycopy(byteArray, 0, bArr, 4, i3);
        return bArr;
    }

    public static byte[] h(byte[] bArr) {
        int length = bArr.length - 4;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 4, bArr2, 0, length);
        return bArr2;
    }

    public static ArrayList<QConReqExtraInfo> i(int[] iArr) {
        ArrayList<QConReqExtraInfo> arrayList = new ArrayList<>();
        if (iArr != null && iArr.length != 0) {
            for (int i3 : iArr) {
                arrayList.add(new QConReqExtraInfo(i3, false));
            }
        }
        return arrayList;
    }

    public static int[] j(ArrayList<QConReqExtraInfo> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            int[] iArr = new int[arrayList.size()];
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                iArr[i3] = arrayList.get(i3).f202243d;
            }
            return iArr;
        }
        return null;
    }

    public static void a(Class<?> cls, Object obj) {
    }
}
