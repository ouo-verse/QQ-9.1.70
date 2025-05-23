package com.tencent.mobileqq.troop.widget;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.ecommerce.base.runtime.api.IECScreenReceiver;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.minigame.utils.GameActivityStatusWatcher;

/* compiled from: P */
@Deprecated
/* loaded from: classes19.dex */
public class TroopUsageTimeReport extends BroadcastReceiver {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public boolean f302471a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f302472b;

    /* renamed from: c, reason: collision with root package name */
    private String f302473c;

    /* renamed from: d, reason: collision with root package name */
    private long f302474d;

    /* renamed from: e, reason: collision with root package name */
    private long f302475e;

    /* renamed from: f, reason: collision with root package name */
    private long f302476f;

    /* renamed from: g, reason: collision with root package name */
    private long f302477g;

    /* renamed from: h, reason: collision with root package name */
    private QQAppInterface f302478h;

    /* renamed from: i, reason: collision with root package name */
    private IntentFilter f302479i;

    /* renamed from: j, reason: collision with root package name */
    private SessionInfo f302480j;

    /* renamed from: k, reason: collision with root package name */
    private volatile boolean f302481k;

    TroopUsageTimeReport() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f302471a = false;
        this.f302472b = false;
        this.f302481k = false;
        IntentFilter intentFilter = new IntentFilter();
        this.f302479i = intentFilter;
        intentFilter.addAction(IECScreenReceiver.ACTION_SCREEN_OFF);
        this.f302479i.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
        this.f302479i.addAction("android.intent.action.ACTION_SHUTDOWN");
        this.f302479i.addAction("android.intent.action.QUICKBOOT_POWEROFF");
    }

    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (this.f302471a) {
            long currentTimeMillis = System.currentTimeMillis();
            this.f302475e = currentTimeMillis;
            long j3 = (currentTimeMillis - this.f302474d) / 1000;
            int i3 = (int) j3;
            if (i3 <= 0) {
                i3 = 1;
            }
            int i16 = i3;
            SessionInfo sessionInfo = this.f302480j;
            if (sessionInfo != null) {
                ReportController.n(this.f302478h, "P_CliOper", "Grp_AIO", "", "time", "aio_time", 0, i16, 0, sessionInfo.f179557e, "", "", "");
                if (QLog.isColorLevel()) {
                    QLog.d("TroopUsageTimeReport-->AioUseTime", 2, "uin=" + this.f302473c + ",mTroopUin=" + sessionInfo.f179557e + ",time=" + j3 + ReportConstant.COSTREPORT_PREFIX);
                }
            }
            this.f302471a = false;
        }
    }

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        if (this.f302472b) {
            long currentTimeMillis = System.currentTimeMillis();
            this.f302477g = currentTimeMillis;
            long j3 = (currentTimeMillis - this.f302476f) / 1000;
            int i3 = (int) j3;
            if (i3 <= 0) {
                i3 = 1;
            }
            int i16 = i3;
            SessionInfo sessionInfo = this.f302480j;
            if (sessionInfo != null) {
                ReportController.n(this.f302478h, "P_CliOper", "Grp_AIO", "", "time", "grp_time", 0, i16, 0, sessionInfo.f179557e, "", "", "");
                if (QLog.isColorLevel()) {
                    QLog.d("TroopUsageTimeReport-->TroopUseTime", 2, "uin=" + this.f302473c + ",mTroopUin=" + sessionInfo.f179557e + ",time=" + j3 + ReportConstant.COSTREPORT_PREFIX);
                }
            }
            this.f302472b = false;
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String stringExtra;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) context, (Object) intent);
            return;
        }
        String action = intent.getAction();
        if (!IECScreenReceiver.ACTION_SCREEN_OFF.equals(action) && !"android.intent.action.ACTION_SHUTDOWN".equals(action) && !"android.intent.action.QUICKBOOT_POWEROFF".equals(action)) {
            if ("android.intent.action.CLOSE_SYSTEM_DIALOGS".equals(action) && (stringExtra = intent.getStringExtra("reason")) != null && stringExtra.equals(GameActivityStatusWatcher.InnerRecevier.SYSTEM_DIALOG_REASON_HOME_KEY)) {
                b();
                return;
            }
            return;
        }
        a();
        b();
    }
}
