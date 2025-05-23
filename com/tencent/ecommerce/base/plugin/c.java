package com.tencent.ecommerce.base.plugin;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.avcore.jni.audiodevice.TraeConstants;
import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.base.report.api.IECDataReport;
import com.tencent.tuxmetersdk.impl.ruleengine.JsonRuleKey;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J0\u0010\b\u001a\u00020\u00072\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J(\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\t2\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u0002H\u0002J(\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u0002H\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\"\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004J6\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00042\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u0004R\u0016\u0010\u0013\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/ecommerce/base/plugin/c;", "", "", "params", "Ljava/util/HashMap;", "", "launchParams", "", "c", "", "a", "b", "", "d", "pluginVersion", "e", "extParams", "f", "Z", "isPluginLaunched", "", "J", "lastReportTime", "<init>", "()V", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static volatile boolean isPluginLaunched;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static volatile long lastReportTime;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final c f100897c = new c();

    c() {
    }

    private final Map<Object, Object> a(Map<Object, Object> params) {
        int i3;
        String str;
        QQEcommerceSdk qQEcommerceSdk = QQEcommerceSdk.INSTANCE;
        if (qQEcommerceSdk.getGlobalInternalSdk().getRuntime().isMainProcess()) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        params.put("scene", Integer.valueOf(i3));
        params.put("uin", String.valueOf(qQEcommerceSdk.getGlobalInternalSdk().getAccountManager().getCurrentAccount()));
        if (qQEcommerceSdk.getGlobalInternalSdk().getRuntime().isPublicVersion()) {
            str = "2";
        } else if (!qQEcommerceSdk.getGlobalInternalSdk().getRuntime().isDebug()) {
            str = "1";
        } else {
            str = "0";
        }
        params.put("app_env", str);
        params.put("os", "Android");
        b(params);
        return params;
    }

    private final Map<Object, Object> b(Map<Object, Object> params) {
        Map<String, String> deviceInfo = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getRuntime().getDeviceInfo();
        String str = deviceInfo.get("os_ver");
        String str2 = "";
        if (str == null) {
            str = "";
        }
        params.put("os_ver", str);
        String str3 = deviceInfo.get("brand");
        if (str3 == null) {
            str3 = "";
        }
        params.put("brand", str3);
        String str4 = deviceInfo.get(JsonRuleKey.OPERATOR);
        if (str4 == null) {
            str4 = "";
        }
        params.put(JsonRuleKey.OPERATOR, str4);
        String str5 = deviceInfo.get("app_version");
        if (str5 != null) {
            str2 = str5;
        }
        params.put("app_version", str2);
        return params;
    }

    private final void c(Map<Object, Object> params, HashMap<String, String> launchParams) {
        params.put("state", Integer.valueOf(Boolean.parseBoolean(launchParams.get("KEY_IS_PLUGIN_MODE")) ? 1 : 0));
        params.put("result_code", Integer.valueOf(Boolean.parseBoolean(launchParams.get("KEY_IS_PLUGIN_LOADED")) ? 1 : 0));
        String str = launchParams.get(TraeConstants.KEY_OPERATION);
        Object obj = "";
        if (str == null) {
            str = "";
        }
        params.put("cmd", str);
        int hashCode = str.hashCode();
        if (hashCode != -1854658139) {
            if (hashCode != -120877942) {
                if (hashCode == 72611646 && str.equals("LOGIC")) {
                    Object obj2 = (String) launchParams.get("KEY_LOGIC_TYPE");
                    if (obj2 != null) {
                        obj = obj2;
                    }
                    params.put("ext", obj);
                    return;
                }
                return;
            }
            if (str.equals("SCHME_BY_TARGET")) {
                Object obj3 = (String) launchParams.get("KEY_TARGET");
                if (obj3 != null) {
                    obj = obj3;
                }
                params.put("ext", obj);
                return;
            }
            return;
        }
        if (str.equals("SCHEME")) {
            Object obj4 = (String) launchParams.get("KEY_SCHEME");
            if (obj4 != null) {
                obj = obj4;
            }
            params.put("ext", obj);
        }
    }

    private final boolean d() {
        if (System.currentTimeMillis() - lastReportTime < 1000) {
            return true;
        }
        return false;
    }

    public final void e(@NotNull String pluginVersion, @NotNull HashMap<String, String> launchParams) {
        QQEcommerceSdk qQEcommerceSdk = QQEcommerceSdk.INSTANCE;
        if (!qQEcommerceSdk.getHasInited() || isPluginLaunched || d()) {
            return;
        }
        lastReportTime = System.currentTimeMillis();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("type", 0);
        linkedHashMap.put(HiAnalyticsConstant.BI_KEY_SDK_VER, pluginVersion);
        c(linkedHashMap, launchParams);
        a(linkedHashMap);
        IECDataReport.a.a(qQEcommerceSdk.getGlobalInternalSdk().getReporter(), "ec_quality_plugin_launch_report", linkedHashMap, false, 4, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0038, code lost:
    
        r9 = kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull(r9);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void f(@NotNull String pluginVersion, @NotNull HashMap<String, String> launchParams, @NotNull HashMap<Object, Object> extParams) {
        long j3;
        Long longOrNull;
        QQEcommerceSdk qQEcommerceSdk = QQEcommerceSdk.INSTANCE;
        if (!qQEcommerceSdk.getHasInited() || isPluginLaunched) {
            return;
        }
        isPluginLaunched = true;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("type", 1);
        linkedHashMap.put(HiAnalyticsConstant.BI_KEY_SDK_VER, pluginVersion);
        c(linkedHashMap, launchParams);
        long currentTimeMillis = System.currentTimeMillis();
        String str = launchParams.get("KEY_ENTER_TIME");
        if (str != null && longOrNull != null) {
            j3 = longOrNull.longValue();
        } else {
            j3 = currentTimeMillis;
        }
        linkedHashMap.put("cost_time", Long.valueOf(currentTimeMillis - j3));
        a(linkedHashMap);
        linkedHashMap.putAll(extParams);
        IECDataReport.a.a(qQEcommerceSdk.getGlobalInternalSdk().getReporter(), "ec_quality_plugin_launch_report", linkedHashMap, false, 4, null);
    }
}
