package com.tencent.tuxmetersdk.impl.event;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tuxmetersdk.impl.Utils;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes27.dex */
public class TuxEvent {
    static IPatchRedirector $redirector_;

    @SerializedName("event_code")
    private String eventCode;

    @SerializedName("event_time")
    private Date eventTime;
    private String filter;
    private HashMap<String, String> params;
    private String paramsOfJson;

    public TuxEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    private String getNotNullEventCode(String str) {
        if (str == null) {
            return "";
        }
        return str;
    }

    private String getNotNullFilter(String str) {
        if (str == null) {
            return "";
        }
        return str.trim();
    }

    private HashMap<String, String> getNotNullParams(HashMap<String, String> hashMap) {
        if (hashMap == null) {
            return new HashMap<>();
        }
        return hashMap;
    }

    private boolean isEventCodeEqual(String str) {
        return getNotNullEventCode(this.eventCode).equals(getNotNullEventCode(str));
    }

    private void transferParamsToJson(HashMap<String, String> hashMap) {
        if (hashMap != null && hashMap.size() != 0) {
            try {
                Gson gson = new Gson();
                JsonElement jsonTree = gson.toJsonTree(hashMap, new TypeToken<HashMap<String, String>>() { // from class: com.tencent.tuxmetersdk.impl.event.TuxEvent.1
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) TuxEvent.this);
                        }
                    }
                }.getType());
                if (jsonTree != null && jsonTree.isJsonObject()) {
                    JsonObject asJsonObject = jsonTree.getAsJsonObject();
                    String str = hashMap.get(EventKey.EXTRA);
                    if (str != null) {
                        asJsonObject.add(EventKey.EXTRA, new JsonParser().parse(str));
                    }
                    this.paramsOfJson = gson.toJson((JsonElement) asJsonObject);
                }
            } catch (Exception unused) {
            }
        }
    }

    public boolean contain(TuxEvent tuxEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this, (Object) tuxEvent)).booleanValue();
        }
        if (tuxEvent == null || !isEventCodeEqual(tuxEvent.eventCode)) {
            return false;
        }
        HashMap<String, String> notNullParams = getNotNullParams(this.params);
        HashMap<String, String> notNullParams2 = getNotNullParams(tuxEvent.getParams());
        for (Map.Entry<String, String> entry : notNullParams2.entrySet()) {
            if (!notNullParams.containsKey(entry.getKey()) || (notNullParams.containsKey(entry.getKey()) && !Utils.isStrEqual(notNullParams2.get(entry.getKey()), notNullParams.get(entry.getKey())))) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this, obj)).booleanValue();
        }
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TuxEvent tuxEvent = (TuxEvent) obj;
        if (!isEventCodeEqual(tuxEvent.getEventCode()) || !getNotNullParams(this.params).equals(getNotNullParams(tuxEvent.getParams()))) {
            return false;
        }
        return getNotNullFilter(this.filter).equals(getNotNullFilter(tuxEvent.getFilter()));
    }

    public String getEventCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.eventCode;
    }

    public Date getEventTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Date) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.eventTime;
    }

    public String getFilter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.filter;
    }

    public HashMap<String, String> getParams() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (HashMap) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.params;
    }

    public String getParamsOfJson() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        if (TextUtils.isEmpty(this.paramsOfJson)) {
            transferParamsToJson(this.params);
        }
        return this.paramsOfJson;
    }

    public int hashCode() {
        int hashCode;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this)).intValue();
        }
        String str = this.eventCode;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        return 31 + hashCode;
    }

    public void setEventCode(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        } else {
            this.eventCode = str;
        }
    }

    public void setEventTime(Date date) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) date);
        } else {
            this.eventTime = date;
        }
    }

    public void setFilter(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) str);
        } else {
            this.filter = str;
        }
    }

    public void setParams(HashMap<String, String> hashMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) hashMap);
        } else {
            this.params = hashMap;
        }
    }

    public void setParamsOfJson(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) str);
        } else {
            this.paramsOfJson = str;
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (String) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        return "TuxEvent{eventCode='" + this.eventCode + "', eventTime=" + this.eventTime + ", params=" + this.params + ", filter='" + this.filter + "'}";
    }

    public TuxEvent(String str, HashMap<String, String> hashMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) hashMap);
            return;
        }
        this.eventCode = str;
        this.eventTime = new Date();
        this.params = hashMap;
    }

    public TuxEvent(String str, HashMap<String, String> hashMap, Date date) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, str, hashMap, date);
            return;
        }
        this.eventCode = str;
        this.eventTime = date;
        this.params = hashMap;
    }

    public boolean contain(TuxEvent tuxEvent, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 15)) ? contain(tuxEvent) : ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this, (Object) tuxEvent, (Object) str)).booleanValue();
    }
}
