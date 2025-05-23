package com.tencent.mobileqq.guild.rolegroup.fragments.roledetail;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment;
import com.tencent.mobileqq.guild.rolegroup.adapters.previewavatar.a;
import com.tencent.mobileqq.guild.rolegroup.fragments.memberlist.GuildCommonViewMemberFragment;
import com.tencent.mobileqq.guild.rolegroup.fragments.memberlist.GuildRoleMemberParamData;
import com.tencent.mobileqq.guild.rolegroup.view.previewavatar.GuildRoleMemberPreviewView;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildRoleInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.functions.Function0;
import ux1.g;

/* compiled from: P */
/* loaded from: classes14.dex */
public class GuildAdminRoleFragment extends QQGuildTitleBarFragment implements View.OnClickListener {
    private int T;
    private String U;
    private String V;
    private int W;
    private ImageView X;
    private TextView Y;
    private TextView Z;

    /* renamed from: a0, reason: collision with root package name */
    private RecyclerView f232505a0;

    /* renamed from: b0, reason: collision with root package name */
    private ux1.g f232506b0;

    /* renamed from: c0, reason: collision with root package name */
    private GuildRoleMemberPreviewView f232507c0;

    /* renamed from: d0, reason: collision with root package name */
    private String f232508d0;

    /* renamed from: e0, reason: collision with root package name */
    private String f232509e0;

    /* renamed from: f0, reason: collision with root package name */
    private String f232510f0;

    /* renamed from: g0, reason: collision with root package name */
    private TextView f232511g0;

    /* renamed from: h0, reason: collision with root package name */
    private TextView f232512h0;

    /* renamed from: j0, reason: collision with root package name */
    private IGProGuildRoleInfo f232514j0;

    /* renamed from: k0, reason: collision with root package name */
    private int f232515k0;

    /* renamed from: l0, reason: collision with root package name */
    private String f232516l0;

    /* renamed from: m0, reason: collision with root package name */
    private String f232517m0;

    /* renamed from: n0, reason: collision with root package name */
    private com.tencent.mobileqq.guild.rolegroup.viewmodel.h f232518n0;

    /* renamed from: i0, reason: collision with root package name */
    private Boolean f232513i0 = Boolean.FALSE;

    /* renamed from: o0, reason: collision with root package name */
    private final g.a f232519o0 = Kh();

    private g.a Kh() {
        return new g.a() { // from class: com.tencent.mobileqq.guild.rolegroup.fragments.roledetail.k
            @Override // ux1.g.a
            public final void a(int i3, String str, boolean z16, View view) {
                GuildAdminRoleFragment.this.Oh(i3, str, z16, view);
            }
        };
    }

