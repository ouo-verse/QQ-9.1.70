package com.tencent.robot.write.view;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u001b\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00018\u0000\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0004\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0006\u001a\u00020\u0005H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u0019\u0010\u0011\u001a\u0004\u0018\u00018\u00008\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/robot/write/view/b;", "T", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "name", "b", "Ljava/lang/Object;", "()Ljava/lang/Object;", "sourceData", "<init>", "(Ljava/lang/String;Ljava/lang/Object;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.robot.write.view.b, reason: from toString */
/* loaded from: classes25.dex */
public final /* data */ class SelectData<T> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String name;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final T sourceData;

    public SelectData(@NotNull String name, @Nullable T t16) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.name = name;
        this.sourceData = t16;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final T b() {
        return this.sourceData;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SelectData)) {
            return false;
        }
        SelectData selectData = (SelectData) other;
        if (Intrinsics.areEqual(this.name, selectData.name) && Intrinsics.areEqual(this.sourceData, selectData.sourceData)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = this.name.hashCode() * 31;
        T t16 = this.sourceData;
        if (t16 == null) {
            hashCode = 0;
        } else {
            hashCode = t16.hashCode();
        }
        return hashCode2 + hashCode;
    }

    @NotNull
    public String toString() {
        return "SelectData(name=" + this.name + ", sourceData=" + this.sourceData + ")";
    }
}
