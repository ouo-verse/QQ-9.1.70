package com.tencent.biz.qqstory.takevideo2;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.AndroidRuntimeException;
import android.view.WindowManager;
import com.tencent.aelight.camera.api.IAEClassManager;
import com.tencent.aelight.camera.api.ICaptureQmcfSoDownloadLaunch;
import com.tencent.aelight.camera.api.IQIMCameraCapture;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.aelight.camera.entry.api.IAECameraLauncher;
import com.tencent.aelight.camera.qqstory.api.IShortVideoGuideUtil;
import com.tencent.aelight.camera.util.api.ICaptureUtil;
import com.tencent.avbiz.AVBizModuleFactory;
import com.tencent.avbiz.Constants;
import com.tencent.avbiz.IModule;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.util.f;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ae.current.SessionWrap;
import hd0.c;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import mqq.app.AppRuntime;

/* loaded from: classes5.dex */
public class StoryPublishLauncher {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a extends DialogUtil.DialogOnClickAdapter {
        a() {
        }

        @Override // com.tencent.mobileqq.utils.DialogUtil.DialogOnClickAdapter, android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
        }
    }

    StoryPublishLauncher() {
    }

    private boolean a(Context context) {
        if (!((ICaptureUtil) QRoute.api(ICaptureUtil.class)).supportCapture()) {
            c.a("Q.qqstory.publish.StoryPublishLauncher", "checkApiVersionDialog false");
            try {
                if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
                    return true;
                }
                DialogUtil.createCustomDialog(context, 230).setMessage(HardCodeUtil.qqStr(R.string.tut)).setPositiveButton(R.string.f171151ok, new a()).show();
                return true;
            } catch (WindowManager.BadTokenException e16) {
                QLog.e("Q.qqstory.publish.StoryPublishLauncher", 1, "checkApiVersionDialog | BadTokenException:" + e16.getMessage());
                return true;
            } catch (Exception e17) {
                QLog.e("Q.qqstory.publish.StoryPublishLauncher", 1, "checkApiVersionDialog | Exception:" + e17.getMessage());
                return true;
            }
        }
        return false;
    }

    public static boolean b() {
        return f.j(e(), BaseApplication.getContext());
    }

    public static Bundle c(SessionWrap sessionWrap, String str, int i3, int i16) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(AECameraConstants.ARG_SESSION_INFO, sessionWrap);
        bundle.putInt("edit_video_type", i3);
        bundle.putInt("entrance_type", i16);
        bundle.putString(AECameraConstants.ARG_AIO_CLASS, str);
        if (i3 == 10000) {
            bundle.putIntegerArrayList(AECameraConstants.SUPPORT_INTENT_MODE, new ArrayList<>(Arrays.asList(0)));
        }
        bundle.putBoolean(AECameraConstants.ENABLE_LOCAL_VIDEO, false);
        return bundle;
    }

    public static StoryPublishLauncher d() {
        return new StoryPublishLauncher();
    }

    public static QQAppInterface e() {
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime instanceof QQAppInterface) {
            return (QQAppInterface) runtime;
        }
        throw new AndroidRuntimeException("mobile qq main process only");
    }

    private void f(final boolean z16) {
        String str;
        int aEResStatus = ((IAEResUtil) QRoute.api(IAEResUtil.class)).getAEResStatus(AEResInfo.AE_RES_BASE_PACKAGE);
        int aEResStatus2 = ((IAEResUtil) QRoute.api(IAEResUtil.class)).getAEResStatus(AEResInfo.LIGHT_RES_BASE_PACKAGE);
        if (aEResStatus != 0 || aEResStatus2 != 0) {
            boolean z17 = false;
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.biz.qqstory.takevideo2.StoryPublishLauncher.1
                @Override // java.lang.Runnable
                public void run() {
                    c.c("Q.qqstory.publish.StoryPublishLauncher", "launchForResult, videoSoUsable=%s, filterOk=%s", Boolean.valueOf(z16), Boolean.valueOf(StoryPublishLauncher.b()));
                }
            }, 128, null, false);
            if (z16 && aEResStatus == 1 && aEResStatus2 == 1) {
                z17 = true;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            String str2 = "1";
            if (z16) {
                str = "1";
            } else {
                str = "0";
            }
            hashMap.put("videoSoUsable", str);
            if (!z17) {
                str2 = "0";
            }
            hashMap.put("videoAndFilterReady", str2);
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", StatisticCollector.SHORT_VIDEO_SO_DOWNLOAD, true, 0L, 0L, hashMap, "");
        }
        IAEResUtil iAEResUtil = (IAEResUtil) QRoute.api(IAEResUtil.class);
        AEResInfo aEResInfo = AEResInfo.LIGHT_RES_BUNDLE_FACE;
        if (!iAEResUtil.isAEResExist(aEResInfo.agentType)) {
            ms.a.f("Q.qqstory.publish.StoryPublishLauncher", "handleLaunchEvent---download face bundle");
            ((IAEResUtil) QRoute.api(IAEResUtil.class)).fetchSingleBundle(aEResInfo.agentType);
        }
        IAEResUtil iAEResUtil2 = (IAEResUtil) QRoute.api(IAEResUtil.class);
        AEResInfo aEResInfo2 = AEResInfo.LIGHT_RES_BUNDLE_BG_SEG;
        if (!iAEResUtil2.isAEResExist(aEResInfo2.agentType)) {
            ms.a.f("Q.qqstory.publish.StoryPublishLauncher", "handleLaunchEvent---download bgSeg bundle");
            ((IAEResUtil) QRoute.api(IAEResUtil.class)).fetchSingleBundle(aEResInfo2.agentType);
        }
    }

    private boolean g() {
        IModule moduleByName = AVBizModuleFactory.getModuleByName(Constants.Business.DEFAULT_CAMERA);
        if (moduleByName != null && !"true".equals(moduleByName.checkAVFocus())) {
            return true;
        }
        return false;
    }

    public static boolean h(int i3) {
        if (i3 != js.a.f410908h.b() && i3 != js.a.Q.b() && i3 != js.a.f410923w.b()) {
            return false;
        }
        return true;
    }

    public void i(Context context, Bundle bundle) {
        if (g()) {
            ms.a.i("Q.qqstory.publish.StoryPublishLauncher", "\u3010" + R.string.hld + "\u3011");
            QQToast.makeText(context, 0, R.string.hld, 0).show();
            return;
        }
        if (a(context)) {
            return;
        }
        if (bundle == null) {
            bundle = new Bundle();
        }
        boolean isCameraResReady = ((IAECameraLauncher) QRoute.api(IAECameraLauncher.class)).isCameraResReady();
        l(bundle);
        if (isCameraResReady) {
            ms.a.f("Q.qqstory.publish.StoryPublishLauncher", "\u3010Choose\u3011 QIMCameraCaptureActivity");
            ((IQIMCameraCapture) QRoute.api(IQIMCameraCapture.class)).launch(context, bundle);
        } else {
            ms.a.f("Q.qqstory.publish.StoryPublishLauncher", "\u3010Choose\u3011 CaptureQmcfSoDownloadActivity");
            ((ICaptureQmcfSoDownloadLaunch) QRoute.api(ICaptureQmcfSoDownloadLaunch.class)).launch(context, ((IAEClassManager) QRoute.api(IAEClassManager.class)).getAEPituCameraUnitClass().getName(), bundle, bundle.getBoolean("resource_need_all_wait", false));
        }
        f(isCameraResReady);
    }

    public void j(Context context, Bundle bundle) {
        if (g()) {
            ms.a.i("Q.qqstory.publish.StoryPublishLauncher", "\u3010" + R.string.hld + "\u3011");
            QQToast.makeText(context, 0, R.string.hld, 0).show();
            QLog.e("Q.qqstory.publish.StoryPublishLauncher", 1, "launchForPreview failed: isVideoChatting");
            return;
        }
        if (a(context)) {
            QLog.e("Q.qqstory.publish.StoryPublishLauncher", 1, "launchForPreview failed: not support short video");
            return;
        }
        if (bundle == null) {
            bundle = new Bundle();
        }
        l(bundle);
        ((IQIMCameraCapture) QRoute.api(IQIMCameraCapture.class)).launch(context, bundle);
    }

    public void k(Activity activity, Bundle bundle, int i3) {
        boolean isCameraResReady;
        if (g()) {
            ms.a.i("Q.qqstory.publish.StoryPublishLauncher", "\u3010" + R.string.hld + "\u3011");
            QQToast.makeText(activity, 0, R.string.hld, 0).show();
            return;
        }
        if (a(activity)) {
            return;
        }
        if (bundle == null) {
            bundle = new Bundle();
        }
        Bundle bundle2 = bundle;
        if (bundle2.getInt("entrance_type") == 104) {
            return;
        }
        if (i3 == 11) {
            if (((IAECameraLauncher) QRoute.api(IAECameraLauncher.class)).isCameraResReady("qq_aio") && ((IShortVideoGuideUtil) QRoute.api(IShortVideoGuideUtil.class)).isResourceReady(e())) {
                isCameraResReady = true;
            } else {
                isCameraResReady = false;
            }
        } else {
            isCameraResReady = ((IAECameraLauncher) QRoute.api(IAECameraLauncher.class)).isCameraResReady();
        }
        l(bundle2);
        boolean h16 = h(bundle2.getInt(AECameraConstants.VIDEO_STORY_FROM_TYPE, js.a.f410904d.b()));
        if (!isCameraResReady && !h16) {
            ms.a.f("Q.qqstory.publish.StoryPublishLauncher", "\u3010Choose\u3011 CaptureQmcfSoDownloadActivity");
            ((ICaptureQmcfSoDownloadLaunch) QRoute.api(ICaptureQmcfSoDownloadLaunch.class)).launchForResult(activity, ((IAEClassManager) QRoute.api(IAEClassManager.class)).getAEPituCameraUnitClass().getName(), bundle2, i3, bundle2.getBoolean("resource_need_all_wait", false));
        } else {
            ms.a.f("Q.qqstory.publish.StoryPublishLauncher", "\u3010Choose\u3011 QIMCameraCaptureActivity");
            ((IQIMCameraCapture) QRoute.api(IQIMCameraCapture.class)).launchForResult(activity, bundle2, i3);
        }
        f(isCameraResReady);
    }

    public void l(@NonNull Bundle bundle) {
        if (!bundle.containsKey("entrance_type")) {
            c.u("Q.qqstory.publish.StoryPublishLauncher", "do not has entrance type", new Throwable());
        }
        if (!bundle.containsKey("edit_video_type")) {
            bundle.putInt("edit_video_type", 10002);
        }
        if (!bundle.containsKey("ability_flag")) {
            bundle.putInt("ability_flag", 1);
        }
    }
}
