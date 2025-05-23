package com.tencent.mobileqq.qqlive.room.gamedownloader.downloader;

import android.content.Intent;
import android.text.TextUtils;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamematrix.gmcg.api.GmCgKingsHonorMidGameErrorCode;
import com.tencent.halley.d;
import com.tencent.halley.downloader.DownloaderTask;
import com.tencent.halley.downloader.DownloaderTaskListener;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.sail.c;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001e\u0010\u001fJ6\u0010\r\u001a\u00020\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J\u0018\u0010\u0010\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000f\u001a\u00020\u0004J&\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\bJ\u000e\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\bJ\u000e\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\bJ\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0011\u001a\u00020\bJ\u000e\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\bR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/qqlive/room/gamedownloader/downloader/b;", "", "Lcom/tencent/halley/downloader/DownloaderTask;", "downloaderTask", "Lcom/tencent/halley/downloader/DownloaderTaskListener;", "listener", "", "errCode", "", "errMsg", "", "errStack", "", "f", "currentRoomTask", "statueListener", "i", "url", "filePath", WadlProxyConsts.PARAM_FILENAME, "b", "", h.F, "e", "d", "c", "a", "Lcom/tencent/halley/b;", "Lcom/tencent/halley/b;", PM.APK_DOWNLOADER, "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f271569a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static com.tencent.halley.b apkDownloader;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(26953);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
            return;
        }
        f271569a = new b();
        apkDownloader = com.tencent.halley.b.f();
        d dVar = new d(BaseApplication.getContext(), 406, String.valueOf(c.f272176a.G()), "qqlive");
        com.tencent.halley.b bVar = apkDownloader;
        if (bVar != null) {
            bVar.h(dVar);
        }
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void f(DownloaderTask downloaderTask, DownloaderTaskListener listener, int errCode, String errMsg, Throwable errStack) {
        if (downloaderTask != null) {
            downloaderTask.removeListener(listener);
        }
        listener.onTaskFailedMainloop(downloaderTask);
    }

    static /* synthetic */ void g(b bVar, DownloaderTask downloaderTask, DownloaderTaskListener downloaderTaskListener, int i3, String str, Throwable th5, int i16, Object obj) {
        if ((i16 & 16) != 0) {
            th5 = null;
        }
        bVar.f(downloaderTask, downloaderTaskListener, i3, str, th5);
    }

    public final void a(@NotNull String url) {
        com.tencent.halley.b bVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) url);
            return;
        }
        Intrinsics.checkNotNullParameter(url, "url");
        DownloaderTask c16 = c(url);
        if (c16 != null && (bVar = apkDownloader) != null) {
            bVar.d(c16, true);
        }
    }

    public final void b(@NotNull String url, @NotNull String filePath, @NotNull String fileName, @NotNull DownloaderTaskListener listener) {
        DownloaderTask downloaderTask;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, url, filePath, fileName, listener);
            return;
        }
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        Intrinsics.checkNotNullParameter(listener, "listener");
        DownloaderTask c16 = c(url);
        if (c16 != null) {
            try {
                c16.addListener(listener);
                c16.resume();
                return;
            } catch (Exception e16) {
                f271569a.f(c16, listener, GmCgKingsHonorMidGameErrorCode.InitializerGameNotFront, "download resume exception", e16);
                return;
            } catch (OutOfMemoryError e17) {
                f271569a.f(c16, listener, -8002, "download resume OOM", e17);
                return;
            }
        }
        com.tencent.halley.b bVar = apkDownloader;
        String str = null;
        if (bVar != null) {
            downloaderTask = bVar.b(url, filePath, fileName, listener);
        } else {
            downloaderTask = null;
        }
        try {
            com.tencent.halley.b bVar2 = apkDownloader;
            if (bVar2 != null) {
                str = bVar2.k(downloaderTask);
            }
            if (!TextUtils.isEmpty(str)) {
                g(this, downloaderTask, listener, -8003, "download start error - " + str, null, 16, null);
            }
        } catch (Exception e18) {
            f(downloaderTask, listener, -8004, "download start exception", e18);
        } catch (OutOfMemoryError e19) {
            f(downloaderTask, listener, -8005, "download start OOM", e19);
        }
    }

    @Nullable
    public final DownloaderTask c(@NotNull String url) {
        List<DownloaderTask> e16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (DownloaderTask) iPatchRedirector.redirect((short) 8, (Object) this, (Object) url);
        }
        Intrinsics.checkNotNullParameter(url, "url");
        com.tencent.halley.b bVar = apkDownloader;
        Object obj = null;
        if (bVar == null || (e16 = bVar.e()) == null) {
            return null;
        }
        Iterator<T> it = e16.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (Intrinsics.areEqual(((DownloaderTask) next).getFileUrl(), url)) {
                obj = next;
                break;
            }
        }
        return (DownloaderTask) obj;
    }

    public final boolean d(@NotNull String url) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) url)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(url, "url");
        DownloaderTask c16 = c(url);
        if (c16 == null || !new File(c16.getFullSavePath()).exists()) {
            return false;
        }
        Intent openApkIntent = FileProvider7Helper.openApkIntent(BaseApplication.getContext(), c16.getFullSavePath());
        openApkIntent.putExtra("big_brother_source_key", "biz_src_jc_qqlive");
        BaseApplication.getContext().startActivity(openApkIntent);
        return true;
    }

    public final boolean e(@NotNull String url) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) url)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(url, "url");
        DownloaderTask c16 = c(url);
        if (c16 == null || !new File(c16.getFullSavePath()).exists()) {
            return false;
        }
        return true;
    }

    public final boolean h(@NotNull String url) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) url)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(url, "url");
        DownloaderTask c16 = c(url);
        if (c16 != null) {
            c16.pause();
            return true;
        }
        return false;
    }

    public final void i(@Nullable DownloaderTask currentRoomTask, @NotNull DownloaderTaskListener statueListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) currentRoomTask, (Object) statueListener);
            return;
        }
        Intrinsics.checkNotNullParameter(statueListener, "statueListener");
        if (currentRoomTask != null) {
            currentRoomTask.removeListener(statueListener);
            currentRoomTask.addListener(statueListener);
        }
    }
}
