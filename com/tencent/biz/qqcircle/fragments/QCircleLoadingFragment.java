package com.tencent.biz.qqcircle.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qcircleshadow.lib.QCirclePluginInitHelper;
import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import com.tencent.biz.qqcircle.widgets.QCircleProgressDialog;
import com.tencent.biz.qqcircle.wink.f;
import com.tencent.biz.richframework.part.ImmersivePartFragment;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.report.QCirclePublishQualityReporter;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QCircleLoadingFragment extends ImmersivePartFragment {
    private QCircleProgressDialog C;

    private void qh() {
        Long.valueOf(HostDataTransUtils.getAccount()).longValue();
        final Intent intent = getActivity().getIntent();
        if (intent != null) {
            final int intExtra = intent.getIntExtra(IProfileCardConst.KEY_FROM_TYPE, 0);
            final String traceId = QCirclePublishQualityReporter.getTraceId();
            if (QCirclePluginInitHelper.isPeakAlive(getContext())) {
                f.f93951a.a(getActivity(), intent.getExtras(), intExtra, traceId, null);
            } else {
                QCirclePluginInitHelper.preloadPeakProcess(getContext());
                QLog.d("[QcirclePublish]QCircleLoadingFragment", 1, "onActivityCreated... preloadPeakProcess");
                RFWThreadManager.getInstance().getWinkHandler().postDelayed(new Runnable() { // from class: com.tencent.biz.qqcircle.fragments.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        QCircleLoadingFragment.this.rh(intent, intExtra, traceId);
                    }
                }, uq3.c.B3());
            }
            intent.putExtra("key_scheme", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void rh(Intent intent, int i3, String str) {
        f.f93951a.a(getActivity(), intent.getExtras(), i3, str, null);
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        return new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return 0;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment
    /* renamed from: getLogTag */
    public String getTAG() {
        return "[QcirclePublish]QCircleLoadingFragment";
    }

    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    protected int getStatusBarColor() {
        return 0;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        QLog.d("[QcirclePublish]QCircleLoadingFragment", 1, "onCreateView...");
        View inflate = layoutInflater.inflate(R.layout.g3y, viewGroup, false);
        QCircleProgressDialog qCircleProgressDialog = new QCircleProgressDialog(getActivity());
        this.C = qCircleProgressDialog;
        qCircleProgressDialog.show();
        qh();
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStop() {
        QLog.d("[QcirclePublish]QCircleLoadingFragment", 1, "onStop...");
        super.onStop();
        QCircleProgressDialog qCircleProgressDialog = this.C;
        if (qCircleProgressDialog != null && qCircleProgressDialog.isShowing()) {
            this.C.dismiss();
        }
        getActivity().finish();
    }
}
