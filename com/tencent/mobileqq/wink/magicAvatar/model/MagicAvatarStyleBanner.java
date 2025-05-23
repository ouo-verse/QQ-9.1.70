package com.tencent.mobileqq.wink.magicAvatar.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\u000bR\u0017\u0010\u0010\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\r\u0010\u000b\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/wink/magicAvatar/model/d;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "id", "b", "c", "pic", "name", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.wink.magicAvatar.model.d, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class MagicAvatarStyleBanner {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String id;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String pic;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String name;

    public MagicAvatarStyleBanner(@NotNull String id5, @NotNull String pic, @NotNull String name) {
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(pic, "pic");
        Intrinsics.checkNotNullParameter(name, "name");
        this.id = id5;
        this.pic = pic;
        this.name = name;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getId() {
        return this.id;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getPic() {
        return this.pic;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MagicAvatarStyleBanner)) {
            return false;
        }
        MagicAvatarStyleBanner magicAvatarStyleBanner = (MagicAvatarStyleBanner) other;
        if (Intrinsics.areEqual(this.id, magicAvatarStyleBanner.id) && Intrinsics.areEqual(this.pic, magicAvatarStyleBanner.pic) && Intrinsics.areEqual(this.name, magicAvatarStyleBanner.name)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((this.id.hashCode() * 31) + this.pic.hashCode()) * 31) + this.name.hashCode();
    }

    @NotNull
    public String toString() {
        return "MagicAvatarStyleBanner(id=" + this.id + ", pic=" + this.pic + ", name=" + this.name + ")";
    }
}
