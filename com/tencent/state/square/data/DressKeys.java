package com.tencent.state.square.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import oicq.wlogin_sdk.tools.util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005J\t\u0010\f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u00c6\u0001J\u0010\u0010\u000f\u001a\u00020\u00102\b\u0010\u0004\u001a\u0004\u0018\u00010\u0000J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0011\u001a\u00020\u0012H\u00d6\u0001J\b\u0010\u0013\u001a\u00020\u0003H\u0016R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/state/square/data/DressKeys;", "", "owner", "", "other", "(Ljava/lang/String;Ljava/lang/String;)V", "getOther", "()Ljava/lang/String;", "setOther", "(Ljava/lang/String;)V", "getOwner", "setOwner", "component1", "component2", "copy", "equals", "", "hashCode", "", "toString", "square_base_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes26.dex */
public final /* data */ class DressKeys {

    @NotNull
    private String other;

    @NotNull
    private String owner;

    public DressKeys(@NotNull String owner, @NotNull String other) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(other, "other");
        this.owner = owner;
        this.other = other;
    }

    public static /* synthetic */ DressKeys copy$default(DressKeys dressKeys, String str, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = dressKeys.owner;
        }
        if ((i3 & 2) != 0) {
            str2 = dressKeys.other;
        }
        return dressKeys.copy(str, str2);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getOwner() {
        return this.owner;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getOther() {
        return this.other;
    }

    @NotNull
    public final DressKeys copy(@NotNull String owner, @NotNull String other) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(other, "other");
        return new DressKeys(owner, other);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DressKeys)) {
            return false;
        }
        DressKeys dressKeys = (DressKeys) other;
        return Intrinsics.areEqual(this.owner, dressKeys.owner) && Intrinsics.areEqual(this.other, dressKeys.other);
    }

    @NotNull
    public final String getOther() {
        return this.other;
    }

    @NotNull
    public final String getOwner() {
        return this.owner;
    }

    public int hashCode() {
        int i3;
        String str = this.owner;
        int i16 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i17 = i3 * 31;
        String str2 = this.other;
        if (str2 != null) {
            i16 = str2.hashCode();
        }
        return i17 + i16;
    }

    public final void setOther(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.other = str;
    }

    public final void setOwner(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.owner = str;
    }

    @NotNull
    public String toString() {
        return this.owner + util.base64_pad_url + this.other;
    }

    public final boolean equals(@Nullable DressKeys other) {
        return other != null && Intrinsics.areEqual(this.owner, other.owner) && Intrinsics.areEqual(this.other, other.other);
    }
}
