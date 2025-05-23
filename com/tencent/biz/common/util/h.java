package com.tencent.biz.common.util;

import android.text.TextUtils;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.pubaccount.api.IPublicAccountHandler;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfoHelper;
import com.tencent.mobileqq.webview.swift.injector.aa;
import com.tencent.mobileqq.webview.swift.injector.m;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.jf.dexlib2.analysis.RegisterType;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes2.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    private static String f78471a = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCrREOFRN9uYS869mOeLmZXFw3djnofd7wbf3ru6zmRB7P6gTpmnvJNnclCcEC7TOmDImvVl+gVPXQ0AmWAI4q042rALV5NPCJiOpIzSgJH2l0F/ZVbj69QztBiKmSHVHqQ8yemqtFljNEJbE9HL3RXE/uwGmHViFl4fGg9am5w7QIDAQAB";

    /* renamed from: b, reason: collision with root package name */
    protected static String f78472b;

    /* renamed from: c, reason: collision with root package name */
    private static char[] f78473c = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    private static Boolean a(String str, String str2, JSONObject jSONObject, JSONArray jSONArray, Map<String, String> map) {
        String str3;
        if (jSONObject != null) {
            Iterator keys = jSONObject.keys();
            while (true) {
                if (!keys.hasNext()) {
                    break;
                }
                String obj = keys.next().toString();
                if (obj != null && str2.equals(obj)) {
                    String str4 = map.get(str2);
                    String b16 = b(str + File.separator + str2);
                    if (!TextUtils.isEmpty(str4) && str4.equals(b16)) {
                        if (QLog.isColorLevel()) {
                            QLog.i("offlneSecurity", 2, "check local file:" + obj + " success");
                        }
                        try {
                            jSONArray = jSONObject.getJSONArray(obj);
                        } catch (JSONException e16) {
                            e16.printStackTrace();
                            h(5);
                            if (QLog.isColorLevel()) {
                                QLog.i("offlneSecurity", 2, "JSONException:" + obj);
                            }
                        }
                        if (jSONArray != null) {
                            if (QLog.isColorLevel()) {
                                QLog.i("offlneSecurity", 2, "check local file:" + obj + ",related files:" + jSONArray.toString());
                            }
                            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                                try {
                                    str3 = jSONArray.getString(i3);
                                } catch (JSONException e17) {
                                    e17.printStackTrace();
                                    h(5);
                                    if (QLog.isColorLevel()) {
                                        QLog.i("offlneSecurity", 2, "jsonArray.getString");
                                    }
                                    str3 = null;
                                }
                                if (!TextUtils.isEmpty(str3)) {
                                    String str5 = map.get(str3);
                                    String b17 = b(str + File.separator + str3);
                                    if (TextUtils.isEmpty(str5) || !str5.equals(b17)) {
                                        if (QLog.isColorLevel()) {
                                            QLog.i("offlneSecurity", 2, "check related file md5 fail;html=" + obj + "; resfile=" + str3 + ";resMd5=" + str5 + "; reshash=" + b17);
                                        }
                                        return Boolean.FALSE;
                                    }
                                }
                                if (QLog.isColorLevel()) {
                                    StringBuilder sb5 = new StringBuilder();
                                    sb5.append("check related file md5 success ; html=");
                                    sb5.append(obj);
                                    sb5.append(";  resfile=");
                                    if (str3 == null) {
                                        str3 = "null";
                                    }
                                    sb5.append(str3);
                                    QLog.i("offlneSecurity", 2, sb5.toString());
                                }
                            }
                        }
                    } else {
                        if (QLog.isColorLevel()) {
                            QLog.i("offlneSecurity", 2, "check md5 fail:" + obj + ";fileMd5=" + str4 + "; filehash=" + b16);
                        }
                        return Boolean.FALSE;
                    }
                }
            }
        }
        return null;
    }

    public static String b(String str) {
        try {
            return c(str, "SHA1");
        } catch (Exception e16) {
            e16.printStackTrace();
            return "";
        }
    }

    private static String c(String str, String str2) throws Exception {
        BufferedInputStream bufferedInputStream;
        BufferedInputStream bufferedInputStream2 = null;
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(str));
        } catch (Throwable th5) {
            th = th5;
        }
        try {
            byte[] bArr = new byte[4096];
            MessageDigest messageDigest = MessageDigest.getInstance(str2);
            while (true) {
                int read = bufferedInputStream.read(bArr);
                if (read > 0) {
                    messageDigest.update(bArr, 0, read);
                } else {
                    try {
                        break;
                    } catch (IOException unused) {
                    }
                }
            }
            bufferedInputStream.close();
            return j(messageDigest.digest());
        } catch (Throwable th6) {
            th = th6;
            bufferedInputStream2 = bufferedInputStream;
            if (bufferedInputStream2 != null) {
                try {
                    bufferedInputStream2.close();
                } catch (IOException unused2) {
                }
            }
            throw th;
        }
    }

    public static String d(BufferedInputStream bufferedInputStream) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        byte[] bArr = new byte[4096];
        while (true) {
            int read = bufferedInputStream.read(bArr);
            if (read != -1) {
                stringBuffer.append(new String(bArr, 0, read));
            } else {
                return stringBuffer.toString();
            }
        }
    }

    public static byte[] e(BufferedInputStream bufferedInputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[4096];
        while (true) {
            int read = bufferedInputStream.read(bArr);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                return byteArray;
            }
        }
    }

    public static boolean f(String str, String str2, String str3) {
        i(str3);
        if (p(str)) {
            return g(str, str2);
        }
        return false;
    }

    private static boolean g(String str, String str2) {
        String str3;
        if (QLog.isColorLevel()) {
            QLog.i("offlneSecurity", 2, "will check local file,dir:" + str + "; fileName: " + str2);
        }
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(str);
        String str4 = File.separator;
        sb5.append(str4);
        sb5.append(str2);
        if (!new File(sb5.toString()).exists()) {
            return false;
        }
        BufferedInputStream bufferedInputStream = null;
        try {
            try {
                BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(str + str4 + "verify.json"));
                try {
                    JSONObject jSONObject = new JSONObject(d(bufferedInputStream2));
                    bufferedInputStream2.close();
                    JSONObject jSONObject2 = jSONObject.getJSONObject("md5");
                    JSONObject jSONObject3 = jSONObject.getJSONObject("route");
                    try {
                        bufferedInputStream2.close();
                    } catch (IOException e16) {
                        e16.printStackTrace();
                    }
                    HashMap hashMap = new HashMap();
                    if (jSONObject2 != null) {
                        Iterator keys = jSONObject2.keys();
                        while (keys.hasNext()) {
                            String obj = keys.next().toString();
                            try {
                                str3 = jSONObject2.getString(obj);
                            } catch (JSONException e17) {
                                e17.printStackTrace();
                                h(5);
                                if (QLog.isColorLevel()) {
                                    QLog.i("offlneSecurity", 2, "JSONException:" + obj);
                                }
                                str3 = null;
                            }
                            if (!TextUtils.isEmpty(str3)) {
                                hashMap.put(obj, str3);
                            }
                        }
                    }
                    Boolean a16 = a(str, str2, jSONObject3, null, hashMap);
                    if (a16 == null) {
                        return true;
                    }
                    return a16.booleanValue();
                } catch (FileNotFoundException e18) {
                    e = e18;
                    bufferedInputStream = bufferedInputStream2;
                    h(1);
                    e.printStackTrace();
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e19) {
                            e19.printStackTrace();
                        }
                    }
                    return false;
                } catch (IOException e26) {
                    e = e26;
                    bufferedInputStream = bufferedInputStream2;
                    h(2);
                    e.printStackTrace();
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e27) {
                            e27.printStackTrace();
                        }
                    }
                    return false;
                } catch (JSONException e28) {
                    e = e28;
                    bufferedInputStream = bufferedInputStream2;
                    h(3);
                    e.printStackTrace();
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e29) {
                            e29.printStackTrace();
                        }
                    }
                    return false;
                } catch (Throwable th5) {
                    th = th5;
                    bufferedInputStream = bufferedInputStream2;
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e36) {
                            e36.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (FileNotFoundException e37) {
                e = e37;
            } catch (IOException e38) {
                e = e38;
            } catch (JSONException e39) {
                e = e39;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    private static void h(int i3) {
        int i16;
        try {
            i16 = Integer.valueOf(f78472b).intValue();
        } catch (NumberFormatException unused) {
            i16 = 0;
        }
        ((m) aa.k(m.class)).b(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "mp_msg_sys_14", "lixian_security", i16, i3, "", "3", "", "");
        if (QLog.isColorLevel()) {
            QLog.d("offlneSecurity", 2, "report:" + i3);
        }
    }

    private static void i(String str) {
        if (str == null) {
            str = "0";
        }
        f78472b = str;
    }

    public static String j(byte[] bArr) {
        StringBuilder sb5 = new StringBuilder(bArr.length * 2);
        for (int i3 = 0; i3 < bArr.length; i3++) {
            sb5.append(f78473c[(bArr[i3] & 240) >>> 4]);
            sb5.append(f78473c[bArr[i3] & RegisterType.DOUBLE_HI]);
        }
        return sb5.toString();
    }

    public static boolean k(String str, String str2) {
        if (QLog.isColorLevel()) {
            QLog.i("offlneSecurity", 2, "-->offline:verify");
        }
        i(str2);
        if (p(str)) {
            return o(str);
        }
        return false;
    }

    private static boolean l(String str, byte[] bArr, byte[] bArr2) {
        try {
            if (QLog.isColorLevel()) {
                QLog.i("offlneSecurity", 2, "-->offline:verify");
            }
            byte[] decode = PluginBaseInfoHelper.Base64Helper.decode(str.getBytes("UTF-8"), 0);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            Signature signature = Signature.getInstance("SHA1withRSA");
            signature.initVerify(keyFactory.generatePublic(new X509EncodedKeySpec(decode)));
            signature.update(bArr);
            return signature.verify(bArr2);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.i("offlneSecurity", 2, "-->offline:verify error:" + e16.toString());
            }
            e16.printStackTrace();
            h(4);
            return false;
        }
    }

    public static boolean m(String str, String str2, String str3) {
        String str4;
        if (QLog.isColorLevel()) {
            QLog.i("OfflineSecurity", 2, "-->offline:verifyFile");
        }
        i(str3);
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return false;
        }
        BufferedInputStream bufferedInputStream = null;
        try {
            try {
                ConcurrentHashMap<String, String> concurrentHashMap = HtmlOffline.f78404g;
                if (concurrentHashMap != null && concurrentHashMap.containsKey(str3)) {
                    str4 = HtmlOffline.f78404g.get(str3);
                } else {
                    BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(str2 + "/verify.json"));
                    try {
                        String d16 = d(bufferedInputStream2);
                        ConcurrentHashMap<String, String> concurrentHashMap2 = HtmlOffline.f78404g;
                        if (concurrentHashMap2 != null) {
                            concurrentHashMap2.put(str3, d16);
                        }
                        str4 = d16;
                        bufferedInputStream = bufferedInputStream2;
                    } catch (FileNotFoundException e16) {
                        e = e16;
                        bufferedInputStream = bufferedInputStream2;
                        if (QLog.isColorLevel()) {
                            QLog.i("OfflineSecurity", 2, "-->offline,verifyFile:file not found!");
                        }
                        h(1);
                        e.printStackTrace();
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (Exception e17) {
                                QLog.e("offlneSecurity", 1, "error", e17);
                            }
                        }
                        return false;
                    } catch (IOException e18) {
                        e = e18;
                        bufferedInputStream = bufferedInputStream2;
                        if (QLog.isColorLevel()) {
                            QLog.i("OfflineSecurity", 2, "-->offline,verifyFile:io error!");
                        }
                        h(2);
                        e.printStackTrace();
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (Exception e19) {
                                QLog.e("offlneSecurity", 1, "error", e19);
                            }
                        }
                        return false;
                    } catch (JSONException e26) {
                        e = e26;
                        bufferedInputStream = bufferedInputStream2;
                        if (QLog.isColorLevel()) {
                            QLog.i("OfflineSecurity", 2, "-->offline,verifyFile:json error!");
                        }
                        h(3);
                        e.printStackTrace();
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (Exception e27) {
                                QLog.e("offlneSecurity", 1, "error", e27);
                            }
                        }
                        return false;
                    } catch (Throwable th5) {
                        th = th5;
                        bufferedInputStream = bufferedInputStream2;
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (Exception e28) {
                                QLog.e("offlneSecurity", 1, "error", e28);
                            }
                        }
                        throw th;
                    }
                }
                JSONObject jSONObject = new JSONObject(str4);
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (Exception e29) {
                        QLog.e("offlneSecurity", 1, "error", e29);
                    }
                }
                String optString = jSONObject.optString(str);
                if (TextUtils.isEmpty(optString)) {
                    if (QLog.isColorLevel()) {
                        QLog.i("offlneSecurity", 2, "-->offline:verifyFile,not in verify list!");
                    }
                    return true;
                }
                if (optString.equals(b(str2 + File.separator + str))) {
                    return true;
                }
                if (QLog.isColorLevel()) {
                    QLog.i("offlneSecurity", 2, "-->offline:verifyFile,check md5 fail:" + str);
                }
                h(6);
                return false;
            } catch (FileNotFoundException e36) {
                e = e36;
            } catch (IOException e37) {
                e = e37;
            } catch (JSONException e38) {
                e = e38;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    public static boolean n(String str, String str2, String str3) {
        if (QLog.isColorLevel()) {
            QLog.i("OfflineSecurity", 2, "-->offline:verifyIndex");
        }
        i(str3);
        if (p(str2)) {
            return m(str, str2, str3);
        }
        return false;
    }

    private static boolean o(String str) {
        if (QLog.isColorLevel()) {
            QLog.i("offlneSecurity", 2, "-->offline:verifySHA1:");
        }
        BufferedInputStream bufferedInputStream = null;
        try {
            try {
                BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(str + "/verify.json"));
                try {
                    JSONObject jSONObject = new JSONObject(d(bufferedInputStream2));
                    try {
                        bufferedInputStream2.close();
                    } catch (IOException unused) {
                    }
                    Iterator keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String obj = keys.next().toString();
                        try {
                        } catch (JSONException e16) {
                            e16.printStackTrace();
                            h(5);
                            if (QLog.isColorLevel()) {
                                QLog.i("offlneSecurity", 2, "-->offline:verifySHA1,JSONException:" + obj);
                            }
                        }
                        if (!jSONObject.getString(obj).equals(b(str + File.separator + obj))) {
                            if (QLog.isColorLevel()) {
                                QLog.i("offlneSecurity", 2, "-->offline:verifySHA1,check md5 fail:" + obj);
                            }
                            h(6);
                            return false;
                        }
                        continue;
                    }
                    return true;
                } catch (FileNotFoundException e17) {
                    e = e17;
                    bufferedInputStream = bufferedInputStream2;
                    if (QLog.isColorLevel()) {
                        QLog.i("offlneSecurity", 2, "-->offline:verifySHA1 error:file not foud!");
                    }
                    h(1);
                    e.printStackTrace();
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException unused2) {
                        }
                    }
                    return false;
                } catch (IOException e18) {
                    e = e18;
                    bufferedInputStream = bufferedInputStream2;
                    if (QLog.isColorLevel()) {
                        QLog.i("offlneSecurity", 2, "-->offline:verifySHA1 error:io error!");
                    }
                    h(2);
                    e.printStackTrace();
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException unused3) {
                        }
                    }
                    return false;
                } catch (JSONException e19) {
                    e = e19;
                    bufferedInputStream = bufferedInputStream2;
                    if (QLog.isColorLevel()) {
                        QLog.i("offlneSecurity", 2, "-->offline:verifySHA1 error:json error!");
                    }
                    h(3);
                    e.printStackTrace();
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException unused4) {
                        }
                    }
                    return false;
                } catch (Throwable th5) {
                    th = th5;
                    bufferedInputStream = bufferedInputStream2;
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException unused5) {
                        }
                    }
                    throw th;
                }
            } catch (FileNotFoundException e26) {
                e = e26;
            } catch (IOException e27) {
                e = e27;
            } catch (JSONException e28) {
                e = e28;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    private static boolean p(String str) {
        BufferedInputStream bufferedInputStream;
        if (QLog.isColorLevel()) {
            QLog.i("offlneSecurity", 2, "-->offline:verifySecurity");
        }
        try {
            File file = new File(str + "/verify.json");
            if (!file.exists()) {
                if (QLog.isColorLevel()) {
                    QLog.i("offlneSecurity", 2, "-->offline:verifySecurity,verify.json not exist!");
                }
                return false;
            }
            BufferedInputStream bufferedInputStream2 = null;
            try {
                bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            } catch (Throwable th5) {
                th = th5;
            }
            try {
                byte[] e16 = e(bufferedInputStream);
                try {
                    bufferedInputStream.close();
                } catch (IOException unused) {
                }
                File file2 = new File(str + "/verify.signature");
                if (!file2.exists()) {
                    if (QLog.isColorLevel()) {
                        QLog.i("offlneSecurity", 2, "-->offline:verifySecurity,verify.signature not exist!");
                    }
                    return false;
                }
                try {
                    BufferedInputStream bufferedInputStream3 = new BufferedInputStream(new FileInputStream(file2));
                    try {
                        byte[] e17 = e(bufferedInputStream3);
                        try {
                            bufferedInputStream3.close();
                        } catch (IOException unused2) {
                        }
                        return l(f78471a, e16, e17);
                    } catch (Throwable th6) {
                        th = th6;
                        bufferedInputStream2 = bufferedInputStream3;
                        if (bufferedInputStream2 != null) {
                            try {
                                bufferedInputStream2.close();
                            } catch (IOException unused3) {
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th7) {
                    th = th7;
                }
            } catch (Throwable th8) {
                th = th8;
                bufferedInputStream2 = bufferedInputStream;
                if (bufferedInputStream2 != null) {
                    try {
                        bufferedInputStream2.close();
                    } catch (IOException unused4) {
                    }
                }
                throw th;
            }
        } catch (FileNotFoundException e18) {
            if (QLog.isColorLevel()) {
                QLog.i("offlneSecurity", 2, "-->offline:verifySecurity,file not found error!");
            }
            h(1);
            e18.printStackTrace();
            return false;
        } catch (IOException e19) {
            if (QLog.isColorLevel()) {
                QLog.i("offlneSecurity", 2, "-->offline:verifySecurity,io error!");
            }
            h(2);
            e19.printStackTrace();
            return false;
        }
    }

    public static boolean q(String str, String str2) {
        i(str2);
        return p(str);
    }
}
