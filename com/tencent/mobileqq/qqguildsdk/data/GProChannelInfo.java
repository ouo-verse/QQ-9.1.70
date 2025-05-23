package com.tencent.mobileqq.qqguildsdk.data;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qqguildsdk.data.d;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProInviteSpeakCfg;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProMedalInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProVoiceQueueCfg;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProVoiceSpeakModeCfg;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProInviteSpeakCfg;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProMedalInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProVoiceQueueCfg;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProVoiceSpeakModeCfg;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProApplicationChannelInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProAuthControlStatus;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProChannel;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProChannelMedalInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProCmd0xf55CategoryInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProForumChannelInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProInviteSpeakCfg;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProLiveChannelInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProMedalInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProMsgSeq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProOfficialMedalInfoExt;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProQqMsgListSetting;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProSlowModeInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProTextChannelInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProTopMsg;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProVoiceChannelInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProVoiceQueueCfg;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProVoiceSpeakModeCfg;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes17.dex */
public class GProChannelInfo implements IGProChannelInfo {
    public static final String TAG = "GProChannelInfo";
    private final String channelUin;
    private long mCategoryId;
    private String mCategoryName;
    private int mCategoryType;
    private final GProChannel mChannel;

    public GProChannelInfo(GProChannel gProChannel) {
        this.mCategoryId = 0L;
        this.mCategoryName = "";
        this.mChannel = gProChannel;
        this.channelUin = com.tencent.mobileqq.qqguildsdk.util.g.X0(gProChannel.getChannelId());
        this.mCategoryId = gProChannel.getCategoryInfo().categoryId;
        this.mCategoryName = gProChannel.getCategoryInfo().categoryName;
        this.mCategoryType = gProChannel.getCategoryInfo().categoryType;
    }

