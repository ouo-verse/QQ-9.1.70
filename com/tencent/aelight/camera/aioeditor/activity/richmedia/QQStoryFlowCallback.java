package com.tencent.aelight.camera.aioeditor.activity.richmedia;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaMetadataRetriever;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.aelight.camera.aioeditor.takevideo.EditVideoActivity;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.aelight.camera.entry.api.IAECameraEntryManager;
import com.tencent.aelight.camera.qqstory.api.IJumpUtil;
import com.tencent.aelight.camera.report.api.IAEBaseReportParam;
import com.tencent.component.media.MediaFile;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.editor.params.EditLocalPhotoSource;
import com.tencent.mobileqq.editor.params.EditLocalVideoSource;
import com.tencent.mobileqq.editor.params.EditVideoParams;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import fs.s;
import java.io.File;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes32.dex */
public class QQStoryFlowCallback {

    /* renamed from: a, reason: collision with root package name */
    public static int f66327a = 419430400;

    /* renamed from: b, reason: collision with root package name */
    public static int f66328b = 240;

    /* renamed from: c, reason: collision with root package name */
    public static int f66329c = 180000;

    /* renamed from: d, reason: collision with root package name */
    public static int f66330d = 2000;

    /* renamed from: e, reason: collision with root package name */
    public static int f66331e = 12002200;

    /* renamed from: f, reason: collision with root package name */
    public static int f66332f = 20971520;

    /* renamed from: g, reason: collision with root package name */
    public static int f66333g = 240;

    /* renamed from: h, reason: collision with root package name */
    public static int f66334h;

    /* renamed from: i, reason: collision with root package name */
    public static float f66335i = (12002200 / 10000) / 1000.0f;

    /* renamed from: j, reason: collision with root package name */
    public static float f66336j = (12002200 % 10000) / 1000.0f;

    public static String a(LocalMediaInfo localMediaInfo) {
        return localMediaInfo.fileSize + "|" + localMediaInfo.mediaWidth + "|" + localMediaInfo.mediaHeight + "|" + localMediaInfo.mDuration + "," + localMediaInfo.mMimeType + "," + localMediaInfo.rotation;
    }

    public static String b(Activity activity, int i3) {
        if (activity.getIntent().hasExtra("extra_upload_temp_directory")) {
            return activity.getIntent().getStringExtra("extra_upload_temp_directory");
        }
        String b16 = s.b(i3);
        activity.getIntent().putExtra("extra_upload_temp_directory", b16);
        return b16;
    }

