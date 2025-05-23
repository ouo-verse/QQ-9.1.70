package com.tencent.relation.common.utils;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Looper;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

/* compiled from: P */
/* loaded from: classes25.dex */
public class RelationDialogUtil {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static QQCustomDialog f364760a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28693);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f364760a = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Activity activity, int i3, String str, CharSequence charSequence, String str2, String str3, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        if (activity != null && !activity.isFinishing()) {
            QQCustomDialog qQCustomDialog = f364760a;
            if (qQCustomDialog != null && qQCustomDialog.isShowing()) {
                return;
            }
            QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(activity, i3, str, charSequence, str2, str3, onClickListener, onClickListener2);
            f364760a = createCustomDialog;
            createCustomDialog.show();
        }
    }

    public static void c(Activity activity, int i3, String str, CharSequence charSequence, String str2, String str3, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            b(activity, i3, str, charSequence, str2, str3, onClickListener, onClickListener2);
        } else {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable(activity, i3, str, charSequence, str2, str3, onClickListener, onClickListener2) { // from class: com.tencent.relation.common.utils.RelationDialogUtil.1
                static IPatchRedirector $redirector_;
                final /* synthetic */ DialogInterface.OnClickListener C;
                final /* synthetic */ DialogInterface.OnClickListener D;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ Activity f364761d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ int f364762e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ String f364763f;

                /* renamed from: h, reason: collision with root package name */
                final /* synthetic */ CharSequence f364764h;

                /* renamed from: i, reason: collision with root package name */
                final /* synthetic */ String f364765i;

                /* renamed from: m, reason: collision with root package name */
                final /* synthetic */ String f364766m;

                {
                    this.f364761d = activity;
                    this.f364762e = i3;
                    this.f364763f = str;
                    this.f364764h = charSequence;
                    this.f364765i = str2;
                    this.f364766m = str3;
                    this.C = onClickListener;
                    this.D = onClickListener2;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, activity, Integer.valueOf(i3), str, charSequence, str2, str3, onClickListener, onClickListener2);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                        RelationDialogUtil.b(this.f364761d, this.f364762e, this.f364763f, this.f364764h, this.f364765i, this.f364766m, this.C, this.D);
                    } else {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    }
                }
            });
        }
    }
}
