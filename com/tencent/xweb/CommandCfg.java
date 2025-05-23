package com.tencent.xweb;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.luggage.wxa.ar.a0;
import com.tencent.luggage.wxa.ar.h;
import com.tencent.luggage.wxa.ar.j;
import com.tencent.luggage.wxa.ar.l0;
import com.tencent.luggage.wxa.ar.n0;
import com.tencent.luggage.wxa.ar.v0;
import com.tencent.luggage.wxa.ar.x0;
import com.tencent.luggage.wxa.ar.y0;
import com.tencent.qqlive.tvkplayer.report.capability.spatialaudio.TVKDeviceSpatialAudioCapabilityReportConstant;
import com.tencent.xweb.WebView;
import com.tencent.xweb.XWebSdk;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.xwalk.core.XWalkEnvironment;

/* compiled from: P */
/* loaded from: classes27.dex */
public class CommandCfg {

    /* renamed from: b, reason: collision with root package name */
    public static int f384888b = 0;

    /* renamed from: c, reason: collision with root package name */
    public static String f384889c = "";

    /* renamed from: d, reason: collision with root package name */
    public static CommandCfg f384890d;

    /* renamed from: a, reason: collision with root package name */
    public Map f384891a = new HashMap();

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class CmdHandleRet {
        public boolean handled = false;
        public Object handleRet = null;
    }

    public static synchronized CommandCfg getInstance() {
        CommandCfg commandCfg;
        synchronized (CommandCfg.class) {
            if (f384890d == null) {
                CommandCfg commandCfg2 = new CommandCfg();
                f384890d = commandCfg2;
                commandCfg2.initCommandConfigs();
            }
            commandCfg = f384890d;
        }
        return commandCfg;
    }

    public static synchronized void resetCommandCfg() {
        synchronized (CommandCfg.class) {
            x0.d("CommandCfg", "resetCommandCfg, module: " + XWalkEnvironment.getSafeModuleName(""));
            f384890d = null;
            getInstance();
        }
    }

    public final boolean a(SharedPreferences sharedPreferences) {
        String string;
        return sharedPreferences != null && sharedPreferences.contains("cStrSpKeyConfigsReady") && (string = sharedPreferences.getString("cStrSpKeyConfigsReady", "")) != null && string.equalsIgnoreCase("true");
    }

    public synchronized void applyCommand(j[] jVarArr, String str) {
        applyCommand(jVarArr, str, false);
    }

    public String b() {
        return "CommandCfg";
    }

    public Map c(String str) {
        String str2;
        String str3;
        HashMap hashMap = new HashMap();
        if (str != null && !str.isEmpty()) {
            for (String str4 : str.split("~~~")) {
                if (str4 != null && !str4.isEmpty()) {
                    String[] split = str4.split("```");
                    if (split.length == 2 && (str2 = split[0]) != null && (str3 = split[1]) != null) {
                        hashMap.put(str2, str3);
                    }
                }
            }
        }
        return hashMap;
    }

    public boolean d(String str) {
        if ("revertToVersion".equals(str)) {
            return true;
        }
        return false;
    }

    public synchronized String dumpCmds() {
        StringBuilder sb5 = new StringBuilder(512);
        Set<String> keySet = this.f384891a.keySet();
        sb5.append(" config version = " + f384889c + "\n");
        sb5.append(" config sdk version = " + f384888b + "\n");
        if (keySet == null) {
            return sb5.toString();
        }
        for (String str : keySet) {
            if (!TextUtils.isEmpty(str)) {
                String a16 = a(getCommandMap(str));
                if (a16 == null) {
                    a16 = "";
                }
                sb5.append(" [" + str + "] = ");
                sb5.append(a16);
                sb5.append("\n");
            }
        }
        return sb5.toString();
    }

    public String getAbstractInfo() {
        try {
            return dumpCmds();
        } catch (Throwable th5) {
            x0.a(b(), "getAbstractInfo error", th5);
            return "";
        }
    }

    public int getChildProcessStartTimeOutCount() {
        return getCmdAsInt("child_process_start_timeout_count", "mm", 2);
    }

    public int getChildProcessStartTimeOutThreshold() {
        return getCmdAsInt("child_process_start_timeout_threshold", "mm", 50);
    }

    public synchronized String getCmd(String str) {
        String moduleName;
        moduleName = WebView.getModuleName();
        if (TextUtils.isEmpty(moduleName)) {
            moduleName = "tools";
        }
        return getCmd(str, moduleName);
    }

