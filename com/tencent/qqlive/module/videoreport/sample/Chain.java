package com.tencent.qqlive.module.videoreport.sample;

import com.tencent.qqlive.module.videoreport.common.ReportEvent;
import com.tencent.qqlive.module.videoreport.sample.interceptor.InterceptorIndex;
import com.tencent.qqlive.module.videoreport.sample.model.InterceptRes;
import com.tencent.qqlive.module.videoreport.sample.samplenode.SampleNode;
import java.util.List;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface Chain {
    InterceptRes defRes();

    InterceptRes proceed(InterceptorIndex interceptorIndex, ReportEvent reportEvent, List<SampleNode> list);
}
