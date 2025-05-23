package com.tencent.mobileqq.qqlive.room.gamedownloader.downloader;

import com.tencent.halley.downloader.DownloaderTask;
import com.tencent.halley.downloader.DownloaderTaskListener;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\n\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u000b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\f\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/qqlive/room/gamedownloader/downloader/a;", "Lcom/tencent/halley/downloader/DownloaderTaskListener;", "Lcom/tencent/halley/downloader/DownloaderTask;", "task", "", "onTaskPendingMainloop", "onTaskDetectedMainloop", "onTaskStartedSubloop", "onTaskDetectedSubloop", "onTaskReceivedSubloop", "onTaskPausedSubloop", "onTaskFailedSubloop", "onTaskCompletedSubloop", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public class a implements DownloaderTaskListener {
    static IPatchRedirector $redirector_;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.halley.downloader.DownloaderTaskListener
    public void onTaskCompletedSubloop(@Nullable DownloaderTask task) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) task);
        }
    }

    @Override // com.tencent.halley.downloader.DownloaderTaskListener
    public void onTaskDetectedMainloop(@Nullable DownloaderTask task) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) task);
        }
    }

    @Override // com.tencent.halley.downloader.DownloaderTaskListener
    public void onTaskDetectedSubloop(@Nullable DownloaderTask task) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) task);
        }
    }

    @Override // com.tencent.halley.downloader.DownloaderTaskListener
    public void onTaskFailedSubloop(@Nullable DownloaderTask task) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) task);
        }
    }

    @Override // com.tencent.halley.downloader.DownloaderTaskListener
    public void onTaskPausedSubloop(@Nullable DownloaderTask task) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) task);
        }
    }

    @Override // com.tencent.halley.downloader.DownloaderTaskListener
    public void onTaskPendingMainloop(@Nullable DownloaderTask task) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) task);
        }
    }

    @Override // com.tencent.halley.downloader.DownloaderTaskListener
    public void onTaskReceivedSubloop(@Nullable DownloaderTask task) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) task);
        }
    }

    @Override // com.tencent.halley.downloader.DownloaderTaskListener
    public void onTaskStartedSubloop(@Nullable DownloaderTask task) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) task);
        }
    }
}
