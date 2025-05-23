package com.qzone.common.tool;

import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qzonehub.api.IQzonePatchApi;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;

/* loaded from: classes39.dex */
public class PhotoFilterTool {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f46121a = false;

    public static void d() {
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.RealTimeThread).post(new Runnable() { // from class: com.qzone.common.tool.PhotoFilterTool.1
            @Override // java.lang.Runnable
            public void run() {
                PhotoFilterTool.f46121a = ((IAEResUtil) QRoute.api(IAEResUtil.class)).isLightCameraResExist();
                if (PhotoFilterTool.f46121a) {
                    return;
                }
                PhotoFilterTool.f();
                QZLog.d("PhotoFilterTool", 1, "isQQFilterSoDownloaded false ,start download");
            }
        });
    }

    public static boolean e() {
        return f46121a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void f() {
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.PreLoadThread).post(new Runnable() { // from class: com.qzone.common.tool.PhotoFilterTool.2
            @Override // java.lang.Runnable
            public void run() {
                ((IQzonePatchApi) QRoute.api(IQzonePatchApi.class)).triggerQQDownloadPtuFilter();
            }
        });
    }
}
