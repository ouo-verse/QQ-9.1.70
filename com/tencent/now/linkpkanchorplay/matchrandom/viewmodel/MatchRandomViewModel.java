package com.tencent.now.linkpkanchorplay.matchrandom.viewmodel;

import android.os.SystemClock;
import androidx.lifecycle.ViewModel;
import com.tencent.component.core.event.EventCenter;
import com.tencent.component.core.thread.ThreadCenter;
import com.tencent.mobileqq.qqlive.api.ILiveNetRequest;
import com.tencent.mobileqq.qqlive.api.sso.QQLiveResponse;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.now.linkpkanchorplay.event.UIEvent;
import com.tencent.now.linkpkanchorplay.matchrandom.datamodel.MatchRandomDataModel;
import com.tencent.now.linkpkanchorplay.sso.request.CancelMatchRequest;
import com.tencent.now.linkpkanchorplay.sso.request.CancelRankPKMatchRequest;
import com.tencent.qqlive.common.api.AegisLogger;

/* compiled from: P */
/* loaded from: classes22.dex */
public class MatchRandomViewModel extends ViewModel {
    private com.tencent.now.linkpkanchorplay.matchrandom.viewmodel.a C;
    private long D;

    /* renamed from: m, reason: collision with root package name */
    private MatchRandomDataModel f338377m;

    /* renamed from: i, reason: collision with root package name */
    private boolean f338376i = false;
    private boolean E = false;
    private Runnable F = new Runnable() { // from class: com.tencent.now.linkpkanchorplay.matchrandom.viewmodel.MatchRandomViewModel.3
        @Override // java.lang.Runnable
        public void run() {
            if (MatchRandomViewModel.this.C != null) {
                MatchRandomViewModel.this.C.c();
                MatchRandomViewModel.this.C = null;
                tm3.b.f436626a.a(0, null);
            }
        }
    };

    private void U1() {
        ThreadCenter.postDefaultUITask(this.F, 90000L);
    }

    private int W1(UIEvent.PKType pKType) {
        if (pKType == UIEvent.PKType.LinkPK) {
            return 3;
        }
        if (pKType == UIEvent.PKType.Rank_Normal_PK) {
            return 1;
        }
        if (pKType != UIEvent.PKType.Rank_Link_PK) {
            return 3;
        }
        return 2;
    }

