package com.tencent.upload.report;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.upload.uinterface.TaskTypeConfig;
import com.tencent.upload.utils.Const;
import com.tencent.upload.utils.UploadLog;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes27.dex */
public class SessionReport {
    static IPatchRedirector $redirector_ = null;
    public static final String BUSINESS_TYPE = "BusinessType";
    public static final String CONNECT_TYPE = "ConnectType";
    public static final String IP = "Ip";
    public static final String NEW_STRATEGY = "new_strategy";
    public static final String PORT = "Port";
    public static final String ROUTE = "route";
    public static final String SESSION_ID = "SessionId";
    public static final String TAG = "SessionReport";
    public Const.BusinessType businessType;
    public String connectIp;
    public Const.ConnectType connectType;
    public int newStrategy;
    public int port;
    public String sessionId;
    public TaskTypeConfig taskTypeConfig;
    public String uploadRouteIp;

    public SessionReport() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.newStrategy = 0;
        }
    }

    public void reset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        this.uploadRouteIp = "";
        this.connectIp = "";
        this.port = 0;
        this.sessionId = "";
        this.newStrategy = 0;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(IP, this.connectIp);
            jSONObject.put(PORT, this.port);
            jSONObject.put(SESSION_ID, this.sessionId);
            jSONObject.put(BUSINESS_TYPE, this.businessType);
            jSONObject.put(CONNECT_TYPE, this.connectType);
            jSONObject.put("route", this.uploadRouteIp);
            jSONObject.put(NEW_STRATEGY, this.newStrategy);
        } catch (JSONException e16) {
            UploadLog.e(TAG, "exception:", e16);
        }
        return jSONObject.toString();
    }
}
