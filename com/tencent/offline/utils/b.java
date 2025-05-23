package com.tencent.offline.utils;

import android.util.Base64;
import com.tencent.component.core.log.LogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.util.f;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;
import java.util.Iterator;
import org.jf.dexlib2.analysis.RegisterType;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes22.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static String f339496a;

    /* renamed from: b, reason: collision with root package name */
    protected static String f339497b;

    /* renamed from: c, reason: collision with root package name */
    private static char[] f339498c;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(23280);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f339496a = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCrREOFRN9uYS869mOeLmZXFw3djnofd7wbf3ru6zmRB7P6gTpmnvJNnclCcEC7TOmDImvVl+gVPXQ0AmWAI4q042rALV5NPCJiOpIzSgJH2l0F/ZVbj69QztBiKmSHVHqQ8yemqtFljNEJbE9HL3RXE/uwGmHViFl4fGg9am5w7QIDAQAB";
            f339498c = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        }
    }

    public static String a(String str) {
        try {
            return b(str, "SHA1");
        } catch (Exception e16) {
            e16.printStackTrace();
            return "";
        }
    }

    private static String b(String str, String str2) throws Exception {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(str);
        } catch (IOException unused) {
        } catch (Throwable th5) {
            th = th5;
        }
        try {
            byte[] bArr = new byte[4096];
            MessageDigest messageDigest = MessageDigest.getInstance(str2);
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read > 0) {
                    messageDigest.update(bArr, 0, read);
                } else {
                    String g16 = g(messageDigest.digest());
                    f.a(fileInputStream);
                    return g16;
                }
            }
        } catch (IOException unused2) {
            fileInputStream2 = fileInputStream;
            f.a(fileInputStream2);
            return "";
        } catch (Throwable th6) {
            th = th6;
            fileInputStream2 = fileInputStream;
            f.a(fileInputStream2);
            throw th;
        }
    }

    public static String c(InputStream inputStream) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        byte[] bArr = new byte[4096];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                stringBuffer.append(new String(bArr, 0, read));
            } else {
                return stringBuffer.toString();
            }
        }
    }

    public static byte[] d(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[4096];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                return byteArray;
            }
        }
    }

    private static void e(int i3) {
        LogUtil.e("offlineSecurity", " report error code:" + i3, new Object[0]);
    }

    private static void f(String str) {
        if (str == null) {
            str = "0";
        }
        f339497b = str;
    }

    private static String g(byte[] bArr) {
        StringBuilder sb5 = new StringBuilder(bArr.length * 2);
        for (int i3 = 0; i3 < bArr.length; i3++) {
            sb5.append(f339498c[(bArr[i3] & 240) >>> 4]);
            sb5.append(f339498c[bArr[i3] & RegisterType.DOUBLE_HI]);
        }
        return sb5.toString();
    }

    public static boolean h(String str, String str2) {
        f(str2);
        if (k(str)) {
            return j(str);
        }
        return false;
    }

    private static boolean i(String str, byte[] bArr, byte[] bArr2) {
        try {
            byte[] decode = Base64.decode(str.getBytes("UTF-8"), 0);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            Signature signature = Signature.getInstance("SHA1withRSA");
            signature.initVerify(keyFactory.generatePublic(new X509EncodedKeySpec(decode)));
            signature.update(bArr);
            return signature.verify(bArr2);
        } catch (Exception e16) {
            e16.printStackTrace();
            e(4);
            return false;
        }
    }

    private static boolean j(String str) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(new File(str + "/verify.json"));
        } catch (Exception e16) {
            e = e16;
        }
        try {
            JSONObject jSONObject = new JSONObject(c(fileInputStream));
            fileInputStream.close();
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String obj = keys.next().toString();
                try {
                } catch (JSONException e17) {
                    LogUtil.i("offlineSecurity", "JSONException:" + obj, new Object[0]);
                    LogUtil.printStackTrace(e17);
                    e(5);
                }
                if (!jSONObject.getString(obj).equals(a(str + File.separator + obj))) {
                    LogUtil.i("offlineSecurity", "check md5 fail:" + obj, new Object[0]);
                    e(6);
                    return false;
                }
                continue;
            }
            return true;
        } catch (Exception e18) {
            e = e18;
            fileInputStream2 = fileInputStream;
            LogUtil.printStackTrace(e);
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (IOException e19) {
                    e19.printStackTrace();
                }
            }
            return false;
        }
    }

    private static boolean k(String str) {
        FileInputStream fileInputStream;
        Exception e16;
        FileInputStream fileInputStream2;
        try {
            File file = new File(str + "/verify.json");
            if (!file.exists()) {
                return false;
            }
            fileInputStream = new FileInputStream(file);
            try {
                byte[] d16 = d(fileInputStream);
                fileInputStream.close();
                File file2 = new File(str + "/verify.signature");
                if (!file2.exists()) {
                    return false;
                }
                fileInputStream2 = new FileInputStream(file2);
                try {
                    byte[] d17 = d(fileInputStream2);
                    fileInputStream2.close();
                    return i(f339496a, d16, d17);
                } catch (Exception e17) {
                    e16 = e17;
                    LogUtil.printStackTrace(e16);
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception e18) {
                            LogUtil.printStackTrace(e18);
                            return false;
                        }
                    }
                    if (fileInputStream2 != null) {
                        fileInputStream.close();
                    }
                    return false;
                }
            } catch (Exception e19) {
                e16 = e19;
                fileInputStream2 = null;
            }
        } catch (Exception e26) {
            fileInputStream = null;
            e16 = e26;
            fileInputStream2 = null;
        }
    }
}
