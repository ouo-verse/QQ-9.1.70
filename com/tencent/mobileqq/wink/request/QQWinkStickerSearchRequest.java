package com.tencent.mobileqq.wink.request;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.requests.QCircleBaseRequest;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.LightEngine;
import qshadow.ShadowStickerSearch$CircleEditFirstSearchReq;
import qshadow.ShadowStickerSearch$CircleEditFirstSearchRsp;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00102\u00020\u0001:\u0001\u0011B\u000f\u0012\u0006\u0010\r\u001a\u00020\u0004\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0014J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u001f\u0010\b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0016\u00a2\u0006\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/wink/request/QQWinkStickerSearchRequest;", "Lcom/tencent/mobileqq/qcircle/api/requests/QCircleBaseRequest;", "", "getRequestByteData", "", "getCmdName", "T", "convertInputStreamtoByteArray", "decode", "([B)Ljava/lang/Object;", "Lqshadow/ShadowStickerSearch$CircleEditFirstSearchReq;", "mReq", "Lqshadow/ShadowStickerSearch$CircleEditFirstSearchReq;", "keyword", "<init>", "(Ljava/lang/String;)V", "Companion", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class QQWinkStickerSearchRequest extends QCircleBaseRequest {
    public static final int FIRST_EXPRESSION_PAGE_SIZE = 200;
    public static final int FIRST_STICKER_PAGE_SIZE = 100;

    @NotNull
    private ShadowStickerSearch$CircleEditFirstSearchReq mReq;

    public QQWinkStickerSearchRequest(@NotNull String keyword) {
        List split$default;
        List take;
        String joinToString$default;
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        ShadowStickerSearch$CircleEditFirstSearchReq shadowStickerSearch$CircleEditFirstSearchReq = new ShadowStickerSearch$CircleEditFirstSearchReq();
        shadowStickerSearch$CircleEditFirstSearchReq.search_text.set(keyword);
        shadowStickerSearch$CircleEditFirstSearchReq.first_sticker_page_size.set(100);
        shadowStickerSearch$CircleEditFirstSearchReq.first_expression_page_size.set(200);
        PBStringField pBStringField = shadowStickerSearch$CircleEditFirstSearchReq.lightsdk_version;
        String version = LightEngine.version();
        Intrinsics.checkNotNullExpressionValue(version, "version()");
        split$default = StringsKt__StringsKt.split$default((CharSequence) version, new String[]{"."}, false, 0, 6, (Object) null);
        take = CollectionsKt___CollectionsKt.take(split$default, 3);
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(take, ".", null, null, 0, null, null, 62, null);
        pBStringField.set(joinToString$default);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            shadowStickerSearch$CircleEditFirstSearchReq.uin.set(peekAppRuntime.getCurrentUin());
        }
        this.mReq = shadowStickerSearch$CircleEditFirstSearchReq;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [T, com.tencent.mobileqq.pb.MessageMicro, qshadow.ShadowStickerSearch$CircleEditFirstSearchRsp] */
    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public <T> T decode(@Nullable byte[] convertInputStreamtoByteArray) {
        ?? r06 = (T) new ShadowStickerSearch$CircleEditFirstSearchRsp();
        try {
            r06.mergeFrom(convertInputStreamtoByteArray);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return r06;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    /* renamed from: getCmdName */
    public String get$cmd() {
        return "trpc.shadow_qq.trpc_gateway.TrpcGateway.sso_circle_edit_first_search";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    /* renamed from: getRequestByteData */
    protected byte[] get$pbReqBytes() {
        byte[] byteArray = this.mReq.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "mReq.toByteArray()");
        return byteArray;
    }
}
