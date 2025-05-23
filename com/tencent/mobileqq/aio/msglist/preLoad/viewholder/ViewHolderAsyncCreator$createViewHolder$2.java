package com.tencent.mobileqq.aio.msglist.preLoad.viewholder;

import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.aio.msglist.b;
import com.tencent.mobileqq.aio.msglist.c;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.aio.msglist.preLoad.viewholder.ViewHolderAsyncCreator$createViewHolder$2", f = "ViewHolderAsyncCreator.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes11.dex */
final class ViewHolderAsyncCreator$createViewHolder$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super RecyclerView.ViewHolder>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ WeakReference<RecyclerView> $recycleViewRef;
    final /* synthetic */ RecyclerView.RecycledViewPool $recycledViewPool;
    final /* synthetic */ int $viewHolderType;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewHolderAsyncCreator$createViewHolder$2(WeakReference<RecyclerView> weakReference, int i3, RecyclerView.RecycledViewPool recycledViewPool, Continuation<? super ViewHolderAsyncCreator$createViewHolder$2> continuation) {
        super(2, continuation);
        this.$recycleViewRef = weakReference;
        this.$viewHolderType = i3;
        this.$recycledViewPool = recycledViewPool;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, weakReference, Integer.valueOf(i3), recycledViewPool, continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new ViewHolderAsyncCreator$createViewHolder$2(this.$recycleViewRef, this.$viewHolderType, this.$recycledViewPool, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Map map;
        int i3;
        RecyclerView recyclerView;
        RecyclerView.Adapter adapter;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                if (this.$recycleViewRef.get() != null) {
                    map = MapsKt__MapsKt.toMap(b.f190447a.b());
                    Integer num = (Integer) map.get(Boxing.boxInt(this.$viewHolderType));
                    if (num != null) {
                        i3 = num.intValue();
                    } else {
                        i3 = 5;
                    }
                    if (c.a(this.$recycledViewPool, this.$viewHolderType) >= i3 || (recyclerView = this.$recycleViewRef.get()) == null || (adapter = recyclerView.getAdapter()) == null) {
                        return null;
                    }
                    RecyclerView recyclerView2 = this.$recycleViewRef.get();
                    if (recyclerView2 != null) {
                        return adapter.createViewHolder(recyclerView2, this.$viewHolderType);
                    }
                    throw new IllegalStateException("Required value was null.".toString());
                }
                return null;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super RecyclerView.ViewHolder> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((ViewHolderAsyncCreator$createViewHolder$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
