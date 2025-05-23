package com.tencent.av.app;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Process;
import android.text.TextUtils;
import android.text.format.Time;
import com.tencent.av.utils.DataReport;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.Foreground;

/* loaded from: classes3.dex */
public class GKillProcessMonitor {

    /* renamed from: a, reason: collision with root package name */
    private VideoAppInterface f72975a;

    /* renamed from: b, reason: collision with root package name */
    private BroadcastReceiver f72976b = new ExitBroadcastReceiver();

    /* renamed from: c, reason: collision with root package name */
    private boolean f72977c = false;

    /* loaded from: classes3.dex */
    class ExitBroadcastReceiver extends BroadcastReceiver {
        ExitBroadcastReceiver() {
        }

        private boolean b(com.tencent.av.r rVar) {
            if (rVar == null) {
                return true;
            }
            long currentTimeMillis = System.currentTimeMillis() - rVar.w0();
            QLog.d("GKillProcessMonitor", 1, "[videoKeepLive] qqExitBroadcastReceiver elapseTime:= " + currentTimeMillis);
            if (com.tencent.av.n.e().f().D() && currentTimeMillis > 10000) {
                return true;
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(Intent intent) {
            ArrayList<String> stringArrayList = intent.getExtras().getStringArrayList("procNameList");
            if (GKillProcessMonitor.this.f(intent.getExtras().getString("verify"), stringArrayList) && GKillProcessMonitor.this.e(stringArrayList)) {
                if (b(com.tencent.av.r.h0())) {
                    if (com.tencent.av.r.h0() != null) {
                        com.tencent.av.r.h0().r1();
                    }
                    QLog.d("GKillProcessMonitor", 1, "qqExitBroadcastReceiver");
                    SystemMethodProxy.killProcess(Process.myPid());
                    return;
                }
                if (com.tencent.av.n.e().f().D()) {
                    DataReport.T(null, "dc00898", "", com.tencent.av.n.e().f().f73091w, "0X800C57F", "0X800C57F", com.tencent.av.n.e().f().f73035i, 0, "", "", "", "");
                }
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, final Intent intent) {
            if (intent != null && "com.tencent.process.exit".equals(intent.getAction())) {
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.av.app.GKillProcessMonitor.ExitBroadcastReceiver.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ExitBroadcastReceiver.this.c(intent);
                    }
                }, 16, null, true);
            }
        }
    }

    public GKillProcessMonitor(VideoAppInterface videoAppInterface) {
        this.f72975a = videoAppInterface;
    }

    private String c(Context context) {
        try {
            int myPid = Process.myPid();
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : SystemMethodProxy.getRunningAppProcesses((ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY))) {
                if (runningAppProcessInfo.pid == myPid) {
                    return runningAppProcessInfo.processName;
                }
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    private String d(ArrayList<String> arrayList, boolean z16) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            return true;
        }
        String c16 = c(this.f72975a.getApplication());
        if (TextUtils.isEmpty(c16)) {
            return false;
        }
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            if (c16.equals(arrayList.get(i3))) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean f(String str, ArrayList<String> arrayList) {
        if (Foreground.getActivityCount() > 0 || str == null || str.length() == 0) {
            return false;
        }
        if (!str.equals(d(arrayList, false)) && !str.equals(d(arrayList, true))) {
            return false;
        }
        return true;
    }

    public void g() {
        if (QLog.isColorLevel()) {
            QLog.d("GKillProcessMonitor", 2, "regist QQ Process Exit Receiver");
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.tencent.process.exit");
        if (this.f72975a.getApplication().registerReceiver(this.f72976b, intentFilter) != null) {
            this.f72977c = true;
        }
    }

    public void h() {
        if (this.f72977c) {
            this.f72975a.getApplication().unregisterReceiver(this.f72976b);
            this.f72977c = false;
        }
    }
}
