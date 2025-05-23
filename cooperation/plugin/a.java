package cooperation.plugin;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.gamecenter.wadl.sdk.app.WadlRuntime;
import com.tencent.mobileqq.api.IBuildConfig;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qshadow.core.QShadow;
import com.tencent.qphone.base.util.QLog;
import com.tencent.shadow.core.common.LoggerFactory;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes28.dex */
public class a {

    /* renamed from: c, reason: collision with root package name */
    private static volatile a f390253c;

    /* renamed from: d, reason: collision with root package name */
    private static String[] f390254d = {"qwallet_plugin.apk", "qqfav.apk", WadlRuntime.WADL_MODULE_ID};

    /* renamed from: a, reason: collision with root package name */
    private Context f390255a;

    /* renamed from: b, reason: collision with root package name */
    private HashMap<String, PluginInfo> f390256b = new HashMap<>();

    a(Context context) {
        this.f390255a = context;
        LoggerFactory.setILoggerFactory(com.tencent.mobileqq.intervideo.f.a());
        c();
    }

    public static final a b(Context context) {
        if (f390253c == null) {
            synchronized (a.class) {
                if (f390253c == null) {
                    f390253c = new a(context);
                }
            }
        }
        return f390253c;
    }

    public static boolean d(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        int i3 = 0;
        while (true) {
            String[] strArr = f390254d;
            if (i3 >= strArr.length) {
                return false;
            }
            if (str.equals(strArr[i3])) {
                return true;
            }
            i3++;
        }
    }

    public PluginInfo a(String str) {
        return this.f390256b.get(str);
    }

    public void c() {
        g();
        if (QLog.isColorLevel()) {
            QLog.d("plugin_tag", 2, "init. built in plugin size:" + this.f390256b.size());
        }
    }

    public boolean e(String str) {
        return this.f390256b.containsKey(str);
    }

    public boolean f(String str, PluginBaseInfo pluginBaseInfo) {
        PluginInfo pluginInfo;
        if (!TextUtils.isEmpty(str) && (pluginInfo = this.f390256b.get(str)) != null) {
            if (pluginBaseInfo != null) {
                boolean equals = TextUtils.equals(pluginInfo.mMD5, pluginBaseInfo.mMD5);
                QLog.i("plugin_tag", 1, "isUpToDayBuiltIn " + str + " isUpToDay " + equals);
                if (!equals) {
                    com.tencent.qqperf.monitor.crash.catchedexception.a.c(new RuntimeException(), "plugin_tagCreateClassLoaderNotUpToDay");
                    return equals;
                }
                return equals;
            }
            QLog.i("plugin_tag", 1, "isUpToDayBuiltIn info");
        }
        return false;
    }

    void g() {
        BufferedReader bufferedReader;
        Throwable th5;
        BufferedReader bufferedReader2 = null;
        try {
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(this.f390255a.getAssets().open("plugins/PluginManifest")));
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        String[] split = readLine.trim().split(":");
                        String str = split[0];
                        String str2 = "";
                        if (split.length > 1) {
                            str2 = split[1];
                        }
                        PluginInfo pluginInfo = new PluginInfo();
                        pluginInfo.mID = str;
                        pluginInfo.mMD5 = str2;
                        pluginInfo.mUpdateType = 1;
                        pluginInfo.mInstallType = 0;
                        if (((IBuildConfig) QRoute.api(IBuildConfig.class)).getDynamicFeaturePlugins().contains(str)) {
                            pluginInfo.mSubType = 2;
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d("plugin_tag", 2, "readManifest: " + pluginInfo.mID + ", " + pluginInfo.mMD5);
                        }
                        this.f390256b.put(str, pluginInfo);
                    } catch (IOException unused) {
                        bufferedReader2 = bufferedReader;
                        if (bufferedReader2 != null) {
                            bufferedReader2.close();
                        }
                        return;
                    } catch (Throwable th6) {
                        th5 = th6;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Exception unused2) {
                            }
                        }
                        throw th5;
                    }
                }
                for (Map.Entry<String, PluginBaseInfo> entry : QShadow.getInstance().getQShadowBuildInPlugins().entrySet()) {
                    PluginInfo pluginInfo2 = new PluginInfo();
                    pluginInfo2.mSubType = 1;
                    pluginInfo2.mID = entry.getValue().mID;
                    pluginInfo2.mMD5 = entry.getValue().mMD5;
                    pluginInfo2.mUpdateType = entry.getValue().mUpdateType;
                    pluginInfo2.mInstallType = entry.getValue().mInstallType;
                    this.f390256b.put(entry.getKey(), pluginInfo2);
                    if (QLog.isColorLevel()) {
                        QLog.d("plugin_tag", 2, "read QShadow build in plugin: " + pluginInfo2.mID + ", " + pluginInfo2.mMD5);
                    }
                }
                bufferedReader.close();
            } catch (IOException unused3) {
            } catch (Throwable th7) {
                bufferedReader = null;
                th5 = th7;
            }
        } catch (Exception unused4) {
        }
    }
}
