package com.tencent.biz.qqcircle.immersive.utils;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.requests.QCircleDoFollowRequest;
import com.tencent.biz.qqcircle.richframework.sender.iml.fake.a;
import com.tencent.richframework.sender.call.Call;
import feedcloud.FeedCloudCommon$Entry;
import feedcloud.FeedCloudCommon$StCommonExt;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StUser;

/* compiled from: P */
/* loaded from: classes4.dex */
public class z {
    public static void a(Call.OnRspCallBack onRspCallBack, FeedCloudMeta$StUser feedCloudMeta$StUser, QCircleInitBean qCircleInitBean, FeedCloudCommon$StCommonExt feedCloudCommon$StCommonExt) {
        if (feedCloudMeta$StUser == null) {
            return;
        }
        int i3 = feedCloudMeta$StUser.followState.get() ^ 1;
        Bundle bundle = new Bundle();
        bundle.putInt(eb0.a.f396059a, i3);
        com.tencent.biz.qqcircle.richframework.sender.iml.b.a().b().k(false).addInterceptor(new com.tencent.biz.qqcircle.richframework.sender.iml.fake.a(true, new a.C0926a(feedCloudMeta$StUser.f398463id.get(), feedCloudMeta$StUser.followState.get(), i3))).addRspInterceptor(new eb0.a()).addExtraData(bundle).addRequest(new QCircleDoFollowRequest(feedCloudMeta$StUser, i3 & 1, feedCloudCommon$StCommonExt, qCircleInitBean)).m250setRspOnCallBack(onRspCallBack).execute();
    }

    public static void b(Call.OnRspCallBack onRspCallBack, FeedCloudMeta$StUser feedCloudMeta$StUser, FeedCloudMeta$StFeed feedCloudMeta$StFeed, QCircleInitBean qCircleInitBean) {
        FeedCloudCommon$StCommonExt feedCloudCommon$StCommonExt;
        if (feedCloudMeta$StFeed != null && !TextUtils.isEmpty(feedCloudMeta$StFeed.f398449id.get())) {
            feedCloudCommon$StCommonExt = new FeedCloudCommon$StCommonExt();
            FeedCloudCommon$Entry feedCloudCommon$Entry = new FeedCloudCommon$Entry();
            feedCloudCommon$Entry.key.set("feedid");
            feedCloudCommon$Entry.value.set(feedCloudMeta$StFeed.f398449id.get());
            feedCloudCommon$StCommonExt.mapInfo.get().add(feedCloudCommon$Entry);
        } else {
            feedCloudCommon$StCommonExt = null;
        }
        a(onRspCallBack, feedCloudMeta$StUser, qCircleInitBean, feedCloudCommon$StCommonExt);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0045, code lost:
    
        if (r5 != 3) goto L21;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void c(String str, int i3) {
        MutableLiveData globalData = w20.a.j().getGlobalData(com.tencent.biz.qqcircle.immersive.personal.data.w.class, str);
        if (globalData != null && globalData.getValue() != 0) {
            com.tencent.biz.qqcircle.immersive.personal.data.w wVar = (com.tencent.biz.qqcircle.immersive.personal.data.w) globalData.getValue();
            if (wVar.c().followState.get() == i3) {
                return;
            }
            int i16 = (int) wVar.c().fansCount.get();
            int i17 = (int) wVar.c().followCount.get();
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 2) {
                    }
                }
                i16++;
                com.tencent.biz.qqcircle.immersive.personal.data.w wVar2 = new com.tencent.biz.qqcircle.immersive.personal.data.w(wVar.L());
                wVar2.P(i3, i16, i17);
                w20.a.j().initOrUpdateGlobalState((w20.a) wVar2, true);
            }
            if (i16 > 0) {
                i16--;
            }
            com.tencent.biz.qqcircle.immersive.personal.data.w wVar22 = new com.tencent.biz.qqcircle.immersive.personal.data.w(wVar.L());
            wVar22.P(i3, i16, i17);
            w20.a.j().initOrUpdateGlobalState((w20.a) wVar22, true);
        }
    }

    public static void d(String str, int i3) {
        c(str, i3);
        e(i3);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x003c, code lost:
    
        if (r5 != 3) goto L18;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void e(int i3) {
        MutableLiveData globalData = w20.a.j().getGlobalData(com.tencent.biz.qqcircle.immersive.personal.data.w.class, r.q());
        if (globalData != null && globalData.getValue() != 0) {
            com.tencent.biz.qqcircle.immersive.personal.data.w wVar = (com.tencent.biz.qqcircle.immersive.personal.data.w) globalData.getValue();
            int i16 = (int) wVar.c().fansCount.get();
            int i17 = (int) wVar.c().followCount.get();
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 2) {
                    }
                }
                i17++;
                com.tencent.biz.qqcircle.immersive.personal.data.w wVar2 = new com.tencent.biz.qqcircle.immersive.personal.data.w(wVar.L());
                wVar2.P(i3, i16, i17);
                w20.a.j().initOrUpdateGlobalState((w20.a) wVar2, true);
            }
            if (i17 > 0) {
                i17--;
            }
            com.tencent.biz.qqcircle.immersive.personal.data.w wVar22 = new com.tencent.biz.qqcircle.immersive.personal.data.w(wVar.L());
            wVar22.P(i3, i16, i17);
            w20.a.j().initOrUpdateGlobalState((w20.a) wVar22, true);
        }
    }
}
