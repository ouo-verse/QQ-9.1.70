package com.tencent.mobileqq.mini.push;

import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

/* loaded from: classes33.dex */
public class MiniAppPushControl {
    public static final String KEY_CTRL_CMD = "key_ctrl_cmd";
    public static final String KEY_CTRL_CMD_CLEAR_CACHE = "clear_cache";
    public static final String KEY_CTRL_CMD_DOWNGRADE = "sdk_downgrade";
    public static final String KEY_CTRL_CMD_UPLOAD_LOG = "upload_log";
    public static final String TAG = "MiniAppPushControl";
    private static MiniAppPushControl instance;
    private static Object lock = new Object();
    public String mUin;
    public HashMap<String, PushAction> pushActions;

    MiniAppPushControl(String str) {
        HashMap<String, PushAction> hashMap = new HashMap<>();
        this.pushActions = hashMap;
        this.mUin = str;
        hashMap.put(KEY_CTRL_CMD_UPLOAD_LOG, new UploadLogAction());
        this.pushActions.put(KEY_CTRL_CMD_CLEAR_CACHE, new ClearCacheAction());
        this.pushActions.put(KEY_CTRL_CMD_DOWNGRADE, new SDKDowngradeAction());
    }

    public static MiniAppPushControl getInstance(String str) {
        if (instance == null) {
            synchronized (lock) {
                if (instance == null) {
                    instance = new MiniAppPushControl(str);
                }
            }
        }
        return instance;
    }

    public void processControlInfo(MiniAppControlInfo miniAppControlInfo) {
        try {
            if (this.pushActions.containsKey(miniAppControlInfo.cmd)) {
                QLog.d(TAG, 1, "MiniAppPushControl processControlInfo cmd:" + miniAppControlInfo);
                this.pushActions.get(miniAppControlInfo.cmd).exec(miniAppControlInfo);
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "processControlInfo failed:", e16);
        }
    }
}
