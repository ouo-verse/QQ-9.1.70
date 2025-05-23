package com.qzone.reborn.albumx.qzonex.bean.initbean;

import com.qzone.reborn.albumx.qzonex.base.QZAlbumxInitBean;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0004R\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\u0004R\u001a\u0010\f\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0007\"\u0004\b\u000e\u0010\u0004R\u001a\u0010\u000f\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0007\"\u0004\b\u0011\u0010\u0004R\u001a\u0010\u0012\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0007\"\u0004\b\u0014\u0010\u0004R\u001a\u0010\u0015\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0007\"\u0004\b\u0017\u0010\u0004R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d\u00a8\u0006\u001e"}, d2 = {"Lcom/qzone/reborn/albumx/qzonex/bean/initbean/QZAlbumxInvitePageInitBean;", "Lcom/qzone/reborn/albumx/qzonex/base/QZAlbumxInitBean;", "uin", "", "(Ljava/lang/String;)V", "albumId", "getAlbumId", "()Ljava/lang/String;", "setAlbumId", AEEditorConstants.ALBUMNAME, "getAlbumName", "setAlbumName", "albumOwner", "getAlbumOwner", "setAlbumOwner", "from", "getFrom", "setFrom", "inviteAttachInfo", "getInviteAttachInfo", "setInviteAttachInfo", "joinAttachInfo", "getJoinAttachInfo", "setJoinAttachInfo", "pageType", "", "getPageType", "()I", "setPageType", "(I)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class QZAlbumxInvitePageInitBean extends QZAlbumxInitBean {
    private String albumId;
    private String albumName;
    private String albumOwner;
    private String from;
    private String inviteAttachInfo;
    private String joinAttachInfo;
    private int pageType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZAlbumxInvitePageInitBean(String uin) {
        super(uin);
        Intrinsics.checkNotNullParameter(uin, "uin");
        this.albumId = "";
        this.albumName = "";
        this.albumOwner = "";
        this.joinAttachInfo = "";
        this.inviteAttachInfo = "";
        this.from = "";
    }

    public final String getAlbumId() {
        return this.albumId;
    }

    public final String getAlbumName() {
        return this.albumName;
    }

    public final String getAlbumOwner() {
        return this.albumOwner;
    }

    public final String getFrom() {
        return this.from;
    }

    public final String getInviteAttachInfo() {
        return this.inviteAttachInfo;
    }

    public final String getJoinAttachInfo() {
        return this.joinAttachInfo;
    }

    public final int getPageType() {
        return this.pageType;
    }

    public final void setAlbumId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.albumId = str;
    }

    public final void setAlbumName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.albumName = str;
    }

    public final void setAlbumOwner(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.albumOwner = str;
    }

    public final void setFrom(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.from = str;
    }

    public final void setInviteAttachInfo(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.inviteAttachInfo = str;
    }

    public final void setJoinAttachInfo(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.joinAttachInfo = str;
    }

    public final void setPageType(int i3) {
        this.pageType = i3;
    }
}
