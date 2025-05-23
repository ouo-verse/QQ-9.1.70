package com.tencent.raft.standard.net;

import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.raft.standard.net.IRNetwork;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes25.dex */
public interface IRDownload {
    public static final IPatchRedirector $redirector_ = null;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static final class DownloadPriority {
        private static final /* synthetic */ DownloadPriority[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final DownloadPriority High;
        public static final DownloadPriority Highest;
        public static final DownloadPriority Low;
        public static final DownloadPriority Normal;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(FaceConstant.HeadDownload.RESULT_CODE_QQHEAD_STORGE_EXCEPTION);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            DownloadPriority downloadPriority = new DownloadPriority("Highest", 0);
            Highest = downloadPriority;
            DownloadPriority downloadPriority2 = new DownloadPriority("High", 1);
            High = downloadPriority2;
            DownloadPriority downloadPriority3 = new DownloadPriority("Normal", 2);
            Normal = downloadPriority3;
            DownloadPriority downloadPriority4 = new DownloadPriority("Low", 3);
            Low = downloadPriority4;
            $VALUES = new DownloadPriority[]{downloadPriority, downloadPriority2, downloadPriority3, downloadPriority4};
        }

        DownloadPriority(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static DownloadPriority valueOf(String str) {
            return (DownloadPriority) Enum.valueOf(DownloadPriority.class, str);
        }

        public static DownloadPriority[] values() {
            return (DownloadPriority[]) $VALUES.clone();
        }
    }

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public interface IDownloadCallback {
        void onComplete(@NotNull IRNetwork.ResultInfo resultInfo);

        void onProgress(long j3, long j16);
    }

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public interface IRDownloadTask {
        boolean cancel();
    }

    IRDownloadTask downloadWithUrl(@NotNull String str, @NotNull String str2, @NotNull DownloadPriority downloadPriority, @NotNull IDownloadCallback iDownloadCallback);

    IRDownloadTask downloadWithUrl(@NotNull String str, @NotNull String str2, @NotNull DownloadPriority downloadPriority, @NotNull IDownloadCallback iDownloadCallback, @Nullable Map<String, String> map);

    IRDownloadTask downloadWithUrl(@NotNull String str, @NotNull String str2, @NotNull IDownloadCallback iDownloadCallback);
}
