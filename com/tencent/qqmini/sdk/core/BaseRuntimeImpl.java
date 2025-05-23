package com.tencent.qqmini.sdk.core;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.manager.ActivityResultManagerFaker;
import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import com.tencent.qqmini.sdk.core.manager.ObserverManager;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.shell.BaselibLoader;
import com.tencent.qqmini.sdk.launcher.shell.IActivityResultManager;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppFileManager;
import com.tencent.qqmini.sdk.report.MiniAppRealTimeLogReporter;

/* compiled from: P */
/* loaded from: classes23.dex */
public abstract class BaseRuntimeImpl extends BaseRuntime {
    protected Context mContext;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class BaselibProvider {
        private BaselibLoader.BaselibContent mBaselibContent;

        public String getBasePageFrameStr() {
            BaselibLoader.BaselibContent baselibContent = this.mBaselibContent;
            if (baselibContent != null && !TextUtils.isEmpty(baselibContent.pageFrameStr)) {
                return this.mBaselibContent.pageFrameStr;
            }
            return "<!DOCTYPE html><html lang=\"zh-CN\"><head><meta charset=\"UTF-8\" /><meta name=\"viewport\" content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\" /><meta http-equiv=\"Content-Security-Policy\" content=\"script-src 'self' 'unsafe-inline' 'unsafe-eval'\"><link rel=\"icon\" href=\"data:image/ico;base64,aWNv\"><script></script></head><body><div></div></body></html>";
        }

        public BaselibLoader.BaselibContent getBaselibContent() {
            return this.mBaselibContent;
        }

        public void setBaseLib(BaselibLoader.BaselibContent baselibContent) {
            this.mBaselibContent = baselibContent;
        }
    }

    public BaseRuntimeImpl(Context context) {
        this.mContext = context;
        MiniAppFileManager miniAppFileManager = new MiniAppFileManager();
        this.mManagerMap.put(MiniAppFileManager.class, miniAppFileManager);
        this.mManagerMap.put(IMiniAppFileManager.class, miniAppFileManager);
        this.mManagerMap.put(BaselibProvider.class, new BaselibProvider());
        this.mManagerMap.put(MiniAppRealTimeLogReporter.class, new MiniAppRealTimeLogReporter());
        this.mManagerMap.put(ObserverManager.class, new ObserverManager());
        this.mManagerMap.put(IActivityResultManager.class, new ActivityResultManagerFaker());
    }
}
