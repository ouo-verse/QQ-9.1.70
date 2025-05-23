package com.tencent.biz.qqcircle.richframework.sender.iml;

import com.tencent.biz.qqcircle.immersive.personal.interceptor.QFSUIStateBaseManager;
import com.tencent.biz.qqcircle.immersive.personal.interceptor.h;
import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.richframework.sender.call.BaseCall;
import com.tencent.richframework.sender.chain.BaseSenderChain;
import com.tencent.richframework.sender.interceptor.ReqInterceptor;
import com.tencent.richframework.sender.interceptor.RspInterceptor;
import com.tencent.richframework.thread.RFWThreadManager;
import db0.e;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QCircleRequestCall extends BaseCall<QCircleBaseRequest> {

    /* renamed from: a, reason: collision with root package name */
    private int f91999a = 2;

    /* renamed from: b, reason: collision with root package name */
    private boolean f92000b = true;

    /* renamed from: c, reason: collision with root package name */
    private boolean f92001c = true;

    /* renamed from: d, reason: collision with root package name */
    private WeakReference<QFSUIStateBaseManager> f92002d;

    /* renamed from: e, reason: collision with root package name */
    private h f92003e;

    private void c(List<ReqInterceptor> list) {
        h hVar = this.f92003e;
        if (hVar != null) {
            list.add(hVar);
        }
    }

    private void d(List<ReqInterceptor> list) {
        WeakReference<QFSUIStateBaseManager> weakReference = this.f92002d;
        if (weakReference != null && weakReference.get() != null) {
            list.add(this.f92002d.get());
        }
    }

    private void e(List<RspInterceptor> list) {
        WeakReference<QFSUIStateBaseManager> weakReference = this.f92002d;
        if (weakReference != null && weakReference.get() != null) {
            list.add(this.f92002d.get());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        a aVar = new a();
        aVar.d(this.f92001c);
        List<ReqInterceptor> arrayList = new ArrayList<>();
        d(arrayList);
        arrayList.addAll(this.mCustomReqInterceptor);
        if (this.f92000b) {
            Iterator it = this.mReqObjectList.iterator();
            while (it.hasNext()) {
                ((QCircleBaseRequest) it.next()).setRetryCount(this.f91999a);
            }
            arrayList.add(aVar);
        }
        c(arrayList);
        arrayList.add(new e());
        List<RspInterceptor> arrayList2 = new ArrayList<>();
        if (this.f92000b) {
            arrayList2.add(aVar);
        }
        arrayList2.addAll(this.mCustomRspInterceptor);
        e(arrayList2);
        BaseSenderChain build = BaseSenderChain.BaseSenderChainBuilder.newBuilder().withReqInterceptors(arrayList).withRspInterceptors(arrayList2).withWRFListener(new WeakReference<>(this.mCallback)).withHandleReqIndex(0).withHandleRspIndex(0).withExtraData(this.mExtraData).withOutputSenderChain(this.mOutputSenderChains).build();
        Iterator it5 = this.mReqObjectList.iterator();
        while (it5.hasNext()) {
            build.addRequest((QCircleBaseRequest) it5.next());
        }
    }

    public QCircleRequestCall b(String str, QCircleBaseRequest qCircleBaseRequest) {
        this.f92003e = new h(str, true);
        addRequest(qCircleBaseRequest);
        return this;
    }

    @Override // com.tencent.richframework.sender.call.Call
    public void execute() {
        RFWThreadManager.getInstance().execOnNetThread(new Runnable() { // from class: com.tencent.biz.qqcircle.richframework.sender.iml.QCircleRequestCall.1
            @Override // java.lang.Runnable
            public void run() {
                QCircleRequestCall.this.g();
            }
        });
    }

    public QCircleRequestCall f(String str) {
        this.f92003e = new h(str, false);
        return this;
    }

    public QCircleRequestCall h(boolean z16) {
        this.f92000b = z16;
        return this;
    }

    public QCircleRequestCall i(boolean z16) {
        this.mExtraData.putBoolean("qfs_extra_data_key_is_load_more", z16);
        return this;
    }

    public QCircleRequestCall j(QFSUIStateBaseManager qFSUIStateBaseManager) {
        if (qFSUIStateBaseManager != null) {
            this.f92002d = new WeakReference<>(qFSUIStateBaseManager);
        }
        return this;
    }

    public QCircleRequestCall k(boolean z16) {
        this.f92001c = z16;
        return this;
    }
}
