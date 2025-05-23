package com.tencent.qcircle.application.initprocess;

import android.text.TextUtils;
import com.tencent.biz.qqcircle.events.QCirclePreInflateEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.utils.abtest.ABTestController;
import com.tencent.mobileqq.utils.abtest.ExpEntityInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.utils.QCircleHostStubUtil;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes22.dex */
public class f extends b {

    /* renamed from: e, reason: collision with root package name */
    private static String f342431e = "enableDelayPreload";

    /* renamed from: f, reason: collision with root package name */
    private static String f342432f = "delayPreloadDuration";

    /* renamed from: g, reason: collision with root package name */
    public static volatile f f342433g;

    /* renamed from: b, reason: collision with root package name */
    private long f342435b;

    /* renamed from: c, reason: collision with root package name */
    private String f342436c;

    /* renamed from: a, reason: collision with root package name */
    private boolean f342434a = false;

    /* renamed from: d, reason: collision with root package name */
    private boolean f342437d = false;

    public static f d() {
        if (f342433g == null) {
            synchronized (f.class) {
                if (f342433g == null) {
                    f fVar = new f();
                    fVar.e();
                    f342433g = fVar;
                }
            }
        }
        return f342433g;
    }

    private void e() {
        this.f342436c = QCircleHostStubUtil.getCurrentAccount();
        f();
        QLog.d("QCirclePreloadProcess", 1, "init,enablePreload:", Boolean.valueOf(this.f342434a), ",duration:", Long.valueOf(this.f342435b));
    }

    private void f() {
        ExpEntityInfo expEntity = ABTestController.getInstance().getExpEntity("exp_xsj_qcircle_delay_preload_1505");
        expEntity.reportExpExposure();
        Map<String, String> tabParams = expEntity.getTabParams();
        if (tabParams != null && tabParams.containsKey(f342431e)) {
            try {
                this.f342434a = Boolean.parseBoolean(tabParams.get(f342431e));
                this.f342435b = Integer.parseInt(tabParams.get(f342432f)) * 1000;
                return;
            } catch (Exception e16) {
                this.f342434a = false;
                QLog.e("QCirclePreloadProcess", 1, "initDelayPreloadExp error:", e16);
                return;
            }
        }
        this.f342434a = false;
        this.f342435b = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        SimpleEventBus.getInstance().dispatchEvent(new QCirclePreInflateEvent());
    }

    private void h() {
        if (!TextUtils.isEmpty(this.f342436c) && this.f342436c.equals(QCircleHostStubUtil.getCurrentAccount())) {
            QLog.d("QCirclePreloadProcess", 1, "same user,don't reset");
        } else {
            QLog.d("QCirclePreloadProcess", 1, "reset");
            this.f342434a = false;
        }
    }

    public static void i() {
        if (f342433g != null) {
            f342433g.h();
        }
    }

    public boolean c() {
        if (this.f342434a && !this.f342437d) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.qcircle.application.initprocess.b, com.tencent.qcircle.application.initprocess.a
    public void process() {
        QLog.d("QCirclePreloadProcess", 1, "QCirclePreloadProcess real start");
        if (this.f342434a) {
            RFWThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.qcircle.application.initprocess.e
                @Override // java.lang.Runnable
                public final void run() {
                    f.this.g();
                }
            }, this.f342435b);
        }
        this.f342437d = true;
    }
}
