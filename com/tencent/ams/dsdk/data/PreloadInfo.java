package com.tencent.ams.dsdk.data;

import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class PreloadInfo {
    static IPatchRedirector $redirector_;
    private String materialId;
    private String md5;
    private long size;
    private int type;
    private String url;

    public PreloadInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static PreloadInfo fromJSON(JSONObject jSONObject) {
        if (jSONObject != null && !JSONObject.NULL.equals(jSONObject)) {
            PreloadInfo preloadInfo = new PreloadInfo();
            preloadInfo.setMaterialId(jSONObject.optString(DKConfiguration.PreloadKeys.KEY_MATERIAL_ID));
            preloadInfo.setMd5(jSONObject.optString("md5"));
            preloadInfo.setSize(jSONObject.optLong("size"));
            preloadInfo.setType(jSONObject.optInt("type"));
            preloadInfo.setUrl(jSONObject.optString("url"));
            return preloadInfo;
        }
        return null;
    }

    public String getMaterialId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.materialId;
    }

    public String getMd5() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.md5;
    }

    public long getSize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Long) iPatchRedirector.redirect((short) 6, (Object) this)).longValue();
        }
        return this.size;
    }

    public int getType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return this.type;
    }

    public String getUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.url;
    }

    public void setMaterialId(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        } else {
            this.materialId = str;
        }
    }

    public void setMd5(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        } else {
            this.md5 = str;
        }
    }

    public void setSize(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, j3);
        } else {
            this.size = j3;
        }
    }

    public void setType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, i3);
        } else {
            this.type = i3;
        }
    }

    public void setUrl(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
        } else {
            this.url = str;
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return "PreloadInfo{materialId='" + this.materialId + "', md5='" + this.md5 + "', size=" + this.size + ", type=" + this.type + ", url='" + this.url + "'}";
    }
}
