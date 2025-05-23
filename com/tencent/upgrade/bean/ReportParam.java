package com.tencent.upgrade.bean;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.upgrade.core.j;
import com.tencent.upgrade.network.b;
import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: classes27.dex */
public class ReportParam {
    static IPatchRedirector $redirector_;
    private HashMap<String, String> extraHeadParams;
    private JSONObject jsonObject;

    public ReportParam() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.extraHeadParams = new HashMap<>();
            this.jsonObject = new JSONObject();
        }
    }

    public HashMap<String, String> getExtraHeadParams() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (HashMap) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.extraHeadParams;
    }

    public JSONObject getJsonObject() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (JSONObject) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.jsonObject;
    }

    public void report() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        UpgradeStrategy h16 = j.l().h();
        String tacticsId = h16.getTacticsId();
        int grayType = h16.getGrayType();
        try {
            this.jsonObject.put("tacticsId", tacticsId);
            this.jsonObject.put("eventTime", System.currentTimeMillis());
            this.jsonObject.put("updateType", grayType);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        b.b(this, j.l().u());
    }

    public void reportPatch(String str, int i3, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, str, Integer.valueOf(i3), str2);
            return;
        }
        try {
            this.jsonObject.put("tacticsId", str);
            this.jsonObject.put("eventTime", System.currentTimeMillis());
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        this.extraHeadParams.put("patchBuildNo", String.valueOf(i3));
        this.extraHeadParams.put("patchMd5", str2);
        b.b(this, j.l().u());
    }

    public ReportParam setEventResult(byte b16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ReportParam) iPatchRedirector.redirect((short) 4, this, Byte.valueOf(b16));
        }
        try {
            this.jsonObject.put("eventResult", (int) b16);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return this;
    }

    public ReportParam setEventType(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ReportParam) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        }
        try {
            this.jsonObject.put("eventType", str);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return this;
    }
}
