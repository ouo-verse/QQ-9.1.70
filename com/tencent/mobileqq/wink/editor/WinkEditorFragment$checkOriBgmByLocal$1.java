package com.tencent.mobileqq.wink.editor;

import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.wink.editor.WinkEditorFragment$checkOriBgmByLocal$1;
import com.tencent.qphone.base.util.QLog;
import com.tencent.weclip.WEYamnet;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.TimeoutKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.editor.WinkEditorFragment$checkOriBgmByLocal$1", f = "WinkEditorFragment.kt", i = {}, l = {3189}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
public final class WinkEditorFragment$checkOriBgmByLocal$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $overTime;
    final /* synthetic */ long $startTime;
    int label;
    final /* synthetic */ WinkEditorFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.wink.editor.WinkEditorFragment$checkOriBgmByLocal$1$1", f = "WinkEditorFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.wink.editor.WinkEditorFragment$checkOriBgmByLocal$1$1, reason: invalid class name */
    /* loaded from: classes21.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ long $startTime;
        int label;
        final /* synthetic */ WinkEditorFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(WinkEditorFragment winkEditorFragment, long j3, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = winkEditorFragment;
            this.$startTime = j3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(WinkEditorFragment winkEditorFragment, long j3, boolean z16, int i3) {
            QLog.i("WinkEditorFragment", 1, "checkOriBgmByLocal hasOriBgm " + z16 + " ");
            winkEditorFragment.xk().w4(z16);
            if (z16) {
                winkEditorFragment.Mj(false);
            }
            winkEditorFragment.xn(z16, System.currentTimeMillis() - j3, "", true, i3);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$startTime, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            String str;
            LocalMediaInfo localMediaInfo;
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                WEYamnet wEYamnet = new WEYamnet();
                if (wEYamnet.e()) {
                    ArrayList<LocalMediaInfo> R2 = this.this$0.Tk().R2();
                    if (R2 != null && (localMediaInfo = R2.get(0)) != null) {
                        str = localMediaInfo.path;
                    } else {
                        str = null;
                    }
                    final WinkEditorFragment winkEditorFragment = this.this$0;
                    final long j3 = this.$startTime;
                    wEYamnet.g(str, new com.tencent.weclip.weyamnet.c() { // from class: com.tencent.mobileqq.wink.editor.bu
                        @Override // com.tencent.weclip.weyamnet.c
                        public final void a(boolean z16, int i3) {
                            WinkEditorFragment$checkOriBgmByLocal$1.AnonymousClass1.b(WinkEditorFragment.this, j3, z16, i3);
                        }
                    });
                } else {
                    QLog.i("WinkEditorFragment", 1, "SDK no ready");
                    this.this$0.xk().w4(true);
                    this.this$0.Mj(false);
                    WinkEditorFragment.yn(this.this$0, true, System.currentTimeMillis() - this.$startTime, "sdkError", true, 0, 16, null);
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
    public WinkEditorFragment$checkOriBgmByLocal$1(long j3, WinkEditorFragment winkEditorFragment, long j16, Continuation<? super WinkEditorFragment$checkOriBgmByLocal$1> continuation) {
        super(2, continuation);
        this.$overTime = j3;
        this.this$0 = winkEditorFragment;
        this.$startTime = j16;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WinkEditorFragment$checkOriBgmByLocal$1(this.$overTime, this.this$0, this.$startTime, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        try {
            if (i3 != 0) {
                if (i3 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                long j3 = this.$overTime;
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, this.$startTime, null);
                this.label = 1;
                if (TimeoutKt.withTimeout(j3, anonymousClass1, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } catch (TimeoutCancellationException unused) {
            QLog.i("WinkEditorFragment", 1, "Timeout occurred");
            this.this$0.xk().w4(true);
            this.this$0.Mj(false);
            WinkEditorFragment.yn(this.this$0, true, System.currentTimeMillis() - this.$startTime, "timeout", true, 0, 16, null);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((WinkEditorFragment$checkOriBgmByLocal$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
