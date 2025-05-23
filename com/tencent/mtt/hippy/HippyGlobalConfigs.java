package com.tencent.mtt.hippy;

import android.content.Context;
import com.tencent.mtt.hippy.HippyEngine;
import com.tencent.mtt.hippy.adapter.DefaultLogAdapter;
import com.tencent.mtt.hippy.adapter.HippyLogAdapter;
import com.tencent.mtt.hippy.adapter.device.DefaultDeviceAdapter;
import com.tencent.mtt.hippy.adapter.device.HippyDeviceAdapter;
import com.tencent.mtt.hippy.adapter.exception.DefaultExceptionHandler;
import com.tencent.mtt.hippy.adapter.exception.HippyExceptionHandlerAdapter;
import com.tencent.mtt.hippy.adapter.executor.DefaultExecutorSupplierAdapter;
import com.tencent.mtt.hippy.adapter.executor.HippyExecutorSupplierAdapter;
import com.tencent.mtt.hippy.adapter.font.DefaultFontScaleAdapter;
import com.tencent.mtt.hippy.adapter.font.HippyFontScaleAdapter;
import com.tencent.mtt.hippy.adapter.http.DefaultHttpAdapter;
import com.tencent.mtt.hippy.adapter.http.HippyHttpAdapter;
import com.tencent.mtt.hippy.adapter.image.HippyImageLoader;
import com.tencent.mtt.hippy.adapter.monitor.DefaultEngineMonitorAdapter;
import com.tencent.mtt.hippy.adapter.monitor.HippyEngineMonitorAdapter;
import com.tencent.mtt.hippy.adapter.sharedpreferences.DefaultSharedPreferencesAdapter;
import com.tencent.mtt.hippy.adapter.sharedpreferences.HippySharedPreferencesAdapter;
import com.tencent.mtt.hippy.adapter.soloader.DefaultSoLoaderAdapter;
import com.tencent.mtt.hippy.adapter.soloader.HippySoLoaderAdapter;
import com.tencent.mtt.hippy.adapter.storage.DefaultStorageAdapter;
import com.tencent.mtt.hippy.adapter.storage.HippyStorageAdapter;
import com.tencent.mtt.hippy.utils.LogUtils;

