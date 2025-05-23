package com.tencent.biz.qqcircle.immersive.personal.viewmodel;

import android.app.Activity;
import android.content.Context;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.immersive.personal.request.QFSPersonalGuildInfoRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import feedcloud.FeedCloudRead$GetGuildListRsp;
import feedcloud.FeedCloudRead$GuildInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class n extends com.tencent.biz.qqcircle.viewmodels.a {
    public static final String H = "com.tencent.biz.qqcircle.immersive.personal.viewmodel.n";
    private boolean E;

    /* renamed from: m, reason: collision with root package name */
    private Context f89155m;
    private final List<com.tencent.biz.qqcircle.immersive.personal.bean.l> C = new ArrayList();
    private long D = 0;
    private final MutableLiveData<Long> F = new MutableLiveData<>();
    private final MutableLiveData<UIStateData<List<com.tencent.biz.qqcircle.immersive.personal.bean.l>>> G = new MutableLiveData<>();

    private com.tencent.biz.qqcircle.immersive.personal.bean.l M1() {
        com.tencent.biz.qqcircle.immersive.personal.bean.l lVar = new com.tencent.biz.qqcircle.immersive.personal.bean.l();
        lVar.e(this.f89155m.getResources().getString(R.string.f19270488));
        lVar.d(0L);
        return lVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: P1, reason: merged with bridge method [inline-methods] */
    public void S1(BaseRequest baseRequest, FeedCloudRead$GetGuildListRsp feedCloudRead$GetGuildListRsp, boolean z16, long j3, String str) {
        if (!(baseRequest instanceof QFSPersonalGuildInfoRequest)) {
            QLog.e(H, 1, "[handleGetGuildListResponse] invalid request");
            return;
        }
        boolean isProtocolCache = VSNetworkHelper.isProtocolCache(str);
        QLog.d(getTAG(), 1, "handleGetGuildListResponse: retCode:" + j3 + ",isSuccess:" + z16 + "isCache:" + isProtocolCache);
        QFSPersonalGuildInfoRequest qFSPersonalGuildInfoRequest = (QFSPersonalGuildInfoRequest) baseRequest;
        if (z16 && j3 == 0 && feedCloudRead$GetGuildListRsp != null) {
            List<com.tencent.biz.qqcircle.immersive.personal.bean.l> X1 = X1(feedCloudRead$GetGuildListRsp.guilds.get());
            this.C.clear();
            if (X1.size() == 0) {
                this.G.setValue(UIStateData.obtainEmpty().setData(false, this.C).setLoadMore(false).setFinish(true));
                return;
            }
            UIStateData<List<com.tencent.biz.qqcircle.immersive.personal.bean.l>> finish = UIStateData.obtainSuccess(isProtocolCache).setFinish(true);
            this.C.add(M1());
            this.C.addAll(X1);
            Q1();
            finish.setData(false, this.C);
            this.G.setValue(finish);
            return;
        }
        QLog.e(getTAG(), 1, "[requestData] onReceive dispatch Error: | TraceId:" + qFSPersonalGuildInfoRequest.getTraceId() + " | SeqId:" + qFSPersonalGuildInfoRequest.getCurrentSeq() + " | retCode:" + j3 + " | isCache:" + isProtocolCache + " | retMessage:" + str);
        UIStateData<List<com.tencent.biz.qqcircle.immersive.personal.bean.l>> obtainError = UIStateData.obtainError(str);
        obtainError.setData(false, this.C).setFinish(true);
        obtainError.setRetCode(j3);
        this.G.setValue(obtainError);
    }

    private void Q1() {
        if (this.C.size() == 0) {
            return;
        }
        if (this.D != 0) {
            for (com.tencent.biz.qqcircle.immersive.personal.bean.l lVar : this.C) {
                if (lVar.a() == this.D) {
                    lVar.f(true);
                } else {
                    lVar.f(false);
                }
            }
            return;
        }
        if (this.C.size() - 1 > 0) {
            this.C.get(0).f(true);
        }
    }

    private void W1() {
        this.G.setValue(UIStateData.obtainLoading());
    }

    private List<com.tencent.biz.qqcircle.immersive.personal.bean.l> X1(List<FeedCloudRead$GuildInfo> list) {
        ArrayList arrayList = new ArrayList();
        for (FeedCloudRead$GuildInfo feedCloudRead$GuildInfo : list) {
            if (feedCloudRead$GuildInfo != null) {
                com.tencent.biz.qqcircle.immersive.personal.bean.l lVar = new com.tencent.biz.qqcircle.immersive.personal.bean.l();
                lVar.d(feedCloudRead$GuildInfo.guildId.get());
                lVar.e(feedCloudRead$GuildInfo.name.get());
                arrayList.add(lVar);
            }
        }
        return arrayList;
    }

    public MutableLiveData<Long> N1() {
        return this.F;
    }

    public MutableLiveData<UIStateData<List<com.tencent.biz.qqcircle.immersive.personal.bean.l>>> O1() {
        return this.G;
    }

    public void R1(Context context, long j3, boolean z16) {
        this.D = j3;
        this.f89155m = context;
        this.E = z16;
    }

    public void T1() {
        W1();
        QFSPersonalGuildInfoRequest qFSPersonalGuildInfoRequest = new QFSPersonalGuildInfoRequest();
        qFSPersonalGuildInfoRequest.setEnableCache(true);
        VSNetworkHelper.getInstance().sendRequest(qFSPersonalGuildInfoRequest, new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.biz.qqcircle.immersive.personal.viewmodel.m
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                n.this.S1(baseRequest, z16, j3, str, (FeedCloudRead$GetGuildListRsp) obj);
            }
        });
    }

    public void U1(Activity activity) {
        com.tencent.biz.qqcircle.immersive.personal.bean.s sVar;
        if (this.C.size() > 0) {
            Iterator<com.tencent.biz.qqcircle.immersive.personal.bean.l> it = this.C.iterator();
            while (true) {
                if (it.hasNext()) {
                    com.tencent.biz.qqcircle.immersive.personal.bean.l next = it.next();
                    if (this.D == next.a()) {
                        sVar = new com.tencent.biz.qqcircle.immersive.personal.bean.s(next);
                        sVar.h(this.E);
                        break;
                    }
                } else {
                    sVar = null;
                    break;
                }
            }
            if (sVar != null) {
                com.tencent.biz.qqcircle.immersive.personal.utils.g.e().h(sVar, activity);
                return;
            }
            return;
        }
        QLog.e(H, 1, "[sendSaveGuildBindInfoProfile]: select null");
    }

    public void Z1() {
        if (this.G.getValue() == null) {
            QLog.e(H, 1, "[updateSelectStatus]: personalGuildInfo is null");
            return;
        }
        List<com.tencent.biz.qqcircle.immersive.personal.bean.l> data = this.G.getValue().getData();
        if (data != null && data.size() != 0) {
            if (this.F.getValue() != null && this.F.getValue().longValue() != 0) {
                for (com.tencent.biz.qqcircle.immersive.personal.bean.l lVar : data) {
                    if (lVar.a() == this.F.getValue().longValue()) {
                        lVar.f(true);
                        this.D = lVar.a();
                    } else {
                        lVar.f(false);
                    }
                }
            } else {
                for (com.tencent.biz.qqcircle.immersive.personal.bean.l lVar2 : data) {
                    if (lVar2.a() == 0) {
                        lVar2.f(true);
                        this.D = 0L;
                    } else {
                        lVar2.f(false);
                    }
                }
            }
            UIStateData<List<com.tencent.biz.qqcircle.immersive.personal.bean.l>> finish = UIStateData.obtainSuccess(false).setFinish(true);
            finish.setData(false, data);
            this.G.setValue(finish);
            return;
        }
        QLog.e(H, 1, "[updateSelectStatus]: personalGuildInfo is empty");
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return H;
    }
}
