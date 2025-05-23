package com.tencent.oskplayer;

import android.text.TextUtils;
import android.util.Log;
import com.tencent.oskplayer.cache.CacheKeyGenerator;
import com.tencent.oskplayer.cache.DefaultCacheKeyGenerator;
import com.tencent.oskplayer.datasource.HttpHeader;
import com.tencent.oskplayer.report.IVideoReporter;
import com.tencent.oskplayer.support.loader.NativeLibLoader;
import com.tencent.oskplayer.util.QLog;
import java.util.List;

/* loaded from: classes22.dex */
public class OskPlayerConfig {
    private CacheKeyGenerator mCacheKeyGenerator;
    private HttpHeader mExtraHeader;
    private QLog mLogger;
    private NativeLibLoader mNativeLibLoader;
    private boolean mIsDebugVersion = true;
    private int mMaxMediaPlayerInstance = 3;
    private boolean mProxyEnabled = true;
    private boolean mCacheEnabled = true;
    private long mMaxCacheSizeByte = 536870912;
    private IVideoReporter mVideoReporter = null;
    private String[] mAllowedContentType = new String[0];
    private boolean mIsEnableHLSCache = true;
    private volatile boolean mSSLCertVerify = false;
    private boolean mEnableProxySecret = true;
    private int mConnectionRetryCount = 3;

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<String> getAllowedContentType() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CacheKeyGenerator getCacheKeyGenerator() {
        if (this.mCacheKeyGenerator == null) {
            this.mCacheKeyGenerator = new DefaultCacheKeyGenerator();
        }
        return this.mCacheKeyGenerator;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getConnectionRetryCount() {
        return this.mConnectionRetryCount;
    }

    public HttpHeader getGlobalExtraHeader() {
        return this.mExtraHeader;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public QLog getLogger() {
        return this.mLogger;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long getMaxCacheSizeByte() {
        return this.mMaxCacheSizeByte;
    }

    int getMaxMediaPlayerInstance() {
        return this.mMaxMediaPlayerInstance;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public NativeLibLoader getNativeLibLoader() {
        return this.mNativeLibLoader;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public IVideoReporter getVideoReporter() {
        return this.mVideoReporter;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isCacheEnabled() {
        return this.mCacheEnabled;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isDebugVersion() {
        return this.mIsDebugVersion;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isEnableHLSCache() {
        return this.mIsEnableHLSCache;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isEnableProxySecret() {
        return this.mEnableProxySecret;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isProxyEnabled() {
        return this.mProxyEnabled;
    }

    public boolean isSSLCertVerifyEnabled() {
        return this.mSSLCertVerify;
    }

    public void setAllowedContentType(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mAllowedContentType = str.split("\\|");
        }
    }

    public void setCacheKeyGenerator(CacheKeyGenerator cacheKeyGenerator) {
        this.mCacheKeyGenerator = cacheKeyGenerator;
    }

    public void setConnectionRetryCount(int i3) {
        this.mConnectionRetryCount = i3;
    }

    public void setDebugVersion(boolean z16) {
        this.mIsDebugVersion = z16;
    }

    public void setEnableCache(boolean z16) {
        this.mCacheEnabled = z16;
    }

    public void setEnableHLSCache(boolean z16) {
        this.mIsEnableHLSCache = z16;
    }

    public void setEnableProxy(boolean z16) {
        this.mProxyEnabled = z16;
    }

    public void setEnableProxySecret(boolean z16) {
        this.mEnableProxySecret = z16;
    }

    public void setEnableSSLVerify(boolean z16) {
        this.mSSLCertVerify = z16;
    }

    public void setGlobalExtraHeader(HttpHeader httpHeader) {
        this.mExtraHeader = httpHeader;
    }

    public void setLogger(QLog qLog) {
        if (this.mLogger != null) {
            Log.w("OskPlayer", "logger is modified, which is not recommended");
        }
        this.mLogger = qLog;
    }

    public void setMaxCacheSizeByte(int i3) {
        this.mMaxCacheSizeByte = i3;
    }

    public void setNativeLibLoader(NativeLibLoader nativeLibLoader) {
        this.mNativeLibLoader = nativeLibLoader;
    }

    public void setVideoReporter(IVideoReporter iVideoReporter) {
        this.mVideoReporter = iVideoReporter;
    }
}
