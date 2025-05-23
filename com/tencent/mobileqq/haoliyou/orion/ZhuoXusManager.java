package com.tencent.mobileqq.haoliyou.orion;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QMMKVMigrateHelper;
import com.tencent.mobileqq.config.aj;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService$Config;
import com.tencent.mobileqq.haoliyou.JefsClassUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.EstablishSetting;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes7.dex */
public class ZhuoXusManager {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "Zhuoxu";
    public final ConfigLoader configLoader;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static class SingletonHolder {
        static IPatchRedirector $redirector_;
        private static final ZhuoXusManager INSTANCE;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42467);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                INSTANCE = new ZhuoXusManager();
            }
        }

        SingletonHolder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    ZhuoXusManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.configLoader = new ConfigLoader();
        }
    }

    public static ZhuoXusManager instance() {
        return SingletonHolder.INSTANCE;
    }

    public boolean isSendFileExifInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this)).booleanValue();
        }
        return this.configLoader.sendFileExif.needBlock();
    }

    public boolean isSendFileQRCodeOpen() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        return this.configLoader.sendFileQRCode.needBlock();
    }

    public boolean isSendFileScanApp() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this)).booleanValue();
        }
        return this.configLoader.sendFileScanApp.needBlock();
    }

    public boolean isSendPicAppProbOpen() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        return this.configLoader.sendPicAppProb.needBlock();
    }

    public boolean isSendPicExifOpen() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        return this.configLoader.sendPicExif.needBlock();
    }

    public boolean isSendPicQRCodeOpen() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        return this.configLoader.sendPicQRCode.needBlock();
    }

    public boolean needReportSystemShareInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return this.configLoader.needReportSystemShareInfo;
    }

    public boolean needThinkElseAppInstalled() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return this.configLoader.needThinkElseAppInstalled;
    }

    public boolean needThinkPluginShare() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return this.configLoader.needThinkPluginShare;
    }

    public String packageName1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.configLoader.packageName1;
    }

    public String packageName2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.configLoader.packageName2;
    }

    public boolean saveImageNeedBlock() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return this.configLoader.saveImage.needBlock();
    }

    public boolean scanQrCodeNeedBlock() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return this.configLoader.scanQrCode.needBlock();
    }

    public boolean webViewMenuNeedBlock() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return this.configLoader.webViewMenu.needBlock();
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static class ConfigLoader {
        static IPatchRedirector $redirector_ = null;
        private static final String KEY_WO_KAO_CONFIG = "KEY_WO_KAO_CONFIG";
        private static final String KEY_WO_KAO_VERSION = "KEY_WO_KAO_VERSION";
        public static final String SP_WO_KAO = "SP_WO_KAO";
        private final Context context;
        boolean needReportSystemShareInfo;
        boolean needThinkElseAppInstalled;
        boolean needThinkPluginShare;
        String packageName1;
        String packageName2;
        ZhuosConfig saveImage;
        ZhuosConfig scanQrCode;
        ZhuosConfig sendFileExif;
        ZhuosConfig sendFileQRCode;
        ZhuosConfig sendFileScanApp;
        ZhuosConfig sendPicAppProb;
        ZhuosConfig sendPicExif;
        ZhuosConfig sendPicQRCode;
        ZhuosConfig webViewLaunchApp;
        ZhuosConfig webViewMenu;

        ConfigLoader() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.context = BaseApplication.getContext();
            ZhuosConfig zhuosConfig = ZhuosConfig.EMPTY_CONFIG;
            this.webViewMenu = zhuosConfig;
            this.webViewLaunchApp = zhuosConfig;
            this.scanQrCode = zhuosConfig;
            this.saveImage = zhuosConfig;
            this.sendPicQRCode = zhuosConfig;
            this.sendPicAppProb = zhuosConfig;
            this.sendPicExif = zhuosConfig;
            this.sendFileQRCode = zhuosConfig;
            this.sendFileExif = zhuosConfig;
            this.sendFileScanApp = zhuosConfig;
            this.needReportSystemShareInfo = false;
            this.needThinkElseAppInstalled = false;
            this.needThinkPluginShare = false;
            this.packageName1 = "";
            this.packageName2 = "";
            try {
                loadConfigFromSp();
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
        }

        private ZhuosConfig buildConfig(JSONObject jSONObject) {
            if (jSONObject == null) {
                return ZhuosConfig.EMPTY_CONFIG;
            }
            boolean z16 = true;
            if (jSONObject.optInt("need_block") != 1) {
                z16 = false;
            }
            String optString = jSONObject.optString("start_time");
            String optString2 = jSONObject.optString("end_time");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");
            try {
                return new ZhuosConfig(z16, simpleDateFormat.parse(optString), simpleDateFormat.parse(optString2));
            } catch (ParseException e16) {
                e16.printStackTrace();
                return ZhuosConfig.EMPTY_CONFIG;
            } catch (Throwable th5) {
                if (EstablishSetting.isPublicVersion()) {
                    th5.printStackTrace();
                    return ZhuosConfig.EMPTY_CONFIG;
                }
                throw new IllegalArgumentException();
            }
        }

        private String getCurrentUin() {
            String account;
            AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
            if (waitAppRuntime == null || (account = waitAppRuntime.getAccount()) == null) {
                return "";
            }
            return account;
        }

        private void saveVersionToSp(int i3) {
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.context);
            String str = "_" + getCurrentUin();
            defaultSharedPreferences.edit().putInt(KEY_WO_KAO_VERSION + str, i3).apply();
        }

        private void setAllConfigEmpty() {
            ZhuosConfig zhuosConfig = ZhuosConfig.EMPTY_CONFIG;
            this.webViewMenu = zhuosConfig;
            this.webViewLaunchApp = zhuosConfig;
            this.scanQrCode = zhuosConfig;
            this.saveImage = zhuosConfig;
            this.sendPicQRCode = zhuosConfig;
            this.sendPicAppProb = zhuosConfig;
            this.sendPicExif = zhuosConfig;
            this.sendFileQRCode = zhuosConfig;
            this.sendFileExif = zhuosConfig;
            this.sendFileScanApp = zhuosConfig;
            this.needReportSystemShareInfo = false;
            this.needThinkElseAppInstalled = false;
            this.needThinkPluginShare = false;
            this.packageName1 = "";
            this.packageName2 = "";
        }

        public int getVersionFromSp() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            return PreferenceManager.getDefaultSharedPreferences(this.context).getInt(KEY_WO_KAO_VERSION + ("_" + getCurrentUin()), 0);
        }

        public void handleConfig(ConfigurationService$Config configurationService$Config) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) configurationService$Config);
                return;
            }
            int i3 = configurationService$Config.version.get();
            int versionFromSp = getVersionFromSp();
            saveVersionToSp(i3);
            if (versionFromSp != i3) {
                String d16 = aj.d(configurationService$Config, versionFromSp, configurationService$Config.type.get());
                parseConfig(d16);
                saveConfigToSp(d16);
            } else if (QLog.isColorLevel()) {
                QLog.i(ZhuoXusManager.TAG, 2, "handleConfig: invoked. save version, ignored. version: " + versionFromSp);
            }
        }

        void loadConfigFromSp() {
            long currentTimeMillis = System.currentTimeMillis();
            String str = "";
            try {
                str = XorCipher.decrypt(QMMKVMigrateHelper.getMMKVMigratedSharePreferencesSync(this.context, SP_WO_KAO, 4).getString(KEY_WO_KAO_CONFIG + ("_" + getCurrentUin()), ""));
            } catch (XorCipherException e16) {
                e16.printStackTrace();
            }
            parseConfig(str);
            if (QLog.isColorLevel()) {
                QLog.i(ZhuoXusManager.TAG, 2, "loadConfigFromSp: invoked.  cost ms: " + (System.currentTimeMillis() - currentTimeMillis));
            }
        }

        void parseConfig(String str) {
            boolean z16;
            boolean z17;
            if (TextUtils.isEmpty(str)) {
                setAllConfigEmpty();
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.webViewMenu = buildConfig(jSONObject.optJSONObject("webview_menu"));
                this.webViewLaunchApp = buildConfig(jSONObject.optJSONObject("webview_launch_app"));
                this.scanQrCode = buildConfig(jSONObject.optJSONObject("scan_qrcode"));
                this.saveImage = buildConfig(jSONObject.optJSONObject("save_image"));
                this.sendPicQRCode = buildConfig(jSONObject.optJSONObject("imageUpload_scan"));
                this.sendPicExif = buildConfig(jSONObject.optJSONObject("assetInfo_upload"));
                this.sendPicAppProb = buildConfig(jSONObject.optJSONObject("image_probe"));
                this.sendFileQRCode = buildConfig(jSONObject.optJSONObject("send_fileqrcode_switch"));
                this.sendFileExif = buildConfig(jSONObject.optJSONObject("file_exif_info"));
                this.sendFileScanApp = buildConfig(jSONObject.optJSONObject("file_app_scan"));
                boolean z18 = false;
                if (jSONObject.optInt("need_report_system_share_info_new") == 1) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                this.needReportSystemShareInfo = z16;
                if (jSONObject.optInt("need_xxxxx_else_xxx_installed") == 1) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                this.needThinkElseAppInstalled = z17;
                if (jSONObject.optInt("need_xxxxx_plugin_xxxxx") == 1) {
                    z18 = true;
                }
                this.needThinkPluginShare = z18;
                this.packageName1 = jSONObject.optString("package1");
                this.packageName2 = jSONObject.optString("package2");
                JefsClassUtil.initPolicy(this.webViewLaunchApp.needBlock(), jSONObject.optJSONObject("webview_launch_xxx_xxxxxyyyy"));
            } catch (Exception e16) {
                QLog.e(ZhuoXusManager.TAG, 1, "parseConfig: failed. ", e16);
            } catch (Throwable unused) {
                if (!EstablishSetting.isPublicVersion()) {
                    throw new IllegalArgumentException();
                }
            }
        }

        void saveConfigToSp(String str) {
            String str2;
            try {
                str2 = XorCipher.encrypt(str);
            } catch (XorCipherException e16) {
                e16.printStackTrace();
                str2 = "";
            }
            SharedPreferences mMKVMigratedSharePreferencesSync = QMMKVMigrateHelper.getMMKVMigratedSharePreferencesSync(this.context, SP_WO_KAO, 4);
            String str3 = "_" + getCurrentUin();
            mMKVMigratedSharePreferencesSync.edit().putString(KEY_WO_KAO_CONFIG + str3, str2).apply();
        }

        public void handleConfig(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            } else {
                parseConfig(str);
                saveConfigToSp(str);
            }
        }
    }
}
