package com.tencent.mobileqq.troop.selectmember.inject;

import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J)\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\b\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/troop/selectmember/inject/a;", "", "", "Lcom/tencent/mobileqq/data/troop/TroopMemberInfo;", "troopMembers", "Lcom/tencent/mobileqq/troop/selectmember/vm/a;", "vmOperator", "", "a", "(Ljava/util/List;Lcom/tencent/mobileqq/troop/selectmember/vm/a;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public interface a {
    @Nullable
    Object a(@NotNull List<? extends TroopMemberInfo> list, @NotNull com.tencent.mobileqq.troop.selectmember.vm.a aVar, @NotNull Continuation<? super Boolean> continuation);
}
