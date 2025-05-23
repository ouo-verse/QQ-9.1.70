package com.tencent.aelight.camera.pref.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.ArrayList;

@QAPI(process = {"all"})
/* loaded from: classes3.dex */
public interface IPrefRecorder extends QRouteApi {
    public static final String AI_ELIMINATE_HOT_START = "is_hot_start";
    public static final String AI_ELIMINATE_IS_CANCEL = "is_cancel";
    public static final String AI_ELIMINATE_IS_SUCCESS_APPLY = "is_success_apply";
    public static final String AI_ELIMINATE_RESPONSE_CODE = "response_code";
    public static final String AI_ELIMINATE_TAB_NAME = "tab_name";
    public static final String MILESTONE_AEFTER_DETECT = "afterDetect";
    public static final String MILESTONE_AI_ELIMINATE_BACKEND_REQUEST = "backend_cost";
    public static final String MILESTONE_AI_ELIMINATE_DOWNLOAD_IMG = "download_img_cost";
    public static final String MILESTONE_AI_ELIMINATE_TOTAL_COST = "total_cost";
    public static final String MILESTONE_AI_ELIMINATE_UPLOAD_IMG = "upload_img_cost";
    public static final String MILESTONE_BASE_BUNDLE_DOWNLOADED = "baseBundleDownload";
    public static final String MILESTONE_CAMERA_RECORD_JUMP_AIO = "recordJumpAIO";
    public static final String MILESTONE_CAMERA_RECORD_JUMP_FLASH = "recordJumpFlash";
    public static final String MILESTONE_CAMERA_RESUME_SWITCH = "resumeCost";
    public static final String MILESTONE_CAMERA_SHOOT_JUMP_AIO = "shootJumpAIO";
    public static final String MILESTONE_CAMERA_SHOOT_JUMP_FLASH = "shootJumpFlash";
    public static final String MILESTONE_CAMERA_TAB_SWITCH = "tabSwitch";
    public static final String MILESTONE_CLIECK_NEXT_TIP = "clickNextTip";
    public static final int MILESTONE_DEFAULT_INDEX = 0;
    public static final int MILESTONE_DEFAULT_LAST_INDEX = -1;
    public static final String MILESTONE_EXTRACT_COVER = "extractCover";
    public static final String MILESTONE_FETCH_MUSIC = "fetchMusic";
    public static final String MILESTONE_FETCH_MUSIC_STUCK_POINT = "fetchMusicStuckPoint";
    public static final long MILESTONE_INVAILD = -1;
    public static final String MILESTONE_MAGIC_GALLERY_DOWNLOAD_FIRST_CROP_IMAGE = "xsj_magic_gallery_download_first_crop_image";
    public static final String MILESTONE_MAGIC_GALLERY_DOWNLOAD_FIRST_IMAGE = "xsj_magic_gallery_download_first_image";
    public static final String MILESTONE_MAGIC_GALLERY_DOWNLOAD_TEMPLATE = "xsj_magic_gallery_download_template";
    public static final String MILESTONE_MAGIC_GALLERY_FIRST_FRAME = "xsj_magic_gallery_next_first_frame";
    public static final String MILESTONE_MAGIC_GALLERY_GENERATE_COUNT = "xsj_magic_gallery_generate_count";
    public static final String MILESTONE_MAGIC_GALLERY_MAX_GENERATE_IMAGE = "xsj_magic_gallery_max_generate_image";
    public static final String MILESTONE_MAGIC_GALLERY_MIN_GENERATE_IMAGE = "xsj_magic_gallery_min_generate_image";
    public static final String MILESTONE_MAGIC_GALLERY_PARALLEL_MAX_TIME = "xsj_magic_gallery_parallel_max_time";
    public static final String MILESTONE_MAGIC_GALLERY_REQUEST_COUNT = "xsj_magic_gallery_request_count";
    public static final String MILESTONE_MAGIC_GALLERY_SELECT_TO_COMPLETE_FRAME = "xsj_magic_gallery_select_complete_frame";
    public static final String MILESTONE_MAGIC_GALLERY_SELECT_TO_FIRST_FRAME = "xsj_magic_gallery_select_to_editor_first_frame";
    public static final String MILESTONE_MEDIA_IMPORT = "mediaImport";
    public static final String MILESTONE_ONE_CLICK_TEMPLATE = "oneClickTemplate";
    public static final String MILESTONE_ON_SLEECT_CAMERA_IN_FS = "selectCamera";
    public static final String MILESTONE_START_DETECT = "startDetect";
    public static final String MILESTONE_TIMELINE_GENERATE = "timelineGenerate";
    public static final String MILESTONE_VIDEO_EXPORT = "videoExport";
    public static final String MILESTONE_VIDEO_LOAD_FAKE_FIRST_FRAME = "videoLoadFakeFirstFrame";
    public static final String MILESTONE_VIDEO_LOAD_FIRST_FRAME = "videoLoadFirstFrame";
    public static final String XSJ_MAGIC_GALLERY_GENERATE_STATUS = "xsj_magic_gallery_generate_status";
    public static final String XSJ_MAGIC_GALLERY_SESSION_ID = "xsj_magic_gallery_session_id";
    public static final String XSJ_MAGIC_GALLERY_UPLOAD_FILE = "xsj_magic_gallery_upload_file";
    public static final String XSJ_MAGIC_GALLERY_UPLOAD_RECOMMEND = "xsj_magic_gallery_upload_recommend";
    public static final String XSJ_MAGIC_GALLERY_UPLOAD_WHOLE_TIME = "xsj_magic_gallery_upload_whole_time";

    void clearTimeEvent(String str);

    long getTimeCost(String str);

    long getTimeCost(String str, int i3);

    ArrayList<Long> getTimeCostRange(String str, int... iArr);

    void milestone(String str);

    void milestoneEnd(String str);

    void milestoneEnd(String str, long j3);
}
