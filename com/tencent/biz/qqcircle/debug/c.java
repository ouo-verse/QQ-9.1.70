package com.tencent.biz.qqcircle.debug;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.widgets.QFSFormSimpleItem;
import com.tencent.biz.qqcircle.widgets.person.QFSSettingSwitchView;
import com.tencent.biz.richframework.part.block.base.BaseListViewAdapter;
import com.tencent.biz.richframework.part.block.base.SafeLinearLayoutManager;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class c extends BaseListViewAdapter<com.tencent.qcircle.cooperation.config.debug.a> {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class a extends RecyclerView.ViewHolder {
        private QFSFormSimpleItem E;
        private com.tencent.qcircle.cooperation.config.debug.a F;
        private View G;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* renamed from: com.tencent.biz.qqcircle.debug.c$a$a, reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class ViewOnClickListenerC0860a implements View.OnClickListener {
            ViewOnClickListenerC0860a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                a.this.F.onClick(view);
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        public a(@NonNull View view) {
            super(view);
            this.E = (QFSFormSimpleItem) view.findViewById(R.id.f30860ph);
            this.G = view;
        }

        public void m(com.tencent.qcircle.cooperation.config.debug.a aVar) {
            this.F = aVar;
            this.E.setLeftText(aVar.e());
            this.E.setOnClickListener(new ViewOnClickListenerC0860a());
            this.F.f(this.itemView);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class b extends RecyclerView.Adapter {
        private ViewOnClickListenerC0861b.a D;

        /* renamed from: m, reason: collision with root package name */
        private List<a> f84175m = new ArrayList();
        private int C = -1;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes4.dex */
        public static class a {

            /* renamed from: a, reason: collision with root package name */
            private String f84176a;

            /* renamed from: b, reason: collision with root package name */
            private boolean f84177b = false;

            a(String str) {
                this.f84176a = str;
            }

            public String a() {
                return this.f84176a;
            }

            public boolean b() {
                return this.f84177b;
            }

            public void c(boolean z16) {
                this.f84177b = z16;
            }
        }

        /* compiled from: P */
        /* renamed from: com.tencent.biz.qqcircle.debug.c$b$b, reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        static class ViewOnClickListenerC0861b extends RecyclerView.ViewHolder implements View.OnClickListener {
            RadioButton E;
            TextView F;
            a G;
            int H;

            /* compiled from: P */
            /* renamed from: com.tencent.biz.qqcircle.debug.c$b$b$a */
            /* loaded from: classes4.dex */
            public interface a {
                void onClick(int i3);
            }

            ViewOnClickListenerC0861b(View view) {
                super(view);
                this.E = (RadioButton) view.findViewById(R.id.f32320tf);
                this.F = (TextView) view.findViewById(R.id.f32330tg);
                this.E.setOnClickListener(this);
                this.F.setOnClickListener(this);
                view.setOnClickListener(this);
            }

            public void l(a aVar, int i3) {
                this.F.setText(aVar.a());
                this.E.setChecked(aVar.b());
                this.H = i3;
            }

            public void m(a aVar) {
                this.G = aVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                this.G.onClick(this.H);
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        b() {
        }

        public void clearData() {
            this.f84175m = new ArrayList();
            this.C = -1;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: getItemCount */
        public int getNUM_BACKGOURND_ICON() {
            return this.f84175m.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public long getItemId(int i3) {
            return i3;
        }

        public void i0(String str) {
            this.f84175m.add(new a(str));
        }

        public void j0(int i3) {
            int i16 = this.C;
            if (i3 != i16) {
                if (i16 != -1) {
                    this.f84175m.get(i16).c(false);
                }
                this.f84175m.get(i3).c(true);
                this.C = i3;
                notifyDataSetChanged();
            }
        }

        public void k0(ViewOnClickListenerC0861b.a aVar) {
            this.D = aVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i3) {
            if (viewHolder instanceof ViewOnClickListenerC0861b) {
                ViewOnClickListenerC0861b viewOnClickListenerC0861b = (ViewOnClickListenerC0861b) viewHolder;
                viewOnClickListenerC0861b.l(this.f84175m.get(i3), i3);
                viewOnClickListenerC0861b.m(this.D);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i3) {
            return new ViewOnClickListenerC0861b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.g2v, viewGroup, false));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.biz.qqcircle.debug.c$c, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0862c extends RecyclerView.ViewHolder {
        private RecyclerView E;
        private b F;
        private TextView G;
        private com.tencent.qcircle.cooperation.config.debug.d H;
        private Context I;
        private View J;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* renamed from: com.tencent.biz.qqcircle.debug.c$c$a */
        /* loaded from: classes4.dex */
        public class a implements b.ViewOnClickListenerC0861b.a {
            a() {
            }

            @Override // com.tencent.biz.qqcircle.debug.c.b.ViewOnClickListenerC0861b.a
            public void onClick(int i3) {
                C0862c.this.H.p(i3);
                C0862c.this.F.j0(i3);
            }
        }

        public C0862c(@NonNull View view) {
            super(view);
            this.E = (RecyclerView) view.findViewById(R.id.f30880pj);
            this.G = (TextView) view.findViewById(R.id.f32920v2);
            this.F = new b();
            this.I = view.getContext();
            this.J = view;
        }

        public void n(com.tencent.qcircle.cooperation.config.debug.d dVar) {
            if (dVar == null) {
                return;
            }
            this.H = dVar;
            this.G.setText(dVar.e());
            this.H.f(this.J);
            List<com.tencent.qcircle.cooperation.config.debug.b> j3 = this.H.j();
            this.F.clearData();
            for (int i3 = 0; i3 < j3.size(); i3++) {
                this.F.i0(j3.get(i3).a());
            }
            this.F.j0(this.H.i());
            this.F.k0(new a());
            this.E.setLayoutManager(new SafeLinearLayoutManager(this.I, 1, false));
            this.E.setAdapter(this.F);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class d extends RecyclerView.ViewHolder {
        private QFSSettingSwitchView E;
        private com.tencent.qcircle.cooperation.config.debug.d F;
        private View G;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes4.dex */
        public class a implements QFSSettingSwitchView.b {
            a() {
            }

            @Override // com.tencent.biz.qqcircle.widgets.person.QFSSettingSwitchView.b
            public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                d.this.F.o(z16 ? 1 : 0);
            }
        }

        public d(@NonNull View view) {
            super(view);
            this.E = (QFSSettingSwitchView) view.findViewById(R.id.f30900pl);
            this.G = view;
        }

        public void m(com.tencent.qcircle.cooperation.config.debug.d dVar) {
            this.F = dVar;
            if (dVar.c() == null) {
                this.E.setDesTvVisibility(false);
            } else {
                this.E.setHide(this.F.c());
            }
            this.E.setListener(new a());
            this.F.f(this.G);
            this.E.setCheckedOnly(this.F.n());
            this.E.setTitle(this.F.e());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        return ((com.tencent.qcircle.cooperation.config.debug.a) this.mDataList.get(i3)).b();
    }

    public void i0(RecyclerView.ViewHolder viewHolder, int i3) {
        if (viewHolder instanceof a) {
            ((a) viewHolder).m((com.tencent.qcircle.cooperation.config.debug.a) this.mDataList.get(i3));
        }
    }

    public void j0(RecyclerView.ViewHolder viewHolder, int i3) {
        if (viewHolder instanceof C0862c) {
            ((C0862c) viewHolder).n((com.tencent.qcircle.cooperation.config.debug.d) this.mDataList.get(i3));
        }
    }

    public void k0(RecyclerView.ViewHolder viewHolder, int i3) {
        if (viewHolder instanceof d) {
            ((d) viewHolder).m((com.tencent.qcircle.cooperation.config.debug.d) this.mDataList.get(i3));
        }
    }

    public RecyclerView.ViewHolder l0(ViewGroup viewGroup, int i3) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.g2q, viewGroup, false));
    }

    public RecyclerView.ViewHolder m0(ViewGroup viewGroup, int i3) {
        return new C0862c(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.g2w, viewGroup, false));
    }

    public RecyclerView.ViewHolder n0(ViewGroup viewGroup, int i3) {
        return new d(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.g2x, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i3) {
        int itemViewType = getItemViewType(i3);
        if (itemViewType == 0) {
            i0(viewHolder, i3);
        } else if (itemViewType == -9999) {
            k0(viewHolder, i3);
        } else if (itemViewType == 9999) {
            j0(viewHolder, i3);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        if (i3 == 0) {
            return l0(viewGroup, i3);
        }
        if (i3 == -9999) {
            return n0(viewGroup, i3);
        }
        if (i3 == 9999) {
            return m0(viewGroup, i3);
        }
        return l0(viewGroup, i3);
    }
}
