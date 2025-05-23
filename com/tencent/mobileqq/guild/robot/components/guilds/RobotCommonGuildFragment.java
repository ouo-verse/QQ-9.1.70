package com.tencent.mobileqq.guild.robot.components.guilds;

import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.gson.Gson;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.robot.components.base.widget.RobotLoadingView;
import com.tencent.mobileqq.guild.robot.components.console.RobotInfo;
import com.tencent.mobileqq.guild.robot.components.guilds.RobotCommonGuildFragment;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqnt.kernel.api.ac;
import com.tencent.qqnt.kernel.nativeinterface.GProRobotCommonGuildReq;
import com.tencent.qqnt.kernel.nativeinterface.GProRobotCommonGuildRsp;
import com.tencent.qqnt.kernel.nativeinterface.IGProFetchRobotCommonGuildCallback;
import com.tencent.widget.immersive.ImmersiveUtils;
import fx1.b;
import java.util.ArrayList;
import java.util.HashMap;
import sx1.f;

/* compiled from: P */
/* loaded from: classes14.dex */
public class RobotCommonGuildFragment extends BottomSheetDialogFragment {
    private RecyclerView C;
    private RobotLoadingView D;
    private RobotInfo E;
    private Bundle F;
    private View G;
    private LinearLayout H;
    private a I;
    private b J;

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public interface a {
        void onDismiss(boolean z16);
    }

    private void init(View view) {
        this.G = view;
        this.C = (RecyclerView) view.findViewById(R.id.f770743d);
        this.D = (RobotLoadingView) view.findViewById(R.id.f7693430);
        this.H = (LinearLayout) view.findViewById(R.id.f771143h);
        RobotLoadingView robotLoadingView = this.D;
        if (robotLoadingView != null) {
            robotLoadingView.setLoadingBg(R.drawable.guild_robot_common_guild_loading_bg);
            this.D.setVisibility(0);
        }
        Bundle arguments = getArguments();
        this.F = arguments;
        if (arguments == null) {
            return;
        }
        this.E = (RobotInfo) new Gson().fromJson(this.F.getString("ROBOT_INFO_KEY"), RobotInfo.class);
        ac g16 = f.g();
        if (g16 == null) {
            return;
        }
        g16.fetchRobotCommonGuild(new GProRobotCommonGuildReq(this.E.l(), 0, 20, this.E.k(), 1, 0L, new ArrayList(), new ArrayList()), new IGProFetchRobotCommonGuildCallback() { // from class: fx1.c
            @Override // com.tencent.qqnt.kernel.nativeinterface.IGProFetchRobotCommonGuildCallback
            public final void onFetchRobotCommonGuild(int i3, String str, GProRobotCommonGuildRsp gProRobotCommonGuildRsp) {
                RobotCommonGuildFragment.this.th(i3, str, gProRobotCommonGuildRsp);
            }
        });
    }

    private void rh(View view) {
        if (this.F == null) {
            return;
        }
        VideoReport.addToDetectionWhitelist(getActivity());
        VideoReport.setPageId(view, "pg_qqrobot_common_channel");
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_ALL);
        VideoReport.setPageParams(view, new PageParams((HashMap) this.F.getSerializable("ROBOT_COMMON_GUILD_DA_TONG_DATA")));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void th(int i3, String str, final GProRobotCommonGuildRsp gProRobotCommonGuildRsp) {
        if (i3 == 0 && gProRobotCommonGuildRsp != null) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: fx1.d
                @Override // java.lang.Runnable
                public final void run() {
                    RobotCommonGuildFragment.this.sh(gProRobotCommonGuildRsp);
                }
            });
            return;
        }
        QLog.e("RobotCommonGuildFragmen", 1, "fetchRobotCommonGuild | result=" + i3 + " errMsg=" + str);
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        dismiss();
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.f57, (ViewGroup) null);
        init(inflate);
        rh(inflate);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(@NonNull DialogInterface dialogInterface) {
        b bVar;
        super.onDismiss(dialogInterface);
        a aVar = this.I;
        if (aVar != null && (bVar = this.J) != null) {
            aVar.onDismiss(bVar.k0());
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Window window;
        super.onResume();
        if (this.G.getParent() instanceof View) {
            ((View) this.G.getParent()).setBackgroundColor(0);
        }
        int instantScreenHeight = ScreenUtil.getInstantScreenHeight(getContext());
        com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) getDialog();
        if (aVar == null || aVar.getWindow() == null || (window = aVar.getWindow()) == null) {
            return;
        }
        int statusBarHeight = instantScreenHeight - ImmersiveUtils.getStatusBarHeight(getContext());
        aVar.getBehavior().setPeekHeight(statusBarHeight);
        window.setLayout(-1, statusBarHeight);
        window.setGravity(80);
    }

    @Override // androidx.fragment.app.DialogFragment
    public void show(FragmentManager fragmentManager, String str) {
        try {
            FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
            beginTransaction.add(this, str);
            beginTransaction.commitAllowingStateLoss();
        } catch (IllegalStateException e16) {
            QLog.e("RobotCommonGuildFragmen", 1, e16, new Object[0]);
        }
    }

    public void uh(a aVar) {
        this.I = aVar;
    }

    /* renamed from: vh, reason: merged with bridge method [inline-methods] */
    public void sh(GProRobotCommonGuildRsp gProRobotCommonGuildRsp) {
        RobotLoadingView robotLoadingView = this.D;
        if (robotLoadingView != null) {
            robotLoadingView.setVisibility(8);
        }
        this.C.setLayoutManager(new LinearLayoutManager(getContext()));
        b bVar = new b(getContext(), gProRobotCommonGuildRsp, this);
        this.J = bVar;
        this.C.setAdapter(bVar);
        if (gProRobotCommonGuildRsp.getTotal() <= 0) {
            this.H.setVisibility(0);
            this.C.setVisibility(8);
        } else {
            this.H.setVisibility(8);
            this.C.setVisibility(0);
        }
    }
}
