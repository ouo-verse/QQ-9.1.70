package com.tencent.mobileqq.kandian.biz.framework;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.utils.b;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadinjoySPEventReport;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes33.dex */
public class RIJAppSetting {

    /* renamed from: a, reason: collision with root package name */
    public static volatile boolean f239382a = false;

    /* renamed from: b, reason: collision with root package name */
    private static volatile boolean f239383b = true;

    public static void b(QQAppInterface qQAppInterface) {
        if (f239383b) {
            f239383b = false;
            c();
        }
        f239382a = true;
    }

    public static void c() {
        AppRuntime c16 = b.c();
        if (c16 instanceof QQAppInterface) {
            if (!((QQAppInterface) c16).mAutomator.isInRealActionLoginB()) {
                ReadinjoySPEventReport.o0(false);
            } else {
                ThreadManager.getSubThreadHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.kandian.biz.framework.RIJAppSetting.1
                    @Override // java.lang.Runnable
                    public void run() {
                        RIJAppSetting.c();
                    }
                }, 500L);
            }
        }
    }

    public static void a(QQAppInterface qQAppInterface) {
        f239382a = false;
    }
}
