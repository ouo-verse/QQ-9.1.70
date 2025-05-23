package com.tencent.mobileqq.config.square;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001a\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011R\u001a\u0010\u0014\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0015\u0010\u0011R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/config/square/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "id", "J", "c", "()J", "title", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "icon", "b", "bigIcon", "a", "showInStudyMode", "Ljava/lang/Boolean;", "d", "()Ljava/lang/Boolean;", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.config.square.b, reason: from toString */
/* loaded from: classes10.dex */
public final /* data */ class SquareOnlineStatusItem {

    @SerializedName("big_icon")
    @NotNull
    private final String bigIcon;

    @SerializedName("icon")
    @NotNull
    private final String icon;

    @SerializedName("id")
    private final long id;

    @SerializedName("showInStudyMode")
    @Nullable
    private final Boolean showInStudyMode;

    @SerializedName("title")
    @NotNull
    private final String title;

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getBigIcon() {
        return this.bigIcon;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getIcon() {
        return this.icon;
    }

    /* renamed from: c, reason: from getter */
    public final long getId() {
        return this.id;
    }

    @Nullable
    /* renamed from: d, reason: from getter */
    public final Boolean getShowInStudyMode() {
        return this.showInStudyMode;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SquareOnlineStatusItem)) {
            return false;
        }
        SquareOnlineStatusItem squareOnlineStatusItem = (SquareOnlineStatusItem) other;
        if (this.id == squareOnlineStatusItem.id && Intrinsics.areEqual(this.title, squareOnlineStatusItem.title) && Intrinsics.areEqual(this.icon, squareOnlineStatusItem.icon) && Intrinsics.areEqual(this.bigIcon, squareOnlineStatusItem.bigIcon) && Intrinsics.areEqual(this.showInStudyMode, squareOnlineStatusItem.showInStudyMode)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int a16 = ((((((androidx.fragment.app.a.a(this.id) * 31) + this.title.hashCode()) * 31) + this.icon.hashCode()) * 31) + this.bigIcon.hashCode()) * 31;
        Boolean bool = this.showInStudyMode;
        if (bool == null) {
            hashCode = 0;
        } else {
            hashCode = bool.hashCode();
        }
        return a16 + hashCode;
    }

    @NotNull
    public String toString() {
        return "SquareOnlineStatusItem(id=" + this.id + ", title=" + this.title + ", icon=" + this.icon + ", bigIcon=" + this.bigIcon + ", showInStudyMode=" + this.showInStudyMode + ")";
    }
}
