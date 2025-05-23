package com.qzone.feed.ui.activity;

import com.qzone.common.activities.base.ad;
import com.tencent.luan.ioc.annotation.Inject;
import com.tencent.luan.ioc.annotation.Named;

/* compiled from: P */
@Named("CommonPushFeedFragmentReporter")
/* loaded from: classes39.dex */
public class a extends ad {

    /* renamed from: e, reason: collision with root package name */
    protected int f47336e;

    @Inject
    public a() {
    }

    @Override // com.qzone.common.activities.base.ad, com.qzone.util.ap.a
    public int getReportPageId() {
        return this.f47336e;
    }
}
