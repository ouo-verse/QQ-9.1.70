package com.tencent.mobileqq.troop.troopgame.data;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes19.dex */
public class ProfileGameInfo implements Serializable {
    static IPatchRedirector $redirector_;
    public String area;
    public ArrayList<UserHeroInfo> bestHeroList;
    public int bestOccupation;
    public int currSkinCount;
    public String encrptOpenId;
    public long gamesTotal;
    public int mGrade;
    public long mvpTotal;
    public String partition;
    public String platid;
    public String roleId;
    public double seasonWinRate;
    public ArrayList<SkinGroupInfo> skinGroupList;
    public int skinHonor;
    public String skinHonorIcon;
    public int skinPartition;
    public int skinPrice;
    public String skinRoleId;
    public int skinTotal;

    /* loaded from: classes19.dex */
    public static class SkinGroupInfo implements Serializable {
        static IPatchRedirector $redirector_;
        public int skinCount;
        public String skinName;
        public String skinPic;
        public int skinTotal;

        public SkinGroupInfo(String str, int i3, int i16, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16), str2);
                return;
            }
            this.skinName = str;
            this.skinCount = i3;
            this.skinTotal = i16;
            this.skinPic = str2;
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return "SkinGroupInfo{skinName=" + this.skinName + "skinCount=" + this.skinCount + ", skinTotal=" + this.skinTotal + ", skinPic='" + this.skinPic + "'}";
        }
    }

    /* loaded from: classes19.dex */
    public class UserHeroInfo implements Serializable {
        static IPatchRedirector $redirector_;
        public String heroIcon;
        public long heroId;
        public int skilledLevel;

        public UserHeroInfo(long j3, String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, ProfileGameInfo.this, Long.valueOf(j3), str, Integer.valueOf(i3));
                return;
            }
            this.heroId = j3;
            this.heroIcon = str;
            this.skilledLevel = i3;
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return "UserHeroInfo{heroId=" + this.heroId + ", heroIcon='" + this.heroIcon + "', skilledLevel=" + this.skilledLevel + '}';
        }
    }

    public ProfileGameInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mGrade = 0;
        this.seasonWinRate = 0.0d;
        this.gamesTotal = 0L;
        this.mvpTotal = 0L;
        this.bestOccupation = 0;
        this.bestHeroList = new ArrayList<>();
        this.currSkinCount = 0;
        this.skinTotal = 0;
        this.skinPrice = 0;
        this.skinHonor = 0;
        this.skinHonorIcon = "";
        this.skinGroupList = new ArrayList<>();
    }

    public boolean isEmpty() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        if (isRankEmpty() && isSkinEmpty()) {
            return true;
        }
        return false;
    }

    public boolean isRankEmpty() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        if (this.mGrade <= 0 && this.seasonWinRate <= 0.0d && this.gamesTotal <= 0 && this.mvpTotal <= 0 && this.bestOccupation <= 0 && this.bestHeroList.size() == 0) {
            return true;
        }
        return false;
    }

    public boolean isSkinEmpty() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        if (this.skinTotal <= 0 && this.skinGroupList.size() == 0) {
            return true;
        }
        return false;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return "ProfileGameInfo{mGrade=" + this.mGrade + ", seasonWinRate=" + this.seasonWinRate + ", gamesTotal=" + this.gamesTotal + ", mvpTotal=" + this.mvpTotal + ", bestOccupation=" + this.bestOccupation + ", encrptOpenId='" + this.encrptOpenId + "', partition='" + this.partition + "', platid='" + this.platid + "', area='" + this.area + "', bestHeroList=" + this.bestHeroList.size() + ", currSkinCount=" + this.currSkinCount + ", skinTotal=" + this.skinTotal + ", skinPrice=" + this.skinPrice + ", skinHonor=" + this.skinHonor + ", skinHonorIcon='" + this.skinHonorIcon + "', skinGroupList=" + this.skinGroupList.size() + '}';
    }

    public boolean validRankJumpParams() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        if (!TextUtils.isEmpty(this.encrptOpenId) && !TextUtils.isEmpty(this.partition) && !TextUtils.isEmpty(this.platid) && !TextUtils.isEmpty(this.area)) {
            return true;
        }
        return false;
    }
}
