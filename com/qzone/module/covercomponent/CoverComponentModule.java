package com.qzone.module.covercomponent;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.qzone.module.Module;
import com.qzone.module.covercomponent.manage.CoverCacheManager;
import com.qzone.module.covercomponent.ui.CoverVideoCoverView;
import com.qzone.module.covercomponent.ui.QZoneCoverContainer;
import com.qzone.module.covercomponent.utils.CoverHelper;
import com.qzone.module.covercomponent.utils.CoverURLDrawableHelper;
import com.qzone.module.covercomponent.utils.QzoneCoverFullScreenImageProcessor;
import com.qzone.module.covercomponent.utils.QzoneCoverSquareImageProcessor;
import com.qzone.module.covercomponent.utils.QzoneShowCutInnerSquareImageProcessor;
import com.qzone.proxy.covercomponent.ICoverComponentService;
import com.qzone.proxy.covercomponent.ICoverComponentUI;
import com.qzone.proxy.covercomponent.IOnPictrueLoadListener;
import com.qzone.proxy.covercomponent.QzoneCoverConst;
import com.qzone.proxy.covercomponent.adapter.CoverLog;
import com.qzone.proxy.covercomponent.adapter.ICoverResources;
import com.qzone.proxy.covercomponent.env.CoverEnv;
import com.qzone.proxy.covercomponent.ui.ICoverBaseView;
import com.qzone.proxy.covercomponent.ui.IQZoneCoverContainer;
import com.qzone.proxy.feedcomponent.model.PictureUrl;
import com.qzone.proxy.feedcomponent.model.VideoInfo;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.component.media.image.ImageProcessor;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.vas.VasToggle;
import cooperation.qzone.model.CoverCacheData;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CoverComponentModule extends Module<ICoverComponentUI, ICoverComponentService> {

    /* renamed from: a, reason: collision with root package name */
    private ICoverComponentUI f48628a = new ICoverComponentUI() { // from class: com.qzone.module.covercomponent.CoverComponentModule.1
        @Override // com.qzone.proxy.covercomponent.ICoverComponentUI
        public IQZoneCoverContainer getCoverContainerInstance(Context context, ViewGroup viewGroup, long j3, ICoverResources iCoverResources) {
            CoverHelper.sCoverRes = iCoverResources;
            QZoneCoverContainer qZoneCoverContainer = new QZoneCoverContainer(context, viewGroup, j3);
            CoverLog.i("cover@", CoverLog.CLR, "\u521b\u5efacover container uin=" + j3);
            return qZoneCoverContainer;
        }

        @Override // com.qzone.proxy.covercomponent.ICoverComponentUI
        public ICoverBaseView getCoverVideoCoverView(Context context, Activity activity, FrameLayout frameLayout, long j3, HashMap<String, String> hashMap, ICoverResources iCoverResources, int i3) {
            CoverHelper.sCoverRes = iCoverResources;
            return new CoverVideoCoverView(context, activity, frameLayout, j3, hashMap, i3, 3);
        }

        @Override // com.qzone.proxy.covercomponent.ICoverComponentUI
        public ImageProcessor getFullScreenCoverImageProcessor(String str) {
            return new QzoneCoverFullScreenImageProcessor(str);
        }

        @Override // com.qzone.proxy.covercomponent.ICoverComponentUI
        public ImageProcessor getQzoneShowInnerSquareImageProcess(int i3, double d16) {
            return new QzoneShowCutInnerSquareImageProcessor(i3, d16);
        }

        @Override // com.qzone.proxy.covercomponent.ICoverComponentUI
        public ImageProcessor getSquareImageProcessor() {
            return new QzoneCoverSquareImageProcessor(0);
        }
    };

    /* renamed from: b, reason: collision with root package name */
    private ICoverComponentService f48629b = new ICoverComponentService() { // from class: com.qzone.module.covercomponent.CoverComponentModule.2
        @Override // com.qzone.proxy.covercomponent.ICoverComponentService
        public CoverCacheData getCoverFromCache(long j3) {
            return CoverCacheManager.getInstance().getCoverFromCache(j3);
        }

        @Override // com.qzone.proxy.covercomponent.ICoverComponentService
        public String getDefaultCover() {
            return CoverHelper.getDefaultCover();
        }

        @Override // com.qzone.proxy.covercomponent.ICoverComponentService
        public String getRightCoverUrl(CoverCacheData coverCacheData) {
            return CoverCacheManager.getRightCoverUrl(coverCacheData);
        }

        @Override // com.qzone.proxy.covercomponent.ICoverComponentService
        public CoverCacheData getRollbackCover(String str) {
            CoverCacheData coverFromCache;
            HashMap<String, String> hashMap;
            if (TextUtils.isEmpty(str) || (coverFromCache = getCoverFromCache(CoverEnv.getLoginUin())) == null) {
                return null;
            }
            CoverCacheData copyObject = CoverHelper.copyObject(coverFromCache);
            if (QzoneCoverConst.CoverStringType.COVER_TYPE_VIDEO_COVER.equals(copyObject.type) && (hashMap = copyObject.mapExtInfo) != null && !str.equals(hashMap.get(QzoneCoverConst.KEY_VIDEO_COVER_LOCAL_CLIENT_KEY))) {
                CoverLog.i("cover", CoverLog.CLR, "curr cover is video,but not the delete one,not rollback");
                return copyObject;
            }
            HashMap<String, String> hashMap2 = copyObject.backupMapExtInfo;
            if (hashMap2 == null) {
                return copyObject;
            }
            String str2 = hashMap2.get(QzoneCoverConst.KEY_VIDEO_COVER_ORIGINAL_TYPE);
            if (TextUtils.isEmpty(str2)) {
                return copyObject;
            }
            CoverLog.i("cover", CoverLog.CLR, "type=" + copyObject.type + ",rollback to : " + str2);
            copyObject.type = str2;
            copyObject.backupMapExtInfo.remove(QzoneCoverConst.KEY_VIDEO_COVER_ORIGINAL_TYPE);
            copyObject.mapExtInfo = copyObject.backupMapExtInfo;
            return copyObject;
        }

        @Override // com.qzone.proxy.covercomponent.ICoverComponentService
        public int getSuperCoverTrans(long j3) {
            return CoverCacheManager.getSuperCoverTrans(j3);
        }

        @Override // com.qzone.proxy.covercomponent.ICoverComponentService
        public CoverCacheData handleLocalVideoCover(CoverCacheData coverCacheData) {
            String str;
            String str2;
            String str3;
            CoverCacheData coverFromCache;
            String str4;
            long loginUin = CoverEnv.getLoginUin();
            if (coverCacheData != null && coverCacheData.uin == loginUin) {
                if (QzoneCoverConst.CoverStringType.COVER_TYPE_FULL_SCREEN.equals(coverCacheData.type) && !CoverEnv.isSupportSuperCover()) {
                    CoverCacheData copyObject = CoverHelper.copyObject(coverCacheData);
                    copyObject.type = QzoneCoverConst.CoverStringType.COVER_TYPE_CUSTOM;
                    return copyObject;
                }
                if (QzoneCoverConst.CoverStringType.COVER_TYPE_QZONE_SHOW_COVER.equals(coverCacheData.type) && !CoverEnv.isSupportQzoneShowCover()) {
                    CoverCacheData coverCacheData2 = new CoverCacheData();
                    coverCacheData2.uin = loginUin;
                    coverCacheData2.type = QzoneCoverConst.CoverStringType.COVER_TYPE_CUSTOM;
                    coverCacheData2.alian = 1;
                    HashMap<String, String> hashMap = coverCacheData.mapExtInfo;
                    String str5 = hashMap != null ? hashMap.get(QzoneCoverConst.COVER_QZONE_SHOW_DOWNGRADE_BG) : null;
                    if (TextUtils.isEmpty(str5)) {
                        str5 = getDefaultCover();
                    }
                    coverCacheData2.local_url = str5;
                    return coverCacheData2;
                }
                String qzonePublishQueueVideoCoverTaskClientKey = CoverEnv.getQzonePublishQueueVideoCoverTaskClientKey();
                if (!TextUtils.isEmpty(qzonePublishQueueVideoCoverTaskClientKey) && (coverFromCache = getCoverFromCache(loginUin)) != null && coverFromCache.isVideoCover() && isFakeCover(coverFromCache)) {
                    HashMap<String, String> hashMap2 = coverFromCache.mapExtInfo;
                    if (hashMap2 == null) {
                        str4 = "";
                    } else {
                        str4 = hashMap2.get(QzoneCoverConst.KEY_VIDEO_COVER_LOCAL_CLIENT_KEY);
                    }
                    if (qzonePublishQueueVideoCoverTaskClientKey.equals(str4)) {
                        return coverFromCache;
                    }
                }
                if (coverCacheData.isVideoCover()) {
                    HashMap<String, String> hashMap3 = coverCacheData.mapExtInfo;
                    if (hashMap3 == null) {
                        str = "";
                    } else {
                        str = hashMap3.get(QzoneCoverConst.KEY_VIDEO_COVER_CLIENT_KEY);
                    }
                    VideoInfo videoInfoFromCache = CoverEnv.getVideoInfoFromCache(str);
                    if (videoInfoFromCache == null && CoverHelper.isVideoCoverHanding(coverCacheData)) {
                        CoverCacheData coverFromCache2 = getCoverFromCache(loginUin);
                        if (coverFromCache2 != null) {
                            CoverLog.i(QAlbumUtil.PROTOCOL_VIDEO_COVER, CoverLog.CLR, "return cover dbcache");
                            return coverFromCache2;
                        }
                        CoverLog.i(QAlbumUtil.PROTOCOL_VIDEO_COVER, CoverLog.CLR, "return refreshData");
                        return coverCacheData;
                    }
                    HashMap<String, String> hashMap4 = coverCacheData.mapExtInfo;
                    if (hashMap4 == null) {
                        str2 = "";
                    } else {
                        str2 = hashMap4.get(QzoneCoverConst.KEY_VIDEO_COVER_STATUS);
                    }
                    if (!"1002".equals(str2) && videoInfoFromCache != null) {
                        PictureUrl pictureUrl = videoInfoFromCache.coverUrl;
                        if (pictureUrl != null && CoverHelper.isLocalVideo(pictureUrl.url) && !CoverHelper.isFileExist(videoInfoFromCache.coverUrl.url)) {
                            CoverLog.i(QAlbumUtil.PROTOCOL_VIDEO_COVER, CoverLog.CLR, "\u5c01\u9762\u6587\u4ef6\u4e0d\u5b58\u5728 \u7528\u7f51\u7edccover\u6570\u636e");
                            return coverCacheData;
                        }
                        String str6 = videoInfoFromCache.videoId;
                        PictureUrl pictureUrl2 = videoInfoFromCache.coverUrl;
                        if (pictureUrl2 == null) {
                            str3 = "";
                        } else {
                            str3 = pictureUrl2.url;
                        }
                        return fillVideoCoverDataWithLocalData(coverCacheData, str6, str3, videoInfoFromCache.videoUrl.url, videoInfoFromCache.width, videoInfoFromCache.height, videoInfoFromCache.videoTime, str, str2);
                    }
                }
            }
            return coverCacheData;
        }

        @Override // com.qzone.proxy.covercomponent.ICoverComponentService
        public boolean isFullScreenCover(CoverCacheData coverCacheData) {
            return CoverHelper.isFullScreenCover(coverCacheData);
        }

        @Override // com.qzone.proxy.covercomponent.ICoverComponentService
        public boolean isVideoCoverHanding(CoverCacheData coverCacheData) {
            return CoverHelper.isVideoCoverHanding(coverCacheData);
        }

        @Override // com.qzone.proxy.covercomponent.ICoverComponentService
        public boolean isWebviewLikeCover(CoverCacheData coverCacheData) {
            return CoverHelper.isWebviewLikeCover(CoverHelper.checkCoverType(coverCacheData));
        }

        @Override // com.qzone.proxy.covercomponent.ICoverComponentService
        public CoverCacheData parseCoverJceJson(JSONObject jSONObject) throws JSONException {
            return CoverCacheManager.parseCoverJceJson(jSONObject);
        }

        @Override // com.qzone.proxy.covercomponent.ICoverComponentService
        public void saveCoverIntoCache(CoverCacheData coverCacheData) {
            CoverCacheManager.getInstance().saveCoverIntoCache(coverCacheData);
        }

        @Override // com.qzone.proxy.covercomponent.ICoverComponentService
        public void setLoginUserCoverUrl(String str) {
            CoverCacheManager.gLoginUserCoverUrl = str;
        }

        @Override // com.qzone.proxy.covercomponent.ICoverComponentService
        public void getCoverPreviewPictureUrl(CoverCacheData coverCacheData, final IOnPictrueLoadListener iOnPictrueLoadListener) {
            final String defaultCover;
            ImageProcessor imageProcessor;
            Drawable loadImage;
            if (coverCacheData == null) {
                return;
            }
            CoverLog.i("cover@", CoverLog.CLR, "getCoverPreviewPictureUrl \u83b7\u53d6cover\u9759\u6001\u56fe");
            if (QzoneCoverConst.CoverStringType.COVER_TYPE_QZONE_SHOW_COVER.equals(coverCacheData.type)) {
                double d16 = 1.0d;
                if (coverCacheData.mapExtInfo != null) {
                    if (CoverEnv.isSupportQzoneShowCover()) {
                        defaultCover = coverCacheData.mapExtInfo.get(QzoneCoverConst.COVER_QZONE_SHOW_FULL_SCREEN_URL);
                        if (CoverEnv.isSupportSuperCover() && !TextUtils.isEmpty(defaultCover)) {
                            imageProcessor = new QzoneCoverFullScreenImageProcessor(coverCacheData.mapExtInfo.get(QzoneCoverConst.COVER_QZONE_SHOW_FULL_SCREEN_ALIGN));
                        } else {
                            defaultCover = coverCacheData.mapExtInfo.get(QzoneCoverConst.COVER_QZONE_SHOW_DOWNGRADE_BG);
                            d16 = CoverEnv.QzoneShowEnv.getCutRateConfig();
                        }
                    } else {
                        defaultCover = coverCacheData.mapExtInfo.get(QzoneCoverConst.COVER_QZONE_SHOW_DOWNGRADE_BG);
                        d16 = CoverEnv.QzoneShowEnv.getCutRateConfig();
                    }
                    imageProcessor = null;
                } else {
                    defaultCover = null;
                    imageProcessor = null;
                }
                if (TextUtils.isEmpty(defaultCover)) {
                    return;
                }
                int screenWidth = CoverEnv.getScreenWidth();
                if (imageProcessor == null) {
                    imageProcessor = new QzoneShowCutInnerSquareImageProcessor(screenWidth, d16);
                }
            } else {
                if (QzoneCoverConst.CoverStringType.COVER_TYPE_CUSTOM_DYNAMIC_ALBUM_COVER.equals(coverCacheData.type)) {
                    defaultCover = coverCacheData.mapExtInfo.get(QzoneCoverConst.COVER_EXTINFO_DYNAMIC_ALBUM_STATIC_PIC_URL);
                } else if (!TextUtils.isEmpty(coverCacheData.type) && !"default".equals(coverCacheData.type)) {
                    if (QzoneCoverConst.CoverStringType.COVER_TYPE_FULL_SCREEN.equals(coverCacheData.type)) {
                        defaultCover = coverCacheData.urls.get("HigeResolutionCover");
                    } else {
                        defaultCover = getRightCoverUrl(coverCacheData);
                    }
                } else {
                    defaultCover = CoverHelper.getDefaultCover();
                }
                imageProcessor = null;
            }
            if (TextUtils.isEmpty(defaultCover)) {
                return;
            }
            ImageLoader.Options obtain = ImageLoader.Options.obtain();
            obtain.preferQuality = true;
            obtain.type = "qzCvPicd";
            obtain.priority = true;
            if (imageProcessor != null) {
                obtain.extraProcessor = imageProcessor;
            }
            ImageLoader.ImageLoadListener imageLoadListener = iOnPictrueLoadListener != null ? new ImageLoader.ImageLoadListener() { // from class: com.qzone.module.covercomponent.CoverComponentModule.2.1
                @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
                public void onImageLoaded(String str, Drawable drawable, ImageLoader.Options options) {
                    IOnPictrueLoadListener iOnPictrueLoadListener2 = iOnPictrueLoadListener;
                    if (iOnPictrueLoadListener2 != null) {
                        iOnPictrueLoadListener2.onImageLoaded(defaultCover, drawable);
                    }
                }

                @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
                public void onImageCanceled(String str, ImageLoader.Options options) {
                }

                @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
                public void onImageFailed(String str, ImageLoader.Options options) {
                }

                @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
                public void onImageProgress(String str, float f16, ImageLoader.Options options) {
                }
            } : null;
            if (VasToggle.isEnable("qzone_cover_load_with_URLDrawable", false)) {
                loadImage = CoverURLDrawableHelper.getCoverDrawable(defaultCover, obtain, imageLoadListener);
            } else {
                loadImage = ImageLoader.getInstance().loadImage(defaultCover, imageLoadListener, obtain);
            }
            if (loadImage == null || iOnPictrueLoadListener == null) {
                return;
            }
            iOnPictrueLoadListener.onImageLoaded(defaultCover, loadImage);
        }

        @Override // com.qzone.proxy.covercomponent.ICoverComponentService
        public boolean isFakeCover(CoverCacheData coverCacheData) {
            HashMap<String, String> hashMap;
            if (coverCacheData == null || (hashMap = coverCacheData.mapExtInfo) == null) {
                return false;
            }
            return "1000".equals(hashMap.get(QzoneCoverConst.KEY_VIDEO_COVER_STATUS)) || "1001".equals(coverCacheData.mapExtInfo.get(QzoneCoverConst.KEY_VIDEO_COVER_STATUS)) || "1002".equals(coverCacheData.mapExtInfo.get(QzoneCoverConst.KEY_VIDEO_COVER_STATUS));
        }

        @Override // com.qzone.proxy.covercomponent.ICoverComponentService
        public CoverCacheData fillVideoCoverDataWithLocalData(CoverCacheData coverCacheData, String str, String str2, String str3, int i3, int i16, long j3, String str4, String str5) {
            CoverCacheData copyObject;
            String str6;
            String str7;
            HashMap<String, String> hashMap;
            String str8;
            if (coverCacheData == null) {
                copyObject = new CoverCacheData();
            } else {
                copyObject = CoverHelper.copyObject(coverCacheData);
            }
            if (copyObject.mapExtInfo == null) {
                copyObject.mapExtInfo = new HashMap<>();
            }
            if (isFakeCover(copyObject)) {
                str6 = null;
            } else {
                if (copyObject.backupMapExtInfo == null) {
                    copyObject.backupMapExtInfo = new HashMap<>();
                }
                copyObject.backupMapExtInfo.putAll(copyObject.mapExtInfo);
                str6 = copyObject.type;
                copyObject.backupMapExtInfo.put(QzoneCoverConst.KEY_VIDEO_COVER_ORIGINAL_TYPE, str6);
            }
            copyObject.type = QzoneCoverConst.CoverStringType.COVER_TYPE_VIDEO_COVER;
            String str9 = "0";
            if (!"2".equals(str5) && !"1002".equals(str5)) {
                if (!QzoneCoverConst.CoverStringType.COVER_TYPE_VIDEO_COVER.equals(str6) || str4 == null || str4.length() == 0 || !str4.equals(copyObject.mapExtInfo.get(QzoneCoverConst.KEY_VIDEO_COVER_CLIENT_KEY))) {
                    copyObject.mapExtInfo = new HashMap<>();
                }
                if (!TextUtils.isEmpty(str5)) {
                    copyObject.mapExtInfo.put(QzoneCoverConst.KEY_VIDEO_COVER_STATUS, str5);
                }
                copyObject.mapExtInfo.put(QzoneCoverConst.KEY_VIDEO_COVER_DURATION, String.valueOf(j3));
                copyObject.mapExtInfo.put(QzoneCoverConst.KEY_VIDEO_COVER_LOCAL_PIC, str2);
                copyObject.mapExtInfo.put(QzoneCoverConst.KEY_VIDEO_COVER_LOCAL_PATH, str3);
                HashMap<String, String> hashMap2 = copyObject.mapExtInfo;
                if (str2 == null) {
                    str8 = "0";
                } else {
                    str8 = String.valueOf(i3);
                }
                hashMap2.put(QzoneCoverConst.KEY_VIDEO_COVER_LOCAL_PIC_WIDTH, str8);
                HashMap<String, String> hashMap3 = copyObject.mapExtInfo;
                if (str2 != null) {
                    str9 = String.valueOf(i16);
                }
                hashMap3.put(QzoneCoverConst.KEY_VIDEO_COVER_LOCAL_PIC_HEIGHT, str9);
                copyObject.mapExtInfo.put(QzoneCoverConst.KEY_VIDEO_COVER_CLIENT_KEY, str4);
                copyObject.mapExtInfo.put(QzoneCoverConst.KEY_VIDEO_COVER_LOCAL_CLIENT_KEY, str4);
            } else {
                HashMap<String, String> hashMap4 = new HashMap<>();
                copyObject.mapExtInfo = hashMap4;
                hashMap4.put(QzoneCoverConst.KEY_VIDEO_COVER_STATUS, str5);
                copyObject.mapExtInfo.put(QzoneCoverConst.KEY_VIDEO_COVER_DURATION, String.valueOf(j3));
                copyObject.mapExtInfo.put(QzoneCoverConst.KEY_VIDEO_COVER_PIC, str2);
                copyObject.mapExtInfo.put(QzoneCoverConst.KEY_VIDEO_COVER_PLAY_URL, str3);
                HashMap<String, String> hashMap5 = copyObject.mapExtInfo;
                if (str2 == null) {
                    str7 = "0";
                } else {
                    str7 = String.valueOf(i3);
                }
                hashMap5.put(QzoneCoverConst.KEY_VIDEO_COVER_PIC_WIDTH, str7);
                HashMap<String, String> hashMap6 = copyObject.mapExtInfo;
                if (str2 != null) {
                    str9 = String.valueOf(i16);
                }
                hashMap6.put(QzoneCoverConst.KEY_VIDEO_COVER_PIC_HEIGHT, str9);
                copyObject.mapExtInfo.put(QzoneCoverConst.KEY_VIDEO_ID, str == null ? "" : str);
            }
            if (!TextUtils.isEmpty(str6) && (hashMap = copyObject.mapExtInfo) != null) {
                hashMap.put(QzoneCoverConst.KEY_VIDEO_COVER_ORIGINAL_TYPE, str6);
            }
            return copyObject;
        }

        @Override // com.qzone.proxy.covercomponent.ICoverComponentService
        @Deprecated
        public void rollbackCover(String str) {
        }
    };

    @Override // com.qzone.module.Proxy
    public String getModuleClassName() {
        return null;
    }

    @Override // com.qzone.module.Module
    public String getName() {
        return "CoverComponentModule";
    }

    @Override // com.qzone.module.Module
    public int getVersion() {
        return 0;
    }

    @Override // com.qzone.module.Proxy, com.qzone.module.IProxy
    public ICoverComponentService getServiceInterface() {
        return this.f48629b;
    }

    @Override // com.qzone.module.Proxy, com.qzone.module.IProxy
    public ICoverComponentUI getUiInterface() {
        return this.f48628a;
    }
}
