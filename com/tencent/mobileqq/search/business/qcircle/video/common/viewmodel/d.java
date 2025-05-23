package com.tencent.mobileqq.search.business.qcircle.video.common.viewmodel;

import androidx.lifecycle.MutableLiveData;
import com.tencent.richframework.data.base.UIStateData;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public class d extends com.tencent.mobileqq.search.business.qcircle.video.base.viewmodel.a {
    private final c D = new c();

    @Override // com.tencent.mobileqq.search.business.qcircle.video.base.viewmodel.a
    public void T1(List<FeedCloudMeta$StFeed> list) {
        this.D.c2(list);
    }

    @Override // com.tencent.mobileqq.search.business.qcircle.video.base.viewmodel.a
    public boolean U1(Object obj) {
        boolean U1 = super.U1(obj);
        if (U1) {
            this.D.e2();
        }
        return U1;
    }

    @Override // com.tencent.mobileqq.search.business.qcircle.video.base.viewmodel.a
    public void W1(String str) {
        this.D.f2(str);
    }

    @Override // com.tencent.richframework.data.idata.IDataDisplaySurface
    public MutableLiveData<UIStateData<List<e30.b>>> getDisplaySurfaceData(Object... objArr) {
        return this.D.getDisplaySurfaceData(objArr);
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    public String getLogTag() {
        return "QCircleSearchCommonVideoViewModel";
    }

    @Override // com.tencent.richframework.data.idata.IDataDisplaySurface
    public void loadMoreForDisplaySurface(Object... objArr) {
        this.D.loadMoreForDisplaySurface(objArr);
    }
}