    public static void f(Activity activity, String str, LocalMediaInfo localMediaInfo, int i3, int i16, int i17, int i18, int i19, String str2, String str3, boolean z16, int i26, int i27, Bundle bundle) {
        EditVideoParams.EditSource editLocalPhotoSource;
        boolean z17;
        Bundle bundle2;
        boolean z18;
        try {
            Bundle bundle3 = new Bundle();
            bundle3.putString("extra_upload_temp_directory", b(activity, i27));
            bundle3.putInt("entrance_type", i17);
            long longExtra = activity.getIntent().getLongExtra("troop_uin", 0L);
            if (localMediaInfo.mMimeType.contains("video")) {
                if (!TextUtils.isEmpty(localMediaInfo.path) && !localMediaInfo.path.equalsIgnoreCase("null")) {
                    ((IAEBaseReportParam) QRoute.api(IAEBaseReportParam.class)).setContentType(4L);
                }
                editLocalPhotoSource = new EditLocalVideoSource(str, localMediaInfo, i3, i16);
            } else {
                if (!TextUtils.isEmpty(localMediaInfo.path) && !localMediaInfo.path.equalsIgnoreCase("null")) {
                    ((IAEBaseReportParam) QRoute.api(IAEBaseReportParam.class)).setContentType(3L);
                }
                editLocalPhotoSource = new EditLocalPhotoSource(str, localMediaInfo);
            }
            if (i27 == 11) {
                Bundle extras = activity.getIntent().getExtras();
                JSONObject c16 = c(extras);
                boolean z19 = false;
                if (c16 != null) {
                    boolean optBoolean = c16.optBoolean("needVideoDoodle", false);
                    z18 = c16.optBoolean("needVideoWording", false);
                    z19 = optBoolean;
                } else {
                    z18 = false;
                }
                r17 = z19 ? 1643 : 619;
                if (!z18) {
                    r17 &= -2;
                }
                bundle3.putAll(extras);
            }
            int i28 = r17;
            if (i27 == 12) {
                z17 = false;
                boolean booleanExtra = activity.getIntent().getBooleanExtra("needVideoDoodle", false);
                boolean booleanExtra2 = activity.getIntent().getBooleanExtra("needVideoWording", false);
                if (!booleanExtra) {
                    i28 &= -1025;
                }
                if (!booleanExtra2) {
                    i28 &= -2;
                }
            } else {
                z17 = false;
            }
            if (i27 != 11 && i27 != 12) {
                i28 |= 4096;
            }
            if (((IAECameraEntryManager) QRoute.api(IAECameraEntryManager.class)).isStoryPhoto(activity.getIntent(), i27) || ((IAECameraEntryManager) QRoute.api(IAECameraEntryManager.class)).isSameStoryPhotoEntry(activity.getIntent())) {
                i28 = 512;
            }
            int i29 = 10023;
            if (i18 == 10023 || i18 == 10024) {
                i28 |= 8192;
            }
            EditVideoParams editVideoParams = new EditVideoParams(i27, i28, editLocalPhotoSource, bundle3);
            editVideoParams.D = activity.getIntent().getIntExtra(AECameraConstants.VIDEO_STORY_FROM_TYPE, js.a.f410904d.b());
            if (longExtra != 0) {
                editVideoParams.f204058h.putLong("troop_uin", longExtra);
            }
            if (i27 == 14) {
                editVideoParams.f204058h.putBoolean("extra_is_fit_center", true);
                bundle2 = bundle;
                editVideoParams.f204058h.putBoolean("extra_photo_list_to_edit", (bundle2 == null || !bundle2.getBoolean("VIDEO_STORY_PHOTO_LIST_TO_EDIT")) ? z17 : true);
            } else {
                bundle2 = bundle;
            }
            editVideoParams.f204058h.putBoolean("enable_hw_encode", true);
            editVideoParams.f204058h.putBoolean("ignorePersonalPublish", z16);
            editVideoParams.f204058h.putInt("shareGroupType", i19);
            editVideoParams.f204058h.putString("shareGroupId", str2);
            editVideoParams.f204058h.putString("shareGroupName", str3);
            editVideoParams.f204058h.putBoolean("extra_is_slide_show_video", i26 == 7 ? true : z17);
            hd0.c.a("Q.qqstory.publish.QQStoryFlowCallback", "EditVideoParams params:" + editVideoParams.toString());
            Intent intent = new Intent(activity, (Class<?>) EditVideoActivity.class);
            com.tencent.biz.qqstory.utils.j.a(intent, activity.getIntent().getExtras(), activity);
            intent.putExtra(EditVideoParams.class.getName(), editVideoParams);
            intent.putExtra("op_department", "grp_qq");
            intent.putExtra("op_type", "video_edit");
            intent.putExtra("stop_record_time", System.currentTimeMillis());
            intent.putExtra("short_video_entrance_type", 6);
            intent.putExtra(IJumpUtil.EDIT_VIDEO_WAY, i26);
            intent.putExtra(AECameraConstants.VIDEO_STORY_FROM_TYPE, ((IAECameraEntryManager) QRoute.api(IAECameraEntryManager.class)).getAEFromType(activity.getIntent()));
            if (i27 == 14) {
                intent.putExtra("VIDEO_STORY_JUMP_TO_TYPE", ((IAECameraEntryManager) QRoute.api(IAECameraEntryManager.class)).getStoryShareType(activity.getIntent()));
                intent.putExtra("VIDEO_STORY_MEDIA_TYPE", ((IAECameraEntryManager) QRoute.api(IAECameraEntryManager.class)).getStoryMediaType(activity.getIntent()));
            }
            if (bundle2 != null) {
                intent.putExtra("state", bundle2);
            }
            if (i27 == 11) {
                i29 = 10012;
            } else if (i27 == 12) {
                i29 = 10013;
            } else if (i27 != 14) {
                i29 = i27 == 2 ? 10000 : 10002;
            }
            intent.putExtra("stop_record_time", System.currentTimeMillis());
            intent.putExtra(AECameraConstants.KEY_FROM_PIC_CHOOSE, d(activity));
            activity.startActivityForResult(intent, i29);
        } catch (Exception e16) {
            hd0.c.g("Q.qqstory.publish.QQStoryFlowCallback", "startEditVideoActivity exception:" + e16);
        }
    }

