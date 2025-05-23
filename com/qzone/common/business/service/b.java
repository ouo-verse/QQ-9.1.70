package com.qzone.common.business.service;

import NS_MOBILE_OPERATION.PicInfo;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.qzone.common.account.LoginData;
import com.qzone.common.activities.base.ak;
import com.qzone.common.business.service.media.QZoneQCircleMediaImpl;
import com.qzone.preview.LocalPictureViewer;
import com.qzone.preview.service.base.PictureConst;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.proxy.feedcomponent.model.PictureUrl;
import com.qzone.proxy.feedcomponent.model.ShuoshuoVideoInfo;
import com.qzone.proxy.feedcomponent.model.VideoInfo;
import com.qzone.proxy.feedcomponent.model.VideoUrl;
import com.qzone.util.al;
import com.qzone.util.image.NetImageInfo;
import com.qzone.widget.ExtendGridView;
import com.tencent.av.camera.QavCameraUsage;
import com.tencent.component.app.common.ParcelableWrapper;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.PhotoCropActivity;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity;
import com.tencent.mobileqq.qqalbum.IPhotoLogicFactory;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.peak.PeakConstants;
import cooperation.qzone.QZonePublishConfig;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.api.QZoneContant;
import cooperation.qzone.cache.CacheManager;
import cooperation.qzone.media.QZoneMediaBusiness;
import cooperation.qzone.model.FaceData;
import cooperation.qzone.model.PhotoInfo;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.util.QZonePermission;
import ho.i;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import rk.j;
import tk.k;

/* compiled from: P */
/* loaded from: classes39.dex */
public class b {

    /* renamed from: d, reason: collision with root package name */
    private static final al<b, Void> f45796d = new a();

    /* renamed from: b, reason: collision with root package name */
    private final QZoneQCircleMediaImpl f45798b = new QZoneQCircleMediaImpl();

    /* renamed from: c, reason: collision with root package name */
    private final com.qzone.common.business.service.media.b f45799c = new com.qzone.common.business.service.media.b();

    /* renamed from: a, reason: collision with root package name */
    protected String f45797a = getClass().getSimpleName();

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a extends al<b, Void> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.qzone.util.al
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public b a(Void r16) {
            return new b();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.qzone.common.business.service.b$b, reason: collision with other inner class name */
    /* loaded from: classes39.dex */
    public class C0368b extends QQPermission.BasePermissionsListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.qzone.common.business.service.media.a f45800a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f45801b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.qzone.common.business.service.media.c f45802c;

        C0368b(com.qzone.common.business.service.media.a aVar, Context context, com.qzone.common.business.service.media.c cVar) {
            this.f45800a = aVar;
            this.f45801b = context;
            this.f45802c = cVar;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            com.qzone.common.business.service.media.a aVar = this.f45800a;
            if (aVar != null) {
                aVar.c((Activity) this.f45801b, this.f45802c);
            }
        }
    }

    b() {
    }

    public static boolean a(Context context) {
        if (CacheManager.isExternalAvailable()) {
            return true;
        }
        y(context);
        return false;
    }

    private QZoneMediaBusiness b(String str) {
        QZoneMediaBusiness qZoneMediaBusiness = QZoneMediaBusiness.QZONE_PANEL_CAMERA;
        if (TextUtils.equals(str, "qzoneCamera")) {
            return qZoneMediaBusiness;
        }
        if (TextUtils.equals(str, "qzoneMoodList")) {
            return QZoneMediaBusiness.QZONE_MYSHUOSHUO_LIST_VIDEO;
        }
        return TextUtils.equals(str, "qzoneShuoshuoCamera") ? QZoneMediaBusiness.QZONE_SHUOSHUO_CAMERA : qZoneMediaBusiness;
    }

    public static b f() {
        return f45796d.get(null);
    }

