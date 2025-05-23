package com.tencent.rdelivery.reshub.api;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011R$\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R$\u0010\u000f\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/rdelivery/reshub/api/r;", "", "", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "setBusinessSetName", "(Ljava/lang/String;)V", "businessSetName", "Lcom/tencent/rdelivery/reshub/api/s;", "b", "Lcom/tencent/rdelivery/reshub/api/s;", "()Lcom/tencent/rdelivery/reshub/api/s;", "c", "(Lcom/tencent/rdelivery/reshub/api/s;)V", "resHubParams", "<init>", "()V", "reshub_debug"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String businessSetName;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ResHubParams resHubParams;

    @Nullable
    /* renamed from: a, reason: from getter */
    public final String getBusinessSetName() {
        return this.businessSetName;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final ResHubParams getResHubParams() {
        return this.resHubParams;
    }

    public final void c(@Nullable ResHubParams resHubParams) {
        this.resHubParams = resHubParams;
    }
}
