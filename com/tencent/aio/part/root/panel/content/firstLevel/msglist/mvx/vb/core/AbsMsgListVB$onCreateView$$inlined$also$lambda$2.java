package com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core;

import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\t\u001a\u00020\u0005\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0003*\u00020\u0002*\u00020\u0004H\u008a@\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"Lat/b;", "I", "Lcom/tencent/aio/base/mvi/part/MsgListUiState;", ExifInterface.LATITUDE_SOUTH, "Lkotlinx/coroutines/CoroutineScope;", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/core/AbsMsgListVB$$special$$inlined$apply$lambda$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.AbsMsgListVB$onCreateView$1$pool$2$2", f = "AbsMsgListVB.kt", i = {0, 0, 1, 1, 2, 2, 2, 2}, l = {224, 224, 224}, m = "invokeSuspend", n = {"$this$launch", "it", "$this$launch", "it", "$this$launch", "it", "result$iv$iv", "start$iv$iv$iv"}, s = {"L$0", "L$2", "L$0", "L$2", "L$0", "L$2", "L$5", "J$0"})
/* loaded from: classes3.dex */
public final class AbsMsgListVB$onCreateView$$inlined$also$lambda$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ RecyclerView.RecycledViewPool $this_apply;
    int I$0;
    int I$1;
    long J$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    final /* synthetic */ AbsMsgListVB this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\t\u001a\u00020\u0005\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0003*\u00020\u0002*\u00020\u0004H\u008a@\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"Lat/b;", "I", "Lcom/tencent/aio/base/mvi/part/MsgListUiState;", ExifInterface.LATITUDE_SOUTH, "Lkotlinx/coroutines/CoroutineScope;", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/core/AbsMsgListVB$$special$$inlined$apply$lambda$1$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    @DebugMetadata(c = "com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.AbsMsgListVB$onCreateView$1$pool$2$2$1$2", f = "AbsMsgListVB.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.AbsMsgListVB$onCreateView$$inlined$also$lambda$2$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        static IPatchRedirector $redirector_;
        final /* synthetic */ CoroutineScope $this_launch$inlined;
        final /* synthetic */ RecyclerView.ViewHolder $viewHolder;
        int label;
        final /* synthetic */ AbsMsgListVB$onCreateView$$inlined$also$lambda$2 this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(RecyclerView.ViewHolder viewHolder, Continuation continuation, AbsMsgListVB$onCreateView$$inlined$also$lambda$2 absMsgListVB$onCreateView$$inlined$also$lambda$2, CoroutineScope coroutineScope) {
            super(2, continuation);
            this.$viewHolder = viewHolder;
            this.this$0 = absMsgListVB$onCreateView$$inlined$also$lambda$2;
            this.$this_launch$inlined = coroutineScope;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, viewHolder, continuation, absMsgListVB$onCreateView$$inlined$also$lambda$2, coroutineScope);
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> completion) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) completion);
            }
            Intrinsics.checkNotNullParameter(completion, "completion");
            return new AnonymousClass1(this.$viewHolder, completion, this.this$0, this.$this_launch$inlined);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
            }
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.this$0.$this_apply.putRecycledView(this.$viewHolder);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return iPatchRedirector.redirect((short) 2, (Object) this, obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbsMsgListVB$onCreateView$$inlined$also$lambda$2(RecyclerView.RecycledViewPool recycledViewPool, Continuation continuation, AbsMsgListVB absMsgListVB) {
        super(2, continuation);
        this.$this_apply = recycledViewPool;
        this.this$0 = absMsgListVB;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, recycledViewPool, continuation, absMsgListVB);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> completion) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) completion);
        }
        Intrinsics.checkNotNullParameter(completion, "completion");
        AbsMsgListVB$onCreateView$$inlined$also$lambda$2 absMsgListVB$onCreateView$$inlined$also$lambda$2 = new AbsMsgListVB$onCreateView$$inlined$also$lambda$2(this.$this_apply, completion, this.this$0);
        absMsgListVB$onCreateView$$inlined$also$lambda$2.L$0 = obj;
        return absMsgListVB$onCreateView$$inlined$also$lambda$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
        }
        return ((AbsMsgListVB$onCreateView$$inlined$also$lambda$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(20:100|101|102|(1:78)|79|80|62|63|64|29|30|31|32|33|34|35|36|37|38|(3:19|20|(2:22|(1:24)(15:25|26|27|28|29|30|31|32|33|34|35|36|37|38|(3:18|11|(4:13|(1:15)|16|(0)(0))(2:94|95))(0)))(2:54|(2:56|(1:58)(17:59|60|61|62|63|64|29|30|31|32|33|34|35|36|37|38|(0)(0)))(8:68|69|70|71|72|73|74|(1:76)(18:77|78|79|80|62|63|64|29|30|31|32|33|34|35|36|37|38|(0)(0)))))(0)) */
    /* JADX WARN: Can't wrap try/catch for region: R(20:100|101|102|78|79|80|62|63|64|29|30|31|32|33|34|35|36|37|38|(3:19|20|(2:22|(1:24)(15:25|26|27|28|29|30|31|32|33|34|35|36|37|38|(3:18|11|(4:13|(1:15)|16|(0)(0))(2:94|95))(0)))(2:54|(2:56|(1:58)(17:59|60|61|62|63|64|29|30|31|32|33|34|35|36|37|38|(0)(0)))(8:68|69|70|71|72|73|74|(1:76)(18:77|78|79|80|62|63|64|29|30|31|32|33|34|35|36|37|38|(0)(0)))))(0)) */
    /* JADX WARN: Can't wrap try/catch for region: R(8:68|69|70|71|72|73|74|(1:76)(18:77|78|79|80|62|63|64|29|30|31|32|33|34|35|36|37|38|(0)(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0253, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x025c, code lost:
    
        r9 = r3;
        r12 = r15;
        r13 = r16;
        r2 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0255, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0256, code lost:
    
        r17 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0259, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x025a, code lost:
    
        r17 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0261, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0262, code lost:
    
        r17 = null;
        r2 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x026a, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x026e, code lost:
    
        r17 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0275, code lost:
    
        r9 = r2;
        r2 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x026c, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:13:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x02a8  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0133 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x02b0  */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v32 */
    /* JADX WARN: Type inference failed for: r2v33 */
    /* JADX WARN: Type inference failed for: r2v34 */
    /* JADX WARN: Type inference failed for: r3v4, types: [androidx.recyclerview.widget.RecyclerView$ViewHolder, T] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x02a8 -> B:11:0x00b7). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Object obj2;
        CoroutineScope coroutineScope;
        Pair pair;
        Object obj3;
        AbsMsgListVB$onCreateView$$inlined$also$lambda$2 absMsgListVB$onCreateView$$inlined$also$lambda$2;
        int i3;
        int i16;
        Object obj4;
        CoroutineScope coroutineScope2;
        Object obj5;
        Object obj6;
        Iterator it;
        int i17;
        int i18;
        Iterator it5;
        Iterator it6;
        CoroutineScope coroutineScope3;
        Iterator it7;
        Iterator it8;
        CoroutineScope coroutineScope4;
        Iterator it9;
        AbsMsgListVB$onCreateView$$inlined$also$lambda$2 absMsgListVB$onCreateView$$inlined$also$lambda$22;
        IPatchRedirector iPatchRedirector = $redirector_;
        ?? r26 = 2;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return iPatchRedirector.redirect((short) 2, (Object) this, obj);
        }
        Object obj7 = obj;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i19 = this.label;
        Object obj8 = null;
        if (i19 != 0) {
            try {
            } catch (Exception e16) {
                e = e16;
                obj2 = null;
                coroutineScope = 1;
                pair = 3;
                obj3 = coroutine_suspended;
                absMsgListVB$onCreateView$$inlined$also$lambda$2 = this;
                e.printStackTrace();
                com.tencent.aio.base.log.a.f69187b.e("AbsMsgListVB", "preCreate " + ((Number) pair.getFirst()).intValue());
                it6 = r26;
                coroutineScope3 = coroutineScope;
                i16++;
                obj8 = obj2;
                if (i16 < i3) {
                }
            }
            if (i19 != 1) {
                if (i19 != 2) {
                    if (i19 == 3) {
                        long j3 = this.J$0;
                        i3 = this.I$1;
                        i16 = this.I$0;
                        Ref.ObjectRef objectRef = (Ref.ObjectRef) this.L$5;
                        String str = (String) this.L$4;
                        Ref.ObjectRef objectRef2 = (Ref.ObjectRef) this.L$3;
                        Pair pair2 = (Pair) this.L$2;
                        Iterator it10 = (Iterator) this.L$1;
                        CoroutineScope coroutineScope5 = (CoroutineScope) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        coroutineScope = coroutineScope5;
                        pair = pair2;
                        obj3 = coroutine_suspended;
                        absMsgListVB$onCreateView$$inlined$also$lambda$2 = this;
                        Iterator it11 = it10;
                        try {
                        } catch (Exception e17) {
                            e = e17;
                            obj2 = null;
                            r26 = it11;
                            e.printStackTrace();
                            com.tencent.aio.base.log.a.f69187b.e("AbsMsgListVB", "preCreate " + ((Number) pair.getFirst()).intValue());
                            it6 = r26;
                            coroutineScope3 = coroutineScope;
                            i16++;
                            obj8 = obj2;
                            if (i16 < i3) {
                            }
                        }
                        objectRef2.element = (RecyclerView.ViewHolder) obj7;
                        Log.w("AIO#", str + " spend " + Boxing.boxLong(Boxing.boxLong(System.currentTimeMillis() - j3).longValue()).longValue());
                        obj6 = objectRef.element;
                        coroutineScope2 = coroutineScope;
                        it = it11;
                        com.tencent.aio.pref.a.f69788j.e();
                        i17 = i3;
                        i18 = i16;
                        it7 = it;
                        obj2 = null;
                        BuildersKt__Builders_commonKt.launch$default(coroutineScope2, Dispatchers.getMain(), null, new AnonymousClass1((RecyclerView.ViewHolder) obj6, null, absMsgListVB$onCreateView$$inlined$also$lambda$2, coroutineScope2), 2, null);
                        i3 = i17;
                        CoroutineScope coroutineScope6 = coroutineScope2;
                        it6 = it7;
                        coroutineScope3 = coroutineScope6;
                        i16 = i18 + 1;
                        obj8 = null;
                        if (i16 < i3) {
                            try {
                            } catch (Exception e18) {
                                e = e18;
                                obj2 = obj8;
                            }
                            com.tencent.aio.pref.a aVar = com.tencent.aio.pref.a.f69788j;
                            if (!aVar.g()) {
                                AbsMsgListVB absMsgListVB = absMsgListVB$onCreateView$$inlined$also$lambda$2.this$0;
                                int intValue = ((Number) pair.getFirst()).intValue();
                                absMsgListVB$onCreateView$$inlined$also$lambda$2.L$0 = coroutineScope3;
                                absMsgListVB$onCreateView$$inlined$also$lambda$2.L$1 = it6;
                                absMsgListVB$onCreateView$$inlined$also$lambda$2.L$2 = pair;
                                absMsgListVB$onCreateView$$inlined$also$lambda$2.L$3 = obj8;
                                absMsgListVB$onCreateView$$inlined$also$lambda$2.L$4 = obj8;
                                absMsgListVB$onCreateView$$inlined$also$lambda$2.L$5 = obj8;
                                absMsgListVB$onCreateView$$inlined$also$lambda$2.I$0 = i16;
                                absMsgListVB$onCreateView$$inlined$also$lambda$2.I$1 = i3;
                                absMsgListVB$onCreateView$$inlined$also$lambda$2.label = 1;
                                obj4 = absMsgListVB.x1(intValue, absMsgListVB$onCreateView$$inlined$also$lambda$2);
                                if (obj4 == obj3) {
                                    return obj3;
                                }
                                Iterator it12 = it6;
                                coroutineScope2 = coroutineScope3;
                                it8 = it12;
                                try {
                                } catch (Exception e19) {
                                    e = e19;
                                    obj2 = obj8;
                                    Iterator it13 = it8;
                                    coroutineScope = coroutineScope2;
                                    r26 = it13;
                                    e.printStackTrace();
                                    com.tencent.aio.base.log.a.f69187b.e("AbsMsgListVB", "preCreate " + ((Number) pair.getFirst()).intValue());
                                    it6 = r26;
                                    coroutineScope3 = coroutineScope;
                                    i16++;
                                    obj8 = obj2;
                                    if (i16 < i3) {
                                    }
                                }
                                obj6 = (RecyclerView.ViewHolder) obj4;
                                i17 = i3;
                                i18 = i16;
                                it7 = it8;
                                obj2 = null;
                                BuildersKt__Builders_commonKt.launch$default(coroutineScope2, Dispatchers.getMain(), null, new AnonymousClass1((RecyclerView.ViewHolder) obj6, null, absMsgListVB$onCreateView$$inlined$also$lambda$2, coroutineScope2), 2, null);
                                i3 = i17;
                                CoroutineScope coroutineScope62 = coroutineScope2;
                                it6 = it7;
                                coroutineScope3 = coroutineScope62;
                                i16 = i18 + 1;
                                obj8 = null;
                                if (i16 < i3) {
                                    coroutineScope4 = coroutineScope3;
                                    it9 = it6;
                                    absMsgListVB$onCreateView$$inlined$also$lambda$22 = absMsgListVB$onCreateView$$inlined$also$lambda$2;
                                    coroutine_suspended = obj3;
                                    if (!it9.hasNext()) {
                                        Pair pair3 = (Pair) it9.next();
                                        if (com.tencent.aio.base.a.f69150c.a()) {
                                            com.tencent.aio.base.log.a aVar2 = com.tencent.aio.base.log.a.f69187b;
                                            StringBuilder sb5 = new StringBuilder();
                                            sb5.append(absMsgListVB$onCreateView$$inlined$also$lambda$22.this$0.hashCode());
                                            sb5.append(" thread ");
                                            Thread currentThread = Thread.currentThread();
                                            Intrinsics.checkNotNullExpressionValue(currentThread, "Thread.currentThread()");
                                            sb5.append(currentThread.getName());
                                            sb5.append(" type->");
                                            sb5.append(((Number) pair3.getFirst()).intValue());
                                            sb5.append(" size->");
                                            sb5.append(((Number) pair3.getSecond()).intValue());
                                            aVar2.d("AbsMsgListVB", sb5.toString());
                                        }
                                        i3 = ((Number) pair3.getSecond()).intValue();
                                        i16 = 0;
                                        pair = pair3;
                                        obj3 = coroutine_suspended;
                                        absMsgListVB$onCreateView$$inlined$also$lambda$2 = absMsgListVB$onCreateView$$inlined$also$lambda$22;
                                        it6 = it9;
                                        coroutineScope3 = coroutineScope4;
                                        if (i16 < i3) {
                                        }
                                    } else {
                                        return Unit.INSTANCE;
                                    }
                                }
                            } else {
                                aVar.b("preCreateViewHolder");
                                str = "AIO#preCreateViewHolder";
                                if (!aVar.h()) {
                                    AbsMsgListVB absMsgListVB2 = absMsgListVB$onCreateView$$inlined$also$lambda$2.this$0;
                                    int intValue2 = ((Number) pair.getFirst()).intValue();
                                    absMsgListVB$onCreateView$$inlined$also$lambda$2.L$0 = coroutineScope3;
                                    absMsgListVB$onCreateView$$inlined$also$lambda$2.L$1 = it6;
                                    absMsgListVB$onCreateView$$inlined$also$lambda$2.L$2 = pair;
                                    absMsgListVB$onCreateView$$inlined$also$lambda$2.L$3 = obj8;
                                    absMsgListVB$onCreateView$$inlined$also$lambda$2.L$4 = obj8;
                                    absMsgListVB$onCreateView$$inlined$also$lambda$2.L$5 = obj8;
                                    absMsgListVB$onCreateView$$inlined$also$lambda$2.I$0 = i16;
                                    absMsgListVB$onCreateView$$inlined$also$lambda$2.I$1 = i3;
                                    absMsgListVB$onCreateView$$inlined$also$lambda$2.label = 2;
                                    obj5 = absMsgListVB2.x1(intValue2, absMsgListVB$onCreateView$$inlined$also$lambda$2);
                                    if (obj5 == obj3) {
                                        return obj3;
                                    }
                                    Iterator it14 = it6;
                                    coroutineScope2 = coroutineScope3;
                                    it5 = it14;
                                    obj6 = (RecyclerView.ViewHolder) obj5;
                                    it = it5;
                                    com.tencent.aio.pref.a.f69788j.e();
                                    i17 = i3;
                                    i18 = i16;
                                    it7 = it;
                                    obj2 = null;
                                    BuildersKt__Builders_commonKt.launch$default(coroutineScope2, Dispatchers.getMain(), null, new AnonymousClass1((RecyclerView.ViewHolder) obj6, null, absMsgListVB$onCreateView$$inlined$also$lambda$2, coroutineScope2), 2, null);
                                    i3 = i17;
                                    CoroutineScope coroutineScope622 = coroutineScope2;
                                    it6 = it7;
                                    coroutineScope3 = coroutineScope622;
                                    i16 = i18 + 1;
                                    obj8 = null;
                                    if (i16 < i3) {
                                    }
                                } else {
                                    objectRef = new Ref.ObjectRef();
                                    long currentTimeMillis = System.currentTimeMillis();
                                    AbsMsgListVB absMsgListVB3 = absMsgListVB$onCreateView$$inlined$also$lambda$2.this$0;
                                    int intValue3 = ((Number) pair.getFirst()).intValue();
                                    absMsgListVB$onCreateView$$inlined$also$lambda$2.L$0 = coroutineScope3;
                                    absMsgListVB$onCreateView$$inlined$also$lambda$2.L$1 = it6;
                                    absMsgListVB$onCreateView$$inlined$also$lambda$2.L$2 = pair;
                                    absMsgListVB$onCreateView$$inlined$also$lambda$2.L$3 = objectRef;
                                    absMsgListVB$onCreateView$$inlined$also$lambda$2.L$4 = str;
                                    absMsgListVB$onCreateView$$inlined$also$lambda$2.L$5 = objectRef;
                                    absMsgListVB$onCreateView$$inlined$also$lambda$2.I$0 = i16;
                                    absMsgListVB$onCreateView$$inlined$also$lambda$2.I$1 = i3;
                                    absMsgListVB$onCreateView$$inlined$also$lambda$2.J$0 = currentTimeMillis;
                                    absMsgListVB$onCreateView$$inlined$also$lambda$2.label = 3;
                                    Object x16 = absMsgListVB3.x1(intValue3, absMsgListVB$onCreateView$$inlined$also$lambda$2);
                                    if (x16 == obj3) {
                                        return obj3;
                                    }
                                    objectRef2 = objectRef;
                                    coroutineScope = coroutineScope3;
                                    it11 = it6;
                                    obj7 = x16;
                                    j3 = currentTimeMillis;
                                    objectRef2.element = (RecyclerView.ViewHolder) obj7;
                                    Log.w("AIO#", str + " spend " + Boxing.boxLong(Boxing.boxLong(System.currentTimeMillis() - j3).longValue()).longValue());
                                    obj6 = objectRef.element;
                                    coroutineScope2 = coroutineScope;
                                    it = it11;
                                    com.tencent.aio.pref.a.f69788j.e();
                                    i17 = i3;
                                    i18 = i16;
                                    it7 = it;
                                    obj2 = null;
                                    BuildersKt__Builders_commonKt.launch$default(coroutineScope2, Dispatchers.getMain(), null, new AnonymousClass1((RecyclerView.ViewHolder) obj6, null, absMsgListVB$onCreateView$$inlined$also$lambda$2, coroutineScope2), 2, null);
                                    i3 = i17;
                                    CoroutineScope coroutineScope6222 = coroutineScope2;
                                    it6 = it7;
                                    coroutineScope3 = coroutineScope6222;
                                    i16 = i18 + 1;
                                    obj8 = null;
                                    if (i16 < i3) {
                                    }
                                }
                            }
                        }
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    i3 = this.I$1;
                    i16 = this.I$0;
                    Pair pair4 = (Pair) this.L$2;
                    Iterator it15 = (Iterator) this.L$1;
                    CoroutineScope coroutineScope7 = (CoroutineScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    obj5 = obj7;
                    coroutineScope2 = coroutineScope7;
                    pair = pair4;
                    obj3 = coroutine_suspended;
                    absMsgListVB$onCreateView$$inlined$also$lambda$2 = this;
                    it5 = it15;
                    obj6 = (RecyclerView.ViewHolder) obj5;
                    it = it5;
                    com.tencent.aio.pref.a.f69788j.e();
                    i17 = i3;
                    i18 = i16;
                    it7 = it;
                    obj2 = null;
                    BuildersKt__Builders_commonKt.launch$default(coroutineScope2, Dispatchers.getMain(), null, new AnonymousClass1((RecyclerView.ViewHolder) obj6, null, absMsgListVB$onCreateView$$inlined$also$lambda$2, coroutineScope2), 2, null);
                    i3 = i17;
                    CoroutineScope coroutineScope62222 = coroutineScope2;
                    it6 = it7;
                    coroutineScope3 = coroutineScope62222;
                    i16 = i18 + 1;
                    obj8 = null;
                    if (i16 < i3) {
                    }
                }
            } else {
                i3 = this.I$1;
                i16 = this.I$0;
                Pair pair5 = (Pair) this.L$2;
                Iterator it16 = (Iterator) this.L$1;
                CoroutineScope coroutineScope8 = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                obj4 = obj7;
                coroutineScope2 = coroutineScope8;
                pair = pair5;
                obj3 = coroutine_suspended;
                absMsgListVB$onCreateView$$inlined$also$lambda$2 = this;
                it8 = it16;
                obj6 = (RecyclerView.ViewHolder) obj4;
                i17 = i3;
                i18 = i16;
                it7 = it8;
                obj2 = null;
                BuildersKt__Builders_commonKt.launch$default(coroutineScope2, Dispatchers.getMain(), null, new AnonymousClass1((RecyclerView.ViewHolder) obj6, null, absMsgListVB$onCreateView$$inlined$also$lambda$2, coroutineScope2), 2, null);
                i3 = i17;
                CoroutineScope coroutineScope622222 = coroutineScope2;
                it6 = it7;
                coroutineScope3 = coroutineScope622222;
                i16 = i18 + 1;
                obj8 = null;
                if (i16 < i3) {
                }
            }
        } else {
            ResultKt.throwOnFailure(obj);
            coroutineScope4 = (CoroutineScope) this.L$0;
            it9 = this.this$0.h().iterator();
            absMsgListVB$onCreateView$$inlined$also$lambda$22 = this;
            if (!it9.hasNext()) {
            }
        }
    }
}
