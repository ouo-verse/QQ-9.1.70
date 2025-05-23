package com.tencent.mobileqq.tvideo.viewmodel;

import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.tvideo.net.request.TVideoPlotRequest;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tvideo.QueryVideoPlotListResponse;
import tvideo.VideoPlot;
import tvideo.VideoPlotDetails;

/* compiled from: P */
/* loaded from: classes19.dex */
public class h extends com.tencent.biz.qqcircle.viewmodels.a {
    private String C;
    private int D;

    /* renamed from: m, reason: collision with root package name */
    public MutableLiveData<VideoPlotDetails> f304835m = new MutableLiveData<>();
    private VideoPlotDetails E = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class a implements VSDispatchObserver.OnVSRspCallBack<QueryVideoPlotListResponse> {
        a() {
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, QueryVideoPlotListResponse queryVideoPlotListResponse) {
            QLog.d("QFSTVideoEpisodeViewModel", 4, "requestPlot isSuccess = " + z16 + " errMsg = " + str + " rsp = " + queryVideoPlotListResponse);
            if (queryVideoPlotListResponse != null && z16 && j3 == 0) {
                h.this.Q1(queryVideoPlotListResponse.data);
                if (h.this.R1(queryVideoPlotListResponse.data)) {
                    h hVar = h.this;
                    hVar.S1(hVar.C, h.this.D + 1, queryVideoPlotListResponse.data.page_context);
                    return;
                } else {
                    h hVar2 = h.this;
                    hVar2.f304835m.setValue(hVar2.E);
                    return;
                }
            }
            h hVar3 = h.this;
            hVar3.f304835m.setValue(hVar3.E);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q1(VideoPlotDetails videoPlotDetails) {
        List<VideoPlot> list;
        List<VideoPlot> list2;
        ArrayList arrayList = new ArrayList();
        VideoPlotDetails videoPlotDetails2 = this.E;
        if (videoPlotDetails2 != null && (list2 = videoPlotDetails2.video_plot_list) != null) {
            arrayList.addAll(list2);
        }
        if (videoPlotDetails != null && (list = videoPlotDetails.video_plot_list) != null) {
            arrayList.addAll(list);
            this.E = videoPlotDetails.newBuilder().k(arrayList).build();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean R1(VideoPlotDetails videoPlotDetails) {
        if (videoPlotDetails == null) {
            return false;
        }
        return videoPlotDetails.has_next;
    }

    public void S1(String str, int i3, Map<String, String> map) {
        this.C = str;
        this.D = i3;
        QLog.d("QFSTVideoEpisodeViewModel", 4, "requestPlot cid = " + str);
        HashMap hashMap = new HashMap();
        hashMap.put("cid", str);
        hashMap.put("page_num", i3 + "");
        hashMap.put("page_size", "50");
        sendRequest(new TVideoPlotRequest(hashMap, map), new a());
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSTVideoEpisodeViewModel";
    }
}
