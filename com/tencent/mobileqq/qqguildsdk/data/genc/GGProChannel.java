package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProAuthControlStatus;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProChannel;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProChannelInfoExtendInfoEntry;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProSlowModeInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProTopMsg;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes17.dex */
public class GGProChannel implements IGProChannel {
    public final GProChannel mInfo;

    public GGProChannel(GProChannel gProChannel) {
        this.mInfo = gProChannel;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel
    public IGProApplicationChannelInfo getApplicationInfo() {
        return new GGProApplicationChannelInfo(this.mInfo.getApplicationInfo());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel
    public ArrayList<IGProAuthControlStatus> getAuthControlStatusList() {
        ArrayList<GProAuthControlStatus> authControlStatusList = this.mInfo.getAuthControlStatusList();
        ArrayList<IGProAuthControlStatus> arrayList = new ArrayList<>();
        Iterator<GProAuthControlStatus> it = authControlStatusList.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProAuthControlStatus(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel
    public int getBannedSpeak() {
        return this.mInfo.getBannedSpeak();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel
    public int getCalcMsgNotifyType() {
        return this.mInfo.getCalcMsgNotifyType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel
    public IGProCmd0xf55CategoryInfo getCategoryInfo() {
        return new GGProCmd0xf55CategoryInfo(this.mInfo.getCategoryInfo());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel
    public long getChannelChangeSeq() {
        return this.mInfo.getChannelChangeSeq();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel
    public long getChannelId() {
        return this.mInfo.getChannelId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel
    public String getChannelName() {
        return this.mInfo.getChannelName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel
    public int getChannelType() {
        return this.mInfo.getChannelType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel
    public String getContentUrl() {
        return this.mInfo.getContentUrl();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel
    public int getContentUrlType() {
        return this.mInfo.getContentUrlType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel
    public long getCreateTime() {
        return this.mInfo.getCreateTime();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel
    public long getCreatorTinyid() {
        return this.mInfo.getCreatorTinyid();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel
    public ArrayList<IGProChannelInfoExtendInfoEntry> getExtendInfoList() {
        ArrayList<GProChannelInfoExtendInfoEntry> extendInfoList = this.mInfo.getExtendInfoList();
        ArrayList<IGProChannelInfoExtendInfoEntry> arrayList = new ArrayList<>();
        Iterator<GProChannelInfoExtendInfoEntry> it = extendInfoList.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProChannelInfoExtendInfoEntry(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel
    public IGProForumChannelInfo getForumChannelInfo() {
        return new GGProForumChannelInfo(this.mInfo.getForumChannelInfo());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel
    public long getGotoChannelId() {
        return this.mInfo.getGotoChannelId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel
    public long getGuildId() {
        return this.mInfo.getGuildId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel
    public boolean getHasCustomMsgNotifyType() {
        return this.mInfo.getHasCustomMsgNotifyType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel
    public int getHiddenPostChannel() {
        return this.mInfo.getHiddenPostChannel();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel
    public String getIconUrl() {
        return this.mInfo.getIconUrl();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel
    public int getIsCategoryAdmin() {
        return this.mInfo.getIsCategoryAdmin();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel
    public int getIsChannelAdmin() {
        return this.mInfo.getIsChannelAdmin();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel
    public IGProMsgSeq getLastCntMsgSeq() {
        return new GGProMsgSeq(this.mInfo.getLastCntMsgSeq());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel
    public IGProMsgSeq getLastMsgSeq() {
        return new GGProMsgSeq(this.mInfo.getLastMsgSeq());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel
    public IGProLiveChannelInfo getLiveChannelInfo() {
        return new GGProLiveChannelInfo(this.mInfo.getLiveChannelInfo());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel
    public int getLivePermission() {
        return this.mInfo.getLivePermission();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel
    public long getMaxEventSeq() {
        return this.mInfo.getMaxEventSeq();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel
    public IGProChannelMedalInfo getMedalInfo() {
        return new GGProChannelMedalInfo(this.mInfo.getMedalInfo());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel
    public String getMsgMeta() {
        return this.mInfo.getMsgMeta();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel
    public int getMsgNotifyType() {
        return this.mInfo.getMsgNotifyType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel
    public int getMyMsgNotifyBackendFlag() {
        return this.mInfo.getMyMsgNotifyBackendFlag();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel
    public int getMyMsgNotifyType() {
        return this.mInfo.getMyMsgNotifyType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel
    public IGProQqMsgListSetting getMyQqMsgListSetting() {
        return new GGProQqMsgListSetting(this.mInfo.getMyQqMsgListSetting());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel
    public IGProMsgSeq getMyReadCntSeq() {
        return new GGProMsgSeq(this.mInfo.getMyReadCntSeq());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel
    public IGProMsgSeq getMyReadMsgSeq() {
        return new GGProMsgSeq(this.mInfo.getMyReadMsgSeq());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel
    public int getMySpeakPermissionType() {
        return this.mInfo.getMySpeakPermissionType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel
    public String getOperationTitle() {
        return this.mInfo.getOperationTitle();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel
    public int getOperationType() {
        return this.mInfo.getOperationType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel
    public int getPrivateType() {
        return this.mInfo.getPrivateType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel
    public String getReadMsgMeta() {
        return this.mInfo.getReadMsgMeta();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel
    public int getResult() {
        return this.mInfo.getResult();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel
    public ArrayList<IGProSlowModeInfo> getSlowModeInfoList() {
        ArrayList<GProSlowModeInfo> slowModeInfoList = this.mInfo.getSlowModeInfoList();
        ArrayList<IGProSlowModeInfo> arrayList = new ArrayList<>();
        Iterator<GProSlowModeInfo> it = slowModeInfoList.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProSlowModeInfo(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel
    public int getSlowModeKey() {
        return this.mInfo.getSlowModeKey();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel
    public int getSpeakPermission() {
        return this.mInfo.getSpeakPermission();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel
    public ArrayList<Integer> getSpecialTypeList() {
        return this.mInfo.getSpecialTypeList();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel
    public int getSwitchJumpChannelId() {
        return this.mInfo.getSwitchJumpChannelId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel
    public IGProTextChannelInfo getTextChannelInfo() {
        return new GGProTextChannelInfo(this.mInfo.getTextChannelInfo());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel
    public IGProTopMsg getTopMsg() {
        return new GGProTopMsg(this.mInfo.getTopMsg());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel
    public ArrayList<IGProTopMsg> getTopMsgList() {
        ArrayList<GProTopMsg> topMsgList = this.mInfo.getTopMsgList();
        ArrayList<IGProTopMsg> arrayList = new ArrayList<>();
        Iterator<GProTopMsg> it = topMsgList.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProTopMsg(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel
    public int getVisibleType() {
        return this.mInfo.getVisibleType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel
    public IGProVoiceChannelInfo getVoiceChannelInfo() {
        return new GGProVoiceChannelInfo(this.mInfo.getVoiceChannelInfo());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel
    public String toString() {
        return this.mInfo.toString();
    }
}
