package com.tencent.mobileqq.colornote;

import android.content.SharedPreferences;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.data.ColorNoteRecentConfigProcessor;
import com.tencent.mobileqq.colornote.ipc.IColorNoteProcessState;
import com.tencent.mobileqq.colornote.smallscreen.ColorNoteSmallScreenUtil;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes5.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private ColorNoteCurd f201404a;

    private static SharedPreferences a(AppRuntime appRuntime) {
        String str = "color_note_recent_view_switch" + appRuntime.getAccount();
        SharedPreferences fromSpAdapter = QMMKV.fromSpAdapter(MobileQQ.sMobileQQ, str, "common_mmkv_configurations");
        if (!fromSpAdapter.getBoolean("_migrate_flag_", false)) {
            QMMKV.migrateToSpAdapter(appRuntime.getApplicationContext(), str, "common_mmkv_configurations");
            fromSpAdapter.edit().putBoolean("_migrate_flag_", true).apply();
        }
        return fromSpAdapter;
    }

    public static boolean b(AppRuntime appRuntime) {
        SharedPreferences a16 = a(appRuntime);
        if (a16 == null) {
            return false;
        }
        return a16.getBoolean("color_recent_permission_shown", false);
    }

    public static boolean c() {
        SharedPreferences a16 = a(MobileQQ.getMobileQQ().waitAppRuntime(null));
        if (a16 == null || a16.getBoolean("color_note_recent_first_visit", false)) {
            return false;
        }
        a16.edit().putBoolean("color_note_recent_first_visit", true).apply();
        return true;
    }

    public static boolean d(AppRuntime appRuntime) {
        SharedPreferences a16 = a(appRuntime);
        if (a16 == null) {
            return true;
        }
        return a16.getBoolean("color_note_recently_viewed_switch", true);
    }

    public static void f(AppRuntime appRuntime) {
        SharedPreferences a16 = a(appRuntime);
        if (a16 != null) {
            a16.edit().putBoolean("color_note_recent_first_visit", false).apply();
        }
    }

    public static void g(AppRuntime appRuntime, boolean z16) {
        SharedPreferences a16 = a(appRuntime);
        if (a16 != null) {
            a16.edit().putBoolean("color_recent_permission_shown", z16).apply();
        }
    }

    public static void h(AppRuntime appRuntime, boolean z16) {
        SharedPreferences a16 = a(appRuntime);
        if (a16 != null) {
            a16.edit().putBoolean("color_note_recently_viewed_switch", z16).apply();
            if (!z16) {
                ColorNoteSmallScreenUtil.m(BaseApplication.getContext(), 5, false);
            }
            if (QLog.isColorLevel()) {
                QLog.d("ColorNoteRecentView", 2, "setRecentColorNoteSwitch: " + z16);
            }
        }
    }

    public void e(ColorNoteCurd colorNoteCurd) {
        this.f201404a = colorNoteCurd;
    }

    public void i(ColorNote colorNote) {
        boolean z16;
        ea1.c a16 = ColorNoteRecentConfigProcessor.a();
        if (a16 != null && a16.a()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && colorNote != null && this.f201404a != null && ((IColorNoteProcessState) QRoute.api(IColorNoteProcessState.class)).isRecentColorNoteTurnOn(MobileQQ.getMobileQQ().waitAppRuntime(null))) {
            this.f201404a.r(com.tencent.mobileqq.colornote.data.a.c(colorNote));
            if (QLog.isColorLevel()) {
                QLog.d("ColorNoteRecentView", 2, "updateRecentNote: " + colorNote.toString());
            }
        }
    }
}
