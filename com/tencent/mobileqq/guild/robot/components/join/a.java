package com.tencent.mobileqq.guild.robot.components.join;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IQQGuildAvatarApi;
import com.tencent.mobileqq.guild.robot.components.join.a;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import gx1.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes14.dex */
public class a extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private boolean D;
    private boolean E;
    private d F;
    private f G;

    /* renamed from: m, reason: collision with root package name */
    private final AppInterface f232156m;
    private final RecyclerView.OnScrollListener H = new C7876a();
    private final List<j> C = new ArrayList();

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.guild.robot.components.join.a$a, reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    class C7876a extends RecyclerView.OnScrollListener {
        C7876a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i3) {
            LinearLayoutManager linearLayoutManager;
            super.onScrollStateChanged(recyclerView, i3);
            if (!a.this.D || a.this.E || a.this.F == null || (linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager()) == null) {
                return;
            }
            int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
            int childCount = linearLayoutManager.getChildCount();
            int itemCount = linearLayoutManager.getItemCount();
            if (i3 == 0 && childCount > 0 && findLastVisibleItemPosition >= itemCount - 1) {
                a.this.F.a(a.this.C.size());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class b extends RecyclerView.ViewHolder {
        private final ImageView E;
        private final TextView F;
        private final Button G;

        public b(@NonNull View view) {
            super(view);
            this.E = (ImageView) view.findViewById(R.id.y8i);
            this.F = (TextView) view.findViewById(R.id.f110836jl);
            Button button = (Button) view.findViewById(R.id.tgj);
            this.G = button;
            button.setOnClickListener(new View.OnClickListener() { // from class: gx1.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    a.b.this.o(view2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void o(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (a.this.G != null) {
                int adapterPosition = getAdapterPosition();
                int i3 = adapterPosition - 1;
                if (a.this.q0(i3)) {
                    f fVar = a.this.G;
                    a aVar = a.this;
                    fVar.a(aVar, this.G, adapterPosition, (j) aVar.C.get(i3));
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void p(j jVar) {
            boolean z16;
            int i3;
            float f16;
            if (jVar != null && a.this.f232156m != null) {
                int dip2px = ViewUtils.dip2px(40.0f);
                this.E.setImageDrawable(((IQQGuildAvatarApi) a.this.f232156m.getRuntimeService(IQQGuildAvatarApi.class, "")).getAvatarDrawable(jVar.a(), dip2px, dip2px, (String) null));
                this.F.setText(jVar.c());
                if (jVar.d() == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                this.G.setClickable(z16);
                Button button = this.G;
                if (z16) {
                    i3 = R.string.f138600_0;
                } else {
                    i3 = R.string.f138810_k;
                }
                button.setText(i3);
                Button button2 = this.G;
                if (z16) {
                    f16 = 1.0f;
                } else {
                    f16 = 0.3f;
                }
                button2.setAlpha(f16);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    protected static class c extends RecyclerView.ViewHolder {
        public c(@NonNull View view) {
            super(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public interface d {
        void a(int i3);
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    protected static class e extends RecyclerView.ViewHolder {
        public e(@NonNull View view) {
            super(view);
        }

        public void l(boolean z16) {
            int i3;
            View view = this.itemView;
            if (z16) {
                i3 = 0;
            } else {
                i3 = 4;
            }
            view.setVisibility(i3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public interface f {
        void a(a aVar, View view, int i3, j jVar);
    }

    public a(AppInterface appInterface) {
        this.f232156m = appInterface;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean q0(int i3) {
        if (i3 >= 0 && i3 < this.C.size()) {
            return true;
        }
        return false;
    }

    private void r0(b bVar, j jVar) {
        VideoReport.setElementId(bVar.G, "em_qqrobot_add_btn");
        VideoReport.setElementReuseIdentifier(bVar.G, String.valueOf(jVar.b()));
        VideoReport.setElementExposePolicy(bVar.G, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(bVar.G, ClickPolicy.REPORT_ALL);
        VideoReport.setElementEndExposePolicy(bVar.G, EndExposurePolicy.REPORT_ALL);
        HashMap hashMap = new HashMap();
        hashMap.put("qq_robot_channel_name", jVar.c());
        hashMap.put("qq_robot_channel_id", String.valueOf(jVar.b()));
        hashMap.put("qq_robot_add_status", Integer.valueOf(jVar.d()));
        VideoReport.setElementParams(bVar.G, hashMap);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.C.isEmpty()) {
            return 0;
        }
        return this.C.size() + 1 + (this.D ? 1 : 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        if (i3 >= 0 && i3 < 1) {
            return 0;
        }
        if (q0(i3 - 1)) {
            return 1;
        }
        return 2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        recyclerView.addOnScrollListener(this.H);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i3) {
        int itemViewType = getItemViewType(i3);
        if (itemViewType != 1) {
            if (itemViewType == 2) {
                ((e) viewHolder).l(this.E);
            }
        } else {
            int i16 = i3 - 1;
            if (q0(i16)) {
                b bVar = (b) viewHolder;
                bVar.p(this.C.get(i16));
                r0(bVar, this.C.get(i16));
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        LayoutInflater from = LayoutInflater.from(this.f232156m.getApplicationContext());
        if (i3 == 0) {
            return new c(from.inflate(R.layout.f5n, viewGroup, false));
        }
        if (i3 == 1) {
            return new b(from.inflate(R.layout.f5o, viewGroup, false));
        }
        return new e(com.tencent.mobileqq.guild.util.qqui.d.c(viewGroup.getContext(), false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        recyclerView.removeOnScrollListener(this.H);
    }

    public void p0(List<j> list, int i3) {
        boolean z16;
        int size = this.C.size();
        int size2 = list.size();
        int i16 = size + size2;
        this.C.addAll(list);
        notifyItemRangeInserted(size + 1, size2);
        boolean z17 = this.D;
        if (i16 < i3) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.D = z16;
        if (z17 && !z16) {
            notifyItemRemoved(i16 + 1);
        } else if (!z17 && z16) {
            notifyItemInserted(i16 + 1);
        }
    }

    public void s0(d dVar) {
        this.F = dVar;
    }

    public void t0(boolean z16) {
        this.E = z16;
        if (this.D) {
            notifyItemChanged(this.C.size() + 1);
        }
    }

    public void u0(f fVar) {
        this.G = fVar;
    }
}
