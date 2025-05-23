package com.tencent.biz.qqcircle.preload.task;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.beans.QFSSearchBean;
import com.tencent.biz.qqcircle.immersive.request.QFSGetSearchPageRequest;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.biz.qqcircle.immersive.views.search.util.p;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.engineering.preload.BasePreLoadTask;
import com.tencent.mobileqq.engineering.preload.inter.OnPreLoadListener;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudRead$StGetSearchPageRsp;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes4.dex */
public class i extends BasePreLoadTask {

    /* renamed from: a, reason: collision with root package name */
    private final QFSSearchBean f91634a;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class a implements VSDispatchObserver.OnVSRspCallBack<FeedCloudRead$StGetSearchPageRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ OnPreLoadListener f91635a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ QFSGetSearchPageRequest f91636b;

        a(OnPreLoadListener onPreLoadListener, QFSGetSearchPageRequest qFSGetSearchPageRequest) {
            this.f91635a = onPreLoadListener;
            this.f91636b = qFSGetSearchPageRequest;
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, FeedCloudRead$StGetSearchPageRsp feedCloudRead$StGetSearchPageRsp) {
            QLog.d("QFSSearchResultPreLoaderTask", 1, "[requestSearchResult] onReceive: dispatch Success:" + z16 + " | TraceId:" + baseRequest.getTraceId() + " | SeqId:" + baseRequest.getCurrentSeq() + " | retCode:" + j3 + " | retMessage:" + str);
            OnPreLoadListener onPreLoadListener = this.f91635a;
            if (onPreLoadListener == null) {
                return;
            }
            onPreLoadListener.onLoaded(Boolean.valueOf(z16), Long.valueOf(j3), str, feedCloudRead$StGetSearchPageRsp, Boolean.FALSE);
            this.f91636b.addReportExtraData("isPreload", "true").addReportExtraData(QFSSearchBaseRequest.EXTRA_KEY_QUERY_SOURCE, String.valueOf(i.this.f91634a.getQuerySource())).addReportExtraData("word", i.this.f91634a.getSearchKeyword()).addSearchPageRspExtraData(feedCloudRead$StGetSearchPageRsp, z16, j3).reportCmdSuccessRate(j3, str);
        }
    }

    public i(QFSSearchBean qFSSearchBean) {
        this.f91634a = qFSSearchBean;
    }

    private void b(@NonNull QFSGetSearchPageRequest.a aVar) {
        QFSSearchBean qFSSearchBean = this.f91634a;
        if (qFSSearchBean != null && qFSSearchBean.getSchemeAttrs() != null && this.f91634a.getSchemeAttrs().size() != 0) {
            String str = this.f91634a.getSchemeAttrs().get("trace_id");
            if (TextUtils.isEmpty(str)) {
                return;
            }
            aVar.f("qq_trace_id", str);
        }
    }

    @Override // com.tencent.mobileqq.engineering.preload.BasePreLoadTask
    public void startLoadData(OnPreLoadListener onPreLoadListener) {
        if (this.f91634a == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        arrayList.add(6);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(7);
        arrayList.add(9);
        arrayList.add(10);
        arrayList.add(13);
        arrayList.add(14);
        arrayList.add(11);
        arrayList.add(12);
        if (!p.x(this.f91634a.getQuerySource())) {
            arrayList.add(15);
        }
        if (com.tencent.biz.qqcircle.immersive.utils.a.h(this.f91634a.getSearchKeyword())) {
            arrayList.add(17);
        }
        arrayList.add(18);
        QFSGetSearchPageRequest.a k3 = new QFSGetSearchPageRequest.a().l(this.f91634a.getSearchKeyword()).j(1).k(arrayList);
        b(k3);
        QFSGetSearchPageRequest b16 = k3.b();
        b16.setEnableCache(false);
        VSNetworkHelper.getInstance().sendRequest(b16, new a(onPreLoadListener, b16));
    }

    @Override // com.tencent.mobileqq.engineering.preload.BasePreLoadTask
    public void onRemove() {
    }
}
