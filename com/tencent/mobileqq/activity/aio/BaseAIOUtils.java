package com.tencent.mobileqq.activity.aio;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.util.Pair;
import android.view.TouchDelegate;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* compiled from: P */
/* loaded from: classes10.dex */
public class BaseAIOUtils {
    private static Boolean c(@NonNull String str) {
        if (str.length() != 0) {
            boolean z16 = false;
            char charAt = str.charAt(0);
            if (Character.isUpperCase(charAt) || Character.isLowerCase(charAt) || Character.isDigit(charAt)) {
                z16 = true;
            }
            return Boolean.valueOf(z16);
        }
        return Boolean.FALSE;
    }

    public static Boolean d(String str) {
        if (str != null && !TextUtils.isDigitsOnly(str) && !c(str).booleanValue()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[checkAIOParamValid]: ");
            sb5.append(QLog.getStackTraceString(new Throwable("uid invalid " + str)));
            QLog.i("BaseAIOUtils", 1, sb5.toString());
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    public static Boolean e(String str) {
        if (str != null && (str.isEmpty() || str.length() < 5 || !TextUtils.isDigitsOnly(str))) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[checkUinValid]: ");
            sb5.append(QLog.getStackTraceString(new Throwable("uin invalid " + str)));
            QLog.i("BaseAIOUtils", 1, sb5.toString());
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    public static final int f(float f16, Resources resources) {
        if (f16 == 0.0f) {
            return 0;
        }
        return (int) ((f16 * resources.getDisplayMetrics().density) + 0.5f);
    }

    public static void g(final View view, final int i3) {
        if (view == null) {
            return;
        }
        ((View) view.getParent()).post(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.n
            @Override // java.lang.Runnable
            public final void run() {
                BaseAIOUtils.j(view, i3);
            }
        });
    }

    public static void h(final View view, final int i3, final int i16, final int i17, final int i18) {
        if (view == null) {
            return;
        }
        ((View) view.getParent()).post(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.BaseAIOUtils.1
            @Override // java.lang.Runnable
            public void run() {
                Rect rect = new Rect();
                view.setEnabled(true);
                view.getHitRect(rect);
                rect.top -= i3;
                rect.bottom += i16;
                rect.left -= i17;
                rect.right += i18;
                if (QLog.isColorLevel()) {
                    QLog.d("TouchDelegate", 2, " bounds.top=" + rect.top + "bounds.bottom=" + rect.bottom);
                }
                TouchDelegate touchDelegate = new TouchDelegate(rect, view);
                if (View.class.isInstance(view.getParent())) {
                    ((View) view.getParent()).setTouchDelegate(touchDelegate);
                }
            }
        });
    }

    @Nullable
    private static Pair<Object, Object> i(InputMethodManager inputMethodManager) {
        if (QLog.isColorLevel()) {
            QLog.i("BaseAIOUtils", 2, "getInputServeObject VERSION.SDK_INT: " + Build.VERSION.SDK_INT);
        }
        try {
            if (Build.VERSION.SDK_INT > 29) {
                Method declaredMethod = inputMethodManager.getClass().getDeclaredMethod("getServedViewLocked", new Class[0]);
                declaredMethod.setAccessible(true);
                Method declaredMethod2 = inputMethodManager.getClass().getDeclaredMethod("getNextServedViewLocked", new Class[0]);
                declaredMethod2.setAccessible(true);
                return new Pair<>(declaredMethod.invoke(inputMethodManager, new Object[0]), declaredMethod2.invoke(inputMethodManager, new Object[0]));
            }
            Class<?> cls = inputMethodManager.getClass();
            Field declaredField = cls.getDeclaredField("mServedView");
            Field declaredField2 = cls.getDeclaredField("mNextServedView");
            declaredField.setAccessible(true);
            declaredField2.setAccessible(true);
            return new Pair<>(declaredField.get(inputMethodManager), declaredField2.get(inputMethodManager));
        } catch (Exception e16) {
            QLog.e("Q.aio.XPanelContainer", 1, " getInputServeObject exception ", e16);
            return new Pair<>(null, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void j(View view, int i3) {
        Rect rect = new Rect();
        view.getHitRect(rect);
        rect.top -= i3;
        rect.bottom += i3;
        rect.left -= i3;
        rect.right += i3;
        if (QLog.isColorLevel()) {
            QLog.d("TouchDelegate", 2, " bounds.top=" + rect.top + "bounds.bottom=" + rect.bottom);
        }
        TouchDelegate touchDelegate = new TouchDelegate(rect, view);
        if (View.class.isInstance(view.getParent())) {
            ((View) view.getParent()).setTouchDelegate(touchDelegate);
        }
    }

    public static final float l(int i3, Resources resources) {
        if (i3 == 0) {
            return 0.0f;
        }
        return i3 / resources.getDisplayMetrics().density;
    }

    public static Intent m(Intent intent, int[] iArr) {
        intent.putExtra("open_chatfragment", true);
        intent.addFlags(67108864);
        if (iArr != null) {
            for (int i3 : iArr) {
                if (i3 != 1) {
                    if (i3 == 2) {
                        intent.addFlags(268435456);
                    }
                } else {
                    intent.putExtra("open_chatfragment_withanim", true);
                }
            }
        }
        if (QLog.isDevelopLevel()) {
            QLog.i("BaseAIOUtils", 4, QLog.getStackTraceString(new Throwable()));
        }
        return new AIOIntent(intent);
    }

    public static ActivityURIRequest n(ActivityURIRequest activityURIRequest, int[] iArr) {
        activityURIRequest.extra().putBoolean("open_chatfragment", true);
        activityURIRequest.setFlags(67108864);
        if (iArr != null) {
            for (int i3 : iArr) {
                if (i3 != 1) {
                    if (i3 == 2) {
                        activityURIRequest.setFlags(268435456);
                    }
                } else {
                    activityURIRequest.extra().putBoolean("open_chatfragment_withanim", true);
                }
            }
        }
        if (QLog.isDevelopLevel()) {
            QLog.i("BaseAIOUtils", 4, QLog.getStackTraceString(new Throwable()));
        }
        return activityURIRequest;
    }

    public static void o(final View view) {
        if (view == null) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.aio.XPanelContainer", 2, "showKeyboard failed, view is null ");
                return;
            }
            return;
        }
        if (view.requestFocus()) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.aio.XPanelContainer", 2, " requestFocus success ");
            }
            if (QLog.isColorLevel()) {
                QLog.d("Q.aio.XPanelContainer", 2, " hasFocus: " + view.hasFocus() + " hasWindowFocus: " + view.hasWindowFocus());
            }
        } else if (QLog.isColorLevel()) {
            QLog.e("Q.aio.XPanelContainer", 2, " requestFocus fail ");
        }
        ResultReceiver resultReceiver = new ResultReceiver(new Handler()) { // from class: com.tencent.mobileqq.activity.aio.BaseAIOUtils.2
            @Override // android.os.ResultReceiver
            protected void onReceiveResult(int i3, Bundle bundle) {
                if (i3 != 2) {
                    QLog.e("Q.aio.XPanelContainer", 1, " showSoftInput Result" + i3 + "bundle" + bundle);
                }
            }
        };
        final InputMethodManager inputMethodManager = (InputMethodManager) view.getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        if (inputMethodManager.showSoftInput(view, 0, resultReceiver)) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.aio.XPanelContainer", 2, " showSoftInput success ");
            }
        } else {
            if (QLog.isColorLevel()) {
                QLog.e("Q.aio.XPanelContainer", 2, " showSoftInput fail ");
            }
            try {
                Pair<Object, Object> i3 = i(inputMethodManager);
                Object obj = i3.first;
                Object obj2 = i3.second;
                if (QLog.isColorLevel()) {
                    QLog.d("Q.aio.XPanelContainer", 2, " showSoftInput fail mNextServedObject = " + obj2 + " mServedObject" + obj + " messageInputer = " + view);
                }
                if (obj != null && obj != view) {
                    if (obj instanceof View) {
                        inputMethodManager.hideSoftInputFromWindow(((View) obj).getWindowToken(), 0);
                        view.requestFocusFromTouch();
                        view.requestFocus();
                        if (!inputMethodManager.showSoftInput(view, 0) && QLog.isColorLevel()) {
                            QLog.d("Q.aio.XPanelContainer", 2, " try showSoftInput fail ");
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d("Q.aio.XPanelContainer", 2, " try showSoftInput end");
                        }
                    }
                } else {
                    view.post(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.m
                        @Override // java.lang.Runnable
                        public final void run() {
                            inputMethodManager.showSoftInput(view, 2);
                        }
                    });
                }
                QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
                if (qBaseActivity != null && qBaseActivity.getWindow() != null && qBaseActivity.getWindow().getDecorView() != null) {
                    QLog.e("Q.aio.XPanelContainer", 1, " showSoftInput focus: ", qBaseActivity.getWindow().getDecorView().findFocus());
                }
            } catch (Exception e16) {
                QLog.e("Q.aio.XPanelContainer", 1, " showSoftInput fail ", e16);
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.aio.XPanelContainer", 2, " imm.isActive() = " + inputMethodManager.isActive());
        }
    }
}
