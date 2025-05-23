package com.tencent.mobileqq.config;

import com.tencent.mobileqq.nearby.api.INearbyAppInterface;
import mqq.manager.Manager;

/* compiled from: P */
/* loaded from: classes10.dex */
public class af implements Manager {

    /* renamed from: d, reason: collision with root package name */
    private INearbyAppInterface f202260d;

    /* renamed from: e, reason: collision with root package name */
    private int f202261e = 0;

    public af(INearbyAppInterface iNearbyAppInterface) {
        this.f202260d = iNearbyAppInterface;
    }

    public void a() {
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
    }
}
