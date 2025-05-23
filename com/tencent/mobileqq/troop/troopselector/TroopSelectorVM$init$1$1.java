package com.tencent.mobileqq.troop.troopselector;

import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.util.UiThreadUtil;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "result", "", "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public final class TroopSelectorVM$init$1$1 extends Lambda implements Function1<List<? extends TroopInfo>, Unit> {
    final /* synthetic */ TroopSelectorVM this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TroopSelectorVM$init$1$1(TroopSelectorVM troopSelectorVM) {
        super(1);
        this.this$0 = troopSelectorVM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(TroopSelectorVM this$0, List result) {
        MutableLiveData mutableLiveData;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(result, "$result");
        mutableLiveData = this$0._allTroopsList;
        mutableLiveData.postValue(result);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends TroopInfo> list) {
        invoke2(list);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(final List<? extends TroopInfo> result) {
        Intrinsics.checkNotNullParameter(result, "result");
        final TroopSelectorVM troopSelectorVM = this.this$0;
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.troop.troopselector.k
            @Override // java.lang.Runnable
            public final void run() {
                TroopSelectorVM$init$1$1.b(TroopSelectorVM.this, result);
            }
        });
    }
}
