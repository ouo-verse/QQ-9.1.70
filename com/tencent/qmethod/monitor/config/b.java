package com.tencent.qmethod.monitor.config;

import com.tencent.qmethod.monitor.config.ConfigManager;
import com.tencent.qmethod.monitor.report.SampleHelper;
import com.tencent.qmethod.pandoraex.api.q;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/qmethod/monitor/config/b;", "Lcom/tencent/qmethod/monitor/config/ConfigManager$a;", "Lcom/tencent/qmethod/monitor/config/bean/d;", "newConfig", "oldConfig", "", "a", "<init>", "()V", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes22.dex */
public final class b implements ConfigManager.a {
    @Override // com.tencent.qmethod.monitor.config.ConfigManager.a
    public void a(@NotNull com.tencent.qmethod.monitor.config.bean.d newConfig, @NotNull com.tencent.qmethod.monitor.config.bean.d oldConfig) {
        Intrinsics.checkParameterIsNotNull(newConfig, "newConfig");
        Intrinsics.checkParameterIsNotNull(oldConfig, "oldConfig");
        SampleHelper.f343779l.v();
        Iterator<T> it = newConfig.d().iterator();
        while (it.hasNext()) {
            q.v((com.tencent.qmethod.pandoraex.api.b) it.next());
        }
        com.tencent.qmethod.monitor.ext.auto.a.f343622g.c();
        jr3.a.f410877b.e();
        ir3.a.f408442b.e();
    }
}
