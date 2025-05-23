package com.tencent.mobileqq.matchfriend.reborn.content.msg.setting.repository;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.identity.Proto2JsonUtil;
import com.tencent.mobileqq.matchfriend.reborn.content.msg.setting.repository.QQStrangerMsgSettingRepository;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import com.tencent.trpcprotocol.kuolie.user_config.user_config.UserConfig$GetOptionsReq;
import com.tencent.trpcprotocol.kuolie.user_config.user_config.UserConfig$GetOptionsRsp;
import com.tencent.trpcprotocol.kuolie.user_config.user_config.UserConfig$SetOptionsReq;
import com.tencent.trpcprotocol.kuolie.user_config.user_config.UserConfig$SetOptionsRsp;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000  2\u00020\u0001:\u0002\u0016\u001bB\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0014\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u0002J\u0019\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0002H\u0002J!\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u00032\u0006\u0010\u000b\u001a\u00020\nH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\r\u0010\u000eJ\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u0002J\u0006\u0010\u0010\u001a\u00020\bJ\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u00022\u0006\u0010\u0012\u001a\u00020\u0011J\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u00022\u0006\u0010\u0012\u001a\u00020\u0011R\u001b\u0010\u001a\u001a\u00020\u00158BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001d\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/setting/repository/QQStrangerMsgSettingRepository;", "", "Lkotlinx/coroutines/flow/Flow;", "Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/setting/repository/QQStrangerMsgSettingRepository$b;", "Lcom/tencent/trpcprotocol/kuolie/user_config/user_config/UserConfig$GetOptionsRsp;", h.F, "j", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/setting/repository/b;", "f", "Lcom/tencent/trpcprotocol/kuolie/user_config/user_config/UserConfig$SetOptionsReq;", "req", "Lcom/tencent/trpcprotocol/kuolie/user_config/user_config/UserConfig$SetOptionsRsp;", "k", "(Lcom/tencent/trpcprotocol/kuolie/user_config/user_config/UserConfig$SetOptionsReq;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "g", "i", "", TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH, "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/setting/repository/a;", "a", "Lkotlin/Lazy;", "e", "()Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/setting/repository/a;", "cacheHelper", "b", "Lcom/tencent/trpcprotocol/kuolie/user_config/user_config/UserConfig$GetOptionsRsp;", "getOptionsRsp", "<init>", "()V", "c", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class QQStrangerMsgSettingRepository {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Lazy cacheHelper;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private UserConfig$GetOptionsRsp getOptionsRsp;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u001b\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00018\u0000\u00a2\u0006\u0004\b\f\u0010\rR\u0017\u0010\b\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0019\u0010\u000b\u001a\u0004\u0018\u00018\u00008\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\t\u001a\u0004\b\u0004\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/setting/repository/QQStrangerMsgSettingRepository$b;", "T", "", "", "a", "Z", "b", "()Z", "isSuccess", "Ljava/lang/Object;", "()Ljava/lang/Object;", "data", "<init>", "(ZLjava/lang/Object;)V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class b<T> {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final boolean isSuccess;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final T data;

        public b(boolean z16, T t16) {
            this.isSuccess = z16;
            this.data = t16;
        }

        public final T a() {
            return this.data;
        }

        /* renamed from: b, reason: from getter */
        public final boolean getIsSuccess() {
            return this.isSuccess;
        }

        public /* synthetic */ b(boolean z16, Object obj, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(z16, (i3 & 2) != 0 ? null : obj);
        }
    }

    public QQStrangerMsgSettingRepository() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<a>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.msg.setting.repository.QQStrangerMsgSettingRepository$cacheHelper$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final a invoke() {
                return new a();
            }
        });
        this.cacheHelper = lazy;
        this.getOptionsRsp = new UserConfig$GetOptionsRsp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final a e() {
        return (a) this.cacheHelper.getValue();
    }

    private final Flow<QQStrangerMsgSettingOptionResult> f() {
        return FlowKt.flow(new QQStrangerMsgSettingRepository$loadMsgSettingDataCacheFlow$1(this, null));
    }

    private final Flow<b<UserConfig$GetOptionsRsp>> h() {
        return FlowKt.flow(new QQStrangerMsgSettingRepository$requestMsgSettingsDataFlow$1(this, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    public final Object j(Continuation<? super b<UserConfig$GetOptionsRsp>> continuation) {
        Continuation intercepted;
        List<Integer> listOf;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        boolean z16 = false;
        int i3 = 2;
        boolean z17 = false;
        boolean z18 = false;
        if (!NetworkUtil.isNetworkAvailable()) {
            QLog.d("QQStrangerMsgSettingRepository", 2, "[requestMsgSettingsDataReal] network is not available");
            cancellableContinuationImpl.resume(new b(z16, z18 ? 1 : 0, i3, z17 ? 1 : 0), null);
        } else {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
            com.tencent.relation.common.servlet.a businessHandler = appInterface != null ? appInterface.getBusinessHandler(com.tencent.relation.common.servlet.a.f364759y4) : null;
            com.tencent.relation.common.servlet.a aVar = businessHandler instanceof com.tencent.relation.common.servlet.a ? businessHandler : null;
            if (aVar != null) {
                UserConfig$GetOptionsReq userConfig$GetOptionsReq = new UserConfig$GetOptionsReq();
                PBRepeatField<Integer> pBRepeatField = userConfig$GetOptionsReq.option_ids;
                listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{Boxing.boxInt(3), Boxing.boxInt(4)});
                pBRepeatField.set(listOf);
                Unit unit = Unit.INSTANCE;
                final String str = "QQStranger.user_config.SsoGetOptions";
                aVar.Z0("QQStranger.user_config.SsoGetOptions", userConfig$GetOptionsReq.toByteArray(), new com.tencent.relation.common.servlet.b() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.msg.setting.repository.QQStrangerMsgSettingRepository$requestMsgSettingsDataReal$2$2
                    @Override // com.tencent.mobileqq.app.BusinessObserver
                    public final void onUpdate(int i16, boolean z19, Object obj) {
                        Object m476constructorimpl;
                        int i17 = 2;
                        DefaultConstructorMarker defaultConstructorMarker = null;
                        if (z19 && (obj instanceof byte[])) {
                            UserConfig$GetOptionsRsp userConfig$GetOptionsRsp = new UserConfig$GetOptionsRsp();
                            try {
                                Result.Companion companion = Result.INSTANCE;
                                m476constructorimpl = Result.m476constructorimpl(userConfig$GetOptionsRsp.mergeFrom((byte[]) obj));
                            } catch (Throwable th5) {
                                Result.Companion companion2 = Result.INSTANCE;
                                m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
                            }
                            Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
                            if (m479exceptionOrNullimpl != null) {
                                CancellableContinuation<QQStrangerMsgSettingRepository.b<UserConfig$GetOptionsRsp>> cancellableContinuation = cancellableContinuationImpl;
                                QLog.e("QQStrangerMsgSettingRepository", 1, "[requestMsgSettingsDataReal] mergeFrom error ", m479exceptionOrNullimpl);
                                cancellableContinuation.resume(new QQStrangerMsgSettingRepository.b<>(r2, defaultConstructorMarker, i17, defaultConstructorMarker), new Function1<Throwable, Unit>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.msg.setting.repository.QQStrangerMsgSettingRepository$requestMsgSettingsDataReal$2$2$2$1
                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(Throwable th6) {
                                        invoke2(th6);
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(Throwable t16) {
                                        Intrinsics.checkNotNullParameter(t16, "t");
                                        QLog.d("QQStrangerMsgSettingRepository", 1, "[requestMsgSettingsDataReal] resume exception: ", t16);
                                    }
                                });
                                return;
                            }
                            QLog.d("QQStrangerMsgSettingRepository", 1, "[requestMsgSettingsDataReal] response: cmd=" + str + " isSuccess=" + z19 + " ret_code=" + userConfig$GetOptionsRsp.ret_code.get() + ", data=" + Proto2JsonUtil.proto2Json(userConfig$GetOptionsRsp));
                            cancellableContinuationImpl.resume(new QQStrangerMsgSettingRepository.b<>(userConfig$GetOptionsRsp.ret_code.get() == 0, userConfig$GetOptionsRsp), new Function1<Throwable, Unit>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.msg.setting.repository.QQStrangerMsgSettingRepository$requestMsgSettingsDataReal$2$2.3
                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(Throwable th6) {
                                    invoke2(th6);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(Throwable it) {
                                    Intrinsics.checkNotNullParameter(it, "it");
                                    QLog.d("QQStrangerMsgSettingRepository", 1, "[requestMsgSettingsDataReal] resume exception: ", it);
                                }
                            });
                            return;
                        }
                        QLog.d("QQStrangerMsgSettingRepository", 1, "[requestMsgSettingsDataReal] response: cmd=" + str + " isSuccess=" + z19 + " data=" + obj);
                        cancellableContinuationImpl.resume(new QQStrangerMsgSettingRepository.b<>(r2, defaultConstructorMarker, i17, defaultConstructorMarker), new Function1<Throwable, Unit>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.msg.setting.repository.QQStrangerMsgSettingRepository$requestMsgSettingsDataReal$2$2.4
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Throwable th6) {
                                invoke2(th6);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(Throwable it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                QLog.d("QQStrangerMsgSettingRepository", 1, "[requestMsgSettingsDataReal] resume exception: ", it);
                            }
                        });
                    }
                });
            }
        }
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    public final Object k(UserConfig$SetOptionsReq userConfig$SetOptionsReq, Continuation<? super b<UserConfig$SetOptionsRsp>> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        boolean z16 = false;
        boolean z17 = false;
        if (!NetworkUtil.isNetworkAvailable()) {
            QLog.d("QQStrangerMsgSettingRepository", 2, "[requestSetMsgOptions] network is not available");
            cancellableContinuationImpl.resume(new b(false, z17 ? 1 : 0, 2, z16 ? 1 : 0), null);
        } else {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
            com.tencent.relation.common.servlet.a businessHandler = appInterface != null ? appInterface.getBusinessHandler(com.tencent.relation.common.servlet.a.f364759y4) : null;
            com.tencent.relation.common.servlet.a aVar = businessHandler instanceof com.tencent.relation.common.servlet.a ? businessHandler : null;
            if (aVar != null) {
                final String str = "QQStranger.user_config.SsoSetOptions";
                aVar.Z0("QQStranger.user_config.SsoSetOptions", userConfig$SetOptionsReq.toByteArray(), new com.tencent.relation.common.servlet.b() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.msg.setting.repository.QQStrangerMsgSettingRepository$requestSetMsgOptions$2$1
                    @Override // com.tencent.mobileqq.app.BusinessObserver
                    public final void onUpdate(int i3, boolean z18, Object obj) {
                        Object m476constructorimpl;
                        int i16 = 2;
                        DefaultConstructorMarker defaultConstructorMarker = null;
                        if (z18 && (obj instanceof byte[])) {
                            UserConfig$SetOptionsRsp userConfig$SetOptionsRsp = new UserConfig$SetOptionsRsp();
                            try {
                                Result.Companion companion = Result.INSTANCE;
                                m476constructorimpl = Result.m476constructorimpl(userConfig$SetOptionsRsp.mergeFrom((byte[]) obj));
                            } catch (Throwable th5) {
                                Result.Companion companion2 = Result.INSTANCE;
                                m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
                            }
                            Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
                            if (m479exceptionOrNullimpl != null) {
                                CancellableContinuation<QQStrangerMsgSettingRepository.b<UserConfig$SetOptionsRsp>> cancellableContinuation = cancellableContinuationImpl;
                                QLog.e("QQStrangerMsgSettingRepository", 1, "[requestSetMsgOptions] mergeFrom error ", m479exceptionOrNullimpl);
                                cancellableContinuation.resume(new QQStrangerMsgSettingRepository.b<>(r2, defaultConstructorMarker, i16, defaultConstructorMarker), new Function1<Throwable, Unit>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.msg.setting.repository.QQStrangerMsgSettingRepository$requestSetMsgOptions$2$1$2$1
                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(Throwable th6) {
                                        invoke2(th6);
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(Throwable t16) {
                                        Intrinsics.checkNotNullParameter(t16, "t");
                                        QLog.d("QQStrangerMsgSettingRepository", 1, "[requestSetMsgOptions] resume exception: ", t16);
                                    }
                                });
                                return;
                            }
                            QLog.d("QQStrangerMsgSettingRepository", 1, "[requestSetMsgOptions] response: cmd=" + str + " isSuccess=" + z18 + " ret_code=" + userConfig$SetOptionsRsp.ret_code.get() + ", data=" + Proto2JsonUtil.proto2Json(userConfig$SetOptionsRsp));
                            cancellableContinuationImpl.resume(new QQStrangerMsgSettingRepository.b<>(userConfig$SetOptionsRsp.ret_code.get() == 0, userConfig$SetOptionsRsp), new Function1<Throwable, Unit>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.msg.setting.repository.QQStrangerMsgSettingRepository$requestSetMsgOptions$2$1.3
                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(Throwable th6) {
                                    invoke2(th6);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(Throwable it) {
                                    Intrinsics.checkNotNullParameter(it, "it");
                                    QLog.d("QQStrangerMsgSettingRepository", 1, "[requestSetMsgOptions] resume exception: ", it);
                                }
                            });
                            return;
                        }
                        QLog.d("QQStrangerMsgSettingRepository", 1, "[requestSetMsgOptions] response: cmd=" + str + " isSuccess=" + z18 + " data=" + obj);
                        cancellableContinuationImpl.resume(new QQStrangerMsgSettingRepository.b<>(r2, defaultConstructorMarker, i16, defaultConstructorMarker), new Function1<Throwable, Unit>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.msg.setting.repository.QQStrangerMsgSettingRepository$requestSetMsgOptions$2$1.4
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Throwable th6) {
                                invoke2(th6);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(Throwable it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                QLog.d("QQStrangerMsgSettingRepository", 1, "[requestSetMsgOptions] resume exception: ", it);
                            }
                        });
                    }
                });
            }
        }
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    public final Flow<QQStrangerMsgSettingOptionResult> g() {
        final Flow<b<UserConfig$GetOptionsRsp>> h16 = h();
        return FlowKt.flattenConcat(FlowKt.flowOf((Object[]) new Flow[]{f(), new Flow<QQStrangerMsgSettingOptionResult>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.msg.setting.repository.QQStrangerMsgSettingRepository$requestMsgSettingsData$$inlined$map$1

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\b"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$lambda-1$$inlined$collect$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 1, mv = {1, 7, 1}, xi = 48)
            /* renamed from: com.tencent.mobileqq.matchfriend.reborn.content.msg.setting.repository.QQStrangerMsgSettingRepository$requestMsgSettingsData$$inlined$map$1$2, reason: invalid class name */
            /* loaded from: classes33.dex */
            public static final class AnonymousClass2 implements FlowCollector<QQStrangerMsgSettingRepository.b<UserConfig$GetOptionsRsp>> {

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ FlowCollector f244763d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ QQStrangerMsgSettingRepository f244764e;

                /* compiled from: P */
                @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
                @DebugMetadata(c = "com.tencent.mobileqq.matchfriend.reborn.content.msg.setting.repository.QQStrangerMsgSettingRepository$requestMsgSettingsData$$inlined$map$1$2", f = "QQStrangerMsgSettingRepository.kt", i = {}, l = {136}, m = "emit", n = {}, s = {})
                /* renamed from: com.tencent.mobileqq.matchfriend.reborn.content.msg.setting.repository.QQStrangerMsgSettingRepository$requestMsgSettingsData$$inlined$map$1$2$1, reason: invalid class name */
                /* loaded from: classes33.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector, QQStrangerMsgSettingRepository qQStrangerMsgSettingRepository) {
                    this.f244763d = flowCollector;
                    this.f244764e = qQStrangerMsgSettingRepository;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public Object emit(QQStrangerMsgSettingRepository.b<UserConfig$GetOptionsRsp> bVar, Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    Object coroutine_suspended;
                    int i3;
                    QQStrangerMsgSettingOptionResult qQStrangerMsgSettingOptionResult;
                    UserConfig$GetOptionsRsp userConfig$GetOptionsRsp;
                    a e16;
                    if (continuation instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) continuation;
                        int i16 = anonymousClass1.label;
                        if ((i16 & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label = i16 - Integer.MIN_VALUE;
                            Object obj = anonymousClass1.result;
                            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            i3 = anonymousClass1.label;
                            if (i3 != 0) {
                                ResultKt.throwOnFailure(obj);
                                FlowCollector flowCollector = this.f244763d;
                                QQStrangerMsgSettingRepository.b<UserConfig$GetOptionsRsp> bVar2 = bVar;
                                if (bVar2.getIsSuccess() && bVar2.a() != null) {
                                    UserConfig$GetOptionsRsp a16 = bVar2.a();
                                    if (a16 != null) {
                                        userConfig$GetOptionsRsp = this.f244764e.getOptionsRsp;
                                        userConfig$GetOptionsRsp.options.set(a16.options);
                                        e16 = this.f244764e.e();
                                        e16.b(a16);
                                    }
                                    qQStrangerMsgSettingOptionResult = new QQStrangerMsgSettingOptionResult(true, false, bVar2.a());
                                } else {
                                    qQStrangerMsgSettingOptionResult = new QQStrangerMsgSettingOptionResult(false, false, null, 6, null);
                                }
                                anonymousClass1.label = 1;
                                if (flowCollector.emit(qQStrangerMsgSettingOptionResult, anonymousClass1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            } else if (i3 == 1) {
                                ResultKt.throwOnFailure(obj);
                            } else {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            return Unit.INSTANCE;
                        }
                    }
                    anonymousClass1 = new AnonymousClass1(continuation);
                    Object obj2 = anonymousClass1.result;
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i3 = anonymousClass1.label;
                    if (i3 != 0) {
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super QQStrangerMsgSettingOptionResult> flowCollector, Continuation continuation) {
                Object coroutine_suspended;
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector, this), continuation);
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                return collect == coroutine_suspended ? collect : Unit.INSTANCE;
            }
        }}));
    }

    public final QQStrangerMsgSettingOptionResult i() {
        return new QQStrangerMsgSettingOptionResult(true, true, this.getOptionsRsp);
    }

    public final Flow<QQStrangerMsgSettingOptionResult> l(final boolean r36) {
        final Flow flow = FlowKt.flow(new QQStrangerMsgSettingRepository$requestSetNewChatMsgNotifyOptions$1(this, r36, null));
        return new Flow<QQStrangerMsgSettingOptionResult>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.msg.setting.repository.QQStrangerMsgSettingRepository$requestSetNewChatMsgNotifyOptions$$inlined$map$1

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\b"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$lambda-1$$inlined$collect$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 1, mv = {1, 7, 1}, xi = 48)
            /* renamed from: com.tencent.mobileqq.matchfriend.reborn.content.msg.setting.repository.QQStrangerMsgSettingRepository$requestSetNewChatMsgNotifyOptions$$inlined$map$1$2, reason: invalid class name */
            /* loaded from: classes33.dex */
            public static final class AnonymousClass2 implements FlowCollector<QQStrangerMsgSettingRepository.b<UserConfig$SetOptionsRsp>> {

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ FlowCollector f244768d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ QQStrangerMsgSettingRepository f244769e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ boolean f244770f;

                /* compiled from: P */
                @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
                @DebugMetadata(c = "com.tencent.mobileqq.matchfriend.reborn.content.msg.setting.repository.QQStrangerMsgSettingRepository$requestSetNewChatMsgNotifyOptions$$inlined$map$1$2", f = "QQStrangerMsgSettingRepository.kt", i = {}, l = {136}, m = "emit", n = {}, s = {})
                /* renamed from: com.tencent.mobileqq.matchfriend.reborn.content.msg.setting.repository.QQStrangerMsgSettingRepository$requestSetNewChatMsgNotifyOptions$$inlined$map$1$2$1, reason: invalid class name */
                /* loaded from: classes33.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector, QQStrangerMsgSettingRepository qQStrangerMsgSettingRepository, boolean z16) {
                    this.f244768d = flowCollector;
                    this.f244769e = qQStrangerMsgSettingRepository;
                    this.f244770f = z16;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public Object emit(QQStrangerMsgSettingRepository.b<UserConfig$SetOptionsRsp> bVar, Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    Object coroutine_suspended;
                    int i3;
                    QQStrangerMsgSettingOptionResult qQStrangerMsgSettingOptionResult;
                    UserConfig$GetOptionsRsp userConfig$GetOptionsRsp;
                    UserConfig$GetOptionsRsp userConfig$GetOptionsRsp2;
                    UserConfig$GetOptionsRsp userConfig$GetOptionsRsp3;
                    a e16;
                    UserConfig$GetOptionsRsp userConfig$GetOptionsRsp4;
                    if (continuation instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) continuation;
                        int i16 = anonymousClass1.label;
                        if ((i16 & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label = i16 - Integer.MIN_VALUE;
                            Object obj = anonymousClass1.result;
                            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            i3 = anonymousClass1.label;
                            if (i3 != 0) {
                                ResultKt.throwOnFailure(obj);
                                FlowCollector flowCollector = this.f244768d;
                                QQStrangerMsgSettingRepository.b<UserConfig$SetOptionsRsp> bVar2 = bVar;
                                if (!bVar2.getIsSuccess() || bVar2.a() == null) {
                                    userConfig$GetOptionsRsp = this.f244769e.getOptionsRsp;
                                    qQStrangerMsgSettingOptionResult = new QQStrangerMsgSettingOptionResult(false, false, userConfig$GetOptionsRsp, 2, null);
                                } else {
                                    if (bVar2.a() != null) {
                                        userConfig$GetOptionsRsp3 = this.f244769e.getOptionsRsp;
                                        userConfig$GetOptionsRsp3.options.message_option.receive_offline_message.set(this.f244770f);
                                        e16 = this.f244769e.e();
                                        userConfig$GetOptionsRsp4 = this.f244769e.getOptionsRsp;
                                        e16.b(userConfig$GetOptionsRsp4);
                                    }
                                    userConfig$GetOptionsRsp2 = this.f244769e.getOptionsRsp;
                                    qQStrangerMsgSettingOptionResult = new QQStrangerMsgSettingOptionResult(true, false, userConfig$GetOptionsRsp2);
                                }
                                anonymousClass1.label = 1;
                                if (flowCollector.emit(qQStrangerMsgSettingOptionResult, anonymousClass1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            } else if (i3 == 1) {
                                ResultKt.throwOnFailure(obj);
                            } else {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            return Unit.INSTANCE;
                        }
                    }
                    anonymousClass1 = new AnonymousClass1(continuation);
                    Object obj2 = anonymousClass1.result;
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i3 = anonymousClass1.label;
                    if (i3 != 0) {
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super QQStrangerMsgSettingOptionResult> flowCollector, Continuation continuation) {
                Object coroutine_suspended;
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector, this, r36), continuation);
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                return collect == coroutine_suspended ? collect : Unit.INSTANCE;
            }
        };
    }

    public final Flow<QQStrangerMsgSettingOptionResult> m(final boolean r36) {
        final Flow flow = FlowKt.flow(new QQStrangerMsgSettingRepository$requestSetPrivacyOption$1(this, r36, null));
        return new Flow<QQStrangerMsgSettingOptionResult>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.msg.setting.repository.QQStrangerMsgSettingRepository$requestSetPrivacyOption$$inlined$map$1

            @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\b"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$lambda-1$$inlined$collect$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 1, mv = {1, 7, 1}, xi = 48)
            /* renamed from: com.tencent.mobileqq.matchfriend.reborn.content.msg.setting.repository.QQStrangerMsgSettingRepository$requestSetPrivacyOption$$inlined$map$1$2, reason: invalid class name */
            /* loaded from: classes33.dex */
            public static final class AnonymousClass2 implements FlowCollector<QQStrangerMsgSettingRepository.b<UserConfig$SetOptionsRsp>> {

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ FlowCollector f244774d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ QQStrangerMsgSettingRepository f244775e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ boolean f244776f;

                @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
                @DebugMetadata(c = "com.tencent.mobileqq.matchfriend.reborn.content.msg.setting.repository.QQStrangerMsgSettingRepository$requestSetPrivacyOption$$inlined$map$1$2", f = "QQStrangerMsgSettingRepository.kt", i = {}, l = {136}, m = "emit", n = {}, s = {})
                /* renamed from: com.tencent.mobileqq.matchfriend.reborn.content.msg.setting.repository.QQStrangerMsgSettingRepository$requestSetPrivacyOption$$inlined$map$1$2$1, reason: invalid class name */
                /* loaded from: classes33.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector, QQStrangerMsgSettingRepository qQStrangerMsgSettingRepository, boolean z16) {
                    this.f244774d = flowCollector;
                    this.f244775e = qQStrangerMsgSettingRepository;
                    this.f244776f = z16;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public Object emit(QQStrangerMsgSettingRepository.b<UserConfig$SetOptionsRsp> bVar, Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    Object coroutine_suspended;
                    int i3;
                    QQStrangerMsgSettingOptionResult qQStrangerMsgSettingOptionResult;
                    UserConfig$GetOptionsRsp userConfig$GetOptionsRsp;
                    UserConfig$GetOptionsRsp userConfig$GetOptionsRsp2;
                    UserConfig$GetOptionsRsp userConfig$GetOptionsRsp3;
                    a e16;
                    UserConfig$GetOptionsRsp userConfig$GetOptionsRsp4;
                    if (continuation instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) continuation;
                        int i16 = anonymousClass1.label;
                        if ((i16 & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label = i16 - Integer.MIN_VALUE;
                            Object obj = anonymousClass1.result;
                            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            i3 = anonymousClass1.label;
                            if (i3 != 0) {
                                ResultKt.throwOnFailure(obj);
                                FlowCollector flowCollector = this.f244774d;
                                QQStrangerMsgSettingRepository.b<UserConfig$SetOptionsRsp> bVar2 = bVar;
                                if (!bVar2.getIsSuccess() || bVar2.a() == null) {
                                    userConfig$GetOptionsRsp = this.f244775e.getOptionsRsp;
                                    qQStrangerMsgSettingOptionResult = new QQStrangerMsgSettingOptionResult(false, false, userConfig$GetOptionsRsp, 2, null);
                                } else {
                                    if (bVar2.a() != null) {
                                        userConfig$GetOptionsRsp3 = this.f244775e.getOptionsRsp;
                                        userConfig$GetOptionsRsp3.options.privacy_option.is_not_disturb.set(this.f244776f);
                                        e16 = this.f244775e.e();
                                        userConfig$GetOptionsRsp4 = this.f244775e.getOptionsRsp;
                                        e16.b(userConfig$GetOptionsRsp4);
                                    }
                                    userConfig$GetOptionsRsp2 = this.f244775e.getOptionsRsp;
                                    qQStrangerMsgSettingOptionResult = new QQStrangerMsgSettingOptionResult(true, false, userConfig$GetOptionsRsp2);
                                }
                                anonymousClass1.label = 1;
                                if (flowCollector.emit(qQStrangerMsgSettingOptionResult, anonymousClass1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            } else if (i3 == 1) {
                                ResultKt.throwOnFailure(obj);
                            } else {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            return Unit.INSTANCE;
                        }
                    }
                    anonymousClass1 = new AnonymousClass1(continuation);
                    Object obj2 = anonymousClass1.result;
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i3 = anonymousClass1.label;
                    if (i3 != 0) {
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super QQStrangerMsgSettingOptionResult> flowCollector, Continuation continuation) {
                Object coroutine_suspended;
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector, this, r36), continuation);
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                return collect == coroutine_suspended ? collect : Unit.INSTANCE;
            }
        };
    }
}
