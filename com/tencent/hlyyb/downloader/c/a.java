package com.tencent.hlyyb.downloader.c;

import android.text.TextUtils;
import com.tencent.hlyyb.common.HalleyException;
import com.tencent.hlyyb.downloader.Downloader;
import com.tencent.hlyyb.downloader.DownloaderTask;
import com.tencent.hlyyb.downloader.DownloaderTaskCategory;
import com.tencent.hlyyb.downloader.DownloaderTaskListener;
import com.tencent.hlyyb.downloader.e.h;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class a implements Downloader {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static a f114440a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11844);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f114440a = new a();
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            b.f();
        }
    }

    public static a a() {
        return f114440a;
    }

    @Override // com.tencent.hlyyb.downloader.Downloader
    public final void addNewTask(DownloaderTask downloaderTask) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) downloaderTask);
        } else {
            if (downloaderTask instanceof h) {
                b.f().a(downloaderTask);
                return;
            }
            throw new RuntimeException("DownloaderTask should be created by Downloader.createNewTask");
        }
    }

    @Override // com.tencent.hlyyb.downloader.Downloader
    public final DownloaderTask createNewTask(int i3, String str, String str2, String str3, String str4, DownloaderTaskListener downloaderTaskListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? createNewTask(i3, str, str2, str3, str4, downloaderTaskListener, -1L, "") : (DownloaderTask) iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), str, str2, str3, str4, downloaderTaskListener);
    }

    @Override // com.tencent.hlyyb.downloader.Downloader
    public final void deleteTask(DownloaderTask downloaderTask, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, downloaderTask, Boolean.valueOf(z16));
        } else {
            b.f().a(downloaderTask, z16);
        }
    }

    @Override // com.tencent.hlyyb.downloader.Downloader
    public final void deleteTaskByKey(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, str, Boolean.valueOf(z16));
        } else {
            b.f().a(str, z16);
        }
    }

    @Override // com.tencent.hlyyb.downloader.Downloader
    public final void enableUserAction(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, z16);
        }
    }

    @Override // com.tencent.hlyyb.downloader.Downloader
    public final List<DownloaderTask> getAllTasks() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (List) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return b.f().c();
    }

    @Override // com.tencent.hlyyb.downloader.Downloader
    public final List<DownloaderTask> getCancelledTasks() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (List) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return b.f().a(true, true, false, false, true, false, false);
    }

    @Override // com.tencent.hlyyb.downloader.Downloader
    public final List<DownloaderTask> getCompletedTasks() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (List) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return b.f().a(true, true, false, false, false, false, true);
    }

    @Override // com.tencent.hlyyb.downloader.Downloader
    public final List<DownloaderTask> getFailedTasks() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (List) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return b.f().a(true, true, false, false, false, true, false);
    }

    @Override // com.tencent.hlyyb.downloader.Downloader
    public final List<DownloaderTask> getIncompleteTasks() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (List) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return b.f().a(true, true, true, true, true, true, false);
    }

    @Override // com.tencent.hlyyb.downloader.Downloader
    public final List<DownloaderTask> getRunningTasks() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (List) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return b.f().d();
    }

    @Override // com.tencent.hlyyb.downloader.Downloader
    public final String getVersion() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return com.tencent.hlyyb.common.a.e();
    }

    @Override // com.tencent.hlyyb.downloader.Downloader
    public final List<DownloaderTask> getWaitingTasks() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (List) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return b.f().a(true, true, false, true, false, false, false);
    }

    @Override // com.tencent.hlyyb.downloader.Downloader
    public final void pauseTasks(boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        Iterator<DownloaderTask> it = b.f().a(true, true, z16, z17, false, false, false).iterator();
        while (it.hasNext()) {
            it.next().pause();
        }
    }

    @Override // com.tencent.hlyyb.downloader.Downloader
    public final void resumeTasks(boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        Iterator<DownloaderTask> it = b.f().a(true, true, false, false, z16, z17, false).iterator();
        while (it.hasNext()) {
            try {
                it.next().resume();
            } catch (HalleyException e16) {
                e16.printStackTrace();
            }
        }
    }

    @Override // com.tencent.hlyyb.downloader.Downloader
    public final void setNotNetworkWaitMillis(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, i3);
        } else {
            com.tencent.hlyyb.downloader.a.b.b(i3);
        }
    }

    @Override // com.tencent.hlyyb.downloader.Downloader
    public final void setPhoneGuid(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) str);
        } else {
            com.tencent.hlyyb.downloader.a.b.c(str);
        }
    }

    @Override // com.tencent.hlyyb.downloader.Downloader
    public final void setProgressInterval(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, i3);
        } else {
            com.tencent.hlyyb.downloader.a.b.a(i3);
        }
    }

    @Override // com.tencent.hlyyb.downloader.Downloader
    public final void setQua1(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) str);
        } else {
            com.tencent.hlyyb.downloader.a.b.a(str);
        }
    }

    @Override // com.tencent.hlyyb.downloader.Downloader
    public final void setQua2(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) str);
        } else {
            com.tencent.hlyyb.downloader.a.b.b(str);
        }
    }

    @Override // com.tencent.hlyyb.downloader.Downloader
    public final void setTaskNumForCategory(DownloaderTaskCategory downloaderTaskCategory, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, (Object) downloaderTaskCategory, i3);
        } else {
            com.tencent.hlyyb.downloader.f.a.a().a(downloaderTaskCategory, i3);
        }
    }

    @Override // com.tencent.hlyyb.downloader.Downloader
    public final void setTempFileSubfix(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) str);
        } else {
            com.tencent.hlyyb.downloader.a.b.d(str);
        }
    }

    @Override // com.tencent.hlyyb.downloader.Downloader
    public final DownloaderTask createNewTask(int i3, String str, String str2, String str3, String str4, DownloaderTaskListener downloaderTaskListener, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) ? createNewTask(i3, str, str2, str3, str4, downloaderTaskListener, j3, "") : (DownloaderTask) iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), str, str2, str3, str4, downloaderTaskListener, Long.valueOf(j3));
    }

    @Override // com.tencent.hlyyb.downloader.Downloader
    public final DownloaderTask createNewTask(int i3, String str, String str2, String str3, String str4, DownloaderTaskListener downloaderTaskListener, long j3, String str5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (DownloaderTask) iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), str, str2, str3, str4, downloaderTaskListener, Long.valueOf(j3), str5);
        }
        DownloaderTask createNewTask = createNewTask(str2, str3, str4, downloaderTaskListener, j3, str5);
        createNewTask.setType(i3);
        createNewTask.setId(str);
        return createNewTask;
    }

    @Override // com.tencent.hlyyb.downloader.Downloader
    public final DownloaderTask createNewTask(String str, String str2, String str3, DownloaderTaskListener downloaderTaskListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) ? createNewTask(str, str2, str3, downloaderTaskListener, -1L, "") : (DownloaderTask) iPatchRedirector.redirect((short) 7, this, str, str2, str3, downloaderTaskListener);
    }

    @Override // com.tencent.hlyyb.downloader.Downloader
    public final DownloaderTask createNewTask(String str, String str2, String str3, DownloaderTaskListener downloaderTaskListener, long j3, String str4) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (DownloaderTask) iPatchRedirector.redirect((short) 8, this, str, str2, str3, downloaderTaskListener, Long.valueOf(j3), str4);
        }
        String str5 = TextUtils.isEmpty(str) ? "url is empty." : downloaderTaskListener == null ? "listener is null." : "";
        String b16 = com.tencent.hlyyb.common.b.b.a(str2) ? com.tencent.hlyyb.downloader.a.b.b() : str2;
        if ("".equals(str5)) {
            return new h(new com.tencent.hlyyb.downloader.e.f.b(str, j3), b16, str3, downloaderTaskListener, j3, str4);
        }
        throw new HalleyException(str5);
    }
}
