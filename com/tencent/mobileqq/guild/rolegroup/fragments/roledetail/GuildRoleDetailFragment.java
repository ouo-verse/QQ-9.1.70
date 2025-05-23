package com.tencent.mobileqq.guild.rolegroup.fragments.roledetail;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.api.RoleGroupUserUIData;
import com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment;
import com.tencent.mobileqq.guild.base.view.colorpick.ColorPickDialogFragment;
import com.tencent.mobileqq.guild.profile.profilecard.guildowneroperation.GuildOwnerOperationTipCard;
import com.tencent.mobileqq.guild.rolegroup.adapters.previewavatar.a;
import com.tencent.mobileqq.guild.rolegroup.fragments.ChannelPermissionEditFragment;
import com.tencent.mobileqq.guild.rolegroup.fragments.ChannelPermissionForRoleDialog;
import com.tencent.mobileqq.guild.rolegroup.fragments.ChannelPermissionTypeForRole;
import com.tencent.mobileqq.guild.rolegroup.fragments.Source;
import com.tencent.mobileqq.guild.rolegroup.fragments.roledetail.d;
import com.tencent.mobileqq.guild.rolegroup.model.ModifyRolePermissionType;
import com.tencent.mobileqq.guild.rolegroup.model.data.ChannelPermission;
import com.tencent.mobileqq.guild.rolegroup.model.data.RoleGroupModel;
import com.tencent.mobileqq.guild.rolegroup.view.GuildRoleGroupChannelPermissionView;
import com.tencent.mobileqq.guild.rolegroup.view.previewavatar.GuildRoleMemberPreviewView;
import com.tencent.mobileqq.guild.rolegroup.viewmodel.RoleGroupViewModel;
import com.tencent.mobileqq.guild.util.GuildDebugUtils;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.cb;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.widget.CharacterCountEditText;
import com.tencent.mobileqq.guild.widget.GuildLevelRoleView;
import com.tencent.mobileqq.guild.widget.GuildSwitchButton;
import com.tencent.mobileqq.guild.widget.RadiusFrameLayout;
import com.tencent.mobileqq.guild.widget.TextAndSwitchButtonBar;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.util.HashMap;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import ux1.g;

/* compiled from: P */
/* loaded from: classes14.dex */
public class GuildRoleDetailFragment extends QQGuildTitleBarFragment implements View.OnClickListener {
    private LinearLayout T;
    private CharacterCountEditText U;
    private RelativeLayout V;
    private TextView W;
    private RelativeLayout X;
    private RadiusFrameLayout Y;
    private TextView Z;

    /* renamed from: a0, reason: collision with root package name */
    private ImageView f232543a0;

    /* renamed from: b0, reason: collision with root package name */
    private TextView f232544b0;

    /* renamed from: c0, reason: collision with root package name */
    private View f232545c0;

    /* renamed from: d0, reason: collision with root package name */
    private TextAndSwitchButtonBar f232546d0;

    /* renamed from: e0, reason: collision with root package name */
    private TextView f232547e0;

    /* renamed from: f0, reason: collision with root package name */
    private TextView f232548f0;

    /* renamed from: g0, reason: collision with root package name */
    private TextView f232549g0;

    /* renamed from: h0, reason: collision with root package name */
    private GuildRoleMemberPreviewView f232550h0;

    /* renamed from: i0, reason: collision with root package name */
    private GuildRoleGroupChannelPermissionView f232551i0;

    /* renamed from: j0, reason: collision with root package name */
    private GuildRoleGroupChannelPermissionView f232552j0;

    /* renamed from: k0, reason: collision with root package name */
    private RelativeLayout f232553k0;

    /* renamed from: l0, reason: collision with root package name */
    public GuildLevelRoleView f232554l0;

    /* renamed from: m0, reason: collision with root package name */
    private String f232555m0;

    /* renamed from: n0, reason: collision with root package name */
    private String f232556n0;

    /* renamed from: o0, reason: collision with root package name */
    private int f232557o0;

    /* renamed from: p0, reason: collision with root package name */
    private int f232558p0;

    /* renamed from: q0, reason: collision with root package name */
    private GuildOwnerOperationTipCard f232559q0;

    /* renamed from: r0, reason: collision with root package name */
    private ChannelPermissionForRoleDialog f232560r0;

    /* renamed from: s0, reason: collision with root package name */
    private QQProgressDialog f232561s0;

    /* renamed from: t0, reason: collision with root package name */
    private RoleGroupViewModel f232562t0;

    /* renamed from: u0, reason: collision with root package name */
    private RecyclerView f232563u0;

    /* renamed from: v0, reason: collision with root package name */
    private ux1.g f232564v0;

    /* renamed from: w0, reason: collision with root package name */
    private final g.a f232565w0 = Yh();

    /* renamed from: x0, reason: collision with root package name */
    private int f232566x0 = 0;

    /* renamed from: y0, reason: collision with root package name */
    private int f232567y0 = 0;

