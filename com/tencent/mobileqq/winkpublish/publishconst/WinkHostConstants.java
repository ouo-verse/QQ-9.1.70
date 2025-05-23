package com.tencent.mobileqq.winkpublish.publishconst;

import com.tencent.mobileqq.config.api.IAppSettingApi;
import com.tencent.mobileqq.qroute.QRoute;
import cooperation.qzone.QZoneHelper;

/* compiled from: P */
/* loaded from: classes21.dex */
public class WinkHostConstants {

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public static class AEEditorConstants {
        public static String keyVideoCoverPath() {
            return com.tencent.aelight.camera.constants.AEEditorConstants.KEY_VIDEO_COVER_PATH;
        }

        public static String keyVideoCoverPosition() {
            return com.tencent.aelight.camera.constants.AEEditorConstants.KEY_VIDEO_COVER_POSITION;
        }

        public static String keyVideoMediaPath() {
            return com.tencent.aelight.camera.constants.AEEditorConstants.KEY_VIDEO_MEDIA_PATH;
        }

        public static String videoPhotoFrom() {
            return com.tencent.aelight.camera.constants.AEEditorConstants.VIDEO_PHOTO_FROM;
        }
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public static class AppSetting {
        public static String buildNum() {
            return ((IAppSettingApi) QRoute.api(IAppSettingApi.class)).buildNum();
        }

        public static boolean enableTalkBack() {
            return ((IAppSettingApi) QRoute.api(IAppSettingApi.class)).enableTalkBack();
        }

        public static String getSubVersion() {
            return ((IAppSettingApi) QRoute.api(IAppSettingApi.class)).getSubVersion();
        }

        public static String getVersion() {
            return ((IAppSettingApi) QRoute.api(IAppSettingApi.class)).getVersion();
        }

        public static boolean isDebugVersion() {
            return ((IAppSettingApi) QRoute.api(IAppSettingApi.class)).isDebugVersion();
        }

        public static boolean isGrayVersion() {
            return ((IAppSettingApi) QRoute.api(IAppSettingApi.class)).isGrayVersion();
        }

        public static boolean isPublicVersion() {
            return ((IAppSettingApi) QRoute.api(IAppSettingApi.class)).isPublicVersion();
        }

        public static String reportVersionName() {
            return ((IAppSettingApi) QRoute.api(IAppSettingApi.class)).getReportVersionName();
        }
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public static class PhotoConst {
        public static String photoPaths() {
            return "PhotoConst.PHOTO_PATHS";
        }
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public static class QAlbumConstants {
        public static String selectedMediaInfoHashMap() {
            return "PeakConstants.selectedMediaInfoHashMap";
        }
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public static class QQStoryMainActivity {
        public static int requestCodeTakeVideo() {
            return 20000;
        }
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public static class QZoneAppConstants {
        public static String keyUploadEntrance() {
            return QZoneHelper.QZoneAppConstants.KEY_UPLOAD_ENTRANCE;
        }

        public static int qzoneBussinessId() {
            return 1000027;
        }
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public static class QZoneConstant {
        public static int qzGetLocationForPoi() {
            return 1208;
        }

        public static String shareImages() {
            return "images";
        }

        public static String shareSummary() {
            return "summary";
        }
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public static class QzoneLbsConstant {
        public static String businessIdQzoneSay() {
            return cooperation.qzone.Lbs.QzoneLbsConstant.BUSINESS_ID_QZONE_SAY;
        }
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public static class QzoneModuleConst {
        public static String qzoneModuleUploadSo() {
            return cooperation.qzone.networkedmodule.QzoneModuleConst.QZONE_MODULE_UPLOAD_SO;
        }
    }
}
