package com.tencent.qqnt.qbasealbum.ktx;

import android.content.ContentUris;
import android.net.Uri;
import android.provider.MediaStore;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qqnt.qbasealbum.model.LocalMediaInfo;
import com.tencent.qqnt.qbasealbum.model.PageType;
import com.tencent.qqnt.qbasealbum.utils.MediaTypeHelper;
import com.tencent.qqnt.qbasealbum.utils.UriUtil;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerPicInfo;
import com.tencent.richframework.gallery.bean.RFWLayerVideoInfo;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0006\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0004\u001a\u00020\u0003*\u00020\u0000\u001a\n\u0010\u0005\u001a\u00020\u0003*\u00020\u0000\u001a\f\u0010\u0006\u001a\u00020\u0003*\u0004\u0018\u00010\u0000\u001a\f\u0010\u0007\u001a\u00020\u0003*\u0004\u0018\u00010\u0000\u001a\n\u0010\b\u001a\u00020\u0003*\u00020\u0000\u001a\n\u0010\t\u001a\u00020\u0003*\u00020\u0000\u001a\n\u0010\u000b\u001a\u00020\n*\u00020\u0000\u001a\n\u0010\r\u001a\u00020\f*\u00020\u0000\u001a\n\u0010\u000e\u001a\u00020\f*\u00020\u0000\u001a\n\u0010\u000f\u001a\u00020\u0000*\u00020\u0000\u001a\u0010\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0000H\u0007\",\u0010\u0018\u001a\u0004\u0018\u00010\u0012*\u00020\u00002\b\u0010\u0013\u001a\u0004\u0018\u00010\u00128F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017\"(\u0010\u001e\u001a\u00020\u0019*\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u00198F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d\"\u0015\u0010 \u001a\u00020\u0019*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b\u001f\u0010\u001b\"(\u0010%\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u00038F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$\"(\u0010+\u001a\u00020&*\u00020\u00002\u0006\u0010\u0013\u001a\u00020&8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*\u00a8\u0006,"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", "u", "", "p", "l", DomainData.DOMAIN_NAME, "o", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "k", "Lcom/tencent/qqnt/qbasealbum/model/PageType;", "g", "Landroid/net/Uri;", "d", "i", "b", "localMediaInfo", "a", "", "value", "c", "(Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;)Ljava/lang/String;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "(Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;Ljava/lang/String;)V", "albumId", "", "e", "(Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;)I", ReportConstant.COSTREPORT_PREFIX, "(Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;I)V", "indexInSelectedMedia", h.F, "validStatus", "j", "(Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;)Z", "r", "(Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;Z)V", "isEdit", "", "f", "(Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;)J", "t", "(Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;J)V", "mDuration", "nt_album_kit_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class b {
    @Deprecated(message = "\u4f7f\u7528LocalMediaInfo.copy()\u66ff\u6362")
    @NotNull
    public static final LocalMediaInfo a(@NotNull LocalMediaInfo localMediaInfo) {
        Intrinsics.checkNotNullParameter(localMediaInfo, "localMediaInfo");
        LocalMediaInfo localMediaInfo2 = new LocalMediaInfo(false, 1, null);
        localMediaInfo2.set_id(localMediaInfo.get_id());
        localMediaInfo2.setPath(localMediaInfo.getPath());
        localMediaInfo2.setFileSize(localMediaInfo.getFileSize());
        localMediaInfo2.setAddedDate(localMediaInfo.getAddedDate());
        localMediaInfo2.setModifiedDate(localMediaInfo.getModifiedDate());
        localMediaInfo2.setOrientation(localMediaInfo.getOrientation());
        t(localMediaInfo2, f(localMediaInfo));
        localMediaInfo2.setMStartTime(localMediaInfo.getMStartTime());
        localMediaInfo2.setMTotalDuration(localMediaInfo.getMTotalDuration());
        localMediaInfo2.setMChecked(localMediaInfo.getMChecked());
        localMediaInfo2.setNeedProcess(localMediaInfo.getNeedProcess());
        localMediaInfo2.setFakeVid(localMediaInfo.getFakeVid());
        localMediaInfo2.setMVideoType(localMediaInfo.getMVideoType());
        localMediaInfo2.setThumbRect(localMediaInfo.getThumbRect());
        localMediaInfo2.setRecord(localMediaInfo.isRecord());
        localMediaInfo2.setThumbnailPath(localMediaInfo.getThumbnailPath());
        localMediaInfo2.setThumbnailProgress(localMediaInfo.getThumbnailProgress());
        localMediaInfo2.setProgressThumbnail(localMediaInfo.isProgressThumbnail());
        localMediaInfo2.setSelectStatus(localMediaInfo.getSelectStatus());
        localMediaInfo2.setSegment(localMediaInfo.isSegment());
        localMediaInfo2.setRotation(localMediaInfo.getRotation());
        localMediaInfo2.setLatitude(localMediaInfo.getLatitude());
        localMediaInfo2.setLongitude(localMediaInfo.getLongitude());
        localMediaInfo2.setMakeVideo(localMediaInfo.isMakeVideo());
        localMediaInfo2.setSyncToWeishi(localMediaInfo.isSyncToWeishi());
        localMediaInfo2.setVideoReady(localMediaInfo.isVideoReady());
        localMediaInfo2.setMissionID(localMediaInfo.getMissionID());
        localMediaInfo2.setAiTextLabel(localMediaInfo.getAiTextLabel());
        localMediaInfo2.setMCloudPhotoOwnerUin(localMediaInfo.getMCloudPhotoOwnerUin());
        localMediaInfo2.setMCloudPhotoOwnerAlbumId(localMediaInfo.getMCloudPhotoOwnerAlbumId());
        localMediaInfo2.setMCloudPhotoId(localMediaInfo.getMCloudPhotoId());
        localMediaInfo2.setThumbWidth(localMediaInfo.getThumbWidth());
        localMediaInfo2.setThumbHeight(localMediaInfo.getThumbHeight());
        localMediaInfo2.setIndex(localMediaInfo.getIndex());
        localMediaInfo2.setPosition(localMediaInfo.getPosition());
        localMediaInfo2.setMMimeType(localMediaInfo.getMMimeType());
        localMediaInfo2.setMMediaType(localMediaInfo.getMMediaType());
        localMediaInfo2.setMTransferPosList(localMediaInfo.getMTransferPosList());
        localMediaInfo2.setMediaWidth(localMediaInfo.getMediaWidth());
        localMediaInfo2.setMediaHeight(localMediaInfo.getMediaHeight());
        localMediaInfo2.setMediaBitrate(localMediaInfo.getMediaBitrate());
        localMediaInfo2.setMediaOriginWidth(localMediaInfo.getMediaOriginWidth());
        localMediaInfo2.setMediaOriginHeight(localMediaInfo.getMediaOriginHeight());
        localMediaInfo2.setMediaOriginSize(localMediaInfo.getMediaOriginSize());
        localMediaInfo2.setMediaOriginBitrate(localMediaInfo.getMediaOriginBitrate());
        localMediaInfo2.setMOriginPath(localMediaInfo.getMOriginPath());
        localMediaInfo2.setMaterialID(localMediaInfo.getMaterialID());
        localMediaInfo2.setMaterialName(localMediaInfo.getMaterialName());
        localMediaInfo2.setFilterID(localMediaInfo.getFilterID());
        localMediaInfo2.setScheme(localMediaInfo.getScheme());
        localMediaInfo2.setShowCircleTakeSame(localMediaInfo.getShowCircleTakeSame());
        localMediaInfo2.setMKuolieId(localMediaInfo.getMKuolieId());
        localMediaInfo2.setMKuolieCenterX(localMediaInfo.getMKuolieCenterX());
        localMediaInfo2.setMKuolieCenterY(localMediaInfo.getMKuolieCenterY());
        localMediaInfo2.setMKuolieRotate(localMediaInfo.getMKuolieRotate());
        localMediaInfo2.setMKuolieWidthScale(localMediaInfo.getMKuolieWidthScale());
        localMediaInfo2.setMKuolieHeightScale(localMediaInfo.getMKuolieHeightScale());
        localMediaInfo2.setMHashTagList(localMediaInfo.getMHashTagList());
        localMediaInfo2.setSystemMeidaStore(localMediaInfo.isSystemMeidaStore());
        localMediaInfo2.setRegionThumbUseNewDecoder(localMediaInfo.isRegionThumbUseNewDecoder());
        localMediaInfo2.setMIsUploadOrigin(localMediaInfo.getMIsUploadOrigin());
        localMediaInfo2.setVisableTime(localMediaInfo.getVisableTime());
        localMediaInfo2.setListViewPosition(localMediaInfo.getListViewPosition());
        localMediaInfo2.setThumbSize(localMediaInfo.getThumbSize());
        localMediaInfo2.setPanoramaPhotoType(localMediaInfo.getPanoramaPhotoType());
        localMediaInfo2.setMAudioPath(localMediaInfo.getMAudioPath());
        localMediaInfo2.setMHasAudioTrack(localMediaInfo.getMHasAudioTrack());
        localMediaInfo2.setMSampleRate(localMediaInfo.getMSampleRate());
        localMediaInfo2.setMAlbumName(localMediaInfo.getMAlbumName());
        localMediaInfo2.setMTransId(localMediaInfo.getMTransId());
        localMediaInfo2.setMTextId(localMediaInfo.getMTextId());
        localMediaInfo2.setMTextStr(localMediaInfo.getMTextStr());
        localMediaInfo2.setRwa(localMediaInfo.isRwa());
        localMediaInfo2.setPicPathBeforeEdit(localMediaInfo.getPicPathBeforeEdit());
        return localMediaInfo2;
    }

    @NotNull
    public static final LocalMediaInfo b(@NotNull LocalMediaInfo localMediaInfo) {
        Intrinsics.checkNotNullParameter(localMediaInfo, "<this>");
        return a(localMediaInfo);
    }

    @Nullable
    public static final String c(@NotNull LocalMediaInfo localMediaInfo) {
        Intrinsics.checkNotNullParameter(localMediaInfo, "<this>");
        return String.valueOf(localMediaInfo.getExtAlbumId());
    }

    @NotNull
    public static final Uri d(@NotNull LocalMediaInfo localMediaInfo) {
        Intrinsics.checkNotNullParameter(localMediaInfo, "<this>");
        Uri withAppendedId = ContentUris.withAppendedId(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, localMediaInfo.get_id());
        Intrinsics.checkNotNullExpressionValue(withAppendedId, "withAppendedId(\n        \u2026NT_URI,\n        _id\n    )");
        return withAppendedId;
    }

    public static final int e(@NotNull LocalMediaInfo localMediaInfo) {
        Intrinsics.checkNotNullParameter(localMediaInfo, "<this>");
        return localMediaInfo.getExtIndexInSelectedMedia();
    }

    public static final long f(@NotNull LocalMediaInfo localMediaInfo) {
        Intrinsics.checkNotNullParameter(localMediaInfo, "<this>");
        Long videoDuration = localMediaInfo.getVideoDuration();
        if (videoDuration != null) {
            return videoDuration.longValue();
        }
        return 0L;
    }

    @NotNull
    public static final PageType g(@NotNull LocalMediaInfo localMediaInfo) {
        Intrinsics.checkNotNullParameter(localMediaInfo, "<this>");
        if (l(localMediaInfo)) {
            if (n(localMediaInfo)) {
                return PageType.QZONE_IMAGE;
            }
            return PageType.QZONE_VIDEO;
        }
        if (k(localMediaInfo)) {
            if (n(localMediaInfo)) {
                return PageType.ONLINE_IMAGE;
            }
            return PageType.ONLINE_VIDEO;
        }
        if (n(localMediaInfo)) {
            return PageType.LOCAL_IMAGE;
        }
        return PageType.LOCAL_VIDEO;
    }

    public static final int h(@NotNull LocalMediaInfo localMediaInfo) {
        Intrinsics.checkNotNullParameter(localMediaInfo, "<this>");
        return 0;
    }

    @NotNull
    public static final Uri i(@NotNull LocalMediaInfo localMediaInfo) {
        Intrinsics.checkNotNullParameter(localMediaInfo, "<this>");
        Uri withAppendedId = ContentUris.withAppendedId(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, localMediaInfo.get_id());
        Intrinsics.checkNotNullExpressionValue(withAppendedId, "withAppendedId(\n        \u2026NT_URI,\n        _id\n    )");
        return withAppendedId;
    }

    public static final boolean j(@NotNull LocalMediaInfo localMediaInfo) {
        Intrinsics.checkNotNullParameter(localMediaInfo, "<this>");
        return localMediaInfo.getExtIsEdit();
    }

    public static final boolean k(@NotNull LocalMediaInfo localMediaInfo) {
        Intrinsics.checkNotNullParameter(localMediaInfo, "<this>");
        return false;
    }

    public static final boolean l(@NotNull LocalMediaInfo localMediaInfo) {
        Intrinsics.checkNotNullParameter(localMediaInfo, "<this>");
        return false;
    }

    public static final boolean m(@NotNull LocalMediaInfo localMediaInfo) {
        Intrinsics.checkNotNullParameter(localMediaInfo, "<this>");
        return MediaTypeHelper.f361628a.b(localMediaInfo);
    }

    public static final boolean n(@Nullable LocalMediaInfo localMediaInfo) {
        if (MediaTypeHelper.f361628a.a(localMediaInfo) == 0) {
            return true;
        }
        return false;
    }

    public static final boolean o(@Nullable LocalMediaInfo localMediaInfo) {
        if (MediaTypeHelper.f361628a.a(localMediaInfo) == 1) {
            return true;
        }
        return false;
    }

    public static final boolean p(@NotNull LocalMediaInfo localMediaInfo) {
        Intrinsics.checkNotNullParameter(localMediaInfo, "<this>");
        if (localMediaInfo.getExtAlbumId() == 0) {
            return true;
        }
        return false;
    }

    public static final void q(@NotNull LocalMediaInfo localMediaInfo, @Nullable String str) {
        int parseInt;
        Intrinsics.checkNotNullParameter(localMediaInfo, "<this>");
        if (str == null) {
            return;
        }
        if (p(localMediaInfo)) {
            parseInt = str.hashCode();
        } else {
            parseInt = Integer.parseInt(str);
        }
        localMediaInfo.setExtAlbumId(parseInt);
    }

    public static final void r(@NotNull LocalMediaInfo localMediaInfo, boolean z16) {
        Intrinsics.checkNotNullParameter(localMediaInfo, "<this>");
        localMediaInfo.setExtIsEdit(z16);
    }

    public static final void s(@NotNull LocalMediaInfo localMediaInfo, int i3) {
        Intrinsics.checkNotNullParameter(localMediaInfo, "<this>");
        localMediaInfo.setExtIndexInSelectedMedia(i3);
    }

    public static final void t(@NotNull LocalMediaInfo localMediaInfo, long j3) {
        Intrinsics.checkNotNullParameter(localMediaInfo, "<this>");
        localMediaInfo.setVideoDuration(Long.valueOf(j3));
    }

    @NotNull
    public static final RFWLayerItemMediaInfo u(@NotNull LocalMediaInfo localMediaInfo) {
        Intrinsics.checkNotNullParameter(localMediaInfo, "<this>");
        RFWLayerItemMediaInfo rFWLayerItemMediaInfo = new RFWLayerItemMediaInfo();
        rFWLayerItemMediaInfo.setMediaId(String.valueOf(localMediaInfo.get_id()));
        if (o(localMediaInfo)) {
            RFWLayerVideoInfo rFWLayerVideoInfo = new RFWLayerVideoInfo();
            rFWLayerVideoInfo.setFileId(String.valueOf(localMediaInfo.get_id()));
            rFWLayerVideoInfo.setLocalPath(localMediaInfo.getPath());
            rFWLayerVideoInfo.setVideoWidth(localMediaInfo.getMediaWidth());
            rFWLayerVideoInfo.setVideoHeight(localMediaInfo.getMediaHeight());
            rFWLayerVideoInfo.setVideoDurationSec(((int) f(localMediaInfo)) / 1000);
            rFWLayerVideoInfo.setCurrentVideoUrl(UriUtil.d(UriUtil.f361640a, localMediaInfo, false, 2, null));
            rFWLayerItemMediaInfo.setLayerVideoInfo(rFWLayerVideoInfo);
        } else {
            RFWLayerPicInfo rFWLayerPicInfo = new RFWLayerPicInfo();
            rFWLayerPicInfo.setPicId(String.valueOf(localMediaInfo.getPath()));
            RFWLayerPicInfo.RFWPicInfo rFWPicInfo = new RFWLayerPicInfo.RFWPicInfo();
            rFWPicInfo.setLocalPath(localMediaInfo.getPath());
            rFWPicInfo.setWidth(localMediaInfo.getMediaWidth());
            rFWPicInfo.setHeight(localMediaInfo.getMediaHeight());
            rFWPicInfo.setSize(localMediaInfo.getFileSize());
            rFWLayerPicInfo.setCurrentPicInfo(rFWPicInfo);
            rFWLayerPicInfo.setOriginPicInfo(rFWPicInfo);
            rFWLayerPicInfo.getCurrentPicInfo().setUrl(UriUtil.d(UriUtil.f361640a, localMediaInfo, false, 2, null));
            rFWLayerItemMediaInfo.setLayerPicInfo(rFWLayerPicInfo);
        }
        return rFWLayerItemMediaInfo;
    }
}
