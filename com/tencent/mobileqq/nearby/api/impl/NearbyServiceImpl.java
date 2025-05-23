package com.tencent.mobileqq.nearby.api.impl;

import com.tencent.mobileqq.app.NearbyHandler;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.intervideo.groupvideo.GroupVideoManager;
import com.tencent.mobileqq.intervideo.huayang.HuayangPluginLauncher;
import com.tencent.mobileqq.intervideo.huayang.impl.HuayangPluginNewDownloaderImpl;
import com.tencent.mobileqq.intervideo.now.dynamic.channelImpl.NowChannerHandlerV2;
import com.tencent.mobileqq.nearby.NearByGeneralManager;
import com.tencent.mobileqq.nearby.NearbyCardManager;
import com.tencent.mobileqq.nearby.NearbyReceiver;
import com.tencent.mobileqq.nearby.NearbyRelevantHandler;
import com.tencent.mobileqq.nearby.api.INearbyService;
import com.tencent.mobileqq.nearby.api.NearbyProxy;
import com.tencent.mobileqq.nearby.business.NearbyCardHandler;
import com.tencent.mobileqq.nearby.g;
import com.tencent.mobileqq.nearby.now.SmallVideoFragment;
import com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentManager;
import com.tencent.mobileqq.nearby.redtouch.LocalRedTouchManager;
import u92.d;

/* compiled from: P */
/* loaded from: classes33.dex */
public class NearbyServiceImpl implements INearbyService {
    @Override // com.tencent.mobileqq.nearby.api.INearbyService
    public Class getDynamicNowManagerClass() {
        return com.tencent.mobileqq.intervideo.now.dynamic.a.class;
    }

    @Override // com.tencent.mobileqq.nearby.api.INearbyService
    public Class getGroupVideoManagerClass() {
        return GroupVideoManager.class;
    }

    @Override // com.tencent.mobileqq.nearby.api.INearbyService
    public String getHuayangPluginLauncherClassName() {
        return HuayangPluginLauncher.class.getName();
    }

    @Override // com.tencent.mobileqq.nearby.api.INearbyService
    public String getHuayangPluginNewDownloaderClassName() {
        return HuayangPluginNewDownloaderImpl.class.getName();
    }

    @Override // com.tencent.mobileqq.nearby.api.INearbyService
    public Class getLocalRedTouchManagerClass() {
        return LocalRedTouchManager.class;
    }

    @Override // com.tencent.mobileqq.nearby.api.INearbyService
    public Class getMiniCardManagerClass() {
        return d.class;
    }

    @Override // com.tencent.mobileqq.nearby.api.INearbyService
    public String getNearbyCardHandlerClassName() {
        return NearbyCardHandler.f252547h;
    }

    @Override // com.tencent.mobileqq.nearby.api.INearbyService
    public Class getNearbyCardManagerClass() {
        return NearbyCardManager.class;
    }

    @Override // com.tencent.mobileqq.nearby.api.INearbyService
    public Class getNearbyGeneralManagerClass() {
        return NearByGeneralManager.class;
    }

    @Override // com.tencent.mobileqq.nearby.api.INearbyService
    public Class getNearbyHandlerClass() {
        return NearbyHandler.class;
    }

    @Override // com.tencent.mobileqq.nearby.api.INearbyService
    public Class getNearbyLikeLimitManagerClass() {
        return g.class;
    }

    @Override // com.tencent.mobileqq.nearby.api.INearbyService
    public Class getNearbyMomentManagerClass() {
        return NearbyMomentManager.class;
    }

    @Override // com.tencent.mobileqq.nearby.api.INearbyService
    public Class getNearbyProxyClass() {
        return NearbyProxy.class;
    }

    @Override // com.tencent.mobileqq.nearby.api.INearbyService
    public Class getNearbyReceiverClass() {
        return NearbyReceiver.class;
    }

    @Override // com.tencent.mobileqq.nearby.api.INearbyService
    public String getNearbyRelevantHandlerClassName() {
        return NearbyRelevantHandler.f252511f;
    }

    @Override // com.tencent.mobileqq.nearby.api.INearbyService
    public String getNowChannerHandlerV2ClassName() {
        return NowChannerHandlerV2.class.getName();
    }

    @Override // com.tencent.mobileqq.nearby.api.INearbyService
    public int getQQNearbyFactoryCountManager() {
        return QQManagerFactory.COUNT_MANAGER;
    }

    @Override // com.tencent.mobileqq.nearby.api.INearbyService
    public Class getSmallVideoFragmentClass() {
        return SmallVideoFragment.class;
    }
}
