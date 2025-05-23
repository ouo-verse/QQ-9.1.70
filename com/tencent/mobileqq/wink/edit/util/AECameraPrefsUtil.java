package com.tencent.mobileqq.wink.edit.util;

import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qmmkv.QMMKV;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import y53.f;

/* loaded from: classes21.dex */
public class AECameraPrefsUtil {
    private static final List<Pair<String, Integer>> H;
    private static final Set<String> I;
    private static final Map<String, WinkMMKVMigrateTask> J;

    /* renamed from: a, reason: collision with root package name */
    public static String f318463a = "ShadowBackendSvc.GetCategoryMaterialMqStoryCamera";

    /* renamed from: b, reason: collision with root package name */
    public static String f318464b = "ShadowBackendSvc.GetCategoryMaterialMqEmoCamera";

    /* renamed from: c, reason: collision with root package name */
    public static String f318465c = "ShadowBackendSvc.GetPlayShowCatMatTree";

    /* renamed from: d, reason: collision with root package name */
    public static String f318466d = "ShadowBackendSvc.GetCircleCatMatTreeMqKuaishanEdit";

    /* renamed from: e, reason: collision with root package name */
    public static String f318467e = "ShadowBackendSvc.GetCircleCatMatTreeMqKuaishanTemplate";

    /* renamed from: f, reason: collision with root package name */
    public static String f318468f = "ShadowBackendSvc.GetCircleCatMatTreeMqKuaishanRecommend";

    /* renamed from: g, reason: collision with root package name */
    public static String f318469g = "key_app_version";

    /* renamed from: h, reason: collision with root package name */
    public static String f318470h = "key_wink_home_test_user_published";

    /* renamed from: i, reason: collision with root package name */
    public static String f318471i = "key_eidt_medialmodel_";

    /* renamed from: j, reason: collision with root package name */
    public static String f318472j = "key_first_into_crop_page";

    /* renamed from: k, reason: collision with root package name */
    public static String f318473k = "key_first_modify_smart_clip";

    /* renamed from: l, reason: collision with root package name */
    public static String f318474l = "key_first_show_effect_face_red_dot";

    /* renamed from: m, reason: collision with root package name */
    public static String f318475m = "key_wink_export_completed_mission";

    /* renamed from: n, reason: collision with root package name */
    public static String f318476n = "key_wink_compress_completed_mission";

    /* renamed from: r, reason: collision with root package name */
    public static String f318480r = "\u5168\u90e8";

    /* renamed from: s, reason: collision with root package name */
    public static String f318481s = "___";

    /* renamed from: o, reason: collision with root package name */
    public static String f318477o = "rhythm";

    /* renamed from: t, reason: collision with root package name */
    public static String f318482t = "ShadowBackendSvc.GetCircleCatMatTreeMqKuaishanEdit." + f318477o;

    /* renamed from: p, reason: collision with root package name */
    public static String f318478p = "redot";

    /* renamed from: u, reason: collision with root package name */
    public static String f318483u = "ShadowBackendSvc.GetCircleCatMatTreeMqKuaishanEdit." + f318478p;

    /* renamed from: q, reason: collision with root package name */
    public static String f318479q = "bubble";

    /* renamed from: v, reason: collision with root package name */
    public static String f318484v = "ShadowBackendSvc.GetCircleCatMatTreeMqKuaishanEdit." + f318479q;

    /* renamed from: w, reason: collision with root package name */
    public static String f318485w = "key_wink_picker_first_video_cancel_times";

    /* renamed from: x, reason: collision with root package name */
    public static String f318486x = "key_wink_picker_first_video_consume";

    /* renamed from: y, reason: collision with root package name */
    public static String f318487y = "key_wink_picker_first_video_show_timestamp";

    /* renamed from: z, reason: collision with root package name */
    public static String f318488z = "key_wink_no_click_share_avatar_video";
    public static String A = "key_wink_last_share_avatar_video_time";
    public static String B = "key_wink_no_click_share_sign_video";
    public static String C = "key_wink_last_share_sign_video_time";
    public static String D = "key_first_wink_enhance";
    public static String E = "key_wink_first_show_ai_elimination";
    public static String F = "key_wink_ai_elimination_clicked";
    public static String G = "key_wink_ai_elimination_safe_dialog_confirm";

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes21.dex */
    public @interface PreferenceMode {
    }

    /* loaded from: classes21.dex */
    private static class a {
        static boolean a(@NonNull String str, boolean z16) {
            return d().getBoolean(str, z16);
        }

        static int b(@NonNull String str, int i3) {
            return d().getInt(str, i3);
        }

        static long c(@NonNull String str, long j3) {
            return d().getLong(str, j3);
        }

        private static SharedPreferences d() {
            return AECameraPrefsUtil.f("wink_short_video_ptu_template_sdk_sp", 0);
        }

        @Nullable
        static String e(@NonNull String str, String str2) {
            return d().getString(str, str2);
        }

        static void f(@NonNull String str, boolean z16) {
            SharedPreferences.Editor edit = d().edit();
            edit.putBoolean(str, z16);
            edit.apply();
        }

        static void g(@NonNull String str, int i3) {
            SharedPreferences.Editor edit = d().edit();
            edit.putInt(str, i3);
            edit.apply();
        }

        static void h(@NonNull String str, long j3) {
            SharedPreferences.Editor edit = d().edit();
            edit.putLong(str, j3);
            edit.apply();
        }

        static void i(@NonNull String str, String str2) {
            SharedPreferences.Editor edit = d().edit();
            edit.putString(str, str2);
            edit.apply();
        }

