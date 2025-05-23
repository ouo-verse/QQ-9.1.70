package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProRecentVisitChannelInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProRecentVisitChannelList;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes17.dex */
public class GGProRecentVisitChannelList implements IGProRecentVisitChannelList {
    public final GProRecentVisitChannelList mInfo;

    public GGProRecentVisitChannelList(GProRecentVisitChannelList gProRecentVisitChannelList) {
        this.mInfo = gProRecentVisitChannelList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProRecentVisitChannelList
    public long getGuildId() {
        GProRecentVisitChannelList gProRecentVisitChannelList = this.mInfo;
        if (gProRecentVisitChannelList != null) {
            return gProRecentVisitChannelList.getGuildId();
        }
        return 0L;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProRecentVisitChannelList
    public ArrayList<IGProRecentVisitChannelInfo> getRecentList() {
        GProRecentVisitChannelList gProRecentVisitChannelList = this.mInfo;
        if (gProRecentVisitChannelList == null) {
            return new ArrayList<>();
        }
        ArrayList<GProRecentVisitChannelInfo> recentList = gProRecentVisitChannelList.getRecentList();
        ArrayList<IGProRecentVisitChannelInfo> arrayList = new ArrayList<>();
        Iterator<GProRecentVisitChannelInfo> it = recentList.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProRecentVisitChannelInfo(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProRecentVisitChannelList
    public String toString() {
        GProRecentVisitChannelList gProRecentVisitChannelList = this.mInfo;
        if (gProRecentVisitChannelList != null) {
            return gProRecentVisitChannelList.toString();
        }
        return "null";
    }
}
