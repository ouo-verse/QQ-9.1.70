package com.tencent.mobileqq.minigame.config;

import com.tencent.freesia.IConfigData;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u000b2\u00020\u0001:\u0002\u000b\fB\u0005\u00a2\u0006\u0002\u0010\u0002R&\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/minigame/config/MiniGameCustomLoadingConfig;", "Lcom/tencent/freesia/IConfigData;", "()V", "bgConfigMap", "", "", "Lcom/tencent/mobileqq/minigame/config/MiniGameCustomLoadingConfig$LoadingBgConfig;", "getBgConfigMap", "()Ljava/util/Map;", "setBgConfigMap", "(Ljava/util/Map;)V", "Companion", "LoadingBgConfig", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniGameCustomLoadingConfig implements IConfigData {
    public static final String CONFIG_ID = "102851";
    private Map<String, LoadingBgConfig> bgConfigMap = new LinkedHashMap();

    public final Map<String, LoadingBgConfig> getBgConfigMap() {
        return this.bgConfigMap;
    }

    public final void setBgConfigMap(Map<String, LoadingBgConfig> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.bgConfigMap = map;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\n\u001a\u00020\u0003H\u00c6\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001J\t\u0010\u0011\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/minigame/config/MiniGameCustomLoadingConfig$LoadingBgConfig;", "", "loadingBgImgUrl", "", "landscapeLoadingBgImgUrl", "(Ljava/lang/String;Ljava/lang/String;)V", "getLandscapeLoadingBgImgUrl", "()Ljava/lang/String;", "getLoadingBgImgUrl", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public static final /* data */ class LoadingBgConfig {
        private final String landscapeLoadingBgImgUrl;
        private final String loadingBgImgUrl;

        public LoadingBgConfig(String loadingBgImgUrl, String landscapeLoadingBgImgUrl) {
            Intrinsics.checkNotNullParameter(loadingBgImgUrl, "loadingBgImgUrl");
            Intrinsics.checkNotNullParameter(landscapeLoadingBgImgUrl, "landscapeLoadingBgImgUrl");
            this.loadingBgImgUrl = loadingBgImgUrl;
            this.landscapeLoadingBgImgUrl = landscapeLoadingBgImgUrl;
        }

        /* renamed from: component1, reason: from getter */
        public final String getLoadingBgImgUrl() {
            return this.loadingBgImgUrl;
        }

        /* renamed from: component2, reason: from getter */
        public final String getLandscapeLoadingBgImgUrl() {
            return this.landscapeLoadingBgImgUrl;
        }

        public final LoadingBgConfig copy(String loadingBgImgUrl, String landscapeLoadingBgImgUrl) {
            Intrinsics.checkNotNullParameter(loadingBgImgUrl, "loadingBgImgUrl");
            Intrinsics.checkNotNullParameter(landscapeLoadingBgImgUrl, "landscapeLoadingBgImgUrl");
            return new LoadingBgConfig(loadingBgImgUrl, landscapeLoadingBgImgUrl);
        }

        public final String getLandscapeLoadingBgImgUrl() {
            return this.landscapeLoadingBgImgUrl;
        }

        public final String getLoadingBgImgUrl() {
            return this.loadingBgImgUrl;
        }

        public int hashCode() {
            return (this.loadingBgImgUrl.hashCode() * 31) + this.landscapeLoadingBgImgUrl.hashCode();
        }

        public String toString() {
            return "LoadingBgConfig(loadingBgImgUrl=" + this.loadingBgImgUrl + ", landscapeLoadingBgImgUrl=" + this.landscapeLoadingBgImgUrl + ")";
        }

        public static /* synthetic */ LoadingBgConfig copy$default(LoadingBgConfig loadingBgConfig, String str, String str2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = loadingBgConfig.loadingBgImgUrl;
            }
            if ((i3 & 2) != 0) {
                str2 = loadingBgConfig.landscapeLoadingBgImgUrl;
            }
            return loadingBgConfig.copy(str, str2);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LoadingBgConfig)) {
                return false;
            }
            LoadingBgConfig loadingBgConfig = (LoadingBgConfig) other;
            return Intrinsics.areEqual(this.loadingBgImgUrl, loadingBgConfig.loadingBgImgUrl) && Intrinsics.areEqual(this.landscapeLoadingBgImgUrl, loadingBgConfig.landscapeLoadingBgImgUrl);
        }
    }
}