    public synchronized boolean getCmdAsBoolean(String str, String str2, boolean z16) {
        String a16 = a(str, str2);
        if (TextUtils.isEmpty(a16)) {
            return z16;
        }
        if ("true".equalsIgnoreCase(a16)) {
            return true;
        }
        if ("false".equalsIgnoreCase(a16)) {
            return false;
        }
        return z16;
    }

    public synchronized int getCmdAsInt(String str, String str2, int i3) {
        String a16 = a(str, str2);
        if (TextUtils.isEmpty(a16)) {
            return i3;
        }
        a0.a c16 = a0.c(a16);
        if (c16 != null && c16.f121611a) {
            return c16.b();
        }
        return i3;
    }

    public synchronized String getCmdAsString(String str, String str2, String str3) {
        String a16;
        a16 = a(str, str2);
        if (TextUtils.isEmpty(a16)) {
            return str3;
        }
        return a16;
    }

    public int getCmdFetchConfigPeriodMills() {
        try {
            String cmd = getCmd("setConfigPeriod", "tools");
            if (cmd != null && !cmd.isEmpty()) {
                int parseInt = Integer.parseInt(cmd);
                if (parseInt < 30) {
                    return -1;
                }
                return parseInt * 60 * 1000;
            }
            return -1;
        } catch (Throwable th5) {
            x0.a(b(), "getCmdFetchConfigPeriodMills, error", th5);
            return -1;
        }
    }

    public synchronized Map<String, String> getCommandMap(String str) {
        return a(str, this.f384891a);
    }

    public String getConfigVersion() {
        return f384889c;
    }

    public boolean getDisableChildProcessStartCrashCount() {
        return getCmdAsBoolean("disable_child_process_start_crash_count", "mm", false);
    }

    public boolean getDisableChildProcessStartTimeOut() {
        return getCmdAsBoolean("disable_child_process_start_timeout", "mm", false);
    }

    public boolean getEnableCheckStorage() {
        return getCmdAsBoolean("enable_check_storage", "tools", false);
    }

