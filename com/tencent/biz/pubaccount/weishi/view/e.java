package com.tencent.biz.pubaccount.weishi.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi.util.ba;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LiuHaiUtils;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes32.dex */
public class e extends PopupWindow implements Animation.AnimationListener, View.OnClickListener {
    private static final int[] F = {R.string.x8o, R.drawable.gmt};
    private static final int[] G = {R.string.x8n, R.drawable.gmq};
    private static final int[] H = {R.string.x8m, R.drawable.gmr};
    private static final int[] I = {R.string.x8l, R.drawable.gmo};
    private static final int[] J = {R.string.x8p, R.drawable.gna};
    private WindowManager.LayoutParams C;
    private View D;
    private boolean E;

    /* renamed from: d, reason: collision with root package name */
    private Activity f82451d;

    /* renamed from: e, reason: collision with root package name */
    private d f82452e;

    /* renamed from: f, reason: collision with root package name */
    private InterfaceC0839e f82453f;

    /* renamed from: h, reason: collision with root package name */
    private c f82454h;

    /* renamed from: i, reason: collision with root package name */
    private int f82455i;

    /* renamed from: m, reason: collision with root package name */
    private int f82456m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (e.this.isShowing()) {
                e.this.dismiss();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public int f82459a;

        /* renamed from: b, reason: collision with root package name */
        public String f82460b;

        /* renamed from: c, reason: collision with root package name */
        public int f82461c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f82462d;
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface d {
        void a(c cVar);
    }

    /* compiled from: P */
    /* renamed from: com.tencent.biz.pubaccount.weishi.view.e$e, reason: collision with other inner class name */
    /* loaded from: classes32.dex */
    public interface InterfaceC0839e {
        void onDismiss();
    }

    e(Activity activity, View view, int i3, int i16, boolean z16) {
        super(view, i3, i16, z16);
        this.f82454h = null;
        this.f82455i = 0;
        this.f82456m = 0;
        this.E = false;
        this.f82451d = activity;
        h();
    }

    private static c a(Context context, int[] iArr, boolean z16) {
        c cVar = new c();
        cVar.f82459a = iArr[0];
        cVar.f82460b = context.getResources().getString(iArr[0]);
        cVar.f82461c = iArr[1];
        cVar.f82462d = z16;
        return cVar;
    }

    public static e b(Activity activity, boolean z16, d dVar, InterfaceC0839e interfaceC0839e) {
        List<c> f16 = f(activity, z16);
        if (f16 != null && f16.size() != 0) {
            int d16 = d(activity, f16.size());
            e eVar = new e(activity, j(activity, f16), ViewUtils.dip2px(143.0f), d16, true);
            eVar.setAnimationStyle(R.style.f173310t);
            eVar.setBackgroundDrawable(new ColorDrawable(0));
            eVar.setOutsideTouchable(false);
            l(eVar, 1002);
            if (AppSetting.f99565y) {
                k(eVar);
            }
            eVar.i(eVar.getContentView());
            eVar.f82456m = d16;
            eVar.f82452e = dVar;
            eVar.f82453f = interfaceC0839e;
            eVar.E = false;
            return eVar;
        }
        throw new IllegalArgumentException("parameter items can not be null or zero-length array.");
    }

    private static List<c> f(Context context, boolean z16) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(a(context, H, false));
        if (com.tencent.biz.pubaccount.weishi.home.c.j() || com.tencent.biz.pubaccount.weishi.home.c.m()) {
            arrayList.add(a(context, F, false));
        }
        arrayList.add(a(context, G, z16));
        arrayList.add(a(context, I, false));
        arrayList.add(a(context, J, false));
        return arrayList;
    }

    public static int g(Context context, int i3) {
        return context.getResources().getDimensionPixelSize(i3);
    }

    private void h() {
        int height;
        if (this.C == null) {
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            this.C = layoutParams;
            layoutParams.type = 1000;
            layoutParams.format = -3;
            layoutParams.flags = 40;
            if (ImmersiveUtils.isSupporImmersive() == 1) {
                this.C.flags |= 67108864;
            }
            int i3 = -1;
            this.C.width = -1;
            if (this.f82451d.getWindow() != null && this.f82451d.getWindow().getDecorView() != null && (height = this.f82451d.getWindow().getDecorView().getHeight()) > 0) {
                i3 = height;
            }
            WindowManager.LayoutParams layoutParams2 = this.C;
            layoutParams2.height = i3;
            layoutParams2.windowAnimations = R.style.f173628ho;
        }
        if (this.D == null) {
            View view = new View(this.f82451d);
            this.D = view;
            view.setBackgroundColor(this.f82451d.getResources().getColor(R.color.f156934fo));
            this.D.setContentDescription(HardCodeUtil.qqStr(R.string.paq));
            this.D.setOnClickListener(new a());
        }
        if (AppSetting.f99565y) {
            getContentView().setAccessibilityDelegate(new b());
        }
    }

