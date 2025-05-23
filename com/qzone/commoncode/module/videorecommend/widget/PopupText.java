package com.qzone.commoncode.module.videorecommend.widget;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qzone.album.ui.widget.SafePopupWindow;
import com.qzone.module.feedcomponent.ui.AreaConst;
import com.qzone.util.ar;
import com.qzone.widget.AsyncImageView;
import com.tencent.mobileqq.R;
import cooperation.qzone.util.QZLog;
import java.lang.ref.WeakReference;
import u5.b;

/* loaded from: classes39.dex */
public class PopupText {

    /* renamed from: a, reason: collision with root package name */
    private SafePopupWindow f46213a;

    /* renamed from: b, reason: collision with root package name */
    private WeakReference<Context> f46214b;

    /* renamed from: com.qzone.commoncode.module.videorecommend.widget.PopupText$1, reason: invalid class name */
    /* loaded from: classes39.dex */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ PopupText this$0;

        @Override // java.lang.Runnable
        public void run() {
            this.this$0.a();
        }
    }

    /* renamed from: com.qzone.commoncode.module.videorecommend.widget.PopupText$5, reason: invalid class name */
    /* loaded from: classes39.dex */
    class AnonymousClass5 implements Runnable {
        final /* synthetic */ PopupText this$0;

        @Override // java.lang.Runnable
        public void run() {
            this.this$0.a();
        }
    }

    /* renamed from: com.qzone.commoncode.module.videorecommend.widget.PopupText$6, reason: invalid class name */
    /* loaded from: classes39.dex */
    class AnonymousClass6 implements Runnable {
        final /* synthetic */ PopupText this$0;

        @Override // java.lang.Runnable
        public void run() {
            this.this$0.a();
        }
    }

    /* renamed from: com.qzone.commoncode.module.videorecommend.widget.PopupText$7, reason: invalid class name */
    /* loaded from: classes39.dex */
    class AnonymousClass7 implements Runnable {
        final /* synthetic */ PopupText this$0;

        @Override // java.lang.Runnable
        public void run() {
            this.this$0.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class a implements View.OnTouchListener {
        a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            PopupText.this.a();
            return true;
        }
    }

    public PopupText(Context context, String str, int i3, int i16) {
        this.f46214b = null;
        if (context != null) {
            this.f46214b = new WeakReference<>(context);
            View inflate = LayoutInflater.from(context).inflate(R.layout.bt7, (ViewGroup) null);
            this.f46213a = new SafePopupWindow(inflate, -2, -2);
            if (str != null) {
                TextView textView = (TextView) inflate.findViewById(R.id.hue);
                textView.setText(str);
                if (i16 == 100) {
                    View findViewById = inflate.findViewById(R.id.hud);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.addRule(3, R.id.huf);
                    layoutParams.addRule(9, -1);
                    findViewById.setLayoutParams(layoutParams);
                    findViewById.setPadding(AreaConst.dp25, 0, 0, 0);
                } else if (i16 != -1) {
                    View findViewById2 = inflate.findViewById(R.id.hud);
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams2.addRule(3, R.id.huf);
                    layoutParams2.addRule(13);
                    findViewById2.setLayoutParams(layoutParams2);
                }
                if (i3 == 1000) {
                    ((LinearLayout) inflate.findViewById(R.id.huf)).setBackgroundResource(R.drawable.g1u);
                    ((ImageView) inflate.findViewById(R.id.huc)).setBackgroundResource(R.drawable.g1s);
                    int e16 = ar.e(10.0f);
                    textView.setPadding(e16, e16, e16, e16);
                    textView.setTextColor(-16777216);
                } else if (i3 == 1001) {
                    ((LinearLayout) inflate.findViewById(R.id.huf)).setBackgroundResource(R.drawable.g1v);
                    ((ImageView) inflate.findViewById(R.id.huc)).setBackgroundResource(R.drawable.g1t);
                    int e17 = ar.e(10.0f);
                    textView.setPadding(e17, e17, e17, e17);
                    textView.setTextColor(-16777216);
                }
            }
            this.f46213a.setFocusable(false);
            this.f46213a.setBackgroundDrawable(new BitmapDrawable());
            if (this.f46213a.getContentView() != null) {
                this.f46213a.getContentView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                this.f46213a.getContentView().measure(0, 0);
            }
        }
    }

    public void a() {
        SafePopupWindow safePopupWindow = this.f46213a;
        if (safePopupWindow != null) {
            try {
                safePopupWindow.dismiss();
            } catch (Exception e16) {
                QZLog.w("exception", "PopupText.dismiss() exception:", e16);
            }
        }
    }

    public View b() {
        SafePopupWindow safePopupWindow = this.f46213a;
        if (safePopupWindow != null) {
            return safePopupWindow.getContentView();
        }
        return null;
    }

    public void c() {
        SafePopupWindow safePopupWindow = this.f46213a;
        if (safePopupWindow == null) {
            return;
        }
        safePopupWindow.setTouchInterceptor(new a());
    }

    public void e(View view, int i3, int i16, boolean z16, boolean z17, int i17) {
        SafePopupWindow safePopupWindow = this.f46213a;
        if (safePopupWindow == null || view == null) {
            return;
        }
        safePopupWindow.showAsDropDown(view, i3, i16);
        this.f46213a.setFocusable(z16);
        this.f46213a.setOutsideTouchable(z17);
        if (z17) {
            c();
        }
        try {
            this.f46213a.update();
        } catch (Exception e16) {
            QZLog.w("exception", "PopupText.update() exception:", e16);
        }
        view.postDelayed(new Runnable() { // from class: com.qzone.commoncode.module.videorecommend.widget.PopupText.2
            @Override // java.lang.Runnable
            public void run() {
                PopupText.this.a();
            }
        }, i17);
    }

    public void f(View view) {
        if (this.f46213a == null || view == null) {
            return;
        }
        int height = view.getHeight();
        SafePopupWindow safePopupWindow = this.f46213a;
        safePopupWindow.showAsDropDown(view, (-safePopupWindow.getContentView().getMeasuredWidth()) + view.getWidth(), (-height) - this.f46213a.getContentView().getMeasuredHeight());
        this.f46213a.setFocusable(true);
        this.f46213a.setOutsideTouchable(true);
        try {
            this.f46213a.update();
        } catch (Exception e16) {
            QZLog.w("exception", "PopupText.update() exception:", e16);
        }
        view.postDelayed(new Runnable() { // from class: com.qzone.commoncode.module.videorecommend.widget.PopupText.4
            @Override // java.lang.Runnable
            public void run() {
                PopupText.this.a();
            }
        }, 4000L);
    }

    public static boolean d(String str) {
        boolean D = b.D(str, true);
        if (D) {
            b.o0(str, false);
        }
        return D;
    }

    public void g(View view, boolean z16) {
        if (z16) {
            c();
        }
        f(view);
    }

    public PopupText(Context context, String str, int i3) {
        this(context, str, i3, -1);
    }

    public PopupText(Context context, int i3, int i16, String str) {
        this.f46214b = null;
        if (context != null) {
            this.f46214b = new WeakReference<>(context);
            AsyncImageView asyncImageView = new AsyncImageView(context);
            this.f46213a = new SafePopupWindow(asyncImageView, i3, i16);
            asyncImageView.setAsyncImage(str);
            this.f46213a.setFocusable(false);
            this.f46213a.setBackgroundDrawable(new BitmapDrawable());
            if (this.f46213a.getContentView() != null) {
                this.f46213a.getContentView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                this.f46213a.getContentView().measure(0, 0);
            }
        }
    }
}