        static void j(@NonNull String str) {
            SharedPreferences.Editor edit = d().edit();
            edit.remove(str);
            edit.apply();
        }
    }

    /* loaded from: classes21.dex */
    private static class b {
        static boolean a(@NonNull String str, boolean z16) {
            return d().getBoolean(str, z16);
        }

        static int b(@NonNull String str, int i3) {
            return d().getInt(str, i3);
        }

        static long c(@NonNull String str, long j3) {
            return d().getLong(str, j3);
        }

        private static SharedPreferences d() {
            return AECameraPrefsUtil.f("ae_camera_multi_process_sp", 4);
        }

        @Nullable
        static String e(@NonNull String str, String str2) {
            return d().getString(str, str2);
        }

        static void f(@NonNull String str, boolean z16) {
            SharedPreferences.Editor edit = d().edit();
            edit.putBoolean(str, z16);
            edit.apply();
        }

        static void g(@NonNull String str, int i3) {
            SharedPreferences.Editor edit = d().edit();
            edit.putInt(str, i3);
            edit.apply();
        }

        static void h(@NonNull String str, long j3) {
            SharedPreferences.Editor edit = d().edit();
            edit.putLong(str, j3);
            edit.apply();
        }

        static void i(@NonNull String str, String str2) {
            SharedPreferences.Editor edit = d().edit();
            edit.putString(str, str2);
            edit.apply();
        }

        static void j(@NonNull String str) {
            SharedPreferences.Editor edit = d().edit();
            edit.remove(str);
            edit.apply();
        }
    }

    /* loaded from: classes21.dex */
    private static class c {

        /* renamed from: a, reason: collision with root package name */
        private static final AECameraPrefsUtil f318489a = new AECameraPrefsUtil();
    }

    static {
        LinkedList linkedList = new LinkedList();
        H = linkedList;
        I = Collections.synchronizedSet(new HashSet());
        J = new ConcurrentHashMap();
        linkedList.add(new Pair("AEKIT_CAMERA_FIRST_LAUNCH", 0));
        linkedList.add(new Pair(f318463a, 4));
        linkedList.add(new Pair(f318464b, 4));
        linkedList.add(new Pair(f318465c, 4));
    }

    AECameraPrefsUtil() {
        String e16 = b.e(f318469g, "");
        if (TextUtils.isEmpty(e16) || !AppSetting.d().equals(e16)) {
            for (Pair<String, Integer> pair : H) {
                if (4 == ((Integer) pair.second).intValue()) {
                    b.j((String) pair.first);
                } else {
                    a.j((String) pair.first);
                }
            }
            b.i(f318469g, AppSetting.d());
        }
    }

    public static AECameraPrefsUtil c() {
        return c.f318489a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static SharedPreferences f(@androidx.annotation.NonNull String str, int i3) {
        if (com.tencent.mobileqq.wink.b.c() == null) {
            return null;
        }
        SharedPreferences fromSpAdapter = QMMKV.fromSpAdapter(com.tencent.mobileqq.wink.b.c(), str, QMMKVFile.FILE_QCIRCLE);
        Set<String> set = I;
        if (set.contains(str)) {
            return new f(fromSpAdapter, str, true);
        }
        if (fromSpAdapter.getBoolean("sp_has_migrate_" + str, false)) {
            set.add(str);
            return new f(fromSpAdapter, str, true);
        }
        Map<String, WinkMMKVMigrateTask> map = J;
        if (map.get(str) == null) {
            WinkMMKVMigrateTask winkMMKVMigrateTask = new WinkMMKVMigrateTask(str);
            map.put(str, winkMMKVMigrateTask);
            ThreadManagerV2.excute(winkMMKVMigrateTask, 64, null, true);
        }
        w53.b.c("AECameraPrefsUtil", "sp has not migrate to mmkv\uff0cuse old sp:" + str);
        return new f(com.tencent.mobileqq.wink.b.c().getSharedPreferences(str, i3), str, false);
    }

    public boolean b(@NonNull String str, boolean z16, int i3) {
        if (4 == i3) {
            return b.a(str, z16);
        }
        return a.a(str, z16);
    }

    public int d(@NonNull String str, int i3, int i16) {
        if (4 == i16) {
            return b.b(str, i3);
        }
        return a.b(str, i3);
    }

    public long e(@NonNull String str, long j3, int i3) {
        if (4 == i3) {
            return b.c(str, j3);
        }
        return a.c(str, j3);
    }

    @Nullable
    public String g(@NonNull String str, String str2, int i3) {
        if (4 == i3) {
            return b.e(str, str2);
        }
        return a.e(str, str2);
    }

    public void h(@NonNull String str, boolean z16, int i3) {
        if (4 == i3) {
            b.f(str, z16);
        } else {
            a.f(str, z16);
        }
    }

    public void i(@NonNull String str, int i3, int i16) {
        if (4 == i16) {
            b.g(str, i3);
        } else {
            a.g(str, i3);
        }
    }

    public void j(@NonNull String str, long j3, int i3) {
        if (4 == i3) {
            b.h(str, j3);
        } else {
            a.h(str, j3);
        }
    }

    public void k(@NonNull String str, String str2, int i3) {
        if (4 == i3) {
            b.i(str, str2);
        } else {
            a.i(str, str2);
        }
    }

    public void l(@NonNull String str, int i3) {
        if (4 == i3) {
            b.j(str);
        } else {
            a.j(str);
        }
    }
}
