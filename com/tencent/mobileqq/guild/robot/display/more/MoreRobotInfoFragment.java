package com.tencent.mobileqq.guild.robot.display.more;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.guild.robot.api.model.GuildChannel;
import com.tencent.mobileqq.guild.robot.components.console.RobotInfo;
import com.tencent.mobileqq.guild.robot.display.more.MoreRobotInfoFragment;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.bv;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqnt.kernel.api.ac;
import com.tencent.qqnt.kernel.nativeinterface.GProGuildRobotInfoRsp;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.HashMap;
import px1.a;
import px1.c;
import sx1.f;

/* compiled from: P */
/* loaded from: classes14.dex */
public class MoreRobotInfoFragment extends QPublicBaseFragment {
    private ImageView C;
    private TextView D;
    private RecyclerView E;
    private GuildChannel F;
    private RobotInfo G;
    private c H;
    private Bundle I;

    private void init(View view) {
        this.C = (ImageView) view.findViewById(R.id.f763641g);
        this.D = (TextView) view.findViewById(R.id.f775744q);
        this.E = (RecyclerView) view.findViewById(R.id.f770743d);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.root);
        if (ImmersiveUtils.isSupporImmersive() == 1) {
            linearLayout.setFitsSystemWindows(true);
            linearLayout.setPadding(0, ImmersiveUtils.getStatusBarHeight(getContext()), 0, 0);
        }
        this.C.setOnClickListener(new View.OnClickListener() { // from class: px1.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                MoreRobotInfoFragment.this.rh(view2);
            }
        });
        if (getActivity() != null && getActivity().getIntent() != null) {
            this.I = getActivity().getIntent().getBundleExtra("com.tencent.mobileqq.guild.robot.other.MoreRobotInfoFragment");
        }
        if (this.I == null) {
            return;
        }
        if (QQTheme.isNowThemeIsNight()) {
            getActivity().getWindow().getDecorView().setSystemUiVisibility(1024);
        } else {
            getActivity().getWindow().getDecorView().setSystemUiVisibility(9216);
        }
        String string = this.I.getString("guildId");
        String string2 = this.I.getString("channelId");
        GuildChannel guildChannel = new GuildChannel();
        this.F = guildChannel;
        guildChannel.e(bv.b(string, 0L));
        this.F.c(bv.b(string2, 0L));
        this.G = (RobotInfo) this.I.getParcelable("MORE_ROBOT_INFO_KEY");
        this.H = new c(this);
        ac g16 = f.g();
        if (g16 == null) {
            return;
        }
        g16.fetchGuildRobotInfo(f.b(this.F, this.G, 1), this.H);
    }

    private void qh(View view) {
        if (this.I == null) {
            return;
        }
        VideoReport.addToDetectionWhitelist(getActivity());
        VideoReport.setPageId(view, "pg_qqrobot_card_more");
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_ALL);
        VideoReport.setPageParams(view, new PageParams((HashMap) this.I.getSerializable("MORE_ROBOT_DA_TONG_DATA")));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void rh(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        getActivity().finish();
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return false;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.f5s, (ViewGroup) null);
        init(inflate);
        qh(inflate);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    public void sh(GProGuildRobotInfoRsp gProGuildRobotInfoRsp) {
        this.E.setLayoutManager(new LinearLayoutManager(getContext()));
        this.E.setAdapter(new a(getContext(), gProGuildRobotInfoRsp));
    }
}