/* compiled from: P */
/* loaded from: classes20.dex */
public class HippyGlobalConfigs {
    private Context mContext;
    private final HippyDeviceAdapter mDeviceAdapter;
    private boolean mEnableTurbo;
    private final HippyEngineMonitorAdapter mEngineMonitorAdapter;
    private final HippyExceptionHandlerAdapter mExceptionHandler;
    private final HippyExecutorSupplierAdapter mExecutorSupplierAdapter;
    private final HippyFontScaleAdapter mFontScaleAdapter;
    private final HippyHttpAdapter mHttpAdapter;
    private final HippyImageLoader mImageLoaderAdapter;
    private final HippyLogAdapter mLogAdapter;
    private final HippySharedPreferencesAdapter mSharedPreferencesAdapter;
    private final HippySoLoaderAdapter mSoLoaderAdapter;
    private final HippyStorageAdapter mStorageAdapter;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class Builder {
        private Context mContext;
        private HippyDeviceAdapter mDeviceAdapter;
        private HippyEngineMonitorAdapter mEngineMonitorAdapter;
        private HippyExceptionHandlerAdapter mExceptionHandler;
        private HippyExecutorSupplierAdapter mExecutorSupplierAdapter;
        private HippyFontScaleAdapter mFontScaleAdapter;
        private HippyHttpAdapter mHttpAdapter;
        private HippyImageLoader mImageLoaderAdapter;
        private HippyLogAdapter mLogAdapter;
        private HippySharedPreferencesAdapter mSharedPreferencesAdapter;
        private HippySoLoaderAdapter mSoLoaderAdapter;
        private HippyStorageAdapter mStorageAdapter;

        @Deprecated
        public HippyGlobalConfigs build() {
            Context context = this.mContext;
            if (context != null) {
                if (this.mSharedPreferencesAdapter == null) {
                    this.mSharedPreferencesAdapter = new DefaultSharedPreferencesAdapter(context.getApplicationContext());
                }
                if (this.mExceptionHandler == null) {
                    this.mExceptionHandler = new DefaultExceptionHandler();
                }
                if (this.mHttpAdapter == null) {
                    this.mHttpAdapter = new DefaultHttpAdapter();
                }
                if (this.mExecutorSupplierAdapter == null) {
                    this.mExecutorSupplierAdapter = new DefaultExecutorSupplierAdapter();
                }
                if (this.mStorageAdapter == null) {
                    this.mStorageAdapter = new DefaultStorageAdapter(this.mContext.getApplicationContext(), this.mExecutorSupplierAdapter.getDBExecutor());
                }
                if (this.mEngineMonitorAdapter == null) {
                    this.mEngineMonitorAdapter = new DefaultEngineMonitorAdapter();
                }
                if (this.mFontScaleAdapter == null) {
                    this.mFontScaleAdapter = new DefaultFontScaleAdapter();
                }
                if (this.mSoLoaderAdapter == null) {
                    this.mSoLoaderAdapter = new DefaultSoLoaderAdapter();
                }
                if (this.mDeviceAdapter == null) {
                    this.mDeviceAdapter = new DefaultDeviceAdapter();
                }
                if (this.mLogAdapter == null) {
                    this.mLogAdapter = new DefaultLogAdapter();
                }
                HippyImageLoader hippyImageLoader = this.mImageLoaderAdapter;
                if (hippyImageLoader != null) {
                    return new HippyGlobalConfigs(this.mContext, this.mSharedPreferencesAdapter, this.mExceptionHandler, this.mHttpAdapter, hippyImageLoader, this.mExecutorSupplierAdapter, this.mStorageAdapter, this.mEngineMonitorAdapter, this.mFontScaleAdapter, this.mSoLoaderAdapter, this.mDeviceAdapter, this.mLogAdapter);
                }
                throw new IllegalArgumentException("HippyGlobalConfigs ImageLoaderAdapter must is not null!");
            }
            throw new IllegalArgumentException("HippyGlobalConfigs Context must is not null!");
        }

        public HippyLogAdapter getLogAdapter() {
            return this.mLogAdapter;
        }

        public Builder setContext(Context context) {
            this.mContext = context;
            return this;
        }

        public Builder setDeviceAdapter(HippyDeviceAdapter hippyDeviceAdapter) {
            this.mDeviceAdapter = hippyDeviceAdapter;
            return this;
        }

        public Builder setEngineMonitorAdapter(HippyEngineMonitorAdapter hippyEngineMonitorAdapter) {
            this.mEngineMonitorAdapter = hippyEngineMonitorAdapter;
            return this;
        }

        public Builder setExceptionHandler(HippyExceptionHandlerAdapter hippyExceptionHandlerAdapter) {
            this.mExceptionHandler = hippyExceptionHandlerAdapter;
            return this;
        }

        public Builder setExecutorSupplierAdapter(HippyExecutorSupplierAdapter hippyExecutorSupplierAdapter) {
            this.mExecutorSupplierAdapter = hippyExecutorSupplierAdapter;
            return this;
        }

        public Builder setFontScaleAdapter(HippyFontScaleAdapter hippyFontScaleAdapter) {
            this.mFontScaleAdapter = hippyFontScaleAdapter;
            return this;
        }

        public Builder setHttpAdapter(HippyHttpAdapter hippyHttpAdapter) {
            this.mHttpAdapter = hippyHttpAdapter;
            return this;
        }

        public Builder setImageLoaderAdapter(HippyImageLoader hippyImageLoader) {
            this.mImageLoaderAdapter = hippyImageLoader;
            return this;
        }

        public Builder setLogAdapter(HippyLogAdapter hippyLogAdapter) {
            this.mLogAdapter = hippyLogAdapter;
            return this;
        }

        public Builder setSharedPreferencesAdapter(HippySharedPreferencesAdapter hippySharedPreferencesAdapter) {
            this.mSharedPreferencesAdapter = hippySharedPreferencesAdapter;
            return this;
        }

        public Builder setSoLoaderAdapter(HippySoLoaderAdapter hippySoLoaderAdapter) {
            this.mSoLoaderAdapter = hippySoLoaderAdapter;
            return this;
        }

        public Builder setStorageAdapter(HippyStorageAdapter hippyStorageAdapter) {
            this.mStorageAdapter = hippyStorageAdapter;
            return this;
        }
    }

    HippyGlobalConfigs(Context context, HippySharedPreferencesAdapter hippySharedPreferencesAdapter, HippyExceptionHandlerAdapter hippyExceptionHandlerAdapter, HippyHttpAdapter hippyHttpAdapter, HippyImageLoader hippyImageLoader, HippyExecutorSupplierAdapter hippyExecutorSupplierAdapter, HippyStorageAdapter hippyStorageAdapter, HippyEngineMonitorAdapter hippyEngineMonitorAdapter, HippyFontScaleAdapter hippyFontScaleAdapter, HippySoLoaderAdapter hippySoLoaderAdapter, HippyDeviceAdapter hippyDeviceAdapter, HippyLogAdapter hippyLogAdapter) {
        this.mContext = context;
        this.mSharedPreferencesAdapter = hippySharedPreferencesAdapter;
        this.mExceptionHandler = hippyExceptionHandlerAdapter;
        this.mHttpAdapter = hippyHttpAdapter;
        this.mImageLoaderAdapter = hippyImageLoader;
        this.mStorageAdapter = hippyStorageAdapter;
        this.mExecutorSupplierAdapter = hippyExecutorSupplierAdapter;
        this.mEngineMonitorAdapter = hippyEngineMonitorAdapter;
        this.mFontScaleAdapter = hippyFontScaleAdapter;
        this.mSoLoaderAdapter = hippySoLoaderAdapter;
        this.mDeviceAdapter = hippyDeviceAdapter;
        this.mLogAdapter = hippyLogAdapter;
    }

