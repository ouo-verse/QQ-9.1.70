package com.tencent.mobileqq.guild.channel.choose;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.widget.OverScrollRecyclerView;
import com.tencent.mobileqq.mvvm.h;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.HashMap;
import java.util.List;
import mf1.b;

/* compiled from: P */
/* loaded from: classes12.dex */
public class QQGuildSelectChannelDialogFragment extends BottomSheetDialogFragment implements View.OnClickListener {
    private View C;
    private OverScrollRecyclerView D;
    private kf1.a E;
    private b F;
    private String G;
    private Activity H;
    private vy1.a I;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a implements Observer<List<lf1.a>> {
        a() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(List<lf1.a> list) {
            QQGuildSelectChannelDialogFragment.this.sh(list);
        }
    }

    public QQGuildSelectChannelDialogFragment(String str) {
        this.G = str;
    }

    private void initData() {
        if (this.H == null) {
            return;
        }
        this.F = (b) h.b(this, b.D).get(b.class);
        if (!TextUtils.isEmpty(this.G)) {
            this.F.Q1(this.G);
        }
        kf1.a aVar = new kf1.a();
        this.E = aVar;
        aVar.m0(this);
        this.D.setAdapter(this.E);
        this.D.setLayoutManager(new LinearLayoutManager(this.H));
        DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator();
        defaultItemAnimator.setSupportsChangeAnimations(false);
        this.D.setItemAnimator(defaultItemAnimator);
        this.E.setData(this.F.O1(this.G));
    }

    private void initView() {
        if (getActivity() != null) {
            this.H = getActivity();
        }
        OverScrollRecyclerView overScrollRecyclerView = (OverScrollRecyclerView) this.C.findViewById(R.id.xfj);
        this.D = overScrollRecyclerView;
        overScrollRecyclerView.H();
    }

    private void qh(View view, String str) {
        if (view == null) {
            return;
        }
        VideoReport.setElementId(view, str);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
    }

    private void rh() {
        this.F.P1().observe(getViewLifecycleOwner(), new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sh(List<lf1.a> list) {
        if (list != null && list.size() > 0) {
            this.E.setData(list);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        IGProChannelInfo iGProChannelInfo;
        EventCollector.getInstance().onViewClickedBefore(view);
        lf1.a aVar = (lf1.a) view.getTag();
        if (aVar != null && (iGProChannelInfo = aVar.f414445c) != null) {
            this.I.a(iGProChannelInfo);
            qh(view, "em_qqrobot_sub_channel_select");
            HashMap hashMap = new HashMap();
            hashMap.put("qq_robot_sub_channel_id", aVar.f414445c.getChannelUin());
            hashMap.put("qq_robot_sub_channel_name", aVar.f414445c.getChannelName());
            VideoReport.setElementParams(view, hashMap);
            dismiss();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.C = layoutInflater.inflate(R.layout.f168180f82, viewGroup, false);
        initView();
        initData();
        rh();
        View view = this.C;
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ((ViewGroup) this.C.getParent()).setBackgroundColor(0);
        com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) getDialog();
        if (aVar == null) {
            return;
        }
        int instantScreenHeight = ScreenUtil.getInstantScreenHeight(this.H);
        aVar.getBehavior().setPeekHeight((int) (instantScreenHeight * 0.6f));
        Window window = aVar.getWindow();
        if (window == null) {
            return;
        }
        window.setLayout(-1, instantScreenHeight - ImmersiveUtils.getStatusBarHeight(this.H));
        window.setGravity(80);
    }

    public void th(vy1.a aVar) {
        this.I = aVar;
    }
}
