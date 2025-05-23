package com.tencent.mobileqq.guild.media.detail;

import com.tencent.mobileqq.guild.media.core.data.p;
import com.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0011\u001a\u00020\r\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u0011\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/guild/media/detail/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "()I", "type", "Lcom/tencent/mobileqq/guild/media/core/data/p;", "b", "Lcom/tencent/mobileqq/guild/media/core/data/p;", "()Lcom/tencent/mobileqq/guild/media/core/data/p;", ITVKPlayerEventListener.KEY_USER_INFO, "<init>", "(ILcom/tencent/mobileqq/guild/media/core/data/p;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.media.detail.a, reason: from toString */
/* loaded from: classes14.dex */
public final /* data */ class DetailUserListUIItem {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int type;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final p userInfo;

    public DetailUserListUIItem(int i3, @NotNull p userInfo) {
        Intrinsics.checkNotNullParameter(userInfo, "userInfo");
        this.type = i3;
        this.userInfo = userInfo;
    }

    /* renamed from: a, reason: from getter */
    public final int getType() {
        return this.type;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final p getUserInfo() {
        return this.userInfo;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DetailUserListUIItem)) {
            return false;
        }
        DetailUserListUIItem detailUserListUIItem = (DetailUserListUIItem) other;
        if (this.type == detailUserListUIItem.type && Intrinsics.areEqual(this.userInfo, detailUserListUIItem.userInfo)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.type * 31) + this.userInfo.hashCode();
    }

    @NotNull
    public String toString() {
        return "DetailUserListUIItem(type=" + this.type + ", userInfo=" + this.userInfo + ")";
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ DetailUserListUIItem(int i3, p pVar, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, pVar);
        if ((i16 & 2) != 0) {
            pVar = p.j();
            Intrinsics.checkNotNullExpressionValue(pVar, "create()");
        }
    }
}
