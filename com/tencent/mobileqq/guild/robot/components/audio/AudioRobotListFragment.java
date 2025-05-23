package com.tencent.mobileqq.guild.robot.components.audio;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.media.core.data.f;
import com.tencent.mobileqq.guild.media.core.j;
import com.tencent.mobileqq.guild.media.core.notify.y;
import com.tencent.mobileqq.guild.robot.api.model.GuildChannel;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqnt.kernel.nativeinterface.GProGetGuildRobotListRsp;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.HashMap;
import java.util.Observable;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import zw1.e;

/* compiled from: P */
/* loaded from: classes14.dex */
public class AudioRobotListFragment extends BottomSheetDialogFragment {
    private static b X;
    private Activity C;
    private View D;
    private e E;
    private RecyclerView F;
    private RecyclerView G;
    private zw1.a H;
    private zw1.a I;
    private LinearLayout J;
    private LinearLayout K;
    private TextView L;
    private TextView M;
    private View N;
    private View P;
    private GuildChannel Q;
    private GProGetGuildRobotListRsp R;
    String S;
    String T;
    private IntentFilter U;
    private final com.tencent.mobileqq.guild.robot.driver.audio.b V = new a();
    private c W = new c();

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class a extends com.tencent.mobileqq.guild.robot.driver.audio.b {
        a() {
        }

        @Override // java.util.Observer
        public void update(Observable observable, Object obj) {
            if (AudioRobotListFragment.this.H != null) {
                AudioRobotListFragment.this.H.notifyDataSetChanged();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public interface b {
        void a();

        void b();
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    private class c extends y {
        c() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.y
        public void x(String str, String str2, String str3, f fVar) {
            super.x(str, str2, str3, fVar);
            if ("onAudioChannelUserExit".equals(str)) {
                AudioRobotListFragment.this.refreshUI();
            }
        }
    }

    private void hideLoading() {
        View view = this.P;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    private void initData() {
        Bundle arguments;
        if (this.C == null || (arguments = getArguments()) == null) {
            return;
        }
        this.S = arguments.getString("guildId");
        this.T = arguments.getString("channelId");
        GuildChannel guildChannel = new GuildChannel();
        this.Q = guildChannel;
        guildChannel.e(xh(this.S, 0L));
        this.Q.c(xh(this.T, 0L));
    }

    private void initUI() {
        this.N = this.D.findViewById(R.id.b_7);
        this.P = this.D.findViewById(R.id.efs);
        this.F = (RecyclerView) this.D.findViewById(R.id.vwv);
        this.G = (RecyclerView) this.D.findViewById(R.id.vws);
        this.J = (LinearLayout) this.D.findViewById(R.id.vwx);
        this.K = (LinearLayout) this.D.findViewById(R.id.vwu);
        this.M = (TextView) this.D.findViewById(R.id.wse);
        this.L = (TextView) this.D.findViewById(R.id.vwt);
        showLoading();
        this.N.setVisibility(8);
        IntentFilter intentFilter = new IntentFilter();
        this.U = intentFilter;
        intentFilter.addAction("com.tencent.mobileqq.guild_robot_close_fragment");
        this.F.setLayoutManager(new LinearLayoutManager(MobileQQ.sMobileQQ.getApplicationContext()));
        this.G.setLayoutManager(new LinearLayoutManager(MobileQQ.sMobileQQ.getApplicationContext()));
        this.H = new zw1.a(getActivity(), e.k(), this.Q, true, this.E);
        this.I = new zw1.a(getActivity(), e.j(), this.Q, false, this.E);
        this.F.setAdapter(this.H);
        this.G.setAdapter(this.I);
    }

    private void showLoading() {
        View view = this.P;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    private void th() {
        Window window;
        com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) getDialog();
        if (aVar == null || (window = aVar.getWindow()) == null) {
            return;
        }
        window.setLayout(-1, QQGuildUIUtil.p(getActivity()).f185861b - (ViewUtils.dip2px(30.0f) + ImmersiveUtils.getStatusBarHeight(this.C)));
        window.setGravity(80);
    }

    private void uh() {
        ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).setElementExposureAndClickParams(this.J, "em_qqrobot_added_module", null);
        LinearLayout linearLayout = this.J;
        EndExposurePolicy endExposurePolicy = EndExposurePolicy.REPORT_ALL;
        VideoReport.setElementEndExposePolicy(linearLayout, endExposurePolicy);
        ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).setElementExposureAndClickParams(this.K, "em_qqrobot_not_added_module", null);
        VideoReport.setElementEndExposePolicy(this.K, endExposurePolicy);
    }

    private void vh() {
        VideoReport.addToDetectionWhitelist((QBaseActivity) getActivity());
        VideoReport.setPageId(this.D, "pg_qqrobot_voicechannel_robotlist");
        VideoReport.setElementExposePolicy(this.D, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(this.D, ClickPolicy.REPORT_ALL);
        VideoReport.setElementEndExposePolicy(this.D, EndExposurePolicy.REPORT_ALL);
        if (this.R != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("qq_robot_channel_id", this.S);
            hashMap.put("qq_robot_role_type", Integer.valueOf(this.R.getRole()));
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime == null) {
                return;
            }
            IGProGuildInfo guildInfo = ((IGPSService) peekAppRuntime.getRuntimeService(IGPSService.class, "")).getGuildInfo(this.S);
            if (guildInfo != null) {
                hashMap.put("qq_robot_channel_name", guildInfo.getGuildName());
            }
            ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).setGuildPageParams(this.D, this.S, hashMap);
        }
    }

    public static void wh(FragmentActivity fragmentActivity, String str, String str2, int i3, b bVar) {
        if (fragmentActivity == null) {
            return;
        }
        X = bVar;
        Bundle bundle = new Bundle();
        bundle.putString("channelId", str);
        bundle.putString("guildId", str2);
        bundle.putInt("robotType", i3);
        AudioRobotListFragment audioRobotListFragment = new AudioRobotListFragment();
        audioRobotListFragment.setArguments(bundle);
        FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        if (supportFragmentManager.isDestroyed()) {
            return;
        }
        FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
        beginTransaction.add(audioRobotListFragment, "AddRobotFragment");
        beginTransaction.commitAllowingStateLoss();
        b bVar2 = X;
        if (bVar2 != null) {
            bVar2.b();
        }
    }

    private long xh(String str, long j3) {
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return j3;
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NonNull Configuration configuration) {
        super.onConfigurationChanged(configuration);
        th();
        refreshUI();
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View view;
        this.C = getActivity();
        this.D = layoutInflater.inflate(R.layout.f5q, viewGroup, false);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        this.E = new e(this);
        if (peekAppRuntime == null) {
            this.C.finish();
            view = this.D;
        } else {
            initData();
            initUI();
            view = this.D;
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(@NonNull DialogInterface dialogInterface) {
        b bVar = X;
        if (bVar != null) {
            bVar.a();
            X = null;
        }
        super.onDismiss(dialogInterface);
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.Fragment
    public void onPause() {
        com.tencent.mobileqq.guild.robot.driver.audio.a.b().deleteObserver(this.V);
        j.a().l0().B(this.W);
        super.onPause();
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ((ViewGroup) this.D.getParent()).setBackgroundColor(0);
        th();
        com.tencent.mobileqq.guild.robot.driver.audio.a.b().addObserver(this.V);
        j.a().l0().b(this.W);
        this.E.l(this.Q, 1, false);
    }

    public void qh(boolean z16, int i3, String str, String str2) {
        if (z16) {
            refreshUI();
        } else {
            QQToast.makeText(MobileQQ.sMobileQQ.getApplicationContext(), 4, MobileQQ.sMobileQQ.getApplicationContext().getString(R.string.f143360lv), 0).show();
        }
    }

    public void refresh() {
        this.E.l(this.Q, 1, true);
    }

    public void refreshUI() {
        if (e.k() != null && getActivity() != null) {
            if (e.k().size() <= 0) {
                this.J.setVisibility(8);
                this.K.setVisibility(8);
            } else {
                this.J.setVisibility(0);
            }
            if (e.j().size() <= 0) {
                this.G.setVisibility(8);
                if (e.k().size() <= 0) {
                    this.M.setVisibility(0);
                }
                this.L.setVisibility(8);
            } else {
                this.K.setVisibility(0);
                this.G.setVisibility(0);
                this.L.setVisibility(0);
                this.M.setVisibility(8);
            }
            this.H.t0(e.k());
            this.I.t0(e.j());
        }
    }

    public void rh(GProGetGuildRobotListRsp gProGetGuildRobotListRsp, boolean z16) {
        if (z16) {
            this.R = gProGetGuildRobotListRsp;
            hideLoading();
            this.N.setVisibility(0);
            refreshUI();
            vh();
            uh();
            return;
        }
        QQToast.makeText(MobileQQ.sMobileQQ.getApplicationContext(), 4, R.string.f154081du, 0).show();
        hideLoading();
        dismiss();
    }

    public void sh(boolean z16, int i3, String str, String str2) {
        if (z16) {
            this.E.h();
        } else {
            QQToast.makeText(MobileQQ.sMobileQQ.getApplicationContext(), 4, str, 0).show();
        }
    }
}
