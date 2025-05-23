package com.qzone.preview.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u00a8\u0006\u000e"}, d2 = {"Lcom/qzone/preview/event/QZoneAlbumLayerSelectPhotoEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "lloc", "", "isSelected", "", "photoIndex", "", "(Ljava/lang/String;ZI)V", "()Z", "getLloc", "()Ljava/lang/String;", "getPhotoIndex", "()I", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes39.dex */
public final class QZoneAlbumLayerSelectPhotoEvent extends SimpleBaseEvent {
    private final boolean isSelected;
    private final String lloc;
    private final int photoIndex;

    public /* synthetic */ QZoneAlbumLayerSelectPhotoEvent(String str, boolean z16, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, z16, (i16 & 4) != 0 ? -1 : i3);
    }

    public final String getLloc() {
        return this.lloc;
    }

    public final int getPhotoIndex() {
        return this.photoIndex;
    }

    /* renamed from: isSelected, reason: from getter */
    public final boolean getIsSelected() {
        return this.isSelected;
    }

    public QZoneAlbumLayerSelectPhotoEvent(String lloc, boolean z16, int i3) {
        Intrinsics.checkNotNullParameter(lloc, "lloc");
        this.lloc = lloc;
        this.isSelected = z16;
        this.photoIndex = i3;
    }
}
