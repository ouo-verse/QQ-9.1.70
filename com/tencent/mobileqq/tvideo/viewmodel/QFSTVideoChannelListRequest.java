package com.tencent.mobileqq.tvideo.viewmodel;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.tvideo.net.base.TVideoBaseRequest;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tvideo.TVideoChannelList$GetVideoChannelListReq;
import tvideo.TVideoChannelList$GetVideoChannelListResp;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\n\u0018\u0000 \r2\u00020\u0001:\u0001\u000eB\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0014J\u001f\u0010\t\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0005H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/tvideo/viewmodel/QFSTVideoChannelListRequest;", "Lcom/tencent/mobileqq/tvideo/net/base/TVideoBaseRequest;", "", "getCallee", "getFunc", "", "getRequestByteData", "T", "buffer", "decode", "([B)Ljava/lang/Object;", "<init>", "()V", "Companion", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class QFSTVideoChannelListRequest extends TVideoBaseRequest {
    public QFSTVideoChannelListRequest() {
        super(null, 1, null);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [tvideo.TVideoChannelList$GetVideoChannelListResp, T, com.tencent.mobileqq.pb.MessageMicro] */
    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public <T> T decode(@Nullable byte[] buffer) {
        ?? r06 = (T) new TVideoChannelList$GetVideoChannelListResp();
        try {
            r06.mergeFrom(buffer);
        } catch (IOException e16) {
            e16.printStackTrace();
        }
        return r06;
    }

    @Override // com.tencent.mobileqq.tvideo.net.base.TVideoBaseRequest
    @NotNull
    public String getCallee() {
        return "trpc.growth.video_server.VideoServer";
    }

    @Override // com.tencent.mobileqq.tvideo.net.base.TVideoBaseRequest
    @NotNull
    public String getFunc() {
        return "/trpc.growth.video_server.VideoServer/QueryVideoChannel";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    protected byte[] getRequestByteData() {
        MessageMicro<TVideoChannelList$GetVideoChannelListReq> messageMicro = new MessageMicro<TVideoChannelList$GetVideoChannelListReq>() { // from class: tvideo.TVideoChannelList$GetVideoChannelListReq
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], TVideoChannelList$GetVideoChannelListReq.class);
        };
        QLog.d("QFSTVideoChannelListRequest", 4, "getRequestByteData request = " + messageMicro);
        byte[] byteArray = messageMicro.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "request.toByteArray()");
        return byteArray;
    }
}
