package okhttp3.internal.platform.android;

import com.tencent.hippy.qq.view.pag.HippyQQPagView;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import java.util.logging.Handler;
import java.util.logging.LogRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0016\u00a8\u0006\t"}, d2 = {"Lokhttp3/internal/platform/android/AndroidLogHandler;", "Ljava/util/logging/Handler;", "()V", "close", "", HippyQQPagView.FunctionName.FLUSH, "publish", QQPermissionConstants.Permission.AUIDO_GROUP, "Ljava/util/logging/LogRecord;", "okhttp"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes20.dex */
public final class AndroidLogHandler extends Handler {

    @NotNull
    public static final AndroidLogHandler INSTANCE = new AndroidLogHandler();

    AndroidLogHandler() {
    }

    @Override // java.util.logging.Handler
    public void publish(@NotNull LogRecord record) {
        int androidLevel;
        Intrinsics.checkNotNullParameter(record, "record");
        AndroidLog androidLog = AndroidLog.INSTANCE;
        String loggerName = record.getLoggerName();
        Intrinsics.checkNotNullExpressionValue(loggerName, "record.loggerName");
        androidLevel = AndroidLogKt.getAndroidLevel(record);
        String message = record.getMessage();
        Intrinsics.checkNotNullExpressionValue(message, "record.message");
        androidLog.androidLog$okhttp(loggerName, androidLevel, message, record.getThrown());
    }

    @Override // java.util.logging.Handler
    public void close() {
    }

    @Override // java.util.logging.Handler
    public void flush() {
    }
}
