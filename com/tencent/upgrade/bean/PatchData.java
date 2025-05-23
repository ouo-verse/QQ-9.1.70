package com.tencent.upgrade.bean;

import com.google.gson.annotations.SerializedName;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.Serializable;
import java.util.Map;

/* loaded from: classes27.dex */
public class PatchData implements Serializable {
    static IPatchRedirector $redirector_ = null;
    public static final int CMD_NOOP = 0;
    public static final int CMD_ROLLBACK = 101;
    public static final int CMD_UPDATE_NOW = 1;
    public static final int CMD_UPDATE_UNDER_WIFI = 2;
    private static final long serialVersionUID = 6466678674367640280L;

    @SerializedName("cmd")
    private int cmd;

    @SerializedName("extra")
    private Map<String, String> extra;

    @SerializedName("grayType")
    private int grayType;

    @SerializedName("patchInfo")
    private PatchInfo patchInfo;

    @SerializedName("publishTime")
    private long publishTime;

    @SerializedName("tacticsId")
    private String tacticsId;

    @SerializedName("updateTime")
    private long updateTime;

    public PatchData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public int getCmd() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.cmd;
    }

    public Map<String, String> getExtra() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Map) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.extra;
    }

    public int getGrayType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.grayType;
    }

    public PatchInfo getPatchInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (PatchInfo) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.patchInfo;
    }

    public long getPublishTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Long) iPatchRedirector.redirect((short) 4, (Object) this)).longValue();
        }
        return this.publishTime;
    }

    public String getTacticsId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.tacticsId;
    }

    public long getUpdateTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Long) iPatchRedirector.redirect((short) 5, (Object) this)).longValue();
        }
        return this.updateTime;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return "PatchData{tacticsId='" + this.tacticsId + "', patchInfo=" + this.patchInfo + ", publishTime=" + this.publishTime + ", updateTime=" + this.updateTime + ", grayType=" + this.grayType + ", cmd=" + this.cmd + ", extra=" + this.extra + '}';
    }
}