    private MatchRandomDataModel X1() {
        if (this.f338377m == null) {
            this.f338377m = new MatchRandomDataModel();
        }
        return this.f338377m;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d2(QQLiveResponse qQLiveResponse) {
        if (qQLiveResponse.isFailed()) {
            AegisLogger.i("PK_Biz|MatchRandomViewModel", "cancelLinkPKMatch", "error, errCode=" + qQLiveResponse.getRetCode() + ", errMsg=" + qQLiveResponse.getErrMsg());
            return;
        }
        AegisLogger.i("PK_Biz|MatchRandomViewModel", "cancelLinkPKMatch success");
        this.E = true;
        f2();
        tm3.b.f436626a.a(0, null);
        X1().e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e2(QQLiveResponse qQLiveResponse) {
        if (qQLiveResponse.isFailed()) {
            AegisLogger.i("PK_Biz|MatchRandomViewModel", "cancelRankMatch", "error, errCode=" + qQLiveResponse.getRetCode() + ", errMsg=" + qQLiveResponse.getErrMsg());
            return;
        }
        AegisLogger.i("PK_Biz|MatchRandomViewModel", "cancelRankMatch success");
        this.E = true;
        f2();
        tm3.b.f436626a.a(0, null);
        X1().e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f2() {
        ThreadCenter.removeDefaultUITask(this.F);
        this.C = null;
    }

    public void S1() {
        tm3.a.f436625a.a(this.D);
        this.f338376i = false;
        if (!com.tencent.falco.base.downloader.utils.a.a()) {
            tm3.b.f436626a.a(0, null);
        }
        ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest(new CancelMatchRequest(), new ILiveNetRequest.Callback() { // from class: com.tencent.now.linkpkanchorplay.matchrandom.viewmodel.b
            @Override // com.tencent.mobileqq.qqlive.api.ILiveNetRequest.Callback
            public final void onResponse(QQLiveResponse qQLiveResponse) {
                MatchRandomViewModel.this.d2(qQLiveResponse);
            }
        });
    }

    public void T1(UIEvent.PKType pKType) {
        int W1 = W1(pKType);
        tm3.a.f436625a.d(W1, this.D);
        this.f338376i = false;
        ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest(new CancelRankPKMatchRequest(W1), new ILiveNetRequest.Callback() { // from class: com.tencent.now.linkpkanchorplay.matchrandom.viewmodel.c
            @Override // com.tencent.mobileqq.qqlive.api.ILiveNetRequest.Callback
            public final void onResponse(QQLiveResponse qQLiveResponse) {
                MatchRandomViewModel.this.e2(qQLiveResponse);
            }
        });
    }

    public boolean Z1() {
        return this.E;
    }

    public boolean a2() {
        return this.f338376i;
    }

    public void b2(long j3, UIEvent.PKType pKType, com.tencent.now.linkpkanchorplay.matchrandom.viewmodel.a aVar) {
        int W1 = W1(pKType);
        AegisLogger.i("PK_Biz|MatchRandomViewModel", "\u5f00\u59cb\u8fde\u5c4fPK\u968f\u673a\u5339\u914d, pkType:" + W1);
        this.f338376i = true;
        this.E = false;
        this.C = aVar;
        this.D = SystemClock.elapsedRealtime();
        X1().f(j3, new a(W1));
        U1();
        tm3.b.f436626a.c(pKType);
    }

    public void c2(long j3, UIEvent.PKType pKType, com.tencent.now.linkpkanchorplay.matchrandom.viewmodel.a aVar) {
        int W1 = W1(pKType);
        AegisLogger.i("PK_Biz|MatchRandomViewModel", "\u5f00\u59cb\u6392\u4f4d\u8d5b\u968f\u673a\u5339\u914d, pkType:" + W1);
        this.f338376i = true;
        this.E = false;
        this.C = aVar;
        this.D = SystemClock.currentThreadTimeMillis();
        X1().g(j3, W1, new b(W1));
        U1();
        tm3.b.f436626a.c(pKType);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        ThreadCenter.removeDefaultUITask(this.F);
        this.C = null;
        MatchRandomDataModel matchRandomDataModel = this.f338377m;
        if (matchRandomDataModel != null) {
            matchRandomDataModel.l();
            this.f338377m = null;
        }
        super.onCleared();
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class a implements MatchRandomDataModel.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f338378a;

        a(int i3) {
            this.f338378a = i3;
        }

        @Override // com.tencent.now.linkpkanchorplay.matchrandom.datamodel.MatchRandomDataModel.a
        public void a(e55.c cVar) {
            MatchRandomViewModel.this.f338376i = false;
            if (MatchRandomViewModel.this.C != null) {
                MatchRandomViewModel.this.C.a(cVar);
                tm3.b.f436626a.a(this.f338378a, cVar);
            }
            MatchRandomViewModel.this.f2();
            tm3.a.f436625a.c(cVar, MatchRandomViewModel.this.D);
        }

        @Override // com.tencent.now.linkpkanchorplay.matchrandom.datamodel.MatchRandomDataModel.a
        public void b(String str, boolean z16) {
            MatchRandomViewModel.this.f338376i = false;
            if (MatchRandomViewModel.this.C != null) {
                MatchRandomViewModel.this.C.b(str, z16);
            }
            MatchRandomViewModel.this.f2();
            tm3.a.f436625a.b(MatchRandomViewModel.this.D);
        }

        @Override // com.tencent.now.linkpkanchorplay.matchrandom.datamodel.MatchRandomDataModel.a
        public void c() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class b implements MatchRandomDataModel.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f338380a;

        b(int i3) {
            this.f338380a = i3;
        }

        @Override // com.tencent.now.linkpkanchorplay.matchrandom.datamodel.MatchRandomDataModel.a
        public void a(e55.c cVar) {
            MatchRandomViewModel.this.f338376i = false;
            if (MatchRandomViewModel.this.C != null) {
                MatchRandomViewModel.this.C.a(cVar);
                tm3.b.f436626a.a(this.f338380a, cVar);
                if (cVar != null) {
                    EventCenter.post(new hn3.c(cVar));
                }
            }
            MatchRandomViewModel.this.f2();
            tm3.a.f436625a.f(this.f338380a, cVar, MatchRandomViewModel.this.D);
        }

        @Override // com.tencent.now.linkpkanchorplay.matchrandom.datamodel.MatchRandomDataModel.a
        public void b(String str, boolean z16) {
            MatchRandomViewModel.this.f338376i = false;
            if (MatchRandomViewModel.this.C != null) {
                MatchRandomViewModel.this.C.b(str, z16);
            }
            MatchRandomViewModel.this.f2();
            tm3.a.f436625a.e(this.f338380a, MatchRandomViewModel.this.D);
        }

        @Override // com.tencent.now.linkpkanchorplay.matchrandom.datamodel.MatchRandomDataModel.a
        public void c() {
        }
    }
}
