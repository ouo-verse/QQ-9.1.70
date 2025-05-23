package com.tencent.aelight.camera.ae.util;

import android.content.SharedPreferences;
import android.util.Pair;
import com.tencent.aelight.camera.util.api.IAECameraPrefsUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import mqq.app.MobileQQ;

/* loaded from: classes32.dex */
public class AECameraPrefsUtil {

    /* renamed from: a, reason: collision with root package name */
    private static final List<Pair<String, Integer>> f65746a;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes32.dex */
    public @interface PreferenceMode {
    }

    /* loaded from: classes32.dex */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final SharedPreferences f65747a = AECameraPrefsUtil.i();

        static boolean b(String str) {
            return f65747a.contains(str);
        }

        static Set<String> c(String str, Set<String> set) {
            return f65747a.getStringSet(str, set);
        }

        static boolean d(String str, boolean z16) {
            return f65747a.getBoolean(str, z16);
        }

        static float e(String str, float f16) {
            return f65747a.getFloat(str, f16);
        }

        static int f(String str, int i3) {
            return f65747a.getInt(str, i3);
        }

        static long g(String str, long j3) {
            return f65747a.getLong(str, j3);
        }

        static String h(String str, String str2) {
            return f65747a.getString(str, str2);
        }

        static void i(String str, Set<String> set) {
            SharedPreferences.Editor edit = f65747a.edit();
            edit.putStringSet(str, set);
            edit.apply();
        }

        static void j(String str, boolean z16) {
            SharedPreferences.Editor edit = f65747a.edit();
            edit.putBoolean(str, z16);
            edit.apply();
        }

        static void k(String str, float f16) {
            SharedPreferences.Editor edit = f65747a.edit();
            edit.putFloat(str, f16);
            edit.apply();
        }

        static void l(String str, int i3) {
            SharedPreferences.Editor edit = f65747a.edit();
            edit.putInt(str, i3);
            edit.apply();
        }

        static void m(String str, long j3) {
            SharedPreferences.Editor edit = f65747a.edit();
            edit.putLong(str, j3);
            edit.apply();
        }

        static void n(String str, String str2) {
            SharedPreferences.Editor edit = f65747a.edit();
            edit.putString(str, str2);
            edit.apply();
        }

