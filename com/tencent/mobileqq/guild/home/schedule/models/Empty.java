package com.tencent.mobileqq.guild.home.schedule.models;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0015\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u001d\u0010\u0005\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0002H\u00c6\u0001J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\t\u0010\t\u001a\u00020\bH\u00d6\u0001J\u0013\u0010\f\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u00d6\u0003R\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0004\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u0010\u0010\u000fR\u001a\u0010\u0014\u001a\u00020\b8\u0016X\u0096D\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0019\u001a\u00020\u00068\u0016X\u0096D\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u001c\u001a\u00020\u00028\u0016X\u0096D\u00a2\u0006\f\n\u0004\b\u001a\u0010\r\u001a\u0004\b\u001b\u0010\u000f\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/guild/home/schedule/models/b;", "Lcom/tencent/mobileqq/guild/home/schedule/models/d;", "", "isAdmin", "newStyle", "b", "", "toString", "", "hashCode", "", "other", "equals", "Z", "d", "()Z", "c", "I", "getType", "()I", "type", "e", "Ljava/lang/String;", "getText", "()Ljava/lang/String;", "text", "f", "a", "isToday", "<init>", "(ZZ)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.home.schedule.models.b, reason: from toString */
/* loaded from: classes13.dex */
public final /* data */ class Empty implements d {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isAdmin;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean newStyle;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int type;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String text;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final boolean isToday;

    public Empty(boolean z16, boolean z17) {
        this.isAdmin = z16;
        this.newStyle = z17;
        this.type = 4;
        this.text = "Empty";
    }

    @Override // com.tencent.mobileqq.guild.home.schedule.models.d
    /* renamed from: a, reason: from getter */
    public boolean getIsToday() {
        return this.isToday;
    }

    @NotNull
    public final Empty b(boolean isAdmin, boolean newStyle) {
        return new Empty(isAdmin, newStyle);
    }

    /* renamed from: c, reason: from getter */
    public final boolean getNewStyle() {
        return this.newStyle;
    }

    /* renamed from: d, reason: from getter */
    public final boolean getIsAdmin() {
        return this.isAdmin;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Empty)) {
            return false;
        }
        Empty empty = (Empty) other;
        if (this.isAdmin == empty.isAdmin && this.newStyle == empty.newStyle) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.guild.home.schedule.models.d
    @NotNull
    public String getText() {
        return this.text;
    }

    @Override // com.tencent.mobileqq.guild.home.schedule.models.d
    public int getType() {
        return this.type;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z16 = this.isAdmin;
        int i3 = 1;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int i16 = r06 * 31;
        boolean z17 = this.newStyle;
        if (!z17) {
            i3 = z17 ? 1 : 0;
        }
        return i16 + i3;
    }

    @NotNull
    public String toString() {
        return "Empty(isAdmin=" + this.isAdmin + ", newStyle=" + this.newStyle + ")";
    }

    public /* synthetic */ Empty(boolean z16, boolean z17, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(z16, (i3 & 2) != 0 ? false : z17);
    }
}
