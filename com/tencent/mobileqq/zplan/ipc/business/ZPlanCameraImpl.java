package com.tencent.mobileqq.zplan.ipc.business;

import com.tencent.aelight.camera.filament.api.IZShowFilamentPreviewProvider;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zplan.cc.an;
import com.tencent.mobileqq.zplan.meme.api.impl.MemeHelper;
import com.tencent.qphone.base.util.BaseApplication;

/* loaded from: classes34.dex */
public class ZPlanCameraImpl implements b {
    private static final int MIN_MEMORY_SIZE_MB = 4096;

    @Override // com.tencent.mobileqq.zplan.ipc.business.b
    public void onDestroyFaceCamera() {
        MemeHelper.INSTANCE.toggleQueuePauseState(false, "DestroyFaceCamera");
    }

    @Override // com.tencent.mobileqq.zplan.ipc.business.b
    public void openFaceCamera() {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.ipc.business.ZPlanCameraImpl.1
            @Override // java.lang.Runnable
            public void run() {
                BaseApplication baseApplication = BaseApplication.context;
                if (baseApplication != null) {
                    QQToast.makeText(baseApplication, HardCodeUtil.qqStr(R.string.ubf), 0).show();
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.zplan.ipc.business.b
    public void openFilamentFaceCamera(int i3, ZootopiaSource zootopiaSource, String str) {
        if (((IZShowFilamentPreviewProvider) QRoute.api(IZShowFilamentPreviewProvider.class)).isSupportFilament()) {
            an.f332478a.h(BaseApplication.context, i3, zootopiaSource, str);
        } else {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.ipc.business.ZPlanCameraImpl.2
                @Override // java.lang.Runnable
                public void run() {
                    BaseApplication baseApplication = BaseApplication.context;
                    if (baseApplication != null) {
                        QQToast.makeText(baseApplication, "\u6682\u672a\u5f00\u653e", 0).show();
                    }
                }
            });
        }
    }
}
