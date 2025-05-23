package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProHotLiveCard;
import java.util.ArrayList;

/* loaded from: classes17.dex */
public class GGProHotLiveCard implements IGProHotLiveCard {
    public final GProHotLiveCard mInfo;

    public GGProHotLiveCard(GProHotLiveCard gProHotLiveCard) {
        this.mInfo = gProHotLiveCard;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProHotLiveCard
    public long getChannelId() {
        return this.mInfo.getChannelId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProHotLiveCard
    public int getChannelType() {
        return this.mInfo.getChannelType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProHotLiveCard
    public String getCover() {
        return this.mInfo.getCover();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProHotLiveCard
    public long getGuildId() {
        return this.mInfo.getGuildId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProHotLiveCard
    public String getIcon() {
        return this.mInfo.getIcon();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProHotLiveCard
    public String getLiveTitle() {
        return this.mInfo.getLiveTitle();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProHotLiveCard
    public ArrayList<String> getMemberAvatarList() {
        return this.mInfo.getMemberAvatarList();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProHotLiveCard
    public long getRoomId() {
        return this.mInfo.getRoomId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProHotLiveCard
    public String getThemeSessionId() {
        return this.mInfo.getThemeSessionId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProHotLiveCard
    public int getThemeType() {
        return this.mInfo.getThemeType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProHotLiveCard
    public String toString() {
        return this.mInfo.toString();
    }
}
