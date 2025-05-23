package com.tencent.mobileqq.springhb.entry.model;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqgamepub.api.impl.QQGamePreDownloadServiceImpl;
import java.io.Serializable;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class HtmlOfflineCheckConfig implements Serializable {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "SpringHb_HtmlOfflineCheckConfig";
    public String bids;
    public String checkDomain;
    public String netType;
    public int timeInterval;
    public int totalCnt;

    public HtmlOfflineCheckConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public void parseJson(JSONObject jSONObject) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) jSONObject);
            return;
        }
        if (jSONObject == null) {
            return;
        }
        this.bids = jSONObject.optString(QQGamePreDownloadServiceImpl.QQGAME_BIDS_KEY, "");
        this.timeInterval = jSONObject.optInt("time_interval", 24);
        this.totalCnt = jSONObject.optInt("total_cnt", 3);
        this.netType = jSONObject.optString("net_type", "0");
        this.checkDomain = jSONObject.optString("check_domain", "");
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "HtmlOfflineCheckConfig{bids='" + this.bids + "', time_interval=" + this.timeInterval + ", total_cnt=" + this.totalCnt + ", net_type='" + this.netType + "', checkDomain='" + this.checkDomain + "'}";
    }
}
