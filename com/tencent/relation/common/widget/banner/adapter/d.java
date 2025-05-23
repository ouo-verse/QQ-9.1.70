package com.tencent.relation.common.widget.banner.adapter;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes25.dex */
public class d<T, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {
    static IPatchRedirector $redirector_;
    private qz3.a<T> C;
    private VH D;
    private int E;

    /* renamed from: m, reason: collision with root package name */
    protected List<T> f364822m;

    public d(List<T> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) list);
            return;
        }
        this.f364822m = new ArrayList();
        this.E = 2;
        setDatas(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m0(Object obj, int i3, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        this.C.a(obj, i3);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void n0(RecyclerView.ViewHolder viewHolder, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (this.C != null) {
            this.C.a(viewHolder.itemView.getTag(R.id.t3v), ((Integer) viewHolder.itemView.getTag(R.id.t47)).intValue());
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void o0(RecyclerView.ViewHolder viewHolder, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (this.C != null) {
            this.C.a(viewHolder.itemView.getTag(R.id.t3v), ((Integer) viewHolder.itemView.getTag(R.id.t47)).intValue());
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        if (l0() > 1) {
            return l0() + this.E;
        }
        return l0();
    }

    public int getRealPosition(int i3) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this, i3)).intValue();
        }
        if (this.E == 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        return com.tencent.relation.common.widget.banner.util.a.a(z16, i3, l0());
    }

    public int l0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        List<T> list = this.f364822m;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(@NonNull VH vh5, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) vh5, i3);
            return;
        }
        this.D = vh5;
        final int realPosition = getRealPosition(i3);
        final T t16 = this.f364822m.get(realPosition);
        vh5.itemView.setTag(R.id.t3v, t16);
        vh5.itemView.setTag(R.id.t47, Integer.valueOf(realPosition));
        p0(vh5, this.f364822m.get(realPosition), realPosition, l0());
        if (this.C != null) {
            vh5.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.relation.common.widget.banner.adapter.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    d.this.m0(t16, realPosition, view);
                }
            });
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public VH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (VH) iPatchRedirector.redirect((short) 5, (Object) this, (Object) viewGroup, i3);
        }
        final VH q06 = q0(viewGroup, i3);
        q06.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.relation.common.widget.banner.adapter.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                d.this.o0(q06, view);
            }
        });
        return q06;
    }

    public void p0(VH vh5, T t16, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, vh5, t16, Integer.valueOf(i3), Integer.valueOf(i16));
        }
    }

    public VH q0(ViewGroup viewGroup, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (VH) iPatchRedirector.redirect((short) 13, (Object) this, (Object) viewGroup, i3);
        }
        final VH q06 = q0(viewGroup, i3);
        q06.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.relation.common.widget.banner.adapter.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                d.this.n0(q06, view);
            }
        });
        return q06;
    }

    public void r0(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, i3);
        } else {
            this.E = i3;
        }
    }

    public void s0(qz3.a<T> aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) aVar);
        } else {
            this.C = aVar;
        }
    }

    public void setDatas(List<T> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) list);
            return;
        }
        if (list == null) {
            list = new ArrayList<>();
        }
        this.f364822m = list;
        notifyDataSetChanged();
    }
}
