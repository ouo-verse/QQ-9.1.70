package com.tencent.qqlive.module.videoreport.sample;

import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.common.ReportEvent;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import com.tencent.qqlive.module.videoreport.remoteconfig.RemoteConfig;
import com.tencent.qqlive.module.videoreport.sample.SampleConfigLoader;
import com.tencent.qqlive.module.videoreport.sample.interceptor.ElementInterceptor;
import com.tencent.qqlive.module.videoreport.sample.interceptor.EventKeyInterceptor;
import com.tencent.qqlive.module.videoreport.sample.interceptor.HeadInterceptor;
import com.tencent.qqlive.module.videoreport.sample.interceptor.Interceptor;
import com.tencent.qqlive.module.videoreport.sample.interceptor.InterceptorIndex;
import com.tencent.qqlive.module.videoreport.sample.interceptor.PageInterceptor;
import com.tencent.qqlive.module.videoreport.sample.interceptor.ParamsInterceptor;
import com.tencent.qqlive.module.videoreport.sample.interceptor.RateInterceptor;
import com.tencent.qqlive.module.videoreport.sample.model.InterceptRes;
import com.tencent.qqlive.module.videoreport.sample.samplenode.SampleNode;
import com.tencent.qqlive.module.videoreport.utils.BaseUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: P */
/* loaded from: classes22.dex */
public class SamplerImpl implements Sampler, Chain, SampleConfigLoader.OnConfigLoadedListener {
    private final SampleConfigLoader configLoader;
    private final Interceptor interceptor;
    private final List<Interceptor> interceptors;
    private final InterceptRes res;
    private SampleNode sampleTree;

    public SamplerImpl() {
        ArrayList arrayList = new ArrayList();
        this.interceptors = arrayList;
        this.interceptor = new HeadInterceptor(this);
        SampleConfigLoader sampleConfigLoader = new SampleConfigLoader();
        this.configLoader = sampleConfigLoader;
        this.res = InterceptRes.defRes();
        sampleConfigLoader.observeSampleConfigLoad(this);
        generateInterceptors(arrayList);
    }

    private boolean cannotSample() {
        if (VideoReport.getConfiguration().remoteSampleEnabled() && (!VideoReportInner.getInstance().isSampleDisable() || VideoReportInner.getInstance().sampleTestEnabled())) {
            return false;
        }
        return true;
    }

    private void generateInterceptors(List<Interceptor> list) {
        list.add(new EventKeyInterceptor(this));
        list.add(new PageInterceptor(this));
        list.add(new ElementInterceptor(this));
        list.add(new ParamsInterceptor(this));
        list.add(new RateInterceptor(this));
    }

    private Interceptor next(InterceptorIndex interceptorIndex) {
        for (Interceptor interceptor : this.interceptors) {
            if (interceptor.index().getIndex() == interceptorIndex.next()) {
                return interceptor;
            }
        }
        return null;
    }

    @Override // com.tencent.qqlive.module.videoreport.sample.Sampler
    public synchronized void bindConfig(SampleNode sampleNode) {
        if (sampleNode != null) {
            if (!BaseUtils.isEmpty(sampleNode.children())) {
                Log.d(DTConstants.TAG.SAMPLER, "config onBind");
                this.sampleTree = sampleNode;
            }
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.sample.Sampler
    public synchronized void bindSubConfig(SampleNode sampleNode) {
        if (sampleNode != null) {
            if (!BaseUtils.isEmpty(sampleNode.children())) {
                if (this.sampleTree == null) {
                    this.sampleTree = sampleNode;
                }
            }
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.sample.Chain
    public InterceptRes defRes() {
        return this.res;
    }

    @Override // com.tencent.qqlive.module.videoreport.sample.Sampler
    public void loadConfig(RemoteConfig remoteConfig) {
        this.configLoader.load(remoteConfig, VideoReportInner.getInstance().getSampleSceneId());
    }

    @Override // com.tencent.qqlive.module.videoreport.sample.SampleConfigLoader.OnConfigLoadedListener
    public void onConfigLoaded(SampleNode sampleNode) {
        bindConfig(sampleNode);
    }

    @Override // com.tencent.qqlive.module.videoreport.sample.SampleConfigLoader.OnConfigLoadedListener
    public void onSubConfigLoaded(SampleNode sampleNode) {
        bindSubConfig(sampleNode);
    }

    @Override // com.tencent.qqlive.module.videoreport.sample.Chain
    public InterceptRes proceed(InterceptorIndex interceptorIndex, ReportEvent reportEvent, List<SampleNode> list) {
        Interceptor next = next(interceptorIndex);
        if (next != null) {
            return next.intercept(reportEvent, list);
        }
        return this.res;
    }

    @Override // com.tencent.qqlive.module.videoreport.sample.Sampler
    public synchronized void sample(ReportEvent reportEvent) {
        if (cannotSample()) {
            return;
        }
        SampleNode sampleNode = this.sampleTree;
        if (sampleNode != null && !BaseUtils.isEmpty(sampleNode.children())) {
            this.res.reset();
            InterceptRes intercept = this.interceptor.intercept(reportEvent, Collections.singletonList(this.sampleTree));
            if (intercept != null && intercept.intercepted()) {
                reportEvent.remoteSampled(SampleRateUtil.isHit(intercept.rate()));
                reportEvent.remoteSampleRate(intercept.rate());
                reportEvent.remoteSampleHit(intercept.intercepted());
            }
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.sample.Sampler
    public void loadConfig(String str) {
        this.configLoader.load(str);
    }
}
