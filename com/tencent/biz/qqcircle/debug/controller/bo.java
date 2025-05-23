package com.tencent.biz.qqcircle.debug.controller;

import android.app.Application;
import android.content.Context;
import android.provider.Settings;
import android.widget.Toast;
import com.tencent.biz.qqcircle.debug.report.QFSReportInfoFloatingWindow;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.mobileqq.R;
import com.tencent.qcircle.cooperation.config.debug.QCircleDebugKey$SwitchStateKey;

/* compiled from: P */
/* loaded from: classes4.dex */
public class bo extends bs {

    /* renamed from: d, reason: collision with root package name */
    private static final String f84229d = QCircleDebugKey$SwitchStateKey.QCIRCLE_ENABLED_REPORT_INFO_BOARD.name();

    private boolean r(Context context) {
        if (!Settings.canDrawOverlays(context)) {
            Toast.makeText(context, "\u8bf7\u5f00\u542f\u60ac\u6d6e\u7a97\u6743\u9650", 0).show();
            return false;
        }
        return true;
    }

    @Override // com.tencent.qcircle.cooperation.config.debug.a
    public String c() {
        return null;
    }

    @Override // com.tencent.qcircle.cooperation.config.debug.a
    public String d() {
        return f84229d;
    }

    @Override // com.tencent.qcircle.cooperation.config.debug.a
    public String e() {
        return com.tencent.biz.qqcircle.utils.h.a(R.string.f182183fs);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.debug.controller.bs, com.tencent.qcircle.cooperation.config.debug.d
    public void g(int i3) {
        super.g(i3);
        boolean z16 = true;
        if (i3 != 1) {
            z16 = false;
        }
        Application application = RFWApplication.getApplication();
        if (z16 && r(application)) {
            new QFSReportInfoFloatingWindow(application).A();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.qcircle.cooperation.config.debug.d
    public int h() {
        return 0;
    }
}
