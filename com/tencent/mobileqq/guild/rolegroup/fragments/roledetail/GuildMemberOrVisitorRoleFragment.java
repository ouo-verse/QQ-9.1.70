package com.tencent.mobileqq.guild.rolegroup.fragments.roledetail;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment;
import com.tencent.mobileqq.guild.rolegroup.adapters.previewavatar.a;
import com.tencent.mobileqq.guild.rolegroup.fragments.ChannelPermissionEditFragment;
import com.tencent.mobileqq.guild.rolegroup.fragments.ChannelPermissionForRoleDialog;
import com.tencent.mobileqq.guild.rolegroup.fragments.ChannelPermissionTypeForRole;
import com.tencent.mobileqq.guild.rolegroup.fragments.Source;
import com.tencent.mobileqq.guild.rolegroup.model.data.ChannelPermission;
import com.tencent.mobileqq.guild.rolegroup.model.data.RoleGroupModel;
import com.tencent.mobileqq.guild.rolegroup.view.GuildRoleGroupChannelPermissionView;
import com.tencent.mobileqq.guild.rolegroup.view.previewavatar.GuildRoleMemberPreviewView;
import com.tencent.mobileqq.guild.rolegroup.viewmodel.RoleGroupViewModel;
import com.tencent.mobileqq.guild.util.GuildDebugUtils;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.List;
import kotlin.jvm.functions.Function0;

/* compiled from: P */
/* loaded from: classes14.dex */
public class GuildMemberOrVisitorRoleFragment extends QQGuildTitleBarFragment implements View.OnClickListener {
    private LinearLayout T;
    private ImageView U;
    private TextView V;
    private TextView W;
    private GuildRoleMemberPreviewView X;
    private GuildRoleGroupChannelPermissionView Y;
    private GuildRoleGroupChannelPermissionView Z;

    /* renamed from: a0, reason: collision with root package name */
    private String f232537a0;

    /* renamed from: b0, reason: collision with root package name */
    private String f232538b0;

    /* renamed from: c0, reason: collision with root package name */
    private int f232539c0;

    /* renamed from: d0, reason: collision with root package name */
    private QQProgressDialog f232540d0;

    /* renamed from: e0, reason: collision with root package name */
    private ChannelPermissionForRoleDialog f232541e0;

    /* renamed from: f0, reason: collision with root package name */
    private RoleGroupViewModel f232542f0;

    private void Jh() {
        QQProgressDialog qQProgressDialog = this.f232540d0;
        if (qQProgressDialog != null && qQProgressDialog.isShowing()) {
            this.f232540d0.dismiss();
        }
    }

    private void Kh() {
        bi(this.f232542f0.g2());
        initListener();
        Jh();
        this.T.setVisibility(0);
    }

