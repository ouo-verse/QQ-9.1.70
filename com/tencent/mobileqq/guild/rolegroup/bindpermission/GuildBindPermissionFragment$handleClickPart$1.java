package com.tencent.mobileqq.guild.rolegroup.bindpermission;

import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.guild.rolegroup.bindpermission.actions.PermissionSwitchStatus;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.rolegroup.bindpermission.GuildBindPermissionFragment$handleClickPart$1", f = "GuildBindPermissionFragment.kt", i = {}, l = {272, 275}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes14.dex */
public final class GuildBindPermissionFragment$handleClickPart$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ GuildBindPermissionFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildBindPermissionFragment$handleClickPart$1(GuildBindPermissionFragment guildBindPermissionFragment, Continuation<? super GuildBindPermissionFragment$handleClickPart$1> continuation) {
        super(2, continuation);
        this.this$0 = guildBindPermissionFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GuildBindPermissionFragment$handleClickPart$1(this.this$0, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0069  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        k kVar;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    ResultKt.throwOnFailure(obj);
                    if (!((Boolean) obj).booleanValue()) {
                        kVar = this.this$0.mFetchActionViewModel;
                        if (kVar == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mFetchActionViewModel");
                            kVar = null;
                        }
                        kVar.Z1(PermissionSwitchStatus.TYPE_PART);
                        return Unit.INSTANCE;
                    }
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            GuildBindPermissionFragment guildBindPermissionFragment = this.this$0;
            this.label = 1;
            obj = guildBindPermissionFragment.ji(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        if (!((Boolean) obj).booleanValue()) {
            return Unit.INSTANCE;
        }
        FragmentActivity requireActivity = this.this$0.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        String guildId = this.this$0.Uh().getGuildId();
        String channelId = this.this$0.Uh().getChannelId();
        this.label = 2;
        obj = ay1.a.b(requireActivity, guildId, channelId, this);
        if (obj == coroutine_suspended) {
            return coroutine_suspended;
        }
        if (!((Boolean) obj).booleanValue()) {
        }
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GuildBindPermissionFragment$handleClickPart$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
