package com.tencent.luggage.wxa.g6;

import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.luggage.ui.presenter.UIContainerPageBase;
import com.tencent.mm.ui.BaseActivity;
import com.tencent.mobileqq.R;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class i extends UIContainerPageBase {
    public ViewGroup G;
    public View H;
    public TextView I;
    public View J;
    public BaseActivity.h K;
    public int L;
    public ImageView M;
    public boolean N;
    public int O;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements MenuItem.OnMenuItemClickListener {
        public a() {
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public final boolean onMenuItemClick(MenuItem it) {
            Intrinsics.checkNotNullParameter(it, "it");
            i.this.finish();
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MenuItem.OnMenuItemClickListener f126551a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ i f126552b;

        public b(MenuItem.OnMenuItemClickListener onMenuItemClickListener, i iVar) {
            this.f126551a = onMenuItemClickListener;
            this.f126552b = iVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.f126551a.onMenuItemClick(new com.tencent.luggage.wxa.mo.i(this.f126552b.getContext(), 0, 0));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(g container) {
        super(container);
        Intrinsics.checkNotNullParameter(container, "container");
        this.K = BaseActivity.h.BACK;
        View inflate = LayoutInflater.from(this).inflate(R.layout.fdu, (ViewGroup) null);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.view.ViewGroup");
        this.G = (ViewGroup) inflate;
    }

    public final void b(boolean z16) {
        ImageView imageView = this.M;
        if (imageView == null) {
            return;
        }
        if (z16) {
            Intrinsics.checkNotNull(imageView);
            imageView.setVisibility(0);
        } else {
            Intrinsics.checkNotNull(imageView);
            imageView.setVisibility(8);
        }
    }

    @Override // com.tencent.luggage.wxa.g6.u
    public ViewGroup c() {
        ViewGroup viewGroup = this.G;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            return null;
        }
        return viewGroup;
    }

    public final void f() {
        if (this.N) {
            ImageView imageView = this.M;
            Intrinsics.checkNotNull(imageView);
            imageView.setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
        } else {
            ImageView imageView2 = this.M;
            Intrinsics.checkNotNull(imageView2);
            imageView2.setColorFilter(-16777216, PorterDuff.Mode.SRC_ATOP);
        }
    }

    public final void g() {
        TextView textView = this.I;
        if (textView == null) {
            return;
        }
        textView.setTextColor(getContext().getResources().getColor(R.color.b3s));
    }

    @Override // com.tencent.luggage.wxa.g6.t
    public void hideActionbarLine() {
        View view = this.H;
        if (view != null) {
            Intrinsics.checkNotNull(view);
            view.setElevation(0.0f);
        }
    }

    @Override // com.tencent.luggage.wxa.g6.t
    public void setBackBtn(MenuItem.OnMenuItemClickListener onMenuItemClickListener, int i3, BaseActivity.h style) {
        Intrinsics.checkNotNullParameter(style, "style");
        if (onMenuItemClickListener == null) {
            View view = this.J;
            Intrinsics.checkNotNull(view);
            view.setVisibility(8);
        } else {
            View view2 = this.J;
            Intrinsics.checkNotNull(view2);
            view2.setVisibility(0);
            View view3 = this.J;
            Intrinsics.checkNotNull(view3);
            view3.setOnClickListener(new b(onMenuItemClickListener, this));
        }
        this.K = style;
        if (i3 != 0) {
            this.L = i3;
        }
        if (style == BaseActivity.h.NONE) {
            this.L = 0;
        }
        if (style == BaseActivity.h.BACK) {
            this.L = R.drawable.ofm;
        } else if (style == BaseActivity.h.CLOSE) {
            this.L = R.drawable.ofo;
        }
        if (this.M != null && this.L != 0) {
            b(true);
            ImageView imageView = this.M;
            Intrinsics.checkNotNull(imageView);
            imageView.setImageResource(this.L);
        }
        f();
    }

    @Override // com.tencent.luggage.wxa.g6.t
    public void setTitle(int i3) {
        String string = getContext().getResources().getString(i3);
        Intrinsics.checkNotNullExpressionValue(string, "context.resources.getString(titleId)");
        setTitle(string);
    }

    @Override // com.tencent.luggage.wxa.g6.t
    public void showActionbarLine() {
        View view = this.H;
        if (view != null) {
            Intrinsics.checkNotNull(view);
            view.setElevation(1.0f);
        }
    }

    @Override // com.tencent.luggage.wxa.g6.t
    public void setTitle(CharSequence titie) {
        Intrinsics.checkNotNullParameter(titie, "titie");
        TextView textView = this.I;
        Intrinsics.checkNotNull(textView);
        textView.setText(titie.toString());
        g();
    }

    @Override // com.tencent.luggage.ui.presenter.UIContainerPageBase, com.tencent.luggage.wxa.g6.u
    public void b() {
        this.H = findViewById(R.id.jo9);
        this.I = (TextView) findViewById(android.R.id.text1);
        this.J = findViewById(R.id.s_y);
        this.M = (ImageView) findViewById(R.id.s_z);
        if (this.O == 0) {
            this.O = com.tencent.luggage.wxa.lo.o.b(getContext(), R.attr.f50485);
        }
        this.N = com.tencent.luggage.wxa.lo.m.a(this.O);
        setBackBtn(new a());
        super.b();
    }
}
