package com.tencent.mobileqq.guild.mainframe.create.removemember;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0086\b\u0018\u0000 \u00102\u00020\u0001:\u0001\nB\u001f\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\rR\u0017\u0010\u0016\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/guild/mainframe/create/removemember/g;", "Lcom/tencent/mobileqq/guild/mainframe/create/removemember/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "uin", "b", "d", "name", "c", "I", "e", "()I", "selectType", "<init>", "(Ljava/lang/String;Ljava/lang/String;I)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.mainframe.create.removemember.g, reason: from toString */
/* loaded from: classes14.dex */
public final /* data */ class MemberData extends a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String uin;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String name;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int selectType;

    public MemberData(@NotNull String uin, @NotNull String name, int i3) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(name, "name");
        this.uin = uin;
        this.name = name;
        this.selectType = i3;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: e, reason: from getter */
    public final int getSelectType() {
        return this.selectType;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MemberData)) {
            return false;
        }
        MemberData memberData = (MemberData) other;
        if (Intrinsics.areEqual(this.uin, memberData.uin) && Intrinsics.areEqual(this.name, memberData.name) && this.selectType == memberData.selectType) {
            return true;
        }
        return false;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final String getUin() {
        return this.uin;
    }

    public int hashCode() {
        return (((this.uin.hashCode() * 31) + this.name.hashCode()) * 31) + this.selectType;
    }

    @NotNull
    public String toString() {
        return "MemberData(uin=" + this.uin + ", name=" + this.name + ", selectType=" + this.selectType + ")";
    }
}
