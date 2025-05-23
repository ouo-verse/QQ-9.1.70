package fa3;

import com.tencent.mobileqq.winkpublish.report.WinkPublishQualityReportData;
import com.tencent.mobileqq.winkpublish.report.WinkPublishReportQueue;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.factory.RFWThreadFactory;
import java.lang.Thread;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u0000 \f2\u00020\u0001:\u0001\rB\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\u000e"}, d2 = {"Lfa3/m;", "Lcom/tencent/richframework/thread/factory/RFWThreadFactory;", "", "t", "", "b", "Ljava/lang/Runnable;", "runnable", "Ljava/lang/Thread;", "newThread", "<init>", "()V", "d", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class m extends RFWThreadFactory {
    public m() {
        super("WinkRoomThreadFactory");
    }

    private final void b(Throwable t16) {
        try {
            WinkPublishReportQueue winkPublishReportQueue = WinkPublishReportQueue.INSTANCE;
            WinkPublishQualityReportData.Builder ext1 = new WinkPublishQualityReportData.Builder().eventId("key_wink_db_exception").ext1(t16.getClass().getName());
            String message = t16.getMessage();
            if (message == null) {
                message = "";
            }
            winkPublishReportQueue.report(ext1.ext2(message).getReportData(), 1);
        } catch (Exception e16) {
            QLog.e("WinkRoomThreadFactory", 1, "dbExceptionReport, error ", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(m this$0, Thread thread, Throwable throwable) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.e("WinkRoomThreadFactory", 1, "catch wink db error, thread: " + thread, throwable);
        Intrinsics.checkNotNullExpressionValue(throwable, "throwable");
        this$0.b(throwable);
    }

    @Override // com.tencent.richframework.thread.factory.RFWThreadFactory, java.util.concurrent.ThreadFactory
    @NotNull
    public Thread newThread(@NotNull Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        Thread newThread = super.newThread(runnable);
        newThread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: fa3.l
            @Override // java.lang.Thread.UncaughtExceptionHandler
            public final void uncaughtException(Thread thread, Throwable th5) {
                m.c(m.this, thread, th5);
            }
        });
        Intrinsics.checkNotNullExpressionValue(newThread, "super.newThread(runnable\u2026)\n            }\n        }");
        return newThread;
    }
}
