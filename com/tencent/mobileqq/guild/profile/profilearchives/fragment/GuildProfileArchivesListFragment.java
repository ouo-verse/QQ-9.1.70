package com.tencent.mobileqq.guild.profile.profilearchives.fragment;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.avcore.netchannel.INetChannelCallback;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.guild.api.impl.GuildDTReportApiImpl;
import com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment;
import com.tencent.mobileqq.guild.data.w;
import com.tencent.mobileqq.guild.profile.profilearchives.fragment.GuildProfileArchivesListFragment;
import com.tencent.mobileqq.guild.profile.profilearchives.viewmodel.GuildProfileArchivesViewModel;
import com.tencent.mobileqq.guild.util.report.b;
import com.tencent.mobileqq.guild.widget.OverScrollRecyclerView;
import com.tencent.mobileqq.mvvm.h;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import gf1.f;
import java.util.HashMap;
import mqq.app.MobileQQ;

/* loaded from: classes14.dex */
public class GuildProfileArchivesListFragment extends QQGuildCustomTitleBarFragment {
    private OverScrollRecyclerView T;
    private pv1.a U;
    private GuildProfileArchivesViewModel V;
    private String W;
    private boolean Y;

    @Nullable
    private String X = "";
    private int Z = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes14.dex */
    public class a extends RecyclerView.OnScrollListener {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i3) {
            super.onScrollStateChanged(recyclerView, i3);
            if (i3 == 0) {
                VideoReport.traversePage(GuildProfileArchivesListFragment.this.T);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Gh(Boolean bool) {
        if (bool.booleanValue()) {
            this.U.S0(this.V.getGuildArchivesList());
            VideoReport.traversePage(this.T);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Hh(Boolean bool) {
        if (bool.booleanValue()) {
            this.U.y0().r();
        } else {
            this.U.y0().q();
        }
    }

    private void Ih() {
        VideoReport.setPageId(this.N, "pg_sgrp_otherapp_manage");
        VideoReport.setElementId(this.C, "em_sgrp_auditset_back");
        GuildDTReportApiImpl guildDTReportApiImpl = new GuildDTReportApiImpl();
        HashMap hashMap = new HashMap();
        hashMap.put("sgrp_profile_userid", this.W);
        hashMap.put("sgrp_user_master", Integer.valueOf(this.Y ? 1 : 0));
        w.a(hashMap);
        guildDTReportApiImpl.setGuildPageParams(this.N, this.X, hashMap);
    }

    public static void Jh(Activity activity, @Nullable Bundle bundle, String str, String str2) {
        Intent intent = new Intent();
        if (bundle == null) {
            bundle = new Bundle();
        }
        if (!TextUtils.isEmpty(str)) {
            bundle.putString(INetChannelCallback.KEY_TINY_ID, str);
        }
        if (!TextUtils.isEmpty(str2)) {
            bundle.putString("guild_id", str2);
        }
        intent.putExtras(bundle);
        intent.putExtra("_extra_param_report_task", b.a("guild_personal_profile"));
        QPublicFragmentActivity.start(activity, intent, GuildProfileArchivesListFragment.class);
    }

    private void initDtReport() {
        VideoReport.addToDetectionWhitelist(getQBaseActivity());
        Ih();
    }

    private void initView(View view) {
        setTitle(getResources().getString(R.string.f1517918n));
        this.Y = getArguments().getBoolean("is_owner", false);
        this.T = (OverScrollRecyclerView) view.findViewById(R.id.wxh);
        pv1.a aVar = new pv1.a(this.Y);
        this.U = aVar;
        aVar.Q0(true);
        this.U.y0().w(true);
        this.U.y0().x(true);
        this.U.y0().y(new tv1.a());
        this.U.y0().z(new f() { // from class: qv1.a
            @Override // gf1.f
            public final void s() {
                GuildProfileArchivesListFragment.this.lambda$initView$0();
            }
        });
        this.T.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        this.T.setAdapter(this.U);
        this.T.addOnScrollListener(new a());
        qw1.b.o(b.b(this), this.T);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void initViewModel() {
        GuildProfileArchivesViewModel guildProfileArchivesViewModel = (GuildProfileArchivesViewModel) h.b(this, GuildProfileArchivesViewModel.sViewModelFactory).get(GuildProfileArchivesViewModel.class);
        this.V = guildProfileArchivesViewModel;
        ((wy1.a) guildProfileArchivesViewModel.getRepository()).m((AppInterface) MobileQQ.sMobileQQ.peekAppRuntime());
        if (getArguments() == null) {
            QLog.e("Guild.profile.GuildProfileArchivesListFragment", 1, "getArguments is null");
            return;
        }
        this.W = getArguments().getString(INetChannelCallback.KEY_TINY_ID);
        this.X = getArguments().getString("guild_id", "");
        if (TextUtils.isEmpty(this.W)) {
            QLog.e("Guild.profile.GuildProfileArchivesListFragment", 1, "params is null");
            return;
        }
        this.V.refreshList().observe(this, new Observer() { // from class: qv1.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildProfileArchivesListFragment.this.Gh((Boolean) obj);
            }
        });
        this.V.isEnd().observe(this, new Observer() { // from class: qv1.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildProfileArchivesListFragment.this.Hh((Boolean) obj);
            }
        });
        this.V.initData(this.W, this.X, this.Y);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$0() {
        if (this.V.isEnd().getValue().booleanValue()) {
            return;
        }
        this.V.loadMoreData(this.W, this.X);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment
    public void doOnCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        super.doOnCreateView(layoutInflater, viewGroup, bundle);
        initView(this.P);
        initViewModel();
        initDtReport();
        this.Z = dh1.a.f393835a.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.es9;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NonNull Configuration configuration) {
        pv1.a aVar;
        super.onConfigurationChanged(configuration);
        int a16 = dh1.a.f393835a.a();
        if (this.Z != a16 && (aVar = this.U) != null) {
            this.Z = a16;
            aVar.notifyDataSetChanged();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.T.setAdapter(null);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.V.initData(this.W, this.X, this.Y);
    }

    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment
    protected int ph() {
        return R.color.qui_common_bg_bottom_standard;
    }

    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment
    protected int qh() {
        return R.drawable.qui_common_bg_bottom_standard;
    }
}
