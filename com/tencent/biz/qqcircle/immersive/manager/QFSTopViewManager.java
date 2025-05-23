package com.tencent.biz.qqcircle.immersive.manager;

import com.tencent.biz.qqcircle.immersive.feed.ad.u;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.qcircle.api.event.QFSTopViewRedEvent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSTopViewManager {

    /* renamed from: f, reason: collision with root package name */
    private static QFSTopViewManager f87199f;

    /* renamed from: b, reason: collision with root package name */
    private GdtAd f87201b;

    /* renamed from: a, reason: collision with root package name */
    private boolean f87200a = false;

    /* renamed from: c, reason: collision with root package name */
    private CopyOnWriteArraySet<String> f87202c = new CopyOnWriteArraySet<>();

    /* renamed from: d, reason: collision with root package name */
    private CopyOnWriteArraySet<String> f87203d = new CopyOnWriteArraySet<>();

    /* renamed from: e, reason: collision with root package name */
    private CopyOnWriteArraySet<String> f87204e = new CopyOnWriteArraySet<>();

    QFSTopViewManager() {
    }

    public static QFSTopViewManager e() {
        if (f87199f == null) {
            synchronized (QFSTopViewManager.class) {
                if (f87199f == null) {
                    f87199f = new QFSTopViewManager();
                }
            }
        }
        return f87199f;
    }

    public static boolean h(qq_ad_get.QQAdGetRsp.AdInfo adInfo) {
        if ((adInfo != null && adInfo.display_info.inner_adshowtype.get() == 42) || i(adInfo)) {
            return true;
        }
        return false;
    }

    public static boolean i(qq_ad_get.QQAdGetRsp.AdInfo adInfo) {
        if (adInfo != null && adInfo.display_info.inner_adshowtype.get() == 48) {
            return true;
        }
        return false;
    }

    public String d(qq_ad_get.QQAdGetRsp.AdInfo adInfo) {
        String str;
        if (i(adInfo)) {
            str = "\u6447\u52a8\u6216\u70b9\u51fb\u4e86\u89e3\u66f4\u591a";
        } else {
            str = "\u53bb\u770b\u770b";
        }
        return com.tencent.biz.qqcircle.immersive.utils.ad.a.f90082a.m(adInfo, str);
    }

    public boolean f() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f87203d);
        arrayList.removeAll(this.f87202c);
        if (arrayList.size() > 0) {
            return true;
        }
        return false;
    }

    public boolean g(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed != null && this.f87202c.contains(feedCloudMeta$StFeed.f398449id.get())) {
            return true;
        }
        return false;
    }

    public boolean j(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed != null && feedCloudMeta$StFeed.video != null) {
            return this.f87203d.contains(feedCloudMeta$StFeed.f398449id.get());
        }
        return false;
    }

    public void k(final FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        RFWThreadManager.getInstance().getSerialThreadHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.manager.QFSTopViewManager.1
            @Override // java.lang.Runnable
            public void run() {
                FeedCloudMeta$StFeed feedCloudMeta$StFeed2 = feedCloudMeta$StFeed;
                if (feedCloudMeta$StFeed2 != null && feedCloudMeta$StFeed2.video != null) {
                    e30.b bVar = new e30.b(feedCloudMeta$StFeed2);
                    bVar.p();
                    qq_ad_get.QQAdGetRsp.AdInfo e16 = u.e(bVar);
                    if (!QFSTopViewManager.h(e16) || QFSTopViewManager.this.f87203d.contains(feedCloudMeta$StFeed.f398449id.get())) {
                        QFSTopViewManager.this.f87200a = false;
                        return;
                    }
                    QFSTopViewManager.this.f87203d.add(feedCloudMeta$StFeed.f398449id.get());
                    QFSTopViewManager.this.f87200a = true;
                    QFSTopViewManager.this.f87201b = new GdtAd(e16);
                    QLog.d("QFSTopViewManager", 1, "onColdBootVideoPreload id = " + feedCloudMeta$StFeed.f398449id.get() + " vid= " + feedCloudMeta$StFeed.video.fileId.get());
                    SimpleEventBus.getInstance().dispatchEvent(new QFSTopViewRedEvent());
                }
            }
        });
    }

    public void l(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        this.f87202c.add(feedCloudMeta$StFeed.f398449id.get());
    }

    public void m() {
        GdtAd gdtAd;
        if (this.f87200a && (gdtAd = this.f87201b) != null && gdtAd.isValid()) {
            com.tencent.biz.qqcircle.immersive.utils.d.f90201a.f(this.f87201b, 1, 0);
        }
    }
}
