package com.tencent.mobileqq.apollo.model;

import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes33.dex */
public class Apollo3DMessage implements Serializable {
    public static final String RESERVE_JSON_KEY_ACTIONID_3D = "actionID_3D";
    public static final String RESERVE_JSON_KEY_ACTION_NAME_3D = "actionName_3D";
    public static final String RESERVE_JSON_KEY_ACTION_TYPE_3D = "actionType_3D";
    public static final String RESERVE_JSON_KEY_PEER_STATUS_3D = "peerStatus_3D";
    public static final String RESERVE_JSON_KEY_SENDER_STATUS_3D = "senderStatus_3D";
    private static final long serialVersionUID = 201812110422150001L;
    public int actionID3D;
    public String actionName3D;
    public int actionType3D;
    public int peerStatus3D;
    public int senderStatus3D;

    public JSONObject getMessageJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(RESERVE_JSON_KEY_ACTIONID_3D, this.actionID3D);
            jSONObject.put(RESERVE_JSON_KEY_ACTION_TYPE_3D, this.actionType3D);
            jSONObject.put(RESERVE_JSON_KEY_ACTION_NAME_3D, this.actionName3D);
            jSONObject.put(RESERVE_JSON_KEY_SENDER_STATUS_3D, this.senderStatus3D);
            jSONObject.put(RESERVE_JSON_KEY_PEER_STATUS_3D, this.peerStatus3D);
            return jSONObject;
        } catch (Throwable th5) {
            QLog.e("Apollo3DMessage", 1, "get apollo 3d message jsonObject error", th5);
            return null;
        }
    }

    public void setMessageWithJSONObject(JSONObject jSONObject) {
        if (jSONObject == null) {
            QLog.e("Apollo3DMessage", 1, "jsonObject is null");
            return;
        }
        try {
            this.actionID3D = jSONObject.optInt(RESERVE_JSON_KEY_ACTIONID_3D);
            this.actionType3D = jSONObject.optInt(RESERVE_JSON_KEY_ACTION_TYPE_3D);
            this.actionName3D = jSONObject.optString(RESERVE_JSON_KEY_ACTION_NAME_3D);
            this.senderStatus3D = jSONObject.optInt(RESERVE_JSON_KEY_SENDER_STATUS_3D);
            this.peerStatus3D = jSONObject.optInt(RESERVE_JSON_KEY_PEER_STATUS_3D);
        } catch (Throwable unused) {
            QLog.e("Apollo3DMessage", 1, "set apollo 3d message jsonObject error");
        }
    }
}
