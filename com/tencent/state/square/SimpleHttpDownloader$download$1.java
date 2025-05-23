package com.tencent.state.square;

import com.tencent.state.square.IHttpDownloader;
import com.tencent.state.square.SimpleHttpDownloader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 1})
/* loaded from: classes26.dex */
final class SimpleHttpDownloader$download$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ IDownloadListener $listener;
    final /* synthetic */ IHttpDownloader.Task $task;
    final /* synthetic */ SimpleHttpDownloader this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SimpleHttpDownloader$download$1(SimpleHttpDownloader simpleHttpDownloader, IDownloadListener iDownloadListener, IHttpDownloader.Task task) {
        super(0);
        this.this$0 = simpleHttpDownloader;
        this.$listener = iDownloadListener;
        this.$task = task;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:111:0x02f8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:121:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:122:0x02dc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:169:0x01d7 A[Catch: all -> 0x01e0, SSLPeerUnverifiedException -> 0x0249, TRY_ENTER, TryCatch #19 {SSLPeerUnverifiedException -> 0x0249, all -> 0x01e0, blocks: (B:8:0x0055, B:10:0x005d, B:13:0x0073, B:15:0x007b, B:17:0x0083, B:18:0x0098, B:20:0x00c5, B:22:0x00c9, B:25:0x00d0, B:27:0x00d4, B:29:0x0114, B:31:0x012d, B:167:0x0190, B:169:0x01d7, B:170:0x01df), top: B:7:0x0055 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00c5 A[Catch: all -> 0x01e0, SSLPeerUnverifiedException -> 0x0249, TryCatch #19 {SSLPeerUnverifiedException -> 0x0249, all -> 0x01e0, blocks: (B:8:0x0055, B:10:0x005d, B:13:0x0073, B:15:0x007b, B:17:0x0083, B:18:0x0098, B:20:0x00c5, B:22:0x00c9, B:25:0x00d0, B:27:0x00d4, B:29:0x0114, B:31:0x012d, B:167:0x0190, B:169:0x01d7, B:170:0x01df), top: B:7:0x0055 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x029f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:? A[RETURN, SYNTHETIC] */
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void invoke2() {
        File file;
        FileOutputStream fileOutputStream;
        InputStream inputStream;
        Throwable th5;
        IDownloadListener iDownloadListener;
        String message;
        File file2;
        boolean z16;
        String url;
        URLConnection openConnection;
        String ip5;
        boolean contains$default;
        File parentFile;
        this.$listener.onTaskStart();
        File file3 = new File(this.$task.getSavePath());
        if (!file3.exists() && (parentFile = file3.getParentFile()) != null) {
            parentFile.mkdirs();
        }
        SquareBaseKt.getSquareLog().i("Square_SimpleHttpDownloader", "result\uff1a" + file3.getAbsolutePath() + ", download: " + this.$task);
        boolean z17 = false;
        InputStream inputStream2 = null;
        r5 = null;
        r5 = null;
        inputStream2 = null;
        FileOutputStream fileOutputStream2 = null;
        FileOutputStream fileOutputStream3 = null;
        try {
        } catch (SSLPeerUnverifiedException e16) {
            e = e16;
            inputStream = null;
            file = null;
        } catch (Throwable th6) {
            th = th6;
            file = null;
            fileOutputStream = null;
        }
        if (this.this$0.needIpConnect()) {
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) this.$task.getUrl(), (CharSequence) this.this$0.getReplaceHost(), false, 2, (Object) null);
            if (contains$default) {
                z16 = true;
                url = this.$task.getUrl();
                if (z16 && (ip5 = this.this$0.getIp()) != null) {
                    url = StringsKt__StringsJVMKt.replaceFirst$default(this.$task.getUrl(), this.this$0.getReplaceHost(), ip5, false, 4, (Object) null);
                }
                SquareBaseKt.getSquareLog().i("Square_SimpleHttpDownloader", "download needIpConnect:" + z16 + " requestUrl:" + url);
                openConnection = new URL(url).openConnection();
                if (openConnection == null) {
                    final HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
                    if (z16) {
                        if (((HttpsURLConnection) (!(httpURLConnection instanceof HttpsURLConnection) ? null : httpURLConnection)) != null) {
                            httpURLConnection.setRequestProperty("Host", this.this$0.getReplaceHost());
                            ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(new SimpleHttpDownloader.SniSSLSocketFactory((HttpsURLConnection) httpURLConnection));
                            ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(new HostnameVerifier() { // from class: com.tencent.state.square.SimpleHttpDownloader$download$1$$special$$inlined$let$lambda$1
                                @Override // javax.net.ssl.HostnameVerifier
                                public final boolean verify(String str, SSLSession sSLSession) {
                                    return HttpsURLConnection.getDefaultHostnameVerifier().verify(SimpleHttpDownloader$download$1.this.this$0.getReplaceHost(), sSLSession);
                                }
                            });
                            SquareBaseKt.getSquareLog().i("Square_SimpleHttpDownloader", "set ssl:" + this.$task);
                        }
                    }
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.setConnectTimeout(10000);
                    httpURLConnection.setReadTimeout(10000);
                    httpURLConnection.connect();
                    if (httpURLConnection.getResponseCode() == 200) {
                        file = this.this$0.getTmpFile(this.$task);
                        try {
                            this.$listener.onTaskResponse(httpURLConnection.getContentLength());
                            inputStream = httpURLConnection.getInputStream();
                            try {
                                fileOutputStream = new FileOutputStream(file);
                                try {
                                    byte[] bArr = new byte[2048];
                                    int read = inputStream.read(bArr);
                                    long j3 = 0;
                                    while (read >= 0) {
                                        long j16 = j3 + read;
                                        this.$listener.onTaskProgress(file, bArr, read, j16);
                                        fileOutputStream.write(bArr, 0, read);
                                        read = inputStream.read(bArr);
                                        j3 = j16;
                                    }
                                    fileOutputStream.flush();
                                    this.$listener.onDownloadFinish(file);
                                    z17 = this.$listener.onTaskCheckFile(file);
                                    fileOutputStream2 = fileOutputStream;
                                } catch (SSLPeerUnverifiedException e17) {
                                    e = e17;
                                    fileOutputStream3 = fileOutputStream;
                                    try {
                                        SquareBaseKt.getSquareLog().e("Square_SimpleHttpDownloader", "SSLPeerUnverifiedException error: ", e);
                                        IDownloadListener iDownloadListener2 = this.$listener;
                                        String message2 = e.getMessage();
                                        if (message2 == null) {
                                            message2 = "";
                                        }
                                        iDownloadListener2.onTaskFailed(-5, message2);
                                        if (fileOutputStream3 != null) {
                                            try {
                                                fileOutputStream3.close();
                                            } catch (Throwable th7) {
                                                SquareBaseKt.getSquareLog().e("Square_SimpleHttpDownloader", "close stream error", th7);
                                                IDownloadListener iDownloadListener3 = this.$listener;
                                                String message3 = th7.getMessage();
                                                if (message3 == null) {
                                                    message3 = "";
                                                }
                                                iDownloadListener3.onTaskFailed(-4, message3);
                                            }
                                        }
                                        if (inputStream != null) {
                                            try {
                                                inputStream.close();
                                            } catch (Throwable th8) {
                                                SquareBaseKt.getSquareLog().e("Square_SimpleHttpDownloader", "close stream error", th8);
                                                iDownloadListener = this.$listener;
                                                message = th8.getMessage();
                                                if (message == null) {
                                                    message = "";
                                                }
                                                iDownloadListener.onTaskFailed(-4, message);
                                                file2 = file;
                                                if (file2 == null) {
                                                }
                                            }
                                        }
                                        file2 = file;
                                        if (file2 == null) {
                                        }
                                    } catch (Throwable th9) {
                                        th5 = th9;
                                        fileOutputStream = fileOutputStream3;
                                        inputStream2 = inputStream;
                                        if (fileOutputStream != null) {
                                        }
                                        if (inputStream2 == null) {
                                        }
                                    }
                                } catch (Throwable th10) {
                                    th = th10;
                                    inputStream2 = inputStream;
                                    try {
                                        SquareBaseKt.getSquareLog().e("Square_SimpleHttpDownloader", "download error: " + th.getMessage(), th);
                                        IDownloadListener iDownloadListener4 = this.$listener;
                                        String message4 = th.getMessage();
                                        if (message4 == null) {
                                            message4 = "";
                                        }
                                        iDownloadListener4.onTaskFailed(-1, message4);
                                        if (fileOutputStream != null) {
                                            try {
                                                fileOutputStream.close();
                                            } catch (Throwable th11) {
                                                SquareBaseKt.getSquareLog().e("Square_SimpleHttpDownloader", "close stream error", th11);
                                                IDownloadListener iDownloadListener5 = this.$listener;
                                                String message5 = th11.getMessage();
                                                if (message5 == null) {
                                                    message5 = "";
                                                }
                                                iDownloadListener5.onTaskFailed(-4, message5);
                                            }
                                        }
                                        if (inputStream2 != null) {
                                            try {
                                                inputStream2.close();
                                            } catch (Throwable th12) {
                                                SquareBaseKt.getSquareLog().e("Square_SimpleHttpDownloader", "close stream error", th12);
                                                iDownloadListener = this.$listener;
                                                message = th12.getMessage();
                                                if (message == null) {
                                                    message = "";
                                                }
                                                iDownloadListener.onTaskFailed(-4, message);
                                                file2 = file;
                                                if (file2 == null) {
                                                }
                                            }
                                        }
                                        file2 = file;
                                        if (file2 == null) {
                                        }
                                    } catch (Throwable th13) {
                                        th5 = th13;
                                        if (fileOutputStream != null) {
                                            try {
                                                fileOutputStream.close();
                                            } catch (Throwable th14) {
                                                SquareBaseKt.getSquareLog().e("Square_SimpleHttpDownloader", "close stream error", th14);
                                                IDownloadListener iDownloadListener6 = this.$listener;
                                                String message6 = th14.getMessage();
                                                if (message6 == null) {
                                                    message6 = "";
                                                }
                                                iDownloadListener6.onTaskFailed(-4, message6);
                                            }
                                        }
                                        if (inputStream2 == null) {
                                            try {
                                                inputStream2.close();
                                                throw th5;
                                            } catch (Throwable th15) {
                                                SquareBaseKt.getSquareLog().e("Square_SimpleHttpDownloader", "close stream error", th15);
                                                IDownloadListener iDownloadListener7 = this.$listener;
                                                String message7 = th15.getMessage();
                                                iDownloadListener7.onTaskFailed(-4, message7 != null ? message7 : "");
                                                throw th5;
                                            }
                                        }
                                        throw th5;
                                    }
                                }
                            } catch (SSLPeerUnverifiedException e18) {
                                e = e18;
                            } catch (Throwable th16) {
                                th = th16;
                                fileOutputStream = null;
                            }
                        } catch (SSLPeerUnverifiedException e19) {
                            e = e19;
                            inputStream = null;
                        } catch (Throwable th17) {
                            th = th17;
                            fileOutputStream = null;
                        }
                    } else {
                        this.$listener.onTaskFailed(httpURLConnection.getResponseCode(), "\u8fde\u63a5\u51fa\u9519");
                        inputStream = null;
                        file = null;
                    }
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (Throwable th18) {
                            SquareBaseKt.getSquareLog().e("Square_SimpleHttpDownloader", "close stream error", th18);
                            IDownloadListener iDownloadListener8 = this.$listener;
                            String message8 = th18.getMessage();
                            if (message8 == null) {
                                message8 = "";
                            }
                            iDownloadListener8.onTaskFailed(-4, message8);
                        }
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable th19) {
                            SquareBaseKt.getSquareLog().e("Square_SimpleHttpDownloader", "close stream error", th19);
                            iDownloadListener = this.$listener;
                            message = th19.getMessage();
                            if (message == null) {
                                message = "";
                            }
                            iDownloadListener.onTaskFailed(-4, message);
                            file2 = file;
                            if (file2 == null) {
                            }
                        }
                    }
                    file2 = file;
                    if (file2 == null) {
                        try {
                            if (z17) {
                                FilesKt.copyTo$default(file2, file3, true, 0, 4, null);
                                this.$listener.onTaskSuccess(file3);
                            } else {
                                this.$listener.onTaskFailed(-3, "\u68c0\u67e5\u6587\u4ef6\u975e\u6cd5");
                            }
                            file2.delete();
                            return;
                        } catch (Exception e26) {
                            SquareBaseKt.getSquareLog().e("Square_SimpleHttpDownloader", "temp failed: ", e26);
                            IDownloadListener iDownloadListener9 = this.$listener;
                            String message9 = e26.getMessage();
                            iDownloadListener9.onTaskFailed(-2, message9 != null ? message9 : "");
                            return;
                        }
                    }
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type java.net.HttpURLConnection");
            }
        }
        z16 = false;
        url = this.$task.getUrl();
        if (z16) {
            url = StringsKt__StringsJVMKt.replaceFirst$default(this.$task.getUrl(), this.this$0.getReplaceHost(), ip5, false, 4, (Object) null);
        }
        SquareBaseKt.getSquareLog().i("Square_SimpleHttpDownloader", "download needIpConnect:" + z16 + " requestUrl:" + url);
        openConnection = new URL(url).openConnection();
        if (openConnection == null) {
        }
    }
}
