package com.tencent.mobileqq.search.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.adapter.RecommendFriendAdapter;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.relation.widget.RecommendFriendContainerV2;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes18.dex */
public class RecommendFriendFragment extends QBaseFragment {
    private View C;
    private RecommendFriendContainerV2 D;
    private int E;
    private int F;
    private Function1<String, Unit> G;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a implements RecommendFriendAdapter.f {
        a() {
        }

        @Override // com.tencent.mobileqq.adapter.RecommendFriendAdapter.f
        public void a() {
            VideoReport.reportEvent("dt_clck", RecommendFriendFragment.this.D, null);
        }

        @Override // com.tencent.mobileqq.adapter.RecommendFriendAdapter.f
        public void onItemClick() {
            VideoReport.reportEvent("dt_clck", RecommendFriendFragment.this.D, null);
        }
    }

    public RecommendFriendFragment() {
        this.E = -1;
        this.G = null;
    }

    private String getTraceId() {
        RecommendFriendContainerV2 recommendFriendContainerV2 = this.D;
        if (recommendFriendContainerV2 == null) {
            return "";
        }
        return recommendFriendContainerV2.w();
    }

    private String qh() {
        RecommendFriendContainerV2 recommendFriendContainerV2 = this.D;
        if (recommendFriendContainerV2 == null) {
            return "";
        }
        return recommendFriendContainerV2.x();
    }

    private void rh() {
        int i3;
        if (this.E != 99) {
            return;
        }
        VideoReport.addToDetectionWhitelist(getQBaseActivity());
        VideoReport.setPageId(this.C, "pg_search_people_middle");
        VideoReport.setPageParams(this.C, "search_query", "");
        VideoReport.setPageParams(this.C, "trace_id", getTraceId());
        VideoReport.setPageParams(this.C, "trans_info", qh());
        int i16 = this.F;
        if (i16 == 86) {
            i3 = 2;
        } else if (i16 != 83 && i16 != 84) {
            i3 = 0;
        } else {
            i3 = 1;
        }
        VideoReport.setPageParams(this.C, WinkDaTongReportConstant.ElementParamKey.XSJ_USER_FROM, Integer.valueOf(i3));
        VideoReport.setElementId(this.D, "em_search_people_recommend");
        VideoReport.setElementClickPolicy(this.D, ClickPolicy.REPORT_NONE);
        VideoReport.setElementExposePolicy(this.D, ExposurePolicy.REPORT_ALL);
        this.D.setRecommendItemClickListener(new a());
        this.D.setOnHistorySearchItemClickCallback(this.G);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int i3;
        View inflate = layoutInflater.inflate(R.layout.hch, (ViewGroup) null);
        this.C = inflate;
        RecommendFriendContainerV2 recommendFriendContainerV2 = (RecommendFriendContainerV2) inflate.findViewById(R.id.f71253nn);
        this.D = recommendFriendContainerV2;
        recommendFriendContainerV2.f280663d = this.E;
        if (this.F == 86) {
            i3 = 67;
        } else {
            i3 = 63;
        }
        recommendFriendContainerV2.setAdapter(i3);
        this.D.D();
        this.D.setRecommendFriendPageId(36);
        rh();
        View view = this.C;
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        this.D.I();
        super.onDestroy();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        this.D.J();
        super.onPause();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.D.K();
    }

    public void sh(Function1<String, Unit> function1) {
        this.G = function1;
    }

    public RecommendFriendFragment(int i3, int i16) {
        this.G = null;
        this.E = i3;
        this.F = i16;
    }
}
