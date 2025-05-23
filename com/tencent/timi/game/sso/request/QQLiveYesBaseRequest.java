package com.tencent.timi.game.sso.request;

import com.google.protobuf.nano.MessageNano;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qqlive.api.sso.LiveBaseRequest;
import com.tencent.mobileqq.qqlive.config.QQLiveBusinessConfig;
import com.tencent.mobileqq.utils.fh;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.timi.game.utils.c;
import com.tencent.util.QQDeviceInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.BaseInterfaceOuterClass$CSQQAccessBaseInfo;
import trpc.yes.common.BaseInterfaceOuterClass$CSQQAccessReply;
import trpc.yes.common.BaseInterfaceOuterClass$CSQQAccessReqHeader;
import trpc.yes.common.BaseInterfaceOuterClass$CSQQAccessRequest;
import trpc.yes.common.BaseInterfaceOuterClass$CSQQAccessRspHeader;
import trpc.yes.common.BaseInterfaceOuterClass$NetInfo;
import trpc.yes.common.BaseInterfaceOuterClass$Terminal;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0005\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u000e\u001a\u00020\rH&J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0011\u001a\u00020\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u000fH\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\u0010\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0015H\u0014J\u001f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0017H\u0016\u00a2\u0006\u0004\b\u001c\u0010\u001d\u00a8\u0006 "}, d2 = {"Lcom/tencent/timi/game/sso/request/QQLiveYesBaseRequest;", "T", "Lcom/tencent/mobileqq/qqlive/api/sso/LiveBaseRequest;", "", "a", "Ltrpc/yes/common/BaseInterfaceOuterClass$Terminal;", "e", "Ltrpc/yes/common/BaseInterfaceOuterClass$NetInfo;", "c", "Ltrpc/yes/common/BaseInterfaceOuterClass$CSQQAccessBaseInfo;", "b", "Ltrpc/yes/common/BaseInterfaceOuterClass$CSQQAccessReqHeader;", "d", "", "getHeaderCmd", "", "getCmdName", "getMainCmd", "getSubCmd", "Lcom/google/protobuf/nano/MessageNano;", "getMessageNano", "Lcom/tencent/mobileqq/pb/ByteStringMicro;", "requestBizData", "", "getRequestWrapper", "responseBytes", "", "", "parseResponseHeadInfo", "([B)[Ljava/lang/Object;", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public abstract class QQLiveYesBaseRequest<T> extends LiveBaseRequest<T> {
    public QQLiveYesBaseRequest() {
        super(QQLiveBusinessConfig.QQLIVE_APP_ID);
    }

    private final boolean a() {
        return false;
    }

    private final BaseInterfaceOuterClass$CSQQAccessBaseInfo b() {
        BaseInterfaceOuterClass$CSQQAccessBaseInfo baseInterfaceOuterClass$CSQQAccessBaseInfo = new BaseInterfaceOuterClass$CSQQAccessBaseInfo();
        baseInterfaceOuterClass$CSQQAccessBaseInfo.terminal.set(e());
        baseInterfaceOuterClass$CSQQAccessBaseInfo.net_info.set(c());
        return baseInterfaceOuterClass$CSQQAccessBaseInfo;
    }

    private final BaseInterfaceOuterClass$NetInfo c() {
        BaseInterfaceOuterClass$NetInfo baseInterfaceOuterClass$NetInfo = new BaseInterfaceOuterClass$NetInfo();
        baseInterfaceOuterClass$NetInfo.client_ip.set(c.b().c());
        return baseInterfaceOuterClass$NetInfo;
    }

    private final BaseInterfaceOuterClass$CSQQAccessReqHeader d() {
        BaseInterfaceOuterClass$CSQQAccessReqHeader baseInterfaceOuterClass$CSQQAccessReqHeader = new BaseInterfaceOuterClass$CSQQAccessReqHeader();
        baseInterfaceOuterClass$CSQQAccessReqHeader.cmd.set(getHeaderCmd());
        return baseInterfaceOuterClass$CSQQAccessReqHeader;
    }

    private final BaseInterfaceOuterClass$Terminal e() {
        BaseInterfaceOuterClass$Terminal baseInterfaceOuterClass$Terminal = new BaseInterfaceOuterClass$Terminal();
        baseInterfaceOuterClass$Terminal.qimei.set(QQDeviceInfo.getQIMEI());
        baseInterfaceOuterClass$Terminal.phone_system.set(2);
        baseInterfaceOuterClass$Terminal.platform_type.set(2);
        baseInterfaceOuterClass$Terminal.client_version.set(c.b().a());
        return baseInterfaceOuterClass$Terminal;
    }

    @Override // com.tencent.mobileqq.qqlive.api.sso.LiveBaseRequest, com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    /* renamed from: getCmdName */
    public String get$cmd() {
        return "trpc.yes.qq_access_proxy.QQAccess.ClientDo";
    }

    public abstract int getHeaderCmd();

    @Override // com.tencent.mobileqq.qqlive.api.sso.LiveBaseRequest
    @NotNull
    /* renamed from: getMainCmd */
    public String getService() {
        return "";
    }

    @Override // com.tencent.mobileqq.qqlive.api.sso.LiveBaseRequest
    @NotNull
    public MessageNano getMessageNano() {
        throw new RuntimeException("this request cannot use this method");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qqlive.api.sso.LiveBaseRequest, com.tencent.biz.richframework.network.request.VSBaseRequest
    @NotNull
    public byte[] getRequestWrapper(@NotNull ByteStringMicro requestBizData) {
        Intrinsics.checkNotNullParameter(requestBizData, "requestBizData");
        BaseInterfaceOuterClass$CSQQAccessRequest baseInterfaceOuterClass$CSQQAccessRequest = new BaseInterfaceOuterClass$CSQQAccessRequest();
        baseInterfaceOuterClass$CSQQAccessRequest.base_info.set(b());
        baseInterfaceOuterClass$CSQQAccessRequest.req_header.set(d());
        if (a()) {
            baseInterfaceOuterClass$CSQQAccessRequest.body_type.set(1);
        }
        baseInterfaceOuterClass$CSQQAccessRequest.req_body.set(ByteStringMicro.copyFrom(get$pbReqBytes()));
        byte[] byteArray = baseInterfaceOuterClass$CSQQAccessRequest.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "CSQQAccessRequest().appl\u2026)\n        }.toByteArray()");
        return byteArray;
    }

    @Override // com.tencent.mobileqq.qqlive.api.sso.LiveBaseRequest
    @NotNull
    /* renamed from: getSubCmd */
    public String getMethod() {
        return "";
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0075 A[Catch: InvalidProtocolBufferMicroException -> 0x008d, TryCatch #0 {InvalidProtocolBufferMicroException -> 0x008d, blocks: (B:3:0x0016, B:5:0x0028, B:8:0x002d, B:10:0x0035, B:11:0x006f, B:13:0x0075, B:14:0x0084, B:18:0x007a, B:19:0x0054, B:20:0x0062), top: B:2:0x0016 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x007a A[Catch: InvalidProtocolBufferMicroException -> 0x008d, TryCatch #0 {InvalidProtocolBufferMicroException -> 0x008d, blocks: (B:3:0x0016, B:5:0x0028, B:8:0x002d, B:10:0x0035, B:11:0x006f, B:13:0x0075, B:14:0x0084, B:18:0x007a, B:19:0x0054, B:20:0x0062), top: B:2:0x0016 }] */
    @Override // com.tencent.mobileqq.qqlive.api.sso.LiveBaseRequest, com.tencent.biz.richframework.network.request.VSBaseRequest, com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object[] parseResponseHeadInfo(@Nullable byte[] responseBytes) {
        BaseInterfaceOuterClass$CSQQAccessReply baseInterfaceOuterClass$CSQQAccessReply;
        byte[] byteArray;
        BaseInterfaceOuterClass$CSQQAccessRspHeader baseInterfaceOuterClass$CSQQAccessRspHeader;
        Object[] objArr = {-1, "\u5e8f\u5217\u5316\u5f02\u5e38", new byte[0]};
        try {
            baseInterfaceOuterClass$CSQQAccessReply = new BaseInterfaceOuterClass$CSQQAccessReply();
            baseInterfaceOuterClass$CSQQAccessReply.mergeFrom(fh.a(responseBytes));
        } catch (InvalidProtocolBufferMicroException e16) {
            AegisLogger.INSTANCE.e("VSRequest|QQLiveYesBaseRequest", "parseResponseHeadInfo", "error, ", e16);
        }
        if (baseInterfaceOuterClass$CSQQAccessReply.get() != null && (baseInterfaceOuterClass$CSQQAccessRspHeader = baseInterfaceOuterClass$CSQQAccessReply.rsp_header) != null) {
            if (baseInterfaceOuterClass$CSQQAccessRspHeader.error_code.get() != 0) {
                objArr[0] = Integer.valueOf(baseInterfaceOuterClass$CSQQAccessReply.rsp_header.error_code.get());
                String str = baseInterfaceOuterClass$CSQQAccessReply.rsp_header.error_message.get();
                Intrinsics.checkNotNullExpressionValue(str, "reply.rsp_header.error_message.get()");
                objArr[1] = str;
            } else {
                objArr[0] = 0L;
                objArr[1] = "";
            }
            if (!a()) {
                byteArray = baseInterfaceOuterClass$CSQQAccessReply.toByteArray();
            } else {
                byteArray = baseInterfaceOuterClass$CSQQAccessReply.rsp_body.get().toByteArray();
            }
            Intrinsics.checkNotNullExpressionValue(byteArray, "if (isJsonType()) {\n    \u2026ByteArray()\n            }");
            objArr[2] = byteArray;
            return objArr;
        }
        objArr[0] = -9999;
        objArr[1] = "\u56de\u5305\u89e3\u6790\u5931\u8d25";
        if (!a()) {
        }
        Intrinsics.checkNotNullExpressionValue(byteArray, "if (isJsonType()) {\n    \u2026ByteArray()\n            }");
        objArr[2] = byteArray;
        return objArr;
    }
}
