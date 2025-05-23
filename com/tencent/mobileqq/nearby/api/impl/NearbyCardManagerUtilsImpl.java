package com.tencent.mobileqq.nearby.api.impl;

import com.tencent.mobileqq.nearby.NearbyCardManager;
import com.tencent.mobileqq.nearby.api.INearbyCardManagerUtils;

/* compiled from: P */
/* loaded from: classes33.dex */
public class NearbyCardManagerUtilsImpl implements INearbyCardManagerUtils {
    @Override // com.tencent.mobileqq.nearby.api.INearbyCardManagerUtils
    public boolean isTinyId(String str) {
        return NearbyCardManager.q(str);
    }

    @Override // com.tencent.mobileqq.nearby.api.INearbyCardManagerUtils
    public void updateNearbyPeopleCard(Object obj, String str, Object obj2, Object obj3) {
        NearbyCardManager.v(obj, str, obj2, obj3);
    }
}
