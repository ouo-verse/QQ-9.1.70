package com.tencent.richframework.argus.business.performance.function.sample.page;

import com.tencent.biz.richframework.monitor.sample.IRFWSampleManager;
import com.tencent.biz.richframework.monitor.sample.IRFWSampleMeetStrategy;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/richframework/argus/business/performance/function/sample/page/ArgusPageSampleManager;", "Lcom/tencent/biz/richframework/monitor/sample/IRFWSampleManager;", "()V", "list", "", "Lcom/tencent/biz/richframework/monitor/sample/IRFWSampleMeetStrategy;", "getMeetStrategies", "qq-argus-kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
public final class ArgusPageSampleManager implements IRFWSampleManager {

    @NotNull
    private final List<IRFWSampleMeetStrategy> list;

    public ArgusPageSampleManager() {
        List<IRFWSampleMeetStrategy> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new IRFWSampleMeetStrategy[]{new ArgusPageGrayMonitorSample(), new ArgusPagePublicMonitorSample(), new ArgusPageReleaseMonitorSample()});
        this.list = listOf;
    }

    @Override // com.tencent.biz.richframework.monitor.sample.IRFWSampleManager
    @NotNull
    public List<IRFWSampleMeetStrategy> getMeetStrategies() {
        return this.list;
    }

    @Override // com.tencent.biz.richframework.monitor.sample.IRFWSampleManager
    public boolean hitSample(@Nullable String str) {
        return IRFWSampleManager.DefaultImpls.hitSample(this, str);
    }
}
