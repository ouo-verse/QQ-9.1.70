package com.tencent.mobileqq.guild.homev2.parts;

import com.tencent.mobileqq.guild.component.GuildQUIPageTabBar;
import com.tencent.mobileqq.guild.homev2.views.GuildHomeV2ContentLayout;
import com.tencent.mobileqq.guild.util.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import lp1.SubTabData;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@"}, d2 = {"", "Llp1/c;", "it", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.homev2.parts.GuildTabsPart$initData$3", f = "GuildTabsPart.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
public final class GuildTabsPart$initData$3 extends SuspendLambda implements Function2<List<? extends SubTabData>, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ GuildTabsPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildTabsPart$initData$3(GuildTabsPart guildTabsPart, Continuation<? super GuildTabsPart$initData$3> continuation) {
        super(2, continuation);
        this.this$0 = guildTabsPart;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        GuildTabsPart$initData$3 guildTabsPart$initData$3 = new GuildTabsPart$initData$3(this.this$0, continuation);
        guildTabsPart$initData$3.L$0 = obj;
        return guildTabsPart$initData$3;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(List<? extends SubTabData> list, Continuation<? super Unit> continuation) {
        return invoke2((List<SubTabData>) list, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        lp1.a aVar;
        int collectionSizeOrDefault;
        boolean z16;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            List<SubTabData> list = (List) this.L$0;
            Logger.f235387a.d().i("TabContentPart", 1, "tabItems: " + list);
            aVar = this.this$0.adapter;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                aVar = null;
            }
            aVar.setItems(list);
            GuildHomeV2ContentLayout guildHomeV2ContentLayout = this.this$0.contentLayout;
            if (guildHomeV2ContentLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("contentLayout");
                guildHomeV2ContentLayout = null;
            }
            GuildQUIPageTabBar viewTab = guildHomeV2ContentLayout.getViewTab();
            List<SubTabData> list2 = list;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            Iterator<T> it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(new GuildQUIPageTabBar.GuildQUIPagerTabData(((SubTabData) it.next()).getName(), null));
            }
            viewTab.setTabData(arrayList);
            z16 = this.this$0.hasAutoNavigated;
            if (!z16) {
                this.this$0.O9(list);
            } else {
                this.this$0.ba(list);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull List<SubTabData> list, @Nullable Continuation<? super Unit> continuation) {
        return ((GuildTabsPart$initData$3) create(list, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
