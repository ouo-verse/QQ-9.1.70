package com.qzone.reborn.albumx.common.bean;

import com.qzone.reborn.albumx.common.convert.bean.CommonAlbumInfo;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\r\u0018\u0000 \u00142\u00020\u0001:\u0001\u0015B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0013\u0010\bR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000f\u00a8\u0006\u0016"}, d2 = {"Lcom/qzone/reborn/albumx/common/bean/CommonAlbumListBean;", "Ljava/io/Serializable;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumInfo;", "albumInfo", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumInfo;", "getAlbumInfo", "()Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumInfo;", "setAlbumInfo", "(Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumInfo;)V", "", "itemType", "I", "getItemType", "()I", "setItemType", "(I)V", "albumPosition", "getAlbumPosition", "setAlbumPosition", "<init>", "Companion", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class CommonAlbumListBean implements Serializable {
    public static final int SUB_TYPE_ADD_ALBUM = 2;
    public static final int SUB_TYPE_AI_TIME_MACHINE = 3;
    public static final int SUB_TYPE_HEADER_ALBUM = 1;
    public static final int SUB_TYPE_NORMAL_ALBUM = 0;
    private CommonAlbumInfo albumInfo;
    private int albumPosition;
    private int itemType;

    public CommonAlbumListBean(CommonAlbumInfo albumInfo) {
        Intrinsics.checkNotNullParameter(albumInfo, "albumInfo");
        this.albumInfo = albumInfo;
    }

    public final CommonAlbumInfo getAlbumInfo() {
        return this.albumInfo;
    }

    public final int getAlbumPosition() {
        return this.albumPosition;
    }

    public final int getItemType() {
        return this.itemType;
    }

    public final void setAlbumInfo(CommonAlbumInfo commonAlbumInfo) {
        Intrinsics.checkNotNullParameter(commonAlbumInfo, "<set-?>");
        this.albumInfo = commonAlbumInfo;
    }

    public final void setAlbumPosition(int i3) {
        this.albumPosition = i3;
    }

    public final void setItemType(int i3) {
        this.itemType = i3;
    }
}