    private void Ai() {
        Source source;
        boolean z16;
        if (this.f232557o0 == 0) {
            source = Source.CreatePage;
        } else {
            source = Source.RoleGroup;
        }
        if (!GuildDebugUtils.f(this.f232555m0)) {
            ChannelPermissionForRoleDialog channelPermissionForRoleDialog = new ChannelPermissionForRoleDialog(ChannelPermissionTypeForRole.ApproveSpeak, this.f232555m0, this.f232556n0, source);
            this.f232560r0 = channelPermissionForRoleDialog;
            com.tencent.mobileqq.guild.base.extension.d.a(channelPermissionForRoleDialog, getChildFragmentManager(), "Guild.rg.ChannelPermissionForRoleDialog");
            return;
        }
        String name = this.f232562t0.g2().getName();
        Context requireContext = requireContext();
        ChannelPermissionEditFragment.Companion.OpenParam.C7881a d16 = new ChannelPermissionEditFragment.Companion.OpenParam.C7881a().b(this.f232555m0).d(this.f232556n0);
        Source source2 = Source.CreatePage;
        if (source == source2) {
            z16 = true;
        } else {
            z16 = false;
        }
        ChannelPermissionEditFragment.Companion.OpenParam.C7881a c16 = d16.c(z16);
        if (source != source2) {
            name = null;
        }
        ChannelPermissionEditFragment.Rh(requireContext, c16.e(name).f(ChannelPermissionTypeForRole.ApproveSpeak).a(), 101);
    }

    private void Bi() {
        Source source;
        boolean z16;
        if (this.f232557o0 == 0) {
            source = Source.CreatePage;
        } else {
            source = Source.RoleGroup;
        }
        if (!GuildDebugUtils.f(this.f232555m0)) {
            ChannelPermissionForRoleDialog channelPermissionForRoleDialog = new ChannelPermissionForRoleDialog(ChannelPermissionTypeForRole.ApproveVisible, this.f232555m0, this.f232556n0, source);
            this.f232560r0 = channelPermissionForRoleDialog;
            com.tencent.mobileqq.guild.base.extension.d.a(channelPermissionForRoleDialog, getChildFragmentManager(), "Guild.rg.ChannelPermissionForRoleDialog");
            return;
        }
        String name = this.f232562t0.g2().getName();
        Context requireContext = requireContext();
        ChannelPermissionEditFragment.Companion.OpenParam.C7881a d16 = new ChannelPermissionEditFragment.Companion.OpenParam.C7881a().b(this.f232555m0).d(this.f232556n0);
        Source source2 = Source.CreatePage;
        if (source == source2) {
            z16 = true;
        } else {
            z16 = false;
        }
        ChannelPermissionEditFragment.Companion.OpenParam.C7881a c16 = d16.c(z16);
        if (source != source2) {
            name = null;
        }
        ChannelPermissionEditFragment.Rh(requireContext, c16.e(name).f(ChannelPermissionTypeForRole.ApproveVisible).a(), 101);
    }

    public static void Ci(Context context, String str, int i3, String str2, int i16, int i17, int i18) {
        if (i3 == 0 && TextUtils.isEmpty(str2)) {
            QLog.w("Guild.rg.GuildRoleDetailFragment", 1, "open ROLE_GROUP_CREATE_PAGE bug roleId is empty");
            str2 = "1";
        }
        Intent di5 = di(str, i3, str2, i16);
        di5.putExtra("extra_role_color", i18);
        if (!(context instanceof Activity)) {
            di5.addFlags(268435456);
        }
        QPublicFragmentActivity.b.f(context, di5, QPublicFragmentActivity.class, GuildRoleDetailFragment.class, i17);
    }

    public static void Di(String str, int i3, String str2, int i16) {
        Context context = QBaseActivity.sTopActivity;
        if (context == null) {
            context = BaseApplication.getContext();
        }
        Intent di5 = di(str, i3, str2, i16);
        if (!(context instanceof Activity)) {
            di5.addFlags(268435456);
        }
        QPublicFragmentActivity.start(context, di5, GuildRoleDetailFragment.class);
    }

    private void Ei() {
        int i3 = this.f232557o0;
        if (i3 == 0) {
            tx1.b.d(getActivity(), this.f232555m0, this.f232562t0.g2().getMemberLimit(), this.f232562t0.d2(), this.f232562t0.c2());
            return;
        }
        if (i3 == 2) {
            tx1.b.e(getActivity(), this.f232555m0, this.f232556n0, this.f232562t0.g2().getMemberLimit(), this.f232562t0.g2().getIsLevelRole(), ei());
            return;
        }
        QLog.e("Guild.rg.GuildRoleDetailFragment", 1, "openManageMemberPage invalid mOpenType:" + this.f232557o0);
    }

    private void Fi() {
        if (fi() == ModifyRolePermissionType.NO_PERMISSION) {
            this.f232562t0.a2();
            this.f232562t0.b2();
        }
    }