    private int Lh() {
        return this.T;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Mh(List<a.b> list) {
        if (list != null && getActivity() != null && !getActivity().isFinishing() && !isDetached()) {
            boolean z16 = false;
            boolean z17 = true;
            if (this.f232513i0.booleanValue()) {
                GuildRoleMemberPreviewView guildRoleMemberPreviewView = this.f232507c0;
                if (list.size() > this.f232507c0.e() - 1) {
                    z16 = true;
                }
                guildRoleMemberPreviewView.setPreviewItemDataWithNickname(list, z16);
                return;
            }
            GuildRoleMemberPreviewView guildRoleMemberPreviewView2 = this.f232507c0;
            if (list.size() <= this.f232507c0.e()) {
                z17 = false;
            }
            guildRoleMemberPreviewView2.setPreviewItemDataWithNickname(list, z17, false);
        }
    }

    private void Nh(String str, int i3, int i16, int i17, int i18) {
        GuildCommonViewMemberFragment.ki(requireActivity(), new GuildRoleMemberParamData(this.U, str, i16, i18).setGuildCreatorId(this.f232510f0).setRoleGroupId(this.f232508d0).setMaxCountCanSelect(i3).setActivityRequestCode(i17));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Oh(int i3, String str, boolean z16, View view) {
        this.f232518n0.Z1(i3, z16);
        Wh(view, z16, i3, str, "em_sgrp_role_manage_type");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ph(String str, View view, a.b bVar) {
        if (this.f232513i0.booleanValue()) {
            if (bVar.f232295a == 0) {
                Nh(HardCodeUtil.qqStr(R.string.f154341ej), Lh() - this.f232514j0.getCount(), 1, 2002, 5);
            }
            if (bVar.f232295a == 1) {
                Nh(str, Lh(), 2, 2002, 2);
                return;
            }
            return;
        }
        if (bVar.f232295a == 1) {
            Nh(str, Lh(), 3, 2003, 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Qh(String str, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Nh(str, Lh(), 2, 2001, 2);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ com.tencent.mobileqq.guild.rolegroup.viewmodel.h Rh() {
        return new com.tencent.mobileqq.guild.rolegroup.viewmodel.h(this.U, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Sh(List list) {
        this.f232506b0.setData(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Th(int i3, String str, IGProGuildRoleInfo iGProGuildRoleInfo) {
        boolean z16 = true;
        if (i3 != 0) {
            QLog.e("Guild.rg.GuildRoleGroupAdminFragment", 1, "Fail to get mRoleInfo");
            return;
        }
        if (isDetached()) {
            return;
        }
        int count = iGProGuildRoleInfo.getCount();
        this.f232511g0.setText(String.format(HardCodeUtil.qqStr(R.string.f154691fh), Integer.valueOf(count)));
        this.f232514j0 = iGProGuildRoleInfo;
        this.T = iGProGuildRoleInfo.getMemberLimit();
        TextView textView = this.f232512h0;
        if (count <= 0) {
            z16 = false;
        }
        textView.setEnabled(z16);
    }

    public static void Uh(Context context, String str, int i3, String str2, String str3) {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString("extra_guild_id", str);
        intent.putExtra("extra_role_color", i3);
        intent.putExtra("extra_role_display_tag_name", str2);
        intent.putExtra("extra_role_name", str3);
        intent.putExtras(bundle);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        QPublicFragmentActivity.b.b(context, intent, QPublicFragmentActivity.class, GuildAdminRoleFragment.class);
    }

    private void Vh() {
        ((IGPSService) ch.S0(IGPSService.class, "")).fetchRole(this.U, this.f232508d0, false, 126, new vh2.ap() { // from class: com.tencent.mobileqq.guild.rolegroup.fragments.roledetail.h
            @Override // vh2.ap
            public final void a(int i3, String str, IGProGuildRoleInfo iGProGuildRoleInfo) {
                GuildAdminRoleFragment.this.Th(i3, str, iGProGuildRoleInfo);
            }
        });
    }

    private void Wh(View view, boolean z16, int i3, String str, String str2) {
        int i16;
        HashMap hashMap = new HashMap();
        if (z16) {
            i16 = 1;
        } else {
            i16 = 2;
        }
        hashMap.put("sgrp_switch_type", Integer.valueOf(i16));
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("sgrp_manage_type", str);
        } else {
            QLog.e("Guild.rg.GuildRoleGroupAdminFragment", 1, "invalid DT param for permissionName with id " + i3);
        }
        ch.Y0(view, str2, ClickPolicy.REPORT_NONE, ExposurePolicy.REPORT_NONE);
        VideoReport.reportEvent("clck", view, hashMap);
    }

    private void Xh() {
        if (getActivity() == null) {
            return;
        }
        Intent intent = getActivity().getIntent();
        if (intent == null) {
            QLog.e("Guild.rg.GuildRoleGroupAdminFragment", 1, "Bundle is null");
            return;
        }
        this.W = intent.getIntExtra("group_setting_page_open_type", 0);
        this.U = intent.getStringExtra("extra_guild_id");
        this.V = intent.getStringExtra("role_group_id");
        this.f232515k0 = intent.getIntExtra("extra_role_color", Color.parseColor("#FF6542"));
        this.f232516l0 = intent.getStringExtra("extra_role_display_tag_name");
        this.f232517m0 = intent.getStringExtra("extra_role_name");
        if (this.U == null) {
            QLog.e("Guild.rg.GuildRoleGroupAdminFragment", 1, "guildId is null");
            onBackEvent();
        }
    }

    private void Yh() {
        if (TextUtils.isEmpty(this.U)) {
            return;
        }
        int c16 = com.tencent.mobileqq.guild.data.v.c(this.U);
        HashMap hashMap = new HashMap();
        hashMap.put("sgrp_channel_id", this.U);
        hashMap.put("sgrp_user_type", Integer.valueOf(c16));
        VideoReport.addToDetectionWhitelist(getActivity());
        VideoReport.setPageId(this.N, "pg_sgrp_role_edit");
        ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).setGuildPageParams(this.N, this.U, hashMap);
    }

    private void initData() {
        this.f232508d0 = String.valueOf(2);
        IGPSService iGPSService = (IGPSService) ch.R0(IGPSService.class);
        this.f232509e0 = iGPSService.getSelfTinyId();
        IGProGuildInfo guildInfo = iGPSService.getGuildInfo(this.U);
        if (guildInfo != null) {
            String creatorId = guildInfo.getCreatorId();
            this.f232510f0 = creatorId;
            this.f232513i0 = Boolean.valueOf(creatorId.equals(this.f232509e0));
        }
    }

    private void initView() {
        final String str;
        String str2;
        this.C.setOnClickListener(this);
        uh(ViewUtils.dpToPx(16.0f));
        if (TextUtils.isEmpty(this.f232517m0)) {
            str = getString(R.string.f138850_o);
        } else {
            str = this.f232517m0;
        }
        this.E.setText(str);
        this.P.findViewById(R.id.zm5).setBackgroundColor(this.f232515k0);
        ImageView imageView = (ImageView) this.P.findViewById(R.id.vtg);
        this.X = imageView;
        imageView.setImageTintList(ColorStateList.valueOf(this.f232515k0));
        TextView textView = (TextView) this.P.findViewById(R.id.vti);
        this.Y = textView;
        textView.setText(ch.t(this.f232515k0));
        if (TextUtils.isEmpty(this.f232516l0)) {
            str2 = HardCodeUtil.qqStr(R.string.f154371em);
        } else {
            str2 = this.f232516l0;
        }
        TextView textView2 = (TextView) this.P.findViewById(R.id.f779045m);
        this.Z = textView2;
        textView2.setText(str2);
        this.f232511g0 = (TextView) this.P.findViewById(R.id.se9);
        GuildRoleMemberPreviewView guildRoleMemberPreviewView = (GuildRoleMemberPreviewView) this.P.findViewById(R.id.se7);
        this.f232507c0 = guildRoleMemberPreviewView;
        guildRoleMemberPreviewView.setTargetArrange(3, 5);
        this.f232507c0.c(new a.InterfaceC7880a() { // from class: com.tencent.mobileqq.guild.rolegroup.fragments.roledetail.i
            @Override // com.tencent.mobileqq.guild.rolegroup.adapters.previewavatar.a.InterfaceC7880a
            public final void a(View view, a.b bVar) {
                GuildAdminRoleFragment.this.Ph(str, view, bVar);
            }
        });
        TextView textView3 = (TextView) this.P.findViewById(R.id.se8);
        this.f232512h0 = textView3;
        textView3.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.rolegroup.fragments.roledetail.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildAdminRoleFragment.this.Qh(str, view);
            }
        });
        if (!this.f232513i0.booleanValue()) {
            this.f232512h0.setVisibility(8);
        }
        RecyclerView recyclerView = (RecyclerView) this.P.findViewById(R.id.f239007o);
        this.f232505a0 = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        this.f232505a0.addItemDecoration(new ux1.h(ViewUtils.dpToPx(1.0f)));
        ux1.g gVar = new ux1.g();
        this.f232506b0 = gVar;
        gVar.n0(this.f232519o0);
        this.f232505a0.setAdapter(this.f232506b0);
    }

    private void initViewModel() {
        com.tencent.mobileqq.guild.rolegroup.viewmodel.h hVar = (com.tencent.mobileqq.guild.rolegroup.viewmodel.h) ef1.c.a(this, com.tencent.mobileqq.guild.rolegroup.viewmodel.h.class, new Function0() { // from class: com.tencent.mobileqq.guild.rolegroup.fragments.roledetail.e
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                com.tencent.mobileqq.guild.rolegroup.viewmodel.h Rh;
                Rh = GuildAdminRoleFragment.this.Rh();
                return Rh;
            }
        });
        this.f232518n0 = hVar;
        hVar.U1().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.guild.rolegroup.fragments.roledetail.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildAdminRoleFragment.this.Sh((List) obj);
            }
        });
        this.f232518n0.T1().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.guild.rolegroup.fragments.roledetail.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildAdminRoleFragment.this.Mh((List) obj);
            }
        });
        this.f232518n0.S1(14, this.f232510f0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment, com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment
    public void doOnCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.doOnCreateView(layoutInflater, viewGroup, bundle);
        Xh();
        initData();
        initView();
        Vh();
        initViewModel();
        Yh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f69;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (!QQGuildUIUtil.v() && view == this.C) {
            onBackEvent();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Vh();
        this.f232518n0.S1(14, this.f232510f0);
    }
}
