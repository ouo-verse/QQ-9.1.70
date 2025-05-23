package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.bean;

import com.tencent.aelight.camera.constants.AEEditorConstants;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\b\"\u0004\b\u001e\u0010\n\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonAlbumBatchBean;", "", "batchInfo", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonBatchInfo;", "(Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonBatchInfo;)V", "albumId", "", "getAlbumId", "()Ljava/lang/String;", "setAlbumId", "(Ljava/lang/String;)V", AEEditorConstants.ALBUMNAME, "getAlbumName", "setAlbumName", "bannerInfo", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonBatchInfoBanner;", "getBannerInfo", "()Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonBatchInfoBanner;", "setBannerInfo", "(Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonBatchInfoBanner;)V", "getBatchInfo", "()Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonBatchInfo;", "commonExt", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonStCommonExt;", "getCommonExt", "()Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonStCommonExt;", "setCommonExt", "(Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonStCommonExt;)V", "timeId", "getTimeId", "setTimeId", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class CommonAlbumBatchBean {
    public static final int $stable = 8;
    private final CommonBatchInfo batchInfo;
    private CommonStCommonExt commonExt;
    private String timeId = "";
    private String albumId = "";
    private String albumName = "";
    private CommonBatchInfoBanner bannerInfo = new CommonBatchInfoBanner();

    public CommonAlbumBatchBean(CommonBatchInfo commonBatchInfo) {
        this.batchInfo = commonBatchInfo;
    }

    public final String getAlbumId() {
        return this.albumId;
    }

    public final String getAlbumName() {
        return this.albumName;
    }

    public final CommonBatchInfoBanner getBannerInfo() {
        return this.bannerInfo;
    }

    public final CommonBatchInfo getBatchInfo() {
        return this.batchInfo;
    }

    public final CommonStCommonExt getCommonExt() {
        return this.commonExt;
    }

    public final String getTimeId() {
        return this.timeId;
    }

    public final void setAlbumId(String str) {
        this.albumId = str;
    }

    public final void setAlbumName(String str) {
        this.albumName = str;
    }

    public final void setBannerInfo(CommonBatchInfoBanner commonBatchInfoBanner) {
        this.bannerInfo = commonBatchInfoBanner;
    }

    public final void setCommonExt(CommonStCommonExt commonStCommonExt) {
        this.commonExt = commonStCommonExt;
    }

    public final void setTimeId(String str) {
        this.timeId = str;
    }
}
