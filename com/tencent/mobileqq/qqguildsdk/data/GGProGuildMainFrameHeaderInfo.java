package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.mobileqq.qqguildsdk.data.genc.GGProGlobalBanner;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProGuildNavigationInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProRecommendEssenceSvrRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGlobalBanner;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildNavigationInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendEssenceSvrRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildMainFrameHeaderInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProRealTimeChannel;
import java.util.ArrayList;

/* loaded from: classes17.dex */
public class GGProGuildMainFrameHeaderInfo implements IGProGuildMainFrameHeaderInfo {
    public final GProGuildMainFrameHeaderInfo mInfo;

    public GGProGuildMainFrameHeaderInfo(GProGuildMainFrameHeaderInfo gProGuildMainFrameHeaderInfo) {
        this.mInfo = gProGuildMainFrameHeaderInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildMainFrameHeaderInfo
    public IGProGlobalBanner getGlobalBannerInfo() {
        if (this.mInfo.getGlobalBannerInfo() == null) {
            return null;
        }
        return new GGProGlobalBanner(this.mInfo.getGlobalBannerInfo());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildMainFrameHeaderInfo
    public Cdo getGuildCreatorFaceAuthInfo() {
        if (this.mInfo.getGuildCreatorFaceAuthInfo() == null) {
            return null;
        }
        return new n(this.mInfo.getGuildCreatorFaceAuthInfo());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildMainFrameHeaderInfo
    public IGProGuildCreatorTaskInfo getGuildCreatorTasks() {
        if (this.mInfo.getGuildCreatorTasks() == null) {
            return null;
        }
        return new GGProGuildCreatorTaskInfo(this.mInfo.getGuildCreatorTasks());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildMainFrameHeaderInfo
    public IGProGuildInfo getGuildInfo() {
        if (this.mInfo.getGuildInfo() == null) {
            return null;
        }
        return new GProGuildInfo(this.mInfo.getGuildInfo());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildMainFrameHeaderInfo
    public IGProGuildNavigationInfo getGuildNavigationInfo() {
        if (this.mInfo.getGuildNavigationInfo() == null) {
            return null;
        }
        return new GGProGuildNavigationInfo(this.mInfo.getGuildNavigationInfo());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildMainFrameHeaderInfo
    public ArrayList<GProRealTimeChannel> getRealTimeChannelInfos() {
        if (this.mInfo.getRealTimeChannelInfos() == null) {
            return new ArrayList<>();
        }
        return new ArrayList<>(this.mInfo.getRealTimeChannelInfos().channels);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildMainFrameHeaderInfo
    public IGProRecentVisitChannelList getRecentVisitChannelList() {
        if (this.mInfo.getRecentVisitChannelList() == null) {
            return null;
        }
        return new GGProRecentVisitChannelList(this.mInfo.getRecentVisitChannelList());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildMainFrameHeaderInfo
    public IGProRecommendEssenceSvrRsp getRecommendEssence() {
        if (this.mInfo.getRecommendEssence() == null) {
            return null;
        }
        return new GGProRecommendEssenceSvrRsp(this.mInfo.getRecommendEssence());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildMainFrameHeaderInfo
    public String toString() {
        return this.mInfo.toString();
    }
}
