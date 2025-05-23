package com.tencent.qqnt.emotion.stickerrecommended.config;

import android.os.Looper;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJP\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0007\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qqnt/emotion/stickerrecommended/config/b;", "", "", "url", "saveDir", WadlProxyConsts.PARAM_FILENAME, "Lkotlin/Function1;", "", "onSuccess", "onFailure", "a", "<init>", "()V", "emotion_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f356509a;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/qqnt/emotion/stickerrecommended/config/b$a", "Lokhttp3/Callback;", "Lokhttp3/Call;", "call", "Ljava/io/IOException;", "e", "", "onFailure", "Lokhttp3/Response;", "response", "onResponse", "emotion_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class a implements Callback {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f356510a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f356511b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Function1<String, Unit> f356512c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function1<String, Unit> f356513d;

        a(String str, String str2, Function1<? super String, Unit> function1, Function1<? super String, Unit> function12) {
            this.f356510a = str;
            this.f356511b = str2;
            this.f356512c = function1;
            this.f356513d = function12;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, str2, function1, function12);
            }
        }

        @Override // okhttp3.Callback
        public void onFailure(@NotNull Call call, @NotNull IOException e16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) call, (Object) e16);
                return;
            }
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(e16, "e");
            c cVar = c.f356514a;
            cVar.b(cVar.e(this.f356510a));
            File e17 = cVar.e(this.f356510a + this.f356511b);
            Function1<String, Unit> function1 = this.f356512c;
            if (function1 != null) {
                String absolutePath = e17.getAbsolutePath();
                Intrinsics.checkNotNullExpressionValue(absolutePath, "it.absolutePath");
                function1.invoke(absolutePath);
            }
        }

        @Override // okhttp3.Callback
        public void onResponse(@NotNull Call call, @NotNull Response response) {
            InputStream byteStream;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) call, (Object) response);
                return;
            }
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(response, "response");
            if (QLog.isDevelopLevel()) {
                QLog.d("FileDownloadUtil", 4, "isMainThread: " + Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper()));
            }
            c cVar = c.f356514a;
            cVar.b(cVar.e(this.f356510a));
            File e16 = cVar.e(this.f356510a + this.f356511b);
            ResponseBody body = response.body();
            if (body != null && (byteStream = body.byteStream()) != null) {
                Function1<String, Unit> function1 = this.f356513d;
                Function1<String, Unit> function12 = this.f356512c;
                if (cVar.d(byteStream, e16)) {
                    if (function1 != null) {
                        String absolutePath = e16.getAbsolutePath();
                        Intrinsics.checkNotNullExpressionValue(absolutePath, "saveFile.absolutePath");
                        function1.invoke(absolutePath);
                        return;
                    }
                    return;
                }
                if (function12 != null) {
                    String absolutePath2 = e16.getAbsolutePath();
                    Intrinsics.checkNotNullExpressionValue(absolutePath2, "saveFile.absolutePath");
                    function12.invoke(absolutePath2);
                    return;
                }
                return;
            }
            Function1<String, Unit> function13 = this.f356512c;
            if (function13 != null) {
                String absolutePath3 = e16.getAbsolutePath();
                Intrinsics.checkNotNullExpressionValue(absolutePath3, "saveFile.absolutePath");
                function13.invoke(absolutePath3);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(31581);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f356509a = new b();
        }
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @JvmStatic
    public static final void a(@NotNull String url, @NotNull String saveDir, @NotNull String fileName, @Nullable Function1<? super String, Unit> onSuccess, @Nullable Function1<? super String, Unit> onFailure) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(saveDir, "saveDir");
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        File e16 = c.f356514a.e(saveDir + fileName);
        if (e16.isFile() && e16.exists()) {
            if (QLog.isColorLevel()) {
                QLog.i("FileDownloadUtil", 2, "startDownload download file is exists");
            }
            if (onSuccess != null) {
                String absolutePath = e16.getAbsolutePath();
                Intrinsics.checkNotNullExpressionValue(absolutePath, "downloadFile.absolutePath");
                onSuccess.invoke(absolutePath);
                return;
            }
            return;
        }
        new OkHttpClient.Builder().build().newCall(new Request.Builder().url(url).build()).enqueue(new a(saveDir, fileName, onFailure, onSuccess));
    }
}
