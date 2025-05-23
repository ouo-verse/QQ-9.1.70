package com.tencent.local_edit.andserver.http;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.local_edit.andserver.util.MediaType;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.util.zip.GZIPInputStream;
import org.apache.commons.io.Charsets;
import org.apache.httpcore.Header;
import org.apache.httpcore.HttpEntity;
import org.apache.httpcore.HttpEntityEnclosingRequest;
import org.apache.httpcore.HttpRequest;
import org.apache.httpcore.RequestLine;

/* compiled from: P */
/* loaded from: classes7.dex */
public class j implements com.tencent.local_edit.andserver.http.b {

    /* renamed from: n, reason: collision with root package name */
    private static final q11.a f119799n = new q11.b();

    /* renamed from: a, reason: collision with root package name */
    private HttpRequest f119800a;

    /* renamed from: b, reason: collision with root package name */
    private com.tencent.local_edit.andserver.http.a f119801b;

    /* renamed from: c, reason: collision with root package name */
    private j11.c f119802c;

    /* renamed from: d, reason: collision with root package name */
    private RequestLine f119803d;

    /* renamed from: e, reason: collision with root package name */
    private r11.c f119804e;

    /* renamed from: f, reason: collision with root package name */
    private l f119805f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f119806g;

    /* renamed from: h, reason: collision with root package name */
    private com.tencent.local_edit.andserver.util.f<String, String> f119807h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f119808i;

    /* renamed from: j, reason: collision with root package name */
    private List<MediaType> f119809j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f119810k;

    /* renamed from: l, reason: collision with root package name */
    private com.tencent.local_edit.andserver.util.f<String, String> f119811l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f119812m;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static class b implements e {

        /* renamed from: a, reason: collision with root package name */
        private HttpEntity f119813a;

        @Override // com.tencent.local_edit.andserver.http.e
        @NonNull
        public String a() throws IOException {
            Charset charset;
            MediaType contentType = contentType();
            if (contentType == null) {
                charset = null;
            } else {
                charset = contentType.getCharset();
            }
            if (charset == null) {
                return com.tencent.local_edit.andserver.util.d.g(stream());
            }
            return com.tencent.local_edit.andserver.util.d.h(stream(), charset);
        }

        @Override // com.tencent.local_edit.andserver.http.e
        public String b() {
            Header contentType = this.f119813a.getContentType();
            if (contentType == null) {
                return "";
            }
            return contentType.getValue();
        }

        @Override // com.tencent.local_edit.andserver.http.e
        @Nullable
        public MediaType contentType() {
            Header contentType = this.f119813a.getContentType();
            if (contentType == null) {
                return null;
            }
            return MediaType.valueOf(contentType.getValue());
        }

        @Override // com.tencent.local_edit.andserver.http.e
        public long length() {
            return this.f119813a.getContentLength();
        }

        @Override // com.tencent.local_edit.andserver.http.e
        @NonNull
        public InputStream stream() throws IOException {
            InputStream content = this.f119813a.getContent();
            if (b().toLowerCase().contains("gzip")) {
                return new GZIPInputStream(content);
            }
            return content;
        }

        b(HttpEntity httpEntity) {
            this.f119813a = httpEntity;
        }
    }

    public j(HttpRequest httpRequest, com.tencent.local_edit.andserver.http.a aVar, j11.c cVar, r11.c cVar2) {
        this.f119800a = httpRequest;
        this.f119801b = aVar;
        this.f119802c = cVar;
        this.f119803d = httpRequest.getRequestLine();
        this.f119804e = cVar2;
    }

    private void f() {
        if (this.f119810k) {
            return;
        }
        this.f119809j = new ArrayList();
        Header[] headers = this.f119800a.getHeaders("Accept");
        if (headers != null && headers.length > 0) {
            for (Header header : headers) {
                this.f119809j.addAll(MediaType.parseMediaTypes(header.getValue()));
            }
        }
        if (this.f119809j.isEmpty()) {
            this.f119809j.add(MediaType.ALL);
        }
        this.f119810k = true;
    }

    private void g() {
        String a16;
        if (this.f119812m) {
            return;
        }
        if (!getMethod().allowBody()) {
            this.f119811l = new com.tencent.local_edit.andserver.util.e();
            return;
        }
        if (MediaType.APPLICATION_FORM_URLENCODED.includes(getContentType())) {
            try {
                e body = getBody();
                if (body == null) {
                    a16 = "";
                } else {
                    a16 = body.a();
                }
                this.f119811l = h(a16);
            } catch (Exception unused) {
            }
        }
        if (this.f119811l == null) {
            this.f119811l = new com.tencent.local_edit.andserver.util.e();
        }
        this.f119812m = true;
    }

