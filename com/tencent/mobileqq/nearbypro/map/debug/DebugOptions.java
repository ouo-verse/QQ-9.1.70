package com.tencent.mobileqq.nearbypro.map.debug;

import com.tencent.mobileqq.utils.httputils.HttpMsg;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0001\u00a2\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u0014\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0010\u001a\u0004\b\t\u0010\u0011\"\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/map/debug/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "b", "()I", "setMType", "(I)V", HttpMsg.MTYPE, "Ljava/lang/Object;", "()Ljava/lang/Object;", "setMObject", "(Ljava/lang/Object;)V", "mObject", "<init>", "(ILjava/lang/Object;)V", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.nearbypro.map.debug.b, reason: from toString */
/* loaded from: classes15.dex */
public final /* data */ class DebugOptions {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private int mType;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private Object mObject;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public DebugOptions() {
        this(0, r0, 3, r0);
        DefaultConstructorMarker defaultConstructorMarker = null;
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final Object getMObject() {
        return this.mObject;
    }

    /* renamed from: b, reason: from getter */
    public final int getMType() {
        return this.mType;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DebugOptions)) {
            return false;
        }
        DebugOptions debugOptions = (DebugOptions) other;
        if (this.mType == debugOptions.mType && Intrinsics.areEqual(this.mObject, debugOptions.mObject)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int i3 = this.mType * 31;
        Object obj = this.mObject;
        if (obj == null) {
            hashCode = 0;
        } else {
            hashCode = obj.hashCode();
        }
        return i3 + hashCode;
    }

    @NotNull
    public String toString() {
        return "DebugOptions(mType=" + this.mType + ", mObject=" + this.mObject + ")";
    }

    public DebugOptions(int i3, @Nullable Object obj) {
        this.mType = i3;
        this.mObject = obj;
    }

    public /* synthetic */ DebugOptions(int i3, Object obj, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? 0 : i3, (i16 & 2) != 0 ? null : obj);
    }
}
