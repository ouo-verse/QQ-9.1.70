package com.tencent.mobileqq.auto.engine.loader;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.auto.engine.loader.net.ASDataBaseInfo;
import com.tencent.mobileqq.config.api.IAppSettingApi;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.pluginsdk.PluginContext;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.ProtocolDownloaderConstants;
import com.tencent.mobileqq.utils.SdCardUtil;
import com.tencent.mobileqq.vfs.IVFSAssistantApi;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ASEngineUtils {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "ASEngineUtils";

    public ASEngineUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static AppRuntime getAppRunTime() {
        return MobileQQ.sMobileQQ.waitAppRuntime(null);
    }

    private static Activity getContextWrapperActivity(Context context) {
        if (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            return getContextWrapperActivity(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    public static String getEnginePrivateRootPath(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return getEngineRootPath(str) + ProtocolDownloaderConstants.FILE_PREFIX;
    }

    public static String getEngineRootPath(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return ((IVFSAssistantApi) QRoute.api(IVFSAssistantApi.class)).getSDKPrivatePath(str + "/");
    }

    public static EntityManager getEntityManager() {
        if (getAppRunTime() != null) {
            return getAppRunTime().getEntityManagerFactory(getAppRunTime().getAccount()).createEntityManager();
        }
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        return waitAppRuntime.getEntityManagerFactory(waitAppRuntime.getAccount()).createEntityManager();
    }

    public static Context getHostContext(Context context) {
        Context context2;
        Activity contextWrapperActivity = getContextWrapperActivity(context);
        if (contextWrapperActivity != null && contextWrapperActivity.getWindow() != null) {
            View decorView = contextWrapperActivity.getWindow().getDecorView();
            if (decorView.getParent() instanceof View) {
                context2 = ((View) decorView.getParent()).getContext();
            } else {
                context2 = contextWrapperActivity;
            }
            if (context2 == null && contextWrapperActivity.getBaseContext() != null) {
                context2 = contextWrapperActivity.getBaseContext();
            }
            if (context2 instanceof PluginContext) {
                return ((PluginContext) context2).getOutContext();
            }
            return context2;
        }
        QLog.d(TAG, 1, "requestPermissions error with null activity");
        return null;
    }

    public static Intent getHostContextIntent(Context context) {
        Context hostContext = getHostContext(context);
        if (hostContext instanceof Activity) {
            return ((Activity) hostContext).getIntent();
        }
        return null;
    }

    public static int getHostVersion() {
        String[] split = ((IAppSettingApi) QRoute.api(IAppSettingApi.class)).getSubVersion().split("\\.");
        if (split != null && split.length >= 3) {
            StringBuilder sb5 = new StringBuilder(split[0]);
            if (split[1].length() == 1) {
                sb5.append("0");
                sb5.append(split[1]);
            } else {
                sb5.append(split[1]);
            }
            if (split[2].length() == 1) {
                sb5.append("0");
                sb5.append(split[2]);
            } else {
                sb5.append(split[2]);
            }
            sb5.append("00");
            return Integer.parseInt(sb5.toString());
        }
        return Integer.MAX_VALUE;
    }

    public static String getTestEnginePath(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(getEngineRootPath(str));
        sb5.append("file");
        String str2 = File.separator;
        sb5.append(str2);
        sb5.append("test");
        File file = new File(sb5.toString());
        if (!file.exists()) {
            file = new File(SdCardUtil.getSdCardDirectory() + str2 + str + str2 + "file" + str2 + "test");
        }
        return file.getAbsolutePath() + str2;
    }

    public static String getUin() {
        return ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount();
    }

    public static long getUinLong() {
        try {
            if (!TextUtils.isEmpty(getUin())) {
                return Long.parseLong(getUin());
            }
            return 0L;
        } catch (NumberFormatException e16) {
            QLog.e("ASEngineUtils,", 1, "guiUin error" + e16);
            return 0L;
        }
    }

    public static void setHostContextIntent(Context context, Intent intent) {
        Context hostContext = getHostContext(context);
        if (hostContext instanceof Activity) {
            ((Activity) hostContext).setIntent(intent);
        }
    }

    public static ASPluginBean transFormToASPluginBean(ASDataBaseInfo aSDataBaseInfo) {
        if (aSDataBaseInfo == null) {
            return null;
        }
        ASPluginBean aSPluginBean = new ASPluginBean();
        aSPluginBean.setType(ASPluginBean.TYPE_NET).setVersionCode(aSDataBaseInfo.mVersion).setBusinessKey(aSDataBaseInfo.mBusinessKey).setPluginZipPath(aSDataBaseInfo.mPluginZipPath).setZipFileLength(aSDataBaseInfo.mZipFileLength).setPluginMangerApkPath(aSDataBaseInfo.mPluginManagerPath).setManagerFileLength(aSDataBaseInfo.mManagerFileLength);
        return aSPluginBean;
    }
}
