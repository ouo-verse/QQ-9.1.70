package com.gyf.immersionbar;

import android.R;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes2.dex */
public class f implements ViewTreeObserver.OnGlobalLayoutListener {
    private int C;
    private int D;
    private int E;
    private int F;
    private boolean G;

    /* renamed from: d, reason: collision with root package name */
    private ImmersionBar f36037d;

    /* renamed from: e, reason: collision with root package name */
    private Window f36038e;

    /* renamed from: f, reason: collision with root package name */
    private View f36039f;

    /* renamed from: h, reason: collision with root package name */
    private View f36040h;

    /* renamed from: i, reason: collision with root package name */
    private View f36041i;

    /* renamed from: m, reason: collision with root package name */
    private int f36042m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v5, types: [android.view.View] */
    public f(ImmersionBar immersionBar) {
        this.f36042m = 0;
        this.C = 0;
        this.D = 0;
        this.E = 0;
        this.f36037d = immersionBar;
        Window D = immersionBar.D();
        this.f36038e = D;
        View decorView = D.getDecorView();
        this.f36039f = decorView;
        FrameLayout frameLayout = (FrameLayout) decorView.findViewById(R.id.content);
        if (immersionBar.M()) {
            Fragment C = immersionBar.C();
            if (C != null) {
                this.f36041i = C.getView();
            } else {
                android.app.Fragment v3 = immersionBar.v();
                if (v3 != null) {
                    this.f36041i = v3.getView();
                }
            }
        } else {
            View childAt = frameLayout.getChildAt(0);
            this.f36041i = childAt;
            if (childAt != null && (childAt instanceof DrawerLayout)) {
                this.f36041i = ((DrawerLayout) childAt).getChildAt(0);
            }
        }
        View view = this.f36041i;
        if (view != null) {
            this.f36042m = view.getPaddingLeft();
            this.C = this.f36041i.getPaddingTop();
            this.D = this.f36041i.getPaddingRight();
            this.E = this.f36041i.getPaddingBottom();
        }
        ?? r46 = this.f36041i;
        this.f36040h = r46 != 0 ? r46 : frameLayout;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        if (this.G) {
            this.f36039f.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            this.G = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        if (this.G) {
            if (this.f36041i != null) {
                this.f36040h.setPadding(this.f36042m, this.C, this.D, this.E);
            } else {
                this.f36040h.setPadding(this.f36037d.x(), this.f36037d.z(), this.f36037d.y(), this.f36037d.w());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(int i3) {
        this.f36038e.setSoftInputMode(i3);
        if (!this.G) {
            this.f36039f.getViewTreeObserver().addOnGlobalLayoutListener(this);
            this.G = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d() {
        this.F = 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x00b9, code lost:
    
        if ((r3 - r1) > r1) goto L34;
     */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onGlobalLayout() {
        int g16;
        ImmersionBar immersionBar = this.f36037d;
        if (immersionBar != null && immersionBar.u() != null && this.f36037d.u().f36018c0) {
            a t16 = this.f36037d.t();
            if (t16.m()) {
                g16 = t16.d();
            } else {
                g16 = t16.g();
            }
            Rect rect = new Rect();
            this.f36039f.getWindowVisibleDisplayFrame(rect);
            int height = this.f36040h.getHeight() - rect.bottom;
            if (height != this.F) {
                this.F = height;
                int i3 = 0;
                int i16 = 1;
                if (!ImmersionBar.g(this.f36038e.getDecorView().findViewById(R.id.content))) {
                    if (this.f36041i != null) {
                        if (this.f36037d.u().f36017b0) {
                            height += this.f36037d.r() + t16.j();
                        }
                        if (this.f36037d.u().V) {
                            height += t16.j();
                        }
                        if (height > g16) {
                            i3 = height + this.E;
                        } else {
                            i16 = 0;
                        }
                        this.f36040h.setPadding(this.f36042m, this.C, this.D, i3);
                        i3 = i16;
                        this.f36037d.u().getClass();
                        if (i3 == 0 && this.f36037d.u().F != BarHide.FLAG_SHOW_BAR) {
                            this.f36037d.U();
                        }
                        if (i3 != 0) {
                            this.f36037d.l();
                            return;
                        }
                        return;
                    }
                    int w3 = this.f36037d.w();
                    int i17 = height - g16;
                    if (i17 > g16) {
                        w3 = i17 + g16;
                        i3 = 1;
                    }
                    this.f36040h.setPadding(this.f36037d.x(), this.f36037d.z(), this.f36037d.y(), w3);
                    this.f36037d.u().getClass();
                    if (i3 == 0) {
                        this.f36037d.U();
                    }
                    if (i3 != 0) {
                    }
                }
            }
        }
    }
}
