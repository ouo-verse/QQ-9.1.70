package com.tencent.qmethod.pandoraex.core.ext.netcap;

import androidx.annotation.Nullable;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okio.BufferedSink;
import okio.Okio;

/* compiled from: P */
/* loaded from: classes22.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    private Request f344101a;

    public l(Request request) {
        this.f344101a = request;
        try {
            a(request.headers(), request.body());
        } catch (Exception e16) {
            com.tencent.qmethod.pandoraex.core.o.d("OkHttpRecorder", "logRequest", e16);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x008b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void a(Headers headers, @Nullable RequestBody requestBody) throws IOException {
        String str;
        long j3;
        String str2;
        long j16;
        Map<String, List<String>> multimap = headers.toMultimap();
        String str3 = "";
        long j17 = 0;
        byte[] bArr = null;
        if (requestBody == null) {
            str = "";
            j3 = 0;
        } else {
            MediaType contentType = requestBody.getContentType();
            try {
                if (contentType != null) {
                    str3 = contentType.getMediaType();
                } else {
                    List<String> list = multimap.get("Content-Type");
                    if (list != null && list.size() > 0) {
                        str3 = list.get(0);
                    }
                }
                j16 = requestBody.contentLength();
                if (j16 <= 0) {
                    try {
                        List<String> list2 = multimap.get("Content-Length");
                        if (list2 != null && list2.size() > 0) {
                            j16 = Long.parseLong(list2.get(0));
                        }
                    } catch (Throwable unused) {
                        j17 = j16;
                        j16 = j17;
                        if (!k.a(this.f344101a.method(), this.f344101a.url().getUrl(), str3, j16)) {
                        }
                        j3 = j16;
                        str = str3;
                        if (!this.f344101a.url().getIsHttps()) {
                        }
                        k.e(str2, this.f344101a.url().getUrl(), multimap, bArr, System.currentTimeMillis(), "OkHttp", str, j3);
                    }
                }
            } catch (Throwable unused2) {
            }
            if (!k.a(this.f344101a.method(), this.f344101a.url().getUrl(), str3, j16)) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                BufferedSink buffer = Okio.buffer(Okio.sink(byteArrayOutputStream));
                requestBody.writeTo(buffer);
                if (buffer.isOpen()) {
                    buffer.flush();
                }
                bArr = byteArrayOutputStream.toByteArray();
            } else {
                com.tencent.qmethod.pandoraex.core.o.a("OkHttpRecorder", "noParseBody " + this.f344101a.url() + " " + str3 + " " + j16);
            }
            j3 = j16;
            str = str3;
        }
        if (!this.f344101a.url().getIsHttps()) {
            str2 = "HTTPS";
        } else {
            str2 = "HTTP";
        }
        k.e(str2, this.f344101a.url().getUrl(), multimap, bArr, System.currentTimeMillis(), "OkHttp", str, j3);
    }
}
