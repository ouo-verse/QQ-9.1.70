package com.tencent.gdtad.views.wechat.kf.kuikly;

import an0.b;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.tencent.ad.tangram.protocol.link_report;
import com.tencent.ad.tangram.statistics.AdReporterForLinkEvent;
import com.tencent.ad.tangram.statistics.metric.AdMetricID;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.kuikly.a;
import com.tencent.gdtad.kuikly.fragment.GdtBaseKuiklyFragment;
import com.tencent.gdtad.kuikly.fragment.GdtKuiklyFragmentBroadcastReceiver;
import com.tencent.gdtad.kuikly.receiver.GdtBaseKuiklyBroadcastReceiver;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivityForTool;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class GdtWXCustomerServiceKuiklyFragment extends GdtBaseKuiklyFragment {
    private volatile GdtAd M;

    private void Ah(int i3, int i16) {
        link_report.LinkReport.ReportBiz reportBiz = new link_report.LinkReport.ReportBiz();
        if (i16 >= 0) {
            reportBiz.cost_time = i16;
        }
        AdReporterForLinkEvent.getInstance().reportAsync(getContext(), i3, this.M, reportBiz, null);
    }

    public static int Bh(b bVar) {
        if (bVar != null && bVar.isValid()) {
            Bundle bundle = new Bundle();
            if (bVar.j() != null && !bVar.j().isEmpty()) {
                bundle.putAll(bVar.j());
            }
            bundle.putParcelable("AD", bVar.b());
            return GdtBaseKuiklyFragment.zh(bVar, QPublicTransFragmentActivityForTool.class, GdtWXCustomerServiceKuiklyFragment.class, bundle, Integer.MIN_VALUE);
        }
        return 4;
    }

    @Override // com.tencent.gdtad.kuikly.fragment.GdtBaseKuiklyFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void beforeFinish() {
        QLog.i("GdtWXCustomerServiceKuiklyFragment", 1, "[beforeFinish]");
        Ah(4001071, (int) vh());
        super.beforeFinish();
    }

    @Override // com.tencent.gdtad.kuikly.fragment.GdtBaseKuiklyFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Bundle arguments = getArguments();
        View view = null;
        if (arguments == null) {
            a.f("GdtWXCustomerServiceKuiklyFragment", "[onCreateView] error, arguments is null", null, AdMetricID.Click.WXCustomerService.Kuikly.Fragment.ON_CREATE_VIEW_FAILED, null, null, null, 1);
            qh(1);
        } else if (!arguments.containsKey("AD")) {
            a.f("GdtWXCustomerServiceKuiklyFragment", "[onCreateView] error, arguments do not contains KEY_AD", null, AdMetricID.Click.WXCustomerService.Kuikly.Fragment.ON_CREATE_VIEW_FAILED, null, null, null, 1);
            qh(1);
        } else {
            this.M = (GdtAd) arguments.getParcelable("AD");
            if (this.M != null && this.M.isValid()) {
                view = super.onCreateView(layoutInflater, viewGroup, bundle);
            } else {
                a.f("GdtWXCustomerServiceKuiklyFragment", "[onCreateView] error, mAd is not valid", null, AdMetricID.Click.WXCustomerService.Kuikly.Fragment.ON_CREATE_VIEW_FAILED, null, null, null, 1);
                qh(1);
            }
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // com.tencent.gdtad.kuikly.fragment.GdtBaseKuiklyFragment, com.tencent.gdtad.kuikly.GdtKuiklyRenderViewDelegate.a
    public int onLoadSuccess() {
        int onLoadSuccess = super.onLoadSuccess();
        Ah(4001066, (int) vh());
        return onLoadSuccess;
    }

    @Override // com.tencent.gdtad.kuikly.fragment.GdtBaseKuiklyFragment
    protected GdtBaseKuiklyBroadcastReceiver ph(Handler handler) {
        return new GdtKuiklyFragmentBroadcastReceiver(new WeakReference(this), handler);
    }

    @Override // com.tencent.gdtad.kuikly.fragment.GdtBaseKuiklyFragment
    protected GdtAd uh() {
        return this.M;
    }

    @Override // com.tencent.gdtad.kuikly.fragment.GdtBaseKuiklyFragment
    protected com.tencent.gdtad.kuikly.fragment.a wh() {
        return an0.a.n();
    }

    @Override // com.tencent.gdtad.kuikly.fragment.GdtBaseKuiklyFragment
    protected void th(HashMap<String, Object> hashMap) {
    }
}