    private void Gi(View view, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("sgrp_sub_channel_id", this.f232555m0);
        hashMap.put("sgrp_user_type", Integer.valueOf(this.f232566x0));
        VideoReport.setElementId(view, str);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
        VideoReport.reportEvent("clck", view, hashMap);
    }

    private void Hi(View view, boolean z16, int i3, String str, String str2) {
        int i16;
        HashMap hashMap = new HashMap();
        if (z16) {
            i16 = 1;
        } else {
            i16 = 2;
        }
        hashMap.put("sgrp_switch_type", Integer.valueOf(i16));
        hashMap.put("sgrp_sub_channel_id", this.f232555m0);
        hashMap.put("sgrp_user_type", Integer.valueOf(this.f232566x0));
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("sgrp_manage_type", str);
        } else {
            QLog.e("Guild.rg.GuildRoleDetailFragment", 1, "invalid DT param for permissionName with id " + i3);
        }
        VideoReport.setElementId(view, str2);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
        VideoReport.reportEvent("clck", view, hashMap);
    }

    private void Ii() {
        Intent intent = getActivity().getIntent();
        if (intent == null) {
            QLog.e("Guild.rg.GuildRoleDetailFragment", 1, "bundle is null");
            onBackEvent();
            return;
        }
        this.f232558p0 = intent.getIntExtra("guild_owner_operation_dialog_type", 0);
        this.f232557o0 = intent.getIntExtra("group_setting_page_open_type", 0);
        this.f232555m0 = intent.getStringExtra("extra_guild_id");
        this.f232556n0 = intent.getStringExtra("role_group_id");
        this.f232567y0 = intent.getIntExtra("extra_role_color", -1);
        if (TextUtils.isEmpty(this.f232555m0)) {
            QLog.e("Guild.rg.GuildRoleDetailFragment", 1, "guildId is null");
            onBackEvent();
        }
        if (TextUtils.isEmpty(this.f232556n0) && this.f232557o0 == 2) {
            QLog.e("Guild.rg.GuildRoleDetailFragment", 1, "groupId is null");
            onBackEvent();
        }
    }

    private void Ji() {
        Li(this.U, "em_sgrp_role_name");
        Li(this.V, "em_sgrp_role_color_switch");
        Li(this.f232546d0.findViewById(R.id.i_w), "em_sgrp_role_display_switch");
        Li(this.F, "em_sgrp_role_new_button");
        int i3 = this.f232557o0;
        if (i3 == 0) {
            Li(this.C, "em_sgrp_role_cancel_button");
        } else if (i3 == 2) {
            Li(this.C, "em_sgrp_auditset_back");
        }
    }

    private void Ki() {
        if (TextUtils.isEmpty(this.f232555m0)) {
            return;
        }
        this.f232566x0 = com.tencent.mobileqq.guild.data.v.c(this.f232555m0);
        HashMap hashMap = new HashMap();
        hashMap.put("sgrp_channel_id", this.f232555m0);
        hashMap.put("sgrp_user_type", Integer.valueOf(this.f232566x0));
        VideoReport.addToDetectionWhitelist(getActivity());
        if (this.f232557o0 == 0) {
            VideoReport.setPageId(this.N, "pg_sgrp_role_new");
        } else {
            VideoReport.setPageId(this.N, "pg_sgrp_role_edit");
        }
        ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).setGuildPageParams(this.N, this.f232555m0, hashMap);
    }

    private void Li(View view, String str) {
        VideoReport.setElementId(view, str);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
    }

    private void Mi() {
        String str;
        int i3 = this.f232557o0;
        if (i3 == 2) {
            str = QQGuildUIUtil.r(R.string.f154621fa);
        } else if (i3 == 0) {
            str = QQGuildUIUtil.r(R.string.f154641fc);
        } else {
            str = "";
        }
        DialogUtil.createCustomDialog(getContext(), 0, str, "", R.string.f1513017b, R.string.f155081gj, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.rolegroup.fragments.roledetail.ar
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i16) {
                GuildRoleDetailFragment.this.ui(dialogInterface, i16);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.rolegroup.fragments.roledetail.as
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i16) {
                GuildRoleDetailFragment.this.vi(dialogInterface, i16);
            }
        }).show();
    }

    private void Ni() {
        ColorPickDialogFragment.sh(this.f232562t0.g2().getColor()).show(getChildFragmentManager(), "ColorPickDialogFragment");
    }

    private void Oi() {
        final ActionSheet actionSheet = (ActionSheet) ActionSheetHelper.createDialog(getActivity(), null);
        actionSheet.setMainTitle(R.string.f154631fb);
        actionSheet.addButton(R.string.f143030kz, 3);
        actionSheet.addCancelButton(R.string.f140850f3);
        actionSheet.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.mobileqq.guild.rolegroup.fragments.roledetail.ao
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public final void onClick(View view, int i3) {
                GuildRoleDetailFragment.this.wi(actionSheet, view, i3);
            }
        });
        actionSheet.setOnDismissListener(new ap(actionSheet));
        actionSheet.show();
    }

    private void Pi() {
        this.f232558p0 = 0;
        Xh();
        GuildOwnerOperationTipCard guildOwnerOperationTipCard = new GuildOwnerOperationTipCard(this.f232555m0, 3);
        this.f232559q0 = guildOwnerOperationTipCard;
        com.tencent.mobileqq.guild.base.extension.d.a(guildOwnerOperationTipCard, getChildFragmentManager(), "Guild.profile.GuildOwnerOperationTipCard");
    }

    private void Qi() {
        this.T.setVisibility(4);
        this.f232561s0 = new QQProgressDialog(getActivity());
        this.P.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.rolegroup.fragments.roledetail.ak
            @Override // java.lang.Runnable
            public final void run() {
                GuildRoleDetailFragment.this.xi();
            }
        }, 700L);
    }

    private void Ri() {
        if (gi() && this.f232562t0.g2().getLvRole() != null && !TextUtils.isEmpty(this.f232562t0.g2().getLvRole().getDisplayTagName())) {
            this.V.setClickable(false);
            this.f232545c0.setVisibility(8);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f232544b0.getLayoutParams();
            layoutParams.setMarginEnd(ViewUtils.dpToPx(16.0f));
            this.f232544b0.setLayoutParams(layoutParams);
            return;
        }
        this.V.setClickable(true);
        this.f232545c0.setVisibility(0);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f232544b0.getLayoutParams();
        layoutParams2.setMarginEnd(ViewUtils.dpToPx(40.0f));
        this.f232544b0.setLayoutParams(layoutParams2);
    }

    private void Si(RoleGroupModel roleGroupModel) {
        String name;
        if (this.f232557o0 != 0) {
            RoleGroupModel i26 = this.f232562t0.i2();
            if (i26.getIsLevelRole() && i26.getLvRole() != null) {
                name = i26.getLvRole().getLevelSimpleDsc() + " " + i26.getName();
            } else {
                name = i26.getName();
            }
            this.E.setText(name);
        }
        this.F.setEnabled(false);
        this.F.setVisibility(0);
        this.U.setText(roleGroupModel.getName());
        CharacterCountEditText characterCountEditText = this.U;
        characterCountEditText.setSelection(characterCountEditText.getText().length());
        this.f232543a0.setImageTintList(ColorStateList.valueOf(roleGroupModel.getColor()));
        this.f232544b0.setText(ch.t(roleGroupModel.getColor()));
        Ri();
        if (this.f232557o0 != 0 && !roleGroupModel.getIsLevelRole() && roleGroupModel.getLvRole() != null && roleGroupModel.getLvRole().getDisplayType() == 1) {
            this.X.setVisibility(0);
            this.Y.setBackgroundColor(this.f232567y0);
            String displayTagName = roleGroupModel.getDisplayTagName();
            TextView textView = this.Z;
            if (TextUtils.isEmpty(displayTagName)) {
                displayTagName = getContext().getResources().getString(R.string.f154371em);
            }
            textView.setText(displayTagName);
        } else {
            this.X.setVisibility(8);
        }
        if (roleGroupModel.getLvRole() != null && roleGroupModel.getLvRole().getDisplayType() == 1) {
            this.f232546d0.setBtnReplacedWithIcon();
            this.f232562t0.g2().H(true);
        } else {
            this.f232546d0.setBtnNormal(roleGroupModel.getIsHoist(), true);
        }
        this.f232564v0.m0(true, this.f232562t0.g2().getRolePermission().g(), this.f232562t0.g2().getIsLevelRole());
        this.f232564v0.n0(this.f232565w0);
        Ti();
    }

    private void Ti() {
        RoleGroupModel g26 = this.f232562t0.g2();
        if (g26 == null) {
            return;
        }
        ChannelPermission channelPermission = g26.getChannelPermission();
        boolean f16 = GuildDebugUtils.f(this.f232555m0);
        List<String> value = this.f232562t0.w2().getValue();
        this.f232551i0.setChannelInfo(channelPermission.b(), value, f16);
        this.f232552j0.setChannelInfo(channelPermission.a(), value, f16);
        this.F.setEnabled(this.f232562t0.U1());
    }

    private void Ui(ModifyRolePermissionType modifyRolePermissionType) {
        com.tencent.mobileqq.guild.base.view.colorpick.d O1 = com.tencent.mobileqq.guild.base.view.colorpick.d.O1(requireActivity());
        if (modifyRolePermissionType == ModifyRolePermissionType.NO_PERMISSION) {
            O1.P1(com.tencent.mobileqq.guild.base.view.colorpick.a.b());
        } else if (modifyRolePermissionType == ModifyRolePermissionType.HAS_PERMISSION && this.f232562t0.g2().getManageTagPendingColor() != 0) {
            O1.P1((int) this.f232562t0.g2().getManageTagPendingColor());
        }
    }

    private void Wh() {
        QQProgressDialog qQProgressDialog = this.f232561s0;
        if (qQProgressDialog != null && qQProgressDialog.isShowing()) {
            this.f232561s0.dismiss();
        }
    }

    private void Xh() {
        GuildOwnerOperationTipCard guildOwnerOperationTipCard = this.f232559q0;
        if (guildOwnerOperationTipCard != null) {
            guildOwnerOperationTipCard.dismissAllowingStateLoss();
            this.f232559q0 = null;
        }
    }

    private g.a Yh() {
        return new g.a() { // from class: com.tencent.mobileqq.guild.rolegroup.fragments.roledetail.aq
            @Override // ux1.g.a
            public final void a(int i3, String str, boolean z16, View view) {
                GuildRoleDetailFragment.this.hi(i3, str, z16, view);
            }
        };
    }

    private void Zh(boolean z16, ModifyRolePermissionType modifyRolePermissionType) {
        if (z16) {
            Ui(modifyRolePermissionType);
        }
        int i3 = this.f232557o0;
        if (i3 == 0) {
            this.f232562t0.W1();
            return;
        }
        if (i3 == 2) {
            this.f232562t0.A2();
            return;
        }
        QLog.e("Guild.rg.GuildRoleDetailFragment", 2, "Unknown mOpenType when click rightViewText:" + this.f232557o0);
    }

    private void ai() {
        Si(this.f232562t0.g2());
        initListener();
        Wh();
        this.T.setVisibility(0);
    }

    private void bi() {
        this.C.setBackgroundResource(0);
        this.C.setText(R.string.f140850f3);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.C.getLayoutParams();
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.C.setPadding(0, 0, 0, 0);
        this.E.setText(getString(R.string.f142940kq));
        this.F.setText(R.string.f143340lt);
        this.f232553k0.setVisibility(8);
    }

    private void ci() {
        this.X.setVisibility(8);
        this.f232546d0.setVisibility(8);
        this.W.setText(R.string.f154721fk);
        this.f232553k0.setVisibility(8);
        this.f232548f0.setText(this.f232562t0.g2().getLvRole().getLevelDesc());
        this.f232543a0.setVisibility(8);
        this.f232544b0.setVisibility(8);
        this.f232545c0.setVisibility(8);
        this.f232554l0.setVisibility(0);
        this.U.setLimitCount(5);
        this.V.setOnClickListener(null);
        this.U.setHint(R.string.f147360wo);
        this.f232547e0.setText(String.format(getString(R.string.f147350wn), this.f232562t0.f2().getValue()));
        GuildLevelRoleView.l(this.f232562t0.g2().getLvRole(), "Guild.rg.GuildRoleDetailFragment", new Function1() { // from class: com.tencent.mobileqq.guild.rolegroup.fragments.roledetail.aj
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit ii5;
                ii5 = GuildRoleDetailFragment.this.ii((GuildLevelRoleView.UIData) obj);
                return ii5;
            }
        });
    }

    @NonNull
    private static Intent di(String str, int i3, String str2, int i16) {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putSerializable("extra_guild_id", str);
        bundle.putSerializable("group_setting_page_open_type", Integer.valueOf(i3));
        bundle.putSerializable("role_group_id", str2);
        bundle.putInt("guild_owner_operation_dialog_type", i16);
        intent.putExtras(bundle);
        return intent;
    }

    private String ei() {
        if (!TextUtils.isEmpty(this.f232562t0.g2().getName())) {
            return this.f232562t0.g2().getName();
        }
        if (this.f232562t0.g2().getLvRole() != null && !TextUtils.isEmpty(this.f232562t0.g2().getLvRole().getLevelSimpleDsc())) {
            return this.f232562t0.g2().getLvRole().getLevelSimpleDsc();
        }
        return HardCodeUtil.qqStr(R.string.f154681fg);
    }

    private ModifyRolePermissionType fi() {
        int h26 = this.f232562t0.h2();
        int l26 = this.f232562t0.l2();
        if (this.f232557o0 == 0) {
            if (l26 > 0) {
                return ModifyRolePermissionType.HAS_PERMISSION;
            }
            return ModifyRolePermissionType.UNCHANGED;
        }
        if (h26 == 0 && l26 > 0) {
            return ModifyRolePermissionType.HAS_PERMISSION;
        }
        if (h26 > 0) {
            if (this.f232562t0.g2().getLvRole() != null && this.f232562t0.g2().getLvRole().getDisplayType() == 1) {
                if (l26 == 0) {
                    return ModifyRolePermissionType.NO_PERMISSION;
                }
                return ModifyRolePermissionType.UNCHANGED;
            }
            if (l26 == 0) {
                return ModifyRolePermissionType.UNCHANGED;
            }
            return ModifyRolePermissionType.HAS_PERMISSION;
        }
        return ModifyRolePermissionType.UNCHANGED;
    }

    private boolean gi() {
        if (this.f232562t0.g2().getLvRole() != null && this.f232562t0.g2().getLvRole().getPermission().getHasRolePermission()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void hi(int i3, String str, boolean z16, View view) {
        if (z16) {
            if (this.f232562t0.g2().getRolePermission().i().contains(Integer.valueOf(i3))) {
                QLog.e("Guild.rg.GuildRoleDetailFragment", 1, "permissionType:" + i3 + " alreadyHadNow");
                return;
            }
            this.f232562t0.g2().getRolePermission().i().add(Integer.valueOf(i3));
        } else {
            this.f232562t0.g2().getRolePermission().i().remove(Integer.valueOf(i3));
        }
        this.F.setEnabled(this.f232562t0.U1());
        Hi(view, z16, i3, str, "em_sgrp_role_manage_type");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit ii(GuildLevelRoleView.UIData uIData) {
        QLog.d("Guild.rg.GuildRoleDetailFragment", 1, "convertGuildRoleInfoToUIData: " + uIData);
        this.f232554l0.s(uIData);
        return null;
    }

    private void initListener() {
        this.f232550h0.c(new a.InterfaceC7880a() { // from class: com.tencent.mobileqq.guild.rolegroup.fragments.roledetail.al
            @Override // com.tencent.mobileqq.guild.rolegroup.adapters.previewavatar.a.InterfaceC7880a
            public final void a(View view, a.b bVar) {
                GuildRoleDetailFragment.this.ji(view, bVar);
            }
        });
        this.U.setCountChangeListener(new a());
        this.f232546d0.setRightButtonListener(new GuildSwitchButton.a() { // from class: com.tencent.mobileqq.guild.rolegroup.fragments.roledetail.am
            @Override // com.tencent.mobileqq.guild.widget.GuildSwitchButton.a
            public final void onCheckedChanged(GuildSwitchButton guildSwitchButton, boolean z16) {
                GuildRoleDetailFragment.this.ki(guildSwitchButton, z16);
            }
        });
    }

    private void initView() {
        this.C.setOnClickListener(this);
        uh(ViewUtils.dpToPx(16.0f));
        this.F.setText(R.string.f155081gj);
        this.F.setTextColor(getResources().getColorStateList(R.color.bth));
        this.F.setOnClickListener(this);
        this.T = (LinearLayout) this.P.findViewById(R.id.f783246r);
        CharacterCountEditText characterCountEditText = (CharacterCountEditText) this.P.findViewById(R.id.vu5);
        this.U = characterCountEditText;
        characterCountEditText.setLimitCount(15);
        this.X = (RelativeLayout) this.P.findViewById(R.id.vtz);
        this.Y = (RadiusFrameLayout) this.P.findViewById(R.id.f778945l);
        this.Z = (TextView) this.P.findViewById(R.id.f779045m);
        RelativeLayout relativeLayout = (RelativeLayout) this.P.findViewById(R.id.vtf);
        this.V = relativeLayout;
        relativeLayout.setOnClickListener(this);
        this.W = (TextView) this.P.findViewById(R.id.wxd);
        this.f232543a0 = (ImageView) this.P.findViewById(R.id.vtg);
        this.f232544b0 = (TextView) this.P.findViewById(R.id.vti);
        this.f232545c0 = this.P.findViewById(R.id.u0w);
        this.f232554l0 = (GuildLevelRoleView) this.P.findViewById(R.id.xvh);
        this.f232546d0 = (TextAndSwitchButtonBar) this.P.findViewById(R.id.xa6);
        this.f232547e0 = (TextView) this.P.findViewById(R.id.f165405vu1);
        TextView textView = (TextView) this.P.findViewById(R.id.f166220z23);
        this.f232548f0 = textView;
        textView.setOnClickListener(this);
        this.f232549g0 = (TextView) this.P.findViewById(R.id.wle);
        this.f232550h0 = (GuildRoleMemberPreviewView) this.P.findViewById(R.id.z2_);
        GuildRoleGroupChannelPermissionView guildRoleGroupChannelPermissionView = (GuildRoleGroupChannelPermissionView) this.P.findViewById(R.id.f11995789);
        this.f232551i0 = guildRoleGroupChannelPermissionView;
        guildRoleGroupChannelPermissionView.setOnClickListener(this);
        GuildRoleGroupChannelPermissionView guildRoleGroupChannelPermissionView2 = (GuildRoleGroupChannelPermissionView) this.P.findViewById(R.id.f87144tk);
        this.f232552j0 = guildRoleGroupChannelPermissionView2;
        guildRoleGroupChannelPermissionView2.setOnClickListener(this);
        if (GuildDebugUtils.f(this.f232555m0)) {
            this.f232552j0.setLeftText("\u53d1\u8a00\u6743\u9650");
            this.f232551i0.setLeftText("\u67e5\u770b\u6743\u9650");
        }
        RelativeLayout relativeLayout2 = (RelativeLayout) this.P.findViewById(R.id.f164963ug1);
        this.f232553k0 = relativeLayout2;
        relativeLayout2.setOnClickListener(this);
        RecyclerView recyclerView = (RecyclerView) this.P.findViewById(R.id.f239007o);
        this.f232563u0 = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        ux1.g gVar = new ux1.g();
        this.f232564v0 = gVar;
        this.f232563u0.setAdapter(gVar);
        this.f232563u0.setNestedScrollingEnabled(false);
        if (this.f232557o0 == 0) {
            bi();
        }
        if (this.f232558p0 == 1) {
            Pi();
        }
    }

    private void initViewModel() {
        com.tencent.mobileqq.guild.base.view.colorpick.d.O1(requireActivity()).N1().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.guild.rolegroup.fragments.roledetail.at
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildRoleDetailFragment.this.li((Integer) obj);
            }
        });
        RoleGroupViewModel roleGroupViewModel = (RoleGroupViewModel) ef1.c.a(this, RoleGroupViewModel.class, new Function0() { // from class: com.tencent.mobileqq.guild.rolegroup.fragments.roledetail.au
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                RoleGroupViewModel mi5;
                mi5 = GuildRoleDetailFragment.this.mi();
                return mi5;
            }
        });
        this.f232562t0 = roleGroupViewModel;
        roleGroupViewModel.getPageState().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.guild.rolegroup.fragments.roledetail.av
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildRoleDetailFragment.this.ni((Integer) obj);
            }
        });
        this.f232562t0.f2().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.guild.rolegroup.fragments.roledetail.ae
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildRoleDetailFragment.this.oi((Integer) obj);
            }
        });
        this.f232562t0.w2().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.guild.rolegroup.fragments.roledetail.af
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildRoleDetailFragment.this.pi((List) obj);
            }
        });
        this.f232562t0.k2().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.guild.rolegroup.fragments.roledetail.ag
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildRoleDetailFragment.this.qi((List) obj);
            }
        });
        this.f232562t0.j2().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.guild.rolegroup.fragments.roledetail.ah
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildRoleDetailFragment.this.ri((List) obj);
            }
        });
        this.f232562t0.e2().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.guild.rolegroup.fragments.roledetail.ai
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildRoleDetailFragment.this.si((Boolean) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ji(View view, a.b bVar) {
        int i3 = bVar.f232295a;
        if (i3 == 0) {
            int i16 = this.f232557o0;
            if (i16 == 0) {
                tx1.b.a(getActivity(), this.f232555m0, this.f232562t0.g2().getMemberLimit(), this.f232562t0.d2(), this.f232562t0.c2());
            } else if (i16 == 2) {
                tx1.b.b(getActivity(), this.f232555m0, this.f232556n0, this.f232562t0.g2().getMemberLimit(), this.f232562t0.d2(), this.f232562t0.g2().getUserCount());
            }
            Gi(view, "em_sgrp_member_list_member_add");
            return;
        }
        if (i3 == 1) {
            Ei();
            Gi(view, "em_sgrp_member_list_member_manage");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ki(GuildSwitchButton guildSwitchButton, boolean z16) {
        this.f232562t0.g2().H(z16);
        this.F.setEnabled(this.f232562t0.U1());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void li(Integer num) {
        if (this.f232562t0.g2().getColor() != num.intValue()) {
            this.f232562t0.g2().F(num.intValue());
            this.f232543a0.setImageTintList(ColorStateList.valueOf(this.f232562t0.g2().getColor()));
            this.f232544b0.setText(ch.t(this.f232562t0.g2().getColor()));
            this.F.setEnabled(this.f232562t0.U1());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ RoleGroupViewModel mi() {
        return new RoleGroupViewModel(this.f232555m0, this.f232556n0, this.f232557o0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ni(Integer num) {
        QLog.d("Guild.rg.GuildRoleDetailFragment", 1, "getPageState: " + num);
        int intValue = num.intValue();
        if (intValue != 0) {
            if (intValue != 1) {
                if (intValue != 3) {
                    if (intValue == 4) {
                        super.onBackEvent();
                        return;
                    }
                    return;
                } else {
                    Fi();
                    Ti();
                    return;
                }
            }
            ai();
            return;
        }
        Qi();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void oi(Integer num) {
        int i3;
        if (this.f232562t0.g2() != null && this.f232562t0.g2().getIsLevelRole()) {
            i3 = R.string.f147350wn;
        } else {
            i3 = R.string.f154691fh;
        }
        this.f232547e0.setText(String.format(getString(i3), num));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void pi(List list) {
        Ti();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void qi(List list) {
        boolean z16;
        boolean z17;
        boolean z18 = true;
        if (this.f232562t0.e2().getValue() != null && this.f232562t0.e2().getValue().booleanValue()) {
            z16 = false;
        } else {
            z16 = true;
        }
        GuildRoleMemberPreviewView guildRoleMemberPreviewView = this.f232550h0;
        if (list.size() > this.f232550h0.e() - 1) {
            z17 = true;
        } else {
            z17 = false;
        }
        guildRoleMemberPreviewView.setPreviewItemDataWithNickname(list, z17, z16);
        TextView textView = this.f232548f0;
        if (list.size() <= 0 || !z16) {
            z18 = false;
        }
        textView.setEnabled(z18);
        if (!z16 && list.isEmpty()) {
            this.f232549g0.setVisibility(0);
        } else {
            this.f232549g0.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ri(List list) {
        this.f232564v0.setData(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void si(Boolean bool) {
        if (bool.booleanValue()) {
            ci();
            return;
        }
        this.f232546d0.setVisibility(0);
        this.W.setText(R.string.f154611f_);
        if (this.f232557o0 != 0) {
            this.f232553k0.setVisibility(0);
        }
        this.f232554l0.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ti(ModifyRolePermissionType modifyRolePermissionType) {
        Zh(true, modifyRolePermissionType);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ui(DialogInterface dialogInterface, int i3) {
        zi();
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void vi(DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
        requireActivity().finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void wi(ActionSheet actionSheet, View view, int i3) {
        if (com.tencent.mobileqq.guild.util.o.a(view)) {
            return;
        }
        this.f232562t0.X1();
        actionSheet.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void xi() {
        if (getActivity() != null && this.f232562t0.m2()) {
            this.f232561s0.show();
        }
    }

    private void yi() {
        Ei();
        Gi(this.f232548f0, "em_sgrp_member_list_member_manage");
    }

    private void zi() {
        final ModifyRolePermissionType fi5 = fi();
        this.f232562t0.y2(fi5);
        if (fi5 != ModifyRolePermissionType.UNCHANGED && !this.f232562t0.g2().getIsLevelRole()) {
            final d dVar = new d(requireContext());
            dVar.U(fi5);
            dVar.W(this.f232562t0.g2());
            dVar.setCanceledOnTouchOutside(false);
            dVar.S(new d.Companion.InterfaceC7883a() { // from class: com.tencent.mobileqq.guild.rolegroup.fragments.roledetail.ad
                @Override // com.tencent.mobileqq.guild.rolegroup.fragments.roledetail.d.Companion.InterfaceC7883a
                public final void onClick() {
                    GuildRoleDetailFragment.this.ti(fi5);
                }
            });
            dVar.R(new d.Companion.InterfaceC7883a() { // from class: com.tencent.mobileqq.guild.rolegroup.fragments.roledetail.an
                @Override // com.tencent.mobileqq.guild.rolegroup.fragments.roledetail.d.Companion.InterfaceC7883a
                public final void onClick() {
                    d.this.dismiss();
                }
            });
            dVar.show();
            return;
        }
        Zh(false, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment, com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment
    public void doOnCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.doOnCreateView(layoutInflater, viewGroup, bundle);
        Ii();
        initView();
        initViewModel();
        Ki();
        Ji();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f6c;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, @Nullable Intent intent) {
        super.onActivityResult(i3, i16, intent);
        int i17 = this.f232557o0;
        if (i17 == 0) {
            if (i16 == -1 && intent != null) {
                this.f232562t0.z2(intent.getStringArrayExtra("selected_id_array"), (RoleGroupUserUIData[]) intent.getSerializableExtra("selected_ui_array"));
                this.F.setEnabled(this.f232562t0.U1());
                return;
            }
            return;
        }
        if (i17 == 2) {
            this.f232562t0.a2();
            this.f232562t0.Z1();
            this.f232562t0.x2();
        }
    }

    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        if (!this.f232562t0.o2() && !this.f232562t0.m2() && this.F.isEnabled() && this.f232562t0.getPageState().getValue() != null && this.f232562t0.getPageState().getValue().intValue() != 4) {
            Mi();
            return true;
        }
        return super.onBackEvent();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (!QQGuildUIUtil.v()) {
            int id5 = view.getId();
            if (view == this.C) {
                onBackEvent();
            } else if (view == this.F) {
                zi();
            } else if (id5 == R.id.vtf) {
                Ni();
            } else if (id5 == R.id.f166220z23) {
                yi();
            } else if (id5 == R.id.f11995789) {
                Bi();
            } else if (id5 == R.id.f87144tk) {
                Ai();
            } else if (id5 == R.id.f164963ug1) {
                Oi();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        super.onDestroyView();
        Wh();
        Xh();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        ChannelPermissionForRoleDialog channelPermissionForRoleDialog = this.f232560r0;
        if (channelPermissionForRoleDialog != null) {
            channelPermissionForRoleDialog.dismissAllowingStateLoss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class a implements CharacterCountEditText.c {
        a() {
        }

        @Override // com.tencent.mobileqq.guild.widget.CharacterCountEditText.c
        public void s7(cb.b bVar) {
            GuildRoleDetailFragment.this.f232562t0.g2().J(GuildRoleDetailFragment.this.U.getText().toString());
            GuildRoleDetailFragment guildRoleDetailFragment = GuildRoleDetailFragment.this;
            guildRoleDetailFragment.F.setEnabled(guildRoleDetailFragment.f232562t0.U1());
        }

        @Override // com.tencent.mobileqq.guild.widget.CharacterCountEditText.c
        public void Bf(cb.b bVar) {
        }
    }
}
