package com.tencent.qqlive.module.videoreport.page;

import com.tencent.qqlive.module.videoreport.data.DataEntity;

/* loaded from: classes22.dex */
public class PageContext {
    public final DataEntity crePageData;
    public final int crePageStep;
    public final DataEntity curPageData;
    public boolean isDisappear;
    public final int pageStep;
    public final DataEntity refPageData;
    public final int refPageStep;

    public PageContext(int i3, int i16, int i17, DataEntity dataEntity, DataEntity dataEntity2, DataEntity dataEntity3) {
        this.pageStep = i3;
        this.refPageStep = i16;
        this.crePageStep = i17;
        this.curPageData = dataEntity;
        this.refPageData = dataEntity2;
        this.crePageData = dataEntity3;
    }

    public void disappear() {
        this.isDisappear = true;
        DataEntity dataEntity = this.curPageData;
        if (dataEntity != null) {
            dataEntity.unRegisterDynamicParamsProvider();
        }
    }
}
