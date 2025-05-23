package com.tencent.ecommerce.base.share.api;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u0013\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0014\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\t\u0010\f\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/ecommerce/base/share/api/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "uin", "b", "label", "I", "d", "()I", "uinType", "guildId", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.ecommerce.base.share.api.b, reason: from toString */
/* loaded from: classes5.dex */
public final /* data */ class ECActionItemData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String uin;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String label;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int uinType;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String guildId;

    public ECActionItemData() {
        this(null, null, 0, null, 15, null);
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getGuildId() {
        return this.guildId;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getLabel() {
        return this.label;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getUin() {
        return this.uin;
    }

    /* renamed from: d, reason: from getter */
    public final int getUinType() {
        return this.uinType;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof ECActionItemData) {
                ECActionItemData eCActionItemData = (ECActionItemData) other;
                if (!Intrinsics.areEqual(this.uin, eCActionItemData.uin) || !Intrinsics.areEqual(this.label, eCActionItemData.label) || this.uinType != eCActionItemData.uinType || !Intrinsics.areEqual(this.guildId, eCActionItemData.guildId)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i3;
        int i16;
        String str = this.uin;
        int i17 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i18 = i3 * 31;
        String str2 = this.label;
        if (str2 != null) {
            i16 = str2.hashCode();
        } else {
            i16 = 0;
        }
        int i19 = (((i18 + i16) * 31) + this.uinType) * 31;
        String str3 = this.guildId;
        if (str3 != null) {
            i17 = str3.hashCode();
        }
        return i19 + i17;
    }

    @NotNull
    public String toString() {
        return "ECActionItemData(uin=" + this.uin + ", label=" + this.label + ", uinType=" + this.uinType + ", guildId=" + this.guildId + ")";
    }

    public ECActionItemData(@NotNull String str, @NotNull String str2, int i3, @NotNull String str3) {
        this.uin = str;
        this.label = str2;
        this.uinType = i3;
        this.guildId = str3;
    }

    public /* synthetic */ ECActionItemData(String str, String str2, int i3, String str3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? "" : str, (i16 & 2) != 0 ? "" : str2, (i16 & 4) != 0 ? -1 : i3, (i16 & 8) != 0 ? "" : str3);
    }
}
