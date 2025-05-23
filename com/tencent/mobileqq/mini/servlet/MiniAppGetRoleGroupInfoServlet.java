package com.tencent.mobileqq.mini.servlet;

import NS_MINI_INTERFACE.INTERFACE$GetUserRoleGroupRsp;
import NS_MINI_INTERFACE.INTERFACE$RoleGroupInfo;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.utils.fh;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.app.Packet;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniAppGetRoleGroupInfoServlet extends MiniAppAbstractServlet {
    public static final String CMD_NAME = "GetUserRoleGroup";
    public static final String CMD_STRING = "LightAppSvc.mini_app_user_channel_info.GetUserRoleGroup";
    public static final String KEY_ROLEGROUPINFO = "key_role_group_info";
    public static final String REQUEST_KEY_APP_ID = "app_id";

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet
    public void onProcessData(Intent intent, Bundle bundle, byte[] bArr) throws InvalidProtocolBufferMicroException {
        INTERFACE$GetUserRoleGroupRsp iNTERFACE$GetUserRoleGroupRsp = new INTERFACE$GetUserRoleGroupRsp();
        iNTERFACE$GetUserRoleGroupRsp.mergeFrom(bArr);
        QLog.d(MiniAppAbstractServlet.TAG, 2, "onProcessData");
        new ArrayList();
        List<INTERFACE$RoleGroupInfo> list = iNTERFACE$GetUserRoleGroupRsp.roles.get();
        JSONObject jSONObject = new JSONObject();
        if (list != null) {
            JSONArray jSONArray = new JSONArray();
            for (INTERFACE$RoleGroupInfo iNTERFACE$RoleGroupInfo : list) {
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("roleName", String.valueOf(iNTERFACE$RoleGroupInfo.role_name.get()));
                    jSONObject2.put("roleID", String.valueOf(iNTERFACE$RoleGroupInfo.role_id.get()));
                    jSONObject2.put("color", iNTERFACE$RoleGroupInfo.role_color.get());
                    jSONArray.mo162put(jSONObject2);
                    jSONObject.put("roleList", jSONArray);
                } catch (JSONException e16) {
                    e16.printStackTrace();
                }
            }
        }
        bundle.putString(KEY_ROLEGROUPINFO, jSONObject.toString());
        notifyObserver(intent, this.observerId, true, bundle, MiniAppObserver.class);
    }

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet, mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        QLog.i(MiniAppAbstractServlet.TAG, 4, "onSend");
        byte[] encode = new RoleGroupInfoRequest(intent.getStringExtra("app_id")).encode(intent, intent.getIntExtra(MiniAppCmdUtil.KEY_INDEX, -1), getTraceId());
        if (encode == null) {
            encode = new byte[4];
        }
        packet.setSSOCommand(CMD_STRING);
        packet.putSendData(fh.b(encode));
        packet.setTimeout(intent.getLongExtra("timeout", 30000L));
        super.onSend(intent, packet);
    }
}
