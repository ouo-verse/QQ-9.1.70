package lc;

import FileUpload.cnst.kExtKeyMarkUinBeforeUpload;
import NS_MOBILE_OPERATION.LbsInfo;
import android.content.Context;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.qzone.adapter.feedcomponent.FakeShuoShuoDataCacheHelper;
import com.qzone.common.event.EventCenter;
import com.qzone.proxy.feedcomponent.model.PictureUrl;
import com.qzone.proxy.feedcomponent.model.ShuoshuoVideoInfo;
import com.qzone.proxy.feedcomponent.model.VideoInfo;
import com.qzone.proxy.feedcomponent.model.VideoUrl;
import com.qzone.publish.business.model.UploadVideoObject;
import com.qzone.publish.ui.model.MediaWrapper;
import com.qzone.util.ag;
import com.qzone.util.image.ImageInfo;
import com.tencent.biz.richframework.util.RFWFileUtils;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import cooperation.qzone.LbsDataV2;
import cooperation.qzone.model.Size;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\"\u0010#J*\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002J\u001a\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0002J*\u0010\u000f\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002J\u0010\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\tJ\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013J\u001e\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00172\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013JF\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0016\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u001a0\u0019j\b\u0012\u0004\u0012\u00020\u001a`\u001b2\u0016\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u00150\u0019j\b\u0012\u0004\u0012\u00020\u0015`\u001bJ\u001e\u0010!\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00150 2\u0006\u0010\f\u001a\u00020\u000b\u00a8\u0006$"}, d2 = {"Llc/m;", "", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "mediaInfo", "", "publishThumbnailHeight", "publishThumbnailWidth", "Lcom/qzone/proxy/feedcomponent/model/ShuoshuoVideoInfo;", "f", "Lcom/qzone/publish/ui/model/c;", "params", "Lcom/qzone/util/image/ImageInfo;", "d", "e", "shuoshuoVideoInfo", "Lcom/qzone/proxy/feedcomponent/model/VideoInfo;", tl.h.F, "Lcooperation/qzone/LbsDataV2$PoiInfo;", "poiInfo", "", "a", "", "b", "Ljava/util/ArrayList;", "Lcom/qzone/publish/ui/model/MediaWrapper;", "Lkotlin/collections/ArrayList;", "mediaWrapperList", "imageList", "", "g", "Lkotlin/Pair;", "c", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    public static final m f414350a = new m();

    m() {
    }

    private final ImageInfo d(LocalMediaInfo mediaInfo, com.qzone.publish.ui.model.c params) {
        ImageInfo imageInfo;
        if (URLUtil.isNetworkUrl(mediaInfo.path)) {
            imageInfo = new ImageInfo();
            imageInfo.mPath = mediaInfo.path;
        } else {
            imageInfo = new ImageInfo(mediaInfo.path);
            imageInfo.panoramaType = mediaInfo.panoramaPhotoType;
        }
        Map<String, byte[]> map = params.F;
        if (map != null && map.containsKey(mediaInfo.path)) {
            HashMap<String, byte[]> hashMap = imageInfo.mExternalData;
            Intrinsics.checkNotNullExpressionValue(hashMap, "imageInfo.mExternalData");
            hashMap.put(kExtKeyMarkUinBeforeUpload.value, params.F.get(mediaInfo.path));
        }
        imageInfo.mDescription = params.f51934b;
        Map<String, String> map2 = params.G;
        if (map2 != null && map2.containsKey(mediaInfo.path)) {
            HashMap<String, String> hashMap2 = new HashMap<>();
            hashMap2.put("youtu_tag_array", params.G.get(mediaInfo.path));
            HashMap<String, String> hashMap3 = imageInfo.mPhotoTagInfo;
            if (hashMap3 != null && hashMap3.size() > 0) {
                imageInfo.mPhotoTagInfo.putAll(hashMap2);
            } else {
                imageInfo.mPhotoTagInfo = hashMap2;
            }
        }
        return imageInfo;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0079  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Pair<String, String> c(com.qzone.publish.ui.model.c params) {
        String str;
        String str2;
        ShuoshuoVideoInfo shuoshuoVideoInfo;
        boolean startsWith$default;
        Intrinsics.checkNotNullParameter(params, "params");
        Map<String, String> map = params.f51954p;
        if (map != null) {
            str = map.get("geo_idname");
        } else {
            params.f51954p = new HashMap();
            str = null;
        }
        Map<String, String> map2 = params.f51954p;
        Intrinsics.checkNotNullExpressionValue(map2, "params.shootParams");
        int i3 = params.f51959u;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(i3);
        map2.put("shuoshuo_priv", sb5.toString());
        if (params.f51950l && !TextUtils.isEmpty(params.f51934b)) {
            String str3 = params.f51934b;
            Intrinsics.checkNotNullExpressionValue(str3, "params.content");
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(str3, "qm", false, 2, null);
            if (startsWith$default) {
                String str4 = params.f51934b;
                Intrinsics.checkNotNullExpressionValue(str4, "params.content");
                str2 = str4.substring(2);
                Intrinsics.checkNotNullExpressionValue(str2, "this as java.lang.String).substring(startIndex)");
                shuoshuoVideoInfo = params.f51946h;
                if (shuoshuoVideoInfo != null) {
                    shuoshuoVideoInfo.mIsFakeFeed = true;
                }
                if (params.P.size() > 0) {
                    EventCenter eventCenter = EventCenter.getInstance();
                    ArrayList<String> arrayList = params.P;
                    Intrinsics.checkNotNullExpressionValue(arrayList, "params.imageList");
                    Object[] array = arrayList.toArray(new String[0]);
                    Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                    String[] strArr = (String[]) array;
                    eventCenter.post("PHOTOUPLOADACTION", 1, Arrays.copyOf(strArr, strArr.length));
                }
                return new Pair<>(str, str2);
            }
        }
        str2 = params.f51934b;
        shuoshuoVideoInfo = params.f51946h;
        if (shuoshuoVideoInfo != null) {
        }
        if (params.P.size() > 0) {
        }
        return new Pair<>(str, str2);
    }

    public final boolean g(Context context, com.qzone.publish.ui.model.c params, ArrayList<MediaWrapper> mediaWrapperList, ArrayList<String> imageList) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(mediaWrapperList, "mediaWrapperList");
        Intrinsics.checkNotNullParameter(imageList, "imageList");
        int i3 = 0;
        int i16 = 0;
        for (LocalMediaInfo mediaInfo : params.f51940e) {
            Size b16 = f6.b.b(mediaInfo);
            int i17 = b16.width;
            int i18 = b16.height;
            if (mediaInfo.isRecord) {
                Intrinsics.checkNotNullExpressionValue(mediaInfo, "mediaInfo");
                ShuoshuoVideoInfo e16 = e(context, mediaInfo, i18, i17);
                if (e16 != null) {
                    e16.fakeVid = mediaInfo.fakeVid;
                    e16.mDescription = params.f51934b;
                    e16.mIsUploadOrigin = mediaInfo.mIsUploadOrigin;
                    if (mediaInfo.isSyncToWeishi) {
                        ag.w(e16, ShortVideoConstants.VIDEO_IS_SYNC_TO_WEISHI, true);
                    }
                    UploadVideoObject.setVideoType(params.f51946h, true);
                    zm.e.f452772a.b(mediaInfo, e16);
                    mediaWrapperList.add(new MediaWrapper(e16, e16.mNeedProcess));
                    i3++;
                }
            } else if (QAlbumUtil.getMediaType(mediaInfo) == 0) {
                Intrinsics.checkNotNullExpressionValue(mediaInfo, "mediaInfo");
                mediaWrapperList.add(new MediaWrapper(d(mediaInfo, params)));
                imageList.add(mediaInfo.path);
                i16++;
            } else if (QAlbumUtil.getMediaType(mediaInfo) == 1) {
                Intrinsics.checkNotNullExpressionValue(mediaInfo, "mediaInfo");
                ShuoshuoVideoInfo f16 = f(context, mediaInfo, i18, i17);
                if (f16 != null) {
                    f16.mProcessMissionID = mediaInfo.missionID;
                }
                if (f16 != null) {
                    f16.mDescription = params.f51934b;
                }
                if (mediaInfo.isSyncToWeishi) {
                    ag.w(f16, ShortVideoConstants.VIDEO_IS_SYNC_TO_WEISHI, true);
                }
                if (params.f51951m) {
                    ag.w(f16, ShortVideoConstants.VIDEO_IS_USE_QCIRCLE_RATE, true);
                }
                zm.e.f452772a.b(mediaInfo, f16);
                MediaWrapper mediaWrapper = new MediaWrapper(f16);
                if (mediaWrapper.getVideoInfo().mNeedProcess) {
                    mediaWrapper.getVideoInfo().mNeedProcess = mediaInfo.needProcess;
                    mediaWrapper.getVideoInfo().mIsOriginalVideo = !mediaInfo.needProcess ? 1 : 0;
                    mediaWrapper.getVideoInfo().mIsUploadOrigin = !mediaInfo.needProcess;
                } else if (!mediaInfo.needProcess) {
                    mediaWrapper.getVideoInfo().mNeedProcess = false;
                    mediaWrapper.getVideoInfo().mIsOriginalVideo = 1;
                    mediaWrapper.getVideoInfo().mIsUploadOrigin = true;
                }
                mediaWrapperList.add(mediaWrapper);
                i3++;
            }
        }
        return i3 == 1 && i16 == 0;
    }

    public final VideoInfo h(ShuoshuoVideoInfo shuoshuoVideoInfo) {
        VideoInfo videoInfo = new VideoInfo();
        if (shuoshuoVideoInfo == null) {
            return videoInfo;
        }
        if (!RFWFileUtils.fileExists(shuoshuoVideoInfo.mVideoPath)) {
            String c16 = FakeShuoShuoDataCacheHelper.c(shuoshuoVideoInfo.mVideoPath);
            if (!RFWFileUtils.fileExists(c16)) {
                c16 = shuoshuoVideoInfo.mVideoPath;
            }
            shuoshuoVideoInfo.mVideoPath = c16;
        }
        videoInfo.videoUrl = new VideoUrl(shuoshuoVideoInfo.mVideoPath);
        PictureUrl pictureUrl = new PictureUrl();
        pictureUrl.url = shuoshuoVideoInfo.mVideoPath;
        pictureUrl.width = shuoshuoVideoInfo.mVideoWidth;
        pictureUrl.height = shuoshuoVideoInfo.mVideoHeight;
        String str = shuoshuoVideoInfo.mCoverUrl;
        if (str != null) {
            pictureUrl.url = str;
        }
        videoInfo.bigUrl = pictureUrl;
        videoInfo.originUrl = pictureUrl;
        videoInfo.currentUrl = pictureUrl;
        videoInfo.coverUrl = pictureUrl;
        long j3 = shuoshuoVideoInfo.mDuration;
        videoInfo.videoTime = j3;
        videoInfo.validVideoTime = j3;
        videoInfo.showVideoTime = VideoInfo.getShownTimeFromNumeric(j3);
        videoInfo.videoType = 2;
        videoInfo.actionType = 3;
        videoInfo.playType = (byte) 1;
        videoInfo.isFakeFeed = shuoshuoVideoInfo.mIsFakeFeed;
        videoInfo.desc = shuoshuoVideoInfo.mDescription;
        videoInfo.shootTime = shuoshuoVideoInfo.mShootTime;
        videoInfo.needDeleteLocal = shuoshuoVideoInfo.needDeleteLocal;
        videoInfo.width = shuoshuoVideoInfo.mVideoWidth;
        videoInfo.height = shuoshuoVideoInfo.mVideoHeight;
        return videoInfo;
    }

    public final String a(LbsDataV2.PoiInfo poiInfo) {
        if (poiInfo == null) {
            return null;
        }
        if (!TextUtils.isEmpty(poiInfo.poiDefaultName)) {
            return poiInfo.poiDefaultName;
        }
        if (!TextUtils.isEmpty(poiInfo.poiName)) {
            return poiInfo.poiName;
        }
        return poiInfo.address;
    }

    public final Map<String, String> b(LbsDataV2.PoiInfo poiInfo) {
        if (poiInfo == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        LbsInfo parceToLbsInfo = LbsDataV2.parceToLbsInfo(poiInfo);
        if (parceToLbsInfo != null) {
            String str = parceToLbsInfo.lbs_x;
            Intrinsics.checkNotNullExpressionValue(str, "lbsInfo.lbs_x");
            hashMap.put("geo_x", str);
            String str2 = parceToLbsInfo.lbs_y;
            Intrinsics.checkNotNullExpressionValue(str2, "lbsInfo.lbs_y");
            hashMap.put("geo_y", str2);
            hashMap.put("geo_id", String.valueOf(parceToLbsInfo.lbs_id));
            String str3 = parceToLbsInfo.lbs_idnm;
            Intrinsics.checkNotNullExpressionValue(str3, "lbsInfo.lbs_idnm");
            hashMap.put("geo_idname", str3);
            String str4 = parceToLbsInfo.lbs_nm;
            Intrinsics.checkNotNullExpressionValue(str4, "lbsInfo.lbs_nm");
            hashMap.put("geo_name", str4);
        }
        hashMap.put("targetShootIndex", "0");
        return hashMap;
    }

    private final ShuoshuoVideoInfo e(Context context, LocalMediaInfo mediaInfo, int publishThumbnailHeight, int publishThumbnailWidth) {
        ShuoshuoVideoInfo p16 = ag.p(context, mediaInfo._id, mediaInfo.path, mediaInfo.fileSize, mediaInfo.mVideoType, mediaInfo.thumbnailPath, publishThumbnailHeight, publishThumbnailWidth, mediaInfo.mStartTime, mediaInfo.mDuration, mediaInfo.mTotalDuration, mediaInfo.needProcess, mediaInfo.bundle);
        return p16 == null ? ag.z(context, mediaInfo._id, mediaInfo.path, mediaInfo.fileSize, mediaInfo.mVideoType, mediaInfo.thumbnailPath, publishThumbnailHeight, publishThumbnailWidth, mediaInfo.mStartTime, mediaInfo.mDuration, mediaInfo.mTotalDuration, mediaInfo.needProcess, mediaInfo.bundle, false) : p16;
    }

    private final ShuoshuoVideoInfo f(Context context, LocalMediaInfo mediaInfo, int publishThumbnailHeight, int publishThumbnailWidth) {
        long j3 = mediaInfo._id;
        String str = mediaInfo.path;
        long j16 = mediaInfo.fileSize;
        String str2 = mediaInfo.thumbnailPath;
        long j17 = mediaInfo.mDuration;
        ShuoshuoVideoInfo p16 = ag.p(context, j3, str, j16, 1, str2, publishThumbnailHeight, publishThumbnailWidth, 0L, j17, j17, mediaInfo.needProcess, null);
        if (p16 != null) {
            return p16;
        }
        long j18 = mediaInfo._id;
        String str3 = mediaInfo.path;
        long j19 = mediaInfo.fileSize;
        String str4 = mediaInfo.thumbnailPath;
        long j26 = mediaInfo.mDuration;
        return ag.z(context, j18, str3, j19, 1, str4, publishThumbnailHeight, publishThumbnailWidth, 0L, j26, j26, mediaInfo.needProcess, null, false);
    }
}
