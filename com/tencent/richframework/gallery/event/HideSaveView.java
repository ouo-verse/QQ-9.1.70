package com.tencent.richframework.gallery.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010\u000b\u001a\u00020\u0005H\u00c6\u0003J\u001f\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\r\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u00d6\u0003J\t\u0010\u0010\u001a\u00020\u0011H\u00d6\u0001J\t\u0010\u0012\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0007R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/richframework/gallery/event/HideSaveView;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "mediaId", "", "isHide", "", "(Ljava/lang/String;Z)V", "()Z", "getMediaId", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "qq-layer-kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
public final /* data */ class HideSaveView extends SimpleBaseEvent {
    private final boolean isHide;

    @Nullable
    private final String mediaId;

    public HideSaveView(@Nullable String str, boolean z16) {
        this.mediaId = str;
        this.isHide = z16;
    }

    public static /* synthetic */ HideSaveView copy$default(HideSaveView hideSaveView, String str, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = hideSaveView.mediaId;
        }
        if ((i3 & 2) != 0) {
            z16 = hideSaveView.isHide;
        }
        return hideSaveView.copy(str, z16);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getMediaId() {
        return this.mediaId;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getIsHide() {
        return this.isHide;
    }

    @NotNull
    public final HideSaveView copy(@Nullable String mediaId, boolean isHide) {
        return new HideSaveView(mediaId, isHide);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HideSaveView)) {
            return false;
        }
        HideSaveView hideSaveView = (HideSaveView) other;
        if (Intrinsics.areEqual(this.mediaId, hideSaveView.mediaId) && this.isHide == hideSaveView.isHide) {
            return true;
        }
        return false;
    }

    @Nullable
    public final String getMediaId() {
        return this.mediaId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        String str = this.mediaId;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i3 = hashCode * 31;
        boolean z16 = this.isHide;
        int i16 = z16;
        if (z16 != 0) {
            i16 = 1;
        }
        return i3 + i16;
    }

    public final boolean isHide() {
        return this.isHide;
    }

    @NotNull
    public String toString() {
        return "HideSaveView(mediaId=" + this.mediaId + ", isHide=" + this.isHide + ")";
    }
}
