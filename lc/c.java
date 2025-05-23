package lc;

import NS_MOBILE_FEEDS.s_event_tag;
import NS_MOBILE_FEEDS.single_feed;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.qq.jce.wup.UniAttribute;
import com.qzone.adapter.feedcomponent.q;
import com.qzone.album.data.model.PhotoCategorySinglePicInfo;
import com.qzone.common.account.LoginData;
import com.qzone.common.event.EventCenter;
import com.qzone.common.event.ui.model.PublishEventTag;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellBottomRecomm;
import com.qzone.proxy.feedcomponent.model.CellDynamicAlbum;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.proxy.feedcomponent.model.PictureUrl;
import com.qzone.proxy.feedcomponent.model.ShuoshuoVideoInfo;
import com.qzone.proxy.feedcomponent.model.VideoInfo;
import com.qzone.proxy.feedcomponent.model.VideoUrl;
import com.qzone.publish.ui.model.MediaWrapper;
import com.qzone.reborn.albumx.common.convert.bean.CommonAlbumInfo;
import com.qzone.reborn.albumx.qzone.local.QZoneUploadRecommendDirector;
import com.qzone.util.image.ImageInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;
import com.tencent.mobileqq.utils.bl;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LbsDataV2;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u000b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b8\u00109J\u001c\u0010\u0006\u001a\u00020\u00052\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002H\u0002Jp\u0010\u0016\u001a\u00020\u00152\b\u0010\b\u001a\u0004\u0018\u00010\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\f\u001a\u00020\u00032\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\"\u0010\u0010\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000ej\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013Jl\u0010\u0018\u001a\u00020\u00152\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\n2\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\"\u0010\u0010\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000ej\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\u000fJ\u0096\u0001\u0010\u001f\u001a\u00020\u00152\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0019\u001a\u0004\u0018\u00010\u00032\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00022\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0014\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00022\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002J\u0018\u0010\"\u001a\u0004\u0018\u00010\u00152\u0006\u0010!\u001a\u00020 2\u0006\u0010\f\u001a\u00020\u0003JD\u0010'\u001a\u00020\u00152\u0006\u0010\f\u001a\u00020\u00032\b\u0010\u0019\u001a\u0004\u0018\u00010\u00032\u0006\u0010!\u001a\u00020 2\b\u0010#\u001a\u0004\u0018\u00010\u00032\b\u0010%\u001a\u0004\u0018\u00010$2\u000e\u0010&\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tJ.\u0010*\u001a\u0004\u0018\u00010\u00152\u0006\u0010\f\u001a\u00020\u00032\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0006\u0010)\u001a\u00020(JD\u00101\u001a\u00020\u00052\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u001a\u0010.\u001a\u0016\u0012\u0004\u0012\u00020,\u0018\u00010+j\n\u0012\u0004\u0012\u00020,\u0018\u0001`-2\u0012\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030/J\u0012\u00102\u001a\u0004\u0018\u00010\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0007J$\u00104\u001a\u00020\u00052\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0006\u00103\u001a\u00020\u0015R\"\u00106\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u00105R\"\u00107\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u00105\u00a8\u0006:"}, d2 = {"Llc/c;", "", "", "", "localUrlMap", "", "c", "Lcooperation/qzone/LbsDataV2$PoiInfo;", "poiInfo", "", "Lcom/qzone/publish/ui/model/MediaWrapper;", "mediaList", "clientKey", "shootParams", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "extendInfo", "", PhotoCategorySinglePicInfo.UPLOAD_TIME, "Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumInfo;", "albumInfo", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "a", QAdVrReportParams.ParamKey.MEDIA, "b", "lbsAddress", "", "protoExtendInfo", "Lcom/qzone/common/event/ui/model/PublishEventTag;", "eventTag", "panoramaMap", "j", "Lcom/qzone/publish/ui/model/c;", "params", "i", "fakeContent", "Lcom/qzone/proxy/feedcomponent/model/ShuoshuoVideoInfo;", "shuoshuoVideoInfo", "imageFile", "d", "Lcom/qq/jce/wup/UniAttribute;", "uniAttr", "f", "Ljava/util/ArrayList;", "Lcom/qzone/util/image/ImageInfo;", "Lkotlin/collections/ArrayList;", "imageInfos", "", "panoramaInfos", "g", "e", "businessFeedData", tl.h.F, "Ljava/util/Map;", "mVideoLocalUrlMap", "mVideoCacheMap", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f414336a = new c();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static Map<String, String> mVideoLocalUrlMap = new LinkedHashMap();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static Map<String, String> mVideoCacheMap = new LinkedHashMap();

    c() {
    }

    private final void c(Map<String, String> localUrlMap) {
        boolean contains$default;
        for (Map.Entry<String, String> entry : localUrlMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (!TextUtils.isEmpty(key) && !TextUtils.isEmpty(value)) {
                contains$default = StringsKt__StringsKt.contains$default((CharSequence) value, (CharSequence) ".mp4", false, 2, (Object) null);
                if (contains$default) {
                    mVideoCacheMap.put(key, value);
                }
            }
        }
    }

    public final BusinessFeedData f(String clientKey, Map<String, String> localUrlMap, UniAttribute uniAttr) {
        Intrinsics.checkNotNullParameter(clientKey, "clientKey");
        Intrinsics.checkNotNullParameter(uniAttr, "uniAttr");
        single_feed single_feedVar = (single_feed) uniAttr.get("fakeSingleFeed");
        if (single_feedVar == null) {
            QZLog.e("QZPublishX_QZonePublishXFakeFeedDataTransformUtil", "publishSuccessRealFeedTransform  singleFeed == null");
            return null;
        }
        BusinessFeedData createFrom = BusinessFeedData.createFrom(single_feedVar, 4097);
        if (createFrom == null || createFrom.getUser().uin != LoginData.getInstance().getUin()) {
            return null;
        }
        createFrom.getFeedCommInfo().clientkey = clientKey;
        createFrom.getLocalInfo().setHalfReal();
        createFrom.setMixFake(0);
        VideoInfo videoInfo = createFrom.getVideoInfo();
        if (videoInfo != null) {
            videoInfo.isFakeFeed = false;
        }
        createFrom.getUser().nickName = LoginData.getInstance().getNickName(com.qzone.util.l.a(R.string.shh));
        h(localUrlMap, createFrom);
        return createFrom;
    }

    public final void g(List<? extends MediaWrapper> mediaList, ArrayList<ImageInfo> imageInfos, Map<String, String> panoramaInfos) {
        Intrinsics.checkNotNullParameter(mediaList, "mediaList");
        Intrinsics.checkNotNullParameter(panoramaInfos, "panoramaInfos");
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        for (MediaWrapper mediaWrapper : mediaList) {
            if (mediaWrapper.isImage()) {
                if (imageInfos != null) {
                    imageInfos.add(mediaWrapper.getImageInfo());
                }
                arrayList.add(mediaWrapper.getImageInfo().mPath);
                String str = mediaWrapper.getImageInfo().mPath;
                Intrinsics.checkNotNullExpressionValue(str, "media.imageInfo.mPath");
                ImageInfo imageInfo = mediaWrapper.getImageInfo();
                Intrinsics.checkNotNullExpressionValue(imageInfo, "media.imageInfo");
                hashMap.put(str, imageInfo);
            } else {
                arrayList.add(mediaWrapper.getVideoInfo().mVideoPath);
            }
            if (mediaWrapper.getImageInfo() != null) {
                String str2 = mediaWrapper.getImageInfo().mPath;
                Intrinsics.checkNotNullExpressionValue(str2, "media.imageInfo.mPath");
                panoramaInfos.put(str2, String.valueOf(mediaWrapper.getImageInfo().panoramaType));
            }
        }
        if (arrayList.size() > 0) {
            EventCenter eventCenter = EventCenter.getInstance();
            Object[] array = arrayList.toArray(new String[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            String[] strArr = (String[]) array;
            eventCenter.post("PHOTOUPLOADACTION", 1, Arrays.copyOf(strArr, strArr.length));
            QZoneUploadRecommendDirector.INSTANCE.a().E(arrayList);
        }
    }

    public final void h(Map<String, String> localUrlMap, BusinessFeedData businessFeedData) {
        boolean equals;
        VideoInfo videoInfo;
        Intrinsics.checkNotNullParameter(businessFeedData, "businessFeedData");
        if (localUrlMap != null) {
            f414336a.c(localUrlMap);
        }
        if (localUrlMap != null && businessFeedData.getPictureInfo() != null && businessFeedData.getPictureInfo().pics != null) {
            int size = businessFeedData.getPictureInfo().pics.size();
            for (int i3 = 0; i3 < size; i3++) {
                PictureItem pictureItem = businessFeedData.getPictureInfo().pics.get(i3);
                if (pictureItem.videoflag == 1 && (videoInfo = pictureItem.videodata) != null) {
                    String str = localUrlMap.get(videoInfo.videoId);
                    if (!TextUtils.isEmpty(str)) {
                        PictureUrl pictureUrl = pictureItem.currentUrl;
                        if (pictureUrl != null) {
                            pictureUrl.url = str;
                        }
                        pictureItem.localFileUrl = str;
                        VideoInfo videoInfo2 = pictureItem.videodata;
                        PictureUrl pictureUrl2 = videoInfo2.currentUrl;
                        if (pictureUrl2 != null) {
                            pictureUrl2.url = str;
                        }
                        VideoUrl videoUrl = videoInfo2.videoUrl;
                        if (videoUrl != null) {
                            videoUrl.url = str;
                        }
                        videoInfo2.playType = (byte) 0;
                        videoInfo2.videoShowType = 0;
                    }
                }
                if (TextUtils.isEmpty(pictureItem.clientFakeKey)) {
                    pictureItem.clientFakeKey = pictureItem.lloc;
                }
                if (localUrlMap.containsKey(pictureItem.clientFakeKey)) {
                    String str2 = localUrlMap.get(pictureItem.clientFakeKey);
                    if (!TextUtils.isEmpty(str2)) {
                        BitmapFactory.Options G = !URLUtil.isNetworkUrl(str2) ? com.qzone.util.image.c.G(str2) : null;
                        pictureItem.localFileUrl = str2;
                        if (G != null) {
                            equals = StringsKt__StringsJVMKt.equals("image/gif", G.outMimeType, true);
                            if (equals) {
                                pictureItem.currentUrl.pictureType = 2;
                                pictureItem.type = 2;
                            }
                            if (G.outWidth * 5 <= G.outHeight) {
                                pictureItem.setChangtuFlag(true);
                            }
                        }
                    }
                }
            }
            return;
        }
        if (localUrlMap == null || localUrlMap.isEmpty()) {
            return;
        }
        mVideoLocalUrlMap.putAll(localUrlMap);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00ab A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final BusinessFeedData i(com.qzone.publish.ui.model.c params, String clientKey) {
        String str;
        ShuoshuoVideoInfo shuoshuoVideoInfo;
        List<String> list;
        boolean startsWith$default;
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(clientKey, "clientKey");
        String a16 = m.f414350a.a(params.f51948j);
        if (params.f51950l && !TextUtils.isEmpty(params.f51934b)) {
            String str2 = params.f51934b;
            Intrinsics.checkNotNullExpressionValue(str2, "params.content");
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(str2, "qm", false, 2, null);
            if (startsWith$default) {
                String str3 = params.f51934b;
                Intrinsics.checkNotNullExpressionValue(str3, "params.content");
                str = str3.substring(2);
                Intrinsics.checkNotNullExpressionValue(str, "this as java.lang.String).substring(startIndex)");
                String str4 = str;
                shuoshuoVideoInfo = params.f51946h;
                if (shuoshuoVideoInfo != null) {
                    shuoshuoVideoInfo.mIsFakeFeed = true;
                }
                list = params.f51936c;
                if (list != null && list.size() > 0) {
                    EventCenter eventCenter = EventCenter.getInstance();
                    List<String> list2 = params.f51936c;
                    Intrinsics.checkNotNullExpressionValue(list2, "params.imageFiles");
                    Object[] array = list2.toArray(new String[0]);
                    Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                    String[] strArr = (String[]) array;
                    eventCenter.post("PHOTOUPLOADACTION", 1, Arrays.copyOf(strArr, strArr.length));
                }
                if (params.A) {
                    if (params.f51936c == null) {
                        params.f51936c = new ArrayList();
                    }
                    ShuoshuoVideoInfo shuoshuoVideoInfo2 = params.f51946h;
                    if (shuoshuoVideoInfo2 != null) {
                        params.f51936c.add(shuoshuoVideoInfo2.mCoverUrl);
                        params.f51946h = null;
                    }
                }
                if (params.W) {
                    return null;
                }
                return d(clientKey, a16, params, str4, params.f51946h, params.f51936c);
            }
        }
        str = params.f51934b;
        String str42 = str;
        shuoshuoVideoInfo = params.f51946h;
        if (shuoshuoVideoInfo != null) {
        }
        list = params.f51936c;
        if (list != null) {
            EventCenter eventCenter2 = EventCenter.getInstance();
            List<String> list22 = params.f51936c;
            Intrinsics.checkNotNullExpressionValue(list22, "params.imageFiles");
            Object[] array2 = list22.toArray(new String[0]);
            Intrinsics.checkNotNull(array2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            String[] strArr2 = (String[]) array2;
            eventCenter2.post("PHOTOUPLOADACTION", 1, Arrays.copyOf(strArr2, strArr2.length));
        }
        if (params.A) {
        }
        if (params.W) {
        }
    }

    public final String e(LbsDataV2.PoiInfo poiInfo) {
        if (TextUtils.isEmpty(poiInfo != null ? poiInfo.poiName : null)) {
            return m.f414350a.a(poiInfo);
        }
        return null;
    }

    public final BusinessFeedData d(String clientKey, String lbsAddress, com.qzone.publish.ui.model.c params, String fakeContent, ShuoshuoVideoInfo shuoshuoVideoInfo, List<String> imageFile) {
        CellBottomRecomm f16;
        Intrinsics.checkNotNullParameter(clientKey, "clientKey");
        Intrinsics.checkNotNullParameter(params, "params");
        BusinessFeedData businessFeedData = com.qzone.adapter.feedcomponent.f.B(clientKey, lbsAddress, params.f51959u, 0);
        String N0 = com.qzone.adapter.feedcomponent.f.N0(fakeContent);
        com.qzone.adapter.feedcomponent.f.s(businessFeedData, params.f51954p);
        businessFeedData.setVideoInfo(m.f414350a.h(shuoshuoVideoInfo));
        com.qzone.adapter.feedcomponent.f.l(businessFeedData, params.b());
        com.qzone.adapter.feedcomponent.f.o(businessFeedData, params.f51954p);
        com.qzone.adapter.feedcomponent.f.n(businessFeedData, params.E, params.f51954p);
        if (!bl.b(params.f51938d)) {
            CellDynamicAlbum cellDynamicAlbum = new CellDynamicAlbum();
            cellDynamicAlbum.layerTitle = q.b().g(params.f51938d.get(0));
            cellDynamicAlbum.layerText = params.f51938d.size() + "\u4e2a\u7cbe\u5f69\u77ac\u95f4";
            cellDynamicAlbum.opmask = CellDynamicAlbum.OPMASK;
            cellDynamicAlbum.buttonText = "\u64ad\u653e\u5f71\u96c6";
            businessFeedData.setCellDynamicAlbum(cellDynamicAlbum);
            ArrayList arrayList = new ArrayList();
            if (!bl.b(imageFile)) {
                Intrinsics.checkNotNull(imageFile);
                arrayList.add(imageFile.get(0));
            }
            com.qzone.adapter.feedcomponent.f.p(businessFeedData, "", N0, arrayList, 0L, null, params.L);
        } else {
            com.qzone.adapter.feedcomponent.f.q(businessFeedData, "", N0, imageFile, 0L, null, params.L, params.E);
        }
        if (params.C != null) {
            s_event_tag s_event_tagVar = new s_event_tag();
            PublishEventTag publishEventTag = params.C;
            s_event_tagVar.f24992id = publishEventTag.f45886id;
            s_event_tagVar.pic_url = publishEventTag.picUrl;
            s_event_tagVar.show_txt = publishEventTag.title;
            s_event_tagVar.show_desc = publishEventTag.desc;
            businessFeedData.setCellBottomRecomm(com.qzone.adapter.feedcomponent.f.e(s_event_tagVar));
        }
        Map<String, String> map = params.f51935b0;
        if (map != null && !TextUtils.isEmpty(map.get("comm_recom_bottom")) && (f16 = com.qzone.adapter.feedcomponent.f.f(params.f51935b0.get("comm_recom_bottom"))) != null) {
            businessFeedData.setCellBottomRecomm(f16);
        }
        com.qzone.adapter.feedcomponent.f.k(businessFeedData, params.f51935b0);
        Intrinsics.checkNotNullExpressionValue(businessFeedData, "businessFeedData");
        return businessFeedData;
    }

    public final BusinessFeedData b(LbsDataV2.PoiInfo poiInfo, String clientKey, MediaWrapper media, Map<String, String> shootParams, long uploadTime, CommonAlbumInfo albumInfo, HashMap<String, String> extendInfo) {
        String str;
        Intrinsics.checkNotNullParameter(clientKey, "clientKey");
        Intrinsics.checkNotNullParameter(media, "media");
        Intrinsics.checkNotNullParameter(extendInfo, "extendInfo");
        BusinessFeedData businessFeedData = com.qzone.adapter.feedcomponent.f.B(clientKey, e(poiInfo), 1, 4097);
        VideoInfo h16 = m.f414350a.h(media.getVideoInfo());
        h16.isFakeFeed = true;
        h16.isUploading = true;
        businessFeedData.setVideoInfo(h16);
        if (h16.isTranscoding) {
            Intrinsics.checkNotNull(businessFeedData);
            businessFeedData.getLocalInfo().setHalfReal();
        }
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(h16.desc)) {
            str = h16.desc;
            Intrinsics.checkNotNullExpressionValue(str, "videoInfo.desc");
        } else {
            str = "";
        }
        com.qzone.adapter.feedcomponent.f.s(businessFeedData, shootParams);
        com.qzone.adapter.feedcomponent.f.p(businessFeedData, "", str, arrayList, uploadTime, albumInfo, null);
        com.qzone.adapter.feedcomponent.f.u(businessFeedData, h16, albumInfo);
        com.qzone.adapter.feedcomponent.f.o(businessFeedData, extendInfo);
        com.qzone.adapter.feedcomponent.f.w(businessFeedData, albumInfo);
        com.qzone.adapter.feedcomponent.f.k(businessFeedData, extendInfo);
        if (businessFeedData.getRemarkInfoV2() != null) {
            businessFeedData.getRemarkInfoV2().remark = null;
        }
        Intrinsics.checkNotNullExpressionValue(businessFeedData, "businessFeedData");
        return businessFeedData;
    }

    public final BusinessFeedData a(LbsDataV2.PoiInfo poiInfo, List<? extends MediaWrapper> mediaList, String clientKey, Map<String, String> shootParams, HashMap<String, String> extendInfo, long uploadTime, CommonAlbumInfo albumInfo) {
        String str;
        Intrinsics.checkNotNullParameter(mediaList, "mediaList");
        Intrinsics.checkNotNullParameter(clientKey, "clientKey");
        Intrinsics.checkNotNullParameter(extendInfo, "extendInfo");
        Intrinsics.checkNotNullParameter(albumInfo, "albumInfo");
        String e16 = e(poiInfo);
        ArrayList<ImageInfo> arrayList = new ArrayList<>();
        HashMap hashMap = new HashMap();
        g(mediaList, arrayList, hashMap);
        BusinessFeedData businessFeedData = com.qzone.adapter.feedcomponent.f.B(clientKey, e16, 1, 4097);
        ArrayList arrayList2 = new ArrayList();
        Iterator<ImageInfo> it = arrayList.iterator();
        while (it.hasNext()) {
            String str2 = it.next().mPath;
            Intrinsics.checkNotNullExpressionValue(str2, "info.mPath");
            arrayList2.add(str2);
        }
        if (arrayList.size() > 0) {
            str = arrayList.get(0).mDescription;
        } else {
            str = "";
        }
        com.qzone.adapter.feedcomponent.f.s(businessFeedData, shootParams);
        com.qzone.adapter.feedcomponent.f.o(businessFeedData, extendInfo);
        com.qzone.adapter.feedcomponent.f.p(businessFeedData, "", str, arrayList2, uploadTime, albumInfo, hashMap);
        com.qzone.adapter.feedcomponent.f.w(businessFeedData, albumInfo);
        com.qzone.adapter.feedcomponent.f.k(businessFeedData, extendInfo);
        if (businessFeedData.getRemarkInfoV2() != null) {
            businessFeedData.getRemarkInfoV2().remark = null;
        }
        Intrinsics.checkNotNullExpressionValue(businessFeedData, "businessFeedData");
        return businessFeedData;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x011b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final BusinessFeedData j(String clientKey, long uploadTime, CommonAlbumInfo albumInfo, String lbsAddress, List<? extends MediaWrapper> mediaList, Map<String, String> extendInfo, Map<String, String> shootParams, Map<String, byte[]> protoExtendInfo, PublishEventTag eventTag, Map<String, String> panoramaMap) {
        int i3;
        BusinessFeedData businessFeedData;
        ArrayList arrayList;
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(clientKey, "clientKey");
        Intrinsics.checkNotNullParameter(mediaList, "mediaList");
        Intrinsics.checkNotNullParameter(extendInfo, "extendInfo");
        Intrinsics.checkNotNullParameter(panoramaMap, "panoramaMap");
        if (albumInfo == null && shootParams != null && (str2 = shootParams.get("shuoshuo_priv")) != null) {
            try {
                i3 = Integer.parseInt(str2);
            } catch (Exception e16) {
                QLog.e("QZPublishX_QZonePublishXFakeFeedDataTransformUtil", 1, "generateAlbumVideoMixFakeFeed  e=" + e16);
            }
            businessFeedData = com.qzone.adapter.feedcomponent.f.B(clientKey, lbsAddress, i3, 4097);
            arrayList = new ArrayList();
            String str3 = "";
            for (MediaWrapper mediaWrapper : mediaList) {
                if (q.b().p(mediaWrapper)) {
                    Object i16 = q.b().i(mediaWrapper);
                    String l3 = q.b().l(i16);
                    Intrinsics.checkNotNullExpressionValue(l3, "g().getPath(info)");
                    arrayList.add(l3);
                    if (TextUtils.isEmpty(str3)) {
                        str3 = q.b().f(i16);
                    }
                } else {
                    ShuoshuoVideoInfo shuoshuoVideoInfo = (ShuoshuoVideoInfo) q.b().j(mediaWrapper);
                    if (shuoshuoVideoInfo != null && (str = shuoshuoVideoInfo.mCoverUrl) != null) {
                        Intrinsics.checkNotNullExpressionValue(str, "info.mCoverUrl");
                        arrayList.add(str);
                    }
                    if (shuoshuoVideoInfo != null && TextUtils.isEmpty(str3)) {
                        str3 = shuoshuoVideoInfo.mDescription;
                    }
                }
            }
            if (arrayList.size() != mediaList.size()) {
                QLog.e("QZPublishX_QZonePublishXFakeFeedDataTransformUtil", 1, "albumVideoMixFakeFeedDataTransform, some media has no path!");
            }
            businessFeedData.setMixFake(1);
            com.qzone.adapter.feedcomponent.f.s(businessFeedData, shootParams);
            com.qzone.adapter.feedcomponent.f.o(businessFeedData, extendInfo);
            com.qzone.adapter.feedcomponent.f.l(businessFeedData, protoExtendInfo);
            com.qzone.adapter.feedcomponent.f.p(businessFeedData, "", str3, arrayList, uploadTime, albumInfo, panoramaMap);
            if (businessFeedData.getPictureInfo() != null) {
                com.qzone.adapter.feedcomponent.f.v(businessFeedData.getPictureInfo(), mediaList);
            }
            com.qzone.adapter.feedcomponent.f.w(businessFeedData, albumInfo);
            com.qzone.adapter.feedcomponent.f.k(businessFeedData, extendInfo);
            if (businessFeedData.getRemarkInfoV2() != null) {
                businessFeedData.getRemarkInfoV2().remark = null;
            }
            if (eventTag != null) {
                s_event_tag s_event_tagVar = new s_event_tag();
                s_event_tagVar.f24992id = eventTag.f45886id;
                s_event_tagVar.pic_url = eventTag.picUrl;
                s_event_tagVar.show_txt = eventTag.title;
                s_event_tagVar.show_desc = eventTag.desc;
                businessFeedData.setCellBottomRecomm(com.qzone.adapter.feedcomponent.f.e(s_event_tagVar));
            }
            Intrinsics.checkNotNullExpressionValue(businessFeedData, "businessFeedData");
            return businessFeedData;
        }
        i3 = 1;
        businessFeedData = com.qzone.adapter.feedcomponent.f.B(clientKey, lbsAddress, i3, 4097);
        arrayList = new ArrayList();
        String str32 = "";
        while (r1.hasNext()) {
        }
        if (arrayList.size() != mediaList.size()) {
        }
        businessFeedData.setMixFake(1);
        com.qzone.adapter.feedcomponent.f.s(businessFeedData, shootParams);
        com.qzone.adapter.feedcomponent.f.o(businessFeedData, extendInfo);
        com.qzone.adapter.feedcomponent.f.l(businessFeedData, protoExtendInfo);
        com.qzone.adapter.feedcomponent.f.p(businessFeedData, "", str32, arrayList, uploadTime, albumInfo, panoramaMap);
        if (businessFeedData.getPictureInfo() != null) {
        }
        com.qzone.adapter.feedcomponent.f.w(businessFeedData, albumInfo);
        com.qzone.adapter.feedcomponent.f.k(businessFeedData, extendInfo);
        if (businessFeedData.getRemarkInfoV2() != null) {
        }
        if (eventTag != null) {
        }
        Intrinsics.checkNotNullExpressionValue(businessFeedData, "businessFeedData");
        return businessFeedData;
    }
}
