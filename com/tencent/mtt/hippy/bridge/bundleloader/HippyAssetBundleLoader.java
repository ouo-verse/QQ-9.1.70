package com.tencent.mtt.hippy.bridge.bundleloader;

import android.content.Context;
import android.content.res.AssetManager;
import android.text.TextUtils;
import com.tencent.mtt.hippy.bridge.HippyBridge;
import com.tencent.mtt.hippy.bridge.NativeCallback;
import com.tencent.mtt.hippy.utils.LogUtils;

/* compiled from: P */
/* loaded from: classes20.dex */
public class HippyAssetBundleLoader implements HippyBundleLoader {
    private static final String ASSETS_STR = "assets://";
    private final String mAssetPath;
    private boolean mCanUseCodeCache;
    private String mCodeCacheTag;
    private final Context mContext;

    public HippyAssetBundleLoader(Context context, String str) {
        this(context, str, false, "");
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
        String str = this.mAssetPath;
        if (str != null && !str.startsWith("assets://")) {
            return "assets://" + this.mAssetPath;
        }
        return this.mAssetPath;
    }

    @Override // com.tencent.mtt.hippy.bridge.bundleloader.HippyBundleLoader
    public String getRawPath() {
        return this.mAssetPath;
    }

    @Override // com.tencent.mtt.hippy.bridge.bundleloader.HippyBundleLoader
    public void load(HippyBridge hippyBridge, NativeCallback nativeCallback) {
        StringBuilder sb5;
        if (TextUtils.isEmpty(this.mAssetPath)) {
            return;
        }
        AssetManager assets = this.mContext.getAssets();
        String str = this.mAssetPath;
        String str2 = HippyBridge.URI_SCHEME_ASSETS;
        if (!str.startsWith(HippyBridge.URI_SCHEME_ASSETS)) {
            if (this.mAssetPath.startsWith("/")) {
                sb5 = new StringBuilder();
            } else {
                sb5 = new StringBuilder();
                str2 = "asset:/";
            }
            sb5.append(str2);
            sb5.append(this.mAssetPath);
            str = sb5.toString();
        }
        LogUtils.d("HippyAssetBundleLoader", "load: ret" + hippyBridge.runScriptFromUri(str, assets, this.mCanUseCodeCache, this.mCodeCacheTag, nativeCallback));
    }

    public void setCodeCache(boolean z16, String str) {
        this.mCanUseCodeCache = z16;
        this.mCodeCacheTag = str;
    }

    public HippyAssetBundleLoader(Context context, String str, boolean z16, String str2) {
        this.mContext = context;
        this.mAssetPath = str;
        this.mCanUseCodeCache = z16;
        this.mCodeCacheTag = str2;
    }
}
