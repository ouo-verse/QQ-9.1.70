package com.tencent.mobileqq.qshadow.core;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qshadow.constant.QShadowConstant;
import com.tencent.mobileqq.qshadow.utils.PluginIdUtil;
import com.tencent.mobileqq.qshadow.utils.QShadowRepository;
import com.tencent.shadow.core.common.Logger;
import com.tencent.shadow.core.common.LoggerFactory;
import com.tencent.shadow.dynamic.host.Constant;
import com.tencent.shadow.dynamic.host.ShadowTag;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import nk2.a;

/* compiled from: P */
/* loaded from: classes17.dex */
public class QShadow {
    static IPatchRedirector $redirector_;
    private Context mContext;
    private Logger mLogger;
    private Map<String, DefaultPluginManager> mPluginManagerMap;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public static class Holder {
        static IPatchRedirector $redirector_;
        private static final QShadow INSTANCE;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36687);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                INSTANCE = new QShadow(null);
            }
        }

        Holder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* synthetic */ QShadow(AnonymousClass1 anonymousClass1) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 13)) {
            return;
        }
        iPatchRedirector.redirect((short) 13, (Object) this, (Object) anonymousClass1);
    }

    public static QShadow getInstance() {
        return Holder.INSTANCE;
    }

    private DefaultPluginManager getPluginManager(String str) {
        String groupId = PluginIdUtil.getGroupId(str);
        DefaultPluginManager defaultPluginManager = this.mPluginManagerMap.get(groupId);
        if (defaultPluginManager == null) {
            DefaultPluginManager defaultPluginManager2 = new DefaultPluginManager(str, this.mContext);
            this.mPluginManagerMap.put(groupId, defaultPluginManager2);
            return defaultPluginManager2;
        }
        return defaultPluginManager;
    }

    private Bundle wrapperBundle(Bundle bundle, String str, String str2) {
        Bundle bundle2 = new Bundle();
        bundle2.putBundle("KEY_EXTRAS", bundle);
        bundle2.putString("pluginZipPath", getPluginManager(str).getPluginZipPath());
        bundle2.putString("KEY_PLUGIN_PART_KEY", str);
        bundle2.putString(Constant.KEY_CLASSNAME, str2);
        return bundle2;
    }

    public Map<String, PluginBaseInfo> getQShadowBuildInPlugins() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (Map) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        HashMap hashMap = new HashMap();
        try {
            String[] split = QShadowRepository.getStringFromStream(this.mContext.getAssets().open(QShadowConstant.PLUGIN_ASSET_ROOT_PATH + File.separator + "plugins")).split(",");
            int length = split.length;
            for (int i3 = 0; i3 < length; i3++) {
                String str = split[i3];
                String str2 = QShadowConstant.getAssetRootPath(str) + File.separator + "config.json";
                try {
                    InputStream open = this.mContext.getAssets().open(str2);
                    PluginBaseInfo pluginBaseInfo = new PluginBaseInfo();
                    pluginBaseInfo.mID = PluginIdUtil.convertQShadowId2QPluginId(str);
                    pluginBaseInfo.mMD5 = QShadowRepository.getUuidFromStream(open);
                    pluginBaseInfo.mUpdateType = 1;
                    pluginBaseInfo.mInstallType = 0;
                    hashMap.put(pluginBaseInfo.mID, pluginBaseInfo);
                } catch (IOException unused) {
                    this.mLogger.warn("plugin " + str + " not found in asset " + str2);
                }
            }
        } catch (Exception e16) {
            this.mLogger.error("plugin_tag \u83b7\u53d6\u672c\u5730\u63d2\u4ef6asset\u5217\u8868\u5931\u8d25", (Throwable) e16);
        }
        return hashMap;
    }

    public void init(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
            return;
        }
        this.mContext = context.getApplicationContext();
        StringBuilder sb5 = new StringBuilder();
        sb5.append(this.mContext.getFilesDir().getAbsolutePath());
        String str = File.separator;
        sb5.append(str);
        sb5.append(QShadowConstant.PLUGIN_ASSET_ROOT_PATH);
        sb5.append(str);
        File file = new File(sb5.toString());
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    public boolean installPlugin(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) str)).booleanValue();
        }
        return getPluginManager(str).installPlugin();
    }

    public long installedPluginSize(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Long) iPatchRedirector.redirect((short) 11, (Object) this, (Object) str)).longValue();
        }
        return getPluginManager(str).installedPluginSize();
    }

    public boolean isPluginInstalled(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str)).booleanValue();
        }
        return getPluginManager(str).isPluginInstalled();
    }

    public boolean isPluginRunning(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) str)).booleanValue();
        }
        if (!TextUtils.isEmpty(QShadowRepository.getInstalledPlugin(this.mContext, str, "")) && getPluginManager(str).isPluginRunning()) {
            return true;
        }
        return false;
    }

    public boolean preInstall(String str, File file) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str, (Object) file)).booleanValue();
        }
        return getPluginManager(str).preInstall(file);
    }

    public void registerPluginManager(String str, DefaultPluginManager defaultPluginManager) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) defaultPluginManager);
        } else {
            this.mPluginManagerMap.put(PluginIdUtil.getGroupId(str), defaultPluginManager);
        }
    }

    public void startActivity(String str, String str2, Bundle bundle, a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, str, str2, bundle, aVar);
        } else {
            getPluginManager(str).enter(this.mContext, Constant.FROM_ID_START_ACTIVITY, wrapperBundle(bundle, str, str2), aVar);
        }
    }

    public void startService(String str, String str2, Bundle bundle, a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, str, str2, bundle, aVar);
        } else {
            getPluginManager(str).enter(this.mContext, 1004L, wrapperBundle(bundle, str, str2), aVar);
        }
    }

    public boolean uninstallPlugin(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, (Object) str)).booleanValue();
        }
        return getPluginManager(str).uninstallPlugin();
    }

    QShadow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mLogger = LoggerFactory.getLogger(ShadowTag.class);
            this.mPluginManagerMap = new HashMap();
        }
    }
}
