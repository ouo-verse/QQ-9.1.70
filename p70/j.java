package p70;

import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import circlesearch.CircleSearchExhibition$StSuggestionRsp;
import com.tencent.biz.qqcircle.immersive.request.search.QFSGetSearchSuggestRequest;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Objects;

/* compiled from: P */
/* loaded from: classes4.dex */
public class j extends com.tencent.biz.qqcircle.viewmodels.a {
    private String C;

    /* renamed from: m, reason: collision with root package name */
    private final MutableLiveData<UIStateData<List<g30.b>>> f425469m = new MutableLiveData<>();

    /* compiled from: P */
    /* loaded from: classes4.dex */
    private static class a implements VSDispatchObserver.OnVSRspCallBack<CircleSearchExhibition$StSuggestionRsp> {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<j> f425470a;

        a(j jVar) {
            this.f425470a = new WeakReference<>(jVar);
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, CircleSearchExhibition$StSuggestionRsp circleSearchExhibition$StSuggestionRsp) {
            QLog.d("QFSSearchSuggestViewModel", 1, "[requestSearchSuggest] onReceive: dispatch Success:" + z16 + " | TraceId:" + baseRequest.getTraceId() + " | SeqId:" + baseRequest.getCurrentSeq() + " | retCode:" + j3 + " | retMessage:" + str);
            j jVar = this.f425470a.get();
            if (jVar != null) {
                jVar.N1(z16, j3, str, circleSearchExhibition$StSuggestionRsp);
            }
            if (baseRequest instanceof QFSSearchBaseRequest) {
                ((QFSSearchBaseRequest) baseRequest).reportCmdSuccessRate(j3, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N1(boolean z16, long j3, String str, CircleSearchExhibition$StSuggestionRsp circleSearchExhibition$StSuggestionRsp) {
        if (circleSearchExhibition$StSuggestionRsp != null && z16 && j3 == 0) {
            this.f425469m.setValue(UIStateData.obtainSuccess(false).setData(false, g30.b.f(circleSearchExhibition$StSuggestionRsp.infos.get())));
        } else {
            this.f425469m.setValue(UIStateData.obtainError(str));
        }
    }

    public MutableLiveData<UIStateData<List<g30.b>>> M1() {
        return this.f425469m;
    }

    public void O1(g30.b bVar) {
        UIStateData<List<g30.b>> value = this.f425469m.getValue();
        Objects.requireNonNull(value);
        List<g30.b> data = value.getData();
        if (data != null && !data.isEmpty()) {
            data.remove(bVar);
            this.f425469m.setValue(UIStateData.obtainSuccess(false).setData(true, data));
        }
    }

    public void P1(String str) {
        this.C = str;
        if (TextUtils.isEmpty(str)) {
            this.f425469m.setValue(UIStateData.obtainEmpty());
        } else {
            sendRequest(new QFSGetSearchSuggestRequest.a().f(str).b(), new a(this));
        }
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSSearchSuggestViewModel";
    }
}
