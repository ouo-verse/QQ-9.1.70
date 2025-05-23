package com.tencent.mobileqq.qwallet.pet.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0012\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0010\u001a\u0004\b\n\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/qwallet/pet/data/i;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/mobileqq/qwallet/pet/data/j;", "a", "Lcom/tencent/mobileqq/qwallet/pet/data/j;", "b", "()Lcom/tencent/mobileqq/qwallet/pet/data/j;", "infoBase", "Lcom/tencent/mobileqq/qwallet/pet/data/b;", "Lcom/tencent/mobileqq/qwallet/pet/data/b;", "()Lcom/tencent/mobileqq/qwallet/pet/data/b;", "downloadDetail", "<init>", "(Lcom/tencent/mobileqq/qwallet/pet/data/j;Lcom/tencent/mobileqq/qwallet/pet/data/b;)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final /* data */ class i {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final j infoBase;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final DownloadDetail downloadDetail;

    public i(@NotNull j infoBase, @NotNull DownloadDetail downloadDetail) {
        Intrinsics.checkNotNullParameter(infoBase, "infoBase");
        Intrinsics.checkNotNullParameter(downloadDetail, "downloadDetail");
        this.infoBase = infoBase;
        this.downloadDetail = downloadDetail;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final DownloadDetail getDownloadDetail() {
        return this.downloadDetail;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final j getInfoBase() {
        return this.infoBase;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof i)) {
            return false;
        }
        i iVar = (i) other;
        if (Intrinsics.areEqual(this.infoBase, iVar.infoBase) && Intrinsics.areEqual(this.downloadDetail, iVar.downloadDetail)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.infoBase.hashCode() * 31) + this.downloadDetail.hashCode();
    }

    @NotNull
    public String toString() {
        return this.infoBase + " " + this.downloadDetail;
    }
}
