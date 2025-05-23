package com.tencent.mobileqq.zplan.authorize.impl.checker.mod;

import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.data.ZootopiaEnterParams;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000f\u001a\u00020\t\u0012\u0006\u0010\u0014\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000f\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000eR\u0017\u0010\u0014\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/zplan/authorize/impl/checker/mod/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/mobileqq/zootopia/data/ZootopiaEnterParams;", "a", "Lcom/tencent/mobileqq/zootopia/data/ZootopiaEnterParams;", "()Lcom/tencent/mobileqq/zootopia/data/ZootopiaEnterParams;", "c", "(Lcom/tencent/mobileqq/zootopia/data/ZootopiaEnterParams;)V", "enterParams", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "b", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "()Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "source", "<init>", "(Lcom/tencent/mobileqq/zootopia/data/ZootopiaEnterParams;Lcom/tencent/mobileqq/zootopia/ZootopiaSource;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.zplan.authorize.impl.checker.mod.a, reason: from toString */
/* loaded from: classes35.dex */
public final /* data */ class EnterModCheckRequest {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private ZootopiaEnterParams enterParams;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final ZootopiaSource source;

    public EnterModCheckRequest(ZootopiaEnterParams enterParams, ZootopiaSource source) {
        Intrinsics.checkNotNullParameter(enterParams, "enterParams");
        Intrinsics.checkNotNullParameter(source, "source");
        this.enterParams = enterParams;
        this.source = source;
    }

    /* renamed from: a, reason: from getter */
    public final ZootopiaEnterParams getEnterParams() {
        return this.enterParams;
    }

    /* renamed from: b, reason: from getter */
    public final ZootopiaSource getSource() {
        return this.source;
    }

    public final void c(ZootopiaEnterParams zootopiaEnterParams) {
        Intrinsics.checkNotNullParameter(zootopiaEnterParams, "<set-?>");
        this.enterParams = zootopiaEnterParams;
    }

    public int hashCode() {
        return (this.enterParams.hashCode() * 31) + this.source.hashCode();
    }

    public String toString() {
        return "EnterModCheckRequest(enterParams=" + this.enterParams + ", source=" + this.source + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EnterModCheckRequest)) {
            return false;
        }
        EnterModCheckRequest enterModCheckRequest = (EnterModCheckRequest) other;
        return Intrinsics.areEqual(this.enterParams, enterModCheckRequest.enterParams) && Intrinsics.areEqual(this.source, enterModCheckRequest.source);
    }
}
