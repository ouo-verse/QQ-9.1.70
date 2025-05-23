package com.tencent.qqnt.emotion.utils;

import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService$Config;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Locale;
import java.util.zip.InflaterInputStream;

/* compiled from: P */
/* loaded from: classes24.dex */
public class n {
    static IPatchRedirector $redirector_;

    private static byte[] a(byte[] bArr) {
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
            try {
                byteArrayOutputStream.close();
            } catch (IOException e17) {
                QLog.e("QConfigManager", 1, "decompressArConfig, close bos stream fail, ", e17);
            }
            return byteArray;
        } catch (Throwable th6) {
            th = th6;
            try {
                th.printStackTrace();
                if (inflaterInputStream != null) {
                    try {
                        inflaterInputStream.close();
                    } catch (IOException e18) {
                        QLog.e("QConfigManager", 1, "decompressArConfig, close stream fail, ", e18);
                    }
                }
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e19) {
                    QLog.e("QConfigManager", 1, "decompressArConfig, close bos stream fail, ", e19);
                }
                return null;
            } finally {
            }
        }
    }

    public static String b(ConfigurationService$Config configurationService$Config, int i3, int i16) {
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
        if (configurationService$Config.msg_content_list.get(0).compress.get() == 1 && (byteArray = a(byteArray)) == null) {
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
            if (configurationService$Config.version.get() != 397 && configurationService$Config.version.get() != 394 && QLog.isColorLevel()) {
                QLog.d("QConfigManager", 2, format, "content=", str);
            }
        } else {
            QLog.d("QConfigManager", 1, format);
        }
        return str;
    }
}
