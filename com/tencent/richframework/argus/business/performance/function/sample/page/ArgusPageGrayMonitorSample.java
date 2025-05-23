package com.tencent.richframework.argus.business.performance.function.sample.page;

import com.tencent.biz.richframework.monitor.sample.IRFWSampleMeetStrategy;
import com.tencent.mobileqq.config.api.IAppSettingApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.richframework.argus.business.performance.report.sample.page.PageSceneSampleUtils;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\u0003\u001a\u00020\u0004H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/tencent/richframework/argus/business/performance/function/sample/page/ArgusPageGrayMonitorSample;", "Lcom/tencent/biz/richframework/monitor/sample/IRFWSampleMeetStrategy;", "()V", "isTargetType", "", "sampleValue", "", "getSampleSize", "key", "", "qq-argus-kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
public final class ArgusPageGrayMonitorSample implements IRFWSampleMeetStrategy {
    private final boolean isTargetType;
    private final float sampleValue;

    public ArgusPageGrayMonitorSample() {
        boolean z16;
        float personalGraySampleSize = PageSceneSampleUtils.INSTANCE.getPersonalGraySampleSize();
        this.sampleValue = personalGraySampleSize;
        if (((IAppSettingApi) QRoute.api(IAppSettingApi.class)).isPublicVersion() && ((IAppSettingApi) QRoute.api(IAppSettingApi.class)).isGrayVersion() && personalGraySampleSize > 0.0f) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.isTargetType = z16;
    }

    @Override // com.tencent.biz.richframework.monitor.sample.IRFWSampleMeetStrategy
    public float getSampleSize(@Nullable String key) {
        return this.sampleValue;
    }

    @Override // com.tencent.biz.richframework.monitor.sample.IRFWSampleMeetStrategy
    /* renamed from: isTargetType, reason: from getter */
    public boolean getIsTargetType() {
        return this.isTargetType;
    }
}
