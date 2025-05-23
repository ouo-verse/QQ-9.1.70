package com.qzone.reborn.albumx.qzonex.bean.initbean;

import com.qzone.reborn.albumx.qzonex.base.QZAlbumxInitBean;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0004R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0007\"\u0004\b\u0017\u0010\u0004R\u001a\u0010\u0018\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0007\"\u0004\b\u001a\u0010\u0004\u00a8\u0006\u001b"}, d2 = {"Lcom/qzone/reborn/albumx/qzonex/bean/initbean/QZAlbumxAnswerCheckPageInitBean;", "Lcom/qzone/reborn/albumx/qzonex/base/QZAlbumxInitBean;", "uin", "", "(Ljava/lang/String;)V", "albumId", "getAlbumId", "()Ljava/lang/String;", "setAlbumId", IProfileCardConst.KEY_FROM_TYPE, "", "getFromType", "()I", "setFromType", "(I)V", "jumpExtData", "", "getJumpExtData", "()Ljava/lang/Object;", "setJumpExtData", "(Ljava/lang/Object;)V", "ownerUid", "getOwnerUid", "setOwnerUid", "ownerUin", "getOwnerUin", "setOwnerUin", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class QZAlbumxAnswerCheckPageInitBean extends QZAlbumxInitBean {
    private String albumId;
    private int fromType;
    private Object jumpExtData;
    private String ownerUid;
    private String ownerUin;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZAlbumxAnswerCheckPageInitBean(String uin) {
        super(uin);
        Intrinsics.checkNotNullParameter(uin, "uin");
        this.albumId = "";
        this.ownerUin = "";
        this.ownerUid = "";
    }

    public final String getAlbumId() {
        return this.albumId;
    }

    public final int getFromType() {
        return this.fromType;
    }

    public final Object getJumpExtData() {
        return this.jumpExtData;
    }

    public final String getOwnerUid() {
        return this.ownerUid;
    }

    public final String getOwnerUin() {
        return this.ownerUin;
    }

    public final void setAlbumId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.albumId = str;
    }

    public final void setFromType(int i3) {
        this.fromType = i3;
    }

    public final void setJumpExtData(Object obj) {
        this.jumpExtData = obj;
    }

    public final void setOwnerUid(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.ownerUid = str;
    }

    public final void setOwnerUin(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.ownerUin = str;
    }
}
