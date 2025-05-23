package com.tencent.now.app.misc.ui;

import android.content.Context;
import android.os.Build;
import android.os.IBinder;
import android.os.Looper;
import android.text.TextUtils;
import android.view.inputmethod.InputMethodManager;
import com.tencent.component.core.log.LogUtil;
import com.tencent.component.core.thread.ThreadCenter;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import ul3.b;

/* compiled from: P */
/* loaded from: classes22.dex */
public class UIUtil {
    public static int b(Context context, float f16) {
        return (int) ((f16 * context.getResources().getDisplayMetrics().density) + 0.5d);
    }

    public static void c(Context context, IBinder iBinder) {
        ((InputMethodManager) context.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).hideSoftInputFromWindow(iBinder, 0);
    }

    private static boolean d() {
        if (!TextUtils.equals(Build.MANUFACTURER, "OPPO") || Build.VERSION.SDK_INT != 25) {
            return false;
        }
        LogUtil.i("UIUtil", "is oppo 7.1.1, use post ui task to show toast", new Object[0]);
        return true;
    }

    public static void e(int i3, boolean z16) {
        h(b.d().getText(i3), z16, 1);
    }

    public static void f(int i3, boolean z16, int i16) {
        h(b.d().getString(i3), z16, i16);
    }

    public static void g(CharSequence charSequence, boolean z16) {
        h(charSequence, z16, 1);
    }

    public static void h(final CharSequence charSequence, final boolean z16, final int i3) {
        LogUtil.i("UIUtil", "showToast, text=" + ((Object) charSequence) + ",longToast=" + z16 + ",toastType=" + i3, new Object[0]);
        if (TextUtils.isEmpty(charSequence)) {
            return;
        }
        if (Looper.getMainLooper().getThread().getId() == Thread.currentThread().getId() && !d()) {
            i(charSequence, z16, i3);
        } else {
            ThreadCenter.postDefaultUITask(new Runnable() { // from class: com.tencent.now.app.misc.ui.UIUtil.1
                @Override // java.lang.Runnable
                public void run() {
                    UIUtil.i(charSequence, z16, i3);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void i(CharSequence charSequence, boolean z16, int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        com.tencent.qui.b.a(b.d(), 0, charSequence, z16 ? 1 : 0).show();
                        return;
                    } else {
                        com.tencent.qui.b.a(b.d(), 0, charSequence, z16 ? 1 : 0).show();
                        return;
                    }
                }
                com.tencent.qui.b.a(b.d(), 2, charSequence, z16 ? 1 : 0).show();
                return;
            }
            com.tencent.qui.b.a(b.d(), 0, charSequence, z16 ? 1 : 0).show();
            return;
        }
        com.tencent.qui.b.a(b.d(), 1, charSequence, z16 ? 1 : 0).show();
    }
}
