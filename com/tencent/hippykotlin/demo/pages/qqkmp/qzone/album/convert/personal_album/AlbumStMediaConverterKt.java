package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.personal_album;

import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.bean.CommonStImage;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.bean.CommonStLBS;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.bean.CommonStMedia;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.bean.CommonStMediaComment;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.bean.CommonStMediaLike;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.bean.CommonStPicSpecUrlEntry;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.bean.CommonStPicUrl;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.bean.CommonStVideo;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.enumtype.CommonEnumMediaType;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.enumtype.CommonEnumPhotoSpec;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StImage;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StLBS;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StMedia;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StMediaComment;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StMediaLike;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StPicSpecUrlEntry;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StPicUrl;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StUser;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StVideo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0004*\u00020\u0005\u001a\n\u0010\u0006\u001a\u00020\u0007*\u00020\b\u001a\n\u0010\t\u001a\u00020\n*\u00020\u000b\u001a\n\u0010\f\u001a\u00020\r*\u00020\u000e\u001a\n\u0010\u000f\u001a\u00020\u0010*\u00020\u0011\u001a\n\u0010\u0012\u001a\u00020\u0013*\u00020\u0014\u001a\n\u0010\u0015\u001a\u00020\u0002*\u00020\u0001\u001a\n\u0010\u0016\u001a\u00020\b*\u00020\u0007\u001a\n\u0010\u0017\u001a\u00020\u000b*\u00020\n\u001a\n\u0010\u0018\u001a\u00020\u000e*\u00020\r\u001a\n\u0010\u0019\u001a\u00020\u0014*\u00020\u0013\u001a\n\u0010\u001a\u001a\u00020\u0005*\u00020\u0004\u001a\n\u0010\u001b\u001a\u00020\u0011*\u00020\u0010\u00a8\u0006\u001c"}, d2 = {"toCommonStImage", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonStImage;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StImage;", "toCommonStMedia", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonStMedia;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StMedia;", "toCommonStMediaComment", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonStMediaComment;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StMediaComment;", "toCommonStMediaLike", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonStMediaLike;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StMediaLike;", "toCommonStPicSpecUrlEntry", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonStPicSpecUrlEntry;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StPicSpecUrlEntry;", "toCommonStPicUrl", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonStPicUrl;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StPicUrl;", "toCommonStVideo", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonStVideo;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StVideo;", "toNTStImage", "toNTStMediaComment", "toNTStMediaLike", "toNTStPicSpecUrlEntry", "toNTStVideo", "toStMedia", "toStPicUrl", "qecommerce-biz_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class AlbumStMediaConverterKt {
    public static final CommonStImage toCommonStImage(StImage stImage) {
        CommonStPicUrl commonStPicUrl;
        CommonStImage commonStImage = new CommonStImage();
        String str = stImage.name;
        if (str == null) {
            str = "";
        }
        commonStImage.setName(str);
        String str2 = stImage.sloc;
        if (str2 == null) {
            str2 = "";
        }
        commonStImage.setSloc(str2);
        String str3 = stImage.lloc;
        commonStImage.setLloc(str3 != null ? str3 : "");
        Iterator<T> it = stImage.photoUrl.iterator();
        while (it.hasNext()) {
            commonStImage.getPhotoUrl().add(toCommonStPicSpecUrlEntry((StPicSpecUrlEntry) it.next()));
        }
        StPicUrl stPicUrl = stImage.defaultUrl;
        if (stPicUrl == null || (commonStPicUrl = toCommonStPicUrl(stPicUrl)) == null) {
            commonStPicUrl = new CommonStPicUrl();
        }
        commonStImage.setDefaultUrl(commonStPicUrl);
        Boolean bool = stImage.isGif;
        commonStImage.setGif(bool != null ? bool.booleanValue() : false);
        return commonStImage;
    }

    public static final CommonStMedia toCommonStMedia(StMedia stMedia) {
        CommonStImage commonStImage;
        CommonStVideo commonStVideo;
        String str;
        CommonStMediaLike commonStMediaLike;
        CommonStMediaComment commonStMediaComment;
        CommonStLBS commonStLBS;
        String str2;
        CommonStMedia commonStMedia = new CommonStMedia();
        Integer num = stMedia.type;
        boolean z16 = true;
        if (num != null && num.intValue() == 0) {
            commonStMedia.setType(CommonEnumMediaType.IMAGE.ordinal());
        } else {
            Integer num2 = stMedia.type;
            if (num2 != null && num2.intValue() == 1) {
                commonStMedia.setType(CommonEnumMediaType.VIDEO.ordinal());
            }
        }
        StImage stImage = stMedia.image;
        if (stImage == null || (commonStImage = toCommonStImage(stImage)) == null) {
            commonStImage = new CommonStImage();
        }
        commonStMedia.setImage(commonStImage);
        StVideo stVideo = stMedia.video;
        if (stVideo == null || (commonStVideo = toCommonStVideo(stVideo)) == null) {
            commonStVideo = new CommonStVideo();
        }
        commonStMedia.setVideo(commonStVideo);
        commonStMedia.setDesc(stMedia.desc);
        String str3 = stMedia.uploader;
        if (str3 != null && str3.length() != 0) {
            z16 = false;
        }
        String str4 = "";
        if (z16) {
            StUser stUser = stMedia.uploadUser;
            if (stUser == null || (str = stUser.uin) == null) {
                str = "";
            }
        } else {
            str = stMedia.uploader;
        }
        commonStMedia.setUpload(str);
        StUser stUser2 = stMedia.uploadUser;
        if (stUser2 != null && (str2 = stUser2.nick) != null) {
            str4 = str2;
        }
        commonStMedia.setUploadUserName(str4);
        Long l3 = stMedia.batchId;
        commonStMedia.setBatchId(l3 != null ? l3.longValue() : 0L);
        Long l16 = stMedia.uploadTime;
        commonStMedia.setUploadTime(l16 != null ? l16.longValue() : 0L);
        Integer num3 = stMedia.uploadOrder;
        commonStMedia.setUploadOrder(num3 != null ? num3.intValue() : 0);
        StMediaLike stMediaLike = stMedia.like;
        if (stMediaLike == null || (commonStMediaLike = toCommonStMediaLike(stMediaLike)) == null) {
            commonStMediaLike = new CommonStMediaLike();
        }
        commonStMedia.setLike(commonStMediaLike);
        StMediaComment stMediaComment = stMedia.comment;
        if (stMediaComment == null || (commonStMediaComment = toCommonStMediaComment(stMediaComment)) == null) {
            commonStMediaComment = new CommonStMediaComment();
        }
        commonStMedia.setComment(commonStMediaComment);
        Long l17 = stMedia.shootTime;
        commonStMedia.setShootTime(l17 != null ? l17.longValue() : 0L);
        StLBS stLBS = stMedia.lbs;
        if (stLBS == null || (commonStLBS = AlbumStLBSConverterKt.toCommonStLBS(stLBS)) == null) {
            commonStLBS = new CommonStLBS();
        }
        commonStMedia.setLbs(commonStLBS);
        Long l18 = stMedia.linkId;
        commonStMedia.setLinkId(l18 != null ? l18.longValue() : 0L);
        List<Integer> list = stMedia.opMask;
        Intrinsics.checkNotNull(list, "null cannot be cast to non-null type java.util.ArrayList<kotlin.Int>{ kotlin.collections.TypeAliasesKt.ArrayList<kotlin.Int> }");
        commonStMedia.setOpMask((ArrayList) list);
        return commonStMedia;
    }

    public static final CommonStMediaComment toCommonStMediaComment(StMediaComment stMediaComment) {
        CommonStMediaComment commonStMediaComment = new CommonStMediaComment();
        Integer num = stMediaComment.num;
        commonStMediaComment.setCommentNum(num != null ? num.intValue() : 0);
        return commonStMediaComment;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final CommonStMediaLike toCommonStMediaLike(StMediaLike stMediaLike) {
        CommonStMediaLike commonStMediaLike = new CommonStMediaLike();
        String str = stMediaLike.key;
        if (str == null) {
            str = "";
        }
        commonStMediaLike.setKey(str);
        Integer num = stMediaLike.num;
        commonStMediaLike.setNum(num != null ? num.intValue() : 0);
        Boolean bool = stMediaLike.liked;
        commonStMediaLike.setLiked(bool != null ? bool.booleanValue() : 0);
        return commonStMediaLike;
    }

    public static final CommonStPicSpecUrlEntry toCommonStPicSpecUrlEntry(StPicSpecUrlEntry stPicSpecUrlEntry) {
        CommonStPicUrl commonStPicUrl;
        CommonStPicSpecUrlEntry commonStPicSpecUrlEntry = new CommonStPicSpecUrlEntry();
        Integer num = stPicSpecUrlEntry.spec;
        if (num != null && num.intValue() == 0) {
            commonStPicSpecUrlEntry.setSpec(CommonEnumPhotoSpec.PHOTO_SPEC_ORIGIN.ordinal());
        } else if (num != null && num.intValue() == 1) {
            commonStPicSpecUrlEntry.setSpec(CommonEnumPhotoSpec.PHOTO_SPEC_BIG.ordinal());
        } else if (num != null && num.intValue() == 2) {
            commonStPicSpecUrlEntry.setSpec(CommonEnumPhotoSpec.PHOTO_SPEC_MEDIUM.ordinal());
        } else if (num != null && num.intValue() == 3) {
            commonStPicSpecUrlEntry.setSpec(CommonEnumPhotoSpec.PHOTO_SPEC_SMALL.ordinal());
        } else if (num != null && num.intValue() == 4) {
            commonStPicSpecUrlEntry.setSpec(CommonEnumPhotoSpec.PHOTO_SPEC_THUMB.ordinal());
        } else if (num != null && num.intValue() == 5) {
            commonStPicSpecUrlEntry.setSpec(CommonEnumPhotoSpec.PHOTO_SPEC_CURRENT.ordinal());
        } else if (num != null && num.intValue() == 6) {
            commonStPicSpecUrlEntry.setSpec(CommonEnumPhotoSpec.PHOTO_SPEC_DOWNLOAD.ordinal());
        } else {
            commonStPicSpecUrlEntry.setSpec(CommonEnumPhotoSpec.PHOTO_SPEC_ORIGIN.ordinal());
        }
        StPicUrl stPicUrl = stPicSpecUrlEntry.url;
        if (stPicUrl == null || (commonStPicUrl = toCommonStPicUrl(stPicUrl)) == null) {
            commonStPicUrl = new CommonStPicUrl();
        }
        commonStPicSpecUrlEntry.setUrl(commonStPicUrl);
        return commonStPicSpecUrlEntry;
    }

    public static final CommonStPicUrl toCommonStPicUrl(StPicUrl stPicUrl) {
        CommonStPicUrl commonStPicUrl = new CommonStPicUrl();
        String str = stPicUrl.url;
        if (str == null) {
            str = "";
        }
        commonStPicUrl.setUrl(str);
        Integer num = stPicUrl.width;
        commonStPicUrl.setWidth(num != null ? num.intValue() : 0);
        Integer num2 = stPicUrl.height;
        commonStPicUrl.setHeight(num2 != null ? num2.intValue() : 0);
        return commonStPicUrl;
    }

    public static final CommonStVideo toCommonStVideo(StVideo stVideo) {
        CommonStImage commonStImage;
        CommonStVideo commonStVideo = new CommonStVideo();
        String str = stVideo.id;
        if (str == null) {
            str = "";
        }
        commonStVideo.setId(str);
        String str2 = stVideo.url;
        commonStVideo.setUrl(str2 != null ? str2 : "");
        StImage stImage = stVideo.cover;
        if (stImage == null || (commonStImage = toCommonStImage(stImage)) == null) {
            commonStImage = new CommonStImage();
        }
        commonStVideo.setCover(commonStImage);
        Integer num = stVideo.width;
        commonStVideo.setWidth(num != null ? num.intValue() : 0);
        Integer num2 = stVideo.height;
        commonStVideo.setHeight(num2 != null ? num2.intValue() : 0);
        Long l3 = stVideo.videoTime;
        commonStVideo.setVideoTime(l3 != null ? l3.longValue() : 0L);
        Iterator<T> it = stVideo.videoUrl.iterator();
        while (it.hasNext()) {
            commonStVideo.getVideoUrl().add(toCommonStPicSpecUrlEntry((StPicSpecUrlEntry) it.next()));
        }
        return commonStVideo;
    }

    public static final StImage toNTStImage(CommonStImage commonStImage) {
        StImage stImage = new StImage(null, null, null, null, null, null, null, null, 255, null);
        stImage.name = commonStImage.getName();
        stImage.sloc = commonStImage.getSloc();
        stImage.lloc = commonStImage.getLloc();
        Iterator<T> it = commonStImage.getPhotoUrl().iterator();
        while (it.hasNext()) {
            stImage.photoUrl.add(toNTStPicSpecUrlEntry((CommonStPicSpecUrlEntry) it.next()));
        }
        stImage.defaultUrl = toStPicUrl(commonStImage.getDefaultUrl());
        stImage.isGif = Boolean.valueOf(commonStImage.getIsGif());
        return stImage;
    }

    public static final StMediaComment toNTStMediaComment(CommonStMediaComment commonStMediaComment) {
        return new StMediaComment(Integer.valueOf(commonStMediaComment.getCommentNum()));
    }

    public static final StMediaLike toNTStMediaLike(CommonStMediaLike commonStMediaLike) {
        return new StMediaLike(commonStMediaLike.getKey(), Integer.valueOf(commonStMediaLike.getNum()), Boolean.valueOf(commonStMediaLike.getLiked() == 1));
    }

    public static final StPicSpecUrlEntry toNTStPicSpecUrlEntry(CommonStPicSpecUrlEntry commonStPicSpecUrlEntry) {
        StPicSpecUrlEntry stPicSpecUrlEntry = new StPicSpecUrlEntry(null, null, 3, null);
        int spec = commonStPicSpecUrlEntry.getSpec();
        if (spec == CommonEnumPhotoSpec.PHOTO_SPEC_ORIGIN.ordinal()) {
            stPicSpecUrlEntry.spec = 0;
        } else if (spec == CommonEnumPhotoSpec.PHOTO_SPEC_BIG.ordinal()) {
            stPicSpecUrlEntry.spec = 1;
        } else if (spec == CommonEnumPhotoSpec.PHOTO_SPEC_MEDIUM.ordinal()) {
            stPicSpecUrlEntry.spec = 2;
        } else if (spec == CommonEnumPhotoSpec.PHOTO_SPEC_SMALL.ordinal()) {
            stPicSpecUrlEntry.spec = 3;
        } else if (spec == CommonEnumPhotoSpec.PHOTO_SPEC_THUMB.ordinal()) {
            stPicSpecUrlEntry.spec = 4;
        } else if (spec == CommonEnumPhotoSpec.PHOTO_SPEC_CURRENT.ordinal()) {
            stPicSpecUrlEntry.spec = 5;
        } else if (spec == CommonEnumPhotoSpec.PHOTO_SPEC_DOWNLOAD.ordinal()) {
            stPicSpecUrlEntry.spec = 6;
        } else {
            stPicSpecUrlEntry.spec = 0;
        }
        stPicSpecUrlEntry.url = toStPicUrl(commonStPicSpecUrlEntry.getUrl());
        return stPicSpecUrlEntry;
    }

    public static final StVideo toNTStVideo(CommonStVideo commonStVideo) {
        StVideo stVideo = new StVideo(null, null, null, null, null, null, null, null, null, 511, null);
        stVideo.id = commonStVideo.getId();
        stVideo.url = commonStVideo.getUrl();
        stVideo.cover = toNTStImage(commonStVideo.getCover());
        stVideo.width = Integer.valueOf(commonStVideo.getWidth());
        stVideo.height = Integer.valueOf(commonStVideo.getHeight());
        stVideo.videoTime = Long.valueOf(commonStVideo.getVideoTime());
        Iterator<T> it = commonStVideo.getVideoUrl().iterator();
        while (it.hasNext()) {
            stVideo.videoUrl.add(toNTStPicSpecUrlEntry((CommonStPicSpecUrlEntry) it.next()));
        }
        return stVideo;
    }

    public static final StMedia toStMedia(CommonStMedia commonStMedia) {
        StMedia stMedia;
        StMedia stMedia2 = new StMedia(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0 == true ? 1 : 0, null, null, 262143, null);
        if (commonStMedia.getType() == CommonEnumMediaType.IMAGE.ordinal()) {
            stMedia = stMedia2;
            stMedia.type = 0;
        } else {
            stMedia = stMedia2;
            if (commonStMedia.getType() == CommonEnumMediaType.VIDEO.ordinal()) {
                stMedia.type = 1;
            }
        }
        stMedia.image = toNTStImage(commonStMedia.getImage());
        stMedia.video = toNTStVideo(commonStMedia.getVideo());
        stMedia.desc = commonStMedia.getDesc();
        stMedia.uploader = commonStMedia.getUpload();
        stMedia.batchId = Long.valueOf(commonStMedia.getBatchId());
        stMedia.uploadTime = Long.valueOf(commonStMedia.getUploadTime());
        stMedia.shootTime = Long.valueOf(commonStMedia.getShootTime());
        stMedia.linkId = Long.valueOf(commonStMedia.getLinkId());
        stMedia.opMask.addAll(commonStMedia.getOpMask());
        return stMedia;
    }

    public static final StPicUrl toStPicUrl(CommonStPicUrl commonStPicUrl) {
        StPicUrl stPicUrl = new StPicUrl(null, null, null, 7, null);
        stPicUrl.url = commonStPicUrl.getUrl();
        stPicUrl.width = Integer.valueOf(commonStPicUrl.getWidth());
        stPicUrl.height = Integer.valueOf(commonStPicUrl.getHeight());
        return stPicUrl;
    }
}
