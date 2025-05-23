package com.tencent.biz.qqcircle.debug.controller;

import android.text.TextUtils;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.requests.QCircleQZoneVideoWindowStatusSetRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.component.media.image.ProgressTracer;
import com.tencent.mobileqq.R;
import com.tencent.qcircle.cooperation.config.debug.QCircleDebugKey$SwitchStateKey;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import qzone.QZQQVideoSwitch$SetRsp;

/* compiled from: P */
/* loaded from: classes4.dex */
public class bl extends bs {

    /* renamed from: d, reason: collision with root package name */
    private static final String f84226d = QCircleDebugKey$SwitchStateKey.QCIRCLE_SET_QZONE_VIDEO_POP_WINDOW_STATUS.name();

    private String t(int i3) {
        if (i3 == 0) {
            return "\u9ed8\u8ba4 \u6ca1\u5f39\u8fc7";
        }
        if (i3 == 1) {
            return "\u5f39\u8fc7\u6ca1\u70b9\u540c\u610f";
        }
        if (i3 == 2) {
            return "\u5f39\u8fc7\u70b9\u4e86\u540c\u610f";
        }
        if (i3 == 3) {
            return "\u5b89\u5168\u9ed1\u540d\u5355";
        }
        return "\u65e0\u6cd5\u89e3\u6790ret";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u(boolean z16, long j3, QZQQVideoSwitch$SetRsp qZQQVideoSwitch$SetRsp, int i3, String str) {
        if (z16 && j3 == 0 && qZQQVideoSwitch$SetRsp != null) {
            QCircleToast.l(QCircleToast.f91644d, "\u8bbe\u7f6e\u4e86 " + i3 + ProgressTracer.SEPARATOR + t(i3), 0, true, false);
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            QCircleToast.l(QCircleToast.f91645e, str, 0, true, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v(final int i3, BaseRequest baseRequest, final boolean z16, final long j3, final String str, final QZQQVideoSwitch$SetRsp qZQQVideoSwitch$SetRsp) {
        QLog.d("QCircleQZoneVideoAuthWindowStatusController", 1, " changeState onReceive, ", " | isSuccess: " + z16, " | traceId: " + baseRequest.getTraceId(), " | cmdName: " + baseRequest.get$cmd(), " | retCode: " + j3, " | retMessage: " + str, " | state: " + i3);
        RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.tencent.biz.qqcircle.debug.controller.bk
            @Override // java.lang.Runnable
            public final void run() {
                bl.this.u(z16, j3, qZQQVideoSwitch$SetRsp, i3, str);
            }
        });
    }

    @Override // com.tencent.qcircle.cooperation.config.debug.a
    public String c() {
        return null;
    }

    @Override // com.tencent.qcircle.cooperation.config.debug.a
    public String d() {
        return f84226d;
    }

    @Override // com.tencent.qcircle.cooperation.config.debug.a
    public String e() {
        return com.tencent.biz.qqcircle.utils.h.a(R.string.f182703h7);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.debug.controller.bs, com.tencent.qcircle.cooperation.config.debug.d
    public void g(final int i3) {
        super.g(i3);
        VSNetworkHelper.getInstance().sendRequest(new QCircleQZoneVideoWindowStatusSetRequest(i3), new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.biz.qqcircle.debug.controller.bj
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                bl.this.v(i3, baseRequest, z16, j3, str, (QZQQVideoSwitch$SetRsp) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.qcircle.cooperation.config.debug.d
    public int h() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.debug.controller.bs, com.tencent.qcircle.cooperation.config.debug.d
    public void k() {
    }
}