    public static GProChannel getDefaultGProChannel(d dVar) {
        return new GProChannel(com.tencent.mobileqq.qqguildsdk.util.g.O0(dVar.e()), dVar.m(), 0L, com.tencent.mobileqq.qqguildsdk.util.g.O0(dVar.g()), dVar.k(), dVar.p(), dVar.n(), 1, dVar.l(), new GProMsgSeq(1L, 1L), new GProMsgSeq(1L, 1L), new GProMsgSeq(1L, 1L), new GProMsgSeq(1L, 1L), 1L, new GProVoiceChannelInfo(), "", "", new GProLiveChannelInfo(), 0, 0, new ArrayList(), dVar.f(), new GProApplicationChannelInfo(), new GProTopMsg(), 0, null, new GProTextChannelInfo(), new GProForumChannelInfo(), dVar.s(), 0, 0, null, new GProQqMsgListSetting(), 0, new ArrayList(), 0L, 0, 0L, 0, new GProChannelMedalInfo(), 0, "", "", 0, 0L, false, new GProCmd0xf55CategoryInfo());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    @Deprecated
    public int getAllowOtherRaiseHand() {
        return this.mChannel.getVoiceChannelInfo().getAllowOtherRaiseHand();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public String getAppChannelIconUrl() {
        if (this.mChannel.getApplicationInfo() == null) {
            return null;
        }
        return this.mChannel.getApplicationInfo().getAppChannelIcon();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public int getAppChannelJumpType() {
        if (this.mChannel.getApplicationInfo() == null) {
            return 0;
        }
        return this.mChannel.getApplicationInfo().getAppChannelJumpType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public String getAppChannelJumpUrl() {
        if (this.mChannel.getApplicationInfo() == null) {
            return null;
        }
        return this.mChannel.getApplicationInfo().getAppChannelJumpUrl();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public long getApplicationId() {
        if (this.mChannel.getApplicationInfo() == null) {
            return 0L;
        }
        return this.mChannel.getApplicationInfo().getApplicationId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public ArrayList<df> getAuthControlStatusList() {
        ArrayList<df> arrayList = new ArrayList<>();
        ArrayList<GProAuthControlStatus> authControlStatusList = this.mChannel.getAuthControlStatusList();
        if (authControlStatusList != null) {
            Iterator<GProAuthControlStatus> it = authControlStatusList.iterator();
            while (it.hasNext()) {
                arrayList.add(new l(it.next()));
            }
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public int getBannedSpeak() {
        return this.mChannel.getBannedSpeak();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public long getCategoryId() {
        return this.mCategoryId;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public String getCategoryName() {
        return this.mCategoryName;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public int getCategoryType() {
        return this.mCategoryType;
    }

    public GProChannel getChannel() {
        return this.mChannel;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public int getChannelLiveableType() {
        return this.mChannel.getLivePermission();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public int getChannelMemberMax() {
        if (getType() == 2) {
            return this.mChannel.getVoiceChannelInfo().getMemberMaxNum();
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public String getChannelName() {
        return this.mChannel.getChannelName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public String getChannelUin() {
        return this.channelUin;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public String getContentUrl() {
        return this.mChannel.getContentUrl();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public int getContentUrlType() {
        return this.mChannel.getContentUrlType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public long getCreateTime() {
        return this.mChannel.getCreateTime();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public String getCreatorId() {
        return com.tencent.mobileqq.qqguildsdk.util.g.X0(this.mChannel.getCreatorTinyid());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public int getFinalMsgNotify() {
        return this.mChannel.getCalcMsgNotifyType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    @SuppressLint({"WrongConstant"})
    public int getForumSortMode() {
        if (this.mChannel.getForumChannelInfo() == null) {
            return 0;
        }
        return this.mChannel.getForumChannelInfo().getPostSortMode();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public ArrayList<ISlowModeInfo> getGProSlowModeInfoList() {
        ArrayList<ISlowModeInfo> arrayList = new ArrayList<>();
        if (this.mChannel.getSlowModeInfoList() != null) {
            Iterator<GProSlowModeInfo> it = this.mChannel.getSlowModeInfoList().iterator();
            while (it.hasNext()) {
                arrayList.add(new SlowModeInfo(it.next()));
            }
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public long getGotoChannelId() {
        return this.mChannel.getGotoChannelId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public String getGuildId() {
        return com.tencent.mobileqq.qqguildsdk.util.g.X0(this.mChannel.getGuildId());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public String getHotIcon() {
        return this.mChannel.getForumChannelInfo().getHotIcon();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public int getHotIndex() {
        return this.mChannel.getForumChannelInfo().getHotIndex();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public String getIconUrl() {
        return this.mChannel.getIconUrl();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public IGProInviteSpeakCfg getInviteSpeakCfg() {
        if (this.mChannel.getVoiceChannelInfo() == null) {
            return new GGProInviteSpeakCfg(new GProInviteSpeakCfg());
        }
        return new GGProInviteSpeakCfg(new GProInviteSpeakCfg(this.mChannel.getVoiceChannelInfo().getInviteSpeakState()));
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public int getIsCategoryAdmin() {
        return this.mChannel.getIsCategoryAdmin();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public int getIsChannelAdmin() {
        return this.mChannel.getIsChannelAdmin();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public int getJumpSwitch() {
        return this.mChannel.getSwitchJumpChannelId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public long getLastCntMsgSeq() {
        return this.mChannel.getLastCntMsgSeq().getSeq();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public long getLastCntMsgTime() {
        return this.mChannel.getLastCntMsgSeq().getTime();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public long getLastMsgSeq() {
        return this.mChannel.getLastMsgSeq().getSeq();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public long getLastMsgTime() {
        return this.mChannel.getLastMsgSeq().getTime();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public long getLiveAnchorTinyId() {
        return this.mChannel.getLiveChannelInfo().getAnchorTinyId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public long getLiveRoomId() {
        return this.mChannel.getLiveChannelInfo().getRoomId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public String getLiveRoomName() {
        return this.mChannel.getLiveChannelInfo().getName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public IGProMedalInfo getMedalInfo() {
        return new GGProMedalInfo(new GProMedalInfo(this.mChannel.getMedalInfo().getIconUrl(), this.mChannel.getMedalInfo().getName(), this.mChannel.getMedalInfo().getExpireTime(), new GProOfficialMedalInfoExt()));
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public byte[] getMsgMeta() {
        return this.mChannel.getMsgMeta().getBytes(Charset.defaultCharset());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public int getMsgNotify() {
        return this.mChannel.getMsgNotifyType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public int getMyTalkPermissionType() {
        return this.mChannel.getMySpeakPermissionType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public int getNoMemberMaxLimited() {
        return this.mChannel.getVoiceChannelInfo().getNoMemberMaxLimit();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public String getOperationTitle() {
        return this.mChannel.getOperationTitle();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public int getOperationType() {
        return this.mChannel.getOperationType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public long getReadCntMsgSeq() {
        return this.mChannel.getMyReadCntSeq().getSeq();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public long getReadCntMsgTime() {
        return this.mChannel.getMyReadCntSeq().getTime();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public byte[] getReadMsgMeta() {
        return this.mChannel.getReadMsgMeta().getBytes(Charset.defaultCharset());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public long getReadMsgSeq() {
        return this.mChannel.getMyReadMsgSeq().getSeq();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public long getReadMsgTime() {
        return this.mChannel.getMyReadMsgSeq().getTime();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public int getSlowModeKey() {
        return this.mChannel.getSlowModeKey();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    @NotNull
    public List<Integer> getSpecialType() {
        return this.mChannel.getSpecialTypeList();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public int getTalkPermission() {
        return this.mChannel.getSpeakPermission();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public int getTextChannelSubtypeId() {
        if (this.mChannel.getTextChannelInfo() == null) {
            return 0;
        }
        return this.mChannel.getTextChannelInfo().getSubTypeId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public ArrayList<IGProTopMsg> getTopMsgList() {
        ArrayList<IGProTopMsg> arrayList = new ArrayList<>();
        Iterator<GProTopMsg> it = this.mChannel.getTopMsgList().iterator();
        while (it.hasNext()) {
            arrayList.add(new GProTopMsgInfo(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public String getTopMsgOperatorTinyId() {
        return com.tencent.mobileqq.qqguildsdk.util.g.X0(this.mChannel.getTopMsg().getOperatorTinyid());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public long getTopMsgSeq() {
        return this.mChannel.getTopMsg().getSeq();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public long getTopMsgTime() {
        return this.mChannel.getTopMsg().getTime();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public int getType() {
        return this.mChannel.getChannelType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public int getVisibleType() {
        return this.mChannel.getVisibleType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public IGProVoiceQueueCfg getVoiceQueueCfg() {
        if (this.mChannel.getVoiceChannelInfo() == null) {
            return new GGProVoiceQueueCfg(new GProVoiceQueueCfg());
        }
        return new GGProVoiceQueueCfg(new GProVoiceQueueCfg(this.mChannel.getVoiceChannelInfo().getVoiceQueueState()));
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public IGProVoiceSpeakModeCfg getVoiceSpeakModeCfg() {
        if (this.mChannel.getVoiceChannelInfo() == null) {
            return new GGProVoiceSpeakModeCfg(new GProVoiceSpeakModeCfg());
        }
        return new GGProVoiceSpeakModeCfg(new GProVoiceSpeakModeCfg(this.mChannel.getVoiceChannelInfo().getSpeakMode(), this.mChannel.getVoiceChannelInfo().getSpeakSecond()));
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public boolean isAllowOtherRaiseHand() {
        if (this.mChannel.getVoiceChannelInfo().getAllowOtherRaiseHand() == 1) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public boolean isChannelOrCategoryAdmin() {
        if (getIsChannelAdmin() == 1 || getIsCategoryAdmin() == 1) {
            return true;
        }
        return false;
    }

    public boolean isEqual(IGProChannelInfo iGProChannelInfo) {
        if (iGProChannelInfo == null || !getChannelName().equals(iGProChannelInfo.getChannelName()) || getType() != iGProChannelInfo.getType() || getTalkPermission() != iGProChannelInfo.getTalkPermission() || getMsgNotify() != iGProChannelInfo.getMsgNotify() || getFinalMsgNotify() != iGProChannelInfo.getFinalMsgNotify()) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public boolean isHiddenPostChannel() {
        if (this.mChannel.getHiddenPostChannel() == 1) {
            return true;
        }
        return false;
    }

    public void setBannedSpeak(int i3) {
        this.mChannel.setBannedSpeak(i3);
    }

    public void setCategory(long j3, String str) {
        this.mCategoryId = j3;
        this.mCategoryName = str;
    }

    public void setCategoryType(int i3) {
        this.mCategoryType = i3;
    }

    public void setChannelLiveableType(int i3) {
        this.mChannel.setLivePermission(i3);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public void setFinalMsgNotify(int i3) {
        this.mChannel.setCalcMsgNotifyType(i3);
    }

    public void setMsgNotify(int i3) {
        this.mChannel.setMsgNotifyType(i3);
    }

    public void setSlowModeKey(int i3) {
        this.mChannel.setSlowModeKey(i3);
    }

    public void setTalkPermission(int i3) {
        this.mChannel.setSpeakPermission(i3);
    }

    public void setTopMsgList(ArrayList<IGProTopMsg> arrayList) {
        ArrayList<GProTopMsg> arrayList2 = new ArrayList<>();
        Iterator<IGProTopMsg> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((GProTopMsgInfo) it.next()).mInfo);
        }
        this.mChannel.setTopMsgList(arrayList2);
    }

    @NonNull
    public String toString() {
        return "GProChannelInfo:ID: GuildId:" + getGuildId() + ", chanUin:" + getChannelUin() + ", name:" + getChannelName() + ", talkPermission:" + getTalkPermission() + ", type:" + getType() + ", visibleType:" + getVisibleType() + ", msgNotifyType:" + getMsgNotify() + ", finalMsgNotifyType:" + getFinalMsgNotify() + ", createTime:" + getCreateTime() + ", channelMemMax:" + getChannelMemberMax() + ", roomId:" + getLiveRoomId() + ", slowModeKey:" + getSlowModeKey() + ", textChannelSubtypeId:" + getTextChannelSubtypeId() + ", applicationId:" + getApplicationId() + ", appChannelIcon:" + getAppChannelIconUrl() + ", appChannelJumpType:" + getAppChannelJumpType() + ", appChannelJumpUrl:" + getAppChannelJumpUrl() + ", getGotoChannelId:" + getGotoChannelId() + ", getJumpSwitch" + getJumpSwitch() + ", avNoMemberMaxLimited:" + getNoMemberMaxLimited() + ", getHotIcon:" + getHotIcon() + ", getMedalInfo:" + getMedalInfo() + ", getOperationType:" + getOperationType() + ", getOperationTitle:" + getOperationTitle() + ", getIconUrl:" + getIconUrl() + ", getHiddenPostChannel:" + isHiddenPostChannel() + ", getContentUrl:" + getContentUrl() + ", getContentUrlType:" + getContentUrlType();
    }

    public GProChannelInfo(String str, e eVar) {
        this.mCategoryId = 0L;
        this.mCategoryName = "";
        this.mChannel = getDefaultGProChannel(new d.a().A(str).z(eVar.c()).H(eVar.e()).G(eVar.d()).K(eVar.f()).y());
        this.channelUin = eVar.c();
    }
}
