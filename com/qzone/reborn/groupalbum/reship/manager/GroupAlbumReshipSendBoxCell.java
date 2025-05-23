package com.qzone.reborn.groupalbum.reship.manager;

import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;
import com.tencent.mobileqq.vas.theme.ThemeReporter;
import com.tencent.qqnt.kernel.nativeinterface.QuoteStatus;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001e\u0010\u0015\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001e\u0010\u0018\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001e\u0010\u001e\u001a\u00020\u001f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#\u00a8\u0006$"}, d2 = {"Lcom/qzone/reborn/groupalbum/reship/manager/GroupAlbumReshipSendBoxCell;", "Lcom/tencent/component/app/common/SmartParcelable;", "()V", "albumId", "", "getAlbumId", "()Ljava/lang/String;", "setAlbumId", "(Ljava/lang/String;)V", AEEditorConstants.ALBUMNAME, "getAlbumName", "setAlbumName", "batchId", "", "getBatchId", "()J", "setBatchId", "(J)V", "coverUrl", "getCoverUrl", "setCoverUrl", "groupId", "getGroupId", "setGroupId", "status", "", ThemeReporter.BUNDLE_KEY_TASK_GET_STATUS, "()I", "setStatus", "(I)V", "unit", "Lcom/qzone/reborn/groupalbum/reship/manager/GroupAblbumReshipUnit;", "getUnit", "()Lcom/qzone/reborn/groupalbum/reship/manager/GroupAblbumReshipUnit;", "setUnit", "(Lcom/qzone/reborn/groupalbum/reship/manager/GroupAblbumReshipUnit;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class GroupAlbumReshipSendBoxCell implements SmartParcelable {

    @NeedParcel
    private long batchId;

    @NeedParcel
    private String groupId = "";

    @NeedParcel
    private String albumId = "";

    @NeedParcel
    private GroupAblbumReshipUnit unit = new GroupAblbumReshipUnit();

    @NeedParcel
    private String albumName = "";

    @NeedParcel
    private String coverUrl = "";

    @NeedParcel
    private int status = QuoteStatus.KQUOTESTATUSPROCESSING.ordinal();

    public final String getAlbumId() {
        return this.albumId;
    }

    public final String getAlbumName() {
        return this.albumName;
    }

    public final long getBatchId() {
        return this.batchId;
    }

    public final String getCoverUrl() {
        return this.coverUrl;
    }

    public final String getGroupId() {
        return this.groupId;
    }

    public final int getStatus() {
        return this.status;
    }

    public final GroupAblbumReshipUnit getUnit() {
        return this.unit;
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

    public final void setCoverUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.coverUrl = str;
    }

    public final void setGroupId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.groupId = str;
    }

    public final void setStatus(int i3) {
        this.status = i3;
    }

    public final void setUnit(GroupAblbumReshipUnit groupAblbumReshipUnit) {
        Intrinsics.checkNotNullParameter(groupAblbumReshipUnit, "<set-?>");
        this.unit = groupAblbumReshipUnit;
    }
}
