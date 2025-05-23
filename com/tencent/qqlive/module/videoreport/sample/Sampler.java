package com.tencent.qqlive.module.videoreport.sample;

import com.tencent.qqlive.module.videoreport.common.ReportEvent;
import com.tencent.qqlive.module.videoreport.remoteconfig.RemoteConfig;
import com.tencent.qqlive.module.videoreport.sample.samplenode.SampleNode;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface Sampler {
    void bindConfig(SampleNode sampleNode);

    void bindSubConfig(SampleNode sampleNode);

    void loadConfig(RemoteConfig remoteConfig);

    void loadConfig(String str);

    void sample(ReportEvent reportEvent);
}
