package com.tencent.mobileqq.search.rich;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.ark.ArkViewModel;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.item.ArkAppRootLayout;
import com.tencent.mobileqq.search.rich.ArkAppView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes18.dex */
public class c extends o implements ArkAppView.a {
    private LinearLayout C;
    private boolean D;
    private boolean E;
    private WeakReference<e> F;
    private int G;

    /* renamed from: i, reason: collision with root package name */
    private View f283751i;

    /* renamed from: m, reason: collision with root package name */
    private ArkAppView f283752m;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ArkViewModel arkViewModel;
            EventCollector.getInstance().onViewClickedBefore(view);
            if (c.this.f283752m != null) {
                arkViewModel = c.this.f283752m.mViewImpl.getViewModel();
            } else {
                arkViewModel = null;
            }
            if (arkViewModel != null) {
                arkViewModel.reinitArkContainer();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public c(f fVar, Context context) {
        super(fVar, context);
        this.D = true;
        this.E = false;
    }

    @Override // com.tencent.mobileqq.search.rich.o
    public View n(Context context) {
        int i3;
        View inflate = LayoutInflater.from(context).inflate(R.layout.b1p, (ViewGroup) null, false);
        this.f283751i = inflate;
        this.f283752m = (ArkAppView) inflate.findViewById(R.id.f164461yk);
        this.C = null;
        if (this.f283751i.getMeasuredWidth() != 0) {
            i3 = this.f283751i.getMeasuredWidth();
        } else {
            i3 = this.f283751i.getResources().getDisplayMetrics().widthPixels;
        }
        this.G = i3;
        ((ArkAppRootLayout) inflate).setDisableParentReturn(false);
        return this.f283751i;
    }

    @Override // com.tencent.mobileqq.search.rich.o
    public void o() {
        this.f283751i = null;
        ArkAppView arkAppView = this.f283752m;
        if (arkAppView != null) {
            arkAppView.d();
            this.f283752m = null;
        }
        this.C = null;
        super.o();
    }

    @Override // com.tencent.mobileqq.search.rich.ArkAppView.a
    public void onLoadFailed(String str, int i3, boolean z16) {
        int i16;
        this.E = true;
        r(1);
        LinearLayout linearLayout = this.C;
        if (linearLayout == null) {
            return;
        }
        if (this.D) {
            if (QLog.isColorLevel()) {
                QLog.d("ArkNodeView", 2, "onLoadFailed, show no result");
            }
            this.f283751i.setVisibility(8);
            p(false);
            return;
        }
        linearLayout.setVisibility(0);
        if (z16) {
            this.C.setOnClickListener(new a());
        } else {
            this.C.setOnClickListener(null);
        }
        TextView textView = (TextView) this.C.findViewById(R.id.i5p);
        if (textView != null) {
            if (str == null) {
                textView.setText(this.C.getContext().getResources().getString(R.string.f170470s5));
            } else {
                textView.setText(str);
            }
        }
        View findViewById = this.C.findViewById(R.id.i5l);
        if (findViewById != null) {
            if (z16) {
                i16 = R.drawable.c_j;
            } else {
                i16 = R.drawable.c_i;
            }
            findViewById.setBackgroundDrawable(findViewById.getResources().getDrawable(i16));
        }
    }

    @Override // com.tencent.mobileqq.search.rich.ArkAppView.a
    public void onLoadSuccess() {
        this.E = false;
        r(1);
        View view = this.f283751i;
        if (view != null) {
            view.setVisibility(0);
        }
        LinearLayout linearLayout = this.C;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
    }

    @Override // com.tencent.mobileqq.search.rich.ArkAppView.a
    public void onLoading() {
        LinearLayout linearLayout = this.C;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
        }
    }

    @Override // com.tencent.mobileqq.search.rich.o
    public void p(boolean z16) {
        if (z16 && this.E && this.D) {
            z16 = false;
        }
        super.p(z16);
    }

    public void r(int i3) {
        e eVar;
        WeakReference<e> weakReference = this.F;
        if (weakReference == null || (eVar = weakReference.get()) == null) {
            return;
        }
        eVar.a(i3);
    }

    public View s() {
        return this.f283752m;
    }

    public void t(ArkNodeContainer arkNodeContainer) {
        if (this.f283752m != null && arkNodeContainer != null) {
            arkNodeContainer.setMaxSize(this.G, -1);
            arkNodeContainer.setMinSize(this.G, -1);
            this.f283752m.c(arkNodeContainer, this);
        }
    }

    public void u(e eVar) {
        this.F = new WeakReference<>(eVar);
    }

    @Override // com.tencent.mobileqq.search.rich.h
    public void update() {
        int i3;
        if (this.f283751i == null) {
            return;
        }
        d dVar = (d) i();
        if (this.f283751i.getMeasuredWidth() != 0) {
            i3 = this.f283751i.getMeasuredWidth();
        } else {
            i3 = this.f283751i.getResources().getDisplayMetrics().widthPixels;
        }
        if (this.G != i3) {
            ArkNodeContainer l3 = dVar.l();
            l3.setMaxSize(i3, -1);
            l3.setMinSize(i3, -1);
            l3.attachView(this.f283752m.mViewImpl);
            this.G = i3;
        }
    }

    @Override // com.tencent.mobileqq.search.rich.ArkAppView.a
    public void onFirstFrame() {
    }
}
