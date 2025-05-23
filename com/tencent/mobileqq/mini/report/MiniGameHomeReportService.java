package com.tencent.mobileqq.mini.report;

import com.google.protobuf.nano.MessageNano;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.servlet.HomeReportServlet;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\rJ\u0006\u0010\u000f\u001a\u00020\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/mini/report/MiniGameHomeReportService;", "", "()V", "CMD_HOME_REPORT", "", "HOME_APPEAR_EVENT_APPSWITCH", "", "HOME_APPEAR_EVENT_BACKSWITCH", "HOME_APPEAR_EVENT_LOGIN", "HOME_APPEAR_EVENT_UNKNOWN", "TAG", "event", "recordAccountUpdate", "", "recordEnterBackground", "reportHomeAppearEvent", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniGameHomeReportService {
    private static final String CMD_HOME_REPORT = "trpc.gc_indust.device_report.SsoHome.SsoHomeReport";
    private static final int HOME_APPEAR_EVENT_APPSWITCH = 3;
    private static final int HOME_APPEAR_EVENT_BACKSWITCH = 2;
    private static final int HOME_APPEAR_EVENT_LOGIN = 1;
    private static final int HOME_APPEAR_EVENT_UNKNOWN = 0;
    public static final MiniGameHomeReportService INSTANCE = new MiniGameHomeReportService();
    private static final String TAG = "MiniGameHomeReportService";
    private static int event;

    MiniGameHomeReportService() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void reportHomeAppearEvent$lambda$1(b.a req) {
        Intrinsics.checkNotNullParameter(req, "$req");
        HomeReportServlet.INSTANCE.sendRequest(CMD_HOME_REPORT, MessageNano.toByteArray(req));
    }

    public final void reportHomeAppearEvent() {
        try {
            if (event == 0) {
                event = 3;
            }
            final b.a aVar = new b.a();
            aVar.f27595a = event;
            aVar.f27596b = System.currentTimeMillis();
            QLog.d(TAG, 2, "[home report] report event " + event);
            ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.mini.report.d
                @Override // java.lang.Runnable
                public final void run() {
                    MiniGameHomeReportService.reportHomeAppearEvent$lambda$1(b.a.this);
                }
            });
            event = 0;
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "reportHomeAppearEvent throw", th5);
        }
    }

    public final void recordAccountUpdate() {
        event = 1;
        reportHomeAppearEvent();
    }

    public final void recordEnterBackground() {
        event = 2;
    }
}
