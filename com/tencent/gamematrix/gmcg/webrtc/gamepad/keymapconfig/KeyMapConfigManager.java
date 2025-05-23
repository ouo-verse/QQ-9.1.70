package com.tencent.gamematrix.gmcg.webrtc.gamepad.keymapconfig;

import android.content.Context;
import android.graphics.PointF;
import android.util.Log;
import com.android.volley.VolleyError;
import com.android.volley.h;
import com.google.gson.Gson;
import com.tencent.gamematrix.gmcg.base.helper.CGBaseHelper;
import com.tencent.gamematrix.gmcg.base.log.CGLog;
import com.tencent.gamematrix.gmcg.base.network.CGGsonBodyRequest;
import com.tencent.gamematrix.gmcg.base.network.CGHttpReqManager;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.TVInputManager;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.keymapconfig.TVKeyMapMsg;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.utils.FileUtilX;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes6.dex */
public class KeyMapConfigManager {
    public static final String CONFIG_MSG_FAILED = "Failed to load key mapping configuration, please exit the game and try again!";
    public static final int FIGHTING_FOUR_CODE = 294;
    public static final int FIGHTING_THREE_CODE = 293;
    public static final String KEY_MAP_CONFIG_FILE_NAME = "keymap_config.json";
    private static volatile KeyMapConfigManager sKeyMapConfigManager;
    private KeyMapSceneConfig mCombinationRestoreConfig;
    private KeyMapSceneConfig mCurrentSceneConfig;
    private KeyMapConfig mKeyMapConfig;
    private TVKeyMapMsg.IKeyMapConfigRespListener mKeyMapConfigRespListener;
    private String mTGPACurrentScene;
    private final String TAG = "KeyMapConfigManager";
    private int mTvConfigCount = 0;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class KeyMapReq {
        String szGameId;

        /* renamed from: tk, reason: collision with root package name */
        String f108157tk;
    }

    KeyMapConfigManager() {
        if (sKeyMapConfigManager == null) {
        } else {
            throw new RuntimeException("already construct!");
        }
    }

    private KeyMapSceneConfig findScenesConfigById(int i3, int i16) {
        int sceneSize;
        KeyMapConfig keyMapConfig = this.mKeyMapConfig;
        if (keyMapConfig == null || (sceneSize = keyMapConfig.getSceneSize(i3)) <= 0) {
            return null;
        }
        for (int i17 = 0; i17 < sceneSize; i17++) {
            KeyMapSceneConfig sceneConfig = this.mKeyMapConfig.getSceneConfig(i3, i17);
            if (sceneConfig != null && sceneConfig.getPrimarySceneId() == i16) {
                return sceneConfig;
            }
        }
        return null;
    }

    private KeyMapSceneConfig findScenesConfigByMonitorId(int i3) {
        int sceneSize;
        KeyMapConfig keyMapConfig = this.mKeyMapConfig;
        if (keyMapConfig == null || (sceneSize = keyMapConfig.getSceneSize(5)) <= 0) {
            return null;
        }
        for (int i16 = 0; i16 < sceneSize; i16++) {
            KeyMapSceneConfig sceneConfig = this.mKeyMapConfig.getSceneConfig(5, i16);
            if (sceneConfig != null && sceneConfig.getId() == i3) {
                return sceneConfig;
            }
        }
        return null;
    }

    private KeyMapSceneConfig findScenesConfigByTGPAId(int i3, String str) {
        String[] tGPASceneIds;
        KeyMapConfig keyMapConfig = this.mKeyMapConfig;
        KeyMapSceneConfig keyMapSceneConfig = null;
        if (keyMapConfig != null && str != null) {
            int sceneSize = keyMapConfig.getSceneSize(i3);
            if (sceneSize <= 0) {
                return null;
            }
            for (int i16 = 0; i16 < sceneSize; i16++) {
                KeyMapSceneConfig sceneConfig = this.mKeyMapConfig.getSceneConfig(i3, i16);
                if (sceneConfig != null && (tGPASceneIds = sceneConfig.getTGPASceneIds()) != null) {
                    int i17 = 0;
                    while (true) {
                        if (i17 >= tGPASceneIds.length) {
                            break;
                        }
                        String str2 = tGPASceneIds[i17];
                        if (str2 != null && str2.compareTo(str) == 0) {
                            keyMapSceneConfig = sceneConfig;
                            break;
                        }
                        i17++;
                    }
                    if (keyMapSceneConfig != null) {
                        break;
                    }
                }
            }
        }
        return keyMapSceneConfig;
    }

