package com.tencent.mobileqq.guild.feed.widget.sort;

import android.animation.AnimatorInflater;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedBaseInitBean;
import com.tencent.mobileqq.guild.feed.manager.GuildInfoManager;
import com.tencent.mobileqq.guild.feed.viewmodel.j;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.guild.util.IGuildFastClickUtilApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes13.dex */
public class GuildFeedListSortViewController implements g, RadioGroup.OnCheckedChangeListener {
    private j C;
    private Context D;
    private GuildFeedBaseInitBean F;

    /* renamed from: d, reason: collision with root package name */
    private RadioGroup f224326d;

    /* renamed from: e, reason: collision with root package name */
    private RadioButton f224327e;

    /* renamed from: f, reason: collision with root package name */
    private RadioButton f224328f;

    /* renamed from: h, reason: collision with root package name */
    private TextView f224329h;

    /* renamed from: i, reason: collision with root package name */
    private View f224330i;

    /* renamed from: m, reason: collision with root package name */
    private int f224331m = 1;
    private final Observer<Integer> E = new Observer() { // from class: com.tencent.mobileqq.guild.feed.widget.sort.b
        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object obj) {
            GuildFeedListSortViewController.this.g(((Integer) obj).intValue());
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        HashMap hashMap = new HashMap();
        RadioButton radioButton = this.f224328f;
        ClickPolicy clickPolicy = ClickPolicy.REPORT_NONE;
        ExposurePolicy exposurePolicy = ExposurePolicy.REPORT_ALL;
        EndExposurePolicy endExposurePolicy = EndExposurePolicy.REPORT_NONE;
        com.tencent.mobileqq.guild.feed.report.d.d(radioButton, "em_sgrp_forum_sort_new", clickPolicy, exposurePolicy, endExposurePolicy, hashMap);
        com.tencent.mobileqq.guild.feed.report.d.d(this.f224327e, "em_sgrp_forum_sort_hot", clickPolicy, exposurePolicy, endExposurePolicy, hashMap);
        com.tencent.mobileqq.guild.feed.report.d.e(this.f224330i, "em_sgrp_forum_sort_new_type", ClickPolicy.REPORT_ALL, exposurePolicy, endExposurePolicy, hashMap, new IDynamicParams() { // from class: com.tencent.mobileqq.guild.feed.widget.sort.a
            @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
            public final Map getDynamicParams(String str) {
                Map k3;
                k3 = GuildFeedListSortViewController.this.k(str);
                return k3;
            }
        });
    }

    private void e(int i3) {
        if (i3 == 2) {
            if (!this.f224327e.isChecked()) {
                this.f224327e.setChecked(true);
                VideoReport.reportEvent("clck", this.f224327e, null);
            }
        } else if (!this.f224328f.isChecked()) {
            this.f224328f.setChecked(true);
            VideoReport.reportEvent("clck", this.f224328f, null);
        }
        QLog.i("Guild_Feed_GuildFeedListSortWidget", 1, "changeSortViewChecked: mode[" + i3 + "]");
        n(i3);
    }

