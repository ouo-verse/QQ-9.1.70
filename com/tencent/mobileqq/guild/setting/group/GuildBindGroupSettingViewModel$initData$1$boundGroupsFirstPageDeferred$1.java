package com.tencent.mobileqq.guild.setting.group;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/tencent/mobileqq/guild/setting/group/h;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.setting.group.GuildBindGroupSettingViewModel$initData$1$boundGroupsFirstPageDeferred$1", f = "GuildBindGroupSettingViewModel.kt", i = {2}, l = {82, 87, 92}, m = "invokeSuspend", n = {"boundGroupsResult"}, s = {"L$0"})
/* loaded from: classes14.dex */
final class GuildBindGroupSettingViewModel$initData$1$boundGroupsFirstPageDeferred$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super h>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ GuildBindGroupSettingViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildBindGroupSettingViewModel$initData$1$boundGroupsFirstPageDeferred$1(GuildBindGroupSettingViewModel guildBindGroupSettingViewModel, Continuation<? super GuildBindGroupSettingViewModel$initData$1$boundGroupsFirstPageDeferred$1> continuation) {
        super(2, continuation);
        this.this$0 = guildBindGroupSettingViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GuildBindGroupSettingViewModel$initData$1$boundGroupsFirstPageDeferred$1(this.this$0, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00a4 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0082  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        List list;
        List list2;
        ArrayList arrayList;
        h hVar;
        Object h26;
        h hVar2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        boolean z16 = false;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        hVar2 = (h) this.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    hVar = (h) obj;
                    if (hVar.getErrorCode() == 0) {
                        return hVar;
                    }
                    if (!hVar.d().isEmpty()) {
                        GuildBindGroupSettingViewModel guildBindGroupSettingViewModel = this.this$0;
                        ArrayList arrayList2 = new ArrayList(hVar.d());
                        this.L$0 = hVar;
                        this.label = 3;
                        h26 = guildBindGroupSettingViewModel.h2(arrayList2, this);
                        if (h26 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        hVar2 = hVar;
                        obj = h26;
                    } else {
                        return hVar;
                    }
                }
            } else {
                ResultKt.throwOnFailure(obj);
                arrayList = (ArrayList) obj;
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                return new h(0, "", 100, arrayList, null, 16, null);
            }
        } else {
            ResultKt.throwOnFailure(obj);
            if (this.this$0.w2()) {
                list = this.this$0.groupCodeList;
                List list3 = list;
                if (list3 == null || list3.isEmpty()) {
                    z16 = true;
                }
                if (z16) {
                    return new h(0, "", 100, null, null, 24, null);
                }
                GuildBindGroupSettingViewModel guildBindGroupSettingViewModel2 = this.this$0;
                list2 = this.this$0.groupCodeList;
                ArrayList arrayList3 = new ArrayList(list2);
                this.label = 1;
                obj = guildBindGroupSettingViewModel2.l2(arrayList3, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                arrayList = (ArrayList) obj;
                if (arrayList == null) {
                }
                return new h(0, "", 100, arrayList, null, 16, null);
            }
            GuildBindGroupSettingViewModel guildBindGroupSettingViewModel3 = this.this$0;
            this.label = 2;
            obj = guildBindGroupSettingViewModel3.i2(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
            hVar = (h) obj;
            if (hVar.getErrorCode() == 0) {
            }
        }
        ArrayList arrayList4 = (ArrayList) obj;
        if (arrayList4 == null || arrayList4.isEmpty()) {
            z16 = true;
        }
        if (!z16) {
            hVar2.c().addAll(arrayList4);
        }
        return hVar2;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super h> continuation) {
        return ((GuildBindGroupSettingViewModel$initData$1$boundGroupsFirstPageDeferred$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
