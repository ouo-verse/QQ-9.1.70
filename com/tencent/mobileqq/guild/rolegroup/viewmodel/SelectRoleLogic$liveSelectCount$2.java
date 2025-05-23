package com.tencent.mobileqq.guild.rolegroup.viewmodel;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import yx1.RoleSelectItem;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u00020\u0001H\n\u00a2\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/lifecycle/LiveData;", "", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public final class SelectRoleLogic$liveSelectCount$2 extends Lambda implements Function0<LiveData<Integer>> {
    final /* synthetic */ SelectRoleLogic this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectRoleLogic$liveSelectCount$2(SelectRoleLogic selectRoleLogic) {
        super(0);
        this.this$0 = selectRoleLogic;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Integer c(List list) {
        Intrinsics.checkNotNullExpressionValue(list, "list");
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((RoleSelectItem) obj).getIsSelect()) {
                arrayList.add(obj);
            }
        }
        return Integer.valueOf(arrayList.size());
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final LiveData<Integer> invoke() {
        return Transformations.map(this.this$0.q(), new Function() { // from class: com.tencent.mobileqq.guild.rolegroup.viewmodel.t
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                Integer c16;
                c16 = SelectRoleLogic$liveSelectCount$2.c((List) obj);
                return c16;
            }
        });
    }
}
