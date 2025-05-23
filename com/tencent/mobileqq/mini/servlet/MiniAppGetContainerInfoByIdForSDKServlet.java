package com.tencent.mobileqq.mini.servlet;

import NS_MINI_INTERFACE.CONTAINER_INTERFACE$GetMiniAppConfigRsp;
import NS_MINI_INTERFACE.CONTAINER_INTERFACE$SubPkgInfo;
import NS_MINI_INTERFACE.INTERFACE$StApiAppInfo;
import NS_MINI_INTERFACE.INTERFACE$StAppBasicInfo;
import NS_MINI_INTERFACE.INTERFACE$StSubPkgInfo;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.utils.fh;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.util.ArrayList;
import java.util.List;
import mqq.app.Packet;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniAppGetContainerInfoByIdForSDKServlet extends MiniAppAbstractServlet {
    public static final String KEY_APP_ID = "key_app_id";
    public static final String KEY_APP_INFO_DATA = "mini_app_info_data";
    public static final String KEY_ENV_VERSION = "key_env_version";
    public static final String KEY_FIRST_PATH = "key_first_path";
    public static final String KEY_FROM_APP_ID = "key_from_app_id";
    public static final int NO_REQUIRED = 0;
    public static final int REQUIRED = 1;
    public static final String TAG = "MiniAppGetContainerInfoByIdForSDKServlet";

    public MiniAppGetContainerInfoByIdForSDKServlet() {
        this.observerId = 1100;
    }

    private void reCombineAppInfo(INTERFACE$StApiAppInfo iNTERFACE$StApiAppInfo, CONTAINER_INTERFACE$GetMiniAppConfigRsp cONTAINER_INTERFACE$GetMiniAppConfigRsp) {
        String str = cONTAINER_INTERFACE$GetMiniAppConfigRsp.pkg_info.main_pkg_info.version.get();
        String str2 = cONTAINER_INTERFACE$GetMiniAppConfigRsp.pkg_info.main_pkg_info.version_id.get();
        String str3 = cONTAINER_INTERFACE$GetMiniAppConfigRsp.pkg_info.main_pkg_info.down_load_url.get();
        int i3 = cONTAINER_INTERFACE$GetMiniAppConfigRsp.pkg_info.main_pkg_info.version_update_time.get();
        iNTERFACE$StApiAppInfo.appJson.set(cONTAINER_INTERFACE$GetMiniAppConfigRsp.pkg_info.app_json.get());
        iNTERFACE$StApiAppInfo.version.set(str);
        iNTERFACE$StApiAppInfo.versionId.set(str2);
        iNTERFACE$StApiAppInfo.donwLoadUrl.set(str3);
        INTERFACE$StAppBasicInfo iNTERFACE$StAppBasicInfo = iNTERFACE$StApiAppInfo.basicInfo;
        if (iNTERFACE$StAppBasicInfo != null) {
            iNTERFACE$StAppBasicInfo.versionUpdateTime.set(i3);
        }
        ArrayList arrayList = new ArrayList();
        List<CONTAINER_INTERFACE$SubPkgInfo> list = cONTAINER_INTERFACE$GetMiniAppConfigRsp.pkg_info.sub_pkgs.get();
        if (list == null || list.size() <= 0) {
            return;
        }
        for (CONTAINER_INTERFACE$SubPkgInfo cONTAINER_INTERFACE$SubPkgInfo : list) {
            INTERFACE$StSubPkgInfo iNTERFACE$StSubPkgInfo = new INTERFACE$StSubPkgInfo();
            iNTERFACE$StSubPkgInfo.subPkgName.set(cONTAINER_INTERFACE$SubPkgInfo.sub_pkg_name.get());
            iNTERFACE$StSubPkgInfo.version.set(cONTAINER_INTERFACE$SubPkgInfo.version.get());
            iNTERFACE$StSubPkgInfo.versionId.set(cONTAINER_INTERFACE$SubPkgInfo.version_id.get());
            iNTERFACE$StSubPkgInfo.independent.set(cONTAINER_INTERFACE$SubPkgInfo.independent.get());
            iNTERFACE$StSubPkgInfo.mainPackVersion.set(cONTAINER_INTERFACE$SubPkgInfo.main_pack_version.get());
            iNTERFACE$StSubPkgInfo.dowLoadUrl.set(cONTAINER_INTERFACE$SubPkgInfo.down_load_url.get());
            iNTERFACE$StSubPkgInfo.file_size.set(cONTAINER_INTERFACE$SubPkgInfo.file_size.get());
            iNTERFACE$StSubPkgInfo.version_type.set(cONTAINER_INTERFACE$SubPkgInfo.version_type.get());
            iNTERFACE$StSubPkgInfo.prefetch_config.set(cONTAINER_INTERFACE$SubPkgInfo.prefetch_config.get());
            arrayList.add(iNTERFACE$StSubPkgInfo);
        }
        iNTERFACE$StApiAppInfo.subPkgs.set(arrayList);
    }

    private void savaMiniAppInfo(final Intent intent, final INTERFACE$StApiAppInfo iNTERFACE$StApiAppInfo) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.mini.servlet.MiniAppGetContainerInfoByIdForSDKServlet.1
            @Override // java.lang.Runnable
            public void run() {
                String stringExtra = intent.getStringExtra("key_first_path");
                MiniAppInfo.saveMiniAppByIdEntity(stringExtra, iNTERFACE$StApiAppInfo);
                MiniAppInfo.saveMiniAppInfoEntity(iNTERFACE$StApiAppInfo);
                MiniAppInfo.saveMiniAppShowInfoEntity(iNTERFACE$StApiAppInfo);
                MiniAppInfo.saveMiniAppInfoByIdEntity(stringExtra, iNTERFACE$StApiAppInfo);
            }
        }, 32, null, true);
    }

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet
    public void onProcessData(Intent intent, Bundle bundle, byte[] bArr) throws InvalidProtocolBufferMicroException {
        QMLog.i(TAG, "received result");
        CONTAINER_INTERFACE$GetMiniAppConfigRsp cONTAINER_INTERFACE$GetMiniAppConfigRsp = new CONTAINER_INTERFACE$GetMiniAppConfigRsp();
        cONTAINER_INTERFACE$GetMiniAppConfigRsp.mergeFrom(bArr);
        INTERFACE$StApiAppInfo iNTERFACE$StApiAppInfo = new INTERFACE$StApiAppInfo();
        iNTERFACE$StApiAppInfo.mergeFrom(cONTAINER_INTERFACE$GetMiniAppConfigRsp.ext_info.get().toByteArray());
        reCombineAppInfo(iNTERFACE$StApiAppInfo, cONTAINER_INTERFACE$GetMiniAppConfigRsp);
        com.tencent.qqmini.sdk.launcher.model.MiniAppInfo from = com.tencent.qqmini.sdk.launcher.model.MiniAppInfo.from(iNTERFACE$StApiAppInfo);
        from.setIsLoadByContainer(true);
        if (iNTERFACE$StApiAppInfo.type.get() == 3) {
            savaMiniAppInfo(intent, iNTERFACE$StApiAppInfo);
        }
        if (QMLog.isColorLevel()) {
            QMLog.i(TAG, "appjson:" + from.appJson + ",appinfo:" + from.toString());
        }
        bundle.putParcelable("mini_app_info_data", from);
        notifyObserver(intent, 1100, true, bundle, MiniAppObserver.class);
    }

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet, mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        super.onReceive(intent, fromServiceMsg);
    }

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet, mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        String stringExtra = intent.getStringExtra("key_app_id");
        String stringExtra2 = intent.getStringExtra("key_first_path");
        String stringExtra3 = intent.getStringExtra("key_env_version");
        byte[] encode = new GetContainerInfoByIdRequest(null, stringExtra, 1, 0, stringExtra2 == null ? "" : stringExtra2, stringExtra3 == null ? "" : stringExtra3, intent.getStringExtra("key_from_app_id")).encode(intent, intent.getIntExtra(MiniAppCmdUtil.KEY_INDEX, -1), getTraceId());
        if (encode == null) {
            encode = new byte[4];
        }
        packet.setSSOCommand(GetContainerInfoByIdRequest.CMD_STRING);
        packet.putSendData(fh.b(encode));
        packet.setTimeout(intent.getLongExtra("timeout", 30000L));
        super.onSend(intent, packet);
    }
}
