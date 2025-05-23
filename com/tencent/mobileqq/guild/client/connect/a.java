package com.tencent.mobileqq.guild.client.connect;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.client.GuildClientParams;
import com.tencent.mobileqq.guild.client.manage.GuildClientManageFragment;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.widget.C11728RoundRectUrlImageView;
import com.tencent.mobileqq.util.x;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public class a extends RecyclerView.Adapter<C7690a> {
    private final List<GuildClientParams> C = new ArrayList();

    /* renamed from: m, reason: collision with root package name */
    private final Context f215380m;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.guild.client.connect.a$a, reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    public static class C7690a extends RecyclerView.ViewHolder {
        private final View E;
        private final C11728RoundRectUrlImageView F;
        private final TextView G;
        private final TextView H;

        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.guild.client.connect.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes12.dex */
        class ViewOnClickListenerC7691a implements View.OnClickListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ View f215381d;

            ViewOnClickListenerC7691a(View view) {
                this.f215381d = view;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                if (!QQGuildUIUtil.v()) {
                    GuildClientParams guildClientParams = (GuildClientParams) view.getTag();
                    GuildClientManageFragment.Nh(this.f215381d.getContext(), guildClientParams, 1);
                    C7690a.this.n(view, guildClientParams);
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        public C7690a(View view) {
            super(view);
            view.setOnClickListener(new ViewOnClickListenerC7691a(view));
            this.E = view;
            C11728RoundRectUrlImageView c11728RoundRectUrlImageView = (C11728RoundRectUrlImageView) view.findViewById(R.id.ty_);
            this.F = c11728RoundRectUrlImageView;
            c11728RoundRectUrlImageView.setAllRadius(x.c(view.getContext(), 7.0f));
            this.G = (TextView) view.findViewById(R.id.tyf);
            this.H = (TextView) view.findViewById(R.id.ty9);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void n(View view, GuildClientParams guildClientParams) {
            HashMap hashMap = new HashMap();
            hashMap.put("sgrp_otherapp_id", guildClientParams.z());
            VideoReport.reportEvent("clck", view, hashMap);
        }

        private void o(ImageView imageView, String str) {
            imageView.setImageDrawable(URLDrawable.getDrawable(str, URLDrawable.URLDrawableOptions.obtain()));
        }

        public void m(GuildClientParams guildClientParams, int i3) {
            if (i3 == 0) {
                this.itemView.findViewById(R.id.bmt).setVisibility(4);
            } else {
                this.itemView.findViewById(R.id.bmt).setVisibility(0);
            }
            if (!TextUtils.isEmpty(guildClientParams.y())) {
                o(this.F, guildClientParams.y());
            }
            this.G.setText(guildClientParams.A());
            if (!TextUtils.isEmpty(guildClientParams.x())) {
                this.H.setText(guildClientParams.x());
            } else {
                this.H.setVisibility(8);
            }
            this.E.setTag(guildClientParams);
        }
    }

    public a(Context context) {
        this.f215380m = context;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.C.size();
    }

    public void i0() {
        this.C.clear();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(C7690a c7690a, int i3) {
        c7690a.m(this.C.get(i3), i3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public C7690a onCreateViewHolder(ViewGroup viewGroup, int i3) {
        return new C7690a(LayoutInflater.from(this.f215380m).inflate(R.layout.eje, viewGroup, false));
    }

    public void setData(List<GuildClientParams> list) {
        this.C.addAll(list);
        notifyDataSetChanged();
    }
}
