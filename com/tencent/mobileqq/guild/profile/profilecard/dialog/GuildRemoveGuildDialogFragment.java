package com.tencent.mobileqq.guild.profile.profilecard.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.api.impl.GuildDTReportApiImpl;
import com.tencent.mobileqq.guild.main.viewmodel.base.BaseChannelViewModel;
import com.tencent.mobileqq.guild.profile.profilecard.dialog.GuildRemoveGuildDialogFragment;
import com.tencent.mobileqq.guild.profile.profilecard.dialog.remove.GuildRemoveGuildDialogViewModel;
import com.tencent.mobileqq.guild.profile.profilecard.dialog.remove.RemoveFromGuildData;
import com.tencent.mobileqq.guild.rolegroup.viewmodel.GuildSecondaryAuthorityViewModel;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.util.HashMap;
import java.util.List;
import lv1.b;
import zv1.e;
import zv1.i;
import zv1.j;

/* compiled from: P */
/* loaded from: classes14.dex */
public class GuildRemoveGuildDialogFragment extends BottomSheetDialogFragment {
    private View C;
    private j D;
    private b E;
    private GuildSecondaryAuthorityViewModel F;
    private GuildRemoveGuildDialogViewModel G;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class a implements ActionSheet.OnDismissListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ b f231397d;

        a(b bVar) {
            this.f231397d = bVar;
        }

