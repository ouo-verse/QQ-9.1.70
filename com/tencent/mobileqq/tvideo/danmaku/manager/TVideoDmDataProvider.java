package com.tencent.mobileqq.tvideo.danmaku.manager;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.immersive.events.QFSGetBarrageEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.part.utils.RFSafeListUtils;
import com.tencent.biz.richframework.part.utils.RFSafeMapUtils;
import com.tencent.mobileqq.engineering.preload.inter.OnTaskListener;
import com.tencent.mobileqq.tvideo.danmaku.vm.TVideoDmViewModel;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import feedcloud.FeedCloudMeta$StBarrage;
import feedcloud.FeedCloudRead$StGetBarrageListRsp;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import tvideo.Video;
import u50.a;

/* loaded from: classes19.dex */
public class TVideoDmDataProvider {

    /* renamed from: b, reason: collision with root package name */
    private static volatile TVideoDmDataProvider f304369b;

    /* renamed from: a, reason: collision with root package name */
    private final u50.a f304370a = new u50.a();

    /* loaded from: classes19.dex */
    public static class a implements OnTaskListener<Object>, VSDispatchObserver.OnVSRspCallBack<FeedCloudRead$StGetBarrageListRsp> {

        /* renamed from: a, reason: collision with root package name */
        @NonNull
        private final ux2.a f304372a;

        /* renamed from: b, reason: collision with root package name */
        private WeakReference<TVideoDmDataProvider> f304373b;

        public a(@NonNull ux2.a aVar, TVideoDmDataProvider tVideoDmDataProvider) {
            this.f304373b = null;
            this.f304373b = new WeakReference<>(tVideoDmDataProvider);
            this.f304372a = aVar;
        }

        private void a(Object... objArr) {
            TVideoDmDataProvider tVideoDmDataProvider;
            WeakReference<TVideoDmDataProvider> weakReference = this.f304373b;
            if (weakReference == null) {
                tVideoDmDataProvider = null;
            } else {
                tVideoDmDataProvider = weakReference.get();
            }
            if (tVideoDmDataProvider != null) {
                tVideoDmDataProvider.h(this.f304372a, objArr);
            } else {
                QLog.d("QDM-TVideoDmDataProvider", 1, "[onComplete] manager should not be null.");
            }
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, FeedCloudRead$StGetBarrageListRsp feedCloudRead$StGetBarrageListRsp) {
            String cmdName;
            Object[] objArr = {Boolean.valueOf(z16), Long.valueOf(j3), str, feedCloudRead$StGetBarrageListRsp};
            String str2 = "null";
            if (baseRequest == null) {
                cmdName = "null";
            } else {
                cmdName = baseRequest.getCmdName();
            }
            if (baseRequest != null) {
                str2 = baseRequest.getTraceId();
            }
            QLog.d("QDM-TVideoDmDataProvider", 2, "[onReceive] request load task, cmdName" + cmdName + " | trace id: ", str2, " | retCode: ", Long.valueOf(j3), " | errMsg: ", str);
            a(objArr);
        }

        @Override // com.tencent.mobileqq.engineering.preload.inter.OnTaskListener
        public void onComplete(Object... objArr) {
            a(objArr);
        }
    }

    TVideoDmDataProvider() {
    }

    private List<FeedCloudMeta$StBarrage> d(@NonNull String str) {
        ArrayList arrayList = (ArrayList) RFSafeMapUtils.getVal(e(str), str);
        if (arrayList == null) {
            QLog.d("QDM-TVideoDmDataProvider", 1, "[getBarrageCache] comment cache is empty, create comment cache.");
            return new ArrayList();
        }
        return arrayList;
    }

