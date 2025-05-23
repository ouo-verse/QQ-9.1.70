package com.tencent.qqprotect.common;

import android.os.Handler;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.common.pb.SafeReport$LogItem;
import com.tencent.qqprotect.common.pb.SafeReport$ReqBody;
import java.util.Iterator;
import java.util.Vector;

/* compiled from: P */
/* loaded from: classes25.dex */
public class QSecRptControllerImpl extends c implements Handler.Callback {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes25.dex */
    private class ReportRunnable implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private Vector<e> f363495d;
        final /* synthetic */ QSecRptControllerImpl this$0;

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            try {
                Vector<e> vector = this.f363495d;
                if (vector != null && !vector.isEmpty()) {
                    SafeReport$ReqBody safeReport$ReqBody = new SafeReport$ReqBody();
                    Iterator<e> it = this.f363495d.iterator();
                    int i3 = 0;
                    int i16 = 0;
                    while (it.hasNext()) {
                        e next = it.next();
                        if (next != null) {
                            if (safeReport$ReqBody == null) {
                                safeReport$ReqBody = new SafeReport$ReqBody();
                            }
                            String d16 = c.d(c.c(next.f363499a));
                            SafeReport$LogItem safeReport$LogItem = new SafeReport$LogItem();
                            safeReport$LogItem.uint32_rpt_id.set(next.f363499a);
                            String str = d16 + "," + next.f363500b + "," + next.f363501c;
                            safeReport$LogItem.bytes_rpt_data.set(ByteStringMicro.copyFrom(str.getBytes()));
                            safeReport$ReqBody.LogItem_reportdata.add(safeReport$LogItem);
                            i3++;
                            i16 += str.length();
                            if (i3 == 20 || i16 > 1024) {
                                if (QLog.isColorLevel()) {
                                    QLog.d("QSRPT", 2, String.format("sending...item count: %d, package size: %d", Integer.valueOf(i3), Integer.valueOf(i16)));
                                }
                                QSecRptControllerImpl.e(null, safeReport$ReqBody);
                                i3 = 0;
                                i16 = 0;
                                safeReport$ReqBody = null;
                            }
                        }
                    }
                    if (i3 > 0 && safeReport$ReqBody != null) {
                        QSecRptControllerImpl.e(null, safeReport$ReqBody);
                    }
                    this.f363495d.removeAllElements();
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18345);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        }
    }

    static /* bridge */ /* synthetic */ void e(QSecRptControllerImpl qSecRptControllerImpl, SafeReport$ReqBody safeReport$ReqBody) {
        throw null;
    }
}
