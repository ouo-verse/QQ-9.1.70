package com.tencent.qqlive.module.videoreport.sample.interceptor;

import com.tencent.qqlive.module.videoreport.common.ReportEvent;
import com.tencent.qqlive.module.videoreport.sample.Chain;
import com.tencent.qqlive.module.videoreport.sample.model.InterceptRes;
import com.tencent.qqlive.module.videoreport.sample.model.SampleConfig;
import com.tencent.qqlive.module.videoreport.sample.samplenode.SampleKVMatchNode;
import com.tencent.qqlive.module.videoreport.sample.samplenode.SampleNode;
import com.tencent.qqlive.module.videoreport.utils.BaseUtils;
import java.util.List;
import java.util.Map;

/* loaded from: classes22.dex */
public class ParamsInterceptor extends BaseSampleInterceptor {
    public ParamsInterceptor(Chain chain) {
        super(chain);
    }

    private InterceptRes allKvMatched(ReportEvent reportEvent, List<SampleNode> list) {
        if (reportEvent == null) {
            return res();
        }
        Map<String, Object> rawParams = reportEvent.getRawParams();
        for (SampleNode sampleNode : list) {
            if ((sampleNode instanceof SampleKVMatchNode) && kvMatched(rawParams, (SampleKVMatchNode) sampleNode)) {
                return proceed(reportEvent, sampleNode.children());
            }
        }
        return res();
    }

    private String findValueByKey(Map<String, Object> map, String str) {
        try {
            return String.valueOf(findValueByPath(str.split("\\."), map, 0));
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    private Object findValueByPath(String[] strArr, Object obj, int i3) {
        if (obj instanceof Map) {
            if (i3 > strArr.length) {
                return obj;
            }
            return findValueByPath(strArr, ((Map) obj).get(strArr[i3]), i3 + 1);
        }
        return obj;
    }

    private boolean kvMatched(Map<String, Object> map, SampleKVMatchNode sampleKVMatchNode) {
        String findValueByKey;
        if (BaseUtils.isEmpty(sampleKVMatchNode.params())) {
            return false;
        }
        for (SampleConfig.Param param : sampleKVMatchNode.params()) {
            if (param == null || (findValueByKey = findValueByKey(map, param.key)) == null || !sampleKVMatchNode.matched(param.key, findValueByKey)) {
                return false;
            }
        }
        return true;
    }

    @Override // com.tencent.qqlive.module.videoreport.sample.interceptor.Interceptor
    public InterceptorIndex index() {
        return InterceptorIndex.INTERCEPTOR_PARAMS;
    }

    @Override // com.tencent.qqlive.module.videoreport.sample.interceptor.Interceptor
    public InterceptRes intercept(ReportEvent reportEvent, List<SampleNode> list) {
        if (BaseUtils.isEmpty(list)) {
            return res();
        }
        InterceptRes allKvMatched = allKvMatched(reportEvent, list);
        if (!allKvMatched.intercepted()) {
            return wildCardMatch(reportEvent, list);
        }
        return allKvMatched;
    }
}
