package com.tencent.qqnt.http.api;

import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.comic.data.ComicCancelRedPointPopItemData;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.live2.impl.V2TXLiveProperty;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.io.File;
import java.io.OutputStream;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00b6\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 \u008d\u00012\u00020\u0001:\u0002\f\u0011B\u0013\u0012\b\u0010\u008a\u0001\u001a\u00030\u0089\u0001\u00a2\u0006\u0006\b\u008b\u0001\u0010\u008c\u0001J\u0006\u0010\u0003\u001a\u00020\u0002J%\u0010\u0007\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00042\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0005\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\n\u001a\u00020\tH\u0016R\u0017\u0010\u0010\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0015\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0018\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0012\u001a\u0004\b\u0017\u0010\u0014R\u0019\u0010\u001d\u001a\u0004\u0018\u00010\u00198\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001a\u0010\u001cR\u0017\u0010\"\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0017\u0010$\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b \u0010\r\u001a\u0004\b#\u0010\u000fR\u0019\u0010*\u001a\u0004\u0018\u00010%8\u0006\u00a2\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u0017\u00100\u001a\u00020+8\u0006\u00a2\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u0019\u00106\u001a\u0004\u0018\u0001018\u0006\u00a2\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R\u0019\u0010;\u001a\u0004\u0018\u0001078\u0006\u00a2\u0006\f\n\u0004\b.\u00108\u001a\u0004\b9\u0010:R\u0017\u0010>\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b<\u0010\u001f\u001a\u0004\b=\u0010!R\u0019\u0010B\u001a\u0004\u0018\u00010?8\u0006\u00a2\u0006\f\n\u0004\b9\u0010@\u001a\u0004\b&\u0010AR\u0019\u0010G\u001a\u0004\u0018\u00010C8\u0006\u00a2\u0006\f\n\u0004\bD\u0010E\u001a\u0004\b\u0016\u0010FR\u0019\u0010L\u001a\u0004\u0018\u00010H8\u0006\u00a2\u0006\f\n\u0004\b4\u0010I\u001a\u0004\bJ\u0010KR\u0019\u0010P\u001a\u0004\u0018\u00010M8\u0006\u00a2\u0006\f\n\u0004\b#\u0010N\u001a\u0004\b2\u0010OR\u0019\u0010V\u001a\u0004\u0018\u00010Q8\u0006\u00a2\u0006\f\n\u0004\bR\u0010S\u001a\u0004\bT\u0010UR%\u0010Z\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010W8\u0006\u00a2\u0006\f\n\u0004\bT\u0010X\u001a\u0004\b,\u0010YR\u0017\u0010_\u001a\u00020[8\u0006\u00a2\u0006\f\n\u0004\bJ\u0010\\\u001a\u0004\b]\u0010^R$\u0010c\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b`\u0010\u001b\u001a\u0004\b\u001e\u0010\u001c\"\u0004\ba\u0010bR2\u0010h\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\u0004\u0012\u00020\u00010d8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b=\u0010X\u001a\u0004\be\u0010Y\"\u0004\bf\u0010gR$\u0010n\u001a\u0004\u0018\u00010i8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010j\u001a\u0004\b<\u0010k\"\u0004\bl\u0010mR$\u0010t\u001a\u0004\u0018\u00010o8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010p\u001a\u0004\b\f\u0010q\"\u0004\br\u0010sR$\u0010y\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b]\u0010u\u001a\u0004\bD\u0010v\"\u0004\bw\u0010xR$\u0010|\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010u\u001a\u0004\bz\u0010v\"\u0004\b{\u0010xR$\u0010~\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bz\u0010u\u001a\u0004\b\u0011\u0010v\"\u0004\b}\u0010xR)\u0010\u0084\u0001\u001a\u0004\u0018\u00010\u007f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0016\n\u0005\b\u0003\u0010\u0080\u0001\u001a\u0005\bR\u0010\u0081\u0001\"\u0006\b\u0082\u0001\u0010\u0083\u0001R\u001b\u0010\u0088\u0001\u001a\u00030\u0085\u00018\u0006\u00a2\u0006\u000e\n\u0005\b\u0007\u0010\u0086\u0001\u001a\u0005\b`\u0010\u0087\u0001\u00a8\u0006\u008e\u0001"}, d2 = {"Lcom/tencent/qqnt/http/api/b;", "", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "T", "Ljava/lang/Class;", "type", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Ljava/lang/Class;)Ljava/lang/Object;", "", "toString", "", "a", "I", "u", "()I", com.heytap.mcssdk.a.a.f36094d, "b", "Ljava/lang/String;", HippyTKDListViewAdapter.X, "()Ljava/lang/String;", "url", "c", "getBusinessTag", "businessTag", "Ljava/io/File;", "d", "Ljava/io/File;", "()Ljava/io/File;", "downloadFile", "e", "Z", "f", "()Z", "enableHttp2", "o", "retryCount", "Lcom/tencent/qqnt/http/api/l;", "g", "Lcom/tencent/qqnt/http/api/l;", "v", "()Lcom/tencent/qqnt/http/api/l;", "taskListener", "Lcom/tencent/qqnt/http/api/HTTP_METHOD;", tl.h.F, "Lcom/tencent/qqnt/http/api/HTTP_METHOD;", "j", "()Lcom/tencent/qqnt/http/api/HTTP_METHOD;", "method", "Lcom/tencent/qqnt/http/api/k;", "i", "Lcom/tencent/qqnt/http/api/k;", DomainData.DOMAIN_NAME, "()Lcom/tencent/qqnt/http/api/k;", "requestContent", "Lcom/tencent/qqnt/http/api/j;", "Lcom/tencent/qqnt/http/api/j;", "l", "()Lcom/tencent/qqnt/http/api/j;", "progressListener", "k", "t", "supportCache304", "Lcom/tencent/qqnt/http/api/e;", "Lcom/tencent/qqnt/http/api/e;", "()Lcom/tencent/qqnt/http/api/e;", "eventListener", "Lcom/tencent/qqnt/http/api/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/qqnt/http/api/a;", "()Lcom/tencent/qqnt/http/api/a;", "dnsResolver", "Ljavax/net/ssl/SSLSocketFactory;", "Ljavax/net/ssl/SSLSocketFactory;", "r", "()Ljavax/net/ssl/SSLSocketFactory;", "sslSocketFactory", "Ljavax/net/ssl/HostnameVerifier;", "Ljavax/net/ssl/HostnameVerifier;", "()Ljavax/net/ssl/HostnameVerifier;", "hostnameVerifier", "Ljavax/net/SocketFactory;", "p", "Ljavax/net/SocketFactory;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Ljavax/net/SocketFactory;", "socketFactory", "", "Ljava/util/Map;", "()Ljava/util/Map;", "headers", "", "J", "w", "()J", "timeout", ReportConstant.COSTREPORT_PREFIX, "setDownloadTempFile", "(Ljava/io/File;)V", "downloadTempFile", "", "getTags", "setTags", "(Ljava/util/Map;)V", ComicCancelRedPointPopItemData.JSON_KEY_TAGS, "Ljava/io/OutputStream;", "Ljava/io/OutputStream;", "()Ljava/io/OutputStream;", "setOutputStream", "(Ljava/io/OutputStream;)V", "outputStream", "Lcom/tencent/qqnt/http/api/c;", "Lcom/tencent/qqnt/http/api/c;", "()Lcom/tencent/qqnt/http/api/c;", "setBreakPoint", "(Lcom/tencent/qqnt/http/api/c;)V", "breakPoint", "Ljava/lang/Integer;", "()Ljava/lang/Integer;", "setReadTimeout", "(Ljava/lang/Integer;)V", "readTimeout", "y", "setWriteTimeout", "writeTimeout", "setConnectTimeout", "connectTimeout", "Lcom/tencent/qqnt/http/api/h;", "Lcom/tencent/qqnt/http/api/h;", "()Lcom/tencent/qqnt/http/api/h;", "setRetryStrategy", "(Lcom/tencent/qqnt/http/api/h;)V", "retryStrategy", "Lcom/tencent/qqnt/http/api/n;", "Lcom/tencent/qqnt/http/api/n;", "()Lcom/tencent/qqnt/http/api/n;", "status", "Lcom/tencent/qqnt/http/api/b$a;", "builder", "<init>", "(Lcom/tencent/qqnt/http/api/b$a;)V", "B", "http_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: B, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final AtomicInteger C;

    /* renamed from: A, reason: from kotlin metadata */
    @NotNull
    private final n status;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int taskID;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String url;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String businessTag;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final File downloadFile;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final boolean enableHttp2;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int retryCount;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final l taskListener;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HTTP_METHOD method;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final k requestContent;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final j progressListener;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private final boolean supportCache304;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final e eventListener;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final com.tencent.qqnt.http.api.a dnsResolver;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final SSLSocketFactory sslSocketFactory;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final HostnameVerifier hostnameVerifier;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final SocketFactory socketFactory;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Map<String, String> headers;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    private final long timeout;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private File downloadTempFile;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Map<Class<?>, Object> tags;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private OutputStream outputStream;

    /* renamed from: v, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private c breakPoint;

    /* renamed from: w, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Integer readTimeout;

    /* renamed from: x, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Integer writeTimeout;

    /* renamed from: y, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Integer connectTimeout;

    /* renamed from: z, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private h retryStrategy;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/http/api/b$b;", "", "Ljava/util/concurrent/atomic/AtomicInteger;", "seqFactory", "Ljava/util/concurrent/atomic/AtomicInteger;", "<init>", "()V", "http_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.http.api.b$b, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes24.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42546);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 40)) {
            redirector.redirect((short) 40);
        } else {
            INSTANCE = new Companion(null);
            C = new AtomicInteger(new Random().nextInt(10000));
        }
    }

    public b(@NotNull a builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) builder);
            return;
        }
        this.taskID = C.incrementAndGet();
        this.url = builder.G();
        this.businessTag = builder.k();
        this.downloadFile = builder.n();
        this.enableHttp2 = builder.p();
        this.retryCount = builder.y();
        this.taskListener = builder.E();
        this.method = builder.t();
        this.requestContent = builder.x();
        this.progressListener = builder.v();
        this.supportCache304 = builder.C();
        this.eventListener = builder.q();
        this.dnsResolver = builder.m();
        this.sslSocketFactory = builder.B();
        this.hostnameVerifier = builder.s();
        this.socketFactory = builder.A();
        this.headers = builder.r();
        this.timeout = builder.F();
        this.downloadTempFile = builder.o();
        this.tags = builder.D();
        this.outputStream = builder.u();
        this.breakPoint = builder.j();
        this.readTimeout = builder.w();
        this.writeTimeout = builder.H();
        this.connectTimeout = builder.l();
        this.retryStrategy = builder.z();
        this.status = new n();
    }

    @Nullable
    public final <T> T A(@NotNull Class<? extends T> type) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            return (T) iPatchRedirector.redirect((short) 38, (Object) this, (Object) type);
        }
        Intrinsics.checkNotNullParameter(type, "type");
        return type.cast(this.tags.get(type));
    }

    @Nullable
    public final c a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return (c) iPatchRedirector.redirect((short) 26, (Object) this);
        }
        return this.breakPoint;
    }

    @Nullable
    public final Integer b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return (Integer) iPatchRedirector.redirect((short) 32, (Object) this);
        }
        return this.connectTimeout;
    }

    @Nullable
    public final com.tencent.qqnt.http.api.a c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (com.tencent.qqnt.http.api.a) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return this.dnsResolver;
    }

    @Nullable
    public final File d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (File) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.downloadFile;
    }

    @Nullable
    public final File e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (File) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        return this.downloadTempFile;
    }

    public final boolean f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return this.enableHttp2;
    }

    @Nullable
    public final e g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (e) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.eventListener;
    }

    @Nullable
    public final Map<String, String> h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (Map) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        return this.headers;
    }

    @Nullable
    public final HostnameVerifier i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (HostnameVerifier) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return this.hostnameVerifier;
    }

    @NotNull
    public final HTTP_METHOD j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (HTTP_METHOD) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.method;
    }

    @Nullable
    public final OutputStream k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (OutputStream) iPatchRedirector.redirect((short) 24, (Object) this);
        }
        return this.outputStream;
    }

    @Nullable
    public final j l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (j) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.progressListener;
    }

    @Nullable
    public final Integer m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (Integer) iPatchRedirector.redirect((short) 28, (Object) this);
        }
        return this.readTimeout;
    }

    @Nullable
    public final k n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (k) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.requestContent;
    }

    public final int o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.retryCount;
    }

    @Nullable
    public final h p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return (h) iPatchRedirector.redirect((short) 34, (Object) this);
        }
        return this.retryStrategy;
    }

    @Nullable
    public final SocketFactory q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (SocketFactory) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        return this.socketFactory;
    }

    @Nullable
    public final SSLSocketFactory r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (SSLSocketFactory) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return this.sslSocketFactory;
    }

    @NotNull
    public final n s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            return (n) iPatchRedirector.redirect((short) 36, (Object) this);
        }
        return this.status;
    }

    public final boolean t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        return this.supportCache304;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            return (String) iPatchRedirector.redirect((short) 39, (Object) this);
        }
        return "HttpTask(taskID=" + this.taskID + ", url='" + this.url + "', method=" + this.method + " businessTag='" + this.businessTag + "', retryCount=" + this.retryCount + ", timeout=" + this.timeout + ")";
    }

    public final int u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.taskID;
    }

    @Nullable
    public final l v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (l) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.taskListener;
    }

    public final long w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Long) iPatchRedirector.redirect((short) 19, (Object) this)).longValue();
        }
        return this.timeout;
    }

    @NotNull
    public final String x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.url;
    }

    @Nullable
    public final Integer y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return (Integer) iPatchRedirector.redirect((short) 30, (Object) this);
        }
        return this.writeTimeout;
    }

    public final boolean z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return ((Boolean) iPatchRedirector.redirect((short) 37, (Object) this)).booleanValue();
        }
        return this.status.f().get();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u00b0\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b8\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010%\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010=\u001a\u00020$\u0012\u0006\u0010?\u001a\u00020$\u00a2\u0006\u0006\b\u00ae\u0001\u0010\u00af\u0001B#\b\u0016\u0012\u0006\u0010=\u001a\u00020$\u0012\u0006\u0010?\u001a\u00020$\u0012\u0006\u0010E\u001a\u00020\u0002\u00a2\u0006\u0006\b\u00ae\u0001\u0010\u00b0\u0001J\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000fJ\u000e\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0012J\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\tJ\u000e\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0017J\u000e\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001aJ\u000e\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u001dJ\u000e\u0010\"\u001a\u00020\u00002\u0006\u0010!\u001a\u00020 J\u001a\u0010&\u001a\u00020\u00002\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020$0#J\u000e\u0010)\u001a\u00020\u00002\u0006\u0010(\u001a\u00020'J\u000e\u0010,\u001a\u00020\u00002\u0006\u0010+\u001a\u00020*J\u000e\u0010.\u001a\u00020\u00002\u0006\u0010-\u001a\u00020\u0002J-\u00102\u001a\u00020\u0000\"\u0004\b\u0000\u0010\u000e2\u000e\u00100\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000/2\b\u00101\u001a\u0004\u0018\u00018\u0000\u00a2\u0006\u0004\b2\u00103J\u000e\u00105\u001a\u00020\u00002\u0006\u00104\u001a\u00020'J\u000e\u00107\u001a\u00020\u00002\u0006\u00106\u001a\u00020'J\u0006\u00109\u001a\u000208R\u0017\u0010=\u001a\u00020$8\u0006\u00a2\u0006\f\n\u0004\b&\u0010:\u001a\u0004\b;\u0010<R\u0017\u0010?\u001a\u00020$8\u0006\u00a2\u0006\f\n\u0004\b\"\u0010:\u001a\u0004\b>\u0010<R$\u0010E\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b9\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b5\u0010F\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010K\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR\"\u0010(\u001a\u00020'8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\u0011\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\"\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b.\u0010T\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR$\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010Y\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R$\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010^\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR\"\u0010\u0015\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bc\u0010F\u001a\u0004\bd\u0010H\"\u0004\be\u0010JR$\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b;\u0010f\u001a\u0004\bg\u0010h\"\u0004\bi\u0010jR$\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bk\u0010l\u001a\u0004\bm\u0010n\"\u0004\bo\u0010pR$\u0010w\u001a\u0004\u0018\u00010q8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bm\u0010r\u001a\u0004\bs\u0010t\"\u0004\bu\u0010vR$\u0010~\u001a\u0004\u0018\u00010x8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bA\u0010y\u001a\u0004\bz\u0010{\"\u0004\b|\u0010}R+\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u007f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u0080\u0001\u0010\u0081\u0001\u001a\u0006\b\u0082\u0001\u0010\u0083\u0001\"\u0006\b\u0084\u0001\u0010\u0085\u0001R5\u0010%\u001a\u0010\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020$\u0018\u00010#8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0005\bG\u0010\u0087\u0001\u001a\u0006\b\u0088\u0001\u0010\u0089\u0001\"\u0006\b\u008a\u0001\u0010\u008b\u0001R&\u0010+\u001a\u00020*8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0016\n\u0004\bg\u0010\b\u001a\u0006\b\u008c\u0001\u0010\u008d\u0001\"\u0006\b\u008e\u0001\u0010\u008f\u0001R'\u0010-\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0015\n\u0005\b\u0088\u0001\u0010@\u001a\u0005\b\u0080\u0001\u0010B\"\u0005\b\u0090\u0001\u0010DR9\u0010\u0094\u0001\u001a\u0013\u0012\b\u0012\u0006\u0012\u0002\b\u00030/\u0012\u0004\u0012\u00020\u00010\u0091\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0005\bz\u0010\u0087\u0001\u001a\u0006\b\u0092\u0001\u0010\u0089\u0001\"\u0006\b\u0093\u0001\u0010\u008b\u0001R)\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0005\bU\u0010\u0095\u0001\u001a\u0006\b\u0096\u0001\u0010\u0097\u0001\"\u0006\b\u0098\u0001\u0010\u0099\u0001R)\u0010!\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0006\b\u0096\u0001\u0010\u009a\u0001\u001a\u0005\bc\u0010\u009b\u0001\"\u0006\b\u009c\u0001\u0010\u009d\u0001R(\u00104\u001a\u0004\u0018\u00010'8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0016\n\u0005\b_\u0010\u009e\u0001\u001a\u0005\bk\u0010\u009f\u0001\"\u0006\b\u00a0\u0001\u0010\u00a1\u0001R*\u00106\u001a\u0004\u0018\u00010'8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00a2\u0001\u0010\u009e\u0001\u001a\u0006\b\u00a2\u0001\u0010\u009f\u0001\"\u0006\b\u00a3\u0001\u0010\u00a1\u0001R*\u0010\u00a6\u0001\u001a\u0004\u0018\u00010'8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0005\bZ\u0010\u009e\u0001\u001a\u0006\b\u00a4\u0001\u0010\u009f\u0001\"\u0006\b\u00a5\u0001\u0010\u00a1\u0001R+\u0010\u00ad\u0001\u001a\u0005\u0018\u00010\u00a7\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0005\bP\u0010\u00a8\u0001\u001a\u0006\b\u00a9\u0001\u0010\u00aa\u0001\"\u0006\b\u00ab\u0001\u0010\u00ac\u0001\u00a8\u0006\u00b1\u0001"}, d2 = {"Lcom/tencent/qqnt/http/api/b$a;", "", "Ljava/io/File;", "downloadPath", "f", "Ljava/io/OutputStream;", "outputStream", "", "J", "", "enableHttp2", tl.h.F, "Lcom/tencent/qqnt/http/api/l;", "taskListener", "T", "Lcom/tencent/qqnt/http/api/HTTP_METHOD;", "method", "I", "Lcom/tencent/qqnt/http/api/k;", "requestContent", "M", "supportCache304", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/qqnt/http/api/j;", "progressListener", "K", "Lcom/tencent/qqnt/http/api/e;", "eventListener", "i", "Lcom/tencent/qqnt/http/api/a;", "dnsResolver", "e", "Lcom/tencent/qqnt/http/api/c;", "breakPoint", "b", "", "", "headers", "a", "", "retryCount", "N", "", "timeout", "U", "downloadTempFile", "g", "Ljava/lang/Class;", "type", "tag", ExifInterface.LATITUDE_SOUTH, "(Ljava/lang/Class;Ljava/lang/Object;)Lcom/tencent/qqnt/http/api/b$a;", "connectTimeout", "d", "readTimeout", "L", "Lcom/tencent/qqnt/http/api/b;", "c", "Ljava/lang/String;", "k", "()Ljava/lang/String;", "businessTag", "G", "url", "Ljava/io/File;", DomainData.DOMAIN_NAME, "()Ljava/io/File;", "setDownloadFile", "(Ljava/io/File;)V", "downloadFile", "Z", "p", "()Z", "setEnableHttp2", "(Z)V", "Lcom/tencent/qqnt/http/api/l;", "E", "()Lcom/tencent/qqnt/http/api/l;", "P", "(Lcom/tencent/qqnt/http/api/l;)V", "y", "()I", "setRetryCount", "(I)V", "Lcom/tencent/qqnt/http/api/HTTP_METHOD;", "t", "()Lcom/tencent/qqnt/http/api/HTTP_METHOD;", "setMethod", "(Lcom/tencent/qqnt/http/api/HTTP_METHOD;)V", "Lcom/tencent/qqnt/http/api/k;", HippyTKDListViewAdapter.X, "()Lcom/tencent/qqnt/http/api/k;", "setRequestContent", "(Lcom/tencent/qqnt/http/api/k;)V", "Lcom/tencent/qqnt/http/api/j;", "v", "()Lcom/tencent/qqnt/http/api/j;", "O", "(Lcom/tencent/qqnt/http/api/j;)V", "j", BdhLogUtil.LogTag.Tag_Conn, "setSupportCache304", "Lcom/tencent/qqnt/http/api/e;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Lcom/tencent/qqnt/http/api/e;", "setEventListener", "(Lcom/tencent/qqnt/http/api/e;)V", "l", "Lcom/tencent/qqnt/http/api/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Lcom/tencent/qqnt/http/api/a;", "setDnsResolver", "(Lcom/tencent/qqnt/http/api/a;)V", "Ljavax/net/ssl/SSLSocketFactory;", "Ljavax/net/ssl/SSLSocketFactory;", "B", "()Ljavax/net/ssl/SSLSocketFactory;", "setSslSocketFactory", "(Ljavax/net/ssl/SSLSocketFactory;)V", "sslSocketFactory", "Ljavax/net/ssl/HostnameVerifier;", "Ljavax/net/ssl/HostnameVerifier;", ReportConstant.COSTREPORT_PREFIX, "()Ljavax/net/ssl/HostnameVerifier;", "setHostnameVerifier", "(Ljavax/net/ssl/HostnameVerifier;)V", "hostnameVerifier", "Ljavax/net/SocketFactory;", "o", "Ljavax/net/SocketFactory;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "()Ljavax/net/SocketFactory;", "setSocketFactory", "(Ljavax/net/SocketFactory;)V", "socketFactory", "Ljava/util/Map;", "r", "()Ljava/util/Map;", V2TXLiveProperty.kV2SetHeaders, "(Ljava/util/Map;)V", UserInfo.SEX_FEMALE, "()J", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "(J)V", "setDownloadTempFile", "", "D", "setTags", ComicCancelRedPointPopItemData.JSON_KEY_TAGS, "Ljava/io/OutputStream;", "u", "()Ljava/io/OutputStream;", "setOutputStream", "(Ljava/io/OutputStream;)V", "Lcom/tencent/qqnt/http/api/c;", "()Lcom/tencent/qqnt/http/api/c;", "setBreakPoint", "(Lcom/tencent/qqnt/http/api/c;)V", "Ljava/lang/Integer;", "()Ljava/lang/Integer;", "setConnectTimeout", "(Ljava/lang/Integer;)V", "w", "setReadTimeout", "H", "setWriteTimeout", "writeTimeout", "Lcom/tencent/qqnt/http/api/h;", "Lcom/tencent/qqnt/http/api/h;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "()Lcom/tencent/qqnt/http/api/h;", "setRetryStrategy", "(Lcom/tencent/qqnt/http/api/h;)V", "retryStrategy", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/io/File;)V", "http_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String businessTag;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String url;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private File downloadFile;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private boolean enableHttp2;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private l taskListener;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private int retryCount;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private HTTP_METHOD method;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private k requestContent;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private j progressListener;

        /* renamed from: j, reason: collision with root package name and from kotlin metadata */
        private boolean supportCache304;

        /* renamed from: k, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private e eventListener;

        /* renamed from: l, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private com.tencent.qqnt.http.api.a dnsResolver;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private SSLSocketFactory sslSocketFactory;

        /* renamed from: n, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private HostnameVerifier hostnameVerifier;

        /* renamed from: o, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private SocketFactory socketFactory;

        /* renamed from: p, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private Map<String, String> headers;

        /* renamed from: q, reason: collision with root package name and from kotlin metadata */
        private long timeout;

        /* renamed from: r, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private File downloadTempFile;

        /* renamed from: s, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private Map<Class<?>, Object> tags;

        /* renamed from: t, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private OutputStream outputStream;

        /* renamed from: u, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private c breakPoint;

        /* renamed from: v, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private Integer connectTimeout;

        /* renamed from: w, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private Integer readTimeout;

        /* renamed from: x, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private Integer writeTimeout;

        /* renamed from: y, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private h retryStrategy;

        public a(@NotNull String businessTag, @NotNull String url) {
            Intrinsics.checkNotNullParameter(businessTag, "businessTag");
            Intrinsics.checkNotNullParameter(url, "url");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) businessTag, (Object) url);
                return;
            }
            this.businessTag = businessTag;
            this.url = url;
            this.retryCount = 1;
            this.method = HTTP_METHOD.GET;
            this.timeout = 60000L;
            this.tags = new LinkedHashMap();
        }

        @Nullable
        public final SocketFactory A() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
                return (SocketFactory) iPatchRedirector.redirect((short) 31, (Object) this);
            }
            return this.socketFactory;
        }

        @Nullable
        public final SSLSocketFactory B() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
                return (SSLSocketFactory) iPatchRedirector.redirect((short) 27, (Object) this);
            }
            return this.sslSocketFactory;
        }

        public final boolean C() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
                return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this)).booleanValue();
            }
            return this.supportCache304;
        }

        @NotNull
        public final Map<Class<?>, Object> D() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
                return (Map) iPatchRedirector.redirect((short) 39, (Object) this);
            }
            return this.tags;
        }

        @Nullable
        public final l E() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (l) iPatchRedirector.redirect((short) 9, (Object) this);
            }
            return this.taskListener;
        }

        public final long F() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
                return ((Long) iPatchRedirector.redirect((short) 35, (Object) this)).longValue();
            }
            return this.timeout;
        }

        @NotNull
        public final String G() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.url;
        }

        @Nullable
        public final Integer H() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
                return (Integer) iPatchRedirector.redirect((short) 49, (Object) this);
            }
            return this.writeTimeout;
        }

        public final void I(@NotNull HTTP_METHOD method) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 57)) {
                iPatchRedirector.redirect((short) 57, (Object) this, (Object) method);
            } else {
                Intrinsics.checkNotNullParameter(method, "method");
                this.method = method;
            }
        }

        public final void J(@NotNull OutputStream outputStream) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 54)) {
                iPatchRedirector.redirect((short) 54, (Object) this, (Object) outputStream);
            } else {
                Intrinsics.checkNotNullParameter(outputStream, "outputStream");
                this.outputStream = outputStream;
            }
        }

        @NotNull
        public final a K(@NotNull j progressListener) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 60)) {
                return (a) iPatchRedirector.redirect((short) 60, (Object) this, (Object) progressListener);
            }
            Intrinsics.checkNotNullParameter(progressListener, "progressListener");
            this.progressListener = progressListener;
            return this;
        }

        @NotNull
        public final a L(int readTimeout) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 73)) {
                return (a) iPatchRedirector.redirect((short) 73, (Object) this, readTimeout);
            }
            this.readTimeout = Integer.valueOf(readTimeout);
            return this;
        }

        @NotNull
        public final a M(@NotNull k requestContent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 58)) {
                return (a) iPatchRedirector.redirect((short) 58, (Object) this, (Object) requestContent);
            }
            Intrinsics.checkNotNullParameter(requestContent, "requestContent");
            this.requestContent = requestContent;
            return this;
        }

        @NotNull
        public final a N(int retryCount) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 68)) {
                return (a) iPatchRedirector.redirect((short) 68, (Object) this, retryCount);
            }
            this.retryCount = retryCount;
            return this;
        }

        public final void O(@Nullable j jVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
                iPatchRedirector.redirect((short) 18, (Object) this, (Object) jVar);
            } else {
                this.progressListener = jVar;
            }
        }

        public final void P(@Nullable l lVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                iPatchRedirector.redirect((short) 10, (Object) this, (Object) lVar);
            } else {
                this.taskListener = lVar;
            }
        }

        public final void Q(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
                iPatchRedirector.redirect((short) 36, (Object) this, j3);
            } else {
                this.timeout = j3;
            }
        }

        @NotNull
        public final a R(boolean supportCache304) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 59)) {
                return (a) iPatchRedirector.redirect((short) 59, (Object) this, supportCache304);
            }
            this.supportCache304 = supportCache304;
            return this;
        }

        @NotNull
        public final <T> a S(@NotNull Class<? super T> type, @Nullable T tag) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 71)) {
                return (a) iPatchRedirector.redirect((short) 71, (Object) this, (Object) type, (Object) tag);
            }
            Intrinsics.checkNotNullParameter(type, "type");
            if (tag == null) {
                this.tags.remove(type);
            } else {
                if (this.tags.isEmpty()) {
                    this.tags = new LinkedHashMap();
                }
                Map<Class<?>, Object> map = this.tags;
                T cast = type.cast(tag);
                Intrinsics.checkNotNull(cast);
                map.put(type, cast);
            }
            return this;
        }

        @NotNull
        public final a T(@NotNull l taskListener) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 56)) {
                return (a) iPatchRedirector.redirect((short) 56, (Object) this, (Object) taskListener);
            }
            Intrinsics.checkNotNullParameter(taskListener, "taskListener");
            this.taskListener = taskListener;
            return this;
        }

        @NotNull
        public final a U(long timeout) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 69)) {
                return (a) iPatchRedirector.redirect((short) 69, (Object) this, timeout);
            }
            this.timeout = timeout;
            return this;
        }

        @NotNull
        public final a a(@NotNull Map<String, String> headers) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 67)) {
                return (a) iPatchRedirector.redirect((short) 67, (Object) this, (Object) headers);
            }
            Intrinsics.checkNotNullParameter(headers, "headers");
            this.headers = headers;
            return this;
        }

        @NotNull
        public final a b(@NotNull c breakPoint) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 66)) {
                return (a) iPatchRedirector.redirect((short) 66, (Object) this, (Object) breakPoint);
            }
            Intrinsics.checkNotNullParameter(breakPoint, "breakPoint");
            this.breakPoint = breakPoint;
            return this;
        }

        @NotNull
        public final b c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 76)) {
                return (b) iPatchRedirector.redirect((short) 76, (Object) this);
            }
            return new b(this);
        }

        @NotNull
        public final a d(int connectTimeout) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 72)) {
                return (a) iPatchRedirector.redirect((short) 72, (Object) this, connectTimeout);
            }
            this.connectTimeout = Integer.valueOf(connectTimeout);
            return this;
        }

        @NotNull
        public final a e(@NotNull com.tencent.qqnt.http.api.a dnsResolver) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 62)) {
                return (a) iPatchRedirector.redirect((short) 62, (Object) this, (Object) dnsResolver);
            }
            Intrinsics.checkNotNullParameter(dnsResolver, "dnsResolver");
            this.dnsResolver = dnsResolver;
            return this;
        }

        @NotNull
        public final a f(@NotNull File downloadPath) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 53)) {
                return (a) iPatchRedirector.redirect((short) 53, (Object) this, (Object) downloadPath);
            }
            Intrinsics.checkNotNullParameter(downloadPath, "downloadPath");
            this.downloadFile = downloadPath;
            return this;
        }

        @NotNull
        public final a g(@NotNull File downloadTempFile) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 70)) {
                return (a) iPatchRedirector.redirect((short) 70, (Object) this, (Object) downloadTempFile);
            }
            Intrinsics.checkNotNullParameter(downloadTempFile, "downloadTempFile");
            this.downloadTempFile = downloadTempFile;
            return this;
        }

        @NotNull
        public final a h(boolean enableHttp2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 55)) {
                return (a) iPatchRedirector.redirect((short) 55, (Object) this, enableHttp2);
            }
            this.enableHttp2 = enableHttp2;
            return this;
        }

        @NotNull
        public final a i(@NotNull e eventListener) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 61)) {
                return (a) iPatchRedirector.redirect((short) 61, (Object) this, (Object) eventListener);
            }
            Intrinsics.checkNotNullParameter(eventListener, "eventListener");
            this.eventListener = eventListener;
            return this;
        }

        @Nullable
        public final c j() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
                return (c) iPatchRedirector.redirect((short) 43, (Object) this);
            }
            return this.breakPoint;
        }

        @NotNull
        public final String k() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.businessTag;
        }

        @Nullable
        public final Integer l() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
                return (Integer) iPatchRedirector.redirect((short) 45, (Object) this);
            }
            return this.connectTimeout;
        }

        @Nullable
        public final com.tencent.qqnt.http.api.a m() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
                return (com.tencent.qqnt.http.api.a) iPatchRedirector.redirect((short) 25, (Object) this);
            }
            return this.dnsResolver;
        }

        @Nullable
        public final File n() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (File) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return this.downloadFile;
        }

        @Nullable
        public final File o() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
                return (File) iPatchRedirector.redirect((short) 37, (Object) this);
            }
            return this.downloadTempFile;
        }

        public final boolean p() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
            }
            return this.enableHttp2;
        }

        @Nullable
        public final e q() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
                return (e) iPatchRedirector.redirect((short) 21, (Object) this);
            }
            return this.eventListener;
        }

        @Nullable
        public final Map<String, String> r() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
                return (Map) iPatchRedirector.redirect((short) 33, (Object) this);
            }
            return this.headers;
        }

        @Nullable
        public final HostnameVerifier s() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
                return (HostnameVerifier) iPatchRedirector.redirect((short) 29, (Object) this);
            }
            return this.hostnameVerifier;
        }

        @NotNull
        public final HTTP_METHOD t() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                return (HTTP_METHOD) iPatchRedirector.redirect((short) 13, (Object) this);
            }
            return this.method;
        }

        @Nullable
        public final OutputStream u() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
                return (OutputStream) iPatchRedirector.redirect((short) 41, (Object) this);
            }
            return this.outputStream;
        }

        @Nullable
        public final j v() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
                return (j) iPatchRedirector.redirect((short) 17, (Object) this);
            }
            return this.progressListener;
        }

        @Nullable
        public final Integer w() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
                return (Integer) iPatchRedirector.redirect((short) 47, (Object) this);
            }
            return this.readTimeout;
        }

        @Nullable
        public final k x() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                return (k) iPatchRedirector.redirect((short) 15, (Object) this);
            }
            return this.requestContent;
        }

        public final int y() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
            }
            return this.retryCount;
        }

        @Nullable
        public final h z() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
                return (h) iPatchRedirector.redirect((short) 51, (Object) this);
            }
            return this.retryStrategy;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public a(@NotNull String businessTag, @NotNull String url, @NotNull File downloadFile) {
            this(businessTag, url);
            Intrinsics.checkNotNullParameter(businessTag, "businessTag");
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(downloadFile, "downloadFile");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                f(downloadFile);
            } else {
                iPatchRedirector.redirect((short) 4, this, businessTag, url, downloadFile);
            }
        }
    }
}
