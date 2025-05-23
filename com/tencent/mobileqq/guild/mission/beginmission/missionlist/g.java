package com.tencent.mobileqq.guild.mission.beginmission.missionlist;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.guild.mission.beginmission.presentdialog.MissionPresentDialogFragment;
import com.tencent.mobileqq.guild.theme.GuildThemeManager;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import uu1.Mission;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u00a2\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0007R\u0017\u0010\u0010\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001a\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0013\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/guild/mission/beginmission/missionlist/g;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "missionId", "", "p", "Luu1/a;", "mission", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "o", "Lcom/tencent/mobileqq/guild/mission/beginmission/missionlist/e;", "E", "Lcom/tencent/mobileqq/guild/mission/beginmission/missionlist/e;", "getListener", "()Lcom/tencent/mobileqq/guild/mission/beginmission/missionlist/e;", "listener", "Landroid/widget/ImageView;", UserInfo.SEX_FEMALE, "Landroid/widget/ImageView;", "missionIcon", "Landroid/widget/TextView;", "G", "Landroid/widget/TextView;", "missionName", "H", "missionDesc", "I", "missionStatus", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;Lcom/tencent/mobileqq/guild/mission/beginmission/missionlist/e;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class g extends RecyclerView.ViewHolder {

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final e listener;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final ImageView missionIcon;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final TextView missionName;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final TextView missionDesc;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final ImageView missionStatus;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(@NotNull View itemView, @NotNull e listener) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listener = listener;
        View findViewById = itemView.findViewById(R.id.zbu);
        Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.mission_icon)");
        this.missionIcon = (ImageView) findViewById;
        View findViewById2 = itemView.findViewById(R.id.zbx);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.mission_name)");
        this.missionName = (TextView) findViewById2;
        View findViewById3 = itemView.findViewById(R.id.zbt);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.id.mission_desc)");
        this.missionDesc = (TextView) findViewById3;
        View findViewById4 = itemView.findViewById(R.id.zby);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "itemView.findViewById(R.id.mission_status)");
        this.missionStatus = (ImageView) findViewById4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(Mission mission, g this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(mission, "$mission");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        switch (mission.getMissionId()) {
            case 1:
                MissionPresentDialogFragment.Companion companion = MissionPresentDialogFragment.INSTANCE;
                QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
                Intrinsics.checkNotNull(qBaseActivity, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
                FragmentManager supportFragmentManager = qBaseActivity.getSupportFragmentManager();
                Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "QBaseActivity.sTopActivi\u2026y).supportFragmentManager");
                companion.a(supportFragmentManager, mission.getGuildId(), 1);
                break;
            case 2:
                MissionPresentDialogFragment.Companion companion2 = MissionPresentDialogFragment.INSTANCE;
                QBaseActivity qBaseActivity2 = QBaseActivity.sTopActivity;
                Intrinsics.checkNotNull(qBaseActivity2, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
                FragmentManager supportFragmentManager2 = qBaseActivity2.getSupportFragmentManager();
                Intrinsics.checkNotNullExpressionValue(supportFragmentManager2, "QBaseActivity.sTopActivi\u2026y).supportFragmentManager");
                companion2.a(supportFragmentManager2, mission.getGuildId(), 2);
                break;
            case 3:
                tu1.a aVar = tu1.a.f437478a;
                QBaseActivity qBaseActivity3 = QBaseActivity.sTopActivity;
                Intrinsics.checkNotNull(qBaseActivity3, "null cannot be cast to non-null type android.app.Activity");
                aVar.b(qBaseActivity3, mission.getGuildId());
                break;
            case 4:
                if (mission.getIsFinish()) {
                    IQQGuildRouterApi iQQGuildRouterApi = (IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class);
                    QBaseActivity qBaseActivity4 = QBaseActivity.sTopActivity;
                    Intrinsics.checkNotNull(qBaseActivity4, "null cannot be cast to non-null type android.app.Activity");
                    iQQGuildRouterApi.openGuildInfoSetting(qBaseActivity4, uu1.e.j(mission.getGuildId()), 0, 2);
                    break;
                } else {
                    wu1.a.f446537c.a(mission.getGuildId(), new String[]{"enter_setting", "click_management"});
                    break;
                }
            case 5:
                QBaseActivity qBaseActivity5 = QBaseActivity.sTopActivity;
                Intrinsics.checkNotNull(qBaseActivity5, "null cannot be cast to non-null type com.tencent.mobileqq.app.QBaseActivity");
                tu1.a.c(qBaseActivity5, mission.getGuildId());
                break;
            case 6:
                break;
            default:
                throw new IllegalArgumentException("Illegal missionId");
        }
        this$0.listener.onItemClick();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final String p(int missionId) {
        switch (missionId) {
            case 1:
                return "em_sgrp_master_guide_subchannel";
            case 2:
                return "em_sgrp_master_guide_robot";
            case 3:
                return "em_sgrp_master_guide_share";
            case 4:
                return "em_sgrp_master_guide_manage";
            case 5:
                return "em_sgrp_master_guide_message";
            case 6:
                return "em_sgrp_master_guide_welcome";
            default:
                throw new IllegalArgumentException("Illegal missionId");
        }
    }

    public final void m(@NotNull final Mission mission) {
        Intrinsics.checkNotNullParameter(mission, "mission");
        View view = this.itemView;
        String p16 = p(mission.getMissionId());
        ExposurePolicy exposurePolicy = ExposurePolicy.REPORT_ALL;
        ClickPolicy clickPolicy = ClickPolicy.REPORT_ALL;
        VideoReport.setElementId(view, p16);
        VideoReport.setElementExposePolicy(view, exposurePolicy);
        VideoReport.setElementClickPolicy(view, clickPolicy);
        this.missionIcon.setImageResource(o(mission.getMissionId()));
        this.missionName.setText(mission.getMissionName());
        this.missionDesc.setText(mission.getMissionDes());
        if (mission.getIsFinish()) {
            this.missionStatus.getLayoutParams().width = ViewUtils.dpToPx(24.0f);
            this.missionStatus.getLayoutParams().height = ViewUtils.dpToPx(24.0f);
            ViewGroup.LayoutParams layoutParams = this.missionStatus.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            ((LinearLayout.LayoutParams) layoutParams).setMargins(0, 0, ViewUtils.dpToPx(10.0f), 0);
            this.missionStatus.setImageResource(R.drawable.guild_mission_finished_icon);
        } else {
            this.missionStatus.getLayoutParams().width = ViewUtils.dpToPx(16.0f);
            this.missionStatus.getLayoutParams().height = ViewUtils.dpToPx(16.0f);
            ViewGroup.LayoutParams layoutParams2 = this.missionStatus.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            ((LinearLayout.LayoutParams) layoutParams2).setMargins(0, 0, ViewUtils.dpToPx(12.0f), 0);
            this.missionStatus.setImageResource(R.drawable.guild_me_right_arrow);
        }
        this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.mission.beginmission.missionlist.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                g.n(Mission.this, this, view2);
            }
        });
    }

    @DrawableRes
    public final int o(int missionId) {
        switch (missionId) {
            case 1:
                if (GuildThemeManager.f235286a.b()) {
                    return R.drawable.guild_begin_mission_list_create_sub_channel_icon_night;
                }
                return R.drawable.guild_begin_mission_list_create_sub_channel_icon;
            case 2:
                if (GuildThemeManager.f235286a.b()) {
                    return R.drawable.guild_begin_mission_list_robot_icon_night;
                }
                return R.drawable.guild_begin_mission_list_robot_icon;
            case 3:
                if (GuildThemeManager.f235286a.b()) {
                    return R.drawable.guild_begin_mission_list_invite_icon_night;
                }
                return R.drawable.guild_begin_mission_list_invite_icon;
            case 4:
                if (GuildThemeManager.f235286a.b()) {
                    return R.drawable.guild_begin_mission_list_manage_icon_night;
                }
                return R.drawable.guild_begin_mission_list_manage_icon;
            case 5:
                if (GuildThemeManager.f235286a.b()) {
                    return R.drawable.guild_begin_mission_list_message_icon_night;
                }
                return R.drawable.guild_begin_mission_list_message_icon;
            case 6:
                if (GuildThemeManager.f235286a.b()) {
                    return R.drawable.guild_begin_mission_list_welcome_icon_night;
                }
                return R.drawable.guild_begin_mission_list_welcome_icon;
            default:
                throw new IllegalArgumentException("Illegal missionId");
        }
    }
}
