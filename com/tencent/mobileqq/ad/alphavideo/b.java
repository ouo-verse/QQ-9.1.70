package com.tencent.mobileqq.ad.alphavideo;

import android.text.TextUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.ad.api.IAdFileApi;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.util.l;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.download.api.IDownloaderFactory;
import com.tencent.mobileqq.vip.f;
import com.tencent.mobileqq.vip.g;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.net.URL;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0016B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0002H\u0002J\u001c\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u00022\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bJ\u0006\u0010\u0010\u001a\u00020\u000eR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0012\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/ad/alphavideo/b;", "", "", h.F, "url", "f", "g", "filePath", "", "e", "downloadUrl", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mobileqq/ad/alphavideo/b$a;", "weakFileDownloadCallback", "", "b", "d", "Lcom/tencent/mobileqq/vip/h;", "Lcom/tencent/mobileqq/vip/h;", "mDownloaderInterface", "<init>", "()V", "a", "qqad-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f186687a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static com.tencent.mobileqq.vip.h mDownloaderInterface;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/ad/alphavideo/b$a;", "", "", WadlProxyConsts.PARAM_FILENAME, "", "b", "a", "qqad-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public interface a {
        void a(@NotNull String fileName);

        void b(@NotNull String fileName);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/ad/alphavideo/b$b", "Lcom/tencent/mobileqq/vip/f;", "Lcom/tencent/mobileqq/vip/g;", "task", "", "onDone", "qqad-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.ad.alphavideo.b$b, reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static final class C7216b extends f {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ WeakReference<a> f186689a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f186690b;

        C7216b(WeakReference<a> weakReference, String str) {
            this.f186689a = weakReference;
            this.f186690b = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) weakReference, (Object) str);
            }
        }

        @Override // com.tencent.mobileqq.vip.f
        public void onDone(@NotNull g task) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) task);
                return;
            }
            Intrinsics.checkNotNullParameter(task, "task");
            super.onDoneFile(task);
            QLog.d("MaskAdAlphaVideoFileHelper", 1, "downloadFile onDone");
            a aVar = this.f186689a.get();
            if (aVar != null) {
                aVar.b(this.f186690b);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(26452);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f186687a = new b();
        }
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(String downloadUrl, String filePath, f downloadListener) {
        Intrinsics.checkNotNullParameter(downloadUrl, "$downloadUrl");
        Intrinsics.checkNotNullParameter(filePath, "$filePath");
        Intrinsics.checkNotNullParameter(downloadListener, "$downloadListener");
        g gVar = new g(downloadUrl, new File(filePath));
        gVar.f313008f = 2;
        gVar.S = "";
        com.tencent.mobileqq.vip.h hVar = mDownloaderInterface;
        if (hVar != null) {
            hVar.startDownload(gVar, downloadListener, null);
        }
    }

    private final boolean e(String filePath) {
        if (TextUtils.isEmpty(filePath)) {
            return false;
        }
        return l.b(filePath);
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0022, code lost:
    
        r1 = kotlin.text.StringsKt__StringsKt.lastIndexOf$default((java.lang.CharSequence) r11, ".", 0, false, 6, (java.lang.Object) null);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String f(String url) {
        String str;
        int lastIndexOf$default;
        int i3;
        try {
            String path = new URL(url).getPath();
            Intrinsics.checkNotNullExpressionValue(path, "tempUrl.path");
            url = path;
        } catch (Throwable th5) {
            QLog.e("MaskAdAlphaVideoFileHelper", 1, "getFileSuffixByUrl error", th5);
        }
        if (!TextUtils.isEmpty(url) && lastIndexOf$default != -1 && (i3 = lastIndexOf$default + 1) < url.length()) {
            str = url.substring(i3);
            Intrinsics.checkNotNullExpressionValue(str, "this as java.lang.String).substring(startIndex)");
        } else {
            str = "";
        }
        return '.' + str;
    }

    private final String g(String url) {
        if (TextUtils.isEmpty(url)) {
            return "";
        }
        try {
            String d16 = com.tencent.open.base.g.d(url);
            return h() + d16 + f(url);
        } catch (Throwable th5) {
            QLog.e("MaskAdAlphaVideoFileHelper", 1, "getResPath error:", th5);
            return "";
        }
    }

    private final String h() {
        return ((IAdFileApi) QRoute.api(IAdFileApi.class)).getResPathPrefix("mask_ad_alpha_video");
    }

    public final void b(@NotNull final String downloadUrl, @NotNull WeakReference<a> weakFileDownloadCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) downloadUrl, (Object) weakFileDownloadCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(downloadUrl, "downloadUrl");
        Intrinsics.checkNotNullParameter(weakFileDownloadCallback, "weakFileDownloadCallback");
        if (TextUtils.isEmpty(downloadUrl)) {
            QLog.e("MaskAdAlphaVideoFileHelper", 1, "downloadFile error: url is null");
            return;
        }
        final String g16 = g(downloadUrl);
        if (TextUtils.isEmpty(g16)) {
            QLog.e("MaskAdAlphaVideoFileHelper", 1, "downloadFile error: filePath is null");
            return;
        }
        if (e(g16)) {
            QLog.e("MaskAdAlphaVideoFileHelper", 1, "downloadFile cancel: filePath is exist:", g16);
            a aVar = weakFileDownloadCallback.get();
            if (aVar != null) {
                aVar.a(g16);
                return;
            }
            return;
        }
        if (mDownloaderInterface == null) {
            mDownloaderInterface = ((IDownloaderFactory) QRoute.api(IDownloaderFactory.class)).getDownloader(1);
        }
        final C7216b c7216b = new C7216b(weakFileDownloadCallback, g16);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.ad.alphavideo.a
            @Override // java.lang.Runnable
            public final void run() {
                b.c(downloadUrl, g16, c7216b);
            }
        }, 128, null, true);
    }

    public final void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            FileUtils.deleteFilesInDirectory(h());
        }
    }
}