    private void i(View view) {
        if (view.getTag() != null && (view.getTag() instanceof c)) {
            view.setOnClickListener(this);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                i(viewGroup.getChildAt(i3));
            }
        }
    }

    private static View j(Activity activity, List<c> list) {
        View inflate = LayoutInflater.from(activity).inflate(R.layout.fwe, (ViewGroup) null);
        c(activity, inflate, list);
        return inflate;
    }

    public static void k(PopupWindow popupWindow) {
        if (AppSetting.f99565y) {
            for (Method method : PopupWindow.class.getMethods()) {
                if (TextUtils.equals(method.getName(), "setTouchModal")) {
                    try {
                        method.invoke(popupWindow, Boolean.FALSE);
                        return;
                    } catch (Exception e16) {
                        e16.printStackTrace();
                        return;
                    }
                }
            }
        }
    }

    public static void l(PopupWindow popupWindow, int i3) {
        for (Method method : PopupWindow.class.getMethods()) {
            if (TextUtils.equals(method.getName(), "setWindowLayoutType")) {
                try {
                    method.invoke(popupWindow, Integer.valueOf(i3));
                    return;
                } catch (Exception e16) {
                    e16.printStackTrace();
                    return;
                }
            }
        }
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        c cVar;
        try {
            if (LiuHaiUtils.hasNotchInScreenWrapper(this.f82451d)) {
                ((ViewGroup) this.f82451d.getWindow().getDecorView()).removeView(this.D);
            } else {
                this.f82451d.getWindowManager().removeView(this.D);
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.i("WSPopupMenuDialog", 2, e16.toString());
            }
        }
        super.dismiss();
        d dVar = this.f82452e;
        if (dVar != null && (cVar = this.f82454h) != null) {
            dVar.a(cVar);
        }
        this.f82454h = null;
        InterfaceC0839e interfaceC0839e = this.f82453f;
        if (interfaceC0839e != null) {
            interfaceC0839e.onDismiss();
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        c cVar;
        if (QLog.isColorLevel()) {
            QLog.i("WSPopupMenuDialog", 2, "onAnimationEnd");
        }
        d dVar = this.f82452e;
        if (dVar != null && (cVar = this.f82454h) != null) {
            dVar.a(cVar);
        }
        this.f82454h = null;
        InterfaceC0839e interfaceC0839e = this.f82453f;
        if (interfaceC0839e != null) {
            interfaceC0839e.onDismiss();
        }
        super.dismiss();
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        if (QLog.isColorLevel()) {
            QLog.i("WSPopupMenuDialog", 2, "onAnimationStart");
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f82454h = (c) view.getTag();
        dismiss();
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i3, int i16) {
        int maxAvailableHeight = getMaxAvailableHeight(view, i16);
        if (maxAvailableHeight != this.f82455i) {
            int g16 = maxAvailableHeight < this.f82456m ? ((1 - g(this.f82451d, R.dimen.au_)) + maxAvailableHeight) / (g(this.f82451d, R.dimen.aub) + 1) : 0;
            if (g16 > 0) {
                setHeight(e(this.f82451d, g16, this.E));
            } else {
                setHeight(this.f82456m);
            }
            this.f82455i = maxAvailableHeight;
        }
        try {
            if (LiuHaiUtils.hasNotchInScreenWrapper(this.f82451d)) {
                ((ViewGroup) this.f82451d.getWindow().getDecorView()).addView(this.D, this.C);
            } else {
                this.f82451d.getWindowManager().addView(this.D, this.C);
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.i("WSPopupMenuDialog", 2, e16.toString());
            }
        }
        super.showAsDropDown(view, i3, i16);
    }

    @Override // android.widget.PopupWindow
    public void showAtLocation(View view, int i3, int i16, int i17) {
        try {
            if (LiuHaiUtils.hasNotchInScreenWrapper(this.f82451d)) {
                ((ViewGroup) this.f82451d.getWindow().getDecorView()).addView(this.D, this.C);
            } else {
                this.f82451d.getWindowManager().addView(this.D, this.C);
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.i("WSPopupMenuDialog", 2, e16.toString());
            }
        }
        super.showAtLocation(view, i3, i16, i17);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class b extends View.AccessibilityDelegate {
        b() {
        }

        @Override // android.view.View.AccessibilityDelegate
        public void sendAccessibilityEvent(View view, int i3) {
            if (i3 != 32) {
                super.sendAccessibilityEvent(view, i3);
            }
        }
    }

    private static void c(Context context, View view, List<c> list) {
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ypv);
        linearLayout.removeAllViews();
        for (c cVar : list) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.fwd, (ViewGroup) null);
            inflate.setBackgroundResource(e00.b.b() ? R.drawable.m6u : R.drawable.m6t);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.f125217lg);
            ImageView imageView2 = (ImageView) inflate.findViewById(R.id.f165939y53);
            TextView textView = (TextView) inflate.findViewById(R.id.f108866e_);
            imageView2.setImageDrawable(ba.l(cVar.f82461c));
            textView.setText(cVar.f82460b);
            if (cVar.f82462d) {
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
            inflate.setTag(cVar);
            linearLayout.addView(inflate);
        }
    }

    private static int e(Context context, int i3, boolean z16) {
        int g16 = (g(context, R.dimen.aub) * i3) + g(context, R.dimen.au_);
        return z16 ? g16 + ((i3 - 1) * 1) : g16;
    }

    public static int d(Context context, int i3) {
        int f16;
        int i16 = i3 - 2;
        if (i16 > 0) {
            f16 = (i16 * BaseAIOUtils.f(52.0f, context.getResources())) + (BaseAIOUtils.f(62.0f, context.getResources()) * 2);
        } else {
            f16 = BaseAIOUtils.f(62.0f, context.getResources()) * i3;
        }
        return f16 + g(context, R.dimen.au_);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
