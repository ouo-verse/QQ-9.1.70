package com.qzone.common.activities.base;

import com.tencent.luan.ioc.annotation.Inject;
import com.tencent.luan.ioc.annotation.Named;
import com.tencent.luan.ioc.annotation.Singleton;

/* compiled from: P */
@Singleton
@Named("CustomListViewFragmentDateImp")
/* loaded from: classes39.dex */
public class ag implements d5.f {
    @Inject
    public ag() {
    }

    @Override // d5.f
    public String a(long j3) {
        return com.qzone.album.util.g.b(j3);
    }
}
