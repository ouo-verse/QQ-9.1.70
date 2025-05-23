package com.tencent.mobileqq.qqlive.anchor.beauty.widget.popup;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.anchor.beauty.model.CategoryItem;
import com.tencent.mobileqq.qqlive.anchor.beauty.widget.popup.EffectPageItemView;
import com.tencent.mobileqq.qqlive.anchor.beauty.widget.popup.EffectPageView;
import java.util.List;

/* loaded from: classes17.dex */
public class EffectPageView extends FrameLayout {
    static IPatchRedirector $redirector_;
    private boolean C;
    private final EffectPageItemView.i D;

    /* renamed from: d, reason: collision with root package name */
    private CategoryItem f270598d;

    /* renamed from: e, reason: collision with root package name */
    private View f270599e;

    /* renamed from: f, reason: collision with root package name */
    private RecyclerView f270600f;

    /* renamed from: h, reason: collision with root package name */
    private c f270601h;

    /* renamed from: i, reason: collision with root package name */
    private CategoryItem.a f270602i;

    /* renamed from: m, reason: collision with root package name */
    private EffectPageItemView f270603m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes17.dex */
    public class a extends RecyclerView.ItemDecoration {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) EffectPageView.this);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NonNull Rect rect, @NonNull View view, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, rect, view, recyclerView, state);
            } else {
                super.getItemOffsets(rect, view, recyclerView, state);
                rect.set((int) TypedValue.applyDimension(1, 10.0f, EffectPageView.this.getContext().getResources().getDisplayMetrics()), 0, 0, 0);
            }
        }
    }

    /* loaded from: classes17.dex */
    class b implements EffectPageItemView.i {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) EffectPageView.this);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.anchor.beauty.widget.popup.EffectPageItemView.i
        public void a(EffectPageItemView effectPageItemView) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) effectPageItemView);
                return;
            }
            if (EffectPageView.this.f270603m != null) {
                EffectPageView.this.f270603m.setSelected(false);
            }
            EffectPageView.this.f270603m = effectPageItemView;
            if (EffectPageView.this.f270603m != null) {
                EffectPageView.this.f270603m.setSelected(true);
                EffectPageView effectPageView = EffectPageView.this;
                effectPageView.f270602i = effectPageView.f270603m.i();
            }
            if (EffectPageView.this.f270601h != null) {
                EffectPageView.this.f270601h.notifyDataSetChanged();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes17.dex */
    public class c extends RecyclerView.Adapter<a> {
        static IPatchRedirector $redirector_;

        /* loaded from: classes17.dex */
        public class a extends RecyclerView.ViewHolder {
            static IPatchRedirector $redirector_;
            EffectPageItemView E;

            public a(@NonNull View view) {
                super(view);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this, (Object) view);
                } else {
                    this.E = (EffectPageItemView) view;
                }
            }
        }

        public c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) EffectPageView.this);
            }
        }

        private void j0(@NonNull a aVar, int i3) {
            CategoryItem.a aVar2;
            boolean z16;
            if (i3 >= getItemCount() || (aVar2 = EffectPageView.this.f270598d.f270411e.get(i3)) == null) {
                return;
            }
            if (aVar2 == EffectPageView.this.f270602i) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16 && EffectPageView.this.f270603m == null) {
                EffectPageView.this.f270603m = aVar.E;
            }
            aVar.setIsRecyclable(false);
            aVar.E.setSeekBar(EffectPageView.this.f270599e);
            aVar.E.setData(aVar2, EffectPageView.this.f270602i, EffectPageView.this.o());
            aVar.E.setListener(EffectPageView.this.D);
            aVar.E.setTag(Integer.valueOf(aVar2.hashCode()));
            aVar.E.setItemResDownloadListener(new EffectPageItemView.h() { // from class: com.tencent.mobileqq.qqlive.anchor.beauty.widget.popup.i
                @Override // com.tencent.mobileqq.qqlive.anchor.beauty.widget.popup.EffectPageItemView.h
                public final void a(int i16, int i17, int i18) {
                    EffectPageView.c.this.k0(i16, i17, i18);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void k0(int i3, int i16, int i17) {
            EffectPageItemView effectPageItemView = (EffectPageItemView) EffectPageView.this.f270600f.findViewWithTag(Integer.valueOf(i3));
            effectPageItemView.m(i16);
            effectPageItemView.setProgress(i17);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
            }
            if (EffectPageView.this.f270598d != null && EffectPageView.this.f270598d.f270411e != null) {
                return EffectPageView.this.f270598d.f270411e.size();
            }
            return 0;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this, i3)).intValue();
            }
            if (EffectPageView.this.f270598d != null) {
                return EffectPageView.this.f270598d.f270408b;
            }
            return super.getItemViewType(i3);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: l0, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(@NonNull a aVar, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) aVar, i3);
            } else {
                j0(aVar, i3);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: m0, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(@NonNull a aVar, int i3, @NonNull List<Object> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, aVar, Integer.valueOf(i3), list);
            } else {
                j0(aVar, i3);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        /* renamed from: n0, reason: merged with bridge method [inline-methods] */
        public a onCreateViewHolder(@NonNull ViewGroup viewGroup, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (a) iPatchRedirector.redirect((short) 2, (Object) this, (Object) viewGroup, i3);
            }
            return new a(new EffectPageItemView(EffectPageView.this.getContext()));
        }
    }

    public EffectPageView(@NonNull Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.C = false;
        this.D = new b();
        n();
    }

    private int l() {
        CategoryItem categoryItem;
        if (this.f270602i == null || (categoryItem = this.f270598d) == null || categoryItem.f270411e == null) {
            return -1;
        }
        for (int i3 = 0; i3 < this.f270598d.f270411e.size(); i3++) {
            if (this.f270602i == this.f270598d.f270411e.get(i3)) {
                return i3;
            }
        }
        return -1;
    }

    private void m(View view) {
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.i4m);
        this.f270600f = recyclerView;
        recyclerView.setPadding(17, 0, 17, 0);
        this.f270600f.setClipToPadding(false);
        ((SimpleItemAnimator) this.f270600f.getItemAnimator()).setSupportsChangeAnimations(false);
        this.f270600f.setItemAnimator(null);
        this.f270600f.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        this.f270600f.setHasFixedSize(true);
        c cVar = new c();
        this.f270601h = cVar;
        this.f270600f.setAdapter(cVar);
        this.f270600f.addItemDecoration(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean o() {
        if (this.C && this.f270602i != null) {
            return true;
        }
        return false;
    }

    public String k() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        CategoryItem categoryItem = this.f270598d;
        if (categoryItem != null && (str = categoryItem.f270410d) != null) {
            return str;
        }
        return "";
    }

    public void n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            m(LayoutInflater.from(getContext()).inflate(R.layout.h_f, (ViewGroup) this, true));
        }
    }

    public void setData(CategoryItem categoryItem, CategoryItem.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) categoryItem, (Object) aVar);
        } else {
            this.f270598d = categoryItem;
            this.f270602i = aVar;
        }
    }

    public void setRootContainer(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) view);
        } else {
            this.f270599e = view;
        }
    }

    @Override // android.view.View
    public void setSelected(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, z16);
            return;
        }
        this.C = z16;
        c cVar = this.f270601h;
        if (cVar != null) {
            cVar.notifyDataSetChanged();
        }
        int l3 = l();
        if (l3 >= 0) {
            this.f270600f.scrollToPosition(l3);
        }
    }

    public EffectPageView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.C = false;
        this.D = new b();
        n();
    }

    public EffectPageView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.C = false;
        this.D = new b();
        n();
    }
}
