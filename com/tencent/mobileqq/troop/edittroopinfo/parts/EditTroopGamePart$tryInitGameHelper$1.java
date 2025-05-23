package com.tencent.mobileqq.troop.edittroopinfo.parts;

import android.app.Activity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.oskplayer.util.SecretUtils;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "title", "", SecretUtils.DES, "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes19.dex */
public final class EditTroopGamePart$tryInitGameHelper$1 extends Lambda implements Function2<String, String, Unit> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ EditTroopGamePart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditTroopGamePart$tryInitGameHelper$1(EditTroopGamePart editTroopGamePart) {
        super(2);
        this.this$0 = editTroopGamePart;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) editTroopGamePart);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(EditTroopGamePart this$0, String title, String des) {
        com.tencent.mobileqq.widget.listitem.x V9;
        com.tencent.mobileqq.widget.listitem.x V92;
        com.tencent.mobileqq.widget.listitem.x V93;
        com.tencent.mobileqq.widget.listitem.x V94;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(title, "$title");
        Intrinsics.checkNotNullParameter(des, "$des");
        Activity activity = this$0.getActivity();
        boolean z16 = false;
        if (activity != null && !activity.isFinishing()) {
            z16 = true;
        }
        if (z16) {
            V9 = this$0.V9();
            if (!Intrinsics.areEqual(((x.b.d) V9.K()).getText(), title)) {
                this$0.needDoDtImpReport = true;
            }
            V92 = this$0.V9();
            ((x.b.d) V92.K()).b(title);
            V93 = this$0.V9();
            ((x.c.g) V93.O()).h(des);
            V94 = this$0.V9();
            this$0.D9(V94);
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(String str, String str2) {
        invoke2(str, str2);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull final String title, @NotNull final String des) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) title, (Object) des);
            return;
        }
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(des, "des");
        if (QLog.isColorLevel()) {
            QLog.i("EditTroopInfoFragment-GamePart", 2, "[tryInitGameHelper] title:" + title + ", des:" + des);
        }
        final EditTroopGamePart editTroopGamePart = this.this$0;
        com.tencent.qqnt.e.i(new Runnable() { // from class: com.tencent.mobileqq.troop.edittroopinfo.parts.l
            @Override // java.lang.Runnable
            public final void run() {
                EditTroopGamePart$tryInitGameHelper$1.b(EditTroopGamePart.this, title, des);
            }
        });
    }
}
