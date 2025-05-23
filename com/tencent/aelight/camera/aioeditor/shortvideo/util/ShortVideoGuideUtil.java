package com.tencent.aelight.camera.aioeditor.shortvideo.util;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.aelight.camera.api.IQIMWebEffectUnit;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.aelight.camera.util.api.ICaptureUtil;
import com.tencent.biz.qqstory.storyHome.StoryTransitionActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.util.f;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes32.dex */
public class ShortVideoGuideUtil {

    /* renamed from: a, reason: collision with root package name */
    public static String f67605a = "ShortVideoGuideUtil";

    public static boolean a() {
        if (VideoEnvironment.getShortVideoSoLibName() == null) {
            return false;
        }
        if (!ShortVideoUtils.isVideoSoLibLoaded()) {
            if (!ShortVideoUtils.checkShortVideoSoReadyToLoad()) {
                return false;
            }
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.shortvideo.util.ShortVideoGuideUtil.1
                @Override // java.lang.Runnable
                public void run() {
                    VideoEnvironment.loadAVCodecSo();
                }
            }, 64, null, false);
        }
        return (((IAEResUtil) QRoute.api(IAEResUtil.class)).isLightCameraBaseResNotAllExist() || !com.tencent.mobileqq.shortvideo.gesture.a.c().b() || f.f() == 2) ? false : true;
    }

    public static boolean b(AppInterface appInterface) {
        if (VideoEnvironment.getShortVideoSoLibName() == null) {
            return false;
        }
        if (ShortVideoUtils.isVideoSoLibLoaded()) {
            return true;
        }
        VideoEnvironment.loadAVCodecSo();
        return ShortVideoUtils.isVideoSoLibLoaded();
    }

    public static boolean c(Activity activity, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i3) {
        if (QLog.isColorLevel()) {
            QLog.i(f67605a, 2, "startPTVActivity , supportVideo:" + str + ", supportPhoto:" + str2 + ", cameraMode:" + str3 + ", beauty:" + str4 + ", unfoldDDStr:" + str6 + ", dDItemID:" + str7 + ", entranceType=" + i3);
        }
        boolean equals = "1".equals(str);
        boolean equals2 = "1".equals(str2);
        int i16 = "1".equals(str3) ? 2 : 1;
        boolean equals3 = "1".equals(str4);
        boolean equals4 = "1".equals(str5);
        boolean equals5 = "1".equals(str8);
        boolean equals6 = "1".equals(str6);
        if (!((ICaptureUtil) QRoute.api(ICaptureUtil.class)).supportCapture()) {
            if (!QLog.isColorLevel()) {
                return false;
            }
            QLog.i(f67605a, 2, "supportMediaCodec = false");
            return false;
        }
        Bundle generateArgs = ((IQIMWebEffectUnit) QRoute.api(IQIMWebEffectUnit.class)).generateArgs(equals, equals2, i16, equals3, equals4, equals6, str7, equals5, i3);
        Intent intent = new Intent(activity, (Class<?>) StoryTransitionActivity.class);
        intent.putExtras(generateArgs);
        intent.putExtra("jump_action", 7);
        activity.startActivity(intent);
        return true;
    }
}
