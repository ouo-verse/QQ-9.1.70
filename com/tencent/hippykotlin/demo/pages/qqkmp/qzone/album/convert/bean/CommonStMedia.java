package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.bean;

import com.qzone.album.data.model.PhotoCategorySinglePicInfo;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.CommonBeanExtKt;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.CommonPicUtils;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.enumtype.CommonEnumPhotoSpec;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.mobileqq.profilecard.bussiness.qzone.BaseProfileQZoneComponent;
import com.tencent.weiyun.transmission.db.JobDbManager;
import java.util.ArrayList;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\\\u0010]J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0006\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0002J\u0006\u0010\b\u001a\u00020\u0002J\u0006\u0010\n\u001a\u00020\tR\"\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0013\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u001a\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010 \u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R$\u0010&\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010!\u001a\u0004\b'\u0010#\"\u0004\b(\u0010%R\"\u0010*\u001a\u00020)8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\"\u00100\u001a\u00020)8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b0\u0010+\u001a\u0004\b1\u0010-\"\u0004\b2\u0010/R\"\u00103\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b3\u0010\r\u001a\u0004\b4\u0010\u000f\"\u0004\b5\u0010\u0011R\"\u00107\u001a\u0002068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\"\u0010>\u001a\u00020=8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b>\u0010?\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR$\u0010D\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bD\u0010!\u001a\u0004\bE\u0010#\"\u0004\bF\u0010%R\"\u0010G\u001a\u00020)8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bG\u0010+\u001a\u0004\bH\u0010-\"\u0004\bI\u0010/R\"\u0010K\u001a\u00020J8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bK\u0010L\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\"\u0010Q\u001a\u00020)8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bQ\u0010+\u001a\u0004\bR\u0010-\"\u0004\bS\u0010/R2\u0010V\u001a\u0012\u0012\u0004\u0012\u00020\u000b0Tj\b\u0012\u0004\u0012\u00020\u000b`U8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bV\u0010W\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[\u00a8\u0006^"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonStMedia;", "", "", "getMedialLoc", "", BaseProfileQZoneComponent.KEY_IS_VIDEO, "getMediaUrl", "getVideoCoverUrl", "getMediaLLoc", "Lcom/tencent/kuikly/core/nvi/serialization/json/e;", "toJSONObject", "", "type", "I", "getType", "()I", "setType", "(I)V", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonStImage;", "image", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonStImage;", "getImage", "()Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonStImage;", "setImage", "(Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonStImage;)V", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonStVideo;", "video", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonStVideo;", "getVideo", "()Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonStVideo;", "setVideo", "(Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonStVideo;)V", "desc", "Ljava/lang/String;", "getDesc", "()Ljava/lang/String;", "setDesc", "(Ljava/lang/String;)V", JobDbManager.TBL_UPLOAD, "getUpload", "setUpload", "", "batchId", "J", "getBatchId", "()J", "setBatchId", "(J)V", PhotoCategorySinglePicInfo.UPLOAD_TIME, "getUploadTime", "setUploadTime", "uploadOrder", "getUploadOrder", "setUploadOrder", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonStMediaLike;", "like", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonStMediaLike;", "getLike", "()Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonStMediaLike;", "setLike", "(Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonStMediaLike;)V", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonStMediaComment;", "comment", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonStMediaComment;", "getComment", "()Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonStMediaComment;", "setComment", "(Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonStMediaComment;)V", "uploadUserName", "getUploadUserName", "setUploadUserName", "shootTime", "getShootTime", "setShootTime", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonStLBS;", "lbs", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonStLBS;", "getLbs", "()Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonStLBS;", "setLbs", "(Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonStLBS;)V", "linkId", "getLinkId", "setLinkId", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "opMask", "Ljava/util/ArrayList;", "getOpMask", "()Ljava/util/ArrayList;", "setOpMask", "(Ljava/util/ArrayList;)V", "<init>", "()V", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class CommonStMedia {
    public static final int $stable = 8;
    private long batchId;
    private long linkId;
    private long shootTime;
    private int type;
    private int uploadOrder;
    private long uploadTime;
    private CommonStImage image = new CommonStImage();
    private CommonStVideo video = new CommonStVideo();
    private String desc = "";
    private String upload = "";
    private CommonStMediaLike like = new CommonStMediaLike();
    private CommonStMediaComment comment = new CommonStMediaComment();
    private String uploadUserName = "";
    private CommonStLBS lbs = new CommonStLBS();
    private ArrayList<Integer> opMask = new ArrayList<>();

    public final long getBatchId() {
        return this.batchId;
    }

    public final CommonStMediaComment getComment() {
        return this.comment;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final CommonStImage getImage() {
        return this.image;
    }

    public final CommonStLBS getLbs() {
        return this.lbs;
    }

    public final CommonStMediaLike getLike() {
        return this.like;
    }

    public final long getLinkId() {
        return this.linkId;
    }

    public final String getMediaLLoc() {
        if (isVideo()) {
            return this.video.getCover().getLloc();
        }
        return this.image.getLloc();
    }

    public final String getMediaUrl() {
        String url;
        if (CommonBeanExtKt.isVideo(this)) {
            return this.video.getUrl();
        }
        CommonStPicUrl picUrlByPhotoSpec = CommonPicUtils.INSTANCE.getPicUrlByPhotoSpec(this.image.getPhotoUrl(), CommonEnumPhotoSpec.PHOTO_SPEC_ORIGIN);
        return (picUrlByPhotoSpec == null || (url = picUrlByPhotoSpec.getUrl()) == null) ? "" : url;
    }

    public final String getMedialLoc() {
        if (CommonBeanExtKt.isVideo(this)) {
            return this.video.getCover().getLloc();
        }
        return this.image.getLloc();
    }

    public final ArrayList<Integer> getOpMask() {
        return this.opMask;
    }

    public final long getShootTime() {
        return this.shootTime;
    }

    public final int getType() {
        return this.type;
    }

    public final String getUpload() {
        return this.upload;
    }

    public final int getUploadOrder() {
        return this.uploadOrder;
    }

    public final long getUploadTime() {
        return this.uploadTime;
    }

    public final String getUploadUserName() {
        return this.uploadUserName;
    }

    public final CommonStVideo getVideo() {
        return this.video;
    }

    public final String getVideoCoverUrl() {
        CommonStPicUrl picUrlByPhotoSpec;
        String url;
        return (!CommonBeanExtKt.isVideo(this) || (picUrlByPhotoSpec = CommonPicUtils.INSTANCE.getPicUrlByPhotoSpec(this.video.getCover().getPhotoUrl(), CommonEnumPhotoSpec.PHOTO_SPEC_ORIGIN)) == null || (url = picUrlByPhotoSpec.getUrl()) == null) ? "" : url;
    }

    public final boolean isVideo() {
        return CommonBeanExtKt.isVideo(this);
    }

    public final void setBatchId(long j3) {
        this.batchId = j3;
    }

    public final void setComment(CommonStMediaComment commonStMediaComment) {
        this.comment = commonStMediaComment;
    }

    public final void setDesc(String str) {
        this.desc = str;
    }

    public final void setImage(CommonStImage commonStImage) {
        this.image = commonStImage;
    }

    public final void setLbs(CommonStLBS commonStLBS) {
        this.lbs = commonStLBS;
    }

    public final void setLike(CommonStMediaLike commonStMediaLike) {
        this.like = commonStMediaLike;
    }

    public final void setLinkId(long j3) {
        this.linkId = j3;
    }

    public final void setOpMask(ArrayList<Integer> arrayList) {
        this.opMask = arrayList;
    }

    public final void setShootTime(long j3) {
        this.shootTime = j3;
    }

    public final void setType(int i3) {
        this.type = i3;
    }

    public final void setUpload(String str) {
        this.upload = str;
    }

    public final void setUploadOrder(int i3) {
        this.uploadOrder = i3;
    }

    public final void setUploadTime(long j3) {
        this.uploadTime = j3;
    }

    public final void setUploadUserName(String str) {
        this.uploadUserName = str;
    }

    public final void setVideo(CommonStVideo commonStVideo) {
        this.video = commonStVideo;
    }

    public final e toJSONObject() {
        e eVar = new e();
        eVar.t("type", this.type);
        eVar.v("image", this.image.toJSONObject());
        eVar.v("video", this.video.toJSONObject());
        eVar.v("desc", this.desc);
        eVar.v(JobDbManager.TBL_UPLOAD, this.upload);
        eVar.u("batchId", this.batchId);
        eVar.u(PhotoCategorySinglePicInfo.UPLOAD_TIME, this.uploadTime);
        eVar.t("uploadOrder", this.uploadOrder);
        eVar.v("like", this.like.toJSONObject());
        eVar.v("comment", this.comment.toJSONObject());
        eVar.v("uploadUserName", this.uploadUserName);
        eVar.u("shootTime", this.shootTime);
        eVar.v("lbs", this.lbs.toJSONObject());
        eVar.u("linkId", this.linkId);
        eVar.v("opMask", this.opMask);
        return eVar;
    }
}
