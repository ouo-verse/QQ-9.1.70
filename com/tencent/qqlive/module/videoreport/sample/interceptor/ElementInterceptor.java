package com.tencent.qqlive.module.videoreport.sample.interceptor;

import com.tencent.qqlive.module.videoreport.common.ReportEvent;
import com.tencent.qqlive.module.videoreport.sample.Chain;
import com.tencent.qqlive.module.videoreport.sample.model.InterceptRes;
import com.tencent.qqlive.module.videoreport.sample.samplenode.SampleNode;
import com.tencent.qqlive.module.videoreport.utils.BaseUtils;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes22.dex */
public class ElementInterceptor extends BaseSampleInterceptor {
    public ElementInterceptor(Chain chain) {
        super(chain);
    }

    @Override // com.tencent.qqlive.module.videoreport.sample.interceptor.Interceptor
    public InterceptorIndex index() {
        return InterceptorIndex.INTERCEPTOR_ELEMENT;
    }

    @Override // com.tencent.qqlive.module.videoreport.sample.interceptor.Interceptor
    public InterceptRes intercept(ReportEvent reportEvent, List<SampleNode> list) {
        Object obj;
        if (BaseUtils.isEmpty(list)) {
            return res();
        }
        if (reportEvent == null) {
            return res();
        }
        Map<String, Object> rawParams = reportEvent.getRawParams();
        if (rawParams != null) {
            obj = rawParams.get("dt_eid");
        } else {
            obj = null;
        }
        if (obj == null) {
            obj = "";
        }
        if (obj instanceof String) {
            InterceptRes vMatch = vMatch(reportEvent, (String) obj, list);
            if (!vMatch.intercepted()) {
                return wildCardMatch(reportEvent, list);
            }
            return vMatch;
        }
        return res();
    }
}
