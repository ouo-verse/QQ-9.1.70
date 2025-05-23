package com.tencent.tavkit.report;

import androidx.annotation.Nullable;
import com.tencent.tav.core.AssetExportSession;
import com.tencent.tav.core.ExportErrorStatus;
import com.tencent.tav.coremedia.CGSize;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TAVReportUtils {
    @NotNull
    public static String buildExportErrorMsg(String str, @Nullable AssetExportSession assetExportSession) {
        ExportErrorStatus exportErrorStatus;
        if (assetExportSession != null && (exportErrorStatus = assetExportSession.getExportErrorStatus()) != null) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("errorCode:");
            sb5.append(exportErrorStatus.code);
            sb5.append("\n");
            CGSize outputSize = assetExportSession.getExportConfig().getOutputSize();
            if (outputSize != null) {
                sb5.append("size:");
                sb5.append(outputSize);
                sb5.append(";");
            }
            sb5.append("progress:");
            sb5.append(assetExportSession.getProgress());
            sb5.append(";\n");
            sb5.append("extraInfo:");
            sb5.append(exportErrorStatus.f374239msg);
            sb5.append(";\n");
            sb5.append("retryIndex:");
            sb5.append(assetExportSession.getRetryIndex());
            sb5.append(";\n");
            Throwable th5 = exportErrorStatus.throwable;
            if (th5 != null) {
                sb5.append(th5.getClass().getSimpleName());
                sb5.append(":");
                sb5.append(exportErrorStatus.throwable.getMessage());
                sb5.append(";\n");
                for (StackTraceElement stackTraceElement : exportErrorStatus.throwable.getStackTrace()) {
                    sb5.append(stackTraceElement.toString());
                    sb5.append("\n");
                }
            }
            return sb5.toString();
        }
        return str;
    }
}
