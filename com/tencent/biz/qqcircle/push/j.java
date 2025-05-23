package com.tencent.biz.qqcircle.push;

import android.annotation.SuppressLint;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.utils.bz;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.richframework.util.RFWTypefaceUtil;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public class j extends RecyclerView.Adapter<c> {
    private Pair<Integer, Integer> C;
    private b D;

    /* renamed from: m, reason: collision with root package name */
    private final List<Integer> f91852m = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f91853d;

        a(int i3) {
            this.f91853d = i3;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (j.this.D != null) {
                j.this.D.onItemClick(this.f91853d);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface b {
        void onItemClick(int i3);
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class c extends RecyclerView.ViewHolder {
        private final FrameLayout E;
        private final TextView F;
        private int G;
        private int H;
        private int I;

        public c(View view) {
            super(view);
            this.E = (FrameLayout) view.findViewById(R.id.f509826v);
            this.F = (TextView) view.findViewById(R.id.f509926w);
        }

        private void r() {
            FrameLayout frameLayout = this.E;
            if (frameLayout != null && this.F != null) {
                int i3 = this.H;
                if (i3 != 0) {
                    if (i3 != 1) {
                        if (i3 == 2) {
                            frameLayout.setBackground(ResourcesCompat.getDrawable(frameLayout.getResources(), R.drawable.klk, null));
                            this.F.setTextColor(this.E.getResources().getColor(R.color.cle));
                            return;
                        }
                        return;
                    }
                    frameLayout.setBackground(ResourcesCompat.getDrawable(frameLayout.getResources(), R.drawable.klj, null));
                    this.F.setTextColor(this.E.getResources().getColor(R.color.clf));
                    return;
                }
                frameLayout.setBackground(ResourcesCompat.getDrawable(frameLayout.getResources(), R.drawable.klj, null));
                this.F.setTextColor(this.E.getResources().getColor(R.color.clf));
                this.E.setAlpha(0.6f);
                this.F.setAlpha(0.6f);
            }
        }

        public void m() {
            if (this.E != null) {
                Pair l06 = j.this.l0();
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) this.E.getLayoutParams();
                ((ViewGroup.MarginLayoutParams) layoutParams).height = ((Integer) l06.first).intValue();
                ((ViewGroup.MarginLayoutParams) layoutParams).width = ((Integer) l06.second).intValue();
                if (this.I != 0) {
                    ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = cx.a(12.0f);
                }
                this.E.setLayoutParams(layoutParams);
            }
        }

        public void o() {
            if (this.H == 1) {
                this.H = 2;
                r();
            }
        }

        public int p() {
            return this.H;
        }

        public void q() {
            if (this.H == 2) {
                this.H = 1;
                r();
            }
        }

        public void s(int i3) {
            this.H = i3;
            if (com.tencent.biz.qqcircle.f.v().t() < this.G) {
                this.H = 0;
            }
            r();
        }

        public void t(int i3) {
            this.I = i3;
        }

        public void u(int i3) {
            TextView textView = this.F;
            if (textView == null) {
                return;
            }
            textView.setText(String.valueOf(i3));
            RFWTypefaceUtil.setNumberTypeface(this.F, false);
            this.G = i3;
        }
    }

    private void k0(c cVar, int i3) {
        if (cVar.E == null) {
            return;
        }
        if (this.C == null) {
            this.C = l0();
        }
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) cVar.E.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams).height = ((Integer) this.C.first).intValue();
        ((ViewGroup.MarginLayoutParams) layoutParams).width = ((Integer) this.C.second).intValue();
        if (i3 != 0) {
            ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = cx.a(12.0f);
        }
        cVar.E.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Pair<Integer, Integer> l0() {
        return new Pair<>(Integer.valueOf(cx.a(68.0f)), Integer.valueOf((int) (((bz.j() - (cx.a(12.0f) * 3)) - (cx.a(16.0f) * 2)) / 4.0f)));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.f91852m.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NonNull c cVar, @SuppressLint({"RecyclerView"}) int i3) {
        int i16;
        if (i3 <= 3 && this.f91852m.get(i3) != null) {
            cVar.u(this.f91852m.get(i3).intValue());
            cVar.t(i3);
            if (i3 == 0) {
                i16 = 2;
            } else {
                i16 = 1;
            }
            cVar.s(i16);
            k0(cVar, i3);
            cVar.E.setOnClickListener(new a(i3));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: n0, reason: merged with bridge method [inline-methods] */
    public c onCreateViewHolder(ViewGroup viewGroup, int i3) {
        return new c(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.gph, viewGroup, false));
    }

    public void o0(List<Integer> list, b bVar) {
        this.D = bVar;
        this.f91852m.clear();
        this.f91852m.addAll(list);
        notifyDataSetChanged();
    }
}
