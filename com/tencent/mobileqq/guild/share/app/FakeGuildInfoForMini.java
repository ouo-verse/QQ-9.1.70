package com.tencent.mobileqq.guild.share.app;

import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.fc;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProMedalInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProNavigationInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildAuditBaseItem;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildAuditInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildGlobalAuthInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildSafetyRisk;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes14.dex */
public class FakeGuildInfoForMini implements IGProGuildInfo {

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class a implements fc {
        a() {
        }

        @Override // com.tencent.mobileqq.qqguildsdk.data.fc
        public boolean a() {
            return false;
        }

        @Override // com.tencent.mobileqq.qqguildsdk.data.fc
        public long b() {
            return 0L;
        }

        @Override // com.tencent.mobileqq.qqguildsdk.data.fc
        public boolean c() {
            return false;
        }

        @Override // com.tencent.mobileqq.qqguildsdk.data.fc
        public long d() {
            return 0L;
        }

        @Override // com.tencent.mobileqq.qqguildsdk.data.fc
        public boolean e() {
            return false;
        }

        @Override // com.tencent.mobileqq.qqguildsdk.data.fc
        public boolean f() {
            return false;
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public boolean getAllowSearch() {
        return false;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public long getAvatarSeq() {
        return 0L;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public String getAvatarUrl(int i3) {
        return null;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public long getBannedTimeLimit() {
        return 0L;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public String getCanBeEmptyCoverUrl(int i3, int i16) {
        return "";
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public long getChangeNameInterval() {
        return 0L;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public String getClientId() {
        return null;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public int getCoverFontColorId() {
        return 0;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public String getCoverUrl(int i3, int i16) {
        return null;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public long getCreateTime() {
        return 0L;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public String getCreatorId() {
        return null;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public String getErrMsg() {
        return null;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public int getFeedInteractionNotify() {
        return 0;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public int getFeedInteractionNotifyAll() {
        return 0;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public int getFeedInteractionNotifyIdentityGroup() {
        return 0;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public GProGuildSafetyRisk getGProGuildSafetyRisk() {
        return new GProGuildSafetyRisk();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public long getGroupId() {
        return 0L;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public int getGuildAudioChannelNotify() {
        return 0;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public GProGuildAuditInfo getGuildAuditInfo() {
        return null;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public boolean getGuildCanShare() {
        return false;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public GProGuildGlobalAuthInfo getGuildGlobalAuthInfo() {
        return new GProGuildGlobalAuthInfo();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public String getGuildID() {
        return null;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public int getGuildManagementNotify() {
        return 0;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public String getGuildName() {
        return null;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public long getGuildNameChangeTime() {
        return 0L;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public int getGuildNumSearch() {
        return 0;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public String getGuildNumber() {
        return null;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public int getGuildPostFeedNotify() {
        return 0;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public ArrayList<GProGuildAuditBaseItem> getGuildRules() {
        return null;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public int getGuildSignInNotify() {
        return 0;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public int getGuildTopFeedMsgNotify() {
        return 0;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public int getGuildType() {
        return 0;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public int getGuildUnNotifyFlag() {
        return 0;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public GProGuildInfo getInnerGuildInfo() {
        return null;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public boolean getIsBanned() {
        return false;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public boolean getIsFrozen() {
        return false;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public boolean getIsValid() {
        return false;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public long getJoinTime() {
        return 0L;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public long getJumpChannelId() {
        return 0L;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public boolean getJumpChannelSwitch() {
        return false;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public int getKeywordSearchSwitch() {
        return 0;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public ArrayList<IGProMedalInfo> getMedalInfoList() {
        return new ArrayList<>();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public int getMedalLevel() {
        return 0;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public int getMemberCode() {
        return 0;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public int getMyGuildGlobalAuth() {
        return 0;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public long getMyShutUpExpireTime() {
        return 0L;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public ArrayList<IGProNavigationInfo> getNavigationInfoList() {
        return new ArrayList<>();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public String getProfile() {
        return null;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public int getQRCodePeriod() {
        return 0;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public int getQRCodeSwitch() {
        return 0;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public int getResult() {
        return 0;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public int getScheduleNotify() {
        return 0;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public String getShowNumber() {
        return null;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public long getShutUpExpireTime() {
        return 0L;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public int getSignInNotifySwitch() {
        return 0;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public fc getSpeakThreshold() {
        return new a();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public int getSupportRecommendSwitch() {
        return 0;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public String getTagDesc() {
        return null;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public long getTagId() {
        return 0L;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public boolean getTopicSquareSwitch() {
        return false;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public long getU64guildSeq() {
        return 0L;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public String getUIData(String str) {
        return null;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public long getUint32GuildRuleChangeTime() {
        return 0L;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public int getUserNum() {
        return 0;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public int getUserType() {
        return 0;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public int getVisitorInteractionAllSwitch() {
        return 0;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public int getWeakNotifyDisplay() {
        return 0;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public boolean isGroupGuild() {
        return false;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public boolean isInteractiveForVisitor() {
        return false;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public boolean isMember() {
        return false;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public boolean isMovePostSection() {
        return false;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public boolean isNeedRealNameForVisitor() {
        return false;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public boolean isTop() {
        return false;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo
    public boolean isVisibleForVisitor() {
        return false;
    }
}
