package com.qzone.album.business.photolist.ui.menu;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import com.qzone.album.ui.widget.SafePopupWindow;
import com.qzone.proxy.feedcomponent.util.j;
import com.qzone.util.ar;
import com.qzone.widget.AsyncImageView;

/* compiled from: P */
/* loaded from: classes39.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private Context f43692a;

    /* renamed from: b, reason: collision with root package name */
    private SafePopupWindow f43693b;

    public a(Context context) {
        this.f43692a = context;
        a();
    }

    private void a() {
        FrameLayout frameLayout = new FrameLayout(this.f43692a);
        AsyncImageView asyncImageView = new AsyncImageView(this.f43692a);
        frameLayout.addView(asyncImageView, new FrameLayout.LayoutParams(ar.e(206.0f), ar.e(82.0f)));
        asyncImageView.setAsyncImage("https://qzonestyle.gtimg.cn/aoi/sola/20181211194150_inf8dYcZP0.png");
        SafePopupWindow safePopupWindow = new SafePopupWindow(frameLayout, -2, -2);
        this.f43693b = safePopupWindow;
        safePopupWindow.setFocusable(true);
        this.f43693b.setBackgroundDrawable(new ColorDrawable(0));
        this.f43693b.setOnDismissListener(new C0346a());
    }

    public void b(View view, int i3, int i16) {
        SafePopupWindow safePopupWindow = this.f43693b;
        if (safePopupWindow == null || view == null) {
            return;
        }
        safePopupWindow.showAsDropDown(view, i3, i16);
        this.f43693b.setFocusable(true);
        this.f43693b.setOutsideTouchable(true);
        try {
            this.f43693b.update();
        } catch (Exception e16) {
            j.d("AlbumShortcutPopupWindow", "showAsDropDown e:", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.qzone.album.business.photolist.ui.menu.a$a, reason: collision with other inner class name */
    /* loaded from: classes39.dex */
    public class C0346a implements PopupWindow.OnDismissListener {
        C0346a() {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
        }
    }
}
