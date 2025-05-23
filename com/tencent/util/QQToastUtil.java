package com.tencent.util;

import android.content.res.Resources;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.StringRes;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes27.dex */
public class QQToastUtil {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "QQToastUtil";

    public QQToastUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void showQQToast(int i3) {
        showQQToast(-1, i3);
    }

    public static void showQQToastInUiThread(int i3, String str) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            showQQToast(i3, str);
        } else {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable(i3, str) { // from class: com.tencent.util.QQToastUtil.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ int f383965d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ String f383966e;

                {
                    this.f383965d = i3;
                    this.f383966e = str;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, i3, (Object) str);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    } else {
                        QQToastUtil.showQQToast(this.f383965d, this.f383966e);
                    }
                }
            });
        }
    }

    public static void showQQToast(int i3, int i16) {
        BaseApplication context = BaseApplication.getContext();
        QQToast.makeText(context, i3, i16, 0).show(context.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
    }

    public static void showQQToast(int i3, String str) {
        BaseApplication context = BaseApplication.getContext();
        QQToast.makeText(context, i3, str, 0).show(context.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
    }

    public static void showQQToast(int i3, @StringRes int i16, Object... objArr) {
        String str;
        BaseApplication context = BaseApplication.getContext();
        try {
            str = context.getString(i16, objArr);
        } catch (Resources.NotFoundException unused) {
            QLog.e(TAG, 1, "showQQToast resNotFound: " + i16);
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        QQToast.makeText(context, i3, str, 0).show(context.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
    }
}
