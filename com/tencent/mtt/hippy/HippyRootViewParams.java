package com.tencent.mtt.hippy;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.mtt.hippy.bridge.bundleloader.HippyBundleLoader;
import com.tencent.mtt.hippy.common.HippyMap;
import java.util.Map;

@Deprecated
/* loaded from: classes20.dex */
public class HippyRootViewParams {
    private final Activity mActivity;
    private final HippyBundleLoader mBundleLoader;
    private HippyInstanceContext mHippyInstanceContext;
    private final HippyMap mLaunchParams;
    private final String mName;
    private final Map mNativeParams;

    /* loaded from: classes20.dex */
    public static class Builder {
        private Activity mActivity;
        private HippyBundleLoader mBundleLoader;
        private HippyInstanceContext mHippyInstanceContext;
        private HippyMap mLaunchParams;
        private String mName;
        private Map mNativeParams;

        public HippyRootViewParams build() {
            if (this.mActivity != null) {
                if (!TextUtils.isEmpty(this.mName)) {
                    if (this.mLaunchParams == null) {
                        this.mLaunchParams = new HippyMap();
                    }
                    HippyBundleLoader hippyBundleLoader = this.mBundleLoader;
                    if (hippyBundleLoader != null) {
                        this.mLaunchParams.pushString("sourcePath", hippyBundleLoader.getPath());
                    }
                    return new HippyRootViewParams(this.mName, this.mBundleLoader, this.mActivity, this.mLaunchParams, this.mNativeParams, this.mHippyInstanceContext);
                }
                throw new IllegalArgumentException("HippyInstance must set name!");
            }
            throw new IllegalArgumentException("HippyInstance must set activity!");
        }

        public Builder setActivity(Activity activity) {
            this.mActivity = activity;
            return this;
        }

        public Builder setBundleLoader(HippyBundleLoader hippyBundleLoader) {
            this.mBundleLoader = hippyBundleLoader;
            return this;
        }

        public Builder setInstanceContext(HippyInstanceContext hippyInstanceContext) {
            this.mHippyInstanceContext = hippyInstanceContext;
            return this;
        }

        public Builder setLaunchParams(HippyMap hippyMap) {
            this.mLaunchParams = hippyMap;
            return this;
        }

        public Builder setName(String str) {
            this.mName = str;
            return this;
        }

        public Builder setNativeParams(Map map) {
            this.mNativeParams = map;
            return this;
        }
    }

    HippyRootViewParams(String str, HippyBundleLoader hippyBundleLoader, Activity activity, HippyMap hippyMap, Map map, HippyInstanceContext hippyInstanceContext) {
        this.mName = str;
        this.mBundleLoader = hippyBundleLoader;
        this.mActivity = activity;
        this.mLaunchParams = hippyMap;
        this.mNativeParams = map;
        this.mHippyInstanceContext = hippyInstanceContext;
    }

    public void clearHippyInstanceContext() {
        this.mHippyInstanceContext = null;
    }

    public Activity getActivity() {
        return this.mActivity;
    }

    public HippyBundleLoader getBundleLoader() {
        return this.mBundleLoader;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public HippyInstanceContext getInstanceContext() {
        return this.mHippyInstanceContext;
    }

    public HippyMap getLaunchParams() {
        return this.mLaunchParams;
    }

    public String getName() {
        return this.mName;
    }

    public Map getNativeParams() {
        return this.mNativeParams;
    }
}
