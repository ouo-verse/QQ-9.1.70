package com.qzone.common.activities.base;

import com.qzone.proxy.feedcomponent.model.BusinessFeedData;

/* compiled from: P */
/* loaded from: classes39.dex */
public class k implements d5.k<BusinessFeedData> {

    /* renamed from: a, reason: collision with root package name */
    private final BusinessFeedData f45526a;

    public k(BusinessFeedData businessFeedData) {
        this.f45526a = businessFeedData;
    }

    @Override // d5.k
    public long a() {
        return this.f45526a.getUser().uin;
    }

    @Override // d5.k
    public int c() {
        return this.f45526a.getFeedCommInfo().subid;
    }

    @Override // d5.k
    public String d() {
        return this.f45526a.getFeedCommInfo().ugckey;
    }

    @Override // d5.k
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public BusinessFeedData b() {
        return this.f45526a;
    }

    @Override // d5.k
    public int getAppId() {
        return this.f45526a.getFeedCommInfo().appid;
    }
}
