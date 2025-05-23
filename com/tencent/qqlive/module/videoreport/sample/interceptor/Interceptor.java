package com.tencent.qqlive.module.videoreport.sample.interceptor;

import com.tencent.qqlive.module.videoreport.common.ReportEvent;
import com.tencent.qqlive.module.videoreport.sample.model.InterceptRes;
import com.tencent.qqlive.module.videoreport.sample.samplenode.SampleNode;
import java.util.List;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface Interceptor {
    InterceptorIndex index();

    InterceptRes intercept(ReportEvent reportEvent, List<SampleNode> list);
}
