package com.tencent.mobileqq.guild.feed.launcher.parser;

import android.app.Activity;
import android.content.Context;
import com.tencent.mobileqq.guild.feed.api.FeedEditorCheckItemResult;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.permission.SpeakPermissionType;
import com.tencent.mobileqq.guild.feed.nativepublish.utils.GuildFeedPublishUtils;
import com.tencent.mobileqq.guild.feed.util.ae;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lkotlinx/coroutines/Job;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.launcher.parser.GuildFeedNativeEditorParser$makeCheckItemListener$1$onCheckResult$2", f = "GuildFeedNativeEditorParser.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
public final class GuildFeedNativeEditorParser$makeCheckItemListener$1$onCheckResult$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Job>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ String $guildId;
    final /* synthetic */ FeedEditorCheckItemResult $result;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.guild.feed.launcher.parser.GuildFeedNativeEditorParser$makeCheckItemListener$1$onCheckResult$2$1", f = "GuildFeedNativeEditorParser.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.guild.feed.launcher.parser.GuildFeedNativeEditorParser$makeCheckItemListener$1$onCheckResult$2$1, reason: invalid class name */
    /* loaded from: classes13.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $context;
        final /* synthetic */ String $guildId;
        final /* synthetic */ FeedEditorCheckItemResult $result;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Context context, String str, FeedEditorCheckItemResult feedEditorCheckItemResult, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$context = context;
            this.$guildId = str;
            this.$result = feedEditorCheckItemResult;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(this.$context, this.$guildId, this.$result, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                GuildFeedPublishUtils guildFeedPublishUtils = GuildFeedPublishUtils.f222315a;
                Context context = this.$context;
                Object obj2 = null;
                if (!(context instanceof Activity)) {
                    context = null;
                }
                Activity activity = (Activity) context;
                String str = this.$guildId;
                Object payload = this.$result.getPayload();
                if (payload instanceof SpeakPermissionType) {
                    obj2 = payload;
                }
                SpeakPermissionType speakPermissionType = (SpeakPermissionType) obj2;
                if (speakPermissionType == null) {
                    speakPermissionType = SpeakPermissionType.PERMISSION_TYPE_INVALID;
                }
                guildFeedPublishUtils.D(activity, str, speakPermissionType);
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
    public GuildFeedNativeEditorParser$makeCheckItemListener$1$onCheckResult$2(Context context, String str, FeedEditorCheckItemResult feedEditorCheckItemResult, Continuation<? super GuildFeedNativeEditorParser$makeCheckItemListener$1$onCheckResult$2> continuation) {
        super(2, continuation);
        this.$context = context;
        this.$guildId = str;
        this.$result = feedEditorCheckItemResult;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        GuildFeedNativeEditorParser$makeCheckItemListener$1$onCheckResult$2 guildFeedNativeEditorParser$makeCheckItemListener$1$onCheckResult$2 = new GuildFeedNativeEditorParser$makeCheckItemListener$1$onCheckResult$2(this.$context, this.$guildId, this.$result, continuation);
        guildFeedNativeEditorParser$makeCheckItemListener$1$onCheckResult$2.L$0 = obj;
        return guildFeedNativeEditorParser$makeCheckItemListener$1$onCheckResult$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Job launch$default;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            launch$default = BuildersKt__Builders_commonKt.launch$default((CoroutineScope) this.L$0, ae.a().e().getImmediate(), null, new AnonymousClass1(this.$context, this.$guildId, this.$result, null), 2, null);
            return launch$default;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Job> continuation) {
        return ((GuildFeedNativeEditorParser$makeCheckItemListener$1$onCheckResult$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
