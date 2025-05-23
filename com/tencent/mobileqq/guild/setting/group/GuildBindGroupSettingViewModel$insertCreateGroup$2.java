package com.tencent.mobileqq.guild.setting.group;

import com.tencent.luggage.wxa.gf.d0;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProBindingGroup;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.setting.group.GuildBindGroupSettingViewModel$insertCreateGroup$2", f = "GuildBindGroupSettingViewModel.kt", i = {}, l = {d0.CTRL_INDEX}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes14.dex */
public final class GuildBindGroupSettingViewModel$insertCreateGroup$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $troopUin;
    int label;
    final /* synthetic */ GuildBindGroupSettingViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildBindGroupSettingViewModel$insertCreateGroup$2(GuildBindGroupSettingViewModel guildBindGroupSettingViewModel, long j3, Continuation<? super GuildBindGroupSettingViewModel$insertCreateGroup$2> continuation) {
        super(2, continuation);
        this.this$0 = guildBindGroupSettingViewModel;
        this.$troopUin = j3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GuildBindGroupSettingViewModel$insertCreateGroup$2(this.this$0, this.$troopUin, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0050  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        ArrayList arrayListOf;
        boolean z16;
        List list;
        Object obj2;
        Object first;
        Map map;
        boolean z17;
        Object firstOrNull;
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
            GuildBindGroupSettingViewModel guildBindGroupSettingViewModel = this.this$0;
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(Boxing.boxLong(this.$troopUin));
            this.label = 1;
            obj = guildBindGroupSettingViewModel.l2(arrayListOf, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        ArrayList arrayList = (ArrayList) obj;
        if (arrayList != null) {
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) arrayList);
            IGProBindingGroup iGProBindingGroup = (IGProBindingGroup) firstOrNull;
            if (iGProBindingGroup != null && iGProBindingGroup.getGroupCode() == this.$troopUin) {
                z16 = true;
                if (z16) {
                    list = this.this$0.unboundGroupList;
                    Iterator it = list.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            obj2 = it.next();
                            if (((OneBindableGroupSettingData) obj2).getCom.tencent.mobileqq.qwallet.transaction.impl.NotifyMsgApiImpl.KEY_GROUP_TYPE java.lang.String() == GroupType.CreatedGroup) {
                                z17 = true;
                            } else {
                                z17 = false;
                            }
                            if (z17) {
                                break;
                            }
                        } else {
                            obj2 = null;
                            break;
                        }
                    }
                    OneBindableGroupSettingData oneBindableGroupSettingData = (OneBindableGroupSettingData) obj2;
                    if (oneBindableGroupSettingData != null) {
                        GuildBindGroupSettingViewModel guildBindGroupSettingViewModel2 = this.this$0;
                        first = CollectionsKt___CollectionsKt.first((List<? extends Object>) arrayList);
                        IGProBindingGroup iGProBindingGroup2 = (IGProBindingGroup) first;
                        oneBindableGroupSettingData.b().add(0, iGProBindingGroup2);
                        map = guildBindGroupSettingViewModel2.bindableGroupToType;
                        map.put(Boxing.boxLong(iGProBindingGroup2.getGroupCode()), GroupType.CreatedGroup);
                        guildBindGroupSettingViewModel2.t2();
                    }
                }
                return Unit.INSTANCE;
            }
        }
        z16 = false;
        if (z16) {
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GuildBindGroupSettingViewModel$insertCreateGroup$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
