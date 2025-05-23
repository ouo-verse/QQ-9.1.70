package com.tencent.mobileqq.qqvideoedit.edit.util;

import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.common.config.AppSetting;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes17.dex */
public class AECameraPrefsUtil {

    /* renamed from: a, reason: collision with root package name */
    public static String f275086a = "ShadowBackendSvc.GetCategoryMaterialMqStoryCamera";

    /* renamed from: b, reason: collision with root package name */
    public static String f275087b = "ShadowBackendSvc.GetCategoryMaterialMqEmoCamera";

    /* renamed from: c, reason: collision with root package name */
    public static String f275088c = "ShadowBackendSvc.GetPlayShowCatMatTree";

    /* renamed from: d, reason: collision with root package name */
    public static String f275089d = "ShadowBackendSvc.GetCircleCatMatTreeMqKuaishanEdit";

    /* renamed from: e, reason: collision with root package name */
    public static String f275090e = "key_app_version";

    /* renamed from: f, reason: collision with root package name */
    public static String f275091f = "key_eidt_medialmodel_";

    /* renamed from: g, reason: collision with root package name */
    public static String f275092g = "key_editor_switch_mode_dialog";

    /* renamed from: h, reason: collision with root package name */
    public static String f275093h = "key_first_into_crop_page";

    /* renamed from: i, reason: collision with root package name */
    private static final List<Pair<String, Integer>> f275094i;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes17.dex */
    public @interface PreferenceMode {
    }

    /* loaded from: classes17.dex */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final SharedPreferences f275095a = com.tencent.mobileqq.qqvideoedit.a.c().getSharedPreferences("video_short_video_ptu_template_sdk_sp", 0);

        static boolean a(@NonNull String str, boolean z16) {
            return f275095a.getBoolean(str, z16);
        }

        @Nullable
        static String b(@NonNull String str, String str2) {
            return f275095a.getString(str, str2);
        }

        static void c(@NonNull String str, boolean z16) {
            SharedPreferences.Editor edit = f275095a.edit();
            edit.putBoolean(str, z16);
            edit.apply();
        }

        static void d(@NonNull String str, String str2) {
            SharedPreferences.Editor edit = f275095a.edit();
            edit.putString(str, str2);
            edit.apply();
        }

        static void e(@NonNull String str) {
            SharedPreferences.Editor edit = f275095a.edit();
            edit.remove(str);
            edit.apply();
        }
    }

    /* loaded from: classes17.dex */
    private static class b {

        /* renamed from: a, reason: collision with root package name */
        private static final SharedPreferences f275096a = com.tencent.mobileqq.qqvideoedit.a.c().getSharedPreferences("ae_camera_multi_process_sp", 4);

        static boolean a(@NonNull String str, boolean z16) {
            return f275096a.getBoolean(str, z16);
        }

        @Nullable
        static String b(@NonNull String str, String str2) {
            return f275096a.getString(str, str2);
        }

        static void c(@NonNull String str, boolean z16) {
            SharedPreferences.Editor edit = f275096a.edit();
            edit.putBoolean(str, z16);
            edit.apply();
        }

        static void d(@NonNull String str, String str2) {
            SharedPreferences.Editor edit = f275096a.edit();
            edit.putString(str, str2);
            edit.apply();
        }

        static void e(@NonNull String str) {
            SharedPreferences.Editor edit = f275096a.edit();
            edit.remove(str);
            edit.apply();
        }
    }

    /* loaded from: classes17.dex */
    private static class c {

        /* renamed from: a, reason: collision with root package name */
        private static final AECameraPrefsUtil f275097a = new AECameraPrefsUtil();
    }

    static {
        LinkedList linkedList = new LinkedList();
        f275094i = linkedList;
        linkedList.add(new Pair("AEKIT_CAMERA_FIRST_LAUNCH", 0));
        linkedList.add(new Pair(f275086a, 4));
        linkedList.add(new Pair(f275087b, 4));
        linkedList.add(new Pair(f275088c, 4));
    }

    AECameraPrefsUtil() {
        String b16 = b.b(f275090e, "");
        if (TextUtils.isEmpty(b16) || !AppSetting.d().equals(b16)) {
            for (Pair<String, Integer> pair : f275094i) {
                if (4 == ((Integer) pair.second).intValue()) {
                    b.e((String) pair.first);
                } else {
                    a.e((String) pair.first);
                }
            }
            b.d(f275090e, AppSetting.d());
        }
    }

    public static AECameraPrefsUtil b() {
        return c.f275097a;
    }

    public boolean a(@NonNull String str, boolean z16, int i3) {
        if (4 == i3) {
            return b.a(str, z16);
        }
        return a.a(str, z16);
    }

    @Nullable
    public String c(@NonNull String str, String str2, int i3) {
        if (4 == i3) {
            return b.b(str, str2);
        }
        return a.b(str, str2);
    }

    public void d(@NonNull String str, boolean z16, int i3) {
        if (4 == i3) {
            b.c(str, z16);
        } else {
            a.c(str, z16);
        }
    }

    public void e(@NonNull String str, String str2, int i3) {
        if (4 == i3) {
            b.d(str, str2);
        } else {
            a.d(str, str2);
        }
    }

    public void f(@NonNull String str, int i3) {
        if (4 == i3) {
            b.e(str);
        } else {
            a.e(str);
        }
    }
}
