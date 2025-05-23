package com.tencent.mobileqq.perf.upload.cos;

import android.util.Log;
import com.tencent.bugly.library.BuglyMonitorName;
import com.tencent.mobileqq.msf.core.auth.k;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__IndentKt;
import kotlin.text.StringsKt__StringsJVMKt;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.Buffer;
import okio.BufferedSink;
import okio.ForwardingSink;
import okio.Okio;
import okio.Sink;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0004\u001b\u001c\u001d\u000fB\t\b\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ(\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002J8\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006H\u0002J\u0016\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0006J(\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u0016\u001a\u00020\u0015J(\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u0016\u001a\u00020\u0015\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/perf/upload/cos/PerfCosUploader;", "", "Ljava/io/File;", "file", "Ljava/net/URL;", "url", "", "host", "fileContentSha1", "Lokhttp3/Response;", "e", "skey", "sid", "uuid", "key_time", "a", "Lcom/tencent/mobileqq/perf/upload/cos/PerfCosUploader$BucketType;", "bucketType", "uploadUuid", "b", "filePath", "", "autoPrefix", "c", "f", "<init>", "()V", "BucketType", "CosUploaderException", "CosUploaderNetWorkException", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class PerfCosUploader {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final PerfCosUploader f258269a;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/perf/upload/cos/PerfCosUploader$BucketType;", "", "bucketName", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getBucketName", "()Ljava/lang/String;", "LEAK_FILE", "QLOG", "MEM", "TRAFFIC", "TRACE", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes16.dex */
    public static final class BucketType {
        private static final /* synthetic */ BucketType[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final BucketType LEAK_FILE;
        public static final BucketType MEM;
        public static final BucketType QLOG;
        public static final BucketType TRACE;
        public static final BucketType TRAFFIC;

        @NotNull
        private final String bucketName;

        private static final /* synthetic */ BucketType[] $values() {
            return new BucketType[]{LEAK_FILE, QLOG, MEM, TRAFFIC, TRACE};
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(47244);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 3)) {
                redirector.redirect((short) 3);
                return;
            }
            LEAK_FILE = new BucketType("LEAK_FILE", 0, "leakfile");
            QLOG = new BucketType("QLOG", 1, "qlog");
            MEM = new BucketType("MEM", 2, "mem");
            TRAFFIC = new BucketType("TRAFFIC", 3, BuglyMonitorName.TRAFFIC);
            TRACE = new BucketType("TRACE", 4, "trace");
            $VALUES = $values();
        }

        BucketType(String str, int i3, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), str2);
            } else {
                this.bucketName = str2;
            }
        }

        public static BucketType valueOf(String str) {
            return (BucketType) Enum.valueOf(BucketType.class, str);
        }

        public static BucketType[] values() {
            return (BucketType[]) $VALUES.clone();
        }

        @NotNull
        public final String getBucketName() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.bucketName;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/perf/upload/cos/PerfCosUploader$CosUploaderException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "msg", "", "(Ljava/lang/String;)V", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes16.dex */
    public static final class CosUploaderException extends Exception {
        static IPatchRedirector $redirector_;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CosUploaderException(@NotNull String msg2) {
            super(msg2);
            Intrinsics.checkNotNullParameter(msg2, "msg");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) msg2);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/perf/upload/cos/PerfCosUploader$CosUploaderNetWorkException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "msg", "", "(Ljava/lang/String;)V", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes16.dex */
    public static final class CosUploaderNetWorkException extends Exception {
        static IPatchRedirector $redirector_;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CosUploaderNetWorkException(@NotNull String msg2) {
            super(msg2);
            Intrinsics.checkNotNullParameter(msg2, "msg");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) msg2);
            }
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0011\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\u0001\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\bH\u0016R\u0014\u0010\r\u001a\u00020\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\"\u0010\u0013\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000b\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0014\u001a\u00020\u00068\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0011\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/perf/upload/cos/PerfCosUploader$a;", "Lokhttp3/RequestBody;", "Lokio/Sink;", "sink", "Lokhttp3/MediaType;", "contentType", "", "contentLength", "Lokio/BufferedSink;", "", "writeTo", "a", "Lokhttp3/RequestBody;", "mRequestBody", "b", "J", "()J", "c", "(J)V", InnerAudioPlugin.AUDIO_PROPERTY_CURRENTTIME, "printInterval", "d", "Lokio/BufferedSink;", "mBufferedSink", "<init>", "(Lokhttp3/RequestBody;)V", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class a extends RequestBody {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final RequestBody mRequestBody;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private long currentTime;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private final long printInterval;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private BufferedSink mBufferedSink;

        @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\"\u0010\u000e\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u0012\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\t\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\r\u00a8\u0006\u0013"}, d2 = {"com/tencent/mobileqq/perf/upload/cos/PerfCosUploader$a$a", "Lokio/ForwardingSink;", "Lokio/Buffer;", "source", "", "byteCount", "", k.f247492f, "d", "J", "getBytesWritten", "()J", "setBytesWritten", "(J)V", "bytesWritten", "e", "getContentLength", "setContentLength", "contentLength", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.perf.upload.cos.PerfCosUploader$a$a, reason: collision with other inner class name */
        /* loaded from: classes16.dex */
        public static final class C8216a extends ForwardingSink {
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name and from kotlin metadata */
            private long bytesWritten;

            /* renamed from: e, reason: collision with root package name and from kotlin metadata */
            private long contentLength;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ a f258276f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C8216a(Sink sink, a aVar) {
                super(sink);
                this.f258276f = aVar;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) sink, (Object) aVar);
                }
            }

            @Override // okio.ForwardingSink, okio.Sink
            public void write(@NotNull Buffer source, long byteCount) throws IOException {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                    iPatchRedirector.redirect((short) 6, this, source, Long.valueOf(byteCount));
                    return;
                }
                Intrinsics.checkNotNullParameter(source, "source");
                super.write(source, byteCount);
                if (this.contentLength == 0) {
                    this.contentLength = this.f258276f.contentLength();
                }
                this.bytesWritten += byteCount;
                if (System.currentTimeMillis() - this.f258276f.a() > this.f258276f.b()) {
                    QLog.i("PerfCosUploader", 1, "onUpdateProgress, writen length: " + this.bytesWritten + ", total length: " + this.contentLength);
                    this.f258276f.c(System.currentTimeMillis());
                }
            }
        }

        public a(@NotNull RequestBody mRequestBody) {
            Intrinsics.checkNotNullParameter(mRequestBody, "mRequestBody");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) mRequestBody);
            } else {
                this.mRequestBody = mRequestBody;
                this.printInterval = 1000L;
            }
        }

        private final Sink sink(Sink sink) {
            return new C8216a(sink, this);
        }

        public final long a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Long) iPatchRedirector.redirect((short) 2, (Object) this)).longValue();
            }
            return this.currentTime;
        }

        public final long b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Long) iPatchRedirector.redirect((short) 4, (Object) this)).longValue();
            }
            return this.printInterval;
        }

        public final void c(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, j3);
            } else {
                this.currentTime = j3;
            }
        }

        @Override // okhttp3.RequestBody
        public long contentLength() throws IOException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Long) iPatchRedirector.redirect((short) 6, (Object) this)).longValue();
            }
            return this.mRequestBody.contentLength();
        }

        @Override // okhttp3.RequestBody
        @Nullable
        /* renamed from: contentType */
        public MediaType getContentType() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (MediaType) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return this.mRequestBody.getContentType();
        }

        @Override // okhttp3.RequestBody
        public void writeTo(@NotNull BufferedSink sink) throws IOException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, (Object) sink);
                return;
            }
            Intrinsics.checkNotNullParameter(sink, "sink");
            try {
                if (this.mBufferedSink == null) {
                    this.mBufferedSink = Okio.buffer(sink(sink));
                }
                BufferedSink bufferedSink = this.mBufferedSink;
                if (bufferedSink != null) {
                    this.mRequestBody.writeTo(bufferedSink);
                    bufferedSink.flush();
                }
            } catch (IllegalStateException e16) {
                Log.e("ProgressRequestBody", "ProgressRequestBody exp:" + e16.getMessage());
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(47257);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            f258269a = new PerfCosUploader();
        }
    }

    PerfCosUploader() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final String a(String skey, String sid, String uuid, String host, String fileContentSha1, String key_time) throws SignatureException, NoSuchAlgorithmException, InvalidKeyException {
        String trimIndent;
        String trimIndent2;
        String trimIndent3;
        String replace$default;
        trimIndent = StringsKt__IndentKt.trimIndent("\n        put\n        " + uuid + "\n\n        host=" + host + "&x-cos-content-sha1=" + fileContentSha1 + "\n        \n    ");
        com.tencent.mobileqq.perf.upload.cos.a aVar = com.tencent.mobileqq.perf.upload.cos.a.f258277a;
        trimIndent2 = StringsKt__IndentKt.trimIndent("\n        sha1\n        " + key_time + "\n        " + aVar.c(trimIndent) + "\n        \n    ");
        trimIndent3 = StringsKt__IndentKt.trimIndent("\n        q-sign-algorithm=sha1\n        &q-ak=" + sid + "\n        &q-sign-time=" + key_time + "\n        &q-key-time=" + key_time + "\n        &q-header-list=host;x-cos-content-sha1\n        &q-url-param-list=\n        &q-signature=" + aVar.a(trimIndent2, aVar.a(key_time, skey)) + "\n    ");
        replace$default = StringsKt__StringsJVMKt.replace$default(trimIndent3, "\n", "", false, 4, (Object) null);
        String encode = URLEncoder.encode(replace$default, "utf-8");
        Intrinsics.checkNotNullExpressionValue(encode, "encode(authorization, \"utf-8\")");
        return encode;
    }

    public static /* synthetic */ String d(PerfCosUploader perfCosUploader, BucketType bucketType, String str, String str2, boolean z16, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            z16 = true;
        }
        return perfCosUploader.c(bucketType, str, str2, z16);
    }

    private final Response e(File file, URL url, String host, String fileContentSha1) {
        return new OkHttpClient.Builder().retryOnConnectionFailure(true).readTimeout(60L, TimeUnit.SECONDS).build().newCall(new Request.Builder().url(url).addHeader("Content-Length", String.valueOf(file.length())).addHeader("Host", host).addHeader("x-cos-content-sha1", fileContentSha1).put(new a(RequestBody.INSTANCE.create(MediaType.INSTANCE.parse("application/zip"), file))).build()).execute();
    }

    @NotNull
    public final String b(@NotNull BucketType bucketType, @NotNull String uploadUuid) {
        boolean startsWith$default;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bucketType, (Object) uploadUuid);
        }
        Intrinsics.checkNotNullParameter(bucketType, "bucketType");
        Intrinsics.checkNotNullParameter(uploadUuid, "uploadUuid");
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(uploadUuid, "/", false, 2, null);
        if (!startsWith$default) {
            return "https://" + bucketType.getBucketName() + "-70657.njc.vod.tencent-cloud.com/" + uploadUuid;
        }
        return "https://" + bucketType.getBucketName() + "-70657.njc.vod.tencent-cloud.com" + uploadUuid;
    }

    @NotNull
    public final String c(@NotNull BucketType bucketType, @NotNull String filePath, @NotNull String uuid, boolean autoPrefix) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, this, bucketType, filePath, uuid, Boolean.valueOf(autoPrefix));
        }
        Intrinsics.checkNotNullParameter(bucketType, "bucketType");
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        try {
            return f(bucketType, filePath, uuid, autoPrefix);
        } catch (CosUploaderException e16) {
            str = "upload failed.";
            QLog.e("PerfCosUploader", 1, "upload failed.", e16);
            return str;
        } catch (CosUploaderNetWorkException e17) {
            str = "network occur upload exception.";
            QLog.e("PerfCosUploader", 1, "network occur upload exception.", e17);
            return str;
        } catch (Throwable th5) {
            QLog.e("PerfCosUploader", 1, "other exception.", th5);
            return "occur other exception.";
        }
    }

    @NotNull
    public final String f(@NotNull BucketType bucketType, @NotNull String filePath, @NotNull String uuid, boolean autoPrefix) throws CosUploaderException, CosUploaderNetWorkException {
        Response response;
        String uuid2 = uuid;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, this, bucketType, filePath, uuid2, Boolean.valueOf(autoPrefix));
        }
        Intrinsics.checkNotNullParameter(bucketType, "bucketType");
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        Intrinsics.checkNotNullParameter(uuid2, "uuid");
        File file = new File(filePath);
        if (file.exists()) {
            if (file.length() <= 314572800) {
                String str = bucketType.getBucketName() + "-70657.njc.vod.tencent-cloud.com";
                long currentTimeMillis = System.currentTimeMillis();
                StringBuilder sb5 = new StringBuilder();
                long j3 = currentTimeMillis / 1000;
                sb5.append(j3);
                sb5.append(';');
                sb5.append(j3 + 60000);
                String sb6 = sb5.toString();
                if (autoPrefix) {
                    uuid2 = "/qq_" + uuid2;
                }
                String str2 = uuid2;
                try {
                    String b16 = com.tencent.mobileqq.perf.upload.cos.a.f258277a.b(file);
                    b bVar = b.f258278a;
                    URL url = new URL("http://" + str + str2 + "?sign=" + a(bVar.b(), bVar.a(), str2, str, b16, sb6));
                    QLog.i("PerfCosUploader", 1, "uploadFileToCos start. file is " + filePath + ", length: " + file.length() + '.');
                    try {
                        response = e(file, url, str, b16);
                    } catch (Exception e16) {
                        QLog.e("PerfCosUploader", 1, e16, new Object[0]);
                        QLog.e("PerfCosUploader", 1, "CosUploaderNetWorkException upload failed. occur Exception.");
                        response = null;
                    }
                    if (response != null && response.code() != 200) {
                        QLog.e("PerfCosUploader", 1, "upload " + filePath + " failed. ");
                        QLog.e("PerfCosUploader", 1, "CosUploaderNetWorkException upload failed. resp.code(): " + response.code() + ". resp.msg(): " + response.message() + '}');
                    }
                    QLog.i("PerfCosUploader", 1, "uploadFileToCos finished. file is " + filePath + ", length: " + file.length() + ", cost: " + (System.currentTimeMillis() - currentTimeMillis) + "ms.");
                    return b(bucketType, str2);
                } catch (Exception unused) {
                    throw new CosUploaderException("sign generate failed.");
                }
            }
            throw new CosUploaderException("upload failed. Because length too big. is " + file.length() + '.');
        }
        throw new CosUploaderException("\u5f85\u4e0a\u4f20 cos \u7684\u6587\u4ef6\u4e0d\u5b58\u5728");
    }
}
