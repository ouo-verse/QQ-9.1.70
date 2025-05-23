package com.tencent.gathererga.core;

import android.text.TextUtils;
import com.tencent.gathererga.core.internal.util.g;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.Serializable;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes6.dex */
public class GathererCloudConfigItem implements Serializable {
    static IPatchRedirector $redirector_;
    private Map<String, String> custom_ops;
    private boolean effective;
    private Map<Integer, Integer> feature_id_ops;
    private long life_time;
    private Map<String, String> path;
    private long seq;
    private long version;

    public GathererCloudConfigItem() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            return;
        }
        iPatchRedirector.redirect((short) 8, (Object) this);
    }

    public Map<String, String> getCustomOps() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Map) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.custom_ops;
    }

    public Map<Integer, Integer> getFeatureIdOps() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Map) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.feature_id_ops;
    }

    public long getLifeTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Long) iPatchRedirector.redirect((short) 6, (Object) this)).longValue();
        }
        return this.life_time;
    }

    public Map<String, String> getPath() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Map) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.path;
    }

    public long getSeq() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return ((Long) iPatchRedirector.redirect((short) 1, (Object) this)).longValue();
        }
        return this.seq;
    }

    public long getVersion() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Long) iPatchRedirector.redirect((short) 3, (Object) this)).longValue();
        }
        return this.version;
    }

    public boolean isEffective() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return this.effective;
    }

    public JSONObject toJson() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (JSONObject) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("seq", Long.valueOf(this.seq));
            jSONObject.putOpt("effective", Boolean.valueOf(this.effective));
            jSONObject.putOpt("version", Long.valueOf(this.version));
            jSONObject.putOpt("path", g.b(this.path));
            jSONObject.putOpt("feature_id_ops", g.a(this.feature_id_ops));
            jSONObject.putOpt("life_time", Long.valueOf(this.life_time));
            jSONObject.putOpt("custom_ops", g.b(this.custom_ops));
        } catch (Exception e16) {
            com.tencent.gathererga.core.internal.util.d.b(e16.getMessage());
        }
        return jSONObject;
    }

    public GathererCloudConfigItem(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.seq = jSONObject.optLong("seq");
            this.effective = jSONObject.optBoolean("effective");
            this.version = jSONObject.optLong("version");
            this.path = g.d(jSONObject.optJSONObject("path"));
            this.feature_id_ops = g.c(jSONObject.optJSONObject("feature_id_ops"));
            this.life_time = jSONObject.optLong("life_time");
            this.custom_ops = g.d(jSONObject.optJSONObject("custom_ops"));
        } catch (Exception e16) {
            com.tencent.gathererga.core.internal.util.d.b(e16.getMessage());
        }
    }
}
