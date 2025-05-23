package com.tencent.aelight.camera.aebase;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.aelight.camera.aioeditor.shortvideo.util.PtvFilterUtils;
import com.tencent.aelight.camera.aioeditor.takevideo.publish.VideoSendPublicParam;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.aelight.camera.struct.editor.PublishParam;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.guild.temp.api.IGuildActivityApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.scaleaio.api.IScaleAIOActivityApi;
import cooperation.peak.PeakConstants;
import java.io.File;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes32.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    public static String f66039a = "ShortVideoProcessUtil";

    private static Bundle a(Intent intent) {
        Bundle bundle = new Bundle();
        bundle.putString("dynamic_text", intent.getStringExtra("dynamic_text"));
        String stringExtra = intent.getStringExtra(PeakConstants.KEY_QQ_CAMERA_VIDEOPARAM);
        String stringExtra2 = intent.getStringExtra(PeakConstants.KEY_QQ_CAMERA_MATERIAL_NAME);
        if (!TextUtils.isEmpty(stringExtra)) {
            bundle.putString(PeakConstants.KEY_QQ_CAMERA_VIDEOPARAM, stringExtra);
            if (!TextUtils.isEmpty(stringExtra2)) {
                bundle.putString(PeakConstants.KEY_QQ_CAMERA_MATERIAL_NAME, stringExtra2);
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(f66039a, 2, "getBundle templateId:" + stringExtra + ", name:" + stringExtra2);
        }
        return bundle;
    }

    public static void d(Activity activity, SessionInfo sessionInfo, PublishParam publishParam, Bundle bundle, qs.c cVar, String str, int i3, ArrayList<String> arrayList, boolean z16, String str2, boolean z17) {
        String str3;
        String str4;
        int i16;
        VideoSendPublicParam videoSendPublicParam = new VideoSendPublicParam();
        videoSendPublicParam.mContext = activity;
        videoSendPublicParam.mVideoCacheDir = new File(publishParam.P).getParent();
        int i17 = publishParam.I;
        if (i17 > 5) {
            i17 = 0;
        }
        videoSendPublicParam.mEncodeMode = i17;
        videoSendPublicParam.mVideoFilePath = publishParam.P;
        videoSendPublicParam.mThumbFilePath = publishParam.f69067e;
        videoSendPublicParam.mThumbWidth = 0;
        videoSendPublicParam.mThumbHeight = 0;
        videoSendPublicParam.fakeVid = publishParam.f69066d;
        videoSendPublicParam.mUserCallBack = cVar;
        videoSendPublicParam.mContent = str;
        videoSendPublicParam.mPriv = i3;
        videoSendPublicParam.mPrivUinList = arrayList;
        videoSendPublicParam.mEnableEditVideo = z16;
        videoSendPublicParam.topicId = str2;
        videoSendPublicParam.topicSyncQzone = z17;
        videoSendPublicParam.templateId = bundle.getString(PeakConstants.KEY_QQ_CAMERA_VIDEOPARAM);
        videoSendPublicParam.templateName = bundle.getString(PeakConstants.KEY_QQ_CAMERA_MATERIAL_NAME);
        if (sessionInfo != null) {
            str3 = sessionInfo.f179557e;
            i16 = sessionInfo.f179555d;
            str4 = sessionInfo.f179559f;
        } else {
            str3 = "";
            str4 = "";
            i16 = 0;
        }
        videoSendPublicParam.mUin = str3;
        videoSendPublicParam.mUinType = i16;
        videoSendPublicParam.mTroopUin = str4;
        new com.tencent.aelight.camera.aioeditor.c(videoSendPublicParam).execute(new Void[0]);
    }

    public static void c(Activity activity, SessionInfo sessionInfo, PublishParam publishParam, Bundle bundle) {
        d(activity, sessionInfo, publishParam, bundle, null, "", 1, null, false, "", false);
    }

    public static void b(Activity activity, Intent intent, or.d dVar) {
        if (activity != null && intent != null && dVar != null) {
            activity.getIntent().putExtra("forward_source_from_shoot_quick", true);
            PublishParam publishParam = (PublishParam) intent.getParcelableExtra(PublishParam.Z);
            if (publishParam == null || publishParam.N != 1) {
                return;
            }
            String str = publishParam.f69067e;
            activity.getIntent().putExtra("ab_test_send_btn_click_time", SystemClock.uptimeMillis());
            if (QLog.isColorLevel()) {
                QLog.d(f66039a, 2, "hwEncodeVideo videoMergeThumbPath =" + str);
                QLog.d(f66039a, 2, "publishParam =" + publishParam.toString());
            }
            PtvFilterUtils.a(new File(publishParam.P).getParent(), publishParam.f69066d);
            Bundle a16 = a(intent);
            SessionInfo sessionInfo = (SessionInfo) intent.getParcelableExtra(PeakConstants.SEND_SESSION_INFO);
            boolean booleanExtra = intent.getBooleanExtra("gotoAIO", false);
            String stringExtra = intent.getStringExtra(AECameraConstants.ARG_AIO_CLASS);
            if (sessionInfo != null && booleanExtra) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(publishParam.P);
                Intent intent2 = new Intent();
                if (QPublicTransFragmentActivity.class.getName().equals(stringExtra)) {
                    intent2.setClassName("com.tencent.mobileqq", stringExtra);
                    intent2.addFlags(603979776);
                } else if (ChatActivity.class.getName().equals(stringExtra)) {
                    intent2.setClassName("com.tencent.mobileqq", stringExtra);
                    intent2.addFlags(603979776);
                } else if (((IScaleAIOActivityApi) QRoute.api(IScaleAIOActivityApi.class)).getScaleAIOActivityClassName().equals(stringExtra)) {
                    intent2.setClassName("com.tencent.mobileqq", stringExtra);
                    intent2.addFlags(603979776);
                } else {
                    intent2 = BaseAIOUtils.m(SplashActivity.getAliasIntent(activity), new int[]{2});
                }
                intent2.putExtra("uinname", sessionInfo.f179563i);
                intent2.putExtra("uin", sessionInfo.f179557e);
                intent2.putExtra("uintype", sessionInfo.f179555d);
                intent2.putExtra("troop_uin", sessionInfo.f179559f);
                intent2.putExtra(PeakConstants.SEND_FLAG, true);
                intent2.putExtra("PhotoConst.PHOTO_PATHS", arrayList);
                if (!TextUtils.isEmpty(publishParam.f69067e)) {
                    intent2.putExtra(PeakConstants.VIDEO_THUMBNAIL_PATH, publishParam.f69067e);
                }
                if (sessionInfo.f179555d == 10014) {
                    Intent intent3 = (Intent) activity.getIntent().getParcelableExtra(PeakConstants.GUILD_OPEN_AIO_INTENT);
                    if (intent3 != null) {
                        intent3.putExtras(intent2);
                        if (intent3.getBooleanExtra("isSplitViewMode", false)) {
                            ((IGuildActivityApi) QRoute.api(IGuildActivityApi.class)).launchGuildChatPieInSplitMode(activity, intent3);
                            return;
                        } else {
                            activity.startActivity(intent3);
                            return;
                        }
                    }
                    return;
                }
                activity.startActivity(intent2);
                return;
            }
            d(activity, sessionInfo, publishParam, a16, null, "", 1, null, false, "", false);
            if (intent.getBooleanExtra(ShortVideoConstants.SHORT_VIDEO_MULTI_SHARE, false)) {
                lr.a.f(activity, intent.getBooleanExtra(ShortVideoConstants.QUICK_SHOOT_JUMP_STORY, true), dVar);
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(f66039a, 2, "handleVideoFromEditVideoActivity params are wrong");
        }
    }
}