    private String i(Activity activity, Bundle bundle) {
        File parentFile;
        if (QavCameraUsage.a(BaseApplication.getContext())) {
            return null;
        }
        String cameraPhotoSavePath = CacheManager.getCameraPhotoSavePath();
        File file = new File(cameraPhotoSavePath);
        if (!file.exists() && (parentFile = file.getParentFile()) != null) {
            parentFile.mkdirs();
        }
        u5.b.v0("PIC_TMP_PATH", cameraPhotoSavePath);
        try {
            QZoneMediaBusiness b16 = b(bundle.getString("from"));
            com.qzone.common.business.service.media.a c16 = c();
            if (c16 != null) {
                c16.g(activity, file, 6000, bundle, b16);
                com.qzone.util.image.e.e(System.currentTimeMillis());
            }
        } catch (Exception unused) {
            x(activity);
        }
        return cameraPhotoSavePath;
    }

    public com.qzone.common.business.service.media.a c() {
        if (QZonePublishConfig.isUseQCirclePublish()) {
            return this.f45798b;
        }
        return this.f45799c;
    }

    public QZoneQCircleMediaImpl h() {
        return this.f45798b;
    }

    public boolean j(Activity activity, int i3, int i16, int i17, int i18, String str, String str2, String[] strArr, String str3) {
        if (!a(activity)) {
            return false;
        }
        Intent intent = new Intent();
        intent.setClass(BaseApplication.getContext(), PhotoCropActivity.class);
        intent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", activity.getClass().getName());
        intent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
        intent.putExtra(PeakConstants.TARGET_WIDTH, i3);
        intent.putExtra(PeakConstants.TARGET_HEIGHT, i16);
        intent.putExtra(PeakConstants.COMPRESS_QUALITY, i17);
        intent.putExtra(PeakConstants.TARGET_PATH, str2);
        intent.putExtra(PeakConstants.CLIP_WIDTH, i18);
        intent.putExtra(PeakConstants.CLIP_HEIGHT, i18);
        intent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", str);
        intent.putExtra(PeakConstants.QZONE_COVER_SOURCE, strArr);
        intent.putExtra(PeakConstants.QZONE_COVER_CROP_LEFT_TITLE, str3);
        Bundle bundle = new Bundle();
        QzonePluginProxyActivity.toExActivityWithResult(bundle);
        intent.putExtras(bundle);
        activity.startActivity(intent);
        QAlbumUtil.anim(activity, false, true);
        return true;
    }

    public void k(Activity activity, PhotoInfo photoInfo, QZoneMediaBusiness qZoneMediaBusiness, int i3) {
        com.qzone.common.business.service.media.a d16 = d(i3);
        if (d16 != null) {
            d16.a(activity, photoInfo, qZoneMediaBusiness);
        }
    }

