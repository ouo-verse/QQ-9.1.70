package com.tencent.mobileqq.tvideo.binge.data;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.haoliyou.sso.CheckForwardServlet;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.tvideo.net.base.TVideoBaseRequest;
import java.io.IOException;
import java.util.List;
import jy2.g;
import tvideo.TVideoBingeWatch$AlbumAtom;
import tvideo.TVideoBingeWatch$UpdateAlbumRequest;
import tvideo.TVideoBingeWatch$UpdateAlbumResponse;

/* compiled from: P */
/* loaded from: classes19.dex */
class TVideoBingeWatchStateUpdateRequest extends TVideoBaseRequest {
    private final TVideoBingeWatch$UpdateAlbumRequest request;

    public TVideoBingeWatchStateUpdateRequest(@TVideoBingeWatchOperationType int i3, List<TVideoBingeWatch$AlbumAtom> list, String str) {
        if (list != null && list.size() > 0) {
            TVideoBingeWatch$UpdateAlbumRequest tVideoBingeWatch$UpdateAlbumRequest = new TVideoBingeWatch$UpdateAlbumRequest();
            this.request = tVideoBingeWatch$UpdateAlbumRequest;
            tVideoBingeWatch$UpdateAlbumRequest.album_list.set(list);
            tVideoBingeWatch$UpdateAlbumRequest.option_type.set(i3);
            tVideoBingeWatch$UpdateAlbumRequest.source.set(str);
            tVideoBingeWatch$UpdateAlbumRequest.uid.set(g.r());
            return;
        }
        this.request = null;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [T, com.tencent.mobileqq.pb.MessageMicro, tvideo.TVideoBingeWatch$UpdateAlbumResponse] */
    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public <T> T decode(byte[] bArr) {
        ?? r06 = (T) new MessageMicro<TVideoBingeWatch$UpdateAlbumResponse>() { // from class: tvideo.TVideoBingeWatch$UpdateAlbumResponse
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{CheckForwardServlet.KEY_ERR_CODE, "err_msg"}, new Object[]{0, ""}, TVideoBingeWatch$UpdateAlbumResponse.class);
            public final PBInt32Field err_code = PBField.initInt32(0);
            public final PBStringField err_msg = PBField.initString("");
        };
        try {
            return (T) ((TVideoBingeWatch$UpdateAlbumResponse) r06.mergeFrom(bArr));
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
        return "/trpc.growth.video_server.VideoHistoryServer/UpdateAlbum";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        TVideoBingeWatch$UpdateAlbumRequest tVideoBingeWatch$UpdateAlbumRequest = this.request;
        if (tVideoBingeWatch$UpdateAlbumRequest != null) {
            return tVideoBingeWatch$UpdateAlbumRequest.toByteArray();
        }
        return new byte[0];
    }
}