    private Map<String, ArrayList<FeedCloudMeta$StBarrage>> e(@NonNull String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.d("QDM-TVideoDmDataProvider", 1, "[getBarrageCacheMap] feed id not is empty.");
            return null;
        }
        u50.a aVar = this.f304370a;
        if (aVar == null) {
            QLog.d("QDM-TVideoDmDataProvider", 1, "[getBarrageCacheMap] comment cache pack should not be null.");
            return null;
        }
        return aVar.a();
    }

    private void f(@NonNull ux2.a aVar, @NonNull FeedCloudRead$StGetBarrageListRsp feedCloudRead$StGetBarrageListRsp) {
        String n3 = n(aVar.c());
        if (TextUtils.isEmpty(n3)) {
            QLog.d("QDM-TVideoDmDataProvider", 1, "[handleGetBarrageDataSource] current feed id is empty, handle fail.");
            return;
        }
        List<FeedCloudMeta$StBarrage> list = feedCloudRead$StGetBarrageListRsp.vecBarrage.get();
        if (list == null) {
            QLog.d("QDM-TVideoDmDataProvider", 1, "[handleGetBarrageDataSource] comment list is empty, handler fail.");
            return;
        }
        if (list.size() > 300) {
            list = list.subList(0, 300);
        }
        QLog.d("QDM-TVideoDmDataProvider", 2, "[handleGetBarrageDataSource] bean value: ", aVar.toString());
        QLog.d("QDM-TVideoDmDataProvider", 2, "[handleGetBarrageDataSource] rsp.vecBarrage.get().size: ", Integer.valueOf(list.size()));
        if (aVar.e()) {
            s(n3, list);
        } else {
            r(n3, list);
        }
    }

    private void g(@NonNull ux2.a aVar, long j3, String str) {
        boolean e16 = aVar.e();
        String n3 = n(aVar.c());
        QFSGetBarrageEvent build = QFSGetBarrageEvent.build();
        build.setLoadSuccess(false);
        build.setFeedId(n3);
        build.setRetCode(j3);
        build.setLoadMore(e16);
        build.setErrMsg(str);
        SimpleEventBus.getInstance().dispatchEvent(build);
        QLog.d("QDM-TVideoDmDataProvider", 1, "[handleGetBarrageListFail] ret code: ", Long.valueOf(j3), " | err msg: ", str, " | isLoadMore: ", Boolean.valueOf(e16), " | feed id: ", n3, " | hash code: ", Integer.valueOf(aVar.b()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(@NonNull ux2.a aVar, Object... objArr) {
        if (objArr != null && objArr.length >= 4) {
            boolean booleanValue = ((Boolean) objArr[0]).booleanValue();
            long longValue = ((Long) objArr[1]).longValue();
            String str = (String) objArr[2];
            FeedCloudRead$StGetBarrageListRsp feedCloudRead$StGetBarrageListRsp = (FeedCloudRead$StGetBarrageListRsp) objArr[3];
            if (booleanValue && longValue == 0 && feedCloudRead$StGetBarrageListRsp != null) {
                t(aVar, feedCloudRead$StGetBarrageListRsp);
                f(aVar, feedCloudRead$StGetBarrageListRsp);
                m(aVar, feedCloudRead$StGetBarrageListRsp, longValue, str);
                return;
            }
            g(aVar, longValue, str);
            return;
        }
        QLog.e("QDM-TVideoDmDataProvider", 1, "[handleGetCommentListResponse] handle args is null or args length < 4");
    }

    private void i(@NonNull ux2.a aVar) {
        if (k(n(aVar.c()))) {
            QLog.d("QDM-TVideoDmDataProvider", 1, "[handlerLoadMore] current load data finish");
        } else {
            c(aVar);
        }
    }

    public static TVideoDmDataProvider j() {
        if (f304369b == null) {
            synchronized (TVideoDmDataProvider.class) {
                if (f304369b == null) {
                    f304369b = new TVideoDmDataProvider();
                }
            }
        }
        return f304369b;
    }

    private boolean k(String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.d("QDM-TVideoDmDataProvider", 1, "[isLoadFinish] current feed id should not be null.");
            return false;
        }
        a.C11324a c11324a = (a.C11324a) RFSafeMapUtils.getVal(this.f304370a.b(), str);
        if (c11324a == null || !c11324a.b()) {
            return false;
        }
        return true;
    }

    private void m(ux2.a aVar, FeedCloudRead$StGetBarrageListRsp feedCloudRead$StGetBarrageListRsp, long j3, String str) {
        boolean z16;
        String n3 = n(aVar.c());
        boolean e16 = aVar.e();
        List<FeedCloudMeta$StBarrage> list = feedCloudRead$StGetBarrageListRsp.vecBarrage.get();
        if (list.size() > 300) {
            list = list.subList(0, 300);
        }
        QFSGetBarrageEvent build = QFSGetBarrageEvent.build();
        build.setLoadSuccess(false);
        build.setFeedId(n3);
        build.setRetCode(j3);
        build.setLoadMore(e16);
        build.setAttachInfo(feedCloudRead$StGetBarrageListRsp.feedPlayTime.get());
        if (feedCloudRead$StGetBarrageListRsp.isFinish.get() != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        build.setIsFinish(z16);
        build.setErrMsg(str);
        build.setBarrageList(list);
        SimpleEventBus.getInstance().dispatchEvent(build);
        QLog.d("QDM-TVideoDmDataProvider", 1, "[notifyGetBarrageListFinish]", "ret code: " + j3 + " | err msg: " + str + " | count: " + RFSafeListUtils.getSize(list) + " | isLoadMore: " + e16 + " | feedId: " + n3 + " | hash code:" + aVar.b() + " | attachInfo: " + feedCloudRead$StGetBarrageListRsp.feedPlayTime);
    }

    private String n(Video video) {
        if (video == null) {
            return null;
        }
        return video.video_base_info.vid;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(@NonNull ux2.a aVar) {
        long d16 = aVar.d();
        int b16 = aVar.b();
        TVideoDmViewModel tVideoDmViewModel = new TVideoDmViewModel(aVar, d16);
        QLog.d("QDM-TVideoDmDataProvider", 1, "[requestFeedBarrageData]", "hashCode: " + b16 + " | feed id: " + n(aVar.c()) + " | isLoadMore: " + aVar.e() + " | playTime: " + d16);
        tVideoDmViewModel.n2(new a(aVar, this));
    }

    private void q(@NonNull ux2.a aVar) {
        if (aVar.e()) {
            i(aVar);
        } else {
            c(aVar);
        }
    }

    private void r(@NonNull String str, @NonNull List<FeedCloudMeta$StBarrage> list) {
        RFSafeMapUtils.put(e(str), str, new ArrayList(list));
    }

    private void s(@NonNull String str, @NonNull List<FeedCloudMeta$StBarrage> list) {
        List<FeedCloudMeta$StBarrage> d16 = d(str);
        d16.addAll(list);
        QLog.d("QDM-TVideoDmDataProvider", 1, "[updateBarrageLoadMoreData] update feed id: ", str + " | server call comment count: ", Integer.valueOf(list.size()), " | current cache comment count: ", Integer.valueOf(d16.size()));
    }

    private void t(@NonNull ux2.a aVar, @NonNull FeedCloudRead$StGetBarrageListRsp feedCloudRead$StGetBarrageListRsp) {
        boolean z16;
        String n3 = n(aVar.c());
        if (TextUtils.isEmpty(n3)) {
            QLog.d("QDM-TVideoDmDataProvider", 1, "[updateResponseAttachInfo] feed id not is empty.");
            return;
        }
        long j3 = feedCloudRead$StGetBarrageListRsp.feedPlayTime.get();
        if (feedCloudRead$StGetBarrageListRsp.isFinish.get() != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        QLog.d("QDM-TVideoDmDataProvider", 2, "[updateResponseAttachInfo] feed id: ", n(aVar.c()), " | attachInfo: ", Long.valueOf(j3), " | isFinish: ", Boolean.valueOf(z16));
        Map<String, a.C11324a> b16 = this.f304370a.b();
        a.C11324a c11324a = (a.C11324a) RFSafeMapUtils.getVal(b16, n3);
        if (c11324a == null) {
            a.C11324a a16 = a.C11324a.a();
            a16.c(j3);
            a16.d(z16);
            b16.put(n3, a16);
            return;
        }
        c11324a.d(z16);
        c11324a.c(j3);
    }

    public void c(@NonNull final ux2.a aVar) {
        RFWThreadManager.getInstance().execOnNetThread(new Runnable() { // from class: com.tencent.mobileqq.tvideo.danmaku.manager.TVideoDmDataProvider.1
            @Override // java.lang.Runnable
            public void run() {
                TVideoDmDataProvider.this.p(aVar);
            }
        });
    }

    public void l(ux2.a aVar) {
        if (aVar == null) {
            QLog.d("QDM-TVideoDmDataProvider", 1, "[loadBarrageList] bean should not be null.");
        } else {
            q(aVar);
        }
    }

    public void o() {
        u50.a aVar = this.f304370a;
        if (aVar == null) {
            return;
        }
        aVar.c();
    }
}
