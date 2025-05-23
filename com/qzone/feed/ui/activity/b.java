package com.qzone.feed.ui.activity;

import com.qzone.common.activities.base.BaseFeedFragmentFeedPresenterImp;
import com.qzone.common.activities.base.QZoneBaseFeedFragment;
import com.qzone.common.logic.presenter.BaseFeedPresenter;
import com.tencent.luan.ioc.annotation.Inject;

/* compiled from: P */
/* loaded from: classes39.dex */
public class b extends BaseFeedFragmentFeedPresenterImp {
    @Inject
    public b() {
    }

    @Override // com.qzone.common.activities.base.BaseFeedFragmentFeedPresenterImp
    protected BaseFeedPresenter e() {
        return new com.qzone.common.logic.presenter.b((QZoneBaseFeedFragment) this.f45044a.getFragment());
    }
}
