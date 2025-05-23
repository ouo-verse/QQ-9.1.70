package com.tencent.mobileqq.onlinestatus.guide;

import android.content.SharedPreferences;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes16.dex */
public class c {
    protected boolean a(AppRuntime appRuntime, String str, long j3) {
        if (appRuntime == null) {
            QLog.i("StatusGuideStateSaver", 1, "checkInClickIds app=null,key=" + str);
            return false;
        }
        SharedPreferences preferences = appRuntime.getPreferences();
        if (preferences == null) {
            QLog.i("StatusGuideStateSaver", 1, "checkInClickIds preferences=null,key=" + str);
            return false;
        }
        String string = preferences.getString(str, "");
        QLog.i("StatusGuideStateSaver", 1, "checkInClickIds key=" + str + ",statusId=" + j3 + ",ids=" + string);
        if (string == null || !string.contains(String.valueOf(j3))) {
            return false;
        }
        return true;
    }

    public boolean b(AppRuntime appRuntime, long j3) {
        return a(appRuntime, "status_guide_conversation_click_ids", j3);
    }

    public boolean c(AppRuntime appRuntime, long j3) {
        return a(appRuntime, "status_guide_panel_click_ids", j3);
    }

    public long d(AppRuntime appRuntime, long j3) {
        if (appRuntime == null) {
            QLog.i("StatusGuideStateSaver", 1, "getFirstShowTime app == null");
            return -1L;
        }
        SharedPreferences preferences = appRuntime.getPreferences();
        if (preferences == null) {
            QLog.i("StatusGuideStateSaver", 1, "getFirstShowTime preferences == null");
            return -1L;
        }
        long j16 = preferences.getLong("status_guide_first_show_time" + j3, 0L);
        QLog.i("StatusGuideStateSaver", 1, "getFirstShowTime statusId=" + j3 + ",firstTime=" + j16);
        return j16;
    }

    protected void e(AppRuntime appRuntime, long j3, String str) {
        if (appRuntime == null) {
            QLog.i("StatusGuideStateSaver", 1, "saveClickIds app == null,key = " + str);
            return;
        }
        SharedPreferences preferences = appRuntime.getPreferences();
        if (preferences == null) {
            QLog.i("StatusGuideStateSaver", 1, "saveClickIds preferences == null,key = " + str);
            return;
        }
        SharedPreferences.Editor edit = preferences.edit();
        String valueOf = String.valueOf(j3);
        String string = preferences.getString(str, "");
        if (string != null && !string.isEmpty()) {
            if (string.contains(valueOf)) {
                valueOf = string;
            } else {
                valueOf = string + " " + valueOf;
            }
        }
        QLog.i("StatusGuideStateSaver", 1, "saveClickIds newClickIds=" + valueOf + ",oldClickIds=" + string + ",statusId=" + j3 + ",key=" + str);
        edit.putString(str, valueOf);
        edit.commit();
    }

    public void f(AppRuntime appRuntime, long j3) {
        e(appRuntime, j3, "status_guide_conversation_click_ids");
    }

    public void g(AppRuntime appRuntime, long j3, long j16) {
        if (appRuntime == null) {
            QLog.i("StatusGuideStateSaver", 1, "saveFirstShowTime app == null");
            return;
        }
        SharedPreferences preferences = appRuntime.getPreferences();
        if (preferences == null) {
            QLog.i("StatusGuideStateSaver", 1, "saveFirstShowTime preferences == null");
            return;
        }
        String str = "status_guide_first_show_time" + j3;
        if (preferences.getLong(str, 0L) <= 0) {
            SharedPreferences.Editor edit = appRuntime.getPreferences().edit();
            edit.putLong(str, j16);
            edit.apply();
            QLog.i("StatusGuideStateSaver", 1, "saveFirstShowTime statusId=" + j3 + ",serverTime=" + j16);
        }
    }

    public void h(AppRuntime appRuntime, long j3) {
        e(appRuntime, j3, "status_guide_panel_click_ids");
    }
}
