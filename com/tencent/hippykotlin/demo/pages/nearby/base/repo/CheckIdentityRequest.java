package com.tencent.hippykotlin.demo.pages.nearby.base.repo;

import c45.i;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.UserDataManager;
import com.tencent.kuikly.core.log.KLog;
import p35.a;
import p35.b;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class CheckIdentityRequest implements IBizRequestByProxy<a, b> {
    public final int appId;

    public CheckIdentityRequest(int i3) {
        this.appId = i3;
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.base.repo.IBizRequestByProxy
    public final b decodeResponse(byte[] bArr) {
        try {
            return (b) i.b(new b(null, 0, null, 7, null), bArr);
        } catch (Throwable th5) {
            KLog.INSTANCE.e("CheckIdentityRequest", "CheckIdentityRsp decode error: " + th5);
            return new b(null, 0, null, 7, null);
        }
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.base.repo.IBizRequestByProxy
    public final int getAppId() {
        return this.appId;
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.base.repo.IBizRequestByProxy
    public final String getMethod() {
        return "CheckIdentity";
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.base.repo.IBizRequestByProxy
    public final a getRequest() {
        return new a(UserDataManager.INSTANCE.getCommonExtInfo());
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.base.repo.IBizRequestByProxy
    public final String getService() {
        return "QQStranger.FeedSvr";
    }
}
