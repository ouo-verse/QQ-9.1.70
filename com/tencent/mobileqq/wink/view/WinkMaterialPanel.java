package com.tencent.mobileqq.wink.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.wink.reddot.WinkMaterialRedDotManager;
import com.tencent.mobileqq.wink.view.x;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes21.dex */
public class WinkMaterialPanel extends LinearLayout {
    private ab C;
    private List<MetaCategory> D;
    private List<MetaMaterial> E;
    List<MetaMaterial> F;
    private String G;
    private boolean H;

    /* renamed from: d, reason: collision with root package name */
    private LinearLayout f326878d;

    /* renamed from: e, reason: collision with root package name */
    private RecyclerView f326879e;

    /* renamed from: f, reason: collision with root package name */
    private RecyclerView f326880f;

    /* renamed from: h, reason: collision with root package name */
    private ImageView f326881h;

    /* renamed from: i, reason: collision with root package name */
    private LinearLayoutManager f326882i;

    /* renamed from: m, reason: collision with root package name */
    private x f326883m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes21.dex */
    public class a extends RecyclerView.OnScrollListener {
        a() {
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i3) {
            if (1 == i3) {
                WinkMaterialPanel.this.H = false;
                if (WinkMaterialPanel.this.C != null) {
                    WinkMaterialPanel.this.C.R = false;
                    WinkMaterialPanel.this.C.S = false;
                }
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i3, int i16) {
            if (!WinkMaterialPanel.this.H && WinkMaterialPanel.this.C != null && !WinkMaterialPanel.this.C.R && !WinkMaterialPanel.this.C.S) {
                WinkMaterialPanel.this.f326883m.B(com.tencent.mobileqq.wink.editor.c.f(WinkMaterialPanel.this.D, WinkMaterialPanel.this.E, WinkMaterialPanel.this.f326882i.findFirstVisibleItemPosition()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes21.dex */
    public class b implements x.b {
        b() {
        }

        @Override // com.tencent.mobileqq.wink.view.x.b
        public void a(x.a aVar, int i3, @Nullable MetaCategory metaCategory) {
            WinkMaterialPanel.c(WinkMaterialPanel.this);
            WinkMaterialPanel.this.H = true;
            int e16 = com.tencent.mobileqq.wink.editor.c.e(WinkMaterialPanel.this.D, WinkMaterialPanel.this.E, i3);
            if (aVar != null) {
                com.tencent.mobileqq.wink.utils.b.g(WinkMaterialPanel.this.f326880f, WinkMaterialPanel.this.C.D(), e16);
            } else {
                com.tencent.mobileqq.wink.utils.b.i(WinkMaterialPanel.this.f326880f, WinkMaterialPanel.this.C.D(), e16, false, false);
            }
        }

        @Override // com.tencent.mobileqq.wink.view.x.b
        public void b(x.a aVar, int i3, @Nullable MetaCategory metaCategory) {
            WinkMaterialPanel.c(WinkMaterialPanel.this);
        }
    }

    /* loaded from: classes21.dex */
    public interface c {
    }

    public WinkMaterialPanel(Context context) {
        this(context, null);
    }

    static /* bridge */ /* synthetic */ c c(WinkMaterialPanel winkMaterialPanel) {
        winkMaterialPanel.getClass();
        return null;
    }

    private void k(@Nullable AttributeSet attributeSet) {
        int i3;
        TypedArray obtainStyledAttributes;
        setOrientation(1);
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.f326878d = linearLayout;
        linearLayout.setOrientation(0);
        this.f326878d.setGravity(16);
        this.f326881h = new ImageView(getContext());
        int c16 = com.tencent.mobileqq.util.x.c(getContext(), 10.0f);
        this.f326881h.setPadding(c16, c16, c16, c16);
        int c17 = com.tencent.mobileqq.util.x.c(getContext(), 40.0f);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(c17, c17);
        layoutParams.setMargins(com.tencent.mobileqq.util.x.c(getContext(), 10.0f), 0, 0, 0);
        this.f326878d.addView(this.f326881h, layoutParams);
        setClearButtonEnable(false);
        RecyclerView recyclerView = new RecyclerView(getContext());
        this.f326879e = recyclerView;
        recyclerView.setOverScrollMode(2);
        this.f326879e.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        SimpleItemAnimator simpleItemAnimator = (SimpleItemAnimator) this.f326879e.getItemAnimator();
        if (simpleItemAnimator != null) {
            simpleItemAnimator.setSupportsChangeAnimations(false);
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -2);
        layoutParams2.weight = 1.0f;
        this.f326878d.addView(this.f326879e, layoutParams2);
        addView(this.f326878d, new LinearLayout.LayoutParams(-1, com.tencent.mobileqq.util.x.c(getContext(), 40.0f)));
        RecyclerView recyclerView2 = new RecyclerView(getContext());
        this.f326880f = recyclerView2;
        recyclerView2.setOverScrollMode(2);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), 0, false);
        this.f326882i = linearLayoutManager;
        linearLayoutManager.setAutoMeasureEnabled(false);
        this.f326880f.setLayoutManager(this.f326882i);
        SimpleItemAnimator simpleItemAnimator2 = (SimpleItemAnimator) this.f326880f.getItemAnimator();
        if (simpleItemAnimator2 != null) {
            simpleItemAnimator2.setSupportsChangeAnimations(false);
        }
        if (attributeSet != null && (obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, com.tencent.mobileqq.wink.j.P9)) != null) {
            i3 = obtainStyledAttributes.getDimensionPixelSize(com.tencent.mobileqq.wink.j.Q9, 0);
            obtainStyledAttributes.recycle();
        } else {
            i3 = 0;
        }
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams3.setMargins(0, i3, 0, 0);
        addView(this.f326880f, layoutParams3);
        this.f326880f.addOnScrollListener(new a());
        l();
    }

    private void l() {
        x xVar = new x(new ArrayList(), new b());
        this.f326883m = xVar;
        xVar.A(new x.c() { // from class: com.tencent.mobileqq.wink.view.v
            @Override // com.tencent.mobileqq.wink.view.x.c
            public final void a(int i3, MetaCategory metaCategory) {
                WinkMaterialPanel.this.m(i3, metaCategory);
            }
        });
        this.f326879e.setAdapter(this.f326883m);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m(int i3, MetaCategory metaCategory) {
        if (metaCategory != null) {
            w53.b.a("WinkMaterialPanel", "Select position = " + i3 + " id = " + metaCategory.f30532id);
            WinkMaterialRedDotManager.f326249a.c(metaCategory.f30532id);
            this.G = metaCategory.f30532id;
        }
    }

    public void n(List<MetaMaterial> list) {
        int i3 = 0;
        while (true) {
            if (i3 < list.size()) {
                if (list.get(i3).hasRedDot) {
                    break;
                } else {
                    i3++;
                }
            } else {
                i3 = -1;
                break;
            }
        }
        w53.b.a("WinkMaterialPanel", "scrollToFirstRedDot firstRedDot = " + i3);
        if (i3 >= 0) {
            com.tencent.mobileqq.wink.utils.b.i(this.f326880f, this.C.D(), i3, false, false);
        }
    }

    public void o(MetaMaterial metaMaterial) {
        List<MetaCategory> list;
        if (this.f326883m != null && metaMaterial != null && (list = this.D) != null && list.size() != 0) {
            String p16 = com.tencent.mobileqq.wink.editor.c.p(metaMaterial);
            if (TextUtils.isEmpty(p16)) {
                return;
            }
            int i3 = 0;
            int i16 = 0;
            while (true) {
                if (i16 >= this.D.size()) {
                    break;
                }
                if (p16.equals(this.D.get(i16).name)) {
                    i3 = i16;
                    break;
                }
                i16++;
            }
            this.f326883m.D(i3);
        }
    }

    public void setClearButtonEnable(boolean z16) {
        int i3;
        this.f326881h.setEnabled(z16);
        ImageView imageView = this.f326881h;
        if (z16) {
            i3 = R.drawable.owd;
        } else {
            i3 = R.drawable.owe;
        }
        imageView.setImageResource(i3);
    }

    public void setOnClearButtonClickListener(View.OnClickListener onClickListener) {
        this.f326881h.setOnClickListener(onClickListener);
    }

    public void setup(ab abVar, @NonNull List<MetaCategory> list, @NonNull List<MetaMaterial> list2) {
        setup(abVar, list, list2, null);
    }

    public WinkMaterialPanel(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setup(ab abVar, @NonNull List<MetaCategory> list, @NonNull List<MetaMaterial> list2, List<MetaMaterial> list3) {
        setup(abVar, list, list2, list3, false);
    }

    public WinkMaterialPanel(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        k(attributeSet);
    }

    public void setup(ab abVar, @NonNull List<MetaCategory> list, @NonNull List<MetaMaterial> list2, List<MetaMaterial> list3, boolean z16) {
        this.D = list;
        this.E = list2;
        this.F = list3;
        if (this.C != abVar) {
            this.C = abVar;
            this.f326880f.setAdapter(abVar);
        }
        this.C.i0(list2, list3);
        this.f326883m.E(list);
        if (z16) {
            n(this.E);
        }
    }

    public void setCategoryItemListener(c cVar) {
    }
}
