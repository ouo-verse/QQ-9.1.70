package com.tencent.mobileqq.qqlive.room.livelabel;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.room.livelabel.b;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

/* compiled from: P */
/* loaded from: classes17.dex */
public class b extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    static IPatchRedirector $redirector_;
    private a C;
    private List<LabelModel> D;
    private int E;

    /* renamed from: m, reason: collision with root package name */
    private final boolean f271621m;

    /* compiled from: P */
    /* loaded from: classes17.dex */
    public interface a {
        void a(int i3, LabelModel labelModel);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.qqlive.room.livelabel.b$b, reason: collision with other inner class name */
    /* loaded from: classes17.dex */
    public class C8372b extends RecyclerView.ViewHolder {
        static IPatchRedirector $redirector_;
        private ImageView E;
        private TextView F;
        private FrameLayout G;

        public C8372b(@NonNull View view) {
            super(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this, (Object) view);
                return;
            }
            this.E = (ImageView) view.findViewById(R.id.xd6);
            lk4.e.b(view.getContext(), 18.0f);
            this.G = (FrameLayout) view.findViewById(R.id.xd7);
            this.F = (TextView) view.findViewById(R.id.f98175md);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qqlive.room.livelabel.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    b.C8372b.this.m(view2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void m(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            b.this.E = getAdapterPosition();
            if (!this.G.isSelected()) {
                this.G.setSelected(true);
                ((LabelModel) b.this.D.get(b.this.E)).isSelected = true;
                for (int i3 = 0; i3 < b.this.D.size(); i3++) {
                    if (b.this.E != i3 && ((LabelModel) b.this.D.get(i3)).isSelected) {
                        ((LabelModel) b.this.D.get(i3)).isSelected = false;
                        b.this.notifyItemChanged(i3);
                    }
                }
                b.this.C.a(b.this.E, (LabelModel) b.this.D.get(b.this.E));
            }
            EventCollector.getInstance().onViewClicked(view);
        }

        public void n(LabelModel labelModel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) labelModel);
                return;
            }
            this.F.setText(labelModel.title);
            if (!TextUtils.isEmpty(labelModel.iconUrl)) {
                this.E.setImageDrawable(URLDrawable.getDrawable(labelModel.iconUrl));
            }
            this.G.setSelected(labelModel.isSelected);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public class c extends RecyclerView.ViewHolder {
        static IPatchRedirector $redirector_;
        private TextView E;

        public c(@NonNull View view) {
            super(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this, (Object) view);
                return;
            }
            TextView textView = (TextView) view.findViewById(R.id.f920856x);
            this.E = textView;
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qqlive.room.livelabel.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    b.c.this.m(view2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void m(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            b.this.E = getAdapterPosition();
            boolean isSelected = this.E.isSelected();
            if (!isSelected) {
                this.E.setSelected(!isSelected);
                ((LabelModel) b.this.D.get(b.this.E)).isSelected = !isSelected;
                for (int i3 = 0; i3 < b.this.D.size(); i3++) {
                    if (b.this.E != i3 && ((LabelModel) b.this.D.get(i3)).isSelected) {
                        ((LabelModel) b.this.D.get(i3)).isSelected = false;
                        b.this.notifyItemChanged(i3);
                    }
                }
                b.this.C.a(b.this.E, (LabelModel) b.this.D.get(b.this.E));
            }
            EventCollector.getInstance().onViewClicked(view);
        }

        public void n(LabelModel labelModel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) labelModel);
            } else {
                this.E.setText(labelModel.title);
                this.E.setSelected(labelModel.isSelected);
            }
        }
    }

    public b(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, z16);
        } else {
            this.f271621m = z16;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        List<LabelModel> list = this.D;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this, i3)).intValue();
        }
        if (this.f271621m) {
            return 2;
        }
        return 1;
    }

    public void m0(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
        } else {
            this.C = aVar;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) viewHolder, i3);
        } else if (viewHolder instanceof C8372b) {
            ((C8372b) viewHolder).n(this.D.get(i3));
        } else {
            ((c) viewHolder).n(this.D.get(i3));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (RecyclerView.ViewHolder) iPatchRedirector.redirect((short) 4, (Object) this, (Object) viewGroup, i3);
        }
        if (i3 == 2) {
            return new C8372b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.i3r, viewGroup, false));
        }
        return new c(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.i3s, viewGroup, false));
    }

    public void setData(List<LabelModel> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) list);
        } else {
            this.D = list;
            notifyDataSetChanged();
        }
    }
}
