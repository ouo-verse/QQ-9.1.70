package com.tencent.mobileqq.qzoneplayer.videosource;

import android.webkit.URLUtil;
import com.tencent.oskplayer.PlayerConfig;
import com.tencent.oskplayer.cache.Cache;
import com.tencent.oskplayer.cache.CacheDataSink;
import com.tencent.oskplayer.cache.CacheDataSource;
import com.tencent.oskplayer.datasource.BandwidthMeter;
import com.tencent.oskplayer.datasource.DataSource;
import com.tencent.oskplayer.datasource.DefaultBandwidthMeter;
import com.tencent.oskplayer.datasource.FileDataSource;
import com.tencent.oskplayer.proxy.DataSourceBuilder;
import com.tencent.oskplayer.proxy.HttpRetryLogic;
import com.tencent.oskplayer.proxy.VideoRequest;
import com.tencent.oskplayer.util.PassOnVideoType;
import com.tencent.oskplayer.util.PlayerUtils;

/* compiled from: P */
/* loaded from: classes35.dex */
public class g implements DataSourceBuilder {

    /* renamed from: f, reason: collision with root package name */
    private static BandwidthMeter f280114f;

    /* renamed from: a, reason: collision with root package name */
    private FileDataSource f280115a;

    /* renamed from: b, reason: collision with root package name */
    private f f280116b;

    /* renamed from: c, reason: collision with root package name */
    private Cache f280117c;

    /* renamed from: d, reason: collision with root package name */
    private CacheDataSink f280118d;

    /* renamed from: e, reason: collision with root package name */
    private VideoRequest f280119e;

    public g(Cache cache, HttpRetryLogic httpRetryLogic, VideoRequest videoRequest) {
        if (f280114f == null) {
            f280114f = new DefaultBandwidthMeter(null, null);
        }
        this.f280117c = cache;
        if (cache != null) {
            this.f280118d = new CacheDataSink(cache, PlayerConfig.g().getCacheSingleFileBytes());
        }
        f fVar = new f(PlayerConfig.USER_AGENT, new PassOnVideoType(), f280114f, httpRetryLogic, videoRequest);
        this.f280116b = fVar;
        TcUtils.setTcVideoDataSource(fVar);
        TcUtils.setTcDataSourceUtils(b.b());
        this.f280115a = new FileDataSource();
        this.f280119e = videoRequest;
    }

    @Override // com.tencent.oskplayer.proxy.DataSourceBuilder
    public DataSource build(String str, String str2) {
        this.f280116b.setLogTag(str2);
        this.f280115a.setLogTag(str2);
        CacheDataSink cacheDataSink = this.f280118d;
        if (cacheDataSink != null) {
            cacheDataSink.setLogTag(str2);
        }
        if (!URLUtil.isNetworkUrl(str)) {
            FileDataSource fileDataSource = this.f280115a;
            PlayerUtils.log(3, str2 + "TcVideoDataSourceBuilder", "play local file");
            return fileDataSource;
        }
        if (this.f280117c != null && PlayerConfig.g().isEnableCache()) {
            PlayerUtils.log(3, str2 + "TcVideoDataSourceBuilder", "local cache");
            CacheDataSource cacheDataSource = new CacheDataSource(this.f280117c, this.f280116b, this.f280115a, this.f280119e.isCacheEnabled() ? this.f280118d : null, false, false, new a());
            cacheDataSource.setLogTag(str2);
            return cacheDataSource;
        }
        f fVar = this.f280116b;
        PlayerUtils.log(5, str2 + "TcVideoDataSourceBuilder", "cache disabled");
        return fVar;
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    public class a implements CacheDataSource.EventListener {
        public a() {
        }

        @Override // com.tencent.oskplayer.cache.CacheDataSource.EventListener
        public void onCachedAttrRead(long j3) {
            PlayerConfig.g().getVideoReporter();
        }

        @Override // com.tencent.oskplayer.cache.CacheDataSource.EventListener
        public void onCachedBytesRead(long j3, long j16) {
        }

        @Override // com.tencent.oskplayer.cache.CacheDataSource.EventListener
        public void onHttpUpstreamServerCost(String str, long j3, long j16, long j17) {
        }

        @Override // com.tencent.oskplayer.cache.CacheDataSource.EventListener
        public void downloadSizeAndDuration(String str, int i3, long j3, long j16, long j17) {
        }
    }
}
