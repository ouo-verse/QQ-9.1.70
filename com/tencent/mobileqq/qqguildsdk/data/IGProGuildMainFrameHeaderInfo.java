package com.tencent.mobileqq.qqguildsdk.data;

import androidx.annotation.Nullable;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGlobalBanner;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildNavigationInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendEssenceSvrRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProRealTimeChannel;
import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes17.dex */
public interface IGProGuildMainFrameHeaderInfo extends Serializable {
    @Nullable
    IGProGlobalBanner getGlobalBannerInfo();

    @Nullable
    Cdo getGuildCreatorFaceAuthInfo();

    @Nullable
    IGProGuildCreatorTaskInfo getGuildCreatorTasks();

    @Nullable
    IGProGuildInfo getGuildInfo();

    @Nullable
    IGProGuildNavigationInfo getGuildNavigationInfo();

    ArrayList<GProRealTimeChannel> getRealTimeChannelInfos();

    @Nullable
    IGProRecentVisitChannelList getRecentVisitChannelList();

    @Nullable
    IGProRecommendEssenceSvrRsp getRecommendEssence();

    String toString();
}
