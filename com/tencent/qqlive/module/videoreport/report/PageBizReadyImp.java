package com.tencent.qqlive.module.videoreport.report;

import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import com.tencent.qqlive.module.videoreport.page.PageInfo;
import com.tencent.qqlive.module.videoreport.report.bizready.BaseBizReadyImp;
import com.tencent.qqlive.module.videoreport.report.bizready.IBizReadyListener;
import com.tencent.qqlive.module.videoreport.report.bizready.IPageBizReady;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes22.dex */
public class PageBizReadyImp implements IPageBizReady {
    private static final String TAG = "PageBizReadyImp";
    private final BaseBizReadyImp<PageInfo> mBaseBizReadyImp = new a();

    /* loaded from: classes22.dex */
    class a extends BaseBizReadyImp<PageInfo> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.qqlive.module.videoreport.report.bizready.BaseBizReadyImp
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Object getTargetObj(PageInfo pageInfo) {
            return pageInfo.getPage();
        }

        @Override // com.tencent.qqlive.module.videoreport.report.bizready.BaseBizReadyImp
        protected boolean isTargetObject(Object obj) {
            return VideoReportInner.getInstance().checkPageObjectArgument(obj);
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.report.bizready.IPageBizReady
    public void reportNotBizReadyPages() {
        List<PageInfo> notBizReadyList = this.mBaseBizReadyImp.getNotBizReadyList();
        for (int i3 = 0; i3 < notBizReadyList.size(); i3++) {
            PageInfo pageInfo = notBizReadyList.get(i3);
            if (pageInfo != null && pageInfo.getPage() != null) {
                setBizReady(pageInfo.getPage(), true);
                Log.d(TAG, "reportNotBizReadyPages() -> pageInfo=" + pageInfo);
            }
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.report.bizready.IBizReady
    public void setBizReady(Object obj, boolean z16) {
        this.mBaseBizReadyImp.setBizReady(obj, z16);
    }

    @Override // com.tencent.qqlive.module.videoreport.report.bizready.IBizReady
    public void setOnBizReadyListener(IBizReadyListener<PageInfo> iBizReadyListener) {
        this.mBaseBizReadyImp.setOnBizReadyListener(iBizReadyListener);
    }

    @Override // com.tencent.qqlive.module.videoreport.report.bizready.IBizReady
    public PageInfo handleExposureInfo(PageInfo pageInfo) {
        return this.mBaseBizReadyImp.handleExposureInfo(pageInfo);
    }
}
