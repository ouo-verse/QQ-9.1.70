package com.tencent.mobileqq.matchfriend.aio.sign;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.icgame.api.room.PreloadTRTCPlayerParams;
import com.tencent.mobileqq.nearbypro.api.INearbyProChatApi;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.nativeinterface.IGetTempChatInfoCallback;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.TempChatGameSession;
import com.tencent.qqnt.kernel.nativeinterface.TempChatInfo;
import com.tencent.qqnt.kernel.nativeinterface.TempChatPrepareInfo;
import com.tencent.trpcprotocol.qqstranger.aio_msg.aio_msg.aioMsg$GetAIOSignReq;
import com.tencent.trpcprotocol.qqstranger.aio_msg.aio_msg.aioMsg$GetAIOSignRsp;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b$\u0010%J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007JR\u0010\u0011\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u000228\u0010\u0010\u001a4\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0015\u0012\u0013\u0018\u00010\u000e\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00040\tH\u0007J.\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0002J\n\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0002J%\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u0002H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001b\u0010\u001cJ+\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u000eH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001e\u0010\u001fJ%\u0010 \u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u0002H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b \u0010\u001cJ#\u0010!\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u0002H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b!\u0010\u001cJ%\u0010\"\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u0002H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\"\u0010\u001cJ%\u0010#\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u0002H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b#\u0010\u001c\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/aio/sign/QQStrangerAIOSigUtil;", "", "", "tinyId", "", "f", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/mobileqq/app/QQAppInterface;", "app", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "isSuccess", "", "sigFromSever", "cb", "i", "", "chatType", PreloadTRTCPlayerParams.KEY_SIG, "Lcom/tencent/qqnt/kernel/nativeinterface/IOperateCallback;", "callback", "o", "Lcom/tencent/qqnt/kernel/api/w;", "l", "Lcom/tencent/qqnt/kernel/nativeinterface/TempChatInfo;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(IJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sign", "r", "(IJ[BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "k", h.F, DomainData.DOMAIN_NAME, "t", "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class QQStrangerAIOSigUtil {

    /* renamed from: a, reason: collision with root package name */
    public static final QQStrangerAIOSigUtil f243975a = new QQStrangerAIOSigUtil();

    QQStrangerAIOSigUtil() {
    }

    @JvmStatic
    public static final void f(final long tinyId) {
        w l3 = f243975a.l();
        if (l3 == null) {
            QLog.e("QQStrangerAIOSigUtil", 1, "checkAioSigAndPrepareTempChat msgService is invalid!");
        } else {
            l3.getTempChatInfo(104, String.valueOf(tinyId), new IGetTempChatInfoCallback() { // from class: com.tencent.mobileqq.matchfriend.aio.sign.b
                @Override // com.tencent.qqnt.kernel.nativeinterface.IGetTempChatInfoCallback
                public final void onResult(int i3, String str, TempChatInfo tempChatInfo) {
                    QQStrangerAIOSigUtil.g(tinyId, i3, str, tempChatInfo);
                }
            });
        }
    }

    @JvmStatic
    public static final void i(final QQAppInterface app, final long tinyId, final Function2<? super Boolean, ? super byte[], Unit> cb5) {
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(cb5, "cb");
        aioMsg$GetAIOSignReq aiomsg_getaiosignreq = new aioMsg$GetAIOSignReq();
        aiomsg_getaiosignreq.to_tinyid.set(tinyId);
        Object businessHandler = app.getBusinessHandler(com.tencent.relation.common.servlet.a.f364759y4);
        Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.relation.common.servlet.IRelationRequestHandler");
        ((com.tencent.relation.common.servlet.a) businessHandler).Z0("QQStranger.AIOMsg.SsoGetAIOSign", aiomsg_getaiosignreq.toByteArray(), new com.tencent.relation.common.servlet.b() { // from class: com.tencent.mobileqq.matchfriend.aio.sign.c
            @Override // com.tencent.mobileqq.app.BusinessObserver
            public final void onUpdate(int i3, boolean z16, Object obj) {
                QQStrangerAIOSigUtil.j(Function2.this, app, tinyId, i3, z16, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(Function2 cb5, QQAppInterface app, long j3, int i3, boolean z16, Object obj) {
        aioMsg$GetAIOSignRsp aiomsg_getaiosignrsp;
        int i16;
        Intrinsics.checkNotNullParameter(cb5, "$cb");
        Intrinsics.checkNotNullParameter(app, "$app");
        if (z16 && obj != null) {
            try {
                aiomsg_getaiosignrsp = new aioMsg$GetAIOSignRsp();
                aiomsg_getaiosignrsp.mergeFrom((byte[]) obj);
                i16 = aiomsg_getaiosignrsp.ret_code.get();
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.e("QQStrangerAIOSigUtil", 1, "[getAioSigFromNet] error", e16);
            }
            if (i16 == 0) {
                byte[] byteArray = aiomsg_getaiosignrsp.sign.get().toByteArray();
                QLog.i("QQStrangerAIOSigUtil", 1, "[getAioSigFromNet] success sign length:" + byteArray.length);
                app.getMsgCache().x(String.valueOf(j3), app.getCurrentAccountUin(), byteArray);
                cb5.invoke(Boolean.TRUE, byteArray);
                return;
            }
            QLog.e("QQStrangerAIOSigUtil", 1, "[getAioSigFromNet] retCode=" + i16);
            cb5.invoke(Boolean.FALSE, null);
            return;
        }
        QLog.e("QQStrangerAIOSigUtil", 1, "[getAioSigFromNet] isSuccess:" + z16 + ", data:" + obj);
        cb5.invoke(Boolean.FALSE, null);
    }

    private final Object k(int i3, final long j3, Continuation<? super byte[]> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        QQAppInterface qQAppInterface = peekAppRuntime instanceof QQAppInterface ? (QQAppInterface) peekAppRuntime : null;
        if (qQAppInterface == null) {
            QLog.e("QQStrangerAIOSigUtil", 1, "getAioSigFromNetSuspend app is null");
        } else if (i3 == 104) {
            i(qQAppInterface, j3, new Function2<Boolean, byte[], Unit>() { // from class: com.tencent.mobileqq.matchfriend.aio.sign.QQStrangerAIOSigUtil$getAioSigFromNetSuspend$2$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, byte[] bArr) {
                    invoke(bool.booleanValue(), bArr);
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z16, byte[] bArr) {
                    cancellableContinuationImpl.resume(bArr, new Function1<Throwable, Unit>() { // from class: com.tencent.mobileqq.matchfriend.aio.sign.QQStrangerAIOSigUtil$getAioSigFromNetSuspend$2$1.1
                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(Throwable it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Throwable th5) {
                            invoke2(th5);
                            return Unit.INSTANCE;
                        }
                    });
                }
            });
        } else if (i3 != 119) {
            cancellableContinuationImpl.resume(null, new Function1<Throwable, Unit>() { // from class: com.tencent.mobileqq.matchfriend.aio.sign.QQStrangerAIOSigUtil$getAioSigFromNetSuspend$2$3
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Throwable it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Throwable th5) {
                    invoke2(th5);
                    return Unit.INSTANCE;
                }
            });
        } else {
            ((INearbyProChatApi) QRoute.api(INearbyProChatApi.class)).getAioSign(String.valueOf(j3), new Function2<byte[], String, Unit>() { // from class: com.tencent.mobileqq.matchfriend.aio.sign.QQStrangerAIOSigUtil$getAioSigFromNetSuspend$2$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(byte[] bArr, String str) {
                    invoke2(bArr, str);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(byte[] sig, String str) {
                    Intrinsics.checkNotNullParameter(sig, "sig");
                    QLog.d("QQStrangerAIOSigUtil", 1, "get nearby sign result, tinyId=" + j3 + " sig=" + sig);
                    cancellableContinuationImpl.resume(sig, new Function1<Throwable, Unit>() { // from class: com.tencent.mobileqq.matchfriend.aio.sign.QQStrangerAIOSigUtil$getAioSigFromNetSuspend$2$2.1
                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(Throwable it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Throwable th5) {
                            invoke2(th5);
                            return Unit.INSTANCE;
                        }
                    });
                }
            });
        }
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final w l() {
        IKernelService iKernelService;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null || (iKernelService = (IKernelService) peekAppRuntime.getRuntimeService(IKernelService.class, "all")) == null) {
            return null;
        }
        return iKernelService.getMsgService();
    }

    private final Object m(int i3, long j3, Continuation<? super TempChatInfo> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        w l3 = f243975a.l();
        if (l3 == null) {
            QLog.e("QQStrangerAIOSigUtil", 1, "getTempChatInfoSuspend msg service is invalid!");
            cancellableContinuationImpl.resume(null, new Function1<Throwable, Unit>() { // from class: com.tencent.mobileqq.matchfriend.aio.sign.QQStrangerAIOSigUtil$getTempChatInfoSuspend$2$1
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Throwable it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Throwable th5) {
                    invoke2(th5);
                    return Unit.INSTANCE;
                }
            });
        } else {
            l3.getTempChatInfo(i3, String.valueOf(j3), new IGetTempChatInfoCallback() { // from class: com.tencent.mobileqq.matchfriend.aio.sign.QQStrangerAIOSigUtil$getTempChatInfoSuspend$2$2
                @Override // com.tencent.qqnt.kernel.nativeinterface.IGetTempChatInfoCallback
                public final void onResult(int i16, String str, TempChatInfo tempChatInfo) {
                    QLog.i("QQStrangerAIOSigUtil", 1, "getTempChatInfoSuspend result=" + i16 + " errMsg=" + str);
                    if (i16 == 0) {
                        cancellableContinuationImpl.resume(tempChatInfo, new Function1<Throwable, Unit>() { // from class: com.tencent.mobileqq.matchfriend.aio.sign.QQStrangerAIOSigUtil$getTempChatInfoSuspend$2$2.1
                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(Throwable it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Throwable th5) {
                                invoke2(th5);
                                return Unit.INSTANCE;
                            }
                        });
                    } else {
                        cancellableContinuationImpl.resume(null, new Function1<Throwable, Unit>() { // from class: com.tencent.mobileqq.matchfriend.aio.sign.QQStrangerAIOSigUtil$getTempChatInfoSuspend$2$2.2
                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(Throwable it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Throwable th5) {
                                invoke2(th5);
                                return Unit.INSTANCE;
                            }
                        });
                    }
                }
            });
        }
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    private final Object r(int i3, long j3, byte[] bArr, Continuation<? super Integer> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        f243975a.o(i3, j3, bArr, new IOperateCallback() { // from class: com.tencent.mobileqq.matchfriend.aio.sign.QQStrangerAIOSigUtil$prepareTempChatSuspend$2$1
            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
            public final void onResult(int i16, String str) {
                cancellableContinuationImpl.resume(Integer.valueOf(i16), new Function1<Throwable, Unit>() { // from class: com.tencent.mobileqq.matchfriend.aio.sign.QQStrangerAIOSigUtil$prepareTempChatSuspend$2$1.1
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Throwable it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Throwable th5) {
                        invoke2(th5);
                        return Unit.INSTANCE;
                    }
                });
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    @JvmStatic
    public static final void s(final long tinyId) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        QQAppInterface qQAppInterface = peekAppRuntime instanceof QQAppInterface ? (QQAppInterface) peekAppRuntime : null;
        if (qQAppInterface == null) {
            return;
        }
        i(qQAppInterface, tinyId, new Function2<Boolean, byte[], Unit>() { // from class: com.tencent.mobileqq.matchfriend.aio.sign.QQStrangerAIOSigUtil$refreshAioSigAndPrepareTempChat$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, byte[] bArr) {
                invoke(bool.booleanValue(), bArr);
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16, byte[] bArr) {
                if (z16 && bArr != null) {
                    QQStrangerAIOSigUtil.p(QQStrangerAIOSigUtil.f243975a, 104, tinyId, bArr, null, 8, null);
                } else {
                    QLog.e("QQStrangerAIOSigUtil", 1, "refreshAioSigAndPrepareTempChat getSig error");
                }
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object h(int i3, long j3, Continuation<? super Integer> continuation) {
        QQStrangerAIOSigUtil$checkAioSigAndPrepareTempChatSuspend$1 qQStrangerAIOSigUtil$checkAioSigAndPrepareTempChatSuspend$1;
        Object obj;
        Object coroutine_suspended;
        int i16;
        QQStrangerAIOSigUtil qQStrangerAIOSigUtil;
        byte[] bArr;
        if (continuation instanceof QQStrangerAIOSigUtil$checkAioSigAndPrepareTempChatSuspend$1) {
            qQStrangerAIOSigUtil$checkAioSigAndPrepareTempChatSuspend$1 = (QQStrangerAIOSigUtil$checkAioSigAndPrepareTempChatSuspend$1) continuation;
            int i17 = qQStrangerAIOSigUtil$checkAioSigAndPrepareTempChatSuspend$1.label;
            if ((i17 & Integer.MIN_VALUE) != 0) {
                qQStrangerAIOSigUtil$checkAioSigAndPrepareTempChatSuspend$1.label = i17 - Integer.MIN_VALUE;
                QQStrangerAIOSigUtil$checkAioSigAndPrepareTempChatSuspend$1 qQStrangerAIOSigUtil$checkAioSigAndPrepareTempChatSuspend$12 = qQStrangerAIOSigUtil$checkAioSigAndPrepareTempChatSuspend$1;
                obj = qQStrangerAIOSigUtil$checkAioSigAndPrepareTempChatSuspend$12.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i16 = qQStrangerAIOSigUtil$checkAioSigAndPrepareTempChatSuspend$12.label;
                if (i16 != 0) {
                    ResultKt.throwOnFailure(obj);
                    qQStrangerAIOSigUtil$checkAioSigAndPrepareTempChatSuspend$12.L$0 = this;
                    qQStrangerAIOSigUtil$checkAioSigAndPrepareTempChatSuspend$12.I$0 = i3;
                    qQStrangerAIOSigUtil$checkAioSigAndPrepareTempChatSuspend$12.J$0 = j3;
                    qQStrangerAIOSigUtil$checkAioSigAndPrepareTempChatSuspend$12.label = 1;
                    obj = m(i3, j3, qQStrangerAIOSigUtil$checkAioSigAndPrepareTempChatSuspend$12);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    qQStrangerAIOSigUtil = this;
                } else {
                    if (i16 != 1) {
                        if (i16 != 2) {
                            if (i16 == 3) {
                                ResultKt.throwOnFailure(obj);
                            }
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        long j16 = qQStrangerAIOSigUtil$checkAioSigAndPrepareTempChatSuspend$12.J$0;
                        int i18 = qQStrangerAIOSigUtil$checkAioSigAndPrepareTempChatSuspend$12.I$0;
                        qQStrangerAIOSigUtil = (QQStrangerAIOSigUtil) qQStrangerAIOSigUtil$checkAioSigAndPrepareTempChatSuspend$12.L$0;
                        ResultKt.throwOnFailure(obj);
                        i3 = i18;
                        j3 = j16;
                        bArr = (byte[]) obj;
                        if (bArr != null) {
                            if (!(bArr.length == 0)) {
                                qQStrangerAIOSigUtil$checkAioSigAndPrepareTempChatSuspend$12.L$0 = null;
                                qQStrangerAIOSigUtil$checkAioSigAndPrepareTempChatSuspend$12.label = 3;
                                obj = qQStrangerAIOSigUtil.r(i3, j3, bArr, qQStrangerAIOSigUtil$checkAioSigAndPrepareTempChatSuspend$12);
                                return obj == coroutine_suspended ? coroutine_suspended : obj;
                            }
                        }
                        QLog.e("QQStrangerAIOSigUtil", 1, "checkAioSigAndPrepareTempChatSuspend sig is null or empty");
                        return Boxing.boxInt(-1);
                    }
                    j3 = qQStrangerAIOSigUtil$checkAioSigAndPrepareTempChatSuspend$12.J$0;
                    i3 = qQStrangerAIOSigUtil$checkAioSigAndPrepareTempChatSuspend$12.I$0;
                    qQStrangerAIOSigUtil = (QQStrangerAIOSigUtil) qQStrangerAIOSigUtil$checkAioSigAndPrepareTempChatSuspend$12.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                if (((TempChatInfo) obj) == null) {
                    return Boxing.boxInt(0);
                }
                qQStrangerAIOSigUtil$checkAioSigAndPrepareTempChatSuspend$12.L$0 = qQStrangerAIOSigUtil;
                qQStrangerAIOSigUtil$checkAioSigAndPrepareTempChatSuspend$12.I$0 = i3;
                qQStrangerAIOSigUtil$checkAioSigAndPrepareTempChatSuspend$12.J$0 = j3;
                qQStrangerAIOSigUtil$checkAioSigAndPrepareTempChatSuspend$12.label = 2;
                obj = qQStrangerAIOSigUtil.k(i3, j3, qQStrangerAIOSigUtil$checkAioSigAndPrepareTempChatSuspend$12);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                bArr = (byte[]) obj;
                if (bArr != null) {
                }
                QLog.e("QQStrangerAIOSigUtil", 1, "checkAioSigAndPrepareTempChatSuspend sig is null or empty");
                return Boxing.boxInt(-1);
            }
        }
        qQStrangerAIOSigUtil$checkAioSigAndPrepareTempChatSuspend$1 = new QQStrangerAIOSigUtil$checkAioSigAndPrepareTempChatSuspend$1(this, continuation);
        QQStrangerAIOSigUtil$checkAioSigAndPrepareTempChatSuspend$1 qQStrangerAIOSigUtil$checkAioSigAndPrepareTempChatSuspend$122 = qQStrangerAIOSigUtil$checkAioSigAndPrepareTempChatSuspend$1;
        obj = qQStrangerAIOSigUtil$checkAioSigAndPrepareTempChatSuspend$122.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i16 = qQStrangerAIOSigUtil$checkAioSigAndPrepareTempChatSuspend$122.label;
        if (i16 != 0) {
        }
        if (((TempChatInfo) obj) == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x00a0 A[PHI: r12
  0x00a0: PHI (r12v8 java.lang.Object) = (r12v7 java.lang.Object), (r12v1 java.lang.Object) binds: [B:29:0x009d, B:10:0x0028] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x009f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object n(int i3, long j3, Continuation<? super byte[]> continuation) {
        QQStrangerAIOSigUtil$getTempChatSigSuspend$1 qQStrangerAIOSigUtil$getTempChatSigSuspend$1;
        Object coroutine_suspended;
        int i16;
        QQStrangerAIOSigUtil qQStrangerAIOSigUtil;
        TempChatInfo tempChatInfo;
        if (continuation instanceof QQStrangerAIOSigUtil$getTempChatSigSuspend$1) {
            qQStrangerAIOSigUtil$getTempChatSigSuspend$1 = (QQStrangerAIOSigUtil$getTempChatSigSuspend$1) continuation;
            int i17 = qQStrangerAIOSigUtil$getTempChatSigSuspend$1.label;
            if ((i17 & Integer.MIN_VALUE) != 0) {
                qQStrangerAIOSigUtil$getTempChatSigSuspend$1.label = i17 - Integer.MIN_VALUE;
                Object obj = qQStrangerAIOSigUtil$getTempChatSigSuspend$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i16 = qQStrangerAIOSigUtil$getTempChatSigSuspend$1.label;
                if (i16 != 0) {
                    ResultKt.throwOnFailure(obj);
                    QLog.d("QQStrangerAIOSigUtil", 1, "getTempChatSigSuspend chatType=" + i3 + " tinyId=" + j3);
                    qQStrangerAIOSigUtil$getTempChatSigSuspend$1.L$0 = this;
                    qQStrangerAIOSigUtil$getTempChatSigSuspend$1.I$0 = i3;
                    qQStrangerAIOSigUtil$getTempChatSigSuspend$1.J$0 = j3;
                    qQStrangerAIOSigUtil$getTempChatSigSuspend$1.label = 1;
                    obj = m(i3, j3, qQStrangerAIOSigUtil$getTempChatSigSuspend$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    qQStrangerAIOSigUtil = this;
                } else {
                    if (i16 != 1) {
                        if (i16 == 2) {
                            ResultKt.throwOnFailure(obj);
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    j3 = qQStrangerAIOSigUtil$getTempChatSigSuspend$1.J$0;
                    i3 = qQStrangerAIOSigUtil$getTempChatSigSuspend$1.I$0;
                    qQStrangerAIOSigUtil = (QQStrangerAIOSigUtil) qQStrangerAIOSigUtil$getTempChatSigSuspend$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                tempChatInfo = (TempChatInfo) obj;
                if ((tempChatInfo == null ? tempChatInfo.sig : null) != null) {
                    byte[] bArr = tempChatInfo.sig;
                    Intrinsics.checkNotNullExpressionValue(bArr, "tempChatInfo.sig");
                    if (true ^ (bArr.length == 0)) {
                        return tempChatInfo.sig;
                    }
                }
                qQStrangerAIOSigUtil$getTempChatSigSuspend$1.L$0 = null;
                qQStrangerAIOSigUtil$getTempChatSigSuspend$1.label = 2;
                obj = qQStrangerAIOSigUtil.t(i3, j3, qQStrangerAIOSigUtil$getTempChatSigSuspend$1);
                return obj != coroutine_suspended ? coroutine_suspended : obj;
            }
        }
        qQStrangerAIOSigUtil$getTempChatSigSuspend$1 = new QQStrangerAIOSigUtil$getTempChatSigSuspend$1(this, continuation);
        Object obj2 = qQStrangerAIOSigUtil$getTempChatSigSuspend$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i16 = qQStrangerAIOSigUtil$getTempChatSigSuspend$1.label;
        if (i16 != 0) {
        }
        tempChatInfo = (TempChatInfo) obj2;
        if ((tempChatInfo == null ? tempChatInfo.sig : null) != null) {
        }
        qQStrangerAIOSigUtil$getTempChatSigSuspend$1.L$0 = null;
        qQStrangerAIOSigUtil$getTempChatSigSuspend$1.label = 2;
        obj2 = qQStrangerAIOSigUtil.t(i3, j3, qQStrangerAIOSigUtil$getTempChatSigSuspend$1);
        if (obj2 != coroutine_suspended) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0080 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object t(int i3, long j3, Continuation<? super byte[]> continuation) {
        QQStrangerAIOSigUtil$refreshAioSigAndPrepareTempChatSuspend$1 qQStrangerAIOSigUtil$refreshAioSigAndPrepareTempChatSuspend$1;
        Object coroutine_suspended;
        int i16;
        QQStrangerAIOSigUtil qQStrangerAIOSigUtil;
        byte[] bArr;
        if (continuation instanceof QQStrangerAIOSigUtil$refreshAioSigAndPrepareTempChatSuspend$1) {
            qQStrangerAIOSigUtil$refreshAioSigAndPrepareTempChatSuspend$1 = (QQStrangerAIOSigUtil$refreshAioSigAndPrepareTempChatSuspend$1) continuation;
            int i17 = qQStrangerAIOSigUtil$refreshAioSigAndPrepareTempChatSuspend$1.label;
            if ((i17 & Integer.MIN_VALUE) != 0) {
                qQStrangerAIOSigUtil$refreshAioSigAndPrepareTempChatSuspend$1.label = i17 - Integer.MIN_VALUE;
                QQStrangerAIOSigUtil$refreshAioSigAndPrepareTempChatSuspend$1 qQStrangerAIOSigUtil$refreshAioSigAndPrepareTempChatSuspend$12 = qQStrangerAIOSigUtil$refreshAioSigAndPrepareTempChatSuspend$1;
                Object obj = qQStrangerAIOSigUtil$refreshAioSigAndPrepareTempChatSuspend$12.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i16 = qQStrangerAIOSigUtil$refreshAioSigAndPrepareTempChatSuspend$12.label;
                if (i16 != 0) {
                    ResultKt.throwOnFailure(obj);
                    QLog.d("QQStrangerAIOSigUtil", 1, "refreshAioSigAndPrepareTempChatSuspend chatType=" + i3 + " tinyId=" + j3);
                    qQStrangerAIOSigUtil$refreshAioSigAndPrepareTempChatSuspend$12.L$0 = this;
                    qQStrangerAIOSigUtil$refreshAioSigAndPrepareTempChatSuspend$12.I$0 = i3;
                    qQStrangerAIOSigUtil$refreshAioSigAndPrepareTempChatSuspend$12.J$0 = j3;
                    qQStrangerAIOSigUtil$refreshAioSigAndPrepareTempChatSuspend$12.label = 1;
                    obj = k(i3, j3, qQStrangerAIOSigUtil$refreshAioSigAndPrepareTempChatSuspend$12);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    qQStrangerAIOSigUtil = this;
                } else {
                    if (i16 != 1) {
                        if (i16 == 2) {
                            byte[] bArr2 = (byte[]) qQStrangerAIOSigUtil$refreshAioSigAndPrepareTempChatSuspend$12.L$0;
                            ResultKt.throwOnFailure(obj);
                            return bArr2;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    j3 = qQStrangerAIOSigUtil$refreshAioSigAndPrepareTempChatSuspend$12.J$0;
                    i3 = qQStrangerAIOSigUtil$refreshAioSigAndPrepareTempChatSuspend$12.I$0;
                    qQStrangerAIOSigUtil = (QQStrangerAIOSigUtil) qQStrangerAIOSigUtil$refreshAioSigAndPrepareTempChatSuspend$12.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                long j16 = j3;
                bArr = (byte[]) obj;
                if (bArr != null) {
                    return null;
                }
                qQStrangerAIOSigUtil$refreshAioSigAndPrepareTempChatSuspend$12.L$0 = bArr;
                qQStrangerAIOSigUtil$refreshAioSigAndPrepareTempChatSuspend$12.label = 2;
                return qQStrangerAIOSigUtil.r(i3, j16, bArr, qQStrangerAIOSigUtil$refreshAioSigAndPrepareTempChatSuspend$12) == coroutine_suspended ? coroutine_suspended : bArr;
            }
        }
        qQStrangerAIOSigUtil$refreshAioSigAndPrepareTempChatSuspend$1 = new QQStrangerAIOSigUtil$refreshAioSigAndPrepareTempChatSuspend$1(this, continuation);
        QQStrangerAIOSigUtil$refreshAioSigAndPrepareTempChatSuspend$1 qQStrangerAIOSigUtil$refreshAioSigAndPrepareTempChatSuspend$122 = qQStrangerAIOSigUtil$refreshAioSigAndPrepareTempChatSuspend$1;
        Object obj2 = qQStrangerAIOSigUtil$refreshAioSigAndPrepareTempChatSuspend$122.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i16 = qQStrangerAIOSigUtil$refreshAioSigAndPrepareTempChatSuspend$122.label;
        if (i16 != 0) {
        }
        long j162 = j3;
        bArr = (byte[]) obj2;
        if (bArr != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(long j3, int i3, String str, TempChatInfo tempChatInfo) {
        if (i3 == 0 && tempChatInfo.sig != null) {
            QLog.i("QQStrangerAIOSigUtil", 1, "checkAioSigAndPrepareTempChat local sign is valid!");
        } else {
            QLog.i("QQStrangerAIOSigUtil", 1, "checkAioSigAndPrepareTempChat local sign is invalid!");
            s(j3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(IOperateCallback iOperateCallback, int i3, String str) {
        QLog.d("QQStrangerAIOSigUtil", 2, "prepareTempChat: ", Integer.valueOf(i3), ", errMsg: ", str);
        if (iOperateCallback != null) {
            iOperateCallback.onResult(i3, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o(int chatType, long tinyId, byte[] sig, final IOperateCallback callback) {
        w l3 = l();
        if (l3 == null) {
            QLog.d("QQStrangerAIOSigUtil", 1, "prepareTempChat msgService is null");
            if (callback != null) {
                callback.onResult(-1, null);
                return;
            }
            return;
        }
        l3.prepareTempChat(new TempChatPrepareInfo(chatType, String.valueOf(tinyId), "", "", sig, "", "", new TempChatGameSession()), new IOperateCallback() { // from class: com.tencent.mobileqq.matchfriend.aio.sign.d
            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
            public final void onResult(int i3, String str) {
                QQStrangerAIOSigUtil.q(IOperateCallback.this, i3, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void p(QQStrangerAIOSigUtil qQStrangerAIOSigUtil, int i3, long j3, byte[] bArr, IOperateCallback iOperateCallback, int i16, Object obj) {
        if ((i16 & 8) != 0) {
            iOperateCallback = null;
        }
        qQStrangerAIOSigUtil.o(i3, j3, bArr, iOperateCallback);
    }
}
