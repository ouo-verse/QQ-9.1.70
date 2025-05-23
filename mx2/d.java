package mx2;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import mx2.d;
import nx2.i;
import org.light.utils.CollectionUtils;
import tvideo.TVideoChannelList$VideoChannelData;

/* compiled from: P */
/* loaded from: classes19.dex */
public class d extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    protected final RecyclerView C;
    protected a D;
    protected int E;
    protected i.b F;
    private b G;

    /* renamed from: m, reason: collision with root package name */
    protected final List<TVideoChannelList$VideoChannelData> f417747m = new ArrayList();

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class a extends RecyclerView.ViewHolder {
        View E;
        TextView F;
        View G;

        public a(@NonNull View view) {
            super(view);
            this.G = view;
            this.F = (TextView) view.findViewById(R.id.tsl);
            this.E = view.findViewById(R.id.tsb);
        }

        private boolean n(TVideoChannelList$VideoChannelData tVideoChannelList$VideoChannelData, int i3) {
            if (ox2.b.e().c() == null) {
                if (i3 == d.this.k0()) {
                    return true;
                }
                return false;
            }
            if (tVideoChannelList$VideoChannelData != null && tVideoChannelList$VideoChannelData.channel_id.get() == ox2.b.e().d()) {
                return true;
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void o(int i3, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            onItemClick(view, i3);
            EventCollector.getInstance().onViewClicked(view);
        }

        private void onItemClick(View view, int i3) {
            if (d.this.G != null && d.this.E != i3) {
                TVideoChannelList$VideoChannelData tVideoChannelList$VideoChannelData = (TVideoChannelList$VideoChannelData) view.getTag();
                d.this.G.a(tVideoChannelList$VideoChannelData);
                p(i3);
                d dVar = d.this;
                VideoReport.reportEvent("clck", dVar.C, dVar.j0(tVideoChannelList$VideoChannelData, i3));
            }
        }

        public void m(TVideoChannelList$VideoChannelData tVideoChannelList$VideoChannelData, final int i3) {
            if (n(tVideoChannelList$VideoChannelData, i3)) {
                p(i3);
                if (ox2.b.e().c() == null) {
                    ox2.b.e().l(tVideoChannelList$VideoChannelData);
                }
            } else {
                q();
            }
            this.F.setText(tVideoChannelList$VideoChannelData.channel_title.get());
            this.G.setTag(tVideoChannelList$VideoChannelData);
            this.G.setOnClickListener(new View.OnClickListener() { // from class: mx2.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    d.a.this.o(i3, view);
                }
            });
            d.this.m0(tVideoChannelList$VideoChannelData, i3);
        }

        protected void p(int i3) {
            a aVar = d.this.D;
            if (aVar != null) {
                aVar.q();
            }
            d dVar = d.this;
            dVar.E = i3;
            dVar.D = this;
            this.E.setVisibility(0);
            this.F.setTextColor(this.E.getContext().getColor(R.color.f158017al3));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void q() {
            this.E.setVisibility(8);
            this.F.setTextColor(this.E.getContext().getColor(R.color.cwf));
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public interface b {
        void a(TVideoChannelList$VideoChannelData tVideoChannelList$VideoChannelData);
    }

    public d(RecyclerView recyclerView) {
        this.C = recyclerView;
        VideoReport.setElementId(recyclerView, "channel_icon");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f417747m.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        return 0;
    }

    public Map<String, Object> j0(TVideoChannelList$VideoChannelData tVideoChannelList$VideoChannelData, int i3) {
        Map<String, Object> g16 = gy2.c.g();
        g16.put("icon_name", tVideoChannelList$VideoChannelData.channel_title);
        g16.put("ztid", tVideoChannelList$VideoChannelData.channel_id);
        g16.put("item_idx", Integer.valueOf(i3));
        g16.put("style", l0());
        return g16;
    }

    protected int k0() {
        return 0;
    }

    protected String l0() {
        return "horizontal";
    }

    public void n0(b bVar) {
        this.G = bVar;
    }

    public void o0(i.b bVar) {
        this.F = bVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i3) {
        TVideoChannelList$VideoChannelData tVideoChannelList$VideoChannelData = this.f417747m.get(i3);
        if (viewHolder instanceof a) {
            ((a) viewHolder).m(tVideoChannelList$VideoChannelData, i3);
        }
    }

    public void setData(List<TVideoChannelList$VideoChannelData> list) {
        if (CollectionUtils.isEmpty(list)) {
            return;
        }
        this.f417747m.clear();
        this.f417747m.addAll(list);
        ox2.b.e().b(list);
        notifyDataSetChanged();
    }

    protected void m0(TVideoChannelList$VideoChannelData tVideoChannelList$VideoChannelData, int i3) {
    }
}
