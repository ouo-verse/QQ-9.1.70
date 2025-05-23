package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.bean;

import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.mobileqq.profilecard.bussiness.qzone.BaseProfileQZoneComponent;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0018\u001a\u00020\u0019R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonPhotoInfo;", "", "()V", "albumId", "", "getAlbumId", "()Ljava/lang/String;", "setAlbumId", "(Ljava/lang/String;)V", AEEditorConstants.ALBUMNAME, "getAlbumName", "setAlbumName", QAdVrReportParams.ParamKey.MEDIA, "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonStMedia;", "getMedia", "()Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonStMedia;", "setMedia", "(Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonStMedia;)V", "owner", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonStUser;", "getOwner", "()Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonStUser;", "setOwner", "(Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonStUser;)V", BaseProfileQZoneComponent.KEY_IS_VIDEO, "", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class CommonPhotoInfo {
    public static final int $stable = 8;
    private String albumId = "";
    private String albumName = "";
    private CommonStUser owner = new CommonStUser();
    private CommonStMedia media = new CommonStMedia();

    public final String getAlbumId() {
        return this.albumId;
    }

    public final String getAlbumName() {
        return this.albumName;
    }

    public final CommonStMedia getMedia() {
        return this.media;
    }

    public final CommonStUser getOwner() {
        return this.owner;
    }

    public final boolean isVideo() {
        CommonStMedia commonStMedia = this.media;
        if (commonStMedia != null) {
            return commonStMedia.isVideo();
        }
        return false;
    }

    public final void setAlbumId(String str) {
        this.albumId = str;
    }

    public final void setAlbumName(String str) {
        this.albumName = str;
    }

    public final void setMedia(CommonStMedia commonStMedia) {
        this.media = commonStMedia;
    }

    public final void setOwner(CommonStUser commonStUser) {
        this.owner = commonStUser;
    }
}
