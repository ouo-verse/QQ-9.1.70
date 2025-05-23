package com.tencent.tuxmetersdk.model;

import com.google.gson.annotations.SerializedName;
import com.tencent.ads.data.AdParam;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tuxmetersdk.export.config.TuxConstants;
import com.tencent.tuxmetersdk.impl.TuxDataManager;
import com.tencent.tuxmetersdk.impl.TuxSurveyConfig;
import com.tencent.tuxmetersdk.impl.Utils;
import java.util.Date;
import java.util.TimeZone;
import java.util.UUID;

/* compiled from: P */
/* loaded from: classes27.dex */
public class SurveyConfig {
    static IPatchRedirector $redirector_;

    @SerializedName("bhcfg")
    private BehaviorConfig bhcfg;

    @SerializedName("child_trigger")
    private String childTrigger;

    @SerializedName("end_time")
    private String endTime;

    @SerializedName("front_survey")
    private FrontSurvey frontSurvey;

    @SerializedName("is_permanent")
    private boolean isPermanent;

    @SerializedName("is_white")
    private boolean isWhite;

    @SerializedName("open_id")
    private String openId;

    /* renamed from: pf, reason: collision with root package name */
    @SerializedName(AdParam.PF)
    private String f383487pf;

    @SerializedName("position")
    private String position;
    private Resource resource;

    @SerializedName("start_time")
    private String startTime;
    private Survey survey;

    @SerializedName("task_id")
    private String taskId;
    private String trigger;

    public SurveyConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.resource = new Resource();
        this.survey = new Survey();
        this.frontSurvey = new FrontSurvey();
    }

    public BehaviorConfig getBhcfg() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (BehaviorConfig) iPatchRedirector.redirect((short) 28, (Object) this);
        }
        return this.bhcfg;
    }

    public String getChildTrigger() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.childTrigger;
    }

    public String getEndTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (String) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        return this.endTime;
    }

    public FrontSurvey getFrontSurvey() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (FrontSurvey) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return this.frontSurvey;
    }

    public String getOpenId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.openId;
    }

    public String getPf() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (String) iPatchRedirector.redirect((short) 24, (Object) this);
        }
        return this.f383487pf;
    }

    public String getPosition() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (String) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        return this.position;
    }

    public Resource getResource() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Resource) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.resource;
    }

    public String getStartTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (String) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return this.startTime;
    }

    public Survey getSurvey() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (Survey) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.survey;
    }

    public String getTaskId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.taskId;
    }

    public String getTrigger() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.trigger;
    }

    public boolean isInValidityPeriod() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return ((Boolean) iPatchRedirector.redirect((short) 29, (Object) this)).booleanValue();
        }
        Date convertTime = Utils.convertTime(this.startTime, TuxConstants.BEIJING_TIMEZONE, TimeZone.getDefault().getDisplayName());
        Date convertTime2 = Utils.convertTime(this.endTime, TuxConstants.BEIJING_TIMEZONE, TimeZone.getDefault().getDisplayName());
        Date date = new Date();
        if (convertTime != null && convertTime2 != null) {
            if (convertTime.after(convertTime2)) {
                return true;
            }
            if (date.getTime() < convertTime.getTime() || date.getTime() > convertTime2.getTime()) {
                return false;
            }
            return true;
        }
        if (convertTime == null && convertTime2 == null) {
            return true;
        }
        if (convertTime == null) {
            if (date.getTime() > convertTime2.getTime()) {
                return false;
            }
            return true;
        }
        if (date.getTime() < convertTime.getTime()) {
            return false;
        }
        return true;
    }

    public boolean isPermanent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Boolean) iPatchRedirector.redirect((short) 26, (Object) this)).booleanValue();
        }
        return this.isPermanent;
    }

    public boolean isWhite() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Boolean) iPatchRedirector.redirect((short) 22, (Object) this)).booleanValue();
        }
        return this.isWhite;
    }

    public void setChildTrigger(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        } else {
            this.childTrigger = str;
        }
    }

    public void setEndTime(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) str);
        } else {
            this.endTime = str;
        }
    }

    public void setFrontSurvey(FrontSurvey frontSurvey) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) frontSurvey);
        } else {
            this.frontSurvey = frontSurvey;
        }
    }

    public void setOpenId(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        } else {
            this.openId = str;
        }
    }

    public void setPermanent(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, z16);
        } else {
            this.isPermanent = z16;
        }
    }

    public void setPf(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) str);
        } else {
            this.f383487pf = str;
        }
    }

    public void setPosition(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) str);
        } else {
            this.position = str;
        }
    }

    public void setResource(Resource resource) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) resource);
        } else {
            this.resource = resource;
        }
    }

    public void setStartTime(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) str);
        } else {
            this.startTime = str;
        }
    }

    public void setSurvey(Survey survey) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) survey);
        } else {
            this.survey = survey;
        }
    }

    public void setTaskId(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) str);
        } else {
            this.taskId = str;
        }
    }

    public void setTrigger(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        } else {
            this.trigger = str;
        }
    }

    public void setWhite(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, z16);
        } else {
            this.isWhite = z16;
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return (String) iPatchRedirector.redirect((short) 30, (Object) this);
        }
        return "SurveyConfig{openId='" + this.openId + "', trigger='" + this.trigger + "', resource=" + this.resource + ", survey=" + this.survey + ", taskId='" + this.taskId + "', frontSurvey=" + this.frontSurvey + ", startTime='" + this.startTime + "', endTime='" + this.endTime + "', position='" + this.position + "'}";
    }

    public TuxSurveyConfig transferToTuxSurveyConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return (TuxSurveyConfig) iPatchRedirector.redirect((short) 31, (Object) this);
        }
        TuxSurveyConfig tuxSurveyConfig = new TuxSurveyConfig();
        SurveyConfig deepCopySurveyConfig = TuxDataManager.deepCopySurveyConfig(this);
        if (deepCopySurveyConfig == null) {
            return null;
        }
        tuxSurveyConfig.setDeliveryId(UUID.randomUUID().toString());
        tuxSurveyConfig.setOpenId(deepCopySurveyConfig.openId);
        tuxSurveyConfig.setSurvey(deepCopySurveyConfig.survey);
        tuxSurveyConfig.setResource(deepCopySurveyConfig.resource);
        tuxSurveyConfig.setFrontSurvey(deepCopySurveyConfig.frontSurvey);
        tuxSurveyConfig.setStartTime(deepCopySurveyConfig.startTime);
        tuxSurveyConfig.setEndTime(deepCopySurveyConfig.endTime);
        tuxSurveyConfig.setPosition(deepCopySurveyConfig.position);
        tuxSurveyConfig.setWhite(deepCopySurveyConfig.isWhite);
        tuxSurveyConfig.setPf(deepCopySurveyConfig.f383487pf);
        tuxSurveyConfig.setPermanent(deepCopySurveyConfig.isPermanent);
        tuxSurveyConfig.setBhcfg(deepCopySurveyConfig.bhcfg);
        return tuxSurveyConfig;
    }
}
