package com.tencent.mobileqq.guild.client.titledisplay;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.client.titledisplay.c;
import com.tencent.mobileqq.guild.client.widget.GuildClientIdentityView;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.data.IGProIdentityInfo;
import com.tencent.mobileqq.qqguildsdk.data.da;
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
public class c extends BaseAdapter implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: d, reason: collision with root package name */
    private final List<da> f215468d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    private int f215469e = 0;

    /* renamed from: f, reason: collision with root package name */
    private final GuildClientTitleDisplaySettingFragment f215470f;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        private View f215471a;

        /* renamed from: b, reason: collision with root package name */
        private TextView f215472b;

        /* renamed from: c, reason: collision with root package name */
        private CheckBox f215473c;

        /* renamed from: d, reason: collision with root package name */
        private GuildClientIdentityView f215474d;

        a() {
        }

        private void c(da daVar) {
            IGProIdentityInfo e16 = e(daVar);
            if (e16 != null) {
                this.f215474d.a(e16);
            }
        }

        private IGProIdentityInfo e(da daVar) {
            if (daVar.a() != null && daVar.a().getIdentityList() != null) {
                for (IGProIdentityInfo iGProIdentityInfo : daVar.a().getIdentityList()) {
                    if (iGProIdentityInfo.getType() == 0 || iGProIdentityInfo.getType() == 1 || iGProIdentityInfo.getIdentityType() == 2) {
                        return iGProIdentityInfo;
                    }
                }
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void g(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (!QQGuildUIUtil.v()) {
                ((CheckBox) view.findViewById(R.id.tva)).setChecked(true);
            }
            EventCollector.getInstance().onViewClicked(view);
        }

        public void d(Context context, int i3, da daVar, int i16) {
            this.f215471a.setBackgroundResource(R.drawable.guild_client_item_top_border_bg_left_16dp);
            this.f215473c.setTag(Integer.valueOf(i3));
            if (i16 == i3) {
                this.f215473c.setChecked(true);
                this.f215473c.setVisibility(0);
            } else {
                this.f215473c.setChecked(false);
                this.f215473c.setVisibility(8);
            }
            this.f215474d.setVisibility(8);
            if (i3 != 0) {
                this.f215472b.setText(daVar.getClientName());
                c(daVar);
            } else {
                this.f215472b.setText(context.getString(R.string.f139680bx));
            }
        }

        public View f(ViewGroup viewGroup) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.ejo, (ViewGroup) null);
            inflate.setTag(this);
            this.f215472b = (TextView) inflate.findViewById(R.id.tyh);
            this.f215473c = (CheckBox) inflate.findViewById(R.id.tva);
            this.f215474d = (GuildClientIdentityView) inflate.findViewById(R.id.tya);
            inflate.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.client.titledisplay.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    c.a.g(view);
                }
            });
            ch.Y0(inflate, "em_sgrp_otherapp_identity_choose", ClickPolicy.REPORT_NONE, ExposurePolicy.REPORT_NONE);
            this.f215471a = inflate;
            return inflate;
        }
    }

    public c(GuildClientTitleDisplaySettingFragment guildClientTitleDisplaySettingFragment) {
        this.f215470f = guildClientTitleDisplaySettingFragment;
        guildClientTitleDisplaySettingFragment.f215462c0.W1().observe(guildClientTitleDisplaySettingFragment.getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.guild.client.titledisplay.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                c.this.setData((List) obj);
            }
        });
    }

    private int b(da daVar) {
        for (int i3 = 1; i3 < this.f215468d.size(); i3++) {
            if (this.f215468d.get(i3).getClientId().equals(daVar.getClientId())) {
                return i3;
            }
        }
        return 0;
    }

    @Override // android.widget.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public da getItem(int i3) {
        if (this.f215468d.size() > i3) {
            return this.f215468d.get(i3);
        }
        return null;
    }

    public void c() {
        this.f215469e = 0;
        notifyDataSetChanged();
    }

    public void d(da daVar) {
        this.f215469e = b(daVar);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f215468d.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        return i3;
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        View view2;
        a aVar;
        if (view == null) {
            aVar = new a();
            view2 = aVar.f(viewGroup);
        } else {
            view2 = view;
            aVar = (a) view.getTag();
        }
        da item = getItem(i3);
        if (item != null && !TextUtils.isEmpty(item.getClientId())) {
            aVar.d(this.f215470f.getContext(), i3, item, this.f215469e);
            aVar.f215473c.setOnCheckedChangeListener(this);
        }
        EventCollector.getInstance().onListGetView(i3, view2, viewGroup, getItemId(i3));
        return view2;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        if (z16 && ((Integer) compoundButton.getTag()).intValue() != this.f215469e) {
            int intValue = ((Integer) compoundButton.getTag()).intValue();
            this.f215469e = intValue;
            da item = getItem(intValue);
            if (item == null) {
                QLog.w("GuildClientTitleDisplaySettingListAdapter", 1, "onCheckedChanged but clientInfo is null");
            } else {
                String clientId = item.getClientId();
                if (this.f215469e == 0) {
                    clientId = "0";
                }
                HashMap hashMap = new HashMap();
                hashMap.put("sgrp_otherapp_id", clientId);
                VideoReport.reportEvent("clck", compoundButton.getParent(), hashMap);
                this.f215470f.f215462c0.e2(clientId);
                notifyDataSetChanged();
            }
        }
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    public void setData(List<da> list) {
        if (list.isEmpty()) {
            return;
        }
        this.f215468d.clear();
        this.f215468d.add(0, list.get(0));
        this.f215468d.addAll(list);
        notifyDataSetChanged();
    }
}
