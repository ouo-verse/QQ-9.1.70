package com.tencent.mobileqq.guild.client.manage;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.client.GuildClientConfig;
import com.tencent.mobileqq.guild.client.GuildClientParams;
import com.tencent.mobileqq.guild.jump.GuildJumpUtil;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public class a extends RecyclerView.Adapter<b> implements CompoundButton.OnCheckedChangeListener {
    private GuildClientManageFragment C;
    private final GuildClientManageViewModel D;
    private GuildClientParams E;
    private List<GuildClientConfig> F = new ArrayList();

    /* renamed from: m, reason: collision with root package name */
    private final Context f215407m;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.guild.client.manage.a$a, reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    class C7693a implements Observer<Object[]> {
        C7693a() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Object[] objArr) {
            int intValue = ((Integer) objArr[0]).intValue();
            int intValue2 = ((Integer) objArr[1]).intValue();
            for (GuildClientConfig guildClientConfig : a.this.F) {
                if (guildClientConfig.c() == intValue) {
                    guildClientConfig.a(intValue2);
                }
            }
            a.this.notifyDataSetChanged();
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class b extends RecyclerView.ViewHolder {
        public b(FormSwitchItem formSwitchItem, CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
            super(formSwitchItem);
            formSwitchItem.setOnCheckedChangeListener(onCheckedChangeListener);
            formSwitchItem.setListBackground(ContextCompat.getDrawable(formSwitchItem.getContext(), R.drawable.guild_drawable_rect_ffffff_1d1d20));
            formSwitchItem.setCloseVipTheme(true);
        }

        private void m(View view, GuildClientConfig guildClientConfig) {
            int i3;
            VideoReport.setElementReuseIdentifier(view, String.valueOf(guildClientConfig.c()));
            VideoReport.setElementId(view, "em_sgrp_otherapp_functionswitch");
            VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
            VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
            HashMap hashMap = new HashMap();
            if (guildClientConfig.e()) {
                i3 = 1;
            } else {
                i3 = 2;
            }
            hashMap.put("sgrp_switch_type", Integer.valueOf(i3));
            hashMap.put("sgrp_otherapp_functionswitch_name", guildClientConfig.b());
            VideoReport.setElementParams(view, hashMap);
        }

        public void l(GuildClientConfig guildClientConfig, int i3, int i16) {
            FormSwitchItem formSwitchItem = (FormSwitchItem) this.itemView;
            n(formSwitchItem, i3, i16);
            formSwitchItem.setText(guildClientConfig.b());
            formSwitchItem.getSwitch().setTag(guildClientConfig);
            formSwitchItem.setChecked(guildClientConfig.e());
            m(formSwitchItem.getSwitch(), guildClientConfig);
        }

        public void n(FormSwitchItem formSwitchItem, int i3, int i16) {
            if (i3 == 0 && i16 == 1) {
                formSwitchItem.setBgType(0);
                return;
            }
            if (i3 == 0) {
                formSwitchItem.setBgType(1);
            } else if (i3 == i16 - 1) {
                formSwitchItem.setBgType(3);
            } else {
                formSwitchItem.setBgType(2);
            }
        }
    }

    public a(GuildClientManageFragment guildClientManageFragment, GuildClientParams guildClientParams, GuildClientManageViewModel guildClientManageViewModel) {
        this.f215407m = guildClientManageFragment.getContext();
        this.C = guildClientManageFragment;
        this.D = guildClientManageViewModel;
        this.E = guildClientParams;
        guildClientManageViewModel.X1().observe(guildClientManageFragment.getViewLifecycleOwner(), new C7693a());
    }

    private void l0(CompoundButton compoundButton, boolean z16, GuildClientConfig guildClientConfig) {
        int i3;
        if (z16 != guildClientConfig.e()) {
            GuildClientManageViewModel guildClientManageViewModel = this.D;
            guildClientManageViewModel.f2(guildClientManageViewModel.T1(), guildClientConfig.c(), z16);
            VideoReport.setElementId(compoundButton, "em_sgrp_otherapp_functionswitch");
            HashMap hashMap = new HashMap();
            hashMap.put("sgrp_otherapp_functionswitch_name", guildClientConfig.b());
            if (z16) {
                i3 = 1;
            } else {
                i3 = 2;
            }
            hashMap.put("sgrp_sub_channel_switch", Integer.valueOf(i3));
            VideoReport.reportEvent("clck", compoundButton, hashMap);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.F.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(b bVar, int i3) {
        bVar.l(this.F.get(i3), i3, getNUM_BACKGOURND_ICON());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public b onCreateViewHolder(ViewGroup viewGroup, int i3) {
        return new b(new FormSwitchItem(this.f215407m), this);
    }

    public void m0(GuildClientParams guildClientParams) {
        this.E = guildClientParams;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        GuildClientConfig guildClientConfig = (GuildClientConfig) compoundButton.getTag();
        if (this.E.B() == 2) {
            boolean e16 = guildClientConfig.e();
            String f16 = guildClientConfig.f();
            QLog.i("Guild.client.GuildClientConfigAdapter", 1, "onCheckedChanged status," + e16 + ", jumpUrl: " + f16);
            if (!e16 && !TextUtils.isEmpty(f16)) {
                Context context = this.f215407m;
                if (context instanceof Activity) {
                    GuildJumpUtil.w((Activity) context, f16);
                } else {
                    GuildJumpUtil.w(null, f16);
                }
                compoundButton.setChecked(false);
                this.C.Ph(true);
            } else {
                l0(compoundButton, z16, guildClientConfig);
            }
        } else {
            l0(compoundButton, z16, guildClientConfig);
        }
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    public void setData(@NonNull List<GuildClientConfig> list) {
        this.F.clear();
        this.F.addAll(list);
        notifyDataSetChanged();
    }
}
