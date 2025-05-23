package com.tencent.mobileqq.guild.discoveryv2.net;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [Rsp, Req] */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\b\u0001\u0012\u00028\u00010\u00030\u0002H\u008a@"}, d2 = {"Req", "Rsp", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/tencent/mobileqq/guild/discoveryv2/net/h;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.discoveryv2.net.NetworkCacheManager$fetch$1", f = "NetworkCacheManager.kt", i = {0, 1, 1, 1}, l = {29, 38, 46}, m = "invokeSuspend", n = {"$this$flow", "$this$flow", "response", "start$iv"}, s = {"L$0", "L$0", "L$1", "J$0"})
/* loaded from: classes13.dex */
public final class NetworkCacheManager$fetch$1<Req, Rsp> extends SuspendLambda implements Function2<FlowCollector<? super NetTransaction<Req, ? extends Rsp>>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Req $req;
    final /* synthetic */ boolean $updateCache;
    final /* synthetic */ boolean $useCache;
    long J$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ NetworkCacheManager<Req, Rsp> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NetworkCacheManager$fetch$1(boolean z16, Req req, boolean z17, NetworkCacheManager<Req, Rsp> networkCacheManager, Continuation<? super NetworkCacheManager$fetch$1> continuation) {
        super(2, continuation);
        this.$useCache = z16;
        this.$req = req;
        this.$updateCache = z17;
        this.this$0 = networkCacheManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        NetworkCacheManager$fetch$1 networkCacheManager$fetch$1 = new NetworkCacheManager$fetch$1(this.$useCache, this.$req, this.$updateCache, this.this$0, continuation);
        networkCacheManager$fetch$1.L$0 = obj;
        return networkCacheManager$fetch$1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00dd A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        FlowCollector flowCollector;
        b bVar;
        T t16;
        FlowCollector flowCollector2;
        Ref.ObjectRef objectRef;
        Function2 function2;
        Ref.ObjectRef objectRef2;
        long j3;
        T t17;
        NetTransaction netTransaction;
        b bVar2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                j3 = this.J$0;
                objectRef = (Ref.ObjectRef) this.L$2;
                objectRef2 = (Ref.ObjectRef) this.L$1;
                flowCollector2 = (FlowCollector) this.L$0;
                ResultKt.throwOnFailure(obj);
                t17 = obj;
                objectRef.element = t17;
                long currentTimeMillis = System.currentTimeMillis() - j3;
                if (this.$updateCache && bVar2 != null) {
                    bVar2.b(this.$req, objectRef2.element);
                }
                netTransaction = new NetTransaction(this.$req, objectRef2.element, DataType.NET);
                netTransaction.e(currentTimeMillis);
                this.L$0 = null;
                this.L$1 = null;
                this.L$2 = null;
                this.label = 3;
                if (flowCollector2.emit(netTransaction, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
            flowCollector = (FlowCollector) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            flowCollector = (FlowCollector) this.L$0;
            if (this.$useCache) {
                Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
                NetworkCacheManager<Req, Rsp> networkCacheManager = this.this$0;
                Req req = this.$req;
                long currentTimeMillis2 = System.currentTimeMillis();
                bVar = ((NetworkCacheManager) networkCacheManager).com.tencent.mobileqq.qqpermission.QQPermissionConstants.Permission.STORAGE_GROUP java.lang.String;
                if (bVar != null) {
                    t16 = bVar.a(req);
                } else {
                    t16 = 0;
                }
                objectRef3.element = t16;
                long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis2;
                T t18 = objectRef3.element;
                if (t18 != 0) {
                    NetTransaction netTransaction2 = new NetTransaction(this.$req, t18, DataType.FILE);
                    netTransaction2.e(currentTimeMillis3);
                    this.L$0 = flowCollector;
                    this.label = 1;
                    if (flowCollector.emit(netTransaction2, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            }
        }
        flowCollector2 = flowCollector;
        objectRef = new Ref.ObjectRef();
        NetworkCacheManager<Req, Rsp> networkCacheManager2 = this.this$0;
        Req req2 = this.$req;
        long currentTimeMillis4 = System.currentTimeMillis();
        function2 = ((NetworkCacheManager) networkCacheManager2).networkRequestFunction;
        this.L$0 = flowCollector2;
        this.L$1 = objectRef;
        this.L$2 = objectRef;
        this.J$0 = currentTimeMillis4;
        this.label = 2;
        Object invoke = function2.invoke(req2, this);
        if (invoke == coroutine_suspended) {
            return coroutine_suspended;
        }
        objectRef2 = objectRef;
        j3 = currentTimeMillis4;
        t17 = invoke;
        objectRef.element = t17;
        long currentTimeMillis5 = System.currentTimeMillis() - j3;
        if (this.$updateCache) {
            bVar2 = ((NetworkCacheManager) this.this$0).com.tencent.mobileqq.qqpermission.QQPermissionConstants.Permission.STORAGE_GROUP java.lang.String;
            bVar2.b(this.$req, objectRef2.element);
        }
        netTransaction = new NetTransaction(this.$req, objectRef2.element, DataType.NET);
        netTransaction.e(currentTimeMillis5);
        this.L$0 = null;
        this.L$1 = null;
        this.L$2 = null;
        this.label = 3;
        if (flowCollector2.emit(netTransaction, this) == coroutine_suspended) {
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull FlowCollector<? super NetTransaction<Req, ? extends Rsp>> flowCollector, @Nullable Continuation<? super Unit> continuation) {
        return ((NetworkCacheManager$fetch$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
