package com.tencent.gamecenter.wadl.api.impl;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.gamecenter.wadl.api.IQQGameTrpcSsoService;
import com.tencent.gamecenter.wadl.biz.entity.WadlParams;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.ah;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import nl0.h;
import tencent.im.qqgame.QQGameCheckDownload$CheckURLRequest;
import tencent.im.qqgame.QQGameCheckDownload$CheckURLResponse;
import tencent.im.qqgame.QQGameCheckDownload$InstallTipReq;
import tencent.im.qqgame.QQGameCheckDownload$InstallTipRsp;
import tencent.im.qqgame.QQGameCheckDownload$SsoCheckCustomAPKReq;
import tencent.im.qqgame.QQGameCheckDownload$SsoCheckCustomAPKRsp;
import tencent.im.qqgame.QQGameCheckDownload$SsoCheckEnvReq;
import tencent.im.qqgame.QQGameConfig$GetDownloadConfigRequest;
import tencent.im.qqgame.QQGameConfig$GetDownloadConfigResponse;
import tencent.im.qqgame.QQGameFullScreenRemind$SsoShowRequest;
import tencent.im.qqgame.QQGameFullScreenRemind$SsoShowResponse;
import tencent.im.qqgame.QQGameIntercept$CheckReq;
import tencent.im.qqgame.QQGameIntercept$CheckRsp;
import tencent.im.qqgame.QQGameIntercept$GetLgameFileRequest;
import tencent.im.qqgame.QQGameIntercept$GetLgameFileResponse;
import tencent.im.qqgame.QQGameIntercept$GetLgameInfoRequest;
import tencent.im.qqgame.QQGameIntercept$GetLgameInfoResponse;
import tencent.im.qqgame.QQGameOrder$SetOrderGameRequest;
import tencent.im.qqgame.QQGameRegister$GetGameRegisteredRequest;
import tencent.im.qqgame.QQGameRegister$GetGameRegisteredResponse;

/* compiled from: P */
/* loaded from: classes6.dex */
public class QQGameTrpcSsoServiceImpl implements IQQGameTrpcSsoService {
    private static final String TAG = "Wadl_QQGameTrpcSsoServiceImpl";
    private CopyOnWriteArrayList<WeakReference<h>> ssoListeners = new CopyOnWriteArrayList<>();

