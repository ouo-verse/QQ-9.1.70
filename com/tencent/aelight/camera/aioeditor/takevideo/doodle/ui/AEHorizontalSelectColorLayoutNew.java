package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.AEHorizontalSelectColorLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

/* compiled from: P */
/* loaded from: classes32.dex */
public class AEHorizontalSelectColorLayoutNew extends AEHorizontalSelectColorLayout {
    private static final int C = ViewUtils.dip2px(16.0f);
    private static final int D = ViewUtils.dip2px(28.0f);

    /* renamed from: i, reason: collision with root package name */
    private RecyclerView.ItemDecoration f68020i;

    /* renamed from: m, reason: collision with root package name */
    private int f68021m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a extends RecyclerView.ItemDecoration {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f68022d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f68023e;

        a(int i3, int i16) {
            this.f68022d = i3;
            this.f68023e = i16;
        }

        @Override // android.support.v7.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            if (recyclerView.getChildAdapterPosition(view) < this.f68022d - 1) {
                rect.right = this.f68023e;
            } else {
                rect.right = 0;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    protected static class b extends AEHorizontalSelectColorLayout.a<c> {

        /* renamed from: m, reason: collision with root package name */
        private boolean f68025m = false;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes32.dex */
        public class a implements View.OnClickListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ c f68026d;

            a(c cVar) {
                this.f68026d = cVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                int adapterPosition = this.f68026d.getAdapterPosition();
                b bVar = b.this;
                bVar.f68010d = adapterPosition;
                int i3 = bVar.f68012f;
                if (adapterPosition < i3) {
                    if (bVar.f68011e != null) {
                        bVar.f68025m = !bVar.f68025m;
                        b bVar2 = b.this;
                        bVar2.f68011e.J(bVar2.f68025m ? 32 : 0);
                    }
                } else {
                    int intValue = bVar.f68013h.get(adapterPosition - i3).intValue();
                    AEHorizontalSelectColorLayout.d dVar = b.this.f68011e;
                    if (dVar != null) {
                        dVar.c(1, intValue);
                    }
                }
                b.this.notifyDataSetChanged();
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        protected b() {
        }

        public void A(boolean z16) {
            this.f68025m = z16;
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        /* renamed from: y, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(c cVar, int i3) {
            GradientDrawable gradientDrawable;
            if (i3 < this.f68012f) {
                if (this.f68025m) {
                    cVar.f68028d.setImageResource(R.drawable.ngl);
                } else {
                    cVar.f68028d.setImageResource(R.drawable.ngk);
                }
                cVar.f68029e.setVisibility(8);
            } else {
                Context context = cVar.f68028d.getContext();
                if (i3 == this.f68010d) {
                    this.f68014i = i3 - this.f68012f;
                    gradientDrawable = (GradientDrawable) context.getDrawable(R.drawable.f160075j53);
                } else {
                    gradientDrawable = (GradientDrawable) context.getDrawable(R.drawable.f160074j52);
                }
                int intValue = this.f68013h.get(i3 - this.f68012f).intValue();
                gradientDrawable.mutate();
                gradientDrawable.setColor(intValue);
                cVar.f68028d.setImageDrawable(gradientDrawable);
                cVar.f68029e.setVisibility(i3 == this.f68010d ? 0 : 8);
            }
            cVar.itemView.setOnClickListener(new a(cVar));
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        /* renamed from: z, reason: merged with bridge method [inline-methods] */
        public c onCreateViewHolder(ViewGroup viewGroup, int i3) {
            return new c(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.dtf, viewGroup, false));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class c extends RecyclerView.ViewHolder {

        /* renamed from: d, reason: collision with root package name */
        private final ImageView f68028d;

        /* renamed from: e, reason: collision with root package name */
        private final ImageView f68029e;

        c(View view) {
            super(view);
            this.f68028d = (ImageView) view.findViewById(R.id.f165938y52);
            this.f68029e = (ImageView) view.findViewById(R.id.y8u);
        }
    }

    public AEHorizontalSelectColorLayoutNew(Context context) {
        super(context);
    }

    private void e() {
        int itemCount = this.f68007e.getItemCount();
        if (this.f68021m == itemCount) {
            return;
        }
        this.f68021m = itemCount;
        int screenWidth = ((ViewUtils.getScreenWidth() - C) - (D * itemCount)) / itemCount;
        RecyclerView.ItemDecoration itemDecoration = this.f68020i;
        if (itemDecoration != null) {
            this.f68006d.removeItemDecoration(itemDecoration);
        }
        a aVar = new a(itemCount, screenWidth);
        this.f68020i = aVar;
        this.f68006d.addItemDecoration(aVar);
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.AEHorizontalSelectColorLayout
    protected AEHorizontalSelectColorLayout.a a() {
        return new b();
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.AEHorizontalSelectColorLayout
    protected int b() {
        return R.layout.dto;
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.AEHorizontalSelectColorLayout
    public void c(List<Integer> list, int i3, boolean z16) {
        AEHorizontalSelectColorLayout.a aVar = this.f68007e;
        if (aVar == null) {
            ms.a.c("AEHorizontalSelectColorLayoutNew", "color adapter null.");
            return;
        }
        if (z16) {
            aVar.u(1);
            this.f68007e.v(i3 + 1);
        } else {
            aVar.v(i3);
        }
        this.f68007e.r(list);
        e();
        this.f68007e.notifyDataSetChanged();
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.AEHorizontalSelectColorLayout
    public void setCurrentTextItemType(int i3) {
        super.setCurrentTextItemType(i3);
        AEHorizontalSelectColorLayout.a aVar = this.f68007e;
        if (aVar instanceof b) {
            ((b) aVar).A(i3 != 0);
        }
    }

    public AEHorizontalSelectColorLayoutNew(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
