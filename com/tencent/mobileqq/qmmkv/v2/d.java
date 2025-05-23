package com.tencent.mobileqq.qmmkv.v2;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/qmmkv/v2/d;", "Lcom/tencent/mobileqq/qmmkv/v2/b;", "", "mmapId", "", "withAccount", "d", "", "maxSize", "<init>", "(J)V", "library_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes16.dex */
public final class d extends b {
    public d(long j3) {
        super(j3);
    }

    @Override // com.tencent.mobileqq.qmmkv.v2.b, com.tencent.mobileqq.qmmkv.v2.k
    @NotNull
    public String d(@NotNull String mmapId, boolean withAccount) {
        Intrinsics.checkNotNullParameter(mmapId, "mmapId");
        if (withAccount) {
            return mmapId + "@123";
        }
        return mmapId;
    }
}
