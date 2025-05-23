package com.tencent.relation.common.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes25.dex */
public class InterestLabelMoreFlowLayout extends ViewGroup {
    static IPatchRedirector $redirector_;
    private int C;
    boolean D;
    public boolean E;
    public boolean F;
    public int G;
    protected int H;
    protected boolean I;
    private List<View> J;

    /* renamed from: d, reason: collision with root package name */
    private a f364779d;

    /* renamed from: e, reason: collision with root package name */
    private int f364780e;

    /* renamed from: f, reason: collision with root package name */
    private int f364781f;

    /* renamed from: h, reason: collision with root package name */
    private int f364782h;

    /* renamed from: i, reason: collision with root package name */
    private final List<a> f364783i;

    /* renamed from: m, reason: collision with root package name */
    private int f364784m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        int f364785a;

        /* renamed from: b, reason: collision with root package name */
        int f364786b;

        /* renamed from: c, reason: collision with root package name */
        List<View> f364787c;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) InterestLabelMoreFlowLayout.this);
                return;
            }
            this.f364785a = 0;
            this.f364786b = 0;
            this.f364787c = new ArrayList();
        }

        public void a(View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
                return;
            }
            this.f364787c.add(view);
            this.f364785a += view.getMeasuredWidth();
            int measuredHeight = view.getMeasuredHeight();
            int i3 = this.f364786b;
            if (i3 >= measuredHeight) {
                measuredHeight = i3;
            }
            this.f364786b = measuredHeight;
        }

        public int b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return this.f364787c.size();
        }

        public List<View> c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (List) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.f364787c;
        }

        public void d(int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Integer.valueOf(i16));
                return;
            }
            int b16 = b();
            int measuredWidth = (((InterestLabelMoreFlowLayout.this.getMeasuredWidth() - InterestLabelMoreFlowLayout.this.getPaddingLeft()) - InterestLabelMoreFlowLayout.this.getPaddingRight()) - this.f364785a) - (InterestLabelMoreFlowLayout.this.f364780e * (b16 - 1));
            if (measuredWidth >= 0) {
                for (int i17 = 0; i17 < b16; i17++) {
                    View view = this.f364787c.get(i17);
                    int measuredWidth2 = view.getMeasuredWidth();
                    int measuredHeight = view.getMeasuredHeight();
                    int i18 = (int) (((this.f364786b - measuredHeight) / 2.0d) + 0.5d);
                    if (i18 < 0) {
                        i18 = 0;
                    }
                    if (i17 == 0) {
                        int i19 = InterestLabelMoreFlowLayout.this.f364784m;
                        if (i19 != 0) {
                            if (i19 != 2) {
                                i3 = 0;
                            } else {
                                i3 += measuredWidth / 2;
                            }
                        } else {
                            i3 += measuredWidth;
                        }
                    }
                    int i26 = i18 + i16;
                    view.layout(i3, i26, i3 + measuredWidth2, measuredHeight + i26);
                    i3 += measuredWidth2 + InterestLabelMoreFlowLayout.this.f364781f;
                }
            }
        }
    }

    public InterestLabelMoreFlowLayout(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private void d() {
        boolean z16;
        int size = this.f364783i.size();
        if (size > 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.F = z16;
        if (!this.E && size > 1) {
            for (int i3 = size - 1; i3 >= 1; i3--) {
                this.f364783i.remove(i3);
            }
        }
        int i16 = this.H;
        if (i16 != -1 && size <= i16 && size > 0) {
            int size2 = this.f364783i.size() - 1;
            List<View> list = this.f364783i.get(size2).f364787c;
            list.remove(list.size() - 1);
            if (this.f364783i.get(size2).f364787c.size() == 0) {
                this.f364783i.remove(size2);
            }
        }
        int i17 = this.H;
        if (i17 != -1 && size > i17 && !this.I) {
            for (int i18 = size - 1; i18 >= this.H; i18--) {
                this.f364783i.remove(i18);
            }
        }
        e();
    }

    private int f(int i3) {
        for (int i16 = this.H - 2; i16 >= 0; i16--) {
            i3 += this.f364783i.get(i16).f364787c.size();
        }
        return i3;
    }

    private void g(int i3, int i16, int i17, int i18, boolean z16) {
        View view;
        int i19;
        if (z16) {
            this.J.clear();
        }
        int childCount = getChildCount();
        for (int i26 = 0; i26 < childCount; i26++) {
            if (z16) {
                view = getChildAt(i26);
            } else {
                view = this.J.get(i26);
            }
            if (view.getVisibility() != 8) {
                if (z16) {
                    this.J.add(view);
                }
                int i27 = Integer.MIN_VALUE;
                if (i17 == 1073741824) {
                    i19 = Integer.MIN_VALUE;
                } else {
                    i19 = i17;
                }
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i3, i19);
                if (i18 != 1073741824) {
                    i27 = i18;
                }
                view.measure(makeMeasureSpec, View.MeasureSpec.makeMeasureSpec(i16, i27));
                if (this.f364779d == null) {
                    this.f364779d = new a();
                }
                int measuredWidth = view.getMeasuredWidth();
                int i28 = this.f364782h + measuredWidth;
                this.f364782h = i28;
                if (i28 <= i3) {
                    this.f364779d.a(view);
                    int i29 = this.f364782h + this.f364780e;
                    this.f364782h = i29;
                    if (i29 >= i3) {
                        if (this.f364783i.size() == 0) {
                            this.G = this.f364782h - this.f364780e;
                        }
                        if (!h()) {
                            break;
                        }
                    } else {
                        continue;
                    }
                } else if (this.f364779d.b() == 0) {
                    this.f364779d.a(view);
                    if (this.f364783i.size() == 0) {
                        this.G = (this.f364782h - measuredWidth) - this.f364780e;
                    }
                    if (!h()) {
                        break;
                    }
                } else {
                    if (this.f364783i.size() == 0) {
                        this.G = (this.f364782h - measuredWidth) - this.f364780e;
                    }
                    if (!h()) {
                        break;
                    }
                    this.f364779d.a(view);
                    this.f364782h += measuredWidth + this.f364780e;
                }
            }
        }
        a aVar = this.f364779d;
        if (aVar != null && aVar.b() > 0 && !this.f364783i.contains(this.f364779d)) {
            this.f364783i.add(this.f364779d);
        }
    }

    private boolean h() {
        this.f364783i.add(this.f364779d);
        if (this.f364783i.size() >= this.C) {
            return false;
        }
        this.f364779d = new a();
        this.f364782h = 0;
        return true;
    }

    private void i(int i3, int i16, int i17, int i18) {
        int i19;
        int size = this.f364783i.size();
        View childAt = getChildAt(getChildCount() - 1);
        int i26 = this.H;
        if (size > i26) {
            a aVar = this.f364783i.get(i26 - 1);
            List<View> c16 = aVar.c();
            int size2 = c16.size();
            int i27 = size2 - 1;
            int i28 = i27;
            while (true) {
                i19 = 0;
                if (i28 < 0) {
                    break;
                }
                View view = c16.get(i28);
                int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
                int measuredWidth2 = childAt.getMeasuredWidth();
                int i29 = this.f364780e;
                if (measuredWidth2 + (i29 * i27) + i29 + aVar.f364785a < measuredWidth) {
                    i19 = f(0 + size2);
                    break;
                } else {
                    if (childAt.getMeasuredWidth() <= view.getMeasuredWidth()) {
                        i19 = f(i28 + 0);
                        break;
                    }
                    i28--;
                }
            }
            this.J.add(i19, childAt);
            k();
            g(i3, i16, i17, i18, false);
        }
    }

    private void j() {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.relation.common.widget.InterestLabelMoreFlowLayout.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) InterestLabelMoreFlowLayout.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    InterestLabelMoreFlowLayout.this.requestLayout();
                }
            }
        });
    }

    private void k() {
        this.f364783i.clear();
        this.f364779d = new a();
        this.f364782h = 0;
    }

    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int size = this.f364783i.size();
        for (int i19 = 0; i19 < size; i19++) {
            a aVar = this.f364783i.get(i19);
            aVar.d(paddingLeft, paddingTop);
            paddingTop += aVar.f364786b + this.f364781f;
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        int size = (View.MeasureSpec.getSize(i3) - getPaddingRight()) - getPaddingLeft();
        int size2 = (View.MeasureSpec.getSize(i16) - getPaddingTop()) - getPaddingBottom();
        int mode = View.MeasureSpec.getMode(i3);
        int mode2 = View.MeasureSpec.getMode(i16);
        k();
        g(size, size2, mode, mode2, true);
        if (this.H != -1 && this.f364783i.size() > this.H) {
            i(size, size2, mode, mode2);
        }
        d();
        int size3 = View.MeasureSpec.getSize(i3);
        int size4 = this.f364783i.size();
        int i17 = 0;
        for (int i18 = 0; i18 < size4; i18++) {
            i17 += this.f364783i.get(i18).f364786b;
        }
        setMeasuredDimension(size3, View.resolveSize(i17 + (this.f364781f * (size4 - 1)) + getPaddingTop() + getPaddingBottom(), i16));
    }

    public void setAlignByCenter(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
        } else {
            this.f364784m = i3;
            j();
        }
    }

    public void setArrowLocationLineNum(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
        } else {
            this.H = i3;
        }
    }

    public void setHorizontalSpacing(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
        } else if (this.f364780e != i3) {
            this.f364780e = i3;
            j();
        }
    }

    public void setVerticalSpacing(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
        } else if (this.f364781f != i3) {
            this.f364781f = i3;
            j();
        }
    }

    public InterestLabelMoreFlowLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public InterestLabelMoreFlowLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.f364779d = null;
        this.f364780e = 20;
        this.f364781f = 20;
        this.f364782h = 0;
        this.f364783i = new ArrayList();
        this.f364784m = 2;
        this.C = Integer.MAX_VALUE;
        this.D = true;
        this.E = true;
        this.F = true;
        this.G = 0;
        this.H = -1;
        this.I = false;
        this.J = new ArrayList();
    }
}
