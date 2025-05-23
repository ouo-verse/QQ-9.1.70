package com.tencent.biz.qqcircle.widgets.comment;

import android.app.Activity;
import android.graphics.Point;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.tencent.biz.qqcircle.utils.bz;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.mobileqq.qcircle.api.global.QCircleHostGlobalInfo;
import com.tencent.mobileqq.qcircle.api.utils.QCircleDeviceInfoUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.core.utils.SoftKeyboardStateHelper;
import java.util.LinkedList;
import java.util.List;
import uq3.k;

/* compiled from: P */
/* loaded from: classes5.dex */
public class f {

    /* renamed from: g, reason: collision with root package name */
    public static final int f93570g = cx.a(250.0f);

    /* renamed from: a, reason: collision with root package name */
    private final List<b> f93571a = new LinkedList();

    /* renamed from: b, reason: collision with root package name */
    private boolean f93572b;

    /* renamed from: c, reason: collision with root package name */
    private View f93573c;

    /* renamed from: d, reason: collision with root package name */
    private int f93574d;

    /* renamed from: e, reason: collision with root package name */
    private int f93575e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f93576f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a implements OnApplyWindowInsetsListener {
        a() {
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            f.this.j(windowInsetsCompat);
            return ViewCompat.onApplyWindowInsets(view, windowInsetsCompat);
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface b {
        void onSoftKeyboardClosed();

        void onSoftKeyboardOpened(int i3);
    }

    public f(View view) {
        k b16 = k.b();
        int i3 = f93570g;
        this.f93574d = b16.e("sp_key_soft_keyboard_height", i3);
        this.f93575e = k.b().e("sp_key_real_keyboard_height", i3);
        this.f93573c = view;
        k(view);
    }

    private boolean b() {
        if (uq3.c.w() && QCircleHostGlobalInfo.isSplitViewMode() && QCircleDeviceInfoUtils.isHarmonyOs() && QCircleDeviceInfoUtils.getHarmonyBuildOsVersion().startsWith("2.0.0") && bz.o() && m()) {
            return true;
        }
        return false;
    }

    private boolean c(Activity activity) {
        if (uq3.c.w() && QCircleHostGlobalInfo.isSplitViewMode() && QCircleDeviceInfoUtils.isHarmonyOs() && l(activity)) {
            return true;
        }
        return false;
    }

    private boolean d(@NonNull ViewGroup viewGroup) {
        View childAt = viewGroup.getChildAt(0);
        if (childAt == null || !(this.f93573c.getContext() instanceof Activity)) {
            return false;
        }
        Point point = new Point();
        if (this.f93573c.getContext() instanceof Activity) {
            ((Activity) this.f93573c.getContext()).getWindowManager().getDefaultDisplay().getRealSize(point);
        }
        if (!childAt.getClass().getSimpleName().contains("HwSplitScreenCaptionView") || childAt.getBottom() == point.y) {
            return false;
        }
        return true;
    }

    private boolean e() {
        View view = this.f93573c;
        if (view != null && (view.getContext() instanceof Activity) && !b() && c((Activity) this.f93573c.getContext())) {
            return true;
        }
        return false;
    }

    private int h(int i3) {
        if (bz.o() && !bz.r()) {
            if (i3 == 0) {
                QLog.d(SoftKeyboardStateHelper.TAG, 1, "fixKeyboardHeight: height: " + i3 + ", mSpRealKeyBoardHeight:" + this.f93575e);
            }
            if (i3 == 0) {
                return this.f93575e;
            }
            return i3;
        }
        return i3;
    }

    private void k(View view) {
        ViewCompat.setOnApplyWindowInsetsListener(view, new a());
    }

    private boolean l(Activity activity) {
        boolean isInMultiWindowMode;
        boolean isInMultiWindowMode2;
        boolean z16 = false;
        if (activity == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("isInMultiWindowMode: ");
            isInMultiWindowMode = activity.isInMultiWindowMode();
            sb5.append(isInMultiWindowMode);
            QLog.d(SoftKeyboardStateHelper.TAG, 1, sb5.toString());
            isInMultiWindowMode2 = activity.isInMultiWindowMode();
            return isInMultiWindowMode2;
        }
        int instantScreenWidth = DisplayUtil.getInstantScreenWidth(activity);
        int instantScreenHeight = DisplayUtil.getInstantScreenHeight(activity);
        if (instantScreenWidth != DisplayUtil.getScreenWidth() && instantScreenHeight != DisplayUtil.getScreenHeight()) {
            if (instantScreenHeight - DisplayUtil.getScreenHeight() > 200 && instantScreenWidth - DisplayUtil.getScreenWidth() > 200) {
                z16 = true;
            }
            QLog.d(SoftKeyboardStateHelper.TAG, 1, "isInPictureInPictureMode: " + z16 + ", physicalWidth: " + instantScreenWidth + ", physicalHeight: " + instantScreenHeight + ", windowWidth: " + DisplayUtil.getScreenWidth() + ", windowHeight: " + DisplayUtil.getScreenHeight());
        }
        return z16;
    }

    private boolean m() {
        View view = this.f93573c;
        if (view != null && (view.getRootView() instanceof ViewGroup) && d((ViewGroup) this.f93573c.getRootView())) {
            return true;
        }
        return false;
    }

    private boolean n(int i3) {
        int instantScreenHeight = DisplayUtil.getInstantScreenHeight(RFWApplication.getApplication());
        if (instantScreenHeight - i3 < 200 && bz.k()) {
            QLog.e(SoftKeyboardStateHelper.TAG, 1, "[saveKeyboardHeight] too height. screenHeight: " + instantScreenHeight + ", keyboard height: " + i3 + ", default height: " + f93570g);
            return true;
        }
        return false;
    }

    private void o() {
        for (b bVar : this.f93571a) {
            if (bVar != null) {
                bVar.onSoftKeyboardClosed();
            }
        }
    }

    private void p(int i3) {
        for (b bVar : this.f93571a) {
            if (bVar != null) {
                bVar.onSoftKeyboardOpened(i3);
            }
        }
    }

    private void q(int i3, boolean z16) {
        boolean z17;
        if (z16 && n(i3)) {
            i3 = f93570g;
        }
        t(i3, z16);
        if (this.f93574d != i3 && z16) {
            z17 = true;
        } else {
            z17 = false;
        }
        boolean z18 = this.f93572b;
        if ((!z18 && z16) || z17) {
            this.f93572b = true;
            p(i3);
            this.f93574d = i3;
            k.b().m("sp_key_soft_keyboard_height", i3);
            return;
        }
        if (z18 && !z16) {
            this.f93572b = false;
            o();
        }
    }

    public void a(b bVar) {
        this.f93571a.add(bVar);
    }

    public void f(boolean z16) {
        if (!b()) {
            return;
        }
        q(0, z16);
    }

    public void g(boolean z16) {
        if (e()) {
            this.f93576f = true;
            q(0, z16);
        }
    }

    public int i() {
        return this.f93575e;
    }

    public void j(WindowInsetsCompat windowInsetsCompat) {
        if (e() && this.f93576f) {
            QLog.d(SoftKeyboardStateHelper.TAG, 1, "[handleOnApplyWindowInsets] disableNotifyKeyboardStatus");
        } else {
            q(h(windowInsetsCompat.getInsets(WindowInsetsCompat.Type.ime()).bottom), windowInsetsCompat.isVisible(WindowInsetsCompat.Type.ime()));
        }
    }

    public void r() {
        this.f93571a.clear();
    }

    public void s(b bVar) {
        this.f93571a.remove(bVar);
    }

    public void t(int i3, boolean z16) {
        int i16;
        if (i3 == 0 && z16 && (i16 = this.f93574d) != 0 && i16 != this.f93575e) {
            k.b().m("sp_key_real_keyboard_height", this.f93574d);
            this.f93575e = this.f93574d;
        }
    }
}
