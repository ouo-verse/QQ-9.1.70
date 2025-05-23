package com.tencent.mobileqq.ptt.preop;

import android.content.SharedPreferences;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes16.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    int[] f261284a;

    /* renamed from: b, reason: collision with root package name */
    int[] f261285b;

    /* renamed from: c, reason: collision with root package name */
    long f261286c;

    /* renamed from: d, reason: collision with root package name */
    long f261287d;

    /* renamed from: e, reason: collision with root package name */
    AppRuntime f261288e;

    public c(AppRuntime appRuntime, int i3, int i16, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, appRuntime, Integer.valueOf(i3), Integer.valueOf(i16), Long.valueOf(j3));
            return;
        }
        this.f261284a = new int[2];
        this.f261285b = r0;
        int[] iArr = {i3, i16};
        this.f261287d = j3;
        this.f261288e = appRuntime;
        a();
    }

    private void a() {
        SharedPreferences sharedPreferences = BaseApplication.getContext().getSharedPreferences("PttPreSendSp_" + this.f261288e.getCurrentUin(), 0);
        this.f261284a[0] = sharedPreferences.getInt("avaliableflowxg", this.f261285b[0]);
        this.f261284a[1] = sharedPreferences.getInt("avaliableflowifi", this.f261285b[1]);
        this.f261286c = sharedPreferences.getLong("lastdaymillion", 0L);
        if (QLog.isDevelopLevel()) {
            QLog.d("PttPreFlowController", 4, "PttPreFlowController.loadCfg, lastDayMillion " + this.f261286c);
        }
    }

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        BaseApplication.getContext().getSharedPreferences("PttPreSendSp_" + this.f261288e.getCurrentUin(), 0).edit().putInt("avaliableflowxg", this.f261284a[0]).putInt("avaliableflowifi", this.f261284a[1]).commit();
    }
}
