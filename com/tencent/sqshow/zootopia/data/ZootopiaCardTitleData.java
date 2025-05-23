package com.tencent.sqshow.zootopia.data;

import android.text.TextUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0019\u0010\u000f\u001a\u0004\u0018\u00010\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\u0010\u001a\u0004\u0018\u00010\n8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\f\u001a\u0004\b\u000b\u0010\u000e\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/sqshow/zootopia/data/e;", "", "", "c", "", "toString", "", "hashCode", "other", "equals", "Lpv4/u;", "a", "Lpv4/u;", "b", "()Lpv4/u;", "title", "moreInfo", "<init>", "(Lpv4/u;Lpv4/u;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.sqshow.zootopia.data.e, reason: from toString */
/* loaded from: classes34.dex */
public final /* data */ class ZootopiaCardTitleData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final pv4.u title;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final pv4.u moreInfo;

    public ZootopiaCardTitleData(pv4.u uVar, pv4.u uVar2) {
        this.title = uVar;
        this.moreInfo = uVar2;
    }

    /* renamed from: a, reason: from getter */
    public final pv4.u getMoreInfo() {
        return this.moreInfo;
    }

    /* renamed from: b, reason: from getter */
    public final pv4.u getTitle() {
        return this.title;
    }

    public final boolean c() {
        pv4.u uVar = this.title;
        if (TextUtils.isEmpty(uVar != null ? uVar.f427702a : null)) {
            pv4.u uVar2 = this.moreInfo;
            if (TextUtils.isEmpty(uVar2 != null ? uVar2.f427702a : null)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        pv4.u uVar = this.title;
        int hashCode = (uVar == null ? 0 : uVar.hashCode()) * 31;
        pv4.u uVar2 = this.moreInfo;
        return hashCode + (uVar2 != null ? uVar2.hashCode() : 0);
    }

    public String toString() {
        return "ZootopiaCardTitleData(title=" + this.title + ", moreInfo=" + this.moreInfo + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ZootopiaCardTitleData)) {
            return false;
        }
        ZootopiaCardTitleData zootopiaCardTitleData = (ZootopiaCardTitleData) other;
        return Intrinsics.areEqual(this.title, zootopiaCardTitleData.title) && Intrinsics.areEqual(this.moreInfo, zootopiaCardTitleData.moreInfo);
    }
}
