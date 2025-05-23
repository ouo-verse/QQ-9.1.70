package com.qzone.preview;

import NS_FASHION_FEEDS_TAG_PROTO.GetPicTagBinRspNode;
import NS_FASHION_FEEDS_TAG_PROTO.PicTagInfo;
import NS_FASHION_FEEDS_TAG_PROTO.TagInfo;
import NS_MOBILE_FEEDS.s_pic_host;
import NS_MOBILE_FEEDS.s_picdata;
import NS_MOBILE_FEEDS.stPhotoTag;
import NS_MOBILE_OPERATION.PicInfo;
import NS_MOBILE_PHOTO.Photo;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.qzone.album.business.search.SearchFilterComposition;
import com.qzone.album.data.model.AlbumCacheData;
import com.qzone.album.data.model.AlbumImageTagInfo;
import com.qzone.album.data.model.PhotoCacheData;
import com.qzone.album.data.model.PhotoCategorySinglePicInfo;
import com.qzone.album.util.QZoneAlbumUtil;
import com.qzone.common.account.LoginData;
import com.qzone.misc.network.report.QzoneFeedVisitorReportService;
import com.qzone.preview.service.base.PictureConst;
import com.qzone.proxy.feedcomponent.model.CellFeedCommInfo;
import com.qzone.proxy.feedcomponent.model.CellPictureInfo;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.proxy.feedcomponent.model.VideoInfo;
import com.qzone.reborn.configx.g;
import com.qzone.reborn.layer.fragment.QZoneFeedxLayerFragment;
import com.qzone.reborn.layer.fragment.QZoneSingleVideoLayerFragment;
import com.qzone.reborn.layer.part.QZoneFeedXGalleryActivity;
import com.qzone.reborn.layer.part.ac;
import com.tencent.biz.richframework.activity.CompatPublicActivity;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.util.RFWFileUtils;
import com.tencent.component.media.image.ImageKey;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.gallery.RFWLayerFragment;
import com.tencent.richframework.gallery.RFWLayerLaunchUtil;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerPicInfo;
import com.tencent.richframework.gallery.bean.RFWLayerVideoInfo;
import com.tencent.util.Pair;
import common.config.service.QzoneConfig;
import cooperation.peak.PeakConstants;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.api.QZoneApiProxy;
import cooperation.qzone.model.CellColorfulTail;
import cooperation.qzone.model.FaceData;
import cooperation.qzone.model.ImageTagInfo;
import cooperation.qzone.model.PhotoInfo;
import cooperation.qzone.model.PhotoParam;
import cooperation.qzone.model.PictureUrl;
import cooperation.qzone.model.VideoInfo;
import cooperation.qzone.model.VideoUrl;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import ho.i;
import j8.a;
import j8.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import k8.a;
import k8.b;
import k8.c;
import k8.d;
import l8.a;
import l8.b;
import l8.c;
import photo_share_struct.pic_host;
import tk.h;

/* loaded from: classes39.dex */
public class PictureViewerFactory {
    public static Class<? extends RFWLayerFragment> B(PhotoParam photoParam, List<PhotoInfo> list) {
        if (F(photoParam, list)) {
            return QZoneSingleVideoLayerFragment.class;
        }
        return QZoneFeedxLayerFragment.class;
    }

    public static ArrayList<PhotoInfo> C(CellPictureInfo cellPictureInfo, CellFeedCommInfo cellFeedCommInfo, PhotoParam photoParam, int i3) {
        int i16;
        ArrayList<PhotoInfo> arrayList = new ArrayList<>();
        int size = cellPictureInfo.pics.size();
        for (int i17 = 0; i17 < size; i17++) {
            PhotoInfo photoInfo = new PhotoInfo();
            PictureItem pictureItem = cellPictureInfo.pics.get(i17);
            if (TextUtils.isEmpty(pictureItem.albumId)) {
                pictureItem.albumId = cellPictureInfo.albumid;
            }
            j0(photoInfo, pictureItem, photoParam.isTihFeed);
            photoInfo.allow_share = cellPictureInfo.allow_share;
            photoInfo.appid = photoParam.appid;
            if (size == 1 && ((i16 = photoInfo.flag) == 16 || i16 == 32)) {
                photoInfo.bigUrl = photoInfo.currentUrl;
            }
            if (cellFeedCommInfo != null) {
                photoInfo.opMask = cellFeedCommInfo.operatemask;
            }
            if (photoParam.isOnePictureFeed && i17 == i3) {
                String str = photoInfo.lloc;
                if (str == null) {
                    str = "null";
                }
                photoParam.oneFeedPictruePath = str;
                photoInfo.hasPraise = photoParam.isLike;
                photoInfo.praiseCount = photoParam.likeNum;
            }
            photoInfo.videoUgcRight = photoParam.videoUgcRight;
            arrayList.add(photoInfo);
        }
        return arrayList;
    }

    public static ArrayList<TagInfo> D(Photo photo) {
        GetPicTagBinRspNode getPicTagBinRspNode;
        PicTagInfo picTagInfo;
        if (photo == null) {
            return null;
        }
        try {
            if (!photo.binaryExtInfo.containsKey("fashion_tag_info") || (getPicTagBinRspNode = (GetPicTagBinRspNode) t5.b.b(GetPicTagBinRspNode.class, photo.binaryExtInfo.get("fashion_tag_info"))) == null || (picTagInfo = getPicTagBinRspNode.stPicTagInfo) == null) {
                return null;
            }
            return picTagInfo.vecTagInfo;
        } catch (Exception unused) {
            return null;
        }
    }

    public static int E(CellFeedCommInfo cellFeedCommInfo) {
        Map<String, String> map;
        int i3;
        if (cellFeedCommInfo == null || (map = cellFeedCommInfo.extendInfo) == null || !map.containsKey("is_feeds_long_pics_browsing_mode")) {
            return 0;
        }
        try {
            i3 = Integer.parseInt(cellFeedCommInfo.extendInfo.get("is_feeds_long_pics_browsing_mode"));
        } catch (Exception e16) {
            QZLog.e("PictureViewerFactory", 1, "showFeedPictureViewer parseInt e:", e16);
            i3 = 0;
        }
        QZLog.d("PictureViewerFactory", 1, "showFeedPictureViewer showType:", Integer.valueOf(i3));
        return i3;
    }

    public static void K(Activity activity, long j3, List<PhotoCategorySinglePicInfo> list, ArrayList<PhotoCacheData> arrayList, int i3, boolean z16, int i16) {
        Pair<ArrayList<AlbumCacheData>, ArrayList<PhotoCacheData>> w3 = w(list);
        ArrayList<PhotoParam> l06 = l0(w3.first);
        ArrayList<PhotoCacheData> arrayList2 = w3.second;
        W(activity, j3, arrayList2, i3, l06, A(l06, arrayList2, i3), z16, i16, 9, new a.C10640a().r(z(list)).p(x(list)).q(y(list)));
    }

    public static void S(Activity activity, ArrayList<PictureItem> arrayList, int i3) {
        int size = arrayList.size();
        ArrayList arrayList2 = new ArrayList();
        for (int i16 = 0; i16 < size; i16++) {
            PhotoInfo photoInfo = new PhotoInfo();
            j0(photoInfo, arrayList.get(i16), false);
            arrayList2.add(photoInfo);
        }
        i8.b.c(activity).i(new m8.a(i3, 0, null, arrayList2)).g(activity, -1, true);
    }

    private static void V(Activity activity, String str, PhotoParam photoParam, ArrayList<PhotoInfo> arrayList, int i3, int i16, int i17, View view) {
        QZoneHelper.UserInfo userInfo = QZoneHelper.UserInfo.getInstance();
        userInfo.qzone_uin = str;
        Bundle bundle = new Bundle();
        bundle.putSerializable("picturelist", arrayList);
        bundle.putInt("curindex", i3);
        bundle.putParcelable("photo_param", photoParam);
        bundle.putInt("mode", 2);
        bundle.putBoolean("need_clear_cache", true);
        bundle.putInt(PeakConstants.KEY_SHOW_TYPE, i16);
        if (i16 == 0) {
            QLog.i("PictureViewerFactory", 1, "launch main process Newlayer");
            RFWLayerLaunchUtil.jumpToGallery(activity, view instanceof ImageView ? (ImageView) view : null, j(arrayList), i3, (Class<? extends CompatPublicActivity>) QZoneFeedXGalleryActivity.class, B(photoParam, arrayList), bundle);
        } else {
            QZoneHelper.forwardToPictureViewerForQzone(activity, userInfo, bundle, i17);
        }
    }

    public static void c(PhotoInfo photoInfo, RFWLayerItemMediaInfo rFWLayerItemMediaInfo) {
        RFWLayerVideoInfo rFWLayerVideoInfo = new RFWLayerVideoInfo();
        VideoInfo videoInfo = photoInfo.videodata;
        if (videoInfo == null) {
            RFWLog.e("PictureViewerFactory", RFWLog.USR, "error video data");
            return;
        }
        VideoUrl videoUrl = videoInfo.videoUrl;
        if (videoUrl == null || TextUtils.isEmpty(videoUrl.url)) {
            RFWLog.e("PictureViewerFactory", RFWLog.USR, "invalid photo info id is " + photoInfo.lloc + " invalid photo video info id is " + photoInfo.videodata.videoId);
        }
        rFWLayerVideoInfo.setNormalVideoUrl(h.r(photoInfo.videodata));
        rFWLayerVideoInfo.setFileId(photoInfo.videodata.videoId);
        VideoUrl videoUrl2 = photoInfo.videodata.originVideoUrl;
        if (videoUrl2 != null) {
            rFWLayerVideoInfo.setVideoOriginUrl(videoUrl2.url);
        }
        rFWLayerVideoInfo.setCurrentVideoUrl(rFWLayerVideoInfo.getNormalVideoUrl());
        if (ac.J.contains(rFWLayerVideoInfo.getPlayId()) && rFWLayerVideoInfo.getVideoOriginUrl() != null && !TextUtils.isEmpty(rFWLayerVideoInfo.getVideoOriginUrl())) {
            rFWLayerVideoInfo.setCurrentVideoUrl(rFWLayerVideoInfo.getVideoOriginUrl());
        }
        rFWLayerItemMediaInfo.setLayerVideoInfo(rFWLayerVideoInfo);
    }

