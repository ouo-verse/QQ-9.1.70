package com.qzone.common.business.service.media;

import NS_MOBILE_OPERATION.PicInfo;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.qzone.album.ui.activity.QzDynamicVideoEditActivity;
import com.qzone.common.account.LoginData;
import com.qzone.common.activities.base.PhotoActivity;
import com.qzone.preview.PictureViewerFactory;
import com.qzone.proxy.feedcomponent.model.CellPictureInfo;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.publish.ui.activity.QZonePublishMoodActivity;
import com.qzone.publish.ui.activity.QZonePublishMoodRealActivity;
import com.qzone.publish.ui.activity.QZonePublishMoodTabActivity;
import com.qzone.publish.ui.activity.QZoneUploadPhotoActivity;
import com.qzone.publish.ui.activity.QZoneUploadPhotoRealActivity;
import com.qzone.reborn.albumx.qzonex.activity.QZonePublishXMoodRealActivity;
import com.qzone.widget.ExtendGridView;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.QAlbumConstants;
import com.tencent.mobileqq.activity.richmedia.p2veffect.effect.base.P2VGlobalConfig;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.pubaccount.publish.QQPublicAccountPublishFeedActivity;
import com.tencent.pubaccount.publish.QQPublicAccountPublishFeedFragment;
import common.config.service.QzoneConfig;
import cooperation.peak.PeakConstants;
import cooperation.qzone.Lbs.QzoneLbsConstant;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.media.QZoneMediaBusiness;
import cooperation.qzone.model.PhotoInfo;
import cooperation.qzone.util.QZLog;
import cooperation.zebra.ZebraPluginProxy;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
@Deprecated
/* loaded from: classes39.dex */
public class b implements a {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f45826a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f45827b;

