package com.tencent.mobileqq.guild.client.selectclient;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.client.selectclient.a;
import com.tencent.mobileqq.guild.client.selectclient.b;
import com.tencent.mobileqq.guild.jump.GuildJumpUtil;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.cx;
import com.tencent.mobileqq.guild.widget.C11728RoundRectUrlImageView;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes12.dex */
public class a extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final List<b.c> C = new ArrayList();

    /* renamed from: m, reason: collision with root package name */
    private final GuildSelectClientDialogFragment f215453m;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.guild.client.selectclient.a$a, reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    public static class C7697a extends RecyclerView.ViewHolder {
        private final View E;
        private final C11728RoundRectUrlImageView F;
        private final TextView G;

        public C7697a(View view, final GuildSelectClientDialogFragment guildSelectClientDialogFragment) {
            super(view);
            view.setOnClickListener(new View.OnClickListener() { // from class: mg1.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    a.C7697a.this.o(guildSelectClientDialogFragment, view2);
                }
            });
            this.E = view;
            C11728RoundRectUrlImageView c11728RoundRectUrlImageView = (C11728RoundRectUrlImageView) view.findViewById(R.id.ty_);
            this.F = c11728RoundRectUrlImageView;
            c11728RoundRectUrlImageView.setAllRadius(x.c(view.getContext(), 7.0f));
            this.G = (TextView) view.findViewById(R.id.tyf);
        }

        private void n(View view, b.c cVar) {
            VideoReport.setElementReuseIdentifier(view, cVar.a().z());
            VideoReport.setElementId(view, "em_sgrp_choose_otherapp");
            VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
            VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
            HashMap hashMap = new HashMap();
            hashMap.put("sgrp_otherapp_id", cVar.a().z());
            VideoReport.setElementParams(view, hashMap);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void o(GuildSelectClientDialogFragment guildSelectClientDialogFragment, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (!QQGuildUIUtil.v()) {
                p((b.c) view.getTag(), guildSelectClientDialogFragment);
                guildSelectClientDialogFragment.dismiss();
            }
            EventCollector.getInstance().onViewClicked(view);
        }

        private void p(b.c cVar, GuildSelectClientDialogFragment guildSelectClientDialogFragment) {
            if (cVar.a().B() == 2) {
                if (!cVar.a().t()) {
                    String a06 = cVar.a().a0();
                    Context applicationContext = MobileQQ.sMobileQQ.getApplicationContext();
                    if (!TextUtils.isEmpty(a06) && applicationContext != null) {
                        QQToast.makeText(applicationContext, 0, a06, 1).show();
                        return;
                    }
                    return;
                }
                if (!TextUtils.isEmpty(cVar.c())) {
                    GuildJumpUtil.w(guildSelectClientDialogFragment.getActivity(), cVar.c());
                    return;
                }
                return;
            }
            if (cVar.b() == 1 && !TextUtils.isEmpty(cVar.c())) {
                cx.a(guildSelectClientDialogFragment.getActivity(), cVar.c());
            } else if (cVar.b() == 0) {
                jg1.b.c((QBaseActivity) guildSelectClientDialogFragment.getActivity(), null, cVar.a());
            }
        }

        private void q(ImageView imageView, String str) {
            imageView.setImageDrawable(URLDrawable.getDrawable(str, URLDrawable.URLDrawableOptions.obtain()));
        }

        public void m(b.c cVar, int i3) {
            if (i3 == 0) {
                this.itemView.findViewById(R.id.bmt).setVisibility(4);
            } else {
                this.itemView.findViewById(R.id.bmt).setVisibility(0);
            }
            if (!TextUtils.isEmpty(cVar.a().y())) {
                q(this.F, cVar.a().y());
            }
            this.G.setText(cVar.a().A());
            this.E.setTag(cVar);
            n(this.itemView, cVar);
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class b extends RecyclerView.ViewHolder {
        public b(@NonNull View view) {
            super(view);
        }
    }

    public a(GuildSelectClientDialogFragment guildSelectClientDialogFragment) {
        this.f215453m = guildSelectClientDialogFragment;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.C.isEmpty()) {
            return 1;
        }
        return this.C.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        if (this.C.isEmpty()) {
            return 0;
        }
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i3) {
        if (viewHolder instanceof C7697a) {
            ((C7697a) viewHolder).m(this.C.get(i3), i3);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i3) {
        if (this.C.isEmpty() && i3 == 0) {
            return new b(LayoutInflater.from(this.f215453m.getActivity()).inflate(R.layout.f88, viewGroup, false));
        }
        return new C7697a(LayoutInflater.from(this.f215453m.getActivity()).inflate(R.layout.eji, viewGroup, false), this.f215453m);
    }

    public void setData(List<b.c> list) {
        this.C.addAll(list);
        notifyDataSetChanged();
    }
}
