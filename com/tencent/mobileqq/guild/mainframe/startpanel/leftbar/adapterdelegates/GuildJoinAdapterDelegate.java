package com.tencent.mobileqq.guild.mainframe.startpanel.leftbar.adapterdelegates;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.base.preload.LayoutLoaders;
import com.tencent.mobileqq.guild.mainframe.startpanel.leftbar.GuildLeftBarListAdapter;
import com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cs1.b;
import cs1.c;
import java.util.List;

/* compiled from: P */
/* loaded from: classes14.dex */
public class GuildJoinAdapterDelegate extends AbsListItemAdapterDelegate<c, b, fs1.b> implements View.OnClickListener {

    /* renamed from: d, reason: collision with root package name */
    private GuildLeftBarListAdapter f227569d;

    public GuildJoinAdapterDelegate(GuildLeftBarListAdapter guildLeftBarListAdapter) {
        this.f227569d = guildLeftBarListAdapter;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public boolean j(@NonNull b bVar, @NonNull List<b> list, int i3) {
        return bVar instanceof c;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Object tag = view.getTag(fs1.b.S);
        if (tag instanceof c) {
            this.f227569d.r0((c) tag, true);
            o02.b.c(14);
        } else {
            QLog.e("Guild.MF.Lt.GuildJoinAdapterDelegate", 2, "click on null data ", tag);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public void l(@NonNull c cVar, @NonNull fs1.b bVar, @NonNull List<Object> list) {
        bVar.E(cVar, list);
        if (AppSetting.f99565y) {
            bVar.itemView.setContentDescription(cVar.F);
        }
        if (QLog.isColorLevel()) {
            QLog.e("Guild.MF.Lt.GuildJoinAdapterDelegate", 1, "onBindViewHolder item uiData:", cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.b
    @NonNull
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public fs1.b d(@NonNull ViewGroup viewGroup) {
        View preloadView = LayoutLoaders.g().getPreloadView(viewGroup.getContext(), R.layout.exn, true);
        preloadView.setLayoutParams(LayoutLoaders.f());
        fs1.b bVar = new fs1.b(preloadView);
        bVar.v().setOnClickListener(this);
        return bVar;
    }
}
