package com.tencent.mobileqq.webview.injector;

import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadScheduleUtil;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.ClubContentJsonTask;
import com.tencent.mobileqq.vas.ar;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateUtil;
import com.tencent.mobileqq.webview.config.DnsMappingConfigParser;
import com.tencent.mobileqq.webview.config.HardSandBoxConfigParser;
import com.tencent.mobileqq.webview.config.HtmlAgentConfigParser;
import com.tencent.mobileqq.webview.config.WVFileChooserConfig;
import com.tencent.mobileqq.webview.config.WVFileChooserConfigParser;
import com.tencent.mobileqq.webview.config.WebViewMainProcConfig;
import com.tencent.mobileqq.webview.config.WebViewMainProcConfigParser;
import com.tencent.mobileqq.webview.swift.injector.aa;
import com.tencent.mobileqq.webview.swift.injector.c;
import com.tencent.mobileqq.webview.swift.injector.v;
import com.tencent.mobileqq.webview.swift.utils.i;
import com.tencent.mobileqq.webview.util.t;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.QbSdk;
import common.config.service.QzoneConfig;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: P */
/* loaded from: classes35.dex */
public class b implements com.tencent.mobileqq.webview.swift.injector.c {

    /* renamed from: a, reason: collision with root package name */
    private static volatile boolean f313959a = false;

    /* renamed from: b, reason: collision with root package name */
    private static HtmlAgentConfigParser f313960b = null;

    /* renamed from: c, reason: collision with root package name */
    private static HardSandBoxConfigParser f313961c = null;

    /* renamed from: d, reason: collision with root package name */
    private static DnsMappingConfigParser f313962d = null;

    /* renamed from: e, reason: collision with root package name */
    private static WebViewMainProcConfig f313963e = null;

    /* renamed from: f, reason: collision with root package name */
    private static WVFileChooserConfig f313964f = null;

    /* renamed from: g, reason: collision with root package name */
    private static int f313965g = -1;

    private static WVFileChooserConfig A() {
        WVFileChooserConfig wVFileChooserConfig = f313964f;
        if (wVFileChooserConfig != null) {
            return wVFileChooserConfig;
        }
        WVFileChooserConfig loadConfig = new WVFileChooserConfigParser().loadConfig();
        f313964f = loadConfig;
        return loadConfig;
    }

    private static WebViewMainProcConfig B() {
        WebViewMainProcConfig webViewMainProcConfig = f313963e;
        if (webViewMainProcConfig != null) {
            return webViewMainProcConfig;
        }
        WebViewMainProcConfig loadConfig = new WebViewMainProcConfigParser().loadConfig();
        f313963e = loadConfig;
        return loadConfig;
    }

    private static int C() {
        if (f313965g < 0) {
            try {
                f313965g = QbSdk.getTbsVersion(BaseApplication.getContext());
            } catch (Exception e16) {
                QLog.w("ConfigInjector", 1, "ensureX5CoreVersion exception: " + e16.getMessage(), e16);
            }
            QLog.d("ConfigInjector", 1, "ensureX5CoreVersion: " + f313965g);
        }
        return f313965g;
    }

    private static DnsMappingConfigParser x() {
        DnsMappingConfigParser dnsMappingConfigParser = f313962d;
        if (dnsMappingConfigParser != null) {
            return dnsMappingConfigParser;
        }
        DnsMappingConfigParser dnsMappingConfigParser2 = new DnsMappingConfigParser();
        f313962d = dnsMappingConfigParser2;
        return dnsMappingConfigParser2;
    }

    private static HtmlAgentConfigParser y() {
        HtmlAgentConfigParser htmlAgentConfigParser = f313960b;
        if (htmlAgentConfigParser != null) {
            return htmlAgentConfigParser;
        }
        HtmlAgentConfigParser htmlAgentConfigParser2 = new HtmlAgentConfigParser();
        f313960b = htmlAgentConfigParser2;
        return htmlAgentConfigParser2;
    }

    private static HardSandBoxConfigParser z() {
        HardSandBoxConfigParser hardSandBoxConfigParser = f313961c;
        if (hardSandBoxConfigParser != null) {
            return hardSandBoxConfigParser;
        }
        HardSandBoxConfigParser hardSandBoxConfigParser2 = new HardSandBoxConfigParser();
        f313961c = hardSandBoxConfigParser2;
        return hardSandBoxConfigParser2;
    }

