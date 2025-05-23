package com.tencent.mobileqq.activity.contact.addcontact.face2face;

import android.content.SharedPreferences;
import android.os.SystemClock;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes10.dex */
public class c {
    static IPatchRedirector $redirector_;

    public static void a(long j3, List<d> list) {
        int elapsedRealtime = ((int) (SystemClock.elapsedRealtime() - j3)) / 1000;
        Iterator<d> it = list.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            if (it.next().a()) {
                i3++;
            }
        }
        b("0X800AB63", i3 + "", elapsedRealtime + "", "");
    }

    public static void b(String str, String str2, String str3, String str4) {
        if (QLog.isColorLevel()) {
            QLog.d("Face2FaceAddContactUtils", 2, " face2faceReport tValue = " + str + " r2 = " + str2 + " r3 = " + str3 + " r4 =" + str4);
        }
        ReportController.o(null, "dc00898", "", "", str, str, 0, 0, str2, str3, str4, "");
    }

    public static boolean c(QQAppInterface qQAppInterface) {
        if (qQAppInterface == null) {
            return false;
        }
        return !qQAppInterface.getPreferences().getBoolean("face2face_add_contact_guide_dialog", false);
    }

    public static void d(QQAppInterface qQAppInterface) {
        if (qQAppInterface != null) {
            SharedPreferences.Editor edit = qQAppInterface.getPreferences().edit();
            edit.putBoolean("face2face_add_contact_guide_dialog", true);
            edit.commit();
        }
    }
}
