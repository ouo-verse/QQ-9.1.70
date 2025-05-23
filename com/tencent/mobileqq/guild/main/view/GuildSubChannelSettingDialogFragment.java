package com.tencent.mobileqq.guild.main.view;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.tencent.common.app.AppInterface;
import com.tencent.guild.api.channel.IGuildChannelApi;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.api.IGuildInfoUtilsApi;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.guild.constant.GuildFacadeType;
import com.tencent.mobileqq.guild.data.w;
import com.tencent.mobileqq.guild.setting.subscribe.recommend.GuildSubscribeSuccessDialogFragment;
import com.tencent.mobileqq.guild.util.as;
import com.tencent.mobileqq.guild.util.az;
import com.tencent.mobileqq.guild.util.bw;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.l;
import com.tencent.mobileqq.guild.widget.GuildSwitchButton;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import mqq.util.WeakReference;
import uh2.e;
import vh2.cc;

/* compiled from: P */
/* loaded from: classes14.dex */
public class GuildSubChannelSettingDialogFragment extends BottomSheetDialogFragment implements GuildSwitchButton.a, View.OnClickListener {
    private GuildSubChannelParams C = new GuildSubChannelParams();
    private long D;
    private View E;
    private TextView F;
    private LinearLayout G;
    private RelativeLayout H;
    private GuildSwitchButton I;
    private DialogInterface.OnDismissListener J;

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public static class GuildSubChannelParams implements Serializable {
        public IGProChannelInfo channelInfo;
        public GuildFacadeType guildFacadeType;
        public boolean isManager;
        public boolean isSupportSubscription;
        public boolean isSupportTextChannelAbility;

        private boolean a(IGProChannelInfo iGProChannelInfo) {
            AppInterface l3 = ch.l();
            if (l3 == null) {
                return false;
            }
            e eVar = (e) l3.getRuntimeService(IGPSService.class, "");
            if (((IGPSService) ch.S0(IGPSService.class, "")).isQQMsgListGuild(Long.parseLong(iGProChannelInfo.getGuildId())) || !eVar.isQQMsgListChannel(iGProChannelInfo.getGuildId(), iGProChannelInfo.getChannelUin())) {
                return false;
            }
            return true;
        }

        public boolean canShowSettingDialog() {
            if (!this.isManager && !this.isSupportTextChannelAbility && !this.isSupportSubscription) {
                return false;
            }
            return true;
        }

        public boolean showOldSettingPage() {
            if (!this.isManager && !a(this.channelInfo)) {
                return false;
            }
            return true;
        }

        public String toString() {
            return "GuildSubChannelParams{isManager=" + this.isManager + ", isSupportTextChannelAbility=" + this.isSupportTextChannelAbility + ", isSupportSubscription=" + this.isSupportSubscription + ", channelInfo=" + this.channelInfo.getChannelUin() + this.channelInfo.getChannelName() + '}';
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public static final class a implements cc {

        /* renamed from: a, reason: collision with root package name */
        final WeakReference<GuildSubChannelSettingDialogFragment> f227219a;

        /* renamed from: b, reason: collision with root package name */
        final WeakReference<FragmentManager> f227220b;

        /* renamed from: c, reason: collision with root package name */
        final boolean f227221c;

        a(GuildSubChannelSettingDialogFragment guildSubChannelSettingDialogFragment, boolean z16) {
            this.f227219a = new WeakReference<>(guildSubChannelSettingDialogFragment);
            this.f227220b = new WeakReference<>(guildSubChannelSettingDialogFragment.getParentFragmentManager());
            this.f227221c = z16;
        }

        private void a() {
            if (this.f227219a.get() == null) {
                return;
            }
            if (this.f227221c) {
                b();
            } else {
                QQToast.makeText(BaseApplication.getContext(), 2, R.string.f141880hv, 0).show();
            }
        }

        private void b() {
            GuildSubChannelSettingDialogFragment guildSubChannelSettingDialogFragment = this.f227219a.get();
            if (guildSubChannelSettingDialogFragment == null) {
                return;
            }
            if (bw.o0()) {
                QQToast.makeText(BaseApplication.getContext(), 2, R.string.f141020fj, 0).show();
                return;
            }
            FragmentManager fragmentManager = this.f227220b.get();
            if (fragmentManager == null) {
                return;
            }
            bw.W1();
            GuildSubscribeSuccessDialogFragment.Oh(fragmentManager);
            guildSubChannelSettingDialogFragment.dismissAllowingStateLoss();
        }

        @Override // vh2.cc
        public void onResult(int i3, String str) {
            GuildSubChannelSettingDialogFragment guildSubChannelSettingDialogFragment = this.f227219a.get();
            if (guildSubChannelSettingDialogFragment == null) {
                return;
            }
            if (i3 == 0) {
                a();
            } else if (i3 == 110000) {
                QQToast.makeText(BaseApplication.getContext(), 1, R.string.f141010fi, 0).show();
                if (guildSubChannelSettingDialogFragment.isAdded()) {
                    guildSubChannelSettingDialogFragment.I.setCheckedOnly(guildSubChannelSettingDialogFragment.vh(guildSubChannelSettingDialogFragment.C.channelInfo));
                }
            } else if (i3 == 11009) {
                QQToast.makeText(BaseApplication.getContext(), 1, R.string.f141000fh, 0).show();
                if (guildSubChannelSettingDialogFragment.isAdded()) {
                    guildSubChannelSettingDialogFragment.I.setCheckedOnly(guildSubChannelSettingDialogFragment.vh(guildSubChannelSettingDialogFragment.C.channelInfo));
                }
            } else {
                QQToast.makeText(BaseApplication.getContext(), 1, R.string.f1511016s, 0).show();
                if (guildSubChannelSettingDialogFragment.isAdded()) {
                    guildSubChannelSettingDialogFragment.I.setCheckedOnly(guildSubChannelSettingDialogFragment.vh(guildSubChannelSettingDialogFragment.C.channelInfo));
                }
            }
            QLog.d("Guild.MF.Rt.GuildSubChannelSettingDialogFragment", 1, "addToMsgList result=" + i3 + ", errMsg=" + str);
        }
    }

    private void Ah() {
        VideoReport.addToDetectionWhitelist(getActivity());
        VideoReport.setPageId(this.E, this.C.guildFacadeType.getReportPageId());
        VideoReport.setPageContentId(this.E, "GuildSubChannelSettingDialogFragment");
        HashMap hashMap = new HashMap();
        w.b(hashMap);
        ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).setGuildPageParams(this.E, this.C.channelInfo.getGuildId(), hashMap);
    }

    public static void Bh(QBaseActivity qBaseActivity, @NonNull GuildSubChannelParams guildSubChannelParams) {
        Ch(qBaseActivity, guildSubChannelParams, null);
    }

    public static void Ch(QBaseActivity qBaseActivity, @NonNull GuildSubChannelParams guildSubChannelParams, DialogInterface.OnDismissListener onDismissListener) {
        boolean showOldSettingPage = guildSubChannelParams.showOldSettingPage();
        boolean isSelfGuest = ((IGuildChannelApi) QRoute.api(IGuildChannelApi.class)).isSelfGuest(guildSubChannelParams.channelInfo.getChannelUin(), guildSubChannelParams.channelInfo.getGuildId());
        QLog.i("Guild.MF.Rt.GuildSubChannelSettingDialogFragment", 2, "show GuildSubChannelSettingDialogFragment params :" + guildSubChannelParams + " showOldSettingPage=" + showOldSettingPage + " isGuest=" + isSelfGuest);
        if (!isSelfGuest && showOldSettingPage) {
            Bundle bundle = new Bundle();
            bundle.putSerializable("params", guildSubChannelParams);
            GuildSubChannelSettingDialogFragment guildSubChannelSettingDialogFragment = new GuildSubChannelSettingDialogFragment();
            guildSubChannelSettingDialogFragment.setArguments(bundle);
            guildSubChannelSettingDialogFragment.setOnDismissListener(onDismissListener);
            guildSubChannelSettingDialogFragment.show(qBaseActivity.getSupportFragmentManager(), "Guild.MF.Rt.GuildSubChannelSettingDialogFragment");
        }
    }

    private void Dh(boolean z16) {
        AppInterface appInterface = getAppInterface();
        if (appInterface == null) {
            return;
        }
        int i3 = 1;
        if (System.currentTimeMillis() - this.D < 500) {
            this.I.setCheckedOnly(!z16);
            return;
        }
        this.D = System.currentTimeMillis();
        if (!NetworkUtil.isNetworkAvailable()) {
            QQToast.makeText(BaseApplication.getContext(), 1, R.string.f1511016s, 0).show();
            this.I.setCheckedOnly(vh(this.C.channelInfo));
            return;
        }
        e eVar = (e) appInterface.getRuntimeService(IGPSService.class, "");
        IGProChannelInfo iGProChannelInfo = this.C.channelInfo;
        if (!z16) {
            i3 = 2;
        }
        eVar.setQQMsgListChannel(iGProChannelInfo.getGuildId(), iGProChannelInfo.getChannelUin(), i3, new a(this, z16));
        yh(z16);
    }

    private AppInterface getAppInterface() {
        return ch.l();
    }

    private void initView() {
        this.G = (LinearLayout) this.E.findViewById(R.id.f901151l);
        this.H = (RelativeLayout) this.E.findViewById(R.id.sdm);
        this.I = (GuildSwitchButton) this.E.findViewById(R.id.sdn);
        TextView textView = (TextView) this.E.findViewById(R.id.f901451o);
        this.F = textView;
        textView.setText(this.C.channelInfo.getChannelName());
        if (this.C.isManager) {
            this.G.setVisibility(0);
            this.G.setOnClickListener(this);
        } else {
            this.G.setVisibility(8);
        }
        if (this.C.isSupportSubscription) {
            this.H.setVisibility(0);
            this.I.setOnCheckedChangeListener(this);
            this.I.setCheckedOnly(vh(this.C.channelInfo));
        } else {
            this.H.setVisibility(8);
        }
        Ah();
        zh();
    }

    public static GuildSubChannelParams th(@NonNull IGProChannelInfo iGProChannelInfo, GuildFacadeType guildFacadeType) {
        boolean z16;
        GuildSubChannelParams guildSubChannelParams = new GuildSubChannelParams();
        guildSubChannelParams.isManager = as.j(iGProChannelInfo);
        IGuildInfoUtilsApi iGuildInfoUtilsApi = (IGuildInfoUtilsApi) QRoute.api(IGuildInfoUtilsApi.class);
        int channelType = iGuildInfoUtilsApi.getChannelType(ch.m(), iGProChannelInfo.getGuildId(), iGProChannelInfo.getChannelUin());
        boolean z17 = false;
        if (!iGuildInfoUtilsApi.isSupportTextChannleAbility(channelType) && !l.f235569a.c(channelType)) {
            z16 = false;
        } else {
            z16 = true;
        }
        guildSubChannelParams.isSupportTextChannelAbility = z16;
        IGPSService iGPSService = (IGPSService) ch.R0(IGPSService.class);
        if (guildFacadeType != GuildFacadeType.ChatList && guildFacadeType != GuildFacadeType.FeedsGuildHomeSubChannel9015) {
            if (iGuildInfoUtilsApi.isSupportSubscriptionChannelAbility(channelType) && !iGPSService.isQQMsgListGuild(az.d(iGProChannelInfo.getGuildId(), 0L)) && !d12.a.c()) {
                z17 = true;
            }
            guildSubChannelParams.isSupportSubscription = z17;
        } else {
            guildSubChannelParams.isSupportSubscription = false;
            if (!iGPSService.isQQMsgListGuild(az.d(iGProChannelInfo.getGuildId(), 0L))) {
                QLog.w("Guild.MF.Rt.GuildSubChannelSettingDialogFragment", 1, "isQQMsgListGuild error: " + iGProChannelInfo.getGuildId() + "-" + iGProChannelInfo.getChannelUin());
            }
        }
        guildSubChannelParams.channelInfo = iGProChannelInfo;
        guildSubChannelParams.guildFacadeType = guildFacadeType;
        if (QLog.isColorLevel()) {
            QLog.i("Guild.MF.Rt.GuildSubChannelSettingDialogFragment", 2, "getSettingParams: " + guildSubChannelParams);
        }
        return guildSubChannelParams;
    }

    private boolean uh() {
        Bundle arguments = getArguments();
        if (arguments == null) {
            QLog.e("Guild.MF.Rt.GuildSubChannelSettingDialogFragment", 1, "onCreate error: bundle is null");
            dismiss();
            return false;
        }
        GuildSubChannelParams guildSubChannelParams = (GuildSubChannelParams) arguments.getSerializable("params");
        this.C = guildSubChannelParams;
        if (guildSubChannelParams != null && guildSubChannelParams.canShowSettingDialog()) {
            return true;
        }
        QLog.i("Guild.MF.Rt.GuildSubChannelSettingDialogFragment", 2, "invalid params: " + this.C);
        dismiss();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean vh(IGProChannelInfo iGProChannelInfo) {
        AppInterface appInterface = getAppInterface();
        if (appInterface == null) {
            return false;
        }
        return ((e) appInterface.getRuntimeService(IGPSService.class, "")).isQQMsgListChannel(iGProChannelInfo.getGuildId(), iGProChannelInfo.getChannelUin());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Map wh(String str) {
        String str2;
        HashMap hashMap = new HashMap();
        hashMap.put("sgrp_sub_channel_id", this.C.channelInfo.getChannelUin());
        hashMap.put("sgrp_sub_channel_type", Integer.valueOf(this.C.channelInfo.getType()));
        if (this.I.isChecked()) {
            str2 = "1";
        } else {
            str2 = "2";
        }
        hashMap.put("sgrp_sub_channel_switch", str2);
        return hashMap;
    }

    private void xh() {
        if (getAppInterface() == null) {
            QLog.e("Guild.MF.Rt.GuildSubChannelSettingDialogFragment", 1, "openChannelInfoSetting failed: appInterface null");
        } else {
            ((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).openGuildChannelInfoSetting(getAppInterface(), getContext(), this.C.channelInfo.getGuildId(), this.C.channelInfo.getChannelUin(), 0);
            dismiss();
        }
    }

    private void yh(boolean z16) {
        int i3;
        HashMap hashMap = new HashMap();
        if (z16) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        hashMap.put("sgrp_sub_channel_switch", Integer.valueOf(i3));
        VideoReport.reportEvent("clck", this.H, hashMap);
    }

    private void zh() {
        ch.X0(this.I, "em_sgrp_add_shortcut", new IDynamicParams() { // from class: com.tencent.mobileqq.guild.main.view.b
            @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
            public final Map getDynamicParams(String str) {
                Map wh5;
                wh5 = GuildSubChannelSettingDialogFragment.this.wh(str);
                return wh5;
            }
        });
        ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).setElementExposureAllAndClickPolicy(this.G, "em_sgrp_sub_channel_manage");
    }

    @Override // com.tencent.mobileqq.guild.widget.GuildSwitchButton.a
    public void onCheckedChanged(GuildSwitchButton guildSwitchButton, boolean z16) {
        if (guildSwitchButton == this.I) {
            Dh(z16);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view == this.G) {
            xh();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) super.onCreateDialog(bundle);
        aVar.getWindow().setWindowAnimations(R.style.avr);
        aVar.getBehavior().setState(3);
        aVar.getBehavior().setSkipCollapsed(true);
        return aVar;
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.E = layoutInflater.inflate(R.layout.f9l, viewGroup, false);
        if (uh()) {
            initView();
        }
        View view = this.E;
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(@NonNull DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        DialogInterface.OnDismissListener onDismissListener = this.J;
        if (onDismissListener != null) {
            onDismissListener.onDismiss(dialogInterface);
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        dismissAllowingStateLoss();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        ((View) this.E.getParent()).setBackgroundColor(0);
    }

    public void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        this.J = onDismissListener;
    }
}
