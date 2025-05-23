package com.tencent.sqshow.zootopia.friendsdressup.datasrouce;

import android.os.Handler;
import android.os.Looper;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleCoroutineScope;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.zootopia.api.e;
import com.tencent.mobileqq.zootopia.d;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import tl.h;
import zb3.FriendsRespData;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 62\u00020\u0001:\u0001\u0019B\u000f\u0012\u0006\u0010\u001d\u001a\u00020\u0018\u00a2\u0006\u0004\b4\u00105J\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\u0016\u0010\t\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\f\u0010\n\u001a\u00020\u0005*\u00020\u0005H\u0002J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000bH\u0002J\f\u0010\u000e\u001a\u00020\u0005*\u00020\u0005H\u0002J\u0016\u0010\u0011\u001a\u00020\u00072\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u000fH\u0002J\u0016\u0010\u0013\u001a\u00020\u00072\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u000fH\u0002J\u001c\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\u0014\u0010\u0015\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\u0014\u0010\u0016\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\u0006\u0010\u0017\u001a\u00020\u0007R\u0017\u0010\u001d\u001a\u00020\u00188\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010 \u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010\"\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\u001fR\u0016\u0010$\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010\u001fR\u0014\u0010(\u001a\u00020%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'R\"\u0010/\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001e\u00103\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102\u00a8\u00067"}, d2 = {"Lcom/tencent/sqshow/zootopia/friendsdressup/datasrouce/DataSource;", "", "", "friendUin", "Lcom/tencent/mobileqq/zootopia/d;", "Lzb3/b;", "callback", "", "w", "v", "o", "", "isLoadingState", "y", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lkotlin/Function0;", "function", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "callBack", "p", ReportConstant.COSTREPORT_PREFIX, "r", "t", HippyTKDListViewAdapter.X, "Landroidx/lifecycle/LifecycleCoroutineScope;", "a", "Landroidx/lifecycle/LifecycleCoroutineScope;", "u", "()Landroidx/lifecycle/LifecycleCoroutineScope;", "scope", "b", "J", "requestStartIndex", "c", "requestOffset", "d", "sessionID", "Ljava/util/concurrent/atomic/AtomicBoolean;", "e", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isLoading", "f", "Z", "getEnableLoadMore", "()Z", "setEnableLoadMore", "(Z)V", "enableLoadMore", "Lcom/tencent/mobileqq/zootopia/api/e;", "g", "Lcom/tencent/mobileqq/zootopia/api/e;", "hostCallBack", "<init>", "(Landroidx/lifecycle/LifecycleCoroutineScope;)V", h.F, "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class DataSource {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final LifecycleCoroutineScope scope;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private long requestStartIndex;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private long requestOffset;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private long sessionID;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final AtomicBoolean isLoading;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean enableLoadMore;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private e<FriendsRespData> hostCallBack;

    public DataSource(LifecycleCoroutineScope scope) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.scope = scope;
        this.isLoading = new AtomicBoolean(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FriendsRespData A(FriendsRespData friendsRespData) {
        this.enableLoadMore = friendsRespData.getHasMore();
        y(false);
        com.tencent.sqshow.zootopia.friendsdressup.a.b("DataSource", "success  size " + friendsRespData.a().size());
        return friendsRespData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FriendsRespData o(FriendsRespData friendsRespData) {
        if (friendsRespData.getHasMore()) {
            this.requestStartIndex = friendsRespData.getStartIndex();
            this.requestOffset = friendsRespData.getOffset();
        }
        com.tencent.sqshow.zootopia.friendsdressup.a.b("DataSource", "calculateStartIndex hasMore " + friendsRespData.getHasMore() + "  nextStartIndex " + this.requestStartIndex + " requestOffset " + this.requestOffset);
        return friendsRespData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p(final Function0<Unit> callBack) {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            callBack.invoke();
        } else {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.sqshow.zootopia.friendsdressup.datasrouce.a
                @Override // java.lang.Runnable
                public final void run() {
                    DataSource.q(Function0.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(Function0 callBack) {
        Intrinsics.checkNotNullParameter(callBack, "$callBack");
        callBack.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v(d<FriendsRespData> callback) {
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new DataSource$innerFirstPage$1(this, callback, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w(long friendUin, d<FriendsRespData> callback) {
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new DataSource$innerFriendDressUp$1(callback, this, friendUin, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y(boolean isLoadingState) {
        this.isLoading.compareAndSet(!isLoadingState, isLoadingState);
    }

    private final void z(Function0<Unit> function) {
        if (this.isLoading.get()) {
            return;
        }
        y(true);
        function.invoke();
    }

    public final void r(final d<FriendsRespData> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        z(new Function0<Unit>() { // from class: com.tencent.sqshow.zootopia.friendsdressup.datasrouce.DataSource$getFirstPage$1

            /* JADX INFO: Access modifiers changed from: package-private */
            @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
            @DebugMetadata(c = "com.tencent.sqshow.zootopia.friendsdressup.datasrouce.DataSource$getFirstPage$1$1", f = "DataSource.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: com.tencent.sqshow.zootopia.friendsdressup.datasrouce.DataSource$getFirstPage$1$1, reason: invalid class name */
            /* loaded from: classes34.dex */
            public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ d<FriendsRespData> $callback;
                int label;
                final /* synthetic */ DataSource this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(DataSource dataSource, d<FriendsRespData> dVar, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.this$0 = dataSource;
                    this.$callback = dVar;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass1(this.this$0, this.$callback, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    long j3;
                    IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (this.label == 0) {
                        ResultKt.throwOnFailure(obj);
                        j3 = this.this$0.requestStartIndex;
                        com.tencent.sqshow.zootopia.friendsdressup.a.b("DataSource", " getFirstPage  startIndex " + j3);
                        this.this$0.requestOffset = 0L;
                        this.this$0.v(this.$callback);
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                BuildersKt__Builders_commonKt.launch$default(DataSource.this.getScope(), null, null, new AnonymousClass1(DataSource.this, callback, null), 3, null);
            }
        });
    }

    public final void s(final long friendUin, final d<FriendsRespData> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        z(new Function0<Unit>() { // from class: com.tencent.sqshow.zootopia.friendsdressup.datasrouce.DataSource$getFriendDressUp$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                DataSource.this.w(friendUin, callback);
            }
        });
    }

    public final void t(final d<FriendsRespData> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        com.tencent.sqshow.zootopia.friendsdressup.a.b("DataSource", " getMorePage  startIndex " + this.requestStartIndex + " thread " + Thread.currentThread().getName() + " enableLoadMore " + this.enableLoadMore + "  isLoading" + this.isLoading + " ");
        if (this.enableLoadMore) {
            z(new Function0<Unit>() { // from class: com.tencent.sqshow.zootopia.friendsdressup.datasrouce.DataSource$getMorePage$1

                /* JADX INFO: Access modifiers changed from: package-private */
                @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
                @DebugMetadata(c = "com.tencent.sqshow.zootopia.friendsdressup.datasrouce.DataSource$getMorePage$1$1", f = "DataSource.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
                /* renamed from: com.tencent.sqshow.zootopia.friendsdressup.datasrouce.DataSource$getMorePage$1$1, reason: invalid class name */
                /* loaded from: classes34.dex */
                public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ d<FriendsRespData> $callback;
                    int label;
                    final /* synthetic */ DataSource this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass1(d<FriendsRespData> dVar, DataSource dataSource, Continuation<? super AnonymousClass1> continuation) {
                        super(2, continuation);
                        this.$callback = dVar;
                        this.this$0 = dataSource;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new AnonymousClass1(this.$callback, this.this$0, continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        long j3;
                        long j16;
                        long j17;
                        e eVar;
                        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        if (this.label == 0) {
                            ResultKt.throwOnFailure(obj);
                            this.$callback.z();
                            final DataSource dataSource = this.this$0;
                            final d<FriendsRespData> dVar = this.$callback;
                            dataSource.hostCallBack = new e<FriendsRespData>() { // from class: com.tencent.sqshow.zootopia.friendsdressup.datasrouce.DataSource.getMorePage.1.1.1
                                @Override // com.tencent.mobileqq.zootopia.api.e
                                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                                public void onResultSuccess(final FriendsRespData result) {
                                    Intrinsics.checkNotNullParameter(result, "result");
                                    final DataSource dataSource2 = DataSource.this;
                                    final d<FriendsRespData> dVar2 = dVar;
                                    dataSource2.p(
                                    /*  JADX ERROR: Method code generation error
                                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000f: INVOKE 
                                          (r0v1 'dataSource2' com.tencent.sqshow.zootopia.friendsdressup.datasrouce.DataSource)
                                          (wrap:kotlin.jvm.functions.Function0<kotlin.Unit>:0x000c: CONSTRUCTOR 
                                          (r4v0 'result' zb3.b A[DONT_INLINE])
                                          (r2v0 'dVar2' com.tencent.mobileqq.zootopia.d<zb3.b> A[DONT_INLINE])
                                          (r0v1 'dataSource2' com.tencent.sqshow.zootopia.friendsdressup.datasrouce.DataSource A[DONT_INLINE])
                                         A[MD:(zb3.b, com.tencent.mobileqq.zootopia.d<zb3.b>, com.tencent.sqshow.zootopia.friendsdressup.datasrouce.DataSource):void (m), WRAPPED] (LINE:13) call: com.tencent.sqshow.zootopia.friendsdressup.datasrouce.DataSource$getMorePage$1$1$1$onResultSuccess$1.<init>(zb3.b, com.tencent.mobileqq.zootopia.d, com.tencent.sqshow.zootopia.friendsdressup.datasrouce.DataSource):void type: CONSTRUCTOR)
                                         DIRECT call: com.tencent.sqshow.zootopia.friendsdressup.datasrouce.DataSource.p(kotlin.jvm.functions.Function0):void A[MD:(kotlin.jvm.functions.Function0<kotlin.Unit>):void (m)] (LINE:1) in method: com.tencent.sqshow.zootopia.friendsdressup.datasrouce.DataSource.getMorePage.1.1.1.a(zb3.b):void, file: classes34.dex
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                                        	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:297)
                                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:276)
                                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:406)
                                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
                                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
                                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
                                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.sqshow.zootopia.friendsdressup.datasrouce.DataSource$getMorePage$1$1$1$onResultSuccess$1, state: NOT_LOADED
                                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:304)
                                        	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:781)
                                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
                                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
                                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
                                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1117)
                                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:884)
                                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:422)
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                                        	... 15 more
                                        */
                                    /*
                                        this = this;
                                        java.lang.String r0 = "result"
                                        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
                                        com.tencent.sqshow.zootopia.friendsdressup.datasrouce.DataSource r0 = com.tencent.sqshow.zootopia.friendsdressup.datasrouce.DataSource.this
                                        com.tencent.sqshow.zootopia.friendsdressup.datasrouce.DataSource$getMorePage$1$1$1$onResultSuccess$1 r1 = new com.tencent.sqshow.zootopia.friendsdressup.datasrouce.DataSource$getMorePage$1$1$1$onResultSuccess$1
                                        com.tencent.mobileqq.zootopia.d<zb3.b> r2 = r2
                                        r1.<init>(r4, r2, r0)
                                        com.tencent.sqshow.zootopia.friendsdressup.datasrouce.DataSource.c(r0, r1)
                                        return
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.sqshow.zootopia.friendsdressup.datasrouce.DataSource$getMorePage$1.AnonymousClass1.C98081.onResultSuccess(zb3.b):void");
                                }

                                @Override // com.tencent.mobileqq.zootopia.api.e
                                public void onResultFailure(final int error, final String message) {
                                    final DataSource dataSource2 = DataSource.this;
                                    final d<FriendsRespData> dVar2 = dVar;
                                    dataSource2.p(
                                    /*  JADX ERROR: Method code generation error
                                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0009: INVOKE 
                                          (r0v0 'dataSource2' com.tencent.sqshow.zootopia.friendsdressup.datasrouce.DataSource)
                                          (wrap:kotlin.jvm.functions.Function0<kotlin.Unit>:0x0006: CONSTRUCTOR 
                                          (r4v0 'error' int A[DONT_INLINE])
                                          (r5v0 'message' java.lang.String A[DONT_INLINE])
                                          (r0v0 'dataSource2' com.tencent.sqshow.zootopia.friendsdressup.datasrouce.DataSource A[DONT_INLINE])
                                          (r2v0 'dVar2' com.tencent.mobileqq.zootopia.d<zb3.b> A[DONT_INLINE])
                                         A[MD:(int, java.lang.String, com.tencent.sqshow.zootopia.friendsdressup.datasrouce.DataSource, com.tencent.mobileqq.zootopia.d<zb3.b>):void (m), WRAPPED] (LINE:7) call: com.tencent.sqshow.zootopia.friendsdressup.datasrouce.DataSource$getMorePage$1$1$1$onResultFailure$1.<init>(int, java.lang.String, com.tencent.sqshow.zootopia.friendsdressup.datasrouce.DataSource, com.tencent.mobileqq.zootopia.d):void type: CONSTRUCTOR)
                                         DIRECT call: com.tencent.sqshow.zootopia.friendsdressup.datasrouce.DataSource.p(kotlin.jvm.functions.Function0):void A[MD:(kotlin.jvm.functions.Function0<kotlin.Unit>):void (m)] (LINE:1) in method: com.tencent.sqshow.zootopia.friendsdressup.datasrouce.DataSource.getMorePage.1.1.1.onResultFailure(int, java.lang.String):void, file: classes34.dex
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                                        	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:297)
                                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:276)
                                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:406)
                                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
                                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
                                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
                                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.sqshow.zootopia.friendsdressup.datasrouce.DataSource$getMorePage$1$1$1$onResultFailure$1, state: NOT_LOADED
                                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:304)
                                        	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:781)
                                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
                                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
                                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
                                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1117)
                                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:884)
                                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:422)
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                                        	... 15 more
                                        */
                                    /*
                                        this = this;
                                        com.tencent.sqshow.zootopia.friendsdressup.datasrouce.DataSource r0 = com.tencent.sqshow.zootopia.friendsdressup.datasrouce.DataSource.this
                                        com.tencent.sqshow.zootopia.friendsdressup.datasrouce.DataSource$getMorePage$1$1$1$onResultFailure$1 r1 = new com.tencent.sqshow.zootopia.friendsdressup.datasrouce.DataSource$getMorePage$1$1$1$onResultFailure$1
                                        com.tencent.mobileqq.zootopia.d<zb3.b> r2 = r2
                                        r1.<init>(r4, r5, r0, r2)
                                        com.tencent.sqshow.zootopia.friendsdressup.datasrouce.DataSource.c(r0, r1)
                                        return
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.sqshow.zootopia.friendsdressup.datasrouce.DataSource$getMorePage$1.AnonymousClass1.C98081.onResultFailure(int, java.lang.String):void");
                                }
                            };
                            y84.d dVar2 = y84.d.f449567a;
                            j3 = this.this$0.requestStartIndex;
                            j16 = this.this$0.requestOffset;
                            j17 = this.this$0.sessionID;
                            eVar = this.this$0.hostCallBack;
                            Intrinsics.checkNotNull(eVar);
                            dVar2.d(j3, j16, j17, new b(eVar));
                            return Unit.INSTANCE;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                        return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    BuildersKt__Builders_commonKt.launch$default(DataSource.this.getScope(), null, null, new AnonymousClass1(callback, DataSource.this, null), 3, null);
                }
            });
        }
    }

    /* renamed from: u, reason: from getter */
    public final LifecycleCoroutineScope getScope() {
        return this.scope;
    }

    public final void x() {
        this.hostCallBack = null;
    }
}
