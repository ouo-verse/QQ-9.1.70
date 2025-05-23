package com.tencent.mobileqq.guild.rolegroup.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.rolegroup.fragments.ChannelPermissionEditFragment;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 82\u00020\u00012\u00020\u0002:\u00019B'\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\u0006\u0010\u001a\u001a\u00020\u0015\u0012\u0006\u0010 \u001a\u00020\u001b\u00a2\u0006\u0004\b6\u00107J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J&\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\u000f\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u0010\u001a\u00020\u0003H\u0016R\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001a\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0017R\u0017\u0010 \u001a\u00020\u001b8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0016\u0010#\u001a\u00020\f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010-\u001a\u00020\f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b,\u0010\"R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b3\u00104\u00a8\u0006:"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/fragments/ChannelPermissionForRoleDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "Landroid/view/View$OnClickListener;", "", "initView", "initData", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "view", NodeProps.ON_CLICK, "onResume", "Lcom/tencent/mobileqq/guild/rolegroup/fragments/ChannelPermissionTypeForRole;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/rolegroup/fragments/ChannelPermissionTypeForRole;", "type", "", "D", "Ljava/lang/String;", "guildId", "E", "roleId", "Lcom/tencent/mobileqq/guild/rolegroup/fragments/Source;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/guild/rolegroup/fragments/Source;", "getSource", "()Lcom/tencent/mobileqq/guild/rolegroup/fragments/Source;", "source", "G", "Landroid/view/View;", "mRootView", "Landroid/widget/TextView;", "H", "Landroid/widget/TextView;", "mTitleView", "Landroidx/recyclerview/widget/RecyclerView;", "I", "Landroidx/recyclerview/widget/RecyclerView;", "mRecyclerView", "J", "mModifyButton", "Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/a;", "K", "Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/a;", "mViewModel", "Lux1/c;", "L", "Lux1/c;", "mAdapter", "<init>", "(Lcom/tencent/mobileqq/guild/rolegroup/fragments/ChannelPermissionTypeForRole;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/guild/rolegroup/fragments/Source;)V", "M", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class ChannelPermissionForRoleDialog extends BottomSheetDialogFragment implements View.OnClickListener {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final ChannelPermissionTypeForRole type;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final String guildId;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final String roleId;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Source source;

    /* renamed from: G, reason: from kotlin metadata */
    private View mRootView;

    /* renamed from: H, reason: from kotlin metadata */
    private TextView mTitleView;

    /* renamed from: I, reason: from kotlin metadata */
    private RecyclerView mRecyclerView;

    /* renamed from: J, reason: from kotlin metadata */
    private View mModifyButton;

    /* renamed from: K, reason: from kotlin metadata */
    private com.tencent.mobileqq.guild.rolegroup.viewmodel.a mViewModel;

    /* renamed from: L, reason: from kotlin metadata */
    private ux1.c mAdapter;

    @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0006\b\u0000\u0010\u0000\u0018\u00012\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "kotlin.jvm.PlatformType", "it", "", "onChanged", "(Ljava/lang/Object;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b<T> implements Observer {
        public b() {
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(T t16) {
            List<com.tencent.mobileqq.guild.channel.manage.b> it = (List) t16;
            ux1.c cVar = ChannelPermissionForRoleDialog.this.mAdapter;
            if (cVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
                cVar = null;
            }
            Intrinsics.checkNotNullExpressionValue(it, "it");
            cVar.setData(it);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0006\b\u0000\u0010\u0000\u0018\u00012\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "kotlin.jvm.PlatformType", "it", "", "onChanged", "(Ljava/lang/Object;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c<T> implements Observer {
        public c() {
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(T t16) {
            List<com.tencent.mobileqq.guild.channel.manage.b> it = (List) t16;
            ux1.c cVar = ChannelPermissionForRoleDialog.this.mAdapter;
            if (cVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
                cVar = null;
            }
            Intrinsics.checkNotNullExpressionValue(it, "it");
            cVar.setData(it);
        }
    }

    public ChannelPermissionForRoleDialog(@NotNull ChannelPermissionTypeForRole type, @NotNull String guildId, @NotNull String roleId, @NotNull Source source) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(roleId, "roleId");
        Intrinsics.checkNotNullParameter(source, "source");
        this.type = type;
        this.guildId = guildId;
        this.roleId = roleId;
        this.source = source;
    }

    private final void initData() {
        this.mViewModel = (com.tencent.mobileqq.guild.rolegroup.viewmodel.a) ef1.c.INSTANCE.c(this, com.tencent.mobileqq.guild.rolegroup.viewmodel.a.class, new Function0<com.tencent.mobileqq.guild.rolegroup.viewmodel.a>() { // from class: com.tencent.mobileqq.guild.rolegroup.fragments.ChannelPermissionForRoleDialog$initData$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final com.tencent.mobileqq.guild.rolegroup.viewmodel.a invoke() {
                String str;
                String str2;
                str = ChannelPermissionForRoleDialog.this.guildId;
                str2 = ChannelPermissionForRoleDialog.this.roleId;
                return new com.tencent.mobileqq.guild.rolegroup.viewmodel.a(str, str2);
            }
        });
        this.mAdapter = new ux1.c();
        RecyclerView recyclerView = this.mRecyclerView;
        com.tencent.mobileqq.guild.rolegroup.viewmodel.a aVar = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            recyclerView = null;
        }
        ux1.c cVar = this.mAdapter;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
            cVar = null;
        }
        recyclerView.setAdapter(cVar);
        ChannelPermissionTypeForRole channelPermissionTypeForRole = this.type;
        if (channelPermissionTypeForRole == ChannelPermissionTypeForRole.ApproveSpeak) {
            com.tencent.mobileqq.guild.rolegroup.viewmodel.a aVar2 = this.mViewModel;
            if (aVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
                aVar2 = null;
            }
            aVar2.S1().observe(this, new b());
        } else if (channelPermissionTypeForRole == ChannelPermissionTypeForRole.ApproveVisible) {
            com.tencent.mobileqq.guild.rolegroup.viewmodel.a aVar3 = this.mViewModel;
            if (aVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
                aVar3 = null;
            }
            aVar3.T1().observe(this, new c());
        }
        com.tencent.mobileqq.guild.rolegroup.viewmodel.a aVar4 = this.mViewModel;
        if (aVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
        } else {
            aVar = aVar4;
        }
        aVar.initData();
    }

    private final void initView() {
        String r16;
        View view = this.mRootView;
        RecyclerView recyclerView = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view = null;
        }
        View findViewById = view.findViewById(R.id.bkg);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mRootView.findViewById(R.id.dialog_title)");
        this.mTitleView = (TextView) findViewById;
        View view2 = this.mRootView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view2 = null;
        }
        View findViewById2 = view2.findViewById(R.id.ts5);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mRootView.findViewById(R.id.channel_list)");
        this.mRecyclerView = (RecyclerView) findViewById2;
        View view3 = this.mRootView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view3 = null;
        }
        View findViewById3 = view3.findViewById(R.id.zd6);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "mRootView.findViewById(R.id.modify_button)");
        this.mModifyButton = findViewById3;
        Source source = this.source;
        if (source != Source.CreatePage && source != Source.NormalMember && source != Source.VisitorMember) {
            if (findViewById3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mModifyButton");
                findViewById3 = null;
            }
            findViewById3.setVisibility(0);
            View view4 = this.mModifyButton;
            if (view4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mModifyButton");
                view4 = null;
            }
            view4.setOnClickListener(this);
        } else {
            if (findViewById3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mModifyButton");
                findViewById3 = null;
            }
            findViewById3.setVisibility(8);
        }
        TextView textView = this.mTitleView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleView");
            textView = null;
        }
        if (this.type == ChannelPermissionTypeForRole.ApproveVisible) {
            r16 = QQGuildUIUtil.r(R.string.f146460u9);
        } else {
            r16 = QQGuildUIUtil.r(R.string.f146380u1);
        }
        textView.setText(r16);
        RecyclerView recyclerView2 = this.mRecyclerView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
        } else {
            recyclerView = recyclerView2;
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        View view2 = this.mModifyButton;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mModifyButton");
            view2 = null;
        }
        if (Intrinsics.areEqual(view, view2)) {
            dismissAllowingStateLoss();
            ChannelPermissionEditFragment.Companion companion = ChannelPermissionEditFragment.INSTANCE;
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
            companion.b(requireContext, this.type, this.guildId, this.roleId, 101);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.eii, container);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou\u2026ission_dialog, container)");
        this.mRootView = inflate;
        initView();
        initData();
        View view = this.mRootView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view = null;
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        View view = this.mRootView;
        com.tencent.mobileqq.guild.rolegroup.viewmodel.a aVar = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view = null;
        }
        ViewParent parent = view.getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) parent).setBackgroundColor(0);
        com.tencent.mobileqq.guild.rolegroup.viewmodel.a aVar2 = this.mViewModel;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
        } else {
            aVar = aVar2;
        }
        aVar.Q1();
    }
}
