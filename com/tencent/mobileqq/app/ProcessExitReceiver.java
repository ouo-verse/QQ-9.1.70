package com.tencent.mobileqq.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import android.text.format.Time;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.MobileQQ;

/* loaded from: classes11.dex */
public class ProcessExitReceiver extends BroadcastReceiver {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    protected AppInterface f194950a;

    protected String a(ArrayList<String> arrayList, boolean z16) {
        String obj;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, this, arrayList, Boolean.valueOf(z16));
        }
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

    protected boolean b(ArrayList<String> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) arrayList)).booleanValue();
        }
        if (arrayList == null || arrayList.size() == 0) {
            return true;
        }
        String qQProcessName = MobileQQ.getMobileQQ().getQQProcessName();
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            if (qQProcessName.equals(it.next())) {
                return true;
            }
        }
        return false;
    }

    protected boolean c(String str, ArrayList<String> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) arrayList)).booleanValue();
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (!str.equals(a(arrayList, false)) && !str.equals(a(arrayList, true))) {
            return false;
        }
        return true;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
            return;
        }
        String action = intent.getAction();
        if (action == null) {
            return;
        }
        if (action.equals("com.tencent.process.exit")) {
            Bundle extras = intent.getExtras();
            if (extras == null) {
                return;
            }
            ArrayList<String> stringArrayList = extras.getStringArrayList("procNameList");
            if (c(extras.getString("verify"), stringArrayList) && b(stringArrayList)) {
                ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.app.ProcessExitReceiver.1
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ProcessExitReceiver.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d("ProcessExitReceiver", 2, "Kill process " + MobileQQ.getMobileQQ().getQQProcessName());
                        }
                        SystemMethodProxy.killProcess(Process.myPid());
                    }
                }, 8, null, true);
                return;
            }
            return;
        }
        this.f194950a.getApplication().otherProcessExit(true);
    }
}
