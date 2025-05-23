package com.tencent.aelight.camera.ae.flashshow.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.aelight.camera.pref.api.IPrefRecorder;
import com.tencent.aelight.camera.struct.camera.material.AEMaterialMetaData;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.wink.QQWinkActivity;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.editor.WinkEditorFragment;
import com.tencent.mobileqq.wink.editor.music.vo.WinkEditorMusicInfo;
import com.tencent.mobileqq.wink.model.AEDataToEditor;
import com.tencent.qphone.base.util.QLog;
import cooperation.peak.PeakConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes32.dex */
public class s {
    public static void b(Activity activity, int i3, LocalMediaInfo localMediaInfo, String str, String str2, String str3, String str4, String str5, AEMaterialMetaData aEMaterialMetaData, AEDataToEditor aEDataToEditor) {
        Intent intent = new Intent();
        intent.putExtras(activity.getIntent().getExtras());
        if (!gq.c.b()) {
            HashMap hashMap = new HashMap();
            hashMap.put("target", "4");
            intent.putExtra("key_attrs", hashMap);
            HashMap hashMap2 = new HashMap();
            hashMap2.put(localMediaInfo.path, localMediaInfo);
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(localMediaInfo.path);
            intent.putExtra(PeakConstants.QCIRCLE_CLIENT_TRACEID, activity.getIntent().getStringExtra(PeakConstants.QCIRCLE_CLIENT_TRACEID));
            intent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", arrayList);
            intent.putExtra("PeakConstants.selectedMediaInfoHashMap", hashMap2);
            com.tencent.mobileqq.wink.g.f322861a.m(activity, intent);
            return;
        }
        intent.putExtra(QQWinkConstants.INPUT_MEDIA, new ArrayList(Arrays.asList(localMediaInfo)));
        intent.putExtra(QQWinkConstants.IS_EDIT_TEXT, false);
        intent.putExtra(QQWinkConstants.IS_IMAGE_MODEL, false);
        intent.putExtra(QQWinkConstants.EDITOR_ENTRANCE, 1);
        intent.putExtra(QQWinkConstants.IS_FROM_CAPTURE, true);
        if (activity.getIntent() != null && activity.getIntent().getExtras() != null && activity.getIntent().getExtras().getSerializable("key_attrs") != null) {
            intent.putExtra("key_attrs", activity.getIntent().getExtras().getSerializable("key_attrs"));
            HashMap hashMap3 = (HashMap) activity.getIntent().getExtras().getSerializable("key_attrs");
            if (!TextUtils.isEmpty((CharSequence) hashMap3.get(QCircleScheme.AttrQQPublish.MUSIC_SCENE))) {
                try {
                    intent.putExtra(QQWinkConstants.PUBLISH_SCHEMA_MUSIC_SCENE, Integer.parseInt((String) hashMap3.get(QCircleScheme.AttrQQPublish.MUSIC_SCENE)));
                } catch (NumberFormatException e16) {
                    w53.b.c("startPhotoEdit", e16.toString());
                }
            }
            if (!TextUtils.isEmpty((CharSequence) hashMap3.get(QCircleScheme.AttrQQPublish.MUSIC_AUTHOR_UID))) {
                intent.putExtra(QQWinkConstants.PUBLISH_SCHEMA_MUSIC_AUTHOR_UID, (String) hashMap3.get(QCircleScheme.AttrQQPublish.MUSIC_AUTHOR_UID));
            }
            if (!TextUtils.isEmpty((CharSequence) hashMap3.get(QCircleScheme.AttrQQPublish.ENTER_FEED_ID))) {
                intent.putExtra(QQWinkConstants.PUBLISH_SCHEMA_ENTER_FEED_ID, (String) hashMap3.get(QCircleScheme.AttrQQPublish.ENTER_FEED_ID));
            }
            hashMap3.put("content", str4);
            a(hashMap3, intent);
        } else {
            HashMap hashMap4 = new HashMap();
            hashMap4.put("content", str4);
            intent.putExtra("key_attrs", hashMap4);
        }
        if (!TextUtils.isEmpty(str)) {
            intent.putExtra(QQWinkConstants.PUBLISH_SCHEMA_MUSIC_ID, str);
        }
        if (activity.getIntent() != null) {
            intent.putExtra(PeakConstants.QCIRCLE_CLIENT_TRACEID, activity.getIntent().getStringExtra(PeakConstants.QCIRCLE_CLIENT_TRACEID));
        }
        if (str2 != null) {
            intent.putExtra(QQWinkConstants.CAPTURE_MATERIAL_ID, str2);
            intent.putExtra(QQWinkConstants.CAPTURE_MATERIAL_TOPIC, str3);
            QLog.i("CircleTakeSame", 1, String.format("photo---materialId=%s, topic=%s", str2, str3));
        }
        if (str5 != null) {
            intent.putExtra(QQWinkConstants.CAPTURE_MATERIAL_NAME, str5);
        }
        if (aEMaterialMetaData != null) {
            String str6 = aEMaterialMetaData.score;
            if (str6 != null && !TextUtils.isEmpty(str6)) {
                intent.putExtra(QQWinkConstants.CAPTURE_MATERIAL_SCORE, aEMaterialMetaData.score);
            }
            intent.putExtra(QQWinkConstants.CAPTURE_MATERIAL, aEMaterialMetaData);
        }
        if (aEDataToEditor != null) {
            intent.putExtra(QQWinkConstants.CAPTURE_AE_TO_EDITOR, aEDataToEditor);
        }
        intent.putExtra("ae_editor_video_flag", false);
        intent.putExtra("public_fragment_class", WinkEditorFragment.class.getName());
        mq.a.d().k(IPrefRecorder.MILESTONE_CAMERA_SHOOT_JUMP_FLASH);
        intent.setClass(activity, QQWinkActivity.class);
        activity.startActivityForResult(intent, i3);
    }