    private Source Lh() {
        if (this.f232539c0 == 6) {
            return Source.VisitorMember;
        }
        return Source.NormalMember;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Mh(View view, a.b bVar) {
        int i3 = bVar.f232295a;
        if (i3 == 0) {
            tx1.b.b(getActivity(), this.f232537a0, this.f232538b0, this.f232542f0.g2().getMemberLimit(), this.f232542f0.d2(), this.f232542f0.g2().getUserCount());
        } else if (i3 == 1) {
            tx1.b.f(getActivity(), this.f232537a0, this.f232538b0, this.f232542f0.g2().getMemberLimit());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ RoleGroupViewModel Nh() {
        return new RoleGroupViewModel(this.f232537a0, this.f232538b0, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Oh(Integer num) {
        int intValue = num.intValue();
        if (intValue != 0) {
            if (intValue != 1) {
                if (intValue == 4) {
                    onBackEvent();
                    return;
                }
                return;
            }
            Kh();
            return;
        }
        ai();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ph(List list) {
        boolean z16;
        GuildRoleMemberPreviewView guildRoleMemberPreviewView = this.X;
        boolean z17 = true;
        if (list.size() > this.X.e() - 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        guildRoleMemberPreviewView.setPreviewItemDataWithNickname(list, z16);
        TextView textView = this.W;
        if (list.size() <= 0) {
            z17 = false;
        }
        textView.setEnabled(z17);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Qh(List list) {
        ci();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Rh() {
        if (this.f232542f0.m2()) {
            this.f232540d0.show();
        }
    }

    private void Sh() {
        if (!GuildDebugUtils.f(this.f232537a0)) {
            ChannelPermissionForRoleDialog channelPermissionForRoleDialog = new ChannelPermissionForRoleDialog(ChannelPermissionTypeForRole.ApproveSpeak, this.f232537a0, this.f232538b0, Lh());
            this.f232541e0 = channelPermissionForRoleDialog;
            com.tencent.mobileqq.guild.base.extension.d.a(channelPermissionForRoleDialog, getChildFragmentManager(), "Guild.rg.ChannelPermissionForRoleDialog");
        } else {
            ChannelPermissionEditFragment.Rh(requireContext(), new ChannelPermissionEditFragment.Companion.OpenParam.C7881a().b(this.f232537a0).d(this.f232538b0).c(true).e(this.f232542f0.g2().getName()).f(ChannelPermissionTypeForRole.ApproveSpeak).a(), 101);
        }
    }

    private void Th() {
        if (!GuildDebugUtils.f(this.f232537a0)) {
            ChannelPermissionForRoleDialog channelPermissionForRoleDialog = new ChannelPermissionForRoleDialog(ChannelPermissionTypeForRole.ApproveVisible, this.f232537a0, this.f232538b0, Lh());
            this.f232541e0 = channelPermissionForRoleDialog;
            com.tencent.mobileqq.guild.base.extension.d.a(channelPermissionForRoleDialog, getChildFragmentManager(), "Guild.rg.ChannelPermissionForRoleDialog");
        } else {
            ChannelPermissionEditFragment.Rh(requireContext(), new ChannelPermissionEditFragment.Companion.OpenParam.C7881a().b(this.f232537a0).d(this.f232538b0).c(true).e(this.f232542f0.g2().getName()).f(ChannelPermissionTypeForRole.ApproveVisible).a(), 101);
        }
    }

    public static void Uh(Context context, String str, String str2, int i3) {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putSerializable("extra_guild_id", str);
        bundle.putSerializable("role_group_id", str2);
        bundle.putInt("role_type", i3);
        intent.putExtras(bundle);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        QPublicFragmentActivity.b.b(context, intent, QPublicFragmentActivity.class, GuildMemberOrVisitorRoleFragment.class);
    }

    private void Vh() {
        Intent intent = getActivity().getIntent();
        if (intent == null) {
            QLog.e("Guild.rg.EveryoneRoleGroupDetailFragment", 1, "bundle is null");
            onBackEvent();
            return;
        }
        this.f232537a0 = intent.getStringExtra("extra_guild_id");
        this.f232538b0 = intent.getStringExtra("role_group_id");
        this.f232539c0 = intent.getIntExtra("role_type", 1);
        if (TextUtils.isEmpty(this.f232537a0)) {
            QLog.e("Guild.rg.EveryoneRoleGroupDetailFragment", 1, "guildId is null");
            onBackEvent();
        }
        if (TextUtils.isEmpty(this.f232538b0)) {
            QLog.e("Guild.rg.EveryoneRoleGroupDetailFragment", 1, "groupId is null");
            onBackEvent();
        }
    }

    private void Wh() {
        Yh(this.F, "em_sgrp_role_new_button");
        Yh(this.C, "em_sgrp_auditset_back");
    }

    private void Xh() {
        if (TextUtils.isEmpty(this.f232537a0)) {
            return;
        }
        VideoReport.addToDetectionWhitelist(getActivity());
        VideoReport.setPageId(this.N, "pg_sgrp_role_edit");
        ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).setGuildPageParams(this.N, this.f232537a0, null);
    }

    private void Yh(View view, String str) {
        VideoReport.setElementId(view, str);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
    }

    private void Zh() {
        if (this.f232539c0 == 6) {
            this.E.setText(R.string.f158201oz);
        } else {
            this.E.setText(R.string.f15010143);
        }
    }

    private void ai() {
        this.T.setVisibility(4);
        this.f232540d0 = new QQProgressDialog(getActivity());
        this.P.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.rolegroup.fragments.roledetail.ab
            @Override // java.lang.Runnable
            public final void run() {
                GuildMemberOrVisitorRoleFragment.this.Rh();
            }
        }, 700L);
    }

    private void bi(RoleGroupModel roleGroupModel) {
        this.U.setImageTintList(ColorStateList.valueOf(roleGroupModel.getColor()));
        this.V.setText(ch.t(roleGroupModel.getColor()));
        ci();
    }

    private void ci() {
        RoleGroupModel g26 = this.f232542f0.g2();
        if (g26 == null) {
            return;
        }
        ChannelPermission channelPermission = g26.getChannelPermission();
        boolean f16 = GuildDebugUtils.f(this.f232537a0);
        List<String> value = this.f232542f0.w2().getValue();
        this.Y.setChannelInfo(channelPermission.b(), value, f16);
        this.Z.setChannelInfo(channelPermission.a(), value, f16);
    }

    private void initListener() {
        this.X.c(new a.InterfaceC7880a() { // from class: com.tencent.mobileqq.guild.rolegroup.fragments.roledetail.ac
            @Override // com.tencent.mobileqq.guild.rolegroup.adapters.previewavatar.a.InterfaceC7880a
            public final void a(View view, a.b bVar) {
                GuildMemberOrVisitorRoleFragment.this.Mh(view, bVar);
            }
        });
    }

    private void initView() {
        this.C.setOnClickListener(this);
        uh(ViewUtils.dpToPx(16.0f));
        Zh();
        this.T = (LinearLayout) this.P.findViewById(R.id.f783246r);
        this.U = (ImageView) this.P.findViewById(R.id.vtg);
        this.V = (TextView) this.P.findViewById(R.id.vti);
        this.W = (TextView) this.P.findViewById(R.id.f166220z23);
        this.X = (GuildRoleMemberPreviewView) this.P.findViewById(R.id.z2_);
        if (this.f232539c0 == 6) {
            this.P.findViewById(R.id.z27).setVisibility(8);
            this.P.findViewById(R.id.xa6).setVisibility(8);
            this.X.setVisibility(8);
        }
        this.Y = (GuildRoleGroupChannelPermissionView) this.P.findViewById(R.id.f11995789);
        this.Z = (GuildRoleGroupChannelPermissionView) this.P.findViewById(R.id.f87144tk);
        if (GuildDebugUtils.f(this.f232537a0)) {
            this.Z.setLeftText("\u53d1\u8a00\u6743\u9650");
            this.Y.setLeftText("\u67e5\u770b\u6743\u9650");
        }
        this.W.setOnClickListener(this);
        this.Y.setOnClickListener(this);
        this.Z.setOnClickListener(this);
    }

    private void initViewModel() {
        RoleGroupViewModel roleGroupViewModel = (RoleGroupViewModel) ef1.c.a(this, RoleGroupViewModel.class, new Function0() { // from class: com.tencent.mobileqq.guild.rolegroup.fragments.roledetail.x
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                RoleGroupViewModel Nh;
                Nh = GuildMemberOrVisitorRoleFragment.this.Nh();
                return Nh;
            }
        });
        this.f232542f0 = roleGroupViewModel;
        roleGroupViewModel.getPageState().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.guild.rolegroup.fragments.roledetail.y
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildMemberOrVisitorRoleFragment.this.Oh((Integer) obj);
            }
        });
        if (this.f232539c0 != 6) {
            this.f232542f0.k2().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.guild.rolegroup.fragments.roledetail.z
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    GuildMemberOrVisitorRoleFragment.this.Ph((List) obj);
                }
            });
        }
        this.f232542f0.w2().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.guild.rolegroup.fragments.roledetail.aa
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildMemberOrVisitorRoleFragment.this.Qh((List) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment, com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment
    public void doOnCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.doOnCreateView(layoutInflater, viewGroup, bundle);
        Vh();
        initView();
        initViewModel();
        Xh();
        Wh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f6b;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, @Nullable Intent intent) {
        super.onActivityResult(i3, i16, intent);
        this.f232542f0.a2();
        this.f232542f0.Z1();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (!QQGuildUIUtil.v()) {
            if (view == this.C) {
                onBackEvent();
            } else if (view == this.W) {
                tx1.b.f(getActivity(), this.f232537a0, this.f232538b0, this.f232542f0.g2().getMemberLimit());
            } else if (view == this.Y) {
                Th();
            } else if (view == this.Z) {
                Sh();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        super.onDestroyView();
        Jh();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        ChannelPermissionForRoleDialog channelPermissionForRoleDialog = this.f232541e0;
        if (channelPermissionForRoleDialog != null) {
            channelPermissionForRoleDialog.dismissAllowingStateLoss();
        }
    }
}
