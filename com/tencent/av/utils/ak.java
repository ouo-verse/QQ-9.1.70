package com.tencent.av.utils;

import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0007J \u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\nH\u0007J\u0018\u0010\f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\nH\u0007R \u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\u00028BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/av/utils/ak;", "", "", VipFunCallConstants.KEY_GROUP, "Lorg/json/JSONObject;", "a", "key", "", AdMetricTag.FALLBACK, "b", "", "c", "e", "", "Ljava/util/Map;", "mConfigMap", "d", "()Ljava/lang/String;", "uin", "<init>", "()V", "qqrtc-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes3.dex */
public final class ak {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final ak f76980a = new ak();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<String, JSONObject> mConfigMap = new LinkedHashMap();

    ak() {
    }

    private final JSONObject a(String group) {
        JSONObject jSONObject;
        String str = group + "_" + d();
        Map<String, JSONObject> map = mConfigMap;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        String loadAsString = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString(group, "{}");
        com.tencent.xaction.log.b.a("QAVUnitedConfigUtils", 1, "getConfigContent group: " + str + " content: " + loadAsString);
        try {
            jSONObject = new JSONObject(loadAsString);
        } catch (JSONException e16) {
            com.tencent.xaction.log.b.c("QAVUnitedConfigUtils", 1, "parse config failed! content: " + loadAsString, e16);
            jSONObject = null;
        }
        if (jSONObject != null) {
            mConfigMap.put(str, jSONObject);
        }
        return jSONObject;
    }

    @JvmStatic
    public static final long b(@NotNull String group, @NotNull String key, long fallback) {
        Intrinsics.checkNotNullParameter(group, "group");
        Intrinsics.checkNotNullParameter(key, "key");
        JSONObject a16 = f76980a.a(group);
        if (a16 == null) {
            return fallback;
        }
        return a16.optLong(key, fallback);
    }

    @JvmStatic
    public static final boolean c(@NotNull String group, @NotNull String key, boolean fallback) {
        Intrinsics.checkNotNullParameter(group, "group");
        Intrinsics.checkNotNullParameter(key, "key");
        JSONObject a16 = f76980a.a(group);
        if (a16 == null) {
            return fallback;
        }
        return a16.optBoolean(key, fallback);
    }

    private final String d() {
        String str;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            str = peekAppRuntime.getCurrentUin();
        } else {
            str = null;
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    @JvmStatic
    public static final boolean e(@NotNull String group, boolean fallback) {
        Intrinsics.checkNotNullParameter(group, "group");
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn(group, fallback);
    }
}
