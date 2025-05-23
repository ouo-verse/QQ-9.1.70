package com.tencent.mobileqq.troop.selectmember.part.search;

import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/view/View$OnFocusChangeListener;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes19.dex */
public final class TroopSelectMemberSearchBarPart$searchBarFocusChangeListener$2 extends Lambda implements Function0<View.OnFocusChangeListener> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ TroopSelectMemberSearchBarPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TroopSelectMemberSearchBarPart$searchBarFocusChangeListener$2(TroopSelectMemberSearchBarPart troopSelectMemberSearchBarPart) {
        super(0);
        this.this$0 = troopSelectMemberSearchBarPart;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) troopSelectMemberSearchBarPart);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(TroopSelectMemberSearchBarPart this$0, View view, boolean z16) {
        com.tencent.mobileqq.search.view.f fVar;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (z16) {
            fVar = this$0.searchFragment;
            if (fVar == null) {
                this$0.Y9();
            }
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final View.OnFocusChangeListener invoke() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View.OnFocusChangeListener) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        final TroopSelectMemberSearchBarPart troopSelectMemberSearchBarPart = this.this$0;
        return new View.OnFocusChangeListener() { // from class: com.tencent.mobileqq.troop.selectmember.part.search.f
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z16) {
                TroopSelectMemberSearchBarPart$searchBarFocusChangeListener$2.b(TroopSelectMemberSearchBarPart.this, view, z16);
            }
        };
    }
}
