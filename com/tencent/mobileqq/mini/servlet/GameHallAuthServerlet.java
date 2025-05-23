package com.tencent.mobileqq.mini.servlet;

import NS_MINI_INTERFACE.GAME_HALL_AUTH$GetGameDataAuthReq;
import NS_MINI_INTERFACE.GAME_HALL_AUTH$GetGameDataAuthRsp;
import NS_MINI_INTERFACE.GAME_HALL_AUTH$SetGameDataAuthReq;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.utils.fh;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MSFServlet;
import mqq.app.NewIntent;
import mqq.app.Packet;
import mqq.observer.BusinessObserver;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* compiled from: P */
/* loaded from: classes33.dex */
public class GameHallAuthServerlet extends MSFServlet {
    public static final String AUTH_STATUS = "auth_status";
    public static final String CMD = "cmd";
    public static final String CMD_STR = "cmd_str";
    public static final String DATA = "data";
    public static final String ERROR_CODE = "error_code";
    public static final String ERROR_MSG = "error_msg";
    public static final int GET_AUTH = 4556;
    public static final String GET_AUTH_STR = "OidbSvcTrpcTcp.0x11cc_1";
    public static final int SERVICE_TYPE = 1;
    public static final int SET_AUTH = 4555;
    public static final String SET_AUTH_STR = "OidbSvcTrpcTcp.0x11cb_1";
    public static final int UNKNOWN_ERROR = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static class AuthBusinessCallBack implements BusinessObserver {
        private GetAuthCallBack callBack;

        public AuthBusinessCallBack(GetAuthCallBack getAuthCallBack) {
            this.callBack = getAuthCallBack;
        }

        @Override // mqq.observer.BusinessObserver
        public void onReceive(int i3, boolean z16, Bundle bundle) {
            if (this.callBack != null) {
                if (z16 && bundle.containsKey(GameHallAuthServerlet.AUTH_STATUS)) {
                    this.callBack.onResponse(bundle.getInt(GameHallAuthServerlet.AUTH_STATUS));
                } else {
                    this.callBack.onError(bundle.getInt("error_code"), bundle.getString("error_msg", ""));
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public interface GetAuthCallBack {
        void onError(int i3, String str);

        void onResponse(int i3);
    }

    public static void getAuth(GetAuthCallBack getAuthCallBack) {
        send(new MessageMicro<GAME_HALL_AUTH$GetGameDataAuthReq>() { // from class: NS_MINI_INTERFACE.GAME_HALL_AUTH$GetGameDataAuthReq
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], GAME_HALL_AUTH$GetGameDataAuthReq.class);
        }.toByteArray(), GET_AUTH, GET_AUTH_STR, getAuthCallBack);
    }

    private static void send(byte[] bArr, int i3, String str, GetAuthCallBack getAuthCallBack) {
        NewIntent newIntent = new NewIntent(BaseApplicationImpl.getApplication(), GameHallAuthServerlet.class);
        newIntent.putExtra("cmd", i3);
        newIntent.putExtra(CMD_STR, str);
        newIntent.setObserver(new AuthBusinessCallBack(getAuthCallBack));
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        oidb_sso_oidbssopkg.uint32_command.set(i3);
        if (bArr != null) {
            oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(bArr));
        }
        oidb_sso_oidbssopkg.str_client_version.set(AppSetting.n());
        oidb_sso_oidbssopkg.uint32_service_type.set(1);
        newIntent.putExtra("data", oidb_sso_oidbssopkg.toByteArray());
        BaseApplicationImpl.getApplication().getRuntime().startServlet(newIntent);
    }

    public static void setAuth(int i3) {
        GAME_HALL_AUTH$SetGameDataAuthReq gAME_HALL_AUTH$SetGameDataAuthReq = new GAME_HALL_AUTH$SetGameDataAuthReq();
        gAME_HALL_AUTH$SetGameDataAuthReq.auth_status.set(i3);
        send(gAME_HALL_AUTH$SetGameDataAuthReq.toByteArray(), SET_AUTH, SET_AUTH_STR, null);
    }

    @Override // mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        if (intent.getIntExtra("cmd", SET_AUTH) == 4556) {
            try {
                oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
                oidb_sso_oidbssopkg.mergeFrom(fh.a(fromServiceMsg.getWupBuffer()));
                Bundle bundle = new Bundle();
                int i3 = oidb_sso_oidbssopkg.uint32_result.get();
                if (i3 != 0) {
                    QLog.d(MSFServlet.TAG, 1, "oidb head error code : ", Integer.valueOf(i3));
                    bundle.putString("error_msg", oidb_sso_oidbssopkg.str_error_msg.get());
                    bundle.putInt("error_code", i3);
                    notifyObserver(intent, 1, fromServiceMsg.isSuccess(), bundle, AuthBusinessCallBack.class);
                    return;
                }
                byte[] byteArray = oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray();
                GAME_HALL_AUTH$GetGameDataAuthRsp gAME_HALL_AUTH$GetGameDataAuthRsp = new GAME_HALL_AUTH$GetGameDataAuthRsp();
                gAME_HALL_AUTH$GetGameDataAuthRsp.mergeFrom(byteArray);
                bundle.putInt(AUTH_STATUS, gAME_HALL_AUTH$GetGameDataAuthRsp.auth_status.get());
                notifyObserver(intent, 1, fromServiceMsg.isSuccess(), bundle, AuthBusinessCallBack.class);
            } catch (Exception e16) {
                Bundle bundle2 = new Bundle();
                bundle2.putInt("error_code", -1);
                bundle2.putString("error_msg", e16.getMessage());
                notifyObserver(intent, 1, fromServiceMsg.isSuccess(), bundle2, AuthBusinessCallBack.class);
            }
        }
    }

    @Override // mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        QLog.i(MSFServlet.TAG, 4, "onsend");
        packet.setSSOCommand(intent.getStringExtra(CMD_STR));
        packet.putSendData(fh.b(intent.getByteArrayExtra("data")));
        packet.setTimeout(30000L);
    }
}
