package com.tencent.mobileqq.activity.recent.cur;

import android.view.View;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.widget.TabDragAnimationView;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes10.dex */
public class c implements DragFrameLayout.a {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public TabDragAnimationView f185379d;

    /* renamed from: e, reason: collision with root package name */
    public View f185380e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f185381f;

    public c(TabDragAnimationView tabDragAnimationView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) tabDragAnimationView);
        } else {
            this.f185381f = false;
            this.f185379d = tabDragAnimationView;
        }
    }

    @Override // com.tencent.mobileqq.quibadge.QUIBadgeDragLayout.OnDragListener
    public void onDrag(float f16, float f17, int i3, View view) {
        View view2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Float.valueOf(f16), Float.valueOf(f17), Integer.valueOf(i3), view);
            return;
        }
        if (this.f185379d != null && (view2 = this.f185380e) != null && view2.equals(view)) {
            if (QLog.isColorLevel()) {
                QLog.d("TabDragListener", 2, "drag detect x=" + f16 + ",y=" + f17 + ",dragType=" + i3);
            }
            if (i3 != 1 && i3 != 2) {
                if (this.f185381f) {
                    this.f185381f = false;
                    this.f185379d.g();
                    return;
                }
                return;
            }
            if (!this.f185381f) {
                this.f185379d.L();
            }
            this.f185381f = true;
            this.f185379d.K(f16, f17, false);
        }
    }
}
