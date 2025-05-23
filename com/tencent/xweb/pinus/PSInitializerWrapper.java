package com.tencent.xweb.pinus;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.luggage.wxa.ar.g0;
import com.tencent.luggage.wxa.ar.x0;
import com.tencent.luggage.wxa.uq.a;
import com.tencent.luggage.wxa.wq.j;
import com.tencent.xweb.WebView;
import com.tencent.xweb.XWebInitializer;
import com.tencent.xweb.XWebPreferences;
import com.tencent.xweb.XWebProfileManager;
import com.tencent.xweb.internal.ConstValue;
import java.io.File;
import java.io.FilenameFilter;
import oicq.wlogin_sdk.tools.util;
import org.xwalk.core.XWalkEnvironment;

/* loaded from: classes27.dex */
public class PSInitializerWrapper extends XWebInitializer {
    private static final String TAG = "PSInitializerWrapper";

    /* loaded from: classes27.dex */
    public static class SingletonHolder {
        private static final PSInitializerWrapper sInstance = new PSInitializerWrapper();

        SingletonHolder() {
        }
    }

    private static void cleanLastCrashDumpFiles() {
        File[] listFiles;
        try {
            if (XWebBrowserProcessHelper.getCrashDumpFileCallback() != null) {
                String crashDumpFolderPath = XWebBrowserProcessHelper.getCrashDumpFileCallback().getCrashDumpFolderPath();
                if (TextUtils.isEmpty(crashDumpFolderPath)) {
                    x0.d(TAG, "cleanLastCrashDumpFiles, crash folder path is null");
                    return;
                }
                x0.d(TAG, "cleanLastCrashDumpFiles, crashDumpFolderPath:" + crashDumpFolderPath);
                File file = new File(crashDumpFolderPath);
                final String processName = XWalkEnvironment.getProcessName();
                if (file.exists() && (listFiles = file.listFiles(new FilenameFilter() { // from class: com.tencent.xweb.pinus.PSInitializerWrapper.1
                    @Override // java.io.FilenameFilter
                    public boolean accept(File file2, String str) {
                        if ((str.startsWith("java_") || str.startsWith("NativeCrash_")) && str.contains(processName.replace(':', util.base64_pad_url)) && (str.contains(XWalkEnvironment.CRASH_DUMP_FILE_SUFFIX) || str.contains(XWalkEnvironment.CRASH_DUMP_FILE_SUFFIX_FOR_GPU) || str.contains(XWalkEnvironment.CRASH_DUMP_FILE_SUFFIX_FOR_RENDER_UNSANDBOX))) {
                            return true;
                        }
                        return false;
                    }
                })) != null) {
                    for (File file2 : listFiles) {
                        if (file2.length() == 0) {
                            x0.d(TAG, "cleanLastCrashDumpFiles, file:" + file2.getName());
                            file2.delete();
                        }
                    }
                }
            }
        } catch (Throwable th5) {
            x0.a(TAG, "cleanLastCrashDumpFiles error", th5);
        }
    }

    public static PSInitializerWrapper getInstance() {
        return SingletonHolder.sInstance;
    }

    private void initViewDelegate() {
        x0.d(TAG, "initViewDelegate");
        Class<?> bridgeClass = PSCoreWrapper.getInstance().getBridgeClass("PSViewDelegate");
        cleanLastCrashDumpFiles();
        int multiProcessType = XWalkEnvironment.getMultiProcessType();
        g0 g0Var = new g0((Class) bridgeClass, "preInit", Bundle.class);
        if (!g0Var.a()) {
            Bundle bundle = new Bundle();
            bundle.putString("lang", XWalkEnvironment.getLocaleString());
            bundle.putBoolean("sandbox", XWalkEnvironment.getEnableSandbox());
            bundle.putBoolean("checkCertificate", XWalkEnvironment.getEnableCheckCertificate());
            bundle.putBundle("extendBundle", XWalkEnvironment.getExtendConfigBundle());
            bundle.putBundle("initBundle", XWalkEnvironment.getInitConfigBundle());
            g0Var.a(bundle);
        }
        new g0((Class) bridgeClass, "init", Context.class, Context.class, Integer.TYPE, String.class, String.class, String.class, String.class).a(null, this.webViewContextWrapper, Integer.valueOf(multiProcessType), String.valueOf(XWalkEnvironment.getAvailableVersion()), String.valueOf(XWalkEnvironment.SDK_VERSION), XWalkEnvironment.getPrivilegedServicesName(), XWalkEnvironment.getSandboxedServicesName());
        if (XWalkEnvironment.getPackageName().equalsIgnoreCase(XWalkEnvironment.getProcessName())) {
            j.a();
        }
    }

    private void setLocationProxy() {
        if (a.a().b()) {
            x0.d(TAG, "setLocationProxy");
            this.webViewCoreWrapper.invokeRuntimeChannel(ConstValue.INVOKE_RUNTIME_ID_USE_LOCATION_PROXY, new Object[]{""});
        }
    }

    @Override // com.tencent.xweb.XWebInitializer
    public boolean doInitWebViewCore(int i3) {
        x0.a(TAG, "doInitWebViewCore, version:" + i3);
        boolean initChannels = PinusStandAloneChannel.getInstance().initChannels(false, false);
        x0.a(TAG, "doInitWebViewCore, result:" + initChannels);
        return initChannels;
    }

    @Override // com.tencent.xweb.XWebInitializer
    public void postInitWebViewCore(int i3) {
        x0.a(TAG, "postInitWebViewCore, version:" + i3);
        this.webViewCoreWrapper = new PSCoreWrapper();
        this.webViewContextWrapper = new PSContextWrapper(XWalkEnvironment.getApplicationContext(), i3);
        XWebPreferences.setWebPreferences(new PinusPreferences());
        initViewDelegate();
        setLocalStorageSuffix();
        XWebProfileManager.initProfile();
        setLocationProxy();
        WebView.onXWebCoreInited();
    }

    PSInitializerWrapper() {
    }
}
