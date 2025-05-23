package com.tencent.qqlive.module.videoreport.sample.interceptor;

import com.tencent.qqlive.module.videoreport.common.ReportEvent;
import com.tencent.qqlive.module.videoreport.sample.Chain;
import com.tencent.qqlive.module.videoreport.sample.model.InterceptRes;
import com.tencent.qqlive.module.videoreport.sample.samplenode.SampleHeadNode;
import com.tencent.qqlive.module.videoreport.sample.samplenode.SampleNode;
import java.util.List;

/* compiled from: P */
/* loaded from: classes22.dex */
public class HeadInterceptor extends BaseSampleInterceptor {
    public HeadInterceptor(Chain chain) {
        super(chain);
    }

    @Override // com.tencent.qqlive.module.videoreport.sample.interceptor.Interceptor
    public InterceptorIndex index() {
        return InterceptorIndex.INTERCEPTOR_HEAD;
    }

    @Override // com.tencent.qqlive.module.videoreport.sample.interceptor.Interceptor
    public InterceptRes intercept(ReportEvent reportEvent, List<SampleNode> list) {
        if (list != null && list.size() == 1) {
            if (list.get(0) instanceof SampleHeadNode) {
                return proceed(reportEvent, list.get(0).children());
            }
            return res();
        }
        return res();
    }
}