    public void destroyIfNeed() {
        try {
            HippyHttpAdapter hippyHttpAdapter = this.mHttpAdapter;
            if (hippyHttpAdapter != null) {
                hippyHttpAdapter.destroyIfNeed();
            }
            HippyStorageAdapter hippyStorageAdapter = this.mStorageAdapter;
            if (hippyStorageAdapter != null) {
                hippyStorageAdapter.destroyIfNeed();
            }
            HippyExecutorSupplierAdapter hippyExecutorSupplierAdapter = this.mExecutorSupplierAdapter;
            if (hippyExecutorSupplierAdapter != null) {
                hippyExecutorSupplierAdapter.destroyIfNeed();
            }
            HippyImageLoader hippyImageLoader = this.mImageLoaderAdapter;
            if (hippyImageLoader != null) {
                hippyImageLoader.destroyIfNeed();
            }
            this.mContext = null;
        } catch (Throwable th5) {
            LogUtils.d("HippyGlobalConfigs", "destroyIfNeed: " + th5.getMessage());
        }
    }

    public boolean enableTurbo() {
        return this.mEnableTurbo;
    }

    public Context getContext() {
        return this.mContext;
    }

    public HippyDeviceAdapter getDeviceAdapter() {
        return this.mDeviceAdapter;
    }

    public HippyEngineMonitorAdapter getEngineMonitorAdapter() {
        return this.mEngineMonitorAdapter;
    }

    public HippyExceptionHandlerAdapter getExceptionHandler() {
        return this.mExceptionHandler;
    }

    public HippyExecutorSupplierAdapter getExecutorSupplierAdapter() {
        return this.mExecutorSupplierAdapter;
    }

    public HippyFontScaleAdapter getFontScaleAdapter() {
        return this.mFontScaleAdapter;
    }

    public HippyHttpAdapter getHttpAdapter() {
        return this.mHttpAdapter;
    }

    public HippyImageLoader getImageLoaderAdapter() {
        return this.mImageLoaderAdapter;
    }

    public HippyLogAdapter getLogAdapter() {
        return this.mLogAdapter;
    }

    public HippySharedPreferencesAdapter getSharedPreferencesAdapter() {
        return this.mSharedPreferencesAdapter;
    }

    public HippySoLoaderAdapter getSoLoaderAdapter() {
        return this.mSoLoaderAdapter;
    }

    public HippyStorageAdapter getStorageAdapter() {
        return this.mStorageAdapter;
    }

    @Deprecated
    public void toDebug(HippyEngine.EngineInitParams engineInitParams) {
        engineInitParams.context = this.mContext;
        engineInitParams.sharedPreferencesAdapter = this.mSharedPreferencesAdapter;
        engineInitParams.exceptionHandler = this.mExceptionHandler;
        engineInitParams.httpAdapter = this.mHttpAdapter;
        engineInitParams.imageLoader = this.mImageLoaderAdapter;
        engineInitParams.storageAdapter = this.mStorageAdapter;
        engineInitParams.executorSupplier = this.mExecutorSupplierAdapter;
        engineInitParams.engineMonitor = this.mEngineMonitorAdapter;
        engineInitParams.fontScaleAdapter = this.mFontScaleAdapter;
        engineInitParams.soLoader = this.mSoLoaderAdapter;
        engineInitParams.deviceAdapter = this.mDeviceAdapter;
        engineInitParams.logAdapter = this.mLogAdapter;
        engineInitParams.enableTurbo = true;
    }

    public HippyGlobalConfigs(HippyEngine.EngineInitParams engineInitParams) {
        this.mContext = engineInitParams.context;
        this.mSharedPreferencesAdapter = engineInitParams.sharedPreferencesAdapter;
        this.mExceptionHandler = engineInitParams.exceptionHandler;
        this.mHttpAdapter = engineInitParams.httpAdapter;
        this.mImageLoaderAdapter = engineInitParams.imageLoader;
        this.mStorageAdapter = engineInitParams.storageAdapter;
        this.mExecutorSupplierAdapter = engineInitParams.executorSupplier;
        this.mEngineMonitorAdapter = engineInitParams.engineMonitor;
        this.mFontScaleAdapter = engineInitParams.fontScaleAdapter;
        this.mSoLoaderAdapter = engineInitParams.soLoader;
        this.mDeviceAdapter = engineInitParams.deviceAdapter;
        this.mLogAdapter = engineInitParams.logAdapter;
        this.mEnableTurbo = engineInitParams.enableTurbo;
    }
}
