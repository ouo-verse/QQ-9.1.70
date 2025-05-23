package com.tencent.mobileqq.aio.panel.debug;

import android.text.TextUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqnt.aio.utils.m;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Random;
import javax.net.ssl.HttpsURLConnection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt__UtilsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0002J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\f\u001a\u00020\nH\u0002J\u0018\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0002J\u0018\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0002J\u0018\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\u0016\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bJ\u0016\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bJ\u0016\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bJ\u0016\u0010\u001b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/aio/panel/debug/DebugFileSender;", "", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, DomainData.DOMAIN_NAME, WadlProxyConsts.PARAM_FILENAME, "i", "path", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "", "o", "t", "", "size", "", "l", "k", "url", tl.h.F, "httpsUrl", "Ljava/io/OutputStream;", "outputStream", "j", "p", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "r", ReportConstant.COSTREPORT_PREFIX, "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class DebugFileSender {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final DebugFileSender f193020a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(64412);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            f193020a = new DebugFileSender();
        }
    }

    DebugFileSender() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final String h(String url, String path) {
        try {
            File parentFile = new File(path).getParentFile();
            if (parentFile != null) {
                parentFile.mkdirs();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            try {
                if (!f193020a.j(url, fileOutputStream)) {
                    m.f352305a.d(path);
                    CloseableKt.closeFinally(fileOutputStream, null);
                    return "";
                }
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(fileOutputStream, null);
                return path;
            } finally {
            }
        } catch (IOException unused) {
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String i(String fileName) {
        String str = null;
        File externalFilesDir = BaseApplication.getContext().getExternalFilesDir(null);
        if (externalFilesDir != null) {
            str = externalFilesDir.getAbsolutePath();
        }
        if (str == null) {
            return "";
        }
        return str + "/debug/send_file/" + fileName;
    }

    private final boolean j(String httpsUrl, OutputStream outputStream) {
        HttpsURLConnection httpsURLConnection;
        HttpsURLConnection httpsURLConnection2 = null;
        try {
            URLConnection openConnection = new URL(httpsUrl).openConnection();
            Intrinsics.checkNotNull(openConnection, "null cannot be cast to non-null type javax.net.ssl.HttpsURLConnection");
            httpsURLConnection = (HttpsURLConnection) openConnection;
        } catch (IOException unused) {
        } catch (Throwable th5) {
            th = th5;
        }
        try {
            httpsURLConnection.setDoInput(true);
            httpsURLConnection.setUseCaches(true);
            httpsURLConnection.setRequestMethod("GET");
            httpsURLConnection.connect();
            if (httpsURLConnection.getResponseCode() != 200) {
                httpsURLConnection.disconnect();
                return false;
            }
            try {
                byte[] bArr = new byte[8196];
                while (true) {
                    int read = httpsURLConnection.getInputStream().read(bArr);
                    if (read != -1) {
                        outputStream.write(bArr, 0, read);
                    } else {
                        Unit unit = Unit.INSTANCE;
                        CloseableKt.closeFinally(outputStream, null);
                        httpsURLConnection.disconnect();
                        return true;
                    }
                }
            } finally {
            }
        } catch (IOException unused2) {
            httpsURLConnection2 = httpsURLConnection;
            if (httpsURLConnection2 != null) {
                httpsURLConnection2.disconnect();
            }
            return false;
        } catch (Throwable th6) {
            th = th6;
            httpsURLConnection2 = httpsURLConnection;
            if (httpsURLConnection2 != null) {
                httpsURLConnection2.disconnect();
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String k(String path) {
        String nameWithoutExtension;
        String extension;
        try {
            long currentTimeMillis = System.currentTimeMillis();
            File file = new File(path);
            String parent = file.getParent();
            nameWithoutExtension = FilesKt__UtilsKt.getNameWithoutExtension(file);
            extension = FilesKt__UtilsKt.getExtension(file);
            String str = parent + "/" + nameWithoutExtension + "_" + currentTimeMillis + "." + extension;
            if (!com.tencent.qqnt.util.file.a.b(path, str)) {
                return "";
            }
            Random random = new Random(currentTimeMillis);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str, true));
            try {
                bufferedOutputStream.write((int) currentTimeMillis);
                for (int i3 = 1; i3 < 1000001; i3++) {
                    bufferedOutputStream.write(random.nextInt());
                }
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(bufferedOutputStream, null);
                return str;
            } finally {
            }
        } catch (IOException unused) {
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean l(String path, int size) {
        try {
            Random random = new Random(System.currentTimeMillis());
            File parentFile = new File(path).getParentFile();
            if (parentFile != null) {
                parentFile.mkdirs();
            }
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(path));
            if (1 <= size) {
                int i3 = 1;
                while (true) {
                    try {
                        bufferedOutputStream.write(random.nextInt());
                        if (i3 == size) {
                            break;
                        }
                        i3++;
                    } finally {
                    }
                }
            }
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(bufferedOutputStream, null);
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String m() {
        String i3 = i("pic-normal.jpeg");
        if (!m.f352305a.f(i3)) {
            String h16 = h("https://static-res.qq.com/static-res/ark/template/demo/pic-normal.jpeg", i3);
            if (!m.e(h16)) {
                return "";
            }
            return h16;
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String n() {
        String i3 = i("video.mp4");
        m mVar = m.f352305a;
        if (!mVar.f(i3)) {
            String h16 = h("https://static-res.qq.com/static-res/clivia/welcome.mp4", i3);
            if (!mVar.f(h16)) {
                return "";
            }
            return h16;
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o(String path, com.tencent.aio.api.runtime.a aioContext) {
        if (!TextUtils.isEmpty(path)) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new DebugFileSender$realSendMsg$1(aioContext, path, null), 3, null);
        } else {
            t();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t() {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new DebugFileSender$showError$1(null), 3, null);
    }

    public final void p(@NotNull String path, @NotNull com.tencent.aio.api.runtime.a aioContext) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) path, (Object) aioContext);
            return;
        }
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new DebugFileSender$sendFile$1(path, aioContext, null), 3, null);
    }

    public final void q(@NotNull String path, @NotNull com.tencent.aio.api.runtime.a aioContext) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) path, (Object) aioContext);
            return;
        }
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new DebugFileSender$sendNewFile$1(path, aioContext, null), 3, null);
    }

    public final void r(@NotNull String path, @NotNull com.tencent.aio.api.runtime.a aioContext) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) path, (Object) aioContext);
            return;
        }
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new DebugFileSender$sendPic$1(path, aioContext, null), 3, null);
    }

    public final void s(@NotNull String path, @NotNull com.tencent.aio.api.runtime.a aioContext) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) path, (Object) aioContext);
            return;
        }
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new DebugFileSender$sendVideo$1(path, aioContext, null), 3, null);
    }
}