    private KeyMapSceneConfig findTGPAPrimaryScene(int i3) {
        int sceneSize;
        KeyMapConfig keyMapConfig = this.mKeyMapConfig;
        if (keyMapConfig == null || (sceneSize = keyMapConfig.getSceneSize(i3)) <= 0) {
            return null;
        }
        for (int i16 = 0; i16 < sceneSize; i16++) {
            KeyMapSceneConfig sceneConfig = this.mKeyMapConfig.getSceneConfig(i3, i16);
            if (sceneConfig != null && sceneConfig.getPrimarySceneId() == 1) {
                return sceneConfig;
            }
        }
        return null;
    }

    public static KeyMapConfigManager getInstance() {
        if (sKeyMapConfigManager == null) {
            synchronized (KeyMapConfigManager.class) {
                if (sKeyMapConfigManager == null) {
                    sKeyMapConfigManager = new KeyMapConfigManager();
                }
            }
        }
        return sKeyMapConfigManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$pullAndLoadConfig$0(final TVKeyMapMsg.TVMsg tVMsg) {
        new BaseThread() { // from class: com.tencent.gamematrix.gmcg.webrtc.gamepad.keymapconfig.KeyMapConfigManager.1
            @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
            public void run() {
                KeyMapConfigManager.this.onKeyMapConfigResp(tVMsg);
            }
        }.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$pullAndLoadConfig$1(VolleyError volleyError) {
        showPullAndLoadConfigError(CONFIG_MSG_FAILED, volleyError.toString());
    }

    private boolean loadAssetConfig(Context context, String str) {
        try {
            onKeyMapConfigResp((TVKeyMapMsg.TVMsg) new Gson().fromJson(FileUtilX.readAssetFile(context, str), TVKeyMapMsg.TVMsg.class));
            return true;
        } catch (Exception e16) {
            e16.printStackTrace();
            return false;
        }
    }

    private boolean loadFilesDirConfig(Context context, String str) {
        try {
            KeyMapSceneConfig keyMapSceneConfig = (KeyMapSceneConfig) new Gson().fromJson(FileUtilX.readFilesDirFile(context, str), KeyMapSceneConfig.class);
            if (keyMapSceneConfig != null) {
                setCurrentSceneConfig(keyMapSceneConfig);
            }
            return true;
        } catch (Exception e16) {
            e16.printStackTrace();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onKeyMapConfigResp(TVKeyMapMsg.TVMsg tVMsg) {
        if (tVMsg != null) {
            KeyMapConfig keyMapConfig = new KeyMapConfig();
            if (keyMapConfig.parseKeyMapMsg(tVMsg)) {
                this.mKeyMapConfig = keyMapConfig;
                TVKeyMapMsg.IKeyMapConfigRespListener iKeyMapConfigRespListener = this.mKeyMapConfigRespListener;
                if (iKeyMapConfigRespListener != null) {
                    iKeyMapConfigRespListener.onRespConfigLoadSuccess(this, GlobalConfig.getInstance().isNeedLogin(), GlobalConfig.getInstance().getMaxPlayerNum());
                    this.mKeyMapConfigRespListener = null;
                    return;
                }
                return;
            }
            showPullAndLoadConfigError(CONFIG_MSG_FAILED, "parse config msg failed");
            return;
        }
        showPullAndLoadConfigError(CONFIG_MSG_FAILED, "tvMsg is NULL");
    }

    private void setCurrentSceneConfig(KeyMapSceneConfig keyMapSceneConfig) {
        this.mCurrentSceneConfig = keyMapSceneConfig;
        if (keyMapSceneConfig != null) {
            float f16 = keyMapSceneConfig.mTouchMapSensitivityX;
            if (f16 != 0.0f) {
                float f17 = keyMapSceneConfig.mTouchMapSensitivityY;
                if (f17 != 0.0f) {
                    GlobalConfig.kTouchMapSensitivityX = f16;
                    GlobalConfig.kTouchMapSensitivityY = f17;
                }
            }
            if (GlobalConfig.kTouchMapPos != null) {
                PointF sceneTouchMapPos = keyMapSceneConfig.getSceneTouchMapPos();
                if (sceneTouchMapPos != null) {
                    PointF pointF = GlobalConfig.kTouchMapPos;
                    pointF.x = sceneTouchMapPos.x;
                    pointF.y = sceneTouchMapPos.y;
                } else {
                    PointF pointF2 = GlobalConfig.kTouchMapPos;
                    pointF2.x = 0.0f;
                    pointF2.y = 0.0f;
                }
            } else {
                CGLog.e("touch map pos is null object!");
            }
            PointF pointF3 = keyMapSceneConfig.mSGameSkillsCancelPos;
            if (pointF3 != null) {
                float f18 = pointF3.x;
                if (f18 != 0.0f) {
                    float f19 = pointF3.y;
                    if (f19 != 0.0f) {
                        PointF pointF4 = GlobalConfig.kSGameSkillCancelPos;
                        if (pointF4 != null) {
                            pointF4.x = f18;
                            pointF4.y = f19;
                        } else {
                            CGLog.e("sgame cancel pos is null object!");
                        }
                    }
                }
            }
            GlobalConfig.kIsJoystickToMove = keyMapSceneConfig.mIsJoystickToMove;
        }
    }

    public void clear() {
        clearCurrentSceneConfig();
    }

    public void clearCurrentSceneConfig() {
        KeyMapSceneConfig keyMapSceneConfig = this.mCurrentSceneConfig;
        if (keyMapSceneConfig != null) {
            keyMapSceneConfig.clear();
        }
        setCurrentSceneConfig(null);
    }

    public KeyMapSceneConfig findScenesConfigByScenesId(int i3, int i16) {
        int sceneSize;
        KeyMapConfig keyMapConfig = this.mKeyMapConfig;
        if (keyMapConfig == null || (sceneSize = keyMapConfig.getSceneSize(i3)) <= 0) {
            return null;
        }
        for (int i17 = 0; i17 < sceneSize; i17++) {
            KeyMapSceneConfig sceneConfig = this.mKeyMapConfig.getSceneConfig(i3, i17);
            if (sceneConfig != null && sceneConfig.getId() == i16) {
                return sceneConfig;
            }
        }
        return null;
    }

    public KeyMapSceneConfig getCurrentSceneConfig() {
        return this.mCurrentSceneConfig;
    }

    public KeyMapConfig getKeyMapConfig() {
        return this.mKeyMapConfig;
    }

    public boolean loadGameScene(int i3, int i16) {
        KeyMapSceneConfig findScenesConfigById = findScenesConfigById(i3, i16);
        if (findScenesConfigById != null) {
            setCurrentSceneConfig(findScenesConfigById);
            return true;
        }
        return false;
    }

    public boolean loadKeyCombination() {
        this.mCombinationRestoreConfig = this.mCurrentSceneConfig;
        KeyMapConfig keyMapConfig = this.mKeyMapConfig;
        if (keyMapConfig == null) {
            return false;
        }
        KeyMapSceneConfig nextSceneConfig = keyMapConfig.getNextSceneConfig(6);
        if (nextSceneConfig != null) {
            setCurrentSceneConfig(nextSceneConfig);
            return true;
        }
        setCurrentSceneConfig(null);
        return false;
    }

    public void loadLocalKeyMapConfig(Context context, String str) {
        String str2;
        if (str != null) {
            str2 = str + "." + KEY_MAP_CONFIG_FILE_NAME;
        } else {
            str2 = KEY_MAP_CONFIG_FILE_NAME;
        }
        if (FileUtilX.isFilesDirFile(context, str2)) {
            loadFilesDirConfig(context, str2);
        } else if (!loadAssetConfig(context, str2)) {
            loadAssetConfig(context, KEY_MAP_CONFIG_FILE_NAME);
        }
    }

    public boolean loadNextGamepadConfig() {
        KeyMapConfig keyMapConfig;
        KeyMapConfig keyMapConfig2 = this.mKeyMapConfig;
        if (keyMapConfig2 == null || !keyMapConfig2.hasSceneConfig(1) || (keyMapConfig = this.mKeyMapConfig) == null) {
            return false;
        }
        KeyMapSceneConfig nextSceneConfig = keyMapConfig.getNextSceneConfig(1);
        if (nextSceneConfig != null) {
            setCurrentSceneConfig(nextSceneConfig);
            return true;
        }
        setCurrentSceneConfig(null);
        return false;
    }

    public boolean loadNextMFGamepadConfig() {
        KeyMapConfig keyMapConfig;
        KeyMapConfig keyMapConfig2 = this.mKeyMapConfig;
        if (keyMapConfig2 == null || !keyMapConfig2.hasSceneConfig(3) || (keyMapConfig = this.mKeyMapConfig) == null) {
            return false;
        }
        KeyMapSceneConfig nextSceneConfig = keyMapConfig.getNextSceneConfig(3);
        if (nextSceneConfig != null) {
            setCurrentSceneConfig(nextSceneConfig);
            return true;
        }
        setCurrentSceneConfig(null);
        return false;
    }

    public boolean loadNextSceneConfig(int i3) {
        KeyMapSceneConfig lastSceneConfig;
        KeyMapConfig keyMapConfig = this.mKeyMapConfig;
        if (keyMapConfig == null || (lastSceneConfig = keyMapConfig.getLastSceneConfig(i3)) == null) {
            return false;
        }
        if (this.mCurrentSceneConfig == lastSceneConfig) {
            setCurrentSceneConfig(null);
            return false;
        }
        KeyMapSceneConfig nextSceneConfig = this.mKeyMapConfig.getNextSceneConfig(i3);
        setCurrentSceneConfig(nextSceneConfig);
        if (nextSceneConfig == null) {
            return false;
        }
        return true;
    }

    public boolean loadSDKSceneConfig(int i3) {
        int i16;
        boolean z16 = true;
        if (TVInputManager.getInstance().hasMFGamepadConnected()) {
            i16 = 3;
        } else {
            i16 = 1;
        }
        KeyMapConfig keyMapConfig = this.mKeyMapConfig;
        if (keyMapConfig != null) {
            KeyMapSceneConfig loadSceneConfigById = keyMapConfig.loadSceneConfigById(i16, i3);
            if (loadSceneConfigById != null) {
                setCurrentSceneConfig(loadSceneConfigById);
                CGLog.i("loadSDKSceneConfig find config~");
            } else {
                CGLog.i("loadSDKSceneConfig id=" + i3 + " config is not found!");
                z16 = false;
            }
            return z16;
        }
        CGLog.i("loadSDKSceneConfig keymapconfig is null object!");
        return false;
    }

    public boolean loadSceneConfig(int i3, int i16) {
        KeyMapConfig keyMapConfig = this.mKeyMapConfig;
        if (keyMapConfig == null) {
            return false;
        }
        KeyMapSceneConfig loadSceneConfigByIndex = keyMapConfig.loadSceneConfigByIndex(i3, i16);
        if (loadSceneConfigByIndex != null) {
            setCurrentSceneConfig(loadSceneConfigByIndex);
            return true;
        }
        setCurrentSceneConfig(null);
        return false;
    }

    public boolean loadSceneConfigFromMonitor(int i3, String str, boolean z16) {
        CGLog.i("DcEvent loadScene trMonitorSceneId = " + i3 + "isSceneLeft" + z16);
        if (i3 != 293 && i3 != 294) {
            KeyMapSceneConfig findScenesConfigByMonitorId = findScenesConfigByMonitorId(i3);
            if (findScenesConfigByMonitorId != null) {
                findScenesConfigByMonitorId.setIsSceneLeft(z16);
                findScenesConfigByMonitorId.checkChooseWindowItemShowState(str, i3);
                setCurrentSceneConfig(findScenesConfigByMonitorId);
                return true;
            }
            setCurrentSceneConfig(null);
            return false;
        }
        return loadNextMFGamepadConfig(i3);
    }

    public boolean loadSceneConfigFromTGPA(String str) {
        int i3;
        CGLog.i("DcEvent loadScene sceneid = " + str);
        if (TVInputManager.getInstance().hasMFGamepadConnected()) {
            i3 = 3;
        } else {
            i3 = 1;
        }
        KeyMapSceneConfig findScenesConfigByTGPAId = findScenesConfigByTGPAId(i3, str);
        if (findScenesConfigByTGPAId != null) {
            String str2 = this.mTGPACurrentScene;
            if (str2 != null && str != null && str2.equals(str)) {
                CGLog.i("DcEvent already the current scene config!");
                return false;
            }
            this.mTGPACurrentScene = str;
            setCurrentSceneConfig(findScenesConfigByTGPAId);
            return true;
        }
        CGLog.i("DcEvent can't find scene id");
        this.mTGPACurrentScene = null;
        return false;
    }

    public boolean loadTGPAPrimaryScene(int i3) {
        KeyMapSceneConfig keyMapSceneConfig;
        CGLog.i("DcEvent load PrimaryScene");
        String str = this.mTGPACurrentScene;
        if (str != null) {
            keyMapSceneConfig = findScenesConfigByTGPAId(i3, str);
        } else {
            keyMapSceneConfig = null;
        }
        if (keyMapSceneConfig == null) {
            keyMapSceneConfig = findTGPAPrimaryScene(i3);
        }
        if (keyMapSceneConfig != null) {
            setCurrentSceneConfig(keyMapSceneConfig);
            return true;
        }
        return false;
    }

    public boolean loadTVControllerConfig() {
        KeyMapConfig keyMapConfig = this.mKeyMapConfig;
        if (keyMapConfig != null && keyMapConfig.hasSceneConfig(2)) {
            if (this.mTvConfigCount == 0) {
                this.mTvConfigCount = 1;
                KeyMapSceneConfig loadTVControllerConfig = this.mKeyMapConfig.loadTVControllerConfig();
                if (loadTVControllerConfig != null) {
                    setCurrentSceneConfig(loadTVControllerConfig);
                    return true;
                }
                setCurrentSceneConfig(null);
            }
            this.mTvConfigCount = 0;
        }
        return false;
    }

    public int pullAndLoadConfig(Context context, String str, TVKeyMapMsg.IKeyMapConfigRespListener iKeyMapConfigRespListener) {
        this.mKeyMapConfigRespListener = iKeyMapConfigRespListener;
        CGGsonBodyRequest cGGsonBodyRequest = new CGGsonBodyRequest(0, str, TVKeyMapMsg.TVMsg.class, new Gson().toJson(new KeyMapReq()), new PointFAdapter(), new h.b() { // from class: com.tencent.gamematrix.gmcg.webrtc.gamepad.keymapconfig.a
            @Override // com.android.volley.h.b
            public final void onResponse(Object obj) {
                KeyMapConfigManager.this.lambda$pullAndLoadConfig$0((TVKeyMapMsg.TVMsg) obj);
            }
        }, new h.a() { // from class: com.tencent.gamematrix.gmcg.webrtc.gamepad.keymapconfig.b
            @Override // com.android.volley.h.a
            public final void onErrorResponse(VolleyError volleyError) {
                KeyMapConfigManager.this.lambda$pullAndLoadConfig$1(volleyError);
            }
        });
        cGGsonBodyRequest.setTag("KeyMapConfigManager");
        CGHttpReqManager.get().newReq(cGGsonBodyRequest);
        return 0;
    }

    public boolean restoreCombinationRestoreConfig() {
        boolean z16;
        setCurrentSceneConfig(this.mCombinationRestoreConfig);
        if (this.mCombinationRestoreConfig != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.mCombinationRestoreConfig = null;
        return z16;
    }

    public boolean saveLocalConfig(KeyMapSceneConfig keyMapSceneConfig, Context context, String str) {
        Gson gson = new Gson();
        try {
            FileWriter fileWriter = new FileWriter(context.getFilesDir().getAbsolutePath() + File.separator + str);
            try {
                gson.toJson(keyMapSceneConfig, fileWriter);
                fileWriter.close();
                return true;
            } finally {
            }
        } catch (IOException e16) {
            e16.printStackTrace();
            return false;
        }
    }

    public void setGameTypeMixedKeyMapEnabled(boolean z16) {
        GlobalConfig.getInstance().setGameTypeMixedKeyMapEnabled(z16);
    }

    public void showPullAndLoadConfigError(String str, String str2) {
        CGBaseHelper.showToast(str);
        Log.d("KeyMapConfigManager", str2);
    }

    public boolean loadNextMFGamepadConfig(int i3) {
        KeyMapConfig keyMapConfig = this.mKeyMapConfig;
        if (keyMapConfig == null) {
            return false;
        }
        KeyMapSceneConfig loadMFGamepadConfig = keyMapConfig.loadMFGamepadConfig(i3);
        if (loadMFGamepadConfig != null) {
            setCurrentSceneConfig(loadMFGamepadConfig);
            return true;
        }
        setCurrentSceneConfig(null);
        return false;
    }
}
