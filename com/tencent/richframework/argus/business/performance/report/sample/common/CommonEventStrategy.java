package com.tencent.richframework.argus.business.performance.report.sample.common;

import com.tencent.biz.richframework.monitor.sample.IRFWSampleMeetStrategy;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/richframework/argus/business/performance/report/sample/common/CommonEventStrategy;", "Lcom/tencent/biz/richframework/monitor/sample/IRFWSampleMeetStrategy;", "()V", "getSampleSize", "", "key", "", "isTargetType", "", "qq-argus-kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
public final class CommonEventStrategy implements IRFWSampleMeetStrategy {
    @Override // com.tencent.biz.richframework.monitor.sample.IRFWSampleMeetStrategy
    public float getSampleSize(@Nullable String key) {
        CommonEventSceneSampleUtil commonEventSceneSampleUtil = CommonEventSceneSampleUtil.INSTANCE;
        return commonEventSceneSampleUtil.getSampleSize(key, commonEventSceneSampleUtil.getDefaultSample());
    }

    @Override // com.tencent.biz.richframework.monitor.sample.IRFWSampleMeetStrategy
    /* renamed from: isTargetType */
    public boolean getIsTargetType() {
        return true;
    }
}
