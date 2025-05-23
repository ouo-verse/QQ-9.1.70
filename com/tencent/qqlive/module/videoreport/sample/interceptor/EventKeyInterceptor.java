package com.tencent.qqlive.module.videoreport.sample.interceptor;

import com.tencent.qqlive.module.videoreport.common.ReportEvent;
import com.tencent.qqlive.module.videoreport.sample.Chain;
import com.tencent.qqlive.module.videoreport.sample.model.InterceptRes;
import com.tencent.qqlive.module.videoreport.sample.samplenode.SampleNode;
import com.tencent.qqlive.module.videoreport.utils.BaseUtils;
import java.util.List;

/* compiled from: P */
/* loaded from: classes22.dex */
public class EventKeyInterceptor extends BaseSampleInterceptor {
    public EventKeyInterceptor(Chain chain) {
        super(chain);
    }

    @Override // com.tencent.qqlive.module.videoreport.sample.interceptor.Interceptor
    public InterceptorIndex index() {
        return InterceptorIndex.INTERCEPTOR_EVENT;
    }

    @Override // com.tencent.qqlive.module.videoreport.sample.interceptor.Interceptor
    public InterceptRes intercept(ReportEvent reportEvent, List<SampleNode> list) {
        String str;
        if (BaseUtils.isEmpty(list)) {
            return res();
        }
        if (reportEvent != null) {
            str = reportEvent.getKey();
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        InterceptRes vMatch = vMatch(reportEvent, str, list);
        if (!vMatch.intercepted()) {
            return wildCardMatch(reportEvent, list);
        }
        return vMatch;
    }
}
