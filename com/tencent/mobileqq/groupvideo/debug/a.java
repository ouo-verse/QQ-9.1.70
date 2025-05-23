package com.tencent.mobileqq.groupvideo.debug;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0002\u000b\u0010B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ,\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0006R\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/groupvideo/debug/a;", "", "", "url", "destFileDir", "destFileName", "Lcom/tencent/mobileqq/groupvideo/debug/a$b;", "listener", "", "c", "Lokhttp3/OkHttpClient;", "a", "Lokhttp3/OkHttpClient;", "okHttpClient", "<init>", "()V", "b", "group-video-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    private static a f213764c;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final OkHttpClient okHttpClient;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0005\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/groupvideo/debug/a$a;", "", "Lcom/tencent/mobileqq/groupvideo/debug/a;", "a", "downloadUtil", "Lcom/tencent/mobileqq/groupvideo/debug/a;", "<init>", "()V", "group-video-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.groupvideo.debug.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes12.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        @Nullable
        public final a a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (a) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            if (a.f213764c == null) {
                a.f213764c = new a(null);
            }
            return a.f213764c;
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0018\u0010\f\u001a\u00020\u00042\u000e\u0010\u000b\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\nH&\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/groupvideo/debug/a$b;", "", "Ljava/io/File;", "file", "", "b", "", "progress", "a", "Ljava/lang/Exception;", "Lkotlin/Exception;", "e", "onDownloadFailed", "group-video-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public interface b {
        void a(int progress);

        void b(@Nullable File file);

        void onDownloadFailed(@Nullable Exception e16);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/groupvideo/debug/a$c", "Lokhttp3/Callback;", "Lokhttp3/Call;", "call", "Ljava/io/IOException;", "e", "", "onFailure", "Lokhttp3/Response;", "response", "onResponse", "group-video-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class c implements Callback {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f213766a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f213767b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f213768c;

        c(b bVar, String str, String str2) {
            this.f213766a = bVar;
            this.f213767b = str;
            this.f213768c = str2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, bVar, str, str2);
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
            this.f213766a.onDownloadFailed(e16);
        }

        /* JADX WARN: Removed duplicated region for block: B:55:0x00ac A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:61:? A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:62:0x00a7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // okhttp3.Callback
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onResponse(@NotNull Call call, @NotNull Response response) {
            FileOutputStream fileOutputStream;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) call, (Object) response);
                return;
            }
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(response, "response");
            byte[] bArr = new byte[2048];
            File file = new File(this.f213767b);
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(file, this.f213768c);
            InputStream inputStream = null;
            try {
                ResponseBody body = response.body();
                Intrinsics.checkNotNull(body);
                InputStream byteStream = body.byteStream();
                try {
                    ResponseBody body2 = response.body();
                    Intrinsics.checkNotNull(body2);
                    long contentLength = body2.getContentLength();
                    fileOutputStream = new FileOutputStream(file2);
                    long j3 = 0;
                    int i3 = 0;
                    while (true) {
                        try {
                            int read = byteStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            fileOutputStream.write(bArr, 0, read);
                            j3 += read;
                            int i16 = (int) (((((float) j3) * 1.0f) / ((float) contentLength)) * 100);
                            if (i16 != i3) {
                                this.f213766a.a(i16);
                                i3 = i16;
                            }
                        } catch (Exception e16) {
                            e = e16;
                            inputStream = byteStream;
                            try {
                                this.f213766a.onDownloadFailed(e);
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (IOException unused) {
                                    }
                                }
                                if (fileOutputStream == null) {
                                    return;
                                }
                                fileOutputStream.close();
                            } catch (Throwable th5) {
                                th = th5;
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (IOException unused2) {
                                    }
                                }
                                if (fileOutputStream == null) {
                                    try {
                                        fileOutputStream.close();
                                        throw th;
                                    } catch (IOException unused3) {
                                        throw th;
                                    }
                                }
                                throw th;
                            }
                        } catch (Throwable th6) {
                            th = th6;
                            inputStream = byteStream;
                            if (inputStream != null) {
                            }
                            if (fileOutputStream == null) {
                            }
                        }
                    }
                    fileOutputStream.flush();
                    this.f213766a.b(file2);
                    try {
                        byteStream.close();
                    } catch (IOException unused4) {
                    }
                } catch (Exception e17) {
                    e = e17;
                    fileOutputStream = null;
                } catch (Throwable th7) {
                    th = th7;
                    fileOutputStream = null;
                }
            } catch (Exception e18) {
                e = e18;
                fileOutputStream = null;
            } catch (Throwable th8) {
                th = th8;
                fileOutputStream = null;
            }
            try {
                fileOutputStream.close();
            } catch (IOException unused5) {
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(23980);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
    }

    public final void c(@Nullable String url, @Nullable String destFileDir, @Nullable String destFileName, @NotNull b listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, url, destFileDir, destFileName, listener);
            return;
        }
        Intrinsics.checkNotNullParameter(listener, "listener");
        File file = new File(destFileDir, destFileName);
        if (file.exists()) {
            file.delete();
        }
        try {
            Request.Builder builder = new Request.Builder();
            Intrinsics.checkNotNull(url);
            this.okHttpClient.newCall(builder.url(url).build()).enqueue(new c(listener, destFileDir, destFileName));
        } catch (IOException e16) {
            listener.onDownloadFailed(e16);
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.okHttpClient = new OkHttpClient();
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
