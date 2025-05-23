package com.tencent.raft.standard.net;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.raft.standard.net.IRDownload;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes25.dex */
public final /* synthetic */ class a {
    public static IRDownload.IRDownloadTask a(IRDownload iRDownload, @NotNull String str, @NotNull String str2, @NotNull IRDownload.DownloadPriority downloadPriority, @NotNull IRDownload.IDownloadCallback iDownloadCallback, @Nullable Map map) {
        IPatchRedirector iPatchRedirector = IRDownload.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (IRDownload.IRDownloadTask) iPatchRedirector.redirect((short) 1, iRDownload, str, str2, downloadPriority, iDownloadCallback, map);
        }
        return iRDownload.downloadWithUrl(str, str2, downloadPriority, iDownloadCallback);
    }
}
