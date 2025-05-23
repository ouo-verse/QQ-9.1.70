package cc0;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.immersive.layer.biz.inside.tab.QFSTabFeedViewModel;
import com.tencent.biz.qqcircle.immersive.repository.foldertab.l;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.tedger.outapi.beans.EdgeItem;
import hc0.r;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes5.dex */
public class g extends l {

    /* renamed from: e, reason: collision with root package name */
    private long f30635e;

    /* renamed from: f, reason: collision with root package name */
    private com.tencent.biz.qqcircle.immersive.repository.foldertab.f f30636f;

    /* renamed from: g, reason: collision with root package name */
    private final d f30637g;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class a implements r.a {
        a() {
        }

        @Override // hc0.r.a
        public List<e30.b> a() {
            g.this.f30635e = System.currentTimeMillis();
            com.tencent.biz.qqcircle.immersive.repository.foldertab.f O = g.this.O();
            g.this.f30636f = O;
            if (O != null && !O.f89780b.isEmpty()) {
                l.a a16 = O.a();
                if (a16 != null) {
                    g.this.f30637g.L(a16);
                }
                return O.f89780b;
            }
            QLog.e("FeedLine_TEdgeRS_QFSTabEdgeRSRankDataRepository", 1, "getUnexposuredItems error,candidate feeds is empty!");
            return null;
        }

        @Override // hc0.r.a
        public void b(String str, List<EdgeItem> list) {
            List<e30.b> b16 = ic0.b.b(list);
            if (bc0.a.g().i(b16)) {
                com.tencent.biz.qqcircle.immersive.repository.foldertab.f fVar = g.this.f30636f;
                if (fVar != null) {
                    g.this.U(fVar, b16, str);
                    bc0.a.g().j(new CopyOnWriteArrayList(b16));
                    return;
                } else {
                    QLog.d("FeedLine_TEdgeRS_QFSTabEdgeRSRankDataRepository", 1, "reRank result mFeedSnapshot is null");
                    ic0.d.c("mFeedSnapshot is null");
                    return;
                }
            }
            QLog.d("FeedLine_TEdgeRS_QFSTabEdgeRSRankDataRepository", 1, "reRank result feed doesn't exist in adLoad pool.");
            ic0.d.c("adload check failed");
        }
    }

    public g(@NonNull QFSTabFeedViewModel qFSTabFeedViewModel) {
        super(qFSTabFeedViewModel);
        d dVar = new d();
        this.f30637g = dVar;
        dVar.p(qFSTabFeedViewModel.hashCode(), new a());
    }

    @NonNull
    @MainThread
    private List<e30.b> M(List<e30.b> list, List<e30.b> list2, boolean z16) {
        if (list == null) {
            return new ArrayList();
        }
        if (list2 == null) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        Collection<e30.b> a16 = com.tencent.biz.qqcircle.rerank.util.a.a(list2, list, z16);
        if (a16 != null) {
            arrayList.addAll(a16);
        }
        QLog.d("FeedLine_TEdgeRS_QFSTabEdgeRSRankDataRepository", 1, "handleReRankFeedList filter repeat,origin size:" + size + ",no repeat feed size:" + arrayList.size());
        return arrayList;
    }

