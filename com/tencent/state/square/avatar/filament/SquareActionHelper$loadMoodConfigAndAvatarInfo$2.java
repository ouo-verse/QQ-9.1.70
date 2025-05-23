package com.tencent.state.square.avatar.filament;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.state.square.avatar.filament.SquareActionHelper$loadMoodConfigAndAvatarInfo$2", f = "SquareActionHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes38.dex */
public final class SquareActionHelper$loadMoodConfigAndAvatarInfo$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Job>, Object> {
    final /* synthetic */ Ref.ObjectRef $guestAvatarInfo;
    final /* synthetic */ Long $guestUin;
    final /* synthetic */ Ref.ObjectRef $hostAvatarInfo;
    final /* synthetic */ long $hostUin;
    final /* synthetic */ Ref.ObjectRef $moodConfig;
    final /* synthetic */ LoadFilamentAssetsStatistics $statistics;
    final /* synthetic */ String $url;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
    @DebugMetadata(c = "com.tencent.state.square.avatar.filament.SquareActionHelper$loadMoodConfigAndAvatarInfo$2$1", f = "SquareActionHelper.kt", i = {0}, l = {77}, m = "invokeSuspend", n = {"startTs"}, s = {"J$0"})
    /* renamed from: com.tencent.state.square.avatar.filament.SquareActionHelper$loadMoodConfigAndAvatarInfo$2$1, reason: invalid class name */
    /* loaded from: classes38.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        long J$0;
        Object L$0;
        int label;

        AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> completion) {
            Intrinsics.checkNotNullParameter(completion, "completion");
            return new AnonymousClass1(completion);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r9v5, types: [T, com.tencent.state.square.avatar.filament.MoodConfig] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended;
            Ref.ObjectRef objectRef;
            long j3;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.throwOnFailure(obj);
                long currentTimeMillis = System.currentTimeMillis();
                SquareActionHelper$loadMoodConfigAndAvatarInfo$2 squareActionHelper$loadMoodConfigAndAvatarInfo$2 = SquareActionHelper$loadMoodConfigAndAvatarInfo$2.this;
                Ref.ObjectRef objectRef2 = squareActionHelper$loadMoodConfigAndAvatarInfo$2.$moodConfig;
                AvatarResourceHelper avatarResourceHelper = AvatarResourceHelper.INSTANCE;
                String str = squareActionHelper$loadMoodConfigAndAvatarInfo$2.$url;
                this.L$0 = objectRef2;
                this.J$0 = currentTimeMillis;
                this.label = 1;
                obj = avatarResourceHelper.loadMoodConfig(str, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                objectRef = objectRef2;
                j3 = currentTimeMillis;
            } else if (i3 == 1) {
                j3 = this.J$0;
                objectRef = (Ref.ObjectRef) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            objectRef.element = (MoodConfig) obj;
            SquareActionHelper$loadMoodConfigAndAvatarInfo$2.this.$statistics.setLoadMoodConfigCost(System.currentTimeMillis() - j3);
            SquareActionHelper$loadMoodConfigAndAvatarInfo$2 squareActionHelper$loadMoodConfigAndAvatarInfo$22 = SquareActionHelper$loadMoodConfigAndAvatarInfo$2.this;
            LoadFilamentAssetsStatistics loadFilamentAssetsStatistics = squareActionHelper$loadMoodConfigAndAvatarInfo$22.$statistics;
            MoodConfig moodConfig = (MoodConfig) squareActionHelper$loadMoodConfigAndAvatarInfo$22.$moodConfig.element;
            loadFilamentAssetsStatistics.setLoadMoodConfigFromNet((moodConfig == null || moodConfig.getFromCache()) ? false : true);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
    @DebugMetadata(c = "com.tencent.state.square.avatar.filament.SquareActionHelper$loadMoodConfigAndAvatarInfo$2$2", f = "SquareActionHelper.kt", i = {0}, l = {83}, m = "invokeSuspend", n = {"startTs"}, s = {"J$0"})
    /* renamed from: com.tencent.state.square.avatar.filament.SquareActionHelper$loadMoodConfigAndAvatarInfo$2$2, reason: invalid class name */
    /* loaded from: classes38.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        long J$0;
        Object L$0;
        int label;

        AnonymousClass2(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> completion) {
            Intrinsics.checkNotNullParameter(completion, "completion");
            return new AnonymousClass2(completion);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Type inference failed for: r9v4, types: [org.json.JSONObject, T] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended;
            Ref.ObjectRef objectRef;
            long j3;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.throwOnFailure(obj);
                long currentTimeMillis = System.currentTimeMillis();
                SquareActionHelper$loadMoodConfigAndAvatarInfo$2 squareActionHelper$loadMoodConfigAndAvatarInfo$2 = SquareActionHelper$loadMoodConfigAndAvatarInfo$2.this;
                Ref.ObjectRef objectRef2 = squareActionHelper$loadMoodConfigAndAvatarInfo$2.$hostAvatarInfo;
                AvatarResourceHelper avatarResourceHelper = AvatarResourceHelper.INSTANCE;
                long j16 = squareActionHelper$loadMoodConfigAndAvatarInfo$2.$hostUin;
                this.L$0 = objectRef2;
                this.J$0 = currentTimeMillis;
                this.label = 1;
                obj = avatarResourceHelper.loadAvatarInfo(j16, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                objectRef = objectRef2;
                j3 = currentTimeMillis;
            } else if (i3 == 1) {
                j3 = this.J$0;
                objectRef = (Ref.ObjectRef) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            objectRef.element = (JSONObject) obj;
            SquareActionHelper$loadMoodConfigAndAvatarInfo$2.this.$statistics.setLoadHostAvatarInfoCost(System.currentTimeMillis() - j3);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
    @DebugMetadata(c = "com.tencent.state.square.avatar.filament.SquareActionHelper$loadMoodConfigAndAvatarInfo$2$3", f = "SquareActionHelper.kt", i = {0}, l = {89}, m = "invokeSuspend", n = {"startTs"}, s = {"J$0"})
    /* renamed from: com.tencent.state.square.avatar.filament.SquareActionHelper$loadMoodConfigAndAvatarInfo$2$3, reason: invalid class name */
    /* loaded from: classes38.dex */
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        long J$0;
        Object L$0;
        int label;

