package com.tencent.sqshow.zootopia.avatar.filament.anim;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u0010\u0010\fR\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\t\u0010\fR\u001d\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001d\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0016\u001a\u0004\b\u0015\u0010\u0018\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/sqshow/zootopia/avatar/filament/anim/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "idleHeadAnimPathMale", "b", "idleBodyAnimPathMale", "c", "idleHeadAnimPathFemale", "idleBodyAnimPathFemale", "", "Lcom/tencent/sqshow/zootopia/avatar/filament/anim/a;", "e", "Ljava/util/List;", "f", "()Ljava/util/List;", "randomAnimPathMale", "randomAnimPathFemale", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.sqshow.zootopia.avatar.filament.anim.b, reason: from toString */
/* loaded from: classes34.dex */
public final /* data */ class HandHeldItem {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final String idleHeadAnimPathMale;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final String idleBodyAnimPathMale;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final String idleHeadAnimPathFemale;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final String idleBodyAnimPathFemale;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final List<AnimPath> randomAnimPathMale;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private final List<AnimPath> randomAnimPathFemale;

    public HandHeldItem(String idleHeadAnimPathMale, String idleBodyAnimPathMale, String idleHeadAnimPathFemale, String idleBodyAnimPathFemale, List<AnimPath> randomAnimPathMale, List<AnimPath> randomAnimPathFemale) {
        Intrinsics.checkNotNullParameter(idleHeadAnimPathMale, "idleHeadAnimPathMale");
        Intrinsics.checkNotNullParameter(idleBodyAnimPathMale, "idleBodyAnimPathMale");
        Intrinsics.checkNotNullParameter(idleHeadAnimPathFemale, "idleHeadAnimPathFemale");
        Intrinsics.checkNotNullParameter(idleBodyAnimPathFemale, "idleBodyAnimPathFemale");
        Intrinsics.checkNotNullParameter(randomAnimPathMale, "randomAnimPathMale");
        Intrinsics.checkNotNullParameter(randomAnimPathFemale, "randomAnimPathFemale");
        this.idleHeadAnimPathMale = idleHeadAnimPathMale;
        this.idleBodyAnimPathMale = idleBodyAnimPathMale;
        this.idleHeadAnimPathFemale = idleHeadAnimPathFemale;
        this.idleBodyAnimPathFemale = idleBodyAnimPathFemale;
        this.randomAnimPathMale = randomAnimPathMale;
        this.randomAnimPathFemale = randomAnimPathFemale;
    }

    /* renamed from: a, reason: from getter */
    public final String getIdleBodyAnimPathFemale() {
        return this.idleBodyAnimPathFemale;
    }

    /* renamed from: b, reason: from getter */
    public final String getIdleBodyAnimPathMale() {
        return this.idleBodyAnimPathMale;
    }

    /* renamed from: c, reason: from getter */
    public final String getIdleHeadAnimPathFemale() {
        return this.idleHeadAnimPathFemale;
    }

    /* renamed from: d, reason: from getter */
    public final String getIdleHeadAnimPathMale() {
        return this.idleHeadAnimPathMale;
    }

    public final List<AnimPath> e() {
        return this.randomAnimPathFemale;
    }

    public final List<AnimPath> f() {
        return this.randomAnimPathMale;
    }

    public int hashCode() {
        return (((((((((this.idleHeadAnimPathMale.hashCode() * 31) + this.idleBodyAnimPathMale.hashCode()) * 31) + this.idleHeadAnimPathFemale.hashCode()) * 31) + this.idleBodyAnimPathFemale.hashCode()) * 31) + this.randomAnimPathMale.hashCode()) * 31) + this.randomAnimPathFemale.hashCode();
    }

    public String toString() {
        return "HandHeldItem(idleHeadAnimPathMale=" + this.idleHeadAnimPathMale + ", idleBodyAnimPathMale=" + this.idleBodyAnimPathMale + ", idleHeadAnimPathFemale=" + this.idleHeadAnimPathFemale + ", idleBodyAnimPathFemale=" + this.idleBodyAnimPathFemale + ", randomAnimPathMale=" + this.randomAnimPathMale + ", randomAnimPathFemale=" + this.randomAnimPathFemale + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HandHeldItem)) {
            return false;
        }
        HandHeldItem handHeldItem = (HandHeldItem) other;
        return Intrinsics.areEqual(this.idleHeadAnimPathMale, handHeldItem.idleHeadAnimPathMale) && Intrinsics.areEqual(this.idleBodyAnimPathMale, handHeldItem.idleBodyAnimPathMale) && Intrinsics.areEqual(this.idleHeadAnimPathFemale, handHeldItem.idleHeadAnimPathFemale) && Intrinsics.areEqual(this.idleBodyAnimPathFemale, handHeldItem.idleBodyAnimPathFemale) && Intrinsics.areEqual(this.randomAnimPathMale, handHeldItem.randomAnimPathMale) && Intrinsics.areEqual(this.randomAnimPathFemale, handHeldItem.randomAnimPathFemale);
    }
}
