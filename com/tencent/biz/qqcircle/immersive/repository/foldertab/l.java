package com.tencent.biz.qqcircle.immersive.repository.foldertab;

import android.text.TextUtils;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.beans.QCircleTabInfo;
import com.tencent.biz.qqcircle.events.QCircleTabPageFeedUpdateEvent;
import com.tencent.biz.qqcircle.immersive.layer.biz.inside.tab.QFSTabFeedViewModel;
import com.tencent.biz.qqcircle.immersive.utils.y;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import common.config.service.QzoneConfig;
import feedcloud.FeedCloudCommon$Entry;
import feedcloud.FeedCloudCommon$RecomReed;
import feedcloud.FeedCloudCommon$StCommonExt;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes4.dex */
public abstract class l implements p60.b {

    /* renamed from: a, reason: collision with root package name */
    protected final QFSTabFeedViewModel f89800a;

    /* renamed from: b, reason: collision with root package name */
    protected p60.a f89801b;

    /* renamed from: c, reason: collision with root package name */
    private byte[] f89802c;

    /* renamed from: d, reason: collision with root package name */
    private PBRepeatMessageField<FeedCloudCommon$Entry> f89803d;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public int f89804a;

        /* renamed from: b, reason: collision with root package name */
        public int f89805b;

        /* renamed from: c, reason: collision with root package name */
        public int f89806c = -1;

        /* renamed from: d, reason: collision with root package name */
        public int f89807d = -1;

        /* renamed from: e, reason: collision with root package name */
        public List<e30.b> f89808e;

