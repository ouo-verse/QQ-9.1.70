package com.tencent.mobileqq.guild.home.viewmodels.header;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u000e\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\r\u0010\u000bR\u0017\u0010\u0013\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/guild/home/viewmodels/header/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "()Z", "needShowEntry", "b", "isChecked", "c", "I", "getCheckinCount", "()I", "checkinCount", "<init>", "(ZZI)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.home.viewmodels.header.a, reason: from toString */
/* loaded from: classes13.dex */
public final /* data */ class CheckinEntryInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean needShowEntry;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isChecked;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int checkinCount;

    public CheckinEntryInfo(boolean z16, boolean z17, int i3) {
        this.needShowEntry = z16;
        this.isChecked = z17;
        this.checkinCount = i3;
    }

    /* renamed from: a, reason: from getter */
    public final boolean getNeedShowEntry() {
        return this.needShowEntry;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getIsChecked() {
        return this.isChecked;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CheckinEntryInfo)) {
            return false;
        }
        CheckinEntryInfo checkinEntryInfo = (CheckinEntryInfo) other;
        if (this.needShowEntry == checkinEntryInfo.needShowEntry && this.isChecked == checkinEntryInfo.isChecked && this.checkinCount == checkinEntryInfo.checkinCount) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public int hashCode() {
        boolean z16 = this.needShowEntry;
        int i3 = 1;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int i16 = r06 * 31;
        boolean z17 = this.isChecked;
        if (!z17) {
            i3 = z17 ? 1 : 0;
        }
        return ((i16 + i3) * 31) + this.checkinCount;
    }

    @NotNull
    public String toString() {
        return "CheckinEntryInfo(needShowEntry=" + this.needShowEntry + ", isChecked=" + this.isChecked + ", checkinCount=" + this.checkinCount + ")";
    }

    public /* synthetic */ CheckinEntryInfo(boolean z16, boolean z17, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(z16, (i16 & 2) != 0 ? false : z17, (i16 & 4) != 0 ? 0 : i3);
    }
}
