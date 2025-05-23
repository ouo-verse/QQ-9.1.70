package com.tencent.mobileqq.mini.servlet;

import NS_MINI_CLOUDSTORAGE.CloudStorage$StGetFriendCloudStorageRsp;
import NS_MINI_CLOUDSTORAGE.CloudStorage$StGetGroupCloudStorageRsp;
import NS_MINI_CLOUDSTORAGE.CloudStorage$StGetUserCloudStorageRsp;
import NS_MINI_CLOUDSTORAGE.CloudStorage$StKVData;
import NS_MINI_CLOUDSTORAGE.CloudStorage$StUserGameData;
import NS_QWEB_PROTOCAL.PROTOCAL;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.qzone.album.data.model.PhotoCategorySummaryInfo;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.utils.fh;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;
import mqq.app.Packet;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes33.dex */
public class CloudStorageServlet extends MiniAppAbstractServlet {
    public static final String GET_CLOUD_STORAGE = "get_cloud_storage";
    public static final String GET_FRIEND_CLOUD_STORAGE = "get_friend_cloud_storage";
    public static final String GET_GROUP_CLOUD_STORAGE = "get_group_cloud_storage";
    public static final String KEY_APP_ID = "app_id";
    public static final String KEY_DATA = "key_data";
    public static final String KEY_RESULT_DATA = "key_reslut_data";
    public static final String KEY_SHARETICKET = "key_shareticket";
    public static final String REMOVE_CLOUD_STORAGE = "remove_cloud_storage";
    public static final String REQUEST_TYPE = "request_type";
    public static final String SET_CLOUD_STORAGE = "set_cloud_storage";
    private static final String TAG = "[minigame] CloudStorageServlet";
    private String type;

