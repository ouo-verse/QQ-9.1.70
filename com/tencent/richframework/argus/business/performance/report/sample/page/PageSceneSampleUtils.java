package com.tencent.richframework.argus.business.performance.report.sample.page;

import com.tencent.richframework.argus.business.performance.report.sample.ISceneSample;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0006\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\u0004\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/richframework/argus/business/performance/report/sample/page/PageSceneSampleUtils;", "Lcom/tencent/richframework/argus/business/performance/report/sample/ISceneSample;", "", "getCanLanKey", "", "getGraySample", "getPublicSample", "getPersonalGraySampleSize", "getPersonalPublicSampleSize", "<init>", "()V", "qq-argus-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class PageSceneSampleUtils extends ISceneSample {

    @NotNull
    public static final PageSceneSampleUtils INSTANCE = new PageSceneSampleUtils();

    PageSceneSampleUtils() {
    }

    @Override // com.tencent.richframework.argus.business.performance.report.sample.ISceneSample
    @NotNull
    public String getCanLanKey() {
        return "argus_page_scene_sample";
    }

    public final float getGraySample() {
        return getSampleSize("gray_default", 1.0E-4f);
    }

    public final float getPersonalGraySampleSize() {
        return getSampleSize("gray_personal", 0.02f);
    }

    public final float getPersonalPublicSampleSize() {
        return getSampleSize("public_personal", 0.0f);
    }

    public final float getPublicSample() {
        return getSampleSize("public_default", 1.0E-4f);
    }
}
