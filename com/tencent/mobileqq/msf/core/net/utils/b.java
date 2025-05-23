package com.tencent.mobileqq.msf.core.net.utils;

import android.content.Intent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes15.dex */
public class b {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: a, reason: collision with root package name */
    public static final String f249483a = "HotFixNotifyHelper";

    /* renamed from: b, reason: collision with root package name */
    public static final int f249484b = 1;

    /* renamed from: c, reason: collision with root package name */
    public static final int f249485c = 2;

    /* renamed from: d, reason: collision with root package name */
    public static final int f249486d = 0;

    /* renamed from: e, reason: collision with root package name */
    public static final int f249487e = 0;

    /* renamed from: f, reason: collision with root package name */
    public static final int f249488f = 1;

    /* renamed from: g, reason: collision with root package name */
    public static final int f249489g = 2;

    /* renamed from: h, reason: collision with root package name */
    public static final int f249490h = 3;

    /* renamed from: i, reason: collision with root package name */
    public static final int f249491i = 100;

    /* renamed from: j, reason: collision with root package name */
    public static final int f249492j = 1000;

    /* renamed from: k, reason: collision with root package name */
    public static final String f249493k = "hot_fix_step_notification_action";

    /* renamed from: l, reason: collision with root package name */
    public static final String f249494l = "hot_fix_step";

    /* renamed from: m, reason: collision with root package name */
    public static final String f249495m = "hot_fix_is_success";

    /* renamed from: n, reason: collision with root package name */
    public static final String f249496n = "hot_fix_type";

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void a(int i3, int i16, boolean z16) {
        if (i3 < 0) {
            QLog.d(f249483a, 1, "sendHotFixBroadcast, error type: " + i3);
            return;
        }
        Intent intent = new Intent(f249493k);
        intent.putExtra(f249496n, i3);
        intent.putExtra(f249494l, i16);
        intent.putExtra(f249495m, z16);
        intent.setPackage(BaseApplication.getContext().getPackageName());
        BaseApplication.getContext().sendBroadcast(intent);
        QLog.d(f249483a, 1, "sendHotFixBroadcast, info: " + i3 + "|" + i16 + "|" + z16);
    }
}
