package com.tencent.gathererga.core;

import com.tencent.gathererga.core.internal.util.g;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes6.dex */
public class GathererCloudReq {
    static IPatchRedirector $redirector_;
    private Map<String, String> client_paths;
    private GathererCloudConfigItem local_config;
    private String ticket;
    private long timestamp;
    private String uuid;

    public GathererCloudReq(Map<String, String> map, GathererCloudConfigItem gathererCloudConfigItem, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, map, gathererCloudConfigItem, str);
            return;
        }
        this.timestamp = System.currentTimeMillis();
        this.client_paths = map;
        this.local_config = gathererCloudConfigItem;
        this.ticket = str;
    }

    public JSONObject toJson() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (JSONObject) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("timestamp", Long.valueOf(this.timestamp));
            jSONObject.putOpt("client_paths", g.b(this.client_paths));
            GathererCloudConfigItem gathererCloudConfigItem = this.local_config;
            if (gathererCloudConfigItem != null) {
                jSONObject.putOpt("local_config", gathererCloudConfigItem.toJson());
            }
            jSONObject.putOpt("uuid", this.uuid);
            jSONObject.putOpt("ticket", this.ticket);
        } catch (Exception e16) {
            com.tencent.gathererga.core.internal.util.d.b(e16.getMessage());
        }
        return jSONObject;
    }
}
