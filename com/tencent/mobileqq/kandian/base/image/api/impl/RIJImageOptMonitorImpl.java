package com.tencent.mobileqq.kandian.base.image.api.impl;

import com.tencent.mobileqq.kandian.base.image.RIJImageOptMonitor;
import com.tencent.mobileqq.kandian.base.image.api.IRIJImageOptMonitor;
import com.tencent.mobileqq.kandian.base.image.b;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/kandian/base/image/api/impl/RIJImageOptMonitorImpl;", "Lcom/tencent/mobileqq/kandian/base/image/api/IRIJImageOptMonitor;", "Lcom/tencent/mobileqq/kandian/base/image/b;", "imageRequest", "", "addMonitor", "<init>", "()V", "kandian_feature_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class RIJImageOptMonitorImpl implements IRIJImageOptMonitor {
    @Override // com.tencent.mobileqq.kandian.base.image.api.IRIJImageOptMonitor
    public void addMonitor(b imageRequest) {
        RIJImageOptMonitor.a(imageRequest);
    }
}
