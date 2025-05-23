package com.tencent.biz.pubaccount.weishi.verticalvideo.data.module;

import com.tencent.biz.pubaccount.weishi.util.bb;

/* compiled from: P */
/* loaded from: classes32.dex */
public class b {
    public static a a() {
        if (bb.L(13)) {
            return new d();
        }
        if (bb.z() != null) {
            return new WSFetchPushDataModule();
        }
        return new c();
    }
}
