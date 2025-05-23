package com.tencent.mobileqq.springhb.entry.model;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class CommonData implements Serializable {
    static IPatchRedirector $redirector_ = null;
    public static final String ACTIVITY_GAME_CENTER = "gamecenter";
    public static final String ACTIVITY_SPRING_HB = "springhb";
    public static final String ACTIVITY_UNKNOWN = "";
    public static final int APNG_ANIM_DEFAULT_COUNT = 10;
    public static final int DEFAULT_FORBID_REFRESH_TIME = 180;
    public static final String TAG = "SpringHb_CommonData";
    public String activityType;
    public int animationPlayCount;
    public Set<Integer> comboNumberSet;
    public String comboResUrl;
    public List<Integer> comboUpgradeNums;
    public int forbidRefreshAfterTime;
    public int forbidRefreshBeforeTime;
    public List<Integer> giftFiredNums;

    @NonNull
    public MainActivityData mainActivityData;
    public String previewVideoUrl;
    public String rewardsPackageUrl;
    public String springHBMainUrl;
    public String weiboShareText;

    public CommonData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.comboNumberSet = new HashSet();
        this.giftFiredNums = new ArrayList();
        this.comboUpgradeNums = new ArrayList();
        this.comboResUrl = "";
        this.forbidRefreshBeforeTime = 180;
        this.forbidRefreshAfterTime = 180;
        this.rewardsPackageUrl = "";
        this.springHBMainUrl = "";
        this.previewVideoUrl = "";
        this.weiboShareText = "";
        this.activityType = "";
        this.animationPlayCount = 10;
        this.mainActivityData = MainActivityData.newEmpty();
    }

    public static CommonData newEmpty() {
        return new CommonData();
    }

    public boolean isGameCenterActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return "gamecenter".equals(this.activityType);
    }

    public boolean isSpringActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return "springhb".equals(this.activityType);
    }

    public void parseJson(JSONObject jSONObject) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) jSONObject);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "[parseJson] json:" + jSONObject);
        }
        if (jSONObject == null) {
            return;
        }
        this.forbidRefreshBeforeTime = jSONObject.optInt("ForbidRefreshBeforeTime", this.forbidRefreshBeforeTime);
        this.forbidRefreshAfterTime = jSONObject.optInt("ForbidRefreshAfterTime", this.forbidRefreshAfterTime);
        this.rewardsPackageUrl = jSONObject.optString("RewardsPackageUrl", this.rewardsPackageUrl);
        this.springHBMainUrl = jSONObject.optString("SpringHBMainUrl", this.springHBMainUrl);
        this.previewVideoUrl = jSONObject.optString("PreviewVideoUrl", this.previewVideoUrl);
        this.weiboShareText = jSONObject.optString("WeiboShareText", this.weiboShareText);
        this.activityType = jSONObject.optString("ActivityType", this.activityType);
        this.animationPlayCount = jSONObject.optInt("AnimationPlayCount", 10);
        this.mainActivityData.parseJson(jSONObject);
        this.comboResUrl = jSONObject.optString("ComboNumberImgUrls", this.comboResUrl);
        JSONArray optJSONArray = jSONObject.optJSONArray("ComboNumberList");
        if (optJSONArray != null) {
            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                int optInt = optJSONArray.optInt(i3, 0);
                if (optInt != 0) {
                    this.comboNumberSet.add(Integer.valueOf(optInt));
                }
            }
        }
        JSONArray optJSONArray2 = jSONObject.optJSONArray("ShuaRequestNumberList");
        if (optJSONArray2 != null) {
            for (int i16 = 0; i16 < optJSONArray2.length(); i16++) {
                int optInt2 = optJSONArray2.optInt(i16, 0);
                if (optInt2 != 0) {
                    this.giftFiredNums.add(Integer.valueOf(optInt2));
                }
            }
        }
        JSONArray optJSONArray3 = jSONObject.optJSONArray("UpgradeNumbers");
        if (optJSONArray3 != null) {
            for (int i17 = 0; i17 < optJSONArray3.length(); i17++) {
                int optInt3 = optJSONArray3.optInt(i17, 0);
                if (optInt3 != 0) {
                    this.comboUpgradeNums.add(Integer.valueOf(optInt3));
                }
            }
        }
    }

    public String toSimpleString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return "CommonData{, forbidRefreshBeforeTime=" + this.forbidRefreshBeforeTime + ", forbidRefreshAfterTime=" + this.forbidRefreshAfterTime + ", rewardsPackageUrl=" + this.rewardsPackageUrl + ", animationPlayCount=" + this.animationPlayCount + '}';
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return "CommonData{, forbidRefreshBeforeTime=" + this.forbidRefreshBeforeTime + ", forbidRefreshAfterTime=" + this.forbidRefreshAfterTime + ", comboNumberSet=" + this.comboNumberSet + ", comboResUrl='" + this.comboResUrl + "', rewardsPackageUrl=" + this.rewardsPackageUrl + ", activityType=" + this.activityType + ", animationPlayCount=" + this.animationPlayCount + '}';
    }
}
