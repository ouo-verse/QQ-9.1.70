package com.tencent.mobileqq.vas.social.record;

import android.os.Bundle;
import com.tencent.state.square.data.RecordSource;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001a\u00a2\u0006\u0004\b \u0010!J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0013\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR$\u0010\u0016\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u000b\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR$\u0010\u0019\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u000b\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR$\u0010\u001f\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u001b\u001a\u0004\b\n\u0010\u001c\"\u0004\b\u001d\u0010\u001e\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/vas/social/record/g;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/state/square/data/RecordSource;", "a", "Lcom/tencent/state/square/data/RecordSource;", "c", "()Lcom/tencent/state/square/data/RecordSource;", tl.h.F, "(Lcom/tencent/state/square/data/RecordSource;)V", "localMp4", "b", "g", "localCover", "e", "j", "serviceMp4", "d", "i", "serviceCover", "Landroid/os/Bundle;", "Landroid/os/Bundle;", "()Landroid/os/Bundle;", "f", "(Landroid/os/Bundle;)V", "extra", "<init>", "(Lcom/tencent/state/square/data/RecordSource;Lcom/tencent/state/square/data/RecordSource;Lcom/tencent/state/square/data/RecordSource;Lcom/tencent/state/square/data/RecordSource;Landroid/os/Bundle;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.vas.social.record.g, reason: from toString */
/* loaded from: classes35.dex */
public final /* data */ class RecordStepProduct {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private RecordSource localMp4;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private RecordSource localCover;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private RecordSource serviceMp4;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private RecordSource serviceCover;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private Bundle extra;

    public RecordStepProduct() {
        this(null, null, null, null, null, 31, null);
    }

    /* renamed from: a, reason: from getter */
    public final Bundle getExtra() {
        return this.extra;
    }

    /* renamed from: b, reason: from getter */
    public final RecordSource getLocalCover() {
        return this.localCover;
    }

    /* renamed from: c, reason: from getter */
    public final RecordSource getLocalMp4() {
        return this.localMp4;
    }

    /* renamed from: d, reason: from getter */
    public final RecordSource getServiceCover() {
        return this.serviceCover;
    }

    /* renamed from: e, reason: from getter */
    public final RecordSource getServiceMp4() {
        return this.serviceMp4;
    }

    public final void f(Bundle bundle) {
        this.extra = bundle;
    }

    public final void g(RecordSource recordSource) {
        this.localCover = recordSource;
    }

    public final void h(RecordSource recordSource) {
        this.localMp4 = recordSource;
    }

    public int hashCode() {
        RecordSource recordSource = this.localMp4;
        int hashCode = (recordSource == null ? 0 : recordSource.hashCode()) * 31;
        RecordSource recordSource2 = this.localCover;
        int hashCode2 = (hashCode + (recordSource2 == null ? 0 : recordSource2.hashCode())) * 31;
        RecordSource recordSource3 = this.serviceMp4;
        int hashCode3 = (hashCode2 + (recordSource3 == null ? 0 : recordSource3.hashCode())) * 31;
        RecordSource recordSource4 = this.serviceCover;
        int hashCode4 = (hashCode3 + (recordSource4 == null ? 0 : recordSource4.hashCode())) * 31;
        Bundle bundle = this.extra;
        return hashCode4 + (bundle != null ? bundle.hashCode() : 0);
    }

    public final void i(RecordSource recordSource) {
        this.serviceCover = recordSource;
    }

    public final void j(RecordSource recordSource) {
        this.serviceMp4 = recordSource;
    }

    public String toString() {
        return "RecordStepProduct(localMp4=" + this.localMp4 + ", localCover=" + this.localCover + ", serviceMp4=" + this.serviceMp4 + ", serviceCover=" + this.serviceCover + ", extra=" + this.extra + ")";
    }

    public RecordStepProduct(RecordSource recordSource, RecordSource recordSource2, RecordSource recordSource3, RecordSource recordSource4, Bundle bundle) {
        this.localMp4 = recordSource;
        this.localCover = recordSource2;
        this.serviceMp4 = recordSource3;
        this.serviceCover = recordSource4;
        this.extra = bundle;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RecordStepProduct)) {
            return false;
        }
        RecordStepProduct recordStepProduct = (RecordStepProduct) other;
        return Intrinsics.areEqual(this.localMp4, recordStepProduct.localMp4) && Intrinsics.areEqual(this.localCover, recordStepProduct.localCover) && Intrinsics.areEqual(this.serviceMp4, recordStepProduct.serviceMp4) && Intrinsics.areEqual(this.serviceCover, recordStepProduct.serviceCover) && Intrinsics.areEqual(this.extra, recordStepProduct.extra);
    }

    public /* synthetic */ RecordStepProduct(RecordSource recordSource, RecordSource recordSource2, RecordSource recordSource3, RecordSource recordSource4, Bundle bundle, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : recordSource, (i3 & 2) != 0 ? null : recordSource2, (i3 & 4) != 0 ? null : recordSource3, (i3 & 8) != 0 ? null : recordSource4, (i3 & 16) != 0 ? null : bundle);
    }
}
