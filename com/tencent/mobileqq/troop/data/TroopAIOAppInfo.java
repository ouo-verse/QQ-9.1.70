package com.tencent.mobileqq.troop.data;

import android.text.TextUtils;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.Serializable;

/* compiled from: P */
@uniqueConstraints(clause = ConflictClause.REPLACE, columnNames = "appid,groupType")
/* loaded from: classes19.dex */
public class TroopAIOAppInfo extends Entity implements Serializable, Comparable<TroopAIOAppInfo> {
    static IPatchRedirector $redirector_ = null;
    static final long serialVersionUID = 1;
    public String action;
    public String actionType;
    public int appid;
    public boolean canRemove;
    public String enName;
    public int enableC2C;
    public int enableGroup;
    public int groupType;
    public String hashVal;
    public String iconPress;
    public String iconUrl;
    public String iconYouth;
    public int identifyMask;
    public boolean isCommon;
    public boolean isGray;
    public String minVersion;
    public String name;
    public String redDotID;
    public boolean redPoint;
    public String simpleDayPressUrl;
    public String simpleDayUrl;
    public String simpleNightPressUrl;
    public String simpleNightUrl;
    public int sort;
    public String url;

    public TroopAIOAppInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.isCommon = false;
            this.identifyMask = 31;
        }
    }

    public static boolean checkVersion(String str) {
        if (str != null && str.matches("\\d+(\\.\\d+)*")) {
            return true;
        }
        return false;
    }

    public void copyFrom(TroopAIOAppInfo troopAIOAppInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) troopAIOAppInfo);
            return;
        }
        if (troopAIOAppInfo != null) {
            this.appid = troopAIOAppInfo.appid;
            this.redDotID = troopAIOAppInfo.redDotID;
            this.groupType = troopAIOAppInfo.groupType;
            this.hashVal = troopAIOAppInfo.hashVal;
            this.iconUrl = troopAIOAppInfo.iconUrl;
            this.name = troopAIOAppInfo.name;
            this.url = troopAIOAppInfo.url;
            this.redPoint = troopAIOAppInfo.redPoint;
            this.canRemove = troopAIOAppInfo.canRemove;
            this.minVersion = troopAIOAppInfo.minVersion;
            this.identifyMask = troopAIOAppInfo.identifyMask;
            this.isGray = troopAIOAppInfo.isGray;
            this.simpleNightUrl = troopAIOAppInfo.simpleNightUrl;
            this.simpleNightPressUrl = troopAIOAppInfo.simpleNightPressUrl;
            this.simpleDayUrl = troopAIOAppInfo.simpleDayUrl;
            this.simpleDayPressUrl = troopAIOAppInfo.simpleDayPressUrl;
            this.sort = troopAIOAppInfo.sort;
            this.action = troopAIOAppInfo.action;
            this.actionType = troopAIOAppInfo.actionType;
            this.iconPress = troopAIOAppInfo.iconPress;
            this.enableC2C = troopAIOAppInfo.enableC2C;
        }
    }

    public boolean isValidTroopApp() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        if (this.appid > 0 && !TextUtils.isEmpty(this.hashVal) && !TextUtils.isEmpty(this.iconUrl) && !TextUtils.isEmpty(this.name)) {
            return true;
        }
        return false;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return "TroopAppInfo{appid=" + this.appid + ", redDotID=" + this.redDotID + ", groupType='" + this.groupType + "', hashVal='" + this.hashVal + "', iconUrl='" + this.iconUrl + "', name='" + this.name + "', url='" + this.url + "', redPoint=" + this.redPoint + ", canRemove=" + this.canRemove + ", minVersion='" + this.minVersion + "', isGray=" + this.isGray + ", isCommon=" + this.isCommon + ", identifyMask=" + Integer.toBinaryString(this.identifyMask) + ", simpleDayUrl=" + this.simpleDayUrl + ", simpleDayPressUrl=" + this.simpleDayPressUrl + ", simpleNightUrl=" + this.simpleNightUrl + ", simpleNightPressUrl=" + this.simpleNightPressUrl + ", sort=" + this.sort + ", action=" + this.action + ", actionType=" + this.actionType + ", iconPress=" + this.iconPress + ", enable=" + this.enableC2C + '}';
    }

    @Override // java.lang.Comparable
    public int compareTo(TroopAIOAppInfo troopAIOAppInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this, (Object) troopAIOAppInfo)).intValue();
        }
        if (troopAIOAppInfo != null) {
            return this.sort - troopAIOAppInfo.sort;
        }
        return 0;
    }

    public TroopAIOAppInfo(TroopAIOAppInfo troopAIOAppInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) troopAIOAppInfo);
            return;
        }
        this.isCommon = false;
        this.identifyMask = 31;
        copyFrom(troopAIOAppInfo);
    }
}
