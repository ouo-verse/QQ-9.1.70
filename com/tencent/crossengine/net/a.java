package com.tencent.crossengine.net;

import android.util.Pair;
import com.tencent.crossengine.net.NetworkManager;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.ConnectionPool;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.BufferedSink;
import okio.ByteString;
import okio.Okio;

/* compiled from: P */
/* loaded from: classes32.dex */
class a extends NetworkManager {

    /* renamed from: a, reason: collision with root package name */
    private final OkHttpClient f100490a;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class b implements NetworkManager.HttpRequest {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Call f100494a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ NetworkManager.Callback f100495b;

        b(Call call, NetworkManager.Callback callback) {
            this.f100494a = call;
            this.f100495b = callback;
        }

        @Override // com.tencent.crossengine.net.NetworkManager.HttpRequest
        public void cancel() {
            this.f100494a.cancel();
            this.f100495b.onCancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class c extends RequestBody {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ RequestBody f100497a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ long[] f100498b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ NetworkManager.Callback f100499c;

        /* compiled from: P */
        /* renamed from: com.tencent.crossengine.net.a$c$a, reason: collision with other inner class name */
        /* loaded from: classes32.dex */
        class C1024a extends OutputStream {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ OutputStream f100501d;

            C1024a(OutputStream outputStream) {
                this.f100501d = outputStream;
            }

            @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                this.f100501d.close();
            }

            @Override // java.io.OutputStream, java.io.Flushable
            public void flush() throws IOException {
                this.f100501d.flush();
            }

            @Override // java.io.OutputStream
            public void write(int i3) throws IOException {
                this.f100501d.write(i3);
            }

            @Override // java.io.OutputStream
            public void write(byte[] bArr, int i3, int i16) throws IOException {
                this.f100501d.write(bArr, i3, i16);
                c cVar = c.this;
                long[] jArr = cVar.f100498b;
                if (jArr[0] == 0) {
                    jArr[0] = cVar.f100497a.contentLength();
                }
                c cVar2 = c.this;
                long[] jArr2 = cVar2.f100498b;
                long j3 = jArr2[1] + i16;
                jArr2[1] = j3;
                cVar2.f100499c.onProgress(jArr2[3], jArr2[2], j3, jArr2[0]);
            }
        }

        c(RequestBody requestBody, long[] jArr, NetworkManager.Callback callback) {
            this.f100497a = requestBody;
            this.f100498b = jArr;
            this.f100499c = callback;
        }

        @Override // okhttp3.RequestBody
        public long contentLength() throws IOException {
            return this.f100497a.contentLength();
        }

        @Override // okhttp3.RequestBody
        /* renamed from: contentType */
        public MediaType getContentType() {
            return this.f100497a.getContentType();
        }

        @Override // okhttp3.RequestBody
        public boolean isDuplex() {
            return this.f100497a.isDuplex();
        }

        @Override // okhttp3.RequestBody
        public boolean isOneShot() {
            return this.f100497a.isOneShot();
        }

        @Override // okhttp3.RequestBody
        public void writeTo(BufferedSink bufferedSink) throws IOException {
            BufferedSink buffer = Okio.buffer(Okio.sink(new C1024a(bufferedSink.outputStream())));
            this.f100497a.writeTo(buffer);
            buffer.flush();
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class d extends WebSocketListener {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ NetworkManager.WebSocketDelegate f100503b;

        d(NetworkManager.WebSocketDelegate webSocketDelegate) {
            this.f100503b = webSocketDelegate;
        }

        @Override // okhttp3.WebSocketListener
        public void onClosed(WebSocket webSocket, int i3, String str) {
            this.f100503b.onClose(i3, str);
        }

        @Override // okhttp3.WebSocketListener
        public void onFailure(WebSocket webSocket, Throwable th5, Response response) {
            this.f100503b.onError(th5.getMessage());
        }

        @Override // okhttp3.WebSocketListener
        public void onMessage(WebSocket webSocket, String str) {
            this.f100503b.onMessage(str);
        }

        @Override // okhttp3.WebSocketListener
        public void onOpen(WebSocket webSocket, Response response) {
            this.f100503b.onOpen(a.this.b(response));
        }

        @Override // okhttp3.WebSocketListener
        public void onMessage(WebSocket webSocket, ByteString byteString) {
            this.f100503b.onMessage(byteString.toByteArray(), byteString.size());
        }

        @Override // okhttp3.WebSocketListener
        public void onClosing(WebSocket webSocket, int i3, String str) {
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class e implements NetworkManager.WebSocket {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ WebSocket f100505a;

        e(WebSocket webSocket) {
            this.f100505a = webSocket;
        }

        @Override // com.tencent.crossengine.net.NetworkManager.WebSocket
        public void close(int i3, String str) {
            this.f100505a.close(i3, str);
        }

        @Override // com.tencent.crossengine.net.NetworkManager.WebSocket
        public void sendMessage(String str) {
            this.f100505a.send(str);
        }

        @Override // com.tencent.crossengine.net.NetworkManager.WebSocket
        public void sendMessage(byte[] bArr, int i3) {
            this.f100505a.send(ByteString.of(bArr, 0, i3));
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    static /* synthetic */ class f {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f100507a;

        static {
            int[] iArr = new int[Protocol.values().length];
            f100507a = iArr;
            try {
                iArr[Protocol.HTTP_1_0.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f100507a[Protocol.HTTP_1_1.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f100507a[Protocol.HTTP_2.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f100507a[Protocol.H2_PRIOR_KNOWLEDGE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public a() {
        this(new OkHttpClient.Builder().connectionPool(new ConnectionPool(32, 1L, TimeUnit.MINUTES)).followRedirects(true).build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<Pair<String, String>> b(Response response) {
        ArrayList arrayList = new ArrayList(response.headers().size());
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            arrayList.add(new Pair(response.headers().name(i3), response.headers().value(i3)));
        }
        return arrayList;
    }

    private RequestBody c(NetworkManager.Callback callback, long[] jArr, RequestBody requestBody) {
        return new c(requestBody, jArr, callback);
    }

    @Override // com.tencent.crossengine.net.NetworkManager
    public NetworkManager.HttpRequest performHttpRequest(NetworkManager.HttpRequestData httpRequestData) {
        RequestBody build;
        Request.Builder builder = new Request.Builder();
        builder.url(httpRequestData.url);
        String str = httpRequestData.userAgent;
        if (str != null) {
            builder.addHeader("User-Agent", str);
        }
        for (Pair<String, String> pair : httpRequestData.header) {
            builder.addHeader((String) pair.first, (String) pair.second);
        }
        NetworkManager.Callback callback = httpRequestData.callback;
        long[] jArr = new long[4];
        if (httpRequestData.method == 0) {
            builder.get();
        } else {
            String str2 = httpRequestData.postBody;
            if (str2 != null) {
                build = RequestBody.create((MediaType) null, str2);
            } else {
                MultipartBody.Builder builder2 = new MultipartBody.Builder();
                for (Object obj : httpRequestData.multiParts) {
                    if (obj instanceof NetworkManager.d) {
                        NetworkManager.d dVar = (NetworkManager.d) obj;
                        builder2.addFormDataPart(dVar.f100487a, null, RequestBody.create(d(dVar.f100488b), dVar.f100489c));
                    } else if (obj instanceof NetworkManager.b) {
                        NetworkManager.b bVar = (NetworkManager.b) obj;
                        builder2.addFormDataPart(bVar.f100480a, null, RequestBody.create(d(bVar.f100481b), bVar.f100482c));
                    } else if (obj instanceof NetworkManager.c) {
                        NetworkManager.c cVar = (NetworkManager.c) obj;
                        builder2.addFormDataPart(cVar.f100483a, cVar.f100486d, RequestBody.create(d(cVar.f100484b), new File(cVar.f100485c)));
                    }
                }
                builder2.setType(MultipartBody.FORM);
                build = builder2.build();
            }
            builder.post(c(callback, jArr, build));
        }
        Call newCall = this.f100490a.newCall(builder.build());
        if (httpRequestData.timeout != 0) {
            newCall.timeout().timeout(httpRequestData.timeout, TimeUnit.MILLISECONDS);
        }
        newCall.enqueue(new C1023a(callback, jArr));
        return new b(newCall, callback);
    }

    @Override // com.tencent.crossengine.net.NetworkManager
    public NetworkManager.WebSocket performWebSocketRequest(NetworkManager.WebSocketRequestData webSocketRequestData) {
        Request.Builder builder = new Request.Builder();
        builder.url(webSocketRequestData.url);
        String str = webSocketRequestData.userAgent;
        if (str != null) {
            builder.addHeader("User-Agent", str);
        }
        for (Pair<String, String> pair : webSocketRequestData.header) {
            builder.addHeader((String) pair.first, (String) pair.second);
        }
        if (!webSocketRequestData.protocols.isEmpty()) {
            Iterator<String> it = webSocketRequestData.protocols.iterator();
            while (it.hasNext()) {
                builder.addHeader("Sec-WebSocket-Protocol", it.next());
            }
        }
        return new e(this.f100490a.newWebSocket(builder.build(), new d(webSocketRequestData.delegate)));
    }

    /* compiled from: P */
    /* renamed from: com.tencent.crossengine.net.a$a, reason: collision with other inner class name */
    /* loaded from: classes32.dex */
    class C1023a implements Callback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ NetworkManager.Callback f100491a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ long[] f100492b;

        C1023a(NetworkManager.Callback callback, long[] jArr) {
            this.f100491a = callback;
            this.f100492b = jArr;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            NetworkManager.Callback callback = this.f100491a;
            if (callback != null) {
                callback.onError(iOException.getMessage());
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:23:0x007a, code lost:
        
            throw new java.io.IOException("writeResponseContent failure " + r26.request().url());
         */
        /* JADX WARN: Removed duplicated region for block: B:56:0x00b4  */
        /* JADX WARN: Removed duplicated region for block: B:58:0x00b9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:65:? A[SYNTHETIC] */
        @Override // okhttp3.Callback
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onResponse(Call call, Response response) {
            Throwable th5;
            Call call2;
            InputStream inputStream;
            NetworkManager.Callback callback;
            List<Pair<String, String>> b16 = a.this.b(response);
            NetworkManager.Callback callback2 = this.f100491a;
            if (callback2 != null) {
                callback2.onHeader(b16);
            }
            int i3 = 3;
            if (response.body() != null) {
                byte[] bArr = new byte[8192];
                InputStream inputStream2 = null;
                try {
                    try {
                        inputStream = response.body().byteStream();
                    } catch (IOException e16) {
                        e = e16;
                        call2 = call;
                        inputStream = null;
                    } catch (Throwable th6) {
                        th5 = th6;
                        callback = this.f100491a;
                        if (callback != null) {
                        }
                        if (0 == 0) {
                        }
                    }
                    try {
                        this.f100492b[2] = response.body().contentLength();
                        while (true) {
                            int read = inputStream.read(bArr);
                            if (read > 0) {
                                NetworkManager.Callback callback3 = this.f100491a;
                                if (callback3 != null) {
                                    long j3 = read;
                                    if (callback3.writeResponseContent(bArr, read) < j3) {
                                        break;
                                    }
                                    long[] jArr = this.f100492b;
                                    long j16 = jArr[3] + j3;
                                    jArr[3] = j16;
                                    this.f100491a.onProgress(j16, jArr[2], jArr[1], jArr[0]);
                                }
                            } else {
                                NetworkManager.Callback callback4 = this.f100491a;
                                if (callback4 != null) {
                                    callback4.writeResponseContent(null, 0);
                                }
                                try {
                                    inputStream.close();
                                } catch (IOException e17) {
                                    e17.printStackTrace();
                                }
                            }
                        }
                    } catch (IOException e18) {
                        e = e18;
                        call2 = call;
                        onFailure(call2, e);
                        NetworkManager.Callback callback5 = this.f100491a;
                        if (callback5 != null) {
                            callback5.writeResponseContent(null, 0);
                        }
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                                return;
                            } catch (IOException e19) {
                                e19.printStackTrace();
                                return;
                            }
                        }
                        return;
                    }
                } catch (Throwable th7) {
                    th5 = th7;
                    callback = this.f100491a;
                    if (callback != null) {
                        callback.writeResponseContent(null, 0);
                    }
                    if (0 == 0) {
                        try {
                            inputStream2.close();
                            throw th5;
                        } catch (IOException e26) {
                            e26.printStackTrace();
                            throw th5;
                        }
                    }
                    throw th5;
                }
            }
            if (this.f100491a != null) {
                int i16 = f.f100507a[response.protocol().ordinal()];
                if (i16 == 1) {
                    i3 = 1;
                } else if (i16 == 2 || (i16 != 3 && i16 != 4)) {
                    i3 = 2;
                }
                this.f100491a.onResponse(call.request().url().getUrl(), response.code(), b16, i3);
            }
        }
    }

    private MediaType d(String str) {
        if (str == null) {
            return null;
        }
        return MediaType.parse(str);
    }

    public a(OkHttpClient okHttpClient) {
        this.f100490a = okHttpClient;
    }
}
