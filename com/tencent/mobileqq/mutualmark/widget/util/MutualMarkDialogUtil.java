package com.tencent.mobileqq.mutualmark.widget.util;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.WindowManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LoadingUtil;
import com.tencent.util.QQToastUtil;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes15.dex */
public class MutualMarkDialogUtil {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static WeakReference<Dialog> f252437a;

    /* renamed from: b, reason: collision with root package name */
    private static long f252438b;

    /* renamed from: c, reason: collision with root package name */
    private static long f252439c;

    public static void c(boolean z16) {
        WeakReference<Dialog> weakReference = f252437a;
        if (weakReference != null && weakReference.get() != null && f252437a.get().isShowing()) {
            try {
                Context baseContext = ((ContextWrapper) f252437a.get().getContext()).getBaseContext();
                if (baseContext instanceof Activity) {
                    if (!((Activity) baseContext).isFinishing() && !((Activity) baseContext).isDestroyed()) {
                        f252437a.get().dismiss();
                    }
                } else {
                    f252437a.get().dismiss();
                }
            } catch (WindowManager.BadTokenException e16) {
                QLog.e("PartyRoomDialogUtil", 1, "showLoadingDialogMainThread WindowManager.BadTokenException:" + e16);
            } catch (IllegalStateException e17) {
                QLog.e("PartyRoomDialogUtil", 1, "showLoadingDialogMainThread WindowManager.IllegalStateException:" + e17);
            }
            if (!z16) {
                QQToastUtil.showQQToastInUiThread(1, "\u64cd\u4f5c\u5931\u8d25");
            }
        }
    }

    public static void d(Context context, String str, boolean z16, long j3) {
        if (context == null) {
            return;
        }
        f252438b = j3;
        try {
            WeakReference<Dialog> weakReference = f252437a;
            if (weakReference == null || weakReference.get() == null) {
                f252437a = new WeakReference<>(LoadingUtil.showLoadingDialog(context, str, z16));
            }
        } catch (WindowManager.BadTokenException e16) {
            QLog.e("PartyRoomDialogUtil", 1, "showLoadingDialogMainThread WindowManager.BadTokenException:" + e16);
        } catch (IllegalStateException e17) {
            QLog.e("PartyRoomDialogUtil", 1, "showLoadingDialogMainThread WindowManager.IllegalStateException:" + e17);
        }
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return;
        }
        if (!f252437a.get().isShowing()) {
            f252437a.get().show();
        }
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable(j3) { // from class: com.tencent.mobileqq.mutualmark.widget.util.MutualMarkDialogUtil.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ long f252440d;

            {
                this.f252440d = j3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, j3);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                boolean z17;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    long j16 = MutualMarkDialogUtil.f252438b;
                    long j17 = this.f252440d;
                    if (j16 != j17) {
                        return;
                    }
                    if (j17 < MutualMarkDialogUtil.f252439c) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    MutualMarkDialogUtil.c(z17);
                    return;
                }
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }, 3000L);
    }

    public static void e() {
        f252439c = System.currentTimeMillis();
    }
}
