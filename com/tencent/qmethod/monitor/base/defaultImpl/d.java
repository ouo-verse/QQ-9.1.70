package com.tencent.qmethod.monitor.base.defaultImpl;

import com.tencent.qmethod.monitor.base.util.ProcessForegroundHelper;
import com.tencent.qmethod.pandoraex.api.q;
import com.tencent.qmethod.pandoraex.core.ext.broadcast.ReceiverDispatchHelper;
import com.tencent.qmethod.pandoraex.core.ext.file.ContentObserverHelper;
import com.tencent.qmethod.pandoraex.core.ext.file.FileObserverHelper;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/qmethod/monitor/base/defaultImpl/d;", "Lcom/tencent/qmethod/monitor/base/defaultImpl/b;", "Lcom/tdsrightly/tds/fg/observer/d;", "from", "", "b", "a", "<init>", "()V", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes22.dex */
public final class d implements b {
    @Override // com.tencent.qmethod.monitor.base.defaultImpl.b
    public void a(@Nullable com.tdsrightly.tds.fg.observer.d from) {
        String str;
        q.o();
        ProcessForegroundHelper processForegroundHelper = ProcessForegroundHelper.f343520g;
        if (from == null || (str = from.getName()) == null) {
            str = "";
        }
        processForegroundHelper.f(str);
        ReceiverDispatchHelper.m();
        FileObserverHelper.g();
        ContentObserverHelper.e();
    }

    @Override // com.tencent.qmethod.monitor.base.defaultImpl.b
    public void b(@Nullable com.tdsrightly.tds.fg.observer.d from) {
        String str;
        q.p();
        ProcessForegroundHelper processForegroundHelper = ProcessForegroundHelper.f343520g;
        if (from == null || (str = from.getName()) == null) {
            str = "";
        }
        processForegroundHelper.g(str);
        ReceiverDispatchHelper.n();
        FileObserverHelper.h();
        ContentObserverHelper.f();
    }
}
