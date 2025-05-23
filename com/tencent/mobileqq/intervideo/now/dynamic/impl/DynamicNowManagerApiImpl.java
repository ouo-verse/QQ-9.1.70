package com.tencent.mobileqq.intervideo.now.dynamic.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.intervideo.now.dynamic.IDynamicNowManagerApi;
import com.tencent.mobileqq.intervideo.now.dynamic.a;

/* compiled from: P */
/* loaded from: classes33.dex */
public class DynamicNowManagerApiImpl implements IDynamicNowManagerApi {
    @Override // com.tencent.mobileqq.intervideo.now.dynamic.IDynamicNowManagerApi
    public void addJumpCallback() {
        a.g();
    }

    @Override // com.tencent.mobileqq.intervideo.now.dynamic.IDynamicNowManagerApi
    public int getFirstByFrom(String str) {
        return a.i(str);
    }

    @Override // com.tencent.mobileqq.intervideo.now.dynamic.IDynamicNowManagerApi
    public AppInterface getQQAppInterface() {
        return a.k();
    }
}
