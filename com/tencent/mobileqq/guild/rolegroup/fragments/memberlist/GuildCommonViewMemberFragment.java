package com.tencent.mobileqq.guild.rolegroup.fragments.memberlist;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.RelativeLayout;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.guild.api.RoleGroupUserUIData;
import com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment;
import com.tencent.mobileqq.guild.performance.report.p;
import com.tencent.mobileqq.guild.rolegroup.fragments.memberlist.GuildCommonViewMemberFragment;
import com.tencent.mobileqq.guild.rolegroup.view.memberlist.GuildGridSearchSelectMemberView;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.security.SecurityTipHelperKt;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cy1.k;
import ef1.c;
import ey1.MemberData;
import ey1.d;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import jy1.a;
import kotlin.jvm.functions.Function0;
import xx1.b;

/* compiled from: P */
/* loaded from: classes14.dex */
public class GuildCommonViewMemberFragment extends QQGuildTitleBarFragment {
    private GuildGridSearchSelectMemberView T;
    private jy1.a U;
    private GuildRoleMemberParamData V;
    private String X;
    private d Y;
    private iy1.d Z;
    private boolean W = false;

    /* renamed from: a0, reason: collision with root package name */
    private final Set<String> f232499a0 = new HashSet();

    /* renamed from: b0, reason: collision with root package name */
    GuildGridSearchSelectMemberView.f f232500b0 = new b();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class a implements a.InterfaceC10621a {
        a() {
        }

        @Override // jy1.a.InterfaceC10621a
        public void a(ri1.a aVar) {
            GuildCommonViewMemberFragment.this.W = false;
            SecurityTipHelperKt.B(GuildCommonViewMemberFragment.this.getContext(), aVar.f431477a, aVar.f431478b, (IGProSecurityResult) aVar.f431479c, QQGuildUIUtil.r(R.string.f154591f8));
        }

        @Override // jy1.a.InterfaceC10621a
        public void onSuccess() {
            GuildCommonViewMemberFragment.showToast(QQGuildUIUtil.r(R.string.f154601f9), 2);
            GuildCommonViewMemberFragment.this.requireActivity().finish();
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class b implements GuildGridSearchSelectMemberView.f {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes14.dex */
        public class a implements a.InterfaceC10621a {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ RoleGroupUserUIData f232503a;

            a(RoleGroupUserUIData roleGroupUserUIData) {
                this.f232503a = roleGroupUserUIData;
            }

            @Override // jy1.a.InterfaceC10621a
            public void a(ri1.a aVar) {
                SecurityTipHelperKt.B(GuildCommonViewMemberFragment.this.getContext(), aVar.f431477a, aVar.f431478b, (IGProSecurityResult) aVar.f431479c, QQGuildUIUtil.r(R.string.f154651fd));
            }

            @Override // jy1.a.InterfaceC10621a
            public void onSuccess() {
                GuildCommonViewMemberFragment.this.T.J(this.f232503a);
                GuildCommonViewMemberFragment.this.U.g2().remove(this.f232503a);
            }
        }

        b() {
        }

        private void j(RoleGroupUserUIData roleGroupUserUIData) {
            GuildCommonViewMemberFragment.this.f232499a0.remove(roleGroupUserUIData.getMTinyId());
            GuildCommonViewMemberFragment.this.U.x2(roleGroupUserUIData);
        }

        private void k(RoleGroupUserUIData roleGroupUserUIData) {
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(roleGroupUserUIData.getMTinyId());
            GuildCommonViewMemberFragment.this.U.q2(new ArrayList<>(), arrayList, new a(roleGroupUserUIData));
        }

        @Override // com.tencent.mobileqq.guild.rolegroup.view.memberlist.GuildGridSearchSelectMemberView.f
        public void a(RoleGroupUserUIData roleGroupUserUIData) {
            String[] strArr = {roleGroupUserUIData.getMTinyId()};
            Intent intent = new Intent();
            intent.putExtra(IQQGuildRouterApi.SELECT_MEMBER_LIST, strArr);
            intent.putExtra(IQQGuildRouterApi.SELECT_MEMBER_NAME_LIST, new String[]{roleGroupUserUIData.getMName()});
            GuildCommonViewMemberFragment.this.getActivity().setResult(-1, intent);
            GuildCommonViewMemberFragment.this.getActivity().finish();
        }

        @Override // com.tencent.mobileqq.guild.rolegroup.view.memberlist.GuildGridSearchSelectMemberView.f
        public void b() {
            k.b(GuildCommonViewMemberFragment.this.requireActivity(), GuildCommonViewMemberFragment.this.V, GuildCommonViewMemberFragment.this.U, GuildCommonViewMemberFragment.this.f232499a0, GuildCommonViewMemberFragment.this.T.v());
        }

        @Override // com.tencent.mobileqq.guild.rolegroup.view.memberlist.GuildGridSearchSelectMemberView.f
        public void c() {
            if (!GuildCommonViewMemberFragment.this.U.l2() && !GuildCommonViewMemberFragment.this.U.m2()) {
                GuildCommonViewMemberFragment.this.U.o2();
            }
        }

        @Override // com.tencent.mobileqq.guild.rolegroup.view.memberlist.GuildGridSearchSelectMemberView.f
        public void d(String str) {
            GuildCommonViewMemberFragment.this.U.z2(str);
        }

        @Override // com.tencent.mobileqq.guild.rolegroup.view.memberlist.GuildGridSearchSelectMemberView.f
        public void e() {
            ((InputMethodManager) GuildCommonViewMemberFragment.this.requireActivity().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).hideSoftInputFromWindow(GuildCommonViewMemberFragment.this.requireActivity().getWindow().getDecorView().getWindowToken(), 0);
        }

        @Override // com.tencent.mobileqq.guild.rolegroup.view.memberlist.GuildGridSearchSelectMemberView.f
        public void f() {
            if (!GuildCommonViewMemberFragment.this.U.l2() && !GuildCommonViewMemberFragment.this.U.m2()) {
                GuildCommonViewMemberFragment.this.U.p2();
            }
        }

        @Override // com.tencent.mobileqq.guild.rolegroup.view.memberlist.GuildGridSearchSelectMemberView.f
        public void g() {
            GuildCommonViewMemberFragment.this.U.X1();
            GuildCommonViewMemberFragment.this.T.setRecyclerViewItemData(GuildCommonViewMemberFragment.this.V.getGuildId(), GuildCommonViewMemberFragment.this.U.g2());
            GuildCommonViewMemberFragment.this.T.N(true);
        }

        @Override // com.tencent.mobileqq.guild.rolegroup.view.memberlist.GuildGridSearchSelectMemberView.f
        public void h() {
            GuildCommonViewMemberFragment.this.ri();
        }

        @Override // com.tencent.mobileqq.guild.rolegroup.view.memberlist.GuildGridSearchSelectMemberView.f
        public void i(RoleGroupUserUIData roleGroupUserUIData) {
            if (GuildCommonViewMemberFragment.this.V.getLayoutType() == 2) {
                k(roleGroupUserUIData);
            } else if (GuildCommonViewMemberFragment.this.V.getLayoutType() == 5) {
                j(roleGroupUserUIData);
            }
        }
    }

    private void Th(ArrayList<String> arrayList) {
        if (this.W) {
            return;
        }
        this.U.q2(arrayList, new ArrayList<>(), new a());
        this.W = true;
    }

    private void Uh() {
        this.T.s();
    }

    private List<b.C11573b> Vh(RoleGroupUserUIData[] roleGroupUserUIDataArr) {
        ArrayList arrayList = new ArrayList();
        for (RoleGroupUserUIData roleGroupUserUIData : roleGroupUserUIDataArr) {
            b.C11573b c11573b = new b.C11573b(0);
            c11573b.f448974c = roleGroupUserUIData.getMName();
            c11573b.f448973b = roleGroupUserUIData.getMTinyId();
            arrayList.add(c11573b);
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v4, types: [com.tencent.mobileqq.guild.api.RoleGroupUserUIData[], java.io.Serializable] */
    /* JADX WARN: Type inference failed for: r1v9, types: [com.tencent.mobileqq.guild.api.RoleGroupUserUIData[], java.io.Serializable] */
    private Intent Wh() {
        Intent intent = new Intent();
        Set<String> w3 = this.T.w();
        if (this.V.getLayoutType() == 5) {
            w3 = this.f232499a0;
        }
        if (!w3.isEmpty()) {
            String[] strArr = (String[]) w3.toArray(new String[0]);
            ?? r16 = (RoleGroupUserUIData[]) this.U.i2(w3).toArray(new RoleGroupUserUIData[0]);
            intent.putExtra("selected_id_array", strArr);
            intent.putExtra("selected_ui_array", (Serializable) r16);
            if (QLog.isColorLevel()) {
                QLog.i("Guild.rg.GuildRoleGroupMemberFragment", 2, " getResultIntent selectedIdArray:" + Arrays.toString(strArr) + " selectedUIArrayLength:" + r16.length);
            }
        } else {
            intent.putExtra("selected_id_array", new String[0]);
            intent.putExtra("selected_ui_array", (Serializable) new RoleGroupUserUIData[0]);
            if (QLog.isColorLevel()) {
                QLog.i("Guild.rg.GuildRoleGroupMemberFragment", 2, " getResultIntent Nothing Selected! ");
            }
        }
        return intent;
    }

    private boolean Xh() {
        if (this.f232499a0.size() != this.T.w().size()) {
            return true;
        }
        return !this.f232499a0.containsAll(this.T.w());
    }

    private void Yh() {
        this.U.h2().observe(getViewLifecycleOwner(), new Observer() { // from class: cy1.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildCommonViewMemberFragment.this.Zh((Boolean) obj);
            }
        });
        this.U.j2().observe(getViewLifecycleOwner(), new Observer() { // from class: cy1.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildCommonViewMemberFragment.this.ai((ArrayList) obj);
            }
        });
        this.U.k2().observe(getViewLifecycleOwner(), new Observer() { // from class: cy1.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildCommonViewMemberFragment.this.bi((ArrayList) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Zh(Boolean bool) {
        if (bool.equals(Boolean.TRUE)) {
            this.U.X1();
            this.U.W1();
            this.T.q();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ai(ArrayList arrayList) {
        if (this.T.E()) {
            return;
        }
        if (arrayList == null) {
            this.T.setRecyclerViewItemData(this.V.getGuildId(), new ArrayList());
        } else {
            this.T.setRecyclerViewItemData(this.V.getGuildId(), arrayList);
        }
        this.T.N(true);
        Uh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void bi(ArrayList arrayList) {
        if (!this.T.E()) {
            return;
        }
        if (arrayList == null) {
            this.T.setRecyclerViewItemData(this.V.getGuildId(), new ArrayList());
        } else {
            this.T.setRecyclerViewItemData(this.V.getGuildId(), arrayList);
        }
        this.T.N(false);
        Uh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ci(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        onBackEvent();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void di(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (this.V.getLayoutType() == 0) {
            requireActivity().setResult(-1, Wh());
            requireActivity().finish();
        } else if (this.V.getLayoutType() == 1) {
            ji();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ei(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        onBackEvent();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ jy1.a fi() {
        return new jy1.a(this.V);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void gi(ArrayList arrayList, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Th(arrayList);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void hi(ArrayList arrayList, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Th(arrayList);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void ii(int i3, String str) {
        QQToast.makeText(BaseApplication.getContext(), i3, str, 0).show();
    }

    private void initTitleBar() {
        if (!TextUtils.isEmpty(this.V.getSubTitleStr())) {
            super.zh(this.V.getMainTitleStr(), this.V.getSubTitleStr());
        } else {
            setTitle(this.V.getMainTitleStr());
        }
        if (this.V.getLayoutType() != 0 && this.V.getLayoutType() != 1) {
            if (this.V.getLayoutType() == 2 || this.V.getLayoutType() == 3 || this.V.getLayoutType() == 5 || this.V.getLayoutType() == 8 || this.V.getLayoutType() == 6) {
                this.D.setText("");
                this.C.setOnClickListener(new View.OnClickListener() { // from class: cy1.d
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        GuildCommonViewMemberFragment.this.ei(view);
                    }
                });
                this.F.setText("");
            }
        } else {
            setLeftButton(R.string.f140850f3, new View.OnClickListener() { // from class: cy1.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GuildCommonViewMemberFragment.this.ci(view);
                }
            });
            this.X = getResources().getString(R.string.f155081gj);
            setRightButton(R.string.f155081gj, new View.OnClickListener() { // from class: cy1.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GuildCommonViewMemberFragment.this.di(view);
                }
            });
        }
        setRightButtonEnable(false);
    }

    private void initView() {
        if (this.V == null) {
            requireActivity().finish();
            return;
        }
        initTitleBar();
        this.U = (jy1.a) c.a(this, jy1.a.class, new Function0() { // from class: cy1.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                jy1.a fi5;
                fi5 = GuildCommonViewMemberFragment.this.fi();
                return fi5;
            }
        });
        GuildGridSearchSelectMemberView guildGridSearchSelectMemberView = (GuildGridSearchSelectMemberView) this.P;
        this.T = guildGridSearchSelectMemberView;
        guildGridSearchSelectMemberView.y(this.V, this.f232500b0);
        if (this.V.getLayoutType() == 0) {
            String[] strArr = (String[]) this.V.getSelectedIdList().toArray(new String[0]);
            RoleGroupUserUIData[] roleGroupUserUIDataArr = (RoleGroupUserUIData[]) this.V.getSelectedUIList().toArray(new RoleGroupUserUIData[0]);
            if (roleGroupUserUIDataArr.length > 0) {
                this.U.Q1(new ArrayList<>(Arrays.asList(roleGroupUserUIDataArr)));
                this.T.p(this.V.getGuildId(), Vh(roleGroupUserUIDataArr));
                this.T.L();
            }
            if (strArr.length > 0) {
                this.T.setSelectIdItems(strArr);
                this.f232499a0.addAll(Arrays.asList(strArr));
            }
            ri();
        } else if (this.V.getLayoutType() == 5) {
            RoleGroupUserUIData[] roleGroupUserUIDataArr2 = (RoleGroupUserUIData[]) this.V.getSelectedUIList().toArray(new RoleGroupUserUIData[0]);
            if (roleGroupUserUIDataArr2.length > 0) {
                this.U.Q1(new ArrayList<>(Arrays.asList(roleGroupUserUIDataArr2)));
                this.f232499a0.addAll(this.V.getSelectedIdList());
            }
            this.T.s();
        }
        Yh();
        this.U.w2();
    }

    private void ji() {
        final ArrayList<String> arrayList = new ArrayList<>(this.T.w());
        if (!TextUtils.equals("1", this.V.getRoleGroupId())) {
            Th(arrayList);
            return;
        }
        if (arrayList.size() == 1) {
            this.Z = iy1.d.X(requireContext(), arrayList.get(0), this.V.getGuildId(), new View.OnClickListener() { // from class: cy1.i
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GuildCommonViewMemberFragment.this.gi(arrayList, view);
                }
            });
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(new MemberData(it.next(), this.V.getGuildId(), 1));
        }
        this.Y = d.Y(requireContext(), new View.OnClickListener() { // from class: cy1.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildCommonViewMemberFragment.this.hi(arrayList, view);
            }
        }, arrayList2);
    }

    public static void ki(Activity activity, GuildRoleMemberParamData guildRoleMemberParamData) {
        li(activity, guildRoleMemberParamData, null, null);
    }

    public static void li(Activity activity, GuildRoleMemberParamData guildRoleMemberParamData, ts.a aVar, ActivityResultCallback<ActivityResult> activityResultCallback) {
        pi(guildRoleMemberParamData);
        QLog.i("Guild.rg.GuildRoleGroupMemberFragment", 1, "openRoleGroupSelectMember: " + guildRoleMemberParamData);
        if (!guildRoleMemberParamData.judgeParamIllegal()) {
            QLog.e("Guild.rg.GuildRoleGroupMemberFragment", 1, "openRoleGroupSelectMember But Param Not Illegal");
            QQToast.makeText(activity, 1, QQGuildUIUtil.r(R.string.f143560me), 0).show();
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("EXTRA_PARAM_DATA", guildRoleMemberParamData);
        if (aVar != null && activityResultCallback != null) {
            intent.setClass(activity, QPublicFragmentActivity.class);
            intent.putExtra("public_fragment_class", GuildCommonViewMemberFragment.class.getName());
            aVar.a(intent, activityResultCallback);
            return;
        }
        QPublicFragmentActivity.b.e(activity, intent, QPublicFragmentActivity.class, GuildCommonViewMemberFragment.class, guildRoleMemberParamData.getActivityRequestCode());
    }

    public static void mi(QBaseFragment qBaseFragment, GuildRoleMemberParamData guildRoleMemberParamData) {
        if (qBaseFragment == null) {
            QLog.i("Guild.rg.GuildRoleGroupMemberFragment", 1, "openRoleGroupSelectMember QBaseFragment context is null" + guildRoleMemberParamData);
            return;
        }
        pi(guildRoleMemberParamData);
        QLog.i("Guild.rg.GuildRoleGroupMemberFragment", 1, "openRoleGroupSelectMember: " + guildRoleMemberParamData);
        if (!guildRoleMemberParamData.judgeParamIllegal()) {
            QLog.e("Guild.rg.GuildRoleGroupMemberFragment", 1, "openRoleGroupSelectMember But Param Not Illegal");
            QQToast.makeText(qBaseFragment.getContext(), 1, QQGuildUIUtil.r(R.string.f143560me), 0).show();
        } else {
            Intent intent = new Intent();
            intent.putExtra("EXTRA_PARAM_DATA", guildRoleMemberParamData);
            QPublicFragmentActivity.b.g(qBaseFragment, intent, QPublicFragmentActivity.class, GuildCommonViewMemberFragment.class, guildRoleMemberParamData.getActivityRequestCode());
        }
    }

    private void ni() {
        oi(requireActivity());
    }

    private void oi(@NonNull Activity activity) {
        if (this.V != null) {
            return;
        }
        try {
            this.V = (GuildRoleMemberParamData) activity.getIntent().getSerializableExtra("EXTRA_PARAM_DATA");
        } catch (Exception unused) {
            QLog.e("Guild.rg.GuildRoleGroupMemberFragment", 1, "initData failed get GuildRoleMemberParamData");
            QQToast.makeText(BaseApplication.getContext(), 1, QQGuildUIUtil.r(R.string.f143560me), 1).show();
            activity.finish();
        }
    }

    private static void pi(GuildRoleMemberParamData guildRoleMemberParamData) {
        if (guildRoleMemberParamData.getFetchType() == 0) {
            return;
        }
        p.c();
    }

    private void qi(String str) {
        this.F.setVisibility(0);
        this.F.setText(str);
        this.F.setBackgroundResource(0);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.F.getLayoutParams();
        layoutParams.addRule(11);
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.rightMargin = QQGuildUIUtil.f(12.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ri() {
        if (Xh()) {
            setRightButtonEnable(true);
            qi(this.X + "(" + this.T.w().size() + ")");
            return;
        }
        setRightButtonEnable(false);
        qi(this.X);
    }

    public static void showToast(final String str, final int i3) {
        Runnable runnable = new Runnable() { // from class: cy1.h
            @Override // java.lang.Runnable
            public final void run() {
                GuildCommonViewMemberFragment.ii(i3, str);
            }
        };
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            ThreadManagerV2.getUIHandlerV2().post(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment, com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment
    public void doOnCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.doOnCreateView(layoutInflater, viewGroup, bundle);
        initView();
    }

    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    protected int getContentLayoutId() {
        return R.layout.f6p;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public void initWindowStyleAndAnimation(Activity activity) {
        super.initWindowStyleAndAnimation(activity);
        GuildRoleMemberParamData guildRoleMemberParamData = this.V;
        if (guildRoleMemberParamData == null) {
            oi(activity);
        } else if (guildRoleMemberParamData.getOpenPageSlideType() == 1) {
            activity.overridePendingTransition(R.anim.f154630p2, R.anim.f154442w);
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, @Nullable Intent intent) {
        super.onActivityResult(i3, i16, intent);
        if (this.T.E()) {
            this.T.t(true);
        }
        if (i3 == 2000) {
            if (i16 == -1 && intent != null) {
                String[] stringArrayExtra = intent.getStringArrayExtra("selected_id_array");
                RoleGroupUserUIData[] roleGroupUserUIDataArr = (RoleGroupUserUIData[]) intent.getSerializableExtra("selected_ui_array");
                if (stringArrayExtra != null && roleGroupUserUIDataArr != null) {
                    if (stringArrayExtra.length > 0) {
                        this.U.Z1();
                        this.U.Q1(new ArrayList<>(Arrays.asList(roleGroupUserUIDataArr)));
                        this.f232499a0.clear();
                        this.f232499a0.addAll(Arrays.asList(stringArrayExtra));
                        return;
                    }
                    this.U.Z1();
                    this.U.Q1(new ArrayList<>());
                    this.f232499a0.clear();
                    return;
                }
                return;
            }
            return;
        }
        this.U.U1();
        this.T.M();
        this.U.w2();
    }

    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        if (this.V.getLayoutType() == 5) {
            requireActivity().setResult(-1, Wh());
            requireActivity().finish();
        }
        return super.onBackEvent();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NonNull Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (QQGuildUIUtil.w()) {
            this.T.C();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        ni();
    }

    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.T.I();
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onFinish() {
        super.onFinish();
        FragmentActivity activity = getActivity();
        if (activity != null && this.V.getOpenPageSlideType() == 1) {
            activity.overridePendingTransition(0, R.anim.f154636p8);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        GuildGridSearchSelectMemberView guildGridSearchSelectMemberView = this.T;
        if (guildGridSearchSelectMemberView != null) {
            guildGridSearchSelectMemberView.r();
            this.f232500b0.e();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        d dVar = this.Y;
        if (dVar != null && dVar.isShowing()) {
            this.Y.dismiss();
        }
        iy1.d dVar2 = this.Z;
        if (dVar2 != null && dVar2.isShowing()) {
            this.Z.dismiss();
        }
    }
}
