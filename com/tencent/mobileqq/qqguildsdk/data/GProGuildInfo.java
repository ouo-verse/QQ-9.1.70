package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qqguildsdk.api.impl.QQGuildUtilApiImpl;
import com.tencent.mobileqq.qqguildsdk.data.ci;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProMedalInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProNavigationInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProMedalInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProNavigationInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProCmdUinInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProDirectMsgThreshold;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProExtendInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGroupProStatus;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuild;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildAuditBaseItem;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildAuditInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildGlobalAuthInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildSafetyRisk;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProJumpInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProMedalInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProMsgSeq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProNavigationInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProQQMsgSubscribe;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProSpeakThreshold;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProTagInfo;
import java.util.ArrayList;
import java.util.Iterator;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes17.dex */
public class GProGuildInfo implements IGProGuildInfo {
    public static final String TAG = "GProGuildInfo";
    private final String guildId;
    private final int keyWordMaxLength = 2;
    private final GProGuild mGuild;

    public GProGuildInfo(@NotNull GProGuild gProGuild) {
        this.mGuild = gProGuild;
        this.guildId = com.tencent.mobileqq.qqguildsdk.util.g.X0(gProGuild.getGuildId());
    }

    public static GProGuild getGProGuild(ci ciVar) {
        GProGroupProStatus gProGroupProStatus = new GProGroupProStatus();
        gProGroupProStatus.setIsBanned(ciVar.h() ? 1 : 0);
        gProGroupProStatus.setIsFrozen(ciVar.i() ? 1 : 0);
        gProGroupProStatus.setIsEnable(ciVar.l() ? 1 : 0);
        com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildInfo gProGuildInfo = new com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildInfo(com.tencent.mobileqq.qqguildsdk.util.g.O0(ciVar.r()), ciVar.u(), ciVar.o(), ciVar.e(), ciVar.a(), gProGroupProStatus, 0L, ciVar.c(), com.tencent.mobileqq.qqguildsdk.util.g.M0(ciVar.b()), 0L, 0L, 0, 0, 0, "", 0L, 0, 0, 1, new GProSpeakThreshold(), new GProDirectMsgThreshold(), new GProExtendInfo(), com.tencent.mobileqq.qqguildsdk.util.g.D(ciVar.p()), new GProJumpInfo(), 0, 0, com.tencent.mobileqq.qqguildsdk.util.g.w(ciVar.n()), 0, 0L, false, new GProTagInfo(), 0, 0, new GProMsgSeq(ciVar.t(), 0L), new GProMsgSeq(ciVar.s(), 0L), new GProMsgSeq(), new GProMsgSeq(), new GProMsgSeq(), 0, 0L);
        long m3 = ciVar.m();
        int v3 = ciVar.v();
        boolean k3 = ciVar.k();
        return new GProGuild(ciVar.q(), ciVar.f(), com.tencent.mobileqq.qqguildsdk.util.g.O0(ciVar.g()), gProGuildInfo, new GProCmdUinInfo(m3, v3, k3 ? 1 : 0, com.tencent.mobileqq.qqguildsdk.util.g.O0(ciVar.d()), 0L, 0L, 0, 0L, 0L, 0L, 0L, new GProQQMsgSubscribe(), 1, 1, 1, 0, 0L, ciVar.j()), 1000);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public boolean getAllowSearch() {
        if (this.mGuild.getGuildInfo().getAllowSearch() == 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public long getAvatarSeq() {
        return this.mGuild.getGuildInfo().getFaceSeq();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public String getAvatarUrl(int i3) {
        return QQGuildUtilApiImpl.INSTANCE.a(this.guildId, this.mGuild.getGuildInfo().getFaceSeq(), i3);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public long getBannedTimeLimit() {
        return this.mGuild.getGuildInfo().getBannedTimeLimit();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public String getCanBeEmptyCoverUrl(int i3, int i16) {
        if (this.mGuild.getGuildInfo().getCoverSeq() == 0) {
            return "";
        }
        return getCoverUrl(i3, i16);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public long getChangeNameInterval() {
        return this.mGuild.getGuildInfo().getChangeNameInterval();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public String getClientId() {
        return com.tencent.mobileqq.qqguildsdk.util.g.W0(this.mGuild.getGuildInfo().getClientId());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public int getCoverFontColorId() {
        return this.mGuild.getGuildInfo().getCoverFontColorId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public String getCoverUrl(int i3, int i16) {
        return QQGuildUtilApiImpl.INSTANCE.b(this.guildId, this.mGuild.getGuildInfo().getCoverSeq(), i3, i16);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public long getCreateTime() {
        return this.mGuild.getGuildInfo().createTime;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public String getCreatorId() {
        return com.tencent.mobileqq.qqguildsdk.util.g.X0(this.mGuild.getGuildInfo().getOwnerTinyid());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public String getErrMsg() {
        return this.mGuild.getErrMsg();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public int getFeedInteractionNotify() {
        return this.mGuild.getCmdUinInfo().getFeedInteractionNotify();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public int getFeedInteractionNotifyAll() {
        return (int) ((this.mGuild.getCmdUinInfo().getGuildMsgCommonNotify() >> 4) & 1);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public int getFeedInteractionNotifyIdentityGroup() {
        return (int) ((this.mGuild.getCmdUinInfo().getGuildMsgCommonNotify() >> 5) & 1);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public GProGuildSafetyRisk getGProGuildSafetyRisk() {
        return this.mGuild.getGuildInfo().getGuildSafetyRisk();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public long getGroupId() {
        return this.mGuild.getGuildInfo().getGroupId();
    }

    public GProGuild getGuild() {
        return this.mGuild;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public int getGuildAudioChannelNotify() {
        return (int) ((this.mGuild.getCmdUinInfo().getGuildMsgCommonNotify() >> 1) & 1);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public GProGuildAuditInfo getGuildAuditInfo() {
        return this.mGuild.getGuildInfo().getGuildAuditInfo();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public boolean getGuildCanShare() {
        if (this.mGuild.getGuildInfo().getGuildCanShare() == 1) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public GProGuildGlobalAuthInfo getGuildGlobalAuthInfo() {
        return this.mGuild.getGuildInfo().getGuildGlobalAuthInfo();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public String getGuildID() {
        return this.guildId;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public int getGuildManagementNotify() {
        return this.mGuild.getCmdUinInfo().getGuildManagementNotify();
    }

    public ci getGuildModifyInfo(cn cnVar) {
        return new ci.a().D(cnVar.a()).E(cnVar.b()).F(cnVar.c()).C();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public String getGuildName() {
        return this.mGuild.getGuildInfo().getGuildName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public long getGuildNameChangeTime() {
        return this.mGuild.getGuildInfo().getGuildNameChangeTime();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public int getGuildNumSearch() {
        return this.mGuild.getGuildInfo().getGuildNumSearch();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public String getGuildNumber() {
        return this.mGuild.getGuildInfo().getGuildNumber();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public int getGuildPostFeedNotify() {
        return this.mGuild.getCmdUinInfo().getPostFeedNotify();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public ArrayList<GProGuildAuditBaseItem> getGuildRules() {
        return this.mGuild.getGuildInfo().getGuildRules();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public int getGuildSignInNotify() {
        return this.mGuild.getGuildInfo().getGuildSignInNotify();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public int getGuildTopFeedMsgNotify() {
        return (int) (this.mGuild.getCmdUinInfo().getGuildMsgCommonNotify() & 1);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public int getGuildType() {
        return this.mGuild.getGuildInfo().getGuildType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public int getGuildUnNotifyFlag() {
        return this.mGuild.getCmdUinInfo().getGuildUnnotifyFlag();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildInfo getInnerGuildInfo() {
        return this.mGuild.getGuildInfo();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public boolean getIsBanned() {
        boolean z16;
        long serverTime = NetConnInfoCenter.getServerTime();
        boolean z17 = true;
        com.tencent.mobileqq.qqguildsdk.util.h.t(TAG, true, "getIsBanned gid=" + this.mGuild.getGuildId() + ", banned=" + this.mGuild.getGuildInfo().getGuildStatus().getIsBanned() + ", frozen=" + this.mGuild.getGuildInfo().getGuildStatus().getIsFrozen() + ", limitTs=" + this.mGuild.getGuildInfo().getBannedTimeLimit() + ", serTs=" + serverTime);
        if (this.mGuild.getGuildInfo().getGuildStatus().getIsBanned() != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && this.mGuild.getGuildInfo().getBannedTimeLimit() > 0) {
            if (this.mGuild.getGuildInfo().getBannedTimeLimit() < serverTime) {
                z17 = false;
            }
            return z17;
        }
        return z16;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public boolean getIsFrozen() {
        if (this.mGuild.getGuildInfo().getGuildStatus().getIsFrozen() != 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public boolean getIsValid() {
        if (this.mGuild.getGuildInfo().getGuildStatus().getIsEnable() != 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public long getJoinTime() {
        return this.mGuild.getCmdUinInfo().getJoinTime();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public long getJumpChannelId() {
        return this.mGuild.getGuildInfo().getJumpInfo().getChannel();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public boolean getJumpChannelSwitch() {
        if (this.mGuild.getGuildInfo().getJumpInfo().getUint32Switch() != 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public int getKeywordSearchSwitch() {
        return this.mGuild.getGuildInfo().getKeywordSearchSwitch();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public ArrayList<IGProMedalInfo> getMedalInfoList() {
        ArrayList<IGProMedalInfo> arrayList = new ArrayList<>();
        Iterator<GProMedalInfo> it = this.mGuild.getGuildInfo().getMedals().iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProMedalInfo(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public int getMedalLevel() {
        return this.mGuild.getGuildInfo().getMedalLevel();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public int getMemberCode() {
        GProGuild gProGuild = this.mGuild;
        if (gProGuild != null) {
            return gProGuild.memberCode;
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public int getMyGuildGlobalAuth() {
        return (this.mGuild.getCmdUinInfo().getMyGuildGlobalAuth() >> 2) & 1;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public long getMyShutUpExpireTime() {
        return this.mGuild.getCmdUinInfo().getShutupExpireTime();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public ArrayList<IGProNavigationInfo> getNavigationInfoList() {
        ArrayList<IGProNavigationInfo> arrayList = new ArrayList<>();
        Iterator<GProNavigationInfo> it = this.mGuild.getGuildInfo().getNavigations().iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProNavigationInfo(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public String getProfile() {
        return this.mGuild.getGuildInfo().getProfile();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public int getQRCodePeriod() {
        return this.mGuild.getGuildInfo().getQrCodePeriod();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public int getQRCodeSwitch() {
        return this.mGuild.getGuildInfo().getQrCodeSwitch();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public int getResult() {
        return this.mGuild.getResult();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public int getScheduleNotify() {
        return (int) ((this.mGuild.getCmdUinInfo().getGuildMsgCommonNotify() >> 3) & 1);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public String getShowNumber() {
        return com.tencent.mobileqq.qqguildsdk.util.g.X0(this.mGuild.getGuildInfo().getGuildCode());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public long getShutUpExpireTime() {
        return this.mGuild.getGuildInfo().getShutupExpireTime();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public int getSignInNotifySwitch() {
        return (int) ((this.mGuild.getCmdUinInfo().getGuildMsgCommonNotify() >> 2) & 1);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public fc getSpeakThreshold() {
        return com.tencent.mobileqq.qqguildsdk.util.g.u0(this.mGuild.getGuildInfo().getSpeakThreshold(), this.mGuild.getGuildInfo().getDirectMsgThreshold());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public int getSupportRecommendSwitch() {
        return this.mGuild.getGuildInfo().getSupportRecommendSwitch();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public String getTagDesc() {
        return this.mGuild.getGuildInfo().getTagInfo().getDesc();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public long getTagId() {
        return this.mGuild.getGuildInfo().getTagInfo().getId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public boolean getTopicSquareSwitch() {
        if (this.mGuild.getGuildInfo().getTopicSquareSwitch() != 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public long getU64guildSeq() {
        return this.mGuild.getGuildInfo().getGuildInfoChangeSeq().getSeq();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public String getUIData(String str) {
        return null;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public long getUint32GuildRuleChangeTime() {
        return this.mGuild.getGuildInfo().getUint32GuildRuleChangeTime();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public int getUserNum() {
        return this.mGuild.getGuildInfo().getMemberNum();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public int getUserType() {
        return this.mGuild.getCmdUinInfo().getRole();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public int getVisitorInteractionAllSwitch() {
        return this.mGuild.getGuildInfo().getVisitorInteractionAllSwitch();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public int getWeakNotifyDisplay() {
        return this.mGuild.getCmdUinInfo().getWeakNotifyDisplay();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public boolean isGroupGuild() {
        if (getGroupId() > 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public boolean isInteractiveForVisitor() {
        if (this.mGuild.getGuildInfo().getVistorInteraction() != 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public boolean isMember() {
        if (this.mGuild.getCmdUinInfo().getIsMember() == 2) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public boolean isMovePostSection() {
        if (this.mGuild.getGuildInfo().getExtendInfo().getGray().getMovePostSection() == 1) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public boolean isNeedRealNameForVisitor() {
        if (this.mGuild.getGuildInfo().getVistorFaceDistinguish() != 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public boolean isTop() {
        if (this.mGuild.getCmdUinInfo().getIsTop() != 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public boolean isVisibleForVisitor() {
        if (this.mGuild.getGuildInfo().getIsVisibleForVisitor() == 0) {
            return true;
        }
        return false;
    }

    public void setGuildUnNotifyFlag(int i3) {
        this.mGuild.getCmdUinInfo().setGuildUnnotifyFlag(i3);
    }

    public void setIsBanned(boolean z16) {
        this.mGuild.getGuildInfo().getGuildStatus().setIsBanned(z16 ? 1 : 0);
    }

    public void setIsFrozen(boolean z16) {
        this.mGuild.getGuildInfo().getGuildStatus().setIsFrozen(z16 ? 1 : 0);
    }

    public void setIsValid(boolean z16) {
        this.mGuild.getGuildInfo().getGuildStatus().setIsEnable(z16 ? 1 : 0);
    }

    public void setJumpChannelId(long j3) {
        this.mGuild.getGuildInfo().getJumpInfo().setChannel(j3);
    }

    public void setJumpChannelSwitch(boolean z16) {
        this.mGuild.getGuildInfo().getJumpInfo().setUint32Switch(z16 ? 1 : 0);
    }

    public void setMyShutUpExpireTime(long j3) {
        this.mGuild.getCmdUinInfo().setShutupExpireTime(j3);
    }

    public void setTop(boolean z16) {
        this.mGuild.getCmdUinInfo().setIsTop(z16 ? 1 : 0);
    }

    public void setUserType(int i3) {
        this.mGuild.getCmdUinInfo().setRole(i3);
    }

    public void setWeakNotifyDisplay(int i3) {
        this.mGuild.getCmdUinInfo().setWeakNotifyDisplay(i3);
    }

    @NotNull
    public String toString() {
        return "GProGuildInfo{GuilId:" + getGuildID() + " name:" + com.tencent.qqnt.kernel.nativeinterface.cq.w(getGuildName(), 2) + " showNumber:" + getShowNumber() + " isTop:" + isTop() + " CreatorId:" + getCreatorId() + " joinTime:" + getJoinTime() + " userType: " + getUserType() + " result:" + getResult() + " errMsg:" + getErrMsg() + " clientId:" + getClientId() + " coverFontColorId:" + getCoverFontColorId() + " guildCanShare:" + getGuildCanShare() + " qrCodePeriod:" + getQRCodePeriod() + " guildCanShare:" + getGuildCanShare() + " getGuildNameChangeTime:" + getGuildNameChangeTime() + " getChangeNameInterval:" + getChangeNameInterval() + " getGuildNumber:" + getGuildNumber() + " getAllowSearch: " + getAllowSearch() + " isVisibleForVisitor: " + isVisibleForVisitor() + " isMember: " + isMember() + " getJumpChannelSwitch: " + getJumpChannelSwitch() + " getJumpChannelId: " + getJumpChannelId() + " navigation size: " + getNavigationInfoList().size() + " isInteractiveForVisitor: " + isInteractiveForVisitor() + " medal size: " + getMedalInfoList().size() + " topicSquareSwitch: " + getTopicSquareSwitch() + " groupId: " + getGroupId() + " tagId:" + getTagId() + " tagDesc:" + com.tencent.qqnt.kernel.nativeinterface.cq.w(getTagDesc(), 2) + " qrCodeSwitch:" + getQRCodeSwitch() + " guildSignInNotify:" + getGuildSignInNotify() + "}";
    }

    public GProGuildInfo(cn cnVar) {
        this.mGuild = getGProGuild(getGuildModifyInfo(cnVar));
        this.guildId = cnVar.a();
    }

    public void setUIData(String str, String str2) {
    }
}
