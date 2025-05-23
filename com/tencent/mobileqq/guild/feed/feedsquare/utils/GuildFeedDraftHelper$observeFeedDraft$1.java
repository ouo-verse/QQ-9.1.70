package com.tencent.mobileqq.guild.feed.feedsquare.utils;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.guild.feed.publish.publishV2.IFeedDraftServiceV2;
import com.tencent.mobileqq.guild.feed.util.ae;
import com.tencent.mobileqq.guild.util.at;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildFeedDraft;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStRichTextContent;
import java.util.ArrayList;
import kotlin.Metadata;
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
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.StateFlow;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.feedsquare.utils.GuildFeedDraftHelper$observeFeedDraft$1", f = "GuildFeedDraftHelper.kt", i = {}, l = {34, 37}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
public final class GuildFeedDraftHelper$observeFeedDraft$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<CharSequence, Integer, Unit> $callback;
    final /* synthetic */ String $channelId;
    final /* synthetic */ String $draftKey;
    final /* synthetic */ int $draftType;
    final /* synthetic */ String $guildId;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\u008a@"}, d2 = {"Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProGuildFeedDraft;", "it", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.guild.feed.feedsquare.utils.GuildFeedDraftHelper$observeFeedDraft$1$1", f = "GuildFeedDraftHelper.kt", i = {}, l = {45}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.guild.feed.feedsquare.utils.GuildFeedDraftHelper$observeFeedDraft$1$1, reason: invalid class name */
    /* loaded from: classes13.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<GProGuildFeedDraft, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<CharSequence, Integer, Unit> $callback;
        final /* synthetic */ String $channelId;
        final /* synthetic */ String $guildId;
        /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
        @DebugMetadata(c = "com.tencent.mobileqq.guild.feed.feedsquare.utils.GuildFeedDraftHelper$observeFeedDraft$1$1$2", f = "GuildFeedDraftHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.tencent.mobileqq.guild.feed.feedsquare.utils.GuildFeedDraftHelper$observeFeedDraft$1$1$2, reason: invalid class name */
        /* loaded from: classes13.dex */
        public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Function2<CharSequence, Integer, Unit> $callback;
            final /* synthetic */ Ref.ObjectRef<CharSequence> $draftText;
            final /* synthetic */ Ref.IntRef $size;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass2(Function2<? super CharSequence, ? super Integer, Unit> function2, Ref.ObjectRef<CharSequence> objectRef, Ref.IntRef intRef, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.$callback = function2;
                this.$draftText = objectRef;
                this.$size = intRef;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                return new AnonymousClass2(this.$callback, this.$draftText, this.$size, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.$callback.invoke(this.$draftText.element, Boxing.boxInt(this.$size.element));
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            @Override // kotlin.jvm.functions.Function2
            @Nullable
            public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(String str, String str2, Function2<? super CharSequence, ? super Integer, Unit> function2, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$guildId = str;
            this.$channelId = str2;
            this.$callback = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$guildId, this.$channelId, this.$callback, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@Nullable GProGuildFeedDraft gProGuildFeedDraft, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(gProGuildFeedDraft, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Type inference failed for: r4v2, types: [android.text.SpannableStringBuilder, T] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended;
            GProStFeed gProStFeed;
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
                GProGuildFeedDraft gProGuildFeedDraft = (GProGuildFeedDraft) this.L$0;
                Ref.ObjectRef objectRef = new Ref.ObjectRef();
                objectRef.element = "";
                Ref.IntRef intRef = new Ref.IntRef();
                if (gProGuildFeedDraft != null && (gProStFeed = gProGuildFeedDraft.draftFeed) != null) {
                    String str = this.$guildId;
                    String str2 = this.$channelId;
                    GuildFeedDraftHelper guildFeedDraftHelper = GuildFeedDraftHelper.f219277a;
                    ArrayList<GProStRichTextContent> arrayList = gProStFeed.contents.contents;
                    Intrinsics.checkNotNullExpressionValue(arrayList, "contents.contents");
                    objectRef.element = guildFeedDraftHelper.a(arrayList, str, str2);
                    intRef.element = gProStFeed.images.size() + gProStFeed.videos.size();
                }
                MainCoroutineDispatcher e16 = ae.a().e();
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$callback, objectRef, intRef, null);
                this.label = 1;
                if (BuildersKt.withContext(e16, anonymousClass2, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public GuildFeedDraftHelper$observeFeedDraft$1(String str, int i3, String str2, String str3, Function2<? super CharSequence, ? super Integer, Unit> function2, Continuation<? super GuildFeedDraftHelper$observeFeedDraft$1> continuation) {
        super(2, continuation);
        this.$guildId = str;
        this.$draftType = i3;
        this.$draftKey = str2;
        this.$channelId = str3;
        this.$callback = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GuildFeedDraftHelper$observeFeedDraft$1(this.$guildId, this.$draftType, this.$draftKey, this.$channelId, this.$callback, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x006b  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        AppInterface appInterface;
        IRuntimeService iRuntimeService;
        StateFlow stateFlow;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                stateFlow = (StateFlow) obj;
                if (stateFlow != null) {
                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$guildId, this.$channelId, this.$callback, null);
                    this.label = 2;
                    if (FlowKt.collectLatest(stateFlow, anonymousClass1, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            }
        } else {
            ResultKt.throwOnFailure(obj);
            IGProGuildInfo L = ch.L(this.$guildId);
            int i16 = this.$draftType;
            if (i16 == 0) {
                if (L.isGroupGuild()) {
                    i16 = 10;
                } else {
                    i16 = 1;
                }
            }
            at atVar = at.f235448a;
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime instanceof AppInterface) {
                appInterface = (AppInterface) peekAppRuntime;
            } else {
                appInterface = null;
            }
            if (appInterface != null) {
                iRuntimeService = appInterface.getRuntimeService(IFeedDraftServiceV2.class, "");
            } else {
                iRuntimeService = null;
            }
            IFeedDraftServiceV2 iFeedDraftServiceV2 = (IFeedDraftServiceV2) iRuntimeService;
            if (iFeedDraftServiceV2 != null) {
                String str = this.$guildId;
                String str2 = this.$draftKey;
                this.label = 1;
                obj = iFeedDraftServiceV2.feedDraftFlow(str, i16, str2, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                stateFlow = (StateFlow) obj;
                if (stateFlow != null) {
                }
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GuildFeedDraftHelper$observeFeedDraft$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
