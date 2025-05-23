package com.tencent.qqnt.aio.adapter.api.impl;

import android.net.http.Headers;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IAIOHttpApi;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000 \f2\u00020\u0001:\u0001\rB\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/AIOHttpApiNtImpl;", "Lcom/tencent/qqnt/aio/adapter/api/IAIOHttpApi;", "Ljava/io/File;", "file", "", "makeParentDir", "", "url", "savePath", "download", "<init>", "()V", "Companion", "a", "aio_adapter_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class AIOHttpApiNtImpl implements IAIOHttpApi {
    static IPatchRedirector $redirector_ = null;
    private static final int CONNECTION_TIMEOUT = 5000;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final String TAG = "AIOHttpApiFallback";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/AIOHttpApiNtImpl$a;", "", "", "CONNECTION_TIMEOUT", "I", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_adapter_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.adapter.api.impl.AIOHttpApiNtImpl$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(30753);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public AIOHttpApiNtImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final boolean makeParentDir(File file) {
        try {
            File parentFile = file.getParentFile();
            if (parentFile == null) {
                return false;
            }
            if (parentFile.exists()) {
                return true;
            }
            return parentFile.mkdirs();
        } catch (Exception unused) {
            QLog.i(TAG, 1, "makeParentDir fail, path is " + file);
            return false;
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOHttpApi
    public boolean download(@NotNull String url, @NotNull File savePath) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) url, (Object) savePath)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(savePath, "savePath");
        if (!makeParentDir(savePath)) {
            return false;
        }
        HttpURLConnection httpURLConnection = null;
        try {
            try {
                URLConnection openConnection = new URL(url).openConnection();
                Intrinsics.checkNotNull(openConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
                HttpURLConnection httpURLConnection2 = (HttpURLConnection) openConnection;
                try {
                    httpURLConnection2.setRequestMethod("GET");
                    httpURLConnection2.setRequestProperty("accept", "*/*");
                    httpURLConnection2.setRequestProperty(Headers.CONN_DIRECTIVE, "Keep-Alive");
                    httpURLConnection2.setConnectTimeout(5000);
                    httpURLConnection2.setReadTimeout(5000);
                    httpURLConnection2.connect();
                    if (httpURLConnection2.getResponseCode() != 200) {
                        httpURLConnection2.disconnect();
                        return false;
                    }
                    InputStream inputStream = httpURLConnection2.getInputStream();
                    try {
                        FileOutputStream fileOutputStream = new FileOutputStream(savePath);
                        try {
                            byte[] bArr = new byte[8192];
                            while (true) {
                                int read = inputStream.read(bArr);
                                if (read > 0) {
                                    fileOutputStream.write(bArr, 0, read);
                                } else {
                                    Unit unit = Unit.INSTANCE;
                                    CloseableKt.closeFinally(fileOutputStream, null);
                                    CloseableKt.closeFinally(inputStream, null);
                                    httpURLConnection2.disconnect();
                                    return true;
                                }
                            }
                        } finally {
                        }
                    } finally {
                    }
                } catch (IOException e16) {
                    e = e16;
                    httpURLConnection = httpURLConnection2;
                    QLog.i(TAG, 1, "[download] exception=" + e);
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    return false;
                } catch (Throwable th5) {
                    th = th5;
                    httpURLConnection = httpURLConnection2;
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    throw th;
                }
            } catch (IOException e17) {
                e = e17;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }
}
