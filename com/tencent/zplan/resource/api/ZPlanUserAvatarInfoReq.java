package com.tencent.zplan.resource.api;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0019\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0014\u001a\u0004\b\t\u0010\u0015R\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\u000e\u0010\f\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/zplan/resource/api/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "uin", "b", "Ljava/lang/Integer;", "c", "()Ljava/lang/Integer;", "gender", "Lgx4/a;", "Lgx4/a;", "()Lgx4/a;", "avatarCharacter", "dressKey", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Lgx4/a;Ljava/lang/String;)V", "zplan_debug"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.tencent.zplan.resource.api.b, reason: from toString */
/* loaded from: classes27.dex */
public final /* data */ class ZPlanUserAvatarInfoReq {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String uin;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final Integer gender;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final gx4.a avatarCharacter;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String dressKey;

    public ZPlanUserAvatarInfoReq() {
        this(null, null, null, null, 15, null);
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final gx4.a getAvatarCharacter() {
        return this.avatarCharacter;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final String getDressKey() {
        return this.dressKey;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final Integer getGender() {
        return this.gender;
    }

    @Nullable
    /* renamed from: d, reason: from getter */
    public final String getUin() {
        return this.uin;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof ZPlanUserAvatarInfoReq) {
                ZPlanUserAvatarInfoReq zPlanUserAvatarInfoReq = (ZPlanUserAvatarInfoReq) other;
                if (!Intrinsics.areEqual(this.uin, zPlanUserAvatarInfoReq.uin) || !Intrinsics.areEqual(this.gender, zPlanUserAvatarInfoReq.gender) || !Intrinsics.areEqual(this.avatarCharacter, zPlanUserAvatarInfoReq.avatarCharacter) || !Intrinsics.areEqual(this.dressKey, zPlanUserAvatarInfoReq.dressKey)) {
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
        int i17;
        String str = this.uin;
        int i18 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i19 = i3 * 31;
        Integer num = this.gender;
        if (num != null) {
            i16 = num.hashCode();
        } else {
            i16 = 0;
        }
        int i26 = (i19 + i16) * 31;
        gx4.a aVar = this.avatarCharacter;
        if (aVar != null) {
            i17 = aVar.hashCode();
        } else {
            i17 = 0;
        }
        int i27 = (i26 + i17) * 31;
        String str2 = this.dressKey;
        if (str2 != null) {
            i18 = str2.hashCode();
        }
        return i27 + i18;
    }

    @NotNull
    public String toString() {
        return "ZPlanUserAvatarInfoReq(uin=" + this.uin + ", gender=" + this.gender + ", avatarCharacter=" + this.avatarCharacter + ", dressKey=" + this.dressKey + ")";
    }

    public ZPlanUserAvatarInfoReq(@Nullable String str, @Nullable Integer num, @Nullable gx4.a aVar, @Nullable String str2) {
        this.uin = str;
        this.gender = num;
        this.avatarCharacter = aVar;
        this.dressKey = str2;
    }

    public /* synthetic */ ZPlanUserAvatarInfoReq(String str, Integer num, gx4.a aVar, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : str, (i3 & 2) != 0 ? null : num, (i3 & 4) != 0 ? null : aVar, (i3 & 8) != 0 ? null : str2);
    }
}