    private boolean f() {
        return ((IGuildFastClickUtilApi) QRoute.api(IGuildFastClickUtilApi.class)).isFastClick("Guild_Feed_GuildFeedListSortWidget");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(int i3) {
        e(i3);
        m(i3);
    }

    private void h() {
        this.f224330i.setOnClickListener(this);
        this.f224326d.setOnCheckedChangeListener(this);
    }

    private void i(GuildFeedBaseInitBean guildFeedBaseInitBean) {
        g(GuildInfoManager.q().x(guildFeedBaseInitBean));
    }

    private void j(View view) {
        this.f224326d = (RadioGroup) view.findViewById(R.id.f166790m62);
        this.f224327e = (RadioButton) view.findViewById(R.id.x16);
        this.f224328f = (RadioButton) view.findViewById(R.id.f165631x15);
        this.f224330i = view.findViewById(R.id.x18);
        TextView textView = (TextView) view.findViewById(R.id.x17);
        this.f224329h = textView;
        textView.setTextColor(AppCompatResources.getColorStateList(view.getContext(), R.color.qui_common_text_primary));
        ((ImageView) view.findViewById(R.id.x19)).setImageDrawable(GuildUIUtils.w(view.getContext(), R.drawable.guild_feed_sort_icon, Integer.valueOf(R.color.qui_common_text_primary)));
        if (Build.VERSION.SDK_INT >= 26) {
            this.f224330i.setStateListAnimator(AnimatorInflater.loadStateListAnimator(view.getContext(), R.animator.f155134n));
        }
        h();
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.widget.sort.GuildFeedListSortViewController.1
            @Override // java.lang.Runnable
            public void run() {
                GuildFeedListSortViewController.this.d();
            }
        }, 16, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Map k(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("sgrp_forum_sort_new_type", Integer.valueOf(this.f224331m));
        return hashMap;
    }

    private void l(int i3) {
        if (this.f224330i == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        if (i3 == 1) {
            this.f224331m = 2;
        } else if (i3 == 3) {
            this.f224331m = 1;
        }
        hashMap.put("sgrp_forum_sort_new_type", Integer.valueOf(this.f224331m));
        VideoReport.reportEvent("clck", this.f224330i, hashMap);
    }

    private void m(int i3) {
        if (i3 != 1 && i3 != 3) {
            this.f224330i.setVisibility(8);
            return;
        }
        this.f224330i.setVisibility(0);
        if (i3 == 1) {
            this.f224329h.setText(this.D.getText(R.string.f145400rd));
        } else {
            this.f224329h.setText(this.D.getText(R.string.f145450ri));
        }
        l(i3);
    }

    private void n(int i3) {
        this.f224327e.setTypeface(Typeface.defaultFromStyle(0));
        this.f224328f.setTypeface(Typeface.defaultFromStyle(0));
        if (i3 == 2) {
            this.f224327e.setTypeface(Typeface.defaultFromStyle(1));
            this.f224327e.setAlpha(1.0f);
            this.f224328f.setAlpha(1.0f);
        } else {
            this.f224328f.setTypeface(Typeface.defaultFromStyle(1));
            this.f224328f.setAlpha(1.0f);
            this.f224327e.setAlpha(1.0f);
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.widget.sort.g
    public void N7(View view, GuildFeedBaseInitBean guildFeedBaseInitBean) {
        this.D = view.getContext();
        this.F = guildFeedBaseInitBean;
        j(view);
        j jVar = this.C;
        if (jVar == null) {
            return;
        }
        jVar.L1().observeForever(this.E);
        if (guildFeedBaseInitBean != null) {
            this.C.N1(guildFeedBaseInitBean);
        }
        i(guildFeedBaseInitBean);
    }

    @Override // com.tencent.mobileqq.guild.feed.widget.sort.g
    public void b2(j jVar) {
        this.C = jVar;
    }

    @Override // com.tencent.mobileqq.guild.feed.widget.sort.g
    public void destroy() {
        j jVar = this.C;
        if (jVar != null) {
            jVar.L1().removeObserver(this.E);
        }
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public void onCheckedChanged(RadioGroup radioGroup, int i3) {
        EventCollector.getInstance().onRadioGroupCheckedBefore(radioGroup, i3);
        if (this.f224327e.getId() == i3) {
            QLog.i("Guild_Feed_GuildFeedListSortWidget", 1, "onCheckedChanged: mode popularity");
            this.C.Q1();
            this.f224330i.setVisibility(8);
        } else if (this.f224328f.getId() == i3) {
            QLog.i("Guild_Feed_GuildFeedListSortWidget", 1, "onCheckedChanged: mode new");
            this.C.P1();
            this.f224330i.setVisibility(0);
        } else {
            QLog.e("Guild_Feed_GuildFeedListSortWidget", 1, "onCheckedChanged: error");
        }
        EventCollector.getInstance().onRadioGroupChecked(radioGroup, i3);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (f()) {
            QLog.i("Guild_Feed_GuildFeedListSortWidget", 1, "onClick: click too fast!");
        } else if (view.getId() == R.id.x18) {
            this.C.R1();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.guild.feed.widget.sort.g
    public void updateView() {
        i(this.F);
    }
}
