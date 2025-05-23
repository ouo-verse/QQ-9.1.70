package com.tencent.qqlive.module.videoreport.report.bizready;

import android.view.View;
import com.tencent.qqlive.module.videoreport.report.element.ExposureElementInfo;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface IElementBizReady extends IBizReady<ExposureElementInfo> {
    boolean isElementNotCached(View view);

    void reportNotBizReadyElement(long j3);
}
