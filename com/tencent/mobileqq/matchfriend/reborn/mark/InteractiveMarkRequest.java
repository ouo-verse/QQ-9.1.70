package com.tencent.mobileqq.matchfriend.reborn.mark;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.qqstranger.relation.interactive_marker.InteractiveMarkerPB$InteractiveMarker;
import com.tencent.trpcprotocol.qqstranger.relation.relation.Relation$GetInteractiveMarkerReq;
import com.tencent.trpcprotocol.qqstranger.relation.relation.Relation$GetInteractiveMarkerRsp;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J0\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J9\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000e\u0010\u000f\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/mark/InteractiveMarkRequest;", "", "", "appId", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "tinyIds", "Lcom/tencent/relation/common/servlet/b;", "observer", "", "c", "", "Lcom/tencent/trpcprotocol/qqstranger/relation/interactive_marker/InteractiveMarkerPB$InteractiveMarker;", "b", "(ILjava/util/ArrayList;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class InteractiveMarkRequest {

    /* renamed from: a, reason: collision with root package name */
    public static final InteractiveMarkRequest f245170a = new InteractiveMarkRequest();

    InteractiveMarkRequest() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c(int appId, ArrayList<Long> tinyIds, com.tencent.relation.common.servlet.b observer) {
        Relation$GetInteractiveMarkerReq relation$GetInteractiveMarkerReq = new Relation$GetInteractiveMarkerReq();
        relation$GetInteractiveMarkerReq.appid.set(appId);
        relation$GetInteractiveMarkerReq.tinyids.set(tinyIds);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        if (appInterface != null) {
            Object businessHandler = appInterface.getBusinessHandler(com.tencent.relation.common.servlet.a.f364759y4);
            Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.relation.common.servlet.IRelationRequestHandler");
            ((com.tencent.relation.common.servlet.a) businessHandler).Z0("QQStranger.Relation.SsoGetInteractiveMarker", relation$GetInteractiveMarkerReq.toByteArray(), observer);
        } else {
            QLog.i("InteractiveMarkRequest", 1, "[reqGetInteractiveMark], app is null, request fail");
            observer.onUpdate(0, false, new Object());
        }
    }

    public final Object b(int i3, ArrayList<Long> arrayList, Continuation<? super List<InteractiveMarkerPB$InteractiveMarker>> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        if (QLog.isDevelopLevel()) {
            QLog.d("InteractiveMarkRequest", 1, "[getInteractiveMarkFromSever] appId=" + i3 + ", tinyIds=" + arrayList);
        }
        f245170a.c(i3, arrayList, new com.tencent.relation.common.servlet.b() { // from class: com.tencent.mobileqq.matchfriend.reborn.mark.InteractiveMarkRequest$getInteractiveMarkFromSever$2$1
            @Override // com.tencent.mobileqq.app.BusinessObserver
            public final void onUpdate(int i16, boolean z16, Object obj) {
                List<InteractiveMarkerPB$InteractiveMarker> emptyList;
                List<InteractiveMarkerPB$InteractiveMarker> emptyList2;
                List<InteractiveMarkerPB$InteractiveMarker> emptyList3;
                if (z16 && (obj instanceof byte[])) {
                    Relation$GetInteractiveMarkerRsp relation$GetInteractiveMarkerRsp = new Relation$GetInteractiveMarkerRsp();
                    try {
                        relation$GetInteractiveMarkerRsp.mergeFrom((byte[]) obj);
                        if (relation$GetInteractiveMarkerRsp.ret_code.get() != 0) {
                            QLog.i("InteractiveMarkRequest", 1, "[getInteractiveMarkFromSever]ret_code=" + relation$GetInteractiveMarkerRsp.ret_code.get() + ", errMsg=" + relation$GetInteractiveMarkerRsp.ret_msg.get());
                            CancellableContinuation<List<InteractiveMarkerPB$InteractiveMarker>> cancellableContinuation = cancellableContinuationImpl;
                            emptyList3 = CollectionsKt__CollectionsKt.emptyList();
                            cancellableContinuation.resume(emptyList3, new Function1<Throwable, Unit>() { // from class: com.tencent.mobileqq.matchfriend.reborn.mark.InteractiveMarkRequest$getInteractiveMarkFromSever$2$1.3
                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(Throwable th5) {
                                    invoke2(th5);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(Throwable it) {
                                    Intrinsics.checkNotNullParameter(it, "it");
                                    QLog.e("InteractiveMarkRequest", 1, "[getInteractiveMarkFromSever] resume error. ", it);
                                }
                            });
                            return;
                        }
                        CancellableContinuation<List<InteractiveMarkerPB$InteractiveMarker>> cancellableContinuation2 = cancellableContinuationImpl;
                        List<InteractiveMarkerPB$InteractiveMarker> list = relation$GetInteractiveMarkerRsp.markers.get();
                        Intrinsics.checkNotNullExpressionValue(list, "rsp.markers.get()");
                        cancellableContinuation2.resume(list, new Function1<Throwable, Unit>() { // from class: com.tencent.mobileqq.matchfriend.reborn.mark.InteractiveMarkRequest$getInteractiveMarkFromSever$2$1.4
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Throwable th5) {
                                invoke2(th5);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(Throwable it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                QLog.e("InteractiveMarkRequest", 1, "[getInteractiveMarkFromSever] resume error. ", it);
                            }
                        });
                        return;
                    } catch (InvalidProtocolBufferMicroException e16) {
                        QLog.e("InteractiveMarkRequest", 1, "[getInteractiveMarkFromSever] error", e16);
                        CancellableContinuation<List<InteractiveMarkerPB$InteractiveMarker>> cancellableContinuation3 = cancellableContinuationImpl;
                        emptyList2 = CollectionsKt__CollectionsKt.emptyList();
                        cancellableContinuation3.resume(emptyList2, new Function1<Throwable, Unit>() { // from class: com.tencent.mobileqq.matchfriend.reborn.mark.InteractiveMarkRequest$getInteractiveMarkFromSever$2$1.2
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Throwable th5) {
                                invoke2(th5);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(Throwable it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                QLog.e("InteractiveMarkRequest", 1, "[getInteractiveMarkFromSever] resume error. ", it);
                            }
                        });
                        return;
                    }
                }
                QLog.i("InteractiveMarkRequest", 1, "[getInteractiveMarkFromSever]isSuccess=" + z16);
                CancellableContinuation<List<InteractiveMarkerPB$InteractiveMarker>> cancellableContinuation4 = cancellableContinuationImpl;
                emptyList = CollectionsKt__CollectionsKt.emptyList();
                cancellableContinuation4.resume(emptyList, new Function1<Throwable, Unit>() { // from class: com.tencent.mobileqq.matchfriend.reborn.mark.InteractiveMarkRequest$getInteractiveMarkFromSever$2$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Throwable th5) {
                        invoke2(th5);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Throwable it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        QLog.e("InteractiveMarkRequest", 1, "[getInteractiveMarkFromSever] resume error. ", it);
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
}
