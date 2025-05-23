package com.tencent.biz.qqcircle.immersive.personal.interceptor;

import com.tencent.biz.qqcircle.immersive.utils.r;
import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.sender.chain.BaseSenderChain;
import com.tencent.richframework.sender.interceptor.ReqInterceptor;
import com.tencent.richframework.sender.interceptor.RspInterceptor;
import com.tencent.richframework.thread.RFWThreadManager;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public abstract class QFSUIStateBaseManager<Q extends QCircleBaseRequest, R> implements ReqInterceptor<Q, BaseSenderChain>, RspInterceptor<Q, BaseSenderChain> {

    /* renamed from: a, reason: collision with root package name */
    private List<e30.b> f88699a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    private long f88700b;

    private void d() {
        this.f88699a.clear();
        QLog.d("QFSUIStateBaseManager", 1, "[clear] cache data size: " + this.f88699a.size());
    }

    private List<e30.b> e(List<e30.b> list, List<e30.b> list2) {
        if (list2 == null) {
            QLog.i(g(), 1, "rspDatas is null");
            return list;
        }
        int size = list.size();
        for (e30.b bVar : list2) {
            boolean z16 = false;
            int i3 = 0;
            while (true) {
                if (i3 >= size) {
                    break;
                }
                if (r.B0(list.get(i3).g(), bVar.g())) {
                    list.set(i3, bVar);
                    z16 = true;
                    break;
                }
                i3++;
            }
            if (!z16) {
                list.add(bVar);
                size++;
            }
        }
        return list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(final boolean z16, final boolean z17, final boolean z18, final List<e30.b> list, final long j3, final BaseSenderChain baseSenderChain, final String str, final Q q16) {
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.personal.interceptor.QFSUIStateBaseManager.2
            @Override // java.lang.Runnable
            public void run() {
                QFSUIStateBaseManager qFSUIStateBaseManager = QFSUIStateBaseManager.this;
                qFSUIStateBaseManager.f88699a = qFSUIStateBaseManager.k(qFSUIStateBaseManager.f88699a, list);
                if (QFSUIStateBaseManager.this.f88699a.isEmpty()) {
                    baseSenderChain.handleRsp(true, j3, str, q16, UIStateData.obtainEmpty().setData(z16, QFSUIStateBaseManager.this.f88699a).setFinish(z18).setRetCode(j3));
                } else {
                    baseSenderChain.handleRsp(true, j3, str, q16, UIStateData.obtainSuccess(z17).setData(z16, QFSUIStateBaseManager.this.f88699a).setFinish(z18).setRetCode(j3));
                }
            }
        });
    }

    public List<e30.b> f() {
        return this.f88699a;
    }

    public String g() {
        return "QFSUIStateBaseManager";
    }

    @Override // com.tencent.richframework.sender.interceptor.ReqInterceptor
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public void interceptAddReq(Q q16, BaseSenderChain baseSenderChain) {
        boolean z16 = baseSenderChain.getExtraData().getBoolean("qfs_extra_data_key_is_load_more");
        o(q16);
        if (z16) {
            n(q16);
        }
        baseSenderChain.addRequest(q16);
        this.f88700b = System.currentTimeMillis();
    }

    @Override // com.tencent.richframework.sender.interceptor.RspInterceptor
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public final void interceptReturnRsp(boolean z16, final long j3, final String str, final Q q16, final Object obj, final BaseSenderChain baseSenderChain) {
        boolean z17;
        String str2;
        if (baseSenderChain == null) {
            return;
        }
        if (baseSenderChain.getExtraData() != null && baseSenderChain.getExtraData().getBoolean("qfs_extra_data_key_is_load_more")) {
            z17 = true;
        } else {
            z17 = false;
        }
        final boolean isProtocolCache = VSNetworkHelper.isProtocolCache(str);
        QLog.i(g(), 1, "[interceptReturnRsp] request=" + q16 + ",isSuccess=" + z16 + ",retCode=" + j3 + ",errMsg=" + str + ",traceId=" + q16.getTraceId() + ",isCache=" + isProtocolCache + ",isLoadMore=" + z17);
        baseSenderChain.callBackRsp(z16, j3, str, q16, obj);
        String g16 = g();
        StringBuilder sb5 = new StringBuilder();
        sb5.append(q16);
        if (isProtocolCache) {
            str2 = " cache";
        } else {
            str2 = " network";
        }
        sb5.append(str2);
        sb5.append(" costTime = ");
        sb5.append(System.currentTimeMillis() - this.f88700b);
        sb5.append("ms");
        QLog.i(g16, 1, sb5.toString());
        if (!z17) {
            d();
        }
        if (z16 && j3 == 0 && obj != null) {
            final boolean z18 = z17;
            RFWThreadManager.getInstance().execOnNetThread(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.personal.interceptor.QFSUIStateBaseManager.1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        Object obj2 = obj;
                        boolean m3 = QFSUIStateBaseManager.this.m(obj2);
                        RFWLog.i(QFSUIStateBaseManager.this.g(), RFWLog.USR, "[parseDataFromRsp] -> isCache = " + isProtocolCache);
                        QFSUIStateBaseManager.this.h(z18, isProtocolCache, m3, QFSUIStateBaseManager.this.l(obj2, isProtocolCache), j3, baseSenderChain, str, q16);
                    } catch (ClassCastException e16) {
                        QLog.i("QFSUIStateBaseManager", 1, "[interceptReturnRsp] -> errorMsg = " + e16.getMessage() + " rsp is " + obj);
                    }
                }
            });
        } else {
            baseSenderChain.handleRsp(z16, j3, str, q16, UIStateData.obtainError(str).setData(z17, this.f88699a).setFinish(true).setRetCode(j3));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public List<e30.b> k(List<e30.b> list, List<e30.b> list2) {
        return e(list, list2);
    }

    protected abstract List<e30.b> l(R r16, boolean z16);

    protected abstract boolean m(R r16);

    protected abstract void n(Q q16);

    protected void o(Q q16) {
    }
}
