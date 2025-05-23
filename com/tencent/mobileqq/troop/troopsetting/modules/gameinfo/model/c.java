package com.tencent.mobileqq.troop.troopsetting.modules.gameinfo.model;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsetting/modules/gameinfo/model/c;", "", "Landroid/content/Context;", "context", "Landroid/app/Dialog;", "b", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f301169a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60216);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f301169a = new c();
        }
    }

    c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @JvmStatic
    @Nullable
    public static final Dialog b(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        com.tencent.mobileqq.troop.config.a aVar = com.tencent.mobileqq.troop.config.a.f294689a;
        if (aVar.d("Change_Game_Card_Switch_Tips_Value", false, true)) {
            return null;
        }
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(context, 230, context.getString(R.string.f180273am), context.getString(R.string.f180263al), R.string.cancel, R.string.f180253ak, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopsetting.modules.gameinfo.model.b
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                c.c(dialogInterface, i3);
            }
        }, (DialogInterface.OnClickListener) null);
        createCustomDialog.show();
        aVar.q("Change_Game_Card_Switch_Tips_Value", true, true);
        return createCustomDialog;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
    }
}
