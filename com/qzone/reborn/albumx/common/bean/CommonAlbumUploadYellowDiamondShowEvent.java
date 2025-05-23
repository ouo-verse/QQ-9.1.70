package com.qzone.reborn.albumx.common.bean;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0006\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\nH\u00d6\u0003J\t\u0010\u000b\u001a\u00020\fH\u00d6\u0001J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0005\u00a8\u0006\u000f"}, d2 = {"Lcom/qzone/reborn/albumx/common/bean/CommonAlbumUploadYellowDiamondShowEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "isShowBottom", "", "(Z)V", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final /* data */ class CommonAlbumUploadYellowDiamondShowEvent extends SimpleBaseEvent {
    private final boolean isShowBottom;

    public CommonAlbumUploadYellowDiamondShowEvent(boolean z16) {
        this.isShowBottom = z16;
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getIsShowBottom() {
        return this.isShowBottom;
    }

    public final CommonAlbumUploadYellowDiamondShowEvent copy(boolean isShowBottom) {
        return new CommonAlbumUploadYellowDiamondShowEvent(isShowBottom);
    }

    public int hashCode() {
        boolean z16 = this.isShowBottom;
        if (z16) {
            return 1;
        }
        return z16 ? 1 : 0;
    }

    public final boolean isShowBottom() {
        return this.isShowBottom;
    }

    public String toString() {
        return "CommonAlbumUploadYellowDiamondShowEvent(isShowBottom=" + this.isShowBottom + ")";
    }

    public static /* synthetic */ CommonAlbumUploadYellowDiamondShowEvent copy$default(CommonAlbumUploadYellowDiamondShowEvent commonAlbumUploadYellowDiamondShowEvent, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = commonAlbumUploadYellowDiamondShowEvent.isShowBottom;
        }
        return commonAlbumUploadYellowDiamondShowEvent.copy(z16);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof CommonAlbumUploadYellowDiamondShowEvent) && this.isShowBottom == ((CommonAlbumUploadYellowDiamondShowEvent) other).isShowBottom;
    }
}
