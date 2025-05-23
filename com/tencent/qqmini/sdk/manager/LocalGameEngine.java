package com.tencent.qqmini.sdk.manager;

import android.text.TextUtils;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.BaseLibInfo;
import com.tencent.qqmini.sdk.utils.WnsUtil;

/* compiled from: P */
/* loaded from: classes23.dex */
public class LocalGameEngine {
    public static final String ASSETS_PROTOCOL = "assets://";
    public static final String GAME_ASSETS_PATH = "mini";
    public static final String LIBNAME_PNG_SO = "png-armeabi";
    public static final String LIBNAME_PNG_SO_ARMV7A = "png-armeabi-v7a";
    public static final String LOCAL_ENGINE_FLAG = "soTest";
    public static final String LOCAL_ENGINE_VERSION = "1.74.3.00001";
    public static final String LOG_TAG = "LocalGameEngine";
    private static volatile LocalGameEngine sInstance;
    public BaseLibInfo mLocalBaseLibInfo;
    public EngineVersion mLocalEngineVersion;

    public LocalGameEngine() {
        initLocalBaseLibInfo();
        initLocalEngineVersion();
    }

    public static LocalGameEngine g() {
        if (sInstance == null) {
            synchronized (LocalGameEngine.class) {
                if (sInstance == null) {
                    sInstance = new LocalGameEngine();
                }
            }
        }
        return sInstance;
    }

    private void initLocalBaseLibInfo() {
        BaseLibInfo baseLibInfo = new BaseLibInfo();
        this.mLocalBaseLibInfo = baseLibInfo;
        baseLibInfo.baseLibUrl = "assets://mini";
        baseLibInfo.baseLibVersion = WnsUtil.getGameEngineVersion("1.74.3.00001");
        long[] jArr = {0};
        QMLog.i("LocalGameEngine", "[MiniEng]initLocalBaseLibInfo start");
        boolean[] zArr = {false};
        QMLog.i("LocalGameEngine", "[MiniEng]initLocalBaseLibInfo cost=" + (System.currentTimeMillis() - System.currentTimeMillis()));
        if (zArr[0]) {
            this.mLocalBaseLibInfo.baseLibDesc = "{'file_length':" + jArr[0] + "}";
        } else {
            this.mLocalBaseLibInfo.baseLibDesc = "{'file_length':-1}";
        }
        BaseLibInfo baseLibInfo2 = this.mLocalBaseLibInfo;
        baseLibInfo2.baseLibKey = null;
        baseLibInfo2.baseLibType = 2;
    }

    private void initLocalEngineVersion() {
        this.mLocalEngineVersion = new EngineVersion(WnsUtil.getGameEngineVersion("1.74.3.00001"));
    }

    private boolean isQQSpeedPackage() {
        String packageName = AppLoaderFactory.g().getContext().getPackageName();
        QMLog.i("LocalGameEngine", "[MiniEng]isQQSpeedPackage " + packageName);
        if (!TextUtils.isEmpty(packageName) && packageName.toLowerCase().startsWith("com.tencent.qqlite")) {
            return true;
        }
        return false;
    }

    public boolean isDisabled() {
        return isQQSpeedPackage();
    }

    public boolean isWnsConfigModel() {
        return isQQSpeedPackage();
    }
}
