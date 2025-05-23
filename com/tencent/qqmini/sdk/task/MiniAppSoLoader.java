package com.tencent.qqmini.sdk.task;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePlayerProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.manager.EngineInstaller;
import com.tencent.qqmini.sdk.manager.EngineManager;
import com.tencent.qqmini.sdk.manager.InstalledEngine;
import com.tencent.qqmini.sdk.utils.DebugUtil;
import com.tencent.qqmini.sdk.utils.d;
import com.tencent.rfix.loader.utils.RFixConstants;
import java.io.File;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Iterator;

/* compiled from: P */
@SuppressLint({"WrongConstant"})
/* loaded from: classes23.dex */
public class MiniAppSoLoader {
    public static final String LIBNAME_LAME_MP3_SO = "mini_lamemp3";
    public static final String LIBNAME_LITEAVSDK_JAR = "liteavsdk.jar";
    public static final String LOCAL_ENGINE_VERSION = "0.1";
    private static final String TAG = "MiniAppSoLoader";
    private static final String TRTC_TAG = "[TRTC_SDK]";
    private static volatile MiniAppSoLoader sInstance;
    private InstalledEngine mEngine;
    private int mEngineType = 3;
    private boolean lameMp3SoLoaded = false;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public class a implements InvocationHandler {
        public a() {
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            if (Object.class.equals(method.getDeclaringClass())) {
                QMLog.e(MiniAppSoLoader.TAG, "InnerTXLiveBaseListenerImpl invoke:" + method.getName());
                try {
                    return method.invoke(this, objArr);
                } catch (Throwable th5) {
                    th5.printStackTrace();
                    return null;
                }
            }
            if ("OnLog".equals(method.getName())) {
                MiniAppSoLoader.this.onLog(objArr);
                return null;
            }
            return null;
        }
    }

    public MiniAppSoLoader() {
        Iterator<InstalledEngine> it = EngineInstaller.getInstalledEngine(3).iterator();
        while (it.hasNext()) {
            InstalledEngine next = it.next();
            if (next.isVerify) {
                this.mEngine = next;
                return;
            }
        }
    }

    public static MiniAppSoLoader g() {
        if (sInstance == null) {
            synchronized (EngineManager.class) {
                if (sInstance == null) {
                    sInstance = new MiniAppSoLoader();
                }
            }
        }
        return sInstance;
    }

    private String getBaseEnginePath(InstalledEngine installedEngine) {
        if (installedEngine != null && installedEngine.isVerify) {
            return installedEngine.engineDir;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onLog(Object[] objArr) {
        if (objArr.length == 3) {
            QMLog.e(TRTC_TAG, ((Integer) objArr[0]) + "||" + ((String) objArr[1]) + "||" + ((String) objArr[2]));
        }
    }

    public boolean isLameMp3SoLoaded() {
        return this.lameMp3SoLoaded;
    }

    public boolean loadAllMiniSo() {
        InstalledEngine installedEngine;
        final IWXLivePlayerProxy iWXLivePlayerProxy = (IWXLivePlayerProxy) ProxyManager.getNew(IWXLivePlayerProxy.class);
        boolean loadLibSo = loadLibSo(LIBNAME_LAME_MP3_SO);
        if (loadLibSo) {
            this.lameMp3SoLoaded = true;
        }
        if (loadLibSo && (installedEngine = this.mEngine) != null && !TextUtils.isEmpty(installedEngine.engineDir)) {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.qqmini.sdk.task.MiniAppSoLoader.1
                @Override // java.lang.Runnable
                public void run() {
                    QMLog.d(MiniAppSoLoader.TAG, "loadAllOk, TXLiveBase.setLibraryPath:" + MiniAppSoLoader.this.mEngine.engineDir);
                    iWXLivePlayerProxy.hookListenerAndGoOn(MiniAppSoLoader.this.mEngine.engineDir, new a());
                }
            });
        }
        return loadLibSo;
    }

    public boolean loadLameMp3So() {
        return loadLibSo(LIBNAME_LAME_MP3_SO);
    }

    protected boolean loadLibSo(String str) {
        if (this.mEngine != null && !TextUtils.isEmpty(str)) {
            String baseEnginePath = getBaseEnginePath(this.mEngine);
            String str2 = baseEnginePath + File.separator + RFixConstants.SO_PATH + str + ".so";
            QMLog.i(TAG, "[MiniEng]load so " + str + " from " + str2);
            if (TextUtils.isEmpty(baseEnginePath)) {
                return false;
            }
            try {
                d.c(str2);
                System.load(str2);
                if (this.mEngine.loadStatus == 1) {
                    this.mEngine.loadStatus = 3;
                }
                QMLog.i(TAG, "[MiniEng] load " + str2 + " success.");
                return true;
            } catch (Throwable th5) {
                QMLog.e(TAG, "[MiniEng] load " + str2 + " fail: " + DebugUtil.getPrintableStackTrace(th5), th5);
                this.mEngine.loadStatus = 2;
                return false;
            }
        }
        QMLog.e(TAG, "[MiniEng]load so " + str + " from " + this.mEngine);
        return false;
    }

    public void setEngine(InstalledEngine installedEngine) {
        this.mEngine = installedEngine;
    }
}