    private static void d(PhotoInfo photoInfo, RFWLayerPicInfo rFWLayerPicInfo) {
        if (!TextUtils.isEmpty(photoInfo.currentUrl)) {
            rFWLayerPicInfo.getCurrentPicInfo().setUrl(photoInfo.currentUrl);
            rFWLayerPicInfo.getCurrentPicInfo().setLocalPath(com.tencent.mobileqq.qzone.picload.c.a().d(Option.obtain().setUrl(photoInfo.currentUrl)));
        } else if (!TextUtils.isEmpty(photoInfo.bigUrl)) {
            rFWLayerPicInfo.getCurrentPicInfo().setUrl(photoInfo.bigUrl);
            rFWLayerPicInfo.getCurrentPicInfo().setLocalPath(com.tencent.mobileqq.qzone.picload.c.a().d(Option.obtain().setUrl(photoInfo.bigUrl)));
        } else {
            rFWLayerPicInfo.getCurrentPicInfo().setUrl(photoInfo.downloadUrl);
            rFWLayerPicInfo.getCurrentPicInfo().setLocalPath(com.tencent.mobileqq.qzone.picload.c.a().d(Option.obtain().setUrl(photoInfo.downloadUrl)));
        }
    }

    public static void d0(Activity activity, PictureItem pictureItem) {
        ArrayList arrayList = new ArrayList();
        PhotoInfo photoInfo = new PhotoInfo();
        j0(photoInfo, pictureItem, false);
        arrayList.add(photoInfo);
        i8.b.a(activity).i(new m8.a(0, 0, null, arrayList)).g(activity, -1, true);
    }

    private static void e(PhotoInfo photoInfo, RFWLayerPicInfo rFWLayerPicInfo) {
        if (rFWLayerPicInfo.getSmallPicInfo() != null) {
            QLog.i("PictureViewerFactory", 4, "user small pic info");
            rFWLayerPicInfo.setCurrentPicInfo(rFWLayerPicInfo.getSmallPicInfo());
            return;
        }
        if (rFWLayerPicInfo.getBigPicInfo() != null) {
            QLog.i("PictureViewerFactory", 1, "user big pic info");
            rFWLayerPicInfo.setCurrentPicInfo(rFWLayerPicInfo.getBigPicInfo());
            return;
        }
        if (rFWLayerPicInfo.getDownloadPicInfo() != null) {
            QLog.i("PictureViewerFactory", 1, "user download pic info");
            rFWLayerPicInfo.setCurrentPicInfo(rFWLayerPicInfo.getDownloadPicInfo());
            rFWLayerPicInfo.getCurrentPicInfo().setWidth(photoInfo.mCurrentUrlWith);
            rFWLayerPicInfo.getCurrentPicInfo().setHeight(photoInfo.mCurrentUrlHeight);
            return;
        }
        if (TextUtils.isEmpty(photoInfo.currentUrl)) {
            return;
        }
        QLog.i("PictureViewerFactory", 1, "user current pic info");
        rFWLayerPicInfo.getCurrentPicInfo().setUrl(photoInfo.currentUrl);
        rFWLayerPicInfo.getCurrentPicInfo().setLocalPath(com.tencent.mobileqq.qzone.picload.c.a().d(Option.obtain().setUrl(photoInfo.currentUrl)));
        rFWLayerPicInfo.getCurrentPicInfo().setWidth(photoInfo.mCurrentUrlWith);
        rFWLayerPicInfo.getCurrentPicInfo().setHeight(photoInfo.mCurrentUrlHeight);
    }

