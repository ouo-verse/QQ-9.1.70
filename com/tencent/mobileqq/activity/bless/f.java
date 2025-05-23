package com.tencent.mobileqq.activity.bless;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.aelight.camera.api.IQIMWebEffectUnit;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.aelight.camera.util.api.ICaptureUtil;
import com.tencent.biz.qqstory.storyHome.StoryTransitionActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ISelectMemberActivityConstants;
import com.tencent.mobileqq.selectmember.api.ISelectMemberApi;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes10.dex */
public class f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static String f180589a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(67747);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f180589a = "BlessJsApiUtils";
        }
    }

    public static boolean a(AppInterface appInterface) {
        boolean supportShortVideoRecordAndPlay = VideoEnvironment.supportShortVideoRecordAndPlay();
        if (!supportShortVideoRecordAndPlay && QLog.isColorLevel()) {
            QLog.d(f180589a, 2, "isMobileSupportPTV false");
        }
        return supportShortVideoRecordAndPlay;
    }

    public static boolean b(AppInterface appInterface) {
        boolean m3 = com.tencent.mobileqq.shortvideo.util.f.m();
        if (!m3 && QLog.isColorLevel()) {
            QLog.d(f180589a, 2, "isSupportFilterSo false");
        }
        return m3;
    }

    public static boolean c(AppInterface appInterface) {
        if (appInterface.getCurrentAccountUin() == null) {
            if (QLog.isColorLevel()) {
                QLog.i(f180589a, 2, "isAccLoginSuccess false.");
            }
            return false;
        }
        if (!a(appInterface)) {
            return false;
        }
        if (((IAEResUtil) QRoute.api(IAEResUtil.class)).isLightCameraBaseResNotAllExist()) {
            if (QLog.isColorLevel()) {
                QLog.d(f180589a, 2, "PtvFilterSoLoad getFilterSoState is false");
            }
            return false;
        }
        if (!((ICaptureUtil) QRoute.api(ICaptureUtil.class)).supportCapture()) {
            return false;
        }
        return VideoEnvironment.checkAndLoadAVCodec();
    }

    public static void d(Activity activity, String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str.trim())) {
            Intent intent = new Intent();
            intent.putExtra("param_type", 9003);
            intent.putExtra(ISelectMemberActivityConstants.PARAM_ENTRANCE, 15);
            intent.putExtra(ISelectMemberActivityConstants.PARAM_ONLY_FRIENDS, true);
            intent.putExtra(ISelectMemberActivityConstants.PARAM_DONOT_NEED_CONTACTS, true);
            intent.putExtra(ISelectMemberActivityConstants.PARAM_TITLE, activity.getString(R.string.f170612vu));
            intent.putExtra(ISelectMemberActivityConstants.PARAM_DONE_BUTTON_WORDING, activity.getString(R.string.a8j));
            intent.putExtra(ISelectMemberActivityConstants.PARAM_EXIT_ANIMATION, 1);
            intent.putExtra(ISelectMemberActivityConstants.PARAM_BLESSTYPE, 1);
            intent.putExtra(ISelectMemberActivityConstants.PARAM_BLESSWORD_CONTENT, str);
            intent.putExtra(ISelectMemberActivityConstants.PARAM_WEB_CALLBACK, str2);
            ((ISelectMemberApi) QRoute.api(ISelectMemberApi.class)).startBlessSelectMemberActivity(activity, intent);
            activity.overridePendingTransition(R.anim.activity_new, R.anim.activity_out);
            return;
        }
        QQToast.makeText(activity, R.string.f170606vd, 1).show();
    }

    public static boolean e(Activity activity, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        String str9;
        int i3;
        if (QLog.isColorLevel()) {
            QLog.i(f180589a, 2, "startBlessPtvActivity , supportVideo:" + str + ", supportPhoto:" + str2 + ", cameraMode:" + str3 + ", unfoldDDStr:" + str5 + ", dDItemID:" + str6 + ", callback:" + str8);
        }
        boolean equals = "1".equals(str);
        boolean equals2 = "1".equals(str2);
        if ("1".equals(str3)) {
            str9 = str4;
            i3 = 2;
        } else {
            str9 = str4;
            i3 = 1;
        }
        boolean equals3 = "1".equals(str9);
        boolean equals4 = "1".equals(str7);
        boolean equals5 = "1".equals(str5);
        if (!((ICaptureUtil) QRoute.api(ICaptureUtil.class)).supportCapture()) {
            if (QLog.isColorLevel()) {
                QLog.i(f180589a, 2, "supportMediaCodec = false");
            }
            QQToast.makeText(activity, activity.getString(R.string.f170610vr), 0).show();
            return false;
        }
        Bundle generateArgs = ((IQIMWebEffectUnit) QRoute.api(IQIMWebEffectUnit.class)).generateArgs(equals, equals2, i3, true, equals3, equals5, str6, equals4, 107);
        Intent intent = new Intent(activity, (Class<?>) StoryTransitionActivity.class);
        intent.putExtras(generateArgs);
        intent.putExtra("jump_action", 7);
        activity.startActivity(intent);
        return true;
    }
}