    @NonNull
    private static com.tencent.local_edit.andserver.util.f<String, String> h(@NonNull String str) {
        com.tencent.local_edit.andserver.util.e eVar = new com.tencent.local_edit.andserver.util.e();
        StringTokenizer stringTokenizer = new StringTokenizer(str, ContainerUtils.FIELD_DELIMITER);
        while (stringTokenizer.hasMoreElements()) {
            String nextToken = stringTokenizer.nextToken();
            int indexOf = nextToken.indexOf(ContainerUtils.KEY_VALUE_DELIMITER);
            if (indexOf > 0 && indexOf < nextToken.length() - 1) {
                eVar.a(nextToken.substring(0, indexOf), com.tencent.local_edit.andserver.util.h.b(nextToken.substring(indexOf + 1), Charsets.toCharset("utf-8")));
            }
        }
        return eVar;
    }

    private void i() {
        if (this.f119808i) {
            return;
        }
        j();
        this.f119807h = this.f119805f.b();
        this.f119808i = true;
    }

    private void j() {
        if (this.f119806g) {
            return;
        }
        String uri = this.f119803d.getUri();
        if (TextUtils.isEmpty(uri)) {
            uri = "/";
        }
        this.f119805f = l.d("scheme://host:ip" + uri).g();
        this.f119806g = true;
    }

    @Override // com.tencent.local_edit.andserver.http.b
    public long a(@NonNull String str) {
        Header firstHeader = this.f119800a.getFirstHeader(str);
        if (firstHeader == null) {
            return -1L;
        }
        String value = firstHeader.getValue();
        long b16 = com.tencent.local_edit.andserver.util.c.b(value);
        if (b16 != -1) {
            return b16;
        }
        throw new IllegalStateException(String.format("The %s cannot be converted to date.", value));
    }

    @Override // com.tencent.local_edit.andserver.http.b
    @Nullable
    public f b(@NonNull String str) {
        return this.f119802c.e(this, str);
    }

    @Override // com.tencent.local_edit.andserver.http.b
    @NonNull
    public List<MediaType> d() {
        f();
        return this.f119809j;
    }

    @Nullable
    public String e(@NonNull String str) {
        i();
        return this.f119807h.b(str);
    }

    @Override // com.tencent.local_edit.andserver.http.a
    @Nullable
    public Object getAttribute(@NonNull String str) {
        return this.f119801b.getAttribute(str);
    }

    @Override // com.tencent.local_edit.andserver.http.b
    @Nullable
    public e getBody() {
        HttpEntity entity;
        if (getMethod().allowBody()) {
            HttpRequest httpRequest = this.f119800a;
            if (!(httpRequest instanceof HttpEntityEnclosingRequest) || (entity = ((HttpEntityEnclosingRequest) httpRequest).getEntity()) == null) {
                return null;
            }
            return new b(entity);
        }
        throw new UnsupportedOperationException("This method does not allow body.");
    }

    @Override // com.tencent.local_edit.andserver.http.b
    @Nullable
    public MediaType getContentType() {
        String header = getHeader("Content-Type");
        if (TextUtils.isEmpty(header)) {
            return null;
        }
        return MediaType.valueOf(header);
    }

    @Override // com.tencent.local_edit.andserver.http.b
    @Nullable
    public String getHeader(@NonNull String str) {
        Header firstHeader = this.f119800a.getFirstHeader(str);
        if (firstHeader == null) {
            return null;
        }
        return firstHeader.getValue();
    }

    @Override // com.tencent.local_edit.andserver.http.b
    @NonNull
    public List<String> getHeaders(@NonNull String str) {
        Header[] headers = this.f119800a.getHeaders(str);
        if (headers != null && headers.length != 0) {
            ArrayList arrayList = new ArrayList();
            for (Header header : headers) {
                arrayList.add(header.getValue());
            }
            return arrayList;
        }
        return Collections.emptyList();
    }

    @Override // com.tencent.local_edit.andserver.http.b
    @NonNull
    public HttpMethod getMethod() {
        return HttpMethod.reverse(this.f119803d.getMethod());
    }

    @Override // com.tencent.local_edit.andserver.http.b
    @Nullable
    public String getParameter(@NonNull String str) {
        g();
        String b16 = this.f119811l.b(str);
        if (TextUtils.isEmpty(b16)) {
            return e(str);
        }
        return b16;
    }

    @Override // com.tencent.local_edit.andserver.http.b
    @NonNull
    public String getPath() {
        j();
        return this.f119805f.c();
    }

    @Override // com.tencent.local_edit.andserver.http.b
    @NonNull
    public String getURI() {
        j();
        return this.f119805f.toString();
    }

    public void k(String str) {
        j();
        this.f119805f = this.f119805f.a().h(str).g();
    }

    @Override // com.tencent.local_edit.andserver.http.a
    public void setAttribute(@NonNull String str, @Nullable Object obj) {
        this.f119801b.setAttribute(str, obj);
    }
}
