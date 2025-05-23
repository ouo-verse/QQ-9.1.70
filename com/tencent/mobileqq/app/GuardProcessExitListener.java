package com.tencent.mobileqq.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import android.text.format.Time;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.Foreground;

/* loaded from: classes11.dex */
public abstract class GuardProcessExitListener extends BroadcastReceiver {
    static IPatchRedirector $redirector_;

    public GuardProcessExitListener() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private String c(ArrayList<String> arrayList, boolean z16) {
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

    private boolean d(ArrayList<String> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            return arrayList.contains(b());
        }
        return true;
    }

    private boolean e(String str, ArrayList<String> arrayList) {
        if (Foreground.getActivityCount() > 0 || str == null || str.length() == 0) {
            return false;
        }
        if (!str.equals(c(arrayList, false)) && !str.equals(c(arrayList, true))) {
            return false;
        }
        return true;
    }

    public void a(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
        } else {
            SystemMethodProxy.killProcess(Process.myPid());
        }
    }

    protected String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return com.tencent.biz.troop.b.y();
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Bundle extras;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
            return;
        }
        String action = intent.getAction();
        if (action != null && "com.tencent.process.exit".equals(action) && (extras = intent.getExtras()) != null) {
            ArrayList<String> stringArrayList = extras.getStringArrayList("procNameList");
            if (e(intent.getExtras().getString("verify"), stringArrayList) && d(stringArrayList)) {
                if (QLog.isColorLevel()) {
                    QLog.e("GuardProcessExitListener", 2, "***exitProcexx*** receive broacast action=" + intent.getAction());
                }
                a(true);
            }
        }
    }
}
