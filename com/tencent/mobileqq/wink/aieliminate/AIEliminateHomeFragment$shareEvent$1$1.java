package com.tencent.mobileqq.wink.aieliminate;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.aieliminate.AIEliminateHomeFragment$shareEvent$1$1;
import com.tencent.mobileqq.wink.editor.aielimination.WinkAiEliminationViewModel;
import com.tencent.mobileqq.wink.share.WinkShareManager;
import java.util.Map;
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
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.aieliminate.AIEliminateHomeFragment$shareEvent$1$1", f = "AIEliminateHomeFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
public final class AIEliminateHomeFragment$shareEvent$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FragmentActivity $it;
    int label;
    final /* synthetic */ AIEliminateHomeFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n\u00a2\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "shareType", "", "isSuccess", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.mobileqq.wink.aieliminate.AIEliminateHomeFragment$shareEvent$1$1$1, reason: invalid class name */
    /* loaded from: classes21.dex */
    public static final class AnonymousClass1 extends Lambda implements Function2<String, Boolean, Unit> {
        final /* synthetic */ AIEliminateHomeFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(AIEliminateHomeFragment aIEliminateHomeFragment) {
            super(2);
            this.this$0 = aIEliminateHomeFragment;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(String shareType, boolean z16, AIEliminateHomeFragment this$0) {
            int i3;
            int i16;
            Intrinsics.checkNotNullParameter(shareType, "$shareType");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            switch (shareType.hashCode()) {
                case -1052216532:
                    if (shareType.equals("save_to_phone")) {
                        Context context = this$0.getContext();
                        if (z16) {
                            i3 = 5;
                        } else {
                            i3 = 1;
                        }
                        if (z16) {
                            i16 = R.string.f240737pz;
                        } else {
                            i16 = R.string.f240727py;
                        }
                        QQToast.makeText(context, i3, i16, 0).show();
                        return;
                    }
                    return;
                case -791575966:
                    if (!shareType.equals("weixin")) {
                        return;
                    }
                    break;
                case -393543490:
                    if (!shareType.equals("qqfriend")) {
                        return;
                    }
                    break;
                case -304161157:
                    if (!shareType.equals("qzoneshuoshuo")) {
                        return;
                    }
                    break;
                case 154627506:
                    if (!shareType.equals("weixincircle")) {
                        return;
                    }
                    break;
                case 2024098531:
                    if (!shareType.equals("qqchannel")) {
                        return;
                    }
                    break;
                default:
                    return;
            }
            w53.b.f("AIEliminateHomeFragment", "shareCallback shareType: " + shareType + ", isSuccess: " + z16);
            if (z16) {
                this$0.yh();
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(String str, Boolean bool) {
            invoke(str, bool.booleanValue());
            return Unit.INSTANCE;
        }

        public final void invoke(@NotNull final String shareType, final boolean z16) {
            Intrinsics.checkNotNullParameter(shareType, "shareType");
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final AIEliminateHomeFragment aIEliminateHomeFragment = this.this$0;
            uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.wink.aieliminate.d
                @Override // java.lang.Runnable
                public final void run() {
                    AIEliminateHomeFragment$shareEvent$1$1.AnonymousClass1.b(shareType, z16, aIEliminateHomeFragment);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AIEliminateHomeFragment$shareEvent$1$1(FragmentActivity fragmentActivity, AIEliminateHomeFragment aIEliminateHomeFragment, Continuation<? super AIEliminateHomeFragment$shareEvent$1$1> continuation) {
        super(2, continuation);
        this.$it = fragmentActivity;
        this.this$0 = aIEliminateHomeFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new AIEliminateHomeFragment$shareEvent$1$1(this.$it, this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            final AIEliminateHomeFragment aIEliminateHomeFragment = this.this$0;
            com.tencent.mobileqq.wink.api.c cVar = new com.tencent.mobileqq.wink.api.c() { // from class: com.tencent.mobileqq.wink.aieliminate.AIEliminateHomeFragment$shareEvent$1$1$eliminateData$1
                @Override // com.tencent.mobileqq.wink.api.c
                @NotNull
                public Function1<Boolean, Unit> a() {
                    final AIEliminateHomeFragment aIEliminateHomeFragment2 = AIEliminateHomeFragment.this;
                    return new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.wink.aieliminate.AIEliminateHomeFragment$shareEvent$1$1$eliminateData$1$getShareCallback$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                            invoke(bool.booleanValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(boolean z16) {
                            if (z16) {
                                AIEliminateHomeFragment.this.yh();
                            }
                        }
                    };
                }

                @Override // com.tencent.mobileqq.wink.api.c
                public boolean b() {
                    return true;
                }

                @Override // com.tencent.mobileqq.wink.api.c
                @NotNull
                public Function1<Boolean, Unit> c() {
                    final AIEliminateHomeFragment aIEliminateHomeFragment2 = AIEliminateHomeFragment.this;
                    return new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.wink.aieliminate.AIEliminateHomeFragment$shareEvent$1$1$eliminateData$1$getSaveCallback$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                            invoke(bool.booleanValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(boolean z16) {
                            QQToast.makeText(AIEliminateHomeFragment.this.getContext(), z16 ? 5 : 1, z16 ? R.string.f240737pz : R.string.f240727py, 0).show();
                        }
                    };
                }

                @Override // com.tencent.mobileqq.wink.api.c
                @NotNull
                public Bundle d() {
                    WinkAiEliminationViewModel eliminationViewModel = AIEliminateHomeFragment.this.Ch();
                    Intrinsics.checkNotNullExpressionValue(eliminationViewModel, "eliminationViewModel");
                    return WinkAiEliminationViewModel.u2(eliminationViewModel, null, false, 2, null);
                }

                @Override // com.tencent.mobileqq.wink.api.c
                @NotNull
                public Map<String, Object> e() {
                    return AIEliminateHomeFragment.this.Dh();
                }

                @Override // com.tencent.mobileqq.wink.api.c
                @NotNull
                public Map<String, Object> f() {
                    return AIEliminateHomeFragment.this.Ch().c2();
                }
            };
            WinkShareManager winkShareManager = WinkShareManager.f326323a;
            FragmentActivity it = this.$it;
            Intrinsics.checkNotNullExpressionValue(it, "it");
            winkShareManager.l(it, cVar, this.this$0.Ch().C2(2), 2, new AnonymousClass1(this.this$0));
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((AIEliminateHomeFragment$shareEvent$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
