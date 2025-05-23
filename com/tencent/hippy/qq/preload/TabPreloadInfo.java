package com.tencent.hippy.qq.preload;

import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.hippy.qq.app.HippyQQPreloadEngine;

/* loaded from: classes7.dex */
public class TabPreloadInfo {
    public HippyQQPreloadEngine mHippyEngine;
    public TabPreloadItem mPreloadItem;
    public int mPreloadScene = 1;
    public String mPreloadTab;
    public long mPreloadTime;

    public TabPreloadInfo(String str, TabPreloadItem tabPreloadItem) {
        this.mPreloadTab = str;
        this.mPreloadItem = tabPreloadItem;
    }

    public void destroyHippyEngine(String str) {
        HippyQQPreloadEngine hippyQQPreloadEngine = this.mHippyEngine;
        if (hippyQQPreloadEngine != null) {
            hippyQQPreloadEngine.destroyEngineImmediately(str);
        }
    }

    public boolean isLifeEnd() {
        TabPreloadItem tabPreloadItem = this.mPreloadItem;
        if (tabPreloadItem == null || tabPreloadItem.lifeTime <= 0) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        long j3 = this.mPreloadTime;
        if (currentTimeMillis < j3 || currentTimeMillis - j3 > this.mPreloadItem.lifeTime) {
            return true;
        }
        return false;
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append('{');
        if (this.mPreloadItem != null) {
            sb5.append("bundleName:");
            sb5.append(this.mPreloadItem.bundleName);
            sb5.append(" preloadType:");
            sb5.append(this.mPreloadItem.preloadType);
            sb5.append(" jsType:");
            sb5.append(this.mPreloadItem.preloadFramework);
        }
        sb5.append(" tabName:");
        sb5.append(this.mPreloadTab);
        sb5.append(" preloadTime:");
        sb5.append(this.mPreloadTime);
        sb5.append('}');
        return sb5.toString();
    }
}
