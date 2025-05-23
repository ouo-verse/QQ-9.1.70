package com.tencent.mobileqq.guild.robot.components.auth;

import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.Gson;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.guild.robot.api.impl.GuildRobotPageApiImpl;
import com.tencent.mobileqq.guild.robot.components.auth.RobotAuthorizeAddInfo;
import com.tencent.mobileqq.guild.robot.components.auth.RobotPermissionFragment;
import com.tencent.mobileqq.guild.robot.components.auth.b;
import com.tencent.mobileqq.guild.rolegroup.model.data.GuildTarget;
import com.tencent.mobileqq.guild.rolegroup.model.repositories.r;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqnt.kernel.api.ac;
import com.tencent.qqnt.kernel.nativeinterface.GProGuildRobotAuthSetInfo;
import com.tencent.qqnt.kernel.nativeinterface.GProGuildRobotPermissionReq;
import com.tencent.qqnt.kernel.nativeinterface.GProGuildRobotPermissionRsp;
import com.tencent.qqnt.kernel.nativeinterface.GProGuildRobotSetPermissionReq;
import com.tencent.qqnt.kernel.nativeinterface.IGProFetchGuildRobotPermissionCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGProRobotSimpleResultCallback;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* loaded from: classes14.dex */
public class RobotPermissionFragment extends QPublicBaseFragment {
    private ImageView C;
    private RecyclerView D;
    private Bundle E;
    private View F;
    private c G;
    private int H;
    private int I;
    private String J;
    private String K;
    private String L;
    private String M;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes14.dex */
    public class a implements IGProFetchGuildRobotPermissionCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f232093a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f232094b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ AppRuntime f232095c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ b.a f232096d;

