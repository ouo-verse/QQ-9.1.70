package com.tencent.mobileqq.matchfriend.aio.interactive;

import com.tencent.mobileqq.matchfriend.aio.sign.QQStrangerAIOSigUtil;
import com.tencent.mobileqq.matchfriend.reborn.utils.QQStrangerCommonProxyRequest;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.kuolie.prompt.prompt.Prompt$InteractiveOption;
import com.tencent.trpcprotocol.kuolie.prompt.prompt.Prompt$InteractiveParam;
import com.tencent.trpcprotocol.kuolie.prompt.prompt.Prompt$SendInteractiveReq;
import com.tencent.trpcprotocol.kuolie.prompt.prompt.Prompt$SendInteractiveRsp;
import com.tencent.trpcprotocol.qqstranger.common_proxy.common_proxy.CommonProxyPB$ProxyRsp;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J;\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0002H\u0002J;\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0012\u0010\u0013\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/aio/interactive/QQStrangerAIOInteractiveRequest;", "", "", "appId", "", "sign", "interactiveType", "Lcom/tencent/trpcprotocol/kuolie/prompt/prompt/Prompt$InteractiveParam;", "param", "Lcom/tencent/trpcprotocol/kuolie/prompt/prompt/Prompt$InteractiveOption;", "option", "Lcom/tencent/mobileqq/matchfriend/aio/interactive/a;", "d", "(I[BILcom/tencent/trpcprotocol/kuolie/prompt/prompt/Prompt$InteractiveParam;Lcom/tencent/trpcprotocol/kuolie/prompt/prompt/Prompt$InteractiveOption;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "chatType", "b", "", "tinyId", "c", "(IJILcom/tencent/trpcprotocol/kuolie/prompt/prompt/Prompt$InteractiveParam;Lcom/tencent/trpcprotocol/kuolie/prompt/prompt/Prompt$InteractiveOption;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class QQStrangerAIOInteractiveRequest {

    /* renamed from: a, reason: collision with root package name */
    public static final QQStrangerAIOInteractiveRequest f243904a = new QQStrangerAIOInteractiveRequest();

    QQStrangerAIOInteractiveRequest() {
    }

    private final int b(int chatType) {
        if (chatType == 104 || chatType != 119) {
            return 1;
        }
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:41:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object d(int i3, byte[] bArr, int i16, Prompt$InteractiveParam prompt$InteractiveParam, Prompt$InteractiveOption prompt$InteractiveOption, Continuation<? super AIOInteractiveResult> continuation) {
        QQStrangerAIOInteractiveRequest$reqSendInteractiveInner$1 qQStrangerAIOInteractiveRequest$reqSendInteractiveInner$1;
        Object coroutine_suspended;
        int i17;
        CommonProxyPB$ProxyRsp commonProxyPB$ProxyRsp;
        String str;
        PBStringField pBStringField;
        PBInt32Field pBInt32Field;
        if (continuation instanceof QQStrangerAIOInteractiveRequest$reqSendInteractiveInner$1) {
            qQStrangerAIOInteractiveRequest$reqSendInteractiveInner$1 = (QQStrangerAIOInteractiveRequest$reqSendInteractiveInner$1) continuation;
            int i18 = qQStrangerAIOInteractiveRequest$reqSendInteractiveInner$1.label;
            if ((i18 & Integer.MIN_VALUE) != 0) {
                qQStrangerAIOInteractiveRequest$reqSendInteractiveInner$1.label = i18 - Integer.MIN_VALUE;
                QQStrangerAIOInteractiveRequest$reqSendInteractiveInner$1 qQStrangerAIOInteractiveRequest$reqSendInteractiveInner$12 = qQStrangerAIOInteractiveRequest$reqSendInteractiveInner$1;
                Object obj = qQStrangerAIOInteractiveRequest$reqSendInteractiveInner$12.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i17 = qQStrangerAIOInteractiveRequest$reqSendInteractiveInner$12.label;
                if (i17 != 0) {
                    ResultKt.throwOnFailure(obj);
                    Prompt$SendInteractiveReq prompt$SendInteractiveReq = new Prompt$SendInteractiveReq();
                    prompt$SendInteractiveReq.interactive_type.set(i16);
                    prompt$SendInteractiveReq.param.set(prompt$InteractiveParam);
                    prompt$SendInteractiveReq.option.set(prompt$InteractiveOption);
                    prompt$SendInteractiveReq.sign.set(ByteStringMicro.copyFrom(bArr));
                    QQStrangerCommonProxyRequest qQStrangerCommonProxyRequest = QQStrangerCommonProxyRequest.f245454a;
                    byte[] byteArray = prompt$SendInteractiveReq.toByteArray();
                    Intrinsics.checkNotNullExpressionValue(byteArray, "reqBody.toByteArray()");
                    qQStrangerAIOInteractiveRequest$reqSendInteractiveInner$12.label = 1;
                    obj = qQStrangerCommonProxyRequest.a(i3, "QQStranger.prompt", "SsoSendInteractive", byteArray, qQStrangerAIOInteractiveRequest$reqSendInteractiveInner$12);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i17 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                commonProxyPB$ProxyRsp = (CommonProxyPB$ProxyRsp) obj;
                if (commonProxyPB$ProxyRsp == null && commonProxyPB$ProxyRsp.ret_code.get() == 0) {
                    Prompt$SendInteractiveRsp prompt$SendInteractiveRsp = new Prompt$SendInteractiveRsp();
                    try {
                        prompt$SendInteractiveRsp.mergeFrom(commonProxyPB$ProxyRsp.biz_buf.get().toByteArray());
                        int i19 = prompt$SendInteractiveRsp.ret_code.get();
                        String str2 = prompt$SendInteractiveRsp.err_msg.get();
                        String str3 = str2 != null ? str2 : "";
                        QLog.i("QQStrangerAIOInteractiveRequest", 1, "[reqSendInteractive] retCode=" + i19 + ", errMsg=" + str3);
                        return new AIOInteractiveResult(i19 == 0, i19, str3);
                    } catch (Exception e16) {
                        QLog.e("QQStrangerAIOInteractiveRequest", 1, "[reqSendInteractive] parse biz_buf error: ", e16);
                        return new AIOInteractiveResult(false, -10, "parse biz_buf error");
                    }
                }
                str = null;
                Integer boxInt = (commonProxyPB$ProxyRsp != null || (pBInt32Field = commonProxyPB$ProxyRsp.ret_code) == null) ? null : Boxing.boxInt(pBInt32Field.get());
                if (commonProxyPB$ProxyRsp != null && (pBStringField = commonProxyPB$ProxyRsp.ret_msg) != null) {
                    str = pBStringField.get();
                }
                QLog.e("QQStrangerAIOInteractiveRequest", 1, "[reqSendInteractive] proxy error, proxyRetCode=" + boxInt + ", proxyRetMsg=" + str);
                return new AIOInteractiveResult(false, boxInt != null ? boxInt.intValue() : -10, str != null ? str : "");
            }
        }
        qQStrangerAIOInteractiveRequest$reqSendInteractiveInner$1 = new QQStrangerAIOInteractiveRequest$reqSendInteractiveInner$1(this, continuation);
        QQStrangerAIOInteractiveRequest$reqSendInteractiveInner$1 qQStrangerAIOInteractiveRequest$reqSendInteractiveInner$122 = qQStrangerAIOInteractiveRequest$reqSendInteractiveInner$1;
        Object obj2 = qQStrangerAIOInteractiveRequest$reqSendInteractiveInner$122.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i17 = qQStrangerAIOInteractiveRequest$reqSendInteractiveInner$122.label;
        if (i17 != 0) {
        }
        commonProxyPB$ProxyRsp = (CommonProxyPB$ProxyRsp) obj2;
        if (commonProxyPB$ProxyRsp == null) {
        }
        str = null;
        if (commonProxyPB$ProxyRsp != null) {
        }
        if (commonProxyPB$ProxyRsp != null) {
            str = pBStringField.get();
        }
        QLog.e("QQStrangerAIOInteractiveRequest", 1, "[reqSendInteractive] proxy error, proxyRetCode=" + boxInt + ", proxyRetMsg=" + str);
        return new AIOInteractiveResult(false, boxInt != null ? boxInt.intValue() : -10, str != null ? str : "");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00e2 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object c(int i3, long j3, int i16, Prompt$InteractiveParam prompt$InteractiveParam, Prompt$InteractiveOption prompt$InteractiveOption, Continuation<? super AIOInteractiveResult> continuation) {
        QQStrangerAIOInteractiveRequest$reqSendInteractive$1 qQStrangerAIOInteractiveRequest$reqSendInteractive$1;
        Object coroutine_suspended;
        int i17;
        Prompt$InteractiveParam prompt$InteractiveParam2;
        Prompt$InteractiveOption prompt$InteractiveOption2;
        int i18;
        QQStrangerAIOInteractiveRequest qQStrangerAIOInteractiveRequest;
        Object obj;
        byte[] bArr;
        Object d16;
        Prompt$InteractiveParam prompt$InteractiveParam3;
        Prompt$InteractiveOption prompt$InteractiveOption3;
        int i19;
        int i26;
        int i27;
        long j16;
        Object obj2;
        boolean success;
        Prompt$InteractiveParam prompt$InteractiveParam4;
        QQStrangerAIOInteractiveRequest qQStrangerAIOInteractiveRequest2;
        Object obj3;
        AIOInteractiveResult aIOInteractiveResult;
        byte[] bArr2;
        Object obj4;
        int i28 = i3;
        long j17 = j3;
        if (continuation instanceof QQStrangerAIOInteractiveRequest$reqSendInteractive$1) {
            qQStrangerAIOInteractiveRequest$reqSendInteractive$1 = (QQStrangerAIOInteractiveRequest$reqSendInteractive$1) continuation;
            int i29 = qQStrangerAIOInteractiveRequest$reqSendInteractive$1.label;
            if ((i29 & Integer.MIN_VALUE) != 0) {
                qQStrangerAIOInteractiveRequest$reqSendInteractive$1.label = i29 - Integer.MIN_VALUE;
                Object obj5 = qQStrangerAIOInteractiveRequest$reqSendInteractive$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i17 = qQStrangerAIOInteractiveRequest$reqSendInteractive$1.label;
                if (i17 != 0) {
                    ResultKt.throwOnFailure(obj5);
                    QQStrangerAIOSigUtil qQStrangerAIOSigUtil = QQStrangerAIOSigUtil.f243975a;
                    qQStrangerAIOInteractiveRequest$reqSendInteractive$1.L$0 = this;
                    prompt$InteractiveParam2 = prompt$InteractiveParam;
                    qQStrangerAIOInteractiveRequest$reqSendInteractive$1.L$1 = prompt$InteractiveParam2;
                    prompt$InteractiveOption2 = prompt$InteractiveOption;
                    qQStrangerAIOInteractiveRequest$reqSendInteractive$1.L$2 = prompt$InteractiveOption2;
                    qQStrangerAIOInteractiveRequest$reqSendInteractive$1.I$0 = i28;
                    qQStrangerAIOInteractiveRequest$reqSendInteractive$1.J$0 = j17;
                    i18 = i16;
                    qQStrangerAIOInteractiveRequest$reqSendInteractive$1.I$1 = i18;
                    qQStrangerAIOInteractiveRequest$reqSendInteractive$1.label = 1;
                    Object n3 = qQStrangerAIOSigUtil.n(i28, j17, qQStrangerAIOInteractiveRequest$reqSendInteractive$1);
                    if (n3 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    qQStrangerAIOInteractiveRequest = this;
                    obj = n3;
                } else {
                    if (i17 != 1) {
                        if (i17 != 2) {
                            if (i17 != 3) {
                                if (i17 == 4) {
                                    ResultKt.throwOnFailure(obj5);
                                    obj4 = obj5;
                                }
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            i27 = qQStrangerAIOInteractiveRequest$reqSendInteractive$1.I$1;
                            i26 = qQStrangerAIOInteractiveRequest$reqSendInteractive$1.I$0;
                            aIOInteractiveResult = (AIOInteractiveResult) qQStrangerAIOInteractiveRequest$reqSendInteractive$1.L$3;
                            prompt$InteractiveOption3 = (Prompt$InteractiveOption) qQStrangerAIOInteractiveRequest$reqSendInteractive$1.L$2;
                            prompt$InteractiveParam4 = (Prompt$InteractiveParam) qQStrangerAIOInteractiveRequest$reqSendInteractive$1.L$1;
                            qQStrangerAIOInteractiveRequest2 = (QQStrangerAIOInteractiveRequest) qQStrangerAIOInteractiveRequest$reqSendInteractive$1.L$0;
                            ResultKt.throwOnFailure(obj5);
                            obj3 = obj5;
                            bArr2 = (byte[]) obj3;
                            if (bArr2 != null) {
                                QLog.d("QQStrangerAIOInteractiveRequest", 1, "refresh aio sign fail");
                                return aIOInteractiveResult;
                            }
                            QLog.d("QQStrangerAIOInteractiveRequest", 1, "send interactive again after refresh aio sign");
                            qQStrangerAIOInteractiveRequest$reqSendInteractive$1.L$0 = null;
                            qQStrangerAIOInteractiveRequest$reqSendInteractive$1.L$1 = null;
                            qQStrangerAIOInteractiveRequest$reqSendInteractive$1.L$2 = null;
                            qQStrangerAIOInteractiveRequest$reqSendInteractive$1.L$3 = null;
                            qQStrangerAIOInteractiveRequest$reqSendInteractive$1.label = 4;
                            Object d17 = qQStrangerAIOInteractiveRequest2.d(i27, bArr2, i26, prompt$InteractiveParam4, prompt$InteractiveOption3, qQStrangerAIOInteractiveRequest$reqSendInteractive$1);
                            obj4 = d17;
                            return d17 == coroutine_suspended ? coroutine_suspended : obj4;
                        }
                        i27 = qQStrangerAIOInteractiveRequest$reqSendInteractive$1.I$2;
                        i26 = qQStrangerAIOInteractiveRequest$reqSendInteractive$1.I$1;
                        j16 = qQStrangerAIOInteractiveRequest$reqSendInteractive$1.J$0;
                        i19 = qQStrangerAIOInteractiveRequest$reqSendInteractive$1.I$0;
                        prompt$InteractiveOption3 = (Prompt$InteractiveOption) qQStrangerAIOInteractiveRequest$reqSendInteractive$1.L$2;
                        prompt$InteractiveParam3 = (Prompt$InteractiveParam) qQStrangerAIOInteractiveRequest$reqSendInteractive$1.L$1;
                        qQStrangerAIOInteractiveRequest = (QQStrangerAIOInteractiveRequest) qQStrangerAIOInteractiveRequest$reqSendInteractive$1.L$0;
                        ResultKt.throwOnFailure(obj5);
                        obj2 = obj5;
                        AIOInteractiveResult aIOInteractiveResult2 = (AIOInteractiveResult) obj2;
                        success = aIOInteractiveResult2.getSuccess();
                        obj4 = aIOInteractiveResult2;
                        if (!success) {
                            int retCode = aIOInteractiveResult2.getRetCode();
                            obj4 = aIOInteractiveResult2;
                            if (retCode == 48) {
                                QQStrangerAIOSigUtil qQStrangerAIOSigUtil2 = QQStrangerAIOSigUtil.f243975a;
                                qQStrangerAIOInteractiveRequest$reqSendInteractive$1.L$0 = qQStrangerAIOInteractiveRequest;
                                qQStrangerAIOInteractiveRequest$reqSendInteractive$1.L$1 = prompt$InteractiveParam3;
                                qQStrangerAIOInteractiveRequest$reqSendInteractive$1.L$2 = prompt$InteractiveOption3;
                                qQStrangerAIOInteractiveRequest$reqSendInteractive$1.L$3 = aIOInteractiveResult2;
                                qQStrangerAIOInteractiveRequest$reqSendInteractive$1.I$0 = i26;
                                qQStrangerAIOInteractiveRequest$reqSendInteractive$1.I$1 = i27;
                                qQStrangerAIOInteractiveRequest$reqSendInteractive$1.label = 3;
                                Object t16 = qQStrangerAIOSigUtil2.t(i19, j16, qQStrangerAIOInteractiveRequest$reqSendInteractive$1);
                                if (t16 == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                prompt$InteractiveParam4 = prompt$InteractiveParam3;
                                qQStrangerAIOInteractiveRequest2 = qQStrangerAIOInteractiveRequest;
                                obj3 = t16;
                                aIOInteractiveResult = aIOInteractiveResult2;
                                bArr2 = (byte[]) obj3;
                                if (bArr2 != null) {
                                }
                            }
                        }
                    }
                    int i36 = qQStrangerAIOInteractiveRequest$reqSendInteractive$1.I$1;
                    j17 = qQStrangerAIOInteractiveRequest$reqSendInteractive$1.J$0;
                    int i37 = qQStrangerAIOInteractiveRequest$reqSendInteractive$1.I$0;
                    prompt$InteractiveOption2 = (Prompt$InteractiveOption) qQStrangerAIOInteractiveRequest$reqSendInteractive$1.L$2;
                    Prompt$InteractiveParam prompt$InteractiveParam5 = (Prompt$InteractiveParam) qQStrangerAIOInteractiveRequest$reqSendInteractive$1.L$1;
                    qQStrangerAIOInteractiveRequest = (QQStrangerAIOInteractiveRequest) qQStrangerAIOInteractiveRequest$reqSendInteractive$1.L$0;
                    ResultKt.throwOnFailure(obj5);
                    i18 = i36;
                    i28 = i37;
                    prompt$InteractiveParam2 = prompt$InteractiveParam5;
                    obj = obj5;
                }
                bArr = (byte[]) obj;
                if (bArr == null) {
                    bArr = new byte[0];
                }
                int b16 = qQStrangerAIOInteractiveRequest.b(i28);
                qQStrangerAIOInteractiveRequest$reqSendInteractive$1.L$0 = qQStrangerAIOInteractiveRequest;
                qQStrangerAIOInteractiveRequest$reqSendInteractive$1.L$1 = prompt$InteractiveParam2;
                qQStrangerAIOInteractiveRequest$reqSendInteractive$1.L$2 = prompt$InteractiveOption2;
                qQStrangerAIOInteractiveRequest$reqSendInteractive$1.I$0 = i28;
                qQStrangerAIOInteractiveRequest$reqSendInteractive$1.J$0 = j17;
                qQStrangerAIOInteractiveRequest$reqSendInteractive$1.I$1 = i18;
                qQStrangerAIOInteractiveRequest$reqSendInteractive$1.I$2 = b16;
                qQStrangerAIOInteractiveRequest$reqSendInteractive$1.label = 2;
                d16 = qQStrangerAIOInteractiveRequest.d(b16, bArr, i18, prompt$InteractiveParam2, prompt$InteractiveOption2, qQStrangerAIOInteractiveRequest$reqSendInteractive$1);
                if (d16 != coroutine_suspended) {
                    return coroutine_suspended;
                }
                prompt$InteractiveParam3 = prompt$InteractiveParam2;
                prompt$InteractiveOption3 = prompt$InteractiveOption2;
                long j18 = j17;
                i19 = i28;
                i26 = i18;
                i27 = b16;
                j16 = j18;
                obj2 = d16;
                AIOInteractiveResult aIOInteractiveResult22 = (AIOInteractiveResult) obj2;
                success = aIOInteractiveResult22.getSuccess();
                obj4 = aIOInteractiveResult22;
                if (!success) {
                }
            }
        }
        qQStrangerAIOInteractiveRequest$reqSendInteractive$1 = new QQStrangerAIOInteractiveRequest$reqSendInteractive$1(this, continuation);
        Object obj52 = qQStrangerAIOInteractiveRequest$reqSendInteractive$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i17 = qQStrangerAIOInteractiveRequest$reqSendInteractive$1.label;
        if (i17 != 0) {
        }
        bArr = (byte[]) obj;
        if (bArr == null) {
        }
        int b162 = qQStrangerAIOInteractiveRequest.b(i28);
        qQStrangerAIOInteractiveRequest$reqSendInteractive$1.L$0 = qQStrangerAIOInteractiveRequest;
        qQStrangerAIOInteractiveRequest$reqSendInteractive$1.L$1 = prompt$InteractiveParam2;
        qQStrangerAIOInteractiveRequest$reqSendInteractive$1.L$2 = prompt$InteractiveOption2;
        qQStrangerAIOInteractiveRequest$reqSendInteractive$1.I$0 = i28;
        qQStrangerAIOInteractiveRequest$reqSendInteractive$1.J$0 = j17;
        qQStrangerAIOInteractiveRequest$reqSendInteractive$1.I$1 = i18;
        qQStrangerAIOInteractiveRequest$reqSendInteractive$1.I$2 = b162;
        qQStrangerAIOInteractiveRequest$reqSendInteractive$1.label = 2;
        d16 = qQStrangerAIOInteractiveRequest.d(b162, bArr, i18, prompt$InteractiveParam2, prompt$InteractiveOption2, qQStrangerAIOInteractiveRequest$reqSendInteractive$1);
        if (d16 != coroutine_suspended) {
        }
    }
}
