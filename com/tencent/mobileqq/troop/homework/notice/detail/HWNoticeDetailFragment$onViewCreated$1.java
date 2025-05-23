package com.tencent.mobileqq.troop.homework.notice.detail;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.homework.notice.detail.viewmodel.HWNoticeDetailViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.troop.homework.notice.detail.HWNoticeDetailFragment$onViewCreated$1", f = "HWNoticeDetailFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes19.dex */
final class HWNoticeDetailFragment$onViewCreated$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    int label;
    final /* synthetic */ HWNoticeDetailFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HWNoticeDetailFragment$onViewCreated$1(HWNoticeDetailFragment hWNoticeDetailFragment, Continuation<? super HWNoticeDetailFragment$onViewCreated$1> continuation) {
        super(2, continuation);
        this.this$0 = hWNoticeDetailFragment;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) hWNoticeDetailFragment, (Object) continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new HWNoticeDetailFragment$onViewCreated$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        HWNoticeDetailViewModel yh5;
        HWNoticeDetailViewModel yh6;
        HWNoticeDetailViewModel yh7;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                yh5 = this.this$0.yh();
                LiveData<Long> e26 = yh5.e2();
                LifecycleOwner viewLifecycleOwner = this.this$0.getViewLifecycleOwner();
                final Function1<Long, Unit> function1 = new Function1<Long, Unit>() { // from class: com.tencent.mobileqq.troop.homework.notice.detail.HWNoticeDetailFragment$onViewCreated$1.1
                    static IPatchRedirector $redirector_;

                    {
                        super(1);
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) HWNoticeDetailFragment.this);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Long l3) {
                        invoke2(l3);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Long it) {
                        HWNoticeDetailViewModel yh8;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                            return;
                        }
                        HWNoticeDetailFragment hWNoticeDetailFragment = HWNoticeDetailFragment.this;
                        Intrinsics.checkNotNullExpressionValue(it, "it");
                        hWNoticeDetailFragment.Ah(it.longValue());
                        HWNoticeDetailFragment hWNoticeDetailFragment2 = HWNoticeDetailFragment.this;
                        long longValue = it.longValue();
                        yh8 = HWNoticeDetailFragment.this.yh();
                        Boolean value = yh8.k2().getValue();
                        if (value == null) {
                            value = Boolean.TRUE;
                        }
                        hWNoticeDetailFragment2.Gh(longValue, value.booleanValue());
                    }
                };
                e26.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.troop.homework.notice.detail.d
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj2) {
                        Function1.this.invoke(obj2);
                    }
                });
                yh6 = this.this$0.yh();
                LiveData<Boolean> f26 = yh6.f2();
                LifecycleOwner viewLifecycleOwner2 = this.this$0.getViewLifecycleOwner();
                final Function1<Boolean, Unit> function12 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.troop.homework.notice.detail.HWNoticeDetailFragment$onViewCreated$1.2
                    static IPatchRedirector $redirector_;

                    {
                        super(1);
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) HWNoticeDetailFragment.this);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                        invoke2(bool);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Boolean bool) {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this, (Object) bool);
                            return;
                        }
                        FragmentActivity activity = HWNoticeDetailFragment.this.getActivity();
                        if (activity != null) {
                            activity.finish();
                        }
                    }
                };
                f26.observe(viewLifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.troop.homework.notice.detail.e
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj2) {
                        Function1.this.invoke(obj2);
                    }
                });
                yh7 = this.this$0.yh();
                LiveData<Boolean> k26 = yh7.k2();
                LifecycleOwner viewLifecycleOwner3 = this.this$0.getViewLifecycleOwner();
                final Function1<Boolean, Unit> function13 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.troop.homework.notice.detail.HWNoticeDetailFragment$onViewCreated$1.3
                    static IPatchRedirector $redirector_;

                    {
                        super(1);
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) HWNoticeDetailFragment.this);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                        invoke2(bool);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Boolean bool) {
                        HWNoticeDetailViewModel yh8;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this, (Object) bool);
                        } else if (Intrinsics.areEqual(bool, Boolean.FALSE)) {
                            yh8 = HWNoticeDetailFragment.this.yh();
                            if (yh8.e2().getValue() != null) {
                                HWNoticeDetailFragment.this.zh();
                            }
                        }
                    }
                };
                k26.observe(viewLifecycleOwner3, new Observer() { // from class: com.tencent.mobileqq.troop.homework.notice.detail.f
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj2) {
                        Function1.this.invoke(obj2);
                    }
                });
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((HWNoticeDetailFragment$onViewCreated$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
