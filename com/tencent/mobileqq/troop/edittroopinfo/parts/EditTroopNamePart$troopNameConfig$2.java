package com.tencent.mobileqq.troop.edittroopinfo.parts;

import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.edittroopinfo.TroopEditInfoViewModel;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000H\n\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/tencent/mobileqq/widget/listitem/x;", "Lcom/tencent/mobileqq/widget/listitem/x$b$d;", "Lcom/tencent/mobileqq/widget/listitem/x$c$g;", "invoke", "()Lcom/tencent/mobileqq/widget/listitem/x;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class EditTroopNamePart$troopNameConfig$2 extends Lambda implements Function0<com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g>> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ EditTroopNamePart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditTroopNamePart$troopNameConfig$2(EditTroopNamePart editTroopNamePart) {
        super(0);
        this.this$0 = editTroopNamePart;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) editTroopNamePart);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(EditTroopNamePart this$0, com.tencent.mobileqq.widget.listitem.x this_apply, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(it, "it");
        com.tencent.mobileqq.troop.edittroopinfo.parts.base.c.z9(this$0, this_apply.i(), "em_group_chat_name", null, null, null, 28, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(EditTroopNamePart this$0, com.tencent.mobileqq.widget.listitem.x this_apply, View view) {
        TroopEditInfoViewModel C9;
        boolean z16;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        this$0.X9();
        View i3 = this_apply.i();
        C9 = this$0.C9();
        TroopInfo g26 = C9.g2();
        if (g26 != null && g26.hasSetNewTroopName) {
            z16 = true;
        } else {
            z16 = false;
        }
        com.tencent.mobileqq.troop.edittroopinfo.parts.base.c.G9(this$0, i3, z16, null, null, 12, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> invoke() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.widget.listitem.x) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        String qqStr = HardCodeUtil.qqStr(R.string.atv);
        Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.discussion_name)");
        final com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> xVar = new com.tencent.mobileqq.widget.listitem.x<>(new x.b.d(qqStr), new x.c.g("", false, false, 6, null));
        final EditTroopNamePart editTroopNamePart = this.this$0;
        xVar.w(new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.mobileqq.troop.edittroopinfo.parts.z
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                EditTroopNamePart$troopNameConfig$2.c(EditTroopNamePart.this, xVar, view);
            }
        });
        xVar.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.edittroopinfo.parts.aa
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EditTroopNamePart$troopNameConfig$2.d(EditTroopNamePart.this, xVar, view);
            }
        });
        return xVar;
    }
}
