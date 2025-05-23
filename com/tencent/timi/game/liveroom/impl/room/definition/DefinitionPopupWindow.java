package com.tencent.timi.game.liveroom.impl.room.definition;

import android.app.Activity;
import android.graphics.Point;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.util.Utils;

/* loaded from: classes26.dex */
public class DefinitionPopupWindow {

    /* renamed from: a, reason: collision with root package name */
    private PopupWindow f377537a = null;

    /* renamed from: b, reason: collision with root package name */
    private final Runnable f377538b = new Runnable() { // from class: com.tencent.timi.game.liveroom.impl.room.definition.DefinitionPopupWindow.2
        @Override // java.lang.Runnable
        public void run() {
            if (DefinitionPopupWindow.this.f377537a != null && DefinitionPopupWindow.this.f377537a.isShowing()) {
                DefinitionPopupWindow.this.f377537a.dismiss();
                DefinitionPopupWindow.this.f377537a = null;
            }
        }
    };

    /* loaded from: classes26.dex */
    class a implements PopupWindow.OnDismissListener {
        a() {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            ThreadManager.getUIHandler().removeCallbacks(DefinitionPopupWindow.this.f377538b);
            DefinitionPopupWindow.this.f377537a = null;
        }
    }

    public void d() {
        if (this.f377537a == null) {
            return;
        }
        ThreadManager.getUIHandler().removeCallbacks(this.f377538b);
        this.f377537a.dismiss();
        this.f377537a = null;
    }

    public void e(Activity activity, ViewGroup viewGroup, boolean z16) {
        View decorView = activity.getWindow().getDecorView();
        Point point = new Point();
        activity.getWindowManager().getDefaultDisplay().getSize(point);
        if (z16) {
            PopupWindow popupWindow = new PopupWindow(viewGroup, Utils.n(228.0f, activity.getResources()), point.y);
            this.f377537a = popupWindow;
            popupWindow.setFocusable(false);
            this.f377537a.setClippingEnabled(false);
            this.f377537a.setOutsideTouchable(true);
            this.f377537a.setAnimationStyle(R.style.a06);
            this.f377537a.showAtLocation(decorView, 8388613, 0, 0);
        } else {
            PopupWindow popupWindow2 = new PopupWindow(viewGroup, -1, Utils.n(108.0f, viewGroup.getContext().getResources()));
            this.f377537a = popupWindow2;
            popupWindow2.setFocusable(false);
            this.f377537a.setOutsideTouchable(true);
            this.f377537a.setAnimationStyle(R.style.a06);
            this.f377537a.showAtLocation(decorView, 80, 0, 0);
        }
        this.f377537a.setOnDismissListener(new a());
        ThreadManager.getUIHandler().removeCallbacks(this.f377538b);
        ThreadManager.getUIHandler().postDelayed(this.f377538b, 5000L);
    }
}
