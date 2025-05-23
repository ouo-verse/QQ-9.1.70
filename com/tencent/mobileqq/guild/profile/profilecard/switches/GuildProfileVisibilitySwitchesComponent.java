package com.tencent.mobileqq.guild.profile.profilecard.switches;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.data.profilecard.GuildProfileData;
import com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.component.AbsGuildProfileComponent;
import com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.controller.IGuildComponentController;
import com.tencent.mobileqq.guild.profile.profilecard.switches.GuildProfileVisibilitySwitchesComponent;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.security.SecurityTipHelperKt;
import com.tencent.mobileqq.mvvm.h;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.widget.Switch;
import dw1.f;
import java.util.HashMap;
import java.util.Map;
import ri1.a;
import vp1.ct;

/* loaded from: classes14.dex */
public class GuildProfileVisibilitySwitchesComponent extends AbsGuildProfileComponent implements CompoundButton.OnCheckedChangeListener {
    private static final String TAG = "Guild.profile.GuildProfileVisibilitySwitchesComponent";
    private ct binding;
    private boolean joinedGuildSwitchLiveDataNoValue;
    private f model;
    private boolean publishedFeedSwitchLiveDataNoValue;

    public GuildProfileVisibilitySwitchesComponent(IGuildComponentController iGuildComponentController, GuildProfileData guildProfileData) {
        super(iGuildComponentController, guildProfileData);
        this.publishedFeedSwitchLiveDataNoValue = true;
        this.joinedGuildSwitchLiveDataNoValue = true;
    }

    private Map<String, Object> getSwitchButtonDtParams(boolean z16) {
        int i3;
        HashMap hashMap = new HashMap();
        if (z16) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        hashMap.put("sgrp_switch_condition", Integer.valueOf(i3));
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$onCreate$0(Fragment fragment, a aVar) {
        SecurityTipHelperKt.z(fragment.getContext(), aVar.f431477a, aVar.f431478b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$1(Boolean bool) {
        this.binding.f442799c.setChecked(bool.booleanValue());
        if (this.publishedFeedSwitchLiveDataNoValue) {
            this.publishedFeedSwitchLiveDataNoValue = false;
            Switch r36 = this.binding.f442799c;
            VideoReport.reportEvent("imp", r36, getSwitchButtonDtParams(r36.isChecked()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$2(Boolean bool) {
        this.binding.f442800d.setChecked(bool.booleanValue());
        if (this.joinedGuildSwitchLiveDataNoValue) {
            this.joinedGuildSwitchLiveDataNoValue = false;
            Switch r36 = this.binding.f442800d;
            VideoReport.reportEvent("imp", r36, getSwitchButtonDtParams(r36.isChecked()));
        }
    }

    private void setDtElement() {
        Switch r06 = this.binding.f442799c;
        ClickPolicy clickPolicy = ClickPolicy.REPORT_NONE;
        ExposurePolicy exposurePolicy = ExposurePolicy.REPORT_NONE;
        ch.Y0(r06, "em_sgrp_show_forum_switch", clickPolicy, exposurePolicy);
        ch.Y0(this.binding.f442800d, "em_sgrp_show_channel_switch", clickPolicy, exposurePolicy);
    }

    @Override // com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.component.AbsGuildProfileComponent
    /* renamed from: getComponentName */
    public String getTAG() {
        return TAG;
    }

    @Override // com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.component.AbsGuildProfileComponent
    public int getComponentType() {
        return 1009;
    }

    @Override // com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.component.AbsGuildProfileComponent
    public int getContentLayoutId() {
        return R.layout.f26;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        ct ctVar = this.binding;
        if (compoundButton == ctVar.f442799c) {
            this.model.W1(z16);
            VideoReport.reportEvent("dt_clck", this.binding.f442799c, getSwitchButtonDtParams(z16));
        } else if (compoundButton == ctVar.f442800d) {
            this.model.U1(z16);
            VideoReport.reportEvent("dt_clck", this.binding.f442800d, getSwitchButtonDtParams(z16));
        }
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    @Override // com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.component.AbsGuildProfileComponent
    public void onCreate(final Fragment fragment, AppInterface appInterface, Bundle bundle) {
        super.onCreate(fragment, appInterface, bundle);
        this.model = (f) h.a(this.mFragment).get(f.class);
        ct e16 = ct.e(m193getContainerView());
        this.binding = e16;
        e16.f442799c.setOnCheckedChangeListener(this);
        this.binding.f442800d.setOnCheckedChangeListener(this);
        setDtElement();
        this.model.P1().observe(fragment.getViewLifecycleOwner(), new Observer() { // from class: dw1.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildProfileVisibilitySwitchesComponent.lambda$onCreate$0(Fragment.this, (ri1.a) obj);
            }
        });
        this.model.R1().observe(fragment.getViewLifecycleOwner(), new Observer() { // from class: dw1.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildProfileVisibilitySwitchesComponent.this.lambda$onCreate$1((Boolean) obj);
            }
        });
        this.model.Q1().observe(fragment.getViewLifecycleOwner(), new Observer() { // from class: dw1.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildProfileVisibilitySwitchesComponent.this.lambda$onCreate$2((Boolean) obj);
            }
        });
    }

    @Override // com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.component.AbsGuildProfileComponent, com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.component.a
    public void onResume() {
        super.onResume();
        if (this.model.R1().getValue() != null) {
            Switch r06 = this.binding.f442799c;
            VideoReport.reportEvent("imp", r06, getSwitchButtonDtParams(r06.isChecked()));
        }
        if (this.model.Q1().getValue() != null) {
            Switch r07 = this.binding.f442800d;
            VideoReport.reportEvent("imp", r07, getSwitchButtonDtParams(r07.isChecked()));
        }
    }

    @Override // com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.component.AbsGuildProfileComponent
    public void onUpdateData(GuildProfileData guildProfileData) {
    }

    @Override // com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.component.AbsGuildProfileComponent
    public void onInitData(GuildProfileData guildProfileData) {
        if (guildProfileData.isDirectMessage()) {
            LinearLayout root = this.binding.getRoot();
            int childCount = root.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                root.getChildAt(i3).setVisibility(8);
            }
            this.binding.f442798b.setVisibility(0);
            this.binding.f442801e.setVisibility(0);
            this.binding.f442801e.setBackgroundResource(R.drawable.qui_common_fill_light_secondary_round_8_bg_selector);
        }
    }

    public GuildProfileVisibilitySwitchesComponent() {
        super(null, null);
        this.publishedFeedSwitchLiveDataNoValue = true;
        this.joinedGuildSwitchLiveDataNoValue = true;
    }
}
