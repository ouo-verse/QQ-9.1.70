package com.tencent.mobileqq.nearby.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.intervideo.groupvideo.IVPluginDataReporter;
import com.tencent.mobileqq.intervideo.groupvideo.plugininterface.IVPluginReportInterface;
import com.tencent.mobileqq.intervideo.huayang.IHuayangDowanloadHelper;
import com.tencent.mobileqq.intervideo.huayang.Monitor;
import com.tencent.mobileqq.intervideo.huayang.b;
import com.tencent.mobileqq.nearby.api.IFactoryApi;
import com.tencent.mobileqq.nearby.api.INearbyAppInterface;
import com.tencent.mobileqq.nearby.h;
import com.tencent.mobileqq.nearby.ipc.NearbyProcManager;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes33.dex */
public class FactoryApiImpl implements IFactoryApi {
    @Override // com.tencent.mobileqq.nearby.api.IFactoryApi
    public IHuayangDowanloadHelper getHuaYangDownLoadHelper(AppInterface appInterface, String str, String str2) {
        return b.a(((QQAppInterface) appInterface).getApp(), str, str2);
    }

    @Override // com.tencent.mobileqq.nearby.api.IFactoryApi
    public IVPluginReportInterface getIVPluginReportInterface() {
        return new IVPluginDataReporter();
    }

    @Override // com.tencent.mobileqq.nearby.api.IFactoryApi
    public INearbyAppInterface getNearbyAppInterface(MobileQQ mobileQQ, String str) {
        return new NearbyAppInterfaceImpl((BaseApplicationImpl) mobileQQ, str);
    }

    @Override // com.tencent.mobileqq.nearby.api.IFactoryApi
    public com.tencent.mobileqq.nearby.ipc.b getNearbyProcManager(AppInterface appInterface) {
        return new NearbyProcManager(appInterface);
    }

    @Override // com.tencent.mobileqq.nearby.api.IFactoryApi
    public com.tencent.mobileqq.nearby.api.a getNearbyProxy(Object obj) {
        return h.b((QQAppInterface) obj);
    }

    @Override // com.tencent.mobileqq.nearby.api.IFactoryApi
    public void monitorReport(String str) {
        Monitor.b(str);
    }

    @Override // com.tencent.mobileqq.nearby.api.IFactoryApi
    public void monitorTrigger(String str) {
        Monitor.d(str);
    }
}
