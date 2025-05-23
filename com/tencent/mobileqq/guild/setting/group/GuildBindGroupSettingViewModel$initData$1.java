package com.tencent.mobileqq.guild.setting.group;

import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProBindingGroup;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.setting.group.GuildBindGroupSettingViewModel$initData$1", f = "GuildBindGroupSettingViewModel.kt", i = {0, 1}, l = {100, 101}, m = "invokeSuspend", n = {"boundGroupsFirstPageDeferred", "bindableGroupsResult"}, s = {"L$0", "L$0"})
/* loaded from: classes14.dex */
public final class GuildBindGroupSettingViewModel$initData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ GuildBindGroupSettingViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildBindGroupSettingViewModel$initData$1(GuildBindGroupSettingViewModel guildBindGroupSettingViewModel, Continuation<? super GuildBindGroupSettingViewModel$initData$1> continuation) {
        super(2, continuation);
        this.this$0 = guildBindGroupSettingViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        GuildBindGroupSettingViewModel$initData$1 guildBindGroupSettingViewModel$initData$1 = new GuildBindGroupSettingViewModel$initData$1(this.this$0, continuation);
        guildBindGroupSettingViewModel$initData$1.L$0 = obj;
        return guildBindGroupSettingViewModel$initData$1;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0099 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x009a  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        MutableLiveData mutableLiveData;
        List listOf;
        com.tencent.mobileqq.qcoroutine.api.coroutine.a c16;
        BindableGroupsResult bindableGroupsResult;
        Deferred o16;
        Object await;
        Deferred o17;
        Object await2;
        BindableGroupsResult bindableGroupsResult2;
        List<GroupType> m26;
        OneBindableGroupSettingData oneBindableGroupSettingData;
        List mutableList;
        List mutableList2;
        Map map;
        boolean z16;
        boolean z17;
        Map map2;
        boolean z18;
        boolean z19;
        List list;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        h hVar = null;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    bindableGroupsResult2 = (BindableGroupsResult) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    await2 = obj;
                    hVar = (h) await2;
                    bindableGroupsResult = bindableGroupsResult2;
                    if (bindableGroupsResult == null && bindableGroupsResult.getErrorCode() == 0 && hVar != null) {
                        this.this$0.boundGroupList.addAll(hVar.c());
                        this.this$0._bindGroupLimit = hVar.getBindGroupLimit();
                        m26 = this.this$0.m2();
                        GuildBindGroupSettingViewModel guildBindGroupSettingViewModel = this.this$0;
                        for (GroupType groupType : m26) {
                            f fVar = bindableGroupsResult.b().get(groupType);
                            if (fVar == null) {
                                oneBindableGroupSettingData = new OneBindableGroupSettingData(groupType, new ArrayList(), new ArrayList(), groupType.getIsDefaultCollapse(), false);
                            } else {
                                ArrayList arrayList = new ArrayList();
                                for (IGProBindingGroup iGProBindingGroup : fVar.a()) {
                                    map2 = guildBindGroupSettingViewModel.bindableGroupToType;
                                    map2.put(Boxing.boxLong(iGProBindingGroup.getGroupCode()), groupType);
                                    List list2 = guildBindGroupSettingViewModel.boundGroupList;
                                    if (!(list2 instanceof Collection) || !list2.isEmpty()) {
                                        Iterator it = list2.iterator();
                                        while (it.hasNext()) {
                                            if (((IGProBindingGroup) it.next()).getGroupCode() == iGProBindingGroup.getGroupCode()) {
                                                z18 = true;
                                            } else {
                                                z18 = false;
                                            }
                                            if (z18) {
                                                z19 = true;
                                                break;
                                            }
                                        }
                                    }
                                    z19 = false;
                                    if (!z19) {
                                        arrayList.add(iGProBindingGroup);
                                    }
                                }
                                ArrayList arrayList2 = new ArrayList();
                                for (IGProBindingGroup iGProBindingGroup2 : fVar.b()) {
                                    map = guildBindGroupSettingViewModel.bindableGroupToType;
                                    map.put(Boxing.boxLong(iGProBindingGroup2.getGroupCode()), groupType);
                                    List list3 = guildBindGroupSettingViewModel.boundGroupList;
                                    if (!(list3 instanceof Collection) || !list3.isEmpty()) {
                                        Iterator it5 = list3.iterator();
                                        while (it5.hasNext()) {
                                            if (((IGProBindingGroup) it5.next()).getGroupCode() == iGProBindingGroup2.getGroupCode()) {
                                                z16 = true;
                                            } else {
                                                z16 = false;
                                            }
                                            if (z16) {
                                                z17 = true;
                                                break;
                                            }
                                        }
                                    }
                                    z17 = false;
                                    if (!z17) {
                                        arrayList2.add(iGProBindingGroup2);
                                    }
                                }
                                mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList);
                                mutableList2 = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList2);
                                oneBindableGroupSettingData = new OneBindableGroupSettingData(groupType, mutableList, mutableList2, groupType.getIsDefaultCollapse(), false);
                            }
                            list = guildBindGroupSettingViewModel.unboundGroupList;
                            list.add(oneBindableGroupSettingData);
                        }
                        this.this$0.isLoading = false;
                        this.this$0.t2();
                        return Unit.INSTANCE;
                    }
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            c16 = (com.tencent.mobileqq.qcoroutine.api.coroutine.a) this.L$0;
            ResultKt.throwOnFailure(obj);
            await = obj;
        } else {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            mutableLiveData = this.this$0._pageDataLiveData;
            listOf = CollectionsKt__CollectionsJVMKt.listOf(new PlaceHolderData(7));
            mutableLiveData.setValue(listOf);
            this.this$0.isLoading = true;
            com.tencent.mobileqq.qcoroutine.api.coroutine.a c17 = CorountineFunKt.c(coroutineScope, "Guild.group.GuildBindGroupSettingViewModel bindableGroupsDeferred", null, null, new GuildBindGroupSettingViewModel$initData$1$bindableGroupsDeferred$1(this.this$0, null), 6, null);
            c16 = CorountineFunKt.c(coroutineScope, "Guild.group.GuildBindGroupSettingViewModel boundGroupsFirstPageDeferred", null, null, new GuildBindGroupSettingViewModel$initData$1$boundGroupsFirstPageDeferred$1(this.this$0, null), 6, null);
            if (c17 != null && (o16 = c17.o()) != null) {
                this.L$0 = c16;
                this.label = 1;
                await = o16.await(this);
                if (await == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                bindableGroupsResult = null;
                if (c16 != null && (o17 = c16.o()) != null) {
                    this.L$0 = bindableGroupsResult;
                    this.label = 2;
                    await2 = o17.await(this);
                    if (await2 != coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    bindableGroupsResult2 = bindableGroupsResult;
                    hVar = (h) await2;
                    bindableGroupsResult = bindableGroupsResult2;
                }
                if (bindableGroupsResult == null) {
                }
                return Unit.INSTANCE;
            }
        }
        bindableGroupsResult = (BindableGroupsResult) await;
        if (c16 != null) {
            this.L$0 = bindableGroupsResult;
            this.label = 2;
            await2 = o17.await(this);
            if (await2 != coroutine_suspended) {
            }
        }
        if (bindableGroupsResult == null) {
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GuildBindGroupSettingViewModel$initData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
