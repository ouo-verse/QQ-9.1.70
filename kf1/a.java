package kf1;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.GuildChannelIconUtil;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProAppChnnPreInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public class a extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private View.OnClickListener C;

    /* renamed from: m, reason: collision with root package name */
    private List<lf1.a> f412284m = new ArrayList();

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* renamed from: kf1.a$a, reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    public static class C10654a extends RecyclerView.ViewHolder {
        public RelativeLayout E;

        public C10654a(View view) {
            super(view);
            this.E = (RelativeLayout) view.findViewById(R.id.xfb);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class b extends RecyclerView.ViewHolder {
        public ImageView E;
        public RelativeLayout F;
        public TextView G;

        public b(View view) {
            super(view);
            this.E = (ImageView) view.findViewById(R.id.xff);
            this.F = (RelativeLayout) view.findViewById(R.id.xfc);
            this.G = (TextView) view.findViewById(R.id.xfg);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class c extends RecyclerView.ViewHolder {
        public RelativeLayout E;
        public TextView F;

        public c(View view) {
            super(view);
            this.E = (RelativeLayout) view.findViewById(R.id.xfd);
            this.F = (TextView) view.findViewById(R.id.xfh);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class d extends RecyclerView.ViewHolder {
        public View E;

        public d(View view) {
            super(view);
            this.E = view.findViewById(R.id.xfe);
        }
    }

    private void i0(RecyclerView.ViewHolder viewHolder, lf1.a aVar) {
        if (viewHolder instanceof C10654a) {
            C10654a c10654a = (C10654a) viewHolder;
            c10654a.E.setVisibility(0);
            c10654a.itemView.setOnClickListener(null);
        }
    }

    private void j0(RecyclerView.ViewHolder viewHolder, lf1.a aVar) {
        if (viewHolder instanceof b) {
            b bVar = (b) viewHolder;
            bVar.G.setText(aVar.f414445c.getChannelName());
            bVar.F.setVisibility(0);
            GuildChannelIconUtil.p(bVar.E, aVar.f414445c.getType(), aVar.f414445c.getTextChannelSubtypeId());
            bVar.itemView.setOnClickListener(this.C);
            bVar.itemView.setTag(aVar);
        }
    }

    private void k0(RecyclerView.ViewHolder viewHolder, lf1.a aVar) {
        if (viewHolder instanceof c) {
            c cVar = (c) viewHolder;
            cVar.F.setText(aVar.f414444b);
            cVar.E.setVisibility(0);
            cVar.itemView.setOnClickListener(null);
        }
    }

    private void l0(RecyclerView.ViewHolder viewHolder, lf1.a aVar) {
        if (viewHolder instanceof d) {
            d dVar = (d) viewHolder;
            dVar.E.setVisibility(0);
            dVar.itemView.setOnClickListener(null);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f412284m.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        return this.f412284m.get(i3).f414443a;
    }

    public void m0(View.OnClickListener onClickListener) {
        this.C = onClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i3) {
        lf1.a aVar = this.f412284m.get(i3);
        l0(viewHolder, aVar);
        j0(viewHolder, aVar);
        k0(viewHolder, aVar);
        i0(viewHolder, aVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i3) {
        return kf1.b.a(i3, viewGroup);
    }

    public void setData(List<lf1.a> list) {
        IGProAppChnnPreInfo appChnnPreInfo;
        if (list != null && list.size() > 0) {
            this.f412284m.clear();
            this.f412284m.addAll(list);
            Iterator<lf1.a> it = this.f412284m.iterator();
            while (it.hasNext()) {
                lf1.a next = it.next();
                if (next.f414445c != null && (appChnnPreInfo = ((IGPSService) ch.l().getRuntimeService(IGPSService.class, "all")).getAppChnnPreInfo(next.f414445c.getGuildId(), next.f414445c.getChannelUin())) != null && appChnnPreInfo.getAppid() == 1000050) {
                    it.remove();
                }
            }
        }
        notifyDataSetChanged();
    }
}
