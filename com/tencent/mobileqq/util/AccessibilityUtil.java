package com.tencent.mobileqq.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Method;

/* compiled from: P */
/* loaded from: classes20.dex */
public class AccessibilityUtil {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f306351a = false;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a extends View.AccessibilityDelegate {
        a() {
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            accessibilityNodeInfo.setCheckable(false);
            accessibilityNodeInfo.setSelected(false);
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class b extends View.AccessibilityDelegate {
        b() {
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            EditText editText = (EditText) view;
            editText.setHint("");
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            accessibilityNodeInfo.setContentDescription(editText.getContentDescription());
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class c extends View.AccessibilityDelegate {
        c() {
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            accessibilityNodeInfo.setVisibleToUser(false);
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class d extends View.AccessibilityDelegate {
        d() {
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            accessibilityNodeInfo.setVisibleToUser(false);
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class e extends View.AccessibilityDelegate {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ i f306355a;

        e(i iVar) {
            this.f306355a = iVar;
        }

        @Override // android.view.View.AccessibilityDelegate
        public void sendAccessibilityEvent(View view, int i3) {
            i iVar;
            super.sendAccessibilityEvent(view, i3);
            if (i3 == 1 && (iVar = this.f306355a) != null) {
                iVar.onClick(view);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class f extends View.AccessibilityDelegate {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CharSequence f306356a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f306357b;

        f(CharSequence charSequence, String str) {
            this.f306356a = charSequence;
            this.f306357b = str;
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            CharSequence charSequence = this.f306356a;
            if (charSequence != null) {
                accessibilityNodeInfo.setContentDescription(charSequence);
            }
            accessibilityNodeInfo.setClassName(this.f306357b);
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class g extends View.AccessibilityDelegate {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f306358a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f306359b;

        g(String str, boolean z16) {
            this.f306358a = str;
            this.f306359b = z16;
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            accessibilityNodeInfo.setContentDescription(this.f306358a);
            accessibilityNodeInfo.setCheckable(true);
            accessibilityNodeInfo.setChecked(this.f306359b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class h extends View.AccessibilityDelegate {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CharSequence f306360a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f306361b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ CharSequence f306362c;

        h(CharSequence charSequence, boolean z16, CharSequence charSequence2) {
            this.f306360a = charSequence;
            this.f306361b = z16;
            this.f306362c = charSequence2;
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            accessibilityNodeInfo.setContentDescription(this.f306360a);
            accessibilityNodeInfo.setCheckable(true);
            accessibilityNodeInfo.setChecked(this.f306361b);
            CharSequence charSequence = this.f306362c;
            if (charSequence != null) {
                accessibilityNodeInfo.setClassName(charSequence);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface i {
        void onClick(View view);
    }

    @TargetApi(14)
    public static void A(Context context) {
        AppSetting.f99565y = j(context);
        b(context);
        if (QLog.isColorLevel()) {
            QLog.d("AccessibilityUtil", 2, "setTalkbackSwitch: " + AppSetting.f99565y);
        }
    }

    public static void B(final Context context) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.util.AccessibilityUtil.11
            @Override // java.lang.Runnable
            public void run() {
                AccessibilityUtil.A(context);
            }
        }, 16, null, true);
    }

    public static void C(View view, boolean z16) {
        if (view == null) {
            return;
        }
        x(view, view.getContentDescription(), z16, Button.class.getName());
    }

    public static void b(Context context) {
        if (context == null || f306351a) {
            return;
        }
        f306351a = true;
        if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qq_accessibility_change_listener_900", true)) {
            return;
        }
        QLog.i("AccessibilityUtil", 1, "[addTalkbackChangeListener]");
        try {
            ((AccessibilityManager) context.getSystemService("accessibility")).addAccessibilityStateChangeListener(new AccessibilityManager.AccessibilityStateChangeListener() { // from class: com.tencent.mobileqq.util.b
                @Override // android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener
                public final void onAccessibilityStateChanged(boolean z16) {
                    AccessibilityUtil.k(z16);
                }
            });
        } catch (Throwable th5) {
            QLog.i("AccessibilityUtil", 1, "[addTalkbackChangeListener] " + th5);
        }
    }

    @TargetApi(14)
    public static void c(View view, CharSequence charSequence, String str) {
        view.setAccessibilityDelegate(new f(charSequence, str));
    }

    public static void d(View view, String str) {
        c(view, null, str);
    }

    public static void e(View view, boolean z16) {
        if (view == null) {
            return;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                e(viewGroup.getChildAt(i3), z16);
            }
        }
        if (z16) {
            ViewCompat.setImportantForAccessibility(view, 1);
        } else {
            ViewCompat.setImportantForAccessibility(view, 2);
        }
    }

    @TargetApi(16)
    public static void f(View view) {
        if (view == null) {
            if (QLog.isColorLevel()) {
                QLog.w("AccessibilityUtil", 2, "clearFocus view can't be null");
                return;
            }
            return;
        }
        if (AppSetting.f99565y) {
            for (Method method : view.getClass().getMethods()) {
                if (method.getName().equals("clearAccessibilityFocus")) {
                    try {
                        method.invoke(view, new Object[0]);
                        return;
                    } catch (Exception e16) {
                        if (QLog.isColorLevel()) {
                            QLog.w("AccessibilityUtil", 2, "clearFocus: " + e16.toString());
                            return;
                        }
                        return;
                    }
                }
            }
        }
    }

    @TargetApi(16)
    public static void g(View view) {
        if (AppSetting.f99565y) {
            view.setAccessibilityDelegate(new c());
        }
    }

    @TargetApi(16)
    public static void h(View view) {
        AccessibilityManager accessibilityManager = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        if (accessibilityManager != null && accessibilityManager.isEnabled()) {
            view.setFocusable(true);
            view.setAccessibilityDelegate(new d());
        }
    }

    @Deprecated
    public static boolean i(Context context) {
        return ((AccessibilityManager) context.getSystemService("accessibility")).isEnabled();
    }

    public static boolean j(Context context) {
        if (context == null) {
            return false;
        }
        try {
            AccessibilityManager accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
            if (accessibilityManager == null || !accessibilityManager.isEnabled()) {
                return false;
            }
            if (!accessibilityManager.isTouchExplorationEnabled()) {
                return false;
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void k(boolean z16) {
        QLog.i("AccessibilityUtil", 1, "[onAccessibilityStateChanged]: " + z16);
        if (z16 != AppSetting.f99565y) {
            AppSetting.f99565y = z16;
        }
    }

    public static void l(Context context, final View view) {
        if (!((AccessibilityManager) context.getSystemService("accessibility")).isEnabled()) {
            return;
        }
        view.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.util.AccessibilityUtil.6
            @Override // java.lang.Runnable
            public void run() {
                view.sendAccessibilityEvent(8);
            }
        }, 200L);
    }

    @TargetApi(14)
    public static void m(final View view) {
        if (view == null) {
            if (QLog.isColorLevel()) {
                QLog.w("AccessibilityUtil", 2, "requestFocus view can't be null");
                return;
            }
            return;
        }
        view.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.util.AccessibilityUtil.3
            @Override // java.lang.Runnable
            public void run() {
                view.sendAccessibilityEvent(128);
            }
        }, 200L);
    }

    public static void n(View view, boolean z16) {
        if (view != null && AppSetting.f99565y) {
            if (z16) {
                ViewCompat.setImportantForAccessibility(view, 1);
            } else {
                ViewCompat.setImportantForAccessibility(view, 2);
            }
        }
    }

    public static void o(View view) {
        if (view instanceof TextView) {
            c(view, ((TextView) view).getText(), Button.class.getName());
        }
    }

    public static void p(View view, CharSequence charSequence) {
        c(view, charSequence, Button.class.getName());
    }

    public static void q(View view, String str, boolean z16) {
        x(view, str, z16, CheckBox.class.getName());
    }

    @Deprecated
    public static void r(View view, String str, boolean z16) {
        if (view != null) {
            view.setAccessibilityDelegate(new g(str, z16));
        }
    }

    public static void s(View view, String str) {
        if (view != null && AppSetting.f99565y) {
            view.setContentDescription(str);
        }
    }

    public static void t(View view, i iVar) {
        view.setAccessibilityDelegate(new e(iVar));
    }

    @TargetApi(14)
    public static void u(EditText editText, String str) {
        if (AppSetting.f99565y) {
            editText.setContentDescription(str);
            editText.setAccessibilityDelegate(new b());
        }
    }

    public static void v(View view, boolean z16) {
        String str;
        if (z16) {
            str = "\u5df2\u6298\u53e0";
        } else {
            str = "\u5df2\u5c55\u5f00";
        }
        z(view, str);
    }

    public static void w(View view) {
        if (view == null) {
            return;
        }
        view.setAccessibilityDelegate(new a());
    }

    public static void x(View view, CharSequence charSequence, boolean z16, CharSequence charSequence2) {
        if (view == null) {
            return;
        }
        view.setAccessibilityDelegate(new h(charSequence, z16, charSequence2));
    }

    public static void y(View view, String str, boolean z16) {
        x(view, str, z16, null);
    }

    public static void z(View view, CharSequence charSequence) {
        if (view != null && Build.VERSION.SDK_INT >= 30) {
            view.setStateDescription(charSequence);
        }
    }
}