    public b() {
        this.f45826a = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_QZONE_SUPPORT_HEIF, 1) > 0;
        this.f45827b = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_SUPPORT_VIDEO_CHECKBOX, 1) > 0;
    }

    @Override // com.qzone.common.business.service.media.a
    public void b(Activity activity, Fragment fragment, ArrayList<String> arrayList, HashMap<String, PicInfo> hashMap, int i3, int i16, boolean z16, boolean z17, ConcurrentHashMap<String, String> concurrentHashMap, String str, Bundle bundle, HashMap<String, LocalMediaInfo> hashMap2, QZoneMediaBusiness qZoneMediaBusiness) {
        boolean z18;
        boolean z19;
        boolean z26;
        String name;
        int i17 = i16;
        QZLog.i("upload2_QZoneQQBaseMediaImpl", "onLocalPhoto");
        if (!this.f45826a) {
            if (i17 == 5) {
                i17 = 0;
            } else if (i17 == 6) {
                i17 = 1;
            } else if (i17 == 7) {
                i17 = 3;
            }
        }
        ArrayList<String> arrayList2 = arrayList == null ? new ArrayList<>() : arrayList;
        Bundle bundle2 = new Bundle();
        bundle2.putBoolean(QAlbumConstants.SHOW_GIF_TYPE_ICON, true);
        boolean z27 = activity instanceof QZonePublishMoodRealActivity;
        if (z27 || (activity instanceof QZonePublishXMoodRealActivity) || (fragment instanceof QZonePublishMoodActivity)) {
            bundle2.putBoolean(PeakConstants.IS_SHOW_QZONE_ALBUM, true);
            if (this.f45827b && bundle != null && bundle.getBoolean("QZONE_SUPPORT_MIX_MOOD", false)) {
                bundle2.putBoolean(QAlbumConstants.IS_SUPPORT_VIDEO_CHECKBOX, true);
            }
            bundle2.putLong(PeakConstants.PHOTOLIST_KEY_VIDEO_CAN_UPLOAD_DURATION, QZoneHelper.getVideoCanUploadLimitMs());
        }
        boolean z28 = activity instanceof QZonePublishMoodTabActivity;
        if (z28 || (fragment instanceof PhotoActivity)) {
            if (!(activity instanceof QQPublicAccountPublishFeedActivity) && !(fragment instanceof QQPublicAccountPublishFeedFragment)) {
                bundle2.putBoolean(PeakConstants.IS_SHOW_QZONE_ALBUM, true);
                z18 = false;
            } else {
                z18 = false;
                bundle2.putBoolean(PeakConstants.IS_SHOW_QZONE_ALBUM, false);
            }
            if (bundle != null && bundle.getBoolean("QZONE_SUPPORT_MIX_MOOD", z18)) {
                bundle2.putBoolean(QAlbumConstants.IS_SUPPORT_VIDEO_CHECKBOX, true);
            }
            z19 = z28;
            bundle2.putLong(PeakConstants.PHOTOLIST_KEY_VIDEO_CAN_UPLOAD_DURATION, QZoneHelper.getVideoCanUploadLimitMs());
        } else {
            z19 = z28;
        }
        boolean z29 = activity instanceof QZoneUploadPhotoRealActivity;
        if (z29 || (fragment instanceof QZoneUploadPhotoActivity)) {
            bundle2.putBoolean(PeakConstants.IS_SHOW_QZONE_ALBUM, false);
            z26 = z29;
            bundle2.putLong(PeakConstants.PHOTOLIST_KEY_VIDEO_CAN_UPLOAD_DURATION, QZoneHelper.getVideoCanUploadLimitMs());
            bundle2.putBoolean(QAlbumConstants.IS_SUPPORT_VIDEO_CHECKBOX, true);
        } else {
            z26 = z29;
        }
        if (QzDynamicVideoEditActivity.Oh(activity)) {
            bundle2.putBoolean(PeakConstants.IS_SHOW_QZONE_ALBUM, true);
            bundle2.putLong(PeakConstants.PHOTOLIST_KEY_VIDEO_CAN_UPLOAD_DURATION, P2VGlobalConfig.VIDEO_CAN_UPLOAD_LIMIT_MS);
            bundle2.putBoolean(QAlbumConstants.IS_SUPPORT_VIDEO_CHECKBOX, true);
            bundle2.putBoolean(PeakConstants.IS_FROM_P2V, true);
        }
        bundle2.putStringArrayList("PhotoConst.PHOTO_PATHS", arrayList2);
        bundle2.putSerializable(PeakConstants.PHOTO_INFOS, hashMap);
        bundle2.putInt("PhotoConst.MAXUM_SELECTED_NUM", i3);
        bundle2.putBoolean("PhotoConst.IS_SINGLE_MODE", false);
        bundle2.putBoolean(PeakConstants.IS_FINISH_RESTART_INIT_ACTIVITY, true);
        if (bundle != null ? bundle.getBoolean(PeakConstants.IS_EMBEDED_IN_TAB, false) : false) {
            name = QZonePublishMoodTabActivity.class.getName();
        } else {
            name = activity != null ? activity.getClass().getName() : "";
        }
        bundle2.putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", name);
        bundle2.putString("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
        bundle2.putBoolean(PeakConstants.PHOTO_LIST_SHOW_PREVIEW, true);
        bundle2.putInt(QAlbumConstants.PHOTOLIST_KEY_SHOW_MEDIA, i17);
        bundle2.putString("uin", String.valueOf(LoginData.getInstance().getUin()));
        bundle2.putInt("uintype", 0);
        String config = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_MINI_VIDEO, QzoneConfig.SECONDARY_UPLOAD_VIDEO_FILE_SIZE_LIMIT);
        bundle2.putLong(PeakConstants.PHOTOLIST_KEY_VIDEO_SIZE, TextUtils.isEmpty(config) ? 1048576000L : Long.parseLong(config));
        if (QzDynamicVideoEditActivity.Oh(activity)) {
            long j3 = P2VGlobalConfig.VIDEO_CAN_UPLOAD_LIMIT_MS;
            bundle2.putLong(PeakConstants.PHOTOLIST_KEY_VIDEO_DURATION, j3);
            bundle2.putLong(PeakConstants.QZONE_COVER_PHOTOLIST_KEY_VIDEO_DURATION, j3);
            bundle2.putLong(QAlbumConstants.PHOTOLIST_KEY_FILTER_VIDEO_DURATION_LIMIT, j3);
        } else if (activity instanceof QQPublicAccountPublishFeedActivity) {
            bundle2.putLong(PeakConstants.PHOTOLIST_KEY_VIDEO_DURATION, 600000L);
        } else {
            bundle2.putLong(PeakConstants.PHOTOLIST_KEY_VIDEO_DURATION, QZoneHelper.getVideoCanUploadLimitMs());
        }
        boolean z36 = false;
        bundle2.putBoolean(PeakConstants.IS_PREVIEW_VIDEO, false);
        bundle2.putBoolean(PeakConstants.IS_TRIM_VIDEO_BLACK_LIST, z16);
        if (activity != null) {
            bundle2.putString(PeakConstants.VIDEO_REFER, activity.getClass().getName());
        }
        bundle2.putBoolean(PeakConstants.SHOW_MAGIC_USE_PASTER, z17);
        bundle2.putSerializable("PasterConstants.original_to_bottom", concurrentHashMap);
        bundle2.putString("report_from", str);
        if (!bundle2.containsKey(AECameraConstants.KEY_LATITUDE)) {
            bundle2.putDouble(AECameraConstants.KEY_LATITUDE, com.qzone.business.lbsv2.business.c.g(QzoneLbsConstant.BUSINESS_ID_QZONE_OTHER).b());
            bundle2.putDouble(AECameraConstants.KEY_LONGTITUDE, com.qzone.business.lbsv2.business.c.g(QzoneLbsConstant.BUSINESS_ID_QZONE_OTHER).d());
        }
        boolean z37 = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PHOTO_ALBUM, QzoneConfig.SECONDARY_RECENT_PHOTO_CAMERA, 1) > 0;
        if (i17 != 1 && i17 != 6) {
            z36 = z37;
        }
        if (z27 || (activity instanceof QZonePublishXMoodRealActivity) || z19 || z26 || (fragment instanceof PhotoActivity)) {
            bundle2.putBoolean(QAlbumConstants.IS_SHOW_CAMERA, z36);
            bundle2.putBoolean(QAlbumConstants.SHOW_CAMERA_IN_VIDEO, z36);
        }
        if (bundle != null) {
            bundle2.putAll(bundle);
        }
        QzonePluginProxyActivity.toExActivityWithResult(bundle2);
        if (activity != null) {
            activity.overridePendingTransition(R.anim.f154424l, R.anim.f154422j);
        }
        ZebraPluginProxy.startPhotoList(activity, bundle2);
    }

    @Override // com.qzone.common.business.service.media.a
    public void d(Activity activity, int i3, Bundle bundle) {
        QZLog.i("upload2_QZoneQQBaseMediaImpl", "onLocalPhotoForP2V");
        if (!this.f45826a) {
            if (i3 == 5) {
                i3 = 0;
            } else if (i3 == 6) {
                i3 = 1;
            } else if (i3 == 7) {
                i3 = 3;
            }
        }
        Bundle bundle2 = new Bundle();
        bundle2.putInt(QAlbumConstants.PHOTOLIST_KEY_SHOW_MEDIA, i3);
        if (bundle != null) {
            bundle2.putAll(bundle);
        }
        QzonePluginProxyActivity.toExActivityWithResult(bundle2);
        if (activity == null) {
            QZLog.e("upload2_QZoneQQBaseMediaImpl", "activity is null");
        } else {
            activity.overridePendingTransition(R.anim.f154424l, R.anim.f154422j);
            ZebraPluginProxy.startPhotoList(activity, bundle2);
        }
    }

    @Override // com.qzone.common.business.service.media.a
    public void e(Activity activity, ExtendGridView extendGridView, int i3, ArrayList<PictureItem> arrayList, HashMap<String, LocalMediaInfo> hashMap, int i16, Intent intent) {
        QZLog.i("upload2_QZoneQQBaseMediaImpl", "onPhotoPreview");
        CellPictureInfo cellPictureInfo = new CellPictureInfo();
        cellPictureInfo.uin = LoginData.getInstance().getUin();
        cellPictureInfo.balbum = false;
        cellPictureInfo.pics = arrayList;
        PictureViewerFactory.N(activity, cellPictureInfo, i3, 6002, i16, 0, 0, intent);
    }

    @Override // com.qzone.common.business.service.media.a
    public int f() {
        return 0;
    }

    @Override // com.qzone.common.business.service.media.a
    public void g(Activity activity, File file, int i3, Bundle bundle, QZoneMediaBusiness qZoneMediaBusiness) {
        QZLog.i("upload2_QZoneQQBaseMediaImpl", "goToCameraActivity");
        Intent intent = new Intent();
        FileProvider7Helper.setSystemCapture(activity, file, intent);
        activity.startActivityForResult(intent, 6000);
    }

    @Override // com.qzone.common.business.service.media.a
    public void c(Activity activity, c cVar) {
    }

    @Override // com.qzone.common.business.service.media.a
    public void a(Activity activity, PhotoInfo photoInfo, QZoneMediaBusiness qZoneMediaBusiness) {
    }
}
