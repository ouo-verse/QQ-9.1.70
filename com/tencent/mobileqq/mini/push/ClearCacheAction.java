package com.tencent.mobileqq.mini.push;

import android.content.Intent;
import android.os.Process;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadExcutor;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mini.MiniAppInterface;
import com.tencent.mobileqq.mini.cache.MiniCacheFreeManager;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes33.dex */
public class ClearCacheAction implements PushAction {
    public static final String KEY_APPID = "appid";
    public static final String TAG = "ClearCacheAction";

    @Override // com.tencent.mobileqq.mini.push.PushAction
    public void exec(MiniAppControlInfo miniAppControlInfo) {
        if (miniAppControlInfo.data.containsKey("appid")) {
            final String str = miniAppControlInfo.data.get("appid");
            QLog.d(TAG, 1, "ClearCacheAction: appid:" + str);
            MiniCacheFreeManager.freeCache(BaseApplicationImpl.getApplication().getRuntime().getAccount(), str, true, new ThreadExcutor.IThreadListener() { // from class: com.tencent.mobileqq.mini.push.ClearCacheAction.1
                @Override // com.tencent.mobileqq.app.ThreadExcutor.IThreadListener
                public void onPostRun() {
                    AppLoaderFactory.g().getMiniCacheFreeManager().freeCache(BaseApplicationImpl.getApplication().getRuntime().getAccount(), new MiniAppInfo(), false);
                    QLog.d(ClearCacheAction.TAG, 1, "ClearCacheAction: appid:" + str + " killSelf!!!");
                    SystemMethodProxy.killProcess(Process.myPid());
                }

                @Override // com.tencent.mobileqq.app.ThreadExcutor.IThreadListener
                public void onAdded() {
                }

                @Override // com.tencent.mobileqq.app.ThreadExcutor.IThreadListener
                public void onPreRun() {
                }
            });
            return;
        }
        QLog.d(TAG, 1, "ClearCacheAction:");
        MiniCacheFreeManager.freeCache(true, new ThreadExcutor.IThreadListener() { // from class: com.tencent.mobileqq.mini.push.ClearCacheAction.2
            @Override // com.tencent.mobileqq.app.ThreadExcutor.IThreadListener
            public void onPostRun() {
                AppLoaderFactory.g().getMiniCacheFreeManager().freeCache();
                ThreadManager.getSubThreadHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.mini.push.ClearCacheAction.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Intent intent = new Intent(MiniAppInterface.ACTION_MINI_PROCESS_EXIT);
                        intent.setPackage(MobileQQ.PACKAGE_NAME);
                        BaseApplication.getContext().sendBroadcast(intent);
                    }
                }, 3000L);
            }

            @Override // com.tencent.mobileqq.app.ThreadExcutor.IThreadListener
            public void onAdded() {
            }

            @Override // com.tencent.mobileqq.app.ThreadExcutor.IThreadListener
            public void onPreRun() {
            }
        });
    }
}
