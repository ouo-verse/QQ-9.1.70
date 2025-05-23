package com.tencent.mobileqq.nearby.api.impl;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.nearby.api.INearbyManagerHelper;
import com.tencent.mobileqq.nearby.b;

/* compiled from: P */
/* loaded from: classes33.dex */
public class NearbyManagerHelperImpl implements INearbyManagerHelper {
    @Override // com.tencent.mobileqq.nearby.api.INearbyManagerHelper
    public b getNearbyCardManager(Object obj) {
        return (b) ((QQAppInterface) obj).getManager(QQManagerFactory.NEARBY_CARD_MANAGER);
    }

    @Override // com.tencent.mobileqq.nearby.api.INearbyManagerHelper
    public com.tencent.mobileqq.nearby.a getNearbyGeneralManager(Object obj) {
        return (com.tencent.mobileqq.nearby.a) ((QQAppInterface) obj).getManager(QQManagerFactory.NEARBY_GENERAL_MANAGER);
    }

    @Override // com.tencent.mobileqq.nearby.api.INearbyManagerHelper
    public com.tencent.mobileqq.nearby.api.a getNearbyProxy(Object obj) {
        return (com.tencent.mobileqq.nearby.api.a) ((QQAppInterface) obj).getManager(QQManagerFactory.NEARBY_PROXY_MANAGER);
    }
}
