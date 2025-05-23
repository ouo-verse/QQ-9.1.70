package com.tencent.mobileqq.emosm.favroaming;

import android.os.Bundle;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.emoticonview.api.IEmosmService;
import com.tencent.mobileqq.emoticonview.api.IEmoticonPanelIpcService;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* loaded from: classes6.dex */
public class EmoticonIPCModule extends QIPCModule {

    /* renamed from: d, reason: collision with root package name */
    private static EmoticonIPCModule f204322d;

    EmoticonIPCModule(String str) {
        super(str);
    }

    public static EmoticonIPCModule b() {
        if (f204322d == null) {
            synchronized (EmoticonIPCModule.class) {
                if (f204322d == null) {
                    f204322d = new EmoticonIPCModule(IEmoticonPanelIpcService.EMOTICON_IPC_NAME);
                }
            }
        }
        return f204322d;
    }

    @Override // eipc.EIPCModule
    public EIPCResult onCall(final String str, final Bundle bundle, final int i3) {
        if (QLog.isColorLevel()) {
            QLog.d(IEmoticonPanelIpcService.EMOTICON_IPC_NAME, 2, "onCall action = " + str);
        }
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (!(waitAppRuntime instanceof BaseQQAppInterface)) {
            if (QLog.isColorLevel()) {
                QLog.d(IEmoticonPanelIpcService.EMOTICON_IPC_NAME, 2, "cannot get QQAppInterface.");
            }
            return null;
        }
        final EmoticonFromGroupManager emoticonFromGroupManager = (EmoticonFromGroupManager) ((IEmosmService) QRoute.api(IEmosmService.class)).getEmoticonFromGroupManager((BaseQQAppInterface) waitAppRuntime);
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.emosm.favroaming.EmoticonIPCModule.1
            @Override // java.lang.Runnable
            public void run() {
                String string = bundle.getString("pic_md5");
                if ("action_group_emo_big_pic_add_fav".equals(str)) {
                    if (!emoticonFromGroupManager.C(string)) {
                        EmoticonIPCModule.this.callbackResult(i3, EIPCResult.createResult(-102, null));
                        return;
                    }
                    return;
                }
                if ("action_group_emo_big_pic_upload_wy".equals(str)) {
                    emoticonFromGroupManager.D(string);
                }
            }
        }, 5, null, true);
        return null;
    }
}
