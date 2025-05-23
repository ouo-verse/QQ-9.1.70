package com.tencent.mobileqq.qqguildsdk.data;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProAVChannelConfig;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProAVChannelConfig;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProBusinessNode;
import com.tencent.mobileqq.qqguildsdk.state.ChannelStateUtil;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProChannelMemberInfos;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes17.dex */
public class ChannelMemberInfos implements IAudioChannelMemberInfos {
    public static final int MIC_CLOSE = 2;
    public static final int MIC_OPEN = 1;
    public static final String TAG = "ChannelMemberInfos";
    private String mChannelId;
    private int mChannelMemberCount;
    private List<GProUserInfo> mChannelMemberList;
    private int mChannelMemberMax;
    private ArrayList<IGProChannelStateInfo> mChannelStateList;
    private int mChannelStatus;
    private String mGuildId;
    private GProChannelMemberInfos mInfos;
    private int mSource;
    private long mUpdateTime;

    public ChannelMemberInfos(GProChannelMemberInfos gProChannelMemberInfos) {
        this(gProChannelMemberInfos.getGuildId(), gProChannelMemberInfos);
    }

    private List<GProUserInfo> a(List<GProUserInfo> list, int i3) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (GProUserInfo gProUserInfo : list) {
                if (gProUserInfo.getUser().getVoiceInfo() != null) {
                    if (i3 == 1 && gProUserInfo.getUser().getBusinessInfo().getUserAVInfo().getUserDevState().getMicState() == 2) {
                        arrayList.add(gProUserInfo);
                    } else if (i3 == 2 && gProUserInfo.getUser().getBusinessInfo().getUserAVInfo().getUserDevState().getMicState() != 2) {
                        arrayList.add(gProUserInfo);
                    }
                }
            }
        }
        return arrayList;
    }

    public boolean addUser(GProUserInfo gProUserInfo) {
        if (gProUserInfo == null) {
            return false;
        }
        GProUserInfo gProUserInfo2 = null;
        for (GProUserInfo gProUserInfo3 : this.mChannelMemberList) {
            if (gProUserInfo3.getTinyId().equals(gProUserInfo.getTinyId())) {
                gProUserInfo2 = gProUserInfo3;
            }
        }
        if (gProUserInfo2 != null) {
            gProUserInfo2.reflash(gProUserInfo.getUser());
        } else {
            this.mChannelMemberList.add(gProUserInfo);
            this.mChannelMemberCount++;
            com.tencent.mobileqq.qqguildsdk.util.h.r(TAG, 1, "mGuildId: " + this.mGuildId + " mChannelId:" + this.mChannelId + " add audio chanel mem:" + gProUserInfo.getTinyId());
        }
        return true;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IAudioChannelMemberInfos
    public IGProAVChannelConfig getAVChannelConfig() {
        return new GGProAVChannelConfig(this.mInfos.getChannelConfig());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IAudioChannelMemberInfos
    public int getChannelGameStatus() {
        return this.mChannelStatus;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IAudioChannelMemberInfos
    public int getChannelMemberCount() {
        return this.mChannelMemberCount;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IAudioChannelMemberInfos
    public int getChannelMemberMax() {
        return this.mChannelMemberMax;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IAudioChannelMemberInfos
    public ArrayList<IGProChannelStateInfo> getChannelStateList() {
        return this.mChannelStateList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IAudioChannelMemberInfos
    public String getChannleId() {
        return this.mChannelId;
    }

    public String getGuildId() {
        return this.mGuildId;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IAudioChannelMemberInfos
    public int getNoMemberMaxLimit() {
        return this.mInfos.getNoMemberMaxLimit();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IAudioChannelMemberInfos
    public IGProUserInfo getScreenShareUserInfo() {
        IGProBusinessNode iGProBusinessNode;
        ArrayList<IGProBusinessNode> businessList = getAVChannelConfig().getBusinessList();
        Iterator<IGProBusinessNode> it = businessList.iterator();
        while (true) {
            if (it.hasNext()) {
                iGProBusinessNode = it.next();
                if (iGProBusinessNode.getNodeType() == 2) {
                    break;
                }
            } else {
                iGProBusinessNode = null;
                break;
            }
        }
        if (iGProBusinessNode == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.p(TAG, true, "sdk callback", "getScreenShareUserInfo", "", "channelConfig businessNodes size is " + businessList.size() + ", but has no screen share");
            return null;
        }
        for (int i3 = 0; i3 < this.mChannelMemberList.size(); i3++) {
            GProUserInfo gProUserInfo = this.mChannelMemberList.get(i3);
            if (gProUserInfo.getTinyId().equals(String.valueOf(iGProBusinessNode.getScreenShareInfo().getScreenShareTinyId()))) {
                gProUserInfo.setGProVoiceInfo(iGProBusinessNode.getScreenShareInfo());
                return gProUserInfo;
            }
        }
        return null;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IAudioChannelMemberInfos
    public int getSource() {
        return this.mSource;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IAudioChannelMemberInfos
    public long getUpdateTime() {
        return this.mUpdateTime;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IAudioChannelMemberInfos
    public List<IGProUserInfo> getUserList() {
        return new ArrayList(this.mChannelMemberList);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IAudioChannelMemberInfos
    public List<IGProUserInfo> getUserListOfMuting() {
        return new ArrayList(a(this.mChannelMemberList, 2));
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IAudioChannelMemberInfos
    public List<IGProUserInfo> getUserListOfUnMuting() {
        return new ArrayList(a(this.mChannelMemberList, 1));
    }

    public void reflash(ChannelMemberInfos channelMemberInfos) {
        if (channelMemberInfos != null && this.mChannelId.equals(channelMemberInfos.mChannelId)) {
            this.mChannelMemberCount = channelMemberInfos.mChannelMemberCount;
            this.mChannelMemberMax = channelMemberInfos.mChannelMemberMax;
            this.mChannelMemberList.clear();
            this.mChannelMemberList.addAll(channelMemberInfos.mChannelMemberList);
            this.mChannelStatus = channelMemberInfos.getChannelGameStatus();
            this.mChannelStateList.clear();
            this.mChannelStateList.addAll(channelMemberInfos.getChannelStateList());
            setUpdateTime(channelMemberInfos.mUpdateTime);
            this.mSource = channelMemberInfos.mSource;
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IAudioChannelMemberInfos
    public boolean removeUser(String str) {
        for (GProUserInfo gProUserInfo : this.mChannelMemberList) {
            if (gProUserInfo.getTinyId().equals(str)) {
                this.mChannelMemberList.remove(gProUserInfo);
                int i3 = this.mChannelMemberCount;
                if (i3 > 0) {
                    this.mChannelMemberCount = i3 - 1;
                }
                com.tencent.mobileqq.qqguildsdk.util.h.r(TAG, 1, "mGuildId: " + this.mGuildId + " mChannelId:" + this.mChannelId + " remove audio chanel mem:" + str);
                return true;
            }
        }
        return false;
    }

    public void setSource(int i3) {
        this.mSource = i3;
    }

    public void setUpdateTime(long j3) {
        if (j3 > 0) {
            this.mUpdateTime = j3;
        }
    }

    @NonNull
    public String toString() {
        int size;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("ChannelMemberInfos:{channelId=");
        sb5.append(this.mChannelId);
        sb5.append(" mChannelMemberCount=");
        sb5.append(this.mChannelMemberCount);
        sb5.append(" mChannelMemberList.size=");
        List<GProUserInfo> list = this.mChannelMemberList;
        if (list == null) {
            size = 0;
        } else {
            size = list.size();
        }
        sb5.append(size);
        sb5.append("}");
        return sb5.toString();
    }

    public ChannelMemberInfos(String str, GProChannelMemberInfos gProChannelMemberInfos) {
        this.mChannelMemberList = new ArrayList();
        this.mChannelStateList = null;
        this.mGuildId = str;
        this.mChannelId = gProChannelMemberInfos.getChannelId();
        this.mChannelMemberCount = gProChannelMemberInfos.getChannelMemberCount();
        this.mChannelMemberMax = gProChannelMemberInfos.getChannelMemberMax();
        this.mChannelMemberList = com.tencent.mobileqq.qqguildsdk.util.g.X(gProChannelMemberInfos.getMemberList());
        this.mChannelStatus = gProChannelMemberInfos.getChannelStatus();
        this.mChannelStateList = ChannelStateUtil.c(gProChannelMemberInfos.getChannelStateList());
        this.mInfos = gProChannelMemberInfos;
    }
}
