package com.tencent.mobileqq.data.troop;

import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import java.io.Serializable;

/* compiled from: P */
@KeepClassConstructor
@uniqueConstraints(clause = ConflictClause.IGNORE, columnNames = "troopUin")
/* loaded from: classes10.dex */
public class TroopExtDBInfo extends Entity implements Serializable {
    public String atOrReplyMeUins;
    public int avatarId;
    public int comparePartInt;
    public String compareSpell;
    public String dailyNewMemberUins;
    public String feedsId;
    public int fileVideoIsWhite;
    public long fileVideoReqInterval;
    public String headerUinsNew;
    public String headerUinsOld;
    public int insertBAFTipCount;
    public long lastBAFTipMsgUniSeq;
    public long lastInsertBAFTipTime;
    public long lastMsgUpdateMyHonorRichTime;
    public String myHonorList;
    public byte myHonorRichFlag;
    public String newLevelMapStr;
    public long newTroopNameTimeStamp;
    public int specialClass;
    public int troopGuildSwitchOpen;
    public int troopHonorGrayFlag;
    public String troopSettingMemberList;
    public int troopType;
    public String troopUin;
    public String picListJson = "";
    public long oldMemberNickIconSeq = -1;
    public int memberNumClient = -1;
    public String strLastAnnouncement = null;
    public int gameSwitchStatus = 0;
    public int showGameSwitchStatus = 0;
    public int troopRepeatType = 0;
    public int hadInitLevelInfo = 0;
    public byte cGroupRankUserFlag = 0;
    public byte cNewGroupRankUserFlag = 0;

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("TroopExtDBInfo{");
        stringBuffer.append("troopUin='");
        stringBuffer.append(this.troopUin);
        stringBuffer.append('\'');
        stringBuffer.append(", fileVideoIsWhite=");
        stringBuffer.append(this.fileVideoIsWhite);
        stringBuffer.append(", fileVideoReqInterval=");
        stringBuffer.append(this.fileVideoReqInterval);
        stringBuffer.append(", picListJson='");
        stringBuffer.append(this.picListJson);
        stringBuffer.append('\'');
        stringBuffer.append(", avatarId=");
        stringBuffer.append(this.avatarId);
        stringBuffer.append(", headerUinsNew='");
        stringBuffer.append(this.headerUinsNew);
        stringBuffer.append('\'');
        stringBuffer.append(", headerUinsOld='");
        stringBuffer.append(this.headerUinsOld);
        stringBuffer.append('\'');
        stringBuffer.append(", compareSpell='");
        stringBuffer.append(this.compareSpell);
        stringBuffer.append('\'');
        stringBuffer.append(", comparePartInt=");
        stringBuffer.append(this.comparePartInt);
        stringBuffer.append(", oldMemberNickIconSeq=");
        stringBuffer.append(this.oldMemberNickIconSeq);
        stringBuffer.append(", newTroopNameTimeStamp=");
        stringBuffer.append(this.newTroopNameTimeStamp);
        stringBuffer.append(", troopType=");
        stringBuffer.append(this.troopType);
        stringBuffer.append(", specialClass=");
        stringBuffer.append(this.specialClass);
        stringBuffer.append(", memberNumClient=");
        stringBuffer.append(this.memberNumClient);
        stringBuffer.append(", troopSettingMemberList=");
        stringBuffer.append(this.troopSettingMemberList);
        stringBuffer.append(", lastInsertBAFTipTime=");
        stringBuffer.append(this.lastInsertBAFTipTime);
        stringBuffer.append(", insertBAFTipCount=");
        stringBuffer.append(this.insertBAFTipCount);
        stringBuffer.append(", lastBAFTipMsgUniSeq=");
        stringBuffer.append(this.lastBAFTipMsgUniSeq);
        stringBuffer.append(", dailyNewMemberUins=");
        stringBuffer.append(this.dailyNewMemberUins);
        stringBuffer.append(", strLastAnnouncement=");
        stringBuffer.append(this.strLastAnnouncement);
        stringBuffer.append(", atOrReplyMeUins=");
        stringBuffer.append(this.atOrReplyMeUins);
        stringBuffer.append(", gameSwitchStatus=");
        stringBuffer.append(this.gameSwitchStatus);
        stringBuffer.append(", showGameSwitchStatus=");
        stringBuffer.append(this.showGameSwitchStatus);
        stringBuffer.append(", troopHonorGrayFlag=");
        stringBuffer.append(this.troopHonorGrayFlag);
        stringBuffer.append(", troopRepeatType=");
        stringBuffer.append(this.troopRepeatType);
        stringBuffer.append(", feedsId=");
        stringBuffer.append(this.feedsId);
        stringBuffer.append(", myHonorList=");
        stringBuffer.append(this.myHonorList);
        stringBuffer.append(", myHonorRichFlag=");
        stringBuffer.append((int) this.myHonorRichFlag);
        stringBuffer.append(", lastMsgUpdateMyHonorRichTime=");
        stringBuffer.append(this.lastMsgUpdateMyHonorRichTime);
        stringBuffer.append(", troopGuildSwitchOpen=");
        stringBuffer.append(this.troopGuildSwitchOpen);
        stringBuffer.append('}');
        return stringBuffer.toString();
    }
}
