package com.tencent.mobileqq.bubble;

import android.content.res.Resources;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes11.dex */
public class f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static c f200742a;

    /* renamed from: b, reason: collision with root package name */
    public static c f200743b;

    /* renamed from: c, reason: collision with root package name */
    public static c f200744c;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(71035);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f200742a = new c(0);
        f200743b = new c(100000, R.drawable.flv, R.drawable.flw);
        f200744c = new c(100001, R.drawable.flv, R.drawable.flv);
    }

    public static c a(int i3, AppRuntime appRuntime, Resources resources, BaseAdapter baseAdapter) {
        return b(i3, appRuntime, resources, baseAdapter, true);
    }

    @NonNull
    public static c b(int i3, AppRuntime appRuntime, Resources resources, BaseAdapter baseAdapter, boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d("BubbleUtils", 2, "getBubbleInfo, bubbleId=" + i3 + ", shouldDownload=" + z16);
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (i3 == 100000) {
            return f200744c;
        }
        if (i3 == 100001) {
            return f200743b;
        }
        if (i3 < 1) {
            return f200742a;
        }
        c F = ((BubbleManager) appRuntime.getManager(QQManagerFactory.CHAT_BUBBLE_MANAGER)).F(i3, z16);
        if (F != null) {
            if (QLog.isColorLevel()) {
                QLog.d("bubble_performance", 2, "getBubbleInfo time " + (SystemClock.elapsedRealtime() - elapsedRealtime));
            }
            return F;
        }
        if (QLog.isColorLevel()) {
            QLog.d("bubble_performance", 2, "getBubbleInfo time default" + (SystemClock.elapsedRealtime() - elapsedRealtime));
        }
        return f200742a;
    }
}
