package com.qzone.publish.business.publishqueue.common;

import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\b\u001a\u00020\u0006R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/qzone/publish/business/publishqueue/common/e;", "", "", "caseId", "", "b", "", "c", "a", "", "Ljava/util/Set;", "retryCaseIdSet", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Set<String> retryCaseIdSet = new LinkedHashSet();

    public final void a() {
        this.retryCaseIdSet.clear();
    }

    public final boolean b(String caseId) {
        Intrinsics.checkNotNullParameter(caseId, "caseId");
        return this.retryCaseIdSet.contains(caseId);
    }

    public final void c(String caseId) {
        Intrinsics.checkNotNullParameter(caseId, "caseId");
        this.retryCaseIdSet.add(caseId);
    }
}
