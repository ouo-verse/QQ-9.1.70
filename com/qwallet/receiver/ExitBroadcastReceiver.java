package com.qwallet.receiver;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import android.text.format.Time;
import com.qwallet.pay.l;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.Foreground;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ExitBroadcastReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    private static ExitBroadcastReceiver f41710a = null;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f41711b = false;

    private String b(ArrayList<String> arrayList, boolean z16) {
        String obj;
        Time time = new Time();
        time.setToNow();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("com.tencent.process.exit");
        sb5.append(time.year);
        sb5.append(time.month + 1);
        sb5.append(time.monthDay);
        sb5.append(time.hour);
        if (z16) {
            sb5.append(time.minute - 1);
        } else {
            sb5.append(time.minute);
        }
        if (arrayList == null) {
            obj = "null";
        } else {
            obj = arrayList.toString();
        }
        sb5.append(obj);
        return MD5.toMD5(MD5.toMD5(sb5.toString()) + sb5.toString());
    }

    private boolean c(Context context, ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            return true;
        }
        String a16 = a(context);
        if (TextUtils.isEmpty(a16)) {
            return false;
        }
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            if (a16.equals(arrayList.get(i3))) {
                return true;
            }
        }
        return false;
    }

    private boolean e(String str, ArrayList<String> arrayList) {
        if (Foreground.getActivityCount() > 0 || str == null || str.length() == 0) {
            return false;
        }
        if (!str.equals(b(arrayList, false)) && !str.equals(b(arrayList, true))) {
            return false;
        }
        return true;
    }

    public static void f(Context context) {
        if (f41710a != null && f41711b) {
            try {
                context.getApplicationContext().unregisterReceiver(f41710a);
            } catch (Exception e16) {
                QLog.e("ExitBroadcastReceiver", 1, "", e16);
            }
        }
    }

    String a(Context context) {
        int myPid = Process.myPid();
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : SystemMethodProxy.getRunningAppProcesses((ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY))) {
            if (runningAppProcessInfo.pid == myPid) {
                return runningAppProcessInfo.processName;
            }
        }
        return null;
    }

    protected boolean d(Bundle bundle) {
        if (bundle != null && bundle.getBoolean("qq_mode_foreground", false) && l.o()) {
            Time time = new Time();
            time.setToNow();
            int i3 = time.month;
            if (i3 >= 0 && i3 <= 2) {
                return true;
            }
        }
        return false;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Bundle extras;
        if (intent == null || !"com.tencent.process.exit".equals(intent.getAction()) || (extras = intent.getExtras()) == null || d(extras)) {
            return;
        }
        ArrayList<String> stringArrayList = extras.getStringArrayList("procNameList");
        if (e(extras.getString("verify"), stringArrayList) && c(context, stringArrayList)) {
            f(context);
            f41711b = false;
            MobileQQ mobileQQ = MobileQQ.sMobileQQ;
            if (mobileQQ != null) {
                mobileQQ.otherProcessExit(false);
            } else {
                SystemMethodProxy.killProcess(Process.myPid());
            }
        }
    }
}
