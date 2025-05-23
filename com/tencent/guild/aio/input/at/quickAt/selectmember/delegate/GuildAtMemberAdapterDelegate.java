package com.tencent.guild.aio.input.at.quickAt.selectmember.delegate;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.widget.GuildUserAvatarView;
import com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProRoleManagementTag;
import com.tencent.mobileqq.util.x;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes6.dex */
public class GuildAtMemberAdapterDelegate extends AbsListItemAdapterDelegate<com.tencent.guild.aio.input.at.quickAt.selectmember.data.d, com.tencent.guild.aio.input.at.quickAt.selectmember.data.a, a> implements View.OnClickListener {

    /* renamed from: d, reason: collision with root package name */
    private final d f111002d;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class a extends RecyclerView.ViewHolder {
        private final GuildUserAvatarView E;
        private final TextView F;
        private final CheckBox G;
        private final TextView H;

        public a(@NonNull View view) {
            super(view);
            this.E = (GuildUserAvatarView) view.findViewById(R.id.dvo);
            this.F = (TextView) view.findViewById(R.id.tv_name);
            this.G = (CheckBox) view.findViewById(R.id.f2x);
            this.H = (TextView) view.findViewById(R.id.mde);
        }
    }

    public GuildAtMemberAdapterDelegate(d dVar) {
        this.f111002d = dVar;
    }

    private void o(a aVar) {
        if (this.f111002d.getChannelType() == 5 || this.f111002d.getChannelType() == 2) {
            p(aVar);
        }
    }

    private void p(a aVar) {
        aVar.F.setTextColor(this.f111002d.getContext().getResources().getColor(R.color.bq_));
        aVar.itemView.setBackgroundResource(R.drawable.guild_live_aio_at_common_list_item_background);
        aVar.G.setBackgroundResource(R.drawable.guild_live_add_checkbox_selector);
    }

    public static Drawable q(int i3) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i3);
        gradientDrawable.setCornerRadius(x.c(MobileQQ.sMobileQQ, 2.0f));
        return gradientDrawable;
    }

    private void r(com.tencent.guild.aio.input.at.quickAt.selectmember.data.d dVar, a aVar) {
        if (dVar.d()) {
            aVar.G.setVisibility(0);
            aVar.G.setChecked(dVar.e());
        } else {
            aVar.G.setVisibility(8);
            aVar.G.setChecked(false);
        }
    }

    private void s(com.tencent.guild.aio.input.at.quickAt.selectmember.data.d dVar, a aVar) {
        IGProRoleManagementTag roleManagementTag = dVar.i().getRoleManagementTag();
        if (roleManagementTag != null && !TextUtils.isEmpty(roleManagementTag.getTagName())) {
            aVar.H.setBackground(q(((int) roleManagementTag.getColor()) | (-16777216)));
            aVar.H.setText(roleManagementTag.getTagName());
            aVar.H.setVisibility(0);
            return;
        }
        aVar.H.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        EventCollector.getInstance().onViewClickedBefore(view);
        com.tencent.guild.aio.input.at.quickAt.selectmember.data.d dVar = (com.tencent.guild.aio.input.at.quickAt.selectmember.data.d) view.getTag(R.id.vyv);
        this.f111002d.a(dVar);
        if (!dVar.d()) {
            if (dVar.i() != null) {
                str = dVar.i().getTinyId();
            } else {
                str = "0";
            }
            lo0.c.a("clck", view, "em_sgrp_at_select", 4, str, null, null);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public boolean j(@NonNull com.tencent.guild.aio.input.at.quickAt.selectmember.data.a aVar, @NonNull List<com.tencent.guild.aio.input.at.quickAt.selectmember.data.a> list, int i3) {
        return aVar instanceof com.tencent.guild.aio.input.at.quickAt.selectmember.data.d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public void l(@NonNull com.tencent.guild.aio.input.at.quickAt.selectmember.data.d dVar, @NonNull a aVar, @NonNull List<Object> list) {
        aVar.itemView.setTag(R.id.vyv, dVar);
        aVar.itemView.setTag(R.id.vyw, aVar);
        aVar.itemView.setOnClickListener(this);
        aVar.E.setAvatarMeta(this.f111002d.getGuildId(), dVar.i().getTinyId(), dVar.i().getAvatarMeta());
        aVar.F.setText(so0.c.c(dVar.i()));
        r(dVar, aVar);
        s(dVar, aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.b
    @NonNull
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public a d(@NonNull ViewGroup viewGroup) {
        a aVar = new a(LayoutInflater.from(this.f111002d.getContext()).inflate(R.layout.ezh, viewGroup, false));
        o(aVar);
        return aVar;
    }
}