    public static void c(Activity activity, int i3, LocalMediaInfo localMediaInfo, WinkEditorMusicInfo winkEditorMusicInfo, Integer num, Float f16, String str, String str2, String str3, String str4, AEMaterialMetaData aEMaterialMetaData, AEDataToEditor aEDataToEditor) {
        if (activity == null) {
            QLog.i("PostEditLaunchUtil", 1, "activity is null");
            return;
        }
        Intent intent = new Intent();
        intent.putExtras(activity.getIntent().getExtras());
        if (!gq.c.b()) {
            HashMap hashMap = new HashMap();
            hashMap.put("target", "4");
            intent.putExtra("key_attrs", hashMap);
            HashMap hashMap2 = new HashMap();
            String str5 = "multi_video_" + System.currentTimeMillis();
            localMediaInfo.missionID = str5;
            hashMap2.put(localMediaInfo.path, localMediaInfo);
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(localMediaInfo.path);
            intent.putExtra(PeakConstants.QCIRCLE_CLIENT_TRACEID, activity.getIntent().getStringExtra(PeakConstants.QCIRCLE_CLIENT_TRACEID));
            intent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", arrayList);
            intent.putExtra("PeakConstants.selectedMediaInfoHashMap", hashMap2);
            intent.putExtra("ae_editor_video_flag", true);
            intent.putExtra("ae_editor_video_export_size_height", 3000);
            intent.putExtra("ae_editor_video_export_size_width", 3000);
            intent.putExtra(QQWinkConstants.MISSION_ID, str5);
            com.tencent.mobileqq.wink.g.f322861a.m(activity, intent);
            return;
        }
        intent.putExtra(QQWinkConstants.INPUT_MEDIA, new ArrayList(Arrays.asList(localMediaInfo)));
        intent.putExtra(QQWinkConstants.IS_EDIT_TEXT, false);
        intent.putExtra(QQWinkConstants.IS_IMAGE_MODEL, false);
        intent.putExtra(QQWinkConstants.MUSIC_INFO, winkEditorMusicInfo);
        intent.putExtra(QQWinkConstants.MUSIC_VOLUME, f16);
        if (activity.getIntent() != null && activity.getIntent().getExtras() != null) {
            if (activity.getIntent().getExtras().getSerializable("key_attrs") != null) {
                intent.putExtra("key_attrs", activity.getIntent().getExtras().getSerializable("key_attrs"));
                HashMap hashMap3 = (HashMap) intent.getSerializableExtra("key_attrs");
                hashMap3.put("content", str3);
                a(hashMap3, intent);
            } else {
                HashMap hashMap4 = new HashMap();
                hashMap4.put("content", str3);
                intent.putExtra("key_attrs", hashMap4);
            }
            if (activity.getIntent().getExtras().getString(PeakConstants.QCIRCLE_CLIENT_TRACEID) != null) {
                intent.putExtra(PeakConstants.QCIRCLE_CLIENT_TRACEID, activity.getIntent().getExtras().getString(PeakConstants.QCIRCLE_CLIENT_TRACEID));
            }
            intent.putExtra("AECAMERA_TAB_ALBUM_ENTRANCE", activity.getIntent().getBooleanExtra("AECAMERA_TAB_ALBUM_ENTRANCE", true));
        }
        if (num != null) {
            intent.putExtra(QQWinkConstants.MUSIC_START_TIME, num.intValue());
        }
        if (str != null) {
            intent.putExtra(QQWinkConstants.CAPTURE_MATERIAL_ID, str);
            intent.putExtra(QQWinkConstants.CAPTURE_MATERIAL_TOPIC, str2);
        }
        if (str4 != null) {
            intent.putExtra(QQWinkConstants.CAPTURE_MATERIAL_NAME, str4);
        }
        if (aEMaterialMetaData != null) {
            String str6 = aEMaterialMetaData.score;
            if (str6 != null && !TextUtils.isEmpty(str6)) {
                intent.putExtra(QQWinkConstants.CAPTURE_MATERIAL_SCORE, aEMaterialMetaData.score);
            }
            intent.putExtra(QQWinkConstants.CAPTURE_MATERIAL, aEMaterialMetaData);
        }
        if (aEDataToEditor != null) {
            intent.putExtra(QQWinkConstants.CAPTURE_AE_TO_EDITOR, aEDataToEditor);
        }
        intent.putExtra(QQWinkConstants.EDITOR_ENTRANCE, 1);
        intent.putExtra(QQWinkConstants.IS_FROM_CAPTURE, true);
        intent.putExtra("ae_editor_video_flag", true);
        intent.putExtra("public_fragment_class", WinkEditorFragment.class.getName());
        intent.setClass(activity, QQWinkActivity.class);
        mq.a.d().k(IPrefRecorder.MILESTONE_CAMERA_RECORD_JUMP_FLASH);
        activity.startActivityForResult(intent, i3);
    }

    public static void d(Context context, Bundle bundle) {
        Intent intent = new Intent();
        intent.putExtras(bundle);
        intent.putExtra("ae_editor_video_flag", true);
        intent.putExtra("public_fragment_class", WinkEditorFragment.class.getName());
        intent.setClass(context, QQWinkActivity.class);
        if (!(context instanceof Activity) && Build.VERSION.SDK_INT < 24) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    private static void a(HashMap<String, String> hashMap, Intent intent) {
        if (hashMap == null || !QQWinkConstants.QCIRCLE_FROM_QZONE.equals(hashMap.get("from"))) {
            return;
        }
        intent.putExtra(QQWinkConstants.IS_TO_TEMPLATE_TAB, true);
    }
}
