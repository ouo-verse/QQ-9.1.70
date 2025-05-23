package com.tencent.libra.util;

import com.tencent.biz.richframework.delegate.impl.RFWConfig;
import com.tencent.biz.richframework.delegate.util.RFWConfigExtKt;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0006\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\u0004J\u0006\u0010\t\u001a\u00020\u0004J\u0006\u0010\n\u001a\u00020\u0004J\u0006\u0010\u000b\u001a\u00020\u0004J\u0006\u0010\f\u001a\u00020\u0004J\u0006\u0010\r\u001a\u00020\u0004J\u0006\u0010\u000e\u001a\u00020\u0004J\u0006\u0010\u000f\u001a\u00020\u0004J\u0006\u0010\u0010\u001a\u00020\u0011\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/libra/util/LibraConfigUtil;", "", "()V", "disablePicLoaderAvifUseX86", "", "enableAdjustScaleLimit", "enableDnsNotTryIpv6AfterFail", "enableFullyTrustIPDirectConfigDelivered", "enableIPDirectConfigV2", "enableIpFailBlacklist", "enableIpRaceStrategy", "enablePicLoaderAvifAdjustScale", "enablePicLoaderCacheNotUseSync", "enablePicLoaderClearLogic", "enablePicLoaderDrawableCache", "isSortByInetPhotoAlternately", "maxDownloadContentLength", "", "libra-extension-base_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class LibraConfigUtil {

    @NotNull
    public static final LibraConfigUtil INSTANCE = new LibraConfigUtil();

    LibraConfigUtil() {
    }

    public final boolean disablePicLoaderAvifUseX86() {
        return RFWConfigExtKt.isInnerVerOrRemoteCfgEnabled("disable_avif_use_x86");
    }

    public final boolean enableAdjustScaleLimit() {
        return RFWConfigExtKt.isInnerVerOrRemoteCfgEnabled("enable_adjust_scale_limit");
    }

    public final boolean enableDnsNotTryIpv6AfterFail() {
        return RFWConfigExtKt.isInnerVerOrRemoteCfgEnabled("enable_dns_not_try_ipv6_connect_after_fail");
    }

    public final boolean enableFullyTrustIPDirectConfigDelivered() {
        return RFWConfig.getConfigValue("enable_fully_trust_ip_direct_config_delivered", false);
    }

    public final boolean enableIPDirectConfigV2() {
        return RFWConfigExtKt.isInnerVerOrRemoteCfgEnabled("enable_ip_direct_config_v2");
    }

    public final boolean enableIpFailBlacklist() {
        return RFWConfigExtKt.isInnerVerOrRemoteCfgEnabled("enable_ip_fail_blacklist");
    }

    public final boolean enableIpRaceStrategy() {
        return RFWConfigExtKt.isInnerVerOrRemoteCfgEnabled("enable_ip_race_strategy");
    }

    public final boolean enablePicLoaderAvifAdjustScale() {
        return RFWConfigExtKt.isInnerVerOrRemoteCfgEnabled("enable_pic_loader_avif_adjust_scale");
    }

    public final boolean enablePicLoaderCacheNotUseSync() {
        return RFWConfigExtKt.isInnerVerOrRemoteCfgEnabled("enable_picloader_cache_not_use_sync");
    }

    public final boolean enablePicLoaderClearLogic() {
        return RFWConfig.getConfigValue("enable_pic_loader_clear_logic", true);
    }

    public final boolean enablePicLoaderDrawableCache() {
        return RFWConfigExtKt.isInnerVerOrRemoteCfgEnabled("enable_pic_loader_drawable_cache");
    }

    public final boolean isSortByInetPhotoAlternately() {
        return RFWConfig.getConfigValue("enable_pic_loader_sort_by_inet_proto_alternately", true);
    }

    public final int maxDownloadContentLength() {
        return RFWConfig.getConfigValue("max_download_content_length", 104857600);
    }
}
