package com.tencent.mobileqq.wink.magicstudio;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.wink.magicstudio.MagicStudioCreationViewModel;
import com.tencent.mobileqq.wink.view.ai;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.SharedFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.magicstudio.MagicStudioCreationViewModel$collectCreationEvent$1", f = "MagicStudioCreationViewModel.kt", i = {}, l = {1147}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
public final class MagicStudioCreationViewModel$collectCreationEvent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $cancelAction;
    final /* synthetic */ Context $context;
    final /* synthetic */ Function0<Unit> $failedAction;
    final /* synthetic */ Function1<MagicStudioCreationViewModel.b.GotoMultiSelect, Unit> $gotoMultiSelect;
    final /* synthetic */ boolean $hideProgressDialog;
    final /* synthetic */ View $parentView;
    final /* synthetic */ Function1<MagicStudioCreationViewModel.b.ProgressUpdate, Unit> $progressAction;
    int label;
    final /* synthetic */ MagicStudioCreationViewModel this$0;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "kotlin.jvm.PlatformType", "a", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    static final class a<V> implements Callable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ MagicStudioCreationViewModel f323640d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f323641e;

        a(MagicStudioCreationViewModel magicStudioCreationViewModel, Function0<Unit> function0) {
            this.f323640d = magicStudioCreationViewModel;
            this.f323641e = function0;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean call() {
            this.f323640d.r2(true);
            Function0<Unit> function0 = this.f323641e;
            if (function0 != null) {
                function0.invoke();
            }
            return Boolean.TRUE;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "value", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b implements FlowCollector<MagicStudioCreationViewModel.b> {
        final /* synthetic */ Function1 C;
        final /* synthetic */ Function0 D;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ MagicStudioCreationViewModel f323642d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Function0 f323643e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Function1 f323644f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ boolean f323645h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ Context f323646i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ View f323647m;

        public b(MagicStudioCreationViewModel magicStudioCreationViewModel, Function0 function0, Function1 function1, boolean z16, Context context, View view, Function1 function12, Function0 function02) {
            this.f323642d = magicStudioCreationViewModel;
            this.f323643e = function0;
            this.f323644f = function1;
            this.f323645h = z16;
            this.f323646i = context;
            this.f323647m = view;
            this.C = function12;
            this.D = function02;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        @Nullable
        public Object emit(MagicStudioCreationViewModel.b bVar, @NotNull Continuation<? super Unit> continuation) {
            ai aiVar;
            ai aiVar2;
            ai aiVar3;
            ai aiVar4;
            int i3;
            ai aiVar5;
            List<String> listOf;
            ai aiVar6;
            ai aiVar7;
            MagicStudioCreationViewModel.b bVar2 = bVar;
            w53.b.a("MagicStudioCreationViewModel", "collectCreationEvent eventName:" + bVar2.getClass());
            if (bVar2 instanceof MagicStudioCreationViewModel.b.MakeFail) {
                aiVar7 = this.f323642d.nextDialog;
                if (aiVar7 != null) {
                    aiVar7.dismiss();
                }
                this.f323642d.nextDialog = null;
                Function0 function0 = this.f323643e;
                if (function0 != null) {
                    function0.invoke();
                }
            } else if (bVar2 instanceof MagicStudioCreationViewModel.b.ProgressUpdate) {
                Function1 function1 = this.f323644f;
                if (function1 != null) {
                    function1.invoke(bVar2);
                }
                if (!this.f323645h) {
                    MagicStudioCreationViewModel.b.ProgressUpdate progressUpdate = (MagicStudioCreationViewModel.b.ProgressUpdate) bVar2;
                    if (progressUpdate.getProgress() == 0) {
                        aiVar5 = this.f323642d.nextDialog;
                        if (aiVar5 != null) {
                            aiVar5.dismiss();
                        }
                        ai.b h16 = new ai.b(this.f323646i, R.style.f173547a45).f(this.f323647m).h(true);
                        final MagicStudioCreationViewModel magicStudioCreationViewModel = this.f323642d;
                        final Function0 function02 = this.D;
                        ai.b d16 = h16.e(new Runnable() { // from class: com.tencent.mobileqq.wink.magicstudio.MagicStudioCreationViewModel$collectCreationEvent$1$1$nextDialogBuilder$1
                            @Override // java.lang.Runnable
                            public final void run() {
                                MagicStudioCreationViewModel.this.r2(true);
                                Function0<Unit> function03 = function02;
                                if (function03 != null) {
                                    function03.invoke();
                                }
                            }
                        }).d(new a(this.f323642d, this.D));
                        if (!this.f323642d.getIsRegenerate()) {
                            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"\u6b63\u5728\u4e0a\u4f20\u56fe\u7247...", "\u6b63\u5728\u8fd0\u7528\u6ee4\u955c...", "\u52a0\u901f\u751f\u6210\u4e2d..."});
                            d16.g(listOf);
                        } else {
                            d16.i("\u91cd\u65b0\u751f\u6210\u4e2d...");
                        }
                        this.f323642d.nextDialog = d16.a();
                        aiVar6 = this.f323642d.nextDialog;
                        if (aiVar6 != null) {
                            aiVar6.show();
                        }
                    }
                    aiVar2 = this.f323642d.nextDialog;
                    if (aiVar2 != null) {
                        aiVar4 = this.f323642d.nextDialog;
                        if (aiVar4 != null) {
                            i3 = aiVar4.j();
                        } else {
                            i3 = 0;
                        }
                        aiVar2.v(i3 + progressUpdate.getProgress());
                    }
                    if (progressUpdate.getProgress() == 1000) {
                        aiVar3 = this.f323642d.nextDialog;
                        if (aiVar3 != null) {
                            aiVar3.dismiss();
                        }
                        this.f323642d.nextDialog = null;
                    }
                }
            } else if (bVar2 instanceof MagicStudioCreationViewModel.b.GotoMultiSelect) {
                Function1 function12 = this.C;
                if (function12 != null) {
                    function12.invoke(bVar2);
                }
                aiVar = this.f323642d.nextDialog;
                if (aiVar != null) {
                    aiVar.dismiss();
                }
                this.f323642d.nextDialog = null;
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public MagicStudioCreationViewModel$collectCreationEvent$1(MagicStudioCreationViewModel magicStudioCreationViewModel, Function0<Unit> function0, Function1<? super MagicStudioCreationViewModel.b.ProgressUpdate, Unit> function1, boolean z16, Context context, View view, Function1<? super MagicStudioCreationViewModel.b.GotoMultiSelect, Unit> function12, Function0<Unit> function02, Continuation<? super MagicStudioCreationViewModel$collectCreationEvent$1> continuation) {
        super(2, continuation);
        this.this$0 = magicStudioCreationViewModel;
        this.$failedAction = function0;
        this.$progressAction = function1;
        this.$hideProgressDialog = z16;
        this.$context = context;
        this.$parentView = view;
        this.$gotoMultiSelect = function12;
        this.$cancelAction = function02;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new MagicStudioCreationViewModel$collectCreationEvent$1(this.this$0, this.$failedAction, this.$progressAction, this.$hideProgressDialog, this.$context, this.$parentView, this.$gotoMultiSelect, this.$cancelAction, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
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
            SharedFlow<MagicStudioCreationViewModel.b> K2 = this.this$0.K2();
            b bVar = new b(this.this$0, this.$failedAction, this.$progressAction, this.$hideProgressDialog, this.$context, this.$parentView, this.$gotoMultiSelect, this.$cancelAction);
            this.label = 1;
            if (K2.collect(bVar, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((MagicStudioCreationViewModel$collectCreationEvent$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
