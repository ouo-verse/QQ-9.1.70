package com.tencent.mobileqq.mini.servlet;

import NS_MINI_INTERFACE.INTERFACE$StApiUserInfo;
import NS_MINI_INTERFACE.INTERFACE$StBatchGetUserInfoRsp;
import NS_QWEB_PROTOCAL.PROTOCAL;
import android.content.Intent;
import android.os.Bundle;
import com.qzone.album.data.model.PhotoCategorySummaryInfo;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.utils.fh;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.Packet;
import org.json.JSONArray;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: P */
/* loaded from: classes33.dex */
public class BatchGetUserInfoServlet extends MiniAppAbstractServlet {
    public static final String KEY_OPENIDS = "key_openid";
    public static final String KEY_RESULT_DATA = "key_reslut_data";
    public static final String TAG = "[minigame] BatchGetUserInfoServlet";

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet, mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        Bundle bundle = new Bundle();
        try {
            bundle.putInt(MiniAppCmdUtil.KEY_INDEX, intent.getIntExtra(MiniAppCmdUtil.KEY_INDEX, -1));
            if (fromServiceMsg != null) {
                if (fromServiceMsg.isSuccess()) {
                    PROTOCAL.StQWebRsp stQWebRsp = new PROTOCAL.StQWebRsp();
                    stQWebRsp.mergeFrom(fh.a(fromServiceMsg.getWupBuffer()));
                    bundle.putInt(MiniAppCmdUtil.KEY_INDEX, (int) stQWebRsp.Seq.get());
                    if (stQWebRsp.retCode.get() == 0) {
                        INTERFACE$StBatchGetUserInfoRsp iNTERFACE$StBatchGetUserInfoRsp = new INTERFACE$StBatchGetUserInfoRsp();
                        iNTERFACE$StBatchGetUserInfoRsp.mergeFrom(stQWebRsp.busiBuff.get().toByteArray());
                        PBRepeatMessageField<INTERFACE$StApiUserInfo> pBRepeatMessageField = iNTERFACE$StBatchGetUserInfoRsp.user;
                        if (pBRepeatMessageField != null) {
                            List<INTERFACE$StApiUserInfo> list = pBRepeatMessageField.get();
                            JSONArray jSONArray = new JSONArray();
                            for (INTERFACE$StApiUserInfo iNTERFACE$StApiUserInfo : list) {
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("nickName", iNTERFACE$StApiUserInfo.nick.get());
                                jSONObject.put(PhotoCategorySummaryInfo.AVATAR_URL, iNTERFACE$StApiUserInfo.avatar.get());
                                jSONObject.put("gender", iNTERFACE$StApiUserInfo.gender.get());
                                jSONObject.put(IjkMediaMeta.IJKM_KEY_LANGUAGE, iNTERFACE$StApiUserInfo.language.get());
                                jSONObject.put("country", iNTERFACE$StApiUserInfo.address.country.get());
                                jSONObject.put("province", iNTERFACE$StApiUserInfo.address.province.get());
                                jSONObject.put("city", iNTERFACE$StApiUserInfo.address.city.get());
                                jSONObject.put("openId", iNTERFACE$StApiUserInfo.openid.get());
                                jSONArray.mo162put(jSONObject);
                            }
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("data", jSONArray);
                            bundle.putString("key_reslut_data", jSONObject2.toString());
                            notifyObserver(intent, 1028, true, bundle, MiniAppObserver.class);
                        } else {
                            QLog.e(TAG, 2, "inform BatchGetUserInfoServlet result.user == null");
                            notifyObserver(intent, 1028, false, bundle, MiniAppObserver.class);
                        }
                    } else {
                        QLog.e(TAG, 2, "inform BatchGetUserInfoServlet rsp.retCode = " + stQWebRsp.retCode.get());
                        notifyObserver(intent, 1028, false, bundle, MiniAppObserver.class);
                    }
                } else {
                    bundle.putLong("ret_code", fromServiceMsg.getBusinessFailCode());
                    bundle.putString("err_msg", fromServiceMsg.getBusinessFailMsg());
                    QLog.e(TAG, 2, "inform BatchGetUserInfoServlet isSuccess false");
                    notifyObserver(intent, 1028, false, bundle, MiniAppObserver.class);
                }
            } else {
                QLog.e(TAG, 2, "inform BatchGetUserInfoServlet resultcode fail.");
                notifyObserver(intent, 1028, false, bundle, MiniAppObserver.class);
            }
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "BatchGetUserInfoServlet exception:" + th5 + "onReceive error");
            notifyObserver(null, 1028, false, bundle, MiniAppObserver.class);
        }
        doReport(intent, fromServiceMsg);
    }

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet, mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        byte[] encode = new BatchGetUserInfoRequest(intent.getStringExtra("key_appid"), intent.getStringExtra(MiniAppAbstractServlet.KEY_LANG), intent.getStringArrayExtra("key_openid")).encode(intent, intent.getIntExtra(MiniAppCmdUtil.KEY_INDEX, -1), getTraceId());
        if (encode == null) {
            encode = new byte[4];
        }
        packet.setSSOCommand(BatchGetUserInfoRequest.CMD_STRING);
        packet.putSendData(fh.b(encode));
        packet.setTimeout(intent.getLongExtra("timeout", 30000L));
        super.onSend(intent, packet);
    }
}
