package com.tencent.biz.qqcircle.viewmodels;

import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.beans.QCircleFolderBean;
import com.tencent.biz.qqcircle.manager.QCircleFolderTabInfoManager;
import com.tencent.mobileqq.qcircle.api.constant.QCirclePeriodCollect;
import feedcloud.FeedCloudMeta$StGPSV2;
import java.util.List;
import qqcircle.QQCircleFeedBase$StTabInfo;

/* compiled from: P */
/* loaded from: classes5.dex */
public class j extends a {

    /* renamed from: m, reason: collision with root package name */
    private final MutableLiveData<List<QQCircleFeedBase$StTabInfo>> f92864m = new MutableLiveData<>();

    public MutableLiveData<List<QQCircleFeedBase$StTabInfo>> L1() {
        return this.f92864m;
    }

    public void M1(FeedCloudMeta$StGPSV2 feedCloudMeta$StGPSV2, QCircleFolderBean qCircleFolderBean, boolean z16) {
        List<QQCircleFeedBase$StTabInfo> o16 = QCircleFolderTabInfoManager.m().o(feedCloudMeta$StGPSV2, qCircleFolderBean);
        if (!z16) {
            this.f92864m.setValue(o16);
        }
        QCirclePeriodCollect.record(QCirclePeriodCollect.PERIOD_GET_TAB_CACHE_RSP);
        com.tencent.a.a("initTab", "from net");
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QCircleTabViewModel";
    }
}
