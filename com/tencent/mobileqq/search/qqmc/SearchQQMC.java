package com.tencent.mobileqq.search.qqmc;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.qphone.base.util.QLog;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import jp2.a;
import jp2.b;
import jp2.c;
import jp2.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0016\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J3\u0010\u000b\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00072\u0006\u0010\b\u001a\u00020\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\t2\u0006\u0010\u0005\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ#\u0010\u000b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00072\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00028\u0000\u00a2\u0006\u0004\b\u000b\u0010\rJ\u0006\u0010\u000f\u001a\u00020\u000eJ\u0006\u0010\u0011\u001a\u00020\u0010J\u0006\u0010\u0013\u001a\u00020\u0012J\u0006\u0010\u0014\u001a\u00020\u0004R\u0014\u0010\u0015\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/search/qqmc/SearchQQMC;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", VipFunCallConstants.KEY_GROUP, "", AdMetricTag.FALLBACK, "isSwitchOn", "T", "groupId", "Ljava/lang/Class;", "configClass", "getConfig", "(Ljava/lang/String;Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Object;", "(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "Ljp2/a;", "getDefaultSingleModeConfig", "Ljp2/b;", "getSearchDirectPageJumpControlConfig", "Ljp2/d;", "enableSearchTux", "enableFilterTempConversation", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes18.dex */
public final class SearchQQMC implements QRouteApi {

    @NotNull
    public static final SearchQQMC INSTANCE = new SearchQQMC();

    @NotNull
    private static final String TAG = "SearchQQMC";

    SearchQQMC() {
    }

    public final boolean enableFilterTempConversation() {
        return ((c) getConfig("search_filter_temp_conversation", new c())).getEnable();
    }

    @NotNull
    public final d enableSearchTux() {
        return (d) getConfig("search_tux_control", new d());
    }

    @Nullable
    public final <T> T getConfig(@NotNull String groupId, @NotNull Class<T> configClass, @NotNull String fallback) {
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        Intrinsics.checkNotNullParameter(configClass, "configClass");
        Intrinsics.checkNotNullParameter(fallback, "fallback");
        IUnitedConfigManager iUnitedConfigManager = (IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class);
        byte[] bytes = fallback.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        byte[] loadRawConfig = iUnitedConfigManager.loadRawConfig(groupId, bytes);
        if (loadRawConfig == null) {
            return null;
        }
        Charset UTF_8 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
        try {
            return (T) GsonUtil.f283677a.a().fromJson(new String(loadRawConfig, UTF_8), (Class) configClass);
        } catch (JsonSyntaxException e16) {
            QLog.e(TAG, 1, "parse fail. ", e16);
            return null;
        }
    }

    @NotNull
    public final a getDefaultSingleModeConfig() {
        return (a) getConfig("search_result_page_multiple_selected_button_style", new a());
    }

    @NotNull
    public final b getSearchDirectPageJumpControlConfig() {
        return (b) getConfig("search_direct_page_jump_control", new b());
    }

    public final boolean isSwitchOn(@NotNull String group, boolean fallback) {
        Intrinsics.checkNotNullParameter(group, "group");
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn(group, fallback);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T> T getConfig(@NotNull String groupId, T fallback) {
        byte[] bArr;
        Object obj;
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        try {
            bArr = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadRawConfig(groupId, new byte[0]);
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "loadRawConfig " + groupId + " fail.", th5);
            bArr = null;
        }
        if (bArr == null) {
            return fallback;
        }
        if (bArr.length == 0) {
            return fallback;
        }
        Charset UTF_8 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
        String str = new String(bArr, UTF_8);
        try {
            if (fallback instanceof Integer) {
                obj = Integer.valueOf(Integer.parseInt(str));
            } else if (fallback instanceof Long) {
                obj = Long.valueOf(Long.parseLong(str));
            } else if (fallback instanceof Boolean) {
                obj = Boolean.valueOf(Boolean.parseBoolean(str));
            } else {
                Gson a16 = GsonUtil.f283677a.a();
                Intrinsics.checkNotNull(fallback);
                obj = a16.fromJson(str, (Class<Object>) fallback.getClass());
            }
            return obj;
        } catch (Throwable th6) {
            QLog.e(TAG, 1, "parse config " + groupId + " fail. content:" + str, th6);
            return fallback;
        }
    }
}
