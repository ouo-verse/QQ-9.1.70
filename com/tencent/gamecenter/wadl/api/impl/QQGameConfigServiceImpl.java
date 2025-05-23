package com.tencent.gamecenter.wadl.api.impl;

import android.content.Intent;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.gamecenter.wadl.api.IQQGameConfigService;
import com.tencent.gamecenter.wadl.api.IQQGameTrpcSsoService;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.gamecenter.wadl.biz.receiver.GameCenterReceiver;
import com.tencent.gamecenter.wadl.util.GameCenterSpUtils;
import com.tencent.gamecenter.wadl.util.GameCenterUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingPermission;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import mqq.app.MobileQQ;
import nl0.h;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.qqgame.QQGameConfig$DownloadConfig;
import tencent.im.qqgame.QQGameConfig$GetDownloadConfigResponse;
import tencent.im.qqgame.QQGameConfig$KV;

/* compiled from: P */
/* loaded from: classes6.dex */
public class QQGameConfigServiceImpl implements IQQGameConfigService, h {
    public static final short FAIL_LIMIT = 3;
    public static final long INVALID_TIME = 86400000;
    private static final String TAG = "Wadl_QQGameConfigServiceImpl";
    public static final long UNCHECK = -1;
    private short updateConfFailCount = 0;
    private long updateConfTime = -1;
    HashSet<String> cmds = new HashSet<>();
    private HashMap<String, com.tencent.gamecenter.wadl.biz.entity.e> confMap = new HashMap<>();

    public QQGameConfigServiceImpl() {
        this.cmds.add(WadlProxyConsts.CMD_TRPC_GET_DOWNLOAD_CONFIG);
        ((IQQGameTrpcSsoService) QRoute.api(IQQGameTrpcSsoService.class)).addListener(this);
        loadConfig(WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE);
        GameCenterReceiver.registerReceiver();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkUpdate(boolean z16, long j3) {
        long readFromSpLong = GameCenterSpUtils.readFromSpLong(GameCenterSpUtils.KEY_LAST_GET_CONF_VERSION);
        QLog.d(TAG, 1, "checkUpdate isForce=" + z16 + ",newVersion=" + j3 + ",currVersion=" + readFromSpLong);
        if (j3 > -1 && j3 == readFromSpLong && GameCenterUtil.getConfigFile(GameCenterUtil.CONF_FILE_COMM).exists()) {
            return;
        }
        if (z16) {
            requestConfig(readFromSpLong);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.updateConfFailCount >= 3) {
            this.updateConfTime = currentTimeMillis;
            this.updateConfFailCount = (short) 0;
            return;
        }
        if (this.updateConfTime == -1) {
            this.updateConfTime = GameCenterSpUtils.readFromSpLong(GameCenterSpUtils.KEY_LAST_GET_CONF_TIME);
        }
        long j16 = this.updateConfTime;
        if (86400000 + j16 >= currentTimeMillis && j16 <= currentTimeMillis) {
            QLog.w(TAG, 1, "checkConfigUpdate time limit, currVersion=" + readFromSpLong);
            return;
        }
        requestConfig(readFromSpLong);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onLoadConfigSucc(String str) {
        com.tencent.gamecenter.wadl.biz.entity.g gVar;
        if ("update".equals(str) && (gVar = (com.tencent.gamecenter.wadl.biz.entity.g) this.confMap.get(IQQGameConfigService.KEY_CONF_COMM)) != null && gVar.f106803p) {
            reportPermission();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String parseConfigToJsonString(QQGameConfig$DownloadConfig qQGameConfig$DownloadConfig) {
        List<QQGameConfig$KV> list = qQGameConfig$DownloadConfig.data.get();
        if (list.size() < 1) {
            QLog.d(TAG, 1, "parseConfigToJsonString kvList is empty");
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            for (QQGameConfig$KV qQGameConfig$KV : list) {
                jSONObject.put(qQGameConfig$KV.key.get(), qQGameConfig$KV.value.get());
            }
            String jSONObject2 = jSONObject.toString();
            QLog.d(TAG, 1, "parseConfigToJsonString resString=" + jSONObject2);
            return jSONObject2;
        } catch (JSONException e16) {
            QLog.e(TAG, 1, "parseConfigToJsonString exception", e16);
            return null;
        }
    }

    private void reportPermission() {
        String str;
        String str2;
        String str3;
        try {
            WadlReportBuilder operId = new WadlReportBuilder().setDcId(WadlProxyConsts.TAG_DC_00087).setOperModule("999").setOperId(WadlProxyConsts.OPER_ID_PERMISSION);
            String str4 = "1";
            if (GameCenterUtil.isAppFirstInstall(MobileQQ.sMobileQQ.getPackageName(), MobileQQ.sMobileQQ)) {
                str = "1";
            } else {
                str = "0";
            }
            WadlReportBuilder ext = operId.setExt(22, str);
            if (QQNotificationManager.getInstance().areNotificationsEnabled(MobileQQ.sMobileQQ)) {
                str2 = "1";
            } else {
                str2 = "0";
            }
            WadlReportBuilder ext2 = ext.setExt(23, str2);
            if (((IQQFloatingPermission) QRoute.api(IQQFloatingPermission.class)).checkPermission(BaseApplication.getContext())) {
                str3 = "1";
            } else {
                str3 = "0";
            }
            WadlReportBuilder ext3 = ext2.setExt(24, str3);
            if (!GameCenterUtil.checkInstallPermission()) {
                str4 = "0";
            }
            ext3.setExt(25, str4).report();
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "reportPermission exception", th5);
        }
    }

    private void requestConfig(long j3) {
        QLog.d(TAG, 1, "requestConfig currVersion=" + j3);
        ((IQQGameTrpcSsoService) QRoute.api(IQQGameTrpcSsoService.class)).requestDownloadConfig(j3);
    }

    private synchronized void writeConfig(final QQGameConfig$DownloadConfig qQGameConfig$DownloadConfig) {
        QLog.d(TAG, 1, "writeConfig...newVersion=" + qQGameConfig$DownloadConfig.version.get());
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.gamecenter.wadl.api.impl.QQGameConfigServiceImpl.3
            @Override // java.lang.Runnable
            public void run() {
                File configFile = GameCenterUtil.getConfigFile(GameCenterUtil.CONF_FILE_COMM);
                if (configFile.exists()) {
                    configFile.delete();
                }
                String parseConfigToJsonString = QQGameConfigServiceImpl.this.parseConfigToJsonString(qQGameConfig$DownloadConfig);
                if (TextUtils.isEmpty(parseConfigToJsonString) || !FileUtils.writeFile(configFile.getAbsolutePath(), parseConfigToJsonString, false)) {
                    return;
                }
                GameCenterSpUtils.writeToSpLong(GameCenterSpUtils.KEY_LAST_GET_CONF_VERSION, qQGameConfig$DownloadConfig.version.get());
                GameCenterSpUtils.writeToSpLong(GameCenterSpUtils.KEY_LAST_GET_CONF_TIME, QQGameConfigServiceImpl.this.updateConfTime);
                Intent intent = new Intent(WadlProxyConsts.ACTION_GAME_CENTER_DYNAMIC_ACTION);
                intent.setPackage(MobileQQ.sMobileQQ.getPackageName());
                intent.putExtra("key_event_id", 1);
                MobileQQ.sMobileQQ.sendBroadcast(intent);
            }
        }, 16, null, false);
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameConfigService
    public void checkConfigUpdate(final boolean z16, final long j3) {
        boolean z17;
        if (Looper.getMainLooper() == Looper.myLooper()) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.gamecenter.wadl.api.impl.QQGameConfigServiceImpl.2
                @Override // java.lang.Runnable
                public void run() {
                    QQGameConfigServiceImpl.this.checkUpdate(z16, j3);
                }
            }, 16, null, true);
        } else {
            checkUpdate(z16, j3);
        }
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameConfigService
    public <T> T getConfig(String str) {
        return (T) this.confMap.get(str);
    }

