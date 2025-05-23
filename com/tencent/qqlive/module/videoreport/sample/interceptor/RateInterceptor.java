package com.tencent.qqlive.module.videoreport.sample.interceptor;

import com.tencent.qqlive.module.videoreport.common.ReportEvent;
import com.tencent.qqlive.module.videoreport.sample.Chain;
import com.tencent.qqlive.module.videoreport.sample.model.InterceptRes;
import com.tencent.qqlive.module.videoreport.sample.samplenode.SampleNode;
import com.tencent.qqlive.module.videoreport.sample.samplenode.SampleRateNode;
import com.tencent.qqlive.module.videoreport.utils.BaseUtils;
import java.util.List;

/* compiled from: P */
/* loaded from: classes22.dex */
public class RateInterceptor extends BaseSampleInterceptor {
    private final InterceptRes res;

    public RateInterceptor(Chain chain) {
        super(chain);
        this.res = res();
    }

    @Override // com.tencent.qqlive.module.videoreport.sample.interceptor.Interceptor
    public InterceptorIndex index() {
        return InterceptorIndex.INTERCEPTOR_RATE;
    }

    @Override // com.tencent.qqlive.module.videoreport.sample.interceptor.Interceptor
    public InterceptRes intercept(ReportEvent reportEvent, List<SampleNode> list) {
        this.res.setIntercepted(true);
        if (BaseUtils.isEmpty(list)) {
            return this.res;
        }
        if (list.size() > 1) {
            return this.res;
        }
        SampleNode sampleNode = list.get(0);
        if (sampleNode instanceof SampleRateNode) {
            this.res.setSampleRate(((SampleRateNode) sampleNode).rate());
            return this.res;
        }
        return this.res;
    }
}
