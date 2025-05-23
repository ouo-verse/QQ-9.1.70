package com.tencent.tuxmetersdk.model;

import com.google.gson.annotations.SerializedName;
import com.tencent.ads.data.AdParam;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes27.dex */
public class PersonalizedSurveyReq {
    static IPatchRedirector $redirector_;

    /* renamed from: bh, reason: collision with root package name */
    @SerializedName("bh")
    private Behavior f383481bh;

    @SerializedName("business")
    String business;

    @SerializedName("is_permanent")
    private boolean isPermanent;

    @SerializedName("is_white")
    private boolean isWhite;

    /* renamed from: pf, reason: collision with root package name */
    @SerializedName(AdParam.PF)
    private String f383482pf;

    @SerializedName("platform")
    private String platform;

    @SerializedName("survey_id")
    String surveyId;

    @SerializedName("user_id")
    String userId;

    @SerializedName("zone_id")
    private String zoneId;

    public PersonalizedSurveyReq(String str, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, str2, str3);
            return;
        }
        this.platform = "Android";
        this.isWhite = false;
        this.business = str;
        this.surveyId = str2;
        this.userId = str3;
    }

    public Behavior getBh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (Behavior) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.f383481bh;
    }

    public String getBusiness() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.business;
    }

    public String getPf() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.f383482pf;
    }

    public String getPlatform() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.platform;
    }

    public boolean isPermanent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        return this.isPermanent;
    }

    public boolean isWhite() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return this.isWhite;
    }

    public void setBh(Behavior behavior) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) behavior);
        } else {
            this.f383481bh = behavior;
        }
    }

    public void setPermanent(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, z16);
        } else {
            this.isPermanent = z16;
        }
    }

    public void setPf(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
        } else {
            this.f383482pf = str;
        }
    }

    public void setPlatform(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        } else {
            this.platform = str;
        }
    }

    public void setWhite(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, z16);
        } else {
            this.isWhite = z16;
        }
    }

    public void setZoneId(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) str);
        } else {
            this.zoneId = str;
        }
    }
}