    public boolean m(Activity activity, int i3, int i16, int i17, int i18, String str, String[] strArr) {
        if (!a(activity)) {
            return false;
        }
        ActivityURIRequest activityURIRequest = new ActivityURIRequest(activity, IPhotoLogicFactory.PHOTO_LIST_ACTIVITY_URI);
        activityURIRequest.extra().putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", activity.getClass().getName());
        activityURIRequest.extra().putString("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
        activityURIRequest.extra().putInt("PhotoConst.MAXUM_SELECTED_NUM", 1);
        activityURIRequest.extra().putBoolean("PhotoConst.IS_SINGLE_MODE", true);
        activityURIRequest.extra().putBoolean(PeakConstants.IS_SINGLE_NEED_EDIT, true);
        activityURIRequest.extra().putBoolean(PeakConstants.PHOTO_LIST_SHOW_PREVIEW, true);
        activityURIRequest.extra().putInt(PeakConstants.TARGET_WIDTH, i3);
        activityURIRequest.extra().putInt(PeakConstants.TARGET_HEIGHT, i16);
        activityURIRequest.extra().putString(PeakConstants.TARGET_PATH, str);
        activityURIRequest.extra().putInt(PeakConstants.CLIP_WIDTH, i18);
        activityURIRequest.extra().putInt(PeakConstants.CLIP_HEIGHT, i18);
        activityURIRequest.extra().putInt(PeakConstants.COMPRESS_QUALITY, i17);
        activityURIRequest.extra().putStringArray(PeakConstants.QZONE_COVER_SOURCE, strArr);
        Bundle bundle = new Bundle();
        QzonePluginProxyActivity.toExActivityWithResult(bundle);
        activityURIRequest.extra().putAll(bundle);
        try {
            QRoute.startUri(activityURIRequest);
            QAlbumUtil.anim(activity, false, true);
            return true;
        } catch (Exception e16) {
            QZLog.w("exception", "startActiviy error!source activity: " + activity.getClass().getName(), e16);
            return false;
        }
    }

    public boolean n(Activity activity, Fragment fragment, ArrayList<String> arrayList, HashMap<String, PicInfo> hashMap, int i3, boolean z16, int i16, boolean z17, boolean z18, ConcurrentHashMap<String, String> concurrentHashMap, String str, Bundle bundle, HashMap<String, LocalMediaInfo> hashMap2, QZoneMediaBusiness qZoneMediaBusiness) {
        com.qzone.common.business.service.media.a c16 = c();
        if (c16 == null) {
            return true;
        }
        if (!QZonePermission.requestStoragePermission(activity, QQPermissionConstants.Business.SCENE.QQ_QZONE_SHUOSHUO_ALBUM_OPEN_MEDIA)) {
            return false;
        }
        c16.b(activity, fragment, arrayList, hashMap, i3, i16, z17, z18, concurrentHashMap, str, bundle, hashMap2, qZoneMediaBusiness);
        return true;
    }

    public boolean p(Activity activity, ArrayList<String> arrayList, HashMap<String, PicInfo> hashMap, int i3, boolean z16, int i16, boolean z17, boolean z18, ConcurrentHashMap<String, String> concurrentHashMap, QZoneMediaBusiness qZoneMediaBusiness) {
        return q(activity, arrayList, hashMap, i3, z16, i16, z17, z18, concurrentHashMap, "", null, qZoneMediaBusiness);
    }

    public void r(Activity activity, int i3, Bundle bundle) {
        com.qzone.common.business.service.media.a c16 = c();
        if (c16 != null) {
            c16.d(activity, i3, bundle);
        }
    }

    public boolean u(Activity activity, ArrayList<NetImageInfo> arrayList, int i3) {
        if (!a(activity)) {
            return false;
        }
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        Intent x16 = ak.x(activity, activity.getString(R.string.gjv), 1);
        ParcelableWrapper.putArrayListToIntent(x16, QZoneContant.INPUT_IMAGES, arrayList);
        x16.putExtra("_input_max", i3);
        x16.putExtra(QZoneContant.KEY_RESHIP, true);
        com.qzone.feed.utils.b.e(activity, x16, 6003);
        activity.overridePendingTransition(R.anim.f154424l, R.anim.f154425m);
        return true;
    }

    public String v(Context context, Bundle bundle) {
        if (a(context) && (context instanceof Activity)) {
            return i((Activity) context, bundle);
        }
        return null;
    }

    public void z(Context context) {
        com.qzone.util.image.c.N(context, u5.b.h0("PIC_TMP_PATH", ""));
    }

    public boolean q(Activity activity, ArrayList<String> arrayList, HashMap<String, PicInfo> hashMap, int i3, boolean z16, int i16, boolean z17, boolean z18, ConcurrentHashMap<String, String> concurrentHashMap, String str, Bundle bundle, QZoneMediaBusiness qZoneMediaBusiness) {
        return n(activity, null, arrayList, hashMap, i3, z16, i16, z17, z18, concurrentHashMap, str, bundle, new HashMap<>(), qZoneMediaBusiness);
    }

    public com.qzone.common.business.service.media.a e(Intent intent) {
        if (intent == null) {
            return c();
        }
        return d(intent.getIntExtra("KEY_MEDIA_PLATFORM_TYPE", -1));
    }

    public void l(Context context, com.qzone.common.business.service.media.c cVar) {
        if (cVar == null) {
            return;
        }
        QZoneMediaBusiness qZoneMediaBusiness = cVar.f45829b;
        com.qzone.common.business.service.media.a d16 = d((qZoneMediaBusiness == QZoneMediaBusiness.QZONE_PUBLISH_INTIMATE_MOOD || qZoneMediaBusiness == QZoneMediaBusiness.QZONE_INTIMATE_UPLOAD_ALBUM || qZoneMediaBusiness == QZoneMediaBusiness.QZONE_GROUP_UPLOAD_ALBUM || qZoneMediaBusiness == QZoneMediaBusiness.QZONE_ALBUMX_UPLOAD_ALBUM) ? 1 : -1);
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            if (QZonePermission.requestStoragePermission(activity, new C0368b(d16, context, cVar), QQPermissionConstants.Business.SCENE.QQ_QZONE_SHUOSHUO_ALBUM_OPEN_MEDIA)) {
                d16.c(activity, cVar);
                return;
            }
            return;
        }
        QLog.e(this.f45797a, 1, "onLocalPhoto: context is not a activity");
    }

