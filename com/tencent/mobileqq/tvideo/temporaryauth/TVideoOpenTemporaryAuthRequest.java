package com.tencent.mobileqq.tvideo.temporaryauth;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.tvideo.net.base.TVideoBaseRequest;
import com.tencent.mobileqq.tvideo.net.utils.TVideoConfig;
import java.io.IOException;
import jy2.g;
import tvideo.TVideoTemporaryAuth$AuthorizePlayRequest;
import tvideo.TVideoTemporaryAuth$AuthorizePlayResponse;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TVideoOpenTemporaryAuthRequest extends TVideoBaseRequest {
    private int count;
    private String vid;

    public TVideoOpenTemporaryAuthRequest(String str, int i3) {
        this.vid = str;
        this.count = i3;
    }

    private void a(StringBuilder sb5, String str, int i3) {
        if (i3 == 0) {
            return;
        }
        sb5.append(str);
        sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
        sb5.append(i3);
        sb5.append(ContainerUtils.FIELD_DELIMITER);
    }

    private void b(StringBuilder sb5, String str, String str2) {
        c(sb5, str, str2, false);
    }

    private void c(StringBuilder sb5, String str, String str2, boolean z16) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        sb5.append(str);
        sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
        sb5.append(str2);
        if (!z16) {
            sb5.append(ContainerUtils.FIELD_DELIMITER);
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [T, com.tencent.mobileqq.pb.MessageMicro, tvideo.TVideoTemporaryAuth$AuthorizePlayResponse] */
    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public <T> T decode(byte[] bArr) {
        ?? r06 = (T) new TVideoTemporaryAuth$AuthorizePlayResponse();
        try {
            return (T) ((TVideoTemporaryAuth$AuthorizePlayResponse) r06.mergeFrom(bArr));
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
        return "/trpc.growth.video_server.VideoServer/AuthorizePlay";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getRequestByteData */
    protected byte[] get$pbReqBytes() {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        StringBuilder sb5 = new StringBuilder();
        a(sb5, "authorize_count", this.count);
        a(sb5, "authorize_pgid", 3);
        a(sb5, "authorize_source", 1);
        TVideoConfig tVideoConfig = TVideoConfig.f304492a;
        b(sb5, "qimei36", tVideoConfig.k());
        b(sb5, "time_stamp", currentTimeMillis + "");
        c(sb5, "vid", this.vid, true);
        TVideoTemporaryAuth$AuthorizePlayRequest tVideoTemporaryAuth$AuthorizePlayRequest = new TVideoTemporaryAuth$AuthorizePlayRequest();
        tVideoTemporaryAuth$AuthorizePlayRequest.authorize_source.set(1);
        tVideoTemporaryAuth$AuthorizePlayRequest.authorize_pgid.set(3);
        tVideoTemporaryAuth$AuthorizePlayRequest.vid.set(this.vid);
        tVideoTemporaryAuth$AuthorizePlayRequest.qimei36.set(tVideoConfig.k());
        tVideoTemporaryAuth$AuthorizePlayRequest.authorize_count.set(this.count);
        tVideoTemporaryAuth$AuthorizePlayRequest.time_stamp.set(currentTimeMillis);
        tVideoTemporaryAuth$AuthorizePlayRequest.sign.set(g.m(sb5.toString()));
        return tVideoTemporaryAuth$AuthorizePlayRequest.toByteArray();
    }
}
