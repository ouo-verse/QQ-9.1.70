package id0;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.editor.params.EditVideoParams;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import xc0.c;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static final String f407529a = c.c(R.string.fx5);

    /* renamed from: b, reason: collision with root package name */
    public static ConcurrentHashMap<Class, Integer> f407530b = new ConcurrentHashMap<>();

    /* renamed from: c, reason: collision with root package name */
    private static final List<String> f407531c = Arrays.asList("time_openshoot", "time_waitshoot", "clk_mode", "start_shoot", "time_shoot", "time_openedit", "time_edit", "clk_function", "time_composite");

    public static int a(int i3) {
        int i16 = 1;
        if (i3 != 1) {
            i16 = 3;
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 == 4) {
                        return 4;
                    }
                    if (i3 == 6) {
                        return 2;
                    }
                    return 6;
                }
                return 5;
            }
        }
        return i16;
    }

    public static String b(int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 4) {
                        if (i3 != 9) {
                            return "";
                        }
                        return "9";
                    }
                    return "4";
                }
                return "2";
            }
            return "1";
        }
        return "0";
    }

    @NonNull
    public static String c(int i3, String... strArr) {
        if (strArr != null && strArr.length > i3) {
            return strArr[i3];
        }
        return "";
    }

    public static String d(Context context) {
        int systemNetwork = NetworkUtil.getSystemNetwork(context);
        int i3 = 4;
        int i16 = 1;
        if (systemNetwork != 1) {
            if (systemNetwork != 2) {
                i16 = 3;
                if (systemNetwork == 3) {
                    i3 = 2;
                } else if (systemNetwork != 4) {
                    i3 = 5;
                }
            }
            i3 = i16;
        }
        return "" + i3;
    }

    public static int e(int i3) {
        if (i3 != 10005) {
            if (i3 != 10017) {
                if (i3 != 10012) {
                    if (i3 != 10013) {
                        switch (i3) {
                            case 10000:
                                return 5;
                            case 10001:
                                return 4;
                            case 10002:
                                break;
                            default:
                                return 0;
                        }
                    }
                } else {
                    return 2;
                }
            }
            return 3;
        }
        return 1;
    }

    public static int f(Class<? extends QQStoryBaseActivity> cls, int i3) {
        Integer num = f407530b.get(cls);
        if (num == null) {
            return i3;
        }
        return num.intValue();
    }

    public static boolean g(long j3, long j16, long j17) {
        if (j3 >= j16 && j3 <= j17) {
            return true;
        }
        return false;
    }

    private static void h(Map<String, String> map, String str, String str2) {
        String str3 = "\u4e8b\u4ef6Code : " + str2 + "   \u4e0a\u62a5\u5185\u5bb9 ----------  \n";
        for (Map.Entry<String, String> entry : map.entrySet()) {
            str3 = (((str3 + entry.getKey()) + "   :   ") + entry.getValue()) + "\n";
        }
        if (QLog.isColorLevel()) {
            QLog.d(str, 2, str3);
        }
    }

    public static void i(String str, String... strArr) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("op_r1", c(0, strArr));
        hashMap.put("op_r2", c(1, strArr));
        h(hashMap, "reportALUMB", str);
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, str, true, 0L, 0L, hashMap, null);
    }

    public static void j(String str, String str2, Intent intent, String... strArr) {
        int intExtra;
        if (intent == null) {
            return;
        }
        EditVideoParams editVideoParams = (EditVideoParams) intent.getParcelableExtra(EditVideoParams.class.getName());
        if (editVideoParams != null) {
            intExtra = editVideoParams.l("extra_ablum_type", -1);
        } else {
            intExtra = intent.getIntExtra("extra_ablum_type", -1);
        }
        int a16 = a(intExtra);
        String[] strArr2 = new String[strArr.length + 1];
        strArr2[0] = a16 + "";
        System.arraycopy(strArr, 0, strArr2, 1, strArr.length);
        n(str, str2, 0, 0, strArr2);
    }

    public static void k(String str, String str2, int i3, int i16, String... strArr) {
        try {
            if (hd0.c.q()) {
                hd0.c.f("StoryReportor", "Dev[op_type]%s;[op_name]%s;[op_in]%d;[op_result]%d;[d1]%s;[d2]%s;[d3]%s;[d4]%s", str, str2, Integer.valueOf(i3), Integer.valueOf(i16), c(0, strArr), c(1, strArr), c(2, strArr), c(3, strArr));
            }
        } catch (Exception unused) {
        }
        ReportController.o(null, "dc00899", "grp_story_engineer", "", str, str2, i3, i16, c(0, strArr), c(1, strArr), c(2, strArr), c(3, strArr));
    }

    public static void l(String str, int i3, int i16, String... strArr) {
        if (i3 == 10000 || i3 == 10001) {
            n("video_edit_new", str, i3, i16, strArr);
        }
        if (f407531c.contains(str)) {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("op_type", "video_edit_new");
            hashMap.put("op_name", String.valueOf(str));
            hashMap.put("op_result", String.valueOf(i16));
            hashMap.put("op_r1", c(0, strArr));
            hashMap.put("op_r2", c(1, strArr));
            hashMap.put("op_r3", c(2, strArr));
            hashMap.put("op_r4", c(3, strArr));
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "video_edit_new_" + str, true, 0L, 0L, hashMap, null);
        }
    }

    public static void m(Activity activity, String str, String str2, String str3) {
        int intExtra = activity.getIntent().getIntExtra(ShortVideoConstants.CAPTURE_OPERATION_IN, -1);
        if (intExtra == 10002 || intExtra == 10000) {
            n("video_edit_new", str, intExtra, 0, str2, str3);
        }
    }

    public static void n(String str, String str2, int i3, int i16, String... strArr) {
        try {
            if (hd0.c.q()) {
                hd0.c.f("StoryReportor", "[op_type]%s;[op_name]%s;[op_in]%d;[op_result]%d;[d1]%s;[d2]%s;[d3]%s;[d4]%s", str, str2, Integer.valueOf(i3), Integer.valueOf(i16), c(0, strArr), c(1, strArr), c(2, strArr), c(3, strArr));
            }
        } catch (Exception unused) {
        }
        ReportController.o(null, "dc00899", f407529a, "", str, str2, i3, i16, c(0, strArr), c(1, strArr), c(2, strArr), c(3, strArr));
    }

    public static void o(String str, int i3, int i16, boolean z16, String... strArr) {
        if (i3 == 10002 || i3 == 10000 || i3 == 10001 || !z16 || i3 == js.a.f410919s.b() || i3 == js.a.f410908h.b() || i3 == js.a.Q.b()) {
            n("video_shoot_new", str, i3, i16, strArr);
            if (f407531c.contains(str)) {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("op_type", "video_shoot_new");
                hashMap.put("op_name", String.valueOf(str));
                hashMap.put("op_result", String.valueOf(i16));
                hashMap.put("op_r1", c(0, strArr));
                hashMap.put("op_r2", c(1, strArr));
                hashMap.put("op_r3", c(2, strArr));
                hashMap.put("op_r4", c(3, strArr));
                StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "video_shoot_new_" + str, true, 0L, 0L, hashMap, null);
            }
        }
    }

    public static void p(String str, int i3, int i16, String... strArr) {
        o(str, i3, i16, true, strArr);
    }

    public static void q(int i3, long j3, String str) {
        long uptimeMillis = SystemClock.uptimeMillis() - j3;
        if (uptimeMillis > 86400000) {
            return;
        }
        n("home_page", "time_stay_new", i3, (int) uptimeMillis, str);
    }

    public static void r(String str, boolean z16, long j3, String... strArr) {
        HashMap<String, String> hashMap = new HashMap<>();
        if (strArr != null) {
            int i3 = 0;
            while (i3 < strArr.length) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("op_r");
                int i16 = i3 + 1;
                sb5.append(i16);
                hashMap.put(sb5.toString(), strArr[i3]);
                i3 = i16;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.qqstory.StoryReportor", 2, "780, reportToBeacon, ", str, ", isSuc:", Boolean.valueOf(z16), " duration:", Long.valueOf(j3), " eventValue:", hashMap.toString());
        }
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, str, z16, j3, 0L, hashMap, null);
    }
}
