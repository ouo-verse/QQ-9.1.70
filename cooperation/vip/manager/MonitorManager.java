package cooperation.vip.manager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.pb.mobile_monitor_report;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes28.dex */
public class MonitorManager extends BroadcastReceiver {

    /* renamed from: e, reason: collision with root package name */
    private static MonitorManager f391267e;

    /* renamed from: a, reason: collision with root package name */
    private long f391268a;

    /* renamed from: b, reason: collision with root package name */
    private int f391269b;

    /* renamed from: c, reason: collision with root package name */
    private long f391270c;

    /* renamed from: d, reason: collision with root package name */
    private List<mobile_monitor_report.ExceptionReport> f391271d = new ArrayList();

    MonitorManager() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(GuardManager.ACTION_PLUGIN_STATE_CHANGE);
        BaseApplicationImpl.getApplication().registerReceiver(this, intentFilter);
        SharedPreferences sharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("monitor_manager", 4);
        this.f391269b = sharedPreferences.getInt("max_size_out", 20);
        this.f391270c = sharedPreferences.getLong("max_time_out", 30L) * 60 * 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i3, int i16, String str, boolean z16) {
        mobile_monitor_report.ExceptionReport exceptionReport = new mobile_monitor_report.ExceptionReport();
        exceptionReport.busi_id.set(i3);
        exceptionReport.errcode.set(i16);
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        exceptionReport.f391308msg.set(str);
        synchronized (this.f391271d) {
            this.f391271d.add(exceptionReport);
        }
        g(z16);
    }

    private boolean e(boolean z16) {
        boolean z17;
        boolean z18;
        if (z16) {
            return true;
        }
        if (this.f391271d.size() > this.f391269b) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (System.currentTimeMillis() - this.f391268a > this.f391270c) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (z17 || z18) {
            return true;
        }
        return false;
    }

    public static MonitorManager f() {
        if (f391267e == null) {
            synchronized (MonitorManager.class) {
                if (f391267e == null) {
                    f391267e = new MonitorManager();
                }
            }
        }
        return f391267e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(boolean z16) {
        if (e(z16)) {
            this.f391268a = System.currentTimeMillis();
            k();
        }
    }

    private void i() {
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: cooperation.vip.manager.MonitorManager.2
            @Override // java.lang.Runnable
            public void run() {
                MonitorManager.this.g(true);
            }
        });
    }

    private void k() {
        if (this.f391271d.size() <= 0) {
            return;
        }
        ArrayList arrayList = new ArrayList(this.f391271d);
        synchronized (this.f391271d) {
            this.f391271d.clear();
        }
        f.e(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(int i3, int i16, String str, String str2) {
        mobile_monitor_report.TraceReport traceReport = new mobile_monitor_report.TraceReport();
        traceReport.trace_id.set(String.valueOf(i3));
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        traceReport.f391309msg.set(str2);
        traceReport.trace_num.set(i16);
        traceReport.page_id.set(str);
        ArrayList arrayList = new ArrayList();
        arrayList.add(traceReport);
        f.f(arrayList);
    }

    public void h(final int i3, final int i16, final String str, final boolean z16) {
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: cooperation.vip.manager.MonitorManager.1
            @Override // java.lang.Runnable
            public void run() {
                MonitorManager.this.d(i3, i16, str, z16);
            }
        });
    }

    public void j(final int i3, final int i16, final String str, final String str2) {
        if (QLog.isColorLevel()) {
            QLog.e("MonitorManager", 1, "report trace " + i3, " trace Num " + i16 + " page desc " + str + " trace Msg " + str2);
        }
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: cooperation.vip.manager.MonitorManager.3
            @Override // java.lang.Runnable
            public void run() {
                MonitorManager.this.l(i3, i16, str, str2);
            }
        });
    }

    public void m(int i3, int i16) {
        if (i3 > 0 && i16 > 0) {
            this.f391270c = i16 * 60 * 60;
            SharedPreferences.Editor edit = BaseApplicationImpl.getApplication().getSharedPreferences("monitor_manager", 4).edit();
            edit.putInt("max_size_out", i3);
            edit.putInt("max_time_out", i16);
            edit.apply();
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (!TextUtils.isEmpty(action) && GuardManager.ACTION_PLUGIN_STATE_CHANGE.equals(action) && intent.getIntExtra(GuardManager.KEY_PLUGIN_STATE, 0) == 0) {
            QLog.i("MonitorManager", 1, "[onReceive] bg action");
            i();
        }
    }
}
