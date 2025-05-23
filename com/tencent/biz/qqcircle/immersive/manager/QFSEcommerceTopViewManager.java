package com.tencent.biz.qqcircle.immersive.manager;

import com.tencent.biz.qqcircle.immersive.adapter.n;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.qcircle.api.event.QFSTopViewRedEvent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StVideo;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSEcommerceTopViewManager {

    /* renamed from: c, reason: collision with root package name */
    private static QFSEcommerceTopViewManager f87195c;

    /* renamed from: a, reason: collision with root package name */
    private CopyOnWriteArraySet<String> f87196a = new CopyOnWriteArraySet<>();

    /* renamed from: b, reason: collision with root package name */
    private CopyOnWriteArraySet<String> f87197b = new CopyOnWriteArraySet<>();

    QFSEcommerceTopViewManager() {
    }

    public static QFSEcommerceTopViewManager b() {
        if (f87195c == null) {
            synchronized (QFSEcommerceTopViewManager.class) {
                if (f87195c == null) {
                    f87195c = new QFSEcommerceTopViewManager();
                }
            }
        }
        return f87195c;
    }

    public boolean c() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f87197b);
        arrayList.removeAll(this.f87196a);
        if (arrayList.size() > 0) {
            return true;
        }
        return false;
    }

    public boolean d(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed != null && this.f87196a.contains(feedCloudMeta$StFeed.f398449id.get())) {
            return true;
        }
        return false;
    }

    public boolean e(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed != null && feedCloudMeta$StFeed.video != null && f(feedCloudMeta$StFeed)) {
            return this.f87197b.contains(feedCloudMeta$StFeed.f398449id.get());
        }
        return false;
    }

    public boolean f(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        FeedCloudMeta$StVideo feedCloudMeta$StVideo;
        if (feedCloudMeta$StFeed == null || (feedCloudMeta$StVideo = feedCloudMeta$StFeed.video) == null || feedCloudMeta$StVideo.height.get() <= 0) {
            return false;
        }
        if (feedCloudMeta$StFeed.video.width.get() > feedCloudMeta$StFeed.video.height.get() && feedCloudMeta$StFeed.video.orientation.get() != 1) {
            return false;
        }
        return true;
    }

    public void g(final FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        RFWThreadManager.getInstance().getSerialThreadHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.manager.QFSEcommerceTopViewManager.1
            @Override // java.lang.Runnable
            public void run() {
                FeedCloudMeta$StFeed feedCloudMeta$StFeed2 = feedCloudMeta$StFeed;
                if (feedCloudMeta$StFeed2 != null && feedCloudMeta$StFeed2.video != null && n.k(feedCloudMeta$StFeed2) && !QFSEcommerceTopViewManager.this.f87197b.contains(feedCloudMeta$StFeed.f398449id.get())) {
                    QFSEcommerceTopViewManager.this.f87197b.add(feedCloudMeta$StFeed.f398449id.get());
                    QLog.d("QFSEcommerceTopViewManager", 1, "onColdBootVideoPreload id = " + feedCloudMeta$StFeed.f398449id.get() + " vid= " + feedCloudMeta$StFeed.video.fileId.get());
                    SimpleEventBus.getInstance().dispatchEvent(new QFSTopViewRedEvent());
                }
            }
        });
    }

    public void h(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        this.f87196a.add(feedCloudMeta$StFeed.f398449id.get());
    }
}
