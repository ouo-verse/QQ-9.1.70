package com.tencent.mobileqq.portal;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfoHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Pattern;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* compiled from: P */
/* loaded from: classes16.dex */
public class o {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    protected static MessageDigest f259390a;

    /* renamed from: b, reason: collision with root package name */
    private static final int[] f259391b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(73652);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f259390a = null;
            f259391b = new int[]{1, 2, 3};
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0092, code lost:
    
        return java.lang.String.valueOf(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x008b, code lost:
    
        if (com.tencent.qphone.base.util.QLog.isColorLevel() == false) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        StringBuilder sb5 = new StringBuilder();
        long j3 = 0;
        try {
            try {
                byte[] decode = PluginBaseInfoHelper.Base64Helper.decode(str.getBytes(), 2);
                String str2 = new String(decode);
                sb5.append("src");
                sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
                sb5.append(decode);
                sb5.append(",");
                int intValue = Integer.valueOf(str2.substring(0, 1)).intValue();
                sb5.append("factor");
                sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
                sb5.append(intValue);
                sb5.append(",");
                j3 = Long.valueOf(str2.substring(1)).longValue() >> intValue;
                sb5.append("result");
                sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
                sb5.append(j3);
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("PortalUtils", 2, "", e16);
                }
            }
        } finally {
            if (QLog.isColorLevel()) {
                QLog.d("PortalUtils", 2, sb5.toString());
            }
        }
    }

    public static String b(String str, long j3) {
        int i3;
        try {
            Long.valueOf(str);
            i3 = 1;
            int intValue = Integer.valueOf(str.substring(0, 1)).intValue() % 4;
            if (intValue != 0) {
                i3 = intValue;
            }
        } catch (Exception unused) {
            i3 = 2;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("factorIndex");
        sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
        sb5.append(i3);
        sb5.append(",");
        long j16 = j3 << i3;
        sb5.append("value1");
        sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
        sb5.append(j16);
        sb5.append(",");
        StringBuilder sb6 = new StringBuilder();
        sb6.append(i3);
        sb6.append(j16);
        String sb7 = sb6.toString();
        sb5.append("value2");
        sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
        sb5.append(sb7);
        sb5.append(",");
        String encodeToString = PluginBaseInfoHelper.Base64Helper.encodeToString(sb7.getBytes(), 2);
        sb5.append("value3");
        sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
        sb5.append(encodeToString);
        if (QLog.isColorLevel()) {
            QLog.d("PortalUtils", 2, sb5.toString());
        }
        return encodeToString;
    }

    public static String c(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        return PluginBaseInfoHelper.Base64Helper.encodeToString(byteArrayOutputStream.toByteArray(), 2);
    }

    public static String d(byte[] bArr) {
        if (f259390a == null) {
            try {
                f259390a = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
            } catch (NoSuchAlgorithmException e16) {
                e16.printStackTrace();
                return null;
            }
        }
        f259390a.update(bArr);
        return com.tencent.qqprotect.singleupdate.a.b(f259390a.digest());
    }

    public static String e(String str) {
        String str2 = null;
        try {
            byte[] partfileMd5 = MD5.getPartfileMd5(str, 0L);
            if (partfileMd5 != null) {
                str2 = com.tencent.qqprotect.singleupdate.a.b(partfileMd5);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
            QLog.e("PortalManager.PortalUtils", 2, "error ........ error getFileMD5String filePath: " + str + ", error=" + e16.getMessage());
        }
        if (QLog.isDebugVersion()) {
            QLog.e("PortalManager.PortalUtils", 2, "getFileMD5String md5: " + str2);
        }
        return str2;
    }

    public static byte[] f(String str) {
        StringBuilder sb5;
        byte[] bArr = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (QLog.isColorLevel()) {
            QLog.d("PortalManager.PortalUtils", 2, "gzip:before source:" + str);
        }
        try {
            byte[] bytes = str.getBytes("UTF-8");
            if (QLog.isColorLevel()) {
                QLog.d("PortalManager.PortalUtils", 2, "gzip:before zip length:" + bytes.length);
            }
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                try {
                    byte[] bArr2 = new byte[1024];
                    GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                    while (true) {
                        int read = byteArrayInputStream.read(bArr2, 0, 1024);
                        if (read == -1) {
                            break;
                        }
                        gZIPOutputStream.write(bArr2, 0, read);
                    }
                    gZIPOutputStream.flush();
                    gZIPOutputStream.close();
                    bArr = byteArrayOutputStream.toByteArray();
                    if (QLog.isColorLevel()) {
                        QLog.d("PortalManager.PortalUtils", 2, "gzip:after zip length:" + bArr.length);
                    }
                    try {
                        byteArrayOutputStream.close();
                        byteArrayInputStream.close();
                    } catch (IOException e16) {
                        e = e16;
                        if (QLog.isColorLevel()) {
                            sb5 = new StringBuilder();
                            sb5.append("gzip: gzip throw ioexception,");
                            sb5.append(e.getMessage());
                            QLog.d("PortalManager.PortalUtils", 2, sb5.toString());
                        }
                    }
                } catch (Exception e17) {
                    if (QLog.isColorLevel()) {
                        QLog.d("PortalManager.PortalUtils", 2, "gzip: gzip throw exception," + e17.getMessage());
                    }
                    try {
                        byteArrayOutputStream.close();
                        byteArrayInputStream.close();
                    } catch (IOException e18) {
                        e = e18;
                        if (QLog.isColorLevel()) {
                            sb5 = new StringBuilder();
                            sb5.append("gzip: gzip throw ioexception,");
                            sb5.append(e.getMessage());
                            QLog.d("PortalManager.PortalUtils", 2, sb5.toString());
                        }
                    }
                } catch (OutOfMemoryError e19) {
                    if (QLog.isColorLevel()) {
                        QLog.d("PortalManager.PortalUtils", 2, "gzip: gzip throw error," + e19.getMessage());
                    }
                    try {
                        byteArrayOutputStream.close();
                        byteArrayInputStream.close();
                    } catch (IOException e26) {
                        e = e26;
                        if (QLog.isColorLevel()) {
                            sb5 = new StringBuilder();
                            sb5.append("gzip: gzip throw ioexception,");
                            sb5.append(e.getMessage());
                            QLog.d("PortalManager.PortalUtils", 2, sb5.toString());
                        }
                    }
                }
                return bArr;
            } catch (Throwable th5) {
                try {
                    byteArrayOutputStream.close();
                    byteArrayInputStream.close();
                } catch (IOException e27) {
                    if (QLog.isColorLevel()) {
                        QLog.d("PortalManager.PortalUtils", 2, "gzip: gzip throw ioexception," + e27.getMessage());
                    }
                }
                throw th5;
            }
        } catch (UnsupportedEncodingException e28) {
            e28.printStackTrace();
            return null;
        }
    }

    public static boolean g(String str) {
        if (!Pattern.compile("[0-9]*").matcher(str).matches()) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00fb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String h(byte[] bArr) {
        byte[] bArr2;
        StringBuilder sb5;
        byte[] bArr3;
        if (bArr == null) {
            return null;
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            try {
                byte[] bArr4 = new byte[1024];
                GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
                while (true) {
                    int read = gZIPInputStream.read(bArr4, 0, 1024);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr4, 0, read);
                }
                gZIPInputStream.close();
                bArr3 = byteArrayOutputStream.toByteArray();
                try {
                    if (QLog.isColorLevel()) {
                        QLog.d("PortalManager.PortalUtils", 2, "ungzip:after unzip length:" + bArr3.length);
                    }
                    try {
                        byteArrayOutputStream.close();
                        byteArrayInputStream.close();
                    } catch (IOException e16) {
                        if (QLog.isColorLevel()) {
                            QLog.d("PortalManager.PortalUtils", 2, "ungzip: ungzip throw ioexception," + e16.getMessage());
                        }
                    }
                } catch (Exception e17) {
                    bArr2 = bArr3;
                    e = e17;
                    if (QLog.isColorLevel()) {
                        QLog.d("PortalManager.PortalUtils", 2, "ungzip: ungzip throw error," + e.getMessage());
                    }
                    try {
                        byteArrayOutputStream.close();
                        byteArrayInputStream.close();
                    } catch (IOException e18) {
                        e = e18;
                        if (QLog.isColorLevel()) {
                            sb5 = new StringBuilder();
                            sb5.append("ungzip: ungzip throw ioexception,");
                            sb5.append(e.getMessage());
                            QLog.d("PortalManager.PortalUtils", 2, sb5.toString());
                        }
                    }
                    bArr3 = bArr2;
                    if (bArr3 != null) {
                    }
                    return null;
                } catch (OutOfMemoryError e19) {
                    bArr2 = bArr3;
                    e = e19;
                    if (QLog.isColorLevel()) {
                        QLog.d("PortalManager.PortalUtils", 2, "ungzip: ungzip throw error," + e.getMessage());
                    }
                    try {
                        byteArrayOutputStream.close();
                        byteArrayInputStream.close();
                    } catch (IOException e26) {
                        e = e26;
                        if (QLog.isColorLevel()) {
                            sb5 = new StringBuilder();
                            sb5.append("ungzip: ungzip throw ioexception,");
                            sb5.append(e.getMessage());
                            QLog.d("PortalManager.PortalUtils", 2, sb5.toString());
                        }
                    }
                    bArr3 = bArr2;
                    if (bArr3 != null) {
                    }
                    return null;
                }
            } catch (Exception e27) {
                e = e27;
                bArr2 = null;
            } catch (OutOfMemoryError e28) {
                e = e28;
                bArr2 = null;
            }
            if (bArr3 != null) {
                try {
                    return new String(bArr3, "UTF-8");
                } catch (UnsupportedEncodingException e29) {
                    e29.printStackTrace();
                } catch (Exception e36) {
                    e36.printStackTrace();
                }
            }
            return null;
        } catch (Throwable th5) {
            try {
                byteArrayOutputStream.close();
                byteArrayInputStream.close();
            } catch (IOException e37) {
                if (QLog.isColorLevel()) {
                    QLog.d("PortalManager.PortalUtils", 2, "ungzip: ungzip throw ioexception," + e37.getMessage());
                }
            }
            throw th5;
        }
    }
}
