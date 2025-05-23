package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.DoodleSelectModeView;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel.DoodlePanel;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes32.dex */
public class DoodleColorAndModeView extends RelativeLayout {
    protected final List<Integer> C;
    protected final List<String> D;
    protected boolean E;
    protected int F;
    protected boolean G;
    protected d H;

    /* renamed from: d, reason: collision with root package name */
    protected RecyclerView f68050d;

    /* renamed from: e, reason: collision with root package name */
    protected RecyclerView.Adapter f68051e;

    /* renamed from: f, reason: collision with root package name */
    protected int f68052f;

    /* renamed from: h, reason: collision with root package name */
    protected Boolean f68053h;

    /* renamed from: i, reason: collision with root package name */
    protected boolean f68054i;

    /* renamed from: m, reason: collision with root package name */
    protected int f68055m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a extends RecyclerView.ItemDecoration {

        /* renamed from: d, reason: collision with root package name */
        private int f68056d;

        /* renamed from: e, reason: collision with root package name */
        private int f68057e;

        a() {
            this.f68056d = UIUtils.b(DoodleColorAndModeView.this.getContext(), 15.0f);
            this.f68057e = UIUtils.b(DoodleColorAndModeView.this.getContext(), 28.5f);
        }

        @Override // android.support.v7.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
            if (childAdapterPosition > 0) {
                rect.left = this.f68056d;
            }
            if (childAdapterPosition == 1 && DoodleColorAndModeView.this.f68054i) {
                rect.left = this.f68057e;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class c extends RecyclerView.ViewHolder {

        /* renamed from: d, reason: collision with root package name */
        protected int f68061d;

        /* renamed from: e, reason: collision with root package name */
        protected GradientDrawable f68062e;

        /* renamed from: f, reason: collision with root package name */
        protected ImageView f68063f;

        /* renamed from: h, reason: collision with root package name */
        protected ImageView f68064h;

        /* compiled from: P */
        /* loaded from: classes32.dex */
        class a implements View.OnClickListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ DoodleColorAndModeView f68066d;

            a(DoodleColorAndModeView doodleColorAndModeView) {
                this.f68066d = doodleColorAndModeView;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                c cVar = c.this;
                if (DoodleColorAndModeView.this.G) {
                    ms.a.a("DoodleColorAndModeView", "click color item, but now is disable");
                } else {
                    int adapterPosition = cVar.getAdapterPosition();
                    DoodleColorAndModeView doodleColorAndModeView = DoodleColorAndModeView.this;
                    int i3 = doodleColorAndModeView.f68055m;
                    doodleColorAndModeView.E = adapterPosition >= i3;
                    if (adapterPosition < i3) {
                        d dVar = doodleColorAndModeView.H;
                        if (dVar != null) {
                            dVar.c(0, 0);
                        }
                    } else {
                        int intValue = doodleColorAndModeView.C.get(adapterPosition - i3).intValue();
                        d dVar2 = DoodleColorAndModeView.this.H;
                        if (dVar2 != null) {
                            dVar2.c(1, intValue);
                        }
                        DoodleColorAndModeView.this.F = intValue;
                    }
                    DoodleColorAndModeView.this.f68051e.notifyDataSetChanged();
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        protected c(int i3, View view) {
            super(view);
            this.f68061d = i3;
            if (i3 == 0) {
                this.f68063f = (ImageView) view.findViewById(R.id.f165938y52);
                this.f68064h = (ImageView) view.findViewById(R.id.y8u);
                this.f68062e = (GradientDrawable) view.getContext().getResources().getDrawable(R.drawable.f160072j50);
                view.setOnClickListener(new a(DoodleColorAndModeView.this));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface d {
        void a(DoodlePanel.PenMode penMode);

        void c(int i3, int i16);
    }

    public DoodleColorAndModeView(Context context) {
        this(context, null);
    }

    protected RecyclerView.Adapter a() {
        return new b();
    }

    protected int b() {
        return R.layout.dtn;
    }

    public void d(List<Integer> list, List<String> list2, boolean z16, int i3) {
        this.E = z16;
        this.F = i3;
        this.C.clear();
        this.C.addAll(list);
        this.D.clear();
        this.D.addAll(list2);
        this.f68051e.notifyDataSetChanged();
    }

    protected void e() {
        LayoutInflater.from(getContext()).inflate(b(), this);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.f787547x);
        this.f68050d = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        RecyclerView.Adapter a16 = a();
        this.f68051e = a16;
        this.f68050d.setAdapter(a16);
        this.f68050d.addItemDecoration(new a());
    }

    public boolean f() {
        return !this.E;
    }

    public void g(boolean z16) {
        if (this.G == z16) {
            this.G = !z16;
            this.f68051e.notifyDataSetChanged();
        }
    }

    public void setColorSelectListener(d dVar) {
        this.H = dVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class b extends RecyclerView.Adapter<c> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes32.dex */
        public class a implements DoodleSelectModeView.b {
            a() {
            }

            @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.DoodleSelectModeView.b
            public void a(DoodlePanel.PenMode penMode) {
                DoodleColorAndModeView.this.g(penMode != DoodlePanel.PenMode.ERASER);
                d dVar = DoodleColorAndModeView.this.H;
                if (dVar != null) {
                    dVar.a(penMode);
                }
            }
        }

        protected b() {
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public int getItemCount() {
            return DoodleColorAndModeView.this.C.size() + DoodleColorAndModeView.this.f68055m;
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        /* renamed from: p, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(c cVar, int i3) {
            boolean z16;
            if (getItemViewType(i3) == 1) {
                return;
            }
            DoodleColorAndModeView doodleColorAndModeView = DoodleColorAndModeView.this;
            int i16 = doodleColorAndModeView.f68055m;
            if (i3 < i16) {
                cVar.f68063f.setBackgroundResource(R.drawable.mja);
                DoodleColorAndModeView doodleColorAndModeView2 = DoodleColorAndModeView.this;
                z16 = !doodleColorAndModeView2.E;
                cVar.itemView.setContentDescription(doodleColorAndModeView2.getContext().getString(R.string.f171789l02));
            } else {
                int intValue = doodleColorAndModeView.C.get(i3 - i16).intValue();
                cVar.f68062e.mutate();
                cVar.f68062e.setColor(intValue);
                cVar.f68063f.setBackgroundDrawable(cVar.f68062e);
                DoodleColorAndModeView doodleColorAndModeView3 = DoodleColorAndModeView.this;
                boolean z17 = doodleColorAndModeView3.E && intValue == doodleColorAndModeView3.F;
                cVar.itemView.setContentDescription(doodleColorAndModeView3.D.get(i3 - doodleColorAndModeView3.f68055m));
                z16 = z17;
            }
            cVar.f68064h.setVisibility(z16 ? 0 : 8);
            cVar.itemView.setAlpha(DoodleColorAndModeView.this.G ? 0.4f : 1.0f);
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public int getItemViewType(int i3) {
            return (i3 == 0 && DoodleColorAndModeView.this.f68054i) ? 1 : 0;
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        /* renamed from: q, reason: merged with bridge method [inline-methods] */
        public c onCreateViewHolder(ViewGroup viewGroup, int i3) {
            View view;
            if (i3 == 0) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.dte, viewGroup, false);
            } else if (i3 == 1) {
                DoodleSelectModeView doodleSelectModeView = new DoodleSelectModeView(DoodleColorAndModeView.this.getContext());
                doodleSelectModeView.setUseCase(DoodleColorAndModeView.this.f68052f);
                doodleSelectModeView.setSelectModeListener(new a());
                view = doodleSelectModeView;
            } else {
                view = null;
            }
            return new c(i3, view);
        }
    }

    public DoodleColorAndModeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f68052f = 0;
        this.f68053h = Boolean.FALSE;
        this.f68054i = false;
        this.C = new ArrayList();
        this.D = new ArrayList();
        this.G = false;
        c(context, attributeSet);
        e();
    }

    protected void c(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.DoodleColorAndModeView);
            this.f68052f = obtainStyledAttributes.getInt(2, 0);
            this.f68054i = obtainStyledAttributes.getBoolean(0, false);
            this.f68053h = Boolean.valueOf(obtainStyledAttributes.getBoolean(1, false));
            obtainStyledAttributes.recycle();
        }
        this.f68055m = 0;
        if (this.f68054i) {
            this.f68055m = 0 + 1;
        }
        if (this.f68053h.booleanValue()) {
            this.f68055m++;
        }
    }
}
