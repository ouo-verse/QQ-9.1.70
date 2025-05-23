package com.tencent.mobileqq.guild.mainframe.startpanel.leftbar.adapterdelegates;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import bs1.a;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.base.preload.LayoutLoaders;
import com.tencent.mobileqq.guild.mainframe.startpanel.GuildPicProLoaderManager;
import com.tencent.mobileqq.guild.mainframe.startpanel.leftbar.GuildLeftBarListAdapter;
import com.tencent.mobileqq.guild.mainframe.util.j;
import com.tencent.mobileqq.guild.message.unread.api.IGuildUnreadCntService;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.widget.TraceUtils;
import cs1.b;
import cs1.e;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes14.dex */
public class GuildNormalAdapterDelegate extends AbsListItemAdapterDelegate<e, b, fs1.b> implements View.OnClickListener, View.OnLongClickListener {

    /* renamed from: d, reason: collision with root package name */
    private GuildLeftBarListAdapter f227570d;

    public GuildNormalAdapterDelegate(GuildLeftBarListAdapter guildLeftBarListAdapter) {
        this.f227570d = guildLeftBarListAdapter;
    }

    private String o(e eVar) {
        String str;
        IGuildUnreadCntService.b bVar = eVar.E;
        if (bVar != null && bVar.f230840d > 0) {
            if (bVar.f230841e == 1) {
                str = String.format(QQGuildUIUtil.r(R.string.f1488210m), Long.valueOf(eVar.E.f230840d));
            } else {
                str = QQGuildUIUtil.r(R.string.f1488110l);
            }
        } else {
            str = "";
        }
        return String.format(QQGuildUIUtil.r(R.string.f1488010k), eVar.F, str);
    }

    private void s(View view, int i3, String str, boolean z16) {
        String str2;
        HashMap hashMap = new HashMap(3);
        ch.Y0(view, "em_sgrp_head", ClickPolicy.REPORT_NONE, ExposurePolicy.REPORT_NONE);
        hashMap.put("sgrp_channel_id", str);
        hashMap.put("sgrp_head_type", String.valueOf(i3));
        if (z16) {
            str2 = "1";
        } else {
            str2 = "0";
        }
        hashMap.put("sgrp_channel_press", str2);
        VideoReport.reportEvent("clck", view, hashMap);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Object tag = view.getTag(fs1.b.S);
        if (tag instanceof e) {
            e eVar = (e) tag;
            this.f227570d.r0(eVar, true);
            this.f227570d.I0(eVar, null, true);
            o02.b.c(14);
            s(view, eVar.G.d(), eVar.f391796e, false);
        } else {
            QLog.e("Guild.MF.Lt.GuildNormalAdapterDelegate", 2, "click on null data " + tag);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        EventCollector.getInstance().onViewLongClickedBefore(view);
        Object tag = view.getTag(fs1.b.S);
        this.f227570d.v0().invoke(Integer.valueOf(this.f227570d.getItems().indexOf(tag)));
        if (tag instanceof e) {
            e eVar = (e) tag;
            s(view, eVar.G.d(), eVar.f391796e, true);
        }
        EventCollector.getInstance().onViewLongClicked(view);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public boolean j(@NonNull b bVar, @NonNull List<b> list, int i3) {
        return bVar instanceof e;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public void l(@NonNull e eVar, @NonNull fs1.b bVar, @NonNull List<Object> list) {
        TraceUtils.traceBegin("leftbar_normal_onBindViewHolder");
        j.c("leftbar_normal_onBindViewHolder");
        bVar.E(eVar, list);
        List<Integer> z16 = fs1.b.z(list);
        boolean z17 = false;
        if (!z16.isEmpty()) {
            if (z16.contains(2)) {
                bVar.Q(eVar.E, eVar.f391797f);
                if (AppSetting.f99565y) {
                    bVar.itemView.setContentDescription(o(eVar));
                }
            }
        } else {
            bVar.O(eVar.G, eVar.f391797f);
            bVar.Q(eVar.E, eVar.f391797f);
            bVar.setSelected(true);
            bVar.P(eVar.H);
            if (AppSetting.f99565y) {
                bVar.itemView.setContentDescription(o(eVar));
            }
            if (QLog.isColorLevel()) {
                QLog.d("Guild.MF.Lt.GuildNormalAdapterDelegate", 2, "onBindViewHolder ", " item uiData:", eVar);
            }
        }
        GuildPicProLoaderManager g16 = GuildPicProLoaderManager.g();
        Context context = bVar.itemView.getContext();
        String str = eVar.f391796e;
        if (eVar.E.f230840d > 0) {
            z17 = true;
        }
        g16.j(context, str, z17);
        ch.Y0(bVar.itemView, "em_sgrp_head", ClickPolicy.REPORT_NONE, ExposurePolicy.REPORT_NONE);
        j.a("leftbar_normal_onBindViewHolder");
        TraceUtils.traceEnd();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.b
    @NonNull
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public fs1.b d(@NonNull ViewGroup viewGroup) {
        a.b();
        j.c("leftbar_normal_onCreateViewHolder");
        TraceUtils.traceBegin("leftbar_normal_onCreateViewHolder");
        View preloadView = LayoutLoaders.g().getPreloadView(viewGroup.getContext(), R.layout.exn, true);
        preloadView.setLayoutParams(LayoutLoaders.f());
        fs1.b bVar = new fs1.b(preloadView);
        bVar.v().setOnClickListener(this);
        bVar.v().setOnLongClickListener(this);
        TraceUtils.traceEnd();
        j.a("leftbar_normal_onCreateViewHolder");
        a.b();
        return bVar;
    }
}
