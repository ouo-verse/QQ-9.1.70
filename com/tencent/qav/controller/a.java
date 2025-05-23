package com.tencent.qav.controller;

import android.content.Context;
import com.tencent.av.video.call.ClientLogReport;
import com.tencent.av.video.call.GAClientLogReport;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qav.channel.d;
import com.tencent.qav.controller.multi.MultiOperatorImpl;
import com.tencent.qav.monitor.CallingStateMonitor;
import pu.c;

/* compiled from: P */
/* loaded from: classes22.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private Context f342367a;

    /* renamed from: b, reason: collision with root package name */
    private MultiOperatorImpl f342368b;

    public a(Context context, MultiOperatorImpl multiOperatorImpl) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) multiOperatorImpl);
            return;
        }
        this.f342367a = context;
        CallingStateMonitor.k().p(this.f342367a, d());
        this.f342368b = multiOperatorImpl;
        ClientLogReport.instance();
        GAClientLogReport.instance();
    }

    public static int b() {
        int i3;
        if (AppNetConnInfo.isWifiConn()) {
            i3 = 1;
        } else if (AppNetConnInfo.isMobileConn()) {
            int mobileInfo = AppNetConnInfo.getMobileInfo();
            i3 = 3;
            if (mobileInfo != 1) {
                if (mobileInfo != 2) {
                    if (mobileInfo != 3) {
                        if (mobileInfo != 4) {
                            i3 = 100;
                        } else {
                            i3 = 14;
                        }
                    } else {
                        i3 = 11;
                    }
                } else {
                    i3 = 9;
                }
            }
        } else {
            i3 = 0;
        }
        com.tencent.qav.log.a.a("QavCtrl", String.format("getApn networkType=%s", Integer.valueOf(i3)));
        return i3;
    }

    public static void e(d dVar) {
        if (dVar != null) {
            dVar.sendGetGatewayMsg();
        }
    }

    public static void f(d dVar, Context context, long j3) {
        if (dVar != null) {
            dVar.sendGetVideoConfig(c.g(j3, String.valueOf(AppSetting.f()), context));
        }
    }

    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        MultiOperatorImpl multiOperatorImpl = this.f342368b;
        if (multiOperatorImpl != null) {
            multiOperatorImpl.l();
            this.f342368b = null;
        }
        this.f342367a = null;
        CallingStateMonitor.k().j();
    }

    public com.tencent.qav.controller.multi.a c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.qav.controller.multi.a) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f342368b;
    }

    protected boolean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return true;
    }
}
