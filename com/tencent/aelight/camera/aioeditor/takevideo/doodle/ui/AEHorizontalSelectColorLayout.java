package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes32.dex */
public class AEHorizontalSelectColorLayout extends FrameLayout {

    /* renamed from: d, reason: collision with root package name */
    protected RecyclerView f68006d;

    /* renamed from: e, reason: collision with root package name */
    protected a f68007e;

    /* renamed from: f, reason: collision with root package name */
    private Boolean f68008f;

    /* renamed from: h, reason: collision with root package name */
    protected int f68009h;

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static abstract class a<VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {

        /* renamed from: d, reason: collision with root package name */
        protected int f68010d;

        /* renamed from: e, reason: collision with root package name */
        protected d f68011e;

        /* renamed from: f, reason: collision with root package name */
        protected int f68012f = 0;

        /* renamed from: h, reason: collision with root package name */
        protected List<Integer> f68013h = new ArrayList();

        /* renamed from: i, reason: collision with root package name */
        protected int f68014i;

        /* JADX INFO: Access modifiers changed from: private */
        public void s(d dVar) {
            this.f68011e = dVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void t(boolean z16) {
            int i3 = this.f68012f;
            this.f68012f = z16 ? 1 : 0;
            if (!z16 && this.f68010d == 0) {
                this.f68010d = this.f68014i;
            } else {
                this.f68010d += (z16 ? 1 : 0) - i3;
            }
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.f68013h.size() + this.f68012f;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void r(List<Integer> list) {
            this.f68013h.clear();
            this.f68013h.addAll(list);
        }

        public void u(int i3) {
            this.f68012f = i3;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void v(int i3) {
            this.f68010d = i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class b extends a<c> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes32.dex */
        public class a implements View.OnClickListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ c f68015d;

            a(c cVar) {
                this.f68015d = cVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                int adapterPosition = this.f68015d.getAdapterPosition();
                b bVar = b.this;
                bVar.f68010d = adapterPosition;
                int i3 = bVar.f68012f;
                if (adapterPosition < i3) {
                    d dVar = bVar.f68011e;
                    if (dVar != null) {
                        dVar.c(0, 0);
                    }
                } else {
                    int intValue = bVar.f68013h.get(adapterPosition - i3).intValue();
                    d dVar2 = b.this.f68011e;
                    if (dVar2 != null) {
                        dVar2.c(1, intValue);
                    }
                }
                b.this.notifyDataSetChanged();
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        b() {
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        /* renamed from: w, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(c cVar, int i3) {
            int i16 = this.f68012f;
            if (i3 < i16) {
                cVar.f68018e.setBackgroundResource(R.drawable.mja);
            } else {
                int intValue = this.f68013h.get(i3 - i16).intValue();
                cVar.f68017d.mutate();
                cVar.f68017d.setColor(intValue);
                cVar.f68018e.setBackgroundDrawable(cVar.f68017d);
            }
            cVar.f68019f.setVisibility(i3 == this.f68010d ? 0 : 8);
            int i17 = this.f68012f;
            if (i3 >= i17 && i3 == this.f68010d) {
                this.f68014i = i3 - i17;
            }
            cVar.itemView.setOnClickListener(new a(cVar));
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        /* renamed from: x, reason: merged with bridge method [inline-methods] */
        public c onCreateViewHolder(ViewGroup viewGroup, int i3) {
            return new c(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.dtg, viewGroup, false));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class c extends RecyclerView.ViewHolder {

        /* renamed from: d, reason: collision with root package name */
        private final GradientDrawable f68017d;

        /* renamed from: e, reason: collision with root package name */
        private final ImageView f68018e;

        /* renamed from: f, reason: collision with root package name */
        private final ImageView f68019f;

        c(View view) {
            super(view);
            this.f68018e = (ImageView) view.findViewById(R.id.f165938y52);
            this.f68019f = (ImageView) view.findViewById(R.id.y8u);
            this.f68017d = (GradientDrawable) view.getContext().getResources().getDrawable(R.drawable.f160072j50);
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface d {
        void J(int i3);

        void c(int i3, int i16);
    }

    public AEHorizontalSelectColorLayout(Context context) {
        this(context, null);
    }

    private void d() {
        LayoutInflater.from(getContext()).inflate(b(), this);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.f787547x);
        this.f68006d = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        a a16 = a();
        this.f68007e = a16;
        this.f68006d.setAdapter(a16);
    }

    protected a a() {
        return new b();
    }

    protected int b() {
        return R.layout.dtn;
    }

    public void c(List<Integer> list, int i3, boolean z16) {
        if (this.f68007e == null) {
            ms.a.c("AEHorizontalSelectColorLayout", "color adapter null.");
            return;
        }
        this.f68008f = Boolean.valueOf(z16);
        this.f68007e.v(i3);
        this.f68007e.t(z16);
        this.f68007e.r(list);
        this.f68007e.notifyDataSetChanged();
    }

    public void setColorSelectListener(d dVar) {
        a aVar = this.f68007e;
        if (aVar != null) {
            aVar.s(dVar);
        }
    }

    public void setCurrentTextItemType(int i3) {
        this.f68009h = i3;
    }

    public AEHorizontalSelectColorLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        d();
    }
}
