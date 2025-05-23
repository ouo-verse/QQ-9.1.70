package com.tencent.biz.qqcircle.debug.controller;

import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkpublish.api.IUploadApi;
import com.tencent.qcircle.application.QCircleApplication;
import com.tencent.qcircle.cooperation.config.debug.QCircleDebugKey$SwitchStateKey;

/* compiled from: P */
/* loaded from: classes4.dex */
public class r extends com.tencent.qcircle.cooperation.config.debug.a {

    /* renamed from: b, reason: collision with root package name */
    private static final String f84268b = QCircleDebugKey$SwitchStateKey.QCIRCLE_DEBUG_UPLOAD_SERVER_CONTROLLER.name();

    @Override // com.tencent.qcircle.cooperation.config.debug.a
    public int b() {
        return 0;
    }

    @Override // com.tencent.qcircle.cooperation.config.debug.a
    public String d() {
        return f84268b;
    }

    @Override // com.tencent.qcircle.cooperation.config.debug.a
    public String e() {
        return com.tencent.biz.qqcircle.utils.h.a(R.string.f182793hf);
    }

    @Override // com.tencent.qcircle.cooperation.config.debug.a
    public void onClick(View view) {
        ((IUploadApi) QRoute.api(IUploadApi.class)).initUpload();
        com.tencent.biz.qqcircle.launcher.c.z(QCircleApplication.APP.getApplicationContext());
    }
}
