package com.tencent.mobileqq.guild.robot.components.setting;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import cf1.b;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.gson.Gson;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.guild.robot.api.IGuildRobotPageApi;
import com.tencent.mobileqq.guild.robot.components.auth.RobotPermissionFragment;
import com.tencent.mobileqq.guild.robot.components.console.RobotInfoActivity;
import com.tencent.mobileqq.guild.robot.components.feedback.RobotFeedbackFragment;
import com.tencent.mobileqq.guild.robot.components.join.RobotJoinGuildFragment;
import com.tencent.mobileqq.guild.robot.components.setting.RobotMoreSettingDialogFragment;
import com.tencent.mobileqq.guild.robot.components.share.e;
import com.tencent.mobileqq.guild.robot.display.more.MoreRobotInfoFragment;
import com.tencent.mobileqq.guild.util.o;
import com.tencent.mobileqq.guild.util.security.SecurityTipHelperKt;
import com.tencent.mobileqq.guild.widget.GuildSwitchButton;
import com.tencent.mobileqq.guild.widget.GuildUserAvatarView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqnt.kernel.nativeinterface.GProGuildRobotData;
import com.tencent.qqnt.kernel.nativeinterface.GProGuildRobotInfoRsp;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.immersive.ImmersiveUtils;
import cx1.a;
import ef1.c;
import kotlin.jvm.functions.Function0;
import ox1.d;
import ox1.i;

/* compiled from: P */
/* loaded from: classes14.dex */
public class RobotMoreSettingDialogFragment extends BottomSheetDialogFragment implements View.OnClickListener {
    private a C;
    private View D;
    private LinearLayout E;
    private View F;
    private GuildSwitchButton G;
    private i H;
    private d I;
    private GProGuildRobotInfoRsp J;