        static void o(String str) {
            SharedPreferences.Editor edit = f65747a.edit();
            edit.remove(str);
            edit.apply();
        }
    }

    /* loaded from: classes32.dex */
    private static class b {

        /* renamed from: a, reason: collision with root package name */
        private static final SharedPreferences f65748a = BaseApplicationImpl.getApplication().getSharedPreferences("ae_camera_multi_process_sp", 4);

        static boolean a(String str) {
            return f65748a.contains(str);
        }

        static Set<String> b(String str, Set<String> set) {
            return f65748a.getStringSet(str, set);
        }

        static boolean c(String str, boolean z16) {
            return f65748a.getBoolean(str, z16);
        }

        static float d(String str, float f16) {
            return f65748a.getFloat(str, f16);
        }

        static int e(String str, int i3) {
            return f65748a.getInt(str, i3);
        }

        static long f(String str, long j3) {
            return f65748a.getLong(str, j3);
        }

        static String g(String str, String str2) {
            return f65748a.getString(str, str2);
        }

        static void h(String str, Set<String> set) {
            SharedPreferences.Editor edit = f65748a.edit();
            edit.putStringSet(str, set);
            edit.apply();
        }

        static void i(String str, boolean z16) {
            SharedPreferences.Editor edit = f65748a.edit();
            edit.putBoolean(str, z16);
            edit.apply();
        }

        static void j(String str, float f16) {
            SharedPreferences.Editor edit = f65748a.edit();
            edit.putFloat(str, f16);
            edit.apply();
        }

        static void k(String str, int i3) {
            SharedPreferences.Editor edit = f65748a.edit();
            edit.putInt(str, i3);
            edit.apply();
        }

        static void l(String str, long j3) {
            SharedPreferences.Editor edit = f65748a.edit();
            edit.putLong(str, j3);
            edit.apply();
        }

        static void m(String str, String str2) {
            SharedPreferences.Editor edit = f65748a.edit();
            edit.putString(str, str2);
            edit.apply();
        }

        static void n(String str) {
            SharedPreferences.Editor edit = f65748a.edit();
            edit.remove(str);
            edit.apply();
        }
    }

    /* loaded from: classes32.dex */
    private static class c {

        /* renamed from: a, reason: collision with root package name */
        private static final AECameraPrefsUtil f65749a = new AECameraPrefsUtil();
    }

    static {
        LinkedList linkedList = new LinkedList();
        f65746a = linkedList;
        linkedList.add(new Pair("AEKIT_CAMERA_FIRST_LAUNCH", 0));
        linkedList.add(new Pair(IAECameraPrefsUtil.KEY_ETAG_STORY, 4));
        linkedList.add(new Pair(IAECameraPrefsUtil.KEY_ETAG_STORY_MAKEUP, 4));
        linkedList.add(new Pair(IAECameraPrefsUtil.KEY_ETAG_FLASH_SHOW, 4));
        linkedList.add(new Pair(IAECameraPrefsUtil.KEY_ETAG_EMOJI, 4));
        linkedList.add(new Pair("ShadowBackendSvc.GetPlayShowCatMatTree", 4));
    }

    AECameraPrefsUtil() {
    }

    public static AECameraPrefsUtil f() {
        return c.f65749a;
    }

    public static SharedPreferences i() {
        return BaseApplication.getContext().getSharedPreferences("short_video_ptu_template_sdk_sp_" + MobileQQ.sProcessId, 0);
    }

    public SharedPreferences d() {
        return a.f65747a;
    }

    public boolean a(String str, int i3) {
        if (4 == i3) {
            return b.a(str);
        }
        return a.b(str);
    }

    public Set<String> b(String str, Set<String> set, int i3) {
        if (4 == i3) {
            return b.b(str, set);
        }
        return a.c(str, set);
    }

    public boolean c(String str, boolean z16, int i3) {
        if (4 == i3) {
            return b.c(str, z16);
        }
        return a.d(str, z16);
    }

    public float e(String str, float f16, int i3) {
        if (4 == i3) {
            return b.d(str, f16);
        }
        return a.e(str, f16);
    }

    public int g(String str, int i3, int i16) {
        if (4 == i16) {
            return b.e(str, i3);
        }
        return a.f(str, i3);
    }

    public long h(String str, long j3, int i3) {
        if (4 == i3) {
            return b.f(str, j3);
        }
        return a.g(str, j3);
    }

    public String j(String str, String str2, int i3) {
        if (4 == i3) {
            return b.g(str, str2);
        }
        return a.h(str, str2);
    }

    public void k(String str, Set<String> set, int i3) {
        if (4 == i3) {
            b.h(str, set);
        } else {
            a.i(str, set);
        }
    }

    public void l(String str, boolean z16, int i3) {
        if (4 == i3) {
            b.i(str, z16);
        } else {
            a.j(str, z16);
        }
    }

    public void m(String str, float f16, int i3) {
        if (4 == i3) {
            b.j(str, f16);
        } else {
            a.k(str, f16);
        }
    }

    public void n(String str, int i3, int i16) {
        if (4 == i16) {
            b.k(str, i3);
        } else {
            a.l(str, i3);
        }
    }

    public void o(String str, long j3, int i3) {
        if (4 == i3) {
            b.l(str, j3);
        } else {
            a.m(str, j3);
        }
    }

    public void p(String str, String str2, int i3) {
        if (4 == i3) {
            b.m(str, str2);
        } else {
            a.n(str, str2);
        }
    }

    public void q(String str, int i3) {
        if (4 == i3) {
            b.n(str);
        } else {
            a.o(str);
        }
    }
}
