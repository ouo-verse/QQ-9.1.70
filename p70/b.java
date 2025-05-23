package p70;

import androidx.lifecycle.MutableLiveData;
import circlesearch.CircleSearchExhibition$StSquareRsp;
import com.tencent.biz.qqcircle.immersive.views.searchsquare.request.QFSSquareGetDataRequest;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes4.dex */
public class b extends com.tencent.biz.qqcircle.viewmodels.a {
    private final MutableLiveData<UIStateData<CircleSearchExhibition$StSquareRsp>> C = new MutableLiveData<>();

    /* renamed from: m, reason: collision with root package name */
    private String f425448m;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    private static class a implements VSDispatchObserver.OnVSRspCallBack<CircleSearchExhibition$StSquareRsp> {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<b> f425449a;

        a(b bVar) {
            this.f425449a = new WeakReference<>(bVar);
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, CircleSearchExhibition$StSquareRsp circleSearchExhibition$StSquareRsp) {
            QLog.d("QFSSearchFeedChildBottomBannerViewModel", 1, "[requestSquareRelevantInfo] onReceive: dispatch Success:" + z16 + " | TraceId:" + baseRequest.getTraceId() + " | SeqId:" + baseRequest.getCurrentSeq() + " | retCode:" + j3 + " | retMessage:" + str);
            b bVar = this.f425449a.get();
            if (bVar != null) {
                bVar.M1(z16, j3, str, circleSearchExhibition$StSquareRsp);
            }
        }
    }

    public MutableLiveData<UIStateData<CircleSearchExhibition$StSquareRsp>> L1() {
        return this.C;
    }

    public void M1(boolean z16, long j3, String str, CircleSearchExhibition$StSquareRsp circleSearchExhibition$StSquareRsp) {
        if (circleSearchExhibition$StSquareRsp != null && z16 && j3 == 0) {
            this.C.setValue(UIStateData.obtainSuccess(false).setData(false, circleSearchExhibition$StSquareRsp));
        } else {
            this.C.setValue(UIStateData.obtainError(str));
        }
    }

    public void N1(String str) {
        this.f425448m = str;
        sendRequest(new QFSSquareGetDataRequest.a().g(2).f(this.f425448m).b(), new a(this));
    }

    public void O1() {
        this.C.setValue(null);
        this.f425448m = null;
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSSearchFeedChildBottomBannerViewModel";
    }
}
