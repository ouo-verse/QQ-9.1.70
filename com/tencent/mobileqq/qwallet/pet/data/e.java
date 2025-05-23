package com.tencent.mobileqq.qwallet.pet.data;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0004\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0002\u0012\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001b\u0012\b\u0010!\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\"\u0010#J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\t\u0010\fR\u0017\u0010\u0014\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0018\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0019\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\n\u001a\u0004\b\u0010\u0010\fR\u001f\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001b8\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u001d\u001a\u0004\b\u0019\u0010\u001eR\u0019\u0010!\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b \u0010\n\u001a\u0004\b\u000e\u0010\f\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/qwallet/pet/data/e;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "petType", "b", "actionType", "c", "Z", "f", "()Z", "isDefault", "I", "getRepeatCount", "()I", "repeatCount", "e", "petDownloadUrl", "", "Lcom/tencent/mobileqq/qwallet/pet/data/k;", "Ljava/util/List;", "()Ljava/util/List;", "subPetActionBaseList", "g", "clothDownloadUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZILjava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final /* data */ class e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String petType;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String actionType;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final boolean isDefault;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int repeatCount;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String petDownloadUrl;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final List<k> subPetActionBaseList;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String clothDownloadUrl;

    public e(@NotNull String petType, @NotNull String actionType, boolean z16, int i3, @Nullable String str, @Nullable List<k> list, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(petType, "petType");
        Intrinsics.checkNotNullParameter(actionType, "actionType");
        this.petType = petType;
        this.actionType = actionType;
        this.isDefault = z16;
        this.repeatCount = i3;
        this.petDownloadUrl = str;
        this.subPetActionBaseList = list;
        this.clothDownloadUrl = str2;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getActionType() {
        return this.actionType;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final String getClothDownloadUrl() {
        return this.clothDownloadUrl;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final String getPetDownloadUrl() {
        return this.petDownloadUrl;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getPetType() {
        return this.petType;
    }

    @Nullable
    public final List<k> e() {
        return this.subPetActionBaseList;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof e)) {
            return false;
        }
        e eVar = (e) other;
        if (Intrinsics.areEqual(this.petType, eVar.petType) && Intrinsics.areEqual(this.actionType, eVar.actionType) && this.isDefault == eVar.isDefault && this.repeatCount == eVar.repeatCount && Intrinsics.areEqual(this.petDownloadUrl, eVar.petDownloadUrl) && Intrinsics.areEqual(this.subPetActionBaseList, eVar.subPetActionBaseList) && Intrinsics.areEqual(this.clothDownloadUrl, eVar.clothDownloadUrl)) {
            return true;
        }
        return false;
    }

    /* renamed from: f, reason: from getter */
    public final boolean getIsDefault() {
        return this.isDefault;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3 = ((this.petType.hashCode() * 31) + this.actionType.hashCode()) * 31;
        boolean z16 = this.isDefault;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        int i16 = (((hashCode3 + i3) * 31) + this.repeatCount) * 31;
        String str = this.petDownloadUrl;
        int i17 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i18 = (i16 + hashCode) * 31;
        List<k> list = this.subPetActionBaseList;
        if (list == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = list.hashCode();
        }
        int i19 = (i18 + hashCode2) * 31;
        String str2 = this.clothDownloadUrl;
        if (str2 != null) {
            i17 = str2.hashCode();
        }
        return i19 + i17;
    }

    @NotNull
    public String toString() {
        return this.petType + "-" + this.actionType + " isDefault=" + this.isDefault + " " + this.subPetActionBaseList;
    }
}
