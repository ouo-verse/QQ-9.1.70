package com.tencent.aelight.camera.util.api;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.jetbrains.annotations.NotNull;

@QAPI(process = {"all"})
/* loaded from: classes3.dex */
public interface IAECameraPrefsUtil extends QRouteApi {
    public static final String KEY_AEEDITOR_FILES = "key_ae_editor_files";
    public static final String KEY_AEEDITOR_RECORD = "key_ae_editor_record";
    public static final String KEY_AEEDITOR_RECORD_DATA = "key_ae_editor_record_data";
    public static final String KEY_AEEDITOR_RECORD_MID_DATA = "key_ae_editor_record_mid_data";
    public static final String KEY_AEEDITOR_RECORD_TYPE = "key_ae_editor_record_type";
    public static final String KEY_AE_RES = "key_ae_res_";
    public static final String KEY_ARCAKE_ID = "key_ae_arcake_id";
    public static final String KEY_ARCAKE_NICK = "key_ae_arcake_nick";
    public static final String KEY_ARCAKE_PREVIEW = "key_ae_arcake_preview";
    public static final String KEY_ARCAKE_TOUIN = "key_ae_arcake_touin";
    public static final String KEY_ETAG_AEEDITOR_MATERIAL = "ShadowBackendSvc.GetCircleCatMatTreeMqCircleEditor";
    public static final String KEY_ETAG_EMOJI = "ShadowBackendSvc.GetCategoryMaterialMqEmoCamera";
    public static final String KEY_ETAG_FLASH_SHOW = "ShadowBackendSvc.GetCategoryMaterialMqKuaishanCamera";
    public static final String KEY_ETAG_PLAY_SHOW = "ShadowBackendSvc.GetPlayShowCatMatTree";
    public static final String KEY_ETAG_STORY = "ShadowBackendSvc.GetCategoryMaterialMqStoryCamera";
    public static final String KEY_ETAG_STORY_MAKEUP = "ShadowBackendSvc.GetCategoryMaterialMqCameraMakeup";
    public static final String KEY_ETAG_WATERMARK = "ShadowBackendSvc.GetCategoryMaterialMqCircleWatermark";
    public static final String KEY_FIRST_CHANGE_FACE_CLICK = "key_first_change_face_click_flag";
    public static final String KEY_KUOLIE_SITCK_BUBBLE = "key_kuolie_sitck_bubble";
    public static final String KEY_KUOLIE_SITCK_BUBBLE_PANEL = "key_kuolie_sitck_bubble_panel";
    public static final String KEY_PEAK_ACTIVITY_CRASH_ENTRYINFO = "key_peak_activity_crash_entryinfo";
    public static final String KEY_PEAK_ACTIVITY_CRASH_LASTINFO = "key_peak_activity_crash_lastinfo";
    public static final String KEY_PEAK_ACTIVITY_CRASH_PATHINFO = "key_peak_activity_crash_pathinfo";
    public static final String KEY_PEAK_ACTIVITY_CRASH_TIMEINFO = "key_peak_activity_crash_timeinfo";
    public static final String KEY_WEB_SELECTED_PIC_PATH = "key_web_selected_pic_path";

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface PreferenceMode {
    }

    boolean getBoolean(@NotNull String str, boolean z16, int i3);

    int getInt(@NonNull String str, int i3, int i16);

    long getLong(@NonNull String str, long j3, int i3);

    String getString(@NotNull String str, String str2, int i3);

    void putBoolean(@NotNull String str, boolean z16, int i3);

    void putInt(@NonNull String str, int i3, int i16);

    void putLong(@NonNull String str, long j3, int i3);

    void putString(@NonNull String str, String str2, int i3);

    void remove(@NotNull String str, int i3);
}