    public RobotMoreSettingDialogFragment(d dVar, a aVar, i iVar) {
        this.I = dVar;
        this.C = aVar;
        this.H = iVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ah(Long l3) {
        String format = String.format(getString(R.string.f153731cw), l3);
        View view = this.F;
        if (view != null) {
            TextView textView = (TextView) view.findViewById(R.id.f74663wv);
            textView.setVisibility(0);
            textView.setText(format);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Bh(b bVar) {
        SecurityTipHelperKt.D(getContext(), bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ch(ActionSheet actionSheet, View view, int i3) {
        if (o.c("RobotMoreSettingDialog")) {
            return;
        }
        if (!NetworkUtil.isNetworkAvailable()) {
            QQToast.makeText(getContext(), R.string.f146090t9, 1).show();
            return;
        }
        this.H.U1().setValue(Boolean.TRUE);
        this.H.d2();
        actionSheet.dismiss();
        VideoReport.setElementId(view, "em_qqrobot_confirm_btn");
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_ALL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Dh(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (!o.c("RobotMoreSettingDialog")) {
            VideoReport.setElementId(view, "em_qqrobot_cancel_btn");
            VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
            VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
            VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_ALL);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private void Eh() {
        GProGuildRobotData gProGuildRobotData;
        if (this.I.o()) {
            QQToast.makeText(BaseApplication.getContext(), 0, this.I.e(), 0).show();
            return;
        }
        GProGuildRobotInfoRsp gProGuildRobotInfoRsp = this.J;
        if (gProGuildRobotInfoRsp != null) {
            gProGuildRobotData = gProGuildRobotInfoRsp.getRobotData();
        } else {
            gProGuildRobotData = null;
        }
        if (gProGuildRobotData != null && gProGuildRobotData.getPublicType() == 1) {
            QQToast.makeText(BaseApplication.getContext(), 0, R.string.f154171e3, 0).show();
        } else {
            RobotJoinGuildFragment.Uh(getActivity(), this.I.f(), this.I.b());
            dismiss();
        }
    }

    private void Fh() {
        if (this.I.o()) {
            QQToast.makeText(BaseApplication.getContext(), 0, this.I.e(), 0).show();
        } else if (!this.I.l()) {
            QQToast.makeText(BaseApplication.getContext(), 0, R.string.f154171e3, 0).show();
        } else {
            e.a(getActivity(), this.I.f());
            dismiss();
        }
    }

    private void Gh() {
        if (Boolean.TRUE.equals(this.H.U1().getValue())) {
            this.H.U1().setValue(Boolean.FALSE);
            this.H.d2();
        } else {
            Jh();
        }
    }

    public static void Hh(cx1.e eVar, boolean z16, int i3, GProGuildRobotInfoRsp gProGuildRobotInfoRsp, a aVar) {
        if (!(eVar.b() instanceof FragmentActivity)) {
            return;
        }
        try {
            new RobotMoreSettingDialogFragment(new d(eVar, z16, i3, gProGuildRobotInfoRsp), aVar, null).show(eVar.e(), "RobotMoreSettingDialog");
        } catch (IllegalStateException e16) {
            QLog.e("RobotMoreSettingDialog", 1, "show exception = " + e16);
        }
    }

    public static void Ih(cx1.e eVar, boolean z16, int i3, GProGuildRobotInfoRsp gProGuildRobotInfoRsp, a aVar, i iVar) {
        if (!(eVar.b() instanceof FragmentActivity)) {
            return;
        }
        try {
            new RobotMoreSettingDialogFragment(new d(eVar, z16, i3, gProGuildRobotInfoRsp), aVar, iVar).show(eVar.e(), "RobotMoreSettingDialog");
        } catch (IllegalStateException e16) {
            QLog.e("RobotMoreSettingDialog", 1, "show exception = " + e16);
        }
    }

    private void Kh() {
        DirectMsgLimitDialogFragment.Jh(requireActivity(), this.C, this.H, this.I.c(), this.I.i(), this.I.g(), 1);
        dismiss();
    }

    private void Lh() {
        GProGuildRobotInfoRsp gProGuildRobotInfoRsp;
        if (getActivity() != null && (gProGuildRobotInfoRsp = this.J) != null && gProGuildRobotInfoRsp.getRobotData() != null) {
            Bundle bundle = new Bundle();
            Gson gson = new Gson();
            bundle.putString("ROBOT_SUPPORT_URL_KEY", this.J.getRobotData().getSupportUrl());
            bundle.putString("ROBOT_FEEDBACK_URL_KEY", this.J.getPlatformSupportUrl());
            bundle.putString("ROBOT_IN_GUILD_ID", this.I.c());
            bundle.putString("ROBOT_DA_TONG_PARAMS_KEY", gson.toJson(this.I.b()));
            Intent intent = new Intent();
            intent.putExtra("com.tencent.mobileqq.guild.robot.components.feedback.RobotFeedbackFragment", bundle);
            QPublicFragmentActivity.start(getActivity(), intent, RobotFeedbackFragment.class);
            dismiss();
            return;
        }
        QLog.e("RobotMoreSettingDialog", 1, "mActivity == " + getActivity() + " mRobotData == " + this.J);
    }

    private void Mh() {
        Bundle bundle = new Bundle();
        bundle.putString("channelId", this.I.a());
        bundle.putString("guildId", this.I.c());
        bundle.putParcelable("MORE_ROBOT_INFO_KEY", this.I.f());
        bundle.putSerializable("MORE_ROBOT_DA_TONG_DATA", this.I.b());
        Intent intent = new Intent();
        intent.putExtra("com.tencent.mobileqq.guild.robot.other.MoreRobotInfoFragment", bundle);
        QPublicFragmentActivity.start(getActivity(), intent, MoreRobotInfoFragment.class);
        dismiss();
    }

    private void Nh() {
        if (getActivity() == null) {
            QLog.e("RobotMoreSettingDialog", 1, "mActivity = NULL ");
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("guildId", this.I.c());
        bundle.putString("channelId", this.I.a());
        bundle.putString("ROBOT_UIN_KEY", this.I.i());
        bundle.putString("ROBOT_TID_KEY", this.I.h());
        bundle.putSerializable("ROBOT_PERMISSION_DA_TONG", this.I.b());
        Intent intent = new Intent();
        intent.putExtra("ROBOT_PERMISSION_SETTING_FLAG", bundle);
        QPublicFragmentActivity.start(getActivity(), intent, RobotPermissionFragment.class);
        dismiss();
    }

    private void initUI() {
        View view = this.D;
        if (view == null) {
            return;
        }
        this.E = (LinearLayout) view.findViewById(R.id.b_7);
        d dVar = this.I;
        if (dVar == null) {
            return;
        }
        this.J = dVar.d();
        this.E.addView(xh());
        if (this.I.k()) {
            if (this.I.m() && this.I.j()) {
                View vh5 = vh(R.string.f153331bt, R.id.wwb);
                this.E.addView(vh5);
                rx1.a.a(vh5, "em_qqrobot_add_others");
            }
            if (!this.I.n() && this.I.j()) {
                View vh6 = vh(R.string.f153361bw, R.id.wwe);
                this.E.addView(vh6);
                rx1.a.a(vh6, "em_qqrobot_add_authoritay");
            }
        }
        View vh7 = vh(R.string.f153841d7, R.id.wwa);
        this.E.addView(vh7);
        rx1.a.a(vh7, "em_qqrobot_feedback_complain");
        View wh5 = wh(R.string.f154271ec, R.id.f165609wx4);
        this.E.addView(wh5);
        if (wh5 != null) {
            this.G = (GuildSwitchButton) wh5.findViewById(R.id.w4j);
        }
        View vh8 = vh(R.string.f153721cv, R.id.wws);
        this.F = vh8;
        this.E.addView(vh8);
        View vh9 = vh(R.string.f153341bu, R.id.wwc);
        this.E.addView(vh9);
        this.E.addView(vh(R.string.f153351bv, R.id.wwd));
        rx1.a.b(getActivity(), this.D, "pg_qqrobot_card", this.I.b());
        rx1.a.a(vh9, "em_qqrobot_more_info");
        for (int i3 = 0; i3 < this.E.getChildCount(); i3++) {
            this.E.getChildAt(i3).setOnClickListener(this);
        }
    }

    private void initViewModel() {
        if (this.H == null) {
            this.H = (i) c.a(this, i.class, new Function0() { // from class: ox1.r
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    i yh5;
                    yh5 = RobotMoreSettingDialogFragment.this.yh();
                    return yh5;
                }
            });
        }
        this.H.U1().observe(getViewLifecycleOwner(), new Observer() { // from class: ox1.s
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RobotMoreSettingDialogFragment.this.zh((Boolean) obj);
            }
        });
        this.H.T1().observe(getViewLifecycleOwner(), new Observer() { // from class: ox1.t
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RobotMoreSettingDialogFragment.this.Ah((Long) obj);
            }
        });
        this.H.W1().observe(getViewLifecycleOwner(), new Observer() { // from class: ox1.u
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RobotMoreSettingDialogFragment.this.Bh((cf1.b) obj);
            }
        });
    }

    private View vh(@StringRes int i3, int i16) {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.f5w, (ViewGroup) null);
        if (inflate == null) {
            return null;
        }
        inflate.setId(i16);
        ((TextView) inflate.findViewById(R.id.f768542s)).setText(i3);
        return inflate;
    }

    private View wh(@StringRes int i3, int i16) {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.f5x, (ViewGroup) null);
        if (inflate == null) {
            return null;
        }
        inflate.setId(i16);
        ((TextView) inflate.findViewById(R.id.f768642t)).setText(i3);
        GuildSwitchButton guildSwitchButton = (GuildSwitchButton) inflate.findViewById(R.id.w4j);
        guildSwitchButton.setOnClickListener(null);
        guildSwitchButton.setClickable(false);
        return inflate;
    }

    private View xh() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.f5v, (ViewGroup) null);
        if (inflate == null) {
            return null;
        }
        ((GuildUserAvatarView) inflate.findViewById(R.id.f763141b)).setAvatarTinyId(this.I.c(), this.I.h());
        ((TextView) inflate.findViewById(R.id.f771043g)).setText(this.I.g());
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ i yh() {
        return new i(this.I.h());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void zh(Boolean bool) {
        int i3;
        GuildSwitchButton guildSwitchButton = this.G;
        if (guildSwitchButton != null) {
            guildSwitchButton.setCheckedOnly(bool.booleanValue());
        }
        if (this.F != null) {
            if (bool.booleanValue()) {
                i3 = 8;
            } else {
                i3 = 0;
            }
            this.F.setVisibility(i3);
        }
    }

    public void Jh() {
        final ActionSheet createMenuSheet = ActionSheet.createMenuSheet(getContext());
        createMenuSheet.setRoundCornerTop(true);
        createMenuSheet.setMainTitle(R.string.f154211e7);
        createMenuSheet.addButton(R.string.f143520ma, 3, R.id.wwu);
        createMenuSheet.getWindow().clearFlags(2);
        createMenuSheet.addCancelButton(R.string.cancel);
        createMenuSheet.preInitView();
        rx1.a.b(getActivity(), createMenuSheet.getRootView(), "pg_qqrobot_block_private_double_check", this.I.b());
        createMenuSheet.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: ox1.p
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public final void onClick(View view, int i3) {
                RobotMoreSettingDialogFragment.this.Ch(createMenuSheet, view, i3);
            }
        });
        createMenuSheet.setOnBottomCancelListener(new View.OnClickListener() { // from class: ox1.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RobotMoreSettingDialogFragment.Dh(view);
            }
        });
        createMenuSheet.show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (!o.a(view)) {
            int id5 = view.getId();
            if (id5 == R.id.wwb) {
                Eh();
            } else if (id5 == R.id.wwe) {
                Nh();
            } else if (id5 == R.id.wwc) {
                Mh();
            } else if (id5 == R.id.wwd) {
                ((IGuildRobotPageApi) QRoute.api(IGuildRobotPageApi.class)).openRobotFaqPage(getContext(), this.I.c());
                dismiss();
            } else if (id5 == R.id.wwf) {
                this.C.g();
                dismiss();
            } else if (id5 == R.id.wwg) {
                Fh();
            } else if (id5 == R.id.wwa) {
                Lh();
            } else if (id5 == R.id.f165609wx4) {
                Gh();
            } else if (id5 == R.id.wws) {
                Kh();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.f5u, viewGroup, false);
        this.D = inflate;
        if (inflate == null) {
            dismiss();
        } else {
            initUI();
            initViewModel();
        }
        View view = this.D;
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(@NonNull DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        if ((getActivity() instanceof RobotInfoActivity) && ((RobotInfoActivity) getActivity()).F2()) {
            getActivity().finish();
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        View view = this.D;
        if (view == null) {
            return;
        }
        ((ViewGroup) view.getParent()).setBackgroundColor(0);
        com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) getDialog();
        if (aVar == null) {
            return;
        }
        int instantScreenHeight = ScreenUtil.getInstantScreenHeight(getActivity());
        aVar.getBehavior().setPeekHeight((int) (instantScreenHeight * 0.6f));
        Window window = aVar.getWindow();
        if (window == null) {
            return;
        }
        window.setLayout(-1, instantScreenHeight - ImmersiveUtils.getStatusBarHeight(getActivity()));
        window.setGravity(80);
    }

    public RobotMoreSettingDialogFragment() {
    }
}
