package com.tencent.mobileqq.guild.setting.guildinfo;

import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.guild.setting.guildinfo.GuildInfoDialogViewModel;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProBindingGroup;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProMemberGetBoundGroupRsp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wh2.ce;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.setting.guildinfo.GuildInfoDialogViewModel$initRelativeGroupInfo$1", f = "GuildInfoDialogViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes14.dex */
public final class GuildInfoDialogViewModel$initRelativeGroupInfo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ GuildInfoDialogViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildInfoDialogViewModel$initRelativeGroupInfo$1(GuildInfoDialogViewModel guildInfoDialogViewModel, Continuation<? super GuildInfoDialogViewModel$initRelativeGroupInfo$1> continuation) {
        super(2, continuation);
        this.this$0 = guildInfoDialogViewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(GuildInfoDialogViewModel guildInfoDialogViewModel, int i3, String str, IGProMemberGetBoundGroupRsp iGProMemberGetBoundGroupRsp) {
        int collectionSizeOrDefault;
        boolean z16;
        List emptyList;
        if (i3 != 0) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str2 = "fetchBoundGroupsFirstPage failed: " + i3 + "-" + str;
            if (str2 instanceof String) {
                bVar.a().add(str2);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("GuildInfoDialogViewModel", 1, (String) it.next(), null);
            }
            MutableLiveData<GuildInfoDialogViewModel.RelativeGroupShowItem> d26 = guildInfoDialogViewModel.d2();
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            d26.setValue(new GuildInfoDialogViewModel.RelativeGroupShowItem(false, emptyList));
            return;
        }
        ArrayList<IGProBindingGroup> bindingGroupList = iGProMemberGetBoundGroupRsp.getBindingGroupList();
        Intrinsics.checkNotNullExpressionValue(bindingGroupList, "rsp.bindingGroupList");
        ArrayList arrayList = new ArrayList();
        for (Object obj : bindingGroupList) {
            IGProBindingGroup iGProBindingGroup = (IGProBindingGroup) obj;
            if (iGProBindingGroup.getGroupFlag() != 2 && iGProBindingGroup.getGroupFlag() != 128) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                arrayList.add(obj);
            }
        }
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        Iterator it5 = arrayList.iterator();
        while (it5.hasNext()) {
            arrayList2.add(Long.valueOf(((IGProBindingGroup) it5.next()).getGroupCode()));
        }
        guildInfoDialogViewModel.d2().setValue(new GuildInfoDialogViewModel.RelativeGroupShowItem(!arrayList2.isEmpty(), arrayList2));
        Logger.f235387a.d().i("GuildInfoDialogViewModel", 1, "fetchBoundGroupsFirstPage: " + i3);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GuildInfoDialogViewModel$initRelativeGroupInfo$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            IRuntimeService S0 = ch.S0(IGPSService.class, "");
            Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(java, process)");
            String str = this.this$0.guildId;
            final GuildInfoDialogViewModel guildInfoDialogViewModel = this.this$0;
            ((IGPSService) S0).getGuildBoundGroupsFirstPage(str, 50, new ce() { // from class: com.tencent.mobileqq.guild.setting.guildinfo.c
                @Override // wh2.ce
                public final void a(int i3, String str2, IGProMemberGetBoundGroupRsp iGProMemberGetBoundGroupRsp) {
                    GuildInfoDialogViewModel$initRelativeGroupInfo$1.b(GuildInfoDialogViewModel.this, i3, str2, iGProMemberGetBoundGroupRsp);
                }
            });
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GuildInfoDialogViewModel$initRelativeGroupInfo$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
