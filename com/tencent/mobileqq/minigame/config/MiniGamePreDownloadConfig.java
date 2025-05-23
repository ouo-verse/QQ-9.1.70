package com.tencent.mobileqq.minigame.config;

import com.tencent.freesia.IConfigData;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0002\u0011\u0012B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR&\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/minigame/config/MiniGamePreDownloadConfig;", "Lcom/tencent/freesia/IConfigData;", "()V", "checkInterval", "", "getCheckInterval", "()J", "setCheckInterval", "(J)V", "preloadMap", "", "", "Lcom/tencent/mobileqq/minigame/config/MiniGamePreDownloadConfig$DownloadConfig;", "getPreloadMap", "()Ljava/util/Map;", "setPreloadMap", "(Ljava/util/Map;)V", "Companion", "DownloadConfig", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniGamePreDownloadConfig implements IConfigData {
    public static final String CONFIG_ID = "103111";
    public static final String TAG = "MiniGamePreDownloadConfig";
    private long checkInterval = 360;
    private Map<String, DownloadConfig> preloadMap = new LinkedHashMap();

    public final long getCheckInterval() {
        return this.checkInterval;
    }

    public final Map<String, DownloadConfig> getPreloadMap() {
        return this.preloadMap;
    }

    public final void setCheckInterval(long j3) {
        this.checkInterval = j3;
    }

    public final void setPreloadMap(Map<String, DownloadConfig> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.preloadMap = map;
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\f\u001a\u00020\rH\u00d6\u0001J\t\u0010\u000e\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/minigame/config/MiniGamePreDownloadConfig$DownloadConfig;", "", "appId", "", "(Ljava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public static final /* data */ class DownloadConfig {
        private final String appId;

        public DownloadConfig(String appId) {
            Intrinsics.checkNotNullParameter(appId, "appId");
            this.appId = appId;
        }

        /* renamed from: component1, reason: from getter */
        public final String getAppId() {
            return this.appId;
        }

        public final DownloadConfig copy(String appId) {
            Intrinsics.checkNotNullParameter(appId, "appId");
            return new DownloadConfig(appId);
        }

        public final String getAppId() {
            return this.appId;
        }

        public int hashCode() {
            return this.appId.hashCode();
        }

        public String toString() {
            return "DownloadConfig(appId=" + this.appId + ")";
        }

        public static /* synthetic */ DownloadConfig copy$default(DownloadConfig downloadConfig, String str, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = downloadConfig.appId;
            }
            return downloadConfig.copy(str);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof DownloadConfig) && Intrinsics.areEqual(this.appId, ((DownloadConfig) other).appId);
        }
    }
}
