package com.tencent.tuxmetersdk.model;

import com.google.gson.JsonObject;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tuxmetersdk.gsonadapter.NullableJsonElementTypeAdapterFactory;
import java.io.Serializable;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes27.dex */
public class Resource implements Serializable {
    static IPatchRedirector $redirector_;

    @SerializedName("component_params")
    private HashMap<String, String> componentParams;

    @SerializedName("component_type")
    private int componentType;

    @JsonAdapter(NullableJsonElementTypeAdapterFactory.class)
    private transient JsonObject location;

    @SerializedName("id")
    private String sceneId;

    @SerializedName("url_of_param")
    private String urlOfParam;

    public Resource() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 12)) {
            return;
        }
        iPatchRedirector.redirect((short) 12, (Object) this);
    }

    public void appendComponentParams(HashMap<String, String> hashMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) hashMap);
            return;
        }
        if (hashMap == null) {
            return;
        }
        HashMap<String, String> hashMap2 = this.componentParams;
        if (hashMap2 == null) {
            this.componentParams = hashMap;
        } else {
            hashMap2.putAll(hashMap);
        }
    }

    public HashMap<String, String> getComponentParams() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (HashMap) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.componentParams;
    }

    public int getComponentType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.componentType;
    }

    public JsonObject getLocation() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (JsonObject) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.location;
    }

    public String getSceneId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.sceneId;
    }

    public String getUrlOfParam() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (String) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        return this.urlOfParam;
    }

    public void setComponentParams(HashMap<String, String> hashMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) hashMap);
        } else {
            this.componentParams = hashMap;
        }
    }

    public void setComponentType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
        } else {
            this.componentType = i3;
        }
    }

    public void setLocation(JsonObject jsonObject) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) jsonObject);
        } else {
            this.location = jsonObject;
        }
    }

    public void setSceneId(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        } else {
            this.sceneId = str;
        }
    }

    public void setUrlOfParam(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        } else {
            this.urlOfParam = str;
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return "Resource{urlOfParam='" + this.urlOfParam + "', sceneId='" + this.sceneId + "', location=" + this.location + ", componentType=" + this.componentType + ", componentParams=" + this.componentParams + '}';
    }

    public Resource(String str, String str2, JsonObject jsonObject, int i3, HashMap<String, String> hashMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, str, str2, jsonObject, Integer.valueOf(i3), hashMap);
            return;
        }
        this.urlOfParam = str;
        this.sceneId = str2;
        this.location = jsonObject;
        this.componentType = i3;
        this.componentParams = hashMap;
    }
}
