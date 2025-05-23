package com.tencent.gamecenter.wadl.api.impl;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInstaller;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.gamecenter.wadl.api.IQQGameInstallService;
import com.tencent.gamecenter.wadl.api.IQQGameTrpcService;
import com.tencent.gamecenter.wadl.biz.entity.ApkParams;
import com.tencent.gamecenter.wadl.biz.entity.TrpcProxy;
import com.tencent.gamecenter.wadl.biz.entity.WadlParams;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener;
import com.tencent.gamecenter.wadl.sdk.app.WadlInstallActivity;
import com.tencent.gamecenter.wadl.util.GameCenterUtil;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.comm.api.receiver.VasReceiver;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import mqq.app.MobileQQ;
import tencent.im.qqgame.QQGameQfsSubscribe;

/* compiled from: P */
/* loaded from: classes6.dex */
public class QQGameInstallServiceImpl implements IQQGameInstallService, WadlTrpcListener {
    private static final String MMKV_KEY_GAME_CHECK_INSTALL_MODEL = "mmkv_key_game_check_install_model";
    public static final String TAG = "Installer_QQGameInstallServiceImpl";
    private final ArrayList<nl0.b> listenerList = new ArrayList<>();
    HashSet<String> filterCmds = new HashSet<>();

    public QQGameInstallServiceImpl() {
        ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).addListener(this);
        this.filterCmds.add(WadlProxyConsts.CMD_CHECK_INSTALL_MODEL);
    }

    private void callback(int i3, int i16, long j3) {
        QLog.d(TAG, 1, "callback sessionId=" + i3 + ",status=" + i16);
        synchronized (this.listenerList) {
            Iterator<nl0.b> it = this.listenerList.iterator();
            while (it.hasNext()) {
                nl0.b next = it.next();
                if (i16 == 1) {
                    next.onSendConfirm(i3, j3);
                } else if (i16 == 2) {
                    next.onAbort(i3);
                }
            }
        }
    }

    private void jumpInstallActivity(final WadlParams wadlParams, final String str, final long j3) {
        QLog.d(TAG, 1, "jumpInstallActivity localAPKPath=" + str + ",fileSize=" + j3);
        ThreadManagerV2.checkAndRunOnUIThread(new Runnable() { // from class: com.tencent.gamecenter.wadl.api.impl.QQGameInstallServiceImpl.1
            @Override // java.lang.Runnable
            public void run() {
                ApkParams apkParams = new ApkParams();
                WadlParams wadlParams2 = wadlParams;
                apkParams.f106716d = wadlParams2.appId;
                apkParams.f106717e = wadlParams2.appName;
                apkParams.f106718f = wadlParams2.packageName;
                apkParams.f106721m = wadlParams2.sourceId;
                apkParams.C = wadlParams2.iconUrl;
                apkParams.E = wadlParams2.apkChannel;
                apkParams.f106720i = str;
                apkParams.f106719h = j3;
                Intent intent = new Intent();
                intent.putExtra("public_fragment_window_feature", 1);
                intent.putExtra(WadlProxyConsts.WADL_INSTALL_REQUEST, apkParams);
                QPublicFragmentActivity.b.d(intent, QPublicFragmentActivity.class, WadlInstallActivity.class);
            }
        });
    }

    private void onGetCheckInstallModelRsp(long j3, Intent intent, TrpcProxy.TrpcInovkeRsp trpcInovkeRsp) {
        WadlParams wadlParams;
        long j16;
        String str;
        if (intent != null) {
            wadlParams = (WadlParams) intent.getParcelableExtra(WadlProxyConsts.PARAM_DOWNLOAD_INFO);
            str = intent.getStringExtra(WadlProxyConsts.KEY_LOCAL_APK_PATH);
            j16 = intent.getLongExtra(WadlProxyConsts.PARAM_APK_FILE_SIZE, 0L);
        } else {
            wadlParams = null;
            j16 = 0;
            str = null;
        }
        boolean z16 = false;
        QLog.d(TAG, 1, "onGetCheckInstallModelRsp ret=", j3 + ",wadlParams=" + wadlParams + ",localAPKPath=" + str + ",fileSize=" + j16);
        if (wadlParams != null && !TextUtils.isEmpty(str) && j16 >= 1) {
            if (j3 == 0 && trpcInovkeRsp.data.has()) {
                try {
                    QQGameQfsSubscribe.GetInstallationReminderRsp getInstallationReminderRsp = new QQGameQfsSubscribe.GetInstallationReminderRsp();
                    getInstallationReminderRsp.mergeFrom(trpcInovkeRsp.data.get().toByteArray());
                    z16 = getInstallationReminderRsp.is_support_phone_model.get();
                } catch (Exception e16) {
                    QLog.e(TAG, 1, "onGetCheckInstallModelRsp exception=", e16);
                }
            }
            QLog.d(TAG, 1, "onGetCheckInstallModelRsp isSupport=" + z16);
            if (!z16) {
                GameCenterUtil.goToInstall(wadlParams.appId, wadlParams.packageName, str, wadlParams.sourceId, GameCenterUtil.INSTALL_FROM_CHECK_MODEL);
            } else {
                jumpInstallActivity(wadlParams, str, j16);
            }
        }
    }

    private void sendConfirmIntent(Context context, String str, String str2, Intent intent) {
        QLog.d(TAG, 1, "sendConfirmIntent confirmIntent=" + intent + ",pkgName=" + str2);
        if (intent != null && context != null) {
            if (TextUtils.isEmpty(str)) {
                str = "biz_src_zf_games";
            }
            intent.putExtra("big_brother_source_key", str);
            intent.putExtra("big_brother_pkg_name_key", str2);
            intent.addFlags(268435456);
            context.startActivity(intent);
        }
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameInstallService
    public void addInstallListener(nl0.b bVar) {
        synchronized (this.listenerList) {
            if (!this.listenerList.contains(bVar)) {
                this.listenerList.add(bVar);
            }
        }
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameInstallService
    public void checkInstallModel(WadlParams wadlParams, String str, long j3) {
        if (wadlParams != null && !TextUtils.isEmpty(wadlParams.appId) && !TextUtils.isEmpty(str) && j3 >= 1) {
            QLog.d(TAG, 1, "checkInstallModel wadlParams=" + wadlParams + ",localAPKPath=" + str);
            QQGameQfsSubscribe.GetInstallationReminderReq getInstallationReminderReq = new QQGameQfsSubscribe.GetInstallationReminderReq();
            getInstallationReminderReq.app_id.set(wadlParams.appId);
            getInstallationReminderReq.phone_model.set(DeviceInfoMonitor.getModel());
            TrpcProxy.TrpcInovkeReq createTrpcInvokeReq = ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).createTrpcInvokeReq(WadlProxyConsts.CMD_CHECK_INSTALL_MODEL, false, getInstallationReminderReq.toByteArray());
            TrpcProxy.TrpcListReq trpcListReq = new TrpcProxy.TrpcListReq();
            trpcListReq.list.add(createTrpcInvokeReq);
            Bundle bundle = new Bundle();
            bundle.putParcelable(WadlProxyConsts.PARAM_DOWNLOAD_INFO, wadlParams);
            bundle.putString(WadlProxyConsts.KEY_LOCAL_APK_PATH, str);
            bundle.putLong(WadlProxyConsts.PARAM_APK_FILE_SIZE, j3);
            ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).requestTrpc(trpcListReq, bundle);
        }
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameInstallService
    public boolean execInstallCommand(PackageInstaller packageInstaller, int i3, ApkParams apkParams) {
        QLog.i(TAG, 1, "execInstallCommand sessionId=" + i3 + ",apkParams=" + apkParams);
        if (packageInstaller == null || apkParams == null) {
            return false;
        }
        PackageInstaller.Session session = null;
        try {
            session = packageInstaller.openSession(i3);
            Intent intent = new Intent(MobileQQ.sMobileQQ, (Class<?>) VasReceiver.class);
            intent.setAction("com.gamedownload.install");
            intent.setData(apkParams.b());
            session.commit(PendingIntent.getBroadcast(MobileQQ.sMobileQQ, i3, intent, 201326592).getIntentSender());
            return true;
        } catch (Exception e16) {
            QLog.e(TAG, 1, "execInstallCommand exception", e16);
            return false;
        } finally {
            GameCenterUtil.closeIO(session);
        }
    }

    @Override // com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener
    public HashSet<String> getFilterCmds() {
        return this.filterCmds;
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameInstallService
    public boolean isInstallModelChecked(String str) {
        return p03.a.m(null).c("mmkv_key_game_check_install_model_" + str, false);
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameInstallService
    public void onReceiveCustomInstallBroadcast(Context context, Intent intent) {
        Intent intent2 = (Intent) intent.getParcelableExtra("key_broadcast_intent");
        if (intent2 == null) {
            QLog.w(TAG, 1, "onReceiveCustomInstallBroadcast intent is null");
            return;
        }
        int intExtra = intent2.getIntExtra("android.content.pm.extra.STATUS", 1);
        String stringExtra = intent2.getStringExtra("android.content.pm.extra.STATUS_MESSAGE");
        Bundle extras = intent2.getExtras();
        printBundle(extras);
        ApkParams a16 = ApkParams.a(intent2.getData());
        QLog.i(TAG, 1, "onReceiveCustomInstallBroadcast status=" + intExtra + ",statusMsg=" + stringExtra + ",apkParams=" + a16 + ",apkParams=" + a16);
        if (a16 == null) {
            return;
        }
        if (intExtra == -1) {
            if (extras != null && context != null) {
                Intent intent3 = (Intent) extras.get("android.intent.extra.INTENT");
                if (intent3 != null) {
                    sendConfirmIntent(context, a16.f106721m, a16.f106718f, intent3);
                    callback(a16.D, 1, System.currentTimeMillis());
                    return;
                } else {
                    QLog.w(TAG, 1, "onReceiveCustomInstallBroadcast sendConfirmIntent confirmIntent is null");
                    return;
                }
            }
            return;
        }
        if (intExtra == 3) {
            QLog.i(TAG, 1, "onReceiveCustomInstallBroadcast statusMsg=" + stringExtra + ",uri=" + intent2.getDataString() + ",context=" + context);
            callback(a16.D, 2, 0L);
        }
    }

    @Override // com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener
    public void onTrpcRsp(Intent intent, String str, long j3, TrpcProxy.TrpcInovkeRsp trpcInovkeRsp) {
        if (WadlProxyConsts.CMD_CHECK_INSTALL_MODEL.equals(str)) {
            onGetCheckInstallModelRsp(j3, intent, trpcInovkeRsp);
        }
    }

    protected void printBundle(Bundle bundle) {
        if (bundle != null) {
            if (QLog.isColorLevel()) {
                for (String str : bundle.keySet()) {
                    QLog.d(TAG, 4, "printBundle key=" + str + ",value=" + bundle.get(str));
                }
                return;
            }
            return;
        }
        QLog.i(TAG, 4, "printBundle extras is empty");
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameInstallService
    public void removeInstallListener(nl0.b bVar) {
        synchronized (this.listenerList) {
            if (this.listenerList.contains(bVar)) {
                this.listenerList.remove(bVar);
            }
        }
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameInstallService
    public void saveInstallModelChecked(String str) {
        p03.a.m(null).h("mmkv_key_game_check_install_model_" + str, true);
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameInstallService
    public void selectInstaller(Bundle bundle) {
        if (bundle == null) {
            QLog.d(TAG, 1, "selectInstaller, bundle null");
        } else {
            checkInstallModel(new WadlParams(bundle.getString(WadlProxyConsts.PARAM_WADL_PARAMS_JSON_STR)), bundle.getString(WadlProxyConsts.PARAM_LOCAL_APK_PATH), bundle.getLong(WadlProxyConsts.PARAM_APK_FILE_SIZE));
        }
    }
}
