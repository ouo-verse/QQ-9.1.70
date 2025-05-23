package com.tencent.gathererga.core;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.Serializable;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes6.dex */
public class GathererCloudResp implements Serializable {
    static IPatchRedirector $redirector_;
    private GathererCloudConfigItem config_item;
    private long record_timestamp;
    private int ret;

    public GathererCloudResp(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.ret = jSONObject.optInt("ret");
            JSONObject optJSONObject = jSONObject.optJSONObject("config_item");
            if (!JSONObject.NULL.equals(optJSONObject)) {
                this.config_item = new GathererCloudConfigItem(optJSONObject.toString());
            }
            this.record_timestamp = jSONObject.optLong("record_timestamp");
        } catch (Exception e16) {
            com.tencent.gathererga.core.internal.util.d.b(e16.getMessage());
        }
    }

    public GathererCloudConfigItem getConfig_item() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (GathererCloudConfigItem) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.config_item;
    }

    public long getRecord_timestamp() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Long) iPatchRedirector.redirect((short) 3, (Object) this)).longValue();
        }
        return this.record_timestamp;
    }

    public int getRet() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return ((Integer) iPatchRedirector.redirect((short) 1, (Object) this)).intValue();
        }
        return this.ret;
    }
}
