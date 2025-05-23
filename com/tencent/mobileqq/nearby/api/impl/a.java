package com.tencent.mobileqq.nearby.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.f;
import com.tencent.mobileqq.nearby.api.INearbyAppInterface;
import com.tencent.mobileqq.nearby.api.b;
import com.tencent.mobileqq.service.MobileQQServiceBase;
import com.tencent.mobileqq.service.lbs.c;
import java.util.Map;
import java.util.Random;
import mqq.app.MSFServlet;

/* compiled from: P */
/* loaded from: classes33.dex */
public class a extends MobileQQServiceBase implements b {

    /* renamed from: a, reason: collision with root package name */
    INearbyAppInterface f252545a;

    /* renamed from: b, reason: collision with root package name */
    Random f252546b;

    public a(INearbyAppInterface iNearbyAppInterface) {
        Random random = new Random();
        this.f252546b = random;
        this.f252545a = iNearbyAppInterface;
        MobileQQServiceBase.seq = Math.abs(random.nextInt());
    }

    @Override // com.tencent.mobileqq.service.MobileQQServiceBase
    public AppInterface getAppInterface() {
        return (AppInterface) this.f252545a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.service.MobileQQServiceBase
    public Map<String, String[]> getCompatibleCmd2HandlerMap() {
        return f.a();
    }

    @Override // com.tencent.mobileqq.service.MobileQQServiceBase
    protected Class<? extends MSFServlet> getServlet() {
        return com.tencent.mobileqq.nearby.api.f.class;
    }

    @Override // com.tencent.mobileqq.service.MobileQQServiceBase
    protected synchronized void initCoders() {
        super.addCoder(new c((AppInterface) this.f252545a));
        super.setCodersInit();
    }
}
