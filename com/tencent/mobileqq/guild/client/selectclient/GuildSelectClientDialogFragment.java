package com.tencent.mobileqq.guild.client.selectclient;

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
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.client.selectclient.b;
import com.tencent.mobileqq.guild.data.w;
import com.tencent.mobileqq.mvvm.h;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.PageReportPolicy;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public class GuildSelectClientDialogFragment extends BottomSheetDialogFragment {
    private View C;
    private RecyclerView D;
    private com.tencent.mobileqq.guild.client.selectclient.a E;
    private com.tencent.mobileqq.guild.client.selectclient.b F;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a implements Observer<List<b.c>> {
        a() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(List<b.c> list) {
            if (!list.isEmpty()) {
                GuildSelectClientDialogFragment.this.wh();
            }
            GuildSelectClientDialogFragment.this.E.setData(list);
            GuildSelectClientDialogFragment.this.D.setVisibility(0);
            VideoReport.traversePage(GuildSelectClientDialogFragment.this.D);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class b extends RecyclerView.OnScrollListener {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i3) {
            if (i3 == 0) {
                VideoReport.traversePage(GuildSelectClientDialogFragment.this.D);
                return;
            }
            if (GuildSelectClientDialogFragment.this.E.getItemCount() - ((LinearLayoutManager) recyclerView.getLayoutManager()).findLastVisibleItemPosition() < 20 && !GuildSelectClientDialogFragment.this.F.S1().getValue().booleanValue() && !GuildSelectClientDialogFragment.this.F.T1().getValue().booleanValue()) {
                GuildSelectClientDialogFragment.this.F.W1();
            }
        }
    }

    private void initView() {
        RecyclerView recyclerView = (RecyclerView) this.C.findViewById(R.id.tye);
        this.D = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        com.tencent.mobileqq.guild.client.selectclient.a aVar = new com.tencent.mobileqq.guild.client.selectclient.a(this);
        this.E = aVar;
        this.D.setAdapter(aVar);
    }

    private void th(String str) {
        this.F = (com.tencent.mobileqq.guild.client.selectclient.b) h.b(this, com.tencent.mobileqq.guild.client.selectclient.b.G).get(com.tencent.mobileqq.guild.client.selectclient.b.class);
        this.F.U1((AppInterface) ((QBaseActivity) getActivity()).getAppRuntime(), str);
        this.F.R1().observe(getViewLifecycleOwner(), new a());
        this.D.addOnScrollListener(new b());
    }

    private void uh(boolean z16) {
        if (TextUtils.isEmpty(this.F.getGuildId())) {
            return;
        }
        VideoReport.addToDetectionWhitelist(getActivity());
        VideoReport.setPageReportPolicy(this.C, PageReportPolicy.REPORT_NONE);
        VideoReport.setPageId(this.C, "pg_sgrp_otherapp_manage");
        HashMap hashMap = new HashMap();
        hashMap.put("sgrp_user_master", Integer.valueOf(z16 ? 1 : 0));
        w.a(hashMap);
        ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).setGuildPageParams(this.C, this.F.getGuildId(), hashMap);
    }

    public static void vh(QBaseActivity qBaseActivity, Bundle bundle) {
        QLog.d("GuildSelectClientDialogFragment", 1, "showClientConnectSelectDialogFragment params\uff1a");
        GuildSelectClientDialogFragment guildSelectClientDialogFragment = new GuildSelectClientDialogFragment();
        guildSelectClientDialogFragment.setArguments(bundle);
        qBaseActivity.getSupportFragmentManager().beginTransaction().add(guildSelectClientDialogFragment, "GuildSelectClientDialogFragment").commitAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wh() {
        this.C.findViewById(R.id.title).setVisibility(0);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String string = getActivity().getIntent().getExtras().getString("guild_id");
        if (TextUtils.isEmpty(string)) {
            QLog.e("GuildSelectClientDialogFragment", 1, "showClientConnectSelectDialogFragment but guildId is empty");
            dismiss();
        }
        this.C = layoutInflater.inflate(R.layout.ejd, viewGroup, false);
        initView();
        th(string);
        uh(getActivity().getIntent().getExtras().getBoolean("is_owner", false));
        View view = this.C;
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        VideoReport.reportPgOut(this.C);
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ((ViewGroup) this.C.getParent()).setBackgroundColor(0);
        VideoReport.reportPgIn(this.C);
    }
}
