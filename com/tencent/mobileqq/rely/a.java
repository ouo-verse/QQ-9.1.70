package com.tencent.mobileqq.rely;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Stack;

/* compiled from: P */
/* loaded from: classes17.dex */
public abstract class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    protected String f280849a;

    /* renamed from: b, reason: collision with root package name */
    protected final Stack<View>[] f280850b;

    /* renamed from: c, reason: collision with root package name */
    protected final int f280851c;

    /* renamed from: d, reason: collision with root package name */
    protected final b[] f280852d;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.rely.a$a, reason: collision with other inner class name */
    /* loaded from: classes17.dex */
    public static class C8502a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public View f280853a;

        /* renamed from: b, reason: collision with root package name */
        public b[] f280854b;

        public C8502a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f280855a;

        /* renamed from: b, reason: collision with root package name */
        public int f280856b;

        /* renamed from: c, reason: collision with root package name */
        public int f280857c;

        /* renamed from: d, reason: collision with root package name */
        public int f280858d;

        /* renamed from: e, reason: collision with root package name */
        public View f280859e;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            this.f280855a = -1;
            this.f280856b = -1;
            this.f280857c = 0;
            this.f280858d = 0;
            this.f280859e = null;
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return "[menuType = " + this.f280855a + ",menuId = " + this.f280856b + ",menuWidth = " + this.f280857c + ",menuHeight = " + this.f280858d + ",menuView = " + this.f280859e + "]";
        }
    }

    public a(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        this.f280849a = a.class.getSimpleName();
        this.f280851c = i3;
        if (i3 >= 0 && (i3 <= 0 || i16 >= 1)) {
            this.f280850b = new Stack[i16];
            for (int i17 = 0; i17 < i16; i17++) {
                this.f280850b[i17] = new Stack<>();
            }
            this.f280852d = new b[this.f280851c];
            for (int i18 = 0; i18 < this.f280851c; i18++) {
                this.f280852d[i18] = new b();
            }
            return;
        }
        throw new IllegalArgumentException("SwipRightMenuBuilder, menuTypeCount = " + i16);
    }

    public abstract View a(Context context, int i3);

    public View b(Context context, View view, C8502a c8502a, int i3) {
        View view2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (View) iPatchRedirector.redirect((short) 4, this, context, view, c8502a, Integer.valueOf(i3));
        }
        if (c8502a != null && view != null) {
            int i16 = this.f280851c;
            if (i16 > 0) {
                c8502a.f280854b = new b[i16];
                for (int i17 = 0; i17 < this.f280851c; i17++) {
                    c8502a.f280854b[i17] = new b();
                    b bVar = c8502a.f280854b[i17];
                    bVar.f280855a = -1;
                    bVar.f280857c = 0;
                    bVar.f280859e = null;
                }
                LinearLayout linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(0);
                linearLayout.addView(view, new LinearLayout.LayoutParams(i3, -2));
                view2 = linearLayout;
            } else {
                c8502a.f280854b = null;
                view2 = view;
            }
            c8502a.f280853a = view;
            return view2;
        }
        throw new NullPointerException("SwipRightMenuBuilder.createView holder is null or leftView is null");
    }

    public abstract void c(int i3, Object obj, b[] bVarArr);

    protected void d(b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bVar);
            return;
        }
        if (bVar == null) {
            return;
        }
        View view = bVar.f280859e;
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent != null) {
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(bVar.f280859e);
                } else {
                    throw new IllegalArgumentException("recycleMenuView, parent is not ViewGroup");
                }
            }
            synchronized (this.f280850b) {
                int i3 = bVar.f280855a;
                if (i3 >= 0) {
                    Stack<View>[] stackArr = this.f280850b;
                    if (i3 < stackArr.length) {
                        stackArr[i3].push(bVar.f280859e);
                    }
                }
            }
        }
        bVar.a();
    }

    public abstract View e(int i3, Object obj, b bVar, View.OnClickListener onClickListener);

    public int f(Context context, View view, int i3, Object obj, C8502a c8502a, View.OnClickListener onClickListener) {
        b[] bVarArr;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i16 = 1;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, this, context, view, Integer.valueOf(i3), obj, c8502a, onClickListener)).intValue();
        }
        if (!(view instanceof LinearLayout) || c8502a == null || (bVarArr = c8502a.f280854b) == null || bVarArr.length == 0 || bVarArr.length > this.f280851c) {
            return 0;
        }
        LinearLayout linearLayout = (LinearLayout) view;
        c(i3, obj, this.f280852d);
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        while (i17 < this.f280851c) {
            if (this.f280850b.length > i16) {
                b bVar = c8502a.f280854b[i17];
                if (bVar.f280855a != this.f280852d[i17].f280855a) {
                    d(bVar);
                }
            }
            b bVar2 = c8502a.f280854b[i17];
            b bVar3 = this.f280852d[i17];
            int i26 = bVar3.f280855a;
            bVar2.f280855a = i26;
            bVar2.f280856b = bVar3.f280856b;
            bVar2.f280857c = 0;
            bVar2.f280858d = -1;
            View view2 = bVar2.f280859e;
            if (i26 >= 0) {
                Stack<View>[] stackArr = this.f280850b;
                if (i26 < stackArr.length) {
                    if (view2 == null) {
                        synchronized (stackArr) {
                            if (!this.f280850b[i26].isEmpty()) {
                                view2 = this.f280850b[i26].pop();
                            }
                        }
                        if (view2 == null) {
                            view2 = a(context, i26);
                        }
                        if (view2 != null) {
                            c8502a.f280854b[i17].f280859e = view2;
                            z16 = true;
                        } else {
                            throw new NullPointerException("updateRightMenuView menuView is null");
                        }
                    } else {
                        z16 = false;
                    }
                    e(i3, obj, c8502a.f280854b[i17], onClickListener);
                    int i27 = c8502a.f280854b[i17].f280857c;
                    if (i27 >= 0) {
                        i18 += i27;
                        i19++;
                        view2.setVisibility(0);
                        if (z16) {
                            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view2.getLayoutParams();
                            if (layoutParams == null) {
                                b bVar4 = c8502a.f280854b[i17];
                                layoutParams = new LinearLayout.LayoutParams(bVar4.f280857c, bVar4.f280858d);
                                view2.setLayoutParams(layoutParams);
                            } else {
                                b bVar5 = c8502a.f280854b[i17];
                                layoutParams.width = bVar5.f280857c;
                                layoutParams.height = bVar5.f280858d;
                            }
                            layoutParams.gravity = 16;
                            linearLayout.addView(view2, i19);
                        }
                        i17++;
                        i16 = 1;
                    } else {
                        throw new IllegalArgumentException("updateRightMenuView, menuWidth = " + c8502a.f280854b[i17].f280857c);
                    }
                }
            }
            if (view2 != null) {
                view2.setVisibility(8);
                i19++;
            }
            i17++;
            i16 = 1;
        }
        view.setTag(-3, Integer.valueOf(i18));
        return i18;
    }
}
