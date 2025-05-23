package com.tencent.av.ui.part.base;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.m;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LiuHaiUtils;
import com.tencent.widget.immersive.ImmersiveUtils;

/* compiled from: P */
/* loaded from: classes32.dex */
public class i extends nw.a {

    /* renamed from: e, reason: collision with root package name */
    private RelativeLayout f76305e = null;

    /* renamed from: f, reason: collision with root package name */
    private RelativeLayout f76306f = null;

    /* renamed from: h, reason: collision with root package name */
    protected View f76307h;

    /* renamed from: i, reason: collision with root package name */
    private a f76308i;

    public int A9(Context context) {
        a aVar = this.f76308i;
        if (aVar == null || !aVar.b() || context == null) {
            return 0;
        }
        return ImmersiveUtils.getStatusBarHeight(context);
    }

    public int B9() {
        View view = this.f76307h;
        if (view == null || !(view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            return 0;
        }
        return ((ViewGroup.MarginLayoutParams) this.f76307h.getLayoutParams()).topMargin;
    }

    public void C9(boolean z16) {
        a aVar = this.f76308i;
        if (aVar != null) {
            aVar.c(z16);
        }
    }

    public void D9(Context context, int i3, boolean z16) {
        if (this.f76307h != null) {
            if (com.tencent.av.utils.e.e(0) == 1) {
                this.f76307h.setBackgroundColor(2147460352);
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f76307h.getLayoutParams();
            if (layoutParams != null) {
                if (!z16) {
                    layoutParams.topMargin = (i3 - A9(context)) + BaseAIOUtils.f(15.0f, context.getResources());
                    if (LiuHaiUtils.isLiuHaiUseValid()) {
                        layoutParams.topMargin += LiuHaiUtils.getNotchInScreenHeight((AVActivity) context);
                    }
                } else {
                    layoutParams.topMargin = BaseAIOUtils.f(15.0f, context.getResources());
                }
                this.f76307h.setLayoutParams(layoutParams);
            }
        }
    }

    public void E9(int i3) {
        View view = this.f76307h;
        if (view != null) {
            view.setVisibility(i3);
        }
    }

    @Override // nw.a, com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        this.f76307h = view.findViewById(m.d.f76004b);
        if (com.tencent.av.utils.e.e(0) == 1) {
            this.f76305e = (RelativeLayout) view.findViewById(m.d.f76006d);
            this.f76306f = (RelativeLayout) view.getRootView().findViewById(m.d.f76007e);
            this.f76305e.setBackgroundColor(2147475117);
            this.f76306f.setBackgroundColor(2147475117);
            this.f76307h.setBackgroundColor(2145838842);
        }
        a aVar = new a(view);
        this.f76308i = aVar;
        aVar.a(view.getContext());
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        onDestroy();
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        View f76309a;

        /* renamed from: b, reason: collision with root package name */
        View f76310b;

        a(View view) {
            this.f76309a = view.findViewById(m.d.f76008f);
            this.f76310b = view.getRootView().findViewById(m.d.f76009g);
        }

        public boolean b() {
            View view = this.f76309a;
            return view != null && view.getVisibility() == 0;
        }

        void c(boolean z16) {
            if (this.f76309a != null) {
                QLog.w("QavStatusBar", 1, "setBackgroundColor, bDoubleScreen[" + z16 + "]");
                if (z16) {
                    this.f76309a.setBackgroundColor(-16777216);
                } else {
                    this.f76309a.setBackgroundColor(0);
                }
            }
        }

        void a(Context context) {
            if (context == null || this.f76309a == null) {
                return;
            }
            if (ImmersiveUtils.isSupporImmersive() != 1) {
                this.f76309a.setVisibility(8);
                View view = this.f76310b;
                if (view != null) {
                    view.setVisibility(8);
                    return;
                }
                return;
            }
            int statusBarHeight = ImmersiveUtils.getStatusBarHeight(context);
            QLog.w("QavStatusBar", 1, "adjust, height[" + statusBarHeight + "]");
            if (statusBarHeight > 0) {
                d(this.f76309a, statusBarHeight);
                d(this.f76310b, statusBarHeight);
            }
            if (com.tencent.av.utils.e.e(0) == 1) {
                this.f76309a.setBackgroundColor(2140405971);
                View view2 = this.f76310b;
                if (view2 != null) {
                    view2.setBackgroundColor(2140405971);
                }
            }
        }

        static void d(View view, int i3) {
            if (view == null) {
                return;
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
            layoutParams.height = i3;
            view.setLayoutParams(layoutParams);
        }
    }

    @Override // nw.a
    public void onDestroy() {
        this.f76305e = null;
        this.f76306f = null;
        this.f76307h = null;
        this.f76308i = null;
    }
}
