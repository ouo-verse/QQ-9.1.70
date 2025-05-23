package com.tencent.av.business.servlet;

import android.os.Looper;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.NewIntent;
import mqq.app.Servlet;

/* compiled from: P */
/* loaded from: classes3.dex */
public abstract class BaseService {

    /* renamed from: a, reason: collision with root package name */
    protected AppInterface f73467a;

    public BaseService(AppInterface appInterface) {
        this.f73467a = appInterface;
    }

    public abstract Class<? extends Servlet> a();

    public void b(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        byte[] bArr;
        if (fromServiceMsg.isSuccess() && fromServiceMsg.getWupBuffer() != null) {
            int length = fromServiceMsg.getWupBuffer().length - 4;
            if (length > 0) {
                byte[] bArr2 = new byte[length];
                PkgTools.copyData(bArr2, 0, fromServiceMsg.getWupBuffer(), 4, length);
                fromServiceMsg.putWupBuffer(bArr2);
            }
            bArr = fromServiceMsg.getWupBuffer();
        } else {
            bArr = null;
        }
        c(toServiceMsg, fromServiceMsg, bArr);
    }

    protected abstract void c(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj);

    public void d(final ToServiceMsg toServiceMsg) {
        Runnable runnable = new Runnable() { // from class: com.tencent.av.business.servlet.BaseService.1
            @Override // java.lang.Runnable
            public void run() {
                String serviceCmd = toServiceMsg.getServiceCmd();
                if (QLog.isColorLevel()) {
                    QLog.i("BaseService", 2, "sendRequest " + serviceCmd);
                }
                if (toServiceMsg.getWupBuffer() != null) {
                    long length = toServiceMsg.getWupBuffer().length;
                    int i3 = (int) length;
                    byte[] bArr = new byte[i3 + 4];
                    PkgTools.dWord2Byte(bArr, 0, length + 4);
                    PkgTools.copyData(bArr, 4, toServiceMsg.getWupBuffer(), i3);
                    toServiceMsg.putWupBuffer(bArr);
                    NewIntent newIntent = new NewIntent(BaseService.this.f73467a.getApplication(), BaseService.this.a());
                    newIntent.putExtra(ToServiceMsg.class.getSimpleName(), toServiceMsg);
                    BaseService.this.f73467a.startServlet(newIntent);
                }
            }
        };
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            ThreadManagerV2.excute(runnable, 16, null, false);
        } else {
            runnable.run();
        }
    }
}
