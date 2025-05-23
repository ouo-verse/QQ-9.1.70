package com.tencent.mobileqq.guild.profile.profilecard.guildowneroperation;

import android.app.Dialog;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.profile.profilecard.guildowneroperation.a;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.bi;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.RoundImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes14.dex */
public class GuildOwnerOperationTipCard extends BottomSheetDialogFragment implements View.OnClickListener {
    private View C;
    private FrameLayout D;
    private TextView E;
    private TextView F;
    private RoundImageView G;
    private LinearLayout H;
    private final String I;
    private final a.C7866a J;

    public GuildOwnerOperationTipCard(String str, int i3) {
        if (QLog.isColorLevel()) {
            QLog.i("Guild.profile.GuildOwnerOperationTipCard", 2, "openCard, guildId: " + str + " openType: " + i3);
        }
        this.I = str;
        this.J = a.a().b(i3);
    }

    private void initView() {
        this.D = (FrameLayout) this.C.findViewById(R.id.wfx);
        this.E = (TextView) this.C.findViewById(R.id.x3p);
        this.F = (TextView) this.C.findViewById(R.id.x3o);
        this.G = (RoundImageView) this.C.findViewById(R.id.wk7);
        LinearLayout linearLayout = (LinearLayout) this.C.findViewById(R.id.woj);
        this.H = linearLayout;
        linearLayout.setOnClickListener(this);
    }

    private void ph() {
        this.E.setText(this.J.f231436a);
        this.F.setText(this.J.f231437b);
        this.G.setImageDrawable(ch.J(this.J.f231438c, QQGuildUIUtil.f(360.0f), new BitmapDrawable(QQGuildUIUtil.j(false)), false));
        int d16 = bi.d() - QQGuildUIUtil.f(68.0f);
        this.G.getLayoutParams().width = d16;
        ViewGroup.LayoutParams layoutParams = this.G.getLayoutParams();
        a.C7866a c7866a = this.J;
        layoutParams.height = (d16 * c7866a.f231439d) / c7866a.f231440e;
        this.G.requestLayout();
    }

    private void qh() {
        VideoReport.setElementId(this.H, this.J.f231443h);
        VideoReport.setElementExposePolicy(this.H, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(this.H, ClickPolicy.REPORT_ALL);
        VideoReport.reportEvent("clck", this.H, new HashMap());
    }

    private void rh() {
        VideoReport.setElementId(this.D, this.J.f231442g);
        VideoReport.setElementExposePolicy(this.D, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(this.D, ClickPolicy.REPORT_ALL);
        VideoReport.reportEvent("imp", this.D, new HashMap());
    }

    private void sh() {
        VideoReport.setElementId(this.D, this.J.f231442g);
        VideoReport.setElementExposePolicy(this.D, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(this.D, ClickPolicy.REPORT_ALL);
        VideoReport.reportEvent("imp_end", this.D, new HashMap());
    }

    private void th() {
        VideoReport.addToDetectionWhitelist(getActivity());
        VideoReport.setPageId(this.C, this.J.f231441f);
        ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).setGuildPageParams(this.C, this.I, new HashMap());
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.fragment.app.DialogFragment
    public void dismiss() {
        super.dismiss();
        if (this.J == null) {
            return;
        }
        sh();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.woj) {
            qh();
            dismiss();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) super.onCreateDialog(bundle);
        aVar.getWindow().getAttributes().windowAnimations = R.style.f174032aw0;
        return aVar;
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View view;
        this.C = layoutInflater.inflate(R.layout.f1s, viewGroup, true);
        if (this.J == null) {
            dismiss();
            view = this.C;
        } else {
            initView();
            ph();
            view = this.C;
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        th();
        rh();
        ((ViewGroup) this.C.getParent()).setBackgroundColor(0);
    }
}
