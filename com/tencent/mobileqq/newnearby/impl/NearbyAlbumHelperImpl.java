package com.tencent.mobileqq.newnearby.impl;

import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.album.QAlbumConstants;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationNearby;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.api.ICompressOperator;
import com.tencent.mobileqq.qqalbum.IPhotoLogicFactory;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mtt.hippy.modules.Promise;
import cooperation.peak.PeakConstants;
import cooperation.qzone.QZoneHelper;

/* compiled from: P */
/* loaded from: classes33.dex */
public class NearbyAlbumHelperImpl {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f254217a;

    /* renamed from: b, reason: collision with root package name */
    private static Promise f254218b;

    /* renamed from: c, reason: collision with root package name */
    private static Promise f254219c;

    /* renamed from: d, reason: collision with root package name */
    private static String f254220d;

    private static void c(QBaseActivity qBaseActivity) {
        ActivityURIRequest activityURIRequest = new ActivityURIRequest(qBaseActivity, IPhotoLogicFactory.PHOTO_LIST_ACTIVITY_URI);
        activityURIRequest.extra().putInt("PhotoConst.MAXUM_SELECTED_NUM", 1);
        activityURIRequest.extra().putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", qBaseActivity.getClass().getName());
        activityURIRequest.extra().putString("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
        activityURIRequest.extra().putBoolean(QAlbumConstants.IS_RECODE_LAST_ALBUMPATH, false);
        activityURIRequest.extra().putBoolean("PhotoConst.IS_SINGLE_MODE", false);
        activityURIRequest.extra().putBoolean(PeakConstants.IS_SINGLE_NEED_EDIT, true);
        activityURIRequest.extra().putBoolean(PeakConstants.IS_FINISH_RESTART_INIT_ACTIVITY, true);
        activityURIRequest.extra().putBoolean(PeakConstants.PHOTO_LIST_SHOW_PREVIEW, true);
        activityURIRequest.extra().putString(PeakConstants.TARGET_PATH, VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH + AppConstants.PATH_NEARBY_PEOPLE_PHOTO) + System.currentTimeMillis() + ".jpg");
        activityURIRequest.extra().putInt(PeakConstants.CLIP_WIDTH, 640);
        activityURIRequest.extra().putInt(PeakConstants.CLIP_HEIGHT, 640);
        activityURIRequest.extra().putInt(PeakConstants.TARGET_WIDTH, 640);
        activityURIRequest.extra().putInt(PeakConstants.TARGET_HEIGHT, 640);
        activityURIRequest.extra().putInt(IPhotoLogicFactory.ENTER_FROM, 30);
        activityURIRequest.extra().putString(IPhotoLogicFactory.KEY_PHOTO_LIST_CLASS_NAME, PhotoListCustomizationNearby.F);
        QRoute.startUri(activityURIRequest);
        QAlbumUtil.anim(qBaseActivity, false, true);
    }

    private static void d(QBaseActivity qBaseActivity) {
        QZoneHelper.UserInfo userInfo = QZoneHelper.UserInfo.getInstance();
        userInfo.qzone_uin = qBaseActivity.getAppRuntime().getCurrentAccountUin();
        userInfo.nickname = ((QQAppInterface) qBaseActivity.getAppRuntime()).getCurrentNickname();
        Bundle bundle = new Bundle();
        bundle.putString("key_title", qBaseActivity.getString(R.string.gjv));
        bundle.putInt("key_personal_album_enter_model", 2);
        bundle.putBoolean("show_album", false);
        bundle.putBoolean(QZoneHelper.QZonePersonalAlbumContants.KEY_NEED_CHANGE_TO_JPG, true);
        QZoneHelper.forwardToPersonalAlbumSelect(qBaseActivity, userInfo, bundle, 5);
    }

    public static void e(boolean z16) {
        f254217a = z16;
    }

    public static void f(Promise promise) {
        f254219c = promise;
        if (TextUtils.isEmpty(f254220d)) {
            return;
        }
        new Handler().post(new Runnable() { // from class: com.tencent.mobileqq.newnearby.impl.NearbyAlbumHelperImpl.1
            @Override // java.lang.Runnable
            public void run() {
                CompressInfo compressInfo = new CompressInfo(NearbyAlbumHelperImpl.f254220d, 0);
                compressInfo.K = 0;
                ((ICompressOperator) QRoute.api(ICompressOperator.class)).start(compressInfo);
                TransferRequest transferRequest = new TransferRequest();
                transferRequest.mIsUp = true;
                transferRequest.mLocalPath = compressInfo.H;
                transferRequest.mFileType = 8;
                ((ITransFileController) ((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime()).getRuntimeService(ITransFileController.class)).transferAsync(transferRequest);
            }
        });
    }

    public static void b(int i3, QBaseActivity qBaseActivity, Promise promise) {
        e(true);
        f254218b = promise;
        if (i3 == 1) {
            c(qBaseActivity);
        } else if (i3 == 2) {
            d(qBaseActivity);
        }
    }
}
