package com.tencent.mobileqq.zootopia.ue;

import com.tencent.mobileqq.zootopia.ZootopiaSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/zootopia/ue/d;", "", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "a", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "()Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "sourceCurrent", "<init>", "(Lcom/tencent/mobileqq/zootopia/ZootopiaSource;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final ZootopiaSource sourceCurrent;

    public d(ZootopiaSource sourceCurrent) {
        Intrinsics.checkNotNullParameter(sourceCurrent, "sourceCurrent");
        this.sourceCurrent = sourceCurrent;
    }

    /* renamed from: a, reason: from getter */
    public final ZootopiaSource getSourceCurrent() {
        return this.sourceCurrent;
    }
}
