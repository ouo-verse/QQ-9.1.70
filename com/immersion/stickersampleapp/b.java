package com.immersion.stickersampleapp;

import android.text.TextUtils;
import com.immersion.touchsensesdk.AsyncConnectionProxy;
import com.immersion.touchsensesdk.IConnection;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes2.dex */
public class b extends AsyncConnectionProxy {

    /* renamed from: a, reason: collision with root package name */
    private WeakReference<QQAppInterface> f38081a;

    public b() {
        if (MobileQQ.sProcessId == 1) {
            this.f38081a = new WeakReference<>((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime());
        }
    }

    @Override // com.immersion.touchsensesdk.AsyncConnectionProxy
    public void connect(String str, int i3, int i16) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ImmersionHandler immersionHandler = (ImmersionHandler) this.f38081a.get().getBusinessHandler(BusinessHandlerFactory.IMMERSION_HANDLER);
        immersionHandler.E2(this);
        immersionHandler.D2(str);
    }

    @Override // com.immersion.touchsensesdk.AsyncConnectionProxy
    public void setConnection(IConnection iConnection) {
        boolean z16;
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("HapticMediaPlayer connection == NULL -->");
            if (iConnection == null) {
                z16 = true;
            } else {
                z16 = false;
            }
            sb5.append(z16);
            QLog.i("ImmerIConnectionProxy", 2, sb5.toString());
        }
        super.setConnection(iConnection);
    }
}
