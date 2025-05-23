package com.tencent.oskplayer;

import android.content.Context;
import com.tencent.oskplayer.datasource.HttpHeader;
import com.tencent.oskplayer.proxy.PreloadListener;
import com.tencent.oskplayer.proxy.VideoManager;
import com.tencent.oskplayer.support.OskSupport;
import com.tencent.oskplayer.support.loader.DefaultNativeLibLoader;
import com.tencent.oskplayer.support.loader.NativeLibLoader;
import com.tencent.oskplayer.util.LogProxy;
import com.tencent.oskplayer.util.OskVideoKeyGenerator;
import com.tencent.oskplayer.util.Singleton;
import java.util.List;

/* loaded from: classes22.dex */
public class OskPlayerCore {
    private static boolean mIsInited;
    private static OskPlayerConfig sConfig;
    static final Singleton<OskPlayerCore> sSingleton = new Singleton<OskPlayerCore>() { // from class: com.tencent.oskplayer.OskPlayerCore.1
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.tencent.oskplayer.util.Singleton
        public OskPlayerCore createInstance() {
            return new OskPlayerCore();
        }
    };

    public static OskPlayerCore getInstance() {
        return sSingleton.getInstance();
    }

    public static void init(Context context, OskPlayerConfig oskPlayerConfig) {
        if (!mIsInited) {
            PlayerConfig.init(context);
            initConfig(oskPlayerConfig);
            OskSupport.init(context, new LogProxy(oskPlayerConfig.getLogger()), oskPlayerConfig.getNativeLibLoader());
            VideoManager.init(context);
            mIsInited = true;
        }
    }

    private static void initConfig(OskPlayerConfig oskPlayerConfig) {
        NativeLibLoader nativeLibLoader;
        if (oskPlayerConfig != null) {
            sConfig = oskPlayerConfig;
            PlayerConfig.g().setCacheProvider(1);
            PlayerConfig.g().setIsDebugVersion(sConfig.isDebugVersion());
            PlayerConfig.g().setEnableProxy(sConfig.isProxyEnabled());
            PlayerConfig.g().setEnableCache(sConfig.isCacheEnabled());
            PlayerConfig.g().setCacheMaxBytes(sConfig.getMaxCacheSizeByte());
            PlayerConfig.g().setVideoReporter(sConfig.getVideoReporter());
            PlayerConfig.g().setContentTypeList(sConfig.getAllowedContentType());
            PlayerConfig.g().setDataSourceMaxRetryCount(sConfig.getConnectionRetryCount());
            PlayerConfig.g().setVideoKeyGenerator(new OskVideoKeyGenerator(sConfig.getCacheKeyGenerator()));
            PlayerConfig g16 = PlayerConfig.g();
            if (oskPlayerConfig.getNativeLibLoader() == null) {
                nativeLibLoader = new DefaultNativeLibLoader();
            } else {
                nativeLibLoader = oskPlayerConfig.getNativeLibLoader();
            }
            g16.setNativeLibLoader(nativeLibLoader);
            PlayerConfig.g().setEnableHLSCache(sConfig.isEnableHLSCache());
            PlayerConfig.g().setLogger(sConfig.getLogger());
            PlayerConfig.g().setGlobalExtraHeader(sConfig.getGlobalExtraHeader());
            PlayerConfig.g().setEnableProxySecret(sConfig.isEnableProxySecret());
        }
    }

    public void addDownloadErrorListener(String str, DownloadErrorListener downloadErrorListener) {
        VideoManager.getInstance().addHttpErrorListener(str, downloadErrorListener);
    }

    public void cancelPreloadMedia() {
        VideoManager.getInstance().cancelPreloadMedia();
    }

    public OskPlayerConfig getConfig() {
        return sConfig;
    }

    public String getUrl(String str) {
        return VideoManager.getInstance().getUrl(str);
    }

    public void preloadMedia(List<String> list, int i3, long j3, PreloadListener preloadListener) {
        VideoManager.getInstance().preloadMedia(list, i3, j3, preloadListener);
    }

    public void removeDownloadErrorListener(String str) {
        VideoManager.getInstance().removeHttpErrorListener(str);
    }

    public String getUrl(String str, HttpHeader httpHeader) {
        return VideoManager.getInstance().getUrl(str, httpHeader);
    }
}
