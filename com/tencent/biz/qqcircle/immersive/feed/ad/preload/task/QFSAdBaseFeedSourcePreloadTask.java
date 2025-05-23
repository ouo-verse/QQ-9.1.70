package com.tencent.biz.qqcircle.immersive.feed.ad.preload.task;

import android.text.TextUtils;
import androidx.lifecycle.Observer;
import com.tencent.biz.qqcircle.immersive.feed.ad.preload.model.a;
import com.tencent.biz.qqcircle.immersive.feed.ad.preload.task.a;
import com.tencent.biz.qqcircle.immersive.layer.biz.inside.tab.QFSTabFeedViewModel;
import com.tencent.biz.qqcircle.utils.bj;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.part.utils.RFSafeListUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes4.dex */
public abstract class QFSAdBaseFeedSourcePreloadTask implements a {

    /* renamed from: a, reason: collision with root package name */
    private QFSTabFeedViewModel.c f85750a;

    /* renamed from: b, reason: collision with root package name */
    private a.InterfaceC0880a f85751b;

    /* renamed from: c, reason: collision with root package name */
    private int f85752c = -1;

    /* renamed from: d, reason: collision with root package name */
    private String f85753d = "";

    /* renamed from: e, reason: collision with root package name */
    private final Map<String, Set<String>> f85754e = new ConcurrentHashMap();

    /* renamed from: f, reason: collision with root package name */
    private com.tencent.biz.qqcircle.immersive.feed.ad.preload.model.a f85755f;

    /* renamed from: g, reason: collision with root package name */
    private long f85756g;

    /* loaded from: classes4.dex */
    public enum QFSAdPreloadTriggerType {
        PAGE_RESUME,
        POSITION_CHANGE
    }

