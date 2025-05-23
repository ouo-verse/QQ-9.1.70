package com.tencent.qqnt.aio.fav;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes23.dex */
final class NtMultiFavUtils$showUnSupportMsgDialog$1 extends Lambda implements Function0<Unit> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ Context $context;
    final /* synthetic */ Function0<Unit> $listener;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NtMultiFavUtils$showUnSupportMsgDialog$1(Context context, Function0<Unit> function0) {
        super(0);
        this.$context = context;
        this.$listener = function0;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) function0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(Function0 listener, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(listener, "$listener");
        listener.invoke();
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        Activity activity;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        Context context = this.$context;
        if (context instanceof Activity) {
            activity = (Activity) context;
        } else {
            activity = QBaseActivity.sTopActivity;
        }
        Activity activity2 = activity;
        if (activity2 != null && !activity2.isFinishing()) {
            String string = this.$context.getString(R.string.bt5);
            String string2 = this.$context.getString(R.string.cdn);
            final Function0<Unit> function0 = this.$listener;
            try {
                DialogUtil.createCustomDialog(activity2, 230, (String) null, string, "", string2, new DialogInterface.OnClickListener() { // from class: com.tencent.qqnt.aio.fav.h
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i3) {
                        NtMultiFavUtils$showUnSupportMsgDialog$1.b(Function0.this, dialogInterface, i3);
                    }
                }, (DialogInterface.OnClickListener) null).show();
                return;
            } catch (Exception e16) {
                QLog.e("NTMsgFav", 1, "showUnSupportMsgDialog exception", e16);
                return;
            }
        }
        this.$listener.invoke();
    }
}