    public static JSONObject c(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        String string = bundle.getString("options");
        if (QLog.isColorLevel()) {
            QLog.d("Q.qqstory.publish.QQStoryFlowCallback", 2, "getTribeJsonExtra option: " + string);
        }
        try {
            return new JSONObject(string);
        } catch (Exception e16) {
            if (!QLog.isColorLevel()) {
                return null;
            }
            QLog.e("Q.qqstory.publish.QQStoryFlowCallback", 2, "getTribeJsonExtra: " + e16);
            return null;
        }
    }

    public static boolean g() {
        com.tencent.biz.qqstory.model.h hVar = (com.tencent.biz.qqstory.model.h) com.tencent.biz.qqstory.model.i.c(10);
        if (hVar == null) {
            hd0.c.g("Q.qqstory.publish.QQStoryFlowCallback", "StoryConfigManager(CONFIG_MANAGER) is null!");
            return false;
        }
        int f16 = hVar.f();
        if (f16 == f66334h) {
            return false;
        }
        f66327a = ((Integer) hVar.j("localUploadVideoSizeLimit", Integer.valueOf(f66327a))).intValue();
        f66328b = ((Integer) hVar.j("localUploadVideoMinResolutionLimit", Integer.valueOf(f66328b))).intValue();
        f66329c = ((Integer) hVar.j("localUploadVideoDurationLimit", Integer.valueOf(f66329c))).intValue();
        f66331e = ((Integer) hVar.j("localUploadVideoRatioLimit", Integer.valueOf(f66331e))).intValue();
        f66332f = ((Integer) hVar.j("localUploadImageSizeLimit", Integer.valueOf(f66332f))).intValue();
        f66333g = ((Integer) hVar.j("localUploadImageMinResolutionLimit", Integer.valueOf(f66333g))).intValue();
        int i3 = f66331e;
        f66335i = (i3 / 10000) / 1000.0f;
        f66336j = (i3 % 10000) / 1000.0f;
        hd0.c.v("Q.qqstory.publish.QQStoryFlowCallback", "Update Limit Config %d|%d|%d|%d|%d|%d", Integer.valueOf(f66327a), Integer.valueOf(f66328b), Integer.valueOf(f66329c), Integer.valueOf(f66331e), Integer.valueOf(f66332f), Integer.valueOf(f66333g));
        hd0.c.v("Q.qqstory.publish.QQStoryFlowCallback", "Update Limit Config from %d to %d", Integer.valueOf(f66334h), Integer.valueOf(f16));
        f66334h = hVar.f();
        return true;
    }

    private static boolean d(Activity activity) {
        if (activity == null || activity.getIntent() == null) {
            return false;
        }
        return activity.getIntent().getBooleanExtra(AECameraConstants.KEY_FROM_PIC_CHOOSE, false);
    }

