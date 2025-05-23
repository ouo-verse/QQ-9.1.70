package com.tencent.mobileqq.matchfriend.reborn.liteinteraction.repo;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.matchfriend.reborn.liteinteraction.QQStrangerLIAItem;
import com.tencent.mobileqq.matchfriend.reborn.liteinteraction.QQStrangerLIAResource;
import com.tencent.mobileqq.matchfriend.reborn.utils.c;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.relation.common.servlet.a;
import com.tencent.relation.common.servlet.b;
import com.tencent.trpcprotocol.qqstranger.relation.interactive_marker.InteractiveMarkerPB$InteractiveInfo;
import com.tencent.trpcprotocol.qqstranger.relation.relation.Relation$GetInteractiveInfoReq;
import com.tencent.trpcprotocol.qqstranger.relation.relation.Relation$GetInteractiveInfoRsp;
import com.tencent.trpcprotocol.qqstranger.relation.relation.Relation$MessageNodeInfo;
import com.tencent.trpcprotocol.qqstranger.relation.relation.Relation$ReportMessageNodeReq;
import com.tencent.trpcprotocol.qqstranger.relation.relation.Relation$ReportMessageNodeRsp;
import com.tencent.util.AppSetting;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJA\u0010\n\u001a\u0004\u0018\u00018\u0000\"\f\b\u0000\u0010\u0003*\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\n\u0010\u000bJ'\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0010\u0010\u0011J+\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0012H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0018\u0010\u0019J+\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0012H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001a\u0010\u0019\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/liteinteraction/repo/QQStrangerLIARepo;", "", "Lcom/tencent/mobileqq/pb/MessageMicro;", "T", "", "cmd", "", "reqBytes", "Ljava/lang/Class;", "rspClass", "d", "(Ljava/lang/String;[BLjava/lang/Class;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "Lcom/tencent/trpcprotocol/qqstranger/relation/relation/Relation$MessageNodeInfo;", "nodeList", "Lcom/tencent/mobileqq/matchfriend/reborn/liteinteraction/d;", "c", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "chatType", "", "peerTinyId", "type", "", "a", "(IJILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "b", "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class QQStrangerLIARepo {
    private final <T extends MessageMicro<?>> Object d(String str, byte[] bArr, final Class<T> cls, Continuation<? super T> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        if (!NetworkUtil.isNetworkAvailable()) {
            QLog.d("QQStrangerLIARepo", 1, "requestServer network is not available");
            return null;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        Object businessHandler = appInterface != null ? appInterface.getBusinessHandler(a.f364759y4) : null;
        a aVar = businessHandler instanceof a ? (a) businessHandler : null;
        if (aVar != null) {
            intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
            final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
            cancellableContinuationImpl.initCancellability();
            aVar.Z0(str, bArr, new b() { // from class: com.tencent.mobileqq.matchfriend.reborn.liteinteraction.repo.QQStrangerLIARepo$requestServer$2$1
                @Override // com.tencent.mobileqq.app.BusinessObserver
                public final void onUpdate(int i3, boolean z16, Object obj) {
                    if (z16 && (obj instanceof byte[])) {
                        try {
                            MessageMicro messageMicro = (MessageMicro) cls.newInstance();
                            messageMicro.mergeFrom((byte[]) obj);
                            cancellableContinuationImpl.resume(messageMicro, new Function1<Throwable, Unit>() { // from class: com.tencent.mobileqq.matchfriend.reborn.liteinteraction.repo.QQStrangerLIARepo$requestServer$2$1.2
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
                            return;
                        } catch (Exception e16) {
                            QLog.e("QQStrangerLIARepo", 1, "parse rsp error ", e16);
                            cancellableContinuationImpl.resume(null, new Function1<Throwable, Unit>() { // from class: com.tencent.mobileqq.matchfriend.reborn.liteinteraction.repo.QQStrangerLIARepo$requestServer$2$1.3
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
                            return;
                        }
                    }
                    QLog.w("QQStrangerLIARepo", 1, "requestServer fail, isSuccess=" + z16 + " data=" + obj);
                    cancellableContinuationImpl.resume(null, new Function1<Throwable, Unit>() { // from class: com.tencent.mobileqq.matchfriend.reborn.liteinteraction.repo.QQStrangerLIARepo$requestServer$2$1.1
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
        QLog.e("QQStrangerLIARepo", 1, "requestServer handler is null");
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object a(int i3, long j3, int i16, Continuation<? super Unit> continuation) {
        QQStrangerLIARepo$reportCloseLIA$1 qQStrangerLIARepo$reportCloseLIA$1;
        Object coroutine_suspended;
        int i17;
        Relation$ReportMessageNodeRsp relation$ReportMessageNodeRsp;
        if (continuation instanceof QQStrangerLIARepo$reportCloseLIA$1) {
            qQStrangerLIARepo$reportCloseLIA$1 = (QQStrangerLIARepo$reportCloseLIA$1) continuation;
            int i18 = qQStrangerLIARepo$reportCloseLIA$1.label;
            if ((i18 & Integer.MIN_VALUE) != 0) {
                qQStrangerLIARepo$reportCloseLIA$1.label = i18 - Integer.MIN_VALUE;
                Object obj = qQStrangerLIARepo$reportCloseLIA$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i17 = qQStrangerLIARepo$reportCloseLIA$1.label;
                if (i17 != 0) {
                    ResultKt.throwOnFailure(obj);
                    QLog.d("QQStrangerLIARepo", 1, "reportCloseLIA chatType=" + i3 + " peerTinyId=" + j3 + " type=" + i16);
                    Relation$ReportMessageNodeReq relation$ReportMessageNodeReq = new Relation$ReportMessageNodeReq();
                    relation$ReportMessageNodeReq.appid.set(c.f245468a.b(i3));
                    relation$ReportMessageNodeReq.to_tinyid.set(j3);
                    relation$ReportMessageNodeReq.type.set(i16);
                    relation$ReportMessageNodeReq.node_type.set(1);
                    Unit unit = Unit.INSTANCE;
                    byte[] byteArray = relation$ReportMessageNodeReq.toByteArray();
                    Intrinsics.checkNotNullExpressionValue(byteArray, "ReportMessageNodeReq().a\u2026          }.toByteArray()");
                    qQStrangerLIARepo$reportCloseLIA$1.label = 1;
                    obj = d("QQStranger.Relation.SsoReportMessageNode", byteArray, Relation$ReportMessageNodeRsp.class, qQStrangerLIARepo$reportCloseLIA$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i17 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                relation$ReportMessageNodeRsp = (Relation$ReportMessageNodeRsp) obj;
                if (relation$ReportMessageNodeRsp != null) {
                    QLog.d("QQStrangerLIARepo", 1, "reportCloseLIA ret_code=" + relation$ReportMessageNodeRsp.ret_code.get() + " ret_msg=" + relation$ReportMessageNodeRsp.ret_msg.get());
                }
                return Unit.INSTANCE;
            }
        }
        qQStrangerLIARepo$reportCloseLIA$1 = new QQStrangerLIARepo$reportCloseLIA$1(this, continuation);
        Object obj2 = qQStrangerLIARepo$reportCloseLIA$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i17 = qQStrangerLIARepo$reportCloseLIA$1.label;
        if (i17 != 0) {
        }
        relation$ReportMessageNodeRsp = (Relation$ReportMessageNodeRsp) obj2;
        if (relation$ReportMessageNodeRsp != null) {
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object b(int i3, long j3, int i16, Continuation<? super Unit> continuation) {
        QQStrangerLIARepo$reportExpoLIA$1 qQStrangerLIARepo$reportExpoLIA$1;
        Object coroutine_suspended;
        int i17;
        Relation$ReportMessageNodeRsp relation$ReportMessageNodeRsp;
        if (continuation instanceof QQStrangerLIARepo$reportExpoLIA$1) {
            qQStrangerLIARepo$reportExpoLIA$1 = (QQStrangerLIARepo$reportExpoLIA$1) continuation;
            int i18 = qQStrangerLIARepo$reportExpoLIA$1.label;
            if ((i18 & Integer.MIN_VALUE) != 0) {
                qQStrangerLIARepo$reportExpoLIA$1.label = i18 - Integer.MIN_VALUE;
                Object obj = qQStrangerLIARepo$reportExpoLIA$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i17 = qQStrangerLIARepo$reportExpoLIA$1.label;
                if (i17 != 0) {
                    ResultKt.throwOnFailure(obj);
                    QLog.d("QQStrangerLIARepo", 1, "reportExpoLIA chatType=" + i3 + " peerTinyId=" + j3 + " type=" + i16);
                    Relation$ReportMessageNodeReq relation$ReportMessageNodeReq = new Relation$ReportMessageNodeReq();
                    relation$ReportMessageNodeReq.appid.set(c.f245468a.b(i3));
                    relation$ReportMessageNodeReq.to_tinyid.set(j3);
                    relation$ReportMessageNodeReq.type.set(i16);
                    relation$ReportMessageNodeReq.node_type.set(2);
                    Unit unit = Unit.INSTANCE;
                    byte[] byteArray = relation$ReportMessageNodeReq.toByteArray();
                    Intrinsics.checkNotNullExpressionValue(byteArray, "ReportMessageNodeReq().a\u2026          }.toByteArray()");
                    qQStrangerLIARepo$reportExpoLIA$1.label = 1;
                    obj = d("QQStranger.Relation.SsoReportMessageNode", byteArray, Relation$ReportMessageNodeRsp.class, qQStrangerLIARepo$reportExpoLIA$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i17 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                relation$ReportMessageNodeRsp = (Relation$ReportMessageNodeRsp) obj;
                if (relation$ReportMessageNodeRsp != null) {
                    QLog.d("QQStrangerLIARepo", 1, "reportExpoLIA ret_code=" + relation$ReportMessageNodeRsp.ret_code.get() + " ret_msg=" + relation$ReportMessageNodeRsp.ret_msg.get());
                }
                return Unit.INSTANCE;
            }
        }
        qQStrangerLIARepo$reportExpoLIA$1 = new QQStrangerLIARepo$reportExpoLIA$1(this, continuation);
        Object obj2 = qQStrangerLIARepo$reportExpoLIA$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i17 = qQStrangerLIARepo$reportExpoLIA$1.label;
        if (i17 != 0) {
        }
        relation$ReportMessageNodeRsp = (Relation$ReportMessageNodeRsp) obj2;
        if (relation$ReportMessageNodeRsp != null) {
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object c(List<Relation$MessageNodeInfo> list, Continuation<? super List<QQStrangerLIAItem>> continuation) {
        QQStrangerLIARepo$requestLIAData$1 qQStrangerLIARepo$requestLIAData$1;
        Object coroutine_suspended;
        int i3;
        Relation$GetInteractiveInfoRsp relation$GetInteractiveInfoRsp;
        int collectionSizeOrDefault;
        List emptyList;
        if (continuation instanceof QQStrangerLIARepo$requestLIAData$1) {
            qQStrangerLIARepo$requestLIAData$1 = (QQStrangerLIARepo$requestLIAData$1) continuation;
            int i16 = qQStrangerLIARepo$requestLIAData$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                qQStrangerLIARepo$requestLIAData$1.label = i16 - Integer.MIN_VALUE;
                Object obj = qQStrangerLIARepo$requestLIAData$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = qQStrangerLIARepo$requestLIAData$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    AppSetting.isDebugVersion();
                    QLog.d("QQStrangerLIARepo", 1, "requestLIAData nodeSize=" + list.size());
                    Relation$GetInteractiveInfoReq relation$GetInteractiveInfoReq = new Relation$GetInteractiveInfoReq();
                    relation$GetInteractiveInfoReq.node_infos.set(list);
                    Unit unit = Unit.INSTANCE;
                    byte[] byteArray = relation$GetInteractiveInfoReq.toByteArray();
                    Intrinsics.checkNotNullExpressionValue(byteArray, "GetInteractiveInfoReq().\u2026          }.toByteArray()");
                    qQStrangerLIARepo$requestLIAData$1.label = 1;
                    obj = d("QQStranger.Relation.SsoGetInteractiveInfo", byteArray, Relation$GetInteractiveInfoRsp.class, qQStrangerLIARepo$requestLIAData$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i3 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                relation$GetInteractiveInfoRsp = (Relation$GetInteractiveInfoRsp) obj;
                if (relation$GetInteractiveInfoRsp != null) {
                    emptyList = CollectionsKt__CollectionsKt.emptyList();
                    return emptyList;
                }
                QLog.d("QQStrangerLIARepo", 1, "requestLIAData ret_code=" + relation$GetInteractiveInfoRsp.ret_code.get() + " ret_msg=" + relation$GetInteractiveInfoRsp.ret_msg.get() + " infoSize=" + relation$GetInteractiveInfoRsp.infos.size());
                List<InteractiveMarkerPB$InteractiveInfo> list2 = relation$GetInteractiveInfoRsp.infos.get();
                Intrinsics.checkNotNullExpressionValue(list2, "rsp.infos.get()");
                List<InteractiveMarkerPB$InteractiveInfo> list3 = list2;
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list3, 10);
                ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                for (InteractiveMarkerPB$InteractiveInfo interactiveMarkerPB$InteractiveInfo : list3) {
                    int a16 = c.f245468a.a(interactiveMarkerPB$InteractiveInfo.appid.get());
                    long j3 = interactiveMarkerPB$InteractiveInfo.peer_tinyid.get();
                    int i17 = interactiveMarkerPB$InteractiveInfo.type.get();
                    int i18 = (int) interactiveMarkerPB$InteractiveInfo.interactive_emoji.get();
                    String str = interactiveMarkerPB$InteractiveInfo.summary.get();
                    Intrinsics.checkNotNullExpressionValue(str, "info.summary.get()");
                    String str2 = interactiveMarkerPB$InteractiveInfo.assist_content.get();
                    Intrinsics.checkNotNullExpressionValue(str2, "info.assist_content.get()");
                    String str3 = interactiveMarkerPB$InteractiveInfo.interactive_message.get();
                    Intrinsics.checkNotNullExpressionValue(str3, "info.interactive_message.get()");
                    QQStrangerLIAResource qQStrangerLIAResource = new QQStrangerLIAResource(i18, str, str2, str3);
                    String str4 = interactiveMarkerPB$InteractiveInfo.start_time.get();
                    Intrinsics.checkNotNullExpressionValue(str4, "info.start_time.get()");
                    String str5 = interactiveMarkerPB$InteractiveInfo.end_time.get();
                    Intrinsics.checkNotNullExpressionValue(str5, "info.end_time.get()");
                    arrayList.add(new QQStrangerLIAItem(a16, j3, i17, qQStrangerLIAResource, str4, str5, 3));
                }
                return arrayList;
            }
        }
        qQStrangerLIARepo$requestLIAData$1 = new QQStrangerLIARepo$requestLIAData$1(this, continuation);
        Object obj2 = qQStrangerLIARepo$requestLIAData$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = qQStrangerLIARepo$requestLIAData$1.label;
        if (i3 != 0) {
        }
        relation$GetInteractiveInfoRsp = (Relation$GetInteractiveInfoRsp) obj2;
        if (relation$GetInteractiveInfoRsp != null) {
        }
    }
}
