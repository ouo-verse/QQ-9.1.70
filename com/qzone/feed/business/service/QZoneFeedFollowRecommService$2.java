package com.qzone.feed.business.service;

import NS_MOBILE_FEEDS.opera_infomation;
import android.os.Handler;
import com.qzone.common.business.QZoneBusinessLooper;
import com.qzone.common.business.task.QZoneTask;
import com.qzone.feed.business.protocol.QZoneGetFollowRecommFeedRequest;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.util.j;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes39.dex */
class QZoneFeedFollowRecommService$2 implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ BusinessFeedData f47169d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ int f47170e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ String f47171f;

    /* renamed from: h, reason: collision with root package name */
    final /* synthetic */ Handler f47172h;
    final /* synthetic */ b this$0;

    /* JADX WARN: Removed duplicated region for block: B:25:0x00d3  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        long j3;
        HashMap hashMap;
        String str;
        String str2;
        QZoneGetFollowRecommFeedRequest qZoneGetFollowRecommFeedRequest;
        long j16;
        String str3;
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis < u5.b.I("ranking_feed_time", currentTimeMillis)) {
            j.a("QZoneFeedFollowRecommService", 2, "currentTime < nextReqTime ,return");
            return;
        }
        BusinessFeedData businessFeedData = this.f47169d;
        if (businessFeedData == null) {
            j3 = 0;
            hashMap = null;
            str = null;
            str2 = null;
        } else if (businessFeedData.isForwardFeed()) {
            if (this.f47169d.getOriginalInfo() != null) {
                j16 = this.f47169d.getOriginalInfo().getUser() != null ? this.f47169d.getOriginalInfo().getUser().uin : 0L;
                if (this.f47170e != 1) {
                    if (this.f47169d.getOriginalInfo().getOperationInfoV2() != null) {
                        hashMap = new HashMap();
                        hashMap.putAll(this.f47169d.getOriginalInfo().getOperationInfoV2().busiParam);
                    } else {
                        hashMap = null;
                    }
                    if (this.f47169d.getOriginalInfo().getFeedCommInfoV2() != null) {
                        str3 = this.f47169d.getOriginalInfo().getFeedCommInfoV2().feedskey;
                        str2 = (this.f47170e != 1 || this.f47169d.getCellSummaryV2() == null) ? null : this.f47169d.getCellSummaryV2().summary;
                        long j17 = j16;
                        str = str3;
                        j3 = j17;
                    }
                    str3 = null;
                    if (this.f47170e != 1) {
                    }
                    long j172 = j16;
                    str = str3;
                    j3 = j172;
                }
            } else {
                j16 = 0;
            }
            hashMap = null;
            str3 = null;
            if (this.f47170e != 1) {
            }
            long j1722 = j16;
            str = str3;
            j3 = j1722;
        } else {
            j16 = this.f47169d.getUser() != null ? this.f47169d.getUser().uin : 0L;
            if (this.f47170e != 1) {
                if (this.f47169d.getOperationInfoV2() != null) {
                    hashMap = new HashMap();
                    hashMap.putAll(this.f47169d.getOperationInfoV2().busiParam);
                } else {
                    hashMap = null;
                }
                if (this.f47169d.getFeedCommInfoV2() != null) {
                    str3 = this.f47169d.getFeedCommInfoV2().feedskey;
                    if (this.f47170e != 1) {
                    }
                    long j17222 = j16;
                    str = str3;
                    j3 = j17222;
                }
                str3 = null;
                if (this.f47170e != 1) {
                }
                long j172222 = j16;
                str = str3;
                j3 = j172222;
            }
            hashMap = null;
            str3 = null;
            if (this.f47170e != 1) {
            }
            long j1722222 = j16;
            str = str3;
            j3 = j1722222;
        }
        if (j3 > 0) {
            j.a("QZoneFeedFollowRecommService", 2, "followUin > 0 request , uin :" + j3);
            if (this.f47170e != 1) {
                opera_infomation opera_infomationVar = new opera_infomation();
                opera_infomationVar.busi_param = hashMap;
                opera_infomationVar.strFeedsKey = str;
                String str4 = this.f47171f;
                if (str4 != null) {
                    opera_infomationVar.strOperaData = str4;
                }
                opera_infomationVar.strSummary = str2;
                HashMap hashMap2 = new HashMap();
                hashMap2.put(1, opera_infomationVar.toByteArray());
                qZoneGetFollowRecommFeedRequest = new QZoneGetFollowRecommFeedRequest(j3, this.f47170e, null, hashMap2);
            } else {
                qZoneGetFollowRecommFeedRequest = new QZoneGetFollowRecommFeedRequest(j3, this.f47170e, null, null);
            }
            QZoneTask qZoneTask = new QZoneTask(qZoneGetFollowRecommFeedRequest, this.f47172h, null, 0);
            qZoneTask.addParameter("follow_feed", this.f47169d);
            QZoneBusinessLooper.getInstance().runTask(qZoneTask);
        }
    }
}
