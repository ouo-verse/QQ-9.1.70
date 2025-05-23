package com.tencent.comic.api.impl;

import android.app.Application;
import com.tencent.comic.VipComicHelper;
import com.tencent.comic.api.IQQComicService;
import com.tencent.comic.f;
import com.tencent.comic.g;
import com.tencent.comic.i;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes32.dex */
public class QQComicServiceImpl implements IQQComicService {
    public static final String TAG = "QQComicServiceImpl";
    private AppRuntime appRuntime;

    @Override // com.tencent.comic.api.IQQComicService
    public AppRuntime createComicRuntime(Application application, String str) {
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "createComicRuntime: processName=" + str);
        }
        return VipComicHelper.a(application instanceof MobileQQ ? (MobileQQ) application : null, str);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        this.appRuntime = appRuntime;
    }

    @Override // com.tencent.comic.api.IQQComicService
    public void startUp() {
        final AppRuntime appRuntime = this.appRuntime;
        if (appRuntime == null) {
            QLog.i(TAG, 1, "app runtime is null");
        } else {
            ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.comic.api.impl.QQComicServiceImpl.1
                @Override // java.lang.Runnable
                public void run() {
                    ThreadManagerV2.executeOnNetWorkThread(new Runnable() { // from class: com.tencent.comic.api.impl.QQComicServiceImpl.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            f.k(appRuntime);
                            i.b(appRuntime);
                        }
                    });
                }
            }, 3000L);
        }
    }

    @Override // com.tencent.comic.api.IQQComicService
    public void beforeLaunchPlugin() {
        g.d(null);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
    }
}
