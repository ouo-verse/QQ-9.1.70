package com.tencent.mobileqq.activity.recent.cur;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.quibadge.QUIBadgeDragLayout;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes10.dex */
public class DragFrameLayout extends QUIBadgeDragLayout implements com.tencent.mobileqq.activity.recent.cur.b {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private static boolean f185370d;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public interface a extends QUIBadgeDragLayout.OnDragListener {
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public interface b extends QUIBadgeDragLayout.OnDragModeChangedListener {
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45964);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f185370d = false;
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.activity.recent.cur.a
                @Override // java.lang.Runnable
                public final void run() {
                    DragFrameLayout.d();
                }
            }, 16, null, false);
        }
    }

    public DragFrameLayout(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            c();
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        }
    }

    private void b() {
        if (!f185370d) {
            return;
        }
        QLog.e("DragFrameLayout", 1, "checkRemoveView\n" + QLog.getStackTraceString(new Throwable()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void d() {
        f185370d = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("drag_frame_layout_remove_view_101405751", false);
        QLog.i("DragFrameLayout", 1, "init() ----- needLogRemoveView:" + f185370d);
    }

    public static DragFrameLayout e(Activity activity) {
        ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
        View childAt = viewGroup.getChildAt(0);
        if (childAt instanceof DragFrameLayout) {
            return (DragFrameLayout) childAt;
        }
        DragFrameLayout dragFrameLayout = new DragFrameLayout(activity.getApplication());
        viewGroup.addView(dragFrameLayout, 0);
        viewGroup.removeView(childAt);
        dragFrameLayout.addView(childAt);
        return dragFrameLayout;
    }

    @Override // com.tencent.mobileqq.quibadge.QUIBadgeDragLayout, android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) view);
        } else {
            b();
            super.removeView(view);
        }
    }

    public DragFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            c();
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
        }
    }

    public DragFrameLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            c();
        } else {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
        }
    }

    private void c() {
    }
}
