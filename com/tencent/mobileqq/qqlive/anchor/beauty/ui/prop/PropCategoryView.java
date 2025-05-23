package com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.PropCategoryView;

/* loaded from: classes17.dex */
public class PropCategoryView extends FrameLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private RecyclerView f270457d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f270458e;

    /* renamed from: f, reason: collision with root package name */
    private com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.bean.b f270459f;

    /* renamed from: h, reason: collision with root package name */
    private b f270460h;

    /* renamed from: i, reason: collision with root package name */
    private com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.api.a f270461i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes17.dex */
    public class a extends RecyclerView.ItemDecoration {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PropCategoryView.this);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NonNull Rect rect, @NonNull View view, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, rect, view, recyclerView, state);
                return;
            }
            super.getItemOffsets(rect, view, recyclerView, state);
            int applyDimension = (int) TypedValue.applyDimension(1, 7.0f, view.getContext().getResources().getDisplayMetrics());
            rect.set(applyDimension, applyDimension, applyDimension, applyDimension);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes17.dex */
    public class b extends RecyclerView.Adapter<a> {
        static IPatchRedirector $redirector_;

        /* loaded from: classes17.dex */
        public class a extends RecyclerView.ViewHolder {
            static IPatchRedirector $redirector_;
            PropItemView E;

            public a(@NonNull View view) {
                super(view);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this, (Object) view);
                } else {
                    this.E = (PropItemView) view;
                }
            }
        }

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PropCategoryView.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void j0(PropItemView propItemView, com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.bean.a aVar) {
            if (PropCategoryView.this.f270461i != null) {
                PropCategoryView.this.f270461i.b(propItemView, aVar);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
            }
            if (PropCategoryView.this.f270459f != null && PropCategoryView.this.f270459f.f270511e != null && PropCategoryView.this.f270459f.f270511e.size() != 0) {
                return PropCategoryView.this.f270459f.f270511e.size();
            }
            return 0;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this, i3)).intValue();
            }
            return i3;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: k0, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(@NonNull a aVar, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar, i3);
                return;
            }
            com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.bean.a aVar2 = PropCategoryView.this.f270459f.f270511e.get(i3);
            aVar.E.setData(aVar2);
            aVar.E.setSelected(aVar2.d());
            aVar.E.setPropItemClickListener(new com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.api.a() { // from class: com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.a
                @Override // com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.api.a
                public final void b(PropItemView propItemView, com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.bean.a aVar3) {
                    PropCategoryView.b.this.j0(propItemView, aVar3);
                }
            });
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        /* renamed from: l0, reason: merged with bridge method [inline-methods] */
        public a onCreateViewHolder(@NonNull ViewGroup viewGroup, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (a) iPatchRedirector.redirect((short) 2, (Object) this, (Object) viewGroup, i3);
            }
            return new a(new PropItemView(PropCategoryView.this.getContext()));
        }
    }

    public PropCategoryView(@NonNull Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            c();
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        }
    }

    private void c() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.hb8, (ViewGroup) this, true);
        this.f270458e = (TextView) inflate.findViewById(R.id.f11991785);
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R.id.yvd);
        this.f270457d = recyclerView;
        recyclerView.setPadding(5, 5, 5, 5);
        this.f270457d.setClipToPadding(false);
        ((SimpleItemAnimator) this.f270457d.getItemAnimator()).setSupportsChangeAnimations(false);
        this.f270457d.setItemAnimator(null);
        this.f270457d.setLayoutManager(new GridLayoutManager(getContext(), 5));
        this.f270457d.setHasFixedSize(true);
        b bVar = new b();
        this.f270460h = bVar;
        bVar.setHasStableIds(true);
        this.f270457d.setAdapter(this.f270460h);
        this.f270457d.addItemDecoration(new a());
    }

    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        b bVar = this.f270460h;
        if (bVar != null) {
            bVar.notifyDataSetChanged();
        }
    }

    public void setData(com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.bean.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) bVar);
        } else {
            this.f270459f = bVar;
        }
    }

    public void setPropItemClickListener(com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.api.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) aVar);
        } else {
            this.f270461i = aVar;
        }
    }

    public void setVirtualAnchorTextVisibility(boolean z16) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, z16);
            return;
        }
        TextView textView = this.f270458e;
        if (textView != null) {
            if (z16) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            textView.setVisibility(i3);
        }
    }

    public PropCategoryView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            c();
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
        }
    }

    public PropCategoryView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            c();
        } else {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
        }
    }
}
