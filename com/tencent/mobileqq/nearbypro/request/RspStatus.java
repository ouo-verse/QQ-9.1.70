package com.tencent.mobileqq.nearbypro.request;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\b\b\u0002\u0010\u000e\u001a\u00020\t\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0013\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\n\u0010\u0012R\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0010\u0010\u0016R\u0011\u0010\u0019\u001a\u00020\u00078F\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/request/d;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/mobileqq/nearbypro/request/RspStatusType;", "a", "Lcom/tencent/mobileqq/nearbypro/request/RspStatusType;", "d", "()Lcom/tencent/mobileqq/nearbypro/request/RspStatusType;", "type", "", "b", "J", "()J", "code", "c", "Ljava/lang/String;", "()Ljava/lang/String;", "msg", "()Z", "success", "<init>", "(Lcom/tencent/mobileqq/nearbypro/request/RspStatusType;JLjava/lang/String;)V", "qq_nearby_pro_base_kit_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.nearbypro.request.d, reason: from toString */
/* loaded from: classes15.dex */
public final /* data */ class RspStatus {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final RspStatusType type;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final long code;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String msg;

    public RspStatus() {
        this(null, 0L, null, 7, null);
    }

    /* renamed from: a, reason: from getter */
    public final long getCode() {
        return this.code;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final String getMsg() {
        return this.msg;
    }

    public final boolean c() {
        return this.type.getSuccess();
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final RspStatusType getType() {
        return this.type;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RspStatus)) {
            return false;
        }
        RspStatus rspStatus = (RspStatus) other;
        if (this.type == rspStatus.type && this.code == rspStatus.code && Intrinsics.areEqual(this.msg, rspStatus.msg)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = ((this.type.hashCode() * 31) + androidx.fragment.app.a.a(this.code)) * 31;
        String str = this.msg;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        return hashCode2 + hashCode;
    }

    @NotNull
    public String toString() {
        return "RspStatus(type=" + this.type + ", code=" + this.code + ", msg=" + this.msg + ")";
    }

    public RspStatus(@NotNull RspStatusType type, long j3, @Nullable String str) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.type = type;
        this.code = j3;
        this.msg = str;
    }

    public /* synthetic */ RspStatus(RspStatusType rspStatusType, long j3, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? RspStatusType.SUCCESS : rspStatusType, (i3 & 2) != 0 ? 0L : j3, (i3 & 4) != 0 ? null : str);
    }
}
