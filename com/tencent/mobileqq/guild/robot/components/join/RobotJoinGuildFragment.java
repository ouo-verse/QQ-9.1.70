package com.tencent.mobileqq.guild.robot.components.join;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment;
import com.tencent.mobileqq.guild.robot.api.model.GuildChannel;
import com.tencent.mobileqq.guild.robot.components.auth.RobotAuthorizeAddFragment;
import com.tencent.mobileqq.guild.robot.components.base.widget.RobotLoadingView;
import com.tencent.mobileqq.guild.robot.components.console.RobotInfo;
import com.tencent.mobileqq.guild.robot.components.join.RobotJoinGuildFragment;
import com.tencent.mobileqq.guild.robot.components.join.a;
import com.tencent.mobileqq.guild.robot.components.share.e;
import com.tencent.mobileqq.guild.util.v;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.common.EventData;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.util.QQToastUtil;
import gx1.j;
import java.util.HashMap;
import java.util.List;
import mqq.app.AppRuntime;
import vw1.d;

/* compiled from: P */
/* loaded from: classes14.dex */
public class RobotJoinGuildFragment extends QQGuildTitleBarFragment {
    private View T;
    private AppInterface U;
    private a V;
    private b W;
    private View X;
    private RobotLoadingView Y;
    private View Z;

    /* renamed from: a0, reason: collision with root package name */
    private HashMap<String, Object> f232155a0;

    private boolean Kh() {
        Intent intent;
        RobotInfo robotInfo;
        FragmentActivity activity = getActivity();
        if (activity == null || (intent = activity.getIntent()) == null || (robotInfo = (RobotInfo) intent.getParcelableExtra("robotInfo")) == null) {
            return false;
        }
        this.W = new b(this, this.U, robotInfo);
        return true;
    }

