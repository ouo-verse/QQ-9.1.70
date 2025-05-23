package com.qzone.reborn.intimate.bean.init;

import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0018\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010'\u001a\u00020\u0004H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001a\u0010\u0018\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001a\u0010\u001b\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0012\"\u0004\b\u001d\u0010\u0014R\u001a\u0010\u001e\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR\u001a\u0010!\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0012\"\u0004\b#\u0010\u0014R\u001a\u0010$\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0012\"\u0004\b&\u0010\u0014\u00a8\u0006("}, d2 = {"Lcom/qzone/reborn/intimate/bean/init/QZoneIntimateAlbumDetailInitBean;", "Lcom/qzone/reborn/intimate/bean/init/QZoneIntimateInitBean;", "()V", "albumId", "", "getAlbumId", "()Ljava/lang/String;", "setAlbumId", "(Ljava/lang/String;)V", "batchId", "", "getBatchId", "()J", "setBatchId", "(J)V", "clickMediaPos", "", "getClickMediaPos", "()I", "setClickMediaPos", "(I)V", "dataRepoKey", "getDataRepoKey", "setDataRepoKey", "memberUid", "getMemberUid", "setMemberUid", QFSSearchBaseRequest.EXTRA_KEY_SEARCH_TYPE, "getSearchType", "setSearchType", "spaceId", "getSpaceId", "setSpaceId", "spaceType", "getSpaceType", "setSpaceType", "viewModelHashCode", "getViewModelHashCode", "setViewModelHashCode", "toString", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class QZoneIntimateAlbumDetailInitBean extends QZoneIntimateInitBean {
    private long batchId;
    private int clickMediaPos;
    private int searchType;
    private int spaceType;
    private int viewModelHashCode;
    private String spaceId = "";
    private String albumId = "";
    private String memberUid = "";
    private String dataRepoKey = "";

    public final String getAlbumId() {
        return this.albumId;
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

    public final String getMemberUid() {
        return this.memberUid;
    }

    public final int getSearchType() {
        return this.searchType;
    }

    public final String getSpaceId() {
        return this.spaceId;
    }

    public final int getSpaceType() {
        return this.spaceType;
    }

    public final int getViewModelHashCode() {
        return this.viewModelHashCode;
    }

    public final void setAlbumId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.albumId = str;
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

    public final void setMemberUid(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.memberUid = str;
    }

    public final void setSearchType(int i3) {
        this.searchType = i3;
    }

    public final void setSpaceId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.spaceId = str;
    }

    public final void setSpaceType(int i3) {
        this.spaceType = i3;
    }

    public final void setViewModelHashCode(int i3) {
        this.viewModelHashCode = i3;
    }

    public String toString() {
        return "QZoneIntimateAlbumDetailInitBean(searchType=" + this.searchType + ", spaceId='" + this.spaceId + "', albumId='" + this.albumId + "', spaceType='" + this.spaceType + "', batchId=" + this.batchId + ", memberUid=" + this.memberUid + ",  viewModelHashCode=" + this.viewModelHashCode + ")";
    }
}