    private void putData(Bundle bundle, PROTOCAL.StQWebRsp stQWebRsp) throws InvalidProtocolBufferMicroException, JSONException {
        List<CloudStorage$StUserGameData> list;
        if (GET_CLOUD_STORAGE.equals(this.type)) {
            CloudStorage$StGetUserCloudStorageRsp cloudStorage$StGetUserCloudStorageRsp = new CloudStorage$StGetUserCloudStorageRsp();
            cloudStorage$StGetUserCloudStorageRsp.mergeFrom(stQWebRsp.busiBuff.get().toByteArray());
            List<CloudStorage$StKVData> list2 = cloudStorage$StGetUserCloudStorageRsp.KVDataList.get();
            JSONArray jSONArray = new JSONArray();
            for (CloudStorage$StKVData cloudStorage$StKVData : list2) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("key", cloudStorage$StKVData.key.get());
                jSONObject.put("value", cloudStorage$StKVData.value.get());
                jSONArray.mo162put(jSONObject);
            }
            bundle.putString("key_reslut_data", jSONArray.toString());
            return;
        }
        if (GET_FRIEND_CLOUD_STORAGE.equals(this.type) || GET_GROUP_CLOUD_STORAGE.equals(this.type)) {
            if (GET_FRIEND_CLOUD_STORAGE.equals(this.type)) {
                CloudStorage$StGetFriendCloudStorageRsp cloudStorage$StGetFriendCloudStorageRsp = new CloudStorage$StGetFriendCloudStorageRsp();
                cloudStorage$StGetFriendCloudStorageRsp.mergeFrom(stQWebRsp.busiBuff.get().toByteArray());
                list = cloudStorage$StGetFriendCloudStorageRsp.data.get();
            } else if (GET_GROUP_CLOUD_STORAGE.equals(this.type)) {
                CloudStorage$StGetGroupCloudStorageRsp cloudStorage$StGetGroupCloudStorageRsp = new CloudStorage$StGetGroupCloudStorageRsp();
                cloudStorage$StGetGroupCloudStorageRsp.mergeFrom(stQWebRsp.busiBuff.get().toByteArray());
                list = cloudStorage$StGetGroupCloudStorageRsp.data.get();
            } else {
                list = null;
            }
            if (list == null || list.isEmpty()) {
                return;
            }
            try {
                JSONObject jSONObject2 = new JSONObject();
                JSONArray jSONArray2 = new JSONArray();
                for (CloudStorage$StUserGameData cloudStorage$StUserGameData : list) {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put(PhotoCategorySummaryInfo.AVATAR_URL, cloudStorage$StUserGameData.avatarUrl.get());
                    jSONObject3.put("nickname", cloudStorage$StUserGameData.nickname.get());
                    jSONObject3.put("openid", cloudStorage$StUserGameData.openid.get());
                    PBRepeatMessageField<CloudStorage$StKVData> pBRepeatMessageField = cloudStorage$StUserGameData.KVDataList;
                    if (pBRepeatMessageField != null && pBRepeatMessageField.size() > 0) {
                        List<CloudStorage$StKVData> list3 = cloudStorage$StUserGameData.KVDataList.get();
                        JSONArray jSONArray3 = new JSONArray();
                        for (CloudStorage$StKVData cloudStorage$StKVData2 : list3) {
                            JSONObject jSONObject4 = new JSONObject();
                            jSONObject4.put("key", cloudStorage$StKVData2.key.get());
                            jSONObject4.put("value", cloudStorage$StKVData2.value.get());
                            jSONArray3.mo162put(jSONObject4);
                        }
                        jSONObject3.put("KVDataList", jSONArray3);
                    }
                    jSONArray2.mo162put(jSONObject3);
                }
                jSONObject2.put("data", jSONArray2);
                bundle.putString("key_reslut_data", jSONObject2.toString());
            } catch (Throwable th5) {
                th5.printStackTrace();
                QLog.d(TAG, 1, "GET_FRIEND_CLOUD_STORAGE fail", th5);
            }
        }
    }

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet, mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        String stringExtra;
        int i3;
        if (intent != null) {
            try {
                stringExtra = intent.getStringExtra(REQUEST_TYPE);
            } catch (Throwable th5) {
                QLog.e(TAG, 1, "onReceive error", th5);
            }
        } else {
            stringExtra = null;
        }
        QLog.i(TAG, 1, "onReceive type:" + this.type + ", intent.type:" + stringExtra);
        if (!TextUtils.isEmpty(stringExtra) && !stringExtra.equals(this.type)) {
            this.type = stringExtra;
        }
        if (!SET_CLOUD_STORAGE.equals(this.type) && !REMOVE_CLOUD_STORAGE.equals(this.type)) {
            if (GET_CLOUD_STORAGE.equals(this.type) || GET_FRIEND_CLOUD_STORAGE.equals(this.type) || GET_GROUP_CLOUD_STORAGE.equals(this.type)) {
                if (GET_FRIEND_CLOUD_STORAGE.equals(this.type)) {
                    i3 = 1019;
                } else {
                    i3 = GET_GROUP_CLOUD_STORAGE.equals(this.type) ? 1018 : 1016;
                }
                int i16 = i3;
                Bundle bundle = new Bundle();
                PROTOCAL.StQWebRsp stQWebRsp = new PROTOCAL.StQWebRsp();
                stQWebRsp.mergeFrom(fh.a(fromServiceMsg.getWupBuffer()));
                putData(bundle, stQWebRsp);
                bundle.putInt(MiniAppCmdUtil.KEY_INDEX, (int) stQWebRsp.Seq.get());
                notifyObserver(intent, i16, fromServiceMsg.isSuccess(), bundle, MiniAppObserver.class);
            }
            doReport(intent, fromServiceMsg);
        }
        int i17 = SET_CLOUD_STORAGE.equals(this.type) ? 1015 : 1017;
        Bundle bundle2 = new Bundle();
        PROTOCAL.StQWebRsp stQWebRsp2 = new PROTOCAL.StQWebRsp();
        stQWebRsp2.mergeFrom(fh.a(fromServiceMsg.getWupBuffer()));
        bundle2.putInt(MiniAppCmdUtil.KEY_INDEX, (int) stQWebRsp2.Seq.get());
        notifyObserver(intent, i17, fromServiceMsg.isSuccess(), bundle2, MiniAppObserver.class);
        doReport(intent, fromServiceMsg);
    }

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet, mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        int intExtra = intent.getIntExtra(MiniAppCmdUtil.KEY_INDEX, -1);
        this.type = intent.getStringExtra(REQUEST_TYPE);
        ProtoBufRequest request = getRequest(intent, packet);
        if (request == null) {
            return;
        }
        byte[] encode = request.encode(intent, intExtra, getTraceId());
        if (encode == null) {
            encode = new byte[4];
        }
        packet.putSendData(fh.b(encode));
        packet.setTimeout(intent.getLongExtra("timeout", 30000L));
        super.onSend(intent, packet);
    }

    private ProtoBufRequest getRequest(Intent intent, Packet packet) {
        if (intent == null) {
            QLog.e(TAG, 1, "getRequest intent invalid!");
            return null;
        }
        String stringExtra = intent.getStringExtra("app_id");
        if (SET_CLOUD_STORAGE.equals(this.type)) {
            packet.setSSOCommand("LightAppSvc.mini_app_cloudstorage.SetUserCloudStorage");
            return new SetCloudStorageRequest((HashMap) intent.getSerializableExtra("key_data"), stringExtra);
        }
        if (GET_CLOUD_STORAGE.equals(this.type)) {
            packet.setSSOCommand("LightAppSvc.mini_app_cloudstorage.GetUserCloudStorage");
            return new GetCloudStorageRequest(intent.getStringArrayExtra("key_data"), stringExtra);
        }
        if (REMOVE_CLOUD_STORAGE.equals(this.type)) {
            packet.setSSOCommand("LightAppSvc.mini_app_cloudstorage.RemoveUserCloudStorage");
            return new RemoveCloudStorageRequest(intent.getStringArrayExtra("key_data"), stringExtra);
        }
        if (GET_GROUP_CLOUD_STORAGE.equals(this.type)) {
            packet.setSSOCommand("LightAppSvc.mini_app_cloudstorage.GetGroupCloudStorage");
            return new GetGroupCloudStorageRequest(intent.getStringArrayExtra("key_data"), intent.getStringExtra(KEY_SHARETICKET), stringExtra);
        }
        if (!GET_FRIEND_CLOUD_STORAGE.equals(this.type)) {
            return null;
        }
        packet.setSSOCommand("LightAppSvc.mini_app_cloudstorage.GetFriendCloudStorage");
        return new GetFriendCloudStorageRequest(intent.getStringArrayExtra("key_data"), stringExtra);
    }
}
