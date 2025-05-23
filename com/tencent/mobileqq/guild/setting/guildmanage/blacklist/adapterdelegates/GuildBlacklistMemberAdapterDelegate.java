package com.tencent.mobileqq.guild.setting.guildmanage.blacklist.adapterdelegates;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.setting.guildmanage.blacklist.adapterdelegates.GuildBlacklistMemberAdapterDelegate;
import com.tencent.mobileqq.guild.setting.guildmanage.blacklist.p;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.widget.GuildUserAvatarView;
import com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import fz1.b;
import fz1.e;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes14.dex */
public class GuildBlacklistMemberAdapterDelegate extends AbsListItemAdapterDelegate<e, b, a> implements View.OnClickListener {

    /* renamed from: d, reason: collision with root package name */
    private final p f233713d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public static class a extends RecyclerView.ViewHolder {
        public GuildUserAvatarView E;
        public TextView F;
        public ImageView G;

        public a(@NonNull View view) {
            super(view);
            this.E = (GuildUserAvatarView) view.findViewById(R.id.a2o);
            this.F = (TextView) view.findViewById(R.id.eos);
            this.G = (ImageView) view.findViewById(R.id.f83754ke);
        }
    }

    public GuildBlacklistMemberAdapterDelegate(p pVar) {
        this.f233713d = pVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public boolean j(@NonNull b bVar, @NonNull List<b> list, int i3) {
        return bVar instanceof e;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getTag() instanceof e) {
            e eVar = (e) view.getTag();
            this.f233713d.E1(eVar.c(), eVar.b());
            VideoReport.reportEvent("clck", view, new HashMap());
        }
        EventCollector.getInstance().onViewClicked(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public void l(@NonNull e eVar, @NonNull a aVar, @NonNull List<Object> list) {
        aVar.F.setText(eVar.b());
        aVar.E.setAvatarTinyId("0", eVar.c());
        aVar.G.setTag(eVar);
        ch.Y0(aVar.G, "em_sgrp_more_action", ClickPolicy.REPORT_NONE, ExposurePolicy.REPORT_NONE);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.b
    @NonNull
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public a d(@NonNull ViewGroup viewGroup) {
        a aVar = new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.eh5, viewGroup, false));
        aVar.G.setOnClickListener(new View.OnClickListener() { // from class: ez1.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildBlacklistMemberAdapterDelegate.this.onClick(view);
            }
        });
        return aVar;
    }
}
