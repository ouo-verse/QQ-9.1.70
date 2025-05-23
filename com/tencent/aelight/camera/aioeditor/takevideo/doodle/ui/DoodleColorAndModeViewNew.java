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
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.DoodleColorAndModeView;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.DoodleSelectModeView;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel.DoodlePanel;
import com.tencent.aelight.camera.aioeditor.takevideo.mosaic.MosaicConfig;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes32.dex */
public class DoodleColorAndModeViewNew extends DoodleColorAndModeView {
    private DoodleSelectModeViewNew I;
    private ImageView J;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class a extends RecyclerView.ItemDecoration {

        /* renamed from: d, reason: collision with root package name */
        private int f68068d;

        a() {
            this.f68068d = UIUtils.b(DoodleColorAndModeViewNew.this.getContext(), 15.0f);
        }

        @Override // android.support.v7.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            if (recyclerView.getChildAdapterPosition(view) != 0) {
                rect.left = this.f68068d;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class b implements DoodleSelectModeView.b {
        b() {
        }

        @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.DoodleSelectModeView.b
        public void a(DoodlePanel.PenMode penMode) {
            DoodleColorAndModeViewNew.this.l(penMode);
            DoodleColorAndModeViewNew.this.k(penMode == DoodlePanel.PenMode.FREE_DRAW);
            DoodleColorAndModeViewNew.this.g(penMode != DoodlePanel.PenMode.ERASER);
            DoodleColorAndModeView.d dVar = DoodleColorAndModeViewNew.this.H;
            if (dVar != null) {
                dVar.a(penMode);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (view.isSelected()) {
                DoodleColorAndModeViewNew.this.setDoodleSelectModeViewVisibility(8);
            } else {
                DoodleColorAndModeViewNew.this.setDoodleSelectModeViewVisibility(0);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static /* synthetic */ class d {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f68072a;

        static {
            int[] iArr = new int[DoodlePanel.PenMode.values().length];
            f68072a = iArr;
            try {
                iArr[DoodlePanel.PenMode.ARROW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f68072a[DoodlePanel.PenMode.RECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f68072a[DoodlePanel.PenMode.OVAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class e extends RecyclerView.Adapter<f> {
        e() {
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public int getItemCount() {
            return DoodleColorAndModeViewNew.this.C.size() + DoodleColorAndModeViewNew.this.f68055m;
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public int getItemViewType(int i3) {
            return 0;
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        /* renamed from: p, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(f fVar, int i3) {
            GradientDrawable gradientDrawable;
            DoodleColorAndModeViewNew doodleColorAndModeViewNew = DoodleColorAndModeViewNew.this;
            int i16 = doodleColorAndModeViewNew.f68055m;
            if (i3 < i16) {
                fVar.f68075e.setImageResource(R.drawable.f160077j55);
                boolean z16 = !DoodleColorAndModeViewNew.this.E;
                fVar.f68076f.setVisibility(8);
                fVar.f68075e.setSelected(z16);
                fVar.itemView.setContentDescription(DoodleColorAndModeViewNew.this.getContext().getString(R.string.f171789l02));
            } else {
                int intValue = doodleColorAndModeViewNew.C.get(i3 - i16).intValue();
                DoodleColorAndModeViewNew doodleColorAndModeViewNew2 = DoodleColorAndModeViewNew.this;
                boolean z17 = doodleColorAndModeViewNew2.E && intValue == doodleColorAndModeViewNew2.F;
                if (z17) {
                    gradientDrawable = (GradientDrawable) doodleColorAndModeViewNew2.getContext().getResources().getDrawable(R.drawable.f160075j53);
                } else {
                    gradientDrawable = (GradientDrawable) doodleColorAndModeViewNew2.getContext().getResources().getDrawable(R.drawable.f160074j52);
                }
                gradientDrawable.mutate();
                gradientDrawable.setColor(intValue);
                fVar.f68075e.setImageDrawable(gradientDrawable);
                fVar.f68076f.setVisibility(z17 ? 0 : 8);
                View view = fVar.itemView;
                DoodleColorAndModeViewNew doodleColorAndModeViewNew3 = DoodleColorAndModeViewNew.this;
                view.setContentDescription(doodleColorAndModeViewNew3.D.get(i3 - doodleColorAndModeViewNew3.f68055m));
            }
            fVar.itemView.setAlpha(DoodleColorAndModeViewNew.this.G ? 0.4f : 1.0f);
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        /* renamed from: q, reason: merged with bridge method [inline-methods] */
        public f onCreateViewHolder(ViewGroup viewGroup, int i3) {
            return new f(i3, LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.dtf, viewGroup, false));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class f extends RecyclerView.ViewHolder {

        /* renamed from: d, reason: collision with root package name */
        protected int f68074d;

        /* renamed from: e, reason: collision with root package name */
        protected ImageView f68075e;

        /* renamed from: f, reason: collision with root package name */
        protected ImageView f68076f;

        /* compiled from: P */
        /* loaded from: classes32.dex */
        class a implements View.OnClickListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ DoodleColorAndModeViewNew f68078d;

            a(DoodleColorAndModeViewNew doodleColorAndModeViewNew) {
                this.f68078d = doodleColorAndModeViewNew;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                DoodleColorAndModeViewNew.this.setDoodleSelectModeViewVisibility(8);
                f fVar = f.this;
                if (DoodleColorAndModeViewNew.this.G) {
                    ms.a.a("DoodleColorAndModeView", "click color item, but now is disable");
                } else {
                    int adapterPosition = fVar.getAdapterPosition();
                    DoodleColorAndModeViewNew doodleColorAndModeViewNew = DoodleColorAndModeViewNew.this;
                    int i3 = doodleColorAndModeViewNew.f68055m;
                    doodleColorAndModeViewNew.E = adapterPosition >= i3;
                    if (adapterPosition < i3) {
                        DoodleColorAndModeView.d dVar = doodleColorAndModeViewNew.H;
                        if (dVar != null) {
                            dVar.c(0, 0);
                        }
                        DoodleColorAndModeViewNew doodleColorAndModeViewNew2 = DoodleColorAndModeViewNew.this;
                        doodleColorAndModeViewNew2.j(doodleColorAndModeViewNew2.f68050d, "em_image_edit_draw", 5);
                    } else {
                        int intValue = doodleColorAndModeViewNew.C.get(adapterPosition - i3).intValue();
                        DoodleColorAndModeView.d dVar2 = DoodleColorAndModeViewNew.this.H;
                        if (dVar2 != null) {
                            dVar2.c(1, intValue);
                        }
                        DoodleColorAndModeViewNew doodleColorAndModeViewNew3 = DoodleColorAndModeViewNew.this;
                        doodleColorAndModeViewNew3.F = intValue;
                        doodleColorAndModeViewNew3.j(doodleColorAndModeViewNew3.f68050d, "em_image_edit_draw", 6);
                    }
                    DoodleColorAndModeViewNew.this.f68051e.notifyDataSetChanged();
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        protected f(int i3, View view) {
            super(view);
            this.f68074d = i3;
            if (i3 == 0) {
                this.f68075e = (ImageView) view.findViewById(R.id.f165938y52);
                this.f68076f = (ImageView) view.findViewById(R.id.y8u);
                view.setOnClickListener(new a(DoodleColorAndModeViewNew.this));
            }
        }
    }

    public DoodleColorAndModeViewNew(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(View view, String str, int i3) {
        VideoReport.setElementId(view, str);
        Map<String, Object> a16 = kr.a.a();
        a16.put("image_edit_draw_type", Integer.valueOf(i3));
        VideoReport.setElementParams(view, a16);
        VideoReport.reportEvent("dt_clck", view, a16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(DoodlePanel.PenMode penMode) {
        int i3 = d.f68072a[penMode.ordinal()];
        this.J.setImageResource(i3 != 1 ? i3 != 2 ? i3 != 3 ? R.drawable.j5_ : R.drawable.j58 : R.drawable.j59 : R.drawable.j57);
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.DoodleColorAndModeView
    protected RecyclerView.Adapter a() {
        return new e();
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.DoodleColorAndModeView
    protected int b() {
        return R.layout.dto;
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.DoodleColorAndModeView
    protected void e() {
        LayoutInflater.from(getContext()).inflate(b(), this);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.f787547x);
        this.f68050d = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        RecyclerView.Adapter a16 = a();
        this.f68051e = a16;
        this.f68050d.setAdapter(a16);
        this.f68050d.addItemDecoration(new a());
        DoodleSelectModeViewNew doodleSelectModeViewNew = (DoodleSelectModeViewNew) findViewById(R.id.ukf);
        this.I = doodleSelectModeViewNew;
        doodleSelectModeViewNew.setUseCase(1);
        this.I.setSelectModeListener(new b());
        ImageView imageView = (ImageView) findViewById(R.id.ukg);
        this.J = imageView;
        imageView.setOnClickListener(new c());
        if (this.f68054i) {
            this.J.setVisibility(0);
        } else {
            this.J.setVisibility(4);
        }
    }

    protected void k(boolean z16) {
        if (this.f68053h.booleanValue() != z16) {
            if (z16) {
                this.f68055m++;
            } else {
                this.f68055m--;
            }
            this.f68053h = Boolean.valueOf(z16);
            this.f68051e.notifyDataSetChanged();
        }
    }

    public void setDoodleSelectModeViewVisibility(int i3) {
        DoodleSelectModeViewNew doodleSelectModeViewNew = this.I;
        if (doodleSelectModeViewNew != null) {
            doodleSelectModeViewNew.setVisibility(i3);
        }
        ImageView imageView = this.J;
        if (imageView != null) {
            imageView.setSelected(i3 == 0);
        }
    }

    public DoodleColorAndModeViewNew(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.DoodleColorAndModeView
    protected void c(Context context, AttributeSet attributeSet) {
        boolean z16 = false;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.DoodleColorAndModeView);
            this.f68052f = obtainStyledAttributes.getInt(2, 0);
            this.f68054i = obtainStyledAttributes.getBoolean(0, false);
            this.f68053h = Boolean.valueOf(obtainStyledAttributes.getBoolean(1, false));
            obtainStyledAttributes.recycle();
        }
        this.f68055m = 0;
        if (this.f68053h.booleanValue() && !MosaicConfig.a()) {
            z16 = true;
        }
        Boolean valueOf = Boolean.valueOf(z16);
        this.f68053h = valueOf;
        if (valueOf.booleanValue()) {
            this.f68055m++;
        }
    }
}
