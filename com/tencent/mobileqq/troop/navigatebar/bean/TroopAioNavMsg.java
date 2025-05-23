package com.tencent.mobileqq.troop.navigatebar.bean;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopAioNavMsg implements Serializable {
    static IPatchRedirector $redirector_;
    public long eventRandom;
    public int eventType;
    public long msgSeq;
    public String summary;
    public long tinyId;
    public String troopId;

    public TroopAioNavMsg() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.msgSeq = 0L;
        this.eventType = 0;
        this.eventRandom = 0L;
        this.summary = "";
    }

    public static TroopAioNavMsg parseFromJsonStr(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            TroopAioNavMsg troopAioNavMsg = new TroopAioNavMsg();
            troopAioNavMsg.troopId = jSONObject.getString("troopId");
            troopAioNavMsg.eventType = jSONObject.getInt("eventType");
            troopAioNavMsg.msgSeq = jSONObject.getLong("msgSeq");
            troopAioNavMsg.tinyId = jSONObject.optLong("tinyId");
            troopAioNavMsg.eventRandom = jSONObject.optLong("eventRandom");
            return troopAioNavMsg;
        } catch (JSONException e16) {
            QLog.d("TroopAioNavMsg", 2, "parseFromJsonStr : ", e16);
            return null;
        }
    }

    public static String transToJsonStr(TroopAioNavMsg troopAioNavMsg) {
        if (troopAioNavMsg == null) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("troopId", troopAioNavMsg.troopId);
            jSONObject.put("msgSeq", troopAioNavMsg.msgSeq);
            jSONObject.put("eventType", troopAioNavMsg.eventType);
            jSONObject.put("tinyId", troopAioNavMsg.tinyId);
            jSONObject.put("eventRandom", troopAioNavMsg.eventRandom);
        } catch (JSONException e16) {
            QLog.d("TroopAioNavMsg", 2, "transToJsonStr : ", e16);
        }
        return jSONObject.toString();
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "TroopAioNavMsg{troopId='" + this.troopId + "', msgSeq=" + this.msgSeq + ", eventType=" + this.eventType + ", tinyId=" + this.tinyId + ", eventRandom=" + this.eventRandom + ", summary='" + this.summary + "'}";
    }
}
