package com.tencent.richframework.gallery.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0005H\u00c6\u0003J\u001f\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u00d6\u0003J\t\u0010\u0004\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\u0012\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/richframework/gallery/event/SaveToAlbumEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "mediaId", "", "hashCode", "", "(Ljava/lang/String;I)V", "getHashCode", "()I", "getMediaId", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "toString", "qq-layer-kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
public final /* data */ class SaveToAlbumEvent extends SimpleBaseEvent {
    private final int hashCode;

    @Nullable
    private final String mediaId;

    public SaveToAlbumEvent(@Nullable String str, int i3) {
        this.mediaId = str;
        this.hashCode = i3;
    }

    public static /* synthetic */ SaveToAlbumEvent copy$default(SaveToAlbumEvent saveToAlbumEvent, String str, int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            str = saveToAlbumEvent.mediaId;
        }
        if ((i16 & 2) != 0) {
            i3 = saveToAlbumEvent.hashCode;
        }
        return saveToAlbumEvent.copy(str, i3);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getMediaId() {
        return this.mediaId;
    }

    /* renamed from: component2, reason: from getter */
    public final int getHashCode() {
        return this.hashCode;
    }

    @NotNull
    public final SaveToAlbumEvent copy(@Nullable String mediaId, int hashCode) {
        return new SaveToAlbumEvent(mediaId, hashCode);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SaveToAlbumEvent)) {
            return false;
        }
        SaveToAlbumEvent saveToAlbumEvent = (SaveToAlbumEvent) other;
        if (Intrinsics.areEqual(this.mediaId, saveToAlbumEvent.mediaId) && this.hashCode == saveToAlbumEvent.hashCode) {
            return true;
        }
        return false;
    }

    public final int getHashCode() {
        return this.hashCode;
    }

    @Nullable
    public final String getMediaId() {
        return this.mediaId;
    }

    public int hashCode() {
        int hashCode;
        String str = this.mediaId;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        return (hashCode * 31) + this.hashCode;
    }

    @NotNull
    public String toString() {
        return "SaveToAlbumEvent(mediaId=" + this.mediaId + ", hashCode=" + this.hashCode + ")";
    }
}
