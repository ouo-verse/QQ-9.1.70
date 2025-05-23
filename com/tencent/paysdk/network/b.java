package com.tencent.paysdk.network;

import com.tencent.ark.ark;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.paysdk.api.k;
import com.tencent.paysdk.api.m;
import com.tencent.paysdk.network.RequestWrapper;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.fileupload.FileUploadBase;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/paysdk/network/b;", "Lcom/tencent/paysdk/api/k;", "Lcom/tencent/paysdk/api/m;", "a", "<init>", "()V", "tencentvideo_pay_sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes22.dex */
public final class b implements k {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b)\u0010*J\u0018\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u0018\u0010\r\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002H\u0016J\u0018\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0002H\u0016J\u0010\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0002H\u0016R\"\u0010\u001b\u001a\u00020\u00158\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\"\u001a\u00020\u001c8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010(\u001a\u00020\u00028\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\r\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'\u00a8\u0006+"}, d2 = {"Lcom/tencent/paysdk/network/b$a;", "Lcom/tencent/paysdk/api/m;", "", "key", "value", "a", "url", "b", "referKey", "refer", "f", "cookieKey", "cookie", "c", "mediaType", ark.ARKMETADATA_JSON, "d", "Lcom/tencent/paysdk/network/RequestWrapper$RequestType;", "type", "e", Const.BUNDLE_KEY_REQUEST, "Ljava/net/HttpURLConnection;", "Ljava/net/HttpURLConnection;", "getMUrlConnection", "()Ljava/net/HttpURLConnection;", "setMUrlConnection", "(Ljava/net/HttpURLConnection;)V", "mUrlConnection", "Ljava/net/URL;", "Ljava/net/URL;", "getMURL", "()Ljava/net/URL;", "setMURL", "(Ljava/net/URL;)V", "mURL", "Ljava/lang/String;", "getMJson", "()Ljava/lang/String;", "setMJson", "(Ljava/lang/String;)V", "mJson", "<init>", "()V", "tencentvideo_pay_sdk_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes22.dex */
    private static final class a implements m {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public HttpURLConnection mUrlConnection;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public URL mURL;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        public String mJson;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                iPatchRedirector.redirect((short) 15, (Object) this);
            }
        }

        @Override // com.tencent.paysdk.api.m
        @NotNull
        public m a(@NotNull String key, @NotNull String value) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (m) iPatchRedirector.redirect((short) 7, (Object) this, (Object) key, (Object) value);
            }
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(value, "value");
            HttpURLConnection httpURLConnection = this.mUrlConnection;
            if (httpURLConnection == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mUrlConnection");
            }
            httpURLConnection.addRequestProperty(key, value);
            return this;
        }

        @Override // com.tencent.paysdk.api.m
        @NotNull
        public m b(@NotNull String url) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (m) iPatchRedirector.redirect((short) 8, (Object) this, (Object) url);
            }
            Intrinsics.checkNotNullParameter(url, "url");
            URL url2 = new URL(url);
            this.mURL = url2;
            URLConnection openConnection = url2.openConnection();
            if (openConnection != null) {
                HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
                this.mUrlConnection = httpURLConnection;
                httpURLConnection.setUseCaches(false);
                HttpURLConnection httpURLConnection2 = this.mUrlConnection;
                if (httpURLConnection2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mUrlConnection");
                }
                httpURLConnection2.setInstanceFollowRedirects(true);
                return this;
            }
            throw new NullPointerException("null cannot be cast to non-null type java.net.HttpURLConnection");
        }

        @Override // com.tencent.paysdk.api.m
        @NotNull
        public m c(@NotNull String cookieKey, @NotNull String cookie) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (m) iPatchRedirector.redirect((short) 10, (Object) this, (Object) cookieKey, (Object) cookie);
            }
            Intrinsics.checkNotNullParameter(cookieKey, "cookieKey");
            Intrinsics.checkNotNullParameter(cookie, "cookie");
            HttpURLConnection httpURLConnection = this.mUrlConnection;
            if (httpURLConnection == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mUrlConnection");
            }
            httpURLConnection.addRequestProperty(cookieKey, cookie);
            return this;
        }

        @Override // com.tencent.paysdk.api.m
        @NotNull
        public m d(@NotNull String mediaType, @NotNull String json) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return (m) iPatchRedirector.redirect((short) 11, (Object) this, (Object) mediaType, (Object) json);
            }
            Intrinsics.checkNotNullParameter(mediaType, "mediaType");
            Intrinsics.checkNotNullParameter(json, "json");
            HttpURLConnection httpURLConnection = this.mUrlConnection;
            if (httpURLConnection == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mUrlConnection");
            }
            httpURLConnection.setRequestProperty(FileUploadBase.CONTENT_TYPE, mediaType);
            this.mJson = json;
            return this;
        }

        @Override // com.tencent.paysdk.api.m
        @NotNull
        public m e(@NotNull RequestWrapper.RequestType type) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return (m) iPatchRedirector.redirect((short) 12, (Object) this, (Object) type);
            }
            Intrinsics.checkNotNullParameter(type, "type");
            int i3 = com.tencent.paysdk.network.a.f342044a[type.ordinal()];
            if (i3 != 1) {
                if (i3 == 2) {
                    HttpURLConnection httpURLConnection = this.mUrlConnection;
                    if (httpURLConnection == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mUrlConnection");
                    }
                    httpURLConnection.setRequestMethod("POST");
                }
            } else {
                HttpURLConnection httpURLConnection2 = this.mUrlConnection;
                if (httpURLConnection2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mUrlConnection");
                }
                httpURLConnection2.setRequestMethod("GET");
            }
            return this;
        }

        @Override // com.tencent.paysdk.api.m
        @NotNull
        public m f(@NotNull String referKey, @NotNull String refer) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (m) iPatchRedirector.redirect((short) 9, (Object) this, (Object) referKey, (Object) refer);
            }
            Intrinsics.checkNotNullParameter(referKey, "referKey");
            Intrinsics.checkNotNullParameter(refer, "refer");
            HttpURLConnection httpURLConnection = this.mUrlConnection;
            if (httpURLConnection == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mUrlConnection");
            }
            httpURLConnection.addRequestProperty(referKey, refer);
            return this;
        }

        @Override // com.tencent.paysdk.api.m
        @Nullable
        public String request() throws Exception {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                return (String) iPatchRedirector.redirect((short) 14, (Object) this);
            }
            HttpURLConnection httpURLConnection = this.mUrlConnection;
            if (httpURLConnection == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mUrlConnection");
            }
            httpURLConnection.connect();
            HttpURLConnection httpURLConnection2 = this.mUrlConnection;
            if (httpURLConnection2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mUrlConnection");
            }
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection2.getOutputStream());
            String str = this.mJson;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mJson");
            }
            dataOutputStream.writeBytes(str);
            dataOutputStream.flush();
            dataOutputStream.close();
            HttpURLConnection httpURLConnection3 = this.mUrlConnection;
            if (httpURLConnection3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mUrlConnection");
            }
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection3.getInputStream()));
            StringBuffer stringBuffer = new StringBuffer("");
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                stringBuffer.append(URLDecoder.decode(readLine, "utf-8"));
            }
            bufferedReader.close();
            HttpURLConnection httpURLConnection4 = this.mUrlConnection;
            if (httpURLConnection4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mUrlConnection");
            }
            httpURLConnection4.disconnect();
            return stringBuffer.toString();
        }
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    @Override // com.tencent.paysdk.api.k
    @NotNull
    public m a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (m) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        return new a();
    }
}
