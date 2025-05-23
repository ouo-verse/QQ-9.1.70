package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.mobileqq.qqguildsdk.data.genc.GGProChannel;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProRecentVisitChannelInfo;

/* loaded from: classes17.dex */
public class GGProRecentVisitChannelInfo implements IGProRecentVisitChannelInfo {
    public final GProRecentVisitChannelInfo mInfo;

    public GGProRecentVisitChannelInfo(GProRecentVisitChannelInfo gProRecentVisitChannelInfo) {
        this.mInfo = gProRecentVisitChannelInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProRecentVisitChannelInfo
    public long getChannelId() {
        GProRecentVisitChannelInfo gProRecentVisitChannelInfo = this.mInfo;
        if (gProRecentVisitChannelInfo != null) {
            return gProRecentVisitChannelInfo.getChannelId();
        }
        return 0L;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProRecentVisitChannelInfo
    public IGProChannel getChannelInfo() {
        GProRecentVisitChannelInfo gProRecentVisitChannelInfo = this.mInfo;
        if (gProRecentVisitChannelInfo != null) {
            return new GGProChannel(gProRecentVisitChannelInfo.getChannelInfo());
        }
        return null;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProRecentVisitChannelInfo
    public long getUpdateTime() {
        GProRecentVisitChannelInfo gProRecentVisitChannelInfo = this.mInfo;
        if (gProRecentVisitChannelInfo != null) {
            return gProRecentVisitChannelInfo.getUpdateTime();
        }
        return 0L;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProRecentVisitChannelInfo
    public String toString() {
        GProRecentVisitChannelInfo gProRecentVisitChannelInfo = this.mInfo;
        if (gProRecentVisitChannelInfo != null) {
            return gProRecentVisitChannelInfo.toString();
        }
        return "null";
    }
}