    @Override // nl0.h
    public HashSet<String> getFilterCmds() {
        return this.cmds;
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameConfigService
    public void handlePushConfigCheck(String str) {
        long j3 = -1;
        if (!TextUtils.isEmpty(str)) {
            try {
                j3 = new JSONObject(str).optLong("version", -1L);
            } catch (JSONException e16) {
                QLog.e(TAG, 1, "handlePushConfigCheck exception", e16);
            }
        }
        checkConfigUpdate(true, j3);
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameConfigService
    public void loadConfig(final String str) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.gamecenter.wadl.api.impl.QQGameConfigServiceImpl.1
            @Override // java.lang.Runnable
            public void run() {
                String str2;
                File configFile = GameCenterUtil.getConfigFile(GameCenterUtil.CONF_FILE_COMM);
                if (configFile.exists()) {
                    str2 = FileUtils.readFileContent(configFile);
                } else {
                    str2 = null;
                }
                if (QLog.isColorLevel()) {
                    QLog.d(QQGameConfigServiceImpl.TAG, 1, "loadConfig from=" + str + ",processId=" + MobileQQ.sProcessId + ",content=" + str2);
                }
                synchronized (QQGameConfigServiceImpl.this.confMap) {
                    QQGameConfigServiceImpl.this.confMap.clear();
                    if (!TextUtils.isEmpty(str2)) {
                        try {
                            JSONObject jSONObject = new JSONObject(str2);
                            if (jSONObject.length() > 0) {
                                com.tencent.gamecenter.wadl.biz.entity.g gVar = new com.tencent.gamecenter.wadl.biz.entity.g(IQQGameConfigService.KEY_CONF_COMM);
                                gVar.a(jSONObject, str);
                                QQGameConfigServiceImpl.this.confMap.put(IQQGameConfigService.KEY_CONF_COMM, gVar);
                            }
                        } catch (Exception e16) {
                            QLog.e(QQGameConfigServiceImpl.TAG, 1, "loadConfig exception", e16);
                        }
                        QQGameConfigServiceImpl.this.onLoadConfigSucc(str);
                    }
                }
            }
        }, 64, null, false);
    }

    @Override // nl0.h
    public void onTrpcRsp(String str, boolean z16, int i3, int i16, Intent intent, Object obj) {
        QQGameConfig$DownloadConfig qQGameConfig$DownloadConfig;
        if (!WadlProxyConsts.CMD_TRPC_GET_DOWNLOAD_CONFIG.equals(str)) {
            return;
        }
        if (!z16) {
            QLog.w(TAG, 1, "onTrpcRsp getDownloadConfig fail");
            this.updateConfFailCount = (short) (this.updateConfFailCount + 1);
            return;
        }
        this.updateConfFailCount = (short) 0;
        this.updateConfTime = System.currentTimeMillis();
        if ((obj instanceof QQGameConfig$GetDownloadConfigResponse) && (qQGameConfig$DownloadConfig = ((QQGameConfig$GetDownloadConfigResponse) obj).config.get()) != null) {
            writeConfig(qQGameConfig$DownloadConfig);
        }
    }
}