    public static ArrayList<PhotoInfo> e0(List<PhotoCacheData> list) {
        ArrayList<PhotoInfo> arrayList = new ArrayList<>();
        if (list != null && !list.isEmpty()) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                PhotoInfo photoInfo = new PhotoInfo();
                h0(photoInfo, list.get(i3));
                arrayList.add(photoInfo);
            }
        }
        return arrayList;
    }

    public static List<RFWLayerItemMediaInfo> g(List<PhotoInfo> list) {
        ArrayList arrayList = new ArrayList();
        boolean f16 = f(list);
        for (PhotoInfo photoInfo : list) {
            RFWLayerItemMediaInfo rFWLayerItemMediaInfo = new RFWLayerItemMediaInfo();
            rFWLayerItemMediaInfo.setLayerPicInfo(new RFWLayerPicInfo());
            if (!f16) {
                rFWLayerItemMediaInfo.getLayerPicInfo().setPicId(photoInfo.getPicId());
            } else if (!TextUtils.isEmpty(photoInfo.bigUrl)) {
                rFWLayerItemMediaInfo.getLayerPicInfo().setPicId(ImageKey.getUrlKey(photoInfo.bigUrl, true));
            }
            if (photoInfo.videodata != null && photoInfo.isVideo()) {
                c(photoInfo, rFWLayerItemMediaInfo);
            }
            a(photoInfo, rFWLayerItemMediaInfo.getLayerPicInfo());
            rFWLayerItemMediaInfo.setExtraData(photoInfo);
            arrayList.add(rFWLayerItemMediaInfo);
        }
        return arrayList;
    }

    public static List<RFWLayerItemMediaInfo> j(List<PhotoInfo> list) {
        ArrayList arrayList = new ArrayList();
        boolean f16 = f(list);
        for (PhotoInfo photoInfo : list) {
            RFWLayerItemMediaInfo rFWLayerItemMediaInfo = new RFWLayerItemMediaInfo();
            rFWLayerItemMediaInfo.setLayerPicInfo(new RFWLayerPicInfo());
            if (!f16) {
                rFWLayerItemMediaInfo.getLayerPicInfo().setPicId(photoInfo.getPicId());
            } else if (!TextUtils.isEmpty(photoInfo.bigUrl)) {
                rFWLayerItemMediaInfo.getLayerPicInfo().setPicId(ImageKey.getUrlKey(photoInfo.bigUrl, true));
            }
            if (photoInfo.videodata != null && photoInfo.isVideo()) {
                c(photoInfo, rFWLayerItemMediaInfo);
            }
            b(photoInfo, rFWLayerItemMediaInfo.getLayerPicInfo());
            rFWLayerItemMediaInfo.setExtraData(photoInfo);
            arrayList.add(rFWLayerItemMediaInfo);
        }
        return arrayList;
    }

    public static ArrayList<PhotoParam> l0(ArrayList<AlbumCacheData> arrayList) {
        ArrayList<PhotoParam> arrayList2 = new ArrayList<>();
        Iterator<AlbumCacheData> it = arrayList.iterator();
        while (it.hasNext()) {
            AlbumCacheData next = it.next();
            if (next != null) {
                PhotoParam photoParam = new PhotoParam();
                long j3 = next.ownerUin;
                photoParam.ownerUin = j3;
                photoParam.feedUin = j3;
                photoParam.albumid = next.albumid;
                photoParam.albumType = next.albumtype;
                int i3 = next.albumnum;
                photoParam.albumnum = i3;
                photoParam.uploadnum = i3;
                photoParam.albumPriv = next.albumrights;
                String str = next.albumanswer;
                photoParam.albumanswer = str;
                if (str == null) {
                    photoParam.albumanswer = "";
                }
                photoParam.loginUin = LoginData.getInstance().getUin();
                photoParam.cell_id = photoParam.albumid;
                Map<Integer, String> map = next.busi_param;
                photoParam.busi_param = map;
                if (map != null) {
                    photoParam.orgKey = map.get(5);
                    photoParam.curKey = photoParam.busi_param.get(6);
                }
                photoParam.mFromRecent = true;
                photoParam.isShareAlbum = next.isSharingAlbumOnServer();
                arrayList2.add(photoParam);
            }
        }
        return arrayList2;
    }

    private static boolean u() {
        if (!RFWApplication.isPublicVersion()) {
            return gd.a.f401926a.c("KEY_ENABLE_USE_NEW_ALBUM_SELECT_LAYER", true);
        }
        return g.f53821a.b().S();
    }

    public static Pair<ArrayList<AlbumCacheData>, ArrayList<PhotoCacheData>> w(List<PhotoCategorySinglePicInfo> list) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (list != null && !list.isEmpty()) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                if (list.get(i3) != null) {
                    AlbumCacheData albumCacheData = list.get(i3).albumInfo;
                    if (I(albumCacheData, arrayList)) {
                        arrayList.add(albumCacheData);
                    }
                    arrayList2.add(list.get(i3).singlePicInfo);
                }
            }
            return new Pair<>(arrayList, arrayList2);
        }
        return new Pair<>(arrayList, arrayList2);
    }

    private static String x(List<PhotoCategorySinglePicInfo> list) {
        if (list != null && !list.isEmpty()) {
            for (PhotoCategorySinglePicInfo photoCategorySinglePicInfo : list) {
                if (photoCategorySinglePicInfo != null) {
                    return photoCategorySinglePicInfo.categoryId;
                }
            }
        }
        return "";
    }

    private static void a(PhotoInfo photoInfo, RFWLayerPicInfo rFWLayerPicInfo) {
        v(photoInfo, rFWLayerPicInfo, true);
        if (rFWLayerPicInfo.getOriginPicInfo() != null && RFWFileUtils.fileExists(rFWLayerPicInfo.getOriginPicInfo().getLocalPath())) {
            QLog.i("PictureViewerFactory", 1, "user origin pic");
            rFWLayerPicInfo.setSmallPicInfo(rFWLayerPicInfo.getOriginPicInfo());
            if (rFWLayerPicInfo.getSmallPicInfo() != null) {
                rFWLayerPicInfo.setCurrentPicInfo(rFWLayerPicInfo.getSmallPicInfo());
                return;
            } else {
                rFWLayerPicInfo.setCurrentPicInfo(rFWLayerPicInfo.getOriginPicInfo());
                return;
            }
        }
        if (rFWLayerPicInfo.getBigPicInfo() != null && rFWLayerPicInfo.getBigPicInfo().getWidth() != 0 && (rFWLayerPicInfo.getBigPicInfo().getHeight() * 1.0d) / rFWLayerPicInfo.getBigPicInfo().getWidth() > 2.5d) {
            QLog.i("PictureViewerFactory", 1, "user big pic");
            rFWLayerPicInfo.setSmallPicInfo(rFWLayerPicInfo.getBigPicInfo());
            if (rFWLayerPicInfo.getSmallPicInfo() != null) {
                rFWLayerPicInfo.setCurrentPicInfo(rFWLayerPicInfo.getSmallPicInfo());
                return;
            } else {
                rFWLayerPicInfo.setCurrentPicInfo(rFWLayerPicInfo.getBigPicInfo());
                return;
            }
        }
        rFWLayerPicInfo.setCurrentPicInfo(new RFWLayerPicInfo.RFWPicInfo());
        e(photoInfo, rFWLayerPicInfo);
    }

    public static void b(PhotoInfo photoInfo, RFWLayerPicInfo rFWLayerPicInfo) {
        v(photoInfo, rFWLayerPicInfo, false);
        if (rFWLayerPicInfo.getOriginPicInfo() != null && RFWFileUtils.fileExists(rFWLayerPicInfo.getOriginPicInfo().getLocalPath())) {
            rFWLayerPicInfo.setCurrentPicInfo(rFWLayerPicInfo.getOriginPicInfo());
            return;
        }
        if (rFWLayerPicInfo.getBigPicInfo() != null && rFWLayerPicInfo.getBigPicInfo().getWidth() != 0 && (rFWLayerPicInfo.getBigPicInfo().getHeight() * 1.0d) / rFWLayerPicInfo.getBigPicInfo().getWidth() > 2.5d) {
            rFWLayerPicInfo.setCurrentPicInfo(rFWLayerPicInfo.getBigPicInfo());
            return;
        }
        rFWLayerPicInfo.setCurrentPicInfo(new RFWLayerPicInfo.RFWPicInfo());
        d(photoInfo, rFWLayerPicInfo);
        rFWLayerPicInfo.getCurrentPicInfo().setWidth(photoInfo.mCurrentUrlWith);
        rFWLayerPicInfo.getCurrentPicInfo().setHeight(photoInfo.mCurrentUrlHeight);
        if (rFWLayerPicInfo.getBigPicInfo() != null) {
            rFWLayerPicInfo.setSmallPicInfo(rFWLayerPicInfo.getCurrentPicInfo());
            rFWLayerPicInfo.setCurrentPicInfo(rFWLayerPicInfo.getBigPicInfo());
        }
    }

    public static void j0(PhotoInfo photoInfo, PictureItem pictureItem, boolean z16) {
        k0(photoInfo, pictureItem, z16, false);
    }

    public static void J(Activity activity, List<PhotoCategorySinglePicInfo> list, ArrayList<PhotoCacheData> arrayList, int i3, int i16, int i17, int i18) {
        Pair<ArrayList<AlbumCacheData>, ArrayList<PhotoCacheData>> w3 = w(list);
        ArrayList<PhotoParam> l06 = l0(w3.first);
        ArrayList<PhotoCacheData> arrayList2 = w3.second;
        ArrayList<String> c16 = com.qzone.album.util.a.c(arrayList);
        PhotoParam A = A(l06, arrayList2, i3);
        new a.C10640a().r(z(list)).p(x(list)).q(y(list)).a();
        T(activity, arrayList2, i3, A, i18, i16, arrayList2.get(i3).index, arrayList2.size(), c16, i17, 0, false, 9);
    }

    public static void Q(Activity activity, CellPictureInfo cellPictureInfo, CellFeedCommInfo cellFeedCommInfo, int i3, int i16, PhotoParam photoParam, boolean z16, boolean z17) {
        ArrayList<PictureItem> arrayList;
        String l3;
        if (cellPictureInfo == null || (arrayList = cellPictureInfo.pics) == null) {
            return;
        }
        int size = arrayList.size();
        ArrayList arrayList2 = new ArrayList();
        int i17 = i3;
        for (int i18 = 0; i18 < size; i18++) {
            PhotoInfo photoInfo = new PhotoInfo();
            k0(photoInfo, cellPictureInfo.pics.get(i18), false, z16);
            if (!z16 || !cellPictureInfo.isVideoPicMix() || cellPictureInfo.pics.get(i18).videoflag != 1) {
                arrayList2.add(photoInfo);
            } else if (i18 < i3) {
                i17--;
            }
        }
        if (photoParam != null) {
            photoParam.loginUin = LoginData.getInstance().getUin();
        }
        int E = E(cellFeedCommInfo);
        if (!QZoneApiProxy.isInQZoneEnvironment()) {
            if (photoParam != null) {
                l3 = Long.toString(photoParam.ownerUin);
            } else {
                l3 = Long.toString(cellPictureInfo.uin);
            }
            U(activity, l3, photoParam, arrayList2, i17, E, i16);
            return;
        }
        i8.b.c(activity).i(new m8.a(i17, 0, photoParam, arrayList2)).c(new b.a().d(E).a()).b(new a.C10575a().c(z16).g(z16).d(z17).a()).a(z17, 67108864).g(activity, i16, true);
    }

    private static ArrayList<ImageTagInfo> i(List<AlbumImageTagInfo> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        ArrayList<ImageTagInfo> arrayList = new ArrayList<>();
        Iterator<AlbumImageTagInfo> it = list.iterator();
        while (it.hasNext()) {
            ImageTagInfo h16 = h(it.next());
            if (h16 != null) {
                arrayList.add(h16);
            }
        }
        return arrayList;
    }

    private static String y(List<PhotoCategorySinglePicInfo> list) {
        if (list != null && !list.isEmpty()) {
            return list.get(list.size() - 1).pageStr;
        }
        return "";
    }

    public static boolean F(PhotoParam photoParam, List<PhotoInfo> list) {
        return list != null && list.size() == 1 && list.get(0) != null && list.get(0).isVideo() && photoParam != null && TextUtils.isEmpty(photoParam.albumid);
    }

    private static void G(PhotoInfo photoInfo) {
        VideoInfo videoInfo;
        if (photoInfo == null || photoInfo.videoflag != 1 || (videoInfo = photoInfo.videodata) == null) {
            return;
        }
        PictureUrl pictureUrl = videoInfo.bigUrl;
        if (pictureUrl != null && !TextUtils.isEmpty(pictureUrl.url)) {
            photoInfo.bigUrl = videoInfo.bigUrl.url;
        }
        PictureUrl pictureUrl2 = videoInfo.currentUrl;
        if (pictureUrl2 != null && !TextUtils.isEmpty(pictureUrl2.url)) {
            photoInfo.currentUrl = videoInfo.currentUrl.url;
        }
        PictureUrl pictureUrl3 = videoInfo.originUrl;
        if (pictureUrl3 == null || TextUtils.isEmpty(pictureUrl3.url)) {
            return;
        }
        photoInfo.orgUrl = videoInfo.originUrl.url;
    }

    private static boolean I(AlbumCacheData albumCacheData, ArrayList<AlbumCacheData> arrayList) {
        String str;
        if (albumCacheData == null || albumCacheData.albumid == null || arrayList == null) {
            return false;
        }
        Iterator<AlbumCacheData> it = arrayList.iterator();
        while (it.hasNext()) {
            AlbumCacheData next = it.next();
            if (next != null && (str = next.albumid) != null && str.equals(albumCacheData.albumid)) {
                return false;
            }
        }
        return true;
    }

    private static boolean f(List<PhotoInfo> list) {
        if (list == null || list.size() < 2) {
            return false;
        }
        String str = list.get(0).lloc;
        String str2 = list.get(1).lloc;
        String str3 = list.get(0).sloc;
        String str4 = list.get(1).sloc;
        QLog.i("PictureViewerFactory", 1, "firstId: " + str + " secondId:" + str2 + "firstSId:" + str3 + " secondSId:" + str4);
        return (!TextUtils.isEmpty(str) && Objects.equals(str, str2)) || (!TextUtils.isEmpty(str3) && Objects.equals(str3, str4));
    }

    private static void v(PhotoInfo photoInfo, RFWLayerPicInfo rFWLayerPicInfo, boolean z16) {
        if (photoInfo == null) {
            return;
        }
        int i3 = photoInfo.mBigUrlWidth;
        int i16 = photoInfo.mBigUrlHeight;
        if (i3 == 0 || i16 == 0) {
            i3 = photoInfo.mOriginWidth;
            i16 = photoInfo.mOriginHeight;
        }
        String str = photoInfo.bigUrl;
        if (str != null && !TextUtils.isEmpty(str)) {
            RFWLayerPicInfo.RFWPicInfo rFWPicInfo = new RFWLayerPicInfo.RFWPicInfo();
            rFWPicInfo.setUrl(photoInfo.bigUrl);
            rFWPicInfo.setLocalPath(com.tencent.mobileqq.qzone.picload.c.a().d(Option.obtain().setUrl(photoInfo.bigUrl)));
            rFWPicInfo.setWidth(i3);
            rFWPicInfo.setHeight(i16);
            if (z16) {
                rFWLayerPicInfo.setSmallPicInfo(rFWPicInfo);
            } else {
                rFWLayerPicInfo.setBigPicInfo(rFWPicInfo);
            }
        }
        String str2 = photoInfo.orgUrl;
        if (str2 != null && !TextUtils.isEmpty(str2) && !photoInfo.isVideo()) {
            RFWLayerPicInfo.RFWPicInfo rFWPicInfo2 = new RFWLayerPicInfo.RFWPicInfo();
            rFWPicInfo2.setUrl(photoInfo.orgUrl);
            rFWPicInfo2.setSize(photoInfo.originSize);
            rFWPicInfo2.setLocalPath(com.tencent.mobileqq.qzone.picload.c.a().d(Option.obtain().setUrl(photoInfo.orgUrl)));
            rFWPicInfo2.setWidth(i3);
            rFWPicInfo2.setHeight(i16);
            if (z16) {
                rFWLayerPicInfo.setSmallPicInfo(rFWPicInfo2);
            } else {
                rFWLayerPicInfo.setOriginPicInfo(rFWPicInfo2);
            }
        }
        if (photoInfo.downloadUrl != null) {
            RFWLayerPicInfo.RFWPicInfo rFWPicInfo3 = new RFWLayerPicInfo.RFWPicInfo();
            rFWPicInfo3.setUrl(photoInfo.downloadUrl);
            rFWPicInfo3.setLocalPath(com.tencent.mobileqq.qzone.picload.c.a().d(Option.obtain().setUrl(photoInfo.downloadUrl)));
            rFWLayerPicInfo.setDownloadPicInfo(rFWPicInfo3);
        }
    }

    private static int z(List<PhotoCategorySinglePicInfo> list) {
        if (list != null && !list.isEmpty()) {
            for (PhotoCategorySinglePicInfo photoCategorySinglePicInfo : list) {
                if (photoCategorySinglePicInfo != null) {
                    return photoCategorySinglePicInfo.categoryType;
                }
            }
        }
        return 0;
    }

    private static void Z(Activity activity, long j3, List<PhotoCacheData> list, AlbumCacheData albumCacheData, int i3, ArrayList<PhotoParam> arrayList, PhotoParam photoParam, boolean z16, int i16, int i17, c.a aVar) {
        if (list != null && !list.isEmpty() && albumCacheData != null) {
            Iterator<PhotoCacheData> it = list.iterator();
            while (it.hasNext()) {
                it.next().albumName = albumCacheData.albumname;
            }
        }
        X(activity, j3, list, i3, arrayList, photoParam, z16, i16, i17, aVar, true);
    }

    private static void c0(Activity activity, long j3, List<PhotoCacheData> list, AlbumCacheData albumCacheData, int i3, ArrayList<PhotoParam> arrayList, PhotoParam photoParam, boolean z16, int i16, int i17, c.a aVar, ArrayList<String> arrayList2, int i18, int i19) {
        if (list != null && !list.isEmpty() && albumCacheData != null) {
            Iterator<PhotoCacheData> it = list.iterator();
            while (it.hasNext()) {
                it.next().albumName = albumCacheData.albumname;
            }
        }
        b0(activity, j3, list, i3, arrayList, photoParam, z16, i16, i17, aVar, true, arrayList2, i18, i19);
    }

    private static ImageTagInfo h(AlbumImageTagInfo albumImageTagInfo) {
        if (albumImageTagInfo == null) {
            return null;
        }
        ImageTagInfo imageTagInfo = new ImageTagInfo();
        imageTagInfo.type = albumImageTagInfo.type;
        imageTagInfo.content = albumImageTagInfo.content;
        imageTagInfo.tagId = albumImageTagInfo.tagId;
        imageTagInfo.xScale = albumImageTagInfo.xScale;
        imageTagInfo.yScale = albumImageTagInfo.yScale;
        imageTagInfo.direction = albumImageTagInfo.direction;
        imageTagInfo.poiTagStreet = albumImageTagInfo.poiTagStreet;
        return imageTagInfo;
    }

    public static void i0(PhotoInfo photoInfo, PhotoCacheData photoCacheData, int i3) {
        PictureItem pictureItem;
        Map<Integer, String> map;
        if (photoInfo == null || photoCacheData == null || (pictureItem = photoCacheData.picItem) == null) {
            return;
        }
        com.qzone.proxy.feedcomponent.model.PictureUrl pictureUrl = pictureItem.bigUrl;
        if (pictureUrl != null && !TextUtils.isEmpty(pictureUrl.url)) {
            photoInfo.bigUrl = photoCacheData.picItem.bigUrl.url;
        } else {
            photoInfo.bigUrl = "";
        }
        com.qzone.proxy.feedcomponent.model.PictureUrl pictureUrl2 = photoCacheData.picItem.originUrl;
        if (pictureUrl2 != null && !TextUtils.isEmpty(pictureUrl2.url)) {
            photoInfo.orgUrl = photoCacheData.picItem.originUrl.url;
        } else {
            photoInfo.orgUrl = "";
        }
        com.qzone.proxy.feedcomponent.model.PictureUrl pictureUrl3 = photoCacheData.picItem.downloadUrl;
        if (pictureUrl3 != null && !TextUtils.isEmpty(pictureUrl3.url)) {
            photoInfo.downloadUrl = photoCacheData.picItem.downloadUrl.url;
        } else {
            photoInfo.downloadUrl = "";
        }
        photoInfo.albumId = photoCacheData.albumid;
        PictureItem pictureItem2 = photoCacheData.picItem;
        photoInfo.currentUrl = pictureItem2.currentUrl.url;
        photoInfo.photoType = pictureItem2.type;
        photoInfo.praiseCount = pictureItem2.likeCount;
        photoInfo.commentCount = pictureItem2.commentCount;
        photoInfo.hasPraise = pictureItem2.isLike;
        photoInfo.unikey = photoCacheData.unikey;
        photoInfo.curkey = photoCacheData.curkey;
        photoInfo.lloc = photoCacheData.lloc;
        photoInfo.sloc = pictureItem2.sloc;
        photoInfo.flag = pictureItem2.flag;
        photoInfo.desc = photoCacheData.desc;
        photoInfo.opsynflag = pictureItem2.opsynflag;
        photoInfo.isIndependentUgc = pictureItem2.isIndependentUgc;
        if (pictureItem2 != null && (map = pictureItem2.busi_param) != null) {
            photoInfo.busi_param = map;
        }
        photoInfo.videoflag = photoCacheData.videoflag;
        photoInfo.videodata = r(photoCacheData.videodata);
        photoInfo.albumName = photoCacheData.albumName;
        try {
            photoInfo.uploadtime = (int) photoCacheData.uploadtime;
            photoInfo.shootingTime = (int) photoCacheData.shoottime;
        } catch (Exception e16) {
            QLog.e("PictureViewerFactory", 1, "exception is " + e16);
        }
        PictureItem pictureItem3 = photoCacheData.picItem;
        if (pictureItem3 != null) {
            com.qzone.proxy.feedcomponent.model.PictureUrl pictureUrl4 = pictureItem3.bigUrl;
            photoInfo.mOriginWidth = pictureUrl4.width;
            photoInfo.mOriginHeight = pictureUrl4.height;
        }
        photoInfo.photoOpmask = photoCacheData.photoOpmask;
        if (i3 == 9) {
            photoInfo.uploadOwner = QZoneAlbumUtil.x(photoCacheData.uploadUin, photoCacheData.uploadNickName);
        } else {
            photoInfo.uploadOwner = photoCacheData.uploadNickName;
        }
        photoInfo.uploaduin = photoCacheData.uploadUin;
        G(photoInfo);
    }

    private static PictureUrl k(com.qzone.proxy.feedcomponent.model.PictureUrl pictureUrl) {
        if (pictureUrl == null) {
            return null;
        }
        PictureUrl pictureUrl2 = new PictureUrl();
        pictureUrl2.url = pictureUrl.url;
        pictureUrl2.width = pictureUrl.width;
        pictureUrl2.height = pictureUrl.height;
        pictureUrl2.pictureType = pictureUrl.pictureType;
        pictureUrl2.pivotXRate = pictureUrl.pivotXRate;
        pictureUrl2.pivotYRate = pictureUrl.pivotYRate;
        pictureUrl2.enlarge_rate = pictureUrl.enlargeRate;
        return pictureUrl2;
    }

    private static com.qzone.proxy.feedcomponent.model.PictureUrl l(PictureUrl pictureUrl) {
        if (pictureUrl == null) {
            return null;
        }
        com.qzone.proxy.feedcomponent.model.PictureUrl pictureUrl2 = new com.qzone.proxy.feedcomponent.model.PictureUrl();
        pictureUrl2.url = pictureUrl.url;
        pictureUrl2.width = pictureUrl.width;
        pictureUrl2.height = pictureUrl.height;
        pictureUrl2.pictureType = pictureUrl.pictureType;
        pictureUrl2.pivotXRate = pictureUrl.pivotXRate;
        pictureUrl2.pivotYRate = pictureUrl.pivotYRate;
        pictureUrl2.enlargeRate = pictureUrl.enlarge_rate;
        return pictureUrl2;
    }

    private static ArrayList<com.qzone.proxy.feedcomponent.model.VideoUrl> m(ArrayList<VideoUrl> arrayList) {
        if (arrayList == null) {
            return null;
        }
        ArrayList<com.qzone.proxy.feedcomponent.model.VideoUrl> arrayList2 = new ArrayList<>(arrayList.size());
        Iterator<VideoUrl> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(p(it.next()));
        }
        return arrayList2;
    }

    public static com.qzone.proxy.feedcomponent.model.VideoInfo n(VideoInfo videoInfo) {
        if (videoInfo == null) {
            return null;
        }
        com.qzone.proxy.feedcomponent.model.VideoInfo videoInfo2 = new com.qzone.proxy.feedcomponent.model.VideoInfo();
        videoInfo2.videoId = videoInfo.videoId;
        videoInfo2.videoUrl = p(videoInfo.videoUrl);
        videoInfo2.originUrl = l(videoInfo.originUrl);
        videoInfo2.bigUrl = l(videoInfo.bigUrl);
        videoInfo2.currentUrl = l(videoInfo.currentUrl);
        videoInfo2.coverUrl = l(videoInfo.coverUrl);
        videoInfo2.actionType = videoInfo.actionType;
        videoInfo2.actionUrl = videoInfo.actionUrl;
        videoInfo2.nativeLikeUrl = videoInfo.nativeLikeUrl;
        videoInfo2.highBrUrl = p(videoInfo.highBrUrl);
        videoInfo2.lowBrUrl = p(videoInfo.lowBrUrl);
        videoInfo2.originVideoUrl = p(videoInfo.originVideoUrl);
        videoInfo2.h265NormalUrl = p(videoInfo.h265NormalUrl);
        videoInfo2.downloadVideoUrl = p(videoInfo.downloadVideoUrl);
        videoInfo2.originVideoSize = videoInfo.originVideoSize;
        videoInfo2.fileType = videoInfo.fileType;
        videoInfo2.videoType = videoInfo.videoType;
        videoInfo2.videoTime = videoInfo.videoTime;
        videoInfo2.showVideoTime = videoInfo.showVideoTime;
        videoInfo2.playType = videoInfo.playType;
        videoInfo2.videoShowType = videoInfo.videoShowType;
        videoInfo2.hasVideoPlayed = videoInfo.hasVideoPlayed;
        videoInfo2.videoStatus = videoInfo.videoStatus;
        videoInfo2.lastUseTime = videoInfo.lastUseTime;
        videoInfo2.width = videoInfo.width;
        videoInfo2.height = videoInfo.height;
        videoInfo2.toast = videoInfo.toast;
        videoInfo2.isFakeFeed = videoInfo.isFakeFeed;
        videoInfo2.isFloatFirst = videoInfo.isFloatFirst;
        videoInfo2.isFeedFirst = videoInfo.isFeedFirst;
        videoInfo2.isFeedFirstComplete = videoInfo.isFeedFirstComplete;
        videoInfo2.isFeedComplete = videoInfo.isFeedComplete;
        videoInfo2.isTranscoding = videoInfo.isTranscoding;
        videoInfo2.isUploading = videoInfo.isUploading;
        videoInfo2.videoFloatReportParam = videoInfo.videoFloatReportParam;
        videoInfo2.videoRemark = o(videoInfo.videoRemark);
        videoInfo2.validVideoTime = videoInfo.validVideoTime;
        videoInfo2.validVideoTimeDesc = videoInfo.validVideoTimeDesc;
        videoInfo2.isCircle = videoInfo.isCircle;
        videoInfo2.isAutoPlay = videoInfo.isAutoPlay;
        videoInfo2.writeFrom = videoInfo.writeFrom;
        videoInfo2.desc = videoInfo.desc;
        videoInfo2.videoSource = videoInfo.videoSource;
        videoInfo2.advDelayTime = videoInfo.advDelayTime;
        videoInfo2.isGetRecommAfterPlay = videoInfo.isGetRecommAfterPlay;
        videoInfo2.shootTime = videoInfo.shootTime;
        videoInfo2.videoplaycnt = videoInfo.videoplaycnt;
        videoInfo2.allowShowPasterVideoAdv = videoInfo.allowShowPasterVideoAdv;
        videoInfo2.needDeleteLocal = videoInfo.needDeleteLocal;
        videoInfo2.videoRateList = m(videoInfo.videoRateList);
        videoInfo2.currentVideoRate = videoInfo.currentVideoRate;
        videoInfo2.albumid = videoInfo.albumid;
        videoInfo2.lloc = videoInfo.lloc;
        return videoInfo2;
    }

    private static VideoInfo.VideoRemark o(VideoInfo.VideoRemark videoRemark) {
        if (videoRemark == null) {
            return null;
        }
        VideoInfo.VideoRemark videoRemark2 = new VideoInfo.VideoRemark();
        videoRemark2.iconurl = videoRemark.iconurl;
        videoRemark2.icondesc = videoRemark.icondesc;
        videoRemark2.remark = videoRemark.remark;
        videoRemark2.actiontype = videoRemark.actiontype;
        videoRemark2.actionurl = videoRemark.actionurl;
        videoRemark2.orgwebsite = videoRemark.orgwebsite;
        return videoRemark2;
    }

    private static com.qzone.proxy.feedcomponent.model.VideoUrl p(VideoUrl videoUrl) {
        if (videoUrl == null) {
            return null;
        }
        com.qzone.proxy.feedcomponent.model.VideoUrl videoUrl2 = new com.qzone.proxy.feedcomponent.model.VideoUrl();
        videoUrl2.url = videoUrl.url;
        videoUrl2.decoderType = videoUrl.decoderType;
        videoUrl2.videoRate = videoUrl.videoRate;
        return videoUrl2;
    }

    private static ArrayList<VideoUrl> q(ArrayList<com.qzone.proxy.feedcomponent.model.VideoUrl> arrayList) {
        if (arrayList == null) {
            return null;
        }
        ArrayList<VideoUrl> arrayList2 = new ArrayList<>(arrayList.size());
        Iterator<com.qzone.proxy.feedcomponent.model.VideoUrl> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(t(it.next()));
        }
        return arrayList2;
    }

    public static cooperation.qzone.model.VideoInfo r(com.qzone.proxy.feedcomponent.model.VideoInfo videoInfo) {
        if (videoInfo == null) {
            return null;
        }
        cooperation.qzone.model.VideoInfo videoInfo2 = new cooperation.qzone.model.VideoInfo();
        videoInfo2.videoId = videoInfo.videoId;
        videoInfo2.videoUrl = t(videoInfo.videoUrl);
        videoInfo2.originUrl = k(videoInfo.originUrl);
        videoInfo2.bigUrl = k(videoInfo.bigUrl);
        videoInfo2.currentUrl = k(videoInfo.currentUrl);
        videoInfo2.coverUrl = k(videoInfo.coverUrl);
        videoInfo2.actionType = videoInfo.actionType;
        videoInfo2.actionUrl = videoInfo.actionUrl;
        videoInfo2.nativeLikeUrl = videoInfo.nativeLikeUrl;
        videoInfo2.highBrUrl = t(videoInfo.highBrUrl);
        videoInfo2.lowBrUrl = t(videoInfo.lowBrUrl);
        videoInfo2.originVideoUrl = t(videoInfo.originVideoUrl);
        videoInfo2.downloadVideoUrl = t(videoInfo.downloadVideoUrl);
        videoInfo2.h265NormalUrl = t(videoInfo.h265NormalUrl);
        videoInfo2.originVideoSize = videoInfo.originVideoSize;
        videoInfo2.fileType = videoInfo.fileType;
        videoInfo2.videoType = videoInfo.videoType;
        videoInfo2.videoTime = videoInfo.videoTime;
        videoInfo2.showVideoTime = videoInfo.showVideoTime;
        videoInfo2.playType = videoInfo.playType;
        videoInfo2.videoShowType = videoInfo.videoShowType;
        videoInfo2.hasVideoPlayed = videoInfo.hasVideoPlayed;
        videoInfo2.videoStatus = videoInfo.videoStatus;
        videoInfo2.lastUseTime = videoInfo.lastUseTime;
        videoInfo2.width = videoInfo.width;
        videoInfo2.height = videoInfo.height;
        videoInfo2.toast = videoInfo.toast;
        videoInfo2.isFakeFeed = videoInfo.isFakeFeed;
        videoInfo2.isFloatFirst = videoInfo.isFloatFirst;
        videoInfo2.isFeedFirst = videoInfo.isFeedFirst;
        videoInfo2.isFeedFirstComplete = videoInfo.isFeedFirstComplete;
        videoInfo2.isFeedComplete = videoInfo.isFeedComplete;
        videoInfo2.isTranscoding = videoInfo.isTranscoding;
        videoInfo2.isUploading = videoInfo.isUploading;
        videoInfo2.videoFloatReportParam = videoInfo.videoFloatReportParam;
        videoInfo2.videoRemark = s(videoInfo.videoRemark);
        videoInfo2.validVideoTime = videoInfo.validVideoTime;
        videoInfo2.validVideoTimeDesc = videoInfo.validVideoTimeDesc;
        videoInfo2.isCircle = videoInfo.isCircle;
        videoInfo2.isAutoPlay = videoInfo.isAutoPlay;
        videoInfo2.writeFrom = videoInfo.writeFrom;
        videoInfo2.desc = videoInfo.desc;
        videoInfo2.videoSource = videoInfo.videoSource;
        videoInfo2.advDelayTime = videoInfo.advDelayTime;
        videoInfo2.isGetRecommAfterPlay = videoInfo.isGetRecommAfterPlay;
        videoInfo2.shootTime = videoInfo.shootTime;
        videoInfo2.videoplaycnt = videoInfo.videoplaycnt;
        videoInfo2.allowShowPasterVideoAdv = videoInfo.allowShowPasterVideoAdv;
        videoInfo2.needDeleteLocal = videoInfo.needDeleteLocal;
        videoInfo2.videoRateList = q(videoInfo.videoRateList);
        videoInfo2.currentVideoRate = videoInfo.currentVideoRate;
        videoInfo2.albumid = videoInfo.albumid;
        videoInfo2.lloc = videoInfo.lloc;
        return videoInfo2;
    }

    private static VideoInfo.VideoRemark s(VideoInfo.VideoRemark videoRemark) {
        if (videoRemark == null) {
            return null;
        }
        VideoInfo.VideoRemark videoRemark2 = new VideoInfo.VideoRemark();
        videoRemark2.iconurl = videoRemark.iconurl;
        videoRemark2.icondesc = videoRemark.icondesc;
        videoRemark2.remark = videoRemark.remark;
        videoRemark2.actiontype = videoRemark.actiontype;
        videoRemark2.actionurl = videoRemark.actionurl;
        videoRemark2.orgwebsite = videoRemark.orgwebsite;
        return videoRemark2;
    }

    private static VideoUrl t(com.qzone.proxy.feedcomponent.model.VideoUrl videoUrl) {
        if (videoUrl == null) {
            return null;
        }
        VideoUrl videoUrl2 = new VideoUrl();
        videoUrl2.url = videoUrl.url;
        videoUrl2.decoderType = videoUrl.decoderType;
        videoUrl2.videoRate = videoUrl.videoRate;
        return videoUrl2;
    }

    public static void m0(PictureItem pictureItem, Pair<String, String> pair) {
        if (pictureItem == null || pair == null) {
            return;
        }
        com.qzone.proxy.feedcomponent.model.PictureUrl pictureUrl = pictureItem.currentUrl;
        if (pictureUrl != null) {
            pictureUrl.url = pair.first;
        }
        com.qzone.proxy.feedcomponent.model.PictureUrl pictureUrl2 = pictureItem.bigUrl;
        if (pictureUrl2 != null) {
            pictureUrl2.url = pair.second;
        }
    }

    public static void O(Activity activity, CellPictureInfo cellPictureInfo, int i3, int i16, int i17, int i18, int i19, Intent intent, int i26) {
        HashMap hashMap;
        HashMap hashMap2;
        LocalMediaInfo localMediaInfo;
        int i27;
        int i28;
        int i29 = i26;
        ArrayList<PictureItem> arrayList = cellPictureInfo.pics;
        boolean z16 = false;
        int size = arrayList == null ? 0 : arrayList.size();
        ArrayList arrayList2 = new ArrayList();
        new HashMap();
        new HashMap();
        new HashMap();
        if (intent == null) {
            return;
        }
        HashMap hashMap3 = (HashMap) intent.getSerializableExtra(PeakConstants.SELECTED_FACE_HAS_CHECK_MAP);
        HashMap hashMap4 = (HashMap) intent.getSerializableExtra(PeakConstants.SELECTED_NEED_SHOW_FACE_ICON_MAP);
        HashMap hashMap5 = (HashMap) intent.getSerializableExtra(PeakConstants.PHOTO_INFOS);
        HashMap hashMap6 = (HashMap) intent.getSerializableExtra(PeakConstants.PANORAMA_IMAGES);
        HashMap hashMap7 = (HashMap) intent.getSerializableExtra("PeakConstants.selectedMediaInfoHashMap");
        PhotoInfo photoInfo = null;
        int i36 = 0;
        while (i36 < size) {
            if (i29 == 0) {
                PhotoInfo photoInfo2 = new PhotoInfo();
                j0(photoInfo2, cellPictureInfo.pics.get(i36), z16);
                if (hashMap3 != null && hashMap3.containsKey(photoInfo2.bigUrl)) {
                    photoInfo2.hasCheckFace = ((Boolean) hashMap3.get(photoInfo2.bigUrl)).booleanValue();
                }
                if (hashMap4 != null && hashMap4.containsKey(photoInfo2.bigUrl)) {
                    photoInfo2.needShowFaceIcon = ((Boolean) hashMap4.get(photoInfo2.bigUrl)).booleanValue();
                }
                if (hashMap7 == null || !hashMap7.containsKey(photoInfo2.bigUrl) || (localMediaInfo = (LocalMediaInfo) hashMap7.get(photoInfo2.bigUrl)) == null) {
                    hashMap = hashMap3;
                    hashMap2 = hashMap4;
                } else {
                    int i37 = localMediaInfo.orientation;
                    if (i37 != 90 && i37 != 270) {
                        i27 = localMediaInfo.mediaHeight;
                        i28 = localMediaInfo.mediaWidth;
                    } else {
                        i27 = localMediaInfo.mediaWidth;
                        i28 = localMediaInfo.mediaHeight;
                    }
                    hashMap = hashMap3;
                    hashMap2 = hashMap4;
                    photoInfo2.heightWeightProportion = (float) ((i27 * 1.0d) / i28);
                    photoInfo2.mOriginWidth = i28;
                    photoInfo2.mOriginHeight = i27;
                }
                if (hashMap5 != null && hashMap5.containsKey(photoInfo2.bigUrl) && ((PicInfo) hashMap5.get(photoInfo2.bigUrl)).picwidth != 0) {
                    photoInfo2.heightWeightProportion = (float) ((((PicInfo) hashMap5.get(photoInfo2.bigUrl)).picheight * 1.0d) / ((PicInfo) hashMap5.get(photoInfo2.bigUrl)).picwidth);
                    photoInfo2.mOriginWidth = ((PicInfo) hashMap5.get(photoInfo2.bigUrl)).picwidth;
                    photoInfo2.mOriginHeight = ((PicInfo) hashMap5.get(photoInfo2.bigUrl)).picheight;
                }
                QZLog.d("PictureViewerFactory", 1, "i:", Integer.valueOf(i36), " heightWeightProportion:", Float.valueOf(photoInfo2.heightWeightProportion));
                if (hashMap6 != null && hashMap6.size() > 0 && hashMap6.containsKey(photoInfo2.bigUrl)) {
                    H(photoInfo2, ((Integer) hashMap6.get(photoInfo2.bigUrl)).intValue());
                }
                arrayList2.add(photoInfo2);
                i29 = i26;
            } else {
                hashMap = hashMap3;
                hashMap2 = hashMap4;
                if (photoInfo == null) {
                    PhotoInfo photoInfo3 = new PhotoInfo();
                    PictureItem pictureItem = cellPictureInfo.pics.get(i36);
                    j0(photoInfo3, pictureItem, false);
                    photoInfo3.mNeedEncodeGifPics.add(pictureItem.bigUrl.url);
                    i29 = i26;
                    photoInfo3.mNeedEncodeGifDelay = i29;
                    photoInfo = photoInfo3;
                } else {
                    i29 = i26;
                    if (i36 == size - 1) {
                        PictureItem pictureItem2 = cellPictureInfo.pics.get(i36);
                        j0(photoInfo, pictureItem2, false);
                        photoInfo.mNeedEncodeGifPics.add(pictureItem2.bigUrl.url);
                        photoInfo.mNeedEncodeGifDelay = i29;
                        arrayList2.add(photoInfo);
                    } else {
                        photoInfo.mNeedEncodeGifPics.add(cellPictureInfo.pics.get(i36).bigUrl.url);
                    }
                }
            }
            i36++;
            hashMap3 = hashMap;
            hashMap4 = hashMap2;
            z16 = false;
        }
        PhotoParam photoParam = new PhotoParam();
        photoParam.loginUin = LoginData.getInstance().getUin();
        photoParam.loginNickName = LoginData.getInstance().getNickName("");
        i8.b.a(activity).i(new m8.a(i3, 0, photoParam, arrayList2)).c(new a.C10712a().h(i17).f(false).a()).b(new a.C10575a().g(true).e(false).a()).h(intent).g(activity, i16, true);
    }

    public static void f0(PhotoInfo photoInfo, s_picdata s_picdataVar, int i3) {
        String str;
        if (s_picdataVar == null || photoInfo == null) {
            return;
        }
        photoInfo.photoType = s_picdataVar.type;
        photoInfo.praiseCount = s_picdataVar.likecount;
        photoInfo.commentCount = s_picdataVar.commentcount;
        photoInfo.hasPraise = s_picdataVar.ismylike;
        photoInfo.unikey = s_picdataVar.orglikekey;
        photoInfo.curkey = s_picdataVar.curlikekey;
        photoInfo.lloc = s_picdataVar.lloc;
        photoInfo.sloc = s_picdataVar.sloc;
        photoInfo.desc = s_picdataVar.desc;
        photoInfo.uploadtime = (int) s_picdataVar.uUploadTime;
        photoInfo.mOriginWidth = (int) s_picdataVar.origin_width;
        photoInfo.mOriginHeight = (int) s_picdataVar.origin_height;
        Map<Integer, String> map = s_picdataVar.busi_param;
        if (map != null) {
            Map<Integer, String> map2 = photoInfo.busi_param;
            if (map2 != null) {
                String str2 = map2.get(54);
                photoInfo.busi_param = s_picdataVar.busi_param;
                if (!TextUtils.isEmpty(str2)) {
                    photoInfo.busi_param.put(54, str2);
                }
            } else {
                photoInfo.busi_param = map;
            }
        }
        photoInfo.opsynflag = s_picdataVar.opsynflag;
        photoInfo.isIndependentUgc = s_picdataVar.isIndependentUgc;
        ArrayList<ImageTagInfo> stPhotoTagConvertToImageTagInfo = ImageTagInfo.stPhotoTagConvertToImageTagInfo(s_picdataVar.photoTag);
        if (stPhotoTagConvertToImageTagInfo != null && !stPhotoTagConvertToImageTagInfo.isEmpty()) {
            photoInfo.tagList = stPhotoTagConvertToImageTagInfo;
        }
        photoInfo.flag = s_picdataVar.flag;
        photoInfo.videoflag = s_picdataVar.videoflag;
        photoInfo.videodata = r(com.qzone.proxy.feedcomponent.util.e.s(s_picdataVar.videodata));
        photoInfo.uploadtime = (int) s_picdataVar.uUploadTime;
        photoInfo.mOriginWidth = (int) s_picdataVar.origin_width;
        photoInfo.mOriginHeight = (int) s_picdataVar.origin_height;
        photoInfo.photoOpmask = s_picdataVar.opmask;
        if (i3 == 9) {
            s_pic_host s_pic_hostVar = s_picdataVar.pic_host_nick;
            photoInfo.uploadOwner = QZoneAlbumUtil.x(s_pic_hostVar.uin, s_pic_hostVar.nick);
        } else {
            s_pic_host s_pic_hostVar2 = s_picdataVar.pic_host_nick;
            if (s_pic_hostVar2 != null) {
                str = s_pic_hostVar2.nick;
            } else {
                str = "";
            }
            photoInfo.uploadOwner = str;
        }
        s_pic_host s_pic_hostVar3 = s_picdataVar.pic_host_nick;
        photoInfo.uploaduin = s_pic_hostVar3 != null ? s_pic_hostVar3.uin : 0L;
        G(photoInfo);
        photoInfo.mFaceList = FaceData.toFaceDataList(s_picdataVar.facelist, photoInfo.albumId, s_picdataVar.uploadUin);
        photoInfo.originSize = s_picdataVar.origin_size;
        photoInfo.mOriginWidth = (int) s_picdataVar.origin_width;
        photoInfo.mOriginHeight = (int) s_picdataVar.origin_height;
        String str3 = s_picdataVar.mapExtern.get("i_open");
        if (TextUtils.isEmpty(str3)) {
            return;
        }
        photoInfo.picInfoOpen = Integer.parseInt(str3) > 0;
    }

    public static void g0(PhotoInfo photoInfo, Photo photo, int i3) {
        if (photo == null || photoInfo == null) {
            return;
        }
        String str = "";
        if (!TextUtils.isEmpty(photo.bigurl)) {
            photoInfo.bigUrl = photo.bigurl;
        } else {
            photoInfo.bigUrl = "";
        }
        if (!TextUtils.isEmpty(photo.url)) {
            photoInfo.orgUrl = photo.url;
        } else {
            photoInfo.orgUrl = "";
        }
        if (!TextUtils.isEmpty(photo.downloadURL)) {
            photoInfo.downloadUrl = photo.downloadURL;
        } else {
            photoInfo.downloadUrl = "";
        }
        int i16 = photo.width;
        if (i16 != 0) {
            int i17 = photo.height;
            photoInfo.heightWeightProportion = (float) ((i17 * 1.0d) / i16);
            photoInfo.mOriginWidth = i16;
            photoInfo.mOriginHeight = i17;
        }
        photoInfo.photoType = photo.type;
        photoInfo.praiseCount = photo.likenum;
        photoInfo.commentCount = photo.cmtnum;
        photoInfo.hasPraise = photo.mylike == 1;
        photoInfo.unikey = photo.unikey;
        photoInfo.curkey = photo.curkey;
        photoInfo.lloc = photo.lloc;
        photoInfo.sloc = photo.sloc;
        photoInfo.desc = photo.desc;
        photoInfo.uploadtime = photo.uploadtime;
        photoInfo.shootingTime = photo.shoottime;
        Map<Integer, String> map = photo.busi_param;
        if (map != null) {
            Map<Integer, String> map2 = photoInfo.busi_param;
            if (map2 != null) {
                String str2 = map2.get(54);
                photoInfo.busi_param = photo.busi_param;
                if (!TextUtils.isEmpty(str2)) {
                    photoInfo.busi_param.put(54, str2);
                }
            } else {
                photoInfo.busi_param = map;
            }
        }
        photoInfo.opsynflag = photo.opsynflag;
        photoInfo.isIndependentUgc = photo.isIndependentUgc;
        ArrayList<ImageTagInfo> stPhotoTagConvertToImageTagInfo = ImageTagInfo.stPhotoTagConvertToImageTagInfo(photo.photoTag);
        if (stPhotoTagConvertToImageTagInfo != null && !stPhotoTagConvertToImageTagInfo.isEmpty()) {
            photoInfo.tagList = stPhotoTagConvertToImageTagInfo;
        }
        int i18 = photo.flag;
        photoInfo.flag = i18;
        if (photo.quanflag != 0) {
            photoInfo.flag = i18 | 2;
        }
        photoInfo.videoflag = photo.videoflag;
        photoInfo.videodata = r(com.qzone.proxy.feedcomponent.util.e.s(photo.videodata));
        photoInfo.uploadtime = photo.uploadtime;
        photoInfo.photoOpmask = photo.opmask;
        photoInfo.isShowRepair = photo.is_show_repair;
        if (i3 == 9) {
            pic_host pic_hostVar = photo.pic_host_nick;
            photoInfo.uploadOwner = QZoneAlbumUtil.x(pic_hostVar.uin, pic_hostVar.nick);
        } else {
            pic_host pic_hostVar2 = photo.pic_host_nick;
            if (pic_hostVar2 != null) {
                str = pic_hostVar2.nick;
            }
            photoInfo.uploadOwner = str;
        }
        pic_host pic_hostVar3 = photo.pic_host_nick;
        photoInfo.uploaduin = pic_hostVar3 != null ? pic_hostVar3.uin : 0L;
        G(photoInfo);
        photoInfo.mFaceList = FaceData.toFaceDataList(photo.facelist, photoInfo.albumId, photo.uin);
        photoInfo.originSize = photo.origin_size;
        photoInfo.picTaginfoList = D(photo);
        Map<String, String> map3 = photo.mapExtern;
        if (map3 != null) {
            try {
                String str3 = map3.get("ad_show");
                String str4 = photo.mapExtern.get("i_open");
                if (!TextUtils.isEmpty(str3)) {
                    photoInfo.appAdShow = Integer.parseInt(str3) > 0;
                }
                if (!TextUtils.isEmpty(str4)) {
                    photoInfo.picInfoOpen = Integer.parseInt(str4) > 0;
                }
                photoInfo.appAdText = photo.mapExtern.get("ad_text");
                photoInfo.appAdSchema = photo.mapExtern.get("ad_schema");
            } catch (Exception e16) {
                QZLog.e("PictureViewerFactory", 2, "toPhotoInfo parse mapExtern Exception", e16);
            }
        }
        photoInfo.cellColorfulTail = CellColorfulTail.create(photo.material_info);
    }

    public static void h0(PhotoInfo photoInfo, PhotoCacheData photoCacheData) {
        if (photoInfo == null || photoCacheData == null) {
            return;
        }
        photoInfo.albumName = photoCacheData.albumName;
        photoInfo.albumId = photoCacheData.albumid;
        photoInfo.currentUrl = photoCacheData.currentUrl;
        if (!TextUtils.isEmpty(photoCacheData.bigUrl)) {
            photoInfo.bigUrl = photoCacheData.bigUrl;
        } else {
            photoInfo.bigUrl = "";
        }
        if (!TextUtils.isEmpty(photoCacheData.orgUrl)) {
            photoInfo.orgUrl = photoCacheData.orgUrl;
        } else {
            photoInfo.orgUrl = "";
        }
        if (!TextUtils.isEmpty(photoCacheData.downloadUrl)) {
            photoInfo.downloadUrl = photoCacheData.downloadUrl;
        } else {
            photoInfo.downloadUrl = "";
        }
        photoInfo.desc = photoCacheData.desc;
        photoInfo.praiseCount = photoCacheData.likenum;
        photoInfo.commentCount = photoCacheData.cmtnum;
        photoInfo.hasPraise = photoCacheData.mylike == 1;
        photoInfo.unikey = photoCacheData.unikey;
        photoInfo.curkey = photoCacheData.curkey;
        photoInfo.lloc = photoCacheData.lloc;
        photoInfo.sloc = photoCacheData.sloc;
        photoInfo.busi_param = photoCacheData.busi_param;
        photoInfo.photoType = photoCacheData.type;
        photoInfo.opsynflag = photoCacheData.opsynflag;
        photoInfo.isIndependentUgc = photoCacheData.isIndependentUgc;
        photoInfo.flag = photoCacheData.flag;
        photoInfo.isSelected = photoCacheData.isSelected;
        photoInfo.hasLoaded = photoCacheData.hasLoaded;
        photoInfo.hasLocalOrgFile = photoCacheData.hasLocalOrgFile;
        photoInfo.progress = photoCacheData.progress;
        photoInfo.hasPreDownload = photoCacheData.hasPreDownload;
        photoInfo.hasVisited = photoCacheData.hasVisited;
        photoInfo.tagList = i(photoCacheData.tagList);
        photoInfo.quanLoaded = photoCacheData.quanLoaded;
        photoInfo.showGifState = photoCacheData.showGifState;
        photoInfo.ctime = photoCacheData.ctime;
        photoInfo.date = photoCacheData.date;
        photoInfo.hasQRCode = photoCacheData.hasQRCode;
        photoInfo.opMask = photoCacheData.opmask;
        photoInfo.allow_share = photoCacheData.allow_share;
        photoInfo.videoflag = photoCacheData.videoflag;
        photoInfo.videodata = r(photoCacheData.videodata);
        photoInfo.uploadtime = (int) photoCacheData.uploadtime;
        photoInfo.photoOpmask = photoCacheData.photoOpmask;
        photoInfo.isShowRepair = photoCacheData.isShowRepair;
        photoInfo.uploadOwner = photoCacheData.uploadNickName;
        photoInfo.uploaduin = photoCacheData.uploadUin;
        photoInfo.appid = photoCacheData.appid;
        G(photoInfo);
        photoInfo.pssCellId = photoCacheData.pssCellId;
        photoInfo.pssCellSubId = photoCacheData.pssCellSubId;
        photoInfo.pssUgcKey = photoCacheData.pssUgcKey;
        photoInfo.pssSubId = photoCacheData.pssSubId;
        photoInfo.pssCurLikeKey = photoCacheData.pssCurLikeKey;
        photoInfo.pssOrgLikeKey = photoCacheData.pssOrgLikeKey;
        photoInfo.pssBusiParam = photoCacheData.pssBusiParam;
        photoInfo.pssHasFeedPraise = photoCacheData.pssHasFeedPraise;
        photoInfo.shareWeixinUrl = photoCacheData.shareWeixinUrl;
        photoInfo.shareQqUrl = photoCacheData.shareQqUrl;
        photoInfo.shareTitle = photoCacheData.shareTitle;
        photoInfo.shareSummary = photoCacheData.shareSummary;
        photoInfo.sharePhotoUrl = photoCacheData.sharePhotoUrl;
        photoInfo.shareSpaceRight = photoCacheData.shareSpaceRight;
        photoInfo.shareAlbumRight = photoCacheData.shareAlbumRight;
        int config = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_LIMIT_FACE_NUMS, 5);
        if (photoCacheData.faceList != null) {
            photoInfo.mFaceList = new ArrayList<>(config);
            for (int i3 = 0; i3 < photoCacheData.faceList.size() && i3 < config; i3++) {
                photoInfo.mFaceList.add(photoCacheData.faceList.get(i3));
            }
        }
        photoInfo.originSize = photoCacheData.rawPhotoSize;
        PictureItem pictureItem = photoCacheData.picItem;
        if (pictureItem != null) {
            com.qzone.proxy.feedcomponent.model.PictureUrl pictureUrl = pictureItem.bigUrl;
            photoInfo.mOriginWidth = pictureUrl.width;
            photoInfo.mOriginHeight = pictureUrl.height;
        }
        Map<String, String> map = photoCacheData.mapExtern;
        if (map != null) {
            try {
                String str = map.get("i_open");
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                photoInfo.picInfoOpen = Integer.parseInt(str) > 0;
            } catch (Exception e16) {
                QZLog.e("PictureViewerFactory", 2, "toPhotoInfo parse mapExtern Exception", e16);
            }
        }
    }

    private static void k0(PhotoInfo photoInfo, PictureItem pictureItem, boolean z16, boolean z17) {
        com.qzone.proxy.feedcomponent.model.PictureUrl pictureUrl;
        int i3;
        com.qzone.proxy.feedcomponent.model.PictureUrl pictureUrl2;
        if (pictureItem == null || photoInfo == null) {
            return;
        }
        com.qzone.proxy.feedcomponent.model.PictureUrl pictureUrl3 = pictureItem.bigUrl;
        if (pictureUrl3 != null && !TextUtils.isEmpty(pictureUrl3.url)) {
            com.qzone.proxy.feedcomponent.model.PictureUrl pictureUrl4 = pictureItem.bigUrl;
            photoInfo.bigUrl = pictureUrl4.url;
            photoInfo.mBigUrlWidth = pictureUrl4.width;
            photoInfo.mBigUrlHeight = pictureUrl4.height;
        } else {
            photoInfo.bigUrl = pictureItem.localFileUrl;
        }
        com.qzone.proxy.feedcomponent.model.PictureUrl pictureUrl5 = pictureItem.originUrl;
        if (pictureUrl5 != null && !TextUtils.isEmpty(pictureUrl5.url)) {
            com.qzone.proxy.feedcomponent.model.PictureUrl pictureUrl6 = pictureItem.originUrl;
            photoInfo.orgUrl = pictureUrl6.url;
            photoInfo.mOriginWidth = pictureUrl6.width;
            photoInfo.mOriginHeight = pictureUrl6.height;
        } else {
            photoInfo.orgUrl = "";
        }
        com.qzone.proxy.feedcomponent.model.PictureUrl pictureUrl7 = pictureItem.downloadUrl;
        if (pictureUrl7 != null && !TextUtils.isEmpty(pictureUrl7.url)) {
            photoInfo.downloadUrl = pictureItem.downloadUrl.url;
        } else {
            photoInfo.downloadUrl = "";
        }
        if (pictureItem.isGif() && pictureItem.isAutoPlayGif) {
            photoInfo.showGifState = PhotoInfo.SHOW_GIF;
        }
        photoInfo.currentUrl = h.s(pictureItem);
        photoInfo.lloc = pictureItem.lloc;
        photoInfo.sloc = pictureItem.sloc;
        photoInfo.hasPraise = pictureItem.isLike;
        photoInfo.praiseCount = pictureItem.likeCount;
        photoInfo.commentCount = pictureItem.commentCount;
        photoInfo.albumId = pictureItem.albumId;
        photoInfo.albumPriv = pictureItem.albumPriv;
        photoInfo.opsynflag = pictureItem.opsynflag;
        photoInfo.isIndependentUgc = pictureItem.isIndependentUgc;
        int i16 = pictureItem.type;
        if (i16 != 0) {
            photoInfo.photoType = i16;
        } else {
            com.qzone.proxy.feedcomponent.model.PictureUrl pictureUrl8 = pictureItem.originUrl;
            if (pictureUrl8 != null) {
                photoInfo.photoType = pictureUrl8.pictureType;
            }
        }
        Map<Integer, String> map = pictureItem.busi_param;
        if (map != null) {
            if (z16) {
                photoInfo.busi_param = map;
                map.put(54, "tih");
            } else {
                photoInfo.busi_param = map;
            }
        }
        photoInfo.isSelected = pictureItem.isSelected;
        photoInfo.flag = pictureItem.flag;
        if (pictureItem.hasQuan()) {
            photoInfo.flag |= 2;
        }
        ArrayList<stPhotoTag> arrayList = pictureItem.photoTag;
        if (arrayList != null && !arrayList.isEmpty()) {
            photoInfo.tagList = ImageTagInfo.stPhotoTagConvertToImageTagInfo(pictureItem.photoTag);
        }
        photoInfo.videoflag = pictureItem.videoflag;
        photoInfo.videodata = r(pictureItem.videodata);
        photoInfo.uploadtime = (int) pictureItem.uploadTime;
        photoInfo.photoOpmask = pictureItem.photoOpmask;
        photoInfo.mFaceList = pictureItem.faceLists;
        if (photoInfo.isPanorama() && (pictureUrl2 = pictureItem.originUrl) != null && !TextUtils.isEmpty(pictureUrl2.url)) {
            pictureUrl = pictureItem.originUrl;
        } else {
            com.qzone.proxy.feedcomponent.model.PictureUrl pictureUrl9 = pictureItem.bigUrl;
            if (pictureUrl9 != null && !TextUtils.isEmpty(pictureUrl9.url)) {
                pictureUrl = pictureItem.bigUrl;
            } else {
                com.qzone.proxy.feedcomponent.model.PictureUrl pictureUrl10 = pictureItem.currentUrl;
                pictureUrl = (pictureUrl10 == null || TextUtils.isEmpty(pictureUrl10.url)) ? null : pictureItem.currentUrl;
            }
        }
        if (pictureUrl != null && (i3 = pictureUrl.width) != 0) {
            int i17 = pictureUrl.height;
            photoInfo.heightWeightProportion = (float) ((i17 * 1.0d) / i3);
            photoInfo.mOriginWidth = i3;
            photoInfo.mOriginHeight = i17;
        }
        photoInfo.missionId = pictureItem.missionId;
        G(photoInfo);
    }

    private static PhotoParam A(List<PhotoParam> list, List<PhotoCacheData> list2, int i3) {
        if (list != null && list2 != null && i3 >= 0 && i3 < list2.size() && list2.get(i3) != null) {
            String str = list2.get(i3).albumid;
            for (PhotoParam photoParam : list) {
                String str2 = photoParam.albumid;
                if (str2 != null && str2.equals(str)) {
                    return photoParam;
                }
            }
        }
        return null;
    }

    public static void Y(Activity activity, long j3, AlbumCacheData albumCacheData, int i3, List<PhotoCacheData> list, int i16, SearchFilterComposition searchFilterComposition, String str, boolean z16, int i17) {
        if (albumCacheData != null && list != null && !list.isEmpty() && searchFilterComposition.isDataValid()) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(albumCacheData);
            ArrayList<PhotoParam> l06 = l0(arrayList);
            Z(activity, j3, list, albumCacheData, i16, l06, A(l06, list, i16), z16, i17, 11, new d.a().p(albumCacheData.albumid).q(str).s(i3).r(searchFilterComposition));
            return;
        }
        QZLog.e("PictureViewerFactory", "showSearchResultPictureViewer INVALID input requireParams");
    }

    public static void P(Activity activity, CellPictureInfo cellPictureInfo, int i3, int i16) {
        Q(activity, cellPictureInfo, null, i3, i16, null, false, false);
    }

    public static void R(Activity activity, CellPictureInfo cellPictureInfo, CellFeedCommInfo cellFeedCommInfo, int i3, int i16, boolean z16) {
        Q(activity, cellPictureInfo, cellFeedCommInfo, i3, i16, null, z16, false);
    }

    private static void U(Activity activity, String str, PhotoParam photoParam, ArrayList<PhotoInfo> arrayList, int i3, int i16, int i17) {
        V(activity, str, photoParam, arrayList, i3, i16, i17, null);
    }

    public static void a0(Activity activity, long j3, AlbumCacheData albumCacheData, int i3, List<PhotoCacheData> list, int i16, SearchFilterComposition searchFilterComposition, String str, boolean z16, int i17, ArrayList<String> arrayList, int i18, int i19) {
        if (albumCacheData != null && list != null && !list.isEmpty() && searchFilterComposition.isDataValid()) {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(albumCacheData);
            ArrayList<PhotoParam> l06 = l0(arrayList2);
            c0(activity, j3, list, albumCacheData, i16, l06, A(l06, list, i16), z16, i17, 11, new d.a().p(albumCacheData.albumid).q(str).s(i3).r(searchFilterComposition), arrayList, i18, i19);
            return;
        }
        QZLog.e("PictureViewerFactory", "showSearchResultPictureViewer INVALID input requireParams");
    }

    public static void L(Activity activity, CellPictureInfo cellPictureInfo, CellFeedCommInfo cellFeedCommInfo, int i3, PhotoParam photoParam, int i16, boolean z16) {
        M(activity, cellPictureInfo, cellFeedCommInfo, i3, photoParam, i16, z16, null, null);
    }

    public static void M(Activity activity, CellPictureInfo cellPictureInfo, CellFeedCommInfo cellFeedCommInfo, final int i3, final PhotoParam photoParam, int i16, boolean z16, String str, View view) {
        if (cellPictureInfo == null || cellPictureInfo.pics == null) {
            return;
        }
        final ArrayList<PhotoInfo> C = C(cellPictureInfo, cellFeedCommInfo, photoParam, i3);
        Intent intent = new Intent();
        int i17 = photoParam.appid;
        if (i17 == 4) {
            photoParam.cell_id = photoParam.albumid;
        } else if (i17 == 311 || i17 == 6100) {
            intent.putExtra(PictureConst.KEY_PHTOTCOUNT, cellPictureInfo.pics.size());
        }
        photoParam.loginUin = LoginData.getInstance().getUin();
        photoParam.loginNickName = LoginData.getInstance().getNickName("");
        photoParam.realOwnerUin = cellPictureInfo.uin;
        photoParam.isShareAlbum = cellPictureInfo.isSharingAlbumData();
        int E = E(cellFeedCommInfo);
        if (!QZoneApiProxy.isInQZoneEnvironment()) {
            String l3 = Long.toString(photoParam.ownerUin);
            activity.overridePendingTransition(R.anim.f155022gz, R.anim.f155024h1);
            V(activity, l3, photoParam, C, i3, E, i16, view);
        } else {
            i8.a c16 = i8.b.c(activity).i(new m8.a(i3, 2, photoParam, C)).c(new c.a().h(cellFeedCommInfo != null ? cellFeedCommInfo.feedsDelTime : 0L).i(str).d(E).a());
            b.a j3 = new b.a().j(z16);
            int i18 = photoParam.appid;
            c16.b(j3.i((i18 == 311 || i18 == 6100) ? cellPictureInfo.pics.size() : 0).a()).g(activity, i16, true);
            QzoneHandlerThreadFactory.getMainHandler().postDelayed(new Runnable() { // from class: com.qzone.preview.PictureViewerFactory.1
                @Override // java.lang.Runnable
                public void run() {
                    QzoneFeedVisitorReportService.f().b(PhotoParam.this, C, i3);
                }
            }, 500L);
        }
    }

    public static void N(Activity activity, CellPictureInfo cellPictureInfo, int i3, int i16, int i17, int i18, int i19, Intent intent) {
        O(activity, cellPictureInfo, i3, i16, i17, i18, i19, intent, 0);
    }

    private static void X(Activity activity, long j3, List<PhotoCacheData> list, int i3, ArrayList<PhotoParam> arrayList, PhotoParam photoParam, boolean z16, int i16, int i17, c.a aVar, boolean z17) {
        int i18;
        int i19;
        List<PhotoCacheData> list2 = list;
        if (list2 == null) {
            return;
        }
        int i26 = z17 ? 16 : 50;
        int size = list.size();
        if (size > i26) {
            i19 = i3 - (i26 / 2);
            if (i19 < 0) {
                i19 = 0;
            }
            int i27 = i26 + i19;
            if (i27 > size) {
                i27 = size;
            }
            list2 = list.subList(i19, i27);
            i18 = i3 - i19;
        } else {
            i18 = i3;
            i19 = 0;
        }
        ArrayList<PhotoInfo> e06 = e0(list2);
        PhotoParam photoParam2 = photoParam == null ? new PhotoParam() : photoParam;
        photoParam2.loginUin = LoginData.getInstance().getUin();
        photoParam2.loginNickName = LoginData.getInstance().getNickName("");
        i8.b.c(activity).i(new m8.a(i18, i17, photoParam2, e06)).b(aVar.n(j3).j(z16).l(arrayList).k(i19).i(size).a()).g(activity, i16, false);
    }

    private static void b0(Activity activity, long j3, List<PhotoCacheData> list, int i3, ArrayList<PhotoParam> arrayList, PhotoParam photoParam, boolean z16, int i16, int i17, c.a aVar, boolean z17, ArrayList<String> arrayList2, int i18, int i19) {
        int i26;
        int i27;
        List<PhotoCacheData> list2 = list;
        if (list2 == null) {
            return;
        }
        int i28 = z17 ? 16 : 50;
        int size = list.size();
        if (size > i28) {
            i27 = i3 - (i28 / 2);
            if (i27 < 0) {
                i27 = 0;
            }
            int i29 = i28 + i27;
            if (i29 > size) {
                i29 = size;
            }
            list2 = list.subList(i27, i29);
            i26 = i3 - i27;
        } else {
            i26 = i3;
            i27 = 0;
        }
        ArrayList<PhotoInfo> e06 = e0(list2);
        PhotoParam photoParam2 = photoParam == null ? new PhotoParam() : photoParam;
        photoParam2.loginUin = LoginData.getInstance().getUin();
        photoParam2.loginNickName = LoginData.getInstance().getNickName("");
        i8.b.b(activity).i(new m8.a(i26, i17, photoParam2, e06)).c(new b.a().i(i18).j(arrayList2).a()).b(aVar.n(j3).j(z16).l(arrayList).k(i27).i(size).f(i19).a()).g(activity, i16, false);
    }

    private static void H(PhotoInfo photoInfo, int i3) {
        if (photoInfo == null || i3 == 0 || i3 == 3) {
            return;
        }
        if (i3 == 2) {
            photoInfo.flag = 32;
        } else if (i3 == 1) {
            photoInfo.flag = 16;
        }
        photoInfo.needShowFaceIcon = false;
    }

    private static void W(Activity activity, long j3, List<PhotoCacheData> list, int i3, ArrayList<PhotoParam> arrayList, PhotoParam photoParam, boolean z16, int i16, int i17, c.a aVar) {
        X(activity, j3, list, i3, arrayList, photoParam, z16, i16, i17, aVar, false);
    }

    public static void T(Activity activity, ArrayList<PhotoCacheData> arrayList, int i3, PhotoParam photoParam, int i16, int i17, int i18, int i19, ArrayList<String> arrayList2, int i26, int i27, boolean z16, int i28) {
        ArrayList<PhotoCacheData> arrayList3 = arrayList;
        if (u()) {
            rk.b bVar = new rk.b();
            bVar.q(arrayList3);
            bVar.g(i3);
            bVar.h(photoParam);
            bVar.i(i16);
            bVar.n(i17);
            bVar.p(i18);
            bVar.o(i19);
            bVar.y(arrayList2);
            bVar.v(i26);
            bVar.w(z16);
            bVar.x(i27);
            i.l().q(activity, bVar);
            return;
        }
        int size = arrayList.size();
        ArrayList arrayList4 = new ArrayList();
        int i29 = 0;
        while (i29 < size) {
            PhotoInfo photoInfo = new PhotoInfo();
            PhotoCacheData photoCacheData = arrayList3.get(i29);
            i0(photoInfo, photoCacheData, i17);
            int i36 = size;
            if (i17 == 9 || i17 == 8) {
                photoInfo.currentUrl = null;
            }
            photoInfo.allow_share = photoCacheData.allow_share;
            photoInfo.opMask = photoCacheData.opmask;
            arrayList4.add(photoInfo);
            i29++;
            arrayList3 = arrayList;
            size = i36;
        }
        photoParam.cell_id = photoParam.albumid;
        if (photoParam.albumanswer == null) {
            photoParam.albumanswer = "";
        }
        photoParam.loginUin = LoginData.getInstance().getUin();
        i8.b.b(activity).i(new m8.a(i3, i28, photoParam, arrayList4)).c(new b.a().j(arrayList2).i(i26).h(z16).c(i19).e(i18).a()).b(new a.C10575a().f(i27).a()).g(activity, i16, true);
    }
}
