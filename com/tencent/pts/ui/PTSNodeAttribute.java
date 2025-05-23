package com.tencent.pts.ui;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.pts.utils.PTSStrToObjMap;
import com.tencent.pts.utils.PTSValueConvertUtil;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes22.dex */
public class PTSNodeAttribute extends PTSStrToObjMap {
    static IPatchRedirector $redirector_;

    public PTSNodeAttribute() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    public String getAttributeID() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return PTSValueConvertUtil.getString(get("id"));
    }

    public String getEventBindTap() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return PTSValueConvertUtil.getString(get(PTSNodeAttributeConstant.EVENT_TYPE_TAP));
    }

    public String getEventPtsOnExposure() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return PTSValueConvertUtil.getString(get(PTSNodeAttributeConstant.EVENT_TYPE_PTS_ON_EXPOSURE));
    }

    public String getEventPtsOnTap() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return PTSValueConvertUtil.getString(get(PTSNodeAttributeConstant.EVENT_TYPE_PTS_ON_TAP));
    }

    public String getImageURL() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return PTSValueConvertUtil.getString(get("src"));
    }

    public String getPTSCellType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return PTSValueConvertUtil.getString(get(PTSNodeAttributeConstant.PTS_CELL_TYPE));
    }

    public String getViewID() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return PTSValueConvertUtil.getString(get(PTSNodeAttributeConstant.VIEW_ID));
    }

    public PTSNodeAttribute(Map<String, Object> map) {
        super(map);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) map);
    }

    public PTSNodeAttribute(JSONObject jSONObject) {
        super(jSONObject);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, (Object) this, (Object) jSONObject);
    }
}
