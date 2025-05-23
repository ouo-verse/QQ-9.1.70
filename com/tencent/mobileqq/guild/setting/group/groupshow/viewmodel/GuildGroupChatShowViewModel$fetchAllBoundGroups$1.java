package com.tencent.mobileqq.guild.setting.group.groupshow.viewmodel;

import az1.GroupChatShowData;
import com.tencent.mobileqq.guild.setting.group.groupshow.viewmodel.GuildGroupChatShowViewModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.setting.group.groupshow.viewmodel.GuildGroupChatShowViewModel$fetchAllBoundGroups$1", f = "GuildGroupChatShowViewModel.kt", i = {1}, l = {187, 195}, m = "invokeSuspend", n = {"boundGroupsResult"}, s = {"L$0"})
/* loaded from: classes14.dex */
public final class GuildGroupChatShowViewModel$fetchAllBoundGroups$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ GuildGroupChatShowViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildGroupChatShowViewModel$fetchAllBoundGroups$1(GuildGroupChatShowViewModel guildGroupChatShowViewModel, Continuation<? super GuildGroupChatShowViewModel$fetchAllBoundGroups$1> continuation) {
        super(2, continuation);
        this.this$0 = guildGroupChatShowViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GuildGroupChatShowViewModel$fetchAllBoundGroups$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        GuildGroupChatShowViewModel.BoundGroupsResult boundGroupsResult;
        GuildGroupChatShowViewModel guildGroupChatShowViewModel;
        Object Z1;
        GuildGroupChatShowViewModel guildGroupChatShowViewModel2;
        List<GroupChatShowData> a16;
        List<GroupChatShowData> plus;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    guildGroupChatShowViewModel2 = (GuildGroupChatShowViewModel) this.L$1;
                    boundGroupsResult = (GuildGroupChatShowViewModel.BoundGroupsResult) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    plus = CollectionsKt___CollectionsKt.plus((Collection) boundGroupsResult.a(), (Iterable) obj);
                    GuildGroupChatShowViewModel guildGroupChatShowViewModel3 = guildGroupChatShowViewModel2;
                    a16 = plus;
                    guildGroupChatShowViewModel = guildGroupChatShowViewModel3;
                    guildGroupChatShowViewModel.boundGroupList = a16;
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            GuildGroupChatShowViewModel guildGroupChatShowViewModel4 = this.this$0;
            this.label = 1;
            obj = guildGroupChatShowViewModel4.X1(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        boundGroupsResult = (GuildGroupChatShowViewModel.BoundGroupsResult) obj;
        if (!boundGroupsResult.getLoadSuccess()) {
            return Unit.INSTANCE;
        }
        guildGroupChatShowViewModel = this.this$0;
        if (boundGroupsResult.c().isEmpty()) {
            a16 = boundGroupsResult.a();
            guildGroupChatShowViewModel.boundGroupList = a16;
            return Unit.INSTANCE;
        }
        GuildGroupChatShowViewModel guildGroupChatShowViewModel5 = this.this$0;
        ArrayList arrayList = new ArrayList(boundGroupsResult.c());
        this.L$0 = boundGroupsResult;
        this.L$1 = guildGroupChatShowViewModel;
        this.label = 2;
        Z1 = guildGroupChatShowViewModel5.Z1(arrayList, this);
        if (Z1 == coroutine_suspended) {
            return coroutine_suspended;
        }
        guildGroupChatShowViewModel2 = guildGroupChatShowViewModel;
        obj = Z1;
        plus = CollectionsKt___CollectionsKt.plus((Collection) boundGroupsResult.a(), (Iterable) obj);
        GuildGroupChatShowViewModel guildGroupChatShowViewModel32 = guildGroupChatShowViewModel2;
        a16 = plus;
        guildGroupChatShowViewModel = guildGroupChatShowViewModel32;
        guildGroupChatShowViewModel.boundGroupList = a16;
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GuildGroupChatShowViewModel$fetchAllBoundGroups$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
