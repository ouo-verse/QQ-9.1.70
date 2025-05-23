package com.tencent.mtt.hippy.bridge.bundleloader;

import android.text.TextUtils;
import com.tencent.mtt.hippy.bridge.HippyBridge;
import com.tencent.mtt.hippy.bridge.NativeCallback;
import com.tencent.mtt.hippy.utils.LogUtils;

/* compiled from: P */
/* loaded from: classes20.dex */
public class HippyFileBundleLoader implements HippyBundleLoader {
    private static final String FILE_STR = "file://";
    private boolean mCanUseCodeCache;
    private String mCodeCacheTag;
    final String mFilePath;

    public HippyFileBundleLoader(String str) {
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
        String str = this.mFilePath;
        if (str != null && !str.startsWith(FILE_STR)) {
            return FILE_STR + this.mFilePath;
        }
        return this.mFilePath;
    }

    @Override // com.tencent.mtt.hippy.bridge.bundleloader.HippyBundleLoader
    public String getRawPath() {
        return this.mFilePath;
    }

    @Override // com.tencent.mtt.hippy.bridge.bundleloader.HippyBundleLoader
    public void load(HippyBridge hippyBridge, NativeCallback nativeCallback) {
        String str;
        if (TextUtils.isEmpty(this.mFilePath)) {
            return;
        }
        if (!this.mFilePath.startsWith(HippyBridge.URI_SCHEME_FILE)) {
            str = HippyBridge.URI_SCHEME_FILE + this.mFilePath;
        } else {
            str = this.mFilePath;
        }
        LogUtils.d("HippyFileBundleLoader", "load: ret" + hippyBridge.runScriptFromUri(str, null, this.mCanUseCodeCache, this.mCodeCacheTag, nativeCallback));
    }

    public void setCodeCache(boolean z16, String str) {
        this.mCanUseCodeCache = z16;
        this.mCodeCacheTag = str;
    }

    public HippyFileBundleLoader(String str, boolean z16, String str2) {
        this.mFilePath = str;
        this.mCanUseCodeCache = z16;
        this.mCodeCacheTag = str2;
    }
}
