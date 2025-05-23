package com.tencent.mobileqq.winkpublish;

import android.content.Intent;
import com.tencent.mobileqq.winkpublish.WinkPublishHelper2;
import com.tencent.mobileqq.winkpublish.api.constant.FSPublishConstants;
import com.tencent.mobileqq.winkpublish.compact.WinkPublishServiceReporter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.winkpublish.WinkPublishHelper2$bindService$1", f = "WinkPublishHelper2.kt", i = {}, l = {132}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
public final class WinkPublishHelper2$bindService$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $businessType;
    final /* synthetic */ WinkPublishHelper2.Callback $callback;
    final /* synthetic */ boolean $forceBind;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.winkpublish.WinkPublishHelper2$bindService$1$1", f = "WinkPublishHelper2.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.winkpublish.WinkPublishHelper2$bindService$1$1, reason: invalid class name */
    /* loaded from: classes21.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $businessType;
        final /* synthetic */ long $start;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(long j3, int i3, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$start = j3;
            this.$businessType = i3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(this.$start, this.$businessType, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Set set;
            Map map;
            Map map2;
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                WinkPublishHelper2.MyServiceConnection myServiceConnection = new WinkPublishHelper2.MyServiceConnection(this.$start, this.$businessType);
                QLog.i("Service-WinkPublishHelper2", 1, "bindService id:" + myServiceConnection);
                Intent intent = new Intent();
                intent.setClassName(BaseApplication.getContext(), FSPublishConstants.WINK_PUBLISH_SERVICE_NAME);
                if (BaseApplication.getContext().bindService(intent, myServiceConnection, 1)) {
                    set = WinkPublishHelper2.serviceConnectionMap;
                    set.add(myServiceConnection);
                } else {
                    QLog.e("Service-WinkPublishHelper2", 1, "[bindService] result false");
                    WinkPublishServiceReporter.reportOperation(9, this.$businessType, true);
                    map = WinkPublishHelper2.pendingCallbacksMap;
                    List list = (List) map.get(Boxing.boxInt(this.$businessType));
                    if (list != null) {
                        list.clear();
                    }
                    map2 = WinkPublishHelper2.pendingCallbacksMap;
                    map2.remove(Boxing.boxInt(this.$businessType));
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkPublishHelper2$bindService$1(int i3, WinkPublishHelper2.Callback callback, boolean z16, Continuation<? super WinkPublishHelper2$bindService$1> continuation) {
        super(2, continuation);
        this.$businessType = i3;
        this.$callback = callback;
        this.$forceBind = z16;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WinkPublishHelper2$bindService$1(this.$businessType, this.$callback, this.$forceBind, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Map map;
        Boolean bool;
        Map map2;
        List mutableListOf;
        Map map3;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            long currentTimeMillis = System.currentTimeMillis();
            QLog.i("Service-WinkPublishHelper2", 1, "[bindService] processId=" + MobileQQ.sProcessId + ", businessType=" + this.$businessType);
            WinkPublishServiceProxy2 winkPublishServiceProxy2 = (WinkPublishServiceProxy2) WinkPublishHelper2.serviceProxyMap.get(Boxing.boxInt(this.$businessType));
            if (winkPublishServiceProxy2 == null || !winkPublishServiceProxy2.isBinderAlive()) {
                map = WinkPublishHelper2.pendingCallbacksMap;
                if (map.containsKey(Boxing.boxInt(this.$businessType)) && !this.$forceBind) {
                    QLog.i("Service-WinkPublishHelper2", 1, "[bindService] add pending callback " + this.$callback);
                    map3 = WinkPublishHelper2.pendingCallbacksMap;
                    List list = (List) map3.get(Boxing.boxInt(this.$businessType));
                    if (list != null) {
                        Boxing.boxBoolean(list.add(this.$callback));
                    }
                    return Unit.INSTANCE;
                }
                WinkPublishHelper2.Callback callback = this.$callback;
                if (winkPublishServiceProxy2 != null) {
                    bool = Boxing.boxBoolean(winkPublishServiceProxy2.isBinderAlive());
                } else {
                    bool = null;
                }
                QLog.i("Service-WinkPublishHelper2", 1, "[bindService] new pending callback " + callback + ", alive=" + bool);
                map2 = WinkPublishHelper2.pendingCallbacksMap;
                Integer boxInt = Boxing.boxInt(this.$businessType);
                mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(this.$callback);
                map2.put(boxInt, mutableListOf);
                WinkPublishServiceReporter.reportOperation(1, this.$businessType);
                CoroutineDispatcher coroutineDispatcher = Dispatchers.getDefault();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(currentTimeMillis, this.$businessType, null);
                this.label = 1;
                if (BuildersKt.withContext(coroutineDispatcher, anonymousClass1, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                QLog.i("Service-WinkPublishHelper2", 1, "[bindService] already have connection");
                WinkPublishHelper2.Callback callback2 = this.$callback;
                if (callback2 != null) {
                    callback2.onServiceConnected(winkPublishServiceProxy2);
                }
                return Unit.INSTANCE;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((WinkPublishHelper2$bindService$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
