package com.tencent.mobileqq.qwallet.pet.data;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0007\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u0011\u0012\u0006\u0010\u0019\u001a\u00020\u0002\u0012\u0006\u0010\u001c\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u0010\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\r\u0010\u000fR\u001d\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0019\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\n\u001a\u0004\b\u0018\u0010\u000bR\u0017\u0010\u001c\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\n\u001a\u0004\b\u001b\u0010\u000b\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/qwallet/pet/data/g;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "type", "b", "Z", "()Z", "isDefault", "", "c", "Ljava/util/List;", "getSupportActions", "()Ljava/util/List;", "supportActions", "d", "getEntrancePicSmall", "entrancePicSmall", "e", "getEntrancePicBig", "entrancePicBig", "<init>", "(Ljava/lang/String;ZLjava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.qwallet.pet.data.g, reason: from toString */
/* loaded from: classes16.dex */
public final /* data */ class PetInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String type;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isDefault;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final List<String> supportActions;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String entrancePicSmall;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String entrancePicBig;

    public PetInfo(@NotNull String type, boolean z16, @NotNull List<String> supportActions, @NotNull String entrancePicSmall, @NotNull String entrancePicBig) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(supportActions, "supportActions");
        Intrinsics.checkNotNullParameter(entrancePicSmall, "entrancePicSmall");
        Intrinsics.checkNotNullParameter(entrancePicBig, "entrancePicBig");
        this.type = type;
        this.isDefault = z16;
        this.supportActions = supportActions;
        this.entrancePicSmall = entrancePicSmall;
        this.entrancePicBig = entrancePicBig;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getIsDefault() {
        return this.isDefault;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PetInfo)) {
            return false;
        }
        PetInfo petInfo = (PetInfo) other;
        if (Intrinsics.areEqual(this.type, petInfo.type) && this.isDefault == petInfo.isDefault && Intrinsics.areEqual(this.supportActions, petInfo.supportActions) && Intrinsics.areEqual(this.entrancePicSmall, petInfo.entrancePicSmall) && Intrinsics.areEqual(this.entrancePicBig, petInfo.entrancePicBig)) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.type.hashCode() * 31;
        boolean z16 = this.isDefault;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return ((((((hashCode + i3) * 31) + this.supportActions.hashCode()) * 31) + this.entrancePicSmall.hashCode()) * 31) + this.entrancePicBig.hashCode();
    }

    @NotNull
    public String toString() {
        return "PetInfo(type=" + this.type + ", isDefault=" + this.isDefault + ", supportActions=" + this.supportActions + ", entrancePicSmall=" + this.entrancePicSmall + ", entrancePicBig=" + this.entrancePicBig + ")";
    }
}
