package com.tencent.mobileqq.search.tux;

import com.tencent.mobileqq.search.model.v;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u0004\u0018\u00010\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/search/tux/g;", "Lcom/tencent/mobileqq/search/model/v;", "Lcom/tencent/mobileqq/search/tux/i;", "f", "Lcom/tencent/mobileqq/search/tux/i;", "k", "()Lcom/tencent/mobileqq/search/tux/i;", "tuxReportData", "Lcom/tencent/mobileqq/search/tux/b;", tl.h.F, "Lcom/tencent/mobileqq/search/tux/b;", "l", "()Lcom/tencent/mobileqq/search/tux/b;", "tuxStatisticIoc", "<init>", "(Lcom/tencent/mobileqq/search/tux/i;Lcom/tencent/mobileqq/search/tux/b;)V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class g extends v {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final i tuxReportData;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final b tuxStatisticIoc;

    public g(@NotNull i tuxReportData, @Nullable b bVar) {
        Intrinsics.checkNotNullParameter(tuxReportData, "tuxReportData");
        this.tuxReportData = tuxReportData;
        this.tuxStatisticIoc = bVar;
    }

    @NotNull
    /* renamed from: k, reason: from getter */
    public final i getTuxReportData() {
        return this.tuxReportData;
    }

    @Nullable
    /* renamed from: l, reason: from getter */
    public final b getTuxStatisticIoc() {
        return this.tuxStatisticIoc;
    }
}
