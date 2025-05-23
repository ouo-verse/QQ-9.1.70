package com.tencent.mobileqq.filemanager.util;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes12.dex */
public class QQFMToastUtil {

    /* renamed from: a, reason: collision with root package name */
    private static int f209209a = BaseApplication.getContext().getResources().getDimensionPixelSize(R.dimen.title_bar_height) - ((int) com.tencent.mobileqq.utils.al.a(BaseApplication.getContext(), 5.0f));

    /* renamed from: b, reason: collision with root package name */
    private static Map<Integer, Long> f209210b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    private static Map<String, Long> f209211c = new HashMap();

    private static boolean b(int i3) {
        if (f209210b.containsKey(Integer.valueOf(i3))) {
            long longValue = f209210b.get(Integer.valueOf(i3)).longValue();
            long uptimeMillis = SystemClock.uptimeMillis();
            if (longValue + 2000 < uptimeMillis) {
                f209210b.put(Integer.valueOf(i3), Long.valueOf(uptimeMillis));
                return true;
            }
            return false;
        }
        f209210b.clear();
        f209210b.put(Integer.valueOf(i3), Long.valueOf(SystemClock.uptimeMillis()));
        return true;
    }

    private static boolean c(String str) {
        if (f209211c.containsKey(str)) {
            long longValue = f209211c.get(str).longValue();
            long uptimeMillis = SystemClock.uptimeMillis();
            if (longValue + 2000 < uptimeMillis) {
                f209211c.put(str, Long.valueOf(uptimeMillis));
                return true;
            }
            return false;
        }
        f209211c.clear();
        f209211c.put(str, Long.valueOf(SystemClock.uptimeMillis()));
        return true;
    }

