package com.tencent.mobileqq.troop.recommend.data;

import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.troop.ITroopInfoRepoApi;
import java.io.Serializable;
import java.util.List;
import tencent.im.oidb.cmd0x9fb.oidb_0x9fb$Label;
import tencent.im.oidb.cmd0xf57.cmd0xf57$MedalInfo;
import tencent.im.oidb.guild_search_recommend_svr.guildSearchRecommendSvr$Label;

/* compiled from: P */
/* loaded from: classes19.dex */
public class RecommendTroopItem extends Entity implements Serializable {
    static IPatchRedirector $redirector_;
    public int activity;
    public String authSig;

    @notColumn
    public String gameGradeIcon;

    @notColumn
    public boolean hasRequestJoin;

    @notColumn
    public String icon;
    public String intro;
    public List<oidb_0x9fb$Label> labelList;
    public String labelStr;
    public List<guildSearchRecommendSvr$Label> labels;
    public List<cmd0xf57$MedalInfo> medalInfoList;
    public int memberNum;
    public String name;
    public int privilege;
    public String recomAlgol;
    public String recommendReason;
    public String recommendTrace;

    @notColumn
    public List<oidb_0x9fb$Label> stateList;
    public int troopType;

    @notColumn
    public int type;

    @unique
    public String uin;
    public byte[] x935RgroupInfo;
    public byte[] x9fbRgroupInfo;

    public RecommendTroopItem() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public boolean isJoined() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        TroopInfo troopInfoFromCache = ((ITroopInfoRepoApi) QRoute.api(ITroopInfoRepoApi.class)).getTroopInfoFromCache(this.uin);
        if (troopInfoFromCache != null) {
            return troopInfoFromCache.hadJoinTroop();
        }
        int i3 = this.privilege;
        if (i3 == 0 || i3 == 1 || i3 == 2) {
            return true;
        }
        return false;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "RecommendTroopItem{uin='" + this.uin + "', name='" + this.name + "', intro='" + this.intro + "', memberNum=" + this.memberNum + ", troopType=" + this.troopType + ", recommendReason='" + this.recommendReason + "', medals=" + this.medalInfoList + ", recomAlgol='" + this.recomAlgol + "', activityValue=" + this.activity + "', privilege=" + this.privilege + "', isRequestJoin=" + this.hasRequestJoin + "', recommendTrace=" + this.recommendTrace + "'}";
    }
}
