package com.tencent.mobileqq.activity.aio.zhitu;

import android.os.Bundle;
import android.os.Handler;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

/* compiled from: P */
/* loaded from: classes10.dex */
public class b implements BusinessObserver {

    /* renamed from: d, reason: collision with root package name */
    private Handler f180381d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Handler handler) {
        this.f180381d = handler;
    }

    @Override // mqq.observer.BusinessObserver
    public void onReceive(int i3, boolean z16, Bundle bundle) {
        int i16 = bundle.getInt("ErrorCode");
        String string = bundle.getString("UniqueKey");
        if (QLog.isColorLevel()) {
            QLog.d("ZhituObserver", 2, ZhituManager.x(string, "onReceive", "observer onReceive with code: " + i16));
        }
        String N = ZhituManager.I((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime()).N();
        if (!N.equals(string)) {
            if (QLog.isColorLevel()) {
                QLog.d("ZhituObserver", 2, ZhituManager.x(string, "onReceive", "response with " + string + " but the last one is " + N + ", skip."));
                return;
            }
            return;
        }
        Handler handler = this.f180381d;
        if (handler != null) {
            this.f180381d.sendMessage(handler.obtainMessage(2, bundle));
        }
    }
}