    public static void d(int i3, final int i16) {
        if (QQFileManagerUtilImpl.A0().isBackgroundPause || !b(i16)) {
            return;
        }
        Looper mainLooper = Looper.getMainLooper();
        if (Thread.currentThread() != mainLooper.getThread()) {
            new Handler(mainLooper).post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.util.QQFMToastUtil.10
                @Override // java.lang.Runnable
                public void run() {
                    QQToast qQToast = new QQToast(BaseApplication.getContext());
                    qQToast.setToastIcon(R.drawable.hac);
                    qQToast.setDuration(3000);
                    qQToast.setToastMsg(i16);
                    qQToast.show(QQFMToastUtil.f209209a);
                }
            });
            return;
        }
        QQToast qQToast = new QQToast(BaseApplication.getContext());
        qQToast.setToastIcon(R.drawable.hac);
        qQToast.setDuration(3000);
        qQToast.setToastMsg(i16);
        qQToast.show(f209209a);
    }

    public static void e(final Context context, final int i3, final int i16) {
        if (context == null) {
            return;
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.util.QQFMToastUtil.11
            @Override // java.lang.Runnable
            public void run() {
                QQToast.makeText(context, i3, i16, 0).show(QQFMToastUtil.f209209a);
            }
        });
    }

    public static void f(final int i3, final String str, final int i16) {
        if (QQFileManagerUtilImpl.A0().isBackgroundPause || !c(str)) {
            return;
        }
        Looper mainLooper = Looper.getMainLooper();
        if (Thread.currentThread() != mainLooper.getThread()) {
            new Handler(mainLooper).post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.util.QQFMToastUtil.8
                @Override // java.lang.Runnable
                public void run() {
                    QQToast.makeText(BaseApplication.getContext(), i3, str, i16).show(QQFMToastUtil.f209209a);
                }
            });
        } else {
            QQToast.makeText(BaseApplication.getContext(), i3, str, i16).show(f209209a);
        }
    }

    public static void g(final int i3) {
        if (QQFileManagerUtilImpl.A0().isBackgroundPause || !b(i3)) {
            return;
        }
        Looper mainLooper = Looper.getMainLooper();
        if (Thread.currentThread() != mainLooper.getThread()) {
            new Handler(mainLooper).post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.util.QQFMToastUtil.7
                @Override // java.lang.Runnable
                public void run() {
                    QQToast.makeText(BaseApplication.getContext(), 0, i3, 0).show(QQFMToastUtil.f209209a);
                }
            });
        } else {
            QQToast.makeText(BaseApplication.getContext(), 0, i3, 0).show(f209209a);
        }
    }

    public static void h(final String str) {
        if (QQFileManagerUtilImpl.A0().isBackgroundPause) {
            return;
        }
        Looper mainLooper = Looper.getMainLooper();
        if (Thread.currentThread() != mainLooper.getThread()) {
            new Handler(mainLooper).post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.util.QQFMToastUtil.6
                @Override // java.lang.Runnable
                public void run() {
                    QQToast.makeText(BaseApplication.getContext(), 0, str, 0).show(QQFMToastUtil.f209209a);
                }
            });
        } else {
            QQToast.makeText(BaseApplication.getContext(), 0, str, 0).show(f209209a);
        }
    }

    public static void i(final int i3) {
        try {
            if (QQFileManagerUtilImpl.r1().isBackgroundPause || !b(i3)) {
                return;
            }
            Looper mainLooper = Looper.getMainLooper();
            if (Thread.currentThread() != mainLooper.getThread()) {
                new Handler(mainLooper).post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.util.QQFMToastUtil.1
                    @Override // java.lang.Runnable
                    public void run() {
                        QQToast.makeText(BaseApplication.getContext(), 0, i3, 0).show(QQFMToastUtil.f209209a);
                    }
                });
            } else {
                QQToast.makeText(BaseApplication.getContext(), 0, i3, 0).show(f209209a);
            }
        } catch (Exception unused) {
        }
    }

    public static void j(final String str) {
        if (QQFileManagerUtilImpl.r1().isBackgroundPause || !c(str)) {
            return;
        }
        Looper mainLooper = Looper.getMainLooper();
        if (Thread.currentThread() != mainLooper.getThread()) {
            new Handler(mainLooper).post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.util.QQFMToastUtil.2
                @Override // java.lang.Runnable
                public void run() {
                    QQToast.makeText(BaseApplication.getContext(), 0, str, 0).show(QQFMToastUtil.f209209a);
                }
            });
        } else {
            QQToast.makeText(BaseApplication.getContext(), 0, str, 0).show(f209209a);
        }
    }

    public static void k(final int i3) {
        if (QQFileManagerUtilImpl.A0().isBackgroundPause || !b(i3)) {
            return;
        }
        Looper mainLooper = Looper.getMainLooper();
        if (Thread.currentThread() != mainLooper.getThread()) {
            new Handler(mainLooper).post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.util.QQFMToastUtil.9
                @Override // java.lang.Runnable
                public void run() {
                    QQToast.makeText(BaseApplication.getContext(), -1, i3, 0).show(QQFMToastUtil.f209209a);
                }
            });
        } else {
            QQToast.makeText(BaseApplication.getContext(), -1, i3, 0).show(f209209a);
        }
    }

    public static void l(final int i3) {
        if (QQFileManagerUtilImpl.A0().isBackgroundPause || !b(i3)) {
            return;
        }
        Looper mainLooper = Looper.getMainLooper();
        if (Thread.currentThread() != mainLooper.getThread()) {
            new Handler(mainLooper).post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.util.QQFMToastUtil.3
                @Override // java.lang.Runnable
                public void run() {
                    QQToast.makeText(BaseApplication.getContext(), 2, i3, 0).show(QQFMToastUtil.f209209a);
                }
            });
        } else {
            QQToast.makeText(BaseApplication.getContext(), 2, i3, 0).show(f209209a);
        }
    }

    public static void m(final String str) {
        if (QQFileManagerUtilImpl.A0().isBackgroundPause) {
            return;
        }
        Looper mainLooper = Looper.getMainLooper();
        if (Thread.currentThread() != mainLooper.getThread()) {
            new Handler(mainLooper).post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.util.QQFMToastUtil.4
                @Override // java.lang.Runnable
                public void run() {
                    QQToast.makeText(BaseApplication.getContext(), 2, str, 0).show(QQFMToastUtil.f209209a);
                }
            });
        } else {
            QQToast.makeText(BaseApplication.getContext(), 2, str, 0).show(f209209a);
        }
    }

    public static void n(final String str) {
        if (QQFileManagerUtilImpl.A0().isBackgroundPause || !c(str)) {
            return;
        }
        Looper mainLooper = Looper.getMainLooper();
        if (Thread.currentThread() != mainLooper.getThread()) {
            new Handler(mainLooper).post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.util.QQFMToastUtil.5
                @Override // java.lang.Runnable
                public void run() {
                    QQToast.makeText(BaseApplication.getContext(), 2, str, 1).show(QQFMToastUtil.f209209a);
                }
            });
        } else {
            QQToast.makeText(BaseApplication.getContext(), 2, str, 1).show(f209209a);
        }
    }
}
