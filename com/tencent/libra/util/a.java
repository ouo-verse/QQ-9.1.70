package com.tencent.libra.util;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.libra.request.CustomDownloadRequest;
import com.tencent.libra.request.IpConnectConfig;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b&\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\bA\u0010BJ,\u0010\t\u001a\u00020\b2\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0002J(\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000b2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0002H\u0002J\u001a\u0010\u000e\u001a\u00020\b*\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005J\u001e\u0010\u0010\u001a\u00020\b*\u00020\r2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0002J\u0016\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000b*\u00020\rJ\"\u0010\u0013\u001a\u00020\b2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00022\u0006\u0010\u0012\u001a\u00020\rJ\u0014\u0010\u0015\u001a\u00020\b*\u00020\r2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003J\f\u0010\u0016\u001a\u0004\u0018\u00010\u0003*\u00020\rJ\u0012\u0010\u0019\u001a\u00020\b*\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0017J\n\u0010\u001a\u001a\u00020\u0017*\u00020\rJ\f\u0010\u001c\u001a\u0004\u0018\u00010\u001b*\u00020\rR,\u0010#\u001a\u0004\u0018\u00010\u001d*\u00020\r2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R(\u0010(\u001a\u00020\u0017*\u00020\r2\u0006\u0010\u001e\u001a\u00020\u00178F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R(\u0010+\u001a\u00020\u0017*\u00020\r2\u0006\u0010\u001e\u001a\u00020\u00178F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b)\u0010%\"\u0004\b*\u0010'R(\u00100\u001a\u00020\u0005*\u00020\r2\u0006\u0010\u001e\u001a\u00020\u00058F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R(\u00105\u001a\u00020\u0003*\u00020\r2\u0006\u0010\u001e\u001a\u00020\u00038F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b1\u00102\"\u0004\b3\u00104R(\u00106\u001a\u00020\u0017*\u00020\r2\u0006\u0010\u001e\u001a\u00020\u00178F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b6\u0010%\"\u0004\b7\u0010'R(\u0010:\u001a\u00020\u0017*\u00020\r2\u0006\u0010\u001e\u001a\u00020\u00178F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b8\u0010%\"\u0004\b9\u0010'R(\u0010=\u001a\u00020\u0017*\u00020\r2\u0006\u0010\u001e\u001a\u00020\u00178F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b;\u0010%\"\u0004\b<\u0010'R(\u0010@\u001a\u00020\u0017*\u00020\r2\u0006\u0010\u001e\u001a\u00020\u00178F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b>\u0010%\"\u0004\b?\u0010'\u00a8\u0006C"}, d2 = {"Lcom/tencent/libra/util/a;", "", "", "", "dstExtraData", "", "originWidth", "originHeight", "", "w", WadlProxyConsts.EXTRA_DATA, "Lkotlin/Pair;", h.F, "Lcom/tencent/libra/request/Option;", "u", "srcExtraData", "v", "g", "srcOption", HippyTKDListViewAdapter.X, "remoteIp", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "j", "", "enable", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "l", "Lcom/tencent/libra/request/IpConnectConfig;", "f", "Lcom/tencent/libra/request/a;", "value", "b", "(Lcom/tencent/libra/request/Option;)Lcom/tencent/libra/request/a;", DomainData.DOMAIN_NAME, "(Lcom/tencent/libra/request/Option;Lcom/tencent/libra/request/a;)V", "customDownloadRequest", "i", "(Lcom/tencent/libra/request/Option;)Z", "y", "(Lcom/tencent/libra/request/Option;Z)V", "quicEnabled", "k", "o", "isDownloadWithQuic", "e", "(Lcom/tencent/libra/request/Option;)I", ReportConstant.COSTREPORT_PREFIX, "(Lcom/tencent/libra/request/Option;I)V", "failedWithQuickCount", "a", "(Lcom/tencent/libra/request/Option;)Ljava/lang/String;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Lcom/tencent/libra/request/Option;Ljava/lang/String;)V", "customBusinessName", "isIpv4FirstIfIpv6Fail", "t", "c", "p", "enableBitmapPool", "getEnableOtherPool", "r", "enableOtherPool", "d", "setEnableMemoryCache", "enableMemoryCache", "<init>", "()V", "libra-core_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f118813a = new a();

    a() {
    }

    private final Pair<Integer, Integer> h(Map<String, Object> extraData) {
        Object obj = extraData.get("origin_width");
        Object obj2 = 0;
        if (obj == null) {
            obj = obj2;
        }
        if (obj != null) {
            int intValue = ((Integer) obj).intValue();
            Object obj3 = extraData.get("origin_height");
            if (obj3 != null) {
                obj2 = obj3;
            }
            if (obj2 != null) {
                return new Pair<>(Integer.valueOf(intValue), Integer.valueOf(((Integer) obj2).intValue()));
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }

    private final void w(Map<String, Object> dstExtraData, int originWidth, int originHeight) {
        dstExtraData.put("origin_width", Integer.valueOf(originWidth));
        dstExtraData.put("origin_height", Integer.valueOf(originHeight));
    }

    @NotNull
    public final String a(@NotNull Option customBusinessName) {
        Intrinsics.checkNotNullParameter(customBusinessName, "$this$customBusinessName");
        Object obj = customBusinessName.getExtraData().get("custom_business_name");
        if (!(obj instanceof String)) {
            obj = null;
        }
        String str = (String) obj;
        if (str == null) {
            return "";
        }
        return str;
    }

    @Nullable
    public final CustomDownloadRequest b(@NotNull Option customDownloadRequest) {
        Intrinsics.checkNotNullParameter(customDownloadRequest, "$this$customDownloadRequest");
        Object obj = customDownloadRequest.getExtraData().get("download_custom_headers");
        if (!(obj instanceof CustomDownloadRequest)) {
            obj = null;
        }
        return (CustomDownloadRequest) obj;
    }

    public final boolean c(@NotNull Option enableBitmapPool) {
        Intrinsics.checkNotNullParameter(enableBitmapPool, "$this$enableBitmapPool");
        Object obj = enableBitmapPool.getExtraData().get("enable_bitmap_pool");
        if (!(obj instanceof Boolean)) {
            obj = null;
        }
        Boolean bool = (Boolean) obj;
        if (bool != null) {
            return bool.booleanValue();
        }
        return true;
    }

    public final boolean d(@NotNull Option enableMemoryCache) {
        Intrinsics.checkNotNullParameter(enableMemoryCache, "$this$enableMemoryCache");
        Object obj = enableMemoryCache.getExtraData().get("enable_memory_cache");
        if (!(obj instanceof Boolean)) {
            obj = null;
        }
        Boolean bool = (Boolean) obj;
        if (bool != null) {
            return bool.booleanValue();
        }
        return true;
    }

    public final int e(@NotNull Option failedWithQuickCount) {
        Intrinsics.checkNotNullParameter(failedWithQuickCount, "$this$failedWithQuickCount");
        Object obj = failedWithQuickCount.getExtraData().get("failed_with_quic_count");
        if (!(obj instanceof Integer)) {
            obj = null;
        }
        Integer num = (Integer) obj;
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Nullable
    public final IpConnectConfig f(@NotNull Option getIpConnectConfig) {
        Intrinsics.checkNotNullParameter(getIpConnectConfig, "$this$getIpConnectConfig");
        Object obj = getIpConnectConfig.getExtraData().get("ip_connect_config");
        if (!(obj instanceof IpConnectConfig)) {
            obj = null;
        }
        return (IpConnectConfig) obj;
    }

    @NotNull
    public final Pair<Integer, Integer> g(@NotNull Option getOriginSize) {
        Intrinsics.checkNotNullParameter(getOriginSize, "$this$getOriginSize");
        Map<String, Object> extraData = getOriginSize.getExtraData();
        Intrinsics.checkNotNullExpressionValue(extraData, "extraData");
        return h(extraData);
    }

    public final boolean i(@NotNull Option quicEnabled) {
        Intrinsics.checkNotNullParameter(quicEnabled, "$this$quicEnabled");
        Object obj = quicEnabled.getExtraData().get("enable_quic");
        if (!(obj instanceof Boolean)) {
            obj = null;
        }
        Boolean bool = (Boolean) obj;
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    @Nullable
    public final String j(@NotNull Option getRemoteIp) {
        Intrinsics.checkNotNullParameter(getRemoteIp, "$this$getRemoteIp");
        Object obj = getRemoteIp.getExtraData().get("remote_ip");
        if (!(obj instanceof String)) {
            obj = null;
        }
        return (String) obj;
    }

    public final boolean k(@NotNull Option isDownloadWithQuic) {
        Intrinsics.checkNotNullParameter(isDownloadWithQuic, "$this$isDownloadWithQuic");
        Object obj = isDownloadWithQuic.getExtraData().get("is_download_with_quic");
        if (!(obj instanceof Boolean)) {
            obj = null;
        }
        Boolean bool = (Boolean) obj;
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public final boolean l(@NotNull Option isEnableLocalSmallBitmapFile) {
        Intrinsics.checkNotNullParameter(isEnableLocalSmallBitmapFile, "$this$isEnableLocalSmallBitmapFile");
        Object obj = isEnableLocalSmallBitmapFile.getExtraData().get("enable_local_small_bitmap_file");
        if (!(obj instanceof Boolean)) {
            obj = null;
        }
        Boolean bool = (Boolean) obj;
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public final void m(@NotNull Option customBusinessName, @NotNull String value) {
        Intrinsics.checkNotNullParameter(customBusinessName, "$this$customBusinessName");
        Intrinsics.checkNotNullParameter(value, "value");
        Map<String, Object> extraData = customBusinessName.getExtraData();
        Intrinsics.checkNotNullExpressionValue(extraData, "extraData");
        extraData.put("custom_business_name", value);
    }

    public final void n(@NotNull Option customDownloadRequest, @Nullable CustomDownloadRequest customDownloadRequest2) {
        Intrinsics.checkNotNullParameter(customDownloadRequest, "$this$customDownloadRequest");
        Map<String, Object> extraData = customDownloadRequest.getExtraData();
        Intrinsics.checkNotNullExpressionValue(extraData, "extraData");
        extraData.put("download_custom_headers", customDownloadRequest2);
    }

    public final void o(@NotNull Option isDownloadWithQuic, boolean z16) {
        Intrinsics.checkNotNullParameter(isDownloadWithQuic, "$this$isDownloadWithQuic");
        Map<String, Object> extraData = isDownloadWithQuic.getExtraData();
        Intrinsics.checkNotNullExpressionValue(extraData, "extraData");
        extraData.put("is_download_with_quic", Boolean.valueOf(z16));
    }

    public final void p(@NotNull Option enableBitmapPool, boolean z16) {
        Intrinsics.checkNotNullParameter(enableBitmapPool, "$this$enableBitmapPool");
        Map<String, Object> extraData = enableBitmapPool.getExtraData();
        Intrinsics.checkNotNullExpressionValue(extraData, "extraData");
        extraData.put("enable_bitmap_pool", Boolean.valueOf(z16));
    }

    public final void q(@NotNull Option setEnableLocalSmallBitmapFile, boolean z16) {
        Intrinsics.checkNotNullParameter(setEnableLocalSmallBitmapFile, "$this$setEnableLocalSmallBitmapFile");
        Map<String, Object> extraData = setEnableLocalSmallBitmapFile.getExtraData();
        Intrinsics.checkNotNullExpressionValue(extraData, "extraData");
        extraData.put("enable_local_small_bitmap_file", Boolean.valueOf(z16));
    }

    public final void r(@NotNull Option enableOtherPool, boolean z16) {
        Intrinsics.checkNotNullParameter(enableOtherPool, "$this$enableOtherPool");
        Map<String, Object> extraData = enableOtherPool.getExtraData();
        Intrinsics.checkNotNullExpressionValue(extraData, "extraData");
        extraData.put("enable_other_pool", Boolean.valueOf(z16));
    }

    public final void s(@NotNull Option failedWithQuickCount, int i3) {
        Intrinsics.checkNotNullParameter(failedWithQuickCount, "$this$failedWithQuickCount");
        Map<String, Object> extraData = failedWithQuickCount.getExtraData();
        Intrinsics.checkNotNullExpressionValue(extraData, "extraData");
        extraData.put("failed_with_quic_count", Integer.valueOf(i3));
    }

    public final void t(@NotNull Option isIpv4FirstIfIpv6Fail, boolean z16) {
        Intrinsics.checkNotNullParameter(isIpv4FirstIfIpv6Fail, "$this$isIpv4FirstIfIpv6Fail");
        Map<String, Object> extraData = isIpv4FirstIfIpv6Fail.getExtraData();
        Intrinsics.checkNotNullExpressionValue(extraData, "extraData");
        extraData.put("is_use_ipv4_first_after_ipv6_fail", Boolean.valueOf(z16));
    }

    public final void u(@NotNull Option setOriginSize, int i3, int i16) {
        Intrinsics.checkNotNullParameter(setOriginSize, "$this$setOriginSize");
        Map<String, Object> extraData = setOriginSize.getExtraData();
        Intrinsics.checkNotNullExpressionValue(extraData, "extraData");
        w(extraData, i3, i16);
    }

    public final void v(@NotNull Option setOriginSize, @NotNull Map<String, Object> srcExtraData) {
        Intrinsics.checkNotNullParameter(setOriginSize, "$this$setOriginSize");
        Intrinsics.checkNotNullParameter(srcExtraData, "srcExtraData");
        Pair<Integer, Integer> h16 = h(srcExtraData);
        u(setOriginSize, h16.getFirst().intValue(), h16.getSecond().intValue());
    }

    public final void x(@NotNull Map<String, Object> extraData, @NotNull Option srcOption) {
        Intrinsics.checkNotNullParameter(extraData, "extraData");
        Intrinsics.checkNotNullParameter(srcOption, "srcOption");
        Pair<Integer, Integer> g16 = g(srcOption);
        w(extraData, g16.getFirst().intValue(), g16.getSecond().intValue());
    }

    public final void y(@NotNull Option quicEnabled, boolean z16) {
        Intrinsics.checkNotNullParameter(quicEnabled, "$this$quicEnabled");
        Map<String, Object> extraData = quicEnabled.getExtraData();
        Intrinsics.checkNotNullExpressionValue(extraData, "extraData");
        extraData.put("enable_quic", Boolean.valueOf(z16));
    }

    public final void z(@NotNull Option setRemoteIp, @Nullable String str) {
        Intrinsics.checkNotNullParameter(setRemoteIp, "$this$setRemoteIp");
        Map<String, Object> extraData = setRemoteIp.getExtraData();
        Intrinsics.checkNotNullExpressionValue(extraData, "extraData");
        extraData.put("remote_ip", str);
    }
}
