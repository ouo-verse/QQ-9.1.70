package com.tencent.mobileqq.troop.edittroopinfo.parts;

import android.view.View;
import android.widget.CompoundButton;
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
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000H\n\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/tencent/mobileqq/widget/listitem/x;", "Lcom/tencent/mobileqq/widget/listitem/x$b$d;", "Lcom/tencent/mobileqq/widget/listitem/x$c$f;", "invoke", "()Lcom/tencent/mobileqq/widget/listitem/x;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class EditTroopNamePart$allowMemberModifyTroopNameConfig$2 extends Lambda implements Function0<com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.f>> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ EditTroopNamePart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditTroopNamePart$allowMemberModifyTroopNameConfig$2(EditTroopNamePart editTroopNamePart) {
        super(0);
        this.this$0 = editTroopNamePart;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) editTroopNamePart);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(EditTroopNamePart this$0, CompoundButton compoundButton, boolean z16) {
        TroopEditInfoViewModel C9;
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        C9 = this$0.C9();
        C9.B2(z16);
        this$0.aa(z16);
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(EditTroopNamePart this$0, com.tencent.mobileqq.widget.listitem.x this_apply, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(it, "it");
        com.tencent.mobileqq.troop.edittroopinfo.parts.base.c.z9(this$0, this_apply.i(), "em_group_members_modify_chat", null, null, null, 28, null);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.f> invoke() {
        TroopEditInfoViewModel C9;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.widget.listitem.x) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        x.b.d dVar = new x.b.d("\u5141\u8bb8\u7fa4\u6210\u5458\u4fee\u6539\u7fa4\u804a\u540d\u79f0");
        final EditTroopNamePart editTroopNamePart = this.this$0;
        final com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.f> xVar = new com.tencent.mobileqq.widget.listitem.x<>(dVar, new x.c.f(false, new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.troop.edittroopinfo.parts.x
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                EditTroopNamePart$allowMemberModifyTroopNameConfig$2.c(EditTroopNamePart.this, compoundButton, z16);
            }
        }));
        final EditTroopNamePart editTroopNamePart2 = this.this$0;
        xVar.w(new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.mobileqq.troop.edittroopinfo.parts.y
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                EditTroopNamePart$allowMemberModifyTroopNameConfig$2.d(EditTroopNamePart.this, xVar, view);
            }
        });
        x.c.f O = xVar.O();
        C9 = editTroopNamePart2.C9();
        TroopInfo g26 = C9.g2();
        O.f(g26 != null ? g26.normalMemberCanModifyTroopName() : false);
        return xVar;
    }
}
