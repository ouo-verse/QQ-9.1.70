package com.tencent.oskplayer.datasource;

import android.webkit.URLUtil;
import com.tencent.oskplayer.PlayerConfig;
import com.tencent.oskplayer.cache.Cache;
import com.tencent.oskplayer.cache.CacheDataSink;
import com.tencent.oskplayer.cache.CacheDataSource;
import com.tencent.oskplayer.proxy.DataSourceBuilder;
import com.tencent.oskplayer.proxy.HttpRetryLogic;
import com.tencent.oskplayer.proxy.VideoRequest;
import com.tencent.oskplayer.util.PassOnVideoType;
import com.tencent.oskplayer.util.PlayerUtils;

/* compiled from: P */
/* loaded from: classes22.dex */
public class DefaultDataSourceBuilder implements DataSourceBuilder {
    private static final String TAG = "DefaultDataSourceBuilder";
    private static BandwidthMeter bandwidthMeter;
    private Cache cache;
    private CacheDataSink cacheDataSink;
    private FileDataSource fileDataSource;
    private DefaultHttpDataSource httpTransport;
    private VideoRequest mVideoRequest;

    public DefaultDataSourceBuilder(Cache cache, HttpRetryLogic httpRetryLogic, VideoRequest videoRequest) {
        if (bandwidthMeter == null) {
            bandwidthMeter = new DefaultBandwidthMeter(null, null);
        }
        this.httpTransport = new NiceHttpDataSource(PlayerConfig.USER_AGENT, new PassOnVideoType(), bandwidthMeter, httpRetryLogic, videoRequest.getContentTypeFixer(), videoRequest);
        this.fileDataSource = new FileDataSource();
        this.cache = cache;
        if (cache != null) {
            this.cacheDataSink = new CacheDataSink(cache, PlayerConfig.g().getCacheSingleFileBytes());
        }
        this.mVideoRequest = videoRequest;
    }

    public static BandwidthMeter getBandwidthMeter() {
        return bandwidthMeter;
    }

    @Override // com.tencent.oskplayer.proxy.DataSourceBuilder
    public DataSource build(String str, String str2) {
        DataSource dataSource;
        CacheDataSink cacheDataSink;
        this.httpTransport.setLogTag(str2);
        CacheDataSink cacheDataSink2 = this.cacheDataSink;
        if (cacheDataSink2 != null) {
            cacheDataSink2.setLogTag(str2);
        }
        this.fileDataSource.setLogTag(str2);
        boolean z16 = !URLUtil.isNetworkUrl(str);
        boolean isAssetsUri = PlayerUtils.isAssetsUri(str);
        boolean isRawResourceUri = PlayerUtils.isRawResourceUri(str);
        if (isAssetsUri) {
            AssetDataSource assetDataSource = new AssetDataSource(PlayerConfig.g().getAppContext());
            assetDataSource.setLogTag(str2);
            return assetDataSource;
        }
        if (isRawResourceUri) {
            RawResourceDataSource rawResourceDataSource = new RawResourceDataSource(PlayerConfig.g().getAppContext());
            rawResourceDataSource.setLogTag(str2);
            return rawResourceDataSource;
        }
        if (z16) {
            dataSource = this.fileDataSource;
            PlayerUtils.log(3, str2 + TAG, "play local file");
        } else {
            if (this.cache != null && PlayerConfig.g().isEnableCache()) {
                CacheEventListener cacheEventListener = new CacheEventListener();
                Cache cache = this.cache;
                DefaultHttpDataSource defaultHttpDataSource = this.httpTransport;
                FileDataSource fileDataSource = this.fileDataSource;
                if (this.mVideoRequest.isCacheEnabled()) {
                    cacheDataSink = this.cacheDataSink;
                } else {
                    cacheDataSink = null;
                }
                CacheDataSource cacheDataSource = new CacheDataSource(cache, defaultHttpDataSource, fileDataSource, cacheDataSink, false, true, cacheEventListener);
                cacheDataSource.setLogTag(str2);
                return cacheDataSource;
            }
            dataSource = this.httpTransport;
            PlayerUtils.log(5, str2 + TAG, "cache disabled");
        }
        return dataSource;
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class CacheEventListener implements CacheDataSource.EventListener {
        public CacheEventListener() {
        }

        @Override // com.tencent.oskplayer.cache.CacheDataSource.EventListener
        public void downloadSizeAndDuration(String str, int i3, long j3, long j16, long j17) {
            if (PlayerConfig.g().getVideoReporter() != null) {
                PlayerConfig.g().getVideoReporter().downloadSizeAndDuration(str, i3, j3, j16, j17);
            }
        }

        @Override // com.tencent.oskplayer.cache.CacheDataSource.EventListener
        public void onCachedAttrRead(long j3) {
            if (PlayerConfig.g().getVideoReporter() != null) {
                PlayerConfig.g().getVideoReporter().preLoadOccurred(null, j3);
            }
        }

        @Override // com.tencent.oskplayer.cache.CacheDataSource.EventListener
        public void onHttpUpstreamServerCost(String str, long j3, long j16, long j17) {
            if (PlayerConfig.g().getVideoReporter() != null) {
                PlayerConfig.g().getVideoReporter().downloadServerCost(str, j3, j16, j17);
            }
        }

        @Override // com.tencent.oskplayer.cache.CacheDataSource.EventListener
        public void onCachedBytesRead(long j3, long j16) {
        }
    }
}