    public QFSAdBaseFeedSourcePreloadTask() {
        com.tencent.biz.qqcircle.immersive.feed.ad.preload.model.a aVar = new com.tencent.biz.qqcircle.immersive.feed.ad.preload.model.a();
        this.f85755f = aVar;
        aVar.h().observeForever(new Observer() { // from class: com.tencent.biz.qqcircle.immersive.feed.ad.preload.task.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QFSAdBaseFeedSourcePreloadTask.this.p((a.C0879a) obj);
            }
        });
    }

    private void f(e30.b bVar) {
        if (this.f85753d == null || bVar == null || !m(bVar.g())) {
            return;
        }
        Set<String> set = this.f85754e.get(this.f85753d);
        if (set == null) {
            set = new HashSet<>();
            this.f85754e.put(this.f85753d, set);
        }
        set.add(bj.g(bVar));
    }

    private List<e30.b> h() {
        QFSTabFeedViewModel.c cVar = this.f85750a;
        if (cVar == null) {
            return null;
        }
        return cVar.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public void p(a.C0879a c0879a) {
        if (c0879a == null) {
            RFWLog.d("QASP-QFSAdBaseFeedSourcePreloadTask", RFWLog.USR, "[handlerFeedSourceChange] result should not be null.");
        } else if (c0879a.a() == 0 && TextUtils.isEmpty(c0879a.b())) {
            r(c0879a.c(), c0879a.d(), c0879a.e());
        } else {
            q(c0879a.a(), c0879a.b(), c0879a.e());
        }
    }

    private boolean l(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (TextUtils.isEmpty(this.f85753d)) {
            return false;
        }
        String g16 = bj.g(feedCloudMeta$StFeed);
        Set<String> set = this.f85754e.get(this.f85753d);
        if (set == null || !set.contains(g16)) {
            return false;
        }
        return true;
    }

    private boolean m(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed != null && feedCloudMeta$StFeed.feedType.get() == 4) {
            return true;
        }
        return false;
    }

    private boolean o(e30.b bVar) {
        if (bVar == null) {
            return false;
        }
        FeedCloudMeta$StFeed g16 = bVar.g();
        if (!m(g16) || l(g16) || bVar.j() || !k(g16)) {
            return false;
        }
        return true;
    }

    private e30.b t(int i3) {
        return (e30.b) RFSafeListUtils.get(h(), i3);
    }

    private long x() {
        try {
            return Integer.parseInt(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("qcircle_config_ad_replace_req_min_interval", String.valueOf(3000)));
        } catch (Exception unused) {
            return 3000L;
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.ad.preload.task.a
    public void a(QFSTabFeedViewModel.c cVar) {
        this.f85750a = cVar;
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.ad.preload.task.a
    public void b(String str) {
        this.f85753d = str;
        w(QFSAdPreloadTriggerType.PAGE_RESUME);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.ad.preload.task.a
    public void c(int i3) {
        this.f85752c = i3;
        f(t(i3));
        w(QFSAdPreloadTriggerType.POSITION_CHANGE);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.ad.preload.task.a
    public void d(a.InterfaceC0880a interfaceC0880a) {
        this.f85751b = interfaceC0880a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int g() {
        return this.f85752c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public QFSTabFeedViewModel.c i() {
        return this.f85750a;
    }

    protected abstract boolean k(FeedCloudMeta$StFeed feedCloudMeta$StFeed);

    protected abstract boolean n(QFSAdPreloadTriggerType qFSAdPreloadTriggerType);

    protected void q(long j3, String str, String str2) {
        a.InterfaceC0880a interfaceC0880a = this.f85751b;
        if (interfaceC0880a == null) {
            return;
        }
        interfaceC0880a.a(j3, str, str2);
    }

    protected void r(List<e30.b> list, List<e30.b> list2, String str) {
        a.InterfaceC0880a interfaceC0880a = this.f85751b;
        if (interfaceC0880a == null) {
            return;
        }
        interfaceC0880a.c(list, list2, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int s() {
        List<e30.b> a16;
        QFSTabFeedViewModel.c cVar = this.f85750a;
        if (cVar != null && (a16 = cVar.a()) != null && !a16.isEmpty()) {
            int size = a16.size();
            for (int i3 = this.f85752c; i3 < size; i3++) {
                if (o((e30.b) RFSafeListUtils.get(a16, i3))) {
                    return i3;
                }
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public List<e30.b> u() {
        ArrayList arrayList = new ArrayList();
        List<e30.b> h16 = h();
        if (h16 != null && !h16.isEmpty()) {
            int size = h16.size();
            for (int i3 = this.f85752c; i3 < size; i3++) {
                e30.b bVar = (e30.b) RFSafeListUtils.get(h16, i3);
                if (o(bVar)) {
                    arrayList.add(bVar);
                }
            }
            RFWLog.d("QASP-QFSAdBaseFeedSourcePreloadTask", RFWLog.USR, "[obtainUnExposedAdFeedSource] source size: " + size + " | un export ad feed size: " + arrayList.size());
        }
        return arrayList;
    }

    protected void v(QFSAdPreloadTriggerType qFSAdPreloadTriggerType) {
        int size;
        List<e30.b> u16 = u();
        int i3 = RFWLog.USR;
        Object[] objArr = new Object[1];
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[preloadAdFeedRequest] preload ad feed feed request, size: ");
        if (u16 == null) {
            size = 0;
        } else {
            size = u16.size();
        }
        sb5.append(size);
        sb5.append(" | triggerType: ");
        sb5.append(qFSAdPreloadTriggerType);
        objArr[0] = sb5.toString();
        RFWLog.d("QASP-QFSAdBaseFeedSourcePreloadTask", i3, objArr);
        this.f85755f.l(u16);
    }

    protected void w(QFSAdPreloadTriggerType qFSAdPreloadTriggerType) {
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - this.f85756g) < x() || !n(qFSAdPreloadTriggerType)) {
            return;
        }
        this.f85756g = currentTimeMillis;
        v(qFSAdPreloadTriggerType);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.ad.preload.task.a
    public void release() {
    }
}
