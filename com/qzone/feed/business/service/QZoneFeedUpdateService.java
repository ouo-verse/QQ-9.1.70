package com.qzone.feed.business.service;

import NS_MOBILE_FEEDS.mobile_feeds_rsp;
import NS_MOBILE_FEEDS.mobile_single_feeds_rsp;
import NS_MOBILE_FEEDS.single_feed;
import android.os.Handler;
import com.qzone.common.business.IQZoneServiceListener;
import com.qzone.common.business.QZoneBusinessLooper;
import com.qzone.common.business.task.QZoneTask;
import com.qzone.common.protocol.request.QZoneRequest;
import com.qzone.feed.business.protocol.QzoneQueryFeedUpdateRequest;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.service.FeedIncrementalUpdateService;
import com.tencent.ditto.shell.DittoUIEngine;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.util.WiFiDash;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneFeedUpdateService implements IQZoneServiceListener {

    /* renamed from: f, reason: collision with root package name */
    private static volatile QZoneFeedUpdateService f47193f;

    /* renamed from: h, reason: collision with root package name */
    private static final byte[] f47194h = new byte[0];

    /* renamed from: e, reason: collision with root package name */
    private Runnable f47196e = new Runnable() { // from class: com.qzone.feed.business.service.QZoneFeedUpdateService.1
        @Override // java.lang.Runnable
        public void run() {
            QZoneFeedUpdateService.this.g();
        }
    };

    /* renamed from: d, reason: collision with root package name */
    private Handler f47195d = QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BackGroundThread).getHandler();

    QZoneFeedUpdateService() {
    }

    public static QZoneFeedUpdateService c() {
        if (f47193f == null) {
            synchronized (f47194h) {
                if (f47193f == null) {
                    f47193f = new QZoneFeedUpdateService();
                }
            }
        }
        return f47193f;
    }

    private void h(long j3) {
        QZLog.i("FeedUpdate", "next heartbeat time:" + j3);
        this.f47195d.removeCallbacks(this.f47196e);
        if (j3 > 0) {
            this.f47195d.postDelayed(this.f47196e, j3 * 1000);
        }
    }

    public void d(QZoneTask qZoneTask) {
        mobile_single_feeds_rsp mobile_single_feeds_rspVar;
        if (!qZoneTask.succeeded() || (mobile_single_feeds_rspVar = (mobile_single_feeds_rsp) qZoneTask.mRequest.rsp) == null) {
            return;
        }
        ArrayList<single_feed> arrayList = mobile_single_feeds_rspVar.all_feeds_data;
        if (arrayList != null && arrayList.size() > 0) {
            FeedIncrementalUpdateService.d().f(mobile_single_feeds_rspVar.all_feeds_data);
        }
        h(mobile_single_feeds_rspVar.next_keep_alive_time);
    }

    public void e(QZoneTask qZoneTask) {
        mobile_single_feeds_rsp mobile_single_feeds_rspVar;
        h((!qZoneTask.succeeded() || (mobile_single_feeds_rspVar = (mobile_single_feeds_rsp) qZoneTask.mRequest.rsp) == null) ? 1740L : mobile_single_feeds_rspVar.next_keep_alive_time);
    }

    public void f(QZoneTask qZoneTask) {
        Object obj;
        QZoneRequest qZoneRequest;
        int i3;
        Map<String, String> map;
        if (qZoneTask != null && qZoneTask.succeeded() && (qZoneRequest = qZoneTask.mRequest) != null) {
            mobile_feeds_rsp mobile_feeds_rspVar = (mobile_feeds_rsp) qZoneRequest.rsp;
            if (mobile_feeds_rspVar == null || (map = mobile_feeds_rspVar.kitfileData) == null || map.size() <= 0) {
                i3 = 0;
            } else {
                i3 = mobile_feeds_rspVar.kitfileData.size();
                DittoUIEngine.g().updateLayoutFile(mobile_feeds_rspVar.kitfileData);
            }
            QZLog.i("FeedUpdate", "Ditto\u70ed\u66f4\u65b0 succ. \u66f4\u65b0\u4e2a\u6570:" + i3);
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("Ditto\u70ed\u66f4\u65b0 failed. retCode:");
        if (qZoneTask != null) {
            obj = Integer.valueOf(qZoneTask.mResultCode);
        } else {
            obj = WiFiDash.NOT_AVALIBLE;
        }
        sb5.append(obj);
        QZLog.i("FeedUpdate", sb5.toString());
    }

    public void g() {
        QZoneBusinessLooper.getInstance().runTask(new QZoneTask(new QzoneQueryFeedUpdateRequest(null, 2), null, this, 2));
    }

    @Override // com.qzone.common.business.IQZoneServiceListener
    public void onTaskResponse(QZoneTask qZoneTask) {
        int i3 = qZoneTask.mType;
        if (i3 == 1) {
            d(qZoneTask);
        } else if (i3 == 2) {
            e(qZoneTask);
        } else {
            if (i3 != 3) {
                return;
            }
            f(qZoneTask);
        }
    }

    public void a(List<BusinessFeedData> list) {
        if (list != null) {
            Iterator<BusinessFeedData> it = list.iterator();
            String str = "";
            while (it.hasNext()) {
                str = str + it.next().getFeedCommInfo().ugckey + " ";
            }
            QZLog.i("FeedUpdate", "query feed all info:" + str);
        }
        QZoneBusinessLooper.getInstance().runTask(new QZoneTask(new QzoneQueryFeedUpdateRequest(list, 1, true), null, this, 1));
    }

    public void b(List<BusinessFeedData> list) {
        if (list != null) {
            Iterator<BusinessFeedData> it = list.iterator();
            String str = "";
            while (it.hasNext()) {
                str = str + it.next().getFeedCommInfo().ugckey + " ";
            }
            QZLog.i("FeedUpdate", "query feed:" + str);
        }
        QZoneBusinessLooper.getInstance().runTask(new QZoneTask(new QzoneQueryFeedUpdateRequest(list, 1), null, this, 1));
    }
}
