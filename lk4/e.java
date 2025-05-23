package lk4;

import android.content.Context;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.common.api.IAegisLogApi;

/* compiled from: P */
/* loaded from: classes26.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private static IAegisLogApi f414983a = (IAegisLogApi) QRoute.api(IAegisLogApi.class);

    public static int b(Context context, float f16) {
        return (int) ((f16 * context.getResources().getDisplayMetrics().density) + 0.5d);
    }

    private static boolean c() {
        if (TextUtils.equals(Build.MANUFACTURER, "OPPO") && Build.VERSION.SDK_INT == 25) {
            f414983a.i("UIUtil", "is oppo 7.1.1, use post ui task to show toast");
            return true;
        }
        return false;
    }

    public static void e(CharSequence charSequence, boolean z16) {
        f(charSequence, z16, 1);
    }

    public static void f(final CharSequence charSequence, final boolean z16, final int i3) {
        f414983a.i("UIUtil", "showToast, text=" + ((Object) charSequence) + ",longToast=" + z16 + ",toastType=" + i3);
        if (TextUtils.isEmpty(charSequence)) {
            return;
        }
        if (Looper.getMainLooper().getThread().getId() == Thread.currentThread().getId() && !c()) {
            g(charSequence, z16, i3);
        } else {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: lk4.d
                @Override // java.lang.Runnable
                public final void run() {
                    e.g(charSequence, z16, i3);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g(CharSequence charSequence, boolean z16, int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        a.a(BaseApplication.getContext(), 0, charSequence, z16 ? 1 : 0).show();
                        return;
                    } else {
                        a.a(BaseApplication.getContext(), 0, charSequence, z16 ? 1 : 0).show();
                        return;
                    }
                }
                a.a(BaseApplication.getContext(), 2, charSequence, z16 ? 1 : 0).show();
                return;
            }
            a.a(BaseApplication.getContext(), 0, charSequence, z16 ? 1 : 0).show();
            return;
        }
        a.a(BaseApplication.getContext(), 1, charSequence, z16 ? 1 : 0).show();
    }
}
