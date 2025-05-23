package com.tencent.mobileqq.guild.client.selectaccount;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.client.selectaccount.GuildClientSelectAccountDialogParams;
import com.tencent.mobileqq.guild.data.w;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public class GuildClientSelectAccountDialogFragment extends BottomSheetDialogFragment implements View.OnClickListener {
    private View C;
    private TextView D;
    private com.tencent.mobileqq.guild.client.selectaccount.a E;
    private b F;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a implements Observer<com.tencent.mobileqq.guild.profile.profilecard.main.l> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QBaseActivity f215409d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ GuildClientSelectAccountDialogParams f215410e;

        a(QBaseActivity qBaseActivity, GuildClientSelectAccountDialogParams guildClientSelectAccountDialogParams) {
            this.f215409d = qBaseActivity;
            this.f215410e = guildClientSelectAccountDialogParams;
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(com.tencent.mobileqq.guild.profile.profilecard.main.l lVar) {
            if (lVar.d()) {
                QBaseActivity qBaseActivity = this.f215409d;
                ch.u1(qBaseActivity, qBaseActivity.getString(R.string.f142430jc));
                jg1.b.b(this.f215409d, GuildClientSelectAccountDialogFragment.this.getTargetFragment(), this.f215410e.e(), true);
                GuildClientSelectAccountDialogFragment.this.dismiss();
                return;
            }
            QBaseActivity qBaseActivity2 = this.f215409d;
            ch.r1(qBaseActivity2, -1, qBaseActivity2.getString(R.string.f142420jb), null);
        }
    }

    private String getPageId() {
        if (this.F.M1() != 2 && this.F.M1() != 4 && this.F.M1() != 5) {
            if (this.F.M1() == 1) {
                return "pg_sgrp_otherapp_manage";
            }
            if (this.F.M1() == 3) {
                return "pg_sgrp_channel";
            }
            return "";
        }
        return "pg_sgrp_aio";
    }

    private void initView() {
        this.D = (TextView) this.C.findViewById(R.id.title);
        RecyclerView recyclerView = (RecyclerView) this.C.findViewById(R.id.f163886b8);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        com.tencent.mobileqq.guild.client.selectaccount.a aVar = new com.tencent.mobileqq.guild.client.selectaccount.a(getActivity());
        this.E = aVar;
        recyclerView.setAdapter(aVar);
        this.C.findViewById(R.id.j6n).setOnClickListener(this);
    }

    private void ph(View view) {
        VideoReport.setElementId(view, rh());
        VideoReport.setElementParam(view, "sgrp_otherapp_id", this.F.N1());
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_ALL);
    }

    private void qh() {
        View findViewById = this.C.findViewById(R.id.j6n);
        VideoReport.setElementId(findViewById, sh());
        VideoReport.setElementParam(findViewById, "sgrp_otherapp_id", this.F.N1());
        VideoReport.setElementExposePolicy(findViewById, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(findViewById, ClickPolicy.REPORT_ALL);
        VideoReport.setElementEndExposePolicy(findViewById, EndExposurePolicy.REPORT_ALL);
    }

    private String rh() {
        if (this.F.M1() != 2 && this.F.M1() != 4 && this.F.M1() != 5) {
            if (this.F.M1() == 1) {
                return "em_sgrp_otherapp_role_selection_panel";
            }
            if (this.F.M1() == 3) {
                return "em_sgrp_channel_otherapp_role_selection_panel";
            }
            return "";
        }
        return "em_sgrp_aio_otherapp_role_selection_panel";
    }

    private String sh() {
        if (this.F.M1() != 2 && this.F.M1() != 4 && this.F.M1() != 5) {
            if (this.F.M1() == 1) {
                return "em_sgrp_otherapp_role_confirm";
            }
            if (this.F.M1() == 3) {
                return "em_sgrp_channel_otherapp_role_confirm";
            }
            return "";
        }
        return "em_sgrp_aio_otherapp_role_confirm";
    }

    private void th(GuildClientSelectAccountDialogParams guildClientSelectAccountDialogParams) {
        uh((QBaseActivity) getActivity(), guildClientSelectAccountDialogParams);
        String title = guildClientSelectAccountDialogParams.getTitle();
        List<GuildClientSelectAccountDialogParams.AccountInfo> c16 = guildClientSelectAccountDialogParams.c();
        this.D.setText(title);
        this.E.setData(c16);
    }

    private void uh(QBaseActivity qBaseActivity, GuildClientSelectAccountDialogParams guildClientSelectAccountDialogParams) {
        b bVar = (b) com.tencent.mobileqq.mvvm.h.b(this, b.D).get(b.class);
        this.F = bVar;
        bVar.O1((AppInterface) qBaseActivity.getAppRuntime(), guildClientSelectAccountDialogParams);
        this.F.getToastEvent().observe(this, new a(qBaseActivity, guildClientSelectAccountDialogParams));
    }

    private boolean vh(GuildClientSelectAccountDialogParams guildClientSelectAccountDialogParams) {
        String z16 = guildClientSelectAccountDialogParams.e().z();
        String G = guildClientSelectAccountDialogParams.e().G();
        if (!TextUtils.isEmpty(z16) && !TextUtils.isEmpty(G)) {
            return true;
        }
        QLog.e("Guild.client.GuildClientSelectAccountDialogFragment", 2, "open GuildClientSelectAccountDialogFragment clientId or guildId is null");
        return false;
    }

    private void wh() {
        if (TextUtils.isEmpty(this.F.getGuildId())) {
            return;
        }
        VideoReport.addToDetectionWhitelist(getActivity());
        HashMap hashMap = new HashMap();
        String pageId = getPageId();
        if (!"pg_sgrp_aio".equals(pageId) && !"pg_sgrp_channel".equals(pageId)) {
            if ("pg_sgrp_otherapp_manage".equals(pageId)) {
                w.a(hashMap);
            }
        } else {
            w.b(hashMap);
        }
        hashMap.putAll(com.tencent.mobileqq.guild.report.b.d());
        VideoReport.setPageId(this.C, pageId);
        ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).setGuildPageParams(this.C, this.F.getGuildId(), hashMap);
    }

    public static void xh(QBaseActivity qBaseActivity, Fragment fragment, @NonNull GuildClientSelectAccountDialogParams guildClientSelectAccountDialogParams) {
        QLog.d("Guild.client.GuildClientSelectAccountDialogFragment", 1, "showSelectAccountDialog params\uff1a" + guildClientSelectAccountDialogParams.toString());
        Bundle bundle = new Bundle();
        bundle.putParcelable("guildClientSelectAccountDialogFragmentParam", guildClientSelectAccountDialogParams);
        GuildClientSelectAccountDialogFragment guildClientSelectAccountDialogFragment = new GuildClientSelectAccountDialogFragment();
        guildClientSelectAccountDialogFragment.setArguments(bundle);
        if (fragment != null) {
            guildClientSelectAccountDialogFragment.setTargetFragment(fragment, 1);
        }
        qBaseActivity.getSupportFragmentManager().beginTransaction().add(guildClientSelectAccountDialogFragment, "Guild.client.GuildClientSelectAccountDialogFragment").commitAllowingStateLoss();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.j6n && !QQGuildUIUtil.v()) {
            VideoReport.reportEvent("clck", view, new HashMap());
            this.F.P1(this.E.i0());
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        GuildClientSelectAccountDialogParams guildClientSelectAccountDialogParams = (GuildClientSelectAccountDialogParams) getArguments().getParcelable("guildClientSelectAccountDialogFragmentParam");
        if (!vh(guildClientSelectAccountDialogParams)) {
            dismiss();
        }
        this.C = layoutInflater.inflate(R.layout.ejh, viewGroup, false);
        initView();
        th(guildClientSelectAccountDialogParams);
        wh();
        ph(this.C);
        qh();
        View view = this.C;
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ((ViewGroup) this.C.getParent()).setBackgroundColor(0);
    }
}