        public String toString() {
            int size;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("InsertPosInfo{curExposeIndex=");
            sb5.append(this.f89804a);
            sb5.append(", lastExposeFeedIndex=");
            sb5.append(this.f89805b);
            sb5.append(", insertIndex=");
            sb5.append(this.f89806c);
            sb5.append(", needKeepFeedSize=");
            sb5.append(this.f89807d);
            sb5.append(", needKeepUnExposeFeedList=");
            List<e30.b> list = this.f89808e;
            if (list == null) {
                size = 0;
            } else {
                size = list.size();
            }
            sb5.append(size);
            sb5.append('}');
            return sb5.toString();
        }
    }

    public l(@NonNull QFSTabFeedViewModel qFSTabFeedViewModel) {
        this.f89800a = qFSTabFeedViewModel;
    }

    private int n() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_can_repeat_expose_feed_safe_distance", 8);
    }

    private boolean u(@NonNull e30.b bVar, @NonNull List<e30.b> list) {
        int size = list.size() - 1;
        int i3 = 0;
        for (int i16 = size; i16 >= 0; i16--) {
            e30.b bVar2 = list.get(i16);
            i3++;
            if (bVar2 != null) {
                String str = bVar2.g().f398449id.get();
                if (TextUtils.equals(str, bVar.g().f398449id.get())) {
                    QLog.d(l(), 1, "lastExposeOnSafeRange feed :" + str + ", lastExpose pos = " + size);
                    return false;
                }
                if (i3 >= n()) {
                    break;
                }
            }
        }
        return true;
    }

    private void z(UIStateData<List<e30.b>> uIStateData) {
        if (uIStateData != null && uIStateData.getData() != null) {
            SimpleEventBus.getInstance().dispatchEvent(new QCircleTabPageFeedUpdateEvent(uIStateData.getData()));
        }
    }

    public void A(long j3) {
        this.f89800a.w3(j3);
    }

    public void B(PBRepeatMessageField<FeedCloudCommon$Entry> pBRepeatMessageField) {
        this.f89803d = pBRepeatMessageField;
    }

    public void C(byte[] bArr) {
        this.f89802c = bArr;
    }

    public void D(long j3) {
        this.f89800a.G3(j3);
    }

    @Override // p60.b
    public QCircleTabInfo G() {
        return this.f89800a.w2();
    }

    @Override // p60.b
    public void a(@NonNull UIStateData<List<e30.b>> uIStateData) {
        z(uIStateData);
        this.f89800a.d3(uIStateData);
    }

    @Override // p60.b
    public void b(String str) {
        this.f89800a.v3(str);
    }

    @Override // p60.b
    public void c(@NonNull QFSTabFeedViewModel.c cVar) {
        this.f89800a.e3(cVar);
    }

    @Override // p60.b
    public MutableLiveData<QFSTabFeedViewModel.c> d() {
        return this.f89800a.v2();
    }

    @MainThread
    public boolean f(List<e30.b> list, @NonNull List<e30.b> list2, boolean z16) {
        if (j() == null) {
            return false;
        }
        int size = list.size();
        Iterator<e30.b> it = list.iterator();
        boolean z17 = false;
        while (it.hasNext()) {
            e30.b next = it.next();
            if (next != null) {
                if (!z16 && !y.h(next)) {
                    if (!u(next, new ArrayList(list2))) {
                        QLog.e(l(), 1, "remove cannot filter feed:" + next.g().f398449id.get());
                        it.remove();
                        z17 = true;
                    } else {
                        QLog.d(l(), 2, "find a can repeat feed");
                    }
                } else if (j().c(next)) {
                    it.remove();
                    z17 = true;
                }
            }
        }
        if (z17) {
            QLog.d(l(), 1, "filterExposeFeed,filter before size:", Integer.valueOf(size), ",after size:", Integer.valueOf(list.size()));
        }
        return z17;
    }

    public a g(@NonNull List<e30.b> list) {
        int i3;
        if (j() != null && j().b() != null) {
            int indexOf = list.indexOf(j().b());
            if (indexOf < 0) {
                QLog.e(l(), 1, "findInsertIndex error,can't find current expose index!");
                if (ab0.a.a(j().a(), list)) {
                    return null;
                }
                indexOf = j().a();
            }
            int size = list.size();
            int i16 = indexOf + 1;
            while (true) {
                if (i16 < size) {
                    e30.b bVar = list.get(i16);
                    if (bVar != null && !j().c(bVar)) {
                        i3 = list.indexOf(bVar);
                        break;
                    }
                    i16++;
                } else {
                    i3 = -1;
                    break;
                }
            }
            if (i3 < 0) {
                QLog.e(l(), 1, "findInsertIndex done,can't find proper insert index!");
                return null;
            }
            int e16 = e(i3, indexOf);
            QLog.d(l(), 1, "findInsertIndex done,insert index:", Integer.valueOf(e16));
            a aVar = new a();
            aVar.f89804a = indexOf;
            aVar.f89805b = i3 - 1;
            aVar.f89806c = e16;
            aVar.f89807d = Math.min(e16, size);
            ArrayList arrayList = new ArrayList();
            for (int i17 = aVar.f89805b + 1; i17 < aVar.f89807d; i17++) {
                e30.b bVar2 = list.get(i17);
                if (bVar2 != null) {
                    arrayList.add(bVar2);
                }
            }
            aVar.f89808e = arrayList;
            return aVar;
        }
        QLog.e(l(), 1, "findInsertIndex error,has not inject scroller!");
        return null;
    }

    public e30.b h() {
        p60.a j3 = j();
        if (j3 == null) {
            return null;
        }
        return j3.b();
    }

    public List<e30.b> i() {
        MutableLiveData<QFSTabFeedViewModel.c> d16 = d();
        if (d16 != null && d16.getValue() != null) {
            return q(d16.getValue().f86642a);
        }
        return new ArrayList();
    }

    public p60.a j() {
        return this.f89801b;
    }

    public List<FeedCloudCommon$RecomReed> k() {
        return this.f89800a.s2();
    }

    public abstract String l();

    @MainThread
    @Nullable
    public List<e30.b> m(@NonNull List<e30.b> list) {
        a g16 = g(list);
        if (g16 == null) {
            QLog.e(l(), 1, "getRemainFeeds error, insertPosInfo is null!");
            return null;
        }
        int i3 = g16.f89806c;
        if (i3 < 0) {
            QLog.e(l(), 1, "getRemainFeeds error,can't find insert index!");
            return null;
        }
        int min = Math.min(i3, list.size());
        ArrayList arrayList = new ArrayList(list.subList(0, min));
        QLog.d("FDC-" + l(), 1, "getRemainFeeds insertIndex:" + min + ",cur feeds size:", list.size() + ",remain feeds size:" + arrayList.size());
        return arrayList;
    }

    public FeedCloudCommon$StCommonExt o(boolean z16) {
        return this.f89800a.getSession(z16);
    }

    public PBRepeatMessageField<FeedCloudCommon$Entry> p() {
        return this.f89803d;
    }

    @androidx.annotation.Nullable
    protected List<e30.b> q(List<e30.b> list) {
        if (j() != null && list != null && !list.isEmpty()) {
            int a16 = j().a();
            ArrayList arrayList = new ArrayList();
            int size = list.size();
            while (true) {
                a16++;
                if (a16 < size) {
                    e30.b bVar = list.get(a16);
                    if (bVar != null && !j().c(bVar)) {
                        arrayList.add(bVar);
                    }
                } else {
                    return arrayList;
                }
            }
        } else {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @androidx.annotation.Nullable
    public List<FeedCloudMeta$StFeed> r(List<e30.b> list) {
        List<e30.b> q16 = q(list);
        if (q16 != null && !q16.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (e30.b bVar : q16) {
                if (bVar != null) {
                    arrayList.add(bVar.g());
                }
            }
            return arrayList;
        }
        return new ArrayList();
    }

    public byte[] s() {
        return this.f89802c;
    }

    public void t(p60.a aVar) {
        this.f89801b = aVar;
    }

    public void w() {
        QLog.d(l(), 1, "onEnterQCircleFrame");
    }

    public void x() {
        QLog.d(l(), 1, "onExitQCircleFrame");
    }

    public void y(List<e30.b> list) {
        this.f89800a.g3(list);
    }

    public void v() {
    }

    protected int e(int i3, int i16) {
        return i3;
    }
}
