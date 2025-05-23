package com.tencent.mobileqq.guild.client.auth;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.client.GuildClientParams;
import com.tencent.mobileqq.guild.client.selectaccount.GuildClientSelectAccountDialogFragment;
import com.tencent.mobileqq.guild.client.selectaccount.GuildClientSelectAccountDialogParams;
import com.tencent.mobileqq.guild.data.w;
import com.tencent.mobileqq.guild.profile.profilecard.main.l;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.mvvm.h;
import com.tencent.mobileqq.qqguildsdk.data.dd;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.PageReportPolicy;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public abstract class GuildClientAuthorizationAbstractDialogFragment extends BottomSheetDialogFragment implements View.OnClickListener {
    protected View C;
    protected TextView D;
    protected TextView E;
    public LinearLayout F;
    protected jg1.a G;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a implements Observer<Object[]> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QBaseActivity f215373d;

        a(QBaseActivity qBaseActivity) {
            this.f215373d = qBaseActivity;
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Object[] objArr) {
            GuildClientAuthorizationAbstractDialogFragment.this.dismiss();
            GuildClientSelectAccountDialogFragment.xh(this.f215373d, GuildClientAuthorizationAbstractDialogFragment.this.getTargetFragment(), new GuildClientSelectAccountDialogParams(GuildClientAuthorizationAbstractDialogFragment.this.G.S1().g()).f((String) objArr[0]).b((List) objArr[1]).a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class b implements Observer<Object[]> {
        b() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Object[] objArr) {
            GuildClientAuthorizationAbstractDialogFragment.this.dismiss();
            ng1.b.b((dd) objArr[0], (GuildClientParams) objArr[1], (List) objArr[2]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class c implements Observer<l> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QBaseActivity f215376d;

        c(QBaseActivity qBaseActivity) {
            this.f215376d = qBaseActivity;
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(l lVar) {
            if (lVar.d()) {
                QBaseActivity qBaseActivity = this.f215376d;
                ch.u1(qBaseActivity, qBaseActivity.getString(R.string.f142430jc));
                jg1.b.b(this.f215376d, GuildClientAuthorizationAbstractDialogFragment.this.getTargetFragment(), GuildClientAuthorizationAbstractDialogFragment.this.G.S1().g(), true);
                GuildClientAuthorizationAbstractDialogFragment.this.dismiss();
                return;
            }
            if (lVar.a() == -952354) {
                ch.f1(lVar.c());
                GuildClientAuthorizationAbstractDialogFragment.this.dismiss();
            } else {
                QBaseActivity qBaseActivity2 = this.f215376d;
                ch.r1(qBaseActivity2, -1, qBaseActivity2.getString(R.string.f142420jb), null);
            }
        }
    }

    private String getPageId() {
        if (this.G.Q1() != 2 && this.G.Q1() != 4 && this.G.Q1() != 5) {
            if (this.G.Q1() == 1) {
                return "pg_sgrp_otherapp_manage";
            }
            if (this.G.Q1() == 3) {
                return "pg_sgrp_channel";
            }
            return "";
        }
        return "pg_sgrp_aio";
    }

    private void initView() {
        this.D = (TextView) this.C.findViewById(R.id.f164522sy4);
        this.E = (TextView) this.C.findViewById(R.id.sy6);
        this.F = (LinearLayout) this.C.findViewById(R.id.b9t);
        this.F.addView(getContentView(), new LinearLayout.LayoutParams(-1, -2));
        setCancelable(false);
        this.D.setOnClickListener(this);
        this.E.setOnClickListener(this);
    }

    private boolean ph(GuildClientAuthDialogParams guildClientAuthDialogParams) {
        if (guildClientAuthDialogParams == null) {
            QLog.e("Guild.client.GuildClientAuthorizationAbstractDialogFragment", 1, "open GuildClientAuthorizationAbstractDialogFragment params is null");
            return false;
        }
        String z16 = guildClientAuthDialogParams.g().z();
        String G = guildClientAuthDialogParams.g().G();
        if (!TextUtils.isEmpty(z16) && !TextUtils.isEmpty(G)) {
            return true;
        }
        QLog.e("Guild.client.GuildClientAuthorizationAbstractDialogFragment", 1, "open GuildClientAuthorizationAbstractDialogFragment params :" + guildClientAuthDialogParams.toString());
        return false;
    }

    private void qh() {
        VideoReport.setElementId(this.E, sh());
        VideoReport.setElementParam(this.E, "sgrp_otherapp_id", this.G.R1());
        TextView textView = this.E;
        ClickPolicy clickPolicy = ClickPolicy.REPORT_ALL;
        VideoReport.setElementClickPolicy(textView, clickPolicy);
        TextView textView2 = this.E;
        ExposurePolicy exposurePolicy = ExposurePolicy.REPORT_ALL;
        VideoReport.setElementExposePolicy(textView2, exposurePolicy);
        TextView textView3 = this.E;
        EndExposurePolicy endExposurePolicy = EndExposurePolicy.REPORT_ALL;
        VideoReport.setElementEndExposePolicy(textView3, endExposurePolicy);
        VideoReport.setElementId(this.D, rh());
        VideoReport.setElementParam(this.D, "sgrp_otherapp_id", this.G.R1());
        VideoReport.setElementClickPolicy(this.D, clickPolicy);
        VideoReport.setElementExposePolicy(this.D, exposurePolicy);
        VideoReport.setElementEndExposePolicy(this.D, endExposurePolicy);
    }

    private String rh() {
        if (this.G.Q1() != 2 && this.G.Q1() != 4 && this.G.Q1() != 5) {
            if (this.G.Q1() == 1) {
                return "em_sgrp_otherapp_authorization_refuse";
            }
            if (this.G.Q1() == 3) {
                return "em_sgrp_channel_otherapp_authorization_refuse";
            }
            return "";
        }
        return "em_sgrp_aio_otherapp_authorization_refuse";
    }

    private String sh() {
        if (this.G.Q1() != 2 && this.G.Q1() != 4 && this.G.Q1() != 5) {
            if (this.G.Q1() == 1) {
                return "em_sgrp_otherapp_authorization_allow";
            }
            if (this.G.Q1() == 3) {
                return "em_sgrp_channel_otherapp_authorization_allow";
            }
            return "";
        }
        return "em_sgrp_aio_otherapp_authorization_allow";
    }

    private void th(GuildClientAuthDialogParams guildClientAuthDialogParams) {
        jg1.a aVar = (jg1.a) h.b(this, jg1.a.F).get(jg1.a.class);
        this.G = aVar;
        aVar.W1((AppInterface) ((QBaseActivity) getActivity()).getAppRuntime(), guildClientAuthDialogParams);
    }

    private void uh(QBaseActivity qBaseActivity) {
        this.G.T1().observe(this, new a(qBaseActivity));
        this.G.U1().observe(this, new b());
        this.G.getToastLiveEvent().observe(this, new c(qBaseActivity));
    }

    private void vh() {
        if (TextUtils.isEmpty(this.G.getGuildId())) {
            return;
        }
        VideoReport.addToDetectionWhitelist(getActivity());
        HashMap hashMap = new HashMap();
        String pageId = getPageId();
        if (!"pg_sgrp_aio".equals(pageId) && !"pg_sgrp_channel".equals(pageId)) {
            if ("pg_sgrp_otherapp_manage".equals(pageId)) {
                w.a(hashMap);
                hashMap.put("sgrp_user_master", 1);
            }
        } else {
            w.b(hashMap);
        }
        hashMap.putAll(com.tencent.mobileqq.guild.report.b.d());
        VideoReport.setPageId(this.C, pageId);
        VideoReport.setPageReportPolicy(this.C, PageReportPolicy.REPORT_NONE);
        ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).setGuildPageParams(this.C, this.G.getGuildId(), hashMap);
    }

    protected abstract View getContentView();

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view == this.D) {
            dismiss();
        } else if (view == this.E && !QQGuildUIUtil.v()) {
            this.G.b2();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        GuildClientAuthDialogParams guildClientAuthDialogParams = (GuildClientAuthDialogParams) getArguments().getParcelable("GuildClientAuthorizationParam");
        if (!ph(guildClientAuthDialogParams)) {
            dismiss();
        }
        this.C = layoutInflater.inflate(R.layout.eja, viewGroup, false);
        initView();
        th(guildClientAuthDialogParams);
        uh((QBaseActivity) getActivity());
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
        vh();
        VideoReport.reportPgIn(this.C);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        qh();
    }
}
