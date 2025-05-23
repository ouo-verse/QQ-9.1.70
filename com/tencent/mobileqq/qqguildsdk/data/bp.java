package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProRecommendChannel;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProRecommendGroupInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes17.dex */
public class bp implements ee {

    /* renamed from: a, reason: collision with root package name */
    private ed f265768a;

    /* renamed from: b, reason: collision with root package name */
    private List<ec> f265769b = new ArrayList();

    public bp(GProRecommendGroupInfo gProRecommendGroupInfo) {
        this.f265768a = new bo(gProRecommendGroupInfo.getFeed());
        ArrayList<GProRecommendChannel> channelList = gProRecommendGroupInfo.getChannelList();
        if (channelList != null) {
            Iterator<GProRecommendChannel> it = channelList.iterator();
            while (it.hasNext()) {
                this.f265769b.add(new bn(it.next()));
            }
        }
    }
}
