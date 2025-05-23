package nx4;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0001\u0012J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J$\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH&J \u0010\u0011\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0016\u00a8\u0006\u0013"}, d2 = {"Lnx4/a;", "", "", HiAnalyticsConstant.HaKey.BI_KEY_RESULT, "", "errorMsg", "", "onDownloadFailed", "filePath", "Lnx4/a$b;", "result", "a", "", "progress", "", "totalBytesWritten", "totalBytesExpectedToWrite", "onDownloadProgress", "b", "common_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public interface a {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\t\n\u0002\bI\u0018\u00002\u00020\u0001Bu\u0012\b\u0010A\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010E\u001a\u0004\u0018\u00010\n\u0012\b\u0010I\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010M\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010O\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010T\u001a\u0004\u0018\u00010\"\u0012\b\u0010X\u001a\u0004\u0018\u00010\"\u0012\b\u0010\\\u001a\u0004\u0018\u00010\"\u0012\b\u0010`\u001a\u0004\u0018\u00010\"\u0012\b\u0010d\u001a\u0004\u0018\u00010\"\u0012\b\u0010h\u001a\u0004\u0018\u00010\"\u00a2\u0006\u0004\bi\u0010jR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\u0011\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0019\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u001b\u0010\u0006\"\u0004\b\u001c\u0010\bR$\u0010!\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u0014\u001a\u0004\b\u001f\u0010\u0016\"\u0004\b \u0010\u0018R$\u0010)\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R$\u0010-\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b*\u0010$\u001a\u0004\b+\u0010&\"\u0004\b,\u0010(R$\u00101\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b.\u0010$\u001a\u0004\b/\u0010&\"\u0004\b0\u0010(R$\u00105\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b2\u0010$\u001a\u0004\b3\u0010&\"\u0004\b4\u0010(R$\u00109\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b6\u0010$\u001a\u0004\b7\u0010&\"\u0004\b8\u0010(R$\u0010=\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b:\u0010$\u001a\u0004\b;\u0010&\"\u0004\b<\u0010(R$\u0010A\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b>\u0010\u0004\u001a\u0004\b?\u0010\u0006\"\u0004\b@\u0010\bR$\u0010E\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bB\u0010\f\u001a\u0004\bC\u0010\u000e\"\u0004\bD\u0010\u0010R$\u0010I\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bF\u0010\u0014\u001a\u0004\bG\u0010\u0016\"\u0004\bH\u0010\u0018R$\u0010M\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bJ\u0010\u0004\u001a\u0004\bK\u0010\u0006\"\u0004\bL\u0010\bR$\u0010O\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bN\u0010\u0014\u001a\u0004\bO\u0010\u0016\"\u0004\bP\u0010\u0018R$\u0010T\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bQ\u0010$\u001a\u0004\bR\u0010&\"\u0004\bS\u0010(R$\u0010X\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bU\u0010$\u001a\u0004\bV\u0010&\"\u0004\bW\u0010(R$\u0010\\\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bY\u0010$\u001a\u0004\bZ\u0010&\"\u0004\b[\u0010(R$\u0010`\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b]\u0010$\u001a\u0004\b^\u0010&\"\u0004\b_\u0010(R$\u0010d\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\ba\u0010$\u001a\u0004\bb\u0010&\"\u0004\bc\u0010(R$\u0010h\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\be\u0010$\u001a\u0004\bf\u0010&\"\u0004\bg\u0010(\u00a8\u0006k"}, d2 = {"Lnx4/a$b;", "", "", "a", "Ljava/lang/String;", "getMUrl", "()Ljava/lang/String;", "setMUrl", "(Ljava/lang/String;)V", "mUrl", "", "b", "Ljava/lang/Integer;", "getMHttpStatusCode", "()Ljava/lang/Integer;", "setMHttpStatusCode", "(Ljava/lang/Integer;)V", "mHttpStatusCode", "", "c", "Ljava/lang/Boolean;", "getMSuccess", "()Ljava/lang/Boolean;", "setMSuccess", "(Ljava/lang/Boolean;)V", "mSuccess", "d", "getMMessage", "setMMessage", "mMessage", "e", "getMIsFromReusedConnection", "setMIsFromReusedConnection", "mIsFromReusedConnection", "", "f", "Ljava/lang/Long;", "getMQueueTimeMs", "()Ljava/lang/Long;", "setMQueueTimeMs", "(Ljava/lang/Long;)V", "mQueueTimeMs", "g", "getMDnsTimeMs", "setMDnsTimeMs", "mDnsTimeMs", h.F, "getMConnectionTimeMs", "setMConnectionTimeMs", "mConnectionTimeMs", "i", "getMReceiveTimeMs", "setMReceiveTimeMs", "mReceiveTimeMs", "j", "getMTotalTimeMs", "setMTotalTimeMs", "mTotalTimeMs", "k", "getMContentLength", "setMContentLength", "mContentLength", "l", "getUrl", "setUrl", "url", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "getHttpStatusCode", "setHttpStatusCode", "httpStatusCode", DomainData.DOMAIN_NAME, "getSuccess", "setSuccess", "success", "o", "getMessage", "setMessage", "message", "p", "isFromReusedConnection", "setFromReusedConnection", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "getQueueTimeMs", "setQueueTimeMs", "queueTimeMs", "r", "getDnsTimeMs", "setDnsTimeMs", "dnsTimeMs", ReportConstant.COSTREPORT_PREFIX, "getConnectionTimeMs", "setConnectionTimeMs", "connectionTimeMs", "t", "getReceiveTimeMs", "setReceiveTimeMs", "receiveTimeMs", "u", "getTotalTimeMs", "setTotalTimeMs", "totalTimeMs", "v", "getContentLength", "setContentLength", "contentLength", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;)V", "common_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private String mUrl;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private Integer mHttpStatusCode;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private Boolean mSuccess;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private String mMessage;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private Boolean mIsFromReusedConnection;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private Long mQueueTimeMs;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private Long mDnsTimeMs;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private Long mConnectionTimeMs;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private Long mReceiveTimeMs;

        /* renamed from: j, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private Long mTotalTimeMs;

        /* renamed from: k, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private Long mContentLength;

        /* renamed from: l, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private String url;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private Integer httpStatusCode;

        /* renamed from: n, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private Boolean success;

        /* renamed from: o, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private String message;

        /* renamed from: p, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private Boolean isFromReusedConnection;

        /* renamed from: q, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private Long queueTimeMs;

        /* renamed from: r, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private Long dnsTimeMs;

        /* renamed from: s, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private Long connectionTimeMs;

        /* renamed from: t, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private Long receiveTimeMs;

        /* renamed from: u, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private Long totalTimeMs;

        /* renamed from: v, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private Long contentLength;

        public b(@Nullable String str, @Nullable Integer num, @Nullable Boolean bool, @Nullable String str2, @Nullable Boolean bool2, @Nullable Long l3, @Nullable Long l16, @Nullable Long l17, @Nullable Long l18, @Nullable Long l19, @Nullable Long l26) {
            this.url = str;
            this.httpStatusCode = num;
            this.success = bool;
            this.message = str2;
            this.isFromReusedConnection = bool2;
            this.queueTimeMs = l3;
            this.dnsTimeMs = l16;
            this.connectionTimeMs = l17;
            this.receiveTimeMs = l18;
            this.totalTimeMs = l19;
            this.contentLength = l26;
            this.mUrl = str;
            this.mHttpStatusCode = num;
            this.mSuccess = bool;
            this.mMessage = str2;
            this.mIsFromReusedConnection = bool2;
            this.mQueueTimeMs = l3;
            this.mDnsTimeMs = l16;
            this.mConnectionTimeMs = l17;
            this.mReceiveTimeMs = l18;
            this.mTotalTimeMs = l19;
            this.mContentLength = l26;
        }
    }

    void a(int statusCode, @Nullable String filePath, @Nullable b result);

    void onDownloadFailed(int statusCode, @Nullable String errorMsg);

    void onDownloadProgress(float progress, long totalBytesWritten, long totalBytesExpectedToWrite);

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    /* renamed from: nx4.a$a, reason: collision with other inner class name */
    /* loaded from: classes27.dex */
    public static final class C10870a {
        public static void a(@NotNull a aVar, float f16, long j3, long j16) {
        }
    }
}
