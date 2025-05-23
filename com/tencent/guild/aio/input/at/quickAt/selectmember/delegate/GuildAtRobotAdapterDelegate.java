package com.tencent.guild.aio.input.at.quickAt.selectmember.delegate;

import android.content.res.Resources;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.guild.aio.input.at.quickAt.selectmember.data.e;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.widget.GuildUserAvatarView;
import com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

/* compiled from: P */
/* loaded from: classes6.dex */
public class GuildAtRobotAdapterDelegate extends AbsListItemAdapterDelegate<e, com.tencent.guild.aio.input.at.quickAt.selectmember.data.a, b> implements View.OnClickListener {

    /* renamed from: d, reason: collision with root package name */
    private final d f111003d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QQToast.makeText(GuildAtRobotAdapterDelegate.this.f111003d.getContext(), R.string.f153981dk, 1000).show();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class b extends RecyclerView.ViewHolder {
        private final GuildUserAvatarView E;
        private final TextView F;
        private final CheckBox G;
        private final TextView H;
        private final View I;

        public b(@NonNull View view) {
            super(view);
            this.E = (GuildUserAvatarView) view.findViewById(R.id.dvo);
            this.F = (TextView) view.findViewById(R.id.tv_name);
            this.G = (CheckBox) view.findViewById(R.id.f2x);
            this.H = (TextView) view.findViewById(R.id.mde);
            this.I = view.findViewById(R.id.kab);
        }
    }

    public GuildAtRobotAdapterDelegate(d dVar) {
        this.f111003d = dVar;
    }

    private void p(b bVar) {
        if (this.f111003d.getChannelType() == 5 || this.f111003d.getChannelType() == 2) {
            q(bVar);
        }
    }

    private void q(b bVar) {
        bVar.F.setTextColor(this.f111003d.getContext().getResources().getColor(R.color.bq_));
        bVar.itemView.setBackgroundResource(R.drawable.guild_live_aio_at_common_list_item_background);
        bVar.G.setBackgroundResource(R.drawable.guild_live_add_checkbox_selector);
    }

    private void r(e eVar, b bVar) {
        if (eVar.d()) {
            bVar.G.setVisibility(0);
            bVar.G.setChecked(eVar.e());
        } else {
            bVar.G.setVisibility(8);
            bVar.G.setChecked(false);
        }
    }

    private void s(e eVar, b bVar) {
        bVar.H.setVisibility(8);
    }

    private void t(b bVar) {
        bVar.I.setVisibility(0);
    }

    private void u(b bVar, IGProUserInfo iGProUserInfo) {
        char c16;
        if (QLog.isColorLevel()) {
            QLog.i("GuildAtRobotAdapterDelegate", 2, "handleRobotState,mute:" + iGProUserInfo.getRobotMuteStatus() + ", punished:" + iGProUserInfo.getRobotPunishmentStatus() + ", testGuilds:" + iGProUserInfo.getRobotTestGuilds());
        }
        this.f111003d.getContext().getResources();
        if (iGProUserInfo.getRobotMuteStatus() != 1) {
            c16 = 0;
        } else {
            z(bVar, false);
            bVar.itemView.setOnClickListener(new a());
            c16 = '\u18ff';
        }
        int robotPunishmentStatus = iGProUserInfo.getRobotPunishmentStatus();
        if (robotPunishmentStatus != 3) {
            if (robotPunishmentStatus == 4 && !w(iGProUserInfo.getRobotTestGuilds())) {
                bVar.itemView.setLayoutParams(new ViewGroup.LayoutParams(-1, 0));
                bVar.itemView.setVisibility(8);
                bVar.itemView.requestLayout();
            }
        } else {
            bVar.itemView.setLayoutParams(new ViewGroup.LayoutParams(-1, 0));
            bVar.itemView.setVisibility(8);
            bVar.itemView.requestLayout();
        }
        if (c16 == 0) {
            z(bVar, true);
        }
    }

    private boolean w(String str) {
        return str.contains(this.f111003d.getGuildId());
    }

    private void z(b bVar, boolean z16) {
        Resources resources = this.f111003d.getContext().getResources();
        if (z16) {
            if (this.f111003d.getChannelType() != 5 && this.f111003d.getChannelType() != 2) {
                bVar.F.setTextColor(resources.getColor(R.color.qui_common_text_primary));
                return;
            } else {
                bVar.F.setTextColor(resources.getColor(R.color.bq_));
                return;
            }
        }
        if (this.f111003d.getChannelType() != 5 && this.f111003d.getChannelType() != 2) {
            bVar.F.setTextColor(resources.getColor(fn0.d.guild_skin_form_text_gray2));
        } else {
            bVar.F.setTextColor(Color.parseColor("#5D6064"));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        EventCollector.getInstance().onViewClickedBefore(view);
        e eVar = (e) view.getTag(R.id.vyv);
        this.f111003d.a(eVar);
        if (!eVar.d()) {
            if (eVar.i() != null) {
                str = eVar.i().getTinyId();
            } else {
                str = "0";
            }
            lo0.c.a("clck", view, "em_sgrp_at_select", 5, str, null, null);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public boolean j(@NonNull com.tencent.guild.aio.input.at.quickAt.selectmember.data.a aVar, @NonNull List<com.tencent.guild.aio.input.at.quickAt.selectmember.data.a> list, int i3) {
        return aVar instanceof e;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public void l(@NonNull e eVar, @NonNull b bVar, @NonNull List<Object> list) {
        bVar.itemView.setTag(R.id.vyv, eVar);
        bVar.itemView.setTag(R.id.vyw, bVar);
        bVar.itemView.setOnClickListener(this);
        bVar.E.setAvatarMeta(this.f111003d.getGuildId(), eVar.i().getTinyId(), eVar.i().getAvatarMeta());
        bVar.F.setText(so0.c.c(eVar.i()));
        r(eVar, bVar);
        t(bVar);
        s(eVar, bVar);
        u(bVar, eVar.i());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.b
    @NonNull
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public b d(@NonNull ViewGroup viewGroup) {
        b bVar = new b(LayoutInflater.from(this.f111003d.getContext()).inflate(R.layout.ezn, viewGroup, false));
        p(bVar);
        return bVar;
    }
}
