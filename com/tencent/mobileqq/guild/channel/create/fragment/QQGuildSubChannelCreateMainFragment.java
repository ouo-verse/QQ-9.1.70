package com.tencent.mobileqq.guild.channel.create.fragment;

import android.animation.ValueAnimator;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.channel.create.CreateSubChannelInfo;
import com.tencent.mobileqq.guild.channel.create.dialog.BaseDialogFragment;
import com.tencent.mobileqq.guild.channel.create.dialog.QQGuildAppPreviewDialogFragment;
import com.tencent.mobileqq.guild.channel.create.dialog.QQGuildSubChannelCreateDialogFragment;
import com.tencent.mobileqq.guild.channel.create.fragment.QQGuildSubChannelCreateMainFragment;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.mvvm.h;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProAppInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import nf1.d;

/* compiled from: P */
/* loaded from: classes12.dex */
public class QQGuildSubChannelCreateMainFragment extends BaseCreateSubChannelFragment implements View.OnClickListener, qf1.a, qf1.b {
    private ViewGroup F;
    private TextView G;
    private RelativeLayout H;
    private View I;
    private FrameLayout J;
    private RecyclerView K;
    private d L;
    private rf1.b M;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a implements Observer<List<of1.b>> {
        a() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(List<of1.b> list) {
            QQGuildSubChannelCreateMainFragment.this.L.setData(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class b extends RecyclerView.ItemDecoration {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NonNull Rect rect, @NonNull View view, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
            super.getItemOffsets(rect, view, recyclerView, state);
            rect.left = ScreenUtil.dip2px(-11.0f);
            rect.right = ScreenUtil.dip2px(-11.0f);
            rect.top = ScreenUtil.dip2px(-10.7f);
            rect.bottom = ScreenUtil.dip2px(-10.7f);
        }
    }

    private void Ah() {
        QQGuildSubChannelCreateDialogFragment Eh = QQGuildSubChannelCreateDialogFragment.Eh(this.D);
        Eh.Dh(this.E);
        Eh.show(getActivity().getSupportFragmentManager(), "QQGuildSubChannelCreateDialogFragment");
        this.E.D = Boolean.FALSE;
        th();
        this.E.yh();
    }

    private void initView() {
        this.F = (ViewGroup) this.C.findViewById(R.id.xfq);
        this.G = (TextView) this.C.findViewById(R.id.jq_);
        this.K = (RecyclerView) this.C.findViewById(R.id.f901651q);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        gridLayoutManager.setOrientation(1);
        this.K.setLayoutManager(gridLayoutManager);
        d dVar = new d(getContext(), new qf1.b() { // from class: pf1.i
            @Override // qf1.b
            public final void H3(of1.b bVar) {
                QQGuildSubChannelCreateMainFragment.this.H3(bVar);
            }
        });
        this.L = dVar;
        this.K.setAdapter(dVar);
        this.K.addItemDecoration(new b());
        this.H = (RelativeLayout) this.C.findViewById(R.id.xet);
        this.I = this.C.findViewById(R.id.f164814ty2);
        this.J = (FrameLayout) this.C.findViewById(R.id.zqq);
        this.I.setOnClickListener(this);
    }

    private Bundle sh(@Nullable IGProAppInfo iGProAppInfo) {
        Bundle bundle = new Bundle();
        bundle.putLong("appId", iGProAppInfo.getAppId());
        bundle.putString("iconUrl", iGProAppInfo.getIconUrl());
        bundle.putString("appName", iGProAppInfo.getAppName());
        bundle.putString("appDescription", iGProAppInfo.getAppDescription());
        bundle.putStringArrayList("previewUrls", new ArrayList<>(iGProAppInfo.getPreViewList()));
        return bundle;
    }

    private void th() {
        ViewGroup.LayoutParams layoutParams = this.F.getLayoutParams();
        layoutParams.height = this.F.getMeasuredHeight();
        this.F.setLayoutParams(layoutParams);
    }

    private int uh() {
        int measuredHeight = this.F.getMeasuredHeight();
        List<IGProAppInfo> value = this.M.M1().getValue();
        if (value != null && value.size() != 0) {
            int dip2px = ViewUtils.dip2px(69.0f) + ViewUtils.dip2px(63.0f) + (ViewUtils.dip2px(199.0f) * ((value.size() + 1) / 2));
            return Math.max(Math.min(measuredHeight, dip2px), ViewUtils.dip2px(336.0f));
        }
        return measuredHeight;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void vh(ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        ViewGroup.LayoutParams layoutParams = this.H.getLayoutParams();
        layoutParams.height = intValue;
        this.H.setLayoutParams(layoutParams);
    }

    public static QQGuildSubChannelCreateMainFragment wh(CreateSubChannelInfo createSubChannelInfo) {
        QQGuildSubChannelCreateMainFragment qQGuildSubChannelCreateMainFragment = new QQGuildSubChannelCreateMainFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("extra_key_subchannel_info", createSubChannelInfo);
        qQGuildSubChannelCreateMainFragment.setArguments(bundle);
        return qQGuildSubChannelCreateMainFragment;
    }

    private void xh() {
        CreateSubChannelInfo createSubChannelInfo = this.D;
        if (createSubChannelInfo == null) {
            return;
        }
        this.M.P1(getAppInterface(), createSubChannelInfo.f214821d);
    }

    private void yh() {
        int i3;
        VideoReport.addToDetectionWhitelist(getQBaseActivity());
        VideoReport.setPageId(this.F, "pg_sgrp_select_channel");
        VideoReport.setPageContentId(this.F, "QQGuildSubChannelCreateMainFragment");
        HashMap hashMap = new HashMap();
        if (this.D.f214823f == "main_setting") {
            i3 = 1;
        } else {
            i3 = 2;
        }
        hashMap.put("sgrp_pg_create_source", Integer.valueOf(i3));
        ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).setGuildPageParams(this.F, this.D.f214821d, hashMap);
    }

    private void zh() {
        this.G.setVisibility(8);
        ValueAnimator ofInt = ValueAnimator.ofInt(this.H.getMeasuredHeight(), uh());
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: pf1.j
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                QQGuildSubChannelCreateMainFragment.this.vh(valueAnimator);
            }
        });
        ofInt.setDuration(300L);
        ofInt.start();
        this.K.setVisibility(8);
        this.J.setVisibility(0);
        th();
        QQGuildAppChannelListFragment rh5 = QQGuildAppChannelListFragment.rh(this.D);
        getChildFragmentManager().beginTransaction().replace(R.id.zqq, rh5).commit();
        rh5.th(this);
        rh5.ph(this.E);
    }

    @Override // qf1.b
    public void H3(of1.b bVar) {
        this.D.b(bVar.f422594b);
        if (bVar.f422594b == 6) {
            zh();
        } else {
            Ah();
        }
    }

    @Override // qf1.a
    public void Ha(@Nullable IGProAppInfo iGProAppInfo) {
        this.D.a(sh(iGProAppInfo));
        QQGuildSubChannelCreateDialogFragment Eh = QQGuildSubChannelCreateDialogFragment.Eh(this.D);
        Eh.Dh(this.E);
        Eh.show(getActivity().getSupportFragmentManager(), "QQGuildAppSubChannelCreateDialogFragment");
        BaseDialogFragment baseDialogFragment = this.E;
        baseDialogFragment.D = Boolean.FALSE;
        baseDialogFragment.yh();
    }

    @Override // qf1.a
    public void Sg(@Nullable IGProAppInfo iGProAppInfo) {
        this.D.a(sh(iGProAppInfo));
        QQGuildAppPreviewDialogFragment Eh = QQGuildAppPreviewDialogFragment.Eh(this.D);
        Eh.Dh(this.E);
        Eh.show(getActivity().getSupportFragmentManager(), "QQGuildAppPreviewDialogFragment");
        BaseDialogFragment baseDialogFragment = this.E;
        baseDialogFragment.D = Boolean.FALSE;
        baseDialogFragment.yh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.channel.create.fragment.BaseCreateSubChannelFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f9g;
    }

    @Override // com.tencent.mobileqq.guild.channel.create.fragment.BaseCreateSubChannelFragment
    protected void init() {
        initView();
        yh();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        BaseDialogFragment baseDialogFragment;
        EventCollector.getInstance().onViewClickedBefore(view);
        if (!QQGuildUIUtil.v() && view.getId() == R.id.f164814ty2 && (baseDialogFragment = this.E) != null) {
            baseDialogFragment.dismiss();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.guild.channel.create.fragment.BaseCreateSubChannelFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        rf1.b bVar = (rf1.b) h.a(getActivity()).get(rf1.b.class);
        this.M = bVar;
        bVar.init(getArguments());
        this.M.N1().observe(this, new a());
        xh();
    }
}
