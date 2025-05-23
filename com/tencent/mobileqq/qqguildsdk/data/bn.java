package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildChannelState;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProRecommendChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes17.dex */
public class bn implements ec {

    /* renamed from: a, reason: collision with root package name */
    private GProRecommendChannel f265765a;

    /* renamed from: b, reason: collision with root package name */
    private List<Object> f265766b = new ArrayList();

    public bn(GProRecommendChannel gProRecommendChannel) {
        this.f265765a = gProRecommendChannel;
        ArrayList<GProGuildChannelState> stateList = gProRecommendChannel.getStateList();
        if (stateList != null) {
            Iterator<GProGuildChannelState> it = stateList.iterator();
            while (it.hasNext()) {
                this.f265766b.add(new at(it.next()));
            }
        }
    }
}
