package com.tencent.mobileqq.tvideo.viewmodel;

import com.squareup.wire.AnyMessage;
import com.squareup.wire.ProtoAdapter;
import com.tencent.mobileqq.tvideo.net.base.TVideoBaseRequest;
import com.tencent.mobileqq.tvideo.net.utils.TVideoConfig;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tvideo.protocol.pb.AdRequestContextInfo;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pw2.r;
import tvideo.GetVideoListReq;
import tvideo.GetVideoListResp;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00132\u00020\u0001:\u0001\u0014B\u0011\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\u0004\b\u0012\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0014J\u001f\u0010\t\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0005H\u0016\u00a2\u0006\u0004\b\t\u0010\nR$\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/tvideo/viewmodel/QFSTVideoFeedListRequest;", "Lcom/tencent/mobileqq/tvideo/net/base/TVideoBaseRequest;", "", "getCallee", "getFunc", "", "getRequestByteData", "T", "buffer", "decode", "([B)Ljava/lang/Object;", "Lcom/tencent/mobileqq/tvideo/viewmodel/k;", "requestParams", "Lcom/tencent/mobileqq/tvideo/viewmodel/k;", "getRequestParams", "()Lcom/tencent/mobileqq/tvideo/viewmodel/k;", "setRequestParams", "(Lcom/tencent/mobileqq/tvideo/viewmodel/k;)V", "<init>", "Companion", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class QFSTVideoFeedListRequest extends TVideoBaseRequest {
    public static final int CHANNEL_ID_DEFAULT = 1;
    public static final int CHANNEL_TYPE_DEFAULT = 0;
    public static final int PAGE_SIZE = 5;

    @Nullable
    private k requestParams;

    public QFSTVideoFeedListRequest(@Nullable k kVar) {
        super(null, 1, 0 == true ? 1 : 0);
        this.requestParams = kVar;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public <T> T decode(@Nullable byte[] buffer) {
        ProtoAdapter<GetVideoListResp> protoAdapter = GetVideoListResp.ADAPTER;
        Intrinsics.checkNotNull(buffer);
        return (T) ((GetVideoListResp) protoAdapter.decode(buffer));
    }

    @Override // com.tencent.mobileqq.tvideo.net.base.TVideoBaseRequest
    @NotNull
    public String getCallee() {
        return "trpc.growth_qq_feeds.feed_svr.rpc";
    }

    @Override // com.tencent.mobileqq.tvideo.net.base.TVideoBaseRequest
    @NotNull
    public String getFunc() {
        return "/trpc.growth_qq_feeds.feed_svr.Feed/GetVideoList";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    protected byte[] getRequestByteData() {
        int i3;
        String str;
        Map<String, String> linkedHashMap;
        int i16 = 0;
        int i17 = 1;
        if (jy2.g.h() == 0) {
            i3 = 0;
        } else {
            i3 = 1;
        }
        GetVideoListReq.a g16 = new GetVideoListReq.a().g(5);
        k kVar = this.requestParams;
        if (kVar != null) {
            i16 = kVar.getPageNum();
        }
        GetVideoListReq.a f16 = g16.f(i16);
        String r16 = jy2.g.r();
        Intrinsics.checkNotNullExpressionValue(r16, "getUin()");
        GetVideoListReq.a h16 = f16.h(Long.parseLong(r16));
        k kVar2 = this.requestParams;
        if (kVar2 != null) {
            i17 = kVar2.getChannelId();
        }
        GetVideoListReq.a j3 = h16.c(i17).j("mobileQQFeeds");
        k kVar3 = this.requestParams;
        if (kVar3 == null || (str = kVar3.getReserveVid()) == null) {
            str = "";
        }
        GetVideoListReq.a k3 = j3.i(str).k(i3);
        AnyMessage.Companion companion = AnyMessage.INSTANCE;
        AdRequestContextInfo d16 = r.d(pw2.b.a(), TVideoConfig.f304492a.b());
        Intrinsics.checkNotNullExpressionValue(d16, "createAdRequestContextIn\u2026                        )");
        GetVideoListReq.a a16 = k3.a(companion.pack(d16));
        k kVar4 = this.requestParams;
        if (kVar4 == null || (linkedHashMap = kVar4.b()) == null) {
            linkedHashMap = new LinkedHashMap<>();
        }
        GetVideoListReq build = a16.e(linkedHashMap).build();
        QLog.d("QFSTVideoPageListRequest", 4, "getRequestByteData request = " + build);
        return build.encode();
    }

    @Nullable
    public final k getRequestParams() {
        return this.requestParams;
    }

    public final void setRequestParams(@Nullable k kVar) {
        this.requestParams = kVar;
    }
}
