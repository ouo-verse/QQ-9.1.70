package com.tencent.av.ui;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.av.utils.aw;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public class q extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener {
    private final List<Integer> C = new ArrayList();
    private r D;
    private k E;

    /* renamed from: m, reason: collision with root package name */
    private final Context f76589m;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class a extends RecyclerView.ViewHolder {
        QavPanelAcrossView[] E;

        public a(View view) {
            super(view);
            QavPanelAcrossView[] qavPanelAcrossViewArr = new QavPanelAcrossView[4];
            this.E = qavPanelAcrossViewArr;
            qavPanelAcrossViewArr[0] = (QavPanelAcrossView) view.findViewById(R.id.s8r);
            this.E[1] = (QavPanelAcrossView) view.findViewById(R.id.s8t);
            this.E[2] = (QavPanelAcrossView) view.findViewById(R.id.s8u);
            this.E[3] = (QavPanelAcrossView) view.findViewById(R.id.s8s);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class b extends RecyclerView.ViewHolder {
        View E;
        View F;
        ImageView G;
        TextView H;
        ConstraintLayout I;

        public b(View view) {
            super(view);
            this.E = view.findViewById(R.id.bmt);
            this.G = (ImageView) view.findViewById(R.id.zs9);
            this.H = (TextView) view.findViewById(R.id.zsd);
            this.I = (ConstraintLayout) view.findViewById(R.id.zs_);
            this.F = view.findViewById(R.id.adk);
        }
    }

    public q(Context context) {
        this.f76589m = context;
    }

    private void j0(List<rw.a> list, a aVar) {
        for (int i3 = 0; i3 < list.size(); i3++) {
            s0(list.get(i3), aVar.E[i3].f75103d);
            p0(list.get(i3), aVar.E[i3].f75105f);
            l0(list.get(i3), aVar.E[i3].f75104e);
        }
    }

    private void k0(ImageView imageView, int i3) {
        Drawable drawable = imageView.getResources().getDrawable(i3);
        aw a16 = aw.a(imageView.getResources(), i3, R.color.c_f);
        a16.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        imageView.setImageDrawable(a16);
    }

    private void l0(rw.a aVar, View view) {
        view.setEnabled(!aVar.g());
    }

    private void m0(List<rw.a> list, ConstraintLayout constraintLayout, int i3) {
        if (list.size() == 1) {
            constraintLayout.setBackgroundResource(R.drawable.k_1);
            return;
        }
        int itemViewType = getItemViewType(i3);
        if (itemViewType != 19) {
            if (itemViewType != 20) {
                constraintLayout.setBackgroundResource(R.drawable.k9w);
                return;
            } else {
                constraintLayout.setBackgroundResource(R.drawable.k9x);
                return;
            }
        }
        constraintLayout.setBackgroundResource(R.drawable.k_4);
    }

    private void n0(List<rw.a> list, b bVar, int i3) {
        s0(list.get(i3), bVar.H);
        p0(list.get(i3), bVar.I);
        l0(list.get(i3), bVar.G);
    }

    private void o0(List<rw.a> list, View view, int i3) {
        if (getItemViewType(i3) != 20 && list.size() != 1) {
            view.setVisibility(0);
        } else {
            view.setVisibility(8);
        }
    }

    private void p0(rw.a aVar, View view) {
        if (aVar.f()) {
            view.setOnClickListener(this);
        } else {
            view.setOnClickListener(null);
        }
    }

    private void r0(View view, int i3) {
        if (getItemViewType(i3) == 20) {
            view.setVisibility(0);
        } else {
            view.setVisibility(8);
        }
    }

    private void s0(rw.a aVar, TextView textView) {
        if (!aVar.g()) {
            textView.setTextColor(Color.parseColor("#FFFFFF"));
        } else {
            textView.setTextColor(Color.parseColor("#4CFFFFFF"));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        r rVar = this.D;
        if (rVar == null) {
            return 0;
        }
        return rVar.f76591b.size() + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        if (i3 == 0) {
            return 17;
        }
        if (i3 == 1) {
            return 19;
        }
        if (i3 == this.D.f76591b.size()) {
            return 20;
        }
        return 18;
    }

    public void i0(r rVar) {
        this.D = rVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i3) {
        if (viewHolder instanceof a) {
            if (this.D == null) {
                return;
            }
            if (this.C.size() > 0) {
                this.C.clear();
            }
            List<rw.a> list = this.D.f76590a;
            if (list != null && list.size() > 0) {
                a aVar = (a) viewHolder;
                for (int i16 = 0; i16 < list.size(); i16++) {
                    this.C.add(Integer.valueOf(list.get(i16).b()));
                    aVar.E[i16].f75107i.setVisibility(0);
                    aVar.E[i16].f75103d.setText(list.get(i16).e());
                    aVar.E[i16].f75105f.setId(list.get(i16).b());
                    String a16 = list.get(i16).a();
                    if (TextUtils.isEmpty(a16)) {
                        a16 = String.format(HardCodeUtil.qqStr(R.string.zo8), list.get(i16).e());
                    }
                    aVar.E[i16].f75107i.setContentDescription(a16);
                    com.tencent.av.utils.e.b(aVar.E[i16].f75104e, true, list.get(i16).d());
                }
                for (int i17 = 3; i17 >= list.size(); i17--) {
                    aVar.E[i17].f75107i.setVisibility(4);
                }
                j0(list, aVar);
                return;
            }
            return;
        }
        r rVar = this.D;
        if (rVar == null) {
            return;
        }
        int i18 = i3 - 1;
        List<rw.a> list2 = rVar.f76591b;
        b bVar = (b) viewHolder;
        bVar.H.setText(list2.get(i18).e());
        k0(bVar.G, list2.get(i18).d());
        bVar.I.setTag(Integer.valueOf(list2.get(i18).b()));
        bVar.I.setId(list2.get(i18).b());
        bVar.I.setContentDescription(list2.get(i18).a());
        r0(bVar.F, i3);
        m0(list2, bVar.I, i3);
        o0(list2, bVar.E, i3);
        n0(list2, bVar, i18);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        this.E.b(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        if (i3 == 17) {
            return new a(LayoutInflater.from(this.f76589m).inflate(R.layout.fud, viewGroup, false));
        }
        return new b(LayoutInflater.from(this.f76589m).inflate(R.layout.fue, viewGroup, false));
    }

    public void q0(k kVar) {
        this.E = kVar;
        notifyDataSetChanged();
    }

    public void t0(r rVar) {
        this.D = rVar;
        notifyDataSetChanged();
    }
}
