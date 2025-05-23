package com.tencent.mobileqq.wink.ai.imagetext.model;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.requests.QCircleBaseRequest;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qshadow.QZoneAutoTexting$ImageTextingReq;
import qshadow.QZoneAutoTexting$ImageTextingRsp;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0012\n\u0002\b\u0004\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\u001d\u0010\u000e\u001a\u0002H\u000f\"\u0004\b\u0000\u0010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016\u00a2\u0006\u0002\u0010\u0012J\b\u0010\u0013\u001a\u00020\u0003H\u0016J\b\u0010\u0014\u001a\u00020\u0011H\u0014R\u001b\u0010\b\u001a\u00020\t8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/wink/ai/imagetext/model/WinkAIImageTextRequest;", "Lcom/tencent/mobileqq/qcircle/api/requests/QCircleBaseRequest;", "imageUrl", "", "originText", "isStream", "", "(Ljava/lang/String;Ljava/lang/String;Z)V", "req", "Lqshadow/QZoneAutoTexting$ImageTextingReq;", "getReq", "()Lqshadow/QZoneAutoTexting$ImageTextingReq;", "req$delegate", "Lkotlin/Lazy;", "decode", "T", "convertInputStreamtoByteArray", "", "([B)Ljava/lang/Object;", "getCmdName", "getRequestByteData", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public final class WinkAIImageTextRequest extends QCircleBaseRequest {

    /* renamed from: req$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy req;

    public /* synthetic */ WinkAIImageTextRequest(String str, String str2, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i3 & 4) != 0 ? true : z16);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [T, com.tencent.mobileqq.pb.MessageMicro, qshadow.QZoneAutoTexting$ImageTextingRsp] */
    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public <T> T decode(@Nullable byte[] convertInputStreamtoByteArray) {
        ?? r06 = (T) new QZoneAutoTexting$ImageTextingRsp();
        try {
            r06.mergeFrom(convertInputStreamtoByteArray);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return r06;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    public String getCmdName() {
        return "trpc.shadow_qq.trpc_gateway.LongTimeGateway.sso_auto_texting";
    }

    @NotNull
    public final QZoneAutoTexting$ImageTextingReq getReq() {
        return (QZoneAutoTexting$ImageTextingReq) this.req.getValue();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    protected byte[] getRequestByteData() {
        byte[] byteArray = getReq().toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "req.toByteArray()");
        return byteArray;
    }

    public WinkAIImageTextRequest(@NotNull final String imageUrl, @Nullable final String str, final boolean z16) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(imageUrl, "imageUrl");
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<QZoneAutoTexting$ImageTextingReq>() { // from class: com.tencent.mobileqq.wink.ai.imagetext.model.WinkAIImageTextRequest$req$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final QZoneAutoTexting$ImageTextingReq invoke() {
                List<String> listOf;
                QZoneAutoTexting$ImageTextingReq qZoneAutoTexting$ImageTextingReq = new QZoneAutoTexting$ImageTextingReq();
                String str2 = imageUrl;
                String str3 = str;
                boolean z17 = z16;
                PBRepeatField<String> pBRepeatField = qZoneAutoTexting$ImageTextingReq.imageUrls;
                listOf = CollectionsKt__CollectionsJVMKt.listOf(str2);
                pBRepeatField.set(listOf);
                PBStringField pBStringField = qZoneAutoTexting$ImageTextingReq.text;
                if (str3 == null) {
                    str3 = "";
                }
                pBStringField.set(str3);
                qZoneAutoTexting$ImageTextingReq.isStream.set(z17);
                return qZoneAutoTexting$ImageTextingReq;
            }
        });
        this.req = lazy;
    }
}
