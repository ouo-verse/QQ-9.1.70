package com.tencent.mobileqq.kandian.biz.video.api.impl;

import android.content.Context;
import com.tencent.mobileqq.kandian.biz.video.BandwidthMonitor;
import com.tencent.mobileqq.kandian.biz.video.api.IBandwidthMonitor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0011\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0096\u0001J\u0011\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0096\u0001\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/kandian/biz/video/api/impl/BandwidthMonitorImpl;", "Lcom/tencent/mobileqq/kandian/biz/video/api/IBandwidthMonitor;", "()V", "start", "", "context", "Landroid/content/Context;", "stop", "kandian_feature_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class BandwidthMonitorImpl implements IBandwidthMonitor {
    private final /* synthetic */ BandwidthMonitor $$delegate_0 = BandwidthMonitor.INSTANCE;

    @Override // com.tencent.mobileqq.kandian.biz.video.api.IBandwidthMonitor
    public void start(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.$$delegate_0.start(context);
    }

    @Override // com.tencent.mobileqq.kandian.biz.video.api.IBandwidthMonitor
    public void stop(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.$$delegate_0.stop(context);
    }
}
