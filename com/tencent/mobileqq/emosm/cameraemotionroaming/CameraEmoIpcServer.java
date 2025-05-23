package com.tencent.mobileqq.emosm.cameraemotionroaming;

import android.os.Bundle;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.emoticonview.api.IEmoticonPanelIpcService;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes6.dex */
public class CameraEmoIpcServer extends QIPCModule {

    /* compiled from: P */
    /* loaded from: classes6.dex */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        private static CameraEmoIpcServer f204247a = new CameraEmoIpcServer();
    }

    public CameraEmoIpcServer() {
        super(IEmoticonPanelIpcService.CAMERAEMOIPC_SERVER_NAME);
    }

    public static CameraEmoIpcServer b() {
        return a.f204247a;
    }

    @Override // eipc.EIPCModule
    public EIPCResult onCall(String str, Bundle bundle, int i3) {
        BaseQQAppInterface baseQQAppInterface;
        if (QLog.isColorLevel()) {
            QLog.d(IEmoticonPanelIpcService.CAMERAEMOIPC_SERVER_NAME, 2, "action = " + str + ", params = " + bundle);
        }
        Bundle bundle2 = new Bundle();
        if ("qipc_action_camera_emo_create_gif_and_upload".equals(str)) {
            bundle.setClassLoader(getClass().getClassLoader());
            final ArrayList<String> stringArrayList = bundle.getStringArrayList("qipc_param_camera_emo_png_dirs");
            final ArrayList<String> stringArrayList2 = bundle.getStringArrayList("qipc_param_camera_emo_texts");
            final ArrayList<String> stringArrayList3 = bundle.getStringArrayList("qipc_param_camera_emo_snapshots");
            final ArrayList<String> stringArrayList4 = bundle.getStringArrayList("qipc_param_emo_widget_infos");
            if (stringArrayList != null && stringArrayList2 != null) {
                if (MobileQQ.sMobileQQ.waitAppRuntime(null) instanceof BaseQQAppInterface) {
                    baseQQAppInterface = (BaseQQAppInterface) MobileQQ.sMobileQQ.waitAppRuntime(null);
                } else {
                    baseQQAppInterface = null;
                }
                if (baseQQAppInterface == null) {
                    QLog.d(IEmoticonPanelIpcService.CAMERAEMOIPC_SERVER_NAME, 2, "CameraEmoIpcServer.onCall get app failed");
                    bundle2.putInt("qipc_param_camera_emo_upload_result", 16);
                    callbackResult(i3, EIPCResult.createExceptionResult(new Exception("app == null")));
                    HashMap<String, String> hashMap = new HashMap<>();
                    hashMap.put("sucFlag", "0");
                    hashMap.put("retCode", String.valueOf(16));
                    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "CamEmoUpload", false, 0L, 0L, hashMap, null);
                    return null;
                }
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.emosm.cameraemotionroaming.CameraEmoIpcServer.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (stringArrayList3 != null) {
                            b.b().g(stringArrayList, stringArrayList2, stringArrayList3, stringArrayList4);
                        } else {
                            b.b().f(stringArrayList, stringArrayList2, stringArrayList4);
                        }
                    }
                }, 64, null, false);
                callbackResult(i3, EIPCResult.createSuccessResult(bundle2));
            } else {
                QLog.d(IEmoticonPanelIpcService.CAMERAEMOIPC_SERVER_NAME, 2, "CameraEmoIpcServer.onCall params error");
                bundle2.putInt("qipc_param_camera_emo_upload_result", 16);
                callbackResult(i3, EIPCResult.createExceptionResult(new Exception("pngDirs == null || texts == null")));
                HashMap<String, String> hashMap2 = new HashMap<>();
                hashMap2.put("sucFlag", "0");
                hashMap2.put("retCode", String.valueOf(16));
                StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "CamEmoUpload", false, 0L, 0L, hashMap2, null);
            }
        }
        return null;
    }
}
