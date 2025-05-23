package com.tencent.mobileqq.guild.client.selectaccount;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.client.selectaccount.GuildClientSelectAccountDialogParams;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public class a extends RecyclerView.Adapter<C7694a> implements CompoundButton.OnCheckedChangeListener {
    private final List<GuildClientSelectAccountDialogParams.AccountInfo> C = new ArrayList();
    private int D = 0;

    /* renamed from: m, reason: collision with root package name */
    private final Context f215420m;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.guild.client.selectaccount.a$a, reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    public static class C7694a extends RecyclerView.ViewHolder {
        private final TextView E;
        private final TextView F;
        private final CheckBox G;

        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.guild.client.selectaccount.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes12.dex */
        class ViewOnClickListenerC7695a implements View.OnClickListener {
            ViewOnClickListenerC7695a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                ((CheckBox) view.findViewById(R.id.tul)).setChecked(true);
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        public C7694a(View view) {
            super(view);
            view.setOnClickListener(new ViewOnClickListenerC7695a());
            this.E = (TextView) view.findViewById(R.id.f163888ba);
            this.F = (TextView) view.findViewById(R.id.f163866s82);
            this.G = (CheckBox) view.findViewById(R.id.tul);
        }

        public void m(GuildClientSelectAccountDialogParams.AccountInfo accountInfo, int i3, int i16) {
            if (i3 == 0) {
                this.itemView.setBackgroundResource(R.drawable.guild_background_white);
            } else {
                this.itemView.setBackgroundResource(R.drawable.guild_client_item_top_border_bg_left_16dp);
            }
            this.E.setText(accountInfo.c());
            this.F.setText(accountInfo.a());
            this.G.setTag(Integer.valueOf(i3));
            if (i16 == i3) {
                this.G.setChecked(true);
                this.G.setVisibility(0);
            } else {
                this.G.setChecked(false);
                this.G.setVisibility(8);
            }
        }
    }

    public a(Context context) {
        this.f215420m = context;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.C.size();
    }

    public GuildClientSelectAccountDialogParams.AccountInfo i0() {
        return this.C.get(this.D);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(C7694a c7694a, int i3) {
        c7694a.m(this.C.get(i3), i3, this.D);
        c7694a.G.setOnCheckedChangeListener(this);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public C7694a onCreateViewHolder(ViewGroup viewGroup, int i3) {
        return new C7694a(LayoutInflater.from(this.f215420m).inflate(R.layout.edh, viewGroup, false));
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        if (z16) {
            if (this.D != ((Integer) compoundButton.getTag()).intValue()) {
                this.D = ((Integer) compoundButton.getTag()).intValue();
                notifyDataSetChanged();
            }
        }
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    public void setData(List<GuildClientSelectAccountDialogParams.AccountInfo> list) {
        this.C.clear();
        this.C.addAll(list);
        notifyDataSetChanged();
    }
}