        AnonymousClass3(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> completion) {
            Intrinsics.checkNotNullParameter(completion, "completion");
            return new AnonymousClass3(completion);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Type inference failed for: r9v8, types: [org.json.JSONObject, T] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended;
            Ref.ObjectRef objectRef;
            long j3;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.throwOnFailure(obj);
                if (SquareActionHelper$loadMoodConfigAndAvatarInfo$2.this.$guestUin != null) {
                    long currentTimeMillis = System.currentTimeMillis();
                    SquareActionHelper$loadMoodConfigAndAvatarInfo$2 squareActionHelper$loadMoodConfigAndAvatarInfo$2 = SquareActionHelper$loadMoodConfigAndAvatarInfo$2.this;
                    Ref.ObjectRef objectRef2 = squareActionHelper$loadMoodConfigAndAvatarInfo$2.$guestAvatarInfo;
                    AvatarResourceHelper avatarResourceHelper = AvatarResourceHelper.INSTANCE;
                    long longValue = squareActionHelper$loadMoodConfigAndAvatarInfo$2.$guestUin.longValue();
                    this.L$0 = objectRef2;
                    this.J$0 = currentTimeMillis;
                    this.label = 1;
                    obj = avatarResourceHelper.loadAvatarInfo(longValue, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    objectRef = objectRef2;
                    j3 = currentTimeMillis;
                }
                return Unit.INSTANCE;
            }
            if (i3 == 1) {
                j3 = this.J$0;
                objectRef = (Ref.ObjectRef) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            objectRef.element = (JSONObject) obj;
            SquareActionHelper$loadMoodConfigAndAvatarInfo$2.this.$statistics.setLoadGuestAvatarInfoCost(System.currentTimeMillis() - j3);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SquareActionHelper$loadMoodConfigAndAvatarInfo$2(Ref.ObjectRef objectRef, String str, LoadFilamentAssetsStatistics loadFilamentAssetsStatistics, Ref.ObjectRef objectRef2, long j3, Long l3, Ref.ObjectRef objectRef3, Continuation continuation) {
        super(2, continuation);
        this.$moodConfig = objectRef;
        this.$url = str;
        this.$statistics = loadFilamentAssetsStatistics;
        this.$hostAvatarInfo = objectRef2;
        this.$hostUin = j3;
        this.$guestUin = l3;
        this.$guestAvatarInfo = objectRef3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> completion) {
        Intrinsics.checkNotNullParameter(completion, "completion");
        SquareActionHelper$loadMoodConfigAndAvatarInfo$2 squareActionHelper$loadMoodConfigAndAvatarInfo$2 = new SquareActionHelper$loadMoodConfigAndAvatarInfo$2(this.$moodConfig, this.$url, this.$statistics, this.$hostAvatarInfo, this.$hostUin, this.$guestUin, this.$guestAvatarInfo, completion);
        squareActionHelper$loadMoodConfigAndAvatarInfo$2.L$0 = obj;
        return squareActionHelper$loadMoodConfigAndAvatarInfo$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Job> continuation) {
        return ((SquareActionHelper$loadMoodConfigAndAvatarInfo$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Job launch$default;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass1(null), 3, null);
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass2(null), 3, null);
            launch$default = BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass3(null), 3, null);
            return launch$default;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
