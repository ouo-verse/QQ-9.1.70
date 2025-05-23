package com.tencent.tuxmetersdk.impl;

import android.text.TextUtils;
import android.util.Base64;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.tencent.ads.data.AdParam;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tuxmetersdk.impl.event.TuxEvent;
import com.tencent.tuxmetersdk.model.Behavior;
import com.tencent.tuxmetersdk.model.BehaviorConfig;
import com.tencent.tuxmetersdk.model.FrontSurvey;
import com.tencent.tuxmetersdk.model.Resource;
import com.tencent.tuxmetersdk.model.Survey;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes27.dex */
public class TuxSurveyConfig implements Serializable {
    static IPatchRedirector $redirector_;
    private Behavior behavior;

    @SerializedName("bhcfg")
    private BehaviorConfig bhcfg;

    @SerializedName("child_trigger_info")
    private transient JsonObject childTriggerInfo;

    @SerializedName("delivery_id")
    private String deliveryId;

    @SerializedName("end_time")
    private String endTime;

    @SerializedName("ext_info")
    private String extInfo;
    private final Map<String, String> extInfoMap;

    @SerializedName("front_survey")
    private FrontSurvey frontSurvey;
    private boolean isExtInfoDirty;

    @SerializedName("is_permanent")
    private boolean isPermanent;

    @SerializedName("is_white")
    private boolean isWhite;

    @SerializedName("open_id")
    private String openId;

    /* renamed from: pf, reason: collision with root package name */
    @SerializedName(AdParam.PF)
    private String f383471pf;

    @SerializedName("position")
    private String position;
    private Resource resource;

    @SerializedName("start_time")
    private String startTime;
    private Survey survey;

    @SerializedName("trigger_info")
    private transient JsonObject triggerInfo;

    public TuxSurveyConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.extInfoMap = new HashMap();
        this.extInfo = "";
        this.isExtInfoDirty = false;
    }

    public void appendExtInfo(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, (Object) str2);
        } else if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.extInfoMap.put(str, str2);
            this.isExtInfoDirty = true;
        }
    }

    public void fixBh(List<TuxEvent> list) {
        BehaviorConfig behaviorConfig;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this, (Object) list);
            return;
        }
        if (list != null) {
            try {
                if (!list.isEmpty()) {
                    TuxEvent tuxEvent = list.get(list.size() - 1);
                    String eventCode = tuxEvent.getEventCode();
                    HashMap<String, String> params = tuxEvent.getParams();
                    if (params != null && !params.isEmpty() && (behaviorConfig = this.bhcfg) != null && eventCode != null && eventCode.equals(behaviorConfig.getCode())) {
                        HashMap hashMap = new HashMap();
                        List<String> labels = this.bhcfg.getLabels();
                        if (!labels.isEmpty()) {
                            for (String str : labels) {
                                if (params.containsKey(str)) {
                                    hashMap.put(str, params.get(str));
                                }
                            }
                        }
                        this.behavior = new Behavior(eventCode, hashMap);
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    public String getBase64ExtInfoJson() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        try {
            String extInfoJsonString = getExtInfoJsonString();
            if (TextUtils.isEmpty(extInfoJsonString)) {
                return "";
            }
            return Base64.encodeToString(extInfoJsonString.getBytes(), 0).trim();
        } catch (Exception unused) {
            return "";
        }
    }

    public Behavior getBh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return (Behavior) iPatchRedirector.redirect((short) 33, (Object) this);
        }
        return this.behavior;
    }

    public String getBhString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return (String) iPatchRedirector.redirect((short) 34, (Object) this);
        }
        if (this.behavior == null) {
            return "";
        }
        try {
            return Utils.createGson().toJson(this.behavior);
        } catch (Exception unused) {
            return "";
        }
    }

    public BehaviorConfig getBhcfg() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return (BehaviorConfig) iPatchRedirector.redirect((short) 31, (Object) this);
        }
        return this.bhcfg;
    }

    public JsonObject getChildTriggerInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (JsonObject) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.childTriggerInfo;
    }

    public String getDeliveryId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.deliveryId;
    }

    public String getEndTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (String) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        return this.endTime;
    }

    public String getExtInfoJsonString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        if (this.isExtInfoDirty) {
            try {
                this.extInfo = Utils.createGson().toJson(this.extInfoMap);
            } catch (Exception unused) {
            }
            this.isExtInfoDirty = false;
        }
        if (this.extInfo == null) {
            this.extInfo = "";
        }
        return this.extInfo;
    }

    public FrontSurvey getFrontSurvey() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (FrontSurvey) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        return this.frontSurvey;
    }

    public String getOpenId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.openId;
    }

    public String getPf() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return (String) iPatchRedirector.redirect((short) 27, (Object) this);
        }
        return this.f383471pf;
    }

    public String getPosition() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (String) iPatchRedirector.redirect((short) 23, (Object) this);
        }
        return this.position;
    }

    public Resource getResource() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (Resource) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return this.resource;
    }

    public String getStartTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (String) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        return this.startTime;
    }

    public Survey getSurvey() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (Survey) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.survey;
    }

    public JsonObject getTriggerInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (JsonObject) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.triggerInfo;
    }

    public boolean isPermanent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return ((Boolean) iPatchRedirector.redirect((short) 29, (Object) this)).booleanValue();
        }
        return this.isPermanent;
    }

    public boolean isWhite() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Boolean) iPatchRedirector.redirect((short) 25, (Object) this)).booleanValue();
        }
        return this.isWhite;
    }

    public void setBhcfg(BehaviorConfig behaviorConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, (Object) behaviorConfig);
        } else {
            this.bhcfg = behaviorConfig;
        }
    }

    public void setChildTriggerInfo(JsonObject jsonObject) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) jsonObject);
        } else {
            this.childTriggerInfo = jsonObject;
        }
    }

    public void setDeliveryId(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) str);
        } else {
            this.deliveryId = str;
        }
    }

    public void setEndTime(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) str);
        } else {
            this.endTime = str;
        }
    }

    public void setFrontSurvey(FrontSurvey frontSurvey) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) frontSurvey);
        } else {
            this.frontSurvey = frontSurvey;
        }
    }

    public void setOpenId(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) str);
        } else {
            this.openId = str;
        }
    }

    public void setPermanent(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, z16);
        } else {
            this.isPermanent = z16;
        }
    }

    public void setPf(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, (Object) str);
        } else {
            this.f383471pf = str;
        }
    }

    public void setPosition(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) str);
        } else {
            this.position = str;
        }
    }

    public void setResource(Resource resource) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) resource);
        } else {
            this.resource = resource;
        }
    }

    public void setStartTime(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) str);
        } else {
            this.startTime = str;
        }
    }

    public void setSurvey(Survey survey) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) survey);
        } else {
            this.survey = survey;
        }
    }

    public void setTriggerInfo(JsonObject jsonObject) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) jsonObject);
        } else {
            this.triggerInfo = jsonObject;
        }
    }

    public void setWhite(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, z16);
        } else {
            this.isWhite = z16;
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            return (String) iPatchRedirector.redirect((short) 36, (Object) this);
        }
        return "TuxSurveyConfig{deliveryId='" + this.deliveryId + "', triggerInfo=" + this.triggerInfo + ", childTriggerInfo=" + this.childTriggerInfo + ", openId='" + this.openId + "', survey=" + this.survey + ", resource=" + this.resource + ", frontSurvey=" + this.frontSurvey + ", startTime='" + this.startTime + "', endTime='" + this.endTime + "', position='" + this.position + "', extInfo='" + this.extInfo + "'}";
    }
}
