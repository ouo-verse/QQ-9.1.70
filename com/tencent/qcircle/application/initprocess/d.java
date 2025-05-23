package com.tencent.qcircle.application.initprocess;

import com.tencent.biz.qqcircle.broadcast.QFSGlobalBroadcastHelper;
import com.tencent.biz.qqcircle.immersive.utils.j;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.utils.ch;
import com.tencent.mobileqq.auto.engine.lib.ASInject;
import com.tencent.qcircle.application.QCircleApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.helpers.QFSDynamicResourceManager;
import cooperation.qqcircle.proxy.QCircleInvokeProxy;

/* compiled from: P */
/* loaded from: classes22.dex */
public class d extends b {
    private void b() {
        QCircleInvokeProxy.bindStub(new com.tencent.biz.qqcircle.entrance.b());
    }

    private void c() {
        QFSGlobalBroadcastHelper.c().d();
    }

    private void d() {
        QCircleSkinHelper.getInstance().init(QCircleApplication.APP);
        QFSDynamicResourceManager.g().init(QCircleSkinHelper.getInstance().getQCircleSkinFactory2(), ya0.a.a(), ch.f92746a);
    }

    @Override // com.tencent.qcircle.application.initprocess.b, com.tencent.qcircle.application.initprocess.a
    public void process() {
        super.process();
        QLog.d("QCircleInitStartProcess", 1, "process begin");
        b();
        c();
        d();
        j.f90213a.D();
        QCircleToast.e(ASInject.g().getToastDelegate());
        QLog.d("QCircleInitStartProcess", 1, "process end");
    }
}
