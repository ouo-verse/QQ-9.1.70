package com.qzone.common.activities.base;

import android.content.Intent;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.tencent.luan.ioc.annotation.Inject;
import com.tencent.luan.ioc.annotation.Named;

/* compiled from: P */
@Named("BaseFeedFragmentShareImp")
/* loaded from: classes39.dex */
public class w implements d5.ad<BusinessFeedData> {

    /* renamed from: a, reason: collision with root package name */
    private d5.u f45550a;

    @Inject
    public w() {
    }

    @Inject
    public void setContainer(d5.u uVar) {
        this.f45550a = uVar;
    }

    @Override // d5.ad
    public void onResume() {
    }

    @Override // d5.ad
    public void a(int i3, int i16, Intent intent) {
    }
}
