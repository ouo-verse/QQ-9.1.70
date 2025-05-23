package com.tencent.mobileqq.tvideo.net.request;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.tvideo.net.base.TVideoBaseRequest;
import java.io.IOException;
import java.util.Map;
import tvideo.QueryVideoPlotListRequest;
import tvideo.QueryVideoPlotListResponse;

/* loaded from: classes19.dex */
public class TVideoPlotRequest extends TVideoBaseRequest {
    private final Map<String, String> pageContext;
    private final Map<String, String> pageParams;

    public TVideoPlotRequest(Map<String, String> map, Map<String, String> map2) {
        this.pageParams = map;
        this.pageContext = map2;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public <T> T decode(byte[] bArr) {
        T t16 = (T) new QueryVideoPlotListResponse.a().build();
        try {
            return (T) ((QueryVideoPlotListResponse) QueryVideoPlotListResponse.ADAPTER.decode(bArr));
        } catch (IOException e16) {
            e16.printStackTrace();
            return t16;
        }
    }

    @Override // com.tencent.mobileqq.tvideo.net.base.TVideoBaseRequest
    @NonNull
    public String getCallee() {
        return "trpc.growth.video_server.VideoServer";
    }

    @Override // com.tencent.mobileqq.tvideo.net.base.TVideoBaseRequest
    @NonNull
    public String getFunc() {
        return "/trpc.growth.video_server.VideoServer/QueryVideoPlotList";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        return new QueryVideoPlotListRequest.a().c(this.pageParams).b(this.pageContext).build().encode();
    }
}