    private List<e30.b> N() {
        QFSTabFeedViewModel.c value = d().getValue();
        if (value == null) {
            QLog.e("FeedLine_TEdgeRS_QFSTabEdgeRSRankDataRepository", 1, "getCurFeeds error,no snapshot!");
            return null;
        }
        QLog.d("FeedLine_TEdgeRS_QFSTabEdgeRSRankDataRepository", 1, "getCurFeeds done,size:", Integer.valueOf(value.f86642a.size()));
        return new ArrayList(value.f86642a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.tencent.biz.qqcircle.immersive.repository.foldertab.f O() {
        QLog.d("FeedLine_TEdgeRS_QFSTabEdgeRSRankDataRepository", 1, "getFeedSnapshot begin");
        List<e30.b> N = N();
        if (N == null) {
            QLog.e("FeedLine_TEdgeRS_QFSTabEdgeRSRankDataRepository", 1, "getFeedSnapshot error,cur feed list is null!");
            return null;
        }
        l.a g16 = g(N);
        if (g16 == null) {
            QLog.e("FeedLine_TEdgeRS_QFSTabEdgeRSRankDataRepository", 1, "getFeedSnapshot error,insertPosInfo:null,curFeeds size:", Integer.valueOf(N.size()));
            return null;
        }
        int i3 = g16.f89806c;
        if (i3 >= 0 && i3 < N.size()) {
            com.tencent.biz.qqcircle.immersive.repository.foldertab.f fVar = new com.tencent.biz.qqcircle.immersive.repository.foldertab.f(new ArrayList(N.subList(i3, N.size())), g16);
            QLog.d("FeedLine_TEdgeRS_QFSTabEdgeRSRankDataRepository", 1, "getFeedSnapshot done,needReRankFeedList size:", Integer.valueOf(fVar.f89780b.size()), ",notNeedReRankFeedMap size:", Integer.valueOf(fVar.f89782d.size()), "\uff0cinsertPosInfo\uff1a" + g16);
            return fVar;
        }
        QLog.e("FeedLine_TEdgeRS_QFSTabEdgeRSRankDataRepository", 1, "getFeedSnapshot error,insertIndex:", Integer.valueOf(i3), ",curFeeds size:", Integer.valueOf(N.size()));
        return null;
    }

    @NonNull
    private List<e30.b> P(@NonNull List<e30.b> list, @NonNull List<e30.b> list2, @NonNull List<e30.b> list3, @NonNull List<e30.b> list4) {
        List<e30.b> subList = list.subList(list2.size(), list.size());
        if (subList != null && !subList.isEmpty()) {
            List<e30.b> M = M(subList, list4, true);
            List<e30.b> M2 = M(M, list3, true);
            QLog.d("FeedLine_TEdgeRS_QFSTabEdgeRSRankDataRepository", 1, "getLoadMoreFeedList, unExposeFeedList size:" + subList.size() + ",noRerankFeedList size:" + M.size() + ",noRepeatLoadMoreData size:" + M2.size());
            return M2;
        }
        QLog.d("FeedLine_TEdgeRS_QFSTabEdgeRSRankDataRepository", 1, "getLoadMoreFeedList unExposeFeedList is empty");
        return new ArrayList();
    }

    private List<e30.b> Q(Collection<e30.b> collection, Collection<e30.b> collection2, Map<Integer, e30.b> map) {
        ArrayList arrayList = new ArrayList(collection);
        HashMap hashMap = new HashMap(map);
        ArrayList arrayList2 = new ArrayList(collection2);
        int size = collection.size();
        while (true) {
            if (hashMap.containsKey(Integer.valueOf(size))) {
                e30.b bVar = (e30.b) hashMap.remove(Integer.valueOf(size));
                QLog.d("FeedLine_TEdgeRS_QFSTabEdgeRSRankDataRepository", 1, "mergeFeedList,add diff feed to index: " + size + ",curr size is:" + arrayList.size());
                arrayList.add(bVar);
            } else {
                if (arrayList2.isEmpty()) {
                    break;
                }
                QLog.d("FeedLine_TEdgeRS_QFSTabEdgeRSRankDataRepository", 4, "mergeFeedList, add feed data to index: " + size + ",curr size is:" + arrayList.size());
                arrayList.add((e30.b) arrayList2.remove(0));
            }
            size++;
        }
        if (!hashMap.isEmpty()) {
            QLog.e("FeedLine_TEdgeRS_QFSTabEdgeRSRankDataRepository", 1, "mergeFeedList error\uff0creRankFeeds have consume empty but notNeedReRankFeed is notEmpty\uff0csize is \uff1a " + hashMap.size());
            return null;
        }
        return arrayList;
    }

    private List<e30.b> R(com.tencent.biz.qqcircle.immersive.repository.foldertab.f fVar, List<e30.b> list, String str) {
        if (list != null && !list.isEmpty()) {
            QLog.d("FeedLine_TEdgeRS_QFSTabEdgeRSRankDataRepository", 1, "getMergeList, reRankFeedList size:" + list.size());
            QFSTabFeedViewModel.c value = d().getValue();
            if (value == null) {
                ic0.d.c("snapshot is null");
                QLog.e("FeedLine_TEdgeRS_QFSTabEdgeRSRankDataRepository", 1, "getMergeList error,can't get snapshot!");
                return null;
            }
            ArrayList arrayList = new ArrayList(value.f86642a);
            List<e30.b> m3 = m(arrayList);
            if (m3 == null) {
                ic0.d.c("currentRemainsList is null");
                QLog.e("FeedLine_TEdgeRS_QFSTabEdgeRSRankDataRepository", 1, "getMergeList error,get remain feeds failed!");
                return null;
            }
            if (fVar.f89780b.size() > list.size()) {
                QLog.e("FeedLine_TEdgeRS_QFSTabEdgeRSRankDataRepository", 1, "getMergeList error reRankResult size is less,reRankResult size:" + list.size() + ",needReRankFeeds size:" + fVar.f89780b.size());
                ic0.d.c("reRankResult size less");
                return null;
            }
            V(list, "reRankResult");
            if (f(list, m3, false)) {
                ic0.d.d(str);
                if (ic0.d.a()) {
                    QLog.e("FeedLine_TEdgeRS_QFSTabEdgeRSRankDataRepository", 1, "getMergeList error filterExposeFeed return true");
                    return null;
                }
            }
            List<e30.b> M = M(list, m3, false);
            List<e30.b> Q = Q(m3, M, fVar.f89782d);
            if (Q == null) {
                ic0.d.c("mergeFeedList is null");
                QLog.d("FeedLine_TEdgeRS_QFSTabEdgeRSRankDataRepository", 1, "getMergeList error, remains size:" + m3.size() + ",filterReRankFeeds size:" + M.size() + ",notNeedReRankFeeds size:" + fVar.f89782d.size());
                return null;
            }
            List<e30.b> P = P(arrayList, m3, Q, fVar.f89780b);
            Q.addAll(P);
            V(P, "loadMoreList");
            QLog.d("FeedLine_TEdgeRS_QFSTabEdgeRSRankDataRepository", 1, "getMergeList succeed, remains size:" + m3.size() + ",filterReRankFeeds size:" + M.size() + ",notNeedReRankFeeds size:" + fVar.f89782d.size() + ",canConsumeLoadMoreList size:" + P.size());
            return Q;
        }
        ic0.d.c("reRankResult is null");
        QLog.e("FeedLine_TEdgeRS_QFSTabEdgeRSRankDataRepository", 1, "getMergeList, reRankFeedList is null or empty");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S(List list, com.tencent.biz.qqcircle.immersive.repository.foldertab.f fVar, String str) {
        if (list != null && !list.isEmpty()) {
            List<e30.b> R = R(fVar, list, str);
            if (R == null) {
                QLog.e("FeedLine_TEdgeRS_QFSTabEdgeRSRankDataRepository", 1, "notifyReRankResult mergeList is null");
                return;
            }
            T(d().getValue(), R);
            ic0.d.e();
            QLog.d("FeedLine_TEdgeRS_QFSTabEdgeRSRankDataRepository", 1, "notify rerank feeds,feed size = " + R.size() + ",timeCost:" + (System.currentTimeMillis() - this.f30635e) + "ms");
            return;
        }
        ic0.d.c("reRankFeedList is null");
        QLog.e("FeedLine_TEdgeRS_QFSTabEdgeRSRankDataRepository", 1, "notifyReRankResult reRankFeedInfo.mReRankResultList is empty");
    }

    @MainThread
    private void T(QFSTabFeedViewModel.c cVar, List<e30.b> list) {
        cVar.f86642a.clear();
        cVar.f86642a.addAll(list);
        c(cVar);
        a(UIStateData.obtainModify().setDataList(cVar.a()).setType(103).setFinish(cVar.b()));
        QLog.d("FeedLine_TEdgeRS_QFSTabEdgeRSRankDataRepository", 1, "notifyReRankFeeds done,final output feeds size:", Integer.valueOf(list.size()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U(final com.tencent.biz.qqcircle.immersive.repository.foldertab.f fVar, final List<e30.b> list, final String str) {
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: cc0.f
            @Override // java.lang.Runnable
            public final void run() {
                g.this.S(list, fVar, str);
            }
        });
    }

    private void V(List<e30.b> list, String str) {
        if (list == null) {
            return;
        }
        QLog.d("FeedLine_TEdgeRS_QFSTabEdgeRSRankDataRepository", 1, "printFeedInfo feed size:" + list.size());
        if (!QLog.isColorLevel()) {
            return;
        }
        for (int i3 = 0; i3 < list.size(); i3++) {
            e30.b bVar = list.get(i3);
            if (bVar != null) {
                QLog.d("FeedLine_TEdgeRS_QFSTabEdgeRSRankDataRepository", 1, "printFeedInfo " + str + "," + bVar.g().f398449id.get());
            }
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.repository.foldertab.l
    protected int e(int i3, int i16) {
        if (!this.f30637g.z() && i3 <= i16 + 1) {
            QLog.e("FeedLine_TEdgeRS_QFSTabEdgeRSRankDataRepository", 1, "findInsertIndex is expose index,index + 1");
            return i16 + 2;
        }
        return i3;
    }

    @Override // com.tencent.biz.qqcircle.immersive.repository.foldertab.l
    public String l() {
        return "FeedLine_TEdgeRS_QFSTabEdgeRSRankDataRepository";
    }

    @Override // com.tencent.biz.qqcircle.immersive.repository.foldertab.l
    public void v() {
        d dVar = this.f30637g;
        if (dVar != null) {
            dVar.F();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.repository.foldertab.l
    public void w() {
        super.w();
        d dVar = this.f30637g;
        if (dVar != null) {
            dVar.K();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.repository.foldertab.l
    public void x() {
        super.x();
        d dVar = this.f30637g;
        if (dVar != null) {
            dVar.G();
        }
        this.f30636f = null;
    }
}
