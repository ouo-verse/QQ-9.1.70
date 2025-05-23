package com.tencent.icgame.game.liveroom.impl.room.definition;

import android.app.Activity;
import android.graphics.Point;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.util.Utils;

/* loaded from: classes7.dex */
public class DefinitionPopupWindow {

    /* renamed from: a, reason: collision with root package name */
    private PopupWindow f115199a = null;

    /* renamed from: b, reason: collision with root package name */
    private final Runnable f115200b = new Runnable() { // from class: com.tencent.icgame.game.liveroom.impl.room.definition.DefinitionPopupWindow.2
        @Override // java.lang.Runnable
        public void run() {
            if (DefinitionPopupWindow.this.f115199a != null && DefinitionPopupWindow.this.f115199a.isShowing()) {
                DefinitionPopupWindow.this.f115199a.dismiss();
                DefinitionPopupWindow.this.f115199a = null;
            }
        }
    };

    /* loaded from: classes7.dex */
    class a implements PopupWindow.OnDismissListener {
        a() {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            ThreadManager.getUIHandler().removeCallbacks(DefinitionPopupWindow.this.f115200b);
            DefinitionPopupWindow.this.f115199a = null;
        }
    }

    public void d() {
        if (this.f115199a == null) {
            return;
        }
        ThreadManager.getUIHandler().removeCallbacks(this.f115200b);
        this.f115199a.dismiss();
        this.f115199a = null;
    }

    public void e(Activity activity, ViewGroup viewGroup, boolean z16) {
        View decorView = activity.getWindow().getDecorView();
        Point point = new Point();
        activity.getWindowManager().getDefaultDisplay().getSize(point);
        if (z16) {
            PopupWindow popupWindow = new PopupWindow(viewGroup, Utils.n(228.0f, activity.getResources()), point.y);
            this.f115199a = popupWindow;
            popupWindow.setFocusable(false);
            this.f115199a.setClippingEnabled(false);
            this.f115199a.setOutsideTouchable(true);
            this.f115199a.setAnimationStyle(R.style.a06);
            this.f115199a.showAtLocation(decorView, 8388613, 0, 0);
        } else {
            PopupWindow popupWindow2 = new PopupWindow(viewGroup, -1, Utils.n(108.0f, viewGroup.getContext().getResources()));
            this.f115199a = popupWindow2;
            popupWindow2.setFocusable(false);
            this.f115199a.setOutsideTouchable(true);
            this.f115199a.setAnimationStyle(R.style.a06);
            this.f115199a.showAtLocation(decorView, 80, 0, 0);
        }
        this.f115199a.setOnDismissListener(new a());
        ThreadManager.getUIHandler().removeCallbacks(this.f115200b);
        ThreadManager.getUIHandler().postDelayed(this.f115200b, 5000L);
    }
}