        @Override // com.tencent.widget.ActionSheet.OnDismissListener
        public void onDismiss() {
            this.f231397d.onDismiss();
        }
    }

    private void initData() {
        if (getArguments() == null) {
            QLog.e("Guild.profile.GuildRemoveGuildDialogFragment", 1, "onCreate error: bundle is null");
            dismiss();
        } else {
            initViewModel();
        }
    }

    private void initViewModel() {
        GuildRemoveGuildDialogViewModel guildRemoveGuildDialogViewModel = (GuildRemoveGuildDialogViewModel) BaseChannelViewModel.sViewModelFactory.create(GuildRemoveGuildDialogViewModel.class);
        this.G = guildRemoveGuildDialogViewModel;
        guildRemoveGuildDialogViewModel.init(getArguments());
        GuildSecondaryAuthorityViewModel guildSecondaryAuthorityViewModel = (GuildSecondaryAuthorityViewModel) BaseChannelViewModel.sViewModelFactory.create(GuildSecondaryAuthorityViewModel.class);
        this.F = guildSecondaryAuthorityViewModel;
        guildSecondaryAuthorityViewModel.init(this.G.mData.getGuildId(), "GuildRemoveGuildDialogFragment");
    }

    private j qh() {
        i iVar = new i();
        iVar.d(this);
        return iVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void rh(b bVar, RemoveFromGuildData removeFromGuildData, ActionSheet actionSheet, View view, int i3) {
        if (i3 == 0) {
            new GuildDTReportApiImpl().setElementExposureAndClickParams(view, "em_sgrp_remove_channel", null);
            bVar.a(removeFromGuildData.getMoveToBlack(), 0);
            actionSheet.dismiss();
        }
    }

    private static void th(Activity activity, View view, RemoveFromGuildData removeFromGuildData) {
        VideoReport.addToDetectionWhitelist(activity);
        VideoReport.setPageId(view, "pg_sgrp_block_member");
        VideoReport.setPageContentId(view, "GuildRemoveGuildDialogFragment");
        HashMap hashMap = new HashMap();
        int i3 = 1;
        hashMap.put("sgrp_duration_flag", 1);
        if (removeFromGuildData.getRemoveScene() == 0) {
            hashMap.put("sgrp_touin", removeFromGuildData.getUinReportStr());
        } else if (removeFromGuildData.getRemoveScene() == 1) {
            if (removeFromGuildData.getCount() != 1) {
                i3 = 2;
            }
            hashMap.put("sgrp_popup_type", Integer.valueOf(i3));
        }
        ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).setGuildPageParams(view, removeFromGuildData.getGuildId(), hashMap);
    }

    public static void vh(FragmentActivity fragmentActivity, String str, List<String> list, boolean z16, boolean z17, boolean z18, b bVar) {
        if (list != null && !list.isEmpty()) {
            RemoveFromGuildData removeFromGuildData = new RemoveFromGuildData(0, str, z16, z17, list.size(), e.b(list), z18);
            QLog.d("Guild.profile.GuildRemoveGuildDialogFragment", 1, "show data=", removeFromGuildData);
            xh(fragmentActivity, bVar, removeFromGuildData);
            return;
        }
        QLog.e("Guild.profile.GuildRemoveGuildDialogFragment", 1, "uinList is empty!");
    }

    public static void wh(FragmentActivity fragmentActivity, String str, int i3, boolean z16, b bVar) {
        QLog.i("Guild.profile.GuildRemoveGuildDialogFragment", 1, "showInRisk");
        if (i3 == 0) {
            QLog.e("Guild.profile.GuildRemoveGuildDialogFragment", 1, "uinList is empty!");
        } else {
            xh(fragmentActivity, bVar, new RemoveFromGuildData(1, str, true, false, i3, "", z16));
        }
    }

    private static void xh(FragmentActivity fragmentActivity, b bVar, RemoveFromGuildData removeFromGuildData) {
        if (!e.a(removeFromGuildData.getGuildId())) {
            yh(fragmentActivity, removeFromGuildData, bVar);
            return;
        }
        GuildRemoveGuildDialogFragment guildRemoveGuildDialogFragment = new GuildRemoveGuildDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("KEY_REMOVE_FROM_GUILD_DATA", removeFromGuildData);
        guildRemoveGuildDialogFragment.setArguments(bundle);
        guildRemoveGuildDialogFragment.show(fragmentActivity.getSupportFragmentManager(), "Guild.profile.GuildRemoveGuildDialogFragment");
        guildRemoveGuildDialogFragment.uh(bVar);
    }

    private static void yh(FragmentActivity fragmentActivity, final RemoveFromGuildData removeFromGuildData, final b bVar) {
        final ActionSheet actionSheet = (ActionSheet) ActionSheetHelper.createDialog(fragmentActivity, null);
        actionSheet.addButton(R.string.f143520ma, 3);
        actionSheet.setMainTitle(removeFromGuildData.getTitle());
        actionSheet.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: yv1.g
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public final void onClick(View view, int i3) {
                GuildRemoveGuildDialogFragment.rh(lv1.b.this, removeFromGuildData, actionSheet, view, i3);
            }
        });
        actionSheet.addCancelButton(R.string.f140850f3);
        actionSheet.setOnDismissListener(new a(bVar));
        actionSheet.show();
        th(fragmentActivity, actionSheet.getRootView(), removeFromGuildData);
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) super.onCreateDialog(bundle);
        aVar.getWindow().getAttributes().windowAnimations = R.style.a0o;
        aVar.getBehavior().setState(3);
        aVar.getBehavior().setSkipCollapsed(true);
        return aVar;
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        initData();
        j qh5 = qh();
        this.D = qh5;
        this.C = qh5.a(layoutInflater, viewGroup);
        this.D.c(this.F, this.G);
        th(getActivity(), this.C, this.G.mData);
        View view = this.C;
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(@NonNull DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        QLog.i("Guild.profile.GuildRemoveGuildDialogFragment", 1, "onDismiss");
        this.E.onDismiss();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        ((View) this.C.getParent()).setBackgroundColor(0);
    }

    public void sh() {
        if (this.E != null) {
            boolean moveToBlack = this.G.mData.getMoveToBlack();
            int msgRevokeType = this.G.getMsgRevokeType();
            this.D.b(moveToBlack, msgRevokeType);
            this.E.a(moveToBlack, msgRevokeType);
        }
        dismiss();
    }

    public void uh(b bVar) {
        this.E = bVar;
    }
}
