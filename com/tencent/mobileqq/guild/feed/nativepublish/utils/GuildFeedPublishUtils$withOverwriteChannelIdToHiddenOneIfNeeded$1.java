package com.tencent.mobileqq.guild.feed.nativepublish.utils;

import com.tencent.mobileqq.guild.feed.launcher.GuildFeedBaseInitBean;
import com.tencent.mobileqq.guild.feed.nativepublish.utils.PostPermissionCheckFuns;
import com.tencent.mobileqq.guild.feed.util.ae;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.nativepublish.utils.GuildFeedPublishUtils$withOverwriteChannelIdToHiddenOneIfNeeded$1", f = "GuildFeedPublishUtils.kt", i = {0}, l = {199}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
/* loaded from: classes13.dex */
public final class GuildFeedPublishUtils$withOverwriteChannelIdToHiddenOneIfNeeded$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $after;
    final /* synthetic */ GuildFeedBaseInitBean $bean;
    final /* synthetic */ String $channelId;
    final /* synthetic */ String $guildId;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.guild.feed.nativepublish.utils.GuildFeedPublishUtils$withOverwriteChannelIdToHiddenOneIfNeeded$1$2", f = "GuildFeedPublishUtils.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.guild.feed.nativepublish.utils.GuildFeedPublishUtils$withOverwriteChannelIdToHiddenOneIfNeeded$1$2, reason: invalid class name */
    /* loaded from: classes13.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function0<Unit> $after;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Function0<Unit> function0, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$after = function0;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass2(this.$after, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                this.$after.invoke();
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildFeedPublishUtils$withOverwriteChannelIdToHiddenOneIfNeeded$1(String str, String str2, GuildFeedBaseInitBean guildFeedBaseInitBean, Function0<Unit> function0, Continuation<? super GuildFeedPublishUtils$withOverwriteChannelIdToHiddenOneIfNeeded$1> continuation) {
        super(2, continuation);
        this.$guildId = str;
        this.$channelId = str2;
        this.$bean = guildFeedBaseInitBean;
        this.$after = function0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        GuildFeedPublishUtils$withOverwriteChannelIdToHiddenOneIfNeeded$1 guildFeedPublishUtils$withOverwriteChannelIdToHiddenOneIfNeeded$1 = new GuildFeedPublishUtils$withOverwriteChannelIdToHiddenOneIfNeeded$1(this.$guildId, this.$channelId, this.$bean, this.$after, continuation);
        guildFeedPublishUtils$withOverwriteChannelIdToHiddenOneIfNeeded$1.L$0 = obj;
        return guildFeedPublishUtils$withOverwriteChannelIdToHiddenOneIfNeeded$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        CoroutineScope coroutineScope;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 == 1) {
                coroutineScope = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
            PostPermissionCheckFuns postPermissionCheckFuns = PostPermissionCheckFuns.f222320a;
            String str = this.$guildId;
            String str2 = this.$channelId;
            this.L$0 = coroutineScope2;
            this.label = 1;
            Object c16 = postPermissionCheckFuns.c(str, str2, this);
            if (c16 == coroutine_suspended) {
                return coroutine_suspended;
            }
            coroutineScope = coroutineScope2;
            obj = c16;
        }
        PostPermissionCheckFuns.CheckSpeakablePermissionResult checkSpeakablePermissionResult = (PostPermissionCheckFuns.CheckSpeakablePermissionResult) obj;
        if (checkSpeakablePermissionResult != null) {
            String str3 = this.$channelId;
            GuildFeedBaseInitBean guildFeedBaseInitBean = this.$bean;
            if (!checkSpeakablePermissionResult.getCanPost() && !checkSpeakablePermissionResult.getIsTroopGuild()) {
                if (!Intrinsics.areEqual(str3, checkSpeakablePermissionResult.getHiddenChannelId())) {
                    BuildersKt__Builders_commonKt.launch$default(coroutineScope, ae.a().e(), null, new GuildFeedPublishUtils$withOverwriteChannelIdToHiddenOneIfNeeded$1$1$1(null), 2, null);
                }
                if (!checkSpeakablePermissionResult.getIsVisibleChannel()) {
                    guildFeedBaseInitBean.setChannelId(checkSpeakablePermissionResult.getHiddenChannelId());
                    guildFeedBaseInitBean.setChannelName("");
                }
                QLog.i("GuildFeedPublishUtils", 1, "[overwriteChannelIdToHiddenOne]: checkResult=" + checkSpeakablePermissionResult);
            }
        }
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, ae.a().e(), null, new AnonymousClass2(this.$after, null), 2, null);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GuildFeedPublishUtils$withOverwriteChannelIdToHiddenOneIfNeeded$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
