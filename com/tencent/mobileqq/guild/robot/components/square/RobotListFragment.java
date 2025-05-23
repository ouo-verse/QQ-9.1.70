package com.tencent.mobileqq.guild.robot.components.square;

import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment;
import com.tencent.mobileqq.guild.data.w;
import com.tencent.mobileqq.guild.robot.api.model.GuildChannel;
import com.tencent.mobileqq.guild.robot.components.console.RobotInfoFragment;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.bv;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes14.dex */
public class RobotListFragment extends QQGuildTitleBarFragment {
    private String T;
    private String U;
    private String V;
    private GuildChannel W;
    private b X;
    private a Y;

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public interface a {
        void onConfigurationChanged(@NonNull Configuration configuration);

        void onResume();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Fh(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        getActivity().finish();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Gh(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        ((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).openRobotExplorationDialog(getActivity(), this.T);
        EventCollector.getInstance().onViewClicked(view);
    }

    private void Hh(String str) {
        RobotInfoFragment.xh(getActivity(), this.U, this.T, "", str, "2", false, null, 0);
    }

    private void init(View view) {
        Bundle arguments = getArguments();
        if (arguments == null) {
            return;
        }
        QLog.i("RobotListFragment", 1, "init");
        this.T = arguments.getString("guildId");
        this.U = arguments.getString("channelId");
        this.V = arguments.getString("openRobotProfileCardRobotUin");
        GuildChannel guildChannel = new GuildChannel();
        this.W = guildChannel;
        guildChannel.e(bv.b(this.T, 0L));
        this.W.c(bv.b(this.U, 0L));
        this.C.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.robot.components.square.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                RobotListFragment.this.Fh(view2);
            }
        });
        this.E.setText(R.string.f154131dz);
        this.E.setVisibility(0);
        this.E.setTextColor(getResources().getColorStateList(R.color.bth));
        this.X = new b(this, (ViewGroup) view.findViewById(R.id.root), this.W, arguments.getStringArrayList("robot_uins"));
        this.G.setImageDrawable(getResources().getDrawable(R.drawable.guild_robot_explore_btn));
        this.G.setVisibility(0);
        this.G.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.robot.components.square.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                RobotListFragment.this.Gh(view2);
            }
        });
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.G.getLayoutParams();
        layoutParams.setMargins(layoutParams.leftMargin, layoutParams.topMargin, QQGuildUIUtil.f(12.0f), layoutParams.bottomMargin);
        this.G.setLayoutParams(layoutParams);
        Ih(this.X);
        if (getActivity() != null && getActivity().getWindow() != null) {
            if (QQTheme.isNowThemeIsNight()) {
                getActivity().getWindow().getDecorView().setSystemUiVisibility(1024);
            } else {
                getActivity().getWindow().getDecorView().setSystemUiVisibility(9216);
            }
            VideoReport.addToDetectionWhitelist((QBaseActivity) getActivity());
            VideoReport.setPageId(view, "pg_qqrobot_channel_robotlist");
            ExposurePolicy exposurePolicy = ExposurePolicy.REPORT_ALL;
            VideoReport.setElementExposePolicy(view, exposurePolicy);
            ClickPolicy clickPolicy = ClickPolicy.REPORT_ALL;
            VideoReport.setElementClickPolicy(view, clickPolicy);
            EndExposurePolicy endExposurePolicy = EndExposurePolicy.REPORT_ALL;
            VideoReport.setElementEndExposePolicy(view, endExposurePolicy);
            HashMap hashMap = new HashMap();
            hashMap.put("qq_robot_channel_name", ((IGPSService) ch.R0(IGPSService.class)).getGuildName(this.T));
            hashMap.put("qq_robot_channel_id", this.T);
            hashMap.put("qq_robot_role_type", "0");
            w.a(hashMap);
            VideoReport.setPageParams(view, new PageParams(hashMap));
            VideoReport.setElementId(this.C, "em_qqrobot_robotlist_return");
            VideoReport.setElementExposePolicy(this.C, exposurePolicy);
            VideoReport.setElementClickPolicy(this.C, clickPolicy);
            VideoReport.setElementEndExposePolicy(this.C, endExposurePolicy);
        }
    }

    public void Ih(a aVar) {
        this.Y = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment, com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment
    public void doOnCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.doOnCreateView(layoutInflater, viewGroup, bundle);
        init(this.P);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.efh;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NonNull Configuration configuration) {
        super.onConfigurationChanged(configuration);
        a aVar = this.Y;
        if (aVar != null) {
            aVar.onConfigurationChanged(configuration);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.X.j();
        this.X = null;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        a aVar = this.Y;
        if (aVar != null) {
            aVar.onResume();
        }
        if (!TextUtils.isEmpty(this.V)) {
            Hh(this.V);
            this.V = "";
        }
    }
}
