package com.tencent.mobileqq.vasgift.utils;

import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;
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
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0002\u000b\u0010B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ(\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006R\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/vasgift/utils/j;", "", "", "url", "savePath", "filename", "Lcom/tencent/mobileqq/vasgift/utils/j$b;", "callBack", "", "c", "", "a", "I", "latestProcess", "<init>", "()V", "b", "vas-gift-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int latestProcess;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u001a\u0010\n\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH&J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0004H&\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/vasgift/utils/j$b;", "", "", "onStart", "", "progress", "onProgress", "errorCode", "", "errorMsg", "onError", "from", "onSuccess", "vas-gift-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public interface b {
        void onError(int errorCode, @Nullable String errorMsg);

        void onProgress(int progress);

        void onStart();

        void onSuccess(int from);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/vasgift/utils/j$c", "Lokhttp3/Callback;", "Lokhttp3/Call;", "call", "Ljava/io/IOException;", "e", "", "onFailure", "Lokhttp3/Response;", "response", "onResponse", "vas-gift-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class c implements Callback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f312032a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f312033b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f312034c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ j f312035d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ long f312036e;

        c(b bVar, String str, String str2, j jVar, long j3) {
            this.f312032a = bVar;
            this.f312033b = str;
            this.f312034c = str2;
            this.f312035d = jVar;
            this.f312036e = j3;
        }

        @Override // okhttp3.Callback
        public void onFailure(@NotNull Call call, @NotNull IOException e16) {
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(e16, "e");
            this.f312032a.onError(-1, e16.getMessage());
            QLog.i("QQLiveComboResDownloadUtils", 1, "download failed");
        }

        /* JADX WARN: Removed duplicated region for block: B:51:0x011e A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:58:? A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:59:0x010e A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:64:0x00b2 -> B:21:0x010a). Please report as a decompilation issue!!! */
        @Override // okhttp3.Callback
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
            FileOutputStream fileOutputStream;
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(response, "response");
            this.f312032a.onStart();
            byte[] bArr = new byte[2048];
            File file = new File(this.f312033b);
            if (!file.exists()) {
                file.mkdirs();
            }
            InputStream inputStream = null;
            try {
                try {
                    ResponseBody body = response.body();
                    Intrinsics.checkNotNull(body);
                    InputStream byteStream = body.byteStream();
                    try {
                        ResponseBody body2 = response.body();
                        Intrinsics.checkNotNull(body2);
                        long contentLength = body2.getContentLength();
                        fileOutputStream = new FileOutputStream(new File(this.f312033b, this.f312034c));
                        long j3 = 0;
                        while (true) {
                            try {
                                int read = byteStream.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                fileOutputStream.write(bArr, 0, read);
                                j3 += read;
                                int i3 = (int) (((((float) j3) * 1.0f) / ((float) contentLength)) * 100);
                                if (this.f312035d.latestProcess != i3) {
                                    this.f312035d.latestProcess = i3;
                                    this.f312032a.onProgress(i3);
                                }
                            } catch (Exception e16) {
                                e = e16;
                                inputStream = byteStream;
                                try {
                                    e.printStackTrace();
                                    QLog.e("QQLiveComboResDownloadUtils", 1, "download failed : " + e.getMessage());
                                    this.f312032a.onError(-1, e.getMessage());
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (IOException e17) {
                                            this.f312032a.onError(-1, e17.getMessage());
                                        }
                                    }
                                    if (fileOutputStream != null) {
                                        fileOutputStream.close();
                                    }
                                    return;
                                } catch (Throwable th5) {
                                    th = th5;
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (IOException e18) {
                                            this.f312032a.onError(-1, e18.getMessage());
                                        }
                                    }
                                    if (fileOutputStream == null) {
                                        try {
                                            fileOutputStream.close();
                                            throw th;
                                        } catch (IOException e19) {
                                            e19.printStackTrace();
                                            this.f312032a.onError(-1, e19.getMessage());
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
                        QLog.e("QQLiveComboResDownloadUtils", 1, "download success totalTime=" + (System.currentTimeMillis() - this.f312036e));
                        this.f312032a.onSuccess(0);
                        try {
                            byteStream.close();
                        } catch (IOException e26) {
                            this.f312032a.onError(-1, e26.getMessage());
                        }
                        fileOutputStream.close();
                    } catch (Exception e27) {
                        e = e27;
                        fileOutputStream = null;
                    } catch (Throwable th7) {
                        th = th7;
                        fileOutputStream = null;
                    }
                } catch (Exception e28) {
                    e = e28;
                    fileOutputStream = null;
                } catch (Throwable th8) {
                    th = th8;
                    fileOutputStream = null;
                }
            } catch (IOException e29) {
                e29.printStackTrace();
                this.f312032a.onError(-1, e29.getMessage());
            }
        }
    }

    public final void c(@NotNull String url, @Nullable String savePath, @NotNull String filename, @NotNull b callBack) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(filename, "filename");
        Intrinsics.checkNotNullParameter(callBack, "callBack");
        long currentTimeMillis = System.currentTimeMillis();
        QLog.i("QQLiveComboResDownloadUtils", 1, "startTime=" + currentTimeMillis);
        new OkHttpClient().newCall(new Request.Builder().url(url).addHeader("Connection", "close").build()).enqueue(new c(callBack, savePath, filename, this, currentTimeMillis));
    }
}
