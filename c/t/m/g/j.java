package c.t.m.g;

import com.tencent.mobileqq.vas.theme.ThemeReporter;
import common.config.service.QzoneConfig;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f29769a = false;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f29770b = false;

    /* renamed from: c, reason: collision with root package name */
    public static boolean f29771c = false;

    /* renamed from: d, reason: collision with root package name */
    public static boolean f29772d = false;

    /* renamed from: e, reason: collision with root package name */
    public static boolean f29773e = true;

    /* renamed from: f, reason: collision with root package name */
    public static boolean f29774f = false;

    /* renamed from: g, reason: collision with root package name */
    public static boolean f29775g = false;

    /* renamed from: h, reason: collision with root package name */
    public static boolean f29776h = false;

    /* renamed from: i, reason: collision with root package name */
    public static volatile c f29777i;

    /* renamed from: j, reason: collision with root package name */
    public static final a f29778j = new a();

    /* renamed from: k, reason: collision with root package name */
    public static y f29779k = y.f30109a;

    public static final String a(int i3) {
        if (f29769a) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(f29776h ? "https://lstest.map.qq.com/nlpdr?sf" : "https://nlp.map.qq.com/?sf");
            sb5.append(i3);
            return sb5.toString();
        }
        String str = f29776h ? "https://testdatalbs.sparta.html5.qq.com/tr?sf" : "https://analytics.map.qq.com/?sf";
        if (i3 <= 1) {
            return i3 == 1 ? str : "";
        }
        return str + i3;
    }

    public static final String b() {
        return "fc4.";
    }

    public static final int a(String str) {
        if (str.startsWith("fc4") || str.startsWith("dc4")) {
            return 4;
        }
        if (str.startsWith("fc3") || str.startsWith("dc3")) {
            return 3;
        }
        if (str.startsWith("fc2") || str.startsWith("dc2")) {
            return 2;
        }
        return (str.startsWith("fc1") || str.startsWith("fc") || str.startsWith("dc")) ? 1 : -1;
    }

    public static HashMap<String, String> a() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("D_CH_ID", "fc_sdk");
        hashMap.put("D_FC_SRC", ThemeReporter.FROM_PUSH);
        hashMap.put("D_UP_INTERVAL", "1800000");
        hashMap.put("D_UP_USE_HTTPS", "true");
        hashMap.put("D_MAX_1F_SIZE", "102400");
        hashMap.put("D_NUM_UP", "1");
        hashMap.put("D_MAX_BUF_WF", "25600");
        hashMap.put("D_MAX_FOLDER_SIZE", QzoneConfig.DefaultValue.DEFUALT_UPLOAD_VIDEO_FILE_SIZE_LIMIT_FOR_NON_VIP);
        hashMap.put("D_MAX_DAY_RENAME", "3");
        hashMap.put("D_MAX_DAY_DELETE", "30");
        hashMap.put("D_MAX_SIZE_UP_1DAY", "10485760");
        hashMap.put("D_UP_NET", "w");
        hashMap.put("D_POS_COLL", "false");
        hashMap.put("D_WRITE_MAC", "false");
        hashMap.put("D_UP_WF_INFO", "true");
        hashMap.put("D_UP_U_TRACK_INFO", "false");
        hashMap.put("D_UP_GPS_FOR_NAVI", "false");
        return hashMap;
    }
}
