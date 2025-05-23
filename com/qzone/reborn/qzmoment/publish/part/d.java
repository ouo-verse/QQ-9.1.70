package com.qzone.reborn.qzmoment.publish.part;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.qzone.reborn.qzmoment.bean.QZMPublishCaptureBean;
import com.qzone.reborn.qzmoment.widget.QZMPublishPreview;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes37.dex */
public class d extends an.a {

    /* renamed from: d, reason: collision with root package name */
    private QZMPublishPreview f59031d;

    /* renamed from: e, reason: collision with root package name */
    private pn.b f59032e;

    /* renamed from: f, reason: collision with root package name */
    private QZMPublishCaptureBean f59033f;

    private void C9() {
        if (getActivity() == null) {
            QLog.e("QZMPublishPreviewPart", 1, "qzm activity is null");
            return;
        }
        if (getActivity().getIntent() == null) {
            QLog.e("QZMPublishPreviewPart", 1, "qzm activity intent is null");
            return;
        }
        Intent intent = getActivity().getIntent();
        if (intent == null || !intent.hasExtra("key_bundle_common_init_bean")) {
            return;
        }
        QZMPublishCaptureBean qZMPublishCaptureBean = (QZMPublishCaptureBean) intent.getSerializableExtra("key_bundle_common_init_bean");
        this.f59033f = qZMPublishCaptureBean;
        this.f59032e.U1(qZMPublishCaptureBean);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        QZMPublishPreview qZMPublishPreview = (QZMPublishPreview) view.findViewById(R.id.ml7);
        this.f59031d = qZMPublishPreview;
        qZMPublishPreview.setData(this.f59033f);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        super.onPartCreate(activity, bundle);
        this.f59032e = (pn.b) getViewModel(pn.b.class);
        C9();
    }
}
