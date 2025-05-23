package com.tencent.qqlive.module.videoreport.sample.interceptor;

import com.tencent.qqlive.module.videoreport.common.ReportEvent;
import com.tencent.qqlive.module.videoreport.sample.Chain;
import com.tencent.qqlive.module.videoreport.sample.model.InterceptRes;
import com.tencent.qqlive.module.videoreport.sample.samplenode.SampleNode;
import com.tencent.qqlive.module.videoreport.sample.samplenode.SampleVMatchNode;
import java.util.List;

/* compiled from: P */
/* loaded from: classes22.dex */
public abstract class BaseSampleInterceptor implements Interceptor {
    public static final String SAMPLE_TAG = "sampler";
    private final Chain chain;

    public BaseSampleInterceptor(Chain chain) {
        this.chain = chain;
    }

    private SampleNode findWildCardNode(List<SampleNode> list) {
        for (SampleNode sampleNode : list) {
            if (wildCardNode(sampleNode)) {
                return sampleNode;
            }
        }
        return null;
    }

    private boolean wildCardNode(SampleNode sampleNode) {
        if ((sampleNode instanceof SampleVMatchNode) && "*".equals(((SampleVMatchNode) sampleNode).value())) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public InterceptRes proceed(ReportEvent reportEvent, List<SampleNode> list) {
        return this.chain.proceed(index(), reportEvent, list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public InterceptRes res() {
        return this.chain.defRes();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public InterceptRes vMatch(ReportEvent reportEvent, String str, List<SampleNode> list) {
        for (SampleNode sampleNode : list) {
            if (sampleNode.matched(str)) {
                return proceed(reportEvent, sampleNode.children());
            }
        }
        return res();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public InterceptRes wildCardMatch(ReportEvent reportEvent, List<SampleNode> list) {
        SampleNode findWildCardNode = findWildCardNode(list);
        if (findWildCardNode != null) {
            return proceed(reportEvent, findWildCardNode.children());
        }
        return res();
    }
}
