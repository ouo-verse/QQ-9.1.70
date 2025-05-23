package com.tencent.mobileqq.guild.channel.managev2.item.delete;

import android.app.Activity;
import android.view.View;
import com.tencent.mobileqq.guild.channel.managev2.utils.ChannelSettingUtils;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.channel.managev2.item.delete.GuildDeleteSubChannelConfirmDialog$show$2", f = "GuildDeleteSubChannelConfirmDialog.kt", i = {}, l = {53, 56, 59}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes12.dex */
public final class GuildDeleteSubChannelConfirmDialog$show$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ String $channelId;
    final /* synthetic */ IGProChannelInfo $channelInfo;
    final /* synthetic */ String $guildId;
    final /* synthetic */ Function0<Unit> $onConfirmDelete;
    final /* synthetic */ View $view;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildDeleteSubChannelConfirmDialog$show$2(Activity activity, View view, IGProChannelInfo iGProChannelInfo, String str, String str2, Function0<Unit> function0, Continuation<? super GuildDeleteSubChannelConfirmDialog$show$2> continuation) {
        super(2, continuation);
        this.$activity = activity;
        this.$view = view;
        this.$channelInfo = iGProChannelInfo;
        this.$guildId = str;
        this.$channelId = str2;
        this.$onConfirmDelete = function0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GuildDeleteSubChannelConfirmDialog$show$2(this.$activity, this.$view, this.$channelInfo, this.$guildId, this.$channelId, this.$onConfirmDelete, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x007b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0084  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        ResultKt.throwOnFailure(obj);
                        if (!((Boolean) obj).booleanValue()) {
                            return Unit.INSTANCE;
                        }
                        this.$onConfirmDelete.invoke();
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                if (!((Boolean) obj).booleanValue()) {
                    return Unit.INSTANCE;
                }
                GuildDeleteSubChannelConfirmDialog guildDeleteSubChannelConfirmDialog = GuildDeleteSubChannelConfirmDialog.f215180a;
                Activity activity = this.$activity;
                String str = this.$guildId;
                String str2 = this.$channelId;
                this.label = 3;
                obj = guildDeleteSubChannelConfirmDialog.g(activity, str, str2, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                if (!((Boolean) obj).booleanValue()) {
                }
            } else {
                ResultKt.throwOnFailure(obj);
            }
        } else {
            ResultKt.throwOnFailure(obj);
            GuildDeleteSubChannelConfirmDialog guildDeleteSubChannelConfirmDialog2 = GuildDeleteSubChannelConfirmDialog.f215180a;
            Activity activity2 = this.$activity;
            View view = this.$view;
            int type = this.$channelInfo.getType();
            this.label = 1;
            obj = guildDeleteSubChannelConfirmDialog2.e(activity2, view, type, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        if (!((Boolean) obj).booleanValue()) {
            return Unit.INSTANCE;
        }
        if (ChannelSettingUtils.f215196a.e(this.$channelInfo)) {
            GuildDeleteSubChannelConfirmDialog guildDeleteSubChannelConfirmDialog3 = GuildDeleteSubChannelConfirmDialog.f215180a;
            Activity activity3 = this.$activity;
            this.label = 2;
            obj = guildDeleteSubChannelConfirmDialog3.f(activity3, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
            if (!((Boolean) obj).booleanValue()) {
            }
        }
        GuildDeleteSubChannelConfirmDialog guildDeleteSubChannelConfirmDialog4 = GuildDeleteSubChannelConfirmDialog.f215180a;
        Activity activity4 = this.$activity;
        String str3 = this.$guildId;
        String str22 = this.$channelId;
        this.label = 3;
        obj = guildDeleteSubChannelConfirmDialog4.g(activity4, str3, str22, this);
        if (obj == coroutine_suspended) {
        }
        if (!((Boolean) obj).booleanValue()) {
        }
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GuildDeleteSubChannelConfirmDialog$show$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
