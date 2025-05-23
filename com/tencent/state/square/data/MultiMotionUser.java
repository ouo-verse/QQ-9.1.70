package com.tencent.state.square.data;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000e\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J)\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0015\u001a\u00020\u0016H\u00d6\u0001J\t\u0010\u0017\u001a\u00020\u0003H\u00d6\u0001R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\b\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/state/square/data/MultiMotionUser;", "", "uin", "", "toUin", "selectUin", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getSelectUin", "()Ljava/lang/String;", "setSelectUin", "(Ljava/lang/String;)V", "getToUin", "setToUin", "getUin", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "square_base_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes26.dex */
public final /* data */ class MultiMotionUser {

    @Nullable
    private String selectUin;

    @NotNull
    private String toUin;

    @NotNull
    private final String uin;

    public MultiMotionUser(@NotNull String uin, @NotNull String toUin, @Nullable String str) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(toUin, "toUin");
        this.uin = uin;
        this.toUin = toUin;
        this.selectUin = str;
    }

    public static /* synthetic */ MultiMotionUser copy$default(MultiMotionUser multiMotionUser, String str, String str2, String str3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = multiMotionUser.uin;
        }
        if ((i3 & 2) != 0) {
            str2 = multiMotionUser.toUin;
        }
        if ((i3 & 4) != 0) {
            str3 = multiMotionUser.selectUin;
        }
        return multiMotionUser.copy(str, str2, str3);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getUin() {
        return this.uin;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getToUin() {
        return this.toUin;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getSelectUin() {
        return this.selectUin;
    }

    @NotNull
    public final MultiMotionUser copy(@NotNull String uin, @NotNull String toUin, @Nullable String selectUin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(toUin, "toUin");
        return new MultiMotionUser(uin, toUin, selectUin);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof MultiMotionUser) {
                MultiMotionUser multiMotionUser = (MultiMotionUser) other;
                if (!Intrinsics.areEqual(this.uin, multiMotionUser.uin) || !Intrinsics.areEqual(this.toUin, multiMotionUser.toUin) || !Intrinsics.areEqual(this.selectUin, multiMotionUser.selectUin)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @Nullable
    public final String getSelectUin() {
        return this.selectUin;
    }

    @NotNull
    public final String getToUin() {
        return this.toUin;
    }

    @NotNull
    public final String getUin() {
        return this.uin;
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
        String str2 = this.toUin;
        if (str2 != null) {
            i16 = str2.hashCode();
        } else {
            i16 = 0;
        }
        int i19 = (i18 + i16) * 31;
        String str3 = this.selectUin;
        if (str3 != null) {
            i17 = str3.hashCode();
        }
        return i19 + i17;
    }

    public final void setSelectUin(@Nullable String str) {
        this.selectUin = str;
    }

    public final void setToUin(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.toUin = str;
    }

    @NotNull
    public String toString() {
        return "MultiMotionUser(uin=" + this.uin + ", toUin=" + this.toUin + ", selectUin=" + this.selectUin + ")";
    }

    public /* synthetic */ MultiMotionUser(String str, String str2, String str3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i3 & 4) != 0 ? null : str3);
    }
}
