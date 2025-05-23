package com.tencent.biz.troopplugin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.common.util.k;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.mobileqq.pluginsdk.PluginManagerClient;
import com.tencent.mobileqq.pluginsdk.PluginManagerHelper;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.BaseActivity;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class PluginJumpManager {
    public static final String BID_INFO = "web_plugin_config_bidinfo";
    public static final String BID_VERSION = "bid_version";
    public static final String CONFIG_BID = "1007";
    public static final String CONFIG_FILE_VERSION = "web_plugin_config_config_file_version";
    public static final String CONFIG_VERSION = "web_plugin_config_version";
    public static final String TAG = "PluginJumpManager";
    public static final String URL_MAPPING = "web_plugin_config_urlmaping";
    public static final String WEB_PLUGIN_CONFIG = "web_plugin_config";
    public static PluginJumpManager sInstance;
    public int mConfigVersion;
    public Context mContext;
    public MMKVOptionEntity mEntity;
    public PluginManagerClient mPluginManager;
    public boolean isLoadedPlugin = false;
    public HashMap<String, c> mBidInfos = new HashMap<>();
    public HashMap<String, d> mUrlmappingInfos = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class b implements PluginManagerHelper.OnPluginManagerLoadedListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f96935a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Activity f96936b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f96937c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f96938d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ long f96939e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ d f96940f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f96941g;

        b(c cVar, Activity activity, String str, String str2, long j3, d dVar, String str3) {
            this.f96935a = cVar;
            this.f96936b = activity;
            this.f96937c = str;
            this.f96938d = str2;
            this.f96939e = j3;
            this.f96940f = dVar;
            this.f96941g = str3;
        }

        /* JADX WARN: Removed duplicated region for block: B:10:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0068  */
        @Override // com.tencent.mobileqq.pluginsdk.PluginManagerHelper.OnPluginManagerLoadedListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onPluginManagerLoaded(PluginManagerClient pluginManagerClient) {
            boolean z16;
            PluginJumpManager.this.mPluginManager = pluginManagerClient;
            PluginBaseInfo queryPlugin = pluginManagerClient.queryPlugin(this.f96935a.f96944b);
            if (queryPlugin != null) {
                if (queryPlugin.mState == 4) {
                    PluginJumpManager pluginJumpManager = PluginJumpManager.this;
                    Activity activity = this.f96936b;
                    c cVar = this.f96935a;
                    String str = cVar.f96944b;
                    String str2 = cVar.f96945c;
                    String str3 = this.f96937c;
                    String str4 = this.f96938d;
                    long j3 = this.f96939e;
                    d dVar = this.f96940f;
                    pluginJumpManager.launchPlugin(activity, str, str2, str3, str4, null, j3, dVar.f96948b, dVar.f96950d);
                    z16 = true;
                    if (z16) {
                        PluginJumpManager.this.openLinkInNewWebView(this.f96936b, this.f96938d, this.f96941g);
                        return;
                    }
                    return;
                }
                PluginJumpManager.report("BizTechReport", "native_plugin", "open_with_noapk", 0, this.f96938d, this.f96940f.f96948b, null, null);
                PluginJumpManager.this.mPluginManager.installPlugin(this.f96935a.f96944b);
            } else {
                PluginJumpManager.report("BizTechReport", "native_plugin", "open_with_noapk", 1, this.f96938d, this.f96940f.f96948b, null, null);
            }
            z16 = false;
            if (z16) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c {

        /* renamed from: a, reason: collision with root package name */
        public String f96943a;

        /* renamed from: b, reason: collision with root package name */
        public String f96944b;

        /* renamed from: c, reason: collision with root package name */
        public String f96945c;

        public c() {
        }
    }

    /* loaded from: classes5.dex */
    public class d {

        /* renamed from: a, reason: collision with root package name */
        public String f96947a;

        /* renamed from: b, reason: collision with root package name */
        public String f96948b;

        /* renamed from: c, reason: collision with root package name */
        public String f96949c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f96950d;

        /* renamed from: e, reason: collision with root package name */
        public String f96951e;

        /* renamed from: f, reason: collision with root package name */
        public String f96952f;

        /* renamed from: g, reason: collision with root package name */
        public String f96953g;

        /* renamed from: h, reason: collision with root package name */
        public String f96954h;

        public d() {
        }
    }

    public PluginJumpManager(Context context) {
        this.mContext = context;
        this.mEntity = QMMKV.from(context, "common_mmkv_configurations");
    }

    public static PluginJumpManager getInstance() {
        if (sInstance == null) {
            sInstance = new PluginJumpManager(BaseApplication.getContext());
        }
        return sInstance;
    }

    public static void report(String str, String str2, String str3, int i3, String str4, String str5, String str6, String str7) {
        ReportController.o(null, "P_CliOper", str, "", str2, str3, 0, i3, str4, str5, str6, str7);
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0038, code lost:
    
        if (r1 >= java.lang.Integer.valueOf(r10.f96951e).intValue()) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean checkQVerAndModel(d dVar) {
        int i3;
        try {
            i3 = InstalledAppListMonitor.getPackageInfo(this.mContext.getPackageManager(), this.mContext.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e16) {
            e16.printStackTrace();
            i3 = 0;
        }
        boolean z16 = true;
        if (TextUtils.isEmpty(dVar.f96952f)) {
            if (!TextUtils.isEmpty(dVar.f96951e)) {
            }
        } else {
            for (String str : dVar.f96952f.split(",")) {
                if (String.valueOf(i3).equals(str)) {
                    break;
                }
            }
            z16 = false;
        }
        if (!TextUtils.isEmpty(dVar.f96953g)) {
            String str2 = Build.BRAND;
            String model = DeviceInfoMonitor.getModel();
            String str3 = Build.VERSION.RELEASE;
            String[] split = dVar.f96953g.split(",");
            StringBuffer stringBuffer = new StringBuffer(str2);
            stringBuffer.append(" ");
            stringBuffer.append(model);
            String lowerCase = stringBuffer.toString().toLowerCase();
            stringBuffer.append(" ");
            stringBuffer.append(str3);
            String lowerCase2 = stringBuffer.toString().toLowerCase();
            for (String str4 : split) {
                String lowerCase3 = str4.toLowerCase();
                if (lowerCase3.contains(lowerCase) && lowerCase2.startsWith(lowerCase3)) {
                    return false;
                }
            }
        }
        return z16;
    }

    public void launchPlugin(Activity activity, String str, String str2, String str3, String str4, String str5, long j3, String str6, boolean z16) {
        QLog.e(TAG, 1, "TroopBarProxyActivity \u5df2\u5728725\u4e0b\u67b6");
    }

    public void loadConfig() {
        int i3;
        try {
            i3 = Integer.valueOf(this.mEntity.decodeString(CONFIG_VERSION, "0")).intValue();
        } catch (NumberFormatException unused) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "version parse error!");
            }
            i3 = 0;
        }
        if (i3 <= this.mConfigVersion) {
            return;
        }
        this.mConfigVersion = i3;
        String decodeString = this.mEntity.decodeString(BID_INFO, "");
        String decodeString2 = this.mEntity.decodeString(URL_MAPPING, "");
        try {
            JSONArray jSONArray = new JSONArray(decodeString);
            int length = jSONArray.length();
            for (int i16 = 0; i16 < length; i16++) {
                c cVar = new c();
                JSONObject jSONObject = jSONArray.getJSONObject(i16);
                cVar.f96943a = jSONObject.optString("bid");
                cVar.f96944b = jSONObject.optString("pluginid");
                cVar.f96945c = jSONObject.optString("pluginname");
                this.mBidInfos.put(cVar.f96943a, cVar);
            }
            JSONArray jSONArray2 = new JSONArray(decodeString2);
            int length2 = jSONArray2.length();
            for (int i17 = 0; i17 < length2; i17++) {
                d dVar = new d();
                JSONObject jSONObject2 = jSONArray2.getJSONObject(i17);
                dVar.f96947a = jSONObject2.optString("url");
                dVar.f96948b = jSONObject2.optString(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
                dVar.f96949c = jSONObject2.optString("bid");
                dVar.f96953g = jSONObject2.optString("a_black_ver");
                dVar.f96951e = jSONObject2.optString("q_min_ver");
                dVar.f96952f = jSONObject2.optString("q_white_ver");
                dVar.f96950d = jSONObject2.optBoolean("useiphonetitlebar");
                dVar.f96954h = jSONObject2.optString("extra");
                this.mUrlmappingInfos.put(dVar.f96947a, dVar);
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "config parse error!");
            }
        }
    }

    public void loadConfigFromFile() {
        FileInputStream fileInputStream;
        File file = new File(com.tencent.biz.common.offline.c.c(CONFIG_BID) + CONFIG_BID + "/urlplugin.cfg");
        if (file.exists()) {
            try {
                fileInputStream = new FileInputStream(file);
            } catch (IOException e16) {
                report("BizTechReport", "native_plugin", "read_config", 1, null, null, null, null);
                e16.printStackTrace();
                fileInputStream = null;
            }
            if (fileInputStream == null) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(k.h(fileInputStream));
                this.mEntity.encodeString(CONFIG_FILE_VERSION, HtmlOffline.z(CONFIG_BID));
                this.mEntity.encodeString(CONFIG_VERSION, jSONObject.optString(CONFIG_VERSION));
                this.mEntity.encodeString(BID_INFO, jSONObject.optString(BID_INFO));
                this.mEntity.encodeString(URL_MAPPING, jSONObject.optString(URL_MAPPING)).commitAsync();
                report("BizTechReport", "native_plugin", "read_config", 0, null, null, null, null);
            } catch (Exception e17) {
                e17.printStackTrace();
            }
            try {
                fileInputStream.close();
                return;
            } catch (Exception e18) {
                e18.printStackTrace();
                return;
            }
        }
        report("BizTechReport", "native_plugin", "read_config", 2, null, null, null, null);
    }

    public final void openLinkInNewWebView(Activity activity, String str, String str2) {
        int i3;
        Intent intent;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            Bundle extras = activity.getIntent().getExtras();
            if (extras == null) {
                extras = new Bundle();
            } else {
                extras.remove("title");
                extras.remove(AppConstants.LeftViewText.LEFTVIEWTEXT);
                extras.remove("post_data");
            }
            try {
                i3 = Integer.valueOf(str2).intValue();
            } catch (Exception unused) {
                i3 = 0;
            }
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 == 3) {
                            extras.putBoolean("hide_more_button", true);
                            extras.putBoolean("hide_operation_bar", false);
                            extras.putString("webStyle", "");
                        }
                    } else {
                        extras.putBoolean("hide_more_button", false);
                        extras.putBoolean("hide_operation_bar", false);
                        extras.putString("webStyle", "");
                    }
                } else {
                    extras.putBoolean("hide_more_button", true);
                    extras.putBoolean("hide_operation_bar", true);
                }
            } else {
                extras.putBoolean("hide_more_button", false);
                extras.putBoolean("hide_operation_bar", true);
            }
            if (activity instanceof BaseActivity) {
                intent = new Intent(activity, activity.getClass());
            } else {
                intent = new Intent(activity, (Class<?>) QQBrowserActivity.class);
            }
            intent.putExtras(extras);
            intent.putExtra("url", str);
            intent.setFlags(0);
            activity.startActivityForResult(intent, 100);
        }
    }

    public boolean openView(Activity activity, String str, String str2, String str3, boolean z16) {
        long currentTimeMillis = System.currentTimeMillis();
        if (TextUtils.isEmpty(str) || !Uri.parse(str).isHierarchical()) {
            return false;
        }
        int indexOf = str.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
        String substring = indexOf > 0 ? str.substring(0, indexOf) : str;
        if (!this.mUrlmappingInfos.containsKey(substring)) {
            return false;
        }
        d dVar = this.mUrlmappingInfos.get(substring);
        String str4 = dVar.f96949c;
        if (TextUtils.isEmpty(str4) || !this.mBidInfos.containsKey(str4) || !checkQVerAndModel(dVar)) {
            return false;
        }
        if (!TextUtils.isEmpty(dVar.f96954h)) {
            if (dVar.f96954h.contains(",")) {
                boolean z17 = false;
                for (String str5 : dVar.f96954h.split(",")) {
                    if (str.contains(str5)) {
                        z17 = true;
                    }
                }
                if (!z17) {
                    return false;
                }
            } else if (dVar.f96954h.contains(";")) {
                for (String str6 : dVar.f96954h.split(";")) {
                    if (!str.contains(str6)) {
                        return false;
                    }
                }
            } else if (!str.contains(dVar.f96954h)) {
                return false;
            }
        }
        PluginManagerHelper.getPluginInterface(activity.getApplicationContext(), new b(this.mBidInfos.get(str4), activity, str3, str, currentTimeMillis, dVar, str2));
        return true;
    }

    public void updateConfig(AppRuntime appRuntime) {
        boolean z16;
        if (appRuntime == null) {
            return;
        }
        HtmlOffline.D();
        if (appRuntime.getLongAccountUin() % 10 == 6) {
            z16 = true;
        } else {
            z16 = false;
        }
        HtmlOffline.f78406i = z16;
        HtmlOffline.j(CONFIG_BID, appRuntime, true, new a());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a implements com.tencent.biz.common.offline.a {

        /* renamed from: com.tencent.biz.troopplugin.PluginJumpManager$a$a, reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        class C0984a implements com.tencent.biz.common.offline.b {
            C0984a() {
            }

            @Override // com.tencent.biz.common.offline.b
            public void loaded(int i3, String str) {
                PluginJumpManager.this.loadConfigFromFile();
            }
        }

        a() {
        }

        @Override // com.tencent.biz.common.offline.a
        public void loaded(String str, int i3) {
            if (i3 == 0) {
                HtmlOffline.O("urlplugin.cfg", PluginJumpManager.this.mContext, PluginJumpManager.CONFIG_BID, new C0984a());
            } else if (TextUtils.isEmpty(PluginJumpManager.this.mEntity.decodeString(PluginJumpManager.CONFIG_FILE_VERSION, ""))) {
                PluginJumpManager.this.loadConfigFromFile();
            }
        }

        @Override // com.tencent.biz.common.offline.a
        public void progress(int i3) {
        }
    }

    public boolean openView(Activity activity, String str, String str2) {
        AppRuntime appRuntime;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (activity instanceof BaseActivity) {
            appRuntime = ((BaseActivity) activity).getAppRuntime();
        } else {
            appRuntime = activity instanceof com.tencent.mobileqq.app.BaseActivity ? ((com.tencent.mobileqq.app.BaseActivity) activity).getAppRuntime() : null;
        }
        if (appRuntime == null) {
            return false;
        }
        return openView(activity, str, str2, appRuntime.getAccount(), false);
    }
}