    public boolean getEnableThirdAppReport() {
        String cmd = getCmd("third_app_report", "tools");
        boolean z16 = false;
        if (cmd != null && !cmd.equalsIgnoreCase("")) {
            String[] split = cmd.split(",");
            if (split.length > 0) {
                String valueOf = String.valueOf(v0.b());
                int length = split.length;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        break;
                    }
                    if (valueOf.endsWith(split[i3])) {
                        z16 = true;
                        break;
                    }
                    i3++;
                }
            }
        }
        x0.d("CommandCfg", "getEnableThirdAppReport, result:" + z16 + ", data:" + cmd + ", grayValue:" + v0.b());
        return z16;
    }

    public String getEnabledTraceCategory(String str) {
        return getCmd("setEnabledTraceCategory", str);
    }

    public boolean getFullscreenVideoEnableInitChannelsTryRuntime() {
        return getCmdAsBoolean("fullscreen_video_enable_init_channels_try_runtime", "tools", true);
    }

    public boolean getFullscreenVideoEnableMute() {
        return getCmdAsBoolean("fullscreen_video_enable_mute", "tools", false);
    }

    public boolean getFullscreenVideoEnableSpeed() {
        return getCmdAsBoolean("fullscreen_video_enable_speed", "tools", false);
    }

    public boolean getFullscreenVideoEnableSysTryRuntime() {
        return getCmdAsBoolean("fullscreen_video_enable_sys_try_runtime", "tools", true);
    }

    public WebView.FullscreenVideoKind getFullscreenVideoKind(String str) {
        return a(getCmd("setfullscreenvideo", str));
    }

    public int getMMWebViewDowngradeMode() {
        return getCmdAsInt("mm_webview_downgrade_mode", "mm", XWebSdk.WebViewModeForMM.DISABLE_MULTI_PROCESS.ordinal());
    }

    public int getMinApkVersionForNewDataDir() {
        return getCmdAsInt("min_apk_version_for_new_data_dir", "tools", -1);
    }

    public String getMinApkVersionIgnoreList() {
        return getCmd("min_apk_version_ignore_list", "tools");
    }

    public SharedPreferences getSharePreferenceForCommandConfig() {
        return y0.b();
    }

    public SharedPreferences getSharePreferenceForCommandConfigLatest() {
        return y0.c();
    }

    public int getSupportMultiProcessMinApkVersion() {
        return getCmdAsInt("min_apk_version_for_multi_process", "tools", -1);
    }

    public int getTraceRatioInTenThousand(String str) {
        String cmd = getCmd("setTraceSampleRatioInTenThousand", str);
        if (!TextUtils.isEmpty(cmd) && TextUtils.isDigitsOnly(cmd)) {
            return Integer.parseInt(cmd);
        }
        return 0;
    }

    public WebView.WebViewKind getWebKind(String str) {
        return b(getCmd("setwebtype", str));
    }

    public int getWebViewModeCommandForMM() {
        return getCmdAsInt("mm_webview_mode", "mm", getMMWebViewDowngradeMode());
    }

    public boolean getWxdkDowngrade() {
        return getCmdAsBoolean("mm_wxdk_downgrade", "mm", true);
    }

    public synchronized void initCommandConfigs() {
        x0.d(b(), "initCommandConfigs start");
        this.f384891a.clear();
        SharedPreferences sharePreferenceForCommandConfigLatest = getSharePreferenceForCommandConfigLatest();
        if (!a(sharePreferenceForCommandConfigLatest)) {
            sharePreferenceForCommandConfigLatest = getSharePreferenceForCommandConfig();
            if (!a(sharePreferenceForCommandConfigLatest)) {
                x0.f(b(), "initCommandConfigs, section A and B both not ready!!!");
                n0.a(1749L, 46L, 1L);
            } else {
                x0.d(b(), "initCommandConfigs, section A is ready");
                n0.a(1749L, 47L, 1L);
            }
        } else {
            x0.d(b(), "initCommandConfigs, section B is ready");
            n0.a(1749L, 48L, 1L);
        }
        f384889c = sharePreferenceForCommandConfigLatest.getString("cStrTAGConfigVer", "");
        Map<String, ?> all = sharePreferenceForCommandConfigLatest.getAll();
        if (all != null && all.size() != 0) {
            Iterator<Map.Entry<String, ?>> it = all.entrySet().iterator();
            while (it.hasNext()) {
                String key = it.next().getKey();
                String string = sharePreferenceForCommandConfigLatest.getString(key, "");
                if (key != null && string != null) {
                    Map c16 = c(string);
                    if (c16 != null && c16.size() != 0) {
                        this.f384891a.put(key, c16);
                    }
                    this.f384891a.put(key, string);
                }
            }
            x0.d(b(), "initCommandConfigs end, config version:" + f384889c + ", config map size:" + this.f384891a.size());
            return;
        }
        x0.d(b(), "initCommandConfigs end, empty command configs");
    }

    public boolean isVersionInMinApkVersionIgnoreList(int i3) {
        String cmd = getCmd("min_apk_version_ignore_list", "tools");
        boolean z16 = false;
        if (cmd != null && !cmd.equalsIgnoreCase("")) {
            String[] split = cmd.split(",");
            if (split.length > 0) {
                String valueOf = String.valueOf(i3);
                int length = split.length;
                int i16 = 0;
                while (true) {
                    if (i16 >= length) {
                        break;
                    }
                    if (valueOf.equals(split[i16])) {
                        z16 = true;
                        break;
                    }
                    i16++;
                }
            }
        }
        x0.d("CommandCfg", "isVersionInMinApkVersionIgnoreList, result:" + z16 + ", version:" + i3 + ", data:" + cmd);
        return z16;
    }

    public String[] parseOpValue(String str) {
        String[] strArr = new String[2];
        if (str != null && str.contains(":")) {
            int indexOf = str.indexOf(58);
            strArr[0] = str.substring(0, indexOf);
            if (str.length() - 1 <= indexOf) {
                strArr[1] = "";
            } else {
                strArr[1] = str.substring(indexOf + 1);
            }
            return strArr;
        }
        return null;
    }

    public void setCommandForTest(String str, String str2) {
        synchronized (this) {
            if (this.f384891a == null) {
                this.f384891a = new HashMap();
            }
            HashMap hashMap = new HashMap();
            hashMap.put("tools", str2);
            hashMap.put("appbrand", str2);
            hashMap.put(TVKDeviceSpatialAudioCapabilityReportConstant.SPATIAL_AUDIO_CAPABILITY_PARAM_SURPPORT, str2);
            hashMap.put("mm", str2);
            this.f384891a.put(str, hashMap);
        }
    }

    public synchronized void applyCommand(j[] jVarArr, String str, boolean z16) {
        a(jVarArr, str, z16);
    }

    public synchronized void b(String str, Map map) {
        Object value;
        SharedPreferences.Editor edit = getSharePreferenceForCommandConfigLatest().edit();
        edit.putString("cStrSpKeyConfigsReady", "false");
        edit.commit();
        a(map, getSharePreferenceForCommandConfigLatest());
        edit.putString("cStrTAGConfigVer", str);
        edit.putString("cStrTAGConfigSdkVer", String.valueOf(XWebSdk.getXWebSdkVersion()));
        if (map != null && map.isEmpty()) {
            x0.f(b(), "saveCommandConfigs, new command configs is empty");
        }
        for (Map.Entry entry : map.entrySet()) {
            if (entry.getKey() != null && !((String) entry.getKey()).isEmpty() && (value = entry.getValue()) != null) {
                if (value instanceof Map) {
                    try {
                        edit.putString((String) entry.getKey(), a((Map) value));
                    } catch (Throwable unused) {
                        edit.putString((String) entry.getKey(), value.toString());
                        x0.d(b(), "saveCommandConfigs error, command:" + ((String) entry.getKey()) + ", map:" + value);
                    }
                } else {
                    edit.putString((String) entry.getKey(), value.toString());
                }
            }
        }
        edit.putString("cStrSpKeyConfigsReady", "true");
        boolean commit = edit.commit();
        if (commit) {
            f384889c = str;
            this.f384891a = map;
        }
        x0.d(b(), "saveCommandConfigs, result:" + commit + ", sp size:" + getSharePreferenceForCommandConfigLatest().getAll().size());
    }

    public synchronized void a(j[] jVarArr, String str, boolean z16) {
        String str2;
        if (str == null) {
            x0.d(b(), "applyCommandInternal, invalid configVersion");
            return;
        }
        x0.d(b(), "applyCommandInternal, configVersion:" + str + ", isRecheck:" + z16);
        a();
        HashMap hashMap = new HashMap();
        if (jVarArr != null && jVarArr.length != 0) {
            for (int i3 = 0; i3 < jVarArr.length; i3++) {
                j jVar = jVarArr[i3];
                if (jVar != null && (!z16 || !d(jVar.f121670b))) {
                    x0.d(b(), ">>> applyCommand, command[" + i3 + "]:" + jVarArr[i3]);
                    if (jVarArr[i3].f121669a.a(false, false, "CommandCfg")) {
                        CmdHandleRet a16 = h.a(jVarArr[i3]);
                        if (a16 != null && a16.handled) {
                            x0.d(b(), "<<< applyCommand, command[" + i3 + "] handled");
                        } else {
                            j jVar2 = jVarArr[i3];
                            if (jVar2.f121671c != null && (str2 = jVar2.f121672d) != null && !str2.isEmpty()) {
                                boolean a17 = a(jVarArr[i3], hashMap, jVarArr[i3].f121672d.split(","));
                                x0.f(b(), "<<< applyCommand, apply command[" + i3 + "]:" + a17);
                            }
                        }
                    } else {
                        x0.f(b(), "<<< applyCommand, command[" + i3 + "] not match");
                    }
                }
            }
            b(str, hashMap);
            return;
        }
        x0.f(b(), "applyCommandInternal, empty new command configs");
        b(str, hashMap);
    }

    public synchronized String getCmd(String str, String str2) {
        return a(str, str2);
    }

    public boolean a(j jVar, Map map, String[] strArr) {
        String str = jVar.f121670b;
        String str2 = jVar.f121671c;
        if (str.equals("executeCommand")) {
            String[] parseOpValue = parseOpValue(jVar.f121671c);
            if (parseOpValue == null || parseOpValue.length < 2) {
                return false;
            }
            str = parseOpValue[0];
            str2 = parseOpValue[1];
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Map a16 = a(str, map);
        if (a16 == null || a16.isEmpty()) {
            a16 = new HashMap();
            map.put(str, a16);
        }
        boolean z16 = false;
        for (String str3 : strArr) {
            String trim = str3.trim();
            if (trim != null && !trim.isEmpty() && !a16.containsKey(trim)) {
                a16.put(trim, str2);
                z16 = true;
            }
        }
        return z16;
    }

    public WebView.WebViewKind b(String str) {
        if (str != null && !str.isEmpty()) {
            WebView.WebViewKind webViewKind = WebView.WebViewKind.WV_KIND_NONE;
            try {
                return WebView.WebViewKind.valueOf(str);
            } catch (Throwable th5) {
                x0.a(b(), "convertWebType error", th5);
                return webViewKind;
            }
        }
        return WebView.WebViewKind.WV_KIND_NONE;
    }

    public synchronized void a(Map map, SharedPreferences sharedPreferences) {
        Map<String, ?> all = sharedPreferences.getAll();
        if (all != null && all.size() != 0) {
            Iterator<Map.Entry<String, ?>> it = all.entrySet().iterator();
            ArrayList arrayList = new ArrayList();
            while (it.hasNext()) {
                arrayList.add(it.next().getKey());
            }
            SharedPreferences.Editor edit = sharedPreferences.edit();
            Iterator it5 = arrayList.iterator();
            while (it5.hasNext()) {
                String str = (String) it5.next();
                if (!"cStrTAGConfigVer".equalsIgnoreCase(str) && !"cStrTAGConfigSdkVer".equalsIgnoreCase(str) && !"cStrSpKeyConfigsReady".equalsIgnoreCase(str) && !map.containsKey(str)) {
                    edit.remove(str);
                }
            }
            edit.commit();
            x0.d(b(), "clearOldCommandConfigs, remained section B size:" + sharedPreferences.getAll().size());
        }
    }

    public synchronized void a() {
        if (!a(getSharePreferenceForCommandConfigLatest())) {
            x0.d(b(), "forkSectionBToSectionAIfNeed, section B not ready, ignore");
            return;
        }
        SharedPreferences.Editor edit = getSharePreferenceForCommandConfig().edit();
        edit.putString("cStrSpKeyConfigsReady", "false");
        edit.commit();
        SharedPreferences sharePreferenceForCommandConfigLatest = getSharePreferenceForCommandConfigLatest();
        Map<String, ?> all = sharePreferenceForCommandConfigLatest.getAll();
        if (all != null && all.size() != 0) {
            Iterator<Map.Entry<String, ?>> it = all.entrySet().iterator();
            while (it.hasNext()) {
                String key = it.next().getKey();
                String string = sharePreferenceForCommandConfigLatest.getString(key, "");
                if (key != null && !key.equalsIgnoreCase("cStrSpKeyConfigsReady")) {
                    edit.putString(key, String.valueOf(string));
                }
            }
            edit.putString("cStrSpKeyConfigsReady", "true");
            edit.commit();
            x0.d(b(), "forkSectionBToSectionAIfNeed, forked section A size:" + getSharePreferenceForCommandConfig().getAll().size());
        }
        x0.d(b(), "forkSectionBToSectionAIfNeed, empty command configs");
        edit.putString("cStrSpKeyConfigsReady", "true");
        edit.commit();
        x0.d(b(), "forkSectionBToSectionAIfNeed, forked section A size:" + getSharePreferenceForCommandConfig().getAll().size());
    }

    public String a(Map map) {
        if (map == null) {
            return "";
        }
        StringBuilder sb5 = new StringBuilder(128);
        for (Map.Entry entry : map.entrySet()) {
            if (sb5.length() != 0) {
                sb5.append("~~~");
            }
            sb5.append((String) entry.getKey());
            sb5.append("```");
            sb5.append((String) entry.getValue());
        }
        return sb5.toString();
    }

    public WebView.FullscreenVideoKind a(String str) {
        if (str != null && !str.isEmpty()) {
            WebView.FullscreenVideoKind fullscreenVideoKind = WebView.FullscreenVideoKind.HOOK_EVALUTE_JS;
            try {
                return WebView.FullscreenVideoKind.valueOf(str);
            } catch (Throwable th5) {
                x0.a(b(), "convertFullscreenVideo error", th5);
                return fullscreenVideoKind;
            }
        }
        return WebView.FullscreenVideoKind.HOOK_EVALUTE_JS;
    }

    public synchronized String a(String str, String str2) {
        Map<String, String> commandMap = getCommandMap(str);
        if (TextUtils.isEmpty(str2)) {
            str2 = WebView.getModuleName();
            if (TextUtils.isEmpty(str2)) {
                str2 = "tools";
            }
        }
        if (commandMap != null && str2 != null) {
            String str3 = commandMap.get(str2);
            if (TextUtils.isEmpty(str3) || !str3.contains("[") || !str3.contains("]")) {
                return str3;
            }
            return l0.a(str3);
        }
        return "";
    }

    public synchronized Map a(String str, Map map) {
        if (str != null) {
            if (!str.isEmpty()) {
                Object obj = map.get(str);
                if (obj instanceof HashMap) {
                    return (Map) obj;
                }
                return new HashMap();
            }
        }
        return new HashMap();
    }
}
