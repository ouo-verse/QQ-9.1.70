package com.tencent.mobileqq.guild.rolegroup.fragments;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.guild.rolegroup.bindpermission.GuildOpenBindPermissionUtils;
import com.tencent.mobileqq.guild.rolegroup.levelrole.GuildLevelRoleViewAndSelectFragment;
import com.tencent.mobileqq.guild.rolegroup.levelrole.LevelRoleViewAndSelectParam;
import com.tencent.mobileqq.guild.rolegroup.levelrole.PageLayoutType;
import com.tencent.mobileqq.guild.rolegroup.model.data.GuildRoleGroupSelectModel;
import com.tencent.mobileqq.guild.rolegroup.model.data.RoleGroupModel;
import com.tencent.mobileqq.guild.rolegroup.model.repositories.s;
import com.tencent.mobileqq.guild.rolegroup.viewmodel.SelectRoleForChannelPermissionViewModel;
import com.tencent.mobileqq.guild.theme.GuildThemeManager;
import com.tencent.mobileqq.guild.util.bi;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.o;
import com.tencent.mobileqq.guild.util.security.SecurityTipHelperKt;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildRoleInfo;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.util.List;
import kotlin.jvm.functions.Function0;
import ux1.e;
import yx1.RoleSelectItem;

/* compiled from: P */
/* loaded from: classes14.dex */
public class GuildRoleGroupSelectDialog extends BottomSheetDialogFragment implements View.OnClickListener, e.a {
    private View C;
    private View D;
    private TextView E;
    private TextView F;
    private View G;
    private TextView H;
    private RecyclerView I;
    private ux1.e J;
    private String K;
    private String L;
    private int M;
    private boolean N;
    private SelectRoleForChannelPermissionViewModel P;
    private a Q;
    private int R;
    private GuildRoleGroupSelectModel S;

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public interface a {
        void a(List<RoleGroupModel> list, List<IGProGuildRoleInfo> list2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ SelectRoleForChannelPermissionViewModel Ah() {
        return new SelectRoleForChannelPermissionViewModel(this.K, this.L, this.M, xh(), yh(), s.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Bh(List list) {
        this.J.S0(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ch(Integer num) {
        Jh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Dh(Boolean bool) {
        a aVar;
        if (!bool.booleanValue()) {
            return;
        }
        QLog.d("Guild.rg.BindPermission.GuildRoleGroupSelectDialog", 1, "viewModel hasSubmitSelectedRole finishPage");
        dismissAllowingStateLoss();
        if (bool.booleanValue() && (aVar = this.Q) != null) {
            aVar.a(this.P.m2(), this.P.j2());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Eh(Integer num) {
        this.H.setText(String.format("\u5df2\u9009%s\u4e2a", num));
        Jh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Gh, reason: merged with bridge method [inline-methods] */
    public void Fh(cf1.b bVar) {
        if (bVar.f30775b != 0) {
            SecurityTipHelperKt.D(getContext(), bVar);
        } else {
            QQToast.makeText(getContext(), 2, bVar.f30774a, 1).show();
        }
    }

    public static GuildRoleGroupSelectDialog Hh(@NonNull FragmentManager fragmentManager, GuildRoleGroupSelectModel guildRoleGroupSelectModel) {
        GuildRoleGroupSelectDialog guildRoleGroupSelectDialog = new GuildRoleGroupSelectDialog();
        Bundle bundle = new Bundle();
        bundle.putParcelable("selectModel", guildRoleGroupSelectModel);
        guildRoleGroupSelectDialog.setArguments(bundle);
        guildRoleGroupSelectDialog.show(fragmentManager, "Guild.rg.BindPermission.GuildRoleGroupSelectDialog");
        return guildRoleGroupSelectDialog;
    }

    private void Ih() {
        if (!(getDialog() instanceof com.google.android.material.bottomsheet.a)) {
            return;
        }
        int c16 = (int) (bi.c() * 0.7d);
        ((com.google.android.material.bottomsheet.a) getDialog()).getBehavior().setPeekHeight(c16);
        if (this.D.getLayoutParams() == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.D.getLayoutParams();
        layoutParams.height = c16;
        this.D.setLayoutParams(layoutParams);
    }

    private void Jh() {
        int n26 = this.P.n2();
        if (n26 > 0) {
            this.F.setEnabled(true);
            this.F.setText(String.format("\u5b8c\u6210(%d)", Integer.valueOf(n26)));
        } else {
            this.F.setEnabled(false);
            this.F.setText(R.string.f143340lt);
        }
    }

    private void initData() {
        Bundle arguments = getArguments();
        if (arguments == null) {
            QLog.e("Guild.rg.BindPermission.GuildRoleGroupSelectDialog", 1, "arguments is null");
            dismissAllowingStateLoss();
            return;
        }
        this.S = (GuildRoleGroupSelectModel) arguments.getParcelable("selectModel");
        QLog.d("Guild.rg.BindPermission.GuildRoleGroupSelectDialog", 1, "initData " + this.S);
        this.R = this.S.e();
        this.K = this.S.f();
        this.L = this.S.b();
        this.N = this.S.j();
        this.Q = this.S.a();
        this.M = this.S.c();
        if (TextUtils.isEmpty(this.K)) {
            QLog.e("Guild.rg.BindPermission.GuildRoleGroupSelectDialog", 1, String.format("Invalid info-> mGuildId is %s,", this.K));
            dismissAllowingStateLoss();
        } else if (QLog.isColorLevel()) {
            QLog.i("Guild.rg.BindPermission.GuildRoleGroupSelectDialog", 2, String.format("initData info -> mGuild:%s, mChannelId:%s, mSubmitModify:%b", this.K, this.L, Boolean.valueOf(this.N)));
        }
    }

    private void initView() {
        String str;
        this.D = this.C.findViewById(R.id.w4c);
        this.E = (TextView) this.C.findViewById(R.id.x2y);
        this.F = (TextView) this.C.findViewById(R.id.f165642x34);
        this.G = this.C.findViewById(R.id.wlf);
        this.H = (TextView) this.C.findViewById(R.id.wlj);
        this.F.setEnabled(false);
        this.I = (RecyclerView) this.C.findViewById(R.id.wxb);
        this.J = new ux1.e(this, wh(), this.R);
        this.I.setNestedScrollingEnabled(false);
        this.I.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        if (GuildThemeManager.f235286a.b()) {
            str = "#FF151516";
        } else {
            str = "#FFDEDFD0";
        }
        this.I.addItemDecoration(new com.tencent.mobileqq.guild.widget.k(new ColorDrawable(Color.parseColor(str)), ViewUtils.dpToPx(16.0f), 0));
        this.I.setAdapter(this.J);
    }

    private void initViewModel() {
        SelectRoleForChannelPermissionViewModel selectRoleForChannelPermissionViewModel = (SelectRoleForChannelPermissionViewModel) ef1.c.a(this, SelectRoleForChannelPermissionViewModel.class, new Function0() { // from class: com.tencent.mobileqq.guild.rolegroup.fragments.c
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                SelectRoleForChannelPermissionViewModel Ah;
                Ah = GuildRoleGroupSelectDialog.this.Ah();
                return Ah;
            }
        });
        this.P = selectRoleForChannelPermissionViewModel;
        selectRoleForChannelPermissionViewModel.f2().observe(this, new Observer() { // from class: com.tencent.mobileqq.guild.rolegroup.fragments.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildRoleGroupSelectDialog.this.Bh((List) obj);
            }
        });
        this.P.g2().observe(this, new Observer() { // from class: com.tencent.mobileqq.guild.rolegroup.fragments.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildRoleGroupSelectDialog.this.Ch((Integer) obj);
            }
        });
        this.P.e2().observe(this, new Observer() { // from class: com.tencent.mobileqq.guild.rolegroup.fragments.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildRoleGroupSelectDialog.this.Dh((Boolean) obj);
            }
        });
        this.P.h2().observe(this, new Observer() { // from class: com.tencent.mobileqq.guild.rolegroup.fragments.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildRoleGroupSelectDialog.this.Eh((Integer) obj);
            }
        });
        this.P.getToastEvent().observe(this, new Observer() { // from class: com.tencent.mobileqq.guild.rolegroup.fragments.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildRoleGroupSelectDialog.this.Fh((cf1.b) obj);
            }
        });
        if (!this.S.g().isEmpty()) {
            this.P.q2(this.S.g());
        }
        this.P.o2();
    }

    private void onFinish() {
        if (this.N) {
            this.P.s2();
            return;
        }
        a aVar = this.Q;
        if (aVar != null) {
            aVar.a(this.P.m2(), this.P.j2());
        }
        QLog.d("Guild.rg.BindPermission.GuildRoleGroupSelectDialog", 1, "clickFinish IsCreateMode");
        dismissAllowingStateLoss();
    }

    private void vh() {
        this.E.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.rolegroup.fragments.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildRoleGroupSelectDialog.this.onClick(view);
            }
        });
        this.F.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.rolegroup.fragments.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildRoleGroupSelectDialog.this.onClick(view);
            }
        });
        this.G.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.rolegroup.fragments.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildRoleGroupSelectDialog.this.onClick(view);
            }
        });
    }

    private IGProChannelInfo wh() {
        return ((IGPSService) ch.l().getRuntimeService(IGPSService.class, "")).getChannelInfo(this.L);
    }

    private SelectRoleForChannelPermissionViewModel.PermissionType xh() {
        int i3 = this.R;
        if (i3 == 1) {
            return SelectRoleForChannelPermissionViewModel.PermissionType.ViewPermission;
        }
        if (i3 == 4) {
            return SelectRoleForChannelPermissionViewModel.PermissionType.SpeakUnlimitedPermission;
        }
        if (i3 == 3) {
            return SelectRoleForChannelPermissionViewModel.PermissionType.LiveAnchorPermission;
        }
        if (i3 == 5) {
            return SelectRoleForChannelPermissionViewModel.PermissionType.ActivityPermission;
        }
        if (i3 == 6) {
            return SelectRoleForChannelPermissionViewModel.PermissionType.ModifyMapPermission;
        }
        return SelectRoleForChannelPermissionViewModel.PermissionType.SpeakPermission;
    }

    private SelectRoleForChannelPermissionViewModel.SelectedType yh() {
        if (this.N) {
            return SelectRoleForChannelPermissionViewModel.SelectedType.RemoteSelected;
        }
        return SelectRoleForChannelPermissionViewModel.SelectedType.LocalSelected;
    }

    private void zh() {
        GuildLevelRoleViewAndSelectFragment.Rh(requireActivity(), new LevelRoleViewAndSelectParam(this.K, HardCodeUtil.qqStr(R.string.f154741fm), PageLayoutType.MANAGE_AND_ADD, this.L, GuildOpenBindPermissionUtils.a(this.R), !this.N, 0, this.P.l2(), this.P.k2()));
    }

    @Override // ux1.e.a
    public void m9(RoleSelectItem roleSelectItem, int i3, boolean z16, View view) {
        this.P.p2(roleSelectItem, z16);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        EventCollector.getInstance().onViewClickedBefore(view);
        if (!o.a(view)) {
            int id5 = view.getId();
            if (id5 == R.id.x2y) {
                onCancel();
                QLog.d("Guild.rg.BindPermission.GuildRoleGroupSelectDialog", 1, "onCancel finishPage");
                dismissAllowingStateLoss();
            } else if (id5 == R.id.f165642x34) {
                onFinish();
            } else if (id5 == R.id.wlf) {
                zh();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(@Nullable Bundle bundle) {
        com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) super.onCreateDialog(bundle);
        aVar.getWindow().getAttributes().windowAnimations = R.style.f174032aw0;
        return aVar;
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.C = layoutInflater.inflate(R.layout.f6o, viewGroup, true);
        initData();
        initView();
        vh();
        initViewModel();
        Ih();
        View view = this.C;
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.Fragment
    public void onResume() {
        boolean z16;
        super.onResume();
        List<String> Oh = GuildLevelRoleViewAndSelectFragment.Oh();
        if (QLog.isDebugVersion()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("onResume selectedLvRolesIsNull:");
            if (Oh == null) {
                z16 = true;
            } else {
                z16 = false;
            }
            sb5.append(z16);
            QLog.d("Guild.rg.BindPermission.GuildRoleGroupSelectDialog", 4, sb5.toString());
        }
        if (Oh == null) {
            return;
        }
        GuildLevelRoleViewAndSelectFragment.Th(null);
        this.P.r2(Oh);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        ((View) this.C.getParent()).setBackgroundColor(0);
    }

    private void onCancel() {
    }

    @Override // ux1.e.a
    public void Yf(View view) {
    }
}
