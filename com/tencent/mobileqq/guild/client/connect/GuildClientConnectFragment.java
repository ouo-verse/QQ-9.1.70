package com.tencent.mobileqq.guild.client.connect;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment;
import com.tencent.mobileqq.guild.client.GuildClientParams;
import com.tencent.mobileqq.guild.client.selectclient.GuildSelectClientDialogFragment;
import com.tencent.mobileqq.guild.data.w;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.bx;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.mvvm.h;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public class GuildClientConnectFragment extends QQGuildTitleBarFragment implements View.OnClickListener {
    private LinearLayout T;
    private RecyclerView U;
    private com.tencent.mobileqq.guild.client.connect.a V;
    private com.tencent.mobileqq.guild.client.connect.b W;
    private QQProgressDialog X;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a implements Observer<List<GuildClientParams>> {
        a() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(List<GuildClientParams> list) {
            if (GuildClientConnectFragment.this.W.W1().getValue().booleanValue()) {
                GuildClientConnectFragment.this.V.i0();
            }
            GuildClientConnectFragment.this.V.setData(list);
            if (list.isEmpty() && !bx.b()) {
                Bundle bundle = new Bundle();
                bundle.putString("guild_id", GuildClientConnectFragment.this.W.getGuildId());
                GuildSelectClientDialogFragment.vh(GuildClientConnectFragment.this.getQBaseActivity(), bundle);
            }
            bx.o();
            if (GuildClientConnectFragment.this.X != null && GuildClientConnectFragment.this.X.isShowing()) {
                GuildClientConnectFragment.this.X.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class b extends RecyclerView.OnScrollListener {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i3) {
            if (i3 == 0) {
                return;
            }
            if (GuildClientConnectFragment.this.V.getItemCount() - ((LinearLayoutManager) recyclerView.getLayoutManager()).findLastVisibleItemPosition() < 20 && !GuildClientConnectFragment.this.W.T1().getValue().booleanValue() && !GuildClientConnectFragment.this.W.U1().getValue().booleanValue()) {
                GuildClientConnectFragment.this.W.Z1();
            }
        }
    }

    private void Gh(String str) {
        com.tencent.mobileqq.guild.client.connect.b bVar = (com.tencent.mobileqq.guild.client.connect.b) h.b(this, com.tencent.mobileqq.guild.client.connect.b.H).get(com.tencent.mobileqq.guild.client.connect.b.class);
        this.W = bVar;
        bVar.X1(getAppInterface(), str);
        this.W.S1().observe(getViewLifecycleOwner(), new a());
        this.U.addOnScrollListener(new b());
    }

    private void Hh() {
        if (TextUtils.isEmpty(this.W.getGuildId())) {
            return;
        }
        VideoReport.addToDetectionWhitelist(getActivity());
        VideoReport.setPageId(this.N, "pg_sgrp_otherapp_manage");
        HashMap hashMap = new HashMap();
        w.a(hashMap);
        ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).setGuildPageParams(this.N, this.W.getGuildId(), hashMap);
    }

    private void initView() {
        setTitle(getString(R.string.f155961ix));
        LinearLayout linearLayout = (LinearLayout) this.P.findViewById(R.id.u4n);
        this.T = linearLayout;
        ch.Y0(linearLayout, "em_sgrp_add_otherapp", ClickPolicy.REPORT_NONE, ExposurePolicy.REPORT_NONE);
        this.T.setOnClickListener(this);
        RecyclerView recyclerView = (RecyclerView) this.P.findViewById(R.id.u4q);
        this.U = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        com.tencent.mobileqq.guild.client.connect.a aVar = new com.tencent.mobileqq.guild.client.connect.a(getActivity());
        this.V = aVar;
        this.U.setAdapter(aVar);
        this.U.setOverScrollMode(2);
        this.X = new QQProgressDialog(getActivity());
        this.P.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.client.connect.GuildClientConnectFragment.1
            @Override // java.lang.Runnable
            public void run() {
                if (GuildClientConnectFragment.this.W.S1().getValue() == null) {
                    GuildClientConnectFragment.this.X.show();
                }
            }
        }, 700L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment, com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment
    public void doOnCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.doOnCreateView(layoutInflater, viewGroup, bundle);
        String string = getActivity().getIntent().getExtras().getString("guild_id");
        if (TextUtils.isEmpty(string)) {
            QLog.e("Guild.client.GuildClientConnectFragment", 1, "openGuildClientConnectFragment but guildId is empty");
            getActivity().finish();
        }
        initView();
        Gh(string);
        Hh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.ejc;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view == this.T && !QQGuildUIUtil.v()) {
            Bundle bundle = new Bundle();
            bundle.putString("guild_id", this.W.getGuildId());
            GuildSelectClientDialogFragment.vh(getQBaseActivity(), bundle);
            VideoReport.reportEvent("clck", this.T, null);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        QQProgressDialog qQProgressDialog = this.X;
        if (qQProgressDialog != null) {
            qQProgressDialog.dismiss();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.W.a2();
        this.V.i0();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        com.tencent.mobileqq.guild.client.connect.b bVar = this.W;
        bVar.b2(bVar.getGuildId());
    }
}