        a(String str, String str2, AppRuntime appRuntime, b.a aVar) {
            this.f232093a = str;
            this.f232094b = str2;
            this.f232095c = appRuntime;
            this.f232096d = aVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d(int i3, String str, String str2, String str3) {
            QQToast.makeText(RobotPermissionFragment.this.getContext(), R.string.f1511016s, 1).show();
            QLog.e("RobotPermissionFragment", 1, "errCode = " + i3 + " msg = " + str + " guildId = " + str2 + " robotUin = " + str3);
            RobotPermissionFragment.this.getActivity().finish();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void e(int i3, GProGuildRobotPermissionRsp gProGuildRobotPermissionRsp, String str) {
            if (i3 == 0 && gProGuildRobotPermissionRsp != null) {
                h(gProGuildRobotPermissionRsp);
            } else {
                g(i3, str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void f(GProGuildRobotPermissionRsp gProGuildRobotPermissionRsp, String str, String str2, AppRuntime appRuntime, b.a aVar, RobotAuthorizeAddInfo robotAuthorizeAddInfo) {
            int operatorRole = gProGuildRobotPermissionRsp.getOperatorRole();
            int role = gProGuildRobotPermissionRsp.getRole();
            GuildRobotPageApiImpl.updateCache(RobotPermissionFragment.this.getContext(), str, str2, gProGuildRobotPermissionRsp);
            if (operatorRole == 0) {
                QQToast.makeText(appRuntime.getApp(), 0, HardCodeUtil.qqStr(R.string.f15124176), 1).show();
                RobotPermissionFragment.this.getActivity().finish();
            } else if (operatorRole == 1 && role == 1) {
                QQToast.makeText(appRuntime.getApp(), 0, HardCodeUtil.qqStr(R.string.f138820_l), 1).show();
                RobotPermissionFragment.this.getActivity().finish();
            } else if (aVar != null) {
                aVar.a(0, "", robotAuthorizeAddInfo);
            }
        }

        public void g(final int i3, final String str) {
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final String str2 = this.f232094b;
            final String str3 = this.f232093a;
            uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.guild.robot.components.auth.g
                @Override // java.lang.Runnable
                public final void run() {
                    RobotPermissionFragment.a.this.d(i3, str, str2, str3);
                }
            });
        }

        public void h(final GProGuildRobotPermissionRsp gProGuildRobotPermissionRsp) {
            final RobotAuthorizeAddInfo a16 = RobotAuthorizeAddInfo.a(gProGuildRobotPermissionRsp);
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final String str = this.f232093a;
            final String str2 = this.f232094b;
            final AppRuntime appRuntime = this.f232095c;
            final b.a aVar = this.f232096d;
            uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.guild.robot.components.auth.h
                @Override // java.lang.Runnable
                public final void run() {
                    RobotPermissionFragment.a.this.f(gProGuildRobotPermissionRsp, str, str2, appRuntime, aVar, a16);
                }
            });
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IGProFetchGuildRobotPermissionCallback
        public void onFetchGuildRobotPermission(final int i3, final String str, final GProGuildRobotPermissionRsp gProGuildRobotPermissionRsp) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.robot.components.auth.f
                @Override // java.lang.Runnable
                public final void run() {
                    RobotPermissionFragment.a.this.e(i3, gProGuildRobotPermissionRsp, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ah(int i3, String str) {
        if (i3 != 0) {
            QLog.e("RobotPermissionFragment", 1, "setGuildRobotPermission|result=" + i3 + " errMsg=" + str);
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: ax1.r
                @Override // java.lang.Runnable
                public final void run() {
                    RobotPermissionFragment.zh();
                }
            });
            return;
        }
        vh();
    }

    private void Ch() {
        RobotAuthorizeAddInfo l06;
        ArrayList<GProGuildRobotAuthSetInfo> uh5;
        ac g16 = sx1.f.g();
        if (g16 == null || (uh5 = uh((l06 = this.G.l0()))) == null) {
            return;
        }
        g16.setGuildRobotPermission(new GProGuildRobotSetPermissionReq(Long.parseLong(this.J), Long.parseLong(this.M), l06.f(), uh5, l06.c()), new IGProRobotSimpleResultCallback() { // from class: ax1.q
            @Override // com.tencent.qqnt.kernel.nativeinterface.IGProRobotSimpleResultCallback
            public final void onResult(int i3, String str) {
                RobotPermissionFragment.this.Ah(i3, str);
            }
        });
    }

    private void Dh() {
        if (this.G == null) {
            return;
        }
        if (this.I == 1 && this.H == 1) {
            return;
        }
        Ch();
    }

    private void Eh(RobotAuthorizeAddInfo robotAuthorizeAddInfo) {
        if (this.G == null) {
            this.G = new c(getContext(), this.H);
        }
        this.I = robotAuthorizeAddInfo.f();
        this.F.setVisibility(8);
        this.G.m0(robotAuthorizeAddInfo);
        this.D.setAdapter(this.G);
        this.D.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    private void initData() {
        IGProGuildInfo iGProGuildInfo;
        if (getActivity() != null && getActivity().getIntent() != null) {
            this.E = getActivity().getIntent().getBundleExtra("ROBOT_PERMISSION_SETTING_FLAG");
        }
        Bundle bundle = this.E;
        if (bundle == null) {
            return;
        }
        this.J = bundle.getString("guildId");
        this.K = this.E.getString("channelId");
        this.M = this.E.getString("ROBOT_UIN_KEY");
        this.L = this.E.getString("ROBOT_TID_KEY");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            iGProGuildInfo = ((IGPSService) peekAppRuntime.getRuntimeService(IGPSService.class, "")).getGuildInfo(this.J);
        } else {
            iGProGuildInfo = null;
        }
        if (iGProGuildInfo != null) {
            this.H = iGProGuildInfo.getUserType();
        } else {
            getActivity().finish();
        }
    }

    private void initView(View view) {
        this.C = (ImageView) view.findViewById(R.id.f763641g);
        this.D = (RecyclerView) view.findViewById(R.id.f771443k);
        View findViewById = view.findViewById(R.id.f771543l);
        this.F = findViewById;
        findViewById.setVisibility(0);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.root);
        if (ImmersiveUtils.isSupporImmersive() == 1) {
            linearLayout.setFitsSystemWindows(true);
            linearLayout.setPadding(0, ImmersiveUtils.getStatusBarHeight(getContext()), 0, 0);
        }
        this.C.setOnClickListener(new View.OnClickListener() { // from class: ax1.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                RobotPermissionFragment.this.lambda$initView$0(view2);
            }
        });
        if (QQTheme.isNowThemeIsNight()) {
            getActivity().getWindow().getDecorView().setSystemUiVisibility(1024);
        } else {
            getActivity().getWindow().getDecorView().setSystemUiVisibility(9216);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$0(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Dh();
        getActivity().finish();
        EventCollector.getInstance().onViewClicked(view);
    }

    @Nullable
    private ArrayList<GProGuildRobotAuthSetInfo> uh(RobotAuthorizeAddInfo robotAuthorizeAddInfo) {
        List<RobotAuthorizeAddInfo.Permission> e16 = robotAuthorizeAddInfo.e();
        if (e16 == null) {
            QLog.e("RobotPermissionFragment", 1, "permissionList is null!");
            return null;
        }
        return (ArrayList) RobotAuthorizeAddInfo.Permission.a(new ArrayList(e16.size()), e16);
    }

    private void vh() {
        GuildTarget e16;
        if (TextUtils.isEmpty(this.L)) {
            return;
        }
        String str = this.K;
        if (str != null) {
            e16 = GuildTarget.d(this.J, str);
        } else {
            e16 = GuildTarget.e(this.J);
        }
        r.p().n(e16, this.L, new com.tencent.mobileqq.guild.base.repository.h() { // from class: ax1.s
            @Override // com.tencent.mobileqq.guild.base.repository.h
            public final void a(ri1.a aVar, Object obj) {
                RobotPermissionFragment.xh(aVar, (List) obj);
            }
        });
    }

    private void wh(View view) {
        if (this.E == null) {
            return;
        }
        VideoReport.addToDetectionWhitelist(getActivity());
        VideoReport.setPageId(view, "pg_qqrobot_card_permissions_more");
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_ALL);
        VideoReport.setPageParams(view, new PageParams((HashMap) this.E.getSerializable("ROBOT_PERMISSION_DA_TONG")));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void xh(ri1.a aVar, List list) {
        if (aVar != null) {
            QLog.e("RobotPermissionFragment", 1, aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void yh(int i3, String str, RobotAuthorizeAddInfo robotAuthorizeAddInfo) {
        Eh(robotAuthorizeAddInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void zh() {
        QQToast.makeText(BaseApplication.context, R.string.f154261eb, 1).show();
    }

    public void Bh(AppRuntime appRuntime, String str, String str2, b.a aVar) {
        ac g16 = sx1.f.g();
        if (g16 == null) {
            return;
        }
        g16.fetchGuildRobotPermission(new GProGuildRobotPermissionReq(Long.parseLong(str), Long.parseLong(str2)), new a(str2, str, appRuntime, aVar));
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        Dh();
        return false;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.f168168f60, (ViewGroup) null);
        initView(inflate);
        initData();
        wh(inflate);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        RobotAuthorizeAddInfo robotAuthorizeAddInfo = null;
        String string = this.E.getString("ROBOT_PERMISSION_DATA", null);
        if (!TextUtils.isEmpty(string)) {
            robotAuthorizeAddInfo = (RobotAuthorizeAddInfo) new Gson().fromJson(string, RobotAuthorizeAddInfo.class);
        }
        if (robotAuthorizeAddInfo == null) {
            Bh(MobileQQ.sMobileQQ.peekAppRuntime(), this.J, this.M, new b.a() { // from class: ax1.o
                @Override // com.tencent.mobileqq.guild.robot.components.auth.b.a
                public final void a(int i3, String str, RobotAuthorizeAddInfo robotAuthorizeAddInfo2) {
                    RobotPermissionFragment.this.yh(i3, str, robotAuthorizeAddInfo2);
                }
            });
        } else {
            Eh(robotAuthorizeAddInfo);
        }
    }
}
