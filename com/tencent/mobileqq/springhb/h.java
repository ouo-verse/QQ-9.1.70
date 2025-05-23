package com.tencent.mobileqq.springhb;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.springhb.pack.PackInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: P */
/* loaded from: classes18.dex */
public class h {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface a {
        void b(boolean z16, PackInfo packInfo, String str, String str2);

        void c();

        void d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void f(Bundle bundle, SpringGiftView springGiftView, int i3, a aVar) {
        PackInfo packInfo = (PackInfo) bundle.getSerializable("extra_pack_info");
        QLog.d("SpringHb_SpringHbApi", 1, "requestGiftInner, show view, packInfo=", packInfo);
        if (packInfo == null) {
            QLog.d("SpringHb_SpringHbApi", 1, "requestGiftInner, invalid packInfo");
            packInfo = x.d();
        }
        if (springGiftView != null) {
            packInfo.remainSeconds = i3;
            springGiftView.t(packInfo);
        }
        if (aVar != null) {
            aVar.b(true, packInfo, "", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void g(Bundle bundle, SpringGiftView springGiftView, int i3, a aVar) {
        QLog.d("SpringHb_SpringHbApi", 1, "requestGiftInner, failed, errMsg=", bundle.getString("extra_err_msg"));
        PackInfo d16 = x.d();
        if (springGiftView != null) {
            d16.remainSeconds = i3;
            springGiftView.t(d16);
        }
        if (aVar != null) {
            aVar.b(false, d16, "", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit h(Activity activity, final SpringGiftView springGiftView, final int i3, final a aVar, Integer num, final Bundle bundle) {
        QLog.d("SpringHb_SpringHbApi", 1, "requestGiftInner, result=", num);
        if (num.intValue() == 0) {
            activity.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.springhb.f
                @Override // java.lang.Runnable
                public final void run() {
                    h.f(bundle, springGiftView, i3, aVar);
                }
            });
            return null;
        }
        activity.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.springhb.g
            @Override // java.lang.Runnable
            public final void run() {
                h.g(bundle, springGiftView, i3, aVar);
            }
        });
        return null;
    }

    public static boolean i(Activity activity, int i3, int i16, a aVar, int i17) {
        return j(activity, true, i3, i16, aVar, false, true);
    }

    private static boolean j(final Activity activity, final boolean z16, final int i3, final int i16, final a aVar, final boolean z17, final boolean z18) {
        QLog.d("SpringHb_SpringHbApi", 1, "requestGift, isShua=", Boolean.valueOf(z16), ", sceneType=", Integer.valueOf(i3), ", remainSeconds=", Integer.valueOf(i16), ", isLandscape=", Boolean.valueOf(z17), ", isAutoOpen=", Boolean.valueOf(z18));
        if (activity != null) {
            if (!NetworkUtil.isNetworkAvailable()) {
                QLog.w("SpringHb_SpringHbApi", 1, "requestGift, network not available");
                QQToast.makeText(activity.getApplicationContext(), 1, "\u7f51\u7edc\u5f02\u5e38\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5\u3002", 0).show();
                return false;
            }
            if (Looper.getMainLooper() == Looper.myLooper()) {
                l(activity, z16, i3, i16, aVar, z17, z18);
            } else {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.mobileqq.springhb.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        h.l(activity, z16, i3, i16, aVar, z17, z18);
                    }
                });
            }
        } else {
            QLog.e("SpringHb_SpringHbApi", 1, "requestGift, activity null");
        }
        return true;
    }

    public static boolean k(Activity activity, int i3, boolean z16) {
        return j(activity, false, i3, 0, null, z16, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void l(final Activity activity, boolean z16, int i3, final int i16, final a aVar, boolean z17, boolean z18) {
        QLog.d("SpringHb_SpringHbApi", 1, "requestGiftInner, show loading view");
        final SpringGiftView s16 = SpringGiftView.s(activity, aVar, i3, z17, z18);
        com.tencent.mobileqq.springhb.servlet.c.c(i3, z16, new Function2() { // from class: com.tencent.mobileqq.springhb.e
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Unit h16;
                h16 = h.h(activity, s16, i16, aVar, (Integer) obj, (Bundle) obj2);
                return h16;
            }
        });
    }
}
