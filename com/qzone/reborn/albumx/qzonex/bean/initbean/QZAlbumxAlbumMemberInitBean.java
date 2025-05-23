package com.qzone.reborn.albumx.qzonex.bean.initbean;

import com.qzone.reborn.albumx.qzonex.base.QZAlbumxInitBean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0004R\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\u0004R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0007\"\u0004\b\u0014\u0010\u0004\u00a8\u0006\u0015"}, d2 = {"Lcom/qzone/reborn/albumx/qzonex/bean/initbean/QZAlbumxAlbumMemberInitBean;", "Lcom/qzone/reborn/albumx/qzonex/base/QZAlbumxInitBean;", "uin", "", "(Ljava/lang/String;)V", "albumId", "getAlbumId", "()Ljava/lang/String;", "setAlbumId", "creatorUin", "getCreatorUin", "setCreatorUin", "pageType", "", "getPageType", "()I", "setPageType", "(I)V", "shareAlbumOwnerUin", "getShareAlbumOwnerUin", "setShareAlbumOwnerUin", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class QZAlbumxAlbumMemberInitBean extends QZAlbumxInitBean {
    private String albumId;
    private String creatorUin;
    private int pageType;
    private String shareAlbumOwnerUin;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZAlbumxAlbumMemberInitBean(String uin) {
        super(uin);
        Intrinsics.checkNotNullParameter(uin, "uin");
        this.albumId = "";
        this.creatorUin = "";
        this.shareAlbumOwnerUin = "";
        this.pageType = 1;
    }

    public final String getAlbumId() {
        return this.albumId;
    }

    public final String getCreatorUin() {
        return this.creatorUin;
    }

    public final int getPageType() {
        return this.pageType;
    }

    public final String getShareAlbumOwnerUin() {
        return this.shareAlbumOwnerUin;
    }

    public final void setAlbumId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.albumId = str;
    }

    public final void setCreatorUin(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.creatorUin = str;
    }

    public final void setPageType(int i3) {
        this.pageType = i3;
    }

    public final void setShareAlbumOwnerUin(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.shareAlbumOwnerUin = str;
    }
}
