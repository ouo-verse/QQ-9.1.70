package com.tencent.mobileqq.tvideo.pr;

import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import jy2.g;
import org.light.utils.CollectionUtils;
import tvideo.TVideoFloatPr$FlowPoolReportMap;
import tvideo.TVideoFloatPr$GetQqPromotionData;
import tvideo.TVideoFloatPr$GetQqPromotionResp;
import tvideo.TVideoQueryBubble$QueryBubbleInfoResp;
import tvideo.Video;
import tvideo.VideoBaseInfo;

/* compiled from: P */
/* loaded from: classes19.dex */
public class c extends com.tencent.biz.qqcircle.viewmodels.a {

    /* renamed from: m, reason: collision with root package name */
    public MutableLiveData<TVideoFloatPr$GetQqPromotionData> f304603m = new MutableLiveData<>();
    public MutableLiveData<String> C = new MutableLiveData<>();
    public volatile String D = "";

    private void N1(TVideoFloatPr$GetQqPromotionResp tVideoFloatPr$GetQqPromotionResp) {
        List<TVideoFloatPr$FlowPoolReportMap> list = tVideoFloatPr$GetQqPromotionResp.clientCtx.get();
        if (CollectionUtils.isEmpty(list)) {
            return;
        }
        for (TVideoFloatPr$FlowPoolReportMap tVideoFloatPr$FlowPoolReportMap : list) {
            if (tVideoFloatPr$FlowPoolReportMap != null) {
                String str = tVideoFloatPr$FlowPoolReportMap.key.get();
                String str2 = tVideoFloatPr$FlowPoolReportMap.value.get();
                if ("tag".equals(str) && !TextUtils.isEmpty(str2)) {
                    this.D = str2;
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void O1(BaseRequest baseRequest, boolean z16, long j3, String str, TVideoFloatPr$GetQqPromotionResp tVideoFloatPr$GetQqPromotionResp) {
        QLog.d("TVideoFloatPrViewModel", 1, "requestPrData isSuccess = " + z16 + " errMsg = " + str + " rsp = " + tVideoFloatPr$GetQqPromotionResp);
        if (tVideoFloatPr$GetQqPromotionResp != null && z16 && j3 == 0) {
            N1(tVideoFloatPr$GetQqPromotionResp);
            this.f304603m.setValue(tVideoFloatPr$GetQqPromotionResp.data);
        } else {
            this.f304603m.setValue(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void P1(BaseRequest baseRequest, boolean z16, long j3, String str, TVideoQueryBubble$QueryBubbleInfoResp tVideoQueryBubble$QueryBubbleInfoResp) {
        QLog.d("TVideoFloatPrViewModel", 1, "requestPullLongVideoData isSuccess = " + z16 + " errMsg = " + str + " rsp = " + tVideoQueryBubble$QueryBubbleInfoResp);
        if (tVideoQueryBubble$QueryBubbleInfoResp != null && z16 && j3 == 0) {
            this.C.setValue(tVideoQueryBubble$QueryBubbleInfoResp.data.url.get());
        }
    }

    public void Q1(f fVar) {
        QLog.d("TVideoFloatPrViewModel", 1, "requestPrData");
        this.D = "";
        sendRequest(new TVideoFloatPrRequest(fVar), new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.mobileqq.tvideo.pr.a
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                c.this.O1(baseRequest, z16, j3, str, (TVideoFloatPr$GetQqPromotionResp) obj);
            }
        });
    }

    public void R1(Video video) {
        QLog.d("TVideoFloatPrViewModel", 1, "requestPullLongVideoData");
        if (!g.C(video) && !g.J(video)) {
            QLog.d("TVideoFloatPrViewModel", 1, "notMiddleVideo or shortvideo");
            return;
        }
        VideoBaseInfo videoBaseInfo = video.video_base_info;
        sendRequest(new TVideoPullLongVideoRequest(videoBaseInfo.vid, videoBaseInfo.cid), new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.mobileqq.tvideo.pr.b
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                c.this.P1(baseRequest, z16, j3, str, (TVideoQueryBubble$QueryBubbleInfoResp) obj);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "TVideoFloatPrViewModel";
    }
}
