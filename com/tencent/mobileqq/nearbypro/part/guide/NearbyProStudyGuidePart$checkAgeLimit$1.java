package com.tencent.mobileqq.nearbypro.part.guide;

import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.api.IProfileDataService;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.nearbypro.part.guide.NearbyProStudyGuidePart$checkAgeLimit$1", f = "NearbyProStudyGuidePart.kt", i = {}, l = {59}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes15.dex */
public final class NearbyProStudyGuidePart$checkAgeLimit$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ NearbyProStudyGuidePart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.nearbypro.part.guide.NearbyProStudyGuidePart$checkAgeLimit$1$1", f = "NearbyProStudyGuidePart.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.nearbypro.part.guide.NearbyProStudyGuidePart$checkAgeLimit$1$1, reason: invalid class name */
    /* loaded from: classes15.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $age;
        int label;
        final /* synthetic */ NearbyProStudyGuidePart this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(NearbyProStudyGuidePart nearbyProStudyGuidePart, int i3, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = nearbyProStudyGuidePart;
            this.$age = i3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$age, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            boolean z16;
            boolean z17;
            boolean z18;
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                NearbyProStudyGuidePart nearbyProStudyGuidePart = this.this$0;
                if (this.$age < 18) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                nearbyProStudyGuidePart.mIsStudyLimit = z16;
                z17 = this.this$0.mIsStudyLimit;
                if (z17) {
                    this.this$0.L9();
                }
                NearbyProStudyGuidePart nearbyProStudyGuidePart2 = this.this$0;
                z18 = nearbyProStudyGuidePart2.mIsStudyLimit;
                nearbyProStudyGuidePart2.broadcastMessage("is_study_limit", Boxing.boxBoolean(z18));
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
    public NearbyProStudyGuidePart$checkAgeLimit$1(NearbyProStudyGuidePart nearbyProStudyGuidePart, Continuation<? super NearbyProStudyGuidePart$checkAgeLimit$1> continuation) {
        super(2, continuation);
        this.this$0 = nearbyProStudyGuidePart;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new NearbyProStudyGuidePart$checkAgeLimit$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        String str;
        IProfileDataService iProfileDataService;
        Card profileCard;
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
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null) {
                str = peekAppRuntime.getCurrentAccountUin();
            } else {
                str = null;
            }
            if (str == null) {
                str = "";
            }
            byte b16 = 0;
            if (peekAppRuntime != null && (iProfileDataService = (IProfileDataService) peekAppRuntime.getRuntimeService(IProfileDataService.class, "")) != null && (profileCard = iProfileDataService.getProfileCard(str, false)) != null) {
                b16 = profileCard.age;
            }
            MainCoroutineDispatcher main = Dispatchers.getMain();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, b16, null);
            this.label = 1;
            if (BuildersKt.withContext(main, anonymousClass1, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((NearbyProStudyGuidePart$checkAgeLimit$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
