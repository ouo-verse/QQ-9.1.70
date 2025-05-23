package com.tencent.mobileqq.wink.view;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.util.Supplier;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.wink.editor.WinkEditorViewModel;
import com.tencent.mobileqq.wink.editor.view.WinkDownLoadingView;
import com.tencent.mobileqq.wink.flow.ApplyMaterialTask;
import com.tencent.mobileqq.wink.reddot.WinkMaterialRedDotManager;
import com.tencent.mobileqq.wink.utils.ViewUtilsKt;
import com.tencent.mobileqq.wink.view.AbsWinkMaterialPanelContentAdapter;
import com.tencent.mobileqq.wink.view.ab;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes21.dex */
public abstract class ab extends AbsWinkMaterialPanelContentAdapter {
    private final int L;
    private int M;
    private final int N;
    private final int P;
    private final int Q;
    public boolean R;
    public boolean S;

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public static class a extends RecyclerView.ViewHolder {
        public TextView C;
        public ImageView D;
        public ImageView E;
        public LinearLayout F;
        public ImageView G;

        /* renamed from: d, reason: collision with root package name */
        public CardView f326922d;

        /* renamed from: e, reason: collision with root package name */
        public ImageView f326923e;

        /* renamed from: f, reason: collision with root package name */
        public ImageView f326924f;

        /* renamed from: h, reason: collision with root package name */
        public ImageView f326925h;

        /* renamed from: i, reason: collision with root package name */
        public ImageView f326926i;

        /* renamed from: m, reason: collision with root package name */
        public WinkDownLoadingView f326927m;

        public a(View view) {
            super(view);
            d();
        }

        private void c(int i3, int i16, int i17) {
            WinkDownLoadingView winkDownLoadingView = this.f326927m;
            if (winkDownLoadingView == null) {
                return;
            }
            winkDownLoadingView.setBgCorner(i17 / 2.0f);
            this.f326927m.setMinimumHeight(i17);
            this.f326927m.setMinimumWidth(i17);
            this.f326927m.setProgressSizeAndMode(i3, i16, false);
            this.f326927m.setBgColor(0);
            this.f326927m.setProgressColor(-1);
            this.f326927m.b(false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void e(MetaMaterial metaMaterial, Supplier supplier, AbsWinkMaterialPanelContentAdapter.c cVar, int i3, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (!FastClickUtils.isFastDoubleClick("MaterialPanelContentAdapter", 500L)) {
                if (metaMaterial.hasRedDot) {
                    metaMaterial.hasRedDot = false;
                    WinkMaterialRedDotManager.f326249a.c(metaMaterial.f30533id);
                    l(Boolean.FALSE);
                }
                if (((Boolean) supplier.get()).booleanValue()) {
                    cVar.b(i3, metaMaterial);
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }

        private void j(boolean z16) {
            int i3;
            ImageView imageView = this.f326926i;
            if (z16) {
                i3 = 0;
            } else {
                i3 = 4;
            }
            imageView.setVisibility(i3);
        }

        private void k(boolean z16, int i3) {
            if (z16) {
                this.f326925h.setVisibility(0);
                this.f326927m.setVisibility(0);
                this.f326927m.setProgress(i3);
                j(false);
                return;
            }
            this.f326925h.setVisibility(4);
            this.f326927m.setVisibility(4);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void d() {
            this.f326922d = (CardView) this.itemView.findViewById(R.id.f164726tm1);
            this.f326923e = (ImageView) this.itemView.findViewById(R.id.y9u);
            this.f326924f = (ImageView) this.itemView.findViewById(R.id.y8z);
            this.f326925h = (ImageView) this.itemView.findViewById(R.id.y5f);
            this.f326926i = (ImageView) this.itemView.findViewById(R.id.y2f);
            this.f326927m = (WinkDownLoadingView) this.itemView.findViewById(R.id.g2d);
            this.C = (TextView) this.itemView.findViewById(R.id.tv_name);
            this.D = (ImageView) this.itemView.findViewById(R.id.f72103py);
            this.E = (ImageView) this.itemView.findViewById(R.id.y9_);
            this.F = (LinearLayout) this.itemView.findViewById(R.id.f166092yo0);
            this.G = (ImageView) this.itemView.findViewById(R.id.f165963y83);
        }

        public void f(final MetaMaterial metaMaterial, final int i3, int i16, WinkEditorViewModel.EditMode editMode, boolean z16, final Supplier<Boolean> supplier, final AbsWinkMaterialPanelContentAdapter.c cVar) {
            boolean z17;
            int i17;
            int i18;
            boolean z18 = true;
            if (i16 == i3) {
                z17 = true;
            } else {
                z17 = false;
            }
            ImageView imageView = this.f326924f;
            if (z17) {
                i17 = 0;
            } else {
                i17 = 4;
            }
            imageView.setVisibility(i17);
            if (metaMaterial != null) {
                if (com.tencent.mobileqq.wink.editor.c.c1(metaMaterial)) {
                    if (this.itemView.getVisibility() != 4) {
                        this.itemView.setVisibility(4);
                        return;
                    }
                    return;
                } else if (this.itemView.getVisibility() != 0) {
                    this.itemView.setVisibility(0);
                }
            }
            if (metaMaterial == null) {
                return;
            }
            if (TextUtils.isEmpty(metaMaterial.thumbUrl)) {
                this.f326923e.setVisibility(0);
                this.f326923e.setScaleType(ImageView.ScaleType.CENTER_CROP);
            } else if (metaMaterial.thumbUrl.startsWith("http")) {
                this.f326923e.setVisibility(0);
                this.f326923e.setScaleType(ImageView.ScaleType.CENTER_CROP);
                ViewUtilsKt.l(this.f326923e, metaMaterial.thumbUrl, metaMaterial, editMode, null);
            } else {
                this.f326923e.setVisibility(0);
                this.f326923e.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                int J0 = com.tencent.mobileqq.wink.editor.c.J0(metaMaterial);
                if (J0 == 0) {
                    ViewUtilsKt.j(this.f326923e, metaMaterial.thumbUrl);
                } else {
                    this.f326923e.setImageResource(J0);
                }
            }
            if (com.tencent.mobileqq.wink.editor.c.I0(metaMaterial) != -1) {
                this.f326922d.setCardBackgroundColor(com.tencent.mobileqq.wink.editor.c.I0(metaMaterial));
            }
            TextView textView = this.C;
            if (textView != null) {
                textView.setText(com.tencent.mobileqq.wink.editor.c.a0(metaMaterial));
                TextView textView2 = this.C;
                Resources resources = this.itemView.getContext().getResources();
                if (z17) {
                    i18 = R.color.bfp;
                } else {
                    i18 = R.color.bfq;
                }
                textView2.setTextColor(resources.getColor(i18));
            }
            if (z17) {
                k(false, -1);
                j(false);
            } else if (com.tencent.mobileqq.wink.editor.c.d1(metaMaterial)) {
                int x16 = com.tencent.mobileqq.wink.editor.c.x(metaMaterial);
                if (x16 != -1 && x16 != 100) {
                    k(true, x16);
                } else {
                    k(false, x16);
                    if (x16 != -1 || z16 || !com.tencent.mobileqq.wink.editor.c.u(metaMaterial)) {
                        z18 = false;
                    }
                    j(z18);
                }
            }
            this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.view.aa
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ab.a.this.e(metaMaterial, supplier, cVar, i3, view);
                }
            });
        }

        public void g() {
            h(com.tencent.mobileqq.util.x.c(this.itemView.getContext(), 6.0f), com.tencent.mobileqq.util.x.c(this.itemView.getContext(), 2.0f), com.tencent.mobileqq.util.x.c(this.itemView.getContext(), 16.0f));
        }

        public void h(int i3, int i16, int i17) {
            c(i3, i16, i17);
        }

        public void i(int i3, int i16, int i17, int i18, int i19, int i26) {
            if (i3 == 1) {
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) this.itemView.getLayoutParams();
                if (i16 == 0) {
                    ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = i17;
                } else if (i16 == 2) {
                    ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = i17;
                }
            }
            c(i18, i19, i26);
        }

        public void l(Boolean bool) {
            int i3;
            ImageView imageView = this.D;
            if (bool.booleanValue()) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            imageView.setVisibility(i3);
        }
    }

    public ab(@NonNull Context context, WinkEditorViewModel.EditMode editMode) {
        this(context, editMode, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Boolean l0() {
        return Boolean.valueOf(!this.D);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m0(int i3, MetaMaterial metaMaterial) {
        this.R = true;
        AbsWinkMaterialPanelContentAdapter.d dVar = this.H;
        if (dVar != null) {
            dVar.b(i3, metaMaterial);
        }
        F(i3, metaMaterial);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        if (i3 == 0) {
            return 0;
        }
        if (B() == null || i3 != B().size() - 1) {
            return 1;
        }
        return 2;
    }

    protected abstract a o0(ViewGroup viewGroup, int i3);

    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: p0, reason: merged with bridge method [inline-methods] */
    public final a onCreateViewHolder(ViewGroup viewGroup, int i3) {
        a o06 = o0(viewGroup, i3);
        o06.i(this.L, i3, this.M, this.N, this.P, this.Q);
        return o06;
    }

    public void q0(int i3) {
        this.M = i3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.wink.view.AbsWinkMaterialPanelContentAdapter
    public <T extends RecyclerView.ViewHolder> void x(T t16, int i3, @NonNull MetaMaterial metaMaterial) {
        boolean z16;
        ApplyMaterialTask applyMaterialTask;
        if (t16 instanceof a) {
            if (com.tencent.mobileqq.wink.editor.c.u(metaMaterial) && (applyMaterialTask = this.G) != null && applyMaterialTask.z(i3, metaMaterial)) {
                z16 = true;
            } else {
                z16 = false;
            }
            a aVar = (a) t16;
            aVar.f(metaMaterial, i3, this.f326745h, this.F, z16, new Supplier() { // from class: com.tencent.mobileqq.wink.view.y
                @Override // androidx.core.util.Supplier
                public final Object get() {
                    Boolean l06;
                    l06 = ab.this.l0();
                    return l06;
                }
            }, new AbsWinkMaterialPanelContentAdapter.c() { // from class: com.tencent.mobileqq.wink.view.z
                @Override // com.tencent.mobileqq.wink.view.AbsWinkMaterialPanelContentAdapter.c
                public final void b(int i16, MetaMaterial metaMaterial2) {
                    ab.this.m0(i16, metaMaterial2);
                }
            });
            n0(aVar, i3, metaMaterial);
        }
    }

    public ab(@NonNull Context context, WinkEditorViewModel.EditMode editMode, int i3) {
        super(context, editMode);
        this.R = false;
        this.S = false;
        this.L = i3;
        this.M = com.tencent.mobileqq.util.x.c(context, 20.0f);
        this.N = com.tencent.mobileqq.util.x.c(context, 6.0f);
        this.Q = com.tencent.mobileqq.util.x.c(context, 16.0f);
        this.P = com.tencent.mobileqq.util.x.c(context, 2.0f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void n0(a aVar, int i3, @NonNull MetaMaterial metaMaterial) {
    }
}