    public boolean w(Activity activity, ShuoshuoVideoInfo shuoshuoVideoInfo) {
        if (shuoshuoVideoInfo == null || TextUtils.isEmpty(shuoshuoVideoInfo.mVideoPath)) {
            return false;
        }
        Bundle bundle = new Bundle();
        bundle.putString("file_send_path", shuoshuoVideoInfo.mVideoPath);
        bundle.putLong(ShortVideoConstants.FILE_SEND_DURATION, shuoshuoVideoInfo.mDuration);
        bundle.putLong(ShortVideoConstants.FILE_SEND_SIZE, shuoshuoVideoInfo.mSize);
        bundle.putBoolean(PeakConstants.IS_FINISH_RESTART_INIT_ACTIVITY, true);
        bundle.putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", activity.getClass().getName());
        bundle.putString("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
        bundle.putString("uin", String.valueOf(LoginData.getInstance().getUin()));
        bundle.putInt("uintype", 0);
        QzonePluginProxyActivity.toExActivityWithResult(bundle);
        Intent intent = new Intent();
        intent.setClassName("com.tencent.mobileqq", ShortVideoPreviewActivity.class.getName());
        intent.putExtras(bundle);
        activity.overridePendingTransition(R.anim.f154424l, R.anim.f154422j);
        activity.startActivity(intent);
        return true;
    }

    private com.qzone.common.business.service.media.a d(int i3) {
        if (i3 == 0) {
            return this.f45799c;
        }
        if (i3 != 1) {
            return c();
        }
        return this.f45798b;
    }

    private static void x(Context context) {
        DialogUtil.createCustomDialog(context, 230, context.getString(R.string.f172998gd3), context.getString(R.string.f172999gd4), new d(), null).show();
    }

    private static void y(Context context) {
        DialogUtil.createCustomDialog(context, 230, context.getString(R.string.gpa), context.getString(R.string.gp_), new c(), null).show();
    }

    public void s(Activity activity, ExtendGridView extendGridView, int i3, ArrayList<PictureItem> arrayList, HashMap<String, LocalMediaInfo> hashMap, int i16, Intent intent) {
        if (activity == null || extendGridView == null || arrayList == null || arrayList.isEmpty() || i3 < 0) {
            return;
        }
        com.qzone.common.business.service.media.a e16 = e(intent);
        if (e16 != null) {
            intent.putExtra("KEY_MEDIA_PLATFORM_TYPE", e16.f());
            e16.e(activity, extendGridView, i3, arrayList, hashMap, i16, intent);
        }
    }

    public void t(Activity activity, ExtendGridView extendGridView, int i3, List<String> list, HashMap<String, LocalMediaInfo> hashMap, HashMap<String, ShuoshuoVideoInfo> hashMap2, HashMap<String, ShuoshuoVideoInfo> hashMap3, HashMap<String, ArrayList<FaceData>> hashMap4, int i16, Intent intent) {
        if (activity == null || extendGridView == null || list == null || list.isEmpty() || i3 < 0) {
            return;
        }
        ArrayList<PictureItem> g16 = g(list, hashMap2, hashMap3, hashMap4, hashMap);
        if (k.f436438a.d()) {
            j jVar = new j();
            jVar.x(intent.getIntExtra(PictureConst.KEY_EDIT_BTN_TYPE, 0));
            jVar.y(intent.getIntExtra(PeakConstants.KEY_SHOW_TYPE, 0));
            jVar.w(i16 == 1 ? i16 : 0);
            jVar.r(g16);
            jVar.m(i3);
            ((rk.e) i.t(rk.e.class)).v(activity, jVar);
            return;
        }
        s(activity, extendGridView, i3, g16, hashMap, i16, intent);
    }

    private ArrayList<PictureItem> g(List<String> list, HashMap<String, ShuoshuoVideoInfo> hashMap, HashMap<String, ShuoshuoVideoInfo> hashMap2, HashMap<String, ArrayList<FaceData>> hashMap3, HashMap<String, LocalMediaInfo> hashMap4) {
        ShuoshuoVideoInfo shuoshuoVideoInfo;
        LocalMediaInfo localMediaInfo;
        int i3;
        int i16;
        if (list == null || list.size() <= 0) {
            return null;
        }
        int size = list.size();
        ArrayList<PictureItem> arrayList = new ArrayList<>();
        for (int i17 = 0; i17 < size; i17++) {
            PictureItem pictureItem = new PictureItem();
            pictureItem.localFileUrl = list.get(i17);
            pictureItem.isSelected = true;
            if (hashMap != null && hashMap.size() > 0 && hashMap.containsKey(pictureItem.localFileUrl)) {
                pictureItem.videoflag = 1;
                VideoInfo videoInfo = new VideoInfo();
                pictureItem.videodata = videoInfo;
                videoInfo.videoUrl = new VideoUrl(pictureItem.localFileUrl);
                pictureItem.videodata.coverUrl = new PictureUrl(hashMap.get(pictureItem.localFileUrl).mCoverUrl, hashMap.get(pictureItem.localFileUrl).mVideoWidth, hashMap.get(pictureItem.localFileUrl).mVideoHeight);
                pictureItem.videodata.width = hashMap.get(pictureItem.localFileUrl).mVideoWidth;
                pictureItem.videodata.height = hashMap.get(pictureItem.localFileUrl).mVideoHeight;
                pictureItem.videodata.videoTime = hashMap.get(pictureItem.localFileUrl).mTotalDuration;
                VideoInfo videoInfo2 = pictureItem.videodata;
                videoInfo2.actionType = 3;
                videoInfo2.playType = (byte) 1;
            }
            if (hashMap4 != null && hashMap4.size() > 0 && (localMediaInfo = hashMap4.get(pictureItem.localFileUrl)) != null) {
                pictureItem.missionId = localMediaInfo.missionID;
                PictureUrl pictureUrl = pictureItem.bigUrl;
                pictureUrl.url = pictureItem.localFileUrl;
                int i18 = localMediaInfo.orientation;
                if (i18 != 90 && i18 != 270) {
                    i3 = localMediaInfo.mediaHeight;
                    i16 = localMediaInfo.mediaWidth;
                } else {
                    i3 = localMediaInfo.mediaWidth;
                    i16 = localMediaInfo.mediaHeight;
                }
                pictureUrl.width = i16;
                pictureUrl.height = i3;
                boolean z16 = QAlbumUtil.getMediaType(localMediaInfo) == 1 || localMediaInfo.mMediaType == 1;
                boolean z17 = hashMap == null || !hashMap.containsKey(pictureItem.localFileUrl);
                if (z16 && z17) {
                    pictureItem.videoflag = 1;
                    VideoInfo videoInfo3 = new VideoInfo();
                    pictureItem.videodata = videoInfo3;
                    videoInfo3.videoUrl = new VideoUrl(pictureItem.localFileUrl);
                    pictureItem.videodata.coverUrl = new PictureUrl("", localMediaInfo.mediaWidth, localMediaInfo.mediaHeight);
                    VideoInfo videoInfo4 = pictureItem.videodata;
                    videoInfo4.width = localMediaInfo.mediaWidth;
                    videoInfo4.height = localMediaInfo.mediaHeight;
                    long j3 = localMediaInfo.mTotalDuration;
                    if (j3 == 0) {
                        j3 = localMediaInfo.mDuration;
                    }
                    videoInfo4.videoTime = j3;
                    videoInfo4.actionType = 3;
                    videoInfo4.playType = (byte) 1;
                }
            }
            if (hashMap2 != null && hashMap2.size() > 0 && (shuoshuoVideoInfo = hashMap2.get(pictureItem.localFileUrl)) != null) {
                pictureItem.videodata = new VideoInfo();
                Bundle bundle = shuoshuoVideoInfo.mExtras;
                if (bundle != null && bundle.getInt("video_state", 0) == 1) {
                    pictureItem.videodata.toast = LocalPictureViewer.J1;
                    pictureItem.localFileUrl = shuoshuoVideoInfo.mCoverUrl;
                } else {
                    pictureItem.videodata.videoId = "local_" + String.valueOf(System.currentTimeMillis()) + "#" + shuoshuoVideoInfo.mStartTime + "#" + shuoshuoVideoInfo.mDuration;
                    VideoInfo videoInfo5 = pictureItem.videodata;
                    videoInfo5.toast = null;
                    pictureItem.videoflag = 1;
                    videoInfo5.videoUrl = new VideoUrl(pictureItem.localFileUrl);
                    pictureItem.videodata.coverUrl = new PictureUrl(shuoshuoVideoInfo.mCoverUrl, shuoshuoVideoInfo.mVideoWidth, shuoshuoVideoInfo.mVideoHeight);
                    VideoInfo videoInfo6 = pictureItem.videodata;
                    videoInfo6.width = shuoshuoVideoInfo.mVideoWidth;
                    videoInfo6.height = shuoshuoVideoInfo.mVideoHeight;
                    videoInfo6.videoTime = shuoshuoVideoInfo.mTotalDuration;
                    videoInfo6.actionType = 3;
                    videoInfo6.playType = (byte) 1;
                }
            }
            if (hashMap3 != null) {
                ArrayList<FaceData> arrayList2 = hashMap3.get(pictureItem.localFileUrl);
                if (arrayList2 != null) {
                    QZLog.d("[PhotoAlbum]FaceFuntion", 1, "tmp.localFileUrl:", pictureItem.localFileUrl, " faceDataArrayList size:", arrayList2);
                }
                pictureItem.faceLists = arrayList2;
            }
            if (o7.b.b(pictureItem.localFileUrl)) {
                pictureItem.type = 2;
            }
            if (pictureItem.videodata != null) {
                pictureItem.type = 1000;
            }
            arrayList.add(pictureItem);
        }
        return arrayList;
    }

    public boolean o(Activity activity, ArrayList<String> arrayList, int i3, boolean z16, int i16, QZoneMediaBusiness qZoneMediaBusiness) {
        return p(activity, arrayList, null, i3, z16, i16, false, false, null, qZoneMediaBusiness);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class c implements DialogInterface.OnClickListener {
        c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class d implements DialogInterface.OnClickListener {
        d() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
        }
    }
}
