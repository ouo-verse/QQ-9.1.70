package com.qzone.reborn.groupalbum.bean.init;

import com.tencent.aelight.camera.constants.AEEditorConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u0004R\u001a\u0010\u000f\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u0004R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\b\"\u0004\b\u001a\u0010\nR\u001a\u0010\u001b\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\r\"\u0004\b\u001d\u0010\u0004\u00a8\u0006\u001e"}, d2 = {"Lcom/qzone/reborn/groupalbum/bean/init/GroupAlbumAlbumDetailInitBean;", "Lcom/qzone/reborn/groupalbum/bean/init/GroupAlbumInitBean;", "groupId", "", "(Ljava/lang/String;)V", "action", "", "getAction", "()I", "setAction", "(I)V", "albumId", "getAlbumId", "()Ljava/lang/String;", "setAlbumId", AEEditorConstants.ALBUMNAME, "getAlbumName", "setAlbumName", "batchId", "", "getBatchId", "()J", "setBatchId", "(J)V", "clickMediaPos", "getClickMediaPos", "setClickMediaPos", "dataRepoKey", "getDataRepoKey", "setDataRepoKey", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class GroupAlbumAlbumDetailInitBean extends GroupAlbumInitBean {
    private int action;
    private String albumId;
    private String albumName;
    private long batchId;
    private int clickMediaPos;
    private String dataRepoKey;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GroupAlbumAlbumDetailInitBean(String groupId) {
        super(groupId);
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        this.albumId = "";
        this.albumName = "";
        this.action = -1;
        this.dataRepoKey = "";
    }

    public final int getAction() {
        return this.action;
    }

    public final String getAlbumId() {
        return this.albumId;
    }

    public final String getAlbumName() {
        return this.albumName;
    }

    public final long getBatchId() {
        return this.batchId;
    }

    public final int getClickMediaPos() {
        return this.clickMediaPos;
    }

    public final String getDataRepoKey() {
        return this.dataRepoKey;
    }

    public final void setAction(int i3) {
        this.action = i3;
    }

    public final void setAlbumId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.albumId = str;
    }

    public final void setAlbumName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.albumName = str;
    }

    public final void setBatchId(long j3) {
        this.batchId = j3;
    }

    public final void setClickMediaPos(int i3) {
        this.clickMediaPos = i3;
    }

    public final void setDataRepoKey(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.dataRepoKey = str;
    }
}
