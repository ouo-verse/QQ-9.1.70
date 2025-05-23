package common.config.service;

import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import cooperation.qzone.QUA;
import cooperation.qzone.util.QZLog;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes28.dex */
public class b {

    /* renamed from: b, reason: collision with root package name */
    private static b f390043b;

    /* renamed from: a, reason: collision with root package name */
    private Pattern f390044a = Pattern.compile("(\\d+)\\.(\\d+).(\\d+)_(\\d+)");

    b() {
    }

    private boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            String[] split = str.split(",");
            if (split.length < 2) {
                return false;
            }
            int[] g16 = g(split[0].trim());
            int[] g17 = g(split[1].trim());
            if (g16 != null && g17 != null && g16.length >= 4 && g17.length >= 4) {
                long j3 = (g16[0] << 32) + (g16[1] << 24) + (g16[2] << 16) + g16[3];
                try {
                    long j16 = (g17[0] << 32) + (g17[1] << 24) + (g17[2] << 16) + g17[3];
                    Matcher matcher = this.f390044a.matcher(QUA.getQUA3());
                    if (matcher.find()) {
                        long parseLong = (Long.parseLong(matcher.group(1)) << 32) + (Long.parseLong(matcher.group(2)) << 24) + (Long.parseLong(matcher.group(3)) << 16) + Long.parseLong(matcher.group(4));
                        if (parseLong < j3 || parseLong > j16) {
                            return false;
                        }
                    }
                    return true;
                } catch (Throwable unused) {
                    return false;
                }
            }
            return false;
        } catch (Throwable unused2) {
            return false;
        }
    }

    public static b e() {
        if (f390043b == null) {
            synchronized (b.class) {
                if (f390043b == null) {
                    f390043b = new b();
                }
            }
        }
        return f390043b;
    }

    private boolean f(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        String optString = jSONObject.optString("appVersionRange");
        if (!TextUtils.isEmpty(optString) && !a(optString)) {
            return false;
        }
        String optString2 = jSONObject.optString("osVersionRange");
        if (!TextUtils.isEmpty(optString2)) {
            String[] split = optString2.split(",");
            int parseInt = Integer.parseInt(split[0].trim());
            int parseInt2 = Integer.parseInt(split[1].trim());
            int i3 = Build.VERSION.SDK_INT;
            if (i3 < parseInt || i3 > parseInt2) {
                return false;
            }
        }
        String optString3 = jSONObject.optString("uinRange");
        if (!TextUtils.isEmpty(optString3)) {
            String[] split2 = optString3.split(",");
            if (split2[0].length() != split2[1].length()) {
                return false;
            }
            int parseInt3 = Integer.parseInt(split2[0]);
            int parseInt4 = Integer.parseInt(split2[1]);
            int longAccountUin = (int) (MobileQQ.sMobileQQ.waitAppRuntime(null).getLongAccountUin() % ((int) Math.pow(10.0d, r1)));
            if (longAccountUin < parseInt3 || longAccountUin > parseInt4) {
                return false;
            }
        }
        return true;
    }

    private int[] g(String str) {
        try {
            String[] split = str.split("_");
            if (split.length < 2) {
                return null;
            }
            String[] split2 = split[0].split("\\.");
            if (split2.length < 3) {
                return null;
            }
            int[] iArr = new int[4];
            for (int i3 = 0; i3 < 3; i3++) {
                iArr[i3] = Integer.parseInt(split2[i3]);
            }
            iArr[3] = Integer.parseInt(split[1]);
            return iArr;
        } catch (Throwable unused) {
            return null;
        }
    }

    public int b(String str, String str2, int i3) {
        String c16 = c(str, str2);
        if (c16 == null) {
            return i3;
        }
        try {
            return Integer.valueOf(c16).intValue();
        } catch (Exception unused) {
            return i3;
        }
    }

    public String c(String str, String str2) {
        String config = QzoneConfig.getInstance().getConfig(str, str2);
        if (config == null) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray(config);
            int length = jSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i3);
                String optString = jSONObject.optString("configId");
                String optString2 = jSONObject.optString("value");
                Log.d("QzoneAlphaConfig", "configId=" + optString + " value=" + optString2);
                if (f(jSONObject)) {
                    return optString2;
                }
            }
            return null;
        } catch (JSONException unused) {
            QZLog.e("QzoneAlphaConfig", "failed parsing config:" + config);
            return null;
        }
    }

    public String d(String str, String str2, String str3) {
        String c16 = c(str, str2);
        if (TextUtils.isEmpty(c16)) {
            return str3;
        }
        return c16;
    }
}
