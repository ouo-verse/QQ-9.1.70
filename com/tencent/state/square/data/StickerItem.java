package com.tencent.state.square.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0017\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u00a2\u0006\u0002\u0010\u000bJ\t\u0010\u0016\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\tH\u00c6\u0003J\t\u0010\u001a\u001a\u00020\tH\u00c6\u0003J;\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\tH\u00c6\u0001J\u0013\u0010\u001c\u001a\u00020\t2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001e\u001a\u00020\u0007H\u00d6\u0001J\t\u0010\u001f\u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\n\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006 "}, d2 = {"Lcom/tencent/state/square/data/StickerItem;", "", "type", "Lcom/tencent/state/square/data/StickerType;", "icon", "", "likeType", "", "readed", "", "isMe", "(Lcom/tencent/state/square/data/StickerType;Ljava/lang/String;IZZ)V", "getIcon", "()Ljava/lang/String;", "()Z", "getLikeType", "()I", "getReaded", "setReaded", "(Z)V", "getType", "()Lcom/tencent/state/square/data/StickerType;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class StickerItem {
    private final String icon;
    private final boolean isMe;
    private final int likeType;
    private boolean readed;
    private final StickerType type;

    public StickerItem(StickerType type, String icon, int i3, boolean z16, boolean z17) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(icon, "icon");
        this.type = type;
        this.icon = icon;
        this.likeType = i3;
        this.readed = z16;
        this.isMe = z17;
    }

    /* renamed from: component1, reason: from getter */
    public final StickerType getType() {
        return this.type;
    }

    /* renamed from: component2, reason: from getter */
    public final String getIcon() {
        return this.icon;
    }

    /* renamed from: component3, reason: from getter */
    public final int getLikeType() {
        return this.likeType;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getReaded() {
        return this.readed;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getIsMe() {
        return this.isMe;
    }

    public final StickerItem copy(StickerType type, String icon, int likeType, boolean readed, boolean isMe) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(icon, "icon");
        return new StickerItem(type, icon, likeType, readed, isMe);
    }

    public final String getIcon() {
        return this.icon;
    }

    public final int getLikeType() {
        return this.likeType;
    }

    public final boolean getReaded() {
        return this.readed;
    }

    public final StickerType getType() {
        return this.type;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        StickerType stickerType = this.type;
        int hashCode = (stickerType != null ? stickerType.hashCode() : 0) * 31;
        String str = this.icon;
        int hashCode2 = (((hashCode + (str != null ? str.hashCode() : 0)) * 31) + this.likeType) * 31;
        boolean z16 = this.readed;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        int i16 = (hashCode2 + i3) * 31;
        boolean z17 = this.isMe;
        return i16 + (z17 ? 1 : z17 ? 1 : 0);
    }

    public final boolean isMe() {
        return this.isMe;
    }

    public final void setReaded(boolean z16) {
        this.readed = z16;
    }

    public String toString() {
        return "StickerItem(type=" + this.type + ", icon=" + this.icon + ", likeType=" + this.likeType + ", readed=" + this.readed + ", isMe=" + this.isMe + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StickerItem)) {
            return false;
        }
        StickerItem stickerItem = (StickerItem) other;
        return Intrinsics.areEqual(this.type, stickerItem.type) && Intrinsics.areEqual(this.icon, stickerItem.icon) && this.likeType == stickerItem.likeType && this.readed == stickerItem.readed && this.isMe == stickerItem.isMe;
    }

    public static /* synthetic */ StickerItem copy$default(StickerItem stickerItem, StickerType stickerType, String str, int i3, boolean z16, boolean z17, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            stickerType = stickerItem.type;
        }
        if ((i16 & 2) != 0) {
            str = stickerItem.icon;
        }
        String str2 = str;
        if ((i16 & 4) != 0) {
            i3 = stickerItem.likeType;
        }
        int i17 = i3;
        if ((i16 & 8) != 0) {
            z16 = stickerItem.readed;
        }
        boolean z18 = z16;
        if ((i16 & 16) != 0) {
            z17 = stickerItem.isMe;
        }
        return stickerItem.copy(stickerType, str2, i17, z18, z17);
    }
}