    public static boolean e(Activity activity, LocalMediaInfo localMediaInfo) {
        final QQToast makeText;
        boolean z16;
        int i3;
        int i16;
        String valueOf;
        if (localMediaInfo == null) {
            return false;
        }
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                mediaMetadataRetriever.setDataSource(localMediaInfo.path);
                localMediaInfo.mediaHeight = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
                localMediaInfo.mediaWidth = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
                localMediaInfo.rotation = Integer.parseInt(mediaMetadataRetriever.extractMetadata(24));
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    e16.printStackTrace();
                }
            }
            mediaMetadataRetriever.release();
            g();
            float f16 = (localMediaInfo.mediaHeight * 1.0f) / localMediaInfo.mediaWidth;
            if (localMediaInfo.mMimeType.contains("video")) {
                long j3 = localMediaInfo.mDuration;
                if (j3 > f66329c) {
                    makeText = QQToast.makeText(activity, 1, "\u6682\u4e0d\u652f\u6301\u9009\u62e9\u8d85\u8fc73\u5206\u949f\u7684\u89c6\u9891", 0);
                    hd0.c.k("Q.qqstory.publish.QQStoryFlowCallback", "checkQQStoryMediaValid media not valid! " + localMediaInfo.toString());
                    z16 = true;
                    i3 = 4;
                    i16 = 5;
                } else if (j3 < f66330d) {
                    makeText = QQToast.makeText(activity, 1, "\u8bf7\u9009\u62e9\u65f6\u957f\u5927\u4e8e2\u79d2\u7684\u89c6\u9891", 0);
                    hd0.c.k("Q.qqstory.publish.QQStoryFlowCallback", "checkQQStoryMediaValid media not valid! " + localMediaInfo.toString());
                    z16 = true;
                    i3 = 5;
                    i16 = 6;
                } else if (localMediaInfo.fileSize > f66327a) {
                    makeText = QQToast.makeText(activity, 1, HardCodeUtil.qqStr(R.string.r67), 0);
                    hd0.c.k("Q.qqstory.publish.QQStoryFlowCallback", "checkQQStoryMediaValid media not valid! " + localMediaInfo.toString());
                    z16 = true;
                    i3 = 1;
                    i16 = i3;
                } else if (Math.min(localMediaInfo.mediaHeight, localMediaInfo.mediaWidth) < f66328b) {
                    makeText = QQToast.makeText(activity, 1, HardCodeUtil.qqStr(R.string.r5v), 0);
                    hd0.c.k("Q.qqstory.publish.QQStoryFlowCallback", "checkQQStoryMediaValid media not valid! " + localMediaInfo.toString());
                    i16 = 3;
                    z16 = true;
                    i3 = 2;
                } else if (f16 >= 0.4f && f16 <= 2.2f) {
                    if (MediaFile.getMimeTypeForFile(localMediaInfo.path) == null || MediaFile.getMimeTypeForFile(localMediaInfo.path).contains("mp4")) {
                        i3 = 0;
                        z16 = true;
                        makeText = null;
                        i16 = 9999;
                    } else {
                        makeText = QQToast.makeText(activity, 1, HardCodeUtil.qqStr(R.string.r5m), 0);
                        hd0.c.k("Q.qqstory.publish.QQStoryFlowCallback", "checkQQStoryMediaValid media not valid! " + localMediaInfo.toString());
                        i16 = 8;
                        z16 = true;
                        i3 = 6;
                    }
                } else {
                    makeText = QQToast.makeText(activity, 1, HardCodeUtil.qqStr(R.string.f172483r60), 0);
                    hd0.c.k("Q.qqstory.publish.QQStoryFlowCallback", "checkQQStoryMediaValid media not valid! " + localMediaInfo.toString());
                    i3 = 3;
                    z16 = true;
                    i16 = 4;
                }
            } else if (localMediaInfo.fileSize > f66332f) {
                makeText = QQToast.makeText(activity, 1, HardCodeUtil.qqStr(R.string.f172485r62), 0);
                hd0.c.k("Q.qqstory.publish.QQStoryFlowCallback", "checkQQStoryMediaValid media not valid! " + localMediaInfo.toString());
                z16 = false;
                i3 = 1;
                i16 = i3;
            } else if (Math.min(localMediaInfo.mediaHeight, localMediaInfo.mediaWidth) < f66333g) {
                makeText = QQToast.makeText(activity, 1, HardCodeUtil.qqStr(R.string.f172484r61), 0);
                hd0.c.k("Q.qqstory.publish.QQStoryFlowCallback", "checkQQStoryMediaValid media not valid! " + localMediaInfo.toString());
                z16 = false;
                i16 = 3;
                i3 = 2;
            } else if (f16 < 0.4f || f16 > 2.2f) {
                makeText = QQToast.makeText(activity, 1, HardCodeUtil.qqStr(R.string.r5z), 0);
                hd0.c.k("Q.qqstory.publish.QQStoryFlowCallback", "checkQQStoryMediaValid media not valid! " + localMediaInfo.toString());
                z16 = false;
                i3 = 3;
                i16 = 4;
            } else {
                z16 = false;
                i3 = 0;
                makeText = null;
                i16 = 9999;
            }
            id0.a.k("upload_local_video", "choose_media_info", 0, i3, a(localMediaInfo));
            String[] strArr = new String[3];
            if (z16) {
                valueOf = String.valueOf(1);
            } else {
                valueOf = String.valueOf(0);
            }
            strArr[0] = valueOf;
            strArr[1] = String.valueOf(i16);
            strArr[2] = String.valueOf(f16);
            id0.a.n("video_shoot", "chose_video", 0, 0, strArr);
            if (z16 && localMediaInfo.mDuration >= 20500) {
                id0.a.n("video_shoot", "local_over", 0, 0, new String[0]);
            }
            if (localMediaInfo.addedDate == 0) {
                long lastModified = new File(localMediaInfo.path).lastModified() / 1000;
                localMediaInfo.addedDate = lastModified;
                id0.a.k("upload_local_video", "media_info_missing", 0, lastModified != 0 ? 0 : 1, a(localMediaInfo));
            }
            if (makeText != null) {
                activity.runOnUiThread(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.activity.richmedia.QQStoryFlowCallback.1
                    @Override // java.lang.Runnable
                    public void run() {
                        QQToast.this.show();
                    }
                });
            }
            return i3 == 0;
        } catch (Throwable th5) {
            mediaMetadataRetriever.release();
            throw th5;
        }
    }
}
