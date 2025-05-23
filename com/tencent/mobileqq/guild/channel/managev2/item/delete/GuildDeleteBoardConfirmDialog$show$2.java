package com.tencent.mobileqq.guild.channel.managev2.item.delete;

import android.app.Activity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.channel.managev2.item.delete.GuildDeleteBoardConfirmDialog$show$2", f = "GuildDeleteBoardConfirmDialog.kt", i = {1}, l = {39, 44}, m = "invokeSuspend", n = {"select"}, s = {"I$0"})
/* loaded from: classes12.dex */
public final class GuildDeleteBoardConfirmDialog$show$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ String $channelId;
    final /* synthetic */ String $guildId;
    final /* synthetic */ Function1<Integer, Unit> $onConfirmDelete;
    int I$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public GuildDeleteBoardConfirmDialog$show$2(Activity activity, String str, String str2, Function1<? super Integer, Unit> function1, Continuation<? super GuildDeleteBoardConfirmDialog$show$2> continuation) {
        super(2, continuation);
        this.$activity = activity;
        this.$guildId = str;
        this.$channelId = str2;
        this.$onConfirmDelete = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GuildDeleteBoardConfirmDialog$show$2(this.$activity, this.$guildId, this.$channelId, this.$onConfirmDelete, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x005a  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Object d16;
        int i3;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i16 = this.label;
        if (i16 != 0) {
            if (i16 != 1) {
                if (i16 == 2) {
                    i3 = this.I$0;
                    ResultKt.throwOnFailure(obj);
                    if (((Boolean) obj).booleanValue()) {
                        return Unit.INSTANCE;
                    }
                    this.$onConfirmDelete.invoke(Boxing.boxInt(i3));
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            GuildDeleteBoardConfirmDialog guildDeleteBoardConfirmDialog = GuildDeleteBoardConfirmDialog.f215173a;
            Activity activity = this.$activity;
            this.label = 1;
            obj = guildDeleteBoardConfirmDialog.c(activity, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        int intValue = ((Number) obj).intValue();
        if (intValue == -1) {
            return Unit.INSTANCE;
        }
        GuildDeleteBoardConfirmDialog guildDeleteBoardConfirmDialog2 = GuildDeleteBoardConfirmDialog.f215173a;
        Activity activity2 = this.$activity;
        String str = this.$guildId;
        String str2 = this.$channelId;
        this.I$0 = intValue;
        this.label = 2;
        d16 = guildDeleteBoardConfirmDialog2.d(activity2, str, str2, this);
        if (d16 == coroutine_suspended) {
            return coroutine_suspended;
        }
        i3 = intValue;
        obj = d16;
        if (((Boolean) obj).booleanValue()) {
        }
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GuildDeleteBoardConfirmDialog$show$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