    @Override // com.tencent.gamecenter.wadl.api.IQQGameTrpcSsoService
    public void addListener(h hVar) {
        QLog.d(TAG, 1, "addListener listener=" + hVar);
        if (hVar == null) {
            return;
        }
        Iterator<WeakReference<h>> it = this.ssoListeners.iterator();
        while (it.hasNext()) {
            h hVar2 = it.next().get();
            if (hVar2 != null && hVar2 == hVar) {
                return;
            }
        }
        QLog.d(TAG, 1, "addListener listener=" + hVar + " succ");
        this.ssoListeners.add(new WeakReference<>(hVar));
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameTrpcSsoService
    public void checkDownloadByIntercept(WadlParams wadlParams, String str, Bundle bundle) {
        QLog.d(TAG, 1, "checkDownloadByIntercept wadlParams=" + wadlParams + ",md5=" + str);
        QQGameIntercept$CheckReq qQGameIntercept$CheckReq = new QQGameIntercept$CheckReq();
        String str2 = wadlParams.apkUrl;
        if (str2 != null) {
            qQGameIntercept$CheckReq.download_url.set(str2);
        }
        String str3 = wadlParams.packageName;
        if (str3 != null) {
            qQGameIntercept$CheckReq.package_name.set(str3);
        }
        qQGameIntercept$CheckReq.version_code.set(String.valueOf(wadlParams.versionCode));
        if (str != null) {
            qQGameIntercept$CheckReq.md5.set(str);
        }
        requestTrpc(WadlProxyConsts.CMD_TRPC_CHECK_DOWNLOAD_JOINT, qQGameIntercept$CheckReq.toByteArray(), bundle);
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameTrpcSsoService
    public void checkGameDownload(WadlParams wadlParams, Bundle bundle) {
        QLog.d(TAG, 1, "checkGameDownload wadlParams=" + wadlParams);
        QQGameCheckDownload$CheckURLRequest qQGameCheckDownload$CheckURLRequest = new QQGameCheckDownload$CheckURLRequest();
        String str = wadlParams.adtag;
        if (str != null) {
            qQGameCheckDownload$CheckURLRequest.ad_tag.set(str);
        }
        String str2 = wadlParams.appId;
        if (str2 != null) {
            qQGameCheckDownload$CheckURLRequest.appid.set(str2);
        }
        String str3 = wadlParams.apkChannel;
        if (str3 != null) {
            qQGameCheckDownload$CheckURLRequest.channel_id.set(str3);
        }
        String str4 = wadlParams.apkUrl;
        if (str4 != null) {
            qQGameCheckDownload$CheckURLRequest.download_url.set(str4);
        }
        String str5 = wadlParams.extraData;
        if (str5 != null) {
            qQGameCheckDownload$CheckURLRequest.refer.set(str5);
        }
        String str6 = wadlParams.fromWebUrl;
        if (str6 != null) {
            qQGameCheckDownload$CheckURLRequest.source_url.set(str6);
        }
        qQGameCheckDownload$CheckURLRequest.mie_act_id.set(wadlParams.mieActId);
        qQGameCheckDownload$CheckURLRequest.client_version.set(AppSetting.f99551k);
        qQGameCheckDownload$CheckURLRequest.version_code.set(String.valueOf(wadlParams.versionCode));
        requestTrpc(WadlProxyConsts.CMD_TRPC_CHECK_DOWNLOAD, qQGameCheckDownload$CheckURLRequest.toByteArray(), bundle);
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameTrpcSsoService
    public void checkIndependentDownload(WadlParams wadlParams, Bundle bundle) {
        QLog.d(TAG, 1, "checkIndependentDownload wadlParams=" + wadlParams);
        QQGameCheckDownload$SsoCheckCustomAPKReq qQGameCheckDownload$SsoCheckCustomAPKReq = new QQGameCheckDownload$SsoCheckCustomAPKReq();
        String str = wadlParams.appId;
        if (str != null) {
            qQGameCheckDownload$SsoCheckCustomAPKReq.appid.set(str);
        }
        String str2 = wadlParams.apkChannel;
        if (str2 != null) {
            qQGameCheckDownload$SsoCheckCustomAPKReq.channel_id.set(str2);
        }
        String str3 = wadlParams.apkUrl;
        if (str3 != null) {
            qQGameCheckDownload$SsoCheckCustomAPKReq.download_url.set(str3);
        }
        requestTrpc(WadlProxyConsts.CMD_TRPC_CHECK_INDEPENDENT_DOWNLOAD, qQGameCheckDownload$SsoCheckCustomAPKReq.toByteArray(), bundle);
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameTrpcSsoService
    public void checkPreload(WadlParams wadlParams, Bundle bundle) {
        if (wadlParams != null && !TextUtils.isEmpty(wadlParams.appId)) {
            QQGameCheckDownload$SsoCheckEnvReq qQGameCheckDownload$SsoCheckEnvReq = new QQGameCheckDownload$SsoCheckEnvReq();
            qQGameCheckDownload$SsoCheckEnvReq.app_id.set(wadlParams.appId);
            qQGameCheckDownload$SsoCheckEnvReq.version_code.set(wadlParams.versionCode);
            String str = AppSetting.f99551k;
            String s16 = ah.s();
            String t16 = ah.t();
            long[] U = ah.U();
            QLog.d(TAG, 1, "checkPreload appId=" + wadlParams.appId + ",versionCode=" + wadlParams.versionCode + ",qqVersion=" + str + ",deviceModel=" + s16 + ",osVersion=" + t16 + ",disk_remaining_space=" + (U[1] * 1000));
            if (!TextUtils.isEmpty(str)) {
                qQGameCheckDownload$SsoCheckEnvReq.qq_version.set(str);
            }
            if (!TextUtils.isEmpty(s16)) {
                qQGameCheckDownload$SsoCheckEnvReq.device_model.set(s16);
            }
            if (!TextUtils.isEmpty(t16)) {
                qQGameCheckDownload$SsoCheckEnvReq.android_version.set(t16);
            }
            qQGameCheckDownload$SsoCheckEnvReq.disk_remaining_space.set(U[1] * 1000);
            requestTrpc(WadlProxyConsts.CMD_TRPC_CHECK_PRE_DOWNLOAD, qQGameCheckDownload$SsoCheckEnvReq.toByteArray(), bundle);
            return;
        }
        QLog.e(TAG, 1, "checkPreload params invalid,wadlParams=" + wadlParams);
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameTrpcSsoService
    public void getGameRegister(String str) {
        QLog.d(TAG, 1, "getGameRegister appid=" + str);
        QQGameRegister$GetGameRegisteredRequest qQGameRegister$GetGameRegisteredRequest = new QQGameRegister$GetGameRegisteredRequest();
        qQGameRegister$GetGameRegisteredRequest.plat.set(1);
        qQGameRegister$GetGameRegisteredRequest.appid.set(str);
        requestTrpc(WadlProxyConsts.CMD_TRPC_GET_GAME_REGISTER, qQGameRegister$GetGameRegisteredRequest.toByteArray(), null);
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameTrpcSsoService
    public void getInterruptGameInfoByUrl(String str) {
        QLog.d(TAG, 1, "getInterruptGameInfoByUrl url=" + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        QQGameIntercept$GetLgameInfoRequest qQGameIntercept$GetLgameInfoRequest = new QQGameIntercept$GetLgameInfoRequest();
        qQGameIntercept$GetLgameInfoRequest.url.set(str);
        Bundle bundle = new Bundle();
        bundle.putString(WadlProxyConsts.KEY_JUMP_URL, str);
        requestTrpc(WadlProxyConsts.CMD_TRPC_INTERRUPT_GAME_INFO, qQGameIntercept$GetLgameInfoRequest.toByteArray(), bundle);
    }

    protected void notifyListeners(String str, boolean z16, int i3, int i16, Intent intent, Object obj) {
        Iterator<WeakReference<h>> it = this.ssoListeners.iterator();
        while (it.hasNext()) {
            WeakReference<h> next = it.next();
            h hVar = next.get();
            if (hVar != null) {
                HashSet<String> filterCmds = hVar.getFilterCmds();
                if (filterCmds == null || filterCmds.contains(str)) {
                    if (QLog.isDevelopLevel()) {
                        QLog.d(TAG, 4, "notifyListeners cmd=" + str + ",isSucc=" + z16 + ",listener=" + hVar);
                    }
                    hVar.onTrpcRsp(str, z16, i3, i16, intent, obj);
                }
            } else {
                this.ssoListeners.remove(next);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v25, types: [tencent.im.qqgame.QQGameCheckDownload$InstallTipRsp, com.tencent.mobileqq.pb.MessageMicro] */
    /* JADX WARN: Type inference failed for: r1v26, types: [com.tencent.mobileqq.pb.MessageMicro, tencent.im.qqgame.QQGameFullScreenRemind$SsoShowResponse] */
    /* JADX WARN: Type inference failed for: r1v27, types: [tencent.im.qqgame.QQGameIntercept$GetLgameInfoResponse, com.tencent.mobileqq.pb.MessageMicro] */
    /* JADX WARN: Type inference failed for: r1v28, types: [tencent.im.qqgame.QQGameIntercept$GetLgameFileResponse, com.tencent.mobileqq.pb.MessageMicro] */
    /* JADX WARN: Type inference failed for: r1v29, types: [com.tencent.mobileqq.pb.MessageMicro, tencent.im.qqgame.QQGameIntercept$CheckRsp] */
    /* JADX WARN: Type inference failed for: r1v30, types: [com.tencent.mobileqq.pb.MessageMicro, tencent.im.qqgame.QQGameRegister$GetGameRegisteredResponse] */
    /* JADX WARN: Type inference failed for: r1v31, types: [com.tencent.mobileqq.pb.MessageMicro, tencent.im.qqgame.QQGameConfig$GetDownloadConfigResponse] */
    /* JADX WARN: Type inference failed for: r1v32, types: [com.tencent.mobileqq.pb.MessageMicro, tencent.im.qqgame.QQGameCheckDownload$SsoCheckCustomAPKRsp] */
    /* JADX WARN: Type inference failed for: r1v34, types: [com.tencent.mobileqq.pb.MessageMicro, tencent.im.qqgame.QQGameCheckDownload$CheckURLResponse] */
    @Override // com.tencent.gamecenter.wadl.api.IQQGameTrpcSsoService
    public void onRespTrpcSso(Intent intent, boolean z16, int i3, int i16, byte[] bArr) {
        boolean z17;
        byte[] bArr2;
        if (intent == null) {
            return;
        }
        String stringExtra = intent.getStringExtra(WadlProxyConsts.EXTRA_CMD);
        if (z16 && i3 == 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        boolean z18 = z17;
        if (z18 && bArr != null) {
            try {
                if (WadlProxyConsts.CMD_TRPC_CHECK_DOWNLOAD.equals(stringExtra)) {
                    ?? qQGameCheckDownload$CheckURLResponse = new QQGameCheckDownload$CheckURLResponse();
                    qQGameCheckDownload$CheckURLResponse.mergeFrom(bArr);
                    bArr2 = qQGameCheckDownload$CheckURLResponse;
                } else if (WadlProxyConsts.CMD_TRPC_CHECK_INDEPENDENT_DOWNLOAD.equals(stringExtra)) {
                    ?? qQGameCheckDownload$SsoCheckCustomAPKRsp = new QQGameCheckDownload$SsoCheckCustomAPKRsp();
                    qQGameCheckDownload$SsoCheckCustomAPKRsp.mergeFrom(bArr);
                    bArr2 = qQGameCheckDownload$SsoCheckCustomAPKRsp;
                } else if (WadlProxyConsts.CMD_TRPC_GET_DOWNLOAD_CONFIG.equals(stringExtra)) {
                    ?? qQGameConfig$GetDownloadConfigResponse = new QQGameConfig$GetDownloadConfigResponse();
                    qQGameConfig$GetDownloadConfigResponse.mergeFrom(bArr);
                    bArr2 = qQGameConfig$GetDownloadConfigResponse;
                } else if (WadlProxyConsts.CMD_TRPC_GET_GAME_REGISTER.equals(stringExtra)) {
                    ?? r16 = new MessageMicro<QQGameRegister$GetGameRegisteredResponse>() { // from class: tencent.im.qqgame.QQGameRegister$GetGameRegisteredResponse
                        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"registered", "appid"}, new Object[]{Boolean.FALSE, ""}, QQGameRegister$GetGameRegisteredResponse.class);
                        public final PBBoolField registered = PBField.initBool(false);
                        public final PBStringField appid = PBField.initString("");
                    };
                    r16.mergeFrom(bArr);
                    bArr2 = r16;
                } else if (WadlProxyConsts.CMD_TRPC_CHECK_DOWNLOAD_JOINT.equals(stringExtra)) {
                    ?? qQGameIntercept$CheckRsp = new QQGameIntercept$CheckRsp();
                    qQGameIntercept$CheckRsp.mergeFrom(bArr);
                    bArr2 = qQGameIntercept$CheckRsp;
                } else if (WadlProxyConsts.CMD_TRPC_INTERRUPT_REGEX_FILE.equals(stringExtra)) {
                    ?? qQGameIntercept$GetLgameFileResponse = new QQGameIntercept$GetLgameFileResponse();
                    qQGameIntercept$GetLgameFileResponse.mergeFrom(bArr);
                    bArr2 = qQGameIntercept$GetLgameFileResponse;
                } else if (WadlProxyConsts.CMD_TRPC_INTERRUPT_GAME_INFO.equals(stringExtra)) {
                    ?? qQGameIntercept$GetLgameInfoResponse = new QQGameIntercept$GetLgameInfoResponse();
                    qQGameIntercept$GetLgameInfoResponse.mergeFrom(bArr);
                    bArr2 = qQGameIntercept$GetLgameInfoResponse;
                } else if (WadlProxyConsts.CMD_TRPC_GET_REMIND_FULLSCREEN.equals(stringExtra)) {
                    ?? qQGameFullScreenRemind$SsoShowResponse = new QQGameFullScreenRemind$SsoShowResponse();
                    qQGameFullScreenRemind$SsoShowResponse.mergeFrom(bArr);
                    bArr2 = qQGameFullScreenRemind$SsoShowResponse;
                } else if (WadlProxyConsts.CMD_TRPC_CHECK_DOWNLOAD_SSOINSTALLTIP.equals(stringExtra)) {
                    ?? qQGameCheckDownload$InstallTipRsp = new QQGameCheckDownload$InstallTipRsp();
                    qQGameCheckDownload$InstallTipRsp.mergeFrom(bArr);
                    bArr2 = qQGameCheckDownload$InstallTipRsp;
                }
                bArr = bArr2;
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.e(TAG, 2, "onRespTrpcSso mergeFrom exception", e16);
            }
        }
        byte[] bArr3 = bArr;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onRespTrpcSso cmd=" + stringExtra + ",isSucc=" + z18 + ",trpcRspRetCode=" + i3 + ",trpcRspFuncRetCode=" + i16 + ",rspObj=" + bArr3);
        }
        notifyListeners(stringExtra, z18, i3, i16, intent, bArr3);
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameTrpcSsoService
    public void removeListener(h hVar) {
        QLog.d(TAG, 1, "removeListener listener=" + hVar);
        if (hVar == null) {
            return;
        }
        Iterator<WeakReference<h>> it = this.ssoListeners.iterator();
        while (it.hasNext()) {
            WeakReference<h> next = it.next();
            h hVar2 = next.get();
            if (hVar2 != null && hVar2 == hVar) {
                QLog.d(TAG, 1, "removeListener listener=" + hVar + " " + this.ssoListeners.remove(next));
                return;
            }
        }
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameTrpcSsoService
    public void reqRemindFullScreenInfo(String str) {
        if (StringUtil.isEmpty(str)) {
            QLog.e(TAG, 1, "reqRemindFullScreenInfo---material is null");
            return;
        }
        QQGameFullScreenRemind$SsoShowRequest qQGameFullScreenRemind$SsoShowRequest = new QQGameFullScreenRemind$SsoShowRequest();
        qQGameFullScreenRemind$SsoShowRequest.material.set(str);
        requestTrpc(WadlProxyConsts.CMD_TRPC_GET_REMIND_FULLSCREEN, qQGameFullScreenRemind$SsoShowRequest.toByteArray(), null);
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameTrpcSsoService
    public void reqSsoInstallTip(String str, Bundle bundle) {
        if (StringUtil.isEmpty(str)) {
            QLog.e(TAG, 1, "reqSsoInstallTip---appId is empty");
            return;
        }
        QQGameCheckDownload$InstallTipReq qQGameCheckDownload$InstallTipReq = new QQGameCheckDownload$InstallTipReq();
        qQGameCheckDownload$InstallTipReq.app_id.set(str);
        requestTrpc(WadlProxyConsts.CMD_TRPC_CHECK_DOWNLOAD_SSOINSTALLTIP, qQGameCheckDownload$InstallTipReq.toByteArray(), bundle);
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameTrpcSsoService
    public void requestDownloadConfig(long j3) {
        QLog.d(TAG, 1, "requestDownloadConfig localVersion=" + j3);
        QQGameConfig$GetDownloadConfigRequest qQGameConfig$GetDownloadConfigRequest = new QQGameConfig$GetDownloadConfigRequest();
        qQGameConfig$GetDownloadConfigRequest.version.set(j3);
        requestTrpc(WadlProxyConsts.CMD_TRPC_GET_DOWNLOAD_CONFIG, qQGameConfig$GetDownloadConfigRequest.toByteArray(), null);
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameTrpcSsoService
    public void requestJointRegexConfig(int i3) {
        QLog.d(TAG, 1, "requestJointRegexConfig versionCode=" + i3);
        QQGameIntercept$GetLgameFileRequest qQGameIntercept$GetLgameFileRequest = new QQGameIntercept$GetLgameFileRequest();
        qQGameIntercept$GetLgameFileRequest.version.set(i3);
        requestTrpc(WadlProxyConsts.CMD_TRPC_INTERRUPT_REGEX_FILE, qQGameIntercept$GetLgameFileRequest.toByteArray(), null);
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameTrpcSsoService
    public void requestTrpc(String str, byte[] bArr, Bundle bundle) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        QLog.d(TAG, 1, "requestTrpc cmd=" + str + ",extra=" + bundle + ",appRuntime=" + peekAppRuntime);
        if (peekAppRuntime != null && !TextUtils.isEmpty(str) && bArr != null) {
            try {
                NewIntent newIntent = new NewIntent(MobileQQ.sMobileQQ, com.tencent.gamecenter.wadl.biz.b.class);
                if (bundle == null) {
                    bundle = new Bundle();
                }
                bundle.putInt(WadlProxyConsts.KEY_SSO_TYPE, 2);
                bundle.putString(WadlProxyConsts.EXTRA_CMD, str);
                bundle.putByteArray(WadlProxyConsts.PARAM_WEBSSO_REQ, bArr);
                newIntent.putExtras(bundle);
                peekAppRuntime.startServlet(newIntent);
            } catch (Exception e16) {
                QLog.e(TAG, 1, "requestTrpc exception=", e16);
            }
        }
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameTrpcSsoService
    public void setOrderGame(int i3, Bundle bundle, String... strArr) {
        QLog.d(TAG, 1, "setOrderGame appids=" + strArr);
        QQGameOrder$SetOrderGameRequest qQGameOrder$SetOrderGameRequest = new QQGameOrder$SetOrderGameRequest();
        qQGameOrder$SetOrderGameRequest.operation.set(i3);
        qQGameOrder$SetOrderGameRequest.channel_id.set(WadlProxyConsts.APP_CHANNEL_GAMECENTER);
        for (String str : strArr) {
            qQGameOrder$SetOrderGameRequest.app_ids.add(str);
        }
        requestTrpc(WadlProxyConsts.CMD_TRPC_SET_ORDER_GAME, qQGameOrder$SetOrderGameRequest.toByteArray(), bundle);
    }
}