    private void Lh() {
        if (getActivity() == null) {
            return;
        }
        VideoReport.addToDetectionWhitelist(getActivity());
        VideoReport.setPageId(this.T, "pg_qqrobot_add_personal_secondary_page");
        VideoReport.setElementExposePolicy(this.T, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(this.T, ClickPolicy.REPORT_ALL);
        VideoReport.setElementEndExposePolicy(this.T, EndExposurePolicy.REPORT_ALL);
        Intent intent = getActivity().getIntent();
        if (intent == null) {
            return;
        }
        HashMap<String, Object> hashMap = (HashMap) intent.getSerializableExtra("DA_TONG_DATA");
        this.f232155a0 = hashMap;
        VideoReport.setPageParams(this.T, new PageParams(hashMap));
    }

    private boolean Mh() {
        QBaseActivity qBaseActivity = getQBaseActivity();
        if (qBaseActivity == null) {
            return false;
        }
        AppRuntime appRuntime = qBaseActivity.getAppRuntime();
        if (appRuntime instanceof AppInterface) {
            this.U = (AppInterface) appRuntime;
        }
        if (this.U == null) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Oh(a aVar, View view, int i3, j jVar) {
        Jh(i3, jVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ph(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        view.setEnabled(false);
        view.setAlpha(0.5f);
        initData();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Qh(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        e.a(getActivity(), this.W.e());
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Rh(int i3) {
        this.V.t0(true);
        this.W.i(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Sh, reason: merged with bridge method [inline-methods] */
    public void Nh(int i3, j jVar, int i16, String str) {
        boolean z16;
        int i17;
        int i18;
        QLog.i("RobotJoinGuildFragment", 1, "authorize and add, code: " + i16 + ", message: " + str);
        if (i16 == -2) {
            return;
        }
        if (i16 == 10012) {
            QQToast.makeText(getContext(), R.string.f154171e3, 1).show();
            return;
        }
        if (i16 == 10032) {
            QQToast.makeText(getActivity(), R.string.f153371bx, 1).show();
            return;
        }
        if (i16 == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            i17 = 2;
        } else {
            i17 = 1;
        }
        if (z16) {
            i18 = R.string.f154601f9;
        } else {
            i18 = R.string.f154591f8;
        }
        QQToast.makeText(this.U.getApplicationContext(), i17, i18, 0).show();
        if (z16) {
            jVar.h(1);
            this.V.notifyItemChanged(i3);
            Th(jVar);
        }
    }

    private void Th(j jVar) {
        String str;
        AppInterface appInterface = getAppInterface();
        EventData.Builder withParam = EventData.builder().withId("ev_sgrp_robot_add_success").withParam("robot_id", Long.valueOf(this.W.e().l())).withParam("to_uin", Long.valueOf(jVar.b())).withParam("add_type", 3).withParam("qq_robot_type", 2).withParam("robot_import_source", this.f232155a0.get("robot_import_source"));
        if (appInterface != null) {
            str = appInterface.getCurrentUin();
        } else {
            str = null;
        }
        VideoReport.reportEvent(withParam.withParam("uin", str).build());
    }

    public static void Uh(Context context, RobotInfo robotInfo, HashMap<String, Object> hashMap) {
        Intent intent = new Intent();
        intent.putExtra("robotInfo", robotInfo);
        intent.putExtra("DA_TONG_DATA", hashMap);
        QPublicFragmentActivity.b.b(context, intent, QPublicFragmentActivity.class, RobotJoinGuildFragment.class);
    }

    private void initData() {
        this.W.i(0);
    }

    private void initTitleBar() {
        setTitle(getString(R.string.f154021do));
    }

    private void initView() {
        Context context = getContext();
        RecyclerView recyclerView = (RecyclerView) this.T.findViewById(R.id.f7916491);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        RobotLoadingView robotLoadingView = (RobotLoadingView) this.T.findViewById(R.id.f7693430);
        this.Y = robotLoadingView;
        robotLoadingView.setLoadingBg(R.drawable.guild_loading_member_line);
        this.Y.setVisibility(0);
        a aVar = new a(this.U);
        this.V = aVar;
        aVar.s0(new a.d() { // from class: gx1.e
            @Override // com.tencent.mobileqq.guild.robot.components.join.a.d
            public final void a(int i3) {
                RobotJoinGuildFragment.this.Rh(i3);
            }
        });
        this.V.u0(new a.f() { // from class: gx1.f
            @Override // com.tencent.mobileqq.guild.robot.components.join.a.f
            public final void a(com.tencent.mobileqq.guild.robot.components.join.a aVar2, View view, int i3, j jVar) {
                RobotJoinGuildFragment.this.Oh(aVar2, view, i3, jVar);
            }
        });
        recyclerView.setAdapter(this.V);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Ih(List<j> list, int i3) {
        RobotLoadingView robotLoadingView = this.Y;
        if (robotLoadingView != null) {
            robotLoadingView.setVisibility(8);
        }
        this.V.t0(false);
        this.V.p0(list, i3);
        View view = this.X;
        if (view != null && view.getVisibility() != 8) {
            this.X.setVisibility(8);
        }
    }

    void Jh(final int i3, final j jVar) {
        GuildChannel i16 = jVar.i();
        RobotInfo e16 = this.W.e();
        if (QLog.isColorLevel()) {
            QLog.i("RobotJoinGuildFragment", 2, "authorize robot, guildChannel: " + i16 + ", robotInfo: " + e16);
        } else {
            QLog.i("RobotJoinGuildFragment", 1, "start authorize and add");
        }
        RobotAuthorizeAddFragment.Jh(getQBaseActivity(), this.U, i16, e16, null, new d() { // from class: gx1.i
            @Override // vw1.d
            public final void a(int i17, String str) {
                RobotJoinGuildFragment.this.Nh(i3, jVar, i17, str);
            }
        }, "\u6dfb\u52a0\u5230\u6211\u7684\u5176\u4ed6\u9891\u9053");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Vh(int i3, String str) {
        QLog.i("RobotJoinGuildFragment", 1, "fail to load guild, code: " + i3 + ", message: " + str);
        if (this.V.getNUM_BACKGOURND_ICON() == 0) {
            if (this.X == null) {
                View inflate = ((ViewStub) this.T.findViewById(R.id.w7j)).inflate();
                this.X = inflate;
                inflate.findViewById(R.id.wvu).setOnClickListener(new View.OnClickListener() { // from class: gx1.h
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        RobotJoinGuildFragment.this.Ph(view);
                    }
                });
            }
            RobotLoadingView robotLoadingView = this.Y;
            if (robotLoadingView != null) {
                robotLoadingView.setVisibility(8);
            }
            this.X.setVisibility(0);
            View findViewById = this.X.findViewById(R.id.wvu);
            findViewById.setEnabled(true);
            findViewById.setAlpha(1.0f);
            return;
        }
        QQToast.makeText(this.U.getApplicationContext(), 1, R.string.f153041b1, 0).show();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Wh() {
        if (this.V.getNUM_BACKGOURND_ICON() == 0) {
            if (this.Z == null) {
                this.Z = ((ViewStub) this.T.findViewById(R.id.wsf)).inflate();
            }
            TextView textView = (TextView) this.Z.findViewById(R.id.f84354m1);
            v.k("https://downv6.qq.com/innovate/guild/loading/guild_feed_error_icon.png", (ImageView) this.Z.findViewById(R.id.f165485w90), com.tencent.mobileqq.urldrawable.b.f306350a);
            VideoReport.setElementId(textView, "em_sgrp_qqrobot_share_other_btn");
            VideoReport.setElementExposePolicy(textView, ExposurePolicy.REPORT_ALL);
            VideoReport.setElementClickPolicy(textView, ClickPolicy.REPORT_ALL);
            VideoReport.setElementEndExposePolicy(textView, EndExposurePolicy.REPORT_ALL);
            textView.setOnClickListener(new View.OnClickListener() { // from class: gx1.g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    RobotJoinGuildFragment.this.Qh(view);
                }
            });
            RobotLoadingView robotLoadingView = this.Y;
            if (robotLoadingView != null) {
                robotLoadingView.setVisibility(8);
            }
            this.Z.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment, com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment
    public void doOnCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.doOnCreateView(layoutInflater, viewGroup, bundle);
        if (!QQTheme.isVasTheme()) {
            rh();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f5m;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.T = view;
        if (Mh() && Kh()) {
            initTitleBar();
            initView();
            initData();
            Lh();
            return;
        }
        QLog.e("RobotJoinGuildFragment", 1, "illegal arguments, robotInfo is invalid.");
        QQToastUtil.showQQToast(1, R.string.f154011dn);
        FragmentActivity activity = getActivity();
        if (activity != null && !activity.isFinishing()) {
            activity.finish();
        }
    }
}
