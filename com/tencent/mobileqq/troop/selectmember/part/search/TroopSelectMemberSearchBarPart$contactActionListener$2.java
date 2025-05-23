package com.tencent.mobileqq.troop.selectmember.part.search;

import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.search.model.k;
import com.tencent.mobileqq.widget.search.QUISearchBar;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n\u00a2\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/tencent/mobileqq/search/view/d;", "invoke", "()Lcom/tencent/mobileqq/search/view/d;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopSelectMemberSearchBarPart$contactActionListener$2 extends Lambda implements Function0<com.tencent.mobileqq.search.view.d> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ TroopSelectMemberSearchBarPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TroopSelectMemberSearchBarPart$contactActionListener$2(TroopSelectMemberSearchBarPart troopSelectMemberSearchBarPart) {
        super(0);
        this.this$0 = troopSelectMemberSearchBarPart;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) troopSelectMemberSearchBarPart);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(TroopSelectMemberSearchBarPart this$0, View view) {
        Object obj;
        k kVar;
        boolean z16;
        String R9;
        QUISearchBar qUISearchBar;
        com.tencent.mobileqq.troop.selectmember.bean.c cVar;
        Object obj2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QUISearchBar qUISearchBar2 = null;
        if (view != null) {
            obj = view.getTag(R.id.kxb);
        } else {
            obj = null;
        }
        if (obj instanceof k) {
            kVar = (k) obj;
        } else {
            kVar = null;
        }
        if (kVar == null) {
            QLog.w("TroopSelectMemberFrag.SearchBarPart", 1, "[contactActionListener] model is null");
            return;
        }
        String uin = kVar.getUin();
        String obj3 = kVar.getTitleSpans().toString();
        CharSequence description = kVar.getDescription();
        Intrinsics.checkNotNullExpressionValue(uin, "uin");
        boolean z17 = false;
        if (uin.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            List<com.tencent.mobileqq.troop.selectmember.bean.c> value = this$0.z9().P().getValue();
            if (value != null) {
                Iterator<T> it = value.iterator();
                while (true) {
                    if (it.hasNext()) {
                        obj2 = it.next();
                        if (Intrinsics.areEqual(((com.tencent.mobileqq.troop.selectmember.bean.c) obj2).e(), uin)) {
                            break;
                        }
                    } else {
                        obj2 = null;
                        break;
                    }
                }
                cVar = (com.tencent.mobileqq.troop.selectmember.bean.c) obj2;
            } else {
                cVar = null;
            }
            if (cVar != null) {
                z17 = true;
            }
        }
        QLog.i("TroopSelectMemberFrag.SearchBarPart", 1, "[contactActionListener] uin:" + uin + ", displayName:" + obj3 + ", des:" + ((Object) description) + ", isSelected:" + z17);
        R9 = this$0.R9();
        if (!Intrinsics.areEqual(description, R9) && !z17) {
            if (this$0.z9().G1().r()) {
                this$0.broadcastMessage("msg_key_click_search_item_on_single_mode", this$0.z9().k2(uin));
            } else {
                this$0.z9().z2(uin);
            }
            qUISearchBar = this$0.searchBar;
            if (qUISearchBar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("searchBar");
            } else {
                qUISearchBar2 = qUISearchBar;
            }
            qUISearchBar2.getInputWidget().setText("");
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final com.tencent.mobileqq.search.view.d invoke() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.search.view.d) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        final TroopSelectMemberSearchBarPart troopSelectMemberSearchBarPart = this.this$0;
        return new com.tencent.mobileqq.search.view.d() { // from class: com.tencent.mobileqq.troop.selectmember.part.search.e
            @Override // com.tencent.mobileqq.search.view.d
            public final void onAction(View view) {
                TroopSelectMemberSearchBarPart$contactActionListener$2.b(TroopSelectMemberSearchBarPart.this, view);
            }

            @Override // com.tencent.mobileqq.search.view.d
            public /* synthetic */ void selectedItemClick(String str, int i3, boolean z16) {
                com.tencent.mobileqq.search.view.c.a(this, str, i3, z16);
            }
        };
    }
}
