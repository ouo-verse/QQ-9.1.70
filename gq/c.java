package gq;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.tencent.aelight.camera.ae.d;
import com.tencent.aelight.camera.ae.download.AEResUtil;
import com.tencent.aelight.camera.ae.flashshow.AEFlashShowCameraLauncher;
import com.tencent.aelight.camera.ae.flashshow.util.f;
import com.tencent.aelight.camera.aebase.AECameraPlugin;
import com.tencent.aelight.camera.aebase.QIMCameraCaptureActivity;
import com.tencent.aelight.camera.api.IAELaunchRecorder;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.download.api.IAEMultiDownloadCallBack;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.biz.qqstory.takevideo2.StoryPublishLauncher;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.VideoEnvironment64BitUtils;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.utils.t;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes38.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static long f403053a;

    private static void a(Context context, Bundle bundle) {
        String string;
        Activity activity = (Activity) context;
        activity.overridePendingTransition(R.anim.f154958fh, R.anim.f154550b4);
        if (bundle.containsKey("taskid") && (string = bundle.getString("taskid", "")) != null && t.f326727a.b(string)) {
            activity.overridePendingTransition(R.anim.f154427o, R.anim.l_);
        }
    }

    public static boolean b() {
        return e(QQWinkConstants.ENTRY_QQ_OTHER, true);
    }

    public static boolean c(IAEMultiDownloadCallBack iAEMultiDownloadCallBack) {
        return f(QQWinkConstants.ENTRY_QQ_OTHER, true, iAEMultiDownloadCallBack);
    }

    public static boolean e(String str, boolean z16) {
        VideoEnvironment64BitUtils.checkIs64bit();
        return n(z16, str);
    }

    public static boolean f(String str, boolean z16, IAEMultiDownloadCallBack iAEMultiDownloadCallBack) {
        VideoEnvironment64BitUtils.checkIs64bit();
        return o(z16, str, iAEMultiDownloadCallBack);
    }

    private static boolean g() {
        long currentTimeMillis = System.currentTimeMillis();
        QLog.d("AECameraLauncher", 2, "pre: " + f403053a + " cur: " + currentTimeMillis);
        if (Math.abs(currentTimeMillis - f403053a) < 500) {
            QLog.d("AECameraLauncher", 2, "isFastClick.");
            f403053a = currentTimeMillis;
            return true;
        }
        f403053a = currentTimeMillis;
        return false;
    }

    public static boolean i(String str, boolean z16) {
        VideoEnvironment64BitUtils.checkIs64bit();
        return j(str, z16);
    }

    private static boolean j(String str, boolean z16) {
        boolean z17 = AEResUtil.W(AEResInfo.LIGHT_RES_BASE_PACKAGE.agentType, str) && AEResUtil.W(AEResInfo.LIGHT_RES_FILAMENT.agentType, str) && AEResUtil.W(AEResInfo.LIGHT_RES_PAG.agentType, str);
        ms.a.f("AECameraLauncher", "[sResReady] aeBaseRes + lightBaseRes soIsExist:" + z17);
        if (!z16 ? !(z17 && d.l()) : !(z17 && d.j())) {
            return true;
        }
        AEResUtil.q0();
        ms.a.c("AECameraLauncher", "[isResReady] error soIsExist:false");
        if (z16) {
            AEResUtil.h(AEResInfo.AGENT_TYPE_AE_BASE_RES);
        }
        return false;
    }

    private static boolean l(Bundle bundle) {
        return bundle.getInt(AECameraConstants.AECAMERA_MODE) == 208;
    }

    private static boolean m(Bundle bundle) {
        return !(gm2.a.c() || bundle.getInt("VIDEO_STORY_JUMP_TO_TYPE", 0) == 0) || (bundle.getInt(AECameraConstants.AECAMERA_MODE) == 202 && f.a()) || (bundle.getInt(AECameraConstants.AECAMERA_MODE) == 203 && f.a());
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00b1 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean o(boolean z16, String str, IAEMultiDownloadCallBack iAEMultiDownloadCallBack) {
        boolean z17;
        IAEResUtil iAEResUtil = (IAEResUtil) QRoute.api(IAEResUtil.class);
        AEResInfo aEResInfo = AEResInfo.AE_RES_BASE_PACKAGE;
        int aEResStatus = iAEResUtil.getAEResStatus(aEResInfo.agentType, str);
        if (aEResStatus != 2) {
            int aEResStatus2 = ((IAEResUtil) QRoute.api(IAEResUtil.class)).getAEResStatus(AEResInfo.LIGHT_RES_BASE_PACKAGE.agentType, str);
            if (aEResStatus2 != 2) {
                int aEResStatus3 = ((IAEResUtil) QRoute.api(IAEResUtil.class)).getAEResStatus(AEResInfo.LIGHT_RES_FILAMENT.agentType, str);
                if (aEResStatus3 != 2) {
                    int aEResStatus4 = ((IAEResUtil) QRoute.api(IAEResUtil.class)).getAEResStatus(AEResInfo.LIGHT_RES_PAG.agentType, str);
                    if (aEResStatus4 != 2) {
                        z17 = true;
                        ms.a.f("AECameraLauncher", "[isResReady] aeBaseRes + lightBaseRes soIsExist:" + z17);
                        if (z16) {
                            z17 = z17 && d.l();
                            ms.a.c("AECameraLauncher", "[isResReady] isLoadLightSdk soIsExist:" + z17);
                        }
                        if (!z17) {
                            return true;
                        }
                        if (iAEMultiDownloadCallBack == null) {
                            AEResUtil.q0();
                            AEResUtil.h(aEResInfo.agentType);
                        } else {
                            AEResUtil.s0(iAEMultiDownloadCallBack);
                        }
                        ms.a.c("AECameraLauncher", "[isResReady] error soIsExist:false");
                        return false;
                    }
                }
            }
        }
        z17 = false;
        ms.a.f("AECameraLauncher", "[isResReady] aeBaseRes + lightBaseRes soIsExist:" + z17);
        if (z16) {
        }
        if (!z17) {
        }
    }

    public static void p(Activity activity, int i3, Bundle bundle) {
        if (g()) {
            return;
        }
        tq.b.h().o(IAELaunchRecorder.MILESTONE_LAUNCHER_BEGIN);
        StoryPublishLauncher d16 = StoryPublishLauncher.d();
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putInt("entrance_type", i3);
        bundle.putInt("edit_video_type", 10023);
        bundle.putInt(AECameraConstants.CAPTURE_INTENT_MODE, 8);
        if (m(bundle)) {
            ms.a.f("AECameraLauncher", "isOpenFrontFirst: true");
            gm2.a.d(1);
        }
        if (l(bundle)) {
            ms.a.f("AECameraLauncher", "isOpenBackFirst: true");
            gm2.a.d(2);
        }
        gm2.a.e();
        d16.k(activity, bundle, 20000);
        activity.overridePendingTransition(R.anim.f154958fh, R.anim.f154550b4);
        id0.a.n("video_shoot", "clk_shoot", 0, 0, new String[0]);
        tq.b.h().o(IAELaunchRecorder.MILESTONE_LAUNCHER_END);
        tq.b.h().s(false);
        tq.b.h().e();
    }

    public static void q(Context context, Bundle bundle) {
        if (g()) {
            return;
        }
        StoryPublishLauncher d16 = StoryPublishLauncher.d();
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putInt("edit_video_type", 10023);
        bundle.putInt(AECameraConstants.CAPTURE_INTENT_MODE, 8);
        if (m(bundle)) {
            ms.a.f("AECameraLauncher", "isOpenFrontFirst: true");
            gm2.a.d(1);
        }
        if (l(bundle)) {
            ms.a.f("AECameraLauncher", "isOpenBackFirst: true");
            gm2.a.d(2);
        }
        d16.i(context, bundle);
        id0.a.n("video_shoot", "clk_shoot", 0, 0, new String[0]);
    }

    public static void r(Context context, Bundle bundle) {
        if (context instanceof Activity) {
            AEFlashShowCameraLauncher.i().x(context, bundle, bundle.getInt(QQWinkConstants.ACTIVITY_REQUEST_CODE, 0));
            a(context, bundle);
            return;
        }
        AEFlashShowCameraLauncher.i().x(context, bundle, 0);
    }

    public static void s(Activity activity, int i3, int i16, AECameraPlugin.e eVar) {
        if (g()) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt(AECameraConstants.VIDEO_STORY_FROM_TYPE, i16);
        bundle.putInt(AECameraConstants.AECAMERA_MODE, 200);
        bundle.putInt("ability_flag", 2);
        bundle.putInt("edit_video_type", 10023);
        if (eVar != null) {
            bundle.putBoolean(AECameraConstants.KEY_CAMERA_PREFER_BACK, eVar.f65993d);
            bundle.putBoolean(AECameraConstants.KEY_HAS_COUNTDOWN, eVar.f65995f);
            bundle.putBoolean(AECameraConstants.KEY_DISABLE_FACE_DETECT, eVar.f65997h);
            bundle.putBoolean(AECameraConstants.KEY_NEED_CHECK_SENSITIVE, eVar.f65996g);
            bundle.putString(AECameraConstants.KEY_GUIDE_IMAGE, eVar.f65994e);
        }
        QIMCameraCaptureActivity.D0(activity, bundle, i3);
        activity.overridePendingTransition(R.anim.f154958fh, R.anim.f154550b4);
    }

    public static boolean d(String str) {
        return e(str, true);
    }

    private static boolean n(boolean z16, String str) {
        return o(z16, str, null);
    }

    public static boolean h() {
        return i(null, false);
    }

    public static boolean k(Bundle bundle) {
        return bundle != null && bundle.getBoolean("flag_clear_top");
    }

    public static void t(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putBoolean("flag_clear_top", true);
    }
}
