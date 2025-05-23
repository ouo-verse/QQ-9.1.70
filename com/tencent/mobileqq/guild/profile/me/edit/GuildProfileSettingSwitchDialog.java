package com.tencent.mobileqq.guild.profile.me.edit;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.profile.profilecard.switches.GuildProfileVisibilitySwitchesComponent;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J$\u0010\f\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\r\u001a\u00020\u0004H\u0016J\b\u0010\u000e\u001a\u00020\u0004H\u0016J\b\u0010\u000f\u001a\u00020\u0004H\u0016R\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/guild/profile/me/edit/GuildProfileSettingSwitchDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "Landroid/view/View;", "view", "", "ph", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreateView", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "onDestroyView", "Lcom/tencent/mobileqq/guild/profile/profilecard/switches/GuildProfileVisibilitySwitchesComponent;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/profile/profilecard/switches/GuildProfileVisibilitySwitchesComponent;", "guildProfileVisibilitySwitchesComponent", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildProfileSettingSwitchDialog extends BottomSheetDialogFragment {

    /* renamed from: C, reason: from kotlin metadata */
    private GuildProfileVisibilitySwitchesComponent guildProfileVisibilitySwitchesComponent;

    private final void ph(View view) {
        VideoReport.addToDetectionWhitelist(getActivity());
        VideoReport.setPageId(view, "pg_sgrp_mine_edit");
        HashMap hashMap = new HashMap();
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, "0S200MNJT807V3GE");
        com.tencent.mobileqq.guild.data.w.a(hashMap);
        VideoReport.setPageParams(view, new PageParams(hashMap));
    }

    @Override // androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View view = inflater.inflate(R.layout.f2v, container, false);
        Intrinsics.checkNotNullExpressionValue(view, "view");
        ph(view);
        GuildProfileVisibilitySwitchesComponent guildProfileVisibilitySwitchesComponent = new GuildProfileVisibilitySwitchesComponent();
        this.guildProfileVisibilitySwitchesComponent = guildProfileVisibilitySwitchesComponent;
        guildProfileVisibilitySwitchesComponent.onCreate(this, ch.l(), savedInstanceState);
        ViewGroup viewGroup = (ViewGroup) view;
        GuildProfileVisibilitySwitchesComponent guildProfileVisibilitySwitchesComponent2 = this.guildProfileVisibilitySwitchesComponent;
        if (guildProfileVisibilitySwitchesComponent2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildProfileVisibilitySwitchesComponent");
            guildProfileVisibilitySwitchesComponent2 = null;
        }
        viewGroup.addView(guildProfileVisibilitySwitchesComponent2.m193getContainerView());
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        GuildProfileVisibilitySwitchesComponent guildProfileVisibilitySwitchesComponent = this.guildProfileVisibilitySwitchesComponent;
        if (guildProfileVisibilitySwitchesComponent == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildProfileVisibilitySwitchesComponent");
            guildProfileVisibilitySwitchesComponent = null;
        }
        guildProfileVisibilitySwitchesComponent.onDestroy();
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        GuildProfileVisibilitySwitchesComponent guildProfileVisibilitySwitchesComponent = this.guildProfileVisibilitySwitchesComponent;
        if (guildProfileVisibilitySwitchesComponent == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildProfileVisibilitySwitchesComponent");
            guildProfileVisibilitySwitchesComponent = null;
        }
        guildProfileVisibilitySwitchesComponent.onPause();
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.Fragment
    public void onResume() {
        ViewParent viewParent;
        ViewGroup viewGroup;
        super.onResume();
        View view = getView();
        GuildProfileVisibilitySwitchesComponent guildProfileVisibilitySwitchesComponent = null;
        if (view != null) {
            viewParent = view.getParent();
        } else {
            viewParent = null;
        }
        if (viewParent instanceof ViewGroup) {
            viewGroup = (ViewGroup) viewParent;
        } else {
            viewGroup = null;
        }
        if (viewGroup != null) {
            viewGroup.setBackground(null);
        }
        GuildProfileVisibilitySwitchesComponent guildProfileVisibilitySwitchesComponent2 = this.guildProfileVisibilitySwitchesComponent;
        if (guildProfileVisibilitySwitchesComponent2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildProfileVisibilitySwitchesComponent");
            guildProfileVisibilitySwitchesComponent2 = null;
        }
        guildProfileVisibilitySwitchesComponent2.onResume();
        GuildProfileVisibilitySwitchesComponent guildProfileVisibilitySwitchesComponent3 = this.guildProfileVisibilitySwitchesComponent;
        if (guildProfileVisibilitySwitchesComponent3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildProfileVisibilitySwitchesComponent");
            guildProfileVisibilitySwitchesComponent3 = null;
        }
        guildProfileVisibilitySwitchesComponent3.onPause();
        GuildProfileVisibilitySwitchesComponent guildProfileVisibilitySwitchesComponent4 = this.guildProfileVisibilitySwitchesComponent;
        if (guildProfileVisibilitySwitchesComponent4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildProfileVisibilitySwitchesComponent");
        } else {
            guildProfileVisibilitySwitchesComponent = guildProfileVisibilitySwitchesComponent4;
        }
        guildProfileVisibilitySwitchesComponent.onDestroy();
    }
}
