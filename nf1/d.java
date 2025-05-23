package nf1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.channel.create.widget.SubChannelIconView;
import com.tencent.mobileqq.guild.util.GuildChannelIconUtil;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public class d extends RecyclerView.Adapter<a> implements View.OnClickListener {
    private List<of1.b> C = new ArrayList();
    public qf1.b D;

    /* renamed from: m, reason: collision with root package name */
    private Context f420095m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class a extends RecyclerView.ViewHolder {
        SubChannelIconView E;
        TextView F;
        ImageView G;

        public a(@NonNull View view) {
            super(view);
            this.E = (SubChannelIconView) view.findViewById(R.id.f900951j);
            this.F = (TextView) view.findViewById(R.id.f113816rn);
            this.G = (ImageView) view.findViewById(R.id.zqa);
            ch.Y0(view, "em_sgrp_select_channel", ClickPolicy.REPORT_NONE, ExposurePolicy.REPORT_NONE);
        }
    }

    public d(Context context, @NonNull qf1.b bVar) {
        this.f420095m = context;
        this.D = bVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.C.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: i0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NonNull a aVar, int i3) {
        of1.b bVar = this.C.get(i3);
        aVar.F.setText(bVar.f422593a);
        aVar.E.setIcons(new SubChannelIconView.b(R.drawable.guild_create_channel_item_icon_bg, GuildChannelIconUtil.g(bVar.f422594b)));
        aVar.itemView.setTag(bVar);
        aVar.itemView.setOnClickListener(new View.OnClickListener() { // from class: nf1.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                d.this.onClick(view);
            }
        });
        if (bVar.f422595c) {
            aVar.G.setVisibility(0);
        } else {
            aVar.G.setVisibility(8);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(ViewGroup viewGroup, int i3) {
        return new a(LayoutInflater.from(this.f420095m).inflate(R.layout.f9n, (ViewGroup) null));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        EventCollector.getInstance().onViewClickedBefore(view);
        if (!QQGuildUIUtil.v() && (view.getTag() instanceof of1.b)) {
            of1.b bVar = (of1.b) view.getTag();
            this.D.H3(bVar);
            HashMap hashMap = new HashMap();
            hashMap.put("sgrp_subchannel_type", Integer.valueOf(bVar.f422594b));
            VideoReport.reportEvent("clck", view, hashMap);
        }
        EventCollector.getInstance().onViewClicked(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    public void setData(List<of1.b> list) {
        if (list != null && list.size() > 0) {
            this.C.clear();
            this.C.addAll(list);
        }
        notifyDataSetChanged();
    }
}
