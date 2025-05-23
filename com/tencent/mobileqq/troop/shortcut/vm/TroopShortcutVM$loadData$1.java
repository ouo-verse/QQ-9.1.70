package com.tencent.mobileqq.troop.shortcut.vm;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.shortcut.data.TroopShortcutInfo;
import com.tencent.qqnt.e;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005H\n\u00a2\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "data", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/troop/shortcut/data/TroopShortcutInfo;", "Lkotlin/collections/ArrayList;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes19.dex */
public final class TroopShortcutVM$loadData$1 extends Lambda implements Function1<ArrayList<TroopShortcutInfo>, Unit> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ Function0<Unit> $callback;
    final /* synthetic */ TroopShortcutVM this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TroopShortcutVM$loadData$1(TroopShortcutVM troopShortcutVM, Function0<Unit> function0) {
        super(1);
        this.this$0 = troopShortcutVM;
        this.$callback = function0;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) troopShortcutVM, (Object) function0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(TroopShortcutVM this$0, ArrayList data, Function0 function0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(data, "$data");
        this$0.cachedShownRobotUin = null;
        this$0.Q1().setValue(data);
        if (function0 != null) {
            function0.invoke();
        }
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ArrayList<TroopShortcutInfo> arrayList) {
        invoke2(arrayList);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull final ArrayList<TroopShortcutInfo> data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) data);
            return;
        }
        Intrinsics.checkNotNullParameter(data, "data");
        final TroopShortcutVM troopShortcutVM = this.this$0;
        final Function0<Unit> function0 = this.$callback;
        e.i(new Runnable() { // from class: com.tencent.mobileqq.troop.shortcut.vm.b
            @Override // java.lang.Runnable
            public final void run() {
                TroopShortcutVM$loadData$1.b(TroopShortcutVM.this, data, function0);
            }
        });
    }
}
