package com.tencent.biz.qqcircle.debug.controller;

import android.view.View;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.mobileqq.R;
import com.tencent.qcircle.cooperation.config.debug.QCircleDebugKey$SwitchStateKey;
import com.tencent.upload.network.route.DebugServerRoute;
import com.tencent.upload.uinterface.UploadServiceBuilder;

/* compiled from: P */
/* loaded from: classes4.dex */
public class e extends com.tencent.qcircle.cooperation.config.debug.a {

    /* renamed from: b, reason: collision with root package name */
    private static final String f84260b = QCircleDebugKey$SwitchStateKey.QCIRCLE_CANCEL_DEBUG_UPLOAD_SERVER_CONTROLLER.name();

    @Override // com.tencent.qcircle.cooperation.config.debug.a
    public int b() {
        return 0;
    }

    @Override // com.tencent.qcircle.cooperation.config.debug.a
    public String d() {
        return f84260b;
    }

    @Override // com.tencent.qcircle.cooperation.config.debug.a
    public String e() {
        return com.tencent.biz.qqcircle.utils.h.a(R.string.f181733ek);
    }

    @Override // com.tencent.qcircle.cooperation.config.debug.a
    public void onClick(View view) {
        UploadServiceBuilder.getInstance().setDebugServerRoute(DebugServerRoute.DEV);
        QCircleToast.o(com.tencent.biz.qqcircle.utils.h.a(R.string.f182693h6), 0);
    }
}
