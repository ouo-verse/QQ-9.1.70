package com.tencent.rdelivery;

import android.content.Context;
import com.tencent.bugly.common.labels.VersionLabelWrapper;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.raft.standard.task.IRTask;
import com.tencent.rdelivery.net.b;
import com.tencent.rdelivery.util.c;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/rdelivery/RDelivery$fetchSDKSpecificConfig$1", "Lcom/tencent/raft/standard/task/IRTask$Task;", "", TencentLocation.RUN_MODE, "rdelivery_nonCommercialRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class RDelivery$fetchSDKSpecificConfig$1 extends IRTask.Task {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ Context f364114d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ int f364115e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ String f364116f;
    final /* synthetic */ RDelivery this$0;

    @Override // java.lang.Runnable
    public void run() {
        a aVar;
        b.Companion companion = b.INSTANCE;
        if (companion.g(this.f364114d, this.f364115e, this.this$0.setting)) {
            c cVar = this.this$0.logger;
            if (cVar != null) {
                c.b(cVar, VersionLabelWrapper.SHIPLY_VERSION_LABEL_KEY, "fetchSDKSpecificConfig return for req limited", false, 4, null);
                return;
            }
            return;
        }
        companion.f(this.f364114d, this.this$0.setting);
        b a16 = companion.a(this.f364116f, this.this$0.setting, null);
        aVar = this.this$0.dependencyInjector;
        companion.b(a16, aVar.getNetInterface(), this.this$0.setting);
    }
}
