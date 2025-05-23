package com.tencent.aelight.camera.ae.util;

import android.app.Activity;
import android.content.Intent;
import com.tencent.aelight.camera.ae.camera.ui.gallery.PhotoListCustomizationAECapture;
import com.tencent.aelight.camera.ae.camera.ui.gallery.PhotoPreviewCustomizationAECapture;
import com.tencent.aelight.camera.ae.play.AETemplateInfoFragment;
import com.tencent.aelight.camera.aioeditor.PhotoListCustomizationAECamera;
import com.tencent.aelight.camera.api.IQIMCameraCapture;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.aelight.camera.entry.api.IAECameraEntryManager;
import com.tencent.aelight.camera.qqstory.api.IJumpUtil;
import com.tencent.aelight.camera.util.api.IPicChooseJumpUtil;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.QAlbumConstants;
import com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationAEPlay;
import com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewCustomizationAEPlay;
import com.tencent.mobileqq.qqalbum.IPhotoLogicFactory;
import com.tencent.mobileqq.qroute.QRoute;
import cooperation.peak.PeakConstants;

/* compiled from: P */
/* loaded from: classes32.dex */
public class p {
    public static void a(Activity activity, int i3, int i16, boolean z16, int i17, int i18) {
        String name = ((IQIMCameraCapture) QRoute.api(IQIMCameraCapture.class)).getQIMCameraCaptureActivityClass().getName();
        Intent intent = new Intent(activity, (Class<?>) NewPhotoListActivity.class);
        intent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", name);
        intent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
        intent.putExtra(IPhotoLogicFactory.ENTER_FROM, i16);
        intent.putExtra(IPhotoLogicFactory.KEY_PHOTO_LIST_CLASS_NAME, PhotoListCustomizationAECapture.N);
        intent.putExtra(IPhotoLogicFactory.KEY_PHOTO_PREVIEW_CLASS_NAME, PhotoPreviewCustomizationAECapture.M);
        intent.putExtra(QAlbumConstants.PHOTOLIST_KEY_SHOW_MEDIA, 4);
        intent.putExtra("PhotoConst.IS_SINGLE_MODE", false);
        intent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 1);
        intent.putExtra("MaterialConfig.minImageWidth", i17);
        intent.putExtra("MaterialConfig.minImageHeight", i18);
        intent.putExtra("MaterialConfig.needFace", z16);
        activity.startActivityForResult(intent, i3);
    }

    public static void b(Activity activity, int i3) {
        String name = ((IQIMCameraCapture) QRoute.api(IQIMCameraCapture.class)).getQIMCameraCaptureActivityClass().getName();
        Intent intent = new Intent(activity, (Class<?>) NewPhotoListActivity.class);
        intent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", name);
        intent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
        intent.putExtra(IPhotoLogicFactory.ENTER_FROM, 23);
        intent.putExtra(IPhotoLogicFactory.KEY_PHOTO_LIST_CLASS_NAME, PhotoListCustomizationAEPlay.F);
        intent.putExtra(IPhotoLogicFactory.KEY_PHOTO_PREVIEW_CLASS_NAME, PhotoPreviewCustomizationAEPlay.G);
        intent.putExtra(QAlbumConstants.PHOTOLIST_KEY_SHOW_MEDIA, 1);
        intent.putExtra("PhotoConst.IS_SINGLE_MODE", false);
        intent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", i3);
        intent.putExtra(AECameraConstants.VIDEO_STORY_FROM_TYPE, AETemplateInfoFragment.getFromType(activity));
        activity.startActivity(intent);
    }

    public static void c(Activity activity, int i3) {
        String name = ((IQIMCameraCapture) QRoute.api(IQIMCameraCapture.class)).getQIMCameraCaptureActivityClass().getName();
        Intent intent = new Intent(activity, (Class<?>) NewPhotoListActivity.class);
        intent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", name);
        intent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
        intent.putExtra(IPhotoLogicFactory.ENTER_FROM, 23);
        intent.putExtra(IPhotoLogicFactory.KEY_PHOTO_LIST_CLASS_NAME, PhotoListCustomizationAEPlay.F);
        intent.putExtra(IPhotoLogicFactory.KEY_PHOTO_PREVIEW_CLASS_NAME, PhotoPreviewCustomizationAEPlay.G);
        intent.putExtra("PhotoConst.IS_SINGLE_MODE", true);
        intent.putExtra(QAlbumConstants.PHOTOLIST_KEY_SHOW_MEDIA, 1);
        intent.putExtra(IPicChooseJumpUtil.PIC_NODE_ID, i3);
        intent.putExtra(AECameraConstants.VIDEO_STORY_FROM_TYPE, AETemplateInfoFragment.getFromType(activity));
        activity.startActivity(intent);
    }

    public static void d(Activity activity) {
        if (activity == null) {
            ms.a.c("PicChooseJumpUtil", "activity is null.");
            return;
        }
        String name = ((IQIMCameraCapture) QRoute.api(IQIMCameraCapture.class)).getQIMCameraCaptureActivityClass().getName();
        Intent intent = new Intent(activity, (Class<?>) NewPhotoListActivity.class);
        intent.putExtra(PeakConstants.IS_WAIT_DEST_RESULT, true);
        intent.putExtra(QAlbumConstants.PHOTOLIST_KEY_SHOW_MEDIA, 5);
        intent.putExtra(PeakConstants.PHOTOLIST_KEY_VIDEO_DURATION, 60000L);
        intent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", name);
        intent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
        intent.putExtra(IPhotoLogicFactory.ENTER_FROM, 26);
        intent.putExtra(IPhotoLogicFactory.KEY_PHOTO_LIST_CLASS_NAME, PhotoListCustomizationAECamera.F);
        intent.putExtra("PhotoConst.IS_SINGLE_MODE", true);
        intent.putExtra(IPicChooseJumpUtil.PIC_BACK_TYPE_RESULT, true);
        intent.putExtra("VIDEO_STORY_JUMP_TO_TYPE", ((IAECameraEntryManager) QRoute.api(IAECameraEntryManager.class)).getStoryShareType(activity.getIntent()));
        intent.putExtra(AECameraConstants.VIDEO_STORY_FROM_TYPE, ((IAECameraEntryManager) QRoute.api(IAECameraEntryManager.class)).getAEFromType(activity.getIntent()));
        intent.putExtra(IJumpUtil.EDIT_VIDEO_WAY, 11);
        intent.putExtra("edit_video_type", 10023);
        activity.startActivityForResult(intent, 10006);
    }
}
