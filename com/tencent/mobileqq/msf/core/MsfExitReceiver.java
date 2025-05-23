package com.tencent.mobileqq.msf.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.text.format.Time;
import com.tencent.mobileqq.msf.core.net.utils.MsfPullConfigUtil;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes15.dex */
public class MsfExitReceiver extends BroadcastReceiver {
    static IPatchRedirector $redirector_ = null;
    private static final String tag = "MsfExitReceiver";

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ MsfExitReceiver f247304a;

        a(MsfExitReceiver msfExitReceiver) {
            this.f247304a = msfExitReceiver;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MsfExitReceiver.this, (Object) msfExitReceiver);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                BaseApplication.getContext().registerReceiver(this.f247304a, new IntentFilter("com.tencent.process.exit"));
            }
        }
    }

    public MsfExitReceiver() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            q.s().post(new a(this));
        }
    }

    public static String getLocalVerify(String str, boolean z16) {
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
        if (str == null) {
            str = "null";
        }
        sb5.append(str);
        return MD5.toMD5(MD5.toMD5(sb5.toString()) + sb5.toString());
    }

    private static boolean isLegalBroadcast(String str, String str2) {
        if (str == null || str.length() == 0) {
            return false;
        }
        if (!str.equals(getLocalVerify(str2, false)) && !str.equals(getLocalVerify(str2, true))) {
            return false;
        }
        return true;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String string;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
            return;
        }
        if ("com.tencent.process.exit".equals(intent.getAction()) && (string = intent.getExtras().getString("procName")) != null && string.equals(BaseApplication.processName) && isLegalBroadcast(intent.getExtras().getString("verify"), string)) {
            if (QLog.isColorLevel()) {
                QLog.d(tag, 2, "recv kill msf broadcast from QQ, sRecvRegister=" + MsfPullConfigUtil.sRecvRegister + ", sRecvProxy=" + MsfPullConfigUtil.sRecvProxy);
            }
            SharedPreferences sharedPreferences = MsfService.getCore().getSharedPreferences("crashcontrol", 4);
            sharedPreferences.edit().putInt("countRecvKillMsf", sharedPreferences.getInt("countRecvKillMsf", 0) + 1).commit();
            if (MsfPullConfigUtil.sRecvRegister || MsfPullConfigUtil.sRecvProxy) {
                sharedPreferences.edit().putInt("countMsfRealExit", sharedPreferences.getInt("countMsfRealExit", 0) + 1).commit();
                System.exit(0);
            }
        }
    }
}
