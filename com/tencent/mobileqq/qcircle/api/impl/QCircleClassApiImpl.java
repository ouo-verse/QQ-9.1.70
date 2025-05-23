package com.tencent.mobileqq.qcircle.api.impl;

import com.tencent.biz.qcircleshadow.handler.QCircleHandler;
import com.tencent.biz.richframework.delegate.IReportDelegate;
import com.tencent.biz.richframework.delegate.impl.RFWDelegate;
import com.tencent.biz.richframework.network.MobileQQVSNetworkImpl;
import com.tencent.biz.richframework.network.delegate.VSBaseNetwork;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.perf.tracker.SceneTracker;
import com.tencent.mobileqq.qcircle.api.IQCircleClassApi;
import com.tencent.mobileqq.qcircle.api.requests.QQCircleGetGroupCountRequest;
import cooperation.qqcircle.scene.QFSSceneChangeProxy;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QCircleClassApiImpl implements IQCircleClassApi {
    @Override // com.tencent.mobileqq.qcircle.api.IQCircleClassApi
    public Class getQCircleHandlerClass() {
        return QCircleHandler.class;
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleClassApi
    public BaseRequest getQQCircleGetGroupCountRequest(long j3) {
        return new QQCircleGetGroupCountRequest(j3);
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleClassApi
    public void initDelegate() {
        RFWDelegate.registerDelegate(IReportDelegate.class, e20.b.class);
        RFWDelegate.registerDelegate(VSBaseNetwork.class, MobileQQVSNetworkImpl.class);
        SceneTracker.f258213d.l(new QFSSceneChangeProxy());
    }
}
