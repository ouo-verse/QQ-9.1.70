package com.tencent.luggage.wxa.wm;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class e {

    /* renamed from: b, reason: collision with root package name */
    public static String f144293b;

    /* renamed from: c, reason: collision with root package name */
    public static String f144294c;

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f144292a = {"#", QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER, ContainerUtils.FIELD_DELIMITER};

    /* renamed from: d, reason: collision with root package name */
    public static final Pattern f144295d = Pattern.compile("songid=([0-9]+)");

    public static int a(char c16) {
        if (c16 >= '1' && c16 <= '9') {
            return c16 - '0';
        }
        if (c16 < 'A' || c16 > 'F') {
            return 0;
        }
        return (c16 - EmotcationConstants.SYS_EMOTCATION_MODULO_OFFSET) + 10;
    }

    public static boolean b(String str) {
        String str2;
        if (w0.c(str)) {
            return false;
        }
        Uri parse = Uri.parse(str);
        if (parse != null) {
            str2 = parse.getHost();
        } else {
            str2 = "";
        }
        if (str2 != null) {
            boolean contains = parse.getHost().contains(QQWinkConstants.VALID_HOST);
            w.h("MicroMsg.Music.MusicUrlUtil", "url %s match ? %B", str, Boolean.valueOf(contains));
            return contains;
        }
        w.d("MicroMsg.Music.MusicUrlUtil", "host is null, url is not match .qq.com");
        return false;
    }

    public static byte[] c(String str) {
        int i3;
        byte[] bArr = new byte[(str.length() / 2) + (str.length() % 2)];
        int i16 = 0;
        int i17 = 0;
        while (i16 < str.length()) {
            try {
                int i18 = i16 + 1;
                int a16 = a(str.charAt(i16));
                if (i18 < str.length()) {
                    i3 = a(str.charAt(i18));
                    i18++;
                } else {
                    i3 = 0;
                }
                int i19 = i17 + 1;
                bArr[i17] = (byte) ((a16 << 4) | i3);
                i16 = i18;
                i17 = i19;
            } catch (Exception unused) {
                return null;
            }
        }
        return bArr;
    }

    public static String a(Context context) {
        String str;
        String h16 = z.h();
        if (h16 == null) {
            return "";
        }
        try {
            PackageInfo packageInfo = InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), h16, 0);
            if (packageInfo == null) {
                return "";
            }
            str = "" + packageInfo.versionName;
            try {
                return str + "" + packageInfo.versionCode;
            } catch (PackageManager.NameNotFoundException e16) {
                e = e16;
                w.a("MicroMsg.Music.MusicUrlUtil", e, "", new Object[0]);
                return str;
            }
        } catch (PackageManager.NameNotFoundException e17) {
            e = e17;
            str = "";
        }
    }

    public static String a(String str, String str2, boolean z16, com.tencent.luggage.wxa.dn.a aVar) {
        String str3 = (z16 || w0.c(str2)) ? str : str2;
        if (w0.c(str3)) {
            return str3;
        }
        com.tencent.luggage.wxa.dn.e eVar = new com.tencent.luggage.wxa.dn.e();
        w.d("MicroMsg.Music.MusicUrlUtil", "url[%s], lowBandUrl[%s], isWifi[%B]", str, str2, Boolean.valueOf(z16));
        String a16 = a(str3);
        if (a16 != null) {
            if (a(a16, z16, eVar)) {
                aVar.f124395a = z16;
            }
        } else if (str3.contains("wechat_music_url=")) {
            a(str3.substring(str3.indexOf("wechat_music_url=") + 17), z16, eVar);
        } else {
            eVar.f124399a = str3;
        }
        return eVar.f124399a;
    }

    public static String a(String str) {
        if (w0.c(str)) {
            return null;
        }
        String str2 = f144293b;
        if (str2 != null && str.equals(str2)) {
            return f144294c;
        }
        String str3 = "";
        String str4 = null;
        for (String str5 : f144292a) {
            str3 = str5 + "p=";
            if (str.contains(str3)) {
                str4 = str;
            }
            if (str4 != null) {
                break;
            }
        }
        if (str4 == null) {
            return null;
        }
        int indexOf = str4.indexOf(str3);
        if (indexOf < 0) {
            w.h("MicroMsg.Music.MusicUrlUtil", "pIndex is %d, return", Integer.valueOf(indexOf));
            return null;
        }
        String substring = str4.substring(indexOf + str3.length());
        for (String str6 : f144292a) {
            int indexOf2 = substring.indexOf(str6);
            if (indexOf2 > 0) {
                substring = substring.substring(0, indexOf2);
            }
        }
        if (substring != null) {
            f144293b = str;
            f144294c = substring;
        }
        return substring;
    }

    public static boolean a(String str, boolean z16, com.tencent.luggage.wxa.dn.e eVar) {
        String str2 = new String(c(str));
        int indexOf = str2.indexOf("{");
        if (indexOf != -1) {
            str2 = str2.substring(indexOf);
        }
        try {
            JSONObject jSONObject = new JSONObject(str2);
            String string = jSONObject.getString("song_WapLiveURL");
            String string2 = jSONObject.getString("song_WifiURL");
            w.a("MicroMsg.Music.MusicUrlUtil", "waplive: " + string + "  wifi:" + string2);
            if (z16) {
                string = string2;
            }
            eVar.f124399a = string;
            return true;
        } catch (Exception e16) {
            eVar.f124399a = str;
            w.a("MicroMsg.Music.MusicUrlUtil", e16, "decodeJson", new Object[0]);
            return false;
        }
    }
}
