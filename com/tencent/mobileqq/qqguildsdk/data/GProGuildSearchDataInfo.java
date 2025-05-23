package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.mobileqq.qqguildsdk.data.genc.GGProGuildSearchInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildChannelState;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildSearchInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes17.dex */
public class GProGuildSearchDataInfo extends GGProGuildSearchInfo implements IGProSearchGuildInfo {
    private List<Object> mGuildChannelStates;
    private final GProGuildSearchInfo mInfo;
    private final IRecallInfo mRecallInfo;

    public GProGuildSearchDataInfo(GProGuildSearchInfo gProGuildSearchInfo) {
        super(gProGuildSearchInfo);
        this.mGuildChannelStates = new ArrayList();
        this.mInfo = gProGuildSearchInfo;
        if (gProGuildSearchInfo.getGuildStates() != null) {
            Iterator<GProGuildChannelState> it = gProGuildSearchInfo.getGuildStates().iterator();
            while (it.hasNext()) {
                this.mGuildChannelStates.add(new at(it.next()));
            }
        }
        this.mRecallInfo = new GProRecallInfoData(gProGuildSearchInfo.getRecallInfo());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.GGProGuildSearchInfo, com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchInfo, com.tencent.mobileqq.qqguildsdk.data.IGProSearchGuildInfo
    public String getCoverUrl() {
        return this.mInfo.getCoverUrl();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProSearchGuildInfo
    public List<Object> getGuildChannelStates() {
        return this.mGuildChannelStates;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProSearchGuildInfo
    public String getGuildId() {
        return com.tencent.mobileqq.qqguildsdk.util.g.X0(this.mInfo.getGuildId());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.GGProGuildSearchInfo, com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchInfo, com.tencent.mobileqq.qqguildsdk.data.IGProSearchGuildInfo
    public String getGuildNumber() {
        return this.mInfo.getGuildNumber();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.GGProGuildSearchInfo, com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchInfo, com.tencent.mobileqq.qqguildsdk.data.IGProSearchGuildInfo
    public String getHeadUrl() {
        return this.mInfo.getHeadUrl();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.GGProGuildSearchInfo, com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchInfo, com.tencent.mobileqq.qqguildsdk.data.IGProSearchGuildInfo
    public String getJoinGuildSig() {
        return this.mInfo.getJoinGuildSig();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.GGProGuildSearchInfo, com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchInfo, com.tencent.mobileqq.qqguildsdk.data.IGProSearchGuildInfo
    public int getJoinedGuild() {
        return this.mInfo.getJoinedGuild();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.GGProGuildSearchInfo, com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchInfo, com.tencent.mobileqq.qqguildsdk.data.IGProSearchGuildInfo
    public int getMedalLevel() {
        return this.mInfo.getMedalLevel();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.GGProGuildSearchInfo, com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchInfo, com.tencent.mobileqq.qqguildsdk.data.IGProSearchGuildInfo
    public String getName() {
        return this.mInfo.getName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.GGProGuildSearchInfo, com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchInfo, com.tencent.mobileqq.qqguildsdk.data.IGProSearchGuildInfo
    public String getProfile() {
        return this.mInfo.getProfile();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.GGProGuildSearchInfo, com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchInfo, com.tencent.mobileqq.qqguildsdk.data.IGProSearchGuildInfo
    public IRecallInfo getRecallInfo() {
        return this.mRecallInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.GGProGuildSearchInfo, com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchInfo, com.tencent.mobileqq.qqguildsdk.data.IGProSearchGuildInfo
    public ArrayList<String> getTags() {
        return this.mInfo.getTags();
    }
}
