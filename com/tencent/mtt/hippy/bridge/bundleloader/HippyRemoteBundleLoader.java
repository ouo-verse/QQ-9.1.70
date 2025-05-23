package com.tencent.mtt.hippy.bridge.bundleloader;

import android.text.TextUtils;
import com.tencent.mtt.hippy.bridge.HippyBridge;
import com.tencent.mtt.hippy.bridge.NativeCallback;
import com.tencent.mtt.hippy.utils.LogUtils;

/* compiled from: P */
/* loaded from: classes20.dex */
public class HippyRemoteBundleLoader implements HippyBundleLoader {
    private boolean mCanUseCodeCache;
    private String mCodeCacheTag;
    boolean mIsDebugMode;
    final String mUrl;

    public HippyRemoteBundleLoader(String str) {
        this(str, false, "");
    }

    @Override // com.tencent.mtt.hippy.bridge.bundleloader.HippyBundleLoader
    public boolean canUseCodeCache() {
        return this.mCanUseCodeCache;
    }

    @Override // com.tencent.mtt.hippy.bridge.bundleloader.HippyBundleLoader
    public String getBundleUniKey() {
        return getPath();
    }

    @Override // com.tencent.mtt.hippy.bridge.bundleloader.HippyBundleLoader
    public String getCodeCacheTag() {
        return this.mCodeCacheTag;
    }

    @Override // com.tencent.mtt.hippy.bridge.bundleloader.HippyBundleLoader
    public String getPath() {
        return this.mUrl;
    }

    @Override // com.tencent.mtt.hippy.bridge.bundleloader.HippyBundleLoader
    public String getRawPath() {
        return this.mUrl;
    }

    @Override // com.tencent.mtt.hippy.bridge.bundleloader.HippyBundleLoader
    public void load(HippyBridge hippyBridge, NativeCallback nativeCallback) {
        if (TextUtils.isEmpty(this.mUrl)) {
            return;
        }
        LogUtils.d("HippyRemoteBundleLoader", "load: ret" + hippyBridge.runScriptFromUri(this.mUrl, null, this.mCanUseCodeCache, this.mCodeCacheTag, nativeCallback));
    }

    public void setCodeCache(boolean z16, String str) {
        this.mCanUseCodeCache = z16;
        this.mCodeCacheTag = str;
    }

    public void setIsDebugMode(boolean z16) {
        this.mIsDebugMode = z16;
    }

    public HippyRemoteBundleLoader(String str, boolean z16, String str2) {
        this.mIsDebugMode = false;
        this.mUrl = str;
        this.mCanUseCodeCache = z16;
        this.mCodeCacheTag = str2;
    }
}
