package com.tencent.mobileqq.guild.client.auth;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;

/* compiled from: P */
/* loaded from: classes12.dex */
public class GuildClientAuthorizationDialogFragment extends GuildClientAuthorizationAbstractDialogFragment {
    private void wh() {
        VideoReport.setElementId(this.C, xh());
        VideoReport.setElementClickPolicy(this.C, ClickPolicy.REPORT_ALL);
        VideoReport.setElementExposePolicy(this.C, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementEndExposePolicy(this.C, EndExposurePolicy.REPORT_ALL);
        VideoReport.setElementParam(this.C, "sgrp_otherapp_id", this.G.R1());
    }

    private String xh() {
        if (this.G.Q1() != 4 && this.G.Q1() != 5) {
            if (this.G.Q1() == 1) {
                return "em_sgrp_otherapp_role_selection_panel";
            }
            if (this.G.Q1() == 3) {
                return "em_sgrp_channel_otherapp_role_selection_panel";
            }
            return "";
        }
        return "em_sgrp_aio_otherapp_role_selection_panel";
    }

    private void yh() {
        String e16 = this.G.S1().e();
        String f16 = this.G.S1().f();
        if (QLog.isColorLevel()) {
            QLog.d("Guild.client.GuildClientAuthorizationDialogFragment", 2, String.format("open GuildClientAuthorizationDialogFragment agreement:%s, tips:%s", e16, f16));
        }
        ((TextView) this.F.findViewById(R.id.sf_)).setText(e16);
        ((TextView) this.F.findViewById(R.id.jmp)).setText(f16);
    }

    public static void zh(QBaseActivity qBaseActivity, Fragment fragment, @NonNull GuildClientAuthDialogParams guildClientAuthDialogParams) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("GuildClientAuthorizationParam", guildClientAuthDialogParams);
        GuildClientAuthorizationDialogFragment guildClientAuthorizationDialogFragment = new GuildClientAuthorizationDialogFragment();
        guildClientAuthorizationDialogFragment.setArguments(bundle);
        if (fragment != null) {
            guildClientAuthorizationDialogFragment.setTargetFragment(fragment, 1);
        }
        qBaseActivity.getSupportFragmentManager().beginTransaction().add(guildClientAuthorizationDialogFragment, "Guild.client.GuildClientAuthorizationDialogFragment").commitAllowingStateLoss();
    }

    @Override // com.tencent.mobileqq.guild.client.auth.GuildClientAuthorizationAbstractDialogFragment
    protected View getContentView() {
        return LayoutInflater.from(getContext()).inflate(R.layout.ejb, (ViewGroup) null);
    }

    @Override // com.tencent.mobileqq.guild.client.auth.GuildClientAuthorizationAbstractDialogFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        yh();
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, onCreateView);
        return onCreateView;
    }

    @Override // com.tencent.mobileqq.guild.client.auth.GuildClientAuthorizationAbstractDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        wh();
    }
}
