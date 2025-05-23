package bc0;

import com.tencent.biz.qqcircle.immersive.feed.ad.u;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.qphone.base.util.QLog;
import e30.b;
import e30.d;
import feedcloud.FeedCloudMeta$AdvertClientInfo;
import feedcloud.FeedCloudMeta$AdvertItem;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import uq3.c;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a {

    /* renamed from: c, reason: collision with root package name */
    private static volatile a f28241c;

    /* renamed from: a, reason: collision with root package name */
    private final List<b> f28242a = new CopyOnWriteArrayList();

    /* renamed from: b, reason: collision with root package name */
    private boolean f28243b = false;

    public static a g() {
        if (f28241c == null) {
            synchronized (a.class) {
                if (f28241c == null) {
                    f28241c = new a();
                }
            }
        }
        return f28241c;
    }

    public void a(List<FeedCloudMeta$StFeed> list) {
        if (list != null && !list.isEmpty()) {
            this.f28242a.addAll(d.b(list));
            QLog.d("QFSEdgeAdLoadBackupManager", 1, "adload feeds size: " + list.size());
        }
    }

    public void b() {
        this.f28242a.clear();
    }

    public boolean c() {
        return this.f28243b;
    }

    public FeedCloudMeta$AdvertClientInfo d(List<b> list) {
        boolean z16;
        FeedCloudMeta$AdvertClientInfo feedCloudMeta$AdvertClientInfo = new FeedCloudMeta$AdvertClientInfo();
        List<Integer> f16 = f(list);
        boolean z17 = true;
        if (f16.size() > 0) {
            feedCloudMeta$AdvertClientInfo.advert_expose_position.addAll(f16);
            z16 = true;
        } else {
            z16 = false;
        }
        List<FeedCloudMeta$AdvertItem> e16 = e();
        if (e16 != null && e16.size() > 0) {
            feedCloudMeta$AdvertClientInfo.items.addAll(e16);
        } else {
            z17 = z16;
        }
        if (z17) {
            return feedCloudMeta$AdvertClientInfo;
        }
        return null;
    }

    public List<FeedCloudMeta$AdvertItem> e() {
        ArrayList arrayList = new ArrayList();
        if (this.f28242a.isEmpty()) {
            return arrayList;
        }
        for (b bVar : this.f28242a) {
            FeedCloudMeta$AdvertItem feedCloudMeta$AdvertItem = new FeedCloudMeta$AdvertItem();
            feedCloudMeta$AdvertItem.f398437id.set(new GdtAd(u.e(bVar)).getAId());
            feedCloudMeta$AdvertItem.feed_id.set(bVar.g().f398449id.get());
            feedCloudMeta$AdvertItem.transfer.set(bVar.g().recomInfo.clientSealData.get());
            arrayList.add(feedCloudMeta$AdvertItem);
        }
        return arrayList;
    }

    public List<Integer> f(List<b> list) {
        int i3;
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            ArrayList arrayList2 = new ArrayList(list);
            int size = arrayList2.size();
            if (size > 10) {
                i3 = size - 10;
            } else {
                i3 = 0;
            }
            while (i3 < size) {
                b bVar = (b) arrayList2.get(i3);
                if (bVar.g() != null) {
                    if (bVar.g().feedType.get() == 4) {
                        arrayList.add(1);
                    } else {
                        arrayList.add(0);
                    }
                }
                i3++;
            }
        }
        return arrayList;
    }

    public List<b> h() {
        return this.f28242a;
    }

    public boolean i(List<b> list) {
        if (!c.B() || !g().c()) {
            return true;
        }
        if (list != null && !list.isEmpty()) {
            int i3 = 0;
            int i16 = 0;
            for (b bVar : list) {
                if (bVar != null && bVar.g().iscachedAdsFeeds.get()) {
                    i3++;
                    for (b bVar2 : this.f28242a) {
                        if (bVar2 != null && bVar.g().f398449id.get().equals(bVar2.g().f398449id.get())) {
                            QLog.d("QFSEdgeAdLoadBackupManager", 1, "reRankResultFeed is in the adLoad pool. id: " + bVar.g().f398449id.get());
                            i16++;
                        }
                    }
                }
            }
            if (i3 == 0) {
                return true;
            }
            QLog.d("QFSEdgeAdLoadBackupManager", 1, "adLoadAdsFeedsCnt: " + i3 + ", hitCnt: " + i16);
            if (i3 == i16) {
                return true;
            }
            return false;
        }
        QLog.d("QFSEdgeAdLoadBackupManager", 1, "reRankResultFeeds empty");
        return false;
    }

    public void j(List<b> list) {
        if (list != null && !this.f28242a.isEmpty() && !list.isEmpty()) {
            for (b bVar : this.f28242a) {
                for (b bVar2 : list) {
                    if (bVar != null && bVar2 != null && bVar.g().f398449id.get().equals(bVar2.g().f398449id.get())) {
                        this.f28242a.remove(bVar);
                    }
                }
            }
        }
    }

    public void k(boolean z16) {
        this.f28243b = z16;
    }
}
