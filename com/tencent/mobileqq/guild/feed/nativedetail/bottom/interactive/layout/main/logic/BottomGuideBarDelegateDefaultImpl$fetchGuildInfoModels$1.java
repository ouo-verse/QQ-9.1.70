package com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.layout.main.logic;

import com.tencent.mobileqq.guild.feed.nativedetail.bottom.base.GuideBarGuildInfo;
import com.tencent.mobileqq.guild.mainframe.util.GuildMainFrameUtils;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/channels/ProducerScope;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/base/GuideBarGuildInfo;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.layout.main.logic.BottomGuideBarDelegateDefaultImpl$fetchGuildInfoModels$1", f = "BottomGuideBarDelegateDefaultImpl.kt", i = {}, l = {276}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
final class BottomGuideBarDelegateDefaultImpl$fetchGuildInfoModels$1 extends SuspendLambda implements Function2<ProducerScope<? super GuideBarGuildInfo>, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $guildId;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ BottomGuideBarDelegateDefaultImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.layout.main.logic.BottomGuideBarDelegateDefaultImpl$fetchGuildInfoModels$1$2", f = "BottomGuideBarDelegateDefaultImpl.kt", i = {}, l = {273}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.layout.main.logic.BottomGuideBarDelegateDefaultImpl$fetchGuildInfoModels$1$2, reason: invalid class name */
    /* loaded from: classes13.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.ObjectRef<Function1<GuideBarGuildInfo, Unit>> $callback;
        final /* synthetic */ String $guildId;
        int label;
        final /* synthetic */ BottomGuideBarDelegateDefaultImpl this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(BottomGuideBarDelegateDefaultImpl bottomGuideBarDelegateDefaultImpl, String str, Ref.ObjectRef<Function1<GuideBarGuildInfo, Unit>> objectRef, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.this$0 = bottomGuideBarDelegateDefaultImpl;
            this.$guildId = str;
            this.$callback = objectRef;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass2(this.this$0, this.$guildId, this.$callback, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended;
            Function1<GuideBarGuildInfo, Unit> function1;
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
                BottomGuideBarDelegateDefaultImpl bottomGuideBarDelegateDefaultImpl = this.this$0;
                String str = this.$guildId;
                this.label = 1;
                obj = bottomGuideBarDelegateDefaultImpl.v(str, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            GuideBarGuildInfo guideBarGuildInfo = (GuideBarGuildInfo) obj;
            if (guideBarGuildInfo != null && (function1 = this.$callback.element) != null) {
                function1.invoke(guideBarGuildInfo);
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BottomGuideBarDelegateDefaultImpl$fetchGuildInfoModels$1(String str, BottomGuideBarDelegateDefaultImpl bottomGuideBarDelegateDefaultImpl, Continuation<? super BottomGuideBarDelegateDefaultImpl$fetchGuildInfoModels$1> continuation) {
        super(2, continuation);
        this.$guildId = str;
        this.this$0 = bottomGuideBarDelegateDefaultImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        BottomGuideBarDelegateDefaultImpl$fetchGuildInfoModels$1 bottomGuideBarDelegateDefaultImpl$fetchGuildInfoModels$1 = new BottomGuideBarDelegateDefaultImpl$fetchGuildInfoModels$1(this.$guildId, this.this$0, continuation);
        bottomGuideBarDelegateDefaultImpl$fetchGuildInfoModels$1.L$0 = obj;
        return bottomGuideBarDelegateDefaultImpl$fetchGuildInfoModels$1;
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [T, com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.layout.main.logic.BottomGuideBarDelegateDefaultImpl$fetchGuildInfoModels$1$callback$1] */
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
            final ProducerScope producerScope = (ProducerScope) this.L$0;
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = new Function1<GuideBarGuildInfo, Unit>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.layout.main.logic.BottomGuideBarDelegateDefaultImpl$fetchGuildInfoModels$1$callback$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(GuideBarGuildInfo guideBarGuildInfo) {
                    invoke2(guideBarGuildInfo);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull GuideBarGuildInfo it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    producerScope.mo2003trySendJP2dKIU(it);
                }
            };
            GuildMainFrameUtils.k(this.$guildId, new Function1<IGProGuildInfo, Unit>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.layout.main.logic.BottomGuideBarDelegateDefaultImpl$fetchGuildInfoModels$1.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(IGProGuildInfo iGProGuildInfo) {
                    invoke2(iGProGuildInfo);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable IGProGuildInfo iGProGuildInfo) {
                    if (iGProGuildInfo == null) {
                        QLog.e("BottomGuideBarDelegateDefaultImpl", 1, "fetchGuildInfoInfo|guildInfo is null");
                        return;
                    }
                    Function1<GuideBarGuildInfo, Unit> function1 = objectRef.element;
                    if (function1 != null) {
                        function1.invoke(new GuideBarGuildInfo(iGProGuildInfo.getGuildID(), iGProGuildInfo.getGuildName(), iGProGuildInfo.getAvatarUrl(100), Boolean.valueOf(iGProGuildInfo.isMember()), null, 16, null));
                    }
                }
            });
            BuildersKt__Builders_commonKt.launch$default(producerScope, null, null, new AnonymousClass2(this.this$0, this.$guildId, objectRef, null), 3, null);
            Function0<Unit> function0 = new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.layout.main.logic.BottomGuideBarDelegateDefaultImpl$fetchGuildInfoModels$1.3
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
                    objectRef.element = null;
                }
            };
            this.label = 1;
            if (ProduceKt.awaitClose(producerScope, function0, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull ProducerScope<? super GuideBarGuildInfo> producerScope, @Nullable Continuation<? super Unit> continuation) {
        return ((BottomGuideBarDelegateDefaultImpl$fetchGuildInfoModels$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
