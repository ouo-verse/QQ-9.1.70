package com.tencent.upgrade.bean;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.gson.annotations.SerializedName;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.upgrade.util.h;
import java.io.Serializable;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes27.dex */
public class UpgradeStrategy implements Serializable {
    static IPatchRedirector $redirector_ = null;
    private static final long serialVersionUID = 697616473624876182L;

    @SerializedName("apkBasicInfo")
    private ApkBasicInfo apkBasicInfo;

    @SerializedName("clientInfo")
    private ClientInfo clientInfo;

    @SerializedName("extra")
    private Map<String, String> extra;

    @SerializedName("grayType")
    private int grayType;

    @SerializedName("h5Url")
    private String h5Url;

    @SerializedName("newFeature")
    private String newFeature;

    @SerializedName("popInterval")
    private long popInterval;

    @SerializedName("popTimes")
    private int popTimes;

    @SerializedName("publishTime")
    private long publishTime;
    private long receiveMoment;

    @SerializedName("remindType")
    private int remindType;

    @SerializedName("status")
    private int status;

    @SerializedName("tacticsId")
    private String tacticsId;

    @SerializedName("title")
    private String title;

    @SerializedName("undisturbedDuration")
    private long undisturbedDuration;

    @SerializedName("updateStrategy")
    private int updateStrategy;

    @SerializedName("updateTime")
    private long updateTime;

    UpgradeStrategy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.grayType = 1;
        this.status = 1;
        this.updateStrategy = 1;
        this.receiveMoment = System.currentTimeMillis();
    }

    public static UpgradeStrategy getDefaultCache() {
        UpgradeStrategy upgradeStrategy = new UpgradeStrategy();
        upgradeStrategy.apkBasicInfo = new ApkBasicInfo();
        return upgradeStrategy;
    }

    public boolean eq(@Nullable Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Boolean) iPatchRedirector.redirect((short) 24, (Object) this, obj)).booleanValue();
        }
        if (!(obj instanceof UpgradeStrategy)) {
            return false;
        }
        UpgradeStrategy upgradeStrategy = (UpgradeStrategy) obj;
        if (!getApkBasicInfo().equals(upgradeStrategy.getApkBasicInfo()) || !h.a(getTacticsId(), upgradeStrategy.getTacticsId())) {
            return false;
        }
        return true;
    }

    public ApkBasicInfo getApkBasicInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (ApkBasicInfo) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.apkBasicInfo;
    }

    public ClientInfo getClientInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (ClientInfo) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.clientInfo;
    }

    public Map<String, String> getExtra() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (Map) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        return this.extra;
    }

    public int getGrayType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return this.grayType;
    }

    public String getH5Url() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (String) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        return this.h5Url;
    }

    public String getNewFeature() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.newFeature;
    }

    public long getPopInterval() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Long) iPatchRedirector.redirect((short) 12, (Object) this)).longValue();
        }
        return this.popInterval;
    }

    public int getPopTimes() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.popTimes;
    }

    public long getPublishTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Long) iPatchRedirector.redirect((short) 5, (Object) this)).longValue();
        }
        return this.publishTime;
    }

    public long getReceiveMoment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Long) iPatchRedirector.redirect((short) 16, (Object) this)).longValue();
        }
        return this.receiveMoment;
    }

    public int getRemindType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.remindType;
    }

    public int getStatus() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        return this.status;
    }

    public String getTacticsId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return this.tacticsId;
    }

    public String getTitle() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.title;
    }

    public long getUndisturbedDuration() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Long) iPatchRedirector.redirect((short) 13, (Object) this)).longValue();
        }
        return this.undisturbedDuration;
    }

    public int getUpdateStrategy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this)).intValue();
        }
        return this.updateStrategy;
    }

    public long getUpdateTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Long) iPatchRedirector.redirect((short) 6, (Object) this)).longValue();
        }
        return this.updateTime;
    }

    public boolean isLaterThan(int i3, int i16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 22)) ? getApkBasicInfo().isLaterThan(i3, i16, str) : ((Boolean) iPatchRedirector.redirect((short) 22, this, Integer.valueOf(i3), Integer.valueOf(i16), str)).booleanValue();
    }

    public void setNewFeature(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) str);
        } else {
            this.newFeature = str;
        }
    }

    @NonNull
    public String toString() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (String) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        ApkBasicInfo apkBasicInfo = this.apkBasicInfo;
        if (apkBasicInfo != null) {
            str = apkBasicInfo.toString();
        } else {
            str = "";
        }
        return "apkBasicInfo = {" + str + "}, tacticsId = " + this.tacticsId + ", receiveMoment = " + this.receiveMoment + ", popInterval = " + this.popInterval + ", popTimes = " + this.popTimes + ", updateTime = " + this.updateTime + ", undisturbedDuration = " + this.undisturbedDuration + ", status = " + this.status;
    }

    public void updateReceiveMoment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
        } else {
            this.receiveMoment = System.currentTimeMillis();
        }
    }

    public boolean isLaterThan(UpgradeStrategy upgradeStrategy) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 23)) ? getApkBasicInfo().isLaterThan(upgradeStrategy.getApkBasicInfo()) : ((Boolean) iPatchRedirector.redirect((short) 23, (Object) this, (Object) upgradeStrategy)).booleanValue();
    }
}
