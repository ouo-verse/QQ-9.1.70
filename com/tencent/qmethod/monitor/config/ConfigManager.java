package com.tencent.qmethod.monitor.config;

import android.os.Handler;
import androidx.exifinterface.media.ExifInterface;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.kandian.base.report.ReadInJoyMMapKvStorage;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.shortvideo.videotransfer.TransferConfig;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qmethod.monitor.base.PMonitorInitParam;
import com.tencent.qmethod.monitor.base.thread.ThreadManager;
import com.tencent.qmethod.monitor.base.util.NetworkUtil;
import com.tencent.qmethod.monitor.base.util.f;
import com.tencent.qmethod.monitor.base.util.h;
import com.tencent.qmethod.monitor.config.bean.ConstitutionConfig;
import com.tencent.qmethod.monitor.network.e;
import com.tencent.qmethod.monitor.report.SampleHelper;
import com.tencent.qmethod.monitor.report.base.reporter.uvreport.AppConfigReport;
import com.tencent.qmethod.pandoraex.api.q;
import com.tencent.qmethod.pandoraex.core.o;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001/B\t\b\u0002\u00a2\u0006\u0004\bJ\u0010&J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0004H\u0002J\b\u0010\u000b\u001a\u00020\u0002H\u0002J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0002J\u0018\u0010\u0011\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0018\u0010\u0012\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u001f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0019\u001a\u00020\u0016H\u0002J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u0019\u001a\u00020\u0016H\u0002J\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u0019\u001a\u00020\u0016H\u0002J\u0012\u0010!\u001a\u0004\u0018\u00010 2\u0006\u0010\u0019\u001a\u00020\u0016H\u0002J\b\u0010\"\u001a\u00020\u0002H\u0002J\u000f\u0010#\u001a\u00020\u0004H\u0000\u00a2\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\u0002H\u0000\u00a2\u0006\u0004\b%\u0010&J\u0017\u0010)\u001a\u00020\u00022\u0006\u0010(\u001a\u00020'H\u0000\u00a2\u0006\u0004\b)\u0010*J\u0017\u0010+\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\fH\u0000\u00a2\u0006\u0004\b+\u0010,R$\u00101\u001a\u0012\u0012\u0004\u0012\u00020'0-j\b\u0012\u0004\u0012\u00020'`.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0016\u00104\u001a\u00020\u00048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b2\u00103R\"\u0010<\u001a\u0002058\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u0014\u0010@\u001a\u00020=8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0014\u0010B\u001a\u00020=8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bA\u0010?R\u0014\u0010E\u001a\u00020\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0014\u0010I\u001a\u00020F8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bG\u0010H\u00a8\u0006K"}, d2 = {"Lcom/tencent/qmethod/monitor/config/ConfigManager;", "", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/qmethod/monitor/config/bean/d;", "networkConfig", "v", "t", "newConfig", "", "y", "B", "Lorg/json/JSONObject;", "data", "l", "Lcom/tencent/qmethod/monitor/config/c;", "networkRule", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, DomainData.DOMAIN_NAME, "Lorg/json/JSONArray;", "jsonArray", "", "", "j", "(Lorg/json/JSONArray;)[Ljava/lang/String;", "value", "Lcom/tencent/qmethod/monitor/config/GeneralRule;", "r", "Lcom/tencent/qmethod/monitor/config/HighFrequency;", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/qmethod/monitor/config/Silence;", "u", "Lcom/tencent/qmethod/monitor/config/CacheTime;", "o", "w", "p", "()Lcom/tencent/qmethod/monitor/config/bean/d;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "()V", "Lcom/tencent/qmethod/monitor/config/ConfigManager$a;", "listener", HippyTKDListViewAdapter.X, "(Lcom/tencent/qmethod/monitor/config/ConfigManager$a;)V", "k", "(Lorg/json/JSONObject;)Lcom/tencent/qmethod/monitor/config/c;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "a", "Ljava/util/ArrayList;", "configChangeListener", "b", "Lcom/tencent/qmethod/monitor/config/bean/d;", DownloadInfo.spKey_Config, "Lcom/tencent/qmethod/monitor/config/bean/a;", "c", "Lcom/tencent/qmethod/monitor/config/bean/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Lcom/tencent/qmethod/monitor/config/bean/a;", "setConstitutionConfig$qmethod_privacy_monitor_tencentBuglyRelease", "(Lcom/tencent/qmethod/monitor/config/bean/a;)V", "constitutionConfig", "Ljava/util/concurrent/atomic/AtomicBoolean;", "d", "Ljava/util/concurrent/atomic/AtomicBoolean;", "initFlag", "e", "hasLoadNetworkConfig", "f", "Ljava/lang/Object;", "CONFIG_LOCK", "Ljava/lang/Runnable;", "g", "Ljava/lang/Runnable;", "initConfigRunnable", "<init>", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes22.dex */
public final class ConfigManager {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static com.tencent.qmethod.monitor.config.bean.d config;

    /* renamed from: h, reason: collision with root package name */
    public static final ConfigManager f343549h = new ConfigManager();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final ArrayList<a> configChangeListener = new ArrayList<>();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static ConstitutionConfig constitutionConfig = new ConstitutionConfig(null, null, null, false, 15, null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final AtomicBoolean initFlag = new AtomicBoolean();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static final AtomicBoolean hasLoadNetworkConfig = new AtomicBoolean();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static final Object CONFIG_LOCK = new Object();

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private static final Runnable initConfigRunnable = new Runnable() { // from class: com.tencent.qmethod.monitor.config.ConfigManager$initConfigRunnable$1
        @Override // java.lang.Runnable
        public final void run() {
            h hVar = h.f343541c;
            hVar.e("ConfigManager#ConfigManager");
            List<com.tencent.qmethod.pandoraex.api.b> d16 = ConfigManager.f343549h.p().d();
            hVar.a("ConfigManager#ConfigManager", "ConfigManager#forEach");
            Iterator<T> it = d16.iterator();
            while (it.hasNext()) {
                q.v((com.tencent.qmethod.pandoraex.api.b) it.next());
            }
            SampleHelper.f343779l.v();
            h.f343541c.b("ConfigManager#forEach");
        }
    };

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qmethod/monitor/config/ConfigManager$a;", "", "Lcom/tencent/qmethod/monitor/config/bean/d;", "newConfig", "oldConfig", "", "a", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes22.dex */
    public interface a {
        void a(@NotNull com.tencent.qmethod.monitor.config.bean.d newConfig, @NotNull com.tencent.qmethod.monitor.config.bean.d oldConfig);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/qmethod/monitor/config/ConfigManager$c", "Lcom/tencent/qmethod/monitor/network/c;", "", "responseJson", "", "onSuccess", "", "errorCode", "errorMsg", "onFailure", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes22.dex */
    public static final class c implements com.tencent.qmethod.monitor.network.c {
        c() {
        }

        @Override // com.tencent.qmethod.monitor.network.c
        public void onFailure(int errorCode, @NotNull String errorMsg) {
            Intrinsics.checkParameterIsNotNull(errorMsg, "errorMsg");
            qr3.a aVar = qr3.a.f429371j;
            aVar.k("fetch_config_succ", false);
            aVar.j("fetch_config_status", String.valueOf(errorCode));
            o.c("ConfigManager", "config response onFailure=" + errorCode + " errorMsg=" + errorMsg);
        }

        @Override // com.tencent.qmethod.monitor.network.c
        public void onSuccess(@NotNull String responseJson) {
            Intrinsics.checkParameterIsNotNull(responseJson, "responseJson");
            o.a("ConfigManager", "config responseJson=" + responseJson);
            try {
                JSONObject jSONObject = new JSONObject(responseJson);
                int optInt = jSONObject.optInt("status");
                if (optInt == 0) {
                    NetworkUtil networkUtil = NetworkUtil.f343513c;
                    String optString = jSONObject.optString("data");
                    Intrinsics.checkExpressionValueIsNotNull(optString, "result.optString(\"data\")");
                    JSONObject jSONObject2 = new JSONObject(networkUtil.d(optString));
                    ConfigManager configManager = ConfigManager.f343549h;
                    com.tencent.qmethod.monitor.config.bean.d l3 = configManager.l(jSONObject2);
                    l3.n(System.currentTimeMillis());
                    String optString2 = jSONObject.optString("md5");
                    Intrinsics.checkExpressionValueIsNotNull(optString2, "result.optString(\"md5\")");
                    l3.l(optString2);
                    l3.m(l3.a());
                    if (configManager.y(l3)) {
                        com.tencent.qmethod.monitor.config.bean.d c16 = ConfigManager.b(configManager).c();
                        configManager.v(l3);
                        Iterator it = ConfigManager.c(configManager).iterator();
                        while (it.hasNext()) {
                            ((a) it.next()).a(ConfigManager.b(ConfigManager.f343549h), c16);
                        }
                        ConfigManager.f343549h.w();
                    }
                    AppConfigReport appConfigReport = AppConfigReport.f343851a;
                    String optString3 = jSONObject.optString("data");
                    Intrinsics.checkExpressionValueIsNotNull(optString3, "result.optString(\"data\")");
                    appConfigReport.k(optString3);
                } else if (optInt == 2) {
                    com.tencent.qmethod.monitor.config.bean.d dVar = new com.tencent.qmethod.monitor.config.bean.d(0L, null, null, 7, null);
                    dVar.n(System.currentTimeMillis());
                    dVar.m(dVar.a());
                    ConfigManager configManager2 = ConfigManager.f343549h;
                    if (configManager2.y(dVar)) {
                        com.tencent.qmethod.monitor.config.bean.d c17 = ConfigManager.b(configManager2).c();
                        configManager2.v(null);
                        Iterator it5 = ConfigManager.c(configManager2).iterator();
                        while (it5.hasNext()) {
                            ((a) it5.next()).a(ConfigManager.b(ConfigManager.f343549h), c17);
                        }
                        ConfigManager.f343549h.w();
                    }
                    qr3.a.f429371j.j("fetch_config_status", String.valueOf(optInt));
                } else if (optInt == 1) {
                    o.c("ConfigManager", "config ignore, code=" + optInt);
                    qr3.a.f429371j.j("fetch_config_status", String.valueOf(optInt));
                } else if (optInt == -1) {
                    String optString4 = jSONObject.optString("msg");
                    Intrinsics.checkExpressionValueIsNotNull(optString4, "result.optString(\"msg\")");
                    onFailure(optInt, optString4);
                }
                qr3.a.f429371j.k("fetch_config_succ", true);
            } catch (JSONException e16) {
                onFailure(1, e16.toString());
            }
        }
    }

    ConfigManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B() {
        JSONObject jSONObject = new JSONObject();
        com.tencent.qmethod.monitor.a aVar = com.tencent.qmethod.monitor.a.f343451h;
        jSONObject.put("uin", aVar.d(PMonitorInitParam.Property.APP_USER_ID));
        jSONObject.put("app_key", aVar.g().getAppKey());
        jSONObject.put("pid", aVar.g().getAppId());
        jSONObject.put("version", aVar.d(PMonitorInitParam.Property.APP_VERSION));
        jSONObject.put("deviceid", nr3.a.f421180b.a());
        jSONObject.put(HiAnalyticsConstant.BI_KEY_SDK_VER, "0.9.15-rc2+build.1");
        jSONObject.put("os", aVar.d(PMonitorInitParam.Property.SYS_VERSION_INT));
        jSONObject.put("manu", aVar.d(PMonitorInitParam.Property.SYS_BRAND));
        jSONObject.put("device", aVar.d(PMonitorInitParam.Property.SYS_MODEL));
        com.tencent.qmethod.monitor.config.bean.d dVar = config;
        if (dVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
        }
        jSONObject.put("md5code", dVar.getMd5());
        if (aVar.g().getDebug()) {
            o.a("ConfigManager", "config request body=" + jSONObject.toString(4));
        }
        JSONObject jSONObject2 = new JSONObject();
        NetworkUtil networkUtil = NetworkUtil.f343513c;
        String jSONObject3 = jSONObject.toString();
        Intrinsics.checkExpressionValueIsNotNull(jSONObject3, "jsonObject.toString()");
        jSONObject2.put("input", networkUtil.a(jSONObject3));
        com.tencent.qmethod.monitor.network.b.b(com.tencent.qmethod.monitor.network.b.f343747b, e.f343757e.a() + "compliance/v1/config/" + aVar.g().getAppId() + "/", jSONObject2, new c(), null, 0, 24, null);
    }

    public static final /* synthetic */ com.tencent.qmethod.monitor.config.bean.d b(ConfigManager configManager) {
        com.tencent.qmethod.monitor.config.bean.d dVar = config;
        if (dVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
        }
        return dVar;
    }

    public static final /* synthetic */ ArrayList c(ConfigManager configManager) {
        return configChangeListener;
    }

    public static final /* synthetic */ AtomicBoolean d(ConfigManager configManager) {
        return hasLoadNetworkConfig;
    }

    private final String[] j(JSONArray jsonArray) {
        Object[] plus;
        String[] strArr = new String[0];
        if (jsonArray != null && jsonArray.length() != 0) {
            int length = jsonArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                String optString = jsonArray.optString(i3);
                Intrinsics.checkExpressionValueIsNotNull(optString, "jsonArray.optString(j)");
                plus = ArraysKt___ArraysJvmKt.plus(strArr, optString);
                strArr = (String[]) plus;
            }
        }
        return strArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.qmethod.monitor.config.bean.d l(JSONObject data) {
        return k(data).g();
    }

    private final void m(JSONObject data, com.tencent.qmethod.monitor.config.c networkRule) {
        JSONArray optJSONArray = data.optJSONArray("rules");
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            int i3 = 0;
            while (i3 < length) {
                JSONObject jSONObject = optJSONArray.getJSONObject(i3);
                String module = jSONObject.optString("module");
                ConfigManager configManager = f343549h;
                String[] j3 = configManager.j(jSONObject.optJSONArray("apis"));
                JSONArray optJSONArray2 = jSONObject.optJSONArray("pages");
                String rule = jSONObject.optString(TransferConfig.ExtendParamFloats.KEY_RULE);
                String highFreq = jSONObject.optString("highFreq");
                String silence = jSONObject.optString("silence");
                JSONArray jSONArray = optJSONArray;
                String cacheTime = jSONObject.optString("cacheTime");
                if (optJSONArray2 != null) {
                    try {
                    } catch (Exception e16) {
                        o.c("ConfigManager", "dealRules error: " + e16);
                    }
                    if (optJSONArray2.length() != 0) {
                        Intrinsics.checkExpressionValueIsNotNull(module, "module");
                        fr3.d d16 = networkRule.d(module, (String[]) Arrays.copyOf(j3, j3.length));
                        Intrinsics.checkExpressionValueIsNotNull(rule, "rule");
                        GeneralRule r16 = configManager.r(rule);
                        Intrinsics.checkExpressionValueIsNotNull(highFreq, "highFreq");
                        HighFrequency s16 = configManager.s(highFreq);
                        Intrinsics.checkExpressionValueIsNotNull(silence, "silence");
                        Silence u16 = configManager.u(silence);
                        String[] j16 = configManager.j(optJSONArray2);
                        Intrinsics.checkExpressionValueIsNotNull(cacheTime, "cacheTime");
                        d16.o(r16, s16, u16, j16, configManager.o(cacheTime)).k();
                        i3++;
                        optJSONArray = jSONArray;
                    }
                }
                Intrinsics.checkExpressionValueIsNotNull(module, "module");
                fr3.b n3 = networkRule.n(module, (String[]) Arrays.copyOf(j3, j3.length));
                Intrinsics.checkExpressionValueIsNotNull(rule, "rule");
                GeneralRule r17 = configManager.r(rule);
                if (r17 != null) {
                    n3.p(r17);
                }
                Intrinsics.checkExpressionValueIsNotNull(highFreq, "highFreq");
                HighFrequency s17 = configManager.s(highFreq);
                if (s17 != null) {
                    n3.o(s17);
                }
                Intrinsics.checkExpressionValueIsNotNull(cacheTime, "cacheTime");
                CacheTime o16 = configManager.o(cacheTime);
                if (o16 != null) {
                    n3.l(o16);
                }
                Intrinsics.checkExpressionValueIsNotNull(silence, "silence");
                Silence u17 = configManager.u(silence);
                if (u17 != null) {
                    n3.q(u17);
                }
                n3.k();
                i3++;
                optJSONArray = jSONArray;
            }
        }
    }

    private final void n(JSONObject data, com.tencent.qmethod.monitor.config.c networkRule) {
        IntRange intRange;
        int first;
        int last;
        JSONObject optJSONObject = data.optJSONObject("sample");
        if (optJSONObject != null) {
            double d16 = -1;
            double optDouble = optJSONObject.optDouble("totalSampleRate", d16);
            int optInt = optJSONObject.optInt("totalMaxReport", -1);
            if (d16 != optDouble && -1 != optInt) {
                networkRule.o(ReadInJoyMMapKvStorage.NAME_DEFAULT, optDouble, optInt);
            }
            JSONArray optJSONArray = optJSONObject.optJSONArray("sceneSampleRate");
            if (optJSONArray == null || (first = (intRange = new IntRange(0, optJSONArray.length() - 1)).getFirst()) > (last = intRange.getLast())) {
                return;
            }
            while (true) {
                String optString = optJSONArray.optJSONObject(first).optString("scene");
                Intrinsics.checkExpressionValueIsNotNull(optString, "jsonArray.optJSONObject(i).optString(\"scene\")");
                networkRule.o(optString, optJSONArray.optJSONObject(first).optDouble("rate", d16), optJSONArray.optJSONObject(first).optInt("maxReport", -1));
                if (first != last) {
                    first++;
                } else {
                    return;
                }
            }
        }
    }

    private final CacheTime o(String value) {
        try {
            Locale locale = Locale.ROOT;
            Intrinsics.checkExpressionValueIsNotNull(locale, "Locale.ROOT");
            if (value != null) {
                String upperCase = value.toUpperCase(locale);
                Intrinsics.checkExpressionValueIsNotNull(upperCase, "(this as java.lang.String).toUpperCase(locale)");
                return CacheTime.valueOf(upperCase);
            }
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    private final GeneralRule r(String value) {
        GeneralRule generalRule = GeneralRule.BACK_BAN_AND_FRONT_BAN;
        if (!Intrinsics.areEqual(value, generalRule.getValue())) {
            GeneralRule generalRule2 = GeneralRule.BACK_BAN_AND_FRONT_CACHE;
            if (!Intrinsics.areEqual(value, generalRule2.getValue())) {
                GeneralRule generalRule3 = GeneralRule.BACK_BAN_AND_FRONT_NORMAL;
                if (!Intrinsics.areEqual(value, generalRule3.getValue())) {
                    GeneralRule generalRule4 = GeneralRule.BACK_CACHE_ONLY_AND_FRONT_CACHE;
                    if (!Intrinsics.areEqual(value, generalRule4.getValue())) {
                        GeneralRule generalRule5 = GeneralRule.BACK_CACHE_ONLY_AND_FRONT_NORMAL;
                        if (!Intrinsics.areEqual(value, generalRule5.getValue())) {
                            GeneralRule generalRule6 = GeneralRule.BACK_CACHE_AND_FRONT_CACHE;
                            if (!Intrinsics.areEqual(value, generalRule6.getValue())) {
                                GeneralRule generalRule7 = GeneralRule.BACK_CACHE_AND_FRONT_NORMAL;
                                if (!Intrinsics.areEqual(value, generalRule7.getValue())) {
                                    GeneralRule generalRule8 = GeneralRule.BACK_STORAGE_AND_FRONT_STORAGE;
                                    if (!Intrinsics.areEqual(value, generalRule8.getValue())) {
                                        GeneralRule generalRule9 = GeneralRule.BACK_NORMAL_AND_FRONT_NORMAL;
                                        if (!Intrinsics.areEqual(value, generalRule9.getValue())) {
                                            GeneralRule generalRule10 = GeneralRule.BACK_BAN_AND_FRONT_STORAGE;
                                            if (!Intrinsics.areEqual(value, generalRule10.getValue())) {
                                                GeneralRule generalRule11 = GeneralRule.BACK_CACHE_ONLY_AND_FRONT_STORAGE;
                                                if (!Intrinsics.areEqual(value, generalRule11.getValue())) {
                                                    return null;
                                                }
                                                return generalRule11;
                                            }
                                            return generalRule10;
                                        }
                                        return generalRule9;
                                    }
                                    return generalRule8;
                                }
                                return generalRule7;
                            }
                            return generalRule6;
                        }
                        return generalRule5;
                    }
                    return generalRule4;
                }
                return generalRule3;
            }
            return generalRule2;
        }
        return generalRule;
    }

    private final HighFrequency s(String value) {
        try {
            Locale locale = Locale.ROOT;
            Intrinsics.checkExpressionValueIsNotNull(locale, "Locale.ROOT");
            if (value != null) {
                String upperCase = value.toUpperCase(locale);
                Intrinsics.checkExpressionValueIsNotNull(upperCase, "(this as java.lang.String).toUpperCase(locale)");
                return HighFrequency.valueOf(upperCase);
            }
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    private final com.tencent.qmethod.monitor.config.bean.d t() {
        boolean z16;
        h hVar = h.f343541c;
        hVar.e("ConfigManager#getCommonSPString");
        String d16 = f.d("CONFIG_SP_KEY");
        if (d16 != null) {
            hVar.b("ConfigManager#getCommonSPString");
            if (d16.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                hVar.e("ConfigManager#convert");
                com.tencent.qmethod.monitor.a aVar = com.tencent.qmethod.monitor.a.f343451h;
                if (aVar.g().getDebug()) {
                    o.a("ConfigManager", "convert json=" + d16);
                }
                com.tencent.qmethod.monitor.config.bean.d a16 = com.tencent.qmethod.monitor.config.bean.d.INSTANCE.a(d16);
                if (a16 != null) {
                    if (aVar.g().getDebug()) {
                        o.a("ConfigManager", "success get config from local, \n " + a16);
                    }
                    hVar.b("ConfigManager#convert");
                    return a16;
                }
            }
            o.a("ConfigManager", "fail get config from local, it's empty!");
            return null;
        }
        return null;
    }

    private final Silence u(String value) {
        try {
            Locale locale = Locale.ROOT;
            Intrinsics.checkExpressionValueIsNotNull(locale, "Locale.ROOT");
            if (value != null) {
                String upperCase = value.toUpperCase(locale);
                Intrinsics.checkExpressionValueIsNotNull(upperCase, "(this as java.lang.String).toUpperCase(locale)");
                return Silence.valueOf(upperCase);
            }
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v(com.tencent.qmethod.monitor.config.bean.d networkConfig) {
        com.tencent.qmethod.monitor.a aVar = com.tencent.qmethod.monitor.a.f343451h;
        com.tencent.qmethod.monitor.config.bean.d e16 = aVar.e().e();
        if (aVar.g().getDebug()) {
            o.a("ConfigManager", "app init config = " + e16);
        }
        if (networkConfig != null) {
            e16.h(networkConfig);
        }
        config = e16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w() {
        com.tencent.qmethod.pandoraex.core.collector.utils.a.j(com.tencent.qmethod.monitor.a.f343451h.g().getContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean y(com.tencent.qmethod.monitor.config.bean.d newConfig) {
        if (!newConfig.b()) {
            o.c("ConfigManager", "try to save an invalid config, ignore it: " + newConfig);
            return false;
        }
        o.a("ConfigManager", "try to save an config, it: " + newConfig);
        f.g("CONFIG_SP_KEY", newConfig.toString());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z() {
        new Handler(ThreadManager.f343506c.a()).postDelayed(new Runnable() { // from class: com.tencent.qmethod.monitor.config.ConfigManager$startUpdateNetworkConfig$1
            @Override // java.lang.Runnable
            public final void run() {
                com.tencent.qmethod.monitor.a aVar = com.tencent.qmethod.monitor.a.f343451h;
                if (aVar.h()) {
                    ConfigManager configManager = ConfigManager.f343549h;
                    if (ConfigManager.d(configManager).compareAndSet(false, true)) {
                        configManager.x(new b());
                        aVar.k();
                        if (com.tencent.qmethod.pandoraex.core.collector.utils.a.j(aVar.g().getContext())) {
                            com.tencent.qmethod.monitor.base.util.d dVar = com.tencent.qmethod.monitor.base.util.d.f343534a;
                            if (!com.tencent.qmethod.monitor.base.util.d.c(dVar, 2, "PULL_CONFIG", 0, 4, null)) {
                                configManager.B();
                                dVar.d(2, "PULL_CONFIG");
                                return;
                            }
                        }
                        o.a("ConfigManager", "ignore config pull");
                    }
                }
            }
        }, 5000L);
    }

    public final void A() {
        h.f343541c.e("ConfigManager#convertApp");
        Iterator<T> it = com.tencent.qmethod.monitor.a.f343451h.e().f().d().iterator();
        while (it.hasNext()) {
            com.tencent.qmethod.pandoraex.core.f.e((com.tencent.qmethod.pandoraex.api.b) it.next());
        }
        h hVar = h.f343541c;
        hVar.a("ConfigManager#convertApp", "ConfigManager#postThread");
        com.tencent.qmethod.pandoraex.api.o threadExecutor = com.tencent.qmethod.monitor.a.f343451h.g().getThreadExecutor();
        if (threadExecutor != null) {
            threadExecutor.a(initConfigRunnable, 0L);
        } else {
            new Handler(ThreadManager.f343506c.a()).post(initConfigRunnable);
        }
        hVar.b("ConfigManager#postThread");
    }

    @NotNull
    public final com.tencent.qmethod.monitor.config.c k(@NotNull JSONObject data) {
        Intrinsics.checkParameterIsNotNull(data, "data");
        com.tencent.qmethod.monitor.config.c cVar = new com.tencent.qmethod.monitor.config.c();
        m(data, cVar);
        n(data, cVar);
        return cVar;
    }

    @NotNull
    public final com.tencent.qmethod.monitor.config.bean.d p() {
        AtomicBoolean atomicBoolean = initFlag;
        if (atomicBoolean.get()) {
            com.tencent.qmethod.monitor.config.bean.d dVar = config;
            if (dVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
            }
            return dVar;
        }
        synchronized (CONFIG_LOCK) {
            if (atomicBoolean.get()) {
                com.tencent.qmethod.monitor.config.bean.d dVar2 = config;
                if (dVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
                }
                return dVar2;
            }
            ConfigManager configManager = f343549h;
            configManager.v(configManager.t());
            constitutionConfig.b();
            atomicBoolean.set(true);
            com.tencent.qmethod.monitor.a.f343451h.o(new b());
            configManager.z();
            com.tencent.qmethod.monitor.config.bean.d dVar3 = config;
            if (dVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
            }
            return dVar3;
        }
    }

    @NotNull
    public final ConstitutionConfig q() {
        return constitutionConfig;
    }

    public final void x(@NotNull a listener) {
        Intrinsics.checkParameterIsNotNull(listener, "listener");
        ArrayList<a> arrayList = configChangeListener;
        if (!arrayList.contains(listener)) {
            arrayList.add(listener);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/qmethod/monitor/config/ConfigManager$b", "Lcom/tencent/qmethod/monitor/base/a;", "", "b", "", "isAgree", "a", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes22.dex */
    public static final class b implements com.tencent.qmethod.monitor.base.a {
        b() {
        }

        @Override // com.tencent.qmethod.monitor.base.a
        public void a(boolean isAgree) {
            if (isAgree) {
                ConfigManager configManager = ConfigManager.f343549h;
                if (!ConfigManager.d(configManager).get()) {
                    configManager.z();
                }
            }
        }

        @Override // com.tencent.qmethod.monitor.base.a
        public void b() {
        }
    }
}