    public boolean D() {
        int deviceLevel = ((v) aa.k(v.class)).getDeviceLevel();
        if (deviceLevel > 3) {
            QLog.d("htmlAgent_ConfigInjector", 1, "isHtmlAgentSwitchOn false deviceLevel=", Integer.valueOf(deviceLevel));
            return false;
        }
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("webview_html_agent_switch", false);
        QLog.d("htmlAgent_ConfigInjector", 1, "isHtmlAgentSwitchOn=" + isSwitchOn, " by config");
        return isSwitchOn;
    }

    @Override // com.tencent.mobileqq.webview.swift.injector.c
    public boolean a() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            boolean isFeatureSwitchEnable = ((IFeatureRuntimeService) peekAppRuntime.getRuntimeService(IFeatureRuntimeService.class, "all")).isFeatureSwitchEnable("android_webview_ssl_proceed_switch", false);
            QLog.d("ConfigInjector", 1, "toggle canProceedWhenSSLError=" + isFeatureSwitchEnable);
            return isFeatureSwitchEnable;
        }
        QLog.w("ConfigInjector", 1, "default canProceedWhenSSLError=false");
        return false;
    }

    @Override // com.tencent.mobileqq.webview.swift.injector.c
    public boolean b() {
        return false;
    }

    @Override // com.tencent.mobileqq.webview.swift.injector.c
    public String c(String str, String str2, String str3) {
        return QzoneConfig.getInstance().getConfig(str, str2, str3);
    }

    @Override // com.tencent.mobileqq.webview.swift.injector.c
    public String d(String str, boolean z16) {
        return PreDownloadScheduleUtil.getPreDownloadPathStatic(str, "app", z16);
    }

    @Override // com.tencent.mobileqq.webview.swift.injector.c
    public List<String> e(String str) {
        List<String> b16 = x().loadConfig().b(str, 1);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("getDnsMapping ips count: ");
        sb5.append(b16 == null ? -1 : b16.size());
        QLog.d("ConfigInjector", 1, sb5.toString());
        return b16 == null ? Collections.emptyList() : b16;
    }

    @Override // com.tencent.mobileqq.webview.swift.injector.c
    public boolean f() {
        File file = new File(BaseApplication.getContext().getFilesDir(), ClubContentJsonTask.WebViewCrashJSONTask.jsonName);
        if (!file.exists()) {
            if (QLog.isColorLevel()) {
                QLog.e("ConfigInjector", 2, "no WebviewCrashReport.json exists!");
            }
            return false;
        }
        try {
            String readFileContent = FileUtils.readFileContent(file);
            if (TextUtils.isEmpty(readFileContent)) {
                return false;
            }
            JSONObject jSONObject = new JSONObject(readFileContent);
            if (jSONObject.has("group_domain") && jSONObject.has("group_strategy")) {
                String string = jSONObject.getString("group_domain");
                String string2 = jSONObject.getString("group_strategy");
                if (QLog.isColorLevel()) {
                    QLog.i("ConfigInjector", 2, "cdnCacheConfig, domain: " + string + ", strategys: " + string2);
                }
                String[] split = string.replace("[", "").replace("]", "").replace("\"", "").split(",");
                if (split.length > 0) {
                    ArrayList arrayList = new ArrayList();
                    for (String str : split) {
                        arrayList.add(str.trim());
                    }
                    i.a.f314756a.clear();
                    i.a.f314756a.addAll(arrayList);
                }
                int i3 = BaseApplication.getContext().getResources().getDisplayMetrics().widthPixels;
                String[] split2 = string2.substring(1, string2.length() - 1).split("\\],\\[");
                if (split2.length <= 0) {
                    return true;
                }
                i.a.f314757b = -1;
                for (String str2 : split2) {
                    String replace = str2.replace("[", "").replace("]", "").replace("\"", "");
                    String[] split3 = replace.split(",");
                    if (QLog.isColorLevel()) {
                        QLog.i("ConfigInjector", 2, "stragegy: " + replace);
                    }
                    if (split3.length == 3) {
                        int parseInt = Integer.parseInt(split3[0].trim());
                        int parseInt2 = Integer.parseInt(split3[1].trim());
                        if (i3 >= parseInt && i3 <= parseInt2) {
                            int parseInt3 = Integer.parseInt(split3[2]);
                            i.a.f314757b = parseInt3;
                            if (!QLog.isColorLevel()) {
                                return true;
                            }
                            QLog.i("ConfigInjector", 2, "hit stragegy, target cdn size: " + parseInt3 + ", stragegy: " + replace);
                            return true;
                        }
                    } else {
                        if (!QLog.isColorLevel()) {
                            return true;
                        }
                        QLog.e("ConfigInjector", 2, Arrays.toString(split3));
                        return true;
                    }
                }
                return true;
            }
            if (!QLog.isColorLevel()) {
                return true;
            }
            QLog.w("ConfigInjector", 2, "no cdnCacheConfig!");
            return true;
        } catch (Exception e16) {
            if (!QLog.isColorLevel()) {
                return true;
            }
            QLog.e("ConfigInjector", 2, "", e16);
            return true;
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.injector.c
    public boolean g() {
        int i3 = MobileQQ.sProcessId;
        if (i3 != 7) {
            if (i3 == 1) {
                return B().c();
            }
            return false;
        }
        boolean isSwitchOn = z().isSwitchOn(false);
        QLog.d("ConfigInjector", 1, "isHardSandBoxEnabled: " + isSwitchOn + " by config");
        return isSwitchOn;
    }

    @Override // com.tencent.mobileqq.webview.swift.injector.c
    public boolean h(String str) {
        String str2;
        try {
            str2 = new URI(str).getHost();
        } catch (URISyntaxException e16) {
            QLog.d("htmlAgent_ConfigInjector", 1, "getHost exception", e16);
            str2 = null;
        }
        if (TextUtils.isEmpty(str2)) {
            QLog.d("htmlAgent_ConfigInjector", 1, "isHtmlAgentSwitchOn=false cause host is empty");
            return false;
        }
        com.tencent.mobileqq.webview.config.c loadConfig = y().loadConfig();
        boolean D = D();
        if (D && loadConfig.b(str2)) {
            QLog.d("htmlAgent_ConfigInjector", 1, "isHtmlAgentSwitchOn=false by black host: ", str2);
            return false;
        }
        if (D || !loadConfig.c(str2)) {
            return D;
        }
        QLog.d("htmlAgent_ConfigInjector", 1, "isHtmlAgentSwitchOn=true by white host: ", str2);
        return true;
    }

    @Override // com.tencent.mobileqq.webview.swift.injector.c
    public boolean i() {
        return ar.b("shouyouye", "2024-04-18", "vas_bug_122657815").isEnable(false);
    }

    @Override // com.tencent.mobileqq.webview.swift.injector.c
    public boolean isSwitchOn(String str, boolean z16) {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn(str, z16);
    }

    @Override // com.tencent.mobileqq.webview.swift.injector.c
    public boolean j() {
        if (!f313959a) {
            f313959a = true;
            AppSetting.B = true ^ ((Boolean) t.j().b("enableOffline", Boolean.TRUE)).booleanValue();
        }
        return AppSetting.B;
    }

    @Override // com.tencent.mobileqq.webview.swift.injector.c
    public boolean k() {
        boolean z16 = B().d() && (C() > 0 || !v());
        if (QLog.isColorLevel()) {
            QLog.d("ConfigInjector", 1, "isWebViewInMainProcEnabled: " + z16);
        }
        return z16;
    }

    @Override // com.tencent.mobileqq.webview.swift.injector.c
    public boolean l() {
        int i3 = MobileQQ.sProcessId;
        if (i3 != 7) {
            if (i3 == 1) {
                return B().getFallbackOn();
            }
            return true;
        }
        boolean fallbackEnabled = z().loadConfig().getFallbackEnabled();
        QLog.d("ConfigInjector", 1, "isHardSandBoxFallbackEnabled: " + fallbackEnabled + " by config");
        return fallbackEnabled;
    }

    @Override // com.tencent.mobileqq.webview.swift.injector.c
    public boolean m() {
        boolean isSwitchOn = x().isSwitchOn(false);
        QLog.d("ConfigInjector", 1, "isDnsMappingSwitchOn: " + isSwitchOn + " by config");
        return isSwitchOn;
    }

    @Override // com.tencent.mobileqq.webview.swift.injector.c
    public String n(String str) {
        return A().b(str);
    }

    @Override // com.tencent.mobileqq.webview.swift.injector.c
    public boolean p() {
        boolean onlyFirstPage = y().loadConfig().getOnlyFirstPage();
        QLog.d("htmlAgent_ConfigInjector", 1, "isHtmlAgentSwitchOnOnlyFirstPage=", Boolean.valueOf(onlyFirstPage));
        return onlyFirstPage;
    }

    @Override // com.tencent.mobileqq.webview.swift.injector.c
    public boolean q() {
        boolean c16 = A().c();
        if (QLog.isColorLevel()) {
            QLog.d("ConfigInjector", 1, "isFileChooserExtTypeOn: " + c16);
        }
        return c16;
    }

    @Override // com.tencent.mobileqq.webview.swift.injector.c
    public boolean r() {
        try {
            File file = new File(BaseApplication.getContext().getApplicationContext().getFilesDir(), ClubContentJsonTask.WebViewCrashJSONTask.jsonName);
            if (!file.exists()) {
                return true;
            }
            JSONObject jSONObject = new JSONObject(FileUtils.readFileContent(file));
            if (jSONObject.has("offinePkgReadFromDataCache")) {
                return jSONObject.getBoolean("offinePkgReadFromDataCache");
            }
            return true;
        } catch (Exception e16) {
            if (!QLog.isColorLevel()) {
                return true;
            }
            QLog.e("ConfigInjector", 2, "parse offline globle config error!", e16);
            return true;
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.injector.c
    public boolean s() {
        int i3 = MobileQQ.sProcessId;
        if (i3 != 7) {
            if (i3 != 1) {
                return false;
            }
            WebViewMainProcConfig B = B();
            return B.d() && B.e();
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            boolean isFeatureSwitchEnable = ((IFeatureRuntimeService) peekAppRuntime.getRuntimeService(IFeatureRuntimeService.class, "all")).isFeatureSwitchEnable("webview_sandbox_toolproc_switch", false);
            QLog.d("ConfigInjector", 1, "toggle sandboxSwitchOn=" + isFeatureSwitchEnable);
            return isFeatureSwitchEnable;
        }
        boolean booleanValue = ((Boolean) t.j().b("webview_sandbox_toolproc_switch", Boolean.FALSE)).booleanValue();
        QLog.w("ConfigInjector", 1, "sp sandboxSwitchOn=" + booleanValue);
        return booleanValue;
    }

    @Override // com.tencent.mobileqq.webview.swift.injector.c
    public c.a t() {
        File file = new File(BaseApplication.getContext().getApplicationContext().getFilesDir(), ClubContentJsonTask.WebViewCrashJSONTask.jsonName);
        if (!file.exists()) {
            return null;
        }
        String readFileContent = FileUtils.readFileContent(file);
        if (TextUtils.isEmpty(readFileContent)) {
            return null;
        }
        c.a aVar = new c.a();
        try {
            JSONObject jSONObject = new JSONObject(readFileContent);
            aVar.f314604a.put(IjkMediaMeta.IJKM_KEY_SAMPLE_RATE, Integer.valueOf(jSONObject.getInt(IjkMediaMeta.IJKM_KEY_SAMPLE_RATE)));
            JSONArray jSONArray = jSONObject.getJSONArray("rules");
            int length = jSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i3);
                aVar.f314604a.put(jSONObject2.getString("distUrl"), Integer.valueOf(jSONObject2.getInt("rate")));
            }
            aVar.f314605b = jSONObject.getInt("tail_number");
            return aVar;
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.d("ConfigInjector", 2, "" + th5);
            }
            return null;
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.injector.c
    public boolean u() {
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("webview_random_skey_swtich", false);
        if (QLog.isColorLevel()) {
            QLog.i("ConfigInjector", 2, "isSkeyCutOff by config:  " + isSwitchOn);
        }
        return isSwitchOn;
    }

    @Override // com.tencent.mobileqq.webview.swift.injector.c
    public boolean v() {
        return B().getUseX5Core();
    }

    @Override // com.tencent.mobileqq.webview.swift.injector.c
    public boolean w() {
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("webview_res_sslerror_dialog", false);
        if (QLog.isColorLevel()) {
            QLog.i("ConfigInjector", 2, "isResSSLErrorDialogOn for web: " + isSwitchOn);
        }
        return isSwitchOn;
    }

    @Override // com.tencent.mobileqq.webview.swift.injector.c
    public JSONObject o(AppRuntime appRuntime, String str, boolean z16) {
        return VasUpdateUtil.getJSONFromLocal(appRuntime, str, z16, null);
    }

    @Override // com.tencent.mobileqq.webview.swift.injector.c
    public void reset() {
        f313962d = null;
        f313960b = null;
        f313961c = null;
        f313963e = null;
        f313959a = false;
    }
}
