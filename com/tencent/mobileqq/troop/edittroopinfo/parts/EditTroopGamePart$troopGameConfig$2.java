package com.tencent.mobileqq.troop.edittroopinfo.parts;

import android.app.Activity;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.edittroopinfo.TroopEditInfoViewModel;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000H\n\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/tencent/mobileqq/widget/listitem/x;", "Lcom/tencent/mobileqq/widget/listitem/x$b$d;", "Lcom/tencent/mobileqq/widget/listitem/x$c$g;", "invoke", "()Lcom/tencent/mobileqq/widget/listitem/x;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class EditTroopGamePart$troopGameConfig$2 extends Lambda implements Function0<com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g>> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ EditTroopGamePart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditTroopGamePart$troopGameConfig$2(EditTroopGamePart editTroopGamePart) {
        super(0);
        this.this$0 = editTroopGamePart;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) editTroopGamePart);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0033, code lost:
    
        if (r10.isGameTroop() == true) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void d(final EditTroopGamePart this$0, com.tencent.mobileqq.widget.listitem.x this_apply, View it) {
        TroopEditInfoViewModel C9;
        boolean z16;
        boolean z17;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(it, "it");
        com.tencent.mobileqq.troop.edittroopinfo.parts.base.c.z9(this$0, this_apply.i(), "em_group_bind_game", null, null, null, 28, null);
        C9 = this$0.C9();
        TroopInfo g26 = C9.g2();
        if (g26 != null) {
            z16 = true;
        }
        z16 = false;
        if (z16) {
            z17 = this$0.needDoDtImpReport;
            if (z17) {
                if (QLog.isDebugVersion()) {
                    QLog.d("EditTroopInfoFragment-GamePart", 4, "[setOnBindViewListener] report imp");
                }
                this$0.needDoDtImpReport = false;
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.troop.edittroopinfo.parts.k
                    @Override // java.lang.Runnable
                    public final void run() {
                        EditTroopGamePart$troopGameConfig$2.e(EditTroopGamePart.this);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(EditTroopGamePart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Activity activity = this$0.getActivity();
        boolean z16 = false;
        if (activity != null && !activity.isFinishing()) {
            z16 = true;
        }
        if (z16) {
            this$0.X9("dt_imp");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(EditTroopGamePart this$0, View view) {
        View.OnClickListener onClickListener;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        onClickListener = this$0.gameClickListener;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
        EditTroopGamePart.Y9(this$0, null, 1, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> invoke() {
        TroopEditInfoViewModel C9;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.widget.listitem.x) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        String qqStr = HardCodeUtil.qqStr(R.string.i7k);
        Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.troop_manage_bind_to_game)");
        final com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> xVar = new com.tencent.mobileqq.widget.listitem.x<>(new x.b.d(qqStr), new x.c.g("", false, false, 6, null));
        final EditTroopGamePart editTroopGamePart = this.this$0;
        xVar.w(new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.mobileqq.troop.edittroopinfo.parts.i
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                EditTroopGamePart$troopGameConfig$2.d(EditTroopGamePart.this, xVar, view);
            }
        });
        C9 = editTroopGamePart.C9();
        TroopInfo g26 = C9.g2();
        boolean z16 = false;
        if (g26 != null && g26.isGameTroop()) {
            z16 = true;
        }
        xVar.p(z16);
        xVar.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.edittroopinfo.parts.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EditTroopGamePart$troopGameConfig$2.f(EditTroopGamePart.this, view);
            }
        });
        return xVar;
    }
}
