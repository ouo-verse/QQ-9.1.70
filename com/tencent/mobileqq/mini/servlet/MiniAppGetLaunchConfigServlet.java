package com.tencent.mobileqq.mini.servlet;

import NS_MINI_INTERFACE.INTERFACE$MiniGameBox;
import NS_MINI_INTERFACE.INTERFACE$MiniGameBoxRedDot;
import NS_MINI_INTERFACE.INTERFACE$MiniGameFloat;
import NS_MINI_INTERFACE.INTERFACE$MiniGamePopup;
import NS_MINI_INTERFACE.INTERFACE$PopupInfo;
import NS_MINI_INTERFACE.INTERFACE$StLaunchAppRsp;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.text.TextUtils;
import android.util.Base64;
import com.qq.e.comm.pi.AppDownloadCallback;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.mini.report.MiniAppDesktopDtReportHelper;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.utils.fh;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import cooperation.qzone.report.datong.QZoneDTLoginReporter;
import java.util.List;
import mqq.app.Packet;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniAppGetLaunchConfigServlet extends MiniAppAbstractServlet {
    public static final String CMD_STRING = "LightAppSvc.mini_app_userapp.LaunchApp";
    public static final String KEY_APPID = "appId";
    public static final String KEY_LAUNCH_CONFIG_JSON_STRING = "launch_config_json_string";
    public static final String TAG = "MiniAppGetLaunchConfigServlet";

    public MiniAppGetLaunchConfigServlet() {
        this.observerId = 1099;
    }

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet
    public void onProcessData(Intent intent, Bundle bundle, byte[] bArr) throws InvalidProtocolBufferMicroException {
        List<INTERFACE$PopupInfo> list;
        try {
            QLog.i(TAG, 1, "[onProcessData]");
            INTERFACE$StLaunchAppRsp iNTERFACE$StLaunchAppRsp = new INTERFACE$StLaunchAppRsp();
            iNTERFACE$StLaunchAppRsp.mergeFrom(bArr);
            INTERFACE$MiniGameBox iNTERFACE$MiniGameBox = iNTERFACE$StLaunchAppRsp.miniGameBox.get();
            INTERFACE$MiniGameFloat iNTERFACE$MiniGameFloat = iNTERFACE$StLaunchAppRsp.miniGameFloat.get();
            INTERFACE$MiniGamePopup iNTERFACE$MiniGamePopup = iNTERFACE$StLaunchAppRsp.miniGamePopup.get();
            JSONObject jSONObject = new JSONObject();
            if (iNTERFACE$MiniGameBox != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("isDisplay", iNTERFACE$MiniGameBox.display.get());
                jSONObject2.put("iconUrl", iNTERFACE$MiniGameBox.iconURL.get());
                jSONObject2.put(WadlProxyConsts.KEY_JUMP_URL, iNTERFACE$MiniGameBox.jumpURL.get());
                jSONObject2.put("taskUrl", iNTERFACE$MiniGameBox.taskURL.get());
                jSONObject2.put("dialogTitle", iNTERFACE$MiniGameBox.pageTitle.get());
                jSONObject2.put("boxTitle", iNTERFACE$MiniGameBox.iconTitle.get());
                INTERFACE$MiniGameBoxRedDot iNTERFACE$MiniGameBoxRedDot = iNTERFACE$MiniGameBox.redDot.get();
                if (iNTERFACE$MiniGameBoxRedDot != null) {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("display", iNTERFACE$MiniGameBoxRedDot.display.get());
                    jSONObject3.put("adId", iNTERFACE$MiniGameBoxRedDot.adID.get());
                    jSONObject3.put("adPosId", iNTERFACE$MiniGameBoxRedDot.adPosID.get());
                    jSONObject3.put(MiniAppDesktopDtReportHelper.DT_MINI_TRACE_INFO, iNTERFACE$MiniGameBoxRedDot.traceInfo.get());
                    jSONObject3.put("ext", iNTERFACE$MiniGameBoxRedDot.ext.get());
                    jSONObject3.put("source", iNTERFACE$MiniGameBoxRedDot.source.get());
                    jSONObject2.put("redDot", jSONObject3);
                    QLog.d(TAG, 2, "[onProcessData] redDot info : " + jSONObject3.toString());
                } else {
                    QLog.d(TAG, 2, "[onProcessData] no redDot info");
                }
                jSONObject2.put("displayDuration", iNTERFACE$MiniGameBox.displayDuration.get());
                jSONObject.put("box", jSONObject2);
            }
            if (iNTERFACE$MiniGameFloat != null && iNTERFACE$MiniGameFloat.appInfo.get() != null) {
                MiniAppInfo from = MiniAppInfo.from(iNTERFACE$MiniGameFloat.appInfo.get());
                if (!TextUtils.isEmpty(from.appId) && !TextUtils.isEmpty(from.name) && !TextUtils.isEmpty(from.iconUrl)) {
                    JSONObject jSONObject4 = new JSONObject();
                    Parcel obtain = Parcel.obtain();
                    from.writeToParcel(obtain, 0);
                    byte[] marshall = obtain.marshall();
                    OaidMonitor.parcelRecycle(obtain);
                    jSONObject4.put("appInfo", Base64.encodeToString(marshall, 0));
                    jSONObject4.put(QZoneDTLoginReporter.SCHEMA, iNTERFACE$MiniGameFloat.schema.get());
                    jSONObject4.put("display", iNTERFACE$MiniGameFloat.display.get());
                    jSONObject4.put("via", iNTERFACE$MiniGameFloat.via.get());
                    jSONObject.put("floatGame", jSONObject4);
                }
            }
            if (iNTERFACE$MiniGamePopup != null && (list = iNTERFACE$MiniGamePopup.infos.get()) != null && !list.isEmpty()) {
                INTERFACE$PopupInfo iNTERFACE$PopupInfo = list.get(0);
                JSONObject jSONObject5 = new JSONObject();
                jSONObject5.put("appid", iNTERFACE$PopupInfo.appid.get());
                jSONObject5.put("popupType", iNTERFACE$PopupInfo.popupType.get());
                jSONObject5.put("title", iNTERFACE$PopupInfo.title.get());
                jSONObject5.put("popupContent", iNTERFACE$PopupInfo.popupContent.get());
                jSONObject5.put("enableGame", iNTERFACE$PopupInfo.enableGame.get());
                jSONObject5.put(AppDownloadCallback.BUTTON_TXT, iNTERFACE$PopupInfo.button_txt.get());
                jSONObject.put("miniPopupInfo", jSONObject5);
            }
            QLog.d(TAG, 2, "[onProcessData] data:" + jSONObject.toString());
            bundle.putString(KEY_LAUNCH_CONFIG_JSON_STRING, jSONObject.toString());
            notifyObserver(intent, 1099, true, bundle, MiniAppObserver.class);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "[onProcessData], e:" + e16);
        }
    }

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet, mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        QLog.i(TAG, 4, "onSend");
        byte[] encode = new GetLaunchConfigRequest(intent.getStringExtra("appId")).encode(intent, intent.getIntExtra(MiniAppCmdUtil.KEY_INDEX, -1), getTraceId());
        if (encode == null) {
            encode = new byte[4];
        }
        packet.setSSOCommand(CMD_STRING);
        packet.putSendData(fh.b(encode));
        packet.setTimeout(intent.getLongExtra("timeout", 30000L));
        super.onSend(intent, packet);
    }
}
