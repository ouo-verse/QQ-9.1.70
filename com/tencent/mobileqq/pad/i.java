package com.tencent.mobileqq.pad;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.KeyEventDispatcher;
import androidx.fragment.app.Fragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.microapp.sdk.MiniAppBridgeActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes16.dex */
public class i {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static Method f257095a;

    /* renamed from: b, reason: collision with root package name */
    private static final List<a> f257096b;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public interface a {
        void a(boolean z16);

        void onStart();
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(44426);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f257095a = null;
            f257096b = new ArrayList();
        }
    }

    public static void a(a aVar) {
        f257096b.add(aVar);
    }

    private static void b(boolean z16) {
        Iterator<a> it = f257096b.iterator();
        while (it.hasNext()) {
            it.next().a(z16);
        }
    }

    private static void c() {
        Iterator<a> it = f257096b.iterator();
        while (it.hasNext()) {
            it.next().onStart();
        }
    }

    public static void d(a aVar) {
        f257096b.remove(aVar);
    }

    public static void e(Context context, Bundle bundle, Class<? extends Fragment> cls, LaunchParam launchParam) {
        String str;
        QLog.d("QFragmentLaunch", 1, "startFragment: context = [" + context + "], fragmentCls = [" + cls + "], launchParam = [" + launchParam + "]");
        Intent g16 = g(context, bundle, cls, launchParam);
        c();
        KeyEventDispatcher.Component component = QBaseActivity.sTopActivity;
        if (component instanceof l) {
            k kVar = ((l) component).getqFragmentStackManager();
            if (kVar == null) {
                QLog.d("QFragmentLaunch", 1, "startFragment, but QFragmentStackManager is null");
                b(false);
                return;
            }
            String s16 = kVar.s(g16);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("start Fragment directly\uff0c tag = ");
            if (s16 == null) {
                str = "null";
            } else {
                str = s16;
            }
            sb5.append(str);
            QLog.d("QFragmentLaunch", 1, sb5.toString());
            if (TextUtils.isEmpty(s16)) {
                f(context, g16);
                b(true);
                return;
            } else {
                b(false);
                return;
            }
        }
        QLog.d("QFragmentLaunch", 1, "start Fragment by start Activity");
        f(context, g16);
        b(true);
    }

    private static void f(Context context, Intent intent) {
        intent.setClassName(context, "com.tencent.mobileqq.activity.SplashActivity");
        try {
            if (f257095a == null) {
                String str = SplashActivity.TAG;
                f257095a = SplashActivity.class.getMethod("getAliasName", new Class[0]);
            }
            intent.setClassName(context, (String) f257095a.invoke(null, new Object[0]));
        } catch (Exception e16) {
            QLog.e("QFragmentLaunch", 1, e16, new Object[0]);
        }
        context.startActivity(intent);
    }

    private static Intent g(Context context, Bundle bundle, Class<? extends Fragment> cls, LaunchParam launchParam) {
        Intent intent = new Intent();
        intent.addFlags(67108864);
        if (context instanceof Application) {
            intent.addFlags(268435456);
        }
        intent.putExtra("is_add_fragment", true);
        intent.putExtra("extra_argument", bundle);
        intent.putExtra(MiniAppBridgeActivity.KEY_LAUNCH_PARAM, launchParam);
        intent.putExtra("top_fragment_class", cls.getName());
        return intent;
    }
}
