package p70;

import androidx.lifecycle.MutableLiveData;
import circlesearch.CircleSearchExhibition$StPromptResp;
import com.tencent.biz.qqcircle.immersive.request.search.QFSGetSearchPromptRequest;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.biz.qqcircle.immersive.views.QFSVideoView;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import feedcloud.FeedCloudCommon$Entry;
import feedcloud.FeedCloudCommon$StCommonExt;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes4.dex */
public class e extends com.tencent.biz.qqcircle.viewmodels.a {

    /* renamed from: m, reason: collision with root package name */
    private final MutableLiveData<UIStateData<CircleSearchExhibition$StPromptResp>> f425453m = new MutableLiveData<>();

    /* compiled from: P */
    /* loaded from: classes4.dex */
    private static class a implements VSDispatchObserver.OnVSRspCallBack<CircleSearchExhibition$StPromptResp> {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<e> f425454a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean f425455b;

        a(e eVar, boolean z16) {
            this.f425454a = new WeakReference<>(eVar);
            this.f425455b = z16;
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, CircleSearchExhibition$StPromptResp circleSearchExhibition$StPromptResp) {
            QLog.d("QFSSearchPromptViewModel", 1, "[requestSearchPrompt] onReceive: dispatch Success:" + z16 + " | TraceId:" + baseRequest.getTraceId() + " | SeqId:" + baseRequest.getCurrentSeq() + " | retCode:" + j3 + " | retMessage:" + str);
            e eVar = this.f425454a.get();
            if (eVar != null) {
                eVar.N1(z16, j3, str, circleSearchExhibition$StPromptResp);
            }
            if (baseRequest instanceof QFSSearchBaseRequest) {
                ((QFSSearchBaseRequest) baseRequest).addReportExtraData(QFSSearchBaseRequest.EXTRA_KEY_IS_GUESS_REFRESH, String.valueOf(this.f425455b)).addSearchPromptRspExtraData(circleSearchExhibition$StPromptResp, z16, j3).reportCmdSuccessRate(j3, str);
            }
        }
    }

    private FeedCloudCommon$StCommonExt L1(String str) {
        FeedCloudCommon$StCommonExt feedCloudCommon$StCommonExt = new FeedCloudCommon$StCommonExt();
        QLog.d(getLogTag(), 1, "[generateExtInfo]current_video_id: " + QFSVideoView.L0() + APLogFileUtil.SEPARATOR_LOG + "guess_attach_info" + MsgSummary.STR_COLON + str);
        if (QFSVideoView.L0() != null) {
            FeedCloudCommon$Entry feedCloudCommon$Entry = new FeedCloudCommon$Entry();
            feedCloudCommon$Entry.key.set("current_video_id");
            feedCloudCommon$Entry.value.set(QFSVideoView.L0());
            feedCloudCommon$StCommonExt.mapInfo.get().add(feedCloudCommon$Entry);
        }
        if (str != null) {
            FeedCloudCommon$Entry feedCloudCommon$Entry2 = new FeedCloudCommon$Entry();
            feedCloudCommon$Entry2.key.set("guess_attach_info");
            feedCloudCommon$Entry2.value.set(str);
            feedCloudCommon$StCommonExt.mapInfo.get().add(feedCloudCommon$Entry2);
        }
        if (QFSVideoView.K0() > 0) {
            FeedCloudCommon$Entry feedCloudCommon$Entry3 = new FeedCloudCommon$Entry();
            feedCloudCommon$Entry3.key.set("click_id");
            feedCloudCommon$Entry3.value.set(QFSVideoView.K0() + "");
            feedCloudCommon$StCommonExt.mapInfo.get().add(feedCloudCommon$Entry3);
        }
        return feedCloudCommon$StCommonExt;
    }

    public MutableLiveData<UIStateData<CircleSearchExhibition$StPromptResp>> M1() {
        return this.f425453m;
    }

    public void N1(boolean z16, long j3, String str, CircleSearchExhibition$StPromptResp circleSearchExhibition$StPromptResp) {
        if (circleSearchExhibition$StPromptResp != null && z16 && j3 == 0) {
            this.f425453m.setValue(UIStateData.obtainSuccess(false).setData(false, circleSearchExhibition$StPromptResp));
        } else {
            this.f425453m.setValue(UIStateData.obtainError(str));
        }
    }

    public void O1(boolean z16, String str) {
        ArrayList arrayList = new ArrayList();
        if ((!h60.a.e() || z16) && r60.a.f430818a.b()) {
            arrayList.add(1);
        }
        if (!z16) {
            arrayList.add(3);
            arrayList.add(4);
            arrayList.add(5);
            if (r60.a.f430818a.a()) {
                arrayList.add(6);
            }
        }
        sendRequest(new QFSGetSearchPromptRequest.a().g(arrayList).f(L1(str)).b(), new a(this, z16));
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    public String getLogTag() {
        return "QFSSearchPromptViewModel";
    }
}
