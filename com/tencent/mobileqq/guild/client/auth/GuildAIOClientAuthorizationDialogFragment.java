package com.tencent.mobileqq.guild.client.auth;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.theme.GuildThemeManager;
import com.tencent.mobileqq.guild.util.bx;
import com.tencent.mobileqq.guild.widget.C11728RoundRectUrlImageView;
import com.tencent.mobileqq.util.x;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import mqq.app.AppActivity;

/* compiled from: P */
/* loaded from: classes12.dex */
public class GuildAIOClientAuthorizationDialogFragment extends GuildClientAuthorizationAbstractDialogFragment {
    private TextView H;
    private C11728RoundRectUrlImageView I;
    private TextView J;

    private void xh() {
        VideoReport.setElementId(this.C, "em_sgrp_aio_otherapp_authorization");
        VideoReport.setElementClickPolicy(this.C, ClickPolicy.REPORT_ALL);
        VideoReport.setElementExposePolicy(this.C, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementEndExposePolicy(this.C, EndExposurePolicy.REPORT_ALL);
        VideoReport.setElementParam(this.C, "sgrp_otherapp_id", this.G.R1());
    }

    public static void yh(AppActivity appActivity, @NonNull GuildClientAuthDialogParams guildClientAuthDialogParams) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("GuildClientAuthorizationParam", guildClientAuthDialogParams);
        GuildAIOClientAuthorizationDialogFragment guildAIOClientAuthorizationDialogFragment = new GuildAIOClientAuthorizationDialogFragment();
        guildAIOClientAuthorizationDialogFragment.setArguments(bundle);
        appActivity.getSupportFragmentManager().beginTransaction().add(guildAIOClientAuthorizationDialogFragment, "Guild.client.GuildAIOClientAuthorizationDialogFragment").commitAllowingStateLoss();
    }

    @Override // com.tencent.mobileqq.guild.client.auth.GuildClientAuthorizationAbstractDialogFragment
    protected View getContentView() {
        return LayoutInflater.from(getContext()).inflate(R.layout.ej_, (ViewGroup) null);
    }

    @Override // com.tencent.mobileqq.guild.client.auth.GuildClientAuthorizationAbstractDialogFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        this.E.setText(getActivity().getString(R.string.f142410ja));
        this.H = (TextView) onCreateView.findViewById(R.id.f166992jq2);
        C11728RoundRectUrlImageView c11728RoundRectUrlImageView = (C11728RoundRectUrlImageView) onCreateView.findViewById(R.id.image);
        this.I = c11728RoundRectUrlImageView;
        c11728RoundRectUrlImageView.setAllRadius(x.c(getContext(), 6.0f));
        int c16 = x.f(getContext()).f185860a - (x.c(getContext(), 16.0f) * 2);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.I.getLayoutParams();
        layoutParams.height = (int) ((c16 * 291.0f) / 792.0f);
        this.I.setLayoutParams(layoutParams);
        this.J = (TextView) onCreateView.findViewById(R.id.f164641tb4);
        if (GuildThemeManager.f235286a.b()) {
            this.I.setForeground(new ColorDrawable(Color.parseColor("#19000000")));
        } else {
            this.I.setForeground(null);
        }
        wh();
        bx.w(this.G.R1());
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, onCreateView);
        return onCreateView;
    }

    @Override // com.tencent.mobileqq.guild.client.auth.GuildClientAuthorizationAbstractDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        xh();
    }

    public void wh() {
        String e16 = this.G.S1().e();
        String f16 = this.G.S1().f();
        String j3 = this.G.S1().j();
        if (QLog.isColorLevel()) {
            QLog.d("Guild.client.GuildAIOClientAuthorizationDialogFragment", 2, "open GuildAIOClientAuthorizationDialogFragment guildId=" + this.G.getGuildId() + " clientId=" + this.G.R1() + " title=" + e16 + " imageUrl=" + j3);
        }
        this.H.setText(e16);
        this.J.setText(f16);
        if (!TextUtils.isEmpty(j3)) {
            this.I.setImageDrawable(URLDrawable.getDrawable(j3, URLDrawable.URLDrawableOptions.obtain()));
        }
    }
}
