package com.tencent.mobileqq.tvideo.binge.data;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.tvideo.net.base.TVideoBaseRequest;
import java.io.IOException;
import java.util.List;
import tvideo.TVideoBingeWatch$GetUserAlbumInfoRequest;
import tvideo.TVideoBingeWatch$GetUserAlbumInfoResponse;

/* compiled from: P */
/* loaded from: classes19.dex */
class TVideoBingeWatchStateQueryRequest extends TVideoBaseRequest {
    private final TVideoBingeWatch$GetUserAlbumInfoRequest request;

    public TVideoBingeWatchStateQueryRequest(List<String> list) {
        if (list != null && list.size() > 0) {
            TVideoBingeWatch$GetUserAlbumInfoRequest tVideoBingeWatch$GetUserAlbumInfoRequest = new TVideoBingeWatch$GetUserAlbumInfoRequest();
            this.request = tVideoBingeWatch$GetUserAlbumInfoRequest;
            tVideoBingeWatch$GetUserAlbumInfoRequest.cover_ids.set(list);
            return;
        }
        this.request = null;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [tvideo.TVideoBingeWatch$GetUserAlbumInfoResponse, T, com.tencent.mobileqq.pb.MessageMicro] */
    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public <T> T decode(byte[] bArr) {
        ?? r06 = (T) new TVideoBingeWatch$GetUserAlbumInfoResponse();
        try {
            return (T) ((TVideoBingeWatch$GetUserAlbumInfoResponse) r06.mergeFrom(bArr));
        } catch (IOException e16) {
            e16.printStackTrace();
            return r06;
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
        return "/trpc.growth.video_server.VideoHistoryServer/GetUserAlbumInfo";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        TVideoBingeWatch$GetUserAlbumInfoRequest tVideoBingeWatch$GetUserAlbumInfoRequest = this.request;
        if (tVideoBingeWatch$GetUserAlbumInfoRequest != null) {
            return tVideoBingeWatch$GetUserAlbumInfoRequest.toByteArray();
        }
        return new byte[0];
    }
}
