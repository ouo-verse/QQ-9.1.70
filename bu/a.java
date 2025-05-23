package bu;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static String f29136a = "QavSdkConfigHelper";

    /* renamed from: b, reason: collision with root package name */
    private static String f29137b = "1";

    public static String a() {
        return com.tencent.av.b.i() + "QavFlowCtrlConfig/";
    }

    public static String b() {
        if (!d()) {
            return "";
        }
        String b16 = b.a().b();
        if (!TextUtils.isEmpty(b16)) {
            return b16;
        }
        return c();
    }

    public static String c() {
        boolean equalsIgnoreCase = f29137b.equalsIgnoreCase(vu.a.c().i("KEY_ENABLE_VIDEO_FILE_SAVE"));
        QLog.d(f29136a, 1, "getQavSdkConfigFromDebugPanel open=" + equalsIgnoreCase);
        if (!equalsIgnoreCase) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("RECENCYUV", 1);
            jSONObject2.put("RECENC264", 1);
            jSONObject.put("encConfig", jSONObject2);
        } catch (JSONException unused) {
        }
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject3.put("RECDECYUV", 1);
            jSONObject3.put("RECDEC264", 1);
            jSONObject.put("decConfig", jSONObject3);
        } catch (JSONException unused2) {
        }
        return jSONObject.toString();
    }

    public static boolean d() {
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0082  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String e(String str, String str2) {
        FileInputStream fileInputStream;
        BufferedInputStream bufferedInputStream;
        if (QLog.isColorLevel()) {
            QLog.d(f29136a, 2, "loadQavSdkConfigFromFile. dir = " + str + ", filename = " + str2);
        }
        String str3 = null;
        if (str == null || str.equals("") || str2 == null || str2.equals("")) {
            return null;
        }
        File file = new File(str, str2);
        if (!file.exists()) {
            return null;
        }
        try {
            fileInputStream = new FileInputStream(file);
            try {
                bufferedInputStream = new BufferedInputStream(fileInputStream);
                try {
                    byte[] bArr = new byte[fileInputStream.available()];
                    bufferedInputStream.read(bArr);
                    String str4 = new String(bArr, "UTF-8");
                    try {
                        bufferedInputStream.close();
                    } catch (IOException unused) {
                    }
                    try {
                        fileInputStream.close();
                    } catch (IOException unused2) {
                    }
                    str3 = str4;
                } catch (Throwable unused3) {
                    try {
                        file.delete();
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (IOException unused4) {
                            }
                        }
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException unused5) {
                            }
                        }
                        if (QLog.isColorLevel()) {
                        }
                        return str3;
                    } finally {
                    }
                }
            } catch (Throwable unused6) {
                bufferedInputStream = null;
            }
        } catch (Throwable unused7) {
            fileInputStream = null;
            bufferedInputStream = null;
        }
        if (QLog.isColorLevel()) {
            QLog.d(f29136a, 2, "loadConfigFromFile= " + str3);
        }
        return str3;
    }
}
