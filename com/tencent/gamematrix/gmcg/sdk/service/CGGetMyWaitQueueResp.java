package com.tencent.gamematrix.gmcg.sdk.service;

import com.tencent.gamematrix.gmcg.api.model.GmCgPlayQueueInfo;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes6.dex */
public class CGGetMyWaitQueueResp {
    public List<QueueInfo> data;

    /* renamed from: msg, reason: collision with root package name */
    public String f107895msg;
    public int ret;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class QueueInfo {
        public String bizInfo;
        public int realWaitPos;
        public String tag;
        public boolean tiyanVip;
        public boolean vip;
        public String waitid;
        public int waitnum;
        public int waitpos;
        public int waitsec;
    }

    public List<GmCgPlayQueueInfo> toGmCgPlayQueueInfo() {
        ArrayList arrayList = new ArrayList();
        List<QueueInfo> list = this.data;
        if (list != null) {
            for (QueueInfo queueInfo : list) {
                GmCgPlayQueueInfo gmCgPlayQueueInfo = new GmCgPlayQueueInfo();
                gmCgPlayQueueInfo.pGameTag = queueInfo.tag;
                gmCgPlayQueueInfo.pWaitId = queueInfo.waitid;
                gmCgPlayQueueInfo.pWaitNum = queueInfo.waitnum;
                gmCgPlayQueueInfo.pWaitPos = queueInfo.waitpos;
                gmCgPlayQueueInfo.pWaitSec = queueInfo.waitsec;
                gmCgPlayQueueInfo.pBizInfo = queueInfo.bizInfo;
                gmCgPlayQueueInfo.pIdentityProfType = CGServiceUtil.getIdentityProfileType(queueInfo.vip, queueInfo.tiyanVip);
                gmCgPlayQueueInfo.pRealWaitPos = queueInfo.realWaitPos;
                gmCgPlayQueueInfo.pWaitCanceled = false;
                arrayList.add(gmCgPlayQueueInfo);
            }
        }
        return arrayList;
    }
}
