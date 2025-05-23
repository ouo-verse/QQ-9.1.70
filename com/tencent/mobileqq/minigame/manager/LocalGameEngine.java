package com.tencent.mobileqq.minigame.manager;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.sdk.BaseLibInfo;
import com.tencent.mobileqq.minigame.utils.GameWnsUtils;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes33.dex */
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
        baseLibInfo.baseLibVersion = GameWnsUtils.getGameEngineVersion("1.74.3.00001");
        long[] jArr = {0};
        QLog.i("LocalGameEngine", 1, "[MiniEng]initLocalBaseLibInfo start");
        boolean[] zArr = {false};
        QLog.i("LocalGameEngine", 1, "[MiniEng]initLocalBaseLibInfo cost=" + (System.currentTimeMillis() - System.currentTimeMillis()));
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
        this.mLocalEngineVersion = new EngineVersion(GameWnsUtils.getGameEngineVersion("1.74.3.00001"));
    }

    private boolean isQQSpeedPackage() {
        String packageName = BaseApplicationImpl.getApplication().getPackageName();
        QLog.i("LocalGameEngine", 1, "[MiniEng]isQQSpeedPackage " + packageName);
        return !TextUtils.isEmpty(packageName) && packageName.toLowerCase().startsWith("com.tencent.qqspeed");
    }

    public boolean isDisabled() {
        return isQQSpeedPackage();
    }

    public boolean isWnsConfigModel() {
        return isQQSpeedPackage();
    }
}
