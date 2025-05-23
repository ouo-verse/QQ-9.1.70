package com.tencent.mobileqq.aio.msglist.preLoad.viewholder;

import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.aio.msglist.preLoad.viewholder.ViewHolderAsyncCreator$create$1", f = "ViewHolderAsyncCreator.kt", i = {0, 0, 0, 1, 1, 1}, l = {29, 31}, m = "invokeSuspend", n = {"recycleViewRef", "viewHolderType", "i", "recycleViewRef", "viewHolderType", "i"}, s = {"L$0", "I$0", "I$1", "L$0", "I$0", "I$1"})
/* loaded from: classes11.dex */
public final class ViewHolderAsyncCreator$create$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ List<Pair<Integer, Integer>> $createCollection;
    final /* synthetic */ RecyclerView $this_create;
    int I$0;
    int I$1;
    int I$2;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewHolderAsyncCreator$create$1(RecyclerView recyclerView, List<Pair<Integer, Integer>> list, Continuation<? super ViewHolderAsyncCreator$create$1> continuation) {
        super(2, continuation);
        this.$this_create = recyclerView;
        this.$createCollection = list;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, recyclerView, list, continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new ViewHolderAsyncCreator$create$1(this.$this_create, this.$createCollection, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00e7 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00e8  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x007c -> B:15:0x0097). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x00c7 -> B:14:0x00f2). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x00cf -> B:14:0x00f2). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x00e8 -> B:13:0x00ec). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        WeakReference weakReference;
        RecyclerView recyclerView;
        Iterator it;
        ViewHolderAsyncCreator$create$1 viewHolderAsyncCreator$create$1;
        WeakReference weakReference2;
        RecyclerView recyclerView2;
        int i3;
        Iterator it5;
        int i16;
        int i17;
        RecyclerView.ViewHolder viewHolder;
        RecyclerView recyclerView3;
        int intValue;
        int i18;
        Object d16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return iPatchRedirector.redirect((short) 2, (Object) this, obj);
        }
        Object obj2 = obj;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i19 = this.label;
        if (i19 != 0) {
            if (i19 != 1) {
                if (i19 == 2) {
                    i17 = this.I$2;
                    i16 = this.I$1;
                    int i26 = this.I$0;
                    Iterator it6 = (Iterator) this.L$2;
                    RecyclerView recyclerView4 = (RecyclerView) this.L$1;
                    WeakReference weakReference3 = (WeakReference) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    weakReference2 = weakReference3;
                    recyclerView2 = recyclerView4;
                    Iterator it7 = it6;
                    ViewHolderAsyncCreator$create$1 viewHolderAsyncCreator$create$12 = this;
                    Iterator it8 = it7;
                    i3 = i26;
                    viewHolderAsyncCreator$create$1 = viewHolderAsyncCreator$create$12;
                    it5 = it8;
                    weakReference = weakReference2;
                    Iterator it9 = it5;
                    intValue = i17;
                    it = it9;
                    RecyclerView recyclerView5 = recyclerView2;
                    i18 = i16 + 1;
                    recyclerView = recyclerView5;
                    if (i18 < intValue) {
                        ViewHolderAsyncCreator viewHolderAsyncCreator = ViewHolderAsyncCreator.f192687a;
                        RecyclerView.RecycledViewPool recycledViewPool = recyclerView.getRecycledViewPool();
                        Intrinsics.checkNotNullExpressionValue(recycledViewPool, "recycledViewPool");
                        viewHolderAsyncCreator$create$1.L$0 = weakReference;
                        viewHolderAsyncCreator$create$1.L$1 = recyclerView;
                        viewHolderAsyncCreator$create$1.L$2 = it;
                        viewHolderAsyncCreator$create$1.I$0 = i3;
                        viewHolderAsyncCreator$create$1.I$1 = i18;
                        viewHolderAsyncCreator$create$1.I$2 = intValue;
                        viewHolderAsyncCreator$create$1.label = 1;
                        d16 = viewHolderAsyncCreator.d(recycledViewPool, weakReference, i3, viewHolderAsyncCreator$create$1);
                        if (d16 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        weakReference2 = weakReference;
                        obj2 = d16;
                        int i27 = intValue;
                        it5 = it;
                        i17 = i27;
                        int i28 = i18;
                        recyclerView2 = recyclerView;
                        i16 = i28;
                        viewHolder = (RecyclerView.ViewHolder) obj2;
                        if (viewHolder != null && (recyclerView3 = (RecyclerView) weakReference2.get()) != null) {
                            ViewHolderAsyncCreator viewHolderAsyncCreator2 = ViewHolderAsyncCreator.f192687a;
                            viewHolderAsyncCreator$create$1.L$0 = weakReference2;
                            viewHolderAsyncCreator$create$1.L$1 = recyclerView2;
                            viewHolderAsyncCreator$create$1.L$2 = it5;
                            viewHolderAsyncCreator$create$1.I$0 = i3;
                            viewHolderAsyncCreator$create$1.I$1 = i16;
                            viewHolderAsyncCreator$create$1.I$2 = i17;
                            viewHolderAsyncCreator$create$1.label = 2;
                            obj2 = viewHolderAsyncCreator2.e(recyclerView3, viewHolder, viewHolderAsyncCreator$create$1);
                            if (obj2 != coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            Iterator it10 = it5;
                            viewHolderAsyncCreator$create$12 = viewHolderAsyncCreator$create$1;
                            i26 = i3;
                            it7 = it10;
                            Iterator it82 = it7;
                            i3 = i26;
                            viewHolderAsyncCreator$create$1 = viewHolderAsyncCreator$create$12;
                            it5 = it82;
                        }
                        weakReference = weakReference2;
                        Iterator it92 = it5;
                        intValue = i17;
                        it = it92;
                        RecyclerView recyclerView52 = recyclerView2;
                        i18 = i16 + 1;
                        recyclerView = recyclerView52;
                        if (i18 < intValue) {
                        }
                    }
                    if (!it.hasNext()) {
                        Pair pair = (Pair) it.next();
                        i3 = ((Number) pair.getFirst()).intValue();
                        intValue = ((Number) pair.getSecond()).intValue();
                        i18 = 0;
                        if (i18 < intValue) {
                        }
                        if (!it.hasNext()) {
                            return Unit.INSTANCE;
                        }
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                i17 = this.I$2;
                i16 = this.I$1;
                int i29 = this.I$0;
                it5 = (Iterator) this.L$2;
                RecyclerView recyclerView6 = (RecyclerView) this.L$1;
                WeakReference weakReference4 = (WeakReference) this.L$0;
                ResultKt.throwOnFailure(obj);
                weakReference2 = weakReference4;
                recyclerView2 = recyclerView6;
                i3 = i29;
                viewHolderAsyncCreator$create$1 = this;
                viewHolder = (RecyclerView.ViewHolder) obj2;
                if (viewHolder != null) {
                    ViewHolderAsyncCreator viewHolderAsyncCreator22 = ViewHolderAsyncCreator.f192687a;
                    viewHolderAsyncCreator$create$1.L$0 = weakReference2;
                    viewHolderAsyncCreator$create$1.L$1 = recyclerView2;
                    viewHolderAsyncCreator$create$1.L$2 = it5;
                    viewHolderAsyncCreator$create$1.I$0 = i3;
                    viewHolderAsyncCreator$create$1.I$1 = i16;
                    viewHolderAsyncCreator$create$1.I$2 = i17;
                    viewHolderAsyncCreator$create$1.label = 2;
                    obj2 = viewHolderAsyncCreator22.e(recyclerView3, viewHolder, viewHolderAsyncCreator$create$1);
                    if (obj2 != coroutine_suspended) {
                    }
                }
                weakReference = weakReference2;
                Iterator it922 = it5;
                intValue = i17;
                it = it922;
                RecyclerView recyclerView522 = recyclerView2;
                i18 = i16 + 1;
                recyclerView = recyclerView522;
                if (i18 < intValue) {
                }
                if (!it.hasNext()) {
                }
            }
        } else {
            ResultKt.throwOnFailure(obj);
            weakReference = new WeakReference(this.$this_create);
            List<Pair<Integer, Integer>> list = this.$createCollection;
            recyclerView = this.$this_create;
            it = list.iterator();
            viewHolderAsyncCreator$create$1 = this;
            if (!it.hasNext()) {
            }
        }
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((ViewHolderAsyncCreator$create$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
