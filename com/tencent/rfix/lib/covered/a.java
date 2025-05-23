package com.tencent.rfix.lib.covered;

import android.content.Context;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.rfix.loader.log.RFixLog;
import com.tencent.rfix.loader.storage.AbsStorableInfo;
import java.util.Calendar;
import java.util.Date;

/* compiled from: P */
/* loaded from: classes25.dex */
public class a extends AbsStorableInfo {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private int f364949a;

    /* renamed from: b, reason: collision with root package name */
    private int f364950b;

    /* renamed from: c, reason: collision with root package name */
    private int f364951c;

    /* renamed from: d, reason: collision with root package name */
    private long f364952d;

    /* renamed from: e, reason: collision with root package name */
    private long f364953e;

    /* renamed from: f, reason: collision with root package name */
    private long f364954f;

    public a(Context context) {
        super(context, "task_covered_record");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        }
    }

    private boolean d(long j3) {
        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(new Date(j3));
        if (calendar2.get(1) == calendar.get(1) && calendar2.get(6) == calendar.get(6)) {
            return true;
        }
        return false;
    }

    public int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        if (d(this.f364953e)) {
            return this.f364950b;
        }
        return 0;
    }

    public int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        if (d(this.f364954f)) {
            return this.f364951c;
        }
        return 0;
    }

    public int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        if (d(this.f364952d)) {
            return this.f364949a;
        }
        return 0;
    }

    public void e(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3);
        } else {
            this.f364949a = i3;
            this.f364952d = System.currentTimeMillis();
        }
    }

    public void f(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
        } else {
            this.f364950b = i3;
            this.f364953e = System.currentTimeMillis();
        }
    }

    public void g(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
        } else {
            this.f364951c = i3;
            this.f364954f = System.currentTimeMillis();
        }
    }

    @Override // com.tencent.rfix.loader.storage.AbsStorableInfo
    public void loadStoreInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        super.loadStoreInfo();
        this.f364949a = this.storage.getInt("config_last_report_version", 0);
        this.f364950b = this.storage.getInt("install_last_report_version", 0);
        this.f364951c = this.storage.getInt("load_last_report_version", 0);
        this.f364952d = this.storage.getLong("config_last_report_time", 0L);
        this.f364953e = this.storage.getLong("install_last_report_time", 0L);
        this.f364954f = this.storage.getLong("load_last_report_time", 0L);
        RFixLog.i("RFix.TaskCoveredRecord", "loadStoreInfo " + this);
    }

    @Override // com.tencent.rfix.loader.storage.AbsStorableInfo
    public void saveStoreInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        this.storage.putInt("config_last_report_version", this.f364949a);
        this.storage.putInt("install_last_report_version", this.f364950b);
        this.storage.putInt("load_last_report_version", this.f364951c);
        this.storage.putLong("config_last_report_time", this.f364952d);
        this.storage.putLong("install_last_report_time", this.f364953e);
        this.storage.putLong("load_last_report_time", this.f364954f);
        super.saveStoreInfo();
        RFixLog.i("RFix.TaskCoveredRecord", "saveStoreInfo " + this);
    }

    @NonNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return "TaskCoveredRecord{lastReportConfigVersion=" + this.f364949a + ", lastReportInstallVersion=" + this.f364950b + ", lastReportLoadVersion=" + this.f364951c + ", lastReportConfigTime=" + this.f364952d + ", lastReportInstallTime=" + this.f364953e + ", lastReportLoadTime=" + this.f364954f + '}';
    }
}
