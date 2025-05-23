package com.tencent.mobileqq.sharepanel.multiSelect;

import android.content.DialogInterface;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n\u00a2\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", WidgetCacheConstellationData.NUM, "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes18.dex */
public final class MultiSelectContactPart$initObserver$1 extends Lambda implements Function1<Integer, Unit> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ MultiSelectContactPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiSelectContactPart$initObserver$1(MultiSelectContactPart multiSelectContactPart) {
        super(1);
        this.this$0 = multiSelectContactPart;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) multiSelectContactPart);
        }
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
        invoke(num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3);
            return;
        }
        QQCustomDialog dialog = DialogUtil.createCustomDialog(this.this$0.getContext(), 0, "", this.this$0.getContext().getResources().getString(R.string.f199254ox, Integer.valueOf(i3)), 0, R.string.f1380608j, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.sharepanel.multiSelect.c
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i16) {
                MultiSelectContactPart$initObserver$1.b(dialogInterface, i16);
            }
        }, (DialogInterface.OnClickListener) null);
        dialog.show();
        MultiSelectContactPart multiSelectContactPart = this.this$0;
        Intrinsics.checkNotNullExpressionValue(dialog, "dialog");
        multiSelectContactPart.weakSelectCountLimitDialog = new com.tencent.qqnt.avatar.meta.refresh.c(dialog);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(DialogInterface dialogInterface, int i3) {
    }
}
