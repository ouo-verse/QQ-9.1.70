package com.tencent.mobileqq.guild.client.manage;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment;
import com.tencent.mobileqq.guild.client.GuildClientParams;
import com.tencent.mobileqq.guild.data.w;
import com.tencent.mobileqq.guild.jump.GuildJumpUtil;
import com.tencent.mobileqq.guild.profile.profilecard.main.l;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.mvvm.h;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.o;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes12.dex */
public class GuildClientManageFragment extends QQGuildTitleBarFragment implements View.OnClickListener {
    private GuildClientManageViewModel T;
    private com.tencent.mobileqq.guild.client.manage.a U;
    private RecyclerView V;
    private FrameLayout W;
    private URLImageView X;
    private TextView Y;
    private TextView Z;

    /* renamed from: a0, reason: collision with root package name */
    private QQProgressDialog f215390a0;

    /* renamed from: b0, reason: collision with root package name */
    private boolean f215391b0;

    /* renamed from: c0, reason: collision with root package name */
    private GuildClientParams f215392c0;

    /* renamed from: d0, reason: collision with root package name */
    private int f215393d0 = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a implements Observer<GuildClientParams> {
        a() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(GuildClientParams guildClientParams) {
            if (guildClientParams.B() == 2) {
                if (guildClientParams.getType() == 2) {
                    GuildClientManageFragment.this.W.setVisibility(0);
                } else {
                    GuildClientManageFragment.this.W.setVisibility(8);
                }
            } else {
                GuildClientManageFragment.this.W.setVisibility(0);
            }
            if (!TextUtils.isEmpty(guildClientParams.y())) {
                GuildClientManageFragment.this.X.setBackgroundURL(guildClientParams.y());
            }
            GuildClientManageFragment.this.Y.setText(guildClientParams.A());
            GuildClientManageFragment.this.Z.setText(GuildClientManageFragment.this.getString(R.string.f155911is) + guildClientParams.p());
            GuildClientManageFragment.this.U.setData(guildClientParams.w());
            GuildClientManageFragment.this.U.m0(guildClientParams);
            if (GuildClientManageFragment.this.f215390a0 != null && GuildClientManageFragment.this.f215390a0.isShowing()) {
                GuildClientManageFragment.this.f215390a0.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class b implements Observer<Boolean> {
        b() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Boolean bool) {
            if (GuildClientManageFragment.this.getActivity() != null) {
                QQGuildUIUtil.c(GuildClientManageFragment.this.getActivity(), 400);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class c implements Observer<l> {
        c() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(l lVar) {
            if (TextUtils.isEmpty(lVar.c())) {
                return;
            }
            if (lVar.d()) {
                ch.u1(GuildClientManageFragment.this.getContext(), lVar.c());
            } else {
                ch.r1(GuildClientManageFragment.this.getActivity(), lVar.a(), lVar.c(), lVar.b());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class d implements Observer<Boolean> {
        d() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Boolean bool) {
            if (bool.booleanValue()) {
                GuildClientManageFragment.this.getActivity().finish();
            }
        }
    }

    private void Kh(View view) {
        VideoReport.setElementId(view, "em_sgrp_delete_otherapp");
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
    }

    private void Lh(GuildClientParams guildClientParams, int i3) {
        GuildClientManageViewModel guildClientManageViewModel = (GuildClientManageViewModel) h.b(this, GuildClientManageViewModel.G).get(GuildClientManageViewModel.class);
        this.T = guildClientManageViewModel;
        guildClientManageViewModel.e2(getAppInterface(), guildClientParams, i3);
        com.tencent.mobileqq.guild.client.manage.a aVar = new com.tencent.mobileqq.guild.client.manage.a(this, guildClientParams, this.T);
        this.U = aVar;
        this.V.setAdapter(aVar);
    }

    private void Mh() {
        this.T.U1().observe(getViewLifecycleOwner(), new a());
        this.T.c2().observe(this, new b());
        this.T.b2().observe(this, new c());
        this.T.a2().observe(this, new d());
    }

    public static void Nh(Context context, GuildClientParams guildClientParams, int i3) {
        if (context == null) {
            QLog.e("Guild.client.GuildClientManageFragment", 1, "open openGuildClientManageFragment error, the context is null");
            return;
        }
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putInt("from_type", i3);
        bundle.putParcelable("client_info", guildClientParams);
        intent.putExtras(bundle);
        QPublicFragmentActivity.b.b(context, intent, QPublicFragmentActivity.class, GuildClientManageFragment.class);
    }

    private void Oh() {
        if (TextUtils.isEmpty(this.T.getGuildId())) {
            return;
        }
        VideoReport.addToDetectionWhitelist(getActivity());
        VideoReport.setPageId(this.N, "pg_sgrp_otherapp_set");
        HashMap hashMap = new HashMap();
        hashMap.put("sgrp_otherapp_id", this.T.T1());
        w.a(hashMap);
        ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).setGuildPageParams(this.N, this.T.getGuildId(), hashMap);
    }

    private void initView() {
        this.C.setOnClickListener(this);
        this.V = (RecyclerView) this.P.findViewById(R.id.u3x);
        this.X = (URLImageView) this.P.findViewById(R.id.ty_);
        this.Y = (TextView) this.P.findViewById(R.id.tyf);
        this.Z = (TextView) this.P.findViewById(R.id.tyg);
        this.W = (FrameLayout) this.P.findViewById(R.id.f113936rz);
        o.n(this.W, 0, true, ContextCompat.getDrawable(getContext(), R.drawable.guild_setting_common_bg_selector));
        this.W.setOnClickListener(this);
        Kh(this.W);
        this.V.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        this.V.setOverScrollMode(2);
        this.f215390a0 = new QQProgressDialog(getActivity());
        this.P.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.client.manage.GuildClientManageFragment.1
            @Override // java.lang.Runnable
            public void run() {
                if (GuildClientManageFragment.this.T.U1().getValue() == null) {
                    GuildClientManageFragment.this.f215390a0.show();
                }
            }
        }, 700L);
    }

    public void Ph(boolean z16) {
        this.f215391b0 = z16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment, com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment
    public void doOnCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.doOnCreateView(layoutInflater, viewGroup, bundle);
        GuildClientParams guildClientParams = (GuildClientParams) getActivity().getIntent().getExtras().getParcelable("client_info");
        int i3 = getActivity().getIntent().getExtras().getInt("from_type");
        if (guildClientParams == null || TextUtils.isEmpty(guildClientParams.G()) || TextUtils.isEmpty(guildClientParams.z()) || i3 == 0) {
            QLog.e("Guild.client.GuildClientManageFragment", 1, "open openGuildClientManageFragment error, the data is null");
            getActivity().finish();
        }
        initView();
        Lh(guildClientParams, i3);
        Mh();
        Oh();
        this.f215393d0 = dh1.a.f393835a.a();
        this.f215392c0 = guildClientParams;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.ejg;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view == this.C) {
            onBackEvent();
        } else if (view == this.W && !QQGuildUIUtil.v()) {
            GuildClientManageViewModel guildClientManageViewModel = this.T;
            if (guildClientManageViewModel == null) {
                QLog.i("Guild.client.GuildClientManageFragment", 1, "mViewModel is null, return");
            } else if (guildClientManageViewModel.W1() == 2) {
                String d26 = this.T.d2();
                if (TextUtils.isEmpty(d26)) {
                    QLog.i("Guild.client.GuildClientManageFragment", 1, "unbindUrl is empty, return");
                } else {
                    GuildJumpUtil.w(getActivity(), d26);
                    this.f215391b0 = true;
                }
            } else {
                this.T.g2();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NonNull Configuration configuration) {
        super.onConfigurationChanged(configuration);
        int a16 = dh1.a.f393835a.a();
        if (this.f215393d0 != a16) {
            this.f215393d0 = a16;
            this.P.requestLayout();
        }
    }

    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        QQProgressDialog qQProgressDialog = this.f215390a0;
        if (qQProgressDialog != null) {
            qQProgressDialog.dismiss();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.f215391b0) {
            this.f215391b0 = false;
            this.T.R1(this.f215392c0.z());
        }
    }
}
