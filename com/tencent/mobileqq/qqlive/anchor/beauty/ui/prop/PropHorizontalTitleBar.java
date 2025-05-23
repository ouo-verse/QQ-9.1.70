package com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.PropHorizontalTitleBar;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

/* loaded from: classes17.dex */
public class PropHorizontalTitleBar extends LinearLayout {
    static IPatchRedirector $redirector_;
    private ImageView C;

    /* renamed from: d, reason: collision with root package name */
    private RecyclerView f270464d;

    /* renamed from: e, reason: collision with root package name */
    private c f270465e;

    /* renamed from: f, reason: collision with root package name */
    private int f270466f;

    /* renamed from: h, reason: collision with root package name */
    private List<com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.bean.b> f270467h;

    /* renamed from: i, reason: collision with root package name */
    private b f270468i;

    /* renamed from: m, reason: collision with root package name */
    private d f270469m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes17.dex */
    public class a extends RecyclerView.ItemDecoration {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PropHorizontalTitleBar.this);
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
            int applyDimension = ((int) TypedValue.applyDimension(1, 30.0f, view.getContext().getResources().getDisplayMetrics())) / 2;
            rect.set(applyDimension, 0, applyDimension, 0);
        }
    }

    /* loaded from: classes17.dex */
    public interface b {
        void onItemSelected(int i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes17.dex */
    public class c extends RecyclerView.Adapter<a> {
        static IPatchRedirector $redirector_;

        /* loaded from: classes17.dex */
        public class a extends RecyclerView.ViewHolder {
            static IPatchRedirector $redirector_;
            TextView E;
            View F;

            public a(@NonNull View view) {
                super(view);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this, (Object) view);
                } else {
                    this.E = (TextView) view.findViewById(R.id.yvg);
                    this.F = view.findViewById(R.id.yvf);
                }
            }
        }

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PropHorizontalTitleBar.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void j0(int i3, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            PropHorizontalTitleBar.this.f270466f = i3;
            notifyDataSetChanged();
            PropHorizontalTitleBar.this.f270468i.onItemSelected(i3);
            EventCollector.getInstance().onViewClicked(view);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            if (PropHorizontalTitleBar.this.f270467h == null) {
                return 0;
            }
            return PropHorizontalTitleBar.this.f270467h.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: k0, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(@NonNull a aVar, final int i3) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar, i3);
                return;
            }
            if (PropHorizontalTitleBar.this.f270467h == null) {
                return;
            }
            aVar.E.setText(((com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.bean.b) PropHorizontalTitleBar.this.f270467h.get(i3)).f270508b);
            TextView textView = aVar.E;
            int i16 = 0;
            if (PropHorizontalTitleBar.this.f270466f == i3) {
                z16 = true;
            } else {
                z16 = false;
            }
            textView.setSelected(z16);
            View view = aVar.F;
            if (PropHorizontalTitleBar.this.f270466f != i3) {
                i16 = 4;
            }
            view.setVisibility(i16);
            aVar.E.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    PropHorizontalTitleBar.c.this.j0(i3, view2);
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
            return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.hba, viewGroup, false));
        }
    }

    /* loaded from: classes17.dex */
    public interface d {
        void a();
    }

    public PropHorizontalTitleBar(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            f(context);
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        }
    }

    private void f(Context context) {
        View.inflate(context, R.layout.hb_, this);
        ImageView imageView = (ImageView) findViewById(R.id.yvb);
        this.C = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PropHorizontalTitleBar.this.g(view);
            }
        });
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.yvh);
        this.f270464d = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(context, 0, false));
        this.f270464d.addItemDecoration(new a());
        c cVar = new c();
        this.f270465e = cVar;
        this.f270464d.setAdapter(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        d dVar = this.f270469m;
        if (dVar != null) {
            dVar.a();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void setCallback(b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) bVar);
        } else {
            this.f270468i = bVar;
        }
    }

    public void setCurrentPosition(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
            return;
        }
        this.f270466f = i3;
        this.f270465e.notifyDataSetChanged();
        this.f270464d.scrollToPosition(i3);
    }

    public void setData(List<com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.bean.b> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) list);
        } else {
            this.f270467h = list;
            this.f270465e.notifyDataSetChanged();
        }
    }

    public void setResetCallback(d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) dVar);
        } else {
            this.f270469m = dVar;
        }
    }

    public PropHorizontalTitleBar(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            f(context);
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
        }
    }

    public PropHorizontalTitleBar(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            f(context);
        } else {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
        }
    }
}
