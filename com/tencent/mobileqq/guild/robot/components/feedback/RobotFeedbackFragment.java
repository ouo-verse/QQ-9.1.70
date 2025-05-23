package com.tencent.mobileqq.guild.robot.components.feedback;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.gson.Gson;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.guild.api.IQQGuildAvatarApi;
import com.tencent.mobileqq.guild.robot.components.feedback.RobotFeedbackFragment;
import com.tencent.mobileqq.guild.util.o;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.util.URLUtil;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import sx1.f;
import zu1.a;

/* compiled from: P */
/* loaded from: classes14.dex */
public class RobotFeedbackFragment extends QPublicBaseFragment {
    private ImageView C;
    private TextView D;
    private FrameLayout E;
    private FrameLayout F;
    private AppRuntime G;
    private Bundle H;

    private void initView(View view) {
        this.C = (ImageView) view.findViewById(R.id.f763641g);
        this.D = (TextView) view.findViewById(R.id.f775744q);
        this.E = (FrameLayout) view.findViewById(R.id.f767242f);
        this.F = (FrameLayout) view.findViewById(R.id.f764741r);
        th(this.C, "em_qqrobot_back");
        th(this.E, "em_qqrobot_feedback");
        th(this.F, "em_qqrobot_complain");
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.root);
        if (ImmersiveUtils.isSupporImmersive() == 1) {
            linearLayout.setFitsSystemWindows(true);
            linearLayout.setPadding(0, ImmersiveUtils.getStatusBarHeight(getContext()), 0, 0);
        }
    }

    private String sh(@NonNull String str) {
        return "clientInfo=" + a.c() + " " + a.d() + " " + a.e() + ContainerUtils.FIELD_DELIMITER + "imei=" + a.b() + "&customInfo=" + str;
    }

    private void th(View view, String str) {
        if (view == null) {
            return;
        }
        VideoReport.setElementId(view, str);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_ALL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void uh(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (getActivity() != null) {
            getActivity().finish();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void vh(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (!o.c("RobotFeedbackFragment")) {
            Bundle bundle = this.H;
            if (bundle == null) {
                QLog.e("RobotFeedbackFragment", 1, "\u83b7\u53d6bundle\u4e3anull");
            } else {
                String string = bundle.getString("ROBOT_SUPPORT_URL_KEY");
                String string2 = this.H.getString("ROBOT_IN_GUILD_ID");
                String selfTinyId = ((IGPSService) this.G.getRuntimeService(IGPSService.class, "")).getSelfTinyId();
                if (TextUtils.isEmpty(string)) {
                    QQToast.makeText(getContext(), R.string.f154151e1, 1).show();
                } else {
                    String guildUserNick = ((IGPSService) this.G.getRuntimeService(IGPSService.class, "")).getGuildUserNick(string2, selfTinyId);
                    String avatarUrl = ((IQQGuildAvatarApi) this.G.getRuntimeService(IQQGuildAvatarApi.class, "")).getAvatarUrl(this.G, string2, selfTinyId);
                    String addParameterWithoutEncode = URLUtil.addParameterWithoutEncode(URLUtil.addParameterWithoutEncode(string, "openid", selfTinyId), "nickname", guildUserNick);
                    try {
                        addParameterWithoutEncode = URLUtil.addParameterWithoutEncode(addParameterWithoutEncode, "avatar", URLEncoder.encode(avatarUrl, "utf-8"));
                    } catch (UnsupportedEncodingException e16) {
                        e16.printStackTrace();
                    }
                    f.c(this.G, addParameterWithoutEncode, sh(string2));
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void wh(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (!o.c("RobotFeedbackFragment")) {
            Bundle bundle = this.H;
            if (bundle == null) {
                QLog.e("RobotFeedbackFragment", 1, "\u83b7\u53d6bundle\u4e3anull");
            } else {
                String string = bundle.getString("ROBOT_FEEDBACK_URL_KEY");
                String string2 = this.H.getString("ROBOT_IN_GUILD_ID");
                String selfTinyId = ((IGPSService) this.G.getRuntimeService(IGPSService.class, "")).getSelfTinyId();
                String guildUserNick = ((IGPSService) this.G.getRuntimeService(IGPSService.class, "")).getGuildUserNick(string2, selfTinyId);
                String avatarUrl = ((IQQGuildAvatarApi) this.G.getRuntimeService(IQQGuildAvatarApi.class, "")).getAvatarUrl(this.G, string2, selfTinyId);
                String addParameterWithoutEncode = URLUtil.addParameterWithoutEncode(URLUtil.addParameterWithoutEncode(string, "openid", selfTinyId), "nickname", guildUserNick);
                try {
                    addParameterWithoutEncode = URLUtil.addParameterWithoutEncode(addParameterWithoutEncode, "avatar", URLEncoder.encode(avatarUrl, "utf-8"));
                } catch (UnsupportedEncodingException e16) {
                    e16.printStackTrace();
                }
                f.c(this.G, addParameterWithoutEncode, sh(selfTinyId));
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needStatusTrans() {
        return true;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.f5b, viewGroup, false);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        this.G = peekAppRuntime;
        if (peekAppRuntime == null && getActivity() != null) {
            getActivity().finish();
        }
        if (getActivity() != null && getActivity().getIntent() != null) {
            this.H = getActivity().getIntent().getBundleExtra("com.tencent.mobileqq.guild.robot.components.feedback.RobotFeedbackFragment");
        }
        if (this.H != null) {
            HashMap hashMap = (HashMap) new Gson().fromJson(this.H.getString("ROBOT_DA_TONG_PARAMS_KEY"), HashMap.class);
            VideoReport.addToDetectionWhitelist(getActivity());
            VideoReport.setPageId(inflate, "pg_qqrobot_feedback_complain_secondarypage");
            VideoReport.setElementExposePolicy(inflate, ExposurePolicy.REPORT_ALL);
            VideoReport.setElementEndExposePolicy(inflate, EndExposurePolicy.REPORT_ALL);
            VideoReport.setPageParams(inflate, new PageParams(hashMap));
        }
        initView(inflate);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.C.setOnClickListener(new View.OnClickListener() { // from class: ex1.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                RobotFeedbackFragment.this.uh(view2);
            }
        });
        this.E.setOnClickListener(new View.OnClickListener() { // from class: ex1.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                RobotFeedbackFragment.this.vh(view2);
            }
        });
        this.F.setOnClickListener(new View.OnClickListener() { // from class: ex1.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                RobotFeedbackFragment.this.wh(view2);
            }
        });
    }
}
