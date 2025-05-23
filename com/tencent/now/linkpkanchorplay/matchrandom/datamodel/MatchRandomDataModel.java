package com.tencent.now.linkpkanchorplay.matchrandom.datamodel;

import com.tencent.component.core.thread.ThreadCenter;
import com.tencent.mobileqq.qqlive.api.ILiveNetRequest;
import com.tencent.mobileqq.qqlive.api.sso.QQLiveResponse;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.now.linkpkanchorplay.sso.request.JoinMatchRequest;
import com.tencent.now.linkpkanchorplay.sso.request.JoinRankPKMatchRequest;
import com.tencent.now.sso.request.GetAnchorPKInfoRequest;
import com.tencent.qqlive.common.api.AegisLogger;
import g55.q;

/* compiled from: P */
/* loaded from: classes22.dex */
public class MatchRandomDataModel implements ThreadCenter.HandlerKeyable {

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public interface a {
        void a(e55.c cVar);

        void b(String str, boolean z16);

        void c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h(a aVar, long j3, QQLiveResponse qQLiveResponse) {
        if (qQLiveResponse.isFailed()) {
            AegisLogger.i("PK_Biz|MatchRandomDataModel", "joinMatch error, errCode=" + qQLiveResponse.getRetCode() + ", errMsg=" + qQLiveResponse.getErrMsg());
            if (aVar != null) {
                aVar.b(qQLiveResponse.getErrMsg(), true);
                return;
            }
            return;
        }
        AegisLogger.i("PK_Biz|MatchRandomDataModel", "joinMatch success, roomId=" + j3);
        if (aVar != null) {
            aVar.c();
            k(j3, aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i(a aVar, long j3, QQLiveResponse qQLiveResponse) {
        if (qQLiveResponse.isFailed()) {
            AegisLogger.i("PK_Biz|MatchRandomDataModel", "joinRankMatch error, errCode=" + qQLiveResponse.getRetCode() + ", errMsg=" + qQLiveResponse.getErrMsg());
            if (aVar != null) {
                aVar.b(qQLiveResponse.getErrMsg(), true);
                return;
            }
            return;
        }
        AegisLogger.i("PK_Biz|MatchRandomDataModel", "joinRankMatch success, roomId=" + j3);
        if (aVar != null) {
            aVar.c();
            k(j3, aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j(final a aVar, final long j3, QQLiveResponse qQLiveResponse) {
        q qVar = (q) qQLiveResponse.getRsp();
        if (!qQLiveResponse.isFailed() && qVar != null) {
            AegisLogger.i("PK_Biz|MatchRandomDataModel", "queryMatchResult, success, pkStatus=" + qVar.f401381d);
            int i3 = qVar.f401381d;
            if (1 == i3) {
                AegisLogger.i("PK_Biz|MatchRandomDataModel", "queryMatchResult, match fail");
                aVar.b("svr match fail", false);
                return;
            }
            if (qVar.f401379b != null && 3 == i3) {
                AegisLogger.i("PK_Biz|MatchRandomDataModel", "queryMatchResult, IN_PK");
                e55.c cVar = qVar.f401379b.f401328d.f401358a;
                if (cVar != null) {
                    aVar.a(cVar);
                    return;
                } else {
                    aVar.b("basicInfo is null", false);
                    return;
                }
            }
            int i16 = qVar.f401382e * 1000;
            if (i16 <= 0) {
                AegisLogger.i("PK_Biz|MatchRandomDataModel", "queryMatchResult, match finish, interval=0");
                aVar.b("svr stop match", false);
                return;
            } else {
                ThreadCenter.postDelayedUITask(this, new Runnable() { // from class: com.tencent.now.linkpkanchorplay.matchrandom.datamodel.MatchRandomDataModel.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MatchRandomDataModel.this.k(j3, aVar);
                    }
                }, i16);
                return;
            }
        }
        AegisLogger.i("PK_Biz|MatchRandomDataModel", "joinMatch error, errCode=" + qQLiveResponse.getRetCode() + ", errMsg=" + qQLiveResponse.getErrMsg());
        if (aVar != null) {
            aVar.b(qQLiveResponse.getErrMsg(), true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(final long j3, final a aVar) {
        AegisLogger.i("PK_Biz|MatchRandomDataModel", "queryMatchResult, roomId=" + j3);
        ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest(new GetAnchorPKInfoRequest(j3), new ILiveNetRequest.Callback() { // from class: com.tencent.now.linkpkanchorplay.matchrandom.datamodel.a
            @Override // com.tencent.mobileqq.qqlive.api.ILiveNetRequest.Callback
            public final void onResponse(QQLiveResponse qQLiveResponse) {
                MatchRandomDataModel.this.j(aVar, j3, qQLiveResponse);
            }
        });
    }

    public void e() {
        ThreadCenter.clear(this);
    }

    public void f(final long j3, final a aVar) {
        AegisLogger.i("PK_Biz|MatchRandomDataModel", "joinMatch, roomId=" + j3);
        ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest(new JoinMatchRequest(), new ILiveNetRequest.Callback() { // from class: com.tencent.now.linkpkanchorplay.matchrandom.datamodel.c
            @Override // com.tencent.mobileqq.qqlive.api.ILiveNetRequest.Callback
            public final void onResponse(QQLiveResponse qQLiveResponse) {
                MatchRandomDataModel.this.h(aVar, j3, qQLiveResponse);
            }
        });
    }

    public void g(final long j3, int i3, final a aVar) {
        AegisLogger.i("PK_Biz|MatchRandomDataModel", "joinRankMatch, pkType=" + i3);
        ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest(new JoinRankPKMatchRequest(i3), new ILiveNetRequest.Callback() { // from class: com.tencent.now.linkpkanchorplay.matchrandom.datamodel.b
            @Override // com.tencent.mobileqq.qqlive.api.ILiveNetRequest.Callback
            public final void onResponse(QQLiveResponse qQLiveResponse) {
                MatchRandomDataModel.this.i(aVar, j3, qQLiveResponse);
            }
        });
    }

    public void l() {
        ThreadCenter.clear(this);
    }
}
