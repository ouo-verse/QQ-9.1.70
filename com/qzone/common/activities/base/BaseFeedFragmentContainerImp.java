package com.qzone.common.activities.base;

import com.qzone.widget.QZonePullToRefreshListView;
import com.tencent.luan.ioc.annotation.Inject;

/* compiled from: P */
/* loaded from: classes39.dex */
public class BaseFeedFragmentContainerImp extends BaseFragmentContainerImp {

    /* renamed from: d, reason: collision with root package name */
    private final QZoneBaseFeedFragment f44981d;

    @Inject
    public BaseFeedFragmentContainerImp(QZoneBaseFeedFragment qZoneBaseFeedFragment) {
        super(qZoneBaseFeedFragment);
        this.f44981d = qZoneBaseFeedFragment;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.qzone.feed.business.service.a f() {
        return this.f44981d.si();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public QZonePullToRefreshListView g() {
        return this.f44981d.zi();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h() {
        this.f44981d.H8();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(String str, String str2) {
        this.f44981d.zj(str, str2);
    }
}
