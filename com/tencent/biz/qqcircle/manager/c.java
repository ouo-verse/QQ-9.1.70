package com.tencent.biz.qqcircle.manager;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.Observer;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StUserRecomInfo;
import feedcloud.FeedCloudRead$StGetFeedListRsp;
import feedcloud.FeedCloudRead$StGetRecomUserListRsp;
import java.lang.ref.WeakReference;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class c implements LifecycleOwner {
    private String C;

    /* renamed from: d, reason: collision with root package name */
    private LifecycleRegistry f91539d;

    /* renamed from: e, reason: collision with root package name */
    private com.tencent.biz.qqcircle.viewmodels.e f91540e;

    /* renamed from: f, reason: collision with root package name */
    private com.tencent.biz.qqcircle.viewmodels.i f91541f;

    /* renamed from: h, reason: collision with root package name */
    private a f91542h;

    /* renamed from: i, reason: collision with root package name */
    private C0920c f91543i;

    /* renamed from: m, reason: collision with root package name */
    private b f91544m;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    private static class a implements Observer<UIStateData<FeedCloudRead$StGetFeedListRsp>> {

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<c> f91545d;

        public a(c cVar) {
            this.f91545d = null;
            this.f91545d = new WeakReference<>(cVar);
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(UIStateData<FeedCloudRead$StGetFeedListRsp> uIStateData) {
            c cVar;
            WeakReference<c> weakReference = this.f91545d;
            if (weakReference == null) {
                cVar = null;
            } else {
                cVar = weakReference.get();
            }
            if (cVar == null) {
                QLog.d("PYMK-QCirclePersonalPymkModelManager", 1, "[onChanged] model manager should not be null.");
                return;
            }
            if (uIStateData.getState() == 4) {
                QLog.d("PYMK-QCirclePersonalPymkModelManager", 1, "[onChanged] msg: ", uIStateData.getMsg(), " | error code: ", Long.valueOf(uIStateData.getRetCode()));
                cVar.g(uIStateData.getRetCode(), uIStateData.getMsg());
            } else if (uIStateData.getState() == 3 || uIStateData.getState() == 2) {
                cVar.h(uIStateData.getData());
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public interface b {
        void a(@NonNull List<FeedCloudMeta$StUserRecomInfo> list);
    }

    /* compiled from: P */
    /* renamed from: com.tencent.biz.qqcircle.manager.c$c, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private static class C0920c implements Observer<FeedCloudRead$StGetRecomUserListRsp> {

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<c> f91546d;

        public C0920c(c cVar) {
            this.f91546d = null;
            this.f91546d = new WeakReference<>(cVar);
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(FeedCloudRead$StGetRecomUserListRsp feedCloudRead$StGetRecomUserListRsp) {
            c cVar;
            WeakReference<c> weakReference = this.f91546d;
            if (weakReference == null) {
                cVar = null;
            } else {
                cVar = weakReference.get();
            }
            if (cVar != null) {
                cVar.i(feedCloudRead$StGetRecomUserListRsp);
            } else {
                QLog.d("PYMK-QCirclePersonalPymkModelManager", 1, "[onChanged] model manager should not be null.");
            }
        }
    }

    public c() {
        LifecycleRegistry lifecycleRegistry = new LifecycleRegistry(this);
        this.f91539d = lifecycleRegistry;
        lifecycleRegistry.setCurrentState(Lifecycle.State.STARTED);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(long j3, String str) {
        QLog.d("PYMK-QCirclePersonalPymkModelManager", 1, "[handleFeedListRspFail] err code: ", Long.valueOf(j3), " | err msg: ", str);
        l(null);
        this.C = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp) {
        if (feedCloudRead$StGetFeedListRsp == null) {
            QLog.w("PYMK-QCirclePersonalPymkModelManager", 1, "[handleFeedListRspResult] rsp should be null.");
            return;
        }
        List<FeedCloudMeta$StFeed> list = feedCloudRead$StGetFeedListRsp.vecFeed.get();
        QLog.d("PYMK-QCirclePersonalPymkModelManager", 1, "[handleFeedListRspResult] result count: ", Integer.valueOf(list.size()));
        l(list);
        this.C = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(FeedCloudRead$StGetRecomUserListRsp feedCloudRead$StGetRecomUserListRsp) {
        if (feedCloudRead$StGetRecomUserListRsp == null) {
            QLog.w("PYMK-QCirclePersonalPymkModelManager", 1, "[handlePersonalEmptyProductLoadPymkResult] rsp should be null.");
            return;
        }
        List<FeedCloudMeta$StUserRecomInfo> list = feedCloudRead$StGetRecomUserListRsp.userRecoms.get();
        QLog.d("PYMK-QCirclePersonalPymkModelManager", 1, "[handlePersonalEmptyProductLoadPymkResult] result count: ", Integer.valueOf(list.size()));
        k(list);
        this.C = null;
    }

    private void k(List<FeedCloudMeta$StUserRecomInfo> list) {
        if (this.f91544m == null) {
            QLog.d("PYMK-QCirclePersonalPymkModelManager", 1, "[notifyPersonalEmptyProductLoadPymkResult] result callback should not be null.");
        } else if (list != null && !list.isEmpty()) {
            this.f91544m.a(list);
        } else {
            QLog.d("PYMK-QCirclePersonalPymkModelManager", 1, "[notifyPersonalEmptyProductLoadPymkResult] feed list is empty.");
        }
    }

    private void l(List<FeedCloudMeta$StFeed> list) {
        QLog.d("PYMK-QCirclePersonalPymkModelManager", 1, "[notifyPersonalPymkResult] result callback should not be null.");
    }

    public void d(String str) {
        com.tencent.biz.qqcircle.viewmodels.e eVar = this.f91540e;
        if (eVar == null) {
            QLog.d("PYMK-QCirclePersonalPymkModelManager", 1, "[fetchPersonalEmptyProductLoadPymk] guest view model should be null.");
        } else {
            this.C = str;
            eVar.M1(str, "");
        }
    }

    public com.tencent.biz.qqcircle.viewmodels.e e() {
        return this.f91540e;
    }

    public String f() {
        return this.C;
    }

    @Override // androidx.lifecycle.LifecycleOwner
    @NonNull
    public Lifecycle getLifecycle() {
        return this.f91539d;
    }

    public void j() {
        this.f91542h = new a(this);
        this.f91543i = new C0920c(this);
        com.tencent.biz.qqcircle.viewmodels.e eVar = new com.tencent.biz.qqcircle.viewmodels.e();
        this.f91540e = eVar;
        eVar.f92846m.observe(this, this.f91542h);
        this.f91540e.C.observe(this, this.f91543i);
        com.tencent.biz.qqcircle.viewmodels.i iVar = new com.tencent.biz.qqcircle.viewmodels.i();
        this.f91541f = iVar;
        iVar.f92863m.observe(this, this.f91542h);
    }

    public void m(b bVar) {
        this.f91544m = bVar;
    }
}
