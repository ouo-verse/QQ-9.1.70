package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data;

import com.tencent.aelight.camera.constants.AEEditorConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u001fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R \u0010$\u001a\b\u0012\u0004\u0012\u00020&0%X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001a\u0010+\u001a\u00020\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0015\"\u0004\b-\u0010\u0017\u00a8\u0006."}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonCellMedia;", "", "()V", "albumCover", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonImage;", "getAlbumCover", "()Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonImage;", "setAlbumCover", "(Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonImage;)V", "albumId", "", "getAlbumId", "()Ljava/lang/String;", "setAlbumId", "(Ljava/lang/String;)V", AEEditorConstants.ALBUMNAME, "getAlbumName", "setAlbumName", "albumUploadNum", "", "getAlbumUploadNum", "()I", "setAlbumUploadNum", "(I)V", "batchId", "", "getBatchId", "()J", "setBatchId", "(J)V", "longPicsBrowsingMode", "", "getLongPicsBrowsingMode", "()Z", "setLongPicsBrowsingMode", "(Z)V", "mediaItems", "", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonMedia;", "getMediaItems", "()Ljava/util/List;", "setMediaItems", "(Ljava/util/List;)V", "uploadNum", "getUploadNum", "setUploadNum", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class CommonCellMedia {
    public static final int $stable = 8;
    private CommonImage albumCover;
    private String albumId;
    private String albumName;
    private int albumUploadNum;
    private long batchId;
    private boolean longPicsBrowsingMode;
    private List<CommonMedia> mediaItems;
    private int uploadNum;

    public CommonCellMedia() {
        List<CommonMedia> emptyList;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.mediaItems = emptyList;
    }

    public final CommonImage getAlbumCover() {
        return this.albumCover;
    }

    public final String getAlbumId() {
        return this.albumId;
    }

    public final String getAlbumName() {
        return this.albumName;
    }

    public final int getAlbumUploadNum() {
        return this.albumUploadNum;
    }

    public final long getBatchId() {
        return this.batchId;
    }

    public final boolean getLongPicsBrowsingMode() {
        return this.longPicsBrowsingMode;
    }

    public final List<CommonMedia> getMediaItems() {
        return this.mediaItems;
    }

    public final int getUploadNum() {
        return this.uploadNum;
    }

    public final void setAlbumCover(CommonImage commonImage) {
        this.albumCover = commonImage;
    }

    public final void setAlbumId(String str) {
        this.albumId = str;
    }

    public final void setAlbumName(String str) {
        this.albumName = str;
    }

    public final void setAlbumUploadNum(int i3) {
        this.albumUploadNum = i3;
    }

    public final void setBatchId(long j3) {
        this.batchId = j3;
    }

    public final void setLongPicsBrowsingMode(boolean z16) {
        this.longPicsBrowsingMode = z16;
    }

    public final void setMediaItems(List<CommonMedia> list) {
        this.mediaItems = list;
    }

    public final void setUploadNum(int i3) {
        this.uploadNum = i3;
    }
}
