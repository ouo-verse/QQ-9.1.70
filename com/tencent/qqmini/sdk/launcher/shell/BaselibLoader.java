package com.tencent.qqmini.sdk.launcher.shell;

import android.content.Context;
import android.text.TextUtils;

/* compiled from: P */
/* loaded from: classes23.dex */
public abstract class BaselibLoader {
    public static final String TAG = "BaselibLoader";
    protected BaselibContent mBaselibContent;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class BaselibContent {
        public String miniappWebviewStr;
        public String pageFrameStr;
        public String version;
        public String waConsoleJsStr;
        public String waRemoteDebugStr;
        public String waServiceJsStr;
        public String waServicePath;
        public String waWebviewJsStr;
        public String waWorkerStr;

        public boolean isBaseLibInited() {
            if (!TextUtils.isEmpty(this.waServiceJsStr) && !TextUtils.isEmpty(this.waWebviewJsStr) && !TextUtils.isEmpty(this.waConsoleJsStr) && !TextUtils.isEmpty(this.waRemoteDebugStr) && !TextUtils.isEmpty(this.miniappWebviewStr)) {
                return true;
            }
            return false;
        }

        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public BaselibContent m247clone() {
            BaselibContent baselibContent = new BaselibContent();
            baselibContent.waWebviewJsStr = this.waWebviewJsStr;
            baselibContent.waServiceJsStr = this.waServiceJsStr;
            baselibContent.waConsoleJsStr = this.waConsoleJsStr;
            baselibContent.waRemoteDebugStr = this.waRemoteDebugStr;
            baselibContent.miniappWebviewStr = this.miniappWebviewStr;
            baselibContent.waWorkerStr = this.waWorkerStr;
            baselibContent.pageFrameStr = this.pageFrameStr;
            baselibContent.waServicePath = this.waServicePath;
            return baselibContent;
        }
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public interface OnLoadBaselibListener {
        void onResult(int i3, String str, BaselibContent baselibContent);
    }

    public BaselibContent getBaselib() {
        return this.mBaselibContent;
    }

    public boolean isBaseLibInit() {
        BaselibContent baselibContent = this.mBaselibContent;
        if (baselibContent != null && baselibContent.isBaseLibInited()) {
            return true;
        }
        return false;
    }

    public abstract void loadBaselib(Context context, OnLoadBaselibListener onLoadBaselibListener);

    public void setBaselib(BaselibContent baselibContent) {
        if (baselibContent != null && baselibContent.isBaseLibInited()) {
            this.mBaselibContent = baselibContent;
        }
    }
}
