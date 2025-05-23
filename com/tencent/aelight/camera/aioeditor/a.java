package com.tencent.aelight.camera.aioeditor;

import android.app.Activity;
import android.content.Intent;
import android.preference.PreferenceManager;
import com.tencent.aelight.camera.aioeditor.takevideo.EditPicActivity;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.shortvideo.SendVideoActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.peak.PeakConstants;
import java.io.File;

/* compiled from: P */
/* loaded from: classes32.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static long f66321a;

    /* renamed from: b, reason: collision with root package name */
    public static long f66322b;

    /* renamed from: c, reason: collision with root package name */
    public static long f66323c;

    /* renamed from: d, reason: collision with root package name */
    public static long f66324d;

    /* renamed from: e, reason: collision with root package name */
    public static long f66325e;

    /* renamed from: f, reason: collision with root package name */
    public static long f66326f;

    public static int a(int i3) {
        if (i3 == 0) {
            return 11;
        }
        if (i3 != 1) {
            if (i3 != 3000) {
                return 11;
            }
            return 10;
        }
        return 9;
    }

    public static void b(QQAppInterface qQAppInterface, Activity activity, Intent intent, SessionInfo sessionInfo, int i3, int i16) {
        if (i16 == 1) {
            String string = PreferenceManager.getDefaultSharedPreferences(activity).getString(AppConstants.Preferences.CAMERA_PHOTO_PATH, "");
            if ("".equals(string)) {
                QLog.d("AIOShortVideoUtil", 1, "camera result null");
                return;
            }
            if (sessionInfo.f179555d == 9501) {
                ChatActivityUtils.u(qQAppInterface, activity, sessionInfo, 1, intent, 1);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("AIOShortVideoUtil", 2, "on camera result " + i3);
            }
            activity.getIntent().removeExtra(PeakConstants.PHOTO_SELECT_ACTIVITY_CLASS_NAME);
            Intent startEditPic = EditPicActivity.startEditPic(activity, string, true, true, true, true, false, 2, sessionInfo.f179555d == 1000 ? 1000 : 99, 1);
            startEditPic.putExtra("qq_sub_business_id", 109);
            BaseAIOUtils.m(startEditPic, null);
            startEditPic.putExtra("camera_type", i3);
            startEditPic.putExtra("key_activity_code", ChatActivityUtils.p(activity));
            startEditPic.putExtra(AECameraConstants.KEY_EDITPIC_CAMERATYPE, 3);
            activity.startActivity(startEditPic);
            return;
        }
        Intent intent2 = new Intent(activity, (Class<?>) SendVideoActivity.class);
        String string2 = PreferenceManager.getDefaultSharedPreferences(activity).getString(AppConstants.Preferences.CAMERA_PHOTO_PATH, "");
        intent2.putExtra("file_send_path", string2);
        intent2.putExtra(ShortVideoConstants.FILE_SEND_SIZE, new File(string2).length());
        intent2.putExtra(ShortVideoConstants.FILE_SEND_DURATION, ShortVideoUtils.getDuration(string2));
        intent2.putExtra("uin", sessionInfo.f179557e);
        intent2.putExtra("uintype", sessionInfo.f179555d);
        intent2.putExtra(ShortVideoConstants.FILE_SOURCE, "camera");
        intent2.putExtra(ShortVideoConstants.START_INIT_ACTIVITY_AFTER_SENDED, false);
        activity.startActivity(intent2);
    }
}
