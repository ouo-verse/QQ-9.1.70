package com.tencent.mobileqq.qwallet.pet.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0019\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/qwallet/pet/data/c;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "defaultResource", "<init>", "(Ljava/lang/String;)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.qwallet.pet.data.c, reason: from toString */
/* loaded from: classes16.dex */
public final /* data */ class FilamentDefaultResource {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String defaultResource;

    public FilamentDefaultResource(@Nullable String str) {
        this.defaultResource = str;
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final String getDefaultResource() {
        return this.defaultResource;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof FilamentDefaultResource) && Intrinsics.areEqual(this.defaultResource, ((FilamentDefaultResource) other).defaultResource)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        String str = this.defaultResource;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    @NotNull
    public String toString() {
        return "FilamentDefaultResource(defaultResource=" + this.defaultResource + ")";
    }
}
