package com.tencent.biz.qqcircle.immersive.personal.viewmodel;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.sender.call.Call;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class e extends BaseViewModel implements Call.OnRspCallBack<QCircleBaseRequest> {
    private String C;

    /* renamed from: i, reason: collision with root package name */
    private final com.tencent.biz.qqcircle.immersive.personal.interceptor.e f89137i = new com.tencent.biz.qqcircle.immersive.personal.interceptor.e();

    /* renamed from: m, reason: collision with root package name */
    private final MutableLiveData<com.tencent.biz.qqcircle.immersive.personal.bean.d> f89138m;

    public e() {
        MutableLiveData<com.tencent.biz.qqcircle.immersive.personal.bean.d> mutableLiveData = new MutableLiveData<>();
        this.f89138m = mutableLiveData;
        mutableLiveData.setValue(new com.tencent.biz.qqcircle.immersive.personal.bean.d());
    }

    public com.tencent.biz.qqcircle.immersive.personal.bean.d L1() {
        com.tencent.biz.qqcircle.immersive.personal.bean.d value = this.f89138m.getValue();
        if (value == null) {
            return new com.tencent.biz.qqcircle.immersive.personal.bean.d();
        }
        return value;
    }

    public MutableLiveData<com.tencent.biz.qqcircle.immersive.personal.bean.d> M1() {
        return this.f89138m;
    }

    public com.tencent.biz.qqcircle.immersive.personal.interceptor.e N1() {
        return this.f89137i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.richframework.sender.call.Call.OnRspCallBack
    /* renamed from: O1, reason: merged with bridge method [inline-methods] */
    public void onReceive(boolean z16, long j3, String str, QCircleBaseRequest qCircleBaseRequest, Object obj, Bundle bundle) {
        QLog.i("QFSJustWatchedViewModel", 1, "[onReceive] -> traceId : " + qCircleBaseRequest.getTraceId() + " , isSuccess : " + z16 + " , retCode : " + j3 + " , errMsg : " + str);
        if ((qCircleBaseRequest instanceof com.tencent.biz.qqcircle.immersive.personal.request.a) && TextUtils.equals(this.C, ((com.tencent.biz.qqcircle.immersive.personal.request.a) qCircleBaseRequest).getPreFeedId())) {
            if (z16) {
                if (obj instanceof UIStateData) {
                    Iterator it = ((List) ((UIStateData) obj).getData()).iterator();
                    while (it.hasNext()) {
                        if (TextUtils.equals(((e30.b) it.next()).g().f398449id.get(), this.C)) {
                            U1(true);
                            return;
                        }
                    }
                }
                QLog.i("QFSJustWatchedViewModel", 1, "getJustWatchedData failure! -> traceId = " + qCircleBaseRequest.getTraceId() + " , feedId = " + this.C);
                return;
            }
            return;
        }
        QLog.i("QFSJustWatchedViewModel", 1, "[getJustWatchedData] -> feedId is not same! mPreFeedId = " + this.C);
    }

    public void P1(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        this.C = feedCloudMeta$StFeed.f398449id.get();
        com.tencent.biz.qqcircle.immersive.personal.request.b.m(feedCloudMeta$StFeed.poster.f398463id.get(), this.f89137i, this, feedCloudMeta$StFeed.f398449id.get(), feedCloudMeta$StFeed.createTime.get());
    }

    public void Q1() {
        this.C = "";
        com.tencent.biz.qqcircle.immersive.personal.bean.d L1 = L1();
        L1().f(false);
        L1().k(false);
        L1().j(false);
        L1().g(false);
        L1().e(false);
        L1().i(true);
        this.f89138m.setValue(L1);
    }

    public void R1(boolean z16) {
        com.tencent.biz.qqcircle.immersive.personal.bean.d L1 = L1();
        if (L1.a() == z16) {
            return;
        }
        L1.g(z16);
        this.f89138m.setValue(L1);
    }

    public void S1(boolean z16) {
        com.tencent.biz.qqcircle.immersive.personal.bean.d L1 = L1();
        if (L1.b() == z16) {
            return;
        }
        L1.h(z16);
        this.f89138m.setValue(L1);
    }

    public void T1(boolean z16) {
        com.tencent.biz.qqcircle.immersive.personal.bean.d L1 = L1();
        if (L1.c() == z16) {
            return;
        }
        L1.i(z16);
        this.f89138m.setValue(L1);
    }

    public void U1(boolean z16) {
        com.tencent.biz.qqcircle.immersive.personal.bean.d L1 = L1();
        if (L1.d() == z16) {
            return;
        }
        L1.k(z16);
        this.f89138m.setValue(L1);
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSJustWatchedViewModel";
    }
}
