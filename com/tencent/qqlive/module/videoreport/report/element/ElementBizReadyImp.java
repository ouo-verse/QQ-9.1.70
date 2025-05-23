package com.tencent.qqlive.module.videoreport.report.element;

import android.util.SparseArray;
import android.view.View;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import com.tencent.qqlive.module.videoreport.report.bizready.BaseBizReadyImp;
import com.tencent.qqlive.module.videoreport.report.bizready.IBizReadyListener;
import com.tencent.qqlive.module.videoreport.report.bizready.IElementBizReady;
import java.util.List;

/* compiled from: P */
/* loaded from: classes22.dex */
class ElementBizReadyImp implements IElementBizReady {
    private static final String TAG = "ElementBizReadyImp";
    private final BaseBizReadyImp<ExposureElementInfo> mBaseBizReadyImp = new a();

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class a extends BaseBizReadyImp<ExposureElementInfo> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.qqlive.module.videoreport.report.bizready.BaseBizReadyImp
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Object getTargetObj(ExposureElementInfo exposureElementInfo) {
            return exposureElementInfo.getView();
        }

        @Override // com.tencent.qqlive.module.videoreport.report.bizready.BaseBizReadyImp
        protected boolean isTargetObject(Object obj) {
            return VideoReportInner.getInstance().checkElementObjectArgument(obj);
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.report.bizready.IElementBizReady
    public boolean isElementNotCached(View view) {
        SparseArray<ExposureElementInfo> exposureInfoMap;
        if (view == null || (exposureInfoMap = this.mBaseBizReadyImp.getExposureInfoMap()) == null || exposureInfoMap.size() <= 0 || exposureInfoMap.indexOfKey(view.hashCode()) < 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.qqlive.module.videoreport.report.bizready.IElementBizReady
    public void reportNotBizReadyElement(long j3) {
        ExposureElementInfo exposureElementInfo;
        List<ExposureElementInfo> notBizReadyList = this.mBaseBizReadyImp.getNotBizReadyList();
        int i3 = 0;
        while (true) {
            if (i3 < notBizReadyList.size()) {
                if (notBizReadyList.get(i3).getUniqueId() == j3) {
                    exposureElementInfo = notBizReadyList.get(i3);
                    break;
                }
                i3++;
            } else {
                exposureElementInfo = null;
                break;
            }
        }
        if (exposureElementInfo != null && exposureElementInfo.getView() != null) {
            setBizReady(exposureElementInfo.getView(), true);
            Log.d(TAG, "reportNotBizReadyElement() -> exposureElementInfo=" + exposureElementInfo);
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.report.bizready.IBizReady
    public void setBizReady(Object obj, boolean z16) {
        this.mBaseBizReadyImp.setBizReady(obj, z16);
    }

    @Override // com.tencent.qqlive.module.videoreport.report.bizready.IBizReady
    public void setOnBizReadyListener(IBizReadyListener<ExposureElementInfo> iBizReadyListener) {
        if (iBizReadyListener == null) {
            return;
        }
        this.mBaseBizReadyImp.setOnBizReadyListener(iBizReadyListener);
    }

    @Override // com.tencent.qqlive.module.videoreport.report.bizready.IBizReady
    public ExposureElementInfo handleExposureInfo(ExposureElementInfo exposureElementInfo) {
        return this.mBaseBizReadyImp.handleExposureInfo(exposureElementInfo);
    }
}
