package com.tencent.mobileqq.guild.channel.manage;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment;
import com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.security.SecurityTipHelperKt;
import com.tencent.mobileqq.msf.MSFAccountChangeRegisterTask;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.util.InputMethodUtil;
import java.util.HashMap;
import wh2.dv;

/* compiled from: P */
/* loaded from: classes12.dex */
public class QQGuildVoiceChannelMemberLimitFragment extends QQGuildTitleBarFragment {
    private IGProChannelInfo T;
    private EditText U;
    private View V;
    private TextView W;
    private String X = MSFAccountChangeRegisterTask.MSF_DEFAULT_UIN;
    private GPServiceObserver Y = new e();

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (QQGuildVoiceChannelMemberLimitFragment.this.U.getText() != null && QQGuildVoiceChannelMemberLimitFragment.this.U.getText().length() > 0) {
                QQGuildVoiceChannelMemberLimitFragment.this.U.setText("");
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            InputMethodUtil.hide(QQGuildVoiceChannelMemberLimitFragment.this.U);
            QQGuildVoiceChannelMemberLimitFragment.this.onBackEvent();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QQGuildVoiceChannelMemberLimitFragment.this.Ih(QQGuildVoiceChannelMemberLimitFragment.this.U.getText().toString());
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class d implements dv {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f215075a;

        d(Context context) {
            this.f215075a = context;
        }

        @Override // wh2.dv
        public void a(int i3, String str, IGProSecurityResult iGProSecurityResult) {
            int i16;
            if (i3 == 0 && ch.p(iGProSecurityResult)) {
                QQToast.makeText(this.f215075a, 2, R.string.f156431k7, 0).show();
                InputMethodUtil.hide(QQGuildVoiceChannelMemberLimitFragment.this.U);
                VideoReport.setPageId(((QQGuildCustomTitleBarFragment) QQGuildVoiceChannelMemberLimitFragment.this).P, "pg_sgrp_channel_set");
                HashMap hashMap = new HashMap();
                hashMap.put("sgrp_sub_channel_capacity", QQGuildVoiceChannelMemberLimitFragment.this.U.getText());
                VideoReport.reportEvent("clck", QQGuildVoiceChannelMemberLimitFragment.this.U, hashMap);
                QQGuildVoiceChannelMemberLimitFragment.this.onBackEvent();
                return;
            }
            QLog.e("Guild.mnr.QQGuildVoiceChannelMemberLimitFragment", 1, "setAudioChannelUserLimit result=", Integer.valueOf(i3), ", errMsg=", str);
            if (i3 == 30002) {
                i16 = R.string.f15007140;
            } else if (i3 == 30003) {
                i16 = R.string.f1500613z;
            } else {
                i16 = R.string.f156051j6;
            }
            SecurityTipHelperKt.K(iGProSecurityResult, QQGuildVoiceChannelMemberLimitFragment.this.getQBaseActivity(), i3, BaseApplication.getContext().getString(i16), false);
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class e extends GPServiceObserver {
        e() {
        }
    }

    public static void Gh(Context context, IGProChannelInfo iGProChannelInfo) {
        if (context != null && iGProChannelInfo != null) {
            Intent intent = new Intent();
            intent.putExtra("extra_guild_channel_info", iGProChannelInfo);
            QPublicFragmentActivity.b.b(context, intent, QPublicFragmentActivity.class, QQGuildVoiceChannelMemberLimitFragment.class);
            return;
        }
        QLog.e("Guild.mnr.QQGuildVoiceChannelMemberLimitFragment", 1, "open, invalid param");
    }

    private void Hh(int i3, int i16) {
        boolean z16 = true;
        QLog.i("Guild.mnr.QQGuildVoiceChannelMemberLimitFragment", 1, "[updateMemberCountLimit] maxMemberType: " + i3 + ", maxNumber: " + i16);
        IGProChannelInfo iGProChannelInfo = this.T;
        if (iGProChannelInfo == null) {
            QLog.e("Guild.mnr.QQGuildVoiceChannelMemberLimitFragment", 1, "[updateMemberCountLimit] failed. mChannelInfo is null");
            return;
        }
        long parseLong = Long.parseLong(iGProChannelInfo.getGuildId());
        long parseLong2 = Long.parseLong(this.T.getChannelUin());
        int type = this.T.getType();
        if (i3 != 0) {
            z16 = false;
        }
        ((IGPSService) ch.S0(IGPSService.class, "")).setChannelUserNumLimit(parseLong, parseLong2, type, z16, i16, new d(getQBaseActivity()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ih(String str) {
        QLog.i("Guild.mnr.QQGuildVoiceChannelMemberLimitFragment", 1, "[updateMemberCountLimit] limit: " + str);
        if (TextUtils.isEmpty(str)) {
            Hh(1, 0);
            return;
        }
        try {
            int parseInt = Integer.parseInt(str);
            if (parseInt > 0) {
                Hh(0, parseInt);
            } else {
                QQToast.makeText(getContext(), 1, QQGuildUIUtil.r(R.string.f1492611t), 0).show();
            }
        } catch (NumberFormatException unused) {
            QQToast.makeText(getContext(), 1, QQGuildUIUtil.r(R.string.f1492511s), 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment, com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment
    public void doOnCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.doOnCreateView(layoutInflater, viewGroup, bundle);
        this.T = (IGProChannelInfo) getActivity().getIntent().getSerializableExtra("extra_guild_channel_info");
        this.U = (EditText) this.P.findViewById(R.id.xok);
        this.V = this.P.findViewById(R.id.x26);
        TextView textView = (TextView) this.P.findViewById(R.id.jmp);
        this.W = textView;
        textView.setVisibility(0);
        IGProChannelInfo iGProChannelInfo = this.T;
        if (iGProChannelInfo != null && iGProChannelInfo.getType() == 2) {
            this.W.setText(getString(R.string.f158421pk, this.X));
        } else {
            this.W.setText(getString(R.string.f1500213v, this.X));
        }
        this.V.setOnClickListener(new a());
        setLeftButton(R.string.f140850f3, new b());
        IGProChannelInfo iGProChannelInfo2 = this.T;
        if (iGProChannelInfo2 != null && iGProChannelInfo2.getType() == 2) {
            setTitle(getResources().getString(R.string.f139960co));
        } else {
            setTitle(getResources().getString(R.string.f158401pi));
        }
        setRightButton(R.string.f143340lt, new c());
        this.U.setFocusable(true);
        this.U.setFocusableInTouchMode(true);
        this.U.requestFocus();
        IGProChannelInfo iGProChannelInfo3 = this.T;
        if (iGProChannelInfo3 != null) {
            if (iGProChannelInfo3.getNoMemberMaxLimited() == 1) {
                this.U.setText("");
            } else {
                String valueOf = String.valueOf(this.T.getChannelMemberMax());
                this.U.setText(valueOf);
                this.U.setSelection(valueOf.length());
                this.U.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.channel.manage.QQGuildVoiceChannelMemberLimitFragment.4
                    @Override // java.lang.Runnable
                    public void run() {
                        InputMethodUtil.show(QQGuildVoiceChannelMemberLimitFragment.this.U);
                    }
                }, 200L);
            }
            VideoReport.setPageId(this.P, "pg_sgrp_channel_set");
            HashMap hashMap = new HashMap();
            hashMap.put("sgrp_subchannel_type", Integer.valueOf(this.T.getType()));
            ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).setChannelPageParams(this.P, this.T, hashMap);
        }
        VideoReport.setElementId(this.U, "em_sgrp_voicechannel_set_maxmember");
        VideoReport.setElementExposePolicy(this.U, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(this.U, ClickPolicy.REPORT_NONE);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.eiz;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        ((IGPSService) getAppInterface().getRuntimeService(IGPSService.class, "")).addObserver(this.Y);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        ((IGPSService) getAppInterface().getRuntimeService(IGPSService.class, "")).deleteObserver(this.Y);
    }
}
